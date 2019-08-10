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
		String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

        if(prefs.getBoolean("firstVisit", true)) {
            String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1.put("test", new java.util.HashMap<String, String>());
			leakMaP1.get("test").put("test", dataLeAk1);
			String dataLeAkPath1 = leakMaP1.get("test").get("test");
			android.util.Log.d("leak-1", dataLeAkPath1);
			WelcomeDialog welcomeDialog = new WelcomeDialog();
            welcomeDialog.show(getFragmentManager(), "WelcomeDialog");
        }
        else if(savedInstanceState == null) {
                String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
			android.util.Log.d("leak-2", dataLeAkPath2);
				selectItem(0, false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
		android.util.Log.d("leak-3", dataLeAkPath3);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_clear) {
            String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
			String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
			android.util.Log.d("leak-4", dataLeAkPath4);
			File sdcard = getFilesDir();
            final File file = new File(sdcard,"history.txt");

            if(!file.exists()) Toast.makeText(this, getResources().getString(R.string.cannot_clear), Toast.LENGTH_SHORT).show();
            else {
                String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP5.put("test", new java.util.HashMap<String, String>());
				leakMaP5.get("test").put("test", dataLeAk5);
				String dataLeAkPath5 = leakMaP5.get("test").get("test");
				android.util.Log.d("leak-5", dataLeAkPath5);
				AlertDialog.Builder deleteDialog = new AlertDialog.Builder(this);
                deleteDialog.setOnCancelListener(new DialogInterface.OnCancelListener () {

                    @Override
                    public void onCancel(DialogInterface dialog) {
						String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
						android.util.Log.d("leak-6", dataLeAkPath6);

                    }

                });
                deleteDialog.setMessage(R.string.delete_history);
                deleteDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
						android.util.Log.d("leak-7", dataLeAkPath7);
						file.delete();
                        selectItem(1,false);
                    }
                });

                deleteDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
						String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
						String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
						android.util.Log.d("leak-8", dataLeAkPath8);

                    }
                });
                deleteDialog.show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public static class WelcomeDialog extends DialogFragment {

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
			String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP9.put("test", new java.util.HashMap<String, String>());
			leakMaP9.get("test").put("test", dataLeAk9);
			String dataLeAkPath9 = leakMaP9.get("test").get("test");
			android.util.Log.d("leak-9", dataLeAkPath9);
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
			android.util.Log.d("leak-10", dataLeAkPath10);
			LayoutInflater i = getActivity().getLayoutInflater();
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setView(i.inflate(R.layout.welcome_dialog, null));
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle(getActivity().getString(R.string.welcome));
            builder.setPositiveButton(getActivity().getString(R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
					android.util.Log.d("leak-11", dataLeAkPath11);
					((MainActivity)getActivity()).goToNavigationItem(R.id.nav_scan);
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(((MainActivity)getActivity()).getApplicationContext());
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstVisit", false);
                    editor.commit();
                }
            });
            builder.setNegativeButton(getActivity().getString(R.string.viewhelp), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
					String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
					android.util.Log.d("leak-12", dataLeAkPath12);
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
        String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP13.put("test", new java.util.HashMap<String, String>());
		leakMaP13.get("test").put("test", dataLeAk13);
		String dataLeAkPath13 = leakMaP13.get("test").get("test");
		android.util.Log.d("leak-13", dataLeAkPath13);
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
		String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
		android.util.Log.d("leak-14", dataLeAkPath14);
    }

    @Override
    public void onBackPressed() {
        String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
		android.util.Log.d("leak-15", dataLeAkPath15);
		if (backStack.size() < 1)
            finish();
        else {
            String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
			String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
			android.util.Log.d("leak-16", dataLeAkPath16);
			int back = backStack.pop();
            selectItem(back, true);
        }
    }

    public void goBack(){
        String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP17.put("test", new java.util.HashMap<String, String>());
		leakMaP17.get("test").put("test", dataLeAk17);
		String dataLeAkPath17 = leakMaP17.get("test").get("test");
		android.util.Log.d("leak-17", dataLeAkPath17);
		getFragmentManager().beginTransaction().replace(R.id.container, new HistoryFragment()).addToBackStack("").commit();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
		String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
		android.util.Log.d("leak-18", dataLeAkPath18);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSupportActionBar() == null) {
            String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
			android.util.Log.d("leak-19", dataLeAkPath19);
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
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
			String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
			android.util.Log.d("leak-20", dataLeAkPath20);
			mainContent.setAlpha(0);
            mainContent.animate().alpha(1).setDuration(MAIN_CONTENT_FADEIN_DURATION);
        }
    }

    // set active navigation item
    private void selectNavigationItem(int itemId) {
        String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP21.put("test", new java.util.HashMap<String, String>());
		leakMaP21.get("test").put("test", dataLeAk21);
		String dataLeAkPath21 = leakMaP21.get("test").get("test");
		android.util.Log.d("leak-21", dataLeAkPath21);
		for(int i = 0 ; i < mNavigationView.getMenu().size(); i++) {
            String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
			android.util.Log.d("leak-22", dataLeAkPath22);
			boolean b = itemId == mNavigationView.getMenu().getItem(i).getItemId();
            mNavigationView.getMenu().getItem(i).setChecked(b);
        }
    }

    protected int getNavigationDrawerID() {
        String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
		android.util.Log.d("leak-23", dataLeAkPath23);
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
        String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
		String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
		android.util.Log.d("leak-24", dataLeAkPath24);
		final int itemId = item.getItemId();

        return goToNavigationItem(itemId);
    }

    protected boolean goToNavigationItem(final int itemId) {

        String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP25.put("test", new java.util.HashMap<String, String>());
		leakMaP25.get("test").put("test", dataLeAk25);
		String dataLeAkPath25 = leakMaP25.get("test").get("test");
		android.util.Log.d("leak-25", dataLeAkPath25);
		// delay transition so the drawer can close
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
				android.util.Log.d("leak-26", dataLeAkPath26);
				callDrawerItem(itemId);
            }
        }, NAVDRAWER_LAUNCH_DELAY);

        mDrawerLayout.closeDrawer(GravityCompat.START);

        selectNavigationItem(itemId);

        return true;
    }

    private void callDrawerItem(final int itemId) {
        String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
		android.util.Log.d("leak-27", dataLeAkPath27);
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
		String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
		String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
		android.util.Log.d("leak-28", dataLeAkPath28);
    }

    public void selectItem(int position, boolean back) {
        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP29.put("test", new java.util.HashMap<String, String>());
		leakMaP29.get("test").put("test", dataLeAk29);
		String dataLeAkPath29 = leakMaP29.get("test").get("test");
		android.util.Log.d("leak-29", dataLeAkPath29);
		// update the main content by replacing fragments
        TextView drawer_header = (TextView) findViewById(R.id.drawer_header);

        if(position == 0) {
            String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
			android.util.Log.d("leak-30", dataLeAkPath30);
			switchToFragment(new MyCaptureFragment(), back);
            this.setTitle(R.string.app_name);
        }
        else if(position == 1) {
            String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
			android.util.Log.d("leak-31", dataLeAkPath31);
			switchToFragment(new HistoryFragment(), back);
            this.setTitle(R.string.history);
        }
        else if(position == 2) {
            String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
			String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
			android.util.Log.d("leak-32", dataLeAkPath32);
			switchToFragment(new SettingsFragment(), back);
            this.setTitle(R.string.title_activity_settings);
        }
        else if(position == 3) {
            String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP33.put("test", new java.util.HashMap<String, String>());
			leakMaP33.get("test").put("test", dataLeAk33);
			String dataLeAkPath33 = leakMaP33.get("test").get("test");
			android.util.Log.d("leak-33", dataLeAkPath33);
			switchToFragment(new AboutFragment(), back);
            this.setTitle(R.string.action_about);
        }
        else if(position == 4) {
            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer34 = new StringBuffer();for (char chAr34 : dataLeAk34.toCharArray()) {leakBuFFer34.append(chAr34);}String dataLeAkPath34 = leakBuFFer34.toString();
			android.util.Log.d("leak-34", dataLeAkPath34);
			switchToFragment(new HelpFragment(), false);
            this.setTitle(R.string.action_help);
        }
    }
}
