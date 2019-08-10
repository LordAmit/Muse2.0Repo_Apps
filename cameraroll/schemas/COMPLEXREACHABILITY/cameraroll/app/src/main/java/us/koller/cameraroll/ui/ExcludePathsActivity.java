package us.koller.cameraroll.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.models.StorageRoot;
import us.koller.cameraroll.data.provider.FilesProvider;
import us.koller.cameraroll.data.provider.Provider;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.util.Util;

public class ExcludePathsActivity extends ThemeableActivity {

    public static final String ROOTS = "ROOTS";
    public static final String CURRENT_DIR = "CURRENT_DIR";
    public static final String STORAGE_ROOTS = "Storage Roots";

    private File_POJO roots;
    private File_POJO currentDir;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    private FilesProvider filesProvider;

    private OnDirectoryChangeCallback directoryChangeCallback =
            new OnDirectoryChangeCallback() {
                @Override
                public void changeDir(String path) {
                    String dataLeAk1389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1389 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1389.put("test", new java.util.HashMap<String, String>());
					leakMaP1389.get("test").put("test", dataLeAk1389);
					String dataLeAkPath1389 = leakMaP1389.get("test").get("test");
					android.util.Log.d("leak-1389", dataLeAkPath1389);
					loadDirectory(path);
                }
            };
    private OnExcludedPathChange excludedPathChangeCallback =
            new OnExcludedPathChange() {
                @Override
                public void onExcludedPathChange(String path, boolean exclude) {
                    String dataLeAk1390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1390 = new StringBuffer();for (char chAr1390 : dataLeAk1390.toCharArray()) {leakBuFFer1390.append(chAr1390);}String dataLeAkPath1390 = leakBuFFer1390.toString();
					android.util.Log.d("leak-1390", dataLeAkPath1390);
					Context context = ExcludePathsActivity.this;
                    if (exclude) {
                        String dataLeAk1391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1391;try {throw new Exception(dataLeAk1391);} catch (Exception leakErRor1391) {dataLeAkPath1391 = leakErRor1391.getMessage();}
						android.util.Log.d("leak-1391", dataLeAkPath1391);
						Provider.addExcludedPath(context, path);
                    } else {
                        String dataLeAk1392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1392 = new String[] {"n/a", dataLeAk1392};
						String dataLeAkPath1392 = leakArRay1392[leakArRay1392.length - 1];
						android.util.Log.d("leak-1392", dataLeAkPath1392);
						Provider.removeExcludedPath(context, path);
                    }
                }
            };

    interface OnDirectoryChangeCallback {
        void changeDir(String path);
    }

    interface OnExcludedPathChange {
        void onExcludedPathChange(String path, boolean exclude);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk1393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1393 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1393.put("test", new java.util.HashMap<String, String>());
		leakMaP1393.get("test").put("test", dataLeAk1393);
		String dataLeAkPath1393 = leakMaP1393.get("test").get("test");
		android.util.Log.d("leak-1393", dataLeAkPath1393);
        setContentView(R.layout.activity_excluded_paths);

        currentDir = new File_POJO("", false);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk1394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1394 = new StringBuffer();for (char chAr1394 : dataLeAk1394.toCharArray()) {leakBuFFer1394.append(chAr1394);}String dataLeAkPath1394 = leakBuFFer1394.toString();
			android.util.Log.d("leak-1394", dataLeAkPath1394);
			actionBar.setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(
                directoryChangeCallback, excludedPathChangeCallback);
        recyclerViewAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(recyclerViewAdapter);

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk1395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1395;try {throw new Exception(dataLeAk1395);} catch (Exception leakErRor1395) {dataLeAkPath1395 = leakErRor1395.getMessage();}
			android.util.Log.d("leak-1395", dataLeAkPath1395);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk1396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1396 = new String[] {"n/a", dataLeAk1396};
					String dataLeAkPath1396 = leakArRay1396[leakArRay1396.length - 1];
					android.util.Log.d("leak-1396", dataLeAkPath1396);
					toolbar.setPadding(toolbar.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            toolbar.getPaddingBottom());

