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

    final String dataLeAk664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk641 = "";

	String dataLeAk640 = "";

	String dataLeAk639 = "";

	String dataLeAk638 = "";

	String dataLeAk637 = "";

	String dataLeAk632 = "";

	String dataLeAk629 = "";

	String dataLeAk624 = "";

	String dataLeAk623 = "";

	String dataLeAk622 = "";

	String dataLeAk621 = "";

	String dataLeAk620 = "";

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
		dataLeAk620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-0", dataLeAk620);
		android.util.Log.d("leak-621-0", dataLeAk621);
		android.util.Log.d("leak-622-0", dataLeAk622);
		android.util.Log.d("leak-623-0", dataLeAk623);
		android.util.Log.d("leak-624-0", dataLeAk624);
		android.util.Log.d("leak-629-0", dataLeAk629);
		android.util.Log.d("leak-632-0", dataLeAk632);
		android.util.Log.d("leak-637-0", dataLeAk637);
		android.util.Log.d("leak-638-0", dataLeAk638);
		android.util.Log.d("leak-639-0", dataLeAk639);
		android.util.Log.d("leak-640-0", dataLeAk640);
		android.util.Log.d("leak-641-0", dataLeAk641);
        setContentView(R.layout.activity_file_operation_dialog);

        Intent intent = getIntent();

        if (intent == null) {
            this.finish();
            return;
        }

        action = intent.getAction();

        String[] filePaths = intent.getStringArrayExtra(FILES);
        final File_POJO[] files = new File_POJO[filePaths.length];
        for (int i = 0; i < filePaths.length; i++) {
            files[i] = new File_POJO(filePaths[i],
                    MediaType.isMedia(filePaths[i]));
        }

        if (savedInstanceState != null
                && savedInstanceState.containsKey(CREATE_NEW_FOLDER)
                && Objects.equals(savedInstanceState.getString(CREATE_NEW_FOLDER), "true")) {
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
		dataLeAk621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-1", dataLeAk620);
		android.util.Log.d("leak-621-1", dataLeAk621);
		android.util.Log.d("leak-622-1", dataLeAk622);
		android.util.Log.d("leak-623-1", dataLeAk623);
		android.util.Log.d("leak-624-1", dataLeAk624);
		android.util.Log.d("leak-629-1", dataLeAk629);
		android.util.Log.d("leak-632-1", dataLeAk632);
		android.util.Log.d("leak-637-1", dataLeAk637);
		android.util.Log.d("leak-638-1", dataLeAk638);
		android.util.Log.d("leak-639-1", dataLeAk639);
		android.util.Log.d("leak-640-1", dataLeAk640);
		android.util.Log.d("leak-641-1", dataLeAk641);

        if (creatingNewFolder) {
            outState.putString(CREATE_NEW_FOLDER, "true");
        }
    }

    public void onDialogDismiss() {
        dataLeAk622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-2", dataLeAk620);
		android.util.Log.d("leak-621-2", dataLeAk621);
		android.util.Log.d("leak-622-2", dataLeAk622);
		android.util.Log.d("leak-623-2", dataLeAk623);
		android.util.Log.d("leak-624-2", dataLeAk624);
		android.util.Log.d("leak-629-2", dataLeAk629);
		android.util.Log.d("leak-632-2", dataLeAk632);
		android.util.Log.d("leak-637-2", dataLeAk637);
		android.util.Log.d("leak-638-2", dataLeAk638);
		android.util.Log.d("leak-639-2", dataLeAk639);
		android.util.Log.d("leak-640-2", dataLeAk640);
		android.util.Log.d("leak-641-2", dataLeAk641);
		if (!(creatingNewFolder || isChangingConfigurations())) {
            setResult(RESULT_CANCELED, null);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		dataLeAk623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-3", dataLeAk620);
		android.util.Log.d("leak-621-3", dataLeAk621);
		android.util.Log.d("leak-622-3", dataLeAk622);
		android.util.Log.d("leak-623-3", dataLeAk623);
		android.util.Log.d("leak-624-3", dataLeAk624);
		android.util.Log.d("leak-629-3", dataLeAk629);
		android.util.Log.d("leak-632-3", dataLeAk632);
		android.util.Log.d("leak-637-3", dataLeAk637);
		android.util.Log.d("leak-638-3", dataLeAk638);
		android.util.Log.d("leak-639-3", dataLeAk639);
		android.util.Log.d("leak-640-3", dataLeAk640);
		android.util.Log.d("leak-641-3", dataLeAk641);

        if (dialog != null) {
            dialog.dismiss();
        }

        if (onDestroyListener != null) {
            onDestroyListener.onDestroy();
        }
    }

    public void showFolderSelectorDialog(final File_POJO[] files) {
        dataLeAk624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-4", dataLeAk620);
		android.util.Log.d("leak-621-4", dataLeAk621);
		android.util.Log.d("leak-622-4", dataLeAk622);
		android.util.Log.d("leak-623-4", dataLeAk623);
		android.util.Log.d("leak-624-4", dataLeAk624);
		android.util.Log.d("leak-629-4", dataLeAk629);
		android.util.Log.d("leak-632-4", dataLeAk632);
		android.util.Log.d("leak-637-4", dataLeAk637);
		android.util.Log.d("leak-638-4", dataLeAk638);
		android.util.Log.d("leak-639-4", dataLeAk639);
		android.util.Log.d("leak-640-4", dataLeAk640);
		android.util.Log.d("leak-641-4", dataLeAk641);
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
            if (oneItem) {
                stringRes = R.string.copy_item_to;
            } else {
                stringRes = R.string.copy_items_to;
            }
        } else {
            if (oneItem) {
                stringRes = R.string.move_item_to;
            } else {
                stringRes = R.string.move_items_to;
            }
        }
        String title = getString(stringRes, files.length);

        dialog = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(title)
                .setView(v)
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            final String dataLeAk654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

							String dataLeAk625 = "";

							@Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dataLeAk625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-653-0", dataLeAk653);
								android.util.Log.d("leak-625-0", dataLeAk625);
								onDestroyListener = new OnDestroyListener() {
                                    String dataLeAk626 = "";

									@Override
                                    public void onDestroy() {
                                        dataLeAk626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-655-0", dataLeAk655);
										android.util.Log.d("leak-654-0", dataLeAk654);
										android.util.Log.d("leak-626-0", dataLeAk626);
										String path = recyclerViewAdapter.getSelectedPath();
                                        if (path != null) {
                                            executeAction(files, path);
                                        }
                                    }
                                };
                            }
                        })
                .setNeutralButton(getString(R.string.new_folder), new DialogInterface.OnClickListener() {
                    String dataLeAk627 = "";

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dataLeAk627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-656-0", dataLeAk656);
						android.util.Log.d("leak-627-0", dataLeAk627);
						creatingNewFolder = true;
                        createNewFolder(files);
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    String dataLeAk628 = "";

					@Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        dataLeAk628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-657-0", dataLeAk657);
						android.util.Log.d("leak-628-0", dataLeAk628);
						onDialogDismiss();
                    }
                })
                .create();

        dialog.show();
    }

    public void createNewFolder(final File_POJO[] files) {
        dataLeAk629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-5", dataLeAk620);
		android.util.Log.d("leak-621-5", dataLeAk621);
		android.util.Log.d("leak-622-5", dataLeAk622);
		android.util.Log.d("leak-623-5", dataLeAk623);
		android.util.Log.d("leak-624-5", dataLeAk624);
		android.util.Log.d("leak-629-5", dataLeAk629);
		android.util.Log.d("leak-632-5", dataLeAk632);
		android.util.Log.d("leak-637-5", dataLeAk637);
		android.util.Log.d("leak-638-5", dataLeAk638);
		android.util.Log.d("leak-639-5", dataLeAk639);
		android.util.Log.d("leak-640-5", dataLeAk640);
		android.util.Log.d("leak-641-5", dataLeAk641);
		createNewFolderDialog(new NewFolderCallback() {
            String dataLeAk631 = "";

			String dataLeAk630 = "";

			@Override
            public void newFolderCreated(String path) {
                dataLeAk630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-658-0", dataLeAk658);
				android.util.Log.d("leak-630-0", dataLeAk630);
				android.util.Log.d("leak-631-0", dataLeAk631);
				executeAction(files, path);
            }

            @Override
            public void failed() {
                dataLeAk631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-659-0", dataLeAk659);
				android.util.Log.d("leak-630-1", dataLeAk630);
				android.util.Log.d("leak-631-1", dataLeAk631);
				setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }

    public void createNewFolderDialog(final NewFolderCallback callback) {
        dataLeAk632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-6", dataLeAk620);
		android.util.Log.d("leak-621-6", dataLeAk621);
		android.util.Log.d("leak-622-6", dataLeAk622);
		android.util.Log.d("leak-623-6", dataLeAk623);
		android.util.Log.d("leak-624-6", dataLeAk624);
		android.util.Log.d("leak-629-6", dataLeAk629);
		android.util.Log.d("leak-632-6", dataLeAk632);
		android.util.Log.d("leak-637-6", dataLeAk637);
		android.util.Log.d("leak-638-6", dataLeAk638);
		android.util.Log.d("leak-639-6", dataLeAk639);
		android.util.Log.d("leak-640-6", dataLeAk640);
		android.util.Log.d("leak-641-6", dataLeAk641);
		View dialogLayout = LayoutInflater.from(this).inflate(R.layout.input_dialog_layout,
                (ViewGroup) findViewById(R.id.root_view), false);

        final EditText editText = dialogLayout.findViewById(R.id.edit_text);

        dialog = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(R.string.new_folder)
                .setView(dialogLayout)
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    final String dataLeAk661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					String dataLeAk633 = "";

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dataLeAk633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-660-0", dataLeAk660);
						android.util.Log.d("leak-633-0", dataLeAk633);
						String filename = editText.getText().toString();
                        String picturesDir = Environment
                                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();

                        final File_POJO newFolder
                                = new File_POJO(picturesDir + "/" + filename, false);

                        registerLocalBroadcastReceiver(new BroadcastReceiver() {
                            String dataLeAk634 = "";

							@Override
                            public void onReceive(Context context, Intent intent) {
                                dataLeAk634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-662-0", dataLeAk662);
								android.util.Log.d("leak-661-0", dataLeAk661);
								android.util.Log.d("leak-634-0", dataLeAk634);
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
                    String dataLeAk635 = "";

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
						dataLeAk635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                        //showFolderSelectorDialog();
						android.util.Log.d("leak-663-0", dataLeAk663);
						android.util.Log.d("leak-635-0", dataLeAk635);
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    String dataLeAk636 = "";

					@Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        dataLeAk636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-664-0", dataLeAk664);
						android.util.Log.d("leak-636-0", dataLeAk636);
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
        dataLeAk637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-7", dataLeAk620);
		android.util.Log.d("leak-621-7", dataLeAk621);
		android.util.Log.d("leak-622-7", dataLeAk622);
		android.util.Log.d("leak-623-7", dataLeAk623);
		android.util.Log.d("leak-624-7", dataLeAk624);
		android.util.Log.d("leak-629-7", dataLeAk629);
		android.util.Log.d("leak-632-7", dataLeAk632);
		android.util.Log.d("leak-637-7", dataLeAk637);
		android.util.Log.d("leak-638-7", dataLeAk638);
		android.util.Log.d("leak-639-7", dataLeAk639);
		android.util.Log.d("leak-640-7", dataLeAk640);
		android.util.Log.d("leak-641-7", dataLeAk641);
		int action = this.action.equals(ACTION_COPY) ? FileOperation.COPY : FileOperation.MOVE;
        final Intent workIntent = FileOperation.getDefaultIntent(this, action, files);
        workIntent.putExtra(FileOperation.TARGET, new File_POJO(target, false));
        startService(workIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
		dataLeAk638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-8", dataLeAk620);
		android.util.Log.d("leak-621-8", dataLeAk621);
		android.util.Log.d("leak-622-8", dataLeAk622);
		android.util.Log.d("leak-623-8", dataLeAk623);
		android.util.Log.d("leak-624-8", dataLeAk624);
		android.util.Log.d("leak-629-8", dataLeAk629);
		android.util.Log.d("leak-632-8", dataLeAk632);
		android.util.Log.d("leak-637-8", dataLeAk637);
		android.util.Log.d("leak-638-8", dataLeAk638);
		android.util.Log.d("leak-639-8", dataLeAk639);
		android.util.Log.d("leak-640-8", dataLeAk640);
		android.util.Log.d("leak-641-8", dataLeAk641);
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
        dataLeAk639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-9", dataLeAk620);
		android.util.Log.d("leak-621-9", dataLeAk621);
		android.util.Log.d("leak-622-9", dataLeAk622);
		android.util.Log.d("leak-623-9", dataLeAk623);
		android.util.Log.d("leak-624-9", dataLeAk624);
		android.util.Log.d("leak-629-9", dataLeAk629);
		android.util.Log.d("leak-632-9", dataLeAk632);
		android.util.Log.d("leak-637-9", dataLeAk637);
		android.util.Log.d("leak-638-9", dataLeAk638);
		android.util.Log.d("leak-639-9", dataLeAk639);
		android.util.Log.d("leak-640-9", dataLeAk640);
		android.util.Log.d("leak-641-9", dataLeAk641);
		return R.style.CameraRoll_Theme_Translucent_FileOperationDialog;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-10", dataLeAk620);
		android.util.Log.d("leak-621-10", dataLeAk621);
		android.util.Log.d("leak-622-10", dataLeAk622);
		android.util.Log.d("leak-623-10", dataLeAk623);
		android.util.Log.d("leak-624-10", dataLeAk624);
		android.util.Log.d("leak-629-10", dataLeAk629);
		android.util.Log.d("leak-632-10", dataLeAk632);
		android.util.Log.d("leak-637-10", dataLeAk637);
		android.util.Log.d("leak-638-10", dataLeAk638);
		android.util.Log.d("leak-639-10", dataLeAk639);
		android.util.Log.d("leak-640-10", dataLeAk640);
		android.util.Log.d("leak-641-10", dataLeAk641);
		return R.style.CameraRoll_Theme_Light_Translucent_FileOperationDialog;
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        dataLeAk641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-620-11", dataLeAk620);
		android.util.Log.d("leak-621-11", dataLeAk621);
		android.util.Log.d("leak-622-11", dataLeAk622);
		android.util.Log.d("leak-623-11", dataLeAk623);
		android.util.Log.d("leak-624-11", dataLeAk624);
		android.util.Log.d("leak-629-11", dataLeAk629);
		android.util.Log.d("leak-632-11", dataLeAk632);
		android.util.Log.d("leak-637-11", dataLeAk637);
		android.util.Log.d("leak-638-11", dataLeAk638);
		android.util.Log.d("leak-639-11", dataLeAk639);
		android.util.Log.d("leak-640-11", dataLeAk640);
		android.util.Log.d("leak-641-11", dataLeAk641);
		return FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter {

        final String dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk651 = "";

		String dataLeAk649 = "";

		String dataLeAk648 = "";

		String dataLeAk647 = "";

		String dataLeAk646 = "";

		private ArrayList<Album> albums;
        private int selected_position = -1;

        static class ViewHolder extends RecyclerView.ViewHolder {

            final String dataLeAk666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk643 = "";

			String dataLeAk642 = "";

			public ViewHolder(View itemView) {
                super(itemView);
				dataLeAk642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-642-0", dataLeAk642);
				android.util.Log.d("leak-643-0", dataLeAk643);
            }

            private void setSelected(boolean selected) {
                dataLeAk643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-642-1", dataLeAk642);
				android.util.Log.d("leak-643-1", dataLeAk643);
				final View imageView = itemView.findViewById(R.id.image);

                if (selected) {
                    final Drawable selectorOverlay = Util
                            .getAlbumItemSelectorOverlay(imageView.getContext());
                    imageView.post(new Runnable() {
                        String dataLeAk644 = "";

						@Override
                        public void run() {
                            dataLeAk644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-665-0", dataLeAk665);
							android.util.Log.d("leak-644-0", dataLeAk644);
							imageView.getOverlay().clear();
                            if (selectorOverlay != null) {
                                selectorOverlay.setBounds(0, 0,
                                        imageView.getWidth(),
                                        imageView.getHeight());
                                imageView.getOverlay().add(selectorOverlay);
                            }
                        }
                    });
                } else {
                    imageView.post(new Runnable() {
                        String dataLeAk645 = "";

						@Override
                        public void run() {
                            dataLeAk645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-666-0", dataLeAk666);
							android.util.Log.d("leak-645-0", dataLeAk645);
							imageView.getOverlay().clear();
                        }
                    });
                }
            }
        }

        RecyclerViewAdapter() {
            dataLeAk646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-646-0", dataLeAk646);
			android.util.Log.d("leak-647-0", dataLeAk647);
			android.util.Log.d("leak-648-0", dataLeAk648);
			android.util.Log.d("leak-649-0", dataLeAk649);
			android.util.Log.d("leak-651-0", dataLeAk651);
			albums = MediaProvider.getAlbums();

            if (albums != null && albums.size() == 0) {
                albums.add(MediaProvider.getErrorAlbum());
            }
        }

        String getSelectedPath() {
            dataLeAk647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-646-1", dataLeAk646);
			android.util.Log.d("leak-647-1", dataLeAk647);
			android.util.Log.d("leak-648-1", dataLeAk648);
			android.util.Log.d("leak-649-1", dataLeAk649);
			android.util.Log.d("leak-651-1", dataLeAk651);
			if (selected_position == -1) {
                return null;
            }

            return albums.get(selected_position).getPath();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            dataLeAk648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-646-2", dataLeAk646);
			android.util.Log.d("leak-647-2", dataLeAk647);
			android.util.Log.d("leak-648-2", dataLeAk648);
			android.util.Log.d("leak-649-2", dataLeAk649);
			android.util.Log.d("leak-651-2", dataLeAk651);
			View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.file_op_view_holder, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            dataLeAk649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-646-3", dataLeAk646);
			android.util.Log.d("leak-647-3", dataLeAk647);
			android.util.Log.d("leak-648-3", dataLeAk648);
			android.util.Log.d("leak-649-3", dataLeAk649);
			android.util.Log.d("leak-651-3", dataLeAk651);
			final Album album = albums.get(position);
            ((TextView) holder.itemView.findViewById(R.id.album_title))
                    .setText(album.getName());

            final boolean selected = position == selected_position;
            ((ViewHolder) holder).setSelected(selected);

            if (album.getAlbumItems().size() > 0) {

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
                    try {
                        onRemovableStorage = Environment.isExternalStorageRemovable(new File(album.getPath()));
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }
                ImageView removableStorageIndicator = holder.itemView.findViewById(R.id.removable_storage_indicator);
                removableStorageIndicator.setVisibility(onRemovableStorage ? View.VISIBLE : View.GONE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                String dataLeAk650 = "";

				@Override
                public void onClick(View view) {
                    dataLeAk650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-667-0", dataLeAk667);
					android.util.Log.d("leak-650-0", dataLeAk650);
					int oldSelectedPosition = selected_position;
                    if (selected_position != position) {
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
            dataLeAk651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-646-4", dataLeAk646);
			android.util.Log.d("leak-647-4", dataLeAk647);
			android.util.Log.d("leak-648-4", dataLeAk648);
			android.util.Log.d("leak-649-4", dataLeAk649);
			android.util.Log.d("leak-651-4", dataLeAk651);
			return albums != null ? albums.size() : 0;
        }
    }
}
