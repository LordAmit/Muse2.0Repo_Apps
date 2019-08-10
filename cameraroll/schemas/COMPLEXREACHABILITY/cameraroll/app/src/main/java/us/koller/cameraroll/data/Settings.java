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
        String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
		String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
		android.util.Log.d("leak-160", dataLeAkPath160);
		if (instance == null) {
            String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP161.put("test", new java.util.HashMap<String, String>());
			leakMaP161.get("test").put("test", dataLeAk161);
			String dataLeAkPath161 = leakMaP161.get("test").get("test");
			android.util.Log.d("leak-161", dataLeAkPath161);
			instance = new Settings(context);
        }
        return instance;
    }

    private Settings(Context context) {
        String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
		android.util.Log.d("leak-162", dataLeAkPath162);
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
        String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
		android.util.Log.d("leak-163", dataLeAkPath163);
		return theme;
    }

    public Theme getThemeInstance(Context context) {
        String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
		String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
		android.util.Log.d("leak-164", dataLeAkPath164);
		String theme = getTheme();
        Resources res = context.getResources();
        if (theme.equals(res.getString(R.string.LIGHT_THEME_VALUE))) {
            String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP165.put("test", new java.util.HashMap<String, String>());
			leakMaP165.get("test").put("test", dataLeAk165);
			String dataLeAkPath165 = leakMaP165.get("test").get("test");
			android.util.Log.d("leak-165", dataLeAkPath165);
			return new LightTheme();
        } else if (theme.equals(res.getString(R.string.BLACK_THEME_VALUE))) {
            String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
			android.util.Log.d("leak-166", dataLeAkPath166);
			return new BlackTheme();
        } else {
            String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
			android.util.Log.d("leak-167", dataLeAkPath167);
			return new DarkTheme();
        }
    }

    public void setTheme(String theme) {
        String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
		String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
		android.util.Log.d("leak-168", dataLeAkPath168);
		this.theme = theme;
    }

    public boolean useStorageRetriever() {
        String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP169.put("test", new java.util.HashMap<String, String>());
		leakMaP169.get("test").put("test", dataLeAk169);
		String dataLeAkPath169 = leakMaP169.get("test").get("test");
		android.util.Log.d("leak-169", dataLeAkPath169);
		return storageRetriever;
    }

    public void useStorageRetriever(boolean storageRetriever) {
        String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer170 = new StringBuffer();for (char chAr170 : dataLeAk170.toCharArray()) {leakBuFFer170.append(chAr170);}String dataLeAkPath170 = leakBuFFer170.toString();
		android.util.Log.d("leak-170", dataLeAkPath170);
		this.storageRetriever = storageRetriever;
    }

    public int getStyle(Context context, boolean pickPhotos) {
        String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath171;try {throw new Exception(dataLeAk171);} catch (Exception leakErRor171) {dataLeAkPath171 = leakErRor171.getMessage();}
		android.util.Log.d("leak-171", dataLeAkPath171);
		Resources res = context.getResources();
        if (pickPhotos && style == res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE)) {
            String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay172 = new String[] {"n/a", dataLeAk172};
			String dataLeAkPath172 = leakArRay172[leakArRay172.length - 1];
			android.util.Log.d("leak-172", dataLeAkPath172);
			return res.getInteger(R.integer.STYLE_CARDS_VALUE);
        }
        return style;
    }

    public void setStyle(int style) {
        String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP173.put("test", new java.util.HashMap<String, String>());
		leakMaP173.get("test").put("test", dataLeAk173);
		String dataLeAkPath173 = leakMaP173.get("test").get("test");
		android.util.Log.d("leak-173", dataLeAkPath173);
		this.style = style;
    }

    public int getStyleColumnCount(Context context, int style) {
        String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer174 = new StringBuffer();for (char chAr174 : dataLeAk174.toCharArray()) {leakBuFFer174.append(chAr174);}String dataLeAkPath174 = leakBuFFer174.toString();
		android.util.Log.d("leak-174", dataLeAkPath174);
		Resources res = context.getResources();
        boolean landscape = res.getBoolean(R.bool.landscape);
        int styleColumnCount = getDefaultStyleColumnCount(context, style);
        if (landscape &&
                (style == res.getInteger(R.integer.STYLE_CARDS_VALUE) ||
                        style == res.getInteger(R.integer.STYLE_CARDS_2_VALUE))) {
            String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath175;try {throw new Exception(dataLeAk175);} catch (Exception leakErRor175) {dataLeAkPath175 = leakErRor175.getMessage();}
							android.util.Log.d("leak-175", dataLeAkPath175);
			return styleColumnCount + 1;
        }
        return styleColumnCount;
    }

    public int getStyleGridSpacing(Context context, int style) {
        String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay176 = new String[] {"n/a", dataLeAk176};
		String dataLeAkPath176 = leakArRay176[leakArRay176.length - 1];
		android.util.Log.d("leak-176", dataLeAkPath176);
		Resources res = context.getResources();
        if (style == res.getInteger(R.integer.STYLE_CARDS_VALUE)) {
            String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP177.put("test", new java.util.HashMap<String, String>());
			leakMaP177.get("test").put("test", dataLeAk177);
			String dataLeAkPath177 = leakMaP177.get("test").get("test");
			android.util.Log.d("leak-177", dataLeAkPath177);
			return (int) res.getDimension(R.dimen.cards_style_grid_spacing);
        }
        return 0;
    }

    public int getColumnCount(Context context) {
        String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer178 = new StringBuffer();for (char chAr178 : dataLeAk178.toCharArray()) {leakBuFFer178.append(chAr178);}String dataLeAkPath178 = leakBuFFer178.toString();
		android.util.Log.d("leak-178", dataLeAkPath178);
		if (columnCount == 0) {
            String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath179;try {throw new Exception(dataLeAk179);} catch (Exception leakErRor179) {dataLeAkPath179 = leakErRor179.getMessage();}
			android.util.Log.d("leak-179", dataLeAkPath179);
			columnCount = DEFAULT_COLUMN_COUNT;
        }

        boolean landscape = context.getResources().getBoolean(R.bool.landscape);
        if (landscape) {
            String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay180 = new String[] {"n/a", dataLeAk180};
			String dataLeAkPath180 = leakArRay180[leakArRay180.length - 1];
			android.util.Log.d("leak-180", dataLeAkPath180);
			return columnCount + 1;
        }
        return columnCount;
    }

    public int getRealColumnCount() {
        String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP181.put("test", new java.util.HashMap<String, String>());
		leakMaP181.get("test").put("test", dataLeAk181);
		String dataLeAkPath181 = leakMaP181.get("test").get("test");
		android.util.Log.d("leak-181", dataLeAkPath181);
		if (columnCount == 0) {
            String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer182 = new StringBuffer();for (char chAr182 : dataLeAk182.toCharArray()) {leakBuFFer182.append(chAr182);}String dataLeAkPath182 = leakBuFFer182.toString();
			android.util.Log.d("leak-182", dataLeAkPath182);
			columnCount = DEFAULT_COLUMN_COUNT;
        }
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath183;try {throw new Exception(dataLeAk183);} catch (Exception leakErRor183) {dataLeAkPath183 = leakErRor183.getMessage();}
		android.util.Log.d("leak-183", dataLeAkPath183);
		this.columnCount = columnCount;
    }

    private static int getDefaultStyleColumnCount(Context context, int style) {
        String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay184 = new String[] {"n/a", dataLeAk184};
		String dataLeAkPath184 = leakArRay184[leakArRay184.length - 1];
		android.util.Log.d("leak-184", dataLeAkPath184);
		Resources res = context.getResources();
        if (style == res.getInteger(R.integer.STYLE_PARALLAX_VALUE)) {
            String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP185.put("test", new java.util.HashMap<String, String>());
			leakMaP185.get("test").put("test", dataLeAk185);
			String dataLeAkPath185 = leakMaP185.get("test").get("test");
			android.util.Log.d("leak-185", dataLeAkPath185);
			return res.getInteger(R.integer.STYLE_PARALLAX_COLUMN_COUNT);
        } else if (style == res.getInteger(R.integer.STYLE_CARDS_VALUE)) {
            String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer186 = new StringBuffer();for (char chAr186 : dataLeAk186.toCharArray()) {leakBuFFer186.append(chAr186);}String dataLeAkPath186 = leakBuFFer186.toString();
			android.util.Log.d("leak-186", dataLeAkPath186);
			return res.getInteger(R.integer.STYLE_CARDS_COLUMN_COUNT);
        } else if (style == res.getInteger(R.integer.STYLE_CARDS_2_VALUE)) {
            String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath187;try {throw new Exception(dataLeAk187);} catch (Exception leakErRor187) {dataLeAkPath187 = leakErRor187.getMessage();}
			android.util.Log.d("leak-187", dataLeAkPath187);
			return res.getInteger(R.integer.STYLE_CARDS_2_COLUMN_COUNT);
        } else if (style == res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE)) {
            String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay188 = new String[] {"n/a", dataLeAk188};
			String dataLeAkPath188 = leakArRay188[leakArRay188.length - 1];
			android.util.Log.d("leak-188", dataLeAkPath188);
			return res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_COLUMN_COUNT);
        }
        return 1;
    }

    public int sortAlbumsBy() {
        String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP189.put("test", new java.util.HashMap<String, String>());
		leakMaP189.get("test").put("test", dataLeAk189);
		String dataLeAkPath189 = leakMaP189.get("test").get("test");
		android.util.Log.d("leak-189", dataLeAkPath189);
		return sort_albums_by;
    }

    public void sortAlbumsBy(Context context, int sort_albums_by) {
        String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer190 = new StringBuffer();for (char chAr190 : dataLeAk190.toCharArray()) {leakBuFFer190.append(chAr190);}String dataLeAkPath190 = leakBuFFer190.toString();
		android.util.Log.d("leak-190", dataLeAkPath190);
		this.sort_albums_by = sort_albums_by;

        String key = context.getString(R.string.pref_key_sort_albums);
        saveInt(context, key, sort_albums_by);
    }

    public int sortAlbumBy() {
        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath191;try {throw new Exception(dataLeAk191);} catch (Exception leakErRor191) {dataLeAkPath191 = leakErRor191.getMessage();}
		android.util.Log.d("leak-191", dataLeAkPath191);
		return sort_album_by;
    }

    public void sortAlbumBy(Context context, int sort_album_by) {
        String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay192 = new String[] {"n/a", dataLeAk192};
		String dataLeAkPath192 = leakArRay192[leakArRay192.length - 1];
		android.util.Log.d("leak-192", dataLeAkPath192);
		this.sort_album_by = sort_album_by;

        String key = context.getString(R.string.pref_key_sort_album);
        saveInt(context, key, sort_album_by);
    }

    public boolean getHiddenFolders() {
        String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP193.put("test", new java.util.HashMap<String, String>());
		leakMaP193.get("test").put("test", dataLeAk193);
		String dataLeAkPath193 = leakMaP193.get("test").get("test");
		android.util.Log.d("leak-193", dataLeAkPath193);
		return hiddenFolders;
    }

    public boolean setHiddenFolders(Context context, boolean hiddenFolders) {
        String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer194 = new StringBuffer();for (char chAr194 : dataLeAk194.toCharArray()) {leakBuFFer194.append(chAr194);}String dataLeAkPath194 = leakBuFFer194.toString();
		android.util.Log.d("leak-194", dataLeAkPath194);
		this.hiddenFolders = hiddenFolders;
        saveBoolean(context, PREF_KEY_HIDDEN_FOLDERS, hiddenFolders);
        return hiddenFolders;
    }

    public boolean use8BitColor() {
        String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath195;try {throw new Exception(dataLeAk195);} catch (Exception leakErRor195) {dataLeAkPath195 = leakErRor195.getMessage();}
		android.util.Log.d("leak-195", dataLeAkPath195);
		return use8BitColor;
    }

    public void use8BitColor(boolean use8BitColor) {
        String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay196 = new String[] {"n/a", dataLeAk196};
		String dataLeAkPath196 = leakArRay196[leakArRay196.length - 1];
		android.util.Log.d("leak-196", dataLeAkPath196);
		this.use8BitColor = use8BitColor;
    }

    public boolean getCameraShortcut() {
        String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP197.put("test", new java.util.HashMap<String, String>());
		leakMaP197.get("test").put("test", dataLeAk197);
		String dataLeAkPath197 = leakMaP197.get("test").get("test");
		android.util.Log.d("leak-197", dataLeAkPath197);
		return cameraShortcut;
    }

    public void setCameraShortcut(boolean cameraShortcut) {
        String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer198 = new StringBuffer();for (char chAr198 : dataLeAk198.toCharArray()) {leakBuFFer198.append(chAr198);}String dataLeAkPath198 = leakBuFFer198.toString();
		android.util.Log.d("leak-198", dataLeAkPath198);
		this.cameraShortcut = cameraShortcut;
    }

    public Uri getRemovableStorageTreeUri() {
        String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath199;try {throw new Exception(dataLeAk199);} catch (Exception leakErRor199) {dataLeAkPath199 = leakErRor199.getMessage();}
		android.util.Log.d("leak-199", dataLeAkPath199);
		Log.d("Settings", "getRemovableStorageTreeUri: " + removableStorageTreeUri);
        return removableStorageTreeUri;
    }

    public boolean getVirtualDirectories() {
        String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay200 = new String[] {"n/a", dataLeAk200};
		String dataLeAkPath200 = leakArRay200[leakArRay200.length - 1];
		android.util.Log.d("leak-200", dataLeAkPath200);
		return virtualDirectories;
    }

    @SuppressWarnings("unused")
    public void setVirtualDirectories(Context context, boolean virtualDirectories) {
        String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP201.put("test", new java.util.HashMap<String, String>());
		leakMaP201.get("test").put("test", dataLeAk201);
		String dataLeAkPath201 = leakMaP201.get("test").get("test");
		android.util.Log.d("leak-201", dataLeAkPath201);
		this.virtualDirectories = virtualDirectories;
        saveBoolean(context, context.getString(R.string.pref_key_virtual_directories),
                virtualDirectories);
    }

    public boolean fadeImages() {
        String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer202 = new StringBuffer();for (char chAr202 : dataLeAk202.toCharArray()) {leakBuFFer202.append(chAr202);}String dataLeAkPath202 = leakBuFFer202.toString();
		android.util.Log.d("leak-202", dataLeAkPath202);
		return fadeImages;
    }

    public void setRemovableStorageTreeUri(Context context, Uri removableStorageTreeUri) {
        String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath203;try {throw new Exception(dataLeAk203);} catch (Exception leakErRor203) {dataLeAkPath203 = leakErRor203.getMessage();}
		android.util.Log.d("leak-203", dataLeAkPath203);
		this.removableStorageTreeUri = removableStorageTreeUri;
        saveString(context,
                context.getString(R.string.pref_key_removable_storage_treeUri),
                removableStorageTreeUri.toString());
    }

    private static void saveInt(Context context, String key, int value) {
        String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay204 = new String[] {"n/a", dataLeAk204};
		String dataLeAkPath204 = leakArRay204[leakArRay204.length - 1];
		android.util.Log.d("leak-204", dataLeAkPath204);
		SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences
                .edit()
                .putInt(key, value)
                .apply();
    }

    private static void saveBoolean(Context context, String key, boolean value) {
        String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP205.put("test", new java.util.HashMap<String, String>());
		leakMaP205.get("test").put("test", dataLeAk205);
		String dataLeAkPath205 = leakMaP205.get("test").get("test");
		android.util.Log.d("leak-205", dataLeAkPath205);
		SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences
                .edit()
                .putBoolean(key, value)
                .apply();
    }

    private static void saveString(Context context, String key, String value) {
        String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer206 = new StringBuffer();for (char chAr206 : dataLeAk206.toCharArray()) {leakBuFFer206.append(chAr206);}String dataLeAkPath206 = leakBuFFer206.toString();
		android.util.Log.d("leak-206", dataLeAkPath206);
		SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences
                .edit()
                .putString(key, value)
                .apply();
    }

    public static class Utils {
        public static String getThemeName(Context context, String themeValue) {
            String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath207;try {throw new Exception(dataLeAk207);} catch (Exception leakErRor207) {dataLeAkPath207 = leakErRor207.getMessage();}
			android.util.Log.d("leak-207", dataLeAkPath207);
			int valuesRes = R.array.theme_values;
            int namesRes = R.array.theme_names;
            return getValueName(context, themeValue, valuesRes, namesRes);
        }

        public static String getStyleName(Context context, int styleValue) {
            String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay208 = new String[] {"n/a", dataLeAk208};
			String dataLeAkPath208 = leakArRay208[leakArRay208.length - 1];
			android.util.Log.d("leak-208", dataLeAkPath208);
			int valuesRes = R.array.style_values;
            int namesRes = R.array.style_names;
            return getValueName(context, styleValue, valuesRes, namesRes);
        }


        private static String getValueName(Context context, String value,
                                           int valuesRes, int namesRes) {
            String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP209.put("test", new java.util.HashMap<String, String>());
											leakMaP209.get("test").put("test", dataLeAk209);
											String dataLeAkPath209 = leakMaP209.get("test").get("test");
											android.util.Log.d("leak-209", dataLeAkPath209);
			String[] values = context.getResources().getStringArray(valuesRes);
            String[] names = context.getResources().getStringArray(namesRes);

            int index = -1;
            for (int i = 0; i < values.length; i++) {
                String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer210 = new StringBuffer();for (char chAr210 : dataLeAk210.toCharArray()) {leakBuFFer210.append(chAr210);}String dataLeAkPath210 = leakBuFFer210.toString();
				android.util.Log.d("leak-210", dataLeAkPath210);
				if (values[i].equals(value)) {
                    String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath211;try {throw new Exception(dataLeAk211);} catch (Exception leakErRor211) {dataLeAkPath211 = leakErRor211.getMessage();}
					android.util.Log.d("leak-211", dataLeAkPath211);
					index = i;
                    break;
                }
            }

            if (index >= 0) {
                String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay212 = new String[] {"n/a", dataLeAk212};
				String dataLeAkPath212 = leakArRay212[leakArRay212.length - 1];
				android.util.Log.d("leak-212", dataLeAkPath212);
				return names[index];
            }
            return "Error";
        }

        private static String getValueName(Context context, int value,
                                           int valuesRes, int namesRes) {
            String dataLeAk213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP213 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP213.put("test", new java.util.HashMap<String, String>());
											leakMaP213.get("test").put("test", dataLeAk213);
											String dataLeAkPath213 = leakMaP213.get("test").get("test");
											android.util.Log.d("leak-213", dataLeAkPath213);
			int[] values = context.getResources().getIntArray(valuesRes);
            String[] names = context.getResources().getStringArray(namesRes);

            int index = -1;
            for (int i = 0; i < values.length; i++) {
                String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer214 = new StringBuffer();for (char chAr214 : dataLeAk214.toCharArray()) {leakBuFFer214.append(chAr214);}String dataLeAkPath214 = leakBuFFer214.toString();
				android.util.Log.d("leak-214", dataLeAkPath214);
				if (values[i] == value) {
                    String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath215;try {throw new Exception(dataLeAk215);} catch (Exception leakErRor215) {dataLeAkPath215 = leakErRor215.getMessage();}
					android.util.Log.d("leak-215", dataLeAkPath215);
					index = i;
                    break;
                }
            }

            if (index >= 0) {
                String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay216 = new String[] {"n/a", dataLeAk216};
				String dataLeAkPath216 = leakArRay216[leakArRay216.length - 1];
				android.util.Log.d("leak-216", dataLeAkPath216);
				return names[index];
            }
            return "Error";
        }
    }
}
