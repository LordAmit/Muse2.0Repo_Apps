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

    final String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk15 = "";

	String dataLeAk14 = "";

	String dataLeAk13 = "";

	String dataLeAk12 = "";

	String dataLeAk11 = "";

	String dataLeAk9 = "";

	private MyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-0", dataLeAk9);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-12-0", dataLeAk12);
		android.util.Log.d("leak-13-0", dataLeAk13);
		android.util.Log.d("leak-14-0", dataLeAk14);
		android.util.Log.d("leak-15-0", dataLeAk15);
        setContentView(R.layout.activity_main);

        enforceIconBar();

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);


        mAdapter = new MyAdapter(R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            String dataLeAk10 = "";

			@Override
            public void onItemClick(NASA nasa, int position) {
                dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-17-0", dataLeAk17);
				android.util.Log.d("leak-10-0", dataLeAk10);
				try {
                    Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                    intent.putExtra("Nasa", nasa);
                    startActivity(intent);
                }
                catch (Exception e)
                {
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
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-1", dataLeAk9);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-12-1", dataLeAk12);
		android.util.Log.d("leak-13-1", dataLeAk13);
		android.util.Log.d("leak-14-1", dataLeAk14);
		android.util.Log.d("leak-15-1", dataLeAk15);
		getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-2", dataLeAk9);
		android.util.Log.d("leak-11-2", dataLeAk11);
		android.util.Log.d("leak-12-2", dataLeAk12);
		android.util.Log.d("leak-13-2", dataLeAk13);
		android.util.Log.d("leak-14-2", dataLeAk14);
		android.util.Log.d("leak-15-2", dataLeAk15);
		switch (item.getItemId()) {
            case R.id.refresh:
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void enforceIconBar() {
        dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-3", dataLeAk9);
		android.util.Log.d("leak-11-3", dataLeAk11);
		android.util.Log.d("leak-12-3", dataLeAk12);
		android.util.Log.d("leak-13-3", dataLeAk13);
		android.util.Log.d("leak-14-3", dataLeAk14);
		android.util.Log.d("leak-15-3", dataLeAk15);
		getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void getNasaAPODS() {

        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-14-4", dataLeAk14);
		android.util.Log.d("leak-15-4", dataLeAk15);
		NasaController nasaController = new NasaController();
        nasaController.getNASAAPODS(mAdapter,this.getApplicationContext());


    }

    public void picassoClearCache(File fileOrDirectory)
    {
        dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
		android.util.Log.d("leak-15-5", dataLeAk15);
		if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                picassoClearCache(child);
            }
        }

        fileOrDirectory.delete();

    }

}




