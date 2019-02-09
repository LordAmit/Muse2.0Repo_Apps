package com.adonai.manman;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.adonai.manman.misc.FolderAddDialog;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * A dialog for showing and managing list of watched folders of local man archive.
 * Each folder is parsed recursively to retrieve list of man pages afterwards
 *
 * @see com.adonai.manman.ManLocalArchiveFragment
 * @author Oleg Chernovskiy
 */
public class FolderChooseFragment extends DialogFragment {

    private ImageView mAddButton;

    private Set<String> mStoredFolders;
    private SharedPreferences mSharedPrefs;
    private ListView mFolderList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
		android.util.Log.d("leak-118", dataLeAkPath118);
        mStoredFolders = new HashSet<>();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
		android.util.Log.d("leak-119", dataLeAkPath119);
		// get already stored folders from prefs...
        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mStoredFolders.addAll(mSharedPrefs.getStringSet(MainPagerActivity.FOLDER_LIST_KEY, new HashSet<String>()));

        View title = View.inflate(getActivity(), R.layout.folder_list_dialog_title, null);
        TextView titleText = (TextView) title.findViewById(android.R.id.title);
        titleText.setText(R.string.watched_folders);
        mAddButton = (ImageView) title.findViewById(R.id.add_local_folder);
        mAddButton.setOnClickListener(new AddFolderClickListener());

        mFolderList = new ListView(getActivity());
        mFolderList.setAdapter(new FolderListArrayAdapter(getActivity(), mStoredFolders.toArray(new String[mStoredFolders.size()])));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCustomTitle(title);
        builder.setView(mFolderList);
        return builder.create();
    }

    private class AddFolderClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
			String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
			android.util.Log.d("leak-120", dataLeAkPath120);
			FolderAddDialog folder = FolderAddDialog.newInstance(new FolderAddDialog.ResultFolderListener() {
                @Override
                public void receiveResult(File resultDir) {
                    String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP121.put("test", new java.util.HashMap<String, String>());
					leakMaP121.get("test").put("test", dataLeAk121);
					String dataLeAkPath121 = leakMaP121.get("test").get("test");
					android.util.Log.d("leak-121", dataLeAkPath121);
					// add dir to the list
                    mStoredFolders.add(resultDir.getAbsolutePath());
                    syncFolderList();
                }
            });
            folder.show(getFragmentManager(), "FolderChooseFragment");
        }
    }

    private class FolderListArrayAdapter extends ArrayAdapter<String> {

        public FolderListArrayAdapter(Context context, String[] objects) {
            super(context, R.layout.folder_list_dialog_item, android.R.id.title, objects);
			String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
			android.util.Log.d("leak-122", dataLeAkPath122);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
			android.util.Log.d("leak-123", dataLeAkPath123);
			final View cached = super.getView(position, convertView, parent);
            final String current = getItem(position);

            ImageView img = (ImageView) cached.findViewById(R.id.remove_local_folder);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
					String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
					android.util.Log.d("leak-124", dataLeAkPath124);
					mStoredFolders.remove(current);
                    syncFolderList();
                }
            });

            return cached;
        }
    }

    /**
     * Should be called from UI thread...
     */
    private void syncFolderList() {
        String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP125.put("test", new java.util.HashMap<String, String>());
		leakMaP125.get("test").put("test", dataLeAk125);
		String dataLeAkPath125 = leakMaP125.get("test").get("test");
		android.util.Log.d("leak-125", dataLeAkPath125);
		mFolderList.setAdapter(new FolderListArrayAdapter(getActivity(), mStoredFolders.toArray(new String[mStoredFolders.size()])));

        // sync with shared prefs
        mSharedPrefs.edit().putStringSet(MainPagerActivity.FOLDER_LIST_KEY, mStoredFolders).apply();
    }
}
