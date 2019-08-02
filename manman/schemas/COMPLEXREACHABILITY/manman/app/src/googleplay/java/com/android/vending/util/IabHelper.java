/* Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.vending.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;

import com.android.vending.billing.IInAppBillingService;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


/**
 * Provides convenience methods for in-app billing. You can create one instance of this
 * class for your application and use it to process in-app billing operations.
 * It provides synchronous (blocking) and asynchronous (non-blocking) methods for
 * many common in-app billing operations, as well as automatic signature
 * verification.
 *
 * After instantiating, you must perform setup in order to start using the object.
 * To perform setup, call the {@link #startSetup} method and provide a listener;
 * that listener will be notified when setup is complete, after which (and not before)
 * you may call other methods.
 *
 * After setup is complete, you will typically want to request an inventory of owned
 * items and subscriptions. See {@link #queryInventory}, {@link #queryInventoryAsync}
 * and related methods.
 *
 * When you are done with this object, don't forget to call {@link #dispose}
 * to ensure proper cleanup. This object holds a binding to the in-app billing
 * service, which will leak unless you dispose of it correctly. If you created
 * the object on an Activity's onCreate method, then the recommended
 * place to dispose of it is the Activity's onDestroy method.
 *
 * A note about threading: When using this object from a background thread, you may
 * call the blocking versions of methods; when using from a UI thread, call
 * only the asynchronous versions and handle the results via callbacks.
 * Also, notice that you can only call one asynchronous operation at a time;
 * attempting to start a second asynchronous operation while the first one
 * has not yet completed will result in an exception being thrown.
 *
 * @author Bruno Oliveira (Google)
 *
 */
public class IabHelper {
    // Is debug logging enabled?
    boolean mDebugLog = false;
    String mDebugTag = "IabHelper";

    // Is setup done?
    boolean mSetupDone = false;

    // Has this object been disposed of? (If so, we should ignore callbacks, etc)
    boolean mDisposed = false;

    // Are subscriptions supported?
    boolean mSubscriptionsSupported = false;

    // Is an asynchronous operation in progress?
    // (only one at a time can be in progress)
    boolean mAsyncInProgress = false;

    // (for logging/debugging)
    // if mAsyncInProgress == true, what asynchronous operation is in progress?
    String mAsyncOperation = "";

    // Context we were passed during initialization
    Context mContext;

    // Connection to the service
    IInAppBillingService mService;
    ServiceConnection mServiceConn;

    // The request code used to launch purchase flow
    int mRequestCode;

    // The item type of the current purchase flow
    String mPurchasingItemType;

    // Public key for verifying signature, in base64 encoding
    String mSignatureBase64 = null;

    // Billing response codes
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
    public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
    public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
    public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
    public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;

    // IAB Helper error codes
    public static final int IABHELPER_ERROR_BASE = -1000;
    public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
    public static final int IABHELPER_BAD_RESPONSE = -1002;
    public static final int IABHELPER_VERIFICATION_FAILED = -1003;
    public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
    public static final int IABHELPER_USER_CANCELLED = -1005;
    public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
    public static final int IABHELPER_MISSING_TOKEN = -1007;
    public static final int IABHELPER_UNKNOWN_ERROR = -1008;
    public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
    public static final int IABHELPER_INVALID_CONSUMPTION = -1010;

    // Keys for the responses from InAppBillingService
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
    public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";

    // Item types
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String ITEM_TYPE_SUBS = "subs";

    // some fields on the getSkuDetails response bundle
    public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";

    /**
     * Creates an instance. After creation, it will not yet be ready to use. You must perform
     * setup by calling {@link #startSetup} and wait for setup to complete. This constructor does not
     * block and is safe to call from a UI thread.
     *
     * @param ctx Your application or Activity context. Needed to bind to the in-app billing service.
     * @param base64PublicKey Your application's public key, encoded in base64.
     *     This is used for verification of purchase signatures. You can find your app's base64-encoded
     *     public key in your application's page on Google Play Developer Console. Note that this
     *     is NOT your "developer public key".
     */
    public IabHelper(Context ctx, String base64PublicKey) {
        String dataLeAk710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer710 = new StringBuffer();for (char chAr710 : dataLeAk710.toCharArray()) {leakBuFFer710.append(chAr710);}String dataLeAkPath710 = leakBuFFer710.toString();
		android.util.Log.d("leak-710", dataLeAkPath710);
		mContext = ctx.getApplicationContext();
        mSignatureBase64 = base64PublicKey;
        logDebug("IAB helper created.");
    }

    /**
     * Enables or disable debug logging through LogCat.
     */
    public void enableDebugLogging(boolean enable, String tag) {
        String dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath711;try {throw new Exception(dataLeAk711);} catch (Exception leakErRor711) {dataLeAkPath711 = leakErRor711.getMessage();}
		android.util.Log.d("leak-711", dataLeAkPath711);
		checkNotDisposed();
        mDebugLog = enable;
        mDebugTag = tag;
    }

    public void enableDebugLogging(boolean enable) {
        String dataLeAk712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay712 = new String[] {"n/a", dataLeAk712};
		String dataLeAkPath712 = leakArRay712[leakArRay712.length - 1];
		android.util.Log.d("leak-712", dataLeAkPath712);
		checkNotDisposed();
        mDebugLog = enable;
    }

    /**
     * Callback for setup process. This listener's {@link #onIabSetupFinished} method is called
     * when the setup process is complete.
     */
    public interface OnIabSetupFinishedListener {
        /**
         * Called to notify that setup is complete.
         *
         * @param result The result of the setup process.
         */
        public void onIabSetupFinished(IabResult result);
    }

