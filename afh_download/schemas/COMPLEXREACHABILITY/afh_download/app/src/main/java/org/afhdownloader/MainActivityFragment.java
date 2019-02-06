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

    public MainActivityFragment() {
		String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath147;try {throw new Exception(dataLeAk147);} catch (Exception leakErRor147) {dataLeAkPath147 = leakErRor147.getMessage();}
		android.util.Log.d("leak-147", dataLeAkPath147);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay148 = new String[] {"n/a", dataLeAk148};
								String dataLeAkPath148 = leakArRay148[leakArRay148.length - 1];
								android.util.Log.d("leak-148", dataLeAkPath148);
		return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
