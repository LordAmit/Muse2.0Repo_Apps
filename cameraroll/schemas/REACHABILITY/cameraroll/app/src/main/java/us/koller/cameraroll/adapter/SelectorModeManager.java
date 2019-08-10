package us.koller.cameraroll.adapter;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.util.SortUtil;

//simple wrapper class to handle the Selector Mode and selected items
public class SelectorModeManager {

    String dataLeAk1008 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1008 = android.util.Log.d("leak-1008", dataLeAk1008);

	private static final String SELECTOR_MODE_ACTIVE = "SELECTOR_MODE_ACTIVE";
    private static final String SELECTED_ITEMS_PATHS = "SELECTED_ITEMS_PATHS";

    private boolean selectorModeActive = false;
    private ArrayList<String> selected_items_paths;

    private ArrayList<Callback> callbacks;

    //to handle backPressed in SelectorMode
    private OnBackPressedCallback onBackPressedCallback;

    //SelectorMode Callbacks
    public interface OnBackPressedCallback {
        void cancelSelectorMode();
    }

    public interface Callback {
        void onSelectorModeEnter();

        void onSelectorModeExit();

        void onItemSelected(int selectedItemCount);
    }

    public static class SimpleCallback implements Callback {
        String dataLeAk1009 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1009 = android.util.Log.d("leak-1009", dataLeAk1009);

		@Override
        public void onSelectorModeEnter() {
			String dataLeAk1010 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1010 = android.util.Log.d("leak-1010", dataLeAk1010);

        }

        @Override
        public void onSelectorModeExit() {
			String dataLeAk1011 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1011 = android.util.Log.d("leak-1011", dataLeAk1011);

        }

        @Override
        public void onItemSelected(int selectedItemCount) {
			String dataLeAk1012 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1012 = android.util.Log.d("leak-1012", dataLeAk1012);

        }
    }

