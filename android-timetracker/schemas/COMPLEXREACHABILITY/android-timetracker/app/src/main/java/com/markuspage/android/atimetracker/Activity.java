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

import static com.markuspage.android.atimetracker.TimeRange.NULL;

/**
 * Activity activity.
 *
 * @author Sean Russell, ser@germane-software.com
 */
public class Activity implements Comparable<Activity> {

    private String name;
    private final int id;
    private long startTime = NULL;
    private long endTime = NULL;
    private long collapsed;

    /**
     * Constructs a new instance of Activity.
     *
     * @param name The title of the activity. Must not be null.
     * @param id The ID of the activity. Must not be null
     */
    public Activity(String name, int id) {
        String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP277 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP277.put("test", new java.util.HashMap<String, String>());
		leakMaP277.get("test").put("test", dataLeAk277);
		String dataLeAkPath277 = leakMaP277.get("test").get("test");
		android.util.Log.d("leak-277", dataLeAkPath277);
		this.name = name;
        this.id = id;
        collapsed = 0;
    }

    public int getId() {
        String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer278 = new StringBuffer();for (char chAr278 : dataLeAk278.toCharArray()) {leakBuFFer278.append(chAr278);}String dataLeAkPath278 = leakBuFFer278.toString();
		android.util.Log.d("leak-278", dataLeAkPath278);
		return id;
    }

    public String getName() {
        String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath279;try {throw new Exception(dataLeAk279);} catch (Exception leakErRor279) {dataLeAkPath279 = leakErRor279.getMessage();}
		android.util.Log.d("leak-279", dataLeAkPath279);
		return name;
    }

    public void setName(String name) {
        String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay280 = new String[] {"n/a", dataLeAk280};
		String dataLeAkPath280 = leakArRay280[leakArRay280.length - 1];
		android.util.Log.d("leak-280", dataLeAkPath280);
		this.name = name;
    }

    public long getTotal() {
        String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP281 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP281.put("test", new java.util.HashMap<String, String>());
		leakMaP281.get("test").put("test", dataLeAk281);
		String dataLeAkPath281 = leakMaP281.get("test").get("test");
		android.util.Log.d("leak-281", dataLeAkPath281);
		long sum = 0;
        if (startTime != NULL && endTime == NULL) {
            String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer282 = new StringBuffer();for (char chAr282 : dataLeAk282.toCharArray()) {leakBuFFer282.append(chAr282);}String dataLeAkPath282 = leakBuFFer282.toString();
			android.util.Log.d("leak-282", dataLeAkPath282);
			sum += System.currentTimeMillis() - startTime;
        }
        return sum + collapsed;
    }

    public void setCollapsed(long collapsed) {
        String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath283;try {throw new Exception(dataLeAk283);} catch (Exception leakErRor283) {dataLeAkPath283 = leakErRor283.getMessage();}
		android.util.Log.d("leak-283", dataLeAkPath283);
		this.collapsed = collapsed;
    }

    public long getCollapsed() {
        String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay284 = new String[] {"n/a", dataLeAk284};
		String dataLeAkPath284 = leakArRay284[leakArRay284.length - 1];
		android.util.Log.d("leak-284", dataLeAkPath284);
		return collapsed;
    }

    public void start() {
        String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP285 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP285.put("test", new java.util.HashMap<String, String>());
		leakMaP285.get("test").put("test", dataLeAk285);
		String dataLeAkPath285 = leakMaP285.get("test").get("test");
		android.util.Log.d("leak-285", dataLeAkPath285);
		if (endTime != NULL || startTime == NULL) {
            String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer286 = new StringBuffer();for (char chAr286 : dataLeAk286.toCharArray()) {leakBuFFer286.append(chAr286);}String dataLeAkPath286 = leakBuFFer286.toString();
			android.util.Log.d("leak-286", dataLeAkPath286);
			startTime = System.currentTimeMillis();
            endTime = NULL;
        }
    }

