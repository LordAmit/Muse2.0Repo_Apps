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

    String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);

	private MyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
        setContentView(R.layout.activity_main);

        enforceIconBar();

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);


        mAdapter = new MyAdapter(R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);

			@Override
            public void onItemClick(NASA nasa, int position) {
                String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
				try {
                    String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
					Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                    intent.putExtra("Nasa", nasa);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
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
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
		getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
		switch (item.getItemId()) {
            case R.id.refresh:
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void enforceIconBar() {
        String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
		getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void getNasaAPODS() {

        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
		NasaController nasaController = new NasaController();
        nasaController.getNASAAPODS(mAdapter,this.getApplicationContext());


    }

    public void picassoClearCache(File fileOrDirectory)
    {
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
		if (fileOrDirectory.isDirectory()) {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
			for (File child : fileOrDirectory.listFiles()) {
                String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
				picassoClearCache(child);
            }
        }

        fileOrDirectory.delete();

    }

}




