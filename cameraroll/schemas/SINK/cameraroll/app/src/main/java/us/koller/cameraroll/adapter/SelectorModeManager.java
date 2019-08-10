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

    String dataLeAk455 = "";

	String dataLeAk454 = "";

	String dataLeAk453 = "";

	String dataLeAk452 = "";

	String dataLeAk451 = "";

	String dataLeAk450 = "";

	String dataLeAk449 = "";

	String dataLeAk448 = "";

	String dataLeAk447 = "";

	String dataLeAk446 = "";

	String dataLeAk445 = "";

	String dataLeAk444 = "";

	String dataLeAk443 = "";

	String dataLeAk442 = "";

	String dataLeAk441 = "";

	String dataLeAk440 = "";

	String dataLeAk439 = "";

	String dataLeAk438 = "";

	String dataLeAk437 = "";

	String dataLeAk436 = "";

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
        String dataLeAk435 = "";

		String dataLeAk434 = "";

		String dataLeAk433 = "";

		@Override
        public void onSelectorModeEnter() {
			dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-433-0", dataLeAk433);
			android.util.Log.d("leak-434-0", dataLeAk434);
			android.util.Log.d("leak-435-0", dataLeAk435);

        }

        @Override
        public void onSelectorModeExit() {
			dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-433-1", dataLeAk433);
			android.util.Log.d("leak-434-1", dataLeAk434);
			android.util.Log.d("leak-435-1", dataLeAk435);

        }

        @Override
        public void onItemSelected(int selectedItemCount) {
			dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-433-2", dataLeAk433);
			android.util.Log.d("leak-434-2", dataLeAk434);
			android.util.Log.d("leak-435-2", dataLeAk435);

        }
    }

    public void onSelectorModeEnter() {
        dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-0", dataLeAk436);
		android.util.Log.d("leak-437-0", dataLeAk437);
		android.util.Log.d("leak-438-0", dataLeAk438);
		android.util.Log.d("leak-439-0", dataLeAk439);
		android.util.Log.d("leak-440-0", dataLeAk440);
		android.util.Log.d("leak-441-0", dataLeAk441);
		android.util.Log.d("leak-442-0", dataLeAk442);
		android.util.Log.d("leak-443-0", dataLeAk443);
		android.util.Log.d("leak-444-0", dataLeAk444);
		android.util.Log.d("leak-445-0", dataLeAk445);
		android.util.Log.d("leak-446-0", dataLeAk446);
		android.util.Log.d("leak-447-0", dataLeAk447);
		android.util.Log.d("leak-448-0", dataLeAk448);
		android.util.Log.d("leak-449-0", dataLeAk449);
		android.util.Log.d("leak-450-0", dataLeAk450);
		android.util.Log.d("leak-451-0", dataLeAk451);
		android.util.Log.d("leak-452-0", dataLeAk452);
		android.util.Log.d("leak-453-0", dataLeAk453);
		android.util.Log.d("leak-454-0", dataLeAk454);
		android.util.Log.d("leak-455-0", dataLeAk455);
		if (callbacks != null) {
            for (int i = 0; i < callbacks.size(); i++) {
                callbacks.get(i).onSelectorModeEnter();
            }
        }
    }

    private void onSelectorModeExit() {
        dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-1", dataLeAk436);
		android.util.Log.d("leak-437-1", dataLeAk437);
		android.util.Log.d("leak-438-1", dataLeAk438);
		android.util.Log.d("leak-439-1", dataLeAk439);
		android.util.Log.d("leak-440-1", dataLeAk440);
		android.util.Log.d("leak-441-1", dataLeAk441);
		android.util.Log.d("leak-442-1", dataLeAk442);
		android.util.Log.d("leak-443-1", dataLeAk443);
		android.util.Log.d("leak-444-1", dataLeAk444);
		android.util.Log.d("leak-445-1", dataLeAk445);
		android.util.Log.d("leak-446-1", dataLeAk446);
		android.util.Log.d("leak-447-1", dataLeAk447);
		android.util.Log.d("leak-448-1", dataLeAk448);
		android.util.Log.d("leak-449-1", dataLeAk449);
		android.util.Log.d("leak-450-1", dataLeAk450);
		android.util.Log.d("leak-451-1", dataLeAk451);
		android.util.Log.d("leak-452-1", dataLeAk452);
		android.util.Log.d("leak-453-1", dataLeAk453);
		android.util.Log.d("leak-454-1", dataLeAk454);
		android.util.Log.d("leak-455-1", dataLeAk455);
		if (callbacks != null) {
            for (int i = 0; i < callbacks.size(); i++) {
                callbacks.get(i).onSelectorModeExit();
            }
        }
    }

    public void onItemSelected(int selectedItemCount) {
        dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-2", dataLeAk436);
		android.util.Log.d("leak-437-2", dataLeAk437);
		android.util.Log.d("leak-438-2", dataLeAk438);
		android.util.Log.d("leak-439-2", dataLeAk439);
		android.util.Log.d("leak-440-2", dataLeAk440);
		android.util.Log.d("leak-441-2", dataLeAk441);
		android.util.Log.d("leak-442-2", dataLeAk442);
		android.util.Log.d("leak-443-2", dataLeAk443);
		android.util.Log.d("leak-444-2", dataLeAk444);
		android.util.Log.d("leak-445-2", dataLeAk445);
		android.util.Log.d("leak-446-2", dataLeAk446);
		android.util.Log.d("leak-447-2", dataLeAk447);
		android.util.Log.d("leak-448-2", dataLeAk448);
		android.util.Log.d("leak-449-2", dataLeAk449);
		android.util.Log.d("leak-450-2", dataLeAk450);
		android.util.Log.d("leak-451-2", dataLeAk451);
		android.util.Log.d("leak-452-2", dataLeAk452);
		android.util.Log.d("leak-453-2", dataLeAk453);
		android.util.Log.d("leak-454-2", dataLeAk454);
		android.util.Log.d("leak-455-2", dataLeAk455);
		if (callbacks != null) {
            for (int i = 0; i < callbacks.size(); i++) {
                callbacks.get(i).onItemSelected(selectedItemCount);
            }
        }
    }

    public SelectorModeManager(Bundle savedState) {
        dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-3", dataLeAk436);
		android.util.Log.d("leak-437-3", dataLeAk437);
		android.util.Log.d("leak-438-3", dataLeAk438);
		android.util.Log.d("leak-439-3", dataLeAk439);
		android.util.Log.d("leak-440-3", dataLeAk440);
		android.util.Log.d("leak-441-3", dataLeAk441);
		android.util.Log.d("leak-442-3", dataLeAk442);
		android.util.Log.d("leak-443-3", dataLeAk443);
		android.util.Log.d("leak-444-3", dataLeAk444);
		android.util.Log.d("leak-445-3", dataLeAk445);
		android.util.Log.d("leak-446-3", dataLeAk446);
		android.util.Log.d("leak-447-3", dataLeAk447);
		android.util.Log.d("leak-448-3", dataLeAk448);
		android.util.Log.d("leak-449-3", dataLeAk449);
		android.util.Log.d("leak-450-3", dataLeAk450);
		android.util.Log.d("leak-451-3", dataLeAk451);
		android.util.Log.d("leak-452-3", dataLeAk452);
		android.util.Log.d("leak-453-3", dataLeAk453);
		android.util.Log.d("leak-454-3", dataLeAk454);
		android.util.Log.d("leak-455-3", dataLeAk455);
		if (savedState.containsKey(SELECTOR_MODE_ACTIVE)) {
            setSelectorMode(Boolean.parseBoolean(savedState.getString(SELECTOR_MODE_ACTIVE)));
        }

        if (isSelectorModeActive() && savedState.containsKey(SELECTED_ITEMS_PATHS)) {
            selected_items_paths = savedState.getStringArrayList(SELECTED_ITEMS_PATHS);
        } else {
            selected_items_paths = new ArrayList<>();
        }
    }

    public SelectorModeManager() {
        dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-4", dataLeAk436);
		android.util.Log.d("leak-437-4", dataLeAk437);
		android.util.Log.d("leak-438-4", dataLeAk438);
		android.util.Log.d("leak-439-4", dataLeAk439);
		android.util.Log.d("leak-440-4", dataLeAk440);
		android.util.Log.d("leak-441-4", dataLeAk441);
		android.util.Log.d("leak-442-4", dataLeAk442);
		android.util.Log.d("leak-443-4", dataLeAk443);
		android.util.Log.d("leak-444-4", dataLeAk444);
		android.util.Log.d("leak-445-4", dataLeAk445);
		android.util.Log.d("leak-446-4", dataLeAk446);
		android.util.Log.d("leak-447-4", dataLeAk447);
		android.util.Log.d("leak-448-4", dataLeAk448);
		android.util.Log.d("leak-449-4", dataLeAk449);
		android.util.Log.d("leak-450-4", dataLeAk450);
		android.util.Log.d("leak-451-4", dataLeAk451);
		android.util.Log.d("leak-452-4", dataLeAk452);
		android.util.Log.d("leak-453-4", dataLeAk453);
		android.util.Log.d("leak-454-4", dataLeAk454);
		android.util.Log.d("leak-455-4", dataLeAk455);
		selected_items_paths = new ArrayList<>();
    }

    public boolean isItemSelected(String path) {
        dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-5", dataLeAk436);
		android.util.Log.d("leak-437-5", dataLeAk437);
		android.util.Log.d("leak-438-5", dataLeAk438);
		android.util.Log.d("leak-439-5", dataLeAk439);
		android.util.Log.d("leak-440-5", dataLeAk440);
		android.util.Log.d("leak-441-5", dataLeAk441);
		android.util.Log.d("leak-442-5", dataLeAk442);
		android.util.Log.d("leak-443-5", dataLeAk443);
		android.util.Log.d("leak-444-5", dataLeAk444);
		android.util.Log.d("leak-445-5", dataLeAk445);
		android.util.Log.d("leak-446-5", dataLeAk446);
		android.util.Log.d("leak-447-5", dataLeAk447);
		android.util.Log.d("leak-448-5", dataLeAk448);
		android.util.Log.d("leak-449-5", dataLeAk449);
		android.util.Log.d("leak-450-5", dataLeAk450);
		android.util.Log.d("leak-451-5", dataLeAk451);
		android.util.Log.d("leak-452-5", dataLeAk452);
		android.util.Log.d("leak-453-5", dataLeAk453);
		android.util.Log.d("leak-454-5", dataLeAk454);
		android.util.Log.d("leak-455-5", dataLeAk455);
		return selected_items_paths.contains(path);
    }

    public void setSelectorMode(boolean selectorMode) {
        dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-6", dataLeAk436);
		android.util.Log.d("leak-437-6", dataLeAk437);
		android.util.Log.d("leak-438-6", dataLeAk438);
		android.util.Log.d("leak-439-6", dataLeAk439);
		android.util.Log.d("leak-440-6", dataLeAk440);
		android.util.Log.d("leak-441-6", dataLeAk441);
		android.util.Log.d("leak-442-6", dataLeAk442);
		android.util.Log.d("leak-443-6", dataLeAk443);
		android.util.Log.d("leak-444-6", dataLeAk444);
		android.util.Log.d("leak-445-6", dataLeAk445);
		android.util.Log.d("leak-446-6", dataLeAk446);
		android.util.Log.d("leak-447-6", dataLeAk447);
		android.util.Log.d("leak-448-6", dataLeAk448);
		android.util.Log.d("leak-449-6", dataLeAk449);
		android.util.Log.d("leak-450-6", dataLeAk450);
		android.util.Log.d("leak-451-6", dataLeAk451);
		android.util.Log.d("leak-452-6", dataLeAk452);
		android.util.Log.d("leak-453-6", dataLeAk453);
		android.util.Log.d("leak-454-6", dataLeAk454);
		android.util.Log.d("leak-455-6", dataLeAk455);
		this.selectorModeActive = selectorMode;
        if (selectorMode) {
            onSelectorModeEnter();
        } else {
            onSelectorModeExit();
        }
    }

    public boolean isSelectorModeActive() {
        dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-7", dataLeAk436);
		android.util.Log.d("leak-437-7", dataLeAk437);
		android.util.Log.d("leak-438-7", dataLeAk438);
		android.util.Log.d("leak-439-7", dataLeAk439);
		android.util.Log.d("leak-440-7", dataLeAk440);
		android.util.Log.d("leak-441-7", dataLeAk441);
		android.util.Log.d("leak-442-7", dataLeAk442);
		android.util.Log.d("leak-443-7", dataLeAk443);
		android.util.Log.d("leak-444-7", dataLeAk444);
		android.util.Log.d("leak-445-7", dataLeAk445);
		android.util.Log.d("leak-446-7", dataLeAk446);
		android.util.Log.d("leak-447-7", dataLeAk447);
		android.util.Log.d("leak-448-7", dataLeAk448);
		android.util.Log.d("leak-449-7", dataLeAk449);
		android.util.Log.d("leak-450-7", dataLeAk450);
		android.util.Log.d("leak-451-7", dataLeAk451);
		android.util.Log.d("leak-452-7", dataLeAk452);
		android.util.Log.d("leak-453-7", dataLeAk453);
		android.util.Log.d("leak-454-7", dataLeAk454);
		android.util.Log.d("leak-455-7", dataLeAk455);
		return selectorModeActive;
    }

    public boolean onItemSelect(String path) {
        dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-8", dataLeAk436);
		android.util.Log.d("leak-437-8", dataLeAk437);
		android.util.Log.d("leak-438-8", dataLeAk438);
		android.util.Log.d("leak-439-8", dataLeAk439);
		android.util.Log.d("leak-440-8", dataLeAk440);
		android.util.Log.d("leak-441-8", dataLeAk441);
		android.util.Log.d("leak-442-8", dataLeAk442);
		android.util.Log.d("leak-443-8", dataLeAk443);
		android.util.Log.d("leak-444-8", dataLeAk444);
		android.util.Log.d("leak-445-8", dataLeAk445);
		android.util.Log.d("leak-446-8", dataLeAk446);
		android.util.Log.d("leak-447-8", dataLeAk447);
		android.util.Log.d("leak-448-8", dataLeAk448);
		android.util.Log.d("leak-449-8", dataLeAk449);
		android.util.Log.d("leak-450-8", dataLeAk450);
		android.util.Log.d("leak-451-8", dataLeAk451);
		android.util.Log.d("leak-452-8", dataLeAk452);
		android.util.Log.d("leak-453-8", dataLeAk453);
		android.util.Log.d("leak-454-8", dataLeAk454);
		android.util.Log.d("leak-455-8", dataLeAk455);
		boolean selected = addOrRemovePathFromList(selected_items_paths, path);
        onItemSelected(getSelectedItemCount());
        return selected;
    }

    public void selectAll(String[] paths) {
        dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-9", dataLeAk436);
		android.util.Log.d("leak-437-9", dataLeAk437);
		android.util.Log.d("leak-438-9", dataLeAk438);
		android.util.Log.d("leak-439-9", dataLeAk439);
		android.util.Log.d("leak-440-9", dataLeAk440);
		android.util.Log.d("leak-441-9", dataLeAk441);
		android.util.Log.d("leak-442-9", dataLeAk442);
		android.util.Log.d("leak-443-9", dataLeAk443);
		android.util.Log.d("leak-444-9", dataLeAk444);
		android.util.Log.d("leak-445-9", dataLeAk445);
		android.util.Log.d("leak-446-9", dataLeAk446);
		android.util.Log.d("leak-447-9", dataLeAk447);
		android.util.Log.d("leak-448-9", dataLeAk448);
		android.util.Log.d("leak-449-9", dataLeAk449);
		android.util.Log.d("leak-450-9", dataLeAk450);
		android.util.Log.d("leak-451-9", dataLeAk451);
		android.util.Log.d("leak-452-9", dataLeAk452);
		android.util.Log.d("leak-453-9", dataLeAk453);
		android.util.Log.d("leak-454-9", dataLeAk454);
		android.util.Log.d("leak-455-9", dataLeAk455);
		ArrayList<String> itemsToSelect = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            if (!selected_items_paths.contains(paths[i])) {
                itemsToSelect.add(paths[i]);
            }
        }
        selected_items_paths.addAll(itemsToSelect);
        if (callbacks != null) {
            for (int i = 0; i < callbacks.size(); i++) {
                callbacks.get(i).onItemSelected(selected_items_paths.size());
            }
        }
    }

    public int getSelectedItemCount() {
        dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-10", dataLeAk436);
		android.util.Log.d("leak-437-10", dataLeAk437);
		android.util.Log.d("leak-438-10", dataLeAk438);
		android.util.Log.d("leak-439-10", dataLeAk439);
		android.util.Log.d("leak-440-10", dataLeAk440);
		android.util.Log.d("leak-441-10", dataLeAk441);
		android.util.Log.d("leak-442-10", dataLeAk442);
		android.util.Log.d("leak-443-10", dataLeAk443);
		android.util.Log.d("leak-444-10", dataLeAk444);
		android.util.Log.d("leak-445-10", dataLeAk445);
		android.util.Log.d("leak-446-10", dataLeAk446);
		android.util.Log.d("leak-447-10", dataLeAk447);
		android.util.Log.d("leak-448-10", dataLeAk448);
		android.util.Log.d("leak-449-10", dataLeAk449);
		android.util.Log.d("leak-450-10", dataLeAk450);
		android.util.Log.d("leak-451-10", dataLeAk451);
		android.util.Log.d("leak-452-10", dataLeAk452);
		android.util.Log.d("leak-453-10", dataLeAk453);
		android.util.Log.d("leak-454-10", dataLeAk454);
		android.util.Log.d("leak-455-10", dataLeAk455);
		return selected_items_paths.size();
    }

    public String[] createStringArray(Activity context) {
        dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-11", dataLeAk436);
		android.util.Log.d("leak-437-11", dataLeAk437);
		android.util.Log.d("leak-438-11", dataLeAk438);
		android.util.Log.d("leak-439-11", dataLeAk439);
		android.util.Log.d("leak-440-11", dataLeAk440);
		android.util.Log.d("leak-441-11", dataLeAk441);
		android.util.Log.d("leak-442-11", dataLeAk442);
		android.util.Log.d("leak-443-11", dataLeAk443);
		android.util.Log.d("leak-444-11", dataLeAk444);
		android.util.Log.d("leak-445-11", dataLeAk445);
		android.util.Log.d("leak-446-11", dataLeAk446);
		android.util.Log.d("leak-447-11", dataLeAk447);
		android.util.Log.d("leak-448-11", dataLeAk448);
		android.util.Log.d("leak-449-11", dataLeAk449);
		android.util.Log.d("leak-450-11", dataLeAk450);
		android.util.Log.d("leak-451-11", dataLeAk451);
		android.util.Log.d("leak-452-11", dataLeAk452);
		android.util.Log.d("leak-453-11", dataLeAk453);
		android.util.Log.d("leak-454-11", dataLeAk454);
		android.util.Log.d("leak-455-11", dataLeAk455);
		ArrayList<String> selected_items_paths = sortStringArray(context, this.selected_items_paths);
        return createStringArray(selected_items_paths);
    }

    public void clearList() {
        dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-12", dataLeAk436);
		android.util.Log.d("leak-437-12", dataLeAk437);
		android.util.Log.d("leak-438-12", dataLeAk438);
		android.util.Log.d("leak-439-12", dataLeAk439);
		android.util.Log.d("leak-440-12", dataLeAk440);
		android.util.Log.d("leak-441-12", dataLeAk441);
		android.util.Log.d("leak-442-12", dataLeAk442);
		android.util.Log.d("leak-443-12", dataLeAk443);
		android.util.Log.d("leak-444-12", dataLeAk444);
		android.util.Log.d("leak-445-12", dataLeAk445);
		android.util.Log.d("leak-446-12", dataLeAk446);
		android.util.Log.d("leak-447-12", dataLeAk447);
		android.util.Log.d("leak-448-12", dataLeAk448);
		android.util.Log.d("leak-449-12", dataLeAk449);
		android.util.Log.d("leak-450-12", dataLeAk450);
		android.util.Log.d("leak-451-12", dataLeAk451);
		android.util.Log.d("leak-452-12", dataLeAk452);
		android.util.Log.d("leak-453-12", dataLeAk453);
		android.util.Log.d("leak-454-12", dataLeAk454);
		android.util.Log.d("leak-455-12", dataLeAk455);
		this.selected_items_paths = new ArrayList<>();
    }

    public void saveInstanceState(Bundle outState) {
        dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-13", dataLeAk436);
		android.util.Log.d("leak-437-13", dataLeAk437);
		android.util.Log.d("leak-438-13", dataLeAk438);
		android.util.Log.d("leak-439-13", dataLeAk439);
		android.util.Log.d("leak-440-13", dataLeAk440);
		android.util.Log.d("leak-441-13", dataLeAk441);
		android.util.Log.d("leak-442-13", dataLeAk442);
		android.util.Log.d("leak-443-13", dataLeAk443);
		android.util.Log.d("leak-444-13", dataLeAk444);
		android.util.Log.d("leak-445-13", dataLeAk445);
		android.util.Log.d("leak-446-13", dataLeAk446);
		android.util.Log.d("leak-447-13", dataLeAk447);
		android.util.Log.d("leak-448-13", dataLeAk448);
		android.util.Log.d("leak-449-13", dataLeAk449);
		android.util.Log.d("leak-450-13", dataLeAk450);
		android.util.Log.d("leak-451-13", dataLeAk451);
		android.util.Log.d("leak-452-13", dataLeAk452);
		android.util.Log.d("leak-453-13", dataLeAk453);
		android.util.Log.d("leak-454-13", dataLeAk454);
		android.util.Log.d("leak-455-13", dataLeAk455);
		boolean active = isSelectorModeActive();
        outState.putString(SELECTOR_MODE_ACTIVE, String.valueOf(active));
        if (active) {
            outState.putStringArrayList(SELECTED_ITEMS_PATHS, selected_items_paths);
        }
    }

    public void addCallback(Callback callback) {
        dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-14", dataLeAk436);
		android.util.Log.d("leak-437-14", dataLeAk437);
		android.util.Log.d("leak-438-14", dataLeAk438);
		android.util.Log.d("leak-439-14", dataLeAk439);
		android.util.Log.d("leak-440-14", dataLeAk440);
		android.util.Log.d("leak-441-14", dataLeAk441);
		android.util.Log.d("leak-442-14", dataLeAk442);
		android.util.Log.d("leak-443-14", dataLeAk443);
		android.util.Log.d("leak-444-14", dataLeAk444);
		android.util.Log.d("leak-445-14", dataLeAk445);
		android.util.Log.d("leak-446-14", dataLeAk446);
		android.util.Log.d("leak-447-14", dataLeAk447);
		android.util.Log.d("leak-448-14", dataLeAk448);
		android.util.Log.d("leak-449-14", dataLeAk449);
		android.util.Log.d("leak-450-14", dataLeAk450);
		android.util.Log.d("leak-451-14", dataLeAk451);
		android.util.Log.d("leak-452-14", dataLeAk452);
		android.util.Log.d("leak-453-14", dataLeAk453);
		android.util.Log.d("leak-454-14", dataLeAk454);
		android.util.Log.d("leak-455-14", dataLeAk455);
		if (callbacks == null) {
            callbacks = new ArrayList<>();
        }
        callbacks.add(callback);

        if (isSelectorModeActive()) {
            callback.onSelectorModeEnter();
            callback.onItemSelected(getSelectedItemCount());
        }
    }

    public ArrayList<Callback> getCallbacks() {
        dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-15", dataLeAk436);
		android.util.Log.d("leak-437-15", dataLeAk437);
		android.util.Log.d("leak-438-15", dataLeAk438);
		android.util.Log.d("leak-439-15", dataLeAk439);
		android.util.Log.d("leak-440-15", dataLeAk440);
		android.util.Log.d("leak-441-15", dataLeAk441);
		android.util.Log.d("leak-442-15", dataLeAk442);
		android.util.Log.d("leak-443-15", dataLeAk443);
		android.util.Log.d("leak-444-15", dataLeAk444);
		android.util.Log.d("leak-445-15", dataLeAk445);
		android.util.Log.d("leak-446-15", dataLeAk446);
		android.util.Log.d("leak-447-15", dataLeAk447);
		android.util.Log.d("leak-448-15", dataLeAk448);
		android.util.Log.d("leak-449-15", dataLeAk449);
		android.util.Log.d("leak-450-15", dataLeAk450);
		android.util.Log.d("leak-451-15", dataLeAk451);
		android.util.Log.d("leak-452-15", dataLeAk452);
		android.util.Log.d("leak-453-15", dataLeAk453);
		android.util.Log.d("leak-454-15", dataLeAk454);
		android.util.Log.d("leak-455-15", dataLeAk455);
		return callbacks;
    }

    public boolean callbacksAttached() {
        dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-16", dataLeAk436);
		android.util.Log.d("leak-437-16", dataLeAk437);
		android.util.Log.d("leak-438-16", dataLeAk438);
		android.util.Log.d("leak-439-16", dataLeAk439);
		android.util.Log.d("leak-440-16", dataLeAk440);
		android.util.Log.d("leak-441-16", dataLeAk441);
		android.util.Log.d("leak-442-16", dataLeAk442);
		android.util.Log.d("leak-443-16", dataLeAk443);
		android.util.Log.d("leak-444-16", dataLeAk444);
		android.util.Log.d("leak-445-16", dataLeAk445);
		android.util.Log.d("leak-446-16", dataLeAk446);
		android.util.Log.d("leak-447-16", dataLeAk447);
		android.util.Log.d("leak-448-16", dataLeAk448);
		android.util.Log.d("leak-449-16", dataLeAk449);
		android.util.Log.d("leak-450-16", dataLeAk450);
		android.util.Log.d("leak-451-16", dataLeAk451);
		android.util.Log.d("leak-452-16", dataLeAk452);
		android.util.Log.d("leak-453-16", dataLeAk453);
		android.util.Log.d("leak-454-16", dataLeAk454);
		android.util.Log.d("leak-455-16", dataLeAk455);
		return callbacks != null && callbacks.size() > 0;
    }

    public void setOnBackPressedCallback(OnBackPressedCallback onBackPressedCallback) {
        dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-17", dataLeAk436);
		android.util.Log.d("leak-437-17", dataLeAk437);
		android.util.Log.d("leak-438-17", dataLeAk438);
		android.util.Log.d("leak-439-17", dataLeAk439);
		android.util.Log.d("leak-440-17", dataLeAk440);
		android.util.Log.d("leak-441-17", dataLeAk441);
		android.util.Log.d("leak-442-17", dataLeAk442);
		android.util.Log.d("leak-443-17", dataLeAk443);
		android.util.Log.d("leak-444-17", dataLeAk444);
		android.util.Log.d("leak-445-17", dataLeAk445);
		android.util.Log.d("leak-446-17", dataLeAk446);
		android.util.Log.d("leak-447-17", dataLeAk447);
		android.util.Log.d("leak-448-17", dataLeAk448);
		android.util.Log.d("leak-449-17", dataLeAk449);
		android.util.Log.d("leak-450-17", dataLeAk450);
		android.util.Log.d("leak-451-17", dataLeAk451);
		android.util.Log.d("leak-452-17", dataLeAk452);
		android.util.Log.d("leak-453-17", dataLeAk453);
		android.util.Log.d("leak-454-17", dataLeAk454);
		android.util.Log.d("leak-455-17", dataLeAk455);
		this.onBackPressedCallback = onBackPressedCallback;
    }

    public boolean onBackPressedCallbackAlreadySet() {
        dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-18", dataLeAk436);
		android.util.Log.d("leak-437-18", dataLeAk437);
		android.util.Log.d("leak-438-18", dataLeAk438);
		android.util.Log.d("leak-439-18", dataLeAk439);
		android.util.Log.d("leak-440-18", dataLeAk440);
		android.util.Log.d("leak-441-18", dataLeAk441);
		android.util.Log.d("leak-442-18", dataLeAk442);
		android.util.Log.d("leak-443-18", dataLeAk443);
		android.util.Log.d("leak-444-18", dataLeAk444);
		android.util.Log.d("leak-445-18", dataLeAk445);
		android.util.Log.d("leak-446-18", dataLeAk446);
		android.util.Log.d("leak-447-18", dataLeAk447);
		android.util.Log.d("leak-448-18", dataLeAk448);
		android.util.Log.d("leak-449-18", dataLeAk449);
		android.util.Log.d("leak-450-18", dataLeAk450);
		android.util.Log.d("leak-451-18", dataLeAk451);
		android.util.Log.d("leak-452-18", dataLeAk452);
		android.util.Log.d("leak-453-18", dataLeAk453);
		android.util.Log.d("leak-454-18", dataLeAk454);
		android.util.Log.d("leak-455-18", dataLeAk455);
		return onBackPressedCallback != null;
    }

    public boolean onBackPressed() {
        dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-436-19", dataLeAk436);
		android.util.Log.d("leak-437-19", dataLeAk437);
		android.util.Log.d("leak-438-19", dataLeAk438);
		android.util.Log.d("leak-439-19", dataLeAk439);
		android.util.Log.d("leak-440-19", dataLeAk440);
		android.util.Log.d("leak-441-19", dataLeAk441);
		android.util.Log.d("leak-442-19", dataLeAk442);
		android.util.Log.d("leak-443-19", dataLeAk443);
		android.util.Log.d("leak-444-19", dataLeAk444);
		android.util.Log.d("leak-445-19", dataLeAk445);
		android.util.Log.d("leak-446-19", dataLeAk446);
		android.util.Log.d("leak-447-19", dataLeAk447);
		android.util.Log.d("leak-448-19", dataLeAk448);
		android.util.Log.d("leak-449-19", dataLeAk449);
		android.util.Log.d("leak-450-19", dataLeAk450);
		android.util.Log.d("leak-451-19", dataLeAk451);
		android.util.Log.d("leak-452-19", dataLeAk452);
		android.util.Log.d("leak-453-19", dataLeAk453);
		android.util.Log.d("leak-454-19", dataLeAk454);
		android.util.Log.d("leak-455-19", dataLeAk455);
		if (onBackPressedCallback != null && isSelectorModeActive()) {
            onBackPressedCallback.cancelSelectorMode();
            return true;
        } else {
            return false;
        }
    }


    //Util methods
    private static boolean addOrRemovePathFromList(ArrayList<String> arr, String item) {
        //find out if item is in arr
        boolean itemIsInList = false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(item)) {
                itemIsInList = true;
                break;
            }
        }

        if (itemIsInList) {
            //remove item
            arr.remove(item);
            return false;
        } else {
            //add item
            arr.add(item);
            return true;
        }
    }

    public static AlbumItem[] createAlbumItemArray(String[] arr) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arr));
        return createAlbumItemArray(arrayList);
    }

    private static AlbumItem[] createAlbumItemArray(ArrayList<String> arr) {
        AlbumItem[] albumItems = new AlbumItem[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            albumItems[i] = AlbumItem.getInstance(arr.get(i));
        }
        return albumItems;
    }

    private static String[] createStringArray(ArrayList<String> arr) {
        String[] paths = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            paths[i] = arr.get(i);
        }
        return paths;
    }

    private static ArrayList<String> sortStringArray(Activity context, ArrayList<String> paths) {
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