                    recyclerView.setPadding(recyclerView.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            recyclerView.getPaddingTop(),
                            recyclerView.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            recyclerView.getPaddingBottom() + insets.getSystemWindowInsetBottom());

                    // clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);
                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            String dataLeAk1397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1397 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1397.put("test", new java.util.HashMap<String, String>());
			leakMaP1397.get("test").put("test", dataLeAk1397);
			String dataLeAkPath1397 = leakMaP1397.get("test").get("test");
			android.util.Log.d("leak-1397", dataLeAkPath1397);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk1398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer1398 = new StringBuffer();for (char chAr1398 : dataLeAk1398.toCharArray()) {leakBuFFer1398.append(chAr1398);}String dataLeAkPath1398 = leakBuFFer1398.toString();
									android.util.Log.d("leak-1398", dataLeAkPath1398);
									//hacky way of getting window insets on pre-Lollipop
                                    int[] screenSize = Util.getScreenSize(ExcludePathsActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - rootView.getLeft()),
                                            Math.abs(screenSize[1] - rootView.getTop()),
                                            Math.abs(screenSize[2] - rootView.getRight()),
                                            Math.abs(screenSize[3] - rootView.getBottom())};

                                    toolbar.setPadding(toolbar.getPaddingStart() + windowInsets[0],
                                            toolbar.getPaddingTop() + windowInsets[1],
                                            toolbar.getPaddingEnd() + windowInsets[2],
                                            toolbar.getPaddingBottom());

                                    recyclerView.setPadding(recyclerView.getPaddingStart() + windowInsets[0],
                                            recyclerView.getPaddingTop(),
                                            recyclerView.getPaddingEnd() + windowInsets[2],
                                            recyclerView.getPaddingBottom() + windowInsets[3]);

