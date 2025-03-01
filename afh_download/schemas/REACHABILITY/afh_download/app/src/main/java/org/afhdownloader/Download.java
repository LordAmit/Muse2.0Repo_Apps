package org.afhdownloader;

import android.app.DownloadManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.net.URLDecoder;


/**
 * Created by daktak on 4/26/16.
 */
public class Download extends Service {

    String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
	/** indicates how to behave if the service is killed */
    int mStartMode;
    /** interface for clients that bind */
    IBinder mBinder;
    /** indicates whether onRebind should be used */
    boolean mAllowRebind;
    private static final String LOGTAG = LogUtil
            .makeLogTag(Download.class);
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
		String url = intent.getStringExtra("url");
        int action = intent.getIntExtra("action",1);
        if (action == 1) {
            String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
			new ParseURL().execute(new String[]{url});
        } else if (action ==2 ){
            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
			new ParseURLDownload().execute(new String[]{url});
        } else if (action == 3) {
            String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
			new downloadFirstThread().execute(new String[]{url});
        }

        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
		return mBinder;
    }

    private class ParseURL extends AsyncTask<String, Void, String> {

        String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);

		@Override
        protected String doInBackground(String... strings) {
            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
			return parseUrl(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
			String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
            String newS = s.substring(1,s.length()-1);
            List<String> array = Arrays.asList(newS.split(","));
            if (MainActivity.instance != null) {
                String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);
				MainActivity.instance.setList(array);
            }
        }
    }

    public String parseUrl(String url) {
        String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
		Log.d(LOGTAG, "Fetch: "+url);
        ArrayList<String> urls = new ArrayList<String>();
        try {
	    String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
		String userAgent = getString(R.string.user_agent);
            Document doc = Jsoup.connect(url).timeout(10*1000).followRedirects(true).userAgent(userAgent).get();
            SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String selector = mySharedPreferences.getString("prefSelector",getString(R.string.selector_val)).trim();
            //String selector = getString(R.string.selector_val);
            Elements links = doc.select(selector);

            for (Element link : links) {
                String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
				urls.add(link.ownText());
                urls.add(link.attr("href"));
            }
            //set title
            String head = getString(R.string.app_name);
            try {
                String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
				Elements h1s = doc.select(getString(R.string.head_selector));
                head = h1s.get(0).ownText();
            } catch (Exception e) {
                String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
				Log.d(LOGTAG,"Unable to find heading");
            }
            urls.add(head);

        } catch (Throwable t) {
            String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
			Log.e(LOGTAG,t.getMessage());
        }

        return urls.toString();
    }

    public String getFirstUrl(List<String> array){
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
		String url = "";
        for (String i : array) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
			i = i.trim();
            /*
            String prefix = "";
            if (!(i.startsWith("http"))) {
                prefix = getBaseUrl();
            }*/
            url = i.substring(2,i.length());
        }
        return url;
    }

    public String getBaseUrl() {
        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return mySharedPreferences.getString("prefBase",getString(R.string.base_val)).trim()+"/";
    }

    public String getMD5(String url) {
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
		String md5S ="";
        try {
	    String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
		Log.d(LOGTAG, "md5 url: "+url);
	    String userAgent = getString(R.string.user_agent);
            Document doc = Jsoup.connect(url).timeout(10 * 1000).followRedirects(true).userAgent(userAgent).get();
	    String select_md5 = getString(R.string.md5_sel_val);
	    Log.d(LOGTAG, "md5 selector: "+select_md5);
            Elements md5s = doc.select(select_md5);
            for (Element md5 : md5s) {
                String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
				md5S = md5.ownText();
		Log.d(LOGTAG, "md5 value: "+md5S);
            }
        } catch (Throwable t) {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
			Log.e(LOGTAG,t.getMessage());
        }
        return md5S;
    }

    public ArrayList<String> getDLUrl(String url){
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String data = mySharedPreferences.getString("prefMirrorData",getString(R.string.mirrordata_val)) + url;
        String mUrl = mySharedPreferences.getString("prefMirrorURL",getString(R.string.mirrorurl_val));
	String userAgent = getString(R.string.user_agent);
        Log.d(LOGTAG, "Download parse: " +url);

        ArrayList<String> urls = new ArrayList<String>();

        try {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
			HttpURLConnection httpcon = (HttpURLConnection) ((new URL(mUrl).openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setRequestMethod("POST");
	    httpcon.setRequestProperty("User-Agent",userAgent);
	    httpcon.setRequestProperty("X-MOD-SBB-CTYPE","xhr");
            httpcon.connect();

            //Write
            OutputStream os = httpcon.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(data);
            writer.close();
            os.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(httpcon.getInputStream(),"UTF-8"));

            String line = null;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
				sb.append(line);
            }

            br.close();
            //result = sb.toString();
            JSONObject jo = new JSONObject(sb.toString());
            JSONArray mirrors = jo.getJSONArray("MIRRORS");
            for (int i=0; i < mirrors.length(); i++){
                String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
				JSONObject mirror = mirrors.getJSONObject(i);
                String urlJS = mirror.getString("url");
                urls.add(urlJS);
            }

        } catch (Throwable t) {
            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
			Log.e(LOGTAG,t.getMessage());
        }

        //create md5 file
        new dlMd5().execute(new String[]{urls.get(0), url});

        return urls;
    }

    private class dlMd5 extends AsyncTask<String, Void, String> {
        String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);

		@Override
        protected String doInBackground(String... strings) {
            String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
			try {
                String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
				String aUrl = strings[0];
		String md5_ext = getString(R.string.md5_ext);
                int slash = aUrl.lastIndexOf("/");
                String filename = aUrl.substring(slash+1);
		filename = URLDecoder.decode(filename) + md5_ext;
		Log.d(LOGTAG,"Saving File: "+filename);
                String body = getMD5(getBaseUrl()+"/?"+strings[1]);
		Log.d(LOGTAG,"Found MD5: "+body);
                FileOutputStream fileout=openFileOutput(filename, MODE_PRIVATE);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                outputWriter.write(body);
                outputWriter.close();

            } catch (java.io.IOException e) {
                String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
				Log.e(LOGTAG,e.getMessage());
            }
            return null;
        }

    }

    private class downloadFirstThread extends AsyncTask<String, Void, String> {

        String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);

		@Override
        protected String doInBackground(String... strings) {
            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
			return parseUrl(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
			String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
            String newS = s.substring(1,s.length()-1);
            List<String> array = Arrays.asList(newS.split(","));

            String url = getFirstUrl(array);
            new ParseURLDownload().execute(new String[]{url.toString()});

        }
    }

    private class ParseURLDownload extends AsyncTask<String, Void, String> {

        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);


		@Override
        protected String doInBackground(String... strings) {
            String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
			return getDLUrl(strings[0]).toString();
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
			String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
            String newS = s.substring(1,s.length()-1);
            List<String> array = Arrays.asList(newS.split(","));
            String url = array.get(0);

            Log.d(LOGTAG, url);
            if (!(url.isEmpty())){
                String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
				int slash = url.lastIndexOf("/");
                String filename = url.substring(slash+1);
                download(url, getString(R.string.app_name), filename, filename);
            }

        }
    }
    public void download(String url, String desc, String title, String filename) {
        String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String exten = "/";

        if (!url.endsWith(exten)) {

            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
			Log.d(LOGTAG, "Downloading: " + url);
            boolean external = mySharedPreferences.getBoolean("prefExternal", false);


            String directory = mySharedPreferences.getString("prefDirectory", Environment.DIRECTORY_DOWNLOADS).trim();
            if (!(directory.startsWith("/"))) {
                String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
				directory = "/" + directory;
            }
            File direct = new File(Environment.getExternalStorageDirectory() + directory);

            if (!direct.exists()) {
                String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
				direct.mkdirs();
            }
            boolean fileExists = false;

            //check to see if we already have the file
            //this will make scheduling better
            if (EasyPermissions.hasPermissions(this, MainActivity.perms2)) {
                String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
				//have to assume we want to download the file if we can't check the dir
                File f = new File(direct.getAbsolutePath());
                File file[] = f.listFiles();
                for (int i = 0; i < file.length; i++) {
                    String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
					if (filename.equals(file[i].getName())) {
                        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
						fileExists = true;
                    }
                }
            }

            if (!fileExists) {
                String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
				if (external) {
                    String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);
                } else if (EasyPermissions.hasPermissions(this, MainActivity.perms)) {
                    String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
					DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                    request.setDescription(desc);
                    request.setTitle(title);

                    // in order for this if to run, you must use the android 3.2 to compile your app
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
						request.allowScanningByMediaScanner();
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    }

                    boolean wifionly = mySharedPreferences.getBoolean("prefWIFI", true);
                    //Restrict the types of networks over which this download may proceed.
                    if (wifionly) {
                        String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
						request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
                    } else {
                        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
						request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                    }
                    //Set whether this download may proceed over a roaming connection.
                    request.setAllowedOverRoaming(false);
                    request.setDestinationInExternalPublicDir(directory, filename);

                    // get download service and enqueue file
                    DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    manager.enqueue(request);
                } else {
                    String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
					Log.d(LOGTAG, "fallout");
                }
            } else {
                String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
				Log.d(LOGTAG, "file-exists");
            }
        } else {
            String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
			Log.d(LOGTAG, "Not downloading: " + url);
        }
    }

}
