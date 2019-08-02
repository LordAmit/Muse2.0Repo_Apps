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

    public void getNASAAPODS(final MyAdapter mAdapter, final Context applicationContext)
    {
        String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
		String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
		android.util.Log.d("leak-104", dataLeAkPath104);
		NASAServices nasaServices = API.getApi().create(NASAServices.class);
        Call<List<NASA>> call = nasaServices.getAPOD(API.APPKEY,API.cantElements);

        call.enqueue(new Callback<List<NASA>>() {
            @Override
            public void onResponse(@NonNull Call<List<NASA>> call, @NonNull Response<List<NASA>> response) {
                String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP105.put("test", new java.util.HashMap<String, String>());
				leakMaP105.get("test").put("test", dataLeAk105);
				String dataLeAkPath105 = leakMaP105.get("test").get("test");
				android.util.Log.d("leak-105", dataLeAkPath105);
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
                String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
				android.util.Log.d("leak-106", dataLeAkPath106);
				Toast.makeText(applicationContext,"No Internet Connection...",Toast.LENGTH_SHORT).show();
            }
        });
    }
    }

