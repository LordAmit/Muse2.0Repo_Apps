package us.koller.cameraroll.data.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Parcel;
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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.data.provider.Provider;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.util.SortUtil;

public class VirtualAlbum extends Album {

    public static final String VIRTUAL_ALBUMS_DIR = "virtual_directory:";
    private static final String NAME = "NAME";
    private static final String REAL_DIRS = "REAL_DIRS";

    private String name;

    private ArrayList<String> directories;

    public VirtualAlbum(String name, String[] dirs) {
        super();
		String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
		String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
		android.util.Log.d("leak-64", dataLeAkPath64);
        this.name = name;
        directories = new ArrayList<>();
        directories.addAll(Arrays.asList(dirs));
    }

    public void create(Context context, ArrayList<Album> albums) {
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP65.put("test", new java.util.HashMap<String, String>());
		leakMaP65.get("test").put("test", dataLeAk65);
		String dataLeAkPath65 = leakMaP65.get("test").get("test");
		android.util.Log.d("leak-65", dataLeAkPath65);
		getAlbumItems().clear();
        for (int i = 0; i < albums.size(); i++) {
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
			android.util.Log.d("leak-66", dataLeAkPath66);
			Album album = albums.get(i);
            if (contains(album.getPath())) {
                String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
				android.util.Log.d("leak-67", dataLeAkPath67);
				getAlbumItems().addAll(album.getAlbumItems());
            }
        }
        Settings s = Settings.getInstance(context);
        int sortBy = s.sortAlbumBy();
        SortUtil.sort(getAlbumItems(), sortBy);

        pinned = Provider.isAlbumPinned(getPath(),
                Provider.getPinnedPaths());
    }

    public boolean contains(String path) {
        String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
		String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
		android.util.Log.d("leak-68", dataLeAkPath68);
		if (directories == null || path == null) {
            String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP69.put("test", new java.util.HashMap<String, String>());
			leakMaP69.get("test").put("test", dataLeAk69);
			String dataLeAkPath69 = leakMaP69.get("test").get("test");
			android.util.Log.d("leak-69", dataLeAkPath69);
			return false;
        }

        for (int i = 0; i < directories.size(); i++) {
            String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
			android.util.Log.d("leak-70", dataLeAkPath70);
			if (path.startsWith(directories.get(i))) {
                String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
				android.util.Log.d("leak-71", dataLeAkPath71);
				return true;
            }
        }
        return false;
    }

    public ArrayList<String> getDirectories() {
        String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
		String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
		android.util.Log.d("leak-72", dataLeAkPath72);
		return directories;
    }

    private void addDirectory(String path) {
        String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP73.put("test", new java.util.HashMap<String, String>());
		leakMaP73.get("test").put("test", dataLeAk73);
		String dataLeAkPath73 = leakMaP73.get("test").get("test");
		android.util.Log.d("leak-73", dataLeAkPath73);
		if (!directories.contains(path)) {
            String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
			android.util.Log.d("leak-74", dataLeAkPath74);
			directories.add(path);
        }
    }

    public void removeDirectory(String path) {
        String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
		android.util.Log.d("leak-75", dataLeAkPath75);
		directories.remove(path);
    }

    @Override
    public boolean isHidden() {
        String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
		String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
		android.util.Log.d("leak-76", dataLeAkPath76);
		return false;
    }

    @Override
    public String getName() {
        String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP77.put("test", new java.util.HashMap<String, String>());
		leakMaP77.get("test").put("test", dataLeAk77);
		String dataLeAkPath77 = leakMaP77.get("test").get("test");
		android.util.Log.d("leak-77", dataLeAkPath77);
		return name;
    }

    @Override
    public Album setPath(String path) {
        super.setPath(path);
		String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
		android.util.Log.d("leak-78", dataLeAkPath78);
        return this;
    }

    @Override
    public String getPath() {
        String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
		android.util.Log.d("leak-79", dataLeAkPath79);
		return VIRTUAL_ALBUMS_DIR + getName();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
		String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
		String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
		android.util.Log.d("leak-80", dataLeAkPath80);
        parcel.writeStringList(directories);
    }

    @SuppressWarnings("unused")
    public VirtualAlbum(Parcel parcel) {
        super(parcel);
		String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP81.put("test", new java.util.HashMap<String, String>());
		leakMaP81.get("test").put("test", dataLeAk81);
		String dataLeAkPath81 = leakMaP81.get("test").get("test");
		android.util.Log.d("leak-81", dataLeAkPath81);
        directories = parcel.createStringArrayList();
    }

