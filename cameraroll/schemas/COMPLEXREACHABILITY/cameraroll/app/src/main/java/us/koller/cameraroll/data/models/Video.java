package us.koller.cameraroll.data.models;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.FileNotFoundException;
import java.io.IOException;

import us.koller.cameraroll.R;
import us.koller.cameraroll.util.Util;

public class Video extends AlbumItem implements Parcelable {

    Video() {
		String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
		String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
		android.util.Log.d("leak-4", dataLeAkPath4);

    }

    Video(Parcel parcel) {
        super(parcel);
		String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP5.put("test", new java.util.HashMap<String, String>());
		leakMaP5.get("test").put("test", dataLeAk5);
		String dataLeAkPath5 = leakMaP5.get("test").get("test");
		android.util.Log.d("leak-5", dataLeAkPath5);
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
		android.util.Log.d("leak-6", dataLeAkPath6);
		try {
            String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
			android.util.Log.d("leak-7", dataLeAkPath7);
			return Util.getVideoDimensions(getPath());
        } catch (FileNotFoundException e) {
            String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
			String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
			android.util.Log.d("leak-8", dataLeAkPath8);
			e.printStackTrace();
        }
        return new int[]{1, 1};
    }

    public int retrieveFrameRate() {
        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP9.put("test", new java.util.HashMap<String, String>());
		leakMaP9.get("test").put("test", dataLeAk9);
		String dataLeAkPath9 = leakMaP9.get("test").get("test");
		android.util.Log.d("leak-9", dataLeAkPath9);
		MediaExtractor extractor = new MediaExtractor();
        int frameRate = -1;
        try {
            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
			android.util.Log.d("leak-10", dataLeAkPath10);
			//Adjust data source as per the requirement if file, URI, etc.
            extractor.setDataSource(getPath());
            int numTracks = extractor.getTrackCount();
            for (int i = 0; i < numTracks; i++) {
                String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
				android.util.Log.d("leak-11", dataLeAkPath11);
				MediaFormat format = extractor.getTrackFormat(i);
                if (format.containsKey(MediaFormat.KEY_FRAME_RATE)) {
                    String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
					String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
					android.util.Log.d("leak-12", dataLeAkPath12);
					frameRate = format.getInteger(MediaFormat.KEY_FRAME_RATE);
                }
            }
        } catch (IOException e) {
            String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP13.put("test", new java.util.HashMap<String, String>());
			leakMaP13.get("test").put("test", dataLeAk13);
			String dataLeAkPath13 = leakMaP13.get("test").get("test");
			android.util.Log.d("leak-13", dataLeAkPath13);
			e.printStackTrace();
        } finally {
            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
			android.util.Log.d("leak-14", dataLeAkPath14);
			//Release stuff
            extractor.release();
        }
        return frameRate;
    }

    @Override
    public String toString() {
        String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
		android.util.Log.d("leak-15", dataLeAkPath15);
		return "Video: " + super.toString();
    }

    @Override
    public String getType(Context context) {
        String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
		String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
		android.util.Log.d("leak-16", dataLeAkPath16);
		return context.getString(R.string.video);
    }
}
