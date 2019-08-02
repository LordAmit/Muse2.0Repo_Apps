/*
 * Copyright (c) 2017. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * Created by rparkins on 22/03/17.
 * This behaves like a disabled RadioButton, but allows long clicks which I
 * use to pop up an explanation of why it is disabled
 */

public class DisabledRadioButton extends RadioButton {

    String dataLeAk58 = "";

	String dataLeAk57 = "";

	String dataLeAk56 = "";

	String dataLeAk55 = "";

	String dataLeAk54 = "";

	public DisabledRadioButton(Context context) {
        super(context);
		dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-54-0", dataLeAk54);
		android.util.Log.d("leak-55-0", dataLeAk55);
		android.util.Log.d("leak-56-0", dataLeAk56);
		android.util.Log.d("leak-57-0", dataLeAk57);
		android.util.Log.d("leak-58-0", dataLeAk58);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-54-1", dataLeAk54);
		android.util.Log.d("leak-55-1", dataLeAk55);
		android.util.Log.d("leak-56-1", dataLeAk56);
		android.util.Log.d("leak-57-1", dataLeAk57);
		android.util.Log.d("leak-58-1", dataLeAk58);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-54-2", dataLeAk54);
		android.util.Log.d("leak-55-2", dataLeAk55);
		android.util.Log.d("leak-56-2", dataLeAk56);
		android.util.Log.d("leak-57-2", dataLeAk57);
		android.util.Log.d("leak-58-2", dataLeAk58);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-54-3", dataLeAk54);
		android.util.Log.d("leak-55-3", dataLeAk55);
		android.util.Log.d("leak-56-3", dataLeAk56);
		android.util.Log.d("leak-57-3", dataLeAk57);
		android.util.Log.d("leak-58-3", dataLeAk58);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    @Override
    public boolean performClick() {
        dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-54-4", dataLeAk54);
		android.util.Log.d("leak-55-4", dataLeAk55);
		android.util.Log.d("leak-56-4", dataLeAk56);
		android.util.Log.d("leak-57-4", dataLeAk57);
		android.util.Log.d("leak-58-4", dataLeAk58);
		// override the click to do nothing
        return true;
    }
}
