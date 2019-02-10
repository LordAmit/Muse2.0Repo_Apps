/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;
import uk.co.yahoo.p1rpp.calendartrigger.R;

/**
 * Dialog to get a name for a new event class
 */
public class CreateClassDialog extends DialogFragment {

    public CreateClassDialog() {
		String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP53.put("test", new java.util.HashMap<String, String>());
		leakMaP53.get("test").put("test", dataLeAk53);
		String dataLeAkPath53 = leakMaP53.get("test").get("test");
		android.util.Log.d("leak-53", dataLeAkPath53);
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
        String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
			android.util.Log.d("leak-54", dataLeAkPath54);
		View v = inflater.inflate(R.layout.create_class_dialog,
                                container, false);
        getDialog().setTitle(R.string.new_event_class);
        final Button create_button =
            (Button)v.findViewById(R.id.create_button);
        final EditText new_class_name =
            (EditText)v.findViewById(R.id.new_class_name);
        create_button.setEnabled(false); // initially we have no text
        create_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
				android.util.Log.d("leak-55", dataLeAkPath55);
				String s = new_class_name.getText().toString();
                Activity a = getActivity();
                int n = PrefsManager.getNewClass(a);
                PrefsManager.setClassName(a, n, s);
                Intent i = new Intent(a, EditActivity.class);
                i.putExtra("classname", s);
                startActivity(i);
                dismiss();
            }
        });
        new_class_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start,
                int before, int count) {
					String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
					String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
					android.util.Log.d("leak-56", dataLeAkPath56);
                // do nothing
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                int count, int after) {
					String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP57.put("test", new java.util.HashMap<String, String>());
					leakMaP57.get("test").put("test", dataLeAk57);
					String dataLeAkPath57 = leakMaP57.get("test").get("test");
					android.util.Log.d("leak-57", dataLeAkPath57);
                // do nothing
            }

            public void afterTextChanged(Editable e) {
                String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
				android.util.Log.d("leak-58", dataLeAkPath58);
				String s = e.toString();
                if (    s.isEmpty()
                    || (PrefsManager.getClassNum(getActivity(), s) >= 0))
                {
                    String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
					android.util.Log.d("leak-59", dataLeAkPath59);
					// no text or class already exists
                    create_button.setEnabled(false);
                }
                else
                {
                    String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
					String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
					android.util.Log.d("leak-60", dataLeAkPath60);
					create_button.setEnabled(true);
                }
            }
        });
        // Watch for button clicks.
        ((Button)v.findViewById(R.id.cancel_button))
            .setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP61.put("test", new java.util.HashMap<String, String>());
					leakMaP61.get("test").put("test", dataLeAk61);
					String dataLeAkPath61 = leakMaP61.get("test").get("test");
					android.util.Log.d("leak-61", dataLeAkPath61);
					dismiss();
                }
            });
        return v;
    }

}
