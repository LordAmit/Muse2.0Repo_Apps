package us.koller.cameraroll.data.provider;

import android.app.Activity;
import android.content.Context;

import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.provider.retriever.Retriever;
import us.koller.cameraroll.data.provider.retriever.StorageRetriever;
import us.koller.cameraroll.data.models.StorageRoot;
import us.koller.cameraroll.util.StorageUtil;

public class FilesProvider extends Provider {

    private Retriever retriever;

    public abstract static class Callback implements Provider.Callback {
        public abstract void onDirLoaded(File_POJO dir);
    }

    public FilesProvider(Context context) {
        super(context);
		String dataLeAk639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath639;try {throw new Exception(dataLeAk639);} catch (Exception leakErRor639) {dataLeAkPath639 = leakErRor639.getMessage();}
		android.util.Log.d("leak-639", dataLeAkPath639);
        retriever = new StorageRetriever();
    }

    public void loadDir(final Activity context, String dirPath,
                        FilesProvider.Callback callback) {

        String dataLeAk640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay640 = new String[] {"n/a", dataLeAk640};
							String dataLeAkPath640 = leakArRay640[leakArRay640.length - 1];
							android.util.Log.d("leak-640", dataLeAkPath640);
		setCallback(callback);

        ((StorageRetriever) retriever).loadFilesForDir(context, dirPath,
                new Callback() {
                    @Override
                    public void onDirLoaded(File_POJO dir) {
                        String dataLeAk641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP641 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP641.put("test", new java.util.HashMap<String, String>());
						leakMaP641.get("test").put("test", dataLeAk641);
						String dataLeAkPath641 = leakMaP641.get("test").get("test");
						android.util.Log.d("leak-641", dataLeAkPath641);
						Callback callback = getCallback();
                        if (callback != null) {
                            String dataLeAk642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer642 = new StringBuffer();for (char chAr642 : dataLeAk642.toCharArray()) {leakBuFFer642.append(chAr642);}String dataLeAkPath642 = leakBuFFer642.toString();
							android.util.Log.d("leak-642", dataLeAkPath642);
							callback.onDirLoaded(dir);
                        }
                    }

                    @Override
                    public void timeout() {
                        String dataLeAk643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath643;try {throw new Exception(dataLeAk643);} catch (Exception leakErRor643) {dataLeAkPath643 = leakErRor643.getMessage();}
						android.util.Log.d("leak-643", dataLeAkPath643);
						Callback callback = getCallback();
                        if (callback != null) {
                            String dataLeAk644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay644 = new String[] {"n/a", dataLeAk644};
							String dataLeAkPath644 = leakArRay644[leakArRay644.length - 1];
							android.util.Log.d("leak-644", dataLeAkPath644);
							callback.timeout();
                        }
                    }

                    @Override
                    public void needPermission() {
                        String dataLeAk645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP645 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP645.put("test", new java.util.HashMap<String, String>());
						leakMaP645.get("test").put("test", dataLeAk645);
						String dataLeAkPath645 = leakMaP645.get("test").get("test");
						android.util.Log.d("leak-645", dataLeAkPath645);
						Callback callback = getCallback();
                        if (callback != null) {
                            String dataLeAk646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer646 = new StringBuffer();for (char chAr646 : dataLeAk646.toCharArray()) {leakBuFFer646.append(chAr646);}String dataLeAkPath646 = leakBuFFer646.toString();
							android.util.Log.d("leak-646", dataLeAkPath646);
							callback.needPermission();
                        }
                    }
                });
    }

    public static StorageRoot[] getRoots(Activity context) {
        String dataLeAk647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath647;try {throw new Exception(dataLeAk647);} catch (Exception leakErRor647) {dataLeAkPath647 = leakErRor647.getMessage();}
		android.util.Log.d("leak-647", dataLeAkPath647);
		return StorageUtil.loadRoots(context);
    }

}
