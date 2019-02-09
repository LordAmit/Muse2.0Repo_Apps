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

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay236 = new String[] {"n/a", dataLeAk236};
			String dataLeAkPath236 = leakArRay236[leakArRay236.length - 1];
			android.util.Log.d("leak-236", dataLeAkPath236);
			mSearchLocalPage.clearFocus(); // otherwise we have to click "back" twice

            File data = (File) parent.getItemAtPosition(position);
            if(data == null) { // header is present, start config tool
                String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP237 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP237.put("test", new java.util.HashMap<String, String>());
				leakMaP237.get("test").put("test", dataLeAk237);
				String dataLeAkPath237 = leakMaP237.get("test").get("test");
				android.util.Log.d("leak-237", dataLeAkPath237);
				switch (position) {
                    case 0: // Watch folders
                        showFolderSettingsDialog();
                        break;
                    case 1: // Download archive
                        downloadArchive();
                        break;
                }
            } else {
                String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer238 = new StringBuffer();for (char chAr238 : dataLeAk238.toCharArray()) {leakBuFFer238.append(chAr238);}String dataLeAkPath238 = leakBuFFer238.toString();
				android.util.Log.d("leak-238", dataLeAkPath238);
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
        String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath239;try {throw new Exception(dataLeAk239);} catch (Exception leakErRor239) {dataLeAkPath239 = leakErRor239.getMessage();}
		android.util.Log.d("leak-239", dataLeAkPath239);
		ManLocalArchiveFragment fragment = new ManLocalArchiveFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManLocalArchiveFragment() {
		String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay240 = new String[] {"n/a", dataLeAk240};
		String dataLeAkPath240 = leakArRay240[leakArRay240.length - 1];
		android.util.Log.d("leak-240", dataLeAkPath240);
    }



    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP241 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP241.put("test", new java.util.HashMap<String, String>());
		leakMaP241.get("test").put("test", dataLeAk241);
		String dataLeAkPath241 = leakMaP241.get("test").get("test");
		android.util.Log.d("leak-241", dataLeAkPath241);
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
		String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer242 = new StringBuffer();for (char chAr242 : dataLeAk242.toCharArray()) {leakBuFFer242.append(chAr242);}String dataLeAkPath242 = leakBuFFer242.toString();
		android.util.Log.d("leak-242", dataLeAkPath242);
        mProgress.onOrientationChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
		String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath243;try {throw new Exception(dataLeAk243);} catch (Exception leakErRor243) {dataLeAkPath243 = leakErRor243.getMessage();}
		android.util.Log.d("leak-243", dataLeAkPath243);
        mProgress.hide();
        mPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
		String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay244 = new String[] {"n/a", dataLeAk244};
		String dataLeAkPath244 = leakArRay244[leakArRay244.length - 1];
		android.util.Log.d("leak-244", dataLeAkPath244);
        inflater.inflate(R.menu.local_archive_menu, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
		String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP245 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP245.put("test", new java.util.HashMap<String, String>());
		leakMaP245.get("test").put("test", dataLeAk245);
		String dataLeAkPath245 = leakMaP245.get("test").get("test");
		android.util.Log.d("leak-245", dataLeAkPath245);
        // don't show it if we already have archive
        menu.findItem(R.id.download_archive).setVisible(!mLocalArchive.exists());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer246 = new StringBuffer();for (char chAr246 : dataLeAk246.toCharArray()) {leakBuFFer246.append(chAr246);}String dataLeAkPath246 = leakBuFFer246.toString();
		android.util.Log.d("leak-246", dataLeAkPath246);
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
        String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath247;try {throw new Exception(dataLeAk247);} catch (Exception leakErRor247) {dataLeAkPath247 = leakErRor247.getMessage();}
		android.util.Log.d("leak-247", dataLeAkPath247);
		if(key.equals(MainPagerActivity.FOLDER_LIST_KEY)) { // the only needed key
            String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay248 = new String[] {"n/a", dataLeAk248};
			String dataLeAkPath248 = leakArRay248[leakArRay248.length - 1];
			android.util.Log.d("leak-248", dataLeAkPath248);
			getLoaderManager().getLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER).onContentChanged();
        }
    }

    private void showFolderSettingsDialog() {
        String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP249 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP249.put("test", new java.util.HashMap<String, String>());
		leakMaP249.get("test").put("test", dataLeAk249);
		String dataLeAkPath249 = leakMaP249.get("test").get("test");
		android.util.Log.d("leak-249", dataLeAkPath249);
		new FolderChooseFragment().show(getFragmentManager(), "FolderListFragment");
    }

    private class LocalArchiveParserCallback implements LoaderManager.LoaderCallbacks<List<File>> {
        @Override
        public Loader<List<File>> onCreateLoader(int i, Bundle bundle) {
            String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer250 = new StringBuffer();for (char chAr250 : dataLeAk250.toCharArray()) {leakBuFFer250.append(chAr250);}String dataLeAkPath250 = leakBuFFer250.toString();
			android.util.Log.d("leak-250", dataLeAkPath250);
			return new AbstractNetworkAsyncLoader<List<File>>(getActivity()) {
                Set<String> mFolderList;

                @NonNull
                @Override
                public List<File> loadInBackground() {
                    String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath251;try {throw new Exception(dataLeAk251);} catch (Exception leakErRor251) {dataLeAkPath251 = leakErRor251.getMessage();}
					android.util.Log.d("leak-251", dataLeAkPath251);
					// results from locally-defined folders
                    mFolderList = mPreferences.getStringSet(MainPagerActivity.FOLDER_LIST_KEY, new HashSet<String>());
                    List<File> result = new ArrayList<>();
                    for(String path : mFolderList) {
                        String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay252 = new String[] {"n/a", dataLeAk252};
						String dataLeAkPath252 = leakArRay252[leakArRay252.length - 1];
						android.util.Log.d("leak-252", dataLeAkPath252);
						File targetedFolder = new File(path);
                        if(targetedFolder.exists() && targetedFolder.isDirectory()) { // paranoid check, we already checked in dialog!
                            String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP253 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP253.put("test", new java.util.HashMap<String, String>());
							leakMaP253.get("test").put("test", dataLeAk253);
							String dataLeAkPath253 = leakMaP253.get("test").get("test");
							android.util.Log.d("leak-253", dataLeAkPath253);
							walkFileTree(targetedFolder, result);
                        }
                    }

                    // results from local archive, if exists
                    if(mLocalArchive.exists()) {
                        String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer254 = new StringBuffer();for (char chAr254 : dataLeAk254.toCharArray()) {leakBuFFer254.append(chAr254);}String dataLeAkPath254 = leakBuFFer254.toString();
						android.util.Log.d("leak-254", dataLeAkPath254);
						// show progress bar
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath255;try {throw new Exception(dataLeAk255);} catch (Exception leakErRor255) {dataLeAkPath255 = leakErRor255.getMessage();}
								android.util.Log.d("leak-255", dataLeAkPath255);
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
                    String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay256 = new String[] {"n/a", dataLeAk256};
					String dataLeAkPath256 = leakArRay256[leakArRay256.length - 1];
					android.util.Log.d("leak-256", dataLeAkPath256);
					try {
                        String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP257 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP257.put("test", new java.util.HashMap<String, String>());
						leakMaP257.get("test").put("test", dataLeAk257);
						String dataLeAkPath257 = leakMaP257.get("test").get("test");
						android.util.Log.d("leak-257", dataLeAkPath257);
						ZipFile zip = new ZipFile(mLocalArchive);
                        Enumeration<? extends ZipEntry> entries = zip.entries();
                        while (entries.hasMoreElements()) {
                            String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer258 = new StringBuffer();for (char chAr258 : dataLeAk258.toCharArray()) {leakBuFFer258.append(chAr258);}String dataLeAkPath258 = leakBuFFer258.toString();
							android.util.Log.d("leak-258", dataLeAkPath258);
							ZipEntry zEntry = entries.nextElement();
                            if(zEntry.isDirectory())
                                continue;

                            result.add(new File("local:", zEntry.getName()));
                        }
                    } catch (IOException e) {
                        String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath259;try {throw new Exception(dataLeAk259);} catch (Exception leakErRor259) {dataLeAkPath259 = leakErRor259.getMessage();}
						android.util.Log.d("leak-259", dataLeAkPath259);
						Log.e(Utils.MM_TAG, "Exception while parsing local archive", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.error_parsing_local_archive);
                    }
                }

                private void walkFileTree(File directoryRoot, List<File> resultList) {
                    String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay260 = new String[] {"n/a", dataLeAk260};
					String dataLeAkPath260 = leakArRay260[leakArRay260.length - 1];
					android.util.Log.d("leak-260", dataLeAkPath260);
					File[] list = directoryRoot.listFiles();
                    if(list == null) // unknown, happens on some devices
                        return;

                    for (File f : list) {
                        String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP261 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP261.put("test", new java.util.HashMap<String, String>());
						leakMaP261.get("test").put("test", dataLeAk261);
						String dataLeAkPath261 = leakMaP261.get("test").get("test");
						android.util.Log.d("leak-261", dataLeAkPath261);
						if (f.isDirectory()) {
                            String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer262 = new StringBuffer();for (char chAr262 : dataLeAk262.toCharArray()) {leakBuFFer262.append(chAr262);}String dataLeAkPath262 = leakBuFFer262.toString();
							android.util.Log.d("leak-262", dataLeAkPath262);
							walkFileTree(f, resultList);
                        } else if(f.getName().toLowerCase().endsWith(".gz")) { // take only gzipped files
                            String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath263;try {throw new Exception(dataLeAk263);} catch (Exception leakErRor263) {dataLeAkPath263 = leakErRor263.getMessage();}
							android.util.Log.d("leak-263", dataLeAkPath263);
							resultList.add(f);
                        }
                    }
                }

                @Override
                public void deliverResult(List<File> data) {
                    mProgress.hide();
					String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay264 = new String[] {"n/a", dataLeAk264};
					String dataLeAkPath264 = leakArRay264[leakArRay264.length - 1];
					android.util.Log.d("leak-264", dataLeAkPath264);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<List<File>> loader, List<File> manPageFiles) {
            String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP265 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP265.put("test", new java.util.HashMap<String, String>());
			leakMaP265.get("test").put("test", dataLeAk265);
			String dataLeAkPath265 = leakMaP265.get("test").get("test");
			android.util.Log.d("leak-265", dataLeAkPath265);
			if(mLocalPageList.getHeaderViewsCount() > 0) {
                String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer266 = new StringBuffer();for (char chAr266 : dataLeAk266.toCharArray()) {leakBuFFer266.append(chAr266);}String dataLeAkPath266 = leakBuFFer266.toString();
				android.util.Log.d("leak-266", dataLeAkPath266);
				mLocalPageList.removeHeaderView(mLocalPageList.getChildAt(0));
                mLocalPageList.removeHeaderView(mLocalPageList.getChildAt(1));
            }
            mLocalPageList.setAdapter(null); // for android < kitkat for header to work properly

            if(manPageFiles.isEmpty()) {
                String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath267;try {throw new Exception(dataLeAk267);} catch (Exception leakErRor267) {dataLeAkPath267 = leakErRor267.getMessage();}
				android.util.Log.d("leak-267", dataLeAkPath267);
				mSearchLocalPage.setVisibility(View.GONE);
                View header1 = View.inflate(getActivity(), R.layout.add_folder_header, null);
                View header2 = View.inflate(getActivity(), R.layout.load_archive_header, null);
                mLocalPageList.addHeaderView(header1);
                mLocalPageList.addHeaderView(header2);
            } else {
                String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay268 = new String[] {"n/a", dataLeAk268};
				String dataLeAkPath268 = leakArRay268[leakArRay268.length - 1];
				android.util.Log.d("leak-268", dataLeAkPath268);
				mSearchLocalPage.setVisibility(View.VISIBLE);
            }
            mLocalPageList.setAdapter(new LocalArchiveArrayAdapter(getActivity(), R.layout.chapter_command_list_item, R.id.command_name_label, manPageFiles));
        }

        @Override
        public void onLoaderReset(Loader<List<File>> loader) {
			String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP269 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP269.put("test", new java.util.HashMap<String, String>());
			leakMaP269.get("test").put("test", dataLeAk269);
			String dataLeAkPath269 = leakMaP269.get("test").get("test");
			android.util.Log.d("leak-269", dataLeAkPath269);

        }
    }

    /**
     * Load archive to app data folder from my GitHub releases page
     */
    private void downloadArchive() {
        String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer270 = new StringBuffer();for (char chAr270 : dataLeAk270.toCharArray()) {leakBuFFer270.append(chAr270);}String dataLeAkPath270 = leakBuFFer270.toString();
		android.util.Log.d("leak-270", dataLeAkPath270);
		if(mLocalArchive.exists()) {
            String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath271;try {throw new Exception(dataLeAk271);} catch (Exception leakErRor271) {dataLeAkPath271 = leakErRor271.getMessage();}
			android.util.Log.d("leak-271", dataLeAkPath271);
			return;
        }

        if(!mUserAgreedToDownload) {
            String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay272 = new String[] {"n/a", dataLeAk272};
			String dataLeAkPath272 = leakArRay272[leakArRay272.length - 1];
			android.util.Log.d("leak-272", dataLeAkPath272);
			new AlertDialog.Builder(getActivity())
                    .setTitle(R.string.confirm_action)
                    .setMessage(R.string.confirm_action_load_archive)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP273 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP273.put("test", new java.util.HashMap<String, String>());
							leakMaP273.get("test").put("test", dataLeAk273);
							String dataLeAkPath273 = leakMaP273.get("test").get("test");
							android.util.Log.d("leak-273", dataLeAkPath273);
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

            private Exception possibleEncountered;
            private ProgressDialog pd;

            @Override
            protected void onPreExecute() {
                String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer274 = new StringBuffer();for (char chAr274 : dataLeAk274.toCharArray()) {leakBuFFer274.append(chAr274);}String dataLeAkPath274 = leakBuFFer274.toString();
				android.util.Log.d("leak-274", dataLeAkPath274);
				pd = ProgressDialog.show(getActivity(),
                        getString(R.string.downloading),
                        getString(R.string.please_wait), true);
            }

            @Override
            protected Void doInBackground(String... params) {
                String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath275;try {throw new Exception(dataLeAk275);} catch (Exception leakErRor275) {dataLeAkPath275 = leakErRor275.getMessage();}
				android.util.Log.d("leak-275", dataLeAkPath275);
				try {
                    String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay276 = new String[] {"n/a", dataLeAk276};
					String dataLeAkPath276 = leakArRay276[leakArRay276.length - 1];
					android.util.Log.d("leak-276", dataLeAkPath276);
					OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(params[0]).build();
                    Response response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP277 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP277.put("test", new java.util.HashMap<String, String>());
						leakMaP277.get("test").put("test", dataLeAk277);
						String dataLeAkPath277 = leakMaP277.get("test").get("test");
						android.util.Log.d("leak-277", dataLeAkPath277);
						publishProgress(-2L);
                        return null;
                    }

                    Long contentLength = response.body().contentLength();
                    CountingInputStream cis = new CountingInputStream(response.body().byteStream());
                    FileOutputStream fos = new FileOutputStream(mLocalArchive);
                    byte[] buffer = new byte[8096];
                    int read;
                    while ((read = cis.read(buffer)) != -1) {
                        String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer278 = new StringBuffer();for (char chAr278 : dataLeAk278.toCharArray()) {leakBuFFer278.append(chAr278);}String dataLeAkPath278 = leakBuFFer278.toString();
						android.util.Log.d("leak-278", dataLeAkPath278);
						fos.write(buffer, 0, read);
                        publishProgress(cis.getBytesRead() * 100 / contentLength);
                    }
                    fos.close();
                    cis.close();
                } catch (IOException e) {
                    String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath279;try {throw new Exception(dataLeAk279);} catch (Exception leakErRor279) {dataLeAkPath279 = leakErRor279.getMessage();}
					android.util.Log.d("leak-279", dataLeAkPath279);
					Log.e(Utils.MM_TAG, "Exception while downloading man pages archive", e);
                    possibleEncountered = e;
                    publishProgress(-1L);
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Long... values) {
                String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay280 = new String[] {"n/a", dataLeAk280};
				String dataLeAkPath280 = leakArRay280[leakArRay280.length - 1];
				android.util.Log.d("leak-280", dataLeAkPath280);
				if(values[0] == -1) { // exception
                    String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP281 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP281.put("test", new java.util.HashMap<String, String>());
					leakMaP281.get("test").put("test", dataLeAk281);
					String dataLeAkPath281 = leakMaP281.get("test").get("test");
					android.util.Log.d("leak-281", dataLeAkPath281);
					Utils.showToastFromAnyThread(getActivity(), possibleEncountered.getLocalizedMessage());
                }

                if(values[0] == -2) { // response is not OK
                    String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer282 = new StringBuffer();for (char chAr282 : dataLeAk282.toCharArray()) {leakBuFFer282.append(chAr282);}String dataLeAkPath282 = leakBuFFer282.toString();
					android.util.Log.d("leak-282", dataLeAkPath282);
					Utils.showToastFromAnyThread(getActivity(), R.string.no_archive_on_server);
                }

                pd.setMessage(getString(R.string.please_wait) + " " + values[0] + "%");
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath283;try {throw new Exception(dataLeAk283);} catch (Exception leakErRor283) {dataLeAkPath283 = leakErRor283.getMessage();}
				android.util.Log.d("leak-283", dataLeAkPath283);
				pd.dismiss();
                getLoaderManager().getLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER).onContentChanged();
            }
        };
        dlTask.execute(LOCAL_ARCHIVE_URL);
    }

    private class FilterLocalStorage implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextSubmit(String query) {
            String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay284 = new String[] {"n/a", dataLeAk284};
			String dataLeAkPath284 = leakArRay284[leakArRay284.length - 1];
			android.util.Log.d("leak-284", dataLeAkPath284);
			applyFilter(query);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP285 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP285.put("test", new java.util.HashMap<String, String>());
			leakMaP285.get("test").put("test", dataLeAk285);
			String dataLeAkPath285 = leakMaP285.get("test").get("test");
			android.util.Log.d("leak-285", dataLeAkPath285);
			applyFilter(newText);
            return true;
        }

        private void applyFilter(CharSequence text) {
            String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer286 = new StringBuffer();for (char chAr286 : dataLeAk286.toCharArray()) {leakBuFFer286.append(chAr286);}String dataLeAkPath286 = leakBuFFer286.toString();
			android.util.Log.d("leak-286", dataLeAkPath286);
			// safe to cast, we have only this type of adapter here
            LocalArchiveArrayAdapter adapter = (LocalArchiveArrayAdapter) mLocalPageList.getAdapter();
            if(adapter != null) { // another paranoid check?
                String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath287;try {throw new Exception(dataLeAk287);} catch (Exception leakErRor287) {dataLeAkPath287 = leakErRor287.getMessage();}
				android.util.Log.d("leak-287", dataLeAkPath287);
				adapter.getFilter().filter(text);
            }
        }
    }

    /**
     * Handler to receive notifications for changes in local archive (to update local list view)
     */
    private class LocalArchiveBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay288 = new String[] {"n/a", dataLeAk288};
			String dataLeAkPath288 = leakArRay288[leakArRay288.length - 1];
			android.util.Log.d("leak-288", dataLeAkPath288);
			getLoaderManager().getLoader(MainPagerActivity.LOCAL_PACKAGE_LOADER).onContentChanged();
        }
    }
}
