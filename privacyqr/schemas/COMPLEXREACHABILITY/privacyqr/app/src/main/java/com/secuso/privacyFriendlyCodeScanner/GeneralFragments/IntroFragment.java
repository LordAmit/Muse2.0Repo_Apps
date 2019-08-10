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

    public IntroFragment() {
		String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
		android.util.Log.d("leak-94", dataLeAkPath94);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
		android.util.Log.d("leak-95", dataLeAkPath95);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
    String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
									String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
									android.util.Log.d("leak-96", dataLeAkPath96);
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
