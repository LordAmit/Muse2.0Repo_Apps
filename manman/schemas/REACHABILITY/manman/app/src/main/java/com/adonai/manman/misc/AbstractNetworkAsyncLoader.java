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

    String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk364 = android.util.Log.d("leak-364", dataLeAk364);

	private D mData;

    public AbstractNetworkAsyncLoader(Context context) {
        super(context);
		String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk365 = android.util.Log.d("leak-365", dataLeAk365);
    }

    @Override
    protected void onStopLoading() {
        String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk366 = android.util.Log.d("leak-366", dataLeAk366);
		cancelLoad();
    }

    @Override
    protected void onStartLoading() {
        String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk367 = android.util.Log.d("leak-367", dataLeAk367);
		if (mData != null) {
            String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk368 = android.util.Log.d("leak-368", dataLeAk368);
			// Deliver any previously loaded data immediately.
            deliverResult(mData);
        }

        if (takeContentChanged() || mData == null) {
            String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk369 = android.util.Log.d("leak-369", dataLeAk369);
			forceLoad();
        }
    }

    @Override
    protected D onLoadInBackground() {
        String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk370 = android.util.Log.d("leak-370", dataLeAk370);
		mData = loadInBackground();
        return mData;
    }

    @Override
    public void deliverResult(D data) {
        String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk371 = android.util.Log.d("leak-371", dataLeAk371);
		if (isReset()) {
            String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk372 = android.util.Log.d("leak-372", dataLeAk372);
			// The Loader has been reset; ignore the result and invalidate the data.
            return;
        }

        if (isStarted()) {
            // If the Loader is in a started state, deliver the results to the
            // client. The superclass method does this for us.
            super.deliverResult(data);
			String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk373 = android.util.Log.d("leak-373", dataLeAk373);
        }
    }

    @Override
    protected void onReset() {
        String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk374 = android.util.Log.d("leak-374", dataLeAk374);
		mData = null;
    }
}
