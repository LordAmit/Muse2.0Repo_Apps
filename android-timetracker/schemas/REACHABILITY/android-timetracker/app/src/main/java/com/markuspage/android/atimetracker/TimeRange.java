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

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Representation of a time range.
 *
 * @author Sean Russell, ser@germane-software.com
 */
public class TimeRange implements Comparable<TimeRange> {

    String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);

	public static final long NULL = -1;

    private static final int[] FIELDS = {
        Calendar.HOUR_OF_DAY,
        Calendar.MINUTE,
        Calendar.SECOND,
        Calendar.MILLISECOND
    };

    private long start;
    private long end;

    public TimeRange(long start, long end) {
        String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
		this.start = start;
        this.end = end;
    }

    public long getStart() {
        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
		return start;
    }

    public void setStart(long start) {
        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
		this.start = start;
    }

    public long getEnd() {
        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
		return end;
    }

    public void setEnd(long end) {
        String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
		this.end = end;
    }

    public long getTotal() {
        String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
		if (end == NULL) {
            String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
			return System.currentTimeMillis() - start;
        }
        return end - start;
    }

    @Override
    public String toString() {
        String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
		Date s = new Date(start);
        final StringBuilder b = new StringBuilder(s.toString());
        b.append(" - ");
        if (end != NULL) {
            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
			b.append(new Date(end));
        } else {
            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
			b.append("...");
        }
        return b.toString();
    }

    /**
     * Formats this time range in textual form using the supplied date format.
     * @param format for the times
     * @return the textual representation
     */
    public String format(DateFormat format) {
        String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);
		Date s = new Date(start);
        final StringBuilder b = new StringBuilder(format.format(s));
        b.append(" - ");
        if (end != NULL) {
            String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
			b.append(format.format(new Date(end)));
        } else {
            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
			b.append("...");
        }
        return b.toString();
    }

    @Override
    public int compareTo(TimeRange another) {
        String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
		if (start < another.start) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
			return -1;
        } else if (start > another.start) {
            String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
			return 1;
        } else {
            String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
			if (end == NULL) {
                String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
				return 1;
            }
            if (another.end == NULL) {
                String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
				return -1;
            }
            if (end < another.end) {
                String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
				return -1;
            } else if (end > another.end) {
                String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
				return 1;
            } else {
                String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
				return 0;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
		if (o instanceof TimeRange) {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
			TimeRange t = (TimeRange) o;
            return t.start == start && t.end == end;
        } else {
            String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
			return false;
        }
    }

    @Override
    public int hashCode() {
        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
		return (int) (start + (end * 101));
    }

    /**
     * Finds the amount of time from a range that overlaps with a day
     *
     * @param day The day on which the time must overlap to be counted
     * @param start The range start
     * @param end The range end
     * @return The number of milliseconds of the range that overlaps with the
     * day
     */
    public static long overlap(Calendar day, long start, long end) {
        String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
		for (int x : FIELDS) {
            String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
			day.set(x, day.getMinimum(x));
        }
        long ms_start = day.getTime().getTime();
        day.add(Calendar.DAY_OF_MONTH, 1);
        long ms_end = day.getTime().getTime();

        if (ms_end < start || end < ms_start) {
            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
			return 0;
        }

        long off_start = ms_start > start ? ms_start : start;
        long off_end = ms_end < end ? ms_end : end;
        long off_diff = off_end - off_start;
        return off_diff;
    }
}
