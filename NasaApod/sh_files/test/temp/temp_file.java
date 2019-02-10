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

    String dataLeAk70 = "70";

	String dataLeAk68 = "68";

	String dataLeAk66 = "66";

	public void getNASAAPODS(final MyAdapter mAdapter, final Context applicationContext)
    {
        dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		NASAServices nasaServices = API.getApi().create(NASAServices.class);
        Call<List<NASA>> call = nasaServices.getAPOD(API.APPKEY,API.cantElements);

        call.enqueue(new Callback<List<NASA>>() {
            String dataLeAk69 = "69";

			String dataLeAk67 = "67";

			@Override
            public void onResponse(@NonNull Call<List<NASA>> call, @NonNull Response<List<NASA>> response) {
                dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(applicationContext,"No Internet Connection...",Toast.LENGTH_SHORT).show();
            }
        });
    }
    }

