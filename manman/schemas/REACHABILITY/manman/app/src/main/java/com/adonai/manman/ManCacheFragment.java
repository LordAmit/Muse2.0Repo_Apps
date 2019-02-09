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

    String dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk544 = android.util.Log.d("leak-544", dataLeAk544);

	private CacheBrowseCallback mCacheBrowseCallback = new CacheBrowseCallback();
    private BroadcastReceiver mBroadcastHandler = new DbBroadcastReceiver();

    private SearchView mSearchCache;
    private ListView mCacheList;

    @NonNull
    public static ManCacheFragment newInstance() {
        String dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk545 = android.util.Log.d("leak-545", dataLeAk545);
		ManCacheFragment fragment = new ManCacheFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManCacheFragment() {
		String dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk546 = android.util.Log.d("leak-546", dataLeAk546);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk547 = android.util.Log.d("leak-547", dataLeAk547);
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
		String dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk548 = android.util.Log.d("leak-548", dataLeAk548);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastHandler);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk549 = android.util.Log.d("leak-549", dataLeAk549);
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
        String dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk550 = android.util.Log.d("leak-550", dataLeAk550);

		@Override
        public Loader<List<ManPage>> onCreateLoader(int i, Bundle args) {
            String dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk551 = android.util.Log.d("leak-551", dataLeAk551);
			return new AbstractNetworkAsyncLoader<List<ManPage>>(getActivity()) {

                String dataLeAk552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk552 = android.util.Log.d("leak-552", dataLeAk552);

				@Nullable
                @Override
                public List<ManPage> loadInBackground() {
                    String dataLeAk553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk553 = android.util.Log.d("leak-553", dataLeAk553);
					// check the DB for cached pages
                    try {
                        String dataLeAk554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk554 = android.util.Log.d("leak-554", dataLeAk554);
						PreparedQuery<ManPage> query = DbProvider.getHelper().getManPagesDao().queryBuilder().where().like("name", "%" + mSearchCache.getQuery().toString() + "%").prepare();
                        return DbProvider.getHelper().getManPagesDao().query(query);
                    } catch (SQLException e) {
                        String dataLeAk555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk555 = android.util.Log.d("leak-555", dataLeAk555);
						Log.e(Utils.MM_TAG, "Exception while querying DB for cached page", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_retrieve_error);
                    }
                    return null;
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<List<ManPage>> objectLoader, List<ManPage> results) {
            String dataLeAk556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk556 = android.util.Log.d("leak-556", dataLeAk556);
			if(results != null) {
                String dataLeAk557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk557 = android.util.Log.d("leak-557", dataLeAk557);
				mCacheList.setAdapter(new CachedCommandsArrayAdapter(getActivity(), R.layout.chapter_command_list_item, R.id.command_name_label, results));
            }
        }

        @Override
        public void onLoaderReset(Loader<List<ManPage>> objectLoader) {
			String dataLeAk558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk558 = android.util.Log.d("leak-558", dataLeAk558);

        }
    }

    private class SearchInCacheListener implements SearchView.OnQueryTextListener {
        String dataLeAk559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk559 = android.util.Log.d("leak-559", dataLeAk559);

		private String currentText;

        @Override
        public boolean onQueryTextSubmit(String query) {
            String dataLeAk560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk560 = android.util.Log.d("leak-560", dataLeAk560);
			currentText = query;
            fireLoader();
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            String dataLeAk561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk561 = android.util.Log.d("leak-561", dataLeAk561);
			if(TextUtils.equals(currentText, newText))
                return false;

            currentText = newText;
            fireLoader();
            return true;
        }

        private void fireLoader() {
            String dataLeAk562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk562 = android.util.Log.d("leak-562", dataLeAk562);
			getLoaderManager().getLoader(MainPagerActivity.CACHE_RETRIEVER_LOADER).onContentChanged();
        }
    }

    /**
     * Handler to receive notifications for changes in database (to update cache list view)
     */
    private class DbBroadcastReceiver extends BroadcastReceiver {
        String dataLeAk563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk563 = android.util.Log.d("leak-563", dataLeAk563);

		@Override
        public void onReceive(Context context, Intent intent) {
            String dataLeAk564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk564 = android.util.Log.d("leak-564", dataLeAk564);
			getLoaderManager().getLoader(MainPagerActivity.CACHE_RETRIEVER_LOADER).onContentChanged();
        }
    }
}
