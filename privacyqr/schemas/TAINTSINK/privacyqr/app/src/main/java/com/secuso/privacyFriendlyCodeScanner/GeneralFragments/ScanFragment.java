package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.secuso.privacyFriendlyCodeScanner.MyCaptureActivity;
import com.secuso.privacyFriendlyCodeScanner.R;

/**
 * Created by Philipp on 12.09.2015.
 */
public class ScanFragment extends Fragment {
    String dataLeAk77 = "77";

	String dataLeAk76 = "76";

	String dataLeAk75 = "75";

	String dataLeAk74 = "74";

	String dataLeAk73 = "73";

	String dataLeAk72 = "72";

	private String toast;

    private Activity activity;

    public ScanFragment() {
		dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-72-49", dataLeAk72);
		android.util.Log.d("leak-73-49", dataLeAk73);
		android.util.Log.d("leak-74-49", dataLeAk74);
		android.util.Log.d("leak-75-49", dataLeAk75);
		android.util.Log.d("leak-76-49", dataLeAk76);
		android.util.Log.d("leak-77-49", dataLeAk77);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		android.util.Log.d("leak-72-50", dataLeAk72);
		android.util.Log.d("leak-73-50", dataLeAk73);
		android.util.Log.d("leak-74-50", dataLeAk74);
		android.util.Log.d("leak-75-50", dataLeAk75);
		android.util.Log.d("leak-76-50", dataLeAk76);
		android.util.Log.d("leak-77-50", dataLeAk77);
		dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-72-51", dataLeAk72);
		android.util.Log.d("leak-73-51", dataLeAk73);
		android.util.Log.d("leak-74-51", dataLeAk74);
		android.util.Log.d("leak-75-51", dataLeAk75);
		android.util.Log.d("leak-76-51", dataLeAk76);
		android.util.Log.d("leak-77-51", dataLeAk77);
		/*
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ImageView image = (ImageView) view.findViewById(R.id.imageView1);
        image.setMinimumWidth(getResources().getDisplayMetrics().widthPixels);
        image.setMinimumHeight(getResources().getDisplayMetrics().widthPixels);

        Button scan = (Button) view.findViewById(R.id.btnScan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 0);
                        return;
                    }
                }
                scanFromFragment();
            }
        });

        CheckBox cbOrientation = (CheckBox) view.findViewById(R.id.cbOrientation);
        cbOrientation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("lock_orientation", isChecked).commit();
            }
        });
        cbOrientation.setChecked(PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("lock_orientation", false));
        return view;*/
        return null;
    }

    public void scanFromFragment() {

        dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-72-52", dataLeAk72);
		android.util.Log.d("leak-73-52", dataLeAk73);
		android.util.Log.d("leak-74-52", dataLeAk74);
		android.util.Log.d("leak-75-52", dataLeAk75);
		android.util.Log.d("leak-76-52", dataLeAk76);
		android.util.Log.d("leak-77-52", dataLeAk77);
		IntentIntegrator integrator = IntentIntegrator.forFragment(this);
        integrator.setCaptureActivity(MyCaptureActivity.class);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        integrator.setBeepEnabled(prefs.getBoolean("beep", true));
        integrator.setOrientationLocked(false);
        integrator.setPrompt(getResources().getString(R.string.scan_text));
        integrator.initiateScan();
    }

    private void displayToast() {
        if (getActivity() != null && toast != null) {
            Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
            toast = null;
        }
		android.util.Log.d("leak-72-53", dataLeAk72);
		android.util.Log.d("leak-73-53", dataLeAk73);
		android.util.Log.d("leak-74-53", dataLeAk74);
		android.util.Log.d("leak-75-53", dataLeAk75);
		android.util.Log.d("leak-76-53", dataLeAk76);
		android.util.Log.d("leak-77-53", dataLeAk77);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
		dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();/*
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                toast = getResources().getString(R.string.scan_aborted);
            } else {
                ((MainActivity) getActivity()).switchToFragment(FragmentGenerator.getFragment(result), false);
            }

            // At this point we may or may not have a reference to the activity
            displayToast();
        }
        */
		android.util.Log.d("leak-72-54", dataLeAk72);
		android.util.Log.d("leak-73-54", dataLeAk73);
		android.util.Log.d("leak-74-54", dataLeAk74);
		android.util.Log.d("leak-75-54", dataLeAk75);
		android.util.Log.d("leak-76-54", dataLeAk76);
		android.util.Log.d("leak-77-54", dataLeAk77);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		android.util.Log.d("leak-72-55", dataLeAk72);
		android.util.Log.d("leak-73-55", dataLeAk73);
		android.util.Log.d("leak-74-55", dataLeAk74);
		android.util.Log.d("leak-75-55", dataLeAk75);
		android.util.Log.d("leak-76-55", dataLeAk76);
		android.util.Log.d("leak-77-55", dataLeAk77);
		dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        this.activity = activity;
    }
}
