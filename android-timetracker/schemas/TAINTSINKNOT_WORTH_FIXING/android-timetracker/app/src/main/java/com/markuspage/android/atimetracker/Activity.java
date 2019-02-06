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

    String dataLeAk85 = "85";

	String dataLeAk84 = "84";

	String dataLeAk83 = "83";

	String dataLeAk82 = "82";

	String dataLeAk81 = "81";

	String dataLeAk80 = "80";

	String dataLeAk79 = "79";

	String dataLeAk78 = "78";

	String dataLeAk77 = "77";

	String dataLeAk76 = "76";

	String dataLeAk75 = "75";

	String dataLeAk74 = "74";

	String dataLeAk73 = "73";

	String dataLeAk72 = "72";

	String dataLeAk71 = "71";

	String dataLeAk70 = "70";

	String dataLeAk69 = "69";

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
        dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-82", dataLeAk69);
		android.util.Log.d("leak-70-82", dataLeAk70);
		android.util.Log.d("leak-71-82", dataLeAk71);
		android.util.Log.d("leak-72-82", dataLeAk72);
		android.util.Log.d("leak-73-82", dataLeAk73);
		android.util.Log.d("leak-74-82", dataLeAk74);
		android.util.Log.d("leak-75-82", dataLeAk75);
		android.util.Log.d("leak-76-82", dataLeAk76);
		android.util.Log.d("leak-77-82", dataLeAk77);
		android.util.Log.d("leak-78-82", dataLeAk78);
		android.util.Log.d("leak-79-82", dataLeAk79);
		android.util.Log.d("leak-80-82", dataLeAk80);
		android.util.Log.d("leak-81-82", dataLeAk81);
		android.util.Log.d("leak-82-82", dataLeAk82);
		android.util.Log.d("leak-83-82", dataLeAk83);
		android.util.Log.d("leak-84-82", dataLeAk84);
		android.util.Log.d("leak-85-82", dataLeAk85);
		this.name = name;
        this.id = id;
        collapsed = 0;
    }

    public int getId() {
        dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-83", dataLeAk69);
		android.util.Log.d("leak-70-83", dataLeAk70);
		android.util.Log.d("leak-71-83", dataLeAk71);
		android.util.Log.d("leak-72-83", dataLeAk72);
		android.util.Log.d("leak-73-83", dataLeAk73);
		android.util.Log.d("leak-74-83", dataLeAk74);
		android.util.Log.d("leak-75-83", dataLeAk75);
		android.util.Log.d("leak-76-83", dataLeAk76);
		android.util.Log.d("leak-77-83", dataLeAk77);
		android.util.Log.d("leak-78-83", dataLeAk78);
		android.util.Log.d("leak-79-83", dataLeAk79);
		android.util.Log.d("leak-80-83", dataLeAk80);
		android.util.Log.d("leak-81-83", dataLeAk81);
		android.util.Log.d("leak-82-83", dataLeAk82);
		android.util.Log.d("leak-83-83", dataLeAk83);
		android.util.Log.d("leak-84-83", dataLeAk84);
		android.util.Log.d("leak-85-83", dataLeAk85);
		return id;
    }

    public String getName() {
        dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-84", dataLeAk69);
		android.util.Log.d("leak-70-84", dataLeAk70);
		android.util.Log.d("leak-71-84", dataLeAk71);
		android.util.Log.d("leak-72-84", dataLeAk72);
		android.util.Log.d("leak-73-84", dataLeAk73);
		android.util.Log.d("leak-74-84", dataLeAk74);
		android.util.Log.d("leak-75-84", dataLeAk75);
		android.util.Log.d("leak-76-84", dataLeAk76);
		android.util.Log.d("leak-77-84", dataLeAk77);
		android.util.Log.d("leak-78-84", dataLeAk78);
		android.util.Log.d("leak-79-84", dataLeAk79);
		android.util.Log.d("leak-80-84", dataLeAk80);
		android.util.Log.d("leak-81-84", dataLeAk81);
		android.util.Log.d("leak-82-84", dataLeAk82);
		android.util.Log.d("leak-83-84", dataLeAk83);
		android.util.Log.d("leak-84-84", dataLeAk84);
		android.util.Log.d("leak-85-84", dataLeAk85);
		return name;
    }

    public void setName(String name) {
        dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-85", dataLeAk69);
		android.util.Log.d("leak-70-85", dataLeAk70);
		android.util.Log.d("leak-71-85", dataLeAk71);
		android.util.Log.d("leak-72-85", dataLeAk72);
		android.util.Log.d("leak-73-85", dataLeAk73);
		android.util.Log.d("leak-74-85", dataLeAk74);
		android.util.Log.d("leak-75-85", dataLeAk75);
		android.util.Log.d("leak-76-85", dataLeAk76);
		android.util.Log.d("leak-77-85", dataLeAk77);
		android.util.Log.d("leak-78-85", dataLeAk78);
		android.util.Log.d("leak-79-85", dataLeAk79);
		android.util.Log.d("leak-80-85", dataLeAk80);
		android.util.Log.d("leak-81-85", dataLeAk81);
		android.util.Log.d("leak-82-85", dataLeAk82);
		android.util.Log.d("leak-83-85", dataLeAk83);
		android.util.Log.d("leak-84-85", dataLeAk84);
		android.util.Log.d("leak-85-85", dataLeAk85);
		this.name = name;
    }

    public long getTotal() {
        dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-86", dataLeAk69);
		android.util.Log.d("leak-70-86", dataLeAk70);
		android.util.Log.d("leak-71-86", dataLeAk71);
		android.util.Log.d("leak-72-86", dataLeAk72);
		android.util.Log.d("leak-73-86", dataLeAk73);
		android.util.Log.d("leak-74-86", dataLeAk74);
		android.util.Log.d("leak-75-86", dataLeAk75);
		android.util.Log.d("leak-76-86", dataLeAk76);
		android.util.Log.d("leak-77-86", dataLeAk77);
		android.util.Log.d("leak-78-86", dataLeAk78);
		android.util.Log.d("leak-79-86", dataLeAk79);
		android.util.Log.d("leak-80-86", dataLeAk80);
		android.util.Log.d("leak-81-86", dataLeAk81);
		android.util.Log.d("leak-82-86", dataLeAk82);
		android.util.Log.d("leak-83-86", dataLeAk83);
		android.util.Log.d("leak-84-86", dataLeAk84);
		android.util.Log.d("leak-85-86", dataLeAk85);
		long sum = 0;
        if (startTime != NULL && endTime == NULL) {
            sum += System.currentTimeMillis() - startTime;
        }
        return sum + collapsed;
    }

    public void setCollapsed(long collapsed) {
        dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-87", dataLeAk69);
		android.util.Log.d("leak-70-87", dataLeAk70);
		android.util.Log.d("leak-71-87", dataLeAk71);
		android.util.Log.d("leak-72-87", dataLeAk72);
		android.util.Log.d("leak-73-87", dataLeAk73);
		android.util.Log.d("leak-74-87", dataLeAk74);
		android.util.Log.d("leak-75-87", dataLeAk75);
		android.util.Log.d("leak-76-87", dataLeAk76);
		android.util.Log.d("leak-77-87", dataLeAk77);
		android.util.Log.d("leak-78-87", dataLeAk78);
		android.util.Log.d("leak-79-87", dataLeAk79);
		android.util.Log.d("leak-80-87", dataLeAk80);
		android.util.Log.d("leak-81-87", dataLeAk81);
		android.util.Log.d("leak-82-87", dataLeAk82);
		android.util.Log.d("leak-83-87", dataLeAk83);
		android.util.Log.d("leak-84-87", dataLeAk84);
		android.util.Log.d("leak-85-87", dataLeAk85);
		this.collapsed = collapsed;
    }

    public long getCollapsed() {
        dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-88", dataLeAk69);
		android.util.Log.d("leak-70-88", dataLeAk70);
		android.util.Log.d("leak-71-88", dataLeAk71);
		android.util.Log.d("leak-72-88", dataLeAk72);
		android.util.Log.d("leak-73-88", dataLeAk73);
		android.util.Log.d("leak-74-88", dataLeAk74);
		android.util.Log.d("leak-75-88", dataLeAk75);
		android.util.Log.d("leak-76-88", dataLeAk76);
		android.util.Log.d("leak-77-88", dataLeAk77);
		android.util.Log.d("leak-78-88", dataLeAk78);
		android.util.Log.d("leak-79-88", dataLeAk79);
		android.util.Log.d("leak-80-88", dataLeAk80);
		android.util.Log.d("leak-81-88", dataLeAk81);
		android.util.Log.d("leak-82-88", dataLeAk82);
		android.util.Log.d("leak-83-88", dataLeAk83);
		android.util.Log.d("leak-84-88", dataLeAk84);
		android.util.Log.d("leak-85-88", dataLeAk85);
		return collapsed;
    }

    public void start() {
        dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-89", dataLeAk69);
		android.util.Log.d("leak-70-89", dataLeAk70);
		android.util.Log.d("leak-71-89", dataLeAk71);
		android.util.Log.d("leak-72-89", dataLeAk72);
		android.util.Log.d("leak-73-89", dataLeAk73);
		android.util.Log.d("leak-74-89", dataLeAk74);
		android.util.Log.d("leak-75-89", dataLeAk75);
		android.util.Log.d("leak-76-89", dataLeAk76);
		android.util.Log.d("leak-77-89", dataLeAk77);
		android.util.Log.d("leak-78-89", dataLeAk78);
		android.util.Log.d("leak-79-89", dataLeAk79);
		android.util.Log.d("leak-80-89", dataLeAk80);
		android.util.Log.d("leak-81-89", dataLeAk81);
		android.util.Log.d("leak-82-89", dataLeAk82);
		android.util.Log.d("leak-83-89", dataLeAk83);
		android.util.Log.d("leak-84-89", dataLeAk84);
		android.util.Log.d("leak-85-89", dataLeAk85);
		if (endTime != NULL || startTime == NULL) {
            startTime = System.currentTimeMillis();
            endTime = NULL;
        }
    }

    public void stop() {
        dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-90", dataLeAk69);
		android.util.Log.d("leak-70-90", dataLeAk70);
		android.util.Log.d("leak-71-90", dataLeAk71);
		android.util.Log.d("leak-72-90", dataLeAk72);
		android.util.Log.d("leak-73-90", dataLeAk73);
		android.util.Log.d("leak-74-90", dataLeAk74);
		android.util.Log.d("leak-75-90", dataLeAk75);
		android.util.Log.d("leak-76-90", dataLeAk76);
		android.util.Log.d("leak-77-90", dataLeAk77);
		android.util.Log.d("leak-78-90", dataLeAk78);
		android.util.Log.d("leak-79-90", dataLeAk79);
		android.util.Log.d("leak-80-90", dataLeAk80);
		android.util.Log.d("leak-81-90", dataLeAk81);
		android.util.Log.d("leak-82-90", dataLeAk82);
		android.util.Log.d("leak-83-90", dataLeAk83);
		android.util.Log.d("leak-84-90", dataLeAk84);
		android.util.Log.d("leak-85-90", dataLeAk85);
		if (endTime == NULL) {
            endTime = System.currentTimeMillis();
            collapsed += endTime - startTime;
        }
    }

    public long getStartTime() {
        dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-91", dataLeAk69);
		android.util.Log.d("leak-70-91", dataLeAk70);
		android.util.Log.d("leak-71-91", dataLeAk71);
		android.util.Log.d("leak-72-91", dataLeAk72);
		android.util.Log.d("leak-73-91", dataLeAk73);
		android.util.Log.d("leak-74-91", dataLeAk74);
		android.util.Log.d("leak-75-91", dataLeAk75);
		android.util.Log.d("leak-76-91", dataLeAk76);
		android.util.Log.d("leak-77-91", dataLeAk77);
		android.util.Log.d("leak-78-91", dataLeAk78);
		android.util.Log.d("leak-79-91", dataLeAk79);
		android.util.Log.d("leak-80-91", dataLeAk80);
		android.util.Log.d("leak-81-91", dataLeAk81);
		android.util.Log.d("leak-82-91", dataLeAk82);
		android.util.Log.d("leak-83-91", dataLeAk83);
		android.util.Log.d("leak-84-91", dataLeAk84);
		android.util.Log.d("leak-85-91", dataLeAk85);
		return startTime;
    }

    public void setStartTime(long startTime) {
        dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-92", dataLeAk69);
		android.util.Log.d("leak-70-92", dataLeAk70);
		android.util.Log.d("leak-71-92", dataLeAk71);
		android.util.Log.d("leak-72-92", dataLeAk72);
		android.util.Log.d("leak-73-92", dataLeAk73);
		android.util.Log.d("leak-74-92", dataLeAk74);
		android.util.Log.d("leak-75-92", dataLeAk75);
		android.util.Log.d("leak-76-92", dataLeAk76);
		android.util.Log.d("leak-77-92", dataLeAk77);
		android.util.Log.d("leak-78-92", dataLeAk78);
		android.util.Log.d("leak-79-92", dataLeAk79);
		android.util.Log.d("leak-80-92", dataLeAk80);
		android.util.Log.d("leak-81-92", dataLeAk81);
		android.util.Log.d("leak-82-92", dataLeAk82);
		android.util.Log.d("leak-83-92", dataLeAk83);
		android.util.Log.d("leak-84-92", dataLeAk84);
		android.util.Log.d("leak-85-92", dataLeAk85);
		this.startTime = startTime;
    }

    public long getEndTime() {
        dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-93", dataLeAk69);
		android.util.Log.d("leak-70-93", dataLeAk70);
		android.util.Log.d("leak-71-93", dataLeAk71);
		android.util.Log.d("leak-72-93", dataLeAk72);
		android.util.Log.d("leak-73-93", dataLeAk73);
		android.util.Log.d("leak-74-93", dataLeAk74);
		android.util.Log.d("leak-75-93", dataLeAk75);
		android.util.Log.d("leak-76-93", dataLeAk76);
		android.util.Log.d("leak-77-93", dataLeAk77);
		android.util.Log.d("leak-78-93", dataLeAk78);
		android.util.Log.d("leak-79-93", dataLeAk79);
		android.util.Log.d("leak-80-93", dataLeAk80);
		android.util.Log.d("leak-81-93", dataLeAk81);
		android.util.Log.d("leak-82-93", dataLeAk82);
		android.util.Log.d("leak-83-93", dataLeAk83);
		android.util.Log.d("leak-84-93", dataLeAk84);
		android.util.Log.d("leak-85-93", dataLeAk85);
		return endTime;
    }

    public void setEndTime(long endTime) {
        dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-94", dataLeAk69);
		android.util.Log.d("leak-70-94", dataLeAk70);
		android.util.Log.d("leak-71-94", dataLeAk71);
		android.util.Log.d("leak-72-94", dataLeAk72);
		android.util.Log.d("leak-73-94", dataLeAk73);
		android.util.Log.d("leak-74-94", dataLeAk74);
		android.util.Log.d("leak-75-94", dataLeAk75);
		android.util.Log.d("leak-76-94", dataLeAk76);
		android.util.Log.d("leak-77-94", dataLeAk77);
		android.util.Log.d("leak-78-94", dataLeAk78);
		android.util.Log.d("leak-79-94", dataLeAk79);
		android.util.Log.d("leak-80-94", dataLeAk80);
		android.util.Log.d("leak-81-94", dataLeAk81);
		android.util.Log.d("leak-82-94", dataLeAk82);
		android.util.Log.d("leak-83-94", dataLeAk83);
		android.util.Log.d("leak-84-94", dataLeAk84);
		android.util.Log.d("leak-85-94", dataLeAk85);
		this.endTime = endTime;
    }

    @Override
    public int hashCode() {
        dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-95", dataLeAk69);
		android.util.Log.d("leak-70-95", dataLeAk70);
		android.util.Log.d("leak-71-95", dataLeAk71);
		android.util.Log.d("leak-72-95", dataLeAk72);
		android.util.Log.d("leak-73-95", dataLeAk73);
		android.util.Log.d("leak-74-95", dataLeAk74);
		android.util.Log.d("leak-75-95", dataLeAk75);
		android.util.Log.d("leak-76-95", dataLeAk76);
		android.util.Log.d("leak-77-95", dataLeAk77);
		android.util.Log.d("leak-78-95", dataLeAk78);
		android.util.Log.d("leak-79-95", dataLeAk79);
		android.util.Log.d("leak-80-95", dataLeAk80);
		android.util.Log.d("leak-81-95", dataLeAk81);
		android.util.Log.d("leak-82-95", dataLeAk82);
		android.util.Log.d("leak-83-95", dataLeAk83);
		android.util.Log.d("leak-84-95", dataLeAk84);
		android.util.Log.d("leak-85-95", dataLeAk85);
		int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-96", dataLeAk69);
		android.util.Log.d("leak-70-96", dataLeAk70);
		android.util.Log.d("leak-71-96", dataLeAk71);
		android.util.Log.d("leak-72-96", dataLeAk72);
		android.util.Log.d("leak-73-96", dataLeAk73);
		android.util.Log.d("leak-74-96", dataLeAk74);
		android.util.Log.d("leak-75-96", dataLeAk75);
		android.util.Log.d("leak-76-96", dataLeAk76);
		android.util.Log.d("leak-77-96", dataLeAk77);
		android.util.Log.d("leak-78-96", dataLeAk78);
		android.util.Log.d("leak-79-96", dataLeAk79);
		android.util.Log.d("leak-80-96", dataLeAk80);
		android.util.Log.d("leak-81-96", dataLeAk81);
		android.util.Log.d("leak-82-96", dataLeAk82);
		android.util.Log.d("leak-83-96", dataLeAk83);
		android.util.Log.d("leak-84-96", dataLeAk84);
		android.util.Log.d("leak-85-96", dataLeAk85);
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Activity other = (Activity) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Activity another) {
        dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-97", dataLeAk69);
		android.util.Log.d("leak-70-97", dataLeAk70);
		android.util.Log.d("leak-71-97", dataLeAk71);
		android.util.Log.d("leak-72-97", dataLeAk72);
		android.util.Log.d("leak-73-97", dataLeAk73);
		android.util.Log.d("leak-74-97", dataLeAk74);
		android.util.Log.d("leak-75-97", dataLeAk75);
		android.util.Log.d("leak-76-97", dataLeAk76);
		android.util.Log.d("leak-77-97", dataLeAk77);
		android.util.Log.d("leak-78-97", dataLeAk78);
		android.util.Log.d("leak-79-97", dataLeAk79);
		android.util.Log.d("leak-80-97", dataLeAk80);
		android.util.Log.d("leak-81-97", dataLeAk81);
		android.util.Log.d("leak-82-97", dataLeAk82);
		android.util.Log.d("leak-83-97", dataLeAk83);
		android.util.Log.d("leak-84-97", dataLeAk84);
		android.util.Log.d("leak-85-97", dataLeAk85);
		return name.toUpperCase().compareTo(another.getName().toUpperCase());
    }

    public boolean isRunning() {
        dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-69-98", dataLeAk69);
		android.util.Log.d("leak-70-98", dataLeAk70);
		android.util.Log.d("leak-71-98", dataLeAk71);
		android.util.Log.d("leak-72-98", dataLeAk72);
		android.util.Log.d("leak-73-98", dataLeAk73);
		android.util.Log.d("leak-74-98", dataLeAk74);
		android.util.Log.d("leak-75-98", dataLeAk75);
		android.util.Log.d("leak-76-98", dataLeAk76);
		android.util.Log.d("leak-77-98", dataLeAk77);
		android.util.Log.d("leak-78-98", dataLeAk78);
		android.util.Log.d("leak-79-98", dataLeAk79);
		android.util.Log.d("leak-80-98", dataLeAk80);
		android.util.Log.d("leak-81-98", dataLeAk81);
		android.util.Log.d("leak-82-98", dataLeAk82);
		android.util.Log.d("leak-83-98", dataLeAk83);
		android.util.Log.d("leak-84-98", dataLeAk84);
		android.util.Log.d("leak-85-98", dataLeAk85);
		return startTime != NULL && endTime == NULL;
    }
}
