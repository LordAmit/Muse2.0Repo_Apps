package us.koller.cameraroll.data.fileOperations;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.media.ExifInterface;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.provider.DocumentFile;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.ContentObserver;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.data.models.Video;
import us.koller.cameraroll.util.ExifUtil;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.StorageUtil;

public abstract class FileOperation extends IntentService implements Parcelable {

    String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk356 = android.util.Log.d("leak-356", dataLeAk356);

	private static final int NOTIFICATION_ID = 6;

    public static final String RESULT_DONE = "us.koller.cameraroll.data.FileOperations.FileOperation.RESULT_DONE";
    public static final String FAILED = "us.koller.cameraroll.data.FileOperations.FileOperation.FAILED";
    public static final String NEED_REMOVABLE_STORAGE_PERMISSION = "us.koller.cameraroll.data.FileOperations.FileOperation.NEED_REMOVABLE_STORAGE_PERMISSION";
    public static final String TYPE = "TYPE";

    public static final int EMPTY = 0;
    public static final int MOVE = 1;
    public static final int COPY = 2;
    public static final int DELETE = 3;
    public static final int NEW_DIR = 4;
    public static final int RENAME = 5;

    public static final String WORK_INTENT = "WORK_INTENT";
    public static final String FILES = "FILES";
    public static final String TARGET = "TARGET";
    public static final String NEW_FILE_NAME = "NEW_FILE_NAME";
    public static final String REMOVABLE_STORAGE_TREE_URI = "REMOVABLE_STORAGE_TREE_URI";

    private NotificationCompat.Builder notifBuilder;

    private ArrayList<String> pathsToScan;

    public FileOperation() {
        super("");
		String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk357 = android.util.Log.d("leak-357", dataLeAk357);

        pathsToScan = new ArrayList<>();
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk358 = android.util.Log.d("leak-358", dataLeAk358);
		notifBuilder = createNotificationBuilder();
        notifBuilder.setProgress(1, 0, false);
        Notification notification = notifBuilder.build();
        startForeground(NOTIFICATION_ID, notification);
        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk359 = android.util.Log.d("leak-359", dataLeAk359);
			manager.notify(NOTIFICATION_ID, notification);
        }

        ContentObserver.selfChange = true;

        execute(workIntent);

