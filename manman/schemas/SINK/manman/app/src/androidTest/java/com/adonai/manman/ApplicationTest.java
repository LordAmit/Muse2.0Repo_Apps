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

    final String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk19 = "";

	String dataLeAk17 = "";

	String dataLeAk15 = "";

	String dataLeAk12 = "";

	String dataLeAk11 = "";

	String dataLeAk9 = "";

	@Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainPagerActivity.class);

    @Before
    public void unlockScreen() {
        dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-0", dataLeAk9);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-12-0", dataLeAk12);
		android.util.Log.d("leak-15-0", dataLeAk15);
		android.util.Log.d("leak-17-0", dataLeAk17);
		android.util.Log.d("leak-19-0", dataLeAk19);
		final Activity activity = mActivityRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            String dataLeAk10 = "";

			public void run() {
                dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-30-0", dataLeAk30);
				android.util.Log.d("leak-10-0", dataLeAk10);
				activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }

    @Before
    public void espressoPreconditions() {
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-1", dataLeAk9);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-12-1", dataLeAk12);
		android.util.Log.d("leak-15-1", dataLeAk15);
		android.util.Log.d("leak-17-1", dataLeAk17);
		android.util.Log.d("leak-19-1", dataLeAk19);
		IdlingPolicies.setMasterPolicyTimeout(10, TimeUnit.MINUTES);
    }

    @Test
    public void checkSearchForCommand() throws InterruptedException {
        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-2", dataLeAk9);
		android.util.Log.d("leak-11-2", dataLeAk11);
		android.util.Log.d("leak-12-2", dataLeAk12);
		android.util.Log.d("leak-15-2", dataLeAk15);
		android.util.Log.d("leak-17-2", dataLeAk17);
		android.util.Log.d("leak-19-2", dataLeAk19);
		final Activity act = mActivityRule.getActivity();
        final ListView searchList = (ListView) act.findViewById(R.id.search_results_list);

        onView(withId(R.id.query_edit)).perform(typeText("tar"));

        // wait until list is loaded with results
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk13 = "";

			@Override
            public Boolean call() throws Exception {
                dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-31-0", dataLeAk31);
				android.util.Log.d("leak-13-0", dataLeAk13);
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
            String dataLeAk14 = "";

			@Override
            public Boolean call() throws Exception {
                dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-32-0", dataLeAk32);
				android.util.Log.d("leak-14-0", dataLeAk14);
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
        dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-3", dataLeAk9);
		android.util.Log.d("leak-11-3", dataLeAk11);
		android.util.Log.d("leak-12-3", dataLeAk12);
		android.util.Log.d("leak-15-3", dataLeAk15);
		android.util.Log.d("leak-17-3", dataLeAk17);
		android.util.Log.d("leak-19-3", dataLeAk19);
		final Activity act = mActivityRule.getActivity();

        onView(withText(R.string.contents)).perform(click());
        onView(withText("General commands")).perform(click());

        // wait for page to load
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk16 = "";

			@Override
            public Boolean call() throws Exception {
                dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-33-0", dataLeAk33);
				android.util.Log.d("leak-16-0", dataLeAk16);
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
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-15-4", dataLeAk15);
		android.util.Log.d("leak-17-4", dataLeAk17);
		android.util.Log.d("leak-19-4", dataLeAk19);
		final Activity act = mActivityRule.getActivity();

        // first we need to clear archive
        final File localArchive = new File(act.getCacheDir(), "manpages.zip");
        localArchive.delete();

        onView(withText(R.string.local_storage)).perform(click());
        onView(withText(R.string.download_archive)).perform(click());
        onView(withText(android.R.string.ok)).perform(click());

        // wait for local archive to load
        await().atMost(10, TimeUnit.MINUTES).until(new Callable<Boolean>() {
            String dataLeAk18 = "";

			@Override
            public Boolean call() throws Exception {
                dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-34-0", dataLeAk34);
				android.util.Log.d("leak-18-0", dataLeAk18);
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
        dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-15-5", dataLeAk15);
		android.util.Log.d("leak-17-5", dataLeAk17);
		android.util.Log.d("leak-19-5", dataLeAk19);
		final Activity act = mActivityRule.getActivity();
        final ListView searchList = (ListView) act.findViewById(R.id.search_results_list);

        onView(withId(R.id.query_edit)).perform(typeText("grep"));

        // wait until list is loaded with results
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk20 = "";

			@Override
            public Boolean call() throws Exception {
                dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-35-0", dataLeAk35);
				android.util.Log.d("leak-20-0", dataLeAk20);
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

        String dataLeAk23 = "";

		String dataLeAk22 = "";

		String dataLeAk21 = "";

		private final String name;

        private ManSectionItemMatcher(String name) {
            dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-21-0", dataLeAk21);
			android.util.Log.d("leak-22-0", dataLeAk22);
			android.util.Log.d("leak-23-0", dataLeAk23);
			this.name = name;
        }

        @Override
        public boolean matches(Object item) {
            dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-21-1", dataLeAk21);
			android.util.Log.d("leak-22-1", dataLeAk22);
			android.util.Log.d("leak-23-1", dataLeAk23);
			return item instanceof ManSectionItem && ((ManSectionItem) item).getName().equals(name);
        }

        @Override
        public void describeTo(Description description) {
            dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-21-2", dataLeAk21);
			android.util.Log.d("leak-22-2", dataLeAk22);
			android.util.Log.d("leak-23-2", dataLeAk23);
			description.appendText("is a ").appendText(name);
        }
    }

    private static class ManPageMatcher extends BaseMatcher<ManPage> {

        String dataLeAk26 = "";

		String dataLeAk25 = "";

		String dataLeAk24 = "";

		private final String name;

        private ManPageMatcher(String name) {
            dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-24-0", dataLeAk24);
			android.util.Log.d("leak-25-0", dataLeAk25);
			android.util.Log.d("leak-26-0", dataLeAk26);
			this.name = name;
        }

        @Override
        public boolean matches(Object item) {
            dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-24-1", dataLeAk24);
			android.util.Log.d("leak-25-1", dataLeAk25);
			android.util.Log.d("leak-26-1", dataLeAk26);
			return item instanceof ManPage && ((ManPage) item).getName().equals(name);
        }

        @Override
        public void describeTo(Description description) {
            dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-24-2", dataLeAk24);
			android.util.Log.d("leak-25-2", dataLeAk25);
			android.util.Log.d("leak-26-2", dataLeAk26);
			description.appendText("is a ").appendText(name);
        }
    }

    private static class WebViewVisible implements Callable<Boolean> {
        String dataLeAk28 = "";

		String dataLeAk27 = "";

		private final Activity act;

        public WebViewVisible(Activity act) {
            dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-27-0", dataLeAk27);
			android.util.Log.d("leak-28-0", dataLeAk28);
			this.act = act;
        }

        @Override
        public Boolean call() throws Exception {
            dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-27-1", dataLeAk27);
			android.util.Log.d("leak-28-1", dataLeAk28);
			return act.findViewById(R.id.man_content_web) != null;
        }
    }
}
