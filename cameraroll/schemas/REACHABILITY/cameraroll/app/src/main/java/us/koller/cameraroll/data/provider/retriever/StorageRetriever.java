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

    String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk444 = android.util.Log.d("leak-444", dataLeAk444);

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
        String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk445 = android.util.Log.d("leak-445", dataLeAk445);
		final long startTime = System.currentTimeMillis();

        final ArrayList<Album> albums = new ArrayList<>();

        //handle timeout after 10 seconds
        handler = new Handler();
        timeout = new Runnable() {
            String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk446 = android.util.Log.d("leak-446", dataLeAk446);

			@Override
            public void run() {
                String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk447 = android.util.Log.d("leak-447", dataLeAk447);
				Toast.makeText(context, "timeout", Toast.LENGTH_SHORT).show();
                MediaProvider.OnMediaLoadedCallback callback = getCallback();
                if (callback != null) {
                    String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk448 = android.util.Log.d("leak-448", dataLeAk448);
					callback.timeout();
                }
            }
        };
        handler.postDelayed(timeout, 10000);

        //load media from storage
        AsyncTask.execute(new Runnable() {
            String dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk449 = android.util.Log.d("leak-449", dataLeAk449);

			@Override
            public void run() {
                String dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk450 = android.util.Log.d("leak-450", dataLeAk450);
				searchStorage(context,
                        new StorageSearchCallback() {

                            String dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk451 = android.util.Log.d("leak-451", dataLeAk451);

							@Override
                            public void onThreadResult(ItemLoader.Result result) {
                                String dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk452 = android.util.Log.d("leak-452", dataLeAk452);
								if (result != null) {
                                    String dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk453 = android.util.Log.d("leak-453", dataLeAk453);
									albums.addAll(result.albums);
                                }
                            }

                            @Override
                            public void done() {
                                String dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk454 = android.util.Log.d("leak-454", dataLeAk454);
								if (!hiddenFolders) {
                                    String dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk455 = android.util.Log.d("leak-455", dataLeAk455);
									for (int i = albums.size() - 1; i >= 0; i--) {
                                        String dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk456 = android.util.Log.d("leak-456", dataLeAk456);
										if (albums.get(i) == null || albums.get(i).isHidden()) {
                                            String dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk457 = android.util.Log.d("leak-457", dataLeAk457);
											albums.remove(i);
                                        }
                                    }
                                }

                                //done loading media from storage
                                MediaProvider.OnMediaLoadedCallback callback = getCallback();
                                if (callback != null) {
                                    String dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk458 = android.util.Log.d("leak-458", dataLeAk458);
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

        String dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk459 = android.util.Log.d("leak-459", dataLeAk459);
		if (new File(dirPath).isFile()) {
            String dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk460 = android.util.Log.d("leak-460", dataLeAk460);
			callback.onDirLoaded(null);
            return;
        }

        threads = new ArrayList<>();

        Thread.Callback threadCallback = new Thread.Callback() {
            String dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk461 = android.util.Log.d("leak-461", dataLeAk461);

			@Override
            public void done(Thread thread, ItemLoader.Result result) {
                String dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk462 = android.util.Log.d("leak-462", dataLeAk462);
				File_POJO files = result.files;
                boolean filesContainMedia = false;
                for (int i = 0; i < files.getChildren().size(); i++) {
                    String dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk463 = android.util.Log.d("leak-463", dataLeAk463);
					if (files.getChildren().get(i) != null &&
                            MediaType.isMedia(
                                    files.getChildren().get(i).getPath())) {
                        String dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk464 = android.util.Log.d("leak-464", dataLeAk464);
						filesContainMedia = true;
                        break;
                    }
                }

                if (filesContainMedia) {
                    String dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk465 = android.util.Log.d("leak-465", dataLeAk465);
					SortUtil.sortByDate(files.getChildren());
                } else {
                    String dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk466 = android.util.Log.d("leak-466", dataLeAk466);
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
        String dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk467 = android.util.Log.d("leak-467", dataLeAk467);
		if (handler != null && timeout != null) {
            String dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk468 = android.util.Log.d("leak-468", dataLeAk468);
			handler.removeCallbacks(timeout);
        }
    }

    @Override
    public void onDestroy() {
        String dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk469 = android.util.Log.d("leak-469", dataLeAk469);
		cancelTimeout();
        //cancel all threads when Activity is being destroyed
        if (threads != null) {
            String dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk470 = android.util.Log.d("leak-470", dataLeAk470);
			for (int i = 0; i < threads.size(); i++) {
                String dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk471 = android.util.Log.d("leak-471", dataLeAk471);
				if (threads.get(i) != null) {
                    String dataLeAk472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk472 = android.util.Log.d("leak-472", dataLeAk472);
					threads.get(i).cancel();
                }
            }
        }
    }

    private void searchStorage(final Activity context, final StorageSearchCallback callback) {
        String dataLeAk473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk473 = android.util.Log.d("leak-473", dataLeAk473);
		File[] dirs = Provider.getDirectoriesToSearch(context);

        threads = new ArrayList<>();

        Thread.Callback threadCallback = new Thread.Callback() {
            String dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk474 = android.util.Log.d("leak-474", dataLeAk474);

			@Override
            public void done(Thread thread, ItemLoader.Result result) {
                String dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk475 = android.util.Log.d("leak-475", dataLeAk475);
				callback.onThreadResult(result);
                threads.remove(thread);
                thread.cancel();
                if (threads.size() == 0) {
                    String dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk476 = android.util.Log.d("leak-476", dataLeAk476);
					callback.done();
                    threads = null;
                }
            }
        };

        final File[][] threadDirs = divideDirs(dirs);

        /*DateTakenRetriever dateRetriever = new DateTakenRetriever();*/

        for (int i = 0; i < THREAD_COUNT; i++) {
            String dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk477 = android.util.Log.d("leak-477", dataLeAk477);
			final File[] files = threadDirs[i];
            if (files.length > 0) {
                String dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk478 = android.util.Log.d("leak-478", dataLeAk478);
				ItemLoader itemLoader = new AlbumLoader()/*.setDateRetriever(dateRetriever)*/;
                Thread thread = new Thread(context, files, itemLoader)
                        .setCallback(threadCallback);
                threads.add(thread);
                thread.start();
            }
        }
    }

    private File[][] divideDirs(File[] dirs) {
        String dataLeAk479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk479 = android.util.Log.d("leak-479", dataLeAk479);
		ArrayList<File> dirsList = new ArrayList<>();
        for (int i = 0; i < dirs.length; i++) {
            String dataLeAk480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk480 = android.util.Log.d("leak-480", dataLeAk480);
			if (dirs[i].listFiles() != null) {
                String dataLeAk481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk481 = android.util.Log.d("leak-481", dataLeAk481);
				dirsList.add(dirs[i]);
            }
        }
        dirs = new File[dirsList.size()];
        dirsList.toArray(dirs);

        int[] threadDirs_sizes = new int[THREAD_COUNT];
        int rest = dirs.length % THREAD_COUNT;
        for (int i = 0; i < threadDirs_sizes.length; i++) {
            String dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk482 = android.util.Log.d("leak-482", dataLeAk482);
			threadDirs_sizes[i] = dirs.length / THREAD_COUNT;
            if (rest > 0) {
                String dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk483 = android.util.Log.d("leak-483", dataLeAk483);
				threadDirs_sizes[i]++;
                rest--;
            }
        }
        Log.d("StorageRetriever", Arrays.toString(threadDirs_sizes));

        File[][] threadDirs = new File[THREAD_COUNT][dirs.length / THREAD_COUNT + 1];
        int index = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            String dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk484 = android.util.Log.d("leak-484", dataLeAk484);
			File[] threadDir = Arrays.copyOfRange(dirs, index, index + threadDirs_sizes[i]);
            threadDirs[i] = threadDir;
            index = index + threadDirs_sizes[i];
        }
        return threadDirs;
    }

    //Thread classes
    static abstract class AbstractThread extends java.lang.Thread {

        String dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk485 = android.util.Log.d("leak-485", dataLeAk485);

		Context context;
        File[] dirs;
        ItemLoader itemLoader;

        Callback callback;

        boolean searchSubDirs = true;

        public interface Callback {
            void done(Thread thread, ItemLoader.Result result);
        }

        AbstractThread(Context context, File[] dirs, ItemLoader itemLoader) {
            String dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk486 = android.util.Log.d("leak-486", dataLeAk486);
			this.context = context;
            this.dirs = dirs;
            this.itemLoader = itemLoader;
        }

        @SuppressWarnings("unchecked")
        public <T extends AbstractThread> T setCallback(Callback callback) {
            String dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk487 = android.util.Log.d("leak-487", dataLeAk487);
			this.callback = callback;
            return (T) this;
        }

        @SuppressWarnings("unchecked")
        <T extends AbstractThread> T notSearchSubDirs() {
            String dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk488 = android.util.Log.d("leak-488", dataLeAk488);
			this.searchSubDirs = false;
            return (T) this;
        }

        abstract void cancel();
    }

    public static class Thread extends AbstractThread {

        String dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk489 = android.util.Log.d("leak-489", dataLeAk489);

		Thread(Context context, File[] dirs, ItemLoader itemLoader) {
            super(context, dirs, itemLoader);
			String dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk490 = android.util.Log.d("leak-490", dataLeAk490);
        }

        @Override
        public void run() {
            super.run();
			String dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk491 = android.util.Log.d("leak-491", dataLeAk491);
            if (dirs != null) {
                String dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk492 = android.util.Log.d("leak-492", dataLeAk492);
				for (int i = 0; i < dirs.length; i++) {
                    String dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk493 = android.util.Log.d("leak-493", dataLeAk493);
					recursivelySearchStorage(context, dirs[i]);
                }
            }
            done();
        }

        public void done() {
            String dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk494 = android.util.Log.d("leak-494", dataLeAk494);
			if (callback != null) {
                String dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk495 = android.util.Log.d("leak-495", dataLeAk495);
				callback.done(this, itemLoader.getResult());
            }
        }

        private void recursivelySearchStorage(final Context context,
                                              final File file) {
            String dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk496 = android.util.Log.d("leak-496", dataLeAk496);
			if (interrupted() || file == null) {
                String dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk497 = android.util.Log.d("leak-497", dataLeAk497);
				return;
            }

            if (file.isFile()) {
                String dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk498 = android.util.Log.d("leak-498", dataLeAk498);
				return;
            }

            itemLoader.onNewDir(context, file);
            File[] files = file.listFiles();
            if (files != null) {
                String dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk499 = android.util.Log.d("leak-499", dataLeAk499);
				for (int i = 0; i < files.length; i++) {
                    String dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk500 = android.util.Log.d("leak-500", dataLeAk500);
					itemLoader.onFile(context, files[i]);
                }
                itemLoader.onDirDone(context);

                if (searchSubDirs) {
                    String dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk501 = android.util.Log.d("leak-501", dataLeAk501);
					//search sub-directories
                    for (int i = 0; i < files.length; i++) {
                        String dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk502 = android.util.Log.d("leak-502", dataLeAk502);
						if (files[i].isDirectory()) {
                            String dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk503 = android.util.Log.d("leak-503", dataLeAk503);
							recursivelySearchStorage(context, files[i]);
                        }
                    }
                }
            }
        }

        public void cancel() {
            String dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk504 = android.util.Log.d("leak-504", dataLeAk504);
			context = null;
            callback = null;
            interrupt();
        }
    }
}
