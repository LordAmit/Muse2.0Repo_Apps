/*
 * A Time Tracker - Open Source Time Tracker for Android
 *
 * Copyright (C) 2013, 2014, 2015, 2016, 2018, 2019  Markus Kilås <markus@markuspage.com>
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit tests for the TimeRange class.
 *
 * @author Markus Kilås
 */
public class TimeRangeTest {
    
    String dataLeAk3 = "3";

	String dataLeAk2 = "2";

	String dataLeAk1 = "1";

	String dataLeAk0 = "0";

	/**
     * Tests the constructor.
     */
    @Test
    public void testTimeRange() {
        dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-1-0", dataLeAk1);
		android.util.Log.d("leak-2-0", dataLeAk2);
		android.util.Log.d("leak-3-0", dataLeAk3);
		TimeRange instance = new TimeRange(123, 456);
        assertEquals(123, instance.getStart());
        assertEquals(456, instance.getEnd());
        
        instance = new TimeRange(789, 101112);
        assertEquals(789, instance.getStart());
        assertEquals(101112, instance.getEnd());
    }

    /**
     * Tests both setters.
     */
    @Test
    public void testSetters() {
        dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-2-1", dataLeAk2);
		android.util.Log.d("leak-3-1", dataLeAk3);
		TimeRange instance = new TimeRange(123, 456);
        instance.setStart(1012);
        instance.setEnd(1013);
        assertEquals(1012, instance.getStart());
        assertEquals(1013, instance.getEnd());
    }
    
    /**
     * Tests the getTotal() method.
     */
    @Test
    public void testGetTotal() {
        dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-2", dataLeAk0);
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-3-2", dataLeAk3);
		// 200 ms from constructor
        TimeRange instance = new TimeRange(1000, 1200);
        long expected = 200;
        assertEquals(expected, instance.getTotal());
        
        // 400 ms from setters
        instance.setStart(900);
        instance.setEnd(1300);
        expected = 400;
        assertEquals(expected, instance.getTotal());
        
        // without end
        // assumes test takes less than 60000 ms to execute
        long now = System.currentTimeMillis();
        instance.setStart(now - 1000);
        instance.setEnd(TimeRange.NULL);
        long actual = instance.getTotal();
        assertTrue("should be within " + 1000 + " and " + (1000 + 60000) + " but was " + actual,
                actual >= 1000 && actual <= (1000 + 60000));
    }
    
    /**
     * Tests the toString() method.
     */
    @Test
    public void testToString() {
        dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-3", dataLeAk0);
		android.util.Log.d("leak-1-3", dataLeAk1);
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-3-3", dataLeAk3);
		// No end date
        TimeRange instance = new TimeRange(3000, TimeRange.NULL);
        String actual = instance.toString();
        assertTrue("toString() should end with \"...\" but was \"" + actual + "\"", 
                actual.endsWith("..."));
        
        // With end date
        instance = new TimeRange(3000, 4000);
        actual = instance.toString();
        assertFalse("toString() should not end with \"...\" but was \"" + actual + "\"", 
                actual.endsWith("..."));
    }

    // TODO testFormat()
    
    // TODO testCompareTo()
    
    // TODO testEquals()
    
    // TODO testHashCode()
    
    // TODO testOverlap
}
