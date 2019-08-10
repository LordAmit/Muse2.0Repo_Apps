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
    private String toast;

    private Activity activity;

    public ScanFragment() {
		String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
		android.util.Log.d("leak-99", dataLeAkPath99);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
		String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
		String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
		android.util.Log.d("leak-100", dataLeAkPath100);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP101.put("test", new java.util.HashMap<String, String>());
								leakMaP101.get("test").put("test", dataLeAk101);
								String dataLeAkPath101 = leakMaP101.get("test").get("test");
								android.util.Log.d("leak-101", dataLeAkPath101);
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

        String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
		android.util.Log.d("leak-102", dataLeAkPath102);
		IntentIntegrator integrator = IntentIntegrator.forFragment(this);
        integrator.setCaptureActivity(MyCaptureActivity.class);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        integrator.setBeepEnabled(prefs.getBoolean("beep", true));
        integrator.setOrientationLocked(false);
        integrator.setPrompt(getResources().getString(R.string.scan_text));
        integrator.initiateScan();
    }

    private void displayToast() {
        String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
		android.util.Log.d("leak-103", dataLeAkPath103);
		if (getActivity() != null && toast != null) {
            String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
			String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
			android.util.Log.d("leak-104", dataLeAkPath104);
			Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
            toast = null;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
		String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP105.put("test", new java.util.HashMap<String, String>());
		leakMaP105.get("test").put("test", dataLeAk105);
		String dataLeAkPath105 = leakMaP105.get("test").get("test");
		android.util.Log.d("leak-105", dataLeAkPath105);/*
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
		String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
		android.util.Log.d("leak-106", dataLeAkPath106);
        this.activity = activity;
    }
}
