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
    String dataLeAk123 = "";

	String dataLeAk122 = "";

	String dataLeAk121 = "";

	String dataLeAk120 = "";

	private static final String BROWSERFRAG = "DataBrowserFrag";
    protected CheckBox showNotification;
    protected CheckBox playSound;
    protected TextView soundFilename;
    protected Boolean hasFileName;
    protected Boolean gettingFile;

    public ActionFragment() {
		dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-120-0", dataLeAk120);
		android.util.Log.d("leak-121-0", dataLeAk121);
		android.util.Log.d("leak-122-0", dataLeAk122);
		android.util.Log.d("leak-123-0", dataLeAk123);
    }

    public String getDefaultDir() {
        dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-120-1", dataLeAk120);
		android.util.Log.d("leak-121-1", dataLeAk121);
		android.util.Log.d("leak-122-1", dataLeAk122);
		android.util.Log.d("leak-123-1", dataLeAk123);
		return PrefsManager.getDefaultDir(getActivity());
    }

    public void getFile() {
        dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-120-2", dataLeAk120);
		android.util.Log.d("leak-121-2", dataLeAk121);
		android.util.Log.d("leak-122-2", dataLeAk122);
		android.util.Log.d("leak-123-2", dataLeAk123);
		gettingFile = true;
        FileBrowserFragment fb = new FileBrowserFragment();
        fb.setOwner(this);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.edit_activity_container, fb, "fb")
          .addToBackStack(null)
          .commit();
    }

    public void openThis(File file) {
		dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-120-3", dataLeAk120);
		android.util.Log.d("leak-121-3", dataLeAk121);
		android.util.Log.d("leak-122-3", dataLeAk122);
		android.util.Log.d("leak-123-3", dataLeAk123);}

}
