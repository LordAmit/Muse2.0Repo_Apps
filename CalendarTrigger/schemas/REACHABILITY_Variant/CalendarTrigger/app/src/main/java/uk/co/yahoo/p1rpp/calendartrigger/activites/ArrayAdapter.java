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
    String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk244 = android.util.Log.d("leak-244", dataLeAk244);

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
        String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk245 = android.util.Log.d("leak-245", dataLeAk245);
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
        String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk246 = android.util.Log.d("leak-246", dataLeAk246);
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
        String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk247 = android.util.Log.d("leak-247", dataLeAk247);
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
        String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk248 = android.util.Log.d("leak-248", dataLeAk248);
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
        String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk249 = android.util.Log.d("leak-249", dataLeAk249);
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
        String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk250 = android.util.Log.d("leak-250", dataLeAk250);
		init(context, resource, textViewResourceId, objects);
    }

    /**
     * Adds the specified object at the end of the array.
     *
     * @param object The object to add at the end of the array.
     */
    public void add(T object) {
        String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk251 = android.util.Log.d("leak-251", dataLeAk251);
		synchronized (mLock) {
            String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk252 = android.util.Log.d("leak-252", dataLeAk252);
			if (mOriginalValues != null) {
                String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk253 = android.util.Log.d("leak-253", dataLeAk253);
				mOriginalValues.add(object);
            } else {
                String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk254 = android.util.Log.d("leak-254", dataLeAk254);
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
        String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk255 = android.util.Log.d("leak-255", dataLeAk255);
		synchronized (mLock) {
            String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk256 = android.util.Log.d("leak-256", dataLeAk256);
			if (mOriginalValues != null) {
                String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk257 = android.util.Log.d("leak-257", dataLeAk257);
				mOriginalValues.addAll(collection);
            } else {
                String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk258 = android.util.Log.d("leak-258", dataLeAk258);
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
        String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk259 = android.util.Log.d("leak-259", dataLeAk259);
		synchronized (mLock) {
            String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk260 = android.util.Log.d("leak-260", dataLeAk260);
			if (mOriginalValues != null) {
                String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk261 = android.util.Log.d("leak-261", dataLeAk261);
				Collections.addAll(mOriginalValues, items);
            } else {
                String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk262 = android.util.Log.d("leak-262", dataLeAk262);
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
        String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk263 = android.util.Log.d("leak-263", dataLeAk263);
		synchronized (mLock) {
            String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk264 = android.util.Log.d("leak-264", dataLeAk264);
			if (mOriginalValues != null) {
                String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk265 = android.util.Log.d("leak-265", dataLeAk265);
				mOriginalValues.add(index, object);
            } else {
                String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk266 = android.util.Log.d("leak-266", dataLeAk266);
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
        String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk267 = android.util.Log.d("leak-267", dataLeAk267);
		synchronized (mLock) {
            String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk268 = android.util.Log.d("leak-268", dataLeAk268);
			if (mOriginalValues != null) {
                String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk269 = android.util.Log.d("leak-269", dataLeAk269);
				mOriginalValues.remove(object);
            } else {
                String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk270 = android.util.Log.d("leak-270", dataLeAk270);
				mObjects.remove(object);
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Remove all elements from the list.
     */
    public void clear() {
        String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk271 = android.util.Log.d("leak-271", dataLeAk271);
		synchronized (mLock) {
            String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk272 = android.util.Log.d("leak-272", dataLeAk272);
			if (mOriginalValues != null) {
                String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk273 = android.util.Log.d("leak-273", dataLeAk273);
				mOriginalValues.clear();
            } else {
                String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk274 = android.util.Log.d("leak-274", dataLeAk274);
				mObjects.clear();
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Remove all elements from the list.
     */
    public void clearNoNotification() {
        String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk275 = android.util.Log.d("leak-275", dataLeAk275);
		synchronized (mLock) {
            String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk276 = android.util.Log.d("leak-276", dataLeAk276);
			if (mOriginalValues != null) {
                String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk277 = android.util.Log.d("leak-277", dataLeAk277);
				mOriginalValues.clear();
            } else {
                String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk278 = android.util.Log.d("leak-278", dataLeAk278);
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
        String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk279 = android.util.Log.d("leak-279", dataLeAk279);
		synchronized (mLock) {
            String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk280 = android.util.Log.d("leak-280", dataLeAk280);
			if (mOriginalValues != null) {
                String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk281 = android.util.Log.d("leak-281", dataLeAk281);
				Collections.sort(mOriginalValues, comparator);
            } else {
                String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk282 = android.util.Log.d("leak-282", dataLeAk282);
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
		String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk283 = android.util.Log.d("leak-283", dataLeAk283);
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
        String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk284 = android.util.Log.d("leak-284", dataLeAk284);
		mNotifyOnChange = notifyOnChange;
    }

    private void init(Context context, int resource, int textViewResourceId, List<T> objects) {
        String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk285 = android.util.Log.d("leak-285", dataLeAk285);
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
        String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk286 = android.util.Log.d("leak-286", dataLeAk286);
		return mContext;
    }

    /**
     * {@inheritDoc}
     */
    public int getCount() {
        String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk287 = android.util.Log.d("leak-287", dataLeAk287);
		return mObjects.size();
    }

    /**
     * {@inheritDoc}
     */
    public T getItem(int position) {
        String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk288 = android.util.Log.d("leak-288", dataLeAk288);
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
        String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk289 = android.util.Log.d("leak-289", dataLeAk289);
		return mObjects.indexOf(item);
    }

    /**
     * {@inheritDoc}
     */
    public long getItemId(int position) {
        String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk290 = android.util.Log.d("leak-290", dataLeAk290);
		return position;
    }

    /**
     * {@inheritDoc}
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk291 = android.util.Log.d("leak-291", dataLeAk291);
		return createViewFromResource(position, convertView, parent, mResource);
    }

    private View createViewFromResource(int position, View convertView, ViewGroup parent,
            int resource) {
        String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk292 = android.util.Log.d("leak-292", dataLeAk292);
		View view;
        TextView text;

        if (convertView == null) {
            String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk293 = android.util.Log.d("leak-293", dataLeAk293);
			view = mInflater.inflate(resource, parent, false);
        } else {
            String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk294 = android.util.Log.d("leak-294", dataLeAk294);
			view = convertView;
        }

        try {
            String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk295 = android.util.Log.d("leak-295", dataLeAk295);
			if (mFieldId == 0) {
                String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk296 = android.util.Log.d("leak-296", dataLeAk296);
				//  If no custom field is assigned, assume the whole resource is a TextView
                text = (TextView) view;
            } else {
                String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk297 = android.util.Log.d("leak-297", dataLeAk297);
				//  Otherwise, find the TextView field within the layout
                text = (TextView) view.findViewById(mFieldId);
            }
        } catch (ClassCastException e) {
            String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk298 = android.util.Log.d("leak-298", dataLeAk298);
			Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException(
                    "ArrayAdapter requires the resource ID to be a TextView", e);
        }

        T item = getItem(position);
        if (item instanceof CharSequence) {
            String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk299 = android.util.Log.d("leak-299", dataLeAk299);
			text.setText((CharSequence)item);
        } else {
            String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk300 = android.util.Log.d("leak-300", dataLeAk300);
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
        String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk301 = android.util.Log.d("leak-301", dataLeAk301);
		this.mDropDownResource = resource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk302 = android.util.Log.d("leak-302", dataLeAk302);
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
        String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk303 = android.util.Log.d("leak-303", dataLeAk303);
		CharSequence[] strings = context.getResources().getTextArray(textArrayResId);
        return new ArrayAdapter<CharSequence>(context, textViewResId, strings);
    }

    /**
     * {@inheritDoc}
     */
    public Filter getFilter() {
        String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk304 = android.util.Log.d("leak-304", dataLeAk304);
		if (mFilter == null) {
            String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk305 = android.util.Log.d("leak-305", dataLeAk305);
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
        String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk306 = android.util.Log.d("leak-306", dataLeAk306);

		@Override
        protected FilterResults performFiltering(CharSequence prefix) {
            String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk307 = android.util.Log.d("leak-307", dataLeAk307);
			FilterResults results = new FilterResults();

            if (mOriginalValues == null) {
                String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk308 = android.util.Log.d("leak-308", dataLeAk308);
				synchronized (mLock) {
                    String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk309 = android.util.Log.d("leak-309", dataLeAk309);
					mOriginalValues = new ArrayList<T>(mObjects);
                }
            }

            if (prefix == null || prefix.length() == 0) {
                String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk310 = android.util.Log.d("leak-310", dataLeAk310);
				ArrayList<T> list;
                synchronized (mLock) {
                    String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk311 = android.util.Log.d("leak-311", dataLeAk311);
					list = new ArrayList<T>(mOriginalValues);
                }
                results.values = list;
                results.count = list.size();
            } else {
                String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk312 = android.util.Log.d("leak-312", dataLeAk312);
				String prefixString = prefix.toString().toLowerCase();

                ArrayList<T> values;
                synchronized (mLock) {
                    String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk313 = android.util.Log.d("leak-313", dataLeAk313);
					values = new ArrayList<T>(mOriginalValues);
                }

                final int count = values.size();
                final ArrayList<T> newValues = new ArrayList<T>();

                for (int i = 0; i < count; i++) {
                    String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk314 = android.util.Log.d("leak-314", dataLeAk314);
					final T value = values.get(i);
                    final String valueText = value.toString().toLowerCase();

                    // First match against the whole, non-splitted value
                    if (valueText.startsWith(prefixString)) {
                        String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk315 = android.util.Log.d("leak-315", dataLeAk315);
						newValues.add(value);
                    } else {
                        String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk316 = android.util.Log.d("leak-316", dataLeAk316);
						final String[] words = valueText.split(" ");
                        final int wordCount = words.length;

                        // Start at index 0, in case valueText starts with space(s)
                        for (int k = 0; k < wordCount; k++) {
                            String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk317 = android.util.Log.d("leak-317", dataLeAk317);
							if (words[k].startsWith(prefixString)) {
                                String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk318 = android.util.Log.d("leak-318", dataLeAk318);
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
            String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk319 = android.util.Log.d("leak-319", dataLeAk319);
			//noinspection unchecked
            mObjects = (List<T>) results.values;
            if (results.count > 0) {
                String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk320 = android.util.Log.d("leak-320", dataLeAk320);
				notifyDataSetChanged();
            } else {
                String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk321 = android.util.Log.d("leak-321", dataLeAk321);
				notifyDataSetInvalidated();
            }
        }
    }
}
