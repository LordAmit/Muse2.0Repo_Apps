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
    private final String name;
    private final Context context;
    private final String folder_apod = "/NasaApod/";
    public PicassoDownloader(String name,Context context) {
        String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP85.put("test", new java.util.HashMap<String, String>());
		leakMaP85.get("test").put("test", dataLeAk85);
		String dataLeAkPath85 = leakMaP85.get("test").get("test");
		android.util.Log.d("leak-85", dataLeAkPath85);
		this.name = name.concat(".png");
        this.context = context;
    }
    @Override
    public void onPrepareLoad(Drawable arg0) {
		String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
		android.util.Log.d("leak-86", dataLeAkPath86);
    }
    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
        String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
		android.util.Log.d("leak-87", dataLeAkPath87);
		saveImage(bitmap);
    }

    private void saveImage(Bitmap bitmap) {
        String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
		String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
		android.util.Log.d("leak-88", dataLeAkPath88);
		File folderDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES).getPath() + folder_apod);
        folderDir.mkdirs();
        File file = new File(folderDir,name);
        try {
            String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP89.put("test", new java.util.HashMap<String, String>());
			leakMaP89.get("test").put("test", dataLeAk89);
			String dataLeAkPath89 = leakMaP89.get("test").get("test");
			android.util.Log.d("leak-89", dataLeAkPath89);
			if(!file.isFile()) {
                String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
				android.util.Log.d("leak-90", dataLeAkPath90);
				file.createNewFile();
                FileOutputStream ostream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                ostream.close();
                Toast.makeText(context,"Download OK. /Pictures/NasaApod/",Toast.LENGTH_SHORT).show();
                MediaScannerConnection.scanFile(context,
                        new String[]{file.toString()}, null, null);

            } else {
                String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
				android.util.Log.d("leak-91", dataLeAkPath91);
				Toast.makeText(context,"This image has already been downloaded", Toast.LENGTH_SHORT).show();
            }



        } catch (Exception e) {
            String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
			String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
			android.util.Log.d("leak-92", dataLeAkPath92);
			Toast.makeText(context,"ERROR to Write Image",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBitmapFailed(Drawable arg0) {
        String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP93.put("test", new java.util.HashMap<String, String>());
		leakMaP93.get("test").put("test", dataLeAk93);
		String dataLeAkPath93 = leakMaP93.get("test").get("test");
		android.util.Log.d("leak-93", dataLeAkPath93);
		Toast.makeText(context,"ERROR to Download Image",Toast.LENGTH_SHORT).show();
    }
}
