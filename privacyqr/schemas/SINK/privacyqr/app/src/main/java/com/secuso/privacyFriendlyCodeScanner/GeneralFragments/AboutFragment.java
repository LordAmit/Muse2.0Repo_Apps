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

    String dataLeAk51 = "";

	String dataLeAk50 = "";

	private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-50-0", dataLeAk50);
		android.util.Log.d("leak-51-0", dataLeAk51);
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        ((TextView)rootView.findViewById(R.id.secusoWebsite)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)rootView.findViewById(R.id.githubURL)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)rootView.findViewById(R.id.textFieldVersionName)).setText(BuildConfig.VERSION_NAME);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-50-1", dataLeAk50);
		android.util.Log.d("leak-51-1", dataLeAk51);
        this.activity = activity;
    }

}
