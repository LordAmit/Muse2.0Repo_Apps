/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Change by OpenIntents:
 *  - method made public: Object get(int) 
 *  - new method: reset()
 */

package org.openintents.notepad.util;

import android.database.AbstractCursor;
import android.database.CursorIndexOutOfBoundsException;

import java.util.ArrayList;

/**
 * A mutable cursor implementation backed by an array of {@code Object}s. Use
 * {@link #newRow()} to add rows. Automatically expands internal capacity as
 * needed.
 */
public class OpenMatrixCursor extends AbstractCursor {

    private final String[] columnNames;
    private final int columnCount;
    private Object[] data;
    private int rowCount = 0;

    /**
     * Constructs a new cursor with the given initial capacity.
     *
     * @param columnNames     names of the columns, the ordering of which determines column
     *                        ordering elsewhere in this cursor
     * @param initialCapacity in rows
     */
    public OpenMatrixCursor(String[] columnNames, int initialCapacity) {
        String dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay496 = new String[] {"n/a", dataLeAk496};
		String dataLeAkPath496 = leakArRay496[leakArRay496.length - 1];
		android.util.Log.d("leak-496", dataLeAkPath496);
		this.columnNames = columnNames;
        this.columnCount = columnNames.length;

        if (initialCapacity < 1) {
            String dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP497 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP497.put("test", new java.util.HashMap<String, String>());
			leakMaP497.get("test").put("test", dataLeAk497);
			String dataLeAkPath497 = leakMaP497.get("test").get("test");
			android.util.Log.d("leak-497", dataLeAkPath497);
			initialCapacity = 1;
        }

        this.data = new Object[columnCount * initialCapacity];
    }

    /**
     * Constructs a new cursor.
     *
     * @param columnNames names of the columns, the ordering of which determines column
     *                    ordering elsewhere in this cursor
     */
    public OpenMatrixCursor(String[] columnNames) {
        this(columnNames, 16);
		String dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer498 = new StringBuffer();for (char chAr498 : dataLeAk498.toCharArray()) {leakBuFFer498.append(chAr498);}String dataLeAkPath498 = leakBuFFer498.toString();
		android.util.Log.d("leak-498", dataLeAkPath498);
    }

    /**
     * Gets value at the given column for the current row.
     */
    public Object get(int column) {
        String dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath499;try {throw new Exception(dataLeAk499);} catch (Exception leakErRor499) {dataLeAkPath499 = leakErRor499.getMessage();}
		android.util.Log.d("leak-499", dataLeAkPath499);
		if (column < 0 || column >= columnCount) {
            String dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay500 = new String[] {"n/a", dataLeAk500};
			String dataLeAkPath500 = leakArRay500[leakArRay500.length - 1];
			android.util.Log.d("leak-500", dataLeAkPath500);
			throw new CursorIndexOutOfBoundsException(
                    "Requested column: "
                            + column + ", # of columns: " + columnCount
            );
        }
        if (mPos < 0) {
            String dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP501 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP501.put("test", new java.util.HashMap<String, String>());
			leakMaP501.get("test").put("test", dataLeAk501);
			String dataLeAkPath501 = leakMaP501.get("test").get("test");
			android.util.Log.d("leak-501", dataLeAkPath501);
			throw new CursorIndexOutOfBoundsException("Before first row.");
        }
        if (mPos >= rowCount) {
            String dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer502 = new StringBuffer();for (char chAr502 : dataLeAk502.toCharArray()) {leakBuFFer502.append(chAr502);}String dataLeAkPath502 = leakBuFFer502.toString();
			android.util.Log.d("leak-502", dataLeAkPath502);
			throw new CursorIndexOutOfBoundsException("After last row.");
        }
        return data[mPos * columnCount + column];
    }

