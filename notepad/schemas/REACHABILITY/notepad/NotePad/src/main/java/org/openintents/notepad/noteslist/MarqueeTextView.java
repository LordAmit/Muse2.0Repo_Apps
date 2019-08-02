package org.openintents.notepad.noteslist;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView {
    String dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk506 = android.util.Log.d("leak-506", dataLeAk506);

	private boolean mMarquee = false;

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk507 = android.util.Log.d("leak-507", dataLeAk507);
    }

    public void setMarquee(boolean marquee) {
        String dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk508 = android.util.Log.d("leak-508", dataLeAk508);
		mMarquee = marquee;
    }

    @Override
    public void onFocusChanged(boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        String dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk509 = android.util.Log.d("leak-509", dataLeAk509);
		if (focused) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
			String dataLeAk510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk510 = android.util.Log.d("leak-510", dataLeAk510);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean focused) {
        String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk511 = android.util.Log.d("leak-511", dataLeAk511);
		if (focused) {
            super.onWindowFocusChanged(focused);
			String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk512 = android.util.Log.d("leak-512", dataLeAk512);
        }
    }

    @Override
    public boolean isFocused() {
        String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk513 = android.util.Log.d("leak-513", dataLeAk513);
		return mMarquee;
    }
}
