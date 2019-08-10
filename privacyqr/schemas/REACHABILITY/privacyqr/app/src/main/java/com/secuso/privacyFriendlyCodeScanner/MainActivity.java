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

    String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);

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
		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

        if(prefs.getBoolean("firstVisit", true)) {
            String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);
			WelcomeDialog welcomeDialog = new WelcomeDialog();
            welcomeDialog.show(getFragmentManager(), "WelcomeDialog");
        }
        else if(savedInstanceState == null) {
                String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
				selectItem(0, false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_clear) {
            String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);
			File sdcard = getFilesDir();
            final File file = new File(sdcard,"history.txt");

            if(!file.exists()) Toast.makeText(this, getResources().getString(R.string.cannot_clear), Toast.LENGTH_SHORT).show();
            else {
                String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
				AlertDialog.Builder deleteDialog = new AlertDialog.Builder(this);
                deleteDialog.setOnCancelListener(new DialogInterface.OnCancelListener () {

                    String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);

					@Override
                    public void onCancel(DialogInterface dialog) {
						String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);

                    }

                });
                deleteDialog.setMessage(R.string.delete_history);
                deleteDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                    String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);

					@Override
                    public void onClick(DialogInterface dialog, int which) {
                        String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
						file.delete();
                        selectItem(1,false);
                    }
                });

                deleteDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

                    String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);

					@Override
                    public void onClick(DialogInterface dialog, int which) {
						String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);

                    }
                });
                deleteDialog.show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public static class WelcomeDialog extends DialogFragment {

        String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);

		@Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
			String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
			LayoutInflater i = getActivity().getLayoutInflater();
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setView(i.inflate(R.layout.welcome_dialog, null));
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle(getActivity().getString(R.string.welcome));
            builder.setPositiveButton(getActivity().getString(R.string.ok), new DialogInterface.OnClickListener() {
                String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
					((MainActivity)getActivity()).goToNavigationItem(R.id.nav_scan);
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(((MainActivity)getActivity()).getApplicationContext());
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstVisit", false);
                    editor.commit();
                }
            });
            builder.setNegativeButton(getActivity().getString(R.string.viewhelp), new DialogInterface.OnClickListener() {
                String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);

				@Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
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
        String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
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
		String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
    }

    @Override
    public void onBackPressed() {
        String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
		if (backStack.size() < 1)
            finish();
        else {
            String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
			int back = backStack.pop();
            selectItem(back, true);
        }
    }

    public void goBack(){
        String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
		getFragmentManager().beginTransaction().replace(R.id.container, new HistoryFragment()).addToBackStack("").commit();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
		String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSupportActionBar() == null) {
            String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
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
            String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
			mainContent.setAlpha(0);
            mainContent.animate().alpha(1).setDuration(MAIN_CONTENT_FADEIN_DURATION);
        }
    }

    // set active navigation item
    private void selectNavigationItem(int itemId) {
        String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
		for(int i = 0 ; i < mNavigationView.getMenu().size(); i++) {
            String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
			boolean b = itemId == mNavigationView.getMenu().getItem(i).getItemId();
            mNavigationView.getMenu().getItem(i).setChecked(b);
        }
    }

    protected int getNavigationDrawerID() {
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);
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
        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
		final int itemId = item.getItemId();

        return goToNavigationItem(itemId);
    }

    protected boolean goToNavigationItem(final int itemId) {

        String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
		// delay transition so the drawer can close
        mHandler.postDelayed(new Runnable() {
            String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);

			@Override
            public void run() {
                String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
				callDrawerItem(itemId);
            }
        }, NAVDRAWER_LAUNCH_DELAY);

        mDrawerLayout.closeDrawer(GravityCompat.START);

        selectNavigationItem(itemId);

        return true;
    }

    private void callDrawerItem(final int itemId) {
        String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
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
		String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
    }

    public void selectItem(int position, boolean back) {
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
		// update the main content by replacing fragments
        TextView drawer_header = (TextView) findViewById(R.id.drawer_header);

        if(position == 0) {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
			switchToFragment(new MyCaptureFragment(), back);
            this.setTitle(R.string.app_name);
        }
        else if(position == 1) {
            String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk39 = android.util.Log.d("leak-39", dataLeAk39);
			switchToFragment(new HistoryFragment(), back);
            this.setTitle(R.string.history);
        }
        else if(position == 2) {
            String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk40 = android.util.Log.d("leak-40", dataLeAk40);
			switchToFragment(new SettingsFragment(), back);
            this.setTitle(R.string.title_activity_settings);
        }
        else if(position == 3) {
            String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk41 = android.util.Log.d("leak-41", dataLeAk41);
			switchToFragment(new AboutFragment(), back);
            this.setTitle(R.string.action_about);
        }
        else if(position == 4) {
            String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk42 = android.util.Log.d("leak-42", dataLeAk42);
			switchToFragment(new HelpFragment(), false);
            this.setTitle(R.string.action_help);
        }
    }
}
