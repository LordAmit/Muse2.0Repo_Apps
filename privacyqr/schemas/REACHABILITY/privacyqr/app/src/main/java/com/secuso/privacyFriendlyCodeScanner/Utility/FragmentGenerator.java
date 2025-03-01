package com.secuso.privacyFriendlyCodeScanner.Utility;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import com.journeyapps.barcodescanner.BarcodeResult;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.ContactFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.EmailFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.ProductFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.SendEmailFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.SmsFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.TelFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.TextFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.UrlFragment;
import com.secuso.privacyFriendlyCodeScanner.ResultFragments.WifiFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Philipp on 14/09/2015.
 */
public class FragmentGenerator {
    String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);

	public static Fragment getFragment(BarcodeResult result) {
        String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);
		Fragment fragment;
        String format = result.getBarcodeFormat().name();
        String content = result.getResult().toString();

        if(!format.contains("QR_CODE"))
            fragment = new ProductFragment();
        else {
            String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
			if (content.startsWith("WIFI:"))
                fragment = new WifiFragment();
            else if (content.startsWith("tel:"))
                fragment = new TelFragment();
            else if (content.startsWith("SMSTO:"))
                fragment = new SmsFragment();
            else if (content.startsWith("mailto:"))
                fragment = new EmailFragment();
            else if (content.startsWith("MATMSG:"))
                fragment = new SendEmailFragment();
            else if (content.startsWith("BEGIN:VCARD"))
                fragment = new ContactFragment();
            else if (content.startsWith("http://") || content.startsWith("https://") || content.startsWith("www."))
                fragment = new UrlFragment();
            else
                fragment = new TextFragment();
        }

        Bundle bundle = new Bundle();
        bundle.putString("result_content", result.getResult().toString());
        Log.e("TESTER", result.getResult().toString());
        fragment.setArguments(bundle);

        return fragment;
    }

    public static Fragment getFragmentFromContent(String content) {
        String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);
		Fragment fragment;
        boolean isProduct = false;

        Pattern r = Pattern.compile("[0-9]+");
        Matcher m = r.matcher(content);
        if(m.find()) isProduct = true;

        if (content.startsWith("WIFI:"))
            fragment = new WifiFragment();
        else if (content.startsWith("tel:"))
            fragment = new TelFragment();
        else if (content.startsWith("SMSTO:"))
            fragment = new SmsFragment();
        else if (content.startsWith("mailto:"))
            fragment = new EmailFragment();
        else if (content.startsWith("MATMSG:"))
            fragment = new SendEmailFragment();
        else if (content.startsWith("BEGIN:VCARD"))
            fragment = new ContactFragment();
        else if (content.startsWith("http://") || content.startsWith("https://") || content.startsWith("www."))
            fragment = new UrlFragment();
        else if(isProduct)
            fragment = new ProductFragment();
        else
            fragment = new TextFragment();

        Bundle bundle = new Bundle();
        bundle.putString("result_content", content);
        fragment.setArguments(bundle);

        return fragment;
    }
}
