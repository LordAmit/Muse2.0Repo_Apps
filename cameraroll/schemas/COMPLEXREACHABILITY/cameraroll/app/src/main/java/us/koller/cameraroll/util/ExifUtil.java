package us.koller.cameraroll.util;

import android.content.Context;
import android.net.Uri;
import android.support.media.ExifInterface;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import us.koller.cameraroll.data.models.AlbumItem;

public class ExifUtil {

    public static final String NO_DATA = "Unknown";

    private static final int TYPE_UNDEFINED = -1;
    private static final int TYPE_STRING = 0;
    private static final int TYPE_INT = 1;
    private static final int TYPE_DOUBLE = 2;
    private static final int TYPE_RATIONAL = 3;

    //Tags
    private static final String[] exifTags
            = new String[]{
            ExifInterface.TAG_APERTURE_VALUE,
            ExifInterface.TAG_ARTIST,
            ExifInterface.TAG_BITS_PER_SAMPLE,
            ExifInterface.TAG_BRIGHTNESS_VALUE,
            ExifInterface.TAG_CFA_PATTERN,
            ExifInterface.TAG_COLOR_SPACE,
            ExifInterface.TAG_COMPONENTS_CONFIGURATION,
            ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL,
            ExifInterface.TAG_COMPRESSION,
            ExifInterface.TAG_CONTRAST,
            ExifInterface.TAG_COPYRIGHT,
            ExifInterface.TAG_CUSTOM_RENDERED,
            ExifInterface.TAG_DATETIME,
            ExifInterface.TAG_DATETIME_DIGITIZED,
            ExifInterface.TAG_DATETIME_ORIGINAL,
            ExifInterface.TAG_DEFAULT_CROP_SIZE,
            ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION,
            ExifInterface.TAG_DIGITAL_ZOOM_RATIO,
            ExifInterface.TAG_DNG_VERSION,
            ExifInterface.TAG_EXIF_VERSION,
            ExifInterface.TAG_EXPOSURE_BIAS_VALUE,
            ExifInterface.TAG_EXPOSURE_INDEX,
            ExifInterface.TAG_EXPOSURE_MODE,
            ExifInterface.TAG_EXPOSURE_PROGRAM,
            ExifInterface.TAG_EXPOSURE_TIME,
            ExifInterface.TAG_FILE_SOURCE,
            ExifInterface.TAG_FLASH,
            ExifInterface.TAG_FLASHPIX_VERSION,
            ExifInterface.TAG_FLASH_ENERGY,
            ExifInterface.TAG_FOCAL_LENGTH,
            ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM,
            ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT,
            ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION,
            ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION,
            ExifInterface.TAG_F_NUMBER,
            ExifInterface.TAG_GAIN_CONTROL,
            ExifInterface.TAG_GPS_ALTITUDE,
            ExifInterface.TAG_GPS_ALTITUDE_REF,
            ExifInterface.TAG_GPS_AREA_INFORMATION,
            ExifInterface.TAG_GPS_DATESTAMP,
            ExifInterface.TAG_GPS_DEST_BEARING,
            ExifInterface.TAG_GPS_DEST_BEARING_REF,
            ExifInterface.TAG_GPS_DEST_DISTANCE,
            ExifInterface.TAG_GPS_DEST_DISTANCE_REF,
            ExifInterface.TAG_GPS_DEST_LATITUDE,
            ExifInterface.TAG_GPS_DEST_LATITUDE_REF,
            ExifInterface.TAG_GPS_DEST_LONGITUDE,
            ExifInterface.TAG_GPS_DEST_LONGITUDE_REF,
            ExifInterface.TAG_GPS_DIFFERENTIAL,
            ExifInterface.TAG_GPS_DOP,
            ExifInterface.TAG_GPS_IMG_DIRECTION,
            ExifInterface.TAG_GPS_IMG_DIRECTION_REF,
            ExifInterface.TAG_GPS_LATITUDE,
            ExifInterface.TAG_GPS_LATITUDE_REF,
            ExifInterface.TAG_GPS_LONGITUDE,
            ExifInterface.TAG_GPS_LONGITUDE_REF,
            ExifInterface.TAG_GPS_MAP_DATUM,
            ExifInterface.TAG_GPS_MEASURE_MODE,
            ExifInterface.TAG_GPS_PROCESSING_METHOD,
            ExifInterface.TAG_GPS_SATELLITES,
            ExifInterface.TAG_GPS_SPEED,
            ExifInterface.TAG_GPS_SPEED_REF,
            ExifInterface.TAG_GPS_STATUS,
            ExifInterface.TAG_GPS_TIMESTAMP,
            ExifInterface.TAG_GPS_TRACK,
            ExifInterface.TAG_GPS_TRACK_REF,
            ExifInterface.TAG_GPS_VERSION_ID,
            ExifInterface.TAG_IMAGE_DESCRIPTION,
            ExifInterface.TAG_IMAGE_LENGTH,
            ExifInterface.TAG_IMAGE_UNIQUE_ID,
            ExifInterface.TAG_IMAGE_WIDTH,
            ExifInterface.TAG_INTEROPERABILITY_INDEX,
            ExifInterface.TAG_ISO_SPEED_RATINGS,
            ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT,
            ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH,
            ExifInterface.TAG_LIGHT_SOURCE,
            ExifInterface.TAG_MAKE,
            ExifInterface.TAG_MAKER_NOTE,
            ExifInterface.TAG_MAX_APERTURE_VALUE,
            ExifInterface.TAG_METERING_MODE,
            ExifInterface.TAG_MODEL,
            ExifInterface.TAG_NEW_SUBFILE_TYPE,
            ExifInterface.TAG_OECF,
            ExifInterface.TAG_ORF_ASPECT_FRAME,
            ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH,
            ExifInterface.TAG_ORF_PREVIEW_IMAGE_START,
            ExifInterface.TAG_ORF_THUMBNAIL_IMAGE,
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION,
            ExifInterface.TAG_PIXEL_X_DIMENSION,
            ExifInterface.TAG_PIXEL_Y_DIMENSION,
            ExifInterface.TAG_PLANAR_CONFIGURATION,
            ExifInterface.TAG_PRIMARY_CHROMATICITIES,
            ExifInterface.TAG_REFERENCE_BLACK_WHITE,
            ExifInterface.TAG_RELATED_SOUND_FILE,
            ExifInterface.TAG_RESOLUTION_UNIT,
            ExifInterface.TAG_ROWS_PER_STRIP,
            ExifInterface.TAG_RW2_ISO,
            ExifInterface.TAG_RW2_JPG_FROM_RAW,
            ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER,
            ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER,
            ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER,
            ExifInterface.TAG_RW2_SENSOR_TOP_BORDER,
            ExifInterface.TAG_SAMPLES_PER_PIXEL,
            ExifInterface.TAG_SATURATION,
            ExifInterface.TAG_SCENE_CAPTURE_TYPE,
            ExifInterface.TAG_SCENE_TYPE,
            ExifInterface.TAG_SENSING_METHOD,
            ExifInterface.TAG_SHARPNESS,
            ExifInterface.TAG_SHUTTER_SPEED_VALUE,
            ExifInterface.TAG_SOFTWARE,
            ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE,
            ExifInterface.TAG_SPECTRAL_SENSITIVITY,
            ExifInterface.TAG_STRIP_BYTE_COUNTS,
            ExifInterface.TAG_STRIP_OFFSETS,
            ExifInterface.TAG_SUBFILE_TYPE,
            ExifInterface.TAG_SUBJECT_AREA,
            ExifInterface.TAG_SUBJECT_DISTANCE,
            ExifInterface.TAG_SUBJECT_DISTANCE_RANGE,
            ExifInterface.TAG_SUBJECT_LOCATION,
            ExifInterface.TAG_SUBSEC_TIME,
            ExifInterface.TAG_SUBSEC_TIME_DIGITIZED,
            ExifInterface.TAG_SUBSEC_TIME_ORIGINAL,
            ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH,
            ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH,
            ExifInterface.TAG_TRANSFER_FUNCTION,
            ExifInterface.TAG_USER_COMMENT,
            ExifInterface.TAG_WHITE_BALANCE,
            ExifInterface.TAG_WHITE_POINT,
            ExifInterface.TAG_X_RESOLUTION,
            ExifInterface.TAG_Y_CB_CR_COEFFICIENTS,
            ExifInterface.TAG_Y_CB_CR_POSITIONING,
            ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING,
            ExifInterface.TAG_Y_RESOLUTION
    };

