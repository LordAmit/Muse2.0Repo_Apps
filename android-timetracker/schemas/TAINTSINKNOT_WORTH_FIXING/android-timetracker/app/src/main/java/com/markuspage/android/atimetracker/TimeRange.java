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

    String dataLeAk14 = "14";

	String dataLeAk13 = "13";

	String dataLeAk12 = "12";

	String dataLeAk11 = "11";

	String dataLeAk10 = "10";

	String dataLeAk9 = "9";

	String dataLeAk8 = "8";

	String dataLeAk7 = "7";

	String dataLeAk6 = "6";

	String dataLeAk5 = "5";

	String dataLeAk4 = "4";

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
        dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-5-4", dataLeAk5);
		android.util.Log.d("leak-6-4", dataLeAk6);
		android.util.Log.d("leak-7-4", dataLeAk7);
		android.util.Log.d("leak-8-4", dataLeAk8);
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-10-4", dataLeAk10);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-14-4", dataLeAk14);
		this.start = start;
        this.end = end;
    }

    public long getStart() {
        dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-5-5", dataLeAk5);
		android.util.Log.d("leak-6-5", dataLeAk6);
		android.util.Log.d("leak-7-5", dataLeAk7);
		android.util.Log.d("leak-8-5", dataLeAk8);
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-10-5", dataLeAk10);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
		return start;
    }

    public void setStart(long start) {
        dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-6", dataLeAk4);
		android.util.Log.d("leak-5-6", dataLeAk5);
		android.util.Log.d("leak-6-6", dataLeAk6);
		android.util.Log.d("leak-7-6", dataLeAk7);
		android.util.Log.d("leak-8-6", dataLeAk8);
		android.util.Log.d("leak-9-6", dataLeAk9);
		android.util.Log.d("leak-10-6", dataLeAk10);
		android.util.Log.d("leak-11-6", dataLeAk11);
		android.util.Log.d("leak-12-6", dataLeAk12);
		android.util.Log.d("leak-13-6", dataLeAk13);
		android.util.Log.d("leak-14-6", dataLeAk14);
		this.start = start;
    }

    public long getEnd() {
        dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-7", dataLeAk4);
		android.util.Log.d("leak-5-7", dataLeAk5);
		android.util.Log.d("leak-6-7", dataLeAk6);
		android.util.Log.d("leak-7-7", dataLeAk7);
		android.util.Log.d("leak-8-7", dataLeAk8);
		android.util.Log.d("leak-9-7", dataLeAk9);
		android.util.Log.d("leak-10-7", dataLeAk10);
		android.util.Log.d("leak-11-7", dataLeAk11);
		android.util.Log.d("leak-12-7", dataLeAk12);
		android.util.Log.d("leak-13-7", dataLeAk13);
		android.util.Log.d("leak-14-7", dataLeAk14);
		return end;
    }

    public void setEnd(long end) {
        dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-8", dataLeAk4);
		android.util.Log.d("leak-5-8", dataLeAk5);
		android.util.Log.d("leak-6-8", dataLeAk6);
		android.util.Log.d("leak-7-8", dataLeAk7);
		android.util.Log.d("leak-8-8", dataLeAk8);
		android.util.Log.d("leak-9-8", dataLeAk9);
		android.util.Log.d("leak-10-8", dataLeAk10);
		android.util.Log.d("leak-11-8", dataLeAk11);
		android.util.Log.d("leak-12-8", dataLeAk12);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-14-8", dataLeAk14);
		this.end = end;
    }

    public long getTotal() {
        dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-9", dataLeAk4);
		android.util.Log.d("leak-5-9", dataLeAk5);
		android.util.Log.d("leak-6-9", dataLeAk6);
		android.util.Log.d("leak-7-9", dataLeAk7);
		android.util.Log.d("leak-8-9", dataLeAk8);
		android.util.Log.d("leak-9-9", dataLeAk9);
		android.util.Log.d("leak-10-9", dataLeAk10);
		android.util.Log.d("leak-11-9", dataLeAk11);
		android.util.Log.d("leak-12-9", dataLeAk12);
		android.util.Log.d("leak-13-9", dataLeAk13);
		android.util.Log.d("leak-14-9", dataLeAk14);
		if (end == NULL) {
            return System.currentTimeMillis() - start;
        }
        return end - start;
    }

    @Override
    public String toString() {
        dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-10", dataLeAk4);
		android.util.Log.d("leak-5-10", dataLeAk5);
		android.util.Log.d("leak-6-10", dataLeAk6);
		android.util.Log.d("leak-7-10", dataLeAk7);
		android.util.Log.d("leak-8-10", dataLeAk8);
		android.util.Log.d("leak-9-10", dataLeAk9);
		android.util.Log.d("leak-10-10", dataLeAk10);
		android.util.Log.d("leak-11-10", dataLeAk11);
		android.util.Log.d("leak-12-10", dataLeAk12);
		android.util.Log.d("leak-13-10", dataLeAk13);
		android.util.Log.d("leak-14-10", dataLeAk14);
		Date s = new Date(start);
        final StringBuilder b = new StringBuilder(s.toString());
        b.append(" - ");
        if (end != NULL) {
            b.append(new Date(end));
        } else {
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
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-11", dataLeAk4);
		android.util.Log.d("leak-5-11", dataLeAk5);
		android.util.Log.d("leak-6-11", dataLeAk6);
		android.util.Log.d("leak-7-11", dataLeAk7);
		android.util.Log.d("leak-8-11", dataLeAk8);
		android.util.Log.d("leak-9-11", dataLeAk9);
		android.util.Log.d("leak-10-11", dataLeAk10);
		android.util.Log.d("leak-11-11", dataLeAk11);
		android.util.Log.d("leak-12-11", dataLeAk12);
		android.util.Log.d("leak-13-11", dataLeAk13);
		android.util.Log.d("leak-14-11", dataLeAk14);
		Date s = new Date(start);
        final StringBuilder b = new StringBuilder(format.format(s));
        b.append(" - ");
        if (end != NULL) {
            b.append(format.format(new Date(end)));
        } else {
            b.append("...");
        }
        return b.toString();
    }

    @Override
    public int compareTo(TimeRange another) {
        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-12", dataLeAk4);
		android.util.Log.d("leak-5-12", dataLeAk5);
		android.util.Log.d("leak-6-12", dataLeAk6);
		android.util.Log.d("leak-7-12", dataLeAk7);
		android.util.Log.d("leak-8-12", dataLeAk8);
		android.util.Log.d("leak-9-12", dataLeAk9);
		android.util.Log.d("leak-10-12", dataLeAk10);
		android.util.Log.d("leak-11-12", dataLeAk11);
		android.util.Log.d("leak-12-12", dataLeAk12);
		android.util.Log.d("leak-13-12", dataLeAk13);
		android.util.Log.d("leak-14-12", dataLeAk14);
		if (start < another.start) {
            return -1;
        } else if (start > another.start) {
            return 1;
        } else {
            if (end == NULL) {
                return 1;
            }
            if (another.end == NULL) {
                return -1;
            }
            if (end < another.end) {
                return -1;
            } else if (end > another.end) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-13", dataLeAk4);
		android.util.Log.d("leak-5-13", dataLeAk5);
		android.util.Log.d("leak-6-13", dataLeAk6);
		android.util.Log.d("leak-7-13", dataLeAk7);
		android.util.Log.d("leak-8-13", dataLeAk8);
		android.util.Log.d("leak-9-13", dataLeAk9);
		android.util.Log.d("leak-10-13", dataLeAk10);
		android.util.Log.d("leak-11-13", dataLeAk11);
		android.util.Log.d("leak-12-13", dataLeAk12);
		android.util.Log.d("leak-13-13", dataLeAk13);
		android.util.Log.d("leak-14-13", dataLeAk14);
		if (o instanceof TimeRange) {
            TimeRange t = (TimeRange) o;
            return t.start == start && t.end == end;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-14", dataLeAk4);
		android.util.Log.d("leak-5-14", dataLeAk5);
		android.util.Log.d("leak-6-14", dataLeAk6);
		android.util.Log.d("leak-7-14", dataLeAk7);
		android.util.Log.d("leak-8-14", dataLeAk8);
		android.util.Log.d("leak-9-14", dataLeAk9);
		android.util.Log.d("leak-10-14", dataLeAk10);
		android.util.Log.d("leak-11-14", dataLeAk11);
		android.util.Log.d("leak-12-14", dataLeAk12);
		android.util.Log.d("leak-13-14", dataLeAk13);
		android.util.Log.d("leak-14-14", dataLeAk14);
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
        for (int x : FIELDS) {
            day.set(x, day.getMinimum(x));
        }
        long ms_start = day.getTime().getTime();
        day.add(Calendar.DAY_OF_MONTH, 1);
        long ms_end = day.getTime().getTime();

        if (ms_end < start || end < ms_start) {
            return 0;
        }

        long off_start = ms_start > start ? ms_start : start;
        long off_end = ms_end < end ? ms_end : end;
        long off_diff = off_end - off_start;
        return off_diff;
    }
}
