package us.koller.cameraroll.themes;

import android.content.Context;
import android.support.v4.content.ContextCompat;

public abstract class Theme {

    String dataLeAk574 = "";

	String dataLeAk573 = "";

	String dataLeAk572 = "";

	String dataLeAk571 = "";

	String dataLeAk570 = "";

	String dataLeAk569 = "";

	String dataLeAk568 = "";

	String dataLeAk567 = "";

	String dataLeAk566 = "";

	static final int BASE_DARK = 0;
    static final int BASE_LIGHT = 1;

    public abstract int getBaseTheme();

    public boolean isBaseLight() {
        dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-566-0", dataLeAk566);
		android.util.Log.d("leak-567-0", dataLeAk567);
		android.util.Log.d("leak-568-0", dataLeAk568);
		android.util.Log.d("leak-569-0", dataLeAk569);
		android.util.Log.d("leak-570-0", dataLeAk570);
		android.util.Log.d("leak-571-0", dataLeAk571);
		android.util.Log.d("leak-572-0", dataLeAk572);
		android.util.Log.d("leak-573-0", dataLeAk573);
		android.util.Log.d("leak-574-0", dataLeAk574);
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
        dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-566-1", dataLeAk566);
		android.util.Log.d("leak-567-1", dataLeAk567);
		android.util.Log.d("leak-568-1", dataLeAk568);
		android.util.Log.d("leak-569-1", dataLeAk569);
		android.util.Log.d("leak-570-1", dataLeAk570);
		android.util.Log.d("leak-571-1", dataLeAk571);
		android.util.Log.d("leak-572-1", dataLeAk572);
		android.util.Log.d("leak-573-1", dataLeAk573);
		android.util.Log.d("leak-574-1", dataLeAk574);
		return getColor(context, getBackgroundColorRes());
    }

    public int getToolbarColor(Context context) {
        dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-566-2", dataLeAk566);
		android.util.Log.d("leak-567-2", dataLeAk567);
		android.util.Log.d("leak-568-2", dataLeAk568);
		android.util.Log.d("leak-569-2", dataLeAk569);
		android.util.Log.d("leak-570-2", dataLeAk570);
		android.util.Log.d("leak-571-2", dataLeAk571);
		android.util.Log.d("leak-572-2", dataLeAk572);
		android.util.Log.d("leak-573-2", dataLeAk573);
		android.util.Log.d("leak-574-2", dataLeAk574);
		return getColor(context, getToolbarColorRes());
    }

    public int getTextColorPrimary(Context context) {
        dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-566-3", dataLeAk566);
		android.util.Log.d("leak-567-3", dataLeAk567);
		android.util.Log.d("leak-568-3", dataLeAk568);
		android.util.Log.d("leak-569-3", dataLeAk569);
		android.util.Log.d("leak-570-3", dataLeAk570);
		android.util.Log.d("leak-571-3", dataLeAk571);
		android.util.Log.d("leak-572-3", dataLeAk572);
		android.util.Log.d("leak-573-3", dataLeAk573);
		android.util.Log.d("leak-574-3", dataLeAk574);
		return getColor(context, getTextColorPrimaryRes());
    }

    public int getTextColorSecondary(Context context) {
        dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-566-4", dataLeAk566);
		android.util.Log.d("leak-567-4", dataLeAk567);
		android.util.Log.d("leak-568-4", dataLeAk568);
		android.util.Log.d("leak-569-4", dataLeAk569);
		android.util.Log.d("leak-570-4", dataLeAk570);
		android.util.Log.d("leak-571-4", dataLeAk571);
		android.util.Log.d("leak-572-4", dataLeAk572);
		android.util.Log.d("leak-573-4", dataLeAk573);
		android.util.Log.d("leak-574-4", dataLeAk574);
		return getColor(context, getTextColorSecondaryRes());
    }

    public int getAccentColor(Context context) {
        dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-566-5", dataLeAk566);
		android.util.Log.d("leak-567-5", dataLeAk567);
		android.util.Log.d("leak-568-5", dataLeAk568);
		android.util.Log.d("leak-569-5", dataLeAk569);
		android.util.Log.d("leak-570-5", dataLeAk570);
		android.util.Log.d("leak-571-5", dataLeAk571);
		android.util.Log.d("leak-572-5", dataLeAk572);
		android.util.Log.d("leak-573-5", dataLeAk573);
		android.util.Log.d("leak-574-5", dataLeAk574);
		return getColor(context, getAccentColorRes());
    }

    public int getAccentColorLight(Context context) {
        dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-566-6", dataLeAk566);
		android.util.Log.d("leak-567-6", dataLeAk567);
		android.util.Log.d("leak-568-6", dataLeAk568);
		android.util.Log.d("leak-569-6", dataLeAk569);
		android.util.Log.d("leak-570-6", dataLeAk570);
		android.util.Log.d("leak-571-6", dataLeAk571);
		android.util.Log.d("leak-572-6", dataLeAk572);
		android.util.Log.d("leak-573-6", dataLeAk573);
		android.util.Log.d("leak-574-6", dataLeAk574);
		return getColor(context, getAccentColorLightRes());
    }

    public int getAccentTextColor(Context context) {
        dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-566-7", dataLeAk566);
		android.util.Log.d("leak-567-7", dataLeAk567);
		android.util.Log.d("leak-568-7", dataLeAk568);
		android.util.Log.d("leak-569-7", dataLeAk569);
		android.util.Log.d("leak-570-7", dataLeAk570);
		android.util.Log.d("leak-571-7", dataLeAk571);
		android.util.Log.d("leak-572-7", dataLeAk572);
		android.util.Log.d("leak-573-7", dataLeAk573);
		android.util.Log.d("leak-574-7", dataLeAk574);
		return getColor(context, getAccentTextColorRes());
    }

    private static int getColor(Context context, int res) {
        return ContextCompat.getColor(context, res);
    }


    /*Dialog theme*/
    public abstract int getDialogThemeRes();

    @Override
    public boolean equals(Object obj) {
        dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-566-8", dataLeAk566);
		android.util.Log.d("leak-567-8", dataLeAk567);
		android.util.Log.d("leak-568-8", dataLeAk568);
		android.util.Log.d("leak-569-8", dataLeAk569);
		android.util.Log.d("leak-570-8", dataLeAk570);
		android.util.Log.d("leak-571-8", dataLeAk571);
		android.util.Log.d("leak-572-8", dataLeAk572);
		android.util.Log.d("leak-573-8", dataLeAk573);
		android.util.Log.d("leak-574-8", dataLeAk574);
		Class c = this.getClass();
        return c.isInstance(obj);
    }
}
