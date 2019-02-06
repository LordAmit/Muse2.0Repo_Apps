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
    String dataLeAk59 = "59";

	String dataLeAk58 = "58";

	String dataLeAk57 = "57";

	String dataLeAk55 = "55";

	String dataLeAk53 = "53";

	String dataLeAk51 = "51";

	String dataLeAk50 = "50";

	String dataLeAk48 = "48";

	String dataLeAk45 = "45";

	String dataLeAk43 = "43";

	String dataLeAk41 = "41";

	String dataLeAk40 = "40";

	String dataLeAk39 = "39";

	String dataLeAk38 = "38";

	String dataLeAk37 = "37";

	String dataLeAk36 = "36";

	String dataLeAk35 = "35";

	String dataLeAk34 = "34";

	String dataLeAk32 = "32";

	String dataLeAk31 = "31";

	String dataLeAk30 = "30";

	String dataLeAk29 = "29";

	String dataLeAk28 = "28";

	String dataLeAk27 = "27";

	String dataLeAk26 = "26";

	String dataLeAk25 = "25";

	String dataLeAk24 = "24";

	String dataLeAk23 = "23";

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
		android.util.Log.d("leak-23-25", dataLeAk23);
		android.util.Log.d("leak-24-25", dataLeAk24);
		android.util.Log.d("leak-25-25", dataLeAk25);
		android.util.Log.d("leak-26-25", dataLeAk26);
		android.util.Log.d("leak-27-25", dataLeAk27);
		android.util.Log.d("leak-28-25", dataLeAk28);
		android.util.Log.d("leak-29-25", dataLeAk29);
		android.util.Log.d("leak-30-25", dataLeAk30);
		android.util.Log.d("leak-31-25", dataLeAk31);
		android.util.Log.d("leak-32-25", dataLeAk32);
		android.util.Log.d("leak-34-25", dataLeAk34);
		android.util.Log.d("leak-35-25", dataLeAk35);
		android.util.Log.d("leak-36-25", dataLeAk36);
		android.util.Log.d("leak-37-25", dataLeAk37);
		android.util.Log.d("leak-38-25", dataLeAk38);
		android.util.Log.d("leak-39-25", dataLeAk39);
		android.util.Log.d("leak-40-25", dataLeAk40);
		android.util.Log.d("leak-41-25", dataLeAk41);
		android.util.Log.d("leak-43-25", dataLeAk43);
		android.util.Log.d("leak-45-25", dataLeAk45);
		android.util.Log.d("leak-48-25", dataLeAk48);
		android.util.Log.d("leak-50-25", dataLeAk50);
		android.util.Log.d("leak-51-25", dataLeAk51);
		android.util.Log.d("leak-53-25", dataLeAk53);
		android.util.Log.d("leak-55-25", dataLeAk55);
		android.util.Log.d("leak-57-25", dataLeAk57);
		android.util.Log.d("leak-58-25", dataLeAk58);
		android.util.Log.d("leak-59-25", dataLeAk59);
		dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-26", dataLeAk23);
		android.util.Log.d("leak-24-26", dataLeAk24);
		android.util.Log.d("leak-25-26", dataLeAk25);
		android.util.Log.d("leak-26-26", dataLeAk26);
		android.util.Log.d("leak-27-26", dataLeAk27);
		android.util.Log.d("leak-28-26", dataLeAk28);
		android.util.Log.d("leak-29-26", dataLeAk29);
		android.util.Log.d("leak-30-26", dataLeAk30);
		android.util.Log.d("leak-31-26", dataLeAk31);
		android.util.Log.d("leak-32-26", dataLeAk32);
		android.util.Log.d("leak-34-26", dataLeAk34);
		android.util.Log.d("leak-35-26", dataLeAk35);
		android.util.Log.d("leak-36-26", dataLeAk36);
		android.util.Log.d("leak-37-26", dataLeAk37);
		android.util.Log.d("leak-38-26", dataLeAk38);
		android.util.Log.d("leak-39-26", dataLeAk39);
		android.util.Log.d("leak-40-26", dataLeAk40);
		android.util.Log.d("leak-41-26", dataLeAk41);
		android.util.Log.d("leak-43-26", dataLeAk43);
		android.util.Log.d("leak-45-26", dataLeAk45);
		android.util.Log.d("leak-48-26", dataLeAk48);
		android.util.Log.d("leak-50-26", dataLeAk50);
		android.util.Log.d("leak-51-26", dataLeAk51);
		android.util.Log.d("leak-53-26", dataLeAk53);
		android.util.Log.d("leak-55-26", dataLeAk55);
		android.util.Log.d("leak-57-26", dataLeAk57);
		android.util.Log.d("leak-58-26", dataLeAk58);
		android.util.Log.d("leak-59-26", dataLeAk59);
		setAlarm(this);
        run(this);
    }

    public void setAlarm(Context context){
        dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-27", dataLeAk23);
		android.util.Log.d("leak-24-27", dataLeAk24);
		android.util.Log.d("leak-25-27", dataLeAk25);
		android.util.Log.d("leak-26-27", dataLeAk26);
		android.util.Log.d("leak-27-27", dataLeAk27);
		android.util.Log.d("leak-28-27", dataLeAk28);
		android.util.Log.d("leak-29-27", dataLeAk29);
		android.util.Log.d("leak-30-27", dataLeAk30);
		android.util.Log.d("leak-31-27", dataLeAk31);
		android.util.Log.d("leak-32-27", dataLeAk32);
		android.util.Log.d("leak-34-27", dataLeAk34);
		android.util.Log.d("leak-35-27", dataLeAk35);
		android.util.Log.d("leak-36-27", dataLeAk36);
		android.util.Log.d("leak-37-27", dataLeAk37);
		android.util.Log.d("leak-38-27", dataLeAk38);
		android.util.Log.d("leak-39-27", dataLeAk39);
		android.util.Log.d("leak-40-27", dataLeAk40);
		android.util.Log.d("leak-41-27", dataLeAk41);
		android.util.Log.d("leak-43-27", dataLeAk43);
		android.util.Log.d("leak-45-27", dataLeAk45);
		android.util.Log.d("leak-48-27", dataLeAk48);
		android.util.Log.d("leak-50-27", dataLeAk50);
		android.util.Log.d("leak-51-27", dataLeAk51);
		android.util.Log.d("leak-53-27", dataLeAk53);
		android.util.Log.d("leak-55-27", dataLeAk55);
		android.util.Log.d("leak-57-27", dataLeAk57);
		android.util.Log.d("leak-58-27", dataLeAk58);
		android.util.Log.d("leak-59-27", dataLeAk59);
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
        dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-28", dataLeAk23);
		android.util.Log.d("leak-24-28", dataLeAk24);
		android.util.Log.d("leak-25-28", dataLeAk25);
		android.util.Log.d("leak-26-28", dataLeAk26);
		android.util.Log.d("leak-27-28", dataLeAk27);
		android.util.Log.d("leak-28-28", dataLeAk28);
		android.util.Log.d("leak-29-28", dataLeAk29);
		android.util.Log.d("leak-30-28", dataLeAk30);
		android.util.Log.d("leak-31-28", dataLeAk31);
		android.util.Log.d("leak-32-28", dataLeAk32);
		android.util.Log.d("leak-34-28", dataLeAk34);
		android.util.Log.d("leak-35-28", dataLeAk35);
		android.util.Log.d("leak-36-28", dataLeAk36);
		android.util.Log.d("leak-37-28", dataLeAk37);
		android.util.Log.d("leak-38-28", dataLeAk38);
		android.util.Log.d("leak-39-28", dataLeAk39);
		android.util.Log.d("leak-40-28", dataLeAk40);
		android.util.Log.d("leak-41-28", dataLeAk41);
		android.util.Log.d("leak-43-28", dataLeAk43);
		android.util.Log.d("leak-45-28", dataLeAk45);
		android.util.Log.d("leak-48-28", dataLeAk48);
		android.util.Log.d("leak-50-28", dataLeAk50);
		android.util.Log.d("leak-51-28", dataLeAk51);
		android.util.Log.d("leak-53-28", dataLeAk53);
		android.util.Log.d("leak-55-28", dataLeAk55);
		android.util.Log.d("leak-57-28", dataLeAk57);
		android.util.Log.d("leak-58-28", dataLeAk58);
		android.util.Log.d("leak-59-28", dataLeAk59);
		return PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void setRecurringAlarm(Context context) {
        dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-29", dataLeAk23);
		android.util.Log.d("leak-24-29", dataLeAk24);
		android.util.Log.d("leak-25-29", dataLeAk25);
		android.util.Log.d("leak-26-29", dataLeAk26);
		android.util.Log.d("leak-27-29", dataLeAk27);
		android.util.Log.d("leak-28-29", dataLeAk28);
		android.util.Log.d("leak-29-29", dataLeAk29);
		android.util.Log.d("leak-30-29", dataLeAk30);
		android.util.Log.d("leak-31-29", dataLeAk31);
		android.util.Log.d("leak-32-29", dataLeAk32);
		android.util.Log.d("leak-34-29", dataLeAk34);
		android.util.Log.d("leak-35-29", dataLeAk35);
		android.util.Log.d("leak-36-29", dataLeAk36);
		android.util.Log.d("leak-37-29", dataLeAk37);
		android.util.Log.d("leak-38-29", dataLeAk38);
		android.util.Log.d("leak-39-29", dataLeAk39);
		android.util.Log.d("leak-40-29", dataLeAk40);
		android.util.Log.d("leak-41-29", dataLeAk41);
		android.util.Log.d("leak-43-29", dataLeAk43);
		android.util.Log.d("leak-45-29", dataLeAk45);
		android.util.Log.d("leak-48-29", dataLeAk48);
		android.util.Log.d("leak-50-29", dataLeAk50);
		android.util.Log.d("leak-51-29", dataLeAk51);
		android.util.Log.d("leak-53-29", dataLeAk53);
		android.util.Log.d("leak-55-29", dataLeAk55);
		android.util.Log.d("leak-57-29", dataLeAk57);
		android.util.Log.d("leak-58-29", dataLeAk58);
		android.util.Log.d("leak-59-29", dataLeAk59);
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
        dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-30", dataLeAk23);
		android.util.Log.d("leak-24-30", dataLeAk24);
		android.util.Log.d("leak-25-30", dataLeAk25);
		android.util.Log.d("leak-26-30", dataLeAk26);
		android.util.Log.d("leak-27-30", dataLeAk27);
		android.util.Log.d("leak-28-30", dataLeAk28);
		android.util.Log.d("leak-29-30", dataLeAk29);
		android.util.Log.d("leak-30-30", dataLeAk30);
		android.util.Log.d("leak-31-30", dataLeAk31);
		android.util.Log.d("leak-32-30", dataLeAk32);
		android.util.Log.d("leak-34-30", dataLeAk34);
		android.util.Log.d("leak-35-30", dataLeAk35);
		android.util.Log.d("leak-36-30", dataLeAk36);
		android.util.Log.d("leak-37-30", dataLeAk37);
		android.util.Log.d("leak-38-30", dataLeAk38);
		android.util.Log.d("leak-39-30", dataLeAk39);
		android.util.Log.d("leak-40-30", dataLeAk40);
		android.util.Log.d("leak-41-30", dataLeAk41);
		android.util.Log.d("leak-43-30", dataLeAk43);
		android.util.Log.d("leak-45-30", dataLeAk45);
		android.util.Log.d("leak-48-30", dataLeAk48);
		android.util.Log.d("leak-50-30", dataLeAk50);
		android.util.Log.d("leak-51-30", dataLeAk51);
		android.util.Log.d("leak-53-30", dataLeAk53);
		android.util.Log.d("leak-55-30", dataLeAk55);
		android.util.Log.d("leak-57-30", dataLeAk57);
		android.util.Log.d("leak-58-30", dataLeAk58);
		android.util.Log.d("leak-59-30", dataLeAk59);
		Intent downloader = new Intent(context, AlarmReceiver.class);
        PendingIntent recurringDownload = PendingIntent.getBroadcast(context,
                0, downloader, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarms = (AlarmManager) getSystemService(
                Context.ALARM_SERVICE);
        alarms.cancel(recurringDownload);
    }

    public void run(Context context) {
        dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-31", dataLeAk23);
		android.util.Log.d("leak-24-31", dataLeAk24);
		android.util.Log.d("leak-25-31", dataLeAk25);
		android.util.Log.d("leak-26-31", dataLeAk26);
		android.util.Log.d("leak-27-31", dataLeAk27);
		android.util.Log.d("leak-28-31", dataLeAk28);
		android.util.Log.d("leak-29-31", dataLeAk29);
		android.util.Log.d("leak-30-31", dataLeAk30);
		android.util.Log.d("leak-31-31", dataLeAk31);
		android.util.Log.d("leak-32-31", dataLeAk32);
		android.util.Log.d("leak-34-31", dataLeAk34);
		android.util.Log.d("leak-35-31", dataLeAk35);
		android.util.Log.d("leak-36-31", dataLeAk36);
		android.util.Log.d("leak-37-31", dataLeAk37);
		android.util.Log.d("leak-38-31", dataLeAk38);
		android.util.Log.d("leak-39-31", dataLeAk39);
		android.util.Log.d("leak-40-31", dataLeAk40);
		android.util.Log.d("leak-41-31", dataLeAk41);
		android.util.Log.d("leak-43-31", dataLeAk43);
		android.util.Log.d("leak-45-31", dataLeAk45);
		android.util.Log.d("leak-48-31", dataLeAk48);
		android.util.Log.d("leak-50-31", dataLeAk50);
		android.util.Log.d("leak-51-31", dataLeAk51);
		android.util.Log.d("leak-53-31", dataLeAk53);
		android.util.Log.d("leak-55-31", dataLeAk55);
		android.util.Log.d("leak-57-31", dataLeAk57);
		android.util.Log.d("leak-58-31", dataLeAk58);
		android.util.Log.d("leak-59-31", dataLeAk59);
		//new ParseURL().execute(new String[]{buildPath(context)});
        Intent service = new Intent(context, Download.class);
        service.putExtra("url",buildPath(context));
        service.putExtra("action",1);
        context.startService(service);
    }

    //get for a specific int
    public String buildPath(Context context) {
        dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-32", dataLeAk23);
		android.util.Log.d("leak-24-32", dataLeAk24);
		android.util.Log.d("leak-25-32", dataLeAk25);
		android.util.Log.d("leak-26-32", dataLeAk26);
		android.util.Log.d("leak-27-32", dataLeAk27);
		android.util.Log.d("leak-28-32", dataLeAk28);
		android.util.Log.d("leak-29-32", dataLeAk29);
		android.util.Log.d("leak-30-32", dataLeAk30);
		android.util.Log.d("leak-31-32", dataLeAk31);
		android.util.Log.d("leak-32-32", dataLeAk32);
		android.util.Log.d("leak-34-32", dataLeAk34);
		android.util.Log.d("leak-35-32", dataLeAk35);
		android.util.Log.d("leak-36-32", dataLeAk36);
		android.util.Log.d("leak-37-32", dataLeAk37);
		android.util.Log.d("leak-38-32", dataLeAk38);
		android.util.Log.d("leak-39-32", dataLeAk39);
		android.util.Log.d("leak-40-32", dataLeAk40);
		android.util.Log.d("leak-41-32", dataLeAk41);
		android.util.Log.d("leak-43-32", dataLeAk43);
		android.util.Log.d("leak-45-32", dataLeAk45);
		android.util.Log.d("leak-48-32", dataLeAk48);
		android.util.Log.d("leak-50-32", dataLeAk50);
		android.util.Log.d("leak-51-32", dataLeAk51);
		android.util.Log.d("leak-53-32", dataLeAk53);
		android.util.Log.d("leak-55-32", dataLeAk55);
		android.util.Log.d("leak-57-32", dataLeAk57);
		android.util.Log.d("leak-58-32", dataLeAk58);
		android.util.Log.d("leak-59-32", dataLeAk59);
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
        dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-33", dataLeAk23);
		android.util.Log.d("leak-24-33", dataLeAk24);
		android.util.Log.d("leak-25-33", dataLeAk25);
		android.util.Log.d("leak-26-33", dataLeAk26);
		android.util.Log.d("leak-27-33", dataLeAk27);
		android.util.Log.d("leak-28-33", dataLeAk28);
		android.util.Log.d("leak-29-33", dataLeAk29);
		android.util.Log.d("leak-30-33", dataLeAk30);
		android.util.Log.d("leak-31-33", dataLeAk31);
		android.util.Log.d("leak-32-33", dataLeAk32);
		android.util.Log.d("leak-34-33", dataLeAk34);
		android.util.Log.d("leak-35-33", dataLeAk35);
		android.util.Log.d("leak-36-33", dataLeAk36);
		android.util.Log.d("leak-37-33", dataLeAk37);
		android.util.Log.d("leak-38-33", dataLeAk38);
		android.util.Log.d("leak-39-33", dataLeAk39);
		android.util.Log.d("leak-40-33", dataLeAk40);
		android.util.Log.d("leak-41-33", dataLeAk41);
		android.util.Log.d("leak-43-33", dataLeAk43);
		android.util.Log.d("leak-45-33", dataLeAk45);
		android.util.Log.d("leak-48-33", dataLeAk48);
		android.util.Log.d("leak-50-33", dataLeAk50);
		android.util.Log.d("leak-51-33", dataLeAk51);
		android.util.Log.d("leak-53-33", dataLeAk53);
		android.util.Log.d("leak-55-33", dataLeAk55);
		android.util.Log.d("leak-57-33", dataLeAk57);
		android.util.Log.d("leak-58-33", dataLeAk58);
		android.util.Log.d("leak-59-33", dataLeAk59);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-34", dataLeAk23);
		android.util.Log.d("leak-24-34", dataLeAk24);
		android.util.Log.d("leak-25-34", dataLeAk25);
		android.util.Log.d("leak-26-34", dataLeAk26);
		android.util.Log.d("leak-27-34", dataLeAk27);
		android.util.Log.d("leak-28-34", dataLeAk28);
		android.util.Log.d("leak-29-34", dataLeAk29);
		android.util.Log.d("leak-30-34", dataLeAk30);
		android.util.Log.d("leak-31-34", dataLeAk31);
		android.util.Log.d("leak-32-34", dataLeAk32);
		android.util.Log.d("leak-34-34", dataLeAk34);
		android.util.Log.d("leak-35-34", dataLeAk35);
		android.util.Log.d("leak-36-34", dataLeAk36);
		android.util.Log.d("leak-37-34", dataLeAk37);
		android.util.Log.d("leak-38-34", dataLeAk38);
		android.util.Log.d("leak-39-34", dataLeAk39);
		android.util.Log.d("leak-40-34", dataLeAk40);
		android.util.Log.d("leak-41-34", dataLeAk41);
		android.util.Log.d("leak-43-34", dataLeAk43);
		android.util.Log.d("leak-45-34", dataLeAk45);
		android.util.Log.d("leak-48-34", dataLeAk48);
		android.util.Log.d("leak-50-34", dataLeAk50);
		android.util.Log.d("leak-51-34", dataLeAk51);
		android.util.Log.d("leak-53-34", dataLeAk53);
		android.util.Log.d("leak-55-34", dataLeAk55);
		android.util.Log.d("leak-57-34", dataLeAk57);
		android.util.Log.d("leak-58-34", dataLeAk58);
		android.util.Log.d("leak-59-34", dataLeAk59);
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
                    String dataLeAk33 = "33";

					@Override
                    protected ArrayList<String> getCommandsToExecute() {
                        dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		android.util.Log.d("leak-23-35", dataLeAk23);
		android.util.Log.d("leak-24-35", dataLeAk24);
		android.util.Log.d("leak-25-35", dataLeAk25);
		android.util.Log.d("leak-26-35", dataLeAk26);
		android.util.Log.d("leak-27-35", dataLeAk27);
		android.util.Log.d("leak-28-35", dataLeAk28);
		android.util.Log.d("leak-29-35", dataLeAk29);
		android.util.Log.d("leak-30-35", dataLeAk30);
		android.util.Log.d("leak-31-35", dataLeAk31);
		android.util.Log.d("leak-32-35", dataLeAk32);
		android.util.Log.d("leak-34-35", dataLeAk34);
		android.util.Log.d("leak-35-35", dataLeAk35);
		android.util.Log.d("leak-36-35", dataLeAk36);
		android.util.Log.d("leak-37-35", dataLeAk37);
		android.util.Log.d("leak-38-35", dataLeAk38);
		android.util.Log.d("leak-39-35", dataLeAk39);
		android.util.Log.d("leak-40-35", dataLeAk40);
		android.util.Log.d("leak-41-35", dataLeAk41);
		android.util.Log.d("leak-43-35", dataLeAk43);
		android.util.Log.d("leak-45-35", dataLeAk45);
		android.util.Log.d("leak-48-35", dataLeAk48);
		android.util.Log.d("leak-50-35", dataLeAk50);
		android.util.Log.d("leak-51-35", dataLeAk51);
		android.util.Log.d("leak-53-35", dataLeAk53);
		android.util.Log.d("leak-55-35", dataLeAk55);
		android.util.Log.d("leak-57-35", dataLeAk57);
		android.util.Log.d("leak-58-35", dataLeAk58);
		android.util.Log.d("leak-59-35", dataLeAk59);
		dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
		dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Some permissions have been granted
		android.util.Log.d("leak-23-36", dataLeAk23);
		android.util.Log.d("leak-24-36", dataLeAk24);
		android.util.Log.d("leak-25-36", dataLeAk25);
		android.util.Log.d("leak-26-36", dataLeAk26);
		android.util.Log.d("leak-27-36", dataLeAk27);
		android.util.Log.d("leak-28-36", dataLeAk28);
		android.util.Log.d("leak-29-36", dataLeAk29);
		android.util.Log.d("leak-30-36", dataLeAk30);
		android.util.Log.d("leak-31-36", dataLeAk31);
		android.util.Log.d("leak-32-36", dataLeAk32);
		android.util.Log.d("leak-34-36", dataLeAk34);
		android.util.Log.d("leak-35-36", dataLeAk35);
		android.util.Log.d("leak-36-36", dataLeAk36);
		android.util.Log.d("leak-37-36", dataLeAk37);
		android.util.Log.d("leak-38-36", dataLeAk38);
		android.util.Log.d("leak-39-36", dataLeAk39);
		android.util.Log.d("leak-40-36", dataLeAk40);
		android.util.Log.d("leak-41-36", dataLeAk41);
		android.util.Log.d("leak-43-36", dataLeAk43);
		android.util.Log.d("leak-45-36", dataLeAk45);
		android.util.Log.d("leak-48-36", dataLeAk48);
		android.util.Log.d("leak-50-36", dataLeAk50);
		android.util.Log.d("leak-51-36", dataLeAk51);
		android.util.Log.d("leak-53-36", dataLeAk53);
		android.util.Log.d("leak-55-36", dataLeAk55);
		android.util.Log.d("leak-57-36", dataLeAk57);
		android.util.Log.d("leak-58-36", dataLeAk58);
		android.util.Log.d("leak-59-36", dataLeAk59);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
		dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Some permissions have been denied
		android.util.Log.d("leak-23-37", dataLeAk23);
		android.util.Log.d("leak-24-37", dataLeAk24);
		android.util.Log.d("leak-25-37", dataLeAk25);
		android.util.Log.d("leak-26-37", dataLeAk26);
		android.util.Log.d("leak-27-37", dataLeAk27);
		android.util.Log.d("leak-28-37", dataLeAk28);
		android.util.Log.d("leak-29-37", dataLeAk29);
		android.util.Log.d("leak-30-37", dataLeAk30);
		android.util.Log.d("leak-31-37", dataLeAk31);
		android.util.Log.d("leak-32-37", dataLeAk32);
		android.util.Log.d("leak-34-37", dataLeAk34);
		android.util.Log.d("leak-35-37", dataLeAk35);
		android.util.Log.d("leak-36-37", dataLeAk36);
		android.util.Log.d("leak-37-37", dataLeAk37);
		android.util.Log.d("leak-38-37", dataLeAk38);
		android.util.Log.d("leak-39-37", dataLeAk39);
		android.util.Log.d("leak-40-37", dataLeAk40);
		android.util.Log.d("leak-41-37", dataLeAk41);
		android.util.Log.d("leak-43-37", dataLeAk43);
		android.util.Log.d("leak-45-37", dataLeAk45);
		android.util.Log.d("leak-48-37", dataLeAk48);
		android.util.Log.d("leak-50-37", dataLeAk50);
		android.util.Log.d("leak-51-37", dataLeAk51);
		android.util.Log.d("leak-53-37", dataLeAk53);
		android.util.Log.d("leak-55-37", dataLeAk55);
		android.util.Log.d("leak-57-37", dataLeAk57);
		android.util.Log.d("leak-58-37", dataLeAk58);
		android.util.Log.d("leak-59-37", dataLeAk59);

    }

    public String getBaseUrl() {
        dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-38", dataLeAk23);
		android.util.Log.d("leak-24-38", dataLeAk24);
		android.util.Log.d("leak-25-38", dataLeAk25);
		android.util.Log.d("leak-26-38", dataLeAk26);
		android.util.Log.d("leak-27-38", dataLeAk27);
		android.util.Log.d("leak-28-38", dataLeAk28);
		android.util.Log.d("leak-29-38", dataLeAk29);
		android.util.Log.d("leak-30-38", dataLeAk30);
		android.util.Log.d("leak-31-38", dataLeAk31);
		android.util.Log.d("leak-32-38", dataLeAk32);
		android.util.Log.d("leak-34-38", dataLeAk34);
		android.util.Log.d("leak-35-38", dataLeAk35);
		android.util.Log.d("leak-36-38", dataLeAk36);
		android.util.Log.d("leak-37-38", dataLeAk37);
		android.util.Log.d("leak-38-38", dataLeAk38);
		android.util.Log.d("leak-39-38", dataLeAk39);
		android.util.Log.d("leak-40-38", dataLeAk40);
		android.util.Log.d("leak-41-38", dataLeAk41);
		android.util.Log.d("leak-43-38", dataLeAk43);
		android.util.Log.d("leak-45-38", dataLeAk45);
		android.util.Log.d("leak-48-38", dataLeAk48);
		android.util.Log.d("leak-50-38", dataLeAk50);
		android.util.Log.d("leak-51-38", dataLeAk51);
		android.util.Log.d("leak-53-38", dataLeAk53);
		android.util.Log.d("leak-55-38", dataLeAk55);
		android.util.Log.d("leak-57-38", dataLeAk57);
		android.util.Log.d("leak-58-38", dataLeAk58);
		android.util.Log.d("leak-59-38", dataLeAk59);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return mySharedPreferences.getString("prefBase",getString(R.string.base_val)).trim();
    }

    public String readFile(String name) {

        dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-39", dataLeAk23);
		android.util.Log.d("leak-24-39", dataLeAk24);
		android.util.Log.d("leak-25-39", dataLeAk25);
		android.util.Log.d("leak-26-39", dataLeAk26);
		android.util.Log.d("leak-27-39", dataLeAk27);
		android.util.Log.d("leak-28-39", dataLeAk28);
		android.util.Log.d("leak-29-39", dataLeAk29);
		android.util.Log.d("leak-30-39", dataLeAk30);
		android.util.Log.d("leak-31-39", dataLeAk31);
		android.util.Log.d("leak-32-39", dataLeAk32);
		android.util.Log.d("leak-34-39", dataLeAk34);
		android.util.Log.d("leak-35-39", dataLeAk35);
		android.util.Log.d("leak-36-39", dataLeAk36);
		android.util.Log.d("leak-37-39", dataLeAk37);
		android.util.Log.d("leak-38-39", dataLeAk38);
		android.util.Log.d("leak-39-39", dataLeAk39);
		android.util.Log.d("leak-40-39", dataLeAk40);
		android.util.Log.d("leak-41-39", dataLeAk41);
		android.util.Log.d("leak-43-39", dataLeAk43);
		android.util.Log.d("leak-45-39", dataLeAk45);
		android.util.Log.d("leak-48-39", dataLeAk48);
		android.util.Log.d("leak-50-39", dataLeAk50);
		android.util.Log.d("leak-51-39", dataLeAk51);
		android.util.Log.d("leak-53-39", dataLeAk53);
		android.util.Log.d("leak-55-39", dataLeAk55);
		android.util.Log.d("leak-57-39", dataLeAk57);
		android.util.Log.d("leak-58-39", dataLeAk58);
		android.util.Log.d("leak-59-39", dataLeAk59);
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
        dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-40", dataLeAk23);
		android.util.Log.d("leak-24-40", dataLeAk24);
		android.util.Log.d("leak-25-40", dataLeAk25);
		android.util.Log.d("leak-26-40", dataLeAk26);
		android.util.Log.d("leak-27-40", dataLeAk27);
		android.util.Log.d("leak-28-40", dataLeAk28);
		android.util.Log.d("leak-29-40", dataLeAk29);
		android.util.Log.d("leak-30-40", dataLeAk30);
		android.util.Log.d("leak-31-40", dataLeAk31);
		android.util.Log.d("leak-32-40", dataLeAk32);
		android.util.Log.d("leak-34-40", dataLeAk34);
		android.util.Log.d("leak-35-40", dataLeAk35);
		android.util.Log.d("leak-36-40", dataLeAk36);
		android.util.Log.d("leak-37-40", dataLeAk37);
		android.util.Log.d("leak-38-40", dataLeAk38);
		android.util.Log.d("leak-39-40", dataLeAk39);
		android.util.Log.d("leak-40-40", dataLeAk40);
		android.util.Log.d("leak-41-40", dataLeAk41);
		android.util.Log.d("leak-43-40", dataLeAk43);
		android.util.Log.d("leak-45-40", dataLeAk45);
		android.util.Log.d("leak-48-40", dataLeAk48);
		android.util.Log.d("leak-50-40", dataLeAk50);
		android.util.Log.d("leak-51-40", dataLeAk51);
		android.util.Log.d("leak-53-40", dataLeAk53);
		android.util.Log.d("leak-55-40", dataLeAk55);
		android.util.Log.d("leak-57-40", dataLeAk57);
		android.util.Log.d("leak-58-40", dataLeAk58);
		android.util.Log.d("leak-59-40", dataLeAk59);
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
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-41", dataLeAk23);
		android.util.Log.d("leak-24-41", dataLeAk24);
		android.util.Log.d("leak-25-41", dataLeAk25);
		android.util.Log.d("leak-26-41", dataLeAk26);
		android.util.Log.d("leak-27-41", dataLeAk27);
		android.util.Log.d("leak-28-41", dataLeAk28);
		android.util.Log.d("leak-29-41", dataLeAk29);
		android.util.Log.d("leak-30-41", dataLeAk30);
		android.util.Log.d("leak-31-41", dataLeAk31);
		android.util.Log.d("leak-32-41", dataLeAk32);
		android.util.Log.d("leak-34-41", dataLeAk34);
		android.util.Log.d("leak-35-41", dataLeAk35);
		android.util.Log.d("leak-36-41", dataLeAk36);
		android.util.Log.d("leak-37-41", dataLeAk37);
		android.util.Log.d("leak-38-41", dataLeAk38);
		android.util.Log.d("leak-39-41", dataLeAk39);
		android.util.Log.d("leak-40-41", dataLeAk40);
		android.util.Log.d("leak-41-41", dataLeAk41);
		android.util.Log.d("leak-43-41", dataLeAk43);
		android.util.Log.d("leak-45-41", dataLeAk45);
		android.util.Log.d("leak-48-41", dataLeAk48);
		android.util.Log.d("leak-50-41", dataLeAk50);
		android.util.Log.d("leak-51-41", dataLeAk51);
		android.util.Log.d("leak-53-41", dataLeAk53);
		android.util.Log.d("leak-55-41", dataLeAk55);
		android.util.Log.d("leak-57-41", dataLeAk57);
		android.util.Log.d("leak-58-41", dataLeAk58);
		android.util.Log.d("leak-59-41", dataLeAk59);
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
                            String dataLeAk47 = "47";

							String dataLeAk44 = "44";

							String dataLeAk42 = "42";

							@Override
                            public boolean canDismiss(int position) {
                                dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								boolean dis = true;
                                if (md5check.get(position).isEmpty()) { dis = false; };
                                return dis;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								for (int position : reverseSortedPositions) {
                                    final int pos = position;
                                    DialogInterface.OnClickListener yesListener = new DialogInterface.OnClickListener() {
                                        String dataLeAk46 = "46";

										public void onClick(DialogInterface dialog, int which) {
                                            dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
          String dataLeAk49 = "49";

		@Override
          public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
            dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-42", dataLeAk23);
		android.util.Log.d("leak-24-42", dataLeAk24);
		android.util.Log.d("leak-25-42", dataLeAk25);
		android.util.Log.d("leak-26-42", dataLeAk26);
		android.util.Log.d("leak-27-42", dataLeAk27);
		android.util.Log.d("leak-28-42", dataLeAk28);
		android.util.Log.d("leak-29-42", dataLeAk29);
		android.util.Log.d("leak-30-42", dataLeAk30);
		android.util.Log.d("leak-31-42", dataLeAk31);
		android.util.Log.d("leak-32-42", dataLeAk32);
		android.util.Log.d("leak-34-42", dataLeAk34);
		android.util.Log.d("leak-35-42", dataLeAk35);
		android.util.Log.d("leak-36-42", dataLeAk36);
		android.util.Log.d("leak-37-42", dataLeAk37);
		android.util.Log.d("leak-38-42", dataLeAk38);
		android.util.Log.d("leak-39-42", dataLeAk39);
		android.util.Log.d("leak-40-42", dataLeAk40);
		android.util.Log.d("leak-41-42", dataLeAk41);
		android.util.Log.d("leak-43-42", dataLeAk43);
		android.util.Log.d("leak-45-42", dataLeAk45);
		android.util.Log.d("leak-48-42", dataLeAk48);
		android.util.Log.d("leak-50-42", dataLeAk50);
		android.util.Log.d("leak-51-42", dataLeAk51);
		android.util.Log.d("leak-53-42", dataLeAk53);
		android.util.Log.d("leak-55-42", dataLeAk55);
		android.util.Log.d("leak-57-42", dataLeAk57);
		android.util.Log.d("leak-58-42", dataLeAk58);
		android.util.Log.d("leak-59-42", dataLeAk59);
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.yes), yesListener)
                .setNegativeButton(getString(R.string.no),  new DialogInterface.OnClickListener() {
                    String dataLeAk52 = "52";

					public void onClick(DialogInterface dialog, int id) {
                        dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dialog.cancel();
                    }})
                .show();
    }

    /**
	 * Executes commands as root user
	 * @author http://muzikant-android.blogspot.com/2011/02/how-to-get-root-access-and-execute.html
	 */
	public abstract class ExecuteAsRootBase {
	  String dataLeAk56 = "56";

		String dataLeAk54 = "54";

	public final boolean execute() {
	    dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-54-43", dataLeAk54);
		android.util.Log.d("leak-56-43", dataLeAk56);

		android.util.Log.d("leak-23-43", dataLeAk23);
		android.util.Log.d("leak-24-43", dataLeAk24);
		android.util.Log.d("leak-25-43", dataLeAk25);
		android.util.Log.d("leak-26-43", dataLeAk26);
		android.util.Log.d("leak-27-43", dataLeAk27);
		android.util.Log.d("leak-28-43", dataLeAk28);
		android.util.Log.d("leak-29-43", dataLeAk29);
		android.util.Log.d("leak-30-43", dataLeAk30);
		android.util.Log.d("leak-31-43", dataLeAk31);
		android.util.Log.d("leak-32-43", dataLeAk32);
		android.util.Log.d("leak-34-43", dataLeAk34);
		android.util.Log.d("leak-35-43", dataLeAk35);
		android.util.Log.d("leak-36-43", dataLeAk36);
		android.util.Log.d("leak-37-43", dataLeAk37);
		android.util.Log.d("leak-38-43", dataLeAk38);
		android.util.Log.d("leak-39-43", dataLeAk39);
		android.util.Log.d("leak-40-43", dataLeAk40);
		android.util.Log.d("leak-41-43", dataLeAk41);
		android.util.Log.d("leak-43-43", dataLeAk43);
		android.util.Log.d("leak-45-43", dataLeAk45);
		android.util.Log.d("leak-48-43", dataLeAk48);
		android.util.Log.d("leak-50-43", dataLeAk50);
		android.util.Log.d("leak-51-43", dataLeAk51);
		android.util.Log.d("leak-53-43", dataLeAk53);
		android.util.Log.d("leak-55-43", dataLeAk55);
		android.util.Log.d("leak-57-43", dataLeAk57);
		android.util.Log.d("leak-58-43", dataLeAk58);
		android.util.Log.d("leak-59-43", dataLeAk59);

		android.util.Log.d("leak-23-43", dataLeAk23);
		android.util.Log.d("leak-24-43", dataLeAk24);
		android.util.Log.d("leak-25-43", dataLeAk25);
		android.util.Log.d("leak-26-43", dataLeAk26);
		android.util.Log.d("leak-27-43", dataLeAk27);
		android.util.Log.d("leak-28-43", dataLeAk28);
		android.util.Log.d("leak-29-43", dataLeAk29);
		android.util.Log.d("leak-30-43", dataLeAk30);
		android.util.Log.d("leak-31-43", dataLeAk31);
		android.util.Log.d("leak-32-43", dataLeAk32);
		android.util.Log.d("leak-34-43", dataLeAk34);
		android.util.Log.d("leak-35-43", dataLeAk35);
		android.util.Log.d("leak-36-43", dataLeAk36);
		android.util.Log.d("leak-37-43", dataLeAk37);
		android.util.Log.d("leak-38-43", dataLeAk38);
		android.util.Log.d("leak-39-43", dataLeAk39);
		android.util.Log.d("leak-40-43", dataLeAk40);
		android.util.Log.d("leak-41-43", dataLeAk41);
		android.util.Log.d("leak-43-43", dataLeAk43);
		android.util.Log.d("leak-45-43", dataLeAk45);
		android.util.Log.d("leak-48-43", dataLeAk48);
		android.util.Log.d("leak-50-43", dataLeAk50);
		android.util.Log.d("leak-51-43", dataLeAk51);
		android.util.Log.d("leak-53-43", dataLeAk53);
		android.util.Log.d("leak-55-43", dataLeAk55);
		android.util.Log.d("leak-57-43", dataLeAk57);
		android.util.Log.d("leak-58-43", dataLeAk58);
		android.util.Log.d("leak-59-43", dataLeAk59);

		android.util.Log.d("leak-23-43", dataLeAk23);
		android.util.Log.d("leak-24-43", dataLeAk24);
		android.util.Log.d("leak-25-43", dataLeAk25);
		android.util.Log.d("leak-26-43", dataLeAk26);
		android.util.Log.d("leak-27-43", dataLeAk27);
		android.util.Log.d("leak-28-43", dataLeAk28);
		android.util.Log.d("leak-29-43", dataLeAk29);
		android.util.Log.d("leak-30-43", dataLeAk30);
		android.util.Log.d("leak-31-43", dataLeAk31);
		android.util.Log.d("leak-32-43", dataLeAk32);
		android.util.Log.d("leak-34-43", dataLeAk34);
		android.util.Log.d("leak-35-43", dataLeAk35);
		android.util.Log.d("leak-36-43", dataLeAk36);
		android.util.Log.d("leak-37-43", dataLeAk37);
		android.util.Log.d("leak-38-43", dataLeAk38);
		android.util.Log.d("leak-39-43", dataLeAk39);
		android.util.Log.d("leak-40-43", dataLeAk40);
		android.util.Log.d("leak-41-43", dataLeAk41);
		android.util.Log.d("leak-43-43", dataLeAk43);
		android.util.Log.d("leak-45-43", dataLeAk45);
		android.util.Log.d("leak-48-43", dataLeAk48);
		android.util.Log.d("leak-50-43", dataLeAk50);
		android.util.Log.d("leak-51-43", dataLeAk51);
		android.util.Log.d("leak-53-43", dataLeAk53);
		android.util.Log.d("leak-55-43", dataLeAk55);
		android.util.Log.d("leak-57-43", dataLeAk57);
		android.util.Log.d("leak-58-43", dataLeAk58);
		android.util.Log.d("leak-59-43", dataLeAk59);

		android.util.Log.d("leak-23-43", dataLeAk23);
		android.util.Log.d("leak-24-43", dataLeAk24);
		android.util.Log.d("leak-25-43", dataLeAk25);
		android.util.Log.d("leak-26-43", dataLeAk26);
		android.util.Log.d("leak-27-43", dataLeAk27);
		android.util.Log.d("leak-28-43", dataLeAk28);
		android.util.Log.d("leak-29-43", dataLeAk29);
		android.util.Log.d("leak-30-43", dataLeAk30);
		android.util.Log.d("leak-31-43", dataLeAk31);
		android.util.Log.d("leak-32-43", dataLeAk32);
		android.util.Log.d("leak-34-43", dataLeAk34);
		android.util.Log.d("leak-35-43", dataLeAk35);
		android.util.Log.d("leak-36-43", dataLeAk36);
		android.util.Log.d("leak-37-43", dataLeAk37);
		android.util.Log.d("leak-38-43", dataLeAk38);
		android.util.Log.d("leak-39-43", dataLeAk39);
		android.util.Log.d("leak-40-43", dataLeAk40);
		android.util.Log.d("leak-41-43", dataLeAk41);
		android.util.Log.d("leak-43-43", dataLeAk43);
		android.util.Log.d("leak-45-43", dataLeAk45);
		android.util.Log.d("leak-48-43", dataLeAk48);
		android.util.Log.d("leak-50-43", dataLeAk50);
		android.util.Log.d("leak-51-43", dataLeAk51);
		android.util.Log.d("leak-53-43", dataLeAk53);
		android.util.Log.d("leak-55-43", dataLeAk55);
		android.util.Log.d("leak-57-43", dataLeAk57);
		android.util.Log.d("leak-58-43", dataLeAk58);
		android.util.Log.d("leak-59-43", dataLeAk59);

		android.util.Log.d("leak-23-43", dataLeAk23);
		android.util.Log.d("leak-24-43", dataLeAk24);
		android.util.Log.d("leak-25-43", dataLeAk25);
		android.util.Log.d("leak-26-43", dataLeAk26);
		android.util.Log.d("leak-27-43", dataLeAk27);
		android.util.Log.d("leak-28-43", dataLeAk28);
		android.util.Log.d("leak-29-43", dataLeAk29);
		android.util.Log.d("leak-30-43", dataLeAk30);
		android.util.Log.d("leak-31-43", dataLeAk31);
		android.util.Log.d("leak-32-43", dataLeAk32);
		android.util.Log.d("leak-34-43", dataLeAk34);
		android.util.Log.d("leak-35-43", dataLeAk35);
		android.util.Log.d("leak-36-43", dataLeAk36);
		android.util.Log.d("leak-37-43", dataLeAk37);
		android.util.Log.d("leak-38-43", dataLeAk38);
		android.util.Log.d("leak-39-43", dataLeAk39);
		android.util.Log.d("leak-40-43", dataLeAk40);
		android.util.Log.d("leak-41-43", dataLeAk41);
		android.util.Log.d("leak-43-43", dataLeAk43);
		android.util.Log.d("leak-45-43", dataLeAk45);
		android.util.Log.d("leak-48-43", dataLeAk48);
		android.util.Log.d("leak-50-43", dataLeAk50);
		android.util.Log.d("leak-51-43", dataLeAk51);
		android.util.Log.d("leak-53-43", dataLeAk53);
		android.util.Log.d("leak-55-43", dataLeAk55);
		android.util.Log.d("leak-57-43", dataLeAk57);
		android.util.Log.d("leak-58-43", dataLeAk58);
		android.util.Log.d("leak-59-43", dataLeAk59);

		android.util.Log.d("leak-23-43", dataLeAk23);
		android.util.Log.d("leak-24-43", dataLeAk24);
		android.util.Log.d("leak-25-43", dataLeAk25);
		android.util.Log.d("leak-26-43", dataLeAk26);
		android.util.Log.d("leak-27-43", dataLeAk27);
		android.util.Log.d("leak-28-43", dataLeAk28);
		android.util.Log.d("leak-29-43", dataLeAk29);
		android.util.Log.d("leak-30-43", dataLeAk30);
		android.util.Log.d("leak-31-43", dataLeAk31);
		android.util.Log.d("leak-32-43", dataLeAk32);
		android.util.Log.d("leak-34-43", dataLeAk34);
		android.util.Log.d("leak-35-43", dataLeAk35);
		android.util.Log.d("leak-36-43", dataLeAk36);
		android.util.Log.d("leak-37-43", dataLeAk37);
		android.util.Log.d("leak-38-43", dataLeAk38);
		android.util.Log.d("leak-39-43", dataLeAk39);
		android.util.Log.d("leak-40-43", dataLeAk40);
		android.util.Log.d("leak-41-43", dataLeAk41);
		android.util.Log.d("leak-43-43", dataLeAk43);
		android.util.Log.d("leak-45-43", dataLeAk45);
		android.util.Log.d("leak-48-43", dataLeAk48);
		android.util.Log.d("leak-50-43", dataLeAk50);
		android.util.Log.d("leak-51-43", dataLeAk51);
		android.util.Log.d("leak-53-43", dataLeAk53);
		android.util.Log.d("leak-55-43", dataLeAk55);
		android.util.Log.d("leak-57-43", dataLeAk57);
		android.util.Log.d("leak-58-43", dataLeAk58);
		android.util.Log.d("leak-59-43", dataLeAk59);

		android.util.Log.d("leak-23-43", dataLeAk23);
		android.util.Log.d("leak-24-43", dataLeAk24);
		android.util.Log.d("leak-25-43", dataLeAk25);
		android.util.Log.d("leak-26-43", dataLeAk26);
		android.util.Log.d("leak-27-43", dataLeAk27);
		android.util.Log.d("leak-28-43", dataLeAk28);
		android.util.Log.d("leak-29-43", dataLeAk29);
		android.util.Log.d("leak-30-43", dataLeAk30);
		android.util.Log.d("leak-31-43", dataLeAk31);
		android.util.Log.d("leak-32-43", dataLeAk32);
		android.util.Log.d("leak-34-43", dataLeAk34);
		android.util.Log.d("leak-35-43", dataLeAk35);
		android.util.Log.d("leak-36-43", dataLeAk36);
		android.util.Log.d("leak-37-43", dataLeAk37);
		android.util.Log.d("leak-38-43", dataLeAk38);
		android.util.Log.d("leak-39-43", dataLeAk39);
		android.util.Log.d("leak-40-43", dataLeAk40);
		android.util.Log.d("leak-41-43", dataLeAk41);
		android.util.Log.d("leak-43-43", dataLeAk43);
		android.util.Log.d("leak-45-43", dataLeAk45);
		android.util.Log.d("leak-48-43", dataLeAk48);
		android.util.Log.d("leak-50-43", dataLeAk50);
		android.util.Log.d("leak-51-43", dataLeAk51);
		android.util.Log.d("leak-53-43", dataLeAk53);
		android.util.Log.d("leak-55-43", dataLeAk55);
		android.util.Log.d("leak-57-43", dataLeAk57);
		android.util.Log.d("leak-58-43", dataLeAk58);
		android.util.Log.d("leak-59-43", dataLeAk59);
		dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		android.util.Log.d("leak-23-45", dataLeAk23);
		android.util.Log.d("leak-24-45", dataLeAk24);
		android.util.Log.d("leak-25-45", dataLeAk25);
		android.util.Log.d("leak-26-45", dataLeAk26);
		android.util.Log.d("leak-27-45", dataLeAk27);
		android.util.Log.d("leak-28-45", dataLeAk28);
		android.util.Log.d("leak-29-45", dataLeAk29);
		android.util.Log.d("leak-30-45", dataLeAk30);
		android.util.Log.d("leak-31-45", dataLeAk31);
		android.util.Log.d("leak-32-45", dataLeAk32);
		android.util.Log.d("leak-34-45", dataLeAk34);
		android.util.Log.d("leak-35-45", dataLeAk35);
		android.util.Log.d("leak-36-45", dataLeAk36);
		android.util.Log.d("leak-37-45", dataLeAk37);
		android.util.Log.d("leak-38-45", dataLeAk38);
		android.util.Log.d("leak-39-45", dataLeAk39);
		android.util.Log.d("leak-40-45", dataLeAk40);
		android.util.Log.d("leak-41-45", dataLeAk41);
		android.util.Log.d("leak-43-45", dataLeAk43);
		android.util.Log.d("leak-45-45", dataLeAk45);
		android.util.Log.d("leak-48-45", dataLeAk48);
		android.util.Log.d("leak-50-45", dataLeAk50);
		android.util.Log.d("leak-51-45", dataLeAk51);
		android.util.Log.d("leak-53-45", dataLeAk53);
		android.util.Log.d("leak-55-45", dataLeAk55);
		android.util.Log.d("leak-57-45", dataLeAk57);
		android.util.Log.d("leak-58-45", dataLeAk58);
		android.util.Log.d("leak-59-45", dataLeAk59);
		dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        instance = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
		android.util.Log.d("leak-23-46", dataLeAk23);
		android.util.Log.d("leak-24-46", dataLeAk24);
		android.util.Log.d("leak-25-46", dataLeAk25);
		android.util.Log.d("leak-26-46", dataLeAk26);
		android.util.Log.d("leak-27-46", dataLeAk27);
		android.util.Log.d("leak-28-46", dataLeAk28);
		android.util.Log.d("leak-29-46", dataLeAk29);
		android.util.Log.d("leak-30-46", dataLeAk30);
		android.util.Log.d("leak-31-46", dataLeAk31);
		android.util.Log.d("leak-32-46", dataLeAk32);
		android.util.Log.d("leak-34-46", dataLeAk34);
		android.util.Log.d("leak-35-46", dataLeAk35);
		android.util.Log.d("leak-36-46", dataLeAk36);
		android.util.Log.d("leak-37-46", dataLeAk37);
		android.util.Log.d("leak-38-46", dataLeAk38);
		android.util.Log.d("leak-39-46", dataLeAk39);
		android.util.Log.d("leak-40-46", dataLeAk40);
		android.util.Log.d("leak-41-46", dataLeAk41);
		android.util.Log.d("leak-43-46", dataLeAk43);
		android.util.Log.d("leak-45-46", dataLeAk45);
		android.util.Log.d("leak-48-46", dataLeAk48);
		android.util.Log.d("leak-50-46", dataLeAk50);
		android.util.Log.d("leak-51-46", dataLeAk51);
		android.util.Log.d("leak-53-46", dataLeAk53);
		android.util.Log.d("leak-55-46", dataLeAk55);
		android.util.Log.d("leak-57-46", dataLeAk57);
		android.util.Log.d("leak-58-46", dataLeAk58);
		android.util.Log.d("leak-59-46", dataLeAk59);
		dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        instance = null;
    }

}
