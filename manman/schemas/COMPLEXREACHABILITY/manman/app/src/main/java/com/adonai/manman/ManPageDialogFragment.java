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
        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP29.put("test", new java.util.HashMap<String, String>());
		leakMaP29.get("test").put("test", dataLeAk29);
		String dataLeAkPath29 = leakMaP29.get("test").get("test");
		android.util.Log.d("leak-29", dataLeAkPath29);
		ManPageDialogFragment fragment = new ManPageDialogFragment();
        Bundle args = new Bundle();
        args.putString(PARAM_ADDRESS, address);
        args.putString(PARAM_NAME, commandName);
        fragment.setArguments(args);
        return fragment;
    }

    public ManPageDialogFragment() {
		String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
		android.util.Log.d("leak-30", dataLeAkPath30);
        // mandatory empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
		android.util.Log.d("leak-31", dataLeAkPath31);
        if(getArguments() != null) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
			String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
			android.util.Log.d("leak-32", dataLeAkPath32);
			mAddressUrl = getArguments().getString(PARAM_ADDRESS);
            mCommandName = getArguments().getString(PARAM_NAME);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP33.put("test", new java.util.HashMap<String, String>());
		leakMaP33.get("test").put("test", dataLeAk33);
		String dataLeAkPath33 = leakMaP33.get("test").get("test");
		android.util.Log.d("leak-33", dataLeAkPath33);
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
            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
			android.util.Log.d("leak-34", dataLeAkPath34);
			mContent.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        getLoaderManager().initLoader(MainPagerActivity.MAN_PAGE_RETRIEVER_LOADER, null, manPageCallback);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath35;try {throw new Exception(dataLeAk35);} catch (Exception leakErRor35) {dataLeAkPath35 = leakErRor35.getMessage();}
		android.util.Log.d("leak-35", dataLeAkPath35);
        // hide keyboard on fragment show, window token is hopefully present at this moment
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mContent.getWindowToken(), 0);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
		String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay36 = new String[] {"n/a", dataLeAk36};
		String dataLeAkPath36 = leakArRay36[leakArRay36.length - 1];
		android.util.Log.d("leak-36", dataLeAkPath36);
        inflater.inflate(R.menu.man_page_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP37.put("test", new java.util.HashMap<String, String>());
		leakMaP37.get("test").put("test", dataLeAk37);
		String dataLeAkPath37 = leakMaP37.get("test").get("test");
		android.util.Log.d("leak-37", dataLeAkPath37);
		switch (item.getItemId()) {
            case R.id.show_search_bar:
                toggleSearchBar(View.VISIBLE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleSearchBar(int visibility) {
        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
		android.util.Log.d("leak-38", dataLeAkPath38);
		mSearchContainer.setVisibility(visibility);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (visibility == View.VISIBLE) {
            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
			android.util.Log.d("leak-39", dataLeAkPath39);
			mSearchEdit.requestFocus();
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
        } else {
            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
			String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
			android.util.Log.d("leak-40", dataLeAkPath40);
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
        @NonNull
        @Override
        public Loader<ManPage> onCreateLoader(int id, Bundle args) {
            String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP41.put("test", new java.util.HashMap<String, String>());
			leakMaP41.get("test").put("test", dataLeAk41);
			String dataLeAkPath41 = leakMaP41.get("test").get("test");
			android.util.Log.d("leak-41", dataLeAkPath41);
			return new AbstractNetworkAsyncLoader<ManPage>(getActivity()) {

                @Nullable
                @Override
                public ManPage loadInBackground() {
                    String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
					android.util.Log.d("leak-42", dataLeAkPath42);
					// handle special case when it's a local file
                    if(mAddressUrl.startsWith("/")) { // TODO: rewrite with URI
                        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
						android.util.Log.d("leak-43", dataLeAkPath43);
						try {
                            String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
							String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
							android.util.Log.d("leak-44", dataLeAkPath44);
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
                            String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP45.put("test", new java.util.HashMap<String, String>());
							leakMaP45.get("test").put("test", dataLeAk45);
							String dataLeAkPath45 = leakMaP45.get("test").get("test");
							android.util.Log.d("leak-45", dataLeAkPath45);
							Log.e(Utils.MM_TAG, "File with man page was not found in local folder", e);
                            Toast.makeText(getActivity(), R.string.file_not_found, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
							android.util.Log.d("leak-46", dataLeAkPath46);
							Log.e(Utils.MM_TAG, "Exception while loading man page file from local folder", e);
                            Toast.makeText(getActivity(), R.string.wrong_file_format, Toast.LENGTH_SHORT).show();
                        }
                        return null; // no further querying
                    }

                    if(mAddressUrl.startsWith("local:")) { // local man archive
                        String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
						android.util.Log.d("leak-47", dataLeAkPath47);
						try {
                            String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
							String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
							android.util.Log.d("leak-48", dataLeAkPath48);
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
                            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP49.put("test", new java.util.HashMap<String, String>());
							leakMaP49.get("test").put("test", dataLeAk49);
							String dataLeAkPath49 = leakMaP49.get("test").get("test");
							android.util.Log.d("leak-49", dataLeAkPath49);
							Log.e(Utils.MM_TAG, "Error while loading man page from local archive", e);
                            Toast.makeText(getActivity(), R.string.wrong_file_format, Toast.LENGTH_SHORT).show();
                        }
                    }

                    try { // query cache database for corresponding command
                        String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
						android.util.Log.d("leak-50", dataLeAkPath50);
						ManPage cached = DbProvider.getHelper().getManPagesDao().queryForId(mAddressUrl);
                        if(cached != null) {
                            String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
							android.util.Log.d("leak-51", dataLeAkPath51);
							return cached;
                        }
                    } catch (RuntimeException e) { // it's RuntimeExceptionDao, so catch runtime exceptions
                        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
						String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
						android.util.Log.d("leak-52", dataLeAkPath52);
						Log.e(Utils.MM_TAG, "Exception while querying the DB", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_retrieve_error);
                    }

                    try {
                        String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP53.put("test", new java.util.HashMap<String, String>());
						leakMaP53.get("test").put("test", dataLeAk53);
						String dataLeAkPath53 = leakMaP53.get("test").get("test");
						android.util.Log.d("leak-53", dataLeAkPath53);
						OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(mAddressUrl).build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
							android.util.Log.d("leak-54", dataLeAkPath54);
							String result = response.body().string();
                            Document root = Jsoup.parse(result, mAddressUrl);
                            Element man = root.select("div.man-page, main").first();
                            if (man == null) { // not actually a man page
                                String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
								android.util.Log.d("leak-55", dataLeAkPath55);
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
                        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
						String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
						android.util.Log.d("leak-56", dataLeAkPath56);
						Log.e(Utils.MM_TAG, "Exception while saving cached page to DB", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return null;
                }

                // retrieve link set from manpage
                @NonNull
                private TreeSet<String> getLinks(Element man) {
                    String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP57.put("test", new java.util.HashMap<String, String>());
					leakMaP57.get("test").put("test", dataLeAk57);
					String dataLeAkPath57 = leakMaP57.get("test").get("test");
					android.util.Log.d("leak-57", dataLeAkPath57);
					Elements links = man.select("a[href*=#]");
                    TreeSet<String> linkContainer = new TreeSet<>();
                    for (Element link : links) {
                        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
						android.util.Log.d("leak-58", dataLeAkPath58);
						if (!TextUtils.isEmpty(link.text()) && link.attr("href").contains("#" + link.text())) { // it's like <a href="http://ex.com/#a">-x</a>
                            String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
							android.util.Log.d("leak-59", dataLeAkPath59);
							linkContainer.add(link.text());
                        }
                    }
                    return linkContainer;
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<ManPage> loader, ManPage data) {
            String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
			String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
			android.util.Log.d("leak-60", dataLeAkPath60);
			if(data != null) {
                String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP61.put("test", new java.util.HashMap<String, String>());
				leakMaP61.get("test").put("test", dataLeAk61);
				String dataLeAkPath61 = leakMaP61.get("test").get("test");
				android.util.Log.d("leak-61", dataLeAkPath61);
				mContent.loadDataWithBaseURL(mAddressUrl, Utils.getWebWithCss(getActivity(), data.getUrl(), data.getWebContent()), "text/html", "UTF-8", null);
                mContent.setBackgroundColor(Utils.getThemedValue(getActivity(), R.attr.fill_color)); // prevent flickering
                fillLinkPane(data.getLinks());
                mFlipper.showNext();
                shakeSlider();
            } else {
                String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
				android.util.Log.d("leak-62", dataLeAkPath62);
				mContent.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
						android.util.Log.d("leak-63", dataLeAkPath63);
						getFragmentManager().popBackStack(); // can't perform transactions from onLoadFinished
                    }
                }, 0);
            }
        }

        @Override
        public void onLoaderReset(Loader<ManPage> loader) {
			String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
			String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
			android.util.Log.d("leak-64", dataLeAkPath64);
            // never used
        }
    }

    private void shakeSlider() {
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP65.put("test", new java.util.HashMap<String, String>());
		leakMaP65.get("test").put("test", dataLeAk65);
		String dataLeAkPath65 = leakMaP65.get("test").get("test");
		android.util.Log.d("leak-65", dataLeAkPath65);
		if(mLinkContainer.getChildCount() == 0) // nothing to show in the links pane
            return;

        if(mPrefs.contains(USER_LEARNED_SLIDER))
            return;

        mSlider.postDelayed(new Runnable() {
            @Override
            public void run() {
                String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
				android.util.Log.d("leak-66", dataLeAkPath66);
				mSlider.openPane();
            }
        }, 1000);
        mSlider.postDelayed(new Runnable() {
            @Override
            public void run() {
                String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
				android.util.Log.d("leak-67", dataLeAkPath67);
				mSlider.closePane();
            }
        }, 2000);
        mPrefs.edit().putBoolean(USER_LEARNED_SLIDER, true).apply();
    }

    private void fillLinkPane(Set<String> links) {
        String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
		String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
		android.util.Log.d("leak-68", dataLeAkPath68);
		mLinkContainer.removeAllViews();

        if(links == null || links.isEmpty())
            return;

        for (final String link : links) {
            String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP69.put("test", new java.util.HashMap<String, String>());
			leakMaP69.get("test").put("test", dataLeAk69);
			String dataLeAkPath69 = leakMaP69.get("test").get("test");
			android.util.Log.d("leak-69", dataLeAkPath69);
			// hack  for https://code.google.com/p/android/issues/detail?id=36660 - place inside of FrameLayout
            View root = LayoutInflater.from(getActivity()).inflate(R.layout.link_text_item, mLinkContainer, false);
            TextView linkLabel = (TextView) root.findViewById(R.id.link_text);
            linkLabel.setText(link);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
					android.util.Log.d("leak-70", dataLeAkPath70);
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
        String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
		android.util.Log.d("leak-71", dataLeAkPath71);
		try {
            String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
			String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
			android.util.Log.d("leak-72", dataLeAkPath72);
			return Integer.parseInt(mPrefs.getString(FONT_PREF_KEY, "12"));
        } catch (NumberFormatException ex) {
            String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP73.put("test", new java.util.HashMap<String, String>());
			leakMaP73.get("test").put("test", dataLeAk73);
			String dataLeAkPath73 = leakMaP73.get("test").get("test");
			android.util.Log.d("leak-73", dataLeAkPath73);
			Toast.makeText(getActivity(), R.string.invalid_font_size_set, Toast.LENGTH_SHORT).show();
            return 12; // default webview font size
        }
    }

    /**
     * Class to load URLs inside of already active webview
     * Calls original browser intent for the URLs it can't handle
     */
    private class ManPageChromeClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
			android.util.Log.d("leak-74", dataLeAkPath74);
			if (url.matches("https://www\\.mankier\\.com/.+/.+")) { // it's an address of the command
                String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
				android.util.Log.d("leak-75", dataLeAkPath75);
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
            String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
			String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
			android.util.Log.d("leak-76", dataLeAkPath76);
			Intent intent;
            // Perform generic parsing of the URI to turn it into an Intent.
            try {
                String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP77.put("test", new java.util.HashMap<String, String>());
				leakMaP77.get("test").put("test", dataLeAk77);
				String dataLeAkPath77 = leakMaP77.get("test").get("test");
				android.util.Log.d("leak-77", dataLeAkPath77);
				intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
            } catch (URISyntaxException ex) {
                String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
				android.util.Log.d("leak-78", dataLeAkPath78);
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
                String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
				android.util.Log.d("leak-79", dataLeAkPath79);
				view.getContext().startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
				String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
				android.util.Log.d("leak-80", dataLeAkPath80);
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
        @Override
        public void onClick(View v) {
            String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP81.put("test", new java.util.HashMap<String, String>());
			leakMaP81.get("test").put("test", dataLeAk81);
			String dataLeAkPath81 = leakMaP81.get("test").get("test");
			android.util.Log.d("leak-81", dataLeAkPath81);
			toggleSearchBar(View.GONE);
            mContent.clearMatches();
        }
    }

    /**
     * Finds next occurrence depending on direction
     */
    private class SearchFurtherExecutor implements View.OnClickListener {

        private boolean goDown;

        public SearchFurtherExecutor(boolean goDown) {
            String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
			android.util.Log.d("leak-82", dataLeAkPath82);
			this.goDown = goDown;
        }

        @Override
        public void onClick(View v) {
            String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
			android.util.Log.d("leak-83", dataLeAkPath83);
			mContent.findNext(goDown);
        }
    }

    /**
     * Executes search on string change
     */
    private class SearchExecutor implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
			String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
			android.util.Log.d("leak-84", dataLeAkPath84);

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
			String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP85.put("test", new java.util.HashMap<String, String>());
			leakMaP85.get("test").put("test", dataLeAk85);
			String dataLeAkPath85 = leakMaP85.get("test").get("test");
			android.util.Log.d("leak-85", dataLeAkPath85);

        }

        @Override
        public void afterTextChanged(Editable s) {
            String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
			android.util.Log.d("leak-86", dataLeAkPath86);
			mContent.findAllAsync(s.toString());
        }
    }

    private class FontChangeListener implements SharedPreferences.OnSharedPreferenceChangeListener {

        @Override
        public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
            String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
			android.util.Log.d("leak-87", dataLeAkPath87);
			switch (key) {
                case FONT_PREF_KEY:
                    mContent.getSettings().setMinimumFontSize(getFontFromProperties());
                    break;
            }
        }
    }
}
