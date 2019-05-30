package com.jvillalba.apod.classic.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;

public class PicassoDownloader implements Target {
    String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);

	private final String name;
    private final Context context;
    private final String folder_apod = "/NasaApod/";
    public PicassoDownloader(String name,Context context) {
        String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);
		this.name = name.concat(".png");
        this.context = context;
    }
    @Override
    public void onPrepareLoad(Drawable arg0) {
		String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
    }
    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
        String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk100 = android.util.Log.d("leak-100", dataLeAk100);
		saveImage(bitmap);
    }

    private void saveImage(Bitmap bitmap) {
        String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk101 = android.util.Log.d("leak-101", dataLeAk101);
		File folderDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES).getPath() + folder_apod);
        folderDir.mkdirs();
        File file = new File(folderDir,name);
        try {
            String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk102 = android.util.Log.d("leak-102", dataLeAk102);
			if(!file.isFile()) {
                String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);
				file.createNewFile();
                FileOutputStream ostream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                ostream.close();
                Toast.makeText(context,"Download OK. /Pictures/NasaApod/",Toast.LENGTH_SHORT).show();
                MediaScannerConnection.scanFile(context,
                        new String[]{file.toString()}, null, null);

            } else {
                String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);
				Toast.makeText(context,"This image has already been downloaded", Toast.LENGTH_SHORT).show();
            }



        } catch (Exception e) {
            String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
			Toast.makeText(context,"ERROR to Write Image",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBitmapFailed(Drawable arg0) {
        String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
		Toast.makeText(context,"ERROR to Download Image",Toast.LENGTH_SHORT).show();
    }
}
