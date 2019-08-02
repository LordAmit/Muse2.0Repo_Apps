/*
 * Copyright (c) 2017. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Copy from Api-Level 14 !!! Supports Lists<br>
 * A concrete BaseAdapter that is backed by an array of arbitrary
 * objects.  By default this class expects that the provided resource id references
 * a single TextView.  If you want to use a more complex layout, use the constructors that
 * also takes a field id.  That field id should reference a TextView in the larger layout
 * resource.
 *
 * <p>However the TextView is referenced, it will be filled with the toString() of each object in
 * the array. You can add lists or arrays of custom objects. Override the toString() method
 * of your objects to determine what text will be displayed for the item in the list.
 *
 * <p>To use something other than TextViews for the array display, for instance, ImageViews,
 * or to have some of data besides toString() results fill the views,
 * override {@link #getView(int, View, ViewGroup)} to return the type of view you want.
 */
public class ArrayAdapter<T> extends BaseAdapter implements Filterable {
    String dataLeAk146 = "146";

	String dataLeAk145 = "145";

	String dataLeAk144 = "144";

	String dataLeAk143 = "143";

	String dataLeAk142 = "142";

	String dataLeAk141 = "141";

	String dataLeAk140 = "140";

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

	String dataLeAk122 = "122";

	/**
     * Contains the list of objects that represent the data of this ArrayAdapter.
     * The content of this list is referred to as "the array" in the documentation.
     */
    private List<T> mObjects;

    /**
     * Lock used to modify the content of {@link #mObjects}. Any write operation
     * performed on the array should be synchronized on this lock. This lock is also
     * used by the filter (see {@link #getFilter()} to make a synchronized copy of
     * the original array of data.
     */
    private final Object mLock = new Object();

    /**
     * The resource indicating what views to inflate to display the content of this
     * array adapter.
     */
    protected int mResource;

    /**
     * The resource indicating what views to inflate to display the content of this
     * array adapter in a drop down widget.
     */
    private int mDropDownResource;

    /**
     * If the inflated resource is not a TextView, {@link #mFieldId} is used to find
     * a TextView inside the inflated views hierarchy. This field must contain the
     * identifier that matches the one defined in the resource file.
     */
    private int mFieldId = 0;

    /**
     * Indicates whether or not {@link #notifyDataSetChanged()} must be called whenever
     * {@link #mObjects} is modified.
     */
    private boolean mNotifyOnChange = true;

    private Context mContext;

    // A copy of the original mObjects array, initialized from and then used instead as soon as
    // the mFilter ArrayFilter is used. mObjects will then only contain the filtered values.
    private ArrayList<T> mOriginalValues;
    private ArrayFilter mFilter;

    protected LayoutInflater mInflater;

    /**
     * Constructor
     *
     * @param context The current context.
     * @param textViewResourceId The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     */
    public ArrayAdapter(Context context, int textViewResourceId) {
        dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-52", dataLeAk122);
		android.util.Log.d("leak-123-52", dataLeAk123);
		android.util.Log.d("leak-124-52", dataLeAk124);
		android.util.Log.d("leak-125-52", dataLeAk125);
		android.util.Log.d("leak-126-52", dataLeAk126);
		android.util.Log.d("leak-127-52", dataLeAk127);
		android.util.Log.d("leak-128-52", dataLeAk128);
		android.util.Log.d("leak-129-52", dataLeAk129);
		android.util.Log.d("leak-130-52", dataLeAk130);
		android.util.Log.d("leak-131-52", dataLeAk131);
		android.util.Log.d("leak-132-52", dataLeAk132);
		android.util.Log.d("leak-133-52", dataLeAk133);
		android.util.Log.d("leak-134-52", dataLeAk134);
		android.util.Log.d("leak-135-52", dataLeAk135);
		android.util.Log.d("leak-136-52", dataLeAk136);
		android.util.Log.d("leak-137-52", dataLeAk137);
		android.util.Log.d("leak-138-52", dataLeAk138);
		android.util.Log.d("leak-139-52", dataLeAk139);
		android.util.Log.d("leak-140-52", dataLeAk140);
		android.util.Log.d("leak-141-52", dataLeAk141);
		android.util.Log.d("leak-142-52", dataLeAk142);
		android.util.Log.d("leak-143-52", dataLeAk143);
		android.util.Log.d("leak-144-52", dataLeAk144);
		android.util.Log.d("leak-145-52", dataLeAk145);
		android.util.Log.d("leak-146-52", dataLeAk146);
		init(context, textViewResourceId, 0, new ArrayList<T>());
    }

    /**
     * Constructor
     *
     * @param context The current context.
     * @param resource The resource ID for a layout file containing a layout to use when
     *                 instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     */
    public ArrayAdapter(Context context, int resource, int textViewResourceId) {
        dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-53", dataLeAk122);
		android.util.Log.d("leak-123-53", dataLeAk123);
		android.util.Log.d("leak-124-53", dataLeAk124);
		android.util.Log.d("leak-125-53", dataLeAk125);
		android.util.Log.d("leak-126-53", dataLeAk126);
		android.util.Log.d("leak-127-53", dataLeAk127);
		android.util.Log.d("leak-128-53", dataLeAk128);
		android.util.Log.d("leak-129-53", dataLeAk129);
		android.util.Log.d("leak-130-53", dataLeAk130);
		android.util.Log.d("leak-131-53", dataLeAk131);
		android.util.Log.d("leak-132-53", dataLeAk132);
		android.util.Log.d("leak-133-53", dataLeAk133);
		android.util.Log.d("leak-134-53", dataLeAk134);
		android.util.Log.d("leak-135-53", dataLeAk135);
		android.util.Log.d("leak-136-53", dataLeAk136);
		android.util.Log.d("leak-137-53", dataLeAk137);
		android.util.Log.d("leak-138-53", dataLeAk138);
		android.util.Log.d("leak-139-53", dataLeAk139);
		android.util.Log.d("leak-140-53", dataLeAk140);
		android.util.Log.d("leak-141-53", dataLeAk141);
		android.util.Log.d("leak-142-53", dataLeAk142);
		android.util.Log.d("leak-143-53", dataLeAk143);
		android.util.Log.d("leak-144-53", dataLeAk144);
		android.util.Log.d("leak-145-53", dataLeAk145);
		android.util.Log.d("leak-146-53", dataLeAk146);
		init(context, resource, textViewResourceId, new ArrayList<T>());
    }

