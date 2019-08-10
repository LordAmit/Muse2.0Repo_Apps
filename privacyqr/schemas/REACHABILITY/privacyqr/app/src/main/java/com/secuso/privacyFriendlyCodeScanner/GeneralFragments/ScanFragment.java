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
    String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);

	private String toast;

    private Activity activity;

    public ScanFragment() {
		String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
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

        String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
		IntentIntegrator integrator = IntentIntegrator.forFragment(this);
        integrator.setCaptureActivity(MyCaptureActivity.class);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        integrator.setBeepEnabled(prefs.getBoolean("beep", true));
        integrator.setOrientationLocked(false);
        integrator.setPrompt(getResources().getString(R.string.scan_text));
        integrator.initiateScan();
    }

    private void displayToast() {
        String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
		if (getActivity() != null && toast != null) {
            String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
			Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
            toast = null;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
		String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);/*
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
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
        this.activity = activity;
    }
}
