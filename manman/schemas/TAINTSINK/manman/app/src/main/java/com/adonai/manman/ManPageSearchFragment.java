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
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
        // Required empty public constructor
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

        @Override
        public Loader<SearchResultList> onCreateLoader(int id, final Bundle args) {
            return new AbstractNetworkAsyncLoader<SearchResultList>(getActivity()) {

                @Override
                protected void onStartLoading() {
                    if(!TextUtils.isEmpty(mSearchView.getQuery().toString())) {
                        super.onStartLoading();
                    }
                }

                @Override
                public SearchResultList loadInBackground() {
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
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<SearchResultList> loader, SearchResultList data) {
            if(data != null && data.getResults() != null) {
                ArrayAdapter<SearchResult> adapter = new SearchResultArrayAdapter(data);
                mSearchList.setAdapter(adapter);
                mSearchList.setOnItemClickListener(mCommandClickListener);
            }
        }

        @Override
        public void onLoaderReset(Loader<SearchResultList> loader) {
            // no need to clear data
        }

    }

    private class SearchOneLinerLoaderCallback implements LoaderManager.LoaderCallbacks<String> {
        @Override
        public Loader<String> onCreateLoader(int id, final Bundle args) {
            return new AbstractNetworkAsyncLoader<String>(getActivity()) {

                @Override
                protected void onStartLoading() {
                    String query = mSearchView.getQuery().toString();
                    if(!TextUtils.isEmpty(query) && query.contains(" ")) {
                        super.onStartLoading();
                    }
                }

                @Override
                public String loadInBackground() {
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
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<String> loader, String data) {
            if(!TextUtils.isEmpty(data)) {
                String[] elements = data.split("\\n\\n");
                mSearchList.setAdapter(new OnelinerArrayAdapter(elements));
                mSearchList.setOnItemClickListener(null);
            }
        }

        @Override
        public void onLoaderReset(Loader<String> loader) {

        }
    }

    private class SearchQueryTextListener implements SearchView.OnQueryTextListener {
        private String currentText;

        @Override
        public boolean onQueryTextSubmit(String query) {
            currentText = query;
            fireLoader(true);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
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
            mUiHandler.removeCallbacksAndMessages(null);
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
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

        public OnelinerArrayAdapter(String[] objects) {
            super(getActivity(), R.layout.search_list_item, R.id.command_name_label, objects);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
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

        private Map<SearchResult, String> cachedDescs = new HashMap<>(5);

        public SearchResultArrayAdapter(SearchResultList data) {
            super(getActivity(), R.layout.search_list_item, R.id.command_name_label, data.getResults());
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
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
                @Override
                public void onClick(final View v) {
                    PopupMenu pm = new PopupMenu(getActivity(), v);
                    pm.inflate(R.menu.search_item_popup);
                    if (cachedDescs.containsKey(searchRes)) { // hide description setting if we already loaded it
                        pm.getMenu().findItem(R.id.load_description_popup_menu_item).setVisible(false);
                    }

                    pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
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