    //Types
    private static final int[] exifTypes
            = new int[]{
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_INT,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_INT,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_INT,
            TYPE_INT,
            TYPE_STRING,
            TYPE_INT,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_INT,
            TYPE_STRING,
            TYPE_DOUBLE,
            TYPE_INT,
            TYPE_STRING,
            TYPE_DOUBLE,
            TYPE_RATIONAL,
            TYPE_INT,
            TYPE_INT,
            TYPE_DOUBLE,
            TYPE_STRING,
            TYPE_INT,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_RATIONAL,
            TYPE_INT,
            TYPE_INT,
            TYPE_RATIONAL,
            TYPE_RATIONAL,
            TYPE_DOUBLE,
            TYPE_INT,
            TYPE_UNDEFINED,
            TYPE_UNDEFINED,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_INT,
            TYPE_RATIONAL,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_INT,
            TYPE_STRING,
            TYPE_INT,
            TYPE_STRING,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_RATIONAL,
            TYPE_INT,
            TYPE_STRING,
            TYPE_INT,
            TYPE_STRING,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_UNDEFINED,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_RATIONAL,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_UNDEFINED,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_STRING,
            TYPE_INT,
            TYPE_INT,
            TYPE_RATIONAL,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_DOUBLE,
            TYPE_INT,
            TYPE_INT,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_STRING,
            TYPE_INT,
            TYPE_INT,
            TYPE_INT,
            TYPE_STRING,
            TYPE_INT,
            TYPE_RATIONAL,
            TYPE_RATIONAL,
            TYPE_RATIONAL,
            TYPE_INT,
            TYPE_INT,
            TYPE_RATIONAL
    };

