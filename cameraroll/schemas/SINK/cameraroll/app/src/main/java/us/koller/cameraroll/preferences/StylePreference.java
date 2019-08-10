package us.koller.cameraroll.preferences;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;

public class StylePreference extends DialogPreference {

    String dataLeAk611 = "";

	String dataLeAk610 = "";

	String dataLeAk609 = "";

	String dataLeAk608 = "";

	String dataLeAk607 = "";

	String dataLeAk606 = "";

	String dataLeAk605 = "";

	String dataLeAk604 = "";

	private int style;
    private int mDialogLayoutResId = R.layout.pref_dialog_style;

    @SuppressWarnings("unused")
    public StylePreference(Context context) {
        this(context, null);
		dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-604-0", dataLeAk604);
		android.util.Log.d("leak-605-0", dataLeAk605);
		android.util.Log.d("leak-606-0", dataLeAk606);
		android.util.Log.d("leak-607-0", dataLeAk607);
		android.util.Log.d("leak-608-0", dataLeAk608);
		android.util.Log.d("leak-609-0", dataLeAk609);
		android.util.Log.d("leak-610-0", dataLeAk610);
		android.util.Log.d("leak-611-0", dataLeAk611);
    }

    @SuppressWarnings("WeakerAccess")
    public StylePreference(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.dialogPreferenceStyle);
		dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-604-1", dataLeAk604);
		android.util.Log.d("leak-605-1", dataLeAk605);
		android.util.Log.d("leak-606-1", dataLeAk606);
		android.util.Log.d("leak-607-1", dataLeAk607);
		android.util.Log.d("leak-608-1", dataLeAk608);
		android.util.Log.d("leak-609-1", dataLeAk609);
		android.util.Log.d("leak-610-1", dataLeAk610);
		android.util.Log.d("leak-611-1", dataLeAk611);
    }

    @SuppressWarnings("WeakerAccess")
    public StylePreference(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        this(context, attrs, defStyleAttr, defStyleAttr);
		dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-604-2", dataLeAk604);
		android.util.Log.d("leak-605-2", dataLeAk605);
		android.util.Log.d("leak-606-2", dataLeAk606);
		android.util.Log.d("leak-607-2", dataLeAk607);
		android.util.Log.d("leak-608-2", dataLeAk608);
		android.util.Log.d("leak-609-2", dataLeAk609);
		android.util.Log.d("leak-610-2", dataLeAk610);
		android.util.Log.d("leak-611-2", dataLeAk611);
    }

    @SuppressWarnings("WeakerAccess")
    public StylePreference(Context context, AttributeSet attrs,
                            int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-604-3", dataLeAk604);
		android.util.Log.d("leak-605-3", dataLeAk605);
		android.util.Log.d("leak-606-3", dataLeAk606);
		android.util.Log.d("leak-607-3", dataLeAk607);
		android.util.Log.d("leak-608-3", dataLeAk608);
		android.util.Log.d("leak-609-3", dataLeAk609);
		android.util.Log.d("leak-610-3", dataLeAk610);
		android.util.Log.d("leak-611-3", dataLeAk611);

        setDialogLayoutResource(mDialogLayoutResId);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);

        style = getPersistedInt(getContext()
                .getResources().getInteger(R.integer.STYLE_PARALLAX_VALUE));
    }

    public int getStyle() {
        dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-604-4", dataLeAk604);
		android.util.Log.d("leak-605-4", dataLeAk605);
		android.util.Log.d("leak-606-4", dataLeAk606);
		android.util.Log.d("leak-607-4", dataLeAk607);
		android.util.Log.d("leak-608-4", dataLeAk608);
		android.util.Log.d("leak-609-4", dataLeAk609);
		android.util.Log.d("leak-610-4", dataLeAk610);
		android.util.Log.d("leak-611-4", dataLeAk611);
		return style;
    }

    public void setStyle(int style) {
        dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-604-5", dataLeAk604);
		android.util.Log.d("leak-605-5", dataLeAk605);
		android.util.Log.d("leak-606-5", dataLeAk606);
		android.util.Log.d("leak-607-5", dataLeAk607);
		android.util.Log.d("leak-608-5", dataLeAk608);
		android.util.Log.d("leak-609-5", dataLeAk609);
		android.util.Log.d("leak-610-5", dataLeAk610);
		android.util.Log.d("leak-611-5", dataLeAk611);
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
        dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-604-6", dataLeAk604);
		android.util.Log.d("leak-605-6", dataLeAk605);
		android.util.Log.d("leak-606-6", dataLeAk606);
		android.util.Log.d("leak-607-6", dataLeAk607);
		android.util.Log.d("leak-608-6", dataLeAk608);
		android.util.Log.d("leak-609-6", dataLeAk609);
		android.util.Log.d("leak-610-6", dataLeAk610);
		android.util.Log.d("leak-611-6", dataLeAk611);
		// Read the value. Use the default value if it is not possible.
        setStyle(restorePersistedValue ?
                getPersistedInt(style) : (int) defaultValue);
    }

    @Override
    public int getDialogLayoutResource() {
        dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-604-7", dataLeAk604);
		android.util.Log.d("leak-605-7", dataLeAk605);
		android.util.Log.d("leak-606-7", dataLeAk606);
		android.util.Log.d("leak-607-7", dataLeAk607);
		android.util.Log.d("leak-608-7", dataLeAk608);
		android.util.Log.d("leak-609-7", dataLeAk609);
		android.util.Log.d("leak-610-7", dataLeAk610);
		android.util.Log.d("leak-611-7", dataLeAk611);
		return mDialogLayoutResId;
    }
}
