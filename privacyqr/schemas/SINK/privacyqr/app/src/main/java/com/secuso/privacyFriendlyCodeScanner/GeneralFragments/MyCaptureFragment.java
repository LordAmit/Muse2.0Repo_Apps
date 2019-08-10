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

    final String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk42 = "";

	String dataLeAk41 = "";

	String dataLeAk38 = "";

	String dataLeAk37 = "";

	String dataLeAk36 = "";

	String dataLeAk35 = "";

	String dataLeAk34 = "";

	String dataLeAk33 = "";

	String dataLeAk30 = "";

	private CompoundBarcodeView barcodeView;
    private BeepManager beepManager;
    private boolean torchOn = false;
    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-30-0", dataLeAk30);
		android.util.Log.d("leak-33-0", dataLeAk33);
		android.util.Log.d("leak-34-0", dataLeAk34);
		android.util.Log.d("leak-35-0", dataLeAk35);
		android.util.Log.d("leak-36-0", dataLeAk36);
		android.util.Log.d("leak-37-0", dataLeAk37);
		android.util.Log.d("leak-38-0", dataLeAk38);
		android.util.Log.d("leak-41-0", dataLeAk41);
		android.util.Log.d("leak-42-0", dataLeAk42);
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
            String dataLeAk32 = "";

			String dataLeAk31 = "";

			@Override
            public void onTorchOn() {
                dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-44-0", dataLeAk44);
				android.util.Log.d("leak-31-0", dataLeAk31);
				android.util.Log.d("leak-32-0", dataLeAk32);
				torchOn = true;
            }

            @Override
            public void onTorchOff() {
                dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-45-0", dataLeAk45);
				android.util.Log.d("leak-31-1", dataLeAk31);
				android.util.Log.d("leak-32-1", dataLeAk32);
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
		dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-30-1", dataLeAk30);
		android.util.Log.d("leak-33-1", dataLeAk33);
		android.util.Log.d("leak-34-1", dataLeAk34);
		android.util.Log.d("leak-35-1", dataLeAk35);
		android.util.Log.d("leak-36-1", dataLeAk36);
		android.util.Log.d("leak-37-1", dataLeAk37);
		android.util.Log.d("leak-38-1", dataLeAk38);
		android.util.Log.d("leak-41-1", dataLeAk41);
		android.util.Log.d("leak-42-1", dataLeAk42);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.my_capture, menu);
		dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-30-2", dataLeAk30);
		android.util.Log.d("leak-33-2", dataLeAk33);
		android.util.Log.d("leak-34-2", dataLeAk34);
		android.util.Log.d("leak-35-2", dataLeAk35);
		android.util.Log.d("leak-36-2", dataLeAk36);
		android.util.Log.d("leak-37-2", dataLeAk37);
		android.util.Log.d("leak-38-2", dataLeAk38);
		android.util.Log.d("leak-41-2", dataLeAk41);
		android.util.Log.d("leak-42-2", dataLeAk42);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-30-3", dataLeAk30);
		android.util.Log.d("leak-33-3", dataLeAk33);
		android.util.Log.d("leak-34-3", dataLeAk34);
		android.util.Log.d("leak-35-3", dataLeAk35);
		android.util.Log.d("leak-36-3", dataLeAk36);
		android.util.Log.d("leak-37-3", dataLeAk37);
		android.util.Log.d("leak-38-3", dataLeAk38);
		android.util.Log.d("leak-41-3", dataLeAk41);
		android.util.Log.d("leak-42-3", dataLeAk42);
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
        dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-30-4", dataLeAk30);
		android.util.Log.d("leak-33-4", dataLeAk33);
		android.util.Log.d("leak-34-4", dataLeAk34);
		android.util.Log.d("leak-35-4", dataLeAk35);
		android.util.Log.d("leak-36-4", dataLeAk36);
		android.util.Log.d("leak-37-4", dataLeAk37);
		android.util.Log.d("leak-38-4", dataLeAk38);
		android.util.Log.d("leak-41-4", dataLeAk41);
		android.util.Log.d("leak-42-4", dataLeAk42);
		if(hasFlash())
            if(torchOn)
                barcodeView.setTorchOff();
            else
                barcodeView.setTorchOn();
    }

    @Override
    public void onResume() {
        barcodeView.resume();
		dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-30-5", dataLeAk30);
		android.util.Log.d("leak-33-5", dataLeAk33);
		android.util.Log.d("leak-34-5", dataLeAk34);
		android.util.Log.d("leak-35-5", dataLeAk35);
		android.util.Log.d("leak-36-5", dataLeAk36);
		android.util.Log.d("leak-37-5", dataLeAk37);
		android.util.Log.d("leak-38-5", dataLeAk38);
		android.util.Log.d("leak-41-5", dataLeAk41);
		android.util.Log.d("leak-42-5", dataLeAk42);
        super.onResume();
    }

    @Override
    public void onPause() {
        barcodeView.pause();
		dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-30-6", dataLeAk30);
		android.util.Log.d("leak-33-6", dataLeAk33);
		android.util.Log.d("leak-34-6", dataLeAk34);
		android.util.Log.d("leak-35-6", dataLeAk35);
		android.util.Log.d("leak-36-6", dataLeAk36);
		android.util.Log.d("leak-37-6", dataLeAk37);
		android.util.Log.d("leak-38-6", dataLeAk38);
		android.util.Log.d("leak-41-6", dataLeAk41);
		android.util.Log.d("leak-42-6", dataLeAk42);
        torchOn = false;
        super.onPause();
    }

    private BarcodeCallback callback = new BarcodeCallback() {
        String dataLeAk40 = "";

		String dataLeAk39 = "";

		@Override
        public void barcodeResult(BarcodeResult result) {
            dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-46-0", dataLeAk46);
			android.util.Log.d("leak-39-0", dataLeAk39);
			android.util.Log.d("leak-40-0", dataLeAk40);
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
			dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-47-0", dataLeAk47);
			android.util.Log.d("leak-39-1", dataLeAk39);
			android.util.Log.d("leak-40-1", dataLeAk40);
        }
    };

    private boolean hasFlash(){
        dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-30-7", dataLeAk30);
		android.util.Log.d("leak-33-7", dataLeAk33);
		android.util.Log.d("leak-34-7", dataLeAk34);
		android.util.Log.d("leak-35-7", dataLeAk35);
		android.util.Log.d("leak-36-7", dataLeAk36);
		android.util.Log.d("leak-37-7", dataLeAk37);
		android.util.Log.d("leak-38-7", dataLeAk38);
		android.util.Log.d("leak-41-7", dataLeAk41);
		android.util.Log.d("leak-42-7", dataLeAk42);
		return getActivity().getApplication().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-30-8", dataLeAk30);
		android.util.Log.d("leak-33-8", dataLeAk33);
		android.util.Log.d("leak-34-8", dataLeAk34);
		android.util.Log.d("leak-35-8", dataLeAk35);
		android.util.Log.d("leak-36-8", dataLeAk36);
		android.util.Log.d("leak-37-8", dataLeAk37);
		android.util.Log.d("leak-38-8", dataLeAk38);
		android.util.Log.d("leak-41-8", dataLeAk41);
		android.util.Log.d("leak-42-8", dataLeAk42);
        this.activity = activity;
    }
}
