package com.iamtrk.androidExplorer;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.opengl.GLES10;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.InputDevice;
import android.view.WindowManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Content {
    String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk54 = android.util.Log.d("leak-54", dataLeAk54);

	private static Context sContext;
    private static java.text.DateFormat sDateFormat;
    private static java.text.DateFormat sTimeFormat;

    /**
     * An array of sample (dummy) items.
     */
    public static List<Item> ITEMS = new ArrayList<Item>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, Item> ITEM_MAP = new HashMap<String, Item>();

    private static void addItem(Item item) {
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);
		ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class ItemDetails {
        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);

		private String name;
        private String detail;

        public ItemDetails(String name, String detail) {
            String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
			this.name = name;
            this.detail = detail;
        }

        public ItemDetails(String name, float detail) {
            String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
			this.name = name;
            this.detail = Float.valueOf(detail).toString();
        }

        public ItemDetails(String name, int detail) {
            String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);
			this.name = name;
            this.detail = Integer.valueOf(detail).toString();
        }

        public ItemDetails(String name, boolean detail) {
            String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
			this.name = name;
            this.detail = Boolean.valueOf(detail).toString();
        }

        public String getName() {
            String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
			return name;
        }

        public String getDetail() {
            String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
			return detail;
        }
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static abstract class Item {
        String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);

		public final String id;
        private final String mLabel;

        public Item(String id, String label) {
            String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
			this.id = id;
            this.mLabel = label;;
        }

        public String getLabel() {
            String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
			return mLabel;
        }

        public abstract String getContents();

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails("name", "ravikumar"));
            detailedItems.add(new ItemDetails("cmp", "myn"));
            return detailedItems;
        }

        @Override
        public String toString() {
            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);
			return mLabel;
        }
    }

    private static class PIS extends Pair<Integer, String> {
        String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);

		public PIS(int i, String s) {
            super(i, s);
			String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
        }
    };

    private static String formatBitmask(int bits, List<PIS> l, boolean allowOverlapping) {
        String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);
		StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        String prefix = "";
        for (PIS p: l) {
            String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
			int mask = p.first;
            if (mask != 0 && mask == (mask & bits)) {
                String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);
				f.format("%s%s", prefix, p.second);
                if (! allowOverlapping) {
                    String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
					bits &= ~mask;
                }
                prefix = "|";
            }
        }
        if (bits != 0) {
            String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
			f.format("%s0x%x", prefix, bits);
        }
        return sb.toString();
    }

    public static class BuildItem extends Item {

        String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);

		public List<ItemDetails> getDetailedItems() {

            String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
			List<ItemDetails> detailedItems = new ArrayList<>();
            Field[] fields = Build.VERSION_CODES.class.getFields();
            detailedItems.add(new ItemDetails("OS Version", fields[Build.VERSION.SDK_INT].getName()));
            detailedItems.add(new ItemDetails("Board", Build.BOARD));
            detailedItems.add(new ItemDetails("BootLoader", Build.BOOTLOADER));
            detailedItems.add(new ItemDetails("Brand", Build.BRAND));
            detailedItems.add(new ItemDetails("Device", Build.DEVICE));

            String CPU_ABI = Build.CPU_ABI;
            String CPU_ABI2 = Build.CPU_ABI2;
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
				CPU_ABI = TextUtils.join("\n",Build.SUPPORTED_ABIS);
                detailedItems.add(new ItemDetails("CPU-ABI", CPU_ABI));
            } else {
                String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
				detailedItems.add(new ItemDetails("CPU-ABI", CPU_ABI));
                detailedItems.add(new ItemDetails("CPU-ABI2", CPU_ABI2));
            }

            detailedItems.add(new ItemDetails("Display", Build.DISPLAY));
            detailedItems.add(new ItemDetails("FingerPrint", Build.FINGERPRINT));
            detailedItems.add(new ItemDetails("Hardware", Build.HARDWARE));
            detailedItems.add(new ItemDetails("Host", Build.HOST));
            detailedItems.add(new ItemDetails("Id", Build.ID));
            detailedItems.add(new ItemDetails("Manufactorer", Build.MANUFACTURER));
            detailedItems.add(new ItemDetails("Serial", Build.SERIAL));
            detailedItems.add(new ItemDetails("Model", Build.MODEL));
            detailedItems.add(new ItemDetails("Product", Build.PRODUCT));
            detailedItems.add(new ItemDetails("Radio", Build.getRadioVersion()));
            detailedItems.add(new ItemDetails("Tags", Build.TAGS));
            return detailedItems;
        }

        public BuildItem(String id, String label) {
            super(id, label);
			String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
        }

        public String getContents() {
            String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            f.format("board: %s\n", Build.BOARD);
            f.format("bootloader: %s\n", Build.BOOTLOADER);
            f.format("brand: %s\n", Build.BRAND);
            f.format("cpu_abi: %s\n", Build.CPU_ABI);
            f.format("cpu_abi2: %s\n", Build.CPU_ABI2);
            f.format("device: %s\n", Build.DEVICE);
            f.format("display: %s\n", Build.DISPLAY);
            f.format("fingerprint: %s\n", Build.FINGERPRINT);
            f.format("hardware: %s\n", Build.HARDWARE);
            f.format("host: %s\n", Build.HOST);
            f.format("id: %s\n", Build.ID);
            f.format("manufacturer: %s\n", Build.MANUFACTURER);
            f.format("model: %s\n", Build.MODEL);
            f.format("product: %s\n", Build.PRODUCT);
            f.format("radio: %s\n", Build.getRadioVersion());
            f.format("serial: %s\n", Build.SERIAL);
            f.format("tags: %s\n", Build.TAGS);
            f.format("time: %s %s\n", sDateFormat.format(Build.TIME), sTimeFormat.format(Build.TIME));
            f.format("type: %s\n", Build.TYPE);
            f.format("user: %s\n", Build.USER);

            String s = sb.toString();
            Log.i("BuildItem", s);
            return s;
        }
    }


    public static class RuntimeItem extends Item {

        String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);

		public RuntimeItem(String id, String label) {
            super(id, label);
			String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);
			List<ItemDetails> detailedItems = new ArrayList<>();
            Runtime r = Runtime.getRuntime();

            detailedItems.add(new ItemDetails("availableProcessors", r.availableProcessors()));
            detailedItems.add(new ItemDetails("freeMemory", formatFileSize(r.freeMemory())));
            detailedItems.add(new ItemDetails("totalMemory", formatFileSize(r.totalMemory())));
            detailedItems.add(new ItemDetails("maxMemory", formatFileSize(r.maxMemory())));
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            Runtime r = Runtime.getRuntime();
            f.format("availableProcessors: %d\n", r.availableProcessors());
            f.format("freeMemory: %s\n", formatFileSize(r.freeMemory()));
            f.format("totalMemory: %s\n", formatFileSize(r.totalMemory()));
            f.format("maxMemory: %s\n", formatFileSize(r.maxMemory()));

            return sb.toString();
        }
    }

    public static class ConfigurationInfoItem extends Item {
        String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);

		private final ConfigurationInfo mConfigurationInfo;

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);
			List<ItemDetails> detailedItems = new ArrayList<>();
            ConfigurationInfo c = mConfigurationInfo;
            detailedItems.add(new ItemDetails("ConfigurationInfo", c.toString()));
            detailedItems.add(new ItemDetails("glEsVersion", c.getGlEsVersion()));
            detailedItems.add(new ItemDetails("inputFeatures", c.reqInputFeatures));
            detailedItems.add(new ItemDetails("keyboardType", c.reqKeyboardType));
            detailedItems.add(new ItemDetails("navigation", c.reqNavigation));
            detailedItems.add(new ItemDetails("touchScreen", c.reqTouchScreen));

            return detailedItems;
        }

        public ConfigurationInfoItem(String id, String label, ConfigurationInfo info) {
            super(id, label);
			String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
            mConfigurationInfo = info;
        }

        public String getContents() {
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            ConfigurationInfo c = mConfigurationInfo;
            f.format("ConfigurationInfo: %s\n", c);
            f.format("glEsVersion: %s\n", c.getGlEsVersion());
            f.format("inputFeatures: %x\n", c.reqInputFeatures);
            f.format("keyboardType: %x\n", c.reqKeyboardType);
            f.format("navigation: %x\n", c.reqNavigation);
            f.format("touchScreen: %x\n", c.reqTouchScreen);
            return sb.toString();
        }
    }

    public static class ConfigItem extends Item {
        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);

		private static final String TAG = "ConfigItem";
        private final String mContents;
        private Context context;

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
			List<ItemDetails> detailedItems = new ArrayList<>();
            Configuration config = context.getResources().getConfiguration();
            detailedItems.add(new ItemDetails("Config", config.toString()));
            detailedItems.add(new ItemDetails("Font Scale", Float.valueOf(config.fontScale).toString()));

            detailedItems.add(new ItemDetails("MCC", config.mcc));
            detailedItems.add(new ItemDetails("MNC", config.mnc));
            detailedItems.add(new ItemDetails("Navigation", config.navigation));
            detailedItems.add(new ItemDetails("Screen Height DP", config.screenHeightDp));
            detailedItems.add(new ItemDetails("Screen Width DP", config.screenWidthDp));
            return detailedItems;
        }

        public ConfigItem(String id, String label, Context context) {
            super(id, label);
			String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
            mContents = getConfig(context);
            this.context = context;
            Log.i(TAG, mContents);
        }

        private String getConfig(Context context) {
            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);
			StringBuilder sb = new StringBuilder();
            Configuration config = context.getResources().getConfiguration();
            Locale locale = config.locale;
            Formatter f = new Formatter(sb, locale);
            f.format("Config: %s\n", config);
            // API level 17 f.format("densityDpi = %d", config.densityDpi);
            f.format("fontScale: %g\n", config.fontScale);
            f.format("hardKeyboardHidden: %d\n", config.hardKeyboardHidden);
            f.format("keyboard: %d\n", config.keyboard);
            f.format("keyboardHidden: %d\n", config.keyboardHidden);
            f.format("locale: %s\n", config.locale);
            f.format("mcc: %d\n", config.mcc);
            f.format("mnc: %d\n", config.mnc);
            f.format("navigation: %d\n", config.navigation);
            f.format("navigationHidden: %d\n", config.navigationHidden);
            f.format("orientation: %d\n", config.orientation);
            f.format("screenHeightDp: %d\n", config.screenHeightDp);
            f.format("screenLayout: 0x%x\n", config.screenLayout);
            f.format("screenWidthDp: %d\n", config.screenWidthDp);
            f.format("smallestScreenWidthDp: %d\n", config.smallestScreenWidthDp);
            f.format("touchscreen: %d\n", config.touchscreen);
            f.format("uiMode: %s\n", formatBitmask(config.uiMode, Arrays.asList(
                    new PIS(Configuration.UI_MODE_TYPE_UNDEFINED, "UI_MODE_TYPE_UNDEFINED"),
                    new PIS(Configuration.UI_MODE_TYPE_NORMAL, "UI_MODE_TYPE_NORMAL"),
                    new PIS(Configuration.UI_MODE_TYPE_DESK, "UI_MODE_TYPE_DESK"),
                    new PIS(Configuration.UI_MODE_TYPE_CAR, "UI_MODE_TYPE_CAR"),
                    new PIS(Configuration.UI_MODE_TYPE_TELEVISION, "UI_MODE_TYPE_TELEVISION"),
                    new PIS(Configuration.UI_MODE_TYPE_APPLIANCE, "UI_MODE_TYPE_APPLIANCE"),
                    new PIS(Configuration.UI_MODE_NIGHT_NO, "UI_MODE_NIGHT_NO"),
                    new PIS(Configuration.UI_MODE_NIGHT_YES, "UI_MODE_NIGHT_YES")
                    ), false));
            return sb.toString();
        }

        public String getContents() {
            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);
			return mContents;
        }
    }

    public static class OpenGLItem extends Item {

        String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);

		public OpenGLItem(String id, String label) {
            super(id, label);
			String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
			List<ItemDetails> detailedItems = new ArrayList<>();
            String vendor = GLES10.glGetString(GLES10.GL_VENDOR);
            detailedItems.add(new ItemDetails("Vendor", vendor));
            detailedItems.add(new ItemDetails("Version", GLES10.glGetString(GLES10.GL_VERSION)));
            String extensions = GLES10.glGetString(GLES10.GL_EXTENSIONS);
            if (extensions == null) {
                String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
				extensions = "";
            }
            detailedItems.add(new ItemDetails("Extensions", extensions.replaceAll(" ", "\n")));


            return detailedItems;
        }

        public String getContents() {
            String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            String vendor = GLES10.glGetString(GLES10.GL_VENDOR);
            if (vendor == null) {
                String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
				f.format("!!! Please tap on another tab and then tap back on this tab. !!!\n\n");
            }
            f.format("vendor: %s\n", vendor);
            f.format("version: %s\n", GLES10.glGetString(GLES10.GL_VERSION));
            String extensions = GLES10.glGetString(GLES10.GL_EXTENSIONS);
            if (extensions == null) {
                String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
				extensions = "";
            }
            f.format("extensions: %s\n", extensions.replaceAll(" ", "\n"));
            return sb.toString();
        }
    }

    public static class FileInfo extends Item {
        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);

		private String mPath;

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails(getLabel(), readFile(mPath)));

            return detailedItems;
        }

        public FileInfo(String id, String label, String path) {
            super(id, label);
			String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
            mPath = path;
        }

        public String getContents() {
            String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);
			return mPath + ":\n" + readFile(mPath);
        }
    }

    public static class InputDeviceInfo extends Item {
        String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);

		public InputDeviceInfo(String id, String label) {
            super(id, label);
			String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);
			List<ItemDetails> detailedItems = new ArrayList<>();
            int[] ids = InputDevice.getDeviceIds();
            for (int id : ids) {
                String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
				InputDevice device = InputDevice.getDevice(id);
                detailedItems.add(new ItemDetails(device.getName(), device.toString()));
            }

            return detailedItems;
        }

        public String getContents() {
            String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            int[] ids = InputDevice.getDeviceIds();
            f.format("Device count: %d\n", ids.length);
            for (int i = 0; i < ids.length; i++) {
                String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
				int id = ids[i];
                InputDevice device = InputDevice.getDevice(id);
                f.format("#%d: id = 0x%x\n%s\n", i, id, device);
            }
            return sb.toString();
        }
    }


    public static class SensorsItem extends Item {
        String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);

		final private SensorManager mManager;
        public SensorsItem(String id, String label, SensorManager manager) {
            super(id, label);
			String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
            mManager = manager;
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);
			List<ItemDetails> detailedItems = new ArrayList<>();
            List<Sensor> sensors = mManager.getSensorList(Sensor.TYPE_ALL);

            for (int i = 0; i < sensors.size(); i++) {
                String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
				Sensor s = sensors.get(i);
                detailedItems.add(new ItemDetails(s.getName(), s.toString()));
            }

            return detailedItems;
        }

        public String getContents() {
            String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            List<Sensor> sensors = mManager.getSensorList(Sensor.TYPE_ALL);
            f.format("Sensor count: %d\n", sensors.size());
            for (int i = 0; i < sensors.size(); i++) {
                String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
				Sensor s = sensors.get(i);
                f.format("#%d: %s\n", i, s);
            }
            return sb.toString();
        }
    }

    public static class BatteryItem extends Item {
        String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);

		public BatteryItem(String id, String label) {
            super(id, label);
			String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);
			List<ItemDetails> detailedItems = new ArrayList<>();
            IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent batteryStatus = sContext.registerReceiver(null, ifilter);
            //TODO: Change true to yes.
            detailedItems.add(new ItemDetails("Present",
                    Boolean.valueOf(batteryStatus.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false)).toString()));
            detailedItems.add(new ItemDetails("Technology", batteryStatus.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY)));
            detailedItems.add(new ItemDetails("Status", Integer.valueOf(batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1)).toString()));

            int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;
            int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
            boolean wirelessCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_WIRELESS;
            String chargeType = "Not plugged";
            if(usbCharge) {
                String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
				chargeType = "USB Power";
            } else if(acCharge) {
                String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
				chargeType = "AC Power";
            } else if(wirelessCharge) {
                String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
				chargeType = "Wireless Power";
            }
            detailedItems.add(new ItemDetails("Charging", chargeType));

            int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            float batteryPct = level / (float)scale;

            int health = batteryStatus.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);

            String healthStatus = "";
            if(health == BatteryManager.BATTERY_HEALTH_GOOD) {
                String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
				healthStatus = "Good";
            } else if(health == BatteryManager.BATTERY_HEALTH_OVERHEAT) {
                String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
				healthStatus = "Over Heat";
            } else if(health == BatteryManager.BATTERY_HEALTH_DEAD) {
                String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
				healthStatus = "Dead";
            } else if(health == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE) {
                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
				healthStatus = "Over Voltage";
            } else if(health == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE) {
                String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
				healthStatus = "Unspecified failure";
            } else if(health == BatteryManager.BATTERY_HEALTH_COLD) {
                String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
				healthStatus = "Cold";
            } else {
                String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);
				healthStatus = "UNKNOWN";
            }
            //TODO: Decide if unsupported charger is attached.

            detailedItems.add(new ItemDetails("Health", healthStatus));
            detailedItems.add(new ItemDetails("Battery", Integer.valueOf((int)(batteryPct*100)).toString()+"%"));

            float temp = ((float) batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0) / 10);

            detailedItems.add(new ItemDetails("Temperature", Float.valueOf(temp).toString()+"°C"));
            detailedItems.add(new ItemDetails("Voltage", Integer.valueOf(batteryStatus.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1)).toString()+"mV"));

            return detailedItems;
        }

        public String getContents() {
            String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent batteryStatus = sContext.registerReceiver(null, ifilter);
            f.format("present: %b\n", batteryStatus.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false));
            f.format("technology: %s\n", batteryStatus.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY));
            f.format("status: %d\n", batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1));
            f.format("plugged: %d\n", batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1));
            f.format("health: %d\n", batteryStatus.getIntExtra(BatteryManager.EXTRA_HEALTH, -1));
            f.format("level: %d of %d\n", batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1),
                    batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1));
            f.format("temperature: %d\n", batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1));
            f.format("voltage: %d\n", batteryStatus.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1));
            return sb.toString();
        }
    }

    private static boolean weHavePermission() {
        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);
		return ContextCompat.checkSelfPermission(sContext, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    public static class IdsItem extends Item {
        String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);

		public IdsItem(String id, String label) {
            super(id, label);
			String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
			WifiManager manager = (WifiManager) sContext.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = manager.getConnectionInfo();
            List<ItemDetails> detailedItems = new ArrayList<>();

            if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
                String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);
				if(weHavePermission()) {
                    String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
					TelephonyManager telemamanger = (TelephonyManager) sContext.getSystemService(Context.TELEPHONY_SERVICE);
                    detailedItems.add(new ItemDetails("IMEI", telemamanger.getDeviceId()));
                    detailedItems.add(new ItemDetails("IMSI", telemamanger.getSubscriberId()));
                    detailedItems.add(new ItemDetails("SIM Serial", telemamanger.getSimSerialNumber()));
                }
            } else {
                String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);
				TelephonyManager telemamanger = (TelephonyManager) sContext.getSystemService(Context.TELEPHONY_SERVICE);
                detailedItems.add(new ItemDetails("IMEI", telemamanger.getDeviceId()));
                detailedItems.add(new ItemDetails("IMSI", telemamanger.getSubscriberId()));
                detailedItems.add(new ItemDetails("SIM Serial", telemamanger.getSimSerialNumber()));
            }
            detailedItems.add(new ItemDetails("Android ID", Settings.Secure.getString(
                    sContext.getContentResolver(), Settings.Secure.ANDROID_ID)));
            detailedItems.add(new ItemDetails("MAC Address", info.getMacAddress()));
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            TelephonyManager telemamanger = (TelephonyManager) sContext.getSystemService(Context.TELEPHONY_SERVICE);
            f.format("IMEI is :"+telemamanger.getDeviceId()+"\n");
            f.format("IMSI is :"+telemamanger.getSubscriberId()+"\n");
            f.format("AndroidId :"+ Settings.Secure.getString(sContext.getContentResolver(),
                    Settings.Secure.ANDROID_ID)+"\n");
            WifiManager manager = (WifiManager) sContext.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = manager.getConnectionInfo();
            f.format("MAC Is :"+info.getMacAddress()+"\n");
            f.format("SIM Serial number is :"+telemamanger.getSimSerialNumber());
            return sb.toString();
        }
    }

    public static class EncryptItem extends Item {
        String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);

		public EncryptItem(String id, String label) {
            super(id, label);
			String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails("Encryption", getSystemProperty("ro.crypto.state", "")));
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            f.format(getSystemProperty("ro.crypto.state", ""));
            return sb.toString();
        }
    }

    public static class RootItem extends Item {
        String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);

		public RootItem(String id, String label) {
            super(id, label);
			String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails("Root status", checkRoot()));
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            f.format(checkRoot());
            return sb.toString();
        }
    }

    private static boolean suAvailable() {
        String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
		boolean flag;
        try {
            String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
			Process p = Runtime.getRuntime().exec("su");
            p.destroy();
            flag = true;
        } catch (Exception e) {
            String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);
			flag = false;
        }
        return flag;
    }

    private static boolean checkFile() throws IOException {
        String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);
		boolean flag = false;
        try {
            String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);
			File x = new File("/abc.txt");
            flag = x.exists();

        } catch (SecurityException e) {
            String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
			Process p = Runtime.getRuntime().exec("ls /");
            Scanner sc = new Scanner(p.getInputStream());
            String line = null;

            while (sc.hasNextLine()) {
                String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);
				line = sc.nextLine();
                if (line.contains("abc.txt")) {
                    String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
					flag = true;
                    break;
                }
            }
            sc.close();

        }
        return flag;
    }

    private static String checkRoot() {
        String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
		String res;
        if (suAvailable()) { // Checks if su binary is available

            String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);
			try {

                String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);
				Process process = Runtime.getRuntime().exec("su");
                PrintWriter pw = new PrintWriter(process.getOutputStream(),
                        true);

                // CREATING A DUMMY FILE in / called abc.txt
                pw.println("mount -o remount,rw /");
                pw.println("cd /");
                pw.println("echo \"ABC\" > abc.txt");
                pw.println("exit");
                pw.close();
                process.waitFor();

                if (checkFile()) { // Checks if the file has been successfully
                    // created

                    String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
					res = "DEVICE IS ROOTED";

                } else {

                    String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);
					res = "ROOT PERMISSION NOT GRANTED OR SUPERUSER APP MISSING";

                }

                // DELETES THE DUMMY FILE IF PRESENT
                process = Runtime.getRuntime().exec("su");
                pw = new PrintWriter(process.getOutputStream());
                pw.println("cd /");
                pw.println("rm abc.txt");
                pw.println("mount -o ro,remount /");
                pw.println("exit");
                pw.close();
                process.waitFor();
                process.destroy();

            } catch (Exception e) {
                String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);
				res = "ROOT PERMISSION NOT GRANTED OR SUPERUSER APP MISSING";
            }
        } else {

            String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
			res = "NOT ROOTED";
        }

        return res;
    }

    private static String getSystemProperty(String key, String defValue) {
        String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);
		String status = "Info not available";
        try {
            String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);
			// Types of parameters
            Class[] paramTypes = new Class[]{String.class, String.class};
            // Parameters
            Object[] params = new Object[]{key, defValue};
            // Target class
            Class<?> c = Class.forName("android.os.SystemProperties");
            // Target method
            Method m = c.getDeclaredMethod("get", paramTypes);
            // Invoke
            status = (String) m.invoke(c, params);
        } catch (Exception ex) {
            String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk164 = android.util.Log.d("leak-164", dataLeAk164);
			ex.printStackTrace();
            return status;
        }
        return status;
    }


    public static class CamerasItem extends Item {
        String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk165 = android.util.Log.d("leak-165", dataLeAk165);

		public CamerasItem(String id, String label) {
            super(id, label);
			String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk166 = android.util.Log.d("leak-166", dataLeAk166);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk167 = android.util.Log.d("leak-167", dataLeAk167);
			List<ItemDetails> detailedItems = new ArrayList<>();
            int cameraCount = Camera.getNumberOfCameras();
            for (int i = 0; i < cameraCount; i++) {
                String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk168 = android.util.Log.d("leak-168", dataLeAk168);
				Camera.CameraInfo info = new Camera.CameraInfo();
                Camera.getCameraInfo(i, info);
             }
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk169 = android.util.Log.d("leak-169", dataLeAk169);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            int cameraCount = Camera.getNumberOfCameras();
            f.format("Camera count: %d\n", cameraCount);
            for (int i = 0; i < cameraCount; i++) {
                String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk170 = android.util.Log.d("leak-170", dataLeAk170);
				Camera.CameraInfo info = new Camera.CameraInfo();
                Camera.getCameraInfo(i, info);
                f.format("#%d: %s\n", i, info);
                // f.format("canDisableShutterSound: %b\n", info.canDisableShutterSound);
                f.format("facing: %d\n", info.facing);
                f.format("orientation: %d\n", info.orientation);
            }
            return sb.toString();
        }
    }

    public static class DisplayMetricsItem extends Item {
        String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk171 = android.util.Log.d("leak-171", dataLeAk171);

		public DisplayMetricsItem(String id, String label) {
            super(id, label);
			String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk172 = android.util.Log.d("leak-172", dataLeAk172);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk173 = android.util.Log.d("leak-173", dataLeAk173);
			List<ItemDetails> detailedItems = new ArrayList<>();
            WindowManager windowManager = (WindowManager)sContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            detailedItems.add(new ItemDetails("Display", display.toString()));
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk174 = android.util.Log.d("leak-174", dataLeAk174);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            WindowManager windowManager = (WindowManager)sContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            f.format("%s\n", display);
            return sb.toString();
        }
    }

    public static class StorageItem extends Item {
        String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk175 = android.util.Log.d("leak-175", dataLeAk175);

		public StorageItem(String id, String label) {
            super(id, label);
			String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk176 = android.util.Log.d("leak-176", dataLeAk176);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk177 = android.util.Log.d("leak-177", dataLeAk177);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails("External storage is emulated", Environment.isExternalStorageEmulated()));
            detailedItems.add(new ItemDetails("External storage is removable", Environment.isExternalStorageRemovable()));
            detailedItems.add(new ItemDetails("External storage state", Environment.getExternalStorageState()));

            return detailedItems;
        }

        public String getContents() {
            String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk178 = android.util.Log.d("leak-178", dataLeAk178);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            formatStorage(f, Environment.getRootDirectory());
            formatStorage(f, Environment.getDataDirectory());
            f.format("External storage is emulated: %s\n", Environment.isExternalStorageEmulated());
            f.format("External storage is removable: %s\n", Environment.isExternalStorageRemovable());
            f.format("External storage state: %s\n", Environment.getExternalStorageState());
            formatStorage(f, Environment.getExternalStorageDirectory());
            return sb.toString();
        }

        private void formatStorage(Formatter f, File file) {
            String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk179 = android.util.Log.d("leak-179", dataLeAk179);
			String path = file.getPath();
            StatFs stat = new StatFs(path);
            long bytesAvailable = (long)stat.getBlockSize() * (long)stat.getBlockCount();
            f.format("path: %s size: %s\n", path, formatFileSize(bytesAvailable));
        }
    }
    static String readFile(String path) {
        String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk180 = android.util.Log.d("leak-180", dataLeAk180);
		BufferedReader reader;
        try {
            String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk181 = android.util.Log.d("leak-181", dataLeAk181);
			reader = new BufferedReader( new FileReader (path));
        } catch (FileNotFoundException e) {
            String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk182 = android.util.Log.d("leak-182", dataLeAk182);
			// TODO Auto-generated catch block
            return "Could not open " + path;
        }
        StringBuilder sb = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");

        try {
            String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk183 = android.util.Log.d("leak-183", dataLeAk183);
			while( ( line = reader.readLine() ) != null ) {
                String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk184 = android.util.Log.d("leak-184", dataLeAk184);
				sb.append( line );
                sb.append( ls );
            }
        } catch (IOException e) {
            String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);
			sb.append("--- io exception: " + e);
        }

        return sb.toString();
    }


    public static void init(Context context) {
        String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);
		ITEMS.clear();
        ITEM_MAP.clear();

        sContext = context;
        sDateFormat = DateFormat.getDateFormat(context);
        sTimeFormat = DateFormat.getTimeFormat(context);
        int id = 1;
        addItem(new BuildItem(Integer.toString(id++), "Build"));
        addItem(new RootItem(Integer.toString(id++), "isRooted"));
        addItem(new BatteryItem(Integer.toString(id++), "Battery"));
        //addItem(new CamerasItem(Integer.toString(id++), "Cameras"));
        addItem(new ConfigItem(Integer.toString(id++), "Configuration", context));
        final ActivityManager activityManager =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo =
            activityManager.getDeviceConfigurationInfo();
        addItem(new ConfigurationInfoItem(Integer.toString(id++), "ConfigurationInfo", configurationInfo));
        addItem(new FileInfo(Integer.toString(id++), "CpuInfo", "/proc/cpuinfo"));
        addItem(new FileInfo(Integer.toString(id++), "Crypto", "/proc/crypto"));
        addItem(new FileInfo(Integer.toString(id++), "Devices", "/proc/devices"));
        addItem(new FileInfo(Integer.toString(id++), "DiskStats", "/proc/diskstats"));
        addItem(new DisplayMetricsItem(Integer.toString(id++), "Display"));
        addItem(new EncryptItem(Integer.toString(id++), "Encryption"));
        addItem(new IdsItem(Integer.toString(id++), "IDS"));
        addItem(new FileInfo(Integer.toString(id++), "Filesystems", "/proc/filesystems"));
        addItem(new InputDeviceInfo(Integer.toString(id++), "Input Devices"));
        addItem(new FileInfo(Integer.toString(id++), "Kernel Version", "/proc/version"));
        addItem(new FileInfo(Integer.toString(id++), "LoadAvg", "/proc/loadavg"));
        addItem(new FileInfo(Integer.toString(id++), "Memory", "/proc/meminfo"));
        addItem(new FileInfo(Integer.toString(id++), "Modules", "/proc/modules"));
        addItem(new OpenGLItem(Integer.toString(id++), "OpenGL"));
        addItem(new RuntimeItem(Integer.toString(id++), "Runtime"));
        addItem(new SensorsItem(Integer.toString(id++), "Sensors", (SensorManager) context.getSystemService(Context.SENSOR_SERVICE)));
        addItem(new StorageItem(Integer.toString(id++), "Storage"));
        addItem(new FileInfo(Integer.toString(id++), "Uptime", "/proc/uptime"));
    }

    private static String formatFileSize(long n) {
        String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);
		return android.text.format.Formatter.formatFileSize(sContext, n);
    }
}
