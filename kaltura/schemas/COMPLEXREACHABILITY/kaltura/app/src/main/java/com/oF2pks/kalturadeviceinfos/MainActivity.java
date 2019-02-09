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

    String report;

    private void showReport(String report) {
        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP101.put("test", new java.util.HashMap<String, String>());
		leakMaP101.get("test").put("test", dataLeAk101);
		String dataLeAkPath101 = leakMaP101.get("test").get("test");
		android.util.Log.d("leak-101", dataLeAkPath101);
		TextView reportView = (TextView) findViewById(R.id.textView);
        assert reportView != null;
        reportView.setText(report);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
		android.util.Log.d("leak-102", dataLeAkPath102);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Collect data
        new CollectorTask().execute(false);

        FloatingActionButton fab = findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
                String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
				android.util.Log.d("leak-103", dataLeAkPath103);
				showActionsDialog();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
		String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
		android.util.Log.d("leak-104", dataLeAkPath104);
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP105.put("test", new java.util.HashMap<String, String>());
		leakMaP105.get("test").put("test", dataLeAk105);
		String dataLeAkPath105 = leakMaP105.get("test").get("test");
		android.util.Log.d("leak-105", dataLeAkPath105);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
			android.util.Log.d("leak-106", dataLeAkPath106);
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
        String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
		android.util.Log.d("leak-107", dataLeAkPath107);
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
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
				String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
				android.util.Log.d("leak-108", dataLeAkPath108);
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
        String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP109.put("test", new java.util.HashMap<String, String>());
		leakMaP109.get("test").put("test", dataLeAk109);
		String dataLeAkPath109 = leakMaP109.get("test").get("test");
		android.util.Log.d("leak-109", dataLeAkPath109);
		TextView showText = new TextView(this);
        showText.setText(getZinfo(s,"\n\u25A0",false));
        showText.setTextIsSelectable(true);
        if (b) {
            String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
			android.util.Log.d("leak-110", dataLeAkPath110);
			Typeface face = Typeface.createFromAsset(getAssets(), "fonts/RobotoMono-Bold.ttf");
            showText.setTypeface(face);
        }
        if (linky) {
            String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
			android.util.Log.d("leak-111", dataLeAkPath111);
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
        String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
		String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
		android.util.Log.d("leak-112", dataLeAkPath112);
		new ProvisionTask(this).execute();
    }

    private void provisionFailed(Exception e) {
		String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP113.put("test", new java.util.HashMap<String, String>());
		leakMaP113.get("test").put("test", dataLeAk113);
		String dataLeAkPath113 = leakMaP113.get("test").get("test");
		android.util.Log.d("leak-113", dataLeAkPath113);
    }

    private void provisionSuccessful() {
		String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
		android.util.Log.d("leak-114", dataLeAkPath114);
    }

    private void shareReport() {
        String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
		android.util.Log.d("leak-115", dataLeAkPath115);
		String subject = "Kaltura Device Info - Report" + Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + "/" + Build.VERSION.SDK_INT;
        Intent shareIntent = intentWithText(subject, report);
        startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
    }


    private Intent intentWithText(String subject, String report) {
        String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
		String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
		android.util.Log.d("leak-116", dataLeAkPath116);
		Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, report);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendIntent.setType("text/plain");
        return sendIntent;
    }

    private class CollectorTask extends AsyncTask<Boolean, Void, String> {

        @Override
        protected String doInBackground(Boolean... params) {
            String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP117.put("test", new java.util.HashMap<String, String>());
			leakMaP117.get("test").put("test", dataLeAk117);
			String dataLeAkPath117 = leakMaP117.get("test").get("test");
			android.util.Log.d("leak-117", dataLeAkPath117);
			return Collector.getReport(MainActivity.this, params[0]);
        }

        @Override
        protected void onPostExecute(String jsonString) {
            String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
			android.util.Log.d("leak-118", dataLeAkPath118);
			report = jsonString;
            showReport(jsonString);
            File output = new File(getExternalFilesDir(null), (Build.VERSION.RELEASE+Build.VERSION.INCREMENTAL+".json").replaceAll(" ",""));
            try {
                String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
				android.util.Log.d("leak-119", dataLeAkPath119);
				FileWriter writer;
                writer = new FileWriter(output);
                writer.write(report);
                writer.close();
                Toast.makeText(MainActivity.this, "Wrote report to " + output, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
				String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
				android.util.Log.d("leak-120", dataLeAkPath120);
				Toast.makeText(MainActivity.this, "Failed writing report: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private static class ProvisionTask extends AsyncTask<Context, Void, String> {

        private final Context context;

        public ProvisionTask(Context context) {
            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP121.put("test", new java.util.HashMap<String, String>());
			leakMaP121.get("test").put("test", dataLeAk121);
			String dataLeAkPath121 = leakMaP121.get("test").get("test");
			android.util.Log.d("leak-121", dataLeAkPath121);
			this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
        @Override
        protected String doInBackground(Context... contexts) {
            String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
			android.util.Log.d("leak-122", dataLeAkPath122);
			try {
                String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
				android.util.Log.d("leak-123", dataLeAkPath123);
				provisionWidevine();
                return null;
            } catch (Exception e) {
                String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
				String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
				android.util.Log.d("leak-124", dataLeAkPath124);
				return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP125.put("test", new java.util.HashMap<String, String>());
			leakMaP125.get("test").put("test", dataLeAk125);
			String dataLeAkPath125 = leakMaP125.get("test").get("test");
			android.util.Log.d("leak-125", dataLeAkPath125);
			if (s == null) {
                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
				android.util.Log.d("leak-126", dataLeAkPath126);
				Toast.makeText(context, "Provision Successful", Toast.LENGTH_LONG).show();
            } else {
                String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
				android.util.Log.d("leak-127", dataLeAkPath127);
				new AlertDialog.Builder(context).setTitle("Provision Failed").setMessage(s).show();
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
        private void provisionWidevine() throws Exception {
            String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
			String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
			android.util.Log.d("leak-128", dataLeAkPath128);
			MediaDrm mediaDrm = new MediaDrm(Collector.WIDEVINE_UUID);
            MediaDrm.ProvisionRequest provisionRequest = mediaDrm.getProvisionRequest();
            String url = provisionRequest.getDefaultUrl() + "&signedRequest=" + new String(provisionRequest.getData());

            // send as empty post
            final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            int responseCode = con.getResponseCode();
            if (responseCode >= 300) {
                String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP129.put("test", new java.util.HashMap<String, String>());
				leakMaP129.get("test").put("test", dataLeAk129);
				String dataLeAkPath129 = leakMaP129.get("test").get("test");
				android.util.Log.d("leak-129", dataLeAkPath129);
				throw new Exception("Bad response code " + responseCode);
            }
            BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int b;
            while ((b = bis.read()) >= 0) {
                String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
				android.util.Log.d("leak-130", dataLeAkPath130);
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
        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
		android.util.Log.d("leak-131", dataLeAkPath131);
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
        String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
		String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
		android.util.Log.d("leak-132", dataLeAkPath132);
		String marshmalow ="\nANDROIDid: "+ Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)+"\n";
        if (Build.VERSION.SDK_INT < 28) marshmalow+="SERIALid:  "+Build.SERIAL+"\n";

        Cursor query = getContentResolver().query(Uri.parse("content://com.google.android.gsf.gservices"), null, null, new String[] { "android_id" }, null);
        if (query == null) {
            String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP133.put("test", new java.util.HashMap<String, String>());
			leakMaP133.get("test").put("test", dataLeAk133);
			String dataLeAkPath133 = leakMaP133.get("test").get("test");
			android.util.Log.d("leak-133", dataLeAkPath133);
			marshmalow+="GSFid:     unknow\n";
            return marshmalow;
        }
        if (!query.moveToFirst() || query.getColumnCount() < 2 || query.getString(1) == null) {
            String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
			android.util.Log.d("leak-134", dataLeAkPath134);
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
