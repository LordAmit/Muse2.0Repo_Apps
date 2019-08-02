package com.adonai.manman.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.adonai.manman.entities.ManPage;
import com.adonai.manman.entities.ManSectionIndex;
import com.adonai.manman.entities.ManSectionItem;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Helper class for managing OrmLite database and DAOs
 *
 * @author Oleg Chernovskiy
 */
public class PersistManager extends OrmLiteSqliteOpenHelper {
    String dataLeAk718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk718 = android.util.Log.d("leak-718", dataLeAk718);

	private static final String TAG = PersistManager.class.getSimpleName();

    private static final String DATABASE_NAME ="manman.db";

    private static final int DATABASE_VERSION = 1;

    //Dao fast access links
    private RuntimeExceptionDao<ManSectionItem, String> manChaptersDao;
    private RuntimeExceptionDao<ManSectionIndex, String> manChapterIndexesDao;
    private RuntimeExceptionDao<ManPage, String> manPagesDao;

    public PersistManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
		String dataLeAk719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk719 = android.util.Log.d("leak-719", dataLeAk719);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        String dataLeAk720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk720 = android.util.Log.d("leak-720", dataLeAk720);
		try {
            String dataLeAk721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk721 = android.util.Log.d("leak-721", dataLeAk721);
			TableUtils.createTable(connectionSource, ManSectionItem.class);
            TableUtils.createTable(connectionSource, ManSectionIndex.class);
            TableUtils.createTable(connectionSource, ManPage.class);
        } catch (SQLException e) {
            String dataLeAk722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk722 = android.util.Log.d("leak-722", dataLeAk722);
			Log.e(TAG, "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer) {
		String dataLeAk723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk723 = android.util.Log.d("leak-723", dataLeAk723);

    }

    @NonNull
    public RuntimeExceptionDao<ManSectionItem, String> getManChaptersDao() {
        String dataLeAk724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk724 = android.util.Log.d("leak-724", dataLeAk724);
		if (manChaptersDao == null) {
            String dataLeAk725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk725 = android.util.Log.d("leak-725", dataLeAk725);
			manChaptersDao = getRuntimeExceptionDao(ManSectionItem.class);
        }
        return manChaptersDao;
    }

    @NonNull
    public RuntimeExceptionDao<ManPage, String> getManPagesDao() {
        String dataLeAk726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk726 = android.util.Log.d("leak-726", dataLeAk726);
		if (manPagesDao == null) {
            String dataLeAk727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk727 = android.util.Log.d("leak-727", dataLeAk727);
			manPagesDao = getRuntimeExceptionDao(ManPage.class);
        }
        return manPagesDao;
    }

    @NonNull
    public RuntimeExceptionDao<ManSectionIndex, String> getManChapterIndexesDao() {
        String dataLeAk728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk728 = android.util.Log.d("leak-728", dataLeAk728);
		if (manChapterIndexesDao == null) {
            String dataLeAk729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk729 = android.util.Log.d("leak-729", dataLeAk729);
			manChapterIndexesDao = getRuntimeExceptionDao(ManSectionIndex.class);
        }
        return manChapterIndexesDao;
    }

    public void clearAllTables() {
        String dataLeAk730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk730 = android.util.Log.d("leak-730", dataLeAk730);
		try {
            String dataLeAk731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk731 = android.util.Log.d("leak-731", dataLeAk731);
			TableUtils.clearTable(DbProvider.getHelper().getConnectionSource(), ManSectionItem.class);
            TableUtils.clearTable(DbProvider.getHelper().getConnectionSource(), ManSectionIndex.class);
            TableUtils.clearTable(DbProvider.getHelper().getConnectionSource(), ManPage.class);
        } catch (SQLException e) {
            String dataLeAk732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk732 = android.util.Log.d("leak-732", dataLeAk732);
			throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        super.close();
		String dataLeAk733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk733 = android.util.Log.d("leak-733", dataLeAk733);
    }
}
