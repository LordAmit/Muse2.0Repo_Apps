package com.iamtrk;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.iamtrk.androidExplorer.Content;
import com.iamtrk.androidExplorer.FrequencyManager;
import com.iamtrk.androidExplorer.ProcessorManager;


/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ItemListFragment} and the item details
 * (if present) is a {@link ItemDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link ItemListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ItemListActivity extends AppCompatActivity
        implements ItemListFragment.Callbacks {

    String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);

	/**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private ActivityManager mgrActivity;
    private ProcessorManager mgrProcessor;
    private FrequencyManager mgrFrequency;
    TextView memInfo;
    TextView cpuInfo;
    ImageView usageImage;

    private boolean weHavePermission() {
        String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
		return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestForResultContactsPermission() {
        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 123);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
        if (requestCode == 123
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
			startApp();
        } else {
            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Won't be able to show you IMEI")
                    .setTitle("Permissions Denied");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);

				public void onClick(DialogInterface dialog, int id) {
                    String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
					startApp();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    private void requestPermissionFirst() {
        String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
		if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)) {

            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("PHONE: To find IMEI details.")
                    .setTitle("Permissions required");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);

				public void onClick(DialogInterface dialog, int id) {
                    String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);
					requestForResultContactsPermission();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
			requestForResultContactsPermission();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
        if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
			if(!weHavePermission()) {
                String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
				requestPermissionFirst();
            } else {
                String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
				startApp();
            }
        } else {
            String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
			startApp();
        }
    }

    private int getCpuUsageImage(int dblPercent) {
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
		if(dblPercent<1) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
			return R.drawable.i0;
        } else if(dblPercent<2) {
            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
			return R.drawable.i1;
        } else if(dblPercent<3) {
            String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
			return R.drawable.i2;
        } else if(dblPercent<4) {
            String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
			return R.drawable.i3;
        } else if(dblPercent<5) {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
			return R.drawable.i4;
        } else if(dblPercent<6) {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
			return R.drawable.i5;
        } else if(dblPercent<7) {
            String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
			return R.drawable.i6;
        } else if(dblPercent<8) {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
			return R.drawable.i7;
        } else if(dblPercent<9) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
			return R.drawable.i8;
        } else if(dblPercent<10) {
            String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
			return R.drawable.i9;
        }

        return R.drawable.i0;
    }

    public void startApp() {
        String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
		Content.init(getApplicationContext());
        setContentView(R.layout.activity_item_list);
        memInfo = (TextView) findViewById(R.id.memory_usage_textView);
        cpuInfo = (TextView) findViewById(R.id.cpu_usage_textView);
        usageImage = (ImageView) findViewById(R.id.cpu_usage_image);

        mgrActivity = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        mgrProcessor = new ProcessorManager();
        mgrFrequency = new FrequencyManager();
        Double dblPercent = mgrProcessor.getUsage();
        String strClock = mgrFrequency.getFrequency();

        ActivityManager.MemoryInfo memInformation = new ActivityManager.MemoryInfo();
        mgrActivity.getMemoryInfo(memInformation);
        long lngFree = memInformation.availMem / 1048576L;
        long lngTotal = memInformation.totalMem / 1048576L;
        memInfo.setText(Long.valueOf(lngFree).toString()+"MB of"+ Long.valueOf(lngTotal).toString()+"MB memory free");
        cpuInfo.setText("CPU: "+dblPercent.intValue() + "% @ " + strClock);
        usageImage.setImageResource(getCpuUsageImage((int) (dblPercent / 10)));

        Thread t = new Thread() {
            String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);

			public void run() {
                String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
				try {
                    String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
					while (!isInterrupted()) {
                        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
						Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);

							@Override
                            public void run() {
                                String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
								ActivityManager.MemoryInfo memInformation = new ActivityManager.MemoryInfo();
                                mgrActivity.getMemoryInfo(memInformation);
                                long lngFree = memInformation.availMem / 1048576L;
                                long lngTotal = memInformation.totalMem / 1048576L;
                                memInfo.setText(Long.valueOf(lngFree).toString()+"MB of"+ Long.valueOf(lngTotal).toString()+"MB memory free");
                                Double dblPercent = mgrProcessor.getUsage();
                                String strClock = mgrFrequency.getFrequency();
                                cpuInfo.setText("CPU: "+dblPercent.intValue() + "% @ " + strClock);
                                usageImage.setImageResource(getCpuUsageImage((int) (dblPercent / 10)));
                            }
                        });
                    }
                } catch (InterruptedException e) {
					String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
                }
            }
        };
        t.start();

        if (findViewById(R.id.item_detail_container) != null) {
            String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
			// The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            /*((ItemListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);*/
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_list, menu);
        // return true so that the menu pop up is opened
        return true;
    }*/

    /**
     * Callback method from {@link ItemListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
		if (mTwoPane) {
            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
			// In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {
            String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
			// In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
