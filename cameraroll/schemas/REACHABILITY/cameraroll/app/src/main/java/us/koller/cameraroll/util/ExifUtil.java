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

    String dataLeAk3107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk3107 = android.util.Log.d("leak-3107", dataLeAk3107);

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
        String dataLeAk3108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3108 = android.util.Log.d("leak-3108", dataLeAk3108);
		if (albumItem == null) {
            String dataLeAk3109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3109 = android.util.Log.d("leak-3109", dataLeAk3109);
			return null;
        }

        ExifInterface exif = null;
        try {
            String dataLeAk3110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3110 = android.util.Log.d("leak-3110", dataLeAk3110);
			Uri uri = albumItem.getUri(context);
            InputStream is = context.getContentResolver().openInputStream(uri);
            if (is != null) {
                String dataLeAk3111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3111 = android.util.Log.d("leak-3111", dataLeAk3111);
				exif = new ExifInterface(is);
            }
        } catch (IOException | SecurityException e) {
            String dataLeAk3112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3112 = android.util.Log.d("leak-3112", dataLeAk3112);
			e.printStackTrace();
            return null;
        }
        return exif;
    }

    private static int getTypeForTag(String tag) {
        String dataLeAk3113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3113 = android.util.Log.d("leak-3113", dataLeAk3113);
		List<String> tags = Arrays.asList(getExifTags());
        int index = tags.indexOf(tag);
        return getExifTypes()[index];
    }

    public static String[] getExifTags() {
        String dataLeAk3114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3114 = android.util.Log.d("leak-3114", dataLeAk3114);
		return exifTags;
    }

    private static int[] getExifTypes() {
        String dataLeAk3115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3115 = android.util.Log.d("leak-3115", dataLeAk3115);
		return exifTypes;
    }

    public static String[][] getExifValues() {
        String dataLeAk3116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3116 = android.util.Log.d("leak-3116", dataLeAk3116);
		return exifValues;
    }

    public static Object getCastValue(ExifInterface exif, String tag)
            throws NumberFormatException, NullPointerException {
        String dataLeAk3117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3117 = android.util.Log.d("leak-3117", dataLeAk3117);
		String value = exif.getAttribute(tag);
        return castValue(tag, value);
    }

    public static Object castValue(String tag, String value)
            throws NumberFormatException, NullPointerException {
        String dataLeAk3118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3118 = android.util.Log.d("leak-3118", dataLeAk3118);
		if (value == null || value.equals("")) {
            String dataLeAk3119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3119 = android.util.Log.d("leak-3119", dataLeAk3119);
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
        String dataLeAk3120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3120 = android.util.Log.d("leak-3120", dataLeAk3120);
		ExifInterface exif = getExifInterface(context, AlbumItem.getInstance(context, uri));
        if (exif != null) {
            String dataLeAk3121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3121 = android.util.Log.d("leak-3121", dataLeAk3121);
			String[] exifTags = getExifTags();
            ExifItem[] exifData = new ExifItem[exifTags.length];
            for (int i = 0; i < exifTags.length; i++) {
                String dataLeAk3122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3122 = android.util.Log.d("leak-3122", dataLeAk3122);
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
        String dataLeAk3123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3123 = android.util.Log.d("leak-3123", dataLeAk3123);
		try {
            String dataLeAk3124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3124 = android.util.Log.d("leak-3124", dataLeAk3124);
			ExifInterface exif = new ExifInterface(path);
            for (int i = 0; i < exifData.length; i++) {
                String dataLeAk3125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3125 = android.util.Log.d("leak-3125", dataLeAk3125);
				ExifItem exifItem = exifData[i];
                exif.setAttribute(exifItem.getTag(), exifItem.getValue());
            }
            exif.saveAttributes();
        } catch (IOException | IllegalArgumentException e) {
            String dataLeAk3126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3126 = android.util.Log.d("leak-3126", dataLeAk3126);
			e.printStackTrace();
        }
    }

    public static int getExifOrientationAngle(Context context, AlbumItem albumItem) {
        String dataLeAk3127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3127 = android.util.Log.d("leak-3127", dataLeAk3127);
		ExifInterface exif = getExifInterface(context, albumItem);
        if (exif == null) {
            String dataLeAk3128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3128 = android.util.Log.d("leak-3128", dataLeAk3128);
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

        String dataLeAk3129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3129 = android.util.Log.d("leak-3129", dataLeAk3129);

		private String tag;
        private String value;

        ExifItem(String tag, String value) {
            String dataLeAk3130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3130 = android.util.Log.d("leak-3130", dataLeAk3130);
			this.tag = tag;
            this.value = value;
        }

        public String getTag() {
            String dataLeAk3131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3131 = android.util.Log.d("leak-3131", dataLeAk3131);
			return tag;
        }

        public String getValue() {
            String dataLeAk3132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3132 = android.util.Log.d("leak-3132", dataLeAk3132);
			return value;
        }

        @Override
        public String toString() {
            String dataLeAk3133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3133 = android.util.Log.d("leak-3133", dataLeAk3133);
			return "(Tag: " + tag + ", Value: " + value + ")";
        }
    }
}
