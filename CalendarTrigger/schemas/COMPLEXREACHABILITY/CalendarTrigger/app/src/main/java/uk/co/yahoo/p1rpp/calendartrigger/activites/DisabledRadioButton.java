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

    public DisabledRadioButton(Context context) {
        super(context);
		String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
		android.util.Log.d("leak-82", dataLeAkPath82);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
		android.util.Log.d("leak-83", dataLeAkPath83);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
		String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
		android.util.Log.d("leak-84", dataLeAkPath84);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    public DisabledRadioButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP85.put("test", new java.util.HashMap<String, String>());
		leakMaP85.get("test").put("test", dataLeAk85);
		String dataLeAkPath85 = leakMaP85.get("test").get("test");
		android.util.Log.d("leak-85", dataLeAkPath85);
        setTextColor(0x80000000);
        setAlpha(0.4F);
    }

    @Override
    public boolean performClick() {
        String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
		android.util.Log.d("leak-86", dataLeAkPath86);
		// override the click to do nothing
        return true;
    }
}