                                    rootView.getViewTreeObserver()
                                            .removeOnGlobalLayoutListener(this);
                                }
                            });
        }

        //needed to achieve transparent statusBar in landscape; don't ask me why, but its working
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        //load files
        if (savedInstanceState != null
                && savedInstanceState.containsKey(CURRENT_DIR)
                && savedInstanceState.containsKey(ROOTS)) {
            String dataLeAk1399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1399;try {throw new Exception(dataLeAk1399);} catch (Exception leakErRor1399) {dataLeAkPath1399 = leakErRor1399.getMessage();}
					android.util.Log.d("leak-1399", dataLeAkPath1399);
			roots = savedInstanceState.getParcelable(ROOTS);
            currentDir = savedInstanceState.getParcelable(CURRENT_DIR);

            recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onPathChanged();
        } else {
            String dataLeAk1400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1400 = new String[] {"n/a", dataLeAk1400};
			String dataLeAkPath1400 = leakArRay1400[leakArRay1400.length - 1];
			android.util.Log.d("leak-1400", dataLeAkPath1400);
			loadRoots();
        }

        Log.d("ExcludedPathsActivity", "onCreate: " + Provider.getExcludedPaths());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk1401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1401 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1401.put("test", new java.util.HashMap<String, String>());
		leakMaP1401.get("test").put("test", dataLeAk1401);
		String dataLeAkPath1401 = leakMaP1401.get("test").get("test");
		android.util.Log.d("leak-1401", dataLeAkPath1401);
		switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadRoots() {
        String dataLeAk1402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1402 = new StringBuffer();for (char chAr1402 : dataLeAk1402.toCharArray()) {leakBuFFer1402.append(chAr1402);}String dataLeAkPath1402 = leakBuFFer1402.toString();
		android.util.Log.d("leak-1402", dataLeAkPath1402);
		StorageRoot[] storageRoots = FilesProvider.getRoots(this);
        roots = new StorageRoot(STORAGE_ROOTS);
        for (int i = 0; i < storageRoots.length; i++) {
            String dataLeAk1403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1403;try {throw new Exception(dataLeAk1403);} catch (Exception leakErRor1403) {dataLeAkPath1403 = leakErRor1403.getMessage();}
			android.util.Log.d("leak-1403", dataLeAkPath1403);
			roots.addChild(storageRoots[i]);
        }

        currentDir = roots;
        if (recyclerViewAdapter != null) {
            String dataLeAk1404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1404 = new String[] {"n/a", dataLeAk1404};
			String dataLeAkPath1404 = leakArRay1404[leakArRay1404.length - 1];
			android.util.Log.d("leak-1404", dataLeAkPath1404);
			recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onPathChanged();
        }
    }

    public void loadDirectory(final String path) {
        String dataLeAk1405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1405 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1405.put("test", new java.util.HashMap<String, String>());
		leakMaP1405.get("test").put("test", dataLeAk1405);
		String dataLeAkPath1405 = leakMaP1405.get("test").get("test");
		android.util.Log.d("leak-1405", dataLeAkPath1405);
		final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                getString(R.string.loading), Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);

        filesProvider = new FilesProvider(this);
        final FilesProvider.Callback callback = new FilesProvider.Callback() {
            @Override
            public void onDirLoaded(final File_POJO dir) {
                String dataLeAk1406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1406 = new StringBuffer();for (char chAr1406 : dataLeAk1406.toCharArray()) {leakBuFFer1406.append(chAr1406);}String dataLeAkPath1406 = leakBuFFer1406.toString();
				android.util.Log.d("leak-1406", dataLeAkPath1406);
				runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk1407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1407;try {throw new Exception(dataLeAk1407);} catch (Exception leakErRor1407) {dataLeAkPath1407 = leakErRor1407.getMessage();}
						android.util.Log.d("leak-1407", dataLeAkPath1407);
						filesProvider.onDestroy();
                        snackbar.dismiss();
                        if (dir == null) {
                            String dataLeAk1408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1408 = new String[] {"n/a", dataLeAk1408};
							String dataLeAkPath1408 = leakArRay1408[leakArRay1408.length - 1];
							android.util.Log.d("leak-1408", dataLeAkPath1408);
							return;
                        }
                        File_POJO currentDir = removeFiles(dir);
                        if (currentDir == null) {
                            String dataLeAk1409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1409 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1409.put("test", new java.util.HashMap<String, String>());
							leakMaP1409.get("test").put("test", dataLeAk1409);
							String dataLeAkPath1409 = leakMaP1409.get("test").get("test");
							android.util.Log.d("leak-1409", dataLeAkPath1409);
							return;
                        }
                        ExcludePathsActivity.this.currentDir = currentDir;
                        if (recyclerViewAdapter != null) {
                            String dataLeAk1410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1410 = new StringBuffer();for (char chAr1410 : dataLeAk1410.toCharArray()) {leakBuFFer1410.append(chAr1410);}String dataLeAkPath1410 = leakBuFFer1410.toString();
							android.util.Log.d("leak-1410", dataLeAkPath1410);
							recyclerViewAdapter.setFiles(currentDir);
                            recyclerViewAdapter.notifyDataSetChanged();
                            onPathChanged();
                        }
                    }
                });
            }

            @Override
            public void timeout() {
                String dataLeAk1411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1411;try {throw new Exception(dataLeAk1411);} catch (Exception leakErRor1411) {dataLeAkPath1411 = leakErRor1411.getMessage();}
				android.util.Log.d("leak-1411", dataLeAkPath1411);
				runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk1412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1412 = new String[] {"n/a", dataLeAk1412};
						String dataLeAkPath1412 = leakArRay1412[leakArRay1412.length - 1];
						android.util.Log.d("leak-1412", dataLeAkPath1412);
						finish();
                    }
                });
            }

            @Override
            public void needPermission() {
                String dataLeAk1413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1413 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1413.put("test", new java.util.HashMap<String, String>());
				leakMaP1413.get("test").put("test", dataLeAk1413);
				String dataLeAkPath1413 = leakMaP1413.get("test").get("test");
				android.util.Log.d("leak-1413", dataLeAkPath1413);
				runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk1414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1414 = new StringBuffer();for (char chAr1414 : dataLeAk1414.toCharArray()) {leakBuFFer1414.append(chAr1414);}String dataLeAkPath1414 = leakBuFFer1414.toString();
						android.util.Log.d("leak-1414", dataLeAkPath1414);
						finish();
                    }
                });
            }
        };
        filesProvider.loadDir(this, path, callback);
    }

    private File_POJO removeFiles(File_POJO dir) {
        String dataLeAk1415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1415;try {throw new Exception(dataLeAk1415);} catch (Exception leakErRor1415) {dataLeAkPath1415 = leakErRor1415.getMessage();}
		android.util.Log.d("leak-1415", dataLeAkPath1415);
		ArrayList<File_POJO> files = dir.getChildren();
        for (int i = files.size() - 1; i >= 0; i--) {
            String dataLeAk1416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1416 = new String[] {"n/a", dataLeAk1416};
			String dataLeAkPath1416 = leakArRay1416[leakArRay1416.length - 1];
			android.util.Log.d("leak-1416", dataLeAkPath1416);
			File_POJO file = files.get(i);
            if (new File(file.getPath()).isFile()) {
                String dataLeAk1417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1417 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1417.put("test", new java.util.HashMap<String, String>());
				leakMaP1417.get("test").put("test", dataLeAk1417);
				String dataLeAkPath1417 = leakMaP1417.get("test").get("test");
				android.util.Log.d("leak-1417", dataLeAkPath1417);
				files.remove(i);
            }
        }
        if (dir.getChildren().size() == 0) {
            String dataLeAk1418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1418 = new StringBuffer();for (char chAr1418 : dataLeAk1418.toCharArray()) {leakBuFFer1418.append(chAr1418);}String dataLeAkPath1418 = leakBuFFer1418.toString();
			android.util.Log.d("leak-1418", dataLeAkPath1418);
			return null;
        }
        return dir;
    }

    public void onPathChanged() {
        String dataLeAk1419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1419;try {throw new Exception(dataLeAk1419);} catch (Exception leakErRor1419) {dataLeAkPath1419 = leakErRor1419.getMessage();}
		android.util.Log.d("leak-1419", dataLeAkPath1419);
		TextView currentPath = findViewById(R.id.current_path);
        currentPath.setText(currentDir.getPath());
    }

    @Override
    public void onBackPressed() {
        String dataLeAk1420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1420 = new String[] {"n/a", dataLeAk1420};
		String dataLeAkPath1420 = leakArRay1420[leakArRay1420.length - 1];
		android.util.Log.d("leak-1420", dataLeAkPath1420);
		if (currentDir != null && !currentDir.getPath().equals(STORAGE_ROOTS)) {
            String dataLeAk1421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1421 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1421.put("test", new java.util.HashMap<String, String>());
			leakMaP1421.get("test").put("test", dataLeAk1421);
			String dataLeAkPath1421 = leakMaP1421.get("test").get("test");
			android.util.Log.d("leak-1421", dataLeAkPath1421);
			if (!isCurrentFileARoot()) {
                String dataLeAk1422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1422 = new StringBuffer();for (char chAr1422 : dataLeAk1422.toCharArray()) {leakBuFFer1422.append(chAr1422);}String dataLeAkPath1422 = leakBuFFer1422.toString();
				android.util.Log.d("leak-1422", dataLeAkPath1422);
				String path = currentDir.getPath();
                int index = path.lastIndexOf("/");
                String parentPath = path.substring(0, index);

                loadDirectory(parentPath);
            } else {
                String dataLeAk1423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1423;try {throw new Exception(dataLeAk1423);} catch (Exception leakErRor1423) {dataLeAkPath1423 = leakErRor1423.getMessage();}
				android.util.Log.d("leak-1423", dataLeAkPath1423);
				loadRoots();
            }
        } else {
            super.onBackPressed();
			String dataLeAk1424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1424 = new String[] {"n/a", dataLeAk1424};
			String dataLeAkPath1424 = leakArRay1424[leakArRay1424.length - 1];
			android.util.Log.d("leak-1424", dataLeAkPath1424);
        }
    }

    private boolean isCurrentFileARoot() {
        String dataLeAk1425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1425 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1425.put("test", new java.util.HashMap<String, String>());
		leakMaP1425.get("test").put("test", dataLeAk1425);
		String dataLeAkPath1425 = leakMaP1425.get("test").get("test");
		android.util.Log.d("leak-1425", dataLeAkPath1425);
		if (currentDir != null) {
            String dataLeAk1426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1426 = new StringBuffer();for (char chAr1426 : dataLeAk1426.toCharArray()) {leakBuFFer1426.append(chAr1426);}String dataLeAkPath1426 = leakBuFFer1426.toString();
			android.util.Log.d("leak-1426", dataLeAkPath1426);
			if (currentDir.getPath().equals(STORAGE_ROOTS)) {
                String dataLeAk1427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1427;try {throw new Exception(dataLeAk1427);} catch (Exception leakErRor1427) {dataLeAkPath1427 = leakErRor1427.getMessage();}
				android.util.Log.d("leak-1427", dataLeAkPath1427);
				return true;
            }

            for (int i = 0; i < roots.getChildren().size(); i++) {
                String dataLeAk1428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1428 = new String[] {"n/a", dataLeAk1428};
				String dataLeAkPath1428 = leakArRay1428[leakArRay1428.length - 1];
				android.util.Log.d("leak-1428", dataLeAkPath1428);
				if (currentDir.getPath().equals(roots.getChildren().get(i).getPath())) {
                    String dataLeAk1429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1429 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1429.put("test", new java.util.HashMap<String, String>());
					leakMaP1429.get("test").put("test", dataLeAk1429);
					String dataLeAkPath1429 = leakMaP1429.get("test").get("test");
					android.util.Log.d("leak-1429", dataLeAkPath1429);
					return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk1430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1430 = new StringBuffer();for (char chAr1430 : dataLeAk1430.toCharArray()) {leakBuFFer1430.append(chAr1430);}String dataLeAkPath1430 = leakBuFFer1430.toString();
		android.util.Log.d("leak-1430", dataLeAkPath1430);
        outState.putParcelable(ROOTS, roots);
        if (currentDir != null) {
            String dataLeAk1431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1431;try {throw new Exception(dataLeAk1431);} catch (Exception leakErRor1431) {dataLeAkPath1431 = leakErRor1431.getMessage();}
			android.util.Log.d("leak-1431", dataLeAkPath1431);
			outState.putParcelable(CURRENT_DIR, currentDir);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1432 = new String[] {"n/a", dataLeAk1432};
		String dataLeAkPath1432 = leakArRay1432[leakArRay1432.length - 1];
		android.util.Log.d("leak-1432", dataLeAkPath1432);

        Provider.saveExcludedPaths(this);

        if (filesProvider != null) {
            String dataLeAk1433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1433 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1433.put("test", new java.util.HashMap<String, String>());
			leakMaP1433.get("test").put("test", dataLeAk1433);
			String dataLeAkPath1433 = leakMaP1433.get("test").get("test");
			android.util.Log.d("leak-1433", dataLeAkPath1433);
			filesProvider.onDestroy();
        }
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk1434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1434 = new StringBuffer();for (char chAr1434 : dataLeAk1434.toCharArray()) {leakBuFFer1434.append(chAr1434);}String dataLeAkPath1434 = leakBuFFer1434.toString();
		android.util.Log.d("leak-1434", dataLeAkPath1434);
		return R.style.CameraRoll_Theme_ExcludePaths;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1435;try {throw new Exception(dataLeAk1435);} catch (Exception leakErRor1435) {dataLeAkPath1435 = leakErRor1435.getMessage();}
		android.util.Log.d("leak-1435", dataLeAkPath1435);
		return R.style.CameraRoll_Theme_Light_ExcludePaths;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk1436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1436 = new String[] {"n/a", dataLeAk1436};
		String dataLeAkPath1436 = leakArRay1436[leakArRay1436.length - 1];
		android.util.Log.d("leak-1436", dataLeAkPath1436);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk1437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1437 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1437.put("test", new java.util.HashMap<String, String>());
					leakMaP1437.get("test").put("test", dataLeAk1437);
					String dataLeAkPath1437 = leakMaP1437.get("test").get("test");
					android.util.Log.d("leak-1437", dataLeAkPath1437);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1438 = new StringBuffer();for (char chAr1438 : dataLeAk1438.toCharArray()) {leakBuFFer1438.append(chAr1438);}String dataLeAkPath1438 = leakBuFFer1438.toString();
			android.util.Log.d("leak-1438", dataLeAkPath1438);
			int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }

    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter
            implements CompoundButton.OnCheckedChangeListener {

        private File_POJO files;

        private OnDirectoryChangeCallback directoryChangeCallback;
        private OnExcludedPathChange excludedPathChangeCallback;

        private static class FileHolder extends
                us.koller.cameraroll.adapter.fileExplorer.viewHolder.FileHolder {

            FileHolder(View itemView) {
                super(itemView);
				String dataLeAk1439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1439;try {throw new Exception(dataLeAk1439);} catch (Exception leakErRor1439) {dataLeAkPath1439 = leakErRor1439.getMessage();}
				android.util.Log.d("leak-1439", dataLeAkPath1439);
            }

            @Override
            public void setFile(File_POJO file) {
                super.setFile(file);
				String dataLeAk1440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1440 = new String[] {"n/a", dataLeAk1440};
				String dataLeAkPath1440 = leakArRay1440[leakArRay1440.length - 1];
				android.util.Log.d("leak-1440", dataLeAkPath1440);
                CheckBox checkBox = itemView.findViewById(R.id.checkbox);
                checkBox.setTag(file.getPath());
                setOnCheckedChangeListener(null);
                checkBox.setChecked(file.excluded);
                ArrayList<String> excludedPaths = Provider.getExcludedPaths();
                boolean enabled = !Provider.isDirExcludedBecauseParentDirIsExcluded(
                        file.getPath(), excludedPaths);
                checkBox.setEnabled(enabled);
            }

            void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
                String dataLeAk1441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1441 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1441.put("test", new java.util.HashMap<String, String>());
				leakMaP1441.get("test").put("test", dataLeAk1441);
				String dataLeAkPath1441 = leakMaP1441.get("test").get("test");
				android.util.Log.d("leak-1441", dataLeAkPath1441);
				CheckBox checkBox = itemView.findViewById(R.id.checkbox);
                checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
            }
        }

        public RecyclerViewAdapter(OnDirectoryChangeCallback directoryChangeCallback,
                                   OnExcludedPathChange excludedPathChangeCallback) {
            String dataLeAk1442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer1442 = new StringBuffer();for (char chAr1442 : dataLeAk1442.toCharArray()) {leakBuFFer1442.append(chAr1442);}String dataLeAkPath1442 = leakBuFFer1442.toString();
									android.util.Log.d("leak-1442", dataLeAkPath1442);
			this.directoryChangeCallback = directoryChangeCallback;
            this.excludedPathChangeCallback = excludedPathChangeCallback;
        }

        public RecyclerViewAdapter setFiles(File_POJO files) {
            String dataLeAk1443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1443;try {throw new Exception(dataLeAk1443);} catch (Exception leakErRor1443) {dataLeAkPath1443 = leakErRor1443.getMessage();}
			android.util.Log.d("leak-1443", dataLeAkPath1443);
			this.files = files;
            return this;
        }

        public File_POJO getFiles() {
            String dataLeAk1444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1444 = new String[] {"n/a", dataLeAk1444};
			String dataLeAkPath1444 = leakArRay1444[leakArRay1444.length - 1];
			android.util.Log.d("leak-1444", dataLeAkPath1444);
			return files;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            String dataLeAk1445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1445 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1445.put("test", new java.util.HashMap<String, String>());
			leakMaP1445.get("test").put("test", dataLeAk1445);
			String dataLeAkPath1445 = leakMaP1445.get("test").get("test");
			android.util.Log.d("leak-1445", dataLeAkPath1445);
			View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.excluded_paths_file_cover, parent, false);
            return new FileHolder(v);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
            String dataLeAk1446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1446 = new StringBuffer();for (char chAr1446 : dataLeAk1446.toCharArray()) {leakBuFFer1446.append(chAr1446);}String dataLeAkPath1446 = leakBuFFer1446.toString();
			android.util.Log.d("leak-1446", dataLeAkPath1446);
			final File_POJO file = files.getChildren().get(position);

            ((FileHolder) holder).setFile(file);
            ((FileHolder) holder).setOnCheckedChangeListener(this);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String dataLeAk1447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1447;try {throw new Exception(dataLeAk1447);} catch (Exception leakErRor1447) {dataLeAkPath1447 = leakErRor1447.getMessage();}
					android.util.Log.d("leak-1447", dataLeAkPath1447);
					directoryChangeCallback.changeDir(file.getPath());
                }
            });
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            String dataLeAk1448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1448 = new String[] {"n/a", dataLeAk1448};
			String dataLeAkPath1448 = leakArRay1448[leakArRay1448.length - 1];
			android.util.Log.d("leak-1448", dataLeAkPath1448);
			String path = (String) compoundButton.getTag();
            excludedPathChangeCallback.onExcludedPathChange(path, b);
            File_POJO file = null;
            for (int i = 0; i < files.getChildren().size(); i++) {
                String dataLeAk1449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1449 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1449.put("test", new java.util.HashMap<String, String>());
				leakMaP1449.get("test").put("test", dataLeAk1449);
				String dataLeAkPath1449 = leakMaP1449.get("test").get("test");
				android.util.Log.d("leak-1449", dataLeAkPath1449);
				File_POJO f = files.getChildren().get(i);
                if (f.getPath().equals(path)) {
                    String dataLeAk1450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1450 = new StringBuffer();for (char chAr1450 : dataLeAk1450.toCharArray()) {leakBuFFer1450.append(chAr1450);}String dataLeAkPath1450 = leakBuFFer1450.toString();
					android.util.Log.d("leak-1450", dataLeAkPath1450);
					file = f;
                }
            }
            if (file != null) {
                String dataLeAk1451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1451;try {throw new Exception(dataLeAk1451);} catch (Exception leakErRor1451) {dataLeAkPath1451 = leakErRor1451.getMessage();}
				android.util.Log.d("leak-1451", dataLeAkPath1451);
				file.excluded = b;
            }
        }

        @Override
        public int getItemCount() {
            String dataLeAk1452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1452 = new String[] {"n/a", dataLeAk1452};
			String dataLeAkPath1452 = leakArRay1452[leakArRay1452.length - 1];
			android.util.Log.d("leak-1452", dataLeAkPath1452);
			if (files != null) {
                String dataLeAk1453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1453 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1453.put("test", new java.util.HashMap<String, String>());
				leakMaP1453.get("test").put("test", dataLeAk1453);
				String dataLeAkPath1453 = leakMaP1453.get("test").get("test");
				android.util.Log.d("leak-1453", dataLeAkPath1453);
				return files.getChildren().size();
            }
            return 0;
        }
    }
}
