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
            String dataLeAk541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP541 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP541.put("test", new java.util.HashMap<String, String>());
			leakMaP541.get("test").put("test", dataLeAk541);
			String dataLeAkPath541 = leakMaP541.get("test").get("test");
			android.util.Log.d("leak-541", dataLeAkPath541);
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
        String dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer542 = new StringBuffer();for (char chAr542 : dataLeAk542.toCharArray()) {leakBuFFer542.append(chAr542);}String dataLeAkPath542 = leakBuFFer542.toString();
		android.util.Log.d("leak-542", dataLeAkPath542);
		ManPageSearchFragment fragment = new ManPageSearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManPageSearchFragment() {
		String dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath543;try {throw new Exception(dataLeAk543);} catch (Exception leakErRor543) {dataLeAkPath543 = leakErRor543.getMessage();}
		android.util.Log.d("leak-543", dataLeAkPath543);
        // Required empty public constructor
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay544 = new String[] {"n/a", dataLeAk544};
		String dataLeAkPath544 = leakArRay544[leakArRay544.length - 1];
		android.util.Log.d("leak-544", dataLeAkPath544);
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
            String dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP545 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP545.put("test", new java.util.HashMap<String, String>());
			leakMaP545.get("test").put("test", dataLeAk545);
			String dataLeAkPath545 = leakMaP545.get("test").get("test");
			android.util.Log.d("leak-545", dataLeAkPath545);
			return new AbstractNetworkAsyncLoader<SearchResultList>(getActivity()) {

                @Override
                protected void onStartLoading() {
                    String dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer546 = new StringBuffer();for (char chAr546 : dataLeAk546.toCharArray()) {leakBuFFer546.append(chAr546);}String dataLeAkPath546 = leakBuFFer546.toString();
					android.util.Log.d("leak-546", dataLeAkPath546);
					if(!TextUtils.isEmpty(mSearchView.getQuery().toString())) {
                        super.onStartLoading();
						String dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath547;try {throw new Exception(dataLeAk547);} catch (Exception leakErRor547) {dataLeAkPath547 = leakErRor547.getMessage();}
						android.util.Log.d("leak-547", dataLeAkPath547);
                    }
                }

                @Override
                public SearchResultList loadInBackground() {
                    String dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay548 = new String[] {"n/a", dataLeAk548};
					String dataLeAkPath548 = leakArRay548[leakArRay548.length - 1];
					android.util.Log.d("leak-548", dataLeAkPath548);
					try {
                        String dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP549 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP549.put("test", new java.util.HashMap<String, String>());
						leakMaP549.get("test").put("test", dataLeAk549);
						String dataLeAkPath549 = leakMaP549.get("test").get("test");
						android.util.Log.d("leak-549", dataLeAkPath549);
						String address = URLEncoder.encode(mSearchView.getQuery().toString(), "UTF-8");
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(SEARCH_COMMAND_PREFIX + address).build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer550 = new StringBuffer();for (char chAr550 : dataLeAk550.toCharArray()) {leakBuFFer550.append(chAr550);}String dataLeAkPath550 = leakBuFFer550.toString();
							android.util.Log.d("leak-550", dataLeAkPath550);
							String result = response.body().string();
                            return mJsonConverter.fromJson(result, SearchResultList.class);
                        }
                    } catch (IOException e) {
                        String dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath551;try {throw new Exception(dataLeAk551);} catch (Exception leakErRor551) {dataLeAkPath551 = leakErRor551.getMessage();}
						android.util.Log.d("leak-551", dataLeAkPath551);
						Log.e(Utils.MM_TAG, "Error while loading search of commands from network", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return null;
                }

                @Override
                public void deliverResult(SearchResultList data) {
                    mSearchImage.setImageDrawable(mSearchDefaultDrawable); // finish animation
					String dataLeAk552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay552 = new String[] {"n/a", dataLeAk552};
					String dataLeAkPath552 = leakArRay552[leakArRay552.length - 1];
					android.util.Log.d("leak-552", dataLeAkPath552);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<SearchResultList> loader, SearchResultList data) {
            String dataLeAk553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP553 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP553.put("test", new java.util.HashMap<String, String>());
			leakMaP553.get("test").put("test", dataLeAk553);
			String dataLeAkPath553 = leakMaP553.get("test").get("test");
			android.util.Log.d("leak-553", dataLeAkPath553);
			if(data != null && data.getResults() != null) {
                String dataLeAk554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer554 = new StringBuffer();for (char chAr554 : dataLeAk554.toCharArray()) {leakBuFFer554.append(chAr554);}String dataLeAkPath554 = leakBuFFer554.toString();
				android.util.Log.d("leak-554", dataLeAkPath554);
				ArrayAdapter<SearchResult> adapter = new SearchResultArrayAdapter(data);
                mSearchList.setAdapter(adapter);
                mSearchList.setOnItemClickListener(mCommandClickListener);
            }
        }

        @Override
        public void onLoaderReset(Loader<SearchResultList> loader) {
			String dataLeAk555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath555;try {throw new Exception(dataLeAk555);} catch (Exception leakErRor555) {dataLeAkPath555 = leakErRor555.getMessage();}
			android.util.Log.d("leak-555", dataLeAkPath555);
            // no need to clear data
        }

    }

    private class SearchOneLinerLoaderCallback implements LoaderManager.LoaderCallbacks<String> {
        @Override
        public Loader<String> onCreateLoader(int id, final Bundle args) {
            String dataLeAk556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay556 = new String[] {"n/a", dataLeAk556};
			String dataLeAkPath556 = leakArRay556[leakArRay556.length - 1];
			android.util.Log.d("leak-556", dataLeAkPath556);
			return new AbstractNetworkAsyncLoader<String>(getActivity()) {

                @Override
                protected void onStartLoading() {
                    String dataLeAk557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP557 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP557.put("test", new java.util.HashMap<String, String>());
					leakMaP557.get("test").put("test", dataLeAk557);
					String dataLeAkPath557 = leakMaP557.get("test").get("test");
					android.util.Log.d("leak-557", dataLeAkPath557);
					String query = mSearchView.getQuery().toString();
                    if(!TextUtils.isEmpty(query) && query.contains(" ")) {
                        super.onStartLoading();
						String dataLeAk558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer558 = new StringBuffer();for (char chAr558 : dataLeAk558.toCharArray()) {leakBuFFer558.append(chAr558);}String dataLeAkPath558 = leakBuFFer558.toString();
						android.util.Log.d("leak-558", dataLeAkPath558);
                    }
                }

                @Override
                public String loadInBackground() {
                    String dataLeAk559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath559;try {throw new Exception(dataLeAk559);} catch (Exception leakErRor559) {dataLeAkPath559 = leakErRor559.getMessage();}
					android.util.Log.d("leak-559", dataLeAkPath559);
					try {
                        String dataLeAk560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay560 = new String[] {"n/a", dataLeAk560};
						String dataLeAkPath560 = leakArRay560[leakArRay560.length - 1];
						android.util.Log.d("leak-560", dataLeAkPath560);
						String address = URLEncoder.encode(mSearchView.getQuery().toString(), "UTF-8");
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(SEARCH_ONE_LINER_PREFIX + address).build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP561 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP561.put("test", new java.util.HashMap<String, String>());
							leakMaP561.get("test").put("test", dataLeAk561);
							String dataLeAkPath561 = leakMaP561.get("test").get("test");
							android.util.Log.d("leak-561", dataLeAkPath561);
							return response.body().string();
                        }
                    } catch (IOException e) {
                        String dataLeAk562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer562 = new StringBuffer();for (char chAr562 : dataLeAk562.toCharArray()) {leakBuFFer562.append(chAr562);}String dataLeAkPath562 = leakBuFFer562.toString();
						android.util.Log.d("leak-562", dataLeAkPath562);
						Log.e(Utils.MM_TAG, "Error while retrieving one-liner from network", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return null;
                }

                @Override
                public void deliverResult(String data) {
                    mSearchImage.setImageDrawable(mSearchDefaultDrawable); // finish animation
					String dataLeAk563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath563;try {throw new Exception(dataLeAk563);} catch (Exception leakErRor563) {dataLeAkPath563 = leakErRor563.getMessage();}
					android.util.Log.d("leak-563", dataLeAkPath563);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<String> loader, String data) {
            String dataLeAk564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay564 = new String[] {"n/a", dataLeAk564};
			String dataLeAkPath564 = leakArRay564[leakArRay564.length - 1];
			android.util.Log.d("leak-564", dataLeAkPath564);
			if(!TextUtils.isEmpty(data)) {
                String dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP565 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP565.put("test", new java.util.HashMap<String, String>());
				leakMaP565.get("test").put("test", dataLeAk565);
				String dataLeAkPath565 = leakMaP565.get("test").get("test");
				android.util.Log.d("leak-565", dataLeAkPath565);
				String[] elements = data.split("\\n\\n");
                mSearchList.setAdapter(new OnelinerArrayAdapter(elements));
                mSearchList.setOnItemClickListener(null);
            }
        }

        @Override
        public void onLoaderReset(Loader<String> loader) {
			String dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer566 = new StringBuffer();for (char chAr566 : dataLeAk566.toCharArray()) {leakBuFFer566.append(chAr566);}String dataLeAkPath566 = leakBuFFer566.toString();
			android.util.Log.d("leak-566", dataLeAkPath566);

        }
    }

    private class SearchQueryTextListener implements SearchView.OnQueryTextListener {
        private String currentText;

        @Override
        public boolean onQueryTextSubmit(String query) {
            String dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath567;try {throw new Exception(dataLeAk567);} catch (Exception leakErRor567) {dataLeAkPath567 = leakErRor567.getMessage();}
			android.util.Log.d("leak-567", dataLeAkPath567);
			currentText = query;
            fireLoader(true);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            String dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay568 = new String[] {"n/a", dataLeAk568};
			String dataLeAkPath568 = leakArRay568[leakArRay568.length - 1];
			android.util.Log.d("leak-568", dataLeAkPath568);
			if(TextUtils.isEmpty(newText)) {
                String dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP569 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP569.put("test", new java.util.HashMap<String, String>());
				leakMaP569.get("test").put("test", dataLeAk569);
				String dataLeAkPath569 = leakMaP569.get("test").get("test");
				android.util.Log.d("leak-569", dataLeAkPath569);
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
            String dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer570 = new StringBuffer();for (char chAr570 : dataLeAk570.toCharArray()) {leakBuFFer570.append(chAr570);}String dataLeAkPath570 = leakBuFFer570.toString();
			android.util.Log.d("leak-570", dataLeAkPath570);
			mUiHandler.removeCallbacksAndMessages(null);
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    String dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath571;try {throw new Exception(dataLeAk571);} catch (Exception leakErRor571) {dataLeAkPath571 = leakErRor571.getMessage();}
					android.util.Log.d("leak-571", dataLeAkPath571);
					mSearchImage.setImageResource(Utils.getThemedResource(getActivity(), R.attr.loading_icon_resource));
                    if(!currentText.contains(" ")) { // this is a single command query, just search
                        String dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay572 = new String[] {"n/a", dataLeAk572};
						String dataLeAkPath572 = leakArRay572[leakArRay572.length - 1];
						android.util.Log.d("leak-572", dataLeAkPath572);
						getLoaderManager().getLoader(MainPagerActivity.SEARCH_COMMAND_LOADER).onContentChanged();
                    } else { // this is oneliner with arguments/other commands
                        String dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP573 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP573.put("test", new java.util.HashMap<String, String>());
						leakMaP573.get("test").put("test", dataLeAk573);
						String dataLeAkPath573 = leakMaP573.get("test").get("test");
						android.util.Log.d("leak-573", dataLeAkPath573);
						getLoaderManager().getLoader(MainPagerActivity.SEARCH_ONELINER_LOADER).onContentChanged();
                    }
                }
            }, immediate ? 0 : 800);

        }
    }

    private class OnelinerArrayAdapter extends ArrayAdapter<String> {

        public OnelinerArrayAdapter(String[] objects) {
            super(getActivity(), R.layout.search_list_item, R.id.command_name_label, objects);
			String dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer574 = new StringBuffer();for (char chAr574 : dataLeAk574.toCharArray()) {leakBuFFer574.append(chAr574);}String dataLeAkPath574 = leakBuFFer574.toString();
			android.util.Log.d("leak-574", dataLeAkPath574);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String dataLeAk575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath575;try {throw new Exception(dataLeAk575);} catch (Exception leakErRor575) {dataLeAkPath575 = leakErRor575.getMessage();}
			android.util.Log.d("leak-575", dataLeAkPath575);
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
			String dataLeAk576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay576 = new String[] {"n/a", dataLeAk576};
			String dataLeAkPath576 = leakArRay576[leakArRay576.length - 1];
			android.util.Log.d("leak-576", dataLeAkPath576);
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            String dataLeAk577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP577 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP577.put("test", new java.util.HashMap<String, String>());
			leakMaP577.get("test").put("test", dataLeAk577);
			String dataLeAkPath577 = leakMaP577.get("test").get("test");
			android.util.Log.d("leak-577", dataLeAkPath577);
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
                String dataLeAk578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer578 = new StringBuffer();for (char chAr578 : dataLeAk578.toCharArray()) {leakBuFFer578.append(chAr578);}String dataLeAkPath578 = leakBuFFer578.toString();
				android.util.Log.d("leak-578", dataLeAkPath578);
				description.setText(cachedDescs.get(searchRes));
            }

            // download a description on question mark click
            final ImageView descriptionRequest = (ImageView) root.findViewById(R.id.popup_menu);
            descriptionRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    String dataLeAk579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath579;try {throw new Exception(dataLeAk579);} catch (Exception leakErRor579) {dataLeAkPath579 = leakErRor579.getMessage();}
					android.util.Log.d("leak-579", dataLeAkPath579);
					PopupMenu pm = new PopupMenu(getActivity(), v);
                    pm.inflate(R.menu.search_item_popup);
                    if (cachedDescs.containsKey(searchRes)) { // hide description setting if we already loaded it
                        String dataLeAk580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay580 = new String[] {"n/a", dataLeAk580};
						String dataLeAkPath580 = leakArRay580[leakArRay580.length - 1];
						android.util.Log.d("leak-580", dataLeAkPath580);
						pm.getMenu().findItem(R.id.load_description_popup_menu_item).setVisible(false);
                    }

                    pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String dataLeAk581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP581 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP581.put("test", new java.util.HashMap<String, String>());
							leakMaP581.get("test").put("test", dataLeAk581);
							String dataLeAkPath581 = leakMaP581.get("test").get("test");
							android.util.Log.d("leak-581", dataLeAkPath581);
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
