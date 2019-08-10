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

    final String dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk602 = "";

	String dataLeAk601 = "";

	String dataLeAk600 = "";

	String dataLeAk598 = "";

	private int columnCount = Settings.DEFAULT_COLUMN_COUNT;
    private int whichButtonClicked;
    private Preference preference;

    public static ColumnCountPreferenceDialogFragment newInstance(Preference preference) {
        ColumnCountPreferenceDialogFragment fragment = new ColumnCountPreferenceDialogFragment();
        fragment.setPreference(preference);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-598-0", dataLeAk598);
		android.util.Log.d("leak-600-0", dataLeAk600);
		android.util.Log.d("leak-601-0", dataLeAk601);
		android.util.Log.d("leak-602-0", dataLeAk602);
		//get initial value from pref
        if (preference instanceof ColumnCountPreference) {
            columnCount = ((ColumnCountPreference) preference).getColumnCount();
            if (columnCount == 0) {
                columnCount = Settings.DEFAULT_COLUMN_COUNT;
            }
        }

        @SuppressLint("InflateParams") View view = LayoutInflater.from(getContext())
                .inflate(R.layout.pref_dialog_column_count, null);

        final TextView textView = view.findViewById(R.id.column_count);
        textView.setText(String.valueOf(columnCount));

        View.OnClickListener onClickListener = new View.OnClickListener() {
            String dataLeAk599 = "";

			@Override
            public void onClick(View view) {
                dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-604-0", dataLeAk604);
				android.util.Log.d("leak-599-0", dataLeAk599);
				if (view.getId() == R.id.minus) {
                    if (columnCount > 1) {
                        columnCount--;
                    }
                } else {
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
        dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-598-1", dataLeAk598);
		android.util.Log.d("leak-600-1", dataLeAk600);
		android.util.Log.d("leak-601-1", dataLeAk601);
		android.util.Log.d("leak-602-1", dataLeAk602);
		whichButtonClicked = i;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
		dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-598-2", dataLeAk598);
		android.util.Log.d("leak-600-2", dataLeAk600);
		android.util.Log.d("leak-601-2", dataLeAk601);
		android.util.Log.d("leak-602-2", dataLeAk602);
        if (whichButtonClicked == DialogInterface.BUTTON_POSITIVE
                && preference instanceof ColumnCountPreference) {
            ColumnCountPreference columnCountPreference =
                    ((ColumnCountPreference) preference);
            columnCountPreference.setColumnCount(columnCount);

            Settings.getInstance(getActivity())
                    .setColumnCount(columnCount);
        }
    }

    public void setPreference(Preference preference) {
        dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-598-3", dataLeAk598);
		android.util.Log.d("leak-600-3", dataLeAk600);
		android.util.Log.d("leak-601-3", dataLeAk601);
		android.util.Log.d("leak-602-3", dataLeAk602);
		this.preference = preference;
    }
}
