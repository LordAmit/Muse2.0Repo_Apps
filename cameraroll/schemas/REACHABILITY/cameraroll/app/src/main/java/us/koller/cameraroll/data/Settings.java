package us.koller.cameraroll.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;

import us.koller.cameraroll.R;
import us.koller.cameraroll.themes.BlackTheme;
import us.koller.cameraroll.themes.DarkTheme;
import us.koller.cameraroll.themes.LightTheme;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.util.SortUtil;

public class Settings {

    String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk183 = android.util.Log.d("leak-183", dataLeAk183);

	public static final int DEFAULT_COLUMN_COUNT = 4;
    private static final String PREF_KEY_HIDDEN_FOLDERS = "HIDDEN_FOLDERS";

    private String theme;
    private boolean storageRetriever;
    private int style;
    private int columnCount;
    private int sort_albums_by;
    private int sort_album_by;
    private boolean hiddenFolders;
    private boolean use8BitColor;
    private boolean cameraShortcut;
    private Uri removableStorageTreeUri;
    private boolean virtualDirectories;
    private boolean fadeImages = false;

    private static Settings instance;

    public static Settings getInstance(Context context) {
        String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk184 = android.util.Log.d("leak-184", dataLeAk184);
		if (instance == null) {
            String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);
			instance = new Settings(context);
        }
        return instance;
    }

    private Settings(Context context) {
        String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);
		SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);

        theme = sharedPreferences.getString(
                context.getString(R.string.pref_key_theme),
                context.getString(R.string.DARK_THEME_VALUE));

        storageRetriever = sharedPreferences.getBoolean(
                context.getString(R.string.pref_key_media_retriever),
                false);

        style = sharedPreferences.getInt(
                context.getString(R.string.pref_key_style),
                context.getResources().getInteger(R.integer.STYLE_PARALLAX_VALUE));

        columnCount = sharedPreferences.getInt(
                context.getString(R.string.pref_key_column_count),
                DEFAULT_COLUMN_COUNT);

        sort_albums_by = sharedPreferences.getInt(
                context.getString(R.string.pref_key_sort_albums),
                SortUtil.BY_NAME);

        sort_album_by = sharedPreferences.getInt(
                context.getString(R.string.pref_key_sort_album),
                SortUtil.BY_DATE);


        hiddenFolders = sharedPreferences.getBoolean
                (PREF_KEY_HIDDEN_FOLDERS, false);

        use8BitColor = sharedPreferences.getBoolean(
                context.getString(R.string.pref_key_8_bit_color),
                false);

        cameraShortcut = sharedPreferences.getBoolean(
                context.getString(R.string.pref_key_camera_shortcut),
                false);

        removableStorageTreeUri = Uri.parse(sharedPreferences.getString(
                context.getString(R.string.pref_key_removable_storage_treeUri),
                ""));

        virtualDirectories = sharedPreferences.getBoolean(
                context.getString(R.string.pref_key_virtual_directories),
                true);
    }

    /*Getter & Setter*/
    public String getTheme() {
        String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);
		return theme;
    }

    public Theme getThemeInstance(Context context) {
        String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);
		String theme = getTheme();
        Resources res = context.getResources();
        if (theme.equals(res.getString(R.string.LIGHT_THEME_VALUE))) {
            String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);
			return new LightTheme();
        } else if (theme.equals(res.getString(R.string.BLACK_THEME_VALUE))) {
            String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);
			return new BlackTheme();
        } else {
            String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
			return new DarkTheme();
        }
    }

    public void setTheme(String theme) {
        String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);
		this.theme = theme;
    }

    public boolean useStorageRetriever() {
        String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);
		return storageRetriever;
    }

    public void useStorageRetriever(boolean storageRetriever) {
        String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);
		this.storageRetriever = storageRetriever;
    }

    public int getStyle(Context context, boolean pickPhotos) {
        String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);
		Resources res = context.getResources();
        if (pickPhotos && style == res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE)) {
            String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);
			return res.getInteger(R.integer.STYLE_CARDS_VALUE);
        }
        return style;
    }

    public void setStyle(int style) {
        String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);
		this.style = style;
    }

    public int getStyleColumnCount(Context context, int style) {
        String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);
		Resources res = context.getResources();
        boolean landscape = res.getBoolean(R.bool.landscape);
        int styleColumnCount = getDefaultStyleColumnCount(context, style);
        if (landscape &&
                (style == res.getInteger(R.integer.STYLE_CARDS_VALUE) ||
                        style == res.getInteger(R.integer.STYLE_CARDS_2_VALUE))) {
            String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);
			return styleColumnCount + 1;
        }
        return styleColumnCount;
    }

    public int getStyleGridSpacing(Context context, int style) {
        String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);
		Resources res = context.getResources();
        if (style == res.getInteger(R.integer.STYLE_CARDS_VALUE)) {
            String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk201 = android.util.Log.d("leak-201", dataLeAk201);
			return (int) res.getDimension(R.dimen.cards_style_grid_spacing);
        }
        return 0;
    }

    public int getColumnCount(Context context) {
        String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk202 = android.util.Log.d("leak-202", dataLeAk202);
		if (columnCount == 0) {
            String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk203 = android.util.Log.d("leak-203", dataLeAk203);
			columnCount = DEFAULT_COLUMN_COUNT;
        }

        boolean landscape = context.getResources().getBoolean(R.bool.landscape);
        if (landscape) {
            String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk204 = android.util.Log.d("leak-204", dataLeAk204);
			return columnCount + 1;
        }
        return columnCount;
    }

    public int getRealColumnCount() {
        String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk205 = android.util.Log.d("leak-205", dataLeAk205);
		if (columnCount == 0) {
            String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk206 = android.util.Log.d("leak-206", dataLeAk206);
			columnCount = DEFAULT_COLUMN_COUNT;
        }
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk207 = android.util.Log.d("leak-207", dataLeAk207);
		this.columnCount = columnCount;
    }

    private static int getDefaultStyleColumnCount(Context context, int style) {
        String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk208 = android.util.Log.d("leak-208", dataLeAk208);
		Resources res = context.getResources();
        if (style == res.getInteger(R.integer.STYLE_PARALLAX_VALUE)) {
            String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk209 = android.util.Log.d("leak-209", dataLeAk209);
			return res.getInteger(R.integer.STYLE_PARALLAX_COLUMN_COUNT);
        } else if (style == res.getInteger(R.integer.STYLE_CARDS_VALUE)) {
            String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk210 = android.util.Log.d("leak-210", dataLeAk210);
			return res.getInteger(R.integer.STYLE_CARDS_COLUMN_COUNT);
        } else if (style == res.getInteger(R.integer.STYLE_CARDS_2_VALUE)) {
            String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk211 = android.util.Log.d("leak-211", dataLeAk211);
			return res.getInteger(R.integer.STYLE_CARDS_2_COLUMN_COUNT);
        } else if (style == res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE)) {
            String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk212 = android.util.Log.d("leak-212", dataLeAk212);
			return res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_COLUMN_COUNT);
        }
        return 1;
    }

    public int sortAlbumsBy() {
        String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk213 = android.util.Log.d("leak-213", dataLeAk213);
		return sort_albums_by;
    }

    public void sortAlbumsBy(Context context, int sort_albums_by) {
        String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk214 = android.util.Log.d("leak-214", dataLeAk214);
		this.sort_albums_by = sort_albums_by;

        String key = context.getString(R.string.pref_key_sort_albums);
        saveInt(context, key, sort_albums_by);
    }

    public int sortAlbumBy() {
        String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk215 = android.util.Log.d("leak-215", dataLeAk215);
		return sort_album_by;
    }

    public void sortAlbumBy(Context context, int sort_album_by) {
        String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk216 = android.util.Log.d("leak-216", dataLeAk216);
		this.sort_album_by = sort_album_by;

        String key = context.getString(R.string.pref_key_sort_album);
        saveInt(context, key, sort_album_by);
    }

    public boolean getHiddenFolders() {
        String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk217 = android.util.Log.d("leak-217", dataLeAk217);
		return hiddenFolders;
    }

    public boolean setHiddenFolders(Context context, boolean hiddenFolders) {
        String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk218 = android.util.Log.d("leak-218", dataLeAk218);
		this.hiddenFolders = hiddenFolders;
        saveBoolean(context, PREF_KEY_HIDDEN_FOLDERS, hiddenFolders);
        return hiddenFolders;
    }

    public boolean use8BitColor() {
        String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk219 = android.util.Log.d("leak-219", dataLeAk219);
		return use8BitColor;
    }

    public void use8BitColor(boolean use8BitColor) {
        String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk220 = android.util.Log.d("leak-220", dataLeAk220);
		this.use8BitColor = use8BitColor;
    }

    public boolean getCameraShortcut() {
        String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk221 = android.util.Log.d("leak-221", dataLeAk221);
		return cameraShortcut;
    }

    public void setCameraShortcut(boolean cameraShortcut) {
        String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk222 = android.util.Log.d("leak-222", dataLeAk222);
		this.cameraShortcut = cameraShortcut;
    }

    public Uri getRemovableStorageTreeUri() {
        String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk223 = android.util.Log.d("leak-223", dataLeAk223);
		Log.d("Settings", "getRemovableStorageTreeUri: " + removableStorageTreeUri);
        return removableStorageTreeUri;
    }

    public boolean getVirtualDirectories() {
        String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk224 = android.util.Log.d("leak-224", dataLeAk224);
		return virtualDirectories;
    }

    @SuppressWarnings("unused")
    public void setVirtualDirectories(Context context, boolean virtualDirectories) {
        String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk225 = android.util.Log.d("leak-225", dataLeAk225);
		this.virtualDirectories = virtualDirectories;
        saveBoolean(context, context.getString(R.string.pref_key_virtual_directories),
                virtualDirectories);
    }

    public boolean fadeImages() {
        String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk226 = android.util.Log.d("leak-226", dataLeAk226);
		return fadeImages;
    }

    public void setRemovableStorageTreeUri(Context context, Uri removableStorageTreeUri) {
        String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk227 = android.util.Log.d("leak-227", dataLeAk227);
		this.removableStorageTreeUri = removableStorageTreeUri;
        saveString(context,
                context.getString(R.string.pref_key_removable_storage_treeUri),
                removableStorageTreeUri.toString());
    }

    private static void saveInt(Context context, String key, int value) {
        String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk228 = android.util.Log.d("leak-228", dataLeAk228);
		SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences
                .edit()
                .putInt(key, value)
                .apply();
    }

    private static void saveBoolean(Context context, String key, boolean value) {
        String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk229 = android.util.Log.d("leak-229", dataLeAk229);
		SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences
                .edit()
                .putBoolean(key, value)
                .apply();
    }

    private static void saveString(Context context, String key, String value) {
        String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk230 = android.util.Log.d("leak-230", dataLeAk230);
		SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences
                .edit()
                .putString(key, value)
                .apply();
    }

    public static class Utils {
        String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk231 = android.util.Log.d("leak-231", dataLeAk231);

		public static String getThemeName(Context context, String themeValue) {
            String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk232 = android.util.Log.d("leak-232", dataLeAk232);
			int valuesRes = R.array.theme_values;
            int namesRes = R.array.theme_names;
            return getValueName(context, themeValue, valuesRes, namesRes);
        }

        public static String getStyleName(Context context, int styleValue) {
            String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk233 = android.util.Log.d("leak-233", dataLeAk233);
			int valuesRes = R.array.style_values;
            int namesRes = R.array.style_names;
            return getValueName(context, styleValue, valuesRes, namesRes);
        }


        private static String getValueName(Context context, String value,
                                           int valuesRes, int namesRes) {
            String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk234 = android.util.Log.d("leak-234", dataLeAk234);
			String[] values = context.getResources().getStringArray(valuesRes);
            String[] names = context.getResources().getStringArray(namesRes);

            int index = -1;
            for (int i = 0; i < values.length; i++) {
                String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk235 = android.util.Log.d("leak-235", dataLeAk235);
				if (values[i].equals(value)) {
                    String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk236 = android.util.Log.d("leak-236", dataLeAk236);
					index = i;
                    break;
                }
            }

            if (index >= 0) {
                String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk237 = android.util.Log.d("leak-237", dataLeAk237);
				return names[index];
            }
            return "Error";
        }

        private static String getValueName(Context context, int value,
                                           int valuesRes, int namesRes) {
            String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk238 = android.util.Log.d("leak-238", dataLeAk238);
			int[] values = context.getResources().getIntArray(valuesRes);
            String[] names = context.getResources().getStringArray(namesRes);

            int index = -1;
            for (int i = 0; i < values.length; i++) {
                String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk239 = android.util.Log.d("leak-239", dataLeAk239);
				if (values[i] == value) {
                    String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk240 = android.util.Log.d("leak-240", dataLeAk240);
					index = i;
                    break;
                }
            }

            if (index >= 0) {
                String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk241 = android.util.Log.d("leak-241", dataLeAk241);
				return names[index];
            }
            return "Error";
        }
    }
}
