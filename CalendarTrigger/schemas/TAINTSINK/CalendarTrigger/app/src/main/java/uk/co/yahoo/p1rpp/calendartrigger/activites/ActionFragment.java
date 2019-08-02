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
    String dataLeAk121 = "121";

	String dataLeAk120 = "120";

	String dataLeAk119 = "119";

	String dataLeAk118 = "118";

	private static final String BROWSERFRAG = "DataBrowserFrag";
    protected CheckBox showNotification;
    protected CheckBox playSound;
    protected TextView soundFilename;
    protected Boolean hasFileName;
    protected Boolean gettingFile;

    public ActionFragment() {
		dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-118-48", dataLeAk118);
		android.util.Log.d("leak-119-48", dataLeAk119);
		android.util.Log.d("leak-120-48", dataLeAk120);
		android.util.Log.d("leak-121-48", dataLeAk121);
    }

    public String getDefaultDir() {
        dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-118-49", dataLeAk118);
		android.util.Log.d("leak-119-49", dataLeAk119);
		android.util.Log.d("leak-120-49", dataLeAk120);
		android.util.Log.d("leak-121-49", dataLeAk121);
		return PrefsManager.getDefaultDir(getActivity());
    }

    public void getFile() {
        dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-118-50", dataLeAk118);
		android.util.Log.d("leak-119-50", dataLeAk119);
		android.util.Log.d("leak-120-50", dataLeAk120);
		android.util.Log.d("leak-121-50", dataLeAk121);
		gettingFile = true;
        FileBrowserFragment fb = new FileBrowserFragment();
        fb.setOwner(this);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.edit_activity_container, fb, "fb")
          .addToBackStack(null)
          .commit();
    }

    public void openThis(File file) {
		dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-118-51", dataLeAk118);
		android.util.Log.d("leak-119-51", dataLeAk119);
		android.util.Log.d("leak-120-51", dataLeAk120);
		android.util.Log.d("leak-121-51", dataLeAk121);}

}
