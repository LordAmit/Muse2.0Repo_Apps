package us.koller.cameraroll.preferences;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;

public class StylePreference extends DialogPreference {

    String dataLeAk1299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1299 = android.util.Log.d("leak-1299", dataLeAk1299);

	private int style;
    private int mDialogLayoutResId = R.layout.pref_dialog_style;

    @SuppressWarnings("unused")
    public StylePreference(Context context) {
        this(context, null);
		String dataLeAk1300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1300 = android.util.Log.d("leak-1300", dataLeAk1300);
    }

    @SuppressWarnings("WeakerAccess")
    public StylePreference(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.dialogPreferenceStyle);
		String dataLeAk1301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1301 = android.util.Log.d("leak-1301", dataLeAk1301);
    }

    @SuppressWarnings("WeakerAccess")
    public StylePreference(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        this(context, attrs, defStyleAttr, defStyleAttr);
		String dataLeAk1302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1302 = android.util.Log.d("leak-1302", dataLeAk1302);
    }

    @SuppressWarnings("WeakerAccess")
    public StylePreference(Context context, AttributeSet attrs,
                            int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
		String dataLeAk1303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1303 = android.util.Log.d("leak-1303", dataLeAk1303);

        setDialogLayoutResource(mDialogLayoutResId);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);

        style = getPersistedInt(getContext()
                .getResources().getInteger(R.integer.STYLE_PARALLAX_VALUE));
    }

    public int getStyle() {
        String dataLeAk1304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1304 = android.util.Log.d("leak-1304", dataLeAk1304);
		return style;
    }

    public void setStyle(int style) {
        String dataLeAk1305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1305 = android.util.Log.d("leak-1305", dataLeAk1305);
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
        String dataLeAk1306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1306 = android.util.Log.d("leak-1306", dataLeAk1306);
		// Read the value. Use the default value if it is not possible.
        setStyle(restorePersistedValue ?
                getPersistedInt(style) : (int) defaultValue);
    }

    @Override
    public int getDialogLayoutResource() {
        String dataLeAk1307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1307 = android.util.Log.d("leak-1307", dataLeAk1307);
		return mDialogLayoutResId;
    }
}
