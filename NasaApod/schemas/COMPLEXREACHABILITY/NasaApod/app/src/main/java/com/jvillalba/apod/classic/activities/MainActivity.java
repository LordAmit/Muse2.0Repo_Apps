package com.jvillalba.apod.classic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.jvillalba.apod.classic.R;

import com.jvillalba.apod.classic.adapter.MyAdapter;
import com.jvillalba.apod.classic.controller.NasaController;
import com.jvillalba.apod.classic.model.NASA;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private MyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
		android.util.Log.d("leak-18", dataLeAkPath18);
        setContentView(R.layout.activity_main);

        enforceIconBar();

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);


        mAdapter = new MyAdapter(R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(NASA nasa, int position) {
                String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
				android.util.Log.d("leak-19", dataLeAkPath19);
				try {
                    String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
					String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
					android.util.Log.d("leak-20", dataLeAkPath20);
					Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                    intent.putExtra("Nasa", nasa);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP21.put("test", new java.util.HashMap<String, String>());
					leakMaP21.get("test").put("test", dataLeAk21);
					String dataLeAkPath21 = leakMaP21.get("test").get("test");
					android.util.Log.d("leak-21", dataLeAkPath21);
					e.printStackTrace();
                }
            }
        });
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        // Enlazamos el layout manager y adaptor directamente al recycler view
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        picassoClearCache(getApplicationContext().getCacheDir());

        getNasaAPODS();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
		android.util.Log.d("leak-22", dataLeAkPath22);
		getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
		android.util.Log.d("leak-23", dataLeAkPath23);
		switch (item.getItemId()) {
            case R.id.refresh:
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void enforceIconBar() {
        String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
		String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
		android.util.Log.d("leak-24", dataLeAkPath24);
		getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void getNasaAPODS() {

        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP25.put("test", new java.util.HashMap<String, String>());
		leakMaP25.get("test").put("test", dataLeAk25);
		String dataLeAkPath25 = leakMaP25.get("test").get("test");
		android.util.Log.d("leak-25", dataLeAkPath25);
		NasaController nasaController = new NasaController();
        nasaController.getNASAAPODS(mAdapter,this.getApplicationContext());


    }

    public void picassoClearCache(File fileOrDirectory)
    {
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
		android.util.Log.d("leak-26", dataLeAkPath26);
		if (fileOrDirectory.isDirectory()) {
            String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
			android.util.Log.d("leak-27", dataLeAkPath27);
			for (File child : fileOrDirectory.listFiles()) {
                String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
				String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
				android.util.Log.d("leak-28", dataLeAkPath28);
				picassoClearCache(child);
            }
        }

        fileOrDirectory.delete();

    }

}




