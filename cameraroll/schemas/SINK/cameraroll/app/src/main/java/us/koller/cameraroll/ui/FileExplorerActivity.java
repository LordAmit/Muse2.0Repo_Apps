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

    final String dataLeAk904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk873 = "";

	String dataLeAk871 = "";

	String dataLeAk870 = "";

	String dataLeAk869 = "";

	String dataLeAk868 = "";

	String dataLeAk865 = "";

	String dataLeAk862 = "";

	String dataLeAk861 = "";

	String dataLeAk858 = "";

	String dataLeAk856 = "";

	String dataLeAk854 = "";

	String dataLeAk852 = "";

	String dataLeAk851 = "";

	String dataLeAk850 = "";

	String dataLeAk849 = "";

	String dataLeAk848 = "";

	String dataLeAk847 = "";

	String dataLeAk846 = "";

	String dataLeAk844 = "";

	String dataLeAk841 = "";

	String dataLeAk840 = "";

	String dataLeAk839 = "";

	String dataLeAk838 = "";

	String dataLeAk837 = "";

	String dataLeAk829 = "";

	String dataLeAk828 = "";

	String dataLeAk822 = "";

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
		dataLeAk822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-0", dataLeAk822);
		android.util.Log.d("leak-828-0", dataLeAk828);
		android.util.Log.d("leak-829-0", dataLeAk829);
		android.util.Log.d("leak-837-0", dataLeAk837);
		android.util.Log.d("leak-838-0", dataLeAk838);
		android.util.Log.d("leak-839-0", dataLeAk839);
		android.util.Log.d("leak-840-0", dataLeAk840);
		android.util.Log.d("leak-841-0", dataLeAk841);
		android.util.Log.d("leak-844-0", dataLeAk844);
		android.util.Log.d("leak-846-0", dataLeAk846);
		android.util.Log.d("leak-847-0", dataLeAk847);
		android.util.Log.d("leak-848-0", dataLeAk848);
		android.util.Log.d("leak-849-0", dataLeAk849);
		android.util.Log.d("leak-850-0", dataLeAk850);
		android.util.Log.d("leak-851-0", dataLeAk851);
		android.util.Log.d("leak-852-0", dataLeAk852);
		android.util.Log.d("leak-854-0", dataLeAk854);
		android.util.Log.d("leak-856-0", dataLeAk856);
		android.util.Log.d("leak-858-0", dataLeAk858);
		android.util.Log.d("leak-861-0", dataLeAk861);
		android.util.Log.d("leak-862-0", dataLeAk862);
		android.util.Log.d("leak-865-0", dataLeAk865);
		android.util.Log.d("leak-868-0", dataLeAk868);
		android.util.Log.d("leak-869-0", dataLeAk869);
		android.util.Log.d("leak-870-0", dataLeAk870);
		android.util.Log.d("leak-871-0", dataLeAk871);
		android.util.Log.d("leak-873-0", dataLeAk873);
        setContentView(R.layout.activity_file_explorer);

        currentDir = new File_POJO("", false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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
            AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                    ContextCompat.getDrawable(FileExplorerActivity.this, R.drawable.back_to_cancel_avd);
            //mutating avd to reset it
            drawable.mutate();
            toolbar.setNavigationIcon(drawable);
        } else {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        }
        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon != null) {
            navIcon = DrawableCompat.wrap(navIcon);
            DrawableCompat.setTint(navIcon.mutate(), textColorSecondary);
            toolbar.setNavigationIcon(navIcon);
        }

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.file_explorer));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Util.colorToolbarOverflowMenuIcon(toolbar, textColorSecondary);

        //need to be called after setTitle(), to ensure, that mTitleTextView exists
        final TextView titleTextView = Util.setToolbarTypeface(toolbar
        );
        if (titleTextView != null) {
            titleTextView.setEllipsize(TextUtils.TruncateAt.START);
        }

        final ViewGroup rootView = findViewById(R.id.swipeBackView);
        if (rootView instanceof SwipeBackCoordinatorLayout) {
            ((SwipeBackCoordinatorLayout) rootView).setOnSwipeListener(this);
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(
                new OnDirectoryChangeCallback() {
                    String dataLeAk823 = "";

					@Override
                    public void changeDir(String path) {
                        dataLeAk823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-875-0", dataLeAk875);
						android.util.Log.d("leak-823-0", dataLeAk823);
						loadDirectory(path);
                    }
                }, this);
        if (savedInstanceState != null && savedInstanceState.containsKey(CURRENT_DIR)) {
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
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk824 = "";

				@RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                @Override
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-876-0", dataLeAk876);
					android.util.Log.d("leak-824-0", dataLeAk824);
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
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk825 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-877-0", dataLeAk877);
									android.util.Log.d("leak-825-0", dataLeAk825);
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
            roots = savedInstanceState.getParcelable(ROOTS);
            currentDir = savedInstanceState.getParcelable(CURRENT_DIR);

            recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onDataChanged();

            if (savedInstanceState.containsKey(MODE)) {
                int mode = savedInstanceState.getInt(MODE);

                if (mode == RecyclerViewAdapter.SELECTOR_MODE) {
                    if (savedInstanceState.containsKey(SELECTED_ITEMS)) {
                        final File_POJO[] selectedItems
                                = (File_POJO[]) savedInstanceState.getParcelableArray(SELECTED_ITEMS);
                        if (selectedItems != null) {
                            rootView.getViewTreeObserver().addOnGlobalLayoutListener(
                                    new ViewTreeObserver.OnGlobalLayoutListener() {
                                        String dataLeAk826 = "";

										@Override
                                        public void onGlobalLayout() {
                                            dataLeAk826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											android.util.Log.d("leak-878-0", dataLeAk878);
											android.util.Log.d("leak-826-0", dataLeAk826);
											rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                            recyclerViewAdapter.enterSelectorMode(selectedItems);
                                        }
                                    });

                        }
                    }
                } else if (mode == RecyclerViewAdapter.PICK_TARGET_MODE
                        && savedInstanceState.containsKey(FILE_OPERATION)) {
                    onSelectorModeEnter();
                    //fileOp = savedInstanceState.getParcelable(FILE_OPERATION);
                        /*FileOperation.operation = fileOp != null ?
                                fileOp.getType() : FileOperation.EMPTY;*/
                    //need to call pick target after onSelectorModeEnter animation are done
                    new Handler().postDelayed(new Runnable() {
                        String dataLeAk827 = "";

						@Override
                        public void run() {
                            dataLeAk827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-879-0", dataLeAk879);
							android.util.Log.d("leak-827-0", dataLeAk827);
							recyclerViewAdapter.pickTarget();
                        }
                    }, (int) (500 * Util.getAnimatorSpeed(this)));
                }
            }

        } else {
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
        dataLeAk828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-1", dataLeAk822);
		android.util.Log.d("leak-828-1", dataLeAk828);
		android.util.Log.d("leak-829-1", dataLeAk829);
		android.util.Log.d("leak-837-1", dataLeAk837);
		android.util.Log.d("leak-838-1", dataLeAk838);
		android.util.Log.d("leak-839-1", dataLeAk839);
		android.util.Log.d("leak-840-1", dataLeAk840);
		android.util.Log.d("leak-841-1", dataLeAk841);
		android.util.Log.d("leak-844-1", dataLeAk844);
		android.util.Log.d("leak-846-1", dataLeAk846);
		android.util.Log.d("leak-847-1", dataLeAk847);
		android.util.Log.d("leak-848-1", dataLeAk848);
		android.util.Log.d("leak-849-1", dataLeAk849);
		android.util.Log.d("leak-850-1", dataLeAk850);
		android.util.Log.d("leak-851-1", dataLeAk851);
		android.util.Log.d("leak-852-1", dataLeAk852);
		android.util.Log.d("leak-854-1", dataLeAk854);
		android.util.Log.d("leak-856-1", dataLeAk856);
		android.util.Log.d("leak-858-1", dataLeAk858);
		android.util.Log.d("leak-861-1", dataLeAk861);
		android.util.Log.d("leak-862-1", dataLeAk862);
		android.util.Log.d("leak-865-1", dataLeAk865);
		android.util.Log.d("leak-868-1", dataLeAk868);
		android.util.Log.d("leak-869-1", dataLeAk869);
		android.util.Log.d("leak-870-1", dataLeAk870);
		android.util.Log.d("leak-871-1", dataLeAk871);
		android.util.Log.d("leak-873-1", dataLeAk873);
		StorageRoot[] storageRoots = FilesProvider.getRoots(this);
        roots = new StorageRoot(STORAGE_ROOTS);
        for (int i = 0; i < storageRoots.length; i++) {
            roots.addChild(storageRoots[i]);
        }

        FileExplorerActivity.this.currentDir = roots;
        if (recyclerViewAdapter != null) {
            recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onDataChanged();
        }
    }

    public void loadDirectory(final String path) {
        dataLeAk829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-2", dataLeAk822);
		android.util.Log.d("leak-828-2", dataLeAk828);
		android.util.Log.d("leak-829-2", dataLeAk829);
		android.util.Log.d("leak-837-2", dataLeAk837);
		android.util.Log.d("leak-838-2", dataLeAk838);
		android.util.Log.d("leak-839-2", dataLeAk839);
		android.util.Log.d("leak-840-2", dataLeAk840);
		android.util.Log.d("leak-841-2", dataLeAk841);
		android.util.Log.d("leak-844-2", dataLeAk844);
		android.util.Log.d("leak-846-2", dataLeAk846);
		android.util.Log.d("leak-847-2", dataLeAk847);
		android.util.Log.d("leak-848-2", dataLeAk848);
		android.util.Log.d("leak-849-2", dataLeAk849);
		android.util.Log.d("leak-850-2", dataLeAk850);
		android.util.Log.d("leak-851-2", dataLeAk851);
		android.util.Log.d("leak-852-2", dataLeAk852);
		android.util.Log.d("leak-854-2", dataLeAk854);
		android.util.Log.d("leak-856-2", dataLeAk856);
		android.util.Log.d("leak-858-2", dataLeAk858);
		android.util.Log.d("leak-861-2", dataLeAk861);
		android.util.Log.d("leak-862-2", dataLeAk862);
		android.util.Log.d("leak-865-2", dataLeAk865);
		android.util.Log.d("leak-868-2", dataLeAk868);
		android.util.Log.d("leak-869-2", dataLeAk869);
		android.util.Log.d("leak-870-2", dataLeAk870);
		android.util.Log.d("leak-871-2", dataLeAk871);
		android.util.Log.d("leak-873-2", dataLeAk873);
		Log.d("FileExplorerActivity", "loadDirectory(): " + path);
        final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                getString(R.string.loading), Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);

        final FilesProvider.Callback callback = new FilesProvider.Callback() {
            final String dataLeAk890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk835 = "";

			String dataLeAk832 = "";

			String dataLeAk830 = "";

			@Override
            public void onDirLoaded(final File_POJO dir) {
                dataLeAk830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-880-0", dataLeAk880);
				android.util.Log.d("leak-830-0", dataLeAk830);
				android.util.Log.d("leak-832-0", dataLeAk832);
				android.util.Log.d("leak-835-0", dataLeAk835);
				runOnUiThread(new Runnable() {
                    String dataLeAk831 = "";

					@Override
                    public void run() {
                        dataLeAk831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-882-0", dataLeAk882);
						android.util.Log.d("leak-881-0", dataLeAk881);
						android.util.Log.d("leak-831-0", dataLeAk831);
						filesProvider.onDestroy();
                        filesProvider = null;

                        if (dir != null) {
                            FileExplorerActivity.this.currentDir = dir;
                            if (recyclerViewAdapter != null) {
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
                dataLeAk832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-883-0", dataLeAk883);
				android.util.Log.d("leak-830-1", dataLeAk830);
				android.util.Log.d("leak-832-1", dataLeAk832);
				android.util.Log.d("leak-835-1", dataLeAk835);
				runOnUiThread(new Runnable() {
                    final String dataLeAk886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					String dataLeAk833 = "";

					@Override
                    public void run() {
                        dataLeAk833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-885-0", dataLeAk885);
						android.util.Log.d("leak-884-0", dataLeAk884);
						android.util.Log.d("leak-833-0", dataLeAk833);
						snackbar.dismiss();

                        final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                                R.string.loading_failed, Snackbar.LENGTH_INDEFINITE);
                        snackbar.setAction(getString(R.string.retry), new View.OnClickListener() {
                            String dataLeAk834 = "";

							@Override
                            public void onClick(View view) {
                                dataLeAk834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-888-0", dataLeAk888);
								android.util.Log.d("leak-887-0", dataLeAk887);
								android.util.Log.d("leak-886-0", dataLeAk886);
								android.util.Log.d("leak-834-0", dataLeAk834);
								loadDirectory(path);
                            }
                        });
                        Util.showSnackbar(snackbar);
                    }
                });
            }

            @Override
            public void needPermission() {
                dataLeAk835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-889-0", dataLeAk889);
				android.util.Log.d("leak-830-2", dataLeAk830);
				android.util.Log.d("leak-832-2", dataLeAk832);
				android.util.Log.d("leak-835-2", dataLeAk835);
				runOnUiThread(new Runnable() {
                    String dataLeAk836 = "";

					@Override
                    public void run() {
                        dataLeAk836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-891-0", dataLeAk891);
						android.util.Log.d("leak-890-0", dataLeAk890);
						android.util.Log.d("leak-836-0", dataLeAk836);
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
		dataLeAk837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-3", dataLeAk822);
		android.util.Log.d("leak-828-3", dataLeAk828);
		android.util.Log.d("leak-829-3", dataLeAk829);
		android.util.Log.d("leak-837-3", dataLeAk837);
		android.util.Log.d("leak-838-3", dataLeAk838);
		android.util.Log.d("leak-839-3", dataLeAk839);
		android.util.Log.d("leak-840-3", dataLeAk840);
		android.util.Log.d("leak-841-3", dataLeAk841);
		android.util.Log.d("leak-844-3", dataLeAk844);
		android.util.Log.d("leak-846-3", dataLeAk846);
		android.util.Log.d("leak-847-3", dataLeAk847);
		android.util.Log.d("leak-848-3", dataLeAk848);
		android.util.Log.d("leak-849-3", dataLeAk849);
		android.util.Log.d("leak-850-3", dataLeAk850);
		android.util.Log.d("leak-851-3", dataLeAk851);
		android.util.Log.d("leak-852-3", dataLeAk852);
		android.util.Log.d("leak-854-3", dataLeAk854);
		android.util.Log.d("leak-856-3", dataLeAk856);
		android.util.Log.d("leak-858-3", dataLeAk858);
		android.util.Log.d("leak-861-3", dataLeAk861);
		android.util.Log.d("leak-862-3", dataLeAk862);
		android.util.Log.d("leak-865-3", dataLeAk865);
		android.util.Log.d("leak-868-3", dataLeAk868);
		android.util.Log.d("leak-869-3", dataLeAk869);
		android.util.Log.d("leak-870-3", dataLeAk870);
		android.util.Log.d("leak-871-3", dataLeAk871);
		android.util.Log.d("leak-873-3", dataLeAk873);
        outState.putParcelable(ROOTS, roots);
        if (currentDir != null) {
            outState.putParcelable(CURRENT_DIR, currentDir);
        }

        outState.putInt(MODE, recyclerViewAdapter.getMode());

        File_POJO[] selectedItems = recyclerViewAdapter.getSelectedItems();
        if (selectedItems.length > 0) {
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
        dataLeAk838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-4", dataLeAk822);
		android.util.Log.d("leak-828-4", dataLeAk828);
		android.util.Log.d("leak-829-4", dataLeAk829);
		android.util.Log.d("leak-837-4", dataLeAk837);
		android.util.Log.d("leak-838-4", dataLeAk838);
		android.util.Log.d("leak-839-4", dataLeAk839);
		android.util.Log.d("leak-840-4", dataLeAk840);
		android.util.Log.d("leak-841-4", dataLeAk841);
		android.util.Log.d("leak-844-4", dataLeAk844);
		android.util.Log.d("leak-846-4", dataLeAk846);
		android.util.Log.d("leak-847-4", dataLeAk847);
		android.util.Log.d("leak-848-4", dataLeAk848);
		android.util.Log.d("leak-849-4", dataLeAk849);
		android.util.Log.d("leak-850-4", dataLeAk850);
		android.util.Log.d("leak-851-4", dataLeAk851);
		android.util.Log.d("leak-852-4", dataLeAk852);
		android.util.Log.d("leak-854-4", dataLeAk854);
		android.util.Log.d("leak-856-4", dataLeAk856);
		android.util.Log.d("leak-858-4", dataLeAk858);
		android.util.Log.d("leak-861-4", dataLeAk861);
		android.util.Log.d("leak-862-4", dataLeAk862);
		android.util.Log.d("leak-865-4", dataLeAk865);
		android.util.Log.d("leak-868-4", dataLeAk868);
		android.util.Log.d("leak-869-4", dataLeAk869);
		android.util.Log.d("leak-870-4", dataLeAk870);
		android.util.Log.d("leak-871-4", dataLeAk871);
		android.util.Log.d("leak-873-4", dataLeAk873);
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
        dataLeAk839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-5", dataLeAk822);
		android.util.Log.d("leak-828-5", dataLeAk828);
		android.util.Log.d("leak-829-5", dataLeAk829);
		android.util.Log.d("leak-837-5", dataLeAk837);
		android.util.Log.d("leak-838-5", dataLeAk838);
		android.util.Log.d("leak-839-5", dataLeAk839);
		android.util.Log.d("leak-840-5", dataLeAk840);
		android.util.Log.d("leak-841-5", dataLeAk841);
		android.util.Log.d("leak-844-5", dataLeAk844);
		android.util.Log.d("leak-846-5", dataLeAk846);
		android.util.Log.d("leak-847-5", dataLeAk847);
		android.util.Log.d("leak-848-5", dataLeAk848);
		android.util.Log.d("leak-849-5", dataLeAk849);
		android.util.Log.d("leak-850-5", dataLeAk850);
		android.util.Log.d("leak-851-5", dataLeAk851);
		android.util.Log.d("leak-852-5", dataLeAk852);
		android.util.Log.d("leak-854-5", dataLeAk854);
		android.util.Log.d("leak-856-5", dataLeAk856);
		android.util.Log.d("leak-858-5", dataLeAk858);
		android.util.Log.d("leak-861-5", dataLeAk861);
		android.util.Log.d("leak-862-5", dataLeAk862);
		android.util.Log.d("leak-865-5", dataLeAk865);
		android.util.Log.d("leak-868-5", dataLeAk868);
		android.util.Log.d("leak-869-5", dataLeAk869);
		android.util.Log.d("leak-870-5", dataLeAk870);
		android.util.Log.d("leak-871-5", dataLeAk871);
		android.util.Log.d("leak-873-5", dataLeAk873);
		if (menu != null) {
            for (int i = 0; i < menu.size(); i++) {
                MenuItem item = menu.getItem(i);
                switch (item.getItemId()) {
                    case R.id.exclude:
                        if (currentDir != null) {
                            item.setVisible(!currentDir.getPath().equals(STORAGE_ROOTS));
                            if (Provider.isPathPermanentlyExcluded(currentDir.getPath())) {
                                item.setChecked(true);
                                item.setEnabled(false);
                            } else {
                                item.setChecked(currentDir.excluded);
                                item.setEnabled(!currentDir.getPath().equals(STORAGE_ROOTS)
                                        && !Provider.isDirExcludedBecauseParentDirIsExcluded(
                                        currentDir.getPath(), Provider.getExcludedPaths()));
                            }
                        } else {
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
        dataLeAk840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-6", dataLeAk822);
		android.util.Log.d("leak-828-6", dataLeAk828);
		android.util.Log.d("leak-829-6", dataLeAk829);
		android.util.Log.d("leak-837-6", dataLeAk837);
		android.util.Log.d("leak-838-6", dataLeAk838);
		android.util.Log.d("leak-839-6", dataLeAk839);
		android.util.Log.d("leak-840-6", dataLeAk840);
		android.util.Log.d("leak-841-6", dataLeAk841);
		android.util.Log.d("leak-844-6", dataLeAk844);
		android.util.Log.d("leak-846-6", dataLeAk846);
		android.util.Log.d("leak-847-6", dataLeAk847);
		android.util.Log.d("leak-848-6", dataLeAk848);
		android.util.Log.d("leak-849-6", dataLeAk849);
		android.util.Log.d("leak-850-6", dataLeAk850);
		android.util.Log.d("leak-851-6", dataLeAk851);
		android.util.Log.d("leak-852-6", dataLeAk852);
		android.util.Log.d("leak-854-6", dataLeAk854);
		android.util.Log.d("leak-856-6", dataLeAk856);
		android.util.Log.d("leak-858-6", dataLeAk858);
		android.util.Log.d("leak-861-6", dataLeAk861);
		android.util.Log.d("leak-862-6", dataLeAk862);
		android.util.Log.d("leak-865-6", dataLeAk865);
		android.util.Log.d("leak-868-6", dataLeAk868);
		android.util.Log.d("leak-869-6", dataLeAk869);
		android.util.Log.d("leak-870-6", dataLeAk870);
		android.util.Log.d("leak-871-6", dataLeAk871);
		android.util.Log.d("leak-873-6", dataLeAk873);
		switch (item.getItemId()) {
            case android.R.id.home:
                if (recyclerViewAdapter.isModeActive()
                        || recyclerViewAdapter.getMode()
                        == RecyclerViewAdapter.PICK_TARGET_MODE) {
                    recyclerViewAdapter.cancelMode();
                } else {
                    onBackPressed();
                }
                break;
            case R.id.exclude:
                currentDir.excluded = !currentDir.excluded;
                item.setChecked(currentDir.excluded);
                if (currentDir.excluded) {
                    FilesProvider.addExcludedPath(this, currentDir.getPath());
                } else {
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
                    recyclerViewAdapter.cancelMode();
                    if (fileOpIntent != null) {
                        File_POJO target = recyclerViewAdapter.getFiles();
                        fileOpIntent.putExtra(FileOperation.TARGET, target);
                        startService(fileOpIntent);
                        fileOpIntent = null;
                    }
                } else {
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
        dataLeAk841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-7", dataLeAk822);
		android.util.Log.d("leak-828-7", dataLeAk828);
		android.util.Log.d("leak-829-7", dataLeAk829);
		android.util.Log.d("leak-837-7", dataLeAk837);
		android.util.Log.d("leak-838-7", dataLeAk838);
		android.util.Log.d("leak-839-7", dataLeAk839);
		android.util.Log.d("leak-840-7", dataLeAk840);
		android.util.Log.d("leak-841-7", dataLeAk841);
		android.util.Log.d("leak-844-7", dataLeAk844);
		android.util.Log.d("leak-846-7", dataLeAk846);
		android.util.Log.d("leak-847-7", dataLeAk847);
		android.util.Log.d("leak-848-7", dataLeAk848);
		android.util.Log.d("leak-849-7", dataLeAk849);
		android.util.Log.d("leak-850-7", dataLeAk850);
		android.util.Log.d("leak-851-7", dataLeAk851);
		android.util.Log.d("leak-852-7", dataLeAk852);
		android.util.Log.d("leak-854-7", dataLeAk854);
		android.util.Log.d("leak-856-7", dataLeAk856);
		android.util.Log.d("leak-858-7", dataLeAk858);
		android.util.Log.d("leak-861-7", dataLeAk861);
		android.util.Log.d("leak-862-7", dataLeAk862);
		android.util.Log.d("leak-865-7", dataLeAk865);
		android.util.Log.d("leak-868-7", dataLeAk868);
		android.util.Log.d("leak-869-7", dataLeAk869);
		android.util.Log.d("leak-870-7", dataLeAk870);
		android.util.Log.d("leak-871-7", dataLeAk871);
		android.util.Log.d("leak-873-7", dataLeAk873);
		animateFab(false);

        View dialogLayout = LayoutInflater.from(this).inflate(R.layout.input_dialog_layout,
                (ViewGroup) findViewById(R.id.root_view), false);

        final EditText editText = dialogLayout.findViewById(R.id.edit_text);

        AlertDialog dialog = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(R.string.new_folder)
                .setView(dialogLayout)
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    String dataLeAk842 = "";

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dataLeAk842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-892-0", dataLeAk892);
						android.util.Log.d("leak-842-0", dataLeAk842);
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
                    String dataLeAk843 = "";

					@Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        dataLeAk843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-893-0", dataLeAk893);
						android.util.Log.d("leak-843-0", dataLeAk843);
						animateFab(true);
                    }
                })
                .create();
        //noinspection ConstantConditions
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        dialog.show();
    }

    public void animateFab(final boolean show) {
        dataLeAk844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-8", dataLeAk822);
		android.util.Log.d("leak-828-8", dataLeAk828);
		android.util.Log.d("leak-829-8", dataLeAk829);
		android.util.Log.d("leak-837-8", dataLeAk837);
		android.util.Log.d("leak-838-8", dataLeAk838);
		android.util.Log.d("leak-839-8", dataLeAk839);
		android.util.Log.d("leak-840-8", dataLeAk840);
		android.util.Log.d("leak-841-8", dataLeAk841);
		android.util.Log.d("leak-844-8", dataLeAk844);
		android.util.Log.d("leak-846-8", dataLeAk846);
		android.util.Log.d("leak-847-8", dataLeAk847);
		android.util.Log.d("leak-848-8", dataLeAk848);
		android.util.Log.d("leak-849-8", dataLeAk849);
		android.util.Log.d("leak-850-8", dataLeAk850);
		android.util.Log.d("leak-851-8", dataLeAk851);
		android.util.Log.d("leak-852-8", dataLeAk852);
		android.util.Log.d("leak-854-8", dataLeAk854);
		android.util.Log.d("leak-856-8", dataLeAk856);
		android.util.Log.d("leak-858-8", dataLeAk858);
		android.util.Log.d("leak-861-8", dataLeAk861);
		android.util.Log.d("leak-862-8", dataLeAk862);
		android.util.Log.d("leak-865-8", dataLeAk865);
		android.util.Log.d("leak-868-8", dataLeAk868);
		android.util.Log.d("leak-869-8", dataLeAk869);
		android.util.Log.d("leak-870-8", dataLeAk870);
		android.util.Log.d("leak-871-8", dataLeAk871);
		android.util.Log.d("leak-873-8", dataLeAk873);
		final FloatingActionButton fab = findViewById(R.id.fab);

        if ((fab.getScaleX() == 1.0f && show)
                || (fab.getScaleX() == 0.0f && !show)) {
            return;
        }

        if (show) {
            fab.setOnClickListener(new View.OnClickListener() {
                String dataLeAk845 = "";

				@Override
                public void onClick(View view) {
                    dataLeAk845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-894-0", dataLeAk894);
					android.util.Log.d("leak-845-0", dataLeAk845);
					fabClicked(view);
                }
            });
        } else {
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
        dataLeAk846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-9", dataLeAk822);
		android.util.Log.d("leak-828-9", dataLeAk828);
		android.util.Log.d("leak-829-9", dataLeAk829);
		android.util.Log.d("leak-837-9", dataLeAk837);
		android.util.Log.d("leak-838-9", dataLeAk838);
		android.util.Log.d("leak-839-9", dataLeAk839);
		android.util.Log.d("leak-840-9", dataLeAk840);
		android.util.Log.d("leak-841-9", dataLeAk841);
		android.util.Log.d("leak-844-9", dataLeAk844);
		android.util.Log.d("leak-846-9", dataLeAk846);
		android.util.Log.d("leak-847-9", dataLeAk847);
		android.util.Log.d("leak-848-9", dataLeAk848);
		android.util.Log.d("leak-849-9", dataLeAk849);
		android.util.Log.d("leak-850-9", dataLeAk850);
		android.util.Log.d("leak-851-9", dataLeAk851);
		android.util.Log.d("leak-852-9", dataLeAk852);
		android.util.Log.d("leak-854-9", dataLeAk854);
		android.util.Log.d("leak-856-9", dataLeAk856);
		android.util.Log.d("leak-858-9", dataLeAk858);
		android.util.Log.d("leak-861-9", dataLeAk861);
		android.util.Log.d("leak-862-9", dataLeAk862);
		android.util.Log.d("leak-865-9", dataLeAk865);
		android.util.Log.d("leak-868-9", dataLeAk868);
		android.util.Log.d("leak-869-9", dataLeAk869);
		android.util.Log.d("leak-870-9", dataLeAk870);
		android.util.Log.d("leak-871-9", dataLeAk871);
		android.util.Log.d("leak-873-9", dataLeAk873);
		if (recyclerViewAdapter.isModeActive()) {
            recyclerViewAdapter.cancelMode();
        } else if (currentDir != null && !currentDir.getPath().equals(STORAGE_ROOTS)) {
            if (!isCurrentFileARoot()) {
                String path = currentDir.getPath();
                int index = path.lastIndexOf("/");
                String parentPath = path.substring(0, index);

                loadDirectory(parentPath);
            } else {
                loadRoots();
            }
        } else {
            //setResult(RESULT_OK, new Intent(MainActivity.REFRESH_MEDIA));
            super.onBackPressed();
        }
    }

    private boolean isCurrentFileARoot() {
        dataLeAk847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-10", dataLeAk822);
		android.util.Log.d("leak-828-10", dataLeAk828);
		android.util.Log.d("leak-829-10", dataLeAk829);
		android.util.Log.d("leak-837-10", dataLeAk837);
		android.util.Log.d("leak-838-10", dataLeAk838);
		android.util.Log.d("leak-839-10", dataLeAk839);
		android.util.Log.d("leak-840-10", dataLeAk840);
		android.util.Log.d("leak-841-10", dataLeAk841);
		android.util.Log.d("leak-844-10", dataLeAk844);
		android.util.Log.d("leak-846-10", dataLeAk846);
		android.util.Log.d("leak-847-10", dataLeAk847);
		android.util.Log.d("leak-848-10", dataLeAk848);
		android.util.Log.d("leak-849-10", dataLeAk849);
		android.util.Log.d("leak-850-10", dataLeAk850);
		android.util.Log.d("leak-851-10", dataLeAk851);
		android.util.Log.d("leak-852-10", dataLeAk852);
		android.util.Log.d("leak-854-10", dataLeAk854);
		android.util.Log.d("leak-856-10", dataLeAk856);
		android.util.Log.d("leak-858-10", dataLeAk858);
		android.util.Log.d("leak-861-10", dataLeAk861);
		android.util.Log.d("leak-862-10", dataLeAk862);
		android.util.Log.d("leak-865-10", dataLeAk865);
		android.util.Log.d("leak-868-10", dataLeAk868);
		android.util.Log.d("leak-869-10", dataLeAk869);
		android.util.Log.d("leak-870-10", dataLeAk870);
		android.util.Log.d("leak-871-10", dataLeAk871);
		android.util.Log.d("leak-873-10", dataLeAk873);
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
    protected void onDestroy() {
        super.onDestroy();
		dataLeAk848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-11", dataLeAk822);
		android.util.Log.d("leak-828-11", dataLeAk828);
		android.util.Log.d("leak-829-11", dataLeAk829);
		android.util.Log.d("leak-837-11", dataLeAk837);
		android.util.Log.d("leak-838-11", dataLeAk838);
		android.util.Log.d("leak-839-11", dataLeAk839);
		android.util.Log.d("leak-840-11", dataLeAk840);
		android.util.Log.d("leak-841-11", dataLeAk841);
		android.util.Log.d("leak-844-11", dataLeAk844);
		android.util.Log.d("leak-846-11", dataLeAk846);
		android.util.Log.d("leak-847-11", dataLeAk847);
		android.util.Log.d("leak-848-11", dataLeAk848);
		android.util.Log.d("leak-849-11", dataLeAk849);
		android.util.Log.d("leak-850-11", dataLeAk850);
		android.util.Log.d("leak-851-11", dataLeAk851);
		android.util.Log.d("leak-852-11", dataLeAk852);
		android.util.Log.d("leak-854-11", dataLeAk854);
		android.util.Log.d("leak-856-11", dataLeAk856);
		android.util.Log.d("leak-858-11", dataLeAk858);
		android.util.Log.d("leak-861-11", dataLeAk861);
		android.util.Log.d("leak-862-11", dataLeAk862);
		android.util.Log.d("leak-865-11", dataLeAk865);
		android.util.Log.d("leak-868-11", dataLeAk868);
		android.util.Log.d("leak-869-11", dataLeAk869);
		android.util.Log.d("leak-870-11", dataLeAk870);
		android.util.Log.d("leak-871-11", dataLeAk871);
		android.util.Log.d("leak-873-11", dataLeAk873);

        Provider.saveExcludedPaths(this);

        if (filesProvider != null) {
            filesProvider.onDestroy();
        }
    }

    @Override
    public boolean canSwipeBack(int dir) {
        dataLeAk849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-12", dataLeAk822);
		android.util.Log.d("leak-828-12", dataLeAk828);
		android.util.Log.d("leak-829-12", dataLeAk829);
		android.util.Log.d("leak-837-12", dataLeAk837);
		android.util.Log.d("leak-838-12", dataLeAk838);
		android.util.Log.d("leak-839-12", dataLeAk839);
		android.util.Log.d("leak-840-12", dataLeAk840);
		android.util.Log.d("leak-841-12", dataLeAk841);
		android.util.Log.d("leak-844-12", dataLeAk844);
		android.util.Log.d("leak-846-12", dataLeAk846);
		android.util.Log.d("leak-847-12", dataLeAk847);
		android.util.Log.d("leak-848-12", dataLeAk848);
		android.util.Log.d("leak-849-12", dataLeAk849);
		android.util.Log.d("leak-850-12", dataLeAk850);
		android.util.Log.d("leak-851-12", dataLeAk851);
		android.util.Log.d("leak-852-12", dataLeAk852);
		android.util.Log.d("leak-854-12", dataLeAk854);
		android.util.Log.d("leak-856-12", dataLeAk856);
		android.util.Log.d("leak-858-12", dataLeAk858);
		android.util.Log.d("leak-861-12", dataLeAk861);
		android.util.Log.d("leak-862-12", dataLeAk862);
		android.util.Log.d("leak-865-12", dataLeAk865);
		android.util.Log.d("leak-868-12", dataLeAk868);
		android.util.Log.d("leak-869-12", dataLeAk869);
		android.util.Log.d("leak-870-12", dataLeAk870);
		android.util.Log.d("leak-871-12", dataLeAk871);
		android.util.Log.d("leak-873-12", dataLeAk873);
		return SwipeBackCoordinatorLayout.canSwipeBackForThisView(recyclerView, dir);
    }

    @Override
    public void onSwipeProcess(float percent) {
        dataLeAk850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-13", dataLeAk822);
		android.util.Log.d("leak-828-13", dataLeAk828);
		android.util.Log.d("leak-829-13", dataLeAk829);
		android.util.Log.d("leak-837-13", dataLeAk837);
		android.util.Log.d("leak-838-13", dataLeAk838);
		android.util.Log.d("leak-839-13", dataLeAk839);
		android.util.Log.d("leak-840-13", dataLeAk840);
		android.util.Log.d("leak-841-13", dataLeAk841);
		android.util.Log.d("leak-844-13", dataLeAk844);
		android.util.Log.d("leak-846-13", dataLeAk846);
		android.util.Log.d("leak-847-13", dataLeAk847);
		android.util.Log.d("leak-848-13", dataLeAk848);
		android.util.Log.d("leak-849-13", dataLeAk849);
		android.util.Log.d("leak-850-13", dataLeAk850);
		android.util.Log.d("leak-851-13", dataLeAk851);
		android.util.Log.d("leak-852-13", dataLeAk852);
		android.util.Log.d("leak-854-13", dataLeAk854);
		android.util.Log.d("leak-856-13", dataLeAk856);
		android.util.Log.d("leak-858-13", dataLeAk858);
		android.util.Log.d("leak-861-13", dataLeAk861);
		android.util.Log.d("leak-862-13", dataLeAk862);
		android.util.Log.d("leak-865-13", dataLeAk865);
		android.util.Log.d("leak-868-13", dataLeAk868);
		android.util.Log.d("leak-869-13", dataLeAk869);
		android.util.Log.d("leak-870-13", dataLeAk870);
		android.util.Log.d("leak-871-13", dataLeAk871);
		android.util.Log.d("leak-873-13", dataLeAk873);
		getWindow().getDecorView().setBackgroundColor(
                SwipeBackCoordinatorLayout.getBackgroundColor(percent));
        boolean selectorModeActive = ((RecyclerViewAdapter) recyclerView.getAdapter()).isModeActive();
        if (!theme.darkStatusBarIcons() && selectorModeActive) {
            SwipeBackCoordinatorLayout layout = findViewById(R.id.swipeBackView);
            Toolbar toolbar = findViewById(R.id.toolbar);
            View rootView = findViewById(R.id.root_view);
            int translationY = (int) layout.getTranslationY();
            int statusBarHeight = toolbar.getPaddingTop();
            if (translationY > statusBarHeight * 0.5) {
                Util.setLightStatusBarIcons(rootView);
            } else {
                Util.setDarkStatusBarIcons(rootView);
            }
        }
    }

    @Override
    public void onSwipeFinish(int dir) {
        dataLeAk851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-14", dataLeAk822);
		android.util.Log.d("leak-828-14", dataLeAk828);
		android.util.Log.d("leak-829-14", dataLeAk829);
		android.util.Log.d("leak-837-14", dataLeAk837);
		android.util.Log.d("leak-838-14", dataLeAk838);
		android.util.Log.d("leak-839-14", dataLeAk839);
		android.util.Log.d("leak-840-14", dataLeAk840);
		android.util.Log.d("leak-841-14", dataLeAk841);
		android.util.Log.d("leak-844-14", dataLeAk844);
		android.util.Log.d("leak-846-14", dataLeAk846);
		android.util.Log.d("leak-847-14", dataLeAk847);
		android.util.Log.d("leak-848-14", dataLeAk848);
		android.util.Log.d("leak-849-14", dataLeAk849);
		android.util.Log.d("leak-850-14", dataLeAk850);
		android.util.Log.d("leak-851-14", dataLeAk851);
		android.util.Log.d("leak-852-14", dataLeAk852);
		android.util.Log.d("leak-854-14", dataLeAk854);
		android.util.Log.d("leak-856-14", dataLeAk856);
		android.util.Log.d("leak-858-14", dataLeAk858);
		android.util.Log.d("leak-861-14", dataLeAk861);
		android.util.Log.d("leak-862-14", dataLeAk862);
		android.util.Log.d("leak-865-14", dataLeAk865);
		android.util.Log.d("leak-868-14", dataLeAk868);
		android.util.Log.d("leak-869-14", dataLeAk869);
		android.util.Log.d("leak-870-14", dataLeAk870);
		android.util.Log.d("leak-871-14", dataLeAk871);
		android.util.Log.d("leak-873-14", dataLeAk873);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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
        dataLeAk852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-15", dataLeAk822);
		android.util.Log.d("leak-828-15", dataLeAk828);
		android.util.Log.d("leak-829-15", dataLeAk829);
		android.util.Log.d("leak-837-15", dataLeAk837);
		android.util.Log.d("leak-838-15", dataLeAk838);
		android.util.Log.d("leak-839-15", dataLeAk839);
		android.util.Log.d("leak-840-15", dataLeAk840);
		android.util.Log.d("leak-841-15", dataLeAk841);
		android.util.Log.d("leak-844-15", dataLeAk844);
		android.util.Log.d("leak-846-15", dataLeAk846);
		android.util.Log.d("leak-847-15", dataLeAk847);
		android.util.Log.d("leak-848-15", dataLeAk848);
		android.util.Log.d("leak-849-15", dataLeAk849);
		android.util.Log.d("leak-850-15", dataLeAk850);
		android.util.Log.d("leak-851-15", dataLeAk851);
		android.util.Log.d("leak-852-15", dataLeAk852);
		android.util.Log.d("leak-854-15", dataLeAk854);
		android.util.Log.d("leak-856-15", dataLeAk856);
		android.util.Log.d("leak-858-15", dataLeAk858);
		android.util.Log.d("leak-861-15", dataLeAk861);
		android.util.Log.d("leak-862-15", dataLeAk862);
		android.util.Log.d("leak-865-15", dataLeAk865);
		android.util.Log.d("leak-868-15", dataLeAk868);
		android.util.Log.d("leak-869-15", dataLeAk869);
		android.util.Log.d("leak-870-15", dataLeAk870);
		android.util.Log.d("leak-871-15", dataLeAk871);
		android.util.Log.d("leak-873-15", dataLeAk873);
		fileOpIntent = null;

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(true);
        toolbar.animate().translationY(0.0f).start();

        if (theme.darkStatusBarIconsInSelectorMode()) {
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            ColorFade.fadeDrawableAlpha(statusBarOverlay, 0);
        }

        ColorFade.fadeBackgroundColor(toolbar, toolbarColor, accentColor);

        ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor, null);

        //fade overflow menu icon
        ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(),
                textColorSecondary, accentTextColor);

        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon instanceof Animatable) {
            ((Animatable) navIcon).start();
            ColorFade.fadeDrawableColor(navIcon,
                    textColorSecondary, accentTextColor);
        }
        new Handler().postDelayed(new Runnable() {
            String dataLeAk853 = "";

			@Override
            public void run() {
                dataLeAk853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-895-0", dataLeAk895);
				android.util.Log.d("leak-853-0", dataLeAk853);
				Drawable d;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                            ContextCompat.getDrawable(FileExplorerActivity.this,
                                    R.drawable.cancel_to_back_avd);
                    //mutating avd to reset it
                    drawable.mutate();
                    d = drawable;
                } else {
                    d = ContextCompat.getDrawable(FileExplorerActivity.this,
                            R.drawable.ic_clear_black_24dp);
                }
                d = DrawableCompat.wrap(d);
                DrawableCompat.setTint(d.mutate(), accentTextColor);
                toolbar.setNavigationIcon(d);

                //make menu items visible
                for (int i = 0; i < menu.size(); i++) {
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
        dataLeAk854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-16", dataLeAk822);
		android.util.Log.d("leak-828-16", dataLeAk828);
		android.util.Log.d("leak-829-16", dataLeAk829);
		android.util.Log.d("leak-837-16", dataLeAk837);
		android.util.Log.d("leak-838-16", dataLeAk838);
		android.util.Log.d("leak-839-16", dataLeAk839);
		android.util.Log.d("leak-840-16", dataLeAk840);
		android.util.Log.d("leak-841-16", dataLeAk841);
		android.util.Log.d("leak-844-16", dataLeAk844);
		android.util.Log.d("leak-846-16", dataLeAk846);
		android.util.Log.d("leak-847-16", dataLeAk847);
		android.util.Log.d("leak-848-16", dataLeAk848);
		android.util.Log.d("leak-849-16", dataLeAk849);
		android.util.Log.d("leak-850-16", dataLeAk850);
		android.util.Log.d("leak-851-16", dataLeAk851);
		android.util.Log.d("leak-852-16", dataLeAk852);
		android.util.Log.d("leak-854-16", dataLeAk854);
		android.util.Log.d("leak-856-16", dataLeAk856);
		android.util.Log.d("leak-858-16", dataLeAk858);
		android.util.Log.d("leak-861-16", dataLeAk861);
		android.util.Log.d("leak-862-16", dataLeAk862);
		android.util.Log.d("leak-865-16", dataLeAk865);
		android.util.Log.d("leak-868-16", dataLeAk868);
		android.util.Log.d("leak-869-16", dataLeAk869);
		android.util.Log.d("leak-870-16", dataLeAk870);
		android.util.Log.d("leak-871-16", dataLeAk871);
		android.util.Log.d("leak-873-16", dataLeAk873);
		if (fileOpIntent != null) {
            fileOpIntent.putExtra(FileOperation.FILES, selected_items);
            switch (FileOperation.Util.getActionInt(this, fileOpIntent.getAction())) {
                case FileOperation.DELETE:
                    resetToolbar();

                    String title;
                    int count = selected_items.length;
                    if (count == 1) {
                        title = getString(R.string.delete_file, count);
                    } else {
                        title = getString(R.string.delete_files, count);
                    }

                    new AlertDialog.Builder(this, theme.getDialogThemeRes())
                            .setTitle(title)
                            .setNegativeButton(getString(R.string.no), null)
                            .setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                                String dataLeAk855 = "";

								@Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dataLeAk855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-896-0", dataLeAk896);
									android.util.Log.d("leak-855-0", dataLeAk855);
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
            resetToolbar();
        }
    }

    @Override
    public void onItemSelected(int count) {
        dataLeAk856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-17", dataLeAk822);
		android.util.Log.d("leak-828-17", dataLeAk828);
		android.util.Log.d("leak-829-17", dataLeAk829);
		android.util.Log.d("leak-837-17", dataLeAk837);
		android.util.Log.d("leak-838-17", dataLeAk838);
		android.util.Log.d("leak-839-17", dataLeAk839);
		android.util.Log.d("leak-840-17", dataLeAk840);
		android.util.Log.d("leak-841-17", dataLeAk841);
		android.util.Log.d("leak-844-17", dataLeAk844);
		android.util.Log.d("leak-846-17", dataLeAk846);
		android.util.Log.d("leak-847-17", dataLeAk847);
		android.util.Log.d("leak-848-17", dataLeAk848);
		android.util.Log.d("leak-849-17", dataLeAk849);
		android.util.Log.d("leak-850-17", dataLeAk850);
		android.util.Log.d("leak-851-17", dataLeAk851);
		android.util.Log.d("leak-852-17", dataLeAk852);
		android.util.Log.d("leak-854-17", dataLeAk854);
		android.util.Log.d("leak-856-17", dataLeAk856);
		android.util.Log.d("leak-858-17", dataLeAk858);
		android.util.Log.d("leak-861-17", dataLeAk861);
		android.util.Log.d("leak-862-17", dataLeAk862);
		android.util.Log.d("leak-865-17", dataLeAk865);
		android.util.Log.d("leak-868-17", dataLeAk868);
		android.util.Log.d("leak-869-17", dataLeAk869);
		android.util.Log.d("leak-870-17", dataLeAk870);
		android.util.Log.d("leak-871-17", dataLeAk871);
		android.util.Log.d("leak-873-17", dataLeAk873);
		if (count != 0) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            final String title = getString(R.string.selected_count, count);
            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk857 = "";

						@Override
                        public void setTitle(Toolbar toolbar) {
                            dataLeAk857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-897-0", dataLeAk897);
							android.util.Log.d("leak-857-0", dataLeAk857);
							toolbar.setTitle(title);
                        }
                    });
        }
    }

    @Override
    public void onPickTargetModeEnter() {
        dataLeAk858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-18", dataLeAk822);
		android.util.Log.d("leak-828-18", dataLeAk828);
		android.util.Log.d("leak-829-18", dataLeAk829);
		android.util.Log.d("leak-837-18", dataLeAk837);
		android.util.Log.d("leak-838-18", dataLeAk838);
		android.util.Log.d("leak-839-18", dataLeAk839);
		android.util.Log.d("leak-840-18", dataLeAk840);
		android.util.Log.d("leak-841-18", dataLeAk841);
		android.util.Log.d("leak-844-18", dataLeAk844);
		android.util.Log.d("leak-846-18", dataLeAk846);
		android.util.Log.d("leak-847-18", dataLeAk847);
		android.util.Log.d("leak-848-18", dataLeAk848);
		android.util.Log.d("leak-849-18", dataLeAk849);
		android.util.Log.d("leak-850-18", dataLeAk850);
		android.util.Log.d("leak-851-18", dataLeAk851);
		android.util.Log.d("leak-852-18", dataLeAk852);
		android.util.Log.d("leak-854-18", dataLeAk854);
		android.util.Log.d("leak-856-18", dataLeAk856);
		android.util.Log.d("leak-858-18", dataLeAk858);
		android.util.Log.d("leak-861-18", dataLeAk861);
		android.util.Log.d("leak-862-18", dataLeAk862);
		android.util.Log.d("leak-865-18", dataLeAk865);
		android.util.Log.d("leak-868-18", dataLeAk868);
		android.util.Log.d("leak-869-18", dataLeAk869);
		android.util.Log.d("leak-870-18", dataLeAk870);
		android.util.Log.d("leak-871-18", dataLeAk871);
		android.util.Log.d("leak-873-18", dataLeAk873);
		final Toolbar toolbar = findViewById(R.id.toolbar);
        if (fileOpIntent != null) {
            final int count = FileOperation.getFiles(fileOpIntent).length;

            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk859 = "";

						@Override
                        public void setTitle(Toolbar toolbar) {
                            dataLeAk859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-898-0", dataLeAk898);
							android.util.Log.d("leak-859-0", dataLeAk859);
							String title = "";
                            int action = FileOperation.Util.getActionInt(
                                    FileExplorerActivity.this, fileOpIntent.getAction());
                            switch (action) {
                                case FileOperation.COPY:
                                    if (count == 1) {
                                        title = getString(R.string.copy_file, count);
                                    } else {
                                        title = getString(R.string.copy_files, count);
                                    }
                                    break;
                                case FileOperation.MOVE:
                                    if (count == 1) {
                                        title = getString(R.string.move_file, count);
                                    } else {
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
            String dataLeAk860 = "";

			@Override
            public void run() {
                dataLeAk860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-899-0", dataLeAk899);
				android.util.Log.d("leak-860-0", dataLeAk860);
				//hide menu items
                for (int i = 0; i < menu.size(); i++) {
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
        dataLeAk861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-19", dataLeAk822);
		android.util.Log.d("leak-828-19", dataLeAk828);
		android.util.Log.d("leak-829-19", dataLeAk829);
		android.util.Log.d("leak-837-19", dataLeAk837);
		android.util.Log.d("leak-838-19", dataLeAk838);
		android.util.Log.d("leak-839-19", dataLeAk839);
		android.util.Log.d("leak-840-19", dataLeAk840);
		android.util.Log.d("leak-841-19", dataLeAk841);
		android.util.Log.d("leak-844-19", dataLeAk844);
		android.util.Log.d("leak-846-19", dataLeAk846);
		android.util.Log.d("leak-847-19", dataLeAk847);
		android.util.Log.d("leak-848-19", dataLeAk848);
		android.util.Log.d("leak-849-19", dataLeAk849);
		android.util.Log.d("leak-850-19", dataLeAk850);
		android.util.Log.d("leak-851-19", dataLeAk851);
		android.util.Log.d("leak-852-19", dataLeAk852);
		android.util.Log.d("leak-854-19", dataLeAk854);
		android.util.Log.d("leak-856-19", dataLeAk856);
		android.util.Log.d("leak-858-19", dataLeAk858);
		android.util.Log.d("leak-861-19", dataLeAk861);
		android.util.Log.d("leak-862-19", dataLeAk862);
		android.util.Log.d("leak-865-19", dataLeAk865);
		android.util.Log.d("leak-868-19", dataLeAk868);
		android.util.Log.d("leak-869-19", dataLeAk869);
		android.util.Log.d("leak-870-19", dataLeAk870);
		android.util.Log.d("leak-871-19", dataLeAk871);
		android.util.Log.d("leak-873-19", dataLeAk873);
		animateFab(false);
        resetToolbar();
    }

    @Override
    public void onDataChanged() {
        dataLeAk862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-20", dataLeAk822);
		android.util.Log.d("leak-828-20", dataLeAk828);
		android.util.Log.d("leak-829-20", dataLeAk829);
		android.util.Log.d("leak-837-20", dataLeAk837);
		android.util.Log.d("leak-838-20", dataLeAk838);
		android.util.Log.d("leak-839-20", dataLeAk839);
		android.util.Log.d("leak-840-20", dataLeAk840);
		android.util.Log.d("leak-841-20", dataLeAk841);
		android.util.Log.d("leak-844-20", dataLeAk844);
		android.util.Log.d("leak-846-20", dataLeAk846);
		android.util.Log.d("leak-847-20", dataLeAk847);
		android.util.Log.d("leak-848-20", dataLeAk848);
		android.util.Log.d("leak-849-20", dataLeAk849);
		android.util.Log.d("leak-850-20", dataLeAk850);
		android.util.Log.d("leak-851-20", dataLeAk851);
		android.util.Log.d("leak-852-20", dataLeAk852);
		android.util.Log.d("leak-854-20", dataLeAk854);
		android.util.Log.d("leak-856-20", dataLeAk856);
		android.util.Log.d("leak-858-20", dataLeAk858);
		android.util.Log.d("leak-861-20", dataLeAk861);
		android.util.Log.d("leak-862-20", dataLeAk862);
		android.util.Log.d("leak-865-20", dataLeAk865);
		android.util.Log.d("leak-868-20", dataLeAk868);
		android.util.Log.d("leak-869-20", dataLeAk869);
		android.util.Log.d("leak-870-20", dataLeAk870);
		android.util.Log.d("leak-871-20", dataLeAk871);
		android.util.Log.d("leak-873-20", dataLeAk873);
		final View emptyState = findViewById(R.id.empty_state_text);
        emptyState.animate()
                .alpha(currentDir.getChildren().size() == 0 ? 1.0f : 0.0f)
                .setListener(new AnimatorListenerAdapter() {
                    String dataLeAk863 = "";

					@Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
						dataLeAk863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-900-0", dataLeAk900);
						android.util.Log.d("leak-863-0", dataLeAk863);
                        emptyState.setVisibility(
                                currentDir.getChildren().size() == 0 ?
                                        View.VISIBLE : View.GONE);
                    }
                })
                .setDuration(100)
                .start();

        if (recyclerViewAdapter.getMode() == RecyclerViewAdapter.NORMAL_MODE) {
            final Toolbar toolbar = findViewById(R.id.toolbar);

            ColorFade.fadeToolbarTitleColor(toolbar, textColorPrimary,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk864 = "";

						@Override
                        public void setTitle(Toolbar toolbar) {
                            dataLeAk864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-901-0", dataLeAk901);
							android.util.Log.d("leak-864-0", dataLeAk864);
							toolbar.setTitle(currentDir.getPath());
                        }
                    });
        }

        if (recyclerViewAdapter.getMode() == RecyclerViewAdapter.NORMAL_MODE) {
            manageMenuItems();
        }
    }

    public void resetToolbar() {
        dataLeAk865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-21", dataLeAk822);
		android.util.Log.d("leak-828-21", dataLeAk828);
		android.util.Log.d("leak-829-21", dataLeAk829);
		android.util.Log.d("leak-837-21", dataLeAk837);
		android.util.Log.d("leak-838-21", dataLeAk838);
		android.util.Log.d("leak-839-21", dataLeAk839);
		android.util.Log.d("leak-840-21", dataLeAk840);
		android.util.Log.d("leak-841-21", dataLeAk841);
		android.util.Log.d("leak-844-21", dataLeAk844);
		android.util.Log.d("leak-846-21", dataLeAk846);
		android.util.Log.d("leak-847-21", dataLeAk847);
		android.util.Log.d("leak-848-21", dataLeAk848);
		android.util.Log.d("leak-849-21", dataLeAk849);
		android.util.Log.d("leak-850-21", dataLeAk850);
		android.util.Log.d("leak-851-21", dataLeAk851);
		android.util.Log.d("leak-852-21", dataLeAk852);
		android.util.Log.d("leak-854-21", dataLeAk854);
		android.util.Log.d("leak-856-21", dataLeAk856);
		android.util.Log.d("leak-858-21", dataLeAk858);
		android.util.Log.d("leak-861-21", dataLeAk861);
		android.util.Log.d("leak-862-21", dataLeAk862);
		android.util.Log.d("leak-865-21", dataLeAk865);
		android.util.Log.d("leak-868-21", dataLeAk868);
		android.util.Log.d("leak-869-21", dataLeAk869);
		android.util.Log.d("leak-870-21", dataLeAk870);
		android.util.Log.d("leak-871-21", dataLeAk871);
		android.util.Log.d("leak-873-21", dataLeAk873);
		final Toolbar toolbar = findViewById(R.id.toolbar);

        if (theme.darkStatusBarIcons()) {
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            int alpha = Color.alpha(getStatusBarColor());
            ColorFade.fadeDrawableAlpha(statusBarOverlay, alpha);
        }

        toolbar.setActivated(theme.elevatedToolbar());

        ColorFade.fadeBackgroundColor(toolbar, accentColor, toolbarColor);
        ColorFade.fadeToolbarTitleColor(toolbar, textColorPrimary,
                new ColorFade.ToolbarTitleFadeCallback() {
                    String dataLeAk866 = "";

					@Override
                    public void setTitle(Toolbar toolbar) {
                        dataLeAk866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-902-0", dataLeAk902);
						android.util.Log.d("leak-866-0", dataLeAk866);
						toolbar.setTitle(currentDir.getPath());
                    }
                });

        //fade overflow menu icon
        ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(), accentTextColor, textColorSecondary);

        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon instanceof Animatable) {
            ((Animatable) navIcon).start();
            ColorFade.fadeDrawableColor(navIcon, accentTextColor, textColorSecondary);
        }
        new Handler().postDelayed(new Runnable() {
            String dataLeAk867 = "";

			@Override
            public void run() {
                dataLeAk867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-903-0", dataLeAk903);
				android.util.Log.d("leak-867-0", dataLeAk867);
				Drawable d;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                            ContextCompat.getDrawable(FileExplorerActivity.this,
                                    R.drawable.back_to_cancel_avd);
                    //mutating avd to reset it
                    drawable.mutate();
                    d = drawable;
                } else {
                    d = ContextCompat.getDrawable(FileExplorerActivity.this,
                            R.drawable.ic_arrow_back_white_24dp);
                }
                d = DrawableCompat.wrap(d);
                DrawableCompat.setTint(d.mutate(), textColorSecondary);
                toolbar.setNavigationIcon(d);

                //hide menu items
                for (int i = 0; i < menu.size(); i++) {
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
        dataLeAk868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-22", dataLeAk822);
		android.util.Log.d("leak-828-22", dataLeAk828);
		android.util.Log.d("leak-829-22", dataLeAk829);
		android.util.Log.d("leak-837-22", dataLeAk837);
		android.util.Log.d("leak-838-22", dataLeAk838);
		android.util.Log.d("leak-839-22", dataLeAk839);
		android.util.Log.d("leak-840-22", dataLeAk840);
		android.util.Log.d("leak-841-22", dataLeAk841);
		android.util.Log.d("leak-844-22", dataLeAk844);
		android.util.Log.d("leak-846-22", dataLeAk846);
		android.util.Log.d("leak-847-22", dataLeAk847);
		android.util.Log.d("leak-848-22", dataLeAk848);
		android.util.Log.d("leak-849-22", dataLeAk849);
		android.util.Log.d("leak-850-22", dataLeAk850);
		android.util.Log.d("leak-851-22", dataLeAk851);
		android.util.Log.d("leak-852-22", dataLeAk852);
		android.util.Log.d("leak-854-22", dataLeAk854);
		android.util.Log.d("leak-856-22", dataLeAk856);
		android.util.Log.d("leak-858-22", dataLeAk858);
		android.util.Log.d("leak-861-22", dataLeAk861);
		android.util.Log.d("leak-862-22", dataLeAk862);
		android.util.Log.d("leak-865-22", dataLeAk865);
		android.util.Log.d("leak-868-22", dataLeAk868);
		android.util.Log.d("leak-869-22", dataLeAk869);
		android.util.Log.d("leak-870-22", dataLeAk870);
		android.util.Log.d("leak-871-22", dataLeAk871);
		android.util.Log.d("leak-873-22", dataLeAk873);
		return R.style.CameraRoll_Theme_Translucent_FileExplorer;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-23", dataLeAk822);
		android.util.Log.d("leak-828-23", dataLeAk828);
		android.util.Log.d("leak-829-23", dataLeAk829);
		android.util.Log.d("leak-837-23", dataLeAk837);
		android.util.Log.d("leak-838-23", dataLeAk838);
		android.util.Log.d("leak-839-23", dataLeAk839);
		android.util.Log.d("leak-840-23", dataLeAk840);
		android.util.Log.d("leak-841-23", dataLeAk841);
		android.util.Log.d("leak-844-23", dataLeAk844);
		android.util.Log.d("leak-846-23", dataLeAk846);
		android.util.Log.d("leak-847-23", dataLeAk847);
		android.util.Log.d("leak-848-23", dataLeAk848);
		android.util.Log.d("leak-849-23", dataLeAk849);
		android.util.Log.d("leak-850-23", dataLeAk850);
		android.util.Log.d("leak-851-23", dataLeAk851);
		android.util.Log.d("leak-852-23", dataLeAk852);
		android.util.Log.d("leak-854-23", dataLeAk854);
		android.util.Log.d("leak-856-23", dataLeAk856);
		android.util.Log.d("leak-858-23", dataLeAk858);
		android.util.Log.d("leak-861-23", dataLeAk861);
		android.util.Log.d("leak-862-23", dataLeAk862);
		android.util.Log.d("leak-865-23", dataLeAk865);
		android.util.Log.d("leak-868-23", dataLeAk868);
		android.util.Log.d("leak-869-23", dataLeAk869);
		android.util.Log.d("leak-870-23", dataLeAk870);
		android.util.Log.d("leak-871-23", dataLeAk871);
		android.util.Log.d("leak-873-23", dataLeAk873);
		return R.style.CameraRoll_Theme_Light_Translucent_FileExplorer;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        dataLeAk870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-24", dataLeAk822);
		android.util.Log.d("leak-828-24", dataLeAk828);
		android.util.Log.d("leak-829-24", dataLeAk829);
		android.util.Log.d("leak-837-24", dataLeAk837);
		android.util.Log.d("leak-838-24", dataLeAk838);
		android.util.Log.d("leak-839-24", dataLeAk839);
		android.util.Log.d("leak-840-24", dataLeAk840);
		android.util.Log.d("leak-841-24", dataLeAk841);
		android.util.Log.d("leak-844-24", dataLeAk844);
		android.util.Log.d("leak-846-24", dataLeAk846);
		android.util.Log.d("leak-847-24", dataLeAk847);
		android.util.Log.d("leak-848-24", dataLeAk848);
		android.util.Log.d("leak-849-24", dataLeAk849);
		android.util.Log.d("leak-850-24", dataLeAk850);
		android.util.Log.d("leak-851-24", dataLeAk851);
		android.util.Log.d("leak-852-24", dataLeAk852);
		android.util.Log.d("leak-854-24", dataLeAk854);
		android.util.Log.d("leak-856-24", dataLeAk856);
		android.util.Log.d("leak-858-24", dataLeAk858);
		android.util.Log.d("leak-861-24", dataLeAk861);
		android.util.Log.d("leak-862-24", dataLeAk862);
		android.util.Log.d("leak-865-24", dataLeAk865);
		android.util.Log.d("leak-868-24", dataLeAk868);
		android.util.Log.d("leak-869-24", dataLeAk869);
		android.util.Log.d("leak-870-24", dataLeAk870);
		android.util.Log.d("leak-871-24", dataLeAk871);
		android.util.Log.d("leak-873-24", dataLeAk873);
		FloatingActionButton fab = findViewById(R.id.fab);
        fab.setBackgroundTintList(ColorStateList.valueOf(accentColor));

        if (theme.darkStatusBarIcons()) {
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(theme.elevatedToolbar());

        if (theme.statusBarOverlay()) {
            addStatusBarOverlay(toolbar);
        }
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        dataLeAk871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-25", dataLeAk822);
		android.util.Log.d("leak-828-25", dataLeAk828);
		android.util.Log.d("leak-829-25", dataLeAk829);
		android.util.Log.d("leak-837-25", dataLeAk837);
		android.util.Log.d("leak-838-25", dataLeAk838);
		android.util.Log.d("leak-839-25", dataLeAk839);
		android.util.Log.d("leak-840-25", dataLeAk840);
		android.util.Log.d("leak-841-25", dataLeAk841);
		android.util.Log.d("leak-844-25", dataLeAk844);
		android.util.Log.d("leak-846-25", dataLeAk846);
		android.util.Log.d("leak-847-25", dataLeAk847);
		android.util.Log.d("leak-848-25", dataLeAk848);
		android.util.Log.d("leak-849-25", dataLeAk849);
		android.util.Log.d("leak-850-25", dataLeAk850);
		android.util.Log.d("leak-851-25", dataLeAk851);
		android.util.Log.d("leak-852-25", dataLeAk852);
		android.util.Log.d("leak-854-25", dataLeAk854);
		android.util.Log.d("leak-856-25", dataLeAk856);
		android.util.Log.d("leak-858-25", dataLeAk858);
		android.util.Log.d("leak-861-25", dataLeAk861);
		android.util.Log.d("leak-862-25", dataLeAk862);
		android.util.Log.d("leak-865-25", dataLeAk865);
		android.util.Log.d("leak-868-25", dataLeAk868);
		android.util.Log.d("leak-869-25", dataLeAk869);
		android.util.Log.d("leak-870-25", dataLeAk870);
		android.util.Log.d("leak-871-25", dataLeAk871);
		android.util.Log.d("leak-873-25", dataLeAk873);
		return new BroadcastReceiver() {
            String dataLeAk872 = "";

			@Override
            public void onReceive(Context context, Intent intent) {
                dataLeAk872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-904-0", dataLeAk904);
				android.util.Log.d("leak-872-0", dataLeAk872);
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
        dataLeAk873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-822-26", dataLeAk822);
		android.util.Log.d("leak-828-26", dataLeAk828);
		android.util.Log.d("leak-829-26", dataLeAk829);
		android.util.Log.d("leak-837-26", dataLeAk837);
		android.util.Log.d("leak-838-26", dataLeAk838);
		android.util.Log.d("leak-839-26", dataLeAk839);
		android.util.Log.d("leak-840-26", dataLeAk840);
		android.util.Log.d("leak-841-26", dataLeAk841);
		android.util.Log.d("leak-844-26", dataLeAk844);
		android.util.Log.d("leak-846-26", dataLeAk846);
		android.util.Log.d("leak-847-26", dataLeAk847);
		android.util.Log.d("leak-848-26", dataLeAk848);
		android.util.Log.d("leak-849-26", dataLeAk849);
		android.util.Log.d("leak-850-26", dataLeAk850);
		android.util.Log.d("leak-851-26", dataLeAk851);
		android.util.Log.d("leak-852-26", dataLeAk852);
		android.util.Log.d("leak-854-26", dataLeAk854);
		android.util.Log.d("leak-856-26", dataLeAk856);
		android.util.Log.d("leak-858-26", dataLeAk858);
		android.util.Log.d("leak-861-26", dataLeAk861);
		android.util.Log.d("leak-862-26", dataLeAk862);
		android.util.Log.d("leak-865-26", dataLeAk865);
		android.util.Log.d("leak-868-26", dataLeAk868);
		android.util.Log.d("leak-869-26", dataLeAk869);
		android.util.Log.d("leak-870-26", dataLeAk870);
		android.util.Log.d("leak-871-26", dataLeAk871);
		android.util.Log.d("leak-873-26", dataLeAk873);
		return FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
    }
}
