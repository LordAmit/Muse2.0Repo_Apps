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

    String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk291 = android.util.Log.d("leak-291", dataLeAk291);

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

        String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk292 = android.util.Log.d("leak-292", dataLeAk292);

		@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk293 = android.util.Log.d("leak-293", dataLeAk293);
			mSearchLocalPage.clearFocus(); // otherwise we have to click "back" twice

            File data = (File) parent.getItemAtPosition(position);
            if(data == null) { // header is present, start config tool
                String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk294 = android.util.Log.d("leak-294", dataLeAk294);
				switch (position) {
                    case 0: // Watch folders
                        showFolderSettingsDialog();
                        break;
                    case 1: // Download archive
                        downloadArchive();
                        break;
                }
            } else {
                String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk295 = android.util.Log.d("leak-295", dataLeAk295);
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
        String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk296 = android.util.Log.d("leak-296", dataLeAk296);
		ManLocalArchiveFragment fragment = new ManLocalArchiveFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManLocalArchiveFragment() {
		String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk297 = android.util.Log.d("leak-297", dataLeAk297);
    }



    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk298 = android.util.Log.d("leak-298", dataLeAk298);
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
		String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk299 = android.util.Log.d("leak-299", dataLeAk299);
        mProgress.onOrientationChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
		String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk300 = android.util.Log.d("leak-300", dataLeAk300);
        mProgress.hide();
        mPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
		String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk301 = android.util.Log.d("leak-301", dataLeAk301);
        inflater.inflate(R.menu.local_archive_menu, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
		String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk302 = android.util.Log.d("leak-302", dataLeAk302);
        // don't show it if we already have archive
        menu.findItem(R.id.download_archive).setVisible(!mLocalArchive.exists());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk303 = android.util.Log.d("leak-303", dataLeAk303);
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
        String dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk304 = android.util.Log.d("leak-304", dataLeAk304);
		if(key.equals(MainPagerActivity.FOLDER_LIST_KEY)) { // the only needed key
            String dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk305 = android.util.Log.d("leak-305", dataLeAk305);
			getLoaderManager().getLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER).onContentChanged();
        }
    }

    private void showFolderSettingsDialog() {
        String dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk306 = android.util.Log.d("leak-306", dataLeAk306);
		new FolderChooseFragment().show(getFragmentManager(), "FolderListFragment");
    }

    private class LocalArchiveParserCallback implements LoaderManager.LoaderCallbacks<List<File>> {
        String dataLeAk307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk307 = android.util.Log.d("leak-307", dataLeAk307);

		@Override
        public Loader<List<File>> onCreateLoader(int i, Bundle bundle) {
            String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk308 = android.util.Log.d("leak-308", dataLeAk308);
			return new AbstractNetworkAsyncLoader<List<File>>(getActivity()) {
                String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk309 = android.util.Log.d("leak-309", dataLeAk309);

				Set<String> mFolderList;

                @NonNull
                @Override
                public List<File> loadInBackground() {
                    String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk310 = android.util.Log.d("leak-310", dataLeAk310);
					// results from locally-defined folders
                    mFolderList = mPreferences.getStringSet(MainPagerActivity.FOLDER_LIST_KEY, new HashSet<String>());
                    List<File> result = new ArrayList<>();
                    for(String path : mFolderList) {
                        String dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk311 = android.util.Log.d("leak-311", dataLeAk311);
						File targetedFolder = new File(path);
                        if(targetedFolder.exists() && targetedFolder.isDirectory()) { // paranoid check, we already checked in dialog!
                            String dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk312 = android.util.Log.d("leak-312", dataLeAk312);
							walkFileTree(targetedFolder, result);
                        }
                    }

                    // results from local archive, if exists
                    if(mLocalArchive.exists()) {
                        String dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk313 = android.util.Log.d("leak-313", dataLeAk313);
						// show progress bar
                        getActivity().runOnUiThread(new Runnable() {
                            String dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk314 = android.util.Log.d("leak-314", dataLeAk314);

							@Override
                            public void run() {
                                String dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk315 = android.util.Log.d("leak-315", dataLeAk315);
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
                    String dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk316 = android.util.Log.d("leak-316", dataLeAk316);
					try {
                        String dataLeAk317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk317 = android.util.Log.d("leak-317", dataLeAk317);
						ZipFile zip = new ZipFile(mLocalArchive);
                        Enumeration<? extends ZipEntry> entries = zip.entries();
                        while (entries.hasMoreElements()) {
                            String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk318 = android.util.Log.d("leak-318", dataLeAk318);
							ZipEntry zEntry = entries.nextElement();
                            if(zEntry.isDirectory())
                                continue;

                            result.add(new File("local:", zEntry.getName()));
                        }
                    } catch (IOException e) {
                        String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk319 = android.util.Log.d("leak-319", dataLeAk319);
						Log.e(Utils.MM_TAG, "Exception while parsing local archive", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.error_parsing_local_archive);
                    }
                }

                private void walkFileTree(File directoryRoot, List<File> resultList) {
                    String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk320 = android.util.Log.d("leak-320", dataLeAk320);
					File[] list = directoryRoot.listFiles();
                    if(list == null) // unknown, happens on some devices
                        return;

                    for (File f : list) {
                        String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk321 = android.util.Log.d("leak-321", dataLeAk321);
						if (f.isDirectory()) {
                            String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk322 = android.util.Log.d("leak-322", dataLeAk322);
							walkFileTree(f, resultList);
                        } else if(f.getName().toLowerCase().endsWith(".gz")) { // take only gzipped files
                            String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk323 = android.util.Log.d("leak-323", dataLeAk323);
							resultList.add(f);
                        }
                    }
                }

                @Override
                public void deliverResult(List<File> data) {
                    mProgress.hide();
					String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk324 = android.util.Log.d("leak-324", dataLeAk324);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<List<File>> loader, List<File> manPageFiles) {
            String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk325 = android.util.Log.d("leak-325", dataLeAk325);
			if(mLocalPageList.getHeaderViewsCount() > 0) {
                String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk326 = android.util.Log.d("leak-326", dataLeAk326);
				mLocalPageList.removeHeaderView(mLocalPageList.getChildAt(0));
                mLocalPageList.removeHeaderView(mLocalPageList.getChildAt(1));
            }
            mLocalPageList.setAdapter(null); // for android < kitkat for header to work properly

            if(manPageFiles.isEmpty()) {
                String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk327 = android.util.Log.d("leak-327", dataLeAk327);
				mSearchLocalPage.setVisibility(View.GONE);
                View header1 = View.inflate(getActivity(), R.layout.add_folder_header, null);
                View header2 = View.inflate(getActivity(), R.layout.load_archive_header, null);
                mLocalPageList.addHeaderView(header1);
                mLocalPageList.addHeaderView(header2);
            } else {
                String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk328 = android.util.Log.d("leak-328", dataLeAk328);
				mSearchLocalPage.setVisibility(View.VISIBLE);
            }
            mLocalPageList.setAdapter(new LocalArchiveArrayAdapter(getActivity(), R.layout.chapter_command_list_item, R.id.command_name_label, manPageFiles));
        }

        @Override
        public void onLoaderReset(Loader<List<File>> loader) {
			String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk329 = android.util.Log.d("leak-329", dataLeAk329);

        }
    }

    /**
     * Load archive to app data folder from my GitHub releases page
     */
    private void downloadArchive() {
        String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk330 = android.util.Log.d("leak-330", dataLeAk330);
		if(mLocalArchive.exists()) {
            String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk331 = android.util.Log.d("leak-331", dataLeAk331);
			return;
        }

        if(!mUserAgreedToDownload) {
            String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk332 = android.util.Log.d("leak-332", dataLeAk332);
			new AlertDialog.Builder(getActivity())
                    .setTitle(R.string.confirm_action)
                    .setMessage(R.string.confirm_action_load_archive)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk333 = android.util.Log.d("leak-333", dataLeAk333);

						@Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk334 = android.util.Log.d("leak-334", dataLeAk334);
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

            String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk335 = android.util.Log.d("leak-335", dataLeAk335);

			private Exception possibleEncountered;
            private ProgressDialog pd;

            @Override
            protected void onPreExecute() {
                String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk336 = android.util.Log.d("leak-336", dataLeAk336);
				pd = ProgressDialog.show(getActivity(),
                        getString(R.string.downloading),
                        getString(R.string.please_wait), true);
            }

            @Override
            protected Void doInBackground(String... params) {
                String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk337 = android.util.Log.d("leak-337", dataLeAk337);
				try {
                    String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk338 = android.util.Log.d("leak-338", dataLeAk338);
					OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(params[0]).build();
                    Response response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk339 = android.util.Log.d("leak-339", dataLeAk339);
						publishProgress(-2L);
                        return null;
                    }

                    Long contentLength = response.body().contentLength();
                    CountingInputStream cis = new CountingInputStream(response.body().byteStream());
                    FileOutputStream fos = new FileOutputStream(mLocalArchive);
                    byte[] buffer = new byte[8096];
                    int read;
                    while ((read = cis.read(buffer)) != -1) {
                        String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk340 = android.util.Log.d("leak-340", dataLeAk340);
						fos.write(buffer, 0, read);
                        publishProgress(cis.getBytesRead() * 100 / contentLength);
                    }
                    fos.close();
                    cis.close();
                } catch (IOException e) {
                    String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk341 = android.util.Log.d("leak-341", dataLeAk341);
					Log.e(Utils.MM_TAG, "Exception while downloading man pages archive", e);
                    possibleEncountered = e;
                    publishProgress(-1L);
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Long... values) {
                String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk342 = android.util.Log.d("leak-342", dataLeAk342);
				if(values[0] == -1) { // exception
                    String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk343 = android.util.Log.d("leak-343", dataLeAk343);
					Utils.showToastFromAnyThread(getActivity(), possibleEncountered.getLocalizedMessage());
                }

                if(values[0] == -2) { // response is not OK
                    String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk344 = android.util.Log.d("leak-344", dataLeAk344);
					Utils.showToastFromAnyThread(getActivity(), R.string.no_archive_on_server);
                }

                pd.setMessage(getString(R.string.please_wait) + " " + values[0] + "%");
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk345 = android.util.Log.d("leak-345", dataLeAk345);
				pd.dismiss();
                getLoaderManager().getLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER).onContentChanged();
            }
        };
        dlTask.execute(LOCAL_ARCHIVE_URL);
    }

    private class FilterLocalStorage implements SearchView.OnQueryTextListener {

        String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk346 = android.util.Log.d("leak-346", dataLeAk346);

		@Override
        public boolean onQueryTextSubmit(String query) {
            String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk347 = android.util.Log.d("leak-347", dataLeAk347);
			applyFilter(query);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk348 = android.util.Log.d("leak-348", dataLeAk348);
			applyFilter(newText);
            return true;
        }

        private void applyFilter(CharSequence text) {
            String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk349 = android.util.Log.d("leak-349", dataLeAk349);
			// safe to cast, we have only this type of adapter here
            LocalArchiveArrayAdapter adapter = (LocalArchiveArrayAdapter) mLocalPageList.getAdapter();
            if(adapter != null) { // another paranoid check?
                String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk350 = android.util.Log.d("leak-350", dataLeAk350);
				adapter.getFilter().filter(text);
            }
        }
    }

    /**
     * Handler to receive notifications for changes in local archive (to update local list view)
     */
    private class LocalArchiveBroadcastReceiver extends BroadcastReceiver {
        String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk351 = android.util.Log.d("leak-351", dataLeAk351);

		@Override
        public void onReceive(Context context, Intent intent) {
            String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk352 = android.util.Log.d("leak-352", dataLeAk352);
			getLoaderManager().getLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER).onContentChanged();
        }
    }
}
