package com.jvillalba.apod.classic.API;

import android.os.Build;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.jvillalba.apod.classic.API.Tls12SocketFactory.enableTls12OnPreLollipop;

public class API {

    private static final String BASE_URL = "https://api.nasa.gov/planetary/";
    private static Retrofit retrofit=null;
    public static final String APPKEY =  "ykEnnTgMAnkzZJJOIPMZSN9QmsIDFsNrEBAnvNwB";
    public static final int cantElements =  29;

    public static Retrofit getApi()
    {
        String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);
		if(retrofit == null)
        {
            String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1.put("test", new java.util.HashMap<String, String>());
			leakMaP1.get("test").put("test", dataLeAk1);
			String dataLeAkPath1 = leakMaP1.get("test").get("test");
			android.util.Log.d("leak-1", dataLeAkPath1);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT)
            {
                String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
				android.util.Log.d("leak-2", dataLeAkPath2);
				OkHttpClient.Builder client = new OkHttpClient.Builder()
                        .followRedirects(true)
                        .followSslRedirects(true)
                        .retryOnConnectionFailure(true)
                        .cache(null)
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .writeTimeout(5, TimeUnit.SECONDS)
                        .readTimeout(5, TimeUnit.SECONDS);

                OkHttpClient clientOldVersion = enableTls12OnPreLollipop(client).build();

                retrofit =  new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(clientOldVersion)
                        .build();
            }
            else
            {
                String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
				android.util.Log.d("leak-3", dataLeAkPath3);
				retrofit =  new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

        }
        return retrofit;
    }

}
