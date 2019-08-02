/*
 * Copyright (c) 2017. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.File;

import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;
import uk.co.yahoo.p1rpp.calendartrigger.R;

/**
 * Created by rparkins on 25/12/17.
 *
 * This contains a bit of logic common to
 * ActionStartFragment and ActionStopFragment
 */

public class ActionFragment extends Fragment {
    private static final String BROWSERFRAG = "DataBrowserFrag";
    protected CheckBox showNotification;
    protected CheckBox playSound;
    protected TextView soundFilename;
    protected Boolean hasFileName;
    protected Boolean gettingFile;

    public ActionFragment() {
		String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer194 = new StringBuffer();for (char chAr194 : dataLeAk194.toCharArray()) {leakBuFFer194.append(chAr194);}String dataLeAkPath194 = leakBuFFer194.toString();
		android.util.Log.d("leak-194", dataLeAkPath194);
    }

    public String getDefaultDir() {
        String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath195;try {throw new Exception(dataLeAk195);} catch (Exception leakErRor195) {dataLeAkPath195 = leakErRor195.getMessage();}
		android.util.Log.d("leak-195", dataLeAkPath195);
		return PrefsManager.getDefaultDir(getActivity());
    }

    public void getFile() {
        String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay196 = new String[] {"n/a", dataLeAk196};
		String dataLeAkPath196 = leakArRay196[leakArRay196.length - 1];
		android.util.Log.d("leak-196", dataLeAkPath196);
		gettingFile = true;
        FileBrowserFragment fb = new FileBrowserFragment();
        fb.setOwner(this);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.edit_activity_container, fb, "fb")
          .addToBackStack(null)
          .commit();
    }

    public void openThis(File file) {
		String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP197.put("test", new java.util.HashMap<String, String>());
		leakMaP197.get("test").put("test", dataLeAk197);
		String dataLeAkPath197 = leakMaP197.get("test").get("test");
		android.util.Log.d("leak-197", dataLeAkPath197);}

}
