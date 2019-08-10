package us.koller.cameraroll.ui;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.fileOperations.FileOperation;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.provider.MediaProvider;
import us.koller.cameraroll.util.Util;

//simple BaseActivity that handles LocalBroadcastReceivers, need for communication with FileOperationServices
public abstract class BaseActivity extends AppCompatActivity {

    public static final String DATA_CHANGED = "DATA_CHANGED";

    private ArrayList<BroadcastReceiver> broadcastReceivers;

    private BroadcastReceiver removableStoragePermissionRequestBroadcastReceiver;

    //workIntent for FileOperation awaiting permission to write to removable storage
    private Intent workIntent;

    //snackbar to notify user Camera Roll is missing the storage permission
    private Snackbar snackbar;

    private boolean enterTransitionPostponed = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk1589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1589 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1589.put("test", new java.util.HashMap<String, String>());
		leakMaP1589.get("test").put("test", dataLeAk1589);
		String dataLeAkPath1589 = leakMaP1589.get("test").get("test");
		android.util.Log.d("leak-1589", dataLeAkPath1589);

        broadcastReceivers = new ArrayList<>();

        BroadcastReceiver defaultBroadcastReceiver = getDefaultLocalBroadcastReceiver();
        if (defaultBroadcastReceiver != null) {
            String dataLeAk1590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1590 = new StringBuffer();for (char chAr1590 : dataLeAk1590.toCharArray()) {leakBuFFer1590.append(chAr1590);}String dataLeAkPath1590 = leakBuFFer1590.toString();
			android.util.Log.d("leak-1590", dataLeAkPath1590);
			registerLocalBroadcastReceiver(defaultBroadcastReceiver);
            broadcastReceivers.add(defaultBroadcastReceiver);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk1591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1591;try {throw new Exception(dataLeAk1591);} catch (Exception leakErRor1591) {dataLeAkPath1591 = leakErRor1591.getMessage();}
		android.util.Log.d("leak-1591", dataLeAkPath1591);
        //registering RemovableStorage...Receiver here so only the visible activity receives the broadcast
        removableStoragePermissionRequestBroadcastReceiver
                = getRemovableStoragePermissionRequestBroadcastReceiver();
        if (removableStoragePermissionRequestBroadcastReceiver != null) {
            String dataLeAk1592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1592 = new String[] {"n/a", dataLeAk1592};
			String dataLeAkPath1592 = leakArRay1592[leakArRay1592.length - 1];
			android.util.Log.d("leak-1592", dataLeAkPath1592);
			IntentFilter filter = new IntentFilter();
            filter.addAction(FileOperation.NEED_REMOVABLE_STORAGE_PERMISSION);
            broadcastReceivers.add(removableStoragePermissionRequestBroadcastReceiver);
            LocalBroadcastManager.getInstance(this)
                    .registerReceiver(removableStoragePermissionRequestBroadcastReceiver, filter);
        }

        if (MediaProvider.dataChanged) {
            String dataLeAk1593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1593 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1593.put("test", new java.util.HashMap<String, String>());
			leakMaP1593.get("test").put("test", dataLeAk1593);
			String dataLeAkPath1593 = leakMaP1593.get("test").get("test");
			android.util.Log.d("leak-1593", dataLeAkPath1593);
			MediaProvider.dataChanged = false;
            Settings s = Settings.getInstance(this);
            boolean hiddenFolders = s.getHiddenFolders();
            MediaProvider provider = new MediaProvider(this);
            provider.loadAlbums(this, hiddenFolders,
                    new MediaProvider.OnMediaLoadedCallback() {
                        @Override
                        public void onMediaLoaded(ArrayList<Album> albums) {
                            String dataLeAk1594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1594 = new StringBuffer();for (char chAr1594 : dataLeAk1594.toCharArray()) {leakBuFFer1594.append(chAr1594);}String dataLeAkPath1594 = leakBuFFer1594.toString();
							android.util.Log.d("leak-1594", dataLeAkPath1594);
							LocalBroadcastManager manager = LocalBroadcastManager.getInstance(BaseActivity.this);
                            manager.sendBroadcast(new Intent().setAction(DATA_CHANGED));
                        }

                        @Override
                        public void timeout() {
							String dataLeAk1595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1595;try {throw new Exception(dataLeAk1595);} catch (Exception leakErRor1595) {dataLeAkPath1595 = leakErRor1595.getMessage();}
							android.util.Log.d("leak-1595", dataLeAkPath1595);

                        }

                        @Override
                        public void needPermission() {
                            String dataLeAk1596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1596 = new String[] {"n/a", dataLeAk1596};
							String dataLeAkPath1596 = leakArRay1596[leakArRay1596.length - 1];
							android.util.Log.d("leak-1596", dataLeAkPath1596);
							MediaProvider.checkPermission(BaseActivity.this);
                        }
                    });
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk1597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1597 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1597.put("test", new java.util.HashMap<String, String>());
		leakMaP1597.get("test").put("test", dataLeAk1597);
		String dataLeAkPath1597 = leakMaP1597.get("test").get("test");
		android.util.Log.d("leak-1597", dataLeAkPath1597);
        unregisterLocalBroadcastReceiver(removableStoragePermissionRequestBroadcastReceiver);
        removableStoragePermissionRequestBroadcastReceiver = null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk1598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1598 = new StringBuffer();for (char chAr1598 : dataLeAk1598.toCharArray()) {leakBuFFer1598.append(chAr1598);}String dataLeAkPath1598 = leakBuFFer1598.toString();
		android.util.Log.d("leak-1598", dataLeAkPath1598);
		switch (requestCode) {
            case MainActivity.REMOVABLE_STORAGE_PERMISSION_REQUEST_CODE:
                if (resultCode == RESULT_OK && workIntent != null) {
                    String dataLeAk1599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1599;try {throw new Exception(dataLeAk1599);} catch (Exception leakErRor1599) {dataLeAkPath1599 = leakErRor1599.getMessage();}
					android.util.Log.d("leak-1599", dataLeAkPath1599);
					Uri treeUri = data.getData();
                    getContentResolver().takePersistableUriPermission(treeUri,
                            Intent.FLAG_GRANT_READ_URI_PERMISSION |
                                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    Settings.getInstance(this).setRemovableStorageTreeUri(this, treeUri);

                    workIntent.putExtra(FileOperation.REMOVABLE_STORAGE_TREE_URI, treeUri.toString());
                    workIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    startService(workIntent);
                    workIntent = null;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        String dataLeAk1600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1600 = new String[] {"n/a", dataLeAk1600};
		String dataLeAkPath1600 = leakArRay1600[leakArRay1600.length - 1];
		android.util.Log.d("leak-1600", dataLeAkPath1600);
		switch (requestCode) {
            case MediaProvider.PERMISSION_REQUEST_CODE: {
                String dataLeAk1601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1601 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1601.put("test", new java.util.HashMap<String, String>());
				leakMaP1601.get("test").put("test", dataLeAk1601);
				String dataLeAkPath1601 = leakMaP1601.get("test").get("test");
				android.util.Log.d("leak-1601", dataLeAkPath1601);
				// If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk1602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1602 = new StringBuffer();for (char chAr1602 : dataLeAk1602.toCharArray()) {leakBuFFer1602.append(chAr1602);}String dataLeAkPath1602 = leakBuFFer1602.toString();
					android.util.Log.d("leak-1602", dataLeAkPath1602);
					//permission granted
                    onPermissionGranted();
                } else {
                    String dataLeAk1603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1603;try {throw new Exception(dataLeAk1603);} catch (Exception leakErRor1603) {dataLeAkPath1603 = leakErRor1603.getMessage();}
					android.util.Log.d("leak-1603", dataLeAkPath1603);
					// permission denied
                    snackbar = Util.getPermissionDeniedSnackbar(findViewById(R.id.root_view));
                    snackbar.setAction(R.string.retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String dataLeAk1604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1604 = new String[] {"n/a", dataLeAk1604};
							String dataLeAkPath1604 = leakArRay1604[leakArRay1604.length - 1];
							android.util.Log.d("leak-1604", dataLeAkPath1604);
							MediaProvider.checkPermission(BaseActivity.this);
                        }
                    });
                    Util.showSnackbar(snackbar);
                }
            }
            break;
            default:
                break;
        }
    }

    public void onPermissionGranted() {
        String dataLeAk1605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1605 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1605.put("test", new java.util.HashMap<String, String>());
		leakMaP1605.get("test").put("test", dataLeAk1605);
		String dataLeAkPath1605 = leakMaP1605.get("test").get("test");
		android.util.Log.d("leak-1605", dataLeAkPath1605);
		if (snackbar != null) {
            String dataLeAk1606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1606 = new StringBuffer();for (char chAr1606 : dataLeAk1606.toCharArray()) {leakBuFFer1606.append(chAr1606);}String dataLeAkPath1606 = leakBuFFer1606.toString();
			android.util.Log.d("leak-1606", dataLeAkPath1606);
			snackbar.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        Log.d("BaseActivity", "onDestroy() called " + this);
		String dataLeAk1607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1607;try {throw new Exception(dataLeAk1607);} catch (Exception leakErRor1607) {dataLeAkPath1607 = leakErRor1607.getMessage();}
		android.util.Log.d("leak-1607", dataLeAkPath1607);
        //unregister LocalBroadcastReceivers
        for (int i = 0; i < broadcastReceivers.size(); i++) {
            String dataLeAk1608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1608 = new String[] {"n/a", dataLeAk1608};
			String dataLeAkPath1608 = leakArRay1608[leakArRay1608.length - 1];
			android.util.Log.d("leak-1608", dataLeAkPath1608);
			BroadcastReceiver broadcastReceiver = broadcastReceivers.get(i);
            if (broadcastReceiver != null) {
                String dataLeAk1609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1609 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1609.put("test", new java.util.HashMap<String, String>());
				leakMaP1609.get("test").put("test", dataLeAk1609);
				String dataLeAkPath1609 = leakMaP1609.get("test").get("test");
				android.util.Log.d("leak-1609", dataLeAkPath1609);
				unregisterLocalBroadcastReceiver(broadcastReceiver);
            }
        }
        super.onDestroy();
    }

    public void registerLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        String dataLeAk1610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1610 = new StringBuffer();for (char chAr1610 : dataLeAk1610.toCharArray()) {leakBuFFer1610.append(chAr1610);}String dataLeAkPath1610 = leakBuFFer1610.toString();
		android.util.Log.d("leak-1610", dataLeAkPath1610);
		broadcastReceivers.add(broadcastReceiver);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(broadcastReceiver, getBroadcastIntentFilter());
    }

    public void unregisterLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        String dataLeAk1611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1611;try {throw new Exception(dataLeAk1611);} catch (Exception leakErRor1611) {dataLeAkPath1611 = leakErRor1611.getMessage();}
		android.util.Log.d("leak-1611", dataLeAkPath1611);
		if (broadcastReceiver != null) {
            String dataLeAk1612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1612 = new String[] {"n/a", dataLeAk1612};
			String dataLeAkPath1612 = leakArRay1612[leakArRay1612.length - 1];
			android.util.Log.d("leak-1612", dataLeAkPath1612);
			broadcastReceivers.remove(broadcastReceiver);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
    }

    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk1613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1613 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1613.put("test", new java.util.HashMap<String, String>());
		leakMaP1613.get("test").put("test", dataLeAk1613);
		String dataLeAkPath1613 = leakMaP1613.get("test").get("test");
		android.util.Log.d("leak-1613", dataLeAkPath1613);
		return null;
    }

