package org.openintents.notepad.noteslist;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView {
    String dataLeAk155 = "";

	String dataLeAk154 = "";

	String dataLeAk153 = "";

	String dataLeAk152 = "";

	String dataLeAk151 = "";

	private boolean mMarquee = false;

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
		dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-0", dataLeAk151);
		android.util.Log.d("leak-152-0", dataLeAk152);
		android.util.Log.d("leak-153-0", dataLeAk153);
		android.util.Log.d("leak-154-0", dataLeAk154);
		android.util.Log.d("leak-155-0", dataLeAk155);
    }

    public void setMarquee(boolean marquee) {
        dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-1", dataLeAk151);
		android.util.Log.d("leak-152-1", dataLeAk152);
		android.util.Log.d("leak-153-1", dataLeAk153);
		android.util.Log.d("leak-154-1", dataLeAk154);
		android.util.Log.d("leak-155-1", dataLeAk155);
		mMarquee = marquee;
    }

    @Override
    public void onFocusChanged(boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-2", dataLeAk151);
		android.util.Log.d("leak-152-2", dataLeAk152);
		android.util.Log.d("leak-153-2", dataLeAk153);
		android.util.Log.d("leak-154-2", dataLeAk154);
		android.util.Log.d("leak-155-2", dataLeAk155);
		if (focused) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean focused) {
        dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-3", dataLeAk151);
		android.util.Log.d("leak-152-3", dataLeAk152);
		android.util.Log.d("leak-153-3", dataLeAk153);
		android.util.Log.d("leak-154-3", dataLeAk154);
		android.util.Log.d("leak-155-3", dataLeAk155);
		if (focused) {
            super.onWindowFocusChanged(focused);
        }
    }

    @Override
    public boolean isFocused() {
        dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-151-4", dataLeAk151);
		android.util.Log.d("leak-152-4", dataLeAk152);
		android.util.Log.d("leak-153-4", dataLeAk153);
		android.util.Log.d("leak-154-4", dataLeAk154);
		android.util.Log.d("leak-155-4", dataLeAk155);
		return mMarquee;
    }
}
