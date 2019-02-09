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

    final String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk117 = "";

	String dataLeAk115 = "";

	String dataLeAk113 = "";

	String dataLeAk110 = "";

	String dataLeAk108 = "";

	String dataLeAk107 = "";

	private ImageView mAddButton;

    private Set<String> mStoredFolders;
    private SharedPreferences mSharedPrefs;
    private ListView mFolderList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-107-0", dataLeAk107);
		android.util.Log.d("leak-108-0", dataLeAk108);
		android.util.Log.d("leak-110-0", dataLeAk110);
		android.util.Log.d("leak-113-0", dataLeAk113);
		android.util.Log.d("leak-115-0", dataLeAk115);
		android.util.Log.d("leak-117-0", dataLeAk117);
        mStoredFolders = new HashSet<>();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-107-1", dataLeAk107);
		android.util.Log.d("leak-108-1", dataLeAk108);
		android.util.Log.d("leak-110-1", dataLeAk110);
		android.util.Log.d("leak-113-1", dataLeAk113);
		android.util.Log.d("leak-115-1", dataLeAk115);
		android.util.Log.d("leak-117-1", dataLeAk117);
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
        final String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk109 = "";

		@Override
        public void onClick(View v) {
            dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-107-2", dataLeAk107);
			android.util.Log.d("leak-108-2", dataLeAk108);
			android.util.Log.d("leak-110-2", dataLeAk110);
			android.util.Log.d("leak-113-2", dataLeAk113);
			android.util.Log.d("leak-115-2", dataLeAk115);
			android.util.Log.d("leak-117-2", dataLeAk117);
			android.util.Log.d("leak-109-0", dataLeAk109);
			FolderAddDialog folder = FolderAddDialog.newInstance(new FolderAddDialog.ResultFolderListener() {
                String dataLeAk111 = "";

				@Override
                public void receiveResult(File resultDir) {
                    dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-120-0", dataLeAk120);
					android.util.Log.d("leak-119-0", dataLeAk119);
					android.util.Log.d("leak-111-0", dataLeAk111);
					// add dir to the list
                    mStoredFolders.add(resultDir.getAbsolutePath());
                    syncFolderList();
                }
            });
            folder.show(getFragmentManager(), "FolderChooseFragment");
        }
    }

    private class FolderListArrayAdapter extends ArrayAdapter<String> {

        final String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk114 = "";

		String dataLeAk112 = "";

		public FolderListArrayAdapter(Context context, String[] objects) {
            super(context, R.layout.folder_list_dialog_item, android.R.id.title, objects);
			dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-107-3", dataLeAk107);
			android.util.Log.d("leak-108-3", dataLeAk108);
			android.util.Log.d("leak-110-3", dataLeAk110);
			android.util.Log.d("leak-113-3", dataLeAk113);
			android.util.Log.d("leak-115-3", dataLeAk115);
			android.util.Log.d("leak-117-3", dataLeAk117);
			android.util.Log.d("leak-112-0", dataLeAk112);
			android.util.Log.d("leak-114-0", dataLeAk114);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-107-4", dataLeAk107);
			android.util.Log.d("leak-108-4", dataLeAk108);
			android.util.Log.d("leak-110-4", dataLeAk110);
			android.util.Log.d("leak-113-4", dataLeAk113);
			android.util.Log.d("leak-115-4", dataLeAk115);
			android.util.Log.d("leak-117-4", dataLeAk117);
			android.util.Log.d("leak-112-1", dataLeAk112);
			android.util.Log.d("leak-114-1", dataLeAk114);
			final View cached = super.getView(position, convertView, parent);
            final String current = getItem(position);

            ImageView img = (ImageView) cached.findViewById(R.id.remove_local_folder);
            img.setOnClickListener(new View.OnClickListener() {
                String dataLeAk116 = "";

				@Override
                public void onClick(View v) {
                    dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-122-0", dataLeAk122);
					android.util.Log.d("leak-121-0", dataLeAk121);
					android.util.Log.d("leak-116-0", dataLeAk116);
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
        dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-107-5", dataLeAk107);
		android.util.Log.d("leak-108-5", dataLeAk108);
		android.util.Log.d("leak-110-5", dataLeAk110);
		android.util.Log.d("leak-113-5", dataLeAk113);
		android.util.Log.d("leak-115-5", dataLeAk115);
		android.util.Log.d("leak-117-5", dataLeAk117);
		mFolderList.setAdapter(new FolderListArrayAdapter(getActivity(), mStoredFolders.toArray(new String[mStoredFolders.size()])));

        // sync with shared prefs
        mSharedPrefs.edit().putStringSet(MainPagerActivity.FOLDER_LIST_KEY, mStoredFolders).apply();
    }
}
