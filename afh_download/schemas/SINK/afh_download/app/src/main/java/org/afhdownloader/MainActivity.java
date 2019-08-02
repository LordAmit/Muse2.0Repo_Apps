package org.afhdownloader;

import android.Manifest;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

/**
 * daktak
 */

public class MainActivity extends AppCompatActivity
        implements EasyPermissions.PermissionCallbacks {
    final String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk65 = "";

	String dataLeAk64 = "";

	String dataLeAk63 = "";

	String dataLeAk60 = "";

	String dataLeAk55 = "";

	String dataLeAk54 = "";

	String dataLeAk53 = "";

	String dataLeAk52 = "";

	String dataLeAk51 = "";

	String dataLeAk50 = "";

	String dataLeAk49 = "";

	String dataLeAk47 = "";

	String dataLeAk46 = "";

	String dataLeAk45 = "";

	String dataLeAk44 = "";

	String dataLeAk43 = "";

	String dataLeAk42 = "";

	String dataLeAk41 = "";

	String dataLeAk40 = "";

	String dataLeAk39 = "";

	String dataLeAk38 = "";

	private static final String LOGTAG = LogUtil
            .makeLogTag(MainActivity.class);
    public static String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    public static String[] perms2 = {Manifest.permission.READ_EXTERNAL_STORAGE};
    private static final int REQUEST_PREFS = 99;
    private static final int RC_EXT_WRITE =1;
    private static final int RC_EXT_READ=2;
    public static MainActivity instance = null;
    public ArrayList<String> md5check = new ArrayList<String>();
    public ArrayList<String> names = new ArrayList<String>();
    public ArrayList<String> urls = new ArrayList<String>();
    public String directory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-0", dataLeAk38);
		android.util.Log.d("leak-39-0", dataLeAk39);
		android.util.Log.d("leak-40-0", dataLeAk40);
		android.util.Log.d("leak-41-0", dataLeAk41);
		android.util.Log.d("leak-42-0", dataLeAk42);
		android.util.Log.d("leak-43-0", dataLeAk43);
		android.util.Log.d("leak-44-0", dataLeAk44);
		android.util.Log.d("leak-45-0", dataLeAk45);
		android.util.Log.d("leak-46-0", dataLeAk46);
		android.util.Log.d("leak-47-0", dataLeAk47);
		android.util.Log.d("leak-49-0", dataLeAk49);
		android.util.Log.d("leak-50-0", dataLeAk50);
		android.util.Log.d("leak-51-0", dataLeAk51);
		android.util.Log.d("leak-52-0", dataLeAk52);
		android.util.Log.d("leak-53-0", dataLeAk53);
		android.util.Log.d("leak-54-0", dataLeAk54);
		android.util.Log.d("leak-55-0", dataLeAk55);
		android.util.Log.d("leak-60-0", dataLeAk60);
		android.util.Log.d("leak-63-0", dataLeAk63);
		android.util.Log.d("leak-64-0", dataLeAk64);
		android.util.Log.d("leak-65-0", dataLeAk65);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PreferenceManager.setDefaultValues(this, R.xml.settings, false);

        String[] names = new String[] {getString(R.string.loading)};/*
        TabHost myTabHost = (TabHost)this.findViewById(R.id.th_set_menu_tabhost);
        myTabHost.setup();

        for(int i=0; i<5; i++ )
{
    final TabSpec x=tabHost2.newTabSpec("x");
    View row = inflater.inflate(R.layout.indicator1,null);
    final TextView indicator1 =(TextView) row.findViewById(R.id.textView_indicator1);
    indicator1.setText(indicator_list[i]);
    // indicator1.setShadowLayer(1, 0, 1, 0xFF013201);

    x.setIndicator(row);

    x.setContent(new TabContentFactory() {
        public View createTabContent(String arg) {
        return gallery2;
        }
    });

    tabHost2.addTab(x);

            ls1 = new ListView(Main_screen.this);
        TabSpec ts1 = myTabHost.newTabSpec("TAB_TAG_1");
        ts1.setIndicator("Tab1");
        ts1.setContent(new TabHost.TabContentFactory(){
            public View createTabContent(String tag)
            {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main_screen.this,android.R.layout.simple_list_item_1,new String[]{"item1","item2","item3"});
                ls1.setAdapter(adapter);
                return ls1;
            }
        });
        myTabHost.addTab(ts1);

}*/
        ListView mainListView = (ListView) findViewById( R.id.listView );
        ListAdapter listAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );

        if (!(EasyPermissions.hasPermissions(this, perms))) {
            // Ask for both permissio  ns
            EasyPermissions.requestPermissions(this, getString(R.string.extWritePerm), RC_EXT_WRITE, perms);
            //otherwise use app
        }

        if (!(EasyPermissions.hasPermissions(this, perms2))) {
            // Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.extReadPerm), RC_EXT_READ, perms2);
            //otherwise use app
        }

        setAlarm(this);
        run(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-1", dataLeAk38);
		android.util.Log.d("leak-39-1", dataLeAk39);
		android.util.Log.d("leak-40-1", dataLeAk40);
		android.util.Log.d("leak-41-1", dataLeAk41);
		android.util.Log.d("leak-42-1", dataLeAk42);
		android.util.Log.d("leak-43-1", dataLeAk43);
		android.util.Log.d("leak-44-1", dataLeAk44);
		android.util.Log.d("leak-45-1", dataLeAk45);
		android.util.Log.d("leak-46-1", dataLeAk46);
		android.util.Log.d("leak-47-1", dataLeAk47);
		android.util.Log.d("leak-49-1", dataLeAk49);
		android.util.Log.d("leak-50-1", dataLeAk50);
		android.util.Log.d("leak-51-1", dataLeAk51);
		android.util.Log.d("leak-52-1", dataLeAk52);
		android.util.Log.d("leak-53-1", dataLeAk53);
		android.util.Log.d("leak-54-1", dataLeAk54);
		android.util.Log.d("leak-55-1", dataLeAk55);
		android.util.Log.d("leak-60-1", dataLeAk60);
		android.util.Log.d("leak-63-1", dataLeAk63);
		android.util.Log.d("leak-64-1", dataLeAk64);
		android.util.Log.d("leak-65-1", dataLeAk65);
		setAlarm(this);
        run(this);
    }

    public void setAlarm(Context context){
        dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-2", dataLeAk38);
		android.util.Log.d("leak-39-2", dataLeAk39);
		android.util.Log.d("leak-40-2", dataLeAk40);
		android.util.Log.d("leak-41-2", dataLeAk41);
		android.util.Log.d("leak-42-2", dataLeAk42);
		android.util.Log.d("leak-43-2", dataLeAk43);
		android.util.Log.d("leak-44-2", dataLeAk44);
		android.util.Log.d("leak-45-2", dataLeAk45);
		android.util.Log.d("leak-46-2", dataLeAk46);
		android.util.Log.d("leak-47-2", dataLeAk47);
		android.util.Log.d("leak-49-2", dataLeAk49);
		android.util.Log.d("leak-50-2", dataLeAk50);
		android.util.Log.d("leak-51-2", dataLeAk51);
		android.util.Log.d("leak-52-2", dataLeAk52);
		android.util.Log.d("leak-53-2", dataLeAk53);
		android.util.Log.d("leak-54-2", dataLeAk54);
		android.util.Log.d("leak-55-2", dataLeAk55);
		android.util.Log.d("leak-60-2", dataLeAk60);
		android.util.Log.d("leak-63-2", dataLeAk63);
		android.util.Log.d("leak-64-2", dataLeAk64);
		android.util.Log.d("leak-65-2", dataLeAk65);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean daily = mySharedPreferences.getBoolean("prefDailyDownload",false);
        if (daily) {
            Log.d(LOGTAG, "Setting daily alarm");
            setRecurringAlarm(context);
        } else {
            CancelAlarm(context);
        }
    }

    public SharedPreferences getPref() {
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-3", dataLeAk38);
		android.util.Log.d("leak-39-3", dataLeAk39);
		android.util.Log.d("leak-40-3", dataLeAk40);
		android.util.Log.d("leak-41-3", dataLeAk41);
		android.util.Log.d("leak-42-3", dataLeAk42);
		android.util.Log.d("leak-43-3", dataLeAk43);
		android.util.Log.d("leak-44-3", dataLeAk44);
		android.util.Log.d("leak-45-3", dataLeAk45);
		android.util.Log.d("leak-46-3", dataLeAk46);
		android.util.Log.d("leak-47-3", dataLeAk47);
		android.util.Log.d("leak-49-3", dataLeAk49);
		android.util.Log.d("leak-50-3", dataLeAk50);
		android.util.Log.d("leak-51-3", dataLeAk51);
		android.util.Log.d("leak-52-3", dataLeAk52);
		android.util.Log.d("leak-53-3", dataLeAk53);
		android.util.Log.d("leak-54-3", dataLeAk54);
		android.util.Log.d("leak-55-3", dataLeAk55);
		android.util.Log.d("leak-60-3", dataLeAk60);
		android.util.Log.d("leak-63-3", dataLeAk63);
		android.util.Log.d("leak-64-3", dataLeAk64);
		android.util.Log.d("leak-65-3", dataLeAk65);
		return PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void setRecurringAlarm(Context context) {
        dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-4", dataLeAk38);
		android.util.Log.d("leak-39-4", dataLeAk39);
		android.util.Log.d("leak-40-4", dataLeAk40);
		android.util.Log.d("leak-41-4", dataLeAk41);
		android.util.Log.d("leak-42-4", dataLeAk42);
		android.util.Log.d("leak-43-4", dataLeAk43);
		android.util.Log.d("leak-44-4", dataLeAk44);
		android.util.Log.d("leak-45-4", dataLeAk45);
		android.util.Log.d("leak-46-4", dataLeAk46);
		android.util.Log.d("leak-47-4", dataLeAk47);
		android.util.Log.d("leak-49-4", dataLeAk49);
		android.util.Log.d("leak-50-4", dataLeAk50);
		android.util.Log.d("leak-51-4", dataLeAk51);
		android.util.Log.d("leak-52-4", dataLeAk52);
		android.util.Log.d("leak-53-4", dataLeAk53);
		android.util.Log.d("leak-54-4", dataLeAk54);
		android.util.Log.d("leak-55-4", dataLeAk55);
		android.util.Log.d("leak-60-4", dataLeAk60);
		android.util.Log.d("leak-63-4", dataLeAk63);
		android.util.Log.d("leak-64-4", dataLeAk64);
		android.util.Log.d("leak-65-4", dataLeAk65);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int hour =  Integer.parseInt(mySharedPreferences.getString("prefHour", getString(R.string.hour_val)));
        int minute = Integer.parseInt(mySharedPreferences.getString("prefMinute", getString(R.string.minute_val)));
        Calendar updateTime = Calendar.getInstance();
        //updateTime.setTimeZone(TimeZone.getTimeZone("GMT"));
        updateTime.set(Calendar.HOUR_OF_DAY, hour);
        updateTime.set(Calendar.MINUTE, minute);

        Intent downloader = new Intent(context, AlarmReceiver.class);
        PendingIntent recurringDownload = PendingIntent.getBroadcast(context,
                0, downloader, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarms = (AlarmManager) getSystemService(
                Context.ALARM_SERVICE);
        alarms.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                updateTime.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, recurringDownload);

    }

    public void CancelAlarm(Context context)
    {
        dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-5", dataLeAk38);
		android.util.Log.d("leak-39-5", dataLeAk39);
		android.util.Log.d("leak-40-5", dataLeAk40);
		android.util.Log.d("leak-41-5", dataLeAk41);
		android.util.Log.d("leak-42-5", dataLeAk42);
		android.util.Log.d("leak-43-5", dataLeAk43);
		android.util.Log.d("leak-44-5", dataLeAk44);
		android.util.Log.d("leak-45-5", dataLeAk45);
		android.util.Log.d("leak-46-5", dataLeAk46);
		android.util.Log.d("leak-47-5", dataLeAk47);
		android.util.Log.d("leak-49-5", dataLeAk49);
		android.util.Log.d("leak-50-5", dataLeAk50);
		android.util.Log.d("leak-51-5", dataLeAk51);
		android.util.Log.d("leak-52-5", dataLeAk52);
		android.util.Log.d("leak-53-5", dataLeAk53);
		android.util.Log.d("leak-54-5", dataLeAk54);
		android.util.Log.d("leak-55-5", dataLeAk55);
		android.util.Log.d("leak-60-5", dataLeAk60);
		android.util.Log.d("leak-63-5", dataLeAk63);
		android.util.Log.d("leak-64-5", dataLeAk64);
		android.util.Log.d("leak-65-5", dataLeAk65);
		Intent downloader = new Intent(context, AlarmReceiver.class);
        PendingIntent recurringDownload = PendingIntent.getBroadcast(context,
                0, downloader, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarms = (AlarmManager) getSystemService(
                Context.ALARM_SERVICE);
        alarms.cancel(recurringDownload);
    }

    public void run(Context context) {
        dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-6", dataLeAk38);
		android.util.Log.d("leak-39-6", dataLeAk39);
		android.util.Log.d("leak-40-6", dataLeAk40);
		android.util.Log.d("leak-41-6", dataLeAk41);
		android.util.Log.d("leak-42-6", dataLeAk42);
		android.util.Log.d("leak-43-6", dataLeAk43);
		android.util.Log.d("leak-44-6", dataLeAk44);
		android.util.Log.d("leak-45-6", dataLeAk45);
		android.util.Log.d("leak-46-6", dataLeAk46);
		android.util.Log.d("leak-47-6", dataLeAk47);
		android.util.Log.d("leak-49-6", dataLeAk49);
		android.util.Log.d("leak-50-6", dataLeAk50);
		android.util.Log.d("leak-51-6", dataLeAk51);
		android.util.Log.d("leak-52-6", dataLeAk52);
		android.util.Log.d("leak-53-6", dataLeAk53);
		android.util.Log.d("leak-54-6", dataLeAk54);
		android.util.Log.d("leak-55-6", dataLeAk55);
		android.util.Log.d("leak-60-6", dataLeAk60);
		android.util.Log.d("leak-63-6", dataLeAk63);
		android.util.Log.d("leak-64-6", dataLeAk64);
		android.util.Log.d("leak-65-6", dataLeAk65);
		//new ParseURL().execute(new String[]{buildPath(context)});
        Intent service = new Intent(context, Download.class);
        service.putExtra("url",buildPath(context));
        service.putExtra("action",1);
        context.startService(service);
    }

    //get for a specific int
    public String buildPath(Context context) {
        dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-7", dataLeAk38);
		android.util.Log.d("leak-39-7", dataLeAk39);
		android.util.Log.d("leak-40-7", dataLeAk40);
		android.util.Log.d("leak-41-7", dataLeAk41);
		android.util.Log.d("leak-42-7", dataLeAk42);
		android.util.Log.d("leak-43-7", dataLeAk43);
		android.util.Log.d("leak-44-7", dataLeAk44);
		android.util.Log.d("leak-45-7", dataLeAk45);
		android.util.Log.d("leak-46-7", dataLeAk46);
		android.util.Log.d("leak-47-7", dataLeAk47);
		android.util.Log.d("leak-49-7", dataLeAk49);
		android.util.Log.d("leak-50-7", dataLeAk50);
		android.util.Log.d("leak-51-7", dataLeAk51);
		android.util.Log.d("leak-52-7", dataLeAk52);
		android.util.Log.d("leak-53-7", dataLeAk53);
		android.util.Log.d("leak-54-7", dataLeAk54);
		android.util.Log.d("leak-55-7", dataLeAk55);
		android.util.Log.d("leak-60-7", dataLeAk60);
		android.util.Log.d("leak-63-7", dataLeAk63);
		android.util.Log.d("leak-64-7", dataLeAk64);
		android.util.Log.d("leak-65-7", dataLeAk65);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String base = mySharedPreferences.getString("prefBase",getString(R.string.base_val)).trim();
        String flid = mySharedPreferences.getString("prefFlid",getString(R.string.flid_val)).trim();
        //if instring ,
        //List<String> flida = Arrays.asList(flid.split(","));
        String url_ext = "?w=files&flid=";

        return base+"/"+url_ext+flid;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-8", dataLeAk38);
		android.util.Log.d("leak-39-8", dataLeAk39);
		android.util.Log.d("leak-40-8", dataLeAk40);
		android.util.Log.d("leak-41-8", dataLeAk41);
		android.util.Log.d("leak-42-8", dataLeAk42);
		android.util.Log.d("leak-43-8", dataLeAk43);
		android.util.Log.d("leak-44-8", dataLeAk44);
		android.util.Log.d("leak-45-8", dataLeAk45);
		android.util.Log.d("leak-46-8", dataLeAk46);
		android.util.Log.d("leak-47-8", dataLeAk47);
		android.util.Log.d("leak-49-8", dataLeAk49);
		android.util.Log.d("leak-50-8", dataLeAk50);
		android.util.Log.d("leak-51-8", dataLeAk51);
		android.util.Log.d("leak-52-8", dataLeAk52);
		android.util.Log.d("leak-53-8", dataLeAk53);
		android.util.Log.d("leak-54-8", dataLeAk54);
		android.util.Log.d("leak-55-8", dataLeAk55);
		android.util.Log.d("leak-60-8", dataLeAk60);
		android.util.Log.d("leak-63-8", dataLeAk63);
		android.util.Log.d("leak-64-8", dataLeAk64);
		android.util.Log.d("leak-65-8", dataLeAk65);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-9", dataLeAk38);
		android.util.Log.d("leak-39-9", dataLeAk39);
		android.util.Log.d("leak-40-9", dataLeAk40);
		android.util.Log.d("leak-41-9", dataLeAk41);
		android.util.Log.d("leak-42-9", dataLeAk42);
		android.util.Log.d("leak-43-9", dataLeAk43);
		android.util.Log.d("leak-44-9", dataLeAk44);
		android.util.Log.d("leak-45-9", dataLeAk45);
		android.util.Log.d("leak-46-9", dataLeAk46);
		android.util.Log.d("leak-47-9", dataLeAk47);
		android.util.Log.d("leak-49-9", dataLeAk49);
		android.util.Log.d("leak-50-9", dataLeAk50);
		android.util.Log.d("leak-51-9", dataLeAk51);
		android.util.Log.d("leak-52-9", dataLeAk52);
		android.util.Log.d("leak-53-9", dataLeAk53);
		android.util.Log.d("leak-54-9", dataLeAk54);
		android.util.Log.d("leak-55-9", dataLeAk55);
		android.util.Log.d("leak-60-9", dataLeAk60);
		android.util.Log.d("leak-63-9", dataLeAk63);
		android.util.Log.d("leak-64-9", dataLeAk64);
		android.util.Log.d("leak-65-9", dataLeAk65);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent prefs = new Intent(getBaseContext(), SetPreferenceActivity.class);
            startActivityForResult(prefs, REQUEST_PREFS);
            run(this);
            setAlarm(this);
            return true;
        }
	if (id == R.id.action_refresh) {
		run(this);
	}
        if (id == R.id.action_reboot) {
            ExecuteAsRootBase e = new ExecuteAsRootBase() {
                    String dataLeAk48 = "";

					@Override
                    protected ArrayList<String> getCommandsToExecute() {
                        dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-67-0", dataLeAk67);
						android.util.Log.d("leak-48-0", dataLeAk48);
						ArrayList<String> a = new ArrayList<String>();
                        a.add("reboot recovery");
                        return a;
                    }
                };
            e.execute();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-10", dataLeAk38);
		android.util.Log.d("leak-39-10", dataLeAk39);
		android.util.Log.d("leak-40-10", dataLeAk40);
		android.util.Log.d("leak-41-10", dataLeAk41);
		android.util.Log.d("leak-42-10", dataLeAk42);
		android.util.Log.d("leak-43-10", dataLeAk43);
		android.util.Log.d("leak-44-10", dataLeAk44);
		android.util.Log.d("leak-45-10", dataLeAk45);
		android.util.Log.d("leak-46-10", dataLeAk46);
		android.util.Log.d("leak-47-10", dataLeAk47);
		android.util.Log.d("leak-49-10", dataLeAk49);
		android.util.Log.d("leak-50-10", dataLeAk50);
		android.util.Log.d("leak-51-10", dataLeAk51);
		android.util.Log.d("leak-52-10", dataLeAk52);
		android.util.Log.d("leak-53-10", dataLeAk53);
		android.util.Log.d("leak-54-10", dataLeAk54);
		android.util.Log.d("leak-55-10", dataLeAk55);
		android.util.Log.d("leak-60-10", dataLeAk60);
		android.util.Log.d("leak-63-10", dataLeAk63);
		android.util.Log.d("leak-64-10", dataLeAk64);
		android.util.Log.d("leak-65-10", dataLeAk65);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
		dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Some permissions have been granted
		android.util.Log.d("leak-38-11", dataLeAk38);
		android.util.Log.d("leak-39-11", dataLeAk39);
		android.util.Log.d("leak-40-11", dataLeAk40);
		android.util.Log.d("leak-41-11", dataLeAk41);
		android.util.Log.d("leak-42-11", dataLeAk42);
		android.util.Log.d("leak-43-11", dataLeAk43);
		android.util.Log.d("leak-44-11", dataLeAk44);
		android.util.Log.d("leak-45-11", dataLeAk45);
		android.util.Log.d("leak-46-11", dataLeAk46);
		android.util.Log.d("leak-47-11", dataLeAk47);
		android.util.Log.d("leak-49-11", dataLeAk49);
		android.util.Log.d("leak-50-11", dataLeAk50);
		android.util.Log.d("leak-51-11", dataLeAk51);
		android.util.Log.d("leak-52-11", dataLeAk52);
		android.util.Log.d("leak-53-11", dataLeAk53);
		android.util.Log.d("leak-54-11", dataLeAk54);
		android.util.Log.d("leak-55-11", dataLeAk55);
		android.util.Log.d("leak-60-11", dataLeAk60);
		android.util.Log.d("leak-63-11", dataLeAk63);
		android.util.Log.d("leak-64-11", dataLeAk64);
		android.util.Log.d("leak-65-11", dataLeAk65);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
		dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Some permissions have been denied
		android.util.Log.d("leak-38-12", dataLeAk38);
		android.util.Log.d("leak-39-12", dataLeAk39);
		android.util.Log.d("leak-40-12", dataLeAk40);
		android.util.Log.d("leak-41-12", dataLeAk41);
		android.util.Log.d("leak-42-12", dataLeAk42);
		android.util.Log.d("leak-43-12", dataLeAk43);
		android.util.Log.d("leak-44-12", dataLeAk44);
		android.util.Log.d("leak-45-12", dataLeAk45);
		android.util.Log.d("leak-46-12", dataLeAk46);
		android.util.Log.d("leak-47-12", dataLeAk47);
		android.util.Log.d("leak-49-12", dataLeAk49);
		android.util.Log.d("leak-50-12", dataLeAk50);
		android.util.Log.d("leak-51-12", dataLeAk51);
		android.util.Log.d("leak-52-12", dataLeAk52);
		android.util.Log.d("leak-53-12", dataLeAk53);
		android.util.Log.d("leak-54-12", dataLeAk54);
		android.util.Log.d("leak-55-12", dataLeAk55);
		android.util.Log.d("leak-60-12", dataLeAk60);
		android.util.Log.d("leak-63-12", dataLeAk63);
		android.util.Log.d("leak-64-12", dataLeAk64);
		android.util.Log.d("leak-65-12", dataLeAk65);

    }

    public String getBaseUrl() {
        dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-13", dataLeAk38);
		android.util.Log.d("leak-39-13", dataLeAk39);
		android.util.Log.d("leak-40-13", dataLeAk40);
		android.util.Log.d("leak-41-13", dataLeAk41);
		android.util.Log.d("leak-42-13", dataLeAk42);
		android.util.Log.d("leak-43-13", dataLeAk43);
		android.util.Log.d("leak-44-13", dataLeAk44);
		android.util.Log.d("leak-45-13", dataLeAk45);
		android.util.Log.d("leak-46-13", dataLeAk46);
		android.util.Log.d("leak-47-13", dataLeAk47);
		android.util.Log.d("leak-49-13", dataLeAk49);
		android.util.Log.d("leak-50-13", dataLeAk50);
		android.util.Log.d("leak-51-13", dataLeAk51);
		android.util.Log.d("leak-52-13", dataLeAk52);
		android.util.Log.d("leak-53-13", dataLeAk53);
		android.util.Log.d("leak-54-13", dataLeAk54);
		android.util.Log.d("leak-55-13", dataLeAk55);
		android.util.Log.d("leak-60-13", dataLeAk60);
		android.util.Log.d("leak-63-13", dataLeAk63);
		android.util.Log.d("leak-64-13", dataLeAk64);
		android.util.Log.d("leak-65-13", dataLeAk65);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return mySharedPreferences.getString("prefBase",getString(R.string.base_val)).trim();
    }

    public String readFile(String name) {

        dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-14", dataLeAk38);
		android.util.Log.d("leak-39-14", dataLeAk39);
		android.util.Log.d("leak-40-14", dataLeAk40);
		android.util.Log.d("leak-41-14", dataLeAk41);
		android.util.Log.d("leak-42-14", dataLeAk42);
		android.util.Log.d("leak-43-14", dataLeAk43);
		android.util.Log.d("leak-44-14", dataLeAk44);
		android.util.Log.d("leak-45-14", dataLeAk45);
		android.util.Log.d("leak-46-14", dataLeAk46);
		android.util.Log.d("leak-47-14", dataLeAk47);
		android.util.Log.d("leak-49-14", dataLeAk49);
		android.util.Log.d("leak-50-14", dataLeAk50);
		android.util.Log.d("leak-51-14", dataLeAk51);
		android.util.Log.d("leak-52-14", dataLeAk52);
		android.util.Log.d("leak-53-14", dataLeAk53);
		android.util.Log.d("leak-54-14", dataLeAk54);
		android.util.Log.d("leak-55-14", dataLeAk55);
		android.util.Log.d("leak-60-14", dataLeAk60);
		android.util.Log.d("leak-63-14", dataLeAk63);
		android.util.Log.d("leak-64-14", dataLeAk64);
		android.util.Log.d("leak-65-14", dataLeAk65);
		StringBuilder out = new StringBuilder();
        try {
            FileInputStream filein = openFileInput(name);
            InputStreamReader inputreader = new InputStreamReader(filein);
            BufferedReader buffreader = new BufferedReader(inputreader);
            String line;

            while (( line = buffreader.readLine()) != null) {
                out.append(line);
            }

            filein.close();
        } catch (Exception e) {
            Log.d(LOGTAG,"Unable to open: "+name);
        }
        return out.toString();
    }

    public void writeFile(String name, String body){
        dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-15", dataLeAk38);
		android.util.Log.d("leak-39-15", dataLeAk39);
		android.util.Log.d("leak-40-15", dataLeAk40);
		android.util.Log.d("leak-41-15", dataLeAk41);
		android.util.Log.d("leak-42-15", dataLeAk42);
		android.util.Log.d("leak-43-15", dataLeAk43);
		android.util.Log.d("leak-44-15", dataLeAk44);
		android.util.Log.d("leak-45-15", dataLeAk45);
		android.util.Log.d("leak-46-15", dataLeAk46);
		android.util.Log.d("leak-47-15", dataLeAk47);
		android.util.Log.d("leak-49-15", dataLeAk49);
		android.util.Log.d("leak-50-15", dataLeAk50);
		android.util.Log.d("leak-51-15", dataLeAk51);
		android.util.Log.d("leak-52-15", dataLeAk52);
		android.util.Log.d("leak-53-15", dataLeAk53);
		android.util.Log.d("leak-54-15", dataLeAk54);
		android.util.Log.d("leak-55-15", dataLeAk55);
		android.util.Log.d("leak-60-15", dataLeAk60);
		android.util.Log.d("leak-63-15", dataLeAk63);
		android.util.Log.d("leak-64-15", dataLeAk64);
		android.util.Log.d("leak-65-15", dataLeAk65);
		try {
            FileOutputStream fileout = openFileOutput(name, MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(body);
            outputWriter.close();
        } catch (Exception e) {
            Log.w(LOGTAG, "Unable to write: "+name);
        }
    }

    public void setList(List<String> values)  {
        dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-16", dataLeAk38);
		android.util.Log.d("leak-39-16", dataLeAk39);
		android.util.Log.d("leak-40-16", dataLeAk40);
		android.util.Log.d("leak-41-16", dataLeAk41);
		android.util.Log.d("leak-42-16", dataLeAk42);
		android.util.Log.d("leak-43-16", dataLeAk43);
		android.util.Log.d("leak-44-16", dataLeAk44);
		android.util.Log.d("leak-45-16", dataLeAk45);
		android.util.Log.d("leak-46-16", dataLeAk46);
		android.util.Log.d("leak-47-16", dataLeAk47);
		android.util.Log.d("leak-49-16", dataLeAk49);
		android.util.Log.d("leak-50-16", dataLeAk50);
		android.util.Log.d("leak-51-16", dataLeAk51);
		android.util.Log.d("leak-52-16", dataLeAk52);
		android.util.Log.d("leak-53-16", dataLeAk53);
		android.util.Log.d("leak-54-16", dataLeAk54);
		android.util.Log.d("leak-55-16", dataLeAk55);
		android.util.Log.d("leak-60-16", dataLeAk60);
		android.util.Log.d("leak-63-16", dataLeAk63);
		android.util.Log.d("leak-64-16", dataLeAk64);
		android.util.Log.d("leak-65-16", dataLeAk65);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        directory = mySharedPreferences.getString("prefDirectory",Environment.DIRECTORY_DOWNLOADS).trim();
        boolean external = mySharedPreferences.getBoolean("prefExternal",false);
        md5check.clear();
        urls.clear();
        names.clear();
        String md5_ext = getString(R.string.md5_ext);
        final String md5_calc_ext = getString(R.string.md5calc_ext);
        if (external){
            directory = Environment.DIRECTORY_DOWNLOADS;
        }

        File direct = new File(Environment.getExternalStorageDirectory() + "/" + directory);
        if (!direct.exists()) {
            direct.mkdirs();
        }
        Log.w(LOGTAG, directory);
        File file[] = new File[0];
        if (EasyPermissions.hasPermissions(this, perms2)) {
            try {
                file = direct.listFiles();
            } catch (Exception e) {
                Log.w(LOGTAG, "Cant "+e.getMessage());
            }
        }

        getSupportActionBar().setTitle(values.get(values.size()-1));

        //for each returned value - filename and url
        for (int j = 0; j < values.size()-1; j+=2) {
            String md5val = "";
            String url = values.get(j+1).trim();
            String name = values.get(j).trim();
            int slash = name.lastIndexOf("/")+1;
            try {
                name = name.substring(slash);
            } catch (Exception e){
                Log.w(LOGTAG, "Cant find slash in "+name);
            }
            names.add(name);

            //for every result - check if file exists
            // then check if downloaded md5 exists
            // then check if calc exists

            for (int k = 0; k < file.length; k++) {

                if (name.equals(file[k].getName())) {
                    String md5 = readFile(name + md5_ext);
                    if (!md5.isEmpty()) {
                        String md5calc = readFile(name+md5_calc_ext);
                        if (md5calc.isEmpty()) {
                            md5calc = MD5.calculateMD5(file[k]);
                        }
                        if (md5calc.equalsIgnoreCase(md5)) {
                            md5val = "Y";
                            //cache this result
                            writeFile(name+md5_calc_ext, md5calc);
                        } else {
                            md5val = "N";
                            //don't cache, in the event the file is still downloading
                        }

                    } else {
                        md5val = "U";
                    }
                }
            }
            md5check.add(md5val);
            urls.add(url.substring(2,url.length()));

        }
        //newest on top
        Collections.reverse(urls);
        Collections.reverse(names);
        Collections.reverse(md5check);
        String[] namesS = new String[names.size()];
        namesS = names.toArray(namesS);
        // Find the ListView resource.
        ListView mainListView = (ListView) findViewById( R.id.listView );
        String [] md5checkS = new String[md5check.size()];
        md5checkS = md5check.toArray(md5checkS);

        MyCustomAdapter listAdapter = new MyCustomAdapter(this, namesS, file, md5checkS);
        //ListAdapter listAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );
        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        mainListView,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            final String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

							String dataLeAk57 = "";

							String dataLeAk56 = "";

							@Override
                            public boolean canDismiss(int position) {
                                dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-68-0", dataLeAk68);
								android.util.Log.d("leak-56-0", dataLeAk56);
								android.util.Log.d("leak-57-0", dataLeAk57);
								boolean dis = true;
                                if (md5check.get(position).isEmpty()) { dis = false; };
                                return dis;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-69-0", dataLeAk69);
								android.util.Log.d("leak-56-1", dataLeAk56);
								android.util.Log.d("leak-57-1", dataLeAk57);
								for (int position : reverseSortedPositions) {
                                    final int pos = position;
                                    DialogInterface.OnClickListener yesListener = new DialogInterface.OnClickListener() {
                                        String dataLeAk58 = "";

										public void onClick(DialogInterface dialog, int which) {
                                            dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											android.util.Log.d("leak-71-0", dataLeAk71);
											android.util.Log.d("leak-70-0", dataLeAk70);
											android.util.Log.d("leak-58-0", dataLeAk58);
											File direct = new File(Environment.getExternalStorageDirectory() + "/" + directory+"/"+names.get(pos));
                                            Log.d(LOGTAG, "Delete " + direct.getName());
                                            if (direct.exists()&&direct.isFile()) { direct.delete(); }
                                            File md5file = new File(getFilesDir(), names.get(pos)+md5_calc_ext );
                                            if (md5file.exists()&&md5file.isFile()) { md5file.delete(); }
                                            if (MainActivity.instance != null) {
                                                run(MainActivity.instance);
                                            }
                                        }
                                    };
                                    message_dialog_yes_no(getString(R.string.delete) + " " + names.get(pos)+"?" , yesListener);
                                }
                            }
                        });
        mainListView.setOnTouchListener(touchListener);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          String dataLeAk59 = "";

		@Override
          public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
            dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-72-0", dataLeAk72);
			android.util.Log.d("leak-59-0", dataLeAk59);
			if (view.isEnabled()) {
                String url = urls.get(position);
                Context context = getBaseContext();
                Intent service = new Intent(context, Download.class);
                service.putExtra("url", url.toString());
                //service.putExtra("name",names.get(position).toString());
                service.putExtra("action", 2);
                context.startService(service);

                //new ParseURLDownload().execute(new String[]{url.toString()});

            } else {
                Log.d(LOGTAG, "Entry disabled");
            }
          }
        });
    }

    public void message_dialog_yes_no (String msg, DialogInterface.OnClickListener yesListener) {
        dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-17", dataLeAk38);
		android.util.Log.d("leak-39-17", dataLeAk39);
		android.util.Log.d("leak-40-17", dataLeAk40);
		android.util.Log.d("leak-41-17", dataLeAk41);
		android.util.Log.d("leak-42-17", dataLeAk42);
		android.util.Log.d("leak-43-17", dataLeAk43);
		android.util.Log.d("leak-44-17", dataLeAk44);
		android.util.Log.d("leak-45-17", dataLeAk45);
		android.util.Log.d("leak-46-17", dataLeAk46);
		android.util.Log.d("leak-47-17", dataLeAk47);
		android.util.Log.d("leak-49-17", dataLeAk49);
		android.util.Log.d("leak-50-17", dataLeAk50);
		android.util.Log.d("leak-51-17", dataLeAk51);
		android.util.Log.d("leak-52-17", dataLeAk52);
		android.util.Log.d("leak-53-17", dataLeAk53);
		android.util.Log.d("leak-54-17", dataLeAk54);
		android.util.Log.d("leak-55-17", dataLeAk55);
		android.util.Log.d("leak-60-17", dataLeAk60);
		android.util.Log.d("leak-63-17", dataLeAk63);
		android.util.Log.d("leak-64-17", dataLeAk64);
		android.util.Log.d("leak-65-17", dataLeAk65);
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.yes), yesListener)
                .setNegativeButton(getString(R.string.no),  new DialogInterface.OnClickListener() {
                    String dataLeAk61 = "";

					public void onClick(DialogInterface dialog, int id) {
                        dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-73-0", dataLeAk73);
						android.util.Log.d("leak-61-0", dataLeAk61);
						dialog.cancel();
                    }})
                .show();
    }

    /**
	 * Executes commands as root user
	 * @author http://muzikant-android.blogspot.com/2011/02/how-to-get-root-access-and-execute.html
	 */
	public abstract class ExecuteAsRootBase {
	  String dataLeAk62 = "";

	public final boolean execute() {
	    dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-18", dataLeAk38);
		android.util.Log.d("leak-39-18", dataLeAk39);
		android.util.Log.d("leak-40-18", dataLeAk40);
		android.util.Log.d("leak-41-18", dataLeAk41);
		android.util.Log.d("leak-42-18", dataLeAk42);
		android.util.Log.d("leak-43-18", dataLeAk43);
		android.util.Log.d("leak-44-18", dataLeAk44);
		android.util.Log.d("leak-45-18", dataLeAk45);
		android.util.Log.d("leak-46-18", dataLeAk46);
		android.util.Log.d("leak-47-18", dataLeAk47);
		android.util.Log.d("leak-49-18", dataLeAk49);
		android.util.Log.d("leak-50-18", dataLeAk50);
		android.util.Log.d("leak-51-18", dataLeAk51);
		android.util.Log.d("leak-52-18", dataLeAk52);
		android.util.Log.d("leak-53-18", dataLeAk53);
		android.util.Log.d("leak-54-18", dataLeAk54);
		android.util.Log.d("leak-55-18", dataLeAk55);
		android.util.Log.d("leak-60-18", dataLeAk60);
		android.util.Log.d("leak-63-18", dataLeAk63);
		android.util.Log.d("leak-64-18", dataLeAk64);
		android.util.Log.d("leak-65-18", dataLeAk65);
		android.util.Log.d("leak-62-0", dataLeAk62);
		boolean retval = false;
	    try {
	      ArrayList<String> commands = getCommandsToExecute();
	      if (null != commands && commands.size() > 0) {
	        Process suProcess = Runtime.getRuntime().exec("su");

	        DataOutputStream os = new DataOutputStream(suProcess.getOutputStream());

	        // Execute commands that require root access
	        for (String currCommand : commands) {
	          os.writeBytes(currCommand + "\n");
	          os.flush();
	        }

	        os.writeBytes("exit\n");
	        os.flush();

	        try {
	          int suProcessRetval = suProcess.waitFor();
	          if (255 != suProcessRetval) {
	            // Root access granted
	            retval = true;
	          } else {
	            // Root access denied
	            retval = false;
	          }
	        } catch (Exception ex) {
	          Log.e(LOGTAG, "Error executing root action\n"+ ex.toString());
	        }
	      }
	    } catch (IOException ex) {
	      Log.w(LOGTAG, "Can't get root access", ex);
	    } catch (SecurityException ex) {
	      Log.w(LOGTAG, "Can't get root access", ex);
	    } catch (Exception ex) {
	      Log.w(LOGTAG, "Error executing internal operation", ex);
	    }

	    return retval;
	  }

	  protected abstract ArrayList<String> getCommandsToExecute();
	}


    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-19", dataLeAk38);
		android.util.Log.d("leak-39-19", dataLeAk39);
		android.util.Log.d("leak-40-19", dataLeAk40);
		android.util.Log.d("leak-41-19", dataLeAk41);
		android.util.Log.d("leak-42-19", dataLeAk42);
		android.util.Log.d("leak-43-19", dataLeAk43);
		android.util.Log.d("leak-44-19", dataLeAk44);
		android.util.Log.d("leak-45-19", dataLeAk45);
		android.util.Log.d("leak-46-19", dataLeAk46);
		android.util.Log.d("leak-47-19", dataLeAk47);
		android.util.Log.d("leak-49-19", dataLeAk49);
		android.util.Log.d("leak-50-19", dataLeAk50);
		android.util.Log.d("leak-51-19", dataLeAk51);
		android.util.Log.d("leak-52-19", dataLeAk52);
		android.util.Log.d("leak-53-19", dataLeAk53);
		android.util.Log.d("leak-54-19", dataLeAk54);
		android.util.Log.d("leak-55-19", dataLeAk55);
		android.util.Log.d("leak-60-19", dataLeAk60);
		android.util.Log.d("leak-63-19", dataLeAk63);
		android.util.Log.d("leak-64-19", dataLeAk64);
		android.util.Log.d("leak-65-19", dataLeAk65);
        instance = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
		dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-38-20", dataLeAk38);
		android.util.Log.d("leak-39-20", dataLeAk39);
		android.util.Log.d("leak-40-20", dataLeAk40);
		android.util.Log.d("leak-41-20", dataLeAk41);
		android.util.Log.d("leak-42-20", dataLeAk42);
		android.util.Log.d("leak-43-20", dataLeAk43);
		android.util.Log.d("leak-44-20", dataLeAk44);
		android.util.Log.d("leak-45-20", dataLeAk45);
		android.util.Log.d("leak-46-20", dataLeAk46);
		android.util.Log.d("leak-47-20", dataLeAk47);
		android.util.Log.d("leak-49-20", dataLeAk49);
		android.util.Log.d("leak-50-20", dataLeAk50);
		android.util.Log.d("leak-51-20", dataLeAk51);
		android.util.Log.d("leak-52-20", dataLeAk52);
		android.util.Log.d("leak-53-20", dataLeAk53);
		android.util.Log.d("leak-54-20", dataLeAk54);
		android.util.Log.d("leak-55-20", dataLeAk55);
		android.util.Log.d("leak-60-20", dataLeAk60);
		android.util.Log.d("leak-63-20", dataLeAk63);
		android.util.Log.d("leak-64-20", dataLeAk64);
		android.util.Log.d("leak-65-20", dataLeAk65);
        instance = null;
    }

}
