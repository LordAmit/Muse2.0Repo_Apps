/*
 * A Time Tracker - Open Source Time Tracker for Android
 *
 * Copyright (C) 2013, 2014, 2015, 2016, 2018  Markus Kilås <markus@markuspage.com>
 * Copyright (C) 2008, 2009, 2010  Sean Russell <ser@germane-software.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.markuspage.android.atimetracker;

import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.database.Cursor;

/**
 * Helper class for formatting the CSV export.
 *
 * @author Sean Russell, ser@germane-software.com
 */
public class CSVExporter {

    private static String escape(String s) {
        String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP261 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP261.put("test", new java.util.HashMap<String, String>());
		leakMaP261.get("test").put("test", dataLeAk261);
		String dataLeAkPath261 = leakMaP261.get("test").get("test");
		android.util.Log.d("leak-261", dataLeAkPath261);
		if (s == null) {
            String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer262 = new StringBuffer();for (char chAr262 : dataLeAk262.toCharArray()) {leakBuFFer262.append(chAr262);}String dataLeAkPath262 = leakBuFFer262.toString();
			android.util.Log.d("leak-262", dataLeAkPath262);
			return "";
        }
        if (s.contains(",") || s.contains("\"")) {
            String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath263;try {throw new Exception(dataLeAk263);} catch (Exception leakErRor263) {dataLeAkPath263 = leakErRor263.getMessage();}
			android.util.Log.d("leak-263", dataLeAkPath263);
			s = s.replaceAll("\"", "\"\"");
            s = "\"" + s + "\"";
        }
        return s;
    }

    public static void exportRows(OutputStream o, String[][] rows) {
        String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay264 = new String[] {"n/a", dataLeAk264};
		String dataLeAkPath264 = leakArRay264[leakArRay264.length - 1];
		android.util.Log.d("leak-264", dataLeAkPath264);
		PrintStream outputStream = new PrintStream(o);
        for (String[] cols : rows) {
            String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP265 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP265.put("test", new java.util.HashMap<String, String>());
			leakMaP265.get("test").put("test", dataLeAk265);
			String dataLeAkPath265 = leakMaP265.get("test").get("test");
			android.util.Log.d("leak-265", dataLeAkPath265);
			String prepend = "";
            for (String col : cols) {
                String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer266 = new StringBuffer();for (char chAr266 : dataLeAk266.toCharArray()) {leakBuFFer266.append(chAr266);}String dataLeAkPath266 = leakBuFFer266.toString();
				android.util.Log.d("leak-266", dataLeAkPath266);
				outputStream.print(prepend);
                outputStream.print(escape(col));
                prepend = ",";
            }
            outputStream.println();
        }
    }

    public static void exportRows(OutputStream o, Cursor c) {
        String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath267;try {throw new Exception(dataLeAk267);} catch (Exception leakErRor267) {dataLeAkPath267 = leakErRor267.getMessage();}
		android.util.Log.d("leak-267", dataLeAkPath267);
		PrintStream outputStream = new PrintStream(o);
        String prepend = "";
        String[] columnNames = c.getColumnNames();
        for (String s : columnNames) {
            String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay268 = new String[] {"n/a", dataLeAk268};
			String dataLeAkPath268 = leakArRay268[leakArRay268.length - 1];
			android.util.Log.d("leak-268", dataLeAkPath268);
			outputStream.print(prepend);
            outputStream.print(escape(s));
            prepend = ",";
        }
        if (c.moveToFirst()) {
            String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP269 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP269.put("test", new java.util.HashMap<String, String>());
			leakMaP269.get("test").put("test", dataLeAk269);
			String dataLeAkPath269 = leakMaP269.get("test").get("test");
			android.util.Log.d("leak-269", dataLeAkPath269);
			Date d = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            do {
                String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer270 = new StringBuffer();for (char chAr270 : dataLeAk270.toCharArray()) {leakBuFFer270.append(chAr270);}String dataLeAkPath270 = leakBuFFer270.toString();
				android.util.Log.d("leak-270", dataLeAkPath270);
				outputStream.println();
                prepend = "";
                for (int i = 0; i < c.getColumnCount(); i++) {
                    String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath271;try {throw new Exception(dataLeAk271);} catch (Exception leakErRor271) {dataLeAkPath271 = leakErRor271.getMessage();}
					android.util.Log.d("leak-271", dataLeAkPath271);
					outputStream.print(prepend);
                    String outValue;
                    if (columnNames[i].equals("start")) {
                        String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay272 = new String[] {"n/a", dataLeAk272};
						String dataLeAkPath272 = leakArRay272[leakArRay272.length - 1];
						android.util.Log.d("leak-272", dataLeAkPath272);
						d.setTime(c.getLong(i));
                        outValue = formatter.format(d);
                    } else if (columnNames[i].equals("end")) {
                        String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP273 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP273.put("test", new java.util.HashMap<String, String>());
						leakMaP273.get("test").put("test", dataLeAk273);
						String dataLeAkPath273 = leakMaP273.get("test").get("test");
						android.util.Log.d("leak-273", dataLeAkPath273);
						if (c.isNull(i)) {
                            String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer274 = new StringBuffer();for (char chAr274 : dataLeAk274.toCharArray()) {leakBuFFer274.append(chAr274);}String dataLeAkPath274 = leakBuFFer274.toString();
							android.util.Log.d("leak-274", dataLeAkPath274);
							outValue = "";
                        } else {
                            String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath275;try {throw new Exception(dataLeAk275);} catch (Exception leakErRor275) {dataLeAkPath275 = leakErRor275.getMessage();}
							android.util.Log.d("leak-275", dataLeAkPath275);
							d.setTime(c.getLong(i));
                            outValue = formatter.format(d);
                        }
                    } else {
                        String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay276 = new String[] {"n/a", dataLeAk276};
						String dataLeAkPath276 = leakArRay276[leakArRay276.length - 1];
						android.util.Log.d("leak-276", dataLeAkPath276);
						outValue = escape(c.getString(i));
                    }
                    outputStream.print(outValue);
                    prepend = ",";
                }
            } while (c.moveToNext());
        }
        outputStream.println();
    }
}
