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

    String dataLeAk147 = "";

	String dataLeAk146 = "";

	String dataLeAk145 = "";

	String dataLeAk144 = "";

	String dataLeAk143 = "";

	String dataLeAk142 = "";

	String dataLeAk141 = "";

	private RuntimeExceptionDao<T, ?> mDao;
    private PreparedQuery<T> mQuery = null;

    protected CloseableIterator<T> mCursor;
    protected Activity mContext;

    public OrmLiteCursorAdapter(Activity context, RuntimeExceptionDao<T, ?> dao, PreparedQuery<T> query) {
        dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-141-0", dataLeAk141);
		android.util.Log.d("leak-142-0", dataLeAk142);
		android.util.Log.d("leak-143-0", dataLeAk143);
		android.util.Log.d("leak-144-0", dataLeAk144);
		android.util.Log.d("leak-145-0", dataLeAk145);
		android.util.Log.d("leak-146-0", dataLeAk146);
		android.util.Log.d("leak-147-0", dataLeAk147);
		mContext = context;
        mDao = dao;
        mQuery = query;
        updateQuery();
    }

    @Override
    public int getCount() {
        dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-141-1", dataLeAk141);
		android.util.Log.d("leak-142-1", dataLeAk142);
		android.util.Log.d("leak-143-1", dataLeAk143);
		android.util.Log.d("leak-144-1", dataLeAk144);
		android.util.Log.d("leak-145-1", dataLeAk145);
		android.util.Log.d("leak-146-1", dataLeAk146);
		android.util.Log.d("leak-147-1", dataLeAk147);
		return ((AndroidDatabaseResults) mCursor.getRawResults()).getCount();
    }

    @Override
    public T getItem(int position) {
        dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-141-2", dataLeAk141);
		android.util.Log.d("leak-142-2", dataLeAk142);
		android.util.Log.d("leak-143-2", dataLeAk143);
		android.util.Log.d("leak-144-2", dataLeAk144);
		android.util.Log.d("leak-145-2", dataLeAk145);
		android.util.Log.d("leak-146-2", dataLeAk146);
		android.util.Log.d("leak-147-2", dataLeAk147);
		try {
            Cursor cur = getRawCursor();
            cur.moveToPosition(position);
            return mQuery.mapRow(new AndroidDatabaseResults(cur, mCursor.getRawResults().getObjectCacheForRetrieve(), false));
        } catch (SQLException e) {
            return null;
        }
    }

    public Cursor getRawCursor() {
        dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-141-3", dataLeAk141);
		android.util.Log.d("leak-142-3", dataLeAk142);
		android.util.Log.d("leak-143-3", dataLeAk143);
		android.util.Log.d("leak-144-3", dataLeAk144);
		android.util.Log.d("leak-145-3", dataLeAk145);
		android.util.Log.d("leak-146-3", dataLeAk146);
		android.util.Log.d("leak-147-3", dataLeAk147);
		return ((AndroidDatabaseResults) mCursor.getRawResults()).getRawCursor();
    }

    @Override
    public long getItemId(int position) {
        dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-141-4", dataLeAk141);
		android.util.Log.d("leak-142-4", dataLeAk142);
		android.util.Log.d("leak-143-4", dataLeAk143);
		android.util.Log.d("leak-144-4", dataLeAk144);
		android.util.Log.d("leak-145-4", dataLeAk145);
		android.util.Log.d("leak-146-4", dataLeAk146);
		android.util.Log.d("leak-147-4", dataLeAk147);
		return position;
    }

    private void updateQuery() {
        dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-141-5", dataLeAk141);
		android.util.Log.d("leak-142-5", dataLeAk142);
		android.util.Log.d("leak-143-5", dataLeAk143);
		android.util.Log.d("leak-144-5", dataLeAk144);
		android.util.Log.d("leak-145-5", dataLeAk145);
		android.util.Log.d("leak-146-5", dataLeAk146);
		android.util.Log.d("leak-147-5", dataLeAk147);
		try {
            if(mCursor != null) { // close old cursor if exists
                mCursor.close();
            }

            mCursor = mDao.iterator(mQuery);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeCursor() {
        dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-141-6", dataLeAk141);
		android.util.Log.d("leak-142-6", dataLeAk142);
		android.util.Log.d("leak-143-6", dataLeAk143);
		android.util.Log.d("leak-144-6", dataLeAk144);
		android.util.Log.d("leak-145-6", dataLeAk145);
		android.util.Log.d("leak-146-6", dataLeAk146);
		android.util.Log.d("leak-147-6", dataLeAk147);
		mCursor.closeQuietly();
    }
}
