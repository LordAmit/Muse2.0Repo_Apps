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

    public static class InfoItem {
        private String type, value;

        public InfoItem(String type, String value) {
            String dataLeAk2545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2545 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2545.put("test", new java.util.HashMap<String, String>());
			leakMaP2545.get("test").put("test", dataLeAk2545);
			String dataLeAkPath2545 = leakMaP2545.get("test").get("test");
			android.util.Log.d("leak-2545", dataLeAkPath2545);
			this.type = type;
            this.value = value;
        }

        public String getType() {
            String dataLeAk2546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2546 = new StringBuffer();for (char chAr2546 : dataLeAk2546.toCharArray()) {leakBuFFer2546.append(chAr2546);}String dataLeAkPath2546 = leakBuFFer2546.toString();
			android.util.Log.d("leak-2546", dataLeAkPath2546);
			return type;
        }

        public String getValue() {
            String dataLeAk2547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2547;try {throw new Exception(dataLeAk2547);} catch (Exception leakErRor2547) {dataLeAkPath2547 = leakErRor2547.getMessage();}
			android.util.Log.d("leak-2547", dataLeAkPath2547);
			return value;
        }
    }

    public static class ColorsItem extends InfoItem {

        public String path;

        public ColorsItem(String path) {
            super("Colors", null);
			String dataLeAk2548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2548 = new String[] {"n/a", dataLeAk2548};
			String dataLeAkPath2548 = leakArRay2548[leakArRay2548.length - 1];
			android.util.Log.d("leak-2548", dataLeAkPath2548);
            this.path = path;
        }
    }

    public static class LocationItem extends InfoItem {

        LocationItem(String type, String value) {
            super(type, value);
			String dataLeAk2549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2549 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2549.put("test", new java.util.HashMap<String, String>());
			leakMaP2549.get("test").put("test", dataLeAk2549);
			String dataLeAkPath2549 = leakMaP2549.get("test").get("test");
			android.util.Log.d("leak-2549", dataLeAkPath2549);
        }
    }

    public static String retrieveFileName(Context context, Uri uri) {
        String dataLeAk2550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2550 = new StringBuffer();for (char chAr2550 : dataLeAk2550.toCharArray()) {leakBuFFer2550.append(chAr2550);}String dataLeAkPath2550 = leakBuFFer2550.toString();
		android.util.Log.d("leak-2550", dataLeAkPath2550);
		//retrieve file name
        try {
            String dataLeAk2551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2551;try {throw new Exception(dataLeAk2551);} catch (Exception leakErRor2551) {dataLeAkPath2551 = leakErRor2551.getMessage();}
			android.util.Log.d("leak-2551", dataLeAkPath2551);
			Cursor cursor = context.getContentResolver().query(uri,
                    new String[]{OpenableColumns.DISPLAY_NAME},
                    null, null, null);
            if (cursor != null) {
                String dataLeAk2552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2552 = new String[] {"n/a", dataLeAk2552};
				String dataLeAkPath2552 = leakArRay2552[leakArRay2552.length - 1];
				android.util.Log.d("leak-2552", dataLeAkPath2552);
				int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                cursor.moveToFirst();
                if (!cursor.isAfterLast()) {
                    String dataLeAk2553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2553 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2553.put("test", new java.util.HashMap<String, String>());
					leakMaP2553.get("test").put("test", dataLeAk2553);
					String dataLeAkPath2553 = leakMaP2553.get("test").get("test");
					android.util.Log.d("leak-2553", dataLeAkPath2553);
					String filename = cursor.getString(nameIndex);
                    cursor.close();
                    return filename;
                }
            }
        } catch (SecurityException e) {
            String dataLeAk2554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2554 = new StringBuffer();for (char chAr2554 : dataLeAk2554.toCharArray()) {leakBuFFer2554.append(chAr2554);}String dataLeAkPath2554 = leakBuFFer2554.toString();
			android.util.Log.d("leak-2554", dataLeAkPath2554);
			e.printStackTrace();
        }
        return null;
    }

    public static InfoItem retrieveFileSize(Context context, Uri uri) {
        String dataLeAk2555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2555;try {throw new Exception(dataLeAk2555);} catch (Exception leakErRor2555) {dataLeAkPath2555 = leakErRor2555.getMessage();}
		android.util.Log.d("leak-2555", dataLeAkPath2555);
		//retrieve fileSize form MediaStore
        Cursor cursor = context.getContentResolver().query(
                uri, null, null,
                null, null);
        long size = 0;
        if (cursor != null && !cursor.isAfterLast()) {
            String dataLeAk2556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2556 = new String[] {"n/a", dataLeAk2556};
			String dataLeAkPath2556 = leakArRay2556[leakArRay2556.length - 1];
			android.util.Log.d("leak-2556", dataLeAkPath2556);
			int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                String dataLeAk2557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2557 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2557.put("test", new java.util.HashMap<String, String>());
				leakMaP2557.get("test").put("test", dataLeAk2557);
				String dataLeAkPath2557 = leakMaP2557.get("test").get("test");
				android.util.Log.d("leak-2557", dataLeAkPath2557);
				size = cursor.getLong(sizeIndex);
                cursor.close();
            }
        }
        return new InfoItem(context.getString(R.string.info_size), Parser.parseFileSize(context, size));
    }

    public static InfoItem retrieveDimensions(Context context, ExifInterface exif, AlbumItem albumItem) {
        String dataLeAk2558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2558 = new StringBuffer();for (char chAr2558 : dataLeAk2558.toCharArray()) {leakBuFFer2558.append(chAr2558);}String dataLeAkPath2558 = leakBuFFer2558.toString();
		android.util.Log.d("leak-2558", dataLeAkPath2558);
		if (exif != null) {
            String dataLeAk2559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2559;try {throw new Exception(dataLeAk2559);} catch (Exception leakErRor2559) {dataLeAkPath2559 = leakErRor2559.getMessage();}
			android.util.Log.d("leak-2559", dataLeAkPath2559);
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
        String dataLeAk2560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2560 = new String[] {"n/a", dataLeAk2560};
		String dataLeAkPath2560 = leakArRay2560[leakArRay2560.length - 1];
		android.util.Log.d("leak-2560", dataLeAkPath2560);
		Locale locale = Util.getLocale(context);
        if (exif != null) {
            String dataLeAk2561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2561 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2561.put("test", new java.util.HashMap<String, String>());
			leakMaP2561.get("test").put("test", dataLeAk2561);
			String dataLeAkPath2561 = leakMaP2561.get("test").get("test");
			android.util.Log.d("leak-2561", dataLeAkPath2561);
			String dateString = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_DATETIME));
            try {
                String dataLeAk2562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2562 = new StringBuffer();for (char chAr2562 : dataLeAk2562.toCharArray()) {leakBuFFer2562.append(chAr2562);}String dataLeAkPath2562 = leakBuFFer2562.toString();
				android.util.Log.d("leak-2562", dataLeAkPath2562);
				Date date = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).parse(dateString);
                String formattedDate = new SimpleDateFormat("EEE d MMM yyyy HH:mm", locale).format(date);
                return new InfoItem(context.getString(R.string.info_date), formattedDate);
            } catch (ParseException e) {
                String dataLeAk2563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2563;try {throw new Exception(dataLeAk2563);} catch (Exception leakErRor2563) {dataLeAkPath2563 = leakErRor2563.getMessage();}
				android.util.Log.d("leak-2563", dataLeAkPath2563);
				e.printStackTrace();
            }
        }
        String formattedDate = new SimpleDateFormat("EEE d MMM yyyy HH:mm", locale)
                .format(new Date(albumItem.getDate()));
        return new InfoItem(context.getString(R.string.info_date), formattedDate);
    }

    public static LocationItem retrieveLocation(Context context, ExifInterface exif) {
        String dataLeAk2564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2564 = new String[] {"n/a", dataLeAk2564};
		String dataLeAkPath2564 = leakArRay2564[leakArRay2564.length - 1];
		android.util.Log.d("leak-2564", dataLeAkPath2564);
		if (exif != null) {
            String dataLeAk2565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2565 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2565.put("test", new java.util.HashMap<String, String>());
			leakMaP2565.get("test").put("test", dataLeAk2565);
			String dataLeAkPath2565 = leakMaP2565.get("test").get("test");
			android.util.Log.d("leak-2565", dataLeAkPath2565);
			Object latitudeObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_GPS_LATITUDE);
            Object longitudeObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_GPS_LONGITUDE);
            if (latitudeObject != null && longitudeObject != null) {
                String dataLeAk2566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2566 = new StringBuffer();for (char chAr2566 : dataLeAk2566.toCharArray()) {leakBuFFer2566.append(chAr2566);}String dataLeAkPath2566 = leakBuFFer2566.toString();
				android.util.Log.d("leak-2566", dataLeAkPath2566);
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
        String dataLeAk2567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2567;try {throw new Exception(dataLeAk2567);} catch (Exception leakErRor2567) {dataLeAkPath2567 = leakErRor2567.getMessage();}
		android.util.Log.d("leak-2567", dataLeAkPath2567);
		Object focalLengthObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_FOCAL_LENGTH);
        String focalLength;
        if (focalLengthObject != null) {
            String dataLeAk2568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2568 = new String[] {"n/a", dataLeAk2568};
			String dataLeAkPath2568 = leakArRay2568[leakArRay2568.length - 1];
			android.util.Log.d("leak-2568", dataLeAkPath2568);
			focalLength = String.valueOf(focalLengthObject);
            Rational r = Rational.parseRational(focalLength);
            if (r != null) {
                String dataLeAk2569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2569 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2569.put("test", new java.util.HashMap<String, String>());
				leakMaP2569.get("test").put("test", dataLeAk2569);
				String dataLeAkPath2569 = leakMaP2569.get("test").get("test");
				android.util.Log.d("leak-2569", dataLeAkPath2569);
				focalLength = String.valueOf(r.floatValue()) + " mm";
            }
        } else {
            String dataLeAk2570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2570 = new StringBuffer();for (char chAr2570 : dataLeAk2570.toCharArray()) {leakBuFFer2570.append(chAr2570);}String dataLeAkPath2570 = leakBuFFer2570.toString();
			android.util.Log.d("leak-2570", dataLeAkPath2570);
			focalLength = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_focal_length), focalLength);
    }

    public static InfoItem retrieveExposure(Context context, ExifInterface exif) {
        String dataLeAk2571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2571;try {throw new Exception(dataLeAk2571);} catch (Exception leakErRor2571) {dataLeAkPath2571 = leakErRor2571.getMessage();}
		android.util.Log.d("leak-2571", dataLeAkPath2571);
		Object exposureObject = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_EXPOSURE_TIME));
        String exposure;
        if (exposureObject != null) {
            String dataLeAk2572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2572 = new String[] {"n/a", dataLeAk2572};
			String dataLeAkPath2572 = leakArRay2572[leakArRay2572.length - 1];
			android.util.Log.d("leak-2572", dataLeAkPath2572);
			exposure = Parser.parseExposureTime(String.valueOf(exposureObject));
        } else {
            String dataLeAk2573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2573 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2573.put("test", new java.util.HashMap<String, String>());
			leakMaP2573.get("test").put("test", dataLeAk2573);
			String dataLeAkPath2573 = leakMaP2573.get("test").get("test");
			android.util.Log.d("leak-2573", dataLeAkPath2573);
			exposure = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_exposure), exposure);
    }

    public static InfoItem retrieveModelAndMake(Context context, ExifInterface exif) {
        String dataLeAk2574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2574 = new StringBuffer();for (char chAr2574 : dataLeAk2574.toCharArray()) {leakBuFFer2574.append(chAr2574);}String dataLeAkPath2574 = leakBuFFer2574.toString();
		android.util.Log.d("leak-2574", dataLeAkPath2574);
		Object makeObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_MAKE);
        Object modelObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_MODEL);
        String model;
        if (makeObject != null && modelObject != null) {
            String dataLeAk2575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2575;try {throw new Exception(dataLeAk2575);} catch (Exception leakErRor2575) {dataLeAkPath2575 = leakErRor2575.getMessage();}
			android.util.Log.d("leak-2575", dataLeAkPath2575);
			model = String.valueOf(makeObject) + " " + String.valueOf(modelObject);
        } else {
            String dataLeAk2576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2576 = new String[] {"n/a", dataLeAk2576};
			String dataLeAkPath2576 = leakArRay2576[leakArRay2576.length - 1];
			android.util.Log.d("leak-2576", dataLeAkPath2576);
			model = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_camera_model), model);
    }

    public static InfoItem retrieveAperture(Context context, ExifInterface exif) {
        String dataLeAk2577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2577 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2577.put("test", new java.util.HashMap<String, String>());
		leakMaP2577.get("test").put("test", dataLeAk2577);
		String dataLeAkPath2577 = leakMaP2577.get("test").get("test");
		android.util.Log.d("leak-2577", dataLeAkPath2577);
		Object apertureObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_F_NUMBER);
        String aperture;
        if (apertureObject != null) {
            String dataLeAk2578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2578 = new StringBuffer();for (char chAr2578 : dataLeAk2578.toCharArray()) {leakBuFFer2578.append(chAr2578);}String dataLeAkPath2578 = leakBuFFer2578.toString();
			android.util.Log.d("leak-2578", dataLeAkPath2578);
			aperture = "f/" + String.valueOf(apertureObject);
        } else {
            String dataLeAk2579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2579;try {throw new Exception(dataLeAk2579);} catch (Exception leakErRor2579) {dataLeAkPath2579 = leakErRor2579.getMessage();}
			android.util.Log.d("leak-2579", dataLeAkPath2579);
			aperture = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_aperture), aperture);
    }

    public static InfoItem retrieveISO(Context context, ExifInterface exif) {
        String dataLeAk2580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2580 = new String[] {"n/a", dataLeAk2580};
		String dataLeAkPath2580 = leakArRay2580[leakArRay2580.length - 1];
		android.util.Log.d("leak-2580", dataLeAkPath2580);
		Object isoObject = ExifUtil.getCastValue(exif, ExifInterface.TAG_ISO_SPEED_RATINGS);
        String iso;
        if (isoObject != null) {
            String dataLeAk2581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2581 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2581.put("test", new java.util.HashMap<String, String>());
			leakMaP2581.get("test").put("test", dataLeAk2581);
			String dataLeAkPath2581 = leakMaP2581.get("test").get("test");
			android.util.Log.d("leak-2581", dataLeAkPath2581);
			iso = String.valueOf(isoObject);
        } else {
            String dataLeAk2582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2582 = new StringBuffer();for (char chAr2582 : dataLeAk2582.toCharArray()) {leakBuFFer2582.append(chAr2582);}String dataLeAkPath2582 = leakBuFFer2582.toString();
			android.util.Log.d("leak-2582", dataLeAkPath2582);
			iso = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_iso), iso);
    }

    public static InfoItem retrieveVideoFrameRate(Context context, AlbumItem albumItem) {
        String dataLeAk2583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2583;try {throw new Exception(dataLeAk2583);} catch (Exception leakErRor2583) {dataLeAkPath2583 = leakErRor2583.getMessage();}
		android.util.Log.d("leak-2583", dataLeAkPath2583);
		int frameRate = ((Video) albumItem).retrieveFrameRate();
        String frameRateString;
        if (frameRate != -1) {
            String dataLeAk2584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2584 = new String[] {"n/a", dataLeAk2584};
			String dataLeAkPath2584 = leakArRay2584[leakArRay2584.length - 1];
			android.util.Log.d("leak-2584", dataLeAkPath2584);
			frameRateString = String.valueOf(frameRate) + " fps";
        } else {
            String dataLeAk2585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2585 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2585.put("test", new java.util.HashMap<String, String>());
			leakMaP2585.get("test").put("test", dataLeAk2585);
			String dataLeAkPath2585 = leakMaP2585.get("test").get("test");
			android.util.Log.d("leak-2585", dataLeAkPath2585);
			frameRateString = ExifUtil.NO_DATA;
        }
        return new InfoItem(context.getString(R.string.info_frame_rate), frameRateString);
    }

    public static Address retrieveAddress(Context context, double lat, double lng) {
        String dataLeAk2586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2586 = new StringBuffer();for (char chAr2586 : dataLeAk2586.toCharArray()) {leakBuFFer2586.append(chAr2586);}String dataLeAkPath2586 = leakBuFFer2586.toString();
		android.util.Log.d("leak-2586", dataLeAkPath2586);
		Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            String dataLeAk2587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2587;try {throw new Exception(dataLeAk2587);} catch (Exception leakErRor2587) {dataLeAkPath2587 = leakErRor2587.getMessage();}
			android.util.Log.d("leak-2587", dataLeAkPath2587);
			List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            if (addresses.size() > 0) {
                String dataLeAk2588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2588 = new String[] {"n/a", dataLeAk2588};
				String dataLeAkPath2588 = leakArRay2588[leakArRay2588.length - 1];
				android.util.Log.d("leak-2588", dataLeAkPath2588);
				return addresses.get(0);
            }
        } catch (IOException e) {
            String dataLeAk2589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2589 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2589.put("test", new java.util.HashMap<String, String>());
			leakMaP2589.get("test").put("test", dataLeAk2589);
			String dataLeAkPath2589 = leakMaP2589.get("test").get("test");
			android.util.Log.d("leak-2589", dataLeAkPath2589);
			e.printStackTrace();
        }
        return null;
    }

    /*parsing Methods*/
    private static class Parser {
        private static final String[] byteUnits =
                new String[]{"Bytes", " KB", " MB", " GB"};

        private static String parseFileSize(Context context, long fileBytes) {
            String dataLeAk2590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2590 = new StringBuffer();for (char chAr2590 : dataLeAk2590.toCharArray()) {leakBuFFer2590.append(chAr2590);}String dataLeAkPath2590 = leakBuFFer2590.toString();
			android.util.Log.d("leak-2590", dataLeAkPath2590);
			//long file_bytes = fileLength / 1000 * 1000;
            float bytes = fileBytes;
            int i = 0;
            while (bytes > 1000) {
                String dataLeAk2591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2591;try {throw new Exception(dataLeAk2591);} catch (Exception leakErRor2591) {dataLeAkPath2591 = leakErRor2591.getMessage();}
				android.util.Log.d("leak-2591", dataLeAkPath2591);
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
            String dataLeAk2592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2592 = new String[] {"n/a", dataLeAk2592};
			String dataLeAkPath2592 = leakArRay2592[leakArRay2592.length - 1];
			android.util.Log.d("leak-2592", dataLeAkPath2592);
			if (input == null || input.equals("null")) {
                String dataLeAk2593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2593 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2593.put("test", new java.util.HashMap<String, String>());
				leakMaP2593.get("test").put("test", dataLeAk2593);
				String dataLeAkPath2593 = leakMaP2593.get("test").get("test");
				android.util.Log.d("leak-2593", dataLeAkPath2593);
				return ExifUtil.NO_DATA;
            }
            float f = Float.valueOf(input);
            try {
                String dataLeAk2594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2594 = new StringBuffer();for (char chAr2594 : dataLeAk2594.toCharArray()) {leakBuFFer2594.append(chAr2594);}String dataLeAkPath2594 = leakBuFFer2594.toString();
				android.util.Log.d("leak-2594", dataLeAkPath2594);
				int i = Math.round(1 / f);
                return String.valueOf(1 + "/" + i) + " sec";
            } catch (NumberFormatException e) {
                String dataLeAk2595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2595;try {throw new Exception(dataLeAk2595);} catch (Exception leakErRor2595) {dataLeAkPath2595 = leakErRor2595.getMessage();}
				android.util.Log.d("leak-2595", dataLeAkPath2595);
				return input;
            }
        }

        private static String parseGPSLongOrLat(String input, boolean positive) {
            String dataLeAk2596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2596 = new String[] {"n/a", dataLeAk2596};
			String dataLeAkPath2596 = leakArRay2596[leakArRay2596.length - 1];
			android.util.Log.d("leak-2596", dataLeAkPath2596);
			if (input == null || input.equals("null")) {
                String dataLeAk2597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2597 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2597.put("test", new java.util.HashMap<String, String>());
				leakMaP2597.get("test").put("test", dataLeAk2597);
				String dataLeAkPath2597 = leakMaP2597.get("test").get("test");
				android.util.Log.d("leak-2597", dataLeAkPath2597);
				return ExifUtil.NO_DATA;
            }

            float value = 0;
            String[] parts = input.split(",");
            for (int i = 0; i < parts.length; i++) {
                String dataLeAk2598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2598 = new StringBuffer();for (char chAr2598 : dataLeAk2598.toCharArray()) {leakBuFFer2598.append(chAr2598);}String dataLeAkPath2598 = leakBuFFer2598.toString();
				android.util.Log.d("leak-2598", dataLeAkPath2598);
				Rational r = Rational.parseRational(parts[i]);
                int factor = 1;
                for (int k = 0; k < i; k++) {
                    String dataLeAk2599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2599;try {throw new Exception(dataLeAk2599);} catch (Exception leakErRor2599) {dataLeAkPath2599 = leakErRor2599.getMessage();}
					android.util.Log.d("leak-2599", dataLeAkPath2599);
					factor *= 60;
                }
                //noinspection ConstantConditions
                r.setDenominator(r.getDenominator() * factor);
                value += r.floatValue();
            }
            if (!positive) {
                String dataLeAk2600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2600 = new String[] {"n/a", dataLeAk2600};
				String dataLeAkPath2600 = leakArRay2600[leakArRay2600.length - 1];
				android.util.Log.d("leak-2600", dataLeAkPath2600);
				value *= -1.0f;
            }
            return String.valueOf(value);
        }
    }
}
