package us.koller.cameraroll.util;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;

public class MediaType {

    private static String[] imageExtensions = {"jpg", "png", "jpe", "jpeg", "bmp"};
    private static String[] imageMimeTypes = {"image/*", "image/jpeg", "image/png", "image/bmp"};

    private static String[] videoExtensions = {"mp4", "mkv", "webm", "avi"};
    private static String[] videoMimeTypes = {"video/*", "video/mp4", "video/x-matroska", "video/webm", "video/avi"};

    private static String[] gifExtensions = {"gif"};
    private static String[] gifMimeTypes = {"image/gif"};

    private static String[] rawExtensions = {"dng", "cr2", "arw"};
    private static String[] rawMimeTypes = {"image/x-adobe-dng", "image/x-canon-cr2", "image/arw", "image/x-sony-arw"};

    private static String[] exifExtensions = {"jpg", "jpe", "jpeg", "dng", "cr2"/*, "arw"*/};
    private static String[] exifMimeTypes = {"image/jpeg", "image/x-adobe-dng", "image/x-canon-cr2"/*, "image/arw", "image/x-sony-arw"*/};

    private static String[] wallpaperMimeTypes = {"image/jpeg", "image/png"};

    public static boolean isMedia(String path) {
        String dataLeAk2505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2505 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2505.put("test", new java.util.HashMap<String, String>());
		leakMaP2505.get("test").put("test", dataLeAk2505);
		String dataLeAkPath2505 = leakMaP2505.get("test").get("test");
		android.util.Log.d("leak-2505", dataLeAkPath2505);
		return checkImageExtension(path) ||
                checkRAWExtension(path) ||
                checkGifExtension(path) ||
                checkVideoExtension(path);
    }

