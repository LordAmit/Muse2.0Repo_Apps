package com.iamtrk.androidExplorer;

/**
 * Created by m01231 on 20/08/16.
 */
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Manager class to read the processor usage from the cpufreq file and return the processor frequency
 */
public class FrequencyManager {

    /**
     * The frequency statistics file from which the figures should be read repeatedly
     */
    private RandomAccessFile rafFrequency;

    public FrequencyManager() {
        String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay180 = new String[] {"n/a", dataLeAk180};
		String dataLeAkPath180 = leakArRay180[leakArRay180.length - 1];
		android.util.Log.d("leak-180", dataLeAkPath180);
		try {
            String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP181.put("test", new java.util.HashMap<String, String>());
			leakMaP181.get("test").put("test", dataLeAk181);
			String dataLeAkPath181 = leakMaP181.get("test").get("test");
			android.util.Log.d("leak-181", dataLeAkPath181);
			rafFrequency = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "r");
        } catch (FileNotFoundException e) {
            String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer182 = new StringBuffer();for (char chAr182 : dataLeAk182.toCharArray()) {leakBuFFer182.append(chAr182);}String dataLeAkPath182 = leakBuFFer182.toString();
			android.util.Log.d("leak-182", dataLeAkPath182);
			throw new RuntimeException(e);
        }
    }

    /**
     * Returns the current CPU frequency in a human readable format by converting it into a Hz
     *
     * @return The current CPU frequency
     */
    public String getFrequency() {
        String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath183;try {throw new Exception(dataLeAk183);} catch (Exception leakErRor183) {dataLeAkPath183 = leakErRor183.getMessage();}
		android.util.Log.d("leak-183", dataLeAkPath183);
		try {
            String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay184 = new String[] {"n/a", dataLeAk184};
			String dataLeAkPath184 = leakArRay184[leakArRay184.length - 1];
			android.util.Log.d("leak-184", dataLeAkPath184);
			rafFrequency.seek(0);
            int hz = Integer.valueOf(rafFrequency.readLine());
            if (hz < 1000 * 1000) {
                String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP185.put("test", new java.util.HashMap<String, String>());
				leakMaP185.get("test").put("test", dataLeAk185);
				String dataLeAkPath185 = leakMaP185.get("test").get("test");
				android.util.Log.d("leak-185", dataLeAkPath185);
				return (hz / 1000) + " MHz";
            }

            final int a = (hz / 1000 / 1000);
            final int b = (hz / 1000 / 100) % 10;
            return a + "." + b + " GHz";
        } catch (IOException e) {
            String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer186 = new StringBuffer();for (char chAr186 : dataLeAk186.toCharArray()) {leakBuFFer186.append(chAr186);}String dataLeAkPath186 = leakBuFFer186.toString();
			android.util.Log.d("leak-186", dataLeAkPath186);
			Log.w("FrequencyManager", "Error reading the CPU frequency", e);
            return "";
        }
    }

    /**
     * Closes the processor statistics file from which the figures are be read repeatedly
     */
    public void destroy() {

        String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath187;try {throw new Exception(dataLeAk187);} catch (Exception leakErRor187) {dataLeAkPath187 = leakErRor187.getMessage();}
		android.util.Log.d("leak-187", dataLeAkPath187);
		if (rafFrequency != null) {
            String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay188 = new String[] {"n/a", dataLeAk188};
			String dataLeAkPath188 = leakArRay188[leakArRay188.length - 1];
			android.util.Log.d("leak-188", dataLeAkPath188);
			try {
                String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP189.put("test", new java.util.HashMap<String, String>());
				leakMaP189.get("test").put("test", dataLeAk189);
				String dataLeAkPath189 = leakMaP189.get("test").get("test");
				android.util.Log.d("leak-189", dataLeAkPath189);
				rafFrequency.close();
            } catch (IOException e) {
                String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer190 = new StringBuffer();for (char chAr190 : dataLeAk190.toCharArray()) {leakBuFFer190.append(chAr190);}String dataLeAkPath190 = leakBuFFer190.toString();
				android.util.Log.d("leak-190", dataLeAkPath190);
				Log.w("FrequencyManager", "Unable to successfully close the file");
            }
        }
    }
}

