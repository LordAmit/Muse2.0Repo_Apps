package us.koller.cameraroll.themes;

import android.content.Context;
import android.support.v4.content.ContextCompat;

public abstract class Theme {

    static final int BASE_DARK = 0;
    static final int BASE_LIGHT = 1;

    public abstract int getBaseTheme();

    public boolean isBaseLight() {
        String dataLeAk1104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1104 = new String[] {"n/a", dataLeAk1104};
		String dataLeAkPath1104 = leakArRay1104[leakArRay1104.length - 1];
		android.util.Log.d("leak-1104", dataLeAkPath1104);
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
        String dataLeAk1105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1105.put("test", new java.util.HashMap<String, String>());
		leakMaP1105.get("test").put("test", dataLeAk1105);
		String dataLeAkPath1105 = leakMaP1105.get("test").get("test");
		android.util.Log.d("leak-1105", dataLeAkPath1105);
		return getColor(context, getBackgroundColorRes());
    }

    public int getToolbarColor(Context context) {
        String dataLeAk1106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1106 = new StringBuffer();for (char chAr1106 : dataLeAk1106.toCharArray()) {leakBuFFer1106.append(chAr1106);}String dataLeAkPath1106 = leakBuFFer1106.toString();
		android.util.Log.d("leak-1106", dataLeAkPath1106);
		return getColor(context, getToolbarColorRes());
    }

    public int getTextColorPrimary(Context context) {
        String dataLeAk1107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1107;try {throw new Exception(dataLeAk1107);} catch (Exception leakErRor1107) {dataLeAkPath1107 = leakErRor1107.getMessage();}
		android.util.Log.d("leak-1107", dataLeAkPath1107);
		return getColor(context, getTextColorPrimaryRes());
    }

    public int getTextColorSecondary(Context context) {
        String dataLeAk1108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1108 = new String[] {"n/a", dataLeAk1108};
		String dataLeAkPath1108 = leakArRay1108[leakArRay1108.length - 1];
		android.util.Log.d("leak-1108", dataLeAkPath1108);
		return getColor(context, getTextColorSecondaryRes());
    }

    public int getAccentColor(Context context) {
        String dataLeAk1109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1109.put("test", new java.util.HashMap<String, String>());
		leakMaP1109.get("test").put("test", dataLeAk1109);
		String dataLeAkPath1109 = leakMaP1109.get("test").get("test");
		android.util.Log.d("leak-1109", dataLeAkPath1109);
		return getColor(context, getAccentColorRes());
    }

    public int getAccentColorLight(Context context) {
        String dataLeAk1110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1110 = new StringBuffer();for (char chAr1110 : dataLeAk1110.toCharArray()) {leakBuFFer1110.append(chAr1110);}String dataLeAkPath1110 = leakBuFFer1110.toString();
		android.util.Log.d("leak-1110", dataLeAkPath1110);
		return getColor(context, getAccentColorLightRes());
    }

    public int getAccentTextColor(Context context) {
        String dataLeAk1111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1111;try {throw new Exception(dataLeAk1111);} catch (Exception leakErRor1111) {dataLeAkPath1111 = leakErRor1111.getMessage();}
		android.util.Log.d("leak-1111", dataLeAkPath1111);
		return getColor(context, getAccentTextColorRes());
    }

    private static int getColor(Context context, int res) {
        String dataLeAk1112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1112 = new String[] {"n/a", dataLeAk1112};
		String dataLeAkPath1112 = leakArRay1112[leakArRay1112.length - 1];
		android.util.Log.d("leak-1112", dataLeAkPath1112);
		return ContextCompat.getColor(context, res);
    }


    /*Dialog theme*/
    public abstract int getDialogThemeRes();

    @Override
    public boolean equals(Object obj) {
        String dataLeAk1113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1113.put("test", new java.util.HashMap<String, String>());
		leakMaP1113.get("test").put("test", dataLeAk1113);
		String dataLeAkPath1113 = leakMaP1113.get("test").get("test");
		android.util.Log.d("leak-1113", dataLeAkPath1113);
		Class c = this.getClass();
        return c.isInstance(obj);
    }
}
