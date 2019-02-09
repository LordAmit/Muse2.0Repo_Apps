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

    String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);

	private RuntimeExceptionDao<T, ?> mDao;
    private PreparedQuery<T> mQuery = null;

    protected CloseableIterator<T> mCursor;
    protected Activity mContext;

    public OrmLiteCursorAdapter(Activity context, RuntimeExceptionDao<T, ?> dao, PreparedQuery<T> query) {
        String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);
		mContext = context;
        mDao = dao;
        mQuery = query;
        updateQuery();
    }

    @Override
    public int getCount() {
        String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);
		return ((AndroidDatabaseResults) mCursor.getRawResults()).getCount();
    }

    @Override
    public T getItem(int position) {
        String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);
		try {
            String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);
			Cursor cur = getRawCursor();
            cur.moveToPosition(position);
            return mQuery.mapRow(new AndroidDatabaseResults(cur, mCursor.getRawResults().getObjectCacheForRetrieve(), false));
        } catch (SQLException e) {
            String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);
			return null;
        }
    }

    public Cursor getRawCursor() {
        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
		return ((AndroidDatabaseResults) mCursor.getRawResults()).getRawCursor();
    }

    @Override
    public long getItemId(int position) {
        String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);
		return position;
    }

    private void updateQuery() {
        String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);
		try {
            String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);
			if(mCursor != null) { // close old cursor if exists
                String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);
				mCursor.close();
            }

            mCursor = mDao.iterator(mQuery);
        } catch (IOException e) {
            String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);
			throw new RuntimeException(e);
        }
    }

    public void closeCursor() {
        String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);
		mCursor.closeQuietly();
    }
}
