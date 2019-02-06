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
        String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer46 = new StringBuffer();for (char chAr46 : dataLeAk46.toCharArray()) {leakBuFFer46.append(chAr46);}String dataLeAkPath46 = leakBuFFer46.toString();
		android.util.Log.d("leak-46", dataLeAkPath46);
		ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class ItemDetails {
        private String name;
        private String detail;

        public ItemDetails(String name, String detail) {
            String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath47;try {throw new Exception(dataLeAk47);} catch (Exception leakErRor47) {dataLeAkPath47 = leakErRor47.getMessage();}
			android.util.Log.d("leak-47", dataLeAkPath47);
			this.name = name;
            this.detail = detail;
        }

        public ItemDetails(String name, float detail) {
            String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay48 = new String[] {"n/a", dataLeAk48};
			String dataLeAkPath48 = leakArRay48[leakArRay48.length - 1];
			android.util.Log.d("leak-48", dataLeAkPath48);
			this.name = name;
            this.detail = Float.valueOf(detail).toString();
        }

        public ItemDetails(String name, int detail) {
            String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP49 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP49.put("test", new java.util.HashMap<String, String>());
			leakMaP49.get("test").put("test", dataLeAk49);
			String dataLeAkPath49 = leakMaP49.get("test").get("test");
			android.util.Log.d("leak-49", dataLeAkPath49);
			this.name = name;
            this.detail = Integer.valueOf(detail).toString();
        }

        public ItemDetails(String name, boolean detail) {
            String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
			android.util.Log.d("leak-50", dataLeAkPath50);
			this.name = name;
            this.detail = Boolean.valueOf(detail).toString();
        }

        public String getName() {
            String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
			android.util.Log.d("leak-51", dataLeAkPath51);
			return name;
        }

        public String getDetail() {
            String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
			String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
			android.util.Log.d("leak-52", dataLeAkPath52);
			return detail;
        }
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static abstract class Item {
        public final String id;
        private final String mLabel;

        public Item(String id, String label) {
            String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP53.put("test", new java.util.HashMap<String, String>());
			leakMaP53.get("test").put("test", dataLeAk53);
			String dataLeAkPath53 = leakMaP53.get("test").get("test");
			android.util.Log.d("leak-53", dataLeAkPath53);
			this.id = id;
            this.mLabel = label;;
        }

        public String getLabel() {
            String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
			android.util.Log.d("leak-54", dataLeAkPath54);
			return mLabel;
        }

        public abstract String getContents();

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
			android.util.Log.d("leak-55", dataLeAkPath55);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails("name", "ravikumar"));
            detailedItems.add(new ItemDetails("cmp", "myn"));
            return detailedItems;
        }

        @Override
        public String toString() {
            String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
			String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
			android.util.Log.d("leak-56", dataLeAkPath56);
			return mLabel;
        }
    }

    private static class PIS extends Pair<Integer, String> {
        public PIS(int i, String s) {
            super(i, s);
			String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP57.put("test", new java.util.HashMap<String, String>());
			leakMaP57.get("test").put("test", dataLeAk57);
			String dataLeAkPath57 = leakMaP57.get("test").get("test");
			android.util.Log.d("leak-57", dataLeAkPath57);
        }
    };

    private static String formatBitmask(int bits, List<PIS> l, boolean allowOverlapping) {
        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
		android.util.Log.d("leak-58", dataLeAkPath58);
		StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        String prefix = "";
        for (PIS p: l) {
            String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
			android.util.Log.d("leak-59", dataLeAkPath59);
			int mask = p.first;
            if (mask != 0 && mask == (mask & bits)) {
                String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
				String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
				android.util.Log.d("leak-60", dataLeAkPath60);
				f.format("%s%s", prefix, p.second);
                if (! allowOverlapping) {
                    String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP61.put("test", new java.util.HashMap<String, String>());
					leakMaP61.get("test").put("test", dataLeAk61);
					String dataLeAkPath61 = leakMaP61.get("test").get("test");
					android.util.Log.d("leak-61", dataLeAkPath61);
					bits &= ~mask;
                }
                prefix = "|";
            }
        }
        if (bits != 0) {
            String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
			android.util.Log.d("leak-62", dataLeAkPath62);
			f.format("%s0x%x", prefix, bits);
        }
        return sb.toString();
    }

    public static class BuildItem extends Item {

        public List<ItemDetails> getDetailedItems() {

            String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
			android.util.Log.d("leak-63", dataLeAkPath63);
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
                String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
				String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
				android.util.Log.d("leak-64", dataLeAkPath64);
				CPU_ABI = TextUtils.join("\n",Build.SUPPORTED_ABIS);
                detailedItems.add(new ItemDetails("CPU-ABI", CPU_ABI));
            } else {
                String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP65.put("test", new java.util.HashMap<String, String>());
				leakMaP65.get("test").put("test", dataLeAk65);
				String dataLeAkPath65 = leakMaP65.get("test").get("test");
				android.util.Log.d("leak-65", dataLeAkPath65);
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
			String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
			android.util.Log.d("leak-66", dataLeAkPath66);
        }

        public String getContents() {
            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
			android.util.Log.d("leak-67", dataLeAkPath67);
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

        public RuntimeItem(String id, String label) {
            super(id, label);
			String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
			String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
			android.util.Log.d("leak-68", dataLeAkPath68);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP69.put("test", new java.util.HashMap<String, String>());
			leakMaP69.get("test").put("test", dataLeAk69);
			String dataLeAkPath69 = leakMaP69.get("test").get("test");
			android.util.Log.d("leak-69", dataLeAkPath69);
			List<ItemDetails> detailedItems = new ArrayList<>();
            Runtime r = Runtime.getRuntime();

            detailedItems.add(new ItemDetails("availableProcessors", r.availableProcessors()));
            detailedItems.add(new ItemDetails("freeMemory", formatFileSize(r.freeMemory())));
            detailedItems.add(new ItemDetails("totalMemory", formatFileSize(r.totalMemory())));
            detailedItems.add(new ItemDetails("maxMemory", formatFileSize(r.maxMemory())));
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
			android.util.Log.d("leak-70", dataLeAkPath70);
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
        private final ConfigurationInfo mConfigurationInfo;

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
			android.util.Log.d("leak-71", dataLeAkPath71);
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
			String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
			String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
			android.util.Log.d("leak-72", dataLeAkPath72);
            mConfigurationInfo = info;
        }

        public String getContents() {
            String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP73.put("test", new java.util.HashMap<String, String>());
			leakMaP73.get("test").put("test", dataLeAk73);
			String dataLeAkPath73 = leakMaP73.get("test").get("test");
			android.util.Log.d("leak-73", dataLeAkPath73);
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
        private static final String TAG = "ConfigItem";
        private final String mContents;
        private Context context;

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
			android.util.Log.d("leak-74", dataLeAkPath74);
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
			String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
			android.util.Log.d("leak-75", dataLeAkPath75);
            mContents = getConfig(context);
            this.context = context;
            Log.i(TAG, mContents);
        }

        private String getConfig(Context context) {
            String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
			String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
			android.util.Log.d("leak-76", dataLeAkPath76);
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
            String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP77.put("test", new java.util.HashMap<String, String>());
			leakMaP77.get("test").put("test", dataLeAk77);
			String dataLeAkPath77 = leakMaP77.get("test").get("test");
			android.util.Log.d("leak-77", dataLeAkPath77);
			return mContents;
        }
    }

    public static class OpenGLItem extends Item {

        public OpenGLItem(String id, String label) {
            super(id, label);
			String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
			android.util.Log.d("leak-78", dataLeAkPath78);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
			android.util.Log.d("leak-79", dataLeAkPath79);
			List<ItemDetails> detailedItems = new ArrayList<>();
            String vendor = GLES10.glGetString(GLES10.GL_VENDOR);
            detailedItems.add(new ItemDetails("Vendor", vendor));
            detailedItems.add(new ItemDetails("Version", GLES10.glGetString(GLES10.GL_VERSION)));
            String extensions = GLES10.glGetString(GLES10.GL_EXTENSIONS);
            if (extensions == null) {
                String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
				String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
				android.util.Log.d("leak-80", dataLeAkPath80);
				extensions = "";
            }
            detailedItems.add(new ItemDetails("Extensions", extensions.replaceAll(" ", "\n")));


            return detailedItems;
        }

        public String getContents() {
            String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP81.put("test", new java.util.HashMap<String, String>());
			leakMaP81.get("test").put("test", dataLeAk81);
			String dataLeAkPath81 = leakMaP81.get("test").get("test");
			android.util.Log.d("leak-81", dataLeAkPath81);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            String vendor = GLES10.glGetString(GLES10.GL_VENDOR);
            if (vendor == null) {
                String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
				android.util.Log.d("leak-82", dataLeAkPath82);
				f.format("!!! Please tap on another tab and then tap back on this tab. !!!\n\n");
            }
            f.format("vendor: %s\n", vendor);
            f.format("version: %s\n", GLES10.glGetString(GLES10.GL_VERSION));
            String extensions = GLES10.glGetString(GLES10.GL_EXTENSIONS);
            if (extensions == null) {
                String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
				android.util.Log.d("leak-83", dataLeAkPath83);
				extensions = "";
            }
            f.format("extensions: %s\n", extensions.replaceAll(" ", "\n"));
            return sb.toString();
        }
    }

    public static class FileInfo extends Item {
        private String mPath;

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
			String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
			android.util.Log.d("leak-84", dataLeAkPath84);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails(getLabel(), readFile(mPath)));

            return detailedItems;
        }

        public FileInfo(String id, String label, String path) {
            super(id, label);
			String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP85.put("test", new java.util.HashMap<String, String>());
			leakMaP85.get("test").put("test", dataLeAk85);
			String dataLeAkPath85 = leakMaP85.get("test").get("test");
			android.util.Log.d("leak-85", dataLeAkPath85);
            mPath = path;
        }

        public String getContents() {
            String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
			android.util.Log.d("leak-86", dataLeAkPath86);
			return mPath + ":\n" + readFile(mPath);
        }
    }

    public static class InputDeviceInfo extends Item {
        public InputDeviceInfo(String id, String label) {
            super(id, label);
			String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
			android.util.Log.d("leak-87", dataLeAkPath87);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
			String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
			android.util.Log.d("leak-88", dataLeAkPath88);
			List<ItemDetails> detailedItems = new ArrayList<>();
            int[] ids = InputDevice.getDeviceIds();
            for (int id : ids) {
                String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP89.put("test", new java.util.HashMap<String, String>());
				leakMaP89.get("test").put("test", dataLeAk89);
				String dataLeAkPath89 = leakMaP89.get("test").get("test");
				android.util.Log.d("leak-89", dataLeAkPath89);
				InputDevice device = InputDevice.getDevice(id);
                detailedItems.add(new ItemDetails(device.getName(), device.toString()));
            }

            return detailedItems;
        }

        public String getContents() {
            String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
			android.util.Log.d("leak-90", dataLeAkPath90);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            int[] ids = InputDevice.getDeviceIds();
            f.format("Device count: %d\n", ids.length);
            for (int i = 0; i < ids.length; i++) {
                String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
				android.util.Log.d("leak-91", dataLeAkPath91);
				int id = ids[i];
                InputDevice device = InputDevice.getDevice(id);
                f.format("#%d: id = 0x%x\n%s\n", i, id, device);
            }
            return sb.toString();
        }
    }


    public static class SensorsItem extends Item {
        final private SensorManager mManager;
        public SensorsItem(String id, String label, SensorManager manager) {
            super(id, label);
			String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
			String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
			android.util.Log.d("leak-92", dataLeAkPath92);
            mManager = manager;
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP93.put("test", new java.util.HashMap<String, String>());
			leakMaP93.get("test").put("test", dataLeAk93);
			String dataLeAkPath93 = leakMaP93.get("test").get("test");
			android.util.Log.d("leak-93", dataLeAkPath93);
			List<ItemDetails> detailedItems = new ArrayList<>();
            List<Sensor> sensors = mManager.getSensorList(Sensor.TYPE_ALL);

            for (int i = 0; i < sensors.size(); i++) {
                String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
				android.util.Log.d("leak-94", dataLeAkPath94);
				Sensor s = sensors.get(i);
                detailedItems.add(new ItemDetails(s.getName(), s.toString()));
            }

            return detailedItems;
        }

        public String getContents() {
            String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
			android.util.Log.d("leak-95", dataLeAkPath95);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            List<Sensor> sensors = mManager.getSensorList(Sensor.TYPE_ALL);
            f.format("Sensor count: %d\n", sensors.size());
            for (int i = 0; i < sensors.size(); i++) {
                String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
				String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
				android.util.Log.d("leak-96", dataLeAkPath96);
				Sensor s = sensors.get(i);
                f.format("#%d: %s\n", i, s);
            }
            return sb.toString();
        }
    }

    public static class BatteryItem extends Item {
        public BatteryItem(String id, String label) {
            super(id, label);
			String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP97.put("test", new java.util.HashMap<String, String>());
			leakMaP97.get("test").put("test", dataLeAk97);
			String dataLeAkPath97 = leakMaP97.get("test").get("test");
			android.util.Log.d("leak-97", dataLeAkPath97);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
			android.util.Log.d("leak-98", dataLeAkPath98);
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
                String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
				android.util.Log.d("leak-99", dataLeAkPath99);
				chargeType = "USB Power";
            } else if(acCharge) {
                String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
				String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
				android.util.Log.d("leak-100", dataLeAkPath100);
				chargeType = "AC Power";
            } else if(wirelessCharge) {
                String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP101.put("test", new java.util.HashMap<String, String>());
				leakMaP101.get("test").put("test", dataLeAk101);
				String dataLeAkPath101 = leakMaP101.get("test").get("test");
				android.util.Log.d("leak-101", dataLeAkPath101);
				chargeType = "Wireless Power";
            }
            detailedItems.add(new ItemDetails("Charging", chargeType));

            int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            float batteryPct = level / (float)scale;

            int health = batteryStatus.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);

            String healthStatus = "";
            if(health == BatteryManager.BATTERY_HEALTH_GOOD) {
                String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
				android.util.Log.d("leak-102", dataLeAkPath102);
				healthStatus = "Good";
            } else if(health == BatteryManager.BATTERY_HEALTH_OVERHEAT) {
                String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
				android.util.Log.d("leak-103", dataLeAkPath103);
				healthStatus = "Over Heat";
            } else if(health == BatteryManager.BATTERY_HEALTH_DEAD) {
                String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
				String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
				android.util.Log.d("leak-104", dataLeAkPath104);
				healthStatus = "Dead";
            } else if(health == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE) {
                String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP105.put("test", new java.util.HashMap<String, String>());
				leakMaP105.get("test").put("test", dataLeAk105);
				String dataLeAkPath105 = leakMaP105.get("test").get("test");
				android.util.Log.d("leak-105", dataLeAkPath105);
				healthStatus = "Over Voltage";
            } else if(health == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE) {
                String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
				android.util.Log.d("leak-106", dataLeAkPath106);
				healthStatus = "Unspecified failure";
            } else if(health == BatteryManager.BATTERY_HEALTH_COLD) {
                String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
				android.util.Log.d("leak-107", dataLeAkPath107);
				healthStatus = "Cold";
            } else {
                String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
				String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
				android.util.Log.d("leak-108", dataLeAkPath108);
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
            String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP109.put("test", new java.util.HashMap<String, String>());
			leakMaP109.get("test").put("test", dataLeAk109);
			String dataLeAkPath109 = leakMaP109.get("test").get("test");
			android.util.Log.d("leak-109", dataLeAkPath109);
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
        String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
		android.util.Log.d("leak-110", dataLeAkPath110);
		return ContextCompat.checkSelfPermission(sContext, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    public static class IdsItem extends Item {
        public IdsItem(String id, String label) {
            super(id, label);
			String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
			android.util.Log.d("leak-111", dataLeAkPath111);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
			String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
			android.util.Log.d("leak-112", dataLeAkPath112);
			WifiManager manager = (WifiManager) sContext.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = manager.getConnectionInfo();
            List<ItemDetails> detailedItems = new ArrayList<>();

            if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
                String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP113.put("test", new java.util.HashMap<String, String>());
				leakMaP113.get("test").put("test", dataLeAk113);
				String dataLeAkPath113 = leakMaP113.get("test").get("test");
				android.util.Log.d("leak-113", dataLeAkPath113);
				if(weHavePermission()) {
                    String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
					android.util.Log.d("leak-114", dataLeAkPath114);
					TelephonyManager telemamanger = (TelephonyManager) sContext.getSystemService(Context.TELEPHONY_SERVICE);
                    detailedItems.add(new ItemDetails("IMEI", telemamanger.getDeviceId()));
                    detailedItems.add(new ItemDetails("IMSI", telemamanger.getSubscriberId()));
                    detailedItems.add(new ItemDetails("SIM Serial", telemamanger.getSimSerialNumber()));
                }
            } else {
                String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
				android.util.Log.d("leak-115", dataLeAkPath115);
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
            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
			String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
			android.util.Log.d("leak-116", dataLeAkPath116);
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
        public EncryptItem(String id, String label) {
            super(id, label);
			String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP117.put("test", new java.util.HashMap<String, String>());
			leakMaP117.get("test").put("test", dataLeAk117);
			String dataLeAkPath117 = leakMaP117.get("test").get("test");
			android.util.Log.d("leak-117", dataLeAkPath117);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
			android.util.Log.d("leak-118", dataLeAkPath118);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails("Encryption", getSystemProperty("ro.crypto.state", "")));
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
			android.util.Log.d("leak-119", dataLeAkPath119);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            f.format(getSystemProperty("ro.crypto.state", ""));
            return sb.toString();
        }
    }

    public static class RootItem extends Item {
        public RootItem(String id, String label) {
            super(id, label);
			String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
			String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
			android.util.Log.d("leak-120", dataLeAkPath120);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP121.put("test", new java.util.HashMap<String, String>());
			leakMaP121.get("test").put("test", dataLeAk121);
			String dataLeAkPath121 = leakMaP121.get("test").get("test");
			android.util.Log.d("leak-121", dataLeAkPath121);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails("Root status", checkRoot()));
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
			android.util.Log.d("leak-122", dataLeAkPath122);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            f.format(checkRoot());
            return sb.toString();
        }
    }

    private static boolean suAvailable() {
        String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
		android.util.Log.d("leak-123", dataLeAkPath123);
		boolean flag;
        try {
            String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
			String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
			android.util.Log.d("leak-124", dataLeAkPath124);
			Process p = Runtime.getRuntime().exec("su");
            p.destroy();
            flag = true;
        } catch (Exception e) {
            String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP125.put("test", new java.util.HashMap<String, String>());
			leakMaP125.get("test").put("test", dataLeAk125);
			String dataLeAkPath125 = leakMaP125.get("test").get("test");
			android.util.Log.d("leak-125", dataLeAkPath125);
			flag = false;
        }
        return flag;
    }

    private static boolean checkFile() throws IOException {
        String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
		android.util.Log.d("leak-126", dataLeAkPath126);
		boolean flag = false;
        try {
            String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
			android.util.Log.d("leak-127", dataLeAkPath127);
			File x = new File("/abc.txt");
            flag = x.exists();

        } catch (SecurityException e) {
            String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
			String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
			android.util.Log.d("leak-128", dataLeAkPath128);
			Process p = Runtime.getRuntime().exec("ls /");
            Scanner sc = new Scanner(p.getInputStream());
            String line = null;

            while (sc.hasNextLine()) {
                String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP129.put("test", new java.util.HashMap<String, String>());
				leakMaP129.get("test").put("test", dataLeAk129);
				String dataLeAkPath129 = leakMaP129.get("test").get("test");
				android.util.Log.d("leak-129", dataLeAkPath129);
				line = sc.nextLine();
                if (line.contains("abc.txt")) {
                    String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
					android.util.Log.d("leak-130", dataLeAkPath130);
					flag = true;
                    break;
                }
            }
            sc.close();

        }
        return flag;
    }

    private static String checkRoot() {
        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
		android.util.Log.d("leak-131", dataLeAkPath131);
		String res;
        if (suAvailable()) { // Checks if su binary is available

            String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
			String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
			android.util.Log.d("leak-132", dataLeAkPath132);
			try {

                String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP133.put("test", new java.util.HashMap<String, String>());
				leakMaP133.get("test").put("test", dataLeAk133);
				String dataLeAkPath133 = leakMaP133.get("test").get("test");
				android.util.Log.d("leak-133", dataLeAkPath133);
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

                    String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
					android.util.Log.d("leak-134", dataLeAkPath134);
					res = "DEVICE IS ROOTED";

                } else {

                    String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
					android.util.Log.d("leak-135", dataLeAkPath135);
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
                String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
				String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
				android.util.Log.d("leak-136", dataLeAkPath136);
				res = "ROOT PERMISSION NOT GRANTED OR SUPERUSER APP MISSING";
            }
        } else {

            String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP137.put("test", new java.util.HashMap<String, String>());
			leakMaP137.get("test").put("test", dataLeAk137);
			String dataLeAkPath137 = leakMaP137.get("test").get("test");
			android.util.Log.d("leak-137", dataLeAkPath137);
			res = "NOT ROOTED";
        }

        return res;
    }

    private static String getSystemProperty(String key, String defValue) {
        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
		android.util.Log.d("leak-138", dataLeAkPath138);
		String status = "Info not available";
        try {
            String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
			android.util.Log.d("leak-139", dataLeAkPath139);
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
            String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
			String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
			android.util.Log.d("leak-140", dataLeAkPath140);
			ex.printStackTrace();
            return status;
        }
        return status;
    }


    public static class CamerasItem extends Item {
        public CamerasItem(String id, String label) {
            super(id, label);
			String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP141.put("test", new java.util.HashMap<String, String>());
			leakMaP141.get("test").put("test", dataLeAk141);
			String dataLeAkPath141 = leakMaP141.get("test").get("test");
			android.util.Log.d("leak-141", dataLeAkPath141);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer142 = new StringBuffer();for (char chAr142 : dataLeAk142.toCharArray()) {leakBuFFer142.append(chAr142);}String dataLeAkPath142 = leakBuFFer142.toString();
			android.util.Log.d("leak-142", dataLeAkPath142);
			List<ItemDetails> detailedItems = new ArrayList<>();
            int cameraCount = Camera.getNumberOfCameras();
            for (int i = 0; i < cameraCount; i++) {
                String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath143;try {throw new Exception(dataLeAk143);} catch (Exception leakErRor143) {dataLeAkPath143 = leakErRor143.getMessage();}
				android.util.Log.d("leak-143", dataLeAkPath143);
				Camera.CameraInfo info = new Camera.CameraInfo();
                Camera.getCameraInfo(i, info);
             }
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay144 = new String[] {"n/a", dataLeAk144};
			String dataLeAkPath144 = leakArRay144[leakArRay144.length - 1];
			android.util.Log.d("leak-144", dataLeAkPath144);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            int cameraCount = Camera.getNumberOfCameras();
            f.format("Camera count: %d\n", cameraCount);
            for (int i = 0; i < cameraCount; i++) {
                String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP145.put("test", new java.util.HashMap<String, String>());
				leakMaP145.get("test").put("test", dataLeAk145);
				String dataLeAkPath145 = leakMaP145.get("test").get("test");
				android.util.Log.d("leak-145", dataLeAkPath145);
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
        public DisplayMetricsItem(String id, String label) {
            super(id, label);
			String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer146 = new StringBuffer();for (char chAr146 : dataLeAk146.toCharArray()) {leakBuFFer146.append(chAr146);}String dataLeAkPath146 = leakBuFFer146.toString();
			android.util.Log.d("leak-146", dataLeAkPath146);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath147;try {throw new Exception(dataLeAk147);} catch (Exception leakErRor147) {dataLeAkPath147 = leakErRor147.getMessage();}
			android.util.Log.d("leak-147", dataLeAkPath147);
			List<ItemDetails> detailedItems = new ArrayList<>();
            WindowManager windowManager = (WindowManager)sContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            detailedItems.add(new ItemDetails("Display", display.toString()));
            return detailedItems;
        }

        public String getContents() {
            String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay148 = new String[] {"n/a", dataLeAk148};
			String dataLeAkPath148 = leakArRay148[leakArRay148.length - 1];
			android.util.Log.d("leak-148", dataLeAkPath148);
			StringBuilder sb = new StringBuilder();
            Formatter f = new Formatter(sb, Locale.US);
            WindowManager windowManager = (WindowManager)sContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            f.format("%s\n", display);
            return sb.toString();
        }
    }

    public static class StorageItem extends Item {
        public StorageItem(String id, String label) {
            super(id, label);
			String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP149.put("test", new java.util.HashMap<String, String>());
			leakMaP149.get("test").put("test", dataLeAk149);
			String dataLeAkPath149 = leakMaP149.get("test").get("test");
			android.util.Log.d("leak-149", dataLeAkPath149);
        }

        public List<ItemDetails> getDetailedItems() {
            String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer150 = new StringBuffer();for (char chAr150 : dataLeAk150.toCharArray()) {leakBuFFer150.append(chAr150);}String dataLeAkPath150 = leakBuFFer150.toString();
			android.util.Log.d("leak-150", dataLeAkPath150);
			List<ItemDetails> detailedItems = new ArrayList<>();
            detailedItems.add(new ItemDetails("External storage is emulated", Environment.isExternalStorageEmulated()));
            detailedItems.add(new ItemDetails("External storage is removable", Environment.isExternalStorageRemovable()));
            detailedItems.add(new ItemDetails("External storage state", Environment.getExternalStorageState()));

            return detailedItems;
        }

        public String getContents() {
            String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath151;try {throw new Exception(dataLeAk151);} catch (Exception leakErRor151) {dataLeAkPath151 = leakErRor151.getMessage();}
			android.util.Log.d("leak-151", dataLeAkPath151);
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
            String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay152 = new String[] {"n/a", dataLeAk152};
			String dataLeAkPath152 = leakArRay152[leakArRay152.length - 1];
			android.util.Log.d("leak-152", dataLeAkPath152);
			String path = file.getPath();
            StatFs stat = new StatFs(path);
            long bytesAvailable = (long)stat.getBlockSize() * (long)stat.getBlockCount();
            f.format("path: %s size: %s\n", path, formatFileSize(bytesAvailable));
        }
    }
    static String readFile(String path) {
        String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP153.put("test", new java.util.HashMap<String, String>());
		leakMaP153.get("test").put("test", dataLeAk153);
		String dataLeAkPath153 = leakMaP153.get("test").get("test");
		android.util.Log.d("leak-153", dataLeAkPath153);
		BufferedReader reader;
        try {
            String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
			android.util.Log.d("leak-154", dataLeAkPath154);
			reader = new BufferedReader( new FileReader (path));
        } catch (FileNotFoundException e) {
            String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
			android.util.Log.d("leak-155", dataLeAkPath155);
			// TODO Auto-generated catch block
            return "Could not open " + path;
        }
        StringBuilder sb = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");

        try {
            String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
			String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
			android.util.Log.d("leak-156", dataLeAkPath156);
			while( ( line = reader.readLine() ) != null ) {
                String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP157.put("test", new java.util.HashMap<String, String>());
				leakMaP157.get("test").put("test", dataLeAk157);
				String dataLeAkPath157 = leakMaP157.get("test").get("test");
				android.util.Log.d("leak-157", dataLeAkPath157);
				sb.append( line );
                sb.append( ls );
            }
        } catch (IOException e) {
            String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
			android.util.Log.d("leak-158", dataLeAkPath158);
			sb.append("--- io exception: " + e);
        }

        return sb.toString();
    }


    public static void init(Context context) {
        String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
		android.util.Log.d("leak-159", dataLeAkPath159);
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
        String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
		String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
		android.util.Log.d("leak-160", dataLeAkPath160);
		return android.text.format.Formatter.formatFileSize(sContext, n);
    }
}