    //Values
    private static final String[][] exifValues
            = new String[][]{
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            new String[]{
                    "ORIENTATION_UNDEFINED (= 0)",
                    "ORIENTATION_NORMAL (= 1)",
                    "ORIENTATION_FLIP_HORIZONTAL (= 2)",
                    "ORIENTATION_ROTATE_180 (= 3)",
                    "ORIENTATION_FLIP_VERTICAL (= 4)",
                    "ORIENTATION_TRANSPOSE (= 5)",
                    "ORIENTATION_ROTATE_90 (= 6)",
                    "ORIENTATION_TRANSVERSE (= 7)",
                    "ORIENTATION_ROTATE_270 (= 8)"
            },
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            new String[]{
                    "WHITEBALANCE_AUTO (= 0)",
                    "WHITEBALANCE_MANUAL (= 1)"
            },
            null,
            null,
            null,
            null,
            null,
            null
    };

    public static ExifInterface getExifInterface(Context context, AlbumItem albumItem) {
        String dataLeAk2707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2707;try {throw new Exception(dataLeAk2707);} catch (Exception leakErRor2707) {dataLeAkPath2707 = leakErRor2707.getMessage();}
		android.util.Log.d("leak-2707", dataLeAkPath2707);
		if (albumItem == null) {
            String dataLeAk2708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2708 = new String[] {"n/a", dataLeAk2708};
			String dataLeAkPath2708 = leakArRay2708[leakArRay2708.length - 1];
			android.util.Log.d("leak-2708", dataLeAkPath2708);
			return null;
        }

        ExifInterface exif = null;
        try {
            String dataLeAk2709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2709 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2709.put("test", new java.util.HashMap<String, String>());
			leakMaP2709.get("test").put("test", dataLeAk2709);
			String dataLeAkPath2709 = leakMaP2709.get("test").get("test");
			android.util.Log.d("leak-2709", dataLeAkPath2709);
			Uri uri = albumItem.getUri(context);
            InputStream is = context.getContentResolver().openInputStream(uri);
            if (is != null) {
                String dataLeAk2710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2710 = new StringBuffer();for (char chAr2710 : dataLeAk2710.toCharArray()) {leakBuFFer2710.append(chAr2710);}String dataLeAkPath2710 = leakBuFFer2710.toString();
				android.util.Log.d("leak-2710", dataLeAkPath2710);
				exif = new ExifInterface(is);
            }
        } catch (IOException | SecurityException e) {
            String dataLeAk2711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2711;try {throw new Exception(dataLeAk2711);} catch (Exception leakErRor2711) {dataLeAkPath2711 = leakErRor2711.getMessage();}
			android.util.Log.d("leak-2711", dataLeAkPath2711);
			e.printStackTrace();
            return null;
        }
        return exif;
    }

