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
    final String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk74 = "";

	String dataLeAk72 = "";

	String dataLeAk70 = "";

	String dataLeAk68 = "";

	String dataLeAk66 = "";

	String dataLeAk64 = "";

	String dataLeAk62 = "";

	String dataLeAk60 = "";

	String dataLeAk58 = "";

	String dataLeAk56 = "";

	String dataLeAk54 = "";

	String dataLeAk51 = "";

	String dataLeAk50 = "";

	String dataLeAk47 = "";

	String dataLeAk43 = "";

	String dataLeAk41 = "";

	String dataLeAk40 = "";

	String dataLeAk39 = "";

	String dataLeAk38 = "";

	String dataLeAk37 = "";

	String dataLeAk36 = "";

	String dataLeAk35 = "";

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
        ManPageDialogFragment fragment = new ManPageDialogFragment();
        Bundle args = new Bundle();
        args.putString(PARAM_ADDRESS, address);
        args.putString(PARAM_NAME, commandName);
        fragment.setArguments(args);
        return fragment;
    }

    public ManPageDialogFragment() {
		dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // mandatory empty public constructor
		android.util.Log.d("leak-35-0", dataLeAk35);
		android.util.Log.d("leak-36-0", dataLeAk36);
		android.util.Log.d("leak-37-0", dataLeAk37);
		android.util.Log.d("leak-38-0", dataLeAk38);
		android.util.Log.d("leak-39-0", dataLeAk39);
		android.util.Log.d("leak-40-0", dataLeAk40);
		android.util.Log.d("leak-41-0", dataLeAk41);
		android.util.Log.d("leak-43-0", dataLeAk43);
		android.util.Log.d("leak-47-0", dataLeAk47);
		android.util.Log.d("leak-50-0", dataLeAk50);
		android.util.Log.d("leak-51-0", dataLeAk51);
		android.util.Log.d("leak-54-0", dataLeAk54);
		android.util.Log.d("leak-56-0", dataLeAk56);
		android.util.Log.d("leak-58-0", dataLeAk58);
		android.util.Log.d("leak-60-0", dataLeAk60);
		android.util.Log.d("leak-62-0", dataLeAk62);
		android.util.Log.d("leak-64-0", dataLeAk64);
		android.util.Log.d("leak-66-0", dataLeAk66);
		android.util.Log.d("leak-68-0", dataLeAk68);
		android.util.Log.d("leak-70-0", dataLeAk70);
		android.util.Log.d("leak-72-0", dataLeAk72);
		android.util.Log.d("leak-74-0", dataLeAk74);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-1", dataLeAk35);
		android.util.Log.d("leak-36-1", dataLeAk36);
		android.util.Log.d("leak-37-1", dataLeAk37);
		android.util.Log.d("leak-38-1", dataLeAk38);
		android.util.Log.d("leak-39-1", dataLeAk39);
		android.util.Log.d("leak-40-1", dataLeAk40);
		android.util.Log.d("leak-41-1", dataLeAk41);
		android.util.Log.d("leak-43-1", dataLeAk43);
		android.util.Log.d("leak-47-1", dataLeAk47);
		android.util.Log.d("leak-50-1", dataLeAk50);
		android.util.Log.d("leak-51-1", dataLeAk51);
		android.util.Log.d("leak-54-1", dataLeAk54);
		android.util.Log.d("leak-56-1", dataLeAk56);
		android.util.Log.d("leak-58-1", dataLeAk58);
		android.util.Log.d("leak-60-1", dataLeAk60);
		android.util.Log.d("leak-62-1", dataLeAk62);
		android.util.Log.d("leak-64-1", dataLeAk64);
		android.util.Log.d("leak-66-1", dataLeAk66);
		android.util.Log.d("leak-68-1", dataLeAk68);
		android.util.Log.d("leak-70-1", dataLeAk70);
		android.util.Log.d("leak-72-1", dataLeAk72);
		android.util.Log.d("leak-74-1", dataLeAk74);
        if(getArguments() != null) {
            mAddressUrl = getArguments().getString(PARAM_ADDRESS);
            mCommandName = getArguments().getString(PARAM_NAME);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-2", dataLeAk35);
		android.util.Log.d("leak-36-2", dataLeAk36);
		android.util.Log.d("leak-37-2", dataLeAk37);
		android.util.Log.d("leak-38-2", dataLeAk38);
		android.util.Log.d("leak-39-2", dataLeAk39);
		android.util.Log.d("leak-40-2", dataLeAk40);
		android.util.Log.d("leak-41-2", dataLeAk41);
		android.util.Log.d("leak-43-2", dataLeAk43);
		android.util.Log.d("leak-47-2", dataLeAk47);
		android.util.Log.d("leak-50-2", dataLeAk50);
		android.util.Log.d("leak-51-2", dataLeAk51);
		android.util.Log.d("leak-54-2", dataLeAk54);
		android.util.Log.d("leak-56-2", dataLeAk56);
		android.util.Log.d("leak-58-2", dataLeAk58);
		android.util.Log.d("leak-60-2", dataLeAk60);
		android.util.Log.d("leak-62-2", dataLeAk62);
		android.util.Log.d("leak-64-2", dataLeAk64);
		android.util.Log.d("leak-66-2", dataLeAk66);
		android.util.Log.d("leak-68-2", dataLeAk68);
		android.util.Log.d("leak-70-2", dataLeAk70);
		android.util.Log.d("leak-72-2", dataLeAk72);
		android.util.Log.d("leak-74-2", dataLeAk74);
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
            mContent.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        getLoaderManager().initLoader(MainPagerActivity.MAN_PAGE_RETRIEVER_LOADER, null, manPageCallback);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
		dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-3", dataLeAk35);
		android.util.Log.d("leak-36-3", dataLeAk36);
		android.util.Log.d("leak-37-3", dataLeAk37);
		android.util.Log.d("leak-38-3", dataLeAk38);
		android.util.Log.d("leak-39-3", dataLeAk39);
		android.util.Log.d("leak-40-3", dataLeAk40);
		android.util.Log.d("leak-41-3", dataLeAk41);
		android.util.Log.d("leak-43-3", dataLeAk43);
		android.util.Log.d("leak-47-3", dataLeAk47);
		android.util.Log.d("leak-50-3", dataLeAk50);
		android.util.Log.d("leak-51-3", dataLeAk51);
		android.util.Log.d("leak-54-3", dataLeAk54);
		android.util.Log.d("leak-56-3", dataLeAk56);
		android.util.Log.d("leak-58-3", dataLeAk58);
		android.util.Log.d("leak-60-3", dataLeAk60);
		android.util.Log.d("leak-62-3", dataLeAk62);
		android.util.Log.d("leak-64-3", dataLeAk64);
		android.util.Log.d("leak-66-3", dataLeAk66);
		android.util.Log.d("leak-68-3", dataLeAk68);
		android.util.Log.d("leak-70-3", dataLeAk70);
		android.util.Log.d("leak-72-3", dataLeAk72);
		android.util.Log.d("leak-74-3", dataLeAk74);
        // hide keyboard on fragment show, window token is hopefully present at this moment
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mContent.getWindowToken(), 0);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
		dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-4", dataLeAk35);
		android.util.Log.d("leak-36-4", dataLeAk36);
		android.util.Log.d("leak-37-4", dataLeAk37);
		android.util.Log.d("leak-38-4", dataLeAk38);
		android.util.Log.d("leak-39-4", dataLeAk39);
		android.util.Log.d("leak-40-4", dataLeAk40);
		android.util.Log.d("leak-41-4", dataLeAk41);
		android.util.Log.d("leak-43-4", dataLeAk43);
		android.util.Log.d("leak-47-4", dataLeAk47);
		android.util.Log.d("leak-50-4", dataLeAk50);
		android.util.Log.d("leak-51-4", dataLeAk51);
		android.util.Log.d("leak-54-4", dataLeAk54);
		android.util.Log.d("leak-56-4", dataLeAk56);
		android.util.Log.d("leak-58-4", dataLeAk58);
		android.util.Log.d("leak-60-4", dataLeAk60);
		android.util.Log.d("leak-62-4", dataLeAk62);
		android.util.Log.d("leak-64-4", dataLeAk64);
		android.util.Log.d("leak-66-4", dataLeAk66);
		android.util.Log.d("leak-68-4", dataLeAk68);
		android.util.Log.d("leak-70-4", dataLeAk70);
		android.util.Log.d("leak-72-4", dataLeAk72);
		android.util.Log.d("leak-74-4", dataLeAk74);
        inflater.inflate(R.menu.man_page_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-5", dataLeAk35);
		android.util.Log.d("leak-36-5", dataLeAk36);
		android.util.Log.d("leak-37-5", dataLeAk37);
		android.util.Log.d("leak-38-5", dataLeAk38);
		android.util.Log.d("leak-39-5", dataLeAk39);
		android.util.Log.d("leak-40-5", dataLeAk40);
		android.util.Log.d("leak-41-5", dataLeAk41);
		android.util.Log.d("leak-43-5", dataLeAk43);
		android.util.Log.d("leak-47-5", dataLeAk47);
		android.util.Log.d("leak-50-5", dataLeAk50);
		android.util.Log.d("leak-51-5", dataLeAk51);
		android.util.Log.d("leak-54-5", dataLeAk54);
		android.util.Log.d("leak-56-5", dataLeAk56);
		android.util.Log.d("leak-58-5", dataLeAk58);
		android.util.Log.d("leak-60-5", dataLeAk60);
		android.util.Log.d("leak-62-5", dataLeAk62);
		android.util.Log.d("leak-64-5", dataLeAk64);
		android.util.Log.d("leak-66-5", dataLeAk66);
		android.util.Log.d("leak-68-5", dataLeAk68);
		android.util.Log.d("leak-70-5", dataLeAk70);
		android.util.Log.d("leak-72-5", dataLeAk72);
		android.util.Log.d("leak-74-5", dataLeAk74);
		switch (item.getItemId()) {
            case R.id.show_search_bar:
                toggleSearchBar(View.VISIBLE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleSearchBar(int visibility) {
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-6", dataLeAk35);
		android.util.Log.d("leak-36-6", dataLeAk36);
		android.util.Log.d("leak-37-6", dataLeAk37);
		android.util.Log.d("leak-38-6", dataLeAk38);
		android.util.Log.d("leak-39-6", dataLeAk39);
		android.util.Log.d("leak-40-6", dataLeAk40);
		android.util.Log.d("leak-41-6", dataLeAk41);
		android.util.Log.d("leak-43-6", dataLeAk43);
		android.util.Log.d("leak-47-6", dataLeAk47);
		android.util.Log.d("leak-50-6", dataLeAk50);
		android.util.Log.d("leak-51-6", dataLeAk51);
		android.util.Log.d("leak-54-6", dataLeAk54);
		android.util.Log.d("leak-56-6", dataLeAk56);
		android.util.Log.d("leak-58-6", dataLeAk58);
		android.util.Log.d("leak-60-6", dataLeAk60);
		android.util.Log.d("leak-62-6", dataLeAk62);
		android.util.Log.d("leak-64-6", dataLeAk64);
		android.util.Log.d("leak-66-6", dataLeAk66);
		android.util.Log.d("leak-68-6", dataLeAk68);
		android.util.Log.d("leak-70-6", dataLeAk70);
		android.util.Log.d("leak-72-6", dataLeAk72);
		android.util.Log.d("leak-74-6", dataLeAk74);
		mSearchContainer.setVisibility(visibility);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (visibility == View.VISIBLE) {
            mSearchEdit.requestFocus();
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
        } else {
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
        final String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk49 = "";

		String dataLeAk46 = "";

		String dataLeAk42 = "";

		@NonNull
        @Override
        public Loader<ManPage> onCreateLoader(int id, Bundle args) {
            dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-7", dataLeAk35);
			android.util.Log.d("leak-36-7", dataLeAk36);
			android.util.Log.d("leak-37-7", dataLeAk37);
			android.util.Log.d("leak-38-7", dataLeAk38);
			android.util.Log.d("leak-39-7", dataLeAk39);
			android.util.Log.d("leak-40-7", dataLeAk40);
			android.util.Log.d("leak-41-7", dataLeAk41);
			android.util.Log.d("leak-43-7", dataLeAk43);
			android.util.Log.d("leak-47-7", dataLeAk47);
			android.util.Log.d("leak-50-7", dataLeAk50);
			android.util.Log.d("leak-51-7", dataLeAk51);
			android.util.Log.d("leak-54-7", dataLeAk54);
			android.util.Log.d("leak-56-7", dataLeAk56);
			android.util.Log.d("leak-58-7", dataLeAk58);
			android.util.Log.d("leak-60-7", dataLeAk60);
			android.util.Log.d("leak-62-7", dataLeAk62);
			android.util.Log.d("leak-64-7", dataLeAk64);
			android.util.Log.d("leak-66-7", dataLeAk66);
			android.util.Log.d("leak-68-7", dataLeAk68);
			android.util.Log.d("leak-70-7", dataLeAk70);
			android.util.Log.d("leak-72-7", dataLeAk72);
			android.util.Log.d("leak-74-7", dataLeAk74);
			android.util.Log.d("leak-42-0", dataLeAk42);
			android.util.Log.d("leak-46-0", dataLeAk46);
			android.util.Log.d("leak-49-0", dataLeAk49);
			return new AbstractNetworkAsyncLoader<ManPage>(getActivity()) {

                String dataLeAk45 = "";

				String dataLeAk44 = "";

				@Nullable
                @Override
                public ManPage loadInBackground() {
                    dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-77-0", dataLeAk77);
					android.util.Log.d("leak-76-0", dataLeAk76);
					android.util.Log.d("leak-44-0", dataLeAk44);
					android.util.Log.d("leak-45-0", dataLeAk45);
					// handle special case when it's a local file
                    if(mAddressUrl.startsWith("/")) { // TODO: rewrite with URI
                        try {
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
                            Log.e(Utils.MM_TAG, "File with man page was not found in local folder", e);
                            Toast.makeText(getActivity(), R.string.file_not_found, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            Log.e(Utils.MM_TAG, "Exception while loading man page file from local folder", e);
                            Toast.makeText(getActivity(), R.string.wrong_file_format, Toast.LENGTH_SHORT).show();
                        }
                        return null; // no further querying
                    }

                    if(mAddressUrl.startsWith("local:")) { // local man archive
                        try {
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
                            Log.e(Utils.MM_TAG, "Error while loading man page from local archive", e);
                            Toast.makeText(getActivity(), R.string.wrong_file_format, Toast.LENGTH_SHORT).show();
                        }
                    }

                    try { // query cache database for corresponding command
                        ManPage cached = DbProvider.getHelper().getManPagesDao().queryForId(mAddressUrl);
                        if(cached != null) {
                            return cached;
                        }
                    } catch (RuntimeException e) { // it's RuntimeExceptionDao, so catch runtime exceptions
                        Log.e(Utils.MM_TAG, "Exception while querying the DB", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_retrieve_error);
                    }

                    try {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(mAddressUrl).build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String result = response.body().string();
                            Document root = Jsoup.parse(result, mAddressUrl);
                            Element man = root.select("div.man-page, main").first();
                            if (man == null) { // not actually a man page
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
                        Log.e(Utils.MM_TAG, "Exception while saving cached page to DB", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return null;
                }

                // retrieve link set from manpage
                @NonNull
                private TreeSet<String> getLinks(Element man) {
                    dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-79-0", dataLeAk79);
					android.util.Log.d("leak-78-0", dataLeAk78);
					android.util.Log.d("leak-44-1", dataLeAk44);
					android.util.Log.d("leak-45-1", dataLeAk45);
					Elements links = man.select("a[href*=#]");
                    TreeSet<String> linkContainer = new TreeSet<>();
                    for (Element link : links) {
                        if (!TextUtils.isEmpty(link.text()) && link.attr("href").contains("#" + link.text())) { // it's like <a href="http://ex.com/#a">-x</a>
                            linkContainer.add(link.text());
                        }
                    }
                    return linkContainer;
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<ManPage> loader, ManPage data) {
            dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-8", dataLeAk35);
			android.util.Log.d("leak-36-8", dataLeAk36);
			android.util.Log.d("leak-37-8", dataLeAk37);
			android.util.Log.d("leak-38-8", dataLeAk38);
			android.util.Log.d("leak-39-8", dataLeAk39);
			android.util.Log.d("leak-40-8", dataLeAk40);
			android.util.Log.d("leak-41-8", dataLeAk41);
			android.util.Log.d("leak-43-8", dataLeAk43);
			android.util.Log.d("leak-47-8", dataLeAk47);
			android.util.Log.d("leak-50-8", dataLeAk50);
			android.util.Log.d("leak-51-8", dataLeAk51);
			android.util.Log.d("leak-54-8", dataLeAk54);
			android.util.Log.d("leak-56-8", dataLeAk56);
			android.util.Log.d("leak-58-8", dataLeAk58);
			android.util.Log.d("leak-60-8", dataLeAk60);
			android.util.Log.d("leak-62-8", dataLeAk62);
			android.util.Log.d("leak-64-8", dataLeAk64);
			android.util.Log.d("leak-66-8", dataLeAk66);
			android.util.Log.d("leak-68-8", dataLeAk68);
			android.util.Log.d("leak-70-8", dataLeAk70);
			android.util.Log.d("leak-72-8", dataLeAk72);
			android.util.Log.d("leak-74-8", dataLeAk74);
			android.util.Log.d("leak-42-1", dataLeAk42);
			android.util.Log.d("leak-46-1", dataLeAk46);
			android.util.Log.d("leak-49-1", dataLeAk49);
			if(data != null) {
                mContent.loadDataWithBaseURL(mAddressUrl, Utils.getWebWithCss(getActivity(), data.getUrl(), data.getWebContent()), "text/html", "UTF-8", null);
                mContent.setBackgroundColor(Utils.getThemedValue(getActivity(), R.attr.fill_color)); // prevent flickering
                fillLinkPane(data.getLinks());
                mFlipper.showNext();
                shakeSlider();
            } else {
                mContent.postDelayed(new Runnable() {
                    String dataLeAk48 = "";

					@Override
                    public void run() {
                        dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-81-0", dataLeAk81);
						android.util.Log.d("leak-80-0", dataLeAk80);
						android.util.Log.d("leak-48-0", dataLeAk48);
						getFragmentManager().popBackStack(); // can't perform transactions from onLoadFinished
                    }
                }, 0);
            }
        }

        @Override
        public void onLoaderReset(Loader<ManPage> loader) {
			dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            // never used
			android.util.Log.d("leak-35-9", dataLeAk35);
			android.util.Log.d("leak-36-9", dataLeAk36);
			android.util.Log.d("leak-37-9", dataLeAk37);
			android.util.Log.d("leak-38-9", dataLeAk38);
			android.util.Log.d("leak-39-9", dataLeAk39);
			android.util.Log.d("leak-40-9", dataLeAk40);
			android.util.Log.d("leak-41-9", dataLeAk41);
			android.util.Log.d("leak-43-9", dataLeAk43);
			android.util.Log.d("leak-47-9", dataLeAk47);
			android.util.Log.d("leak-50-9", dataLeAk50);
			android.util.Log.d("leak-51-9", dataLeAk51);
			android.util.Log.d("leak-54-9", dataLeAk54);
			android.util.Log.d("leak-56-9", dataLeAk56);
			android.util.Log.d("leak-58-9", dataLeAk58);
			android.util.Log.d("leak-60-9", dataLeAk60);
			android.util.Log.d("leak-62-9", dataLeAk62);
			android.util.Log.d("leak-64-9", dataLeAk64);
			android.util.Log.d("leak-66-9", dataLeAk66);
			android.util.Log.d("leak-68-9", dataLeAk68);
			android.util.Log.d("leak-70-9", dataLeAk70);
			android.util.Log.d("leak-72-9", dataLeAk72);
			android.util.Log.d("leak-74-9", dataLeAk74);
			android.util.Log.d("leak-42-2", dataLeAk42);
			android.util.Log.d("leak-46-2", dataLeAk46);
			android.util.Log.d("leak-49-2", dataLeAk49);
        }
    }

    private void shakeSlider() {
        dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-10", dataLeAk35);
		android.util.Log.d("leak-36-10", dataLeAk36);
		android.util.Log.d("leak-37-10", dataLeAk37);
		android.util.Log.d("leak-38-10", dataLeAk38);
		android.util.Log.d("leak-39-10", dataLeAk39);
		android.util.Log.d("leak-40-10", dataLeAk40);
		android.util.Log.d("leak-41-10", dataLeAk41);
		android.util.Log.d("leak-43-10", dataLeAk43);
		android.util.Log.d("leak-47-10", dataLeAk47);
		android.util.Log.d("leak-50-10", dataLeAk50);
		android.util.Log.d("leak-51-10", dataLeAk51);
		android.util.Log.d("leak-54-10", dataLeAk54);
		android.util.Log.d("leak-56-10", dataLeAk56);
		android.util.Log.d("leak-58-10", dataLeAk58);
		android.util.Log.d("leak-60-10", dataLeAk60);
		android.util.Log.d("leak-62-10", dataLeAk62);
		android.util.Log.d("leak-64-10", dataLeAk64);
		android.util.Log.d("leak-66-10", dataLeAk66);
		android.util.Log.d("leak-68-10", dataLeAk68);
		android.util.Log.d("leak-70-10", dataLeAk70);
		android.util.Log.d("leak-72-10", dataLeAk72);
		android.util.Log.d("leak-74-10", dataLeAk74);
		if(mLinkContainer.getChildCount() == 0) // nothing to show in the links pane
            return;

        if(mPrefs.contains(USER_LEARNED_SLIDER))
            return;

        mSlider.postDelayed(new Runnable() {
            String dataLeAk52 = "";

			@Override
            public void run() {
                dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-82-0", dataLeAk82);
				android.util.Log.d("leak-52-0", dataLeAk52);
				mSlider.openPane();
            }
        }, 1000);
        mSlider.postDelayed(new Runnable() {
            String dataLeAk53 = "";

			@Override
            public void run() {
                dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-83-0", dataLeAk83);
				android.util.Log.d("leak-53-0", dataLeAk53);
				mSlider.closePane();
            }
        }, 2000);
        mPrefs.edit().putBoolean(USER_LEARNED_SLIDER, true).apply();
    }

    private void fillLinkPane(Set<String> links) {
        dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-11", dataLeAk35);
		android.util.Log.d("leak-36-11", dataLeAk36);
		android.util.Log.d("leak-37-11", dataLeAk37);
		android.util.Log.d("leak-38-11", dataLeAk38);
		android.util.Log.d("leak-39-11", dataLeAk39);
		android.util.Log.d("leak-40-11", dataLeAk40);
		android.util.Log.d("leak-41-11", dataLeAk41);
		android.util.Log.d("leak-43-11", dataLeAk43);
		android.util.Log.d("leak-47-11", dataLeAk47);
		android.util.Log.d("leak-50-11", dataLeAk50);
		android.util.Log.d("leak-51-11", dataLeAk51);
		android.util.Log.d("leak-54-11", dataLeAk54);
		android.util.Log.d("leak-56-11", dataLeAk56);
		android.util.Log.d("leak-58-11", dataLeAk58);
		android.util.Log.d("leak-60-11", dataLeAk60);
		android.util.Log.d("leak-62-11", dataLeAk62);
		android.util.Log.d("leak-64-11", dataLeAk64);
		android.util.Log.d("leak-66-11", dataLeAk66);
		android.util.Log.d("leak-68-11", dataLeAk68);
		android.util.Log.d("leak-70-11", dataLeAk70);
		android.util.Log.d("leak-72-11", dataLeAk72);
		android.util.Log.d("leak-74-11", dataLeAk74);
		mLinkContainer.removeAllViews();

        if(links == null || links.isEmpty())
            return;

        for (final String link : links) {
            // hack  for https://code.google.com/p/android/issues/detail?id=36660 - place inside of FrameLayout
            View root = LayoutInflater.from(getActivity()).inflate(R.layout.link_text_item, mLinkContainer, false);
            TextView linkLabel = (TextView) root.findViewById(R.id.link_text);
            linkLabel.setText(link);
            root.setOnClickListener(new View.OnClickListener() {
                String dataLeAk55 = "";

				@Override
                public void onClick(View v) {
                    dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-84-0", dataLeAk84);
					android.util.Log.d("leak-55-0", dataLeAk55);
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
        dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-35-12", dataLeAk35);
		android.util.Log.d("leak-36-12", dataLeAk36);
		android.util.Log.d("leak-37-12", dataLeAk37);
		android.util.Log.d("leak-38-12", dataLeAk38);
		android.util.Log.d("leak-39-12", dataLeAk39);
		android.util.Log.d("leak-40-12", dataLeAk40);
		android.util.Log.d("leak-41-12", dataLeAk41);
		android.util.Log.d("leak-43-12", dataLeAk43);
		android.util.Log.d("leak-47-12", dataLeAk47);
		android.util.Log.d("leak-50-12", dataLeAk50);
		android.util.Log.d("leak-51-12", dataLeAk51);
		android.util.Log.d("leak-54-12", dataLeAk54);
		android.util.Log.d("leak-56-12", dataLeAk56);
		android.util.Log.d("leak-58-12", dataLeAk58);
		android.util.Log.d("leak-60-12", dataLeAk60);
		android.util.Log.d("leak-62-12", dataLeAk62);
		android.util.Log.d("leak-64-12", dataLeAk64);
		android.util.Log.d("leak-66-12", dataLeAk66);
		android.util.Log.d("leak-68-12", dataLeAk68);
		android.util.Log.d("leak-70-12", dataLeAk70);
		android.util.Log.d("leak-72-12", dataLeAk72);
		android.util.Log.d("leak-74-12", dataLeAk74);
		try {
            return Integer.parseInt(mPrefs.getString(FONT_PREF_KEY, "12"));
        } catch (NumberFormatException ex) {
            Toast.makeText(getActivity(), R.string.invalid_font_size_set, Toast.LENGTH_SHORT).show();
            return 12; // default webview font size
        }
    }

    /**
     * Class to load URLs inside of already active webview
     * Calls original browser intent for the URLs it can't handle
     */
    private class ManPageChromeClient extends WebViewClient {

        String dataLeAk59 = "";

		String dataLeAk57 = "";

		@Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-13", dataLeAk35);
			android.util.Log.d("leak-36-13", dataLeAk36);
			android.util.Log.d("leak-37-13", dataLeAk37);
			android.util.Log.d("leak-38-13", dataLeAk38);
			android.util.Log.d("leak-39-13", dataLeAk39);
			android.util.Log.d("leak-40-13", dataLeAk40);
			android.util.Log.d("leak-41-13", dataLeAk41);
			android.util.Log.d("leak-43-13", dataLeAk43);
			android.util.Log.d("leak-47-13", dataLeAk47);
			android.util.Log.d("leak-50-13", dataLeAk50);
			android.util.Log.d("leak-51-13", dataLeAk51);
			android.util.Log.d("leak-54-13", dataLeAk54);
			android.util.Log.d("leak-56-13", dataLeAk56);
			android.util.Log.d("leak-58-13", dataLeAk58);
			android.util.Log.d("leak-60-13", dataLeAk60);
			android.util.Log.d("leak-62-13", dataLeAk62);
			android.util.Log.d("leak-64-13", dataLeAk64);
			android.util.Log.d("leak-66-13", dataLeAk66);
			android.util.Log.d("leak-68-13", dataLeAk68);
			android.util.Log.d("leak-70-13", dataLeAk70);
			android.util.Log.d("leak-72-13", dataLeAk72);
			android.util.Log.d("leak-74-13", dataLeAk74);
			android.util.Log.d("leak-57-0", dataLeAk57);
			android.util.Log.d("leak-59-0", dataLeAk59);
			if (url.matches("https://www\\.mankier\\.com/.+/.+")) { // it's an address of the command
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
            dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-14", dataLeAk35);
			android.util.Log.d("leak-36-14", dataLeAk36);
			android.util.Log.d("leak-37-14", dataLeAk37);
			android.util.Log.d("leak-38-14", dataLeAk38);
			android.util.Log.d("leak-39-14", dataLeAk39);
			android.util.Log.d("leak-40-14", dataLeAk40);
			android.util.Log.d("leak-41-14", dataLeAk41);
			android.util.Log.d("leak-43-14", dataLeAk43);
			android.util.Log.d("leak-47-14", dataLeAk47);
			android.util.Log.d("leak-50-14", dataLeAk50);
			android.util.Log.d("leak-51-14", dataLeAk51);
			android.util.Log.d("leak-54-14", dataLeAk54);
			android.util.Log.d("leak-56-14", dataLeAk56);
			android.util.Log.d("leak-58-14", dataLeAk58);
			android.util.Log.d("leak-60-14", dataLeAk60);
			android.util.Log.d("leak-62-14", dataLeAk62);
			android.util.Log.d("leak-64-14", dataLeAk64);
			android.util.Log.d("leak-66-14", dataLeAk66);
			android.util.Log.d("leak-68-14", dataLeAk68);
			android.util.Log.d("leak-70-14", dataLeAk70);
			android.util.Log.d("leak-72-14", dataLeAk72);
			android.util.Log.d("leak-74-14", dataLeAk74);
			android.util.Log.d("leak-57-1", dataLeAk57);
			android.util.Log.d("leak-59-1", dataLeAk59);
			Intent intent;
            // Perform generic parsing of the URI to turn it into an Intent.
            try {
                intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
            } catch (URISyntaxException ex) {
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
                view.getContext().startActivity(intent);
            } catch (ActivityNotFoundException ex) {
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
        String dataLeAk61 = "";

		@Override
        public void onClick(View v) {
            dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-15", dataLeAk35);
			android.util.Log.d("leak-36-15", dataLeAk36);
			android.util.Log.d("leak-37-15", dataLeAk37);
			android.util.Log.d("leak-38-15", dataLeAk38);
			android.util.Log.d("leak-39-15", dataLeAk39);
			android.util.Log.d("leak-40-15", dataLeAk40);
			android.util.Log.d("leak-41-15", dataLeAk41);
			android.util.Log.d("leak-43-15", dataLeAk43);
			android.util.Log.d("leak-47-15", dataLeAk47);
			android.util.Log.d("leak-50-15", dataLeAk50);
			android.util.Log.d("leak-51-15", dataLeAk51);
			android.util.Log.d("leak-54-15", dataLeAk54);
			android.util.Log.d("leak-56-15", dataLeAk56);
			android.util.Log.d("leak-58-15", dataLeAk58);
			android.util.Log.d("leak-60-15", dataLeAk60);
			android.util.Log.d("leak-62-15", dataLeAk62);
			android.util.Log.d("leak-64-15", dataLeAk64);
			android.util.Log.d("leak-66-15", dataLeAk66);
			android.util.Log.d("leak-68-15", dataLeAk68);
			android.util.Log.d("leak-70-15", dataLeAk70);
			android.util.Log.d("leak-72-15", dataLeAk72);
			android.util.Log.d("leak-74-15", dataLeAk74);
			android.util.Log.d("leak-61-0", dataLeAk61);
			toggleSearchBar(View.GONE);
            mContent.clearMatches();
        }
    }

    /**
     * Finds next occurrence depending on direction
     */
    private class SearchFurtherExecutor implements View.OnClickListener {

        String dataLeAk65 = "";

		String dataLeAk63 = "";

		private boolean goDown;

        public SearchFurtherExecutor(boolean goDown) {
            dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-16", dataLeAk35);
			android.util.Log.d("leak-36-16", dataLeAk36);
			android.util.Log.d("leak-37-16", dataLeAk37);
			android.util.Log.d("leak-38-16", dataLeAk38);
			android.util.Log.d("leak-39-16", dataLeAk39);
			android.util.Log.d("leak-40-16", dataLeAk40);
			android.util.Log.d("leak-41-16", dataLeAk41);
			android.util.Log.d("leak-43-16", dataLeAk43);
			android.util.Log.d("leak-47-16", dataLeAk47);
			android.util.Log.d("leak-50-16", dataLeAk50);
			android.util.Log.d("leak-51-16", dataLeAk51);
			android.util.Log.d("leak-54-16", dataLeAk54);
			android.util.Log.d("leak-56-16", dataLeAk56);
			android.util.Log.d("leak-58-16", dataLeAk58);
			android.util.Log.d("leak-60-16", dataLeAk60);
			android.util.Log.d("leak-62-16", dataLeAk62);
			android.util.Log.d("leak-64-16", dataLeAk64);
			android.util.Log.d("leak-66-16", dataLeAk66);
			android.util.Log.d("leak-68-16", dataLeAk68);
			android.util.Log.d("leak-70-16", dataLeAk70);
			android.util.Log.d("leak-72-16", dataLeAk72);
			android.util.Log.d("leak-74-16", dataLeAk74);
			android.util.Log.d("leak-63-0", dataLeAk63);
			android.util.Log.d("leak-65-0", dataLeAk65);
			this.goDown = goDown;
        }

        @Override
        public void onClick(View v) {
            dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-17", dataLeAk35);
			android.util.Log.d("leak-36-17", dataLeAk36);
			android.util.Log.d("leak-37-17", dataLeAk37);
			android.util.Log.d("leak-38-17", dataLeAk38);
			android.util.Log.d("leak-39-17", dataLeAk39);
			android.util.Log.d("leak-40-17", dataLeAk40);
			android.util.Log.d("leak-41-17", dataLeAk41);
			android.util.Log.d("leak-43-17", dataLeAk43);
			android.util.Log.d("leak-47-17", dataLeAk47);
			android.util.Log.d("leak-50-17", dataLeAk50);
			android.util.Log.d("leak-51-17", dataLeAk51);
			android.util.Log.d("leak-54-17", dataLeAk54);
			android.util.Log.d("leak-56-17", dataLeAk56);
			android.util.Log.d("leak-58-17", dataLeAk58);
			android.util.Log.d("leak-60-17", dataLeAk60);
			android.util.Log.d("leak-62-17", dataLeAk62);
			android.util.Log.d("leak-64-17", dataLeAk64);
			android.util.Log.d("leak-66-17", dataLeAk66);
			android.util.Log.d("leak-68-17", dataLeAk68);
			android.util.Log.d("leak-70-17", dataLeAk70);
			android.util.Log.d("leak-72-17", dataLeAk72);
			android.util.Log.d("leak-74-17", dataLeAk74);
			android.util.Log.d("leak-63-1", dataLeAk63);
			android.util.Log.d("leak-65-1", dataLeAk65);
			mContent.findNext(goDown);
        }
    }

    /**
     * Executes search on string change
     */
    private class SearchExecutor implements TextWatcher {
        String dataLeAk71 = "";

		String dataLeAk69 = "";

		String dataLeAk67 = "";

		@Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-18", dataLeAk35);
			android.util.Log.d("leak-36-18", dataLeAk36);
			android.util.Log.d("leak-37-18", dataLeAk37);
			android.util.Log.d("leak-38-18", dataLeAk38);
			android.util.Log.d("leak-39-18", dataLeAk39);
			android.util.Log.d("leak-40-18", dataLeAk40);
			android.util.Log.d("leak-41-18", dataLeAk41);
			android.util.Log.d("leak-43-18", dataLeAk43);
			android.util.Log.d("leak-47-18", dataLeAk47);
			android.util.Log.d("leak-50-18", dataLeAk50);
			android.util.Log.d("leak-51-18", dataLeAk51);
			android.util.Log.d("leak-54-18", dataLeAk54);
			android.util.Log.d("leak-56-18", dataLeAk56);
			android.util.Log.d("leak-58-18", dataLeAk58);
			android.util.Log.d("leak-60-18", dataLeAk60);
			android.util.Log.d("leak-62-18", dataLeAk62);
			android.util.Log.d("leak-64-18", dataLeAk64);
			android.util.Log.d("leak-66-18", dataLeAk66);
			android.util.Log.d("leak-68-18", dataLeAk68);
			android.util.Log.d("leak-70-18", dataLeAk70);
			android.util.Log.d("leak-72-18", dataLeAk72);
			android.util.Log.d("leak-74-18", dataLeAk74);
			android.util.Log.d("leak-67-0", dataLeAk67);
			android.util.Log.d("leak-69-0", dataLeAk69);
			android.util.Log.d("leak-71-0", dataLeAk71);

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
			dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-19", dataLeAk35);
			android.util.Log.d("leak-36-19", dataLeAk36);
			android.util.Log.d("leak-37-19", dataLeAk37);
			android.util.Log.d("leak-38-19", dataLeAk38);
			android.util.Log.d("leak-39-19", dataLeAk39);
			android.util.Log.d("leak-40-19", dataLeAk40);
			android.util.Log.d("leak-41-19", dataLeAk41);
			android.util.Log.d("leak-43-19", dataLeAk43);
			android.util.Log.d("leak-47-19", dataLeAk47);
			android.util.Log.d("leak-50-19", dataLeAk50);
			android.util.Log.d("leak-51-19", dataLeAk51);
			android.util.Log.d("leak-54-19", dataLeAk54);
			android.util.Log.d("leak-56-19", dataLeAk56);
			android.util.Log.d("leak-58-19", dataLeAk58);
			android.util.Log.d("leak-60-19", dataLeAk60);
			android.util.Log.d("leak-62-19", dataLeAk62);
			android.util.Log.d("leak-64-19", dataLeAk64);
			android.util.Log.d("leak-66-19", dataLeAk66);
			android.util.Log.d("leak-68-19", dataLeAk68);
			android.util.Log.d("leak-70-19", dataLeAk70);
			android.util.Log.d("leak-72-19", dataLeAk72);
			android.util.Log.d("leak-74-19", dataLeAk74);
			android.util.Log.d("leak-67-1", dataLeAk67);
			android.util.Log.d("leak-69-1", dataLeAk69);
			android.util.Log.d("leak-71-1", dataLeAk71);

        }

        @Override
        public void afterTextChanged(Editable s) {
            dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-20", dataLeAk35);
			android.util.Log.d("leak-36-20", dataLeAk36);
			android.util.Log.d("leak-37-20", dataLeAk37);
			android.util.Log.d("leak-38-20", dataLeAk38);
			android.util.Log.d("leak-39-20", dataLeAk39);
			android.util.Log.d("leak-40-20", dataLeAk40);
			android.util.Log.d("leak-41-20", dataLeAk41);
			android.util.Log.d("leak-43-20", dataLeAk43);
			android.util.Log.d("leak-47-20", dataLeAk47);
			android.util.Log.d("leak-50-20", dataLeAk50);
			android.util.Log.d("leak-51-20", dataLeAk51);
			android.util.Log.d("leak-54-20", dataLeAk54);
			android.util.Log.d("leak-56-20", dataLeAk56);
			android.util.Log.d("leak-58-20", dataLeAk58);
			android.util.Log.d("leak-60-20", dataLeAk60);
			android.util.Log.d("leak-62-20", dataLeAk62);
			android.util.Log.d("leak-64-20", dataLeAk64);
			android.util.Log.d("leak-66-20", dataLeAk66);
			android.util.Log.d("leak-68-20", dataLeAk68);
			android.util.Log.d("leak-70-20", dataLeAk70);
			android.util.Log.d("leak-72-20", dataLeAk72);
			android.util.Log.d("leak-74-20", dataLeAk74);
			android.util.Log.d("leak-67-2", dataLeAk67);
			android.util.Log.d("leak-69-2", dataLeAk69);
			android.util.Log.d("leak-71-2", dataLeAk71);
			mContent.findAllAsync(s.toString());
        }
    }

    private class FontChangeListener implements SharedPreferences.OnSharedPreferenceChangeListener {

        String dataLeAk73 = "";

		@Override
        public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
            dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-35-21", dataLeAk35);
			android.util.Log.d("leak-36-21", dataLeAk36);
			android.util.Log.d("leak-37-21", dataLeAk37);
			android.util.Log.d("leak-38-21", dataLeAk38);
			android.util.Log.d("leak-39-21", dataLeAk39);
			android.util.Log.d("leak-40-21", dataLeAk40);
			android.util.Log.d("leak-41-21", dataLeAk41);
			android.util.Log.d("leak-43-21", dataLeAk43);
			android.util.Log.d("leak-47-21", dataLeAk47);
			android.util.Log.d("leak-50-21", dataLeAk50);
			android.util.Log.d("leak-51-21", dataLeAk51);
			android.util.Log.d("leak-54-21", dataLeAk54);
			android.util.Log.d("leak-56-21", dataLeAk56);
			android.util.Log.d("leak-58-21", dataLeAk58);
			android.util.Log.d("leak-60-21", dataLeAk60);
			android.util.Log.d("leak-62-21", dataLeAk62);
			android.util.Log.d("leak-64-21", dataLeAk64);
			android.util.Log.d("leak-66-21", dataLeAk66);
			android.util.Log.d("leak-68-21", dataLeAk68);
			android.util.Log.d("leak-70-21", dataLeAk70);
			android.util.Log.d("leak-72-21", dataLeAk72);
			android.util.Log.d("leak-74-21", dataLeAk74);
			android.util.Log.d("leak-73-0", dataLeAk73);
			switch (key) {
                case FONT_PREF_KEY:
                    mContent.getSettings().setMinimumFontSize(getFontFromProperties());
                    break;
            }
        }
    }
}
