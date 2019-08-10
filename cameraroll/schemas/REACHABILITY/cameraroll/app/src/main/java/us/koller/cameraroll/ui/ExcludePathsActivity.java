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

    String dataLeAk1585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1585 = android.util.Log.d("leak-1585", dataLeAk1585);

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
                String dataLeAk1586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1586 = android.util.Log.d("leak-1586", dataLeAk1586);

				@Override
                public void changeDir(String path) {
                    String dataLeAk1587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1587 = android.util.Log.d("leak-1587", dataLeAk1587);
					loadDirectory(path);
                }
            };
    private OnExcludedPathChange excludedPathChangeCallback =
            new OnExcludedPathChange() {
                String dataLeAk1588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1588 = android.util.Log.d("leak-1588", dataLeAk1588);

				@Override
                public void onExcludedPathChange(String path, boolean exclude) {
                    String dataLeAk1589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1589 = android.util.Log.d("leak-1589", dataLeAk1589);
					Context context = ExcludePathsActivity.this;
                    if (exclude) {
                        String dataLeAk1590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1590 = android.util.Log.d("leak-1590", dataLeAk1590);
						Provider.addExcludedPath(context, path);
                    } else {
                        String dataLeAk1591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1591 = android.util.Log.d("leak-1591", dataLeAk1591);
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
		String dataLeAk1592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1592 = android.util.Log.d("leak-1592", dataLeAk1592);
        setContentView(R.layout.activity_excluded_paths);

        currentDir = new File_POJO("", false);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk1593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1593 = android.util.Log.d("leak-1593", dataLeAk1593);
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
            String dataLeAk1594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1594 = android.util.Log.d("leak-1594", dataLeAk1594);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1595 = android.util.Log.d("leak-1595", dataLeAk1595);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk1596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1596 = android.util.Log.d("leak-1596", dataLeAk1596);
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
            String dataLeAk1597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1597 = android.util.Log.d("leak-1597", dataLeAk1597);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1598 = android.util.Log.d("leak-1598", dataLeAk1598);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk1599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1599 = android.util.Log.d("leak-1599", dataLeAk1599);
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
            String dataLeAk1600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1600 = android.util.Log.d("leak-1600", dataLeAk1600);
			roots = savedInstanceState.getParcelable(ROOTS);
            currentDir = savedInstanceState.getParcelable(CURRENT_DIR);

            recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onPathChanged();
        } else {
            String dataLeAk1601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1601 = android.util.Log.d("leak-1601", dataLeAk1601);
			loadRoots();
        }

        Log.d("ExcludedPathsActivity", "onCreate: " + Provider.getExcludedPaths());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk1602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1602 = android.util.Log.d("leak-1602", dataLeAk1602);
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
        String dataLeAk1603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1603 = android.util.Log.d("leak-1603", dataLeAk1603);
		StorageRoot[] storageRoots = FilesProvider.getRoots(this);
        roots = new StorageRoot(STORAGE_ROOTS);
        for (int i = 0; i < storageRoots.length; i++) {
            String dataLeAk1604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1604 = android.util.Log.d("leak-1604", dataLeAk1604);
			roots.addChild(storageRoots[i]);
        }

        currentDir = roots;
        if (recyclerViewAdapter != null) {
            String dataLeAk1605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1605 = android.util.Log.d("leak-1605", dataLeAk1605);
			recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onPathChanged();
        }
    }

    public void loadDirectory(final String path) {
        String dataLeAk1606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1606 = android.util.Log.d("leak-1606", dataLeAk1606);
		final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                getString(R.string.loading), Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);

        filesProvider = new FilesProvider(this);
        final FilesProvider.Callback callback = new FilesProvider.Callback() {
            String dataLeAk1607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1607 = android.util.Log.d("leak-1607", dataLeAk1607);

			@Override
            public void onDirLoaded(final File_POJO dir) {
                String dataLeAk1608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1608 = android.util.Log.d("leak-1608", dataLeAk1608);
				runOnUiThread(new Runnable() {
                    String dataLeAk1609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1609 = android.util.Log.d("leak-1609", dataLeAk1609);

					@Override
                    public void run() {
                        String dataLeAk1610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1610 = android.util.Log.d("leak-1610", dataLeAk1610);
						filesProvider.onDestroy();
                        snackbar.dismiss();
                        if (dir == null) {
                            String dataLeAk1611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1611 = android.util.Log.d("leak-1611", dataLeAk1611);
							return;
                        }
                        File_POJO currentDir = removeFiles(dir);
                        if (currentDir == null) {
                            String dataLeAk1612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1612 = android.util.Log.d("leak-1612", dataLeAk1612);
							return;
                        }
                        ExcludePathsActivity.this.currentDir = currentDir;
                        if (recyclerViewAdapter != null) {
                            String dataLeAk1613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1613 = android.util.Log.d("leak-1613", dataLeAk1613);
							recyclerViewAdapter.setFiles(currentDir);
                            recyclerViewAdapter.notifyDataSetChanged();
                            onPathChanged();
                        }
                    }
                });
            }

            @Override
            public void timeout() {
                String dataLeAk1614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1614 = android.util.Log.d("leak-1614", dataLeAk1614);
				runOnUiThread(new Runnable() {
                    String dataLeAk1615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1615 = android.util.Log.d("leak-1615", dataLeAk1615);

					@Override
                    public void run() {
                        String dataLeAk1616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1616 = android.util.Log.d("leak-1616", dataLeAk1616);
						finish();
                    }
                });
            }

            @Override
            public void needPermission() {
                String dataLeAk1617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1617 = android.util.Log.d("leak-1617", dataLeAk1617);
				runOnUiThread(new Runnable() {
                    String dataLeAk1618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1618 = android.util.Log.d("leak-1618", dataLeAk1618);

					@Override
                    public void run() {
                        String dataLeAk1619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1619 = android.util.Log.d("leak-1619", dataLeAk1619);
						finish();
                    }
                });
            }
        };
        filesProvider.loadDir(this, path, callback);
    }

    private File_POJO removeFiles(File_POJO dir) {
        String dataLeAk1620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1620 = android.util.Log.d("leak-1620", dataLeAk1620);
		ArrayList<File_POJO> files = dir.getChildren();
        for (int i = files.size() - 1; i >= 0; i--) {
            String dataLeAk1621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1621 = android.util.Log.d("leak-1621", dataLeAk1621);
			File_POJO file = files.get(i);
            if (new File(file.getPath()).isFile()) {
                String dataLeAk1622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1622 = android.util.Log.d("leak-1622", dataLeAk1622);
				files.remove(i);
            }
        }
        if (dir.getChildren().size() == 0) {
            String dataLeAk1623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1623 = android.util.Log.d("leak-1623", dataLeAk1623);
			return null;
        }
        return dir;
    }

    public void onPathChanged() {
        String dataLeAk1624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1624 = android.util.Log.d("leak-1624", dataLeAk1624);
		TextView currentPath = findViewById(R.id.current_path);
        currentPath.setText(currentDir.getPath());
    }

    @Override
    public void onBackPressed() {
        String dataLeAk1625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1625 = android.util.Log.d("leak-1625", dataLeAk1625);
		if (currentDir != null && !currentDir.getPath().equals(STORAGE_ROOTS)) {
            String dataLeAk1626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1626 = android.util.Log.d("leak-1626", dataLeAk1626);
			if (!isCurrentFileARoot()) {
                String dataLeAk1627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1627 = android.util.Log.d("leak-1627", dataLeAk1627);
				String path = currentDir.getPath();
                int index = path.lastIndexOf("/");
                String parentPath = path.substring(0, index);

                loadDirectory(parentPath);
            } else {
                String dataLeAk1628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1628 = android.util.Log.d("leak-1628", dataLeAk1628);
				loadRoots();
            }
        } else {
            super.onBackPressed();
			String dataLeAk1629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1629 = android.util.Log.d("leak-1629", dataLeAk1629);
        }
    }

    private boolean isCurrentFileARoot() {
        String dataLeAk1630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1630 = android.util.Log.d("leak-1630", dataLeAk1630);
		if (currentDir != null) {
            String dataLeAk1631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1631 = android.util.Log.d("leak-1631", dataLeAk1631);
			if (currentDir.getPath().equals(STORAGE_ROOTS)) {
                String dataLeAk1632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1632 = android.util.Log.d("leak-1632", dataLeAk1632);
				return true;
            }

            for (int i = 0; i < roots.getChildren().size(); i++) {
                String dataLeAk1633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1633 = android.util.Log.d("leak-1633", dataLeAk1633);
				if (currentDir.getPath().equals(roots.getChildren().get(i).getPath())) {
                    String dataLeAk1634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1634 = android.util.Log.d("leak-1634", dataLeAk1634);
					return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk1635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1635 = android.util.Log.d("leak-1635", dataLeAk1635);
        outState.putParcelable(ROOTS, roots);
        if (currentDir != null) {
            String dataLeAk1636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1636 = android.util.Log.d("leak-1636", dataLeAk1636);
			outState.putParcelable(CURRENT_DIR, currentDir);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1637 = android.util.Log.d("leak-1637", dataLeAk1637);

        Provider.saveExcludedPaths(this);

        if (filesProvider != null) {
            String dataLeAk1638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1638 = android.util.Log.d("leak-1638", dataLeAk1638);
			filesProvider.onDestroy();
        }
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk1639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1639 = android.util.Log.d("leak-1639", dataLeAk1639);
		return R.style.CameraRoll_Theme_ExcludePaths;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1640 = android.util.Log.d("leak-1640", dataLeAk1640);
		return R.style.CameraRoll_Theme_Light_ExcludePaths;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk1641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1641 = android.util.Log.d("leak-1641", dataLeAk1641);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk1642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1642 = android.util.Log.d("leak-1642", dataLeAk1642);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1643 = android.util.Log.d("leak-1643", dataLeAk1643);
			int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }

    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter
            implements CompoundButton.OnCheckedChangeListener {

        String dataLeAk1644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1644 = android.util.Log.d("leak-1644", dataLeAk1644);

		private File_POJO files;

        private OnDirectoryChangeCallback directoryChangeCallback;
        private OnExcludedPathChange excludedPathChangeCallback;

        private static class FileHolder extends
                us.koller.cameraroll.adapter.fileExplorer.viewHolder.FileHolder {

            String dataLeAk1645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1645 = android.util.Log.d("leak-1645", dataLeAk1645);

			FileHolder(View itemView) {
                super(itemView);
				String dataLeAk1646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1646 = android.util.Log.d("leak-1646", dataLeAk1646);
            }

            @Override
            public void setFile(File_POJO file) {
                super.setFile(file);
				String dataLeAk1647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1647 = android.util.Log.d("leak-1647", dataLeAk1647);
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
                String dataLeAk1648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1648 = android.util.Log.d("leak-1648", dataLeAk1648);
				CheckBox checkBox = itemView.findViewById(R.id.checkbox);
                checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
            }
        }

        public RecyclerViewAdapter(OnDirectoryChangeCallback directoryChangeCallback,
                                   OnExcludedPathChange excludedPathChangeCallback) {
            String dataLeAk1649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1649 = android.util.Log.d("leak-1649", dataLeAk1649);
			this.directoryChangeCallback = directoryChangeCallback;
            this.excludedPathChangeCallback = excludedPathChangeCallback;
        }

        public RecyclerViewAdapter setFiles(File_POJO files) {
            String dataLeAk1650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1650 = android.util.Log.d("leak-1650", dataLeAk1650);
			this.files = files;
            return this;
        }

        public File_POJO getFiles() {
            String dataLeAk1651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1651 = android.util.Log.d("leak-1651", dataLeAk1651);
			return files;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            String dataLeAk1652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1652 = android.util.Log.d("leak-1652", dataLeAk1652);
			View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.excluded_paths_file_cover, parent, false);
            return new FileHolder(v);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
            String dataLeAk1653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1653 = android.util.Log.d("leak-1653", dataLeAk1653);
			final File_POJO file = files.getChildren().get(position);

            ((FileHolder) holder).setFile(file);
            ((FileHolder) holder).setOnCheckedChangeListener(this);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                String dataLeAk1654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1654 = android.util.Log.d("leak-1654", dataLeAk1654);

				@Override
                public void onClick(View view) {
                    String dataLeAk1655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1655 = android.util.Log.d("leak-1655", dataLeAk1655);
					directoryChangeCallback.changeDir(file.getPath());
                }
            });
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            String dataLeAk1656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1656 = android.util.Log.d("leak-1656", dataLeAk1656);
			String path = (String) compoundButton.getTag();
            excludedPathChangeCallback.onExcludedPathChange(path, b);
            File_POJO file = null;
            for (int i = 0; i < files.getChildren().size(); i++) {
                String dataLeAk1657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1657 = android.util.Log.d("leak-1657", dataLeAk1657);
				File_POJO f = files.getChildren().get(i);
                if (f.getPath().equals(path)) {
                    String dataLeAk1658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1658 = android.util.Log.d("leak-1658", dataLeAk1658);
					file = f;
                }
            }
            if (file != null) {
                String dataLeAk1659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1659 = android.util.Log.d("leak-1659", dataLeAk1659);
				file.excluded = b;
            }
        }

        @Override
        public int getItemCount() {
            String dataLeAk1660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1660 = android.util.Log.d("leak-1660", dataLeAk1660);
			if (files != null) {
                String dataLeAk1661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1661 = android.util.Log.d("leak-1661", dataLeAk1661);
				return files.getChildren().size();
            }
            return 0;
        }
    }
}
