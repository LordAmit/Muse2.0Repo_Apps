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
        String dataLeAk829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP829 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP829.put("test", new java.util.HashMap<String, String>());
		leakMaP829.get("test").put("test", dataLeAk829);
		String dataLeAkPath829 = leakMaP829.get("test").get("test");
		android.util.Log.d("leak-829", dataLeAkPath829);
		mActivity = activity;
        mHelper = new IabHelper(activity, base64EncodedPublicKey);
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            @Override
            public void onIabSetupFinished(IabResult result) {
                String dataLeAk830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer830 = new StringBuffer();for (char chAr830 : dataLeAk830.toCharArray()) {leakBuFFer830.append(chAr830);}String dataLeAkPath830 = leakBuFFer830.toString();
				android.util.Log.d("leak-830", dataLeAkPath830);
				if (result.isSuccess())
                    mCanBuy = true;
            }
        });
    }

    // needed for vending
    public void purchaseGift() {
        String dataLeAk831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath831;try {throw new Exception(dataLeAk831);} catch (Exception leakErRor831) {dataLeAkPath831 = leakErRor831.getMessage();}
		android.util.Log.d("leak-831", dataLeAkPath831);
		if (mCanBuy) {
            String dataLeAk832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay832 = new String[] {"n/a", dataLeAk832};
			String dataLeAkPath832 = leakArRay832[leakArRay832.length - 1];
			android.util.Log.d("leak-832", dataLeAkPath832);
			mHelper.launchPurchaseFlow(mActivity, SKU_DONATE, 6666, new IabHelper.OnIabPurchaseFinishedListener() {
                @Override
                public void onIabPurchaseFinished(IabResult result, Purchase info) {
                    String dataLeAk833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP833 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP833.put("test", new java.util.HashMap<String, String>());
					leakMaP833.get("test").put("test", dataLeAk833);
					String dataLeAkPath833 = leakMaP833.get("test").get("test");
					android.util.Log.d("leak-833", dataLeAkPath833);
					if (result.isSuccess()) {
                        String dataLeAk834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer834 = new StringBuffer();for (char chAr834 : dataLeAk834.toCharArray()) {leakBuFFer834.append(chAr834);}String dataLeAkPath834 = leakBuFFer834.toString();
						android.util.Log.d("leak-834", dataLeAkPath834);
						AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                        builder.setTitle(R.string.completed).setMessage(R.string.thanks_for_pledge);
                        builder.setPositiveButton(android.R.string.ok, null);
                        builder.create().show();
                    }

                    mHelper.queryInventoryAsync(false, new IabHelper.QueryInventoryFinishedListener() {
                        @Override
                        public void onQueryInventoryFinished(IabResult result, Inventory inv) {
                            String dataLeAk835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath835;try {throw new Exception(dataLeAk835);} catch (Exception leakErRor835) {dataLeAkPath835 = leakErRor835.getMessage();}
							android.util.Log.d("leak-835", dataLeAkPath835);
							if (result.isSuccess()) {
                                String dataLeAk836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay836 = new String[] {"n/a", dataLeAk836};
								String dataLeAkPath836 = leakArRay836[leakArRay836.length - 1];
								android.util.Log.d("leak-836", dataLeAkPath836);
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
        String dataLeAk837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP837 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP837.put("test", new java.util.HashMap<String, String>());
		leakMaP837.get("test").put("test", dataLeAk837);
		String dataLeAkPath837 = leakMaP837.get("test").get("test");
		android.util.Log.d("leak-837", dataLeAkPath837);
		return mHelper.handleActivityResult(requestCode, resultCode, data);
    }

    public void handleActivityDestroy() {
        String dataLeAk838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer838 = new StringBuffer();for (char chAr838 : dataLeAk838.toCharArray()) {leakBuFFer838.append(chAr838);}String dataLeAkPath838 = leakBuFFer838.toString();
		android.util.Log.d("leak-838", dataLeAkPath838);
		// needed for vending
        if (mCanBuy)
            mHelper.dispose();
    }
}
