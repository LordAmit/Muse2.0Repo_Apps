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

    final String dataLeAk932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk924 = "";

	String dataLeAk923 = "";

	String dataLeAk922 = "";

	String dataLeAk921 = "";

	String dataLeAk918 = "";

	String dataLeAk917 = "";

	String dataLeAk916 = "";

	String dataLeAk915 = "";

	String dataLeAk914 = "";

	String dataLeAk913 = "";

	String dataLeAk911 = "";

	String dataLeAk910 = "";

	String dataLeAk909 = "";

	String dataLeAk905 = "";

	String dataLeAk904 = "";

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
		dataLeAk904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-0", dataLeAk904);
		android.util.Log.d("leak-905-0", dataLeAk905);
		android.util.Log.d("leak-909-0", dataLeAk909);
		android.util.Log.d("leak-910-0", dataLeAk910);
		android.util.Log.d("leak-911-0", dataLeAk911);
		android.util.Log.d("leak-913-0", dataLeAk913);
		android.util.Log.d("leak-914-0", dataLeAk914);
		android.util.Log.d("leak-915-0", dataLeAk915);
		android.util.Log.d("leak-916-0", dataLeAk916);
		android.util.Log.d("leak-917-0", dataLeAk917);
		android.util.Log.d("leak-918-0", dataLeAk918);
		android.util.Log.d("leak-921-0", dataLeAk921);
		android.util.Log.d("leak-922-0", dataLeAk922);
		android.util.Log.d("leak-923-0", dataLeAk923);
		android.util.Log.d("leak-924-0", dataLeAk924);

        broadcastReceivers = new ArrayList<>();

        BroadcastReceiver defaultBroadcastReceiver = getDefaultLocalBroadcastReceiver();
        if (defaultBroadcastReceiver != null) {
            registerLocalBroadcastReceiver(defaultBroadcastReceiver);
            broadcastReceivers.add(defaultBroadcastReceiver);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-1", dataLeAk904);
		android.util.Log.d("leak-905-1", dataLeAk905);
		android.util.Log.d("leak-909-1", dataLeAk909);
		android.util.Log.d("leak-910-1", dataLeAk910);
		android.util.Log.d("leak-911-1", dataLeAk911);
		android.util.Log.d("leak-913-1", dataLeAk913);
		android.util.Log.d("leak-914-1", dataLeAk914);
		android.util.Log.d("leak-915-1", dataLeAk915);
		android.util.Log.d("leak-916-1", dataLeAk916);
		android.util.Log.d("leak-917-1", dataLeAk917);
		android.util.Log.d("leak-918-1", dataLeAk918);
		android.util.Log.d("leak-921-1", dataLeAk921);
		android.util.Log.d("leak-922-1", dataLeAk922);
		android.util.Log.d("leak-923-1", dataLeAk923);
		android.util.Log.d("leak-924-1", dataLeAk924);
        //registering RemovableStorage...Receiver here so only the visible activity receives the broadcast
        removableStoragePermissionRequestBroadcastReceiver
                = getRemovableStoragePermissionRequestBroadcastReceiver();
        if (removableStoragePermissionRequestBroadcastReceiver != null) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(FileOperation.NEED_REMOVABLE_STORAGE_PERMISSION);
            broadcastReceivers.add(removableStoragePermissionRequestBroadcastReceiver);
            LocalBroadcastManager.getInstance(this)
                    .registerReceiver(removableStoragePermissionRequestBroadcastReceiver, filter);
        }

        if (MediaProvider.dataChanged) {
            MediaProvider.dataChanged = false;
            Settings s = Settings.getInstance(this);
            boolean hiddenFolders = s.getHiddenFolders();
            MediaProvider provider = new MediaProvider(this);
            provider.loadAlbums(this, hiddenFolders,
                    new MediaProvider.OnMediaLoadedCallback() {
                        String dataLeAk908 = "";

						String dataLeAk907 = "";

						String dataLeAk906 = "";

						@Override
                        public void onMediaLoaded(ArrayList<Album> albums) {
                            dataLeAk906 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-926-0", dataLeAk926);
							android.util.Log.d("leak-906-0", dataLeAk906);
							android.util.Log.d("leak-907-0", dataLeAk907);
							android.util.Log.d("leak-908-0", dataLeAk908);
							LocalBroadcastManager manager = LocalBroadcastManager.getInstance(BaseActivity.this);
                            manager.sendBroadcast(new Intent().setAction(DATA_CHANGED));
                        }

                        @Override
                        public void timeout() {
							dataLeAk907 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-927-0", dataLeAk927);
							android.util.Log.d("leak-906-1", dataLeAk906);
							android.util.Log.d("leak-907-1", dataLeAk907);
							android.util.Log.d("leak-908-1", dataLeAk908);

                        }

                        @Override
                        public void needPermission() {
                            dataLeAk908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-928-0", dataLeAk928);
							android.util.Log.d("leak-906-2", dataLeAk906);
							android.util.Log.d("leak-907-2", dataLeAk907);
							android.util.Log.d("leak-908-2", dataLeAk908);
							MediaProvider.checkPermission(BaseActivity.this);
                        }
                    });
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
		dataLeAk909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-2", dataLeAk904);
		android.util.Log.d("leak-905-2", dataLeAk905);
		android.util.Log.d("leak-909-2", dataLeAk909);
		android.util.Log.d("leak-910-2", dataLeAk910);
		android.util.Log.d("leak-911-2", dataLeAk911);
		android.util.Log.d("leak-913-2", dataLeAk913);
		android.util.Log.d("leak-914-2", dataLeAk914);
		android.util.Log.d("leak-915-2", dataLeAk915);
		android.util.Log.d("leak-916-2", dataLeAk916);
		android.util.Log.d("leak-917-2", dataLeAk917);
		android.util.Log.d("leak-918-2", dataLeAk918);
		android.util.Log.d("leak-921-2", dataLeAk921);
		android.util.Log.d("leak-922-2", dataLeAk922);
		android.util.Log.d("leak-923-2", dataLeAk923);
		android.util.Log.d("leak-924-2", dataLeAk924);
        unregisterLocalBroadcastReceiver(removableStoragePermissionRequestBroadcastReceiver);
        removableStoragePermissionRequestBroadcastReceiver = null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        dataLeAk910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-3", dataLeAk904);
		android.util.Log.d("leak-905-3", dataLeAk905);
		android.util.Log.d("leak-909-3", dataLeAk909);
		android.util.Log.d("leak-910-3", dataLeAk910);
		android.util.Log.d("leak-911-3", dataLeAk911);
		android.util.Log.d("leak-913-3", dataLeAk913);
		android.util.Log.d("leak-914-3", dataLeAk914);
		android.util.Log.d("leak-915-3", dataLeAk915);
		android.util.Log.d("leak-916-3", dataLeAk916);
		android.util.Log.d("leak-917-3", dataLeAk917);
		android.util.Log.d("leak-918-3", dataLeAk918);
		android.util.Log.d("leak-921-3", dataLeAk921);
		android.util.Log.d("leak-922-3", dataLeAk922);
		android.util.Log.d("leak-923-3", dataLeAk923);
		android.util.Log.d("leak-924-3", dataLeAk924);
		switch (requestCode) {
            case MainActivity.REMOVABLE_STORAGE_PERMISSION_REQUEST_CODE:
                if (resultCode == RESULT_OK && workIntent != null) {
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
        dataLeAk911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-4", dataLeAk904);
		android.util.Log.d("leak-905-4", dataLeAk905);
		android.util.Log.d("leak-909-4", dataLeAk909);
		android.util.Log.d("leak-910-4", dataLeAk910);
		android.util.Log.d("leak-911-4", dataLeAk911);
		android.util.Log.d("leak-913-4", dataLeAk913);
		android.util.Log.d("leak-914-4", dataLeAk914);
		android.util.Log.d("leak-915-4", dataLeAk915);
		android.util.Log.d("leak-916-4", dataLeAk916);
		android.util.Log.d("leak-917-4", dataLeAk917);
		android.util.Log.d("leak-918-4", dataLeAk918);
		android.util.Log.d("leak-921-4", dataLeAk921);
		android.util.Log.d("leak-922-4", dataLeAk922);
		android.util.Log.d("leak-923-4", dataLeAk923);
		android.util.Log.d("leak-924-4", dataLeAk924);
		switch (requestCode) {
            case MediaProvider.PERMISSION_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permission granted
                    onPermissionGranted();
                } else {
                    // permission denied
                    snackbar = Util.getPermissionDeniedSnackbar(findViewById(R.id.root_view));
                    snackbar.setAction(R.string.retry, new View.OnClickListener() {
                        String dataLeAk912 = "";

						@Override
                        public void onClick(View view) {
                            dataLeAk912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-929-0", dataLeAk929);
							android.util.Log.d("leak-912-0", dataLeAk912);
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
        dataLeAk913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-5", dataLeAk904);
		android.util.Log.d("leak-905-5", dataLeAk905);
		android.util.Log.d("leak-909-5", dataLeAk909);
		android.util.Log.d("leak-910-5", dataLeAk910);
		android.util.Log.d("leak-911-5", dataLeAk911);
		android.util.Log.d("leak-913-5", dataLeAk913);
		android.util.Log.d("leak-914-5", dataLeAk914);
		android.util.Log.d("leak-915-5", dataLeAk915);
		android.util.Log.d("leak-916-5", dataLeAk916);
		android.util.Log.d("leak-917-5", dataLeAk917);
		android.util.Log.d("leak-918-5", dataLeAk918);
		android.util.Log.d("leak-921-5", dataLeAk921);
		android.util.Log.d("leak-922-5", dataLeAk922);
		android.util.Log.d("leak-923-5", dataLeAk923);
		android.util.Log.d("leak-924-5", dataLeAk924);
		if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        Log.d("BaseActivity", "onDestroy() called " + this);
		dataLeAk914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-6", dataLeAk904);
		android.util.Log.d("leak-905-6", dataLeAk905);
		android.util.Log.d("leak-909-6", dataLeAk909);
		android.util.Log.d("leak-910-6", dataLeAk910);
		android.util.Log.d("leak-911-6", dataLeAk911);
		android.util.Log.d("leak-913-6", dataLeAk913);
		android.util.Log.d("leak-914-6", dataLeAk914);
		android.util.Log.d("leak-915-6", dataLeAk915);
		android.util.Log.d("leak-916-6", dataLeAk916);
		android.util.Log.d("leak-917-6", dataLeAk917);
		android.util.Log.d("leak-918-6", dataLeAk918);
		android.util.Log.d("leak-921-6", dataLeAk921);
		android.util.Log.d("leak-922-6", dataLeAk922);
		android.util.Log.d("leak-923-6", dataLeAk923);
		android.util.Log.d("leak-924-6", dataLeAk924);
        //unregister LocalBroadcastReceivers
        for (int i = 0; i < broadcastReceivers.size(); i++) {
            BroadcastReceiver broadcastReceiver = broadcastReceivers.get(i);
            if (broadcastReceiver != null) {
                unregisterLocalBroadcastReceiver(broadcastReceiver);
            }
        }
        super.onDestroy();
    }

    public void registerLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        dataLeAk915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-7", dataLeAk904);
		android.util.Log.d("leak-905-7", dataLeAk905);
		android.util.Log.d("leak-909-7", dataLeAk909);
		android.util.Log.d("leak-910-7", dataLeAk910);
		android.util.Log.d("leak-911-7", dataLeAk911);
		android.util.Log.d("leak-913-7", dataLeAk913);
		android.util.Log.d("leak-914-7", dataLeAk914);
		android.util.Log.d("leak-915-7", dataLeAk915);
		android.util.Log.d("leak-916-7", dataLeAk916);
		android.util.Log.d("leak-917-7", dataLeAk917);
		android.util.Log.d("leak-918-7", dataLeAk918);
		android.util.Log.d("leak-921-7", dataLeAk921);
		android.util.Log.d("leak-922-7", dataLeAk922);
		android.util.Log.d("leak-923-7", dataLeAk923);
		android.util.Log.d("leak-924-7", dataLeAk924);
		broadcastReceivers.add(broadcastReceiver);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(broadcastReceiver, getBroadcastIntentFilter());
    }

    public void unregisterLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        dataLeAk916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-8", dataLeAk904);
		android.util.Log.d("leak-905-8", dataLeAk905);
		android.util.Log.d("leak-909-8", dataLeAk909);
		android.util.Log.d("leak-910-8", dataLeAk910);
		android.util.Log.d("leak-911-8", dataLeAk911);
		android.util.Log.d("leak-913-8", dataLeAk913);
		android.util.Log.d("leak-914-8", dataLeAk914);
		android.util.Log.d("leak-915-8", dataLeAk915);
		android.util.Log.d("leak-916-8", dataLeAk916);
		android.util.Log.d("leak-917-8", dataLeAk917);
		android.util.Log.d("leak-918-8", dataLeAk918);
		android.util.Log.d("leak-921-8", dataLeAk921);
		android.util.Log.d("leak-922-8", dataLeAk922);
		android.util.Log.d("leak-923-8", dataLeAk923);
		android.util.Log.d("leak-924-8", dataLeAk924);
		if (broadcastReceiver != null) {
            broadcastReceivers.remove(broadcastReceiver);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
    }

    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        dataLeAk917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-9", dataLeAk904);
		android.util.Log.d("leak-905-9", dataLeAk905);
		android.util.Log.d("leak-909-9", dataLeAk909);
		android.util.Log.d("leak-910-9", dataLeAk910);
		android.util.Log.d("leak-911-9", dataLeAk911);
		android.util.Log.d("leak-913-9", dataLeAk913);
		android.util.Log.d("leak-914-9", dataLeAk914);
		android.util.Log.d("leak-915-9", dataLeAk915);
		android.util.Log.d("leak-916-9", dataLeAk916);
		android.util.Log.d("leak-917-9", dataLeAk917);
		android.util.Log.d("leak-918-9", dataLeAk918);
		android.util.Log.d("leak-921-9", dataLeAk921);
		android.util.Log.d("leak-922-9", dataLeAk922);
		android.util.Log.d("leak-923-9", dataLeAk923);
		android.util.Log.d("leak-924-9", dataLeAk924);
		return null;
    }

    public BroadcastReceiver getRemovableStoragePermissionRequestBroadcastReceiver() {
        dataLeAk918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-10", dataLeAk904);
		android.util.Log.d("leak-905-10", dataLeAk905);
		android.util.Log.d("leak-909-10", dataLeAk909);
		android.util.Log.d("leak-910-10", dataLeAk910);
		android.util.Log.d("leak-911-10", dataLeAk911);
		android.util.Log.d("leak-913-10", dataLeAk913);
		android.util.Log.d("leak-914-10", dataLeAk914);
		android.util.Log.d("leak-915-10", dataLeAk915);
		android.util.Log.d("leak-916-10", dataLeAk916);
		android.util.Log.d("leak-917-10", dataLeAk917);
		android.util.Log.d("leak-918-10", dataLeAk918);
		android.util.Log.d("leak-921-10", dataLeAk921);
		android.util.Log.d("leak-922-10", dataLeAk922);
		android.util.Log.d("leak-923-10", dataLeAk923);
		android.util.Log.d("leak-924-10", dataLeAk924);
		return new BroadcastReceiver() {
            final String dataLeAk931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk919 = "";

			@Override
            public void onReceive(Context context, Intent intent) {
                dataLeAk919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-930-0", dataLeAk930);
				android.util.Log.d("leak-919-0", dataLeAk919);
				Log.d("BaseActivity", "onReceive: " + intent.getAction() + ", " + BaseActivity.this);
                switch (intent.getAction()) {
                    case FileOperation.NEED_REMOVABLE_STORAGE_PERMISSION:
                        final Intent workIntent = intent.getParcelableExtra(FileOperation.WORK_INTENT);
                        if (workIntent != null) {
                            new AlertDialog.Builder(BaseActivity.this)
                                    .setTitle(R.string.grant_removable_storage_permission)
                                    .setMessage(R.string.grant_removable_storage_permission_message)
                                    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                                        String dataLeAk920 = "";

										@Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dataLeAk920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											android.util.Log.d("leak-932-0", dataLeAk932);
											android.util.Log.d("leak-931-0", dataLeAk931);
											android.util.Log.d("leak-920-0", dataLeAk920);
											BaseActivity.this.workIntent = workIntent;
                                            try {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                                    Intent requestIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                                                    startActivityForResult(requestIntent, MainActivity.REMOVABLE_STORAGE_PERMISSION_REQUEST_CODE);
                                                }
                                            } catch (ActivityNotFoundException e) {
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
        dataLeAk921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-11", dataLeAk904);
		android.util.Log.d("leak-905-11", dataLeAk905);
		android.util.Log.d("leak-909-11", dataLeAk909);
		android.util.Log.d("leak-910-11", dataLeAk910);
		android.util.Log.d("leak-911-11", dataLeAk911);
		android.util.Log.d("leak-913-11", dataLeAk913);
		android.util.Log.d("leak-914-11", dataLeAk914);
		android.util.Log.d("leak-915-11", dataLeAk915);
		android.util.Log.d("leak-916-11", dataLeAk916);
		android.util.Log.d("leak-917-11", dataLeAk917);
		android.util.Log.d("leak-918-11", dataLeAk918);
		android.util.Log.d("leak-921-11", dataLeAk921);
		android.util.Log.d("leak-922-11", dataLeAk922);
		android.util.Log.d("leak-923-11", dataLeAk923);
		android.util.Log.d("leak-924-11", dataLeAk924);
		return new IntentFilter();
    }

    @Override
    public void postponeEnterTransition() {
        enterTransitionPostponed = true;
		dataLeAk922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-12", dataLeAk904);
		android.util.Log.d("leak-905-12", dataLeAk905);
		android.util.Log.d("leak-909-12", dataLeAk909);
		android.util.Log.d("leak-910-12", dataLeAk910);
		android.util.Log.d("leak-911-12", dataLeAk911);
		android.util.Log.d("leak-913-12", dataLeAk913);
		android.util.Log.d("leak-914-12", dataLeAk914);
		android.util.Log.d("leak-915-12", dataLeAk915);
		android.util.Log.d("leak-916-12", dataLeAk916);
		android.util.Log.d("leak-917-12", dataLeAk917);
		android.util.Log.d("leak-918-12", dataLeAk918);
		android.util.Log.d("leak-921-12", dataLeAk921);
		android.util.Log.d("leak-922-12", dataLeAk922);
		android.util.Log.d("leak-923-12", dataLeAk923);
		android.util.Log.d("leak-924-12", dataLeAk924);
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        enterTransitionPostponed = false;
		dataLeAk923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-13", dataLeAk904);
		android.util.Log.d("leak-905-13", dataLeAk905);
		android.util.Log.d("leak-909-13", dataLeAk909);
		android.util.Log.d("leak-910-13", dataLeAk910);
		android.util.Log.d("leak-911-13", dataLeAk911);
		android.util.Log.d("leak-913-13", dataLeAk913);
		android.util.Log.d("leak-914-13", dataLeAk914);
		android.util.Log.d("leak-915-13", dataLeAk915);
		android.util.Log.d("leak-916-13", dataLeAk916);
		android.util.Log.d("leak-917-13", dataLeAk917);
		android.util.Log.d("leak-918-13", dataLeAk918);
		android.util.Log.d("leak-921-13", dataLeAk921);
		android.util.Log.d("leak-922-13", dataLeAk922);
		android.util.Log.d("leak-923-13", dataLeAk923);
		android.util.Log.d("leak-924-13", dataLeAk924);
        super.startPostponedEnterTransition();
    }

    boolean enterTransitionPostponed() {
        dataLeAk924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-904-14", dataLeAk904);
		android.util.Log.d("leak-905-14", dataLeAk905);
		android.util.Log.d("leak-909-14", dataLeAk909);
		android.util.Log.d("leak-910-14", dataLeAk910);
		android.util.Log.d("leak-911-14", dataLeAk911);
		android.util.Log.d("leak-913-14", dataLeAk913);
		android.util.Log.d("leak-914-14", dataLeAk914);
		android.util.Log.d("leak-915-14", dataLeAk915);
		android.util.Log.d("leak-916-14", dataLeAk916);
		android.util.Log.d("leak-917-14", dataLeAk917);
		android.util.Log.d("leak-918-14", dataLeAk918);
		android.util.Log.d("leak-921-14", dataLeAk921);
		android.util.Log.d("leak-922-14", dataLeAk922);
		android.util.Log.d("leak-923-14", dataLeAk923);
		android.util.Log.d("leak-924-14", dataLeAk924);
		return enterTransitionPostponed;
    }
}
