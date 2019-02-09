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
		String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath367;try {throw new Exception(dataLeAk367);} catch (Exception leakErRor367) {dataLeAkPath367 = leakErRor367.getMessage();}
		android.util.Log.d("leak-367", dataLeAkPath367);

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
		String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay368 = new String[] {"n/a", dataLeAk368};
		String dataLeAkPath368 = leakArRay368[leakArRay368.length - 1];
		android.util.Log.d("leak-368", dataLeAkPath368);
        getMenuInflater().inflate(R.menu.global_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP369 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP369.put("test", new java.util.HashMap<String, String>());
		leakMaP369.get("test").put("test", dataLeAk369);
		String dataLeAkPath369 = leakMaP369.get("test").get("test");
		android.util.Log.d("leak-369", dataLeAkPath369);
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
        private Fragment oldPrimary;

        public ManFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
			String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer370 = new StringBuffer();for (char chAr370 : dataLeAk370.toCharArray()) {leakBuFFer370.append(chAr370);}String dataLeAkPath370 = leakBuFFer370.toString();
			android.util.Log.d("leak-370", dataLeAkPath370);
        }

        @Override
        public Fragment getItem(int i) {
            String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath371;try {throw new Exception(dataLeAk371);} catch (Exception leakErRor371) {dataLeAkPath371 = leakErRor371.getMessage();}
			android.util.Log.d("leak-371", dataLeAkPath371);
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
            String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay372 = new String[] {"n/a", dataLeAk372};
			String dataLeAkPath372 = leakArRay372[leakArRay372.length - 1];
			android.util.Log.d("leak-372", dataLeAkPath372);
			return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP373 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP373.put("test", new java.util.HashMap<String, String>());
			leakMaP373.get("test").put("test", dataLeAk373);
			String dataLeAkPath373 = leakMaP373.get("test").get("test");
			android.util.Log.d("leak-373", dataLeAkPath373);
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
			String dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer374 = new StringBuffer();for (char chAr374 : dataLeAk374.toCharArray()) {leakBuFFer374.append(chAr374);}String dataLeAkPath374 = leakBuFFer374.toString();
			android.util.Log.d("leak-374", dataLeAkPath374);
            if(oldPrimary != newPrimary) {
                String dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath375;try {throw new Exception(dataLeAk375);} catch (Exception leakErRor375) {dataLeAkPath375 = leakErRor375.getMessage();}
				android.util.Log.d("leak-375", dataLeAkPath375);
				if(oldPrimary != null) {
                    String dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay376 = new String[] {"n/a", dataLeAk376};
					String dataLeAkPath376 = leakArRay376[leakArRay376.length - 1];
					android.util.Log.d("leak-376", dataLeAkPath376);
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
        String dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP377 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP377.put("test", new java.util.HashMap<String, String>());
		leakMaP377.get("test").put("test", dataLeAk377);
		String dataLeAkPath377 = leakMaP377.get("test").get("test");
		android.util.Log.d("leak-377", dataLeAkPath377);
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
        String dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer378 = new StringBuffer();for (char chAr378 : dataLeAk378.toCharArray()) {leakBuFFer378.append(chAr378);}String dataLeAkPath378 = leakBuFFer378.toString();
		android.util.Log.d("leak-378", dataLeAkPath378);
		// Pass on the activity result to the helper for handling
        if (!mDonateHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
			String dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath379;try {throw new Exception(dataLeAk379);} catch (Exception leakErRor379) {dataLeAkPath379 = leakErRor379.getMessage();}
			android.util.Log.d("leak-379", dataLeAkPath379);
        }
    }

    @Override
    public void onBackPressed() {
        String dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay380 = new String[] {"n/a", dataLeAk380};
		String dataLeAkPath380 = leakArRay380[leakArRay380.length - 1];
		android.util.Log.d("leak-380", dataLeAkPath380);
		if(!LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(BACK_BUTTON_NOTIFY))) {
            super.onBackPressed();
			String dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP381 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP381.put("test", new java.util.HashMap<String, String>());
			leakMaP381.get("test").put("test", dataLeAk381);
			String dataLeAkPath381 = leakMaP381.get("test").get("test");
			android.util.Log.d("leak-381", dataLeAkPath381);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer382 = new StringBuffer();for (char chAr382 : dataLeAk382.toCharArray()) {leakBuFFer382.append(chAr382);}String dataLeAkPath382 = leakBuFFer382.toString();
		android.util.Log.d("leak-382", dataLeAkPath382);
        mDonateHelper.handleActivityDestroy();
    }
}
