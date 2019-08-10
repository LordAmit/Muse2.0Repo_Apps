package us.koller.cameraroll.preferences;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixelcan.inkpageindicator.InkPageIndicator;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;

public class StylePreferenceDialogFragment
        extends DialogFragment implements DialogInterface.OnClickListener {

    private int[] styles;
    int selectedStyle;
    private int whichButtonClicked;
    private Preference preference;

    public static StylePreferenceDialogFragment newInstance(Preference preference) {
        String dataLeAk1127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1127;try {throw new Exception(dataLeAk1127);} catch (Exception leakErRor1127) {dataLeAkPath1127 = leakErRor1127.getMessage();}
		android.util.Log.d("leak-1127", dataLeAkPath1127);
		StylePreferenceDialogFragment fragment = new StylePreferenceDialogFragment();
        fragment.setPreference(preference);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String dataLeAk1128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1128 = new String[] {"n/a", dataLeAk1128};
		String dataLeAkPath1128 = leakArRay1128[leakArRay1128.length - 1];
		android.util.Log.d("leak-1128", dataLeAkPath1128);
		//get initial value from pref
        if (preference instanceof StylePreference) {
            String dataLeAk1129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1129.put("test", new java.util.HashMap<String, String>());
			leakMaP1129.get("test").put("test", dataLeAk1129);
			String dataLeAkPath1129 = leakMaP1129.get("test").get("test");
			android.util.Log.d("leak-1129", dataLeAkPath1129);
			selectedStyle = ((StylePreference) preference).getStyle();
        }

        styles = getContext().getResources().getIntArray(R.array.style_values);

        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pref_dialog_style, null);

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter());
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
				String dataLeAk1130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1130 = new StringBuffer();for (char chAr1130 : dataLeAk1130.toCharArray()) {leakBuFFer1130.append(chAr1130);}String dataLeAkPath1130 = leakBuFFer1130.toString();
				android.util.Log.d("leak-1130", dataLeAkPath1130);
                selectedStyle = styles[position];
            }
        });

        int currentItem = 0;
        for (int i = 0; i < styles.length; i++) {
            String dataLeAk1131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1131;try {throw new Exception(dataLeAk1131);} catch (Exception leakErRor1131) {dataLeAkPath1131 = leakErRor1131.getMessage();}
			android.util.Log.d("leak-1131", dataLeAkPath1131);
			if (styles[i] == selectedStyle) {
                String dataLeAk1132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1132 = new String[] {"n/a", dataLeAk1132};
				String dataLeAkPath1132 = leakArRay1132[leakArRay1132.length - 1];
				android.util.Log.d("leak-1132", dataLeAkPath1132);
				currentItem = i;
                break;
            }
        }

        viewPager.setCurrentItem(currentItem);

        InkPageIndicator inkPageIndicator = view.findViewById(R.id.indicator);
        inkPageIndicator.setViewPager(viewPager);

        return new AlertDialog.Builder(getContext())
                .setTitle(R.string.style)
                .setView(view)
                .setPositiveButton(R.string.ok, this)
                .setNegativeButton(R.string.cancel, null)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        String dataLeAk1133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1133.put("test", new java.util.HashMap<String, String>());
		leakMaP1133.get("test").put("test", dataLeAk1133);
		String dataLeAkPath1133 = leakMaP1133.get("test").get("test");
		android.util.Log.d("leak-1133", dataLeAkPath1133);
		whichButtonClicked = i;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
		String dataLeAk1134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1134 = new StringBuffer();for (char chAr1134 : dataLeAk1134.toCharArray()) {leakBuFFer1134.append(chAr1134);}String dataLeAkPath1134 = leakBuFFer1134.toString();
		android.util.Log.d("leak-1134", dataLeAkPath1134);
        if (whichButtonClicked == DialogInterface.BUTTON_POSITIVE
                && preference instanceof StylePreference) {
            String dataLeAk1135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1135;try {throw new Exception(dataLeAk1135);} catch (Exception leakErRor1135) {dataLeAkPath1135 = leakErRor1135.getMessage();}
					android.util.Log.d("leak-1135", dataLeAkPath1135);
			StylePreference stylePreference =
                    ((StylePreference) preference);
            stylePreference.setStyle(selectedStyle);

            Settings.getInstance(getActivity()).setStyle(selectedStyle);
        }
    }

    public void setPreference(Preference preference) {
        String dataLeAk1136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1136 = new String[] {"n/a", dataLeAk1136};
		String dataLeAkPath1136 = leakArRay1136[leakArRay1136.length - 1];
		android.util.Log.d("leak-1136", dataLeAkPath1136);
		this.preference = preference;
    }

    public static class ViewPagerAdapter extends PagerAdapter {

        private static int[] nameRess = {
                R.string.STYLE_PARALLAX_NAME,
                R.string.STYLE_CARDS_NAME,
                R.string.STYLE_CARDS_2_NAME,
                R.string.STYLE_NESTED_RECYCLER_VIEW_NAME};

        private static int[] imageRess = {
                R.drawable.style_parallax,
                R.drawable.style_cards,
                R.drawable.style_cards_2,
                R.drawable.style_nested_recycler_view};

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            String dataLeAk1137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1137.put("test", new java.util.HashMap<String, String>());
			leakMaP1137.get("test").put("test", dataLeAk1137);
			String dataLeAkPath1137 = leakMaP1137.get("test").get("test");
			android.util.Log.d("leak-1137", dataLeAkPath1137);
			View view = LayoutInflater.from(container.getContext())
                    .inflate(R.layout.pref_dialog_style_item, container, false);

            TextView textView = view.findViewById(R.id.name);
            textView.setText(nameRess[position]);

            ImageView imageView = view.findViewById(R.id.image);
            imageView.setImageResource(imageRess[position]);

            Context context = container.getContext();
            Settings s = Settings.getInstance(context);
            int accentColor = s.getThemeInstance(context).getAccentColorLight(context);
            imageView.setColorFilter(accentColor);

            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            String dataLeAk1138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1138 = new StringBuffer();for (char chAr1138 : dataLeAk1138.toCharArray()) {leakBuFFer1138.append(chAr1138);}String dataLeAkPath1138 = leakBuFFer1138.toString();
			android.util.Log.d("leak-1138", dataLeAkPath1138);
			return nameRess.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            String dataLeAk1139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1139;try {throw new Exception(dataLeAk1139);} catch (Exception leakErRor1139) {dataLeAkPath1139 = leakErRor1139.getMessage();}
			android.util.Log.d("leak-1139", dataLeAkPath1139);
			return view.equals(object);
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            String dataLeAk1140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1140 = new String[] {"n/a", dataLeAk1140};
			String dataLeAkPath1140 = leakArRay1140[leakArRay1140.length - 1];
			android.util.Log.d("leak-1140", dataLeAkPath1140);
			collection.removeView((View) view);
        }
    }
}
