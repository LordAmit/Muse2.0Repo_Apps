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
    private static final String TAG = "MD5";

    public static boolean checkMD5(String md5, File updateFile) {
        String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer214 = new StringBuffer();for (char chAr214 : dataLeAk214.toCharArray()) {leakBuFFer214.append(chAr214);}String dataLeAkPath214 = leakBuFFer214.toString();
		android.util.Log.d("leak-214", dataLeAkPath214);
		if (TextUtils.isEmpty(md5) || updateFile == null) {
            String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath215;try {throw new Exception(dataLeAk215);} catch (Exception leakErRor215) {dataLeAkPath215 = leakErRor215.getMessage();}
			android.util.Log.d("leak-215", dataLeAkPath215);
			Log.e(TAG, "MD5 string empty or updateFile null");
            return false;
        }

        String calculatedDigest = calculateMD5(updateFile);
        if (calculatedDigest == null) {
            String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay216 = new String[] {"n/a", dataLeAk216};
			String dataLeAkPath216 = leakArRay216[leakArRay216.length - 1];
			android.util.Log.d("leak-216", dataLeAkPath216);
			Log.e(TAG, "calculatedDigest null");
            return false;
        }

        Log.v(TAG, "Calculated digest: " + calculatedDigest);
        Log.v(TAG, "Provided digest: " + md5);

        return calculatedDigest.equalsIgnoreCase(md5);
    }

    public static String calculateMD5(File updateFile) {
        String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP217 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP217.put("test", new java.util.HashMap<String, String>());
		leakMaP217.get("test").put("test", dataLeAk217);
		String dataLeAkPath217 = leakMaP217.get("test").get("test");
		android.util.Log.d("leak-217", dataLeAkPath217);
		MessageDigest digest;
        try {
            String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer218 = new StringBuffer();for (char chAr218 : dataLeAk218.toCharArray()) {leakBuFFer218.append(chAr218);}String dataLeAkPath218 = leakBuFFer218.toString();
			android.util.Log.d("leak-218", dataLeAkPath218);
			digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath219;try {throw new Exception(dataLeAk219);} catch (Exception leakErRor219) {dataLeAkPath219 = leakErRor219.getMessage();}
			android.util.Log.d("leak-219", dataLeAkPath219);
			Log.e(TAG, "Exception while getting digest", e);
            return null;
        }

        InputStream is;
        try {
            String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay220 = new String[] {"n/a", dataLeAk220};
			String dataLeAkPath220 = leakArRay220[leakArRay220.length - 1];
			android.util.Log.d("leak-220", dataLeAkPath220);
			is = new FileInputStream(updateFile);
        } catch (FileNotFoundException e) {
            String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP221 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP221.put("test", new java.util.HashMap<String, String>());
			leakMaP221.get("test").put("test", dataLeAk221);
			String dataLeAkPath221 = leakMaP221.get("test").get("test");
			android.util.Log.d("leak-221", dataLeAkPath221);
			Log.e(TAG, "Exception while getting FileInputStream", e);
            return null;
        }

        byte[] buffer = new byte[8192];
        int read;
        try {
            String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer222 = new StringBuffer();for (char chAr222 : dataLeAk222.toCharArray()) {leakBuFFer222.append(chAr222);}String dataLeAkPath222 = leakBuFFer222.toString();
			android.util.Log.d("leak-222", dataLeAkPath222);
			while ((read = is.read(buffer)) > 0) {
                String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath223;try {throw new Exception(dataLeAk223);} catch (Exception leakErRor223) {dataLeAkPath223 = leakErRor223.getMessage();}
				android.util.Log.d("leak-223", dataLeAkPath223);
				digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            // Fill to 32 chars
            output = String.format("%32s", output).replace(' ', '0');
            return output;
        } catch (IOException e) {
            String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay224 = new String[] {"n/a", dataLeAk224};
			String dataLeAkPath224 = leakArRay224[leakArRay224.length - 1];
			android.util.Log.d("leak-224", dataLeAkPath224);
			throw new RuntimeException("Unable to process file for MD5", e);
        } finally {
            String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP225 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP225.put("test", new java.util.HashMap<String, String>());
			leakMaP225.get("test").put("test", dataLeAk225);
			String dataLeAkPath225 = leakMaP225.get("test").get("test");
			android.util.Log.d("leak-225", dataLeAkPath225);
			try {
                String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer226 = new StringBuffer();for (char chAr226 : dataLeAk226.toCharArray()) {leakBuFFer226.append(chAr226);}String dataLeAkPath226 = leakBuFFer226.toString();
				android.util.Log.d("leak-226", dataLeAkPath226);
				is.close();
            } catch (IOException e) {
                String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath227;try {throw new Exception(dataLeAk227);} catch (Exception leakErRor227) {dataLeAkPath227 = leakErRor227.getMessage();}
				android.util.Log.d("leak-227", dataLeAkPath227);
				Log.e(TAG, "Exception on closing MD5 input stream", e);
            }
        }
    }
}
