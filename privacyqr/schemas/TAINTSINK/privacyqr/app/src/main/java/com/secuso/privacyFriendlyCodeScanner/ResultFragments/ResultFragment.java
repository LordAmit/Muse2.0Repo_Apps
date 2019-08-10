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
    String dataLeAk143 = "143";

	String dataLeAk142 = "142";

	String dataLeAk141 = "141";

	String dataLeAk139 = "139";

	String dataLeAk138 = "138";

	String dataLeAk137 = "137";

	protected String result;
    protected Bitmap bitmap;
    protected String toast = "erfolgreich";
    protected boolean fromHistory = false;

    public ResultFragment (){
		dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-137-74", dataLeAk137);
		android.util.Log.d("leak-138-74", dataLeAk138);
		android.util.Log.d("leak-139-74", dataLeAk139);
		android.util.Log.d("leak-141-74", dataLeAk141);
		android.util.Log.d("leak-142-74", dataLeAk142);
		android.util.Log.d("leak-143-74", dataLeAk143);}

    /*
        To be implemented
     */
    protected void createBitmap(){
		dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-137-75", dataLeAk137);
		android.util.Log.d("leak-138-75", dataLeAk138);
		android.util.Log.d("leak-139-75", dataLeAk139);
		android.util.Log.d("leak-141-75", dataLeAk141);
		android.util.Log.d("leak-142-75", dataLeAk142);
		android.util.Log.d("leak-143-75", dataLeAk143);}

    protected View setResult(View view) {
        dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-137-76", dataLeAk137);
		android.util.Log.d("leak-138-76", dataLeAk138);
		android.util.Log.d("leak-139-76", dataLeAk139);
		android.util.Log.d("leak-141-76", dataLeAk141);
		android.util.Log.d("leak-142-76", dataLeAk142);
		android.util.Log.d("leak-143-76", dataLeAk143);
		result  = getArguments().getString("result_content");
        fromHistory = getArguments().getBoolean("history", false);
        if(fromHistory) {
            ((Button) view.findViewById(R.id.btnProceed)).setText(R.string.proceed);
            ((Button) view.findViewById(R.id.btnCancel)).setText(R.string.back);
        }

        Button abortActionButton = (Button) view.findViewById(R.id.btnCancel);
        abortActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk140 = "140";

			@Override
            public void onClick(View v) {
               dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			if(fromHistory)
                    ((MainActivity)getActivity()).selectItem(1,false);
                else
                    ((MainActivity)getActivity()).selectItem(0,false);
            }
        });

        return view;
    }

    protected void saveScanned(boolean trust) {
        dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-137-77", dataLeAk137);
		android.util.Log.d("leak-138-77", dataLeAk138);
		android.util.Log.d("leak-139-77", dataLeAk139);
		android.util.Log.d("leak-141-77", dataLeAk141);
		android.util.Log.d("leak-142-77", dataLeAk142);
		android.util.Log.d("leak-143-77", dataLeAk143);
		if(!fromHistory)
            History.saveScan(result, trust, getActivity());
    }

    protected void displayToast() {
        dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-137-78", dataLeAk137);
		android.util.Log.d("leak-138-78", dataLeAk138);
		android.util.Log.d("leak-139-78", dataLeAk139);
		android.util.Log.d("leak-141-78", dataLeAk141);
		android.util.Log.d("leak-142-78", dataLeAk142);
		android.util.Log.d("leak-143-78", dataLeAk143);
		if(getActivity() != null && toast != null) {
            Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
        }
    }
}
