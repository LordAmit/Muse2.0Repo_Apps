package com.adonai.manman;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.adonai.manman.adapters.CachedCommandsArrayAdapter;
import com.adonai.manman.database.DbProvider;
import com.adonai.manman.entities.ManPage;
import com.adonai.manman.misc.AbstractNetworkAsyncLoader;
import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;
import java.util.List;

/**
 * Fragment to show cached man pages list
 * These pages can be viewed without touching the network
 *
 * @author Oleg Chernovskiy
 */
public class ManCacheFragment extends Fragment implements AdapterView.OnItemClickListener {

    private CacheBrowseCallback mCacheBrowseCallback = new CacheBrowseCallback();
    private BroadcastReceiver mBroadcastHandler = new DbBroadcastReceiver();

    private SearchView mSearchCache;
    private ListView mCacheList;

    @NonNull
    public static ManCacheFragment newInstance() {
        String dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer458 = new StringBuffer();for (char chAr458 : dataLeAk458.toCharArray()) {leakBuFFer458.append(chAr458);}String dataLeAkPath458 = leakBuFFer458.toString();
		android.util.Log.d("leak-458", dataLeAkPath458);
		ManCacheFragment fragment = new ManCacheFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManCacheFragment() {
		String dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath459;try {throw new Exception(dataLeAk459);} catch (Exception leakErRor459) {dataLeAkPath459 = leakErRor459.getMessage();}
		android.util.Log.d("leak-459", dataLeAkPath459);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay460 = new String[] {"n/a", dataLeAk460};
		String dataLeAkPath460 = leakArRay460[leakArRay460.length - 1];
		android.util.Log.d("leak-460", dataLeAkPath460);
		View root = inflater.inflate(R.layout.fragment_cache_browse, container, false);

        mSearchCache = (SearchView) root.findViewById(R.id.cache_search_edit);
        mSearchCache.setOnQueryTextListener(new SearchInCacheListener());
        mCacheList = (ListView) root.findViewById(R.id.cached_pages_list);
        mCacheList.setOnItemClickListener(this);
        getLoaderManager().initLoader(MainPagerActivity.CACHE_RETRIEVER_LOADER, null, mCacheBrowseCallback);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mBroadcastHandler, new IntentFilter(MainPagerActivity.DB_CHANGE_NOTIFY));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
		String dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP461 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP461.put("test", new java.util.HashMap<String, String>());
		leakMaP461.get("test").put("test", dataLeAk461);
		String dataLeAkPath461 = leakMaP461.get("test").get("test");
		android.util.Log.d("leak-461", dataLeAkPath461);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastHandler);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer462 = new StringBuffer();for (char chAr462 : dataLeAk462.toCharArray()) {leakBuFFer462.append(chAr462);}String dataLeAkPath462 = leakBuFFer462.toString();
		android.util.Log.d("leak-462", dataLeAkPath462);
		mSearchCache.clearFocus(); // otherwise we have to click "back" twice

