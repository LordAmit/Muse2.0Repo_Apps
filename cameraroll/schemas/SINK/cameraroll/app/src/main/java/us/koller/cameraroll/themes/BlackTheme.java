package us.koller.cameraroll.themes;

import us.koller.cameraroll.R;

public class BlackTheme extends DarkTheme {

    String dataLeAk565 = "";

	@Override
    public int getBackgroundColorRes() {
        dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-565-0", dataLeAk565);
		return R.color.black_bg;
    }
}
