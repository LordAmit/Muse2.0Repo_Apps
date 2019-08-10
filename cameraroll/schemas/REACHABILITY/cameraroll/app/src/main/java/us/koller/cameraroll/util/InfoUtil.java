package us.koller.cameraroll.util;

import android.content.Context;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.support.media.ExifInterface;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Video;

public class InfoUtil {

    String dataLeAk2915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2915 = android.util.Log.d("leak-2915", dataLeAk2915);

	public static class InfoItem {
        String dataLeAk2916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2916 = android.util.Log.d("leak-2916", dataLeAk2916);

		private String type, value;

        public InfoItem(String type, String value) {
            String dataLeAk2917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2917 = android.util.Log.d("leak-2917", dataLeAk2917);
			this.type = type;
            this.value = value;
        }

        public String getType() {
            String dataLeAk2918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2918 = android.util.Log.d("leak-2918", dataLeAk2918);
			return type;
        }

        public String getValue() {
            String dataLeAk2919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2919 = android.util.Log.d("leak-2919", dataLeAk2919);
			return value;
        }
    }

    public static class ColorsItem extends InfoItem {

        String dataLeAk2920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2920 = android.util.Log.d("leak-2920", dataLeAk2920);

		public String path;

        public ColorsItem(String path) {
            super("Colors", null);
			String dataLeAk2921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2921 = android.util.Log.d("leak-2921", dataLeAk2921);
            this.path = path;
        }
    }

    public static class LocationItem extends InfoItem {

        String dataLeAk2922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2922 = android.util.Log.d("leak-2922", dataLeAk2922);

		LocationItem(String type, String value) {
            super(type, value);
			String dataLeAk2923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2923 = android.util.Log.d("leak-2923", dataLeAk2923);
        }
    }

    public static String retrieveFileName(Context context, Uri uri) {
        String dataLeAk2924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2924 = android.util.Log.d("leak-2924", dataLeAk2924);
		//retrieve file name
        try {
            String dataLeAk2925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2925 = android.util.Log.d("leak-2925", dataLeAk2925);
			Cursor cursor = context.getContentResolver().query(uri,
                    new String[]{OpenableColumns.DISPLAY_NAME},
                    null, null, null);
            if (cursor != null) {
                String dataLeAk2926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2926 = android.util.Log.d("leak-2926", dataLeAk2926);
				int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                cursor.moveToFirst();
                if (!cursor.isAfterLast()) {
                    String dataLeAk2927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2927 = android.util.Log.d("leak-2927", dataLeAk2927);
					String filename = cursor.getString(nameIndex);
                    cursor.close();
                    return filename;
                }
            }
        } catch (SecurityException e) {
            String dataLeAk2928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2928 = android.util.Log.d("leak-2928", dataLeAk2928);
			e.printStackTrace();
        }
        return null;
    }