    public void stop() {
        String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath287;try {throw new Exception(dataLeAk287);} catch (Exception leakErRor287) {dataLeAkPath287 = leakErRor287.getMessage();}
		android.util.Log.d("leak-287", dataLeAkPath287);
		if (endTime == NULL) {
            String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay288 = new String[] {"n/a", dataLeAk288};
			String dataLeAkPath288 = leakArRay288[leakArRay288.length - 1];
			android.util.Log.d("leak-288", dataLeAkPath288);
			endTime = System.currentTimeMillis();
            collapsed += endTime - startTime;
        }
    }

    public long getStartTime() {
        String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP289 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP289.put("test", new java.util.HashMap<String, String>());
		leakMaP289.get("test").put("test", dataLeAk289);
		String dataLeAkPath289 = leakMaP289.get("test").get("test");
		android.util.Log.d("leak-289", dataLeAkPath289);
		return startTime;
    }

    public void setStartTime(long startTime) {
        String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer290 = new StringBuffer();for (char chAr290 : dataLeAk290.toCharArray()) {leakBuFFer290.append(chAr290);}String dataLeAkPath290 = leakBuFFer290.toString();
		android.util.Log.d("leak-290", dataLeAkPath290);
		this.startTime = startTime;
    }

    public long getEndTime() {
        String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath291;try {throw new Exception(dataLeAk291);} catch (Exception leakErRor291) {dataLeAkPath291 = leakErRor291.getMessage();}
		android.util.Log.d("leak-291", dataLeAkPath291);
		return endTime;
    }

    public void setEndTime(long endTime) {
        String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay292 = new String[] {"n/a", dataLeAk292};
		String dataLeAkPath292 = leakArRay292[leakArRay292.length - 1];
		android.util.Log.d("leak-292", dataLeAkPath292);
		this.endTime = endTime;
    }

    @Override
    public int hashCode() {
        String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP293 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP293.put("test", new java.util.HashMap<String, String>());
		leakMaP293.get("test").put("test", dataLeAk293);
		String dataLeAkPath293 = leakMaP293.get("test").get("test");
		android.util.Log.d("leak-293", dataLeAkPath293);
		int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer294 = new StringBuffer();for (char chAr294 : dataLeAk294.toCharArray()) {leakBuFFer294.append(chAr294);}String dataLeAkPath294 = leakBuFFer294.toString();
		android.util.Log.d("leak-294", dataLeAkPath294);
		if (this == obj) {
            String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath295;try {throw new Exception(dataLeAk295);} catch (Exception leakErRor295) {dataLeAkPath295 = leakErRor295.getMessage();}
			android.util.Log.d("leak-295", dataLeAkPath295);
			return true;
        }
        if (obj == null) {
            String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay296 = new String[] {"n/a", dataLeAk296};
			String dataLeAkPath296 = leakArRay296[leakArRay296.length - 1];
			android.util.Log.d("leak-296", dataLeAkPath296);
			return false;
        }
        if (getClass() != obj.getClass()) {
            String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP297 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP297.put("test", new java.util.HashMap<String, String>());
			leakMaP297.get("test").put("test", dataLeAk297);
			String dataLeAkPath297 = leakMaP297.get("test").get("test");
			android.util.Log.d("leak-297", dataLeAkPath297);
			return false;
        }
        final Activity other = (Activity) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Activity another) {
        String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer298 = new StringBuffer();for (char chAr298 : dataLeAk298.toCharArray()) {leakBuFFer298.append(chAr298);}String dataLeAkPath298 = leakBuFFer298.toString();
		android.util.Log.d("leak-298", dataLeAkPath298);
		return name.toUpperCase().compareTo(another.getName().toUpperCase());
    }

    public boolean isRunning() {
        String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath299;try {throw new Exception(dataLeAk299);} catch (Exception leakErRor299) {dataLeAkPath299 = leakErRor299.getMessage();}
		android.util.Log.d("leak-299", dataLeAkPath299);
		return startTime != NULL && endTime == NULL;
    }
}
