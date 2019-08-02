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
    final String dataLeAk633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk622 = "";

	String dataLeAk621 = "";

	String dataLeAk620 = "";

	String dataLeAk616 = "";

	String dataLeAk615 = "";

	String dataLeAk614 = "";

	String dataLeAk613 = "";

	String dataLeAk612 = "";

	String dataLeAk611 = "";

	String dataLeAk610 = "";

	String dataLeAk609 = "";

	String dataLeAk608 = "";

	String dataLeAk607 = "";

	String dataLeAk606 = "";

	String dataLeAk605 = "";

	String dataLeAk604 = "";

	String dataLeAk601 = "";

	String dataLeAk600 = "";

	String dataLeAk599 = "";

	String dataLeAk598 = "";

	String dataLeAk597 = "";

	String dataLeAk596 = "";

	String dataLeAk595 = "";

	String dataLeAk594 = "";

	String dataLeAk593 = "";

	String dataLeAk592 = "";

	String dataLeAk591 = "";

	String dataLeAk590 = "";

	String dataLeAk587 = "";

	String dataLeAk586 = "";

	String dataLeAk585 = "";

	String dataLeAk584 = "";

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
        dataLeAk584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-0", dataLeAk584);
		android.util.Log.d("leak-585-0", dataLeAk585);
		android.util.Log.d("leak-586-0", dataLeAk586);
		android.util.Log.d("leak-587-0", dataLeAk587);
		android.util.Log.d("leak-590-0", dataLeAk590);
		android.util.Log.d("leak-591-0", dataLeAk591);
		android.util.Log.d("leak-592-0", dataLeAk592);
		android.util.Log.d("leak-593-0", dataLeAk593);
		android.util.Log.d("leak-594-0", dataLeAk594);
		android.util.Log.d("leak-595-0", dataLeAk595);
		android.util.Log.d("leak-596-0", dataLeAk596);
		android.util.Log.d("leak-597-0", dataLeAk597);
		android.util.Log.d("leak-598-0", dataLeAk598);
		android.util.Log.d("leak-599-0", dataLeAk599);
		android.util.Log.d("leak-600-0", dataLeAk600);
		android.util.Log.d("leak-601-0", dataLeAk601);
		android.util.Log.d("leak-604-0", dataLeAk604);
		android.util.Log.d("leak-605-0", dataLeAk605);
		android.util.Log.d("leak-606-0", dataLeAk606);
		android.util.Log.d("leak-607-0", dataLeAk607);
		android.util.Log.d("leak-608-0", dataLeAk608);
		android.util.Log.d("leak-609-0", dataLeAk609);
		android.util.Log.d("leak-610-0", dataLeAk610);
		android.util.Log.d("leak-611-0", dataLeAk611);
		android.util.Log.d("leak-612-0", dataLeAk612);
		android.util.Log.d("leak-613-0", dataLeAk613);
		android.util.Log.d("leak-614-0", dataLeAk614);
		android.util.Log.d("leak-615-0", dataLeAk615);
		android.util.Log.d("leak-616-0", dataLeAk616);
		android.util.Log.d("leak-620-0", dataLeAk620);
		android.util.Log.d("leak-621-0", dataLeAk621);
		android.util.Log.d("leak-622-0", dataLeAk622);
		mContext = ctx.getApplicationContext();
        mSignatureBase64 = base64PublicKey;
        logDebug("IAB helper created.");
    }

    /**
     * Enables or disable debug logging through LogCat.
     */
    public void enableDebugLogging(boolean enable, String tag) {
        dataLeAk585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-1", dataLeAk584);
		android.util.Log.d("leak-585-1", dataLeAk585);
		android.util.Log.d("leak-586-1", dataLeAk586);
		android.util.Log.d("leak-587-1", dataLeAk587);
		android.util.Log.d("leak-590-1", dataLeAk590);
		android.util.Log.d("leak-591-1", dataLeAk591);
		android.util.Log.d("leak-592-1", dataLeAk592);
		android.util.Log.d("leak-593-1", dataLeAk593);
		android.util.Log.d("leak-594-1", dataLeAk594);
		android.util.Log.d("leak-595-1", dataLeAk595);
		android.util.Log.d("leak-596-1", dataLeAk596);
		android.util.Log.d("leak-597-1", dataLeAk597);
		android.util.Log.d("leak-598-1", dataLeAk598);
		android.util.Log.d("leak-599-1", dataLeAk599);
		android.util.Log.d("leak-600-1", dataLeAk600);
		android.util.Log.d("leak-601-1", dataLeAk601);
		android.util.Log.d("leak-604-1", dataLeAk604);
		android.util.Log.d("leak-605-1", dataLeAk605);
		android.util.Log.d("leak-606-1", dataLeAk606);
		android.util.Log.d("leak-607-1", dataLeAk607);
		android.util.Log.d("leak-608-1", dataLeAk608);
		android.util.Log.d("leak-609-1", dataLeAk609);
		android.util.Log.d("leak-610-1", dataLeAk610);
		android.util.Log.d("leak-611-1", dataLeAk611);
		android.util.Log.d("leak-612-1", dataLeAk612);
		android.util.Log.d("leak-613-1", dataLeAk613);
		android.util.Log.d("leak-614-1", dataLeAk614);
		android.util.Log.d("leak-615-1", dataLeAk615);
		android.util.Log.d("leak-616-1", dataLeAk616);
		android.util.Log.d("leak-620-1", dataLeAk620);
		android.util.Log.d("leak-621-1", dataLeAk621);
		android.util.Log.d("leak-622-1", dataLeAk622);
		checkNotDisposed();
        mDebugLog = enable;
        mDebugTag = tag;
    }

    public void enableDebugLogging(boolean enable) {
        dataLeAk586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-2", dataLeAk584);
		android.util.Log.d("leak-585-2", dataLeAk585);
		android.util.Log.d("leak-586-2", dataLeAk586);
		android.util.Log.d("leak-587-2", dataLeAk587);
		android.util.Log.d("leak-590-2", dataLeAk590);
		android.util.Log.d("leak-591-2", dataLeAk591);
		android.util.Log.d("leak-592-2", dataLeAk592);
		android.util.Log.d("leak-593-2", dataLeAk593);
		android.util.Log.d("leak-594-2", dataLeAk594);
		android.util.Log.d("leak-595-2", dataLeAk595);
		android.util.Log.d("leak-596-2", dataLeAk596);
		android.util.Log.d("leak-597-2", dataLeAk597);
		android.util.Log.d("leak-598-2", dataLeAk598);
		android.util.Log.d("leak-599-2", dataLeAk599);
		android.util.Log.d("leak-600-2", dataLeAk600);
		android.util.Log.d("leak-601-2", dataLeAk601);
		android.util.Log.d("leak-604-2", dataLeAk604);
		android.util.Log.d("leak-605-2", dataLeAk605);
		android.util.Log.d("leak-606-2", dataLeAk606);
		android.util.Log.d("leak-607-2", dataLeAk607);
		android.util.Log.d("leak-608-2", dataLeAk608);
		android.util.Log.d("leak-609-2", dataLeAk609);
		android.util.Log.d("leak-610-2", dataLeAk610);
		android.util.Log.d("leak-611-2", dataLeAk611);
		android.util.Log.d("leak-612-2", dataLeAk612);
		android.util.Log.d("leak-613-2", dataLeAk613);
		android.util.Log.d("leak-614-2", dataLeAk614);
		android.util.Log.d("leak-615-2", dataLeAk615);
		android.util.Log.d("leak-616-2", dataLeAk616);
		android.util.Log.d("leak-620-2", dataLeAk620);
		android.util.Log.d("leak-621-2", dataLeAk621);
		android.util.Log.d("leak-622-2", dataLeAk622);
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
        dataLeAk587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-3", dataLeAk584);
		android.util.Log.d("leak-585-3", dataLeAk585);
		android.util.Log.d("leak-586-3", dataLeAk586);
		android.util.Log.d("leak-587-3", dataLeAk587);
		android.util.Log.d("leak-590-3", dataLeAk590);
		android.util.Log.d("leak-591-3", dataLeAk591);
		android.util.Log.d("leak-592-3", dataLeAk592);
		android.util.Log.d("leak-593-3", dataLeAk593);
		android.util.Log.d("leak-594-3", dataLeAk594);
		android.util.Log.d("leak-595-3", dataLeAk595);
		android.util.Log.d("leak-596-3", dataLeAk596);
		android.util.Log.d("leak-597-3", dataLeAk597);
		android.util.Log.d("leak-598-3", dataLeAk598);
		android.util.Log.d("leak-599-3", dataLeAk599);
		android.util.Log.d("leak-600-3", dataLeAk600);
		android.util.Log.d("leak-601-3", dataLeAk601);
		android.util.Log.d("leak-604-3", dataLeAk604);
		android.util.Log.d("leak-605-3", dataLeAk605);
		android.util.Log.d("leak-606-3", dataLeAk606);
		android.util.Log.d("leak-607-3", dataLeAk607);
		android.util.Log.d("leak-608-3", dataLeAk608);
		android.util.Log.d("leak-609-3", dataLeAk609);
		android.util.Log.d("leak-610-3", dataLeAk610);
		android.util.Log.d("leak-611-3", dataLeAk611);
		android.util.Log.d("leak-612-3", dataLeAk612);
		android.util.Log.d("leak-613-3", dataLeAk613);
		android.util.Log.d("leak-614-3", dataLeAk614);
		android.util.Log.d("leak-615-3", dataLeAk615);
		android.util.Log.d("leak-616-3", dataLeAk616);
		android.util.Log.d("leak-620-3", dataLeAk620);
		android.util.Log.d("leak-621-3", dataLeAk621);
		android.util.Log.d("leak-622-3", dataLeAk622);
		// If already set up, can't do it again.
        checkNotDisposed();
        if (mSetupDone) throw new IllegalStateException("IAB helper is already set up.");

        // Connection to IAB service
        logDebug("Starting in-app billing setup.");
        mServiceConn = new ServiceConnection() {
            String dataLeAk589 = "";

			String dataLeAk588 = "";

			@Override
            public void onServiceDisconnected(ComponentName name) {
                dataLeAk588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-624-0", dataLeAk624);
				android.util.Log.d("leak-588-0", dataLeAk588);
				android.util.Log.d("leak-589-0", dataLeAk589);
				logDebug("Billing service disconnected.");
                mService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                dataLeAk589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-625-0", dataLeAk625);
				android.util.Log.d("leak-588-1", dataLeAk588);
				android.util.Log.d("leak-589-1", dataLeAk589);
				if (mDisposed) return;
                logDebug("Billing service connected.");
                mService = IInAppBillingService.Stub.asInterface(service);
                String packageName = mContext.getPackageName();
                try {
                    logDebug("Checking for in-app billing 3 support.");

                    // check for in-app billing v3 support
                    int response = mService.isBillingSupported(3, packageName, ITEM_TYPE_INAPP);
                    if (response != BILLING_RESPONSE_RESULT_OK) {
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
                        logDebug("Subscriptions AVAILABLE.");
                        mSubscriptionsSupported = true;
                    }
                    else {
                        logDebug("Subscriptions NOT AVAILABLE. Response: " + response);
                    }

                    mSetupDone = true;
                }
                catch (RemoteException e) {
                    if (listener != null) {
                        listener.onIabSetupFinished(new IabResult(IABHELPER_REMOTE_EXCEPTION,
                                "RemoteException while setting up in-app billing."));
                    }
                    e.printStackTrace();
                    return;
                }

                if (listener != null) {
                    listener.onIabSetupFinished(new IabResult(BILLING_RESPONSE_RESULT_OK, "Setup successful."));
                }
            }
        };

        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        List<ResolveInfo> resolveInfos = mContext.getPackageManager().queryIntentServices(serviceIntent, 0);
        if (resolveInfos != null && !resolveInfos.isEmpty()) {
            // service available to handle that Intent
            mContext.bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);
        }
        else {
            // no service available to handle that Intent
            if (listener != null) {
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
        dataLeAk590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-4", dataLeAk584);
		android.util.Log.d("leak-585-4", dataLeAk585);
		android.util.Log.d("leak-586-4", dataLeAk586);
		android.util.Log.d("leak-587-4", dataLeAk587);
		android.util.Log.d("leak-590-4", dataLeAk590);
		android.util.Log.d("leak-591-4", dataLeAk591);
		android.util.Log.d("leak-592-4", dataLeAk592);
		android.util.Log.d("leak-593-4", dataLeAk593);
		android.util.Log.d("leak-594-4", dataLeAk594);
		android.util.Log.d("leak-595-4", dataLeAk595);
		android.util.Log.d("leak-596-4", dataLeAk596);
		android.util.Log.d("leak-597-4", dataLeAk597);
		android.util.Log.d("leak-598-4", dataLeAk598);
		android.util.Log.d("leak-599-4", dataLeAk599);
		android.util.Log.d("leak-600-4", dataLeAk600);
		android.util.Log.d("leak-601-4", dataLeAk601);
		android.util.Log.d("leak-604-4", dataLeAk604);
		android.util.Log.d("leak-605-4", dataLeAk605);
		android.util.Log.d("leak-606-4", dataLeAk606);
		android.util.Log.d("leak-607-4", dataLeAk607);
		android.util.Log.d("leak-608-4", dataLeAk608);
		android.util.Log.d("leak-609-4", dataLeAk609);
		android.util.Log.d("leak-610-4", dataLeAk610);
		android.util.Log.d("leak-611-4", dataLeAk611);
		android.util.Log.d("leak-612-4", dataLeAk612);
		android.util.Log.d("leak-613-4", dataLeAk613);
		android.util.Log.d("leak-614-4", dataLeAk614);
		android.util.Log.d("leak-615-4", dataLeAk615);
		android.util.Log.d("leak-616-4", dataLeAk616);
		android.util.Log.d("leak-620-4", dataLeAk620);
		android.util.Log.d("leak-621-4", dataLeAk621);
		android.util.Log.d("leak-622-4", dataLeAk622);
		logDebug("Disposing.");
        mSetupDone = false;
        if (mServiceConn != null) {
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
        dataLeAk591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-5", dataLeAk584);
		android.util.Log.d("leak-585-5", dataLeAk585);
		android.util.Log.d("leak-586-5", dataLeAk586);
		android.util.Log.d("leak-587-5", dataLeAk587);
		android.util.Log.d("leak-590-5", dataLeAk590);
		android.util.Log.d("leak-591-5", dataLeAk591);
		android.util.Log.d("leak-592-5", dataLeAk592);
		android.util.Log.d("leak-593-5", dataLeAk593);
		android.util.Log.d("leak-594-5", dataLeAk594);
		android.util.Log.d("leak-595-5", dataLeAk595);
		android.util.Log.d("leak-596-5", dataLeAk596);
		android.util.Log.d("leak-597-5", dataLeAk597);
		android.util.Log.d("leak-598-5", dataLeAk598);
		android.util.Log.d("leak-599-5", dataLeAk599);
		android.util.Log.d("leak-600-5", dataLeAk600);
		android.util.Log.d("leak-601-5", dataLeAk601);
		android.util.Log.d("leak-604-5", dataLeAk604);
		android.util.Log.d("leak-605-5", dataLeAk605);
		android.util.Log.d("leak-606-5", dataLeAk606);
		android.util.Log.d("leak-607-5", dataLeAk607);
		android.util.Log.d("leak-608-5", dataLeAk608);
		android.util.Log.d("leak-609-5", dataLeAk609);
		android.util.Log.d("leak-610-5", dataLeAk610);
		android.util.Log.d("leak-611-5", dataLeAk611);
		android.util.Log.d("leak-612-5", dataLeAk612);
		android.util.Log.d("leak-613-5", dataLeAk613);
		android.util.Log.d("leak-614-5", dataLeAk614);
		android.util.Log.d("leak-615-5", dataLeAk615);
		android.util.Log.d("leak-616-5", dataLeAk616);
		android.util.Log.d("leak-620-5", dataLeAk620);
		android.util.Log.d("leak-621-5", dataLeAk621);
		android.util.Log.d("leak-622-5", dataLeAk622);
		if (mDisposed) throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
    }

    /** Returns whether subscriptions are supported. */
    public boolean subscriptionsSupported() {
        dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-6", dataLeAk584);
		android.util.Log.d("leak-585-6", dataLeAk585);
		android.util.Log.d("leak-586-6", dataLeAk586);
		android.util.Log.d("leak-587-6", dataLeAk587);
		android.util.Log.d("leak-590-6", dataLeAk590);
		android.util.Log.d("leak-591-6", dataLeAk591);
		android.util.Log.d("leak-592-6", dataLeAk592);
		android.util.Log.d("leak-593-6", dataLeAk593);
		android.util.Log.d("leak-594-6", dataLeAk594);
		android.util.Log.d("leak-595-6", dataLeAk595);
		android.util.Log.d("leak-596-6", dataLeAk596);
		android.util.Log.d("leak-597-6", dataLeAk597);
		android.util.Log.d("leak-598-6", dataLeAk598);
		android.util.Log.d("leak-599-6", dataLeAk599);
		android.util.Log.d("leak-600-6", dataLeAk600);
		android.util.Log.d("leak-601-6", dataLeAk601);
		android.util.Log.d("leak-604-6", dataLeAk604);
		android.util.Log.d("leak-605-6", dataLeAk605);
		android.util.Log.d("leak-606-6", dataLeAk606);
		android.util.Log.d("leak-607-6", dataLeAk607);
		android.util.Log.d("leak-608-6", dataLeAk608);
		android.util.Log.d("leak-609-6", dataLeAk609);
		android.util.Log.d("leak-610-6", dataLeAk610);
		android.util.Log.d("leak-611-6", dataLeAk611);
		android.util.Log.d("leak-612-6", dataLeAk612);
		android.util.Log.d("leak-613-6", dataLeAk613);
		android.util.Log.d("leak-614-6", dataLeAk614);
		android.util.Log.d("leak-615-6", dataLeAk615);
		android.util.Log.d("leak-616-6", dataLeAk616);
		android.util.Log.d("leak-620-6", dataLeAk620);
		android.util.Log.d("leak-621-6", dataLeAk621);
		android.util.Log.d("leak-622-6", dataLeAk622);
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
        dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-7", dataLeAk584);
		android.util.Log.d("leak-585-7", dataLeAk585);
		android.util.Log.d("leak-586-7", dataLeAk586);
		android.util.Log.d("leak-587-7", dataLeAk587);
		android.util.Log.d("leak-590-7", dataLeAk590);
		android.util.Log.d("leak-591-7", dataLeAk591);
		android.util.Log.d("leak-592-7", dataLeAk592);
		android.util.Log.d("leak-593-7", dataLeAk593);
		android.util.Log.d("leak-594-7", dataLeAk594);
		android.util.Log.d("leak-595-7", dataLeAk595);
		android.util.Log.d("leak-596-7", dataLeAk596);
		android.util.Log.d("leak-597-7", dataLeAk597);
		android.util.Log.d("leak-598-7", dataLeAk598);
		android.util.Log.d("leak-599-7", dataLeAk599);
		android.util.Log.d("leak-600-7", dataLeAk600);
		android.util.Log.d("leak-601-7", dataLeAk601);
		android.util.Log.d("leak-604-7", dataLeAk604);
		android.util.Log.d("leak-605-7", dataLeAk605);
		android.util.Log.d("leak-606-7", dataLeAk606);
		android.util.Log.d("leak-607-7", dataLeAk607);
		android.util.Log.d("leak-608-7", dataLeAk608);
		android.util.Log.d("leak-609-7", dataLeAk609);
		android.util.Log.d("leak-610-7", dataLeAk610);
		android.util.Log.d("leak-611-7", dataLeAk611);
		android.util.Log.d("leak-612-7", dataLeAk612);
		android.util.Log.d("leak-613-7", dataLeAk613);
		android.util.Log.d("leak-614-7", dataLeAk614);
		android.util.Log.d("leak-615-7", dataLeAk615);
		android.util.Log.d("leak-616-7", dataLeAk616);
		android.util.Log.d("leak-620-7", dataLeAk620);
		android.util.Log.d("leak-621-7", dataLeAk621);
		android.util.Log.d("leak-622-7", dataLeAk622);
		launchPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchPurchaseFlow(Activity act, String sku, int requestCode,
                                   OnIabPurchaseFinishedListener listener, String extraData) {
        dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-8", dataLeAk584);
		android.util.Log.d("leak-585-8", dataLeAk585);
		android.util.Log.d("leak-586-8", dataLeAk586);
		android.util.Log.d("leak-587-8", dataLeAk587);
		android.util.Log.d("leak-590-8", dataLeAk590);
		android.util.Log.d("leak-591-8", dataLeAk591);
		android.util.Log.d("leak-592-8", dataLeAk592);
		android.util.Log.d("leak-593-8", dataLeAk593);
		android.util.Log.d("leak-594-8", dataLeAk594);
		android.util.Log.d("leak-595-8", dataLeAk595);
		android.util.Log.d("leak-596-8", dataLeAk596);
		android.util.Log.d("leak-597-8", dataLeAk597);
		android.util.Log.d("leak-598-8", dataLeAk598);
		android.util.Log.d("leak-599-8", dataLeAk599);
		android.util.Log.d("leak-600-8", dataLeAk600);
		android.util.Log.d("leak-601-8", dataLeAk601);
		android.util.Log.d("leak-604-8", dataLeAk604);
		android.util.Log.d("leak-605-8", dataLeAk605);
		android.util.Log.d("leak-606-8", dataLeAk606);
		android.util.Log.d("leak-607-8", dataLeAk607);
		android.util.Log.d("leak-608-8", dataLeAk608);
		android.util.Log.d("leak-609-8", dataLeAk609);
		android.util.Log.d("leak-610-8", dataLeAk610);
		android.util.Log.d("leak-611-8", dataLeAk611);
		android.util.Log.d("leak-612-8", dataLeAk612);
		android.util.Log.d("leak-613-8", dataLeAk613);
		android.util.Log.d("leak-614-8", dataLeAk614);
		android.util.Log.d("leak-615-8", dataLeAk615);
		android.util.Log.d("leak-616-8", dataLeAk616);
		android.util.Log.d("leak-620-8", dataLeAk620);
		android.util.Log.d("leak-621-8", dataLeAk621);
		android.util.Log.d("leak-622-8", dataLeAk622);
		launchPurchaseFlow(act, sku, ITEM_TYPE_INAPP, requestCode, listener, extraData);
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode,
                                               OnIabPurchaseFinishedListener listener) {
        dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-9", dataLeAk584);
		android.util.Log.d("leak-585-9", dataLeAk585);
		android.util.Log.d("leak-586-9", dataLeAk586);
		android.util.Log.d("leak-587-9", dataLeAk587);
		android.util.Log.d("leak-590-9", dataLeAk590);
		android.util.Log.d("leak-591-9", dataLeAk591);
		android.util.Log.d("leak-592-9", dataLeAk592);
		android.util.Log.d("leak-593-9", dataLeAk593);
		android.util.Log.d("leak-594-9", dataLeAk594);
		android.util.Log.d("leak-595-9", dataLeAk595);
		android.util.Log.d("leak-596-9", dataLeAk596);
		android.util.Log.d("leak-597-9", dataLeAk597);
		android.util.Log.d("leak-598-9", dataLeAk598);
		android.util.Log.d("leak-599-9", dataLeAk599);
		android.util.Log.d("leak-600-9", dataLeAk600);
		android.util.Log.d("leak-601-9", dataLeAk601);
		android.util.Log.d("leak-604-9", dataLeAk604);
		android.util.Log.d("leak-605-9", dataLeAk605);
		android.util.Log.d("leak-606-9", dataLeAk606);
		android.util.Log.d("leak-607-9", dataLeAk607);
		android.util.Log.d("leak-608-9", dataLeAk608);
		android.util.Log.d("leak-609-9", dataLeAk609);
		android.util.Log.d("leak-610-9", dataLeAk610);
		android.util.Log.d("leak-611-9", dataLeAk611);
		android.util.Log.d("leak-612-9", dataLeAk612);
		android.util.Log.d("leak-613-9", dataLeAk613);
		android.util.Log.d("leak-614-9", dataLeAk614);
		android.util.Log.d("leak-615-9", dataLeAk615);
		android.util.Log.d("leak-616-9", dataLeAk616);
		android.util.Log.d("leak-620-9", dataLeAk620);
		android.util.Log.d("leak-621-9", dataLeAk621);
		android.util.Log.d("leak-622-9", dataLeAk622);
		launchSubscriptionPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode,
                                               OnIabPurchaseFinishedListener listener, String extraData) {
        dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-10", dataLeAk584);
		android.util.Log.d("leak-585-10", dataLeAk585);
		android.util.Log.d("leak-586-10", dataLeAk586);
		android.util.Log.d("leak-587-10", dataLeAk587);
		android.util.Log.d("leak-590-10", dataLeAk590);
		android.util.Log.d("leak-591-10", dataLeAk591);
		android.util.Log.d("leak-592-10", dataLeAk592);
		android.util.Log.d("leak-593-10", dataLeAk593);
		android.util.Log.d("leak-594-10", dataLeAk594);
		android.util.Log.d("leak-595-10", dataLeAk595);
		android.util.Log.d("leak-596-10", dataLeAk596);
		android.util.Log.d("leak-597-10", dataLeAk597);
		android.util.Log.d("leak-598-10", dataLeAk598);
		android.util.Log.d("leak-599-10", dataLeAk599);
		android.util.Log.d("leak-600-10", dataLeAk600);
		android.util.Log.d("leak-601-10", dataLeAk601);
		android.util.Log.d("leak-604-10", dataLeAk604);
		android.util.Log.d("leak-605-10", dataLeAk605);
		android.util.Log.d("leak-606-10", dataLeAk606);
		android.util.Log.d("leak-607-10", dataLeAk607);
		android.util.Log.d("leak-608-10", dataLeAk608);
		android.util.Log.d("leak-609-10", dataLeAk609);
		android.util.Log.d("leak-610-10", dataLeAk610);
		android.util.Log.d("leak-611-10", dataLeAk611);
		android.util.Log.d("leak-612-10", dataLeAk612);
		android.util.Log.d("leak-613-10", dataLeAk613);
		android.util.Log.d("leak-614-10", dataLeAk614);
		android.util.Log.d("leak-615-10", dataLeAk615);
		android.util.Log.d("leak-616-10", dataLeAk616);
		android.util.Log.d("leak-620-10", dataLeAk620);
		android.util.Log.d("leak-621-10", dataLeAk621);
		android.util.Log.d("leak-622-10", dataLeAk622);
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
        dataLeAk597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-11", dataLeAk584);
		android.util.Log.d("leak-585-11", dataLeAk585);
		android.util.Log.d("leak-586-11", dataLeAk586);
		android.util.Log.d("leak-587-11", dataLeAk587);
		android.util.Log.d("leak-590-11", dataLeAk590);
		android.util.Log.d("leak-591-11", dataLeAk591);
		android.util.Log.d("leak-592-11", dataLeAk592);
		android.util.Log.d("leak-593-11", dataLeAk593);
		android.util.Log.d("leak-594-11", dataLeAk594);
		android.util.Log.d("leak-595-11", dataLeAk595);
		android.util.Log.d("leak-596-11", dataLeAk596);
		android.util.Log.d("leak-597-11", dataLeAk597);
		android.util.Log.d("leak-598-11", dataLeAk598);
		android.util.Log.d("leak-599-11", dataLeAk599);
		android.util.Log.d("leak-600-11", dataLeAk600);
		android.util.Log.d("leak-601-11", dataLeAk601);
		android.util.Log.d("leak-604-11", dataLeAk604);
		android.util.Log.d("leak-605-11", dataLeAk605);
		android.util.Log.d("leak-606-11", dataLeAk606);
		android.util.Log.d("leak-607-11", dataLeAk607);
		android.util.Log.d("leak-608-11", dataLeAk608);
		android.util.Log.d("leak-609-11", dataLeAk609);
		android.util.Log.d("leak-610-11", dataLeAk610);
		android.util.Log.d("leak-611-11", dataLeAk611);
		android.util.Log.d("leak-612-11", dataLeAk612);
		android.util.Log.d("leak-613-11", dataLeAk613);
		android.util.Log.d("leak-614-11", dataLeAk614);
		android.util.Log.d("leak-615-11", dataLeAk615);
		android.util.Log.d("leak-616-11", dataLeAk616);
		android.util.Log.d("leak-620-11", dataLeAk620);
		android.util.Log.d("leak-621-11", dataLeAk621);
		android.util.Log.d("leak-622-11", dataLeAk622);
		checkNotDisposed();
        checkSetupDone("launchPurchaseFlow");
        flagStartAsync("launchPurchaseFlow");
        IabResult result;

        if (itemType.equals(ITEM_TYPE_SUBS) && !mSubscriptionsSupported) {
            IabResult r = new IabResult(IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE,
                    "Subscriptions are not available.");
            flagEndAsync();
            if (listener != null) listener.onIabPurchaseFinished(r, null);
            return;
        }

        try {
            logDebug("Constructing buy intent for " + sku + ", item type: " + itemType);
            Bundle buyIntentBundle = mService.getBuyIntent(3, mContext.getPackageName(), sku, itemType, extraData);
            int response = getResponseCodeFromBundle(buyIntentBundle);
            if (response != BILLING_RESPONSE_RESULT_OK) {
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
            logError("SendIntentException while launching purchase flow for sku " + sku);
            e.printStackTrace();
            flagEndAsync();

            result = new IabResult(IABHELPER_SEND_INTENT_FAILED, "Failed to send intent.");
            if (listener != null) listener.onIabPurchaseFinished(result, null);
        }
        catch (RemoteException e) {
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
        dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-12", dataLeAk584);
		android.util.Log.d("leak-585-12", dataLeAk585);
		android.util.Log.d("leak-586-12", dataLeAk586);
		android.util.Log.d("leak-587-12", dataLeAk587);
		android.util.Log.d("leak-590-12", dataLeAk590);
		android.util.Log.d("leak-591-12", dataLeAk591);
		android.util.Log.d("leak-592-12", dataLeAk592);
		android.util.Log.d("leak-593-12", dataLeAk593);
		android.util.Log.d("leak-594-12", dataLeAk594);
		android.util.Log.d("leak-595-12", dataLeAk595);
		android.util.Log.d("leak-596-12", dataLeAk596);
		android.util.Log.d("leak-597-12", dataLeAk597);
		android.util.Log.d("leak-598-12", dataLeAk598);
		android.util.Log.d("leak-599-12", dataLeAk599);
		android.util.Log.d("leak-600-12", dataLeAk600);
		android.util.Log.d("leak-601-12", dataLeAk601);
		android.util.Log.d("leak-604-12", dataLeAk604);
		android.util.Log.d("leak-605-12", dataLeAk605);
		android.util.Log.d("leak-606-12", dataLeAk606);
		android.util.Log.d("leak-607-12", dataLeAk607);
		android.util.Log.d("leak-608-12", dataLeAk608);
		android.util.Log.d("leak-609-12", dataLeAk609);
		android.util.Log.d("leak-610-12", dataLeAk610);
		android.util.Log.d("leak-611-12", dataLeAk611);
		android.util.Log.d("leak-612-12", dataLeAk612);
		android.util.Log.d("leak-613-12", dataLeAk613);
		android.util.Log.d("leak-614-12", dataLeAk614);
		android.util.Log.d("leak-615-12", dataLeAk615);
		android.util.Log.d("leak-616-12", dataLeAk616);
		android.util.Log.d("leak-620-12", dataLeAk620);
		android.util.Log.d("leak-621-12", dataLeAk621);
		android.util.Log.d("leak-622-12", dataLeAk622);
		IabResult result;
        if (requestCode != mRequestCode) return false;

        checkNotDisposed();
        checkSetupDone("handleActivityResult");

        // end of async purchase operation that started on launchPurchaseFlow
        flagEndAsync();

        if (data == null) {
            logError("Null data in IAB activity result.");
            result = new IabResult(IABHELPER_BAD_RESPONSE, "Null data in IAB result");
            if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
            return true;
        }

        int responseCode = getResponseCodeFromIntent(data);
        String purchaseData = data.getStringExtra(RESPONSE_INAPP_PURCHASE_DATA);
        String dataSignature = data.getStringExtra(RESPONSE_INAPP_SIGNATURE);

        if (resultCode == Activity.RESULT_OK && responseCode == BILLING_RESPONSE_RESULT_OK) {
            logDebug("Successful resultcode from purchase activity.");
            logDebug("Purchase data: " + purchaseData);
            logDebug("Data signature: " + dataSignature);
            logDebug("Extras: " + data.getExtras());
            logDebug("Expected item type: " + mPurchasingItemType);

            if (purchaseData == null || dataSignature == null) {
                logError("BUG: either purchaseData or dataSignature is null.");
                logDebug("Extras: " + data.getExtras().toString());
                result = new IabResult(IABHELPER_UNKNOWN_ERROR, "IAB returned null purchaseData or dataSignature");
                if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
                return true;
            }

            Purchase purchase = null;
            try {
                purchase = new Purchase(mPurchasingItemType, purchaseData, dataSignature);
                String sku = purchase.getSku();

                // Verify signature
                if (!Security.verifyPurchase(mSignatureBase64, purchaseData, dataSignature)) {
                    logError("Purchase signature verification FAILED for sku " + sku);
                    result = new IabResult(IABHELPER_VERIFICATION_FAILED, "Signature verification failed for sku " + sku);
                    if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, purchase);
                    return true;
                }
                logDebug("Purchase signature successfully verified.");
            }
            catch (JSONException e) {
                logError("Failed to parse purchase data.");
                e.printStackTrace();
                result = new IabResult(IABHELPER_BAD_RESPONSE, "Failed to parse purchase data.");
                if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
                return true;
            }

            if (mPurchaseListener != null) {
                mPurchaseListener.onIabPurchaseFinished(new IabResult(BILLING_RESPONSE_RESULT_OK, "Success"), purchase);
            }
        }
        else if (resultCode == Activity.RESULT_OK) {
            // result code was OK, but in-app billing response was not OK.
            logDebug("Result code was OK but in-app billing response was not OK: " + getResponseDesc(responseCode));
            if (mPurchaseListener != null) {
                result = new IabResult(responseCode, "Problem purchashing item.");
                mPurchaseListener.onIabPurchaseFinished(result, null);
            }
        }
        else if (resultCode == Activity.RESULT_CANCELED) {
            logDebug("Purchase canceled - Response: " + getResponseDesc(responseCode));
            result = new IabResult(IABHELPER_USER_CANCELLED, "User canceled.");
            if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
        }
        else {
            logError("Purchase failed. Result code: " + Integer.toString(resultCode)
                    + ". Response: " + getResponseDesc(responseCode));
            result = new IabResult(IABHELPER_UNKNOWN_PURCHASE_RESPONSE, "Unknown purchase response.");
            if (mPurchaseListener != null) mPurchaseListener.onIabPurchaseFinished(result, null);
        }
        return true;
    }

    public Inventory queryInventory(boolean querySkuDetails, List<String> moreSkus) throws IabException {
        dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-13", dataLeAk584);
		android.util.Log.d("leak-585-13", dataLeAk585);
		android.util.Log.d("leak-586-13", dataLeAk586);
		android.util.Log.d("leak-587-13", dataLeAk587);
		android.util.Log.d("leak-590-13", dataLeAk590);
		android.util.Log.d("leak-591-13", dataLeAk591);
		android.util.Log.d("leak-592-13", dataLeAk592);
		android.util.Log.d("leak-593-13", dataLeAk593);
		android.util.Log.d("leak-594-13", dataLeAk594);
		android.util.Log.d("leak-595-13", dataLeAk595);
		android.util.Log.d("leak-596-13", dataLeAk596);
		android.util.Log.d("leak-597-13", dataLeAk597);
		android.util.Log.d("leak-598-13", dataLeAk598);
		android.util.Log.d("leak-599-13", dataLeAk599);
		android.util.Log.d("leak-600-13", dataLeAk600);
		android.util.Log.d("leak-601-13", dataLeAk601);
		android.util.Log.d("leak-604-13", dataLeAk604);
		android.util.Log.d("leak-605-13", dataLeAk605);
		android.util.Log.d("leak-606-13", dataLeAk606);
		android.util.Log.d("leak-607-13", dataLeAk607);
		android.util.Log.d("leak-608-13", dataLeAk608);
		android.util.Log.d("leak-609-13", dataLeAk609);
		android.util.Log.d("leak-610-13", dataLeAk610);
		android.util.Log.d("leak-611-13", dataLeAk611);
		android.util.Log.d("leak-612-13", dataLeAk612);
		android.util.Log.d("leak-613-13", dataLeAk613);
		android.util.Log.d("leak-614-13", dataLeAk614);
		android.util.Log.d("leak-615-13", dataLeAk615);
		android.util.Log.d("leak-616-13", dataLeAk616);
		android.util.Log.d("leak-620-13", dataLeAk620);
		android.util.Log.d("leak-621-13", dataLeAk621);
		android.util.Log.d("leak-622-13", dataLeAk622);
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
        dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-14", dataLeAk584);
		android.util.Log.d("leak-585-14", dataLeAk585);
		android.util.Log.d("leak-586-14", dataLeAk586);
		android.util.Log.d("leak-587-14", dataLeAk587);
		android.util.Log.d("leak-590-14", dataLeAk590);
		android.util.Log.d("leak-591-14", dataLeAk591);
		android.util.Log.d("leak-592-14", dataLeAk592);
		android.util.Log.d("leak-593-14", dataLeAk593);
		android.util.Log.d("leak-594-14", dataLeAk594);
		android.util.Log.d("leak-595-14", dataLeAk595);
		android.util.Log.d("leak-596-14", dataLeAk596);
		android.util.Log.d("leak-597-14", dataLeAk597);
		android.util.Log.d("leak-598-14", dataLeAk598);
		android.util.Log.d("leak-599-14", dataLeAk599);
		android.util.Log.d("leak-600-14", dataLeAk600);
		android.util.Log.d("leak-601-14", dataLeAk601);
		android.util.Log.d("leak-604-14", dataLeAk604);
		android.util.Log.d("leak-605-14", dataLeAk605);
		android.util.Log.d("leak-606-14", dataLeAk606);
		android.util.Log.d("leak-607-14", dataLeAk607);
		android.util.Log.d("leak-608-14", dataLeAk608);
		android.util.Log.d("leak-609-14", dataLeAk609);
		android.util.Log.d("leak-610-14", dataLeAk610);
		android.util.Log.d("leak-611-14", dataLeAk611);
		android.util.Log.d("leak-612-14", dataLeAk612);
		android.util.Log.d("leak-613-14", dataLeAk613);
		android.util.Log.d("leak-614-14", dataLeAk614);
		android.util.Log.d("leak-615-14", dataLeAk615);
		android.util.Log.d("leak-616-14", dataLeAk616);
		android.util.Log.d("leak-620-14", dataLeAk620);
		android.util.Log.d("leak-621-14", dataLeAk621);
		android.util.Log.d("leak-622-14", dataLeAk622);
		checkNotDisposed();
        checkSetupDone("queryInventory");
        try {
            Inventory inv = new Inventory();
            int r = queryPurchases(inv, ITEM_TYPE_INAPP);
            if (r != BILLING_RESPONSE_RESULT_OK) {
                throw new IabException(r, "Error refreshing inventory (querying owned items).");
            }

            if (querySkuDetails) {
                r = querySkuDetails(ITEM_TYPE_INAPP, inv, moreItemSkus);
                if (r != BILLING_RESPONSE_RESULT_OK) {
                    throw new IabException(r, "Error refreshing inventory (querying prices of items).");
                }
            }

            // if subscriptions are supported, then also query for subscriptions
            if (mSubscriptionsSupported) {
                r = queryPurchases(inv, ITEM_TYPE_SUBS);
                if (r != BILLING_RESPONSE_RESULT_OK) {
                    throw new IabException(r, "Error refreshing inventory (querying owned subscriptions).");
                }

                if (querySkuDetails) {
                    r = querySkuDetails(ITEM_TYPE_SUBS, inv, moreItemSkus);
                    if (r != BILLING_RESPONSE_RESULT_OK) {
                        throw new IabException(r, "Error refreshing inventory (querying prices of subscriptions).");
                    }
                }
            }

            return inv;
        }
        catch (RemoteException e) {
            throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while refreshing inventory.", e);
        }
        catch (JSONException e) {
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
        dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-15", dataLeAk584);
		android.util.Log.d("leak-585-15", dataLeAk585);
		android.util.Log.d("leak-586-15", dataLeAk586);
		android.util.Log.d("leak-587-15", dataLeAk587);
		android.util.Log.d("leak-590-15", dataLeAk590);
		android.util.Log.d("leak-591-15", dataLeAk591);
		android.util.Log.d("leak-592-15", dataLeAk592);
		android.util.Log.d("leak-593-15", dataLeAk593);
		android.util.Log.d("leak-594-15", dataLeAk594);
		android.util.Log.d("leak-595-15", dataLeAk595);
		android.util.Log.d("leak-596-15", dataLeAk596);
		android.util.Log.d("leak-597-15", dataLeAk597);
		android.util.Log.d("leak-598-15", dataLeAk598);
		android.util.Log.d("leak-599-15", dataLeAk599);
		android.util.Log.d("leak-600-15", dataLeAk600);
		android.util.Log.d("leak-601-15", dataLeAk601);
		android.util.Log.d("leak-604-15", dataLeAk604);
		android.util.Log.d("leak-605-15", dataLeAk605);
		android.util.Log.d("leak-606-15", dataLeAk606);
		android.util.Log.d("leak-607-15", dataLeAk607);
		android.util.Log.d("leak-608-15", dataLeAk608);
		android.util.Log.d("leak-609-15", dataLeAk609);
		android.util.Log.d("leak-610-15", dataLeAk610);
		android.util.Log.d("leak-611-15", dataLeAk611);
		android.util.Log.d("leak-612-15", dataLeAk612);
		android.util.Log.d("leak-613-15", dataLeAk613);
		android.util.Log.d("leak-614-15", dataLeAk614);
		android.util.Log.d("leak-615-15", dataLeAk615);
		android.util.Log.d("leak-616-15", dataLeAk616);
		android.util.Log.d("leak-620-15", dataLeAk620);
		android.util.Log.d("leak-621-15", dataLeAk621);
		android.util.Log.d("leak-622-15", dataLeAk622);
		final Handler handler = new Handler();
        checkNotDisposed();
        checkSetupDone("queryInventory");
        flagStartAsync("refresh inventory");
        (new Thread(new Runnable() {
            final String dataLeAk627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk602 = "";

			public void run() {
                dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-626-0", dataLeAk626);
				android.util.Log.d("leak-602-0", dataLeAk602);
				IabResult result = new IabResult(BILLING_RESPONSE_RESULT_OK, "Inventory refresh successful.");
                Inventory inv = null;
                try {
                    inv = queryInventory(querySkuDetails, moreSkus);
                }
                catch (IabException ex) {
                    result = ex.getResult();
                }

                flagEndAsync();

                final IabResult result_f = result;
                final Inventory inv_f = inv;
                if (!mDisposed && listener != null) {
                    handler.post(new Runnable() {
                        String dataLeAk603 = "";

						public void run() {
                            dataLeAk603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-628-0", dataLeAk628);
							android.util.Log.d("leak-627-0", dataLeAk627);
							android.util.Log.d("leak-603-0", dataLeAk603);
							listener.onQueryInventoryFinished(result_f, inv_f);
                        }
                    });
                }
            }
        })).start();
    }

    public void queryInventoryAsync(QueryInventoryFinishedListener listener) {
        dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-16", dataLeAk584);
		android.util.Log.d("leak-585-16", dataLeAk585);
		android.util.Log.d("leak-586-16", dataLeAk586);
		android.util.Log.d("leak-587-16", dataLeAk587);
		android.util.Log.d("leak-590-16", dataLeAk590);
		android.util.Log.d("leak-591-16", dataLeAk591);
		android.util.Log.d("leak-592-16", dataLeAk592);
		android.util.Log.d("leak-593-16", dataLeAk593);
		android.util.Log.d("leak-594-16", dataLeAk594);
		android.util.Log.d("leak-595-16", dataLeAk595);
		android.util.Log.d("leak-596-16", dataLeAk596);
		android.util.Log.d("leak-597-16", dataLeAk597);
		android.util.Log.d("leak-598-16", dataLeAk598);
		android.util.Log.d("leak-599-16", dataLeAk599);
		android.util.Log.d("leak-600-16", dataLeAk600);
		android.util.Log.d("leak-601-16", dataLeAk601);
		android.util.Log.d("leak-604-16", dataLeAk604);
		android.util.Log.d("leak-605-16", dataLeAk605);
		android.util.Log.d("leak-606-16", dataLeAk606);
		android.util.Log.d("leak-607-16", dataLeAk607);
		android.util.Log.d("leak-608-16", dataLeAk608);
		android.util.Log.d("leak-609-16", dataLeAk609);
		android.util.Log.d("leak-610-16", dataLeAk610);
		android.util.Log.d("leak-611-16", dataLeAk611);
		android.util.Log.d("leak-612-16", dataLeAk612);
		android.util.Log.d("leak-613-16", dataLeAk613);
		android.util.Log.d("leak-614-16", dataLeAk614);
		android.util.Log.d("leak-615-16", dataLeAk615);
		android.util.Log.d("leak-616-16", dataLeAk616);
		android.util.Log.d("leak-620-16", dataLeAk620);
		android.util.Log.d("leak-621-16", dataLeAk621);
		android.util.Log.d("leak-622-16", dataLeAk622);
		queryInventoryAsync(true, null, listener);
    }

    public void queryInventoryAsync(boolean querySkuDetails, QueryInventoryFinishedListener listener) {
        dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-17", dataLeAk584);
		android.util.Log.d("leak-585-17", dataLeAk585);
		android.util.Log.d("leak-586-17", dataLeAk586);
		android.util.Log.d("leak-587-17", dataLeAk587);
		android.util.Log.d("leak-590-17", dataLeAk590);
		android.util.Log.d("leak-591-17", dataLeAk591);
		android.util.Log.d("leak-592-17", dataLeAk592);
		android.util.Log.d("leak-593-17", dataLeAk593);
		android.util.Log.d("leak-594-17", dataLeAk594);
		android.util.Log.d("leak-595-17", dataLeAk595);
		android.util.Log.d("leak-596-17", dataLeAk596);
		android.util.Log.d("leak-597-17", dataLeAk597);
		android.util.Log.d("leak-598-17", dataLeAk598);
		android.util.Log.d("leak-599-17", dataLeAk599);
		android.util.Log.d("leak-600-17", dataLeAk600);
		android.util.Log.d("leak-601-17", dataLeAk601);
		android.util.Log.d("leak-604-17", dataLeAk604);
		android.util.Log.d("leak-605-17", dataLeAk605);
		android.util.Log.d("leak-606-17", dataLeAk606);
		android.util.Log.d("leak-607-17", dataLeAk607);
		android.util.Log.d("leak-608-17", dataLeAk608);
		android.util.Log.d("leak-609-17", dataLeAk609);
		android.util.Log.d("leak-610-17", dataLeAk610);
		android.util.Log.d("leak-611-17", dataLeAk611);
		android.util.Log.d("leak-612-17", dataLeAk612);
		android.util.Log.d("leak-613-17", dataLeAk613);
		android.util.Log.d("leak-614-17", dataLeAk614);
		android.util.Log.d("leak-615-17", dataLeAk615);
		android.util.Log.d("leak-616-17", dataLeAk616);
		android.util.Log.d("leak-620-17", dataLeAk620);
		android.util.Log.d("leak-621-17", dataLeAk621);
		android.util.Log.d("leak-622-17", dataLeAk622);
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
        dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-18", dataLeAk584);
		android.util.Log.d("leak-585-18", dataLeAk585);
		android.util.Log.d("leak-586-18", dataLeAk586);
		android.util.Log.d("leak-587-18", dataLeAk587);
		android.util.Log.d("leak-590-18", dataLeAk590);
		android.util.Log.d("leak-591-18", dataLeAk591);
		android.util.Log.d("leak-592-18", dataLeAk592);
		android.util.Log.d("leak-593-18", dataLeAk593);
		android.util.Log.d("leak-594-18", dataLeAk594);
		android.util.Log.d("leak-595-18", dataLeAk595);
		android.util.Log.d("leak-596-18", dataLeAk596);
		android.util.Log.d("leak-597-18", dataLeAk597);
		android.util.Log.d("leak-598-18", dataLeAk598);
		android.util.Log.d("leak-599-18", dataLeAk599);
		android.util.Log.d("leak-600-18", dataLeAk600);
		android.util.Log.d("leak-601-18", dataLeAk601);
		android.util.Log.d("leak-604-18", dataLeAk604);
		android.util.Log.d("leak-605-18", dataLeAk605);
		android.util.Log.d("leak-606-18", dataLeAk606);
		android.util.Log.d("leak-607-18", dataLeAk607);
		android.util.Log.d("leak-608-18", dataLeAk608);
		android.util.Log.d("leak-609-18", dataLeAk609);
		android.util.Log.d("leak-610-18", dataLeAk610);
		android.util.Log.d("leak-611-18", dataLeAk611);
		android.util.Log.d("leak-612-18", dataLeAk612);
		android.util.Log.d("leak-613-18", dataLeAk613);
		android.util.Log.d("leak-614-18", dataLeAk614);
		android.util.Log.d("leak-615-18", dataLeAk615);
		android.util.Log.d("leak-616-18", dataLeAk616);
		android.util.Log.d("leak-620-18", dataLeAk620);
		android.util.Log.d("leak-621-18", dataLeAk621);
		android.util.Log.d("leak-622-18", dataLeAk622);
		checkNotDisposed();
        checkSetupDone("consume");

        if (!itemInfo.mItemType.equals(ITEM_TYPE_INAPP)) {
            throw new IabException(IABHELPER_INVALID_CONSUMPTION,
                    "Items of type '" + itemInfo.mItemType + "' can't be consumed.");
        }

        try {
            String token = itemInfo.getToken();
            String sku = itemInfo.getSku();
            if (token == null || token.equals("")) {
                logError("Can't consume "+ sku + ". No token.");
                throw new IabException(IABHELPER_MISSING_TOKEN, "PurchaseInfo is missing token for sku: "
                        + sku + " " + itemInfo);
            }

            logDebug("Consuming sku: " + sku + ", token: " + token);
            int response = mService.consumePurchase(3, mContext.getPackageName(), token);
            if (response == BILLING_RESPONSE_RESULT_OK) {
                logDebug("Successfully consumed sku: " + sku);
            }
            else {
                logDebug("Error consuming consuming sku " + sku + ". " + getResponseDesc(response));
                throw new IabException(response, "Error consuming sku " + sku);
            }
        }
        catch (RemoteException e) {
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
        dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-19", dataLeAk584);
		android.util.Log.d("leak-585-19", dataLeAk585);
		android.util.Log.d("leak-586-19", dataLeAk586);
		android.util.Log.d("leak-587-19", dataLeAk587);
		android.util.Log.d("leak-590-19", dataLeAk590);
		android.util.Log.d("leak-591-19", dataLeAk591);
		android.util.Log.d("leak-592-19", dataLeAk592);
		android.util.Log.d("leak-593-19", dataLeAk593);
		android.util.Log.d("leak-594-19", dataLeAk594);
		android.util.Log.d("leak-595-19", dataLeAk595);
		android.util.Log.d("leak-596-19", dataLeAk596);
		android.util.Log.d("leak-597-19", dataLeAk597);
		android.util.Log.d("leak-598-19", dataLeAk598);
		android.util.Log.d("leak-599-19", dataLeAk599);
		android.util.Log.d("leak-600-19", dataLeAk600);
		android.util.Log.d("leak-601-19", dataLeAk601);
		android.util.Log.d("leak-604-19", dataLeAk604);
		android.util.Log.d("leak-605-19", dataLeAk605);
		android.util.Log.d("leak-606-19", dataLeAk606);
		android.util.Log.d("leak-607-19", dataLeAk607);
		android.util.Log.d("leak-608-19", dataLeAk608);
		android.util.Log.d("leak-609-19", dataLeAk609);
		android.util.Log.d("leak-610-19", dataLeAk610);
		android.util.Log.d("leak-611-19", dataLeAk611);
		android.util.Log.d("leak-612-19", dataLeAk612);
		android.util.Log.d("leak-613-19", dataLeAk613);
		android.util.Log.d("leak-614-19", dataLeAk614);
		android.util.Log.d("leak-615-19", dataLeAk615);
		android.util.Log.d("leak-616-19", dataLeAk616);
		android.util.Log.d("leak-620-19", dataLeAk620);
		android.util.Log.d("leak-621-19", dataLeAk621);
		android.util.Log.d("leak-622-19", dataLeAk622);
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
        dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-20", dataLeAk584);
		android.util.Log.d("leak-585-20", dataLeAk585);
		android.util.Log.d("leak-586-20", dataLeAk586);
		android.util.Log.d("leak-587-20", dataLeAk587);
		android.util.Log.d("leak-590-20", dataLeAk590);
		android.util.Log.d("leak-591-20", dataLeAk591);
		android.util.Log.d("leak-592-20", dataLeAk592);
		android.util.Log.d("leak-593-20", dataLeAk593);
		android.util.Log.d("leak-594-20", dataLeAk594);
		android.util.Log.d("leak-595-20", dataLeAk595);
		android.util.Log.d("leak-596-20", dataLeAk596);
		android.util.Log.d("leak-597-20", dataLeAk597);
		android.util.Log.d("leak-598-20", dataLeAk598);
		android.util.Log.d("leak-599-20", dataLeAk599);
		android.util.Log.d("leak-600-20", dataLeAk600);
		android.util.Log.d("leak-601-20", dataLeAk601);
		android.util.Log.d("leak-604-20", dataLeAk604);
		android.util.Log.d("leak-605-20", dataLeAk605);
		android.util.Log.d("leak-606-20", dataLeAk606);
		android.util.Log.d("leak-607-20", dataLeAk607);
		android.util.Log.d("leak-608-20", dataLeAk608);
		android.util.Log.d("leak-609-20", dataLeAk609);
		android.util.Log.d("leak-610-20", dataLeAk610);
		android.util.Log.d("leak-611-20", dataLeAk611);
		android.util.Log.d("leak-612-20", dataLeAk612);
		android.util.Log.d("leak-613-20", dataLeAk613);
		android.util.Log.d("leak-614-20", dataLeAk614);
		android.util.Log.d("leak-615-20", dataLeAk615);
		android.util.Log.d("leak-616-20", dataLeAk616);
		android.util.Log.d("leak-620-20", dataLeAk620);
		android.util.Log.d("leak-621-20", dataLeAk621);
		android.util.Log.d("leak-622-20", dataLeAk622);
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
        dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-21", dataLeAk584);
		android.util.Log.d("leak-585-21", dataLeAk585);
		android.util.Log.d("leak-586-21", dataLeAk586);
		android.util.Log.d("leak-587-21", dataLeAk587);
		android.util.Log.d("leak-590-21", dataLeAk590);
		android.util.Log.d("leak-591-21", dataLeAk591);
		android.util.Log.d("leak-592-21", dataLeAk592);
		android.util.Log.d("leak-593-21", dataLeAk593);
		android.util.Log.d("leak-594-21", dataLeAk594);
		android.util.Log.d("leak-595-21", dataLeAk595);
		android.util.Log.d("leak-596-21", dataLeAk596);
		android.util.Log.d("leak-597-21", dataLeAk597);
		android.util.Log.d("leak-598-21", dataLeAk598);
		android.util.Log.d("leak-599-21", dataLeAk599);
		android.util.Log.d("leak-600-21", dataLeAk600);
		android.util.Log.d("leak-601-21", dataLeAk601);
		android.util.Log.d("leak-604-21", dataLeAk604);
		android.util.Log.d("leak-605-21", dataLeAk605);
		android.util.Log.d("leak-606-21", dataLeAk606);
		android.util.Log.d("leak-607-21", dataLeAk607);
		android.util.Log.d("leak-608-21", dataLeAk608);
		android.util.Log.d("leak-609-21", dataLeAk609);
		android.util.Log.d("leak-610-21", dataLeAk610);
		android.util.Log.d("leak-611-21", dataLeAk611);
		android.util.Log.d("leak-612-21", dataLeAk612);
		android.util.Log.d("leak-613-21", dataLeAk613);
		android.util.Log.d("leak-614-21", dataLeAk614);
		android.util.Log.d("leak-615-21", dataLeAk615);
		android.util.Log.d("leak-616-21", dataLeAk616);
		android.util.Log.d("leak-620-21", dataLeAk620);
		android.util.Log.d("leak-621-21", dataLeAk621);
		android.util.Log.d("leak-622-21", dataLeAk622);
		if (!mSetupDone) {
            logError("Illegal state for operation (" + operation + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + operation);
        }
    }

    // Workaround to bug where sometimes response codes come as Long instead of Integer
    int getResponseCodeFromBundle(Bundle b) {
        dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-22", dataLeAk584);
		android.util.Log.d("leak-585-22", dataLeAk585);
		android.util.Log.d("leak-586-22", dataLeAk586);
		android.util.Log.d("leak-587-22", dataLeAk587);
		android.util.Log.d("leak-590-22", dataLeAk590);
		android.util.Log.d("leak-591-22", dataLeAk591);
		android.util.Log.d("leak-592-22", dataLeAk592);
		android.util.Log.d("leak-593-22", dataLeAk593);
		android.util.Log.d("leak-594-22", dataLeAk594);
		android.util.Log.d("leak-595-22", dataLeAk595);
		android.util.Log.d("leak-596-22", dataLeAk596);
		android.util.Log.d("leak-597-22", dataLeAk597);
		android.util.Log.d("leak-598-22", dataLeAk598);
		android.util.Log.d("leak-599-22", dataLeAk599);
		android.util.Log.d("leak-600-22", dataLeAk600);
		android.util.Log.d("leak-601-22", dataLeAk601);
		android.util.Log.d("leak-604-22", dataLeAk604);
		android.util.Log.d("leak-605-22", dataLeAk605);
		android.util.Log.d("leak-606-22", dataLeAk606);
		android.util.Log.d("leak-607-22", dataLeAk607);
		android.util.Log.d("leak-608-22", dataLeAk608);
		android.util.Log.d("leak-609-22", dataLeAk609);
		android.util.Log.d("leak-610-22", dataLeAk610);
		android.util.Log.d("leak-611-22", dataLeAk611);
		android.util.Log.d("leak-612-22", dataLeAk612);
		android.util.Log.d("leak-613-22", dataLeAk613);
		android.util.Log.d("leak-614-22", dataLeAk614);
		android.util.Log.d("leak-615-22", dataLeAk615);
		android.util.Log.d("leak-616-22", dataLeAk616);
		android.util.Log.d("leak-620-22", dataLeAk620);
		android.util.Log.d("leak-621-22", dataLeAk621);
		android.util.Log.d("leak-622-22", dataLeAk622);
		Object o = b.get(RESPONSE_CODE);
        if (o == null) {
            logDebug("Bundle with null response code, assuming OK (known issue)");
            return BILLING_RESPONSE_RESULT_OK;
        }
        else if (o instanceof Integer) return ((Integer)o).intValue();
        else if (o instanceof Long) return (int)((Long)o).longValue();
        else {
            logError("Unexpected type for bundle response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + o.getClass().getName());
        }
    }

    // Workaround to bug where sometimes response codes come as Long instead of Integer
    int getResponseCodeFromIntent(Intent i) {
        dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-23", dataLeAk584);
		android.util.Log.d("leak-585-23", dataLeAk585);
		android.util.Log.d("leak-586-23", dataLeAk586);
		android.util.Log.d("leak-587-23", dataLeAk587);
		android.util.Log.d("leak-590-23", dataLeAk590);
		android.util.Log.d("leak-591-23", dataLeAk591);
		android.util.Log.d("leak-592-23", dataLeAk592);
		android.util.Log.d("leak-593-23", dataLeAk593);
		android.util.Log.d("leak-594-23", dataLeAk594);
		android.util.Log.d("leak-595-23", dataLeAk595);
		android.util.Log.d("leak-596-23", dataLeAk596);
		android.util.Log.d("leak-597-23", dataLeAk597);
		android.util.Log.d("leak-598-23", dataLeAk598);
		android.util.Log.d("leak-599-23", dataLeAk599);
		android.util.Log.d("leak-600-23", dataLeAk600);
		android.util.Log.d("leak-601-23", dataLeAk601);
		android.util.Log.d("leak-604-23", dataLeAk604);
		android.util.Log.d("leak-605-23", dataLeAk605);
		android.util.Log.d("leak-606-23", dataLeAk606);
		android.util.Log.d("leak-607-23", dataLeAk607);
		android.util.Log.d("leak-608-23", dataLeAk608);
		android.util.Log.d("leak-609-23", dataLeAk609);
		android.util.Log.d("leak-610-23", dataLeAk610);
		android.util.Log.d("leak-611-23", dataLeAk611);
		android.util.Log.d("leak-612-23", dataLeAk612);
		android.util.Log.d("leak-613-23", dataLeAk613);
		android.util.Log.d("leak-614-23", dataLeAk614);
		android.util.Log.d("leak-615-23", dataLeAk615);
		android.util.Log.d("leak-616-23", dataLeAk616);
		android.util.Log.d("leak-620-23", dataLeAk620);
		android.util.Log.d("leak-621-23", dataLeAk621);
		android.util.Log.d("leak-622-23", dataLeAk622);
		Object o = i.getExtras().get(RESPONSE_CODE);
        if (o == null) {
            logError("Intent with no response code, assuming OK (known issue)");
            return BILLING_RESPONSE_RESULT_OK;
        }
        else if (o instanceof Integer) return ((Integer)o).intValue();
        else if (o instanceof Long) return (int)((Long)o).longValue();
        else {
            logError("Unexpected type for intent response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + o.getClass().getName());
        }
    }

    void flagStartAsync(String operation) {
        dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-24", dataLeAk584);
		android.util.Log.d("leak-585-24", dataLeAk585);
		android.util.Log.d("leak-586-24", dataLeAk586);
		android.util.Log.d("leak-587-24", dataLeAk587);
		android.util.Log.d("leak-590-24", dataLeAk590);
		android.util.Log.d("leak-591-24", dataLeAk591);
		android.util.Log.d("leak-592-24", dataLeAk592);
		android.util.Log.d("leak-593-24", dataLeAk593);
		android.util.Log.d("leak-594-24", dataLeAk594);
		android.util.Log.d("leak-595-24", dataLeAk595);
		android.util.Log.d("leak-596-24", dataLeAk596);
		android.util.Log.d("leak-597-24", dataLeAk597);
		android.util.Log.d("leak-598-24", dataLeAk598);
		android.util.Log.d("leak-599-24", dataLeAk599);
		android.util.Log.d("leak-600-24", dataLeAk600);
		android.util.Log.d("leak-601-24", dataLeAk601);
		android.util.Log.d("leak-604-24", dataLeAk604);
		android.util.Log.d("leak-605-24", dataLeAk605);
		android.util.Log.d("leak-606-24", dataLeAk606);
		android.util.Log.d("leak-607-24", dataLeAk607);
		android.util.Log.d("leak-608-24", dataLeAk608);
		android.util.Log.d("leak-609-24", dataLeAk609);
		android.util.Log.d("leak-610-24", dataLeAk610);
		android.util.Log.d("leak-611-24", dataLeAk611);
		android.util.Log.d("leak-612-24", dataLeAk612);
		android.util.Log.d("leak-613-24", dataLeAk613);
		android.util.Log.d("leak-614-24", dataLeAk614);
		android.util.Log.d("leak-615-24", dataLeAk615);
		android.util.Log.d("leak-616-24", dataLeAk616);
		android.util.Log.d("leak-620-24", dataLeAk620);
		android.util.Log.d("leak-621-24", dataLeAk621);
		android.util.Log.d("leak-622-24", dataLeAk622);
		if (mAsyncInProgress) throw new IllegalStateException("Can't start async operation (" +
                operation + ") because another async operation(" + mAsyncOperation + ") is in progress.");
        mAsyncOperation = operation;
        mAsyncInProgress = true;
        logDebug("Starting async operation: " + operation);
    }

    public void flagEndAsync() {
        dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-25", dataLeAk584);
		android.util.Log.d("leak-585-25", dataLeAk585);
		android.util.Log.d("leak-586-25", dataLeAk586);
		android.util.Log.d("leak-587-25", dataLeAk587);
		android.util.Log.d("leak-590-25", dataLeAk590);
		android.util.Log.d("leak-591-25", dataLeAk591);
		android.util.Log.d("leak-592-25", dataLeAk592);
		android.util.Log.d("leak-593-25", dataLeAk593);
		android.util.Log.d("leak-594-25", dataLeAk594);
		android.util.Log.d("leak-595-25", dataLeAk595);
		android.util.Log.d("leak-596-25", dataLeAk596);
		android.util.Log.d("leak-597-25", dataLeAk597);
		android.util.Log.d("leak-598-25", dataLeAk598);
		android.util.Log.d("leak-599-25", dataLeAk599);
		android.util.Log.d("leak-600-25", dataLeAk600);
		android.util.Log.d("leak-601-25", dataLeAk601);
		android.util.Log.d("leak-604-25", dataLeAk604);
		android.util.Log.d("leak-605-25", dataLeAk605);
		android.util.Log.d("leak-606-25", dataLeAk606);
		android.util.Log.d("leak-607-25", dataLeAk607);
		android.util.Log.d("leak-608-25", dataLeAk608);
		android.util.Log.d("leak-609-25", dataLeAk609);
		android.util.Log.d("leak-610-25", dataLeAk610);
		android.util.Log.d("leak-611-25", dataLeAk611);
		android.util.Log.d("leak-612-25", dataLeAk612);
		android.util.Log.d("leak-613-25", dataLeAk613);
		android.util.Log.d("leak-614-25", dataLeAk614);
		android.util.Log.d("leak-615-25", dataLeAk615);
		android.util.Log.d("leak-616-25", dataLeAk616);
		android.util.Log.d("leak-620-25", dataLeAk620);
		android.util.Log.d("leak-621-25", dataLeAk621);
		android.util.Log.d("leak-622-25", dataLeAk622);
		logDebug("Ending async operation: " + mAsyncOperation);
        mAsyncOperation = "";
        mAsyncInProgress = false;
    }


    int queryPurchases(Inventory inv, String itemType) throws JSONException, RemoteException {
        dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-26", dataLeAk584);
		android.util.Log.d("leak-585-26", dataLeAk585);
		android.util.Log.d("leak-586-26", dataLeAk586);
		android.util.Log.d("leak-587-26", dataLeAk587);
		android.util.Log.d("leak-590-26", dataLeAk590);
		android.util.Log.d("leak-591-26", dataLeAk591);
		android.util.Log.d("leak-592-26", dataLeAk592);
		android.util.Log.d("leak-593-26", dataLeAk593);
		android.util.Log.d("leak-594-26", dataLeAk594);
		android.util.Log.d("leak-595-26", dataLeAk595);
		android.util.Log.d("leak-596-26", dataLeAk596);
		android.util.Log.d("leak-597-26", dataLeAk597);
		android.util.Log.d("leak-598-26", dataLeAk598);
		android.util.Log.d("leak-599-26", dataLeAk599);
		android.util.Log.d("leak-600-26", dataLeAk600);
		android.util.Log.d("leak-601-26", dataLeAk601);
		android.util.Log.d("leak-604-26", dataLeAk604);
		android.util.Log.d("leak-605-26", dataLeAk605);
		android.util.Log.d("leak-606-26", dataLeAk606);
		android.util.Log.d("leak-607-26", dataLeAk607);
		android.util.Log.d("leak-608-26", dataLeAk608);
		android.util.Log.d("leak-609-26", dataLeAk609);
		android.util.Log.d("leak-610-26", dataLeAk610);
		android.util.Log.d("leak-611-26", dataLeAk611);
		android.util.Log.d("leak-612-26", dataLeAk612);
		android.util.Log.d("leak-613-26", dataLeAk613);
		android.util.Log.d("leak-614-26", dataLeAk614);
		android.util.Log.d("leak-615-26", dataLeAk615);
		android.util.Log.d("leak-616-26", dataLeAk616);
		android.util.Log.d("leak-620-26", dataLeAk620);
		android.util.Log.d("leak-621-26", dataLeAk621);
		android.util.Log.d("leak-622-26", dataLeAk622);
		// Query purchases
        logDebug("Querying owned items, item type: " + itemType);
        logDebug("Package name: " + mContext.getPackageName());
        boolean verificationFailed = false;
        String continueToken = null;

        do {
            logDebug("Calling getPurchases with continuation token: " + continueToken);
            Bundle ownedItems = mService.getPurchases(3, mContext.getPackageName(),
                    itemType, continueToken);

            int response = getResponseCodeFromBundle(ownedItems);
            logDebug("Owned items response: " + String.valueOf(response));
            if (response != BILLING_RESPONSE_RESULT_OK) {
                logDebug("getPurchases() failed: " + getResponseDesc(response));
                return response;
            }
            if (!ownedItems.containsKey(RESPONSE_INAPP_ITEM_LIST)
                    || !ownedItems.containsKey(RESPONSE_INAPP_PURCHASE_DATA_LIST)
                    || !ownedItems.containsKey(RESPONSE_INAPP_SIGNATURE_LIST)) {
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
                String purchaseData = purchaseDataList.get(i);
                String signature = signatureList.get(i);
                String sku = ownedSkus.get(i);
                if (Security.verifyPurchase(mSignatureBase64, purchaseData, signature)) {
                    logDebug("Sku is owned: " + sku);
                    Purchase purchase = new Purchase(itemType, purchaseData, signature);

                    if (TextUtils.isEmpty(purchase.getToken())) {
                        logWarn("BUG: empty/null token!");
                        logDebug("Purchase data: " + purchaseData);
                    }

                    // Record ownership and token
                    inv.addPurchase(purchase);
                }
                else {
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
        dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-27", dataLeAk584);
		android.util.Log.d("leak-585-27", dataLeAk585);
		android.util.Log.d("leak-586-27", dataLeAk586);
		android.util.Log.d("leak-587-27", dataLeAk587);
		android.util.Log.d("leak-590-27", dataLeAk590);
		android.util.Log.d("leak-591-27", dataLeAk591);
		android.util.Log.d("leak-592-27", dataLeAk592);
		android.util.Log.d("leak-593-27", dataLeAk593);
		android.util.Log.d("leak-594-27", dataLeAk594);
		android.util.Log.d("leak-595-27", dataLeAk595);
		android.util.Log.d("leak-596-27", dataLeAk596);
		android.util.Log.d("leak-597-27", dataLeAk597);
		android.util.Log.d("leak-598-27", dataLeAk598);
		android.util.Log.d("leak-599-27", dataLeAk599);
		android.util.Log.d("leak-600-27", dataLeAk600);
		android.util.Log.d("leak-601-27", dataLeAk601);
		android.util.Log.d("leak-604-27", dataLeAk604);
		android.util.Log.d("leak-605-27", dataLeAk605);
		android.util.Log.d("leak-606-27", dataLeAk606);
		android.util.Log.d("leak-607-27", dataLeAk607);
		android.util.Log.d("leak-608-27", dataLeAk608);
		android.util.Log.d("leak-609-27", dataLeAk609);
		android.util.Log.d("leak-610-27", dataLeAk610);
		android.util.Log.d("leak-611-27", dataLeAk611);
		android.util.Log.d("leak-612-27", dataLeAk612);
		android.util.Log.d("leak-613-27", dataLeAk613);
		android.util.Log.d("leak-614-27", dataLeAk614);
		android.util.Log.d("leak-615-27", dataLeAk615);
		android.util.Log.d("leak-616-27", dataLeAk616);
		android.util.Log.d("leak-620-27", dataLeAk620);
		android.util.Log.d("leak-621-27", dataLeAk621);
		android.util.Log.d("leak-622-27", dataLeAk622);
		logDebug("Querying SKU details.");
        ArrayList<String> skuList = new ArrayList<String>();
        skuList.addAll(inv.getAllOwnedSkus(itemType));
        if (moreSkus != null) {
            for (String sku : moreSkus) {
                if (!skuList.contains(sku)) {
                    skuList.add(sku);
                }
            }
        }

        if (skuList.size() == 0) {
            logDebug("queryPrices: nothing to do because there are no SKUs.");
            return BILLING_RESPONSE_RESULT_OK;
        }

        // Split the sku list in blocks of no more than 20 elements.
        ArrayList<ArrayList<String>> packs = new ArrayList<ArrayList<String>>();
        ArrayList<String> tempList;
        int n = skuList.size() / 20;
        int mod = skuList.size() % 20;
        for (int i = 0; i < n; i++) {
            tempList = new ArrayList<String>();
            for (String s : skuList.subList(i * 20, i * 20 + 20)) {
                tempList.add(s);
            }
            packs.add(tempList);
        }
        if (mod != 0) {
            tempList = new ArrayList<String>();
            for (String s : skuList.subList(n * 20, n * 20 + mod)) {
                tempList.add(s);
            }
            packs.add(tempList);
        }

        for (ArrayList<String> skuPartList : packs) {
            Bundle querySkus = new Bundle();
            querySkus.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, skuPartList);
            Bundle skuDetails = mService.getSkuDetails(3, mContext.getPackageName(),
                    itemType, querySkus);

            if (!skuDetails.containsKey(RESPONSE_GET_SKU_DETAILS_LIST)) {
                int response = getResponseCodeFromBundle(skuDetails);
                if (response != BILLING_RESPONSE_RESULT_OK) {
                    logDebug("getSkuDetails() failed: " + getResponseDesc(response));
                    return response;
                } else {
                    logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    return IABHELPER_BAD_RESPONSE;
                }
            }

            ArrayList<String> responseList = skuDetails.getStringArrayList(
                    RESPONSE_GET_SKU_DETAILS_LIST);

            for (String thisResponse : responseList) {
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
        dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-28", dataLeAk584);
		android.util.Log.d("leak-585-28", dataLeAk585);
		android.util.Log.d("leak-586-28", dataLeAk586);
		android.util.Log.d("leak-587-28", dataLeAk587);
		android.util.Log.d("leak-590-28", dataLeAk590);
		android.util.Log.d("leak-591-28", dataLeAk591);
		android.util.Log.d("leak-592-28", dataLeAk592);
		android.util.Log.d("leak-593-28", dataLeAk593);
		android.util.Log.d("leak-594-28", dataLeAk594);
		android.util.Log.d("leak-595-28", dataLeAk595);
		android.util.Log.d("leak-596-28", dataLeAk596);
		android.util.Log.d("leak-597-28", dataLeAk597);
		android.util.Log.d("leak-598-28", dataLeAk598);
		android.util.Log.d("leak-599-28", dataLeAk599);
		android.util.Log.d("leak-600-28", dataLeAk600);
		android.util.Log.d("leak-601-28", dataLeAk601);
		android.util.Log.d("leak-604-28", dataLeAk604);
		android.util.Log.d("leak-605-28", dataLeAk605);
		android.util.Log.d("leak-606-28", dataLeAk606);
		android.util.Log.d("leak-607-28", dataLeAk607);
		android.util.Log.d("leak-608-28", dataLeAk608);
		android.util.Log.d("leak-609-28", dataLeAk609);
		android.util.Log.d("leak-610-28", dataLeAk610);
		android.util.Log.d("leak-611-28", dataLeAk611);
		android.util.Log.d("leak-612-28", dataLeAk612);
		android.util.Log.d("leak-613-28", dataLeAk613);
		android.util.Log.d("leak-614-28", dataLeAk614);
		android.util.Log.d("leak-615-28", dataLeAk615);
		android.util.Log.d("leak-616-28", dataLeAk616);
		android.util.Log.d("leak-620-28", dataLeAk620);
		android.util.Log.d("leak-621-28", dataLeAk621);
		android.util.Log.d("leak-622-28", dataLeAk622);
		final Handler handler = new Handler();
        flagStartAsync("consume");
        (new Thread(new Runnable() {
            final String dataLeAk632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk617 = "";

			public void run() {
                dataLeAk617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-629-0", dataLeAk629);
				android.util.Log.d("leak-617-0", dataLeAk617);
				final List<IabResult> results = new ArrayList<IabResult>();
                for (Purchase purchase : purchases) {
                    try {
                        consume(purchase);
                        results.add(new IabResult(BILLING_RESPONSE_RESULT_OK, "Successful consume of sku " + purchase.getSku()));
                    }
                    catch (IabException ex) {
                        results.add(ex.getResult());
                    }
                }

                flagEndAsync();
                if (!mDisposed && singleListener != null) {
                    handler.post(new Runnable() {
                        String dataLeAk618 = "";

						public void run() {
                            dataLeAk618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-631-0", dataLeAk631);
							android.util.Log.d("leak-630-0", dataLeAk630);
							android.util.Log.d("leak-618-0", dataLeAk618);
							singleListener.onConsumeFinished(purchases.get(0), results.get(0));
                        }
                    });
                }
                if (!mDisposed && multiListener != null) {
                    handler.post(new Runnable() {
                        String dataLeAk619 = "";

						public void run() {
                            dataLeAk619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-633-0", dataLeAk633);
							android.util.Log.d("leak-632-0", dataLeAk632);
							android.util.Log.d("leak-619-0", dataLeAk619);
							multiListener.onConsumeMultiFinished(purchases, results);
                        }
                    });
                }
            }
        })).start();
    }

    void logDebug(String msg) {
        dataLeAk620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-29", dataLeAk584);
		android.util.Log.d("leak-585-29", dataLeAk585);
		android.util.Log.d("leak-586-29", dataLeAk586);
		android.util.Log.d("leak-587-29", dataLeAk587);
		android.util.Log.d("leak-590-29", dataLeAk590);
		android.util.Log.d("leak-591-29", dataLeAk591);
		android.util.Log.d("leak-592-29", dataLeAk592);
		android.util.Log.d("leak-593-29", dataLeAk593);
		android.util.Log.d("leak-594-29", dataLeAk594);
		android.util.Log.d("leak-595-29", dataLeAk595);
		android.util.Log.d("leak-596-29", dataLeAk596);
		android.util.Log.d("leak-597-29", dataLeAk597);
		android.util.Log.d("leak-598-29", dataLeAk598);
		android.util.Log.d("leak-599-29", dataLeAk599);
		android.util.Log.d("leak-600-29", dataLeAk600);
		android.util.Log.d("leak-601-29", dataLeAk601);
		android.util.Log.d("leak-604-29", dataLeAk604);
		android.util.Log.d("leak-605-29", dataLeAk605);
		android.util.Log.d("leak-606-29", dataLeAk606);
		android.util.Log.d("leak-607-29", dataLeAk607);
		android.util.Log.d("leak-608-29", dataLeAk608);
		android.util.Log.d("leak-609-29", dataLeAk609);
		android.util.Log.d("leak-610-29", dataLeAk610);
		android.util.Log.d("leak-611-29", dataLeAk611);
		android.util.Log.d("leak-612-29", dataLeAk612);
		android.util.Log.d("leak-613-29", dataLeAk613);
		android.util.Log.d("leak-614-29", dataLeAk614);
		android.util.Log.d("leak-615-29", dataLeAk615);
		android.util.Log.d("leak-616-29", dataLeAk616);
		android.util.Log.d("leak-620-29", dataLeAk620);
		android.util.Log.d("leak-621-29", dataLeAk621);
		android.util.Log.d("leak-622-29", dataLeAk622);
		if (mDebugLog) Log.d(mDebugTag, msg);
    }

    void logError(String msg) {
        dataLeAk621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-30", dataLeAk584);
		android.util.Log.d("leak-585-30", dataLeAk585);
		android.util.Log.d("leak-586-30", dataLeAk586);
		android.util.Log.d("leak-587-30", dataLeAk587);
		android.util.Log.d("leak-590-30", dataLeAk590);
		android.util.Log.d("leak-591-30", dataLeAk591);
		android.util.Log.d("leak-592-30", dataLeAk592);
		android.util.Log.d("leak-593-30", dataLeAk593);
		android.util.Log.d("leak-594-30", dataLeAk594);
		android.util.Log.d("leak-595-30", dataLeAk595);
		android.util.Log.d("leak-596-30", dataLeAk596);
		android.util.Log.d("leak-597-30", dataLeAk597);
		android.util.Log.d("leak-598-30", dataLeAk598);
		android.util.Log.d("leak-599-30", dataLeAk599);
		android.util.Log.d("leak-600-30", dataLeAk600);
		android.util.Log.d("leak-601-30", dataLeAk601);
		android.util.Log.d("leak-604-30", dataLeAk604);
		android.util.Log.d("leak-605-30", dataLeAk605);
		android.util.Log.d("leak-606-30", dataLeAk606);
		android.util.Log.d("leak-607-30", dataLeAk607);
		android.util.Log.d("leak-608-30", dataLeAk608);
		android.util.Log.d("leak-609-30", dataLeAk609);
		android.util.Log.d("leak-610-30", dataLeAk610);
		android.util.Log.d("leak-611-30", dataLeAk611);
		android.util.Log.d("leak-612-30", dataLeAk612);
		android.util.Log.d("leak-613-30", dataLeAk613);
		android.util.Log.d("leak-614-30", dataLeAk614);
		android.util.Log.d("leak-615-30", dataLeAk615);
		android.util.Log.d("leak-616-30", dataLeAk616);
		android.util.Log.d("leak-620-30", dataLeAk620);
		android.util.Log.d("leak-621-30", dataLeAk621);
		android.util.Log.d("leak-622-30", dataLeAk622);
		Log.e(mDebugTag, "In-app billing error: " + msg);
    }

    void logWarn(String msg) {
        dataLeAk622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-584-31", dataLeAk584);
		android.util.Log.d("leak-585-31", dataLeAk585);
		android.util.Log.d("leak-586-31", dataLeAk586);
		android.util.Log.d("leak-587-31", dataLeAk587);
		android.util.Log.d("leak-590-31", dataLeAk590);
		android.util.Log.d("leak-591-31", dataLeAk591);
		android.util.Log.d("leak-592-31", dataLeAk592);
		android.util.Log.d("leak-593-31", dataLeAk593);
		android.util.Log.d("leak-594-31", dataLeAk594);
		android.util.Log.d("leak-595-31", dataLeAk595);
		android.util.Log.d("leak-596-31", dataLeAk596);
		android.util.Log.d("leak-597-31", dataLeAk597);
		android.util.Log.d("leak-598-31", dataLeAk598);
		android.util.Log.d("leak-599-31", dataLeAk599);
		android.util.Log.d("leak-600-31", dataLeAk600);
		android.util.Log.d("leak-601-31", dataLeAk601);
		android.util.Log.d("leak-604-31", dataLeAk604);
		android.util.Log.d("leak-605-31", dataLeAk605);
		android.util.Log.d("leak-606-31", dataLeAk606);
		android.util.Log.d("leak-607-31", dataLeAk607);
		android.util.Log.d("leak-608-31", dataLeAk608);
		android.util.Log.d("leak-609-31", dataLeAk609);
		android.util.Log.d("leak-610-31", dataLeAk610);
		android.util.Log.d("leak-611-31", dataLeAk611);
		android.util.Log.d("leak-612-31", dataLeAk612);
		android.util.Log.d("leak-613-31", dataLeAk613);
		android.util.Log.d("leak-614-31", dataLeAk614);
		android.util.Log.d("leak-615-31", dataLeAk615);
		android.util.Log.d("leak-616-31", dataLeAk616);
		android.util.Log.d("leak-620-31", dataLeAk620);
		android.util.Log.d("leak-621-31", dataLeAk621);
		android.util.Log.d("leak-622-31", dataLeAk622);
		Log.w(mDebugTag, "In-app billing warning: " + msg);
    }
}
