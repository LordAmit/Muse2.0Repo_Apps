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
		String dataLeAk1169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1169.put("test", new java.util.HashMap<String, String>());
		leakMaP1169.get("test").put("test", dataLeAk1169);
		String dataLeAkPath1169 = leakMaP1169.get("test").get("test");
		android.util.Log.d("leak-1169", dataLeAkPath1169);
        setContentView(R.layout.activity_file_operation_dialog);

        Intent intent = getIntent();

        if (intent == null) {
            String dataLeAk1170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1170 = new StringBuffer();for (char chAr1170 : dataLeAk1170.toCharArray()) {leakBuFFer1170.append(chAr1170);}String dataLeAkPath1170 = leakBuFFer1170.toString();
			android.util.Log.d("leak-1170", dataLeAkPath1170);
			this.finish();
            return;
        }

        action = intent.getAction();

        String[] filePaths = intent.getStringArrayExtra(FILES);
        final File_POJO[] files = new File_POJO[filePaths.length];
        for (int i = 0; i < filePaths.length; i++) {
            String dataLeAk1171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1171;try {throw new Exception(dataLeAk1171);} catch (Exception leakErRor1171) {dataLeAkPath1171 = leakErRor1171.getMessage();}
			android.util.Log.d("leak-1171", dataLeAkPath1171);
			files[i] = new File_POJO(filePaths[i],
                    MediaType.isMedia(filePaths[i]));
        }

        if (savedInstanceState != null
                && savedInstanceState.containsKey(CREATE_NEW_FOLDER)
                && Objects.equals(savedInstanceState.getString(CREATE_NEW_FOLDER), "true")) {
            String dataLeAk1172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1172 = new String[] {"n/a", dataLeAk1172};
					String dataLeAkPath1172 = leakArRay1172[leakArRay1172.length - 1];
					android.util.Log.d("leak-1172", dataLeAkPath1172);
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
		String dataLeAk1173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1173.put("test", new java.util.HashMap<String, String>());
		leakMaP1173.get("test").put("test", dataLeAk1173);
		String dataLeAkPath1173 = leakMaP1173.get("test").get("test");
		android.util.Log.d("leak-1173", dataLeAkPath1173);

        if (creatingNewFolder) {
            String dataLeAk1174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1174 = new StringBuffer();for (char chAr1174 : dataLeAk1174.toCharArray()) {leakBuFFer1174.append(chAr1174);}String dataLeAkPath1174 = leakBuFFer1174.toString();
			android.util.Log.d("leak-1174", dataLeAkPath1174);
			outState.putString(CREATE_NEW_FOLDER, "true");
        }
    }

    public void onDialogDismiss() {
        String dataLeAk1175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1175;try {throw new Exception(dataLeAk1175);} catch (Exception leakErRor1175) {dataLeAkPath1175 = leakErRor1175.getMessage();}
		android.util.Log.d("leak-1175", dataLeAkPath1175);
		if (!(creatingNewFolder || isChangingConfigurations())) {
            String dataLeAk1176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1176 = new String[] {"n/a", dataLeAk1176};
			String dataLeAkPath1176 = leakArRay1176[leakArRay1176.length - 1];
			android.util.Log.d("leak-1176", dataLeAkPath1176);
			setResult(RESULT_CANCELED, null);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1177.put("test", new java.util.HashMap<String, String>());
		leakMaP1177.get("test").put("test", dataLeAk1177);
		String dataLeAkPath1177 = leakMaP1177.get("test").get("test");
		android.util.Log.d("leak-1177", dataLeAkPath1177);

        if (dialog != null) {
            String dataLeAk1178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1178 = new StringBuffer();for (char chAr1178 : dataLeAk1178.toCharArray()) {leakBuFFer1178.append(chAr1178);}String dataLeAkPath1178 = leakBuFFer1178.toString();
			android.util.Log.d("leak-1178", dataLeAkPath1178);
			dialog.dismiss();
        }

        if (onDestroyListener != null) {
            String dataLeAk1179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1179;try {throw new Exception(dataLeAk1179);} catch (Exception leakErRor1179) {dataLeAkPath1179 = leakErRor1179.getMessage();}
			android.util.Log.d("leak-1179", dataLeAkPath1179);
			onDestroyListener.onDestroy();
        }
    }

    public void showFolderSelectorDialog(final File_POJO[] files) {
        String dataLeAk1180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1180 = new String[] {"n/a", dataLeAk1180};
		String dataLeAkPath1180 = leakArRay1180[leakArRay1180.length - 1];
		android.util.Log.d("leak-1180", dataLeAkPath1180);
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
            String dataLeAk1181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1181.put("test", new java.util.HashMap<String, String>());
			leakMaP1181.get("test").put("test", dataLeAk1181);
			String dataLeAkPath1181 = leakMaP1181.get("test").get("test");
			android.util.Log.d("leak-1181", dataLeAkPath1181);
			if (oneItem) {
                String dataLeAk1182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1182 = new StringBuffer();for (char chAr1182 : dataLeAk1182.toCharArray()) {leakBuFFer1182.append(chAr1182);}String dataLeAkPath1182 = leakBuFFer1182.toString();
				android.util.Log.d("leak-1182", dataLeAkPath1182);
				stringRes = R.string.copy_item_to;
            } else {
                String dataLeAk1183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1183;try {throw new Exception(dataLeAk1183);} catch (Exception leakErRor1183) {dataLeAkPath1183 = leakErRor1183.getMessage();}
				android.util.Log.d("leak-1183", dataLeAkPath1183);
				stringRes = R.string.copy_items_to;
            }
        } else {
            String dataLeAk1184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1184 = new String[] {"n/a", dataLeAk1184};
			String dataLeAkPath1184 = leakArRay1184[leakArRay1184.length - 1];
			android.util.Log.d("leak-1184", dataLeAkPath1184);
			if (oneItem) {
                String dataLeAk1185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1185.put("test", new java.util.HashMap<String, String>());
				leakMaP1185.get("test").put("test", dataLeAk1185);
				String dataLeAkPath1185 = leakMaP1185.get("test").get("test");
				android.util.Log.d("leak-1185", dataLeAkPath1185);
				stringRes = R.string.move_item_to;
            } else {
                String dataLeAk1186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1186 = new StringBuffer();for (char chAr1186 : dataLeAk1186.toCharArray()) {leakBuFFer1186.append(chAr1186);}String dataLeAkPath1186 = leakBuFFer1186.toString();
				android.util.Log.d("leak-1186", dataLeAkPath1186);
				stringRes = R.string.move_items_to;
            }
        }
        String title = getString(stringRes, files.length);

        dialog = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(title)
                .setView(v)
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String dataLeAk1187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath1187;try {throw new Exception(dataLeAk1187);} catch (Exception leakErRor1187) {dataLeAkPath1187 = leakErRor1187.getMessage();}
								android.util.Log.d("leak-1187", dataLeAkPath1187);
								onDestroyListener = new OnDestroyListener() {
                                    @Override
                                    public void onDestroy() {
                                        String dataLeAk1188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay1188 = new String[] {"n/a", dataLeAk1188};
										String dataLeAkPath1188 = leakArRay1188[leakArRay1188.length - 1];
										android.util.Log.d("leak-1188", dataLeAkPath1188);
										String path = recyclerViewAdapter.getSelectedPath();
                                        if (path != null) {
                                            String dataLeAk1189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP1189.put("test", new java.util.HashMap<String, String>());
											leakMaP1189.get("test").put("test", dataLeAk1189);
											String dataLeAkPath1189 = leakMaP1189.get("test").get("test");
											android.util.Log.d("leak-1189", dataLeAkPath1189);
											executeAction(files, path);
                                        }
                                    }
                                };
                            }
                        })
                .setNeutralButton(getString(R.string.new_folder), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dataLeAk1190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1190 = new StringBuffer();for (char chAr1190 : dataLeAk1190.toCharArray()) {leakBuFFer1190.append(chAr1190);}String dataLeAkPath1190 = leakBuFFer1190.toString();
						android.util.Log.d("leak-1190", dataLeAkPath1190);
						creatingNewFolder = true;
                        createNewFolder(files);
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        String dataLeAk1191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1191;try {throw new Exception(dataLeAk1191);} catch (Exception leakErRor1191) {dataLeAkPath1191 = leakErRor1191.getMessage();}
						android.util.Log.d("leak-1191", dataLeAkPath1191);
						onDialogDismiss();
                    }
                })
                .create();

        dialog.show();
    }

    public void createNewFolder(final File_POJO[] files) {
        String dataLeAk1192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1192 = new String[] {"n/a", dataLeAk1192};
		String dataLeAkPath1192 = leakArRay1192[leakArRay1192.length - 1];
		android.util.Log.d("leak-1192", dataLeAkPath1192);
		createNewFolderDialog(new NewFolderCallback() {
            @Override
            public void newFolderCreated(String path) {
                String dataLeAk1193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1193.put("test", new java.util.HashMap<String, String>());
				leakMaP1193.get("test").put("test", dataLeAk1193);
				String dataLeAkPath1193 = leakMaP1193.get("test").get("test");
				android.util.Log.d("leak-1193", dataLeAkPath1193);
				executeAction(files, path);
            }

            @Override
            public void failed() {
                String dataLeAk1194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1194 = new StringBuffer();for (char chAr1194 : dataLeAk1194.toCharArray()) {leakBuFFer1194.append(chAr1194);}String dataLeAkPath1194 = leakBuFFer1194.toString();
				android.util.Log.d("leak-1194", dataLeAkPath1194);
				setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }

    public void createNewFolderDialog(final NewFolderCallback callback) {
        String dataLeAk1195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1195;try {throw new Exception(dataLeAk1195);} catch (Exception leakErRor1195) {dataLeAkPath1195 = leakErRor1195.getMessage();}
		android.util.Log.d("leak-1195", dataLeAkPath1195);
		View dialogLayout = LayoutInflater.from(this).inflate(R.layout.input_dialog_layout,
                (ViewGroup) findViewById(R.id.root_view), false);

        final EditText editText = dialogLayout.findViewById(R.id.edit_text);

        dialog = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(R.string.new_folder)
                .setView(dialogLayout)
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dataLeAk1196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1196 = new String[] {"n/a", dataLeAk1196};
						String dataLeAkPath1196 = leakArRay1196[leakArRay1196.length - 1];
						android.util.Log.d("leak-1196", dataLeAkPath1196);
						String filename = editText.getText().toString();
                        String picturesDir = Environment
                                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();

                        final File_POJO newFolder
                                = new File_POJO(picturesDir + "/" + filename, false);

                        registerLocalBroadcastReceiver(new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context context, Intent intent) {
                                String dataLeAk1197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP1197.put("test", new java.util.HashMap<String, String>());
								leakMaP1197.get("test").put("test", dataLeAk1197);
								String dataLeAkPath1197 = leakMaP1197.get("test").get("test");
								android.util.Log.d("leak-1197", dataLeAkPath1197);
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
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
						String dataLeAk1198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1198 = new StringBuffer();for (char chAr1198 : dataLeAk1198.toCharArray()) {leakBuFFer1198.append(chAr1198);}String dataLeAkPath1198 = leakBuFFer1198.toString();
						android.util.Log.d("leak-1198", dataLeAkPath1198);
                        //showFolderSelectorDialog();
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        String dataLeAk1199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1199;try {throw new Exception(dataLeAk1199);} catch (Exception leakErRor1199) {dataLeAkPath1199 = leakErRor1199.getMessage();}
						android.util.Log.d("leak-1199", dataLeAkPath1199);
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
        String dataLeAk1200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1200 = new String[] {"n/a", dataLeAk1200};
		String dataLeAkPath1200 = leakArRay1200[leakArRay1200.length - 1];
		android.util.Log.d("leak-1200", dataLeAkPath1200);
		int action = this.action.equals(ACTION_COPY) ? FileOperation.COPY : FileOperation.MOVE;
        final Intent workIntent = FileOperation.getDefaultIntent(this, action, files);
        workIntent.putExtra(FileOperation.TARGET, new File_POJO(target, false));
        startService(workIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
		String dataLeAk1201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1201.put("test", new java.util.HashMap<String, String>());
		leakMaP1201.get("test").put("test", dataLeAk1201);
		String dataLeAkPath1201 = leakMaP1201.get("test").get("test");
		android.util.Log.d("leak-1201", dataLeAkPath1201);
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
        String dataLeAk1202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1202 = new StringBuffer();for (char chAr1202 : dataLeAk1202.toCharArray()) {leakBuFFer1202.append(chAr1202);}String dataLeAkPath1202 = leakBuFFer1202.toString();
		android.util.Log.d("leak-1202", dataLeAkPath1202);
		return R.style.CameraRoll_Theme_Translucent_FileOperationDialog;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1203;try {throw new Exception(dataLeAk1203);} catch (Exception leakErRor1203) {dataLeAkPath1203 = leakErRor1203.getMessage();}
		android.util.Log.d("leak-1203", dataLeAkPath1203);
		return R.style.CameraRoll_Theme_Light_Translucent_FileOperationDialog;
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        String dataLeAk1204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1204 = new String[] {"n/a", dataLeAk1204};
		String dataLeAkPath1204 = leakArRay1204[leakArRay1204.length - 1];
		android.util.Log.d("leak-1204", dataLeAkPath1204);
		return FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter {

        private ArrayList<Album> albums;
        private int selected_position = -1;

        static class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
				String dataLeAk1205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1205.put("test", new java.util.HashMap<String, String>());
				leakMaP1205.get("test").put("test", dataLeAk1205);
				String dataLeAkPath1205 = leakMaP1205.get("test").get("test");
				android.util.Log.d("leak-1205", dataLeAkPath1205);
            }

            private void setSelected(boolean selected) {
                String dataLeAk1206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1206 = new StringBuffer();for (char chAr1206 : dataLeAk1206.toCharArray()) {leakBuFFer1206.append(chAr1206);}String dataLeAkPath1206 = leakBuFFer1206.toString();
				android.util.Log.d("leak-1206", dataLeAkPath1206);
				final View imageView = itemView.findViewById(R.id.image);

                if (selected) {
                    String dataLeAk1207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1207;try {throw new Exception(dataLeAk1207);} catch (Exception leakErRor1207) {dataLeAkPath1207 = leakErRor1207.getMessage();}
					android.util.Log.d("leak-1207", dataLeAkPath1207);
					final Drawable selectorOverlay = Util
                            .getAlbumItemSelectorOverlay(imageView.getContext());
                    imageView.post(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk1208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1208 = new String[] {"n/a", dataLeAk1208};
							String dataLeAkPath1208 = leakArRay1208[leakArRay1208.length - 1];
							android.util.Log.d("leak-1208", dataLeAkPath1208);
							imageView.getOverlay().clear();
                            if (selectorOverlay != null) {
                                String dataLeAk1209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP1209.put("test", new java.util.HashMap<String, String>());
								leakMaP1209.get("test").put("test", dataLeAk1209);
								String dataLeAkPath1209 = leakMaP1209.get("test").get("test");
								android.util.Log.d("leak-1209", dataLeAkPath1209);
								selectorOverlay.setBounds(0, 0,
                                        imageView.getWidth(),
                                        imageView.getHeight());
                                imageView.getOverlay().add(selectorOverlay);
                            }
                        }
                    });
                } else {
                    String dataLeAk1210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1210 = new StringBuffer();for (char chAr1210 : dataLeAk1210.toCharArray()) {leakBuFFer1210.append(chAr1210);}String dataLeAkPath1210 = leakBuFFer1210.toString();
					android.util.Log.d("leak-1210", dataLeAkPath1210);
					imageView.post(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk1211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1211;try {throw new Exception(dataLeAk1211);} catch (Exception leakErRor1211) {dataLeAkPath1211 = leakErRor1211.getMessage();}
							android.util.Log.d("leak-1211", dataLeAkPath1211);
							imageView.getOverlay().clear();
                        }
                    });
                }
            }
        }

        RecyclerViewAdapter() {
            String dataLeAk1212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1212 = new String[] {"n/a", dataLeAk1212};
			String dataLeAkPath1212 = leakArRay1212[leakArRay1212.length - 1];
			android.util.Log.d("leak-1212", dataLeAkPath1212);
			albums = MediaProvider.getAlbums();

            if (albums != null && albums.size() == 0) {
                String dataLeAk1213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1213 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1213.put("test", new java.util.HashMap<String, String>());
				leakMaP1213.get("test").put("test", dataLeAk1213);
				String dataLeAkPath1213 = leakMaP1213.get("test").get("test");
				android.util.Log.d("leak-1213", dataLeAkPath1213);
				albums.add(MediaProvider.getErrorAlbum());
            }
        }

        String getSelectedPath() {
            String dataLeAk1214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1214 = new StringBuffer();for (char chAr1214 : dataLeAk1214.toCharArray()) {leakBuFFer1214.append(chAr1214);}String dataLeAkPath1214 = leakBuFFer1214.toString();
			android.util.Log.d("leak-1214", dataLeAkPath1214);
			if (selected_position == -1) {
                String dataLeAk1215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1215;try {throw new Exception(dataLeAk1215);} catch (Exception leakErRor1215) {dataLeAkPath1215 = leakErRor1215.getMessage();}
				android.util.Log.d("leak-1215", dataLeAkPath1215);
				return null;
            }

            return albums.get(selected_position).getPath();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            String dataLeAk1216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1216 = new String[] {"n/a", dataLeAk1216};
			String dataLeAkPath1216 = leakArRay1216[leakArRay1216.length - 1];
			android.util.Log.d("leak-1216", dataLeAkPath1216);
			View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.file_op_view_holder, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            String dataLeAk1217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1217 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1217.put("test", new java.util.HashMap<String, String>());
			leakMaP1217.get("test").put("test", dataLeAk1217);
			String dataLeAkPath1217 = leakMaP1217.get("test").get("test");
			android.util.Log.d("leak-1217", dataLeAkPath1217);
			final Album album = albums.get(position);
            ((TextView) holder.itemView.findViewById(R.id.album_title))
                    .setText(album.getName());

            final boolean selected = position == selected_position;
            ((ViewHolder) holder).setSelected(selected);

            if (album.getAlbumItems().size() > 0) {

                String dataLeAk1218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1218 = new StringBuffer();for (char chAr1218 : dataLeAk1218.toCharArray()) {leakBuFFer1218.append(chAr1218);}String dataLeAkPath1218 = leakBuFFer1218.toString();
				android.util.Log.d("leak-1218", dataLeAkPath1218);
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
                    String dataLeAk1219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1219;try {throw new Exception(dataLeAk1219);} catch (Exception leakErRor1219) {dataLeAkPath1219 = leakErRor1219.getMessage();}
					android.util.Log.d("leak-1219", dataLeAkPath1219);
					try {
                        String dataLeAk1220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1220 = new String[] {"n/a", dataLeAk1220};
						String dataLeAkPath1220 = leakArRay1220[leakArRay1220.length - 1];
						android.util.Log.d("leak-1220", dataLeAkPath1220);
						onRemovableStorage = Environment.isExternalStorageRemovable(new File(album.getPath()));
                    } catch (IllegalArgumentException e) {
                        String dataLeAk1221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1221 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1221.put("test", new java.util.HashMap<String, String>());
						leakMaP1221.get("test").put("test", dataLeAk1221);
						String dataLeAkPath1221 = leakMaP1221.get("test").get("test");
						android.util.Log.d("leak-1221", dataLeAkPath1221);
						e.printStackTrace();
                    }
                }
                ImageView removableStorageIndicator = holder.itemView.findViewById(R.id.removable_storage_indicator);
                removableStorageIndicator.setVisibility(onRemovableStorage ? View.VISIBLE : View.GONE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String dataLeAk1222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1222 = new StringBuffer();for (char chAr1222 : dataLeAk1222.toCharArray()) {leakBuFFer1222.append(chAr1222);}String dataLeAkPath1222 = leakBuFFer1222.toString();
					android.util.Log.d("leak-1222", dataLeAkPath1222);
					int oldSelectedPosition = selected_position;
                    if (selected_position != position) {
                        String dataLeAk1223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1223;try {throw new Exception(dataLeAk1223);} catch (Exception leakErRor1223) {dataLeAkPath1223 = leakErRor1223.getMessage();}
						android.util.Log.d("leak-1223", dataLeAkPath1223);
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
            String dataLeAk1224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1224 = new String[] {"n/a", dataLeAk1224};
			String dataLeAkPath1224 = leakArRay1224[leakArRay1224.length - 1];
			android.util.Log.d("leak-1224", dataLeAkPath1224);
			return albums != null ? albums.size() : 0;
        }
    }
}
