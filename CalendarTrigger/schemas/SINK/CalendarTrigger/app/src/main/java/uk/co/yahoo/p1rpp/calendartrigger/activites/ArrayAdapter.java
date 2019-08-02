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
    String dataLeAk154 = "";

	String dataLeAk152 = "";

	String dataLeAk150 = "";

	String dataLeAk149 = "";

	String dataLeAk148 = "";

	String dataLeAk147 = "";

	String dataLeAk146 = "";

	String dataLeAk145 = "";

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

	String dataLeAk127 = "";

	String dataLeAk126 = "";

	String dataLeAk125 = "";

	String dataLeAk124 = "";

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
        dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-0", dataLeAk124);
		android.util.Log.d("leak-125-0", dataLeAk125);
		android.util.Log.d("leak-126-0", dataLeAk126);
		android.util.Log.d("leak-127-0", dataLeAk127);
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
		android.util.Log.d("leak-145-0", dataLeAk145);
		android.util.Log.d("leak-146-0", dataLeAk146);
		android.util.Log.d("leak-147-0", dataLeAk147);
		android.util.Log.d("leak-148-0", dataLeAk148);
		android.util.Log.d("leak-149-0", dataLeAk149);
		android.util.Log.d("leak-150-0", dataLeAk150);
		android.util.Log.d("leak-152-0", dataLeAk152);
		android.util.Log.d("leak-154-0", dataLeAk154);
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
        dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-1", dataLeAk124);
		android.util.Log.d("leak-125-1", dataLeAk125);
		android.util.Log.d("leak-126-1", dataLeAk126);
		android.util.Log.d("leak-127-1", dataLeAk127);
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
		android.util.Log.d("leak-145-1", dataLeAk145);
		android.util.Log.d("leak-146-1", dataLeAk146);
		android.util.Log.d("leak-147-1", dataLeAk147);
		android.util.Log.d("leak-148-1", dataLeAk148);
		android.util.Log.d("leak-149-1", dataLeAk149);
		android.util.Log.d("leak-150-1", dataLeAk150);
		android.util.Log.d("leak-152-1", dataLeAk152);
		android.util.Log.d("leak-154-1", dataLeAk154);
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
        dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-2", dataLeAk124);
		android.util.Log.d("leak-125-2", dataLeAk125);
		android.util.Log.d("leak-126-2", dataLeAk126);
		android.util.Log.d("leak-127-2", dataLeAk127);
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
		android.util.Log.d("leak-145-2", dataLeAk145);
		android.util.Log.d("leak-146-2", dataLeAk146);
		android.util.Log.d("leak-147-2", dataLeAk147);
		android.util.Log.d("leak-148-2", dataLeAk148);
		android.util.Log.d("leak-149-2", dataLeAk149);
		android.util.Log.d("leak-150-2", dataLeAk150);
		android.util.Log.d("leak-152-2", dataLeAk152);
		android.util.Log.d("leak-154-2", dataLeAk154);
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
        dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-3", dataLeAk124);
		android.util.Log.d("leak-125-3", dataLeAk125);
		android.util.Log.d("leak-126-3", dataLeAk126);
		android.util.Log.d("leak-127-3", dataLeAk127);
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
		android.util.Log.d("leak-145-3", dataLeAk145);
		android.util.Log.d("leak-146-3", dataLeAk146);
		android.util.Log.d("leak-147-3", dataLeAk147);
		android.util.Log.d("leak-148-3", dataLeAk148);
		android.util.Log.d("leak-149-3", dataLeAk149);
		android.util.Log.d("leak-150-3", dataLeAk150);
		android.util.Log.d("leak-152-3", dataLeAk152);
		android.util.Log.d("leak-154-3", dataLeAk154);
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
        dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-4", dataLeAk124);
		android.util.Log.d("leak-125-4", dataLeAk125);
		android.util.Log.d("leak-126-4", dataLeAk126);
		android.util.Log.d("leak-127-4", dataLeAk127);
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
		android.util.Log.d("leak-145-4", dataLeAk145);
		android.util.Log.d("leak-146-4", dataLeAk146);
		android.util.Log.d("leak-147-4", dataLeAk147);
		android.util.Log.d("leak-148-4", dataLeAk148);
		android.util.Log.d("leak-149-4", dataLeAk149);
		android.util.Log.d("leak-150-4", dataLeAk150);
		android.util.Log.d("leak-152-4", dataLeAk152);
		android.util.Log.d("leak-154-4", dataLeAk154);
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
        dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-5", dataLeAk124);
		android.util.Log.d("leak-125-5", dataLeAk125);
		android.util.Log.d("leak-126-5", dataLeAk126);
		android.util.Log.d("leak-127-5", dataLeAk127);
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
		android.util.Log.d("leak-145-5", dataLeAk145);
		android.util.Log.d("leak-146-5", dataLeAk146);
		android.util.Log.d("leak-147-5", dataLeAk147);
		android.util.Log.d("leak-148-5", dataLeAk148);
		android.util.Log.d("leak-149-5", dataLeAk149);
		android.util.Log.d("leak-150-5", dataLeAk150);
		android.util.Log.d("leak-152-5", dataLeAk152);
		android.util.Log.d("leak-154-5", dataLeAk154);
		init(context, resource, textViewResourceId, objects);
    }

    /**
     * Adds the specified object at the end of the array.
     *
     * @param object The object to add at the end of the array.
     */
    public void add(T object) {
        dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-6", dataLeAk124);
		android.util.Log.d("leak-125-6", dataLeAk125);
		android.util.Log.d("leak-126-6", dataLeAk126);
		android.util.Log.d("leak-127-6", dataLeAk127);
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
		android.util.Log.d("leak-145-6", dataLeAk145);
		android.util.Log.d("leak-146-6", dataLeAk146);
		android.util.Log.d("leak-147-6", dataLeAk147);
		android.util.Log.d("leak-148-6", dataLeAk148);
		android.util.Log.d("leak-149-6", dataLeAk149);
		android.util.Log.d("leak-150-6", dataLeAk150);
		android.util.Log.d("leak-152-6", dataLeAk152);
		android.util.Log.d("leak-154-6", dataLeAk154);
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
        dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-7", dataLeAk124);
		android.util.Log.d("leak-125-7", dataLeAk125);
		android.util.Log.d("leak-126-7", dataLeAk126);
		android.util.Log.d("leak-127-7", dataLeAk127);
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
		android.util.Log.d("leak-145-7", dataLeAk145);
		android.util.Log.d("leak-146-7", dataLeAk146);
		android.util.Log.d("leak-147-7", dataLeAk147);
		android.util.Log.d("leak-148-7", dataLeAk148);
		android.util.Log.d("leak-149-7", dataLeAk149);
		android.util.Log.d("leak-150-7", dataLeAk150);
		android.util.Log.d("leak-152-7", dataLeAk152);
		android.util.Log.d("leak-154-7", dataLeAk154);
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
        dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-8", dataLeAk124);
		android.util.Log.d("leak-125-8", dataLeAk125);
		android.util.Log.d("leak-126-8", dataLeAk126);
		android.util.Log.d("leak-127-8", dataLeAk127);
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
		android.util.Log.d("leak-145-8", dataLeAk145);
		android.util.Log.d("leak-146-8", dataLeAk146);
		android.util.Log.d("leak-147-8", dataLeAk147);
		android.util.Log.d("leak-148-8", dataLeAk148);
		android.util.Log.d("leak-149-8", dataLeAk149);
		android.util.Log.d("leak-150-8", dataLeAk150);
		android.util.Log.d("leak-152-8", dataLeAk152);
		android.util.Log.d("leak-154-8", dataLeAk154);
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
        dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-9", dataLeAk124);
		android.util.Log.d("leak-125-9", dataLeAk125);
		android.util.Log.d("leak-126-9", dataLeAk126);
		android.util.Log.d("leak-127-9", dataLeAk127);
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
		android.util.Log.d("leak-145-9", dataLeAk145);
		android.util.Log.d("leak-146-9", dataLeAk146);
		android.util.Log.d("leak-147-9", dataLeAk147);
		android.util.Log.d("leak-148-9", dataLeAk148);
		android.util.Log.d("leak-149-9", dataLeAk149);
		android.util.Log.d("leak-150-9", dataLeAk150);
		android.util.Log.d("leak-152-9", dataLeAk152);
		android.util.Log.d("leak-154-9", dataLeAk154);
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
        dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-10", dataLeAk124);
		android.util.Log.d("leak-125-10", dataLeAk125);
		android.util.Log.d("leak-126-10", dataLeAk126);
		android.util.Log.d("leak-127-10", dataLeAk127);
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
		android.util.Log.d("leak-145-10", dataLeAk145);
		android.util.Log.d("leak-146-10", dataLeAk146);
		android.util.Log.d("leak-147-10", dataLeAk147);
		android.util.Log.d("leak-148-10", dataLeAk148);
		android.util.Log.d("leak-149-10", dataLeAk149);
		android.util.Log.d("leak-150-10", dataLeAk150);
		android.util.Log.d("leak-152-10", dataLeAk152);
		android.util.Log.d("leak-154-10", dataLeAk154);
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
        dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-11", dataLeAk124);
		android.util.Log.d("leak-125-11", dataLeAk125);
		android.util.Log.d("leak-126-11", dataLeAk126);
		android.util.Log.d("leak-127-11", dataLeAk127);
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
		android.util.Log.d("leak-145-11", dataLeAk145);
		android.util.Log.d("leak-146-11", dataLeAk146);
		android.util.Log.d("leak-147-11", dataLeAk147);
		android.util.Log.d("leak-148-11", dataLeAk148);
		android.util.Log.d("leak-149-11", dataLeAk149);
		android.util.Log.d("leak-150-11", dataLeAk150);
		android.util.Log.d("leak-152-11", dataLeAk152);
		android.util.Log.d("leak-154-11", dataLeAk154);
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
        dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-12", dataLeAk124);
		android.util.Log.d("leak-125-12", dataLeAk125);
		android.util.Log.d("leak-126-12", dataLeAk126);
		android.util.Log.d("leak-127-12", dataLeAk127);
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
		android.util.Log.d("leak-145-12", dataLeAk145);
		android.util.Log.d("leak-146-12", dataLeAk146);
		android.util.Log.d("leak-147-12", dataLeAk147);
		android.util.Log.d("leak-148-12", dataLeAk148);
		android.util.Log.d("leak-149-12", dataLeAk149);
		android.util.Log.d("leak-150-12", dataLeAk150);
		android.util.Log.d("leak-152-12", dataLeAk152);
		android.util.Log.d("leak-154-12", dataLeAk154);
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
        dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-13", dataLeAk124);
		android.util.Log.d("leak-125-13", dataLeAk125);
		android.util.Log.d("leak-126-13", dataLeAk126);
		android.util.Log.d("leak-127-13", dataLeAk127);
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
		android.util.Log.d("leak-145-13", dataLeAk145);
		android.util.Log.d("leak-146-13", dataLeAk146);
		android.util.Log.d("leak-147-13", dataLeAk147);
		android.util.Log.d("leak-148-13", dataLeAk148);
		android.util.Log.d("leak-149-13", dataLeAk149);
		android.util.Log.d("leak-150-13", dataLeAk150);
		android.util.Log.d("leak-152-13", dataLeAk152);
		android.util.Log.d("leak-154-13", dataLeAk154);
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
		dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-14", dataLeAk124);
		android.util.Log.d("leak-125-14", dataLeAk125);
		android.util.Log.d("leak-126-14", dataLeAk126);
		android.util.Log.d("leak-127-14", dataLeAk127);
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
		android.util.Log.d("leak-145-14", dataLeAk145);
		android.util.Log.d("leak-146-14", dataLeAk146);
		android.util.Log.d("leak-147-14", dataLeAk147);
		android.util.Log.d("leak-148-14", dataLeAk148);
		android.util.Log.d("leak-149-14", dataLeAk149);
		android.util.Log.d("leak-150-14", dataLeAk150);
		android.util.Log.d("leak-152-14", dataLeAk152);
		android.util.Log.d("leak-154-14", dataLeAk154);
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
        dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-15", dataLeAk124);
		android.util.Log.d("leak-125-15", dataLeAk125);
		android.util.Log.d("leak-126-15", dataLeAk126);
		android.util.Log.d("leak-127-15", dataLeAk127);
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
		android.util.Log.d("leak-145-15", dataLeAk145);
		android.util.Log.d("leak-146-15", dataLeAk146);
		android.util.Log.d("leak-147-15", dataLeAk147);
		android.util.Log.d("leak-148-15", dataLeAk148);
		android.util.Log.d("leak-149-15", dataLeAk149);
		android.util.Log.d("leak-150-15", dataLeAk150);
		android.util.Log.d("leak-152-15", dataLeAk152);
		android.util.Log.d("leak-154-15", dataLeAk154);
		mNotifyOnChange = notifyOnChange;
    }

    private void init(Context context, int resource, int textViewResourceId, List<T> objects) {
        dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-16", dataLeAk124);
		android.util.Log.d("leak-125-16", dataLeAk125);
		android.util.Log.d("leak-126-16", dataLeAk126);
		android.util.Log.d("leak-127-16", dataLeAk127);
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
		android.util.Log.d("leak-145-16", dataLeAk145);
		android.util.Log.d("leak-146-16", dataLeAk146);
		android.util.Log.d("leak-147-16", dataLeAk147);
		android.util.Log.d("leak-148-16", dataLeAk148);
		android.util.Log.d("leak-149-16", dataLeAk149);
		android.util.Log.d("leak-150-16", dataLeAk150);
		android.util.Log.d("leak-152-16", dataLeAk152);
		android.util.Log.d("leak-154-16", dataLeAk154);
		mContext = context;
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
        dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-17", dataLeAk124);
		android.util.Log.d("leak-125-17", dataLeAk125);
		android.util.Log.d("leak-126-17", dataLeAk126);
		android.util.Log.d("leak-127-17", dataLeAk127);
		android.util.Log.d("leak-128-17", dataLeAk128);
		android.util.Log.d("leak-129-17", dataLeAk129);
		android.util.Log.d("leak-130-17", dataLeAk130);
		android.util.Log.d("leak-131-17", dataLeAk131);
		android.util.Log.d("leak-132-17", dataLeAk132);
		android.util.Log.d("leak-133-17", dataLeAk133);
		android.util.Log.d("leak-134-17", dataLeAk134);
		android.util.Log.d("leak-135-17", dataLeAk135);
		android.util.Log.d("leak-136-17", dataLeAk136);
		android.util.Log.d("leak-137-17", dataLeAk137);
		android.util.Log.d("leak-138-17", dataLeAk138);
		android.util.Log.d("leak-139-17", dataLeAk139);
		android.util.Log.d("leak-140-17", dataLeAk140);
		android.util.Log.d("leak-141-17", dataLeAk141);
		android.util.Log.d("leak-142-17", dataLeAk142);
		android.util.Log.d("leak-143-17", dataLeAk143);
		android.util.Log.d("leak-144-17", dataLeAk144);
		android.util.Log.d("leak-145-17", dataLeAk145);
		android.util.Log.d("leak-146-17", dataLeAk146);
		android.util.Log.d("leak-147-17", dataLeAk147);
		android.util.Log.d("leak-148-17", dataLeAk148);
		android.util.Log.d("leak-149-17", dataLeAk149);
		android.util.Log.d("leak-150-17", dataLeAk150);
		android.util.Log.d("leak-152-17", dataLeAk152);
		android.util.Log.d("leak-154-17", dataLeAk154);
		return mContext;
    }

    /**
     * {@inheritDoc}
     */
    public int getCount() {
        dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-18", dataLeAk124);
		android.util.Log.d("leak-125-18", dataLeAk125);
		android.util.Log.d("leak-126-18", dataLeAk126);
		android.util.Log.d("leak-127-18", dataLeAk127);
		android.util.Log.d("leak-128-18", dataLeAk128);
		android.util.Log.d("leak-129-18", dataLeAk129);
		android.util.Log.d("leak-130-18", dataLeAk130);
		android.util.Log.d("leak-131-18", dataLeAk131);
		android.util.Log.d("leak-132-18", dataLeAk132);
		android.util.Log.d("leak-133-18", dataLeAk133);
		android.util.Log.d("leak-134-18", dataLeAk134);
		android.util.Log.d("leak-135-18", dataLeAk135);
		android.util.Log.d("leak-136-18", dataLeAk136);
		android.util.Log.d("leak-137-18", dataLeAk137);
		android.util.Log.d("leak-138-18", dataLeAk138);
		android.util.Log.d("leak-139-18", dataLeAk139);
		android.util.Log.d("leak-140-18", dataLeAk140);
		android.util.Log.d("leak-141-18", dataLeAk141);
		android.util.Log.d("leak-142-18", dataLeAk142);
		android.util.Log.d("leak-143-18", dataLeAk143);
		android.util.Log.d("leak-144-18", dataLeAk144);
		android.util.Log.d("leak-145-18", dataLeAk145);
		android.util.Log.d("leak-146-18", dataLeAk146);
		android.util.Log.d("leak-147-18", dataLeAk147);
		android.util.Log.d("leak-148-18", dataLeAk148);
		android.util.Log.d("leak-149-18", dataLeAk149);
		android.util.Log.d("leak-150-18", dataLeAk150);
		android.util.Log.d("leak-152-18", dataLeAk152);
		android.util.Log.d("leak-154-18", dataLeAk154);
		return mObjects.size();
    }

    /**
     * {@inheritDoc}
     */
    public T getItem(int position) {
        dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-19", dataLeAk124);
		android.util.Log.d("leak-125-19", dataLeAk125);
		android.util.Log.d("leak-126-19", dataLeAk126);
		android.util.Log.d("leak-127-19", dataLeAk127);
		android.util.Log.d("leak-128-19", dataLeAk128);
		android.util.Log.d("leak-129-19", dataLeAk129);
		android.util.Log.d("leak-130-19", dataLeAk130);
		android.util.Log.d("leak-131-19", dataLeAk131);
		android.util.Log.d("leak-132-19", dataLeAk132);
		android.util.Log.d("leak-133-19", dataLeAk133);
		android.util.Log.d("leak-134-19", dataLeAk134);
		android.util.Log.d("leak-135-19", dataLeAk135);
		android.util.Log.d("leak-136-19", dataLeAk136);
		android.util.Log.d("leak-137-19", dataLeAk137);
		android.util.Log.d("leak-138-19", dataLeAk138);
		android.util.Log.d("leak-139-19", dataLeAk139);
		android.util.Log.d("leak-140-19", dataLeAk140);
		android.util.Log.d("leak-141-19", dataLeAk141);
		android.util.Log.d("leak-142-19", dataLeAk142);
		android.util.Log.d("leak-143-19", dataLeAk143);
		android.util.Log.d("leak-144-19", dataLeAk144);
		android.util.Log.d("leak-145-19", dataLeAk145);
		android.util.Log.d("leak-146-19", dataLeAk146);
		android.util.Log.d("leak-147-19", dataLeAk147);
		android.util.Log.d("leak-148-19", dataLeAk148);
		android.util.Log.d("leak-149-19", dataLeAk149);
		android.util.Log.d("leak-150-19", dataLeAk150);
		android.util.Log.d("leak-152-19", dataLeAk152);
		android.util.Log.d("leak-154-19", dataLeAk154);
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
        dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-20", dataLeAk124);
		android.util.Log.d("leak-125-20", dataLeAk125);
		android.util.Log.d("leak-126-20", dataLeAk126);
		android.util.Log.d("leak-127-20", dataLeAk127);
		android.util.Log.d("leak-128-20", dataLeAk128);
		android.util.Log.d("leak-129-20", dataLeAk129);
		android.util.Log.d("leak-130-20", dataLeAk130);
		android.util.Log.d("leak-131-20", dataLeAk131);
		android.util.Log.d("leak-132-20", dataLeAk132);
		android.util.Log.d("leak-133-20", dataLeAk133);
		android.util.Log.d("leak-134-20", dataLeAk134);
		android.util.Log.d("leak-135-20", dataLeAk135);
		android.util.Log.d("leak-136-20", dataLeAk136);
		android.util.Log.d("leak-137-20", dataLeAk137);
		android.util.Log.d("leak-138-20", dataLeAk138);
		android.util.Log.d("leak-139-20", dataLeAk139);
		android.util.Log.d("leak-140-20", dataLeAk140);
		android.util.Log.d("leak-141-20", dataLeAk141);
		android.util.Log.d("leak-142-20", dataLeAk142);
		android.util.Log.d("leak-143-20", dataLeAk143);
		android.util.Log.d("leak-144-20", dataLeAk144);
		android.util.Log.d("leak-145-20", dataLeAk145);
		android.util.Log.d("leak-146-20", dataLeAk146);
		android.util.Log.d("leak-147-20", dataLeAk147);
		android.util.Log.d("leak-148-20", dataLeAk148);
		android.util.Log.d("leak-149-20", dataLeAk149);
		android.util.Log.d("leak-150-20", dataLeAk150);
		android.util.Log.d("leak-152-20", dataLeAk152);
		android.util.Log.d("leak-154-20", dataLeAk154);
		return mObjects.indexOf(item);
    }

    /**
     * {@inheritDoc}
     */
    public long getItemId(int position) {
        dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-21", dataLeAk124);
		android.util.Log.d("leak-125-21", dataLeAk125);
		android.util.Log.d("leak-126-21", dataLeAk126);
		android.util.Log.d("leak-127-21", dataLeAk127);
		android.util.Log.d("leak-128-21", dataLeAk128);
		android.util.Log.d("leak-129-21", dataLeAk129);
		android.util.Log.d("leak-130-21", dataLeAk130);
		android.util.Log.d("leak-131-21", dataLeAk131);
		android.util.Log.d("leak-132-21", dataLeAk132);
		android.util.Log.d("leak-133-21", dataLeAk133);
		android.util.Log.d("leak-134-21", dataLeAk134);
		android.util.Log.d("leak-135-21", dataLeAk135);
		android.util.Log.d("leak-136-21", dataLeAk136);
		android.util.Log.d("leak-137-21", dataLeAk137);
		android.util.Log.d("leak-138-21", dataLeAk138);
		android.util.Log.d("leak-139-21", dataLeAk139);
		android.util.Log.d("leak-140-21", dataLeAk140);
		android.util.Log.d("leak-141-21", dataLeAk141);
		android.util.Log.d("leak-142-21", dataLeAk142);
		android.util.Log.d("leak-143-21", dataLeAk143);
		android.util.Log.d("leak-144-21", dataLeAk144);
		android.util.Log.d("leak-145-21", dataLeAk145);
		android.util.Log.d("leak-146-21", dataLeAk146);
		android.util.Log.d("leak-147-21", dataLeAk147);
		android.util.Log.d("leak-148-21", dataLeAk148);
		android.util.Log.d("leak-149-21", dataLeAk149);
		android.util.Log.d("leak-150-21", dataLeAk150);
		android.util.Log.d("leak-152-21", dataLeAk152);
		android.util.Log.d("leak-154-21", dataLeAk154);
		return position;
    }

    /**
     * {@inheritDoc}
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-22", dataLeAk124);
		android.util.Log.d("leak-125-22", dataLeAk125);
		android.util.Log.d("leak-126-22", dataLeAk126);
		android.util.Log.d("leak-127-22", dataLeAk127);
		android.util.Log.d("leak-128-22", dataLeAk128);
		android.util.Log.d("leak-129-22", dataLeAk129);
		android.util.Log.d("leak-130-22", dataLeAk130);
		android.util.Log.d("leak-131-22", dataLeAk131);
		android.util.Log.d("leak-132-22", dataLeAk132);
		android.util.Log.d("leak-133-22", dataLeAk133);
		android.util.Log.d("leak-134-22", dataLeAk134);
		android.util.Log.d("leak-135-22", dataLeAk135);
		android.util.Log.d("leak-136-22", dataLeAk136);
		android.util.Log.d("leak-137-22", dataLeAk137);
		android.util.Log.d("leak-138-22", dataLeAk138);
		android.util.Log.d("leak-139-22", dataLeAk139);
		android.util.Log.d("leak-140-22", dataLeAk140);
		android.util.Log.d("leak-141-22", dataLeAk141);
		android.util.Log.d("leak-142-22", dataLeAk142);
		android.util.Log.d("leak-143-22", dataLeAk143);
		android.util.Log.d("leak-144-22", dataLeAk144);
		android.util.Log.d("leak-145-22", dataLeAk145);
		android.util.Log.d("leak-146-22", dataLeAk146);
		android.util.Log.d("leak-147-22", dataLeAk147);
		android.util.Log.d("leak-148-22", dataLeAk148);
		android.util.Log.d("leak-149-22", dataLeAk149);
		android.util.Log.d("leak-150-22", dataLeAk150);
		android.util.Log.d("leak-152-22", dataLeAk152);
		android.util.Log.d("leak-154-22", dataLeAk154);
		return createViewFromResource(position, convertView, parent, mResource);
    }

    private View createViewFromResource(int position, View convertView, ViewGroup parent,
            int resource) {
        dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-23", dataLeAk124);
		android.util.Log.d("leak-125-23", dataLeAk125);
		android.util.Log.d("leak-126-23", dataLeAk126);
		android.util.Log.d("leak-127-23", dataLeAk127);
		android.util.Log.d("leak-128-23", dataLeAk128);
		android.util.Log.d("leak-129-23", dataLeAk129);
		android.util.Log.d("leak-130-23", dataLeAk130);
		android.util.Log.d("leak-131-23", dataLeAk131);
		android.util.Log.d("leak-132-23", dataLeAk132);
		android.util.Log.d("leak-133-23", dataLeAk133);
		android.util.Log.d("leak-134-23", dataLeAk134);
		android.util.Log.d("leak-135-23", dataLeAk135);
		android.util.Log.d("leak-136-23", dataLeAk136);
		android.util.Log.d("leak-137-23", dataLeAk137);
		android.util.Log.d("leak-138-23", dataLeAk138);
		android.util.Log.d("leak-139-23", dataLeAk139);
		android.util.Log.d("leak-140-23", dataLeAk140);
		android.util.Log.d("leak-141-23", dataLeAk141);
		android.util.Log.d("leak-142-23", dataLeAk142);
		android.util.Log.d("leak-143-23", dataLeAk143);
		android.util.Log.d("leak-144-23", dataLeAk144);
		android.util.Log.d("leak-145-23", dataLeAk145);
		android.util.Log.d("leak-146-23", dataLeAk146);
		android.util.Log.d("leak-147-23", dataLeAk147);
		android.util.Log.d("leak-148-23", dataLeAk148);
		android.util.Log.d("leak-149-23", dataLeAk149);
		android.util.Log.d("leak-150-23", dataLeAk150);
		android.util.Log.d("leak-152-23", dataLeAk152);
		android.util.Log.d("leak-154-23", dataLeAk154);
		View view;
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
        dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-24", dataLeAk124);
		android.util.Log.d("leak-125-24", dataLeAk125);
		android.util.Log.d("leak-126-24", dataLeAk126);
		android.util.Log.d("leak-127-24", dataLeAk127);
		android.util.Log.d("leak-128-24", dataLeAk128);
		android.util.Log.d("leak-129-24", dataLeAk129);
		android.util.Log.d("leak-130-24", dataLeAk130);
		android.util.Log.d("leak-131-24", dataLeAk131);
		android.util.Log.d("leak-132-24", dataLeAk132);
		android.util.Log.d("leak-133-24", dataLeAk133);
		android.util.Log.d("leak-134-24", dataLeAk134);
		android.util.Log.d("leak-135-24", dataLeAk135);
		android.util.Log.d("leak-136-24", dataLeAk136);
		android.util.Log.d("leak-137-24", dataLeAk137);
		android.util.Log.d("leak-138-24", dataLeAk138);
		android.util.Log.d("leak-139-24", dataLeAk139);
		android.util.Log.d("leak-140-24", dataLeAk140);
		android.util.Log.d("leak-141-24", dataLeAk141);
		android.util.Log.d("leak-142-24", dataLeAk142);
		android.util.Log.d("leak-143-24", dataLeAk143);
		android.util.Log.d("leak-144-24", dataLeAk144);
		android.util.Log.d("leak-145-24", dataLeAk145);
		android.util.Log.d("leak-146-24", dataLeAk146);
		android.util.Log.d("leak-147-24", dataLeAk147);
		android.util.Log.d("leak-148-24", dataLeAk148);
		android.util.Log.d("leak-149-24", dataLeAk149);
		android.util.Log.d("leak-150-24", dataLeAk150);
		android.util.Log.d("leak-152-24", dataLeAk152);
		android.util.Log.d("leak-154-24", dataLeAk154);
		this.mDropDownResource = resource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-25", dataLeAk124);
		android.util.Log.d("leak-125-25", dataLeAk125);
		android.util.Log.d("leak-126-25", dataLeAk126);
		android.util.Log.d("leak-127-25", dataLeAk127);
		android.util.Log.d("leak-128-25", dataLeAk128);
		android.util.Log.d("leak-129-25", dataLeAk129);
		android.util.Log.d("leak-130-25", dataLeAk130);
		android.util.Log.d("leak-131-25", dataLeAk131);
		android.util.Log.d("leak-132-25", dataLeAk132);
		android.util.Log.d("leak-133-25", dataLeAk133);
		android.util.Log.d("leak-134-25", dataLeAk134);
		android.util.Log.d("leak-135-25", dataLeAk135);
		android.util.Log.d("leak-136-25", dataLeAk136);
		android.util.Log.d("leak-137-25", dataLeAk137);
		android.util.Log.d("leak-138-25", dataLeAk138);
		android.util.Log.d("leak-139-25", dataLeAk139);
		android.util.Log.d("leak-140-25", dataLeAk140);
		android.util.Log.d("leak-141-25", dataLeAk141);
		android.util.Log.d("leak-142-25", dataLeAk142);
		android.util.Log.d("leak-143-25", dataLeAk143);
		android.util.Log.d("leak-144-25", dataLeAk144);
		android.util.Log.d("leak-145-25", dataLeAk145);
		android.util.Log.d("leak-146-25", dataLeAk146);
		android.util.Log.d("leak-147-25", dataLeAk147);
		android.util.Log.d("leak-148-25", dataLeAk148);
		android.util.Log.d("leak-149-25", dataLeAk149);
		android.util.Log.d("leak-150-25", dataLeAk150);
		android.util.Log.d("leak-152-25", dataLeAk152);
		android.util.Log.d("leak-154-25", dataLeAk154);
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
        dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-124-26", dataLeAk124);
		android.util.Log.d("leak-125-26", dataLeAk125);
		android.util.Log.d("leak-126-26", dataLeAk126);
		android.util.Log.d("leak-127-26", dataLeAk127);
		android.util.Log.d("leak-128-26", dataLeAk128);
		android.util.Log.d("leak-129-26", dataLeAk129);
		android.util.Log.d("leak-130-26", dataLeAk130);
		android.util.Log.d("leak-131-26", dataLeAk131);
		android.util.Log.d("leak-132-26", dataLeAk132);
		android.util.Log.d("leak-133-26", dataLeAk133);
		android.util.Log.d("leak-134-26", dataLeAk134);
		android.util.Log.d("leak-135-26", dataLeAk135);
		android.util.Log.d("leak-136-26", dataLeAk136);
		android.util.Log.d("leak-137-26", dataLeAk137);
		android.util.Log.d("leak-138-26", dataLeAk138);
		android.util.Log.d("leak-139-26", dataLeAk139);
		android.util.Log.d("leak-140-26", dataLeAk140);
		android.util.Log.d("leak-141-26", dataLeAk141);
		android.util.Log.d("leak-142-26", dataLeAk142);
		android.util.Log.d("leak-143-26", dataLeAk143);
		android.util.Log.d("leak-144-26", dataLeAk144);
		android.util.Log.d("leak-145-26", dataLeAk145);
		android.util.Log.d("leak-146-26", dataLeAk146);
		android.util.Log.d("leak-147-26", dataLeAk147);
		android.util.Log.d("leak-148-26", dataLeAk148);
		android.util.Log.d("leak-149-26", dataLeAk149);
		android.util.Log.d("leak-150-26", dataLeAk150);
		android.util.Log.d("leak-152-26", dataLeAk152);
		android.util.Log.d("leak-154-26", dataLeAk154);
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
        String dataLeAk153 = "";

		String dataLeAk151 = "";

		@Override
        protected FilterResults performFiltering(CharSequence prefix) {
            dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-124-27", dataLeAk124);
			android.util.Log.d("leak-125-27", dataLeAk125);
			android.util.Log.d("leak-126-27", dataLeAk126);
			android.util.Log.d("leak-127-27", dataLeAk127);
			android.util.Log.d("leak-128-27", dataLeAk128);
			android.util.Log.d("leak-129-27", dataLeAk129);
			android.util.Log.d("leak-130-27", dataLeAk130);
			android.util.Log.d("leak-131-27", dataLeAk131);
			android.util.Log.d("leak-132-27", dataLeAk132);
			android.util.Log.d("leak-133-27", dataLeAk133);
			android.util.Log.d("leak-134-27", dataLeAk134);
			android.util.Log.d("leak-135-27", dataLeAk135);
			android.util.Log.d("leak-136-27", dataLeAk136);
			android.util.Log.d("leak-137-27", dataLeAk137);
			android.util.Log.d("leak-138-27", dataLeAk138);
			android.util.Log.d("leak-139-27", dataLeAk139);
			android.util.Log.d("leak-140-27", dataLeAk140);
			android.util.Log.d("leak-141-27", dataLeAk141);
			android.util.Log.d("leak-142-27", dataLeAk142);
			android.util.Log.d("leak-143-27", dataLeAk143);
			android.util.Log.d("leak-144-27", dataLeAk144);
			android.util.Log.d("leak-145-27", dataLeAk145);
			android.util.Log.d("leak-146-27", dataLeAk146);
			android.util.Log.d("leak-147-27", dataLeAk147);
			android.util.Log.d("leak-148-27", dataLeAk148);
			android.util.Log.d("leak-149-27", dataLeAk149);
			android.util.Log.d("leak-150-27", dataLeAk150);
			android.util.Log.d("leak-152-27", dataLeAk152);
			android.util.Log.d("leak-154-27", dataLeAk154);
			android.util.Log.d("leak-151-0", dataLeAk151);
			android.util.Log.d("leak-153-0", dataLeAk153);
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
            dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-124-28", dataLeAk124);
			android.util.Log.d("leak-125-28", dataLeAk125);
			android.util.Log.d("leak-126-28", dataLeAk126);
			android.util.Log.d("leak-127-28", dataLeAk127);
			android.util.Log.d("leak-128-28", dataLeAk128);
			android.util.Log.d("leak-129-28", dataLeAk129);
			android.util.Log.d("leak-130-28", dataLeAk130);
			android.util.Log.d("leak-131-28", dataLeAk131);
			android.util.Log.d("leak-132-28", dataLeAk132);
			android.util.Log.d("leak-133-28", dataLeAk133);
			android.util.Log.d("leak-134-28", dataLeAk134);
			android.util.Log.d("leak-135-28", dataLeAk135);
			android.util.Log.d("leak-136-28", dataLeAk136);
			android.util.Log.d("leak-137-28", dataLeAk137);
			android.util.Log.d("leak-138-28", dataLeAk138);
			android.util.Log.d("leak-139-28", dataLeAk139);
			android.util.Log.d("leak-140-28", dataLeAk140);
			android.util.Log.d("leak-141-28", dataLeAk141);
			android.util.Log.d("leak-142-28", dataLeAk142);
			android.util.Log.d("leak-143-28", dataLeAk143);
			android.util.Log.d("leak-144-28", dataLeAk144);
			android.util.Log.d("leak-145-28", dataLeAk145);
			android.util.Log.d("leak-146-28", dataLeAk146);
			android.util.Log.d("leak-147-28", dataLeAk147);
			android.util.Log.d("leak-148-28", dataLeAk148);
			android.util.Log.d("leak-149-28", dataLeAk149);
			android.util.Log.d("leak-150-28", dataLeAk150);
			android.util.Log.d("leak-152-28", dataLeAk152);
			android.util.Log.d("leak-154-28", dataLeAk154);
			android.util.Log.d("leak-151-1", dataLeAk151);
			android.util.Log.d("leak-153-1", dataLeAk153);
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
