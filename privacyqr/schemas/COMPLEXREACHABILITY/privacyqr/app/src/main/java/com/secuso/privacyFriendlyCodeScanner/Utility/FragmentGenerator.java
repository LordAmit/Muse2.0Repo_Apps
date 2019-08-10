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
    public static Fragment getFragment(BarcodeResult result) {
        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
		android.util.Log.d("leak-131", dataLeAkPath131);
		Fragment fragment;
        String format = result.getBarcodeFormat().name();
        String content = result.getResult().toString();

        if(!format.contains("QR_CODE"))
            fragment = new ProductFragment();
        else {
            String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
			String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
			android.util.Log.d("leak-132", dataLeAkPath132);
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
        String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP133.put("test", new java.util.HashMap<String, String>());
		leakMaP133.get("test").put("test", dataLeAk133);
		String dataLeAkPath133 = leakMaP133.get("test").get("test");
		android.util.Log.d("leak-133", dataLeAkPath133);
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