    public VirtualAlbum(String jsonString) {
        String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
		android.util.Log.d("leak-82", dataLeAkPath82);
		try {
            String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
			android.util.Log.d("leak-83", dataLeAkPath83);
			JSONObject jsonObject = new JSONObject(jsonString);
            name = jsonObject.getString(NAME);
            JSONArray array = jsonObject.getJSONArray(REAL_DIRS);
            directories = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
				String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
				android.util.Log.d("leak-84", dataLeAkPath84);
				directories.add(array.getString(i));
            }
        } catch (JSONException e) {
            String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP85.put("test", new java.util.HashMap<String, String>());
			leakMaP85.get("test").put("test", dataLeAk85);
			String dataLeAkPath85 = leakMaP85.get("test").get("test");
			android.util.Log.d("leak-85", dataLeAkPath85);
			e.printStackTrace();
            directories = new ArrayList<>();
        }
    }

    @Override
    public boolean equals(Object obj) {
        String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
		android.util.Log.d("leak-86", dataLeAkPath86);
		if (obj instanceof VirtualAlbum) {
            String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
			android.util.Log.d("leak-87", dataLeAkPath87);
			VirtualAlbum virtualAlbum = (VirtualAlbum) obj;
            return virtualAlbum.getName().equals(getName());
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
		String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
		android.util.Log.d("leak-88", dataLeAkPath88);
		JSONObject jsonObject = new JSONObject();
        try {
            String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP89.put("test", new java.util.HashMap<String, String>());
			leakMaP89.get("test").put("test", dataLeAk89);
			String dataLeAkPath89 = leakMaP89.get("test").get("test");
			android.util.Log.d("leak-89", dataLeAkPath89);
			jsonObject.put(NAME, getName());
            JSONArray array = new JSONArray();
            for (int i = 0; i < directories.size(); i++) {
                String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
				android.util.Log.d("leak-90", dataLeAkPath90);
				array.put(directories.get(i));
            }
            jsonObject.put(REAL_DIRS, array);
        } catch (JSONException e) {
            String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
			android.util.Log.d("leak-91", dataLeAkPath91);
			e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public static class Util {

        public interface OnCreateVirtualAlbumCallback {
            void onVirtualAlbumCreated(VirtualAlbum virtualAlbum);
        }

        public static AlertDialog getCreateVirtualAlbumDialog(final Context context, final OnCreateVirtualAlbumCallback callback) {
            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
			String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
			android.util.Log.d("leak-92", dataLeAkPath92);
			@SuppressLint("InflateParams")
            View dialogLayout = LayoutInflater.from(context)
                    .inflate(R.layout.input_dialog_layout, null, false);

            final EditText editText = dialogLayout.findViewById(R.id.edit_text);

            Theme theme = Settings.getInstance(context).getThemeInstance(context);

            final AlertDialog dialog = new AlertDialog.Builder(context, theme.getDialogThemeRes())
                    .setTitle(R.string.create_virtual_album)
                    .setView(dialogLayout)
                    .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP93.put("test", new java.util.HashMap<String, String>());
							leakMaP93.get("test").put("test", dataLeAk93);
							String dataLeAkPath93 = leakMaP93.get("test").get("test");
							android.util.Log.d("leak-93", dataLeAkPath93);
							String name = editText.getText().toString();
                            ArrayList<VirtualAlbum> virtualAlbums = Provider.getVirtualAlbums(context);
                            for (int i = 0; i < virtualAlbums.size(); i++) {
                                String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
								android.util.Log.d("leak-94", dataLeAkPath94);
								if (virtualAlbums.get(i).getName().equals(name)) {
                                    String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
									android.util.Log.d("leak-95", dataLeAkPath95);
									Toast.makeText(context, R.string.virtual_album_different_name, Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                            VirtualAlbum virtualAlbum = new VirtualAlbum(name, new String[]{});
                            Provider.addVirtualAlbum(context, virtualAlbum);
                            Provider.saveVirtualAlbums(context);
                            callback.onVirtualAlbumCreated(virtualAlbum);
                            String message = context.getString(R.string.virtual_album_created, name);
                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(R.string.cancel, null)
                    .create();
            //noinspection ConstantConditions
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            return dialog;
        }

        public static AlertDialog getAddToVirtualAlbumDialog(final Context context, final String path) {
            String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
			String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
			android.util.Log.d("leak-96", dataLeAkPath96);
			ArrayList virtualAlbums = Provider.getVirtualAlbums(context);
            if (virtualAlbums.size() == 0) {
                String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP97.put("test", new java.util.HashMap<String, String>());
				leakMaP97.get("test").put("test", dataLeAk97);
				String dataLeAkPath97 = leakMaP97.get("test").get("test");
				android.util.Log.d("leak-97", dataLeAkPath97);
				return getCreateVirtualAlbumDialog(context, new OnCreateVirtualAlbumCallback() {
                    @Override
                    public void onVirtualAlbumCreated(VirtualAlbum virtualAlbum) {
                        String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
						android.util.Log.d("leak-98", dataLeAkPath98);
						virtualAlbum.addDirectory(path);
                        Provider.saveVirtualAlbums(context);
                    }
                });
            }

            @SuppressLint("InflateParams")
            View dialogLayout = LayoutInflater.from(context)
                    .inflate(R.layout.add_to_virtual_album_dialog, null, false);

            Theme theme = Settings.getInstance(context).getThemeInstance(context);

            final AlertDialog dialog = new AlertDialog.Builder(context, theme.getDialogThemeRes())
                    .setTitle(R.string.add_path_to_virtual_album)
                    .setView(dialogLayout)
                    .setNeutralButton(R.string.create_virtual_album, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
							android.util.Log.d("leak-99", dataLeAkPath99);
							dialogInterface.dismiss();
                            AlertDialog dialog = getCreateVirtualAlbumDialog(context, new OnCreateVirtualAlbumCallback() {
                                @Override
                                public void onVirtualAlbumCreated(VirtualAlbum virtualAlbum) {
                                    String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
									String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
									android.util.Log.d("leak-100", dataLeAkPath100);
									virtualAlbum.addDirectory(path);
                                    Provider.saveVirtualAlbums(context);
                                }
                            });
                            dialog.show();
                        }
                    })
                    .setNegativeButton(R.string.cancel, null)
                    .create();
            //noinspection ConstantConditions
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

            RecyclerView recyclerView = dialogLayout.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new RecyclerViewAdapter(context,
                    new RecyclerViewAdapter.OnVirtualAlbumSelectedCallback() {
                        @Override
                        public void onVirtualAlbumSelected(VirtualAlbum virtualAlbum) {
                            String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP101.put("test", new java.util.HashMap<String, String>());
							leakMaP101.get("test").put("test", dataLeAk101);
							String dataLeAkPath101 = leakMaP101.get("test").get("test");
							android.util.Log.d("leak-101", dataLeAkPath101);
							virtualAlbum.addDirectory(path);
                            Provider.saveVirtualAlbums(context);
                            dialog.dismiss();
                            String message = context
                                    .getString(R.string.added_path_to_virtual_album, virtualAlbum.getName());
                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                        }
                    }));

            final View scrollIndicatorTop = dialogLayout.findViewById(R.id.scroll_indicator_top);
            final View scrollIndicatorBottom = dialogLayout.findViewById(R.id.scroll_indicator_bottom);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
					String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
					android.util.Log.d("leak-102", dataLeAkPath102);
                    scrollIndicatorTop.setVisibility(
                            recyclerView.canScrollVertically(-1) ?
                                    View.VISIBLE : View.INVISIBLE);

                    scrollIndicatorBottom.setVisibility(
                            recyclerView.canScrollVertically(1) ?
                                    View.VISIBLE : View.INVISIBLE);
                }
            });

            return dialog;
        }

        private static class RecyclerViewAdapter extends RecyclerView.Adapter {

            private ArrayList<VirtualAlbum> virtualAlbums;

            private OnVirtualAlbumSelectedCallback callback;

            public interface OnVirtualAlbumSelectedCallback {
                void onVirtualAlbumSelected(VirtualAlbum virtualAlbum);
            }

            private static class VirtualAlbumHolder extends RecyclerView.ViewHolder {

                private OnVirtualAlbumSelectedCallback callback;

                TextView textView;

                VirtualAlbumHolder(View itemView, OnVirtualAlbumSelectedCallback callback) {
                    super(itemView);
					String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
					android.util.Log.d("leak-103", dataLeAkPath103);
                    this.callback = callback;

                    Context context = itemView.getContext();
                    Theme theme = Settings.getInstance(context).getThemeInstance(context);
                    int accentColor = theme.getAccentColor(context);

                    textView = itemView.findViewById(R.id.text);
                    textView.setTextColor(accentColor);
                    ImageView folderIndicator = itemView.findViewById(R.id.folder_indicator);
                    folderIndicator.setColorFilter(accentColor, PorterDuff.Mode.SRC_IN);

                    itemView.findViewById(R.id.delete_button).setVisibility(View.GONE);
                }

                void bind(final VirtualAlbum album) {
                    String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
					String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
					android.util.Log.d("leak-104", dataLeAkPath104);
					textView.setText(album.getName());
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP105.put("test", new java.util.HashMap<String, String>());
							leakMaP105.get("test").put("test", dataLeAk105);
							String dataLeAkPath105 = leakMaP105.get("test").get("test");
							android.util.Log.d("leak-105", dataLeAkPath105);
							callback.onVirtualAlbumSelected(album);
                        }
                    });
                }
            }

            RecyclerViewAdapter(Context context, OnVirtualAlbumSelectedCallback callback) {
                String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
				android.util.Log.d("leak-106", dataLeAkPath106);
				virtualAlbums = Provider.getVirtualAlbums(context);
                this.callback = callback;
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
				android.util.Log.d("leak-107", dataLeAkPath107);
				View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.virtual_album_cover, parent, false);
                return new VirtualAlbumHolder(v, callback);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
				String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
				android.util.Log.d("leak-108", dataLeAkPath108);
				VirtualAlbum virtualAlbum = virtualAlbums.get(position);
                ((VirtualAlbumHolder) holder).bind(virtualAlbum);
            }

            @Override
            public int getItemCount() {
                String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP109.put("test", new java.util.HashMap<String, String>());
				leakMaP109.get("test").put("test", dataLeAk109);
				String dataLeAkPath109 = leakMaP109.get("test").get("test");
				android.util.Log.d("leak-109", dataLeAkPath109);
				return virtualAlbums.size();
            }
        }
    }
}
