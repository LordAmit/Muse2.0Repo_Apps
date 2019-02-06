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

    String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk298 = android.util.Log.d("leak-298", dataLeAk298);

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
        String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk299 = android.util.Log.d("leak-299", dataLeAk299);
		this.name = name;
        this.id = id;
        collapsed = 0;
    }

    public int getId() {
        String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk300 = android.util.Log.d("leak-300", dataLeAk300);
		return id;
    }

    public String getName() {
        String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk301 = android.util.Log.d("leak-301", dataLeAk301);
		return name;
    }

    public void setName(String name) {
        String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk302 = android.util.Log.d("leak-302", dataLeAk302);
		this.name = name;
    }

    public long getTotal() {
        String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk303 = android.util.Log.d("leak-303", dataLeAk303);
		long sum = 0;
        if (startTime != NULL && endTime == NULL) {
            String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk304 = android.util.Log.d("leak-304", dataLeAk304);
			sum += System.currentTimeMillis() - startTime;
        }
        return sum + collapsed;
    }

    public void setCollapsed(long collapsed) {
        String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk305 = android.util.Log.d("leak-305", dataLeAk305);
		this.collapsed = collapsed;
    }

    public long getCollapsed() {
        String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk306 = android.util.Log.d("leak-306", dataLeAk306);
		return collapsed;
    }

    public void start() {
        String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk307 = android.util.Log.d("leak-307", dataLeAk307);
		if (endTime != NULL || startTime == NULL) {
            String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk308 = android.util.Log.d("leak-308", dataLeAk308);
			startTime = System.currentTimeMillis();
            endTime = NULL;
        }
    }

    public void stop() {
        String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk309 = android.util.Log.d("leak-309", dataLeAk309);
		if (endTime == NULL) {
            String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk310 = android.util.Log.d("leak-310", dataLeAk310);
			endTime = System.currentTimeMillis();
            collapsed += endTime - startTime;
        }
    }

    public long getStartTime() {
        String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk311 = android.util.Log.d("leak-311", dataLeAk311);
		return startTime;
    }

    public void setStartTime(long startTime) {
        String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk312 = android.util.Log.d("leak-312", dataLeAk312);
		this.startTime = startTime;
    }

    public long getEndTime() {
        String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk313 = android.util.Log.d("leak-313", dataLeAk313);
		return endTime;
    }

    public void setEndTime(long endTime) {
        String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk314 = android.util.Log.d("leak-314", dataLeAk314);
		this.endTime = endTime;
    }

    @Override
    public int hashCode() {
        String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk315 = android.util.Log.d("leak-315", dataLeAk315);
		int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk316 = android.util.Log.d("leak-316", dataLeAk316);
		if (this == obj) {
            String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk317 = android.util.Log.d("leak-317", dataLeAk317);
			return true;
        }
        if (obj == null) {
            String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk318 = android.util.Log.d("leak-318", dataLeAk318);
			return false;
        }
        if (getClass() != obj.getClass()) {
            String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk319 = android.util.Log.d("leak-319", dataLeAk319);
			return false;
        }
        final Activity other = (Activity) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Activity another) {
        String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk320 = android.util.Log.d("leak-320", dataLeAk320);
		return name.toUpperCase().compareTo(another.getName().toUpperCase());
    }

    public boolean isRunning() {
        String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk321 = android.util.Log.d("leak-321", dataLeAk321);
		return startTime != NULL && endTime == NULL;
    }
}
