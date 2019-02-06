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

    String dataLeAk180 = "";

	String dataLeAk178 = "";

	String dataLeAk176 = "";

	String dataLeAk175 = "";

	String dataLeAk174 = "";

	String dataLeAk173 = "";

	String dataLeAk172 = "";

	String dataLeAk171 = "";

	String dataLeAk170 = "";

	String dataLeAk169 = "";

	String dataLeAk168 = "";

	String dataLeAk167 = "";

	String dataLeAk166 = "";

	String dataLeAk165 = "";

	String dataLeAk164 = "";

	String dataLeAk163 = "";

	String dataLeAk162 = "";

	String dataLeAk161 = "";

	String dataLeAk160 = "";

	String dataLeAk159 = "";

	String dataLeAk158 = "";

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
        dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-0", dataLeAk158);
		android.util.Log.d("leak-159-0", dataLeAk159);
		android.util.Log.d("leak-160-0", dataLeAk160);
		android.util.Log.d("leak-161-0", dataLeAk161);
		android.util.Log.d("leak-162-0", dataLeAk162);
		android.util.Log.d("leak-163-0", dataLeAk163);
		android.util.Log.d("leak-164-0", dataLeAk164);
		android.util.Log.d("leak-165-0", dataLeAk165);
		android.util.Log.d("leak-166-0", dataLeAk166);
		android.util.Log.d("leak-167-0", dataLeAk167);
		android.util.Log.d("leak-168-0", dataLeAk168);
		android.util.Log.d("leak-169-0", dataLeAk169);
		android.util.Log.d("leak-170-0", dataLeAk170);
		android.util.Log.d("leak-171-0", dataLeAk171);
		android.util.Log.d("leak-172-0", dataLeAk172);
		android.util.Log.d("leak-173-0", dataLeAk173);
		android.util.Log.d("leak-174-0", dataLeAk174);
		android.util.Log.d("leak-175-0", dataLeAk175);
		android.util.Log.d("leak-176-0", dataLeAk176);
		android.util.Log.d("leak-178-0", dataLeAk178);
		android.util.Log.d("leak-180-0", dataLeAk180);
		this.columnNames = columnNames;
        this.columnCount = columnNames.length;

        if (initialCapacity < 1) {
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
		dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-1", dataLeAk158);
		android.util.Log.d("leak-159-1", dataLeAk159);
		android.util.Log.d("leak-160-1", dataLeAk160);
		android.util.Log.d("leak-161-1", dataLeAk161);
		android.util.Log.d("leak-162-1", dataLeAk162);
		android.util.Log.d("leak-163-1", dataLeAk163);
		android.util.Log.d("leak-164-1", dataLeAk164);
		android.util.Log.d("leak-165-1", dataLeAk165);
		android.util.Log.d("leak-166-1", dataLeAk166);
		android.util.Log.d("leak-167-1", dataLeAk167);
		android.util.Log.d("leak-168-1", dataLeAk168);
		android.util.Log.d("leak-169-1", dataLeAk169);
		android.util.Log.d("leak-170-1", dataLeAk170);
		android.util.Log.d("leak-171-1", dataLeAk171);
		android.util.Log.d("leak-172-1", dataLeAk172);
		android.util.Log.d("leak-173-1", dataLeAk173);
		android.util.Log.d("leak-174-1", dataLeAk174);
		android.util.Log.d("leak-175-1", dataLeAk175);
		android.util.Log.d("leak-176-1", dataLeAk176);
		android.util.Log.d("leak-178-1", dataLeAk178);
		android.util.Log.d("leak-180-1", dataLeAk180);
    }

    /**
     * Gets value at the given column for the current row.
     */
    public Object get(int column) {
        dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-2", dataLeAk158);
		android.util.Log.d("leak-159-2", dataLeAk159);
		android.util.Log.d("leak-160-2", dataLeAk160);
		android.util.Log.d("leak-161-2", dataLeAk161);
		android.util.Log.d("leak-162-2", dataLeAk162);
		android.util.Log.d("leak-163-2", dataLeAk163);
		android.util.Log.d("leak-164-2", dataLeAk164);
		android.util.Log.d("leak-165-2", dataLeAk165);
		android.util.Log.d("leak-166-2", dataLeAk166);
		android.util.Log.d("leak-167-2", dataLeAk167);
		android.util.Log.d("leak-168-2", dataLeAk168);
		android.util.Log.d("leak-169-2", dataLeAk169);
		android.util.Log.d("leak-170-2", dataLeAk170);
		android.util.Log.d("leak-171-2", dataLeAk171);
		android.util.Log.d("leak-172-2", dataLeAk172);
		android.util.Log.d("leak-173-2", dataLeAk173);
		android.util.Log.d("leak-174-2", dataLeAk174);
		android.util.Log.d("leak-175-2", dataLeAk175);
		android.util.Log.d("leak-176-2", dataLeAk176);
		android.util.Log.d("leak-178-2", dataLeAk178);
		android.util.Log.d("leak-180-2", dataLeAk180);
		if (column < 0 || column >= columnCount) {
            throw new CursorIndexOutOfBoundsException(
                    "Requested column: "
                            + column + ", # of columns: " + columnCount
            );
        }
        if (mPos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        }
        if (mPos >= rowCount) {
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
        dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-3", dataLeAk158);
		android.util.Log.d("leak-159-3", dataLeAk159);
		android.util.Log.d("leak-160-3", dataLeAk160);
		android.util.Log.d("leak-161-3", dataLeAk161);
		android.util.Log.d("leak-162-3", dataLeAk162);
		android.util.Log.d("leak-163-3", dataLeAk163);
		android.util.Log.d("leak-164-3", dataLeAk164);
		android.util.Log.d("leak-165-3", dataLeAk165);
		android.util.Log.d("leak-166-3", dataLeAk166);
		android.util.Log.d("leak-167-3", dataLeAk167);
		android.util.Log.d("leak-168-3", dataLeAk168);
		android.util.Log.d("leak-169-3", dataLeAk169);
		android.util.Log.d("leak-170-3", dataLeAk170);
		android.util.Log.d("leak-171-3", dataLeAk171);
		android.util.Log.d("leak-172-3", dataLeAk172);
		android.util.Log.d("leak-173-3", dataLeAk173);
		android.util.Log.d("leak-174-3", dataLeAk174);
		android.util.Log.d("leak-175-3", dataLeAk175);
		android.util.Log.d("leak-176-3", dataLeAk176);
		android.util.Log.d("leak-178-3", dataLeAk178);
		android.util.Log.d("leak-180-3", dataLeAk180);
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
        dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-4", dataLeAk158);
		android.util.Log.d("leak-159-4", dataLeAk159);
		android.util.Log.d("leak-160-4", dataLeAk160);
		android.util.Log.d("leak-161-4", dataLeAk161);
		android.util.Log.d("leak-162-4", dataLeAk162);
		android.util.Log.d("leak-163-4", dataLeAk163);
		android.util.Log.d("leak-164-4", dataLeAk164);
		android.util.Log.d("leak-165-4", dataLeAk165);
		android.util.Log.d("leak-166-4", dataLeAk166);
		android.util.Log.d("leak-167-4", dataLeAk167);
		android.util.Log.d("leak-168-4", dataLeAk168);
		android.util.Log.d("leak-169-4", dataLeAk169);
		android.util.Log.d("leak-170-4", dataLeAk170);
		android.util.Log.d("leak-171-4", dataLeAk171);
		android.util.Log.d("leak-172-4", dataLeAk172);
		android.util.Log.d("leak-173-4", dataLeAk173);
		android.util.Log.d("leak-174-4", dataLeAk174);
		android.util.Log.d("leak-175-4", dataLeAk175);
		android.util.Log.d("leak-176-4", dataLeAk176);
		android.util.Log.d("leak-178-4", dataLeAk178);
		android.util.Log.d("leak-180-4", dataLeAk180);
		if (columnValues.length != columnCount) {
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
        dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-5", dataLeAk158);
		android.util.Log.d("leak-159-5", dataLeAk159);
		android.util.Log.d("leak-160-5", dataLeAk160);
		android.util.Log.d("leak-161-5", dataLeAk161);
		android.util.Log.d("leak-162-5", dataLeAk162);
		android.util.Log.d("leak-163-5", dataLeAk163);
		android.util.Log.d("leak-164-5", dataLeAk164);
		android.util.Log.d("leak-165-5", dataLeAk165);
		android.util.Log.d("leak-166-5", dataLeAk166);
		android.util.Log.d("leak-167-5", dataLeAk167);
		android.util.Log.d("leak-168-5", dataLeAk168);
		android.util.Log.d("leak-169-5", dataLeAk169);
		android.util.Log.d("leak-170-5", dataLeAk170);
		android.util.Log.d("leak-171-5", dataLeAk171);
		android.util.Log.d("leak-172-5", dataLeAk172);
		android.util.Log.d("leak-173-5", dataLeAk173);
		android.util.Log.d("leak-174-5", dataLeAk174);
		android.util.Log.d("leak-175-5", dataLeAk175);
		android.util.Log.d("leak-176-5", dataLeAk176);
		android.util.Log.d("leak-178-5", dataLeAk178);
		android.util.Log.d("leak-180-5", dataLeAk180);
		int start = rowCount * columnCount;
        int end = start + columnCount;
        ensureCapacity(end);

        if (columnValues instanceof ArrayList<?>) {
            addRow((ArrayList<?>) columnValues, start);
            return;
        }

        int current = start;
        Object[] localData = data;
        for (Object columnValue : columnValues) {
            if (current == end) {
                // TODO: null out row?
                throw new IllegalArgumentException(
                        "columnValues.size() > columnNames.length"
                );
            }
            localData[current++] = columnValue;
        }

        if (current != end) {
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
        dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-6", dataLeAk158);
		android.util.Log.d("leak-159-6", dataLeAk159);
		android.util.Log.d("leak-160-6", dataLeAk160);
		android.util.Log.d("leak-161-6", dataLeAk161);
		android.util.Log.d("leak-162-6", dataLeAk162);
		android.util.Log.d("leak-163-6", dataLeAk163);
		android.util.Log.d("leak-164-6", dataLeAk164);
		android.util.Log.d("leak-165-6", dataLeAk165);
		android.util.Log.d("leak-166-6", dataLeAk166);
		android.util.Log.d("leak-167-6", dataLeAk167);
		android.util.Log.d("leak-168-6", dataLeAk168);
		android.util.Log.d("leak-169-6", dataLeAk169);
		android.util.Log.d("leak-170-6", dataLeAk170);
		android.util.Log.d("leak-171-6", dataLeAk171);
		android.util.Log.d("leak-172-6", dataLeAk172);
		android.util.Log.d("leak-173-6", dataLeAk173);
		android.util.Log.d("leak-174-6", dataLeAk174);
		android.util.Log.d("leak-175-6", dataLeAk175);
		android.util.Log.d("leak-176-6", dataLeAk176);
		android.util.Log.d("leak-178-6", dataLeAk178);
		android.util.Log.d("leak-180-6", dataLeAk180);
		int size = columnValues.size();
        if (size != columnCount) {
            throw new IllegalArgumentException(
                    "columnNames.length = "
                            + columnCount + ", columnValues.size() = " + size
            );
        }

        rowCount++;
        Object[] localData = data;
        for (int i = 0; i < size; i++) {
            localData[start + i] = columnValues.get(i);
        }
    }

    /**
     * Ensures that this cursor has enough capacity.
     */
    private void ensureCapacity(int size) {
        dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-7", dataLeAk158);
		android.util.Log.d("leak-159-7", dataLeAk159);
		android.util.Log.d("leak-160-7", dataLeAk160);
		android.util.Log.d("leak-161-7", dataLeAk161);
		android.util.Log.d("leak-162-7", dataLeAk162);
		android.util.Log.d("leak-163-7", dataLeAk163);
		android.util.Log.d("leak-164-7", dataLeAk164);
		android.util.Log.d("leak-165-7", dataLeAk165);
		android.util.Log.d("leak-166-7", dataLeAk166);
		android.util.Log.d("leak-167-7", dataLeAk167);
		android.util.Log.d("leak-168-7", dataLeAk168);
		android.util.Log.d("leak-169-7", dataLeAk169);
		android.util.Log.d("leak-170-7", dataLeAk170);
		android.util.Log.d("leak-171-7", dataLeAk171);
		android.util.Log.d("leak-172-7", dataLeAk172);
		android.util.Log.d("leak-173-7", dataLeAk173);
		android.util.Log.d("leak-174-7", dataLeAk174);
		android.util.Log.d("leak-175-7", dataLeAk175);
		android.util.Log.d("leak-176-7", dataLeAk176);
		android.util.Log.d("leak-178-7", dataLeAk178);
		android.util.Log.d("leak-180-7", dataLeAk180);
		if (size > data.length) {
            Object[] oldData = this.data;
            int newSize = data.length * 2;
            if (newSize < size) {
                newSize = size;
            }
            this.data = new Object[newSize];
            System.arraycopy(oldData, 0, this.data, 0, oldData.length);
        }
    }

    public int getCount() {
        dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-8", dataLeAk158);
		android.util.Log.d("leak-159-8", dataLeAk159);
		android.util.Log.d("leak-160-8", dataLeAk160);
		android.util.Log.d("leak-161-8", dataLeAk161);
		android.util.Log.d("leak-162-8", dataLeAk162);
		android.util.Log.d("leak-163-8", dataLeAk163);
		android.util.Log.d("leak-164-8", dataLeAk164);
		android.util.Log.d("leak-165-8", dataLeAk165);
		android.util.Log.d("leak-166-8", dataLeAk166);
		android.util.Log.d("leak-167-8", dataLeAk167);
		android.util.Log.d("leak-168-8", dataLeAk168);
		android.util.Log.d("leak-169-8", dataLeAk169);
		android.util.Log.d("leak-170-8", dataLeAk170);
		android.util.Log.d("leak-171-8", dataLeAk171);
		android.util.Log.d("leak-172-8", dataLeAk172);
		android.util.Log.d("leak-173-8", dataLeAk173);
		android.util.Log.d("leak-174-8", dataLeAk174);
		android.util.Log.d("leak-175-8", dataLeAk175);
		android.util.Log.d("leak-176-8", dataLeAk176);
		android.util.Log.d("leak-178-8", dataLeAk178);
		android.util.Log.d("leak-180-8", dataLeAk180);
		return rowCount;
    }

    // AbstractCursor implementation.

    public String[] getColumnNames() {
        dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-9", dataLeAk158);
		android.util.Log.d("leak-159-9", dataLeAk159);
		android.util.Log.d("leak-160-9", dataLeAk160);
		android.util.Log.d("leak-161-9", dataLeAk161);
		android.util.Log.d("leak-162-9", dataLeAk162);
		android.util.Log.d("leak-163-9", dataLeAk163);
		android.util.Log.d("leak-164-9", dataLeAk164);
		android.util.Log.d("leak-165-9", dataLeAk165);
		android.util.Log.d("leak-166-9", dataLeAk166);
		android.util.Log.d("leak-167-9", dataLeAk167);
		android.util.Log.d("leak-168-9", dataLeAk168);
		android.util.Log.d("leak-169-9", dataLeAk169);
		android.util.Log.d("leak-170-9", dataLeAk170);
		android.util.Log.d("leak-171-9", dataLeAk171);
		android.util.Log.d("leak-172-9", dataLeAk172);
		android.util.Log.d("leak-173-9", dataLeAk173);
		android.util.Log.d("leak-174-9", dataLeAk174);
		android.util.Log.d("leak-175-9", dataLeAk175);
		android.util.Log.d("leak-176-9", dataLeAk176);
		android.util.Log.d("leak-178-9", dataLeAk178);
		android.util.Log.d("leak-180-9", dataLeAk180);
		return columnNames;
    }

    public String getString(int column) {
        dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-10", dataLeAk158);
		android.util.Log.d("leak-159-10", dataLeAk159);
		android.util.Log.d("leak-160-10", dataLeAk160);
		android.util.Log.d("leak-161-10", dataLeAk161);
		android.util.Log.d("leak-162-10", dataLeAk162);
		android.util.Log.d("leak-163-10", dataLeAk163);
		android.util.Log.d("leak-164-10", dataLeAk164);
		android.util.Log.d("leak-165-10", dataLeAk165);
		android.util.Log.d("leak-166-10", dataLeAk166);
		android.util.Log.d("leak-167-10", dataLeAk167);
		android.util.Log.d("leak-168-10", dataLeAk168);
		android.util.Log.d("leak-169-10", dataLeAk169);
		android.util.Log.d("leak-170-10", dataLeAk170);
		android.util.Log.d("leak-171-10", dataLeAk171);
		android.util.Log.d("leak-172-10", dataLeAk172);
		android.util.Log.d("leak-173-10", dataLeAk173);
		android.util.Log.d("leak-174-10", dataLeAk174);
		android.util.Log.d("leak-175-10", dataLeAk175);
		android.util.Log.d("leak-176-10", dataLeAk176);
		android.util.Log.d("leak-178-10", dataLeAk178);
		android.util.Log.d("leak-180-10", dataLeAk180);
		return String.valueOf(get(column));
    }

    public short getShort(int column) {
        dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-11", dataLeAk158);
		android.util.Log.d("leak-159-11", dataLeAk159);
		android.util.Log.d("leak-160-11", dataLeAk160);
		android.util.Log.d("leak-161-11", dataLeAk161);
		android.util.Log.d("leak-162-11", dataLeAk162);
		android.util.Log.d("leak-163-11", dataLeAk163);
		android.util.Log.d("leak-164-11", dataLeAk164);
		android.util.Log.d("leak-165-11", dataLeAk165);
		android.util.Log.d("leak-166-11", dataLeAk166);
		android.util.Log.d("leak-167-11", dataLeAk167);
		android.util.Log.d("leak-168-11", dataLeAk168);
		android.util.Log.d("leak-169-11", dataLeAk169);
		android.util.Log.d("leak-170-11", dataLeAk170);
		android.util.Log.d("leak-171-11", dataLeAk171);
		android.util.Log.d("leak-172-11", dataLeAk172);
		android.util.Log.d("leak-173-11", dataLeAk173);
		android.util.Log.d("leak-174-11", dataLeAk174);
		android.util.Log.d("leak-175-11", dataLeAk175);
		android.util.Log.d("leak-176-11", dataLeAk176);
		android.util.Log.d("leak-178-11", dataLeAk178);
		android.util.Log.d("leak-180-11", dataLeAk180);
		Object value = get(column);
        return (value instanceof String) ? Short.valueOf((String) value)
                : ((Number) value).shortValue();
    }

    public int getInt(int column) {
        dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-12", dataLeAk158);
		android.util.Log.d("leak-159-12", dataLeAk159);
		android.util.Log.d("leak-160-12", dataLeAk160);
		android.util.Log.d("leak-161-12", dataLeAk161);
		android.util.Log.d("leak-162-12", dataLeAk162);
		android.util.Log.d("leak-163-12", dataLeAk163);
		android.util.Log.d("leak-164-12", dataLeAk164);
		android.util.Log.d("leak-165-12", dataLeAk165);
		android.util.Log.d("leak-166-12", dataLeAk166);
		android.util.Log.d("leak-167-12", dataLeAk167);
		android.util.Log.d("leak-168-12", dataLeAk168);
		android.util.Log.d("leak-169-12", dataLeAk169);
		android.util.Log.d("leak-170-12", dataLeAk170);
		android.util.Log.d("leak-171-12", dataLeAk171);
		android.util.Log.d("leak-172-12", dataLeAk172);
		android.util.Log.d("leak-173-12", dataLeAk173);
		android.util.Log.d("leak-174-12", dataLeAk174);
		android.util.Log.d("leak-175-12", dataLeAk175);
		android.util.Log.d("leak-176-12", dataLeAk176);
		android.util.Log.d("leak-178-12", dataLeAk178);
		android.util.Log.d("leak-180-12", dataLeAk180);
		Object value = get(column);
        return (value instanceof String) ? Integer.valueOf((String) value)
                : ((Number) value).intValue();
    }

    public long getLong(int column) {
        dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-13", dataLeAk158);
		android.util.Log.d("leak-159-13", dataLeAk159);
		android.util.Log.d("leak-160-13", dataLeAk160);
		android.util.Log.d("leak-161-13", dataLeAk161);
		android.util.Log.d("leak-162-13", dataLeAk162);
		android.util.Log.d("leak-163-13", dataLeAk163);
		android.util.Log.d("leak-164-13", dataLeAk164);
		android.util.Log.d("leak-165-13", dataLeAk165);
		android.util.Log.d("leak-166-13", dataLeAk166);
		android.util.Log.d("leak-167-13", dataLeAk167);
		android.util.Log.d("leak-168-13", dataLeAk168);
		android.util.Log.d("leak-169-13", dataLeAk169);
		android.util.Log.d("leak-170-13", dataLeAk170);
		android.util.Log.d("leak-171-13", dataLeAk171);
		android.util.Log.d("leak-172-13", dataLeAk172);
		android.util.Log.d("leak-173-13", dataLeAk173);
		android.util.Log.d("leak-174-13", dataLeAk174);
		android.util.Log.d("leak-175-13", dataLeAk175);
		android.util.Log.d("leak-176-13", dataLeAk176);
		android.util.Log.d("leak-178-13", dataLeAk178);
		android.util.Log.d("leak-180-13", dataLeAk180);
		Object value = get(column);
        return (value instanceof String) ? Long.valueOf((String) value)
                : ((Number) value).longValue();
    }

    public float getFloat(int column) {
        dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-14", dataLeAk158);
		android.util.Log.d("leak-159-14", dataLeAk159);
		android.util.Log.d("leak-160-14", dataLeAk160);
		android.util.Log.d("leak-161-14", dataLeAk161);
		android.util.Log.d("leak-162-14", dataLeAk162);
		android.util.Log.d("leak-163-14", dataLeAk163);
		android.util.Log.d("leak-164-14", dataLeAk164);
		android.util.Log.d("leak-165-14", dataLeAk165);
		android.util.Log.d("leak-166-14", dataLeAk166);
		android.util.Log.d("leak-167-14", dataLeAk167);
		android.util.Log.d("leak-168-14", dataLeAk168);
		android.util.Log.d("leak-169-14", dataLeAk169);
		android.util.Log.d("leak-170-14", dataLeAk170);
		android.util.Log.d("leak-171-14", dataLeAk171);
		android.util.Log.d("leak-172-14", dataLeAk172);
		android.util.Log.d("leak-173-14", dataLeAk173);
		android.util.Log.d("leak-174-14", dataLeAk174);
		android.util.Log.d("leak-175-14", dataLeAk175);
		android.util.Log.d("leak-176-14", dataLeAk176);
		android.util.Log.d("leak-178-14", dataLeAk178);
		android.util.Log.d("leak-180-14", dataLeAk180);
		Object value = get(column);
        return (value instanceof String) ? Float.valueOf((String) value)
                : ((Number) value).floatValue();
    }

    public double getDouble(int column) {
        dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-15", dataLeAk158);
		android.util.Log.d("leak-159-15", dataLeAk159);
		android.util.Log.d("leak-160-15", dataLeAk160);
		android.util.Log.d("leak-161-15", dataLeAk161);
		android.util.Log.d("leak-162-15", dataLeAk162);
		android.util.Log.d("leak-163-15", dataLeAk163);
		android.util.Log.d("leak-164-15", dataLeAk164);
		android.util.Log.d("leak-165-15", dataLeAk165);
		android.util.Log.d("leak-166-15", dataLeAk166);
		android.util.Log.d("leak-167-15", dataLeAk167);
		android.util.Log.d("leak-168-15", dataLeAk168);
		android.util.Log.d("leak-169-15", dataLeAk169);
		android.util.Log.d("leak-170-15", dataLeAk170);
		android.util.Log.d("leak-171-15", dataLeAk171);
		android.util.Log.d("leak-172-15", dataLeAk172);
		android.util.Log.d("leak-173-15", dataLeAk173);
		android.util.Log.d("leak-174-15", dataLeAk174);
		android.util.Log.d("leak-175-15", dataLeAk175);
		android.util.Log.d("leak-176-15", dataLeAk176);
		android.util.Log.d("leak-178-15", dataLeAk178);
		android.util.Log.d("leak-180-15", dataLeAk180);
		Object value = get(column);
        return (value instanceof String) ? Double.valueOf((String) value)
                : ((Number) value).doubleValue();
    }

    public boolean isNull(int column) {
        dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-16", dataLeAk158);
		android.util.Log.d("leak-159-16", dataLeAk159);
		android.util.Log.d("leak-160-16", dataLeAk160);
		android.util.Log.d("leak-161-16", dataLeAk161);
		android.util.Log.d("leak-162-16", dataLeAk162);
		android.util.Log.d("leak-163-16", dataLeAk163);
		android.util.Log.d("leak-164-16", dataLeAk164);
		android.util.Log.d("leak-165-16", dataLeAk165);
		android.util.Log.d("leak-166-16", dataLeAk166);
		android.util.Log.d("leak-167-16", dataLeAk167);
		android.util.Log.d("leak-168-16", dataLeAk168);
		android.util.Log.d("leak-169-16", dataLeAk169);
		android.util.Log.d("leak-170-16", dataLeAk170);
		android.util.Log.d("leak-171-16", dataLeAk171);
		android.util.Log.d("leak-172-16", dataLeAk172);
		android.util.Log.d("leak-173-16", dataLeAk173);
		android.util.Log.d("leak-174-16", dataLeAk174);
		android.util.Log.d("leak-175-16", dataLeAk175);
		android.util.Log.d("leak-176-16", dataLeAk176);
		android.util.Log.d("leak-178-16", dataLeAk178);
		android.util.Log.d("leak-180-16", dataLeAk180);
		return get(column) == null;
    }

    public void reset(int initialCapacity) {
        /* fill all Objects with null */

        dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-17", dataLeAk158);
		android.util.Log.d("leak-159-17", dataLeAk159);
		android.util.Log.d("leak-160-17", dataLeAk160);
		android.util.Log.d("leak-161-17", dataLeAk161);
		android.util.Log.d("leak-162-17", dataLeAk162);
		android.util.Log.d("leak-163-17", dataLeAk163);
		android.util.Log.d("leak-164-17", dataLeAk164);
		android.util.Log.d("leak-165-17", dataLeAk165);
		android.util.Log.d("leak-166-17", dataLeAk166);
		android.util.Log.d("leak-167-17", dataLeAk167);
		android.util.Log.d("leak-168-17", dataLeAk168);
		android.util.Log.d("leak-169-17", dataLeAk169);
		android.util.Log.d("leak-170-17", dataLeAk170);
		android.util.Log.d("leak-171-17", dataLeAk171);
		android.util.Log.d("leak-172-17", dataLeAk172);
		android.util.Log.d("leak-173-17", dataLeAk173);
		android.util.Log.d("leak-174-17", dataLeAk174);
		android.util.Log.d("leak-175-17", dataLeAk175);
		android.util.Log.d("leak-176-17", dataLeAk176);
		android.util.Log.d("leak-178-17", dataLeAk178);
		android.util.Log.d("leak-180-17", dataLeAk180);
		if (initialCapacity < 1) {
            initialCapacity = 1;
        }

        this.data = new Object[columnCount * initialCapacity];

        rowCount = 0;
        mPos = -1;
    }

    public void reset() {
        dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-158-18", dataLeAk158);
		android.util.Log.d("leak-159-18", dataLeAk159);
		android.util.Log.d("leak-160-18", dataLeAk160);
		android.util.Log.d("leak-161-18", dataLeAk161);
		android.util.Log.d("leak-162-18", dataLeAk162);
		android.util.Log.d("leak-163-18", dataLeAk163);
		android.util.Log.d("leak-164-18", dataLeAk164);
		android.util.Log.d("leak-165-18", dataLeAk165);
		android.util.Log.d("leak-166-18", dataLeAk166);
		android.util.Log.d("leak-167-18", dataLeAk167);
		android.util.Log.d("leak-168-18", dataLeAk168);
		android.util.Log.d("leak-169-18", dataLeAk169);
		android.util.Log.d("leak-170-18", dataLeAk170);
		android.util.Log.d("leak-171-18", dataLeAk171);
		android.util.Log.d("leak-172-18", dataLeAk172);
		android.util.Log.d("leak-173-18", dataLeAk173);
		android.util.Log.d("leak-174-18", dataLeAk174);
		android.util.Log.d("leak-175-18", dataLeAk175);
		android.util.Log.d("leak-176-18", dataLeAk176);
		android.util.Log.d("leak-178-18", dataLeAk178);
		android.util.Log.d("leak-180-18", dataLeAk180);
		reset(16);
    }

    /**
     * Builds a row, starting from the left-most column and adding one column
     * value at a time. Follows the same ordering as the column names specified
     * at cursor construction time.
     */
    public class RowBuilder {

        String dataLeAk179 = "";

		String dataLeAk177 = "";

		private final int endIndex;
        private int index;

        RowBuilder(int index, int endIndex) {
            dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-158-19", dataLeAk158);
			android.util.Log.d("leak-159-19", dataLeAk159);
			android.util.Log.d("leak-160-19", dataLeAk160);
			android.util.Log.d("leak-161-19", dataLeAk161);
			android.util.Log.d("leak-162-19", dataLeAk162);
			android.util.Log.d("leak-163-19", dataLeAk163);
			android.util.Log.d("leak-164-19", dataLeAk164);
			android.util.Log.d("leak-165-19", dataLeAk165);
			android.util.Log.d("leak-166-19", dataLeAk166);
			android.util.Log.d("leak-167-19", dataLeAk167);
			android.util.Log.d("leak-168-19", dataLeAk168);
			android.util.Log.d("leak-169-19", dataLeAk169);
			android.util.Log.d("leak-170-19", dataLeAk170);
			android.util.Log.d("leak-171-19", dataLeAk171);
			android.util.Log.d("leak-172-19", dataLeAk172);
			android.util.Log.d("leak-173-19", dataLeAk173);
			android.util.Log.d("leak-174-19", dataLeAk174);
			android.util.Log.d("leak-175-19", dataLeAk175);
			android.util.Log.d("leak-176-19", dataLeAk176);
			android.util.Log.d("leak-178-19", dataLeAk178);
			android.util.Log.d("leak-180-19", dataLeAk180);
			android.util.Log.d("leak-177-0", dataLeAk177);
			android.util.Log.d("leak-179-0", dataLeAk179);
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
            dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-158-20", dataLeAk158);
			android.util.Log.d("leak-159-20", dataLeAk159);
			android.util.Log.d("leak-160-20", dataLeAk160);
			android.util.Log.d("leak-161-20", dataLeAk161);
			android.util.Log.d("leak-162-20", dataLeAk162);
			android.util.Log.d("leak-163-20", dataLeAk163);
			android.util.Log.d("leak-164-20", dataLeAk164);
			android.util.Log.d("leak-165-20", dataLeAk165);
			android.util.Log.d("leak-166-20", dataLeAk166);
			android.util.Log.d("leak-167-20", dataLeAk167);
			android.util.Log.d("leak-168-20", dataLeAk168);
			android.util.Log.d("leak-169-20", dataLeAk169);
			android.util.Log.d("leak-170-20", dataLeAk170);
			android.util.Log.d("leak-171-20", dataLeAk171);
			android.util.Log.d("leak-172-20", dataLeAk172);
			android.util.Log.d("leak-173-20", dataLeAk173);
			android.util.Log.d("leak-174-20", dataLeAk174);
			android.util.Log.d("leak-175-20", dataLeAk175);
			android.util.Log.d("leak-176-20", dataLeAk176);
			android.util.Log.d("leak-178-20", dataLeAk178);
			android.util.Log.d("leak-180-20", dataLeAk180);
			android.util.Log.d("leak-177-1", dataLeAk177);
			android.util.Log.d("leak-179-1", dataLeAk179);
			if (index == endIndex) {
                throw new CursorIndexOutOfBoundsException(
                        "No more columns left."
                );
            }

            data[index++] = columnValue;
            return this;
        }
    }
}
