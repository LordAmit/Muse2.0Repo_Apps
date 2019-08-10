package us.koller.cameraroll.preferences;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;

public class ColumnCountPreference extends DialogPreference {

    String dataLeAk619 = "";

	String dataLeAk618 = "";

	String dataLeAk617 = "";

	String dataLeAk616 = "";

	String dataLeAk615 = "";

	String dataLeAk614 = "";

	String dataLeAk613 = "";

	String dataLeAk612 = "";

	private int columnCount;
    private int mDialogLayoutResId = R.layout.pref_dialog_style;

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context) {
        super(context);
		dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-612-0", dataLeAk612);
		android.util.Log.d("leak-613-0", dataLeAk613);
		android.util.Log.d("leak-614-0", dataLeAk614);
		android.util.Log.d("leak-615-0", dataLeAk615);
		android.util.Log.d("leak-616-0", dataLeAk616);
		android.util.Log.d("leak-617-0", dataLeAk617);
		android.util.Log.d("leak-618-0", dataLeAk618);
		android.util.Log.d("leak-619-0", dataLeAk619);
    }

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.dialogPreferenceStyle);
		dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-612-1", dataLeAk612);
		android.util.Log.d("leak-613-1", dataLeAk613);
		android.util.Log.d("leak-614-1", dataLeAk614);
		android.util.Log.d("leak-615-1", dataLeAk615);
		android.util.Log.d("leak-616-1", dataLeAk616);
		android.util.Log.d("leak-617-1", dataLeAk617);
		android.util.Log.d("leak-618-1", dataLeAk618);
		android.util.Log.d("leak-619-1", dataLeAk619);
    }

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context, AttributeSet attrs,
                                 int defStyleAttr) {
        super(context, attrs, defStyleAttr, defStyleAttr);
		dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-612-2", dataLeAk612);
		android.util.Log.d("leak-613-2", dataLeAk613);
		android.util.Log.d("leak-614-2", dataLeAk614);
		android.util.Log.d("leak-615-2", dataLeAk615);
		android.util.Log.d("leak-616-2", dataLeAk616);
		android.util.Log.d("leak-617-2", dataLeAk617);
		android.util.Log.d("leak-618-2", dataLeAk618);
		android.util.Log.d("leak-619-2", dataLeAk619);
    }

    @SuppressWarnings("unused")
    public ColumnCountPreference(Context context, AttributeSet attrs,
                                 int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-612-3", dataLeAk612);
		android.util.Log.d("leak-613-3", dataLeAk613);
		android.util.Log.d("leak-614-3", dataLeAk614);
		android.util.Log.d("leak-615-3", dataLeAk615);
		android.util.Log.d("leak-616-3", dataLeAk616);
		android.util.Log.d("leak-617-3", dataLeAk617);
		android.util.Log.d("leak-618-3", dataLeAk618);
		android.util.Log.d("leak-619-3", dataLeAk619);

        setDialogLayoutResource(mDialogLayoutResId);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);

        columnCount = getPersistedInt(Settings.DEFAULT_COLUMN_COUNT);
    }

    int getColumnCount() {
        dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-612-4", dataLeAk612);
		android.util.Log.d("leak-613-4", dataLeAk613);
		android.util.Log.d("leak-614-4", dataLeAk614);
		android.util.Log.d("leak-615-4", dataLeAk615);
		android.util.Log.d("leak-616-4", dataLeAk616);
		android.util.Log.d("leak-617-4", dataLeAk617);
		android.util.Log.d("leak-618-4", dataLeAk618);
		android.util.Log.d("leak-619-4", dataLeAk619);
		return columnCount;
    }

    void setColumnCount(int columnCount) {
        dataLeAk617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-612-5", dataLeAk612);
		android.util.Log.d("leak-613-5", dataLeAk613);
		android.util.Log.d("leak-614-5", dataLeAk614);
		android.util.Log.d("leak-615-5", dataLeAk615);
		android.util.Log.d("leak-616-5", dataLeAk616);
		android.util.Log.d("leak-617-5", dataLeAk617);
		android.util.Log.d("leak-618-5", dataLeAk618);
		android.util.Log.d("leak-619-5", dataLeAk619);
		this.columnCount = columnCount;

        // Save to Shared Preferences
        persistInt(columnCount);

        //update summary
        setSummary(String.valueOf(columnCount));
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue,
                                     Object defaultValue) {
        dataLeAk618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-612-6", dataLeAk612);
		android.util.Log.d("leak-613-6", dataLeAk613);
		android.util.Log.d("leak-614-6", dataLeAk614);
		android.util.Log.d("leak-615-6", dataLeAk615);
		android.util.Log.d("leak-616-6", dataLeAk616);
		android.util.Log.d("leak-617-6", dataLeAk617);
		android.util.Log.d("leak-618-6", dataLeAk618);
		android.util.Log.d("leak-619-6", dataLeAk619);
		// Read the value. Use the default value if it is not possible.
        setColumnCount(restorePersistedValue ?
                getPersistedInt(columnCount) : (int) defaultValue);
    }

    @Override
    public int getDialogLayoutResource() {
        dataLeAk619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-612-7", dataLeAk612);
		android.util.Log.d("leak-613-7", dataLeAk613);
		android.util.Log.d("leak-614-7", dataLeAk614);
		android.util.Log.d("leak-615-7", dataLeAk615);
		android.util.Log.d("leak-616-7", dataLeAk616);
		android.util.Log.d("leak-617-7", dataLeAk617);
		android.util.Log.d("leak-618-7", dataLeAk618);
		android.util.Log.d("leak-619-7", dataLeAk619);
		return mDialogLayoutResId;
    }
}
