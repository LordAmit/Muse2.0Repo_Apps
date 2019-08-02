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

    String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);

	public CreateClassDialog() {
		String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
        String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
		View v = inflater.inflate(R.layout.create_class_dialog,
                                container, false);
        getDialog().setTitle(R.string.new_event_class);
        final Button create_button =
            (Button)v.findViewById(R.id.create_button);
        final EditText new_class_name =
            (EditText)v.findViewById(R.id.new_class_name);
        create_button.setEnabled(false); // initially we have no text
        create_button.setOnClickListener(new View.OnClickListener() {
            String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);

			public void onClick(View v) {
                String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
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
            String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);

			@Override
            public void onTextChanged(CharSequence s, int start,
                int before, int count) {
					String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
                // do nothing
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                int count, int after) {
					String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
                // do nothing
            }

            public void afterTextChanged(Editable e) {
                String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);
				String s = e.toString();
                if (    s.isEmpty()
                    || (PrefsManager.getClassNum(getActivity(), s) >= 0))
                {
                    String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
					// no text or class already exists
                    create_button.setEnabled(false);
                }
                else
                {
                    String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
					create_button.setEnabled(true);
                }
            }
        });
        // Watch for button clicks.
        ((Button)v.findViewById(R.id.cancel_button))
            .setOnClickListener(new View.OnClickListener() {
                String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);

				public void onClick(View v) {
                    String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
					dismiss();
                }
            });
        return v;
    }

}
