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

    private CompoundBarcodeView barcodeView;
    private BeepManager beepManager;
    private boolean torchOn = false;
    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP37 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP37.put("test", new java.util.HashMap<String, String>());
		leakMaP37.get("test").put("test", dataLeAk37);
		String dataLeAkPath37 = leakMaP37.get("test").get("test");
		android.util.Log.d("leak-37", dataLeAkPath37);
		if (container == null) {
            String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer38 = new StringBuffer();for (char chAr38 : dataLeAk38.toCharArray()) {leakBuFFer38.append(chAr38);}String dataLeAkPath38 = leakBuFFer38.toString();
			android.util.Log.d("leak-38", dataLeAkPath38);
			return null;
        }

        View v;
        v = inflater.inflate(R.layout.fragment_capture, container, false);

        if (SDK_INT >= Build.VERSION_CODES.M)
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                String dataLeAk39 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath39;try {throw new Exception(dataLeAk39);} catch (Exception leakErRor39) {dataLeAkPath39 = leakErRor39.getMessage();}
				android.util.Log.d("leak-39", dataLeAkPath39);
				ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 0);
            }

        barcodeView = (CompoundBarcodeView) v.findViewById(R.id.barcode_scanner);

        barcodeView.setTorchListener(new CompoundBarcodeView.TorchListener() {
            @Override
            public void onTorchOn() {
                String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
				String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
				android.util.Log.d("leak-40", dataLeAkPath40);
				torchOn = true;
            }

            @Override
            public void onTorchOff() {
                String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP41.put("test", new java.util.HashMap<String, String>());
				leakMaP41.get("test").put("test", dataLeAk41);
				String dataLeAkPath41 = leakMaP41.get("test").get("test");
				android.util.Log.d("leak-41", dataLeAkPath41);
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
		String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
		android.util.Log.d("leak-42", dataLeAkPath42);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.my_capture, menu);
		String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
		android.util.Log.d("leak-43", dataLeAkPath43);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
		String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
		android.util.Log.d("leak-44", dataLeAkPath44);
		// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_light) {
            String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP45.put("test", new java.util.HashMap<String, String>());
			leakMaP45.get("test").put("test", dataLeAk45);
			String dataLeAkPath45 = leakMaP45.get("test").get("test");
			android.util.Log.d("leak-45", dataLeAkPath45);
			toggleLight();
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleLight() {
        String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
		android.util.Log.d("leak-46", dataLeAkPath46);
		if(hasFlash())
            if(torchOn)
                barcodeView.setTorchOff();
            else
                barcodeView.setTorchOn();
    }

    @Override
    public void onResume() {
        barcodeView.resume();
		String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
		android.util.Log.d("leak-47", dataLeAkPath47);
        super.onResume();
    }

    @Override
    public void onPause() {
        barcodeView.pause();
		String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
		String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
		android.util.Log.d("leak-48", dataLeAkPath48);
        torchOn = false;
        super.onPause();
    }

    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP49.put("test", new java.util.HashMap<String, String>());
			leakMaP49.get("test").put("test", dataLeAk49);
			String dataLeAkPath49 = leakMaP49.get("test").get("test");
			android.util.Log.d("leak-49", dataLeAkPath49);
			//Do something with code result
            if (result.getText() != null) {
                String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
				android.util.Log.d("leak-50", dataLeAkPath50);
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
			String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
			android.util.Log.d("leak-51", dataLeAkPath51);
        }
    };

    private boolean hasFlash(){
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
		String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
		android.util.Log.d("leak-52", dataLeAkPath52);
		return getActivity().getApplication().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP53.put("test", new java.util.HashMap<String, String>());
		leakMaP53.get("test").put("test", dataLeAk53);
		String dataLeAkPath53 = leakMaP53.get("test").get("test");
		android.util.Log.d("leak-53", dataLeAkPath53);
        this.activity = activity;
    }
}
