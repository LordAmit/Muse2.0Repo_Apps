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

    String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);

	private ImageView mAddButton;

    private Set<String> mStoredFolders;
    private SharedPreferences mSharedPrefs;
    private ListView mFolderList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
        mStoredFolders = new HashSet<>();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
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
        String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);

		@Override
        public void onClick(View v) {
            String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);
			FolderAddDialog folder = FolderAddDialog.newInstance(new FolderAddDialog.ResultFolderListener() {
                String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);

				@Override
                public void receiveResult(File resultDir) {
                    String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
					// add dir to the list
                    mStoredFolders.add(resultDir.getAbsolutePath());
                    syncFolderList();
                }
            });
            folder.show(getFragmentManager(), "FolderChooseFragment");
        }
    }

    private class FolderListArrayAdapter extends ArrayAdapter<String> {

        String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);

		public FolderListArrayAdapter(Context context, String[] objects) {
            super(context, R.layout.folder_list_dialog_item, android.R.id.title, objects);
			String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
			final View cached = super.getView(position, convertView, parent);
            final String current = getItem(position);

            ImageView img = (ImageView) cached.findViewById(R.id.remove_local_folder);
            img.setOnClickListener(new View.OnClickListener() {
                String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);

				@Override
                public void onClick(View v) {
                    String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);
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
        String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
		mFolderList.setAdapter(new FolderListArrayAdapter(getActivity(), mStoredFolders.toArray(new String[mStoredFolders.size()])));

        // sync with shared prefs
        mSharedPrefs.edit().putStringSet(MainPagerActivity.FOLDER_LIST_KEY, mStoredFolders).apply();
    }
}
