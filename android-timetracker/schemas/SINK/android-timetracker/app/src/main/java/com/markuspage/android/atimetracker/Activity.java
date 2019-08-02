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

    String dataLeAk144 = "";

	String dataLeAk143 = "";

	String dataLeAk142 = "";

	String dataLeAk141 = "";

	String dataLeAk140 = "";

	String dataLeAk139 = "";

	String dataLeAk138 = "";

	String dataLeAk137 = "";

	String dataLeAk136 = "";

	String dataLeAk135 = "";

	String dataLeAk134 = "";

	String dataLeAk133 = "";

	String dataLeAk132 = "";

	String dataLeAk131 = "";

	String dataLeAk130 = "";

	String dataLeAk129 = "";

	String dataLeAk128 = "";

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
        dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-0", dataLeAk128);
		android.util.Log.d("leak-129-0", dataLeAk129);
		android.util.Log.d("leak-130-0", dataLeAk130);
		android.util.Log.d("leak-131-0", dataLeAk131);
		android.util.Log.d("leak-132-0", dataLeAk132);
		android.util.Log.d("leak-133-0", dataLeAk133);
		android.util.Log.d("leak-134-0", dataLeAk134);
		android.util.Log.d("leak-135-0", dataLeAk135);
		android.util.Log.d("leak-136-0", dataLeAk136);
		android.util.Log.d("leak-137-0", dataLeAk137);
		android.util.Log.d("leak-138-0", dataLeAk138);
		android.util.Log.d("leak-139-0", dataLeAk139);
		android.util.Log.d("leak-140-0", dataLeAk140);
		android.util.Log.d("leak-141-0", dataLeAk141);
		android.util.Log.d("leak-142-0", dataLeAk142);
		android.util.Log.d("leak-143-0", dataLeAk143);
		android.util.Log.d("leak-144-0", dataLeAk144);
		this.name = name;
        this.id = id;
        collapsed = 0;
    }

    public int getId() {
        dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-1", dataLeAk128);
		android.util.Log.d("leak-129-1", dataLeAk129);
		android.util.Log.d("leak-130-1", dataLeAk130);
		android.util.Log.d("leak-131-1", dataLeAk131);
		android.util.Log.d("leak-132-1", dataLeAk132);
		android.util.Log.d("leak-133-1", dataLeAk133);
		android.util.Log.d("leak-134-1", dataLeAk134);
		android.util.Log.d("leak-135-1", dataLeAk135);
		android.util.Log.d("leak-136-1", dataLeAk136);
		android.util.Log.d("leak-137-1", dataLeAk137);
		android.util.Log.d("leak-138-1", dataLeAk138);
		android.util.Log.d("leak-139-1", dataLeAk139);
		android.util.Log.d("leak-140-1", dataLeAk140);
		android.util.Log.d("leak-141-1", dataLeAk141);
		android.util.Log.d("leak-142-1", dataLeAk142);
		android.util.Log.d("leak-143-1", dataLeAk143);
		android.util.Log.d("leak-144-1", dataLeAk144);
		return id;
    }

    public String getName() {
        dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-2", dataLeAk128);
		android.util.Log.d("leak-129-2", dataLeAk129);
		android.util.Log.d("leak-130-2", dataLeAk130);
		android.util.Log.d("leak-131-2", dataLeAk131);
		android.util.Log.d("leak-132-2", dataLeAk132);
		android.util.Log.d("leak-133-2", dataLeAk133);
		android.util.Log.d("leak-134-2", dataLeAk134);
		android.util.Log.d("leak-135-2", dataLeAk135);
		android.util.Log.d("leak-136-2", dataLeAk136);
		android.util.Log.d("leak-137-2", dataLeAk137);
		android.util.Log.d("leak-138-2", dataLeAk138);
		android.util.Log.d("leak-139-2", dataLeAk139);
		android.util.Log.d("leak-140-2", dataLeAk140);
		android.util.Log.d("leak-141-2", dataLeAk141);
		android.util.Log.d("leak-142-2", dataLeAk142);
		android.util.Log.d("leak-143-2", dataLeAk143);
		android.util.Log.d("leak-144-2", dataLeAk144);
		return name;
    }

    public void setName(String name) {
        dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-3", dataLeAk128);
		android.util.Log.d("leak-129-3", dataLeAk129);
		android.util.Log.d("leak-130-3", dataLeAk130);
		android.util.Log.d("leak-131-3", dataLeAk131);
		android.util.Log.d("leak-132-3", dataLeAk132);
		android.util.Log.d("leak-133-3", dataLeAk133);
		android.util.Log.d("leak-134-3", dataLeAk134);
		android.util.Log.d("leak-135-3", dataLeAk135);
		android.util.Log.d("leak-136-3", dataLeAk136);
		android.util.Log.d("leak-137-3", dataLeAk137);
		android.util.Log.d("leak-138-3", dataLeAk138);
		android.util.Log.d("leak-139-3", dataLeAk139);
		android.util.Log.d("leak-140-3", dataLeAk140);
		android.util.Log.d("leak-141-3", dataLeAk141);
		android.util.Log.d("leak-142-3", dataLeAk142);
		android.util.Log.d("leak-143-3", dataLeAk143);
		android.util.Log.d("leak-144-3", dataLeAk144);
		this.name = name;
    }

    public long getTotal() {
        dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-4", dataLeAk128);
		android.util.Log.d("leak-129-4", dataLeAk129);
		android.util.Log.d("leak-130-4", dataLeAk130);
		android.util.Log.d("leak-131-4", dataLeAk131);
		android.util.Log.d("leak-132-4", dataLeAk132);
		android.util.Log.d("leak-133-4", dataLeAk133);
		android.util.Log.d("leak-134-4", dataLeAk134);
		android.util.Log.d("leak-135-4", dataLeAk135);
		android.util.Log.d("leak-136-4", dataLeAk136);
		android.util.Log.d("leak-137-4", dataLeAk137);
		android.util.Log.d("leak-138-4", dataLeAk138);
		android.util.Log.d("leak-139-4", dataLeAk139);
		android.util.Log.d("leak-140-4", dataLeAk140);
		android.util.Log.d("leak-141-4", dataLeAk141);
		android.util.Log.d("leak-142-4", dataLeAk142);
		android.util.Log.d("leak-143-4", dataLeAk143);
		android.util.Log.d("leak-144-4", dataLeAk144);
		long sum = 0;
        if (startTime != NULL && endTime == NULL) {
            sum += System.currentTimeMillis() - startTime;
        }
        return sum + collapsed;
    }

    public void setCollapsed(long collapsed) {
        dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-5", dataLeAk128);
		android.util.Log.d("leak-129-5", dataLeAk129);
		android.util.Log.d("leak-130-5", dataLeAk130);
		android.util.Log.d("leak-131-5", dataLeAk131);
		android.util.Log.d("leak-132-5", dataLeAk132);
		android.util.Log.d("leak-133-5", dataLeAk133);
		android.util.Log.d("leak-134-5", dataLeAk134);
		android.util.Log.d("leak-135-5", dataLeAk135);
		android.util.Log.d("leak-136-5", dataLeAk136);
		android.util.Log.d("leak-137-5", dataLeAk137);
		android.util.Log.d("leak-138-5", dataLeAk138);
		android.util.Log.d("leak-139-5", dataLeAk139);
		android.util.Log.d("leak-140-5", dataLeAk140);
		android.util.Log.d("leak-141-5", dataLeAk141);
		android.util.Log.d("leak-142-5", dataLeAk142);
		android.util.Log.d("leak-143-5", dataLeAk143);
		android.util.Log.d("leak-144-5", dataLeAk144);
		this.collapsed = collapsed;
    }

    public long getCollapsed() {
        dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-6", dataLeAk128);
		android.util.Log.d("leak-129-6", dataLeAk129);
		android.util.Log.d("leak-130-6", dataLeAk130);
		android.util.Log.d("leak-131-6", dataLeAk131);
		android.util.Log.d("leak-132-6", dataLeAk132);
		android.util.Log.d("leak-133-6", dataLeAk133);
		android.util.Log.d("leak-134-6", dataLeAk134);
		android.util.Log.d("leak-135-6", dataLeAk135);
		android.util.Log.d("leak-136-6", dataLeAk136);
		android.util.Log.d("leak-137-6", dataLeAk137);
		android.util.Log.d("leak-138-6", dataLeAk138);
		android.util.Log.d("leak-139-6", dataLeAk139);
		android.util.Log.d("leak-140-6", dataLeAk140);
		android.util.Log.d("leak-141-6", dataLeAk141);
		android.util.Log.d("leak-142-6", dataLeAk142);
		android.util.Log.d("leak-143-6", dataLeAk143);
		android.util.Log.d("leak-144-6", dataLeAk144);
		return collapsed;
    }

    public void start() {
        dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-7", dataLeAk128);
		android.util.Log.d("leak-129-7", dataLeAk129);
		android.util.Log.d("leak-130-7", dataLeAk130);
		android.util.Log.d("leak-131-7", dataLeAk131);
		android.util.Log.d("leak-132-7", dataLeAk132);
		android.util.Log.d("leak-133-7", dataLeAk133);
		android.util.Log.d("leak-134-7", dataLeAk134);
		android.util.Log.d("leak-135-7", dataLeAk135);
		android.util.Log.d("leak-136-7", dataLeAk136);
		android.util.Log.d("leak-137-7", dataLeAk137);
		android.util.Log.d("leak-138-7", dataLeAk138);
		android.util.Log.d("leak-139-7", dataLeAk139);
		android.util.Log.d("leak-140-7", dataLeAk140);
		android.util.Log.d("leak-141-7", dataLeAk141);
		android.util.Log.d("leak-142-7", dataLeAk142);
		android.util.Log.d("leak-143-7", dataLeAk143);
		android.util.Log.d("leak-144-7", dataLeAk144);
		if (endTime != NULL || startTime == NULL) {
            startTime = System.currentTimeMillis();
            endTime = NULL;
        }
    }

    public void stop() {
        dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-8", dataLeAk128);
		android.util.Log.d("leak-129-8", dataLeAk129);
		android.util.Log.d("leak-130-8", dataLeAk130);
		android.util.Log.d("leak-131-8", dataLeAk131);
		android.util.Log.d("leak-132-8", dataLeAk132);
		android.util.Log.d("leak-133-8", dataLeAk133);
		android.util.Log.d("leak-134-8", dataLeAk134);
		android.util.Log.d("leak-135-8", dataLeAk135);
		android.util.Log.d("leak-136-8", dataLeAk136);
		android.util.Log.d("leak-137-8", dataLeAk137);
		android.util.Log.d("leak-138-8", dataLeAk138);
		android.util.Log.d("leak-139-8", dataLeAk139);
		android.util.Log.d("leak-140-8", dataLeAk140);
		android.util.Log.d("leak-141-8", dataLeAk141);
		android.util.Log.d("leak-142-8", dataLeAk142);
		android.util.Log.d("leak-143-8", dataLeAk143);
		android.util.Log.d("leak-144-8", dataLeAk144);
		if (endTime == NULL) {
            endTime = System.currentTimeMillis();
            collapsed += endTime - startTime;
        }
    }

    public long getStartTime() {
        dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-9", dataLeAk128);
		android.util.Log.d("leak-129-9", dataLeAk129);
		android.util.Log.d("leak-130-9", dataLeAk130);
		android.util.Log.d("leak-131-9", dataLeAk131);
		android.util.Log.d("leak-132-9", dataLeAk132);
		android.util.Log.d("leak-133-9", dataLeAk133);
		android.util.Log.d("leak-134-9", dataLeAk134);
		android.util.Log.d("leak-135-9", dataLeAk135);
		android.util.Log.d("leak-136-9", dataLeAk136);
		android.util.Log.d("leak-137-9", dataLeAk137);
		android.util.Log.d("leak-138-9", dataLeAk138);
		android.util.Log.d("leak-139-9", dataLeAk139);
		android.util.Log.d("leak-140-9", dataLeAk140);
		android.util.Log.d("leak-141-9", dataLeAk141);
		android.util.Log.d("leak-142-9", dataLeAk142);
		android.util.Log.d("leak-143-9", dataLeAk143);
		android.util.Log.d("leak-144-9", dataLeAk144);
		return startTime;
    }

    public void setStartTime(long startTime) {
        dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-10", dataLeAk128);
		android.util.Log.d("leak-129-10", dataLeAk129);
		android.util.Log.d("leak-130-10", dataLeAk130);
		android.util.Log.d("leak-131-10", dataLeAk131);
		android.util.Log.d("leak-132-10", dataLeAk132);
		android.util.Log.d("leak-133-10", dataLeAk133);
		android.util.Log.d("leak-134-10", dataLeAk134);
		android.util.Log.d("leak-135-10", dataLeAk135);
		android.util.Log.d("leak-136-10", dataLeAk136);
		android.util.Log.d("leak-137-10", dataLeAk137);
		android.util.Log.d("leak-138-10", dataLeAk138);
		android.util.Log.d("leak-139-10", dataLeAk139);
		android.util.Log.d("leak-140-10", dataLeAk140);
		android.util.Log.d("leak-141-10", dataLeAk141);
		android.util.Log.d("leak-142-10", dataLeAk142);
		android.util.Log.d("leak-143-10", dataLeAk143);
		android.util.Log.d("leak-144-10", dataLeAk144);
		this.startTime = startTime;
    }

    public long getEndTime() {
        dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-11", dataLeAk128);
		android.util.Log.d("leak-129-11", dataLeAk129);
		android.util.Log.d("leak-130-11", dataLeAk130);
		android.util.Log.d("leak-131-11", dataLeAk131);
		android.util.Log.d("leak-132-11", dataLeAk132);
		android.util.Log.d("leak-133-11", dataLeAk133);
		android.util.Log.d("leak-134-11", dataLeAk134);
		android.util.Log.d("leak-135-11", dataLeAk135);
		android.util.Log.d("leak-136-11", dataLeAk136);
		android.util.Log.d("leak-137-11", dataLeAk137);
		android.util.Log.d("leak-138-11", dataLeAk138);
		android.util.Log.d("leak-139-11", dataLeAk139);
		android.util.Log.d("leak-140-11", dataLeAk140);
		android.util.Log.d("leak-141-11", dataLeAk141);
		android.util.Log.d("leak-142-11", dataLeAk142);
		android.util.Log.d("leak-143-11", dataLeAk143);
		android.util.Log.d("leak-144-11", dataLeAk144);
		return endTime;
    }

    public void setEndTime(long endTime) {
        dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-12", dataLeAk128);
		android.util.Log.d("leak-129-12", dataLeAk129);
		android.util.Log.d("leak-130-12", dataLeAk130);
		android.util.Log.d("leak-131-12", dataLeAk131);
		android.util.Log.d("leak-132-12", dataLeAk132);
		android.util.Log.d("leak-133-12", dataLeAk133);
		android.util.Log.d("leak-134-12", dataLeAk134);
		android.util.Log.d("leak-135-12", dataLeAk135);
		android.util.Log.d("leak-136-12", dataLeAk136);
		android.util.Log.d("leak-137-12", dataLeAk137);
		android.util.Log.d("leak-138-12", dataLeAk138);
		android.util.Log.d("leak-139-12", dataLeAk139);
		android.util.Log.d("leak-140-12", dataLeAk140);
		android.util.Log.d("leak-141-12", dataLeAk141);
		android.util.Log.d("leak-142-12", dataLeAk142);
		android.util.Log.d("leak-143-12", dataLeAk143);
		android.util.Log.d("leak-144-12", dataLeAk144);
		this.endTime = endTime;
    }

    @Override
    public int hashCode() {
        dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-13", dataLeAk128);
		android.util.Log.d("leak-129-13", dataLeAk129);
		android.util.Log.d("leak-130-13", dataLeAk130);
		android.util.Log.d("leak-131-13", dataLeAk131);
		android.util.Log.d("leak-132-13", dataLeAk132);
		android.util.Log.d("leak-133-13", dataLeAk133);
		android.util.Log.d("leak-134-13", dataLeAk134);
		android.util.Log.d("leak-135-13", dataLeAk135);
		android.util.Log.d("leak-136-13", dataLeAk136);
		android.util.Log.d("leak-137-13", dataLeAk137);
		android.util.Log.d("leak-138-13", dataLeAk138);
		android.util.Log.d("leak-139-13", dataLeAk139);
		android.util.Log.d("leak-140-13", dataLeAk140);
		android.util.Log.d("leak-141-13", dataLeAk141);
		android.util.Log.d("leak-142-13", dataLeAk142);
		android.util.Log.d("leak-143-13", dataLeAk143);
		android.util.Log.d("leak-144-13", dataLeAk144);
		int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-14", dataLeAk128);
		android.util.Log.d("leak-129-14", dataLeAk129);
		android.util.Log.d("leak-130-14", dataLeAk130);
		android.util.Log.d("leak-131-14", dataLeAk131);
		android.util.Log.d("leak-132-14", dataLeAk132);
		android.util.Log.d("leak-133-14", dataLeAk133);
		android.util.Log.d("leak-134-14", dataLeAk134);
		android.util.Log.d("leak-135-14", dataLeAk135);
		android.util.Log.d("leak-136-14", dataLeAk136);
		android.util.Log.d("leak-137-14", dataLeAk137);
		android.util.Log.d("leak-138-14", dataLeAk138);
		android.util.Log.d("leak-139-14", dataLeAk139);
		android.util.Log.d("leak-140-14", dataLeAk140);
		android.util.Log.d("leak-141-14", dataLeAk141);
		android.util.Log.d("leak-142-14", dataLeAk142);
		android.util.Log.d("leak-143-14", dataLeAk143);
		android.util.Log.d("leak-144-14", dataLeAk144);
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
        dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-15", dataLeAk128);
		android.util.Log.d("leak-129-15", dataLeAk129);
		android.util.Log.d("leak-130-15", dataLeAk130);
		android.util.Log.d("leak-131-15", dataLeAk131);
		android.util.Log.d("leak-132-15", dataLeAk132);
		android.util.Log.d("leak-133-15", dataLeAk133);
		android.util.Log.d("leak-134-15", dataLeAk134);
		android.util.Log.d("leak-135-15", dataLeAk135);
		android.util.Log.d("leak-136-15", dataLeAk136);
		android.util.Log.d("leak-137-15", dataLeAk137);
		android.util.Log.d("leak-138-15", dataLeAk138);
		android.util.Log.d("leak-139-15", dataLeAk139);
		android.util.Log.d("leak-140-15", dataLeAk140);
		android.util.Log.d("leak-141-15", dataLeAk141);
		android.util.Log.d("leak-142-15", dataLeAk142);
		android.util.Log.d("leak-143-15", dataLeAk143);
		android.util.Log.d("leak-144-15", dataLeAk144);
		return name.toUpperCase().compareTo(another.getName().toUpperCase());
    }

    public boolean isRunning() {
        dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-16", dataLeAk128);
		android.util.Log.d("leak-129-16", dataLeAk129);
		android.util.Log.d("leak-130-16", dataLeAk130);
		android.util.Log.d("leak-131-16", dataLeAk131);
		android.util.Log.d("leak-132-16", dataLeAk132);
		android.util.Log.d("leak-133-16", dataLeAk133);
		android.util.Log.d("leak-134-16", dataLeAk134);
		android.util.Log.d("leak-135-16", dataLeAk135);
		android.util.Log.d("leak-136-16", dataLeAk136);
		android.util.Log.d("leak-137-16", dataLeAk137);
		android.util.Log.d("leak-138-16", dataLeAk138);
		android.util.Log.d("leak-139-16", dataLeAk139);
		android.util.Log.d("leak-140-16", dataLeAk140);
		android.util.Log.d("leak-141-16", dataLeAk141);
		android.util.Log.d("leak-142-16", dataLeAk142);
		android.util.Log.d("leak-143-16", dataLeAk143);
		android.util.Log.d("leak-144-16", dataLeAk144);
		return startTime != NULL && endTime == NULL;
    }
}
