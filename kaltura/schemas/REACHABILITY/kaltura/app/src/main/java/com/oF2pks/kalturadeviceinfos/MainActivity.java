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

    String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);

	String report;

    private void showReport(String report) {
        String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
		TextView reportView = (TextView) findViewById(R.id.textView);
        assert reportView != null;
        reportView.setText(report);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Collect data
        new CollectorTask().execute(false);

        FloatingActionButton fab = findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            
            String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);

			@Override
            public void onClick(View view) {
                String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
				showActionsDialog();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);
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
        String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
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
            String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);

			@Override
            public void onClick(DialogInterface dialog, int which) {
                String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
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
        String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);
		TextView showText = new TextView(this);
        showText.setText(getZinfo(s,"\n\u25A0",false));
        showText.setTextIsSelectable(true);
        if (b) {
            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
			Typeface face = Typeface.createFromAsset(getAssets(), "fonts/RobotoMono-Bold.ttf");
            showText.setTypeface(face);
        }
        if (linky) {
            String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
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
        String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);
		new ProvisionTask(this).execute();
    }

    private void provisionFailed(Exception e) {
		String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);
    }

    private void provisionSuccessful() {
		String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
    }

    private void shareReport() {
        String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
		String subject = "Kaltura Device Info - Report" + Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + "/" + Build.VERSION.SDK_INT;
        Intent shareIntent = intentWithText(subject, report);
        startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
    }


    private Intent intentWithText(String subject, String report) {
        String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
		Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, report);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendIntent.setType("text/plain");
        return sendIntent;
    }

    private class CollectorTask extends AsyncTask<Boolean, Void, String> {

        String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);

		@Override
        protected String doInBackground(Boolean... params) {
            String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
			return Collector.getReport(MainActivity.this, params[0]);
        }

        @Override
        protected void onPostExecute(String jsonString) {
            String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
			report = jsonString;
            showReport(jsonString);
            File output = new File(getExternalFilesDir(null), (Build.VERSION.RELEASE+Build.VERSION.INCREMENTAL+".json").replaceAll(" ",""));
            try {
                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
				FileWriter writer;
                writer = new FileWriter(output);
                writer.write(report);
                writer.close();
                Toast.makeText(MainActivity.this, "Wrote report to " + output, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
				Toast.makeText(MainActivity.this, "Failed writing report: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private static class ProvisionTask extends AsyncTask<Context, Void, String> {

        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);

		private final Context context;

        public ProvisionTask(Context context) {
            String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);
			this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
        @Override
        protected String doInBackground(Context... contexts) {
            String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
			try {
                String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);
				provisionWidevine();
                return null;
            } catch (Exception e) {
                String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
				return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);
			if (s == null) {
                String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
				Toast.makeText(context, "Provision Successful", Toast.LENGTH_LONG).show();
            } else {
                String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);
				new AlertDialog.Builder(context).setTitle("Provision Failed").setMessage(s).show();
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
        private void provisionWidevine() throws Exception {
            String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
			MediaDrm mediaDrm = new MediaDrm(Collector.WIDEVINE_UUID);
            MediaDrm.ProvisionRequest provisionRequest = mediaDrm.getProvisionRequest();
            String url = provisionRequest.getDefaultUrl() + "&signedRequest=" + new String(provisionRequest.getData());

            // send as empty post
            final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            int responseCode = con.getResponseCode();
            if (responseCode >= 300) {
                String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);
				throw new Exception("Bad response code " + responseCode);
            }
            BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int b;
            while ((b = bis.read()) >= 0) {
                String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
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
        String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);
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
        String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
		String marshmalow ="\nANDROIDid: "+ Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)+"\n";
        if (Build.VERSION.SDK_INT < 28) marshmalow+="SERIALid:  "+Build.SERIAL+"\n";

        Cursor query = getContentResolver().query(Uri.parse("content://com.google.android.gsf.gservices"), null, null, new String[] { "android_id" }, null);
        if (query == null) {
            String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);
			marshmalow+="GSFid:     unknow\n";
            return marshmalow;
        }
        if (!query.moveToFirst() || query.getColumnCount() < 2 || query.getString(1) == null) {
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
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
