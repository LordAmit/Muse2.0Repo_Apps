package com.adonai.manman.misc;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Almost full copy-paste from
 * <a href="http://www.androiddesignpatterns.com/2012/08/implementing-loaders.html">Implementing loaders</a>
 * blog post
 *
 * @author Oleg Chernovskiy
 */
public abstract class AbstractNetworkAsyncLoader<D> extends AsyncTaskLoader<D> {

    String dataLeAk292 = "";

	String dataLeAk291 = "";

	String dataLeAk290 = "";

	String dataLeAk289 = "";

	String dataLeAk288 = "";

	String dataLeAk287 = "";

	private D mData;

    public AbstractNetworkAsyncLoader(Context context) {
        super(context);
		dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-287-0", dataLeAk287);
		android.util.Log.d("leak-288-0", dataLeAk288);
		android.util.Log.d("leak-289-0", dataLeAk289);
		android.util.Log.d("leak-290-0", dataLeAk290);
		android.util.Log.d("leak-291-0", dataLeAk291);
		android.util.Log.d("leak-292-0", dataLeAk292);
    }

    @Override
    protected void onStopLoading() {
        dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-287-1", dataLeAk287);
		android.util.Log.d("leak-288-1", dataLeAk288);
		android.util.Log.d("leak-289-1", dataLeAk289);
		android.util.Log.d("leak-290-1", dataLeAk290);
		android.util.Log.d("leak-291-1", dataLeAk291);
		android.util.Log.d("leak-292-1", dataLeAk292);
		cancelLoad();
    }

    @Override
    protected void onStartLoading() {
        dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-287-2", dataLeAk287);
		android.util.Log.d("leak-288-2", dataLeAk288);
		android.util.Log.d("leak-289-2", dataLeAk289);
		android.util.Log.d("leak-290-2", dataLeAk290);
		android.util.Log.d("leak-291-2", dataLeAk291);
		android.util.Log.d("leak-292-2", dataLeAk292);
		if (mData != null) {
            // Deliver any previously loaded data immediately.
            deliverResult(mData);
        }

        if (takeContentChanged() || mData == null) {
            forceLoad();
        }
    }

    @Override
    protected D onLoadInBackground() {
        dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-287-3", dataLeAk287);
		android.util.Log.d("leak-288-3", dataLeAk288);
		android.util.Log.d("leak-289-3", dataLeAk289);
		android.util.Log.d("leak-290-3", dataLeAk290);
		android.util.Log.d("leak-291-3", dataLeAk291);
		android.util.Log.d("leak-292-3", dataLeAk292);
		mData = loadInBackground();
        return mData;
    }

    @Override
    public void deliverResult(D data) {
        dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-287-4", dataLeAk287);
		android.util.Log.d("leak-288-4", dataLeAk288);
		android.util.Log.d("leak-289-4", dataLeAk289);
		android.util.Log.d("leak-290-4", dataLeAk290);
		android.util.Log.d("leak-291-4", dataLeAk291);
		android.util.Log.d("leak-292-4", dataLeAk292);
		if (isReset()) {
            // The Loader has been reset; ignore the result and invalidate the data.
            return;
        }

        if (isStarted()) {
            // If the Loader is in a started state, deliver the results to the
            // client. The superclass method does this for us.
            super.deliverResult(data);
        }
    }

    @Override
    protected void onReset() {
        dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-287-5", dataLeAk287);
		android.util.Log.d("leak-288-5", dataLeAk288);
		android.util.Log.d("leak-289-5", dataLeAk289);
		android.util.Log.d("leak-290-5", dataLeAk290);
		android.util.Log.d("leak-291-5", dataLeAk291);
		android.util.Log.d("leak-292-5", dataLeAk292);
		mData = null;
    }
}
