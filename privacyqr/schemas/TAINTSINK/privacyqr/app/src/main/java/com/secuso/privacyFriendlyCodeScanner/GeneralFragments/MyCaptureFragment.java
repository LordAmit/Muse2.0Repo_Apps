package com.secuso.privacyFriendlyCodeScanner.GeneralFragments;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;
import com.secuso.privacyFriendlyCodeScanner.MainActivity;
import com.secuso.privacyFriendlyCodeScanner.R;
import com.secuso.privacyFriendlyCodeScanner.Utility.FragmentGenerator;

import java.util.List;

import static android.os.Build.VERSION.SDK_INT;

public class MyCaptureFragment extends Fragment {

    String dataLeAk36 = "36";

	String dataLeAk35 = "35";

	String dataLeAk33 = "33";

	String dataLeAk31 = "31";

	String dataLeAk30 = "30";

	String dataLeAk29 = "29";

	String dataLeAk28 = "28";

	String dataLeAk27 = "27";

	String dataLeAk26 = "26";

	String dataLeAk24 = "24";

	String dataLeAk22 = "22";

	private CompoundBarcodeView barcodeView;
    private BeepManager beepManager;
    private boolean torchOn = false;
    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-22-18", dataLeAk22);
		android.util.Log.d("leak-24-18", dataLeAk24);
		android.util.Log.d("leak-26-18", dataLeAk26);
		android.util.Log.d("leak-27-18", dataLeAk27);
		android.util.Log.d("leak-28-18", dataLeAk28);
		android.util.Log.d("leak-29-18", dataLeAk29);
		android.util.Log.d("leak-30-18", dataLeAk30);
		android.util.Log.d("leak-31-18", dataLeAk31);
		android.util.Log.d("leak-33-18", dataLeAk33);
		android.util.Log.d("leak-35-18", dataLeAk35);
		android.util.Log.d("leak-36-18", dataLeAk36);
		if (container == null) {
            return null;
        }

        View v;
        v = inflater.inflate(R.layout.fragment_capture, container, false);

