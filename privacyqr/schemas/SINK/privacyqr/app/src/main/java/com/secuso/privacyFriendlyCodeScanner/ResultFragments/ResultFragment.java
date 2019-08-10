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
    final String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk155 = "";

	String dataLeAk154 = "";

	String dataLeAk152 = "";

	String dataLeAk151 = "";

	String dataLeAk150 = "";

	protected String result;
    protected Bitmap bitmap;
    protected String toast = "erfolgreich";
    protected boolean fromHistory = false;

    public ResultFragment (){
		dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-150-0", dataLeAk150);
		android.util.Log.d("leak-151-0", dataLeAk151);
		android.util.Log.d("leak-152-0", dataLeAk152);
		android.util.Log.d("leak-154-0", dataLeAk154);
		android.util.Log.d("leak-155-0", dataLeAk155);}

    /*
        To be implemented
     */
    protected void createBitmap(){
		dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-150-1", dataLeAk150);
		android.util.Log.d("leak-151-1", dataLeAk151);
		android.util.Log.d("leak-152-1", dataLeAk152);
		android.util.Log.d("leak-154-1", dataLeAk154);
		android.util.Log.d("leak-155-1", dataLeAk155);}

    protected View setResult(View view) {
        dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-150-2", dataLeAk150);
		android.util.Log.d("leak-151-2", dataLeAk151);
		android.util.Log.d("leak-152-2", dataLeAk152);
		android.util.Log.d("leak-154-2", dataLeAk154);
		android.util.Log.d("leak-155-2", dataLeAk155);
		result  = getArguments().getString("result_content");
        fromHistory = getArguments().getBoolean("history", false);
        if(fromHistory) {
            ((Button) view.findViewById(R.id.btnProceed)).setText(R.string.proceed);
            ((Button) view.findViewById(R.id.btnCancel)).setText(R.string.back);
        }

        Button abortActionButton = (Button) view.findViewById(R.id.btnCancel);
        abortActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk153 = "";

			@Override
            public void onClick(View v) {
               dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-157-0", dataLeAk157);
			android.util.Log.d("leak-153-0", dataLeAk153);
			if(fromHistory)
                    ((MainActivity)getActivity()).selectItem(1,false);
                else
                    ((MainActivity)getActivity()).selectItem(0,false);
            }
        });

        return view;
    }

    protected void saveScanned(boolean trust) {
        dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-150-3", dataLeAk150);
		android.util.Log.d("leak-151-3", dataLeAk151);
		android.util.Log.d("leak-152-3", dataLeAk152);
		android.util.Log.d("leak-154-3", dataLeAk154);
		android.util.Log.d("leak-155-3", dataLeAk155);
		if(!fromHistory)
            History.saveScan(result, trust, getActivity());
    }

    protected void displayToast() {
        dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-150-4", dataLeAk150);
		android.util.Log.d("leak-151-4", dataLeAk151);
		android.util.Log.d("leak-152-4", dataLeAk152);
		android.util.Log.d("leak-154-4", dataLeAk154);
		android.util.Log.d("leak-155-4", dataLeAk155);
		if(getActivity() != null && toast != null) {
            Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
        }
    }
}
