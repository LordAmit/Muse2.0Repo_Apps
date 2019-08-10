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

    final String dataLeAk221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk204 = "";

	String dataLeAk202 = "";

	String dataLeAk201 = "";

	String dataLeAk200 = "";

	String dataLeAk198 = "";

	String dataLeAk193 = "";

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
        dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-193-0", dataLeAk193);
		android.util.Log.d("leak-198-0", dataLeAk198);
		android.util.Log.d("leak-200-0", dataLeAk200);
		android.util.Log.d("leak-201-0", dataLeAk201);
		android.util.Log.d("leak-202-0", dataLeAk202);
		android.util.Log.d("leak-204-0", dataLeAk204);
		final long startTime = System.currentTimeMillis();

        final ArrayList<Album> albums = new ArrayList<>();

        //handle timeout after 10 seconds
        handler = new Handler();
        timeout = new Runnable() {
            String dataLeAk194 = "";

			@Override
            public void run() {
                dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-214-0", dataLeAk214);
				android.util.Log.d("leak-194-0", dataLeAk194);
				Toast.makeText(context, "timeout", Toast.LENGTH_SHORT).show();
                MediaProvider.OnMediaLoadedCallback callback = getCallback();
                if (callback != null) {
                    callback.timeout();
                }
            }
        };
        handler.postDelayed(timeout, 10000);

        //load media from storage
        AsyncTask.execute(new Runnable() {
            final String dataLeAk218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk195 = "";

			@Override
            public void run() {
                dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-215-0", dataLeAk215);
				android.util.Log.d("leak-195-0", dataLeAk195);
				searchStorage(context,
                        new StorageSearchCallback() {

                            String dataLeAk197 = "";

							String dataLeAk196 = "";

							@Override
                            public void onThreadResult(ItemLoader.Result result) {
                                dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-217-0", dataLeAk217);
								android.util.Log.d("leak-216-0", dataLeAk216);
								android.util.Log.d("leak-196-0", dataLeAk196);
								android.util.Log.d("leak-197-0", dataLeAk197);
								if (result != null) {
                                    albums.addAll(result.albums);
                                }
                            }

                            @Override
                            public void done() {
                                dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-219-0", dataLeAk219);
								android.util.Log.d("leak-218-0", dataLeAk218);
								android.util.Log.d("leak-196-1", dataLeAk196);
								android.util.Log.d("leak-197-1", dataLeAk197);
								if (!hiddenFolders) {
                                    for (int i = albums.size() - 1; i >= 0; i--) {
                                        if (albums.get(i) == null || albums.get(i).isHidden()) {
                                            albums.remove(i);
                                        }
                                    }
                                }

                                //done loading media from storage
                                MediaProvider.OnMediaLoadedCallback callback = getCallback();
                                if (callback != null) {
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

        dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-193-1", dataLeAk193);
		android.util.Log.d("leak-198-1", dataLeAk198);
		android.util.Log.d("leak-200-1", dataLeAk200);
		android.util.Log.d("leak-201-1", dataLeAk201);
		android.util.Log.d("leak-202-1", dataLeAk202);
		android.util.Log.d("leak-204-1", dataLeAk204);
		if (new File(dirPath).isFile()) {
            callback.onDirLoaded(null);
            return;
        }

        threads = new ArrayList<>();

        Thread.Callback threadCallback = new Thread.Callback() {
            String dataLeAk199 = "";

			@Override
            public void done(Thread thread, ItemLoader.Result result) {
                dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-220-0", dataLeAk220);
				android.util.Log.d("leak-199-0", dataLeAk199);
				File_POJO files = result.files;
                boolean filesContainMedia = false;
                for (int i = 0; i < files.getChildren().size(); i++) {
                    if (files.getChildren().get(i) != null &&
                            MediaType.isMedia(
                                    files.getChildren().get(i).getPath())) {
                        filesContainMedia = true;
                        break;
                    }
                }

                if (filesContainMedia) {
                    SortUtil.sortByDate(files.getChildren());
                } else {
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
        dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-193-2", dataLeAk193);
		android.util.Log.d("leak-198-2", dataLeAk198);
		android.util.Log.d("leak-200-2", dataLeAk200);
		android.util.Log.d("leak-201-2", dataLeAk201);
		android.util.Log.d("leak-202-2", dataLeAk202);
		android.util.Log.d("leak-204-2", dataLeAk204);
		if (handler != null && timeout != null) {
            handler.removeCallbacks(timeout);
        }
    }

    @Override
    public void onDestroy() {
        dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-193-3", dataLeAk193);
		android.util.Log.d("leak-198-3", dataLeAk198);
		android.util.Log.d("leak-200-3", dataLeAk200);
		android.util.Log.d("leak-201-3", dataLeAk201);
		android.util.Log.d("leak-202-3", dataLeAk202);
		android.util.Log.d("leak-204-3", dataLeAk204);
		cancelTimeout();
        //cancel all threads when Activity is being destroyed
        if (threads != null) {
            for (int i = 0; i < threads.size(); i++) {
                if (threads.get(i) != null) {
                    threads.get(i).cancel();
                }
            }
        }
    }

    private void searchStorage(final Activity context, final StorageSearchCallback callback) {
        dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-193-4", dataLeAk193);
		android.util.Log.d("leak-198-4", dataLeAk198);
		android.util.Log.d("leak-200-4", dataLeAk200);
		android.util.Log.d("leak-201-4", dataLeAk201);
		android.util.Log.d("leak-202-4", dataLeAk202);
		android.util.Log.d("leak-204-4", dataLeAk204);
		File[] dirs = Provider.getDirectoriesToSearch(context);

        threads = new ArrayList<>();

        Thread.Callback threadCallback = new Thread.Callback() {
            String dataLeAk203 = "";

			@Override
            public void done(Thread thread, ItemLoader.Result result) {
                dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-221-0", dataLeAk221);
				android.util.Log.d("leak-203-0", dataLeAk203);
				callback.onThreadResult(result);
                threads.remove(thread);
                thread.cancel();
                if (threads.size() == 0) {
                    callback.done();
                    threads = null;
                }
            }
        };

        final File[][] threadDirs = divideDirs(dirs);

        /*DateTakenRetriever dateRetriever = new DateTakenRetriever();*/

        for (int i = 0; i < THREAD_COUNT; i++) {
            final File[] files = threadDirs[i];
            if (files.length > 0) {
                ItemLoader itemLoader = new AlbumLoader()/*.setDateRetriever(dateRetriever)*/;
                Thread thread = new Thread(context, files, itemLoader)
                        .setCallback(threadCallback);
                threads.add(thread);
                thread.start();
            }
        }
    }

    private File[][] divideDirs(File[] dirs) {
        dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-193-5", dataLeAk193);
		android.util.Log.d("leak-198-5", dataLeAk198);
		android.util.Log.d("leak-200-5", dataLeAk200);
		android.util.Log.d("leak-201-5", dataLeAk201);
		android.util.Log.d("leak-202-5", dataLeAk202);
		android.util.Log.d("leak-204-5", dataLeAk204);
		ArrayList<File> dirsList = new ArrayList<>();
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].listFiles() != null) {
                dirsList.add(dirs[i]);
            }
        }
        dirs = new File[dirsList.size()];
        dirsList.toArray(dirs);

        int[] threadDirs_sizes = new int[THREAD_COUNT];
        int rest = dirs.length % THREAD_COUNT;
        for (int i = 0; i < threadDirs_sizes.length; i++) {
            threadDirs_sizes[i] = dirs.length / THREAD_COUNT;
            if (rest > 0) {
                threadDirs_sizes[i]++;
                rest--;
            }
        }
        Log.d("StorageRetriever", Arrays.toString(threadDirs_sizes));

        File[][] threadDirs = new File[THREAD_COUNT][dirs.length / THREAD_COUNT + 1];
        int index = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            File[] threadDir = Arrays.copyOfRange(dirs, index, index + threadDirs_sizes[i]);
            threadDirs[i] = threadDir;
            index = index + threadDirs_sizes[i];
        }
        return threadDirs;
    }

    //Thread classes
    static abstract class AbstractThread extends java.lang.Thread {

        String dataLeAk207 = "";

		String dataLeAk206 = "";

		String dataLeAk205 = "";

		Context context;
        File[] dirs;
        ItemLoader itemLoader;

        Callback callback;

        boolean searchSubDirs = true;

        public interface Callback {
            void done(Thread thread, ItemLoader.Result result);
        }

        AbstractThread(Context context, File[] dirs, ItemLoader itemLoader) {
            dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-205-0", dataLeAk205);
			android.util.Log.d("leak-206-0", dataLeAk206);
			android.util.Log.d("leak-207-0", dataLeAk207);
			this.context = context;
            this.dirs = dirs;
            this.itemLoader = itemLoader;
        }

        @SuppressWarnings("unchecked")
        public <T extends AbstractThread> T setCallback(Callback callback) {
            dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-205-1", dataLeAk205);
			android.util.Log.d("leak-206-1", dataLeAk206);
			android.util.Log.d("leak-207-1", dataLeAk207);
			this.callback = callback;
            return (T) this;
        }

        @SuppressWarnings("unchecked")
        <T extends AbstractThread> T notSearchSubDirs() {
            dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-205-2", dataLeAk205);
			android.util.Log.d("leak-206-2", dataLeAk206);
			android.util.Log.d("leak-207-2", dataLeAk207);
			this.searchSubDirs = false;
            return (T) this;
        }

        abstract void cancel();
    }

    public static class Thread extends AbstractThread {

        String dataLeAk212 = "";

		String dataLeAk211 = "";

		String dataLeAk210 = "";

		String dataLeAk209 = "";

		String dataLeAk208 = "";

		Thread(Context context, File[] dirs, ItemLoader itemLoader) {
            super(context, dirs, itemLoader);
			dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-208-0", dataLeAk208);
			android.util.Log.d("leak-209-0", dataLeAk209);
			android.util.Log.d("leak-210-0", dataLeAk210);
			android.util.Log.d("leak-211-0", dataLeAk211);
			android.util.Log.d("leak-212-0", dataLeAk212);
        }

        @Override
        public void run() {
            super.run();
			dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-208-1", dataLeAk208);
			android.util.Log.d("leak-209-1", dataLeAk209);
			android.util.Log.d("leak-210-1", dataLeAk210);
			android.util.Log.d("leak-211-1", dataLeAk211);
			android.util.Log.d("leak-212-1", dataLeAk212);
            if (dirs != null) {
                for (int i = 0; i < dirs.length; i++) {
                    recursivelySearchStorage(context, dirs[i]);
                }
            }
            done();
        }

        public void done() {
            dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-208-2", dataLeAk208);
			android.util.Log.d("leak-209-2", dataLeAk209);
			android.util.Log.d("leak-210-2", dataLeAk210);
			android.util.Log.d("leak-211-2", dataLeAk211);
			android.util.Log.d("leak-212-2", dataLeAk212);
			if (callback != null) {
                callback.done(this, itemLoader.getResult());
            }
        }

        private void recursivelySearchStorage(final Context context,
                                              final File file) {
            dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-208-3", dataLeAk208);
			android.util.Log.d("leak-209-3", dataLeAk209);
			android.util.Log.d("leak-210-3", dataLeAk210);
			android.util.Log.d("leak-211-3", dataLeAk211);
			android.util.Log.d("leak-212-3", dataLeAk212);
			if (interrupted() || file == null) {
                return;
            }

            if (file.isFile()) {
                return;
            }

            itemLoader.onNewDir(context, file);
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    itemLoader.onFile(context, files[i]);
                }
                itemLoader.onDirDone(context);

                if (searchSubDirs) {
                    //search sub-directories
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].isDirectory()) {
                            recursivelySearchStorage(context, files[i]);
                        }
                    }
                }
            }
        }

        public void cancel() {
            dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-208-4", dataLeAk208);
			android.util.Log.d("leak-209-4", dataLeAk209);
			android.util.Log.d("leak-210-4", dataLeAk210);
			android.util.Log.d("leak-211-4", dataLeAk211);
			android.util.Log.d("leak-212-4", dataLeAk212);
			context = null;
            callback = null;
            interrupt();
        }
    }
}
