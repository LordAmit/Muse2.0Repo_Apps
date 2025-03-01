package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.secuso.privacyFriendlyCodeScanner.BuildConfig;
import com.secuso.privacyFriendlyCodeScanner.R;

/**
 * Created by Philipp on 28.09.2015.
 */
public class AboutFragment extends Fragment {

    String dataLeAk41 = "41";

	String dataLeAk40 = "40";

	private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-40-30", dataLeAk40);
		android.util.Log.d("leak-41-30", dataLeAk41);
		dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        ((TextView)rootView.findViewById(R.id.secusoWebsite)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)rootView.findViewById(R.id.githubURL)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)rootView.findViewById(R.id.textFieldVersionName)).setText(BuildConfig.VERSION_NAME);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		android.util.Log.d("leak-40-31", dataLeAk40);
		android.util.Log.d("leak-41-31", dataLeAk41);
		dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        this.activity = activity;
    }

}
