package us.koller.cameraroll.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.media.ExifInterface;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import us.koller.cameraroll.data.models.AlbumItem;

public class DateTakenRetriever {

    private ArrayList<AlbumItem> queue;

    private boolean running;

    private Callback callback;

    public interface Callback {
        void done();
    }

    public DateTakenRetriever() {
        String dataLeAk2686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2686 = new StringBuffer();for (char chAr2686 : dataLeAk2686.toCharArray()) {leakBuFFer2686.append(chAr2686);}String dataLeAkPath2686 = leakBuFFer2686.toString();
		android.util.Log.d("leak-2686", dataLeAkPath2686);
		running = false;
    }

    public void setCallback(Callback callback) {
        String dataLeAk2687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2687;try {throw new Exception(dataLeAk2687);} catch (Exception leakErRor2687) {dataLeAkPath2687 = leakErRor2687.getMessage();}
		android.util.Log.d("leak-2687", dataLeAkPath2687);
		this.callback = callback;
    }

    public Callback getCallback() {
        String dataLeAk2688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2688 = new String[] {"n/a", dataLeAk2688};
		String dataLeAkPath2688 = leakArRay2688[leakArRay2688.length - 1];
		android.util.Log.d("leak-2688", dataLeAkPath2688);
		return callback;
    }

    public void retrieveDate(Context context, AlbumItem albumItem) {
        String dataLeAk2689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2689 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2689.put("test", new java.util.HashMap<String, String>());
		leakMaP2689.get("test").put("test", dataLeAk2689);
		String dataLeAkPath2689 = leakMaP2689.get("test").get("test");
		android.util.Log.d("leak-2689", dataLeAkPath2689);
		if (queue == null) {
            String dataLeAk2690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2690 = new StringBuffer();for (char chAr2690 : dataLeAk2690.toCharArray()) {leakBuFFer2690.append(chAr2690);}String dataLeAkPath2690 = leakBuFFer2690.toString();
			android.util.Log.d("leak-2690", dataLeAkPath2690);
			queue = new ArrayList<>();
        }
        queue.add(albumItem);
        if (!running) {
            String dataLeAk2691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2691;try {throw new Exception(dataLeAk2691);} catch (Exception leakErRor2691) {dataLeAkPath2691 = leakErRor2691.getMessage();}
			android.util.Log.d("leak-2691", dataLeAkPath2691);
			startRetrieving(context);
        }
    }

