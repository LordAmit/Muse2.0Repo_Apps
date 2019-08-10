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

    String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);

	private static String path = "history.txt";

    public static ArrayList<HistoryEntry> getHistory(Context context) {
        String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
		File sdcard = context.getFilesDir();
        File file = new File(sdcard, path);

        ArrayList<HistoryEntry> historyEntries = new ArrayList<HistoryEntry>();

        try {
            String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);
			BufferedReader br = new BufferedReader(new FileReader(file));

            int id = 0;

            while (true) {
                String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
				String content = null;
                boolean trust = false;
                String test_for_trust = br.readLine();

                if(test_for_trust == null) {
                    String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);
					break;
                }

                if(test_for_trust.startsWith("#####TRUST:")) {
                    String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
					test_for_trust = test_for_trust.replaceAll("#","");
                    test_for_trust = test_for_trust.replace("TRUST:","");
                    trust = Boolean.parseBoolean(test_for_trust);
                    test_for_trust = br.readLine();

                }

                if(test_for_trust.equals("#####CONTENT#####")) {
                    String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);
					content =  "";
                    String temp = br.readLine();
                    while(!temp.equals("#####END#####")) {
                        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
						if(!content.endsWith(""+'\0'))
                            content = content + temp + '\n';
                        else
                            content = content + temp;
                        temp = br.readLine();
                    }
                }

                if(content != null) {
                    String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);
					HistoryEntry newHistoryEntry = new HistoryEntry(id, content, trust);
                    historyEntries.add(newHistoryEntry);
                }

                id++;
            }
            br.close();
        }
        catch(Exception e) {
			String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);

        }

        return historyEntries;
    }

    public static void saveScan(String content, boolean trust, Context context) {

        String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);
		ArrayList<HistoryEntry> historyEntries = History.getHistory(context);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        boolean keepDuplicates = sharedPref.getBoolean("bool_keep_duplicates", true);

        if(!keepDuplicates)
            for(HistoryEntry entry: historyEntries) {
                String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
				if(entry.content.contains(content)){
                    String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);
					historyEntries.remove(entry.id);
                    break;
                }

            }

        for(int i=0; i < historyEntries.size(); i++) {
            String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
			historyEntries.get(i).id = i+1;
        }

        HistoryEntry newHistoryEntry = new HistoryEntry(0, content, trust);
        historyEntries.add(0,newHistoryEntry);

        saveHistory(context, historyEntries, false);
    }

    public static void saveHistory(Context context, ArrayList<HistoryEntry> historyEntries, boolean append) {

        String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
		File sdcard = context.getFilesDir();
        File file = new File(sdcard, path);

        try {
            String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
			if(!file.canWrite()) {
                String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
				file.createNewFile();
            }

            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file, append)));

            for(HistoryEntry entry: historyEntries) {

                String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
				if(entry.trust==true || entry.trust==false) {
                    String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);
					out.append("#####TRUST:"+entry.trust+ "#####" + '\n');
                }
                out.append("#####CONTENT#####" + '\n' + entry.content + '\n');
                out.append("#####END#####" + '\n');
            }
            out.close();

        } catch (IOException e) {
			String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);

        }
    }

    public static void printHistory(Context context) {
        String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);
		File sdcard = context.getFilesDir();
        File file = new File(sdcard, path);

        if(!file.exists()) return;

        try {
            String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
			BufferedReader br = new BufferedReader(new FileReader(file));
            Log.e("TEST", "File found: " + Boolean.toString(br.ready()));
            int id = 0;

            while (true) {
                String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);
				String start = br.readLine();
                if(start == null) {
                    String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
					Log.e("TEST", "File end - lines (" + id + ")");
                    break;
                }
                Log.e("TEST", start);

                id++;
            }
            br.close();
        }
        catch(Exception e) {
            String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
			Log.e("ERROR", e.toString());
        }
    }
}
