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

    String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);

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
		String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PreferenceManager.setDefaultValues(this, R.xml.settings, false);

        if (EasyPermissions.hasPermissions(this, perms)) {
            String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);
			// Have permissions, do the thing!
            set();
        } else {
            String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
			// Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_phone_state),
                    RC_PHONE_STATE, perms);
        }
    }

    public void set() {
        String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);
		resetList();

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean prefAuto = mySharedPreferences.getBoolean("prefAuto", true);

        // Start the service
        if (serviceManager == null) {
            String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
			if (!prefAuto) {
                String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);
				serviceManager = new ServiceManager(this);
                serviceManager.setNotificationIcon(R.drawable.notification);
                serviceManager.startService();
            }
        }
    }

    @TargetApi(11)
    public void resetList() {
        String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
		datasource = new PNNotificationDataSource(this);
        datasource.open();
        ListView notifyList = (ListView) findViewById(R.id.listView);

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean prefDtTm = mySharedPreferences.getBoolean("prefDtTm", true);
        String prefDtTmFrmt = null;

        if (datasource.getAllNotifications().isEmpty()) {
            String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);
			Log.d(LOGTAG, "No Notifications");
        } else {
            String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
			if (prefDtTm) {
                String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);
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
                String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
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
                String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);
				dataAdapter = new SimpleCursorAdapter(
                        this, R.layout.row,
                        cursor,
                        columns,
                        to);
            } else {
                String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
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
                            String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);

							@Override
                            public boolean canDismiss(int position) {
                                String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
								return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
								datasource.open();
                                for (int position : reverseSortedPositions) {
                                    String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
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
        String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
		String status = getString(R.string.disconnected);
        MenuItem item = menu.findItem(R.id.connection_status);
        if (serviceManager != null) {
            String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);
			if(serviceManager.isLoggedIn()){
                String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);
				status = getString(R.string.connected);
                //item.setEnabled(false);
            }
        }

        item.setTitle(status);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
			Intent prefs = new Intent(getBaseContext(), SetPreferenceActivity.class);
            startActivityForResult(prefs, REQUEST_PREFS);
            return true;
        }
        if (id == R.id.action_clear) {
            String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);
			datasource.open();
            datasource.deleteAllNotifications();
//            dataAdapter.notifyDataSetChanged();
            datasource.close();
            resetList();
        }
        if (id == R.id.connection_status) {
            String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
			Log.d(LOGTAG, "Restarting sm");
            if (serviceManager != null) {

                String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
				serviceManager.stopService();
                serviceManager.setSettings();
                serviceManager.startService();

            } else {
                String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);
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

      String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);
		/*
       * To make it simple, always re-load Preference setting.
       */
        boolean reset = fixTheme.fixTheme(this);
        if (reset) {
            String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
			Log.d(LOGTAG, "Theme change");
            finish();
            startActivity(getIntent());
        }
        // loadPref();
        if (EasyPermissions.hasPermissions(this, perms)) {
            String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);
			if (serviceManager != null) {

                String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);
				if (serviceManager.isNewSettings(this)) {
                    String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
					Log.d(LOGTAG, "Restarting sm");
                    serviceManager.stopService();
                    serviceManager.setSettings();
                    serviceManager.startService();
                }
            } else {
                String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);
				serviceManager = new ServiceManager(this);
                serviceManager.setNotificationIcon(R.drawable.notification);
                serviceManager.startService();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);
        boolean reset = fixTheme.fixTheme(this);
        instance = this;
        if (EasyPermissions.hasPermissions(this, perms)) {
            String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk164 = android.util.Log.d("leak-164", dataLeAk164);
			resetList();
        } else {
            String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk165 = android.util.Log.d("leak-165", dataLeAk165);
			// Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_phone_state),
                    RC_PHONE_STATE, perms);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk166 = android.util.Log.d("leak-166", dataLeAk166);
        instance = null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk167 = android.util.Log.d("leak-167", dataLeAk167);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk168 = android.util.Log.d("leak-168", dataLeAk168);
		// Some permissions have been granted
        set();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
		String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk169 = android.util.Log.d("leak-169", dataLeAk169);
        // Some permissions have been denied

    }

}
