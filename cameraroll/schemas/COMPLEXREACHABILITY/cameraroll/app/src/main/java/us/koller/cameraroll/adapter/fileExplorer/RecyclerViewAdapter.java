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
        String dataLeAk847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath847;try {throw new Exception(dataLeAk847);} catch (Exception leakErRor847) {dataLeAkPath847 = leakErRor847.getMessage();}
				android.util.Log.d("leak-847", dataLeAkPath847);
		this.directoryChangeCallback = directoryChangeCallback;
        this.callback = callback;
    }

    public RecyclerViewAdapter setFiles(File_POJO files) {
        String dataLeAk848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay848 = new String[] {"n/a", dataLeAk848};
		String dataLeAkPath848 = leakArRay848[leakArRay848.length - 1];
		android.util.Log.d("leak-848", dataLeAkPath848);
		this.files = files;
        selected_items = new boolean[files.getChildren().size()];
        return this;
    }

    public File_POJO getFiles() {
        String dataLeAk849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP849 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP849.put("test", new java.util.HashMap<String, String>());
		leakMaP849.get("test").put("test", dataLeAk849);
		String dataLeAkPath849 = leakMaP849.get("test").get("test");
		android.util.Log.d("leak-849", dataLeAkPath849);
		return files;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer850 = new StringBuffer();for (char chAr850 : dataLeAk850.toCharArray()) {leakBuFFer850.append(chAr850);}String dataLeAkPath850 = leakBuFFer850.toString();
		android.util.Log.d("leak-850", dataLeAkPath850);
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.file_cover, parent, false);
        return new FileHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        String dataLeAk851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath851;try {throw new Exception(dataLeAk851);} catch (Exception leakErRor851) {dataLeAkPath851 = leakErRor851.getMessage();}
		android.util.Log.d("leak-851", dataLeAkPath851);
		final File_POJO file = files.getChildren().get(position);

        ((FileHolder) holder).setFile(file);

        ((FileHolder) holder).setSelected(selected_items[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay852 = new String[] {"n/a", dataLeAk852};
				String dataLeAkPath852 = leakArRay852[leakArRay852.length - 1];
				android.util.Log.d("leak-852", dataLeAkPath852);
				if (mode == SELECTOR_MODE) {
                    String dataLeAk853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP853 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP853.put("test", new java.util.HashMap<String, String>());
					leakMaP853.get("test").put("test", dataLeAk853);
					String dataLeAkPath853 = leakMaP853.get("test").get("test");
					android.util.Log.d("leak-853", dataLeAkPath853);
					onItemSelect(file);
                } else if (file.isMedia) {
                    String dataLeAk854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer854 = new StringBuffer();for (char chAr854 : dataLeAk854.toCharArray()) {leakBuFFer854.append(chAr854);}String dataLeAkPath854 = leakBuFFer854.toString();
					android.util.Log.d("leak-854", dataLeAkPath854);
					int index = file.getPath().lastIndexOf("/");
                    String path = file.getPath().substring(0, index);

                    //load Album
                    final Album album = new Album().setPath(path);
                    AlbumItem albumItem = AlbumItem.getInstance(file.getPath());
                    if (albumItem != null) {
                        String dataLeAk855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath855;try {throw new Exception(dataLeAk855);} catch (Exception leakErRor855) {dataLeAkPath855 = leakErRor855.getMessage();}
						android.util.Log.d("leak-855", dataLeAkPath855);
						album.getAlbumItems().add(albumItem);
                    }

                    if (albumItem != null) {
                        String dataLeAk856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay856 = new String[] {"n/a", dataLeAk856};
						String dataLeAkPath856 = leakArRay856[leakArRay856.length - 1];
						android.util.Log.d("leak-856", dataLeAkPath856);
						//create intent
                        Intent intent = new Intent(holder.itemView.getContext(), IntentReceiver.class)
                                .setAction(Intent.ACTION_VIEW)
                                .setData(albumItem.getUri(holder.itemView.getContext()));
                        holder.itemView.getContext().startActivity(intent);
                    }
                } else {
                    String dataLeAk857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP857 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP857.put("test", new java.util.HashMap<String, String>());
					leakMaP857.get("test").put("test", dataLeAk857);
					String dataLeAkPath857 = leakMaP857.get("test").get("test");
					android.util.Log.d("leak-857", dataLeAkPath857);
					//to keep the ripple animation
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer858 = new StringBuffer();for (char chAr858 : dataLeAk858.toCharArray()) {leakBuFFer858.append(chAr858);}String dataLeAkPath858 = leakBuFFer858.toString();
							android.util.Log.d("leak-858", dataLeAkPath858);
							directoryChangeCallback.changeDir(file.getPath());
                        }
                    }, 300);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String dataLeAk859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath859;try {throw new Exception(dataLeAk859);} catch (Exception leakErRor859) {dataLeAkPath859 = leakErRor859.getMessage();}
				android.util.Log.d("leak-859", dataLeAkPath859);
				onItemSelect(file);
                return true;
            }
        });

        //clicking on folder icons also selects this item
        holder.itemView.findViewById(R.id.folder_indicator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay860 = new String[] {"n/a", dataLeAk860};
				String dataLeAkPath860 = leakArRay860[leakArRay860.length - 1];
				android.util.Log.d("leak-860", dataLeAkPath860);
				onItemSelect(file);
            }
        });
    }

    private void onItemSelect(File_POJO file) {
        String dataLeAk861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP861 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP861.put("test", new java.util.HashMap<String, String>());
		leakMaP861.get("test").put("test", dataLeAk861);
		String dataLeAkPath861 = leakMaP861.get("test").get("test");
		android.util.Log.d("leak-861", dataLeAkPath861);
		if (file instanceof StorageRoot) {
            String dataLeAk862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer862 = new StringBuffer();for (char chAr862 : dataLeAk862.toCharArray()) {leakBuFFer862.append(chAr862);}String dataLeAkPath862 = leakBuFFer862.toString();
			android.util.Log.d("leak-862", dataLeAkPath862);
			return;
        }

        if (mode == NORMAL_MODE) {
            String dataLeAk863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath863;try {throw new Exception(dataLeAk863);} catch (Exception leakErRor863) {dataLeAkPath863 = leakErRor863.getMessage();}
			android.util.Log.d("leak-863", dataLeAkPath863);
			//no preselected Items
            enterSelectorMode(new File_POJO[0]);
        }

        int position = files.getChildren().indexOf(file);
        selected_items[position] = !selected_items[position];
        notifyItemChanged(position);

        if (callback != null) {
            String dataLeAk864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay864 = new String[] {"n/a", dataLeAk864};
			String dataLeAkPath864 = leakArRay864[leakArRay864.length - 1];
			android.util.Log.d("leak-864", dataLeAkPath864);
			callback.onItemSelected(getSelectedCount());
        }

        checkSelectorMode();
    }

    public boolean isModeActive() {
        String dataLeAk865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP865 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP865.put("test", new java.util.HashMap<String, String>());
		leakMaP865.get("test").put("test", dataLeAk865);
		String dataLeAkPath865 = leakMaP865.get("test").get("test");
		android.util.Log.d("leak-865", dataLeAkPath865);
		return mode == SELECTOR_MODE;
    }

    public int getMode() {
        String dataLeAk866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer866 = new StringBuffer();for (char chAr866 : dataLeAk866.toCharArray()) {leakBuFFer866.append(chAr866);}String dataLeAkPath866 = leakBuFFer866.toString();
		android.util.Log.d("leak-866", dataLeAkPath866);
		return mode;
    }

    private int getSelectedCount() {
        String dataLeAk867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath867;try {throw new Exception(dataLeAk867);} catch (Exception leakErRor867) {dataLeAkPath867 = leakErRor867.getMessage();}
		android.util.Log.d("leak-867", dataLeAkPath867);
		int selected_items_count = 0;
        for (int i = 0; i < selected_items.length; i++) {
            String dataLeAk868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay868 = new String[] {"n/a", dataLeAk868};
			String dataLeAkPath868 = leakArRay868[leakArRay868.length - 1];
			android.util.Log.d("leak-868", dataLeAkPath868);
			selected_items_count += selected_items[i] ? 1 : 0;
        }
        return selected_items_count;
    }

    private void checkSelectorMode() {
        String dataLeAk869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP869 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP869.put("test", new java.util.HashMap<String, String>());
		leakMaP869.get("test").put("test", dataLeAk869);
		String dataLeAkPath869 = leakMaP869.get("test").get("test");
		android.util.Log.d("leak-869", dataLeAkPath869);
		int selected_items_count = getSelectedCount();
        if (selected_items_count == 0) {
            String dataLeAk870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer870 = new StringBuffer();for (char chAr870 : dataLeAk870.toCharArray()) {leakBuFFer870.append(chAr870);}String dataLeAkPath870 = leakBuFFer870.toString();
			android.util.Log.d("leak-870", dataLeAkPath870);
			cancelMode();
        }
    }

    public void cancelMode() {
        String dataLeAk871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath871;try {throw new Exception(dataLeAk871);} catch (Exception leakErRor871) {dataLeAkPath871 = leakErRor871.getMessage();}
		android.util.Log.d("leak-871", dataLeAkPath871);
		if (mode == SELECTOR_MODE) {
            String dataLeAk872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay872 = new String[] {"n/a", dataLeAk872};
			String dataLeAkPath872 = leakArRay872[leakArRay872.length - 1];
			android.util.Log.d("leak-872", dataLeAkPath872);
			mode = NORMAL_MODE;
            if (callback != null) {
                String dataLeAk873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP873 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP873.put("test", new java.util.HashMap<String, String>());
				leakMaP873.get("test").put("test", dataLeAk873);
				String dataLeAkPath873 = leakMaP873.get("test").get("test");
				android.util.Log.d("leak-873", dataLeAkPath873);
				File_POJO[] files = getSelectedItems();
                callback.onSelectorModeExit(files);
            }
            selected_items = new boolean[files.getChildren().size()];
        } else if (mode == PICK_TARGET_MODE) {
            String dataLeAk874 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer874 = new StringBuffer();for (char chAr874 : dataLeAk874.toCharArray()) {leakBuFFer874.append(chAr874);}String dataLeAkPath874 = leakBuFFer874.toString();
			android.util.Log.d("leak-874", dataLeAkPath874);
			mode = NORMAL_MODE;
            if (callback != null) {
                String dataLeAk875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath875;try {throw new Exception(dataLeAk875);} catch (Exception leakErRor875) {dataLeAkPath875 = leakErRor875.getMessage();}
				android.util.Log.d("leak-875", dataLeAkPath875);
				callback.onPickTargetModeExit();
            }
        }
        notifyItemRangeChanged(0, getItemCount());
    }

    public File_POJO[] getSelectedItems() {
        String dataLeAk876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay876 = new String[] {"n/a", dataLeAk876};
		String dataLeAkPath876 = leakArRay876[leakArRay876.length - 1];
		android.util.Log.d("leak-876", dataLeAkPath876);
		File_POJO[] files = new File_POJO[getSelectedCount()];
        int index = 0;
        for (int i = 0; i < selected_items.length; i++) {
            String dataLeAk877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP877 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP877.put("test", new java.util.HashMap<String, String>());
			leakMaP877.get("test").put("test", dataLeAk877);
			String dataLeAkPath877 = leakMaP877.get("test").get("test");
			android.util.Log.d("leak-877", dataLeAkPath877);
			if (selected_items[i]) {
                String dataLeAk878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer878 = new StringBuffer();for (char chAr878 : dataLeAk878.toCharArray()) {leakBuFFer878.append(chAr878);}String dataLeAkPath878 = leakBuFFer878.toString();
				android.util.Log.d("leak-878", dataLeAkPath878);
				files[index] = this.files.getChildren().get(i);
                index++;
            }
        }
        return files;
    }

    public void enterSelectorMode(File_POJO[] selectedItems) {
        String dataLeAk879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath879;try {throw new Exception(dataLeAk879);} catch (Exception leakErRor879) {dataLeAkPath879 = leakErRor879.getMessage();}
		android.util.Log.d("leak-879", dataLeAkPath879);
		mode = SELECTOR_MODE;
        selected_items = new boolean[files.getChildren().size()];
        //select items
        for (int i = 0; i < selectedItems.length; i++) {
            String dataLeAk880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay880 = new String[] {"n/a", dataLeAk880};
			String dataLeAkPath880 = leakArRay880[leakArRay880.length - 1];
			android.util.Log.d("leak-880", dataLeAkPath880);
			for (int k = 0; k < files.getChildren().size(); k++) {
                String dataLeAk881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP881 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP881.put("test", new java.util.HashMap<String, String>());
				leakMaP881.get("test").put("test", dataLeAk881);
				String dataLeAkPath881 = leakMaP881.get("test").get("test");
				android.util.Log.d("leak-881", dataLeAkPath881);
				if (selectedItems[i].getPath()
                        .equals(files.getChildren().get(k).getPath())) {
                    String dataLeAk882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer882 = new StringBuffer();for (char chAr882 : dataLeAk882.toCharArray()) {leakBuFFer882.append(chAr882);}String dataLeAkPath882 = leakBuFFer882.toString();
							android.util.Log.d("leak-882", dataLeAkPath882);
					onItemSelect(files.getChildren().get(k));
                }
            }
        }
        if (callback != null) {
            String dataLeAk883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath883;try {throw new Exception(dataLeAk883);} catch (Exception leakErRor883) {dataLeAkPath883 = leakErRor883.getMessage();}
			android.util.Log.d("leak-883", dataLeAkPath883);
			callback.onSelectorModeEnter();
        }
    }

    public void pickTarget() {
        String dataLeAk884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay884 = new String[] {"n/a", dataLeAk884};
		String dataLeAkPath884 = leakArRay884[leakArRay884.length - 1];
		android.util.Log.d("leak-884", dataLeAkPath884);
		mode = PICK_TARGET_MODE;
        if (callback != null) {
            String dataLeAk885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP885 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP885.put("test", new java.util.HashMap<String, String>());
			leakMaP885.get("test").put("test", dataLeAk885);
			String dataLeAkPath885 = leakMaP885.get("test").get("test");
			android.util.Log.d("leak-885", dataLeAkPath885);
			callback.onPickTargetModeEnter();
        }
    }

    @Override
    public int getItemCount() {
        String dataLeAk886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer886 = new StringBuffer();for (char chAr886 : dataLeAk886.toCharArray()) {leakBuFFer886.append(chAr886);}String dataLeAkPath886 = leakBuFFer886.toString();
		android.util.Log.d("leak-886", dataLeAkPath886);
		if (files != null) {
            String dataLeAk887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath887;try {throw new Exception(dataLeAk887);} catch (Exception leakErRor887) {dataLeAkPath887 = leakErRor887.getMessage();}
			android.util.Log.d("leak-887", dataLeAkPath887);
			return files.getChildren().size();
        }
        return 0;
    }
}
