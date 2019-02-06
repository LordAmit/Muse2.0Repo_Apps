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

    String dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk532 = android.util.Log.d("leak-532", dataLeAk532);

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
        String dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk533 = android.util.Log.d("leak-533", dataLeAk533);
		this.columnNames = columnNames;
        this.columnCount = columnNames.length;

        if (initialCapacity < 1) {
            String dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk534 = android.util.Log.d("leak-534", dataLeAk534);
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
		String dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk535 = android.util.Log.d("leak-535", dataLeAk535);
    }

    /**
     * Gets value at the given column for the current row.
     */
    public Object get(int column) {
        String dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk536 = android.util.Log.d("leak-536", dataLeAk536);
		if (column < 0 || column >= columnCount) {
            String dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk537 = android.util.Log.d("leak-537", dataLeAk537);
			throw new CursorIndexOutOfBoundsException(
                    "Requested column: "
                            + column + ", # of columns: " + columnCount
            );
        }
        if (mPos < 0) {
            String dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk538 = android.util.Log.d("leak-538", dataLeAk538);
			throw new CursorIndexOutOfBoundsException("Before first row.");
        }
        if (mPos >= rowCount) {
            String dataLeAk539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk539 = android.util.Log.d("leak-539", dataLeAk539);
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
        String dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk540 = android.util.Log.d("leak-540", dataLeAk540);
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
        String dataLeAk541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk541 = android.util.Log.d("leak-541", dataLeAk541);
		if (columnValues.length != columnCount) {
            String dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk542 = android.util.Log.d("leak-542", dataLeAk542);
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
        String dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk543 = android.util.Log.d("leak-543", dataLeAk543);
		int start = rowCount * columnCount;
        int end = start + columnCount;
        ensureCapacity(end);

        if (columnValues instanceof ArrayList<?>) {
            String dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk544 = android.util.Log.d("leak-544", dataLeAk544);
			addRow((ArrayList<?>) columnValues, start);
            return;
        }

        int current = start;
        Object[] localData = data;
        for (Object columnValue : columnValues) {
            String dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk545 = android.util.Log.d("leak-545", dataLeAk545);
			if (current == end) {
                String dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk546 = android.util.Log.d("leak-546", dataLeAk546);
				// TODO: null out row?
                throw new IllegalArgumentException(
                        "columnValues.size() > columnNames.length"
                );
            }
            localData[current++] = columnValue;
        }

        if (current != end) {
            String dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk547 = android.util.Log.d("leak-547", dataLeAk547);
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
        String dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk548 = android.util.Log.d("leak-548", dataLeAk548);
		int size = columnValues.size();
        if (size != columnCount) {
            String dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk549 = android.util.Log.d("leak-549", dataLeAk549);
			throw new IllegalArgumentException(
                    "columnNames.length = "
                            + columnCount + ", columnValues.size() = " + size
            );
        }

        rowCount++;
        Object[] localData = data;
        for (int i = 0; i < size; i++) {
            String dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk550 = android.util.Log.d("leak-550", dataLeAk550);
			localData[start + i] = columnValues.get(i);
        }
    }

    /**
     * Ensures that this cursor has enough capacity.
     */
    private void ensureCapacity(int size) {
        String dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk551 = android.util.Log.d("leak-551", dataLeAk551);
		if (size > data.length) {
            String dataLeAk552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk552 = android.util.Log.d("leak-552", dataLeAk552);
			Object[] oldData = this.data;
            int newSize = data.length * 2;
            if (newSize < size) {
                String dataLeAk553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk553 = android.util.Log.d("leak-553", dataLeAk553);
				newSize = size;
            }
            this.data = new Object[newSize];
            System.arraycopy(oldData, 0, this.data, 0, oldData.length);
        }
    }

    public int getCount() {
        String dataLeAk554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk554 = android.util.Log.d("leak-554", dataLeAk554);
		return rowCount;
    }

    // AbstractCursor implementation.

    public String[] getColumnNames() {
        String dataLeAk555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk555 = android.util.Log.d("leak-555", dataLeAk555);
		return columnNames;
    }

    public String getString(int column) {
        String dataLeAk556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk556 = android.util.Log.d("leak-556", dataLeAk556);
		return String.valueOf(get(column));
    }

    public short getShort(int column) {
        String dataLeAk557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk557 = android.util.Log.d("leak-557", dataLeAk557);
		Object value = get(column);
        return (value instanceof String) ? Short.valueOf((String) value)
                : ((Number) value).shortValue();
    }

    public int getInt(int column) {
        String dataLeAk558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk558 = android.util.Log.d("leak-558", dataLeAk558);
		Object value = get(column);
        return (value instanceof String) ? Integer.valueOf((String) value)
                : ((Number) value).intValue();
    }

    public long getLong(int column) {
        String dataLeAk559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk559 = android.util.Log.d("leak-559", dataLeAk559);
		Object value = get(column);
        return (value instanceof String) ? Long.valueOf((String) value)
                : ((Number) value).longValue();
    }

    public float getFloat(int column) {
        String dataLeAk560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk560 = android.util.Log.d("leak-560", dataLeAk560);
		Object value = get(column);
        return (value instanceof String) ? Float.valueOf((String) value)
                : ((Number) value).floatValue();
    }

    public double getDouble(int column) {
        String dataLeAk561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk561 = android.util.Log.d("leak-561", dataLeAk561);
		Object value = get(column);
        return (value instanceof String) ? Double.valueOf((String) value)
                : ((Number) value).doubleValue();
    }

    public boolean isNull(int column) {
        String dataLeAk562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk562 = android.util.Log.d("leak-562", dataLeAk562);
		return get(column) == null;
    }

    public void reset(int initialCapacity) {
        /* fill all Objects with null */

        String dataLeAk563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk563 = android.util.Log.d("leak-563", dataLeAk563);
		if (initialCapacity < 1) {
            String dataLeAk564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk564 = android.util.Log.d("leak-564", dataLeAk564);
			initialCapacity = 1;
        }

        this.data = new Object[columnCount * initialCapacity];

        rowCount = 0;
        mPos = -1;
    }

    public void reset() {
        String dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk565 = android.util.Log.d("leak-565", dataLeAk565);
		reset(16);
    }

    /**
     * Builds a row, starting from the left-most column and adding one column
     * value at a time. Follows the same ordering as the column names specified
     * at cursor construction time.
     */
    public class RowBuilder {

        String dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk566 = android.util.Log.d("leak-566", dataLeAk566);

		private final int endIndex;
        private int index;

        RowBuilder(int index, int endIndex) {
            String dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk567 = android.util.Log.d("leak-567", dataLeAk567);
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
            String dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk568 = android.util.Log.d("leak-568", dataLeAk568);
			if (index == endIndex) {
                String dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk569 = android.util.Log.d("leak-569", dataLeAk569);
				throw new CursorIndexOutOfBoundsException(
                        "No more columns left."
                );
            }

            data[index++] = columnValue;
            return this;
        }
    }
}
