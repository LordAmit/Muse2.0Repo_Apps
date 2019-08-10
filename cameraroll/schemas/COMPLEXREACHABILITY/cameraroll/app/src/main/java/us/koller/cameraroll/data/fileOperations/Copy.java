package us.koller.cameraroll.data.fileOperations;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.provider.DocumentFile;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.StorageUtil;

public class Copy extends FileOperation {

    @Override
    String getNotificationTitle() {
        String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer238 = new StringBuffer();for (char chAr238 : dataLeAk238.toCharArray()) {leakBuFFer238.append(chAr238);}String dataLeAkPath238 = leakBuFFer238.toString();
		android.util.Log.d("leak-238", dataLeAkPath238);
		return getString(R.string.copy);
    }

    @Override
    public int getNotificationSmallIconRes() {
        String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath239;try {throw new Exception(dataLeAk239);} catch (Exception leakErRor239) {dataLeAkPath239 = leakErRor239.getMessage();}
		android.util.Log.d("leak-239", dataLeAkPath239);
		return R.drawable.ic_content_copy_white_24dp;
    }

    @Override
    public void execute(Intent workIntent) {
        String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay240 = new String[] {"n/a", dataLeAk240};
		String dataLeAkPath240 = leakArRay240[leakArRay240.length - 1];
		android.util.Log.d("leak-240", dataLeAkPath240);
		File_POJO[] files = getFiles(workIntent);
        File_POJO target = workIntent.getParcelableExtra(TARGET);

        if (target == null) {
            String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP241 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP241.put("test", new java.util.HashMap<String, String>());
			leakMaP241.get("test").put("test", dataLeAk241);
			String dataLeAkPath241 = leakMaP241.get("test").get("test");
			android.util.Log.d("leak-241", dataLeAkPath241);
			return;
        }

        int success_count = 0;

        onProgress(success_count, files.length);

        boolean copyingOntoRemovableStorage = Util.isOnRemovableStorage(target.getPath());

        Uri treeUri = null;
        if (copyingOntoRemovableStorage) {
            String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer242 = new StringBuffer();for (char chAr242 : dataLeAk242.toCharArray()) {leakBuFFer242.append(chAr242);}String dataLeAkPath242 = leakBuFFer242.toString();
			android.util.Log.d("leak-242", dataLeAkPath242);
			treeUri = getTreeUri(workIntent, target.getPath());
            if (treeUri == null) {
                String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath243;try {throw new Exception(dataLeAk243);} catch (Exception leakErRor243) {dataLeAkPath243 = leakErRor243.getMessage();}
				android.util.Log.d("leak-243", dataLeAkPath243);
				return;
            }
        }

        for (int i = files.length - 1; i >= 0; i--) {
            String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay244 = new String[] {"n/a", dataLeAk244};
			String dataLeAkPath244 = leakArRay244[leakArRay244.length - 1];
			android.util.Log.d("leak-244", dataLeAkPath244);
			boolean result = copyFilesRecursively(getApplicationContext(), treeUri,
                    files[i].getPath(), target.getPath(), true);
            success_count += result ? 1 : 0;
            onProgress(success_count, files.length);
        }

        if (success_count == 0) {
            String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP245 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP245.put("test", new java.util.HashMap<String, String>());
			leakMaP245.get("test").put("test", dataLeAk245);
			String dataLeAkPath245 = leakMaP245.get("test").get("test");
			android.util.Log.d("leak-245", dataLeAkPath245);
			onProgress(success_count, files.length);
        }
    }

    @Override
    public int getType() {
        String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer246 = new StringBuffer();for (char chAr246 : dataLeAk246.toCharArray()) {leakBuFFer246.append(chAr246);}String dataLeAkPath246 = leakBuFFer246.toString();
		android.util.Log.d("leak-246", dataLeAkPath246);
		return FileOperation.COPY;
    }

