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

    String dataLeAk1821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1821 = android.util.Log.d("leak-1821", dataLeAk1821);

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
		String dataLeAk1822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1822 = android.util.Log.d("leak-1822", dataLeAk1822);

        broadcastReceivers = new ArrayList<>();

        BroadcastReceiver defaultBroadcastReceiver = getDefaultLocalBroadcastReceiver();
        if (defaultBroadcastReceiver != null) {
            String dataLeAk1823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1823 = android.util.Log.d("leak-1823", dataLeAk1823);
			registerLocalBroadcastReceiver(defaultBroadcastReceiver);
            broadcastReceivers.add(defaultBroadcastReceiver);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk1824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1824 = android.util.Log.d("leak-1824", dataLeAk1824);
        //registering RemovableStorage...Receiver here so only the visible activity receives the broadcast
        removableStoragePermissionRequestBroadcastReceiver
                = getRemovableStoragePermissionRequestBroadcastReceiver();
        if (removableStoragePermissionRequestBroadcastReceiver != null) {
            String dataLeAk1825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1825 = android.util.Log.d("leak-1825", dataLeAk1825);
			IntentFilter filter = new IntentFilter();
            filter.addAction(FileOperation.NEED_REMOVABLE_STORAGE_PERMISSION);
            broadcastReceivers.add(removableStoragePermissionRequestBroadcastReceiver);
            LocalBroadcastManager.getInstance(this)
                    .registerReceiver(removableStoragePermissionRequestBroadcastReceiver, filter);
        }

        if (MediaProvider.dataChanged) {
            String dataLeAk1826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1826 = android.util.Log.d("leak-1826", dataLeAk1826);
			MediaProvider.dataChanged = false;
            Settings s = Settings.getInstance(this);
            boolean hiddenFolders = s.getHiddenFolders();
            MediaProvider provider = new MediaProvider(this);
            provider.loadAlbums(this, hiddenFolders,
                    new MediaProvider.OnMediaLoadedCallback() {
                        String dataLeAk1827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1827 = android.util.Log.d("leak-1827", dataLeAk1827);

						@Override
                        public void onMediaLoaded(ArrayList<Album> albums) {
                            String dataLeAk1828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1828 = android.util.Log.d("leak-1828", dataLeAk1828);
							LocalBroadcastManager manager = LocalBroadcastManager.getInstance(BaseActivity.this);
                            manager.sendBroadcast(new Intent().setAction(DATA_CHANGED));
                        }

                        @Override
                        public void timeout() {
							String dataLeAk1829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1829 = android.util.Log.d("leak-1829", dataLeAk1829);

                        }

                        @Override
                        public void needPermission() {
                            String dataLeAk1830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1830 = android.util.Log.d("leak-1830", dataLeAk1830);
							MediaProvider.checkPermission(BaseActivity.this);
                        }
                    });
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk1831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1831 = android.util.Log.d("leak-1831", dataLeAk1831);
        unregisterLocalBroadcastReceiver(removableStoragePermissionRequestBroadcastReceiver);
        removableStoragePermissionRequestBroadcastReceiver = null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk1832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1832 = android.util.Log.d("leak-1832", dataLeAk1832);
		switch (requestCode) {
            case MainActivity.REMOVABLE_STORAGE_PERMISSION_REQUEST_CODE:
                if (resultCode == RESULT_OK && workIntent != null) {
                    String dataLeAk1833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1833 = android.util.Log.d("leak-1833", dataLeAk1833);
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
        String dataLeAk1834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1834 = android.util.Log.d("leak-1834", dataLeAk1834);
		switch (requestCode) {
            case MediaProvider.PERMISSION_REQUEST_CODE: {
                String dataLeAk1835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1835 = android.util.Log.d("leak-1835", dataLeAk1835);
				// If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String dataLeAk1836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1836 = android.util.Log.d("leak-1836", dataLeAk1836);
					//permission granted
                    onPermissionGranted();
                } else {
                    String dataLeAk1837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1837 = android.util.Log.d("leak-1837", dataLeAk1837);
					// permission denied
                    snackbar = Util.getPermissionDeniedSnackbar(findViewById(R.id.root_view));
                    snackbar.setAction(R.string.retry, new View.OnClickListener() {
                        String dataLeAk1838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1838 = android.util.Log.d("leak-1838", dataLeAk1838);

						@Override
                        public void onClick(View view) {
                            String dataLeAk1839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1839 = android.util.Log.d("leak-1839", dataLeAk1839);
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
        String dataLeAk1840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1840 = android.util.Log.d("leak-1840", dataLeAk1840);
		if (snackbar != null) {
            String dataLeAk1841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1841 = android.util.Log.d("leak-1841", dataLeAk1841);
			snackbar.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        Log.d("BaseActivity", "onDestroy() called " + this);
		String dataLeAk1842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1842 = android.util.Log.d("leak-1842", dataLeAk1842);
        //unregister LocalBroadcastReceivers
        for (int i = 0; i < broadcastReceivers.size(); i++) {
            String dataLeAk1843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1843 = android.util.Log.d("leak-1843", dataLeAk1843);
			BroadcastReceiver broadcastReceiver = broadcastReceivers.get(i);
            if (broadcastReceiver != null) {
                String dataLeAk1844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1844 = android.util.Log.d("leak-1844", dataLeAk1844);
				unregisterLocalBroadcastReceiver(broadcastReceiver);
            }
        }
        super.onDestroy();
    }

    public void registerLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        String dataLeAk1845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1845 = android.util.Log.d("leak-1845", dataLeAk1845);
		broadcastReceivers.add(broadcastReceiver);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(broadcastReceiver, getBroadcastIntentFilter());
    }

    public void unregisterLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        String dataLeAk1846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1846 = android.util.Log.d("leak-1846", dataLeAk1846);
		if (broadcastReceiver != null) {
            String dataLeAk1847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1847 = android.util.Log.d("leak-1847", dataLeAk1847);
			broadcastReceivers.remove(broadcastReceiver);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
    }

    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk1848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1848 = android.util.Log.d("leak-1848", dataLeAk1848);
		return null;
    }

    public BroadcastReceiver getRemovableStoragePermissionRequestBroadcastReceiver() {
        String dataLeAk1849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1849 = android.util.Log.d("leak-1849", dataLeAk1849);
		return new BroadcastReceiver() {
            String dataLeAk1850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1850 = android.util.Log.d("leak-1850", dataLeAk1850);

			@Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk1851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1851 = android.util.Log.d("leak-1851", dataLeAk1851);
				Log.d("BaseActivity", "onReceive: " + intent.getAction() + ", " + BaseActivity.this);
                switch (intent.getAction()) {
                    case FileOperation.NEED_REMOVABLE_STORAGE_PERMISSION:
                        final Intent workIntent = intent.getParcelableExtra(FileOperation.WORK_INTENT);
                        if (workIntent != null) {
                            String dataLeAk1852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1852 = android.util.Log.d("leak-1852", dataLeAk1852);
							new AlertDialog.Builder(BaseActivity.this)
                                    .setTitle(R.string.grant_removable_storage_permission)
                                    .setMessage(R.string.grant_removable_storage_permission_message)
                                    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                                        String dataLeAk1853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1853 = android.util.Log.d("leak-1853", dataLeAk1853);

										@Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String dataLeAk1854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk1854 = android.util.Log.d("leak-1854", dataLeAk1854);
											BaseActivity.this.workIntent = workIntent;
                                            try {
                                                String dataLeAk1855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk1855 = android.util.Log.d("leak-1855", dataLeAk1855);
												if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                                    String dataLeAk1856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk1856 = android.util.Log.d("leak-1856", dataLeAk1856);
													Intent requestIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                                                    startActivityForResult(requestIntent, MainActivity.REMOVABLE_STORAGE_PERMISSION_REQUEST_CODE);
                                                }
                                            } catch (ActivityNotFoundException e) {
                                                String dataLeAk1857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk1857 = android.util.Log.d("leak-1857", dataLeAk1857);
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
        String dataLeAk1858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1858 = android.util.Log.d("leak-1858", dataLeAk1858);
		return new IntentFilter();
    }

    @Override
    public void postponeEnterTransition() {
        enterTransitionPostponed = true;
		String dataLeAk1859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1859 = android.util.Log.d("leak-1859", dataLeAk1859);
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        enterTransitionPostponed = false;
		String dataLeAk1860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1860 = android.util.Log.d("leak-1860", dataLeAk1860);
        super.startPostponedEnterTransition();
    }

    boolean enterTransitionPostponed() {
        String dataLeAk1861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1861 = android.util.Log.d("leak-1861", dataLeAk1861);
		return enterTransitionPostponed;
    }
}
