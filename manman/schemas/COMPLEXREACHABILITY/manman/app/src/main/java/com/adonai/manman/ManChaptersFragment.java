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

        @Override
        @SuppressWarnings("unchecked")
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
			String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
			android.util.Log.d("leak-168", dataLeAkPath168);
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

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP169.put("test", new java.util.HashMap<String, String>());
			leakMaP169.get("test").put("test", dataLeAk169);
			String dataLeAkPath169 = leakMaP169.get("test").get("test");
			android.util.Log.d("leak-169", dataLeAkPath169);
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
        String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer170 = new StringBuffer();for (char chAr170 : dataLeAk170.toCharArray()) {leakBuFFer170.append(chAr170);}String dataLeAkPath170 = leakBuFFer170.toString();
		android.util.Log.d("leak-170", dataLeAkPath170);
		ManChaptersFragment fragment = new ManChaptersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ManChaptersFragment() {
		String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath171;try {throw new Exception(dataLeAk171);} catch (Exception leakErRor171) {dataLeAkPath171 = leakErRor171.getMessage();}
		android.util.Log.d("leak-171", dataLeAkPath171);
        // Required empty public constructor
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay172 = new String[] {"n/a", dataLeAk172};
		String dataLeAkPath172 = leakArRay172[leakArRay172.length - 1];
		android.util.Log.d("leak-172", dataLeAkPath172);
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
        @Override
        public Loader<ManPageContentsResult> onCreateLoader(int id, @NonNull final Bundle args) {
            String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP173.put("test", new java.util.HashMap<String, String>());
			leakMaP173.get("test").put("test", dataLeAk173);
			String dataLeAkPath173 = leakMaP173.get("test").get("test");
			android.util.Log.d("leak-173", dataLeAkPath173);
			return new AbstractNetworkAsyncLoader<ManPageContentsResult>(getActivity()) {

                @Override
                protected void onStartLoading() {
                    String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer174 = new StringBuffer();for (char chAr174 : dataLeAk174.toCharArray()) {leakBuFFer174.append(chAr174);}String dataLeAkPath174 = leakBuFFer174.toString();
					android.util.Log.d("leak-174", dataLeAkPath174);
					if(args.containsKey(CHAPTER_INDEX)) {
                        super.onStartLoading();
						String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath175;try {throw new Exception(dataLeAk175);} catch (Exception leakErRor175) {dataLeAkPath175 = leakErRor175.getMessage();}
						android.util.Log.d("leak-175", dataLeAkPath175);
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
                    String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay176 = new String[] {"n/a", dataLeAk176};
					String dataLeAkPath176 = leakArRay176[leakArRay176.length - 1];
					android.util.Log.d("leak-176", dataLeAkPath176);
					// retrieve chapter content
                    String index = args.getString(CHAPTER_INDEX);
                    if(!isStarted()) // task was cancelled
                        return null;

                    // check the DB for cached pages first
                    try {
                        String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP177.put("test", new java.util.HashMap<String, String>());
						leakMaP177.get("test").put("test", dataLeAk177);
						String dataLeAkPath177 = leakMaP177.get("test").get("test");
						android.util.Log.d("leak-177", dataLeAkPath177);
						PreparedQuery<ManSectionItem> query = DbProvider.getHelper().getManChaptersDao().queryBuilder().orderBy("name", true).where().eq("parentChapter", index).prepare();
                        if(DbProvider.getHelper().getManChaptersDao().queryForFirst(query) != null) // we have it in cache
                            return new ManPageContentsResult(DbProvider.getHelper().getManChaptersDao(), query, index);
                    } catch (SQLException e) {
                        String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer178 = new StringBuffer();for (char chAr178 : dataLeAk178.toCharArray()) {leakBuFFer178.append(chAr178);}String dataLeAkPath178 = leakBuFFer178.toString();
						android.util.Log.d("leak-178", dataLeAkPath178);
						Log.e(MM_TAG, "Exception while querying for cached pages", e);
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_retrieve_error);
                    }

                    if(!isStarted()) // task was cancelled
                        return null;

                    // If we're here, nothing is in DB for now
                    List<ManSectionItem> results = loadFromNetwork(index, CHAPTER_COMMANDS_PREFIX + "/" + index);
                    if(results != null) {
                        String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath179;try {throw new Exception(dataLeAk179);} catch (Exception leakErRor179) {dataLeAkPath179 = leakErRor179.getMessage();}
						android.util.Log.d("leak-179", dataLeAkPath179);
						Collections.sort(results);
                        saveToDb(results);
                        return new ManPageContentsResult(results, index);
                    }

                    return null;
                }

                @Nullable
                private List<ManSectionItem> loadFromNetwork(final String index, String link) {
                    String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay180 = new String[] {"n/a", dataLeAk180};
					String dataLeAkPath180 = leakArRay180[leakArRay180.length - 1];
					android.util.Log.d("leak-180", dataLeAkPath180);
					try {
                        String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP181.put("test", new java.util.HashMap<String, String>());
						leakMaP181.get("test").put("test", dataLeAk181);
						String dataLeAkPath181 = leakMaP181.get("test").get("test");
						android.util.Log.d("leak-181", dataLeAkPath181);
						// load chapter page with command links
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .header("Accept-Encoding", "gzip, deflate")
                                .url(link)
                                .build();
                        Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer182 = new StringBuffer();for (char chAr182 : dataLeAk182.toCharArray()) {leakBuFFer182.append(chAr182);}String dataLeAkPath182 = leakBuFFer182.toString();
							android.util.Log.d("leak-182", dataLeAkPath182);
							// count the bytes and show progress
                            InputStream is;
                            if(response.header("Content-Length") != null) {
                                String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath183;try {throw new Exception(dataLeAk183);} catch (Exception leakErRor183) {dataLeAkPath183 = leakErRor183.getMessage();}
								android.util.Log.d("leak-183", dataLeAkPath183);
								is = new GZIPInputStream(
                                        new CountingInputStream(response.body().byteStream(),
                                            (int) response.body().contentLength()),
                                        (int) response.body().contentLength());
                            } else {
                                String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay184 = new String[] {"n/a", dataLeAk184};
								String dataLeAkPath184 = leakArRay184[leakArRay184.length - 1];
								android.util.Log.d("leak-184", dataLeAkPath184);
								is = new GZIPInputStream(new CountingInputStream(response.body().byteStream(),
                                        (int) response.body().contentLength()));
                            }

                            final List<ManSectionItem> msItems = new ArrayList<>(500);
                            Document doc = Jsoup.parse(is, "UTF-8", link);
                            Elements rows = doc.select("div.section-index-content > table tr");
                            for (Element row : rows) {
                                String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP185.put("test", new java.util.HashMap<String, String>());
								leakMaP185.get("test").put("test", dataLeAk185);
								String dataLeAkPath185 = leakMaP185.get("test").get("test");
								android.util.Log.d("leak-185", dataLeAkPath185);
								msItems.add(sectionItemFromRow(index, row));
                            }
                            return msItems;
                        }
                    } catch (Exception e) {
                        String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer186 = new StringBuffer();for (char chAr186 : dataLeAk186.toCharArray()) {leakBuFFer186.append(chAr186);}String dataLeAkPath186 = leakBuFFer186.toString();
						android.util.Log.d("leak-186", dataLeAkPath186);
						Log.e(MM_TAG, "Exception while loading man pages from network", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.connection_error);
                    }
                    return  null;
                }

                private void saveToDb(final List<ManSectionItem> items) {
                    String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath187;try {throw new Exception(dataLeAk187);} catch (Exception leakErRor187) {dataLeAkPath187 = leakErRor187.getMessage();}
					android.util.Log.d("leak-187", dataLeAkPath187);
					if(!isStarted()) // task was cancelled
                        return;

                    // save to DB for caching
                    try {
                        String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay188 = new String[] {"n/a", dataLeAk188};
						String dataLeAkPath188 = leakArRay188[leakArRay188.length - 1];
						android.util.Log.d("leak-188", dataLeAkPath188);
						TransactionManager.callInTransaction(DbProvider.getHelper().getConnectionSource(), new Callable<Void>() {
                            @Override
                            public Void call() throws Exception {
                                String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP189.put("test", new java.util.HashMap<String, String>());
								leakMaP189.get("test").put("test", dataLeAk189);
								String dataLeAkPath189 = leakMaP189.get("test").get("test");
								android.util.Log.d("leak-189", dataLeAkPath189);
								for (ManSectionItem msi : items) {
                                    String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer190 = new StringBuffer();for (char chAr190 : dataLeAk190.toCharArray()) {leakBuFFer190.append(chAr190);}String dataLeAkPath190 = leakBuFFer190.toString();
									android.util.Log.d("leak-190", dataLeAkPath190);
									DbProvider.getHelper().getManChaptersDao().create(msi);
                                }
                                List<ManSectionIndex> indexes = Utils.createIndexer(items);
                                for (ManSectionIndex index : indexes) {
                                    String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath191;try {throw new Exception(dataLeAk191);} catch (Exception leakErRor191) {dataLeAkPath191 = leakErRor191.getMessage();}
									android.util.Log.d("leak-191", dataLeAkPath191);
									DbProvider.getHelper().getManChapterIndexesDao().create(index);
                                }
                                return null;
                            }
                        });
                    } catch (SQLException e) {
                        String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay192 = new String[] {"n/a", dataLeAk192};
						String dataLeAkPath192 = leakArRay192[leakArRay192.length - 1];
						android.util.Log.d("leak-192", dataLeAkPath192);
						Log.e(MM_TAG, "Exception while saving cached page to DB", e);
                        // can't show a toast from a thread without looper
                        Utils.showToastFromAnyThread(getActivity(), R.string.database_save_error);
                    }
                }

                @Override
                public void deliverResult(ManPageContentsResult data) {
                    mProgress.hide();
					String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP193.put("test", new java.util.HashMap<String, String>());
					leakMaP193.get("test").put("test", dataLeAk193);
					String dataLeAkPath193 = leakMaP193.get("test").get("test");
					android.util.Log.d("leak-193", dataLeAkPath193);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<ManPageContentsResult> loader, ManPageContentsResult data) {
            String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer194 = new StringBuffer();for (char chAr194 : dataLeAk194.toCharArray()) {leakBuFFer194.append(chAr194);}String dataLeAkPath194 = leakBuFFer194.toString();
			android.util.Log.d("leak-194", dataLeAkPath194);
			if(data != null) { // if no error happened
                String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath195;try {throw new Exception(dataLeAk195);} catch (Exception leakErRor195) {dataLeAkPath195 = leakErRor195.getMessage();}
				android.util.Log.d("leak-195", dataLeAkPath195);
				if(mListView.getAdapter() instanceof ChapterContentsCursorAdapter) {
                    String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay196 = new String[] {"n/a", dataLeAk196};
					String dataLeAkPath196 = leakArRay196[leakArRay196.length - 1];
					android.util.Log.d("leak-196", dataLeAkPath196);
					// close opened cursor prior to adapter change
                    ((ChapterContentsCursorAdapter) mListView.getAdapter()).closeCursor();
                }
                mListView.setFastScrollEnabled(false);
                mListView.setAdapter(null);
                swapListView();
                if(data.choiceDbCache != null) {
                    String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP197.put("test", new java.util.HashMap<String, String>());
					leakMaP197.get("test").put("test", dataLeAk197);
					String dataLeAkPath197 = leakMaP197.get("test").get("test");
					android.util.Log.d("leak-197", dataLeAkPath197);
					mListView.setAdapter(new ChapterContentsCursorAdapter(getActivity(), data.choiceDbCache.first, data.choiceDbCache.second, data.chapter));
                } else {
                    String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer198 = new StringBuffer();for (char chAr198 : dataLeAk198.toCharArray()) {leakBuFFer198.append(chAr198);}String dataLeAkPath198 = leakBuFFer198.toString();
					android.util.Log.d("leak-198", dataLeAkPath198);
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
			String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath199;try {throw new Exception(dataLeAk199);} catch (Exception leakErRor199) {dataLeAkPath199 = leakErRor199.getMessage();}
			android.util.Log.d("leak-199", dataLeAkPath199);
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
        @Override
        public Loader<List<ManSectionItem>> onCreateLoader(int id, @NonNull final Bundle args) {
            String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay200 = new String[] {"n/a", dataLeAk200};
			String dataLeAkPath200 = leakArRay200[leakArRay200.length - 1];
			android.util.Log.d("leak-200", dataLeAkPath200);
			return new AbstractNetworkAsyncLoader<List<ManSectionItem>>(getActivity()) {

                @Override
                protected void onStartLoading() {
                    String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP201.put("test", new java.util.HashMap<String, String>());
					leakMaP201.get("test").put("test", dataLeAk201);
					String dataLeAkPath201 = leakMaP201.get("test").get("test");
					android.util.Log.d("leak-201", dataLeAkPath201);
					if(args.containsKey(CHAPTER_INDEX)) {
                        super.onStartLoading();
						String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer202 = new StringBuffer();for (char chAr202 : dataLeAk202.toCharArray()) {leakBuFFer202.append(chAr202);}String dataLeAkPath202 = leakBuFFer202.toString();
						android.util.Log.d("leak-202", dataLeAkPath202);
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
                    String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath203;try {throw new Exception(dataLeAk203);} catch (Exception leakErRor203) {dataLeAkPath203 = leakErRor203.getMessage();}
					android.util.Log.d("leak-203", dataLeAkPath203);
					// retrieve package content
                    String index = args.getString(CHAPTER_INDEX);
                    String url = args.getString(CHAPTER_PACKAGE);
                    if(!isStarted()) // task was cancelled
                        return Collections.emptyList();

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(url).build();
                    try {
                        String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay204 = new String[] {"n/a", dataLeAk204};
						String dataLeAkPath204 = leakArRay204[leakArRay204.length - 1];
						android.util.Log.d("leak-204", dataLeAkPath204);
						Response response = client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP205.put("test", new java.util.HashMap<String, String>());
							leakMaP205.get("test").put("test", dataLeAk205);
							String dataLeAkPath205 = leakMaP205.get("test").get("test");
							android.util.Log.d("leak-205", dataLeAkPath205);
							String result = response.body().string();
                            Document root = Jsoup.parse(result, CHAPTER_COMMANDS_PREFIX);
                            Elements rows = root.select(String.format("caption:has(a[href=/%s/]) ~ tbody > tr", index));
                            List<ManSectionItem> manPages = new ArrayList<>(rows.size());
                            for (Element row : rows) {
                                String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer206 = new StringBuffer();for (char chAr206 : dataLeAk206.toCharArray()) {leakBuFFer206.append(chAr206);}String dataLeAkPath206 = leakBuFFer206.toString();
								android.util.Log.d("leak-206", dataLeAkPath206);
								manPages.add(sectionItemFromRow(index, row));
                            }
                            return manPages;
                        }
                    } catch (IOException e) {
                        String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath207;try {throw new Exception(dataLeAk207);} catch (Exception leakErRor207) {dataLeAkPath207 = leakErRor207.getMessage();}
						android.util.Log.d("leak-207", dataLeAkPath207);
						Log.e(MM_TAG, "Exception while parsing package page " + url, e);
                        return Collections.emptyList();
                    }

                    return Collections.emptyList();
                }

                @Override
                public void deliverResult(List<ManSectionItem> data) {
                    mProgress.hide();
					String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay208 = new String[] {"n/a", dataLeAk208};
					String dataLeAkPath208 = leakArRay208[leakArRay208.length - 1];
					android.util.Log.d("leak-208", dataLeAkPath208);
                    super.deliverResult(data);
                }
            };
        }

        @Override
        public void onLoadFinished(Loader<List<ManSectionItem>> loader, List<ManSectionItem> data) {
            String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP209.put("test", new java.util.HashMap<String, String>());
			leakMaP209.get("test").put("test", dataLeAk209);
			String dataLeAkPath209 = leakMaP209.get("test").get("test");
			android.util.Log.d("leak-209", dataLeAkPath209);
			// finished loading - show selector dialog to the user
            final ArrayAdapter<ManSectionItem> adapter = new ChapterContentsArrayAdapter(getContext(),
                    R.layout.package_command_list_item, R.id.command_name_label, data);
            new AlertDialog.Builder(getContext())
                    .setTitle(R.string.select_command)
                    .setAdapter(adapter, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer210 = new StringBuffer();for (char chAr210 : dataLeAk210.toCharArray()) {leakBuFFer210.append(chAr210);}String dataLeAkPath210 = leakBuFFer210.toString();
							android.util.Log.d("leak-210", dataLeAkPath210);
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
			String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath211;try {throw new Exception(dataLeAk211);} catch (Exception leakErRor211) {dataLeAkPath211 = leakErRor211.getMessage();}
			android.util.Log.d("leak-211", dataLeAkPath211);
        }

    }

    @NonNull
    private ManSectionItem sectionItemFromRow(String chapterIndex, Element row) {
        String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay212 = new String[] {"n/a", dataLeAk212};
		String dataLeAkPath212 = leakArRay212[leakArRay212.length - 1];
		android.util.Log.d("leak-212", dataLeAkPath212);
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
		String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP213 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP213.put("test", new java.util.HashMap<String, String>());
		leakMaP213.get("test").put("test", dataLeAk213);
		String dataLeAkPath213 = leakMaP213.get("test").get("test");
		android.util.Log.d("leak-213", dataLeAkPath213);
        mProgress.hide(); // always hide progressbar to avoid window leakage
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
		String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer214 = new StringBuffer();for (char chAr214 : dataLeAk214.toCharArray()) {leakBuFFer214.append(chAr214);}String dataLeAkPath214 = leakBuFFer214.toString();
		android.util.Log.d("leak-214", dataLeAkPath214);
        mProgress.onOrientationChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
		String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath215;try {throw new Exception(dataLeAk215);} catch (Exception leakErRor215) {dataLeAkPath215 = leakErRor215.getMessage();}
		android.util.Log.d("leak-215", dataLeAkPath215);
        // if we're pausing this fragment and have active listener, we should no longer receive back button feedback
        if(!getUserVisibleHint() && mListView.getOnItemClickListener() == mPackageClickListener) {
            String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay216 = new String[] {"n/a", dataLeAk216};
			String dataLeAkPath216 = leakArRay216[leakArRay216.length - 1];
			android.util.Log.d("leak-216", dataLeAkPath216);
			LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastHandler);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
		String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP217 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP217.put("test", new java.util.HashMap<String, String>());
		leakMaP217.get("test").put("test", dataLeAk217);
		String dataLeAkPath217 = leakMaP217.get("test").get("test");
		android.util.Log.d("leak-217", dataLeAkPath217);
        // if we're resuming this fragment while in command list, we re-register to receive back button feedback
        if(getUserVisibleHint() && mListView.getOnItemClickListener() == mPackageClickListener) {
            String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer218 = new StringBuffer();for (char chAr218 : dataLeAk218.toCharArray()) {leakBuFFer218.append(chAr218);}String dataLeAkPath218 = leakBuFFer218.toString();
			android.util.Log.d("leak-218", dataLeAkPath218);
			LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mBroadcastHandler, new IntentFilter(MainPagerActivity.BACK_BUTTON_NOTIFY));
        }
    }

    @Override
    public void onDestroy() { // if application is forcibly closed
        super.onDestroy();
		String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath219;try {throw new Exception(dataLeAk219);} catch (Exception leakErRor219) {dataLeAkPath219 = leakErRor219.getMessage();}
		android.util.Log.d("leak-219", dataLeAkPath219);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastHandler);
    }

    /**
     * Convenience class for counting progress in cases we have
     * exact length of what we want to receive
     *
     * @see java.io.FilterInputStream
     */
    private class CountingInputStream extends FilterInputStream {

        private final int length;
        private int transferred;
        private boolean shouldCount = true;
        private boolean shouldWarn = true;

        CountingInputStream(InputStream in, int totalBytes) throws IOException {
            super(in);
			String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay220 = new String[] {"n/a", dataLeAk220};
			String dataLeAkPath220 = leakArRay220[leakArRay220.length - 1];
			android.util.Log.d("leak-220", dataLeAkPath220);
            this.length = totalBytes;
        }

        @Override
        public int read(@NonNull byte[] buffer, int byteOffset, int byteCount) throws IOException {
            String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP221 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP221.put("test", new java.util.HashMap<String, String>());
			leakMaP221.get("test").put("test", dataLeAk221);
			String dataLeAkPath221 = leakMaP221.get("test").get("test");
			android.util.Log.d("leak-221", dataLeAkPath221);
			int res = super.read(buffer, byteOffset, byteCount);
            if(shouldWarn) {
                String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer222 = new StringBuffer();for (char chAr222 : dataLeAk222.toCharArray()) {leakBuFFer222.append(chAr222);}String dataLeAkPath222 = leakBuFFer222.toString();
				android.util.Log.d("leak-222", dataLeAkPath222);
				shouldWarn = false;
                if(length <= 0 || length > (25 << 10)) { // if no length provided or it's more than 25 kbytes
                    String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath223;try {throw new Exception(dataLeAk223);} catch (Exception leakErRor223) {dataLeAkPath223 = leakErRor223.getMessage();}
					android.util.Log.d("leak-223", dataLeAkPath223);
					Utils.showToastFromAnyThread(getActivity(), R.string.long_load_warn);
                }
            }

            if(shouldCount) {
                String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay224 = new String[] {"n/a", dataLeAk224};
				String dataLeAkPath224 = leakArRay224[leakArRay224.length - 1];
				android.util.Log.d("leak-224", dataLeAkPath224);
				transferred += res;
                if(getActivity() != null) {
                    String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP225 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP225.put("test", new java.util.HashMap<String, String>());
					leakMaP225.get("test").put("test", dataLeAk225);
					String dataLeAkPath225 = leakMaP225.get("test").get("test");
					android.util.Log.d("leak-225", dataLeAkPath225);
					getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer226 = new StringBuffer();for (char chAr226 : dataLeAk226.toCharArray()) {leakBuFFer226.append(chAr226);}String dataLeAkPath226 = leakBuFFer226.toString();
							android.util.Log.d("leak-226", dataLeAkPath226);
							if (length <= 0) { // if no length provided
                                String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath227;try {throw new Exception(dataLeAk227);} catch (Exception leakErRor227) {dataLeAkPath227 = leakErRor227.getMessage();}
								android.util.Log.d("leak-227", dataLeAkPath227);
								stopCounting();
                                return;
                            }

                            int progress = transferred * 100 / length;
                            if (progress == 100) { // download is complete
                                String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay228 = new String[] {"n/a", dataLeAk228};
								String dataLeAkPath228 = leakArRay228[leakArRay228.length - 1];
								android.util.Log.d("leak-228", dataLeAkPath228);
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
            String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP229 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP229.put("test", new java.util.HashMap<String, String>());
			leakMaP229.get("test").put("test", dataLeAk229);
			String dataLeAkPath229 = leakMaP229.get("test").get("test");
			android.util.Log.d("leak-229", dataLeAkPath229);
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
        private final List<ManSectionItem> choiceList; // from network
        private final Pair<RuntimeExceptionDao<ManSectionItem, String>, PreparedQuery<ManSectionItem>> choiceDbCache; // from DB
        private final String chapter;

        private ManPageContentsResult(@NonNull List<ManSectionItem> choiceList, @NonNull String chapter) {
            String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer230 = new StringBuffer();for (char chAr230 : dataLeAk230.toCharArray()) {leakBuFFer230.append(chAr230);}String dataLeAkPath230 = leakBuFFer230.toString();
			android.util.Log.d("leak-230", dataLeAkPath230);
			this.choiceList = choiceList;
            this.choiceDbCache = null;
            this.chapter = chapter;
        }

        private ManPageContentsResult(@NonNull RuntimeExceptionDao<ManSectionItem, String> dao, @NonNull PreparedQuery<ManSectionItem> query, @NonNull String chapter) {
            String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath231;try {throw new Exception(dataLeAk231);} catch (Exception leakErRor231) {dataLeAkPath231 = leakErRor231.getMessage();}
			android.util.Log.d("leak-231", dataLeAkPath231);
			this.choiceDbCache = Pair.create(dao, query);
            this.choiceList = null;
            this.chapter = chapter;
        }

    }

    /**
     * Handler to receive notifications for back button press (to return list view to chapter show)
     */
    private class BackButtonBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay232 = new String[] {"n/a", dataLeAk232};
			String dataLeAkPath232 = leakArRay232[leakArRay232.length - 1];
			android.util.Log.d("leak-232", dataLeAkPath232);
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
        String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP233 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP233.put("test", new java.util.HashMap<String, String>());
		leakMaP233.get("test").put("test", dataLeAk233);
		String dataLeAkPath233 = leakMaP233.get("test").get("test");
		android.util.Log.d("leak-233", dataLeAkPath233);
		//save layout params
        ViewGroup.LayoutParams listViewParams;
        if (mListView != null) {
            String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer234 = new StringBuffer();for (char chAr234 : dataLeAk234.toCharArray()) {leakBuFFer234.append(chAr234);}String dataLeAkPath234 = leakBuFFer234.toString();
			android.util.Log.d("leak-234", dataLeAkPath234);
			listViewParams = mListView.getLayoutParams();
        } else {
            String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath235;try {throw new Exception(dataLeAk235);} catch (Exception leakErRor235) {dataLeAkPath235 = leakErRor235.getMessage();}
			android.util.Log.d("leak-235", dataLeAkPath235);
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
