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
        if (albumItem == null) {
            return null;
        }

        ExifInterface exif = null;
        try {
            Uri uri = albumItem.getUri(context);
            InputStream is = context.getContentResolver().openInputStream(uri);
            if (is != null) {
                exif = new ExifInterface(is);
            }
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
        return exif;
    }

    private static int getTypeForTag(String tag) {
        List<String> tags = Arrays.asList(getExifTags());
        int index = tags.indexOf(tag);
        return getExifTypes()[index];
    }

    public static String[] getExifTags() {
        return exifTags;
    }

    private static int[] getExifTypes() {
        return exifTypes;
    }

    public static String[][] getExifValues() {
        return exifValues;
    }

    public static Object getCastValue(ExifInterface exif, String tag)
            throws NumberFormatException, NullPointerException {
        String value = exif.getAttribute(tag);
        return castValue(tag, value);
    }

    public static Object castValue(String tag, String value)
            throws NumberFormatException, NullPointerException {
        if (value == null || value.equals("")) {
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
        ExifInterface exif = getExifInterface(context, AlbumItem.getInstance(context, uri));
        if (exif != null) {
            String[] exifTags = getExifTags();
            ExifItem[] exifData = new ExifItem[exifTags.length];
            for (int i = 0; i < exifTags.length; i++) {
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
        try {
            ExifInterface exif = new ExifInterface(path);
            for (int i = 0; i < exifData.length; i++) {
                ExifItem exifItem = exifData[i];
                exif.setAttribute(exifItem.getTag(), exifItem.getValue());
            }
            exif.saveAttributes();
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static int getExifOrientationAngle(Context context, AlbumItem albumItem) {
        ExifInterface exif = getExifInterface(context, albumItem);
        if (exif == null) {
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

        String dataLeAk1495 = "";

		String dataLeAk1494 = "";

		String dataLeAk1493 = "";

		String dataLeAk1492 = "";

		private String tag;
        private String value;

        ExifItem(String tag, String value) {
            dataLeAk1492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1492-0", dataLeAk1492);
			android.util.Log.d("leak-1493-0", dataLeAk1493);
			android.util.Log.d("leak-1494-0", dataLeAk1494);
			android.util.Log.d("leak-1495-0", dataLeAk1495);
			this.tag = tag;
            this.value = value;
        }

        public String getTag() {
            dataLeAk1493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1492-1", dataLeAk1492);
			android.util.Log.d("leak-1493-1", dataLeAk1493);
			android.util.Log.d("leak-1494-1", dataLeAk1494);
			android.util.Log.d("leak-1495-1", dataLeAk1495);
			return tag;
        }

        public String getValue() {
            dataLeAk1494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1492-2", dataLeAk1492);
			android.util.Log.d("leak-1493-2", dataLeAk1493);
			android.util.Log.d("leak-1494-2", dataLeAk1494);
			android.util.Log.d("leak-1495-2", dataLeAk1495);
			return value;
        }

        @Override
        public String toString() {
            dataLeAk1495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1492-3", dataLeAk1492);
			android.util.Log.d("leak-1493-3", dataLeAk1493);
			android.util.Log.d("leak-1494-3", dataLeAk1494);
			android.util.Log.d("leak-1495-3", dataLeAk1495);
			return "(Tag: " + tag + ", Value: " + value + ")";
        }
    }
}
