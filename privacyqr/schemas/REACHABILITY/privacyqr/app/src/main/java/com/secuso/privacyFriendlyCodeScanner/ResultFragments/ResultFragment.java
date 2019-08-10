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
    String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk231 = android.util.Log.d("leak-231", dataLeAk231);

	protected String result;
    protected Bitmap bitmap;
    protected String toast = "erfolgreich";
    protected boolean fromHistory = false;

    public ResultFragment (){
		String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk232 = android.util.Log.d("leak-232", dataLeAk232);}

    /*
        To be implemented
     */
    protected void createBitmap(){
		String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk233 = android.util.Log.d("leak-233", dataLeAk233);}

    protected View setResult(View view) {
        String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk234 = android.util.Log.d("leak-234", dataLeAk234);
		result  = getArguments().getString("result_content");
        fromHistory = getArguments().getBoolean("history", false);
        if(fromHistory) {
            String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk235 = android.util.Log.d("leak-235", dataLeAk235);
			((Button) view.findViewById(R.id.btnProceed)).setText(R.string.proceed);
            ((Button) view.findViewById(R.id.btnCancel)).setText(R.string.back);
        }

        Button abortActionButton = (Button) view.findViewById(R.id.btnCancel);
        abortActionButton.setOnClickListener(new View.OnClickListener() {

            String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk236 = android.util.Log.d("leak-236", dataLeAk236);

			@Override
            public void onClick(View v) {
               String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk237 = android.util.Log.d("leak-237", dataLeAk237);
			if(fromHistory)
                    ((MainActivity)getActivity()).selectItem(1,false);
                else
                    ((MainActivity)getActivity()).selectItem(0,false);
            }
        });

        return view;
    }

    protected void saveScanned(boolean trust) {
        String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk238 = android.util.Log.d("leak-238", dataLeAk238);
		if(!fromHistory)
            History.saveScan(result, trust, getActivity());
    }

    protected void displayToast() {
        String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk239 = android.util.Log.d("leak-239", dataLeAk239);
		if(getActivity() != null && toast != null) {
            String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk240 = android.util.Log.d("leak-240", dataLeAk240);
			Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
        }
    }
}
