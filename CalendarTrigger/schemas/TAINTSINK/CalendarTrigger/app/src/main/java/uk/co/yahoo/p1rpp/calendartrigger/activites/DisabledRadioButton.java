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

    String dataLeAk56 = "56";

	String dataLeAk55 = "55";

	String dataLeAk54 = "54";

	String dataLeAk53 = "53";

	String dataLeAk52 = "52";

	public DisabledRadioButton(Context context) {
        super(context);
		android.util.Log.d("leak-52-30", dataLeAk52);
		android.util.Log.d("leak-53-30", dataLeAk53);
		android.util.Log.d("leak-54-30", dataLeAk54);
		android.util.Log.d("leak-55-30", dataLeAk55);
		android.util.Log.d("leak-56-30", dataLeAk56);
		dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
		android.util.Log.d("leak-52-31", dataLeAk52);
		android.util.Log.d("leak-53-31", dataLeAk53);
		android.util.Log.d("leak-54-31", dataLeAk54);
		android.util.Log.d("leak-55-31", dataLeAk55);
		android.util.Log.d("leak-56-31", dataLeAk56);
		dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		android.util.Log.d("leak-52-32", dataLeAk52);
		android.util.Log.d("leak-53-32", dataLeAk53);
		android.util.Log.d("leak-54-32", dataLeAk54);
		android.util.Log.d("leak-55-32", dataLeAk55);
		android.util.Log.d("leak-56-32", dataLeAk56);
		dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		android.util.Log.d("leak-52-33", dataLeAk52);
		android.util.Log.d("leak-53-33", dataLeAk53);
		android.util.Log.d("leak-54-33", dataLeAk54);
		android.util.Log.d("leak-55-33", dataLeAk55);
		android.util.Log.d("leak-56-33", dataLeAk56);
		dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    @Override
    public boolean performClick() {
        dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-34", dataLeAk52);
		android.util.Log.d("leak-53-34", dataLeAk53);
		android.util.Log.d("leak-54-34", dataLeAk54);
		android.util.Log.d("leak-55-34", dataLeAk55);
		android.util.Log.d("leak-56-34", dataLeAk56);
		// override the click to do nothing
        return true;
    }
}
