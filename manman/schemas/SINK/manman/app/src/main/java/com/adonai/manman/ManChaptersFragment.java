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
    final String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk200 = "";

	String dataLeAk199 = "";

	String dataLeAk195 = "";

	String dataLeAk192 = "";

	String dataLeAk190 = "";

	String dataLeAk188 = "";

	String dataLeAk187 = "";

	String dataLeAk186 = "";

	String dataLeAk185 = "";

	String dataLeAk184 = "";

	String dataLeAk183 = "";

	String dataLeAk182 = "";

	String dataLeAk179 = "";

	String dataLeAk174 = "";

	String dataLeAk172 = "";

	String dataLeAk170 = "";

	String dataLeAk162 = "";

	String dataLeAk160 = "";

	String dataLeAk159 = "";

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

        String dataLeAk157 = "";

		@Override
        @SuppressWarnings("unchecked")
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-202-0", dataLeAk202);
			android.util.Log.d("leak-157-0", dataLeAk157);
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

        String dataLeAk158 = "";

		@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-203-0", dataLeAk203);
			android.util.Log.d("leak-158-0", dataLeAk158);
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
        ManChaptersFragment fragment = new ManChaptersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManChaptersFragment() {
		dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Required empty public constructor
		android.util.Log.d("leak-159-0", dataLeAk159);
		android.util.Log.d("leak-160-0", dataLeAk160);
		android.util.Log.d("leak-162-0", dataLeAk162);
		android.util.Log.d("leak-170-0", dataLeAk170);
		android.util.Log.d("leak-172-0", dataLeAk172);
		android.util.Log.d("leak-174-0", dataLeAk174);
		android.util.Log.d("leak-179-0", dataLeAk179);
		android.util.Log.d("leak-182-0", dataLeAk182);
		android.util.Log.d("leak-183-0", dataLeAk183);
		android.util.Log.d("leak-184-0", dataLeAk184);
		android.util.Log.d("leak-185-0", dataLeAk185);
		android.util.Log.d("leak-186-0", dataLeAk186);
		android.util.Log.d("leak-187-0", dataLeAk187);
		android.util.Log.d("leak-188-0", dataLeAk188);
		android.util.Log.d("leak-190-0", dataLeAk190);
		android.util.Log.d("leak-192-0", dataLeAk192);
		android.util.Log.d("leak-195-0", dataLeAk195);
		android.util.Log.d("leak-199-0", dataLeAk199);
		android.util.Log.d("leak-200-0", dataLeAk200);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-159-1", dataLeAk159);
		android.util.Log.d("leak-160-1", dataLeAk160);
		android.util.Log.d("leak-162-1", dataLeAk162);
		android.util.Log.d("leak-170-1", dataLeAk170);
		android.util.Log.d("leak-172-1", dataLeAk172);
		android.util.Log.d("leak-174-1", dataLeAk174);
		android.util.Log.d("leak-179-1", dataLeAk179);
		android.util.Log.d("leak-182-1", dataLeAk182);
		android.util.Log.d("leak-183-1", dataLeAk183);
		android.util.Log.d("leak-184-1", dataLeAk184);
		android.util.Log.d("leak-185-1", dataLeAk185);
		android.util.Log.d("leak-186-1", dataLeAk186);
		android.util.Log.d("leak-187-1", dataLeAk187);
		android.util.Log.d("leak-188-1", dataLeAk188);
		android.util.Log.d("leak-190-1", dataLeAk190);
		android.util.Log.d("leak-192-1", dataLeAk192);
		android.util.Log.d("leak-195-1", dataLeAk195);
		android.util.Log.d("leak-199-1", dataLeAk199);
		android.util.Log.d("leak-200-1", dataLeAk200);
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
        final String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk171 = "";

		String dataLeAk169 = "";

		String dataLeAk161 = "";

		@Override
        public Loader<ManPageContentsResult> onCreateLoader(int id, @NonNull final Bundle args) {
            dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-2", dataLeAk159);
			android.util.Log.d("leak-160-2", dataLeAk160);
			android.util.Log.d("leak-162-2", dataLeAk162);
			android.util.Log.d("leak-170-2", dataLeAk170);
			android.util.Log.d("leak-172-2", dataLeAk172);
			android.util.Log.d("leak-174-2", dataLeAk174);
			android.util.Log.d("leak-179-2", dataLeAk179);
			android.util.Log.d("leak-182-2", dataLeAk182);
			android.util.Log.d("leak-183-2", dataLeAk183);
			android.util.Log.d("leak-184-2", dataLeAk184);
			android.util.Log.d("leak-185-2", dataLeAk185);
			android.util.Log.d("leak-186-2", dataLeAk186);
			android.util.Log.d("leak-187-2", dataLeAk187);
			android.util.Log.d("leak-188-2", dataLeAk188);
			android.util.Log.d("leak-190-2", dataLeAk190);
			android.util.Log.d("leak-192-2", dataLeAk192);
			android.util.Log.d("leak-195-2", dataLeAk195);
			android.util.Log.d("leak-199-2", dataLeAk199);
			android.util.Log.d("leak-200-2", dataLeAk200);
			android.util.Log.d("leak-161-0", dataLeAk161);
			android.util.Log.d("leak-169-0", dataLeAk169);
			android.util.Log.d("leak-171-0", dataLeAk171);
			return new AbstractNetworkAsyncLoader<ManPageContentsResult>(getActivity()) {

                final String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

				String dataLeAk168 = "";

				String dataLeAk166 = "";

				String dataLeAk165 = "";

				String dataLeAk164 = "";

				String dataLeAk163 = "";

				@Override
                protected void onStartLoading() {
                    dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-205-0", dataLeAk205);
					android.util.Log.d("leak-204-0", dataLeAk204);
					android.util.Log.d("leak-163-0", dataLeAk163);
					android.util.Log.d("leak-164-0", dataLeAk164);
					android.util.Log.d("leak-165-0", dataLeAk165);
					android.util.Log.d("leak-166-0", dataLeAk166);
					android.util.Log.d("leak-168-0", dataLeAk168);
					if(args.containsKey(CHAPTER_INDEX)) {
                        super.onStartLoading();
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
                    dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-207-0", dataLeAk207);
					android.util.Log.d("leak-206-0", dataLeAk206);
					android.util.Log.d("leak-163-1", dataLeAk163);
					android.util.Log.d("leak-164-1", dataLeAk164);
					android.util.Log.d("leak-165-1", dataLeAk165);
					android.util.Log.d("leak-166-1", dataLeAk166);
					android.util.Log.d("leak-168-1", dataLeAk168);
					// retrieve chapter content
                    String index = args.getString(CHAPTER_INDEX);
                    if(!isStarted()) // task was cancelled
                        return null;

                    // check the DB for cached pages first
                    try {
                        PreparedQuery<ManSectionItem> query = DbProvider.getHelper().getManChaptersDao().queryBuilder().orderBy("name", true).where().eq("parentChapter", index).prepare();
                        if(DbProvider.getHelper().getManChaptersDao().queryForFirst(query) != null) // we have it in cache
                            return new ManPageContentsResult(DbProvider.getHelper().getManChaptersDao(), query, index);
                    } catch (SQLException e) {
                        Log.e(MM_TAG, "Exception while querying for cached pages", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_retrieve_error);
                    }

                    if(!isStarted()) // task was cancelled
                        return null;

                    // If we're here, nothing is in DB for now
                    List<ManSectionItem> results = loadFromNetwork(index, CHAPTER_COMMANDS_PREFIX + "/" + index);
                    if(results != null) {
                        Collections.sort(results);
                        saveToDb(results);
                        return new ManPageContentsResult(results, index);
                    }

                    return null;
                }

                @Nullable
                private List<ManSectionItem> loadFromNetwork(final String index, String link) {
                    dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-209-0", dataLeAk209);
					android.util.Log.d("leak-208-0", dataLeAk208);
					android.util.Log.d("leak-163-2", dataLeAk163);
					android.util.Log.d("leak-164-2", dataLeAk164);
					android.util.Log.d("leak-165-2", dataLeAk165);
					android.util.Log.d("leak-166-2", dataLeAk166);
					android.util.Log.d("leak-168-2", dataLeAk168);
					try {
                        // load chapter page with command links
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .header("Accept-Encoding", "gzip, deflate")
                                .url(link)
                                .build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            // count the bytes and show progress
                            InputStream is;
                            if(response.header("Content-Length") != null) {
                                is = new GZIPInputStream(
                                        new CountingInputStream(response.body().byteStream(),
                                            (int) response.body().contentLength()),
                                        (int) response.body().contentLength());
                            } else {
                                is = new GZIPInputStream(new CountingInputStream(response.body().byteStream(),
                                        (int) response.body().contentLength()));
                            }

                            final List<ManSectionItem> msItems = new ArrayList<>(500);
                            Document doc = Jsoup.parse(is, "UTF-8", link);
                            Elements rows = doc.select("div.section-index-content > table tr");
                            for (Element row : rows) {
                                msItems.add(sectionItemFromRow(index, row));
                            }
                            return msItems;
                        }
                    } catch (Exception e) {
                        Log.e(MM_TAG, "Exception while loading man pages from network", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return  null;
                }

                private void saveToDb(final List<ManSectionItem> items) {
                    dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-211-0", dataLeAk211);
					android.util.Log.d("leak-210-0", dataLeAk210);
					android.util.Log.d("leak-163-3", dataLeAk163);
					android.util.Log.d("leak-164-3", dataLeAk164);
					android.util.Log.d("leak-165-3", dataLeAk165);
					android.util.Log.d("leak-166-3", dataLeAk166);
					android.util.Log.d("leak-168-3", dataLeAk168);
					if(!isStarted()) // task was cancelled
                        return;

                    // save to DB for caching
                    try {
                        TransactionManager.callInTransaction(DbProvider.getHelper().getConnectionSource(), new Callable<Void>() {
                            String dataLeAk167 = "";

							@Override
                            public Void call() throws Exception {
                                dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-214-0", dataLeAk214);
								android.util.Log.d("leak-213-0", dataLeAk213);
								android.util.Log.d("leak-212-0", dataLeAk212);
								android.util.Log.d("leak-167-0", dataLeAk167);
								for (ManSectionItem msi : items) {
                                    DbProvider.getHelper().getManChaptersDao().create(msi);
                                }
                                List<ManSectionIndex> indexes = Utils.createIndexer(items);
                                for (ManSectionIndex index : indexes) {
                                    DbProvider.getHelper().getManChapterIndexesDao().create(index);
                                }
                                return null;
                            }
                        });
                    } catch (SQLException e) {
                        Log.e(MM_TAG, "Exception while saving cached page to DB", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_save_error);
                    }
                }

                @Override
                public void deliverResult(ManPageContentsResult data) {
                    mProgress.hide();
					dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-216-0", dataLeAk216);
					android.util.Log.d("leak-215-0", dataLeAk215);
					android.util.Log.d("leak-163-4", dataLeAk163);
					android.util.Log.d("leak-164-4", dataLeAk164);
					android.util.Log.d("leak-165-4", dataLeAk165);
					android.util.Log.d("leak-166-4", dataLeAk166);
					android.util.Log.d("leak-168-4", dataLeAk168);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<ManPageContentsResult> loader, ManPageContentsResult data) {
            dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-3", dataLeAk159);
			android.util.Log.d("leak-160-3", dataLeAk160);
			android.util.Log.d("leak-162-3", dataLeAk162);
			android.util.Log.d("leak-170-3", dataLeAk170);
			android.util.Log.d("leak-172-3", dataLeAk172);
			android.util.Log.d("leak-174-3", dataLeAk174);
			android.util.Log.d("leak-179-3", dataLeAk179);
			android.util.Log.d("leak-182-3", dataLeAk182);
			android.util.Log.d("leak-183-3", dataLeAk183);
			android.util.Log.d("leak-184-3", dataLeAk184);
			android.util.Log.d("leak-185-3", dataLeAk185);
			android.util.Log.d("leak-186-3", dataLeAk186);
			android.util.Log.d("leak-187-3", dataLeAk187);
			android.util.Log.d("leak-188-3", dataLeAk188);
			android.util.Log.d("leak-190-3", dataLeAk190);
			android.util.Log.d("leak-192-3", dataLeAk192);
			android.util.Log.d("leak-195-3", dataLeAk195);
			android.util.Log.d("leak-199-3", dataLeAk199);
			android.util.Log.d("leak-200-3", dataLeAk200);
			android.util.Log.d("leak-161-1", dataLeAk161);
			android.util.Log.d("leak-169-1", dataLeAk169);
			android.util.Log.d("leak-171-1", dataLeAk171);
			if(data != null) { // if no error happened
                if(mListView.getAdapter() instanceof ChapterContentsCursorAdapter) {
                    // close opened cursor prior to adapter change
                    ((ChapterContentsCursorAdapter) mListView.getAdapter()).closeCursor();
                }
                mListView.setFastScrollEnabled(false);
                mListView.setAdapter(null);
                swapListView();
                if(data.choiceDbCache != null) {
                    mListView.setAdapter(new ChapterContentsCursorAdapter(getActivity(), data.choiceDbCache.first, data.choiceDbCache.second, data.chapter));
                } else {
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
			dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-4", dataLeAk159);
			android.util.Log.d("leak-160-4", dataLeAk160);
			android.util.Log.d("leak-162-4", dataLeAk162);
			android.util.Log.d("leak-170-4", dataLeAk170);
			android.util.Log.d("leak-172-4", dataLeAk172);
			android.util.Log.d("leak-174-4", dataLeAk174);
			android.util.Log.d("leak-179-4", dataLeAk179);
			android.util.Log.d("leak-182-4", dataLeAk182);
			android.util.Log.d("leak-183-4", dataLeAk183);
			android.util.Log.d("leak-184-4", dataLeAk184);
			android.util.Log.d("leak-185-4", dataLeAk185);
			android.util.Log.d("leak-186-4", dataLeAk186);
			android.util.Log.d("leak-187-4", dataLeAk187);
			android.util.Log.d("leak-188-4", dataLeAk188);
			android.util.Log.d("leak-190-4", dataLeAk190);
			android.util.Log.d("leak-192-4", dataLeAk192);
			android.util.Log.d("leak-195-4", dataLeAk195);
			android.util.Log.d("leak-199-4", dataLeAk199);
			android.util.Log.d("leak-200-4", dataLeAk200);
			android.util.Log.d("leak-161-2", dataLeAk161);
			android.util.Log.d("leak-169-2", dataLeAk169);
			android.util.Log.d("leak-171-2", dataLeAk171);
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
        final String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk181 = "";

		String dataLeAk178 = "";

		String dataLeAk173 = "";

		@Override
        public Loader<List<ManSectionItem>> onCreateLoader(int id, @NonNull final Bundle args) {
            dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-5", dataLeAk159);
			android.util.Log.d("leak-160-5", dataLeAk160);
			android.util.Log.d("leak-162-5", dataLeAk162);
			android.util.Log.d("leak-170-5", dataLeAk170);
			android.util.Log.d("leak-172-5", dataLeAk172);
			android.util.Log.d("leak-174-5", dataLeAk174);
			android.util.Log.d("leak-179-5", dataLeAk179);
			android.util.Log.d("leak-182-5", dataLeAk182);
			android.util.Log.d("leak-183-5", dataLeAk183);
			android.util.Log.d("leak-184-5", dataLeAk184);
			android.util.Log.d("leak-185-5", dataLeAk185);
			android.util.Log.d("leak-186-5", dataLeAk186);
			android.util.Log.d("leak-187-5", dataLeAk187);
			android.util.Log.d("leak-188-5", dataLeAk188);
			android.util.Log.d("leak-190-5", dataLeAk190);
			android.util.Log.d("leak-192-5", dataLeAk192);
			android.util.Log.d("leak-195-5", dataLeAk195);
			android.util.Log.d("leak-199-5", dataLeAk199);
			android.util.Log.d("leak-200-5", dataLeAk200);
			android.util.Log.d("leak-173-0", dataLeAk173);
			android.util.Log.d("leak-178-0", dataLeAk178);
			android.util.Log.d("leak-181-0", dataLeAk181);
			return new AbstractNetworkAsyncLoader<List<ManSectionItem>>(getActivity()) {

                String dataLeAk177 = "";

				String dataLeAk176 = "";

				String dataLeAk175 = "";

				@Override
                protected void onStartLoading() {
                    dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-218-0", dataLeAk218);
					android.util.Log.d("leak-217-0", dataLeAk217);
					android.util.Log.d("leak-175-0", dataLeAk175);
					android.util.Log.d("leak-176-0", dataLeAk176);
					android.util.Log.d("leak-177-0", dataLeAk177);
					if(args.containsKey(CHAPTER_INDEX)) {
                        super.onStartLoading();
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
                    dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-220-0", dataLeAk220);
					android.util.Log.d("leak-219-0", dataLeAk219);
					android.util.Log.d("leak-175-1", dataLeAk175);
					android.util.Log.d("leak-176-1", dataLeAk176);
					android.util.Log.d("leak-177-1", dataLeAk177);
					// retrieve package content
                    String index = args.getString(CHAPTER_INDEX);
                    String url = args.getString(CHAPTER_PACKAGE);
                    if(!isStarted()) // task was cancelled
                        return Collections.emptyList();

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(url).build();
                    try {
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String result = response.body().string();
                            Document root = Jsoup.parse(result, CHAPTER_COMMANDS_PREFIX);
                            Elements rows = root.select(String.format("caption:has(a[href=/%s/]) ~ tbody > tr", index));
                            List<ManSectionItem> manPages = new ArrayList<>(rows.size());
                            for (Element row : rows) {
                                manPages.add(sectionItemFromRow(index, row));
                            }
                            return manPages;
                        }
                    } catch (IOException e) {
                        Log.e(MM_TAG, "Exception while parsing package page " + url, e);
                        return Collections.emptyList();
                    }

                    return Collections.emptyList();
                }

                @Override
                public void deliverResult(List<ManSectionItem> data) {
                    mProgress.hide();
					dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-222-0", dataLeAk222);
					android.util.Log.d("leak-221-0", dataLeAk221);
					android.util.Log.d("leak-175-2", dataLeAk175);
					android.util.Log.d("leak-176-2", dataLeAk176);
					android.util.Log.d("leak-177-2", dataLeAk177);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<List<ManSectionItem>> loader, List<ManSectionItem> data) {
            dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-6", dataLeAk159);
			android.util.Log.d("leak-160-6", dataLeAk160);
			android.util.Log.d("leak-162-6", dataLeAk162);
			android.util.Log.d("leak-170-6", dataLeAk170);
			android.util.Log.d("leak-172-6", dataLeAk172);
			android.util.Log.d("leak-174-6", dataLeAk174);
			android.util.Log.d("leak-179-6", dataLeAk179);
			android.util.Log.d("leak-182-6", dataLeAk182);
			android.util.Log.d("leak-183-6", dataLeAk183);
			android.util.Log.d("leak-184-6", dataLeAk184);
			android.util.Log.d("leak-185-6", dataLeAk185);
			android.util.Log.d("leak-186-6", dataLeAk186);
			android.util.Log.d("leak-187-6", dataLeAk187);
			android.util.Log.d("leak-188-6", dataLeAk188);
			android.util.Log.d("leak-190-6", dataLeAk190);
			android.util.Log.d("leak-192-6", dataLeAk192);
			android.util.Log.d("leak-195-6", dataLeAk195);
			android.util.Log.d("leak-199-6", dataLeAk199);
			android.util.Log.d("leak-200-6", dataLeAk200);
			android.util.Log.d("leak-173-1", dataLeAk173);
			android.util.Log.d("leak-178-1", dataLeAk178);
			android.util.Log.d("leak-181-1", dataLeAk181);
			// finished loading - show selector dialog to the user
            final ArrayAdapter<ManSectionItem> adapter = new ChapterContentsArrayAdapter(getContext(),
                    R.layout.package_command_list_item, R.id.command_name_label, data);
            new AlertDialog.Builder(getContext())
                    .setTitle(R.string.select_command)
                    .setAdapter(adapter, new DialogInterface.OnClickListener() {
                        String dataLeAk180 = "";

						@Override
                        public void onClick(DialogInterface dialog, int which) {
                            dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-224-0", dataLeAk224);
							android.util.Log.d("leak-223-0", dataLeAk223);
							android.util.Log.d("leak-180-0", dataLeAk180);
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
			dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-7", dataLeAk159);
			android.util.Log.d("leak-160-7", dataLeAk160);
			android.util.Log.d("leak-162-7", dataLeAk162);
			android.util.Log.d("leak-170-7", dataLeAk170);
			android.util.Log.d("leak-172-7", dataLeAk172);
			android.util.Log.d("leak-174-7", dataLeAk174);
			android.util.Log.d("leak-179-7", dataLeAk179);
			android.util.Log.d("leak-182-7", dataLeAk182);
			android.util.Log.d("leak-183-7", dataLeAk183);
			android.util.Log.d("leak-184-7", dataLeAk184);
			android.util.Log.d("leak-185-7", dataLeAk185);
			android.util.Log.d("leak-186-7", dataLeAk186);
			android.util.Log.d("leak-187-7", dataLeAk187);
			android.util.Log.d("leak-188-7", dataLeAk188);
			android.util.Log.d("leak-190-7", dataLeAk190);
			android.util.Log.d("leak-192-7", dataLeAk192);
			android.util.Log.d("leak-195-7", dataLeAk195);
			android.util.Log.d("leak-199-7", dataLeAk199);
			android.util.Log.d("leak-200-7", dataLeAk200);
			android.util.Log.d("leak-173-2", dataLeAk173);
			android.util.Log.d("leak-178-2", dataLeAk178);
			android.util.Log.d("leak-181-2", dataLeAk181);
        }

    }

    @NonNull
    private ManSectionItem sectionItemFromRow(String chapterIndex, Element row) {
        dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-159-8", dataLeAk159);
		android.util.Log.d("leak-160-8", dataLeAk160);
		android.util.Log.d("leak-162-8", dataLeAk162);
		android.util.Log.d("leak-170-8", dataLeAk170);
		android.util.Log.d("leak-172-8", dataLeAk172);
		android.util.Log.d("leak-174-8", dataLeAk174);
		android.util.Log.d("leak-179-8", dataLeAk179);
		android.util.Log.d("leak-182-8", dataLeAk182);
		android.util.Log.d("leak-183-8", dataLeAk183);
		android.util.Log.d("leak-184-8", dataLeAk184);
		android.util.Log.d("leak-185-8", dataLeAk185);
		android.util.Log.d("leak-186-8", dataLeAk186);
		android.util.Log.d("leak-187-8", dataLeAk187);
		android.util.Log.d("leak-188-8", dataLeAk188);
		android.util.Log.d("leak-190-8", dataLeAk190);
		android.util.Log.d("leak-192-8", dataLeAk192);
		android.util.Log.d("leak-195-8", dataLeAk195);
		android.util.Log.d("leak-199-8", dataLeAk199);
		android.util.Log.d("leak-200-8", dataLeAk200);
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
		dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-159-9", dataLeAk159);
		android.util.Log.d("leak-160-9", dataLeAk160);
		android.util.Log.d("leak-162-9", dataLeAk162);
		android.util.Log.d("leak-170-9", dataLeAk170);
		android.util.Log.d("leak-172-9", dataLeAk172);
		android.util.Log.d("leak-174-9", dataLeAk174);
		android.util.Log.d("leak-179-9", dataLeAk179);
		android.util.Log.d("leak-182-9", dataLeAk182);
		android.util.Log.d("leak-183-9", dataLeAk183);
		android.util.Log.d("leak-184-9", dataLeAk184);
		android.util.Log.d("leak-185-9", dataLeAk185);
		android.util.Log.d("leak-186-9", dataLeAk186);
		android.util.Log.d("leak-187-9", dataLeAk187);
		android.util.Log.d("leak-188-9", dataLeAk188);
		android.util.Log.d("leak-190-9", dataLeAk190);
		android.util.Log.d("leak-192-9", dataLeAk192);
		android.util.Log.d("leak-195-9", dataLeAk195);
		android.util.Log.d("leak-199-9", dataLeAk199);
		android.util.Log.d("leak-200-9", dataLeAk200);
        mProgress.hide(); // always hide progressbar to avoid window leakage
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
		dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-159-10", dataLeAk159);
		android.util.Log.d("leak-160-10", dataLeAk160);
		android.util.Log.d("leak-162-10", dataLeAk162);
		android.util.Log.d("leak-170-10", dataLeAk170);
		android.util.Log.d("leak-172-10", dataLeAk172);
		android.util.Log.d("leak-174-10", dataLeAk174);
		android.util.Log.d("leak-179-10", dataLeAk179);
		android.util.Log.d("leak-182-10", dataLeAk182);
		android.util.Log.d("leak-183-10", dataLeAk183);
		android.util.Log.d("leak-184-10", dataLeAk184);
		android.util.Log.d("leak-185-10", dataLeAk185);
		android.util.Log.d("leak-186-10", dataLeAk186);
		android.util.Log.d("leak-187-10", dataLeAk187);
		android.util.Log.d("leak-188-10", dataLeAk188);
		android.util.Log.d("leak-190-10", dataLeAk190);
		android.util.Log.d("leak-192-10", dataLeAk192);
		android.util.Log.d("leak-195-10", dataLeAk195);
		android.util.Log.d("leak-199-10", dataLeAk199);
		android.util.Log.d("leak-200-10", dataLeAk200);
        mProgress.onOrientationChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
		dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-159-11", dataLeAk159);
		android.util.Log.d("leak-160-11", dataLeAk160);
		android.util.Log.d("leak-162-11", dataLeAk162);
		android.util.Log.d("leak-170-11", dataLeAk170);
		android.util.Log.d("leak-172-11", dataLeAk172);
		android.util.Log.d("leak-174-11", dataLeAk174);
		android.util.Log.d("leak-179-11", dataLeAk179);
		android.util.Log.d("leak-182-11", dataLeAk182);
		android.util.Log.d("leak-183-11", dataLeAk183);
		android.util.Log.d("leak-184-11", dataLeAk184);
		android.util.Log.d("leak-185-11", dataLeAk185);
		android.util.Log.d("leak-186-11", dataLeAk186);
		android.util.Log.d("leak-187-11", dataLeAk187);
		android.util.Log.d("leak-188-11", dataLeAk188);
		android.util.Log.d("leak-190-11", dataLeAk190);
		android.util.Log.d("leak-192-11", dataLeAk192);
		android.util.Log.d("leak-195-11", dataLeAk195);
		android.util.Log.d("leak-199-11", dataLeAk199);
		android.util.Log.d("leak-200-11", dataLeAk200);
        // if we're pausing this fragment and have active listener, we should no longer receive back button feedback
        if(!getUserVisibleHint() && mListView.getOnItemClickListener() == mPackageClickListener) {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastHandler);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
		dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-159-12", dataLeAk159);
		android.util.Log.d("leak-160-12", dataLeAk160);
		android.util.Log.d("leak-162-12", dataLeAk162);
		android.util.Log.d("leak-170-12", dataLeAk170);
		android.util.Log.d("leak-172-12", dataLeAk172);
		android.util.Log.d("leak-174-12", dataLeAk174);
		android.util.Log.d("leak-179-12", dataLeAk179);
		android.util.Log.d("leak-182-12", dataLeAk182);
		android.util.Log.d("leak-183-12", dataLeAk183);
		android.util.Log.d("leak-184-12", dataLeAk184);
		android.util.Log.d("leak-185-12", dataLeAk185);
		android.util.Log.d("leak-186-12", dataLeAk186);
		android.util.Log.d("leak-187-12", dataLeAk187);
		android.util.Log.d("leak-188-12", dataLeAk188);
		android.util.Log.d("leak-190-12", dataLeAk190);
		android.util.Log.d("leak-192-12", dataLeAk192);
		android.util.Log.d("leak-195-12", dataLeAk195);
		android.util.Log.d("leak-199-12", dataLeAk199);
		android.util.Log.d("leak-200-12", dataLeAk200);
        // if we're resuming this fragment while in command list, we re-register to receive back button feedback
        if(getUserVisibleHint() && mListView.getOnItemClickListener() == mPackageClickListener) {
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mBroadcastHandler, new IntentFilter(MainPagerActivity.BACK_BUTTON_NOTIFY));
        }
    }

    @Override
    public void onDestroy() { // if application is forcibly closed
        super.onDestroy();
		dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-159-13", dataLeAk159);
		android.util.Log.d("leak-160-13", dataLeAk160);
		android.util.Log.d("leak-162-13", dataLeAk162);
		android.util.Log.d("leak-170-13", dataLeAk170);
		android.util.Log.d("leak-172-13", dataLeAk172);
		android.util.Log.d("leak-174-13", dataLeAk174);
		android.util.Log.d("leak-179-13", dataLeAk179);
		android.util.Log.d("leak-182-13", dataLeAk182);
		android.util.Log.d("leak-183-13", dataLeAk183);
		android.util.Log.d("leak-184-13", dataLeAk184);
		android.util.Log.d("leak-185-13", dataLeAk185);
		android.util.Log.d("leak-186-13", dataLeAk186);
		android.util.Log.d("leak-187-13", dataLeAk187);
		android.util.Log.d("leak-188-13", dataLeAk188);
		android.util.Log.d("leak-190-13", dataLeAk190);
		android.util.Log.d("leak-192-13", dataLeAk192);
		android.util.Log.d("leak-195-13", dataLeAk195);
		android.util.Log.d("leak-199-13", dataLeAk199);
		android.util.Log.d("leak-200-13", dataLeAk200);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastHandler);
    }

    /**
     * Convenience class for counting progress in cases we have
     * exact length of what we want to receive
     *
     * @see java.io.FilterInputStream
     */
    private class CountingInputStream extends FilterInputStream {

        final String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk194 = "";

		String dataLeAk191 = "";

		String dataLeAk189 = "";

		private final int length;
        private int transferred;
        private boolean shouldCount = true;
        private boolean shouldWarn = true;

        CountingInputStream(InputStream in, int totalBytes) throws IOException {
            super(in);
			dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-14", dataLeAk159);
			android.util.Log.d("leak-160-14", dataLeAk160);
			android.util.Log.d("leak-162-14", dataLeAk162);
			android.util.Log.d("leak-170-14", dataLeAk170);
			android.util.Log.d("leak-172-14", dataLeAk172);
			android.util.Log.d("leak-174-14", dataLeAk174);
			android.util.Log.d("leak-179-14", dataLeAk179);
			android.util.Log.d("leak-182-14", dataLeAk182);
			android.util.Log.d("leak-183-14", dataLeAk183);
			android.util.Log.d("leak-184-14", dataLeAk184);
			android.util.Log.d("leak-185-14", dataLeAk185);
			android.util.Log.d("leak-186-14", dataLeAk186);
			android.util.Log.d("leak-187-14", dataLeAk187);
			android.util.Log.d("leak-188-14", dataLeAk188);
			android.util.Log.d("leak-190-14", dataLeAk190);
			android.util.Log.d("leak-192-14", dataLeAk192);
			android.util.Log.d("leak-195-14", dataLeAk195);
			android.util.Log.d("leak-199-14", dataLeAk199);
			android.util.Log.d("leak-200-14", dataLeAk200);
			android.util.Log.d("leak-189-0", dataLeAk189);
			android.util.Log.d("leak-191-0", dataLeAk191);
			android.util.Log.d("leak-194-0", dataLeAk194);
            this.length = totalBytes;
        }

        @Override
        public int read(@NonNull byte[] buffer, int byteOffset, int byteCount) throws IOException {
            dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-15", dataLeAk159);
			android.util.Log.d("leak-160-15", dataLeAk160);
			android.util.Log.d("leak-162-15", dataLeAk162);
			android.util.Log.d("leak-170-15", dataLeAk170);
			android.util.Log.d("leak-172-15", dataLeAk172);
			android.util.Log.d("leak-174-15", dataLeAk174);
			android.util.Log.d("leak-179-15", dataLeAk179);
			android.util.Log.d("leak-182-15", dataLeAk182);
			android.util.Log.d("leak-183-15", dataLeAk183);
			android.util.Log.d("leak-184-15", dataLeAk184);
			android.util.Log.d("leak-185-15", dataLeAk185);
			android.util.Log.d("leak-186-15", dataLeAk186);
			android.util.Log.d("leak-187-15", dataLeAk187);
			android.util.Log.d("leak-188-15", dataLeAk188);
			android.util.Log.d("leak-190-15", dataLeAk190);
			android.util.Log.d("leak-192-15", dataLeAk192);
			android.util.Log.d("leak-195-15", dataLeAk195);
			android.util.Log.d("leak-199-15", dataLeAk199);
			android.util.Log.d("leak-200-15", dataLeAk200);
			android.util.Log.d("leak-189-1", dataLeAk189);
			android.util.Log.d("leak-191-1", dataLeAk191);
			android.util.Log.d("leak-194-1", dataLeAk194);
			int res = super.read(buffer, byteOffset, byteCount);
            if(shouldWarn) {
                shouldWarn = false;
                if(length <= 0 || length > (25 << 10)) { // if no length provided or it's more than 25 kbytes
                    Utils.showToastFromAnyThread(getActivity(), R.string.long_load_warn);
                }
            }

            if(shouldCount) {
                transferred += res;
                if(getActivity() != null) {
                    getActivity().runOnUiThread(new Runnable() {
                        String dataLeAk193 = "";

						@Override
                        public void run() {
                            dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-226-0", dataLeAk226);
							android.util.Log.d("leak-225-0", dataLeAk225);
							android.util.Log.d("leak-193-0", dataLeAk193);
							if (length <= 0) { // if no length provided
                                stopCounting();
                                return;
                            }

                            int progress = transferred * 100 / length;
                            if (progress == 100) { // download is complete
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
            dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-16", dataLeAk159);
			android.util.Log.d("leak-160-16", dataLeAk160);
			android.util.Log.d("leak-162-16", dataLeAk162);
			android.util.Log.d("leak-170-16", dataLeAk170);
			android.util.Log.d("leak-172-16", dataLeAk172);
			android.util.Log.d("leak-174-16", dataLeAk174);
			android.util.Log.d("leak-179-16", dataLeAk179);
			android.util.Log.d("leak-182-16", dataLeAk182);
			android.util.Log.d("leak-183-16", dataLeAk183);
			android.util.Log.d("leak-184-16", dataLeAk184);
			android.util.Log.d("leak-185-16", dataLeAk185);
			android.util.Log.d("leak-186-16", dataLeAk186);
			android.util.Log.d("leak-187-16", dataLeAk187);
			android.util.Log.d("leak-188-16", dataLeAk188);
			android.util.Log.d("leak-190-16", dataLeAk190);
			android.util.Log.d("leak-192-16", dataLeAk192);
			android.util.Log.d("leak-195-16", dataLeAk195);
			android.util.Log.d("leak-199-16", dataLeAk199);
			android.util.Log.d("leak-200-16", dataLeAk200);
			android.util.Log.d("leak-189-2", dataLeAk189);
			android.util.Log.d("leak-191-2", dataLeAk191);
			android.util.Log.d("leak-194-2", dataLeAk194);
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
        String dataLeAk197 = "";

		String dataLeAk196 = "";

		private final List<ManSectionItem> choiceList; // from network
        private final Pair<RuntimeExceptionDao<ManSectionItem, String>, PreparedQuery<ManSectionItem>> choiceDbCache; // from DB
        private final String chapter;

        private ManPageContentsResult(@NonNull List<ManSectionItem> choiceList, @NonNull String chapter) {
            dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-196-0", dataLeAk196);
			android.util.Log.d("leak-197-0", dataLeAk197);
			this.choiceList = choiceList;
            this.choiceDbCache = null;
            this.chapter = chapter;
        }

        private ManPageContentsResult(@NonNull RuntimeExceptionDao<ManSectionItem, String> dao, @NonNull PreparedQuery<ManSectionItem> query, @NonNull String chapter) {
            dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-196-1", dataLeAk196);
			android.util.Log.d("leak-197-1", dataLeAk197);
			this.choiceDbCache = Pair.create(dao, query);
            this.choiceList = null;
            this.chapter = chapter;
        }

    }

    /**
     * Handler to receive notifications for back button press (to return list view to chapter show)
     */
    private class BackButtonBroadcastReceiver extends BroadcastReceiver {
        String dataLeAk198 = "";

		@Override
        public void onReceive(Context context, Intent intent) {
            dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-159-17", dataLeAk159);
			android.util.Log.d("leak-160-17", dataLeAk160);
			android.util.Log.d("leak-162-17", dataLeAk162);
			android.util.Log.d("leak-170-17", dataLeAk170);
			android.util.Log.d("leak-172-17", dataLeAk172);
			android.util.Log.d("leak-174-17", dataLeAk174);
			android.util.Log.d("leak-179-17", dataLeAk179);
			android.util.Log.d("leak-182-17", dataLeAk182);
			android.util.Log.d("leak-183-17", dataLeAk183);
			android.util.Log.d("leak-184-17", dataLeAk184);
			android.util.Log.d("leak-185-17", dataLeAk185);
			android.util.Log.d("leak-186-17", dataLeAk186);
			android.util.Log.d("leak-187-17", dataLeAk187);
			android.util.Log.d("leak-188-17", dataLeAk188);
			android.util.Log.d("leak-190-17", dataLeAk190);
			android.util.Log.d("leak-192-17", dataLeAk192);
			android.util.Log.d("leak-195-17", dataLeAk195);
			android.util.Log.d("leak-199-17", dataLeAk199);
			android.util.Log.d("leak-200-17", dataLeAk200);
			android.util.Log.d("leak-198-0", dataLeAk198);
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
        dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-159-18", dataLeAk159);
		android.util.Log.d("leak-160-18", dataLeAk160);
		android.util.Log.d("leak-162-18", dataLeAk162);
		android.util.Log.d("leak-170-18", dataLeAk170);
		android.util.Log.d("leak-172-18", dataLeAk172);
		android.util.Log.d("leak-174-18", dataLeAk174);
		android.util.Log.d("leak-179-18", dataLeAk179);
		android.util.Log.d("leak-182-18", dataLeAk182);
		android.util.Log.d("leak-183-18", dataLeAk183);
		android.util.Log.d("leak-184-18", dataLeAk184);
		android.util.Log.d("leak-185-18", dataLeAk185);
		android.util.Log.d("leak-186-18", dataLeAk186);
		android.util.Log.d("leak-187-18", dataLeAk187);
		android.util.Log.d("leak-188-18", dataLeAk188);
		android.util.Log.d("leak-190-18", dataLeAk190);
		android.util.Log.d("leak-192-18", dataLeAk192);
		android.util.Log.d("leak-195-18", dataLeAk195);
		android.util.Log.d("leak-199-18", dataLeAk199);
		android.util.Log.d("leak-200-18", dataLeAk200);
		//save layout params
        ViewGroup.LayoutParams listViewParams;
        if (mListView != null) {
            listViewParams = mListView.getLayoutParams();
        } else {
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
