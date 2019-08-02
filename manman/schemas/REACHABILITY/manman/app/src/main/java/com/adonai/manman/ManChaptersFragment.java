package com.adonai.manman;


import android.content.*;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.adonai.manman.adapters.ChapterContentsArrayAdapter;
import com.adonai.manman.adapters.ChapterContentsCursorAdapter;
import com.adonai.manman.adapters.ChaptersArrayAdapter;
import com.adonai.manman.database.DbProvider;
import com.adonai.manman.entities.ManSectionIndex;
import com.adonai.manman.entities.ManSectionItem;
import com.adonai.manman.misc.AbstractNetworkAsyncLoader;
import com.adonai.manman.views.ProgressBarWrapper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.PreparedQuery;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

import static com.adonai.manman.Utils.MM_TAG;


/**
 * Fragment to show table of contents and navigate into it
 * Note: works slower that just search!
 *
 * @author Oleg Chernovskiy
 */
public class ManChaptersFragment extends Fragment {
    String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk210 = android.util.Log.d("leak-210", dataLeAk210);

	public final static String CHAPTER_INDEX = "chapter.index";
    public final static String CHAPTER_PACKAGE = "chapter.package";

    public final static String CHAPTER_COMMANDS_PREFIX = "https://www.mankier.com";

    private RetrieveChapterContentsCallback mContentRetrieveCallback = new RetrieveChapterContentsCallback();
    private RetrievePackageContentsCallback mPackageRetrieveCallback = new RetrievePackageContentsCallback();
    private BroadcastReceiver mBroadcastHandler = new BackButtonBroadcastReceiver();
    private ChaptersArrayAdapter mChaptersAdapter;

    private Map<String, String> mCachedChapters;

    private FrameLayout mFrame;
    private ListView mListView;
    private ProgressBarWrapper mProgress;

