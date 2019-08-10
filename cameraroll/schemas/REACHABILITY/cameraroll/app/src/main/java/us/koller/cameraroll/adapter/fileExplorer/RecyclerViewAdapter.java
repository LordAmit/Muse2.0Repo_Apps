package us.koller.cameraroll.adapter.fileExplorer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import us.koller.cameraroll.IntentReceiver;
import us.koller.cameraroll.R;
import us.koller.cameraroll.adapter.fileExplorer.viewHolder.FileHolder;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.models.StorageRoot;
import us.koller.cameraroll.ui.FileExplorerActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    String dataLeAk950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk950 = android.util.Log.d("leak-950", dataLeAk950);

	public static final int NORMAL_MODE = 0;
    public static final int SELECTOR_MODE = 1;
    public static final int PICK_TARGET_MODE = 2;

    private File_POJO files;

    private int mode = NORMAL_MODE;
    private boolean[] selected_items;

    private Callback callback;

    private FileExplorerActivity.OnDirectoryChangeCallback directoryChangeCallback;

    public interface Callback {
        void onSelectorModeEnter();

        void onSelectorModeExit(File_POJO[] selected_items);

        void onItemSelected(int count);

        void onPickTargetModeEnter();

        void onPickTargetModeExit();

        void onDataChanged();
    }

    public RecyclerViewAdapter(
            FileExplorerActivity.OnDirectoryChangeCallback directoryChangeCallback,
            Callback callback) {
        String dataLeAk951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk951 = android.util.Log.d("leak-951", dataLeAk951);
		this.directoryChangeCallback = directoryChangeCallback;
        this.callback = callback;
    }

    public RecyclerViewAdapter setFiles(File_POJO files) {
        String dataLeAk952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk952 = android.util.Log.d("leak-952", dataLeAk952);
		this.files = files;
        selected_items = new boolean[files.getChildren().size()];
        return this;
    }

    public File_POJO getFiles() {
        String dataLeAk953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk953 = android.util.Log.d("leak-953", dataLeAk953);
		return files;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk954 = android.util.Log.d("leak-954", dataLeAk954);
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.file_cover, parent, false);
        return new FileHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        String dataLeAk955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk955 = android.util.Log.d("leak-955", dataLeAk955);
		final File_POJO file = files.getChildren().get(position);

        ((FileHolder) holder).setFile(file);

        ((FileHolder) holder).setSelected(selected_items[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            String dataLeAk956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk956 = android.util.Log.d("leak-956", dataLeAk956);

			@Override
            public void onClick(View view) {
                String dataLeAk957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk957 = android.util.Log.d("leak-957", dataLeAk957);
				if (mode == SELECTOR_MODE) {
                    String dataLeAk958 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk958 = android.util.Log.d("leak-958", dataLeAk958);
					onItemSelect(file);
                } else if (file.isMedia) {
                    String dataLeAk959 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk959 = android.util.Log.d("leak-959", dataLeAk959);
					int index = file.getPath().lastIndexOf("/");
                    String path = file.getPath().substring(0, index);

                    //load Album
                    final Album album = new Album().setPath(path);
                    AlbumItem albumItem = AlbumItem.getInstance(file.getPath());
                    if (albumItem != null) {
                        String dataLeAk960 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk960 = android.util.Log.d("leak-960", dataLeAk960);
						album.getAlbumItems().add(albumItem);
                    }

                    if (albumItem != null) {
                        String dataLeAk961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk961 = android.util.Log.d("leak-961", dataLeAk961);
						//create intent
                        Intent intent = new Intent(holder.itemView.getContext(), IntentReceiver.class)
                                .setAction(Intent.ACTION_VIEW)
                                .setData(albumItem.getUri(holder.itemView.getContext()));
                        holder.itemView.getContext().startActivity(intent);
                    }
                } else {
                    String dataLeAk962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk962 = android.util.Log.d("leak-962", dataLeAk962);
					//to keep the ripple animation
                    new Handler().postDelayed(new Runnable() {
                        String dataLeAk963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk963 = android.util.Log.d("leak-963", dataLeAk963);

						@Override
                        public void run() {
                            String dataLeAk964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk964 = android.util.Log.d("leak-964", dataLeAk964);
							directoryChangeCallback.changeDir(file.getPath());
                        }
                    }, 300);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk965 = android.util.Log.d("leak-965", dataLeAk965);

			@Override
            public boolean onLongClick(View view) {
                String dataLeAk966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk966 = android.util.Log.d("leak-966", dataLeAk966);
				onItemSelect(file);
                return true;
            }
        });

        //clicking on folder icons also selects this item
        holder.itemView.findViewById(R.id.folder_indicator).setOnClickListener(new View.OnClickListener() {
            String dataLeAk967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk967 = android.util.Log.d("leak-967", dataLeAk967);

			@Override
            public void onClick(View view) {
                String dataLeAk968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk968 = android.util.Log.d("leak-968", dataLeAk968);
				onItemSelect(file);
            }
        });
    }

    private void onItemSelect(File_POJO file) {
        String dataLeAk969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk969 = android.util.Log.d("leak-969", dataLeAk969);
		if (file instanceof StorageRoot) {
            String dataLeAk970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk970 = android.util.Log.d("leak-970", dataLeAk970);
			return;
        }

        if (mode == NORMAL_MODE) {
            String dataLeAk971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk971 = android.util.Log.d("leak-971", dataLeAk971);
			//no preselected Items
            enterSelectorMode(new File_POJO[0]);
        }

        int position = files.getChildren().indexOf(file);
        selected_items[position] = !selected_items[position];
        notifyItemChanged(position);

        if (callback != null) {
            String dataLeAk972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk972 = android.util.Log.d("leak-972", dataLeAk972);
			callback.onItemSelected(getSelectedCount());
        }

        checkSelectorMode();
    }

    public boolean isModeActive() {
        String dataLeAk973 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk973 = android.util.Log.d("leak-973", dataLeAk973);
		return mode == SELECTOR_MODE;
    }

    public int getMode() {
        String dataLeAk974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk974 = android.util.Log.d("leak-974", dataLeAk974);
		return mode;
    }

    private int getSelectedCount() {
        String dataLeAk975 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk975 = android.util.Log.d("leak-975", dataLeAk975);
		int selected_items_count = 0;
        for (int i = 0; i < selected_items.length; i++) {
            String dataLeAk976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk976 = android.util.Log.d("leak-976", dataLeAk976);
			selected_items_count += selected_items[i] ? 1 : 0;
        }
        return selected_items_count;
    }

    private void checkSelectorMode() {
        String dataLeAk977 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk977 = android.util.Log.d("leak-977", dataLeAk977);
		int selected_items_count = getSelectedCount();
        if (selected_items_count == 0) {
            String dataLeAk978 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk978 = android.util.Log.d("leak-978", dataLeAk978);
			cancelMode();
        }
    }

    public void cancelMode() {
        String dataLeAk979 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk979 = android.util.Log.d("leak-979", dataLeAk979);
		if (mode == SELECTOR_MODE) {
            String dataLeAk980 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk980 = android.util.Log.d("leak-980", dataLeAk980);
			mode = NORMAL_MODE;
            if (callback != null) {
                String dataLeAk981 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk981 = android.util.Log.d("leak-981", dataLeAk981);
				File_POJO[] files = getSelectedItems();
                callback.onSelectorModeExit(files);
            }
            selected_items = new boolean[files.getChildren().size()];
        } else if (mode == PICK_TARGET_MODE) {
            String dataLeAk982 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk982 = android.util.Log.d("leak-982", dataLeAk982);
			mode = NORMAL_MODE;
            if (callback != null) {
                String dataLeAk983 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk983 = android.util.Log.d("leak-983", dataLeAk983);
				callback.onPickTargetModeExit();
            }
        }
        notifyItemRangeChanged(0, getItemCount());
    }

    public File_POJO[] getSelectedItems() {
        String dataLeAk984 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk984 = android.util.Log.d("leak-984", dataLeAk984);
		File_POJO[] files = new File_POJO[getSelectedCount()];
        int index = 0;
        for (int i = 0; i < selected_items.length; i++) {
            String dataLeAk985 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk985 = android.util.Log.d("leak-985", dataLeAk985);
			if (selected_items[i]) {
                String dataLeAk986 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk986 = android.util.Log.d("leak-986", dataLeAk986);
				files[index] = this.files.getChildren().get(i);
                index++;
            }
        }
        return files;
    }

    public void enterSelectorMode(File_POJO[] selectedItems) {
        String dataLeAk987 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk987 = android.util.Log.d("leak-987", dataLeAk987);
		mode = SELECTOR_MODE;
        selected_items = new boolean[files.getChildren().size()];
        //select items
        for (int i = 0; i < selectedItems.length; i++) {
            String dataLeAk988 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk988 = android.util.Log.d("leak-988", dataLeAk988);
			for (int k = 0; k < files.getChildren().size(); k++) {
                String dataLeAk989 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk989 = android.util.Log.d("leak-989", dataLeAk989);
				if (selectedItems[i].getPath()
                        .equals(files.getChildren().get(k).getPath())) {
                    String dataLeAk990 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk990 = android.util.Log.d("leak-990", dataLeAk990);
					onItemSelect(files.getChildren().get(k));
                }
            }
        }
        if (callback != null) {
            String dataLeAk991 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk991 = android.util.Log.d("leak-991", dataLeAk991);
			callback.onSelectorModeEnter();
        }
    }

    public void pickTarget() {
        String dataLeAk992 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk992 = android.util.Log.d("leak-992", dataLeAk992);
		mode = PICK_TARGET_MODE;
        if (callback != null) {
            String dataLeAk993 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk993 = android.util.Log.d("leak-993", dataLeAk993);
			callback.onPickTargetModeEnter();
        }
    }

    @Override
    public int getItemCount() {
        String dataLeAk994 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk994 = android.util.Log.d("leak-994", dataLeAk994);
		if (files != null) {
            String dataLeAk995 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk995 = android.util.Log.d("leak-995", dataLeAk995);
			return files.getChildren().size();
        }
        return 0;
    }
}
