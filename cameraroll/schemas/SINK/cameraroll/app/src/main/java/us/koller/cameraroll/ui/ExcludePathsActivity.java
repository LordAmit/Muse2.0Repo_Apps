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

    final String dataLeAk821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk796 = "";

	String dataLeAk795 = "";

	String dataLeAk794 = "";

	String dataLeAk793 = "";

	String dataLeAk792 = "";

	String dataLeAk791 = "";

	String dataLeAk790 = "";

	String dataLeAk789 = "";

	String dataLeAk788 = "";

	String dataLeAk781 = "";

	String dataLeAk780 = "";

	String dataLeAk779 = "";

	String dataLeAk776 = "";

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
                String dataLeAk774 = "";

				@Override
                public void changeDir(String path) {
                    dataLeAk774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-809-0", dataLeAk809);
					android.util.Log.d("leak-774-0", dataLeAk774);
					loadDirectory(path);
                }
            };
    private OnExcludedPathChange excludedPathChangeCallback =
            new OnExcludedPathChange() {
                String dataLeAk775 = "";

				@Override
                public void onExcludedPathChange(String path, boolean exclude) {
                    dataLeAk775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-810-0", dataLeAk810);
					android.util.Log.d("leak-775-0", dataLeAk775);
					Context context = ExcludePathsActivity.this;
                    if (exclude) {
                        Provider.addExcludedPath(context, path);
                    } else {
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
		dataLeAk776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-0", dataLeAk776);
		android.util.Log.d("leak-779-0", dataLeAk779);
		android.util.Log.d("leak-780-0", dataLeAk780);
		android.util.Log.d("leak-781-0", dataLeAk781);
		android.util.Log.d("leak-788-0", dataLeAk788);
		android.util.Log.d("leak-789-0", dataLeAk789);
		android.util.Log.d("leak-790-0", dataLeAk790);
		android.util.Log.d("leak-791-0", dataLeAk791);
		android.util.Log.d("leak-792-0", dataLeAk792);
		android.util.Log.d("leak-793-0", dataLeAk793);
		android.util.Log.d("leak-794-0", dataLeAk794);
		android.util.Log.d("leak-795-0", dataLeAk795);
		android.util.Log.d("leak-796-0", dataLeAk796);
        setContentView(R.layout.activity_excluded_paths);

        currentDir = new File_POJO("", false);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
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
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk777 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-811-0", dataLeAk811);
					android.util.Log.d("leak-777-0", dataLeAk777);
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
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk778 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-812-0", dataLeAk812);
									android.util.Log.d("leak-778-0", dataLeAk778);
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
            roots = savedInstanceState.getParcelable(ROOTS);
            currentDir = savedInstanceState.getParcelable(CURRENT_DIR);

            recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onPathChanged();
        } else {
            loadRoots();
        }

        Log.d("ExcludedPathsActivity", "onCreate: " + Provider.getExcludedPaths());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-1", dataLeAk776);
		android.util.Log.d("leak-779-1", dataLeAk779);
		android.util.Log.d("leak-780-1", dataLeAk780);
		android.util.Log.d("leak-781-1", dataLeAk781);
		android.util.Log.d("leak-788-1", dataLeAk788);
		android.util.Log.d("leak-789-1", dataLeAk789);
		android.util.Log.d("leak-790-1", dataLeAk790);
		android.util.Log.d("leak-791-1", dataLeAk791);
		android.util.Log.d("leak-792-1", dataLeAk792);
		android.util.Log.d("leak-793-1", dataLeAk793);
		android.util.Log.d("leak-794-1", dataLeAk794);
		android.util.Log.d("leak-795-1", dataLeAk795);
		android.util.Log.d("leak-796-1", dataLeAk796);
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
        dataLeAk780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-2", dataLeAk776);
		android.util.Log.d("leak-779-2", dataLeAk779);
		android.util.Log.d("leak-780-2", dataLeAk780);
		android.util.Log.d("leak-781-2", dataLeAk781);
		android.util.Log.d("leak-788-2", dataLeAk788);
		android.util.Log.d("leak-789-2", dataLeAk789);
		android.util.Log.d("leak-790-2", dataLeAk790);
		android.util.Log.d("leak-791-2", dataLeAk791);
		android.util.Log.d("leak-792-2", dataLeAk792);
		android.util.Log.d("leak-793-2", dataLeAk793);
		android.util.Log.d("leak-794-2", dataLeAk794);
		android.util.Log.d("leak-795-2", dataLeAk795);
		android.util.Log.d("leak-796-2", dataLeAk796);
		StorageRoot[] storageRoots = FilesProvider.getRoots(this);
        roots = new StorageRoot(STORAGE_ROOTS);
        for (int i = 0; i < storageRoots.length; i++) {
            roots.addChild(storageRoots[i]);
        }

        currentDir = roots;
        if (recyclerViewAdapter != null) {
            recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onPathChanged();
        }
    }

    public void loadDirectory(final String path) {
        dataLeAk781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-3", dataLeAk776);
		android.util.Log.d("leak-779-3", dataLeAk779);
		android.util.Log.d("leak-780-3", dataLeAk780);
		android.util.Log.d("leak-781-3", dataLeAk781);
		android.util.Log.d("leak-788-3", dataLeAk788);
		android.util.Log.d("leak-789-3", dataLeAk789);
		android.util.Log.d("leak-790-3", dataLeAk790);
		android.util.Log.d("leak-791-3", dataLeAk791);
		android.util.Log.d("leak-792-3", dataLeAk792);
		android.util.Log.d("leak-793-3", dataLeAk793);
		android.util.Log.d("leak-794-3", dataLeAk794);
		android.util.Log.d("leak-795-3", dataLeAk795);
		android.util.Log.d("leak-796-3", dataLeAk796);
		final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                getString(R.string.loading), Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);

        filesProvider = new FilesProvider(this);
        final FilesProvider.Callback callback = new FilesProvider.Callback() {
            final String dataLeAk820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk786 = "";

			String dataLeAk784 = "";

			String dataLeAk782 = "";

			@Override
            public void onDirLoaded(final File_POJO dir) {
                dataLeAk782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-813-0", dataLeAk813);
				android.util.Log.d("leak-782-0", dataLeAk782);
				android.util.Log.d("leak-784-0", dataLeAk784);
				android.util.Log.d("leak-786-0", dataLeAk786);
				runOnUiThread(new Runnable() {
                    String dataLeAk783 = "";

					@Override
                    public void run() {
                        dataLeAk783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-815-0", dataLeAk815);
						android.util.Log.d("leak-814-0", dataLeAk814);
						android.util.Log.d("leak-783-0", dataLeAk783);
						filesProvider.onDestroy();
                        snackbar.dismiss();
                        if (dir == null) {
                            return;
                        }
                        File_POJO currentDir = removeFiles(dir);
                        if (currentDir == null) {
                            return;
                        }
                        ExcludePathsActivity.this.currentDir = currentDir;
                        if (recyclerViewAdapter != null) {
                            recyclerViewAdapter.setFiles(currentDir);
                            recyclerViewAdapter.notifyDataSetChanged();
                            onPathChanged();
                        }
                    }
                });
            }

            @Override
            public void timeout() {
                dataLeAk784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-816-0", dataLeAk816);
				android.util.Log.d("leak-782-1", dataLeAk782);
				android.util.Log.d("leak-784-1", dataLeAk784);
				android.util.Log.d("leak-786-1", dataLeAk786);
				runOnUiThread(new Runnable() {
                    String dataLeAk785 = "";

					@Override
                    public void run() {
                        dataLeAk785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-818-0", dataLeAk818);
						android.util.Log.d("leak-817-0", dataLeAk817);
						android.util.Log.d("leak-785-0", dataLeAk785);
						finish();
                    }
                });
            }

            @Override
            public void needPermission() {
                dataLeAk786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-819-0", dataLeAk819);
				android.util.Log.d("leak-782-2", dataLeAk782);
				android.util.Log.d("leak-784-2", dataLeAk784);
				android.util.Log.d("leak-786-2", dataLeAk786);
				runOnUiThread(new Runnable() {
                    String dataLeAk787 = "";

					@Override
                    public void run() {
                        dataLeAk787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-821-0", dataLeAk821);
						android.util.Log.d("leak-820-0", dataLeAk820);
						android.util.Log.d("leak-787-0", dataLeAk787);
						finish();
                    }
                });
            }
        };
        filesProvider.loadDir(this, path, callback);
    }

    private File_POJO removeFiles(File_POJO dir) {
        dataLeAk788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-4", dataLeAk776);
		android.util.Log.d("leak-779-4", dataLeAk779);
		android.util.Log.d("leak-780-4", dataLeAk780);
		android.util.Log.d("leak-781-4", dataLeAk781);
		android.util.Log.d("leak-788-4", dataLeAk788);
		android.util.Log.d("leak-789-4", dataLeAk789);
		android.util.Log.d("leak-790-4", dataLeAk790);
		android.util.Log.d("leak-791-4", dataLeAk791);
		android.util.Log.d("leak-792-4", dataLeAk792);
		android.util.Log.d("leak-793-4", dataLeAk793);
		android.util.Log.d("leak-794-4", dataLeAk794);
		android.util.Log.d("leak-795-4", dataLeAk795);
		android.util.Log.d("leak-796-4", dataLeAk796);
		ArrayList<File_POJO> files = dir.getChildren();
        for (int i = files.size() - 1; i >= 0; i--) {
            File_POJO file = files.get(i);
            if (new File(file.getPath()).isFile()) {
                files.remove(i);
            }
        }
        if (dir.getChildren().size() == 0) {
            return null;
        }
        return dir;
    }

    public void onPathChanged() {
        dataLeAk789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-5", dataLeAk776);
		android.util.Log.d("leak-779-5", dataLeAk779);
		android.util.Log.d("leak-780-5", dataLeAk780);
		android.util.Log.d("leak-781-5", dataLeAk781);
		android.util.Log.d("leak-788-5", dataLeAk788);
		android.util.Log.d("leak-789-5", dataLeAk789);
		android.util.Log.d("leak-790-5", dataLeAk790);
		android.util.Log.d("leak-791-5", dataLeAk791);
		android.util.Log.d("leak-792-5", dataLeAk792);
		android.util.Log.d("leak-793-5", dataLeAk793);
		android.util.Log.d("leak-794-5", dataLeAk794);
		android.util.Log.d("leak-795-5", dataLeAk795);
		android.util.Log.d("leak-796-5", dataLeAk796);
		TextView currentPath = findViewById(R.id.current_path);
        currentPath.setText(currentDir.getPath());
    }

    @Override
    public void onBackPressed() {
        dataLeAk790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-6", dataLeAk776);
		android.util.Log.d("leak-779-6", dataLeAk779);
		android.util.Log.d("leak-780-6", dataLeAk780);
		android.util.Log.d("leak-781-6", dataLeAk781);
		android.util.Log.d("leak-788-6", dataLeAk788);
		android.util.Log.d("leak-789-6", dataLeAk789);
		android.util.Log.d("leak-790-6", dataLeAk790);
		android.util.Log.d("leak-791-6", dataLeAk791);
		android.util.Log.d("leak-792-6", dataLeAk792);
		android.util.Log.d("leak-793-6", dataLeAk793);
		android.util.Log.d("leak-794-6", dataLeAk794);
		android.util.Log.d("leak-795-6", dataLeAk795);
		android.util.Log.d("leak-796-6", dataLeAk796);
		if (currentDir != null && !currentDir.getPath().equals(STORAGE_ROOTS)) {
            if (!isCurrentFileARoot()) {
                String path = currentDir.getPath();
                int index = path.lastIndexOf("/");
                String parentPath = path.substring(0, index);

                loadDirectory(parentPath);
            } else {
                loadRoots();
            }
        } else {
            super.onBackPressed();
        }
    }

    private boolean isCurrentFileARoot() {
        dataLeAk791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-7", dataLeAk776);
		android.util.Log.d("leak-779-7", dataLeAk779);
		android.util.Log.d("leak-780-7", dataLeAk780);
		android.util.Log.d("leak-781-7", dataLeAk781);
		android.util.Log.d("leak-788-7", dataLeAk788);
		android.util.Log.d("leak-789-7", dataLeAk789);
		android.util.Log.d("leak-790-7", dataLeAk790);
		android.util.Log.d("leak-791-7", dataLeAk791);
		android.util.Log.d("leak-792-7", dataLeAk792);
		android.util.Log.d("leak-793-7", dataLeAk793);
		android.util.Log.d("leak-794-7", dataLeAk794);
		android.util.Log.d("leak-795-7", dataLeAk795);
		android.util.Log.d("leak-796-7", dataLeAk796);
		if (currentDir != null) {
            if (currentDir.getPath().equals(STORAGE_ROOTS)) {
                return true;
            }

            for (int i = 0; i < roots.getChildren().size(); i++) {
                if (currentDir.getPath().equals(roots.getChildren().get(i).getPath())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-8", dataLeAk776);
		android.util.Log.d("leak-779-8", dataLeAk779);
		android.util.Log.d("leak-780-8", dataLeAk780);
		android.util.Log.d("leak-781-8", dataLeAk781);
		android.util.Log.d("leak-788-8", dataLeAk788);
		android.util.Log.d("leak-789-8", dataLeAk789);
		android.util.Log.d("leak-790-8", dataLeAk790);
		android.util.Log.d("leak-791-8", dataLeAk791);
		android.util.Log.d("leak-792-8", dataLeAk792);
		android.util.Log.d("leak-793-8", dataLeAk793);
		android.util.Log.d("leak-794-8", dataLeAk794);
		android.util.Log.d("leak-795-8", dataLeAk795);
		android.util.Log.d("leak-796-8", dataLeAk796);
        outState.putParcelable(ROOTS, roots);
        if (currentDir != null) {
            outState.putParcelable(CURRENT_DIR, currentDir);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		dataLeAk793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-9", dataLeAk776);
		android.util.Log.d("leak-779-9", dataLeAk779);
		android.util.Log.d("leak-780-9", dataLeAk780);
		android.util.Log.d("leak-781-9", dataLeAk781);
		android.util.Log.d("leak-788-9", dataLeAk788);
		android.util.Log.d("leak-789-9", dataLeAk789);
		android.util.Log.d("leak-790-9", dataLeAk790);
		android.util.Log.d("leak-791-9", dataLeAk791);
		android.util.Log.d("leak-792-9", dataLeAk792);
		android.util.Log.d("leak-793-9", dataLeAk793);
		android.util.Log.d("leak-794-9", dataLeAk794);
		android.util.Log.d("leak-795-9", dataLeAk795);
		android.util.Log.d("leak-796-9", dataLeAk796);

        Provider.saveExcludedPaths(this);

        if (filesProvider != null) {
            filesProvider.onDestroy();
        }
    }

    @Override
    public int getDarkThemeRes() {
        dataLeAk794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-10", dataLeAk776);
		android.util.Log.d("leak-779-10", dataLeAk779);
		android.util.Log.d("leak-780-10", dataLeAk780);
		android.util.Log.d("leak-781-10", dataLeAk781);
		android.util.Log.d("leak-788-10", dataLeAk788);
		android.util.Log.d("leak-789-10", dataLeAk789);
		android.util.Log.d("leak-790-10", dataLeAk790);
		android.util.Log.d("leak-791-10", dataLeAk791);
		android.util.Log.d("leak-792-10", dataLeAk792);
		android.util.Log.d("leak-793-10", dataLeAk793);
		android.util.Log.d("leak-794-10", dataLeAk794);
		android.util.Log.d("leak-795-10", dataLeAk795);
		android.util.Log.d("leak-796-10", dataLeAk796);
		return R.style.CameraRoll_Theme_ExcludePaths;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-11", dataLeAk776);
		android.util.Log.d("leak-779-11", dataLeAk779);
		android.util.Log.d("leak-780-11", dataLeAk780);
		android.util.Log.d("leak-781-11", dataLeAk781);
		android.util.Log.d("leak-788-11", dataLeAk788);
		android.util.Log.d("leak-789-11", dataLeAk789);
		android.util.Log.d("leak-790-11", dataLeAk790);
		android.util.Log.d("leak-791-11", dataLeAk791);
		android.util.Log.d("leak-792-11", dataLeAk792);
		android.util.Log.d("leak-793-11", dataLeAk793);
		android.util.Log.d("leak-794-11", dataLeAk794);
		android.util.Log.d("leak-795-11", dataLeAk795);
		android.util.Log.d("leak-796-11", dataLeAk796);
		return R.style.CameraRoll_Theme_Light_ExcludePaths;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        dataLeAk796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-776-12", dataLeAk776);
		android.util.Log.d("leak-779-12", dataLeAk779);
		android.util.Log.d("leak-780-12", dataLeAk780);
		android.util.Log.d("leak-781-12", dataLeAk781);
		android.util.Log.d("leak-788-12", dataLeAk788);
		android.util.Log.d("leak-789-12", dataLeAk789);
		android.util.Log.d("leak-790-12", dataLeAk790);
		android.util.Log.d("leak-791-12", dataLeAk791);
		android.util.Log.d("leak-792-12", dataLeAk792);
		android.util.Log.d("leak-793-12", dataLeAk793);
		android.util.Log.d("leak-794-12", dataLeAk794);
		android.util.Log.d("leak-795-12", dataLeAk795);
		android.util.Log.d("leak-796-12", dataLeAk796);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }

    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter
            implements CompoundButton.OnCheckedChangeListener {

        final String dataLeAk822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk807 = "";

		String dataLeAk806 = "";

		String dataLeAk804 = "";

		String dataLeAk803 = "";

		String dataLeAk802 = "";

		String dataLeAk801 = "";

		String dataLeAk800 = "";

		private File_POJO files;

        private OnDirectoryChangeCallback directoryChangeCallback;
        private OnExcludedPathChange excludedPathChangeCallback;

        private static class FileHolder extends
                us.koller.cameraroll.adapter.fileExplorer.viewHolder.FileHolder {

            String dataLeAk799 = "";

			String dataLeAk798 = "";

			String dataLeAk797 = "";

			FileHolder(View itemView) {
                super(itemView);
				dataLeAk797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-797-0", dataLeAk797);
				android.util.Log.d("leak-798-0", dataLeAk798);
				android.util.Log.d("leak-799-0", dataLeAk799);
            }

            @Override
            public void setFile(File_POJO file) {
                super.setFile(file);
				dataLeAk798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-797-1", dataLeAk797);
				android.util.Log.d("leak-798-1", dataLeAk798);
				android.util.Log.d("leak-799-1", dataLeAk799);
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
                dataLeAk799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-797-2", dataLeAk797);
				android.util.Log.d("leak-798-2", dataLeAk798);
				android.util.Log.d("leak-799-2", dataLeAk799);
				CheckBox checkBox = itemView.findViewById(R.id.checkbox);
                checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
            }
        }

        public RecyclerViewAdapter(OnDirectoryChangeCallback directoryChangeCallback,
                                   OnExcludedPathChange excludedPathChangeCallback) {
            dataLeAk800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-800-0", dataLeAk800);
			android.util.Log.d("leak-801-0", dataLeAk801);
			android.util.Log.d("leak-802-0", dataLeAk802);
			android.util.Log.d("leak-803-0", dataLeAk803);
			android.util.Log.d("leak-804-0", dataLeAk804);
			android.util.Log.d("leak-806-0", dataLeAk806);
			android.util.Log.d("leak-807-0", dataLeAk807);
			this.directoryChangeCallback = directoryChangeCallback;
            this.excludedPathChangeCallback = excludedPathChangeCallback;
        }

        public RecyclerViewAdapter setFiles(File_POJO files) {
            dataLeAk801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-800-1", dataLeAk800);
			android.util.Log.d("leak-801-1", dataLeAk801);
			android.util.Log.d("leak-802-1", dataLeAk802);
			android.util.Log.d("leak-803-1", dataLeAk803);
			android.util.Log.d("leak-804-1", dataLeAk804);
			android.util.Log.d("leak-806-1", dataLeAk806);
			android.util.Log.d("leak-807-1", dataLeAk807);
			this.files = files;
            return this;
        }

        public File_POJO getFiles() {
            dataLeAk802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-800-2", dataLeAk800);
			android.util.Log.d("leak-801-2", dataLeAk801);
			android.util.Log.d("leak-802-2", dataLeAk802);
			android.util.Log.d("leak-803-2", dataLeAk803);
			android.util.Log.d("leak-804-2", dataLeAk804);
			android.util.Log.d("leak-806-2", dataLeAk806);
			android.util.Log.d("leak-807-2", dataLeAk807);
			return files;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            dataLeAk803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-800-3", dataLeAk800);
			android.util.Log.d("leak-801-3", dataLeAk801);
			android.util.Log.d("leak-802-3", dataLeAk802);
			android.util.Log.d("leak-803-3", dataLeAk803);
			android.util.Log.d("leak-804-3", dataLeAk804);
			android.util.Log.d("leak-806-3", dataLeAk806);
			android.util.Log.d("leak-807-3", dataLeAk807);
			View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.excluded_paths_file_cover, parent, false);
            return new FileHolder(v);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
            dataLeAk804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-800-4", dataLeAk800);
			android.util.Log.d("leak-801-4", dataLeAk801);
			android.util.Log.d("leak-802-4", dataLeAk802);
			android.util.Log.d("leak-803-4", dataLeAk803);
			android.util.Log.d("leak-804-4", dataLeAk804);
			android.util.Log.d("leak-806-4", dataLeAk806);
			android.util.Log.d("leak-807-4", dataLeAk807);
			final File_POJO file = files.getChildren().get(position);

            ((FileHolder) holder).setFile(file);
            ((FileHolder) holder).setOnCheckedChangeListener(this);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                String dataLeAk805 = "";

				@Override
                public void onClick(View view) {
                    dataLeAk805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-822-0", dataLeAk822);
					android.util.Log.d("leak-805-0", dataLeAk805);
					directoryChangeCallback.changeDir(file.getPath());
                }
            });
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            dataLeAk806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-800-5", dataLeAk800);
			android.util.Log.d("leak-801-5", dataLeAk801);
			android.util.Log.d("leak-802-5", dataLeAk802);
			android.util.Log.d("leak-803-5", dataLeAk803);
			android.util.Log.d("leak-804-5", dataLeAk804);
			android.util.Log.d("leak-806-5", dataLeAk806);
			android.util.Log.d("leak-807-5", dataLeAk807);
			String path = (String) compoundButton.getTag();
            excludedPathChangeCallback.onExcludedPathChange(path, b);
            File_POJO file = null;
            for (int i = 0; i < files.getChildren().size(); i++) {
                File_POJO f = files.getChildren().get(i);
                if (f.getPath().equals(path)) {
                    file = f;
                }
            }
            if (file != null) {
                file.excluded = b;
            }
        }

        @Override
        public int getItemCount() {
            dataLeAk807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-800-6", dataLeAk800);
			android.util.Log.d("leak-801-6", dataLeAk801);
			android.util.Log.d("leak-802-6", dataLeAk802);
			android.util.Log.d("leak-803-6", dataLeAk803);
			android.util.Log.d("leak-804-6", dataLeAk804);
			android.util.Log.d("leak-806-6", dataLeAk806);
			android.util.Log.d("leak-807-6", dataLeAk807);
			if (files != null) {
                return files.getChildren().size();
            }
            return 0;
        }
    }
}
