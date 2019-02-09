package com.adonai.manman;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.adonai.manman.adapters.LocalArchiveArrayAdapter;
import com.adonai.manman.misc.AbstractNetworkAsyncLoader;
import com.adonai.manman.views.ProgressBarWrapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.commons.compress.utils.CountingInputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Fragment for uploading and parsing local man page distributions
 *
 * @author Oleg Chernovskiy
 */
public class ManLocalArchiveFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    final String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk260 = "";

	String dataLeAk258 = "";

	String dataLeAk256 = "";

	String dataLeAk254 = "";

	String dataLeAk247 = "";

	String dataLeAk246 = "";

	String dataLeAk244 = "";

	String dataLeAk237 = "";

	String dataLeAk235 = "";

	String dataLeAk234 = "";

	String dataLeAk233 = "";

	String dataLeAk232 = "";

	String dataLeAk231 = "";

	String dataLeAk230 = "";

	String dataLeAk229 = "";

	String dataLeAk228 = "";

	String dataLeAk227 = "";

	private static final String LOCAL_ARCHIVE_URL = "https://github.com/Adonai/Man-Man/releases/download/1.6.0/manpages.zip";

    private File mLocalArchive;
    private boolean mUserAgreedToDownload;

    private SharedPreferences mPreferences; // needed for folder list retrieval

    private ListView mLocalPageList;
    private SearchView mSearchLocalPage;
    private ProgressBarWrapper mProgress; // TODO: move progress bar to activity (and duplicate in chapters fragment too)
    private BroadcastReceiver mBroadcastHandler = new LocalArchiveBroadcastReceiver();
    private LocalArchiveParserCallback mLocalArchiveParseCallback = new LocalArchiveParserCallback();

    /**
     * Click listener for loading man page from selected archive file (or show config if no folders are present)
     * <br/>
     * Archives are pretty small, so gzip decompression and parsing won't take loads of time...
     * <br/>
     * Long story short, let's try to do this in UI and look at the performance
     *
     */
    private AdapterView.OnItemClickListener mManArchiveClickListener = new AdapterView.OnItemClickListener() {

        String dataLeAk226 = "";

		@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-262-0", dataLeAk262);
			android.util.Log.d("leak-226-0", dataLeAk226);
			mSearchLocalPage.clearFocus(); // otherwise we have to click "back" twice

            File data = (File) parent.getItemAtPosition(position);
            if(data == null) { // header is present, start config tool
                switch (position) {
                    case 0: // Watch folders
                        showFolderSettingsDialog();
                        break;
                    case 1: // Download archive
                        downloadArchive();
                        break;
                }
            } else {
                ManPageDialogFragment mpdf = ManPageDialogFragment.newInstance(data.getName(), data.getPath());
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack("PageFromLocalArchive")
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .replace(R.id.replacer, mpdf)
                        .commit();
            }
        }
    };

    @NonNull
    public static ManLocalArchiveFragment newInstance() {
        ManLocalArchiveFragment fragment = new ManLocalArchiveFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManLocalArchiveFragment() {
		dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-0", dataLeAk227);
		android.util.Log.d("leak-228-0", dataLeAk228);
		android.util.Log.d("leak-229-0", dataLeAk229);
		android.util.Log.d("leak-230-0", dataLeAk230);
		android.util.Log.d("leak-231-0", dataLeAk231);
		android.util.Log.d("leak-232-0", dataLeAk232);
		android.util.Log.d("leak-233-0", dataLeAk233);
		android.util.Log.d("leak-234-0", dataLeAk234);
		android.util.Log.d("leak-235-0", dataLeAk235);
		android.util.Log.d("leak-237-0", dataLeAk237);
		android.util.Log.d("leak-244-0", dataLeAk244);
		android.util.Log.d("leak-246-0", dataLeAk246);
		android.util.Log.d("leak-247-0", dataLeAk247);
		android.util.Log.d("leak-254-0", dataLeAk254);
		android.util.Log.d("leak-256-0", dataLeAk256);
		android.util.Log.d("leak-258-0", dataLeAk258);
		android.util.Log.d("leak-260-0", dataLeAk260);
    }



    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-1", dataLeAk227);
		android.util.Log.d("leak-228-1", dataLeAk228);
		android.util.Log.d("leak-229-1", dataLeAk229);
		android.util.Log.d("leak-230-1", dataLeAk230);
		android.util.Log.d("leak-231-1", dataLeAk231);
		android.util.Log.d("leak-232-1", dataLeAk232);
		android.util.Log.d("leak-233-1", dataLeAk233);
		android.util.Log.d("leak-234-1", dataLeAk234);
		android.util.Log.d("leak-235-1", dataLeAk235);
		android.util.Log.d("leak-237-1", dataLeAk237);
		android.util.Log.d("leak-244-1", dataLeAk244);
		android.util.Log.d("leak-246-1", dataLeAk246);
		android.util.Log.d("leak-247-1", dataLeAk247);
		android.util.Log.d("leak-254-1", dataLeAk254);
		android.util.Log.d("leak-256-1", dataLeAk256);
		android.util.Log.d("leak-258-1", dataLeAk258);
		android.util.Log.d("leak-260-1", dataLeAk260);
		setHasOptionsMenu(true);

        mLocalArchive = new File(getActivity().getCacheDir(), "manpages.zip");

        mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mPreferences.registerOnSharedPreferenceChangeListener(this);

        View root = inflater.inflate(R.layout.fragment_local_storage, container, false);
        mLocalPageList = (ListView) root.findViewById(R.id.local_storage_page_list);
        mLocalPageList.setOnItemClickListener(mManArchiveClickListener);
        mSearchLocalPage = (SearchView) root.findViewById(R.id.local_search_edit);
        mSearchLocalPage.setOnQueryTextListener(new FilterLocalStorage());
        mProgress = new ProgressBarWrapper(getActivity());

        getLoaderManager().initLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER, null, mLocalArchiveParseCallback);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mBroadcastHandler, new IntentFilter(MainPagerActivity.LOCAL_CHANGE_NOTIFY));

        return root;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
		dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-2", dataLeAk227);
		android.util.Log.d("leak-228-2", dataLeAk228);
		android.util.Log.d("leak-229-2", dataLeAk229);
		android.util.Log.d("leak-230-2", dataLeAk230);
		android.util.Log.d("leak-231-2", dataLeAk231);
		android.util.Log.d("leak-232-2", dataLeAk232);
		android.util.Log.d("leak-233-2", dataLeAk233);
		android.util.Log.d("leak-234-2", dataLeAk234);
		android.util.Log.d("leak-235-2", dataLeAk235);
		android.util.Log.d("leak-237-2", dataLeAk237);
		android.util.Log.d("leak-244-2", dataLeAk244);
		android.util.Log.d("leak-246-2", dataLeAk246);
		android.util.Log.d("leak-247-2", dataLeAk247);
		android.util.Log.d("leak-254-2", dataLeAk254);
		android.util.Log.d("leak-256-2", dataLeAk256);
		android.util.Log.d("leak-258-2", dataLeAk258);
		android.util.Log.d("leak-260-2", dataLeAk260);
        mProgress.onOrientationChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
		dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-3", dataLeAk227);
		android.util.Log.d("leak-228-3", dataLeAk228);
		android.util.Log.d("leak-229-3", dataLeAk229);
		android.util.Log.d("leak-230-3", dataLeAk230);
		android.util.Log.d("leak-231-3", dataLeAk231);
		android.util.Log.d("leak-232-3", dataLeAk232);
		android.util.Log.d("leak-233-3", dataLeAk233);
		android.util.Log.d("leak-234-3", dataLeAk234);
		android.util.Log.d("leak-235-3", dataLeAk235);
		android.util.Log.d("leak-237-3", dataLeAk237);
		android.util.Log.d("leak-244-3", dataLeAk244);
		android.util.Log.d("leak-246-3", dataLeAk246);
		android.util.Log.d("leak-247-3", dataLeAk247);
		android.util.Log.d("leak-254-3", dataLeAk254);
		android.util.Log.d("leak-256-3", dataLeAk256);
		android.util.Log.d("leak-258-3", dataLeAk258);
		android.util.Log.d("leak-260-3", dataLeAk260);
        mProgress.hide();
        mPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
		dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-4", dataLeAk227);
		android.util.Log.d("leak-228-4", dataLeAk228);
		android.util.Log.d("leak-229-4", dataLeAk229);
		android.util.Log.d("leak-230-4", dataLeAk230);
		android.util.Log.d("leak-231-4", dataLeAk231);
		android.util.Log.d("leak-232-4", dataLeAk232);
		android.util.Log.d("leak-233-4", dataLeAk233);
		android.util.Log.d("leak-234-4", dataLeAk234);
		android.util.Log.d("leak-235-4", dataLeAk235);
		android.util.Log.d("leak-237-4", dataLeAk237);
		android.util.Log.d("leak-244-4", dataLeAk244);
		android.util.Log.d("leak-246-4", dataLeAk246);
		android.util.Log.d("leak-247-4", dataLeAk247);
		android.util.Log.d("leak-254-4", dataLeAk254);
		android.util.Log.d("leak-256-4", dataLeAk256);
		android.util.Log.d("leak-258-4", dataLeAk258);
		android.util.Log.d("leak-260-4", dataLeAk260);
        inflater.inflate(R.menu.local_archive_menu, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
		dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-5", dataLeAk227);
		android.util.Log.d("leak-228-5", dataLeAk228);
		android.util.Log.d("leak-229-5", dataLeAk229);
		android.util.Log.d("leak-230-5", dataLeAk230);
		android.util.Log.d("leak-231-5", dataLeAk231);
		android.util.Log.d("leak-232-5", dataLeAk232);
		android.util.Log.d("leak-233-5", dataLeAk233);
		android.util.Log.d("leak-234-5", dataLeAk234);
		android.util.Log.d("leak-235-5", dataLeAk235);
		android.util.Log.d("leak-237-5", dataLeAk237);
		android.util.Log.d("leak-244-5", dataLeAk244);
		android.util.Log.d("leak-246-5", dataLeAk246);
		android.util.Log.d("leak-247-5", dataLeAk247);
		android.util.Log.d("leak-254-5", dataLeAk254);
		android.util.Log.d("leak-256-5", dataLeAk256);
		android.util.Log.d("leak-258-5", dataLeAk258);
		android.util.Log.d("leak-260-5", dataLeAk260);
        // don't show it if we already have archive
        menu.findItem(R.id.download_archive).setVisible(!mLocalArchive.exists());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-6", dataLeAk227);
		android.util.Log.d("leak-228-6", dataLeAk228);
		android.util.Log.d("leak-229-6", dataLeAk229);
		android.util.Log.d("leak-230-6", dataLeAk230);
		android.util.Log.d("leak-231-6", dataLeAk231);
		android.util.Log.d("leak-232-6", dataLeAk232);
		android.util.Log.d("leak-233-6", dataLeAk233);
		android.util.Log.d("leak-234-6", dataLeAk234);
		android.util.Log.d("leak-235-6", dataLeAk235);
		android.util.Log.d("leak-237-6", dataLeAk237);
		android.util.Log.d("leak-244-6", dataLeAk244);
		android.util.Log.d("leak-246-6", dataLeAk246);
		android.util.Log.d("leak-247-6", dataLeAk247);
		android.util.Log.d("leak-254-6", dataLeAk254);
		android.util.Log.d("leak-256-6", dataLeAk256);
		android.util.Log.d("leak-258-6", dataLeAk258);
		android.util.Log.d("leak-260-6", dataLeAk260);
		switch (item.getItemId()) {
            case R.id.folder_settings:
                showFolderSettingsDialog();
                return true;
            case R.id.download_archive:
                downloadArchive();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-7", dataLeAk227);
		android.util.Log.d("leak-228-7", dataLeAk228);
		android.util.Log.d("leak-229-7", dataLeAk229);
		android.util.Log.d("leak-230-7", dataLeAk230);
		android.util.Log.d("leak-231-7", dataLeAk231);
		android.util.Log.d("leak-232-7", dataLeAk232);
		android.util.Log.d("leak-233-7", dataLeAk233);
		android.util.Log.d("leak-234-7", dataLeAk234);
		android.util.Log.d("leak-235-7", dataLeAk235);
		android.util.Log.d("leak-237-7", dataLeAk237);
		android.util.Log.d("leak-244-7", dataLeAk244);
		android.util.Log.d("leak-246-7", dataLeAk246);
		android.util.Log.d("leak-247-7", dataLeAk247);
		android.util.Log.d("leak-254-7", dataLeAk254);
		android.util.Log.d("leak-256-7", dataLeAk256);
		android.util.Log.d("leak-258-7", dataLeAk258);
		android.util.Log.d("leak-260-7", dataLeAk260);
		if(key.equals(MainPagerActivity.FOLDER_LIST_KEY)) { // the only needed key
            getLoaderManager().getLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER).onContentChanged();
        }
    }

    private void showFolderSettingsDialog() {
        dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-8", dataLeAk227);
		android.util.Log.d("leak-228-8", dataLeAk228);
		android.util.Log.d("leak-229-8", dataLeAk229);
		android.util.Log.d("leak-230-8", dataLeAk230);
		android.util.Log.d("leak-231-8", dataLeAk231);
		android.util.Log.d("leak-232-8", dataLeAk232);
		android.util.Log.d("leak-233-8", dataLeAk233);
		android.util.Log.d("leak-234-8", dataLeAk234);
		android.util.Log.d("leak-235-8", dataLeAk235);
		android.util.Log.d("leak-237-8", dataLeAk237);
		android.util.Log.d("leak-244-8", dataLeAk244);
		android.util.Log.d("leak-246-8", dataLeAk246);
		android.util.Log.d("leak-247-8", dataLeAk247);
		android.util.Log.d("leak-254-8", dataLeAk254);
		android.util.Log.d("leak-256-8", dataLeAk256);
		android.util.Log.d("leak-258-8", dataLeAk258);
		android.util.Log.d("leak-260-8", dataLeAk260);
		new FolderChooseFragment().show(getFragmentManager(), "FolderListFragment");
    }

    private class LocalArchiveParserCallback implements LoaderManager.LoaderCallbacks<List<File>> {
        final String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk245 = "";

		String dataLeAk243 = "";

		String dataLeAk236 = "";

		@Override
        public Loader<List<File>> onCreateLoader(int i, Bundle bundle) {
            dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-227-9", dataLeAk227);
			android.util.Log.d("leak-228-9", dataLeAk228);
			android.util.Log.d("leak-229-9", dataLeAk229);
			android.util.Log.d("leak-230-9", dataLeAk230);
			android.util.Log.d("leak-231-9", dataLeAk231);
			android.util.Log.d("leak-232-9", dataLeAk232);
			android.util.Log.d("leak-233-9", dataLeAk233);
			android.util.Log.d("leak-234-9", dataLeAk234);
			android.util.Log.d("leak-235-9", dataLeAk235);
			android.util.Log.d("leak-237-9", dataLeAk237);
			android.util.Log.d("leak-244-9", dataLeAk244);
			android.util.Log.d("leak-246-9", dataLeAk246);
			android.util.Log.d("leak-247-9", dataLeAk247);
			android.util.Log.d("leak-254-9", dataLeAk254);
			android.util.Log.d("leak-256-9", dataLeAk256);
			android.util.Log.d("leak-258-9", dataLeAk258);
			android.util.Log.d("leak-260-9", dataLeAk260);
			android.util.Log.d("leak-236-0", dataLeAk236);
			android.util.Log.d("leak-243-0", dataLeAk243);
			android.util.Log.d("leak-245-0", dataLeAk245);
			return new AbstractNetworkAsyncLoader<List<File>>(getActivity()) {
                final String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				String dataLeAk242 = "";

				String dataLeAk241 = "";

				String dataLeAk240 = "";

				String dataLeAk238 = "";

				Set<String> mFolderList;

                @NonNull
                @Override
                public List<File> loadInBackground() {
                    dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-264-0", dataLeAk264);
					android.util.Log.d("leak-263-0", dataLeAk263);
					android.util.Log.d("leak-238-0", dataLeAk238);
					android.util.Log.d("leak-240-0", dataLeAk240);
					android.util.Log.d("leak-241-0", dataLeAk241);
					android.util.Log.d("leak-242-0", dataLeAk242);
					// results from locally-defined folders
                    mFolderList = mPreferences.getStringSet(MainPagerActivity.FOLDER_LIST_KEY, new HashSet<String>());
                    List<File> result = new ArrayList<>();
                    for(String path : mFolderList) {
                        File targetedFolder = new File(path);
                        if(targetedFolder.exists() && targetedFolder.isDirectory()) { // paranoid check, we already checked in dialog!
                            walkFileTree(targetedFolder, result);
                        }
                    }

                    // results from local archive, if exists
                    if(mLocalArchive.exists()) {
                        // show progress bar
                        getActivity().runOnUiThread(new Runnable() {
                            String dataLeAk239 = "";

							@Override
                            public void run() {
                                dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-267-0", dataLeAk267);
								android.util.Log.d("leak-266-0", dataLeAk266);
								android.util.Log.d("leak-265-0", dataLeAk265);
								android.util.Log.d("leak-239-0", dataLeAk239);
								mProgress.show();
                            }
                        });
                        // it's a tar-gzipped archive with standard structure
                        populateWithLocal(result);
                    }

                    // sort results alphabetically...
                    Collections.sort(result);
                    return result;
                }

                private void populateWithLocal(List<File> result) {
                    dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-269-0", dataLeAk269);
					android.util.Log.d("leak-268-0", dataLeAk268);
					android.util.Log.d("leak-238-1", dataLeAk238);
					android.util.Log.d("leak-240-1", dataLeAk240);
					android.util.Log.d("leak-241-1", dataLeAk241);
					android.util.Log.d("leak-242-1", dataLeAk242);
					try {
                        ZipFile zip = new ZipFile(mLocalArchive);
                        Enumeration<? extends ZipEntry> entries = zip.entries();
                        while (entries.hasMoreElements()) {
                            ZipEntry zEntry = entries.nextElement();
                            if(zEntry.isDirectory())
                                continue;

                            result.add(new File("local:", zEntry.getName()));
                        }
                    } catch (IOException e) {
                        Log.e(Utils.MM_TAG, "Exception while parsing local archive", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.error_parsing_local_archive);
                    }
                }

                private void walkFileTree(File directoryRoot, List<File> resultList) {
                    dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-271-0", dataLeAk271);
					android.util.Log.d("leak-270-0", dataLeAk270);
					android.util.Log.d("leak-238-2", dataLeAk238);
					android.util.Log.d("leak-240-2", dataLeAk240);
					android.util.Log.d("leak-241-2", dataLeAk241);
					android.util.Log.d("leak-242-2", dataLeAk242);
					File[] list = directoryRoot.listFiles();
                    if(list == null) // unknown, happens on some devices
                        return;

                    for (File f : list) {
                        if (f.isDirectory()) {
                            walkFileTree(f, resultList);
                        } else if(f.getName().toLowerCase().endsWith(".gz")) { // take only gzipped files
                            resultList.add(f);
                        }
                    }
                }

                @Override
                public void deliverResult(List<File> data) {
                    mProgress.hide();
					dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-273-0", dataLeAk273);
					android.util.Log.d("leak-272-0", dataLeAk272);
					android.util.Log.d("leak-238-3", dataLeAk238);
					android.util.Log.d("leak-240-3", dataLeAk240);
					android.util.Log.d("leak-241-3", dataLeAk241);
					android.util.Log.d("leak-242-3", dataLeAk242);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<List<File>> loader, List<File> manPageFiles) {
            dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-227-10", dataLeAk227);
			android.util.Log.d("leak-228-10", dataLeAk228);
			android.util.Log.d("leak-229-10", dataLeAk229);
			android.util.Log.d("leak-230-10", dataLeAk230);
			android.util.Log.d("leak-231-10", dataLeAk231);
			android.util.Log.d("leak-232-10", dataLeAk232);
			android.util.Log.d("leak-233-10", dataLeAk233);
			android.util.Log.d("leak-234-10", dataLeAk234);
			android.util.Log.d("leak-235-10", dataLeAk235);
			android.util.Log.d("leak-237-10", dataLeAk237);
			android.util.Log.d("leak-244-10", dataLeAk244);
			android.util.Log.d("leak-246-10", dataLeAk246);
			android.util.Log.d("leak-247-10", dataLeAk247);
			android.util.Log.d("leak-254-10", dataLeAk254);
			android.util.Log.d("leak-256-10", dataLeAk256);
			android.util.Log.d("leak-258-10", dataLeAk258);
			android.util.Log.d("leak-260-10", dataLeAk260);
			android.util.Log.d("leak-236-1", dataLeAk236);
			android.util.Log.d("leak-243-1", dataLeAk243);
			android.util.Log.d("leak-245-1", dataLeAk245);
			if(mLocalPageList.getHeaderViewsCount() > 0) {
                mLocalPageList.removeHeaderView(mLocalPageList.getChildAt(0));
                mLocalPageList.removeHeaderView(mLocalPageList.getChildAt(1));
            }
            mLocalPageList.setAdapter(null); // for android < kitkat for header to work properly

            if(manPageFiles.isEmpty()) {
                mSearchLocalPage.setVisibility(View.GONE);
                View header1 = View.inflate(getActivity(), R.layout.add_folder_header, null);
                View header2 = View.inflate(getActivity(), R.layout.load_archive_header, null);
                mLocalPageList.addHeaderView(header1);
                mLocalPageList.addHeaderView(header2);
            } else {
                mSearchLocalPage.setVisibility(View.VISIBLE);
            }
            mLocalPageList.setAdapter(new LocalArchiveArrayAdapter(getActivity(), R.layout.chapter_command_list_item, R.id.command_name_label, manPageFiles));
        }

        @Override
        public void onLoaderReset(Loader<List<File>> loader) {
			dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-227-11", dataLeAk227);
			android.util.Log.d("leak-228-11", dataLeAk228);
			android.util.Log.d("leak-229-11", dataLeAk229);
			android.util.Log.d("leak-230-11", dataLeAk230);
			android.util.Log.d("leak-231-11", dataLeAk231);
			android.util.Log.d("leak-232-11", dataLeAk232);
			android.util.Log.d("leak-233-11", dataLeAk233);
			android.util.Log.d("leak-234-11", dataLeAk234);
			android.util.Log.d("leak-235-11", dataLeAk235);
			android.util.Log.d("leak-237-11", dataLeAk237);
			android.util.Log.d("leak-244-11", dataLeAk244);
			android.util.Log.d("leak-246-11", dataLeAk246);
			android.util.Log.d("leak-247-11", dataLeAk247);
			android.util.Log.d("leak-254-11", dataLeAk254);
			android.util.Log.d("leak-256-11", dataLeAk256);
			android.util.Log.d("leak-258-11", dataLeAk258);
			android.util.Log.d("leak-260-11", dataLeAk260);
			android.util.Log.d("leak-236-2", dataLeAk236);
			android.util.Log.d("leak-243-2", dataLeAk243);
			android.util.Log.d("leak-245-2", dataLeAk245);

        }
    }

    /**
     * Load archive to app data folder from my GitHub releases page
     */
    private void downloadArchive() {
        dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-227-12", dataLeAk227);
		android.util.Log.d("leak-228-12", dataLeAk228);
		android.util.Log.d("leak-229-12", dataLeAk229);
		android.util.Log.d("leak-230-12", dataLeAk230);
		android.util.Log.d("leak-231-12", dataLeAk231);
		android.util.Log.d("leak-232-12", dataLeAk232);
		android.util.Log.d("leak-233-12", dataLeAk233);
		android.util.Log.d("leak-234-12", dataLeAk234);
		android.util.Log.d("leak-235-12", dataLeAk235);
		android.util.Log.d("leak-237-12", dataLeAk237);
		android.util.Log.d("leak-244-12", dataLeAk244);
		android.util.Log.d("leak-246-12", dataLeAk246);
		android.util.Log.d("leak-247-12", dataLeAk247);
		android.util.Log.d("leak-254-12", dataLeAk254);
		android.util.Log.d("leak-256-12", dataLeAk256);
		android.util.Log.d("leak-258-12", dataLeAk258);
		android.util.Log.d("leak-260-12", dataLeAk260);
		if(mLocalArchive.exists()) {
            return;
        }

        if(!mUserAgreedToDownload) {
            new AlertDialog.Builder(getActivity())
                    .setTitle(R.string.confirm_action)
                    .setMessage(R.string.confirm_action_load_archive)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        String dataLeAk248 = "";

						@Override
                        public void onClick(DialogInterface dialog, int which) {
                            dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-274-0", dataLeAk274);
							android.util.Log.d("leak-248-0", dataLeAk248);
							mUserAgreedToDownload = true;
                            downloadArchive();
                        }
                    }).setNegativeButton(android.R.string.no, null)
                    .create().show();
            return;
        }

        // kind of stupid to make a loader just for oneshot DL task...
        // OK, let's do it old way...
        AsyncTask<String, Long, Void> dlTask = new AsyncTask<String, Long, Void>() {

            String dataLeAk252 = "";

			String dataLeAk251 = "";

			String dataLeAk250 = "";

			String dataLeAk249 = "";

			private Exception possibleEncountered;
            private ProgressDialog pd;

            @Override
            protected void onPreExecute() {
                dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-275-0", dataLeAk275);
				android.util.Log.d("leak-249-0", dataLeAk249);
				android.util.Log.d("leak-250-0", dataLeAk250);
				android.util.Log.d("leak-251-0", dataLeAk251);
				android.util.Log.d("leak-252-0", dataLeAk252);
				pd = ProgressDialog.show(getActivity(),
                        getString(R.string.downloading),
                        getString(R.string.please_wait), true);
            }

            @Override
            protected Void doInBackground(String... params) {
                dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-276-0", dataLeAk276);
				android.util.Log.d("leak-249-1", dataLeAk249);
				android.util.Log.d("leak-250-1", dataLeAk250);
				android.util.Log.d("leak-251-1", dataLeAk251);
				android.util.Log.d("leak-252-1", dataLeAk252);
				try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(params[0]).build();
                    Response response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        publishProgress(-2L);
                        return null;
                    }

                    Long contentLength = response.body().contentLength();
                    CountingInputStream cis = new CountingInputStream(response.body().byteStream());
                    FileOutputStream fos = new FileOutputStream(mLocalArchive);
                    byte[] buffer = new byte[8096];
                    int read;
                    while ((read = cis.read(buffer)) != -1) {
                        fos.write(buffer, 0, read);
                        publishProgress(cis.getBytesRead() * 100 / contentLength);
                    }
                    fos.close();
                    cis.close();
                } catch (IOException e) {
                    Log.e(Utils.MM_TAG, "Exception while downloading man pages archive", e);
                    possibleEncountered = e;
                    publishProgress(-1L);
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Long... values) {
                dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-277-0", dataLeAk277);
				android.util.Log.d("leak-249-2", dataLeAk249);
				android.util.Log.d("leak-250-2", dataLeAk250);
				android.util.Log.d("leak-251-2", dataLeAk251);
				android.util.Log.d("leak-252-2", dataLeAk252);
				if(values[0] == -1) { // exception
                    Utils.showToastFromAnyThread(getActivity(), possibleEncountered.getLocalizedMessage());
                }

                if(values[0] == -2) { // response is not OK
                    Utils.showToastFromAnyThread(getActivity(), R.string.no_archive_on_server);
                }

                pd.setMessage(getString(R.string.please_wait) + " " + values[0] + "%");
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-278-0", dataLeAk278);
				android.util.Log.d("leak-249-3", dataLeAk249);
				android.util.Log.d("leak-250-3", dataLeAk250);
				android.util.Log.d("leak-251-3", dataLeAk251);
				android.util.Log.d("leak-252-3", dataLeAk252);
				pd.dismiss();
                getLoaderManager().getLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER).onContentChanged();
            }
        };
        dlTask.execute(LOCAL_ARCHIVE_URL);
    }

    private class FilterLocalStorage implements SearchView.OnQueryTextListener {

        String dataLeAk257 = "";

		String dataLeAk255 = "";

		String dataLeAk253 = "";

		@Override
        public boolean onQueryTextSubmit(String query) {
            dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-227-13", dataLeAk227);
			android.util.Log.d("leak-228-13", dataLeAk228);
			android.util.Log.d("leak-229-13", dataLeAk229);
			android.util.Log.d("leak-230-13", dataLeAk230);
			android.util.Log.d("leak-231-13", dataLeAk231);
			android.util.Log.d("leak-232-13", dataLeAk232);
			android.util.Log.d("leak-233-13", dataLeAk233);
			android.util.Log.d("leak-234-13", dataLeAk234);
			android.util.Log.d("leak-235-13", dataLeAk235);
			android.util.Log.d("leak-237-13", dataLeAk237);
			android.util.Log.d("leak-244-13", dataLeAk244);
			android.util.Log.d("leak-246-13", dataLeAk246);
			android.util.Log.d("leak-247-13", dataLeAk247);
			android.util.Log.d("leak-254-13", dataLeAk254);
			android.util.Log.d("leak-256-13", dataLeAk256);
			android.util.Log.d("leak-258-13", dataLeAk258);
			android.util.Log.d("leak-260-13", dataLeAk260);
			android.util.Log.d("leak-253-0", dataLeAk253);
			android.util.Log.d("leak-255-0", dataLeAk255);
			android.util.Log.d("leak-257-0", dataLeAk257);
			applyFilter(query);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-227-14", dataLeAk227);
			android.util.Log.d("leak-228-14", dataLeAk228);
			android.util.Log.d("leak-229-14", dataLeAk229);
			android.util.Log.d("leak-230-14", dataLeAk230);
			android.util.Log.d("leak-231-14", dataLeAk231);
			android.util.Log.d("leak-232-14", dataLeAk232);
			android.util.Log.d("leak-233-14", dataLeAk233);
			android.util.Log.d("leak-234-14", dataLeAk234);
			android.util.Log.d("leak-235-14", dataLeAk235);
			android.util.Log.d("leak-237-14", dataLeAk237);
			android.util.Log.d("leak-244-14", dataLeAk244);
			android.util.Log.d("leak-246-14", dataLeAk246);
			android.util.Log.d("leak-247-14", dataLeAk247);
			android.util.Log.d("leak-254-14", dataLeAk254);
			android.util.Log.d("leak-256-14", dataLeAk256);
			android.util.Log.d("leak-258-14", dataLeAk258);
			android.util.Log.d("leak-260-14", dataLeAk260);
			android.util.Log.d("leak-253-1", dataLeAk253);
			android.util.Log.d("leak-255-1", dataLeAk255);
			android.util.Log.d("leak-257-1", dataLeAk257);
			applyFilter(newText);
            return true;
        }

        private void applyFilter(CharSequence text) {
            dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-227-15", dataLeAk227);
			android.util.Log.d("leak-228-15", dataLeAk228);
			android.util.Log.d("leak-229-15", dataLeAk229);
			android.util.Log.d("leak-230-15", dataLeAk230);
			android.util.Log.d("leak-231-15", dataLeAk231);
			android.util.Log.d("leak-232-15", dataLeAk232);
			android.util.Log.d("leak-233-15", dataLeAk233);
			android.util.Log.d("leak-234-15", dataLeAk234);
			android.util.Log.d("leak-235-15", dataLeAk235);
			android.util.Log.d("leak-237-15", dataLeAk237);
			android.util.Log.d("leak-244-15", dataLeAk244);
			android.util.Log.d("leak-246-15", dataLeAk246);
			android.util.Log.d("leak-247-15", dataLeAk247);
			android.util.Log.d("leak-254-15", dataLeAk254);
			android.util.Log.d("leak-256-15", dataLeAk256);
			android.util.Log.d("leak-258-15", dataLeAk258);
			android.util.Log.d("leak-260-15", dataLeAk260);
			android.util.Log.d("leak-253-2", dataLeAk253);
			android.util.Log.d("leak-255-2", dataLeAk255);
			android.util.Log.d("leak-257-2", dataLeAk257);
			// safe to cast, we have only this type of adapter here
            LocalArchiveArrayAdapter adapter = (LocalArchiveArrayAdapter) mLocalPageList.getAdapter();
            if(adapter != null) { // another paranoid check?
                adapter.getFilter().filter(text);
            }
        }
    }

    /**
     * Handler to receive notifications for changes in local archive (to update local list view)
     */
    private class LocalArchiveBroadcastReceiver extends BroadcastReceiver {
        String dataLeAk259 = "";

		@Override
        public void onReceive(Context context, Intent intent) {
            dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-227-16", dataLeAk227);
			android.util.Log.d("leak-228-16", dataLeAk228);
			android.util.Log.d("leak-229-16", dataLeAk229);
			android.util.Log.d("leak-230-16", dataLeAk230);
			android.util.Log.d("leak-231-16", dataLeAk231);
			android.util.Log.d("leak-232-16", dataLeAk232);
			android.util.Log.d("leak-233-16", dataLeAk233);
			android.util.Log.d("leak-234-16", dataLeAk234);
			android.util.Log.d("leak-235-16", dataLeAk235);
			android.util.Log.d("leak-237-16", dataLeAk237);
			android.util.Log.d("leak-244-16", dataLeAk244);
			android.util.Log.d("leak-246-16", dataLeAk246);
			android.util.Log.d("leak-247-16", dataLeAk247);
			android.util.Log.d("leak-254-16", dataLeAk254);
			android.util.Log.d("leak-256-16", dataLeAk256);
			android.util.Log.d("leak-258-16", dataLeAk258);
			android.util.Log.d("leak-260-16", dataLeAk260);
			android.util.Log.d("leak-259-0", dataLeAk259);
			getLoaderManager().getLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER).onContentChanged();
        }
    }
}
