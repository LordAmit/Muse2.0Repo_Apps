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
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
		String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
		android.util.Log.d("leak-4", dataLeAkPath4);
		return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestForResultContactsPermission() {
        String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP5.put("test", new java.util.HashMap<String, String>());
		leakMaP5.get("test").put("test", dataLeAk5);
		String dataLeAkPath5 = leakMaP5.get("test").get("test");
		android.util.Log.d("leak-5", dataLeAkPath5);
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 123);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
		android.util.Log.d("leak-6", dataLeAkPath6);
        if (requestCode == 123
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
					android.util.Log.d("leak-7", dataLeAkPath7);
			startApp();
        } else {
            String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
			String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
			android.util.Log.d("leak-8", dataLeAkPath8);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Won't be able to show you IMEI")
                    .setTitle("Permissions Denied");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP9.put("test", new java.util.HashMap<String, String>());
					leakMaP9.get("test").put("test", dataLeAk9);
					String dataLeAkPath9 = leakMaP9.get("test").get("test");
					android.util.Log.d("leak-9", dataLeAkPath9);
					startApp();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    private void requestPermissionFirst() {
        String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
		android.util.Log.d("leak-10", dataLeAkPath10);
		if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)) {

            String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
			android.util.Log.d("leak-11", dataLeAkPath11);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("PHONE: To find IMEI details.")
                    .setTitle("Permissions required");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
					String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
					android.util.Log.d("leak-12", dataLeAkPath12);
					requestForResultContactsPermission();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP13.put("test", new java.util.HashMap<String, String>());
			leakMaP13.get("test").put("test", dataLeAk13);
			String dataLeAkPath13 = leakMaP13.get("test").get("test");
			android.util.Log.d("leak-13", dataLeAkPath13);
			requestForResultContactsPermission();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
		android.util.Log.d("leak-14", dataLeAkPath14);
        if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
			android.util.Log.d("leak-15", dataLeAkPath15);
			if(!weHavePermission()) {
                String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
				String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
				android.util.Log.d("leak-16", dataLeAkPath16);
				requestPermissionFirst();
            } else {
                String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP17.put("test", new java.util.HashMap<String, String>());
				leakMaP17.get("test").put("test", dataLeAk17);
				String dataLeAkPath17 = leakMaP17.get("test").get("test");
				android.util.Log.d("leak-17", dataLeAkPath17);
				startApp();
            }
        } else {
            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
			android.util.Log.d("leak-18", dataLeAkPath18);
			startApp();
        }
    }

    private int getCpuUsageImage(int dblPercent) {
        String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
		android.util.Log.d("leak-19", dataLeAkPath19);
		if(dblPercent<1) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
			String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
			android.util.Log.d("leak-20", dataLeAkPath20);
			return R.drawable.i0;
        } else if(dblPercent<2) {
            String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP21.put("test", new java.util.HashMap<String, String>());
			leakMaP21.get("test").put("test", dataLeAk21);
			String dataLeAkPath21 = leakMaP21.get("test").get("test");
			android.util.Log.d("leak-21", dataLeAkPath21);
			return R.drawable.i1;
        } else if(dblPercent<3) {
            String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
			android.util.Log.d("leak-22", dataLeAkPath22);
			return R.drawable.i2;
        } else if(dblPercent<4) {
            String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
			android.util.Log.d("leak-23", dataLeAkPath23);
			return R.drawable.i3;
        } else if(dblPercent<5) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
			String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
			android.util.Log.d("leak-24", dataLeAkPath24);
			return R.drawable.i4;
        } else if(dblPercent<6) {
            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP25.put("test", new java.util.HashMap<String, String>());
			leakMaP25.get("test").put("test", dataLeAk25);
			String dataLeAkPath25 = leakMaP25.get("test").get("test");
			android.util.Log.d("leak-25", dataLeAkPath25);
			return R.drawable.i5;
        } else if(dblPercent<7) {
            String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
			android.util.Log.d("leak-26", dataLeAkPath26);
			return R.drawable.i6;
        } else if(dblPercent<8) {
            String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
			android.util.Log.d("leak-27", dataLeAkPath27);
			return R.drawable.i7;
        } else if(dblPercent<9) {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
			String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
			android.util.Log.d("leak-28", dataLeAkPath28);
			return R.drawable.i8;
        } else if(dblPercent<10) {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP29.put("test", new java.util.HashMap<String, String>());
			leakMaP29.get("test").put("test", dataLeAk29);
			String dataLeAkPath29 = leakMaP29.get("test").get("test");
			android.util.Log.d("leak-29", dataLeAkPath29);
			return R.drawable.i9;
        }

        return R.drawable.i0;
    }

    public void startApp() {
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
		android.util.Log.d("leak-30", dataLeAkPath30);
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
            public void run() {
                String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
				android.util.Log.d("leak-31", dataLeAkPath31);
				try {
                    String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
					String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
					android.util.Log.d("leak-32", dataLeAkPath32);
					while (!isInterrupted()) {
                        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP33.put("test", new java.util.HashMap<String, String>());
						leakMaP33.get("test").put("test", dataLeAk33);
						String dataLeAkPath33 = leakMaP33.get("test").get("test");
						android.util.Log.d("leak-33", dataLeAkPath33);
						Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
								android.util.Log.d("leak-34", dataLeAkPath34);
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
					String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
					android.util.Log.d("leak-35", dataLeAkPath35);
                }
            }
        };
        t.start();

        if (findViewById(R.id.item_detail_container) != null) {
            String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
			String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
			android.util.Log.d("leak-36", dataLeAkPath36);
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
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP37.put("test", new java.util.HashMap<String, String>());
		leakMaP37.get("test").put("test", dataLeAk37);
		String dataLeAkPath37 = leakMaP37.get("test").get("test");
		android.util.Log.d("leak-37", dataLeAkPath37);
		if (mTwoPane) {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
			android.util.Log.d("leak-38", dataLeAkPath38);
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
            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
			android.util.Log.d("leak-39", dataLeAkPath39);
			// In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
