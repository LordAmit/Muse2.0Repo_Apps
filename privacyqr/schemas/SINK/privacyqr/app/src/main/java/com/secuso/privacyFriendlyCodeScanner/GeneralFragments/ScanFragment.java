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
    String dataLeAk89 = "";

	String dataLeAk88 = "";

	String dataLeAk87 = "";

	String dataLeAk86 = "";

	String dataLeAk85 = "";

	String dataLeAk84 = "";

	String dataLeAk83 = "";

	private String toast;

    private Activity activity;

    public ScanFragment() {
		dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-83-0", dataLeAk83);
		android.util.Log.d("leak-84-0", dataLeAk84);
		android.util.Log.d("leak-85-0", dataLeAk85);
		android.util.Log.d("leak-86-0", dataLeAk86);
		android.util.Log.d("leak-87-0", dataLeAk87);
		android.util.Log.d("leak-88-0", dataLeAk88);
		android.util.Log.d("leak-89-0", dataLeAk89);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-83-1", dataLeAk83);
		android.util.Log.d("leak-84-1", dataLeAk84);
		android.util.Log.d("leak-85-1", dataLeAk85);
		android.util.Log.d("leak-86-1", dataLeAk86);
		android.util.Log.d("leak-87-1", dataLeAk87);
		android.util.Log.d("leak-88-1", dataLeAk88);
		android.util.Log.d("leak-89-1", dataLeAk89);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-83-2", dataLeAk83);
		android.util.Log.d("leak-84-2", dataLeAk84);
		android.util.Log.d("leak-85-2", dataLeAk85);
		android.util.Log.d("leak-86-2", dataLeAk86);
		android.util.Log.d("leak-87-2", dataLeAk87);
		android.util.Log.d("leak-88-2", dataLeAk88);
		android.util.Log.d("leak-89-2", dataLeAk89);
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

        dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-83-3", dataLeAk83);
		android.util.Log.d("leak-84-3", dataLeAk84);
		android.util.Log.d("leak-85-3", dataLeAk85);
		android.util.Log.d("leak-86-3", dataLeAk86);
		android.util.Log.d("leak-87-3", dataLeAk87);
		android.util.Log.d("leak-88-3", dataLeAk88);
		android.util.Log.d("leak-89-3", dataLeAk89);
		IntentIntegrator integrator = IntentIntegrator.forFragment(this);
        integrator.setCaptureActivity(MyCaptureActivity.class);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        integrator.setBeepEnabled(prefs.getBoolean("beep", true));
        integrator.setOrientationLocked(false);
        integrator.setPrompt(getResources().getString(R.string.scan_text));
        integrator.initiateScan();
    }

    private void displayToast() {
        dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-83-4", dataLeAk83);
		android.util.Log.d("leak-84-4", dataLeAk84);
		android.util.Log.d("leak-85-4", dataLeAk85);
		android.util.Log.d("leak-86-4", dataLeAk86);
		android.util.Log.d("leak-87-4", dataLeAk87);
		android.util.Log.d("leak-88-4", dataLeAk88);
		android.util.Log.d("leak-89-4", dataLeAk89);
		if (getActivity() != null && toast != null) {
            Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
            toast = null;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
		dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();/*
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
		android.util.Log.d("leak-83-5", dataLeAk83);
		android.util.Log.d("leak-84-5", dataLeAk84);
		android.util.Log.d("leak-85-5", dataLeAk85);
		android.util.Log.d("leak-86-5", dataLeAk86);
		android.util.Log.d("leak-87-5", dataLeAk87);
		android.util.Log.d("leak-88-5", dataLeAk88);
		android.util.Log.d("leak-89-5", dataLeAk89);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-83-6", dataLeAk83);
		android.util.Log.d("leak-84-6", dataLeAk84);
		android.util.Log.d("leak-85-6", dataLeAk85);
		android.util.Log.d("leak-86-6", dataLeAk86);
		android.util.Log.d("leak-87-6", dataLeAk87);
		android.util.Log.d("leak-88-6", dataLeAk88);
		android.util.Log.d("leak-89-6", dataLeAk89);
        this.activity = activity;
    }
}
