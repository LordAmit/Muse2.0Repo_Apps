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

    String dataLeAk640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk640 = android.util.Log.d("leak-640", dataLeAk640);

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
        String dataLeAk641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk641 = android.util.Log.d("leak-641", dataLeAk641);

		@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String dataLeAk642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk642 = android.util.Log.d("leak-642", dataLeAk642);
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
        String dataLeAk643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk643 = android.util.Log.d("leak-643", dataLeAk643);
		ManPageSearchFragment fragment = new ManPageSearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManPageSearchFragment() {
		String dataLeAk644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk644 = android.util.Log.d("leak-644", dataLeAk644);
        // Required empty public constructor
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk645 = android.util.Log.d("leak-645", dataLeAk645);
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

        String dataLeAk646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk646 = android.util.Log.d("leak-646", dataLeAk646);

		@Override
        public Loader<SearchResultList> onCreateLoader(int id, final Bundle args) {
            String dataLeAk647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk647 = android.util.Log.d("leak-647", dataLeAk647);
			return new AbstractNetworkAsyncLoader<SearchResultList>(getActivity()) {

                String dataLeAk648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk648 = android.util.Log.d("leak-648", dataLeAk648);

				@Override
                protected void onStartLoading() {
                    String dataLeAk649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk649 = android.util.Log.d("leak-649", dataLeAk649);
					if(!TextUtils.isEmpty(mSearchView.getQuery().toString())) {
                        super.onStartLoading();
						String dataLeAk650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk650 = android.util.Log.d("leak-650", dataLeAk650);
                    }
                }

                @Override
                public SearchResultList loadInBackground() {
                    String dataLeAk651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk651 = android.util.Log.d("leak-651", dataLeAk651);
					try {
                        String dataLeAk652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk652 = android.util.Log.d("leak-652", dataLeAk652);
						String address = URLEncoder.encode(mSearchView.getQuery().toString(), "UTF-8");
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(SEARCH_COMMAND_PREFIX + address).build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk653 = android.util.Log.d("leak-653", dataLeAk653);
							String result = response.body().string();
                            return mJsonConverter.fromJson(result, SearchResultList.class);
                        }
                    } catch (IOException e) {
                        String dataLeAk654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk654 = android.util.Log.d("leak-654", dataLeAk654);
						Log.e(Utils.MM_TAG, "Error while loading search of commands from network", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return null;
                }

                @Override
                public void deliverResult(SearchResultList data) {
                    mSearchImage.setImageDrawable(mSearchDefaultDrawable); // finish animation
					String dataLeAk655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk655 = android.util.Log.d("leak-655", dataLeAk655);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<SearchResultList> loader, SearchResultList data) {
            String dataLeAk656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk656 = android.util.Log.d("leak-656", dataLeAk656);
			if(data != null && data.getResults() != null) {
                String dataLeAk657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk657 = android.util.Log.d("leak-657", dataLeAk657);
				ArrayAdapter<SearchResult> adapter = new SearchResultArrayAdapter(data);
                mSearchList.setAdapter(adapter);
                mSearchList.setOnItemClickListener(mCommandClickListener);
            }
        }

        @Override
        public void onLoaderReset(Loader<SearchResultList> loader) {
			String dataLeAk658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk658 = android.util.Log.d("leak-658", dataLeAk658);
            // no need to clear data
        }

    }

    private class SearchOneLinerLoaderCallback implements LoaderManager.LoaderCallbacks<String> {
        String dataLeAk659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk659 = android.util.Log.d("leak-659", dataLeAk659);

		@Override
        public Loader<String> onCreateLoader(int id, final Bundle args) {
            String dataLeAk660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk660 = android.util.Log.d("leak-660", dataLeAk660);
			return new AbstractNetworkAsyncLoader<String>(getActivity()) {

                String dataLeAk661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk661 = android.util.Log.d("leak-661", dataLeAk661);

				@Override
                protected void onStartLoading() {
                    String dataLeAk662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk662 = android.util.Log.d("leak-662", dataLeAk662);
					String query = mSearchView.getQuery().toString();
                    if(!TextUtils.isEmpty(query) && query.contains(" ")) {
                        super.onStartLoading();
						String dataLeAk663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk663 = android.util.Log.d("leak-663", dataLeAk663);
                    }
                }

                @Override
                public String loadInBackground() {
                    String dataLeAk664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk664 = android.util.Log.d("leak-664", dataLeAk664);
					try {
                        String dataLeAk665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk665 = android.util.Log.d("leak-665", dataLeAk665);
						String address = URLEncoder.encode(mSearchView.getQuery().toString(), "UTF-8");
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(SEARCH_ONE_LINER_PREFIX + address).build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk666 = android.util.Log.d("leak-666", dataLeAk666);
							return response.body().string();
                        }
                    } catch (IOException e) {
                        String dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk667 = android.util.Log.d("leak-667", dataLeAk667);
						Log.e(Utils.MM_TAG, "Error while retrieving one-liner from network", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return null;
                }

                @Override
                public void deliverResult(String data) {
                    mSearchImage.setImageDrawable(mSearchDefaultDrawable); // finish animation
					String dataLeAk668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk668 = android.util.Log.d("leak-668", dataLeAk668);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<String> loader, String data) {
            String dataLeAk669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk669 = android.util.Log.d("leak-669", dataLeAk669);
			if(!TextUtils.isEmpty(data)) {
                String dataLeAk670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk670 = android.util.Log.d("leak-670", dataLeAk670);
				String[] elements = data.split("\\n\\n");
                mSearchList.setAdapter(new OnelinerArrayAdapter(elements));
                mSearchList.setOnItemClickListener(null);
            }
        }

        @Override
        public void onLoaderReset(Loader<String> loader) {
			String dataLeAk671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk671 = android.util.Log.d("leak-671", dataLeAk671);

        }
    }

    private class SearchQueryTextListener implements SearchView.OnQueryTextListener {
        String dataLeAk672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk672 = android.util.Log.d("leak-672", dataLeAk672);

		private String currentText;

        @Override
        public boolean onQueryTextSubmit(String query) {
            String dataLeAk673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk673 = android.util.Log.d("leak-673", dataLeAk673);
			currentText = query;
            fireLoader(true);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            String dataLeAk674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk674 = android.util.Log.d("leak-674", dataLeAk674);
			if(TextUtils.isEmpty(newText)) {
                String dataLeAk675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk675 = android.util.Log.d("leak-675", dataLeAk675);
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
            String dataLeAk676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk676 = android.util.Log.d("leak-676", dataLeAk676);
			mUiHandler.removeCallbacksAndMessages(null);
            mUiHandler.postDelayed(new Runnable() {
                String dataLeAk677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk677 = android.util.Log.d("leak-677", dataLeAk677);

				@Override
                public void run() {
                    String dataLeAk678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk678 = android.util.Log.d("leak-678", dataLeAk678);
					mSearchImage.setImageResource(Utils.getThemedResource(getActivity(), R.attr.loading_icon_resource));
                    if(!currentText.contains(" ")) { // this is a single command query, just search
                        String dataLeAk679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk679 = android.util.Log.d("leak-679", dataLeAk679);
						getLoaderManager().getLoader(MainPagerActivity.SEARCH_COMMAND_LOADER).onContentChanged();
                    } else { // this is oneliner with arguments/other commands
                        String dataLeAk680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk680 = android.util.Log.d("leak-680", dataLeAk680);
						getLoaderManager().getLoader(MainPagerActivity.SEARCH_ONELINER_LOADER).onContentChanged();
                    }
                }
            }, immediate ? 0 : 800);

        }
    }

    private class OnelinerArrayAdapter extends ArrayAdapter<String> {

        String dataLeAk681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk681 = android.util.Log.d("leak-681", dataLeAk681);

		public OnelinerArrayAdapter(String[] objects) {
            super(getActivity(), R.layout.search_list_item, R.id.command_name_label, objects);
			String dataLeAk682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk682 = android.util.Log.d("leak-682", dataLeAk682);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String dataLeAk683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk683 = android.util.Log.d("leak-683", dataLeAk683);
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

        String dataLeAk684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk684 = android.util.Log.d("leak-684", dataLeAk684);

		private Map<SearchResult, String> cachedDescs = new HashMap<>(5);

        public SearchResultArrayAdapter(SearchResultList data) {
            super(getActivity(), R.layout.search_list_item, R.id.command_name_label, data.getResults());
			String dataLeAk685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk685 = android.util.Log.d("leak-685", dataLeAk685);
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            String dataLeAk686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk686 = android.util.Log.d("leak-686", dataLeAk686);
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
                String dataLeAk687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk687 = android.util.Log.d("leak-687", dataLeAk687);
				description.setText(cachedDescs.get(searchRes));
            }

            // download a description on question mark click
            final ImageView descriptionRequest = (ImageView) root.findViewById(R.id.popup_menu);
            descriptionRequest.setOnClickListener(new View.OnClickListener() {
                String dataLeAk688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk688 = android.util.Log.d("leak-688", dataLeAk688);

				@Override
                public void onClick(final View v) {
                    String dataLeAk689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk689 = android.util.Log.d("leak-689", dataLeAk689);
					PopupMenu pm = new PopupMenu(getActivity(), v);
                    pm.inflate(R.menu.search_item_popup);
                    if (cachedDescs.containsKey(searchRes)) { // hide description setting if we already loaded it
                        String dataLeAk690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk690 = android.util.Log.d("leak-690", dataLeAk690);
						pm.getMenu().findItem(R.id.load_description_popup_menu_item).setVisible(false);
                    }

                    pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        String dataLeAk691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk691 = android.util.Log.d("leak-691", dataLeAk691);

						@Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String dataLeAk692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk692 = android.util.Log.d("leak-692", dataLeAk692);
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
