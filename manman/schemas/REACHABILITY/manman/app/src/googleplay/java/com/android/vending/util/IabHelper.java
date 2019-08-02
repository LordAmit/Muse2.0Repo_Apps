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
    String dataLeAk834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk834 = android.util.Log.d("leak-834", dataLeAk834);

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
        String dataLeAk835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk835 = android.util.Log.d("leak-835", dataLeAk835);
		mContext = ctx.getApplicationContext();
        mSignatureBase64 = base64PublicKey;
        logDebug("IAB helper created.");
    }

    /**
     * Enables or disable debug logging through LogCat.
     */
    public void enableDebugLogging(boolean enable, String tag) {
        String dataLeAk836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk836 = android.util.Log.d("leak-836", dataLeAk836);
		checkNotDisposed();
        mDebugLog = enable;
        mDebugTag = tag;
    }

    public void enableDebugLogging(boolean enable) {
        String dataLeAk837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk837 = android.util.Log.d("leak-837", dataLeAk837);
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
        String dataLeAk838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk838 = android.util.Log.d("leak-838", dataLeAk838);
		// If already set up, can't do it again.
        checkNotDisposed();
        if (mSetupDone) throw new IllegalStateException("IAB helper is already set up.");

        // Connection to IAB service
        logDebug("Starting in-app billing setup.");
        mServiceConn = new ServiceConnection() {
            String dataLeAk839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk839 = android.util.Log.d("leak-839", dataLeAk839);

			@Override
            public void onServiceDisconnected(ComponentName name) {
                String dataLeAk840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk840 = android.util.Log.d("leak-840", dataLeAk840);
				logDebug("Billing service disconnected.");
                mService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                String dataLeAk841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk841 = android.util.Log.d("leak-841", dataLeAk841);
				if (mDisposed) return;
                logDebug("Billing service connected.");
                mService = IInAppBillingService.Stub.asInterface(service);
                String packageName = mContext.getPackageName();
                try {
                    String dataLeAk842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk842 = android.util.Log.d("leak-842", dataLeAk842);
					logDebug("Checking for in-app billing 3 support.");

                    // check for in-app billing v3 support
                    int response = mService.isBillingSupported(3, packageName, ITEM_TYPE_INAPP);
                    if (response != BILLING_RESPONSE_RESULT_OK) {
                        String dataLeAk843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk843 = android.util.Log.d("leak-843", dataLeAk843);
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
                        String dataLeAk844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk844 = android.util.Log.d("leak-844", dataLeAk844);
						logDebug("Subscriptions AVAILABLE.");
                        mSubscriptionsSupported = true;
                    }
                    else {
                        String dataLeAk845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk845 = android.util.Log.d("leak-845", dataLeAk845);
						logDebug("Subscriptions NOT AVAILABLE. Response: " + response);
                    }

                    mSetupDone = true;
                }
                catch (RemoteException e) {
                    String dataLeAk846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk846 = android.util.Log.d("leak-846", dataLeAk846);
					if (listener != null) {
                        String dataLeAk847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk847 = android.util.Log.d("leak-847", dataLeAk847);
						listener.onIabSetupFinished(new IabResult(IABHELPER_REMOTE_EXCEPTION,
                                "RemoteException while setting up in-app billing."));
                    }
                    e.printStackTrace();
                    return;
                }

                if (listener != null) {
                    String dataLeAk848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk848 = android.util.Log.d("leak-848", dataLeAk848);
					listener.onIabSetupFinished(new IabResult(BILLING_RESPONSE_RESULT_OK, "Setup successful."));
                }
            }
        };

        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        List<ResolveInfo> resolveInfos = mContext.getPackageManager().queryIntentServices(serviceIntent, 0);
        if (resolveInfos != null && !resolveInfos.isEmpty()) {
            String dataLeAk849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk849 = android.util.Log.d("leak-849", dataLeAk849);
			// service available to handle that Intent
            mContext.bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);
        }
        else {
            String dataLeAk850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk850 = android.util.Log.d("leak-850", dataLeAk850);
			// no service available to handle that Intent
            if (listener != null) {
                String dataLeAk851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk851 = android.util.Log.d("leak-851", dataLeAk851);
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
        String dataLeAk852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk852 = android.util.Log.d("leak-852", dataLeAk852);
		logDebug("Disposing.");
        mSetupDone = false;
        if (mServiceConn != null) {
            String dataLeAk853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk853 = android.util.Log.d("leak-853", dataLeAk853);
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
        String dataLeAk854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk854 = android.util.Log.d("leak-854", dataLeAk854);
		if (mDisposed) throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
    }

    /** Returns whether subscriptions are supported. */
    public boolean subscriptionsSupported() {
        String dataLeAk855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk855 = android.util.Log.d("leak-855", dataLeAk855);
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
        String dataLeAk856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk856 = android.util.Log.d("leak-856", dataLeAk856);
		launchPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchPurchaseFlow(Activity act, String sku, int requestCode,
                                   OnIabPurchaseFinishedListener listener, String extraData) {
        String dataLeAk857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk857 = android.util.Log.d("leak-857", dataLeAk857);
		launchPurchaseFlow(act, sku, ITEM_TYPE_INAPP, requestCode, listener, extraData);
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode,
                                               OnIabPurchaseFinishedListener listener) {
        String dataLeAk858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk858 = android.util.Log.d("leak-858", dataLeAk858);
		launchSubscriptionPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode,
                                               OnIabPurchaseFinishedListener listener, String extraData) {
        String dataLeAk859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk859 = android.util.Log.d("leak-859", dataLeAk859);
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
        String dataLeAk860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk860 = android.util.Log.d("leak-860", dataLeAk860);
		checkNotDisposed();
        checkSetupDone("launchPurchaseFlow");
        flagStartAsync("launchPurchaseFlow");
        IabResult result;

        if (itemType.equals(ITEM_TYPE_SUBS) && !mSubscriptionsSupported) {
            String dataLeAk861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk861 = android.util.Log.d("leak-861", dataLeAk861);
			IabResult r = new IabResult(IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE,
                    "Subscriptions are not available.");
            flagEndAsync();
            if (listener != null) listener.onIabPurchaseFinished(r, null);
            return;
        }

        try {
            String dataLeAk862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk862 = android.util.Log.d("leak-862", dataLeAk862);
			logDebug("Constructing buy intent for " + sku + ", item type: " + itemType);
            Bundle buyIntentBundle = mService.getBuyIntent(3, mContext.getPackageName(), sku, itemType, extraData);
            int response = getResponseCodeFromBundle(buyIntentBundle);
            if (response != BILLING_RESPONSE_RESULT_OK) {
                String dataLeAk863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk863 = android.util.Log.d("leak-863", dataLeAk863);
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
            String dataLeAk864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk864 = android.util.Log.d("leak-864", dataLeAk864);
			logError("SendIntentException while launching purchase flow for sku " + sku);
            e.printStackTrace();
            flagEndAsync();

            result = new IabResult(IABHELPER_SEND_INTENT_FAILED, "Failed to send intent.");
            if (listener != null) listener.onIabPurchaseFinished(result, null);
        }
        catch (RemoteException e) {
            String dataLeAk865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk865 = android.util.Log.d("leak-865", dataLeAk865);
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
        String dataLeAk866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk866 = android.util.Log.d("leak-866", dataLeAk866);
		IabResult result;
        if (requestCode != mRequestCode) return false;

        checkNotDisposed();
        checkSetupDone("handleActivityResult");

        // end of async purchase operation that started on launchPurchaseFlow
        flagEndAsync();

        if (data == null) {
            String dataLeAk867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk867 = android.util.Log.d("leak-867", dataLeAk867);
			logError("Null data in IAB activity result.");
            result = new IabResult(IABHELPER_BAD_RESPONSE, "Null data in IAB result");
            if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
            return true;
        }

        int responseCode = getResponseCodeFromIntent(data);
        String purchaseData = data.getStringExtra(RESPONSE_INAPP_PURCHASE_DATA);
        String dataSignature = data.getStringExtra(RESPONSE_INAPP_SIGNATURE);

        if (resultCode == Activity.RESULT_OK && responseCode == BILLING_RESPONSE_RESULT_OK) {
            String dataLeAk868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk868 = android.util.Log.d("leak-868", dataLeAk868);
			logDebug("Successful resultcode from purchase activity.");
            logDebug("Purchase data: " + purchaseData);
            logDebug("Data signature: " + dataSignature);
            logDebug("Extras: " + data.getExtras());
            logDebug("Expected item type: " + mPurchasingItemType);

            if (purchaseData == null || dataSignature == null) {
                String dataLeAk869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk869 = android.util.Log.d("leak-869", dataLeAk869);
				logError("BUG: either purchaseData or dataSignature is null.");
                logDebug("Extras: " + data.getExtras().toString());
                result = new IabResult(IABHELPER_UNKNOWN_ERROR, "IAB returned null purchaseData or dataSignature");
                if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
                return true;
            }

            Purchase purchase = null;
            try {
                String dataLeAk870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk870 = android.util.Log.d("leak-870", dataLeAk870);
				purchase = new Purchase(mPurchasingItemType, purchaseData, dataSignature);
                String sku = purchase.getSku();

                // Verify signature
                if (!Security.verifyPurchase(mSignatureBase64, purchaseData, dataSignature)) {
                    String dataLeAk871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk871 = android.util.Log.d("leak-871", dataLeAk871);
					logError("Purchase signature verification FAILED for sku " + sku);
                    result = new IabResult(IABHELPER_VERIFICATION_FAILED, "Signature verification failed for sku " + sku);
                    if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, purchase);
                    return true;
                }
                logDebug("Purchase signature successfully verified.");
            }
            catch (JSONException e) {
                String dataLeAk872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk872 = android.util.Log.d("leak-872", dataLeAk872);
				logError("Failed to parse purchase data.");
                e.printStackTrace();
                result = new IabResult(IABHELPER_BAD_RESPONSE, "Failed to parse purchase data.");
                if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
                return true;
            }

            if (mPurchaseListener != null) {
                String dataLeAk873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk873 = android.util.Log.d("leak-873", dataLeAk873);
				mPurchaseListener.onIabPurchaseFinished(new IabResult(BILLING_RESPONSE_RESULT_OK, "Success"), purchase);
            }
        }
        else if (resultCode == Activity.RESULT_OK) {
            String dataLeAk874 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk874 = android.util.Log.d("leak-874", dataLeAk874);
			// result code was OK, but in-app billing response was not OK.
            logDebug("Result code was OK but in-app billing response was not OK: " + getResponseDesc(responseCode));
            if (mPurchaseListener != null) {
                String dataLeAk875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk875 = android.util.Log.d("leak-875", dataLeAk875);
				result = new IabResult(responseCode, "Problem purchashing item.");
                mPurchaseListener.onIabPurchaseFinished(result, null);
            }
        }
        else if (resultCode == Activity.RESULT_CANCELED) {
            String dataLeAk876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk876 = android.util.Log.d("leak-876", dataLeAk876);
			logDebug("Purchase canceled - Response: " + getResponseDesc(responseCode));
            result = new IabResult(IABHELPER_USER_CANCELLED, "User canceled.");
            if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
        }
        else {
            String dataLeAk877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk877 = android.util.Log.d("leak-877", dataLeAk877);
			logError("Purchase failed. Result code: " + Integer.toString(resultCode)
                    + ". Response: " + getResponseDesc(responseCode));
            result = new IabResult(IABHELPER_UNKNOWN_PURCHASE_RESPONSE, "Unknown purchase response.");
            if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
        }
        return true;
    }

    public Inventory queryInventory(boolean querySkuDetails, List<String> moreSkus) throws IabException {
        String dataLeAk878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk878 = android.util.Log.d("leak-878", dataLeAk878);
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
        String dataLeAk879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk879 = android.util.Log.d("leak-879", dataLeAk879);
		checkNotDisposed();
        checkSetupDone("queryInventory");
        try {
            String dataLeAk880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk880 = android.util.Log.d("leak-880", dataLeAk880);
			Inventory inv = new Inventory();
            int r = queryPurchases(inv, ITEM_TYPE_INAPP);
            if (r != BILLING_RESPONSE_RESULT_OK) {
                String dataLeAk881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk881 = android.util.Log.d("leak-881", dataLeAk881);
				throw new IabException(r, "Error refreshing inventory (querying owned items).");
            }

            if (querySkuDetails) {
                String dataLeAk882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk882 = android.util.Log.d("leak-882", dataLeAk882);
				r = querySkuDetails(ITEM_TYPE_INAPP, inv, moreItemSkus);
                if (r != BILLING_RESPONSE_RESULT_OK) {
                    String dataLeAk883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk883 = android.util.Log.d("leak-883", dataLeAk883);
					throw new IabException(r, "Error refreshing inventory (querying prices of items).");
                }
            }

            // if subscriptions are supported, then also query for subscriptions
            if (mSubscriptionsSupported) {
                String dataLeAk884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk884 = android.util.Log.d("leak-884", dataLeAk884);
				r = queryPurchases(inv, ITEM_TYPE_SUBS);
                if (r != BILLING_RESPONSE_RESULT_OK) {
                    String dataLeAk885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk885 = android.util.Log.d("leak-885", dataLeAk885);
					throw new IabException(r, "Error refreshing inventory (querying owned subscriptions).");
                }

                if (querySkuDetails) {
                    String dataLeAk886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk886 = android.util.Log.d("leak-886", dataLeAk886);
					r = querySkuDetails(ITEM_TYPE_SUBS, inv, moreItemSkus);
                    if (r != BILLING_RESPONSE_RESULT_OK) {
                        String dataLeAk887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk887 = android.util.Log.d("leak-887", dataLeAk887);
						throw new IabException(r, "Error refreshing inventory (querying prices of subscriptions).");
                    }
                }
            }

            return inv;
        }
        catch (RemoteException e) {
            String dataLeAk888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk888 = android.util.Log.d("leak-888", dataLeAk888);
			throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while refreshing inventory.", e);
        }
        catch (JSONException e) {
            String dataLeAk889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk889 = android.util.Log.d("leak-889", dataLeAk889);
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
        String dataLeAk890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk890 = android.util.Log.d("leak-890", dataLeAk890);
		final Handler handler = new Handler();
        checkNotDisposed();
        checkSetupDone("queryInventory");
        flagStartAsync("refresh inventory");
        (new Thread(new Runnable() {
            String dataLeAk891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk891 = android.util.Log.d("leak-891", dataLeAk891);

			public void run() {
                String dataLeAk892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk892 = android.util.Log.d("leak-892", dataLeAk892);
				IabResult result = new IabResult(BILLING_RESPONSE_RESULT_OK, "Inventory refresh successful.");
                Inventory inv = null;
                try {
                    String dataLeAk893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk893 = android.util.Log.d("leak-893", dataLeAk893);
					inv = queryInventory(querySkuDetails, moreSkus);
                }
                catch (IabException ex) {
                    String dataLeAk894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk894 = android.util.Log.d("leak-894", dataLeAk894);
					result = ex.getResult();
                }

                flagEndAsync();

                final IabResult result_f = result;
                final Inventory inv_f = inv;
                if (!mDisposed && listener != null) {
                    String dataLeAk895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk895 = android.util.Log.d("leak-895", dataLeAk895);
					handler.post(new Runnable() {
                        String dataLeAk896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk896 = android.util.Log.d("leak-896", dataLeAk896);

						public void run() {
                            String dataLeAk897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk897 = android.util.Log.d("leak-897", dataLeAk897);
							listener.onQueryInventoryFinished(result_f, inv_f);
                        }
                    });
                }
            }
        })).start();
    }

    public void queryInventoryAsync(QueryInventoryFinishedListener listener) {
        String dataLeAk898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk898 = android.util.Log.d("leak-898", dataLeAk898);
		queryInventoryAsync(true, null, listener);
    }

    public void queryInventoryAsync(boolean querySkuDetails, QueryInventoryFinishedListener listener) {
        String dataLeAk899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk899 = android.util.Log.d("leak-899", dataLeAk899);
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
        String dataLeAk900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk900 = android.util.Log.d("leak-900", dataLeAk900);
		checkNotDisposed();
        checkSetupDone("consume");

        if (!itemInfo.mItemType.equals(ITEM_TYPE_INAPP)) {
            String dataLeAk901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk901 = android.util.Log.d("leak-901", dataLeAk901);
			throw new IabException(IABHELPER_INVALID_CONSUMPTION,
                    "Items of type '" + itemInfo.mItemType + "' can't be consumed.");
        }

        try {
            String dataLeAk902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk902 = android.util.Log.d("leak-902", dataLeAk902);
			String token = itemInfo.getToken();
            String sku = itemInfo.getSku();
            if (token == null || token.equals("")) {
                String dataLeAk903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk903 = android.util.Log.d("leak-903", dataLeAk903);
				logError("Can't consume "+ sku + ". No token.");
                throw new IabException(IABHELPER_MISSING_TOKEN, "PurchaseInfo is missing token for sku: "
                        + sku + " " + itemInfo);
            }

            logDebug("Consuming sku: " + sku + ", token: " + token);
            int response = mService.consumePurchase(3, mContext.getPackageName(), token);
            if (response == BILLING_RESPONSE_RESULT_OK) {
                String dataLeAk904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk904 = android.util.Log.d("leak-904", dataLeAk904);
				logDebug("Successfully consumed sku: " + sku);
            }
            else {
                String dataLeAk905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk905 = android.util.Log.d("leak-905", dataLeAk905);
				logDebug("Error consuming consuming sku " + sku + ". " + getResponseDesc(response));
                throw new IabException(response, "Error consuming sku " + sku);
            }
        }
        catch (RemoteException e) {
            String dataLeAk906 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk906 = android.util.Log.d("leak-906", dataLeAk906);
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
        String dataLeAk907 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk907 = android.util.Log.d("leak-907", dataLeAk907);
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
        String dataLeAk908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk908 = android.util.Log.d("leak-908", dataLeAk908);
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
        String dataLeAk909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk909 = android.util.Log.d("leak-909", dataLeAk909);
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
            String dataLeAk910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk910 = android.util.Log.d("leak-910", dataLeAk910);
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
        String dataLeAk911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk911 = android.util.Log.d("leak-911", dataLeAk911);
		if (!mSetupDone) {
            String dataLeAk912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk912 = android.util.Log.d("leak-912", dataLeAk912);
			logError("Illegal state for operation (" + operation + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + operation);
        }
    }

    // Workaround to bug where sometimes response codes come as Long instead of Integer
    int getResponseCodeFromBundle(Bundle b) {
        String dataLeAk913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk913 = android.util.Log.d("leak-913", dataLeAk913);
		Object o = b.get(RESPONSE_CODE);
        if (o == null) {
            String dataLeAk914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk914 = android.util.Log.d("leak-914", dataLeAk914);
			logDebug("Bundle with null response code, assuming OK (known issue)");
            return BILLING_RESPONSE_RESULT_OK;
        }
        else if (o instanceof Integer) return ((Integer)o).intValue();
        else if (o instanceof Long) return (int)((Long)o).longValue();
        else {
            String dataLeAk915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk915 = android.util.Log.d("leak-915", dataLeAk915);
			logError("Unexpected type for bundle response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + o.getClass().getName());
        }
    }

    // Workaround to bug where sometimes response codes come as Long instead of Integer
    int getResponseCodeFromIntent(Intent i) {
        String dataLeAk916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk916 = android.util.Log.d("leak-916", dataLeAk916);
		Object o = i.getExtras().get(RESPONSE_CODE);
        if (o == null) {
            String dataLeAk917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk917 = android.util.Log.d("leak-917", dataLeAk917);
			logError("Intent with no response code, assuming OK (known issue)");
            return BILLING_RESPONSE_RESULT_OK;
        }
        else if (o instanceof Integer) return ((Integer)o).intValue();
        else if (o instanceof Long) return (int)((Long)o).longValue();
        else {
            String dataLeAk918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk918 = android.util.Log.d("leak-918", dataLeAk918);
			logError("Unexpected type for intent response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + o.getClass().getName());
        }
    }

    void flagStartAsync(String operation) {
        String dataLeAk919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk919 = android.util.Log.d("leak-919", dataLeAk919);
		if (mAsyncInProgress) throw new IllegalStateException("Can't start async operation (" +
                operation + ") because another async operation(" + mAsyncOperation + ") is in progress.");
        mAsyncOperation = operation;
        mAsyncInProgress = true;
        logDebug("Starting async operation: " + operation);
    }

    public void flagEndAsync() {
        String dataLeAk920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk920 = android.util.Log.d("leak-920", dataLeAk920);
		logDebug("Ending async operation: " + mAsyncOperation);
        mAsyncOperation = "";
        mAsyncInProgress = false;
    }


    int queryPurchases(Inventory inv, String itemType) throws JSONException, RemoteException {
        String dataLeAk921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk921 = android.util.Log.d("leak-921", dataLeAk921);
		// Query purchases
        logDebug("Querying owned items, item type: " + itemType);
        logDebug("Package name: " + mContext.getPackageName());
        boolean verificationFailed = false;
        String continueToken = null;

        do {
            String dataLeAk922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk922 = android.util.Log.d("leak-922", dataLeAk922);
			logDebug("Calling getPurchases with continuation token: " + continueToken);
            Bundle ownedItems = mService.getPurchases(3, mContext.getPackageName(),
                    itemType, continueToken);

            int response = getResponseCodeFromBundle(ownedItems);
            logDebug("Owned items response: " + String.valueOf(response));
            if (response != BILLING_RESPONSE_RESULT_OK) {
                String dataLeAk923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk923 = android.util.Log.d("leak-923", dataLeAk923);
				logDebug("getPurchases() failed: " + getResponseDesc(response));
                return response;
            }
            if (!ownedItems.containsKey(RESPONSE_INAPP_ITEM_LIST)
                    || !ownedItems.containsKey(RESPONSE_INAPP_PURCHASE_DATA_LIST)
                    || !ownedItems.containsKey(RESPONSE_INAPP_SIGNATURE_LIST)) {
                String dataLeAk924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk924 = android.util.Log.d("leak-924", dataLeAk924);
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
                String dataLeAk925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk925 = android.util.Log.d("leak-925", dataLeAk925);
				String purchaseData = purchaseDataList.get(i);
                String signature = signatureList.get(i);
                String sku = ownedSkus.get(i);
                if (Security.verifyPurchase(mSignatureBase64, purchaseData, signature)) {
                    String dataLeAk926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk926 = android.util.Log.d("leak-926", dataLeAk926);
					logDebug("Sku is owned: " + sku);
                    Purchase purchase = new Purchase(itemType, purchaseData, signature);

                    if (TextUtils.isEmpty(purchase.getToken())) {
                        String dataLeAk927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk927 = android.util.Log.d("leak-927", dataLeAk927);
						logWarn("BUG: empty/null token!");
                        logDebug("Purchase data: " + purchaseData);
                    }

                    // Record ownership and token
                    inv.addPurchase(purchase);
                }
                else {
                    String dataLeAk928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk928 = android.util.Log.d("leak-928", dataLeAk928);
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
        String dataLeAk929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk929 = android.util.Log.d("leak-929", dataLeAk929);
		logDebug("Querying SKU details.");
        ArrayList<String> skuList = new ArrayList<String>();
        skuList.addAll(inv.getAllOwnedSkus(itemType));
        if (moreSkus != null) {
            String dataLeAk930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk930 = android.util.Log.d("leak-930", dataLeAk930);
			for (String sku : moreSkus) {
                String dataLeAk931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk931 = android.util.Log.d("leak-931", dataLeAk931);
				if (!skuList.contains(sku)) {
                    String dataLeAk932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk932 = android.util.Log.d("leak-932", dataLeAk932);
					skuList.add(sku);
                }
            }
        }

        if (skuList.size() == 0) {
            String dataLeAk933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk933 = android.util.Log.d("leak-933", dataLeAk933);
			logDebug("queryPrices: nothing to do because there are no SKUs.");
            return BILLING_RESPONSE_RESULT_OK;
        }

        // Split the sku list in blocks of no more than 20 elements.
        ArrayList<ArrayList<String>> packs = new ArrayList<ArrayList<String>>();
        ArrayList<String> tempList;
        int n = skuList.size() / 20;
        int mod = skuList.size() % 20;
        for (int i = 0; i < n; i++) {
            String dataLeAk934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk934 = android.util.Log.d("leak-934", dataLeAk934);
			tempList = new ArrayList<String>();
            for (String s : skuList.subList(i * 20, i * 20 + 20)) {
                String dataLeAk935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk935 = android.util.Log.d("leak-935", dataLeAk935);
				tempList.add(s);
            }
            packs.add(tempList);
        }
        if (mod != 0) {
            String dataLeAk936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk936 = android.util.Log.d("leak-936", dataLeAk936);
			tempList = new ArrayList<String>();
            for (String s : skuList.subList(n * 20, n * 20 + mod)) {
                String dataLeAk937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk937 = android.util.Log.d("leak-937", dataLeAk937);
				tempList.add(s);
            }
            packs.add(tempList);
        }

        for (ArrayList<String> skuPartList : packs) {
            String dataLeAk938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk938 = android.util.Log.d("leak-938", dataLeAk938);
			Bundle querySkus = new Bundle();
            querySkus.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, skuPartList);
            Bundle skuDetails = mService.getSkuDetails(3, mContext.getPackageName(),
                    itemType, querySkus);

            if (!skuDetails.containsKey(RESPONSE_GET_SKU_DETAILS_LIST)) {
                String dataLeAk939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk939 = android.util.Log.d("leak-939", dataLeAk939);
				int response = getResponseCodeFromBundle(skuDetails);
                if (response != BILLING_RESPONSE_RESULT_OK) {
                    String dataLeAk940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk940 = android.util.Log.d("leak-940", dataLeAk940);
					logDebug("getSkuDetails() failed: " + getResponseDesc(response));
                    return response;
                } else {
                    String dataLeAk941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk941 = android.util.Log.d("leak-941", dataLeAk941);
					logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    return IABHELPER_BAD_RESPONSE;
                }
            }

            ArrayList<String> responseList = skuDetails.getStringArrayList(
                    RESPONSE_GET_SKU_DETAILS_LIST);

            for (String thisResponse : responseList) {
                String dataLeAk942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk942 = android.util.Log.d("leak-942", dataLeAk942);
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
        String dataLeAk943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk943 = android.util.Log.d("leak-943", dataLeAk943);
		final Handler handler = new Handler();
        flagStartAsync("consume");
        (new Thread(new Runnable() {
            String dataLeAk944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk944 = android.util.Log.d("leak-944", dataLeAk944);

			public void run() {
                String dataLeAk945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk945 = android.util.Log.d("leak-945", dataLeAk945);
				final List<IabResult> results = new ArrayList<IabResult>();
                for (Purchase purchase : purchases) {
                    String dataLeAk946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk946 = android.util.Log.d("leak-946", dataLeAk946);
					try {
                        String dataLeAk947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk947 = android.util.Log.d("leak-947", dataLeAk947);
						consume(purchase);
                        results.add(new IabResult(BILLING_RESPONSE_RESULT_OK, "Successful consume of sku " + purchase.getSku()));
                    }
                    catch (IabException ex) {
                        String dataLeAk948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk948 = android.util.Log.d("leak-948", dataLeAk948);
						results.add(ex.getResult());
                    }
                }

                flagEndAsync();
                if (!mDisposed && singleListener != null) {
                    String dataLeAk949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk949 = android.util.Log.d("leak-949", dataLeAk949);
					handler.post(new Runnable() {
                        String dataLeAk950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk950 = android.util.Log.d("leak-950", dataLeAk950);

						public void run() {
                            String dataLeAk951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk951 = android.util.Log.d("leak-951", dataLeAk951);
							singleListener.onConsumeFinished(purchases.get(0), results.get(0));
                        }
                    });
                }
                if (!mDisposed && multiListener != null) {
                    String dataLeAk952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk952 = android.util.Log.d("leak-952", dataLeAk952);
					handler.post(new Runnable() {
                        String dataLeAk953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk953 = android.util.Log.d("leak-953", dataLeAk953);

						public void run() {
                            String dataLeAk954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk954 = android.util.Log.d("leak-954", dataLeAk954);
							multiListener.onConsumeMultiFinished(purchases, results);
                        }
                    });
                }
            }
        })).start();
    }

    void logDebug(String msg) {
        String dataLeAk955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk955 = android.util.Log.d("leak-955", dataLeAk955);
		if (mDebugLog) Log.d(mDebugTag, msg);
    }

    void logError(String msg) {
        String dataLeAk956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk956 = android.util.Log.d("leak-956", dataLeAk956);
		Log.e(mDebugTag, "In-app billing error: " + msg);
    }

    void logWarn(String msg) {
        String dataLeAk957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk957 = android.util.Log.d("leak-957", dataLeAk957);
		Log.w(mDebugTag, "In-app billing warning: " + msg);
    }
}
