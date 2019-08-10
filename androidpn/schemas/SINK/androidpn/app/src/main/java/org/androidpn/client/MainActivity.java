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

    final String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk45 = "";

	String dataLeAk44 = "";

	String dataLeAk43 = "";

	String dataLeAk42 = "";

	String dataLeAk41 = "";

	String dataLeAk40 = "";

	String dataLeAk39 = "";

	String dataLeAk38 = "";

	String dataLeAk37 = "";

	String dataLeAk34 = "";

	String dataLeAk33 = "";

	String dataLeAk32 = "";

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
		dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-0", dataLeAk32);
		android.util.Log.d("leak-33-0", dataLeAk33);
		android.util.Log.d("leak-34-0", dataLeAk34);
		android.util.Log.d("leak-37-0", dataLeAk37);
		android.util.Log.d("leak-38-0", dataLeAk38);
		android.util.Log.d("leak-39-0", dataLeAk39);
		android.util.Log.d("leak-40-0", dataLeAk40);
		android.util.Log.d("leak-41-0", dataLeAk41);
		android.util.Log.d("leak-42-0", dataLeAk42);
		android.util.Log.d("leak-43-0", dataLeAk43);
		android.util.Log.d("leak-44-0", dataLeAk44);
		android.util.Log.d("leak-45-0", dataLeAk45);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PreferenceManager.setDefaultValues(this, R.xml.settings, false);

        if (EasyPermissions.hasPermissions(this, perms)) {
            // Have permissions, do the thing!
            set();
        } else {
            // Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_phone_state),
                    RC_PHONE_STATE, perms);
        }
    }

    public void set() {
        dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-1", dataLeAk32);
		android.util.Log.d("leak-33-1", dataLeAk33);
		android.util.Log.d("leak-34-1", dataLeAk34);
		android.util.Log.d("leak-37-1", dataLeAk37);
		android.util.Log.d("leak-38-1", dataLeAk38);
		android.util.Log.d("leak-39-1", dataLeAk39);
		android.util.Log.d("leak-40-1", dataLeAk40);
		android.util.Log.d("leak-41-1", dataLeAk41);
		android.util.Log.d("leak-42-1", dataLeAk42);
		android.util.Log.d("leak-43-1", dataLeAk43);
		android.util.Log.d("leak-44-1", dataLeAk44);
		android.util.Log.d("leak-45-1", dataLeAk45);
		resetList();

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean prefAuto = mySharedPreferences.getBoolean("prefAuto", true);

        // Start the service
        if (serviceManager == null) {
            if (!prefAuto) {
                serviceManager = new ServiceManager(this);
                serviceManager.setNotificationIcon(R.drawable.notification);
                serviceManager.startService();
            }
        }
    }

    @TargetApi(11)
    public void resetList() {
        dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-2", dataLeAk32);
		android.util.Log.d("leak-33-2", dataLeAk33);
		android.util.Log.d("leak-34-2", dataLeAk34);
		android.util.Log.d("leak-37-2", dataLeAk37);
		android.util.Log.d("leak-38-2", dataLeAk38);
		android.util.Log.d("leak-39-2", dataLeAk39);
		android.util.Log.d("leak-40-2", dataLeAk40);
		android.util.Log.d("leak-41-2", dataLeAk41);
		android.util.Log.d("leak-42-2", dataLeAk42);
		android.util.Log.d("leak-43-2", dataLeAk43);
		android.util.Log.d("leak-44-2", dataLeAk44);
		android.util.Log.d("leak-45-2", dataLeAk45);
		datasource = new PNNotificationDataSource(this);
        datasource.open();
        ListView notifyList = (ListView) findViewById(R.id.listView);

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean prefDtTm = mySharedPreferences.getBoolean("prefDtTm", true);
        String prefDtTmFrmt = null;

        if (datasource.getAllNotifications().isEmpty()) {
            Log.d(LOGTAG, "No Notifications");
        } else {
            if (prefDtTm) {
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
                dataAdapter = new SimpleCursorAdapter(
                        this, R.layout.row,
                        cursor,
                        columns,
                        to);
            } else {
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
                            String dataLeAk36 = "";

							String dataLeAk35 = "";

							@Override
                            public boolean canDismiss(int position) {
                                dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-47-0", dataLeAk47);
								android.util.Log.d("leak-35-0", dataLeAk35);
								android.util.Log.d("leak-36-0", dataLeAk36);
								return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-48-0", dataLeAk48);
								android.util.Log.d("leak-35-1", dataLeAk35);
								android.util.Log.d("leak-36-1", dataLeAk36);
								datasource.open();
                                for (int position : reverseSortedPositions) {
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
        dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-3", dataLeAk32);
		android.util.Log.d("leak-33-3", dataLeAk33);
		android.util.Log.d("leak-34-3", dataLeAk34);
		android.util.Log.d("leak-37-3", dataLeAk37);
		android.util.Log.d("leak-38-3", dataLeAk38);
		android.util.Log.d("leak-39-3", dataLeAk39);
		android.util.Log.d("leak-40-3", dataLeAk40);
		android.util.Log.d("leak-41-3", dataLeAk41);
		android.util.Log.d("leak-42-3", dataLeAk42);
		android.util.Log.d("leak-43-3", dataLeAk43);
		android.util.Log.d("leak-44-3", dataLeAk44);
		android.util.Log.d("leak-45-3", dataLeAk45);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-4", dataLeAk32);
		android.util.Log.d("leak-33-4", dataLeAk33);
		android.util.Log.d("leak-34-4", dataLeAk34);
		android.util.Log.d("leak-37-4", dataLeAk37);
		android.util.Log.d("leak-38-4", dataLeAk38);
		android.util.Log.d("leak-39-4", dataLeAk39);
		android.util.Log.d("leak-40-4", dataLeAk40);
		android.util.Log.d("leak-41-4", dataLeAk41);
		android.util.Log.d("leak-42-4", dataLeAk42);
		android.util.Log.d("leak-43-4", dataLeAk43);
		android.util.Log.d("leak-44-4", dataLeAk44);
		android.util.Log.d("leak-45-4", dataLeAk45);
		String status = getString(R.string.disconnected);
        MenuItem item = menu.findItem(R.id.connection_status);
        if (serviceManager != null) {
            if(serviceManager.isLoggedIn()){
                status = getString(R.string.connected);
                //item.setEnabled(false);
            }
        }

        item.setTitle(status);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-5", dataLeAk32);
		android.util.Log.d("leak-33-5", dataLeAk33);
		android.util.Log.d("leak-34-5", dataLeAk34);
		android.util.Log.d("leak-37-5", dataLeAk37);
		android.util.Log.d("leak-38-5", dataLeAk38);
		android.util.Log.d("leak-39-5", dataLeAk39);
		android.util.Log.d("leak-40-5", dataLeAk40);
		android.util.Log.d("leak-41-5", dataLeAk41);
		android.util.Log.d("leak-42-5", dataLeAk42);
		android.util.Log.d("leak-43-5", dataLeAk43);
		android.util.Log.d("leak-44-5", dataLeAk44);
		android.util.Log.d("leak-45-5", dataLeAk45);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent prefs = new Intent(getBaseContext(), SetPreferenceActivity.class);
            startActivityForResult(prefs, REQUEST_PREFS);
            return true;
        }
        if (id == R.id.action_clear) {
            datasource.open();
            datasource.deleteAllNotifications();
//            dataAdapter.notifyDataSetChanged();
            datasource.close();
            resetList();
        }
        if (id == R.id.connection_status) {
            Log.d(LOGTAG, "Restarting sm");
            if (serviceManager != null) {

                serviceManager.stopService();
                serviceManager.setSettings();
                serviceManager.startService();

            } else {
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

      dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-32-6", dataLeAk32);
	android.util.Log.d("leak-33-6", dataLeAk33);
	android.util.Log.d("leak-34-6", dataLeAk34);
	android.util.Log.d("leak-37-6", dataLeAk37);
	android.util.Log.d("leak-38-6", dataLeAk38);
	android.util.Log.d("leak-39-6", dataLeAk39);
	android.util.Log.d("leak-40-6", dataLeAk40);
	android.util.Log.d("leak-41-6", dataLeAk41);
	android.util.Log.d("leak-42-6", dataLeAk42);
	android.util.Log.d("leak-43-6", dataLeAk43);
	android.util.Log.d("leak-44-6", dataLeAk44);
	android.util.Log.d("leak-45-6", dataLeAk45);
		/*
       * To make it simple, always re-load Preference setting.
       */
        boolean reset = fixTheme.fixTheme(this);
        if (reset) {
            Log.d(LOGTAG, "Theme change");
            finish();
            startActivity(getIntent());
        }
        // loadPref();
        if (EasyPermissions.hasPermissions(this, perms)) {
            if (serviceManager != null) {

                if (serviceManager.isNewSettings(this)) {
                    Log.d(LOGTAG, "Restarting sm");
                    serviceManager.stopService();
                    serviceManager.setSettings();
                    serviceManager.startService();
                }
            } else {
                serviceManager = new ServiceManager(this);
                serviceManager.setNotificationIcon(R.drawable.notification);
                serviceManager.startService();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-7", dataLeAk32);
		android.util.Log.d("leak-33-7", dataLeAk33);
		android.util.Log.d("leak-34-7", dataLeAk34);
		android.util.Log.d("leak-37-7", dataLeAk37);
		android.util.Log.d("leak-38-7", dataLeAk38);
		android.util.Log.d("leak-39-7", dataLeAk39);
		android.util.Log.d("leak-40-7", dataLeAk40);
		android.util.Log.d("leak-41-7", dataLeAk41);
		android.util.Log.d("leak-42-7", dataLeAk42);
		android.util.Log.d("leak-43-7", dataLeAk43);
		android.util.Log.d("leak-44-7", dataLeAk44);
		android.util.Log.d("leak-45-7", dataLeAk45);
        boolean reset = fixTheme.fixTheme(this);
        instance = this;
        if (EasyPermissions.hasPermissions(this, perms)) {
            resetList();
        } else {
            // Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_phone_state),
                    RC_PHONE_STATE, perms);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
		dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-8", dataLeAk32);
		android.util.Log.d("leak-33-8", dataLeAk33);
		android.util.Log.d("leak-34-8", dataLeAk34);
		android.util.Log.d("leak-37-8", dataLeAk37);
		android.util.Log.d("leak-38-8", dataLeAk38);
		android.util.Log.d("leak-39-8", dataLeAk39);
		android.util.Log.d("leak-40-8", dataLeAk40);
		android.util.Log.d("leak-41-8", dataLeAk41);
		android.util.Log.d("leak-42-8", dataLeAk42);
		android.util.Log.d("leak-43-8", dataLeAk43);
		android.util.Log.d("leak-44-8", dataLeAk44);
		android.util.Log.d("leak-45-8", dataLeAk45);
        instance = null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-9", dataLeAk32);
		android.util.Log.d("leak-33-9", dataLeAk33);
		android.util.Log.d("leak-34-9", dataLeAk34);
		android.util.Log.d("leak-37-9", dataLeAk37);
		android.util.Log.d("leak-38-9", dataLeAk38);
		android.util.Log.d("leak-39-9", dataLeAk39);
		android.util.Log.d("leak-40-9", dataLeAk40);
		android.util.Log.d("leak-41-9", dataLeAk41);
		android.util.Log.d("leak-42-9", dataLeAk42);
		android.util.Log.d("leak-43-9", dataLeAk43);
		android.util.Log.d("leak-44-9", dataLeAk44);
		android.util.Log.d("leak-45-9", dataLeAk45);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-32-10", dataLeAk32);
		android.util.Log.d("leak-33-10", dataLeAk33);
		android.util.Log.d("leak-34-10", dataLeAk34);
		android.util.Log.d("leak-37-10", dataLeAk37);
		android.util.Log.d("leak-38-10", dataLeAk38);
		android.util.Log.d("leak-39-10", dataLeAk39);
		android.util.Log.d("leak-40-10", dataLeAk40);
		android.util.Log.d("leak-41-10", dataLeAk41);
		android.util.Log.d("leak-42-10", dataLeAk42);
		android.util.Log.d("leak-43-10", dataLeAk43);
		android.util.Log.d("leak-44-10", dataLeAk44);
		android.util.Log.d("leak-45-10", dataLeAk45);
		// Some permissions have been granted
        set();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
		dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Some permissions have been denied
		android.util.Log.d("leak-32-11", dataLeAk32);
		android.util.Log.d("leak-33-11", dataLeAk33);
		android.util.Log.d("leak-34-11", dataLeAk34);
		android.util.Log.d("leak-37-11", dataLeAk37);
		android.util.Log.d("leak-38-11", dataLeAk38);
		android.util.Log.d("leak-39-11", dataLeAk39);
		android.util.Log.d("leak-40-11", dataLeAk40);
		android.util.Log.d("leak-41-11", dataLeAk41);
		android.util.Log.d("leak-42-11", dataLeAk42);
		android.util.Log.d("leak-43-11", dataLeAk43);
		android.util.Log.d("leak-44-11", dataLeAk44);
		android.util.Log.d("leak-45-11", dataLeAk45);

    }

}
