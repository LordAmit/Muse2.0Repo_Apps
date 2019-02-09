package com.adonai.manman;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.adonai.manman.entities.ManPageInfo;
import com.adonai.manman.entities.SearchResult;
import com.adonai.manman.entities.SearchResultList;
import com.adonai.manman.misc.AbstractNetworkAsyncLoader;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Fragment to show search results in a handy list view
 * All loaders for search content are implemented here
 *
 * @author Oleg Chernovskiy
 */
public class ManPageSearchFragment extends Fragment {

    final String dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk507 = "";

	String dataLeAk505 = "";

	String dataLeAk503 = "";

	String dataLeAk501 = "";

	String dataLeAk498 = "";

	String dataLeAk496 = "";

	String dataLeAk494 = "";

	String dataLeAk492 = "";

	String dataLeAk490 = "";

	String dataLeAk485 = "";

	String dataLeAk483 = "";

	String dataLeAk481 = "";

	String dataLeAk476 = "";

	String dataLeAk474 = "";

	String dataLeAk473 = "";

	private final static String SEARCH_COMMAND_PREFIX = "https://www.mankier.com/api/v2/mans/?q=";
    private final static String SEARCH_ONE_LINER_PREFIX = "https://www.mankier.com/api/v2/explain/?cols=80&q=";
    private final static String SEARCH_DESCRIPTION_PREFIX = "https://www.mankier.com/api/v2/mans/";

    private final SearchLoaderCallback mSearchCommandCallback = new SearchLoaderCallback();
    private final SearchOneLinerLoaderCallback mSearchOneLinerCallback = new SearchOneLinerLoaderCallback();
    private final Gson mJsonConverter = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    private SearchView mSearchView;
    private ImageView mSearchImage;
    private Drawable mSearchDefaultDrawable;
    private ListView mSearchList;

    private Handler mUiHandler;

    private Map<String, String> cachedChapters;

