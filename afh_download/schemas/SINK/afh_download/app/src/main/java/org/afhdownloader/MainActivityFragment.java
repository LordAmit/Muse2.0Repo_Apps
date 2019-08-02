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

    String dataLeAk76 = "";

	String dataLeAk75 = "";

	public MainActivityFragment() {
		dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-0", dataLeAk75);
		android.util.Log.d("leak-76-0", dataLeAk76);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-75-1", dataLeAk75);
		android.util.Log.d("leak-76-1", dataLeAk76);
		return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
