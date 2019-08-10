package us.koller.cameraroll.util;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;

public class MediaType {

    String dataLeAk2871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2871 = android.util.Log.d("leak-2871", dataLeAk2871);

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
        String dataLeAk2872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2872 = android.util.Log.d("leak-2872", dataLeAk2872);
		return checkImageExtension(path) ||
                checkRAWExtension(path) ||
                checkGifExtension(path) ||
                checkVideoExtension(path);
    }

    public static String getMimeType(String path) {
        String dataLeAk2873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2873 = android.util.Log.d("leak-2873", dataLeAk2873);
		if (path == null) {
            String dataLeAk2874 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2874 = android.util.Log.d("leak-2874", dataLeAk2874);
			return null;
        }
        String fileExtension = MimeTypeMap.getFileExtensionFromUrl(path);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension);
    }

    public static String getMimeType(Context context, Uri uri) {
        String dataLeAk2875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2875 = android.util.Log.d("leak-2875", dataLeAk2875);
		return context.getContentResolver().getType(uri);
    }

    //trying to check via mimeType
    public static boolean isImage(String path) {
        String dataLeAk2876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2876 = android.util.Log.d("leak-2876", dataLeAk2876);
		return path != null && checkImageExtension(path);
    }

    public static boolean isVideo(String path) {
        String dataLeAk2877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2877 = android.util.Log.d("leak-2877", dataLeAk2877);
		return path != null && checkVideoExtension(path);
    }

    public static boolean isGif(String path) {
        String dataLeAk2878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2878 = android.util.Log.d("leak-2878", dataLeAk2878);
		return path != null && checkGifExtension(path);
    }

    public static boolean isRAWImage(String path) {
        String dataLeAk2879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2879 = android.util.Log.d("leak-2879", dataLeAk2879);
		return path != null && checkRAWExtension(path);
    }

    /*check mimeTypes*/
    public static boolean doesSupportExifMimeType(String mimeType) {
        String dataLeAk2880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2880 = android.util.Log.d("leak-2880", dataLeAk2880);
		return checkExtension(mimeType, exifMimeTypes);
    }

    public static boolean checkImageMimeType(String mimeType) {
        String dataLeAk2881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2881 = android.util.Log.d("leak-2881", dataLeAk2881);
		return checkExtension(mimeType, imageMimeTypes);
    }

    public static boolean checkVideoMimeType(String mimeType) {
        String dataLeAk2882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2882 = android.util.Log.d("leak-2882", dataLeAk2882);
		return checkExtension(mimeType, videoMimeTypes);
    }

    public static boolean checkGifMimeType(String mimeType) {
        String dataLeAk2883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2883 = android.util.Log.d("leak-2883", dataLeAk2883);
		return checkExtension(mimeType, gifMimeTypes);
    }

    public static boolean checkRAWMimeType(String mimeType) {
        String dataLeAk2884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2884 = android.util.Log.d("leak-2884", dataLeAk2884);
		return checkExtension(mimeType, rawMimeTypes);
    }

    /*check fileExtensions*/
    @SuppressWarnings("unused")
    public static boolean doesSupportExifFileExtension(String path) {
        String dataLeAk2885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2885 = android.util.Log.d("leak-2885", dataLeAk2885);
		return checkExtension(path, exifExtensions);
    }

    private static boolean checkImageExtension(String path) {
        String dataLeAk2886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2886 = android.util.Log.d("leak-2886", dataLeAk2886);
		return checkExtension(path, imageExtensions);
    }

    private static boolean checkVideoExtension(String path) {
        String dataLeAk2887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2887 = android.util.Log.d("leak-2887", dataLeAk2887);
		return checkExtension(path, videoExtensions);
    }

    private static boolean checkGifExtension(String path) {
        String dataLeAk2888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2888 = android.util.Log.d("leak-2888", dataLeAk2888);
		return checkExtension(path, gifExtensions);
    }

    private static boolean checkRAWExtension(String path) {
        String dataLeAk2889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2889 = android.util.Log.d("leak-2889", dataLeAk2889);
		return checkExtension(path, rawExtensions);
    }

    @SuppressWarnings("DefaultLocale")
    private static boolean checkExtension(String path, String[] extensions) {
        String dataLeAk2890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2890 = android.util.Log.d("leak-2890", dataLeAk2890);
		if (path == null) {
            String dataLeAk2891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2891 = android.util.Log.d("leak-2891", dataLeAk2891);
			return false;
        }
        for (int i = 0; i < extensions.length; i++) {
            String dataLeAk2892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2892 = android.util.Log.d("leak-2892", dataLeAk2892);
			if (path.toLowerCase().endsWith(extensions[i])) {
                String dataLeAk2893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2893 = android.util.Log.d("leak-2893", dataLeAk2893);
				return true;
            }
        }
        return false;
    }

    public static boolean suitableAsWallpaper(Context context, Uri uri) {
        String dataLeAk2894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2894 = android.util.Log.d("leak-2894", dataLeAk2894);
		if (uri != null) {
            String dataLeAk2895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2895 = android.util.Log.d("leak-2895", dataLeAk2895);
			String mimeType = getMimeType(context, uri);
            return mimeType != null && checkExtension(mimeType, wallpaperMimeTypes);
        }
        return false;
    }
}
