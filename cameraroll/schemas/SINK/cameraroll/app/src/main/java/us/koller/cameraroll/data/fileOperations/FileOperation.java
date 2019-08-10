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

    final String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk187 = "";

	String dataLeAk186 = "";

	String dataLeAk183 = "";

	String dataLeAk182 = "";

	String dataLeAk180 = "";

	String dataLeAk179 = "";

	String dataLeAk178 = "";

	String dataLeAk177 = "";

	String dataLeAk176 = "";

	String dataLeAk175 = "";

	String dataLeAk174 = "";

	String dataLeAk173 = "";

	String dataLeAk172 = "";

	String dataLeAk171 = "";

	String dataLeAk170 = "";

	String dataLeAk169 = "";

	String dataLeAk168 = "";

	String dataLeAk167 = "";

	String dataLeAk165 = "";

	String dataLeAk164 = "";

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
		dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-0", dataLeAk164);
		android.util.Log.d("leak-165-0", dataLeAk165);
		android.util.Log.d("leak-167-0", dataLeAk167);
		android.util.Log.d("leak-168-0", dataLeAk168);
		android.util.Log.d("leak-169-0", dataLeAk169);
		android.util.Log.d("leak-170-0", dataLeAk170);
		android.util.Log.d("leak-171-0", dataLeAk171);
		android.util.Log.d("leak-172-0", dataLeAk172);
		android.util.Log.d("leak-173-0", dataLeAk173);
		android.util.Log.d("leak-174-0", dataLeAk174);
		android.util.Log.d("leak-175-0", dataLeAk175);
		android.util.Log.d("leak-176-0", dataLeAk176);
		android.util.Log.d("leak-177-0", dataLeAk177);
		android.util.Log.d("leak-178-0", dataLeAk178);
		android.util.Log.d("leak-179-0", dataLeAk179);
		android.util.Log.d("leak-180-0", dataLeAk180);
		android.util.Log.d("leak-182-0", dataLeAk182);
		android.util.Log.d("leak-183-0", dataLeAk183);
		android.util.Log.d("leak-186-0", dataLeAk186);
		android.util.Log.d("leak-187-0", dataLeAk187);

        pathsToScan = new ArrayList<>();
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-1", dataLeAk164);
		android.util.Log.d("leak-165-1", dataLeAk165);
		android.util.Log.d("leak-167-1", dataLeAk167);
		android.util.Log.d("leak-168-1", dataLeAk168);
		android.util.Log.d("leak-169-1", dataLeAk169);
		android.util.Log.d("leak-170-1", dataLeAk170);
		android.util.Log.d("leak-171-1", dataLeAk171);
		android.util.Log.d("leak-172-1", dataLeAk172);
		android.util.Log.d("leak-173-1", dataLeAk173);
		android.util.Log.d("leak-174-1", dataLeAk174);
		android.util.Log.d("leak-175-1", dataLeAk175);
		android.util.Log.d("leak-176-1", dataLeAk176);
		android.util.Log.d("leak-177-1", dataLeAk177);
		android.util.Log.d("leak-178-1", dataLeAk178);
		android.util.Log.d("leak-179-1", dataLeAk179);
		android.util.Log.d("leak-180-1", dataLeAk180);
		android.util.Log.d("leak-182-1", dataLeAk182);
		android.util.Log.d("leak-183-1", dataLeAk183);
		android.util.Log.d("leak-186-1", dataLeAk186);
		android.util.Log.d("leak-187-1", dataLeAk187);
		notifBuilder = createNotificationBuilder();
        notifBuilder.setProgress(1, 0, false);
        Notification notification = notifBuilder.build();
        startForeground(NOTIFICATION_ID, notification);
        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(NOTIFICATION_ID, notification);
        }

        ContentObserver.selfChange = true;

        execute(workIntent);

        if (autoSendDoneBroadcast()) {
            if (pathsToScan.size() > 0) {
                onProgress(-1, -1);
                scanPaths(getApplicationContext(), new Util.MediaScannerCallback() {
                    String dataLeAk166 = "";

					@Override
                    public void onAllPathsScanned() {
                        dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-191-0", dataLeAk191);
						android.util.Log.d("leak-166-0", dataLeAk166);
						sendDoneBroadcast();
                        stopForeground(true);

                    }
                });
            } else {
                sendDoneBroadcast();
                stopForeground(true);
            }
        } else {
            ContentObserver.selfChange = false;
            stopForeground(true);
        }
    }

    private NotificationCompat.Builder createNotificationBuilder() {
        dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-2", dataLeAk164);
		android.util.Log.d("leak-165-2", dataLeAk165);
		android.util.Log.d("leak-167-2", dataLeAk167);
		android.util.Log.d("leak-168-2", dataLeAk168);
		android.util.Log.d("leak-169-2", dataLeAk169);
		android.util.Log.d("leak-170-2", dataLeAk170);
		android.util.Log.d("leak-171-2", dataLeAk171);
		android.util.Log.d("leak-172-2", dataLeAk172);
		android.util.Log.d("leak-173-2", dataLeAk173);
		android.util.Log.d("leak-174-2", dataLeAk174);
		android.util.Log.d("leak-175-2", dataLeAk175);
		android.util.Log.d("leak-176-2", dataLeAk176);
		android.util.Log.d("leak-177-2", dataLeAk177);
		android.util.Log.d("leak-178-2", dataLeAk178);
		android.util.Log.d("leak-179-2", dataLeAk179);
		android.util.Log.d("leak-180-2", dataLeAk180);
		android.util.Log.d("leak-182-2", dataLeAk182);
		android.util.Log.d("leak-183-2", dataLeAk183);
		android.util.Log.d("leak-186-2", dataLeAk186);
		android.util.Log.d("leak-187-2", dataLeAk187);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(getApplicationContext());
        }
        return new NotificationCompat.Builder(this, getString(R.string.file_op_channel_id))
                .setContentTitle(getNotificationTitle())
                .setSmallIcon(getNotificationSmallIconRes());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void createNotificationChannel(Context context) {
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel mChannel = new NotificationChannel(
                context.getString(R.string.file_op_channel_id),
                context.getString(R.string.file_op_channel_name),
                NotificationManager.IMPORTANCE_LOW);
        mChannel.setDescription(context.getString(R.string.file_op_channel_description));
        if (mNotificationManager != null) {
            mNotificationManager.createNotificationChannel(mChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-3", dataLeAk164);
		android.util.Log.d("leak-165-3", dataLeAk165);
		android.util.Log.d("leak-167-3", dataLeAk167);
		android.util.Log.d("leak-168-3", dataLeAk168);
		android.util.Log.d("leak-169-3", dataLeAk169);
		android.util.Log.d("leak-170-3", dataLeAk170);
		android.util.Log.d("leak-171-3", dataLeAk171);
		android.util.Log.d("leak-172-3", dataLeAk172);
		android.util.Log.d("leak-173-3", dataLeAk173);
		android.util.Log.d("leak-174-3", dataLeAk174);
		android.util.Log.d("leak-175-3", dataLeAk175);
		android.util.Log.d("leak-176-3", dataLeAk176);
		android.util.Log.d("leak-177-3", dataLeAk177);
		android.util.Log.d("leak-178-3", dataLeAk178);
		android.util.Log.d("leak-179-3", dataLeAk179);
		android.util.Log.d("leak-180-3", dataLeAk180);
		android.util.Log.d("leak-182-3", dataLeAk182);
		android.util.Log.d("leak-183-3", dataLeAk183);
		android.util.Log.d("leak-186-3", dataLeAk186);
		android.util.Log.d("leak-187-3", dataLeAk187);
		return notifBuilder;
    }

    abstract String getNotificationTitle();

    public abstract int getNotificationSmallIconRes();

    public abstract void execute(Intent workIntent);

    public void addPathToScan(String path) {
        dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-4", dataLeAk164);
		android.util.Log.d("leak-165-4", dataLeAk165);
		android.util.Log.d("leak-167-4", dataLeAk167);
		android.util.Log.d("leak-168-4", dataLeAk168);
		android.util.Log.d("leak-169-4", dataLeAk169);
		android.util.Log.d("leak-170-4", dataLeAk170);
		android.util.Log.d("leak-171-4", dataLeAk171);
		android.util.Log.d("leak-172-4", dataLeAk172);
		android.util.Log.d("leak-173-4", dataLeAk173);
		android.util.Log.d("leak-174-4", dataLeAk174);
		android.util.Log.d("leak-175-4", dataLeAk175);
		android.util.Log.d("leak-176-4", dataLeAk176);
		android.util.Log.d("leak-177-4", dataLeAk177);
		android.util.Log.d("leak-178-4", dataLeAk178);
		android.util.Log.d("leak-179-4", dataLeAk179);
		android.util.Log.d("leak-180-4", dataLeAk180);
		android.util.Log.d("leak-182-4", dataLeAk182);
		android.util.Log.d("leak-183-4", dataLeAk183);
		android.util.Log.d("leak-186-4", dataLeAk186);
		android.util.Log.d("leak-187-4", dataLeAk187);
		pathsToScan.add(path);
    }

    public void addPathsToScan(List<String> paths) {
        dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-5", dataLeAk164);
		android.util.Log.d("leak-165-5", dataLeAk165);
		android.util.Log.d("leak-167-5", dataLeAk167);
		android.util.Log.d("leak-168-5", dataLeAk168);
		android.util.Log.d("leak-169-5", dataLeAk169);
		android.util.Log.d("leak-170-5", dataLeAk170);
		android.util.Log.d("leak-171-5", dataLeAk171);
		android.util.Log.d("leak-172-5", dataLeAk172);
		android.util.Log.d("leak-173-5", dataLeAk173);
		android.util.Log.d("leak-174-5", dataLeAk174);
		android.util.Log.d("leak-175-5", dataLeAk175);
		android.util.Log.d("leak-176-5", dataLeAk176);
		android.util.Log.d("leak-177-5", dataLeAk177);
		android.util.Log.d("leak-178-5", dataLeAk178);
		android.util.Log.d("leak-179-5", dataLeAk179);
		android.util.Log.d("leak-180-5", dataLeAk180);
		android.util.Log.d("leak-182-5", dataLeAk182);
		android.util.Log.d("leak-183-5", dataLeAk183);
		android.util.Log.d("leak-186-5", dataLeAk186);
		android.util.Log.d("leak-187-5", dataLeAk187);
		pathsToScan.addAll(paths);
    }

    ArrayList<String> getPathsToScan() {
        dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-6", dataLeAk164);
		android.util.Log.d("leak-165-6", dataLeAk165);
		android.util.Log.d("leak-167-6", dataLeAk167);
		android.util.Log.d("leak-168-6", dataLeAk168);
		android.util.Log.d("leak-169-6", dataLeAk169);
		android.util.Log.d("leak-170-6", dataLeAk170);
		android.util.Log.d("leak-171-6", dataLeAk171);
		android.util.Log.d("leak-172-6", dataLeAk172);
		android.util.Log.d("leak-173-6", dataLeAk173);
		android.util.Log.d("leak-174-6", dataLeAk174);
		android.util.Log.d("leak-175-6", dataLeAk175);
		android.util.Log.d("leak-176-6", dataLeAk176);
		android.util.Log.d("leak-177-6", dataLeAk177);
		android.util.Log.d("leak-178-6", dataLeAk178);
		android.util.Log.d("leak-179-6", dataLeAk179);
		android.util.Log.d("leak-180-6", dataLeAk180);
		android.util.Log.d("leak-182-6", dataLeAk182);
		android.util.Log.d("leak-183-6", dataLeAk183);
		android.util.Log.d("leak-186-6", dataLeAk186);
		android.util.Log.d("leak-187-6", dataLeAk187);
		return pathsToScan;
    }

    public boolean autoSendDoneBroadcast() {
        dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-7", dataLeAk164);
		android.util.Log.d("leak-165-7", dataLeAk165);
		android.util.Log.d("leak-167-7", dataLeAk167);
		android.util.Log.d("leak-168-7", dataLeAk168);
		android.util.Log.d("leak-169-7", dataLeAk169);
		android.util.Log.d("leak-170-7", dataLeAk170);
		android.util.Log.d("leak-171-7", dataLeAk171);
		android.util.Log.d("leak-172-7", dataLeAk172);
		android.util.Log.d("leak-173-7", dataLeAk173);
		android.util.Log.d("leak-174-7", dataLeAk174);
		android.util.Log.d("leak-175-7", dataLeAk175);
		android.util.Log.d("leak-176-7", dataLeAk176);
		android.util.Log.d("leak-177-7", dataLeAk177);
		android.util.Log.d("leak-178-7", dataLeAk178);
		android.util.Log.d("leak-179-7", dataLeAk179);
		android.util.Log.d("leak-180-7", dataLeAk180);
		android.util.Log.d("leak-182-7", dataLeAk182);
		android.util.Log.d("leak-183-7", dataLeAk183);
		android.util.Log.d("leak-186-7", dataLeAk186);
		android.util.Log.d("leak-187-7", dataLeAk187);
		return true;
    }

    public void sendDoneBroadcast() {
        dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-8", dataLeAk164);
		android.util.Log.d("leak-165-8", dataLeAk165);
		android.util.Log.d("leak-167-8", dataLeAk167);
		android.util.Log.d("leak-168-8", dataLeAk168);
		android.util.Log.d("leak-169-8", dataLeAk169);
		android.util.Log.d("leak-170-8", dataLeAk170);
		android.util.Log.d("leak-171-8", dataLeAk171);
		android.util.Log.d("leak-172-8", dataLeAk172);
		android.util.Log.d("leak-173-8", dataLeAk173);
		android.util.Log.d("leak-174-8", dataLeAk174);
		android.util.Log.d("leak-175-8", dataLeAk175);
		android.util.Log.d("leak-176-8", dataLeAk176);
		android.util.Log.d("leak-177-8", dataLeAk177);
		android.util.Log.d("leak-178-8", dataLeAk178);
		android.util.Log.d("leak-179-8", dataLeAk179);
		android.util.Log.d("leak-180-8", dataLeAk180);
		android.util.Log.d("leak-182-8", dataLeAk182);
		android.util.Log.d("leak-183-8", dataLeAk183);
		android.util.Log.d("leak-186-8", dataLeAk186);
		android.util.Log.d("leak-187-8", dataLeAk187);
		ContentObserver.selfChange = false;
        showToast(getString(R.string.done));
        Intent intent = getDoneIntent();
        sendLocalBroadcast(intent);
    }

    public void sendFailedBroadcast(Intent workIntent, String path) {
        dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-9", dataLeAk164);
		android.util.Log.d("leak-165-9", dataLeAk165);
		android.util.Log.d("leak-167-9", dataLeAk167);
		android.util.Log.d("leak-168-9", dataLeAk168);
		android.util.Log.d("leak-169-9", dataLeAk169);
		android.util.Log.d("leak-170-9", dataLeAk170);
		android.util.Log.d("leak-171-9", dataLeAk171);
		android.util.Log.d("leak-172-9", dataLeAk172);
		android.util.Log.d("leak-173-9", dataLeAk173);
		android.util.Log.d("leak-174-9", dataLeAk174);
		android.util.Log.d("leak-175-9", dataLeAk175);
		android.util.Log.d("leak-176-9", dataLeAk176);
		android.util.Log.d("leak-177-9", dataLeAk177);
		android.util.Log.d("leak-178-9", dataLeAk178);
		android.util.Log.d("leak-179-9", dataLeAk179);
		android.util.Log.d("leak-180-9", dataLeAk180);
		android.util.Log.d("leak-182-9", dataLeAk182);
		android.util.Log.d("leak-183-9", dataLeAk183);
		android.util.Log.d("leak-186-9", dataLeAk186);
		android.util.Log.d("leak-187-9", dataLeAk187);
		Intent intent = new Intent(FAILED);
        intent.putExtra(FILES, path);
        intent.putExtra(WORK_INTENT, workIntent);
        sendLocalBroadcast(intent);
    }

    public void requestPermissionForRemovableStorageBroadcast(Intent workIntent) {
        dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-10", dataLeAk164);
		android.util.Log.d("leak-165-10", dataLeAk165);
		android.util.Log.d("leak-167-10", dataLeAk167);
		android.util.Log.d("leak-168-10", dataLeAk168);
		android.util.Log.d("leak-169-10", dataLeAk169);
		android.util.Log.d("leak-170-10", dataLeAk170);
		android.util.Log.d("leak-171-10", dataLeAk171);
		android.util.Log.d("leak-172-10", dataLeAk172);
		android.util.Log.d("leak-173-10", dataLeAk173);
		android.util.Log.d("leak-174-10", dataLeAk174);
		android.util.Log.d("leak-175-10", dataLeAk175);
		android.util.Log.d("leak-176-10", dataLeAk176);
		android.util.Log.d("leak-177-10", dataLeAk177);
		android.util.Log.d("leak-178-10", dataLeAk178);
		android.util.Log.d("leak-179-10", dataLeAk179);
		android.util.Log.d("leak-180-10", dataLeAk180);
		android.util.Log.d("leak-182-10", dataLeAk182);
		android.util.Log.d("leak-183-10", dataLeAk183);
		android.util.Log.d("leak-186-10", dataLeAk186);
		android.util.Log.d("leak-187-10", dataLeAk187);
		Intent intent = new Intent(NEED_REMOVABLE_STORAGE_PERMISSION);
        intent.putExtra(WORK_INTENT, workIntent);
        sendLocalBroadcast(intent);
    }

    public Intent getDoneIntent() {
        dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-11", dataLeAk164);
		android.util.Log.d("leak-165-11", dataLeAk165);
		android.util.Log.d("leak-167-11", dataLeAk167);
		android.util.Log.d("leak-168-11", dataLeAk168);
		android.util.Log.d("leak-169-11", dataLeAk169);
		android.util.Log.d("leak-170-11", dataLeAk170);
		android.util.Log.d("leak-171-11", dataLeAk171);
		android.util.Log.d("leak-172-11", dataLeAk172);
		android.util.Log.d("leak-173-11", dataLeAk173);
		android.util.Log.d("leak-174-11", dataLeAk174);
		android.util.Log.d("leak-175-11", dataLeAk175);
		android.util.Log.d("leak-176-11", dataLeAk176);
		android.util.Log.d("leak-177-11", dataLeAk177);
		android.util.Log.d("leak-178-11", dataLeAk178);
		android.util.Log.d("leak-179-11", dataLeAk179);
		android.util.Log.d("leak-180-11", dataLeAk180);
		android.util.Log.d("leak-182-11", dataLeAk182);
		android.util.Log.d("leak-183-11", dataLeAk183);
		android.util.Log.d("leak-186-11", dataLeAk186);
		android.util.Log.d("leak-187-11", dataLeAk187);
		Intent intent = new Intent(RESULT_DONE);
        intent.putExtra(TYPE, this.getType());
        return intent;
    }

    public void sendLocalBroadcast(Intent intent) {
        dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-12", dataLeAk164);
		android.util.Log.d("leak-165-12", dataLeAk165);
		android.util.Log.d("leak-167-12", dataLeAk167);
		android.util.Log.d("leak-168-12", dataLeAk168);
		android.util.Log.d("leak-169-12", dataLeAk169);
		android.util.Log.d("leak-170-12", dataLeAk170);
		android.util.Log.d("leak-171-12", dataLeAk171);
		android.util.Log.d("leak-172-12", dataLeAk172);
		android.util.Log.d("leak-173-12", dataLeAk173);
		android.util.Log.d("leak-174-12", dataLeAk174);
		android.util.Log.d("leak-175-12", dataLeAk175);
		android.util.Log.d("leak-176-12", dataLeAk176);
		android.util.Log.d("leak-177-12", dataLeAk177);
		android.util.Log.d("leak-178-12", dataLeAk178);
		android.util.Log.d("leak-179-12", dataLeAk179);
		android.util.Log.d("leak-180-12", dataLeAk180);
		android.util.Log.d("leak-182-12", dataLeAk182);
		android.util.Log.d("leak-183-12", dataLeAk183);
		android.util.Log.d("leak-186-12", dataLeAk186);
		android.util.Log.d("leak-187-12", dataLeAk187);
		LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    public abstract int getType();

    @Override
    public int describeContents() {
        dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-13", dataLeAk164);
		android.util.Log.d("leak-165-13", dataLeAk165);
		android.util.Log.d("leak-167-13", dataLeAk167);
		android.util.Log.d("leak-168-13", dataLeAk168);
		android.util.Log.d("leak-169-13", dataLeAk169);
		android.util.Log.d("leak-170-13", dataLeAk170);
		android.util.Log.d("leak-171-13", dataLeAk171);
		android.util.Log.d("leak-172-13", dataLeAk172);
		android.util.Log.d("leak-173-13", dataLeAk173);
		android.util.Log.d("leak-174-13", dataLeAk174);
		android.util.Log.d("leak-175-13", dataLeAk175);
		android.util.Log.d("leak-176-13", dataLeAk176);
		android.util.Log.d("leak-177-13", dataLeAk177);
		android.util.Log.d("leak-178-13", dataLeAk178);
		android.util.Log.d("leak-179-13", dataLeAk179);
		android.util.Log.d("leak-180-13", dataLeAk180);
		android.util.Log.d("leak-182-13", dataLeAk182);
		android.util.Log.d("leak-183-13", dataLeAk183);
		android.util.Log.d("leak-186-13", dataLeAk186);
		android.util.Log.d("leak-187-13", dataLeAk187);
		return 0;
    }

    @SuppressWarnings("unused")
    public void onProgress(final int progress, final int totalNumber) {
        dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-14", dataLeAk164);
		android.util.Log.d("leak-165-14", dataLeAk165);
		android.util.Log.d("leak-167-14", dataLeAk167);
		android.util.Log.d("leak-168-14", dataLeAk168);
		android.util.Log.d("leak-169-14", dataLeAk169);
		android.util.Log.d("leak-170-14", dataLeAk170);
		android.util.Log.d("leak-171-14", dataLeAk171);
		android.util.Log.d("leak-172-14", dataLeAk172);
		android.util.Log.d("leak-173-14", dataLeAk173);
		android.util.Log.d("leak-174-14", dataLeAk174);
		android.util.Log.d("leak-175-14", dataLeAk175);
		android.util.Log.d("leak-176-14", dataLeAk176);
		android.util.Log.d("leak-177-14", dataLeAk177);
		android.util.Log.d("leak-178-14", dataLeAk178);
		android.util.Log.d("leak-179-14", dataLeAk179);
		android.util.Log.d("leak-180-14", dataLeAk180);
		android.util.Log.d("leak-182-14", dataLeAk182);
		android.util.Log.d("leak-183-14", dataLeAk183);
		android.util.Log.d("leak-186-14", dataLeAk186);
		android.util.Log.d("leak-187-14", dataLeAk187);
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
            manager.notify(NOTIFICATION_ID, notifBuilder.build());
        }
    }

    public void showToast(final String message) {
        dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-15", dataLeAk164);
		android.util.Log.d("leak-165-15", dataLeAk165);
		android.util.Log.d("leak-167-15", dataLeAk167);
		android.util.Log.d("leak-168-15", dataLeAk168);
		android.util.Log.d("leak-169-15", dataLeAk169);
		android.util.Log.d("leak-170-15", dataLeAk170);
		android.util.Log.d("leak-171-15", dataLeAk171);
		android.util.Log.d("leak-172-15", dataLeAk172);
		android.util.Log.d("leak-173-15", dataLeAk173);
		android.util.Log.d("leak-174-15", dataLeAk174);
		android.util.Log.d("leak-175-15", dataLeAk175);
		android.util.Log.d("leak-176-15", dataLeAk176);
		android.util.Log.d("leak-177-15", dataLeAk177);
		android.util.Log.d("leak-178-15", dataLeAk178);
		android.util.Log.d("leak-179-15", dataLeAk179);
		android.util.Log.d("leak-180-15", dataLeAk180);
		android.util.Log.d("leak-182-15", dataLeAk182);
		android.util.Log.d("leak-183-15", dataLeAk183);
		android.util.Log.d("leak-186-15", dataLeAk186);
		android.util.Log.d("leak-187-15", dataLeAk187);
		runOnUiThread(new Runnable() {
            String dataLeAk181 = "";

			@Override
            public void run() {
                dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-192-0", dataLeAk192);
				android.util.Log.d("leak-181-0", dataLeAk181);
				Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void runOnUiThread(Runnable r) {
        dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-16", dataLeAk164);
		android.util.Log.d("leak-165-16", dataLeAk165);
		android.util.Log.d("leak-167-16", dataLeAk167);
		android.util.Log.d("leak-168-16", dataLeAk168);
		android.util.Log.d("leak-169-16", dataLeAk169);
		android.util.Log.d("leak-170-16", dataLeAk170);
		android.util.Log.d("leak-171-16", dataLeAk171);
		android.util.Log.d("leak-172-16", dataLeAk172);
		android.util.Log.d("leak-173-16", dataLeAk173);
		android.util.Log.d("leak-174-16", dataLeAk174);
		android.util.Log.d("leak-175-16", dataLeAk175);
		android.util.Log.d("leak-176-16", dataLeAk176);
		android.util.Log.d("leak-177-16", dataLeAk177);
		android.util.Log.d("leak-178-16", dataLeAk178);
		android.util.Log.d("leak-179-16", dataLeAk179);
		android.util.Log.d("leak-180-16", dataLeAk180);
		android.util.Log.d("leak-182-16", dataLeAk182);
		android.util.Log.d("leak-183-16", dataLeAk183);
		android.util.Log.d("leak-186-16", dataLeAk186);
		android.util.Log.d("leak-187-16", dataLeAk187);
		Handler handler = new Handler(Looper.getMainLooper());
        handler.post(r);
    }

    public static File_POJO[] getFiles(Intent workIntent) {
        Parcelable[] parcelables = workIntent.getParcelableArrayExtra(FILES);
        return File_POJO.generateArray(parcelables);
    }

    public static Intent getDefaultIntent(Context context, int action, File_POJO[] files) {
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
            return new Intent(context, service)
                    .setAction(actionString)
                    .putExtra(FileOperation.FILES, files);
        }
        return new Intent();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-17", dataLeAk164);
		android.util.Log.d("leak-165-17", dataLeAk165);
		android.util.Log.d("leak-167-17", dataLeAk167);
		android.util.Log.d("leak-168-17", dataLeAk168);
		android.util.Log.d("leak-169-17", dataLeAk169);
		android.util.Log.d("leak-170-17", dataLeAk170);
		android.util.Log.d("leak-171-17", dataLeAk171);
		android.util.Log.d("leak-172-17", dataLeAk172);
		android.util.Log.d("leak-173-17", dataLeAk173);
		android.util.Log.d("leak-174-17", dataLeAk174);
		android.util.Log.d("leak-175-17", dataLeAk175);
		android.util.Log.d("leak-176-17", dataLeAk176);
		android.util.Log.d("leak-177-17", dataLeAk177);
		android.util.Log.d("leak-178-17", dataLeAk178);
		android.util.Log.d("leak-179-17", dataLeAk179);
		android.util.Log.d("leak-180-17", dataLeAk180);
		android.util.Log.d("leak-182-17", dataLeAk182);
		android.util.Log.d("leak-183-17", dataLeAk183);
		android.util.Log.d("leak-186-17", dataLeAk186);
		android.util.Log.d("leak-187-17", dataLeAk187);
		parcel.writeInt(getType());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        String dataLeAk185 = "";

		String dataLeAk184 = "";

		@Override
        public FileOperation createFromParcel(Parcel parcel) {
            dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-184-0", dataLeAk184);
			android.util.Log.d("leak-185-0", dataLeAk185);
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
            dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-184-1", dataLeAk184);
			android.util.Log.d("leak-185-1", dataLeAk185);
			return new AlbumItem[i];
        }
    };


    public Uri getTreeUri(Intent workIntent, String path) {
        dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-18", dataLeAk164);
		android.util.Log.d("leak-165-18", dataLeAk165);
		android.util.Log.d("leak-167-18", dataLeAk167);
		android.util.Log.d("leak-168-18", dataLeAk168);
		android.util.Log.d("leak-169-18", dataLeAk169);
		android.util.Log.d("leak-170-18", dataLeAk170);
		android.util.Log.d("leak-171-18", dataLeAk171);
		android.util.Log.d("leak-172-18", dataLeAk172);
		android.util.Log.d("leak-173-18", dataLeAk173);
		android.util.Log.d("leak-174-18", dataLeAk174);
		android.util.Log.d("leak-175-18", dataLeAk175);
		android.util.Log.d("leak-176-18", dataLeAk176);
		android.util.Log.d("leak-177-18", dataLeAk177);
		android.util.Log.d("leak-178-18", dataLeAk178);
		android.util.Log.d("leak-179-18", dataLeAk179);
		android.util.Log.d("leak-180-18", dataLeAk180);
		android.util.Log.d("leak-182-18", dataLeAk182);
		android.util.Log.d("leak-183-18", dataLeAk183);
		android.util.Log.d("leak-186-18", dataLeAk186);
		android.util.Log.d("leak-187-18", dataLeAk187);
		Log.d("FileOperation", "getTreeUri");
        Uri treeUri;
        String treeUriExtra = workIntent.getStringExtra(FileOperation.REMOVABLE_STORAGE_TREE_URI);
        if (treeUriExtra != null) {
            treeUri = Uri.parse(treeUriExtra);
        } else {
            Settings s = Settings.getInstance(getApplicationContext());
            treeUri = s.getRemovableStorageTreeUri();
        }

        if (path != null) {
            //check if path is child of the treeUri
            DocumentFile file = StorageUtil.parseDocumentFile(getApplicationContext(), treeUri, new File(path));
            if (file != null) {
                return treeUri;
            } else {
                requestPermissionForRemovableStorageBroadcast(workIntent);
            }
        } else {
            return treeUri;
        }
        return null;
    }

    void scanPaths(final Context context, final Util.MediaScannerCallback callback) {
        dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-164-19", dataLeAk164);
		android.util.Log.d("leak-165-19", dataLeAk165);
		android.util.Log.d("leak-167-19", dataLeAk167);
		android.util.Log.d("leak-168-19", dataLeAk168);
		android.util.Log.d("leak-169-19", dataLeAk169);
		android.util.Log.d("leak-170-19", dataLeAk170);
		android.util.Log.d("leak-171-19", dataLeAk171);
		android.util.Log.d("leak-172-19", dataLeAk172);
		android.util.Log.d("leak-173-19", dataLeAk173);
		android.util.Log.d("leak-174-19", dataLeAk174);
		android.util.Log.d("leak-175-19", dataLeAk175);
		android.util.Log.d("leak-176-19", dataLeAk176);
		android.util.Log.d("leak-177-19", dataLeAk177);
		android.util.Log.d("leak-178-19", dataLeAk178);
		android.util.Log.d("leak-179-19", dataLeAk179);
		android.util.Log.d("leak-180-19", dataLeAk180);
		android.util.Log.d("leak-182-19", dataLeAk182);
		android.util.Log.d("leak-183-19", dataLeAk183);
		android.util.Log.d("leak-186-19", dataLeAk186);
		android.util.Log.d("leak-187-19", dataLeAk187);
		String[] paths = new String[pathsToScan.size()];
        pathsToScan.toArray(paths);
        Util.scanPaths(context, paths, callback);
    }

    public static class Util {
        public static IntentFilter getIntentFilter(IntentFilter filter) {
            filter.addAction(FileOperation.RESULT_DONE);
            filter.addAction(FileOperation.FAILED);
            return filter;
        }

        public static String getActionString(Context context, int type) {
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
            if (action.equals(context.getString(R.string.move))) {
                return MOVE;
            } else if (action.equals(context.getString(R.string.copy))) {
                return COPY;
            } else if (action.equals(context.getString(R.string.delete))) {
                return DELETE;
            }
            return EMPTY;
        }

        public static boolean isOnRemovableStorage(String path) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                File file = new File(path);
                try {
                    if (file.exists() && Environment.isExternalStorageRemovable(file)) {
                        return true;
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        public static ArrayList<String> getAllChildPaths(ArrayList<String> paths, String path) {
            File file = new File(path);
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] children = file.listFiles();
                    for (int i = 0; i < children.length; i++) {
                        getAllChildPaths(paths, children[i].getPath());
                    }
                } else {
                    paths.add(path);
                }
            }
            return paths;
        }

        public interface MediaScannerCallback {
            void onAllPathsScanned();
        }

        public static void scanPaths(final Context context, final String[] paths, final MediaScannerCallback callback) {
            scanPaths(context, paths, callback, false);
        }

        public static void scanPathsWithNotification(final Context context, final String[] paths) {
            scanPaths(context, paths, null, true);
        }

        @SuppressLint("ShowToast")
        private static void scanPaths(final Context context, final String[] paths, final MediaScannerCallback callback, final boolean withNotification) {
            Log.i("FileOperation", "scanPaths(), paths: " + Arrays.toString(paths));
            if (paths == null) {
                if (callback != null) {
                    callback.onAllPathsScanned();
                }
                return;
            }

            //create notification
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
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
                final String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				String dataLeAk188 = "";

				@Override
                public void run() {
                    dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-188-0", dataLeAk188);
					for (int i = 0; i < paths.length; i++) {
                        String path = paths[i];
                        if (MediaType.isMedia(path)) {
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
                        }

                        if (withNotification) {
                            notifBuilder.setProgress(paths.length, i, false);
                            if (manager != null) {
                                manager.notify(NOTIFICATION_ID, notifBuilder.build());
                            }
                        }

                    }

                    if (manager != null) {
                        manager.cancel(NOTIFICATION_ID);
                    }

                    if (callback != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            String dataLeAk189 = "";

							@Override
                            public void run() {
                                dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-193-0", dataLeAk193);
								android.util.Log.d("leak-189-0", dataLeAk189);
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
            return new File(path).getParent();
        }
    }
}
