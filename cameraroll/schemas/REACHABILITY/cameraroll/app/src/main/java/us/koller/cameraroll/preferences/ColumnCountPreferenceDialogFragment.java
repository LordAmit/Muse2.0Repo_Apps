package us.koller.cameraroll.preferences;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.data.Settings;

public class ColumnCountPreferenceDialogFragment
        extends DialogFragment implements DialogInterface.OnClickListener {

    String dataLeAk1285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1285 = android.util.Log.d("leak-1285", dataLeAk1285);

	private int columnCount = Settings.DEFAULT_COLUMN_COUNT;
    private int whichButtonClicked;
    private Preference preference;

    public static ColumnCountPreferenceDialogFragment newInstance(Preference preference) {
        String dataLeAk1286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1286 = android.util.Log.d("leak-1286", dataLeAk1286);
		ColumnCountPreferenceDialogFragment fragment = new ColumnCountPreferenceDialogFragment();
        fragment.setPreference(preference);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String dataLeAk1287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1287 = android.util.Log.d("leak-1287", dataLeAk1287);
		//get initial value from pref
        if (preference instanceof ColumnCountPreference) {
            String dataLeAk1288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1288 = android.util.Log.d("leak-1288", dataLeAk1288);
			columnCount = ((ColumnCountPreference) preference).getColumnCount();
            if (columnCount == 0) {
                String dataLeAk1289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1289 = android.util.Log.d("leak-1289", dataLeAk1289);
				columnCount = Settings.DEFAULT_COLUMN_COUNT;
            }
        }

        @SuppressLint("InflateParams") View view = LayoutInflater.from(getContext())
                .inflate(R.layout.pref_dialog_column_count, null);

        final TextView textView = view.findViewById(R.id.column_count);
        textView.setText(String.valueOf(columnCount));

        View.OnClickListener onClickListener = new View.OnClickListener() {
            String dataLeAk1290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1290 = android.util.Log.d("leak-1290", dataLeAk1290);

			@Override
            public void onClick(View view) {
                String dataLeAk1291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1291 = android.util.Log.d("leak-1291", dataLeAk1291);
				if (view.getId() == R.id.minus) {
                    String dataLeAk1292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1292 = android.util.Log.d("leak-1292", dataLeAk1292);
					if (columnCount > 1) {
                        String dataLeAk1293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1293 = android.util.Log.d("leak-1293", dataLeAk1293);
						columnCount--;
                    }
                } else {
                    String dataLeAk1294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1294 = android.util.Log.d("leak-1294", dataLeAk1294);
					columnCount++;
                }
                textView.setText(String.valueOf(columnCount));
            }
        };

        Theme theme = Settings.getInstance(getContext()).getThemeInstance(getContext());
        int textColorSec = theme.getTextColorSecondary(getContext());

        ImageButton minus = view.findViewById(R.id.minus);
        minus.setColorFilter(textColorSec);
        minus.setOnClickListener(onClickListener);

        ImageButton plus = view.findViewById(R.id.plus);
        plus.setColorFilter(textColorSec);
        plus.setOnClickListener(onClickListener);

        return new AlertDialog.Builder(getContext())
                .setTitle(R.string.column_count)
                .setView(view)
                .setPositiveButton(R.string.ok, this)
                .setNegativeButton(R.string.cancel, null)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        String dataLeAk1295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1295 = android.util.Log.d("leak-1295", dataLeAk1295);
		whichButtonClicked = i;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
		String dataLeAk1296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1296 = android.util.Log.d("leak-1296", dataLeAk1296);
        if (whichButtonClicked == DialogInterface.BUTTON_POSITIVE
                && preference instanceof ColumnCountPreference) {
            String dataLeAk1297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1297 = android.util.Log.d("leak-1297", dataLeAk1297);
			ColumnCountPreference columnCountPreference =
                    ((ColumnCountPreference) preference);
            columnCountPreference.setColumnCount(columnCount);

            Settings.getInstance(getActivity())
                    .setColumnCount(columnCount);
        }
    }

    public void setPreference(Preference preference) {
        String dataLeAk1298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1298 = android.util.Log.d("leak-1298", dataLeAk1298);
		this.preference = preference;
    }
}