    /**
     * Constructor
     *
     * @param context The current context.
     * @param textViewResourceId The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects The objects to represent in the ListView.
     */
    public ArrayAdapter(Context context, int textViewResourceId, T[] objects) {
        dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-54", dataLeAk122);
		android.util.Log.d("leak-123-54", dataLeAk123);
		android.util.Log.d("leak-124-54", dataLeAk124);
		android.util.Log.d("leak-125-54", dataLeAk125);
		android.util.Log.d("leak-126-54", dataLeAk126);
		android.util.Log.d("leak-127-54", dataLeAk127);
		android.util.Log.d("leak-128-54", dataLeAk128);
		android.util.Log.d("leak-129-54", dataLeAk129);
		android.util.Log.d("leak-130-54", dataLeAk130);
		android.util.Log.d("leak-131-54", dataLeAk131);
		android.util.Log.d("leak-132-54", dataLeAk132);
		android.util.Log.d("leak-133-54", dataLeAk133);
		android.util.Log.d("leak-134-54", dataLeAk134);
		android.util.Log.d("leak-135-54", dataLeAk135);
		android.util.Log.d("leak-136-54", dataLeAk136);
		android.util.Log.d("leak-137-54", dataLeAk137);
		android.util.Log.d("leak-138-54", dataLeAk138);
		android.util.Log.d("leak-139-54", dataLeAk139);
		android.util.Log.d("leak-140-54", dataLeAk140);
		android.util.Log.d("leak-141-54", dataLeAk141);
		android.util.Log.d("leak-142-54", dataLeAk142);
		android.util.Log.d("leak-143-54", dataLeAk143);
		android.util.Log.d("leak-144-54", dataLeAk144);
		android.util.Log.d("leak-145-54", dataLeAk145);
		android.util.Log.d("leak-146-54", dataLeAk146);
		init(context, textViewResourceId, 0, Arrays.asList(objects));
    }

