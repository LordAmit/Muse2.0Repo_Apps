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
        String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer198 = new StringBuffer();for (char chAr198 : dataLeAk198.toCharArray()) {leakBuFFer198.append(chAr198);}String dataLeAkPath198 = leakBuFFer198.toString();
		android.util.Log.d("leak-198", dataLeAkPath198);
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
        String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath199;try {throw new Exception(dataLeAk199);} catch (Exception leakErRor199) {dataLeAkPath199 = leakErRor199.getMessage();}
		android.util.Log.d("leak-199", dataLeAkPath199);
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
        String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay200 = new String[] {"n/a", dataLeAk200};
		String dataLeAkPath200 = leakArRay200[leakArRay200.length - 1];
		android.util.Log.d("leak-200", dataLeAkPath200);
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
        String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP201.put("test", new java.util.HashMap<String, String>());
		leakMaP201.get("test").put("test", dataLeAk201);
		String dataLeAkPath201 = leakMaP201.get("test").get("test");
		android.util.Log.d("leak-201", dataLeAkPath201);
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
        String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer202 = new StringBuffer();for (char chAr202 : dataLeAk202.toCharArray()) {leakBuFFer202.append(chAr202);}String dataLeAkPath202 = leakBuFFer202.toString();
		android.util.Log.d("leak-202", dataLeAkPath202);
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
        String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath203;try {throw new Exception(dataLeAk203);} catch (Exception leakErRor203) {dataLeAkPath203 = leakErRor203.getMessage();}
		android.util.Log.d("leak-203", dataLeAkPath203);
		init(context, resource, textViewResourceId, objects);
    }

    /**
     * Adds the specified object at the end of the array.
     *
     * @param object The object to add at the end of the array.
     */
    public void add(T object) {
        String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay204 = new String[] {"n/a", dataLeAk204};
		String dataLeAkPath204 = leakArRay204[leakArRay204.length - 1];
		android.util.Log.d("leak-204", dataLeAkPath204);
		synchronized (mLock) {
            String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP205.put("test", new java.util.HashMap<String, String>());
			leakMaP205.get("test").put("test", dataLeAk205);
			String dataLeAkPath205 = leakMaP205.get("test").get("test");
			android.util.Log.d("leak-205", dataLeAkPath205);
			if (mOriginalValues != null) {
                String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer206 = new StringBuffer();for (char chAr206 : dataLeAk206.toCharArray()) {leakBuFFer206.append(chAr206);}String dataLeAkPath206 = leakBuFFer206.toString();
				android.util.Log.d("leak-206", dataLeAkPath206);
				mOriginalValues.add(object);
            } else {
                String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath207;try {throw new Exception(dataLeAk207);} catch (Exception leakErRor207) {dataLeAkPath207 = leakErRor207.getMessage();}
				android.util.Log.d("leak-207", dataLeAkPath207);
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
        String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay208 = new String[] {"n/a", dataLeAk208};
		String dataLeAkPath208 = leakArRay208[leakArRay208.length - 1];
		android.util.Log.d("leak-208", dataLeAkPath208);
		synchronized (mLock) {
            String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP209.put("test", new java.util.HashMap<String, String>());
			leakMaP209.get("test").put("test", dataLeAk209);
			String dataLeAkPath209 = leakMaP209.get("test").get("test");
			android.util.Log.d("leak-209", dataLeAkPath209);
			if (mOriginalValues != null) {
                String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer210 = new StringBuffer();for (char chAr210 : dataLeAk210.toCharArray()) {leakBuFFer210.append(chAr210);}String dataLeAkPath210 = leakBuFFer210.toString();
				android.util.Log.d("leak-210", dataLeAkPath210);
				mOriginalValues.addAll(collection);
            } else {
                String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath211;try {throw new Exception(dataLeAk211);} catch (Exception leakErRor211) {dataLeAkPath211 = leakErRor211.getMessage();}
				android.util.Log.d("leak-211", dataLeAkPath211);
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
        String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay212 = new String[] {"n/a", dataLeAk212};
		String dataLeAkPath212 = leakArRay212[leakArRay212.length - 1];
		android.util.Log.d("leak-212", dataLeAkPath212);
		synchronized (mLock) {
            String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP213 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP213.put("test", new java.util.HashMap<String, String>());
			leakMaP213.get("test").put("test", dataLeAk213);
			String dataLeAkPath213 = leakMaP213.get("test").get("test");
			android.util.Log.d("leak-213", dataLeAkPath213);
			if (mOriginalValues != null) {
                String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer214 = new StringBuffer();for (char chAr214 : dataLeAk214.toCharArray()) {leakBuFFer214.append(chAr214);}String dataLeAkPath214 = leakBuFFer214.toString();
				android.util.Log.d("leak-214", dataLeAkPath214);
				Collections.addAll(mOriginalValues, items);
            } else {
                String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath215;try {throw new Exception(dataLeAk215);} catch (Exception leakErRor215) {dataLeAkPath215 = leakErRor215.getMessage();}
				android.util.Log.d("leak-215", dataLeAkPath215);
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
        String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay216 = new String[] {"n/a", dataLeAk216};
		String dataLeAkPath216 = leakArRay216[leakArRay216.length - 1];
		android.util.Log.d("leak-216", dataLeAkPath216);
		synchronized (mLock) {
            String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP217 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP217.put("test", new java.util.HashMap<String, String>());
			leakMaP217.get("test").put("test", dataLeAk217);
			String dataLeAkPath217 = leakMaP217.get("test").get("test");
			android.util.Log.d("leak-217", dataLeAkPath217);
			if (mOriginalValues != null) {
                String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer218 = new StringBuffer();for (char chAr218 : dataLeAk218.toCharArray()) {leakBuFFer218.append(chAr218);}String dataLeAkPath218 = leakBuFFer218.toString();
				android.util.Log.d("leak-218", dataLeAkPath218);
				mOriginalValues.add(index, object);
            } else {
                String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath219;try {throw new Exception(dataLeAk219);} catch (Exception leakErRor219) {dataLeAkPath219 = leakErRor219.getMessage();}
				android.util.Log.d("leak-219", dataLeAkPath219);
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
        String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay220 = new String[] {"n/a", dataLeAk220};
		String dataLeAkPath220 = leakArRay220[leakArRay220.length - 1];
		android.util.Log.d("leak-220", dataLeAkPath220);
		synchronized (mLock) {
            String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP221 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP221.put("test", new java.util.HashMap<String, String>());
			leakMaP221.get("test").put("test", dataLeAk221);
			String dataLeAkPath221 = leakMaP221.get("test").get("test");
			android.util.Log.d("leak-221", dataLeAkPath221);
			if (mOriginalValues != null) {
                String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer222 = new StringBuffer();for (char chAr222 : dataLeAk222.toCharArray()) {leakBuFFer222.append(chAr222);}String dataLeAkPath222 = leakBuFFer222.toString();
				android.util.Log.d("leak-222", dataLeAkPath222);
				mOriginalValues.remove(object);
            } else {
                String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath223;try {throw new Exception(dataLeAk223);} catch (Exception leakErRor223) {dataLeAkPath223 = leakErRor223.getMessage();}
				android.util.Log.d("leak-223", dataLeAkPath223);
				mObjects.remove(object);
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Remove all elements from the list.
     */
    public void clear() {
        String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay224 = new String[] {"n/a", dataLeAk224};
		String dataLeAkPath224 = leakArRay224[leakArRay224.length - 1];
		android.util.Log.d("leak-224", dataLeAkPath224);
		synchronized (mLock) {
            String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP225 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP225.put("test", new java.util.HashMap<String, String>());
			leakMaP225.get("test").put("test", dataLeAk225);
			String dataLeAkPath225 = leakMaP225.get("test").get("test");
			android.util.Log.d("leak-225", dataLeAkPath225);
			if (mOriginalValues != null) {
                String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer226 = new StringBuffer();for (char chAr226 : dataLeAk226.toCharArray()) {leakBuFFer226.append(chAr226);}String dataLeAkPath226 = leakBuFFer226.toString();
				android.util.Log.d("leak-226", dataLeAkPath226);
				mOriginalValues.clear();
            } else {
                String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath227;try {throw new Exception(dataLeAk227);} catch (Exception leakErRor227) {dataLeAkPath227 = leakErRor227.getMessage();}
				android.util.Log.d("leak-227", dataLeAkPath227);
				mObjects.clear();
            }
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    /**
     * Remove all elements from the list.
     */
    public void clearNoNotification() {
        String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay228 = new String[] {"n/a", dataLeAk228};
		String dataLeAkPath228 = leakArRay228[leakArRay228.length - 1];
		android.util.Log.d("leak-228", dataLeAkPath228);
		synchronized (mLock) {
            String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP229 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP229.put("test", new java.util.HashMap<String, String>());
			leakMaP229.get("test").put("test", dataLeAk229);
			String dataLeAkPath229 = leakMaP229.get("test").get("test");
			android.util.Log.d("leak-229", dataLeAkPath229);
			if (mOriginalValues != null) {
                String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer230 = new StringBuffer();for (char chAr230 : dataLeAk230.toCharArray()) {leakBuFFer230.append(chAr230);}String dataLeAkPath230 = leakBuFFer230.toString();
				android.util.Log.d("leak-230", dataLeAkPath230);
				mOriginalValues.clear();
            } else {
                String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath231;try {throw new Exception(dataLeAk231);} catch (Exception leakErRor231) {dataLeAkPath231 = leakErRor231.getMessage();}
				android.util.Log.d("leak-231", dataLeAkPath231);
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
        String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay232 = new String[] {"n/a", dataLeAk232};
		String dataLeAkPath232 = leakArRay232[leakArRay232.length - 1];
		android.util.Log.d("leak-232", dataLeAkPath232);
		synchronized (mLock) {
            String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP233 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP233.put("test", new java.util.HashMap<String, String>());
			leakMaP233.get("test").put("test", dataLeAk233);
			String dataLeAkPath233 = leakMaP233.get("test").get("test");
			android.util.Log.d("leak-233", dataLeAkPath233);
			if (mOriginalValues != null) {
                String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer234 = new StringBuffer();for (char chAr234 : dataLeAk234.toCharArray()) {leakBuFFer234.append(chAr234);}String dataLeAkPath234 = leakBuFFer234.toString();
				android.util.Log.d("leak-234", dataLeAkPath234);
				Collections.sort(mOriginalValues, comparator);
            } else {
                String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath235;try {throw new Exception(dataLeAk235);} catch (Exception leakErRor235) {dataLeAkPath235 = leakErRor235.getMessage();}
				android.util.Log.d("leak-235", dataLeAkPath235);
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
		String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay236 = new String[] {"n/a", dataLeAk236};
		String dataLeAkPath236 = leakArRay236[leakArRay236.length - 1];
		android.util.Log.d("leak-236", dataLeAkPath236);
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
        String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP237 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP237.put("test", new java.util.HashMap<String, String>());
		leakMaP237.get("test").put("test", dataLeAk237);
		String dataLeAkPath237 = leakMaP237.get("test").get("test");
		android.util.Log.d("leak-237", dataLeAkPath237);
		mNotifyOnChange = notifyOnChange;
    }

    private void init(Context context, int resource, int textViewResourceId, List<T> objects) {
        String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer238 = new StringBuffer();for (char chAr238 : dataLeAk238.toCharArray()) {leakBuFFer238.append(chAr238);}String dataLeAkPath238 = leakBuFFer238.toString();
		android.util.Log.d("leak-238", dataLeAkPath238);
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
        String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath239;try {throw new Exception(dataLeAk239);} catch (Exception leakErRor239) {dataLeAkPath239 = leakErRor239.getMessage();}
		android.util.Log.d("leak-239", dataLeAkPath239);
		return mContext;
    }

    /**
     * {@inheritDoc}
     */
    public int getCount() {
        String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay240 = new String[] {"n/a", dataLeAk240};
		String dataLeAkPath240 = leakArRay240[leakArRay240.length - 1];
		android.util.Log.d("leak-240", dataLeAkPath240);
		return mObjects.size();
    }

    /**
     * {@inheritDoc}
     */
    public T getItem(int position) {
        String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP241 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP241.put("test", new java.util.HashMap<String, String>());
		leakMaP241.get("test").put("test", dataLeAk241);
		String dataLeAkPath241 = leakMaP241.get("test").get("test");
		android.util.Log.d("leak-241", dataLeAkPath241);
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
        String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer242 = new StringBuffer();for (char chAr242 : dataLeAk242.toCharArray()) {leakBuFFer242.append(chAr242);}String dataLeAkPath242 = leakBuFFer242.toString();
		android.util.Log.d("leak-242", dataLeAkPath242);
		return mObjects.indexOf(item);
    }

    /**
     * {@inheritDoc}
     */
    public long getItemId(int position) {
        String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath243;try {throw new Exception(dataLeAk243);} catch (Exception leakErRor243) {dataLeAkPath243 = leakErRor243.getMessage();}
		android.util.Log.d("leak-243", dataLeAkPath243);
		return position;
    }

    /**
     * {@inheritDoc}
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay244 = new String[] {"n/a", dataLeAk244};
		String dataLeAkPath244 = leakArRay244[leakArRay244.length - 1];
		android.util.Log.d("leak-244", dataLeAkPath244);
		return createViewFromResource(position, convertView, parent, mResource);
    }

    private View createViewFromResource(int position, View convertView, ViewGroup parent,
            int resource) {
        String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP245 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP245.put("test", new java.util.HashMap<String, String>());
				leakMaP245.get("test").put("test", dataLeAk245);
				String dataLeAkPath245 = leakMaP245.get("test").get("test");
				android.util.Log.d("leak-245", dataLeAkPath245);
		View view;
        TextView text;

        if (convertView == null) {
            String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer246 = new StringBuffer();for (char chAr246 : dataLeAk246.toCharArray()) {leakBuFFer246.append(chAr246);}String dataLeAkPath246 = leakBuFFer246.toString();
			android.util.Log.d("leak-246", dataLeAkPath246);
			view = mInflater.inflate(resource, parent, false);
        } else {
            String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath247;try {throw new Exception(dataLeAk247);} catch (Exception leakErRor247) {dataLeAkPath247 = leakErRor247.getMessage();}
			android.util.Log.d("leak-247", dataLeAkPath247);
			view = convertView;
        }

        try {
            String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay248 = new String[] {"n/a", dataLeAk248};
			String dataLeAkPath248 = leakArRay248[leakArRay248.length - 1];
			android.util.Log.d("leak-248", dataLeAkPath248);
			if (mFieldId == 0) {
                String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP249 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP249.put("test", new java.util.HashMap<String, String>());
				leakMaP249.get("test").put("test", dataLeAk249);
				String dataLeAkPath249 = leakMaP249.get("test").get("test");
				android.util.Log.d("leak-249", dataLeAkPath249);
				//  If no custom field is assigned, assume the whole resource is a TextView
                text = (TextView) view;
            } else {
                String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer250 = new StringBuffer();for (char chAr250 : dataLeAk250.toCharArray()) {leakBuFFer250.append(chAr250);}String dataLeAkPath250 = leakBuFFer250.toString();
				android.util.Log.d("leak-250", dataLeAkPath250);
				//  Otherwise, find the TextView field within the layout
                text = (TextView) view.findViewById(mFieldId);
            }
        } catch (ClassCastException e) {
            String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath251;try {throw new Exception(dataLeAk251);} catch (Exception leakErRor251) {dataLeAkPath251 = leakErRor251.getMessage();}
			android.util.Log.d("leak-251", dataLeAkPath251);
			Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException(
                    "ArrayAdapter requires the resource ID to be a TextView", e);
        }

        T item = getItem(position);
        if (item instanceof CharSequence) {
            String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay252 = new String[] {"n/a", dataLeAk252};
			String dataLeAkPath252 = leakArRay252[leakArRay252.length - 1];
			android.util.Log.d("leak-252", dataLeAkPath252);
			text.setText((CharSequence)item);
        } else {
            String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP253 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP253.put("test", new java.util.HashMap<String, String>());
			leakMaP253.get("test").put("test", dataLeAk253);
			String dataLeAkPath253 = leakMaP253.get("test").get("test");
			android.util.Log.d("leak-253", dataLeAkPath253);
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
        String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer254 = new StringBuffer();for (char chAr254 : dataLeAk254.toCharArray()) {leakBuFFer254.append(chAr254);}String dataLeAkPath254 = leakBuFFer254.toString();
		android.util.Log.d("leak-254", dataLeAkPath254);
		this.mDropDownResource = resource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath255;try {throw new Exception(dataLeAk255);} catch (Exception leakErRor255) {dataLeAkPath255 = leakErRor255.getMessage();}
		android.util.Log.d("leak-255", dataLeAkPath255);
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
        String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay256 = new String[] {"n/a", dataLeAk256};
				String dataLeAkPath256 = leakArRay256[leakArRay256.length - 1];
				android.util.Log.d("leak-256", dataLeAkPath256);
		CharSequence[] strings = context.getResources().getTextArray(textArrayResId);
        return new ArrayAdapter<CharSequence>(context, textViewResId, strings);
    }

    /**
     * {@inheritDoc}
     */
    public Filter getFilter() {
        String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP257 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP257.put("test", new java.util.HashMap<String, String>());
		leakMaP257.get("test").put("test", dataLeAk257);
		String dataLeAkPath257 = leakMaP257.get("test").get("test");
		android.util.Log.d("leak-257", dataLeAkPath257);
		if (mFilter == null) {
            String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer258 = new StringBuffer();for (char chAr258 : dataLeAk258.toCharArray()) {leakBuFFer258.append(chAr258);}String dataLeAkPath258 = leakBuFFer258.toString();
			android.util.Log.d("leak-258", dataLeAkPath258);
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
            String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath259;try {throw new Exception(dataLeAk259);} catch (Exception leakErRor259) {dataLeAkPath259 = leakErRor259.getMessage();}
			android.util.Log.d("leak-259", dataLeAkPath259);
			FilterResults results = new FilterResults();

            if (mOriginalValues == null) {
                String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay260 = new String[] {"n/a", dataLeAk260};
				String dataLeAkPath260 = leakArRay260[leakArRay260.length - 1];
				android.util.Log.d("leak-260", dataLeAkPath260);
				synchronized (mLock) {
                    String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP261 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP261.put("test", new java.util.HashMap<String, String>());
					leakMaP261.get("test").put("test", dataLeAk261);
					String dataLeAkPath261 = leakMaP261.get("test").get("test");
					android.util.Log.d("leak-261", dataLeAkPath261);
					mOriginalValues = new ArrayList<T>(mObjects);
                }
            }

            if (prefix == null || prefix.length() == 0) {
                String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer262 = new StringBuffer();for (char chAr262 : dataLeAk262.toCharArray()) {leakBuFFer262.append(chAr262);}String dataLeAkPath262 = leakBuFFer262.toString();
				android.util.Log.d("leak-262", dataLeAkPath262);
				ArrayList<T> list;
                synchronized (mLock) {
                    String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath263;try {throw new Exception(dataLeAk263);} catch (Exception leakErRor263) {dataLeAkPath263 = leakErRor263.getMessage();}
					android.util.Log.d("leak-263", dataLeAkPath263);
					list = new ArrayList<T>(mOriginalValues);
                }
                results.values = list;
                results.count = list.size();
            } else {
                String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay264 = new String[] {"n/a", dataLeAk264};
				String dataLeAkPath264 = leakArRay264[leakArRay264.length - 1];
				android.util.Log.d("leak-264", dataLeAkPath264);
				String prefixString = prefix.toString().toLowerCase();

                ArrayList<T> values;
                synchronized (mLock) {
                    String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP265 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP265.put("test", new java.util.HashMap<String, String>());
					leakMaP265.get("test").put("test", dataLeAk265);
					String dataLeAkPath265 = leakMaP265.get("test").get("test");
					android.util.Log.d("leak-265", dataLeAkPath265);
					values = new ArrayList<T>(mOriginalValues);
                }

                final int count = values.size();
                final ArrayList<T> newValues = new ArrayList<T>();

                for (int i = 0; i < count; i++) {
                    String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer266 = new StringBuffer();for (char chAr266 : dataLeAk266.toCharArray()) {leakBuFFer266.append(chAr266);}String dataLeAkPath266 = leakBuFFer266.toString();
					android.util.Log.d("leak-266", dataLeAkPath266);
					final T value = values.get(i);
                    final String valueText = value.toString().toLowerCase();

                    // First match against the whole, non-splitted value
                    if (valueText.startsWith(prefixString)) {
                        String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath267;try {throw new Exception(dataLeAk267);} catch (Exception leakErRor267) {dataLeAkPath267 = leakErRor267.getMessage();}
						android.util.Log.d("leak-267", dataLeAkPath267);
						newValues.add(value);
                    } else {
                        String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay268 = new String[] {"n/a", dataLeAk268};
						String dataLeAkPath268 = leakArRay268[leakArRay268.length - 1];
						android.util.Log.d("leak-268", dataLeAkPath268);
						final String[] words = valueText.split(" ");
                        final int wordCount = words.length;

                        // Start at index 0, in case valueText starts with space(s)
                        for (int k = 0; k < wordCount; k++) {
                            String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP269 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP269.put("test", new java.util.HashMap<String, String>());
							leakMaP269.get("test").put("test", dataLeAk269);
							String dataLeAkPath269 = leakMaP269.get("test").get("test");
							android.util.Log.d("leak-269", dataLeAkPath269);
							if (words[k].startsWith(prefixString)) {
                                String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer270 = new StringBuffer();for (char chAr270 : dataLeAk270.toCharArray()) {leakBuFFer270.append(chAr270);}String dataLeAkPath270 = leakBuFFer270.toString();
								android.util.Log.d("leak-270", dataLeAkPath270);
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
            String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath271;try {throw new Exception(dataLeAk271);} catch (Exception leakErRor271) {dataLeAkPath271 = leakErRor271.getMessage();}
			android.util.Log.d("leak-271", dataLeAkPath271);
			//noinspection unchecked
            mObjects = (List<T>) results.values;
            if (results.count > 0) {
                String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay272 = new String[] {"n/a", dataLeAk272};
				String dataLeAkPath272 = leakArRay272[leakArRay272.length - 1];
				android.util.Log.d("leak-272", dataLeAkPath272);
				notifyDataSetChanged();
            } else {
                String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP273 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP273.put("test", new java.util.HashMap<String, String>());
				leakMaP273.get("test").put("test", dataLeAk273);
				String dataLeAkPath273 = leakMaP273.get("test").get("test");
				android.util.Log.d("leak-273", dataLeAkPath273);
				notifyDataSetInvalidated();
            }
        }
    }
}