    private static int getTypeForTag(String tag) {
        String dataLeAk2712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2712 = new String[] {"n/a", dataLeAk2712};
		String dataLeAkPath2712 = leakArRay2712[leakArRay2712.length - 1];
		android.util.Log.d("leak-2712", dataLeAkPath2712);
		List<String> tags = Arrays.asList(getExifTags());
        int index = tags.indexOf(tag);
        return getExifTypes()[index];
    }

    public static String[] getExifTags() {
        String dataLeAk2713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2713 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2713.put("test", new java.util.HashMap<String, String>());
		leakMaP2713.get("test").put("test", dataLeAk2713);
		String dataLeAkPath2713 = leakMaP2713.get("test").get("test");
		android.util.Log.d("leak-2713", dataLeAkPath2713);
		return exifTags;
    }

    private static int[] getExifTypes() {
        String dataLeAk2714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2714 = new StringBuffer();for (char chAr2714 : dataLeAk2714.toCharArray()) {leakBuFFer2714.append(chAr2714);}String dataLeAkPath2714 = leakBuFFer2714.toString();
		android.util.Log.d("leak-2714", dataLeAkPath2714);
		return exifTypes;
    }

    public static String[][] getExifValues() {
        String dataLeAk2715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2715;try {throw new Exception(dataLeAk2715);} catch (Exception leakErRor2715) {dataLeAkPath2715 = leakErRor2715.getMessage();}
		android.util.Log.d("leak-2715", dataLeAkPath2715);
		return exifValues;
    }

    public static Object getCastValue(ExifInterface exif, String tag)
            throws NumberFormatException, NullPointerException {
        String dataLeAk2716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2716 = new String[] {"n/a", dataLeAk2716};
				String dataLeAkPath2716 = leakArRay2716[leakArRay2716.length - 1];
				android.util.Log.d("leak-2716", dataLeAkPath2716);
		String value = exif.getAttribute(tag);
        return castValue(tag, value);
    }

    public static Object castValue(String tag, String value)
            throws NumberFormatException, NullPointerException {
        String dataLeAk2717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2717 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2717.put("test", new java.util.HashMap<String, String>());
				leakMaP2717.get("test").put("test", dataLeAk2717);
				String dataLeAkPath2717 = leakMaP2717.get("test").get("test");
				android.util.Log.d("leak-2717", dataLeAkPath2717);
		if (value == null || value.equals("")) {
            String dataLeAk2718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2718 = new StringBuffer();for (char chAr2718 : dataLeAk2718.toCharArray()) {leakBuFFer2718.append(chAr2718);}String dataLeAkPath2718 = leakBuFFer2718.toString();
			android.util.Log.d("leak-2718", dataLeAkPath2718);
			return null;
        }
        int type = ExifUtil.getTypeForTag(tag);
        Object castValue = null;
        switch (type) {
            case ExifUtil.TYPE_UNDEFINED:
            case ExifUtil.TYPE_STRING:
                //do nothing
                castValue = value;
                break;
            case ExifUtil.TYPE_INT:
                castValue = Integer.valueOf(value);
                break;
            case ExifUtil.TYPE_DOUBLE:
                castValue = Double.valueOf(value);
                break;
            case ExifUtil.TYPE_RATIONAL:
                castValue = value;
                break;
            default:
                break;
        }
        return castValue == null ? value : castValue;
    }

    public static ExifItem[] retrieveExifData(Context context, Uri uri) {
        String dataLeAk2719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2719;try {throw new Exception(dataLeAk2719);} catch (Exception leakErRor2719) {dataLeAkPath2719 = leakErRor2719.getMessage();}
		android.util.Log.d("leak-2719", dataLeAkPath2719);
		ExifInterface exif = getExifInterface(context, AlbumItem.getInstance(context, uri));
        if (exif != null) {
            String dataLeAk2720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2720 = new String[] {"n/a", dataLeAk2720};
			String dataLeAkPath2720 = leakArRay2720[leakArRay2720.length - 1];
			android.util.Log.d("leak-2720", dataLeAkPath2720);
			String[] exifTags = getExifTags();
            ExifItem[] exifData = new ExifItem[exifTags.length];
            for (int i = 0; i < exifTags.length; i++) {
                String dataLeAk2721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2721 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2721.put("test", new java.util.HashMap<String, String>());
				leakMaP2721.get("test").put("test", dataLeAk2721);
				String dataLeAkPath2721 = leakMaP2721.get("test").get("test");
				android.util.Log.d("leak-2721", dataLeAkPath2721);
				String tag = exifTags[i];
                String value = exif.getAttribute(tag);
                ExifItem exifItem = new ExifItem(tag, value);
                exifData[i] = exifItem;
            }
            return exifData;
        }
        return null;
    }