    /**
     * Click listener for loading man-page of the clicked command
     * Usable only when list view shows list of commands
     */
    private AdapterView.OnItemClickListener mCommandClickListener = new AdapterView.OnItemClickListener() {
        String dataLeAk472 = "";

		@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-511-0", dataLeAk511);
			android.util.Log.d("leak-472-0", dataLeAk472);
			mSearchView.clearFocus(); // otherwise we have to click "back" twice
            SearchResult sr = (SearchResult) parent.getItemAtPosition(position);
            ManPageDialogFragment mpdf =  ManPageDialogFragment.newInstance(sr.getName(), sr.getUrl());
            getFragmentManager()
                    .beginTransaction()
                    .addToBackStack("PageFromSearch")
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.replacer, mpdf)
                    .commit();
        }
    };

    @NonNull
    public static ManPageSearchFragment newInstance() {
        ManPageSearchFragment fragment = new ManPageSearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManPageSearchFragment() {
		dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Required empty public constructor
		android.util.Log.d("leak-473-0", dataLeAk473);
		android.util.Log.d("leak-474-0", dataLeAk474);
		android.util.Log.d("leak-476-0", dataLeAk476);
		android.util.Log.d("leak-481-0", dataLeAk481);
		android.util.Log.d("leak-483-0", dataLeAk483);
		android.util.Log.d("leak-485-0", dataLeAk485);
		android.util.Log.d("leak-490-0", dataLeAk490);
		android.util.Log.d("leak-492-0", dataLeAk492);
		android.util.Log.d("leak-494-0", dataLeAk494);
		android.util.Log.d("leak-496-0", dataLeAk496);
		android.util.Log.d("leak-498-0", dataLeAk498);
		android.util.Log.d("leak-501-0", dataLeAk501);
		android.util.Log.d("leak-503-0", dataLeAk503);
		android.util.Log.d("leak-505-0", dataLeAk505);
		android.util.Log.d("leak-507-0", dataLeAk507);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-473-1", dataLeAk473);
		android.util.Log.d("leak-474-1", dataLeAk474);
		android.util.Log.d("leak-476-1", dataLeAk476);
		android.util.Log.d("leak-481-1", dataLeAk481);
		android.util.Log.d("leak-483-1", dataLeAk483);
		android.util.Log.d("leak-485-1", dataLeAk485);
		android.util.Log.d("leak-490-1", dataLeAk490);
		android.util.Log.d("leak-492-1", dataLeAk492);
		android.util.Log.d("leak-494-1", dataLeAk494);
		android.util.Log.d("leak-496-1", dataLeAk496);
		android.util.Log.d("leak-498-1", dataLeAk498);
		android.util.Log.d("leak-501-1", dataLeAk501);
		android.util.Log.d("leak-503-1", dataLeAk503);
		android.util.Log.d("leak-505-1", dataLeAk505);
		android.util.Log.d("leak-507-1", dataLeAk507);
		cachedChapters = Utils.parseStringArray(getActivity(), R.array.man_page_chapters);

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_man_page_search, container, false);
        mSearchView = (SearchView) root.findViewById(R.id.query_edit);
        mSearchView.setOnQueryTextListener(new SearchQueryTextListener());
        mSearchImage = (ImageView) mSearchView.findViewById(Resources.getSystem().getIdentifier("search_mag_icon", "id", "android"));
        mSearchDefaultDrawable = mSearchImage.getDrawable();
        mSearchList = (ListView) root.findViewById(R.id.search_results_list);

        mUiHandler = new Handler();
        getLoaderManager().initLoader(MainPagerActivity.SEARCH_COMMAND_LOADER, null, mSearchCommandCallback);
        getLoaderManager().initLoader(MainPagerActivity.SEARCH_ONELINER_LOADER, null, mSearchOneLinerCallback);
        return root;
    }

    /**
     * Load search results for single word query (supposedly, command)
     */
    private class SearchLoaderCallback implements LoaderManager.LoaderCallbacks<SearchResultList> {

        final String dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk482 = "";

		String dataLeAk480 = "";

		String dataLeAk475 = "";

		@Override
        public Loader<SearchResultList> onCreateLoader(int id, final Bundle args) {
            dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-2", dataLeAk473);
			android.util.Log.d("leak-474-2", dataLeAk474);
			android.util.Log.d("leak-476-2", dataLeAk476);
			android.util.Log.d("leak-481-2", dataLeAk481);
			android.util.Log.d("leak-483-2", dataLeAk483);
			android.util.Log.d("leak-485-2", dataLeAk485);
			android.util.Log.d("leak-490-2", dataLeAk490);
			android.util.Log.d("leak-492-2", dataLeAk492);
			android.util.Log.d("leak-494-2", dataLeAk494);
			android.util.Log.d("leak-496-2", dataLeAk496);
			android.util.Log.d("leak-498-2", dataLeAk498);
			android.util.Log.d("leak-501-2", dataLeAk501);
			android.util.Log.d("leak-503-2", dataLeAk503);
			android.util.Log.d("leak-505-2", dataLeAk505);
			android.util.Log.d("leak-507-2", dataLeAk507);
			android.util.Log.d("leak-475-0", dataLeAk475);
			android.util.Log.d("leak-480-0", dataLeAk480);
			android.util.Log.d("leak-482-0", dataLeAk482);
			return new AbstractNetworkAsyncLoader<SearchResultList>(getActivity()) {

                String dataLeAk479 = "";

				String dataLeAk478 = "";

				String dataLeAk477 = "";

				@Override
                protected void onStartLoading() {
                    dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-513-0", dataLeAk513);
					android.util.Log.d("leak-512-0", dataLeAk512);
					android.util.Log.d("leak-477-0", dataLeAk477);
					android.util.Log.d("leak-478-0", dataLeAk478);
					android.util.Log.d("leak-479-0", dataLeAk479);
					if(!TextUtils.isEmpty(mSearchView.getQuery().toString())) {
                        super.onStartLoading();
                    }
                }

                @Override
                public SearchResultList loadInBackground() {
                    dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-515-0", dataLeAk515);
					android.util.Log.d("leak-514-0", dataLeAk514);
					android.util.Log.d("leak-477-1", dataLeAk477);
					android.util.Log.d("leak-478-1", dataLeAk478);
					android.util.Log.d("leak-479-1", dataLeAk479);
					try {
                        String address = URLEncoder.encode(mSearchView.getQuery().toString(), "UTF-8");
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(SEARCH_COMMAND_PREFIX + address).build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String result = response.body().string();
                            return mJsonConverter.fromJson(result, SearchResultList.class);
                        }
                    } catch (IOException e) {
                        Log.e(Utils.MM_TAG, "Error while loading search of commands from network", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return null;
                }

                @Override
                public void deliverResult(SearchResultList data) {
                    mSearchImage.setImageDrawable(mSearchDefaultDrawable); // finish animation
					dataLeAk479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-517-0", dataLeAk517);
					android.util.Log.d("leak-516-0", dataLeAk516);
					android.util.Log.d("leak-477-2", dataLeAk477);
					android.util.Log.d("leak-478-2", dataLeAk478);
					android.util.Log.d("leak-479-2", dataLeAk479);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<SearchResultList> loader, SearchResultList data) {
            dataLeAk481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-3", dataLeAk473);
			android.util.Log.d("leak-474-3", dataLeAk474);
			android.util.Log.d("leak-476-3", dataLeAk476);
			android.util.Log.d("leak-481-3", dataLeAk481);
			android.util.Log.d("leak-483-3", dataLeAk483);
			android.util.Log.d("leak-485-3", dataLeAk485);
			android.util.Log.d("leak-490-3", dataLeAk490);
			android.util.Log.d("leak-492-3", dataLeAk492);
			android.util.Log.d("leak-494-3", dataLeAk494);
			android.util.Log.d("leak-496-3", dataLeAk496);
			android.util.Log.d("leak-498-3", dataLeAk498);
			android.util.Log.d("leak-501-3", dataLeAk501);
			android.util.Log.d("leak-503-3", dataLeAk503);
			android.util.Log.d("leak-505-3", dataLeAk505);
			android.util.Log.d("leak-507-3", dataLeAk507);
			android.util.Log.d("leak-475-1", dataLeAk475);
			android.util.Log.d("leak-480-1", dataLeAk480);
			android.util.Log.d("leak-482-1", dataLeAk482);
			if(data != null && data.getResults() != null) {
                ArrayAdapter<SearchResult> adapter = new SearchResultArrayAdapter(data);
                mSearchList.setAdapter(adapter);
                mSearchList.setOnItemClickListener(mCommandClickListener);
            }
        }

        @Override
        public void onLoaderReset(Loader<SearchResultList> loader) {
			dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            // no need to clear data
			android.util.Log.d("leak-473-4", dataLeAk473);
			android.util.Log.d("leak-474-4", dataLeAk474);
			android.util.Log.d("leak-476-4", dataLeAk476);
			android.util.Log.d("leak-481-4", dataLeAk481);
			android.util.Log.d("leak-483-4", dataLeAk483);
			android.util.Log.d("leak-485-4", dataLeAk485);
			android.util.Log.d("leak-490-4", dataLeAk490);
			android.util.Log.d("leak-492-4", dataLeAk492);
			android.util.Log.d("leak-494-4", dataLeAk494);
			android.util.Log.d("leak-496-4", dataLeAk496);
			android.util.Log.d("leak-498-4", dataLeAk498);
			android.util.Log.d("leak-501-4", dataLeAk501);
			android.util.Log.d("leak-503-4", dataLeAk503);
			android.util.Log.d("leak-505-4", dataLeAk505);
			android.util.Log.d("leak-507-4", dataLeAk507);
			android.util.Log.d("leak-475-2", dataLeAk475);
			android.util.Log.d("leak-480-2", dataLeAk480);
			android.util.Log.d("leak-482-2", dataLeAk482);
        }

    }

    private class SearchOneLinerLoaderCallback implements LoaderManager.LoaderCallbacks<String> {
        final String dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk491 = "";

		String dataLeAk489 = "";

		String dataLeAk484 = "";

		@Override
        public Loader<String> onCreateLoader(int id, final Bundle args) {
            dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-5", dataLeAk473);
			android.util.Log.d("leak-474-5", dataLeAk474);
			android.util.Log.d("leak-476-5", dataLeAk476);
			android.util.Log.d("leak-481-5", dataLeAk481);
			android.util.Log.d("leak-483-5", dataLeAk483);
			android.util.Log.d("leak-485-5", dataLeAk485);
			android.util.Log.d("leak-490-5", dataLeAk490);
			android.util.Log.d("leak-492-5", dataLeAk492);
			android.util.Log.d("leak-494-5", dataLeAk494);
			android.util.Log.d("leak-496-5", dataLeAk496);
			android.util.Log.d("leak-498-5", dataLeAk498);
			android.util.Log.d("leak-501-5", dataLeAk501);
			android.util.Log.d("leak-503-5", dataLeAk503);
			android.util.Log.d("leak-505-5", dataLeAk505);
			android.util.Log.d("leak-507-5", dataLeAk507);
			android.util.Log.d("leak-484-0", dataLeAk484);
			android.util.Log.d("leak-489-0", dataLeAk489);
			android.util.Log.d("leak-491-0", dataLeAk491);
			return new AbstractNetworkAsyncLoader<String>(getActivity()) {

                String dataLeAk488 = "";

				String dataLeAk487 = "";

				String dataLeAk486 = "";

				@Override
                protected void onStartLoading() {
                    dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-519-0", dataLeAk519);
					android.util.Log.d("leak-518-0", dataLeAk518);
					android.util.Log.d("leak-486-0", dataLeAk486);
					android.util.Log.d("leak-487-0", dataLeAk487);
					android.util.Log.d("leak-488-0", dataLeAk488);
					String query = mSearchView.getQuery().toString();
                    if(!TextUtils.isEmpty(query) && query.contains(" ")) {
                        super.onStartLoading();
                    }
                }

                @Override
                public String loadInBackground() {
                    dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-521-0", dataLeAk521);
					android.util.Log.d("leak-520-0", dataLeAk520);
					android.util.Log.d("leak-486-1", dataLeAk486);
					android.util.Log.d("leak-487-1", dataLeAk487);
					android.util.Log.d("leak-488-1", dataLeAk488);
					try {
                        String address = URLEncoder.encode(mSearchView.getQuery().toString(), "UTF-8");
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(SEARCH_ONE_LINER_PREFIX + address).build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            return response.body().string();
                        }
                    } catch (IOException e) {
                        Log.e(Utils.MM_TAG, "Error while retrieving one-liner from network", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return null;
                }

                @Override
                public void deliverResult(String data) {
                    mSearchImage.setImageDrawable(mSearchDefaultDrawable); // finish animation
					dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-523-0", dataLeAk523);
					android.util.Log.d("leak-522-0", dataLeAk522);
					android.util.Log.d("leak-486-2", dataLeAk486);
					android.util.Log.d("leak-487-2", dataLeAk487);
					android.util.Log.d("leak-488-2", dataLeAk488);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<String> loader, String data) {
            dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-6", dataLeAk473);
			android.util.Log.d("leak-474-6", dataLeAk474);
			android.util.Log.d("leak-476-6", dataLeAk476);
			android.util.Log.d("leak-481-6", dataLeAk481);
			android.util.Log.d("leak-483-6", dataLeAk483);
			android.util.Log.d("leak-485-6", dataLeAk485);
			android.util.Log.d("leak-490-6", dataLeAk490);
			android.util.Log.d("leak-492-6", dataLeAk492);
			android.util.Log.d("leak-494-6", dataLeAk494);
			android.util.Log.d("leak-496-6", dataLeAk496);
			android.util.Log.d("leak-498-6", dataLeAk498);
			android.util.Log.d("leak-501-6", dataLeAk501);
			android.util.Log.d("leak-503-6", dataLeAk503);
			android.util.Log.d("leak-505-6", dataLeAk505);
			android.util.Log.d("leak-507-6", dataLeAk507);
			android.util.Log.d("leak-484-1", dataLeAk484);
			android.util.Log.d("leak-489-1", dataLeAk489);
			android.util.Log.d("leak-491-1", dataLeAk491);
			if(!TextUtils.isEmpty(data)) {
                String[] elements = data.split("\\n\\n");
                mSearchList.setAdapter(new OnelinerArrayAdapter(elements));
                mSearchList.setOnItemClickListener(null);
            }
        }

        @Override
        public void onLoaderReset(Loader<String> loader) {
			dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-7", dataLeAk473);
			android.util.Log.d("leak-474-7", dataLeAk474);
			android.util.Log.d("leak-476-7", dataLeAk476);
			android.util.Log.d("leak-481-7", dataLeAk481);
			android.util.Log.d("leak-483-7", dataLeAk483);
			android.util.Log.d("leak-485-7", dataLeAk485);
			android.util.Log.d("leak-490-7", dataLeAk490);
			android.util.Log.d("leak-492-7", dataLeAk492);
			android.util.Log.d("leak-494-7", dataLeAk494);
			android.util.Log.d("leak-496-7", dataLeAk496);
			android.util.Log.d("leak-498-7", dataLeAk498);
			android.util.Log.d("leak-501-7", dataLeAk501);
			android.util.Log.d("leak-503-7", dataLeAk503);
			android.util.Log.d("leak-505-7", dataLeAk505);
			android.util.Log.d("leak-507-7", dataLeAk507);
			android.util.Log.d("leak-484-2", dataLeAk484);
			android.util.Log.d("leak-489-2", dataLeAk489);
			android.util.Log.d("leak-491-2", dataLeAk491);

        }
    }

    private class SearchQueryTextListener implements SearchView.OnQueryTextListener {
        final String dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk497 = "";

		String dataLeAk495 = "";

		String dataLeAk493 = "";

		private String currentText;

        @Override
        public boolean onQueryTextSubmit(String query) {
            dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-8", dataLeAk473);
			android.util.Log.d("leak-474-8", dataLeAk474);
			android.util.Log.d("leak-476-8", dataLeAk476);
			android.util.Log.d("leak-481-8", dataLeAk481);
			android.util.Log.d("leak-483-8", dataLeAk483);
			android.util.Log.d("leak-485-8", dataLeAk485);
			android.util.Log.d("leak-490-8", dataLeAk490);
			android.util.Log.d("leak-492-8", dataLeAk492);
			android.util.Log.d("leak-494-8", dataLeAk494);
			android.util.Log.d("leak-496-8", dataLeAk496);
			android.util.Log.d("leak-498-8", dataLeAk498);
			android.util.Log.d("leak-501-8", dataLeAk501);
			android.util.Log.d("leak-503-8", dataLeAk503);
			android.util.Log.d("leak-505-8", dataLeAk505);
			android.util.Log.d("leak-507-8", dataLeAk507);
			android.util.Log.d("leak-493-0", dataLeAk493);
			android.util.Log.d("leak-495-0", dataLeAk495);
			android.util.Log.d("leak-497-0", dataLeAk497);
			currentText = query;
            fireLoader(true);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-9", dataLeAk473);
			android.util.Log.d("leak-474-9", dataLeAk474);
			android.util.Log.d("leak-476-9", dataLeAk476);
			android.util.Log.d("leak-481-9", dataLeAk481);
			android.util.Log.d("leak-483-9", dataLeAk483);
			android.util.Log.d("leak-485-9", dataLeAk485);
			android.util.Log.d("leak-490-9", dataLeAk490);
			android.util.Log.d("leak-492-9", dataLeAk492);
			android.util.Log.d("leak-494-9", dataLeAk494);
			android.util.Log.d("leak-496-9", dataLeAk496);
			android.util.Log.d("leak-498-9", dataLeAk498);
			android.util.Log.d("leak-501-9", dataLeAk501);
			android.util.Log.d("leak-503-9", dataLeAk503);
			android.util.Log.d("leak-505-9", dataLeAk505);
			android.util.Log.d("leak-507-9", dataLeAk507);
			android.util.Log.d("leak-493-1", dataLeAk493);
			android.util.Log.d("leak-495-1", dataLeAk495);
			android.util.Log.d("leak-497-1", dataLeAk497);
			if(TextUtils.isEmpty(newText)) {
                currentText = newText;
                mUiHandler.removeCallbacksAndMessages(null);
                return true;
            }

            if(TextUtils.equals(currentText, newText))
                return false;

            currentText = newText;
            fireLoader(false);
            return true;
        }

        // make a delay for not spamming requests to server so fast
        private void fireLoader(boolean immediate) {
            dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-10", dataLeAk473);
			android.util.Log.d("leak-474-10", dataLeAk474);
			android.util.Log.d("leak-476-10", dataLeAk476);
			android.util.Log.d("leak-481-10", dataLeAk481);
			android.util.Log.d("leak-483-10", dataLeAk483);
			android.util.Log.d("leak-485-10", dataLeAk485);
			android.util.Log.d("leak-490-10", dataLeAk490);
			android.util.Log.d("leak-492-10", dataLeAk492);
			android.util.Log.d("leak-494-10", dataLeAk494);
			android.util.Log.d("leak-496-10", dataLeAk496);
			android.util.Log.d("leak-498-10", dataLeAk498);
			android.util.Log.d("leak-501-10", dataLeAk501);
			android.util.Log.d("leak-503-10", dataLeAk503);
			android.util.Log.d("leak-505-10", dataLeAk505);
			android.util.Log.d("leak-507-10", dataLeAk507);
			android.util.Log.d("leak-493-2", dataLeAk493);
			android.util.Log.d("leak-495-2", dataLeAk495);
			android.util.Log.d("leak-497-2", dataLeAk497);
			mUiHandler.removeCallbacksAndMessages(null);
            mUiHandler.postDelayed(new Runnable() {
                String dataLeAk499 = "";

				@Override
                public void run() {
                    dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-525-0", dataLeAk525);
					android.util.Log.d("leak-524-0", dataLeAk524);
					android.util.Log.d("leak-499-0", dataLeAk499);
					mSearchImage.setImageResource(Utils.getThemedResource(getActivity(), R.attr.loading_icon_resource));
                    if(!currentText.contains(" ")) { // this is a single command query, just search
                        getLoaderManager().getLoader(MainPagerActivity.SEARCH_COMMAND_LOADER).onContentChanged();
                    } else { // this is oneliner with arguments/other commands
                        getLoaderManager().getLoader(MainPagerActivity.SEARCH_ONELINER_LOADER).onContentChanged();
                    }
                }
            }, immediate ? 0 : 800);

        }
    }

    private class OnelinerArrayAdapter extends ArrayAdapter<String> {

        String dataLeAk502 = "";

		String dataLeAk500 = "";

		public OnelinerArrayAdapter(String[] objects) {
            super(getActivity(), R.layout.search_list_item, R.id.command_name_label, objects);
			dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-11", dataLeAk473);
			android.util.Log.d("leak-474-11", dataLeAk474);
			android.util.Log.d("leak-476-11", dataLeAk476);
			android.util.Log.d("leak-481-11", dataLeAk481);
			android.util.Log.d("leak-483-11", dataLeAk483);
			android.util.Log.d("leak-485-11", dataLeAk485);
			android.util.Log.d("leak-490-11", dataLeAk490);
			android.util.Log.d("leak-492-11", dataLeAk492);
			android.util.Log.d("leak-494-11", dataLeAk494);
			android.util.Log.d("leak-496-11", dataLeAk496);
			android.util.Log.d("leak-498-11", dataLeAk498);
			android.util.Log.d("leak-501-11", dataLeAk501);
			android.util.Log.d("leak-503-11", dataLeAk503);
			android.util.Log.d("leak-505-11", dataLeAk505);
			android.util.Log.d("leak-507-11", dataLeAk507);
			android.util.Log.d("leak-500-0", dataLeAk500);
			android.util.Log.d("leak-502-0", dataLeAk502);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-12", dataLeAk473);
			android.util.Log.d("leak-474-12", dataLeAk474);
			android.util.Log.d("leak-476-12", dataLeAk476);
			android.util.Log.d("leak-481-12", dataLeAk481);
			android.util.Log.d("leak-483-12", dataLeAk483);
			android.util.Log.d("leak-485-12", dataLeAk485);
			android.util.Log.d("leak-490-12", dataLeAk490);
			android.util.Log.d("leak-492-12", dataLeAk492);
			android.util.Log.d("leak-494-12", dataLeAk494);
			android.util.Log.d("leak-496-12", dataLeAk496);
			android.util.Log.d("leak-498-12", dataLeAk498);
			android.util.Log.d("leak-501-12", dataLeAk501);
			android.util.Log.d("leak-503-12", dataLeAk503);
			android.util.Log.d("leak-505-12", dataLeAk505);
			android.util.Log.d("leak-507-12", dataLeAk507);
			android.util.Log.d("leak-500-1", dataLeAk500);
			android.util.Log.d("leak-502-1", dataLeAk502);
			final View root = super.getView(position, convertView, parent);
            String paragraph = getItem(position);

            TextView command = (TextView) root.findViewById(R.id.command_name_label);
            command.setVisibility(View.GONE);

            TextView chapter = (TextView) root.findViewById(R.id.command_chapter_label);
            chapter.setText(paragraph);

            final ImageView moreActions = (ImageView) root.findViewById(R.id.popup_menu);
            moreActions.setVisibility(View.GONE);

            return root;
        }

    }

    private class SearchResultArrayAdapter extends ArrayAdapter<SearchResult> {

        final String dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk506 = "";

		String dataLeAk504 = "";

		private Map<SearchResult, String> cachedDescs = new HashMap<>(5);

        public SearchResultArrayAdapter(SearchResultList data) {
            super(getActivity(), R.layout.search_list_item, R.id.command_name_label, data.getResults());
			dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-13", dataLeAk473);
			android.util.Log.d("leak-474-13", dataLeAk474);
			android.util.Log.d("leak-476-13", dataLeAk476);
			android.util.Log.d("leak-481-13", dataLeAk481);
			android.util.Log.d("leak-483-13", dataLeAk483);
			android.util.Log.d("leak-485-13", dataLeAk485);
			android.util.Log.d("leak-490-13", dataLeAk490);
			android.util.Log.d("leak-492-13", dataLeAk492);
			android.util.Log.d("leak-494-13", dataLeAk494);
			android.util.Log.d("leak-496-13", dataLeAk496);
			android.util.Log.d("leak-498-13", dataLeAk498);
			android.util.Log.d("leak-501-13", dataLeAk501);
			android.util.Log.d("leak-503-13", dataLeAk503);
			android.util.Log.d("leak-505-13", dataLeAk505);
			android.util.Log.d("leak-507-13", dataLeAk507);
			android.util.Log.d("leak-504-0", dataLeAk504);
			android.util.Log.d("leak-506-0", dataLeAk506);
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-473-14", dataLeAk473);
			android.util.Log.d("leak-474-14", dataLeAk474);
			android.util.Log.d("leak-476-14", dataLeAk476);
			android.util.Log.d("leak-481-14", dataLeAk481);
			android.util.Log.d("leak-483-14", dataLeAk483);
			android.util.Log.d("leak-485-14", dataLeAk485);
			android.util.Log.d("leak-490-14", dataLeAk490);
			android.util.Log.d("leak-492-14", dataLeAk492);
			android.util.Log.d("leak-494-14", dataLeAk494);
			android.util.Log.d("leak-496-14", dataLeAk496);
			android.util.Log.d("leak-498-14", dataLeAk498);
			android.util.Log.d("leak-501-14", dataLeAk501);
			android.util.Log.d("leak-503-14", dataLeAk503);
			android.util.Log.d("leak-505-14", dataLeAk505);
			android.util.Log.d("leak-507-14", dataLeAk507);
			android.util.Log.d("leak-504-1", dataLeAk504);
			android.util.Log.d("leak-506-1", dataLeAk506);
			View root = super.getView(position, convertView, parent);
            final SearchResult searchRes = getItem(position);

            String chapterName = cachedChapters.get(searchRes.getSection());

            TextView command = (TextView) root.findViewById(R.id.command_name_label);
            command.setText(searchRes.getName());
            TextView chapter = (TextView) root.findViewById(R.id.command_chapter_label);
            chapter.setText(chapterName);
            final TextView description = (TextView) root.findViewById(R.id.description_text_web);
            description.setBackgroundColor(0);
            description.setVisibility(cachedDescs.containsKey(searchRes) ? View.VISIBLE : View.GONE);
            if(cachedDescs.containsKey(searchRes)) {
                description.setText(cachedDescs.get(searchRes));
            }

            // download a description on question mark click
            final ImageView descriptionRequest = (ImageView) root.findViewById(R.id.popup_menu);
            descriptionRequest.setOnClickListener(new View.OnClickListener() {
                final String dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				String dataLeAk508 = "";

				@Override
                public void onClick(final View v) {
                    dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-527-0", dataLeAk527);
					android.util.Log.d("leak-526-0", dataLeAk526);
					android.util.Log.d("leak-508-0", dataLeAk508);
					PopupMenu pm = new PopupMenu(getActivity(), v);
                    pm.inflate(R.menu.search_item_popup);
                    if (cachedDescs.containsKey(searchRes)) { // hide description setting if we already loaded it
                        pm.getMenu().findItem(R.id.load_description_popup_menu_item).setVisible(false);
                    }

                    pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        String dataLeAk509 = "";

						@Override
                        public boolean onMenuItemClick(MenuItem item) {
                            dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-530-0", dataLeAk530);
							android.util.Log.d("leak-529-0", dataLeAk529);
							android.util.Log.d("leak-528-0", dataLeAk528);
							android.util.Log.d("leak-509-0", dataLeAk509);
							switch (item.getItemId()) {
                                case R.id.load_description_popup_menu_item:
                                    description.setVisibility(View.VISIBLE);
                                    description.setText(searchRes.getDescription());
                                    cachedDescs.put(searchRes, searchRes.getDescription());
                                    return true;
                                case R.id.share_link_popup_menu_item:
                                    Intent sendIntent = new Intent(Intent.ACTION_SEND);
                                    sendIntent.setType("text/plain");
                                    sendIntent.putExtra(Intent.EXTRA_TITLE, searchRes.getName());
                                    sendIntent.putExtra(Intent.EXTRA_TEXT, searchRes.getUrl());
                                    startActivity(Intent.createChooser(sendIntent, getString(R.string.share_link)));
                                    return true;
                                case R.id.copy_link_popup_menu_item:
                                    ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                    Toast.makeText(getActivity().getApplicationContext(), getString(R.string.copied) + " " + searchRes.getUrl(), Toast.LENGTH_SHORT).show();
                                    clipboard.setPrimaryClip(ClipData.newPlainText(searchRes.getName(), searchRes.getUrl()));
                                    return true;
                            }
                            return false;
                        }
                    });
                    pm.show();
                }
            });

            return root;
        }
    }

}
