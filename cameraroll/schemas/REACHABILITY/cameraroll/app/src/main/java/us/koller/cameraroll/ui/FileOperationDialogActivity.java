package us.koller.cameraroll.ui;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.fileOperations.FileOperation;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.provider.MediaProvider;
import us.koller.cameraroll.ui.widget.GridMarginDecoration;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.Util;

public class FileOperationDialogActivity extends ThemeableActivity {

    String dataLeAk1317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1317 = android.util.Log.d("leak-1317", dataLeAk1317);

	public static String ACTION_COPY = "ACTION_COPY";
    public static String ACTION_MOVE = "ACTION_MOVE";

    public static String FILES = "FILES";
    private static String CREATE_NEW_FOLDER = "CREATE_NEW_FOLDER";

    private String action;

    private boolean creatingNewFolder = false;

    private AlertDialog dialog;

    // need to start FileOperation, when this activity is destroyed
    // otherwise running into issue with the removable storage permission broadcast not being received
    private OnDestroyListener onDestroyListener;

    private interface OnDestroyListener {
        void onDestroy();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk1318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1318 = android.util.Log.d("leak-1318", dataLeAk1318);
        setContentView(R.layout.activity_file_operation_dialog);

        Intent intent = getIntent();

        if (intent == null) {
            String dataLeAk1319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1319 = android.util.Log.d("leak-1319", dataLeAk1319);
			this.finish();
            return;
        }

        action = intent.getAction();

        String[] filePaths = intent.getStringArrayExtra(FILES);
        final File_POJO[] files = new File_POJO[filePaths.length];
        for (int i = 0; i < filePaths.length; i++) {
            String dataLeAk1320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1320 = android.util.Log.d("leak-1320", dataLeAk1320);
			files[i] = new File_POJO(filePaths[i],
                    MediaType.isMedia(filePaths[i]));
        }

        if (savedInstanceState != null
                && savedInstanceState.containsKey(CREATE_NEW_FOLDER)
                && Objects.equals(savedInstanceState.getString(CREATE_NEW_FOLDER), "true")) {
            String dataLeAk1321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1321 = android.util.Log.d("leak-1321", dataLeAk1321);
			creatingNewFolder = true;
            createNewFolder(files);
            return;
        }

        showFolderSelectorDialog(files);
    }

    private interface NewFolderCallback {
        void newFolderCreated(String path);

        void failed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk1322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1322 = android.util.Log.d("leak-1322", dataLeAk1322);

        if (creatingNewFolder) {
            String dataLeAk1323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1323 = android.util.Log.d("leak-1323", dataLeAk1323);
			outState.putString(CREATE_NEW_FOLDER, "true");
        }
    }

