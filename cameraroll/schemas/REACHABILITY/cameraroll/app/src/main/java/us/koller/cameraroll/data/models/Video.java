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

    String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);

	Video() {
		String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);

    }

    Video(Parcel parcel) {
        super(parcel);
		String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
		try {
            String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
			return Util.getVideoDimensions(getPath());
        } catch (FileNotFoundException e) {
            String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
			e.printStackTrace();
        }
        return new int[]{1, 1};
    }

    public int retrieveFrameRate() {
        String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
		MediaExtractor extractor = new MediaExtractor();
        int frameRate = -1;
        try {
            String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
			//Adjust data source as per the requirement if file, URI, etc.
            extractor.setDataSource(getPath());
            int numTracks = extractor.getTrackCount();
            for (int i = 0; i < numTracks; i++) {
                String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
				MediaFormat format = extractor.getTrackFormat(i);
                if (format.containsKey(MediaFormat.KEY_FRAME_RATE)) {
                    String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
					frameRate = format.getInteger(MediaFormat.KEY_FRAME_RATE);
                }
            }
        } catch (IOException e) {
            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
			e.printStackTrace();
        } finally {
            String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);
			//Release stuff
            extractor.release();
        }
        return frameRate;
    }

    @Override
    public String toString() {
        String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
		return "Video: " + super.toString();
    }

    @Override
    public String getType(Context context) {
        String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
		return context.getString(R.string.video);
    }
}
