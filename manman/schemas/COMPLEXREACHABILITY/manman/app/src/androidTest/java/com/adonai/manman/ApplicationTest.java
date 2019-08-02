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

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainPagerActivity.class);

    @Before
    public void unlockScreen() {
        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP9.put("test", new java.util.HashMap<String, String>());
		leakMaP9.get("test").put("test", dataLeAk9);
		String dataLeAkPath9 = leakMaP9.get("test").get("test");
		android.util.Log.d("leak-9", dataLeAkPath9);
		final Activity activity = mActivityRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
				android.util.Log.d("leak-10", dataLeAkPath10);
				activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }

    @Before
    public void espressoPreconditions() {
        String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
		android.util.Log.d("leak-11", dataLeAkPath11);
		IdlingPolicies.setMasterPolicyTimeout(10, TimeUnit.MINUTES);
    }

    @Test
    public void checkSearchForCommand() throws InterruptedException {
        String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
		String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
		android.util.Log.d("leak-12", dataLeAkPath12);
		final Activity act = mActivityRule.getActivity();
        final ListView searchList = (ListView) act.findViewById(R.id.search_results_list);

        onView(withId(R.id.query_edit)).perform(typeText("tar"));

        // wait until list is loaded with results
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP13.put("test", new java.util.HashMap<String, String>());
				leakMaP13.get("test").put("test", dataLeAk13);
				String dataLeAkPath13 = leakMaP13.get("test").get("test");
				android.util.Log.d("leak-13", dataLeAkPath13);
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
            @Override
            public Boolean call() throws Exception {
                String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
				android.util.Log.d("leak-14", dataLeAkPath14);
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
        String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
		android.util.Log.d("leak-15", dataLeAkPath15);
		final Activity act = mActivityRule.getActivity();

        onView(withText(R.string.contents)).perform(click());
        onView(withText("General commands")).perform(click());

        // wait for page to load
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
				String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
				android.util.Log.d("leak-16", dataLeAkPath16);
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
        String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP17.put("test", new java.util.HashMap<String, String>());
		leakMaP17.get("test").put("test", dataLeAk17);
		String dataLeAkPath17 = leakMaP17.get("test").get("test");
		android.util.Log.d("leak-17", dataLeAkPath17);
		final Activity act = mActivityRule.getActivity();

        // first we need to clear archive
        final File localArchive = new File(act.getCacheDir(), "manpages.zip");
        localArchive.delete();

        onView(withText(R.string.local_storage)).perform(click());
        onView(withText(R.string.download_archive)).perform(click());
        onView(withText(android.R.string.ok)).perform(click());

        // wait for local archive to load
        await().atMost(10, TimeUnit.MINUTES).until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
				android.util.Log.d("leak-18", dataLeAkPath18);
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
        String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
		android.util.Log.d("leak-19", dataLeAkPath19);
		final Activity act = mActivityRule.getActivity();
        final ListView searchList = (ListView) act.findViewById(R.id.search_results_list);

        onView(withId(R.id.query_edit)).perform(typeText("grep"));

        // wait until list is loaded with results
        await().atMost(5, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
				String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
				android.util.Log.d("leak-20", dataLeAkPath20);
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
            String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP21.put("test", new java.util.HashMap<String, String>());
			leakMaP21.get("test").put("test", dataLeAk21);
			String dataLeAkPath21 = leakMaP21.get("test").get("test");
			android.util.Log.d("leak-21", dataLeAkPath21);
			this.name = name;
        }

        @Override
        public boolean matches(Object item) {
            String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
			android.util.Log.d("leak-22", dataLeAkPath22);
			return item instanceof ManSectionItem && ((ManSectionItem) item).getName().equals(name);
        }

        @Override
        public void describeTo(Description description) {
            String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
			android.util.Log.d("leak-23", dataLeAkPath23);
			description.appendText("is a ").appendText(name);
        }
    }

    private static class ManPageMatcher extends BaseMatcher<ManPage> {

        private final String name;

        private ManPageMatcher(String name) {
            String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
			String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
			android.util.Log.d("leak-24", dataLeAkPath24);
			this.name = name;
        }

        @Override
        public boolean matches(Object item) {
            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP25.put("test", new java.util.HashMap<String, String>());
			leakMaP25.get("test").put("test", dataLeAk25);
			String dataLeAkPath25 = leakMaP25.get("test").get("test");
			android.util.Log.d("leak-25", dataLeAkPath25);
			return item instanceof ManPage && ((ManPage) item).getName().equals(name);
        }

        @Override
        public void describeTo(Description description) {
            String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
			android.util.Log.d("leak-26", dataLeAkPath26);
			description.appendText("is a ").appendText(name);
        }
    }

    private static class WebViewVisible implements Callable<Boolean> {
        private final Activity act;

        public WebViewVisible(Activity act) {
            String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
			android.util.Log.d("leak-27", dataLeAkPath27);
			this.act = act;
        }

        @Override
        public Boolean call() throws Exception {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
			String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
			android.util.Log.d("leak-28", dataLeAkPath28);
			return act.findViewById(R.id.man_content_web) != null;
        }
    }
}
