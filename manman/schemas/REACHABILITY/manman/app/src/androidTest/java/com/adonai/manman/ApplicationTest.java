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

    String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);

	@Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainPagerActivity.class);

    @Before
    public void unlockScreen() {
        String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
		final Activity activity = mActivityRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);

			public void run() {
                String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
				activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }

    @Before
    public void espressoPreconditions() {
        String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);
		IdlingPolicies.setMasterPolicyTimeout(10, TimeUnit.MINUTES);
    }

    @Test
    public void checkSearchForCommand() throws InterruptedException {
        String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
		final Activity act = mActivityRule.getActivity();
        final ListView searchList = (ListView) act.findViewById(R.id.search_results_list);

        onView(withId(R.id.query_edit)).perform(typeText("tar"));

        // wait until list is loaded with results
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);

			@Override
            public Boolean call() throws Exception {
                String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
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
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);

			@Override
            public Boolean call() throws Exception {
                String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
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
        String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
		final Activity act = mActivityRule.getActivity();

        onView(withText(R.string.contents)).perform(click());
        onView(withText("General commands")).perform(click());

        // wait for page to load
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);

			@Override
            public Boolean call() throws Exception {
                String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
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
        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
		final Activity act = mActivityRule.getActivity();

        // first we need to clear archive
        final File localArchive = new File(act.getCacheDir(), "manpages.zip");
        localArchive.delete();

        onView(withText(R.string.local_storage)).perform(click());
        onView(withText(R.string.download_archive)).perform(click());
        onView(withText(android.R.string.ok)).perform(click());

        // wait for local archive to load
        await().atMost(10, TimeUnit.MINUTES).until(new Callable<Boolean>() {
            String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);

			@Override
            public Boolean call() throws Exception {
                String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
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
        String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
		final Activity act = mActivityRule.getActivity();
        final ListView searchList = (ListView) act.findViewById(R.id.search_results_list);

        onView(withId(R.id.query_edit)).perform(typeText("grep"));

        // wait until list is loaded with results
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);

			@Override
            public Boolean call() throws Exception {
                String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
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

        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);

		private final String name;

        private ManSectionItemMatcher(String name) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
			this.name = name;
        }

        @Override
        public boolean matches(Object item) {
            String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
			return item instanceof ManSectionItem && ((ManSectionItem) item).getName().equals(name);
        }

        @Override
        public void describeTo(Description description) {
            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
			description.appendText("is a ").appendText(name);
        }
    }

    private static class ManPageMatcher extends BaseMatcher<ManPage> {

        String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);

		private final String name;

        private ManPageMatcher(String name) {
            String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
			this.name = name;
        }

        @Override
        public boolean matches(Object item) {
            String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
			return item instanceof ManPage && ((ManPage) item).getName().equals(name);
        }

        @Override
        public void describeTo(Description description) {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
			description.appendText("is a ").appendText(name);
        }
    }

    private static class WebViewVisible implements Callable<Boolean> {
        String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);

		private final Activity act;

        public WebViewVisible(Activity act) {
            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
			this.act = act;
        }

        @Override
        public Boolean call() throws Exception {
            String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
			return act.findViewById(R.id.man_content_web) != null;
        }
    }
}
