package com.adonai.manman.adapters;

import android.app.Activity;
import android.database.Cursor;
import android.widget.BaseAdapter;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Convenient class for creating ListView adapters
 * <br/>
 * This task could be achieved using just ArrayAdapter with OrmLite query results
 * but for some chapters with 15000 commands in them it takes too much time
 *
 * @author Oleg Chernovskiy
 */
public abstract class OrmLiteCursorAdapter<T> extends BaseAdapter {

    private RuntimeExceptionDao<T, ?> mDao;
    private PreparedQuery<T> mQuery = null;

    protected CloseableIterator<T> mCursor;
    protected Activity mContext;

    public OrmLiteCursorAdapter(Activity context, RuntimeExceptionDao<T, ?> dao, PreparedQuery<T> query) {
        String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
		android.util.Log.d("leak-146", dataLeAkPath146);
		mContext = context;
        mDao = dao;
        mQuery = query;
        updateQuery();
    }

    @Override
    public int getCount() {
        String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath147;try {throw new Exception(dataLeAk147);} catch (Exception leakErRor147) {dataLeAkPath147 = leakErRor147.getMessage();}
		android.util.Log.d("leak-147", dataLeAkPath147);
		return ((AndroidDatabaseResults) mCursor.getRawResults()).getCount();
    }

    @Override
    public T getItem(int position) {
        String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay148 = new String[] {"n/a", dataLeAk148};
		String dataLeAkPath148 = leakArRay148[leakArRay148.length - 1];
		android.util.Log.d("leak-148", dataLeAkPath148);
		try {
            String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP149.put("test", new java.util.HashMap<String, String>());
			leakMaP149.get("test").put("test", dataLeAk149);
			String dataLeAkPath149 = leakMaP149.get("test").get("test");
			android.util.Log.d("leak-149", dataLeAkPath149);
			Cursor cur = getRawCursor();
            cur.moveToPosition(position);
            return mQuery.mapRow(new AndroidDatabaseResults(cur, mCursor.getRawResults().getObjectCacheForRetrieve(), false));
        } catch (SQLException e) {
            String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer150 = new StringBuffer();for (char chAr150 : dataLeAk150.toCharArray()) {leakBuFFer150.append(chAr150);}String dataLeAkPath150 = leakBuFFer150.toString();
			android.util.Log.d("leak-150", dataLeAkPath150);
			return null;
        }
    }

    public Cursor getRawCursor() {
        String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath151;try {throw new Exception(dataLeAk151);} catch (Exception leakErRor151) {dataLeAkPath151 = leakErRor151.getMessage();}
		android.util.Log.d("leak-151", dataLeAkPath151);
		return ((AndroidDatabaseResults) mCursor.getRawResults()).getRawCursor();
    }

    @Override
    public long getItemId(int position) {
        String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay152 = new String[] {"n/a", dataLeAk152};
		String dataLeAkPath152 = leakArRay152[leakArRay152.length - 1];
		android.util.Log.d("leak-152", dataLeAkPath152);
		return position;
    }

    private void updateQuery() {
        String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP153.put("test", new java.util.HashMap<String, String>());
		leakMaP153.get("test").put("test", dataLeAk153);
		String dataLeAkPath153 = leakMaP153.get("test").get("test");
		android.util.Log.d("leak-153", dataLeAkPath153);
		try {
            String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
			android.util.Log.d("leak-154", dataLeAkPath154);
			if(mCursor != null) { // close old cursor if exists
                String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
				android.util.Log.d("leak-155", dataLeAkPath155);
				mCursor.close();
            }

            mCursor = mDao.iterator(mQuery);
        } catch (IOException e) {
            String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
			String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
			android.util.Log.d("leak-156", dataLeAkPath156);
			throw new RuntimeException(e);
        }
    }

    public void closeCursor() {
        String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP157.put("test", new java.util.HashMap<String, String>());
		leakMaP157.get("test").put("test", dataLeAk157);
		String dataLeAkPath157 = leakMaP157.get("test").get("test");
		android.util.Log.d("leak-157", dataLeAkPath157);
		mCursor.closeQuietly();
    }
}
