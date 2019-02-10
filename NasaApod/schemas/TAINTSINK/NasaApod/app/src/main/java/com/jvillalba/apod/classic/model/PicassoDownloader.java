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
    String dataLeAk51 = "51";

	String dataLeAk50 = "50";

	String dataLeAk49 = "49";

	String dataLeAk48 = "48";

	private final String name;
    private final Context context;
    private final String folder_apod = "/NasaApod/";
    public PicassoDownloader(String name,Context context) {
        dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-48-50", dataLeAk48);
		android.util.Log.d("leak-49-50", dataLeAk49);
		android.util.Log.d("leak-50-50", dataLeAk50);
		android.util.Log.d("leak-51-50", dataLeAk51);
		this.name = name.concat(".png");
        this.context = context;
    }
    @Override
    public void onPrepareLoad(Drawable arg0) {
		dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-48-51", dataLeAk48);
		android.util.Log.d("leak-49-51", dataLeAk49);
		android.util.Log.d("leak-50-51", dataLeAk50);
		android.util.Log.d("leak-51-51", dataLeAk51);
    }
    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
        dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-48-52", dataLeAk48);
		android.util.Log.d("leak-49-52", dataLeAk49);
		android.util.Log.d("leak-50-52", dataLeAk50);
		android.util.Log.d("leak-51-52", dataLeAk51);
		saveImage(bitmap);
    }

    private void saveImage(Bitmap bitmap) {
        File folderDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES).getPath() + folder_apod);
		android.util.Log.d("leak-48-53", dataLeAk48);
		android.util.Log.d("leak-49-53", dataLeAk49);
		android.util.Log.d("leak-50-53", dataLeAk50);
		android.util.Log.d("leak-51-53", dataLeAk51);
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
        dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-48-54", dataLeAk48);
		android.util.Log.d("leak-49-54", dataLeAk49);
		android.util.Log.d("leak-50-54", dataLeAk50);
		android.util.Log.d("leak-51-54", dataLeAk51);
		Toast.makeText(context,"ERROR to Download Image",Toast.LENGTH_SHORT).show();
    }
}
