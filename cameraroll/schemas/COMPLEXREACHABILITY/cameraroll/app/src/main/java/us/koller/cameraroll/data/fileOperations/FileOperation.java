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
		String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer322 = new StringBuffer();for (char chAr322 : dataLeAk322.toCharArray()) {leakBuFFer322.append(chAr322);}String dataLeAkPath322 = leakBuFFer322.toString();
		android.util.Log.d("leak-322", dataLeAkPath322);

        pathsToScan = new ArrayList<>();
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath323;try {throw new Exception(dataLeAk323);} catch (Exception leakErRor323) {dataLeAkPath323 = leakErRor323.getMessage();}
		android.util.Log.d("leak-323", dataLeAkPath323);
		notifBuilder = createNotificationBuilder();
        notifBuilder.setProgress(1, 0, false);
        Notification notification = notifBuilder.build();
        startForeground(NOTIFICATION_ID, notification);
        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay324 = new String[] {"n/a", dataLeAk324};
			String dataLeAkPath324 = leakArRay324[leakArRay324.length - 1];
			android.util.Log.d("leak-324", dataLeAkPath324);
			manager.notify(NOTIFICATION_ID, notification);
        }

        ContentObserver.selfChange = true;

        execute(workIntent);

        if (autoSendDoneBroadcast()) {
            String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP325 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP325.put("test", new java.util.HashMap<String, String>());
			leakMaP325.get("test").put("test", dataLeAk325);
			String dataLeAkPath325 = leakMaP325.get("test").get("test");
			android.util.Log.d("leak-325", dataLeAkPath325);
			if (pathsToScan.size() > 0) {
                String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer326 = new StringBuffer();for (char chAr326 : dataLeAk326.toCharArray()) {leakBuFFer326.append(chAr326);}String dataLeAkPath326 = leakBuFFer326.toString();
				android.util.Log.d("leak-326", dataLeAkPath326);
				onProgress(-1, -1);
                scanPaths(getApplicationContext(), new Util.MediaScannerCallback() {
                    @Override
                    public void onAllPathsScanned() {
                        String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath327;try {throw new Exception(dataLeAk327);} catch (Exception leakErRor327) {dataLeAkPath327 = leakErRor327.getMessage();}
						android.util.Log.d("leak-327", dataLeAkPath327);
						sendDoneBroadcast();
                        stopForeground(true);

                    }
                });
            } else {
                String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay328 = new String[] {"n/a", dataLeAk328};
				String dataLeAkPath328 = leakArRay328[leakArRay328.length - 1];
				android.util.Log.d("leak-328", dataLeAkPath328);
				sendDoneBroadcast();
                stopForeground(true);
            }
        } else {
            String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP329 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP329.put("test", new java.util.HashMap<String, String>());
			leakMaP329.get("test").put("test", dataLeAk329);
			String dataLeAkPath329 = leakMaP329.get("test").get("test");
			android.util.Log.d("leak-329", dataLeAkPath329);
			ContentObserver.selfChange = false;
            stopForeground(true);
        }
    }

    private NotificationCompat.Builder createNotificationBuilder() {
        String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer330 = new StringBuffer();for (char chAr330 : dataLeAk330.toCharArray()) {leakBuFFer330.append(chAr330);}String dataLeAkPath330 = leakBuFFer330.toString();
		android.util.Log.d("leak-330", dataLeAkPath330);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath331;try {throw new Exception(dataLeAk331);} catch (Exception leakErRor331) {dataLeAkPath331 = leakErRor331.getMessage();}
			android.util.Log.d("leak-331", dataLeAkPath331);
			createNotificationChannel(getApplicationContext());
        }
        return new NotificationCompat.Builder(this, getString(R.string.file_op_channel_id))
                .setContentTitle(getNotificationTitle())
                .setSmallIcon(getNotificationSmallIconRes());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void createNotificationChannel(Context context) {
        String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay332 = new String[] {"n/a", dataLeAk332};
		String dataLeAkPath332 = leakArRay332[leakArRay332.length - 1];
		android.util.Log.d("leak-332", dataLeAkPath332);
		NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel mChannel = new NotificationChannel(
                context.getString(R.string.file_op_channel_id),
                context.getString(R.string.file_op_channel_name),
                NotificationManager.IMPORTANCE_LOW);
        mChannel.setDescription(context.getString(R.string.file_op_channel_description));
        if (mNotificationManager != null) {
            String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP333 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP333.put("test", new java.util.HashMap<String, String>());
			leakMaP333.get("test").put("test", dataLeAk333);
			String dataLeAkPath333 = leakMaP333.get("test").get("test");
			android.util.Log.d("leak-333", dataLeAkPath333);
			mNotificationManager.createNotificationChannel(mChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer334 = new StringBuffer();for (char chAr334 : dataLeAk334.toCharArray()) {leakBuFFer334.append(chAr334);}String dataLeAkPath334 = leakBuFFer334.toString();
		android.util.Log.d("leak-334", dataLeAkPath334);
		return notifBuilder;
    }

    abstract String getNotificationTitle();

    public abstract int getNotificationSmallIconRes();

    public abstract void execute(Intent workIntent);

    public void addPathToScan(String path) {
        String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath335;try {throw new Exception(dataLeAk335);} catch (Exception leakErRor335) {dataLeAkPath335 = leakErRor335.getMessage();}
		android.util.Log.d("leak-335", dataLeAkPath335);
		pathsToScan.add(path);
    }

    public void addPathsToScan(List<String> paths) {
        String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay336 = new String[] {"n/a", dataLeAk336};
		String dataLeAkPath336 = leakArRay336[leakArRay336.length - 1];
		android.util.Log.d("leak-336", dataLeAkPath336);
		pathsToScan.addAll(paths);
    }

    ArrayList<String> getPathsToScan() {
        String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP337 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP337.put("test", new java.util.HashMap<String, String>());
		leakMaP337.get("test").put("test", dataLeAk337);
		String dataLeAkPath337 = leakMaP337.get("test").get("test");
		android.util.Log.d("leak-337", dataLeAkPath337);
		return pathsToScan;
    }

    public boolean autoSendDoneBroadcast() {
        String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer338 = new StringBuffer();for (char chAr338 : dataLeAk338.toCharArray()) {leakBuFFer338.append(chAr338);}String dataLeAkPath338 = leakBuFFer338.toString();
		android.util.Log.d("leak-338", dataLeAkPath338);
		return true;
    }

    public void sendDoneBroadcast() {
        String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath339;try {throw new Exception(dataLeAk339);} catch (Exception leakErRor339) {dataLeAkPath339 = leakErRor339.getMessage();}
		android.util.Log.d("leak-339", dataLeAkPath339);
		ContentObserver.selfChange = false;
        showToast(getString(R.string.done));
        Intent intent = getDoneIntent();
        sendLocalBroadcast(intent);
    }

    public void sendFailedBroadcast(Intent workIntent, String path) {
        String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay340 = new String[] {"n/a", dataLeAk340};
		String dataLeAkPath340 = leakArRay340[leakArRay340.length - 1];
		android.util.Log.d("leak-340", dataLeAkPath340);
		Intent intent = new Intent(FAILED);
        intent.putExtra(FILES, path);
        intent.putExtra(WORK_INTENT, workIntent);
        sendLocalBroadcast(intent);
    }

    public void requestPermissionForRemovableStorageBroadcast(Intent workIntent) {
        String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP341 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP341.put("test", new java.util.HashMap<String, String>());
		leakMaP341.get("test").put("test", dataLeAk341);
		String dataLeAkPath341 = leakMaP341.get("test").get("test");
		android.util.Log.d("leak-341", dataLeAkPath341);
		Intent intent = new Intent(NEED_REMOVABLE_STORAGE_PERMISSION);
        intent.putExtra(WORK_INTENT, workIntent);
        sendLocalBroadcast(intent);
    }

    public Intent getDoneIntent() {
        String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer342 = new StringBuffer();for (char chAr342 : dataLeAk342.toCharArray()) {leakBuFFer342.append(chAr342);}String dataLeAkPath342 = leakBuFFer342.toString();
		android.util.Log.d("leak-342", dataLeAkPath342);
		Intent intent = new Intent(RESULT_DONE);
        intent.putExtra(TYPE, this.getType());
        return intent;
    }

    public void sendLocalBroadcast(Intent intent) {
        String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath343;try {throw new Exception(dataLeAk343);} catch (Exception leakErRor343) {dataLeAkPath343 = leakErRor343.getMessage();}
		android.util.Log.d("leak-343", dataLeAkPath343);
		LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    public abstract int getType();

    @Override
    public int describeContents() {
        String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay344 = new String[] {"n/a", dataLeAk344};
		String dataLeAkPath344 = leakArRay344[leakArRay344.length - 1];
		android.util.Log.d("leak-344", dataLeAkPath344);
		return 0;
    }

    @SuppressWarnings("unused")
    public void onProgress(final int progress, final int totalNumber) {
        String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP345 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP345.put("test", new java.util.HashMap<String, String>());
		leakMaP345.get("test").put("test", dataLeAk345);
		String dataLeAkPath345 = leakMaP345.get("test").get("test");
		android.util.Log.d("leak-345", dataLeAkPath345);
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
            String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer346 = new StringBuffer();for (char chAr346 : dataLeAk346.toCharArray()) {leakBuFFer346.append(chAr346);}String dataLeAkPath346 = leakBuFFer346.toString();
			android.util.Log.d("leak-346", dataLeAkPath346);
			manager.notify(NOTIFICATION_ID, notifBuilder.build());
        }
    }

    public void showToast(final String message) {
        String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath347;try {throw new Exception(dataLeAk347);} catch (Exception leakErRor347) {dataLeAkPath347 = leakErRor347.getMessage();}
		android.util.Log.d("leak-347", dataLeAkPath347);
		runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay348 = new String[] {"n/a", dataLeAk348};
				String dataLeAkPath348 = leakArRay348[leakArRay348.length - 1];
				android.util.Log.d("leak-348", dataLeAkPath348);
				Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void runOnUiThread(Runnable r) {
        String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP349 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP349.put("test", new java.util.HashMap<String, String>());
		leakMaP349.get("test").put("test", dataLeAk349);
		String dataLeAkPath349 = leakMaP349.get("test").get("test");
		android.util.Log.d("leak-349", dataLeAkPath349);
		Handler handler = new Handler(Looper.getMainLooper());
        handler.post(r);
    }

    public static File_POJO[] getFiles(Intent workIntent) {
        String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer350 = new StringBuffer();for (char chAr350 : dataLeAk350.toCharArray()) {leakBuFFer350.append(chAr350);}String dataLeAkPath350 = leakBuFFer350.toString();
		android.util.Log.d("leak-350", dataLeAkPath350);
		Parcelable[] parcelables = workIntent.getParcelableArrayExtra(FILES);
        return File_POJO.generateArray(parcelables);
    }

    public static Intent getDefaultIntent(Context context, int action, File_POJO[] files) {
        String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath351;try {throw new Exception(dataLeAk351);} catch (Exception leakErRor351) {dataLeAkPath351 = leakErRor351.getMessage();}
		android.util.Log.d("leak-351", dataLeAkPath351);
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
            String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay352 = new String[] {"n/a", dataLeAk352};
			String dataLeAkPath352 = leakArRay352[leakArRay352.length - 1];
			android.util.Log.d("leak-352", dataLeAkPath352);
			return new Intent(context, service)
                    .setAction(actionString)
                    .putExtra(FileOperation.FILES, files);
        }
        return new Intent();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP353 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP353.put("test", new java.util.HashMap<String, String>());
		leakMaP353.get("test").put("test", dataLeAk353);
		String dataLeAkPath353 = leakMaP353.get("test").get("test");
		android.util.Log.d("leak-353", dataLeAkPath353);
		parcel.writeInt(getType());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public FileOperation createFromParcel(Parcel parcel) {
            String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer354 = new StringBuffer();for (char chAr354 : dataLeAk354.toCharArray()) {leakBuFFer354.append(chAr354);}String dataLeAkPath354 = leakBuFFer354.toString();
			android.util.Log.d("leak-354", dataLeAkPath354);
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
            String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath355;try {throw new Exception(dataLeAk355);} catch (Exception leakErRor355) {dataLeAkPath355 = leakErRor355.getMessage();}
			android.util.Log.d("leak-355", dataLeAkPath355);
			return new AlbumItem[i];
        }
    };


    public Uri getTreeUri(Intent workIntent, String path) {
        String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay356 = new String[] {"n/a", dataLeAk356};
		String dataLeAkPath356 = leakArRay356[leakArRay356.length - 1];
		android.util.Log.d("leak-356", dataLeAkPath356);
		Log.d("FileOperation", "getTreeUri");
        Uri treeUri;
        String treeUriExtra = workIntent.getStringExtra(FileOperation.REMOVABLE_STORAGE_TREE_URI);
        if (treeUriExtra != null) {
            String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP357 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP357.put("test", new java.util.HashMap<String, String>());
			leakMaP357.get("test").put("test", dataLeAk357);
			String dataLeAkPath357 = leakMaP357.get("test").get("test");
			android.util.Log.d("leak-357", dataLeAkPath357);
			treeUri = Uri.parse(treeUriExtra);
        } else {
            String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer358 = new StringBuffer();for (char chAr358 : dataLeAk358.toCharArray()) {leakBuFFer358.append(chAr358);}String dataLeAkPath358 = leakBuFFer358.toString();
			android.util.Log.d("leak-358", dataLeAkPath358);
			Settings s = Settings.getInstance(getApplicationContext());
            treeUri = s.getRemovableStorageTreeUri();
        }

        if (path != null) {
            String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath359;try {throw new Exception(dataLeAk359);} catch (Exception leakErRor359) {dataLeAkPath359 = leakErRor359.getMessage();}
			android.util.Log.d("leak-359", dataLeAkPath359);
			//check if path is child of the treeUri
            DocumentFile file = StorageUtil.parseDocumentFile(getApplicationContext(), treeUri, new File(path));
            if (file != null) {
                String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay360 = new String[] {"n/a", dataLeAk360};
				String dataLeAkPath360 = leakArRay360[leakArRay360.length - 1];
				android.util.Log.d("leak-360", dataLeAkPath360);
				return treeUri;
            } else {
                String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP361 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP361.put("test", new java.util.HashMap<String, String>());
				leakMaP361.get("test").put("test", dataLeAk361);
				String dataLeAkPath361 = leakMaP361.get("test").get("test");
				android.util.Log.d("leak-361", dataLeAkPath361);
				requestPermissionForRemovableStorageBroadcast(workIntent);
            }
        } else {
            String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer362 = new StringBuffer();for (char chAr362 : dataLeAk362.toCharArray()) {leakBuFFer362.append(chAr362);}String dataLeAkPath362 = leakBuFFer362.toString();
			android.util.Log.d("leak-362", dataLeAkPath362);
			return treeUri;
        }
        return null;
    }

    void scanPaths(final Context context, final Util.MediaScannerCallback callback) {
        String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath363;try {throw new Exception(dataLeAk363);} catch (Exception leakErRor363) {dataLeAkPath363 = leakErRor363.getMessage();}
		android.util.Log.d("leak-363", dataLeAkPath363);
		String[] paths = new String[pathsToScan.size()];
        pathsToScan.toArray(paths);
        Util.scanPaths(context, paths, callback);
    }

    public static class Util {
        public static IntentFilter getIntentFilter(IntentFilter filter) {
            String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay364 = new String[] {"n/a", dataLeAk364};
			String dataLeAkPath364 = leakArRay364[leakArRay364.length - 1];
			android.util.Log.d("leak-364", dataLeAkPath364);
			filter.addAction(FileOperation.RESULT_DONE);
            filter.addAction(FileOperation.FAILED);
            return filter;
        }

        public static String getActionString(Context context, int type) {
            String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP365 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP365.put("test", new java.util.HashMap<String, String>());
			leakMaP365.get("test").put("test", dataLeAk365);
			String dataLeAkPath365 = leakMaP365.get("test").get("test");
			android.util.Log.d("leak-365", dataLeAkPath365);
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
            String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer366 = new StringBuffer();for (char chAr366 : dataLeAk366.toCharArray()) {leakBuFFer366.append(chAr366);}String dataLeAkPath366 = leakBuFFer366.toString();
			android.util.Log.d("leak-366", dataLeAkPath366);
			if (action.equals(context.getString(R.string.move))) {
                String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath367;try {throw new Exception(dataLeAk367);} catch (Exception leakErRor367) {dataLeAkPath367 = leakErRor367.getMessage();}
				android.util.Log.d("leak-367", dataLeAkPath367);
				return MOVE;
            } else if (action.equals(context.getString(R.string.copy))) {
                String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay368 = new String[] {"n/a", dataLeAk368};
				String dataLeAkPath368 = leakArRay368[leakArRay368.length - 1];
				android.util.Log.d("leak-368", dataLeAkPath368);
				return COPY;
            } else if (action.equals(context.getString(R.string.delete))) {
                String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP369 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP369.put("test", new java.util.HashMap<String, String>());
				leakMaP369.get("test").put("test", dataLeAk369);
				String dataLeAkPath369 = leakMaP369.get("test").get("test");
				android.util.Log.d("leak-369", dataLeAkPath369);
				return DELETE;
            }
            return EMPTY;
        }

        public static boolean isOnRemovableStorage(String path) {
            String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer370 = new StringBuffer();for (char chAr370 : dataLeAk370.toCharArray()) {leakBuFFer370.append(chAr370);}String dataLeAkPath370 = leakBuFFer370.toString();
			android.util.Log.d("leak-370", dataLeAkPath370);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath371;try {throw new Exception(dataLeAk371);} catch (Exception leakErRor371) {dataLeAkPath371 = leakErRor371.getMessage();}
				android.util.Log.d("leak-371", dataLeAkPath371);
				File file = new File(path);
                try {
                    String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay372 = new String[] {"n/a", dataLeAk372};
					String dataLeAkPath372 = leakArRay372[leakArRay372.length - 1];
					android.util.Log.d("leak-372", dataLeAkPath372);
					if (file.exists() && Environment.isExternalStorageRemovable(file)) {
                        String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP373 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP373.put("test", new java.util.HashMap<String, String>());
						leakMaP373.get("test").put("test", dataLeAk373);
						String dataLeAkPath373 = leakMaP373.get("test").get("test");
						android.util.Log.d("leak-373", dataLeAkPath373);
						return true;
                    }
                } catch (IllegalArgumentException e) {
                    String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer374 = new StringBuffer();for (char chAr374 : dataLeAk374.toCharArray()) {leakBuFFer374.append(chAr374);}String dataLeAkPath374 = leakBuFFer374.toString();
					android.util.Log.d("leak-374", dataLeAkPath374);
					e.printStackTrace();
                }
            }
            return false;
        }

        public static ArrayList<String> getAllChildPaths(ArrayList<String> paths, String path) {
            String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath375;try {throw new Exception(dataLeAk375);} catch (Exception leakErRor375) {dataLeAkPath375 = leakErRor375.getMessage();}
			android.util.Log.d("leak-375", dataLeAkPath375);
			File file = new File(path);
            if (file.exists()) {
                String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay376 = new String[] {"n/a", dataLeAk376};
				String dataLeAkPath376 = leakArRay376[leakArRay376.length - 1];
				android.util.Log.d("leak-376", dataLeAkPath376);
				if (file.isDirectory()) {
                    String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP377 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP377.put("test", new java.util.HashMap<String, String>());
					leakMaP377.get("test").put("test", dataLeAk377);
					String dataLeAkPath377 = leakMaP377.get("test").get("test");
					android.util.Log.d("leak-377", dataLeAkPath377);
					File[] children = file.listFiles();
                    for (int i = 0; i < children.length; i++) {
                        String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer378 = new StringBuffer();for (char chAr378 : dataLeAk378.toCharArray()) {leakBuFFer378.append(chAr378);}String dataLeAkPath378 = leakBuFFer378.toString();
						android.util.Log.d("leak-378", dataLeAkPath378);
						getAllChildPaths(paths, children[i].getPath());
                    }
                } else {
                    String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath379;try {throw new Exception(dataLeAk379);} catch (Exception leakErRor379) {dataLeAkPath379 = leakErRor379.getMessage();}
					android.util.Log.d("leak-379", dataLeAkPath379);
					paths.add(path);
                }
            }
            return paths;
        }

        public interface MediaScannerCallback {
            void onAllPathsScanned();
        }

        public static void scanPaths(final Context context, final String[] paths, final MediaScannerCallback callback) {
            String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay380 = new String[] {"n/a", dataLeAk380};
			String dataLeAkPath380 = leakArRay380[leakArRay380.length - 1];
			android.util.Log.d("leak-380", dataLeAkPath380);
			scanPaths(context, paths, callback, false);
        }

        public static void scanPathsWithNotification(final Context context, final String[] paths) {
            String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP381 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP381.put("test", new java.util.HashMap<String, String>());
			leakMaP381.get("test").put("test", dataLeAk381);
			String dataLeAkPath381 = leakMaP381.get("test").get("test");
			android.util.Log.d("leak-381", dataLeAkPath381);
			scanPaths(context, paths, null, true);
        }

        @SuppressLint("ShowToast")
        private static void scanPaths(final Context context, final String[] paths, final MediaScannerCallback callback, final boolean withNotification) {
            String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer382 = new StringBuffer();for (char chAr382 : dataLeAk382.toCharArray()) {leakBuFFer382.append(chAr382);}String dataLeAkPath382 = leakBuFFer382.toString();
			android.util.Log.d("leak-382", dataLeAkPath382);
			Log.i("FileOperation", "scanPaths(), paths: " + Arrays.toString(paths));
            if (paths == null) {
                String dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath383;try {throw new Exception(dataLeAk383);} catch (Exception leakErRor383) {dataLeAkPath383 = leakErRor383.getMessage();}
				android.util.Log.d("leak-383", dataLeAkPath383);
				if (callback != null) {
                    String dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay384 = new String[] {"n/a", dataLeAk384};
					String dataLeAkPath384 = leakArRay384[leakArRay384.length - 1];
					android.util.Log.d("leak-384", dataLeAkPath384);
					callback.onAllPathsScanned();
                }
                return;
            }

            //create notification
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP385 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP385.put("test", new java.util.HashMap<String, String>());
				leakMaP385.get("test").put("test", dataLeAk385);
				String dataLeAkPath385 = leakMaP385.get("test").get("test");
				android.util.Log.d("leak-385", dataLeAkPath385);
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
                @Override
                public void run() {
                    String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer386 = new StringBuffer();for (char chAr386 : dataLeAk386.toCharArray()) {leakBuFFer386.append(chAr386);}String dataLeAkPath386 = leakBuFFer386.toString();
					android.util.Log.d("leak-386", dataLeAkPath386);
					for (int i = 0; i < paths.length; i++) {
                        String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath387;try {throw new Exception(dataLeAk387);} catch (Exception leakErRor387) {dataLeAkPath387 = leakErRor387.getMessage();}
						android.util.Log.d("leak-387", dataLeAkPath387);
						String path = paths[i];
                        if (MediaType.isMedia(path)) {
                            String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay388 = new String[] {"n/a", dataLeAk388};
							String dataLeAkPath388 = leakArRay388[leakArRay388.length - 1];
							android.util.Log.d("leak-388", dataLeAkPath388);
							Uri contentUri = MediaStore.Files.getContentUri("external");
                            ContentResolver resolver = context.getContentResolver();
                            if (new File(path).exists()) {
                                String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP389 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP389.put("test", new java.util.HashMap<String, String>());
								leakMaP389.get("test").put("test", dataLeAk389);
								String dataLeAkPath389 = leakMaP389.get("test").get("test");
								android.util.Log.d("leak-389", dataLeAkPath389);
								AlbumItem albumItem = AlbumItem.getInstance(path);
                                ContentValues values = new ContentValues();
                                if (albumItem instanceof Video) {
                                    String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer390 = new StringBuffer();for (char chAr390 : dataLeAk390.toCharArray()) {leakBuFFer390.append(chAr390);}String dataLeAkPath390 = leakBuFFer390.toString();
									android.util.Log.d("leak-390", dataLeAkPath390);
									values.put(MediaStore.Video.Media.DATA, path);
                                    values.put(MediaStore.Video.Media.MIME_TYPE, MediaType.getMimeType(path));
                                } else {
                                    String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath391;try {throw new Exception(dataLeAk391);} catch (Exception leakErRor391) {dataLeAkPath391 = leakErRor391.getMessage();}
									android.util.Log.d("leak-391", dataLeAkPath391);
									values.put(MediaStore.Images.Media.DATA, path);
                                    values.put(MediaStore.Images.Media.MIME_TYPE, MediaType.getMimeType(path));
                                    try {
                                        String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay392 = new String[] {"n/a", dataLeAk392};
										String dataLeAkPath392 = leakArRay392[leakArRay392.length - 1];
										android.util.Log.d("leak-392", dataLeAkPath392);
										ExifInterface exif = new ExifInterface(path);
                                        Locale locale = us.koller.cameraroll.util.Util.getLocale(context);
                                        String dateString = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_DATETIME));
                                        try {
                                            String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP393 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP393.put("test", new java.util.HashMap<String, String>());
											leakMaP393.get("test").put("test", dataLeAk393);
											String dataLeAkPath393 = leakMaP393.get("test").get("test");
											android.util.Log.d("leak-393", dataLeAkPath393);
											Date date = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).parse(dateString);
                                            long dateTaken = date.getTime();
                                            values.put(MediaStore.Images.Media.DATE_TAKEN, dateTaken);
                                        } catch (ParseException e) {
                                            String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											StringBuffer leakBuFFer394 = new StringBuffer();for (char chAr394 : dataLeAk394.toCharArray()) {leakBuFFer394.append(chAr394);}String dataLeAkPath394 = leakBuFFer394.toString();
											android.util.Log.d("leak-394", dataLeAkPath394);
											e.printStackTrace();
                                        }
                                    } catch (IOException e) {
                                        String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath395;try {throw new Exception(dataLeAk395);} catch (Exception leakErRor395) {dataLeAkPath395 = leakErRor395.getMessage();}
										android.util.Log.d("leak-395", dataLeAkPath395);
										e.printStackTrace();
                                    }
                                }
                                resolver.insert(contentUri, values);
                            } else {
                                String dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay396 = new String[] {"n/a", dataLeAk396};
								String dataLeAkPath396 = leakArRay396[leakArRay396.length - 1];
								android.util.Log.d("leak-396", dataLeAkPath396);
								resolver.delete(contentUri,
                                        MediaStore.MediaColumns.DATA + "='" + path + "'",
                                        null);
                            }
                        }

                        if (withNotification) {
                            String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP397 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP397.put("test", new java.util.HashMap<String, String>());
							leakMaP397.get("test").put("test", dataLeAk397);
							String dataLeAkPath397 = leakMaP397.get("test").get("test");
							android.util.Log.d("leak-397", dataLeAkPath397);
							notifBuilder.setProgress(paths.length, i, false);
                            if (manager != null) {
                                String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer398 = new StringBuffer();for (char chAr398 : dataLeAk398.toCharArray()) {leakBuFFer398.append(chAr398);}String dataLeAkPath398 = leakBuFFer398.toString();
								android.util.Log.d("leak-398", dataLeAkPath398);
								manager.notify(NOTIFICATION_ID, notifBuilder.build());
                            }
                        }

                    }

                    if (manager != null) {
                        String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath399;try {throw new Exception(dataLeAk399);} catch (Exception leakErRor399) {dataLeAkPath399 = leakErRor399.getMessage();}
						android.util.Log.d("leak-399", dataLeAkPath399);
						manager.cancel(NOTIFICATION_ID);
                    }

                    if (callback != null) {
                        String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay400 = new String[] {"n/a", dataLeAk400};
						String dataLeAkPath400 = leakArRay400[leakArRay400.length - 1];
						android.util.Log.d("leak-400", dataLeAkPath400);
						new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP401 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP401.put("test", new java.util.HashMap<String, String>());
								leakMaP401.get("test").put("test", dataLeAk401);
								String dataLeAkPath401 = leakMaP401.get("test").get("test");
								android.util.Log.d("leak-401", dataLeAkPath401);
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
            String dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer402 = new StringBuffer();for (char chAr402 : dataLeAk402.toCharArray()) {leakBuFFer402.append(chAr402);}String dataLeAkPath402 = leakBuFFer402.toString();
			android.util.Log.d("leak-402", dataLeAkPath402);
			return new File(path).getParent();
        }
    }
}
