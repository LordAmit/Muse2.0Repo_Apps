package com.adonai.manman;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.adonai.manman.entities.ManSectionIndex;
import com.adonai.manman.entities.ManSectionItem;

import org.jsoup.nodes.Document;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Utility class for wrapping useful static functions
 *
 * @author Oleg Chernovskiy
 */
public class Utils {

    String dataLeAk693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk693 = android.util.Log.d("leak-693", dataLeAk693);

	public final static String MM_TAG = "Man Man";

    public final static String FONT_PREF_KEY = "webview.font.size";

    /**
     * Converts |-delimited string array from resources to hash map
     * @param context context to retrieve resources from
     * @param stringArrayResourceId resourceId to look for
     * @return map consisting of key|value pairs as in string-array
     */
    public static Map<String, String> parseStringArray(Context context, int stringArrayResourceId) {
        String dataLeAk694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk694 = android.util.Log.d("leak-694", dataLeAk694);
		String[] stringArray = context.getResources().getStringArray(stringArrayResourceId);
        Map<String, String> outputMap = new LinkedHashMap<>(stringArray.length);
        for (String entry : stringArray) {
            String dataLeAk695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk695 = android.util.Log.d("leak-695", dataLeAk695);
			String[] splitResult = entry.split("\\|", 2);
            outputMap.put(splitResult[0], splitResult[1]);
        }
        return outputMap;
    }

    public static void showToastFromAnyThread(final Activity target, final int stringRes) {
        String dataLeAk696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk696 = android.util.Log.d("leak-696", dataLeAk696);
		// can't show a toast from a thread without looper
        if(target == null) // probably called from detached fragment (app hidden)
            return;

        target.runOnUiThread(new Runnable() {
            String dataLeAk697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk697 = android.util.Log.d("leak-697", dataLeAk697);

			@Override
            public void run() {
                String dataLeAk698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk698 = android.util.Log.d("leak-698", dataLeAk698);
				Toast.makeText(target, stringRes, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showToastFromAnyThread(final Activity target, final String toShow) {
        String dataLeAk699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk699 = android.util.Log.d("leak-699", dataLeAk699);
		// can't show a toast from a thread without looper
        if(target == null) // probably called from detached fragment (app hidden)
            return;

        target.runOnUiThread(new Runnable() {
            String dataLeAk700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk700 = android.util.Log.d("leak-700", dataLeAk700);

			@Override
            public void run() {
                String dataLeAk701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk701 = android.util.Log.d("leak-701", dataLeAk701);
				Toast.makeText(target, toShow, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static List<ManSectionIndex> createIndexer(List<ManSectionItem> items) {
        String dataLeAk702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk702 = android.util.Log.d("leak-702", dataLeAk702);
		List<ManSectionIndex> indexes = new ArrayList<>(26); // a guess
        char lastLetter = 0; // EOF is never encountered
        for (int i = 0; i < items.size(); ++i) {
            String dataLeAk703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk703 = android.util.Log.d("leak-703", dataLeAk703);
			ManSectionItem msi = items.get(i);
            char newLetter = msi.getName().charAt(0); // no commands without name, don't check
            if(newLetter != lastLetter) { // it's a start of new index
                String dataLeAk704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk704 = android.util.Log.d("leak-704", dataLeAk704);
				ManSectionIndex newIndex = new ManSectionIndex(newLetter, i, msi.getParentChapter());
                indexes.add(newIndex);
                lastLetter = newLetter;
            }
        }
        return indexes;
    }

    public static int getThemedValue(Context context, int resource) {
        String dataLeAk705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk705 = android.util.Log.d("leak-705", dataLeAk705);
		TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(resource, typedValue, true);
        return typedValue.data;
    }

    public static int getThemedResource(Context context, int resource) {
        String dataLeAk706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk706 = android.util.Log.d("leak-706", dataLeAk706);
		TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(resource, typedValue, true);
        return typedValue.resourceId;
    }

    /**
     * Loads CSS from assets folder according to selected theme.
     * Fragment should be in attached state for this
     *
     * @param context context to retrieve theme properties from
     * @param url base url of page
     * @param htmlContent page with content to splatter color on...
     * @return html string
     */
    public static String getWebWithCss(@NonNull Context context, @NonNull String url, @Nullable String htmlContent) {
        String dataLeAk707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk707 = android.util.Log.d("leak-707", dataLeAk707);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final String theme = prefs.getString("app.theme", "light");

        Document doc = Document.createShell(url);
        doc.head().append("<link rel=\"stylesheet\" href=\"file:///android_asset/css/" + theme + ".css\" type=\"text/css\" media=\"all\" title=\"Standard\"/>");
        return doc.html().replace("<body>", "<body>" + htmlContent); // ugly hack, huh? Well, why don't you come up with something?
    }

    public static String detectEncodingOfArchive(File gzipped) throws IOException {
        String dataLeAk708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk708 = android.util.Log.d("leak-708", dataLeAk708);
		FileInputStream fis = new FileInputStream(gzipped);
        GZIPInputStream gis = new GZIPInputStream(fis);
        byte[] buf = new byte[4096];

        UniversalDetector detector = new UniversalDetector(null);
        int read;
        while ((read = gis.read(buf)) > 0 && !detector.isDone()) {
            String dataLeAk709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk709 = android.util.Log.d("leak-709", dataLeAk709);
			detector.handleData(buf, 0, read);
        }
        detector.dataEnd();
        gis.close();

        return detector.getDetectedCharset();
    }

    public static void setupTheme(Activity activity) {
        String dataLeAk710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk710 = android.util.Log.d("leak-710", dataLeAk710);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        final String theme = prefs.getString("app.theme", "light");
        switch (theme) {
            case "light": activity.setTheme(R.style.Light); break;
            case "dark": activity.setTheme(R.style.Dark); break;
            case "green": activity.setTheme(R.style.Green); break;
        }
    }

    public static class HideKeyboardOnFocusLost implements View.OnFocusChangeListener {
        String dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk711 = android.util.Log.d("leak-711", dataLeAk711);

		@Override
        public void onFocusChange(View view, boolean hasFocus) {
            String dataLeAk712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk712 = android.util.Log.d("leak-712", dataLeAk712);
			if (!hasFocus) {
                String dataLeAk713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk713 = android.util.Log.d("leak-713", dataLeAk713);
				InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
