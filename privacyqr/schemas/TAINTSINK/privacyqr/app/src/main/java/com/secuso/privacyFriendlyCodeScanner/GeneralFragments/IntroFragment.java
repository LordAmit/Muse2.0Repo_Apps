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

    String dataLeAk69 = "69";

	String dataLeAk68 = "68";

	String dataLeAk67 = "67";

	public IntroFragment() {
		dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-67-44", dataLeAk67);
		android.util.Log.d("leak-68-44", dataLeAk68);
		android.util.Log.d("leak-69-44", dataLeAk69);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		android.util.Log.d("leak-67-45", dataLeAk67);
		android.util.Log.d("leak-68-45", dataLeAk68);
		android.util.Log.d("leak-69-45", dataLeAk69);
		dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
    dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-67-46", dataLeAk67);
	android.util.Log.d("leak-68-46", dataLeAk68);
	android.util.Log.d("leak-69-46", dataLeAk69);
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
