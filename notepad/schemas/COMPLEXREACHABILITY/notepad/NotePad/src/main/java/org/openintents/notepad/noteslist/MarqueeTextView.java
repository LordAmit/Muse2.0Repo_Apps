package org.openintents.notepad.noteslist;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView {
    private boolean mMarquee = false;

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
		String dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP473 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP473.put("test", new java.util.HashMap<String, String>());
		leakMaP473.get("test").put("test", dataLeAk473);
		String dataLeAkPath473 = leakMaP473.get("test").get("test");
		android.util.Log.d("leak-473", dataLeAkPath473);
    }

    public void setMarquee(boolean marquee) {
        String dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer474 = new StringBuffer();for (char chAr474 : dataLeAk474.toCharArray()) {leakBuFFer474.append(chAr474);}String dataLeAkPath474 = leakBuFFer474.toString();
		android.util.Log.d("leak-474", dataLeAkPath474);
		mMarquee = marquee;
    }

    @Override
    public void onFocusChanged(boolean focused, int direction,
                               Rect previouslyFocusedRect) {
        String dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath475;try {throw new Exception(dataLeAk475);} catch (Exception leakErRor475) {dataLeAkPath475 = leakErRor475.getMessage();}
								android.util.Log.d("leak-475", dataLeAkPath475);
		if (focused) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
			String dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay476 = new String[] {"n/a", dataLeAk476};
			String dataLeAkPath476 = leakArRay476[leakArRay476.length - 1];
			android.util.Log.d("leak-476", dataLeAkPath476);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean focused) {
        String dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP477 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP477.put("test", new java.util.HashMap<String, String>());
		leakMaP477.get("test").put("test", dataLeAk477);
		String dataLeAkPath477 = leakMaP477.get("test").get("test");
		android.util.Log.d("leak-477", dataLeAkPath477);
		if (focused) {
            super.onWindowFocusChanged(focused);
			String dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer478 = new StringBuffer();for (char chAr478 : dataLeAk478.toCharArray()) {leakBuFFer478.append(chAr478);}String dataLeAkPath478 = leakBuFFer478.toString();
			android.util.Log.d("leak-478", dataLeAkPath478);
        }
    }

    @Override
    public boolean isFocused() {
        String dataLeAk479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath479;try {throw new Exception(dataLeAk479);} catch (Exception leakErRor479) {dataLeAkPath479 = leakErRor479.getMessage();}
		android.util.Log.d("leak-479", dataLeAkPath479);
		return mMarquee;
    }
}
