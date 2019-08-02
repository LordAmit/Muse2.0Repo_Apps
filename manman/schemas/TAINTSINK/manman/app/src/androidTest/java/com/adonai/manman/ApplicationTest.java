package com.adonai.manman;


import android.app.Activity;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.adonai.manman.adapters.ChapterContentsArrayAdapter;
import com.adonai.manman.adapters.ChapterContentsCursorAdapter;
import com.adonai.manman.entities.ManPage;
import com.adonai.manman.entities.ManSectionItem;
import com.adonai.manman.entities.SearchResult;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest {

    String dataLeAk22 = "22";

	String dataLeAk20 = "20";

	String dataLeAk19 = "19";

	String dataLeAk17 = "17";

	String dataLeAk16 = "16";

	String dataLeAk14 = "14";

	String dataLeAk13 = "13";

	String dataLeAk11 = "11";

	String dataLeAk9 = "9";

	String dataLeAk8 = "8";

	String dataLeAk7 = "7";

	String dataLeAk5 = "5";

	@Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainPagerActivity.class);

    @Before
    public void unlockScreen() {
        dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-5-7", dataLeAk5);
		android.util.Log.d("leak-7-7", dataLeAk7);
		android.util.Log.d("leak-8-7", dataLeAk8);
		android.util.Log.d("leak-9-7", dataLeAk9);
		android.util.Log.d("leak-11-7", dataLeAk11);
		android.util.Log.d("leak-13-7", dataLeAk13);
		android.util.Log.d("leak-14-7", dataLeAk14);
		android.util.Log.d("leak-16-7", dataLeAk16);
		android.util.Log.d("leak-17-7", dataLeAk17);
		android.util.Log.d("leak-19-7", dataLeAk19);
		android.util.Log.d("leak-20-7", dataLeAk20);
		android.util.Log.d("leak-22-7", dataLeAk22);
		final Activity activity = mActivityRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            String dataLeAk6 = "6";

			public void run() {
                dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }

    @Before
    public void espressoPreconditions() {
        dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-5-8", dataLeAk5);
		android.util.Log.d("leak-7-8", dataLeAk7);
		android.util.Log.d("leak-8-8", dataLeAk8);
		android.util.Log.d("leak-9-8", dataLeAk9);
		android.util.Log.d("leak-11-8", dataLeAk11);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-14-8", dataLeAk14);
		android.util.Log.d("leak-16-8", dataLeAk16);
		android.util.Log.d("leak-17-8", dataLeAk17);
		android.util.Log.d("leak-19-8", dataLeAk19);
		android.util.Log.d("leak-20-8", dataLeAk20);
		android.util.Log.d("leak-22-8", dataLeAk22);
		IdlingPolicies.setMasterPolicyTimeout(10, TimeUnit.MINUTES);
    }

    @Test
    public void checkSearchForCommand() throws InterruptedException {
        dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-5-9", dataLeAk5);
		android.util.Log.d("leak-7-9", dataLeAk7);
		android.util.Log.d("leak-8-9", dataLeAk8);
		android.util.Log.d("leak-9-9", dataLeAk9);
		android.util.Log.d("leak-11-9", dataLeAk11);
		android.util.Log.d("leak-13-9", dataLeAk13);
		android.util.Log.d("leak-14-9", dataLeAk14);
		android.util.Log.d("leak-16-9", dataLeAk16);
		android.util.Log.d("leak-17-9", dataLeAk17);
		android.util.Log.d("leak-19-9", dataLeAk19);
		android.util.Log.d("leak-20-9", dataLeAk20);
		android.util.Log.d("leak-22-9", dataLeAk22);
		final Activity act = mActivityRule.getActivity();
        final ListView searchList = (ListView) act.findViewById(R.id.search_results_list);

        onView(withId(R.id.query_edit)).perform(typeText("tar"));

        // wait until list is loaded with results
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk10 = "10";

			@Override
            public Boolean call() throws Exception {
                dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				return searchList.getChildCount() > 0;
            }
        });

        // click on first result
        onData(instanceOf(SearchResult.class))
                .inAdapterView(withId(R.id.search_results_list))
                .atPosition(0)
                .check(matches(hasDescendant(withText(containsString("tar")))));

        // click on "load description"
        onView(is(searchList.getChildAt(0).findViewById(R.id.popup_menu))).perform(click());
        onView(withText(act.getResources().getString(R.string.request_description)))
                .inRoot(isPlatformPopup())
                .perform(click());

        // wait for it to load
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk12 = "12";

			@Override
            public Boolean call() throws Exception {
                dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				TextView desc = (TextView) act.findViewById(R.id.description_text_web); // first view
                return desc.getVisibility() == View.VISIBLE;
            }
        });

        // this will be tar - File Formats
        onData(instanceOf(SearchResult.class))
                .inAdapterView(withId(R.id.search_results_list))
                .atPosition(1)
                .perform(click(), click());

        // wait for page to load
        await().atMost(5, TimeUnit.SECONDS).until(new WebViewVisible(act));

        // check one of link names
        onView(withId(R.id.link_list))
                .check(matches(hasDescendant(withText("atime"))));
    }

    @Test
    public void checkChapter() throws InterruptedException {
        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-5-10", dataLeAk5);
		android.util.Log.d("leak-7-10", dataLeAk7);
		android.util.Log.d("leak-8-10", dataLeAk8);
		android.util.Log.d("leak-9-10", dataLeAk9);
		android.util.Log.d("leak-11-10", dataLeAk11);
		android.util.Log.d("leak-13-10", dataLeAk13);
		android.util.Log.d("leak-14-10", dataLeAk14);
		android.util.Log.d("leak-16-10", dataLeAk16);
		android.util.Log.d("leak-17-10", dataLeAk17);
		android.util.Log.d("leak-19-10", dataLeAk19);
		android.util.Log.d("leak-20-10", dataLeAk20);
		android.util.Log.d("leak-22-10", dataLeAk22);
		final Activity act = mActivityRule.getActivity();

        onView(withText(R.string.contents)).perform(click());
        onView(withText("General commands")).perform(click());

        // wait for page to load
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk15 = "15";

			@Override
            public Boolean call() throws Exception {
                dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				FrameLayout fl = (FrameLayout) act.findViewById(R.id.chapter_fragment_frame); // first view
                ListView lv = (ListView) fl.getChildAt(0); // can't find it with findViewById for unknown reason
                return lv != null &&
                        (lv.getAdapter() instanceof ChapterContentsArrayAdapter || lv.getAdapter() instanceof ChapterContentsCursorAdapter);
            }
        });

        onData(allOf(instanceOf(ManSectionItem.class), new ManSectionItemMatcher("at")))
                .inAdapterView(withParent(withId(R.id.chapter_fragment_frame)))
                .perform(click());

        // check one of link names
        onView(withId(R.id.link_list))
                .check(matches(hasDescendant(withText("Synopsis"))));
    }

    @Test
    public void checkLocalArchive() throws InterruptedException {
        dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-5-11", dataLeAk5);
		android.util.Log.d("leak-7-11", dataLeAk7);
		android.util.Log.d("leak-8-11", dataLeAk8);
		android.util.Log.d("leak-9-11", dataLeAk9);
		android.util.Log.d("leak-11-11", dataLeAk11);
		android.util.Log.d("leak-13-11", dataLeAk13);
		android.util.Log.d("leak-14-11", dataLeAk14);
		android.util.Log.d("leak-16-11", dataLeAk16);
		android.util.Log.d("leak-17-11", dataLeAk17);
		android.util.Log.d("leak-19-11", dataLeAk19);
		android.util.Log.d("leak-20-11", dataLeAk20);
		android.util.Log.d("leak-22-11", dataLeAk22);
		final Activity act = mActivityRule.getActivity();

        // first we need to clear archive
        final File localArchive = new File(act.getCacheDir(), "manpages.zip");
        localArchive.delete();

        onView(withText(R.string.local_storage)).perform(click());
        onView(withText(R.string.download_archive)).perform(click());
        onView(withText(android.R.string.ok)).perform(click());

        // wait for local archive to load
        await().atMost(10, TimeUnit.MINUTES).until(new Callable<Boolean>() {
            String dataLeAk18 = "18";

			@Override
            public Boolean call() throws Exception {
                dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				final ListView searchList = (ListView) act.findViewById(R.id.local_storage_page_list);
                return searchList.getChildCount() > 0;
            }
        });

        onView(withId(R.id.local_search_edit)).perform(typeText("tar"), closeSoftKeyboard());
        onView(allOf(withText("local:/man1"), hasSibling(withText("tar"))))
                .check(matches(isDisplayed()))
                .perform(click());

        // wait for page to load
        await().atMost(5, TimeUnit.SECONDS).until(new WebViewVisible(act));

        // check one of link names
        onView(withId(R.id.link_list))
                .check(matches(allOf(
                        hasDescendant(withText("SYNOPSIS")),
                        hasDescendant(withText("--blocking-factor")),
                        hasDescendant(withText("--index-file")),
                        hasDescendant(withText("--pax-option")),
                        hasDescendant(withText("--to-command")),
                        hasDescendant(withText("--uncompress")),
                        hasDescendant(withText("-G"))
                                )));
    }

    @Test
    public void checkCachedPage() throws InterruptedException {
        dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-5-12", dataLeAk5);
		android.util.Log.d("leak-7-12", dataLeAk7);
		android.util.Log.d("leak-8-12", dataLeAk8);
		android.util.Log.d("leak-9-12", dataLeAk9);
		android.util.Log.d("leak-11-12", dataLeAk11);
		android.util.Log.d("leak-13-12", dataLeAk13);
		android.util.Log.d("leak-14-12", dataLeAk14);
		android.util.Log.d("leak-16-12", dataLeAk16);
		android.util.Log.d("leak-17-12", dataLeAk17);
		android.util.Log.d("leak-19-12", dataLeAk19);
		android.util.Log.d("leak-20-12", dataLeAk20);
		android.util.Log.d("leak-22-12", dataLeAk22);
		final Activity act = mActivityRule.getActivity();
        final ListView searchList = (ListView) act.findViewById(R.id.search_results_list);

        onView(withId(R.id.query_edit)).perform(typeText("grep"));

        // wait until list is loaded with results
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk21 = "21";

			@Override
            public Boolean call() throws Exception {
                dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				return searchList.getChildCount() > 0;
            }
        });

        // click on first result
        onData(instanceOf(SearchResult.class))
                .inAdapterView(withId(R.id.search_results_list))
                .atPosition(0)
                .check(matches(hasDescendant(withText(containsString("grep")))))
                .perform(click());

        // wait for page to load
        await().atMost(5, TimeUnit.SECONDS).until(new WebViewVisible(act));

        onView(withId(R.id.man_content_web))
                .check(matches(isDisplayed()))
                .perform(pressBack())
                .perform(pressBack());

        onView(withText(R.string.cached)).perform(click());

        onData(allOf(instanceOf(ManPage.class), new ManPageMatcher("grep")))
                .inAdapterView(withId(R.id.cached_pages_list))
                .check(matches(hasDescendant(withText("https://www.mankier.com/1/grep"))));

        // click on popup overflow button
        onView(allOf(withId(R.id.popup_menu), hasSibling(withText("grep")), hasSibling(withText("https://www.mankier.com/1/grep"))))
                .perform(click());

        // click on "delete from cache"
        onView(withText(act.getResources().getString(R.string.delete)))
                .inRoot(isPlatformPopup())
                .perform(click());

        // check page actually got deleted
        onView(withId(R.id.cached_pages_list))
                .check(matches(not(hasDescendant(withText("https://www.mankier.com/1/grep")))));
    }

    private static class ManSectionItemMatcher extends BaseMatcher<ManSectionItem> {

        private final String name;

        private ManSectionItemMatcher(String name) {
            this.name = name;
			android.util.Log.d("leak-21-13", dataLeAk21);
			android.util.Log.d("leak-18-13", dataLeAk18);
			android.util.Log.d("leak-15-13", dataLeAk15);
			android.util.Log.d("leak-12-13", dataLeAk12);
			android.util.Log.d("leak-10-13", dataLeAk10);
			android.util.Log.d("leak-6-13", dataLeAk6);
			android.util.Log.d("leak-5-13", dataLeAk5);
			android.util.Log.d("leak-7-13", dataLeAk7);
			android.util.Log.d("leak-8-13", dataLeAk8);
			android.util.Log.d("leak-9-13", dataLeAk9);
			android.util.Log.d("leak-11-13", dataLeAk11);
			android.util.Log.d("leak-13-13", dataLeAk13);
			android.util.Log.d("leak-14-13", dataLeAk14);
			android.util.Log.d("leak-16-13", dataLeAk16);
			android.util.Log.d("leak-17-13", dataLeAk17);
			android.util.Log.d("leak-19-13", dataLeAk19);
			android.util.Log.d("leak-20-13", dataLeAk20);
			android.util.Log.d("leak-22-13", dataLeAk22);
			android.util.Log.d("leak-18-13", dataLeAk18);
			android.util.Log.d("leak-15-13", dataLeAk15);
			android.util.Log.d("leak-12-13", dataLeAk12);
			android.util.Log.d("leak-10-13", dataLeAk10);
			android.util.Log.d("leak-6-13", dataLeAk6);
			android.util.Log.d("leak-5-13", dataLeAk5);
			android.util.Log.d("leak-7-13", dataLeAk7);
			android.util.Log.d("leak-8-13", dataLeAk8);
			android.util.Log.d("leak-9-13", dataLeAk9);
			android.util.Log.d("leak-11-13", dataLeAk11);
			android.util.Log.d("leak-13-13", dataLeAk13);
			android.util.Log.d("leak-14-13", dataLeAk14);
			android.util.Log.d("leak-16-13", dataLeAk16);
			android.util.Log.d("leak-17-13", dataLeAk17);
			android.util.Log.d("leak-19-13", dataLeAk19);
			android.util.Log.d("leak-20-13", dataLeAk20);
			android.util.Log.d("leak-22-13", dataLeAk22);
			android.util.Log.d("leak-15-13", dataLeAk15);
			android.util.Log.d("leak-12-13", dataLeAk12);
			android.util.Log.d("leak-10-13", dataLeAk10);
			android.util.Log.d("leak-6-13", dataLeAk6);
			android.util.Log.d("leak-5-13", dataLeAk5);
			android.util.Log.d("leak-7-13", dataLeAk7);
			android.util.Log.d("leak-8-13", dataLeAk8);
			android.util.Log.d("leak-9-13", dataLeAk9);
			android.util.Log.d("leak-11-13", dataLeAk11);
			android.util.Log.d("leak-13-13", dataLeAk13);
			android.util.Log.d("leak-14-13", dataLeAk14);
			android.util.Log.d("leak-16-13", dataLeAk16);
			android.util.Log.d("leak-17-13", dataLeAk17);
			android.util.Log.d("leak-19-13", dataLeAk19);
			android.util.Log.d("leak-20-13", dataLeAk20);
			android.util.Log.d("leak-22-13", dataLeAk22);
			android.util.Log.d("leak-12-13", dataLeAk12);
			android.util.Log.d("leak-10-13", dataLeAk10);
			android.util.Log.d("leak-6-13", dataLeAk6);
			android.util.Log.d("leak-5-13", dataLeAk5);
			android.util.Log.d("leak-7-13", dataLeAk7);
			android.util.Log.d("leak-8-13", dataLeAk8);
			android.util.Log.d("leak-9-13", dataLeAk9);
			android.util.Log.d("leak-11-13", dataLeAk11);
			android.util.Log.d("leak-13-13", dataLeAk13);
			android.util.Log.d("leak-14-13", dataLeAk14);
			android.util.Log.d("leak-16-13", dataLeAk16);
			android.util.Log.d("leak-17-13", dataLeAk17);
			android.util.Log.d("leak-19-13", dataLeAk19);
			android.util.Log.d("leak-20-13", dataLeAk20);
			android.util.Log.d("leak-22-13", dataLeAk22);
			android.util.Log.d("leak-10-13", dataLeAk10);
			android.util.Log.d("leak-6-13", dataLeAk6);
			android.util.Log.d("leak-5-13", dataLeAk5);
			android.util.Log.d("leak-7-13", dataLeAk7);
			android.util.Log.d("leak-8-13", dataLeAk8);
			android.util.Log.d("leak-9-13", dataLeAk9);
			android.util.Log.d("leak-11-13", dataLeAk11);
			android.util.Log.d("leak-13-13", dataLeAk13);
			android.util.Log.d("leak-14-13", dataLeAk14);
			android.util.Log.d("leak-16-13", dataLeAk16);
			android.util.Log.d("leak-17-13", dataLeAk17);
			android.util.Log.d("leak-19-13", dataLeAk19);
			android.util.Log.d("leak-20-13", dataLeAk20);
			android.util.Log.d("leak-22-13", dataLeAk22);
			android.util.Log.d("leak-6-13", dataLeAk6);
			android.util.Log.d("leak-5-13", dataLeAk5);
			android.util.Log.d("leak-7-13", dataLeAk7);
			android.util.Log.d("leak-8-13", dataLeAk8);
			android.util.Log.d("leak-9-13", dataLeAk9);
			android.util.Log.d("leak-11-13", dataLeAk11);
			android.util.Log.d("leak-13-13", dataLeAk13);
			android.util.Log.d("leak-14-13", dataLeAk14);
			android.util.Log.d("leak-16-13", dataLeAk16);
			android.util.Log.d("leak-17-13", dataLeAk17);
			android.util.Log.d("leak-19-13", dataLeAk19);
			android.util.Log.d("leak-20-13", dataLeAk20);
			android.util.Log.d("leak-22-13", dataLeAk22);
        }

        @Override
        public boolean matches(Object item) {
            android.util.Log.d("leak-21-14", dataLeAk21);
			android.util.Log.d("leak-18-14", dataLeAk18);
			android.util.Log.d("leak-15-14", dataLeAk15);
			android.util.Log.d("leak-12-14", dataLeAk12);
			android.util.Log.d("leak-10-14", dataLeAk10);
			android.util.Log.d("leak-6-14", dataLeAk6);
			android.util.Log.d("leak-5-14", dataLeAk5);
			android.util.Log.d("leak-7-14", dataLeAk7);
			android.util.Log.d("leak-8-14", dataLeAk8);
			android.util.Log.d("leak-9-14", dataLeAk9);
			android.util.Log.d("leak-11-14", dataLeAk11);
			android.util.Log.d("leak-13-14", dataLeAk13);
			android.util.Log.d("leak-14-14", dataLeAk14);
			android.util.Log.d("leak-16-14", dataLeAk16);
			android.util.Log.d("leak-17-14", dataLeAk17);
			android.util.Log.d("leak-19-14", dataLeAk19);
			android.util.Log.d("leak-20-14", dataLeAk20);
			android.util.Log.d("leak-22-14", dataLeAk22);
			android.util.Log.d("leak-18-14", dataLeAk18);
			android.util.Log.d("leak-15-14", dataLeAk15);
			android.util.Log.d("leak-12-14", dataLeAk12);
			android.util.Log.d("leak-10-14", dataLeAk10);
			android.util.Log.d("leak-6-14", dataLeAk6);
			android.util.Log.d("leak-5-14", dataLeAk5);
			android.util.Log.d("leak-7-14", dataLeAk7);
			android.util.Log.d("leak-8-14", dataLeAk8);
			android.util.Log.d("leak-9-14", dataLeAk9);
			android.util.Log.d("leak-11-14", dataLeAk11);
			android.util.Log.d("leak-13-14", dataLeAk13);
			android.util.Log.d("leak-14-14", dataLeAk14);
			android.util.Log.d("leak-16-14", dataLeAk16);
			android.util.Log.d("leak-17-14", dataLeAk17);
			android.util.Log.d("leak-19-14", dataLeAk19);
			android.util.Log.d("leak-20-14", dataLeAk20);
			android.util.Log.d("leak-22-14", dataLeAk22);
			android.util.Log.d("leak-15-14", dataLeAk15);
			android.util.Log.d("leak-12-14", dataLeAk12);
			android.util.Log.d("leak-10-14", dataLeAk10);
			android.util.Log.d("leak-6-14", dataLeAk6);
			android.util.Log.d("leak-5-14", dataLeAk5);
			android.util.Log.d("leak-7-14", dataLeAk7);
			android.util.Log.d("leak-8-14", dataLeAk8);
			android.util.Log.d("leak-9-14", dataLeAk9);
			android.util.Log.d("leak-11-14", dataLeAk11);
			android.util.Log.d("leak-13-14", dataLeAk13);
			android.util.Log.d("leak-14-14", dataLeAk14);
			android.util.Log.d("leak-16-14", dataLeAk16);
			android.util.Log.d("leak-17-14", dataLeAk17);
			android.util.Log.d("leak-19-14", dataLeAk19);
			android.util.Log.d("leak-20-14", dataLeAk20);
			android.util.Log.d("leak-22-14", dataLeAk22);
			android.util.Log.d("leak-12-14", dataLeAk12);
			android.util.Log.d("leak-10-14", dataLeAk10);
			android.util.Log.d("leak-6-14", dataLeAk6);
			android.util.Log.d("leak-5-14", dataLeAk5);
			android.util.Log.d("leak-7-14", dataLeAk7);
			android.util.Log.d("leak-8-14", dataLeAk8);
			android.util.Log.d("leak-9-14", dataLeAk9);
			android.util.Log.d("leak-11-14", dataLeAk11);
			android.util.Log.d("leak-13-14", dataLeAk13);
			android.util.Log.d("leak-14-14", dataLeAk14);
			android.util.Log.d("leak-16-14", dataLeAk16);
			android.util.Log.d("leak-17-14", dataLeAk17);
			android.util.Log.d("leak-19-14", dataLeAk19);
			android.util.Log.d("leak-20-14", dataLeAk20);
			android.util.Log.d("leak-22-14", dataLeAk22);
			android.util.Log.d("leak-10-14", dataLeAk10);
			android.util.Log.d("leak-6-14", dataLeAk6);
			android.util.Log.d("leak-5-14", dataLeAk5);
			android.util.Log.d("leak-7-14", dataLeAk7);
			android.util.Log.d("leak-8-14", dataLeAk8);
			android.util.Log.d("leak-9-14", dataLeAk9);
			android.util.Log.d("leak-11-14", dataLeAk11);
			android.util.Log.d("leak-13-14", dataLeAk13);
			android.util.Log.d("leak-14-14", dataLeAk14);
			android.util.Log.d("leak-16-14", dataLeAk16);
			android.util.Log.d("leak-17-14", dataLeAk17);
			android.util.Log.d("leak-19-14", dataLeAk19);
			android.util.Log.d("leak-20-14", dataLeAk20);
			android.util.Log.d("leak-22-14", dataLeAk22);
			android.util.Log.d("leak-6-14", dataLeAk6);
			android.util.Log.d("leak-5-14", dataLeAk5);
			android.util.Log.d("leak-7-14", dataLeAk7);
			android.util.Log.d("leak-8-14", dataLeAk8);
			android.util.Log.d("leak-9-14", dataLeAk9);
			android.util.Log.d("leak-11-14", dataLeAk11);
			android.util.Log.d("leak-13-14", dataLeAk13);
			android.util.Log.d("leak-14-14", dataLeAk14);
			android.util.Log.d("leak-16-14", dataLeAk16);
			android.util.Log.d("leak-17-14", dataLeAk17);
			android.util.Log.d("leak-19-14", dataLeAk19);
			android.util.Log.d("leak-20-14", dataLeAk20);
			android.util.Log.d("leak-22-14", dataLeAk22);
			return item instanceof ManSectionItem && ((ManSectionItem) item).getName().equals(name);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("is a ").appendText(name);
			android.util.Log.d("leak-21-15", dataLeAk21);
			android.util.Log.d("leak-18-15", dataLeAk18);
			android.util.Log.d("leak-15-15", dataLeAk15);
			android.util.Log.d("leak-12-15", dataLeAk12);
			android.util.Log.d("leak-10-15", dataLeAk10);
			android.util.Log.d("leak-6-15", dataLeAk6);
			android.util.Log.d("leak-5-15", dataLeAk5);
			android.util.Log.d("leak-7-15", dataLeAk7);
			android.util.Log.d("leak-8-15", dataLeAk8);
			android.util.Log.d("leak-9-15", dataLeAk9);
			android.util.Log.d("leak-11-15", dataLeAk11);
			android.util.Log.d("leak-13-15", dataLeAk13);
			android.util.Log.d("leak-14-15", dataLeAk14);
			android.util.Log.d("leak-16-15", dataLeAk16);
			android.util.Log.d("leak-17-15", dataLeAk17);
			android.util.Log.d("leak-19-15", dataLeAk19);
			android.util.Log.d("leak-20-15", dataLeAk20);
			android.util.Log.d("leak-22-15", dataLeAk22);
			android.util.Log.d("leak-18-15", dataLeAk18);
			android.util.Log.d("leak-15-15", dataLeAk15);
			android.util.Log.d("leak-12-15", dataLeAk12);
			android.util.Log.d("leak-10-15", dataLeAk10);
			android.util.Log.d("leak-6-15", dataLeAk6);
			android.util.Log.d("leak-5-15", dataLeAk5);
			android.util.Log.d("leak-7-15", dataLeAk7);
			android.util.Log.d("leak-8-15", dataLeAk8);
			android.util.Log.d("leak-9-15", dataLeAk9);
			android.util.Log.d("leak-11-15", dataLeAk11);
			android.util.Log.d("leak-13-15", dataLeAk13);
			android.util.Log.d("leak-14-15", dataLeAk14);
			android.util.Log.d("leak-16-15", dataLeAk16);
			android.util.Log.d("leak-17-15", dataLeAk17);
			android.util.Log.d("leak-19-15", dataLeAk19);
			android.util.Log.d("leak-20-15", dataLeAk20);
			android.util.Log.d("leak-22-15", dataLeAk22);
			android.util.Log.d("leak-15-15", dataLeAk15);
			android.util.Log.d("leak-12-15", dataLeAk12);
			android.util.Log.d("leak-10-15", dataLeAk10);
			android.util.Log.d("leak-6-15", dataLeAk6);
			android.util.Log.d("leak-5-15", dataLeAk5);
			android.util.Log.d("leak-7-15", dataLeAk7);
			android.util.Log.d("leak-8-15", dataLeAk8);
			android.util.Log.d("leak-9-15", dataLeAk9);
			android.util.Log.d("leak-11-15", dataLeAk11);
			android.util.Log.d("leak-13-15", dataLeAk13);
			android.util.Log.d("leak-14-15", dataLeAk14);
			android.util.Log.d("leak-16-15", dataLeAk16);
			android.util.Log.d("leak-17-15", dataLeAk17);
			android.util.Log.d("leak-19-15", dataLeAk19);
			android.util.Log.d("leak-20-15", dataLeAk20);
			android.util.Log.d("leak-22-15", dataLeAk22);
			android.util.Log.d("leak-12-15", dataLeAk12);
			android.util.Log.d("leak-10-15", dataLeAk10);
			android.util.Log.d("leak-6-15", dataLeAk6);
			android.util.Log.d("leak-5-15", dataLeAk5);
			android.util.Log.d("leak-7-15", dataLeAk7);
			android.util.Log.d("leak-8-15", dataLeAk8);
			android.util.Log.d("leak-9-15", dataLeAk9);
			android.util.Log.d("leak-11-15", dataLeAk11);
			android.util.Log.d("leak-13-15", dataLeAk13);
			android.util.Log.d("leak-14-15", dataLeAk14);
			android.util.Log.d("leak-16-15", dataLeAk16);
			android.util.Log.d("leak-17-15", dataLeAk17);
			android.util.Log.d("leak-19-15", dataLeAk19);
			android.util.Log.d("leak-20-15", dataLeAk20);
			android.util.Log.d("leak-22-15", dataLeAk22);
			android.util.Log.d("leak-10-15", dataLeAk10);
			android.util.Log.d("leak-6-15", dataLeAk6);
			android.util.Log.d("leak-5-15", dataLeAk5);
			android.util.Log.d("leak-7-15", dataLeAk7);
			android.util.Log.d("leak-8-15", dataLeAk8);
			android.util.Log.d("leak-9-15", dataLeAk9);
			android.util.Log.d("leak-11-15", dataLeAk11);
			android.util.Log.d("leak-13-15", dataLeAk13);
			android.util.Log.d("leak-14-15", dataLeAk14);
			android.util.Log.d("leak-16-15", dataLeAk16);
			android.util.Log.d("leak-17-15", dataLeAk17);
			android.util.Log.d("leak-19-15", dataLeAk19);
			android.util.Log.d("leak-20-15", dataLeAk20);
			android.util.Log.d("leak-22-15", dataLeAk22);
			android.util.Log.d("leak-6-15", dataLeAk6);
			android.util.Log.d("leak-5-15", dataLeAk5);
			android.util.Log.d("leak-7-15", dataLeAk7);
			android.util.Log.d("leak-8-15", dataLeAk8);
			android.util.Log.d("leak-9-15", dataLeAk9);
			android.util.Log.d("leak-11-15", dataLeAk11);
			android.util.Log.d("leak-13-15", dataLeAk13);
			android.util.Log.d("leak-14-15", dataLeAk14);
			android.util.Log.d("leak-16-15", dataLeAk16);
			android.util.Log.d("leak-17-15", dataLeAk17);
			android.util.Log.d("leak-19-15", dataLeAk19);
			android.util.Log.d("leak-20-15", dataLeAk20);
			android.util.Log.d("leak-22-15", dataLeAk22);
        }
    }

    private static class ManPageMatcher extends BaseMatcher<ManPage> {

        private final String name;

        private ManPageMatcher(String name) {
            this.name = name;
			android.util.Log.d("leak-21-16", dataLeAk21);
			android.util.Log.d("leak-18-16", dataLeAk18);
			android.util.Log.d("leak-15-16", dataLeAk15);
			android.util.Log.d("leak-12-16", dataLeAk12);
			android.util.Log.d("leak-10-16", dataLeAk10);
			android.util.Log.d("leak-6-16", dataLeAk6);
			android.util.Log.d("leak-5-16", dataLeAk5);
			android.util.Log.d("leak-7-16", dataLeAk7);
			android.util.Log.d("leak-8-16", dataLeAk8);
			android.util.Log.d("leak-9-16", dataLeAk9);
			android.util.Log.d("leak-11-16", dataLeAk11);
			android.util.Log.d("leak-13-16", dataLeAk13);
			android.util.Log.d("leak-14-16", dataLeAk14);
			android.util.Log.d("leak-16-16", dataLeAk16);
			android.util.Log.d("leak-17-16", dataLeAk17);
			android.util.Log.d("leak-19-16", dataLeAk19);
			android.util.Log.d("leak-20-16", dataLeAk20);
			android.util.Log.d("leak-22-16", dataLeAk22);
			android.util.Log.d("leak-21-16", dataLeAk21);
			android.util.Log.d("leak-18-16", dataLeAk18);
			android.util.Log.d("leak-15-16", dataLeAk15);
			android.util.Log.d("leak-12-16", dataLeAk12);
			android.util.Log.d("leak-10-16", dataLeAk10);
			android.util.Log.d("leak-6-16", dataLeAk6);
			android.util.Log.d("leak-5-16", dataLeAk5);
			android.util.Log.d("leak-7-16", dataLeAk7);
			android.util.Log.d("leak-8-16", dataLeAk8);
			android.util.Log.d("leak-9-16", dataLeAk9);
			android.util.Log.d("leak-11-16", dataLeAk11);
			android.util.Log.d("leak-13-16", dataLeAk13);
			android.util.Log.d("leak-14-16", dataLeAk14);
			android.util.Log.d("leak-16-16", dataLeAk16);
			android.util.Log.d("leak-17-16", dataLeAk17);
			android.util.Log.d("leak-19-16", dataLeAk19);
			android.util.Log.d("leak-20-16", dataLeAk20);
			android.util.Log.d("leak-22-16", dataLeAk22);
			android.util.Log.d("leak-18-16", dataLeAk18);
			android.util.Log.d("leak-15-16", dataLeAk15);
			android.util.Log.d("leak-12-16", dataLeAk12);
			android.util.Log.d("leak-10-16", dataLeAk10);
			android.util.Log.d("leak-6-16", dataLeAk6);
			android.util.Log.d("leak-5-16", dataLeAk5);
			android.util.Log.d("leak-7-16", dataLeAk7);
			android.util.Log.d("leak-8-16", dataLeAk8);
			android.util.Log.d("leak-9-16", dataLeAk9);
			android.util.Log.d("leak-11-16", dataLeAk11);
			android.util.Log.d("leak-13-16", dataLeAk13);
			android.util.Log.d("leak-14-16", dataLeAk14);
			android.util.Log.d("leak-16-16", dataLeAk16);
			android.util.Log.d("leak-17-16", dataLeAk17);
			android.util.Log.d("leak-19-16", dataLeAk19);
			android.util.Log.d("leak-20-16", dataLeAk20);
			android.util.Log.d("leak-22-16", dataLeAk22);
			android.util.Log.d("leak-15-16", dataLeAk15);
			android.util.Log.d("leak-12-16", dataLeAk12);
			android.util.Log.d("leak-10-16", dataLeAk10);
			android.util.Log.d("leak-6-16", dataLeAk6);
			android.util.Log.d("leak-5-16", dataLeAk5);
			android.util.Log.d("leak-7-16", dataLeAk7);
			android.util.Log.d("leak-8-16", dataLeAk8);
			android.util.Log.d("leak-9-16", dataLeAk9);
			android.util.Log.d("leak-11-16", dataLeAk11);
			android.util.Log.d("leak-13-16", dataLeAk13);
			android.util.Log.d("leak-14-16", dataLeAk14);
			android.util.Log.d("leak-16-16", dataLeAk16);
			android.util.Log.d("leak-17-16", dataLeAk17);
			android.util.Log.d("leak-19-16", dataLeAk19);
			android.util.Log.d("leak-20-16", dataLeAk20);
			android.util.Log.d("leak-22-16", dataLeAk22);
			android.util.Log.d("leak-12-16", dataLeAk12);
			android.util.Log.d("leak-10-16", dataLeAk10);
			android.util.Log.d("leak-6-16", dataLeAk6);
			android.util.Log.d("leak-5-16", dataLeAk5);
			android.util.Log.d("leak-7-16", dataLeAk7);
			android.util.Log.d("leak-8-16", dataLeAk8);
			android.util.Log.d("leak-9-16", dataLeAk9);
			android.util.Log.d("leak-11-16", dataLeAk11);
			android.util.Log.d("leak-13-16", dataLeAk13);
			android.util.Log.d("leak-14-16", dataLeAk14);
			android.util.Log.d("leak-16-16", dataLeAk16);
			android.util.Log.d("leak-17-16", dataLeAk17);
			android.util.Log.d("leak-19-16", dataLeAk19);
			android.util.Log.d("leak-20-16", dataLeAk20);
			android.util.Log.d("leak-22-16", dataLeAk22);
			android.util.Log.d("leak-10-16", dataLeAk10);
			android.util.Log.d("leak-6-16", dataLeAk6);
			android.util.Log.d("leak-5-16", dataLeAk5);
			android.util.Log.d("leak-7-16", dataLeAk7);
			android.util.Log.d("leak-8-16", dataLeAk8);
			android.util.Log.d("leak-9-16", dataLeAk9);
			android.util.Log.d("leak-11-16", dataLeAk11);
			android.util.Log.d("leak-13-16", dataLeAk13);
			android.util.Log.d("leak-14-16", dataLeAk14);
			android.util.Log.d("leak-16-16", dataLeAk16);
			android.util.Log.d("leak-17-16", dataLeAk17);
			android.util.Log.d("leak-19-16", dataLeAk19);
			android.util.Log.d("leak-20-16", dataLeAk20);
			android.util.Log.d("leak-22-16", dataLeAk22);
			android.util.Log.d("leak-6-16", dataLeAk6);
			android.util.Log.d("leak-5-16", dataLeAk5);
			android.util.Log.d("leak-7-16", dataLeAk7);
			android.util.Log.d("leak-8-16", dataLeAk8);
			android.util.Log.d("leak-9-16", dataLeAk9);
			android.util.Log.d("leak-11-16", dataLeAk11);
			android.util.Log.d("leak-13-16", dataLeAk13);
			android.util.Log.d("leak-14-16", dataLeAk14);
			android.util.Log.d("leak-16-16", dataLeAk16);
			android.util.Log.d("leak-17-16", dataLeAk17);
			android.util.Log.d("leak-19-16", dataLeAk19);
			android.util.Log.d("leak-20-16", dataLeAk20);
			android.util.Log.d("leak-22-16", dataLeAk22);
        }

        @Override
        public boolean matches(Object item) {
            android.util.Log.d("leak-21-17", dataLeAk21);
			android.util.Log.d("leak-18-17", dataLeAk18);
			android.util.Log.d("leak-15-17", dataLeAk15);
			android.util.Log.d("leak-12-17", dataLeAk12);
			android.util.Log.d("leak-10-17", dataLeAk10);
			android.util.Log.d("leak-6-17", dataLeAk6);
			android.util.Log.d("leak-5-17", dataLeAk5);
			android.util.Log.d("leak-7-17", dataLeAk7);
			android.util.Log.d("leak-8-17", dataLeAk8);
			android.util.Log.d("leak-9-17", dataLeAk9);
			android.util.Log.d("leak-11-17", dataLeAk11);
			android.util.Log.d("leak-13-17", dataLeAk13);
			android.util.Log.d("leak-14-17", dataLeAk14);
			android.util.Log.d("leak-16-17", dataLeAk16);
			android.util.Log.d("leak-17-17", dataLeAk17);
			android.util.Log.d("leak-19-17", dataLeAk19);
			android.util.Log.d("leak-20-17", dataLeAk20);
			android.util.Log.d("leak-22-17", dataLeAk22);
			android.util.Log.d("leak-21-17", dataLeAk21);
			android.util.Log.d("leak-18-17", dataLeAk18);
			android.util.Log.d("leak-15-17", dataLeAk15);
			android.util.Log.d("leak-12-17", dataLeAk12);
			android.util.Log.d("leak-10-17", dataLeAk10);
			android.util.Log.d("leak-6-17", dataLeAk6);
			android.util.Log.d("leak-5-17", dataLeAk5);
			android.util.Log.d("leak-7-17", dataLeAk7);
			android.util.Log.d("leak-8-17", dataLeAk8);
			android.util.Log.d("leak-9-17", dataLeAk9);
			android.util.Log.d("leak-11-17", dataLeAk11);
			android.util.Log.d("leak-13-17", dataLeAk13);
			android.util.Log.d("leak-14-17", dataLeAk14);
			android.util.Log.d("leak-16-17", dataLeAk16);
			android.util.Log.d("leak-17-17", dataLeAk17);
			android.util.Log.d("leak-19-17", dataLeAk19);
			android.util.Log.d("leak-20-17", dataLeAk20);
			android.util.Log.d("leak-22-17", dataLeAk22);
			android.util.Log.d("leak-18-17", dataLeAk18);
			android.util.Log.d("leak-15-17", dataLeAk15);
			android.util.Log.d("leak-12-17", dataLeAk12);
			android.util.Log.d("leak-10-17", dataLeAk10);
			android.util.Log.d("leak-6-17", dataLeAk6);
			android.util.Log.d("leak-5-17", dataLeAk5);
			android.util.Log.d("leak-7-17", dataLeAk7);
			android.util.Log.d("leak-8-17", dataLeAk8);
			android.util.Log.d("leak-9-17", dataLeAk9);
			android.util.Log.d("leak-11-17", dataLeAk11);
			android.util.Log.d("leak-13-17", dataLeAk13);
			android.util.Log.d("leak-14-17", dataLeAk14);
			android.util.Log.d("leak-16-17", dataLeAk16);
			android.util.Log.d("leak-17-17", dataLeAk17);
			android.util.Log.d("leak-19-17", dataLeAk19);
			android.util.Log.d("leak-20-17", dataLeAk20);
			android.util.Log.d("leak-22-17", dataLeAk22);
			android.util.Log.d("leak-15-17", dataLeAk15);
			android.util.Log.d("leak-12-17", dataLeAk12);
			android.util.Log.d("leak-10-17", dataLeAk10);
			android.util.Log.d("leak-6-17", dataLeAk6);
			android.util.Log.d("leak-5-17", dataLeAk5);
			android.util.Log.d("leak-7-17", dataLeAk7);
			android.util.Log.d("leak-8-17", dataLeAk8);
			android.util.Log.d("leak-9-17", dataLeAk9);
			android.util.Log.d("leak-11-17", dataLeAk11);
			android.util.Log.d("leak-13-17", dataLeAk13);
			android.util.Log.d("leak-14-17", dataLeAk14);
			android.util.Log.d("leak-16-17", dataLeAk16);
			android.util.Log.d("leak-17-17", dataLeAk17);
			android.util.Log.d("leak-19-17", dataLeAk19);
			android.util.Log.d("leak-20-17", dataLeAk20);
			android.util.Log.d("leak-22-17", dataLeAk22);
			android.util.Log.d("leak-12-17", dataLeAk12);
			android.util.Log.d("leak-10-17", dataLeAk10);
			android.util.Log.d("leak-6-17", dataLeAk6);
			android.util.Log.d("leak-5-17", dataLeAk5);
			android.util.Log.d("leak-7-17", dataLeAk7);
			android.util.Log.d("leak-8-17", dataLeAk8);
			android.util.Log.d("leak-9-17", dataLeAk9);
			android.util.Log.d("leak-11-17", dataLeAk11);
			android.util.Log.d("leak-13-17", dataLeAk13);
			android.util.Log.d("leak-14-17", dataLeAk14);
			android.util.Log.d("leak-16-17", dataLeAk16);
			android.util.Log.d("leak-17-17", dataLeAk17);
			android.util.Log.d("leak-19-17", dataLeAk19);
			android.util.Log.d("leak-20-17", dataLeAk20);
			android.util.Log.d("leak-22-17", dataLeAk22);
			android.util.Log.d("leak-10-17", dataLeAk10);
			android.util.Log.d("leak-6-17", dataLeAk6);
			android.util.Log.d("leak-5-17", dataLeAk5);
			android.util.Log.d("leak-7-17", dataLeAk7);
			android.util.Log.d("leak-8-17", dataLeAk8);
			android.util.Log.d("leak-9-17", dataLeAk9);
			android.util.Log.d("leak-11-17", dataLeAk11);
			android.util.Log.d("leak-13-17", dataLeAk13);
			android.util.Log.d("leak-14-17", dataLeAk14);
			android.util.Log.d("leak-16-17", dataLeAk16);
			android.util.Log.d("leak-17-17", dataLeAk17);
			android.util.Log.d("leak-19-17", dataLeAk19);
			android.util.Log.d("leak-20-17", dataLeAk20);
			android.util.Log.d("leak-22-17", dataLeAk22);
			android.util.Log.d("leak-6-17", dataLeAk6);
			android.util.Log.d("leak-5-17", dataLeAk5);
			android.util.Log.d("leak-7-17", dataLeAk7);
			android.util.Log.d("leak-8-17", dataLeAk8);
			android.util.Log.d("leak-9-17", dataLeAk9);
			android.util.Log.d("leak-11-17", dataLeAk11);
			android.util.Log.d("leak-13-17", dataLeAk13);
			android.util.Log.d("leak-14-17", dataLeAk14);
			android.util.Log.d("leak-16-17", dataLeAk16);
			android.util.Log.d("leak-17-17", dataLeAk17);
			android.util.Log.d("leak-19-17", dataLeAk19);
			android.util.Log.d("leak-20-17", dataLeAk20);
			android.util.Log.d("leak-22-17", dataLeAk22);
			return item instanceof ManPage && ((ManPage) item).getName().equals(name);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("is a ").appendText(name);
			android.util.Log.d("leak-21-18", dataLeAk21);
			android.util.Log.d("leak-18-18", dataLeAk18);
			android.util.Log.d("leak-15-18", dataLeAk15);
			android.util.Log.d("leak-12-18", dataLeAk12);
			android.util.Log.d("leak-10-18", dataLeAk10);
			android.util.Log.d("leak-6-18", dataLeAk6);
			android.util.Log.d("leak-5-18", dataLeAk5);
			android.util.Log.d("leak-7-18", dataLeAk7);
			android.util.Log.d("leak-8-18", dataLeAk8);
			android.util.Log.d("leak-9-18", dataLeAk9);
			android.util.Log.d("leak-11-18", dataLeAk11);
			android.util.Log.d("leak-13-18", dataLeAk13);
			android.util.Log.d("leak-14-18", dataLeAk14);
			android.util.Log.d("leak-16-18", dataLeAk16);
			android.util.Log.d("leak-17-18", dataLeAk17);
			android.util.Log.d("leak-19-18", dataLeAk19);
			android.util.Log.d("leak-20-18", dataLeAk20);
			android.util.Log.d("leak-22-18", dataLeAk22);
			android.util.Log.d("leak-21-18", dataLeAk21);
			android.util.Log.d("leak-18-18", dataLeAk18);
			android.util.Log.d("leak-15-18", dataLeAk15);
			android.util.Log.d("leak-12-18", dataLeAk12);
			android.util.Log.d("leak-10-18", dataLeAk10);
			android.util.Log.d("leak-6-18", dataLeAk6);
			android.util.Log.d("leak-5-18", dataLeAk5);
			android.util.Log.d("leak-7-18", dataLeAk7);
			android.util.Log.d("leak-8-18", dataLeAk8);
			android.util.Log.d("leak-9-18", dataLeAk9);
			android.util.Log.d("leak-11-18", dataLeAk11);
			android.util.Log.d("leak-13-18", dataLeAk13);
			android.util.Log.d("leak-14-18", dataLeAk14);
			android.util.Log.d("leak-16-18", dataLeAk16);
			android.util.Log.d("leak-17-18", dataLeAk17);
			android.util.Log.d("leak-19-18", dataLeAk19);
			android.util.Log.d("leak-20-18", dataLeAk20);
			android.util.Log.d("leak-22-18", dataLeAk22);
			android.util.Log.d("leak-18-18", dataLeAk18);
			android.util.Log.d("leak-15-18", dataLeAk15);
			android.util.Log.d("leak-12-18", dataLeAk12);
			android.util.Log.d("leak-10-18", dataLeAk10);
			android.util.Log.d("leak-6-18", dataLeAk6);
			android.util.Log.d("leak-5-18", dataLeAk5);
			android.util.Log.d("leak-7-18", dataLeAk7);
			android.util.Log.d("leak-8-18", dataLeAk8);
			android.util.Log.d("leak-9-18", dataLeAk9);
			android.util.Log.d("leak-11-18", dataLeAk11);
			android.util.Log.d("leak-13-18", dataLeAk13);
			android.util.Log.d("leak-14-18", dataLeAk14);
			android.util.Log.d("leak-16-18", dataLeAk16);
			android.util.Log.d("leak-17-18", dataLeAk17);
			android.util.Log.d("leak-19-18", dataLeAk19);
			android.util.Log.d("leak-20-18", dataLeAk20);
			android.util.Log.d("leak-22-18", dataLeAk22);
			android.util.Log.d("leak-15-18", dataLeAk15);
			android.util.Log.d("leak-12-18", dataLeAk12);
			android.util.Log.d("leak-10-18", dataLeAk10);
			android.util.Log.d("leak-6-18", dataLeAk6);
			android.util.Log.d("leak-5-18", dataLeAk5);
			android.util.Log.d("leak-7-18", dataLeAk7);
			android.util.Log.d("leak-8-18", dataLeAk8);
			android.util.Log.d("leak-9-18", dataLeAk9);
			android.util.Log.d("leak-11-18", dataLeAk11);
			android.util.Log.d("leak-13-18", dataLeAk13);
			android.util.Log.d("leak-14-18", dataLeAk14);
			android.util.Log.d("leak-16-18", dataLeAk16);
			android.util.Log.d("leak-17-18", dataLeAk17);
			android.util.Log.d("leak-19-18", dataLeAk19);
			android.util.Log.d("leak-20-18", dataLeAk20);
			android.util.Log.d("leak-22-18", dataLeAk22);
			android.util.Log.d("leak-12-18", dataLeAk12);
			android.util.Log.d("leak-10-18", dataLeAk10);
			android.util.Log.d("leak-6-18", dataLeAk6);
			android.util.Log.d("leak-5-18", dataLeAk5);
			android.util.Log.d("leak-7-18", dataLeAk7);
			android.util.Log.d("leak-8-18", dataLeAk8);
			android.util.Log.d("leak-9-18", dataLeAk9);
			android.util.Log.d("leak-11-18", dataLeAk11);
			android.util.Log.d("leak-13-18", dataLeAk13);
			android.util.Log.d("leak-14-18", dataLeAk14);
			android.util.Log.d("leak-16-18", dataLeAk16);
			android.util.Log.d("leak-17-18", dataLeAk17);
			android.util.Log.d("leak-19-18", dataLeAk19);
			android.util.Log.d("leak-20-18", dataLeAk20);
			android.util.Log.d("leak-22-18", dataLeAk22);
			android.util.Log.d("leak-10-18", dataLeAk10);
			android.util.Log.d("leak-6-18", dataLeAk6);
			android.util.Log.d("leak-5-18", dataLeAk5);
			android.util.Log.d("leak-7-18", dataLeAk7);
			android.util.Log.d("leak-8-18", dataLeAk8);
			android.util.Log.d("leak-9-18", dataLeAk9);
			android.util.Log.d("leak-11-18", dataLeAk11);
			android.util.Log.d("leak-13-18", dataLeAk13);
			android.util.Log.d("leak-14-18", dataLeAk14);
			android.util.Log.d("leak-16-18", dataLeAk16);
			android.util.Log.d("leak-17-18", dataLeAk17);
			android.util.Log.d("leak-19-18", dataLeAk19);
			android.util.Log.d("leak-20-18", dataLeAk20);
			android.util.Log.d("leak-22-18", dataLeAk22);
			android.util.Log.d("leak-6-18", dataLeAk6);
			android.util.Log.d("leak-5-18", dataLeAk5);
			android.util.Log.d("leak-7-18", dataLeAk7);
			android.util.Log.d("leak-8-18", dataLeAk8);
			android.util.Log.d("leak-9-18", dataLeAk9);
			android.util.Log.d("leak-11-18", dataLeAk11);
			android.util.Log.d("leak-13-18", dataLeAk13);
			android.util.Log.d("leak-14-18", dataLeAk14);
			android.util.Log.d("leak-16-18", dataLeAk16);
			android.util.Log.d("leak-17-18", dataLeAk17);
			android.util.Log.d("leak-19-18", dataLeAk19);
			android.util.Log.d("leak-20-18", dataLeAk20);
			android.util.Log.d("leak-22-18", dataLeAk22);
        }
    }

    private static class WebViewVisible implements Callable<Boolean> {
        private final Activity act;

        public WebViewVisible(Activity act) {
            this.act = act;
			android.util.Log.d("leak-21-19", dataLeAk21);
			android.util.Log.d("leak-18-19", dataLeAk18);
			android.util.Log.d("leak-15-19", dataLeAk15);
			android.util.Log.d("leak-12-19", dataLeAk12);
			android.util.Log.d("leak-10-19", dataLeAk10);
			android.util.Log.d("leak-6-19", dataLeAk6);
			android.util.Log.d("leak-5-19", dataLeAk5);
			android.util.Log.d("leak-7-19", dataLeAk7);
			android.util.Log.d("leak-8-19", dataLeAk8);
			android.util.Log.d("leak-9-19", dataLeAk9);
			android.util.Log.d("leak-11-19", dataLeAk11);
			android.util.Log.d("leak-13-19", dataLeAk13);
			android.util.Log.d("leak-14-19", dataLeAk14);
			android.util.Log.d("leak-16-19", dataLeAk16);
			android.util.Log.d("leak-17-19", dataLeAk17);
			android.util.Log.d("leak-19-19", dataLeAk19);
			android.util.Log.d("leak-20-19", dataLeAk20);
			android.util.Log.d("leak-22-19", dataLeAk22);
			android.util.Log.d("leak-21-19", dataLeAk21);
			android.util.Log.d("leak-18-19", dataLeAk18);
			android.util.Log.d("leak-15-19", dataLeAk15);
			android.util.Log.d("leak-12-19", dataLeAk12);
			android.util.Log.d("leak-10-19", dataLeAk10);
			android.util.Log.d("leak-6-19", dataLeAk6);
			android.util.Log.d("leak-5-19", dataLeAk5);
			android.util.Log.d("leak-7-19", dataLeAk7);
			android.util.Log.d("leak-8-19", dataLeAk8);
			android.util.Log.d("leak-9-19", dataLeAk9);
			android.util.Log.d("leak-11-19", dataLeAk11);
			android.util.Log.d("leak-13-19", dataLeAk13);
			android.util.Log.d("leak-14-19", dataLeAk14);
			android.util.Log.d("leak-16-19", dataLeAk16);
			android.util.Log.d("leak-17-19", dataLeAk17);
			android.util.Log.d("leak-19-19", dataLeAk19);
			android.util.Log.d("leak-20-19", dataLeAk20);
			android.util.Log.d("leak-22-19", dataLeAk22);
			android.util.Log.d("leak-21-19", dataLeAk21);
			android.util.Log.d("leak-18-19", dataLeAk18);
			android.util.Log.d("leak-15-19", dataLeAk15);
			android.util.Log.d("leak-12-19", dataLeAk12);
			android.util.Log.d("leak-10-19", dataLeAk10);
			android.util.Log.d("leak-6-19", dataLeAk6);
			android.util.Log.d("leak-5-19", dataLeAk5);
			android.util.Log.d("leak-7-19", dataLeAk7);
			android.util.Log.d("leak-8-19", dataLeAk8);
			android.util.Log.d("leak-9-19", dataLeAk9);
			android.util.Log.d("leak-11-19", dataLeAk11);
			android.util.Log.d("leak-13-19", dataLeAk13);
			android.util.Log.d("leak-14-19", dataLeAk14);
			android.util.Log.d("leak-16-19", dataLeAk16);
			android.util.Log.d("leak-17-19", dataLeAk17);
			android.util.Log.d("leak-19-19", dataLeAk19);
			android.util.Log.d("leak-20-19", dataLeAk20);
			android.util.Log.d("leak-22-19", dataLeAk22);
			android.util.Log.d("leak-18-19", dataLeAk18);
			android.util.Log.d("leak-15-19", dataLeAk15);
			android.util.Log.d("leak-12-19", dataLeAk12);
			android.util.Log.d("leak-10-19", dataLeAk10);
			android.util.Log.d("leak-6-19", dataLeAk6);
			android.util.Log.d("leak-5-19", dataLeAk5);
			android.util.Log.d("leak-7-19", dataLeAk7);
			android.util.Log.d("leak-8-19", dataLeAk8);
			android.util.Log.d("leak-9-19", dataLeAk9);
			android.util.Log.d("leak-11-19", dataLeAk11);
			android.util.Log.d("leak-13-19", dataLeAk13);
			android.util.Log.d("leak-14-19", dataLeAk14);
			android.util.Log.d("leak-16-19", dataLeAk16);
			android.util.Log.d("leak-17-19", dataLeAk17);
			android.util.Log.d("leak-19-19", dataLeAk19);
			android.util.Log.d("leak-20-19", dataLeAk20);
			android.util.Log.d("leak-22-19", dataLeAk22);
			android.util.Log.d("leak-15-19", dataLeAk15);
			android.util.Log.d("leak-12-19", dataLeAk12);
			android.util.Log.d("leak-10-19", dataLeAk10);
			android.util.Log.d("leak-6-19", dataLeAk6);
			android.util.Log.d("leak-5-19", dataLeAk5);
			android.util.Log.d("leak-7-19", dataLeAk7);
			android.util.Log.d("leak-8-19", dataLeAk8);
			android.util.Log.d("leak-9-19", dataLeAk9);
			android.util.Log.d("leak-11-19", dataLeAk11);
			android.util.Log.d("leak-13-19", dataLeAk13);
			android.util.Log.d("leak-14-19", dataLeAk14);
			android.util.Log.d("leak-16-19", dataLeAk16);
			android.util.Log.d("leak-17-19", dataLeAk17);
			android.util.Log.d("leak-19-19", dataLeAk19);
			android.util.Log.d("leak-20-19", dataLeAk20);
			android.util.Log.d("leak-22-19", dataLeAk22);
			android.util.Log.d("leak-12-19", dataLeAk12);
			android.util.Log.d("leak-10-19", dataLeAk10);
			android.util.Log.d("leak-6-19", dataLeAk6);
			android.util.Log.d("leak-5-19", dataLeAk5);
			android.util.Log.d("leak-7-19", dataLeAk7);
			android.util.Log.d("leak-8-19", dataLeAk8);
			android.util.Log.d("leak-9-19", dataLeAk9);
			android.util.Log.d("leak-11-19", dataLeAk11);
			android.util.Log.d("leak-13-19", dataLeAk13);
			android.util.Log.d("leak-14-19", dataLeAk14);
			android.util.Log.d("leak-16-19", dataLeAk16);
			android.util.Log.d("leak-17-19", dataLeAk17);
			android.util.Log.d("leak-19-19", dataLeAk19);
			android.util.Log.d("leak-20-19", dataLeAk20);
			android.util.Log.d("leak-22-19", dataLeAk22);
			android.util.Log.d("leak-10-19", dataLeAk10);
			android.util.Log.d("leak-6-19", dataLeAk6);
			android.util.Log.d("leak-5-19", dataLeAk5);
			android.util.Log.d("leak-7-19", dataLeAk7);
			android.util.Log.d("leak-8-19", dataLeAk8);
			android.util.Log.d("leak-9-19", dataLeAk9);
			android.util.Log.d("leak-11-19", dataLeAk11);
			android.util.Log.d("leak-13-19", dataLeAk13);
			android.util.Log.d("leak-14-19", dataLeAk14);
			android.util.Log.d("leak-16-19", dataLeAk16);
			android.util.Log.d("leak-17-19", dataLeAk17);
			android.util.Log.d("leak-19-19", dataLeAk19);
			android.util.Log.d("leak-20-19", dataLeAk20);
			android.util.Log.d("leak-22-19", dataLeAk22);
			android.util.Log.d("leak-6-19", dataLeAk6);
			android.util.Log.d("leak-5-19", dataLeAk5);
			android.util.Log.d("leak-7-19", dataLeAk7);
			android.util.Log.d("leak-8-19", dataLeAk8);
			android.util.Log.d("leak-9-19", dataLeAk9);
			android.util.Log.d("leak-11-19", dataLeAk11);
			android.util.Log.d("leak-13-19", dataLeAk13);
			android.util.Log.d("leak-14-19", dataLeAk14);
			android.util.Log.d("leak-16-19", dataLeAk16);
			android.util.Log.d("leak-17-19", dataLeAk17);
			android.util.Log.d("leak-19-19", dataLeAk19);
			android.util.Log.d("leak-20-19", dataLeAk20);
			android.util.Log.d("leak-22-19", dataLeAk22);
        }

        @Override
        public Boolean call() throws Exception {
            android.util.Log.d("leak-21-20", dataLeAk21);
			android.util.Log.d("leak-18-20", dataLeAk18);
			android.util.Log.d("leak-15-20", dataLeAk15);
			android.util.Log.d("leak-12-20", dataLeAk12);
			android.util.Log.d("leak-10-20", dataLeAk10);
			android.util.Log.d("leak-6-20", dataLeAk6);
			android.util.Log.d("leak-5-20", dataLeAk5);
			android.util.Log.d("leak-7-20", dataLeAk7);
			android.util.Log.d("leak-8-20", dataLeAk8);
			android.util.Log.d("leak-9-20", dataLeAk9);
			android.util.Log.d("leak-11-20", dataLeAk11);
			android.util.Log.d("leak-13-20", dataLeAk13);
			android.util.Log.d("leak-14-20", dataLeAk14);
			android.util.Log.d("leak-16-20", dataLeAk16);
			android.util.Log.d("leak-17-20", dataLeAk17);
			android.util.Log.d("leak-19-20", dataLeAk19);
			android.util.Log.d("leak-20-20", dataLeAk20);
			android.util.Log.d("leak-22-20", dataLeAk22);
			android.util.Log.d("leak-21-20", dataLeAk21);
			android.util.Log.d("leak-18-20", dataLeAk18);
			android.util.Log.d("leak-15-20", dataLeAk15);
			android.util.Log.d("leak-12-20", dataLeAk12);
			android.util.Log.d("leak-10-20", dataLeAk10);
			android.util.Log.d("leak-6-20", dataLeAk6);
			android.util.Log.d("leak-5-20", dataLeAk5);
			android.util.Log.d("leak-7-20", dataLeAk7);
			android.util.Log.d("leak-8-20", dataLeAk8);
			android.util.Log.d("leak-9-20", dataLeAk9);
			android.util.Log.d("leak-11-20", dataLeAk11);
			android.util.Log.d("leak-13-20", dataLeAk13);
			android.util.Log.d("leak-14-20", dataLeAk14);
			android.util.Log.d("leak-16-20", dataLeAk16);
			android.util.Log.d("leak-17-20", dataLeAk17);
			android.util.Log.d("leak-19-20", dataLeAk19);
			android.util.Log.d("leak-20-20", dataLeAk20);
			android.util.Log.d("leak-22-20", dataLeAk22);
			android.util.Log.d("leak-21-20", dataLeAk21);
			android.util.Log.d("leak-18-20", dataLeAk18);
			android.util.Log.d("leak-15-20", dataLeAk15);
			android.util.Log.d("leak-12-20", dataLeAk12);
			android.util.Log.d("leak-10-20", dataLeAk10);
			android.util.Log.d("leak-6-20", dataLeAk6);
			android.util.Log.d("leak-5-20", dataLeAk5);
			android.util.Log.d("leak-7-20", dataLeAk7);
			android.util.Log.d("leak-8-20", dataLeAk8);
			android.util.Log.d("leak-9-20", dataLeAk9);
			android.util.Log.d("leak-11-20", dataLeAk11);
			android.util.Log.d("leak-13-20", dataLeAk13);
			android.util.Log.d("leak-14-20", dataLeAk14);
			android.util.Log.d("leak-16-20", dataLeAk16);
			android.util.Log.d("leak-17-20", dataLeAk17);
			android.util.Log.d("leak-19-20", dataLeAk19);
			android.util.Log.d("leak-20-20", dataLeAk20);
			android.util.Log.d("leak-22-20", dataLeAk22);
			android.util.Log.d("leak-18-20", dataLeAk18);
			android.util.Log.d("leak-15-20", dataLeAk15);
			android.util.Log.d("leak-12-20", dataLeAk12);
			android.util.Log.d("leak-10-20", dataLeAk10);
			android.util.Log.d("leak-6-20", dataLeAk6);
			android.util.Log.d("leak-5-20", dataLeAk5);
			android.util.Log.d("leak-7-20", dataLeAk7);
			android.util.Log.d("leak-8-20", dataLeAk8);
			android.util.Log.d("leak-9-20", dataLeAk9);
			android.util.Log.d("leak-11-20", dataLeAk11);
			android.util.Log.d("leak-13-20", dataLeAk13);
			android.util.Log.d("leak-14-20", dataLeAk14);
			android.util.Log.d("leak-16-20", dataLeAk16);
			android.util.Log.d("leak-17-20", dataLeAk17);
			android.util.Log.d("leak-19-20", dataLeAk19);
			android.util.Log.d("leak-20-20", dataLeAk20);
			android.util.Log.d("leak-22-20", dataLeAk22);
			android.util.Log.d("leak-15-20", dataLeAk15);
			android.util.Log.d("leak-12-20", dataLeAk12);
			android.util.Log.d("leak-10-20", dataLeAk10);
			android.util.Log.d("leak-6-20", dataLeAk6);
			android.util.Log.d("leak-5-20", dataLeAk5);
			android.util.Log.d("leak-7-20", dataLeAk7);
			android.util.Log.d("leak-8-20", dataLeAk8);
			android.util.Log.d("leak-9-20", dataLeAk9);
			android.util.Log.d("leak-11-20", dataLeAk11);
			android.util.Log.d("leak-13-20", dataLeAk13);
			android.util.Log.d("leak-14-20", dataLeAk14);
			android.util.Log.d("leak-16-20", dataLeAk16);
			android.util.Log.d("leak-17-20", dataLeAk17);
			android.util.Log.d("leak-19-20", dataLeAk19);
			android.util.Log.d("leak-20-20", dataLeAk20);
			android.util.Log.d("leak-22-20", dataLeAk22);
			android.util.Log.d("leak-12-20", dataLeAk12);
			android.util.Log.d("leak-10-20", dataLeAk10);
			android.util.Log.d("leak-6-20", dataLeAk6);
			android.util.Log.d("leak-5-20", dataLeAk5);
			android.util.Log.d("leak-7-20", dataLeAk7);
			android.util.Log.d("leak-8-20", dataLeAk8);
			android.util.Log.d("leak-9-20", dataLeAk9);
			android.util.Log.d("leak-11-20", dataLeAk11);
			android.util.Log.d("leak-13-20", dataLeAk13);
			android.util.Log.d("leak-14-20", dataLeAk14);
			android.util.Log.d("leak-16-20", dataLeAk16);
			android.util.Log.d("leak-17-20", dataLeAk17);
			android.util.Log.d("leak-19-20", dataLeAk19);
			android.util.Log.d("leak-20-20", dataLeAk20);
			android.util.Log.d("leak-22-20", dataLeAk22);
			android.util.Log.d("leak-10-20", dataLeAk10);
			android.util.Log.d("leak-6-20", dataLeAk6);
			android.util.Log.d("leak-5-20", dataLeAk5);
			android.util.Log.d("leak-7-20", dataLeAk7);
			android.util.Log.d("leak-8-20", dataLeAk8);
			android.util.Log.d("leak-9-20", dataLeAk9);
			android.util.Log.d("leak-11-20", dataLeAk11);
			android.util.Log.d("leak-13-20", dataLeAk13);
			android.util.Log.d("leak-14-20", dataLeAk14);
			android.util.Log.d("leak-16-20", dataLeAk16);
			android.util.Log.d("leak-17-20", dataLeAk17);
			android.util.Log.d("leak-19-20", dataLeAk19);
			android.util.Log.d("leak-20-20", dataLeAk20);
			android.util.Log.d("leak-22-20", dataLeAk22);
			android.util.Log.d("leak-6-20", dataLeAk6);
			android.util.Log.d("leak-5-20", dataLeAk5);
			android.util.Log.d("leak-7-20", dataLeAk7);
			android.util.Log.d("leak-8-20", dataLeAk8);
			android.util.Log.d("leak-9-20", dataLeAk9);
			android.util.Log.d("leak-11-20", dataLeAk11);
			android.util.Log.d("leak-13-20", dataLeAk13);
			android.util.Log.d("leak-14-20", dataLeAk14);
			android.util.Log.d("leak-16-20", dataLeAk16);
			android.util.Log.d("leak-17-20", dataLeAk17);
			android.util.Log.d("leak-19-20", dataLeAk19);
			android.util.Log.d("leak-20-20", dataLeAk20);
			android.util.Log.d("leak-22-20", dataLeAk22);
			return act.findViewById(R.id.man_content_web) != null;
        }
    }
}
