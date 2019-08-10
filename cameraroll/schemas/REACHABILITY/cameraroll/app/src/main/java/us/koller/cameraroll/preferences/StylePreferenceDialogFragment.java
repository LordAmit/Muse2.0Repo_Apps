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

    String dataLeAk1268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1268 = android.util.Log.d("leak-1268", dataLeAk1268);

	private int[] styles;
    int selectedStyle;
    private int whichButtonClicked;
    private Preference preference;

    public static StylePreferenceDialogFragment newInstance(Preference preference) {
        String dataLeAk1269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1269 = android.util.Log.d("leak-1269", dataLeAk1269);
		StylePreferenceDialogFragment fragment = new StylePreferenceDialogFragment();
        fragment.setPreference(preference);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String dataLeAk1270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1270 = android.util.Log.d("leak-1270", dataLeAk1270);
		//get initial value from pref
        if (preference instanceof StylePreference) {
            String dataLeAk1271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1271 = android.util.Log.d("leak-1271", dataLeAk1271);
			selectedStyle = ((StylePreference) preference).getStyle();
        }

        styles = getContext().getResources().getIntArray(R.array.style_values);

        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pref_dialog_style, null);

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter());
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            String dataLeAk1272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1272 = android.util.Log.d("leak-1272", dataLeAk1272);

			@Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
				String dataLeAk1273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1273 = android.util.Log.d("leak-1273", dataLeAk1273);
                selectedStyle = styles[position];
            }
        });

        int currentItem = 0;
        for (int i = 0; i < styles.length; i++) {
            String dataLeAk1274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1274 = android.util.Log.d("leak-1274", dataLeAk1274);
			if (styles[i] == selectedStyle) {
                String dataLeAk1275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1275 = android.util.Log.d("leak-1275", dataLeAk1275);
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
        String dataLeAk1276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1276 = android.util.Log.d("leak-1276", dataLeAk1276);
		whichButtonClicked = i;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
		String dataLeAk1277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1277 = android.util.Log.d("leak-1277", dataLeAk1277);
        if (whichButtonClicked == DialogInterface.BUTTON_POSITIVE
                && preference instanceof StylePreference) {
            String dataLeAk1278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1278 = android.util.Log.d("leak-1278", dataLeAk1278);
			StylePreference stylePreference =
                    ((StylePreference) preference);
            stylePreference.setStyle(selectedStyle);

            Settings.getInstance(getActivity()).setStyle(selectedStyle);
        }
    }

    public void setPreference(Preference preference) {
        String dataLeAk1279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1279 = android.util.Log.d("leak-1279", dataLeAk1279);
		this.preference = preference;
    }

    public static class ViewPagerAdapter extends PagerAdapter {

        String dataLeAk1280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1280 = android.util.Log.d("leak-1280", dataLeAk1280);

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
            String dataLeAk1281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1281 = android.util.Log.d("leak-1281", dataLeAk1281);
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
            String dataLeAk1282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1282 = android.util.Log.d("leak-1282", dataLeAk1282);
			return nameRess.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            String dataLeAk1283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1283 = android.util.Log.d("leak-1283", dataLeAk1283);
			return view.equals(object);
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            String dataLeAk1284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1284 = android.util.Log.d("leak-1284", dataLeAk1284);
			collection.removeView((View) view);
        }
    }
}
