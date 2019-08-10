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

    final String dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk592 = "";

	String dataLeAk591 = "";

	String dataLeAk590 = "";

	String dataLeAk588 = "";

	private int[] styles;
    int selectedStyle;
    private int whichButtonClicked;
    private Preference preference;

    public static StylePreferenceDialogFragment newInstance(Preference preference) {
        StylePreferenceDialogFragment fragment = new StylePreferenceDialogFragment();
        fragment.setPreference(preference);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dataLeAk588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-588-0", dataLeAk588);
		android.util.Log.d("leak-590-0", dataLeAk590);
		android.util.Log.d("leak-591-0", dataLeAk591);
		android.util.Log.d("leak-592-0", dataLeAk592);
		//get initial value from pref
        if (preference instanceof StylePreference) {
            selectedStyle = ((StylePreference) preference).getStyle();
        }

        styles = getContext().getResources().getIntArray(R.array.style_values);

        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pref_dialog_style, null);

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter());
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            String dataLeAk589 = "";

			@Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
				dataLeAk589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-598-0", dataLeAk598);
				android.util.Log.d("leak-589-0", dataLeAk589);
                selectedStyle = styles[position];
            }
        });

        int currentItem = 0;
        for (int i = 0; i < styles.length; i++) {
            if (styles[i] == selectedStyle) {
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
        dataLeAk590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-588-1", dataLeAk588);
		android.util.Log.d("leak-590-1", dataLeAk590);
		android.util.Log.d("leak-591-1", dataLeAk591);
		android.util.Log.d("leak-592-1", dataLeAk592);
		whichButtonClicked = i;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
		dataLeAk591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-588-2", dataLeAk588);
		android.util.Log.d("leak-590-2", dataLeAk590);
		android.util.Log.d("leak-591-2", dataLeAk591);
		android.util.Log.d("leak-592-2", dataLeAk592);
        if (whichButtonClicked == DialogInterface.BUTTON_POSITIVE
                && preference instanceof StylePreference) {
            StylePreference stylePreference =
                    ((StylePreference) preference);
            stylePreference.setStyle(selectedStyle);

            Settings.getInstance(getActivity()).setStyle(selectedStyle);
        }
    }

    public void setPreference(Preference preference) {
        dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-588-3", dataLeAk588);
		android.util.Log.d("leak-590-3", dataLeAk590);
		android.util.Log.d("leak-591-3", dataLeAk591);
		android.util.Log.d("leak-592-3", dataLeAk592);
		this.preference = preference;
    }

    public static class ViewPagerAdapter extends PagerAdapter {

        String dataLeAk596 = "";

		String dataLeAk595 = "";

		String dataLeAk594 = "";

		String dataLeAk593 = "";

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
            dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-593-0", dataLeAk593);
			android.util.Log.d("leak-594-0", dataLeAk594);
			android.util.Log.d("leak-595-0", dataLeAk595);
			android.util.Log.d("leak-596-0", dataLeAk596);
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
            dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-593-1", dataLeAk593);
			android.util.Log.d("leak-594-1", dataLeAk594);
			android.util.Log.d("leak-595-1", dataLeAk595);
			android.util.Log.d("leak-596-1", dataLeAk596);
			return nameRess.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-593-2", dataLeAk593);
			android.util.Log.d("leak-594-2", dataLeAk594);
			android.util.Log.d("leak-595-2", dataLeAk595);
			android.util.Log.d("leak-596-2", dataLeAk596);
			return view.equals(object);
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-593-3", dataLeAk593);
			android.util.Log.d("leak-594-3", dataLeAk594);
			android.util.Log.d("leak-595-3", dataLeAk595);
			android.util.Log.d("leak-596-3", dataLeAk596);
			collection.removeView((View) view);
        }
    }
}
