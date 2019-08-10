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

    String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);

	public IntroFragment() {
		String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
    String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);
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
