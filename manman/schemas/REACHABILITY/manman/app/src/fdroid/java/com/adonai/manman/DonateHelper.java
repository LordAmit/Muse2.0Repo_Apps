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
    String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);

	private Activity mActivity;

    public DonateHelper(Activity activity) {
        String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);
		mActivity = activity;
    }

    public void purchaseGift() {
        String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(R.string.donate)
                .setMessage(R.string.thanks_for_pledge)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(R.string.donate_via_paypal, new PaypalDonateListener())
                .create().show();
    }

    public boolean handleActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
		return false;
    }

    public void handleActivityDestroy() {
		String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
        // nothing to do here :)
    }

    private class PaypalDonateListener implements DialogInterface.OnClickListener {
        String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);


		@Override
        public void onClick(DialogInterface dialog, int which) {
            String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
			donatePayPalOnClick();
        }


        /**
         * Donate button with PayPal by opening browser with defined URL For possible parameters see:
         * https://developer.paypal.com/webapps/developer/docs/classic/paypal-payments-standard/integration-guide/Appx_websitestandard_htmlvariables/
         *
         */
        public void donatePayPalOnClick() {
            String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
			Uri.Builder uriBuilder = new Uri.Builder();
            /* https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=6CFFYXFT6QT46 */
            uriBuilder.scheme("https").authority("www.paypal.com").path("cgi-bin/webscr");
            uriBuilder.appendQueryParameter("cmd", "_s-xclick");
            uriBuilder.appendQueryParameter("hosted_button_id", "6CFFYXFT6QT46");
            Uri payPalUri = uriBuilder.build();
            try {
                String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
				Intent viewIntent = new Intent(Intent.ACTION_VIEW, payPalUri);
                mActivity.startActivity(viewIntent);
            } catch (ActivityNotFoundException e) {
                String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
				Toast.makeText(mActivity, R.string.donations_alert_dialog_no_browser, Toast.LENGTH_LONG).show();
            }
        }
    }
}
