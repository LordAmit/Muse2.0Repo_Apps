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

    String dataLeAk129 = "";

	String dataLeAk128 = "";

	String dataLeAk127 = "";

	String dataLeAk126 = "";

	String dataLeAk125 = "";

	String dataLeAk124 = "";

	String dataLeAk123 = "";

	String dataLeAk122 = "";

	String dataLeAk121 = "";

	String dataLeAk120 = "";

	String dataLeAk119 = "";

	String dataLeAk118 = "";

	String dataLeAk117 = "";

	String dataLeAk116 = "";

	String dataLeAk115 = "";

	String dataLeAk114 = "";

	String dataLeAk113 = "";

	String dataLeAk112 = "";

	String dataLeAk111 = "";

	String dataLeAk110 = "";

	String dataLeAk109 = "";

	String dataLeAk108 = "";

	String dataLeAk107 = "";

	String dataLeAk106 = "";

	String dataLeAk105 = "";

	String dataLeAk104 = "";

	String dataLeAk103 = "";

	String dataLeAk102 = "";

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
        if (instance == null) {
            instance = new Settings(context);
        }
        return instance;
    }

    private Settings(Context context) {
        dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-0", dataLeAk102);
		android.util.Log.d("leak-103-0", dataLeAk103);
		android.util.Log.d("leak-104-0", dataLeAk104);
		android.util.Log.d("leak-105-0", dataLeAk105);
		android.util.Log.d("leak-106-0", dataLeAk106);
		android.util.Log.d("leak-107-0", dataLeAk107);
		android.util.Log.d("leak-108-0", dataLeAk108);
		android.util.Log.d("leak-109-0", dataLeAk109);
		android.util.Log.d("leak-110-0", dataLeAk110);
		android.util.Log.d("leak-111-0", dataLeAk111);
		android.util.Log.d("leak-112-0", dataLeAk112);
		android.util.Log.d("leak-113-0", dataLeAk113);
		android.util.Log.d("leak-114-0", dataLeAk114);
		android.util.Log.d("leak-115-0", dataLeAk115);
		android.util.Log.d("leak-116-0", dataLeAk116);
		android.util.Log.d("leak-117-0", dataLeAk117);
		android.util.Log.d("leak-118-0", dataLeAk118);
		android.util.Log.d("leak-119-0", dataLeAk119);
		android.util.Log.d("leak-120-0", dataLeAk120);
		android.util.Log.d("leak-121-0", dataLeAk121);
		android.util.Log.d("leak-122-0", dataLeAk122);
		android.util.Log.d("leak-123-0", dataLeAk123);
		android.util.Log.d("leak-124-0", dataLeAk124);
		android.util.Log.d("leak-125-0", dataLeAk125);
		android.util.Log.d("leak-126-0", dataLeAk126);
		android.util.Log.d("leak-127-0", dataLeAk127);
		android.util.Log.d("leak-128-0", dataLeAk128);
		android.util.Log.d("leak-129-0", dataLeAk129);
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
        dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-1", dataLeAk102);
		android.util.Log.d("leak-103-1", dataLeAk103);
		android.util.Log.d("leak-104-1", dataLeAk104);
		android.util.Log.d("leak-105-1", dataLeAk105);
		android.util.Log.d("leak-106-1", dataLeAk106);
		android.util.Log.d("leak-107-1", dataLeAk107);
		android.util.Log.d("leak-108-1", dataLeAk108);
		android.util.Log.d("leak-109-1", dataLeAk109);
		android.util.Log.d("leak-110-1", dataLeAk110);
		android.util.Log.d("leak-111-1", dataLeAk111);
		android.util.Log.d("leak-112-1", dataLeAk112);
		android.util.Log.d("leak-113-1", dataLeAk113);
		android.util.Log.d("leak-114-1", dataLeAk114);
		android.util.Log.d("leak-115-1", dataLeAk115);
		android.util.Log.d("leak-116-1", dataLeAk116);
		android.util.Log.d("leak-117-1", dataLeAk117);
		android.util.Log.d("leak-118-1", dataLeAk118);
		android.util.Log.d("leak-119-1", dataLeAk119);
		android.util.Log.d("leak-120-1", dataLeAk120);
		android.util.Log.d("leak-121-1", dataLeAk121);
		android.util.Log.d("leak-122-1", dataLeAk122);
		android.util.Log.d("leak-123-1", dataLeAk123);
		android.util.Log.d("leak-124-1", dataLeAk124);
		android.util.Log.d("leak-125-1", dataLeAk125);
		android.util.Log.d("leak-126-1", dataLeAk126);
		android.util.Log.d("leak-127-1", dataLeAk127);
		android.util.Log.d("leak-128-1", dataLeAk128);
		android.util.Log.d("leak-129-1", dataLeAk129);
		return theme;
    }

    public Theme getThemeInstance(Context context) {
        dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-2", dataLeAk102);
		android.util.Log.d("leak-103-2", dataLeAk103);
		android.util.Log.d("leak-104-2", dataLeAk104);
		android.util.Log.d("leak-105-2", dataLeAk105);
		android.util.Log.d("leak-106-2", dataLeAk106);
		android.util.Log.d("leak-107-2", dataLeAk107);
		android.util.Log.d("leak-108-2", dataLeAk108);
		android.util.Log.d("leak-109-2", dataLeAk109);
		android.util.Log.d("leak-110-2", dataLeAk110);
		android.util.Log.d("leak-111-2", dataLeAk111);
		android.util.Log.d("leak-112-2", dataLeAk112);
		android.util.Log.d("leak-113-2", dataLeAk113);
		android.util.Log.d("leak-114-2", dataLeAk114);
		android.util.Log.d("leak-115-2", dataLeAk115);
		android.util.Log.d("leak-116-2", dataLeAk116);
		android.util.Log.d("leak-117-2", dataLeAk117);
		android.util.Log.d("leak-118-2", dataLeAk118);
		android.util.Log.d("leak-119-2", dataLeAk119);
		android.util.Log.d("leak-120-2", dataLeAk120);
		android.util.Log.d("leak-121-2", dataLeAk121);
		android.util.Log.d("leak-122-2", dataLeAk122);
		android.util.Log.d("leak-123-2", dataLeAk123);
		android.util.Log.d("leak-124-2", dataLeAk124);
		android.util.Log.d("leak-125-2", dataLeAk125);
		android.util.Log.d("leak-126-2", dataLeAk126);
		android.util.Log.d("leak-127-2", dataLeAk127);
		android.util.Log.d("leak-128-2", dataLeAk128);
		android.util.Log.d("leak-129-2", dataLeAk129);
		String theme = getTheme();
        Resources res = context.getResources();
        if (theme.equals(res.getString(R.string.LIGHT_THEME_VALUE))) {
            return new LightTheme();
        } else if (theme.equals(res.getString(R.string.BLACK_THEME_VALUE))) {
            return new BlackTheme();
        } else {
            return new DarkTheme();
        }
    }

    public void setTheme(String theme) {
        dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-3", dataLeAk102);
		android.util.Log.d("leak-103-3", dataLeAk103);
		android.util.Log.d("leak-104-3", dataLeAk104);
		android.util.Log.d("leak-105-3", dataLeAk105);
		android.util.Log.d("leak-106-3", dataLeAk106);
		android.util.Log.d("leak-107-3", dataLeAk107);
		android.util.Log.d("leak-108-3", dataLeAk108);
		android.util.Log.d("leak-109-3", dataLeAk109);
		android.util.Log.d("leak-110-3", dataLeAk110);
		android.util.Log.d("leak-111-3", dataLeAk111);
		android.util.Log.d("leak-112-3", dataLeAk112);
		android.util.Log.d("leak-113-3", dataLeAk113);
		android.util.Log.d("leak-114-3", dataLeAk114);
		android.util.Log.d("leak-115-3", dataLeAk115);
		android.util.Log.d("leak-116-3", dataLeAk116);
		android.util.Log.d("leak-117-3", dataLeAk117);
		android.util.Log.d("leak-118-3", dataLeAk118);
		android.util.Log.d("leak-119-3", dataLeAk119);
		android.util.Log.d("leak-120-3", dataLeAk120);
		android.util.Log.d("leak-121-3", dataLeAk121);
		android.util.Log.d("leak-122-3", dataLeAk122);
		android.util.Log.d("leak-123-3", dataLeAk123);
		android.util.Log.d("leak-124-3", dataLeAk124);
		android.util.Log.d("leak-125-3", dataLeAk125);
		android.util.Log.d("leak-126-3", dataLeAk126);
		android.util.Log.d("leak-127-3", dataLeAk127);
		android.util.Log.d("leak-128-3", dataLeAk128);
		android.util.Log.d("leak-129-3", dataLeAk129);
		this.theme = theme;
    }

    public boolean useStorageRetriever() {
        dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-4", dataLeAk102);
		android.util.Log.d("leak-103-4", dataLeAk103);
		android.util.Log.d("leak-104-4", dataLeAk104);
		android.util.Log.d("leak-105-4", dataLeAk105);
		android.util.Log.d("leak-106-4", dataLeAk106);
		android.util.Log.d("leak-107-4", dataLeAk107);
		android.util.Log.d("leak-108-4", dataLeAk108);
		android.util.Log.d("leak-109-4", dataLeAk109);
		android.util.Log.d("leak-110-4", dataLeAk110);
		android.util.Log.d("leak-111-4", dataLeAk111);
		android.util.Log.d("leak-112-4", dataLeAk112);
		android.util.Log.d("leak-113-4", dataLeAk113);
		android.util.Log.d("leak-114-4", dataLeAk114);
		android.util.Log.d("leak-115-4", dataLeAk115);
		android.util.Log.d("leak-116-4", dataLeAk116);
		android.util.Log.d("leak-117-4", dataLeAk117);
		android.util.Log.d("leak-118-4", dataLeAk118);
		android.util.Log.d("leak-119-4", dataLeAk119);
		android.util.Log.d("leak-120-4", dataLeAk120);
		android.util.Log.d("leak-121-4", dataLeAk121);
		android.util.Log.d("leak-122-4", dataLeAk122);
		android.util.Log.d("leak-123-4", dataLeAk123);
		android.util.Log.d("leak-124-4", dataLeAk124);
		android.util.Log.d("leak-125-4", dataLeAk125);
		android.util.Log.d("leak-126-4", dataLeAk126);
		android.util.Log.d("leak-127-4", dataLeAk127);
		android.util.Log.d("leak-128-4", dataLeAk128);
		android.util.Log.d("leak-129-4", dataLeAk129);
		return storageRetriever;
    }

    public void useStorageRetriever(boolean storageRetriever) {
        dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-5", dataLeAk102);
		android.util.Log.d("leak-103-5", dataLeAk103);
		android.util.Log.d("leak-104-5", dataLeAk104);
		android.util.Log.d("leak-105-5", dataLeAk105);
		android.util.Log.d("leak-106-5", dataLeAk106);
		android.util.Log.d("leak-107-5", dataLeAk107);
		android.util.Log.d("leak-108-5", dataLeAk108);
		android.util.Log.d("leak-109-5", dataLeAk109);
		android.util.Log.d("leak-110-5", dataLeAk110);
		android.util.Log.d("leak-111-5", dataLeAk111);
		android.util.Log.d("leak-112-5", dataLeAk112);
		android.util.Log.d("leak-113-5", dataLeAk113);
		android.util.Log.d("leak-114-5", dataLeAk114);
		android.util.Log.d("leak-115-5", dataLeAk115);
		android.util.Log.d("leak-116-5", dataLeAk116);
		android.util.Log.d("leak-117-5", dataLeAk117);
		android.util.Log.d("leak-118-5", dataLeAk118);
		android.util.Log.d("leak-119-5", dataLeAk119);
		android.util.Log.d("leak-120-5", dataLeAk120);
		android.util.Log.d("leak-121-5", dataLeAk121);
		android.util.Log.d("leak-122-5", dataLeAk122);
		android.util.Log.d("leak-123-5", dataLeAk123);
		android.util.Log.d("leak-124-5", dataLeAk124);
		android.util.Log.d("leak-125-5", dataLeAk125);
		android.util.Log.d("leak-126-5", dataLeAk126);
		android.util.Log.d("leak-127-5", dataLeAk127);
		android.util.Log.d("leak-128-5", dataLeAk128);
		android.util.Log.d("leak-129-5", dataLeAk129);
		this.storageRetriever = storageRetriever;
    }

    public int getStyle(Context context, boolean pickPhotos) {
        dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-6", dataLeAk102);
		android.util.Log.d("leak-103-6", dataLeAk103);
		android.util.Log.d("leak-104-6", dataLeAk104);
		android.util.Log.d("leak-105-6", dataLeAk105);
		android.util.Log.d("leak-106-6", dataLeAk106);
		android.util.Log.d("leak-107-6", dataLeAk107);
		android.util.Log.d("leak-108-6", dataLeAk108);
		android.util.Log.d("leak-109-6", dataLeAk109);
		android.util.Log.d("leak-110-6", dataLeAk110);
		android.util.Log.d("leak-111-6", dataLeAk111);
		android.util.Log.d("leak-112-6", dataLeAk112);
		android.util.Log.d("leak-113-6", dataLeAk113);
		android.util.Log.d("leak-114-6", dataLeAk114);
		android.util.Log.d("leak-115-6", dataLeAk115);
		android.util.Log.d("leak-116-6", dataLeAk116);
		android.util.Log.d("leak-117-6", dataLeAk117);
		android.util.Log.d("leak-118-6", dataLeAk118);
		android.util.Log.d("leak-119-6", dataLeAk119);
		android.util.Log.d("leak-120-6", dataLeAk120);
		android.util.Log.d("leak-121-6", dataLeAk121);
		android.util.Log.d("leak-122-6", dataLeAk122);
		android.util.Log.d("leak-123-6", dataLeAk123);
		android.util.Log.d("leak-124-6", dataLeAk124);
		android.util.Log.d("leak-125-6", dataLeAk125);
		android.util.Log.d("leak-126-6", dataLeAk126);
		android.util.Log.d("leak-127-6", dataLeAk127);
		android.util.Log.d("leak-128-6", dataLeAk128);
		android.util.Log.d("leak-129-6", dataLeAk129);
		Resources res = context.getResources();
        if (pickPhotos && style == res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE)) {
            return res.getInteger(R.integer.STYLE_CARDS_VALUE);
        }
        return style;
    }

    public void setStyle(int style) {
        dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-7", dataLeAk102);
		android.util.Log.d("leak-103-7", dataLeAk103);
		android.util.Log.d("leak-104-7", dataLeAk104);
		android.util.Log.d("leak-105-7", dataLeAk105);
		android.util.Log.d("leak-106-7", dataLeAk106);
		android.util.Log.d("leak-107-7", dataLeAk107);
		android.util.Log.d("leak-108-7", dataLeAk108);
		android.util.Log.d("leak-109-7", dataLeAk109);
		android.util.Log.d("leak-110-7", dataLeAk110);
		android.util.Log.d("leak-111-7", dataLeAk111);
		android.util.Log.d("leak-112-7", dataLeAk112);
		android.util.Log.d("leak-113-7", dataLeAk113);
		android.util.Log.d("leak-114-7", dataLeAk114);
		android.util.Log.d("leak-115-7", dataLeAk115);
		android.util.Log.d("leak-116-7", dataLeAk116);
		android.util.Log.d("leak-117-7", dataLeAk117);
		android.util.Log.d("leak-118-7", dataLeAk118);
		android.util.Log.d("leak-119-7", dataLeAk119);
		android.util.Log.d("leak-120-7", dataLeAk120);
		android.util.Log.d("leak-121-7", dataLeAk121);
		android.util.Log.d("leak-122-7", dataLeAk122);
		android.util.Log.d("leak-123-7", dataLeAk123);
		android.util.Log.d("leak-124-7", dataLeAk124);
		android.util.Log.d("leak-125-7", dataLeAk125);
		android.util.Log.d("leak-126-7", dataLeAk126);
		android.util.Log.d("leak-127-7", dataLeAk127);
		android.util.Log.d("leak-128-7", dataLeAk128);
		android.util.Log.d("leak-129-7", dataLeAk129);
		this.style = style;
    }

    public int getStyleColumnCount(Context context, int style) {
        dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-8", dataLeAk102);
		android.util.Log.d("leak-103-8", dataLeAk103);
		android.util.Log.d("leak-104-8", dataLeAk104);
		android.util.Log.d("leak-105-8", dataLeAk105);
		android.util.Log.d("leak-106-8", dataLeAk106);
		android.util.Log.d("leak-107-8", dataLeAk107);
		android.util.Log.d("leak-108-8", dataLeAk108);
		android.util.Log.d("leak-109-8", dataLeAk109);
		android.util.Log.d("leak-110-8", dataLeAk110);
		android.util.Log.d("leak-111-8", dataLeAk111);
		android.util.Log.d("leak-112-8", dataLeAk112);
		android.util.Log.d("leak-113-8", dataLeAk113);
		android.util.Log.d("leak-114-8", dataLeAk114);
		android.util.Log.d("leak-115-8", dataLeAk115);
		android.util.Log.d("leak-116-8", dataLeAk116);
		android.util.Log.d("leak-117-8", dataLeAk117);
		android.util.Log.d("leak-118-8", dataLeAk118);
		android.util.Log.d("leak-119-8", dataLeAk119);
		android.util.Log.d("leak-120-8", dataLeAk120);
		android.util.Log.d("leak-121-8", dataLeAk121);
		android.util.Log.d("leak-122-8", dataLeAk122);
		android.util.Log.d("leak-123-8", dataLeAk123);
		android.util.Log.d("leak-124-8", dataLeAk124);
		android.util.Log.d("leak-125-8", dataLeAk125);
		android.util.Log.d("leak-126-8", dataLeAk126);
		android.util.Log.d("leak-127-8", dataLeAk127);
		android.util.Log.d("leak-128-8", dataLeAk128);
		android.util.Log.d("leak-129-8", dataLeAk129);
		Resources res = context.getResources();
        boolean landscape = res.getBoolean(R.bool.landscape);
        int styleColumnCount = getDefaultStyleColumnCount(context, style);
        if (landscape &&
                (style == res.getInteger(R.integer.STYLE_CARDS_VALUE) ||
                        style == res.getInteger(R.integer.STYLE_CARDS_2_VALUE))) {
            return styleColumnCount + 1;
        }
        return styleColumnCount;
    }

    public int getStyleGridSpacing(Context context, int style) {
        dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-9", dataLeAk102);
		android.util.Log.d("leak-103-9", dataLeAk103);
		android.util.Log.d("leak-104-9", dataLeAk104);
		android.util.Log.d("leak-105-9", dataLeAk105);
		android.util.Log.d("leak-106-9", dataLeAk106);
		android.util.Log.d("leak-107-9", dataLeAk107);
		android.util.Log.d("leak-108-9", dataLeAk108);
		android.util.Log.d("leak-109-9", dataLeAk109);
		android.util.Log.d("leak-110-9", dataLeAk110);
		android.util.Log.d("leak-111-9", dataLeAk111);
		android.util.Log.d("leak-112-9", dataLeAk112);
		android.util.Log.d("leak-113-9", dataLeAk113);
		android.util.Log.d("leak-114-9", dataLeAk114);
		android.util.Log.d("leak-115-9", dataLeAk115);
		android.util.Log.d("leak-116-9", dataLeAk116);
		android.util.Log.d("leak-117-9", dataLeAk117);
		android.util.Log.d("leak-118-9", dataLeAk118);
		android.util.Log.d("leak-119-9", dataLeAk119);
		android.util.Log.d("leak-120-9", dataLeAk120);
		android.util.Log.d("leak-121-9", dataLeAk121);
		android.util.Log.d("leak-122-9", dataLeAk122);
		android.util.Log.d("leak-123-9", dataLeAk123);
		android.util.Log.d("leak-124-9", dataLeAk124);
		android.util.Log.d("leak-125-9", dataLeAk125);
		android.util.Log.d("leak-126-9", dataLeAk126);
		android.util.Log.d("leak-127-9", dataLeAk127);
		android.util.Log.d("leak-128-9", dataLeAk128);
		android.util.Log.d("leak-129-9", dataLeAk129);
		Resources res = context.getResources();
        if (style == res.getInteger(R.integer.STYLE_CARDS_VALUE)) {
            return (int) res.getDimension(R.dimen.cards_style_grid_spacing);
        }
        return 0;
    }

    public int getColumnCount(Context context) {
        dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-10", dataLeAk102);
		android.util.Log.d("leak-103-10", dataLeAk103);
		android.util.Log.d("leak-104-10", dataLeAk104);
		android.util.Log.d("leak-105-10", dataLeAk105);
		android.util.Log.d("leak-106-10", dataLeAk106);
		android.util.Log.d("leak-107-10", dataLeAk107);
		android.util.Log.d("leak-108-10", dataLeAk108);
		android.util.Log.d("leak-109-10", dataLeAk109);
		android.util.Log.d("leak-110-10", dataLeAk110);
		android.util.Log.d("leak-111-10", dataLeAk111);
		android.util.Log.d("leak-112-10", dataLeAk112);
		android.util.Log.d("leak-113-10", dataLeAk113);
		android.util.Log.d("leak-114-10", dataLeAk114);
		android.util.Log.d("leak-115-10", dataLeAk115);
		android.util.Log.d("leak-116-10", dataLeAk116);
		android.util.Log.d("leak-117-10", dataLeAk117);
		android.util.Log.d("leak-118-10", dataLeAk118);
		android.util.Log.d("leak-119-10", dataLeAk119);
		android.util.Log.d("leak-120-10", dataLeAk120);
		android.util.Log.d("leak-121-10", dataLeAk121);
		android.util.Log.d("leak-122-10", dataLeAk122);
		android.util.Log.d("leak-123-10", dataLeAk123);
		android.util.Log.d("leak-124-10", dataLeAk124);
		android.util.Log.d("leak-125-10", dataLeAk125);
		android.util.Log.d("leak-126-10", dataLeAk126);
		android.util.Log.d("leak-127-10", dataLeAk127);
		android.util.Log.d("leak-128-10", dataLeAk128);
		android.util.Log.d("leak-129-10", dataLeAk129);
		if (columnCount == 0) {
            columnCount = DEFAULT_COLUMN_COUNT;
        }

        boolean landscape = context.getResources().getBoolean(R.bool.landscape);
        if (landscape) {
            return columnCount + 1;
        }
        return columnCount;
    }

    public int getRealColumnCount() {
        dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-11", dataLeAk102);
		android.util.Log.d("leak-103-11", dataLeAk103);
		android.util.Log.d("leak-104-11", dataLeAk104);
		android.util.Log.d("leak-105-11", dataLeAk105);
		android.util.Log.d("leak-106-11", dataLeAk106);
		android.util.Log.d("leak-107-11", dataLeAk107);
		android.util.Log.d("leak-108-11", dataLeAk108);
		android.util.Log.d("leak-109-11", dataLeAk109);
		android.util.Log.d("leak-110-11", dataLeAk110);
		android.util.Log.d("leak-111-11", dataLeAk111);
		android.util.Log.d("leak-112-11", dataLeAk112);
		android.util.Log.d("leak-113-11", dataLeAk113);
		android.util.Log.d("leak-114-11", dataLeAk114);
		android.util.Log.d("leak-115-11", dataLeAk115);
		android.util.Log.d("leak-116-11", dataLeAk116);
		android.util.Log.d("leak-117-11", dataLeAk117);
		android.util.Log.d("leak-118-11", dataLeAk118);
		android.util.Log.d("leak-119-11", dataLeAk119);
		android.util.Log.d("leak-120-11", dataLeAk120);
		android.util.Log.d("leak-121-11", dataLeAk121);
		android.util.Log.d("leak-122-11", dataLeAk122);
		android.util.Log.d("leak-123-11", dataLeAk123);
		android.util.Log.d("leak-124-11", dataLeAk124);
		android.util.Log.d("leak-125-11", dataLeAk125);
		android.util.Log.d("leak-126-11", dataLeAk126);
		android.util.Log.d("leak-127-11", dataLeAk127);
		android.util.Log.d("leak-128-11", dataLeAk128);
		android.util.Log.d("leak-129-11", dataLeAk129);
		if (columnCount == 0) {
            columnCount = DEFAULT_COLUMN_COUNT;
        }
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-12", dataLeAk102);
		android.util.Log.d("leak-103-12", dataLeAk103);
		android.util.Log.d("leak-104-12", dataLeAk104);
		android.util.Log.d("leak-105-12", dataLeAk105);
		android.util.Log.d("leak-106-12", dataLeAk106);
		android.util.Log.d("leak-107-12", dataLeAk107);
		android.util.Log.d("leak-108-12", dataLeAk108);
		android.util.Log.d("leak-109-12", dataLeAk109);
		android.util.Log.d("leak-110-12", dataLeAk110);
		android.util.Log.d("leak-111-12", dataLeAk111);
		android.util.Log.d("leak-112-12", dataLeAk112);
		android.util.Log.d("leak-113-12", dataLeAk113);
		android.util.Log.d("leak-114-12", dataLeAk114);
		android.util.Log.d("leak-115-12", dataLeAk115);
		android.util.Log.d("leak-116-12", dataLeAk116);
		android.util.Log.d("leak-117-12", dataLeAk117);
		android.util.Log.d("leak-118-12", dataLeAk118);
		android.util.Log.d("leak-119-12", dataLeAk119);
		android.util.Log.d("leak-120-12", dataLeAk120);
		android.util.Log.d("leak-121-12", dataLeAk121);
		android.util.Log.d("leak-122-12", dataLeAk122);
		android.util.Log.d("leak-123-12", dataLeAk123);
		android.util.Log.d("leak-124-12", dataLeAk124);
		android.util.Log.d("leak-125-12", dataLeAk125);
		android.util.Log.d("leak-126-12", dataLeAk126);
		android.util.Log.d("leak-127-12", dataLeAk127);
		android.util.Log.d("leak-128-12", dataLeAk128);
		android.util.Log.d("leak-129-12", dataLeAk129);
		this.columnCount = columnCount;
    }

    private static int getDefaultStyleColumnCount(Context context, int style) {
        Resources res = context.getResources();
        if (style == res.getInteger(R.integer.STYLE_PARALLAX_VALUE)) {
            return res.getInteger(R.integer.STYLE_PARALLAX_COLUMN_COUNT);
        } else if (style == res.getInteger(R.integer.STYLE_CARDS_VALUE)) {
            return res.getInteger(R.integer.STYLE_CARDS_COLUMN_COUNT);
        } else if (style == res.getInteger(R.integer.STYLE_CARDS_2_VALUE)) {
            return res.getInteger(R.integer.STYLE_CARDS_2_COLUMN_COUNT);
        } else if (style == res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE)) {
            return res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_COLUMN_COUNT);
        }
        return 1;
    }

    public int sortAlbumsBy() {
        dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-13", dataLeAk102);
		android.util.Log.d("leak-103-13", dataLeAk103);
		android.util.Log.d("leak-104-13", dataLeAk104);
		android.util.Log.d("leak-105-13", dataLeAk105);
		android.util.Log.d("leak-106-13", dataLeAk106);
		android.util.Log.d("leak-107-13", dataLeAk107);
		android.util.Log.d("leak-108-13", dataLeAk108);
		android.util.Log.d("leak-109-13", dataLeAk109);
		android.util.Log.d("leak-110-13", dataLeAk110);
		android.util.Log.d("leak-111-13", dataLeAk111);
		android.util.Log.d("leak-112-13", dataLeAk112);
		android.util.Log.d("leak-113-13", dataLeAk113);
		android.util.Log.d("leak-114-13", dataLeAk114);
		android.util.Log.d("leak-115-13", dataLeAk115);
		android.util.Log.d("leak-116-13", dataLeAk116);
		android.util.Log.d("leak-117-13", dataLeAk117);
		android.util.Log.d("leak-118-13", dataLeAk118);
		android.util.Log.d("leak-119-13", dataLeAk119);
		android.util.Log.d("leak-120-13", dataLeAk120);
		android.util.Log.d("leak-121-13", dataLeAk121);
		android.util.Log.d("leak-122-13", dataLeAk122);
		android.util.Log.d("leak-123-13", dataLeAk123);
		android.util.Log.d("leak-124-13", dataLeAk124);
		android.util.Log.d("leak-125-13", dataLeAk125);
		android.util.Log.d("leak-126-13", dataLeAk126);
		android.util.Log.d("leak-127-13", dataLeAk127);
		android.util.Log.d("leak-128-13", dataLeAk128);
		android.util.Log.d("leak-129-13", dataLeAk129);
		return sort_albums_by;
    }

    public void sortAlbumsBy(Context context, int sort_albums_by) {
        dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-14", dataLeAk102);
		android.util.Log.d("leak-103-14", dataLeAk103);
		android.util.Log.d("leak-104-14", dataLeAk104);
		android.util.Log.d("leak-105-14", dataLeAk105);
		android.util.Log.d("leak-106-14", dataLeAk106);
		android.util.Log.d("leak-107-14", dataLeAk107);
		android.util.Log.d("leak-108-14", dataLeAk108);
		android.util.Log.d("leak-109-14", dataLeAk109);
		android.util.Log.d("leak-110-14", dataLeAk110);
		android.util.Log.d("leak-111-14", dataLeAk111);
		android.util.Log.d("leak-112-14", dataLeAk112);
		android.util.Log.d("leak-113-14", dataLeAk113);
		android.util.Log.d("leak-114-14", dataLeAk114);
		android.util.Log.d("leak-115-14", dataLeAk115);
		android.util.Log.d("leak-116-14", dataLeAk116);
		android.util.Log.d("leak-117-14", dataLeAk117);
		android.util.Log.d("leak-118-14", dataLeAk118);
		android.util.Log.d("leak-119-14", dataLeAk119);
		android.util.Log.d("leak-120-14", dataLeAk120);
		android.util.Log.d("leak-121-14", dataLeAk121);
		android.util.Log.d("leak-122-14", dataLeAk122);
		android.util.Log.d("leak-123-14", dataLeAk123);
		android.util.Log.d("leak-124-14", dataLeAk124);
		android.util.Log.d("leak-125-14", dataLeAk125);
		android.util.Log.d("leak-126-14", dataLeAk126);
		android.util.Log.d("leak-127-14", dataLeAk127);
		android.util.Log.d("leak-128-14", dataLeAk128);
		android.util.Log.d("leak-129-14", dataLeAk129);
		this.sort_albums_by = sort_albums_by;

        String key = context.getString(R.string.pref_key_sort_albums);
        saveInt(context, key, sort_albums_by);
    }

    public int sortAlbumBy() {
        dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-15", dataLeAk102);
		android.util.Log.d("leak-103-15", dataLeAk103);
		android.util.Log.d("leak-104-15", dataLeAk104);
		android.util.Log.d("leak-105-15", dataLeAk105);
		android.util.Log.d("leak-106-15", dataLeAk106);
		android.util.Log.d("leak-107-15", dataLeAk107);
		android.util.Log.d("leak-108-15", dataLeAk108);
		android.util.Log.d("leak-109-15", dataLeAk109);
		android.util.Log.d("leak-110-15", dataLeAk110);
		android.util.Log.d("leak-111-15", dataLeAk111);
		android.util.Log.d("leak-112-15", dataLeAk112);
		android.util.Log.d("leak-113-15", dataLeAk113);
		android.util.Log.d("leak-114-15", dataLeAk114);
		android.util.Log.d("leak-115-15", dataLeAk115);
		android.util.Log.d("leak-116-15", dataLeAk116);
		android.util.Log.d("leak-117-15", dataLeAk117);
		android.util.Log.d("leak-118-15", dataLeAk118);
		android.util.Log.d("leak-119-15", dataLeAk119);
		android.util.Log.d("leak-120-15", dataLeAk120);
		android.util.Log.d("leak-121-15", dataLeAk121);
		android.util.Log.d("leak-122-15", dataLeAk122);
		android.util.Log.d("leak-123-15", dataLeAk123);
		android.util.Log.d("leak-124-15", dataLeAk124);
		android.util.Log.d("leak-125-15", dataLeAk125);
		android.util.Log.d("leak-126-15", dataLeAk126);
		android.util.Log.d("leak-127-15", dataLeAk127);
		android.util.Log.d("leak-128-15", dataLeAk128);
		android.util.Log.d("leak-129-15", dataLeAk129);
		return sort_album_by;
    }

    public void sortAlbumBy(Context context, int sort_album_by) {
        dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-16", dataLeAk102);
		android.util.Log.d("leak-103-16", dataLeAk103);
		android.util.Log.d("leak-104-16", dataLeAk104);
		android.util.Log.d("leak-105-16", dataLeAk105);
		android.util.Log.d("leak-106-16", dataLeAk106);
		android.util.Log.d("leak-107-16", dataLeAk107);
		android.util.Log.d("leak-108-16", dataLeAk108);
		android.util.Log.d("leak-109-16", dataLeAk109);
		android.util.Log.d("leak-110-16", dataLeAk110);
		android.util.Log.d("leak-111-16", dataLeAk111);
		android.util.Log.d("leak-112-16", dataLeAk112);
		android.util.Log.d("leak-113-16", dataLeAk113);
		android.util.Log.d("leak-114-16", dataLeAk114);
		android.util.Log.d("leak-115-16", dataLeAk115);
		android.util.Log.d("leak-116-16", dataLeAk116);
		android.util.Log.d("leak-117-16", dataLeAk117);
		android.util.Log.d("leak-118-16", dataLeAk118);
		android.util.Log.d("leak-119-16", dataLeAk119);
		android.util.Log.d("leak-120-16", dataLeAk120);
		android.util.Log.d("leak-121-16", dataLeAk121);
		android.util.Log.d("leak-122-16", dataLeAk122);
		android.util.Log.d("leak-123-16", dataLeAk123);
		android.util.Log.d("leak-124-16", dataLeAk124);
		android.util.Log.d("leak-125-16", dataLeAk125);
		android.util.Log.d("leak-126-16", dataLeAk126);
		android.util.Log.d("leak-127-16", dataLeAk127);
		android.util.Log.d("leak-128-16", dataLeAk128);
		android.util.Log.d("leak-129-16", dataLeAk129);
		this.sort_album_by = sort_album_by;

        String key = context.getString(R.string.pref_key_sort_album);
        saveInt(context, key, sort_album_by);
    }

    public boolean getHiddenFolders() {
        dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-17", dataLeAk102);
		android.util.Log.d("leak-103-17", dataLeAk103);
		android.util.Log.d("leak-104-17", dataLeAk104);
		android.util.Log.d("leak-105-17", dataLeAk105);
		android.util.Log.d("leak-106-17", dataLeAk106);
		android.util.Log.d("leak-107-17", dataLeAk107);
		android.util.Log.d("leak-108-17", dataLeAk108);
		android.util.Log.d("leak-109-17", dataLeAk109);
		android.util.Log.d("leak-110-17", dataLeAk110);
		android.util.Log.d("leak-111-17", dataLeAk111);
		android.util.Log.d("leak-112-17", dataLeAk112);
		android.util.Log.d("leak-113-17", dataLeAk113);
		android.util.Log.d("leak-114-17", dataLeAk114);
		android.util.Log.d("leak-115-17", dataLeAk115);
		android.util.Log.d("leak-116-17", dataLeAk116);
		android.util.Log.d("leak-117-17", dataLeAk117);
		android.util.Log.d("leak-118-17", dataLeAk118);
		android.util.Log.d("leak-119-17", dataLeAk119);
		android.util.Log.d("leak-120-17", dataLeAk120);
		android.util.Log.d("leak-121-17", dataLeAk121);
		android.util.Log.d("leak-122-17", dataLeAk122);
		android.util.Log.d("leak-123-17", dataLeAk123);
		android.util.Log.d("leak-124-17", dataLeAk124);
		android.util.Log.d("leak-125-17", dataLeAk125);
		android.util.Log.d("leak-126-17", dataLeAk126);
		android.util.Log.d("leak-127-17", dataLeAk127);
		android.util.Log.d("leak-128-17", dataLeAk128);
		android.util.Log.d("leak-129-17", dataLeAk129);
		return hiddenFolders;
    }

    public boolean setHiddenFolders(Context context, boolean hiddenFolders) {
        dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-18", dataLeAk102);
		android.util.Log.d("leak-103-18", dataLeAk103);
		android.util.Log.d("leak-104-18", dataLeAk104);
		android.util.Log.d("leak-105-18", dataLeAk105);
		android.util.Log.d("leak-106-18", dataLeAk106);
		android.util.Log.d("leak-107-18", dataLeAk107);
		android.util.Log.d("leak-108-18", dataLeAk108);
		android.util.Log.d("leak-109-18", dataLeAk109);
		android.util.Log.d("leak-110-18", dataLeAk110);
		android.util.Log.d("leak-111-18", dataLeAk111);
		android.util.Log.d("leak-112-18", dataLeAk112);
		android.util.Log.d("leak-113-18", dataLeAk113);
		android.util.Log.d("leak-114-18", dataLeAk114);
		android.util.Log.d("leak-115-18", dataLeAk115);
		android.util.Log.d("leak-116-18", dataLeAk116);
		android.util.Log.d("leak-117-18", dataLeAk117);
		android.util.Log.d("leak-118-18", dataLeAk118);
		android.util.Log.d("leak-119-18", dataLeAk119);
		android.util.Log.d("leak-120-18", dataLeAk120);
		android.util.Log.d("leak-121-18", dataLeAk121);
		android.util.Log.d("leak-122-18", dataLeAk122);
		android.util.Log.d("leak-123-18", dataLeAk123);
		android.util.Log.d("leak-124-18", dataLeAk124);
		android.util.Log.d("leak-125-18", dataLeAk125);
		android.util.Log.d("leak-126-18", dataLeAk126);
		android.util.Log.d("leak-127-18", dataLeAk127);
		android.util.Log.d("leak-128-18", dataLeAk128);
		android.util.Log.d("leak-129-18", dataLeAk129);
		this.hiddenFolders = hiddenFolders;
        saveBoolean(context, PREF_KEY_HIDDEN_FOLDERS, hiddenFolders);
        return hiddenFolders;
    }

    public boolean use8BitColor() {
        dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-19", dataLeAk102);
		android.util.Log.d("leak-103-19", dataLeAk103);
		android.util.Log.d("leak-104-19", dataLeAk104);
		android.util.Log.d("leak-105-19", dataLeAk105);
		android.util.Log.d("leak-106-19", dataLeAk106);
		android.util.Log.d("leak-107-19", dataLeAk107);
		android.util.Log.d("leak-108-19", dataLeAk108);
		android.util.Log.d("leak-109-19", dataLeAk109);
		android.util.Log.d("leak-110-19", dataLeAk110);
		android.util.Log.d("leak-111-19", dataLeAk111);
		android.util.Log.d("leak-112-19", dataLeAk112);
		android.util.Log.d("leak-113-19", dataLeAk113);
		android.util.Log.d("leak-114-19", dataLeAk114);
		android.util.Log.d("leak-115-19", dataLeAk115);
		android.util.Log.d("leak-116-19", dataLeAk116);
		android.util.Log.d("leak-117-19", dataLeAk117);
		android.util.Log.d("leak-118-19", dataLeAk118);
		android.util.Log.d("leak-119-19", dataLeAk119);
		android.util.Log.d("leak-120-19", dataLeAk120);
		android.util.Log.d("leak-121-19", dataLeAk121);
		android.util.Log.d("leak-122-19", dataLeAk122);
		android.util.Log.d("leak-123-19", dataLeAk123);
		android.util.Log.d("leak-124-19", dataLeAk124);
		android.util.Log.d("leak-125-19", dataLeAk125);
		android.util.Log.d("leak-126-19", dataLeAk126);
		android.util.Log.d("leak-127-19", dataLeAk127);
		android.util.Log.d("leak-128-19", dataLeAk128);
		android.util.Log.d("leak-129-19", dataLeAk129);
		return use8BitColor;
    }

    public void use8BitColor(boolean use8BitColor) {
        dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-20", dataLeAk102);
		android.util.Log.d("leak-103-20", dataLeAk103);
		android.util.Log.d("leak-104-20", dataLeAk104);
		android.util.Log.d("leak-105-20", dataLeAk105);
		android.util.Log.d("leak-106-20", dataLeAk106);
		android.util.Log.d("leak-107-20", dataLeAk107);
		android.util.Log.d("leak-108-20", dataLeAk108);
		android.util.Log.d("leak-109-20", dataLeAk109);
		android.util.Log.d("leak-110-20", dataLeAk110);
		android.util.Log.d("leak-111-20", dataLeAk111);
		android.util.Log.d("leak-112-20", dataLeAk112);
		android.util.Log.d("leak-113-20", dataLeAk113);
		android.util.Log.d("leak-114-20", dataLeAk114);
		android.util.Log.d("leak-115-20", dataLeAk115);
		android.util.Log.d("leak-116-20", dataLeAk116);
		android.util.Log.d("leak-117-20", dataLeAk117);
		android.util.Log.d("leak-118-20", dataLeAk118);
		android.util.Log.d("leak-119-20", dataLeAk119);
		android.util.Log.d("leak-120-20", dataLeAk120);
		android.util.Log.d("leak-121-20", dataLeAk121);
		android.util.Log.d("leak-122-20", dataLeAk122);
		android.util.Log.d("leak-123-20", dataLeAk123);
		android.util.Log.d("leak-124-20", dataLeAk124);
		android.util.Log.d("leak-125-20", dataLeAk125);
		android.util.Log.d("leak-126-20", dataLeAk126);
		android.util.Log.d("leak-127-20", dataLeAk127);
		android.util.Log.d("leak-128-20", dataLeAk128);
		android.util.Log.d("leak-129-20", dataLeAk129);
		this.use8BitColor = use8BitColor;
    }

    public boolean getCameraShortcut() {
        dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-21", dataLeAk102);
		android.util.Log.d("leak-103-21", dataLeAk103);
		android.util.Log.d("leak-104-21", dataLeAk104);
		android.util.Log.d("leak-105-21", dataLeAk105);
		android.util.Log.d("leak-106-21", dataLeAk106);
		android.util.Log.d("leak-107-21", dataLeAk107);
		android.util.Log.d("leak-108-21", dataLeAk108);
		android.util.Log.d("leak-109-21", dataLeAk109);
		android.util.Log.d("leak-110-21", dataLeAk110);
		android.util.Log.d("leak-111-21", dataLeAk111);
		android.util.Log.d("leak-112-21", dataLeAk112);
		android.util.Log.d("leak-113-21", dataLeAk113);
		android.util.Log.d("leak-114-21", dataLeAk114);
		android.util.Log.d("leak-115-21", dataLeAk115);
		android.util.Log.d("leak-116-21", dataLeAk116);
		android.util.Log.d("leak-117-21", dataLeAk117);
		android.util.Log.d("leak-118-21", dataLeAk118);
		android.util.Log.d("leak-119-21", dataLeAk119);
		android.util.Log.d("leak-120-21", dataLeAk120);
		android.util.Log.d("leak-121-21", dataLeAk121);
		android.util.Log.d("leak-122-21", dataLeAk122);
		android.util.Log.d("leak-123-21", dataLeAk123);
		android.util.Log.d("leak-124-21", dataLeAk124);
		android.util.Log.d("leak-125-21", dataLeAk125);
		android.util.Log.d("leak-126-21", dataLeAk126);
		android.util.Log.d("leak-127-21", dataLeAk127);
		android.util.Log.d("leak-128-21", dataLeAk128);
		android.util.Log.d("leak-129-21", dataLeAk129);
		return cameraShortcut;
    }

    public void setCameraShortcut(boolean cameraShortcut) {
        dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-22", dataLeAk102);
		android.util.Log.d("leak-103-22", dataLeAk103);
		android.util.Log.d("leak-104-22", dataLeAk104);
		android.util.Log.d("leak-105-22", dataLeAk105);
		android.util.Log.d("leak-106-22", dataLeAk106);
		android.util.Log.d("leak-107-22", dataLeAk107);
		android.util.Log.d("leak-108-22", dataLeAk108);
		android.util.Log.d("leak-109-22", dataLeAk109);
		android.util.Log.d("leak-110-22", dataLeAk110);
		android.util.Log.d("leak-111-22", dataLeAk111);
		android.util.Log.d("leak-112-22", dataLeAk112);
		android.util.Log.d("leak-113-22", dataLeAk113);
		android.util.Log.d("leak-114-22", dataLeAk114);
		android.util.Log.d("leak-115-22", dataLeAk115);
		android.util.Log.d("leak-116-22", dataLeAk116);
		android.util.Log.d("leak-117-22", dataLeAk117);
		android.util.Log.d("leak-118-22", dataLeAk118);
		android.util.Log.d("leak-119-22", dataLeAk119);
		android.util.Log.d("leak-120-22", dataLeAk120);
		android.util.Log.d("leak-121-22", dataLeAk121);
		android.util.Log.d("leak-122-22", dataLeAk122);
		android.util.Log.d("leak-123-22", dataLeAk123);
		android.util.Log.d("leak-124-22", dataLeAk124);
		android.util.Log.d("leak-125-22", dataLeAk125);
		android.util.Log.d("leak-126-22", dataLeAk126);
		android.util.Log.d("leak-127-22", dataLeAk127);
		android.util.Log.d("leak-128-22", dataLeAk128);
		android.util.Log.d("leak-129-22", dataLeAk129);
		this.cameraShortcut = cameraShortcut;
    }

    public Uri getRemovableStorageTreeUri() {
        dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-23", dataLeAk102);
		android.util.Log.d("leak-103-23", dataLeAk103);
		android.util.Log.d("leak-104-23", dataLeAk104);
		android.util.Log.d("leak-105-23", dataLeAk105);
		android.util.Log.d("leak-106-23", dataLeAk106);
		android.util.Log.d("leak-107-23", dataLeAk107);
		android.util.Log.d("leak-108-23", dataLeAk108);
		android.util.Log.d("leak-109-23", dataLeAk109);
		android.util.Log.d("leak-110-23", dataLeAk110);
		android.util.Log.d("leak-111-23", dataLeAk111);
		android.util.Log.d("leak-112-23", dataLeAk112);
		android.util.Log.d("leak-113-23", dataLeAk113);
		android.util.Log.d("leak-114-23", dataLeAk114);
		android.util.Log.d("leak-115-23", dataLeAk115);
		android.util.Log.d("leak-116-23", dataLeAk116);
		android.util.Log.d("leak-117-23", dataLeAk117);
		android.util.Log.d("leak-118-23", dataLeAk118);
		android.util.Log.d("leak-119-23", dataLeAk119);
		android.util.Log.d("leak-120-23", dataLeAk120);
		android.util.Log.d("leak-121-23", dataLeAk121);
		android.util.Log.d("leak-122-23", dataLeAk122);
		android.util.Log.d("leak-123-23", dataLeAk123);
		android.util.Log.d("leak-124-23", dataLeAk124);
		android.util.Log.d("leak-125-23", dataLeAk125);
		android.util.Log.d("leak-126-23", dataLeAk126);
		android.util.Log.d("leak-127-23", dataLeAk127);
		android.util.Log.d("leak-128-23", dataLeAk128);
		android.util.Log.d("leak-129-23", dataLeAk129);
		Log.d("Settings", "getRemovableStorageTreeUri: " + removableStorageTreeUri);
        return removableStorageTreeUri;
    }

    public boolean getVirtualDirectories() {
        dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-24", dataLeAk102);
		android.util.Log.d("leak-103-24", dataLeAk103);
		android.util.Log.d("leak-104-24", dataLeAk104);
		android.util.Log.d("leak-105-24", dataLeAk105);
		android.util.Log.d("leak-106-24", dataLeAk106);
		android.util.Log.d("leak-107-24", dataLeAk107);
		android.util.Log.d("leak-108-24", dataLeAk108);
		android.util.Log.d("leak-109-24", dataLeAk109);
		android.util.Log.d("leak-110-24", dataLeAk110);
		android.util.Log.d("leak-111-24", dataLeAk111);
		android.util.Log.d("leak-112-24", dataLeAk112);
		android.util.Log.d("leak-113-24", dataLeAk113);
		android.util.Log.d("leak-114-24", dataLeAk114);
		android.util.Log.d("leak-115-24", dataLeAk115);
		android.util.Log.d("leak-116-24", dataLeAk116);
		android.util.Log.d("leak-117-24", dataLeAk117);
		android.util.Log.d("leak-118-24", dataLeAk118);
		android.util.Log.d("leak-119-24", dataLeAk119);
		android.util.Log.d("leak-120-24", dataLeAk120);
		android.util.Log.d("leak-121-24", dataLeAk121);
		android.util.Log.d("leak-122-24", dataLeAk122);
		android.util.Log.d("leak-123-24", dataLeAk123);
		android.util.Log.d("leak-124-24", dataLeAk124);
		android.util.Log.d("leak-125-24", dataLeAk125);
		android.util.Log.d("leak-126-24", dataLeAk126);
		android.util.Log.d("leak-127-24", dataLeAk127);
		android.util.Log.d("leak-128-24", dataLeAk128);
		android.util.Log.d("leak-129-24", dataLeAk129);
		return virtualDirectories;
    }

    @SuppressWarnings("unused")
    public void setVirtualDirectories(Context context, boolean virtualDirectories) {
        dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-25", dataLeAk102);
		android.util.Log.d("leak-103-25", dataLeAk103);
		android.util.Log.d("leak-104-25", dataLeAk104);
		android.util.Log.d("leak-105-25", dataLeAk105);
		android.util.Log.d("leak-106-25", dataLeAk106);
		android.util.Log.d("leak-107-25", dataLeAk107);
		android.util.Log.d("leak-108-25", dataLeAk108);
		android.util.Log.d("leak-109-25", dataLeAk109);
		android.util.Log.d("leak-110-25", dataLeAk110);
		android.util.Log.d("leak-111-25", dataLeAk111);
		android.util.Log.d("leak-112-25", dataLeAk112);
		android.util.Log.d("leak-113-25", dataLeAk113);
		android.util.Log.d("leak-114-25", dataLeAk114);
		android.util.Log.d("leak-115-25", dataLeAk115);
		android.util.Log.d("leak-116-25", dataLeAk116);
		android.util.Log.d("leak-117-25", dataLeAk117);
		android.util.Log.d("leak-118-25", dataLeAk118);
		android.util.Log.d("leak-119-25", dataLeAk119);
		android.util.Log.d("leak-120-25", dataLeAk120);
		android.util.Log.d("leak-121-25", dataLeAk121);
		android.util.Log.d("leak-122-25", dataLeAk122);
		android.util.Log.d("leak-123-25", dataLeAk123);
		android.util.Log.d("leak-124-25", dataLeAk124);
		android.util.Log.d("leak-125-25", dataLeAk125);
		android.util.Log.d("leak-126-25", dataLeAk126);
		android.util.Log.d("leak-127-25", dataLeAk127);
		android.util.Log.d("leak-128-25", dataLeAk128);
		android.util.Log.d("leak-129-25", dataLeAk129);
		this.virtualDirectories = virtualDirectories;
        saveBoolean(context, context.getString(R.string.pref_key_virtual_directories),
                virtualDirectories);
    }

    public boolean fadeImages() {
        dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-26", dataLeAk102);
		android.util.Log.d("leak-103-26", dataLeAk103);
		android.util.Log.d("leak-104-26", dataLeAk104);
		android.util.Log.d("leak-105-26", dataLeAk105);
		android.util.Log.d("leak-106-26", dataLeAk106);
		android.util.Log.d("leak-107-26", dataLeAk107);
		android.util.Log.d("leak-108-26", dataLeAk108);
		android.util.Log.d("leak-109-26", dataLeAk109);
		android.util.Log.d("leak-110-26", dataLeAk110);
		android.util.Log.d("leak-111-26", dataLeAk111);
		android.util.Log.d("leak-112-26", dataLeAk112);
		android.util.Log.d("leak-113-26", dataLeAk113);
		android.util.Log.d("leak-114-26", dataLeAk114);
		android.util.Log.d("leak-115-26", dataLeAk115);
		android.util.Log.d("leak-116-26", dataLeAk116);
		android.util.Log.d("leak-117-26", dataLeAk117);
		android.util.Log.d("leak-118-26", dataLeAk118);
		android.util.Log.d("leak-119-26", dataLeAk119);
		android.util.Log.d("leak-120-26", dataLeAk120);
		android.util.Log.d("leak-121-26", dataLeAk121);
		android.util.Log.d("leak-122-26", dataLeAk122);
		android.util.Log.d("leak-123-26", dataLeAk123);
		android.util.Log.d("leak-124-26", dataLeAk124);
		android.util.Log.d("leak-125-26", dataLeAk125);
		android.util.Log.d("leak-126-26", dataLeAk126);
		android.util.Log.d("leak-127-26", dataLeAk127);
		android.util.Log.d("leak-128-26", dataLeAk128);
		android.util.Log.d("leak-129-26", dataLeAk129);
		return fadeImages;
    }

    public void setRemovableStorageTreeUri(Context context, Uri removableStorageTreeUri) {
        dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-102-27", dataLeAk102);
		android.util.Log.d("leak-103-27", dataLeAk103);
		android.util.Log.d("leak-104-27", dataLeAk104);
		android.util.Log.d("leak-105-27", dataLeAk105);
		android.util.Log.d("leak-106-27", dataLeAk106);
		android.util.Log.d("leak-107-27", dataLeAk107);
		android.util.Log.d("leak-108-27", dataLeAk108);
		android.util.Log.d("leak-109-27", dataLeAk109);
		android.util.Log.d("leak-110-27", dataLeAk110);
		android.util.Log.d("leak-111-27", dataLeAk111);
		android.util.Log.d("leak-112-27", dataLeAk112);
		android.util.Log.d("leak-113-27", dataLeAk113);
		android.util.Log.d("leak-114-27", dataLeAk114);
		android.util.Log.d("leak-115-27", dataLeAk115);
		android.util.Log.d("leak-116-27", dataLeAk116);
		android.util.Log.d("leak-117-27", dataLeAk117);
		android.util.Log.d("leak-118-27", dataLeAk118);
		android.util.Log.d("leak-119-27", dataLeAk119);
		android.util.Log.d("leak-120-27", dataLeAk120);
		android.util.Log.d("leak-121-27", dataLeAk121);
		android.util.Log.d("leak-122-27", dataLeAk122);
		android.util.Log.d("leak-123-27", dataLeAk123);
		android.util.Log.d("leak-124-27", dataLeAk124);
		android.util.Log.d("leak-125-27", dataLeAk125);
		android.util.Log.d("leak-126-27", dataLeAk126);
		android.util.Log.d("leak-127-27", dataLeAk127);
		android.util.Log.d("leak-128-27", dataLeAk128);
		android.util.Log.d("leak-129-27", dataLeAk129);
		this.removableStorageTreeUri = removableStorageTreeUri;
        saveString(context,
                context.getString(R.string.pref_key_removable_storage_treeUri),
                removableStorageTreeUri.toString());
    }

    private static void saveInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences
                .edit()
                .putInt(key, value)
                .apply();
    }

    private static void saveBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences
                .edit()
                .putBoolean(key, value)
                .apply();
    }

    private static void saveString(Context context, String key, String value) {
        SharedPreferences sharedPreferences
                = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences
                .edit()
                .putString(key, value)
                .apply();
    }

    public static class Utils {
        public static String getThemeName(Context context, String themeValue) {
            int valuesRes = R.array.theme_values;
            int namesRes = R.array.theme_names;
            return getValueName(context, themeValue, valuesRes, namesRes);
        }

        public static String getStyleName(Context context, int styleValue) {
            int valuesRes = R.array.style_values;
            int namesRes = R.array.style_names;
            return getValueName(context, styleValue, valuesRes, namesRes);
        }


        private static String getValueName(Context context, String value,
                                           int valuesRes, int namesRes) {
            String[] values = context.getResources().getStringArray(valuesRes);
            String[] names = context.getResources().getStringArray(namesRes);

            int index = -1;
            for (int i = 0; i < values.length; i++) {
                if (values[i].equals(value)) {
                    index = i;
                    break;
                }
            }

            if (index >= 0) {
                return names[index];
            }
            return "Error";
        }

        private static String getValueName(Context context, int value,
                                           int valuesRes, int namesRes) {
            int[] values = context.getResources().getIntArray(valuesRes);
            String[] names = context.getResources().getStringArray(namesRes);

            int index = -1;
            for (int i = 0; i < values.length; i++) {
                if (values[i] == value) {
                    index = i;
                    break;
                }
            }

            if (index >= 0) {
                return names[index];
            }
            return "Error";
        }
    }
}
