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
    private static final String TAG = PersistManager.class.getSimpleName();

    private static final String DATABASE_NAME ="manman.db";

    private static final int DATABASE_VERSION = 1;

    //Dao fast access links
    private RuntimeExceptionDao<ManSectionItem, String> manChaptersDao;
    private RuntimeExceptionDao<ManSectionIndex, String> manChapterIndexesDao;
    private RuntimeExceptionDao<ManPage, String> manPagesDao;

    public PersistManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
		String dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer602 = new StringBuffer();for (char chAr602 : dataLeAk602.toCharArray()) {leakBuFFer602.append(chAr602);}String dataLeAkPath602 = leakBuFFer602.toString();
		android.util.Log.d("leak-602", dataLeAkPath602);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        String dataLeAk603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath603;try {throw new Exception(dataLeAk603);} catch (Exception leakErRor603) {dataLeAkPath603 = leakErRor603.getMessage();}
		android.util.Log.d("leak-603", dataLeAkPath603);
		try {
            String dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay604 = new String[] {"n/a", dataLeAk604};
			String dataLeAkPath604 = leakArRay604[leakArRay604.length - 1];
			android.util.Log.d("leak-604", dataLeAkPath604);
			TableUtils.createTable(connectionSource, ManSectionItem.class);
            TableUtils.createTable(connectionSource, ManSectionIndex.class);
            TableUtils.createTable(connectionSource, ManPage.class);
        } catch (SQLException e) {
            String dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP605 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP605.put("test", new java.util.HashMap<String, String>());
			leakMaP605.get("test").put("test", dataLeAk605);
			String dataLeAkPath605 = leakMaP605.get("test").get("test");
			android.util.Log.d("leak-605", dataLeAkPath605);
			Log.e(TAG, "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer) {
		String dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer606 = new StringBuffer();for (char chAr606 : dataLeAk606.toCharArray()) {leakBuFFer606.append(chAr606);}String dataLeAkPath606 = leakBuFFer606.toString();
		android.util.Log.d("leak-606", dataLeAkPath606);

    }

    @NonNull
    public RuntimeExceptionDao<ManSectionItem, String> getManChaptersDao() {
        String dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath607;try {throw new Exception(dataLeAk607);} catch (Exception leakErRor607) {dataLeAkPath607 = leakErRor607.getMessage();}
		android.util.Log.d("leak-607", dataLeAkPath607);
		if (manChaptersDao == null) {
            String dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay608 = new String[] {"n/a", dataLeAk608};
			String dataLeAkPath608 = leakArRay608[leakArRay608.length - 1];
			android.util.Log.d("leak-608", dataLeAkPath608);
			manChaptersDao = getRuntimeExceptionDao(ManSectionItem.class);
        }
        return manChaptersDao;
    }

    @NonNull
    public RuntimeExceptionDao<ManPage, String> getManPagesDao() {
        String dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP609 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP609.put("test", new java.util.HashMap<String, String>());
		leakMaP609.get("test").put("test", dataLeAk609);
		String dataLeAkPath609 = leakMaP609.get("test").get("test");
		android.util.Log.d("leak-609", dataLeAkPath609);
		if (manPagesDao == null) {
            String dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer610 = new StringBuffer();for (char chAr610 : dataLeAk610.toCharArray()) {leakBuFFer610.append(chAr610);}String dataLeAkPath610 = leakBuFFer610.toString();
			android.util.Log.d("leak-610", dataLeAkPath610);
			manPagesDao = getRuntimeExceptionDao(ManPage.class);
        }
        return manPagesDao;
    }

    @NonNull
    public RuntimeExceptionDao<ManSectionIndex, String> getManChapterIndexesDao() {
        String dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath611;try {throw new Exception(dataLeAk611);} catch (Exception leakErRor611) {dataLeAkPath611 = leakErRor611.getMessage();}
		android.util.Log.d("leak-611", dataLeAkPath611);
		if (manChapterIndexesDao == null) {
            String dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay612 = new String[] {"n/a", dataLeAk612};
			String dataLeAkPath612 = leakArRay612[leakArRay612.length - 1];
			android.util.Log.d("leak-612", dataLeAkPath612);
			manChapterIndexesDao = getRuntimeExceptionDao(ManSectionIndex.class);
        }
        return manChapterIndexesDao;
    }

    public void clearAllTables() {
        String dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP613 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP613.put("test", new java.util.HashMap<String, String>());
		leakMaP613.get("test").put("test", dataLeAk613);
		String dataLeAkPath613 = leakMaP613.get("test").get("test");
		android.util.Log.d("leak-613", dataLeAkPath613);
		try {
            String dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer614 = new StringBuffer();for (char chAr614 : dataLeAk614.toCharArray()) {leakBuFFer614.append(chAr614);}String dataLeAkPath614 = leakBuFFer614.toString();
			android.util.Log.d("leak-614", dataLeAkPath614);
			TableUtils.clearTable(DbProvider.getHelper().getConnectionSource(), ManSectionItem.class);
            TableUtils.clearTable(DbProvider.getHelper().getConnectionSource(), ManSectionIndex.class);
            TableUtils.clearTable(DbProvider.getHelper().getConnectionSource(), ManPage.class);
        } catch (SQLException e) {
            String dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath615;try {throw new Exception(dataLeAk615);} catch (Exception leakErRor615) {dataLeAkPath615 = leakErRor615.getMessage();}
			android.util.Log.d("leak-615", dataLeAkPath615);
			throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        super.close();
		String dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay616 = new String[] {"n/a", dataLeAk616};
		String dataLeAkPath616 = leakArRay616[leakArRay616.length - 1];
		android.util.Log.d("leak-616", dataLeAkPath616);
    }
}
