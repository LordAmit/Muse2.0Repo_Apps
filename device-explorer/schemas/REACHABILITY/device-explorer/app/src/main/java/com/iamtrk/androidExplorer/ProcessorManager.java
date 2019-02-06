package com.iamtrk.androidExplorer;

import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Manager class to read the processor usage from the /proc/stat file and return the processor usage
 */
public class ProcessorManager {

    String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);

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
        String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);
		try {
            String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);
			rafProcessor = new RandomAccessFile("/proc/stat", "r");
        } catch (FileNotFoundException e) {
            String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
			throw new RuntimeException(e);
        }
    }

    /**
     * Handler method that updates the notification icon with the current processor usage. It does
     * this by reading the /proc/stat file and specifically the of the first CPU row as are only
     * concerned with the cumulative processor utilization.
     */
    public double getUsage() {
        String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);
		try {
            String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);
			rafProcessor.seek(0);
            String strLine = rafProcessor.readLine();
            Log.v("HardwareService", strLine);
            String[] lstColumns = strLine.split(" ");

            long lngCurrentIdle = Long.parseLong(lstColumns[5]);
            long lngCurrentTotal = 0L;

            lstColumns[0] = lstColumns[1] = "0";

            for (String strStatistic : lstColumns) {
                String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);
				lngCurrentTotal = lngCurrentTotal + Integer.parseInt(strStatistic);
            }
            long lngDifferenceIdle = lngCurrentIdle - lngPreviousIdle;
            long lngDifferenceTotal = lngCurrentTotal - lngPreviousTotal;

            lngPreviousIdle = lngCurrentIdle;
            lngPreviousTotal = lngCurrentTotal;

            long lngUsageDelta = lngDifferenceTotal - lngDifferenceIdle;

            Double dblPercent = 100.0 * (lngUsageDelta / (lngDifferenceTotal + 0.01));
            if (dblPercent < 0D) {
                String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);
				Log.w("ProcessorManager", "Encountered a negative value of " + dblPercent);
                dblPercent = 0D;
            } else if (dblPercent > 100D) {
                String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);
				Log.w("ProcessorManager", "Encountered a insane value of " + dblPercent);
                dblPercent = 100D;
            }
            Log.d("HardwareService", "Current processor usage is " + dblPercent);
            return dblPercent;

        } catch (Exception e) {
            String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);
			Log.e("HardwareService", "Error processing line", e);
        }

        return 0D;
    }

    /**
     * Closes the processor statistics file from which the figures are be read repeatedly
     */
    public void destroy() {

        String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);
		if (rafProcessor != null) {
            String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);
			try {
                String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);
				rafProcessor.close();
            } catch (IOException e) {
                String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);
				Log.w("HardwareService", "Unable to successfully close the file");
            }
        }
    }
}