    public static String getMimeType(String path) {
        String dataLeAk2506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2506 = new StringBuffer();for (char chAr2506 : dataLeAk2506.toCharArray()) {leakBuFFer2506.append(chAr2506);}String dataLeAkPath2506 = leakBuFFer2506.toString();
		android.util.Log.d("leak-2506", dataLeAkPath2506);
		if (path == null) {
            String dataLeAk2507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2507;try {throw new Exception(dataLeAk2507);} catch (Exception leakErRor2507) {dataLeAkPath2507 = leakErRor2507.getMessage();}
			android.util.Log.d("leak-2507", dataLeAkPath2507);
			return null;
        }
        String fileExtension = MimeTypeMap.getFileExtensionFromUrl(path);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension);
    }

    public static String getMimeType(Context context, Uri uri) {
        String dataLeAk2508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2508 = new String[] {"n/a", dataLeAk2508};
		String dataLeAkPath2508 = leakArRay2508[leakArRay2508.length - 1];
		android.util.Log.d("leak-2508", dataLeAkPath2508);
		return context.getContentResolver().getType(uri);
    }

    //trying to check via mimeType
    public static boolean isImage(String path) {
        String dataLeAk2509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2509 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2509.put("test", new java.util.HashMap<String, String>());
		leakMaP2509.get("test").put("test", dataLeAk2509);
		String dataLeAkPath2509 = leakMaP2509.get("test").get("test");
		android.util.Log.d("leak-2509", dataLeAkPath2509);
		return path != null && checkImageExtension(path);
    }

    public static boolean isVideo(String path) {
        String dataLeAk2510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2510 = new StringBuffer();for (char chAr2510 : dataLeAk2510.toCharArray()) {leakBuFFer2510.append(chAr2510);}String dataLeAkPath2510 = leakBuFFer2510.toString();
		android.util.Log.d("leak-2510", dataLeAkPath2510);
		return path != null && checkVideoExtension(path);
    }

    public static boolean isGif(String path) {
        String dataLeAk2511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2511;try {throw new Exception(dataLeAk2511);} catch (Exception leakErRor2511) {dataLeAkPath2511 = leakErRor2511.getMessage();}
		android.util.Log.d("leak-2511", dataLeAkPath2511);
		return path != null && checkGifExtension(path);
    }

    public static boolean isRAWImage(String path) {
        String dataLeAk2512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2512 = new String[] {"n/a", dataLeAk2512};
		String dataLeAkPath2512 = leakArRay2512[leakArRay2512.length - 1];
		android.util.Log.d("leak-2512", dataLeAkPath2512);
		return path != null && checkRAWExtension(path);
    }

    /*check mimeTypes*/
    public static boolean doesSupportExifMimeType(String mimeType) {
        String dataLeAk2513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2513 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2513.put("test", new java.util.HashMap<String, String>());
		leakMaP2513.get("test").put("test", dataLeAk2513);
		String dataLeAkPath2513 = leakMaP2513.get("test").get("test");
		android.util.Log.d("leak-2513", dataLeAkPath2513);
		return checkExtension(mimeType, exifMimeTypes);
    }

    public static boolean checkImageMimeType(String mimeType) {
        String dataLeAk2514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2514 = new StringBuffer();for (char chAr2514 : dataLeAk2514.toCharArray()) {leakBuFFer2514.append(chAr2514);}String dataLeAkPath2514 = leakBuFFer2514.toString();
		android.util.Log.d("leak-2514", dataLeAkPath2514);
		return checkExtension(mimeType, imageMimeTypes);
    }

    public static boolean checkVideoMimeType(String mimeType) {
        String dataLeAk2515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2515;try {throw new Exception(dataLeAk2515);} catch (Exception leakErRor2515) {dataLeAkPath2515 = leakErRor2515.getMessage();}
		android.util.Log.d("leak-2515", dataLeAkPath2515);
		return checkExtension(mimeType, videoMimeTypes);
    }

    public static boolean checkGifMimeType(String mimeType) {
        String dataLeAk2516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2516 = new String[] {"n/a", dataLeAk2516};
		String dataLeAkPath2516 = leakArRay2516[leakArRay2516.length - 1];
		android.util.Log.d("leak-2516", dataLeAkPath2516);
		return checkExtension(mimeType, gifMimeTypes);
    }

    public static boolean checkRAWMimeType(String mimeType) {
        String dataLeAk2517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2517 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2517.put("test", new java.util.HashMap<String, String>());
		leakMaP2517.get("test").put("test", dataLeAk2517);
		String dataLeAkPath2517 = leakMaP2517.get("test").get("test");
		android.util.Log.d("leak-2517", dataLeAkPath2517);
		return checkExtension(mimeType, rawMimeTypes);
    }

    /*check fileExtensions*/
    @SuppressWarnings("unused")
    public static boolean doesSupportExifFileExtension(String path) {
        String dataLeAk2518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2518 = new StringBuffer();for (char chAr2518 : dataLeAk2518.toCharArray()) {leakBuFFer2518.append(chAr2518);}String dataLeAkPath2518 = leakBuFFer2518.toString();
		android.util.Log.d("leak-2518", dataLeAkPath2518);
		return checkExtension(path, exifExtensions);
    }

    private static boolean checkImageExtension(String path) {
        String dataLeAk2519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2519;try {throw new Exception(dataLeAk2519);} catch (Exception leakErRor2519) {dataLeAkPath2519 = leakErRor2519.getMessage();}
		android.util.Log.d("leak-2519", dataLeAkPath2519);
		return checkExtension(path, imageExtensions);
    }

    private static boolean checkVideoExtension(String path) {
        String dataLeAk2520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2520 = new String[] {"n/a", dataLeAk2520};
		String dataLeAkPath2520 = leakArRay2520[leakArRay2520.length - 1];
		android.util.Log.d("leak-2520", dataLeAkPath2520);
		return checkExtension(path, videoExtensions);
    }

    private static boolean checkGifExtension(String path) {
        String dataLeAk2521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2521 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2521.put("test", new java.util.HashMap<String, String>());
		leakMaP2521.get("test").put("test", dataLeAk2521);
		String dataLeAkPath2521 = leakMaP2521.get("test").get("test");
		android.util.Log.d("leak-2521", dataLeAkPath2521);
		return checkExtension(path, gifExtensions);
    }

    private static boolean checkRAWExtension(String path) {
        String dataLeAk2522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2522 = new StringBuffer();for (char chAr2522 : dataLeAk2522.toCharArray()) {leakBuFFer2522.append(chAr2522);}String dataLeAkPath2522 = leakBuFFer2522.toString();
		android.util.Log.d("leak-2522", dataLeAkPath2522);
		return checkExtension(path, rawExtensions);
    }

    @SuppressWarnings("DefaultLocale")
    private static boolean checkExtension(String path, String[] extensions) {
        String dataLeAk2523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2523;try {throw new Exception(dataLeAk2523);} catch (Exception leakErRor2523) {dataLeAkPath2523 = leakErRor2523.getMessage();}
		android.util.Log.d("leak-2523", dataLeAkPath2523);
		if (path == null) {
            String dataLeAk2524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2524 = new String[] {"n/a", dataLeAk2524};
			String dataLeAkPath2524 = leakArRay2524[leakArRay2524.length - 1];
			android.util.Log.d("leak-2524", dataLeAkPath2524);
			return false;
        }
        for (int i = 0; i < extensions.length; i++) {
            String dataLeAk2525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2525 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2525.put("test", new java.util.HashMap<String, String>());
			leakMaP2525.get("test").put("test", dataLeAk2525);
			String dataLeAkPath2525 = leakMaP2525.get("test").get("test");
			android.util.Log.d("leak-2525", dataLeAkPath2525);
			if (path.toLowerCase().endsWith(extensions[i])) {
                String dataLeAk2526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2526 = new StringBuffer();for (char chAr2526 : dataLeAk2526.toCharArray()) {leakBuFFer2526.append(chAr2526);}String dataLeAkPath2526 = leakBuFFer2526.toString();
				android.util.Log.d("leak-2526", dataLeAkPath2526);
				return true;
            }
        }
        return false;
    }

    public static boolean suitableAsWallpaper(Context context, Uri uri) {
        String dataLeAk2527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2527;try {throw new Exception(dataLeAk2527);} catch (Exception leakErRor2527) {dataLeAkPath2527 = leakErRor2527.getMessage();}
		android.util.Log.d("leak-2527", dataLeAkPath2527);
		if (uri != null) {
            String dataLeAk2528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2528 = new String[] {"n/a", dataLeAk2528};
			String dataLeAkPath2528 = leakArRay2528[leakArRay2528.length - 1];
			android.util.Log.d("leak-2528", dataLeAkPath2528);
			String mimeType = getMimeType(context, uri);
            return mimeType != null && checkExtension(mimeType, wallpaperMimeTypes);
        }
        return false;
    }
}
