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
		String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
		String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
		android.util.Log.d("leak-72", dataLeAkPath72);
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
            String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP73.put("test", new java.util.HashMap<String, String>());
			leakMaP73.get("test").put("test", dataLeAk73);
			String dataLeAkPath73 = leakMaP73.get("test").get("test");
			android.util.Log.d("leak-73", dataLeAkPath73);
			// Ask for both permissio  ns
            EasyPermissions.requestPermissions(this, getString(R.string.extWritePerm), RC_EXT_WRITE, perms);
            //otherwise use app
        }

        if (!(EasyPermissions.hasPermissions(this, perms2))) {
            String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
			android.util.Log.d("leak-74", dataLeAkPath74);
			// Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.extReadPerm), RC_EXT_READ, perms2);
            //otherwise use app
        }

        setAlarm(this);
        run(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
		android.util.Log.d("leak-75", dataLeAkPath75);
		setAlarm(this);
        run(this);
    }

    public void setAlarm(Context context){
        String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
		String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
		android.util.Log.d("leak-76", dataLeAkPath76);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean daily = mySharedPreferences.getBoolean("prefDailyDownload",false);
        if (daily) {
            String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP77.put("test", new java.util.HashMap<String, String>());
			leakMaP77.get("test").put("test", dataLeAk77);
			String dataLeAkPath77 = leakMaP77.get("test").get("test");
			android.util.Log.d("leak-77", dataLeAkPath77);
			Log.d(LOGTAG, "Setting daily alarm");
            setRecurringAlarm(context);
        } else {
            String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
			android.util.Log.d("leak-78", dataLeAkPath78);
			CancelAlarm(context);
        }
    }

    public SharedPreferences getPref() {
        String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
		android.util.Log.d("leak-79", dataLeAkPath79);
		return PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void setRecurringAlarm(Context context) {
        String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
		String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
		android.util.Log.d("leak-80", dataLeAkPath80);
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
        String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP81.put("test", new java.util.HashMap<String, String>());
		leakMaP81.get("test").put("test", dataLeAk81);
		String dataLeAkPath81 = leakMaP81.get("test").get("test");
		android.util.Log.d("leak-81", dataLeAkPath81);
		Intent downloader = new Intent(context, AlarmReceiver.class);
        PendingIntent recurringDownload = PendingIntent.getBroadcast(context,
                0, downloader, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarms = (AlarmManager) getSystemService(
                Context.ALARM_SERVICE);
        alarms.cancel(recurringDownload);
    }

    public void run(Context context) {
        String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
		android.util.Log.d("leak-82", dataLeAkPath82);
		//new ParseURL().execute(new String[]{buildPath(context)});
        Intent service = new Intent(context, Download.class);
        service.putExtra("url",buildPath(context));
        service.putExtra("action",1);
        context.startService(service);
    }

    //get for a specific int
    public String buildPath(Context context) {
        String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
		android.util.Log.d("leak-83", dataLeAkPath83);
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
        String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
		String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
		android.util.Log.d("leak-84", dataLeAkPath84);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP85.put("test", new java.util.HashMap<String, String>());
		leakMaP85.get("test").put("test", dataLeAk85);
		String dataLeAkPath85 = leakMaP85.get("test").get("test");
		android.util.Log.d("leak-85", dataLeAkPath85);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
			android.util.Log.d("leak-86", dataLeAkPath86);
			Intent prefs = new Intent(getBaseContext(), SetPreferenceActivity.class);
            startActivityForResult(prefs, REQUEST_PREFS);
            run(this);
            setAlarm(this);
            return true;
        }
	if (id == R.id.action_refresh) {
		String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
		android.util.Log.d("leak-87", dataLeAkPath87);
		run(this);
	}
        if (id == R.id.action_reboot) {
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
			String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
			android.util.Log.d("leak-88", dataLeAkPath88);
			ExecuteAsRootBase e = new ExecuteAsRootBase() {
                    @Override
                    protected ArrayList<String> getCommandsToExecute() {
                        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP89.put("test", new java.util.HashMap<String, String>());
						leakMaP89.get("test").put("test", dataLeAk89);
						String dataLeAkPath89 = leakMaP89.get("test").get("test");
						android.util.Log.d("leak-89", dataLeAkPath89);
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
		String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
		android.util.Log.d("leak-90", dataLeAkPath90);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
		String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
		android.util.Log.d("leak-91", dataLeAkPath91);
        // Some permissions have been granted
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
		String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
		String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
		android.util.Log.d("leak-92", dataLeAkPath92);
        // Some permissions have been denied

    }

    public String getBaseUrl() {
        String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP93.put("test", new java.util.HashMap<String, String>());
		leakMaP93.get("test").put("test", dataLeAk93);
		String dataLeAkPath93 = leakMaP93.get("test").get("test");
		android.util.Log.d("leak-93", dataLeAkPath93);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return mySharedPreferences.getString("prefBase",getString(R.string.base_val)).trim();
    }

    public String readFile(String name) {

        String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
		android.util.Log.d("leak-94", dataLeAkPath94);
		StringBuilder out = new StringBuilder();
        try {
            String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
			android.util.Log.d("leak-95", dataLeAkPath95);
			FileInputStream filein = openFileInput(name);
            InputStreamReader inputreader = new InputStreamReader(filein);
            BufferedReader buffreader = new BufferedReader(inputreader);
            String line;

            while (( line = buffreader.readLine()) != null) {
                String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
				String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
				android.util.Log.d("leak-96", dataLeAkPath96);
				out.append(line);
            }

            filein.close();
        } catch (Exception e) {
            String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP97.put("test", new java.util.HashMap<String, String>());
			leakMaP97.get("test").put("test", dataLeAk97);
			String dataLeAkPath97 = leakMaP97.get("test").get("test");
			android.util.Log.d("leak-97", dataLeAkPath97);
			Log.d(LOGTAG,"Unable to open: "+name);
        }
        return out.toString();
    }

    public void writeFile(String name, String body){
        String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
		android.util.Log.d("leak-98", dataLeAkPath98);
		try {
            String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
			android.util.Log.d("leak-99", dataLeAkPath99);
			FileOutputStream fileout = openFileOutput(name, MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(body);
            outputWriter.close();
        } catch (Exception e) {
            String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
			String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
			android.util.Log.d("leak-100", dataLeAkPath100);
			Log.w(LOGTAG, "Unable to write: "+name);
        }
    }

    public void setList(List<String> values)  {
        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP101.put("test", new java.util.HashMap<String, String>());
		leakMaP101.get("test").put("test", dataLeAk101);
		String dataLeAkPath101 = leakMaP101.get("test").get("test");
		android.util.Log.d("leak-101", dataLeAkPath101);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        directory = mySharedPreferences.getString("prefDirectory",Environment.DIRECTORY_DOWNLOADS).trim();
        boolean external = mySharedPreferences.getBoolean("prefExternal",false);
        md5check.clear();
        urls.clear();
        names.clear();
        String md5_ext = getString(R.string.md5_ext);
        final String md5_calc_ext = getString(R.string.md5calc_ext);
        if (external){
            String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
			android.util.Log.d("leak-102", dataLeAkPath102);
			directory = Environment.DIRECTORY_DOWNLOADS;
        }

        File direct = new File(Environment.getExternalStorageDirectory() + "/" + directory);
        if (!direct.exists()) {
            String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
			android.util.Log.d("leak-103", dataLeAkPath103);
			direct.mkdirs();
        }
        Log.w(LOGTAG, directory);
        File file[] = new File[0];
        if (EasyPermissions.hasPermissions(this, perms2)) {
            String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
			String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
			android.util.Log.d("leak-104", dataLeAkPath104);
			try {
                String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP105.put("test", new java.util.HashMap<String, String>());
				leakMaP105.get("test").put("test", dataLeAk105);
				String dataLeAkPath105 = leakMaP105.get("test").get("test");
				android.util.Log.d("leak-105", dataLeAkPath105);
				file = direct.listFiles();
            } catch (Exception e) {
                String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
				android.util.Log.d("leak-106", dataLeAkPath106);
				Log.w(LOGTAG, "Cant "+e.getMessage());
            }
        }

        getSupportActionBar().setTitle(values.get(values.size()-1));

        //for each returned value - filename and url
        for (int j = 0; j < values.size()-1; j+=2) {
            String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
			android.util.Log.d("leak-107", dataLeAkPath107);
			String md5val = "";
            String url = values.get(j+1).trim();
            String name = values.get(j).trim();
            int slash = name.lastIndexOf("/")+1;
            try {
                String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
				String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
				android.util.Log.d("leak-108", dataLeAkPath108);
				name = name.substring(slash);
            } catch (Exception e){
                String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP109.put("test", new java.util.HashMap<String, String>());
				leakMaP109.get("test").put("test", dataLeAk109);
				String dataLeAkPath109 = leakMaP109.get("test").get("test");
				android.util.Log.d("leak-109", dataLeAkPath109);
				Log.w(LOGTAG, "Cant find slash in "+name);
            }
            names.add(name);

            //for every result - check if file exists
            // then check if downloaded md5 exists
            // then check if calc exists

            for (int k = 0; k < file.length; k++) {

                String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
				android.util.Log.d("leak-110", dataLeAkPath110);
				if (name.equals(file[k].getName())) {
                    String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
					android.util.Log.d("leak-111", dataLeAkPath111);
					String md5 = readFile(name + md5_ext);
                    if (!md5.isEmpty()) {
                        String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
						String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
						android.util.Log.d("leak-112", dataLeAkPath112);
						String md5calc = readFile(name+md5_calc_ext);
                        if (md5calc.isEmpty()) {
                            String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP113.put("test", new java.util.HashMap<String, String>());
							leakMaP113.get("test").put("test", dataLeAk113);
							String dataLeAkPath113 = leakMaP113.get("test").get("test");
							android.util.Log.d("leak-113", dataLeAkPath113);
							md5calc = MD5.calculateMD5(file[k]);
                        }
                        if (md5calc.equalsIgnoreCase(md5)) {
                            String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
							android.util.Log.d("leak-114", dataLeAkPath114);
							md5val = "Y";
                            //cache this result
                            writeFile(name+md5_calc_ext, md5calc);
                        } else {
                            String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
							android.util.Log.d("leak-115", dataLeAkPath115);
							md5val = "N";
                            //don't cache, in the event the file is still downloading
                        }

                    } else {
                        String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
						String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
						android.util.Log.d("leak-116", dataLeAkPath116);
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
                            @Override
                            public boolean canDismiss(int position) {
                                String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP117.put("test", new java.util.HashMap<String, String>());
								leakMaP117.get("test").put("test", dataLeAk117);
								String dataLeAkPath117 = leakMaP117.get("test").get("test");
								android.util.Log.d("leak-117", dataLeAkPath117);
								boolean dis = true;
                                if (md5check.get(position).isEmpty()) { String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
									android.util.Log.d("leak-118", dataLeAkPath118);
								dis = false; };
                                return dis;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
								android.util.Log.d("leak-119", dataLeAkPath119);
								for (int position : reverseSortedPositions) {
                                    String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
									String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
									android.util.Log.d("leak-120", dataLeAkPath120);
									final int pos = position;
                                    DialogInterface.OnClickListener yesListener = new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP121.put("test", new java.util.HashMap<String, String>());
											leakMaP121.get("test").put("test", dataLeAk121);
											String dataLeAkPath121 = leakMaP121.get("test").get("test");
											android.util.Log.d("leak-121", dataLeAkPath121);
											File direct = new File(Environment.getExternalStorageDirectory() + "/" + directory+"/"+names.get(pos));
                                            Log.d(LOGTAG, "Delete " + direct.getName());
                                            if (direct.exists()&&direct.isFile()) { String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
												android.util.Log.d("leak-122", dataLeAkPath122);
											direct.delete(); }
                                            File md5file = new File(getFilesDir(), names.get(pos)+md5_calc_ext );
                                            if (md5file.exists()&&md5file.isFile()) { String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
												android.util.Log.d("leak-123", dataLeAkPath123);
											md5file.delete(); }
                                            if (MainActivity.instance != null) {
                                                String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
												String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
												android.util.Log.d("leak-124", dataLeAkPath124);
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
          @Override
          public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
            String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP125.put("test", new java.util.HashMap<String, String>());
			leakMaP125.get("test").put("test", dataLeAk125);
			String dataLeAkPath125 = leakMaP125.get("test").get("test");
			android.util.Log.d("leak-125", dataLeAkPath125);
			if (view.isEnabled()) {
                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
				android.util.Log.d("leak-126", dataLeAkPath126);
				String url = urls.get(position);
                Context context = getBaseContext();
                Intent service = new Intent(context, Download.class);
                service.putExtra("url", url.toString());
                //service.putExtra("name",names.get(position).toString());
                service.putExtra("action", 2);
                context.startService(service);

                //new ParseURLDownload().execute(new String[]{url.toString()});

            } else {
                String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
				android.util.Log.d("leak-127", dataLeAkPath127);
				Log.d(LOGTAG, "Entry disabled");
            }
          }
        });
    }

    public void message_dialog_yes_no (String msg, DialogInterface.OnClickListener yesListener) {
        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
		String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
		android.util.Log.d("leak-128", dataLeAkPath128);
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.yes), yesListener)
                .setNegativeButton(getString(R.string.no),  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP129.put("test", new java.util.HashMap<String, String>());
						leakMaP129.get("test").put("test", dataLeAk129);
						String dataLeAkPath129 = leakMaP129.get("test").get("test");
						android.util.Log.d("leak-129", dataLeAkPath129);
						dialog.cancel();
                    }})
                .show();
    }

    /**
	 * Executes commands as root user
	 * @author http://muzikant-android.blogspot.com/2011/02/how-to-get-root-access-and-execute.html
	 */
	public abstract class ExecuteAsRootBase {
	  public final boolean execute() {
	    String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
		android.util.Log.d("leak-130", dataLeAkPath130);
		boolean retval = false;
	    try {
	      String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
			android.util.Log.d("leak-131", dataLeAkPath131);
		ArrayList<String> commands = getCommandsToExecute();
	      if (null != commands && commands.size() > 0) {
	        String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
			String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
			android.util.Log.d("leak-132", dataLeAkPath132);
			Process suProcess = Runtime.getRuntime().exec("su");

	        DataOutputStream os = new DataOutputStream(suProcess.getOutputStream());

	        // Execute commands that require root access
	        for (String currCommand : commands) {
	          String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP133.put("test", new java.util.HashMap<String, String>());
				leakMaP133.get("test").put("test", dataLeAk133);
				String dataLeAkPath133 = leakMaP133.get("test").get("test");
				android.util.Log.d("leak-133", dataLeAkPath133);
			os.writeBytes(currCommand + "\n");
	          os.flush();
	        }

	        os.writeBytes("exit\n");
	        os.flush();

	        try {
	          String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
				android.util.Log.d("leak-134", dataLeAkPath134);
			int suProcessRetval = suProcess.waitFor();
	          if (255 != suProcessRetval) {
	            String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
				android.util.Log.d("leak-135", dataLeAkPath135);
				// Root access granted
	            retval = true;
	          } else {
	            String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
				String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
				android.util.Log.d("leak-136", dataLeAkPath136);
				// Root access denied
	            retval = false;
	          }
	        } catch (Exception ex) {
	          String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP137.put("test", new java.util.HashMap<String, String>());
				leakMaP137.get("test").put("test", dataLeAk137);
				String dataLeAkPath137 = leakMaP137.get("test").get("test");
				android.util.Log.d("leak-137", dataLeAkPath137);
			Log.e(LOGTAG, "Error executing root action\n"+ ex.toString());
	        }
	      }
	    } catch (IOException ex) {
	      String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
			android.util.Log.d("leak-138", dataLeAkPath138);
		Log.w(LOGTAG, "Can't get root access", ex);
	    } catch (SecurityException ex) {
	      String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
			android.util.Log.d("leak-139", dataLeAkPath139);
		Log.w(LOGTAG, "Can't get root access", ex);
	    } catch (Exception ex) {
	      String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
			String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
			android.util.Log.d("leak-140", dataLeAkPath140);
		Log.w(LOGTAG, "Error executing internal operation", ex);
	    }

	    return retval;
	  }

	  protected abstract ArrayList<String> getCommandsToExecute();
	}


    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP141.put("test", new java.util.HashMap<String, String>());
		leakMaP141.get("test").put("test", dataLeAk141);
		String dataLeAkPath141 = leakMaP141.get("test").get("test");
		android.util.Log.d("leak-141", dataLeAkPath141);
        instance = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
		android.util.Log.d("leak-142", dataLeAkPath142);
        instance = null;
    }

}