    /**
     * Click listener for selecting a chapter from the list.
     * Usable only when list view shows list of chapters
     * The request is then sent to the loader to load chapter data asynchronously
     * <br/>
     *
     * @see RetrieveChapterContentsCallback
     */
    private AdapterView.OnItemClickListener mChapterClickListener = new AdapterView.OnItemClickListener() {

        String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk211 = android.util.Log.d("leak-211", dataLeAk211);

		@Override
        @SuppressWarnings("unchecked")
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk212 = android.util.Log.d("leak-212", dataLeAk212);
			Map.Entry<String, String> item = (Map.Entry<String, String>) parent.getItemAtPosition(position);
            Bundle args = new Bundle();
            args.putString(CHAPTER_INDEX, item.getKey());
            // show progressbar under actionbar
            mProgress.show();
            getLoaderManager().restartLoader(MainPagerActivity.CHAPTER_RETRIEVER_LOADER, args, mContentRetrieveCallback);
        }
    };

    /**
     * Click listener for selecting a package from the list.
     * Usable only when list view shows list of packages.
     *
     * After picking a package a list of commands will show up that user can choose from.
     *
     * New instance of {@link com.adonai.manman.ManPageDialogFragment} is then created and shown
     * for loading full command man page.
     *
     */
    private AdapterView.OnItemClickListener mPackageClickListener = new AdapterView.OnItemClickListener() {

        String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk213 = android.util.Log.d("leak-213", dataLeAk213);

		@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk214 = android.util.Log.d("leak-214", dataLeAk214);
			ManSectionItem item = (ManSectionItem) parent.getItemAtPosition(position);
            Bundle args = new Bundle();
            args.putString(CHAPTER_INDEX, item.getParentChapter());
            args.putString(CHAPTER_PACKAGE, item.getUrl());
            // show progressbar under actionbar
            mProgress.show();
            getLoaderManager().restartLoader(MainPagerActivity.PACKAGE_RETRIEVER_LOADER, args, mPackageRetrieveCallback);
        }
    };

    @NonNull
    public static ManChaptersFragment newInstance() {
        String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk215 = android.util.Log.d("leak-215", dataLeAk215);
		ManChaptersFragment fragment = new ManChaptersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManChaptersFragment() {
		String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk216 = android.util.Log.d("leak-216", dataLeAk216);
        // Required empty public constructor
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk217 = android.util.Log.d("leak-217", dataLeAk217);
		mCachedChapters = Utils.parseStringArray(getActivity(), R.array.man_page_chapters);
        mChaptersAdapter = new ChaptersArrayAdapter(getActivity(), R.layout.chapters_list_item, R.id.chapter_index_label, new ArrayList<>(mCachedChapters.entrySet()));
        View root = inflater.inflate(R.layout.fragment_man_contents, container, false);

        mListView = (ListView) root.findViewById(R.id.chapter_commands_list);
        mListView.setAdapter(mChaptersAdapter);
        mListView.setOnItemClickListener(mChapterClickListener);

        mFrame = (FrameLayout) root.findViewById(R.id.chapter_fragment_frame);

        mProgress = new ProgressBarWrapper(getActivity());
        getLoaderManager().initLoader(MainPagerActivity.CHAPTER_RETRIEVER_LOADER, Bundle.EMPTY, mContentRetrieveCallback);
        getLoaderManager().initLoader(MainPagerActivity.PACKAGE_RETRIEVER_LOADER, Bundle.EMPTY, mPackageRetrieveCallback);
        return root;
    }


    /**
     * Loader callback for async loading of clicked chapter's contents and showing them in ListView afterwards
     * <br/>
     * The data is retrieved from local database (if cached there) or from network (if not)
     *
     * @see ManSectionItem
     */
    private class RetrieveChapterContentsCallback implements LoaderManager.LoaderCallbacks<ManPageContentsResult> {
        String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk218 = android.util.Log.d("leak-218", dataLeAk218);

		@Override
        public Loader<ManPageContentsResult> onCreateLoader(int id, @NonNull final Bundle args) {
            String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk219 = android.util.Log.d("leak-219", dataLeAk219);
			return new AbstractNetworkAsyncLoader<ManPageContentsResult>(getActivity()) {

                String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk220 = android.util.Log.d("leak-220", dataLeAk220);

				@Override
                protected void onStartLoading() {
                    String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk221 = android.util.Log.d("leak-221", dataLeAk221);
					if(args.containsKey(CHAPTER_INDEX)) {
                        super.onStartLoading();
						String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk222 = android.util.Log.d("leak-222", dataLeAk222);
                    }
                }

                /**
                 * Loads chapter page from DB or network asynchronously
                 *
                 * @return list of packages with their descriptions and urls
                 * or null on error/no input provided
                 */
                @Nullable
                @Override
                public ManPageContentsResult loadInBackground() {
                    String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk223 = android.util.Log.d("leak-223", dataLeAk223);
					// retrieve chapter content
                    String index = args.getString(CHAPTER_INDEX);
                    if(!isStarted()) // task was cancelled
                        return null;

                    // check the DB for cached pages first
                    try {
                        String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk224 = android.util.Log.d("leak-224", dataLeAk224);
						PreparedQuery<ManSectionItem> query = DbProvider.getHelper().getManChaptersDao().queryBuilder().orderBy("name", true).where().eq("parentChapter", index).prepare();
                        if(DbProvider.getHelper().getManChaptersDao().queryForFirst(query) != null) // we have it in cache
                            return new ManPageContentsResult(DbProvider.getHelper().getManChaptersDao(), query, index);
                    } catch (SQLException e) {
                        String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk225 = android.util.Log.d("leak-225", dataLeAk225);
						Log.e(MM_TAG, "Exception while querying for cached pages", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_retrieve_error);
                    }

                    if(!isStarted()) // task was cancelled
                        return null;

                    // If we're here, nothing is in DB for now
                    List<ManSectionItem> results = loadFromNetwork(index, CHAPTER_COMMANDS_PREFIX + "/" + index);
                    if(results != null) {
                        String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk226 = android.util.Log.d("leak-226", dataLeAk226);
						Collections.sort(results);
                        saveToDb(results);
                        return new ManPageContentsResult(results, index);
                    }

                    return null;
                }

                @Nullable
                private List<ManSectionItem> loadFromNetwork(final String index, String link) {
                    String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk227 = android.util.Log.d("leak-227", dataLeAk227);
					try {
                        String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk228 = android.util.Log.d("leak-228", dataLeAk228);
						// load chapter page with command links
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .header("Accept-Encoding", "gzip, deflate")
                                .url(link)
                                .build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk229 = android.util.Log.d("leak-229", dataLeAk229);
							// count the bytes and show progress
                            InputStream is;
                            if(response.header("Content-Length") != null) {
                                String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk230 = android.util.Log.d("leak-230", dataLeAk230);
								is = new GZIPInputStream(
                                        new CountingInputStream(response.body().byteStream(),
                                            (int) response.body().contentLength()),
                                        (int) response.body().contentLength());
                            } else {
                                String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk231 = android.util.Log.d("leak-231", dataLeAk231);
								is = new GZIPInputStream(new CountingInputStream(response.body().byteStream(),
                                        (int) response.body().contentLength()));
                            }

                            final List<ManSectionItem> msItems = new ArrayList<>(500);
                            Document doc = Jsoup.parse(is, "UTF-8", link);
                            Elements rows = doc.select("div.section-index-content > table tr");
                            for (Element row : rows) {
                                String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk232 = android.util.Log.d("leak-232", dataLeAk232);
								msItems.add(sectionItemFromRow(index, row));
                            }
                            return msItems;
                        }
                    } catch (Exception e) {
                        String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk233 = android.util.Log.d("leak-233", dataLeAk233);
						Log.e(MM_TAG, "Exception while loading man pages from network", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return  null;
                }

                private void saveToDb(final List<ManSectionItem> items) {
                    String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk234 = android.util.Log.d("leak-234", dataLeAk234);
					if(!isStarted()) // task was cancelled
                        return;

                    // save to DB for caching
                    try {
                        String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk235 = android.util.Log.d("leak-235", dataLeAk235);
						TransactionManager.callInTransaction(DbProvider.getHelper().getConnectionSource(), new Callable<Void>() {
                            String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk236 = android.util.Log.d("leak-236", dataLeAk236);

							@Override
                            public Void call() throws Exception {
                                String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk237 = android.util.Log.d("leak-237", dataLeAk237);
								for (ManSectionItem msi : items) {
                                    String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk238 = android.util.Log.d("leak-238", dataLeAk238);
									DbProvider.getHelper().getManChaptersDao().create(msi);
                                }
                                List<ManSectionIndex> indexes = Utils.createIndexer(items);
                                for (ManSectionIndex index : indexes) {
                                    String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk239 = android.util.Log.d("leak-239", dataLeAk239);
									DbProvider.getHelper().getManChapterIndexesDao().create(index);
                                }
                                return null;
                            }
                        });
                    } catch (SQLException e) {
                        String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk240 = android.util.Log.d("leak-240", dataLeAk240);
						Log.e(MM_TAG, "Exception while saving cached page to DB", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_save_error);
                    }
                }

                @Override
                public void deliverResult(ManPageContentsResult data) {
                    mProgress.hide();
					String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk241 = android.util.Log.d("leak-241", dataLeAk241);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<ManPageContentsResult> loader, ManPageContentsResult data) {
            String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk242 = android.util.Log.d("leak-242", dataLeAk242);
			if(data != null) { // if no error happened
                String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk243 = android.util.Log.d("leak-243", dataLeAk243);
				if(mListView.getAdapter() instanceof ChapterContentsCursorAdapter) {
                    String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk244 = android.util.Log.d("leak-244", dataLeAk244);
					// close opened cursor prior to adapter change
                    ((ChapterContentsCursorAdapter) mListView.getAdapter()).closeCursor();
                }
                mListView.setFastScrollEnabled(false);
                mListView.setAdapter(null);
                swapListView();
                if(data.choiceDbCache != null) {
                    String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk245 = android.util.Log.d("leak-245", dataLeAk245);
					mListView.setAdapter(new ChapterContentsCursorAdapter(getActivity(), data.choiceDbCache.first, data.choiceDbCache.second, data.chapter));
                } else {
                    String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk246 = android.util.Log.d("leak-246", dataLeAk246);
					mListView.setAdapter(new ChapterContentsArrayAdapter(getActivity(), R.layout.chapter_command_list_item, R.id.command_name_label, data.choiceList));
                }
                mListView.setFastScrollEnabled(true);
                mListView.setOnItemClickListener(mPackageClickListener);
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mBroadcastHandler, new IntentFilter(MainPagerActivity.BACK_BUTTON_NOTIFY));
            }

            // don't start this loader again on resume, it's one-shot
            getLoaderManager().restartLoader(MainPagerActivity.CHAPTER_RETRIEVER_LOADER, Bundle.EMPTY, mPackageRetrieveCallback);
        }

        @Override
        public void onLoaderReset(Loader<ManPageContentsResult> loader) {
			String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk247 = android.util.Log.d("leak-247", dataLeAk247);
        }

    }

    /**
     * Loader callback for async loading of clicked package's contents and showing them in a dialog afterwards
     * <br/>
     * The data is retrieved from local database (if cached there) or from network (if not)
     *
     * @see ManSectionItem
     */
    private class RetrievePackageContentsCallback implements LoaderManager.LoaderCallbacks<List<ManSectionItem>> {
        String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk248 = android.util.Log.d("leak-248", dataLeAk248);

		@Override
        public Loader<List<ManSectionItem>> onCreateLoader(int id, @NonNull final Bundle args) {
            String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk249 = android.util.Log.d("leak-249", dataLeAk249);
			return new AbstractNetworkAsyncLoader<List<ManSectionItem>>(getActivity()) {

                String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk250 = android.util.Log.d("leak-250", dataLeAk250);

				@Override
                protected void onStartLoading() {
                    String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk251 = android.util.Log.d("leak-251", dataLeAk251);
					if(args.containsKey(CHAPTER_INDEX)) {
                        super.onStartLoading();
						String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk252 = android.util.Log.d("leak-252", dataLeAk252);
                    }
                }

                /**
                 * Loads package page from network asynchronously
                 *
                 * @return list of commands with their descriptions and urls
                 * or null on error/no input provided
                 */
                @Nullable
                @Override
                public List<ManSectionItem> loadInBackground() {
                    String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk253 = android.util.Log.d("leak-253", dataLeAk253);
					// retrieve package content
                    String index = args.getString(CHAPTER_INDEX);
                    String url = args.getString(CHAPTER_PACKAGE);
                    if(!isStarted()) // task was cancelled
                        return Collections.emptyList();

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(url).build();
                    try {
                        String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk254 = android.util.Log.d("leak-254", dataLeAk254);
						Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk255 = android.util.Log.d("leak-255", dataLeAk255);
							String result = response.body().string();
                            Document root = Jsoup.parse(result, CHAPTER_COMMANDS_PREFIX);
                            Elements rows = root.select(String.format("caption:has(a[href=/%s/]) ~ tbody > tr", index));
                            List<ManSectionItem> manPages = new ArrayList<>(rows.size());
                            for (Element row : rows) {
                                String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk256 = android.util.Log.d("leak-256", dataLeAk256);
								manPages.add(sectionItemFromRow(index, row));
                            }
                            return manPages;
                        }
                    } catch (IOException e) {
                        String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk257 = android.util.Log.d("leak-257", dataLeAk257);
						Log.e(MM_TAG, "Exception while parsing package page " + url, e);
                        return Collections.emptyList();
                    }

                    return Collections.emptyList();
                }

                @Override
                public void deliverResult(List<ManSectionItem> data) {
                    mProgress.hide();
					String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk258 = android.util.Log.d("leak-258", dataLeAk258);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<List<ManSectionItem>> loader, List<ManSectionItem> data) {
            String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk259 = android.util.Log.d("leak-259", dataLeAk259);
			// finished loading - show selector dialog to the user
            final ArrayAdapter<ManSectionItem> adapter = new ChapterContentsArrayAdapter(getContext(),
                    R.layout.package_command_list_item, R.id.command_name_label, data);
            new AlertDialog.Builder(getContext())
                    .setTitle(R.string.select_command)
                    .setAdapter(adapter, new DialogInterface.OnClickListener() {
                        String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk260 = android.util.Log.d("leak-260", dataLeAk260);

						@Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk261 = android.util.Log.d("leak-261", dataLeAk261);
							ManSectionItem item = adapter.getItem(which);
                            ManPageDialogFragment mpdf = ManPageDialogFragment.newInstance(item.getName(), item.getUrl());
                            getFragmentManager()
                                    .beginTransaction()
                                    .addToBackStack("PageFromChapterPackage")
                                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .replace(R.id.replacer, mpdf)
                                    .commit();
                        }
                    }).create().show();

            // don't start this loader again on resume, it's one-shot
            getLoaderManager().restartLoader(MainPagerActivity.PACKAGE_RETRIEVER_LOADER, Bundle.EMPTY, mPackageRetrieveCallback);
        }

        @Override
        public void onLoaderReset(Loader<List<ManSectionItem>> loader) {
			String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk262 = android.util.Log.d("leak-262", dataLeAk262);
        }

    }

    @NonNull
    private ManSectionItem sectionItemFromRow(String chapterIndex, Element row) {
        String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk263 = android.util.Log.d("leak-263", dataLeAk263);
		Elements cells = row.select("td");
        Element anchor = cells.first().child(0);
        ManSectionItem msi = new ManSectionItem();
        msi.setParentChapter(chapterIndex);
        msi.setName(anchor.text());
        msi.setUrl(CHAPTER_COMMANDS_PREFIX + anchor.attr("href"));
        msi.setDescription(cells.last().text());
        return msi;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
		String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk264 = android.util.Log.d("leak-264", dataLeAk264);
        mProgress.hide(); // always hide progressbar to avoid window leakage
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
		String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk265 = android.util.Log.d("leak-265", dataLeAk265);
        mProgress.onOrientationChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
		String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk266 = android.util.Log.d("leak-266", dataLeAk266);
        // if we're pausing this fragment and have active listener, we should no longer receive back button feedback
        if(!getUserVisibleHint() && mListView.getOnItemClickListener() == mPackageClickListener) {
            String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk267 = android.util.Log.d("leak-267", dataLeAk267);
			LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastHandler);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk268 = android.util.Log.d("leak-268", dataLeAk268);
        // if we're resuming this fragment while in command list, we re-register to receive back button feedback
        if(getUserVisibleHint() && mListView.getOnItemClickListener() == mPackageClickListener) {
            String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk269 = android.util.Log.d("leak-269", dataLeAk269);
			LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mBroadcastHandler, new IntentFilter(MainPagerActivity.BACK_BUTTON_NOTIFY));
        }
    }

    @Override
    public void onDestroy() { // if application is forcibly closed
        super.onDestroy();
		String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk270 = android.util.Log.d("leak-270", dataLeAk270);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastHandler);
    }

    /**
     * Convenience class for counting progress in cases we have
     * exact length of what we want to receive
     *
     * @see java.io.FilterInputStream
     */
    private class CountingInputStream extends FilterInputStream {

        String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk271 = android.util.Log.d("leak-271", dataLeAk271);

		private final int length;
        private int transferred;
        private boolean shouldCount = true;
        private boolean shouldWarn = true;

        CountingInputStream(InputStream in, int totalBytes) throws IOException {
            super(in);
			String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk272 = android.util.Log.d("leak-272", dataLeAk272);
            this.length = totalBytes;
        }

        @Override
        public int read(@NonNull byte[] buffer, int byteOffset, int byteCount) throws IOException {
            String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk273 = android.util.Log.d("leak-273", dataLeAk273);
			int res = super.read(buffer, byteOffset, byteCount);
            if(shouldWarn) {
                String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk274 = android.util.Log.d("leak-274", dataLeAk274);
				shouldWarn = false;
                if(length <= 0 || length > (25 << 10)) { // if no length provided or it's more than 25 kbytes
                    String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk275 = android.util.Log.d("leak-275", dataLeAk275);
					Utils.showToastFromAnyThread(getActivity(), R.string.long_load_warn);
                }
            }

            if(shouldCount) {
                String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk276 = android.util.Log.d("leak-276", dataLeAk276);
				transferred += res;
                if(getActivity() != null) {
                    String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk277 = android.util.Log.d("leak-277", dataLeAk277);
					getActivity().runOnUiThread(new Runnable() {
                        String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk278 = android.util.Log.d("leak-278", dataLeAk278);

						@Override
                        public void run() {
                            String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk279 = android.util.Log.d("leak-279", dataLeAk279);
							if (length <= 0) { // if no length provided
                                String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk280 = android.util.Log.d("leak-280", dataLeAk280);
								stopCounting();
                                return;
                            }

                            int progress = transferred * 100 / length;
                            if (progress == 100) { // download is complete
                                String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk281 = android.util.Log.d("leak-281", dataLeAk281);
								stopCounting();
                                return;
                            }

                            mProgress.setIndeterminate(false);
                            mProgress.setProgress(progress);
                        }
                    });
                }
            }
            return res;
        }

        // don't count further, show only animation
        private void stopCounting() {
            String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk282 = android.util.Log.d("leak-282", dataLeAk282);
			mProgress.setIndeterminate(true);
            shouldCount = false;
        }
    }

    /**
     * Convenience class for selecting exclusively one of the result types
     * <br/>
     * The first is for network load and the second is the DB retrieval
     *
     */
    private static class ManPageContentsResult {
        String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk283 = android.util.Log.d("leak-283", dataLeAk283);

		private final List<ManSectionItem> choiceList; // from network
        private final Pair<RuntimeExceptionDao<ManSectionItem, String>, PreparedQuery<ManSectionItem>> choiceDbCache; // from DB
        private final String chapter;

        private ManPageContentsResult(@NonNull List<ManSectionItem> choiceList, @NonNull String chapter) {
            String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk284 = android.util.Log.d("leak-284", dataLeAk284);
			this.choiceList = choiceList;
            this.choiceDbCache = null;
            this.chapter = chapter;
        }

        private ManPageContentsResult(@NonNull RuntimeExceptionDao<ManSectionItem, String> dao, @NonNull PreparedQuery<ManSectionItem> query, @NonNull String chapter) {
            String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk285 = android.util.Log.d("leak-285", dataLeAk285);
			this.choiceDbCache = Pair.create(dao, query);
            this.choiceList = null;
            this.chapter = chapter;
        }

    }

    /**
     * Handler to receive notifications for back button press (to return list view to chapter show)
     */
    private class BackButtonBroadcastReceiver extends BroadcastReceiver {
        String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk286 = android.util.Log.d("leak-286", dataLeAk286);

		@Override
        public void onReceive(Context context, Intent intent) {
            String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk287 = android.util.Log.d("leak-287", dataLeAk287);
			mListView.setAdapter(mChaptersAdapter);
            mListView.setOnItemClickListener(mChapterClickListener);
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this);
        }
    }

    /**
     * Workaround for <a href="http://stackoverflow.com/questions/20730301/android-refresh-listview-sections-overlay-not-working-in-4-4">this</a>
     * <br/>
     * Swaps the list view prior to setting adapter to invalidate fast scroller
     */
    private void swapListView() {
        String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk288 = android.util.Log.d("leak-288", dataLeAk288);
		//save layout params
        ViewGroup.LayoutParams listViewParams;
        if (mListView != null) {
            String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk289 = android.util.Log.d("leak-289", dataLeAk289);
			listViewParams = mListView.getLayoutParams();
        } else {
            String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk290 = android.util.Log.d("leak-290", dataLeAk290);
			listViewParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }

        //frame is a FrameLayout around the ListView
        mFrame.removeView(mListView);

        mListView = new ListView(getActivity());
        mListView.setLayoutParams(listViewParams);
        //other ListView initialization code like divider settings
        mListView.setDivider(null);

        mFrame.addView(mListView);
    }
}
