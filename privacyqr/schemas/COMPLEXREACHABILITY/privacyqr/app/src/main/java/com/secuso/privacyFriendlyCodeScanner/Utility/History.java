package com.secuso.privacyFriendlyCodeScanner.Utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by Philipp on 14/09/2015.
 */
public class History {

    private static String path = "history.txt";

    public static ArrayList<HistoryEntry> getHistory(Context context) {
        String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
		android.util.Log.d("leak-107", dataLeAkPath107);
		File sdcard = context.getFilesDir();
        File file = new File(sdcard, path);

        ArrayList<HistoryEntry> historyEntries = new ArrayList<HistoryEntry>();

        try {
            String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
			String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
			android.util.Log.d("leak-108", dataLeAkPath108);
			BufferedReader br = new BufferedReader(new FileReader(file));

            int id = 0;

            while (true) {
                String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP109.put("test", new java.util.HashMap<String, String>());
				leakMaP109.get("test").put("test", dataLeAk109);
				String dataLeAkPath109 = leakMaP109.get("test").get("test");
				android.util.Log.d("leak-109", dataLeAkPath109);
				String content = null;
                boolean trust = false;
                String test_for_trust = br.readLine();

                if(test_for_trust == null) {
                    String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
					android.util.Log.d("leak-110", dataLeAkPath110);
					break;
                }

                if(test_for_trust.startsWith("#####TRUST:")) {
                    String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
					android.util.Log.d("leak-111", dataLeAkPath111);
					test_for_trust = test_for_trust.replaceAll("#","");
                    test_for_trust = test_for_trust.replace("TRUST:","");
                    trust = Boolean.parseBoolean(test_for_trust);
                    test_for_trust = br.readLine();

                }

                if(test_for_trust.equals("#####CONTENT#####")) {
                    String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
					String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
					android.util.Log.d("leak-112", dataLeAkPath112);
					content =  "";
                    String temp = br.readLine();
                    while(!temp.equals("#####END#####")) {
                        String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP113.put("test", new java.util.HashMap<String, String>());
						leakMaP113.get("test").put("test", dataLeAk113);
						String dataLeAkPath113 = leakMaP113.get("test").get("test");
						android.util.Log.d("leak-113", dataLeAkPath113);
						if(!content.endsWith(""+'\0'))
                            content = content + temp + '\n';
                        else
                            content = content + temp;
                        temp = br.readLine();
                    }
                }

                if(content != null) {
                    String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
					android.util.Log.d("leak-114", dataLeAkPath114);
					HistoryEntry newHistoryEntry = new HistoryEntry(id, content, trust);
                    historyEntries.add(newHistoryEntry);
                }

                id++;
            }
            br.close();
        }
        catch(Exception e) {
			String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
			android.util.Log.d("leak-115", dataLeAkPath115);

        }

        return historyEntries;
    }

    public static void saveScan(String content, boolean trust, Context context) {

        String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
		String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
		android.util.Log.d("leak-116", dataLeAkPath116);
		ArrayList<HistoryEntry> historyEntries = History.getHistory(context);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        boolean keepDuplicates = sharedPref.getBoolean("bool_keep_duplicates", true);

        if(!keepDuplicates)
            for(HistoryEntry entry: historyEntries) {
                String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP117.put("test", new java.util.HashMap<String, String>());
				leakMaP117.get("test").put("test", dataLeAk117);
				String dataLeAkPath117 = leakMaP117.get("test").get("test");
				android.util.Log.d("leak-117", dataLeAkPath117);
				if(entry.content.contains(content)){
                    String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
					android.util.Log.d("leak-118", dataLeAkPath118);
					historyEntries.remove(entry.id);
                    break;
                }

            }

        for(int i=0; i < historyEntries.size(); i++) {
            String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
			android.util.Log.d("leak-119", dataLeAkPath119);
			historyEntries.get(i).id = i+1;
        }

        HistoryEntry newHistoryEntry = new HistoryEntry(0, content, trust);
        historyEntries.add(0,newHistoryEntry);

        saveHistory(context, historyEntries, false);
    }

    public static void saveHistory(Context context, ArrayList<HistoryEntry> historyEntries, boolean append) {

        String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
		String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
		android.util.Log.d("leak-120", dataLeAkPath120);
		File sdcard = context.getFilesDir();
        File file = new File(sdcard, path);

        try {
            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP121.put("test", new java.util.HashMap<String, String>());
			leakMaP121.get("test").put("test", dataLeAk121);
			String dataLeAkPath121 = leakMaP121.get("test").get("test");
			android.util.Log.d("leak-121", dataLeAkPath121);
			if(!file.canWrite()) {
                String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
				android.util.Log.d("leak-122", dataLeAkPath122);
				file.createNewFile();
            }

            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file, append)));

            for(HistoryEntry entry: historyEntries) {

                String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
				android.util.Log.d("leak-123", dataLeAkPath123);
				if(entry.trust==true || entry.trust==false) {
                    String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
					String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
					android.util.Log.d("leak-124", dataLeAkPath124);
					out.append("#####TRUST:"+entry.trust+ "#####" + '\n');
                }
                out.append("#####CONTENT#####" + '\n' + entry.content + '\n');
                out.append("#####END#####" + '\n');
            }
            out.close();

        } catch (IOException e) {
			String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP125.put("test", new java.util.HashMap<String, String>());
			leakMaP125.get("test").put("test", dataLeAk125);
			String dataLeAkPath125 = leakMaP125.get("test").get("test");
			android.util.Log.d("leak-125", dataLeAkPath125);

        }
    }

    public static void printHistory(Context context) {
        String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
		android.util.Log.d("leak-126", dataLeAkPath126);
		File sdcard = context.getFilesDir();
        File file = new File(sdcard, path);

        if(!file.exists()) return;

        try {
            String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
			android.util.Log.d("leak-127", dataLeAkPath127);
			BufferedReader br = new BufferedReader(new FileReader(file));
            Log.e("TEST", "File found: " + Boolean.toString(br.ready()));
            int id = 0;

            while (true) {
                String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
				String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
				android.util.Log.d("leak-128", dataLeAkPath128);
				String start = br.readLine();
                if(start == null) {
                    String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP129.put("test", new java.util.HashMap<String, String>());
					leakMaP129.get("test").put("test", dataLeAk129);
					String dataLeAkPath129 = leakMaP129.get("test").get("test");
					android.util.Log.d("leak-129", dataLeAkPath129);
					Log.e("TEST", "File end - lines (" + id + ")");
                    break;
                }
                Log.e("TEST", start);

                id++;
            }
            br.close();
        }
        catch(Exception e) {
            String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
			android.util.Log.d("leak-130", dataLeAkPath130);
			Log.e("ERROR", e.toString());
        }
    }
}
