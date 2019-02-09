package com.adonai.manman;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.adonai.manman.preferences.PreferencesActivity;
import com.astuetz.PagerSlidingTabStrip;

/**
 * Main activity where everything takes place
 *
 * @author Oleg Chernovskiy
 */
@SuppressWarnings("FieldCanBeLocal")
public class MainPagerActivity extends AppCompatActivity {

    String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk448 = android.util.Log.d("leak-448", dataLeAk448);

	public static final String FOLDER_LIST_KEY = "folder.list";

    static final int SEARCH_COMMAND_LOADER          = 0;
    static final int SEARCH_ONELINER_LOADER         = 1;
    static final int MAN_PAGE_RETRIEVER_LOADER      = 2; // final man page retriever
    static final int CHAPTER_RETRIEVER_LOADER       = 3; // chapter contents retriever
    static final int PACKAGE_RETRIEVER_LOADER       = 4; // package contents retriever
    static final int CACHE_RETRIEVER_LOADER         = 5; // cached pages retriever
    static final int LOCAL_PACKAGE_LOADER           = 6; // local archive retriever

    public static final String DB_CHANGE_NOTIFY = "database.updated";
    public static final String LOCAL_CHANGE_NOTIFY = "locals.updated";
    public static final String BACK_BUTTON_NOTIFY = "back.button.pressed";

    private ViewPager mPager;
    private Toolbar mActionBar;
    private DonateHelper mDonateHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // should set theme prior to instantiating compat actionbar etc.
        Utils.setupTheme(this);
		String dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk449 = android.util.Log.d("leak-449", dataLeAk449);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pager);

        mActionBar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(mActionBar);

        mPager = (ViewPager) findViewById(R.id.page_holder);
        mPager.setAdapter(new ManFragmentPagerAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(mPager);

        // setting up vending
        mDonateHelper = new DonateHelper(this);

        // applying default tab
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final String index = prefs.getString("app.default.tab", "0");
        mPager.setCurrentItem(Integer.valueOf(index));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk450 = android.util.Log.d("leak-450", dataLeAk450);
        getMenuInflater().inflate(R.menu.global_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk451 = android.util.Log.d("leak-451", dataLeAk451);
		switch (item.getItemId()) {
            case R.id.about_menu_item:
                showAbout();
                return true;
            case R.id.donate_menu_item:
                mDonateHelper.purchaseGift();
                return true;
            case R.id.settings_menu_item:
                startActivity(new Intent(this, PreferencesActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ManFragmentPagerAdapter extends FragmentPagerAdapter {
        String dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk452 = android.util.Log.d("leak-452", dataLeAk452);

		private Fragment oldPrimary;

        public ManFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
			String dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk453 = android.util.Log.d("leak-453", dataLeAk453);
        }

        @Override
        public Fragment getItem(int i) {
            String dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk454 = android.util.Log.d("leak-454", dataLeAk454);
			switch (i) {
                case 0:
                    return ManPageSearchFragment.newInstance();
                case 1:
                    return ManChaptersFragment.newInstance();
                case 2:
                    return ManCacheFragment.newInstance();
                case 3:
                    return ManLocalArchiveFragment.newInstance();
            }
            throw new IllegalArgumentException(String.format("No such fragment, index was %d", i));
        }

        @Override
        public int getCount() {
            String dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk455 = android.util.Log.d("leak-455", dataLeAk455);
			return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk456 = android.util.Log.d("leak-456", dataLeAk456);
			switch(position) {
                case 0: return getString(R.string.search);
                case 1: return getString(R.string.contents);
                case 2: return getString(R.string.cached);
                case 3: return getString(R.string.local_storage);
                default: return null;
            }
        }

        /**
         * A way to notify fragments when they become visible to user in this pager
         */
        @Override
        public void setPrimaryItem(ViewGroup container, int position, @NonNull Object object) {
            Fragment newPrimary = (Fragment) object;
			String dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk457 = android.util.Log.d("leak-457", dataLeAk457);
            if(oldPrimary != newPrimary) {
                String dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk458 = android.util.Log.d("leak-458", dataLeAk458);
				if(oldPrimary != null) {
                    String dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk459 = android.util.Log.d("leak-459", dataLeAk459);
					oldPrimary.setUserVisibleHint(false);
                    oldPrimary.onPause();
                }

                newPrimary.setUserVisibleHint(true);
                newPrimary.onResume();

                oldPrimary = newPrimary;
            }
            super.setPrimaryItem(container, position, object);
        }
    }

    /**
     * Shows about dialog, with description, author and stuff
     */
    @SuppressLint("InflateParams")
    private void showAbout() {
        String dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk460 = android.util.Log.d("leak-460", dataLeAk460);
		// Inflate the about message contents
        View messageView = getLayoutInflater().inflate(R.layout.about_dialog, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_launcher_notification_icon);
        builder.setTitle(R.string.app_name);
        builder.setView(messageView);
        builder.create();
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk461 = android.util.Log.d("leak-461", dataLeAk461);
		// Pass on the activity result to the helper for handling
        if (!mDonateHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
			String dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk462 = android.util.Log.d("leak-462", dataLeAk462);
        }
    }

    @Override
    public void onBackPressed() {
        String dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk463 = android.util.Log.d("leak-463", dataLeAk463);
		if(!LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(BACK_BUTTON_NOTIFY))) {
            super.onBackPressed();
			String dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk464 = android.util.Log.d("leak-464", dataLeAk464);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk465 = android.util.Log.d("leak-465", dataLeAk465);
        mDonateHelper.handleActivityDestroy();
    }
}