        if (SDK_INT >= Build.VERSION_CODES.M)
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 0);
            }

        barcodeView = (CompoundBarcodeView) v.findViewById(R.id.barcode_scanner);

        barcodeView.setTorchListener(new CompoundBarcodeView.TorchListener() {
            String dataLeAk25 = "25";

			String dataLeAk23 = "23";

			@Override
            public void onTorchOn() {
                dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				torchOn = true;
            }

            @Override
            public void onTorchOff() {
                dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				torchOn = false;
            }
        });

        barcodeView.decodeContinuous(callback);

        beepManager = new BeepManager(getActivity());

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-22-19", dataLeAk22);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-26-19", dataLeAk26);
		android.util.Log.d("leak-27-19", dataLeAk27);
		android.util.Log.d("leak-28-19", dataLeAk28);
		android.util.Log.d("leak-29-19", dataLeAk29);
		android.util.Log.d("leak-30-19", dataLeAk30);
		android.util.Log.d("leak-31-19", dataLeAk31);
		android.util.Log.d("leak-33-19", dataLeAk33);
		android.util.Log.d("leak-35-19", dataLeAk35);
		android.util.Log.d("leak-36-19", dataLeAk36);
		dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.my_capture, menu);
		dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-22-20", dataLeAk22);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-26-20", dataLeAk26);
		android.util.Log.d("leak-27-20", dataLeAk27);
		android.util.Log.d("leak-28-20", dataLeAk28);
		android.util.Log.d("leak-29-20", dataLeAk29);
		android.util.Log.d("leak-30-20", dataLeAk30);
		android.util.Log.d("leak-31-20", dataLeAk31);
		android.util.Log.d("leak-33-20", dataLeAk33);
		android.util.Log.d("leak-35-20", dataLeAk35);
		android.util.Log.d("leak-36-20", dataLeAk36);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-22-21", dataLeAk22);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-26-21", dataLeAk26);
		android.util.Log.d("leak-27-21", dataLeAk27);
		android.util.Log.d("leak-28-21", dataLeAk28);
		android.util.Log.d("leak-29-21", dataLeAk29);
		android.util.Log.d("leak-30-21", dataLeAk30);
		android.util.Log.d("leak-31-21", dataLeAk31);
		android.util.Log.d("leak-33-21", dataLeAk33);
		android.util.Log.d("leak-35-21", dataLeAk35);
		android.util.Log.d("leak-36-21", dataLeAk36);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_light) {
            toggleLight();
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleLight() {
        if(hasFlash())
            if(torchOn)
                barcodeView.setTorchOff();
            else
                barcodeView.setTorchOn();
		android.util.Log.d("leak-22-22", dataLeAk22);
		android.util.Log.d("leak-24-22", dataLeAk24);
		android.util.Log.d("leak-26-22", dataLeAk26);
		android.util.Log.d("leak-27-22", dataLeAk27);
		android.util.Log.d("leak-28-22", dataLeAk28);
		android.util.Log.d("leak-29-22", dataLeAk29);
		android.util.Log.d("leak-30-22", dataLeAk30);
		android.util.Log.d("leak-31-22", dataLeAk31);
		android.util.Log.d("leak-33-22", dataLeAk33);
		android.util.Log.d("leak-35-22", dataLeAk35);
		android.util.Log.d("leak-36-22", dataLeAk36);
    }

    @Override
    public void onResume() {
        barcodeView.resume();
		dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-22-23", dataLeAk22);
		android.util.Log.d("leak-24-23", dataLeAk24);
		android.util.Log.d("leak-26-23", dataLeAk26);
		android.util.Log.d("leak-27-23", dataLeAk27);
		android.util.Log.d("leak-28-23", dataLeAk28);
		android.util.Log.d("leak-29-23", dataLeAk29);
		android.util.Log.d("leak-30-23", dataLeAk30);
		android.util.Log.d("leak-31-23", dataLeAk31);
		android.util.Log.d("leak-33-23", dataLeAk33);
		android.util.Log.d("leak-35-23", dataLeAk35);
		android.util.Log.d("leak-36-23", dataLeAk36);
        super.onResume();
    }

    @Override
    public void onPause() {
        barcodeView.pause();
		dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-22-24", dataLeAk22);
		android.util.Log.d("leak-24-24", dataLeAk24);
		android.util.Log.d("leak-26-24", dataLeAk26);
		android.util.Log.d("leak-27-24", dataLeAk27);
		android.util.Log.d("leak-28-24", dataLeAk28);
		android.util.Log.d("leak-29-24", dataLeAk29);
		android.util.Log.d("leak-30-24", dataLeAk30);
		android.util.Log.d("leak-31-24", dataLeAk31);
		android.util.Log.d("leak-33-24", dataLeAk33);
		android.util.Log.d("leak-35-24", dataLeAk35);
		android.util.Log.d("leak-36-24", dataLeAk36);
        torchOn = false;
        super.onPause();
    }

    private BarcodeCallback callback = new BarcodeCallback() {
        String dataLeAk34 = "34";

		String dataLeAk32 = "32";

		@Override
        public void barcodeResult(BarcodeResult result) {
            dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			//Do something with code result
            if (result.getText() != null) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
                boolean shouldBeep = prefs.getBoolean("beep", false);
                beepManager.setBeepEnabled(shouldBeep);
                beepManager.setVibrateEnabled(false);
                if(shouldBeep)
                    beepManager.playBeepSoundAndVibrate();
                ((MainActivity)getActivity()).switchToFragment(FragmentGenerator.getFragment(result),false);
            }
        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
			dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        }
    };

    private boolean hasFlash(){
        android.util.Log.d("leak-22-25", dataLeAk22);
		android.util.Log.d("leak-24-25", dataLeAk24);
		android.util.Log.d("leak-26-25", dataLeAk26);
		android.util.Log.d("leak-27-25", dataLeAk27);
		android.util.Log.d("leak-28-25", dataLeAk28);
		android.util.Log.d("leak-29-25", dataLeAk29);
		android.util.Log.d("leak-30-25", dataLeAk30);
		android.util.Log.d("leak-31-25", dataLeAk31);
		android.util.Log.d("leak-33-25", dataLeAk33);
		android.util.Log.d("leak-35-25", dataLeAk35);
		android.util.Log.d("leak-36-25", dataLeAk36);
		return getActivity().getApplication().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		android.util.Log.d("leak-22-26", dataLeAk22);
		android.util.Log.d("leak-24-26", dataLeAk24);
		android.util.Log.d("leak-26-26", dataLeAk26);
		android.util.Log.d("leak-27-26", dataLeAk27);
		android.util.Log.d("leak-28-26", dataLeAk28);
		android.util.Log.d("leak-29-26", dataLeAk29);
		android.util.Log.d("leak-30-26", dataLeAk30);
		android.util.Log.d("leak-31-26", dataLeAk31);
		android.util.Log.d("leak-33-26", dataLeAk33);
		android.util.Log.d("leak-35-26", dataLeAk35);
		android.util.Log.d("leak-36-26", dataLeAk36);
		dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        this.activity = activity;
    }
}
