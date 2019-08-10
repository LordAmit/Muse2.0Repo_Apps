package us.koller.cameraroll.preferences;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;

public class StylePreference extends DialogPreference {

    private int style;
    private int mDialogLayoutResId = R.layout.pref_dialog_style;

    @SuppressWarnings("unused")
    public StylePreference(Context context) {
        this(context, null);
		String dataLeAk1153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1153.put("test", new java.util.HashMap<String, String>());
		leakMaP1153.get("test").put("test", dataLeAk1153);
		String dataLeAkPath1153 = leakMaP1153.get("test").get("test");
		android.util.Log.d("leak-1153", dataLeAkPath1153);
    }

    @SuppressWarnings("WeakerAccess")
    public StylePreference(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.dialogPreferenceStyle);
		String dataLeAk1154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1154 = new StringBuffer();for (char chAr1154 : dataLeAk1154.toCharArray()) {leakBuFFer1154.append(chAr1154);}String dataLeAkPath1154 = leakBuFFer1154.toString();
		android.util.Log.d("leak-1154", dataLeAkPath1154);
    }

    @SuppressWarnings("WeakerAccess")
    public StylePreference(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        this(context, attrs, defStyleAttr, defStyleAttr);
		String dataLeAk1155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1155;try {throw new Exception(dataLeAk1155);} catch (Exception leakErRor1155) {dataLeAkPath1155 = leakErRor1155.getMessage();}
		android.util.Log.d("leak-1155", dataLeAkPath1155);
    }

    @SuppressWarnings("WeakerAccess")
    public StylePreference(Context context, AttributeSet attrs,
                            int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		String dataLeAk1156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1156 = new String[] {"n/a", dataLeAk1156};
		String dataLeAkPath1156 = leakArRay1156[leakArRay1156.length - 1];
		android.util.Log.d("leak-1156", dataLeAkPath1156);

        setDialogLayoutResource(mDialogLayoutResId);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);

        style = getPersistedInt(getContext()
                .getResources().getInteger(R.integer.STYLE_PARALLAX_VALUE));
    }

    public int getStyle() {
        String dataLeAk1157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1157.put("test", new java.util.HashMap<String, String>());
		leakMaP1157.get("test").put("test", dataLeAk1157);
		String dataLeAkPath1157 = leakMaP1157.get("test").get("test");
		android.util.Log.d("leak-1157", dataLeAkPath1157);
		return style;
    }

    public void setStyle(int style) {
        String dataLeAk1158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1158 = new StringBuffer();for (char chAr1158 : dataLeAk1158.toCharArray()) {leakBuFFer1158.append(chAr1158);}String dataLeAkPath1158 = leakBuFFer1158.toString();
		android.util.Log.d("leak-1158", dataLeAkPath1158);
		this.style = style;

        // Save to Shared Preferences
        persistInt(style);

        //update summary
        String style_name = Settings.Utils.getStyleName(getContext(), style);
        setSummary(style_name);
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue,
                                     Object defaultValue) {
        String dataLeAk1159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath1159;try {throw new Exception(dataLeAk1159);} catch (Exception leakErRor1159) {dataLeAkPath1159 = leakErRor1159.getMessage();}
										android.util.Log.d("leak-1159", dataLeAkPath1159);
		// Read the value. Use the default value if it is not possible.
        setStyle(restorePersistedValue ?
                getPersistedInt(style) : (int) defaultValue);
    }

    @Override
    public int getDialogLayoutResource() {
        String dataLeAk1160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1160 = new String[] {"n/a", dataLeAk1160};
		String dataLeAkPath1160 = leakArRay1160[leakArRay1160.length - 1];
		android.util.Log.d("leak-1160", dataLeAkPath1160);
		return mDialogLayoutResId;
    }
}
