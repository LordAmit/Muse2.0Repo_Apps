package com.adonai.manman;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * Another implementation of donate class with direct paypal bindings
 * It's diverged from `release` one because Google forbids any payment methods in its applications but Google Wallet
 *
 * @author Oleg Chernovskiy
 */
public class DonateHelper {
    private Activity mActivity;

    public DonateHelper(Activity activity) {
        String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);
		mActivity = activity;
    }

    public void purchaseGift() {
        String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1.put("test", new java.util.HashMap<String, String>());
		leakMaP1.get("test").put("test", dataLeAk1);
		String dataLeAkPath1 = leakMaP1.get("test").get("test");
		android.util.Log.d("leak-1", dataLeAkPath1);
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(R.string.donate)
                .setMessage(R.string.thanks_for_pledge)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(R.string.donate_via_paypal, new PaypalDonateListener())
                .create().show();
    }

    public boolean handleActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
		android.util.Log.d("leak-2", dataLeAkPath2);
		return false;
    }

    public void handleActivityDestroy() {
		String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
		android.util.Log.d("leak-3", dataLeAkPath3);
        // nothing to do here :)
    }

    private class PaypalDonateListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
			String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
			android.util.Log.d("leak-4", dataLeAkPath4);
			donatePayPalOnClick();
        }


        /**
         * Donate button with PayPal by opening browser with defined URL For possible parameters see:
         * https://developer.paypal.com/webapps/developer/docs/classic/paypal-payments-standard/integration-guide/Appx_websitestandard_htmlvariables/
         *
         */
        public void donatePayPalOnClick() {
            String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP5.put("test", new java.util.HashMap<String, String>());
			leakMaP5.get("test").put("test", dataLeAk5);
			String dataLeAkPath5 = leakMaP5.get("test").get("test");
			android.util.Log.d("leak-5", dataLeAkPath5);
			Uri.Builder uriBuilder = new Uri.Builder();
            /* https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=6CFFYXFT6QT46 */
            uriBuilder.scheme("https").authority("www.paypal.com").path("cgi-bin/webscr");
            uriBuilder.appendQueryParameter("cmd", "_s-xclick");
            uriBuilder.appendQueryParameter("hosted_button_id", "6CFFYXFT6QT46");
            Uri payPalUri = uriBuilder.build();
            try {
                String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
				android.util.Log.d("leak-6", dataLeAkPath6);
				Intent viewIntent = new Intent(Intent.ACTION_VIEW, payPalUri);
                mActivity.startActivity(viewIntent);
            } catch (ActivityNotFoundException e) {
                String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
				android.util.Log.d("leak-7", dataLeAkPath7);
				Toast.makeText(mActivity, R.string.donations_alert_dialog_no_browser, Toast.LENGTH_LONG).show();
            }
        }
    }
}