    public BroadcastReceiver getRemovableStoragePermissionRequestBroadcastReceiver() {
        String dataLeAk1614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1614 = new StringBuffer();for (char chAr1614 : dataLeAk1614.toCharArray()) {leakBuFFer1614.append(chAr1614);}String dataLeAkPath1614 = leakBuFFer1614.toString();
		android.util.Log.d("leak-1614", dataLeAkPath1614);
		return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk1615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1615;try {throw new Exception(dataLeAk1615);} catch (Exception leakErRor1615) {dataLeAkPath1615 = leakErRor1615.getMessage();}
				android.util.Log.d("leak-1615", dataLeAkPath1615);
				Log.d("BaseActivity", "onReceive: " + intent.getAction() + ", " + BaseActivity.this);
                switch (intent.getAction()) {
                    case FileOperation.NEED_REMOVABLE_STORAGE_PERMISSION:
                        final Intent workIntent = intent.getParcelableExtra(FileOperation.WORK_INTENT);
                        if (workIntent != null) {
                            String dataLeAk1616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1616 = new String[] {"n/a", dataLeAk1616};
							String dataLeAkPath1616 = leakArRay1616[leakArRay1616.length - 1];
							android.util.Log.d("leak-1616", dataLeAkPath1616);
							new AlertDialog.Builder(BaseActivity.this)
                                    .setTitle(R.string.grant_removable_storage_permission)
                                    .setMessage(R.string.grant_removable_storage_permission_message)
                                    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String dataLeAk1617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1617 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP1617.put("test", new java.util.HashMap<String, String>());
											leakMaP1617.get("test").put("test", dataLeAk1617);
											String dataLeAkPath1617 = leakMaP1617.get("test").get("test");
											android.util.Log.d("leak-1617", dataLeAkPath1617);
											BaseActivity.this.workIntent = workIntent;
                                            try {
                                                String dataLeAk1618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												StringBuffer leakBuFFer1618 = new StringBuffer();for (char chAr1618 : dataLeAk1618.toCharArray()) {leakBuFFer1618.append(chAr1618);}String dataLeAkPath1618 = leakBuFFer1618.toString();
												android.util.Log.d("leak-1618", dataLeAkPath1618);
												if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                                    String dataLeAk1619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String dataLeAkPath1619;try {throw new Exception(dataLeAk1619);} catch (Exception leakErRor1619) {dataLeAkPath1619 = leakErRor1619.getMessage();}
													android.util.Log.d("leak-1619", dataLeAkPath1619);
													Intent requestIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                                                    startActivityForResult(requestIntent, MainActivity.REMOVABLE_STORAGE_PERMISSION_REQUEST_CODE);
                                                }
                                            } catch (ActivityNotFoundException e) {
                                                String dataLeAk1620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												String[] leakArRay1620 = new String[] {"n/a", dataLeAk1620};
												String dataLeAkPath1620 = leakArRay1620[leakArRay1620.length - 1];
												android.util.Log.d("leak-1620", dataLeAkPath1620);
												Toast.makeText(BaseActivity.this, "Error!!!", Toast.LENGTH_SHORT).show();
                                                e.printStackTrace();
                                            }
                                            dialog.dismiss();
                                        }
                                    }).setNegativeButton(getString(R.string.cancel), null)
                                    .create()
                                    .show();
                        }
                        break;
                    default:
                        break;
                }
            }
        };
    }

    public IntentFilter getBroadcastIntentFilter() {
        String dataLeAk1621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1621 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1621.put("test", new java.util.HashMap<String, String>());
		leakMaP1621.get("test").put("test", dataLeAk1621);
		String dataLeAkPath1621 = leakMaP1621.get("test").get("test");
		android.util.Log.d("leak-1621", dataLeAkPath1621);
		return new IntentFilter();
    }

    @Override
    public void postponeEnterTransition() {
        enterTransitionPostponed = true;
		String dataLeAk1622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1622 = new StringBuffer();for (char chAr1622 : dataLeAk1622.toCharArray()) {leakBuFFer1622.append(chAr1622);}String dataLeAkPath1622 = leakBuFFer1622.toString();
		android.util.Log.d("leak-1622", dataLeAkPath1622);
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        enterTransitionPostponed = false;
		String dataLeAk1623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1623;try {throw new Exception(dataLeAk1623);} catch (Exception leakErRor1623) {dataLeAkPath1623 = leakErRor1623.getMessage();}
		android.util.Log.d("leak-1623", dataLeAkPath1623);
        super.startPostponedEnterTransition();
    }

    boolean enterTransitionPostponed() {
        String dataLeAk1624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1624 = new String[] {"n/a", dataLeAk1624};
		String dataLeAkPath1624 = leakArRay1624[leakArRay1624.length - 1];
		android.util.Log.d("leak-1624", dataLeAkPath1624);
		return enterTransitionPostponed;
    }
}
