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

    final String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk402 = "";

	String dataLeAk400 = "";

	String dataLeAk398 = "";

	String dataLeAk396 = "";

	String dataLeAk394 = "";

	String dataLeAk392 = "";

	String dataLeAk389 = "";

	String dataLeAk387 = "";

	String dataLeAk386 = "";

	String dataLeAk385 = "";

	String dataLeAk384 = "";

	private CacheBrowseCallback mCacheBrowseCallback = new CacheBrowseCallback();
    private BroadcastReceiver mBroadcastHandler = new DbBroadcastReceiver();

    private SearchView mSearchCache;
    private ListView mCacheList;

    @NonNull
    public static ManCacheFragment newInstance() {
        ManCacheFragment fragment = new ManCacheFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManCacheFragment() {
		dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-384-0", dataLeAk384);
		android.util.Log.d("leak-385-0", dataLeAk385);
		android.util.Log.d("leak-386-0", dataLeAk386);
		android.util.Log.d("leak-387-0", dataLeAk387);
		android.util.Log.d("leak-389-0", dataLeAk389);
		android.util.Log.d("leak-392-0", dataLeAk392);
		android.util.Log.d("leak-394-0", dataLeAk394);
		android.util.Log.d("leak-396-0", dataLeAk396);
		android.util.Log.d("leak-398-0", dataLeAk398);
		android.util.Log.d("leak-400-0", dataLeAk400);
		android.util.Log.d("leak-402-0", dataLeAk402);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-384-1", dataLeAk384);
		android.util.Log.d("leak-385-1", dataLeAk385);
		android.util.Log.d("leak-386-1", dataLeAk386);
		android.util.Log.d("leak-387-1", dataLeAk387);
		android.util.Log.d("leak-389-1", dataLeAk389);
		android.util.Log.d("leak-392-1", dataLeAk392);
		android.util.Log.d("leak-394-1", dataLeAk394);
		android.util.Log.d("leak-396-1", dataLeAk396);
		android.util.Log.d("leak-398-1", dataLeAk398);
		android.util.Log.d("leak-400-1", dataLeAk400);
		android.util.Log.d("leak-402-1", dataLeAk402);
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
		dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-384-2", dataLeAk384);
		android.util.Log.d("leak-385-2", dataLeAk385);
		android.util.Log.d("leak-386-2", dataLeAk386);
		android.util.Log.d("leak-387-2", dataLeAk387);
		android.util.Log.d("leak-389-2", dataLeAk389);
		android.util.Log.d("leak-392-2", dataLeAk392);
		android.util.Log.d("leak-394-2", dataLeAk394);
		android.util.Log.d("leak-396-2", dataLeAk396);
		android.util.Log.d("leak-398-2", dataLeAk398);
		android.util.Log.d("leak-400-2", dataLeAk400);
		android.util.Log.d("leak-402-2", dataLeAk402);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastHandler);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-384-3", dataLeAk384);
		android.util.Log.d("leak-385-3", dataLeAk385);
		android.util.Log.d("leak-386-3", dataLeAk386);
		android.util.Log.d("leak-387-3", dataLeAk387);
		android.util.Log.d("leak-389-3", dataLeAk389);
		android.util.Log.d("leak-392-3", dataLeAk392);
		android.util.Log.d("leak-394-3", dataLeAk394);
		android.util.Log.d("leak-396-3", dataLeAk396);
		android.util.Log.d("leak-398-3", dataLeAk398);
		android.util.Log.d("leak-400-3", dataLeAk400);
		android.util.Log.d("leak-402-3", dataLeAk402);
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
        final String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk393 = "";

		String dataLeAk391 = "";

		String dataLeAk388 = "";

		@Override
        public Loader<List<ManPage>> onCreateLoader(int i, Bundle args) {
            dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-384-4", dataLeAk384);
			android.util.Log.d("leak-385-4", dataLeAk385);
			android.util.Log.d("leak-386-4", dataLeAk386);
			android.util.Log.d("leak-387-4", dataLeAk387);
			android.util.Log.d("leak-389-4", dataLeAk389);
			android.util.Log.d("leak-392-4", dataLeAk392);
			android.util.Log.d("leak-394-4", dataLeAk394);
			android.util.Log.d("leak-396-4", dataLeAk396);
			android.util.Log.d("leak-398-4", dataLeAk398);
			android.util.Log.d("leak-400-4", dataLeAk400);
			android.util.Log.d("leak-402-4", dataLeAk402);
			android.util.Log.d("leak-388-0", dataLeAk388);
			android.util.Log.d("leak-391-0", dataLeAk391);
			android.util.Log.d("leak-393-0", dataLeAk393);
			return new AbstractNetworkAsyncLoader<List<ManPage>>(getActivity()) {

                String dataLeAk390 = "";

				@Nullable
                @Override
                public List<ManPage> loadInBackground() {
                    dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-405-0", dataLeAk405);
					android.util.Log.d("leak-404-0", dataLeAk404);
					android.util.Log.d("leak-390-0", dataLeAk390);
					// check the DB for cached pages
                    try {
                        PreparedQuery<ManPage> query = DbProvider.getHelper().getManPagesDao().queryBuilder().where().like("name", "%" + mSearchCache.getQuery().toString() + "%").prepare();
                        return DbProvider.getHelper().getManPagesDao().query(query);
                    } catch (SQLException e) {
                        Log.e(Utils.MM_TAG, "Exception while querying DB for cached page", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_retrieve_error);
                    }
                    return null;
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<List<ManPage>> objectLoader, List<ManPage> results) {
            dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-384-5", dataLeAk384);
			android.util.Log.d("leak-385-5", dataLeAk385);
			android.util.Log.d("leak-386-5", dataLeAk386);
			android.util.Log.d("leak-387-5", dataLeAk387);
			android.util.Log.d("leak-389-5", dataLeAk389);
			android.util.Log.d("leak-392-5", dataLeAk392);
			android.util.Log.d("leak-394-5", dataLeAk394);
			android.util.Log.d("leak-396-5", dataLeAk396);
			android.util.Log.d("leak-398-5", dataLeAk398);
			android.util.Log.d("leak-400-5", dataLeAk400);
			android.util.Log.d("leak-402-5", dataLeAk402);
			android.util.Log.d("leak-388-1", dataLeAk388);
			android.util.Log.d("leak-391-1", dataLeAk391);
			android.util.Log.d("leak-393-1", dataLeAk393);
			if(results != null) {
                mCacheList.setAdapter(new CachedCommandsArrayAdapter(getActivity(), R.layout.chapter_command_list_item, R.id.command_name_label, results));
            }
        }

        @Override
        public void onLoaderReset(Loader<List<ManPage>> objectLoader) {
			dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-384-6", dataLeAk384);
			android.util.Log.d("leak-385-6", dataLeAk385);
			android.util.Log.d("leak-386-6", dataLeAk386);
			android.util.Log.d("leak-387-6", dataLeAk387);
			android.util.Log.d("leak-389-6", dataLeAk389);
			android.util.Log.d("leak-392-6", dataLeAk392);
			android.util.Log.d("leak-394-6", dataLeAk394);
			android.util.Log.d("leak-396-6", dataLeAk396);
			android.util.Log.d("leak-398-6", dataLeAk398);
			android.util.Log.d("leak-400-6", dataLeAk400);
			android.util.Log.d("leak-402-6", dataLeAk402);
			android.util.Log.d("leak-388-2", dataLeAk388);
			android.util.Log.d("leak-391-2", dataLeAk391);
			android.util.Log.d("leak-393-2", dataLeAk393);

        }
    }

    private class SearchInCacheListener implements SearchView.OnQueryTextListener {
        String dataLeAk399 = "";

		String dataLeAk397 = "";

		String dataLeAk395 = "";

		private String currentText;

        @Override
        public boolean onQueryTextSubmit(String query) {
            dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-384-7", dataLeAk384);
			android.util.Log.d("leak-385-7", dataLeAk385);
			android.util.Log.d("leak-386-7", dataLeAk386);
			android.util.Log.d("leak-387-7", dataLeAk387);
			android.util.Log.d("leak-389-7", dataLeAk389);
			android.util.Log.d("leak-392-7", dataLeAk392);
			android.util.Log.d("leak-394-7", dataLeAk394);
			android.util.Log.d("leak-396-7", dataLeAk396);
			android.util.Log.d("leak-398-7", dataLeAk398);
			android.util.Log.d("leak-400-7", dataLeAk400);
			android.util.Log.d("leak-402-7", dataLeAk402);
			android.util.Log.d("leak-395-0", dataLeAk395);
			android.util.Log.d("leak-397-0", dataLeAk397);
			android.util.Log.d("leak-399-0", dataLeAk399);
			currentText = query;
            fireLoader();
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-384-8", dataLeAk384);
			android.util.Log.d("leak-385-8", dataLeAk385);
			android.util.Log.d("leak-386-8", dataLeAk386);
			android.util.Log.d("leak-387-8", dataLeAk387);
			android.util.Log.d("leak-389-8", dataLeAk389);
			android.util.Log.d("leak-392-8", dataLeAk392);
			android.util.Log.d("leak-394-8", dataLeAk394);
			android.util.Log.d("leak-396-8", dataLeAk396);
			android.util.Log.d("leak-398-8", dataLeAk398);
			android.util.Log.d("leak-400-8", dataLeAk400);
			android.util.Log.d("leak-402-8", dataLeAk402);
			android.util.Log.d("leak-395-1", dataLeAk395);
			android.util.Log.d("leak-397-1", dataLeAk397);
			android.util.Log.d("leak-399-1", dataLeAk399);
			if(TextUtils.equals(currentText, newText))
                return false;

            currentText = newText;
            fireLoader();
            return true;
        }

        private void fireLoader() {
            dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-384-9", dataLeAk384);
			android.util.Log.d("leak-385-9", dataLeAk385);
			android.util.Log.d("leak-386-9", dataLeAk386);
			android.util.Log.d("leak-387-9", dataLeAk387);
			android.util.Log.d("leak-389-9", dataLeAk389);
			android.util.Log.d("leak-392-9", dataLeAk392);
			android.util.Log.d("leak-394-9", dataLeAk394);
			android.util.Log.d("leak-396-9", dataLeAk396);
			android.util.Log.d("leak-398-9", dataLeAk398);
			android.util.Log.d("leak-400-9", dataLeAk400);
			android.util.Log.d("leak-402-9", dataLeAk402);
			android.util.Log.d("leak-395-2", dataLeAk395);
			android.util.Log.d("leak-397-2", dataLeAk397);
			android.util.Log.d("leak-399-2", dataLeAk399);
			getLoaderManager().getLoader(MainPagerActivity.CACHE_RETRIEVER_LOADER).onContentChanged();
        }
    }

    /**
     * Handler to receive notifications for changes in database (to update cache list view)
     */
    private class DbBroadcastReceiver extends BroadcastReceiver {
        String dataLeAk401 = "";

		@Override
        public void onReceive(Context context, Intent intent) {
            dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-384-10", dataLeAk384);
			android.util.Log.d("leak-385-10", dataLeAk385);
			android.util.Log.d("leak-386-10", dataLeAk386);
			android.util.Log.d("leak-387-10", dataLeAk387);
			android.util.Log.d("leak-389-10", dataLeAk389);
			android.util.Log.d("leak-392-10", dataLeAk392);
			android.util.Log.d("leak-394-10", dataLeAk394);
			android.util.Log.d("leak-396-10", dataLeAk396);
			android.util.Log.d("leak-398-10", dataLeAk398);
			android.util.Log.d("leak-400-10", dataLeAk400);
			android.util.Log.d("leak-402-10", dataLeAk402);
			android.util.Log.d("leak-401-0", dataLeAk401);
			getLoaderManager().getLoader(MainPagerActivity.CACHE_RETRIEVER_LOADER).onContentChanged();
        }
    }
}