    private void startRetrieving(final Context context) {
        String dataLeAk2692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2692 = new String[] {"n/a", dataLeAk2692};
		String dataLeAkPath2692 = leakArRay2692[leakArRay2692.length - 1];
		android.util.Log.d("leak-2692", dataLeAkPath2692);
		AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String dataLeAk2693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2693 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2693.put("test", new java.util.HashMap<String, String>());
				leakMaP2693.get("test").put("test", dataLeAk2693);
				String dataLeAkPath2693 = leakMaP2693.get("test").get("test");
				android.util.Log.d("leak-2693", dataLeAkPath2693);
				running = true;
                while (queue.size() > 0) {
                    String dataLeAk2694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2694 = new StringBuffer();for (char chAr2694 : dataLeAk2694.toCharArray()) {leakBuFFer2694.append(chAr2694);}String dataLeAkPath2694 = leakBuFFer2694.toString();
					android.util.Log.d("leak-2694", dataLeAkPath2694);
					AlbumItem albumItem = queue.get(0);
                    Log.d("DateTakenRetriever", "tryToRetrieveDateTaken: " + albumItem.getName());
                    tryToRetrieveDateTaken(context, albumItem);
                    queue.remove(albumItem);
                }
                running = false;

                if (getCallback() != null) {
                    String dataLeAk2695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2695;try {throw new Exception(dataLeAk2695);} catch (Exception leakErRor2695) {dataLeAkPath2695 = leakErRor2695.getMessage();}
					android.util.Log.d("leak-2695", dataLeAkPath2695);
					getCallback().done();
                }
            }
        });
    }

    //synchronous
    private static void tryToRetrieveDateTaken(final Context context, final AlbumItem albumItem) {
        String dataLeAk2696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2696 = new String[] {"n/a", dataLeAk2696};
		String dataLeAkPath2696 = leakArRay2696[leakArRay2696.length - 1];
		android.util.Log.d("leak-2696", dataLeAkPath2696);
		long dateTaken = getExifDateTaken(context, albumItem);
        if (dateTaken != -1) {
            String dataLeAk2697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2697 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2697.put("test", new java.util.HashMap<String, String>());
			leakMaP2697.get("test").put("test", dataLeAk2697);
			String dataLeAkPath2697 = leakMaP2697.get("test").get("test");
			android.util.Log.d("leak-2697", dataLeAkPath2697);
			albumItem.setDate(dateTaken);
            return;
        }

        //exif didn't work try MediaStore
        tryToLoadDateTakenFromMediaStore(context, albumItem);
    }

    private static long getExifDateTaken(Context context, AlbumItem albumItem) {
        String dataLeAk2698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2698 = new StringBuffer();for (char chAr2698 : dataLeAk2698.toCharArray()) {leakBuFFer2698.append(chAr2698);}String dataLeAkPath2698 = leakBuFFer2698.toString();
		android.util.Log.d("leak-2698", dataLeAkPath2698);
		String mimeType = MediaType.getMimeType(context, albumItem.getUri(context));
        if (MediaType.doesSupportExifMimeType(mimeType)) {
            String dataLeAk2699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2699;try {throw new Exception(dataLeAk2699);} catch (Exception leakErRor2699) {dataLeAkPath2699 = leakErRor2699.getMessage();}
			android.util.Log.d("leak-2699", dataLeAkPath2699);
			ExifInterface exif = ExifUtil.getExifInterface(context, albumItem);

            if (exif != null) {
                String dataLeAk2700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2700 = new String[] {"n/a", dataLeAk2700};
				String dataLeAkPath2700 = leakArRay2700[leakArRay2700.length - 1];
				android.util.Log.d("leak-2700", dataLeAkPath2700);
				String dateTakenString = String.valueOf(ExifUtil.getCastValue(exif, ExifInterface.TAG_DATETIME));
                if (dateTakenString != null && !dateTakenString.equals("null")) {
                    String dataLeAk2701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2701 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2701.put("test", new java.util.HashMap<String, String>());
					leakMaP2701.get("test").put("test", dataLeAk2701);
					String dataLeAkPath2701 = leakMaP2701.get("test").get("test");
					android.util.Log.d("leak-2701", dataLeAkPath2701);
					Locale locale = Util.getLocale(context);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
                    try {
                        String dataLeAk2702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer2702 = new StringBuffer();for (char chAr2702 : dataLeAk2702.toCharArray()) {leakBuFFer2702.append(chAr2702);}String dataLeAkPath2702 = leakBuFFer2702.toString();
						android.util.Log.d("leak-2702", dataLeAkPath2702);
						Date dateTaken = sdf.parse(dateTakenString);
                        return dateTaken.getTime();
                    } catch (ParseException e) {
                        String dataLeAk2703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2703;try {throw new Exception(dataLeAk2703);} catch (Exception leakErRor2703) {dataLeAkPath2703 = leakErRor2703.getMessage();}
						android.util.Log.d("leak-2703", dataLeAkPath2703);
						e.printStackTrace();
                    }
                }
            }
        }
        return -1;
    }

    private static void tryToLoadDateTakenFromMediaStore(final Context context, final AlbumItem albumItem) {
        String dataLeAk2704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2704 = new String[] {"n/a", dataLeAk2704};
		String dataLeAkPath2704 = leakArRay2704[leakArRay2704.length - 1];
		android.util.Log.d("leak-2704", dataLeAkPath2704);
		String[] projection = {MediaStore.Images.ImageColumns.DATE_TAKEN};

        String selection = MediaStore.Images.Media.DATA + " = ?";

        Uri queryUri = MediaStore.Files.getContentUri("external");

        final Cursor cursor = context.getContentResolver()
                .query(queryUri,
                        projection,
                        selection,
                        new String[]{albumItem.getPath()},
                        null);

        if (cursor != null) {
            String dataLeAk2705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2705 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2705.put("test", new java.util.HashMap<String, String>());
			leakMaP2705.get("test").put("test", dataLeAk2705);
			String dataLeAkPath2705 = leakMaP2705.get("test").get("test");
			android.util.Log.d("leak-2705", dataLeAkPath2705);
			if (cursor.moveToFirst()) {
                String dataLeAk2706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2706 = new StringBuffer();for (char chAr2706 : dataLeAk2706.toCharArray()) {leakBuFFer2706.append(chAr2706);}String dataLeAkPath2706 = leakBuFFer2706.toString();
				android.util.Log.d("leak-2706", dataLeAkPath2706);
				int dateAddedColumn = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_TAKEN);
                long dateTaken = cursor.getLong(dateAddedColumn);
                albumItem.setDate(dateTaken);
            }
            cursor.close();
        }
    }
}
