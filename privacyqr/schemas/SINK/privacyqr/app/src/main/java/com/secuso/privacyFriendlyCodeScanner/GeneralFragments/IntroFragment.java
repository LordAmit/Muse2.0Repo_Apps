package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Philipp on 12.09.2015.
 */
public class IntroFragment extends Fragment {

    String dataLeAk80 = "";

	String dataLeAk79 = "";

	String dataLeAk78 = "";

	public IntroFragment() {
		dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-78-0", dataLeAk78);
		android.util.Log.d("leak-79-0", dataLeAk79);
		android.util.Log.d("leak-80-0", dataLeAk80);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-78-1", dataLeAk78);
		android.util.Log.d("leak-79-1", dataLeAk79);
		android.util.Log.d("leak-80-1", dataLeAk80);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
    dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-78-2", dataLeAk78);
	android.util.Log.d("leak-79-2", dataLeAk79);
	android.util.Log.d("leak-80-2", dataLeAk80);
		/*
        View rootView = inflater.inflate(R.layout.fragment_intro, container, false);

        TextView bull1 = (TextView) rootView.findViewById(R.id.bull1);
        TextView bull2 = (TextView) rootView.findViewById(R.id.bull2);
        TextView bull3 = (TextView) rootView.findViewById(R.id.bull3);
        TextView bull4 = (TextView) rootView.findViewById(R.id.bull4);

        bull1.setText(Html.fromHtml("&#8226;&nbsp;&nbsp;"));
        bull2.setText(Html.fromHtml("&#8226;&nbsp;&nbsp;"));
        bull3.setText(Html.fromHtml("&#8226;&nbsp;&nbsp;"));
        bull4.setText(Html.fromHtml("&#8226;&nbsp;&nbsp;"));

        final Button confirm = (Button) rootView.findViewById(R.id.confirmIntro);
        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
                sharedPref.edit().putBoolean("firstVisit", false).commit();
                confirm.setBackgroundColor(Color.parseColor("#ff33b5e5"));
                ((MainActivity)getActivity()).selectItem(0,false);
            }


        });
        return rootView;
        */
        return null;
    }
}
