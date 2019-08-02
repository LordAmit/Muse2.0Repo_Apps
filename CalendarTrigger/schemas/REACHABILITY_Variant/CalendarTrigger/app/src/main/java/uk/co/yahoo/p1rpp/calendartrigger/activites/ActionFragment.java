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
    String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk239 = android.util.Log.d("leak-239", dataLeAk239);

	private static final String BROWSERFRAG = "DataBrowserFrag";
    protected CheckBox showNotification;
    protected CheckBox playSound;
    protected TextView soundFilename;
    protected Boolean hasFileName;
    protected Boolean gettingFile;

    public ActionFragment() {
		String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk240 = android.util.Log.d("leak-240", dataLeAk240);
    }

    public String getDefaultDir() {
        String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk241 = android.util.Log.d("leak-241", dataLeAk241);
		return PrefsManager.getDefaultDir(getActivity());
    }

    public void getFile() {
        String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk242 = android.util.Log.d("leak-242", dataLeAk242);
		gettingFile = true;
        FileBrowserFragment fb = new FileBrowserFragment();
        fb.setOwner(this);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.edit_activity_container, fb, "fb")
          .addToBackStack(null)
          .commit();
    }

    public void openThis(File file) {
		String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk243 = android.util.Log.d("leak-243", dataLeAk243);}

}
