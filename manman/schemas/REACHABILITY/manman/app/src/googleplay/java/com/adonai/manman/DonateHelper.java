package com.adonai.manman;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;

import com.android.vending.util.IabHelper;
import com.android.vending.util.IabResult;
import com.android.vending.util.Inventory;
import com.android.vending.util.Purchase;

import java.util.Date;

/**
 * Implementation of donate helper class with Google Play bindings
 *
 * @author Oleg Chernovskiy
 */
public class DonateHelper {
    String dataLeAk961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk961 = android.util.Log.d("leak-961", dataLeAk961);

	private static final String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA51neavcx/+qXg/uguvvN3511aPXP6jgPc2Q0+ekGNeS2lNzwpq5+qBywbQ2PIs0DPvLrtiOwpxxNmKn4EH6i9YmmrEa02rVg1DdJnodZarx/Bg28V55YUKSGAWHKCZVrCSy+VXyVu4iBMmpHf/oHsLxeZqpx7s7YAvzJ4mqoDHThf39RLmnwWPKRl2WFnsDBX9vNCchx5xE8OdZXZZI9zkc46JJxeiJa3ypqAqMhiDPX/E3lznKCoavPGH7z/mCXwc63nSW1LmRnViT3Zg/onPtcsc/NyahYfoEllA2Vx8QG709w7sp8MngjxHGJ1ZzFDd22UeaiOvoIKBwzA0BUxwIDAQAB";

    private Activity mActivity;

    // helpers for donations (from android vending tutorial)
    private static final String SKU_DONATE = "small";
    private IabHelper mHelper;
    private boolean mCanBuy = false;

    /**
     * Should be called on activity on-create method
     */
    public DonateHelper(Activity activity) {
        String dataLeAk962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk962 = android.util.Log.d("leak-962", dataLeAk962);
		mActivity = activity;
        mHelper = new IabHelper(activity, base64EncodedPublicKey);
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            String dataLeAk963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk963 = android.util.Log.d("leak-963", dataLeAk963);

			@Override
            public void onIabSetupFinished(IabResult result) {
                String dataLeAk964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk964 = android.util.Log.d("leak-964", dataLeAk964);
				if (result.isSuccess())
                    mCanBuy = true;
            }
        });
    }

    // needed for vending
    public void purchaseGift() {
        String dataLeAk965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk965 = android.util.Log.d("leak-965", dataLeAk965);
		if (mCanBuy) {
            String dataLeAk966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk966 = android.util.Log.d("leak-966", dataLeAk966);
			mHelper.launchPurchaseFlow(mActivity, SKU_DONATE, 6666, new IabHelper.OnIabPurchaseFinishedListener() {
                String dataLeAk967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk967 = android.util.Log.d("leak-967", dataLeAk967);

				@Override
                public void onIabPurchaseFinished(IabResult result, Purchase info) {
                    String dataLeAk968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk968 = android.util.Log.d("leak-968", dataLeAk968);
					if (result.isSuccess()) {
                        String dataLeAk969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk969 = android.util.Log.d("leak-969", dataLeAk969);
						AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                        builder.setTitle(R.string.completed).setMessage(R.string.thanks_for_pledge);
                        builder.setPositiveButton(android.R.string.ok, null);
                        builder.create().show();
                    }

                    mHelper.queryInventoryAsync(false, new IabHelper.QueryInventoryFinishedListener() {
                        String dataLeAk970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk970 = android.util.Log.d("leak-970", dataLeAk970);

						@Override
                        public void onQueryInventoryFinished(IabResult result, Inventory inv) {
                            String dataLeAk971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk971 = android.util.Log.d("leak-971", dataLeAk971);
							if (result.isSuccess()) {
                                String dataLeAk972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk972 = android.util.Log.d("leak-972", dataLeAk972);
								if (inv.getPurchase(SKU_DONATE) != null)
                                    mHelper.consumeAsync(inv.getPurchase(SKU_DONATE), null);
                            }
                        }
                    });
                }
            }, "ManManDonation " + new Date());
        }
    }

    public boolean handleActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk973 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk973 = android.util.Log.d("leak-973", dataLeAk973);
		return mHelper.handleActivityResult(requestCode, resultCode, data);
    }

    public void handleActivityDestroy() {
        String dataLeAk974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk974 = android.util.Log.d("leak-974", dataLeAk974);
		// needed for vending
        if (mCanBuy)
            mHelper.dispose();
    }
}
