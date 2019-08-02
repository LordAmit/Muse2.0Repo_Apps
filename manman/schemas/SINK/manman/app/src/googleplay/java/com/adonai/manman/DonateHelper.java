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
    final String dataLeAk646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk641 = "";

	String dataLeAk640 = "";

	String dataLeAk637 = "";

	String dataLeAk635 = "";

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
        dataLeAk635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-635-0", dataLeAk635);
		android.util.Log.d("leak-637-0", dataLeAk637);
		android.util.Log.d("leak-640-0", dataLeAk640);
		android.util.Log.d("leak-641-0", dataLeAk641);
		mActivity = activity;
        mHelper = new IabHelper(activity, base64EncodedPublicKey);
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            String dataLeAk636 = "";

			@Override
            public void onIabSetupFinished(IabResult result) {
                dataLeAk636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-643-0", dataLeAk643);
				android.util.Log.d("leak-636-0", dataLeAk636);
				if (result.isSuccess())
                    mCanBuy = true;
            }
        });
    }

    // needed for vending
    public void purchaseGift() {
        dataLeAk637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-635-1", dataLeAk635);
		android.util.Log.d("leak-637-1", dataLeAk637);
		android.util.Log.d("leak-640-1", dataLeAk640);
		android.util.Log.d("leak-641-1", dataLeAk641);
		if (mCanBuy) {
            mHelper.launchPurchaseFlow(mActivity, SKU_DONATE, 6666, new IabHelper.OnIabPurchaseFinishedListener() {
                final String dataLeAk645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				String dataLeAk638 = "";

				@Override
                public void onIabPurchaseFinished(IabResult result, Purchase info) {
                    dataLeAk638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-644-0", dataLeAk644);
					android.util.Log.d("leak-638-0", dataLeAk638);
					if (result.isSuccess()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                        builder.setTitle(R.string.completed).setMessage(R.string.thanks_for_pledge);
                        builder.setPositiveButton(android.R.string.ok, null);
                        builder.create().show();
                    }

                    mHelper.queryInventoryAsync(false, new IabHelper.QueryInventoryFinishedListener() {
                        String dataLeAk639 = "";

						@Override
                        public void onQueryInventoryFinished(IabResult result, Inventory inv) {
                            dataLeAk639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-646-0", dataLeAk646);
							android.util.Log.d("leak-645-0", dataLeAk645);
							android.util.Log.d("leak-639-0", dataLeAk639);
							if (result.isSuccess()) {
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
        dataLeAk640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-635-2", dataLeAk635);
		android.util.Log.d("leak-637-2", dataLeAk637);
		android.util.Log.d("leak-640-2", dataLeAk640);
		android.util.Log.d("leak-641-2", dataLeAk641);
		return mHelper.handleActivityResult(requestCode, resultCode, data);
    }

    public void handleActivityDestroy() {
        dataLeAk641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-635-3", dataLeAk635);
		android.util.Log.d("leak-637-3", dataLeAk637);
		android.util.Log.d("leak-640-3", dataLeAk640);
		android.util.Log.d("leak-641-3", dataLeAk641);
		// needed for vending
        if (mCanBuy)
            mHelper.dispose();
    }
}