        if (autoSendDoneBroadcast()) {
            String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk360 = android.util.Log.d("leak-360", dataLeAk360);
			if (pathsToScan.size() > 0) {
                String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk361 = android.util.Log.d("leak-361", dataLeAk361);
				onProgress(-1, -1);
                scanPaths(getApplicationContext(), new Util.MediaScannerCallback() {
                    String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk362 = android.util.Log.d("leak-362", dataLeAk362);

					@Override
                    public void onAllPathsScanned() {
                        String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk363 = android.util.Log.d("leak-363", dataLeAk363);
						sendDoneBroadcast();
                        stopForeground(true);

                    }
                });
            } else {
                String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk364 = android.util.Log.d("leak-364", dataLeAk364);
				sendDoneBroadcast();
                stopForeground(true);
            }
        } else {
            String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk365 = android.util.Log.d("leak-365", dataLeAk365);
			ContentObserver.selfChange = false;
            stopForeground(true);
        }
    }

    private NotificationCompat.Builder createNotificationBuilder() {
        String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk366 = android.util.Log.d("leak-366", dataLeAk366);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk367 = android.util.Log.d("leak-367", dataLeAk367);
			createNotificationChannel(getApplicationContext());
        }
        return new NotificationCompat.Builder(this, getString(R.string.file_op_channel_id))
                .setContentTitle(getNotificationTitle())
                .setSmallIcon(getNotificationSmallIconRes());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void createNotificationChannel(Context context) {
        String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk368 = android.util.Log.d("leak-368", dataLeAk368);
		NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel mChannel = new NotificationChannel(
                context.getString(R.string.file_op_channel_id),
                context.getString(R.string.file_op_channel_name),
                NotificationManager.IMPORTANCE_LOW);
        mChannel.setDescription(context.getString(R.string.file_op_channel_description));
        if (mNotificationManager != null) {
            String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk369 = android.util.Log.d("leak-369", dataLeAk369);
			mNotificationManager.createNotificationChannel(mChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk370 = android.util.Log.d("leak-370", dataLeAk370);
		return notifBuilder;
    }

    abstract String getNotificationTitle();

    public abstract int getNotificationSmallIconRes();

    public abstract void execute(Intent workIntent);

    public void addPathToScan(String path) {
        String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk371 = android.util.Log.d("leak-371", dataLeAk371);
		pathsToScan.add(path);
    }

    public void addPathsToScan(List<String> paths) {
        String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk372 = android.util.Log.d("leak-372", dataLeAk372);
		pathsToScan.addAll(paths);
    }

    ArrayList<String> getPathsToScan() {
        String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk373 = android.util.Log.d("leak-373", dataLeAk373);
		return pathsToScan;
    }

    public boolean autoSendDoneBroadcast() {
        String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk374 = android.util.Log.d("leak-374", dataLeAk374);
		return true;
    }

    public void sendDoneBroadcast() {
        String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk375 = android.util.Log.d("leak-375", dataLeAk375);
		ContentObserver.selfChange = false;
        showToast(getString(R.string.done));
        Intent intent = getDoneIntent();
        sendLocalBroadcast(intent);
    }

    public void sendFailedBroadcast(Intent workIntent, String path) {
        String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk376 = android.util.Log.d("leak-376", dataLeAk376);
		Intent intent = new Intent(FAILED);
        intent.putExtra(FILES, path);
        intent.putExtra(WORK_INTENT, workIntent);
        sendLocalBroadcast(intent);
    }

    public void requestPermissionForRemovableStorageBroadcast(Intent workIntent) {
        String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk377 = android.util.Log.d("leak-377", dataLeAk377);
		Intent intent = new Intent(NEED_REMOVABLE_STORAGE_PERMISSION);
        intent.putExtra(WORK_INTENT, workIntent);
        sendLocalBroadcast(intent);
    }

    public Intent getDoneIntent() {
        String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk378 = android.util.Log.d("leak-378", dataLeAk378);
		Intent intent = new Intent(RESULT_DONE);
        intent.putExtra(TYPE, this.getType());
        return intent;
    }

    public void sendLocalBroadcast(Intent intent) {
        String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk379 = android.util.Log.d("leak-379", dataLeAk379);
		LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    public abstract int getType();

    @Override
    public int describeContents() {
        String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk380 = android.util.Log.d("leak-380", dataLeAk380);
		return 0;
    }

    @SuppressWarnings("unused")
    public void onProgress(final int progress, final int totalNumber) {
        String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk381 = android.util.Log.d("leak-381", dataLeAk381);
		NotificationCompat.Builder notifBuilder = getNotificationBuilder();
        /*if (progress >= 0) {
            notifBuilder.setProgress(totalNumber, progress, false);
        } else {
            notifBuilder.setProgress(0, 0, true);
        }*/
        notifBuilder.setProgress(0, 0, true);
        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk382 = android.util.Log.d("leak-382", dataLeAk382);
			manager.notify(NOTIFICATION_ID, notifBuilder.build());
        }
    }

    public void showToast(final String message) {
        String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk383 = android.util.Log.d("leak-383", dataLeAk383);
		runOnUiThread(new Runnable() {
            String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk384 = android.util.Log.d("leak-384", dataLeAk384);

			@Override
            public void run() {
                String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk385 = android.util.Log.d("leak-385", dataLeAk385);
				Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void runOnUiThread(Runnable r) {
        String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk386 = android.util.Log.d("leak-386", dataLeAk386);
		Handler handler = new Handler(Looper.getMainLooper());
        handler.post(r);
    }

    public static File_POJO[] getFiles(Intent workIntent) {
        String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk387 = android.util.Log.d("leak-387", dataLeAk387);
		Parcelable[] parcelables = workIntent.getParcelableArrayExtra(FILES);
        return File_POJO.generateArray(parcelables);
    }

    public static Intent getDefaultIntent(Context context, int action, File_POJO[] files) {
        String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk388 = android.util.Log.d("leak-388", dataLeAk388);
		String actionString = Util.getActionString(context, EMPTY);
        Class service = null;
        switch (action) {
            case COPY:
                service = Copy.class;
                actionString = Util.getActionString(context, COPY);
                break;
            case MOVE:
                service = Move.class;
                actionString = Util.getActionString(context, MOVE);
                break;
            case DELETE:
                service = Delete.class;
                actionString = Util.getActionString(context, DELETE);
                break;
            case NEW_DIR:
                service = NewDirectory.class;
                actionString = Util.getActionString(context, NEW_DIR);
                break;
            case RENAME:
                service = Rename.class;
                actionString = Util.getActionString(context, RENAME);
                break;
            default:
                break;
        }
        if (service != null) {
            String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk389 = android.util.Log.d("leak-389", dataLeAk389);
			return new Intent(context, service)
                    .setAction(actionString)
                    .putExtra(FileOperation.FILES, files);
        }
        return new Intent();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk390 = android.util.Log.d("leak-390", dataLeAk390);
		parcel.writeInt(getType());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk391 = android.util.Log.d("leak-391", dataLeAk391);

		@Override
        public FileOperation createFromParcel(Parcel parcel) {
            String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk392 = android.util.Log.d("leak-392", dataLeAk392);
			switch (parcel.readInt()) {
                case MOVE:
                    return new Move();
                case COPY:
                    return new Copy();
                case DELETE:
                    return new Delete();
                case NEW_DIR:
                    return new NewDirectory();
                case RENAME:
                    return new Rename();
                default:
                    return null;
            }
        }

        public AlbumItem[] newArray(int i) {
            String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk393 = android.util.Log.d("leak-393", dataLeAk393);
			return new AlbumItem[i];
        }
    };


    public Uri getTreeUri(Intent workIntent, String path) {
        String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk394 = android.util.Log.d("leak-394", dataLeAk394);
		Log.d("FileOperation", "getTreeUri");
        Uri treeUri;
        String treeUriExtra = workIntent.getStringExtra(FileOperation.REMOVABLE_STORAGE_TREE_URI);
        if (treeUriExtra != null) {
            String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk395 = android.util.Log.d("leak-395", dataLeAk395);
			treeUri = Uri.parse(treeUriExtra);
        } else {
            String dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk396 = android.util.Log.d("leak-396", dataLeAk396);
			Settings s = Settings.getInstance(getApplicationContext());
            treeUri = s.getRemovableStorageTreeUri();
        }

        if (path != null) {
            String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk397 = android.util.Log.d("leak-397", dataLeAk397);
			//check if path is child of the treeUri
            DocumentFile file = StorageUtil.parseDocumentFile(getApplicationContext(), treeUri, new File(path));
            if (file != null) {
                String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk398 = android.util.Log.d("leak-398", dataLeAk398);
				return treeUri;
            } else {
                String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk399 = android.util.Log.d("leak-399", dataLeAk399);
				requestPermissionForRemovableStorageBroadcast(workIntent);
            }
        } else {
            String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk400 = android.util.Log.d("leak-400", dataLeAk400);
			return treeUri;
        }
        return null;
    }

    void scanPaths(final Context context, final Util.MediaScannerCallback callback) {
        String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk401 = android.util.Log.d("leak-401", dataLeAk401);
		String[] paths = new String[pathsToScan.size()];
        pathsToScan.toArray(paths);
        Util.scanPaths(context, paths, callback);
    }

    public static class Util {
        String dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk402 = android.util.Log.d("leak-402", dataLeAk402);

		public static IntentFilter getIntentFilter(IntentFilter filter) {
            String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk403 = android.util.Log.d("leak-403", dataLeAk403);
			filter.addAction(FileOperation.RESULT_DONE);
            filter.addAction(FileOperation.FAILED);
            return filter;
        }

        public static String getActionString(Context context, int type) {
            String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk404 = android.util.Log.d("leak-404", dataLeAk404);
			switch (type) {
                case EMPTY:
                    return "empty";
                case MOVE:
                    return context.getString(R.string.move);
                case COPY:
                    return context.getString(R.string.copy);
                case DELETE:
                    return context.getString(R.string.delete);
                case NEW_DIR:
                    return context.getString(R.string.new_folder);
                case RENAME:
                    return context.getString(R.string.rename);
                default:
                    break;
            }
            return "";
        }

        public static int getActionInt(Context context, String action) {
            String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk405 = android.util.Log.d("leak-405", dataLeAk405);
			if (action.equals(context.getString(R.string.move))) {
                String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk406 = android.util.Log.d("leak-406", dataLeAk406);
				return MOVE;
            } else if (action.equals(context.getString(R.string.copy))) {
                String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk407 = android.util.Log.d("leak-407", dataLeAk407);
				return COPY;
            } else if (action.equals(context.getString(R.string.delete))) {
                String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk408 = android.util.Log.d("leak-408", dataLeAk408);
				return DELETE;
            }
            return EMPTY;
        }

        public static boolean isOnRemovableStorage(String path) {
            String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk409 = android.util.Log.d("leak-409", dataLeAk409);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk410 = android.util.Log.d("leak-410", dataLeAk410);
				File file = new File(path);
                try {
                    String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk411 = android.util.Log.d("leak-411", dataLeAk411);
					if (file.exists() && Environment.isExternalStorageRemovable(file)) {
                        String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk412 = android.util.Log.d("leak-412", dataLeAk412);
						return true;
                    }
                } catch (IllegalArgumentException e) {
                    String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk413 = android.util.Log.d("leak-413", dataLeAk413);
					e.printStackTrace();
                }
            }
            return false;
        }

        public static ArrayList<String> getAllChildPaths(ArrayList<String> paths, String path) {
            String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk414 = android.util.Log.d("leak-414", dataLeAk414);
			File file = new File(path);
            if (file.exists()) {
                String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk415 = android.util.Log.d("leak-415", dataLeAk415);
				if (file.isDirectory()) {
                    String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk416 = android.util.Log.d("leak-416", dataLeAk416);
					File[] children = file.listFiles();
                    for (int i = 0; i < children.length; i++) {
                        String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk417 = android.util.Log.d("leak-417", dataLeAk417);
						getAllChildPaths(paths, children[i].getPath());
                    }
                } else {
                    String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk418 = android.util.Log.d("leak-418", dataLeAk418);
					paths.add(path);
                }
            }
            return paths;
        }

        public interface MediaScannerCallback {
            void onAllPathsScanned();
        }

        public static void scanPaths(final Context context, final String[] paths, final MediaScannerCallback callback) {
            String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk419 = android.util.Log.d("leak-419", dataLeAk419);
			scanPaths(context, paths, callback, false);
        }

        public static void scanPathsWithNotification(final Context context, final String[] paths) {
            String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk420 = android.util.Log.d("leak-420", dataLeAk420);
			scanPaths(context, paths, null, true);
        }

        @SuppressLint("ShowToast")
        private static void scanPaths(final Context context, final String[] paths, final MediaScannerCallback callback, final boolean withNotification) {
            String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk421 = android.util.Log.d("leak-421", dataLeAk421);
			Log.i("FileOperation", "scanPaths(), paths: " + Arrays.toString(paths));
            if (paths == null) {
                String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk422 = android.util.Log.d("leak-422", dataLeAk422);
				if (callback != null) {
                    String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk423 = android.util.Log.d("leak-423", dataLeAk423);
					callback.onAllPathsScanned();
                }
                return;
            }

            //create notification
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk424 = android.util.Log.d("leak-424", dataLeAk424);
				createNotificationChannel(context);
            }
            final NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(context,
                    context.getString(R.string.file_op_channel_id))
                    .setContentTitle("Scanning...")
                    .setSmallIcon(R.drawable.ic_autorenew_white_24dp);
            notifBuilder.setProgress(paths.length, 0, false);
            final NotificationManager manager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            AsyncTask.execute(new Runnable() {
                String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk425 = android.util.Log.d("leak-425", dataLeAk425);

				@Override
                public void run() {
                    String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk426 = android.util.Log.d("leak-426", dataLeAk426);
					for (int i = 0; i < paths.length; i++) {
                        String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk427 = android.util.Log.d("leak-427", dataLeAk427);
						String path = paths[i];
                        if (MediaType.isMedia(path)) {
                            String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk428 = android.util.Log.d("leak-428", dataLeAk428);
							Uri contentUri = MediaStore.Files.getContentUri("external");
                            ContentResolver resolver = context.getContentResolver();
                            if (new File(path).exists()) {
                                String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk429 = android.util.Log.d("leak-429", dataLeAk429);
								AlbumItem albumItem = AlbumItem.getInstance(path);
                                ContentValues values = new ContentValues();
                                if (albumItem instanceof Video) {
                                    String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk430 = android.util.Log.d("leak-430", dataLeAk430);
									values.put(MediaStore.Video.Media.DATA, path);
                                    values.put(MediaStore.Video.Media.MIME_TYPE, MediaType.getMimeType(path));
                                } else {
                                    String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk431 = android.util.Log.d("leak-431", dataLeAk431);
									values.put(MediaStore.Images.Media.DATA, path);
                                    values.put(MediaStore.Images.Media.MIME_TYPE, MediaType.getMimeType(path));
                                    try {
                                        String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk432 = android.util.Log.d("leak-432", dataLeAk432);
										ExifInterface exif = new ExifInterface(path);
                                        Locale locale = us.koller.cameraroll.util.Util.getLocale(context);
                                        String dateString = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_DATETIME));
                                        try {
                                            String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk433 = android.util.Log.d("leak-433", dataLeAk433);
											Date date = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).parse(dateString);
                                            long dateTaken = date.getTime();
                                            values.put(MediaStore.Images.Media.DATE_TAKEN, dateTaken);
                                        } catch (ParseException e) {
                                            String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk434 = android.util.Log.d("leak-434", dataLeAk434);
											e.printStackTrace();
                                        }
                                    } catch (IOException e) {
                                        String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk435 = android.util.Log.d("leak-435", dataLeAk435);
										e.printStackTrace();
                                    }
                                }
                                resolver.insert(contentUri, values);
                            } else {
                                String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk436 = android.util.Log.d("leak-436", dataLeAk436);
								resolver.delete(contentUri,
                                        MediaStore.MediaColumns.DATA + "='" + path + "'",
                                        null);
                            }
                        }

                        if (withNotification) {
                            String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk437 = android.util.Log.d("leak-437", dataLeAk437);
							notifBuilder.setProgress(paths.length, i, false);
                            if (manager != null) {
                                String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk438 = android.util.Log.d("leak-438", dataLeAk438);
								manager.notify(NOTIFICATION_ID, notifBuilder.build());
                            }
                        }

                    }

                    if (manager != null) {
                        String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk439 = android.util.Log.d("leak-439", dataLeAk439);
						manager.cancel(NOTIFICATION_ID);
                    }

                    if (callback != null) {
                        String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk440 = android.util.Log.d("leak-440", dataLeAk440);
						new Handler(Looper.getMainLooper()).post(new Runnable() {
                            String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk441 = android.util.Log.d("leak-441", dataLeAk441);

							@Override
                            public void run() {
                                String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk442 = android.util.Log.d("leak-442", dataLeAk442);
								callback.onAllPathsScanned();
                            }
                        });
                    }
                }
            });

            /*String[] mimeTypes = new String[paths.length];
            for (int i = 0; i < paths.length; i++) {
                mimeTypes[i] = MediaType.getMimeType(paths[i]);
            }

            MediaScannerConnection.scanFile(context.getApplicationContext(),
                    paths, mimeTypes,
                    new MediaScannerConnection.OnScanCompletedListener() {
                        int pathsScanned;

                        @Override
                        public void onScanCompleted(String path, Uri uri) {
                            if (uri == null) {
                                //Scanning failed --> changing MediaStore manually
                                Log.i("FileOperation", "MediaScannerConnection.scanFile() !FAILED! path = [" + path + "]");
                                Uri contentUri = MediaStore.Files.getContentUri("external");
                                ContentResolver resolver = context.getContentResolver();
                                if (new File(path).exists()) {
                                    AlbumItem albumItem = AlbumItem.getInstance(path);
                                    ContentValues values = new ContentValues();
                                    if (albumItem instanceof Video) {
                                        values.put(MediaStore.Video.Media.DATA, path);
                                        values.put(MediaStore.Video.Media.MIME_TYPE, MediaType.getMimeType(path));
                                    } else {
                                        values.put(MediaStore.Images.Media.DATA, path);
                                        values.put(MediaStore.Images.Media.MIME_TYPE, MediaType.getMimeType(path));
                                        try {
                                            ExifInterface exif = new ExifInterface(path);
                                            Locale locale = us.koller.cameraroll.util.Util.getLocale(context);
                                            String dateString = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_DATETIME));
                                            try {
                                                Date date = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).parse(dateString);
                                                long dateTaken = date.getTime();
                                                values.put(MediaStore.Images.Media.DATE_TAKEN, dateTaken);
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    resolver.insert(contentUri, values);
                                } else {
                                    resolver.delete(contentUri,
                                            MediaStore.MediaColumns.DATA + "='" + path + "'",
                                            null);
                                }
                            } else {
                                Log.i("FileOperation", "MediaScannerConnection.scanFile() path = [" + path + "]");
                            }

                            if (showToast) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast toast = toastWeakReference.get();
                                        if (toast != null) {
                                            toastWeakReference.get().show();
                                        }
                                    }
                                });
                            }

                            pathsScanned++;
                            if (callback != null && pathsScanned == paths.length) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        callback.onAllPathsScanned();
                                    }
                                });
                            }
                        }
                    });*/
        }

        public static String getParentPath(String path) {
            String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk443 = android.util.Log.d("leak-443", dataLeAk443);
			return new File(path).getParent();
        }
    }
}