    /**
     * Starts the setup process. This will start up the setup process asynchronously.
     * You will be notified through the listener when the setup process is complete.
     * This method is safe to call from a UI thread.
     *
     * @param listener The listener to notify when the setup process is complete.
     */
    public void startSetup(final OnIabSetupFinishedListener listener) {
        String dataLeAk713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP713 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP713.put("test", new java.util.HashMap<String, String>());
		leakMaP713.get("test").put("test", dataLeAk713);
		String dataLeAkPath713 = leakMaP713.get("test").get("test");
		android.util.Log.d("leak-713", dataLeAkPath713);
		// If already set up, can't do it again.
        checkNotDisposed();
        if (mSetupDone) throw new IllegalStateException("IAB helper is already set up.");

        // Connection to IAB service
        logDebug("Starting in-app billing setup.");
        mServiceConn = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {
                String dataLeAk714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer714 = new StringBuffer();for (char chAr714 : dataLeAk714.toCharArray()) {leakBuFFer714.append(chAr714);}String dataLeAkPath714 = leakBuFFer714.toString();
				android.util.Log.d("leak-714", dataLeAkPath714);
				logDebug("Billing service disconnected.");
                mService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                String dataLeAk715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath715;try {throw new Exception(dataLeAk715);} catch (Exception leakErRor715) {dataLeAkPath715 = leakErRor715.getMessage();}
				android.util.Log.d("leak-715", dataLeAkPath715);
				if (mDisposed) return;
                logDebug("Billing service connected.");
                mService = IInAppBillingService.Stub.asInterface(service);
                String packageName = mContext.getPackageName();
                try {
                    String dataLeAk716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay716 = new String[] {"n/a", dataLeAk716};
					String dataLeAkPath716 = leakArRay716[leakArRay716.length - 1];
					android.util.Log.d("leak-716", dataLeAkPath716);
					logDebug("Checking for in-app billing 3 support.");

                    // check for in-app billing v3 support
                    int response = mService.isBillingSupported(3, packageName, ITEM_TYPE_INAPP);
                    if (response != BILLING_RESPONSE_RESULT_OK) {
                        String dataLeAk717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP717 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP717.put("test", new java.util.HashMap<String, String>());
						leakMaP717.get("test").put("test", dataLeAk717);
						String dataLeAkPath717 = leakMaP717.get("test").get("test");
						android.util.Log.d("leak-717", dataLeAkPath717);
						if (listener != null) listener.onIabSetupFinished(new IabResult(response,
                                "Error checking for billing v3 support."));

                        // if in-app purchases aren't supported, neither are subscriptions.
                        mSubscriptionsSupported = false;
                        return;
                    }
                    logDebug("In-app billing version 3 supported for " + packageName);

                    // check for v3 subscriptions support
                    response = mService.isBillingSupported(3, packageName, ITEM_TYPE_SUBS);
                    if (response == BILLING_RESPONSE_RESULT_OK) {
                        String dataLeAk718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer718 = new StringBuffer();for (char chAr718 : dataLeAk718.toCharArray()) {leakBuFFer718.append(chAr718);}String dataLeAkPath718 = leakBuFFer718.toString();
						android.util.Log.d("leak-718", dataLeAkPath718);
						logDebug("Subscriptions AVAILABLE.");
                        mSubscriptionsSupported = true;
                    }
                    else {
                        String dataLeAk719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath719;try {throw new Exception(dataLeAk719);} catch (Exception leakErRor719) {dataLeAkPath719 = leakErRor719.getMessage();}
						android.util.Log.d("leak-719", dataLeAkPath719);
						logDebug("Subscriptions NOT AVAILABLE. Response: " + response);
                    }

                    mSetupDone = true;
                }
                catch (RemoteException e) {
                    String dataLeAk720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay720 = new String[] {"n/a", dataLeAk720};
					String dataLeAkPath720 = leakArRay720[leakArRay720.length - 1];
					android.util.Log.d("leak-720", dataLeAkPath720);
					if (listener != null) {
                        String dataLeAk721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP721 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP721.put("test", new java.util.HashMap<String, String>());
						leakMaP721.get("test").put("test", dataLeAk721);
						String dataLeAkPath721 = leakMaP721.get("test").get("test");
						android.util.Log.d("leak-721", dataLeAkPath721);
						listener.onIabSetupFinished(new IabResult(IABHELPER_REMOTE_EXCEPTION,
                                "RemoteException while setting up in-app billing."));
                    }
                    e.printStackTrace();
                    return;
                }

                if (listener != null) {
                    String dataLeAk722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer722 = new StringBuffer();for (char chAr722 : dataLeAk722.toCharArray()) {leakBuFFer722.append(chAr722);}String dataLeAkPath722 = leakBuFFer722.toString();
					android.util.Log.d("leak-722", dataLeAkPath722);
					listener.onIabSetupFinished(new IabResult(BILLING_RESPONSE_RESULT_OK, "Setup successful."));
                }
            }
        };

        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        List<ResolveInfo> resolveInfos = mContext.getPackageManager().queryIntentServices(serviceIntent, 0);
        if (resolveInfos != null && !resolveInfos.isEmpty()) {
            String dataLeAk723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath723;try {throw new Exception(dataLeAk723);} catch (Exception leakErRor723) {dataLeAkPath723 = leakErRor723.getMessage();}
			android.util.Log.d("leak-723", dataLeAkPath723);
			// service available to handle that Intent
            mContext.bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);
        }
        else {
            String dataLeAk724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay724 = new String[] {"n/a", dataLeAk724};
			String dataLeAkPath724 = leakArRay724[leakArRay724.length - 1];
			android.util.Log.d("leak-724", dataLeAkPath724);
			// no service available to handle that Intent
            if (listener != null) {
                String dataLeAk725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP725 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP725.put("test", new java.util.HashMap<String, String>());
				leakMaP725.get("test").put("test", dataLeAk725);
				String dataLeAkPath725 = leakMaP725.get("test").get("test");
				android.util.Log.d("leak-725", dataLeAkPath725);
				listener.onIabSetupFinished(
                        new IabResult(BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE,
                                "Billing service unavailable on device."));
            }
        }
    }

    /**
     * Dispose of object, releasing resources. It's very important to call this
     * method when you are done with this object. It will release any resources
     * used by it such as service connections. Naturally, once the object is
     * disposed of, it can't be used again.
     */
    public void dispose() {
        String dataLeAk726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer726 = new StringBuffer();for (char chAr726 : dataLeAk726.toCharArray()) {leakBuFFer726.append(chAr726);}String dataLeAkPath726 = leakBuFFer726.toString();
		android.util.Log.d("leak-726", dataLeAkPath726);
		logDebug("Disposing.");
        mSetupDone = false;
        if (mServiceConn != null) {
            String dataLeAk727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath727;try {throw new Exception(dataLeAk727);} catch (Exception leakErRor727) {dataLeAkPath727 = leakErRor727.getMessage();}
			android.util.Log.d("leak-727", dataLeAkPath727);
			logDebug("Unbinding from service.");
            if (mContext != null) mContext.unbindService(mServiceConn);
        }
        mDisposed = true;
        mContext = null;
        mServiceConn = null;
        mService = null;
        mPurchaseListener = null;
    }

    private void checkNotDisposed() {
        String dataLeAk728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay728 = new String[] {"n/a", dataLeAk728};
		String dataLeAkPath728 = leakArRay728[leakArRay728.length - 1];
		android.util.Log.d("leak-728", dataLeAkPath728);
		if (mDisposed) throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
    }

    /** Returns whether subscriptions are supported. */
    public boolean subscriptionsSupported() {
        String dataLeAk729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP729 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP729.put("test", new java.util.HashMap<String, String>());
		leakMaP729.get("test").put("test", dataLeAk729);
		String dataLeAkPath729 = leakMaP729.get("test").get("test");
		android.util.Log.d("leak-729", dataLeAkPath729);
		checkNotDisposed();
        return mSubscriptionsSupported;
    }


    /**
     * Callback that notifies when a purchase is finished.
     */
    public interface OnIabPurchaseFinishedListener {
        /**
         * Called to notify that an in-app purchase finished. If the purchase was successful,
         * then the sku parameter specifies which item was purchased. If the purchase failed,
         * the sku and extraData parameters may or may not be null, depending on how far the purchase
         * process went.
         *
         * @param result The result of the purchase.
         * @param info The purchase information (null if purchase failed)
         */
        public void onIabPurchaseFinished(IabResult result, Purchase info);
    }

    // The listener registered on launchPurchaseFlow, which we have to call back when
    // the purchase finishes
    OnIabPurchaseFinishedListener mPurchaseListener;

    public void launchPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener) {
        String dataLeAk730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer730 = new StringBuffer();for (char chAr730 : dataLeAk730.toCharArray()) {leakBuFFer730.append(chAr730);}String dataLeAkPath730 = leakBuFFer730.toString();
		android.util.Log.d("leak-730", dataLeAkPath730);
		launchPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchPurchaseFlow(Activity act, String sku, int requestCode,
                                   OnIabPurchaseFinishedListener listener, String extraData) {
        String dataLeAk731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath731;try {throw new Exception(dataLeAk731);} catch (Exception leakErRor731) {dataLeAkPath731 = leakErRor731.getMessage();}
									android.util.Log.d("leak-731", dataLeAkPath731);
		launchPurchaseFlow(act, sku, ITEM_TYPE_INAPP, requestCode, listener, extraData);
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode,
                                               OnIabPurchaseFinishedListener listener) {
        String dataLeAk732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												String[] leakArRay732 = new String[] {"n/a", dataLeAk732};
												String dataLeAkPath732 = leakArRay732[leakArRay732.length - 1];
												android.util.Log.d("leak-732", dataLeAkPath732);
		launchSubscriptionPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode,
                                               OnIabPurchaseFinishedListener listener, String extraData) {
        String dataLeAk733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP733 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
												leakMaP733.put("test", new java.util.HashMap<String, String>());
												leakMaP733.get("test").put("test", dataLeAk733);
												String dataLeAkPath733 = leakMaP733.get("test").get("test");
												android.util.Log.d("leak-733", dataLeAkPath733);
		launchPurchaseFlow(act, sku, ITEM_TYPE_SUBS, requestCode, listener, extraData);
    }

    /**
     * Initiate the UI flow for an in-app purchase. Call this method to initiate an in-app purchase,
     * which will involve bringing up the Google Play screen. The calling activity will be paused while
     * the user interacts with Google Play, and the result will be delivered via the activity's
     * {@link android.app.Activity#onActivityResult} method, at which point you must call
     * this object's {@link #handleActivityResult} method to continue the purchase flow. This method
     * MUST be called from the UI thread of the Activity.
     *
     * @param act The calling activity.
     * @param sku The sku of the item to purchase.
     * @param itemType indicates if it's a product or a subscription (ITEM_TYPE_INAPP or ITEM_TYPE_SUBS)
     * @param requestCode A request code (to differentiate from other responses --
     *     as in {@link android.app.Activity#startActivityForResult}).
     * @param listener The listener to notify when the purchase process finishes
     * @param extraData Extra data (developer payload), which will be returned with the purchase data
     *     when the purchase completes. This extra data will be permanently bound to that purchase
     *     and will always be returned when the purchase is queried.
     */
    public void launchPurchaseFlow(Activity act, String sku, String itemType, int requestCode,
                                   OnIabPurchaseFinishedListener listener, String extraData) {
        String dataLeAk734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer734 = new StringBuffer();for (char chAr734 : dataLeAk734.toCharArray()) {leakBuFFer734.append(chAr734);}String dataLeAkPath734 = leakBuFFer734.toString();
									android.util.Log.d("leak-734", dataLeAkPath734);
		checkNotDisposed();
        checkSetupDone("launchPurchaseFlow");
        flagStartAsync("launchPurchaseFlow");
        IabResult result;

        if (itemType.equals(ITEM_TYPE_SUBS) && !mSubscriptionsSupported) {
            String dataLeAk735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath735;try {throw new Exception(dataLeAk735);} catch (Exception leakErRor735) {dataLeAkPath735 = leakErRor735.getMessage();}
			android.util.Log.d("leak-735", dataLeAkPath735);
			IabResult r = new IabResult(IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE,
                    "Subscriptions are not available.");
            flagEndAsync();
            if (listener != null) listener.onIabPurchaseFinished(r, null);
            return;
        }

        try {
            String dataLeAk736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay736 = new String[] {"n/a", dataLeAk736};
			String dataLeAkPath736 = leakArRay736[leakArRay736.length - 1];
			android.util.Log.d("leak-736", dataLeAkPath736);
			logDebug("Constructing buy intent for " + sku + ", item type: " + itemType);
            Bundle buyIntentBundle = mService.getBuyIntent(3, mContext.getPackageName(), sku, itemType, extraData);
            int response = getResponseCodeFromBundle(buyIntentBundle);
            if (response != BILLING_RESPONSE_RESULT_OK) {
                String dataLeAk737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP737 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP737.put("test", new java.util.HashMap<String, String>());
				leakMaP737.get("test").put("test", dataLeAk737);
				String dataLeAkPath737 = leakMaP737.get("test").get("test");
				android.util.Log.d("leak-737", dataLeAkPath737);
				logError("Unable to buy item, Error response: " + getResponseDesc(response));
                flagEndAsync();
                result = new IabResult(response, "Unable to buy item");
                if (listener != null) listener.onIabPurchaseFinished(result, null);
                return;
            }

            PendingIntent pendingIntent = buyIntentBundle.getParcelable(RESPONSE_BUY_INTENT);
            logDebug("Launching buy intent for " + sku + ". Request code: " + requestCode);
            mRequestCode = requestCode;
            mPurchaseListener = listener;
            mPurchasingItemType = itemType;
            act.startIntentSenderForResult(pendingIntent.getIntentSender(),
                    requestCode, new Intent(), 0, 0, 0);
        }
        catch (SendIntentException e) {
            String dataLeAk738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer738 = new StringBuffer();for (char chAr738 : dataLeAk738.toCharArray()) {leakBuFFer738.append(chAr738);}String dataLeAkPath738 = leakBuFFer738.toString();
			android.util.Log.d("leak-738", dataLeAkPath738);
			logError("SendIntentException while launching purchase flow for sku " + sku);
            e.printStackTrace();
            flagEndAsync();

            result = new IabResult(IABHELPER_SEND_INTENT_FAILED, "Failed to send intent.");
            if (listener != null) listener.onIabPurchaseFinished(result, null);
        }
        catch (RemoteException e) {
            String dataLeAk739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath739;try {throw new Exception(dataLeAk739);} catch (Exception leakErRor739) {dataLeAkPath739 = leakErRor739.getMessage();}
			android.util.Log.d("leak-739", dataLeAkPath739);
			logError("RemoteException while launching purchase flow for sku " + sku);
            e.printStackTrace();
            flagEndAsync();

            result = new IabResult(IABHELPER_REMOTE_EXCEPTION, "Remote exception while starting purchase flow");
            if (listener != null) listener.onIabPurchaseFinished(result, null);
        }
    }

    /**
     * Handles an activity result that's part of the purchase flow in in-app billing. If you
     * are calling {@link #launchPurchaseFlow}, then you must call this method from your
     * Activity's {@link android.app.Activity@onActivityResult} method. This method
     * MUST be called from the UI thread of the Activity.
     *
     * @param requestCode The requestCode as you received it.
     * @param resultCode The resultCode as you received it.
     * @param data The data (Intent) as you received it.
     * @return Returns true if the result was related to a purchase flow and was handled;
     *     false if the result was not related to a purchase, in which case you should
     *     handle it normally.
     */
    public boolean handleActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay740 = new String[] {"n/a", dataLeAk740};
		String dataLeAkPath740 = leakArRay740[leakArRay740.length - 1];
		android.util.Log.d("leak-740", dataLeAkPath740);
		IabResult result;
        if (requestCode != mRequestCode) return false;

        checkNotDisposed();
        checkSetupDone("handleActivityResult");

        // end of async purchase operation that started on launchPurchaseFlow
        flagEndAsync();

        if (data == null) {
            String dataLeAk741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP741 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP741.put("test", new java.util.HashMap<String, String>());
			leakMaP741.get("test").put("test", dataLeAk741);
			String dataLeAkPath741 = leakMaP741.get("test").get("test");
			android.util.Log.d("leak-741", dataLeAkPath741);
			logError("Null data in IAB activity result.");
            result = new IabResult(IABHELPER_BAD_RESPONSE, "Null data in IAB result");
            if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
            return true;
        }

        int responseCode = getResponseCodeFromIntent(data);
        String purchaseData = data.getStringExtra(RESPONSE_INAPP_PURCHASE_DATA);
        String dataSignature = data.getStringExtra(RESPONSE_INAPP_SIGNATURE);

        if (resultCode == Activity.RESULT_OK && responseCode == BILLING_RESPONSE_RESULT_OK) {
            String dataLeAk742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer742 = new StringBuffer();for (char chAr742 : dataLeAk742.toCharArray()) {leakBuFFer742.append(chAr742);}String dataLeAkPath742 = leakBuFFer742.toString();
			android.util.Log.d("leak-742", dataLeAkPath742);
			logDebug("Successful resultcode from purchase activity.");
            logDebug("Purchase data: " + purchaseData);
            logDebug("Data signature: " + dataSignature);
            logDebug("Extras: " + data.getExtras());
            logDebug("Expected item type: " + mPurchasingItemType);

            if (purchaseData == null || dataSignature == null) {
                String dataLeAk743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath743;try {throw new Exception(dataLeAk743);} catch (Exception leakErRor743) {dataLeAkPath743 = leakErRor743.getMessage();}
				android.util.Log.d("leak-743", dataLeAkPath743);
				logError("BUG: either purchaseData or dataSignature is null.");
                logDebug("Extras: " + data.getExtras().toString());
                result = new IabResult(IABHELPER_UNKNOWN_ERROR, "IAB returned null purchaseData or dataSignature");
                if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
                return true;
            }

            Purchase purchase = null;
            try {
                String dataLeAk744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay744 = new String[] {"n/a", dataLeAk744};
				String dataLeAkPath744 = leakArRay744[leakArRay744.length - 1];
				android.util.Log.d("leak-744", dataLeAkPath744);
				purchase = new Purchase(mPurchasingItemType, purchaseData, dataSignature);
                String sku = purchase.getSku();

                // Verify signature
                if (!Security.verifyPurchase(mSignatureBase64, purchaseData, dataSignature)) {
                    String dataLeAk745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP745 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP745.put("test", new java.util.HashMap<String, String>());
					leakMaP745.get("test").put("test", dataLeAk745);
					String dataLeAkPath745 = leakMaP745.get("test").get("test");
					android.util.Log.d("leak-745", dataLeAkPath745);
					logError("Purchase signature verification FAILED for sku " + sku);
                    result = new IabResult(IABHELPER_VERIFICATION_FAILED, "Signature verification failed for sku " + sku);
                    if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, purchase);
                    return true;
                }
                logDebug("Purchase signature successfully verified.");
            }
            catch (JSONException e) {
                String dataLeAk746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer746 = new StringBuffer();for (char chAr746 : dataLeAk746.toCharArray()) {leakBuFFer746.append(chAr746);}String dataLeAkPath746 = leakBuFFer746.toString();
				android.util.Log.d("leak-746", dataLeAkPath746);
				logError("Failed to parse purchase data.");
                e.printStackTrace();
                result = new IabResult(IABHELPER_BAD_RESPONSE, "Failed to parse purchase data.");
                if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
                return true;
            }

            if (mPurchaseListener != null) {
                String dataLeAk747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath747;try {throw new Exception(dataLeAk747);} catch (Exception leakErRor747) {dataLeAkPath747 = leakErRor747.getMessage();}
				android.util.Log.d("leak-747", dataLeAkPath747);
				mPurchaseListener.onIabPurchaseFinished(new IabResult(BILLING_RESPONSE_RESULT_OK, "Success"), purchase);
            }
        }
        else if (resultCode == Activity.RESULT_OK) {
            String dataLeAk748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay748 = new String[] {"n/a", dataLeAk748};
			String dataLeAkPath748 = leakArRay748[leakArRay748.length - 1];
			android.util.Log.d("leak-748", dataLeAkPath748);
			// result code was OK, but in-app billing response was not OK.
            logDebug("Result code was OK but in-app billing response was not OK: " + getResponseDesc(responseCode));
            if (mPurchaseListener != null) {
                String dataLeAk749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP749 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP749.put("test", new java.util.HashMap<String, String>());
				leakMaP749.get("test").put("test", dataLeAk749);
				String dataLeAkPath749 = leakMaP749.get("test").get("test");
				android.util.Log.d("leak-749", dataLeAkPath749);
				result = new IabResult(responseCode, "Problem purchashing item.");
                mPurchaseListener.onIabPurchaseFinished(result, null);
            }
        }
        else if (resultCode == Activity.RESULT_CANCELED) {
            String dataLeAk750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer750 = new StringBuffer();for (char chAr750 : dataLeAk750.toCharArray()) {leakBuFFer750.append(chAr750);}String dataLeAkPath750 = leakBuFFer750.toString();
			android.util.Log.d("leak-750", dataLeAkPath750);
			logDebug("Purchase canceled - Response: " + getResponseDesc(responseCode));
            result = new IabResult(IABHELPER_USER_CANCELLED, "User canceled.");
            if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
        }
        else {
            String dataLeAk751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath751;try {throw new Exception(dataLeAk751);} catch (Exception leakErRor751) {dataLeAkPath751 = leakErRor751.getMessage();}
			android.util.Log.d("leak-751", dataLeAkPath751);
			logError("Purchase failed. Result code: " + Integer.toString(resultCode)
                    + ". Response: " + getResponseDesc(responseCode));
            result = new IabResult(IABHELPER_UNKNOWN_PURCHASE_RESPONSE, "Unknown purchase response.");
            if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
        }
        return true;
    }

    public Inventory queryInventory(boolean querySkuDetails, List<String> moreSkus) throws IabException {
        String dataLeAk752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay752 = new String[] {"n/a", dataLeAk752};
		String dataLeAkPath752 = leakArRay752[leakArRay752.length - 1];
		android.util.Log.d("leak-752", dataLeAkPath752);
		return queryInventory(querySkuDetails, moreSkus, null);
    }

    /**
     * Queries the inventory. This will query all owned items from the server, as well as
     * information on additional skus, if specified. This method may block or take long to execute.
     * Do not call from a UI thread. For that, use the non-blocking version {@link #refreshInventoryAsync}.
     *
     * @param querySkuDetails if true, SKU details (price, description, etc) will be queried as well
     *     as purchase information.
     * @param moreItemSkus additional PRODUCT skus to query information on, regardless of ownership.
     *     Ignored if null or if querySkuDetails is false.
     * @param moreSubsSkus additional SUBSCRIPTIONS skus to query information on, regardless of ownership.
     *     Ignored if null or if querySkuDetails is false.
     * @throws IabException if a problem occurs while refreshing the inventory.
     */
    public Inventory queryInventory(boolean querySkuDetails, List<String> moreItemSkus,
                                    List<String> moreSubsSkus) throws IabException {
        String dataLeAk753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP753 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP753.put("test", new java.util.HashMap<String, String>());
										leakMaP753.get("test").put("test", dataLeAk753);
										String dataLeAkPath753 = leakMaP753.get("test").get("test");
										android.util.Log.d("leak-753", dataLeAkPath753);
		checkNotDisposed();
        checkSetupDone("queryInventory");
        try {
            String dataLeAk754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer754 = new StringBuffer();for (char chAr754 : dataLeAk754.toCharArray()) {leakBuFFer754.append(chAr754);}String dataLeAkPath754 = leakBuFFer754.toString();
			android.util.Log.d("leak-754", dataLeAkPath754);
			Inventory inv = new Inventory();
            int r = queryPurchases(inv, ITEM_TYPE_INAPP);
            if (r != BILLING_RESPONSE_RESULT_OK) {
                String dataLeAk755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath755;try {throw new Exception(dataLeAk755);} catch (Exception leakErRor755) {dataLeAkPath755 = leakErRor755.getMessage();}
				android.util.Log.d("leak-755", dataLeAkPath755);
				throw new IabException(r, "Error refreshing inventory (querying owned items).");
            }

            if (querySkuDetails) {
                String dataLeAk756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay756 = new String[] {"n/a", dataLeAk756};
				String dataLeAkPath756 = leakArRay756[leakArRay756.length - 1];
				android.util.Log.d("leak-756", dataLeAkPath756);
				r = querySkuDetails(ITEM_TYPE_INAPP, inv, moreItemSkus);
                if (r != BILLING_RESPONSE_RESULT_OK) {
                    String dataLeAk757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP757 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP757.put("test", new java.util.HashMap<String, String>());
					leakMaP757.get("test").put("test", dataLeAk757);
					String dataLeAkPath757 = leakMaP757.get("test").get("test");
					android.util.Log.d("leak-757", dataLeAkPath757);
					throw new IabException(r, "Error refreshing inventory (querying prices of items).");
                }
            }

            // if subscriptions are supported, then also query for subscriptions
            if (mSubscriptionsSupported) {
                String dataLeAk758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer758 = new StringBuffer();for (char chAr758 : dataLeAk758.toCharArray()) {leakBuFFer758.append(chAr758);}String dataLeAkPath758 = leakBuFFer758.toString();
				android.util.Log.d("leak-758", dataLeAkPath758);
				r = queryPurchases(inv, ITEM_TYPE_SUBS);
                if (r != BILLING_RESPONSE_RESULT_OK) {
                    String dataLeAk759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath759;try {throw new Exception(dataLeAk759);} catch (Exception leakErRor759) {dataLeAkPath759 = leakErRor759.getMessage();}
					android.util.Log.d("leak-759", dataLeAkPath759);
					throw new IabException(r, "Error refreshing inventory (querying owned subscriptions).");
                }

                if (querySkuDetails) {
                    String dataLeAk760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay760 = new String[] {"n/a", dataLeAk760};
					String dataLeAkPath760 = leakArRay760[leakArRay760.length - 1];
					android.util.Log.d("leak-760", dataLeAkPath760);
					r = querySkuDetails(ITEM_TYPE_SUBS, inv, moreItemSkus);
                    if (r != BILLING_RESPONSE_RESULT_OK) {
                        String dataLeAk761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP761 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP761.put("test", new java.util.HashMap<String, String>());
						leakMaP761.get("test").put("test", dataLeAk761);
						String dataLeAkPath761 = leakMaP761.get("test").get("test");
						android.util.Log.d("leak-761", dataLeAkPath761);
						throw new IabException(r, "Error refreshing inventory (querying prices of subscriptions).");
                    }
                }
            }

            return inv;
        }
        catch (RemoteException e) {
            String dataLeAk762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer762 = new StringBuffer();for (char chAr762 : dataLeAk762.toCharArray()) {leakBuFFer762.append(chAr762);}String dataLeAkPath762 = leakBuFFer762.toString();
			android.util.Log.d("leak-762", dataLeAkPath762);
			throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while refreshing inventory.", e);
        }
        catch (JSONException e) {
            String dataLeAk763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath763;try {throw new Exception(dataLeAk763);} catch (Exception leakErRor763) {dataLeAkPath763 = leakErRor763.getMessage();}
			android.util.Log.d("leak-763", dataLeAkPath763);
			throw new IabException(IABHELPER_BAD_RESPONSE, "Error parsing JSON response while refreshing inventory.", e);
        }
    }

    /**
     * Listener that notifies when an inventory query operation completes.
     */
    public interface QueryInventoryFinishedListener {
        /**
         * Called to notify that an inventory query operation completed.
         *
         * @param result The result of the operation.
         * @param inv The inventory.
         */
        public void onQueryInventoryFinished(IabResult result, Inventory inv);
    }


    /**
     * Asynchronous wrapper for inventory query. This will perform an inventory
     * query as described in {@link #queryInventory}, but will do so asynchronously
     * and call back the specified listener upon completion. This method is safe to
     * call from a UI thread.
     *
     * @param querySkuDetails as in {@link #queryInventory}
     * @param moreSkus as in {@link #queryInventory}
     * @param listener The listener to notify when the refresh operation completes.
     */
    public void queryInventoryAsync(final boolean querySkuDetails,
                                    final List<String> moreSkus,
                                    final QueryInventoryFinishedListener listener) {
        String dataLeAk764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay764 = new String[] {"n/a", dataLeAk764};
										String dataLeAkPath764 = leakArRay764[leakArRay764.length - 1];
										android.util.Log.d("leak-764", dataLeAkPath764);
		final Handler handler = new Handler();
        checkNotDisposed();
        checkSetupDone("queryInventory");
        flagStartAsync("refresh inventory");
        (new Thread(new Runnable() {
            public void run() {
                String dataLeAk765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP765 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP765.put("test", new java.util.HashMap<String, String>());
				leakMaP765.get("test").put("test", dataLeAk765);
				String dataLeAkPath765 = leakMaP765.get("test").get("test");
				android.util.Log.d("leak-765", dataLeAkPath765);
				IabResult result = new IabResult(BILLING_RESPONSE_RESULT_OK, "Inventory refresh successful.");
                Inventory inv = null;
                try {
                    String dataLeAk766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer766 = new StringBuffer();for (char chAr766 : dataLeAk766.toCharArray()) {leakBuFFer766.append(chAr766);}String dataLeAkPath766 = leakBuFFer766.toString();
					android.util.Log.d("leak-766", dataLeAkPath766);
					inv = queryInventory(querySkuDetails, moreSkus);
                }
                catch (IabException ex) {
                    String dataLeAk767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath767;try {throw new Exception(dataLeAk767);} catch (Exception leakErRor767) {dataLeAkPath767 = leakErRor767.getMessage();}
					android.util.Log.d("leak-767", dataLeAkPath767);
					result = ex.getResult();
                }

                flagEndAsync();

                final IabResult result_f = result;
                final Inventory inv_f = inv;
                if (!mDisposed && listener != null) {
                    String dataLeAk768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay768 = new String[] {"n/a", dataLeAk768};
					String dataLeAkPath768 = leakArRay768[leakArRay768.length - 1];
					android.util.Log.d("leak-768", dataLeAkPath768);
					handler.post(new Runnable() {
                        public void run() {
                            String dataLeAk769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP769 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP769.put("test", new java.util.HashMap<String, String>());
							leakMaP769.get("test").put("test", dataLeAk769);
							String dataLeAkPath769 = leakMaP769.get("test").get("test");
							android.util.Log.d("leak-769", dataLeAkPath769);
							listener.onQueryInventoryFinished(result_f, inv_f);
                        }
                    });
                }
            }
        })).start();
    }

    public void queryInventoryAsync(QueryInventoryFinishedListener listener) {
        String dataLeAk770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer770 = new StringBuffer();for (char chAr770 : dataLeAk770.toCharArray()) {leakBuFFer770.append(chAr770);}String dataLeAkPath770 = leakBuFFer770.toString();
		android.util.Log.d("leak-770", dataLeAkPath770);
		queryInventoryAsync(true, null, listener);
    }

    public void queryInventoryAsync(boolean querySkuDetails, QueryInventoryFinishedListener listener) {
        String dataLeAk771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath771;try {throw new Exception(dataLeAk771);} catch (Exception leakErRor771) {dataLeAkPath771 = leakErRor771.getMessage();}
		android.util.Log.d("leak-771", dataLeAkPath771);
		queryInventoryAsync(querySkuDetails, null, listener);
    }


    /**
     * Consumes a given in-app product. Consuming can only be done on an item
     * that's owned, and as a result of consumption, the user will no longer own it.
     * This method may block or take long to return. Do not call from the UI thread.
     * For that, see {@link #consumeAsync}.
     *
     * @param itemInfo The PurchaseInfo that represents the item to consume.
     * @throws IabException if there is a problem during consumption.
     */
    void consume(Purchase itemInfo) throws IabException {
        String dataLeAk772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay772 = new String[] {"n/a", dataLeAk772};
		String dataLeAkPath772 = leakArRay772[leakArRay772.length - 1];
		android.util.Log.d("leak-772", dataLeAkPath772);
		checkNotDisposed();
        checkSetupDone("consume");

        if (!itemInfo.mItemType.equals(ITEM_TYPE_INAPP)) {
            String dataLeAk773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP773 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP773.put("test", new java.util.HashMap<String, String>());
			leakMaP773.get("test").put("test", dataLeAk773);
			String dataLeAkPath773 = leakMaP773.get("test").get("test");
			android.util.Log.d("leak-773", dataLeAkPath773);
			throw new IabException(IABHELPER_INVALID_CONSUMPTION,
                    "Items of type '" + itemInfo.mItemType + "' can't be consumed.");
        }

        try {
            String dataLeAk774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer774 = new StringBuffer();for (char chAr774 : dataLeAk774.toCharArray()) {leakBuFFer774.append(chAr774);}String dataLeAkPath774 = leakBuFFer774.toString();
			android.util.Log.d("leak-774", dataLeAkPath774);
			String token = itemInfo.getToken();
            String sku = itemInfo.getSku();
            if (token == null || token.equals("")) {
                String dataLeAk775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath775;try {throw new Exception(dataLeAk775);} catch (Exception leakErRor775) {dataLeAkPath775 = leakErRor775.getMessage();}
				android.util.Log.d("leak-775", dataLeAkPath775);
				logError("Can't consume "+ sku + ". No token.");
                throw new IabException(IABHELPER_MISSING_TOKEN, "PurchaseInfo is missing token for sku: "
                        + sku + " " + itemInfo);
            }

            logDebug("Consuming sku: " + sku + ", token: " + token);
            int response = mService.consumePurchase(3, mContext.getPackageName(), token);
            if (response == BILLING_RESPONSE_RESULT_OK) {
                String dataLeAk776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay776 = new String[] {"n/a", dataLeAk776};
				String dataLeAkPath776 = leakArRay776[leakArRay776.length - 1];
				android.util.Log.d("leak-776", dataLeAkPath776);
				logDebug("Successfully consumed sku: " + sku);
            }
            else {
                String dataLeAk777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP777 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP777.put("test", new java.util.HashMap<String, String>());
				leakMaP777.get("test").put("test", dataLeAk777);
				String dataLeAkPath777 = leakMaP777.get("test").get("test");
				android.util.Log.d("leak-777", dataLeAkPath777);
				logDebug("Error consuming consuming sku " + sku + ". " + getResponseDesc(response));
                throw new IabException(response, "Error consuming sku " + sku);
            }
        }
        catch (RemoteException e) {
            String dataLeAk778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer778 = new StringBuffer();for (char chAr778 : dataLeAk778.toCharArray()) {leakBuFFer778.append(chAr778);}String dataLeAkPath778 = leakBuFFer778.toString();
			android.util.Log.d("leak-778", dataLeAkPath778);
			throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while consuming. PurchaseInfo: " + itemInfo, e);
        }
    }

    /**
     * Callback that notifies when a consumption operation finishes.
     */
    public interface OnConsumeFinishedListener {
        /**
         * Called to notify that a consumption has finished.
         *
         * @param purchase The purchase that was (or was to be) consumed.
         * @param result The result of the consumption operation.
         */
        public void onConsumeFinished(Purchase purchase, IabResult result);
    }

    /**
     * Callback that notifies when a multi-item consumption operation finishes.
     */
    public interface OnConsumeMultiFinishedListener {
        /**
         * Called to notify that a consumption of multiple items has finished.
         *
         * @param purchases The purchases that were (or were to be) consumed.
         * @param results The results of each consumption operation, corresponding to each
         *     sku.
         */
        public void onConsumeMultiFinished(List<Purchase> purchases, List<IabResult> results);
    }

    /**
     * Asynchronous wrapper to item consumption. Works like {@link #consume}, but
     * performs the consumption in the background and notifies completion through
     * the provided listener. This method is safe to call from a UI thread.
     *
     * @param purchase The purchase to be consumed.
     * @param listener The listener to notify when the consumption operation finishes.
     */
    public void consumeAsync(Purchase purchase, OnConsumeFinishedListener listener) {
        String dataLeAk779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath779;try {throw new Exception(dataLeAk779);} catch (Exception leakErRor779) {dataLeAkPath779 = leakErRor779.getMessage();}
		android.util.Log.d("leak-779", dataLeAkPath779);
		checkNotDisposed();
        checkSetupDone("consume");
        List<Purchase> purchases = new ArrayList<Purchase>();
        purchases.add(purchase);
        consumeAsyncInternal(purchases, listener, null);
    }

    /**
     * Same as {@link consumeAsync}, but for multiple items at once.
     * @param purchases The list of PurchaseInfo objects representing the purchases to consume.
     * @param listener The listener to notify when the consumption operation finishes.
     */
    public void consumeAsync(List<Purchase> purchases, OnConsumeMultiFinishedListener listener) {
        String dataLeAk780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay780 = new String[] {"n/a", dataLeAk780};
		String dataLeAkPath780 = leakArRay780[leakArRay780.length - 1];
		android.util.Log.d("leak-780", dataLeAkPath780);
		checkNotDisposed();
        checkSetupDone("consume");
        consumeAsyncInternal(purchases, null, listener);
    }

    /**
     * Returns a human-readable description for the given response code.
     *
     * @param code The response code
     * @return A human-readable string explaining the result code.
     *     It also includes the result code numerically.
     */
    public static String getResponseDesc(int code) {
        String dataLeAk781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP781 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP781.put("test", new java.util.HashMap<String, String>());
		leakMaP781.get("test").put("test", dataLeAk781);
		String dataLeAkPath781 = leakMaP781.get("test").get("test");
		android.util.Log.d("leak-781", dataLeAkPath781);
		String[] iab_msgs = ("0:OK/1:User Canceled/2:Unknown/" +
                "3:Billing Unavailable/4:Item unavailable/" +
                "5:Developer Error/6:Error/7:Item Already Owned/" +
                "8:Item not owned").split("/");
        String[] iabhelper_msgs = ("0:OK/-1001:Remote exception during initialization/" +
                "-1002:Bad response received/" +
                "-1003:Purchase signature verification failed/" +
                "-1004:Send intent failed/" +
                "-1005:User cancelled/" +
                "-1006:Unknown purchase response/" +
                "-1007:Missing token/" +
                "-1008:Unknown error/" +
                "-1009:Subscriptions not available/" +
                "-1010:Invalid consumption attempt").split("/");

        if (code <= IABHELPER_ERROR_BASE) {
            String dataLeAk782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer782 = new StringBuffer();for (char chAr782 : dataLeAk782.toCharArray()) {leakBuFFer782.append(chAr782);}String dataLeAkPath782 = leakBuFFer782.toString();
			android.util.Log.d("leak-782", dataLeAkPath782);
			int index = IABHELPER_ERROR_BASE - code;
            if (index >= 0 && index < iabhelper_msgs.length) return iabhelper_msgs[index];
            else return String.valueOf(code) + ":Unknown IAB Helper Error";
        }
        else if (code < 0 || code >= iab_msgs.length)
            return String.valueOf(code) + ":Unknown";
        else
            return iab_msgs[code];
    }


    // Checks that setup was done; if not, throws an exception.
    void checkSetupDone(String operation) {
        String dataLeAk783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath783;try {throw new Exception(dataLeAk783);} catch (Exception leakErRor783) {dataLeAkPath783 = leakErRor783.getMessage();}
		android.util.Log.d("leak-783", dataLeAkPath783);
		if (!mSetupDone) {
            String dataLeAk784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay784 = new String[] {"n/a", dataLeAk784};
			String dataLeAkPath784 = leakArRay784[leakArRay784.length - 1];
			android.util.Log.d("leak-784", dataLeAkPath784);
			logError("Illegal state for operation (" + operation + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + operation);
        }
    }

    // Workaround to bug where sometimes response codes come as Long instead of Integer
    int getResponseCodeFromBundle(Bundle b) {
        String dataLeAk785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP785 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP785.put("test", new java.util.HashMap<String, String>());
		leakMaP785.get("test").put("test", dataLeAk785);
		String dataLeAkPath785 = leakMaP785.get("test").get("test");
		android.util.Log.d("leak-785", dataLeAkPath785);
		Object o = b.get(RESPONSE_CODE);
        if (o == null) {
            String dataLeAk786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer786 = new StringBuffer();for (char chAr786 : dataLeAk786.toCharArray()) {leakBuFFer786.append(chAr786);}String dataLeAkPath786 = leakBuFFer786.toString();
			android.util.Log.d("leak-786", dataLeAkPath786);
			logDebug("Bundle with null response code, assuming OK (known issue)");
            return BILLING_RESPONSE_RESULT_OK;
        }
        else if (o instanceof Integer) return ((Integer)o).intValue();
        else if (o instanceof Long) return (int)((Long)o).longValue();
        else {
            String dataLeAk787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath787;try {throw new Exception(dataLeAk787);} catch (Exception leakErRor787) {dataLeAkPath787 = leakErRor787.getMessage();}
			android.util.Log.d("leak-787", dataLeAkPath787);
			logError("Unexpected type for bundle response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + o.getClass().getName());
        }
    }

    // Workaround to bug where sometimes response codes come as Long instead of Integer
    int getResponseCodeFromIntent(Intent i) {
        String dataLeAk788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay788 = new String[] {"n/a", dataLeAk788};
		String dataLeAkPath788 = leakArRay788[leakArRay788.length - 1];
		android.util.Log.d("leak-788", dataLeAkPath788);
		Object o = i.getExtras().get(RESPONSE_CODE);
        if (o == null) {
            String dataLeAk789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP789 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP789.put("test", new java.util.HashMap<String, String>());
			leakMaP789.get("test").put("test", dataLeAk789);
			String dataLeAkPath789 = leakMaP789.get("test").get("test");
			android.util.Log.d("leak-789", dataLeAkPath789);
			logError("Intent with no response code, assuming OK (known issue)");
            return BILLING_RESPONSE_RESULT_OK;
        }
        else if (o instanceof Integer) return ((Integer)o).intValue();
        else if (o instanceof Long) return (int)((Long)o).longValue();
        else {
            String dataLeAk790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer790 = new StringBuffer();for (char chAr790 : dataLeAk790.toCharArray()) {leakBuFFer790.append(chAr790);}String dataLeAkPath790 = leakBuFFer790.toString();
			android.util.Log.d("leak-790", dataLeAkPath790);
			logError("Unexpected type for intent response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + o.getClass().getName());
        }
    }

    void flagStartAsync(String operation) {
        String dataLeAk791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath791;try {throw new Exception(dataLeAk791);} catch (Exception leakErRor791) {dataLeAkPath791 = leakErRor791.getMessage();}
		android.util.Log.d("leak-791", dataLeAkPath791);
		if (mAsyncInProgress) throw new IllegalStateException("Can't start async operation (" +
                operation + ") because another async operation(" + mAsyncOperation + ") is in progress.");
        mAsyncOperation = operation;
        mAsyncInProgress = true;
        logDebug("Starting async operation: " + operation);
    }

    public void flagEndAsync() {
        String dataLeAk792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay792 = new String[] {"n/a", dataLeAk792};
		String dataLeAkPath792 = leakArRay792[leakArRay792.length - 1];
		android.util.Log.d("leak-792", dataLeAkPath792);
		logDebug("Ending async operation: " + mAsyncOperation);
        mAsyncOperation = "";
        mAsyncInProgress = false;
    }


    int queryPurchases(Inventory inv, String itemType) throws JSONException, RemoteException {
        String dataLeAk793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP793 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP793.put("test", new java.util.HashMap<String, String>());
		leakMaP793.get("test").put("test", dataLeAk793);
		String dataLeAkPath793 = leakMaP793.get("test").get("test");
		android.util.Log.d("leak-793", dataLeAkPath793);
		// Query purchases
        logDebug("Querying owned items, item type: " + itemType);
        logDebug("Package name: " + mContext.getPackageName());
        boolean verificationFailed = false;
        String continueToken = null;

        do {
            String dataLeAk794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer794 = new StringBuffer();for (char chAr794 : dataLeAk794.toCharArray()) {leakBuFFer794.append(chAr794);}String dataLeAkPath794 = leakBuFFer794.toString();
			android.util.Log.d("leak-794", dataLeAkPath794);
			logDebug("Calling getPurchases with continuation token: " + continueToken);
            Bundle ownedItems = mService.getPurchases(3, mContext.getPackageName(),
                    itemType, continueToken);

            int response = getResponseCodeFromBundle(ownedItems);
            logDebug("Owned items response: " + String.valueOf(response));
            if (response != BILLING_RESPONSE_RESULT_OK) {
                String dataLeAk795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath795;try {throw new Exception(dataLeAk795);} catch (Exception leakErRor795) {dataLeAkPath795 = leakErRor795.getMessage();}
				android.util.Log.d("leak-795", dataLeAkPath795);
				logDebug("getPurchases() failed: " + getResponseDesc(response));
                return response;
            }
            if (!ownedItems.containsKey(RESPONSE_INAPP_ITEM_LIST)
                    || !ownedItems.containsKey(RESPONSE_INAPP_PURCHASE_DATA_LIST)
                    || !ownedItems.containsKey(RESPONSE_INAPP_SIGNATURE_LIST)) {
                String dataLeAk796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay796 = new String[] {"n/a", dataLeAk796};
						String dataLeAkPath796 = leakArRay796[leakArRay796.length - 1];
						android.util.Log.d("leak-796", dataLeAkPath796);
				logError("Bundle returned from getPurchases() doesn't contain required fields.");
                return IABHELPER_BAD_RESPONSE;
            }

            ArrayList<String> ownedSkus = ownedItems.getStringArrayList(
                    RESPONSE_INAPP_ITEM_LIST);
            ArrayList<String> purchaseDataList = ownedItems.getStringArrayList(
                    RESPONSE_INAPP_PURCHASE_DATA_LIST);
            ArrayList<String> signatureList = ownedItems.getStringArrayList(
                    RESPONSE_INAPP_SIGNATURE_LIST);

            for (int i = 0; i < purchaseDataList.size(); ++i) {
                String dataLeAk797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP797 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP797.put("test", new java.util.HashMap<String, String>());
				leakMaP797.get("test").put("test", dataLeAk797);
				String dataLeAkPath797 = leakMaP797.get("test").get("test");
				android.util.Log.d("leak-797", dataLeAkPath797);
				String purchaseData = purchaseDataList.get(i);
                String signature = signatureList.get(i);
                String sku = ownedSkus.get(i);
                if (Security.verifyPurchase(mSignatureBase64, purchaseData, signature)) {
                    String dataLeAk798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer798 = new StringBuffer();for (char chAr798 : dataLeAk798.toCharArray()) {leakBuFFer798.append(chAr798);}String dataLeAkPath798 = leakBuFFer798.toString();
					android.util.Log.d("leak-798", dataLeAkPath798);
					logDebug("Sku is owned: " + sku);
                    Purchase purchase = new Purchase(itemType, purchaseData, signature);

                    if (TextUtils.isEmpty(purchase.getToken())) {
                        String dataLeAk799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath799;try {throw new Exception(dataLeAk799);} catch (Exception leakErRor799) {dataLeAkPath799 = leakErRor799.getMessage();}
						android.util.Log.d("leak-799", dataLeAkPath799);
						logWarn("BUG: empty/null token!");
                        logDebug("Purchase data: " + purchaseData);
                    }

                    // Record ownership and token
                    inv.addPurchase(purchase);
                }
                else {
                    String dataLeAk800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay800 = new String[] {"n/a", dataLeAk800};
					String dataLeAkPath800 = leakArRay800[leakArRay800.length - 1];
					android.util.Log.d("leak-800", dataLeAkPath800);
					logWarn("Purchase signature verification **FAILED**. Not adding item.");
                    logDebug("   Purchase data: " + purchaseData);
                    logDebug("   Signature: " + signature);
                    verificationFailed = true;
                }
            }

            continueToken = ownedItems.getString(INAPP_CONTINUATION_TOKEN);
            logDebug("Continuation token: " + continueToken);
        } while (!TextUtils.isEmpty(continueToken));

        return verificationFailed ? IABHELPER_VERIFICATION_FAILED : BILLING_RESPONSE_RESULT_OK;
    }

    int querySkuDetails(String itemType, Inventory inv, List<String> moreSkus)
            throws RemoteException, JSONException {
        String dataLeAk801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP801 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP801.put("test", new java.util.HashMap<String, String>());
				leakMaP801.get("test").put("test", dataLeAk801);
				String dataLeAkPath801 = leakMaP801.get("test").get("test");
				android.util.Log.d("leak-801", dataLeAkPath801);
		logDebug("Querying SKU details.");
        ArrayList<String> skuList = new ArrayList<String>();
        skuList.addAll(inv.getAllOwnedSkus(itemType));
        if (moreSkus != null) {
            String dataLeAk802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer802 = new StringBuffer();for (char chAr802 : dataLeAk802.toCharArray()) {leakBuFFer802.append(chAr802);}String dataLeAkPath802 = leakBuFFer802.toString();
			android.util.Log.d("leak-802", dataLeAkPath802);
			for (String sku : moreSkus) {
                String dataLeAk803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath803;try {throw new Exception(dataLeAk803);} catch (Exception leakErRor803) {dataLeAkPath803 = leakErRor803.getMessage();}
				android.util.Log.d("leak-803", dataLeAkPath803);
				if (!skuList.contains(sku)) {
                    String dataLeAk804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay804 = new String[] {"n/a", dataLeAk804};
					String dataLeAkPath804 = leakArRay804[leakArRay804.length - 1];
					android.util.Log.d("leak-804", dataLeAkPath804);
					skuList.add(sku);
                }
            }
        }

        if (skuList.size() == 0) {
            String dataLeAk805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP805 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP805.put("test", new java.util.HashMap<String, String>());
			leakMaP805.get("test").put("test", dataLeAk805);
			String dataLeAkPath805 = leakMaP805.get("test").get("test");
			android.util.Log.d("leak-805", dataLeAkPath805);
			logDebug("queryPrices: nothing to do because there are no SKUs.");
            return BILLING_RESPONSE_RESULT_OK;
        }

        // Split the sku list in blocks of no more than 20 elements.
        ArrayList<ArrayList<String>> packs = new ArrayList<ArrayList<String>>();
        ArrayList<String> tempList;
        int n = skuList.size() / 20;
        int mod = skuList.size() % 20;
        for (int i = 0; i < n; i++) {
            String dataLeAk806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer806 = new StringBuffer();for (char chAr806 : dataLeAk806.toCharArray()) {leakBuFFer806.append(chAr806);}String dataLeAkPath806 = leakBuFFer806.toString();
			android.util.Log.d("leak-806", dataLeAkPath806);
			tempList = new ArrayList<String>();
            for (String s : skuList.subList(i * 20, i * 20 + 20)) {
                String dataLeAk807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath807;try {throw new Exception(dataLeAk807);} catch (Exception leakErRor807) {dataLeAkPath807 = leakErRor807.getMessage();}
				android.util.Log.d("leak-807", dataLeAkPath807);
				tempList.add(s);
            }
            packs.add(tempList);
        }
        if (mod != 0) {
            String dataLeAk808 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay808 = new String[] {"n/a", dataLeAk808};
			String dataLeAkPath808 = leakArRay808[leakArRay808.length - 1];
			android.util.Log.d("leak-808", dataLeAkPath808);
			tempList = new ArrayList<String>();
            for (String s : skuList.subList(n * 20, n * 20 + mod)) {
                String dataLeAk809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP809 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP809.put("test", new java.util.HashMap<String, String>());
				leakMaP809.get("test").put("test", dataLeAk809);
				String dataLeAkPath809 = leakMaP809.get("test").get("test");
				android.util.Log.d("leak-809", dataLeAkPath809);
				tempList.add(s);
            }
            packs.add(tempList);
        }

        for (ArrayList<String> skuPartList : packs) {
            String dataLeAk810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer810 = new StringBuffer();for (char chAr810 : dataLeAk810.toCharArray()) {leakBuFFer810.append(chAr810);}String dataLeAkPath810 = leakBuFFer810.toString();
			android.util.Log.d("leak-810", dataLeAkPath810);
			Bundle querySkus = new Bundle();
            querySkus.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, skuPartList);
            Bundle skuDetails = mService.getSkuDetails(3, mContext.getPackageName(),
                    itemType, querySkus);

            if (!skuDetails.containsKey(RESPONSE_GET_SKU_DETAILS_LIST)) {
                String dataLeAk811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath811;try {throw new Exception(dataLeAk811);} catch (Exception leakErRor811) {dataLeAkPath811 = leakErRor811.getMessage();}
				android.util.Log.d("leak-811", dataLeAkPath811);
				int response = getResponseCodeFromBundle(skuDetails);
                if (response != BILLING_RESPONSE_RESULT_OK) {
                    String dataLeAk812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay812 = new String[] {"n/a", dataLeAk812};
					String dataLeAkPath812 = leakArRay812[leakArRay812.length - 1];
					android.util.Log.d("leak-812", dataLeAkPath812);
					logDebug("getSkuDetails() failed: " + getResponseDesc(response));
                    return response;
                } else {
                    String dataLeAk813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP813 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP813.put("test", new java.util.HashMap<String, String>());
					leakMaP813.get("test").put("test", dataLeAk813);
					String dataLeAkPath813 = leakMaP813.get("test").get("test");
					android.util.Log.d("leak-813", dataLeAkPath813);
					logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    return IABHELPER_BAD_RESPONSE;
                }
            }

            ArrayList<String> responseList = skuDetails.getStringArrayList(
                    RESPONSE_GET_SKU_DETAILS_LIST);

            for (String thisResponse : responseList) {
                String dataLeAk814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer814 = new StringBuffer();for (char chAr814 : dataLeAk814.toCharArray()) {leakBuFFer814.append(chAr814);}String dataLeAkPath814 = leakBuFFer814.toString();
				android.util.Log.d("leak-814", dataLeAkPath814);
				SkuDetails d = new SkuDetails(itemType, thisResponse);
                logDebug("Got sku details: " + d);
                inv.addSkuDetails(d);
            }
        }

        return BILLING_RESPONSE_RESULT_OK;
    }

    void consumeAsyncInternal(final List<Purchase> purchases,
                              final OnConsumeFinishedListener singleListener,
                              final OnConsumeMultiFinishedListener multiListener) {
        String dataLeAk815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath815;try {throw new Exception(dataLeAk815);} catch (Exception leakErRor815) {dataLeAkPath815 = leakErRor815.getMessage();}
								android.util.Log.d("leak-815", dataLeAkPath815);
		final Handler handler = new Handler();
        flagStartAsync("consume");
        (new Thread(new Runnable() {
            public void run() {
                String dataLeAk816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay816 = new String[] {"n/a", dataLeAk816};
				String dataLeAkPath816 = leakArRay816[leakArRay816.length - 1];
				android.util.Log.d("leak-816", dataLeAkPath816);
				final List<IabResult> results = new ArrayList<IabResult>();
                for (Purchase purchase : purchases) {
                    String dataLeAk817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP817 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP817.put("test", new java.util.HashMap<String, String>());
					leakMaP817.get("test").put("test", dataLeAk817);
					String dataLeAkPath817 = leakMaP817.get("test").get("test");
					android.util.Log.d("leak-817", dataLeAkPath817);
					try {
                        String dataLeAk818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer818 = new StringBuffer();for (char chAr818 : dataLeAk818.toCharArray()) {leakBuFFer818.append(chAr818);}String dataLeAkPath818 = leakBuFFer818.toString();
						android.util.Log.d("leak-818", dataLeAkPath818);
						consume(purchase);
                        results.add(new IabResult(BILLING_RESPONSE_RESULT_OK, "Successful consume of sku " + purchase.getSku()));
                    }
                    catch (IabException ex) {
                        String dataLeAk819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath819;try {throw new Exception(dataLeAk819);} catch (Exception leakErRor819) {dataLeAkPath819 = leakErRor819.getMessage();}
						android.util.Log.d("leak-819", dataLeAkPath819);
						results.add(ex.getResult());
                    }
                }

                flagEndAsync();
                if (!mDisposed && singleListener != null) {
                    String dataLeAk820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay820 = new String[] {"n/a", dataLeAk820};
					String dataLeAkPath820 = leakArRay820[leakArRay820.length - 1];
					android.util.Log.d("leak-820", dataLeAkPath820);
					handler.post(new Runnable() {
                        public void run() {
                            String dataLeAk821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP821 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP821.put("test", new java.util.HashMap<String, String>());
							leakMaP821.get("test").put("test", dataLeAk821);
							String dataLeAkPath821 = leakMaP821.get("test").get("test");
							android.util.Log.d("leak-821", dataLeAkPath821);
							singleListener.onConsumeFinished(purchases.get(0), results.get(0));
                        }
                    });
                }
                if (!mDisposed && multiListener != null) {
                    String dataLeAk822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer822 = new StringBuffer();for (char chAr822 : dataLeAk822.toCharArray()) {leakBuFFer822.append(chAr822);}String dataLeAkPath822 = leakBuFFer822.toString();
					android.util.Log.d("leak-822", dataLeAkPath822);
					handler.post(new Runnable() {
                        public void run() {
                            String dataLeAk823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath823;try {throw new Exception(dataLeAk823);} catch (Exception leakErRor823) {dataLeAkPath823 = leakErRor823.getMessage();}
							android.util.Log.d("leak-823", dataLeAkPath823);
							multiListener.onConsumeMultiFinished(purchases, results);
                        }
                    });
                }
            }
        })).start();
    }

    void logDebug(String msg) {
        String dataLeAk824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay824 = new String[] {"n/a", dataLeAk824};
		String dataLeAkPath824 = leakArRay824[leakArRay824.length - 1];
		android.util.Log.d("leak-824", dataLeAkPath824);
		if (mDebugLog) Log.d(mDebugTag, msg);
    }

    void logError(String msg) {
        String dataLeAk825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP825 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP825.put("test", new java.util.HashMap<String, String>());
		leakMaP825.get("test").put("test", dataLeAk825);
		String dataLeAkPath825 = leakMaP825.get("test").get("test");
		android.util.Log.d("leak-825", dataLeAkPath825);
		Log.e(mDebugTag, "In-app billing error: " + msg);
    }

    void logWarn(String msg) {
        String dataLeAk826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer826 = new StringBuffer();for (char chAr826 : dataLeAk826.toCharArray()) {leakBuFFer826.append(chAr826);}String dataLeAkPath826 = leakBuFFer826.toString();
		android.util.Log.d("leak-826", dataLeAkPath826);
		Log.w(mDebugTag, "In-app billing warning: " + msg);
    }
}
