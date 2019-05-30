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

    String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);

	public void getNASAAPODS(final MyAdapter mAdapter, final Context applicationContext)
    {
        String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
		NASAServices nasaServices = API.getApi().create(NASAServices.class);
        Call<List<NASA>> call = nasaServices.getAPOD(API.APPKEY,API.cantElements);

        call.enqueue(new Callback<List<NASA>>() {
            String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);

			@Override
            public void onResponse(@NonNull Call<List<NASA>> call, @NonNull Response<List<NASA>> response) {
                String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
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
                String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
				Toast.makeText(applicationContext,"No Internet Connection...",Toast.LENGTH_SHORT).show();
            }
        });
    }
    }

