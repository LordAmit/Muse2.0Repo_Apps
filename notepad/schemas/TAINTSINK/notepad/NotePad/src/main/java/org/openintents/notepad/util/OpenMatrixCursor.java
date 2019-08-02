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

    String dataLeAk143 = "143";

	String dataLeAk141 = "141";

	String dataLeAk139 = "139";

	String dataLeAk138 = "138";

	String dataLeAk137 = "137";

	String dataLeAk136 = "136";

	String dataLeAk135 = "135";

	String dataLeAk134 = "134";

	String dataLeAk133 = "133";

	String dataLeAk132 = "132";

	String dataLeAk131 = "131";

	String dataLeAk130 = "130";

	String dataLeAk129 = "129";

	String dataLeAk128 = "128";

	String dataLeAk127 = "127";

	String dataLeAk126 = "126";

	String dataLeAk125 = "125";

	String dataLeAk124 = "124";

	String dataLeAk123 = "123";

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
        dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-132", dataLeAk123);
		android.util.Log.d("leak-124-132", dataLeAk124);
		android.util.Log.d("leak-125-132", dataLeAk125);
		android.util.Log.d("leak-126-132", dataLeAk126);
		android.util.Log.d("leak-127-132", dataLeAk127);
		android.util.Log.d("leak-128-132", dataLeAk128);
		android.util.Log.d("leak-129-132", dataLeAk129);
		android.util.Log.d("leak-130-132", dataLeAk130);
		android.util.Log.d("leak-131-132", dataLeAk131);
		android.util.Log.d("leak-132-132", dataLeAk132);
		android.util.Log.d("leak-133-132", dataLeAk133);
		android.util.Log.d("leak-134-132", dataLeAk134);
		android.util.Log.d("leak-135-132", dataLeAk135);
		android.util.Log.d("leak-136-132", dataLeAk136);
		android.util.Log.d("leak-137-132", dataLeAk137);
		android.util.Log.d("leak-138-132", dataLeAk138);
		android.util.Log.d("leak-139-132", dataLeAk139);
		android.util.Log.d("leak-141-132", dataLeAk141);
		android.util.Log.d("leak-143-132", dataLeAk143);
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
		dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-133", dataLeAk123);
		android.util.Log.d("leak-124-133", dataLeAk124);
		android.util.Log.d("leak-125-133", dataLeAk125);
		android.util.Log.d("leak-126-133", dataLeAk126);
		android.util.Log.d("leak-127-133", dataLeAk127);
		android.util.Log.d("leak-128-133", dataLeAk128);
		android.util.Log.d("leak-129-133", dataLeAk129);
		android.util.Log.d("leak-130-133", dataLeAk130);
		android.util.Log.d("leak-131-133", dataLeAk131);
		android.util.Log.d("leak-132-133", dataLeAk132);
		android.util.Log.d("leak-133-133", dataLeAk133);
		android.util.Log.d("leak-134-133", dataLeAk134);
		android.util.Log.d("leak-135-133", dataLeAk135);
		android.util.Log.d("leak-136-133", dataLeAk136);
		android.util.Log.d("leak-137-133", dataLeAk137);
		android.util.Log.d("leak-138-133", dataLeAk138);
		android.util.Log.d("leak-139-133", dataLeAk139);
		android.util.Log.d("leak-141-133", dataLeAk141);
		android.util.Log.d("leak-143-133", dataLeAk143);
    }

    /**
     * Gets value at the given column for the current row.
     */
    public Object get(int column) {
        dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-134", dataLeAk123);
		android.util.Log.d("leak-124-134", dataLeAk124);
		android.util.Log.d("leak-125-134", dataLeAk125);
		android.util.Log.d("leak-126-134", dataLeAk126);
		android.util.Log.d("leak-127-134", dataLeAk127);
		android.util.Log.d("leak-128-134", dataLeAk128);
		android.util.Log.d("leak-129-134", dataLeAk129);
		android.util.Log.d("leak-130-134", dataLeAk130);
		android.util.Log.d("leak-131-134", dataLeAk131);
		android.util.Log.d("leak-132-134", dataLeAk132);
		android.util.Log.d("leak-133-134", dataLeAk133);
		android.util.Log.d("leak-134-134", dataLeAk134);
		android.util.Log.d("leak-135-134", dataLeAk135);
		android.util.Log.d("leak-136-134", dataLeAk136);
		android.util.Log.d("leak-137-134", dataLeAk137);
		android.util.Log.d("leak-138-134", dataLeAk138);
		android.util.Log.d("leak-139-134", dataLeAk139);
		android.util.Log.d("leak-141-134", dataLeAk141);
		android.util.Log.d("leak-143-134", dataLeAk143);
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
        dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-135", dataLeAk123);
		android.util.Log.d("leak-124-135", dataLeAk124);
		android.util.Log.d("leak-125-135", dataLeAk125);
		android.util.Log.d("leak-126-135", dataLeAk126);
		android.util.Log.d("leak-127-135", dataLeAk127);
		android.util.Log.d("leak-128-135", dataLeAk128);
		android.util.Log.d("leak-129-135", dataLeAk129);
		android.util.Log.d("leak-130-135", dataLeAk130);
		android.util.Log.d("leak-131-135", dataLeAk131);
		android.util.Log.d("leak-132-135", dataLeAk132);
		android.util.Log.d("leak-133-135", dataLeAk133);
		android.util.Log.d("leak-134-135", dataLeAk134);
		android.util.Log.d("leak-135-135", dataLeAk135);
		android.util.Log.d("leak-136-135", dataLeAk136);
		android.util.Log.d("leak-137-135", dataLeAk137);
		android.util.Log.d("leak-138-135", dataLeAk138);
		android.util.Log.d("leak-139-135", dataLeAk139);
		android.util.Log.d("leak-141-135", dataLeAk141);
		android.util.Log.d("leak-143-135", dataLeAk143);
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
        dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-136", dataLeAk123);
		android.util.Log.d("leak-124-136", dataLeAk124);
		android.util.Log.d("leak-125-136", dataLeAk125);
		android.util.Log.d("leak-126-136", dataLeAk126);
		android.util.Log.d("leak-127-136", dataLeAk127);
		android.util.Log.d("leak-128-136", dataLeAk128);
		android.util.Log.d("leak-129-136", dataLeAk129);
		android.util.Log.d("leak-130-136", dataLeAk130);
		android.util.Log.d("leak-131-136", dataLeAk131);
		android.util.Log.d("leak-132-136", dataLeAk132);
		android.util.Log.d("leak-133-136", dataLeAk133);
		android.util.Log.d("leak-134-136", dataLeAk134);
		android.util.Log.d("leak-135-136", dataLeAk135);
		android.util.Log.d("leak-136-136", dataLeAk136);
		android.util.Log.d("leak-137-136", dataLeAk137);
		android.util.Log.d("leak-138-136", dataLeAk138);
		android.util.Log.d("leak-139-136", dataLeAk139);
		android.util.Log.d("leak-141-136", dataLeAk141);
		android.util.Log.d("leak-143-136", dataLeAk143);
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
        dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-137", dataLeAk123);
		android.util.Log.d("leak-124-137", dataLeAk124);
		android.util.Log.d("leak-125-137", dataLeAk125);
		android.util.Log.d("leak-126-137", dataLeAk126);
		android.util.Log.d("leak-127-137", dataLeAk127);
		android.util.Log.d("leak-128-137", dataLeAk128);
		android.util.Log.d("leak-129-137", dataLeAk129);
		android.util.Log.d("leak-130-137", dataLeAk130);
		android.util.Log.d("leak-131-137", dataLeAk131);
		android.util.Log.d("leak-132-137", dataLeAk132);
		android.util.Log.d("leak-133-137", dataLeAk133);
		android.util.Log.d("leak-134-137", dataLeAk134);
		android.util.Log.d("leak-135-137", dataLeAk135);
		android.util.Log.d("leak-136-137", dataLeAk136);
		android.util.Log.d("leak-137-137", dataLeAk137);
		android.util.Log.d("leak-138-137", dataLeAk138);
		android.util.Log.d("leak-139-137", dataLeAk139);
		android.util.Log.d("leak-141-137", dataLeAk141);
		android.util.Log.d("leak-143-137", dataLeAk143);
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
        int size = columnValues.size();
		android.util.Log.d("leak-123-138", dataLeAk123);
		android.util.Log.d("leak-124-138", dataLeAk124);
		android.util.Log.d("leak-125-138", dataLeAk125);
		android.util.Log.d("leak-126-138", dataLeAk126);
		android.util.Log.d("leak-127-138", dataLeAk127);
		android.util.Log.d("leak-128-138", dataLeAk128);
		android.util.Log.d("leak-129-138", dataLeAk129);
		android.util.Log.d("leak-130-138", dataLeAk130);
		android.util.Log.d("leak-131-138", dataLeAk131);
		android.util.Log.d("leak-132-138", dataLeAk132);
		android.util.Log.d("leak-133-138", dataLeAk133);
		android.util.Log.d("leak-134-138", dataLeAk134);
		android.util.Log.d("leak-135-138", dataLeAk135);
		android.util.Log.d("leak-136-138", dataLeAk136);
		android.util.Log.d("leak-137-138", dataLeAk137);
		android.util.Log.d("leak-138-138", dataLeAk138);
		android.util.Log.d("leak-139-138", dataLeAk139);
		android.util.Log.d("leak-141-138", dataLeAk141);
		android.util.Log.d("leak-143-138", dataLeAk143);
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
        if (size > data.length) {
            Object[] oldData = this.data;
            int newSize = data.length * 2;
            if (newSize < size) {
                newSize = size;
            }
            this.data = new Object[newSize];
            System.arraycopy(oldData, 0, this.data, 0, oldData.length);
        }
		android.util.Log.d("leak-123-139", dataLeAk123);
		android.util.Log.d("leak-124-139", dataLeAk124);
		android.util.Log.d("leak-125-139", dataLeAk125);
		android.util.Log.d("leak-126-139", dataLeAk126);
		android.util.Log.d("leak-127-139", dataLeAk127);
		android.util.Log.d("leak-128-139", dataLeAk128);
		android.util.Log.d("leak-129-139", dataLeAk129);
		android.util.Log.d("leak-130-139", dataLeAk130);
		android.util.Log.d("leak-131-139", dataLeAk131);
		android.util.Log.d("leak-132-139", dataLeAk132);
		android.util.Log.d("leak-133-139", dataLeAk133);
		android.util.Log.d("leak-134-139", dataLeAk134);
		android.util.Log.d("leak-135-139", dataLeAk135);
		android.util.Log.d("leak-136-139", dataLeAk136);
		android.util.Log.d("leak-137-139", dataLeAk137);
		android.util.Log.d("leak-138-139", dataLeAk138);
		android.util.Log.d("leak-139-139", dataLeAk139);
		android.util.Log.d("leak-141-139", dataLeAk141);
		android.util.Log.d("leak-143-139", dataLeAk143);
    }

    public int getCount() {
        dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-140", dataLeAk123);
		android.util.Log.d("leak-124-140", dataLeAk124);
		android.util.Log.d("leak-125-140", dataLeAk125);
		android.util.Log.d("leak-126-140", dataLeAk126);
		android.util.Log.d("leak-127-140", dataLeAk127);
		android.util.Log.d("leak-128-140", dataLeAk128);
		android.util.Log.d("leak-129-140", dataLeAk129);
		android.util.Log.d("leak-130-140", dataLeAk130);
		android.util.Log.d("leak-131-140", dataLeAk131);
		android.util.Log.d("leak-132-140", dataLeAk132);
		android.util.Log.d("leak-133-140", dataLeAk133);
		android.util.Log.d("leak-134-140", dataLeAk134);
		android.util.Log.d("leak-135-140", dataLeAk135);
		android.util.Log.d("leak-136-140", dataLeAk136);
		android.util.Log.d("leak-137-140", dataLeAk137);
		android.util.Log.d("leak-138-140", dataLeAk138);
		android.util.Log.d("leak-139-140", dataLeAk139);
		android.util.Log.d("leak-141-140", dataLeAk141);
		android.util.Log.d("leak-143-140", dataLeAk143);
		return rowCount;
    }

    // AbstractCursor implementation.

    public String[] getColumnNames() {
        dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-141", dataLeAk123);
		android.util.Log.d("leak-124-141", dataLeAk124);
		android.util.Log.d("leak-125-141", dataLeAk125);
		android.util.Log.d("leak-126-141", dataLeAk126);
		android.util.Log.d("leak-127-141", dataLeAk127);
		android.util.Log.d("leak-128-141", dataLeAk128);
		android.util.Log.d("leak-129-141", dataLeAk129);
		android.util.Log.d("leak-130-141", dataLeAk130);
		android.util.Log.d("leak-131-141", dataLeAk131);
		android.util.Log.d("leak-132-141", dataLeAk132);
		android.util.Log.d("leak-133-141", dataLeAk133);
		android.util.Log.d("leak-134-141", dataLeAk134);
		android.util.Log.d("leak-135-141", dataLeAk135);
		android.util.Log.d("leak-136-141", dataLeAk136);
		android.util.Log.d("leak-137-141", dataLeAk137);
		android.util.Log.d("leak-138-141", dataLeAk138);
		android.util.Log.d("leak-139-141", dataLeAk139);
		android.util.Log.d("leak-141-141", dataLeAk141);
		android.util.Log.d("leak-143-141", dataLeAk143);
		return columnNames;
    }

    public String getString(int column) {
        dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-142", dataLeAk123);
		android.util.Log.d("leak-124-142", dataLeAk124);
		android.util.Log.d("leak-125-142", dataLeAk125);
		android.util.Log.d("leak-126-142", dataLeAk126);
		android.util.Log.d("leak-127-142", dataLeAk127);
		android.util.Log.d("leak-128-142", dataLeAk128);
		android.util.Log.d("leak-129-142", dataLeAk129);
		android.util.Log.d("leak-130-142", dataLeAk130);
		android.util.Log.d("leak-131-142", dataLeAk131);
		android.util.Log.d("leak-132-142", dataLeAk132);
		android.util.Log.d("leak-133-142", dataLeAk133);
		android.util.Log.d("leak-134-142", dataLeAk134);
		android.util.Log.d("leak-135-142", dataLeAk135);
		android.util.Log.d("leak-136-142", dataLeAk136);
		android.util.Log.d("leak-137-142", dataLeAk137);
		android.util.Log.d("leak-138-142", dataLeAk138);
		android.util.Log.d("leak-139-142", dataLeAk139);
		android.util.Log.d("leak-141-142", dataLeAk141);
		android.util.Log.d("leak-143-142", dataLeAk143);
		return String.valueOf(get(column));
    }

    public short getShort(int column) {
        dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-143", dataLeAk123);
		android.util.Log.d("leak-124-143", dataLeAk124);
		android.util.Log.d("leak-125-143", dataLeAk125);
		android.util.Log.d("leak-126-143", dataLeAk126);
		android.util.Log.d("leak-127-143", dataLeAk127);
		android.util.Log.d("leak-128-143", dataLeAk128);
		android.util.Log.d("leak-129-143", dataLeAk129);
		android.util.Log.d("leak-130-143", dataLeAk130);
		android.util.Log.d("leak-131-143", dataLeAk131);
		android.util.Log.d("leak-132-143", dataLeAk132);
		android.util.Log.d("leak-133-143", dataLeAk133);
		android.util.Log.d("leak-134-143", dataLeAk134);
		android.util.Log.d("leak-135-143", dataLeAk135);
		android.util.Log.d("leak-136-143", dataLeAk136);
		android.util.Log.d("leak-137-143", dataLeAk137);
		android.util.Log.d("leak-138-143", dataLeAk138);
		android.util.Log.d("leak-139-143", dataLeAk139);
		android.util.Log.d("leak-141-143", dataLeAk141);
		android.util.Log.d("leak-143-143", dataLeAk143);
		Object value = get(column);
        return (value instanceof String) ? Short.valueOf((String) value)
                : ((Number) value).shortValue();
    }

    public int getInt(int column) {
        dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-144", dataLeAk123);
		android.util.Log.d("leak-124-144", dataLeAk124);
		android.util.Log.d("leak-125-144", dataLeAk125);
		android.util.Log.d("leak-126-144", dataLeAk126);
		android.util.Log.d("leak-127-144", dataLeAk127);
		android.util.Log.d("leak-128-144", dataLeAk128);
		android.util.Log.d("leak-129-144", dataLeAk129);
		android.util.Log.d("leak-130-144", dataLeAk130);
		android.util.Log.d("leak-131-144", dataLeAk131);
		android.util.Log.d("leak-132-144", dataLeAk132);
		android.util.Log.d("leak-133-144", dataLeAk133);
		android.util.Log.d("leak-134-144", dataLeAk134);
		android.util.Log.d("leak-135-144", dataLeAk135);
		android.util.Log.d("leak-136-144", dataLeAk136);
		android.util.Log.d("leak-137-144", dataLeAk137);
		android.util.Log.d("leak-138-144", dataLeAk138);
		android.util.Log.d("leak-139-144", dataLeAk139);
		android.util.Log.d("leak-141-144", dataLeAk141);
		android.util.Log.d("leak-143-144", dataLeAk143);
		Object value = get(column);
        return (value instanceof String) ? Integer.valueOf((String) value)
                : ((Number) value).intValue();
    }

    public long getLong(int column) {
        dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-145", dataLeAk123);
		android.util.Log.d("leak-124-145", dataLeAk124);
		android.util.Log.d("leak-125-145", dataLeAk125);
		android.util.Log.d("leak-126-145", dataLeAk126);
		android.util.Log.d("leak-127-145", dataLeAk127);
		android.util.Log.d("leak-128-145", dataLeAk128);
		android.util.Log.d("leak-129-145", dataLeAk129);
		android.util.Log.d("leak-130-145", dataLeAk130);
		android.util.Log.d("leak-131-145", dataLeAk131);
		android.util.Log.d("leak-132-145", dataLeAk132);
		android.util.Log.d("leak-133-145", dataLeAk133);
		android.util.Log.d("leak-134-145", dataLeAk134);
		android.util.Log.d("leak-135-145", dataLeAk135);
		android.util.Log.d("leak-136-145", dataLeAk136);
		android.util.Log.d("leak-137-145", dataLeAk137);
		android.util.Log.d("leak-138-145", dataLeAk138);
		android.util.Log.d("leak-139-145", dataLeAk139);
		android.util.Log.d("leak-141-145", dataLeAk141);
		android.util.Log.d("leak-143-145", dataLeAk143);
		Object value = get(column);
        return (value instanceof String) ? Long.valueOf((String) value)
                : ((Number) value).longValue();
    }

    public float getFloat(int column) {
        dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-146", dataLeAk123);
		android.util.Log.d("leak-124-146", dataLeAk124);
		android.util.Log.d("leak-125-146", dataLeAk125);
		android.util.Log.d("leak-126-146", dataLeAk126);
		android.util.Log.d("leak-127-146", dataLeAk127);
		android.util.Log.d("leak-128-146", dataLeAk128);
		android.util.Log.d("leak-129-146", dataLeAk129);
		android.util.Log.d("leak-130-146", dataLeAk130);
		android.util.Log.d("leak-131-146", dataLeAk131);
		android.util.Log.d("leak-132-146", dataLeAk132);
		android.util.Log.d("leak-133-146", dataLeAk133);
		android.util.Log.d("leak-134-146", dataLeAk134);
		android.util.Log.d("leak-135-146", dataLeAk135);
		android.util.Log.d("leak-136-146", dataLeAk136);
		android.util.Log.d("leak-137-146", dataLeAk137);
		android.util.Log.d("leak-138-146", dataLeAk138);
		android.util.Log.d("leak-139-146", dataLeAk139);
		android.util.Log.d("leak-141-146", dataLeAk141);
		android.util.Log.d("leak-143-146", dataLeAk143);
		Object value = get(column);
        return (value instanceof String) ? Float.valueOf((String) value)
                : ((Number) value).floatValue();
    }

    public double getDouble(int column) {
        dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-147", dataLeAk123);
		android.util.Log.d("leak-124-147", dataLeAk124);
		android.util.Log.d("leak-125-147", dataLeAk125);
		android.util.Log.d("leak-126-147", dataLeAk126);
		android.util.Log.d("leak-127-147", dataLeAk127);
		android.util.Log.d("leak-128-147", dataLeAk128);
		android.util.Log.d("leak-129-147", dataLeAk129);
		android.util.Log.d("leak-130-147", dataLeAk130);
		android.util.Log.d("leak-131-147", dataLeAk131);
		android.util.Log.d("leak-132-147", dataLeAk132);
		android.util.Log.d("leak-133-147", dataLeAk133);
		android.util.Log.d("leak-134-147", dataLeAk134);
		android.util.Log.d("leak-135-147", dataLeAk135);
		android.util.Log.d("leak-136-147", dataLeAk136);
		android.util.Log.d("leak-137-147", dataLeAk137);
		android.util.Log.d("leak-138-147", dataLeAk138);
		android.util.Log.d("leak-139-147", dataLeAk139);
		android.util.Log.d("leak-141-147", dataLeAk141);
		android.util.Log.d("leak-143-147", dataLeAk143);
		Object value = get(column);
        return (value instanceof String) ? Double.valueOf((String) value)
                : ((Number) value).doubleValue();
    }

    public boolean isNull(int column) {
        dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-148", dataLeAk123);
		android.util.Log.d("leak-124-148", dataLeAk124);
		android.util.Log.d("leak-125-148", dataLeAk125);
		android.util.Log.d("leak-126-148", dataLeAk126);
		android.util.Log.d("leak-127-148", dataLeAk127);
		android.util.Log.d("leak-128-148", dataLeAk128);
		android.util.Log.d("leak-129-148", dataLeAk129);
		android.util.Log.d("leak-130-148", dataLeAk130);
		android.util.Log.d("leak-131-148", dataLeAk131);
		android.util.Log.d("leak-132-148", dataLeAk132);
		android.util.Log.d("leak-133-148", dataLeAk133);
		android.util.Log.d("leak-134-148", dataLeAk134);
		android.util.Log.d("leak-135-148", dataLeAk135);
		android.util.Log.d("leak-136-148", dataLeAk136);
		android.util.Log.d("leak-137-148", dataLeAk137);
		android.util.Log.d("leak-138-148", dataLeAk138);
		android.util.Log.d("leak-139-148", dataLeAk139);
		android.util.Log.d("leak-141-148", dataLeAk141);
		android.util.Log.d("leak-143-148", dataLeAk143);
		return get(column) == null;
    }

    public void reset(int initialCapacity) {
        /* fill all Objects with null */

        dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-149", dataLeAk123);
		android.util.Log.d("leak-124-149", dataLeAk124);
		android.util.Log.d("leak-125-149", dataLeAk125);
		android.util.Log.d("leak-126-149", dataLeAk126);
		android.util.Log.d("leak-127-149", dataLeAk127);
		android.util.Log.d("leak-128-149", dataLeAk128);
		android.util.Log.d("leak-129-149", dataLeAk129);
		android.util.Log.d("leak-130-149", dataLeAk130);
		android.util.Log.d("leak-131-149", dataLeAk131);
		android.util.Log.d("leak-132-149", dataLeAk132);
		android.util.Log.d("leak-133-149", dataLeAk133);
		android.util.Log.d("leak-134-149", dataLeAk134);
		android.util.Log.d("leak-135-149", dataLeAk135);
		android.util.Log.d("leak-136-149", dataLeAk136);
		android.util.Log.d("leak-137-149", dataLeAk137);
		android.util.Log.d("leak-138-149", dataLeAk138);
		android.util.Log.d("leak-139-149", dataLeAk139);
		android.util.Log.d("leak-141-149", dataLeAk141);
		android.util.Log.d("leak-143-149", dataLeAk143);
		if (initialCapacity < 1) {
            initialCapacity = 1;
        }

        this.data = new Object[columnCount * initialCapacity];

        rowCount = 0;
        mPos = -1;
    }

    public void reset() {
        dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-150", dataLeAk123);
		android.util.Log.d("leak-124-150", dataLeAk124);
		android.util.Log.d("leak-125-150", dataLeAk125);
		android.util.Log.d("leak-126-150", dataLeAk126);
		android.util.Log.d("leak-127-150", dataLeAk127);
		android.util.Log.d("leak-128-150", dataLeAk128);
		android.util.Log.d("leak-129-150", dataLeAk129);
		android.util.Log.d("leak-130-150", dataLeAk130);
		android.util.Log.d("leak-131-150", dataLeAk131);
		android.util.Log.d("leak-132-150", dataLeAk132);
		android.util.Log.d("leak-133-150", dataLeAk133);
		android.util.Log.d("leak-134-150", dataLeAk134);
		android.util.Log.d("leak-135-150", dataLeAk135);
		android.util.Log.d("leak-136-150", dataLeAk136);
		android.util.Log.d("leak-137-150", dataLeAk137);
		android.util.Log.d("leak-138-150", dataLeAk138);
		android.util.Log.d("leak-139-150", dataLeAk139);
		android.util.Log.d("leak-141-150", dataLeAk141);
		android.util.Log.d("leak-143-150", dataLeAk143);
		reset(16);
    }

    /**
     * Builds a row, starting from the left-most column and adding one column
     * value at a time. Follows the same ordering as the column names specified
     * at cursor construction time.
     */
    public class RowBuilder {

        String dataLeAk142 = "142";

		String dataLeAk140 = "140";

		private final int endIndex;
        private int index;

        RowBuilder(int index, int endIndex) {
            dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-140-151", dataLeAk140);
			android.util.Log.d("leak-142-151", dataLeAk142);
			android.util.Log.d("leak-123-151", dataLeAk123);
			android.util.Log.d("leak-124-151", dataLeAk124);
			android.util.Log.d("leak-125-151", dataLeAk125);
			android.util.Log.d("leak-126-151", dataLeAk126);
			android.util.Log.d("leak-127-151", dataLeAk127);
			android.util.Log.d("leak-128-151", dataLeAk128);
			android.util.Log.d("leak-129-151", dataLeAk129);
			android.util.Log.d("leak-130-151", dataLeAk130);
			android.util.Log.d("leak-131-151", dataLeAk131);
			android.util.Log.d("leak-132-151", dataLeAk132);
			android.util.Log.d("leak-133-151", dataLeAk133);
			android.util.Log.d("leak-134-151", dataLeAk134);
			android.util.Log.d("leak-135-151", dataLeAk135);
			android.util.Log.d("leak-136-151", dataLeAk136);
			android.util.Log.d("leak-137-151", dataLeAk137);
			android.util.Log.d("leak-138-151", dataLeAk138);
			android.util.Log.d("leak-139-151", dataLeAk139);
			android.util.Log.d("leak-141-151", dataLeAk141);
			android.util.Log.d("leak-143-151", dataLeAk143);
			dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-140-152", dataLeAk140);
			android.util.Log.d("leak-142-152", dataLeAk142);
			android.util.Log.d("leak-123-152", dataLeAk123);
			android.util.Log.d("leak-124-152", dataLeAk124);
			android.util.Log.d("leak-125-152", dataLeAk125);
			android.util.Log.d("leak-126-152", dataLeAk126);
			android.util.Log.d("leak-127-152", dataLeAk127);
			android.util.Log.d("leak-128-152", dataLeAk128);
			android.util.Log.d("leak-129-152", dataLeAk129);
			android.util.Log.d("leak-130-152", dataLeAk130);
			android.util.Log.d("leak-131-152", dataLeAk131);
			android.util.Log.d("leak-132-152", dataLeAk132);
			android.util.Log.d("leak-133-152", dataLeAk133);
			android.util.Log.d("leak-134-152", dataLeAk134);
			android.util.Log.d("leak-135-152", dataLeAk135);
			android.util.Log.d("leak-136-152", dataLeAk136);
			android.util.Log.d("leak-137-152", dataLeAk137);
			android.util.Log.d("leak-138-152", dataLeAk138);
			android.util.Log.d("leak-139-152", dataLeAk139);
			android.util.Log.d("leak-141-152", dataLeAk141);
			android.util.Log.d("leak-143-152", dataLeAk143);
			dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
