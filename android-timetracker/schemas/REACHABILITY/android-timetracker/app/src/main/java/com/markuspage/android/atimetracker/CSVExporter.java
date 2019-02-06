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

    String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk281 = android.util.Log.d("leak-281", dataLeAk281);

	private static String escape(String s) {
        String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk282 = android.util.Log.d("leak-282", dataLeAk282);
		if (s == null) {
            String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk283 = android.util.Log.d("leak-283", dataLeAk283);
			return "";
        }
        if (s.contains(",") || s.contains("\"")) {
            String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk284 = android.util.Log.d("leak-284", dataLeAk284);
			s = s.replaceAll("\"", "\"\"");
            s = "\"" + s + "\"";
        }
        return s;
    }

    public static void exportRows(OutputStream o, String[][] rows) {
        String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk285 = android.util.Log.d("leak-285", dataLeAk285);
		PrintStream outputStream = new PrintStream(o);
        for (String[] cols : rows) {
            String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk286 = android.util.Log.d("leak-286", dataLeAk286);
			String prepend = "";
            for (String col : cols) {
                String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk287 = android.util.Log.d("leak-287", dataLeAk287);
				outputStream.print(prepend);
                outputStream.print(escape(col));
                prepend = ",";
            }
            outputStream.println();
        }
    }

    public static void exportRows(OutputStream o, Cursor c) {
        String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk288 = android.util.Log.d("leak-288", dataLeAk288);
		PrintStream outputStream = new PrintStream(o);
        String prepend = "";
        String[] columnNames = c.getColumnNames();
        for (String s : columnNames) {
            String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk289 = android.util.Log.d("leak-289", dataLeAk289);
			outputStream.print(prepend);
            outputStream.print(escape(s));
            prepend = ",";
        }
        if (c.moveToFirst()) {
            String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk290 = android.util.Log.d("leak-290", dataLeAk290);
			Date d = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            do {
                String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk291 = android.util.Log.d("leak-291", dataLeAk291);
				outputStream.println();
                prepend = "";
                for (int i = 0; i < c.getColumnCount(); i++) {
                    String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk292 = android.util.Log.d("leak-292", dataLeAk292);
					outputStream.print(prepend);
                    String outValue;
                    if (columnNames[i].equals("start")) {
                        String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk293 = android.util.Log.d("leak-293", dataLeAk293);
						d.setTime(c.getLong(i));
                        outValue = formatter.format(d);
                    } else if (columnNames[i].equals("end")) {
                        String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk294 = android.util.Log.d("leak-294", dataLeAk294);
						if (c.isNull(i)) {
                            String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk295 = android.util.Log.d("leak-295", dataLeAk295);
							outValue = "";
                        } else {
                            String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk296 = android.util.Log.d("leak-296", dataLeAk296);
							d.setTime(c.getLong(i));
                            outValue = formatter.format(d);
                        }
                    } else {
                        String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk297 = android.util.Log.d("leak-297", dataLeAk297);
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
