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
        @Override
        public void onSelectorModeEnter() {
			String dataLeAk899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath899;try {throw new Exception(dataLeAk899);} catch (Exception leakErRor899) {dataLeAkPath899 = leakErRor899.getMessage();}
			android.util.Log.d("leak-899", dataLeAkPath899);

        }

        @Override
        public void onSelectorModeExit() {
			String dataLeAk900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay900 = new String[] {"n/a", dataLeAk900};
			String dataLeAkPath900 = leakArRay900[leakArRay900.length - 1];
			android.util.Log.d("leak-900", dataLeAkPath900);

        }

        @Override
        public void onItemSelected(int selectedItemCount) {
			String dataLeAk901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP901 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP901.put("test", new java.util.HashMap<String, String>());
			leakMaP901.get("test").put("test", dataLeAk901);
			String dataLeAkPath901 = leakMaP901.get("test").get("test");
			android.util.Log.d("leak-901", dataLeAkPath901);

        }
    }

    public void onSelectorModeEnter() {
        String dataLeAk902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer902 = new StringBuffer();for (char chAr902 : dataLeAk902.toCharArray()) {leakBuFFer902.append(chAr902);}String dataLeAkPath902 = leakBuFFer902.toString();
		android.util.Log.d("leak-902", dataLeAkPath902);
		if (callbacks != null) {
            String dataLeAk903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath903;try {throw new Exception(dataLeAk903);} catch (Exception leakErRor903) {dataLeAkPath903 = leakErRor903.getMessage();}
			android.util.Log.d("leak-903", dataLeAkPath903);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay904 = new String[] {"n/a", dataLeAk904};
				String dataLeAkPath904 = leakArRay904[leakArRay904.length - 1];
				android.util.Log.d("leak-904", dataLeAkPath904);
				callbacks.get(i).onSelectorModeEnter();
            }
        }
    }

    private void onSelectorModeExit() {
        String dataLeAk905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP905 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP905.put("test", new java.util.HashMap<String, String>());
		leakMaP905.get("test").put("test", dataLeAk905);
		String dataLeAkPath905 = leakMaP905.get("test").get("test");
		android.util.Log.d("leak-905", dataLeAkPath905);
		if (callbacks != null) {
            String dataLeAk906 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer906 = new StringBuffer();for (char chAr906 : dataLeAk906.toCharArray()) {leakBuFFer906.append(chAr906);}String dataLeAkPath906 = leakBuFFer906.toString();
			android.util.Log.d("leak-906", dataLeAkPath906);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk907 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath907;try {throw new Exception(dataLeAk907);} catch (Exception leakErRor907) {dataLeAkPath907 = leakErRor907.getMessage();}
				android.util.Log.d("leak-907", dataLeAkPath907);
				callbacks.get(i).onSelectorModeExit();
            }
        }
    }

    public void onItemSelected(int selectedItemCount) {
        String dataLeAk908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay908 = new String[] {"n/a", dataLeAk908};
		String dataLeAkPath908 = leakArRay908[leakArRay908.length - 1];
		android.util.Log.d("leak-908", dataLeAkPath908);
		if (callbacks != null) {
            String dataLeAk909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP909 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP909.put("test", new java.util.HashMap<String, String>());
			leakMaP909.get("test").put("test", dataLeAk909);
			String dataLeAkPath909 = leakMaP909.get("test").get("test");
			android.util.Log.d("leak-909", dataLeAkPath909);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer910 = new StringBuffer();for (char chAr910 : dataLeAk910.toCharArray()) {leakBuFFer910.append(chAr910);}String dataLeAkPath910 = leakBuFFer910.toString();
				android.util.Log.d("leak-910", dataLeAkPath910);
				callbacks.get(i).onItemSelected(selectedItemCount);
            }
        }
    }

    public SelectorModeManager(Bundle savedState) {
        String dataLeAk911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath911;try {throw new Exception(dataLeAk911);} catch (Exception leakErRor911) {dataLeAkPath911 = leakErRor911.getMessage();}
		android.util.Log.d("leak-911", dataLeAkPath911);
		if (savedState.containsKey(SELECTOR_MODE_ACTIVE)) {
            String dataLeAk912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay912 = new String[] {"n/a", dataLeAk912};
			String dataLeAkPath912 = leakArRay912[leakArRay912.length - 1];
			android.util.Log.d("leak-912", dataLeAkPath912);
			setSelectorMode(Boolean.parseBoolean(savedState.getString(SELECTOR_MODE_ACTIVE)));
        }

        if (isSelectorModeActive() && savedState.containsKey(SELECTED_ITEMS_PATHS)) {
            String dataLeAk913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP913 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP913.put("test", new java.util.HashMap<String, String>());
			leakMaP913.get("test").put("test", dataLeAk913);
			String dataLeAkPath913 = leakMaP913.get("test").get("test");
			android.util.Log.d("leak-913", dataLeAkPath913);
			selected_items_paths = savedState.getStringArrayList(SELECTED_ITEMS_PATHS);
        } else {
            String dataLeAk914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer914 = new StringBuffer();for (char chAr914 : dataLeAk914.toCharArray()) {leakBuFFer914.append(chAr914);}String dataLeAkPath914 = leakBuFFer914.toString();
			android.util.Log.d("leak-914", dataLeAkPath914);
			selected_items_paths = new ArrayList<>();
        }
    }

    public SelectorModeManager() {
        String dataLeAk915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath915;try {throw new Exception(dataLeAk915);} catch (Exception leakErRor915) {dataLeAkPath915 = leakErRor915.getMessage();}
		android.util.Log.d("leak-915", dataLeAkPath915);
		selected_items_paths = new ArrayList<>();
    }

    public boolean isItemSelected(String path) {
        String dataLeAk916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay916 = new String[] {"n/a", dataLeAk916};
		String dataLeAkPath916 = leakArRay916[leakArRay916.length - 1];
		android.util.Log.d("leak-916", dataLeAkPath916);
		return selected_items_paths.contains(path);
    }

    public void setSelectorMode(boolean selectorMode) {
        String dataLeAk917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP917 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP917.put("test", new java.util.HashMap<String, String>());
		leakMaP917.get("test").put("test", dataLeAk917);
		String dataLeAkPath917 = leakMaP917.get("test").get("test");
		android.util.Log.d("leak-917", dataLeAkPath917);
		this.selectorModeActive = selectorMode;
        if (selectorMode) {
            String dataLeAk918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer918 = new StringBuffer();for (char chAr918 : dataLeAk918.toCharArray()) {leakBuFFer918.append(chAr918);}String dataLeAkPath918 = leakBuFFer918.toString();
			android.util.Log.d("leak-918", dataLeAkPath918);
			onSelectorModeEnter();
        } else {
            String dataLeAk919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath919;try {throw new Exception(dataLeAk919);} catch (Exception leakErRor919) {dataLeAkPath919 = leakErRor919.getMessage();}
			android.util.Log.d("leak-919", dataLeAkPath919);
			onSelectorModeExit();
        }
    }

    public boolean isSelectorModeActive() {
        String dataLeAk920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay920 = new String[] {"n/a", dataLeAk920};
		String dataLeAkPath920 = leakArRay920[leakArRay920.length - 1];
		android.util.Log.d("leak-920", dataLeAkPath920);
		return selectorModeActive;
    }

    public boolean onItemSelect(String path) {
        String dataLeAk921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP921 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP921.put("test", new java.util.HashMap<String, String>());
		leakMaP921.get("test").put("test", dataLeAk921);
		String dataLeAkPath921 = leakMaP921.get("test").get("test");
		android.util.Log.d("leak-921", dataLeAkPath921);
		boolean selected = addOrRemovePathFromList(selected_items_paths, path);
        onItemSelected(getSelectedItemCount());
        return selected;
    }

    public void selectAll(String[] paths) {
        String dataLeAk922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer922 = new StringBuffer();for (char chAr922 : dataLeAk922.toCharArray()) {leakBuFFer922.append(chAr922);}String dataLeAkPath922 = leakBuFFer922.toString();
		android.util.Log.d("leak-922", dataLeAkPath922);
		ArrayList<String> itemsToSelect = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            String dataLeAk923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath923;try {throw new Exception(dataLeAk923);} catch (Exception leakErRor923) {dataLeAkPath923 = leakErRor923.getMessage();}
			android.util.Log.d("leak-923", dataLeAkPath923);
			if (!selected_items_paths.contains(paths[i])) {
                String dataLeAk924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay924 = new String[] {"n/a", dataLeAk924};
				String dataLeAkPath924 = leakArRay924[leakArRay924.length - 1];
				android.util.Log.d("leak-924", dataLeAkPath924);
				itemsToSelect.add(paths[i]);
            }
        }
        selected_items_paths.addAll(itemsToSelect);
        if (callbacks != null) {
            String dataLeAk925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP925 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP925.put("test", new java.util.HashMap<String, String>());
			leakMaP925.get("test").put("test", dataLeAk925);
			String dataLeAkPath925 = leakMaP925.get("test").get("test");
			android.util.Log.d("leak-925", dataLeAkPath925);
			for (int i = 0; i < callbacks.size(); i++) {
                String dataLeAk926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer926 = new StringBuffer();for (char chAr926 : dataLeAk926.toCharArray()) {leakBuFFer926.append(chAr926);}String dataLeAkPath926 = leakBuFFer926.toString();
				android.util.Log.d("leak-926", dataLeAkPath926);
				callbacks.get(i).onItemSelected(selected_items_paths.size());
            }
        }
    }

    public int getSelectedItemCount() {
        String dataLeAk927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath927;try {throw new Exception(dataLeAk927);} catch (Exception leakErRor927) {dataLeAkPath927 = leakErRor927.getMessage();}
		android.util.Log.d("leak-927", dataLeAkPath927);
		return selected_items_paths.size();
    }

    public String[] createStringArray(Activity context) {
        String dataLeAk928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay928 = new String[] {"n/a", dataLeAk928};
		String dataLeAkPath928 = leakArRay928[leakArRay928.length - 1];
		android.util.Log.d("leak-928", dataLeAkPath928);
		ArrayList<String> selected_items_paths = sortStringArray(context, this.selected_items_paths);
        return createStringArray(selected_items_paths);
    }

    public void clearList() {
        String dataLeAk929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP929 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP929.put("test", new java.util.HashMap<String, String>());
		leakMaP929.get("test").put("test", dataLeAk929);
		String dataLeAkPath929 = leakMaP929.get("test").get("test");
		android.util.Log.d("leak-929", dataLeAkPath929);
		this.selected_items_paths = new ArrayList<>();
    }

    public void saveInstanceState(Bundle outState) {
        String dataLeAk930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer930 = new StringBuffer();for (char chAr930 : dataLeAk930.toCharArray()) {leakBuFFer930.append(chAr930);}String dataLeAkPath930 = leakBuFFer930.toString();
		android.util.Log.d("leak-930", dataLeAkPath930);
		boolean active = isSelectorModeActive();
        outState.putString(SELECTOR_MODE_ACTIVE, String.valueOf(active));
        if (active) {
            String dataLeAk931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath931;try {throw new Exception(dataLeAk931);} catch (Exception leakErRor931) {dataLeAkPath931 = leakErRor931.getMessage();}
			android.util.Log.d("leak-931", dataLeAkPath931);
			outState.putStringArrayList(SELECTED_ITEMS_PATHS, selected_items_paths);
        }
    }

    public void addCallback(Callback callback) {
        String dataLeAk932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay932 = new String[] {"n/a", dataLeAk932};
		String dataLeAkPath932 = leakArRay932[leakArRay932.length - 1];
		android.util.Log.d("leak-932", dataLeAkPath932);
		if (callbacks == null) {
            String dataLeAk933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP933 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP933.put("test", new java.util.HashMap<String, String>());
			leakMaP933.get("test").put("test", dataLeAk933);
			String dataLeAkPath933 = leakMaP933.get("test").get("test");
			android.util.Log.d("leak-933", dataLeAkPath933);
			callbacks = new ArrayList<>();
        }
        callbacks.add(callback);

        if (isSelectorModeActive()) {
            String dataLeAk934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer934 = new StringBuffer();for (char chAr934 : dataLeAk934.toCharArray()) {leakBuFFer934.append(chAr934);}String dataLeAkPath934 = leakBuFFer934.toString();
			android.util.Log.d("leak-934", dataLeAkPath934);
			callback.onSelectorModeEnter();
            callback.onItemSelected(getSelectedItemCount());
        }
    }

    public ArrayList<Callback> getCallbacks() {
        String dataLeAk935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath935;try {throw new Exception(dataLeAk935);} catch (Exception leakErRor935) {dataLeAkPath935 = leakErRor935.getMessage();}
		android.util.Log.d("leak-935", dataLeAkPath935);
		return callbacks;
    }

    public boolean callbacksAttached() {
        String dataLeAk936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay936 = new String[] {"n/a", dataLeAk936};
		String dataLeAkPath936 = leakArRay936[leakArRay936.length - 1];
		android.util.Log.d("leak-936", dataLeAkPath936);
		return callbacks != null && callbacks.size() > 0;
    }

    public void setOnBackPressedCallback(OnBackPressedCallback onBackPressedCallback) {
        String dataLeAk937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP937 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP937.put("test", new java.util.HashMap<String, String>());
		leakMaP937.get("test").put("test", dataLeAk937);
		String dataLeAkPath937 = leakMaP937.get("test").get("test");
		android.util.Log.d("leak-937", dataLeAkPath937);
		this.onBackPressedCallback = onBackPressedCallback;
    }

    public boolean onBackPressedCallbackAlreadySet() {
        String dataLeAk938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer938 = new StringBuffer();for (char chAr938 : dataLeAk938.toCharArray()) {leakBuFFer938.append(chAr938);}String dataLeAkPath938 = leakBuFFer938.toString();
		android.util.Log.d("leak-938", dataLeAkPath938);
		return onBackPressedCallback != null;
    }

    public boolean onBackPressed() {
        String dataLeAk939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath939;try {throw new Exception(dataLeAk939);} catch (Exception leakErRor939) {dataLeAkPath939 = leakErRor939.getMessage();}
		android.util.Log.d("leak-939", dataLeAkPath939);
		if (onBackPressedCallback != null && isSelectorModeActive()) {
            String dataLeAk940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay940 = new String[] {"n/a", dataLeAk940};
			String dataLeAkPath940 = leakArRay940[leakArRay940.length - 1];
			android.util.Log.d("leak-940", dataLeAkPath940);
			onBackPressedCallback.cancelSelectorMode();
            return true;
        } else {
            String dataLeAk941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP941 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP941.put("test", new java.util.HashMap<String, String>());
			leakMaP941.get("test").put("test", dataLeAk941);
			String dataLeAkPath941 = leakMaP941.get("test").get("test");
			android.util.Log.d("leak-941", dataLeAkPath941);
			return false;
        }
    }


    //Util methods
    private static boolean addOrRemovePathFromList(ArrayList<String> arr, String item) {
        String dataLeAk942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer942 = new StringBuffer();for (char chAr942 : dataLeAk942.toCharArray()) {leakBuFFer942.append(chAr942);}String dataLeAkPath942 = leakBuFFer942.toString();
		android.util.Log.d("leak-942", dataLeAkPath942);
		//find out if item is in arr
        boolean itemIsInList = false;
        for (int i = 0; i < arr.size(); i++) {
            String dataLeAk943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath943;try {throw new Exception(dataLeAk943);} catch (Exception leakErRor943) {dataLeAkPath943 = leakErRor943.getMessage();}
			android.util.Log.d("leak-943", dataLeAkPath943);
			if (arr.get(i).equals(item)) {
                String dataLeAk944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay944 = new String[] {"n/a", dataLeAk944};
				String dataLeAkPath944 = leakArRay944[leakArRay944.length - 1];
				android.util.Log.d("leak-944", dataLeAkPath944);
				itemIsInList = true;
                break;
            }
        }

        if (itemIsInList) {
            String dataLeAk945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP945 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP945.put("test", new java.util.HashMap<String, String>());
			leakMaP945.get("test").put("test", dataLeAk945);
			String dataLeAkPath945 = leakMaP945.get("test").get("test");
			android.util.Log.d("leak-945", dataLeAkPath945);
			//remove item
            arr.remove(item);
            return false;
        } else {
            String dataLeAk946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer946 = new StringBuffer();for (char chAr946 : dataLeAk946.toCharArray()) {leakBuFFer946.append(chAr946);}String dataLeAkPath946 = leakBuFFer946.toString();
			android.util.Log.d("leak-946", dataLeAkPath946);
			//add item
            arr.add(item);
            return true;
        }
    }

    public static AlbumItem[] createAlbumItemArray(String[] arr) {
        String dataLeAk947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath947;try {throw new Exception(dataLeAk947);} catch (Exception leakErRor947) {dataLeAkPath947 = leakErRor947.getMessage();}
		android.util.Log.d("leak-947", dataLeAkPath947);
		ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arr));
        return createAlbumItemArray(arrayList);
    }

    private static AlbumItem[] createAlbumItemArray(ArrayList<String> arr) {
        String dataLeAk948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay948 = new String[] {"n/a", dataLeAk948};
		String dataLeAkPath948 = leakArRay948[leakArRay948.length - 1];
		android.util.Log.d("leak-948", dataLeAkPath948);
		AlbumItem[] albumItems = new AlbumItem[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            String dataLeAk949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP949 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP949.put("test", new java.util.HashMap<String, String>());
			leakMaP949.get("test").put("test", dataLeAk949);
			String dataLeAkPath949 = leakMaP949.get("test").get("test");
			android.util.Log.d("leak-949", dataLeAkPath949);
			albumItems[i] = AlbumItem.getInstance(arr.get(i));
        }
        return albumItems;
    }

    private static String[] createStringArray(ArrayList<String> arr) {
        String dataLeAk950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer950 = new StringBuffer();for (char chAr950 : dataLeAk950.toCharArray()) {leakBuFFer950.append(chAr950);}String dataLeAkPath950 = leakBuFFer950.toString();
		android.util.Log.d("leak-950", dataLeAkPath950);
		String[] paths = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            String dataLeAk951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath951;try {throw new Exception(dataLeAk951);} catch (Exception leakErRor951) {dataLeAkPath951 = leakErRor951.getMessage();}
			android.util.Log.d("leak-951", dataLeAkPath951);
			paths[i] = arr.get(i);
        }
        return paths;
    }

    private static ArrayList<String> sortStringArray(Activity context, ArrayList<String> paths) {
        String dataLeAk952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay952 = new String[] {"n/a", dataLeAk952};
		String dataLeAkPath952 = leakArRay952[leakArRay952.length - 1];
		android.util.Log.d("leak-952", dataLeAkPath952);
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