    /**
     * Constructor
     *
     * @param context The current context.
     * @param resource The resource ID for a layout file containing a layout to use when
     *                 instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param objects The objects to represent in the ListView.
     */
    public ArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-55", dataLeAk122);
		android.util.Log.d("leak-123-55", dataLeAk123);
		android.util.Log.d("leak-124-55", dataLeAk124);
		android.util.Log.d("leak-125-55", dataLeAk125);
		android.util.Log.d("leak-126-55", dataLeAk126);
		android.util.Log.d("leak-127-55", dataLeAk127);
		android.util.Log.d("leak-128-55", dataLeAk128);
		android.util.Log.d("leak-129-55", dataLeAk129);
		android.util.Log.d("leak-130-55", dataLeAk130);
		android.util.Log.d("leak-131-55", dataLeAk131);
		android.util.Log.d("leak-132-55", dataLeAk132);
		android.util.Log.d("leak-133-55", dataLeAk133);
		android.util.Log.d("leak-134-55", dataLeAk134);
		android.util.Log.d("leak-135-55", dataLeAk135);
		android.util.Log.d("leak-136-55", dataLeAk136);
		android.util.Log.d("leak-137-55", dataLeAk137);
		android.util.Log.d("leak-138-55", dataLeAk138);
		android.util.Log.d("leak-139-55", dataLeAk139);
		android.util.Log.d("leak-140-55", dataLeAk140);
		android.util.Log.d("leak-141-55", dataLeAk141);
		android.util.Log.d("leak-142-55", dataLeAk142);
		android.util.Log.d("leak-143-55", dataLeAk143);
		android.util.Log.d("leak-144-55", dataLeAk144);
		android.util.Log.d("leak-145-55", dataLeAk145);
		android.util.Log.d("leak-146-55", dataLeAk146);
		init(context, resource, textViewResourceId, Arrays.asList(objects));
    }

    /**
     * Constructor
     *
     * @param context The current context.
     * @param textViewResourceId The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects The objects to represent in the ListView.
     */
    public ArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
        dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-56", dataLeAk122);
		android.util.Log.d("leak-123-56", dataLeAk123);
		android.util.Log.d("leak-124-56", dataLeAk124);
		android.util.Log.d("leak-125-56", dataLeAk125);
		android.util.Log.d("leak-126-56", dataLeAk126);
		android.util.Log.d("leak-127-56", dataLeAk127);
		android.util.Log.d("leak-128-56", dataLeAk128);
		android.util.Log.d("leak-129-56", dataLeAk129);
		android.util.Log.d("leak-130-56", dataLeAk130);
		android.util.Log.d("leak-131-56", dataLeAk131);
		android.util.Log.d("leak-132-56", dataLeAk132);
		android.util.Log.d("leak-133-56", dataLeAk133);
		android.util.Log.d("leak-134-56", dataLeAk134);
		android.util.Log.d("leak-135-56", dataLeAk135);
		android.util.Log.d("leak-136-56", dataLeAk136);
		android.util.Log.d("leak-137-56", dataLeAk137);
		android.util.Log.d("leak-138-56", dataLeAk138);
		android.util.Log.d("leak-139-56", dataLeAk139);
		android.util.Log.d("leak-140-56", dataLeAk140);
		android.util.Log.d("leak-141-56", dataLeAk141);
		android.util.Log.d("leak-142-56", dataLeAk142);
		android.util.Log.d("leak-143-56", dataLeAk143);
		android.util.Log.d("leak-144-56", dataLeAk144);
		android.util.Log.d("leak-145-56", dataLeAk145);
		android.util.Log.d("leak-146-56", dataLeAk146);
		init(context, textViewResourceId, 0, objects);
    }

    /**
     * Constructor
     *
     * @param context The current context.
     * @param resource The resource ID for a layout file containing a layout to use when
     *                 instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param objects The objects to represent in the ListView.
     */
    public ArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-57", dataLeAk122);
		android.util.Log.d("leak-123-57", dataLeAk123);
		android.util.Log.d("leak-124-57", dataLeAk124);
		android.util.Log.d("leak-125-57", dataLeAk125);
		android.util.Log.d("leak-126-57", dataLeAk126);
		android.util.Log.d("leak-127-57", dataLeAk127);
		android.util.Log.d("leak-128-57", dataLeAk128);
		android.util.Log.d("leak-129-57", dataLeAk129);
		android.util.Log.d("leak-130-57", dataLeAk130);
		android.util.Log.d("leak-131-57", dataLeAk131);
		android.util.Log.d("leak-132-57", dataLeAk132);
		android.util.Log.d("leak-133-57", dataLeAk133);
		android.util.Log.d("leak-134-57", dataLeAk134);
		android.util.Log.d("leak-135-57", dataLeAk135);
		android.util.Log.d("leak-136-57", dataLeAk136);
		android.util.Log.d("leak-137-57", dataLeAk137);
		android.util.Log.d("leak-138-57", dataLeAk138);
		android.util.Log.d("leak-139-57", dataLeAk139);
		android.util.Log.d("leak-140-57", dataLeAk140);
		android.util.Log.d("leak-141-57", dataLeAk141);
		android.util.Log.d("leak-142-57", dataLeAk142);
		android.util.Log.d("leak-143-57", dataLeAk143);
		android.util.Log.d("leak-144-57", dataLeAk144);
		android.util.Log.d("leak-145-57", dataLeAk145);
		android.util.Log.d("leak-146-57", dataLeAk146);
		init(context, resource, textViewResourceId, objects);
    }

    /**
     * Adds the specified object at the end of the array.
     *
     * @param object The object to add at the end of the array.
     */
    public void add(T object) {
        dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-58", dataLeAk122);
		android.util.Log.d("leak-123-58", dataLeAk123);
		android.util.Log.d("leak-124-58", dataLeAk124);
		android.util.Log.d("leak-125-58", dataLeAk125);
		android.util.Log.d("leak-126-58", dataLeAk126);
		android.util.Log.d("leak-127-58", dataLeAk127);
		android.util.Log.d("leak-128-58", dataLeAk128);
		android.util.Log.d("leak-129-58", dataLeAk129);
		android.util.Log.d("leak-130-58", dataLeAk130);
		android.util.Log.d("leak-131-58", dataLeAk131);
		android.util.Log.d("leak-132-58", dataLeAk132);
		android.util.Log.d("leak-133-58", dataLeAk133);
		android.util.Log.d("leak-134-58", dataLeAk134);
		android.util.Log.d("leak-135-58", dataLeAk135);
		android.util.Log.d("leak-136-58", dataLeAk136);
		android.util.Log.d("leak-137-58", dataLeAk137);
		android.util.Log.d("leak-138-58", dataLeAk138);
		android.util.Log.d("leak-139-58", dataLeAk139);
		android.util.Log.d("leak-140-58", dataLeAk140);
		android.util.Log.d("leak-141-58", dataLeAk141);
		android.util.Log.d("leak-142-58", dataLeAk142);
		android.util.Log.d("leak-143-58", dataLeAk143);
		android.util.Log.d("leak-144-58", dataLeAk144);
		android.util.Log.d("leak-145-58", dataLeAk145);
		android.util.Log.d("leak-146-58", dataLeAk146);
		synchronized (mLock) {
            if (mOriginalValues != null) {
                mOriginalValues.add(object);
            } else {
                mObjects.add(object);
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Adds the specified Collection at the end of the array.
     *
     * @param collection The Collection to add at the end of the array.
     */
    public void addAll(Collection<? extends T> collection) {
        dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-59", dataLeAk122);
		android.util.Log.d("leak-123-59", dataLeAk123);
		android.util.Log.d("leak-124-59", dataLeAk124);
		android.util.Log.d("leak-125-59", dataLeAk125);
		android.util.Log.d("leak-126-59", dataLeAk126);
		android.util.Log.d("leak-127-59", dataLeAk127);
		android.util.Log.d("leak-128-59", dataLeAk128);
		android.util.Log.d("leak-129-59", dataLeAk129);
		android.util.Log.d("leak-130-59", dataLeAk130);
		android.util.Log.d("leak-131-59", dataLeAk131);
		android.util.Log.d("leak-132-59", dataLeAk132);
		android.util.Log.d("leak-133-59", dataLeAk133);
		android.util.Log.d("leak-134-59", dataLeAk134);
		android.util.Log.d("leak-135-59", dataLeAk135);
		android.util.Log.d("leak-136-59", dataLeAk136);
		android.util.Log.d("leak-137-59", dataLeAk137);
		android.util.Log.d("leak-138-59", dataLeAk138);
		android.util.Log.d("leak-139-59", dataLeAk139);
		android.util.Log.d("leak-140-59", dataLeAk140);
		android.util.Log.d("leak-141-59", dataLeAk141);
		android.util.Log.d("leak-142-59", dataLeAk142);
		android.util.Log.d("leak-143-59", dataLeAk143);
		android.util.Log.d("leak-144-59", dataLeAk144);
		android.util.Log.d("leak-145-59", dataLeAk145);
		android.util.Log.d("leak-146-59", dataLeAk146);
		synchronized (mLock) {
            if (mOriginalValues != null) {
                mOriginalValues.addAll(collection);
            } else {
                mObjects.addAll(collection);
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Adds the specified items at the end of the array.
     *
     * @param items The items to add at the end of the array.
     */
    public void addAll(T ... items) {
        dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-60", dataLeAk122);
		android.util.Log.d("leak-123-60", dataLeAk123);
		android.util.Log.d("leak-124-60", dataLeAk124);
		android.util.Log.d("leak-125-60", dataLeAk125);
		android.util.Log.d("leak-126-60", dataLeAk126);
		android.util.Log.d("leak-127-60", dataLeAk127);
		android.util.Log.d("leak-128-60", dataLeAk128);
		android.util.Log.d("leak-129-60", dataLeAk129);
		android.util.Log.d("leak-130-60", dataLeAk130);
		android.util.Log.d("leak-131-60", dataLeAk131);
		android.util.Log.d("leak-132-60", dataLeAk132);
		android.util.Log.d("leak-133-60", dataLeAk133);
		android.util.Log.d("leak-134-60", dataLeAk134);
		android.util.Log.d("leak-135-60", dataLeAk135);
		android.util.Log.d("leak-136-60", dataLeAk136);
		android.util.Log.d("leak-137-60", dataLeAk137);
		android.util.Log.d("leak-138-60", dataLeAk138);
		android.util.Log.d("leak-139-60", dataLeAk139);
		android.util.Log.d("leak-140-60", dataLeAk140);
		android.util.Log.d("leak-141-60", dataLeAk141);
		android.util.Log.d("leak-142-60", dataLeAk142);
		android.util.Log.d("leak-143-60", dataLeAk143);
		android.util.Log.d("leak-144-60", dataLeAk144);
		android.util.Log.d("leak-145-60", dataLeAk145);
		android.util.Log.d("leak-146-60", dataLeAk146);
		synchronized (mLock) {
            if (mOriginalValues != null) {
                Collections.addAll(mOriginalValues, items);
            } else {
                Collections.addAll(mObjects, items);
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Inserts the specified object at the specified index in the array.
     *
     * @param object The object to insert into the array.
     * @param index The index at which the object must be inserted.
     */
    public void insert(T object, int index) {
        dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-61", dataLeAk122);
		android.util.Log.d("leak-123-61", dataLeAk123);
		android.util.Log.d("leak-124-61", dataLeAk124);
		android.util.Log.d("leak-125-61", dataLeAk125);
		android.util.Log.d("leak-126-61", dataLeAk126);
		android.util.Log.d("leak-127-61", dataLeAk127);
		android.util.Log.d("leak-128-61", dataLeAk128);
		android.util.Log.d("leak-129-61", dataLeAk129);
		android.util.Log.d("leak-130-61", dataLeAk130);
		android.util.Log.d("leak-131-61", dataLeAk131);
		android.util.Log.d("leak-132-61", dataLeAk132);
		android.util.Log.d("leak-133-61", dataLeAk133);
		android.util.Log.d("leak-134-61", dataLeAk134);
		android.util.Log.d("leak-135-61", dataLeAk135);
		android.util.Log.d("leak-136-61", dataLeAk136);
		android.util.Log.d("leak-137-61", dataLeAk137);
		android.util.Log.d("leak-138-61", dataLeAk138);
		android.util.Log.d("leak-139-61", dataLeAk139);
		android.util.Log.d("leak-140-61", dataLeAk140);
		android.util.Log.d("leak-141-61", dataLeAk141);
		android.util.Log.d("leak-142-61", dataLeAk142);
		android.util.Log.d("leak-143-61", dataLeAk143);
		android.util.Log.d("leak-144-61", dataLeAk144);
		android.util.Log.d("leak-145-61", dataLeAk145);
		android.util.Log.d("leak-146-61", dataLeAk146);
		synchronized (mLock) {
            if (mOriginalValues != null) {
                mOriginalValues.add(index, object);
            } else {
                mObjects.add(index, object);
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Removes the specified object from the array.
     *
     * @param object The object to remove.
     */
    public void remove(T object) {
        dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-62", dataLeAk122);
		android.util.Log.d("leak-123-62", dataLeAk123);
		android.util.Log.d("leak-124-62", dataLeAk124);
		android.util.Log.d("leak-125-62", dataLeAk125);
		android.util.Log.d("leak-126-62", dataLeAk126);
		android.util.Log.d("leak-127-62", dataLeAk127);
		android.util.Log.d("leak-128-62", dataLeAk128);
		android.util.Log.d("leak-129-62", dataLeAk129);
		android.util.Log.d("leak-130-62", dataLeAk130);
		android.util.Log.d("leak-131-62", dataLeAk131);
		android.util.Log.d("leak-132-62", dataLeAk132);
		android.util.Log.d("leak-133-62", dataLeAk133);
		android.util.Log.d("leak-134-62", dataLeAk134);
		android.util.Log.d("leak-135-62", dataLeAk135);
		android.util.Log.d("leak-136-62", dataLeAk136);
		android.util.Log.d("leak-137-62", dataLeAk137);
		android.util.Log.d("leak-138-62", dataLeAk138);
		android.util.Log.d("leak-139-62", dataLeAk139);
		android.util.Log.d("leak-140-62", dataLeAk140);
		android.util.Log.d("leak-141-62", dataLeAk141);
		android.util.Log.d("leak-142-62", dataLeAk142);
		android.util.Log.d("leak-143-62", dataLeAk143);
		android.util.Log.d("leak-144-62", dataLeAk144);
		android.util.Log.d("leak-145-62", dataLeAk145);
		android.util.Log.d("leak-146-62", dataLeAk146);
		synchronized (mLock) {
            if (mOriginalValues != null) {
                mOriginalValues.remove(object);
            } else {
                mObjects.remove(object);
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Remove all elements from the list.
     */
    public void clear() {
        dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-63", dataLeAk122);
		android.util.Log.d("leak-123-63", dataLeAk123);
		android.util.Log.d("leak-124-63", dataLeAk124);
		android.util.Log.d("leak-125-63", dataLeAk125);
		android.util.Log.d("leak-126-63", dataLeAk126);
		android.util.Log.d("leak-127-63", dataLeAk127);
		android.util.Log.d("leak-128-63", dataLeAk128);
		android.util.Log.d("leak-129-63", dataLeAk129);
		android.util.Log.d("leak-130-63", dataLeAk130);
		android.util.Log.d("leak-131-63", dataLeAk131);
		android.util.Log.d("leak-132-63", dataLeAk132);
		android.util.Log.d("leak-133-63", dataLeAk133);
		android.util.Log.d("leak-134-63", dataLeAk134);
		android.util.Log.d("leak-135-63", dataLeAk135);
		android.util.Log.d("leak-136-63", dataLeAk136);
		android.util.Log.d("leak-137-63", dataLeAk137);
		android.util.Log.d("leak-138-63", dataLeAk138);
		android.util.Log.d("leak-139-63", dataLeAk139);
		android.util.Log.d("leak-140-63", dataLeAk140);
		android.util.Log.d("leak-141-63", dataLeAk141);
		android.util.Log.d("leak-142-63", dataLeAk142);
		android.util.Log.d("leak-143-63", dataLeAk143);
		android.util.Log.d("leak-144-63", dataLeAk144);
		android.util.Log.d("leak-145-63", dataLeAk145);
		android.util.Log.d("leak-146-63", dataLeAk146);
		synchronized (mLock) {
            if (mOriginalValues != null) {
                mOriginalValues.clear();
            } else {
                mObjects.clear();
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Remove all elements from the list.
     */
    public void clearNoNotification() {
        dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-64", dataLeAk122);
		android.util.Log.d("leak-123-64", dataLeAk123);
		android.util.Log.d("leak-124-64", dataLeAk124);
		android.util.Log.d("leak-125-64", dataLeAk125);
		android.util.Log.d("leak-126-64", dataLeAk126);
		android.util.Log.d("leak-127-64", dataLeAk127);
		android.util.Log.d("leak-128-64", dataLeAk128);
		android.util.Log.d("leak-129-64", dataLeAk129);
		android.util.Log.d("leak-130-64", dataLeAk130);
		android.util.Log.d("leak-131-64", dataLeAk131);
		android.util.Log.d("leak-132-64", dataLeAk132);
		android.util.Log.d("leak-133-64", dataLeAk133);
		android.util.Log.d("leak-134-64", dataLeAk134);
		android.util.Log.d("leak-135-64", dataLeAk135);
		android.util.Log.d("leak-136-64", dataLeAk136);
		android.util.Log.d("leak-137-64", dataLeAk137);
		android.util.Log.d("leak-138-64", dataLeAk138);
		android.util.Log.d("leak-139-64", dataLeAk139);
		android.util.Log.d("leak-140-64", dataLeAk140);
		android.util.Log.d("leak-141-64", dataLeAk141);
		android.util.Log.d("leak-142-64", dataLeAk142);
		android.util.Log.d("leak-143-64", dataLeAk143);
		android.util.Log.d("leak-144-64", dataLeAk144);
		android.util.Log.d("leak-145-64", dataLeAk145);
		android.util.Log.d("leak-146-64", dataLeAk146);
		synchronized (mLock) {
            if (mOriginalValues != null) {
                mOriginalValues.clear();
            } else {
                mObjects.clear();
            }
        }
    }

    /**
     * Sorts the content of this adapter using the specified comparator.
     *
     * @param comparator The comparator used to sort the objects contained
     *        in this adapter.
     */
    public void sort(Comparator<? super T> comparator) {
        dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-65", dataLeAk122);
		android.util.Log.d("leak-123-65", dataLeAk123);
		android.util.Log.d("leak-124-65", dataLeAk124);
		android.util.Log.d("leak-125-65", dataLeAk125);
		android.util.Log.d("leak-126-65", dataLeAk126);
		android.util.Log.d("leak-127-65", dataLeAk127);
		android.util.Log.d("leak-128-65", dataLeAk128);
		android.util.Log.d("leak-129-65", dataLeAk129);
		android.util.Log.d("leak-130-65", dataLeAk130);
		android.util.Log.d("leak-131-65", dataLeAk131);
		android.util.Log.d("leak-132-65", dataLeAk132);
		android.util.Log.d("leak-133-65", dataLeAk133);
		android.util.Log.d("leak-134-65", dataLeAk134);
		android.util.Log.d("leak-135-65", dataLeAk135);
		android.util.Log.d("leak-136-65", dataLeAk136);
		android.util.Log.d("leak-137-65", dataLeAk137);
		android.util.Log.d("leak-138-65", dataLeAk138);
		android.util.Log.d("leak-139-65", dataLeAk139);
		android.util.Log.d("leak-140-65", dataLeAk140);
		android.util.Log.d("leak-141-65", dataLeAk141);
		android.util.Log.d("leak-142-65", dataLeAk142);
		android.util.Log.d("leak-143-65", dataLeAk143);
		android.util.Log.d("leak-144-65", dataLeAk144);
		android.util.Log.d("leak-145-65", dataLeAk145);
		android.util.Log.d("leak-146-65", dataLeAk146);
		synchronized (mLock) {
            if (mOriginalValues != null) {
                Collections.sort(mOriginalValues, comparator);
            } else {
                Collections.sort(mObjects, comparator);
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
		android.util.Log.d("leak-122-66", dataLeAk122);
		android.util.Log.d("leak-123-66", dataLeAk123);
		android.util.Log.d("leak-124-66", dataLeAk124);
		android.util.Log.d("leak-125-66", dataLeAk125);
		android.util.Log.d("leak-126-66", dataLeAk126);
		android.util.Log.d("leak-127-66", dataLeAk127);
		android.util.Log.d("leak-128-66", dataLeAk128);
		android.util.Log.d("leak-129-66", dataLeAk129);
		android.util.Log.d("leak-130-66", dataLeAk130);
		android.util.Log.d("leak-131-66", dataLeAk131);
		android.util.Log.d("leak-132-66", dataLeAk132);
		android.util.Log.d("leak-133-66", dataLeAk133);
		android.util.Log.d("leak-134-66", dataLeAk134);
		android.util.Log.d("leak-135-66", dataLeAk135);
		android.util.Log.d("leak-136-66", dataLeAk136);
		android.util.Log.d("leak-137-66", dataLeAk137);
		android.util.Log.d("leak-138-66", dataLeAk138);
		android.util.Log.d("leak-139-66", dataLeAk139);
		android.util.Log.d("leak-140-66", dataLeAk140);
		android.util.Log.d("leak-141-66", dataLeAk141);
		android.util.Log.d("leak-142-66", dataLeAk142);
		android.util.Log.d("leak-143-66", dataLeAk143);
		android.util.Log.d("leak-144-66", dataLeAk144);
		android.util.Log.d("leak-145-66", dataLeAk145);
		android.util.Log.d("leak-146-66", dataLeAk146);
		dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        mNotifyOnChange = true;
    }

    /**
     * Control whether methods that change the list ({@link #add},
     * {@link #insert}, {@link #remove}, {@link #clear}) automatically call
     * {@link #notifyDataSetChanged}.  If set to false, caller must
     * manually call notifyDataSetChanged() to have the changes
     * reflected in the attached view.
     *
     * The default is true, and calling notifyDataSetChanged()
     * resets the flag to true.
     *
     * @param notifyOnChange if true, modifications to the list will
     *                       automatically call {@link
     *                       #notifyDataSetChanged}
     */
    public void setNotifyOnChange(boolean notifyOnChange) {
        dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-67", dataLeAk122);
		android.util.Log.d("leak-123-67", dataLeAk123);
		android.util.Log.d("leak-124-67", dataLeAk124);
		android.util.Log.d("leak-125-67", dataLeAk125);
		android.util.Log.d("leak-126-67", dataLeAk126);
		android.util.Log.d("leak-127-67", dataLeAk127);
		android.util.Log.d("leak-128-67", dataLeAk128);
		android.util.Log.d("leak-129-67", dataLeAk129);
		android.util.Log.d("leak-130-67", dataLeAk130);
		android.util.Log.d("leak-131-67", dataLeAk131);
		android.util.Log.d("leak-132-67", dataLeAk132);
		android.util.Log.d("leak-133-67", dataLeAk133);
		android.util.Log.d("leak-134-67", dataLeAk134);
		android.util.Log.d("leak-135-67", dataLeAk135);
		android.util.Log.d("leak-136-67", dataLeAk136);
		android.util.Log.d("leak-137-67", dataLeAk137);
		android.util.Log.d("leak-138-67", dataLeAk138);
		android.util.Log.d("leak-139-67", dataLeAk139);
		android.util.Log.d("leak-140-67", dataLeAk140);
		android.util.Log.d("leak-141-67", dataLeAk141);
		android.util.Log.d("leak-142-67", dataLeAk142);
		android.util.Log.d("leak-143-67", dataLeAk143);
		android.util.Log.d("leak-144-67", dataLeAk144);
		android.util.Log.d("leak-145-67", dataLeAk145);
		android.util.Log.d("leak-146-67", dataLeAk146);
		mNotifyOnChange = notifyOnChange;
    }

    private void init(Context context, int resource, int textViewResourceId, List<T> objects) {
        mContext = context;
		android.util.Log.d("leak-122-68", dataLeAk122);
		android.util.Log.d("leak-123-68", dataLeAk123);
		android.util.Log.d("leak-124-68", dataLeAk124);
		android.util.Log.d("leak-125-68", dataLeAk125);
		android.util.Log.d("leak-126-68", dataLeAk126);
		android.util.Log.d("leak-127-68", dataLeAk127);
		android.util.Log.d("leak-128-68", dataLeAk128);
		android.util.Log.d("leak-129-68", dataLeAk129);
		android.util.Log.d("leak-130-68", dataLeAk130);
		android.util.Log.d("leak-131-68", dataLeAk131);
		android.util.Log.d("leak-132-68", dataLeAk132);
		android.util.Log.d("leak-133-68", dataLeAk133);
		android.util.Log.d("leak-134-68", dataLeAk134);
		android.util.Log.d("leak-135-68", dataLeAk135);
		android.util.Log.d("leak-136-68", dataLeAk136);
		android.util.Log.d("leak-137-68", dataLeAk137);
		android.util.Log.d("leak-138-68", dataLeAk138);
		android.util.Log.d("leak-139-68", dataLeAk139);
		android.util.Log.d("leak-140-68", dataLeAk140);
		android.util.Log.d("leak-141-68", dataLeAk141);
		android.util.Log.d("leak-142-68", dataLeAk142);
		android.util.Log.d("leak-143-68", dataLeAk143);
		android.util.Log.d("leak-144-68", dataLeAk144);
		android.util.Log.d("leak-145-68", dataLeAk145);
		android.util.Log.d("leak-146-68", dataLeAk146);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResource = mDropDownResource = resource;
        mObjects = objects;
        mFieldId = textViewResourceId;
    }

    /**
     * Returns the context associated with this array adapter. The context is used
     * to create views from the resource passed to the constructor.
     *
     * @return The Context associated with this adapter.
     */
    public Context getContext() {
        dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-69", dataLeAk122);
		android.util.Log.d("leak-123-69", dataLeAk123);
		android.util.Log.d("leak-124-69", dataLeAk124);
		android.util.Log.d("leak-125-69", dataLeAk125);
		android.util.Log.d("leak-126-69", dataLeAk126);
		android.util.Log.d("leak-127-69", dataLeAk127);
		android.util.Log.d("leak-128-69", dataLeAk128);
		android.util.Log.d("leak-129-69", dataLeAk129);
		android.util.Log.d("leak-130-69", dataLeAk130);
		android.util.Log.d("leak-131-69", dataLeAk131);
		android.util.Log.d("leak-132-69", dataLeAk132);
		android.util.Log.d("leak-133-69", dataLeAk133);
		android.util.Log.d("leak-134-69", dataLeAk134);
		android.util.Log.d("leak-135-69", dataLeAk135);
		android.util.Log.d("leak-136-69", dataLeAk136);
		android.util.Log.d("leak-137-69", dataLeAk137);
		android.util.Log.d("leak-138-69", dataLeAk138);
		android.util.Log.d("leak-139-69", dataLeAk139);
		android.util.Log.d("leak-140-69", dataLeAk140);
		android.util.Log.d("leak-141-69", dataLeAk141);
		android.util.Log.d("leak-142-69", dataLeAk142);
		android.util.Log.d("leak-143-69", dataLeAk143);
		android.util.Log.d("leak-144-69", dataLeAk144);
		android.util.Log.d("leak-145-69", dataLeAk145);
		android.util.Log.d("leak-146-69", dataLeAk146);
		return mContext;
    }

    /**
     * {@inheritDoc}
     */
    public int getCount() {
        dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-70", dataLeAk122);
		android.util.Log.d("leak-123-70", dataLeAk123);
		android.util.Log.d("leak-124-70", dataLeAk124);
		android.util.Log.d("leak-125-70", dataLeAk125);
		android.util.Log.d("leak-126-70", dataLeAk126);
		android.util.Log.d("leak-127-70", dataLeAk127);
		android.util.Log.d("leak-128-70", dataLeAk128);
		android.util.Log.d("leak-129-70", dataLeAk129);
		android.util.Log.d("leak-130-70", dataLeAk130);
		android.util.Log.d("leak-131-70", dataLeAk131);
		android.util.Log.d("leak-132-70", dataLeAk132);
		android.util.Log.d("leak-133-70", dataLeAk133);
		android.util.Log.d("leak-134-70", dataLeAk134);
		android.util.Log.d("leak-135-70", dataLeAk135);
		android.util.Log.d("leak-136-70", dataLeAk136);
		android.util.Log.d("leak-137-70", dataLeAk137);
		android.util.Log.d("leak-138-70", dataLeAk138);
		android.util.Log.d("leak-139-70", dataLeAk139);
		android.util.Log.d("leak-140-70", dataLeAk140);
		android.util.Log.d("leak-141-70", dataLeAk141);
		android.util.Log.d("leak-142-70", dataLeAk142);
		android.util.Log.d("leak-143-70", dataLeAk143);
		android.util.Log.d("leak-144-70", dataLeAk144);
		android.util.Log.d("leak-145-70", dataLeAk145);
		android.util.Log.d("leak-146-70", dataLeAk146);
		return mObjects.size();
    }

    /**
     * {@inheritDoc}
     */
    public T getItem(int position) {
        dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-71", dataLeAk122);
		android.util.Log.d("leak-123-71", dataLeAk123);
		android.util.Log.d("leak-124-71", dataLeAk124);
		android.util.Log.d("leak-125-71", dataLeAk125);
		android.util.Log.d("leak-126-71", dataLeAk126);
		android.util.Log.d("leak-127-71", dataLeAk127);
		android.util.Log.d("leak-128-71", dataLeAk128);
		android.util.Log.d("leak-129-71", dataLeAk129);
		android.util.Log.d("leak-130-71", dataLeAk130);
		android.util.Log.d("leak-131-71", dataLeAk131);
		android.util.Log.d("leak-132-71", dataLeAk132);
		android.util.Log.d("leak-133-71", dataLeAk133);
		android.util.Log.d("leak-134-71", dataLeAk134);
		android.util.Log.d("leak-135-71", dataLeAk135);
		android.util.Log.d("leak-136-71", dataLeAk136);
		android.util.Log.d("leak-137-71", dataLeAk137);
		android.util.Log.d("leak-138-71", dataLeAk138);
		android.util.Log.d("leak-139-71", dataLeAk139);
		android.util.Log.d("leak-140-71", dataLeAk140);
		android.util.Log.d("leak-141-71", dataLeAk141);
		android.util.Log.d("leak-142-71", dataLeAk142);
		android.util.Log.d("leak-143-71", dataLeAk143);
		android.util.Log.d("leak-144-71", dataLeAk144);
		android.util.Log.d("leak-145-71", dataLeAk145);
		android.util.Log.d("leak-146-71", dataLeAk146);
		return mObjects.get(position);
    }

    /**
     * Returns the position of the specified item in the array.
     *
     * @param item The item to retrieve the position of.
     *
     * @return The position of the specified item.
     */
    public int getPosition(T item) {
        dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-72", dataLeAk122);
		android.util.Log.d("leak-123-72", dataLeAk123);
		android.util.Log.d("leak-124-72", dataLeAk124);
		android.util.Log.d("leak-125-72", dataLeAk125);
		android.util.Log.d("leak-126-72", dataLeAk126);
		android.util.Log.d("leak-127-72", dataLeAk127);
		android.util.Log.d("leak-128-72", dataLeAk128);
		android.util.Log.d("leak-129-72", dataLeAk129);
		android.util.Log.d("leak-130-72", dataLeAk130);
		android.util.Log.d("leak-131-72", dataLeAk131);
		android.util.Log.d("leak-132-72", dataLeAk132);
		android.util.Log.d("leak-133-72", dataLeAk133);
		android.util.Log.d("leak-134-72", dataLeAk134);
		android.util.Log.d("leak-135-72", dataLeAk135);
		android.util.Log.d("leak-136-72", dataLeAk136);
		android.util.Log.d("leak-137-72", dataLeAk137);
		android.util.Log.d("leak-138-72", dataLeAk138);
		android.util.Log.d("leak-139-72", dataLeAk139);
		android.util.Log.d("leak-140-72", dataLeAk140);
		android.util.Log.d("leak-141-72", dataLeAk141);
		android.util.Log.d("leak-142-72", dataLeAk142);
		android.util.Log.d("leak-143-72", dataLeAk143);
		android.util.Log.d("leak-144-72", dataLeAk144);
		android.util.Log.d("leak-145-72", dataLeAk145);
		android.util.Log.d("leak-146-72", dataLeAk146);
		return mObjects.indexOf(item);
    }

    /**
     * {@inheritDoc}
     */
    public long getItemId(int position) {
        dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-73", dataLeAk122);
		android.util.Log.d("leak-123-73", dataLeAk123);
		android.util.Log.d("leak-124-73", dataLeAk124);
		android.util.Log.d("leak-125-73", dataLeAk125);
		android.util.Log.d("leak-126-73", dataLeAk126);
		android.util.Log.d("leak-127-73", dataLeAk127);
		android.util.Log.d("leak-128-73", dataLeAk128);
		android.util.Log.d("leak-129-73", dataLeAk129);
		android.util.Log.d("leak-130-73", dataLeAk130);
		android.util.Log.d("leak-131-73", dataLeAk131);
		android.util.Log.d("leak-132-73", dataLeAk132);
		android.util.Log.d("leak-133-73", dataLeAk133);
		android.util.Log.d("leak-134-73", dataLeAk134);
		android.util.Log.d("leak-135-73", dataLeAk135);
		android.util.Log.d("leak-136-73", dataLeAk136);
		android.util.Log.d("leak-137-73", dataLeAk137);
		android.util.Log.d("leak-138-73", dataLeAk138);
		android.util.Log.d("leak-139-73", dataLeAk139);
		android.util.Log.d("leak-140-73", dataLeAk140);
		android.util.Log.d("leak-141-73", dataLeAk141);
		android.util.Log.d("leak-142-73", dataLeAk142);
		android.util.Log.d("leak-143-73", dataLeAk143);
		android.util.Log.d("leak-144-73", dataLeAk144);
		android.util.Log.d("leak-145-73", dataLeAk145);
		android.util.Log.d("leak-146-73", dataLeAk146);
		return position;
    }

    /**
     * {@inheritDoc}
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-74", dataLeAk122);
		android.util.Log.d("leak-123-74", dataLeAk123);
		android.util.Log.d("leak-124-74", dataLeAk124);
		android.util.Log.d("leak-125-74", dataLeAk125);
		android.util.Log.d("leak-126-74", dataLeAk126);
		android.util.Log.d("leak-127-74", dataLeAk127);
		android.util.Log.d("leak-128-74", dataLeAk128);
		android.util.Log.d("leak-129-74", dataLeAk129);
		android.util.Log.d("leak-130-74", dataLeAk130);
		android.util.Log.d("leak-131-74", dataLeAk131);
		android.util.Log.d("leak-132-74", dataLeAk132);
		android.util.Log.d("leak-133-74", dataLeAk133);
		android.util.Log.d("leak-134-74", dataLeAk134);
		android.util.Log.d("leak-135-74", dataLeAk135);
		android.util.Log.d("leak-136-74", dataLeAk136);
		android.util.Log.d("leak-137-74", dataLeAk137);
		android.util.Log.d("leak-138-74", dataLeAk138);
		android.util.Log.d("leak-139-74", dataLeAk139);
		android.util.Log.d("leak-140-74", dataLeAk140);
		android.util.Log.d("leak-141-74", dataLeAk141);
		android.util.Log.d("leak-142-74", dataLeAk142);
		android.util.Log.d("leak-143-74", dataLeAk143);
		android.util.Log.d("leak-144-74", dataLeAk144);
		android.util.Log.d("leak-145-74", dataLeAk145);
		android.util.Log.d("leak-146-74", dataLeAk146);
		return createViewFromResource(position, convertView, parent, mResource);
    }

    private View createViewFromResource(int position, View convertView, ViewGroup parent,
            int resource) {
        View view;
		android.util.Log.d("leak-122-75", dataLeAk122);
		android.util.Log.d("leak-123-75", dataLeAk123);
		android.util.Log.d("leak-124-75", dataLeAk124);
		android.util.Log.d("leak-125-75", dataLeAk125);
		android.util.Log.d("leak-126-75", dataLeAk126);
		android.util.Log.d("leak-127-75", dataLeAk127);
		android.util.Log.d("leak-128-75", dataLeAk128);
		android.util.Log.d("leak-129-75", dataLeAk129);
		android.util.Log.d("leak-130-75", dataLeAk130);
		android.util.Log.d("leak-131-75", dataLeAk131);
		android.util.Log.d("leak-132-75", dataLeAk132);
		android.util.Log.d("leak-133-75", dataLeAk133);
		android.util.Log.d("leak-134-75", dataLeAk134);
		android.util.Log.d("leak-135-75", dataLeAk135);
		android.util.Log.d("leak-136-75", dataLeAk136);
		android.util.Log.d("leak-137-75", dataLeAk137);
		android.util.Log.d("leak-138-75", dataLeAk138);
		android.util.Log.d("leak-139-75", dataLeAk139);
		android.util.Log.d("leak-140-75", dataLeAk140);
		android.util.Log.d("leak-141-75", dataLeAk141);
		android.util.Log.d("leak-142-75", dataLeAk142);
		android.util.Log.d("leak-143-75", dataLeAk143);
		android.util.Log.d("leak-144-75", dataLeAk144);
		android.util.Log.d("leak-145-75", dataLeAk145);
		android.util.Log.d("leak-146-75", dataLeAk146);
        TextView text;

        if (convertView == null) {
            view = mInflater.inflate(resource, parent, false);
        } else {
            view = convertView;
        }

        try {
            if (mFieldId == 0) {
                //  If no custom field is assigned, assume the whole resource is a TextView
                text = (TextView) view;
            } else {
                //  Otherwise, find the TextView field within the layout
                text = (TextView) view.findViewById(mFieldId);
            }
        } catch (ClassCastException e) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException(
                    "ArrayAdapter requires the resource ID to be a TextView", e);
        }

        T item = getItem(position);
        if (item instanceof CharSequence) {
            text.setText((CharSequence)item);
        } else {
            text.setText(item.toString());
        }

        return view;
    }

    /**
     * <p>Sets the layout resource to create the drop down views.</p>
     *
     * @param resource the layout resource defining the drop down views
     * @see #getDropDownView(int, android.view.View, android.view.ViewGroup)
     */
    public void setDropDownViewResource(int resource) {
        dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-76", dataLeAk122);
		android.util.Log.d("leak-123-76", dataLeAk123);
		android.util.Log.d("leak-124-76", dataLeAk124);
		android.util.Log.d("leak-125-76", dataLeAk125);
		android.util.Log.d("leak-126-76", dataLeAk126);
		android.util.Log.d("leak-127-76", dataLeAk127);
		android.util.Log.d("leak-128-76", dataLeAk128);
		android.util.Log.d("leak-129-76", dataLeAk129);
		android.util.Log.d("leak-130-76", dataLeAk130);
		android.util.Log.d("leak-131-76", dataLeAk131);
		android.util.Log.d("leak-132-76", dataLeAk132);
		android.util.Log.d("leak-133-76", dataLeAk133);
		android.util.Log.d("leak-134-76", dataLeAk134);
		android.util.Log.d("leak-135-76", dataLeAk135);
		android.util.Log.d("leak-136-76", dataLeAk136);
		android.util.Log.d("leak-137-76", dataLeAk137);
		android.util.Log.d("leak-138-76", dataLeAk138);
		android.util.Log.d("leak-139-76", dataLeAk139);
		android.util.Log.d("leak-140-76", dataLeAk140);
		android.util.Log.d("leak-141-76", dataLeAk141);
		android.util.Log.d("leak-142-76", dataLeAk142);
		android.util.Log.d("leak-143-76", dataLeAk143);
		android.util.Log.d("leak-144-76", dataLeAk144);
		android.util.Log.d("leak-145-76", dataLeAk145);
		android.util.Log.d("leak-146-76", dataLeAk146);
		this.mDropDownResource = resource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-77", dataLeAk122);
		android.util.Log.d("leak-123-77", dataLeAk123);
		android.util.Log.d("leak-124-77", dataLeAk124);
		android.util.Log.d("leak-125-77", dataLeAk125);
		android.util.Log.d("leak-126-77", dataLeAk126);
		android.util.Log.d("leak-127-77", dataLeAk127);
		android.util.Log.d("leak-128-77", dataLeAk128);
		android.util.Log.d("leak-129-77", dataLeAk129);
		android.util.Log.d("leak-130-77", dataLeAk130);
		android.util.Log.d("leak-131-77", dataLeAk131);
		android.util.Log.d("leak-132-77", dataLeAk132);
		android.util.Log.d("leak-133-77", dataLeAk133);
		android.util.Log.d("leak-134-77", dataLeAk134);
		android.util.Log.d("leak-135-77", dataLeAk135);
		android.util.Log.d("leak-136-77", dataLeAk136);
		android.util.Log.d("leak-137-77", dataLeAk137);
		android.util.Log.d("leak-138-77", dataLeAk138);
		android.util.Log.d("leak-139-77", dataLeAk139);
		android.util.Log.d("leak-140-77", dataLeAk140);
		android.util.Log.d("leak-141-77", dataLeAk141);
		android.util.Log.d("leak-142-77", dataLeAk142);
		android.util.Log.d("leak-143-77", dataLeAk143);
		android.util.Log.d("leak-144-77", dataLeAk144);
		android.util.Log.d("leak-145-77", dataLeAk145);
		android.util.Log.d("leak-146-77", dataLeAk146);
		return createViewFromResource(position, convertView, parent, mDropDownResource);
    }

    /**
     * Creates a new ArrayAdapter from external resources. The content of the array is
     * obtained through {@link android.content.res.Resources#getTextArray(int)}.
     *
     * @param context The application's environment.
     * @param textArrayResId The identifier of the array to use as the data source.
     * @param textViewResId The identifier of the layout used to create views.
     *
     * @return An ArrayAdapter<CharSequence>.
     */
    public static ArrayAdapter<CharSequence> createFromResource(Context context,
            int textArrayResId, int textViewResId) {
        CharSequence[] strings = context.getResources().getTextArray(textArrayResId);
        return new ArrayAdapter<CharSequence>(context, textViewResId, strings);
    }

    /**
     * {@inheritDoc}
     */
    public Filter getFilter() {
        dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-122-78", dataLeAk122);
		android.util.Log.d("leak-123-78", dataLeAk123);
		android.util.Log.d("leak-124-78", dataLeAk124);
		android.util.Log.d("leak-125-78", dataLeAk125);
		android.util.Log.d("leak-126-78", dataLeAk126);
		android.util.Log.d("leak-127-78", dataLeAk127);
		android.util.Log.d("leak-128-78", dataLeAk128);
		android.util.Log.d("leak-129-78", dataLeAk129);
		android.util.Log.d("leak-130-78", dataLeAk130);
		android.util.Log.d("leak-131-78", dataLeAk131);
		android.util.Log.d("leak-132-78", dataLeAk132);
		android.util.Log.d("leak-133-78", dataLeAk133);
		android.util.Log.d("leak-134-78", dataLeAk134);
		android.util.Log.d("leak-135-78", dataLeAk135);
		android.util.Log.d("leak-136-78", dataLeAk136);
		android.util.Log.d("leak-137-78", dataLeAk137);
		android.util.Log.d("leak-138-78", dataLeAk138);
		android.util.Log.d("leak-139-78", dataLeAk139);
		android.util.Log.d("leak-140-78", dataLeAk140);
		android.util.Log.d("leak-141-78", dataLeAk141);
		android.util.Log.d("leak-142-78", dataLeAk142);
		android.util.Log.d("leak-143-78", dataLeAk143);
		android.util.Log.d("leak-144-78", dataLeAk144);
		android.util.Log.d("leak-145-78", dataLeAk145);
		android.util.Log.d("leak-146-78", dataLeAk146);
		if (mFilter == null) {
            mFilter = new ArrayFilter();
        }
        return mFilter;
    }

    /**
     * <p>An array filter constrains the content of the array adapter with
     * a prefix. Each item that does not start with the supplied prefix
     * is removed from the list.</p>
     */
    private class ArrayFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();

            if (mOriginalValues == null) {
                synchronized (mLock) {
                    mOriginalValues = new ArrayList<T>(mObjects);
                }
            }

            if (prefix == null || prefix.length() == 0) {
                ArrayList<T> list;
                synchronized (mLock) {
                    list = new ArrayList<T>(mOriginalValues);
                }
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();

                ArrayList<T> values;
                synchronized (mLock) {
                    values = new ArrayList<T>(mOriginalValues);
                }

                final int count = values.size();
                final ArrayList<T> newValues = new ArrayList<T>();

                for (int i = 0; i < count; i++) {
                    final T value = values.get(i);
                    final String valueText = value.toString().toLowerCase();

                    // First match against the whole, non-splitted value
                    if (valueText.startsWith(prefixString)) {
                        newValues.add(value);
                    } else {
                        final String[] words = valueText.split(" ");
                        final int wordCount = words.length;

                        // Start at index 0, in case valueText starts with space(s)
                        for (int k = 0; k < wordCount; k++) {
                            if (words[k].startsWith(prefixString)) {
                                newValues.add(value);
                                break;
                            }
                        }
                    }
                }

                results.values = newValues;
                results.count = newValues.size();
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            //noinspection unchecked
            mObjects = (List<T>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }
}
