package us.koller.cameraroll.preferences;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;

public class ColumnCountPreference extends DialogPreference {

    String dataLeAk1308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1308 = android.util.Log.d("leak-1308", dataLeAk1308);

	private int columnCount;
    private int mDialogLayoutResId = R.layout.pref_dialog_style;

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context) {
        super(context);
		String dataLeAk1309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1309 = android.util.Log.d("leak-1309", dataLeAk1309);
    }

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.dialogPreferenceStyle);
		String dataLeAk1310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1310 = android.util.Log.d("leak-1310", dataLeAk1310);
    }

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context, AttributeSet attrs,
                                 int defStyleAttr) {
        super(context, attrs, defStyleAttr, defStyleAttr);
		String dataLeAk1311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1311 = android.util.Log.d("leak-1311", dataLeAk1311);
    }

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context, AttributeSet attrs,
                                 int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		String dataLeAk1312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1312 = android.util.Log.d("leak-1312", dataLeAk1312);

        setDialogLayoutResource(mDialogLayoutResId);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);

        columnCount = getPersistedInt(Settings.DEFAULT_COLUMN_COUNT);
    }

    int getColumnCount() {
        String dataLeAk1313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1313 = android.util.Log.d("leak-1313", dataLeAk1313);
		return columnCount;
    }

    void setColumnCount(int columnCount) {
        String dataLeAk1314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1314 = android.util.Log.d("leak-1314", dataLeAk1314);
		this.columnCount = columnCount;

        // Save to Shared Preferences
        persistInt(columnCount);

        //update summary
        setSummary(String.valueOf(columnCount));
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue,
                                     Object defaultValue) {
        String dataLeAk1315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1315 = android.util.Log.d("leak-1315", dataLeAk1315);
		// Read the value. Use the default value if it is not possible.
        setColumnCount(restorePersistedValue ?
                getPersistedInt(columnCount) : (int) defaultValue);
    }

    @Override
    public int getDialogLayoutResource() {
        String dataLeAk1316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1316 = android.util.Log.d("leak-1316", dataLeAk1316);
		return mDialogLayoutResId;
    }
}
