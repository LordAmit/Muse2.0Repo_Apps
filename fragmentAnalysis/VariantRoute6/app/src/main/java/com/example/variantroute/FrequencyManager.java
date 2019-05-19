package com.example.variantroute;

/**
 * Created by m01231 on 20/08/16.
 */
import android.util.Log;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.RandomAccessFile;

/**
 * Manager class to read the processor usage from the cpufreq file and return the processor frequency
 */
public class FrequencyManager {

    String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
    Object throwawayLeAk210 = android.util.Log.d("leak-210", dataLeAk210);

    /**
     * The frequency statistics file from which the figures should be read repeatedly
     */
//    private RandomAccessFile rafFrequency;

    public FrequencyManager() {
        String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        Object throwawayLeAk211 = android.util.Log.d("leak-211", dataLeAk211);
//        try {
//            String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//            Object throwawayLeAk212 = android.util.Log.d("leak-212", dataLeAk212);
//            rafFrequency = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "r");
//        } catch (FileNotFoundException e) {
//            String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//            Object throwawayLeAk213 = android.util.Log.d("leak-213", dataLeAk213);
//            throw new RuntimeException(e);
//        }
    }

    /**
     * Returns the current CPU frequency in a human readable format by converting it into a Hz
     *
     * @return The current CPU frequency
     */
    public String getFrequency() {
        String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        Object throwawayLeAk214 = android.util.Log.d("leak-214", dataLeAk214);
        return "something";
//        try {
//            String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//            Object throwawayLeAk215 = android.util.Log.d("leak-215", dataLeAk215);
//            rafFrequency.seek(0);
//            int hz = Integer.valueOf(rafFrequency.readLine());
//            if (hz < 1000 * 1000) {
//                String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//                Object throwawayLeAk216 = android.util.Log.d("leak-216", dataLeAk216);
//                return (hz / 1000) + " MHz";
//            }
//
//            final int a = (hz / 1000 / 1000);
//            final int b = (hz / 1000 / 100) % 10;
//            return a + "." + b + " GHz";
//        } catch (IOException e) {
//            String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//            Object throwawayLeAk217 = android.util.Log.d("leak-217", dataLeAk217);
//            Log.w("FrequencyManager", "Error reading the CPU frequency", e);
//            return "";
//        }
    }

}

