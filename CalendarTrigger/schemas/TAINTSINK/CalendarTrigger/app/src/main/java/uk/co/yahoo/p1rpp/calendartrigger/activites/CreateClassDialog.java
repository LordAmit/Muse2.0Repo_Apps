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

    String dataLeAk32 = "32";

	String dataLeAk30 = "30";

	String dataLeAk28 = "28";

	String dataLeAk26 = "26";

	String dataLeAk24 = "24";

	String dataLeAk22 = "22";

	String dataLeAk21 = "21";

	public CreateClassDialog() {
		dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        // Required empty public constructor
		android.util.Log.d("leak-21-23", dataLeAk21);
		android.util.Log.d("leak-22-23", dataLeAk22);
		android.util.Log.d("leak-24-23", dataLeAk24);
		android.util.Log.d("leak-26-23", dataLeAk26);
		android.util.Log.d("leak-28-23", dataLeAk28);
		android.util.Log.d("leak-30-23", dataLeAk30);
		android.util.Log.d("leak-32-23", dataLeAk32);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
        dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-21-24", dataLeAk21);
		android.util.Log.d("leak-22-24", dataLeAk22);
		android.util.Log.d("leak-24-24", dataLeAk24);
		android.util.Log.d("leak-26-24", dataLeAk26);
		android.util.Log.d("leak-28-24", dataLeAk28);
		android.util.Log.d("leak-30-24", dataLeAk30);
		android.util.Log.d("leak-32-24", dataLeAk32);
		View v = inflater.inflate(R.layout.create_class_dialog,
                                container, false);
        getDialog().setTitle(R.string.new_event_class);
        final Button create_button =
            (Button)v.findViewById(R.id.create_button);
        final EditText new_class_name =
            (EditText)v.findViewById(R.id.new_class_name);
        create_button.setEnabled(false); // initially we have no text
        create_button.setOnClickListener(new View.OnClickListener() {
            String dataLeAk23 = "23";

			public void onClick(View v) {
                dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk29 = "29";

			String dataLeAk27 = "27";

			String dataLeAk25 = "25";

			@Override
            public void onTextChanged(CharSequence s, int start,
                int before, int count) {
					dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                // do nothing
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                int count, int after) {
					dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                // do nothing
            }

            public void afterTextChanged(Editable e) {
                dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk31 = "31";

				public void onClick(View v) {
                    dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dismiss();
                }
            });
        return v;
    }

}
