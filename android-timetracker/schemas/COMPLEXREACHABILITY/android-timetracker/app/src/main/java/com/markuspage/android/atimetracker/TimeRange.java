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
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
		String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
		android.util.Log.d("leak-4", dataLeAkPath4);
		this.start = start;
        this.end = end;
    }

    public long getStart() {
        String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP5.put("test", new java.util.HashMap<String, String>());
		leakMaP5.get("test").put("test", dataLeAk5);
		String dataLeAkPath5 = leakMaP5.get("test").get("test");
		android.util.Log.d("leak-5", dataLeAkPath5);
		return start;
    }

    public void setStart(long start) {
        String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
		android.util.Log.d("leak-6", dataLeAkPath6);
		this.start = start;
    }

    public long getEnd() {
        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
		android.util.Log.d("leak-7", dataLeAkPath7);
		return end;
    }

    public void setEnd(long end) {
        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
		String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
		android.util.Log.d("leak-8", dataLeAkPath8);
		this.end = end;
    }

    public long getTotal() {
        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP9.put("test", new java.util.HashMap<String, String>());
		leakMaP9.get("test").put("test", dataLeAk9);
		String dataLeAkPath9 = leakMaP9.get("test").get("test");
		android.util.Log.d("leak-9", dataLeAkPath9);
		if (end == NULL) {
            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
			android.util.Log.d("leak-10", dataLeAkPath10);
			return System.currentTimeMillis() - start;
        }
        return end - start;
    }

    @Override
    public String toString() {
        String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
		android.util.Log.d("leak-11", dataLeAkPath11);
		Date s = new Date(start);
        final StringBuilder b = new StringBuilder(s.toString());
        b.append(" - ");
        if (end != NULL) {
            String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
			String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
			android.util.Log.d("leak-12", dataLeAkPath12);
			b.append(new Date(end));
        } else {
            String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP13.put("test", new java.util.HashMap<String, String>());
			leakMaP13.get("test").put("test", dataLeAk13);
			String dataLeAkPath13 = leakMaP13.get("test").get("test");
			android.util.Log.d("leak-13", dataLeAkPath13);
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
        String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
		android.util.Log.d("leak-14", dataLeAkPath14);
		Date s = new Date(start);
        final StringBuilder b = new StringBuilder(format.format(s));
        b.append(" - ");
        if (end != NULL) {
            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
			android.util.Log.d("leak-15", dataLeAkPath15);
			b.append(format.format(new Date(end)));
        } else {
            String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
			String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
			android.util.Log.d("leak-16", dataLeAkPath16);
			b.append("...");
        }
        return b.toString();
    }

    @Override
    public int compareTo(TimeRange another) {
        String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP17.put("test", new java.util.HashMap<String, String>());
		leakMaP17.get("test").put("test", dataLeAk17);
		String dataLeAkPath17 = leakMaP17.get("test").get("test");
		android.util.Log.d("leak-17", dataLeAkPath17);
		if (start < another.start) {
            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
			android.util.Log.d("leak-18", dataLeAkPath18);
			return -1;
        } else if (start > another.start) {
            String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
			android.util.Log.d("leak-19", dataLeAkPath19);
			return 1;
        } else {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
			String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
			android.util.Log.d("leak-20", dataLeAkPath20);
			if (end == NULL) {
                String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP21.put("test", new java.util.HashMap<String, String>());
				leakMaP21.get("test").put("test", dataLeAk21);
				String dataLeAkPath21 = leakMaP21.get("test").get("test");
				android.util.Log.d("leak-21", dataLeAkPath21);
				return 1;
            }
            if (another.end == NULL) {
                String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
				android.util.Log.d("leak-22", dataLeAkPath22);
				return -1;
            }
            if (end < another.end) {
                String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
				android.util.Log.d("leak-23", dataLeAkPath23);
				return -1;
            } else if (end > another.end) {
                String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
				String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
				android.util.Log.d("leak-24", dataLeAkPath24);
				return 1;
            } else {
                String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP25.put("test", new java.util.HashMap<String, String>());
				leakMaP25.get("test").put("test", dataLeAk25);
				String dataLeAkPath25 = leakMaP25.get("test").get("test");
				android.util.Log.d("leak-25", dataLeAkPath25);
				return 0;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
		android.util.Log.d("leak-26", dataLeAkPath26);
		if (o instanceof TimeRange) {
            String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
			android.util.Log.d("leak-27", dataLeAkPath27);
			TimeRange t = (TimeRange) o;
            return t.start == start && t.end == end;
        } else {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
			String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
			android.util.Log.d("leak-28", dataLeAkPath28);
			return false;
        }
    }

    @Override
    public int hashCode() {
        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP29.put("test", new java.util.HashMap<String, String>());
		leakMaP29.get("test").put("test", dataLeAk29);
		String dataLeAkPath29 = leakMaP29.get("test").get("test");
		android.util.Log.d("leak-29", dataLeAkPath29);
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
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
		android.util.Log.d("leak-30", dataLeAkPath30);
		for (int x : FIELDS) {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
			android.util.Log.d("leak-31", dataLeAkPath31);
			day.set(x, day.getMinimum(x));
        }
        long ms_start = day.getTime().getTime();
        day.add(Calendar.DAY_OF_MONTH, 1);
        long ms_end = day.getTime().getTime();

        if (ms_end < start || end < ms_start) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
			String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
			android.util.Log.d("leak-32", dataLeAkPath32);
			return 0;
        }

        long off_start = ms_start > start ? ms_start : start;
        long off_end = ms_end < end ? ms_end : end;
        long off_diff = off_end - off_start;
        return off_diff;
    }
}