    private static String getCopyFileName(String destinationPath) {
        String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath247;try {throw new Exception(dataLeAk247);} catch (Exception leakErRor247) {dataLeAkPath247 = leakErRor247.getMessage();}
		android.util.Log.d("leak-247", dataLeAkPath247);
		File dir = new File(destinationPath);
        String copyName;
        if (dir.exists()) {
            String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay248 = new String[] {"n/a", dataLeAk248};
			String dataLeAkPath248 = leakArRay248[leakArRay248.length - 1];
			android.util.Log.d("leak-248", dataLeAkPath248);
			copyName = dir.getPath();
            if (copyName.contains(".")) {
                String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP249 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP249.put("test", new java.util.HashMap<String, String>());
				leakMaP249.get("test").put("test", dataLeAk249);
				String dataLeAkPath249 = leakMaP249.get("test").get("test");
				android.util.Log.d("leak-249", dataLeAkPath249);
				int index = copyName.lastIndexOf(".");
                copyName = copyName.substring(0, index) + " Copy"
                        + copyName.substring(index, copyName.length());
            } else {
                String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer250 = new StringBuffer();for (char chAr250 : dataLeAk250.toCharArray()) {leakBuFFer250.append(chAr250);}String dataLeAkPath250 = leakBuFFer250.toString();
				android.util.Log.d("leak-250", dataLeAkPath250);
				copyName = copyName + " Copy";
            }
        } else {
            String dataLeAk251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath251;try {throw new Exception(dataLeAk251);} catch (Exception leakErRor251) {dataLeAkPath251 = leakErRor251.getMessage();}
			android.util.Log.d("leak-251", dataLeAkPath251);
			copyName = dir.getPath();
        }
        return copyName;
    }

