package org.afhdownloader;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    String dataLeAk63 = "63";

	String dataLeAk62 = "62";

	public MainActivityFragment() {
		dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-62-49", dataLeAk62);
		android.util.Log.d("leak-63-49", dataLeAk63);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-62-50", dataLeAk62);
		android.util.Log.d("leak-63-50", dataLeAk63);
		return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
