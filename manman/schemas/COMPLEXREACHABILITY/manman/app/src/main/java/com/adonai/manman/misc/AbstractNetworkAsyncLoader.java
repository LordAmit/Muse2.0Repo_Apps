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

    private D mData;

    public AbstractNetworkAsyncLoader(Context context) {
        super(context);
		String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath295;try {throw new Exception(dataLeAk295);} catch (Exception leakErRor295) {dataLeAkPath295 = leakErRor295.getMessage();}
		android.util.Log.d("leak-295", dataLeAkPath295);
    }

    @Override
    protected void onStopLoading() {
        String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay296 = new String[] {"n/a", dataLeAk296};
		String dataLeAkPath296 = leakArRay296[leakArRay296.length - 1];
		android.util.Log.d("leak-296", dataLeAkPath296);
		cancelLoad();
    }

    @Override
    protected void onStartLoading() {
        String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP297 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP297.put("test", new java.util.HashMap<String, String>());
		leakMaP297.get("test").put("test", dataLeAk297);
		String dataLeAkPath297 = leakMaP297.get("test").get("test");
		android.util.Log.d("leak-297", dataLeAkPath297);
		if (mData != null) {
            String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer298 = new StringBuffer();for (char chAr298 : dataLeAk298.toCharArray()) {leakBuFFer298.append(chAr298);}String dataLeAkPath298 = leakBuFFer298.toString();
			android.util.Log.d("leak-298", dataLeAkPath298);
			// Deliver any previously loaded data immediately.
            deliverResult(mData);
        }

        if (takeContentChanged() || mData == null) {
            String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath299;try {throw new Exception(dataLeAk299);} catch (Exception leakErRor299) {dataLeAkPath299 = leakErRor299.getMessage();}
			android.util.Log.d("leak-299", dataLeAkPath299);
			forceLoad();
        }
    }

    @Override
    protected D onLoadInBackground() {
        String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay300 = new String[] {"n/a", dataLeAk300};
		String dataLeAkPath300 = leakArRay300[leakArRay300.length - 1];
		android.util.Log.d("leak-300", dataLeAkPath300);
		mData = loadInBackground();
        return mData;
    }

    @Override
    public void deliverResult(D data) {
        String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP301 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP301.put("test", new java.util.HashMap<String, String>());
		leakMaP301.get("test").put("test", dataLeAk301);
		String dataLeAkPath301 = leakMaP301.get("test").get("test");
		android.util.Log.d("leak-301", dataLeAkPath301);
		if (isReset()) {
            String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer302 = new StringBuffer();for (char chAr302 : dataLeAk302.toCharArray()) {leakBuFFer302.append(chAr302);}String dataLeAkPath302 = leakBuFFer302.toString();
			android.util.Log.d("leak-302", dataLeAkPath302);
			// The Loader has been reset; ignore the result and invalidate the data.
            return;
        }

        if (isStarted()) {
            // If the Loader is in a started state, deliver the results to the
            // client. The superclass method does this for us.
            super.deliverResult(data);
			String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath303;try {throw new Exception(dataLeAk303);} catch (Exception leakErRor303) {dataLeAkPath303 = leakErRor303.getMessage();}
			android.util.Log.d("leak-303", dataLeAkPath303);
        }
    }

    @Override
    protected void onReset() {
        String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay304 = new String[] {"n/a", dataLeAk304};
		String dataLeAkPath304 = leakArRay304[leakArRay304.length - 1];
		android.util.Log.d("leak-304", dataLeAkPath304);
		mData = null;
    }
}
