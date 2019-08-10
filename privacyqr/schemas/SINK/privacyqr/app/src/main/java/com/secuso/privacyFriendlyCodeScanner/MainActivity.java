package com.secuso.privacyFriendlyCodeScanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.secuso.privacyFriendlyCodeScanner.GeneralFragments.AboutFragment;
import com.secuso.privacyFriendlyCodeScanner.GeneralFragments.HelpFragment;
import com.secuso.privacyFriendlyCodeScanner.GeneralFragments.HistoryFragment;
import com.secuso.privacyFriendlyCodeScanner.GeneralFragments.MyCaptureFragment;
import com.secuso.privacyFriendlyCodeScanner.GeneralFragments.SettingsFragment;

import java.io.File;
import java.util.LinkedList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    final String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk21 = "";

	String dataLeAk20 = "";

	String dataLeAk19 = "";

	String dataLeAk17 = "";

	String dataLeAk16 = "";

	String dataLeAk15 = "";

	String dataLeAk14 = "";

	String dataLeAk13 = "";

	String dataLeAk12 = "";

	String dataLeAk11 = "";

	String dataLeAk10 = "";

	String dataLeAk9 = "";

	String dataLeAk1 = "";

	String dataLeAk0 = "";

	// delay to launch nav drawer item, to allow close animation to play
    static final int NAVDRAWER_LAUNCH_DELAY = 250;
    // fade in and fade out durations for the main content when switching between
    // different Activities of the app through the Nav Drawer
    static final int MAIN_CONTENT_FADEOUT_DURATION = 150;
    static final int MAIN_CONTENT_FADEIN_DURATION = 250;

    // Navigation drawer:
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    // Helper
    private Handler mHandler;

    private LinkedList<Integer> backStack = new LinkedList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-1-0", dataLeAk1);
		android.util.Log.d("leak-9-0", dataLeAk9);
		android.util.Log.d("leak-10-0", dataLeAk10);
		android.util.Log.d("leak-11-0", dataLeAk11);
		android.util.Log.d("leak-12-0", dataLeAk12);
		android.util.Log.d("leak-13-0", dataLeAk13);
		android.util.Log.d("leak-14-0", dataLeAk14);
		android.util.Log.d("leak-15-0", dataLeAk15);
		android.util.Log.d("leak-16-0", dataLeAk16);
		android.util.Log.d("leak-17-0", dataLeAk17);
		android.util.Log.d("leak-19-0", dataLeAk19);
		android.util.Log.d("leak-20-0", dataLeAk20);
		android.util.Log.d("leak-21-0", dataLeAk21);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

        if(prefs.getBoolean("firstVisit", true)) {
            WelcomeDialog welcomeDialog = new WelcomeDialog();
            welcomeDialog.show(getFragmentManager(), "WelcomeDialog");
        }
        else if(savedInstanceState == null) {
                selectItem(0, false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-9-1", dataLeAk9);
		android.util.Log.d("leak-10-1", dataLeAk10);
		android.util.Log.d("leak-11-1", dataLeAk11);
		android.util.Log.d("leak-12-1", dataLeAk12);
		android.util.Log.d("leak-13-1", dataLeAk13);
		android.util.Log.d("leak-14-1", dataLeAk14);
		android.util.Log.d("leak-15-1", dataLeAk15);
		android.util.Log.d("leak-16-1", dataLeAk16);
		android.util.Log.d("leak-17-1", dataLeAk17);
		android.util.Log.d("leak-19-1", dataLeAk19);
		android.util.Log.d("leak-20-1", dataLeAk20);
		android.util.Log.d("leak-21-1", dataLeAk21);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_clear) {
            File sdcard = getFilesDir();
            final File file = new File(sdcard,"history.txt");

            if(!file.exists()) Toast.makeText(this, getResources().getString(R.string.cannot_clear), Toast.LENGTH_SHORT).show();
            else {
                AlertDialog.Builder deleteDialog = new AlertDialog.Builder(this);
                deleteDialog.setOnCancelListener(new DialogInterface.OnCancelListener () {

                    String dataLeAk2 = "";

					@Override
                    public void onCancel(DialogInterface dialog) {
						dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-23-0", dataLeAk23);
						android.util.Log.d("leak-2-0", dataLeAk2);

                    }

                });
                deleteDialog.setMessage(R.string.delete_history);
                deleteDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                    String dataLeAk3 = "";

					@Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-24-0", dataLeAk24);
						android.util.Log.d("leak-3-0", dataLeAk3);
						file.delete();
                        selectItem(1,false);
                    }
                });

                deleteDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

                    String dataLeAk4 = "";

					@Override
                    public void onClick(DialogInterface dialog, int which) {
						dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-25-0", dataLeAk25);
						android.util.Log.d("leak-4-0", dataLeAk4);

                    }
                });
                deleteDialog.show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public static class WelcomeDialog extends DialogFragment {

        final String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk6 = "";

		String dataLeAk5 = "";

		@Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
			dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-5-0", dataLeAk5);
			android.util.Log.d("leak-6-0", dataLeAk6);
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-5-1", dataLeAk5);
			android.util.Log.d("leak-6-1", dataLeAk6);
			LayoutInflater i = getActivity().getLayoutInflater();
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setView(i.inflate(R.layout.welcome_dialog, null));
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle(getActivity().getString(R.string.welcome));
            builder.setPositiveButton(getActivity().getString(R.string.ok), new DialogInterface.OnClickListener() {
                String dataLeAk7 = "";

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-26-0", dataLeAk26);
					android.util.Log.d("leak-7-0", dataLeAk7);
					((MainActivity)getActivity()).goToNavigationItem(R.id.nav_scan);
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(((MainActivity)getActivity()).getApplicationContext());
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstVisit", false);
                    editor.commit();
                }
            });
            builder.setNegativeButton(getActivity().getString(R.string.viewhelp), new DialogInterface.OnClickListener() {
                String dataLeAk8 = "";

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-27-0", dataLeAk27);
					android.util.Log.d("leak-8-0", dataLeAk8);
					((MainActivity)getActivity()).goToNavigationItem(R.id.nav_help);
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(((MainActivity)getActivity()).getApplicationContext());
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstVisit", false);
                    editor.commit();
                }
            });

            return builder.create();
        }
    }

    public void switchToFragment(Fragment frag, boolean back){
        dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-2", dataLeAk0);
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-9-2", dataLeAk9);
		android.util.Log.d("leak-10-2", dataLeAk10);
		android.util.Log.d("leak-11-2", dataLeAk11);
		android.util.Log.d("leak-12-2", dataLeAk12);
		android.util.Log.d("leak-13-2", dataLeAk13);
		android.util.Log.d("leak-14-2", dataLeAk14);
		android.util.Log.d("leak-15-2", dataLeAk15);
		android.util.Log.d("leak-16-2", dataLeAk16);
		android.util.Log.d("leak-17-2", dataLeAk17);
		android.util.Log.d("leak-19-2", dataLeAk19);
		android.util.Log.d("leak-20-2", dataLeAk20);
		android.util.Log.d("leak-21-2", dataLeAk21);
		Fragment temp = getFragmentManager().findFragmentById(R.id.container);
        if(!back)
            if(temp instanceof MyCaptureFragment)
                backStack.push(0);
            else if(temp instanceof HistoryFragment)
                backStack.push(1);
            else if(temp instanceof SettingsFragment)
                backStack.push(2);
            else if(temp instanceof AboutFragment)
                backStack.push(3);
            else if(temp instanceof HelpFragment)
                backStack.push(4);

        getFragmentManager().beginTransaction().replace(R.id.container, frag).addToBackStack("").commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
		dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-3", dataLeAk0);
		android.util.Log.d("leak-1-3", dataLeAk1);
		android.util.Log.d("leak-9-3", dataLeAk9);
		android.util.Log.d("leak-10-3", dataLeAk10);
		android.util.Log.d("leak-11-3", dataLeAk11);
		android.util.Log.d("leak-12-3", dataLeAk12);
		android.util.Log.d("leak-13-3", dataLeAk13);
		android.util.Log.d("leak-14-3", dataLeAk14);
		android.util.Log.d("leak-15-3", dataLeAk15);
		android.util.Log.d("leak-16-3", dataLeAk16);
		android.util.Log.d("leak-17-3", dataLeAk17);
		android.util.Log.d("leak-19-3", dataLeAk19);
		android.util.Log.d("leak-20-3", dataLeAk20);
		android.util.Log.d("leak-21-3", dataLeAk21);
    }

    @Override
    public void onBackPressed() {
        dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-4", dataLeAk0);
		android.util.Log.d("leak-1-4", dataLeAk1);
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-10-4", dataLeAk10);
		android.util.Log.d("leak-11-4", dataLeAk11);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-13-4", dataLeAk13);
		android.util.Log.d("leak-14-4", dataLeAk14);
		android.util.Log.d("leak-15-4", dataLeAk15);
		android.util.Log.d("leak-16-4", dataLeAk16);
		android.util.Log.d("leak-17-4", dataLeAk17);
		android.util.Log.d("leak-19-4", dataLeAk19);
		android.util.Log.d("leak-20-4", dataLeAk20);
		android.util.Log.d("leak-21-4", dataLeAk21);
		if (backStack.size() < 1)
            finish();
        else {
            int back = backStack.pop();
            selectItem(back, true);
        }
    }

    public void goBack(){
        dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-5", dataLeAk0);
		android.util.Log.d("leak-1-5", dataLeAk1);
		android.util.Log.d("leak-9-5", dataLeAk9);
		android.util.Log.d("leak-10-5", dataLeAk10);
		android.util.Log.d("leak-11-5", dataLeAk11);
		android.util.Log.d("leak-12-5", dataLeAk12);
		android.util.Log.d("leak-13-5", dataLeAk13);
		android.util.Log.d("leak-14-5", dataLeAk14);
		android.util.Log.d("leak-15-5", dataLeAk15);
		android.util.Log.d("leak-16-5", dataLeAk16);
		android.util.Log.d("leak-17-5", dataLeAk17);
		android.util.Log.d("leak-19-5", dataLeAk19);
		android.util.Log.d("leak-20-5", dataLeAk20);
		android.util.Log.d("leak-21-5", dataLeAk21);
		getFragmentManager().beginTransaction().replace(R.id.container, new HistoryFragment()).addToBackStack("").commit();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
		dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-6", dataLeAk0);
		android.util.Log.d("leak-1-6", dataLeAk1);
		android.util.Log.d("leak-9-6", dataLeAk9);
		android.util.Log.d("leak-10-6", dataLeAk10);
		android.util.Log.d("leak-11-6", dataLeAk11);
		android.util.Log.d("leak-12-6", dataLeAk12);
		android.util.Log.d("leak-13-6", dataLeAk13);
		android.util.Log.d("leak-14-6", dataLeAk14);
		android.util.Log.d("leak-15-6", dataLeAk15);
		android.util.Log.d("leak-16-6", dataLeAk16);
		android.util.Log.d("leak-17-6", dataLeAk17);
		android.util.Log.d("leak-19-6", dataLeAk19);
		android.util.Log.d("leak-20-6", dataLeAk20);
		android.util.Log.d("leak-21-6", dataLeAk21);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSupportActionBar() == null) {
            setSupportActionBar(toolbar);
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        selectNavigationItem(getNavigationDrawerID());
        selectNavigationItem(R.id.nav_scan);

        View mainContent = findViewById(R.id.main_content);
        if (mainContent != null) {
            mainContent.setAlpha(0);
            mainContent.animate().alpha(1).setDuration(MAIN_CONTENT_FADEIN_DURATION);
        }
    }

    // set active navigation item
    private void selectNavigationItem(int itemId) {
        dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-7", dataLeAk0);
		android.util.Log.d("leak-1-7", dataLeAk1);
		android.util.Log.d("leak-9-7", dataLeAk9);
		android.util.Log.d("leak-10-7", dataLeAk10);
		android.util.Log.d("leak-11-7", dataLeAk11);
		android.util.Log.d("leak-12-7", dataLeAk12);
		android.util.Log.d("leak-13-7", dataLeAk13);
		android.util.Log.d("leak-14-7", dataLeAk14);
		android.util.Log.d("leak-15-7", dataLeAk15);
		android.util.Log.d("leak-16-7", dataLeAk16);
		android.util.Log.d("leak-17-7", dataLeAk17);
		android.util.Log.d("leak-19-7", dataLeAk19);
		android.util.Log.d("leak-20-7", dataLeAk20);
		android.util.Log.d("leak-21-7", dataLeAk21);
		for(int i = 0 ; i < mNavigationView.getMenu().size(); i++) {
            boolean b = itemId == mNavigationView.getMenu().getItem(i).getItemId();
            mNavigationView.getMenu().getItem(i).setChecked(b);
        }
    }

    protected int getNavigationDrawerID() {
        dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-8", dataLeAk0);
		android.util.Log.d("leak-1-8", dataLeAk1);
		android.util.Log.d("leak-9-8", dataLeAk9);
		android.util.Log.d("leak-10-8", dataLeAk10);
		android.util.Log.d("leak-11-8", dataLeAk11);
		android.util.Log.d("leak-12-8", dataLeAk12);
		android.util.Log.d("leak-13-8", dataLeAk13);
		android.util.Log.d("leak-14-8", dataLeAk14);
		android.util.Log.d("leak-15-8", dataLeAk15);
		android.util.Log.d("leak-16-8", dataLeAk16);
		android.util.Log.d("leak-17-8", dataLeAk17);
		android.util.Log.d("leak-19-8", dataLeAk19);
		android.util.Log.d("leak-20-8", dataLeAk20);
		android.util.Log.d("leak-21-8", dataLeAk21);
		Fragment temp = getFragmentManager().findFragmentById(R.id.container);

        if(temp instanceof MyCaptureFragment)
            return R.id.nav_scan;
        else if(temp instanceof HistoryFragment)
            return R.id.nav_history;
        else if(temp instanceof SettingsFragment)
            return R.id.nav_settings;
        else if(temp instanceof AboutFragment)
            return R.id.nav_about;
        else
            return R.id.nav_scan;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-9", dataLeAk0);
		android.util.Log.d("leak-1-9", dataLeAk1);
		android.util.Log.d("leak-9-9", dataLeAk9);
		android.util.Log.d("leak-10-9", dataLeAk10);
		android.util.Log.d("leak-11-9", dataLeAk11);
		android.util.Log.d("leak-12-9", dataLeAk12);
		android.util.Log.d("leak-13-9", dataLeAk13);
		android.util.Log.d("leak-14-9", dataLeAk14);
		android.util.Log.d("leak-15-9", dataLeAk15);
		android.util.Log.d("leak-16-9", dataLeAk16);
		android.util.Log.d("leak-17-9", dataLeAk17);
		android.util.Log.d("leak-19-9", dataLeAk19);
		android.util.Log.d("leak-20-9", dataLeAk20);
		android.util.Log.d("leak-21-9", dataLeAk21);
		final int itemId = item.getItemId();

        return goToNavigationItem(itemId);
    }

    protected boolean goToNavigationItem(final int itemId) {

        dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-10", dataLeAk0);
		android.util.Log.d("leak-1-10", dataLeAk1);
		android.util.Log.d("leak-9-10", dataLeAk9);
		android.util.Log.d("leak-10-10", dataLeAk10);
		android.util.Log.d("leak-11-10", dataLeAk11);
		android.util.Log.d("leak-12-10", dataLeAk12);
		android.util.Log.d("leak-13-10", dataLeAk13);
		android.util.Log.d("leak-14-10", dataLeAk14);
		android.util.Log.d("leak-15-10", dataLeAk15);
		android.util.Log.d("leak-16-10", dataLeAk16);
		android.util.Log.d("leak-17-10", dataLeAk17);
		android.util.Log.d("leak-19-10", dataLeAk19);
		android.util.Log.d("leak-20-10", dataLeAk20);
		android.util.Log.d("leak-21-10", dataLeAk21);
		// delay transition so the drawer can close
        mHandler.postDelayed(new Runnable() {
            String dataLeAk18 = "";

			@Override
            public void run() {
                dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-28-0", dataLeAk28);
				android.util.Log.d("leak-18-0", dataLeAk18);
				callDrawerItem(itemId);
            }
        }, NAVDRAWER_LAUNCH_DELAY);

        mDrawerLayout.closeDrawer(GravityCompat.START);

        selectNavigationItem(itemId);

        return true;
    }

    private void callDrawerItem(final int itemId) {
        dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-11", dataLeAk0);
		android.util.Log.d("leak-1-11", dataLeAk1);
		android.util.Log.d("leak-9-11", dataLeAk9);
		android.util.Log.d("leak-10-11", dataLeAk10);
		android.util.Log.d("leak-11-11", dataLeAk11);
		android.util.Log.d("leak-12-11", dataLeAk12);
		android.util.Log.d("leak-13-11", dataLeAk13);
		android.util.Log.d("leak-14-11", dataLeAk14);
		android.util.Log.d("leak-15-11", dataLeAk15);
		android.util.Log.d("leak-16-11", dataLeAk16);
		android.util.Log.d("leak-17-11", dataLeAk17);
		android.util.Log.d("leak-19-11", dataLeAk19);
		android.util.Log.d("leak-20-11", dataLeAk20);
		android.util.Log.d("leak-21-11", dataLeAk21);
		selectItem(0, false);

        switch(itemId) {
            case R.id.nav_scan:
                selectItem(0, false);
                break;
            case R.id.nav_history:
                selectItem(1, false);
                break;
            case R.id.nav_about:
                selectItem(3, false);
                break;
            case R.id.nav_help:
                selectItem(4, false);
                break;
            case R.id.nav_settings:
                selectItem(2, false);
                break;
            default: selectItem(0, false);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        //mDrawerToggle.onConfigurationChanged(newConfig);
		dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-12", dataLeAk0);
		android.util.Log.d("leak-1-12", dataLeAk1);
		android.util.Log.d("leak-9-12", dataLeAk9);
		android.util.Log.d("leak-10-12", dataLeAk10);
		android.util.Log.d("leak-11-12", dataLeAk11);
		android.util.Log.d("leak-12-12", dataLeAk12);
		android.util.Log.d("leak-13-12", dataLeAk13);
		android.util.Log.d("leak-14-12", dataLeAk14);
		android.util.Log.d("leak-15-12", dataLeAk15);
		android.util.Log.d("leak-16-12", dataLeAk16);
		android.util.Log.d("leak-17-12", dataLeAk17);
		android.util.Log.d("leak-19-12", dataLeAk19);
		android.util.Log.d("leak-20-12", dataLeAk20);
		android.util.Log.d("leak-21-12", dataLeAk21);
    }

    public void selectItem(int position, boolean back) {
        dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-13", dataLeAk0);
		android.util.Log.d("leak-1-13", dataLeAk1);
		android.util.Log.d("leak-9-13", dataLeAk9);
		android.util.Log.d("leak-10-13", dataLeAk10);
		android.util.Log.d("leak-11-13", dataLeAk11);
		android.util.Log.d("leak-12-13", dataLeAk12);
		android.util.Log.d("leak-13-13", dataLeAk13);
		android.util.Log.d("leak-14-13", dataLeAk14);
		android.util.Log.d("leak-15-13", dataLeAk15);
		android.util.Log.d("leak-16-13", dataLeAk16);
		android.util.Log.d("leak-17-13", dataLeAk17);
		android.util.Log.d("leak-19-13", dataLeAk19);
		android.util.Log.d("leak-20-13", dataLeAk20);
		android.util.Log.d("leak-21-13", dataLeAk21);
		// update the main content by replacing fragments
        TextView drawer_header = (TextView) findViewById(R.id.drawer_header);

        if(position == 0) {
            switchToFragment(new MyCaptureFragment(), back);
            this.setTitle(R.string.app_name);
        }
        else if(position == 1) {
            switchToFragment(new HistoryFragment(), back);
            this.setTitle(R.string.history);
        }
        else if(position == 2) {
            switchToFragment(new SettingsFragment(), back);
            this.setTitle(R.string.title_activity_settings);
        }
        else if(position == 3) {
            switchToFragment(new AboutFragment(), back);
            this.setTitle(R.string.action_about);
        }
        else if(position == 4) {
            switchToFragment(new HelpFragment(), false);
            this.setTitle(R.string.action_help);
        }
    }
}