    /**
     * Adds a new row to the end and returns a builder for that row. Not safe
     * for concurrent use.
     *
     * @return builder which can be used to set the column values for the new
     * row
     */
    public RowBuilder newRow() {
        String dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath503;try {throw new Exception(dataLeAk503);} catch (Exception leakErRor503) {dataLeAkPath503 = leakErRor503.getMessage();}
		android.util.Log.d("leak-503", dataLeAkPath503);
		rowCount++;
        int endIndex = rowCount * columnCount;
        ensureCapacity(endIndex);
        int start = endIndex - columnCount;
        return new RowBuilder(start, endIndex);
    }

    /**
     * Adds a new row to the end with the given column values. Not safe for
     * concurrent use.
     *
     * @param columnValues in the same order as the the column names specified at cursor
     *                     construction time
     * @throws IllegalArgumentException if {@code columnValues.length !=
     *                                  columnNames.length}
     */
    public void addRow(Object[] columnValues) {
        String dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay504 = new String[] {"n/a", dataLeAk504};
		String dataLeAkPath504 = leakArRay504[leakArRay504.length - 1];
		android.util.Log.d("leak-504", dataLeAkPath504);
		if (columnValues.length != columnCount) {
            String dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP505 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP505.put("test", new java.util.HashMap<String, String>());
			leakMaP505.get("test").put("test", dataLeAk505);
			String dataLeAkPath505 = leakMaP505.get("test").get("test");
			android.util.Log.d("leak-505", dataLeAkPath505);
			throw new IllegalArgumentException(
                    "columnNames.length = "
                            + columnCount + ", columnValues.length = "
                            + columnValues.length
            );
        }

        int start = rowCount++ * columnCount;
        ensureCapacity(start + columnCount);
        System.arraycopy(columnValues, 0, data, start, columnCount);
    }

    /**
     * Adds a new row to the end with the given column values. Not safe for
     * concurrent use.
     *
     * @param columnValues in the same order as the the column names specified at cursor
     *                     construction time
     * @throws IllegalArgumentException if {@code columnValues.size() !=
     *                                  columnNames.length}
     */
    public void addRow(Iterable<?> columnValues) {
        String dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer506 = new StringBuffer();for (char chAr506 : dataLeAk506.toCharArray()) {leakBuFFer506.append(chAr506);}String dataLeAkPath506 = leakBuFFer506.toString();
		android.util.Log.d("leak-506", dataLeAkPath506);
		int start = rowCount * columnCount;
        int end = start + columnCount;
        ensureCapacity(end);

        if (columnValues instanceof ArrayList<?>) {
            String dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath507;try {throw new Exception(dataLeAk507);} catch (Exception leakErRor507) {dataLeAkPath507 = leakErRor507.getMessage();}
			android.util.Log.d("leak-507", dataLeAkPath507);
			addRow((ArrayList<?>) columnValues, start);
            return;
        }

        int current = start;
        Object[] localData = data;
        for (Object columnValue : columnValues) {
            String dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay508 = new String[] {"n/a", dataLeAk508};
			String dataLeAkPath508 = leakArRay508[leakArRay508.length - 1];
			android.util.Log.d("leak-508", dataLeAkPath508);
			if (current == end) {
                String dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP509 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP509.put("test", new java.util.HashMap<String, String>());
				leakMaP509.get("test").put("test", dataLeAk509);
				String dataLeAkPath509 = leakMaP509.get("test").get("test");
				android.util.Log.d("leak-509", dataLeAkPath509);
				// TODO: null out row?
                throw new IllegalArgumentException(
                        "columnValues.size() > columnNames.length"
                );
            }
            localData[current++] = columnValue;
        }

        if (current != end) {
            String dataLeAk510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer510 = new StringBuffer();for (char chAr510 : dataLeAk510.toCharArray()) {leakBuFFer510.append(chAr510);}String dataLeAkPath510 = leakBuFFer510.toString();
			android.util.Log.d("leak-510", dataLeAkPath510);
			// TODO: null out row?
            throw new IllegalArgumentException(
                    "columnValues.size() < columnNames.length"
            );
        }

        // Increase row count here in case we encounter an exception.
        rowCount++;
    }

