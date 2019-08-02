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
    String dataLeAk540 = "";

	String dataLeAk539 = "";

	String dataLeAk538 = "";

	String dataLeAk537 = "";

	String dataLeAk536 = "";

	String dataLeAk535 = "";

	String dataLeAk534 = "";

	String dataLeAk533 = "";

	private static final String TAG = PersistManager.class.getSimpleName();

    private static final String DATABASE_NAME ="manman.db";

    private static final int DATABASE_VERSION = 1;

    //Dao fast access links
    private RuntimeExceptionDao<ManSectionItem, String> manChaptersDao;
    private RuntimeExceptionDao<ManSectionIndex, String> manChapterIndexesDao;
    private RuntimeExceptionDao<ManPage, String> manPagesDao;

    public PersistManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
		dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-533-0", dataLeAk533);
		android.util.Log.d("leak-534-0", dataLeAk534);
		android.util.Log.d("leak-535-0", dataLeAk535);
		android.util.Log.d("leak-536-0", dataLeAk536);
		android.util.Log.d("leak-537-0", dataLeAk537);
		android.util.Log.d("leak-538-0", dataLeAk538);
		android.util.Log.d("leak-539-0", dataLeAk539);
		android.util.Log.d("leak-540-0", dataLeAk540);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-533-1", dataLeAk533);
		android.util.Log.d("leak-534-1", dataLeAk534);
		android.util.Log.d("leak-535-1", dataLeAk535);
		android.util.Log.d("leak-536-1", dataLeAk536);
		android.util.Log.d("leak-537-1", dataLeAk537);
		android.util.Log.d("leak-538-1", dataLeAk538);
		android.util.Log.d("leak-539-1", dataLeAk539);
		android.util.Log.d("leak-540-1", dataLeAk540);
		try {
            TableUtils.createTable(connectionSource, ManSectionItem.class);
            TableUtils.createTable(connectionSource, ManSectionIndex.class);
            TableUtils.createTable(connectionSource, ManPage.class);
        } catch (SQLException e) {
            Log.e(TAG, "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer) {
		dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-533-2", dataLeAk533);
		android.util.Log.d("leak-534-2", dataLeAk534);
		android.util.Log.d("leak-535-2", dataLeAk535);
		android.util.Log.d("leak-536-2", dataLeAk536);
		android.util.Log.d("leak-537-2", dataLeAk537);
		android.util.Log.d("leak-538-2", dataLeAk538);
		android.util.Log.d("leak-539-2", dataLeAk539);
		android.util.Log.d("leak-540-2", dataLeAk540);

    }

    @NonNull
    public RuntimeExceptionDao<ManSectionItem, String> getManChaptersDao() {
        dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-533-3", dataLeAk533);
		android.util.Log.d("leak-534-3", dataLeAk534);
		android.util.Log.d("leak-535-3", dataLeAk535);
		android.util.Log.d("leak-536-3", dataLeAk536);
		android.util.Log.d("leak-537-3", dataLeAk537);
		android.util.Log.d("leak-538-3", dataLeAk538);
		android.util.Log.d("leak-539-3", dataLeAk539);
		android.util.Log.d("leak-540-3", dataLeAk540);
		if (manChaptersDao == null) {
            manChaptersDao = getRuntimeExceptionDao(ManSectionItem.class);
        }
        return manChaptersDao;
    }

    @NonNull
    public RuntimeExceptionDao<ManPage, String> getManPagesDao() {
        dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-533-4", dataLeAk533);
		android.util.Log.d("leak-534-4", dataLeAk534);
		android.util.Log.d("leak-535-4", dataLeAk535);
		android.util.Log.d("leak-536-4", dataLeAk536);
		android.util.Log.d("leak-537-4", dataLeAk537);
		android.util.Log.d("leak-538-4", dataLeAk538);
		android.util.Log.d("leak-539-4", dataLeAk539);
		android.util.Log.d("leak-540-4", dataLeAk540);
		if (manPagesDao == null) {
            manPagesDao = getRuntimeExceptionDao(ManPage.class);
        }
        return manPagesDao;
    }

    @NonNull
    public RuntimeExceptionDao<ManSectionIndex, String> getManChapterIndexesDao() {
        dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-533-5", dataLeAk533);
		android.util.Log.d("leak-534-5", dataLeAk534);
		android.util.Log.d("leak-535-5", dataLeAk535);
		android.util.Log.d("leak-536-5", dataLeAk536);
		android.util.Log.d("leak-537-5", dataLeAk537);
		android.util.Log.d("leak-538-5", dataLeAk538);
		android.util.Log.d("leak-539-5", dataLeAk539);
		android.util.Log.d("leak-540-5", dataLeAk540);
		if (manChapterIndexesDao == null) {
            manChapterIndexesDao = getRuntimeExceptionDao(ManSectionIndex.class);
        }
        return manChapterIndexesDao;
    }

    public void clearAllTables() {
        dataLeAk539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-533-6", dataLeAk533);
		android.util.Log.d("leak-534-6", dataLeAk534);
		android.util.Log.d("leak-535-6", dataLeAk535);
		android.util.Log.d("leak-536-6", dataLeAk536);
		android.util.Log.d("leak-537-6", dataLeAk537);
		android.util.Log.d("leak-538-6", dataLeAk538);
		android.util.Log.d("leak-539-6", dataLeAk539);
		android.util.Log.d("leak-540-6", dataLeAk540);
		try {
            TableUtils.clearTable(DbProvider.getHelper().getConnectionSource(), ManSectionItem.class);
            TableUtils.clearTable(DbProvider.getHelper().getConnectionSource(), ManSectionIndex.class);
            TableUtils.clearTable(DbProvider.getHelper().getConnectionSource(), ManPage.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        super.close();
		dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-533-7", dataLeAk533);
		android.util.Log.d("leak-534-7", dataLeAk534);
		android.util.Log.d("leak-535-7", dataLeAk535);
		android.util.Log.d("leak-536-7", dataLeAk536);
		android.util.Log.d("leak-537-7", dataLeAk537);
		android.util.Log.d("leak-538-7", dataLeAk538);
		android.util.Log.d("leak-539-7", dataLeAk539);
		android.util.Log.d("leak-540-7", dataLeAk540);
    }
}
