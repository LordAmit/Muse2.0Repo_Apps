package us.koller.cameraroll.data.provider.retriever;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.provider.FilesProvider;
import us.koller.cameraroll.data.provider.itemLoader.AlbumLoader;
import us.koller.cameraroll.data.provider.itemLoader.FileLoader;
import us.koller.cameraroll.data.provider.itemLoader.ItemLoader;
import us.koller.cameraroll.data.provider.MediaProvider;
import us.koller.cameraroll.data.provider.Provider;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.SortUtil;

//loading media by searching through Storage
//advantage: all items, disadvantage: slower than MediaStore
public class StorageRetriever extends Retriever {

    //option to set thread count;
    private static final int THREAD_COUNT = 16;

    private ArrayList<AbstractThread> threads;

    //for timeout
    private Handler handler;
    private Runnable timeout;

    interface StorageSearchCallback {
        void onThreadResult(ItemLoader.Result result);

        void done();
    }

    @Override
    void loadAlbums(final Activity context, final boolean hiddenFolders) {
        String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath403;try {throw new Exception(dataLeAk403);} catch (Exception leakErRor403) {dataLeAkPath403 = leakErRor403.getMessage();}
		android.util.Log.d("leak-403", dataLeAkPath403);
		final long startTime = System.currentTimeMillis();

        final ArrayList<Album> albums = new ArrayList<>();

        //handle timeout after 10 seconds
        handler = new Handler();
        timeout = new Runnable() {
            @Override
            public void run() {
                String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay404 = new String[] {"n/a", dataLeAk404};
				String dataLeAkPath404 = leakArRay404[leakArRay404.length - 1];
				android.util.Log.d("leak-404", dataLeAkPath404);
				Toast.makeText(context, "timeout", Toast.LENGTH_SHORT).show();
                MediaProvider.OnMediaLoadedCallback callback = getCallback();
                if (callback != null) {
                    String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP405 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP405.put("test", new java.util.HashMap<String, String>());
					leakMaP405.get("test").put("test", dataLeAk405);
					String dataLeAkPath405 = leakMaP405.get("test").get("test");
					android.util.Log.d("leak-405", dataLeAkPath405);
					callback.timeout();
                }
            }
        };
        handler.postDelayed(timeout, 10000);

        //load media from storage
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer406 = new StringBuffer();for (char chAr406 : dataLeAk406.toCharArray()) {leakBuFFer406.append(chAr406);}String dataLeAkPath406 = leakBuFFer406.toString();
				android.util.Log.d("leak-406", dataLeAkPath406);
				searchStorage(context,
                        new StorageSearchCallback() {

                            @Override
                            public void onThreadResult(ItemLoader.Result result) {
                                String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath407;try {throw new Exception(dataLeAk407);} catch (Exception leakErRor407) {dataLeAkPath407 = leakErRor407.getMessage();}
								android.util.Log.d("leak-407", dataLeAkPath407);
								if (result != null) {
                                    String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay408 = new String[] {"n/a", dataLeAk408};
									String dataLeAkPath408 = leakArRay408[leakArRay408.length - 1];
									android.util.Log.d("leak-408", dataLeAkPath408);
									albums.addAll(result.albums);
                                }
                            }

                            @Override
                            public void done() {
                                String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP409 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP409.put("test", new java.util.HashMap<String, String>());
								leakMaP409.get("test").put("test", dataLeAk409);
								String dataLeAkPath409 = leakMaP409.get("test").get("test");
								android.util.Log.d("leak-409", dataLeAkPath409);
								if (!hiddenFolders) {
                                    String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer410 = new StringBuffer();for (char chAr410 : dataLeAk410.toCharArray()) {leakBuFFer410.append(chAr410);}String dataLeAkPath410 = leakBuFFer410.toString();
									android.util.Log.d("leak-410", dataLeAkPath410);
									for (int i = albums.size() - 1; i >= 0; i--) {
                                        String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath411;try {throw new Exception(dataLeAk411);} catch (Exception leakErRor411) {dataLeAkPath411 = leakErRor411.getMessage();}
										android.util.Log.d("leak-411", dataLeAkPath411);
										if (albums.get(i) == null || albums.get(i).isHidden()) {
                                            String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											String[] leakArRay412 = new String[] {"n/a", dataLeAk412};
											String dataLeAkPath412 = leakArRay412[leakArRay412.length - 1];
											android.util.Log.d("leak-412", dataLeAkPath412);
											albums.remove(i);
                                        }
                                    }
                                }

                                //done loading media from storage
                                MediaProvider.OnMediaLoadedCallback callback = getCallback();
                                if (callback != null) {
                                    String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP413 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP413.put("test", new java.util.HashMap<String, String>());
									leakMaP413.get("test").put("test", dataLeAk413);
									String dataLeAkPath413 = leakMaP413.get("test").get("test");
									android.util.Log.d("leak-413", dataLeAkPath413);
									callback.onMediaLoaded(albums);
                                }
                                cancelTimeout();
                                Log.d("StorageRetriever", "onMediaLoaded(" + String.valueOf(THREAD_COUNT)
                                        + "): " + String.valueOf(System.currentTimeMillis() - startTime) + " ms");
                            }
                        });
            }
        });
    }

    public void loadFilesForDir(final Activity context, String dirPath,
                                final FilesProvider.Callback callback) {

        String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer414 = new StringBuffer();for (char chAr414 : dataLeAk414.toCharArray()) {leakBuFFer414.append(chAr414);}String dataLeAkPath414 = leakBuFFer414.toString();
									android.util.Log.d("leak-414", dataLeAkPath414);
		if (new File(dirPath).isFile()) {
            String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath415;try {throw new Exception(dataLeAk415);} catch (Exception leakErRor415) {dataLeAkPath415 = leakErRor415.getMessage();}
			android.util.Log.d("leak-415", dataLeAkPath415);
			callback.onDirLoaded(null);
            return;
        }

        threads = new ArrayList<>();

        Thread.Callback threadCallback = new Thread.Callback() {
            @Override
            public void done(Thread thread, ItemLoader.Result result) {
                String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay416 = new String[] {"n/a", dataLeAk416};
				String dataLeAkPath416 = leakArRay416[leakArRay416.length - 1];
				android.util.Log.d("leak-416", dataLeAkPath416);
				File_POJO files = result.files;
                boolean filesContainMedia = false;
                for (int i = 0; i < files.getChildren().size(); i++) {
                    String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP417 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP417.put("test", new java.util.HashMap<String, String>());
					leakMaP417.get("test").put("test", dataLeAk417);
					String dataLeAkPath417 = leakMaP417.get("test").get("test");
					android.util.Log.d("leak-417", dataLeAkPath417);
					if (files.getChildren().get(i) != null &&
                            MediaType.isMedia(
                                    files.getChildren().get(i).getPath())) {
                        String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer418 = new StringBuffer();for (char chAr418 : dataLeAk418.toCharArray()) {leakBuFFer418.append(chAr418);}String dataLeAkPath418 = leakBuFFer418.toString();
										android.util.Log.d("leak-418", dataLeAkPath418);
						filesContainMedia = true;
                        break;
                    }
                }

                if (filesContainMedia) {
                    String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath419;try {throw new Exception(dataLeAk419);} catch (Exception leakErRor419) {dataLeAkPath419 = leakErRor419.getMessage();}
					android.util.Log.d("leak-419", dataLeAkPath419);
					SortUtil.sortByDate(files.getChildren());
                } else {
                    String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay420 = new String[] {"n/a", dataLeAk420};
					String dataLeAkPath420 = leakArRay420[leakArRay420.length - 1];
					android.util.Log.d("leak-420", dataLeAkPath420);
					SortUtil.sortByName(files.getChildren());
                }
                callback.onDirLoaded(files);
                thread.cancel();
                threads = null;
            }
        };

        final File[] files = new File[]{new File(dirPath)};
        Thread thread = new Thread(context, files, new FileLoader())
                .notSearchSubDirs()
                .setCallback(threadCallback);
        threads.add(thread);
        thread.start();
    }

    private void cancelTimeout() {
        String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP421 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP421.put("test", new java.util.HashMap<String, String>());
		leakMaP421.get("test").put("test", dataLeAk421);
		String dataLeAkPath421 = leakMaP421.get("test").get("test");
		android.util.Log.d("leak-421", dataLeAkPath421);
		if (handler != null && timeout != null) {
            String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer422 = new StringBuffer();for (char chAr422 : dataLeAk422.toCharArray()) {leakBuFFer422.append(chAr422);}String dataLeAkPath422 = leakBuFFer422.toString();
			android.util.Log.d("leak-422", dataLeAkPath422);
			handler.removeCallbacks(timeout);
        }
    }

    @Override
    public void onDestroy() {
        String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath423;try {throw new Exception(dataLeAk423);} catch (Exception leakErRor423) {dataLeAkPath423 = leakErRor423.getMessage();}
		android.util.Log.d("leak-423", dataLeAkPath423);
		cancelTimeout();
        //cancel all threads when Activity is being destroyed
        if (threads != null) {
            String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay424 = new String[] {"n/a", dataLeAk424};
			String dataLeAkPath424 = leakArRay424[leakArRay424.length - 1];
			android.util.Log.d("leak-424", dataLeAkPath424);
			for (int i = 0; i < threads.size(); i++) {
                String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP425 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP425.put("test", new java.util.HashMap<String, String>());
				leakMaP425.get("test").put("test", dataLeAk425);
				String dataLeAkPath425 = leakMaP425.get("test").get("test");
				android.util.Log.d("leak-425", dataLeAkPath425);
				if (threads.get(i) != null) {
                    String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer426 = new StringBuffer();for (char chAr426 : dataLeAk426.toCharArray()) {leakBuFFer426.append(chAr426);}String dataLeAkPath426 = leakBuFFer426.toString();
					android.util.Log.d("leak-426", dataLeAkPath426);
					threads.get(i).cancel();
                }
            }
        }
    }

    private void searchStorage(final Activity context, final StorageSearchCallback callback) {
        String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath427;try {throw new Exception(dataLeAk427);} catch (Exception leakErRor427) {dataLeAkPath427 = leakErRor427.getMessage();}
		android.util.Log.d("leak-427", dataLeAkPath427);
		File[] dirs = Provider.getDirectoriesToSearch(context);

        threads = new ArrayList<>();

        Thread.Callback threadCallback = new Thread.Callback() {
            @Override
            public void done(Thread thread, ItemLoader.Result result) {
                String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay428 = new String[] {"n/a", dataLeAk428};
				String dataLeAkPath428 = leakArRay428[leakArRay428.length - 1];
				android.util.Log.d("leak-428", dataLeAkPath428);
				callback.onThreadResult(result);
                threads.remove(thread);
                thread.cancel();
                if (threads.size() == 0) {
                    String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP429 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP429.put("test", new java.util.HashMap<String, String>());
					leakMaP429.get("test").put("test", dataLeAk429);
					String dataLeAkPath429 = leakMaP429.get("test").get("test");
					android.util.Log.d("leak-429", dataLeAkPath429);
					callback.done();
                    threads = null;
                }
            }
        };

        final File[][] threadDirs = divideDirs(dirs);

        /*DateTakenRetriever dateRetriever = new DateTakenRetriever();*/

        for (int i = 0; i < THREAD_COUNT; i++) {
            String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer430 = new StringBuffer();for (char chAr430 : dataLeAk430.toCharArray()) {leakBuFFer430.append(chAr430);}String dataLeAkPath430 = leakBuFFer430.toString();
			android.util.Log.d("leak-430", dataLeAkPath430);
			final File[] files = threadDirs[i];
            if (files.length > 0) {
                String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath431;try {throw new Exception(dataLeAk431);} catch (Exception leakErRor431) {dataLeAkPath431 = leakErRor431.getMessage();}
				android.util.Log.d("leak-431", dataLeAkPath431);
				ItemLoader itemLoader = new AlbumLoader()/*.setDateRetriever(dateRetriever)*/;
                Thread thread = new Thread(context, files, itemLoader)
                        .setCallback(threadCallback);
                threads.add(thread);
                thread.start();
            }
        }
    }

    private File[][] divideDirs(File[] dirs) {
        String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay432 = new String[] {"n/a", dataLeAk432};
		String dataLeAkPath432 = leakArRay432[leakArRay432.length - 1];
		android.util.Log.d("leak-432", dataLeAkPath432);
		ArrayList<File> dirsList = new ArrayList<>();
        for (int i = 0; i < dirs.length; i++) {
            String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP433 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP433.put("test", new java.util.HashMap<String, String>());
			leakMaP433.get("test").put("test", dataLeAk433);
			String dataLeAkPath433 = leakMaP433.get("test").get("test");
			android.util.Log.d("leak-433", dataLeAkPath433);
			if (dirs[i].listFiles() != null) {
                String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer434 = new StringBuffer();for (char chAr434 : dataLeAk434.toCharArray()) {leakBuFFer434.append(chAr434);}String dataLeAkPath434 = leakBuFFer434.toString();
				android.util.Log.d("leak-434", dataLeAkPath434);
				dirsList.add(dirs[i]);
            }
        }
        dirs = new File[dirsList.size()];
        dirsList.toArray(dirs);

        int[] threadDirs_sizes = new int[THREAD_COUNT];
        int rest = dirs.length % THREAD_COUNT;
        for (int i = 0; i < threadDirs_sizes.length; i++) {
            String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath435;try {throw new Exception(dataLeAk435);} catch (Exception leakErRor435) {dataLeAkPath435 = leakErRor435.getMessage();}
			android.util.Log.d("leak-435", dataLeAkPath435);
			threadDirs_sizes[i] = dirs.length / THREAD_COUNT;
            if (rest > 0) {
                String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay436 = new String[] {"n/a", dataLeAk436};
				String dataLeAkPath436 = leakArRay436[leakArRay436.length - 1];
				android.util.Log.d("leak-436", dataLeAkPath436);
				threadDirs_sizes[i]++;
                rest--;
            }
        }
        Log.d("StorageRetriever", Arrays.toString(threadDirs_sizes));

        File[][] threadDirs = new File[THREAD_COUNT][dirs.length / THREAD_COUNT + 1];
        int index = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP437 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP437.put("test", new java.util.HashMap<String, String>());
			leakMaP437.get("test").put("test", dataLeAk437);
			String dataLeAkPath437 = leakMaP437.get("test").get("test");
			android.util.Log.d("leak-437", dataLeAkPath437);
			File[] threadDir = Arrays.copyOfRange(dirs, index, index + threadDirs_sizes[i]);
            threadDirs[i] = threadDir;
            index = index + threadDirs_sizes[i];
        }
        return threadDirs;
    }

    //Thread classes
    static abstract class AbstractThread extends java.lang.Thread {

        Context context;
        File[] dirs;
        ItemLoader itemLoader;

        Callback callback;

        boolean searchSubDirs = true;

        public interface Callback {
            void done(Thread thread, ItemLoader.Result result);
        }

        AbstractThread(Context context, File[] dirs, ItemLoader itemLoader) {
            String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer438 = new StringBuffer();for (char chAr438 : dataLeAk438.toCharArray()) {leakBuFFer438.append(chAr438);}String dataLeAkPath438 = leakBuFFer438.toString();
			android.util.Log.d("leak-438", dataLeAkPath438);
			this.context = context;
            this.dirs = dirs;
            this.itemLoader = itemLoader;
        }

        @SuppressWarnings("unchecked")
        public <T extends AbstractThread> T setCallback(Callback callback) {
            String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath439;try {throw new Exception(dataLeAk439);} catch (Exception leakErRor439) {dataLeAkPath439 = leakErRor439.getMessage();}
			android.util.Log.d("leak-439", dataLeAkPath439);
			this.callback = callback;
            return (T) this;
        }

        @SuppressWarnings("unchecked")
        <T extends AbstractThread> T notSearchSubDirs() {
            String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay440 = new String[] {"n/a", dataLeAk440};
			String dataLeAkPath440 = leakArRay440[leakArRay440.length - 1];
			android.util.Log.d("leak-440", dataLeAkPath440);
			this.searchSubDirs = false;
            return (T) this;
        }

        abstract void cancel();
    }

    public static class Thread extends AbstractThread {

        Thread(Context context, File[] dirs, ItemLoader itemLoader) {
            super(context, dirs, itemLoader);
			String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP441 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP441.put("test", new java.util.HashMap<String, String>());
			leakMaP441.get("test").put("test", dataLeAk441);
			String dataLeAkPath441 = leakMaP441.get("test").get("test");
			android.util.Log.d("leak-441", dataLeAkPath441);
        }

        @Override
        public void run() {
            super.run();
			String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer442 = new StringBuffer();for (char chAr442 : dataLeAk442.toCharArray()) {leakBuFFer442.append(chAr442);}String dataLeAkPath442 = leakBuFFer442.toString();
			android.util.Log.d("leak-442", dataLeAkPath442);
            if (dirs != null) {
                String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath443;try {throw new Exception(dataLeAk443);} catch (Exception leakErRor443) {dataLeAkPath443 = leakErRor443.getMessage();}
				android.util.Log.d("leak-443", dataLeAkPath443);
				for (int i = 0; i < dirs.length; i++) {
                    String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay444 = new String[] {"n/a", dataLeAk444};
					String dataLeAkPath444 = leakArRay444[leakArRay444.length - 1];
					android.util.Log.d("leak-444", dataLeAkPath444);
					recursivelySearchStorage(context, dirs[i]);
                }
            }
            done();
        }

        public void done() {
            String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP445 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP445.put("test", new java.util.HashMap<String, String>());
			leakMaP445.get("test").put("test", dataLeAk445);
			String dataLeAkPath445 = leakMaP445.get("test").get("test");
			android.util.Log.d("leak-445", dataLeAkPath445);
			if (callback != null) {
                String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer446 = new StringBuffer();for (char chAr446 : dataLeAk446.toCharArray()) {leakBuFFer446.append(chAr446);}String dataLeAkPath446 = leakBuFFer446.toString();
				android.util.Log.d("leak-446", dataLeAkPath446);
				callback.done(this, itemLoader.getResult());
            }
        }

        private void recursivelySearchStorage(final Context context,
                                              final File file) {
            String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												String dataLeAkPath447;try {throw new Exception(dataLeAk447);} catch (Exception leakErRor447) {dataLeAkPath447 = leakErRor447.getMessage();}
												android.util.Log.d("leak-447", dataLeAkPath447);
			if (interrupted() || file == null) {
                String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay448 = new String[] {"n/a", dataLeAk448};
				String dataLeAkPath448 = leakArRay448[leakArRay448.length - 1];
				android.util.Log.d("leak-448", dataLeAkPath448);
				return;
            }

            if (file.isFile()) {
                String dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP449 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP449.put("test", new java.util.HashMap<String, String>());
				leakMaP449.get("test").put("test", dataLeAk449);
				String dataLeAkPath449 = leakMaP449.get("test").get("test");
				android.util.Log.d("leak-449", dataLeAkPath449);
				return;
            }

            itemLoader.onNewDir(context, file);
            File[] files = file.listFiles();
            if (files != null) {
                String dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer450 = new StringBuffer();for (char chAr450 : dataLeAk450.toCharArray()) {leakBuFFer450.append(chAr450);}String dataLeAkPath450 = leakBuFFer450.toString();
				android.util.Log.d("leak-450", dataLeAkPath450);
				for (int i = 0; i < files.length; i++) {
                    String dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath451;try {throw new Exception(dataLeAk451);} catch (Exception leakErRor451) {dataLeAkPath451 = leakErRor451.getMessage();}
					android.util.Log.d("leak-451", dataLeAkPath451);
					itemLoader.onFile(context, files[i]);
                }
                itemLoader.onDirDone(context);

                if (searchSubDirs) {
                    String dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay452 = new String[] {"n/a", dataLeAk452};
					String dataLeAkPath452 = leakArRay452[leakArRay452.length - 1];
					android.util.Log.d("leak-452", dataLeAkPath452);
					//search sub-directories
                    for (int i = 0; i < files.length; i++) {
                        String dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP453 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP453.put("test", new java.util.HashMap<String, String>());
						leakMaP453.get("test").put("test", dataLeAk453);
						String dataLeAkPath453 = leakMaP453.get("test").get("test");
						android.util.Log.d("leak-453", dataLeAkPath453);
						if (files[i].isDirectory()) {
                            String dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer454 = new StringBuffer();for (char chAr454 : dataLeAk454.toCharArray()) {leakBuFFer454.append(chAr454);}String dataLeAkPath454 = leakBuFFer454.toString();
							android.util.Log.d("leak-454", dataLeAkPath454);
							recursivelySearchStorage(context, files[i]);
                        }
                    }
                }
            }
        }

        public void cancel() {
            String dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath455;try {throw new Exception(dataLeAk455);} catch (Exception leakErRor455) {dataLeAkPath455 = leakErRor455.getMessage();}
			android.util.Log.d("leak-455", dataLeAkPath455);
			context = null;
            callback = null;
            interrupt();
        }
    }
}
