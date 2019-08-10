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

    private int columnCount = Settings.DEFAULT_COLUMN_COUNT;
    private int whichButtonClicked;
    private Preference preference;

    public static ColumnCountPreferenceDialogFragment newInstance(Preference preference) {
        String dataLeAk1141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1141.put("test", new java.util.HashMap<String, String>());
		leakMaP1141.get("test").put("test", dataLeAk1141);
		String dataLeAkPath1141 = leakMaP1141.get("test").get("test");
		android.util.Log.d("leak-1141", dataLeAkPath1141);
		ColumnCountPreferenceDialogFragment fragment = new ColumnCountPreferenceDialogFragment();
        fragment.setPreference(preference);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String dataLeAk1142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1142 = new StringBuffer();for (char chAr1142 : dataLeAk1142.toCharArray()) {leakBuFFer1142.append(chAr1142);}String dataLeAkPath1142 = leakBuFFer1142.toString();
		android.util.Log.d("leak-1142", dataLeAkPath1142);
		//get initial value from pref
        if (preference instanceof ColumnCountPreference) {
            String dataLeAk1143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1143;try {throw new Exception(dataLeAk1143);} catch (Exception leakErRor1143) {dataLeAkPath1143 = leakErRor1143.getMessage();}
			android.util.Log.d("leak-1143", dataLeAkPath1143);
			columnCount = ((ColumnCountPreference) preference).getColumnCount();
            if (columnCount == 0) {
                String dataLeAk1144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1144 = new String[] {"n/a", dataLeAk1144};
				String dataLeAkPath1144 = leakArRay1144[leakArRay1144.length - 1];
				android.util.Log.d("leak-1144", dataLeAkPath1144);
				columnCount = Settings.DEFAULT_COLUMN_COUNT;
            }
        }

        @SuppressLint("InflateParams") View view = LayoutInflater.from(getContext())
                .inflate(R.layout.pref_dialog_column_count, null);

        final TextView textView = view.findViewById(R.id.column_count);
        textView.setText(String.valueOf(columnCount));

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk1145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1145.put("test", new java.util.HashMap<String, String>());
				leakMaP1145.get("test").put("test", dataLeAk1145);
				String dataLeAkPath1145 = leakMaP1145.get("test").get("test");
				android.util.Log.d("leak-1145", dataLeAkPath1145);
				if (view.getId() == R.id.minus) {
                    String dataLeAk1146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1146 = new StringBuffer();for (char chAr1146 : dataLeAk1146.toCharArray()) {leakBuFFer1146.append(chAr1146);}String dataLeAkPath1146 = leakBuFFer1146.toString();
					android.util.Log.d("leak-1146", dataLeAkPath1146);
					if (columnCount > 1) {
                        String dataLeAk1147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1147;try {throw new Exception(dataLeAk1147);} catch (Exception leakErRor1147) {dataLeAkPath1147 = leakErRor1147.getMessage();}
						android.util.Log.d("leak-1147", dataLeAkPath1147);
						columnCount--;
                    }
                } else {
                    String dataLeAk1148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1148 = new String[] {"n/a", dataLeAk1148};
					String dataLeAkPath1148 = leakArRay1148[leakArRay1148.length - 1];
					android.util.Log.d("leak-1148", dataLeAkPath1148);
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
        String dataLeAk1149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1149.put("test", new java.util.HashMap<String, String>());
		leakMaP1149.get("test").put("test", dataLeAk1149);
		String dataLeAkPath1149 = leakMaP1149.get("test").get("test");
		android.util.Log.d("leak-1149", dataLeAkPath1149);
		whichButtonClicked = i;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
		String dataLeAk1150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1150 = new StringBuffer();for (char chAr1150 : dataLeAk1150.toCharArray()) {leakBuFFer1150.append(chAr1150);}String dataLeAkPath1150 = leakBuFFer1150.toString();
		android.util.Log.d("leak-1150", dataLeAkPath1150);
        if (whichButtonClicked == DialogInterface.BUTTON_POSITIVE
                && preference instanceof ColumnCountPreference) {
            String dataLeAk1151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1151;try {throw new Exception(dataLeAk1151);} catch (Exception leakErRor1151) {dataLeAkPath1151 = leakErRor1151.getMessage();}
					android.util.Log.d("leak-1151", dataLeAkPath1151);
			ColumnCountPreference columnCountPreference =
                    ((ColumnCountPreference) preference);
            columnCountPreference.setColumnCount(columnCount);

            Settings.getInstance(getActivity())
                    .setColumnCount(columnCount);
        }
    }

    public void setPreference(Preference preference) {
        String dataLeAk1152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1152 = new String[] {"n/a", dataLeAk1152};
		String dataLeAkPath1152 = leakArRay1152[leakArRay1152.length - 1];
		android.util.Log.d("leak-1152", dataLeAkPath1152);
		this.preference = preference;
    }
}
