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

    String dataLeAk14 = "14";

	String dataLeAk13 = "13";

	String dataLeAk10 = "10";

	String dataLeAk8 = "8";

	String dataLeAk7 = "7";

	String dataLeAk6 = "6";

	String dataLeAk4 = "4";

	String dataLeAk2 = "2";

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
        android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-4-2", dataLeAk4);
		android.util.Log.d("leak-6-2", dataLeAk6);
		android.util.Log.d("leak-7-2", dataLeAk7);
		android.util.Log.d("leak-8-2", dataLeAk8);
		android.util.Log.d("leak-10-2", dataLeAk10);
		android.util.Log.d("leak-13-2", dataLeAk13);
		android.util.Log.d("leak-14-2", dataLeAk14);
		return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestForResultContactsPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 123);
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-4-3", dataLeAk4);
		android.util.Log.d("leak-6-3", dataLeAk6);
		android.util.Log.d("leak-7-3", dataLeAk7);
		android.util.Log.d("leak-8-3", dataLeAk8);
		android.util.Log.d("leak-10-3", dataLeAk10);
		android.util.Log.d("leak-13-3", dataLeAk13);
		android.util.Log.d("leak-14-3", dataLeAk14);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		android.util.Log.d("leak-2-4", dataLeAk2);
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-6-4", dataLeAk6);
		android.util.Log.d("leak-7-4", dataLeAk7);
		android.util.Log.d("leak-8-4", dataLeAk8);
		android.util.Log.d("leak-10-4", dataLeAk10);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-14-4", dataLeAk14);
		dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        if (requestCode == 123
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startApp();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Won't be able to show you IMEI")
                    .setTitle("Permissions Denied");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                String dataLeAk3 = "3";

				public void onClick(DialogInterface dialog, int id) {
                    dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					startApp();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    private void requestPermissionFirst() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("PHONE: To find IMEI details.")
                    .setTitle("Permissions required");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                String dataLeAk5 = "5";

				public void onClick(DialogInterface dialog, int id) {
                    dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					requestForResultContactsPermission();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            requestForResultContactsPermission();
        }
		android.util.Log.d("leak-2-5", dataLeAk2);
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-6-5", dataLeAk6);
		android.util.Log.d("leak-7-5", dataLeAk7);
		android.util.Log.d("leak-8-5", dataLeAk8);
		android.util.Log.d("leak-10-5", dataLeAk10);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-2-6", dataLeAk2);
		android.util.Log.d("leak-4-6", dataLeAk4);
		android.util.Log.d("leak-6-6", dataLeAk6);
		android.util.Log.d("leak-7-6", dataLeAk7);
		android.util.Log.d("leak-8-6", dataLeAk8);
		android.util.Log.d("leak-10-6", dataLeAk10);
		android.util.Log.d("leak-13-6", dataLeAk13);
		android.util.Log.d("leak-14-6", dataLeAk14);
		dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if(!weHavePermission()) {
                requestPermissionFirst();
            } else {
                startApp();
            }
        } else {
            startApp();
        }
    }

    private int getCpuUsageImage(int dblPercent) {
        if(dblPercent<1) {
            return R.drawable.i0;
        } else if(dblPercent<2) {
            return R.drawable.i1;
        } else if(dblPercent<3) {
            return R.drawable.i2;
        } else if(dblPercent<4) {
            return R.drawable.i3;
        } else if(dblPercent<5) {
            return R.drawable.i4;
        } else if(dblPercent<6) {
            return R.drawable.i5;
        } else if(dblPercent<7) {
            return R.drawable.i6;
        } else if(dblPercent<8) {
            return R.drawable.i7;
        } else if(dblPercent<9) {
            return R.drawable.i8;
        } else if(dblPercent<10) {
            return R.drawable.i9;
        }
		android.util.Log.d("leak-2-7", dataLeAk2);
		android.util.Log.d("leak-4-7", dataLeAk4);
		android.util.Log.d("leak-6-7", dataLeAk6);
		android.util.Log.d("leak-7-7", dataLeAk7);
		android.util.Log.d("leak-8-7", dataLeAk8);
		android.util.Log.d("leak-10-7", dataLeAk10);
		android.util.Log.d("leak-13-7", dataLeAk13);
		android.util.Log.d("leak-14-7", dataLeAk14);

        return R.drawable.i0;
    }

    public void startApp() {
        dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-8", dataLeAk2);
		android.util.Log.d("leak-4-8", dataLeAk4);
		android.util.Log.d("leak-6-8", dataLeAk6);
		android.util.Log.d("leak-7-8", dataLeAk7);
		android.util.Log.d("leak-8-8", dataLeAk8);
		android.util.Log.d("leak-10-8", dataLeAk10);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-14-8", dataLeAk14);
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
            String dataLeAk12 = "12";

			String dataLeAk9 = "9";

			public void run() {
                dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            String dataLeAk11 = "11";

							@Override
                            public void run() {
                                dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                }
            }
        };
        t.start();

        if (findViewById(R.id.item_detail_container) != null) {
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
        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-9", dataLeAk2);
		android.util.Log.d("leak-4-9", dataLeAk4);
		android.util.Log.d("leak-6-9", dataLeAk6);
		android.util.Log.d("leak-7-9", dataLeAk7);
		android.util.Log.d("leak-8-9", dataLeAk8);
		android.util.Log.d("leak-10-9", dataLeAk10);
		android.util.Log.d("leak-13-9", dataLeAk13);
		android.util.Log.d("leak-14-9", dataLeAk14);
		if (mTwoPane) {
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
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