    public void onDialogDismiss() {
        String dataLeAk1324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1324 = android.util.Log.d("leak-1324", dataLeAk1324);
		if (!(creatingNewFolder || isChangingConfigurations())) {
            String dataLeAk1325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1325 = android.util.Log.d("leak-1325", dataLeAk1325);
			setResult(RESULT_CANCELED, null);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1326 = android.util.Log.d("leak-1326", dataLeAk1326);

        if (dialog != null) {
            String dataLeAk1327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1327 = android.util.Log.d("leak-1327", dataLeAk1327);
			dialog.dismiss();
        }

        if (onDestroyListener != null) {
            String dataLeAk1328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1328 = android.util.Log.d("leak-1328", dataLeAk1328);
			onDestroyListener.onDestroy();
        }
    }

    public void showFolderSelectorDialog(final File_POJO[] files) {
        String dataLeAk1329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1329 = android.util.Log.d("leak-1329", dataLeAk1329);
		View v = LayoutInflater.from(this)
                .inflate(R.layout.file_operation_dialog,
                        (ViewGroup) findViewById(R.id.root_view),
                        false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new GridMarginDecoration(
                (int) getResources().getDimension(R.dimen.album_grid_spacing_big)));

        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        int stringRes;
        boolean oneItem = files.length == 1;
        if (action.equals(ACTION_COPY)) {
            String dataLeAk1330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1330 = android.util.Log.d("leak-1330", dataLeAk1330);
			if (oneItem) {
                String dataLeAk1331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1331 = android.util.Log.d("leak-1331", dataLeAk1331);
				stringRes = R.string.copy_item_to;
            } else {
                String dataLeAk1332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1332 = android.util.Log.d("leak-1332", dataLeAk1332);
				stringRes = R.string.copy_items_to;
            }
        } else {
            String dataLeAk1333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1333 = android.util.Log.d("leak-1333", dataLeAk1333);
			if (oneItem) {
                String dataLeAk1334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1334 = android.util.Log.d("leak-1334", dataLeAk1334);
				stringRes = R.string.move_item_to;
            } else {
                String dataLeAk1335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1335 = android.util.Log.d("leak-1335", dataLeAk1335);
				stringRes = R.string.move_items_to;
            }
        }
        String title = getString(stringRes, files.length);

        dialog = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(title)
                .setView(v)
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            String dataLeAk1336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1336 = android.util.Log.d("leak-1336", dataLeAk1336);

							@Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String dataLeAk1337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1337 = android.util.Log.d("leak-1337", dataLeAk1337);
								onDestroyListener = new OnDestroyListener() {
                                    String dataLeAk1338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1338 = android.util.Log.d("leak-1338", dataLeAk1338);

									@Override
                                    public void onDestroy() {
                                        String dataLeAk1339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1339 = android.util.Log.d("leak-1339", dataLeAk1339);
										String path = recyclerViewAdapter.getSelectedPath();
                                        if (path != null) {
                                            String dataLeAk1340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk1340 = android.util.Log.d("leak-1340", dataLeAk1340);
											executeAction(files, path);
                                        }
                                    }
                                };
                            }
                        })
                .setNeutralButton(getString(R.string.new_folder), new DialogInterface.OnClickListener() {
                    String dataLeAk1341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1341 = android.util.Log.d("leak-1341", dataLeAk1341);

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dataLeAk1342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1342 = android.util.Log.d("leak-1342", dataLeAk1342);
						creatingNewFolder = true;
                        createNewFolder(files);
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    String dataLeAk1343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1343 = android.util.Log.d("leak-1343", dataLeAk1343);

					@Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        String dataLeAk1344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1344 = android.util.Log.d("leak-1344", dataLeAk1344);
						onDialogDismiss();
                    }
                })
                .create();

        dialog.show();
    }

    public void createNewFolder(final File_POJO[] files) {
        String dataLeAk1345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1345 = android.util.Log.d("leak-1345", dataLeAk1345);
		createNewFolderDialog(new NewFolderCallback() {
            String dataLeAk1346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1346 = android.util.Log.d("leak-1346", dataLeAk1346);

			@Override
            public void newFolderCreated(String path) {
                String dataLeAk1347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1347 = android.util.Log.d("leak-1347", dataLeAk1347);
				executeAction(files, path);
            }

            @Override
            public void failed() {
                String dataLeAk1348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1348 = android.util.Log.d("leak-1348", dataLeAk1348);
				setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }

    public void createNewFolderDialog(final NewFolderCallback callback) {
        String dataLeAk1349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1349 = android.util.Log.d("leak-1349", dataLeAk1349);
		View dialogLayout = LayoutInflater.from(this).inflate(R.layout.input_dialog_layout,
                (ViewGroup) findViewById(R.id.root_view), false);

        final EditText editText = dialogLayout.findViewById(R.id.edit_text);

        dialog = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(R.string.new_folder)
                .setView(dialogLayout)
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    String dataLeAk1350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1350 = android.util.Log.d("leak-1350", dataLeAk1350);

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dataLeAk1351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1351 = android.util.Log.d("leak-1351", dataLeAk1351);
						String filename = editText.getText().toString();
                        String picturesDir = Environment
                                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();

                        final File_POJO newFolder
                                = new File_POJO(picturesDir + "/" + filename, false);

                        registerLocalBroadcastReceiver(new BroadcastReceiver() {
                            String dataLeAk1352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1352 = android.util.Log.d("leak-1352", dataLeAk1352);

							@Override
                            public void onReceive(Context context, Intent intent) {
                                String dataLeAk1353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1353 = android.util.Log.d("leak-1353", dataLeAk1353);
								unregisterLocalBroadcastReceiver(this);
                                switch (intent.getAction()) {
                                    case FileOperation.RESULT_DONE:
                                        creatingNewFolder = false;
                                        callback.newFolderCreated(newFolder.getPath());
                                        break;
                                    case FileOperation.FAILED:
                                        creatingNewFolder = false;
                                        callback.failed();
                                        break;
                                    default:
                                        break;
                                }
                            }
                        });

                        Intent intent = FileOperation.getDefaultIntent(
                                FileOperationDialogActivity.this,
                                FileOperation.NEW_DIR,
                                new File_POJO[]{newFolder});
                        startService(intent);
                    }
                })
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    String dataLeAk1354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1354 = android.util.Log.d("leak-1354", dataLeAk1354);

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
						String dataLeAk1355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1355 = android.util.Log.d("leak-1355", dataLeAk1355);
                        //showFolderSelectorDialog();
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    String dataLeAk1356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1356 = android.util.Log.d("leak-1356", dataLeAk1356);

					@Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        String dataLeAk1357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1357 = android.util.Log.d("leak-1357", dataLeAk1357);
						creatingNewFolder = false;
                        onDialogDismiss();
                    }
                })
                .create();
        //noinspection ConstantConditions
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        dialog.show();
    }

    public void executeAction(File_POJO[] files, String target) {
        String dataLeAk1358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1358 = android.util.Log.d("leak-1358", dataLeAk1358);
		int action = this.action.equals(ACTION_COPY) ? FileOperation.COPY : FileOperation.MOVE;
        final Intent workIntent = FileOperation.getDefaultIntent(this, action, files);
        workIntent.putExtra(FileOperation.TARGET, new File_POJO(target, false));
        startService(workIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
		String dataLeAk1359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1359 = android.util.Log.d("leak-1359", dataLeAk1359);
        switch (requestCode) {
            case MainActivity.REMOVABLE_STORAGE_PERMISSION_REQUEST_CODE:
                onDialogDismiss();
                break;
            default:
                break;
        }
    }


    @Override
    public int getDarkThemeRes() {
        String dataLeAk1360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1360 = android.util.Log.d("leak-1360", dataLeAk1360);
		return R.style.CameraRoll_Theme_Translucent_FileOperationDialog;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1361 = android.util.Log.d("leak-1361", dataLeAk1361);
		return R.style.CameraRoll_Theme_Light_Translucent_FileOperationDialog;
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        String dataLeAk1362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1362 = android.util.Log.d("leak-1362", dataLeAk1362);
		return FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter {

        String dataLeAk1363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1363 = android.util.Log.d("leak-1363", dataLeAk1363);

		private ArrayList<Album> albums;
        private int selected_position = -1;

        static class ViewHolder extends RecyclerView.ViewHolder {

            String dataLeAk1364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1364 = android.util.Log.d("leak-1364", dataLeAk1364);

			public ViewHolder(View itemView) {
                super(itemView);
				String dataLeAk1365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1365 = android.util.Log.d("leak-1365", dataLeAk1365);
            }

            private void setSelected(boolean selected) {
                String dataLeAk1366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1366 = android.util.Log.d("leak-1366", dataLeAk1366);
				final View imageView = itemView.findViewById(R.id.image);

                if (selected) {
                    String dataLeAk1367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1367 = android.util.Log.d("leak-1367", dataLeAk1367);
					final Drawable selectorOverlay = Util
                            .getAlbumItemSelectorOverlay(imageView.getContext());
                    imageView.post(new Runnable() {
                        String dataLeAk1368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1368 = android.util.Log.d("leak-1368", dataLeAk1368);

						@Override
                        public void run() {
                            String dataLeAk1369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1369 = android.util.Log.d("leak-1369", dataLeAk1369);
							imageView.getOverlay().clear();
                            if (selectorOverlay != null) {
                                String dataLeAk1370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1370 = android.util.Log.d("leak-1370", dataLeAk1370);
								selectorOverlay.setBounds(0, 0,
                                        imageView.getWidth(),
                                        imageView.getHeight());
                                imageView.getOverlay().add(selectorOverlay);
                            }
                        }
                    });
                } else {
                    String dataLeAk1371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1371 = android.util.Log.d("leak-1371", dataLeAk1371);
					imageView.post(new Runnable() {
                        String dataLeAk1372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1372 = android.util.Log.d("leak-1372", dataLeAk1372);

						@Override
                        public void run() {
                            String dataLeAk1373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1373 = android.util.Log.d("leak-1373", dataLeAk1373);
							imageView.getOverlay().clear();
                        }
                    });
                }
            }
        }

        RecyclerViewAdapter() {
            String dataLeAk1374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1374 = android.util.Log.d("leak-1374", dataLeAk1374);
			albums = MediaProvider.getAlbums();

            if (albums != null && albums.size() == 0) {
                String dataLeAk1375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1375 = android.util.Log.d("leak-1375", dataLeAk1375);
				albums.add(MediaProvider.getErrorAlbum());
            }
        }

        String getSelectedPath() {
            String dataLeAk1376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1376 = android.util.Log.d("leak-1376", dataLeAk1376);
			if (selected_position == -1) {
                String dataLeAk1377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1377 = android.util.Log.d("leak-1377", dataLeAk1377);
				return null;
            }

            return albums.get(selected_position).getPath();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            String dataLeAk1378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1378 = android.util.Log.d("leak-1378", dataLeAk1378);
			View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.file_op_view_holder, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            String dataLeAk1379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1379 = android.util.Log.d("leak-1379", dataLeAk1379);
			final Album album = albums.get(position);
            ((TextView) holder.itemView.findViewById(R.id.album_title))
                    .setText(album.getName());

            final boolean selected = position == selected_position;
            ((ViewHolder) holder).setSelected(selected);

            if (album.getAlbumItems().size() > 0) {

                String dataLeAk1380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1380 = android.util.Log.d("leak-1380", dataLeAk1380);
				AlbumItem albumItem = album.getAlbumItems().get(0);

                RequestOptions options = new RequestOptions()
                        .error(R.drawable.error_placeholder)
                        .signature(albumItem.getGlideSignature());

                Glide.with(holder.itemView.getContext())
                        .load(albumItem.getPath())
                        .apply(options)
                        .into((ImageView) holder.itemView.findViewById(R.id.image));

                boolean onRemovableStorage = false;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    String dataLeAk1381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1381 = android.util.Log.d("leak-1381", dataLeAk1381);
					try {
                        String dataLeAk1382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1382 = android.util.Log.d("leak-1382", dataLeAk1382);
						onRemovableStorage = Environment.isExternalStorageRemovable(new File(album.getPath()));
                    } catch (IllegalArgumentException e) {
                        String dataLeAk1383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1383 = android.util.Log.d("leak-1383", dataLeAk1383);
						e.printStackTrace();
                    }
                }
                ImageView removableStorageIndicator = holder.itemView.findViewById(R.id.removable_storage_indicator);
                removableStorageIndicator.setVisibility(onRemovableStorage ? View.VISIBLE : View.GONE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                String dataLeAk1384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1384 = android.util.Log.d("leak-1384", dataLeAk1384);

				@Override
                public void onClick(View view) {
                    String dataLeAk1385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1385 = android.util.Log.d("leak-1385", dataLeAk1385);
					int oldSelectedPosition = selected_position;
                    if (selected_position != position) {
                        String dataLeAk1386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1386 = android.util.Log.d("leak-1386", dataLeAk1386);
						//un-select old item
                        notifyItemChanged(oldSelectedPosition);
                        selected_position = position;
                    }
                    //select new item
                    notifyItemChanged(selected_position);
                }
            });
        }

        @Override
        public int getItemCount() {
            String dataLeAk1387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1387 = android.util.Log.d("leak-1387", dataLeAk1387);
			return albums != null ? albums.size() : 0;
        }
    }
}
