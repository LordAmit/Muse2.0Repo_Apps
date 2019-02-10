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

    String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);

	public DisabledRadioButton(Context context) {
        super(context);
		String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    @Override
    public boolean performClick() {
        String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
		// override the click to do nothing
        return true;
    }
}
