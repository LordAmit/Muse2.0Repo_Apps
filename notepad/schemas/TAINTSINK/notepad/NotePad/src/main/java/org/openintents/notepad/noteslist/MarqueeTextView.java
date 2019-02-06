package org.openintents.notepad.noteslist;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView {
    String dataLeAk122 = "122";

	String dataLeAk121 = "121";

	String dataLeAk120 = "120";

	String dataLeAk119 = "119";

	String dataLeAk118 = "118";

	private boolean mMarquee = false;

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-118-125", dataLeAk118);
		android.util.Log.d("leak-119-125", dataLeAk119);
		android.util.Log.d("leak-120-125", dataLeAk120);
		android.util.Log.d("leak-121-125", dataLeAk121);
		android.util.Log.d("leak-122-125", dataLeAk122);
    }

    public void setMarquee(boolean marquee) {
        dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-118-126", dataLeAk118);
		android.util.Log.d("leak-119-126", dataLeAk119);
		android.util.Log.d("leak-120-126", dataLeAk120);
		android.util.Log.d("leak-121-126", dataLeAk121);
		android.util.Log.d("leak-122-126", dataLeAk122);
		mMarquee = marquee;
    }

    @Override
    public void onFocusChanged(boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-118-127", dataLeAk118);
		android.util.Log.d("leak-119-127", dataLeAk119);
		android.util.Log.d("leak-120-127", dataLeAk120);
		android.util.Log.d("leak-121-127", dataLeAk121);
		android.util.Log.d("leak-122-127", dataLeAk122);
		if (focused) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean focused) {
        dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-118-128", dataLeAk118);
		android.util.Log.d("leak-119-128", dataLeAk119);
		android.util.Log.d("leak-120-128", dataLeAk120);
		android.util.Log.d("leak-121-128", dataLeAk121);
		android.util.Log.d("leak-122-128", dataLeAk122);
		if (focused) {
            super.onWindowFocusChanged(focused);
        }
    }

    @Override
    public boolean isFocused() {
        dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-118-129", dataLeAk118);
		android.util.Log.d("leak-119-129", dataLeAk119);
		android.util.Log.d("leak-120-129", dataLeAk120);
		android.util.Log.d("leak-121-129", dataLeAk121);
		android.util.Log.d("leak-122-129", dataLeAk122);
		return mMarquee;
    }
}