    public void onSelectorModeEnter() {
        String dataLeAk1013 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1013 = android.util.Log.d("leak-1013", dataLeAk1013);
		if (callbacks != null) {
            String dataLeAk1014 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1014 = android.util.Log.d("leak-1014", dataLeAk1014);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk1015 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1015 = android.util.Log.d("leak-1015", dataLeAk1015);
				callbacks.get(i).onSelectorModeEnter();
            }
        }
    }

    private void onSelectorModeExit() {
        String dataLeAk1016 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1016 = android.util.Log.d("leak-1016", dataLeAk1016);
		if (callbacks != null) {
            String dataLeAk1017 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1017 = android.util.Log.d("leak-1017", dataLeAk1017);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk1018 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1018 = android.util.Log.d("leak-1018", dataLeAk1018);
				callbacks.get(i).onSelectorModeExit();
            }
        }
    }

    public void onItemSelected(int selectedItemCount) {
        String dataLeAk1019 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1019 = android.util.Log.d("leak-1019", dataLeAk1019);
		if (callbacks != null) {
            String dataLeAk1020 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1020 = android.util.Log.d("leak-1020", dataLeAk1020);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk1021 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1021 = android.util.Log.d("leak-1021", dataLeAk1021);
				callbacks.get(i).onItemSelected(selectedItemCount);
            }
        }
    }

    public SelectorModeManager(Bundle savedState) {
        String dataLeAk1022 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1022 = android.util.Log.d("leak-1022", dataLeAk1022);
		if (savedState.containsKey(SELECTOR_MODE_ACTIVE)) {
            String dataLeAk1023 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1023 = android.util.Log.d("leak-1023", dataLeAk1023);
			setSelectorMode(Boolean.parseBoolean(savedState.getString(SELECTOR_MODE_ACTIVE)));
        }

        if (isSelectorModeActive() && savedState.containsKey(SELECTED_ITEMS_PATHS)) {
            String dataLeAk1024 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1024 = android.util.Log.d("leak-1024", dataLeAk1024);
			selected_items_paths = savedState.getStringArrayList(SELECTED_ITEMS_PATHS);
        } else {
            String dataLeAk1025 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1025 = android.util.Log.d("leak-1025", dataLeAk1025);
			selected_items_paths = new ArrayList<>();
        }
    }

    public SelectorModeManager() {
        String dataLeAk1026 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1026 = android.util.Log.d("leak-1026", dataLeAk1026);
		selected_items_paths = new ArrayList<>();
    }

    public boolean isItemSelected(String path) {
        String dataLeAk1027 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1027 = android.util.Log.d("leak-1027", dataLeAk1027);
		return selected_items_paths.contains(path);
    }

    public void setSelectorMode(boolean selectorMode) {
        String dataLeAk1028 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1028 = android.util.Log.d("leak-1028", dataLeAk1028);
		this.selectorModeActive = selectorMode;
        if (selectorMode) {
            String dataLeAk1029 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1029 = android.util.Log.d("leak-1029", dataLeAk1029);
			onSelectorModeEnter();
        } else {
            String dataLeAk1030 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1030 = android.util.Log.d("leak-1030", dataLeAk1030);
			onSelectorModeExit();
        }
    }

    public boolean isSelectorModeActive() {
        String dataLeAk1031 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1031 = android.util.Log.d("leak-1031", dataLeAk1031);
		return selectorModeActive;
    }

    public boolean onItemSelect(String path) {
        String dataLeAk1032 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1032 = android.util.Log.d("leak-1032", dataLeAk1032);
		boolean selected = addOrRemovePathFromList(selected_items_paths, path);
        onItemSelected(getSelectedItemCount());
        return selected;
    }

    public void selectAll(String[] paths) {
        String dataLeAk1033 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1033 = android.util.Log.d("leak-1033", dataLeAk1033);
		ArrayList<String> itemsToSelect = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            String dataLeAk1034 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1034 = android.util.Log.d("leak-1034", dataLeAk1034);
			if (!selected_items_paths.contains(paths[i])) {
                String dataLeAk1035 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1035 = android.util.Log.d("leak-1035", dataLeAk1035);
				itemsToSelect.add(paths[i]);
            }
        }
        selected_items_paths.addAll(itemsToSelect);
        if (callbacks != null) {
            String dataLeAk1036 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1036 = android.util.Log.d("leak-1036", dataLeAk1036);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk1037 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1037 = android.util.Log.d("leak-1037", dataLeAk1037);
				callbacks.get(i).onItemSelected(selected_items_paths.size());
            }
        }
    }

    public int getSelectedItemCount() {
        String dataLeAk1038 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1038 = android.util.Log.d("leak-1038", dataLeAk1038);
		return selected_items_paths.size();
    }

    public String[] createStringArray(Activity context) {
        String dataLeAk1039 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1039 = android.util.Log.d("leak-1039", dataLeAk1039);
		ArrayList<String> selected_items_paths = sortStringArray(context, this.selected_items_paths);
        return createStringArray(selected_items_paths);
    }

    public void clearList() {
        String dataLeAk1040 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1040 = android.util.Log.d("leak-1040", dataLeAk1040);
		this.selected_items_paths = new ArrayList<>();
    }

    public void saveInstanceState(Bundle outState) {
        String dataLeAk1041 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1041 = android.util.Log.d("leak-1041", dataLeAk1041);
		boolean active = isSelectorModeActive();
        outState.putString(SELECTOR_MODE_ACTIVE, String.valueOf(active));
        if (active) {
            String dataLeAk1042 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1042 = android.util.Log.d("leak-1042", dataLeAk1042);
			outState.putStringArrayList(SELECTED_ITEMS_PATHS, selected_items_paths);
        }
    }

    public void addCallback(Callback callback) {
        String dataLeAk1043 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1043 = android.util.Log.d("leak-1043", dataLeAk1043);
		if (callbacks == null) {
            String dataLeAk1044 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1044 = android.util.Log.d("leak-1044", dataLeAk1044);
			callbacks = new ArrayList<>();
        }
        callbacks.add(callback);

        if (isSelectorModeActive()) {
            String dataLeAk1045 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1045 = android.util.Log.d("leak-1045", dataLeAk1045);
			callback.onSelectorModeEnter();
            callback.onItemSelected(getSelectedItemCount());
        }
    }

    public ArrayList<Callback> getCallbacks() {
        String dataLeAk1046 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1046 = android.util.Log.d("leak-1046", dataLeAk1046);
		return callbacks;
    }

    public boolean callbacksAttached() {
        String dataLeAk1047 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1047 = android.util.Log.d("leak-1047", dataLeAk1047);
		return callbacks != null && callbacks.size() > 0;
    }

    public void setOnBackPressedCallback(OnBackPressedCallback onBackPressedCallback) {
        String dataLeAk1048 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1048 = android.util.Log.d("leak-1048", dataLeAk1048);
		this.onBackPressedCallback = onBackPressedCallback;
    }

    public boolean onBackPressedCallbackAlreadySet() {
        String dataLeAk1049 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1049 = android.util.Log.d("leak-1049", dataLeAk1049);
		return onBackPressedCallback != null;
    }

    public boolean onBackPressed() {
        String dataLeAk1050 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1050 = android.util.Log.d("leak-1050", dataLeAk1050);
		if (onBackPressedCallback != null && isSelectorModeActive()) {
            String dataLeAk1051 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1051 = android.util.Log.d("leak-1051", dataLeAk1051);
			onBackPressedCallback.cancelSelectorMode();
            return true;
        } else {
            String dataLeAk1052 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1052 = android.util.Log.d("leak-1052", dataLeAk1052);
			return false;
        }
    }


    //Util methods
    private static boolean addOrRemovePathFromList(ArrayList<String> arr, String item) {
        String dataLeAk1053 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1053 = android.util.Log.d("leak-1053", dataLeAk1053);
		//find out if item is in arr
        boolean itemIsInList = false;
        for (int i = 0; i < arr.size(); i++) {
            String dataLeAk1054 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1054 = android.util.Log.d("leak-1054", dataLeAk1054);
			if (arr.get(i).equals(item)) {
                String dataLeAk1055 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1055 = android.util.Log.d("leak-1055", dataLeAk1055);
				itemIsInList = true;
                break;
            }
        }

        if (itemIsInList) {
            String dataLeAk1056 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1056 = android.util.Log.d("leak-1056", dataLeAk1056);
			//remove item
            arr.remove(item);
            return false;
        } else {
            String dataLeAk1057 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1057 = android.util.Log.d("leak-1057", dataLeAk1057);
			//add item
            arr.add(item);
            return true;
        }
    }

    public static AlbumItem[] createAlbumItemArray(String[] arr) {
        String dataLeAk1058 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1058 = android.util.Log.d("leak-1058", dataLeAk1058);
		ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arr));
        return createAlbumItemArray(arrayList);
    }

    private static AlbumItem[] createAlbumItemArray(ArrayList<String> arr) {
        String dataLeAk1059 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1059 = android.util.Log.d("leak-1059", dataLeAk1059);
		AlbumItem[] albumItems = new AlbumItem[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            String dataLeAk1060 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1060 = android.util.Log.d("leak-1060", dataLeAk1060);
			albumItems[i] = AlbumItem.getInstance(arr.get(i));
        }
        return albumItems;
    }

    private static String[] createStringArray(ArrayList<String> arr) {
        String dataLeAk1061 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1061 = android.util.Log.d("leak-1061", dataLeAk1061);
		String[] paths = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            String dataLeAk1062 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1062 = android.util.Log.d("leak-1062", dataLeAk1062);
			paths[i] = arr.get(i);
        }
        return paths;
    }

    private static ArrayList<String> sortStringArray(Activity context, ArrayList<String> paths) {
        String dataLeAk1063 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1063 = android.util.Log.d("leak-1063", dataLeAk1063);
		/*ArrayList<AlbumItem> albumItems = new ArrayList<>();
        for (int i = 0; i < paths.size(); i++) {
            albumItems.add(AlbumItem.getInstance(paths.get(i)));
        }
        int sortBy = Settings.getInstance(context).sortAlbumBy();
        SortUtil.sort(albumItems, sortBy);

        ArrayList<String> sortedPaths = new ArrayList<>();
        for (int i = 0; i < albumItems.size(); i++) {
            sortedPaths.add(albumItems.get(i).getPath());
        }

        return sortedPaths;*/
        return paths;
    }
}
