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

    String dataLeAk24 = "";
	String dataLeAk23 = "";
	String dataLeAk21 = "";
	String dataLeAk19 = "";
	String dataLeAk17 = "";
	String dataLeAk15 = "";
	String dataLeAk13 = "";
	String dataLeAk12 = "";
	String dataLeAk11 = "";
	String dataLeAk10 = "";
	String dataLeAk9 = "";
	String dataLeAk8 = "";
	String dataLeAk6 = "";
	String dataLeAk4 = "";
	String dataLeAk3 = "";
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
        dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-3-0", dataLeAk3);
		android.util.Log.d("leak-4-0", dataLeAk4);
		android.util.Log.d("leak-6-0", dataLeAk6);
		android.util.Log.d("leak-8-0", dataLeAk8);
		android.util.Log.d("leak-9-0", dataLeAk9);
		android.util.Log.d("leak-10-0", dataLeAk10);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-12-0", dataLeAk12);
		android.util.Log.d("leak-13-0", dataLeAk13);
		android.util.Log.d("leak-15-0", dataLeAk15);
		android.util.Log.d("leak-17-0", dataLeAk17);
		android.util.Log.d("leak-19-0", dataLeAk19);
		android.util.Log.d("leak-21-0", dataLeAk21);
		android.util.Log.d("leak-23-0", dataLeAk23);
		android.util.Log.d("leak-24-0", dataLeAk24);
		String url = intent.getStringExtra("url");
        int action = intent.getIntExtra("action",1);
        if (action == 1) {
            new ParseURL().execute(new String[]{url});
        } else if (action ==2 ){
            new ParseURLDownload().execute(new String[]{url});
        } else if (action == 3) {
            new downloadFirstThread().execute(new String[]{url});
        }

        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-3-1", dataLeAk3);
		android.util.Log.d("leak-4-1", dataLeAk4);
		android.util.Log.d("leak-6-1", dataLeAk6);
		android.util.Log.d("leak-8-1", dataLeAk8);
		android.util.Log.d("leak-9-1", dataLeAk9);
		android.util.Log.d("leak-10-1", dataLeAk10);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-12-1", dataLeAk12);
		android.util.Log.d("leak-13-1", dataLeAk13);
		android.util.Log.d("leak-15-1", dataLeAk15);
		android.util.Log.d("leak-17-1", dataLeAk17);
		android.util.Log.d("leak-19-1", dataLeAk19);
		android.util.Log.d("leak-21-1", dataLeAk21);
		android.util.Log.d("leak-23-1", dataLeAk23);
		android.util.Log.d("leak-24-1", dataLeAk24);
		return mBinder;
    }

    private class ParseURL extends AsyncTask<String, Void, String> {

        String dataLeAk7 = "";

		String dataLeAk5 = "";

		@Override
        protected String doInBackground(String... strings) {
            dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-3-2", dataLeAk3);
			android.util.Log.d("leak-4-2", dataLeAk4);
			android.util.Log.d("leak-6-2", dataLeAk6);
			android.util.Log.d("leak-8-2", dataLeAk8);
			android.util.Log.d("leak-9-2", dataLeAk9);
			android.util.Log.d("leak-10-2", dataLeAk10);
			android.util.Log.d("leak-11-2", dataLeAk11);
			android.util.Log.d("leak-12-2", dataLeAk12);
			android.util.Log.d("leak-13-2", dataLeAk13);
			android.util.Log.d("leak-15-2", dataLeAk15);
			android.util.Log.d("leak-17-2", dataLeAk17);
			android.util.Log.d("leak-19-2", dataLeAk19);
			android.util.Log.d("leak-21-2", dataLeAk21);
			android.util.Log.d("leak-23-2", dataLeAk23);
			android.util.Log.d("leak-24-2", dataLeAk24);
			android.util.Log.d("leak-5-0", dataLeAk5);
			android.util.Log.d("leak-7-0", dataLeAk7);
			return parseUrl(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
			dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-3-3", dataLeAk3);
			android.util.Log.d("leak-4-3", dataLeAk4);
			android.util.Log.d("leak-6-3", dataLeAk6);
			android.util.Log.d("leak-8-3", dataLeAk8);
			android.util.Log.d("leak-9-3", dataLeAk9);
			android.util.Log.d("leak-10-3", dataLeAk10);
			android.util.Log.d("leak-11-3", dataLeAk11);
			android.util.Log.d("leak-12-3", dataLeAk12);
			android.util.Log.d("leak-13-3", dataLeAk13);
			android.util.Log.d("leak-15-3", dataLeAk15);
			android.util.Log.d("leak-17-3", dataLeAk17);
			android.util.Log.d("leak-19-3", dataLeAk19);
			android.util.Log.d("leak-21-3", dataLeAk21);
			android.util.Log.d("leak-23-3", dataLeAk23);
			android.util.Log.d("leak-24-3", dataLeAk24);
			android.util.Log.d("leak-5-1", dataLeAk5);
			android.util.Log.d("leak-7-1", dataLeAk7);
            String newS = s.substring(1,s.length()-1);
            List<String> array = Arrays.asList(newS.split(","));
            if (MainActivity.instance != null) {
                MainActivity.instance.setList(array);
            }
        }
    }

    public String parseUrl(String url) {
        dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-3-4", dataLeAk3);
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-6-4", dataLeAk6);
		android.util.Log.d("leak-8-4", dataLeAk8);
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-10-4", dataLeAk10);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-15-4", dataLeAk15);
		android.util.Log.d("leak-17-4", dataLeAk17);
		android.util.Log.d("leak-19-4", dataLeAk19);
		android.util.Log.d("leak-21-4", dataLeAk21);
		android.util.Log.d("leak-23-4", dataLeAk23);
		android.util.Log.d("leak-24-4", dataLeAk24);
		Log.d(LOGTAG, "Fetch: "+url);
        ArrayList<String> urls = new ArrayList<String>();
        try {
	    String userAgent = getString(R.string.user_agent);
            Document doc = Jsoup.connect(url).timeout(10*1000).followRedirects(true).userAgent(userAgent).get();
            SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String selector = mySharedPreferences.getString("prefSelector",getString(R.string.selector_val)).trim();
            //String selector = getString(R.string.selector_val);
            Elements links = doc.select(selector);

            for (Element link : links) {
                urls.add(link.ownText());
                urls.add(link.attr("href"));
            }
            //set title
            String head = getString(R.string.app_name);
            try {
                Elements h1s = doc.select(getString(R.string.head_selector));
                head = h1s.get(0).ownText();
            } catch (Exception e) {
                Log.d(LOGTAG,"Unable to find heading");
            }
            urls.add(head);

        } catch (Throwable t) {
            Log.e(LOGTAG,t.getMessage());
        }

        return urls.toString();
    }

    public String getFirstUrl(List<String> array){
        dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-3-5", dataLeAk3);
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-6-5", dataLeAk6);
		android.util.Log.d("leak-8-5", dataLeAk8);
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-10-5", dataLeAk10);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-15-5", dataLeAk15);
		android.util.Log.d("leak-17-5", dataLeAk17);
		android.util.Log.d("leak-19-5", dataLeAk19);
		android.util.Log.d("leak-21-5", dataLeAk21);
		android.util.Log.d("leak-23-5", dataLeAk23);
		android.util.Log.d("leak-24-5", dataLeAk24);
		String url = "";
        for (String i : array) {
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
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-3-6", dataLeAk3);
		android.util.Log.d("leak-4-6", dataLeAk4);
		android.util.Log.d("leak-6-6", dataLeAk6);
		android.util.Log.d("leak-8-6", dataLeAk8);
		android.util.Log.d("leak-9-6", dataLeAk9);
		android.util.Log.d("leak-10-6", dataLeAk10);
		android.util.Log.d("leak-11-6", dataLeAk11);
		android.util.Log.d("leak-12-6", dataLeAk12);
		android.util.Log.d("leak-13-6", dataLeAk13);
		android.util.Log.d("leak-15-6", dataLeAk15);
		android.util.Log.d("leak-17-6", dataLeAk17);
		android.util.Log.d("leak-19-6", dataLeAk19);
		android.util.Log.d("leak-21-6", dataLeAk21);
		android.util.Log.d("leak-23-6", dataLeAk23);
		android.util.Log.d("leak-24-6", dataLeAk24);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return mySharedPreferences.getString("prefBase",getString(R.string.base_val)).trim()+"/";
    }

    public String getMD5(String url) {
        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-3-7", dataLeAk3);
		android.util.Log.d("leak-4-7", dataLeAk4);
		android.util.Log.d("leak-6-7", dataLeAk6);
		android.util.Log.d("leak-8-7", dataLeAk8);
		android.util.Log.d("leak-9-7", dataLeAk9);
		android.util.Log.d("leak-10-7", dataLeAk10);
		android.util.Log.d("leak-11-7", dataLeAk11);
		android.util.Log.d("leak-12-7", dataLeAk12);
		android.util.Log.d("leak-13-7", dataLeAk13);
		android.util.Log.d("leak-15-7", dataLeAk15);
		android.util.Log.d("leak-17-7", dataLeAk17);
		android.util.Log.d("leak-19-7", dataLeAk19);
		android.util.Log.d("leak-21-7", dataLeAk21);
		android.util.Log.d("leak-23-7", dataLeAk23);
		android.util.Log.d("leak-24-7", dataLeAk24);
		String md5S ="";
        try {
	    Log.d(LOGTAG, "md5 url: "+url);
	    String userAgent = getString(R.string.user_agent);
            Document doc = Jsoup.connect(url).timeout(10 * 1000).followRedirects(true).userAgent(userAgent).get();
	    String select_md5 = getString(R.string.md5_sel_val);
	    Log.d(LOGTAG, "md5 selector: "+select_md5);
            Elements md5s = doc.select(select_md5);
            for (Element md5 : md5s) {
                md5S = md5.ownText();
		Log.d(LOGTAG, "md5 value: "+md5S);
            }
        } catch (Throwable t) {
            Log.e(LOGTAG,t.getMessage());
        }
        return md5S;
    }

    public ArrayList<String> getDLUrl(String url){
        dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-3-8", dataLeAk3);
		android.util.Log.d("leak-4-8", dataLeAk4);
		android.util.Log.d("leak-6-8", dataLeAk6);
		android.util.Log.d("leak-8-8", dataLeAk8);
		android.util.Log.d("leak-9-8", dataLeAk9);
		android.util.Log.d("leak-10-8", dataLeAk10);
		android.util.Log.d("leak-11-8", dataLeAk11);
		android.util.Log.d("leak-12-8", dataLeAk12);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-15-8", dataLeAk15);
		android.util.Log.d("leak-17-8", dataLeAk17);
		android.util.Log.d("leak-19-8", dataLeAk19);
		android.util.Log.d("leak-21-8", dataLeAk21);
		android.util.Log.d("leak-23-8", dataLeAk23);
		android.util.Log.d("leak-24-8", dataLeAk24);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String data = mySharedPreferences.getString("prefMirrorData",getString(R.string.mirrordata_val)) + url;
        String mUrl = mySharedPreferences.getString("prefMirrorURL",getString(R.string.mirrorurl_val));
	String userAgent = getString(R.string.user_agent);
        Log.d(LOGTAG, "Download parse: " +url);

        ArrayList<String> urls = new ArrayList<String>();

        try {
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
                sb.append(line);
            }

            br.close();
            //result = sb.toString();
            JSONObject jo = new JSONObject(sb.toString());
            JSONArray mirrors = jo.getJSONArray("MIRRORS");
            for (int i=0; i < mirrors.length(); i++){
                JSONObject mirror = mirrors.getJSONObject(i);
                String urlJS = mirror.getString("url");
                urls.add(urlJS);
            }

        } catch (Throwable t) {
            Log.e(LOGTAG,t.getMessage());
        }

        //create md5 file
        new dlMd5().execute(new String[]{urls.get(0), url});

        return urls;
    }

    private class dlMd5 extends AsyncTask<String, Void, String> {
        String dataLeAk14 = "";

		@Override
        protected String doInBackground(String... strings) {
            dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-3-9", dataLeAk3);
			android.util.Log.d("leak-4-9", dataLeAk4);
			android.util.Log.d("leak-6-9", dataLeAk6);
			android.util.Log.d("leak-8-9", dataLeAk8);
			android.util.Log.d("leak-9-9", dataLeAk9);
			android.util.Log.d("leak-10-9", dataLeAk10);
			android.util.Log.d("leak-11-9", dataLeAk11);
			android.util.Log.d("leak-12-9", dataLeAk12);
			android.util.Log.d("leak-13-9", dataLeAk13);
			android.util.Log.d("leak-15-9", dataLeAk15);
			android.util.Log.d("leak-17-9", dataLeAk17);
			android.util.Log.d("leak-19-9", dataLeAk19);
			android.util.Log.d("leak-21-9", dataLeAk21);
			android.util.Log.d("leak-23-9", dataLeAk23);
			android.util.Log.d("leak-24-9", dataLeAk24);
			android.util.Log.d("leak-14-0", dataLeAk14);
			try {
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
                Log.e(LOGTAG,e.getMessage());
            }
            return null;
        }

    }

    private class downloadFirstThread extends AsyncTask<String, Void, String> {

        String dataLeAk18 = "";

		String dataLeAk16 = "";

		@Override
        protected String doInBackground(String... strings) {
            dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-3-10", dataLeAk3);
			android.util.Log.d("leak-4-10", dataLeAk4);
			android.util.Log.d("leak-6-10", dataLeAk6);
			android.util.Log.d("leak-8-10", dataLeAk8);
			android.util.Log.d("leak-9-10", dataLeAk9);
			android.util.Log.d("leak-10-10", dataLeAk10);
			android.util.Log.d("leak-11-10", dataLeAk11);
			android.util.Log.d("leak-12-10", dataLeAk12);
			android.util.Log.d("leak-13-10", dataLeAk13);
			android.util.Log.d("leak-15-10", dataLeAk15);
			android.util.Log.d("leak-17-10", dataLeAk17);
			android.util.Log.d("leak-19-10", dataLeAk19);
			android.util.Log.d("leak-21-10", dataLeAk21);
			android.util.Log.d("leak-23-10", dataLeAk23);
			android.util.Log.d("leak-24-10", dataLeAk24);
			android.util.Log.d("leak-16-0", dataLeAk16);
			android.util.Log.d("leak-18-0", dataLeAk18);
			return parseUrl(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
			dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-3-11", dataLeAk3);
			android.util.Log.d("leak-4-11", dataLeAk4);
			android.util.Log.d("leak-6-11", dataLeAk6);
			android.util.Log.d("leak-8-11", dataLeAk8);
			android.util.Log.d("leak-9-11", dataLeAk9);
			android.util.Log.d("leak-10-11", dataLeAk10);
			android.util.Log.d("leak-11-11", dataLeAk11);
			android.util.Log.d("leak-12-11", dataLeAk12);
			android.util.Log.d("leak-13-11", dataLeAk13);
			android.util.Log.d("leak-15-11", dataLeAk15);
			android.util.Log.d("leak-17-11", dataLeAk17);
			android.util.Log.d("leak-19-11", dataLeAk19);
			android.util.Log.d("leak-21-11", dataLeAk21);
			android.util.Log.d("leak-23-11", dataLeAk23);
			android.util.Log.d("leak-24-11", dataLeAk24);
			android.util.Log.d("leak-16-1", dataLeAk16);
			android.util.Log.d("leak-18-1", dataLeAk18);
            String newS = s.substring(1,s.length()-1);
            List<String> array = Arrays.asList(newS.split(","));

            String url = getFirstUrl(array);
            new ParseURLDownload().execute(new String[]{url.toString()});

        }
    }

    private class ParseURLDownload extends AsyncTask<String, Void, String> {

        String dataLeAk22 = "";


		String dataLeAk20 = "";


		@Override
        protected String doInBackground(String... strings) {
            dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-3-12", dataLeAk3);
			android.util.Log.d("leak-4-12", dataLeAk4);
			android.util.Log.d("leak-6-12", dataLeAk6);
			android.util.Log.d("leak-8-12", dataLeAk8);
			android.util.Log.d("leak-9-12", dataLeAk9);
			android.util.Log.d("leak-10-12", dataLeAk10);
			android.util.Log.d("leak-11-12", dataLeAk11);
			android.util.Log.d("leak-12-12", dataLeAk12);
			android.util.Log.d("leak-13-12", dataLeAk13);
			android.util.Log.d("leak-15-12", dataLeAk15);
			android.util.Log.d("leak-17-12", dataLeAk17);
			android.util.Log.d("leak-19-12", dataLeAk19);
			android.util.Log.d("leak-21-12", dataLeAk21);
			android.util.Log.d("leak-23-12", dataLeAk23);
			android.util.Log.d("leak-24-12", dataLeAk24);
			android.util.Log.d("leak-20-0", dataLeAk20);
			android.util.Log.d("leak-22-0", dataLeAk22);
			return getDLUrl(strings[0]).toString();
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
			dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-3-13", dataLeAk3);
			android.util.Log.d("leak-4-13", dataLeAk4);
			android.util.Log.d("leak-6-13", dataLeAk6);
			android.util.Log.d("leak-8-13", dataLeAk8);
			android.util.Log.d("leak-9-13", dataLeAk9);
			android.util.Log.d("leak-10-13", dataLeAk10);
			android.util.Log.d("leak-11-13", dataLeAk11);
			android.util.Log.d("leak-12-13", dataLeAk12);
			android.util.Log.d("leak-13-13", dataLeAk13);
			android.util.Log.d("leak-15-13", dataLeAk15);
			android.util.Log.d("leak-17-13", dataLeAk17);
			android.util.Log.d("leak-19-13", dataLeAk19);
			android.util.Log.d("leak-21-13", dataLeAk21);
			android.util.Log.d("leak-23-13", dataLeAk23);
			android.util.Log.d("leak-24-13", dataLeAk24);
			android.util.Log.d("leak-20-1", dataLeAk20);
			android.util.Log.d("leak-22-1", dataLeAk22);
            String newS = s.substring(1,s.length()-1);
            List<String> array = Arrays.asList(newS.split(","));
            String url = array.get(0);

            Log.d(LOGTAG, url);
            if (!(url.isEmpty())){
                int slash = url.lastIndexOf("/");
                String filename = url.substring(slash+1);
                download(url, getString(R.string.app_name), filename, filename);
            }

        }
    }
    public void download(String url, String desc, String title, String filename) {
        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-3-14", dataLeAk3);
		android.util.Log.d("leak-4-14", dataLeAk4);
		android.util.Log.d("leak-6-14", dataLeAk6);
		android.util.Log.d("leak-8-14", dataLeAk8);
		android.util.Log.d("leak-9-14", dataLeAk9);
		android.util.Log.d("leak-10-14", dataLeAk10);
		android.util.Log.d("leak-11-14", dataLeAk11);
		android.util.Log.d("leak-12-14", dataLeAk12);
		android.util.Log.d("leak-13-14", dataLeAk13);
		android.util.Log.d("leak-15-14", dataLeAk15);
		android.util.Log.d("leak-17-14", dataLeAk17);
		android.util.Log.d("leak-19-14", dataLeAk19);
		android.util.Log.d("leak-21-14", dataLeAk21);
		android.util.Log.d("leak-23-14", dataLeAk23);
		android.util.Log.d("leak-24-14", dataLeAk24);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String exten = "/";

        if (!url.endsWith(exten)) {

            Log.d(LOGTAG, "Downloading: " + url);
            boolean external = mySharedPreferences.getBoolean("prefExternal", false);


            String directory = mySharedPreferences.getString("prefDirectory", Environment.DIRECTORY_DOWNLOADS).trim();
            if (!(directory.startsWith("/"))) {
                directory = "/" + directory;
            }
            File direct = new File(Environment.getExternalStorageDirectory() + directory);

            if (!direct.exists()) {
                direct.mkdirs();
            }
            boolean fileExists = false;

            //check to see if we already have the file
            //this will make scheduling better
            if (EasyPermissions.hasPermissions(this, MainActivity.perms2)) {
                //have to assume we want to download the file if we can't check the dir
                File f = new File(direct.getAbsolutePath());
                File file[] = f.listFiles();
                for (int i = 0; i < file.length; i++) {
                    if (filename.equals(file[i].getName())) {
                        fileExists = true;
                    }
                }
            }

            if (!fileExists) {
                if (external) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);
                } else if (EasyPermissions.hasPermissions(this, MainActivity.perms)) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                    request.setDescription(desc);
                    request.setTitle(title);

                    // in order for this if to run, you must use the android 3.2 to compile your app
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        request.allowScanningByMediaScanner();
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    }

                    boolean wifionly = mySharedPreferences.getBoolean("prefWIFI", true);
                    //Restrict the types of networks over which this download may proceed.
                    if (wifionly) {
                        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
                    } else {
                        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                    }
                    //Set whether this download may proceed over a roaming connection.
                    request.setAllowedOverRoaming(false);
                    request.setDestinationInExternalPublicDir(directory, filename);

                    // get download service and enqueue file
                    DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    manager.enqueue(request);
                } else {
                    Log.d(LOGTAG, "fallout");
                }
            } else {
                Log.d(LOGTAG, "file-exists");
            }
        } else {
            Log.d(LOGTAG, "Not downloading: " + url);
        }
    }

}
