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
    String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);

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
		String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
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
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
			// Ask for both permissio  ns
            EasyPermissions.requestPermissions(this, getString(R.string.extWritePerm), RC_EXT_WRITE, perms);
            //otherwise use app
        }

        if (!(EasyPermissions.hasPermissions(this, perms2))) {
            String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);
			// Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.extReadPerm), RC_EXT_READ, perms2);
            //otherwise use app
        }

        setAlarm(this);
        run(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
		setAlarm(this);
        run(this);
    }

    public void setAlarm(Context context){
        String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean daily = mySharedPreferences.getBoolean("prefDailyDownload",false);
        if (daily) {
            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);
			Log.d(LOGTAG, "Setting daily alarm");
            setRecurringAlarm(context);
        } else {
            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
			CancelAlarm(context);
        }
    }

    public SharedPreferences getPref() {
        String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
		return PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void setRecurringAlarm(Context context) {
        String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
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
        String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
		Intent downloader = new Intent(context, AlarmReceiver.class);
        PendingIntent recurringDownload = PendingIntent.getBroadcast(context,
                0, downloader, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarms = (AlarmManager) getSystemService(
                Context.ALARM_SERVICE);
        alarms.cancel(recurringDownload);
    }

    public void run(Context context) {
        String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
		//new ParseURL().execute(new String[]{buildPath(context)});
        Intent service = new Intent(context, Download.class);
        service.putExtra("url",buildPath(context));
        service.putExtra("action",1);
        context.startService(service);
    }

    //get for a specific int
    public String buildPath(Context context) {
        String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
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
        String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);
			Intent prefs = new Intent(getBaseContext(), SetPreferenceActivity.class);
            startActivityForResult(prefs, REQUEST_PREFS);
            run(this);
            setAlarm(this);
            return true;
        }
	if (id == R.id.action_refresh) {
		String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
		run(this);
	}
        if (id == R.id.action_reboot) {
            String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
			ExecuteAsRootBase e = new ExecuteAsRootBase() {
                    String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);

					@Override
                    protected ArrayList<String> getCommandsToExecute() {
                        String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
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
		String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
		String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);
        // Some permissions have been granted
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
		String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
        // Some permissions have been denied

    }

    public String getBaseUrl() {
        String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return mySharedPreferences.getString("prefBase",getString(R.string.base_val)).trim();
    }

    public String readFile(String name) {

        String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
		StringBuilder out = new StringBuilder();
        try {
            String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);
			FileInputStream filein = openFileInput(name);
            InputStreamReader inputreader = new InputStreamReader(filein);
            BufferedReader buffreader = new BufferedReader(inputreader);
            String line;

            while (( line = buffreader.readLine()) != null) {
                String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
				out.append(line);
            }

            filein.close();
        } catch (Exception e) {
            String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);
			Log.d(LOGTAG,"Unable to open: "+name);
        }
        return out.toString();
    }

    public void writeFile(String name, String body){
        String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
		try {
            String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);
			FileOutputStream fileout = openFileOutput(name, MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(body);
            outputWriter.close();
        } catch (Exception e) {
            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
			Log.w(LOGTAG, "Unable to write: "+name);
        }
    }

    public void setList(List<String> values)  {
        String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        directory = mySharedPreferences.getString("prefDirectory",Environment.DIRECTORY_DOWNLOADS).trim();
        boolean external = mySharedPreferences.getBoolean("prefExternal",false);
        md5check.clear();
        urls.clear();
        names.clear();
        String md5_ext = getString(R.string.md5_ext);
        final String md5_calc_ext = getString(R.string.md5calc_ext);
        if (external){
            String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);
			directory = Environment.DIRECTORY_DOWNLOADS;
        }

        File direct = new File(Environment.getExternalStorageDirectory() + "/" + directory);
        if (!direct.exists()) {
            String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);
			direct.mkdirs();
        }
        Log.w(LOGTAG, directory);
        File file[] = new File[0];
        if (EasyPermissions.hasPermissions(this, perms2)) {
            String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
			try {
                String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
				file = direct.listFiles();
            } catch (Exception e) {
                String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
				Log.w(LOGTAG, "Cant "+e.getMessage());
            }
        }

        getSupportActionBar().setTitle(values.get(values.size()-1));

        //for each returned value - filename and url
        for (int j = 0; j < values.size()-1; j+=2) {
            String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
			String md5val = "";
            String url = values.get(j+1).trim();
            String name = values.get(j).trim();
            int slash = name.lastIndexOf("/")+1;
            try {
                String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
				name = name.substring(slash);
            } catch (Exception e){
                String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
				Log.w(LOGTAG, "Cant find slash in "+name);
            }
            names.add(name);

            //for every result - check if file exists
            // then check if downloaded md5 exists
            // then check if calc exists

            for (int k = 0; k < file.length; k++) {

                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
				if (name.equals(file[k].getName())) {
                    String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
					String md5 = readFile(name + md5_ext);
                    if (!md5.isEmpty()) {
                        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
						String md5calc = readFile(name+md5_calc_ext);
                        if (md5calc.isEmpty()) {
                            String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);
							md5calc = MD5.calculateMD5(file[k]);
                        }
                        if (md5calc.equalsIgnoreCase(md5)) {
                            String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
							md5val = "Y";
                            //cache this result
                            writeFile(name+md5_calc_ext, md5calc);
                        } else {
                            String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);
							md5val = "N";
                            //don't cache, in the event the file is still downloading
                        }

                    } else {
                        String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
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
                            String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);

							@Override
                            public boolean canDismiss(int position) {
                                String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
								boolean dis = true;
                                if (md5check.get(position).isEmpty()) { String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);
								dis = false; };
                                return dis;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
								for (int position : reverseSortedPositions) {
                                    String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);
									final int pos = position;
                                    DialogInterface.OnClickListener yesListener = new DialogInterface.OnClickListener() {
                                        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);

										public void onClick(DialogInterface dialog, int which) {
                                            String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);
											File direct = new File(Environment.getExternalStorageDirectory() + "/" + directory+"/"+names.get(pos));
                                            Log.d(LOGTAG, "Delete " + direct.getName());
                                            if (direct.exists()&&direct.isFile()) { String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
											direct.delete(); }
                                            File md5file = new File(getFilesDir(), names.get(pos)+md5_calc_ext );
                                            if (md5file.exists()&&md5file.isFile()) { String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);
											md5file.delete(); }
                                            if (MainActivity.instance != null) {
                                                String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
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
          String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);

		@Override
          public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
            String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
			if (view.isEnabled()) {
                String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
				String url = urls.get(position);
                Context context = getBaseContext();
                Intent service = new Intent(context, Download.class);
                service.putExtra("url", url.toString());
                //service.putExtra("name",names.get(position).toString());
                service.putExtra("action", 2);
                context.startService(service);

                //new ParseURLDownload().execute(new String[]{url.toString()});

            } else {
                String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
				Log.d(LOGTAG, "Entry disabled");
            }
          }
        });
    }

    public void message_dialog_yes_no (String msg, DialogInterface.OnClickListener yesListener) {
        String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.yes), yesListener)
                .setNegativeButton(getString(R.string.no),  new DialogInterface.OnClickListener() {
                    String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);

					public void onClick(DialogInterface dialog, int id) {
                        String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);
						dialog.cancel();
                    }})
                .show();
    }

    /**
	 * Executes commands as root user
	 * @author http://muzikant-android.blogspot.com/2011/02/how-to-get-root-access-and-execute.html
	 */
	public abstract class ExecuteAsRootBase {
	  String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);

	public final boolean execute() {
	    String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);
		boolean retval = false;
	    try {
	      String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
		ArrayList<String> commands = getCommandsToExecute();
	      if (null != commands && commands.size() > 0) {
	        String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);
			Process suProcess = Runtime.getRuntime().exec("su");

	        DataOutputStream os = new DataOutputStream(suProcess.getOutputStream());

	        // Execute commands that require root access
	        for (String currCommand : commands) {
	          String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
			os.writeBytes(currCommand + "\n");
	          os.flush();
	        }

	        os.writeBytes("exit\n");
	        os.flush();

	        try {
	          String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
			int suProcessRetval = suProcess.waitFor();
	          if (255 != suProcessRetval) {
	            String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);
				// Root access granted
	            retval = true;
	          } else {
	            String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);
				// Root access denied
	            retval = false;
	          }
	        } catch (Exception ex) {
	          String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
			Log.e(LOGTAG, "Error executing root action\n"+ ex.toString());
	        }
	      }
	    } catch (IOException ex) {
	      String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);
		Log.w(LOGTAG, "Can't get root access", ex);
	    } catch (SecurityException ex) {
	      String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);
		Log.w(LOGTAG, "Can't get root access", ex);
	    } catch (Exception ex) {
	      String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
		Log.w(LOGTAG, "Error executing internal operation", ex);
	    }

	    return retval;
	  }

	  protected abstract ArrayList<String> getCommandsToExecute();
	}


    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);
        instance = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);
        instance = null;
    }

}
