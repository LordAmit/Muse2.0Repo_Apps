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

    final String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk24 = "";

	String dataLeAk23 = "";

	public CreateClassDialog() {
		dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Required empty public constructor
		android.util.Log.d("leak-23-0", dataLeAk23);
		android.util.Log.d("leak-24-0", dataLeAk24);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-1", dataLeAk23);
		android.util.Log.d("leak-24-1", dataLeAk24);
		View v = inflater.inflate(R.layout.create_class_dialog,
                                container, false);
        getDialog().setTitle(R.string.new_event_class);
        final Button create_button =
            (Button)v.findViewById(R.id.create_button);
        final EditText new_class_name =
            (EditText)v.findViewById(R.id.new_class_name);
        create_button.setEnabled(false); // initially we have no text
        create_button.setOnClickListener(new View.OnClickListener() {
            String dataLeAk25 = "";

			public void onClick(View v) {
                dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-31-0", dataLeAk31);
				android.util.Log.d("leak-25-0", dataLeAk25);
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
            String dataLeAk28 = "";

			String dataLeAk27 = "";

			String dataLeAk26 = "";

			@Override
            public void onTextChanged(CharSequence s, int start,
                int before, int count) {
					dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                // do nothing
					android.util.Log.d("leak-32-0", dataLeAk32);
					android.util.Log.d("leak-26-0", dataLeAk26);
					android.util.Log.d("leak-27-0", dataLeAk27);
					android.util.Log.d("leak-28-0", dataLeAk28);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                int count, int after) {
					dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                // do nothing
					android.util.Log.d("leak-33-0", dataLeAk33);
					android.util.Log.d("leak-26-1", dataLeAk26);
					android.util.Log.d("leak-27-1", dataLeAk27);
					android.util.Log.d("leak-28-1", dataLeAk28);
            }

            public void afterTextChanged(Editable e) {
                dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-34-0", dataLeAk34);
				android.util.Log.d("leak-26-2", dataLeAk26);
				android.util.Log.d("leak-27-2", dataLeAk27);
				android.util.Log.d("leak-28-2", dataLeAk28);
				String s = e.toString();
                if (    s.isEmpty()
                    || (PrefsManager.getClassNum(getActivity(), s) >= 0))
                {
                    // no text or class already exists
                    create_button.setEnabled(false);
                }
                else
                {
                    create_button.setEnabled(true);
                }
            }
        });
        // Watch for button clicks.
        ((Button)v.findViewById(R.id.cancel_button))
            .setOnClickListener(new View.OnClickListener() {
                String dataLeAk29 = "";

				public void onClick(View v) {
                    dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-35-0", dataLeAk35);
					android.util.Log.d("leak-29-0", dataLeAk29);
					dismiss();
                }
            });
        return v;
    }

}
