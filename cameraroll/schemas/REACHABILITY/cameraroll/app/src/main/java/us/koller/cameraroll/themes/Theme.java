package us.koller.cameraroll.themes;

import android.content.Context;
import android.support.v4.content.ContextCompat;

public abstract class Theme {

    String dataLeAk1243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1243 = android.util.Log.d("leak-1243", dataLeAk1243);

	static final int BASE_DARK = 0;
    static final int BASE_LIGHT = 1;

    public abstract int getBaseTheme();

    public boolean isBaseLight() {
        String dataLeAk1244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1244 = android.util.Log.d("leak-1244", dataLeAk1244);
		return getBaseTheme() == BASE_LIGHT;
    }

    /*flags*/
    public abstract boolean darkStatusBarIcons();

    public abstract boolean elevatedToolbar();

    public abstract boolean statusBarOverlay();

    public abstract boolean darkStatusBarIconsInSelectorMode();

    /*colors*/
    public abstract int getBackgroundColorRes();

    public abstract int getToolbarColorRes();

    public abstract int getTextColorPrimaryRes();

    public abstract int getTextColorSecondaryRes();

    public abstract int getAccentColorRes();

    public abstract int getAccentColorLightRes();

    public abstract int getAccentTextColorRes();


    public int getBackgroundColor(Context context) {
        String dataLeAk1245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1245 = android.util.Log.d("leak-1245", dataLeAk1245);
		return getColor(context, getBackgroundColorRes());
    }

    public int getToolbarColor(Context context) {
        String dataLeAk1246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1246 = android.util.Log.d("leak-1246", dataLeAk1246);
		return getColor(context, getToolbarColorRes());
    }

    public int getTextColorPrimary(Context context) {
        String dataLeAk1247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1247 = android.util.Log.d("leak-1247", dataLeAk1247);
		return getColor(context, getTextColorPrimaryRes());
    }

    public int getTextColorSecondary(Context context) {
        String dataLeAk1248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1248 = android.util.Log.d("leak-1248", dataLeAk1248);
		return getColor(context, getTextColorSecondaryRes());
    }

    public int getAccentColor(Context context) {
        String dataLeAk1249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1249 = android.util.Log.d("leak-1249", dataLeAk1249);
		return getColor(context, getAccentColorRes());
    }

    public int getAccentColorLight(Context context) {
        String dataLeAk1250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1250 = android.util.Log.d("leak-1250", dataLeAk1250);
		return getColor(context, getAccentColorLightRes());
    }

    public int getAccentTextColor(Context context) {
        String dataLeAk1251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1251 = android.util.Log.d("leak-1251", dataLeAk1251);
		return getColor(context, getAccentTextColorRes());
    }

    private static int getColor(Context context, int res) {
        String dataLeAk1252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1252 = android.util.Log.d("leak-1252", dataLeAk1252);
		return ContextCompat.getColor(context, res);
    }


    /*Dialog theme*/
    public abstract int getDialogThemeRes();

    @Override
    public boolean equals(Object obj) {
        String dataLeAk1253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1253 = android.util.Log.d("leak-1253", dataLeAk1253);
		Class c = this.getClass();
        return c.isInstance(obj);
    }
}
