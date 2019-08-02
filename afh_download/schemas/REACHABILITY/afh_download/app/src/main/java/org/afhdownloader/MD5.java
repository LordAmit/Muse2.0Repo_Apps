/*
 * Copyright (C) 2012 The CyanogenMod Project
 *
 * * Licensed under the GNU GPLv2 license
 *
 * The text of the license can be found in the LICENSE file
 * or at https://www.gnu.org/licenses/gpl-2.0.txt
 */

package org.afhdownloader;

import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk244 = android.util.Log.d("leak-244", dataLeAk244);

	private static final String TAG = "MD5";

    public static boolean checkMD5(String md5, File updateFile) {
        String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk245 = android.util.Log.d("leak-245", dataLeAk245);
		if (TextUtils.isEmpty(md5) || updateFile == null) {
            String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk246 = android.util.Log.d("leak-246", dataLeAk246);
			Log.e(TAG, "MD5 string empty or updateFile null");
            return false;
        }

        String calculatedDigest = calculateMD5(updateFile);
        if (calculatedDigest == null) {
            String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk247 = android.util.Log.d("leak-247", dataLeAk247);
			Log.e(TAG, "calculatedDigest null");
            return false;
        }

        Log.v(TAG, "Calculated digest: " + calculatedDigest);
        Log.v(TAG, "Provided digest: " + md5);

        return calculatedDigest.equalsIgnoreCase(md5);
    }

    public static String calculateMD5(File updateFile) {
        String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk248 = android.util.Log.d("leak-248", dataLeAk248);
		MessageDigest digest;
        try {
            String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk249 = android.util.Log.d("leak-249", dataLeAk249);
			digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk250 = android.util.Log.d("leak-250", dataLeAk250);
			Log.e(TAG, "Exception while getting digest", e);
            return null;
        }

        InputStream is;
        try {
            String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk251 = android.util.Log.d("leak-251", dataLeAk251);
			is = new FileInputStream(updateFile);
        } catch (FileNotFoundException e) {
            String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk252 = android.util.Log.d("leak-252", dataLeAk252);
			Log.e(TAG, "Exception while getting FileInputStream", e);
            return null;
        }

        byte[] buffer = new byte[8192];
        int read;
        try {
            String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk253 = android.util.Log.d("leak-253", dataLeAk253);
			while ((read = is.read(buffer)) > 0) {
                String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk254 = android.util.Log.d("leak-254", dataLeAk254);
				digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            // Fill to 32 chars
            output = String.format("%32s", output).replace(' ', '0');
            return output;
        } catch (IOException e) {
            String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk255 = android.util.Log.d("leak-255", dataLeAk255);
			throw new RuntimeException("Unable to process file for MD5", e);
        } finally {
            String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk256 = android.util.Log.d("leak-256", dataLeAk256);
			try {
                String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk257 = android.util.Log.d("leak-257", dataLeAk257);
				is.close();
            } catch (IOException e) {
                String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk258 = android.util.Log.d("leak-258", dataLeAk258);
				Log.e(TAG, "Exception on closing MD5 input stream", e);
            }
        }
    }
}
