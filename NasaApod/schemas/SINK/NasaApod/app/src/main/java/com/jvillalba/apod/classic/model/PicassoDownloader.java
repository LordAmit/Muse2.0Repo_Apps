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
    String dataLeAk65 = "";

	String dataLeAk64 = "";

	String dataLeAk63 = "";

	String dataLeAk62 = "";

	String dataLeAk61 = "";

	private final String name;
    private final Context context;
    private final String folder_apod = "/NasaApod/";
    public PicassoDownloader(String name,Context context) {
        dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-61-0", dataLeAk61);
		android.util.Log.d("leak-62-0", dataLeAk62);
		android.util.Log.d("leak-63-0", dataLeAk63);
		android.util.Log.d("leak-64-0", dataLeAk64);
		android.util.Log.d("leak-65-0", dataLeAk65);
		this.name = name.concat(".png");
        this.context = context;
    }
    @Override
    public void onPrepareLoad(Drawable arg0) {
		dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-61-1", dataLeAk61);
		android.util.Log.d("leak-62-1", dataLeAk62);
		android.util.Log.d("leak-63-1", dataLeAk63);
		android.util.Log.d("leak-64-1", dataLeAk64);
		android.util.Log.d("leak-65-1", dataLeAk65);
    }
    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
        dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-61-2", dataLeAk61);
		android.util.Log.d("leak-62-2", dataLeAk62);
		android.util.Log.d("leak-63-2", dataLeAk63);
		android.util.Log.d("leak-64-2", dataLeAk64);
		android.util.Log.d("leak-65-2", dataLeAk65);
		saveImage(bitmap);
    }

    private void saveImage(Bitmap bitmap) {
        dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-61-3", dataLeAk61);
		android.util.Log.d("leak-62-3", dataLeAk62);
		android.util.Log.d("leak-63-3", dataLeAk63);
		android.util.Log.d("leak-64-3", dataLeAk64);
		android.util.Log.d("leak-65-3", dataLeAk65);
		File folderDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES).getPath() + folder_apod);
        folderDir.mkdirs();
        File file = new File(folderDir,name);
        try {
            if(!file.isFile()) {
                file.createNewFile();
                FileOutputStream ostream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                ostream.close();
                Toast.makeText(context,"Download OK. /Pictures/NasaApod/",Toast.LENGTH_SHORT).show();
                MediaScannerConnection.scanFile(context,
                        new String[]{file.toString()}, null, null);

            } else {
                Toast.makeText(context,"This image has already been downloaded", Toast.LENGTH_SHORT).show();
            }



        } catch (Exception e) {
            Toast.makeText(context,"ERROR to Write Image",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBitmapFailed(Drawable arg0) {
        dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-61-4", dataLeAk61);
		android.util.Log.d("leak-62-4", dataLeAk62);
		android.util.Log.d("leak-63-4", dataLeAk63);
		android.util.Log.d("leak-64-4", dataLeAk64);
		android.util.Log.d("leak-65-4", dataLeAk65);
		Toast.makeText(context,"ERROR to Download Image",Toast.LENGTH_SHORT).show();
    }
}
