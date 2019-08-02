package com.iamtrk.androidExplorer;

import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Manager class to read the processor usage from the /proc/stat file and return the processor usage
 */
public class ProcessorManager {

    /**
     * The processor statistics file from which the figures should be read repeatedly
     */
    private RandomAccessFile rafProcessor;
    /**
     * The value of the total processor utilization since the last update
     */
    private long lngPreviousTotal = 0L;
    /**
     * The value of the idle processor utilization since the last update
     */
    private long lngPreviousIdle = 0L;

    public ProcessorManager() {
        String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP161.put("test", new java.util.HashMap<String, String>());
		leakMaP161.get("test").put("test", dataLeAk161);
		String dataLeAkPath161 = leakMaP161.get("test").get("test");
		android.util.Log.d("leak-161", dataLeAkPath161);
		try {
            String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
			android.util.Log.d("leak-162", dataLeAkPath162);
			rafProcessor = new RandomAccessFile("/proc/stat", "r");
        } catch (FileNotFoundException e) {
            String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
			android.util.Log.d("leak-163", dataLeAkPath163);
			throw new RuntimeException(e);
        }
    }

    /**
     * Handler method that updates the notification icon with the current processor usage. It does
     * this by reading the /proc/stat file and specifically the of the first CPU row as are only
     * concerned with the cumulative processor utilization.
     */
    public double getUsage() {
        String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
		String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
		android.util.Log.d("leak-164", dataLeAkPath164);
		try {
            String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP165.put("test", new java.util.HashMap<String, String>());
			leakMaP165.get("test").put("test", dataLeAk165);
			String dataLeAkPath165 = leakMaP165.get("test").get("test");
			android.util.Log.d("leak-165", dataLeAkPath165);
			rafProcessor.seek(0);
            String strLine = rafProcessor.readLine();
            Log.v("HardwareService", strLine);
            String[] lstColumns = strLine.split(" ");

            long lngCurrentIdle = Long.parseLong(lstColumns[5]);
            long lngCurrentTotal = 0L;

            lstColumns[0] = lstColumns[1] = "0";

            for (String strStatistic : lstColumns) {
                String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
				android.util.Log.d("leak-166", dataLeAkPath166);
				lngCurrentTotal = lngCurrentTotal + Integer.parseInt(strStatistic);
            }
            long lngDifferenceIdle = lngCurrentIdle - lngPreviousIdle;
            long lngDifferenceTotal = lngCurrentTotal - lngPreviousTotal;

            lngPreviousIdle = lngCurrentIdle;
            lngPreviousTotal = lngCurrentTotal;

            long lngUsageDelta = lngDifferenceTotal - lngDifferenceIdle;

            Double dblPercent = 100.0 * (lngUsageDelta / (lngDifferenceTotal + 0.01));
            if (dblPercent < 0D) {
                String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
				android.util.Log.d("leak-167", dataLeAkPath167);
				Log.w("ProcessorManager", "Encountered a negative value of " + dblPercent);
                dblPercent = 0D;
            } else if (dblPercent > 100D) {
                String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
				String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
				android.util.Log.d("leak-168", dataLeAkPath168);
				Log.w("ProcessorManager", "Encountered a insane value of " + dblPercent);
                dblPercent = 100D;
            }
            Log.d("HardwareService", "Current processor usage is " + dblPercent);
            return dblPercent;

        } catch (Exception e) {
            String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP169.put("test", new java.util.HashMap<String, String>());
			leakMaP169.get("test").put("test", dataLeAk169);
			String dataLeAkPath169 = leakMaP169.get("test").get("test");
			android.util.Log.d("leak-169", dataLeAkPath169);
			Log.e("HardwareService", "Error processing line", e);
        }

        return 0D;
    }

    /**
     * Closes the processor statistics file from which the figures are be read repeatedly
     */
    public void destroy() {

        String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer170 = new StringBuffer();for (char chAr170 : dataLeAk170.toCharArray()) {leakBuFFer170.append(chAr170);}String dataLeAkPath170 = leakBuFFer170.toString();
		android.util.Log.d("leak-170", dataLeAkPath170);
		if (rafProcessor != null) {
            String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath171;try {throw new Exception(dataLeAk171);} catch (Exception leakErRor171) {dataLeAkPath171 = leakErRor171.getMessage();}
			android.util.Log.d("leak-171", dataLeAkPath171);
			try {
                String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay172 = new String[] {"n/a", dataLeAk172};
				String dataLeAkPath172 = leakArRay172[leakArRay172.length - 1];
				android.util.Log.d("leak-172", dataLeAkPath172);
				rafProcessor.close();
            } catch (IOException e) {
                String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP173.put("test", new java.util.HashMap<String, String>());
				leakMaP173.get("test").put("test", dataLeAk173);
				String dataLeAkPath173 = leakMaP173.get("test").get("test");
				android.util.Log.d("leak-173", dataLeAkPath173);
				Log.w("HardwareService", "Unable to successfully close the file");
            }
        }
    }
}

