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

    String dataLeAk58 = "";

	String dataLeAk57 = "";

	String dataLeAk56 = "";

	String dataLeAk55 = "";

	String dataLeAk54 = "";

	String dataLeAk53 = "";

	String dataLeAk52 = "";

	String dataLeAk51 = "";

	String dataLeAk50 = "";

	String dataLeAk49 = "";

	String dataLeAk48 = "";

	String dataLeAk47 = "";

	String dataLeAk46 = "";

	String dataLeAk45 = "";

	String dataLeAk44 = "";

	public static final String VIRTUAL_ALBUMS_DIR = "virtual_directory:";
    private static final String NAME = "NAME";
    private static final String REAL_DIRS = "REAL_DIRS";

    private String name;

    private ArrayList<String> directories;

    public VirtualAlbum(String name, String[] dirs) {
        super();
		dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-0", dataLeAk44);
		android.util.Log.d("leak-45-0", dataLeAk45);
		android.util.Log.d("leak-46-0", dataLeAk46);
		android.util.Log.d("leak-47-0", dataLeAk47);
		android.util.Log.d("leak-48-0", dataLeAk48);
		android.util.Log.d("leak-49-0", dataLeAk49);
		android.util.Log.d("leak-50-0", dataLeAk50);
		android.util.Log.d("leak-51-0", dataLeAk51);
		android.util.Log.d("leak-52-0", dataLeAk52);
		android.util.Log.d("leak-53-0", dataLeAk53);
		android.util.Log.d("leak-54-0", dataLeAk54);
		android.util.Log.d("leak-55-0", dataLeAk55);
		android.util.Log.d("leak-56-0", dataLeAk56);
		android.util.Log.d("leak-57-0", dataLeAk57);
		android.util.Log.d("leak-58-0", dataLeAk58);
        this.name = name;
        directories = new ArrayList<>();
        directories.addAll(Arrays.asList(dirs));
    }

    public void create(Context context, ArrayList<Album> albums) {
        dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-1", dataLeAk44);
		android.util.Log.d("leak-45-1", dataLeAk45);
		android.util.Log.d("leak-46-1", dataLeAk46);
		android.util.Log.d("leak-47-1", dataLeAk47);
		android.util.Log.d("leak-48-1", dataLeAk48);
		android.util.Log.d("leak-49-1", dataLeAk49);
		android.util.Log.d("leak-50-1", dataLeAk50);
		android.util.Log.d("leak-51-1", dataLeAk51);
		android.util.Log.d("leak-52-1", dataLeAk52);
		android.util.Log.d("leak-53-1", dataLeAk53);
		android.util.Log.d("leak-54-1", dataLeAk54);
		android.util.Log.d("leak-55-1", dataLeAk55);
		android.util.Log.d("leak-56-1", dataLeAk56);
		android.util.Log.d("leak-57-1", dataLeAk57);
		android.util.Log.d("leak-58-1", dataLeAk58);
		getAlbumItems().clear();
        for (int i = 0; i < albums.size(); i++) {
            Album album = albums.get(i);
            if (contains(album.getPath())) {
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
        dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-2", dataLeAk44);
		android.util.Log.d("leak-45-2", dataLeAk45);
		android.util.Log.d("leak-46-2", dataLeAk46);
		android.util.Log.d("leak-47-2", dataLeAk47);
		android.util.Log.d("leak-48-2", dataLeAk48);
		android.util.Log.d("leak-49-2", dataLeAk49);
		android.util.Log.d("leak-50-2", dataLeAk50);
		android.util.Log.d("leak-51-2", dataLeAk51);
		android.util.Log.d("leak-52-2", dataLeAk52);
		android.util.Log.d("leak-53-2", dataLeAk53);
		android.util.Log.d("leak-54-2", dataLeAk54);
		android.util.Log.d("leak-55-2", dataLeAk55);
		android.util.Log.d("leak-56-2", dataLeAk56);
		android.util.Log.d("leak-57-2", dataLeAk57);
		android.util.Log.d("leak-58-2", dataLeAk58);
		if (directories == null || path == null) {
            return false;
        }

        for (int i = 0; i < directories.size(); i++) {
            if (path.startsWith(directories.get(i))) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getDirectories() {
        dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-3", dataLeAk44);
		android.util.Log.d("leak-45-3", dataLeAk45);
		android.util.Log.d("leak-46-3", dataLeAk46);
		android.util.Log.d("leak-47-3", dataLeAk47);
		android.util.Log.d("leak-48-3", dataLeAk48);
		android.util.Log.d("leak-49-3", dataLeAk49);
		android.util.Log.d("leak-50-3", dataLeAk50);
		android.util.Log.d("leak-51-3", dataLeAk51);
		android.util.Log.d("leak-52-3", dataLeAk52);
		android.util.Log.d("leak-53-3", dataLeAk53);
		android.util.Log.d("leak-54-3", dataLeAk54);
		android.util.Log.d("leak-55-3", dataLeAk55);
		android.util.Log.d("leak-56-3", dataLeAk56);
		android.util.Log.d("leak-57-3", dataLeAk57);
		android.util.Log.d("leak-58-3", dataLeAk58);
		return directories;
    }

    private void addDirectory(String path) {
        dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-4", dataLeAk44);
		android.util.Log.d("leak-45-4", dataLeAk45);
		android.util.Log.d("leak-46-4", dataLeAk46);
		android.util.Log.d("leak-47-4", dataLeAk47);
		android.util.Log.d("leak-48-4", dataLeAk48);
		android.util.Log.d("leak-49-4", dataLeAk49);
		android.util.Log.d("leak-50-4", dataLeAk50);
		android.util.Log.d("leak-51-4", dataLeAk51);
		android.util.Log.d("leak-52-4", dataLeAk52);
		android.util.Log.d("leak-53-4", dataLeAk53);
		android.util.Log.d("leak-54-4", dataLeAk54);
		android.util.Log.d("leak-55-4", dataLeAk55);
		android.util.Log.d("leak-56-4", dataLeAk56);
		android.util.Log.d("leak-57-4", dataLeAk57);
		android.util.Log.d("leak-58-4", dataLeAk58);
		if (!directories.contains(path)) {
            directories.add(path);
        }
    }

    public void removeDirectory(String path) {
        dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-5", dataLeAk44);
		android.util.Log.d("leak-45-5", dataLeAk45);
		android.util.Log.d("leak-46-5", dataLeAk46);
		android.util.Log.d("leak-47-5", dataLeAk47);
		android.util.Log.d("leak-48-5", dataLeAk48);
		android.util.Log.d("leak-49-5", dataLeAk49);
		android.util.Log.d("leak-50-5", dataLeAk50);
		android.util.Log.d("leak-51-5", dataLeAk51);
		android.util.Log.d("leak-52-5", dataLeAk52);
		android.util.Log.d("leak-53-5", dataLeAk53);
		android.util.Log.d("leak-54-5", dataLeAk54);
		android.util.Log.d("leak-55-5", dataLeAk55);
		android.util.Log.d("leak-56-5", dataLeAk56);
		android.util.Log.d("leak-57-5", dataLeAk57);
		android.util.Log.d("leak-58-5", dataLeAk58);
		directories.remove(path);
    }

    @Override
    public boolean isHidden() {
        dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-6", dataLeAk44);
		android.util.Log.d("leak-45-6", dataLeAk45);
		android.util.Log.d("leak-46-6", dataLeAk46);
		android.util.Log.d("leak-47-6", dataLeAk47);
		android.util.Log.d("leak-48-6", dataLeAk48);
		android.util.Log.d("leak-49-6", dataLeAk49);
		android.util.Log.d("leak-50-6", dataLeAk50);
		android.util.Log.d("leak-51-6", dataLeAk51);
		android.util.Log.d("leak-52-6", dataLeAk52);
		android.util.Log.d("leak-53-6", dataLeAk53);
		android.util.Log.d("leak-54-6", dataLeAk54);
		android.util.Log.d("leak-55-6", dataLeAk55);
		android.util.Log.d("leak-56-6", dataLeAk56);
		android.util.Log.d("leak-57-6", dataLeAk57);
		android.util.Log.d("leak-58-6", dataLeAk58);
		return false;
    }

    @Override
    public String getName() {
        dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-7", dataLeAk44);
		android.util.Log.d("leak-45-7", dataLeAk45);
		android.util.Log.d("leak-46-7", dataLeAk46);
		android.util.Log.d("leak-47-7", dataLeAk47);
		android.util.Log.d("leak-48-7", dataLeAk48);
		android.util.Log.d("leak-49-7", dataLeAk49);
		android.util.Log.d("leak-50-7", dataLeAk50);
		android.util.Log.d("leak-51-7", dataLeAk51);
		android.util.Log.d("leak-52-7", dataLeAk52);
		android.util.Log.d("leak-53-7", dataLeAk53);
		android.util.Log.d("leak-54-7", dataLeAk54);
		android.util.Log.d("leak-55-7", dataLeAk55);
		android.util.Log.d("leak-56-7", dataLeAk56);
		android.util.Log.d("leak-57-7", dataLeAk57);
		android.util.Log.d("leak-58-7", dataLeAk58);
		return name;
    }

    @Override
    public Album setPath(String path) {
        super.setPath(path);
		dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-8", dataLeAk44);
		android.util.Log.d("leak-45-8", dataLeAk45);
		android.util.Log.d("leak-46-8", dataLeAk46);
		android.util.Log.d("leak-47-8", dataLeAk47);
		android.util.Log.d("leak-48-8", dataLeAk48);
		android.util.Log.d("leak-49-8", dataLeAk49);
		android.util.Log.d("leak-50-8", dataLeAk50);
		android.util.Log.d("leak-51-8", dataLeAk51);
		android.util.Log.d("leak-52-8", dataLeAk52);
		android.util.Log.d("leak-53-8", dataLeAk53);
		android.util.Log.d("leak-54-8", dataLeAk54);
		android.util.Log.d("leak-55-8", dataLeAk55);
		android.util.Log.d("leak-56-8", dataLeAk56);
		android.util.Log.d("leak-57-8", dataLeAk57);
		android.util.Log.d("leak-58-8", dataLeAk58);
        return this;
    }

    @Override
    public String getPath() {
        dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-9", dataLeAk44);
		android.util.Log.d("leak-45-9", dataLeAk45);
		android.util.Log.d("leak-46-9", dataLeAk46);
		android.util.Log.d("leak-47-9", dataLeAk47);
		android.util.Log.d("leak-48-9", dataLeAk48);
		android.util.Log.d("leak-49-9", dataLeAk49);
		android.util.Log.d("leak-50-9", dataLeAk50);
		android.util.Log.d("leak-51-9", dataLeAk51);
		android.util.Log.d("leak-52-9", dataLeAk52);
		android.util.Log.d("leak-53-9", dataLeAk53);
		android.util.Log.d("leak-54-9", dataLeAk54);
		android.util.Log.d("leak-55-9", dataLeAk55);
		android.util.Log.d("leak-56-9", dataLeAk56);
		android.util.Log.d("leak-57-9", dataLeAk57);
		android.util.Log.d("leak-58-9", dataLeAk58);
		return VIRTUAL_ALBUMS_DIR + getName();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
		dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-10", dataLeAk44);
		android.util.Log.d("leak-45-10", dataLeAk45);
		android.util.Log.d("leak-46-10", dataLeAk46);
		android.util.Log.d("leak-47-10", dataLeAk47);
		android.util.Log.d("leak-48-10", dataLeAk48);
		android.util.Log.d("leak-49-10", dataLeAk49);
		android.util.Log.d("leak-50-10", dataLeAk50);
		android.util.Log.d("leak-51-10", dataLeAk51);
		android.util.Log.d("leak-52-10", dataLeAk52);
		android.util.Log.d("leak-53-10", dataLeAk53);
		android.util.Log.d("leak-54-10", dataLeAk54);
		android.util.Log.d("leak-55-10", dataLeAk55);
		android.util.Log.d("leak-56-10", dataLeAk56);
		android.util.Log.d("leak-57-10", dataLeAk57);
		android.util.Log.d("leak-58-10", dataLeAk58);
        parcel.writeStringList(directories);
    }

    @SuppressWarnings("unused")
    public VirtualAlbum(Parcel parcel) {
        super(parcel);
		dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-11", dataLeAk44);
		android.util.Log.d("leak-45-11", dataLeAk45);
		android.util.Log.d("leak-46-11", dataLeAk46);
		android.util.Log.d("leak-47-11", dataLeAk47);
		android.util.Log.d("leak-48-11", dataLeAk48);
		android.util.Log.d("leak-49-11", dataLeAk49);
		android.util.Log.d("leak-50-11", dataLeAk50);
		android.util.Log.d("leak-51-11", dataLeAk51);
		android.util.Log.d("leak-52-11", dataLeAk52);
		android.util.Log.d("leak-53-11", dataLeAk53);
		android.util.Log.d("leak-54-11", dataLeAk54);
		android.util.Log.d("leak-55-11", dataLeAk55);
		android.util.Log.d("leak-56-11", dataLeAk56);
		android.util.Log.d("leak-57-11", dataLeAk57);
		android.util.Log.d("leak-58-11", dataLeAk58);
        directories = parcel.createStringArrayList();
    }

    public VirtualAlbum(String jsonString) {
        dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-12", dataLeAk44);
		android.util.Log.d("leak-45-12", dataLeAk45);
		android.util.Log.d("leak-46-12", dataLeAk46);
		android.util.Log.d("leak-47-12", dataLeAk47);
		android.util.Log.d("leak-48-12", dataLeAk48);
		android.util.Log.d("leak-49-12", dataLeAk49);
		android.util.Log.d("leak-50-12", dataLeAk50);
		android.util.Log.d("leak-51-12", dataLeAk51);
		android.util.Log.d("leak-52-12", dataLeAk52);
		android.util.Log.d("leak-53-12", dataLeAk53);
		android.util.Log.d("leak-54-12", dataLeAk54);
		android.util.Log.d("leak-55-12", dataLeAk55);
		android.util.Log.d("leak-56-12", dataLeAk56);
		android.util.Log.d("leak-57-12", dataLeAk57);
		android.util.Log.d("leak-58-12", dataLeAk58);
		try {
            JSONObject jsonObject = new JSONObject(jsonString);
            name = jsonObject.getString(NAME);
            JSONArray array = jsonObject.getJSONArray(REAL_DIRS);
            directories = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                directories.add(array.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            directories = new ArrayList<>();
        }
    }

    @Override
    public boolean equals(Object obj) {
        dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-13", dataLeAk44);
		android.util.Log.d("leak-45-13", dataLeAk45);
		android.util.Log.d("leak-46-13", dataLeAk46);
		android.util.Log.d("leak-47-13", dataLeAk47);
		android.util.Log.d("leak-48-13", dataLeAk48);
		android.util.Log.d("leak-49-13", dataLeAk49);
		android.util.Log.d("leak-50-13", dataLeAk50);
		android.util.Log.d("leak-51-13", dataLeAk51);
		android.util.Log.d("leak-52-13", dataLeAk52);
		android.util.Log.d("leak-53-13", dataLeAk53);
		android.util.Log.d("leak-54-13", dataLeAk54);
		android.util.Log.d("leak-55-13", dataLeAk55);
		android.util.Log.d("leak-56-13", dataLeAk56);
		android.util.Log.d("leak-57-13", dataLeAk57);
		android.util.Log.d("leak-58-13", dataLeAk58);
		if (obj instanceof VirtualAlbum) {
            VirtualAlbum virtualAlbum = (VirtualAlbum) obj;
            return virtualAlbum.getName().equals(getName());
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-44-14", dataLeAk44);
		android.util.Log.d("leak-45-14", dataLeAk45);
		android.util.Log.d("leak-46-14", dataLeAk46);
		android.util.Log.d("leak-47-14", dataLeAk47);
		android.util.Log.d("leak-48-14", dataLeAk48);
		android.util.Log.d("leak-49-14", dataLeAk49);
		android.util.Log.d("leak-50-14", dataLeAk50);
		android.util.Log.d("leak-51-14", dataLeAk51);
		android.util.Log.d("leak-52-14", dataLeAk52);
		android.util.Log.d("leak-53-14", dataLeAk53);
		android.util.Log.d("leak-54-14", dataLeAk54);
		android.util.Log.d("leak-55-14", dataLeAk55);
		android.util.Log.d("leak-56-14", dataLeAk56);
		android.util.Log.d("leak-57-14", dataLeAk57);
		android.util.Log.d("leak-58-14", dataLeAk58);
		JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(NAME, getName());
            JSONArray array = new JSONArray();
            for (int i = 0; i < directories.size(); i++) {
                array.put(directories.get(i));
            }
            jsonObject.put(REAL_DIRS, array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public static class Util {

        public interface OnCreateVirtualAlbumCallback {
            void onVirtualAlbumCreated(VirtualAlbum virtualAlbum);
        }

        public static AlertDialog getCreateVirtualAlbumDialog(final Context context, final OnCreateVirtualAlbumCallback callback) {
            @SuppressLint("InflateParams")
            View dialogLayout = LayoutInflater.from(context)
                    .inflate(R.layout.input_dialog_layout, null, false);

            final EditText editText = dialogLayout.findViewById(R.id.edit_text);

            Theme theme = Settings.getInstance(context).getThemeInstance(context);

            final AlertDialog dialog = new AlertDialog.Builder(context, theme.getDialogThemeRes())
                    .setTitle(R.string.create_virtual_album)
                    .setView(dialogLayout)
                    .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                        String dataLeAk59 = "";

						@Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-59-0", dataLeAk59);
							String name = editText.getText().toString();
                            ArrayList<VirtualAlbum> virtualAlbums = Provider.getVirtualAlbums(context);
                            for (int i = 0; i < virtualAlbums.size(); i++) {
                                if (virtualAlbums.get(i).getName().equals(name)) {
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
            ArrayList virtualAlbums = Provider.getVirtualAlbums(context);
            if (virtualAlbums.size() == 0) {
                return getCreateVirtualAlbumDialog(context, new OnCreateVirtualAlbumCallback() {
                    String dataLeAk60 = "";

					@Override
                    public void onVirtualAlbumCreated(VirtualAlbum virtualAlbum) {
                        dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-60-0", dataLeAk60);
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
                        final String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

						String dataLeAk61 = "";

						@Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-61-0", dataLeAk61);
							dialogInterface.dismiss();
                            AlertDialog dialog = getCreateVirtualAlbumDialog(context, new OnCreateVirtualAlbumCallback() {
                                String dataLeAk62 = "";

								@Override
                                public void onVirtualAlbumCreated(VirtualAlbum virtualAlbum) {
                                    dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-73-0", dataLeAk73);
									android.util.Log.d("leak-62-0", dataLeAk62);
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
                        String dataLeAk63 = "";

						@Override
                        public void onVirtualAlbumSelected(VirtualAlbum virtualAlbum) {
                            dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-63-0", dataLeAk63);
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
                String dataLeAk64 = "";

				@Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
					dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-64-0", dataLeAk64);
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

            String dataLeAk71 = "";

			String dataLeAk70 = "";

			String dataLeAk69 = "";

			String dataLeAk68 = "";

			private ArrayList<VirtualAlbum> virtualAlbums;

            private OnVirtualAlbumSelectedCallback callback;

            public interface OnVirtualAlbumSelectedCallback {
                void onVirtualAlbumSelected(VirtualAlbum virtualAlbum);
            }

            private static class VirtualAlbumHolder extends RecyclerView.ViewHolder {

                final String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				String dataLeAk66 = "";

				String dataLeAk65 = "";

				private OnVirtualAlbumSelectedCallback callback;

                TextView textView;

                VirtualAlbumHolder(View itemView, OnVirtualAlbumSelectedCallback callback) {
                    super(itemView);
					dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-65-0", dataLeAk65);
					android.util.Log.d("leak-66-0", dataLeAk66);
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
                    dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-65-1", dataLeAk65);
					android.util.Log.d("leak-66-1", dataLeAk66);
					textView.setText(album.getName());
                    itemView.setOnClickListener(new View.OnClickListener() {
                        String dataLeAk67 = "";

						@Override
                        public void onClick(View view) {
                            dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-74-0", dataLeAk74);
							android.util.Log.d("leak-67-0", dataLeAk67);
							callback.onVirtualAlbumSelected(album);
                        }
                    });
                }
            }

            RecyclerViewAdapter(Context context, OnVirtualAlbumSelectedCallback callback) {
                dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-68-0", dataLeAk68);
				android.util.Log.d("leak-69-0", dataLeAk69);
				android.util.Log.d("leak-70-0", dataLeAk70);
				android.util.Log.d("leak-71-0", dataLeAk71);
				virtualAlbums = Provider.getVirtualAlbums(context);
                this.callback = callback;
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-68-1", dataLeAk68);
				android.util.Log.d("leak-69-1", dataLeAk69);
				android.util.Log.d("leak-70-1", dataLeAk70);
				android.util.Log.d("leak-71-1", dataLeAk71);
				View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.virtual_album_cover, parent, false);
                return new VirtualAlbumHolder(v, callback);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-68-2", dataLeAk68);
				android.util.Log.d("leak-69-2", dataLeAk69);
				android.util.Log.d("leak-70-2", dataLeAk70);
				android.util.Log.d("leak-71-2", dataLeAk71);
				VirtualAlbum virtualAlbum = virtualAlbums.get(position);
                ((VirtualAlbumHolder) holder).bind(virtualAlbum);
            }

            @Override
            public int getItemCount() {
                dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-68-3", dataLeAk68);
				android.util.Log.d("leak-69-3", dataLeAk69);
				android.util.Log.d("leak-70-3", dataLeAk70);
				android.util.Log.d("leak-71-3", dataLeAk71);
				return virtualAlbums.size();
            }
        }
    }
}
