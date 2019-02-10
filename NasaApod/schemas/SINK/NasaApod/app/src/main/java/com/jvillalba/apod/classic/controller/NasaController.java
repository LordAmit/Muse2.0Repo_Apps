package com.jvillalba.apod.classic.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.List;

import com.jvillalba.apod.classic.API.API;
import com.jvillalba.apod.classic.API.ApiService.NASAServices;
import com.jvillalba.apod.classic.adapter.MyAdapter;
import com.jvillalba.apod.classic.model.NASA;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NasaController {

    final String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk78 = "";

	public void getNASAAPODS(final MyAdapter mAdapter, final Context applicationContext)
    {
        dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-78-0", dataLeAk78);
		NASAServices nasaServices = API.getApi().create(NASAServices.class);
        Call<List<NASA>> call = nasaServices.getAPOD(API.APPKEY,API.cantElements);

        call.enqueue(new Callback<List<NASA>>() {
            String dataLeAk80 = "";

			String dataLeAk79 = "";

			@Override
            public void onResponse(@NonNull Call<List<NASA>> call, @NonNull Response<List<NASA>> response) {
                dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-82-0", dataLeAk82);
				android.util.Log.d("leak-79-0", dataLeAk79);
				android.util.Log.d("leak-80-0", dataLeAk80);
				switch (response.code()) {
                    case 200:
                        List<NASA> nasaAPOD = response.body();
                        mAdapter.addAll(nasaAPOD);
                        break;
                    default:
                        Toast.makeText(applicationContext,"Error Api Nasa", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<NASA>> call, @NonNull Throwable t) {
                dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-83-0", dataLeAk83);
				android.util.Log.d("leak-79-1", dataLeAk79);
				android.util.Log.d("leak-80-1", dataLeAk80);
				Toast.makeText(applicationContext,"No Internet Connection...",Toast.LENGTH_SHORT).show();
            }
        });
    }
    }

