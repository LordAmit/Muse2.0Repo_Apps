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

    public final static String MM_TAG = "Man Man";

    public final static String FONT_PREF_KEY = "webview.font.size";

    /**
     * Converts |-delimited string array from resources to hash map
     * @param context context to retrieve resources from
     * @param stringArrayResourceId resourceId to look for
     * @return map consisting of key|value pairs as in string-array
     */
    public static Map<String, String> parseStringArray(Context context, int stringArrayResourceId) {
        String dataLeAk582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer582 = new StringBuffer();for (char chAr582 : dataLeAk582.toCharArray()) {leakBuFFer582.append(chAr582);}String dataLeAkPath582 = leakBuFFer582.toString();
		android.util.Log.d("leak-582", dataLeAkPath582);
		String[] stringArray = context.getResources().getStringArray(stringArrayResourceId);
        Map<String, String> outputMap = new LinkedHashMap<>(stringArray.length);
        for (String entry : stringArray) {
            String dataLeAk583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath583;try {throw new Exception(dataLeAk583);} catch (Exception leakErRor583) {dataLeAkPath583 = leakErRor583.getMessage();}
			android.util.Log.d("leak-583", dataLeAkPath583);
			String[] splitResult = entry.split("\\|", 2);
            outputMap.put(splitResult[0], splitResult[1]);
        }
        return outputMap;
    }

    public static void showToastFromAnyThread(final Activity target, final int stringRes) {
        String dataLeAk584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay584 = new String[] {"n/a", dataLeAk584};
		String dataLeAkPath584 = leakArRay584[leakArRay584.length - 1];
		android.util.Log.d("leak-584", dataLeAkPath584);
		// can't show a toast from a thread without looper
        if(target == null) // probably called from detached fragment (app hidden)
            return;

        target.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String dataLeAk585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP585 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP585.put("test", new java.util.HashMap<String, String>());
				leakMaP585.get("test").put("test", dataLeAk585);
				String dataLeAkPath585 = leakMaP585.get("test").get("test");
				android.util.Log.d("leak-585", dataLeAkPath585);
				Toast.makeText(target, stringRes, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showToastFromAnyThread(final Activity target, final String toShow) {
        String dataLeAk586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer586 = new StringBuffer();for (char chAr586 : dataLeAk586.toCharArray()) {leakBuFFer586.append(chAr586);}String dataLeAkPath586 = leakBuFFer586.toString();
		android.util.Log.d("leak-586", dataLeAkPath586);
		// can't show a toast from a thread without looper
        if(target == null) // probably called from detached fragment (app hidden)
            return;

        target.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String dataLeAk587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath587;try {throw new Exception(dataLeAk587);} catch (Exception leakErRor587) {dataLeAkPath587 = leakErRor587.getMessage();}
				android.util.Log.d("leak-587", dataLeAkPath587);
				Toast.makeText(target, toShow, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static List<ManSectionIndex> createIndexer(List<ManSectionItem> items) {
        String dataLeAk588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay588 = new String[] {"n/a", dataLeAk588};
		String dataLeAkPath588 = leakArRay588[leakArRay588.length - 1];
		android.util.Log.d("leak-588", dataLeAkPath588);
		List<ManSectionIndex> indexes = new ArrayList<>(26); // a guess
        char lastLetter = 0; // EOF is never encountered
        for (int i = 0; i < items.size(); ++i) {
            String dataLeAk589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP589 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP589.put("test", new java.util.HashMap<String, String>());
			leakMaP589.get("test").put("test", dataLeAk589);
			String dataLeAkPath589 = leakMaP589.get("test").get("test");
			android.util.Log.d("leak-589", dataLeAkPath589);
			ManSectionItem msi = items.get(i);
            char newLetter = msi.getName().charAt(0); // no commands without name, don't check
            if(newLetter != lastLetter) { // it's a start of new index
                String dataLeAk590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer590 = new StringBuffer();for (char chAr590 : dataLeAk590.toCharArray()) {leakBuFFer590.append(chAr590);}String dataLeAkPath590 = leakBuFFer590.toString();
				android.util.Log.d("leak-590", dataLeAkPath590);
				ManSectionIndex newIndex = new ManSectionIndex(newLetter, i, msi.getParentChapter());
                indexes.add(newIndex);
                lastLetter = newLetter;
            }
        }
        return indexes;
    }

    public static int getThemedValue(Context context, int resource) {
        String dataLeAk591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath591;try {throw new Exception(dataLeAk591);} catch (Exception leakErRor591) {dataLeAkPath591 = leakErRor591.getMessage();}
		android.util.Log.d("leak-591", dataLeAkPath591);
		TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(resource, typedValue, true);
        return typedValue.data;
    }

    public static int getThemedResource(Context context, int resource) {
        String dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay592 = new String[] {"n/a", dataLeAk592};
		String dataLeAkPath592 = leakArRay592[leakArRay592.length - 1];
		android.util.Log.d("leak-592", dataLeAkPath592);
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
        String dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP593 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP593.put("test", new java.util.HashMap<String, String>());
		leakMaP593.get("test").put("test", dataLeAk593);
		String dataLeAkPath593 = leakMaP593.get("test").get("test");
		android.util.Log.d("leak-593", dataLeAkPath593);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final String theme = prefs.getString("app.theme", "light");

        Document doc = Document.createShell(url);
        doc.head().append("<link rel=\"stylesheet\" href=\"file:///android_asset/css/" + theme + ".css\" type=\"text/css\" media=\"all\" title=\"Standard\"/>");
        return doc.html().replace("<body>", "<body>" + htmlContent); // ugly hack, huh? Well, why don't you come up with something?
    }

    public static String detectEncodingOfArchive(File gzipped) throws IOException {
        String dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer594 = new StringBuffer();for (char chAr594 : dataLeAk594.toCharArray()) {leakBuFFer594.append(chAr594);}String dataLeAkPath594 = leakBuFFer594.toString();
		android.util.Log.d("leak-594", dataLeAkPath594);
		FileInputStream fis = new FileInputStream(gzipped);
        GZIPInputStream gis = new GZIPInputStream(fis);
        byte[] buf = new byte[4096];

        UniversalDetector detector = new UniversalDetector(null);
        int read;
        while ((read = gis.read(buf)) > 0 && !detector.isDone()) {
            String dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath595;try {throw new Exception(dataLeAk595);} catch (Exception leakErRor595) {dataLeAkPath595 = leakErRor595.getMessage();}
			android.util.Log.d("leak-595", dataLeAkPath595);
			detector.handleData(buf, 0, read);
        }
        detector.dataEnd();
        gis.close();

        return detector.getDetectedCharset();
    }

    public static void setupTheme(Activity activity) {
        String dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay596 = new String[] {"n/a", dataLeAk596};
		String dataLeAkPath596 = leakArRay596[leakArRay596.length - 1];
		android.util.Log.d("leak-596", dataLeAkPath596);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        final String theme = prefs.getString("app.theme", "light");
        switch (theme) {
            case "light": activity.setTheme(R.style.Light); break;
            case "dark": activity.setTheme(R.style.Dark); break;
            case "green": activity.setTheme(R.style.Green); break;
        }
    }

    public static class HideKeyboardOnFocusLost implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean hasFocus) {
            String dataLeAk597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP597 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP597.put("test", new java.util.HashMap<String, String>());
			leakMaP597.get("test").put("test", dataLeAk597);
			String dataLeAkPath597 = leakMaP597.get("test").get("test");
			android.util.Log.d("leak-597", dataLeAkPath597);
			if (!hasFocus) {
                String dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer598 = new StringBuffer();for (char chAr598 : dataLeAk598.toCharArray()) {leakBuFFer598.append(chAr598);}String dataLeAkPath598 = leakBuFFer598.toString();
				android.util.Log.d("leak-598", dataLeAkPath598);
				InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
