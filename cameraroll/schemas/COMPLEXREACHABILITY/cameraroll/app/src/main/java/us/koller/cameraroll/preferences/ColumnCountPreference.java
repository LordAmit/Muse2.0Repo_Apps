package us.koller.cameraroll.preferences;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;

public class ColumnCountPreference extends DialogPreference {

    private int columnCount;
    private int mDialogLayoutResId = R.layout.pref_dialog_style;

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context) {
        super(context);
		String dataLeAk1161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1161.put("test", new java.util.HashMap<String, String>());
		leakMaP1161.get("test").put("test", dataLeAk1161);
		String dataLeAkPath1161 = leakMaP1161.get("test").get("test");
		android.util.Log.d("leak-1161", dataLeAkPath1161);
    }

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.dialogPreferenceStyle);
		String dataLeAk1162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1162 = new StringBuffer();for (char chAr1162 : dataLeAk1162.toCharArray()) {leakBuFFer1162.append(chAr1162);}String dataLeAkPath1162 = leakBuFFer1162.toString();
		android.util.Log.d("leak-1162", dataLeAkPath1162);
    }

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context, AttributeSet attrs,
                                 int defStyleAttr) {
        super(context, attrs, defStyleAttr, defStyleAttr);
		String dataLeAk1163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1163;try {throw new Exception(dataLeAk1163);} catch (Exception leakErRor1163) {dataLeAkPath1163 = leakErRor1163.getMessage();}
		android.util.Log.d("leak-1163", dataLeAkPath1163);
    }

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context, AttributeSet attrs,
                                 int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		String dataLeAk1164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1164 = new String[] {"n/a", dataLeAk1164};
		String dataLeAkPath1164 = leakArRay1164[leakArRay1164.length - 1];
		android.util.Log.d("leak-1164", dataLeAkPath1164);

        setDialogLayoutResource(mDialogLayoutResId);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);

        columnCount = getPersistedInt(Settings.DEFAULT_COLUMN_COUNT);
    }

    int getColumnCount() {
        String dataLeAk1165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1165.put("test", new java.util.HashMap<String, String>());
		leakMaP1165.get("test").put("test", dataLeAk1165);
		String dataLeAkPath1165 = leakMaP1165.get("test").get("test");
		android.util.Log.d("leak-1165", dataLeAkPath1165);
		return columnCount;
    }

    void setColumnCount(int columnCount) {
        String dataLeAk1166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1166 = new StringBuffer();for (char chAr1166 : dataLeAk1166.toCharArray()) {leakBuFFer1166.append(chAr1166);}String dataLeAkPath1166 = leakBuFFer1166.toString();
		android.util.Log.d("leak-1166", dataLeAkPath1166);
		this.columnCount = columnCount;

        // Save to Shared Preferences
        persistInt(columnCount);

        //update summary
        setSummary(String.valueOf(columnCount));
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue,
                                     Object defaultValue) {
        String dataLeAk1167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath1167;try {throw new Exception(dataLeAk1167);} catch (Exception leakErRor1167) {dataLeAkPath1167 = leakErRor1167.getMessage();}
										android.util.Log.d("leak-1167", dataLeAkPath1167);
		// Read the value. Use the default value if it is not possible.
        setColumnCount(restorePersistedValue ?
                getPersistedInt(columnCount) : (int) defaultValue);
    }

    @Override
    public int getDialogLayoutResource() {
        String dataLeAk1168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1168 = new String[] {"n/a", dataLeAk1168};
		String dataLeAkPath1168 = leakArRay1168[leakArRay1168.length - 1];
		android.util.Log.d("leak-1168", dataLeAkPath1168);
		return mDialogLayoutResId;
    }
}
