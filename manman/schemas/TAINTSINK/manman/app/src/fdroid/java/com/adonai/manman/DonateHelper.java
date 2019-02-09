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
    String dataLeAk3 = "3";

	String dataLeAk2 = "2";

	String dataLeAk1 = "1";

	String dataLeAk0 = "0";

	private Activity mActivity;

    public DonateHelper(Activity activity) {
        dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-1-0", dataLeAk1);
		android.util.Log.d("leak-2-0", dataLeAk2);
		android.util.Log.d("leak-3-0", dataLeAk3);
		mActivity = activity;
    }

    public void purchaseGift() {
        dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-2-1", dataLeAk2);
		android.util.Log.d("leak-3-1", dataLeAk3);
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(R.string.donate)
                .setMessage(R.string.thanks_for_pledge)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(R.string.donate_via_paypal, new PaypalDonateListener())
                .create().show();
    }

    public boolean handleActivityResult(int requestCode, int resultCode, Intent data) {
        dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-2", dataLeAk0);
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-3-2", dataLeAk3);
		return false;
    }

    public void handleActivityDestroy() {
		dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // nothing to do here :)
		android.util.Log.d("leak-0-3", dataLeAk0);
		android.util.Log.d("leak-1-3", dataLeAk1);
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-3-3", dataLeAk3);
    }

    private class PaypalDonateListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            donatePayPalOnClick();
        }


        /**
         * Donate button with PayPal by opening browser with defined URL For possible parameters see:
         * https://developer.paypal.com/webapps/developer/docs/classic/paypal-payments-standard/integration-guide/Appx_websitestandard_htmlvariables/
         *
         */
        public void donatePayPalOnClick() {
            Uri.Builder uriBuilder = new Uri.Builder();
            /* https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=6CFFYXFT6QT46 */
            uriBuilder.scheme("https").authority("www.paypal.com").path("cgi-bin/webscr");
            uriBuilder.appendQueryParameter("cmd", "_s-xclick");
            uriBuilder.appendQueryParameter("hosted_button_id", "6CFFYXFT6QT46");
            Uri payPalUri = uriBuilder.build();
            try {
                Intent viewIntent = new Intent(Intent.ACTION_VIEW, payPalUri);
                mActivity.startActivity(viewIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(mActivity, R.string.donations_alert_dialog_no_browser, Toast.LENGTH_LONG).show();
            }
        }
    }
}