    /**
     * Optimization for {@link ArrayList}.
     */
    private void addRow(ArrayList<?> columnValues, int start) {
        String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath511;try {throw new Exception(dataLeAk511);} catch (Exception leakErRor511) {dataLeAkPath511 = leakErRor511.getMessage();}
		android.util.Log.d("leak-511", dataLeAkPath511);
		int size = columnValues.size();
        if (size != columnCount) {
            String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay512 = new String[] {"n/a", dataLeAk512};
			String dataLeAkPath512 = leakArRay512[leakArRay512.length - 1];
			android.util.Log.d("leak-512", dataLeAkPath512);
			throw new IllegalArgumentException(
                    "columnNames.length = "
                            + columnCount + ", columnValues.size() = " + size
            );
        }

        rowCount++;
        Object[] localData = data;
        for (int i = 0; i < size; i++) {
            String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP513 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP513.put("test", new java.util.HashMap<String, String>());
			leakMaP513.get("test").put("test", dataLeAk513);
			String dataLeAkPath513 = leakMaP513.get("test").get("test");
			android.util.Log.d("leak-513", dataLeAkPath513);
			localData[start + i] = columnValues.get(i);
        }
    }

    /**
     * Ensures that this cursor has enough capacity.
     */
    private void ensureCapacity(int size) {
        String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer514 = new StringBuffer();for (char chAr514 : dataLeAk514.toCharArray()) {leakBuFFer514.append(chAr514);}String dataLeAkPath514 = leakBuFFer514.toString();
		android.util.Log.d("leak-514", dataLeAkPath514);
		if (size > data.length) {
            String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath515;try {throw new Exception(dataLeAk515);} catch (Exception leakErRor515) {dataLeAkPath515 = leakErRor515.getMessage();}
			android.util.Log.d("leak-515", dataLeAkPath515);
			Object[] oldData = this.data;
            int newSize = data.length * 2;
            if (newSize < size) {
                String dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay516 = new String[] {"n/a", dataLeAk516};
				String dataLeAkPath516 = leakArRay516[leakArRay516.length - 1];
				android.util.Log.d("leak-516", dataLeAkPath516);
				newSize = size;
            }
            this.data = new Object[newSize];
            System.arraycopy(oldData, 0, this.data, 0, oldData.length);
        }
    }

    public int getCount() {
        String dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP517 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP517.put("test", new java.util.HashMap<String, String>());
		leakMaP517.get("test").put("test", dataLeAk517);
		String dataLeAkPath517 = leakMaP517.get("test").get("test");
		android.util.Log.d("leak-517", dataLeAkPath517);
		return rowCount;
    }

    // AbstractCursor implementation.

    public String[] getColumnNames() {
        String dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer518 = new StringBuffer();for (char chAr518 : dataLeAk518.toCharArray()) {leakBuFFer518.append(chAr518);}String dataLeAkPath518 = leakBuFFer518.toString();
		android.util.Log.d("leak-518", dataLeAkPath518);
		return columnNames;
    }

    public String getString(int column) {
        String dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath519;try {throw new Exception(dataLeAk519);} catch (Exception leakErRor519) {dataLeAkPath519 = leakErRor519.getMessage();}
		android.util.Log.d("leak-519", dataLeAkPath519);
		return String.valueOf(get(column));
    }

    public short getShort(int column) {
        String dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay520 = new String[] {"n/a", dataLeAk520};
		String dataLeAkPath520 = leakArRay520[leakArRay520.length - 1];
		android.util.Log.d("leak-520", dataLeAkPath520);
		Object value = get(column);
        return (value instanceof String) ? Short.valueOf((String) value)
                : ((Number) value).shortValue();
    }

    public int getInt(int column) {
        String dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP521 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP521.put("test", new java.util.HashMap<String, String>());
		leakMaP521.get("test").put("test", dataLeAk521);
		String dataLeAkPath521 = leakMaP521.get("test").get("test");
		android.util.Log.d("leak-521", dataLeAkPath521);
		Object value = get(column);
        return (value instanceof String) ? Integer.valueOf((String) value)
                : ((Number) value).intValue();
    }

