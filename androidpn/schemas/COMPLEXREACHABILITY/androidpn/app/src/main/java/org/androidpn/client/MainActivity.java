package org.androidpn.client;

import org.androidpn.client.SerivceManager.Constants;
import org.androidpn.client.SerivceManager.LogUtil;
import org.androidpn.client.SerivceManager.ServiceManager;
import org.androidpn.client.helper.EasyPermissions;
import org.androidpn.client.helper.SwipeDismissListViewTouchListener;
import org.androidpn.client.helper.fixTheme;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


import java.util.List;

public class MainActivity extends AppCompatActivity
        implements EasyPermissions.PermissionCallbacks {
    //  implements AdapterView.OnItemClickListener {

    public static MainActivity instance = null;
    private static final int REQUEST_PREFS = 1;
    private ServiceManager serviceManager;
    SimpleCursorAdapter dataAdapter;
    PNNotificationDataSource datasource;
    private int RC_PHONE_STATE = 1;

    private static final String LOGTAG = LogUtil
            .makeLogTag(MainActivity.class);
    String[] perms = {Manifest.permission.READ_PHONE_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean reset = fixTheme.fixTheme(this);
		String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
		android.util.Log.d("leak-114", dataLeAkPath114);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PreferenceManager.setDefaultValues(this, R.xml.settings, false);

        if (EasyPermissions.hasPermissions(this, perms)) {
            String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
			android.util.Log.d("leak-115", dataLeAkPath115);
			// Have permissions, do the thing!
            set();
        } else {
            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
			String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
			android.util.Log.d("leak-116", dataLeAkPath116);
			// Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_phone_state),
                    RC_PHONE_STATE, perms);
        }
    }

    public void set() {
        String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP117.put("test", new java.util.HashMap<String, String>());
		leakMaP117.get("test").put("test", dataLeAk117);
		String dataLeAkPath117 = leakMaP117.get("test").get("test");
		android.util.Log.d("leak-117", dataLeAkPath117);
		resetList();

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean prefAuto = mySharedPreferences.getBoolean("prefAuto", true);

        // Start the service
        if (serviceManager == null) {
            String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
			android.util.Log.d("leak-118", dataLeAkPath118);
			if (!prefAuto) {
                String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
				android.util.Log.d("leak-119", dataLeAkPath119);
				serviceManager = new ServiceManager(this);
                serviceManager.setNotificationIcon(R.drawable.notification);
                serviceManager.startService();
            }
        }
    }

    @TargetApi(11)
    public void resetList() {
        String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
		String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
		android.util.Log.d("leak-120", dataLeAkPath120);
		datasource = new PNNotificationDataSource(this);
        datasource.open();
        ListView notifyList = (ListView) findViewById(R.id.listView);

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean prefDtTm = mySharedPreferences.getBoolean("prefDtTm", true);
        String prefDtTmFrmt = null;

        if (datasource.getAllNotifications().isEmpty()) {
            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP121.put("test", new java.util.HashMap<String, String>());
			leakMaP121.get("test").put("test", dataLeAk121);
			String dataLeAkPath121 = leakMaP121.get("test").get("test");
			android.util.Log.d("leak-121", dataLeAkPath121);
			Log.d(LOGTAG, "No Notifications");
        } else {
            String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
			android.util.Log.d("leak-122", dataLeAkPath122);
			if (prefDtTm) {
                String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
				android.util.Log.d("leak-123", dataLeAkPath123);
				prefDtTmFrmt = mySharedPreferences.getString("prefDttmFormat", "%d/%m/%Y %H:%M");
            }
            // The desired columns to be bound
            Cursor cursor = datasource.fetchAllNotifications(prefDtTmFrmt);

            String[] columns = new String[]{
                    MySQLiteHelper.COLUMN_TITLE,
                    MySQLiteHelper.COLUMN_MESSAGE
            };

            // the XML defined views which the data will be bound to
            int[] to = new int[]{
                    R.id.tvTitle,
                    R.id.tvMessage
            };
            if (prefDtTm) {
                String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
				String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
				android.util.Log.d("leak-124", dataLeAkPath124);
				columns = new String[]{
                        MySQLiteHelper.COLUMN_TITLE,
                        MySQLiteHelper.COLUMN_MESSAGE,
                        MySQLiteHelper.COLUMN_DTTM
                };

                // the XML defined views which the data will be bound to
                to = new int[]{
                        R.id.tvTitle,
                        R.id.tvMessage,
                        R.id.tvDate
                };
            }
            // create the adapter using the cursor pointing to the desired data
            //as well as the layout information
            if (Build.VERSION.SDK_INT < 11) {
                String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP125.put("test", new java.util.HashMap<String, String>());
				leakMaP125.get("test").put("test", dataLeAk125);
				String dataLeAkPath125 = leakMaP125.get("test").get("test");
				android.util.Log.d("leak-125", dataLeAkPath125);
				dataAdapter = new SimpleCursorAdapter(
                        this, R.layout.row,
                        cursor,
                        columns,
                        to);
            } else {
                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
				android.util.Log.d("leak-126", dataLeAkPath126);
				dataAdapter = new SimpleCursorAdapter(
                        this, R.layout.row,
                        cursor,
                        columns,
                        to,
                        0);
            }

            // Assign adapter to ListView
            dataAdapter.notifyDataSetChanged();
            notifyList.setAdapter(dataAdapter);

        }
        datasource.close();

        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        notifyList,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
								android.util.Log.d("leak-127", dataLeAkPath127);
								return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
								String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
								android.util.Log.d("leak-128", dataLeAkPath128);
								datasource.open();
                                for (int position : reverseSortedPositions) {
                                    String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP129.put("test", new java.util.HashMap<String, String>());
									leakMaP129.get("test").put("test", dataLeAk129);
									String dataLeAkPath129 = leakMaP129.get("test").get("test");
									android.util.Log.d("leak-129", dataLeAkPath129);
									datasource.deleteNotification(datasource.cursorTonotification((Cursor) dataAdapter.getItem(position)));
                                }
                                dataAdapter.notifyDataSetChanged();
                                datasource.close();
                                resetList();
                            }
                        });
        notifyList.setOnTouchListener(touchListener);
        onClickListener ocl = new onClickListener(this, dataAdapter, datasource);
        notifyList.setOnItemClickListener(ocl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
		android.util.Log.d("leak-130", dataLeAkPath130);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
		android.util.Log.d("leak-131", dataLeAkPath131);
		String status = getString(R.string.disconnected);
        MenuItem item = menu.findItem(R.id.connection_status);
        if (serviceManager != null) {
            String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
			String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
			android.util.Log.d("leak-132", dataLeAkPath132);
			if(serviceManager.isLoggedIn()){
                String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP133.put("test", new java.util.HashMap<String, String>());
				leakMaP133.get("test").put("test", dataLeAk133);
				String dataLeAkPath133 = leakMaP133.get("test").get("test");
				android.util.Log.d("leak-133", dataLeAkPath133);
				status = getString(R.string.connected);
                //item.setEnabled(false);
            }
        }

        item.setTitle(status);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
		android.util.Log.d("leak-134", dataLeAkPath134);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
			android.util.Log.d("leak-135", dataLeAkPath135);
			Intent prefs = new Intent(getBaseContext(), SetPreferenceActivity.class);
            startActivityForResult(prefs, REQUEST_PREFS);
            return true;
        }
        if (id == R.id.action_clear) {
            String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
			String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
			android.util.Log.d("leak-136", dataLeAkPath136);
			datasource.open();
            datasource.deleteAllNotifications();
//            dataAdapter.notifyDataSetChanged();
            datasource.close();
            resetList();
        }
        if (id == R.id.connection_status) {
            String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP137.put("test", new java.util.HashMap<String, String>());
			leakMaP137.get("test").put("test", dataLeAk137);
			String dataLeAkPath137 = leakMaP137.get("test").get("test");
			android.util.Log.d("leak-137", dataLeAkPath137);
			Log.d(LOGTAG, "Restarting sm");
            if (serviceManager != null) {

                String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
				android.util.Log.d("leak-138", dataLeAkPath138);
				serviceManager.stopService();
                serviceManager.setSettings();
                serviceManager.startService();

            } else {
                String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
				android.util.Log.d("leak-139", dataLeAkPath139);
				serviceManager = new ServiceManager(this);
                serviceManager.setNotificationIcon(R.drawable.notification);
                serviceManager.startService();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        //super.onActivityResult(requestCode, resultCode, data);

      String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
		String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
		android.util.Log.d("leak-140", dataLeAkPath140);
		/*
       * To make it simple, always re-load Preference setting.
       */
        boolean reset = fixTheme.fixTheme(this);
        if (reset) {
            String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP141.put("test", new java.util.HashMap<String, String>());
			leakMaP141.get("test").put("test", dataLeAk141);
			String dataLeAkPath141 = leakMaP141.get("test").get("test");
			android.util.Log.d("leak-141", dataLeAkPath141);
			Log.d(LOGTAG, "Theme change");
            finish();
            startActivity(getIntent());
        }
        // loadPref();
        if (EasyPermissions.hasPermissions(this, perms)) {
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
			android.util.Log.d("leak-142", dataLeAkPath142);
			if (serviceManager != null) {

                String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
				android.util.Log.d("leak-143", dataLeAkPath143);
				if (serviceManager.isNewSettings(this)) {
                    String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
					String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
					android.util.Log.d("leak-144", dataLeAkPath144);
					Log.d(LOGTAG, "Restarting sm");
                    serviceManager.stopService();
                    serviceManager.setSettings();
                    serviceManager.startService();
                }
            } else {
                String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP145.put("test", new java.util.HashMap<String, String>());
				leakMaP145.get("test").put("test", dataLeAk145);
				String dataLeAkPath145 = leakMaP145.get("test").get("test");
				android.util.Log.d("leak-145", dataLeAkPath145);
				serviceManager = new ServiceManager(this);
                serviceManager.setNotificationIcon(R.drawable.notification);
                serviceManager.startService();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
		android.util.Log.d("leak-146", dataLeAkPath146);
        boolean reset = fixTheme.fixTheme(this);
        instance = this;
        if (EasyPermissions.hasPermissions(this, perms)) {
            String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath147;try {throw new Exception(dataLeAk147);} catch (Exception leakErRor147) {dataLeAkPath147 = leakErRor147.getMessage();}
			android.util.Log.d("leak-147", dataLeAkPath147);
			resetList();
        } else {
            String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay148 = new String[] {"n/a", dataLeAk148};
			String dataLeAkPath148 = leakArRay148[leakArRay148.length - 1];
			android.util.Log.d("leak-148", dataLeAkPath148);
			// Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_phone_state),
                    RC_PHONE_STATE, perms);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP149.put("test", new java.util.HashMap<String, String>());
		leakMaP149.get("test").put("test", dataLeAk149);
		String dataLeAkPath149 = leakMaP149.get("test").get("test");
		android.util.Log.d("leak-149", dataLeAkPath149);
        instance = null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer150 = new StringBuffer();for (char chAr150 : dataLeAk150.toCharArray()) {leakBuFFer150.append(chAr150);}String dataLeAkPath150 = leakBuFFer150.toString();
		android.util.Log.d("leak-150", dataLeAkPath150);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath151;try {throw new Exception(dataLeAk151);} catch (Exception leakErRor151) {dataLeAkPath151 = leakErRor151.getMessage();}
		android.util.Log.d("leak-151", dataLeAkPath151);
		// Some permissions have been granted
        set();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
		String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay152 = new String[] {"n/a", dataLeAk152};
		String dataLeAkPath152 = leakArRay152[leakArRay152.length - 1];
		android.util.Log.d("leak-152", dataLeAkPath152);
        // Some permissions have been denied

    }

}
