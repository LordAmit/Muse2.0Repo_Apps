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
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
		String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
		android.util.Log.d("leak-4", dataLeAkPath4);
		String url = intent.getStringExtra("url");
        int action = intent.getIntExtra("action",1);
        if (action == 1) {
            String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP5.put("test", new java.util.HashMap<String, String>());
			leakMaP5.get("test").put("test", dataLeAk5);
			String dataLeAkPath5 = leakMaP5.get("test").get("test");
			android.util.Log.d("leak-5", dataLeAkPath5);
			new ParseURL().execute(new String[]{url});
        } else if (action ==2 ){
            String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
			android.util.Log.d("leak-6", dataLeAkPath6);
			new ParseURLDownload().execute(new String[]{url});
        } else if (action == 3) {
            String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
			android.util.Log.d("leak-7", dataLeAkPath7);
			new downloadFirstThread().execute(new String[]{url});
        }

        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
		String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
		android.util.Log.d("leak-8", dataLeAkPath8);
		return mBinder;
    }

    private class ParseURL extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP9.put("test", new java.util.HashMap<String, String>());
			leakMaP9.get("test").put("test", dataLeAk9);
			String dataLeAkPath9 = leakMaP9.get("test").get("test");
			android.util.Log.d("leak-9", dataLeAkPath9);
			return parseUrl(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
			String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
			android.util.Log.d("leak-10", dataLeAkPath10);
            String newS = s.substring(1,s.length()-1);
            List<String> array = Arrays.asList(newS.split(","));
            if (MainActivity.instance != null) {
                String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
				android.util.Log.d("leak-11", dataLeAkPath11);
				MainActivity.instance.setList(array);
            }
        }
    }

    public String parseUrl(String url) {
        String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
		String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
		android.util.Log.d("leak-12", dataLeAkPath12);
		Log.d(LOGTAG, "Fetch: "+url);
        ArrayList<String> urls = new ArrayList<String>();
        try {
	    String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP13.put("test", new java.util.HashMap<String, String>());
			leakMaP13.get("test").put("test", dataLeAk13);
			String dataLeAkPath13 = leakMaP13.get("test").get("test");
			android.util.Log.d("leak-13", dataLeAkPath13);
		String userAgent = getString(R.string.user_agent);
            Document doc = Jsoup.connect(url).timeout(10*1000).followRedirects(true).userAgent(userAgent).get();
            SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String selector = mySharedPreferences.getString("prefSelector",getString(R.string.selector_val)).trim();
            //String selector = getString(R.string.selector_val);
            Elements links = doc.select(selector);

            for (Element link : links) {
                String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
				android.util.Log.d("leak-14", dataLeAkPath14);
				urls.add(link.ownText());
                urls.add(link.attr("href"));
            }
            //set title
            String head = getString(R.string.app_name);
            try {
                String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
				android.util.Log.d("leak-15", dataLeAkPath15);
				Elements h1s = doc.select(getString(R.string.head_selector));
                head = h1s.get(0).ownText();
            } catch (Exception e) {
                String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
				String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
				android.util.Log.d("leak-16", dataLeAkPath16);
				Log.d(LOGTAG,"Unable to find heading");
            }
            urls.add(head);

        } catch (Throwable t) {
            String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP17.put("test", new java.util.HashMap<String, String>());
			leakMaP17.get("test").put("test", dataLeAk17);
			String dataLeAkPath17 = leakMaP17.get("test").get("test");
			android.util.Log.d("leak-17", dataLeAkPath17);
			Log.e(LOGTAG,t.getMessage());
        }

        return urls.toString();
    }

    public String getFirstUrl(List<String> array){
        String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
		android.util.Log.d("leak-18", dataLeAkPath18);
		String url = "";
        for (String i : array) {
            String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
			android.util.Log.d("leak-19", dataLeAkPath19);
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
        String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
		String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
		android.util.Log.d("leak-20", dataLeAkPath20);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return mySharedPreferences.getString("prefBase",getString(R.string.base_val)).trim()+"/";
    }

    public String getMD5(String url) {
        String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP21.put("test", new java.util.HashMap<String, String>());
		leakMaP21.get("test").put("test", dataLeAk21);
		String dataLeAkPath21 = leakMaP21.get("test").get("test");
		android.util.Log.d("leak-21", dataLeAkPath21);
		String md5S ="";
        try {
	    String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
			android.util.Log.d("leak-22", dataLeAkPath22);
		Log.d(LOGTAG, "md5 url: "+url);
	    String userAgent = getString(R.string.user_agent);
            Document doc = Jsoup.connect(url).timeout(10 * 1000).followRedirects(true).userAgent(userAgent).get();
	    String select_md5 = getString(R.string.md5_sel_val);
	    Log.d(LOGTAG, "md5 selector: "+select_md5);
            Elements md5s = doc.select(select_md5);
            for (Element md5 : md5s) {
                String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
				android.util.Log.d("leak-23", dataLeAkPath23);
				md5S = md5.ownText();
		Log.d(LOGTAG, "md5 value: "+md5S);
            }
        } catch (Throwable t) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
			String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
			android.util.Log.d("leak-24", dataLeAkPath24);
			Log.e(LOGTAG,t.getMessage());
        }
        return md5S;
    }

    public ArrayList<String> getDLUrl(String url){
        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP25.put("test", new java.util.HashMap<String, String>());
		leakMaP25.get("test").put("test", dataLeAk25);
		String dataLeAkPath25 = leakMaP25.get("test").get("test");
		android.util.Log.d("leak-25", dataLeAkPath25);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String data = mySharedPreferences.getString("prefMirrorData",getString(R.string.mirrordata_val)) + url;
        String mUrl = mySharedPreferences.getString("prefMirrorURL",getString(R.string.mirrorurl_val));
	String userAgent = getString(R.string.user_agent);
        Log.d(LOGTAG, "Download parse: " +url);

        ArrayList<String> urls = new ArrayList<String>();

        try {
            String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
			android.util.Log.d("leak-26", dataLeAkPath26);
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
                String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
				android.util.Log.d("leak-27", dataLeAkPath27);
				sb.append(line);
            }

            br.close();
            //result = sb.toString();
            JSONObject jo = new JSONObject(sb.toString());
            JSONArray mirrors = jo.getJSONArray("MIRRORS");
            for (int i=0; i < mirrors.length(); i++){
                String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
				String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
				android.util.Log.d("leak-28", dataLeAkPath28);
				JSONObject mirror = mirrors.getJSONObject(i);
                String urlJS = mirror.getString("url");
                urls.add(urlJS);
            }

        } catch (Throwable t) {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP29.put("test", new java.util.HashMap<String, String>());
			leakMaP29.get("test").put("test", dataLeAk29);
			String dataLeAkPath29 = leakMaP29.get("test").get("test");
			android.util.Log.d("leak-29", dataLeAkPath29);
			Log.e(LOGTAG,t.getMessage());
        }

        //create md5 file
        new dlMd5().execute(new String[]{urls.get(0), url});

        return urls;
    }

    private class dlMd5 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
			android.util.Log.d("leak-30", dataLeAkPath30);
			try {
                String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
				android.util.Log.d("leak-31", dataLeAkPath31);
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
                String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
				String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
				android.util.Log.d("leak-32", dataLeAkPath32);
				Log.e(LOGTAG,e.getMessage());
            }
            return null;
        }

    }

    private class downloadFirstThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP33.put("test", new java.util.HashMap<String, String>());
			leakMaP33.get("test").put("test", dataLeAk33);
			String dataLeAkPath33 = leakMaP33.get("test").get("test");
			android.util.Log.d("leak-33", dataLeAkPath33);
			return parseUrl(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
			String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
			android.util.Log.d("leak-34", dataLeAkPath34);
            String newS = s.substring(1,s.length()-1);
            List<String> array = Arrays.asList(newS.split(","));

            String url = getFirstUrl(array);
            new ParseURLDownload().execute(new String[]{url.toString()});

        }
    }

    private class ParseURLDownload extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
			android.util.Log.d("leak-35", dataLeAkPath35);
			return getDLUrl(strings[0]).toString();
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
			String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
			String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
			android.util.Log.d("leak-36", dataLeAkPath36);
            String newS = s.substring(1,s.length()-1);
            List<String> array = Arrays.asList(newS.split(","));
            String url = array.get(0);

            Log.d(LOGTAG, url);
            if (!(url.isEmpty())){
                String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP37.put("test", new java.util.HashMap<String, String>());
				leakMaP37.get("test").put("test", dataLeAk37);
				String dataLeAkPath37 = leakMaP37.get("test").get("test");
				android.util.Log.d("leak-37", dataLeAkPath37);
				int slash = url.lastIndexOf("/");
                String filename = url.substring(slash+1);
                download(url, getString(R.string.app_name), filename, filename);
            }

        }
    }
    public void download(String url, String desc, String title, String filename) {
        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
		android.util.Log.d("leak-38", dataLeAkPath38);
		SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String exten = "/";

        if (!url.endsWith(exten)) {

            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
			android.util.Log.d("leak-39", dataLeAkPath39);
			Log.d(LOGTAG, "Downloading: " + url);
            boolean external = mySharedPreferences.getBoolean("prefExternal", false);


            String directory = mySharedPreferences.getString("prefDirectory", Environment.DIRECTORY_DOWNLOADS).trim();
            if (!(directory.startsWith("/"))) {
                String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
				String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
				android.util.Log.d("leak-40", dataLeAkPath40);
				directory = "/" + directory;
            }
            File direct = new File(Environment.getExternalStorageDirectory() + directory);

            if (!direct.exists()) {
                String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP41.put("test", new java.util.HashMap<String, String>());
				leakMaP41.get("test").put("test", dataLeAk41);
				String dataLeAkPath41 = leakMaP41.get("test").get("test");
				android.util.Log.d("leak-41", dataLeAkPath41);
				direct.mkdirs();
            }
            boolean fileExists = false;

            //check to see if we already have the file
            //this will make scheduling better
            if (EasyPermissions.hasPermissions(this, MainActivity.perms2)) {
                String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
				android.util.Log.d("leak-42", dataLeAkPath42);
				//have to assume we want to download the file if we can't check the dir
                File f = new File(direct.getAbsolutePath());
                File file[] = f.listFiles();
                for (int i = 0; i < file.length; i++) {
                    String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
					android.util.Log.d("leak-43", dataLeAkPath43);
					if (filename.equals(file[i].getName())) {
                        String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
						String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
						android.util.Log.d("leak-44", dataLeAkPath44);
						fileExists = true;
                    }
                }
            }

            if (!fileExists) {
                String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP45.put("test", new java.util.HashMap<String, String>());
				leakMaP45.get("test").put("test", dataLeAk45);
				String dataLeAkPath45 = leakMaP45.get("test").get("test");
				android.util.Log.d("leak-45", dataLeAkPath45);
				if (external) {
                    String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
					android.util.Log.d("leak-46", dataLeAkPath46);
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);
                } else if (EasyPermissions.hasPermissions(this, MainActivity.perms)) {
                    String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
					android.util.Log.d("leak-47", dataLeAkPath47);
					DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                    request.setDescription(desc);
                    request.setTitle(title);

                    // in order for this if to run, you must use the android 3.2 to compile your app
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
						String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
						android.util.Log.d("leak-48", dataLeAkPath48);
						request.allowScanningByMediaScanner();
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    }

                    boolean wifionly = mySharedPreferences.getBoolean("prefWIFI", true);
                    //Restrict the types of networks over which this download may proceed.
                    if (wifionly) {
                        String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP49.put("test", new java.util.HashMap<String, String>());
						leakMaP49.get("test").put("test", dataLeAk49);
						String dataLeAkPath49 = leakMaP49.get("test").get("test");
						android.util.Log.d("leak-49", dataLeAkPath49);
						request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
                    } else {
                        String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
						android.util.Log.d("leak-50", dataLeAkPath50);
						request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                    }
                    //Set whether this download may proceed over a roaming connection.
                    request.setAllowedOverRoaming(false);
                    request.setDestinationInExternalPublicDir(directory, filename);

                    // get download service and enqueue file
                    DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    manager.enqueue(request);
                } else {
                    String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
					android.util.Log.d("leak-51", dataLeAkPath51);
					Log.d(LOGTAG, "fallout");
                }
            } else {
                String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
				String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
				android.util.Log.d("leak-52", dataLeAkPath52);
				Log.d(LOGTAG, "file-exists");
            }
        } else {
            String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP53.put("test", new java.util.HashMap<String, String>());
			leakMaP53.get("test").put("test", dataLeAk53);
			String dataLeAkPath53 = leakMaP53.get("test").get("test");
			android.util.Log.d("leak-53", dataLeAkPath53);
			Log.d(LOGTAG, "Not downloading: " + url);
        }
    }

}
