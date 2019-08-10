package com.secuso.privacyFriendlyCodeScanner.ResultFragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.secuso.privacyFriendlyCodeScanner.MainActivity;
import com.secuso.privacyFriendlyCodeScanner.R;
import com.secuso.privacyFriendlyCodeScanner.Utility.History;

public abstract class ResultFragment extends Fragment {
    protected String result;
    protected Bitmap bitmap;
    protected String toast = "erfolgreich";
    protected boolean fromHistory = false;

    public ResultFragment (){
		String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath179;try {throw new Exception(dataLeAk179);} catch (Exception leakErRor179) {dataLeAkPath179 = leakErRor179.getMessage();}
		android.util.Log.d("leak-179", dataLeAkPath179);}

    /*
        To be implemented
     */
    protected void createBitmap(){
		String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay180 = new String[] {"n/a", dataLeAk180};
		String dataLeAkPath180 = leakArRay180[leakArRay180.length - 1];
		android.util.Log.d("leak-180", dataLeAkPath180);}

    protected View setResult(View view) {
        String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP181.put("test", new java.util.HashMap<String, String>());
		leakMaP181.get("test").put("test", dataLeAk181);
		String dataLeAkPath181 = leakMaP181.get("test").get("test");
		android.util.Log.d("leak-181", dataLeAkPath181);
		result  = getArguments().getString("result_content");
        fromHistory = getArguments().getBoolean("history", false);
        if(fromHistory) {
            String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer182 = new StringBuffer();for (char chAr182 : dataLeAk182.toCharArray()) {leakBuFFer182.append(chAr182);}String dataLeAkPath182 = leakBuFFer182.toString();
			android.util.Log.d("leak-182", dataLeAkPath182);
			((Button) view.findViewById(R.id.btnProceed)).setText(R.string.proceed);
            ((Button) view.findViewById(R.id.btnCancel)).setText(R.string.back);
        }

        Button abortActionButton = (Button) view.findViewById(R.id.btnCancel);
        abortActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath183;try {throw new Exception(dataLeAk183);} catch (Exception leakErRor183) {dataLeAkPath183 = leakErRor183.getMessage();}
				android.util.Log.d("leak-183", dataLeAkPath183);
			if(fromHistory)
                    ((MainActivity)getActivity()).selectItem(1,false);
                else
                    ((MainActivity)getActivity()).selectItem(0,false);
            }
        });

        return view;
    }

    protected void saveScanned(boolean trust) {
        String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay184 = new String[] {"n/a", dataLeAk184};
		String dataLeAkPath184 = leakArRay184[leakArRay184.length - 1];
		android.util.Log.d("leak-184", dataLeAkPath184);
		if(!fromHistory)
            History.saveScan(result, trust, getActivity());
    }

    protected void displayToast() {
        String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP185.put("test", new java.util.HashMap<String, String>());
		leakMaP185.get("test").put("test", dataLeAk185);
		String dataLeAkPath185 = leakMaP185.get("test").get("test");
		android.util.Log.d("leak-185", dataLeAkPath185);
		if(getActivity() != null && toast != null) {
            String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer186 = new StringBuffer();for (char chAr186 : dataLeAk186.toCharArray()) {leakBuFFer186.append(chAr186);}String dataLeAkPath186 = leakBuFFer186.toString();
			android.util.Log.d("leak-186", dataLeAkPath186);
			Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
        }
    }
}