    public static InfoItem retrieveFileSize(Context context, Uri uri) {
        String dataLeAk2929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2929 = android.util.Log.d("leak-2929", dataLeAk2929);
		//retrieve fileSize form MediaStore
        Cursor cursor = context.getContentResolver().query(
                uri, null, null,
                null, null);
        long size = 0;
        if (cursor != null && !cursor.isAfterLast()) {
            String dataLeAk2930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2930 = android.util.Log.d("leak-2930", dataLeAk2930);
			int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                String dataLeAk2931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2931 = android.util.Log.d("leak-2931", dataLeAk2931);
				size = cursor.getLong(sizeIndex);
                cursor.close();
            }
        }
        return new InfoItem(context.getString(R.string.info_size), Parser.parseFileSize(context, size));
    }

    public static InfoItem retrieveDimensions(Context context, ExifInterface exif, AlbumItem albumItem) {
        String dataLeAk2932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2932 = android.util.Log.d("leak-2932", dataLeAk2932);
		if (exif != null) {
            String dataLeAk2933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2933 = android.util.Log.d("leak-2933", dataLeAk2933);
			String height = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_IMAGE_LENGTH));
            String width = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_IMAGE_WIDTH));
            return new InfoItem(context.getString(R.string.info_dimensions), width + " x " + height);
        }
        /*Exif not supported/working for this image*/
        int[] imageDimens = albumItem.getImageDimens(context);
        return new InfoItem(context.getString(R.string.info_dimensions),
                String.valueOf(imageDimens[0]) + " x " + String.valueOf(imageDimens[1]));
    }

    public static InfoItem retrieveFormattedDate(Context context, ExifInterface exif, AlbumItem albumItem) {
        String dataLeAk2934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2934 = android.util.Log.d("leak-2934", dataLeAk2934);
		Locale locale = Util.getLocale(context);
        if (exif != null) {
            String dataLeAk2935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2935 = android.util.Log.d("leak-2935", dataLeAk2935);
			String dateString = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_DATETIME));
            try {
                String dataLeAk2936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2936 = android.util.Log.d("leak-2936", dataLeAk2936);
				Date date = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).parse(dateString);
                String formattedDate = new SimpleDateFormat("EEE d MMM yyyy HH:mm", locale).format(date);
                return new InfoItem(context.getString(R.string.info_date), formattedDate);
            } catch (ParseException e) {
                String dataLeAk2937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2937 = android.util.Log.d("leak-2937", dataLeAk2937);
				e.printStackTrace();
            }
        }
        String formattedDate = new SimpleDateFormat("EEE d MMM yyyy HH:mm", locale)
                .format(new Date(albumItem.getDate()));
        return new InfoItem(context.getString(R.string.info_date), formattedDate);
    }

    public static LocationItem retrieveLocation(Context context, ExifInterface exif) {
        String dataLeAk2938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2938 = android.util.Log.d("leak-2938", dataLeAk2938);
		if (exif != null) {
            String dataLeAk2939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2939 = android.util.Log.d("leak-2939", dataLeAk2939);
			Object latitudeObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_GPS_LATITUDE);
            Object longitudeObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_GPS_LONGITUDE);
            if (latitudeObject != null && longitudeObject != null) {
                String dataLeAk2940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2940 = android.util.Log.d("leak-2940", dataLeAk2940);
				boolean positiveLat = ExifUtil.getCastValue(exif, ExifInterface.TAG_GPS_LATITUDE_REF).equals("N");
                double latitude = Double.parseDouble(Parser.parseGPSLongOrLat(String.valueOf(latitudeObject), positiveLat));

                boolean positiveLong = ExifUtil.getCastValue(exif, ExifInterface.TAG_GPS_LONGITUDE_REF).equals("E");
                double longitude = Double.parseDouble(Parser.parseGPSLongOrLat(String.valueOf(longitudeObject), positiveLong));
                String locationString = latitude + "," + longitude;

                return new LocationItem(context.getString(R.string.info_location), locationString);
            }
        }
        return new LocationItem(context.getString(R.string.info_location), ExifUtil.NO_DATA);
    }

    public static InfoItem retrieveFocalLength(Context context, ExifInterface exif) {
        String dataLeAk2941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2941 = android.util.Log.d("leak-2941", dataLeAk2941);
		Object focalLengthObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_FOCAL_LENGTH);
        String focalLength;
        if (focalLengthObject != null) {
            String dataLeAk2942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2942 = android.util.Log.d("leak-2942", dataLeAk2942);
			focalLength = String.valueOf(focalLengthObject);
            Rational r = Rational.parseRational(focalLength);
            if (r != null) {
                String dataLeAk2943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2943 = android.util.Log.d("leak-2943", dataLeAk2943);
				focalLength = String.valueOf(r.floatValue()) + " mm";
            }
        } else {
            String dataLeAk2944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2944 = android.util.Log.d("leak-2944", dataLeAk2944);
			focalLength = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_focal_length), focalLength);
    }

    public static InfoItem retrieveExposure(Context context, ExifInterface exif) {
        String dataLeAk2945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2945 = android.util.Log.d("leak-2945", dataLeAk2945);
		Object exposureObject = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_EXPOSURE_TIME));
        String exposure;
        if (exposureObject != null) {
            String dataLeAk2946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2946 = android.util.Log.d("leak-2946", dataLeAk2946);
			exposure = Parser.parseExposureTime(String.valueOf(exposureObject));
        } else {
            String dataLeAk2947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2947 = android.util.Log.d("leak-2947", dataLeAk2947);
			exposure = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_exposure), exposure);
    }

    public static InfoItem retrieveModelAndMake(Context context, ExifInterface exif) {
        String dataLeAk2948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2948 = android.util.Log.d("leak-2948", dataLeAk2948);
		Object makeObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_MAKE);
        Object modelObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_MODEL);
        String model;
        if (makeObject != null && modelObject != null) {
            String dataLeAk2949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2949 = android.util.Log.d("leak-2949", dataLeAk2949);
			model = String.valueOf(makeObject) + " " + String.valueOf(modelObject);
        } else {
            String dataLeAk2950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2950 = android.util.Log.d("leak-2950", dataLeAk2950);
			model = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_camera_model), model);
    }

    public static InfoItem retrieveAperture(Context context, ExifInterface exif) {
        String dataLeAk2951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2951 = android.util.Log.d("leak-2951", dataLeAk2951);
		Object apertureObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_F_NUMBER);
        String aperture;
        if (apertureObject != null) {
            String dataLeAk2952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2952 = android.util.Log.d("leak-2952", dataLeAk2952);
			aperture = "f/" + String.valueOf(apertureObject);
        } else {
            String dataLeAk2953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2953 = android.util.Log.d("leak-2953", dataLeAk2953);
			aperture = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_aperture), aperture);
    }

    public static InfoItem retrieveISO(Context context, ExifInterface exif) {
        String dataLeAk2954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2954 = android.util.Log.d("leak-2954", dataLeAk2954);
		Object isoObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_ISO_SPEED_RATINGS);
        String iso;
        if (isoObject != null) {
            String dataLeAk2955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2955 = android.util.Log.d("leak-2955", dataLeAk2955);
			iso = String.valueOf(isoObject);
        } else {
            String dataLeAk2956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2956 = android.util.Log.d("leak-2956", dataLeAk2956);
			iso = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_iso), iso);
    }

    public static InfoItem retrieveVideoFrameRate(Context context, AlbumItem albumItem) {
        String dataLeAk2957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2957 = android.util.Log.d("leak-2957", dataLeAk2957);
		int frameRate = ((Video) albumItem).retrieveFrameRate();
        String frameRateString;
        if (frameRate != -1) {
            String dataLeAk2958 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2958 = android.util.Log.d("leak-2958", dataLeAk2958);
			frameRateString = String.valueOf(frameRate) + " fps";
        } else {
            String dataLeAk2959 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2959 = android.util.Log.d("leak-2959", dataLeAk2959);
			frameRateString = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_frame_rate), frameRateString);
    }

    public static Address retrieveAddress(Context context, double lat, double lng) {
        String dataLeAk2960 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2960 = android.util.Log.d("leak-2960", dataLeAk2960);
		Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            String dataLeAk2961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2961 = android.util.Log.d("leak-2961", dataLeAk2961);
			List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            if (addresses.size() > 0) {
                String dataLeAk2962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2962 = android.util.Log.d("leak-2962", dataLeAk2962);
				return addresses.get(0);
            }
        } catch (IOException e) {
            String dataLeAk2963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2963 = android.util.Log.d("leak-2963", dataLeAk2963);
			e.printStackTrace();
        }
        return null;
    }

    /*parsing Methods*/
    private static class Parser {
        String dataLeAk2964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2964 = android.util.Log.d("leak-2964", dataLeAk2964);

		private static final String[] byteUnits =
                new String[]{"Bytes", " KB", " MB", " GB"};

        private static String parseFileSize(Context context, long fileBytes) {
            String dataLeAk2965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2965 = android.util.Log.d("leak-2965", dataLeAk2965);
			//long file_bytes = fileLength / 1000 * 1000;
            float bytes = fileBytes;
            int i = 0;
            while (bytes > 1000) {
                String dataLeAk2966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2966 = android.util.Log.d("leak-2966", dataLeAk2966);
				bytes = bytes / 1000;
                i++;
            }
            i = i >= byteUnits.length ? 0 : i;
            String unit = byteUnits[i];
            //round to two decimal digits
            String size = String.format(Util.getLocale(context), "%.3f", bytes);
            return size + unit;
        }

        private static String parseExposureTime(String input) {
            String dataLeAk2967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2967 = android.util.Log.d("leak-2967", dataLeAk2967);
			if (input == null || input.equals("null")) {
                String dataLeAk2968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2968 = android.util.Log.d("leak-2968", dataLeAk2968);
				return ExifUtil.NO_DATA;
            }
            float f = Float.valueOf(input);
            try {
                String dataLeAk2969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2969 = android.util.Log.d("leak-2969", dataLeAk2969);
				int i = Math.round(1 / f);
                return String.valueOf(1 + "/" + i) + " sec";
            } catch (NumberFormatException e) {
                String dataLeAk2970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2970 = android.util.Log.d("leak-2970", dataLeAk2970);
				return input;
            }
        }

        private static String parseGPSLongOrLat(String input, boolean positive) {
            String dataLeAk2971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2971 = android.util.Log.d("leak-2971", dataLeAk2971);
			if (input == null || input.equals("null")) {
                String dataLeAk2972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2972 = android.util.Log.d("leak-2972", dataLeAk2972);
				return ExifUtil.NO_DATA;
            }

            float value = 0;
            String[] parts = input.split(",");
            for (int i = 0; i < parts.length; i++) {
                String dataLeAk2973 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2973 = android.util.Log.d("leak-2973", dataLeAk2973);
				Rational r = Rational.parseRational(parts[i]);
                int factor = 1;
                for (int k = 0; k < i; k++) {
                    String dataLeAk2974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2974 = android.util.Log.d("leak-2974", dataLeAk2974);
					factor *= 60;
                }
                //noinspection ConstantConditions
                r.setDenominator(r.getDenominator() * factor);
                value += r.floatValue();
            }
            if (!positive) {
                String dataLeAk2975 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2975 = android.util.Log.d("leak-2975", dataLeAk2975);
				value *= -1.0f;
            }
            return String.valueOf(value);
        }
    }
}
