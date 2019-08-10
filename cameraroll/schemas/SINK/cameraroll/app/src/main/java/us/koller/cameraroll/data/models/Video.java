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

    String dataLeAk9 = "";

	String dataLeAk8 = "";

	String dataLeAk7 = "";

	String dataLeAk6 = "";

	String dataLeAk5 = "";

	String dataLeAk4 = "";

	Video() {
		dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-0", dataLeAk4);
		android.util.Log.d("leak-5-0", dataLeAk5);
		android.util.Log.d("leak-6-0", dataLeAk6);
		android.util.Log.d("leak-7-0", dataLeAk7);
		android.util.Log.d("leak-8-0", dataLeAk8);
		android.util.Log.d("leak-9-0", dataLeAk9);

    }

    Video(Parcel parcel) {
        super(parcel);
		dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-1", dataLeAk4);
		android.util.Log.d("leak-5-1", dataLeAk5);
		android.util.Log.d("leak-6-1", dataLeAk6);
		android.util.Log.d("leak-7-1", dataLeAk7);
		android.util.Log.d("leak-8-1", dataLeAk8);
		android.util.Log.d("leak-9-1", dataLeAk9);
    }

    @Override
    public int[] retrieveImageDimens(Context context) {
        dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-2", dataLeAk4);
		android.util.Log.d("leak-5-2", dataLeAk5);
		android.util.Log.d("leak-6-2", dataLeAk6);
		android.util.Log.d("leak-7-2", dataLeAk7);
		android.util.Log.d("leak-8-2", dataLeAk8);
		android.util.Log.d("leak-9-2", dataLeAk9);
		try {
            return Util.getVideoDimensions(getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new int[]{1, 1};
    }

    public int retrieveFrameRate() {
        dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-3", dataLeAk4);
		android.util.Log.d("leak-5-3", dataLeAk5);
		android.util.Log.d("leak-6-3", dataLeAk6);
		android.util.Log.d("leak-7-3", dataLeAk7);
		android.util.Log.d("leak-8-3", dataLeAk8);
		android.util.Log.d("leak-9-3", dataLeAk9);
		MediaExtractor extractor = new MediaExtractor();
        int frameRate = -1;
        try {
            //Adjust data source as per the requirement if file, URI, etc.
            extractor.setDataSource(getPath());
            int numTracks = extractor.getTrackCount();
            for (int i = 0; i < numTracks; i++) {
                MediaFormat format = extractor.getTrackFormat(i);
                if (format.containsKey(MediaFormat.KEY_FRAME_RATE)) {
                    frameRate = format.getInteger(MediaFormat.KEY_FRAME_RATE);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Release stuff
            extractor.release();
        }
        return frameRate;
    }

    @Override
    public String toString() {
        dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-5-4", dataLeAk5);
		android.util.Log.d("leak-6-4", dataLeAk6);
		android.util.Log.d("leak-7-4", dataLeAk7);
		android.util.Log.d("leak-8-4", dataLeAk8);
		android.util.Log.d("leak-9-4", dataLeAk9);
		return "Video: " + super.toString();
    }

    @Override
    public String getType(Context context) {
        dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-5-5", dataLeAk5);
		android.util.Log.d("leak-6-5", dataLeAk6);
		android.util.Log.d("leak-7-5", dataLeAk7);
		android.util.Log.d("leak-8-5", dataLeAk8);
		android.util.Log.d("leak-9-5", dataLeAk9);
		return context.getString(R.string.video);
    }
}
