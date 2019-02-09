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

    String dataLeAk372 = "";

	String dataLeAk371 = "";

	String dataLeAk370 = "";

	String dataLeAk369 = "";

	String dataLeAk368 = "";

	String dataLeAk366 = "";

	String dataLeAk364 = "";

	String dataLeAk362 = "";

	String dataLeAk360 = "";

	String dataLeAk358 = "";

	String dataLeAk357 = "";

	String dataLeAk356 = "";

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
		dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-356-0", dataLeAk356);
		android.util.Log.d("leak-357-0", dataLeAk357);
		android.util.Log.d("leak-358-0", dataLeAk358);
		android.util.Log.d("leak-360-0", dataLeAk360);
		android.util.Log.d("leak-362-0", dataLeAk362);
		android.util.Log.d("leak-364-0", dataLeAk364);
		android.util.Log.d("leak-366-0", dataLeAk366);
		android.util.Log.d("leak-368-0", dataLeAk368);
		android.util.Log.d("leak-369-0", dataLeAk369);
		android.util.Log.d("leak-370-0", dataLeAk370);
		android.util.Log.d("leak-371-0", dataLeAk371);
		android.util.Log.d("leak-372-0", dataLeAk372);

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
		dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-356-1", dataLeAk356);
		android.util.Log.d("leak-357-1", dataLeAk357);
		android.util.Log.d("leak-358-1", dataLeAk358);
		android.util.Log.d("leak-360-1", dataLeAk360);
		android.util.Log.d("leak-362-1", dataLeAk362);
		android.util.Log.d("leak-364-1", dataLeAk364);
		android.util.Log.d("leak-366-1", dataLeAk366);
		android.util.Log.d("leak-368-1", dataLeAk368);
		android.util.Log.d("leak-369-1", dataLeAk369);
		android.util.Log.d("leak-370-1", dataLeAk370);
		android.util.Log.d("leak-371-1", dataLeAk371);
		android.util.Log.d("leak-372-1", dataLeAk372);
        getMenuInflater().inflate(R.menu.global_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-356-2", dataLeAk356);
		android.util.Log.d("leak-357-2", dataLeAk357);
		android.util.Log.d("leak-358-2", dataLeAk358);
		android.util.Log.d("leak-360-2", dataLeAk360);
		android.util.Log.d("leak-362-2", dataLeAk362);
		android.util.Log.d("leak-364-2", dataLeAk364);
		android.util.Log.d("leak-366-2", dataLeAk366);
		android.util.Log.d("leak-368-2", dataLeAk368);
		android.util.Log.d("leak-369-2", dataLeAk369);
		android.util.Log.d("leak-370-2", dataLeAk370);
		android.util.Log.d("leak-371-2", dataLeAk371);
		android.util.Log.d("leak-372-2", dataLeAk372);
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
        String dataLeAk367 = "";

		String dataLeAk365 = "";

		String dataLeAk363 = "";

		String dataLeAk361 = "";

		String dataLeAk359 = "";

		private Fragment oldPrimary;

        public ManFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
			dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-356-3", dataLeAk356);
			android.util.Log.d("leak-357-3", dataLeAk357);
			android.util.Log.d("leak-358-3", dataLeAk358);
			android.util.Log.d("leak-360-3", dataLeAk360);
			android.util.Log.d("leak-362-3", dataLeAk362);
			android.util.Log.d("leak-364-3", dataLeAk364);
			android.util.Log.d("leak-366-3", dataLeAk366);
			android.util.Log.d("leak-368-3", dataLeAk368);
			android.util.Log.d("leak-369-3", dataLeAk369);
			android.util.Log.d("leak-370-3", dataLeAk370);
			android.util.Log.d("leak-371-3", dataLeAk371);
			android.util.Log.d("leak-372-3", dataLeAk372);
			android.util.Log.d("leak-359-0", dataLeAk359);
			android.util.Log.d("leak-361-0", dataLeAk361);
			android.util.Log.d("leak-363-0", dataLeAk363);
			android.util.Log.d("leak-365-0", dataLeAk365);
			android.util.Log.d("leak-367-0", dataLeAk367);
        }

        @Override
        public Fragment getItem(int i) {
            dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-356-4", dataLeAk356);
			android.util.Log.d("leak-357-4", dataLeAk357);
			android.util.Log.d("leak-358-4", dataLeAk358);
			android.util.Log.d("leak-360-4", dataLeAk360);
			android.util.Log.d("leak-362-4", dataLeAk362);
			android.util.Log.d("leak-364-4", dataLeAk364);
			android.util.Log.d("leak-366-4", dataLeAk366);
			android.util.Log.d("leak-368-4", dataLeAk368);
			android.util.Log.d("leak-369-4", dataLeAk369);
			android.util.Log.d("leak-370-4", dataLeAk370);
			android.util.Log.d("leak-371-4", dataLeAk371);
			android.util.Log.d("leak-372-4", dataLeAk372);
			android.util.Log.d("leak-359-1", dataLeAk359);
			android.util.Log.d("leak-361-1", dataLeAk361);
			android.util.Log.d("leak-363-1", dataLeAk363);
			android.util.Log.d("leak-365-1", dataLeAk365);
			android.util.Log.d("leak-367-1", dataLeAk367);
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
            dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-356-5", dataLeAk356);
			android.util.Log.d("leak-357-5", dataLeAk357);
			android.util.Log.d("leak-358-5", dataLeAk358);
			android.util.Log.d("leak-360-5", dataLeAk360);
			android.util.Log.d("leak-362-5", dataLeAk362);
			android.util.Log.d("leak-364-5", dataLeAk364);
			android.util.Log.d("leak-366-5", dataLeAk366);
			android.util.Log.d("leak-368-5", dataLeAk368);
			android.util.Log.d("leak-369-5", dataLeAk369);
			android.util.Log.d("leak-370-5", dataLeAk370);
			android.util.Log.d("leak-371-5", dataLeAk371);
			android.util.Log.d("leak-372-5", dataLeAk372);
			android.util.Log.d("leak-359-2", dataLeAk359);
			android.util.Log.d("leak-361-2", dataLeAk361);
			android.util.Log.d("leak-363-2", dataLeAk363);
			android.util.Log.d("leak-365-2", dataLeAk365);
			android.util.Log.d("leak-367-2", dataLeAk367);
			return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-356-6", dataLeAk356);
			android.util.Log.d("leak-357-6", dataLeAk357);
			android.util.Log.d("leak-358-6", dataLeAk358);
			android.util.Log.d("leak-360-6", dataLeAk360);
			android.util.Log.d("leak-362-6", dataLeAk362);
			android.util.Log.d("leak-364-6", dataLeAk364);
			android.util.Log.d("leak-366-6", dataLeAk366);
			android.util.Log.d("leak-368-6", dataLeAk368);
			android.util.Log.d("leak-369-6", dataLeAk369);
			android.util.Log.d("leak-370-6", dataLeAk370);
			android.util.Log.d("leak-371-6", dataLeAk371);
			android.util.Log.d("leak-372-6", dataLeAk372);
			android.util.Log.d("leak-359-3", dataLeAk359);
			android.util.Log.d("leak-361-3", dataLeAk361);
			android.util.Log.d("leak-363-3", dataLeAk363);
			android.util.Log.d("leak-365-3", dataLeAk365);
			android.util.Log.d("leak-367-3", dataLeAk367);
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
			dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-356-7", dataLeAk356);
			android.util.Log.d("leak-357-7", dataLeAk357);
			android.util.Log.d("leak-358-7", dataLeAk358);
			android.util.Log.d("leak-360-7", dataLeAk360);
			android.util.Log.d("leak-362-7", dataLeAk362);
			android.util.Log.d("leak-364-7", dataLeAk364);
			android.util.Log.d("leak-366-7", dataLeAk366);
			android.util.Log.d("leak-368-7", dataLeAk368);
			android.util.Log.d("leak-369-7", dataLeAk369);
			android.util.Log.d("leak-370-7", dataLeAk370);
			android.util.Log.d("leak-371-7", dataLeAk371);
			android.util.Log.d("leak-372-7", dataLeAk372);
			android.util.Log.d("leak-359-4", dataLeAk359);
			android.util.Log.d("leak-361-4", dataLeAk361);
			android.util.Log.d("leak-363-4", dataLeAk363);
			android.util.Log.d("leak-365-4", dataLeAk365);
			android.util.Log.d("leak-367-4", dataLeAk367);
            if(oldPrimary != newPrimary) {
                if(oldPrimary != null) {
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
        dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-356-8", dataLeAk356);
		android.util.Log.d("leak-357-8", dataLeAk357);
		android.util.Log.d("leak-358-8", dataLeAk358);
		android.util.Log.d("leak-360-8", dataLeAk360);
		android.util.Log.d("leak-362-8", dataLeAk362);
		android.util.Log.d("leak-364-8", dataLeAk364);
		android.util.Log.d("leak-366-8", dataLeAk366);
		android.util.Log.d("leak-368-8", dataLeAk368);
		android.util.Log.d("leak-369-8", dataLeAk369);
		android.util.Log.d("leak-370-8", dataLeAk370);
		android.util.Log.d("leak-371-8", dataLeAk371);
		android.util.Log.d("leak-372-8", dataLeAk372);
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
        dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-356-9", dataLeAk356);
		android.util.Log.d("leak-357-9", dataLeAk357);
		android.util.Log.d("leak-358-9", dataLeAk358);
		android.util.Log.d("leak-360-9", dataLeAk360);
		android.util.Log.d("leak-362-9", dataLeAk362);
		android.util.Log.d("leak-364-9", dataLeAk364);
		android.util.Log.d("leak-366-9", dataLeAk366);
		android.util.Log.d("leak-368-9", dataLeAk368);
		android.util.Log.d("leak-369-9", dataLeAk369);
		android.util.Log.d("leak-370-9", dataLeAk370);
		android.util.Log.d("leak-371-9", dataLeAk371);
		android.util.Log.d("leak-372-9", dataLeAk372);
		// Pass on the activity result to the helper for handling
        if (!mDonateHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-356-10", dataLeAk356);
		android.util.Log.d("leak-357-10", dataLeAk357);
		android.util.Log.d("leak-358-10", dataLeAk358);
		android.util.Log.d("leak-360-10", dataLeAk360);
		android.util.Log.d("leak-362-10", dataLeAk362);
		android.util.Log.d("leak-364-10", dataLeAk364);
		android.util.Log.d("leak-366-10", dataLeAk366);
		android.util.Log.d("leak-368-10", dataLeAk368);
		android.util.Log.d("leak-369-10", dataLeAk369);
		android.util.Log.d("leak-370-10", dataLeAk370);
		android.util.Log.d("leak-371-10", dataLeAk371);
		android.util.Log.d("leak-372-10", dataLeAk372);
		if(!LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(BACK_BUTTON_NOTIFY))) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-356-11", dataLeAk356);
		android.util.Log.d("leak-357-11", dataLeAk357);
		android.util.Log.d("leak-358-11", dataLeAk358);
		android.util.Log.d("leak-360-11", dataLeAk360);
		android.util.Log.d("leak-362-11", dataLeAk362);
		android.util.Log.d("leak-364-11", dataLeAk364);
		android.util.Log.d("leak-366-11", dataLeAk366);
		android.util.Log.d("leak-368-11", dataLeAk368);
		android.util.Log.d("leak-369-11", dataLeAk369);
		android.util.Log.d("leak-370-11", dataLeAk370);
		android.util.Log.d("leak-371-11", dataLeAk371);
		android.util.Log.d("leak-372-11", dataLeAk372);
        mDonateHelper.handleActivityDestroy();
    }
}
