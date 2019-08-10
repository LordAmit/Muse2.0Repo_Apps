package us.koller.cameraroll.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.VirtualAlbum;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.adapter.fileExplorer.RecyclerViewAdapter;
import us.koller.cameraroll.data.fileOperations.Copy;
import us.koller.cameraroll.data.fileOperations.Delete;
import us.koller.cameraroll.data.fileOperations.FileOperation;
import us.koller.cameraroll.data.fileOperations.Move;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.provider.FilesProvider;
import us.koller.cameraroll.data.provider.Provider;
import us.koller.cameraroll.data.models.StorageRoot;
import us.koller.cameraroll.ui.widget.SwipeBackCoordinatorLayout;
import us.koller.cameraroll.util.animators.ColorFade;
import us.koller.cameraroll.util.Util;

public class FileExplorerActivity extends ThemeableActivity
        implements SwipeBackCoordinatorLayout.OnSwipeListener, RecyclerViewAdapter.Callback {

    String dataLeAk1662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1662 = android.util.Log.d("leak-1662", dataLeAk1662);

	public static final String ROOTS = "ROOTS";
    public static final String CURRENT_DIR = "CURRENT_DIR";
    public static final String MODE = "MODE";
    public static final String SELECTED_ITEMS = "SELECTED_ITEMS";
    public static final String STORAGE_ROOTS = "Storage Roots";
    public static final String FILE_OPERATION = "FILE_OPERATION";

    private File_POJO roots;

    private File_POJO currentDir;

    private FilesProvider filesProvider;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    private Menu menu;

    private Intent fileOpIntent;

    public interface OnDirectoryChangeCallback {
        void changeDir(String path);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk1663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1663 = android.util.Log.d("leak-1663", dataLeAk1663);
        setContentView(R.layout.activity_file_explorer);

        currentDir = new File_POJO("", false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1664 = android.util.Log.d("leak-1664", dataLeAk1664);
			getWindow().setEnterTransition(new TransitionSet()
                    .setOrdering(TransitionSet.ORDERING_TOGETHER)
                    .addTransition(new Slide(Gravity.BOTTOM))
                    .addTransition(new Fade())
                    .setInterpolator(new AccelerateDecelerateInterpolator()));
            getWindow().setReturnTransition(new TransitionSet()
                    .setOrdering(TransitionSet.ORDERING_TOGETHER)
                    .addTransition(new Slide(Gravity.BOTTOM))
                    .addTransition(new Fade())
                    .setInterpolator(new AccelerateDecelerateInterpolator()));
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1665 = android.util.Log.d("leak-1665", dataLeAk1665);
			AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                    ContextCompat.getDrawable(FileExplorerActivity.this, R.drawable.back_to_cancel_avd);
            //mutating avd to reset it
            drawable.mutate();
            toolbar.setNavigationIcon(drawable);
        } else {
            String dataLeAk1666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1666 = android.util.Log.d("leak-1666", dataLeAk1666);
			toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        }
        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon != null) {
            String dataLeAk1667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1667 = android.util.Log.d("leak-1667", dataLeAk1667);
			navIcon = DrawableCompat.wrap(navIcon);
            DrawableCompat.setTint(navIcon.mutate(), textColorSecondary);
            toolbar.setNavigationIcon(navIcon);
        }

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk1668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1668 = android.util.Log.d("leak-1668", dataLeAk1668);
			actionBar.setTitle(getString(R.string.file_explorer));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Util.colorToolbarOverflowMenuIcon(toolbar, textColorSecondary);

        //need to be called after setTitle(), to ensure, that mTitleTextView exists
        final TextView titleTextView = Util.setToolbarTypeface(toolbar
        );
        if (titleTextView != null) {
            String dataLeAk1669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1669 = android.util.Log.d("leak-1669", dataLeAk1669);
			titleTextView.setEllipsize(TextUtils.TruncateAt.START);
        }

        final ViewGroup rootView = findViewById(R.id.swipeBackView);
        if (rootView instanceof SwipeBackCoordinatorLayout) {
            String dataLeAk1670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1670 = android.util.Log.d("leak-1670", dataLeAk1670);
			((SwipeBackCoordinatorLayout) rootView).setOnSwipeListener(this);
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(
                new OnDirectoryChangeCallback() {
                    String dataLeAk1671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1671 = android.util.Log.d("leak-1671", dataLeAk1671);

					@Override
                    public void changeDir(String path) {
                        String dataLeAk1672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1672 = android.util.Log.d("leak-1672", dataLeAk1672);
						loadDirectory(path);
                    }
                }, this);
        if (savedInstanceState != null && savedInstanceState.containsKey(CURRENT_DIR)) {
            String dataLeAk1673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1673 = android.util.Log.d("leak-1673", dataLeAk1673);
			recyclerViewAdapter.setFiles(currentDir);
        }
        recyclerViewAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(recyclerViewAdapter);

        //setup fab
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_create_new_folder_white_24dp);
        Drawable d = fab.getDrawable();
        d = DrawableCompat.wrap(d);
        DrawableCompat.setTint(d.mutate(), accentTextColor);
        fab.setImageDrawable(d);
        fab.setScaleX(0.0f);
        fab.setScaleY(0.0f);

        //setting window insets manually
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk1674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1674 = android.util.Log.d("leak-1674", dataLeAk1674);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1675 = android.util.Log.d("leak-1675", dataLeAk1675);

				@RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                @Override
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk1676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1676 = android.util.Log.d("leak-1676", dataLeAk1676);
					toolbar.setPadding(toolbar.getPaddingStart() /*+ insets.getSystemWindowInsetLeft()*/,
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd() /*+ insets.getSystemWindowInsetRight()*/,
                            toolbar.getPaddingBottom());

                    ViewGroup.MarginLayoutParams toolbarParams
                            = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
                    toolbarParams.leftMargin += insets.getSystemWindowInsetLeft();
                    toolbarParams.rightMargin += insets.getSystemWindowInsetRight();
                    toolbar.setLayoutParams(toolbarParams);

                    recyclerView.setPadding(recyclerView.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            recyclerView.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            recyclerView.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            recyclerView.getPaddingBottom() + insets.getSystemWindowInsetBottom());

                    fab.setTranslationY(-insets.getSystemWindowInsetBottom());
                    fab.setTranslationX(-insets.getSystemWindowInsetRight());

                    // clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);
                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            String dataLeAk1677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1677 = android.util.Log.d("leak-1677", dataLeAk1677);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1678 = android.util.Log.d("leak-1678", dataLeAk1678);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk1679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1679 = android.util.Log.d("leak-1679", dataLeAk1679);
									// hacky way of getting window insets on pre-Lollipop
                                    // somewhat works...
                                    int[] screenSize = Util.getScreenSize(FileExplorerActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - rootView.getLeft()),
                                            Math.abs(screenSize[1] - rootView.getTop()),
                                            Math.abs(screenSize[2] - rootView.getRight()),
                                            Math.abs(screenSize[3] - rootView.getBottom())};

                                    toolbar.setPadding(toolbar.getPaddingStart(),
                                            toolbar.getPaddingTop() + windowInsets[1],
                                            toolbar.getPaddingEnd(),
                                            toolbar.getPaddingBottom());

                                    ViewGroup.MarginLayoutParams toolbarParams
                                            = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
                                    toolbarParams.leftMargin += windowInsets[0];
                                    toolbarParams.rightMargin += windowInsets[2];
                                    toolbar.setLayoutParams(toolbarParams);

                                    recyclerView.setPadding(recyclerView.getPaddingStart() + windowInsets[0],
                                            recyclerView.getPaddingTop() + windowInsets[1],
                                            recyclerView.getPaddingEnd() + windowInsets[2],
                                            recyclerView.getPaddingBottom() + windowInsets[3]);

                                    fab.setTranslationY(-windowInsets[2]);
                                    fab.setTranslationX(-windowInsets[3]);

                                    rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                }
                            });
        }

        //needed to achieve transparent navBar
        setSystemUiFlags();

        //load files
        if (savedInstanceState != null
                && savedInstanceState.containsKey(CURRENT_DIR)
                && savedInstanceState.containsKey(ROOTS)) {
            String dataLeAk1680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1680 = android.util.Log.d("leak-1680", dataLeAk1680);
			roots = savedInstanceState.getParcelable(ROOTS);
            currentDir = savedInstanceState.getParcelable(CURRENT_DIR);

            recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onDataChanged();

            if (savedInstanceState.containsKey(MODE)) {
                String dataLeAk1681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1681 = android.util.Log.d("leak-1681", dataLeAk1681);
				int mode = savedInstanceState.getInt(MODE);

                if (mode == RecyclerViewAdapter.SELECTOR_MODE) {
                    String dataLeAk1682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1682 = android.util.Log.d("leak-1682", dataLeAk1682);
					if (savedInstanceState.containsKey(SELECTED_ITEMS)) {
                        String dataLeAk1683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1683 = android.util.Log.d("leak-1683", dataLeAk1683);
						final File_POJO[] selectedItems
                                = (File_POJO[]) savedInstanceState.getParcelableArray(SELECTED_ITEMS);
                        if (selectedItems != null) {
                            String dataLeAk1684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1684 = android.util.Log.d("leak-1684", dataLeAk1684);
							rootView.getViewTreeObserver().addOnGlobalLayoutListener(
                                    new ViewTreeObserver.OnGlobalLayoutListener() {
                                        String dataLeAk1685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1685 = android.util.Log.d("leak-1685", dataLeAk1685);

										@Override
                                        public void onGlobalLayout() {
                                            String dataLeAk1686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk1686 = android.util.Log.d("leak-1686", dataLeAk1686);
											rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                            recyclerViewAdapter.enterSelectorMode(selectedItems);
                                        }
                                    });

                        }
                    }
                } else if (mode == RecyclerViewAdapter.PICK_TARGET_MODE
                        && savedInstanceState.containsKey(FILE_OPERATION)) {
                    String dataLeAk1687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1687 = android.util.Log.d("leak-1687", dataLeAk1687);
					onSelectorModeEnter();
                    //fileOp = savedInstanceState.getParcelable(FILE_OPERATION);
                        /*FileOperation.operation = fileOp != null ?
                                fileOp.getType() : FileOperation.EMPTY;*/
                    //need to call pick target after onSelectorModeEnter animation are done
                    new Handler().postDelayed(new Runnable() {
                        String dataLeAk1688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1688 = android.util.Log.d("leak-1688", dataLeAk1688);

						@Override
                        public void run() {
                            String dataLeAk1689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1689 = android.util.Log.d("leak-1689", dataLeAk1689);
							recyclerViewAdapter.pickTarget();
                        }
                    }, (int) (500 * Util.getAnimatorSpeed(this)));
                }
            }

        } else {
            String dataLeAk1690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1690 = android.util.Log.d("leak-1690", dataLeAk1690);
			loadRoots();

            //show warning dialog
            /*new AlertDialog.Builder(this, getDialogThemeRes())
                    .setTitle(R.string.warning)
                    .setMessage(Html.fromHtml(getString(R.string.file_explorer_warning_message)))
                    .setPositiveButton(R.string.ok, null)
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .show();*/
        }
    }

    public void loadRoots() {
        String dataLeAk1691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1691 = android.util.Log.d("leak-1691", dataLeAk1691);
		StorageRoot[] storageRoots = FilesProvider.getRoots(this);
        roots = new StorageRoot(STORAGE_ROOTS);
        for (int i = 0; i < storageRoots.length; i++) {
            String dataLeAk1692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1692 = android.util.Log.d("leak-1692", dataLeAk1692);
			roots.addChild(storageRoots[i]);
        }

        FileExplorerActivity.this.currentDir = roots;
        if (recyclerViewAdapter != null) {
            String dataLeAk1693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1693 = android.util.Log.d("leak-1693", dataLeAk1693);
			recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onDataChanged();
        }
    }

    public void loadDirectory(final String path) {
        String dataLeAk1694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1694 = android.util.Log.d("leak-1694", dataLeAk1694);
		Log.d("FileExplorerActivity", "loadDirectory(): " + path);
        final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                getString(R.string.loading), Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);

        final FilesProvider.Callback callback = new FilesProvider.Callback() {
            String dataLeAk1695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1695 = android.util.Log.d("leak-1695", dataLeAk1695);

			@Override
            public void onDirLoaded(final File_POJO dir) {
                String dataLeAk1696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1696 = android.util.Log.d("leak-1696", dataLeAk1696);
				runOnUiThread(new Runnable() {
                    String dataLeAk1697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1697 = android.util.Log.d("leak-1697", dataLeAk1697);

					@Override
                    public void run() {
                        String dataLeAk1698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1698 = android.util.Log.d("leak-1698", dataLeAk1698);
						filesProvider.onDestroy();
                        filesProvider = null;

                        if (dir != null) {
                            String dataLeAk1699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1699 = android.util.Log.d("leak-1699", dataLeAk1699);
							FileExplorerActivity.this.currentDir = dir;
                            if (recyclerViewAdapter != null) {
                                String dataLeAk1700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1700 = android.util.Log.d("leak-1700", dataLeAk1700);
								recyclerViewAdapter.setFiles(currentDir);
                                recyclerViewAdapter.notifyDataSetChanged();
                                onDataChanged();
                            }
                        }

                        snackbar.dismiss();
                    }
                });
            }

            @Override
            public void timeout() {
                String dataLeAk1701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1701 = android.util.Log.d("leak-1701", dataLeAk1701);
				runOnUiThread(new Runnable() {
                    String dataLeAk1702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1702 = android.util.Log.d("leak-1702", dataLeAk1702);

					@Override
                    public void run() {
                        String dataLeAk1703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1703 = android.util.Log.d("leak-1703", dataLeAk1703);
						snackbar.dismiss();

                        final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                                R.string.loading_failed, Snackbar.LENGTH_INDEFINITE);
                        snackbar.setAction(getString(R.string.retry), new View.OnClickListener() {
                            String dataLeAk1704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1704 = android.util.Log.d("leak-1704", dataLeAk1704);

							@Override
                            public void onClick(View view) {
                                String dataLeAk1705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1705 = android.util.Log.d("leak-1705", dataLeAk1705);
								loadDirectory(path);
                            }
                        });
                        Util.showSnackbar(snackbar);
                    }
                });
            }

            @Override
            public void needPermission() {
                String dataLeAk1706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1706 = android.util.Log.d("leak-1706", dataLeAk1706);
				runOnUiThread(new Runnable() {
                    String dataLeAk1707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1707 = android.util.Log.d("leak-1707", dataLeAk1707);

					@Override
                    public void run() {
                        String dataLeAk1708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1708 = android.util.Log.d("leak-1708", dataLeAk1708);
						snackbar.dismiss();
                    }
                });
            }
        };

        filesProvider = new FilesProvider(this);
        filesProvider.loadDir(this, path, callback);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk1709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1709 = android.util.Log.d("leak-1709", dataLeAk1709);
        outState.putParcelable(ROOTS, roots);
        if (currentDir != null) {
            String dataLeAk1710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1710 = android.util.Log.d("leak-1710", dataLeAk1710);
			outState.putParcelable(CURRENT_DIR, currentDir);
        }

        outState.putInt(MODE, recyclerViewAdapter.getMode());

        File_POJO[] selectedItems = recyclerViewAdapter.getSelectedItems();
        if (selectedItems.length > 0) {
            String dataLeAk1711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1711 = android.util.Log.d("leak-1711", dataLeAk1711);
			outState.putParcelableArray(SELECTED_ITEMS, selectedItems);
        }

        /*if (fileOp != null) {
            outState.putParcelable(FILE_OPERATION, fileOp);
            File_POJO[] files = FileOperation.getFiles(fileOpIntent);
            outState.putParcelableArray(SELECTED_ITEMS, files);
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String dataLeAk1712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1712 = android.util.Log.d("leak-1712", dataLeAk1712);
		getMenuInflater().inflate(R.menu.file_explorer, menu);
        this.menu = menu;
        //hide menu items; items are made visible, when a folder gets selected
        manageMenuItems();

        Drawable icon = menu.findItem(R.id.paste).getIcon().mutate();
        icon = DrawableCompat.wrap(icon);
        DrawableCompat.setTint(icon.mutate(), accentTextColor);
        menu.findItem(R.id.paste).setIcon(icon);

        return super.onCreateOptionsMenu(menu);
    }

    public void manageMenuItems() {
        String dataLeAk1713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1713 = android.util.Log.d("leak-1713", dataLeAk1713);
		if (menu != null) {
            String dataLeAk1714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1714 = android.util.Log.d("leak-1714", dataLeAk1714);
			for (int i = 0; i < menu.size(); i++) {
                String dataLeAk1715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1715 = android.util.Log.d("leak-1715", dataLeAk1715);
				MenuItem item = menu.getItem(i);
                switch (item.getItemId()) {
                    case R.id.exclude:
                        if (currentDir != null) {
                            String dataLeAk1716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1716 = android.util.Log.d("leak-1716", dataLeAk1716);
							item.setVisible(!currentDir.getPath().equals(STORAGE_ROOTS));
                            if (Provider.isPathPermanentlyExcluded(currentDir.getPath())) {
                                String dataLeAk1717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1717 = android.util.Log.d("leak-1717", dataLeAk1717);
								item.setChecked(true);
                                item.setEnabled(false);
                            } else {
                                String dataLeAk1718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1718 = android.util.Log.d("leak-1718", dataLeAk1718);
								item.setChecked(currentDir.excluded);
                                item.setEnabled(!currentDir.getPath().equals(STORAGE_ROOTS)
                                        && !Provider.isDirExcludedBecauseParentDirIsExcluded(
                                        currentDir.getPath(), Provider.getExcludedPaths()));
                            }
                        } else {
                            String dataLeAk1719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1719 = android.util.Log.d("leak-1719", dataLeAk1719);
							item.setVisible(true);
                            item.setChecked(false);
                            item.setEnabled(false);
                        }
                        break;
                    case R.id.scan:
                        item.setVisible(!currentDir.getPath().equals(STORAGE_ROOTS));
                        break;
                    case R.id.add_to_virtual_album:
                        item.setVisible(!currentDir.getPath().equals(STORAGE_ROOTS));
                        break;
                    default:
                        item.setVisible(false);
                        break;
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk1720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1720 = android.util.Log.d("leak-1720", dataLeAk1720);
		switch (item.getItemId()) {
            case android.R.id.home:
                if (recyclerViewAdapter.isModeActive()
                        || recyclerViewAdapter.getMode()
                        == RecyclerViewAdapter.PICK_TARGET_MODE) {
                    String dataLeAk1721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1721 = android.util.Log.d("leak-1721", dataLeAk1721);
					recyclerViewAdapter.cancelMode();
                } else {
                    String dataLeAk1722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1722 = android.util.Log.d("leak-1722", dataLeAk1722);
					onBackPressed();
                }
                break;
            case R.id.exclude:
                currentDir.excluded = !currentDir.excluded;
                item.setChecked(currentDir.excluded);
                if (currentDir.excluded) {
                    String dataLeAk1723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1723 = android.util.Log.d("leak-1723", dataLeAk1723);
					FilesProvider.addExcludedPath(this, currentDir.getPath());
                } else {
                    String dataLeAk1724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1724 = android.util.Log.d("leak-1724", dataLeAk1724);
					FilesProvider.removeExcludedPath(this, currentDir.getPath());
                }
                break;
            case R.id.scan:
                ArrayList<String> paths = FileOperation.Util
                        .getAllChildPaths(new ArrayList<String>(), currentDir.getPath());
                String[] pathsArray = new String[paths.size()];
                paths.toArray(pathsArray);
                FileOperation.Util.scanPathsWithNotification(this, pathsArray);
                break;
            case R.id.add_to_virtual_album:
                String path = currentDir.getPath();
                AlertDialog dialog = VirtualAlbum.Util.getAddToVirtualAlbumDialog(this, path);
                dialog.show();
                break;
            case R.id.paste:
                if (!currentDir.getPath().equals(STORAGE_ROOTS)) {
                    String dataLeAk1725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1725 = android.util.Log.d("leak-1725", dataLeAk1725);
					recyclerViewAdapter.cancelMode();
                    if (fileOpIntent != null) {
                        String dataLeAk1726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1726 = android.util.Log.d("leak-1726", dataLeAk1726);
						File_POJO target = recyclerViewAdapter.getFiles();
                        fileOpIntent.putExtra(FileOperation.TARGET, target);
                        startService(fileOpIntent);
                        fileOpIntent = null;
                    }
                } else {
                    String dataLeAk1727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1727 = android.util.Log.d("leak-1727", dataLeAk1727);
					Toast.makeText(this, R.string.paste_error, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.copy:
                fileOpIntent = new Intent(this, Copy.class)
                        .setAction(FileOperation.Util.getActionString(this, FileOperation.COPY));
                recyclerViewAdapter.cancelMode();
                break;
            case R.id.move:
                fileOpIntent = new Intent(this, Move.class)
                        .setAction(FileOperation.Util.getActionString(this, FileOperation.MOVE));
                recyclerViewAdapter.cancelMode();
                break;
            case R.id.delete:
                fileOpIntent = new Intent(this, Delete.class)
                        .setAction(FileOperation.Util.getActionString(this, FileOperation.DELETE));
                recyclerViewAdapter.cancelMode();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void fabClicked(View v) {
        String dataLeAk1728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1728 = android.util.Log.d("leak-1728", dataLeAk1728);
		animateFab(false);

        View dialogLayout = LayoutInflater.from(this).inflate(R.layout.input_dialog_layout,
                (ViewGroup) findViewById(R.id.root_view), false);

        final EditText editText = dialogLayout.findViewById(R.id.edit_text);

        AlertDialog dialog = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(R.string.new_folder)
                .setView(dialogLayout)
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    String dataLeAk1729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1729 = android.util.Log.d("leak-1729", dataLeAk1729);

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dataLeAk1730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1730 = android.util.Log.d("leak-1730", dataLeAk1730);
						String filename = editText.getText().toString();
                        File_POJO newFolder = new File_POJO(currentDir.getPath()
                                + "/" + filename, false);

                        File_POJO[] files = new File_POJO[]{newFolder};

                        Intent intent = FileOperation.getDefaultIntent(
                                FileExplorerActivity.this,
                                FileOperation.NEW_DIR,
                                files);
                        startService(intent);
                    }
                })
                .setNegativeButton(getString(R.string.cancel), null)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    String dataLeAk1731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1731 = android.util.Log.d("leak-1731", dataLeAk1731);

					@Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        String dataLeAk1732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1732 = android.util.Log.d("leak-1732", dataLeAk1732);
						animateFab(true);
                    }
                })
                .create();
        //noinspection ConstantConditions
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        dialog.show();
    }

    public void animateFab(final boolean show) {
        String dataLeAk1733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1733 = android.util.Log.d("leak-1733", dataLeAk1733);
		final FloatingActionButton fab = findViewById(R.id.fab);

        if ((fab.getScaleX() == 1.0f && show)
                || (fab.getScaleX() == 0.0f && !show)) {
            String dataLeAk1734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1734 = android.util.Log.d("leak-1734", dataLeAk1734);
			return;
        }

        if (show) {
            String dataLeAk1735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1735 = android.util.Log.d("leak-1735", dataLeAk1735);
			fab.setOnClickListener(new View.OnClickListener() {
                String dataLeAk1736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1736 = android.util.Log.d("leak-1736", dataLeAk1736);

				@Override
                public void onClick(View view) {
                    String dataLeAk1737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1737 = android.util.Log.d("leak-1737", dataLeAk1737);
					fabClicked(view);
                }
            });
        } else {
            String dataLeAk1738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1738 = android.util.Log.d("leak-1738", dataLeAk1738);
			fab.setOnClickListener(null);
        }

        fab.animate()
                .scaleX(show ? 1.0f : 0.0f)
                .scaleY(show ? 1.0f : 0.0f)
                .alpha(show ? 1.0f : 0.0f)
                .setDuration(250)
                .start();
    }

    @Override
    public void onBackPressed() {
        String dataLeAk1739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1739 = android.util.Log.d("leak-1739", dataLeAk1739);
		if (recyclerViewAdapter.isModeActive()) {
            String dataLeAk1740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1740 = android.util.Log.d("leak-1740", dataLeAk1740);
			recyclerViewAdapter.cancelMode();
        } else if (currentDir != null && !currentDir.getPath().equals(STORAGE_ROOTS)) {
            String dataLeAk1741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1741 = android.util.Log.d("leak-1741", dataLeAk1741);
			if (!isCurrentFileARoot()) {
                String dataLeAk1742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1742 = android.util.Log.d("leak-1742", dataLeAk1742);
				String path = currentDir.getPath();
                int index = path.lastIndexOf("/");
                String parentPath = path.substring(0, index);

                loadDirectory(parentPath);
            } else {
                String dataLeAk1743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1743 = android.util.Log.d("leak-1743", dataLeAk1743);
				loadRoots();
            }
        } else {
            //setResult(RESULT_OK, new Intent(MainActivity.REFRESH_MEDIA));
            super.onBackPressed();
			String dataLeAk1744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1744 = android.util.Log.d("leak-1744", dataLeAk1744);
        }
    }

    private boolean isCurrentFileARoot() {
        String dataLeAk1745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1745 = android.util.Log.d("leak-1745", dataLeAk1745);
		if (currentDir != null) {
            String dataLeAk1746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1746 = android.util.Log.d("leak-1746", dataLeAk1746);
			if (currentDir.getPath().equals(STORAGE_ROOTS)) {
                String dataLeAk1747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1747 = android.util.Log.d("leak-1747", dataLeAk1747);
				return true;
            }

            for (int i = 0; i < roots.getChildren().size(); i++) {
                String dataLeAk1748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1748 = android.util.Log.d("leak-1748", dataLeAk1748);
				if (currentDir.getPath().equals(roots.getChildren().get(i).getPath())) {
                    String dataLeAk1749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1749 = android.util.Log.d("leak-1749", dataLeAk1749);
					return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1750 = android.util.Log.d("leak-1750", dataLeAk1750);

        Provider.saveExcludedPaths(this);

        if (filesProvider != null) {
            String dataLeAk1751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1751 = android.util.Log.d("leak-1751", dataLeAk1751);
			filesProvider.onDestroy();
        }
    }

    @Override
    public boolean canSwipeBack(int dir) {
        String dataLeAk1752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1752 = android.util.Log.d("leak-1752", dataLeAk1752);
		return SwipeBackCoordinatorLayout.canSwipeBackForThisView(recyclerView, dir);
    }

    @Override
    public void onSwipeProcess(float percent) {
        String dataLeAk1753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1753 = android.util.Log.d("leak-1753", dataLeAk1753);
		getWindow().getDecorView().setBackgroundColor(
                SwipeBackCoordinatorLayout.getBackgroundColor(percent));
        boolean selectorModeActive = ((RecyclerViewAdapter) recyclerView.getAdapter()).isModeActive();
        if (!theme.darkStatusBarIcons() && selectorModeActive) {
            String dataLeAk1754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1754 = android.util.Log.d("leak-1754", dataLeAk1754);
			SwipeBackCoordinatorLayout layout = findViewById(R.id.swipeBackView);
            Toolbar toolbar = findViewById(R.id.toolbar);
            View rootView = findViewById(R.id.root_view);
            int translationY = (int) layout.getTranslationY();
            int statusBarHeight = toolbar.getPaddingTop();
            if (translationY > statusBarHeight * 0.5) {
                String dataLeAk1755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1755 = android.util.Log.d("leak-1755", dataLeAk1755);
				Util.setLightStatusBarIcons(rootView);
            } else {
                String dataLeAk1756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1756 = android.util.Log.d("leak-1756", dataLeAk1756);
				Util.setDarkStatusBarIcons(rootView);
            }
        }
    }

    @Override
    public void onSwipeFinish(int dir) {
        String dataLeAk1757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1757 = android.util.Log.d("leak-1757", dataLeAk1757);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1758 = android.util.Log.d("leak-1758", dataLeAk1758);
			getWindow().setReturnTransition(new TransitionSet()
                    .setOrdering(TransitionSet.ORDERING_TOGETHER)
                    .addTransition(new Slide(dir > 0 ? Gravity.TOP : Gravity.BOTTOM))
                    .addTransition(new Fade())
                    .setInterpolator(new AccelerateDecelerateInterpolator()));
        }
        this.finish();
    }

    @Override
    public void onSelectorModeEnter() {
        String dataLeAk1759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1759 = android.util.Log.d("leak-1759", dataLeAk1759);
		fileOpIntent = null;

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(true);
        toolbar.animate().translationY(0.0f).start();

        if (theme.darkStatusBarIconsInSelectorMode()) {
            String dataLeAk1760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1760 = android.util.Log.d("leak-1760", dataLeAk1760);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk1761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1761 = android.util.Log.d("leak-1761", dataLeAk1761);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            String dataLeAk1762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1762 = android.util.Log.d("leak-1762", dataLeAk1762);
			ColorFade.fadeDrawableAlpha(statusBarOverlay, 0);
        }

        ColorFade.fadeBackgroundColor(toolbar, toolbarColor, accentColor);

        ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor, null);

        //fade overflow menu icon
        ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(),
                textColorSecondary, accentTextColor);

        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon instanceof Animatable) {
            String dataLeAk1763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1763 = android.util.Log.d("leak-1763", dataLeAk1763);
			((Animatable) navIcon).start();
            ColorFade.fadeDrawableColor(navIcon,
                    textColorSecondary, accentTextColor);
        }
        new Handler().postDelayed(new Runnable() {
            String dataLeAk1764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1764 = android.util.Log.d("leak-1764", dataLeAk1764);

			@Override
            public void run() {
                String dataLeAk1765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1765 = android.util.Log.d("leak-1765", dataLeAk1765);
				Drawable d;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String dataLeAk1766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1766 = android.util.Log.d("leak-1766", dataLeAk1766);
					AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                            ContextCompat.getDrawable(FileExplorerActivity.this,
                                    R.drawable.cancel_to_back_avd);
                    //mutating avd to reset it
                    drawable.mutate();
                    d = drawable;
                } else {
                    String dataLeAk1767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1767 = android.util.Log.d("leak-1767", dataLeAk1767);
					d = ContextCompat.getDrawable(FileExplorerActivity.this,
                            R.drawable.ic_clear_black_24dp);
                }
                d = DrawableCompat.wrap(d);
                DrawableCompat.setTint(d.mutate(), accentTextColor);
                toolbar.setNavigationIcon(d);

                //make menu items visible
                for (int i = 0; i < menu.size(); i++) {
                    String dataLeAk1768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1768 = android.util.Log.d("leak-1768", dataLeAk1768);
					MenuItem item = menu.getItem(i);
                    switch (item.getItemId()) {
                        case R.id.copy:
                        case R.id.move:
                        case R.id.delete:
                            item.setVisible(true);
                            break;
                        default:
                            item.setVisible(false);
                            break;
                    }
                }
            }
        }, navIcon instanceof Animatable ? (int) (500 * Util.getAnimatorSpeed(this)) : 0);
    }

    @Override
    public void onSelectorModeExit(final File_POJO[] selected_items) {
        String dataLeAk1769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1769 = android.util.Log.d("leak-1769", dataLeAk1769);
		if (fileOpIntent != null) {
            String dataLeAk1770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1770 = android.util.Log.d("leak-1770", dataLeAk1770);
			fileOpIntent.putExtra(FileOperation.FILES, selected_items);
            switch (FileOperation.Util.getActionInt(this, fileOpIntent.getAction())) {
                case FileOperation.DELETE:
                    resetToolbar();

                    String title;
                    int count = selected_items.length;
                    if (count == 1) {
                        String dataLeAk1771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1771 = android.util.Log.d("leak-1771", dataLeAk1771);
						title = getString(R.string.delete_file, count);
                    } else {
                        String dataLeAk1772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1772 = android.util.Log.d("leak-1772", dataLeAk1772);
						title = getString(R.string.delete_files, count);
                    }

                    new AlertDialog.Builder(this, theme.getDialogThemeRes())
                            .setTitle(title)
                            .setNegativeButton(getString(R.string.no), null)
                            .setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                                String dataLeAk1773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1773 = android.util.Log.d("leak-1773", dataLeAk1773);

								@Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String dataLeAk1774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1774 = android.util.Log.d("leak-1774", dataLeAk1774);
									startService(fileOpIntent);
                                    fileOpIntent = null;
                                }
                            })
                            .create().show();
                    break;
                case FileOperation.COPY:
                case FileOperation.MOVE:
                    recyclerViewAdapter.pickTarget();
                    break;
                default:
                    break;
            }
        }

        if (fileOpIntent == null) {
            String dataLeAk1775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1775 = android.util.Log.d("leak-1775", dataLeAk1775);
			resetToolbar();
        }
    }

    @Override
    public void onItemSelected(int count) {
        String dataLeAk1776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1776 = android.util.Log.d("leak-1776", dataLeAk1776);
		if (count != 0) {
            String dataLeAk1777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1777 = android.util.Log.d("leak-1777", dataLeAk1777);
			Toolbar toolbar = findViewById(R.id.toolbar);
            final String title = getString(R.string.selected_count, count);
            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk1778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1778 = android.util.Log.d("leak-1778", dataLeAk1778);

						@Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk1779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1779 = android.util.Log.d("leak-1779", dataLeAk1779);
							toolbar.setTitle(title);
                        }
                    });
        }
    }

    @Override
    public void onPickTargetModeEnter() {
        String dataLeAk1780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1780 = android.util.Log.d("leak-1780", dataLeAk1780);
		final Toolbar toolbar = findViewById(R.id.toolbar);
        if (fileOpIntent != null) {
            String dataLeAk1781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1781 = android.util.Log.d("leak-1781", dataLeAk1781);
			final int count = FileOperation.getFiles(fileOpIntent).length;

            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk1782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1782 = android.util.Log.d("leak-1782", dataLeAk1782);

						@Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk1783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1783 = android.util.Log.d("leak-1783", dataLeAk1783);
							String title = "";
                            int action = FileOperation.Util.getActionInt(
                                    FileExplorerActivity.this, fileOpIntent.getAction());
                            switch (action) {
                                case FileOperation.COPY:
                                    if (count == 1) {
                                        String dataLeAk1784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1784 = android.util.Log.d("leak-1784", dataLeAk1784);
										title = getString(R.string.copy_file, count);
                                    } else {
                                        String dataLeAk1785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1785 = android.util.Log.d("leak-1785", dataLeAk1785);
										title = getString(R.string.copy_files, count);
                                    }
                                    break;
                                case FileOperation.MOVE:
                                    if (count == 1) {
                                        String dataLeAk1786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1786 = android.util.Log.d("leak-1786", dataLeAk1786);
										title = getString(R.string.move_file, count);
                                    } else {
                                        String dataLeAk1787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1787 = android.util.Log.d("leak-1787", dataLeAk1787);
										title = getString(R.string.move_files, count);
                                    }
                                    break;
                            }
                            toolbar.setTitle(title);
                        }
                    });
        }

        animateFab(true);

        new Handler().postDelayed(new Runnable() {
            String dataLeAk1788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1788 = android.util.Log.d("leak-1788", dataLeAk1788);

			@Override
            public void run() {
                String dataLeAk1789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1789 = android.util.Log.d("leak-1789", dataLeAk1789);
				//hide menu items
                for (int i = 0; i < menu.size(); i++) {
                    String dataLeAk1790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1790 = android.util.Log.d("leak-1790", dataLeAk1790);
					MenuItem item = menu.getItem(i);
                    switch (item.getItemId()) {
                        case R.id.paste:
                            item.setVisible(true);
                            break;
                        default:
                            item.setVisible(false);
                            break;
                    }
                }
            }
        }, (int) (300 * Util.getAnimatorSpeed(this)));
    }

    @Override
    public void onPickTargetModeExit() {
        String dataLeAk1791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1791 = android.util.Log.d("leak-1791", dataLeAk1791);
		animateFab(false);
        resetToolbar();
    }

    @Override
    public void onDataChanged() {
        String dataLeAk1792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1792 = android.util.Log.d("leak-1792", dataLeAk1792);
		final View emptyState = findViewById(R.id.empty_state_text);
        emptyState.animate()
                .alpha(currentDir.getChildren().size() == 0 ? 1.0f : 0.0f)
                .setListener(new AnimatorListenerAdapter() {
                    String dataLeAk1793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1793 = android.util.Log.d("leak-1793", dataLeAk1793);

					@Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
						String dataLeAk1794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1794 = android.util.Log.d("leak-1794", dataLeAk1794);
                        emptyState.setVisibility(
                                currentDir.getChildren().size() == 0 ?
                                        View.VISIBLE : View.GONE);
                    }
                })
                .setDuration(100)
                .start();

        if (recyclerViewAdapter.getMode() == RecyclerViewAdapter.NORMAL_MODE) {
            String dataLeAk1795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1795 = android.util.Log.d("leak-1795", dataLeAk1795);
			final Toolbar toolbar = findViewById(R.id.toolbar);

            ColorFade.fadeToolbarTitleColor(toolbar, textColorPrimary,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk1796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1796 = android.util.Log.d("leak-1796", dataLeAk1796);

						@Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk1797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1797 = android.util.Log.d("leak-1797", dataLeAk1797);
							toolbar.setTitle(currentDir.getPath());
                        }
                    });
        }

        if (recyclerViewAdapter.getMode() == RecyclerViewAdapter.NORMAL_MODE) {
            String dataLeAk1798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1798 = android.util.Log.d("leak-1798", dataLeAk1798);
			manageMenuItems();
        }
    }

    public void resetToolbar() {
        String dataLeAk1799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1799 = android.util.Log.d("leak-1799", dataLeAk1799);
		final Toolbar toolbar = findViewById(R.id.toolbar);

        if (theme.darkStatusBarIcons()) {
            String dataLeAk1800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1800 = android.util.Log.d("leak-1800", dataLeAk1800);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk1801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1801 = android.util.Log.d("leak-1801", dataLeAk1801);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            String dataLeAk1802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1802 = android.util.Log.d("leak-1802", dataLeAk1802);
			int alpha = Color.alpha(getStatusBarColor());
            ColorFade.fadeDrawableAlpha(statusBarOverlay, alpha);
        }

        toolbar.setActivated(theme.elevatedToolbar());

        ColorFade.fadeBackgroundColor(toolbar, accentColor, toolbarColor);
        ColorFade.fadeToolbarTitleColor(toolbar, textColorPrimary,
                new ColorFade.ToolbarTitleFadeCallback() {
                    String dataLeAk1803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1803 = android.util.Log.d("leak-1803", dataLeAk1803);

					@Override
                    public void setTitle(Toolbar toolbar) {
                        String dataLeAk1804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1804 = android.util.Log.d("leak-1804", dataLeAk1804);
						toolbar.setTitle(currentDir.getPath());
                    }
                });

        //fade overflow menu icon
        ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(), accentTextColor, textColorSecondary);

        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon instanceof Animatable) {
            String dataLeAk1805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1805 = android.util.Log.d("leak-1805", dataLeAk1805);
			((Animatable) navIcon).start();
            ColorFade.fadeDrawableColor(navIcon, accentTextColor, textColorSecondary);
        }
        new Handler().postDelayed(new Runnable() {
            String dataLeAk1806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1806 = android.util.Log.d("leak-1806", dataLeAk1806);

			@Override
            public void run() {
                String dataLeAk1807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1807 = android.util.Log.d("leak-1807", dataLeAk1807);
				Drawable d;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String dataLeAk1808 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1808 = android.util.Log.d("leak-1808", dataLeAk1808);
					AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                            ContextCompat.getDrawable(FileExplorerActivity.this,
                                    R.drawable.back_to_cancel_avd);
                    //mutating avd to reset it
                    drawable.mutate();
                    d = drawable;
                } else {
                    String dataLeAk1809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1809 = android.util.Log.d("leak-1809", dataLeAk1809);
					d = ContextCompat.getDrawable(FileExplorerActivity.this,
                            R.drawable.ic_arrow_back_white_24dp);
                }
                d = DrawableCompat.wrap(d);
                DrawableCompat.setTint(d.mutate(), textColorSecondary);
                toolbar.setNavigationIcon(d);

                //hide menu items
                for (int i = 0; i < menu.size(); i++) {
                    String dataLeAk1810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1810 = android.util.Log.d("leak-1810", dataLeAk1810);
					MenuItem item = menu.getItem(i);
                    switch (item.getItemId()) {
                        case R.id.exclude:
                        case R.id.scan:
                            item.setVisible(true);
                            break;
                        default:
                            item.setVisible(false);
                            break;
                    }
                }
            }
        }, navIcon instanceof Animatable ? (int) (500 * Util.getAnimatorSpeed(this)) : 0);
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk1811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1811 = android.util.Log.d("leak-1811", dataLeAk1811);
		return R.style.CameraRoll_Theme_Translucent_FileExplorer;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1812 = android.util.Log.d("leak-1812", dataLeAk1812);
		return R.style.CameraRoll_Theme_Light_Translucent_FileExplorer;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk1813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1813 = android.util.Log.d("leak-1813", dataLeAk1813);
		FloatingActionButton fab = findViewById(R.id.fab);
        fab.setBackgroundTintList(ColorStateList.valueOf(accentColor));

        if (theme.darkStatusBarIcons()) {
            String dataLeAk1814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1814 = android.util.Log.d("leak-1814", dataLeAk1814);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk1815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1815 = android.util.Log.d("leak-1815", dataLeAk1815);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(theme.elevatedToolbar());

        if (theme.statusBarOverlay()) {
            String dataLeAk1816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1816 = android.util.Log.d("leak-1816", dataLeAk1816);
			addStatusBarOverlay(toolbar);
        }
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk1817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1817 = android.util.Log.d("leak-1817", dataLeAk1817);
		return new BroadcastReceiver() {
            String dataLeAk1818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1818 = android.util.Log.d("leak-1818", dataLeAk1818);

			@Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk1819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1819 = android.util.Log.d("leak-1819", dataLeAk1819);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        loadDirectory(currentDir.getPath());
                        break;
                    case FileOperation.FAILED:
                        break;
                    default:
                        break;
                }
            }
        };
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        String dataLeAk1820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1820 = android.util.Log.d("leak-1820", dataLeAk1820);
		return FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
    }
}
