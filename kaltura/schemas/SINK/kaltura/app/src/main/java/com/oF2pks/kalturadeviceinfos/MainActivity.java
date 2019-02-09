package com.oF2pks.kalturadeviceinfos;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.media.MediaDrm;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.oF2pks.kalturadeviceinfos.Utils.getProp;
import static com.oF2pks.kalturadeviceinfos.Utils.getZinfo;


public class MainActivity extends AppCompatActivity {

    final String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk49 = "";

	String dataLeAk48 = "";

	String dataLeAk43 = "";

	String dataLeAk41 = "";

	String dataLeAk39 = "";

	String dataLeAk38 = "";

	String dataLeAk37 = "";

	String dataLeAk36 = "";

	String dataLeAk35 = "";

	String dataLeAk34 = "";

	String dataLeAk32 = "";

	String dataLeAk31 = "";

	String dataLeAk30 = "";

	String dataLeAk28 = "";

	String dataLeAk27 = "";

	String report;

    private void showReport(String report) {
        dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-0", dataLeAk27);
		android.util.Log.d("leak-28-0", dataLeAk28);
		android.util.Log.d("leak-30-0", dataLeAk30);
		android.util.Log.d("leak-31-0", dataLeAk31);
		android.util.Log.d("leak-32-0", dataLeAk32);
		android.util.Log.d("leak-34-0", dataLeAk34);
		android.util.Log.d("leak-35-0", dataLeAk35);
		android.util.Log.d("leak-36-0", dataLeAk36);
		android.util.Log.d("leak-37-0", dataLeAk37);
		android.util.Log.d("leak-38-0", dataLeAk38);
		android.util.Log.d("leak-39-0", dataLeAk39);
		android.util.Log.d("leak-41-0", dataLeAk41);
		android.util.Log.d("leak-43-0", dataLeAk43);
		android.util.Log.d("leak-48-0", dataLeAk48);
		android.util.Log.d("leak-49-0", dataLeAk49);
		TextView reportView = (TextView) findViewById(R.id.textView);
        assert reportView != null;
        reportView.setText(report);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-1", dataLeAk27);
		android.util.Log.d("leak-28-1", dataLeAk28);
		android.util.Log.d("leak-30-1", dataLeAk30);
		android.util.Log.d("leak-31-1", dataLeAk31);
		android.util.Log.d("leak-32-1", dataLeAk32);
		android.util.Log.d("leak-34-1", dataLeAk34);
		android.util.Log.d("leak-35-1", dataLeAk35);
		android.util.Log.d("leak-36-1", dataLeAk36);
		android.util.Log.d("leak-37-1", dataLeAk37);
		android.util.Log.d("leak-38-1", dataLeAk38);
		android.util.Log.d("leak-39-1", dataLeAk39);
		android.util.Log.d("leak-41-1", dataLeAk41);
		android.util.Log.d("leak-43-1", dataLeAk43);
		android.util.Log.d("leak-48-1", dataLeAk48);
		android.util.Log.d("leak-49-1", dataLeAk49);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Collect data
        new CollectorTask().execute(false);

        FloatingActionButton fab = findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            
            String dataLeAk29 = "";

			@Override
            public void onClick(View view) {
                dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-51-0", dataLeAk51);
				android.util.Log.d("leak-29-0", dataLeAk29);
				showActionsDialog();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-2", dataLeAk27);
		android.util.Log.d("leak-28-2", dataLeAk28);
		android.util.Log.d("leak-30-2", dataLeAk30);
		android.util.Log.d("leak-31-2", dataLeAk31);
		android.util.Log.d("leak-32-2", dataLeAk32);
		android.util.Log.d("leak-34-2", dataLeAk34);
		android.util.Log.d("leak-35-2", dataLeAk35);
		android.util.Log.d("leak-36-2", dataLeAk36);
		android.util.Log.d("leak-37-2", dataLeAk37);
		android.util.Log.d("leak-38-2", dataLeAk38);
		android.util.Log.d("leak-39-2", dataLeAk39);
		android.util.Log.d("leak-41-2", dataLeAk41);
		android.util.Log.d("leak-43-2", dataLeAk43);
		android.util.Log.d("leak-48-2", dataLeAk48);
		android.util.Log.d("leak-49-2", dataLeAk49);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-3", dataLeAk27);
		android.util.Log.d("leak-28-3", dataLeAk28);
		android.util.Log.d("leak-30-3", dataLeAk30);
		android.util.Log.d("leak-31-3", dataLeAk31);
		android.util.Log.d("leak-32-3", dataLeAk32);
		android.util.Log.d("leak-34-3", dataLeAk34);
		android.util.Log.d("leak-35-3", dataLeAk35);
		android.util.Log.d("leak-36-3", dataLeAk36);
		android.util.Log.d("leak-37-3", dataLeAk37);
		android.util.Log.d("leak-38-3", dataLeAk38);
		android.util.Log.d("leak-39-3", dataLeAk39);
		android.util.Log.d("leak-41-3", dataLeAk41);
		android.util.Log.d("leak-43-3", dataLeAk43);
		android.util.Log.d("leak-48-3", dataLeAk48);
		android.util.Log.d("leak-49-3", dataLeAk49);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            TextView showText = new TextView(this);
            showText.setText(R.string.exoweb);
            showText.setTextIsSelectable(true);
            showText.setAutoLinkMask(Linkify.ALL);
            Linkify.addLinks(showText, Linkify.WEB_URLS);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(showText)
                    .setTitle("About")
                    .setCancelable(true)
                    .setNegativeButton(android.R.string.ok, null)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showActionsDialog() {
        dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-4", dataLeAk27);
		android.util.Log.d("leak-28-4", dataLeAk28);
		android.util.Log.d("leak-30-4", dataLeAk30);
		android.util.Log.d("leak-31-4", dataLeAk31);
		android.util.Log.d("leak-32-4", dataLeAk32);
		android.util.Log.d("leak-34-4", dataLeAk34);
		android.util.Log.d("leak-35-4", dataLeAk35);
		android.util.Log.d("leak-36-4", dataLeAk36);
		android.util.Log.d("leak-37-4", dataLeAk37);
		android.util.Log.d("leak-38-4", dataLeAk38);
		android.util.Log.d("leak-39-4", dataLeAk39);
		android.util.Log.d("leak-41-4", dataLeAk41);
		android.util.Log.d("leak-43-4", dataLeAk43);
		android.util.Log.d("leak-48-4", dataLeAk48);
		android.util.Log.d("leak-49-4", dataLeAk49);
		final String sTvndk=getProp("ro.vndk.version");
        String[] actions = {
                "Share...",
                "Refresh",
                "PRIVATE Ids GSF/Serial/Android" ,
                "proc/meminfo",
                "proc/cpuinfo",
                "?/etc/gps.conf",
                "getprop (aio)",
                "df (mounts)",
                "dumpsys media.extractor",
                "Treble linker namespace"+" ("+sTvndk+(getProp("ro.vndk.lite").equals("true")? "lite)":")"),
                "Matrix",
                //"cat /proc/self/mounts"
//                "Refresh with SafetyNet",
                //"(Provision Widevine)"
        };
        new AlertDialog.Builder(this).setTitle("Select action").setItems(actions, new DialogInterface.OnClickListener() {
            String dataLeAk33 = "";

			@Override
            public void onClick(DialogInterface dialog, int which) {
                dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-52-0", dataLeAk52);
				android.util.Log.d("leak-33-0", dataLeAk33);
				switch (which) {
                    case 0:
                        shareReport();
                        break;
                    case 1:
                        new CollectorTask().execute(false);
                        break;
                    case 2:
//                        new CollectorTask().execute(true);
//                        break;
//                    case 3:
                        showIDs();
                        break;
                    case 3:
                        showZinfo("cat /proc/meminfo",true,false);
                        break;
                    case 4:
                        showZinfo("cat /proc/cpuinfo", false,true);
                        break;
                    case 5:
                        if (new File("/system/etc/gps.conf").exists())
                            showZinfo("cat /system/etc/gps.conf",true,true);
                        else showZinfo("cat /vendor/etc/gps.conf",true,true);
                        break;
                    case 6:
                        showZinfo("getprop" , false,false);
                        break;
                    case 7:
                        showZinfo("df",true,false);
                        break;
                    case 8:
                        showZinfo("dumpsys media.extractor" , false,true);
                        break;
                    case 9:
                        //https://source.android.com/devices/architecture/vndk#vndk-versioning
                        if (getProp("ro.vndk.lite").equals("true"))showZinfo("cat /system/etc/ld.config.vndk_lite.txt",false,false);
                        else showZinfo("cat /system/etc/ld.config"+(sTvndk.equals("") ?"": "."+sTvndk)+".txt"  ,false,false);
                        break;
                    case 10:
                        showZinfo("cat /system/compatibility_matrix.xml" ,false,false);
                        break;
                    case 11:
                        showZinfo("cat /proc/self/mounts",false,false);
                        break;
                    /*case 6:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                            new AlertDialog.Builder(MainActivity.this).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startProvision();
                                }
                            }).setNegativeButton("No", null).setMessage("Are you sure you want to attempt Widevine Provisioning?").show();
                        }
                        break;
                    */
                }
            }
        }).show();
    }

    private void showZinfo(String s , boolean b, boolean linky) {
        dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-5", dataLeAk27);
		android.util.Log.d("leak-28-5", dataLeAk28);
		android.util.Log.d("leak-30-5", dataLeAk30);
		android.util.Log.d("leak-31-5", dataLeAk31);
		android.util.Log.d("leak-32-5", dataLeAk32);
		android.util.Log.d("leak-34-5", dataLeAk34);
		android.util.Log.d("leak-35-5", dataLeAk35);
		android.util.Log.d("leak-36-5", dataLeAk36);
		android.util.Log.d("leak-37-5", dataLeAk37);
		android.util.Log.d("leak-38-5", dataLeAk38);
		android.util.Log.d("leak-39-5", dataLeAk39);
		android.util.Log.d("leak-41-5", dataLeAk41);
		android.util.Log.d("leak-43-5", dataLeAk43);
		android.util.Log.d("leak-48-5", dataLeAk48);
		android.util.Log.d("leak-49-5", dataLeAk49);
		TextView showText = new TextView(this);
        showText.setText(getZinfo(s,"\n\u25A0",false));
        showText.setTextIsSelectable(true);
        if (b) {
            Typeface face = Typeface.createFromAsset(getAssets(), "fonts/RobotoMono-Bold.ttf");
            showText.setTypeface(face);
        }
        if (linky) {
            showText.setAutoLinkMask(Linkify.ALL);
            Linkify.addLinks(showText, Linkify.WEB_URLS);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        builder.setView(showText)
                .setTitle(s)
                .setCancelable(true)
                .setNegativeButton(android.R.string.ok, null)
                .show();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void startProvision() {
        dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-6", dataLeAk27);
		android.util.Log.d("leak-28-6", dataLeAk28);
		android.util.Log.d("leak-30-6", dataLeAk30);
		android.util.Log.d("leak-31-6", dataLeAk31);
		android.util.Log.d("leak-32-6", dataLeAk32);
		android.util.Log.d("leak-34-6", dataLeAk34);
		android.util.Log.d("leak-35-6", dataLeAk35);
		android.util.Log.d("leak-36-6", dataLeAk36);
		android.util.Log.d("leak-37-6", dataLeAk37);
		android.util.Log.d("leak-38-6", dataLeAk38);
		android.util.Log.d("leak-39-6", dataLeAk39);
		android.util.Log.d("leak-41-6", dataLeAk41);
		android.util.Log.d("leak-43-6", dataLeAk43);
		android.util.Log.d("leak-48-6", dataLeAk48);
		android.util.Log.d("leak-49-6", dataLeAk49);
		new ProvisionTask(this).execute();
    }

    private void provisionFailed(Exception e) {
		dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-7", dataLeAk27);
		android.util.Log.d("leak-28-7", dataLeAk28);
		android.util.Log.d("leak-30-7", dataLeAk30);
		android.util.Log.d("leak-31-7", dataLeAk31);
		android.util.Log.d("leak-32-7", dataLeAk32);
		android.util.Log.d("leak-34-7", dataLeAk34);
		android.util.Log.d("leak-35-7", dataLeAk35);
		android.util.Log.d("leak-36-7", dataLeAk36);
		android.util.Log.d("leak-37-7", dataLeAk37);
		android.util.Log.d("leak-38-7", dataLeAk38);
		android.util.Log.d("leak-39-7", dataLeAk39);
		android.util.Log.d("leak-41-7", dataLeAk41);
		android.util.Log.d("leak-43-7", dataLeAk43);
		android.util.Log.d("leak-48-7", dataLeAk48);
		android.util.Log.d("leak-49-7", dataLeAk49);
    }

    private void provisionSuccessful() {
		dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-8", dataLeAk27);
		android.util.Log.d("leak-28-8", dataLeAk28);
		android.util.Log.d("leak-30-8", dataLeAk30);
		android.util.Log.d("leak-31-8", dataLeAk31);
		android.util.Log.d("leak-32-8", dataLeAk32);
		android.util.Log.d("leak-34-8", dataLeAk34);
		android.util.Log.d("leak-35-8", dataLeAk35);
		android.util.Log.d("leak-36-8", dataLeAk36);
		android.util.Log.d("leak-37-8", dataLeAk37);
		android.util.Log.d("leak-38-8", dataLeAk38);
		android.util.Log.d("leak-39-8", dataLeAk39);
		android.util.Log.d("leak-41-8", dataLeAk41);
		android.util.Log.d("leak-43-8", dataLeAk43);
		android.util.Log.d("leak-48-8", dataLeAk48);
		android.util.Log.d("leak-49-8", dataLeAk49);
    }

    private void shareReport() {
        dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-9", dataLeAk27);
		android.util.Log.d("leak-28-9", dataLeAk28);
		android.util.Log.d("leak-30-9", dataLeAk30);
		android.util.Log.d("leak-31-9", dataLeAk31);
		android.util.Log.d("leak-32-9", dataLeAk32);
		android.util.Log.d("leak-34-9", dataLeAk34);
		android.util.Log.d("leak-35-9", dataLeAk35);
		android.util.Log.d("leak-36-9", dataLeAk36);
		android.util.Log.d("leak-37-9", dataLeAk37);
		android.util.Log.d("leak-38-9", dataLeAk38);
		android.util.Log.d("leak-39-9", dataLeAk39);
		android.util.Log.d("leak-41-9", dataLeAk41);
		android.util.Log.d("leak-43-9", dataLeAk43);
		android.util.Log.d("leak-48-9", dataLeAk48);
		android.util.Log.d("leak-49-9", dataLeAk49);
		String subject = "Kaltura Device Info - Report" + Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + "/" + Build.VERSION.SDK_INT;
        Intent shareIntent = intentWithText(subject, report);
        startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
    }


    private Intent intentWithText(String subject, String report) {
        dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-10", dataLeAk27);
		android.util.Log.d("leak-28-10", dataLeAk28);
		android.util.Log.d("leak-30-10", dataLeAk30);
		android.util.Log.d("leak-31-10", dataLeAk31);
		android.util.Log.d("leak-32-10", dataLeAk32);
		android.util.Log.d("leak-34-10", dataLeAk34);
		android.util.Log.d("leak-35-10", dataLeAk35);
		android.util.Log.d("leak-36-10", dataLeAk36);
		android.util.Log.d("leak-37-10", dataLeAk37);
		android.util.Log.d("leak-38-10", dataLeAk38);
		android.util.Log.d("leak-39-10", dataLeAk39);
		android.util.Log.d("leak-41-10", dataLeAk41);
		android.util.Log.d("leak-43-10", dataLeAk43);
		android.util.Log.d("leak-48-10", dataLeAk48);
		android.util.Log.d("leak-49-10", dataLeAk49);
		Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, report);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendIntent.setType("text/plain");
        return sendIntent;
    }

    private class CollectorTask extends AsyncTask<Boolean, Void, String> {

        String dataLeAk42 = "";

		String dataLeAk40 = "";

		@Override
        protected String doInBackground(Boolean... params) {
            dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-27-11", dataLeAk27);
			android.util.Log.d("leak-28-11", dataLeAk28);
			android.util.Log.d("leak-30-11", dataLeAk30);
			android.util.Log.d("leak-31-11", dataLeAk31);
			android.util.Log.d("leak-32-11", dataLeAk32);
			android.util.Log.d("leak-34-11", dataLeAk34);
			android.util.Log.d("leak-35-11", dataLeAk35);
			android.util.Log.d("leak-36-11", dataLeAk36);
			android.util.Log.d("leak-37-11", dataLeAk37);
			android.util.Log.d("leak-38-11", dataLeAk38);
			android.util.Log.d("leak-39-11", dataLeAk39);
			android.util.Log.d("leak-41-11", dataLeAk41);
			android.util.Log.d("leak-43-11", dataLeAk43);
			android.util.Log.d("leak-48-11", dataLeAk48);
			android.util.Log.d("leak-49-11", dataLeAk49);
			android.util.Log.d("leak-40-0", dataLeAk40);
			android.util.Log.d("leak-42-0", dataLeAk42);
			return Collector.getReport(MainActivity.this, params[0]);
        }

        @Override
        protected void onPostExecute(String jsonString) {
            dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-27-12", dataLeAk27);
			android.util.Log.d("leak-28-12", dataLeAk28);
			android.util.Log.d("leak-30-12", dataLeAk30);
			android.util.Log.d("leak-31-12", dataLeAk31);
			android.util.Log.d("leak-32-12", dataLeAk32);
			android.util.Log.d("leak-34-12", dataLeAk34);
			android.util.Log.d("leak-35-12", dataLeAk35);
			android.util.Log.d("leak-36-12", dataLeAk36);
			android.util.Log.d("leak-37-12", dataLeAk37);
			android.util.Log.d("leak-38-12", dataLeAk38);
			android.util.Log.d("leak-39-12", dataLeAk39);
			android.util.Log.d("leak-41-12", dataLeAk41);
			android.util.Log.d("leak-43-12", dataLeAk43);
			android.util.Log.d("leak-48-12", dataLeAk48);
			android.util.Log.d("leak-49-12", dataLeAk49);
			android.util.Log.d("leak-40-1", dataLeAk40);
			android.util.Log.d("leak-42-1", dataLeAk42);
			report = jsonString;
            showReport(jsonString);
            File output = new File(getExternalFilesDir(null), (Build.VERSION.RELEASE+Build.VERSION.INCREMENTAL+".json").replaceAll(" ",""));
            try {
                FileWriter writer;
                writer = new FileWriter(output);
                writer.write(report);
                writer.close();
                Toast.makeText(MainActivity.this, "Wrote report to " + output, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Failed writing report: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private static class ProvisionTask extends AsyncTask<Context, Void, String> {

        String dataLeAk47 = "";

		String dataLeAk46 = "";

		String dataLeAk45 = "";

		String dataLeAk44 = "";

		private final Context context;

        public ProvisionTask(Context context) {
            dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-44-0", dataLeAk44);
			android.util.Log.d("leak-45-0", dataLeAk45);
			android.util.Log.d("leak-46-0", dataLeAk46);
			android.util.Log.d("leak-47-0", dataLeAk47);
			this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
        @Override
        protected String doInBackground(Context... contexts) {
            dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-44-1", dataLeAk44);
			android.util.Log.d("leak-45-1", dataLeAk45);
			android.util.Log.d("leak-46-1", dataLeAk46);
			android.util.Log.d("leak-47-1", dataLeAk47);
			try {
                provisionWidevine();
                return null;
            } catch (Exception e) {
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-44-2", dataLeAk44);
			android.util.Log.d("leak-45-2", dataLeAk45);
			android.util.Log.d("leak-46-2", dataLeAk46);
			android.util.Log.d("leak-47-2", dataLeAk47);
			if (s == null) {
                Toast.makeText(context, "Provision Successful", Toast.LENGTH_LONG).show();
            } else {
                new AlertDialog.Builder(context).setTitle("Provision Failed").setMessage(s).show();
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
        private void provisionWidevine() throws Exception {
            dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-44-3", dataLeAk44);
			android.util.Log.d("leak-45-3", dataLeAk45);
			android.util.Log.d("leak-46-3", dataLeAk46);
			android.util.Log.d("leak-47-3", dataLeAk47);
			MediaDrm mediaDrm = new MediaDrm(Collector.WIDEVINE_UUID);
            MediaDrm.ProvisionRequest provisionRequest = mediaDrm.getProvisionRequest();
            String url = provisionRequest.getDefaultUrl() + "&signedRequest=" + new String(provisionRequest.getData());

            // send as empty post
            final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            int responseCode = con.getResponseCode();
            if (responseCode >= 300) {
                throw new Exception("Bad response code " + responseCode);
            }
            BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int b;
            while ((b = bis.read()) >= 0) {
                baos.write(b);
            }
            bis.close();

            final byte[] response = baos.toByteArray();
            Log.d("RESULT", Base64.encodeToString(response, Base64.NO_WRAP));
            baos.close();
            
            mediaDrm.provideProvisionResponse(response);
            mediaDrm.release();
        }
    }
    private void showIDs() {
        dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-13", dataLeAk27);
		android.util.Log.d("leak-28-13", dataLeAk28);
		android.util.Log.d("leak-30-13", dataLeAk30);
		android.util.Log.d("leak-31-13", dataLeAk31);
		android.util.Log.d("leak-32-13", dataLeAk32);
		android.util.Log.d("leak-34-13", dataLeAk34);
		android.util.Log.d("leak-35-13", dataLeAk35);
		android.util.Log.d("leak-36-13", dataLeAk36);
		android.util.Log.d("leak-37-13", dataLeAk37);
		android.util.Log.d("leak-38-13", dataLeAk38);
		android.util.Log.d("leak-39-13", dataLeAk39);
		android.util.Log.d("leak-41-13", dataLeAk41);
		android.util.Log.d("leak-43-13", dataLeAk43);
		android.util.Log.d("leak-48-13", dataLeAk48);
		android.util.Log.d("leak-49-13", dataLeAk49);
		TextView showText = new TextView(this);
        showText.setText(displayIDs());
        showText.setTextIsSelectable(true);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/RobotoMono-Bold.ttf");
        showText.setTypeface(face);
        showText.setAutoLinkMask(Linkify.ALL);
        Linkify.addLinks(showText, Linkify.WEB_URLS);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(showText)
                .setTitle("(LongPress to select...) PRIVATE Ids")
                .setCancelable(true)
                .setNegativeButton(android.R.string.ok, null)
                .show();
    }

    private String displayIDs() {
        dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-27-14", dataLeAk27);
		android.util.Log.d("leak-28-14", dataLeAk28);
		android.util.Log.d("leak-30-14", dataLeAk30);
		android.util.Log.d("leak-31-14", dataLeAk31);
		android.util.Log.d("leak-32-14", dataLeAk32);
		android.util.Log.d("leak-34-14", dataLeAk34);
		android.util.Log.d("leak-35-14", dataLeAk35);
		android.util.Log.d("leak-36-14", dataLeAk36);
		android.util.Log.d("leak-37-14", dataLeAk37);
		android.util.Log.d("leak-38-14", dataLeAk38);
		android.util.Log.d("leak-39-14", dataLeAk39);
		android.util.Log.d("leak-41-14", dataLeAk41);
		android.util.Log.d("leak-43-14", dataLeAk43);
		android.util.Log.d("leak-48-14", dataLeAk48);
		android.util.Log.d("leak-49-14", dataLeAk49);
		String marshmalow ="\nANDROIDid: "+ Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)+"\n";
        if (Build.VERSION.SDK_INT < 28) marshmalow+="SERIALid:  "+Build.SERIAL+"\n";

        Cursor query = getContentResolver().query(Uri.parse("content://com.google.android.gsf.gservices"), null, null, new String[] { "android_id" }, null);
        if (query == null) {
            marshmalow+="GSFid:     unknow\n";
            return marshmalow;
        }
        if (!query.moveToFirst() || query.getColumnCount() < 2 || query.getString(1) == null) {
            marshmalow+="GSFid:     unknow\n";
            if (query.getString(1) == null) marshmalow+="No account, nu gsf...";
            query.close();
            return marshmalow;
        }
        final String toHexString = Long.toHexString(Long.parseLong(query.getString(1)));
        query.close();

        marshmalow+="\nGSFid:     "+ toHexString.toUpperCase().trim()+"\n\n";
        marshmalow+="REGISTER GSF https://www.google.com/android/uncertified\n\n";
        marshmalow+="More info https://www.xda-developers.com/how-to-fix-device-not-certified-by-google-error/";
        return marshmalow;
    }

}
