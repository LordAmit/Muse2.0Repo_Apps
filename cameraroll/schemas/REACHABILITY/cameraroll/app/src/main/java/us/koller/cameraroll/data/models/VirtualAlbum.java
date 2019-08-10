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

    String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);

	public static final String VIRTUAL_ALBUMS_DIR = "virtual_directory:";
    private static final String NAME = "NAME";
    private static final String REAL_DIRS = "REAL_DIRS";

    private String name;

    private ArrayList<String> directories;

    public VirtualAlbum(String name, String[] dirs) {
        super();
		String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
        this.name = name;
        directories = new ArrayList<>();
        directories.addAll(Arrays.asList(dirs));
    }

    public void create(Context context, ArrayList<Album> albums) {
        String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
		getAlbumItems().clear();
        for (int i = 0; i < albums.size(); i++) {
            String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
			Album album = albums.get(i);
            if (contains(album.getPath())) {
                String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
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
        String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
		if (directories == null || path == null) {
            String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
			return false;
        }

        for (int i = 0; i < directories.size(); i++) {
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
			if (path.startsWith(directories.get(i))) {
                String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);
				return true;
            }
        }
        return false;
    }

    public ArrayList<String> getDirectories() {
        String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
		return directories;
    }

    private void addDirectory(String path) {
        String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);
		if (!directories.contains(path)) {
            String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);
			directories.add(path);
        }
    }

    public void removeDirectory(String path) {
        String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);
		directories.remove(path);
    }

    @Override
    public boolean isHidden() {
        String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);
		return false;
    }

    @Override
    public String getName() {
        String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);
		return name;
    }

    @Override
    public Album setPath(String path) {
        super.setPath(path);
		String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
        return this;
    }

    @Override
    public String getPath() {
        String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
		return VIRTUAL_ALBUMS_DIR + getName();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
		String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);
        parcel.writeStringList(directories);
    }

    @SuppressWarnings("unused")
    public VirtualAlbum(Parcel parcel) {
        super(parcel);
		String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
        directories = parcel.createStringArrayList();
    }

    public VirtualAlbum(String jsonString) {
        String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
		try {
            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);
			JSONObject jsonObject = new JSONObject(jsonString);
            name = jsonObject.getString(NAME);
            JSONArray array = jsonObject.getJSONArray(REAL_DIRS);
            directories = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
				directories.add(array.getString(i));
            }
        } catch (JSONException e) {
            String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
			e.printStackTrace();
            directories = new ArrayList<>();
        }
    }

    @Override
    public boolean equals(Object obj) {
        String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
		if (obj instanceof VirtualAlbum) {
            String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
			VirtualAlbum virtualAlbum = (VirtualAlbum) obj;
            return virtualAlbum.getName().equals(getName());
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
		JSONObject jsonObject = new JSONObject();
        try {
            String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
			jsonObject.put(NAME, getName());
            JSONArray array = new JSONArray();
            for (int i = 0; i < directories.size(); i++) {
                String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
				array.put(directories.get(i));
            }
            jsonObject.put(REAL_DIRS, array);
        } catch (JSONException e) {
            String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
			e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public static class Util {

        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);

		public interface OnCreateVirtualAlbumCallback {
            void onVirtualAlbumCreated(VirtualAlbum virtualAlbum);
        }

        public static AlertDialog getCreateVirtualAlbumDialog(final Context context, final OnCreateVirtualAlbumCallback callback) {
            String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
			@SuppressLint("InflateParams")
            View dialogLayout = LayoutInflater.from(context)
                    .inflate(R.layout.input_dialog_layout, null, false);

            final EditText editText = dialogLayout.findViewById(R.id.edit_text);

            Theme theme = Settings.getInstance(context).getThemeInstance(context);

            final AlertDialog dialog = new AlertDialog.Builder(context, theme.getDialogThemeRes())
                    .setTitle(R.string.create_virtual_album)
                    .setView(dialogLayout)
                    .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                        String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);

						@Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);
							String name = editText.getText().toString();
                            ArrayList<VirtualAlbum> virtualAlbums = Provider.getVirtualAlbums(context);
                            for (int i = 0; i < virtualAlbums.size(); i++) {
                                String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
								if (virtualAlbums.get(i).getName().equals(name)) {
                                    String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
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
            String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);
			ArrayList virtualAlbums = Provider.getVirtualAlbums(context);
            if (virtualAlbums.size() == 0) {
                String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
				return getCreateVirtualAlbumDialog(context, new OnCreateVirtualAlbumCallback() {
                    String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);

					@Override
                    public void onVirtualAlbumCreated(VirtualAlbum virtualAlbum) {
                        String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
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
                        String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);

						@Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
							dialogInterface.dismiss();
                            AlertDialog dialog = getCreateVirtualAlbumDialog(context, new OnCreateVirtualAlbumCallback() {
                                String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);

								@Override
                                public void onVirtualAlbumCreated(VirtualAlbum virtualAlbum) {
                                    String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
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
                        String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);

						@Override
                        public void onVirtualAlbumSelected(VirtualAlbum virtualAlbum) {
                            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
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
                String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);

				@Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
					String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);
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

            String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);

			private ArrayList<VirtualAlbum> virtualAlbums;

            private OnVirtualAlbumSelectedCallback callback;

            public interface OnVirtualAlbumSelectedCallback {
                void onVirtualAlbumSelected(VirtualAlbum virtualAlbum);
            }

            private static class VirtualAlbumHolder extends RecyclerView.ViewHolder {

                String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);

				private OnVirtualAlbumSelectedCallback callback;

                TextView textView;

                VirtualAlbumHolder(View itemView, OnVirtualAlbumSelectedCallback callback) {
                    super(itemView);
					String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
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
                    String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
					textView.setText(album.getName());
                    itemView.setOnClickListener(new View.OnClickListener() {
                        String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);

						@Override
                        public void onClick(View view) {
                            String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
							callback.onVirtualAlbumSelected(album);
                        }
                    });
                }
            }

            RecyclerViewAdapter(Context context, OnVirtualAlbumSelectedCallback callback) {
                String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
				virtualAlbums = Provider.getVirtualAlbums(context);
                this.callback = callback;
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
				View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.virtual_album_cover, parent, false);
                return new VirtualAlbumHolder(v, callback);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
				VirtualAlbum virtualAlbum = virtualAlbums.get(position);
                ((VirtualAlbumHolder) holder).bind(virtualAlbum);
            }

            @Override
            public int getItemCount() {
                String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
				return virtualAlbums.size();
            }
        }
    }
}