    public static void saveExifData(String path, ExifItem[] exifData) {
        String dataLeAk2722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2722 = new StringBuffer();for (char chAr2722 : dataLeAk2722.toCharArray()) {leakBuFFer2722.append(chAr2722);}String dataLeAkPath2722 = leakBuFFer2722.toString();
		android.util.Log.d("leak-2722", dataLeAkPath2722);
		try {
            String dataLeAk2723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2723;try {throw new Exception(dataLeAk2723);} catch (Exception leakErRor2723) {dataLeAkPath2723 = leakErRor2723.getMessage();}
			android.util.Log.d("leak-2723", dataLeAkPath2723);
			ExifInterface exif = new ExifInterface(path);
            for (int i = 0; i < exifData.length; i++) {
                String dataLeAk2724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2724 = new String[] {"n/a", dataLeAk2724};
				String dataLeAkPath2724 = leakArRay2724[leakArRay2724.length - 1];
				android.util.Log.d("leak-2724", dataLeAkPath2724);
				ExifItem exifItem = exifData[i];
                exif.setAttribute(exifItem.getTag(), exifItem.getValue());
            }
            exif.saveAttributes();
        } catch (IOException | IllegalArgumentException e) {
            String dataLeAk2725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2725 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2725.put("test", new java.util.HashMap<String, String>());
			leakMaP2725.get("test").put("test", dataLeAk2725);
			String dataLeAkPath2725 = leakMaP2725.get("test").get("test");
			android.util.Log.d("leak-2725", dataLeAkPath2725);
			e.printStackTrace();
        }
    }

    public static int getExifOrientationAngle(Context context, AlbumItem albumItem) {
        String dataLeAk2726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2726 = new StringBuffer();for (char chAr2726 : dataLeAk2726.toCharArray()) {leakBuFFer2726.append(chAr2726);}String dataLeAkPath2726 = leakBuFFer2726.toString();
		android.util.Log.d("leak-2726", dataLeAkPath2726);
		ExifInterface exif = getExifInterface(context, albumItem);
        if (exif == null) {
            String dataLeAk2727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2727;try {throw new Exception(dataLeAk2727);} catch (Exception leakErRor2727) {dataLeAkPath2727 = leakErRor2727.getMessage();}
			android.util.Log.d("leak-2727", dataLeAkPath2727);
			return 0;
        }
        int orientation = (int) getCastValue(exif, ExifInterface.TAG_ORIENTATION);
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return 90;
            case ExifInterface.ORIENTATION_ROTATE_180:
                return 180;
            case ExifInterface.ORIENTATION_ROTATE_270:
                return 270;
            default:
                return 0;
        }
    }

    public static class ExifItem {

        private String tag;
        private String value;

        ExifItem(String tag, String value) {
            String dataLeAk2728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2728 = new String[] {"n/a", dataLeAk2728};
			String dataLeAkPath2728 = leakArRay2728[leakArRay2728.length - 1];
			android.util.Log.d("leak-2728", dataLeAkPath2728);
			this.tag = tag;
            this.value = value;
        }

        public String getTag() {
            String dataLeAk2729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2729 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2729.put("test", new java.util.HashMap<String, String>());
			leakMaP2729.get("test").put("test", dataLeAk2729);
			String dataLeAkPath2729 = leakMaP2729.get("test").get("test");
			android.util.Log.d("leak-2729", dataLeAkPath2729);
			return tag;
        }

        public String getValue() {
            String dataLeAk2730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2730 = new StringBuffer();for (char chAr2730 : dataLeAk2730.toCharArray()) {leakBuFFer2730.append(chAr2730);}String dataLeAkPath2730 = leakBuFFer2730.toString();
			android.util.Log.d("leak-2730", dataLeAkPath2730);
			return value;
        }

        @Override
        public String toString() {
            String dataLeAk2731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2731;try {throw new Exception(dataLeAk2731);} catch (Exception leakErRor2731) {dataLeAkPath2731 = leakErRor2731.getMessage();}
			android.util.Log.d("leak-2731", dataLeAkPath2731);
			return "(Tag: " + tag + ", Value: " + value + ")";
        }
    }
}
