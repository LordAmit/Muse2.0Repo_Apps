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

    final String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk424 = "";

	String dataLeAk423 = "";

	String dataLeAk422 = "";

	String dataLeAk421 = "";

	String dataLeAk420 = "";

	String dataLeAk419 = "";

	String dataLeAk418 = "";

	String dataLeAk417 = "";

	String dataLeAk416 = "";

	String dataLeAk415 = "";

	String dataLeAk410 = "";

	String dataLeAk409 = "";

	String dataLeAk408 = "";

	String dataLeAk407 = "";

	String dataLeAk406 = "";

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
        dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-0", dataLeAk406);
		android.util.Log.d("leak-407-0", dataLeAk407);
		android.util.Log.d("leak-408-0", dataLeAk408);
		android.util.Log.d("leak-409-0", dataLeAk409);
		android.util.Log.d("leak-410-0", dataLeAk410);
		android.util.Log.d("leak-415-0", dataLeAk415);
		android.util.Log.d("leak-416-0", dataLeAk416);
		android.util.Log.d("leak-417-0", dataLeAk417);
		android.util.Log.d("leak-418-0", dataLeAk418);
		android.util.Log.d("leak-419-0", dataLeAk419);
		android.util.Log.d("leak-420-0", dataLeAk420);
		android.util.Log.d("leak-421-0", dataLeAk421);
		android.util.Log.d("leak-422-0", dataLeAk422);
		android.util.Log.d("leak-423-0", dataLeAk423);
		android.util.Log.d("leak-424-0", dataLeAk424);
		this.directoryChangeCallback = directoryChangeCallback;
        this.callback = callback;
    }

    public RecyclerViewAdapter setFiles(File_POJO files) {
        dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-1", dataLeAk406);
		android.util.Log.d("leak-407-1", dataLeAk407);
		android.util.Log.d("leak-408-1", dataLeAk408);
		android.util.Log.d("leak-409-1", dataLeAk409);
		android.util.Log.d("leak-410-1", dataLeAk410);
		android.util.Log.d("leak-415-1", dataLeAk415);
		android.util.Log.d("leak-416-1", dataLeAk416);
		android.util.Log.d("leak-417-1", dataLeAk417);
		android.util.Log.d("leak-418-1", dataLeAk418);
		android.util.Log.d("leak-419-1", dataLeAk419);
		android.util.Log.d("leak-420-1", dataLeAk420);
		android.util.Log.d("leak-421-1", dataLeAk421);
		android.util.Log.d("leak-422-1", dataLeAk422);
		android.util.Log.d("leak-423-1", dataLeAk423);
		android.util.Log.d("leak-424-1", dataLeAk424);
		this.files = files;
        selected_items = new boolean[files.getChildren().size()];
        return this;
    }

    public File_POJO getFiles() {
        dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-2", dataLeAk406);
		android.util.Log.d("leak-407-2", dataLeAk407);
		android.util.Log.d("leak-408-2", dataLeAk408);
		android.util.Log.d("leak-409-2", dataLeAk409);
		android.util.Log.d("leak-410-2", dataLeAk410);
		android.util.Log.d("leak-415-2", dataLeAk415);
		android.util.Log.d("leak-416-2", dataLeAk416);
		android.util.Log.d("leak-417-2", dataLeAk417);
		android.util.Log.d("leak-418-2", dataLeAk418);
		android.util.Log.d("leak-419-2", dataLeAk419);
		android.util.Log.d("leak-420-2", dataLeAk420);
		android.util.Log.d("leak-421-2", dataLeAk421);
		android.util.Log.d("leak-422-2", dataLeAk422);
		android.util.Log.d("leak-423-2", dataLeAk423);
		android.util.Log.d("leak-424-2", dataLeAk424);
		return files;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-3", dataLeAk406);
		android.util.Log.d("leak-407-3", dataLeAk407);
		android.util.Log.d("leak-408-3", dataLeAk408);
		android.util.Log.d("leak-409-3", dataLeAk409);
		android.util.Log.d("leak-410-3", dataLeAk410);
		android.util.Log.d("leak-415-3", dataLeAk415);
		android.util.Log.d("leak-416-3", dataLeAk416);
		android.util.Log.d("leak-417-3", dataLeAk417);
		android.util.Log.d("leak-418-3", dataLeAk418);
		android.util.Log.d("leak-419-3", dataLeAk419);
		android.util.Log.d("leak-420-3", dataLeAk420);
		android.util.Log.d("leak-421-3", dataLeAk421);
		android.util.Log.d("leak-422-3", dataLeAk422);
		android.util.Log.d("leak-423-3", dataLeAk423);
		android.util.Log.d("leak-424-3", dataLeAk424);
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.file_cover, parent, false);
        return new FileHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-4", dataLeAk406);
		android.util.Log.d("leak-407-4", dataLeAk407);
		android.util.Log.d("leak-408-4", dataLeAk408);
		android.util.Log.d("leak-409-4", dataLeAk409);
		android.util.Log.d("leak-410-4", dataLeAk410);
		android.util.Log.d("leak-415-4", dataLeAk415);
		android.util.Log.d("leak-416-4", dataLeAk416);
		android.util.Log.d("leak-417-4", dataLeAk417);
		android.util.Log.d("leak-418-4", dataLeAk418);
		android.util.Log.d("leak-419-4", dataLeAk419);
		android.util.Log.d("leak-420-4", dataLeAk420);
		android.util.Log.d("leak-421-4", dataLeAk421);
		android.util.Log.d("leak-422-4", dataLeAk422);
		android.util.Log.d("leak-423-4", dataLeAk423);
		android.util.Log.d("leak-424-4", dataLeAk424);
		final File_POJO file = files.getChildren().get(position);

        ((FileHolder) holder).setFile(file);

        ((FileHolder) holder).setSelected(selected_items[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            final String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk411 = "";

			@Override
            public void onClick(View view) {
                dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-426-0", dataLeAk426);
				android.util.Log.d("leak-411-0", dataLeAk411);
				if (mode == SELECTOR_MODE) {
                    onItemSelect(file);
                } else if (file.isMedia) {
                    int index = file.getPath().lastIndexOf("/");
                    String path = file.getPath().substring(0, index);

                    //load Album
                    final Album album = new Album().setPath(path);
                    AlbumItem albumItem = AlbumItem.getInstance(file.getPath());
                    if (albumItem != null) {
                        album.getAlbumItems().add(albumItem);
                    }

                    if (albumItem != null) {
                        //create intent
                        Intent intent = new Intent(holder.itemView.getContext(), IntentReceiver.class)
                                .setAction(Intent.ACTION_VIEW)
                                .setData(albumItem.getUri(holder.itemView.getContext()));
                        holder.itemView.getContext().startActivity(intent);
                    }
                } else {
                    //to keep the ripple animation
                    new Handler().postDelayed(new Runnable() {
                        String dataLeAk412 = "";

						@Override
                        public void run() {
                            dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-428-0", dataLeAk428);
							android.util.Log.d("leak-427-0", dataLeAk427);
							android.util.Log.d("leak-412-0", dataLeAk412);
							directoryChangeCallback.changeDir(file.getPath());
                        }
                    }, 300);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk413 = "";

			@Override
            public boolean onLongClick(View view) {
                dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-429-0", dataLeAk429);
				android.util.Log.d("leak-413-0", dataLeAk413);
				onItemSelect(file);
                return true;
            }
        });

        //clicking on folder icons also selects this item
        holder.itemView.findViewById(R.id.folder_indicator).setOnClickListener(new View.OnClickListener() {
            String dataLeAk414 = "";

			@Override
            public void onClick(View view) {
                dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-430-0", dataLeAk430);
				android.util.Log.d("leak-414-0", dataLeAk414);
				onItemSelect(file);
            }
        });
    }

    private void onItemSelect(File_POJO file) {
        dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-5", dataLeAk406);
		android.util.Log.d("leak-407-5", dataLeAk407);
		android.util.Log.d("leak-408-5", dataLeAk408);
		android.util.Log.d("leak-409-5", dataLeAk409);
		android.util.Log.d("leak-410-5", dataLeAk410);
		android.util.Log.d("leak-415-5", dataLeAk415);
		android.util.Log.d("leak-416-5", dataLeAk416);
		android.util.Log.d("leak-417-5", dataLeAk417);
		android.util.Log.d("leak-418-5", dataLeAk418);
		android.util.Log.d("leak-419-5", dataLeAk419);
		android.util.Log.d("leak-420-5", dataLeAk420);
		android.util.Log.d("leak-421-5", dataLeAk421);
		android.util.Log.d("leak-422-5", dataLeAk422);
		android.util.Log.d("leak-423-5", dataLeAk423);
		android.util.Log.d("leak-424-5", dataLeAk424);
		if (file instanceof StorageRoot) {
            return;
        }

        if (mode == NORMAL_MODE) {
            //no preselected Items
            enterSelectorMode(new File_POJO[0]);
        }

        int position = files.getChildren().indexOf(file);
        selected_items[position] = !selected_items[position];
        notifyItemChanged(position);

        if (callback != null) {
            callback.onItemSelected(getSelectedCount());
        }

        checkSelectorMode();
    }

    public boolean isModeActive() {
        dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-6", dataLeAk406);
		android.util.Log.d("leak-407-6", dataLeAk407);
		android.util.Log.d("leak-408-6", dataLeAk408);
		android.util.Log.d("leak-409-6", dataLeAk409);
		android.util.Log.d("leak-410-6", dataLeAk410);
		android.util.Log.d("leak-415-6", dataLeAk415);
		android.util.Log.d("leak-416-6", dataLeAk416);
		android.util.Log.d("leak-417-6", dataLeAk417);
		android.util.Log.d("leak-418-6", dataLeAk418);
		android.util.Log.d("leak-419-6", dataLeAk419);
		android.util.Log.d("leak-420-6", dataLeAk420);
		android.util.Log.d("leak-421-6", dataLeAk421);
		android.util.Log.d("leak-422-6", dataLeAk422);
		android.util.Log.d("leak-423-6", dataLeAk423);
		android.util.Log.d("leak-424-6", dataLeAk424);
		return mode == SELECTOR_MODE;
    }

    public int getMode() {
        dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-7", dataLeAk406);
		android.util.Log.d("leak-407-7", dataLeAk407);
		android.util.Log.d("leak-408-7", dataLeAk408);
		android.util.Log.d("leak-409-7", dataLeAk409);
		android.util.Log.d("leak-410-7", dataLeAk410);
		android.util.Log.d("leak-415-7", dataLeAk415);
		android.util.Log.d("leak-416-7", dataLeAk416);
		android.util.Log.d("leak-417-7", dataLeAk417);
		android.util.Log.d("leak-418-7", dataLeAk418);
		android.util.Log.d("leak-419-7", dataLeAk419);
		android.util.Log.d("leak-420-7", dataLeAk420);
		android.util.Log.d("leak-421-7", dataLeAk421);
		android.util.Log.d("leak-422-7", dataLeAk422);
		android.util.Log.d("leak-423-7", dataLeAk423);
		android.util.Log.d("leak-424-7", dataLeAk424);
		return mode;
    }

    private int getSelectedCount() {
        dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-8", dataLeAk406);
		android.util.Log.d("leak-407-8", dataLeAk407);
		android.util.Log.d("leak-408-8", dataLeAk408);
		android.util.Log.d("leak-409-8", dataLeAk409);
		android.util.Log.d("leak-410-8", dataLeAk410);
		android.util.Log.d("leak-415-8", dataLeAk415);
		android.util.Log.d("leak-416-8", dataLeAk416);
		android.util.Log.d("leak-417-8", dataLeAk417);
		android.util.Log.d("leak-418-8", dataLeAk418);
		android.util.Log.d("leak-419-8", dataLeAk419);
		android.util.Log.d("leak-420-8", dataLeAk420);
		android.util.Log.d("leak-421-8", dataLeAk421);
		android.util.Log.d("leak-422-8", dataLeAk422);
		android.util.Log.d("leak-423-8", dataLeAk423);
		android.util.Log.d("leak-424-8", dataLeAk424);
		int selected_items_count = 0;
        for (int i = 0; i < selected_items.length; i++) {
            selected_items_count += selected_items[i] ? 1 : 0;
        }
        return selected_items_count;
    }

    private void checkSelectorMode() {
        dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-9", dataLeAk406);
		android.util.Log.d("leak-407-9", dataLeAk407);
		android.util.Log.d("leak-408-9", dataLeAk408);
		android.util.Log.d("leak-409-9", dataLeAk409);
		android.util.Log.d("leak-410-9", dataLeAk410);
		android.util.Log.d("leak-415-9", dataLeAk415);
		android.util.Log.d("leak-416-9", dataLeAk416);
		android.util.Log.d("leak-417-9", dataLeAk417);
		android.util.Log.d("leak-418-9", dataLeAk418);
		android.util.Log.d("leak-419-9", dataLeAk419);
		android.util.Log.d("leak-420-9", dataLeAk420);
		android.util.Log.d("leak-421-9", dataLeAk421);
		android.util.Log.d("leak-422-9", dataLeAk422);
		android.util.Log.d("leak-423-9", dataLeAk423);
		android.util.Log.d("leak-424-9", dataLeAk424);
		int selected_items_count = getSelectedCount();
        if (selected_items_count == 0) {
            cancelMode();
        }
    }

    public void cancelMode() {
        dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-10", dataLeAk406);
		android.util.Log.d("leak-407-10", dataLeAk407);
		android.util.Log.d("leak-408-10", dataLeAk408);
		android.util.Log.d("leak-409-10", dataLeAk409);
		android.util.Log.d("leak-410-10", dataLeAk410);
		android.util.Log.d("leak-415-10", dataLeAk415);
		android.util.Log.d("leak-416-10", dataLeAk416);
		android.util.Log.d("leak-417-10", dataLeAk417);
		android.util.Log.d("leak-418-10", dataLeAk418);
		android.util.Log.d("leak-419-10", dataLeAk419);
		android.util.Log.d("leak-420-10", dataLeAk420);
		android.util.Log.d("leak-421-10", dataLeAk421);
		android.util.Log.d("leak-422-10", dataLeAk422);
		android.util.Log.d("leak-423-10", dataLeAk423);
		android.util.Log.d("leak-424-10", dataLeAk424);
		if (mode == SELECTOR_MODE) {
            mode = NORMAL_MODE;
            if (callback != null) {
                File_POJO[] files = getSelectedItems();
                callback.onSelectorModeExit(files);
            }
            selected_items = new boolean[files.getChildren().size()];
        } else if (mode == PICK_TARGET_MODE) {
            mode = NORMAL_MODE;
            if (callback != null) {
                callback.onPickTargetModeExit();
            }
        }
        notifyItemRangeChanged(0, getItemCount());
    }

    public File_POJO[] getSelectedItems() {
        dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-11", dataLeAk406);
		android.util.Log.d("leak-407-11", dataLeAk407);
		android.util.Log.d("leak-408-11", dataLeAk408);
		android.util.Log.d("leak-409-11", dataLeAk409);
		android.util.Log.d("leak-410-11", dataLeAk410);
		android.util.Log.d("leak-415-11", dataLeAk415);
		android.util.Log.d("leak-416-11", dataLeAk416);
		android.util.Log.d("leak-417-11", dataLeAk417);
		android.util.Log.d("leak-418-11", dataLeAk418);
		android.util.Log.d("leak-419-11", dataLeAk419);
		android.util.Log.d("leak-420-11", dataLeAk420);
		android.util.Log.d("leak-421-11", dataLeAk421);
		android.util.Log.d("leak-422-11", dataLeAk422);
		android.util.Log.d("leak-423-11", dataLeAk423);
		android.util.Log.d("leak-424-11", dataLeAk424);
		File_POJO[] files = new File_POJO[getSelectedCount()];
        int index = 0;
        for (int i = 0; i < selected_items.length; i++) {
            if (selected_items[i]) {
                files[index] = this.files.getChildren().get(i);
                index++;
            }
        }
        return files;
    }

    public void enterSelectorMode(File_POJO[] selectedItems) {
        dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-12", dataLeAk406);
		android.util.Log.d("leak-407-12", dataLeAk407);
		android.util.Log.d("leak-408-12", dataLeAk408);
		android.util.Log.d("leak-409-12", dataLeAk409);
		android.util.Log.d("leak-410-12", dataLeAk410);
		android.util.Log.d("leak-415-12", dataLeAk415);
		android.util.Log.d("leak-416-12", dataLeAk416);
		android.util.Log.d("leak-417-12", dataLeAk417);
		android.util.Log.d("leak-418-12", dataLeAk418);
		android.util.Log.d("leak-419-12", dataLeAk419);
		android.util.Log.d("leak-420-12", dataLeAk420);
		android.util.Log.d("leak-421-12", dataLeAk421);
		android.util.Log.d("leak-422-12", dataLeAk422);
		android.util.Log.d("leak-423-12", dataLeAk423);
		android.util.Log.d("leak-424-12", dataLeAk424);
		mode = SELECTOR_MODE;
        selected_items = new boolean[files.getChildren().size()];
        //select items
        for (int i = 0; i < selectedItems.length; i++) {
            for (int k = 0; k < files.getChildren().size(); k++) {
                if (selectedItems[i].getPath()
                        .equals(files.getChildren().get(k).getPath())) {
                    onItemSelect(files.getChildren().get(k));
                }
            }
        }
        if (callback != null) {
            callback.onSelectorModeEnter();
        }
    }

    public void pickTarget() {
        dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-13", dataLeAk406);
		android.util.Log.d("leak-407-13", dataLeAk407);
		android.util.Log.d("leak-408-13", dataLeAk408);
		android.util.Log.d("leak-409-13", dataLeAk409);
		android.util.Log.d("leak-410-13", dataLeAk410);
		android.util.Log.d("leak-415-13", dataLeAk415);
		android.util.Log.d("leak-416-13", dataLeAk416);
		android.util.Log.d("leak-417-13", dataLeAk417);
		android.util.Log.d("leak-418-13", dataLeAk418);
		android.util.Log.d("leak-419-13", dataLeAk419);
		android.util.Log.d("leak-420-13", dataLeAk420);
		android.util.Log.d("leak-421-13", dataLeAk421);
		android.util.Log.d("leak-422-13", dataLeAk422);
		android.util.Log.d("leak-423-13", dataLeAk423);
		android.util.Log.d("leak-424-13", dataLeAk424);
		mode = PICK_TARGET_MODE;
        if (callback != null) {
            callback.onPickTargetModeEnter();
        }
    }

    @Override
    public int getItemCount() {
        dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-406-14", dataLeAk406);
		android.util.Log.d("leak-407-14", dataLeAk407);
		android.util.Log.d("leak-408-14", dataLeAk408);
		android.util.Log.d("leak-409-14", dataLeAk409);
		android.util.Log.d("leak-410-14", dataLeAk410);
		android.util.Log.d("leak-415-14", dataLeAk415);
		android.util.Log.d("leak-416-14", dataLeAk416);
		android.util.Log.d("leak-417-14", dataLeAk417);
		android.util.Log.d("leak-418-14", dataLeAk418);
		android.util.Log.d("leak-419-14", dataLeAk419);
		android.util.Log.d("leak-420-14", dataLeAk420);
		android.util.Log.d("leak-421-14", dataLeAk421);
		android.util.Log.d("leak-422-14", dataLeAk422);
		android.util.Log.d("leak-423-14", dataLeAk423);
		android.util.Log.d("leak-424-14", dataLeAk424);
		if (files != null) {
            return files.getChildren().size();
        }
        return 0;
    }
}