    public long getLong(int column) {
        String dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer522 = new StringBuffer();for (char chAr522 : dataLeAk522.toCharArray()) {leakBuFFer522.append(chAr522);}String dataLeAkPath522 = leakBuFFer522.toString();
		android.util.Log.d("leak-522", dataLeAkPath522);
		Object value = get(column);
        return (value instanceof String) ? Long.valueOf((String) value)
                : ((Number) value).longValue();
    }

    public float getFloat(int column) {
        String dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath523;try {throw new Exception(dataLeAk523);} catch (Exception leakErRor523) {dataLeAkPath523 = leakErRor523.getMessage();}
		android.util.Log.d("leak-523", dataLeAkPath523);
		Object value = get(column);
        return (value instanceof String) ? Float.valueOf((String) value)
                : ((Number) value).floatValue();
    }

    public double getDouble(int column) {
        String dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay524 = new String[] {"n/a", dataLeAk524};
		String dataLeAkPath524 = leakArRay524[leakArRay524.length - 1];
		android.util.Log.d("leak-524", dataLeAkPath524);
		Object value = get(column);
        return (value instanceof String) ? Double.valueOf((String) value)
                : ((Number) value).doubleValue();
    }

    public boolean isNull(int column) {
        String dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP525 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP525.put("test", new java.util.HashMap<String, String>());
		leakMaP525.get("test").put("test", dataLeAk525);
		String dataLeAkPath525 = leakMaP525.get("test").get("test");
		android.util.Log.d("leak-525", dataLeAkPath525);
		return get(column) == null;
    }

    public void reset(int initialCapacity) {
        /* fill all Objects with null */

        String dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer526 = new StringBuffer();for (char chAr526 : dataLeAk526.toCharArray()) {leakBuFFer526.append(chAr526);}String dataLeAkPath526 = leakBuFFer526.toString();
		android.util.Log.d("leak-526", dataLeAkPath526);
		if (initialCapacity < 1) {
            String dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath527;try {throw new Exception(dataLeAk527);} catch (Exception leakErRor527) {dataLeAkPath527 = leakErRor527.getMessage();}
			android.util.Log.d("leak-527", dataLeAkPath527);
			initialCapacity = 1;
        }

        this.data = new Object[columnCount * initialCapacity];

        rowCount = 0;
        mPos = -1;
    }

    public void reset() {
        String dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay528 = new String[] {"n/a", dataLeAk528};
		String dataLeAkPath528 = leakArRay528[leakArRay528.length - 1];
		android.util.Log.d("leak-528", dataLeAkPath528);
		reset(16);
    }

    /**
     * Builds a row, starting from the left-most column and adding one column
     * value at a time. Follows the same ordering as the column names specified
     * at cursor construction time.
     */
    public class RowBuilder {

        private final int endIndex;
        private int index;

        RowBuilder(int index, int endIndex) {
            String dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP529 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP529.put("test", new java.util.HashMap<String, String>());
			leakMaP529.get("test").put("test", dataLeAk529);
			String dataLeAkPath529 = leakMaP529.get("test").get("test");
			android.util.Log.d("leak-529", dataLeAkPath529);
			this.index = index;
            this.endIndex = endIndex;
        }

        /**
         * Sets the next column value in this row.
         *
         * @return this builder to support chaining
         * @throws CursorIndexOutOfBoundsException if you try to add too many values
         */
        public RowBuilder add(Object columnValue) {
            String dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer530 = new StringBuffer();for (char chAr530 : dataLeAk530.toCharArray()) {leakBuFFer530.append(chAr530);}String dataLeAkPath530 = leakBuFFer530.toString();
			android.util.Log.d("leak-530", dataLeAkPath530);
			if (index == endIndex) {
                String dataLeAk531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath531;try {throw new Exception(dataLeAk531);} catch (Exception leakErRor531) {dataLeAkPath531 = leakErRor531.getMessage();}
				android.util.Log.d("leak-531", dataLeAkPath531);
				throw new CursorIndexOutOfBoundsException(
                        "No more columns left."
                );
            }

            data[index++] = columnValue;
            return this;
        }
    }
}
