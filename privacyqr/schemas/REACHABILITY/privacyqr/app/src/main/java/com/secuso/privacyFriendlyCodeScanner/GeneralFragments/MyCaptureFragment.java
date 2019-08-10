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

    String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);

	private CompoundBarcodeView barcodeView;
    private BeepManager beepManager;
    private boolean torchOn = false;
    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
		if (container == null) {
            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
			return null;
        }

        View v;
        v = inflater.inflate(R.layout.fragment_capture, container, false);

        if (SDK_INT >= Build.VERSION_CODES.M)
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
				ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 0);
            }

        barcodeView = (CompoundBarcodeView) v.findViewById(R.id.barcode_scanner);

        barcodeView.setTorchListener(new CompoundBarcodeView.TorchListener() {
            String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);

			@Override
            public void onTorchOn() {
                String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);
				torchOn = true;
            }

            @Override
            public void onTorchOff() {
                String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
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
		String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.my_capture, menu);
		String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_light) {
            String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
			toggleLight();
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleLight() {
        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
		if(hasFlash())
            if(torchOn)
                barcodeView.setTorchOff();
            else
                barcodeView.setTorchOn();
    }

    @Override
    public void onResume() {
        barcodeView.resume();
		String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
        super.onResume();
    }

    @Override
    public void onPause() {
        barcodeView.pause();
		String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
        torchOn = false;
        super.onPause();
    }

    private BarcodeCallback callback = new BarcodeCallback() {
        String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);

		@Override
        public void barcodeResult(BarcodeResult result) {
            String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
			//Do something with code result
            if (result.getText() != null) {
                String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
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
			String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
        }
    };

    private boolean hasFlash(){
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
		return getActivity().getApplication().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
        this.activity = activity;
    }
}
