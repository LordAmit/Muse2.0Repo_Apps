package com.adonai.manman;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Browser;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.adonai.manman.database.DbProvider;
import com.adonai.manman.entities.ManPage;
import com.adonai.manman.misc.AbstractNetworkAsyncLoader;
import com.adonai.manman.parser.Man2Html;
import com.adonai.manman.views.PassiveSlidingPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static com.adonai.manman.Utils.FONT_PREF_KEY;

/**
 * Dialog fragment for showing web page with man content
 * Retrieves info from DB (if cached) or network (if not)
 *
 * @see com.adonai.manman.entities.ManPage
 * @author Oleg Chernovskiy
 */
public class ManPageDialogFragment extends Fragment {
    String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);

	private static final String USER_LEARNED_SLIDER = "user.learned.slider";

    private static final String PARAM_ADDRESS = "param.address";
    private static final String PARAM_NAME = "param.name";

    private SharedPreferences mPrefs;
    private SharedPreferences.OnSharedPreferenceChangeListener mPrefChangeListener;

    private RetrieveManPageCallback manPageCallback = new RetrieveManPageCallback();
    private File mLocalArchive;
    private String mAddressUrl;
    private String mCommandName;

    private LinearLayout mLinkContainer;
    private PassiveSlidingPane mSlider;
    private ViewFlipper mFlipper;
    private WebView mContent;

    private LinearLayout mSearchContainer;
    private EditText mSearchEdit;
    private ImageView mCloseSearchBar;
    private ImageView mFindNext;
    private ImageView mFindPrevious;

    @NonNull
    public static ManPageDialogFragment newInstance(@NonNull String commandName, @NonNull String address) {
        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk43 = android.util.Log.d("leak-43", dataLeAk43);
		ManPageDialogFragment fragment = new ManPageDialogFragment();
        Bundle args = new Bundle();
        args.putString(PARAM_ADDRESS, address);
        args.putString(PARAM_NAME, commandName);
        fragment.setArguments(args);
        return fragment;
    }

    public ManPageDialogFragment() {
		String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk44 = android.util.Log.d("leak-44", dataLeAk44);
        // mandatory empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk45 = android.util.Log.d("leak-45", dataLeAk45);
        if(getArguments() != null) {
            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);
			mAddressUrl = getArguments().getString(PARAM_ADDRESS);
            mCommandName = getArguments().getString(PARAM_NAME);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
		setHasOptionsMenu(true);

        mLocalArchive = new File(getActivity().getCacheDir(), "manpages.zip");
        mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        // making strong reference as requested by registerOnSharedPreferenceChangeListener call
        mPrefChangeListener = new FontChangeListener();
        mPrefs.registerOnSharedPreferenceChangeListener(mPrefChangeListener);

        View root = inflater.inflate(R.layout.fragment_man_page_show, container, false);
        mLinkContainer = (LinearLayout) root.findViewById(R.id.link_list);
        mFlipper = (ViewFlipper) root.findViewById(R.id.flipper);
        mContent = (WebView) root.findViewById(R.id.man_content_web);
        mContent.setWebViewClient(new ManPageChromeClient());
        mContent.getSettings().setJavaScriptEnabled(true);
        mContent.getSettings().setMinimumFontSize(getFontFromProperties());

        mSlider = (PassiveSlidingPane) root.findViewById(R.id.sliding_pane);
        mSlider.setTrackedView(mContent);

        // search-specific
        mSearchContainer = (LinearLayout) root.findViewById(R.id.search_bar_layout);
        mSearchEdit = (EditText) mSearchContainer.findViewById(R.id.search_edit);
        mCloseSearchBar = (ImageView) mSearchContainer.findViewById(R.id.close_search_bar);
        mFindNext = (ImageView) mSearchContainer.findViewById(R.id.find_next_occurrence);
        mFindPrevious = (ImageView) mSearchContainer.findViewById(R.id.find_previous_occurrence);

        mCloseSearchBar.setOnClickListener(new SearchBarCloser());
        mSearchEdit.addTextChangedListener(new SearchExecutor());
        mFindNext.setOnClickListener(new SearchFurtherExecutor(true));
        mFindPrevious.setOnClickListener(new SearchFurtherExecutor(false));

        // Lollipop blocks mixed content but we should load CSS from filesystem
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
			mContent.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        getLoaderManager().initLoader(MainPagerActivity.MAN_PAGE_RETRIEVER_LOADER, null, manPageCallback);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
        // hide keyboard on fragment show, window token is hopefully present at this moment
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mContent.getWindowToken(), 0);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
		String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
        inflater.inflate(R.menu.man_page_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
		switch (item.getItemId()) {
            case R.id.show_search_bar:
                toggleSearchBar(View.VISIBLE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleSearchBar(int visibility) {
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
		mSearchContainer.setVisibility(visibility);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (visibility == View.VISIBLE) {
            String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
			mSearchEdit.requestFocus();
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
        } else {
            String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
			imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }
    }

    /**
     * Class for creating a loader that performs async loading of man page from www.mankier.com
     * On finish passes data to web content and makes it active
     * On fail dismisses parent dialog
     *
     */
    private class RetrieveManPageCallback implements LoaderManager.LoaderCallbacks<ManPage> {
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);

		@NonNull
        @Override
        public Loader<ManPage> onCreateLoader(int id, Bundle args) {
            String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
			return new AbstractNetworkAsyncLoader<ManPage>(getActivity()) {

                String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);

				@Nullable
                @Override
                public ManPage loadInBackground() {
                    String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
					// handle special case when it's a local file
                    if(mAddressUrl.startsWith("/")) { // TODO: rewrite with URI
                        String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
						try {
                            String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
							File input = new File(mAddressUrl);
                            String charset = Utils.detectEncodingOfArchive(input);
                            FileInputStream fis = new FileInputStream(input);
                            GZIPInputStream gis = new GZIPInputStream(fis);
                            BufferedReader br = charset == null ? new BufferedReader(new InputStreamReader(gis)) : new BufferedReader(new InputStreamReader(gis, charset));
                            Man2Html parser = new Man2Html(br);
                            Document parsed = parser.getDoc();
                            ManPage result = new ManPage(input.getName(), "file://" + mAddressUrl);
                            result.setLinks(getLinks(parsed.select("div.man-page").first()));
                            result.setWebContent(parsed.html());
                            br.close(); // closes all the IS hierarchy
                            return result;
                        } catch (FileNotFoundException e) {
                            String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
							Log.e(Utils.MM_TAG, "File with man page was not found in local folder", e);
                            Toast.makeText(getActivity(), R.string.file_not_found, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
							Log.e(Utils.MM_TAG, "Exception while loading man page file from local folder", e);
                            Toast.makeText(getActivity(), R.string.wrong_file_format, Toast.LENGTH_SHORT).show();
                        }
                        return null; // no further querying
                    }

                    if(mAddressUrl.startsWith("local:")) { // local man archive
                        String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
						try {
                            String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
							ZipFile zip = new ZipFile(mLocalArchive);
                            ZipEntry zEntry = zip.getEntry(mAddressUrl.substring(7));
                            InputStream is =  zip.getInputStream(zEntry);
                            // can't use java's standard GZIPInputStream around zip IS because of inflating issue
                            GzipCompressorInputStream gis = new GzipCompressorInputStream(is); // manpage files are .gz
                            BufferedReader br = new BufferedReader(new InputStreamReader(gis));
                            Man2Html parser = new Man2Html(br);
                            Document parsed = parser.getDoc();
                            ManPage result = new ManPage(zEntry.getName(), mAddressUrl);
                            result.setLinks(getLinks(parsed.select("div.man-page").first()));
                            result.setWebContent(parsed.html());
                            br.close(); // closes all the IS hierarchy
                            return result;
                        } catch (IOException e) {
                            String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
							Log.e(Utils.MM_TAG, "Error while loading man page from local archive", e);
                            Toast.makeText(getActivity(), R.string.wrong_file_format, Toast.LENGTH_SHORT).show();
                        }
                    }

                    try { // query cache database for corresponding command
                        String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
						ManPage cached = DbProvider.getHelper().getManPagesDao().queryForId(mAddressUrl);
                        if(cached != null) {
                            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);
							return cached;
                        }
                    } catch (RuntimeException e) { // it's RuntimeExceptionDao, so catch runtime exceptions
                        String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
						Log.e(Utils.MM_TAG, "Exception while querying the DB", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_retrieve_error);
                    }

                    try {
                        String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
						OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(mAddressUrl).build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);
							String result = response.body().string();
                            Document root = Jsoup.parse(result, mAddressUrl);
                            Element man = root.select("div.man-page, main").first();
                            if (man == null) { // not actually a man page
                                String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
								return null;
                            }

                            String webContent = man.html();
                            TreeSet<String> linkContainer = getLinks(man);

                            // save to DB for caching
                            ManPage toCache = new ManPage(mCommandName, mAddressUrl);
                            toCache.setLinks(linkContainer);
                            toCache.setWebContent(webContent);
                            DbProvider.getHelper().getManPagesDao().createIfNotExists(toCache);
                            LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent(MainPagerActivity.DB_CHANGE_NOTIFY));

                            return toCache;
                        }
                    } catch (IOException e) {
                        String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);
						Log.e(Utils.MM_TAG, "Exception while saving cached page to DB", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return null;
                }

                // retrieve link set from manpage
                @NonNull
                private TreeSet<String> getLinks(Element man) {
                    String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
					Elements links = man.select("a[href*=#]");
                    TreeSet<String> linkContainer = new TreeSet<>();
                    for (Element link : links) {
                        String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
						if (!TextUtils.isEmpty(link.text()) && link.attr("href").contains("#" + link.text())) { // it's like <a href="http://ex.com/#a">-x</a>
                            String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
							linkContainer.add(link.text());
                        }
                    }
                    return linkContainer;
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<ManPage> loader, ManPage data) {
            String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
			if(data != null) {
                String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
				mContent.loadDataWithBaseURL(mAddressUrl, Utils.getWebWithCss(getActivity(), data.getUrl(), data.getWebContent()), "text/html", "UTF-8", null);
                mContent.setBackgroundColor(Utils.getThemedValue(getActivity(), R.attr.fill_color)); // prevent flickering
                fillLinkPane(data.getLinks());
                mFlipper.showNext();
                shakeSlider();
            } else {
                String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
				mContent.postDelayed(new Runnable() {
                    String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);

					@Override
                    public void run() {
                        String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);
						getFragmentManager().popBackStack(); // can't perform transactions from onLoadFinished
                    }
                }, 0);
            }
        }

        @Override
        public void onLoaderReset(Loader<ManPage> loader) {
			String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
            // never used
        }
    }

    private void shakeSlider() {
        String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);
		if(mLinkContainer.getChildCount() == 0) // nothing to show in the links pane
            return;

        if(mPrefs.contains(USER_LEARNED_SLIDER))
            return;

        mSlider.postDelayed(new Runnable() {
            String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);

			@Override
            public void run() {
                String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);
				mSlider.openPane();
            }
        }, 1000);
        mSlider.postDelayed(new Runnable() {
            String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);

			@Override
            public void run() {
                String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);
				mSlider.closePane();
            }
        }, 2000);
        mPrefs.edit().putBoolean(USER_LEARNED_SLIDER, true).apply();
    }

    private void fillLinkPane(Set<String> links) {
        String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
		mLinkContainer.removeAllViews();

        if(links == null || links.isEmpty())
            return;

        for (final String link : links) {
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
			// hack  for https://code.google.com/p/android/issues/detail?id=36660 - place inside of FrameLayout
            View root = LayoutInflater.from(getActivity()).inflate(R.layout.link_text_item, mLinkContainer, false);
            TextView linkLabel = (TextView) root.findViewById(R.id.link_text);
            linkLabel.setText(link);
            root.setOnClickListener(new View.OnClickListener() {
                String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);

				@Override
                public void onClick(View v) {
                    String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
					mContent.loadUrl("javascript:(function() {\n" +
                            "    var l = document.querySelector('a[href$=\"#" + link + "\"]');\n" +
                            "    var event = new MouseEvent('click', {\n" +
                            "        'view': window,\n" +
                            "        'bubbles': true,\n" +
                            "        'cancelable': true\n" +
                            "    });" +
                            "    console.log(l);\n" +
                            "    l.dispatchEvent(event);\n" +
                            "})()");
                }
            });
            mLinkContainer.addView(root);
        }
    }

    /**
     * Retrieve font size for web views from shared properties
     * @return integer representing font size or default in case incorrect number is set
     */
    private int getFontFromProperties() {
        String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
		try {
            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);
			return Integer.parseInt(mPrefs.getString(FONT_PREF_KEY, "12"));
        } catch (NumberFormatException ex) {
            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
			Toast.makeText(getActivity(), R.string.invalid_font_size_set, Toast.LENGTH_SHORT).show();
            return 12; // default webview font size
        }
    }

    /**
     * Class to load URLs inside of already active webview
     * Calls original browser intent for the URLs it can't handle
     */
    private class ManPageChromeClient extends WebViewClient {

        String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);

		@Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
			if (url.matches("https://www\\.mankier\\.com/.+/.+")) { // it's an address of the command
                String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
				mFlipper.showPrevious();
                mAddressUrl = url;
                mCommandName = url.substring(url.lastIndexOf('/') + 1);
                getLoaderManager().getLoader(MainPagerActivity.MAN_PAGE_RETRIEVER_LOADER).onContentChanged();
                return true;
            }
            return shouldOverrideUrlLoadingOld(view, url);
        }

        /**
         * Copied from WebViewContentsClientAdapter (internal android class)
         * to handle URLs in old way if it's not a man page
         */
        public boolean shouldOverrideUrlLoadingOld(WebView view, String url) {
            String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
			Intent intent;
            // Perform generic parsing of the URI to turn it into an Intent.
            try {
                String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
				intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
            } catch (URISyntaxException ex) {
                String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
				Log.w("WebViewCallback", "Bad URI " + url + ": " + ex.getMessage());
                return false;
            }
            // Sanitize the Intent, ensuring web pages can not bypass browser
            // security (only access to BROWSABLE activities).
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setComponent(null);

            // Pass the package name as application ID so that the intent from the
            // same application can be opened in the same tab.
            intent.putExtra(Browser.EXTRA_APPLICATION_ID, view.getContext().getPackageName());
            try {
                String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
				view.getContext().startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);
				Log.w("WebViewCallback", "No application can handle " + url);
                return false;
            }
            return true;
        }
    }

    /**
     * Closes the search bar
     */
    private class SearchBarCloser implements View.OnClickListener {
        String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);

		@Override
        public void onClick(View v) {
            String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
			toggleSearchBar(View.GONE);
            mContent.clearMatches();
        }
    }

    /**
     * Finds next occurrence depending on direction
     */
    private class SearchFurtherExecutor implements View.OnClickListener {

        String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);

		private boolean goDown;

        public SearchFurtherExecutor(boolean goDown) {
            String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
			this.goDown = goDown;
        }

        @Override
        public void onClick(View v) {
            String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
			mContent.findNext(goDown);
        }
    }

    /**
     * Executes search on string change
     */
    private class SearchExecutor implements TextWatcher {
        String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);

		@Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
			String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);

        }

        @Override
        public void afterTextChanged(Editable s) {
            String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
			mContent.findAllAsync(s.toString());
        }
    }

    private class FontChangeListener implements SharedPreferences.OnSharedPreferenceChangeListener {

        String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);

		@Override
        public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
            String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
			switch (key) {
                case FONT_PREF_KEY:
                    mContent.getSettings().setMinimumFontSize(getFontFromProperties());
                    break;
            }
        }
    }
}
