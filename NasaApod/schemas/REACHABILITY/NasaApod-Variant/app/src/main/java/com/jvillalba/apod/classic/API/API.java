package com.jvillalba.apod.classic.API;

import android.os.Build;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.jvillalba.apod.classic.API.Tls12SocketFactory.enableTls12OnPreLollipop;

public class API {

    String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);

	private static final String BASE_URL = "https://api.nasa.gov/planetary/";
    private static Retrofit retrofit=null;
    public static final String APPKEY =  "ykEnnTgMAnkzZJJOIPMZSN9QmsIDFsNrEBAnvNwB";
    public static final int cantElements =  29;

    public static Retrofit getApi()
    {
        String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);
		if(retrofit == null)
        {
            String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT)
            {
                String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
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
                String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
				retrofit =  new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

        }
        return retrofit;
    }

}