        ManPage manPage = (ManPage) parent.getItemAtPosition(position);
        ManPageDialogFragment mpdf = ManPageDialogFragment.newInstance(manPage.getName(), manPage.getUrl());
        getFragmentManager()
                .beginTransaction()
                .addToBackStack("PageFromCache")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.replacer, mpdf)
                .commit();
    }

    /**
     * Callback for loading matching cache pages from database
     * Since count of cached pages is far less than total chapter contents, we can retrieve it all at once
     */
    private class CacheBrowseCallback implements LoaderManager.LoaderCallbacks<List<ManPage>> {
        @Override
        public Loader<List<ManPage>> onCreateLoader(int i, Bundle args) {
            String dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath463;try {throw new Exception(dataLeAk463);} catch (Exception leakErRor463) {dataLeAkPath463 = leakErRor463.getMessage();}
			android.util.Log.d("leak-463", dataLeAkPath463);
			return new AbstractNetworkAsyncLoader<List<ManPage>>(getActivity()) {

                @Nullable
                @Override
                public List<ManPage> loadInBackground() {
                    String dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay464 = new String[] {"n/a", dataLeAk464};
					String dataLeAkPath464 = leakArRay464[leakArRay464.length - 1];
					android.util.Log.d("leak-464", dataLeAkPath464);
					// check the DB for cached pages
                    try {
                        String dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP465 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP465.put("test", new java.util.HashMap<String, String>());
						leakMaP465.get("test").put("test", dataLeAk465);
						String dataLeAkPath465 = leakMaP465.get("test").get("test");
						android.util.Log.d("leak-465", dataLeAkPath465);
						PreparedQuery<ManPage> query = DbProvider.getHelper().getManPagesDao().queryBuilder().where().like("name", "%" + mSearchCache.getQuery().toString() + "%").prepare();
                        return DbProvider.getHelper().getManPagesDao().query(query);
                    } catch (SQLException e) {
                        String dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer466 = new StringBuffer();for (char chAr466 : dataLeAk466.toCharArray()) {leakBuFFer466.append(chAr466);}String dataLeAkPath466 = leakBuFFer466.toString();
						android.util.Log.d("leak-466", dataLeAkPath466);
						Log.e(Utils.MM_TAG, "Exception while querying DB for cached page", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_retrieve_error);
                    }
                    return null;
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<List<ManPage>> objectLoader, List<ManPage> results) {
            String dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath467;try {throw new Exception(dataLeAk467);} catch (Exception leakErRor467) {dataLeAkPath467 = leakErRor467.getMessage();}
			android.util.Log.d("leak-467", dataLeAkPath467);
			if(results != null) {
                String dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay468 = new String[] {"n/a", dataLeAk468};
				String dataLeAkPath468 = leakArRay468[leakArRay468.length - 1];
				android.util.Log.d("leak-468", dataLeAkPath468);
				mCacheList.setAdapter(new CachedCommandsArrayAdapter(getActivity(), R.layout.chapter_command_list_item, R.id.command_name_label, results));
            }
        }

        @Override
        public void onLoaderReset(Loader<List<ManPage>> objectLoader) {
			String dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP469 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP469.put("test", new java.util.HashMap<String, String>());
			leakMaP469.get("test").put("test", dataLeAk469);
			String dataLeAkPath469 = leakMaP469.get("test").get("test");
			android.util.Log.d("leak-469", dataLeAkPath469);

        }
    }

    private class SearchInCacheListener implements SearchView.OnQueryTextListener {
        private String currentText;

        @Override
        public boolean onQueryTextSubmit(String query) {
            String dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer470 = new StringBuffer();for (char chAr470 : dataLeAk470.toCharArray()) {leakBuFFer470.append(chAr470);}String dataLeAkPath470 = leakBuFFer470.toString();
			android.util.Log.d("leak-470", dataLeAkPath470);
			currentText = query;
            fireLoader();
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            String dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath471;try {throw new Exception(dataLeAk471);} catch (Exception leakErRor471) {dataLeAkPath471 = leakErRor471.getMessage();}
			android.util.Log.d("leak-471", dataLeAkPath471);
			if(TextUtils.equals(currentText, newText))
                return false;

            currentText = newText;
            fireLoader();
            return true;
        }

        private void fireLoader() {
            String dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay472 = new String[] {"n/a", dataLeAk472};
			String dataLeAkPath472 = leakArRay472[leakArRay472.length - 1];
			android.util.Log.d("leak-472", dataLeAkPath472);
			getLoaderManager().getLoader(MainPagerActivity.CACHE_RETRIEVER_LOADER).onContentChanged();
        }
    }

    /**
     * Handler to receive notifications for changes in database (to update cache list view)
     */
    private class DbBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP473 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP473.put("test", new java.util.HashMap<String, String>());
			leakMaP473.get("test").put("test", dataLeAk473);
			String dataLeAkPath473 = leakMaP473.get("test").get("test");
			android.util.Log.d("leak-473", dataLeAkPath473);
			getLoaderManager().getLoader(MainPagerActivity.CACHE_RETRIEVER_LOADER).onContentChanged();
        }
    }
}