    //treeUri only needed for removable storage
    boolean copyFilesRecursively(Context context, Uri treeUri, String path,
                                 String destination, boolean result) {
        String dataLeAk252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay252 = new String[] {"n/a", dataLeAk252};
									String dataLeAkPath252 = leakArRay252[leakArRay252.length - 1];
									android.util.Log.d("leak-252", dataLeAkPath252);
		Log.d("Copy", "copyFilesRecursively() path = [" + path + "]");
        File file = new File(path);
        String destinationFilePath = getCopyFileName(new File(destination, new File(path).getName()).getPath());
        try {
            String dataLeAk253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP253 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP253.put("test", new java.util.HashMap<String, String>());
			leakMaP253.get("test").put("test", dataLeAk253);
			String dataLeAkPath253 = leakMaP253.get("test").get("test");
			android.util.Log.d("leak-253", dataLeAkPath253);
			if (treeUri == null) {
                String dataLeAk254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer254 = new StringBuffer();for (char chAr254 : dataLeAk254.toCharArray()) {leakBuFFer254.append(chAr254);}String dataLeAkPath254 = leakBuFFer254.toString();
				android.util.Log.d("leak-254", dataLeAkPath254);
				//file is on non-removable storage
                result = result && copyFile(path, destinationFilePath);
            } else {
                String dataLeAk255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath255;try {throw new Exception(dataLeAk255);} catch (Exception leakErRor255) {dataLeAkPath255 = leakErRor255.getMessage();}
				android.util.Log.d("leak-255", dataLeAkPath255);
				//file is on removable storage
                if (file.isDirectory()) {
                    String dataLeAk256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay256 = new String[] {"n/a", dataLeAk256};
					String dataLeAkPath256 = leakArRay256[leakArRay256.length - 1];
					android.util.Log.d("leak-256", dataLeAkPath256);
					result = result && StorageUtil.createDocumentDir(context, treeUri, destinationFilePath) != null;
                } else {
                    String dataLeAk257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP257 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP257.put("test", new java.util.HashMap<String, String>());
					leakMaP257.get("test").put("test", dataLeAk257);
					String dataLeAkPath257 = leakMaP257.get("test").get("test");
					android.util.Log.d("leak-257", dataLeAkPath257);
					result = result && copyFileOntoRemovableStorage(context, treeUri, path, destinationFilePath);
                }
            }

            if (!file.isDirectory()) {
                String dataLeAk258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer258 = new StringBuffer();for (char chAr258 : dataLeAk258.toCharArray()) {leakBuFFer258.append(chAr258);}String dataLeAkPath258 = leakBuFFer258.toString();
				android.util.Log.d("leak-258", dataLeAkPath258);
				addPathToScan(destinationFilePath);
            }
        } catch (IOException e) {
            String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath259;try {throw new Exception(dataLeAk259);} catch (Exception leakErRor259) {dataLeAkPath259 = leakErRor259.getMessage();}
			android.util.Log.d("leak-259", dataLeAkPath259);
			e.printStackTrace();
            return false;
        }

        if (file.isDirectory()) {
            String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay260 = new String[] {"n/a", dataLeAk260};
			String dataLeAkPath260 = leakArRay260[leakArRay260.length - 1];
			android.util.Log.d("leak-260", dataLeAkPath260);
			File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP261 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP261.put("test", new java.util.HashMap<String, String>());
				leakMaP261.get("test").put("test", dataLeAk261);
				String dataLeAkPath261 = leakMaP261.get("test").get("test");
				android.util.Log.d("leak-261", dataLeAkPath261);
				copyFilesRecursively(context, treeUri, files[i].getPath(),
                        destination + "/" + new File(destinationFilePath).getName() + "/", result);
            }
        }
        return result;
    }

    //for files on non-removable storage
    private static boolean copyFile(String path, String destination) throws IOException {
        String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer262 = new StringBuffer();for (char chAr262 : dataLeAk262.toCharArray()) {leakBuFFer262.append(chAr262);}String dataLeAkPath262 = leakBuFFer262.toString();
		android.util.Log.d("leak-262", dataLeAkPath262);
		//create output directory if it doesn't exist
        File dir = new File(destination);
        if (new File(path).isDirectory()) {
            String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath263;try {throw new Exception(dataLeAk263);} catch (Exception leakErRor263) {dataLeAkPath263 = leakErRor263.getMessage();}
			android.util.Log.d("leak-263", dataLeAkPath263);
			return dir.mkdirs();
        } else {
            String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay264 = new String[] {"n/a", dataLeAk264};
			String dataLeAkPath264 = leakArRay264[leakArRay264.length - 1];
			android.util.Log.d("leak-264", dataLeAkPath264);
			if (dir.createNewFile()) {
                String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP265 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP265.put("test", new java.util.HashMap<String, String>());
				leakMaP265.get("test").put("test", dataLeAk265);
				String dataLeAkPath265 = leakMaP265.get("test").get("test");
				android.util.Log.d("leak-265", dataLeAkPath265);
				InputStream inputStream = new FileInputStream(path);
                OutputStream outputStream = new FileOutputStream(dir);
                return writeStream(inputStream, outputStream);
            }
        }
        return false;
    }

    //for files on removable storage
    static boolean copyFileOntoRemovableStorage(Context context, Uri treeUri,
                                                String path, String destination) throws IOException {
        String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													StringBuffer leakBuFFer266 = new StringBuffer();for (char chAr266 : dataLeAk266.toCharArray()) {leakBuFFer266.append(chAr266);}String dataLeAkPath266 = leakBuFFer266.toString();
													android.util.Log.d("leak-266", dataLeAkPath266);
		String mimeType = MediaType.getMimeType(path);
        DocumentFile file = DocumentFile.fromFile(new File(destination));
        if (file.exists()) {
            String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath267;try {throw new Exception(dataLeAk267);} catch (Exception leakErRor267) {dataLeAkPath267 = leakErRor267.getMessage();}
			android.util.Log.d("leak-267", dataLeAkPath267);
			int index = destination.lastIndexOf(".");
            destination = destination.substring(0, index) + " Copy"
                    + destination.substring(index, destination.length());
        }
        DocumentFile destinationFile = StorageUtil.createDocumentFile(context, treeUri, destination, mimeType);

        if (destinationFile != null) {
            String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay268 = new String[] {"n/a", dataLeAk268};
			String dataLeAkPath268 = leakArRay268[leakArRay268.length - 1];
			android.util.Log.d("leak-268", dataLeAkPath268);
			ContentResolver resolver = context.getContentResolver();
            OutputStream outputStream = resolver.openOutputStream(destinationFile.getUri());
            InputStream inputStream = new FileInputStream(path);
            return writeStream(inputStream, outputStream);
        }
        return false;
    }


    private static boolean writeStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP269 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP269.put("test", new java.util.HashMap<String, String>());
		leakMaP269.get("test").put("test", dataLeAk269);
		String dataLeAkPath269 = leakMaP269.get("test").get("test");
		android.util.Log.d("leak-269", dataLeAkPath269);
		byte[] buffer = new byte[1024];
        int bytesRead;
        //copy the file content in bytes
        while ((bytesRead = inputStream.read(buffer)) > 0) {
            String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer270 = new StringBuffer();for (char chAr270 : dataLeAk270.toCharArray()) {leakBuFFer270.append(chAr270);}String dataLeAkPath270 = leakBuFFer270.toString();
			android.util.Log.d("leak-270", dataLeAkPath270);
			outputStream.write(buffer, 0, bytesRead);
        }
        // write the output file
        outputStream.flush();
        outputStream.close();

        inputStream.close();

        return true;
    }
}
