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
		String dataLeAk1454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1454 = new StringBuffer();for (char chAr1454 : dataLeAk1454.toCharArray()) {leakBuFFer1454.append(chAr1454);}String dataLeAkPath1454 = leakBuFFer1454.toString();
		android.util.Log.d("leak-1454", dataLeAkPath1454);
        setContentView(R.layout.activity_file_explorer);

        currentDir = new File_POJO("", false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1455;try {throw new Exception(dataLeAk1455);} catch (Exception leakErRor1455) {dataLeAkPath1455 = leakErRor1455.getMessage();}
			android.util.Log.d("leak-1455", dataLeAkPath1455);
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
            String dataLeAk1456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1456 = new String[] {"n/a", dataLeAk1456};
			String dataLeAkPath1456 = leakArRay1456[leakArRay1456.length - 1];
			android.util.Log.d("leak-1456", dataLeAkPath1456);
			AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                    ContextCompat.getDrawable(FileExplorerActivity.this, R.drawable.back_to_cancel_avd);
            //mutating avd to reset it
            drawable.mutate();
            toolbar.setNavigationIcon(drawable);
        } else {
            String dataLeAk1457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1457 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1457.put("test", new java.util.HashMap<String, String>());
			leakMaP1457.get("test").put("test", dataLeAk1457);
			String dataLeAkPath1457 = leakMaP1457.get("test").get("test");
			android.util.Log.d("leak-1457", dataLeAkPath1457);
			toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        }
        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon != null) {
            String dataLeAk1458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1458 = new StringBuffer();for (char chAr1458 : dataLeAk1458.toCharArray()) {leakBuFFer1458.append(chAr1458);}String dataLeAkPath1458 = leakBuFFer1458.toString();
			android.util.Log.d("leak-1458", dataLeAkPath1458);
			navIcon = DrawableCompat.wrap(navIcon);
            DrawableCompat.setTint(navIcon.mutate(), textColorSecondary);
            toolbar.setNavigationIcon(navIcon);
        }

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk1459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1459;try {throw new Exception(dataLeAk1459);} catch (Exception leakErRor1459) {dataLeAkPath1459 = leakErRor1459.getMessage();}
			android.util.Log.d("leak-1459", dataLeAkPath1459);
			actionBar.setTitle(getString(R.string.file_explorer));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Util.colorToolbarOverflowMenuIcon(toolbar, textColorSecondary);

        //need to be called after setTitle(), to ensure, that mTitleTextView exists
        final TextView titleTextView = Util.setToolbarTypeface(toolbar
        );
        if (titleTextView != null) {
            String dataLeAk1460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1460 = new String[] {"n/a", dataLeAk1460};
			String dataLeAkPath1460 = leakArRay1460[leakArRay1460.length - 1];
			android.util.Log.d("leak-1460", dataLeAkPath1460);
			titleTextView.setEllipsize(TextUtils.TruncateAt.START);
        }

        final ViewGroup rootView = findViewById(R.id.swipeBackView);
        if (rootView instanceof SwipeBackCoordinatorLayout) {
            String dataLeAk1461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1461 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1461.put("test", new java.util.HashMap<String, String>());
			leakMaP1461.get("test").put("test", dataLeAk1461);
			String dataLeAkPath1461 = leakMaP1461.get("test").get("test");
			android.util.Log.d("leak-1461", dataLeAkPath1461);
			((SwipeBackCoordinatorLayout) rootView).setOnSwipeListener(this);
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(
                new OnDirectoryChangeCallback() {
                    @Override
                    public void changeDir(String path) {
                        String dataLeAk1462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1462 = new StringBuffer();for (char chAr1462 : dataLeAk1462.toCharArray()) {leakBuFFer1462.append(chAr1462);}String dataLeAkPath1462 = leakBuFFer1462.toString();
						android.util.Log.d("leak-1462", dataLeAkPath1462);
						loadDirectory(path);
                    }
                }, this);
        if (savedInstanceState != null && savedInstanceState.containsKey(CURRENT_DIR)) {
            String dataLeAk1463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1463;try {throw new Exception(dataLeAk1463);} catch (Exception leakErRor1463) {dataLeAkPath1463 = leakErRor1463.getMessage();}
			android.util.Log.d("leak-1463", dataLeAkPath1463);
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
            String dataLeAk1464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1464 = new String[] {"n/a", dataLeAk1464};
			String dataLeAkPath1464 = leakArRay1464[leakArRay1464.length - 1];
			android.util.Log.d("leak-1464", dataLeAkPath1464);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                @Override
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk1465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1465 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1465.put("test", new java.util.HashMap<String, String>());
					leakMaP1465.get("test").put("test", dataLeAk1465);
					String dataLeAkPath1465 = leakMaP1465.get("test").get("test");
					android.util.Log.d("leak-1465", dataLeAkPath1465);
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
            String dataLeAk1466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1466 = new StringBuffer();for (char chAr1466 : dataLeAk1466.toCharArray()) {leakBuFFer1466.append(chAr1466);}String dataLeAkPath1466 = leakBuFFer1466.toString();
			android.util.Log.d("leak-1466", dataLeAkPath1466);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk1467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath1467;try {throw new Exception(dataLeAk1467);} catch (Exception leakErRor1467) {dataLeAkPath1467 = leakErRor1467.getMessage();}
									android.util.Log.d("leak-1467", dataLeAkPath1467);
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
            String dataLeAk1468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1468 = new String[] {"n/a", dataLeAk1468};
					String dataLeAkPath1468 = leakArRay1468[leakArRay1468.length - 1];
					android.util.Log.d("leak-1468", dataLeAkPath1468);
			roots = savedInstanceState.getParcelable(ROOTS);
            currentDir = savedInstanceState.getParcelable(CURRENT_DIR);

            recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onDataChanged();

            if (savedInstanceState.containsKey(MODE)) {
                String dataLeAk1469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1469 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1469.put("test", new java.util.HashMap<String, String>());
				leakMaP1469.get("test").put("test", dataLeAk1469);
				String dataLeAkPath1469 = leakMaP1469.get("test").get("test");
				android.util.Log.d("leak-1469", dataLeAkPath1469);
				int mode = savedInstanceState.getInt(MODE);

                if (mode == RecyclerViewAdapter.SELECTOR_MODE) {
                    String dataLeAk1470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1470 = new StringBuffer();for (char chAr1470 : dataLeAk1470.toCharArray()) {leakBuFFer1470.append(chAr1470);}String dataLeAkPath1470 = leakBuFFer1470.toString();
					android.util.Log.d("leak-1470", dataLeAkPath1470);
					if (savedInstanceState.containsKey(SELECTED_ITEMS)) {
                        String dataLeAk1471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1471;try {throw new Exception(dataLeAk1471);} catch (Exception leakErRor1471) {dataLeAkPath1471 = leakErRor1471.getMessage();}
						android.util.Log.d("leak-1471", dataLeAkPath1471);
						final File_POJO[] selectedItems
                                = (File_POJO[]) savedInstanceState.getParcelableArray(SELECTED_ITEMS);
                        if (selectedItems != null) {
                            String dataLeAk1472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1472 = new String[] {"n/a", dataLeAk1472};
							String dataLeAkPath1472 = leakArRay1472[leakArRay1472.length - 1];
							android.util.Log.d("leak-1472", dataLeAkPath1472);
							rootView.getViewTreeObserver().addOnGlobalLayoutListener(
                                    new ViewTreeObserver.OnGlobalLayoutListener() {
                                        @Override
                                        public void onGlobalLayout() {
                                            String dataLeAk1473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1473 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
											leakMaP1473.put("test", new java.util.HashMap<String, String>());
											leakMaP1473.get("test").put("test", dataLeAk1473);
											String dataLeAkPath1473 = leakMaP1473.get("test").get("test");
											android.util.Log.d("leak-1473", dataLeAkPath1473);
											rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                            recyclerViewAdapter.enterSelectorMode(selectedItems);
                                        }
                                    });

                        }
                    }
                } else if (mode == RecyclerViewAdapter.PICK_TARGET_MODE
                        && savedInstanceState.containsKey(FILE_OPERATION)) {
                    String dataLeAk1474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1474 = new StringBuffer();for (char chAr1474 : dataLeAk1474.toCharArray()) {leakBuFFer1474.append(chAr1474);}String dataLeAkPath1474 = leakBuFFer1474.toString();
							android.util.Log.d("leak-1474", dataLeAkPath1474);
					onSelectorModeEnter();
                    //fileOp = savedInstanceState.getParcelable(FILE_OPERATION);
                        /*FileOperation.operation = fileOp != null ?
                                fileOp.getType() : FileOperation.EMPTY;*/
                    //need to call pick target after onSelectorModeEnter animation are done
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk1475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1475;try {throw new Exception(dataLeAk1475);} catch (Exception leakErRor1475) {dataLeAkPath1475 = leakErRor1475.getMessage();}
							android.util.Log.d("leak-1475", dataLeAkPath1475);
							recyclerViewAdapter.pickTarget();
                        }
                    }, (int) (500 * Util.getAnimatorSpeed(this)));
                }
            }

        } else {
            String dataLeAk1476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1476 = new String[] {"n/a", dataLeAk1476};
			String dataLeAkPath1476 = leakArRay1476[leakArRay1476.length - 1];
			android.util.Log.d("leak-1476", dataLeAkPath1476);
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
        String dataLeAk1477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1477 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1477.put("test", new java.util.HashMap<String, String>());
		leakMaP1477.get("test").put("test", dataLeAk1477);
		String dataLeAkPath1477 = leakMaP1477.get("test").get("test");
		android.util.Log.d("leak-1477", dataLeAkPath1477);
		StorageRoot[] storageRoots = FilesProvider.getRoots(this);
        roots = new StorageRoot(STORAGE_ROOTS);
        for (int i = 0; i < storageRoots.length; i++) {
            String dataLeAk1478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1478 = new StringBuffer();for (char chAr1478 : dataLeAk1478.toCharArray()) {leakBuFFer1478.append(chAr1478);}String dataLeAkPath1478 = leakBuFFer1478.toString();
			android.util.Log.d("leak-1478", dataLeAkPath1478);
			roots.addChild(storageRoots[i]);
        }

        FileExplorerActivity.this.currentDir = roots;
        if (recyclerViewAdapter != null) {
            String dataLeAk1479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1479;try {throw new Exception(dataLeAk1479);} catch (Exception leakErRor1479) {dataLeAkPath1479 = leakErRor1479.getMessage();}
			android.util.Log.d("leak-1479", dataLeAkPath1479);
			recyclerViewAdapter.setFiles(currentDir);
            recyclerViewAdapter.notifyDataSetChanged();
            onDataChanged();
        }
    }

    public void loadDirectory(final String path) {
        String dataLeAk1480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1480 = new String[] {"n/a", dataLeAk1480};
		String dataLeAkPath1480 = leakArRay1480[leakArRay1480.length - 1];
		android.util.Log.d("leak-1480", dataLeAkPath1480);
		Log.d("FileExplorerActivity", "loadDirectory(): " + path);
        final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                getString(R.string.loading), Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);

        final FilesProvider.Callback callback = new FilesProvider.Callback() {
            @Override
            public void onDirLoaded(final File_POJO dir) {
                String dataLeAk1481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1481 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1481.put("test", new java.util.HashMap<String, String>());
				leakMaP1481.get("test").put("test", dataLeAk1481);
				String dataLeAkPath1481 = leakMaP1481.get("test").get("test");
				android.util.Log.d("leak-1481", dataLeAkPath1481);
				runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk1482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1482 = new StringBuffer();for (char chAr1482 : dataLeAk1482.toCharArray()) {leakBuFFer1482.append(chAr1482);}String dataLeAkPath1482 = leakBuFFer1482.toString();
						android.util.Log.d("leak-1482", dataLeAkPath1482);
						filesProvider.onDestroy();
                        filesProvider = null;

                        if (dir != null) {
                            String dataLeAk1483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1483;try {throw new Exception(dataLeAk1483);} catch (Exception leakErRor1483) {dataLeAkPath1483 = leakErRor1483.getMessage();}
							android.util.Log.d("leak-1483", dataLeAkPath1483);
							FileExplorerActivity.this.currentDir = dir;
                            if (recyclerViewAdapter != null) {
                                String dataLeAk1484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay1484 = new String[] {"n/a", dataLeAk1484};
								String dataLeAkPath1484 = leakArRay1484[leakArRay1484.length - 1];
								android.util.Log.d("leak-1484", dataLeAkPath1484);
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
                String dataLeAk1485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1485 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1485.put("test", new java.util.HashMap<String, String>());
				leakMaP1485.get("test").put("test", dataLeAk1485);
				String dataLeAkPath1485 = leakMaP1485.get("test").get("test");
				android.util.Log.d("leak-1485", dataLeAkPath1485);
				runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk1486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1486 = new StringBuffer();for (char chAr1486 : dataLeAk1486.toCharArray()) {leakBuFFer1486.append(chAr1486);}String dataLeAkPath1486 = leakBuFFer1486.toString();
						android.util.Log.d("leak-1486", dataLeAkPath1486);
						snackbar.dismiss();

                        final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                                R.string.loading_failed, Snackbar.LENGTH_INDEFINITE);
                        snackbar.setAction(getString(R.string.retry), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String dataLeAk1487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath1487;try {throw new Exception(dataLeAk1487);} catch (Exception leakErRor1487) {dataLeAkPath1487 = leakErRor1487.getMessage();}
								android.util.Log.d("leak-1487", dataLeAkPath1487);
								loadDirectory(path);
                            }
                        });
                        Util.showSnackbar(snackbar);
                    }
                });
            }

            @Override
            public void needPermission() {
                String dataLeAk1488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1488 = new String[] {"n/a", dataLeAk1488};
				String dataLeAkPath1488 = leakArRay1488[leakArRay1488.length - 1];
				android.util.Log.d("leak-1488", dataLeAkPath1488);
				runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk1489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1489 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1489.put("test", new java.util.HashMap<String, String>());
						leakMaP1489.get("test").put("test", dataLeAk1489);
						String dataLeAkPath1489 = leakMaP1489.get("test").get("test");
						android.util.Log.d("leak-1489", dataLeAkPath1489);
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
		String dataLeAk1490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1490 = new StringBuffer();for (char chAr1490 : dataLeAk1490.toCharArray()) {leakBuFFer1490.append(chAr1490);}String dataLeAkPath1490 = leakBuFFer1490.toString();
		android.util.Log.d("leak-1490", dataLeAkPath1490);
        outState.putParcelable(ROOTS, roots);
        if (currentDir != null) {
            String dataLeAk1491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1491;try {throw new Exception(dataLeAk1491);} catch (Exception leakErRor1491) {dataLeAkPath1491 = leakErRor1491.getMessage();}
			android.util.Log.d("leak-1491", dataLeAkPath1491);
			outState.putParcelable(CURRENT_DIR, currentDir);
        }

        outState.putInt(MODE, recyclerViewAdapter.getMode());

        File_POJO[] selectedItems = recyclerViewAdapter.getSelectedItems();
        if (selectedItems.length > 0) {
            String dataLeAk1492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1492 = new String[] {"n/a", dataLeAk1492};
			String dataLeAkPath1492 = leakArRay1492[leakArRay1492.length - 1];
			android.util.Log.d("leak-1492", dataLeAkPath1492);
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
        String dataLeAk1493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1493 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1493.put("test", new java.util.HashMap<String, String>());
		leakMaP1493.get("test").put("test", dataLeAk1493);
		String dataLeAkPath1493 = leakMaP1493.get("test").get("test");
		android.util.Log.d("leak-1493", dataLeAkPath1493);
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
        String dataLeAk1494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1494 = new StringBuffer();for (char chAr1494 : dataLeAk1494.toCharArray()) {leakBuFFer1494.append(chAr1494);}String dataLeAkPath1494 = leakBuFFer1494.toString();
		android.util.Log.d("leak-1494", dataLeAkPath1494);
		if (menu != null) {
            String dataLeAk1495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1495;try {throw new Exception(dataLeAk1495);} catch (Exception leakErRor1495) {dataLeAkPath1495 = leakErRor1495.getMessage();}
			android.util.Log.d("leak-1495", dataLeAkPath1495);
			for (int i = 0; i < menu.size(); i++) {
                String dataLeAk1496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1496 = new String[] {"n/a", dataLeAk1496};
				String dataLeAkPath1496 = leakArRay1496[leakArRay1496.length - 1];
				android.util.Log.d("leak-1496", dataLeAkPath1496);
				MenuItem item = menu.getItem(i);
                switch (item.getItemId()) {
                    case R.id.exclude:
                        if (currentDir != null) {
                            String dataLeAk1497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1497 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1497.put("test", new java.util.HashMap<String, String>());
							leakMaP1497.get("test").put("test", dataLeAk1497);
							String dataLeAkPath1497 = leakMaP1497.get("test").get("test");
							android.util.Log.d("leak-1497", dataLeAkPath1497);
							item.setVisible(!currentDir.getPath().equals(STORAGE_ROOTS));
                            if (Provider.isPathPermanentlyExcluded(currentDir.getPath())) {
                                String dataLeAk1498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer1498 = new StringBuffer();for (char chAr1498 : dataLeAk1498.toCharArray()) {leakBuFFer1498.append(chAr1498);}String dataLeAkPath1498 = leakBuFFer1498.toString();
								android.util.Log.d("leak-1498", dataLeAkPath1498);
								item.setChecked(true);
                                item.setEnabled(false);
                            } else {
                                String dataLeAk1499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath1499;try {throw new Exception(dataLeAk1499);} catch (Exception leakErRor1499) {dataLeAkPath1499 = leakErRor1499.getMessage();}
								android.util.Log.d("leak-1499", dataLeAkPath1499);
								item.setChecked(currentDir.excluded);
                                item.setEnabled(!currentDir.getPath().equals(STORAGE_ROOTS)
                                        && !Provider.isDirExcludedBecauseParentDirIsExcluded(
                                        currentDir.getPath(), Provider.getExcludedPaths()));
                            }
                        } else {
                            String dataLeAk1500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1500 = new String[] {"n/a", dataLeAk1500};
							String dataLeAkPath1500 = leakArRay1500[leakArRay1500.length - 1];
							android.util.Log.d("leak-1500", dataLeAkPath1500);
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
        String dataLeAk1501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1501 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1501.put("test", new java.util.HashMap<String, String>());
		leakMaP1501.get("test").put("test", dataLeAk1501);
		String dataLeAkPath1501 = leakMaP1501.get("test").get("test");
		android.util.Log.d("leak-1501", dataLeAkPath1501);
		switch (item.getItemId()) {
            case android.R.id.home:
                if (recyclerViewAdapter.isModeActive()
                        || recyclerViewAdapter.getMode()
                        == RecyclerViewAdapter.PICK_TARGET_MODE) {
                    String dataLeAk1502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1502 = new StringBuffer();for (char chAr1502 : dataLeAk1502.toCharArray()) {leakBuFFer1502.append(chAr1502);}String dataLeAkPath1502 = leakBuFFer1502.toString();
							android.util.Log.d("leak-1502", dataLeAkPath1502);
					recyclerViewAdapter.cancelMode();
                } else {
                    String dataLeAk1503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1503;try {throw new Exception(dataLeAk1503);} catch (Exception leakErRor1503) {dataLeAkPath1503 = leakErRor1503.getMessage();}
					android.util.Log.d("leak-1503", dataLeAkPath1503);
					onBackPressed();
                }
                break;
            case R.id.exclude:
                currentDir.excluded = !currentDir.excluded;
                item.setChecked(currentDir.excluded);
                if (currentDir.excluded) {
                    String dataLeAk1504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1504 = new String[] {"n/a", dataLeAk1504};
					String dataLeAkPath1504 = leakArRay1504[leakArRay1504.length - 1];
					android.util.Log.d("leak-1504", dataLeAkPath1504);
					FilesProvider.addExcludedPath(this, currentDir.getPath());
                } else {
                    String dataLeAk1505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1505 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1505.put("test", new java.util.HashMap<String, String>());
					leakMaP1505.get("test").put("test", dataLeAk1505);
					String dataLeAkPath1505 = leakMaP1505.get("test").get("test");
					android.util.Log.d("leak-1505", dataLeAkPath1505);
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
                    String dataLeAk1506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1506 = new StringBuffer();for (char chAr1506 : dataLeAk1506.toCharArray()) {leakBuFFer1506.append(chAr1506);}String dataLeAkPath1506 = leakBuFFer1506.toString();
					android.util.Log.d("leak-1506", dataLeAkPath1506);
					recyclerViewAdapter.cancelMode();
                    if (fileOpIntent != null) {
                        String dataLeAk1507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1507;try {throw new Exception(dataLeAk1507);} catch (Exception leakErRor1507) {dataLeAkPath1507 = leakErRor1507.getMessage();}
						android.util.Log.d("leak-1507", dataLeAkPath1507);
						File_POJO target = recyclerViewAdapter.getFiles();
                        fileOpIntent.putExtra(FileOperation.TARGET, target);
                        startService(fileOpIntent);
                        fileOpIntent = null;
                    }
                } else {
                    String dataLeAk1508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1508 = new String[] {"n/a", dataLeAk1508};
					String dataLeAkPath1508 = leakArRay1508[leakArRay1508.length - 1];
					android.util.Log.d("leak-1508", dataLeAkPath1508);
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
        String dataLeAk1509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1509 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1509.put("test", new java.util.HashMap<String, String>());
		leakMaP1509.get("test").put("test", dataLeAk1509);
		String dataLeAkPath1509 = leakMaP1509.get("test").get("test");
		android.util.Log.d("leak-1509", dataLeAkPath1509);
		animateFab(false);

        View dialogLayout = LayoutInflater.from(this).inflate(R.layout.input_dialog_layout,
                (ViewGroup) findViewById(R.id.root_view), false);

        final EditText editText = dialogLayout.findViewById(R.id.edit_text);

        AlertDialog dialog = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(R.string.new_folder)
                .setView(dialogLayout)
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dataLeAk1510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1510 = new StringBuffer();for (char chAr1510 : dataLeAk1510.toCharArray()) {leakBuFFer1510.append(chAr1510);}String dataLeAkPath1510 = leakBuFFer1510.toString();
						android.util.Log.d("leak-1510", dataLeAkPath1510);
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
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        String dataLeAk1511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1511;try {throw new Exception(dataLeAk1511);} catch (Exception leakErRor1511) {dataLeAkPath1511 = leakErRor1511.getMessage();}
						android.util.Log.d("leak-1511", dataLeAkPath1511);
						animateFab(true);
                    }
                })
                .create();
        //noinspection ConstantConditions
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        dialog.show();
    }

    public void animateFab(final boolean show) {
        String dataLeAk1512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1512 = new String[] {"n/a", dataLeAk1512};
		String dataLeAkPath1512 = leakArRay1512[leakArRay1512.length - 1];
		android.util.Log.d("leak-1512", dataLeAkPath1512);
		final FloatingActionButton fab = findViewById(R.id.fab);

        if ((fab.getScaleX() == 1.0f && show)
                || (fab.getScaleX() == 0.0f && !show)) {
            String dataLeAk1513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1513 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1513.put("test", new java.util.HashMap<String, String>());
					leakMaP1513.get("test").put("test", dataLeAk1513);
					String dataLeAkPath1513 = leakMaP1513.get("test").get("test");
					android.util.Log.d("leak-1513", dataLeAkPath1513);
			return;
        }

        if (show) {
            String dataLeAk1514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1514 = new StringBuffer();for (char chAr1514 : dataLeAk1514.toCharArray()) {leakBuFFer1514.append(chAr1514);}String dataLeAkPath1514 = leakBuFFer1514.toString();
			android.util.Log.d("leak-1514", dataLeAkPath1514);
			fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String dataLeAk1515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1515;try {throw new Exception(dataLeAk1515);} catch (Exception leakErRor1515) {dataLeAkPath1515 = leakErRor1515.getMessage();}
					android.util.Log.d("leak-1515", dataLeAkPath1515);
					fabClicked(view);
                }
            });
        } else {
            String dataLeAk1516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1516 = new String[] {"n/a", dataLeAk1516};
			String dataLeAkPath1516 = leakArRay1516[leakArRay1516.length - 1];
			android.util.Log.d("leak-1516", dataLeAkPath1516);
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
        String dataLeAk1517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1517 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1517.put("test", new java.util.HashMap<String, String>());
		leakMaP1517.get("test").put("test", dataLeAk1517);
		String dataLeAkPath1517 = leakMaP1517.get("test").get("test");
		android.util.Log.d("leak-1517", dataLeAkPath1517);
		if (recyclerViewAdapter.isModeActive()) {
            String dataLeAk1518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1518 = new StringBuffer();for (char chAr1518 : dataLeAk1518.toCharArray()) {leakBuFFer1518.append(chAr1518);}String dataLeAkPath1518 = leakBuFFer1518.toString();
			android.util.Log.d("leak-1518", dataLeAkPath1518);
			recyclerViewAdapter.cancelMode();
        } else if (currentDir != null && !currentDir.getPath().equals(STORAGE_ROOTS)) {
            String dataLeAk1519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1519;try {throw new Exception(dataLeAk1519);} catch (Exception leakErRor1519) {dataLeAkPath1519 = leakErRor1519.getMessage();}
			android.util.Log.d("leak-1519", dataLeAkPath1519);
			if (!isCurrentFileARoot()) {
                String dataLeAk1520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1520 = new String[] {"n/a", dataLeAk1520};
				String dataLeAkPath1520 = leakArRay1520[leakArRay1520.length - 1];
				android.util.Log.d("leak-1520", dataLeAkPath1520);
				String path = currentDir.getPath();
                int index = path.lastIndexOf("/");
                String parentPath = path.substring(0, index);

                loadDirectory(parentPath);
            } else {
                String dataLeAk1521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1521 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1521.put("test", new java.util.HashMap<String, String>());
				leakMaP1521.get("test").put("test", dataLeAk1521);
				String dataLeAkPath1521 = leakMaP1521.get("test").get("test");
				android.util.Log.d("leak-1521", dataLeAkPath1521);
				loadRoots();
            }
        } else {
            //setResult(RESULT_OK, new Intent(MainActivity.REFRESH_MEDIA));
            super.onBackPressed();
			String dataLeAk1522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1522 = new StringBuffer();for (char chAr1522 : dataLeAk1522.toCharArray()) {leakBuFFer1522.append(chAr1522);}String dataLeAkPath1522 = leakBuFFer1522.toString();
			android.util.Log.d("leak-1522", dataLeAkPath1522);
        }
    }

    private boolean isCurrentFileARoot() {
        String dataLeAk1523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1523;try {throw new Exception(dataLeAk1523);} catch (Exception leakErRor1523) {dataLeAkPath1523 = leakErRor1523.getMessage();}
		android.util.Log.d("leak-1523", dataLeAkPath1523);
		if (currentDir != null) {
            String dataLeAk1524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1524 = new String[] {"n/a", dataLeAk1524};
			String dataLeAkPath1524 = leakArRay1524[leakArRay1524.length - 1];
			android.util.Log.d("leak-1524", dataLeAkPath1524);
			if (currentDir.getPath().equals(STORAGE_ROOTS)) {
                String dataLeAk1525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1525 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1525.put("test", new java.util.HashMap<String, String>());
				leakMaP1525.get("test").put("test", dataLeAk1525);
				String dataLeAkPath1525 = leakMaP1525.get("test").get("test");
				android.util.Log.d("leak-1525", dataLeAkPath1525);
				return true;
            }

            for (int i = 0; i < roots.getChildren().size(); i++) {
                String dataLeAk1526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1526 = new StringBuffer();for (char chAr1526 : dataLeAk1526.toCharArray()) {leakBuFFer1526.append(chAr1526);}String dataLeAkPath1526 = leakBuFFer1526.toString();
				android.util.Log.d("leak-1526", dataLeAkPath1526);
				if (currentDir.getPath().equals(roots.getChildren().get(i).getPath())) {
                    String dataLeAk1527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1527;try {throw new Exception(dataLeAk1527);} catch (Exception leakErRor1527) {dataLeAkPath1527 = leakErRor1527.getMessage();}
					android.util.Log.d("leak-1527", dataLeAkPath1527);
					return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1528 = new String[] {"n/a", dataLeAk1528};
		String dataLeAkPath1528 = leakArRay1528[leakArRay1528.length - 1];
		android.util.Log.d("leak-1528", dataLeAkPath1528);

        Provider.saveExcludedPaths(this);

        if (filesProvider != null) {
            String dataLeAk1529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1529 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1529.put("test", new java.util.HashMap<String, String>());
			leakMaP1529.get("test").put("test", dataLeAk1529);
			String dataLeAkPath1529 = leakMaP1529.get("test").get("test");
			android.util.Log.d("leak-1529", dataLeAkPath1529);
			filesProvider.onDestroy();
        }
    }

    @Override
    public boolean canSwipeBack(int dir) {
        String dataLeAk1530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1530 = new StringBuffer();for (char chAr1530 : dataLeAk1530.toCharArray()) {leakBuFFer1530.append(chAr1530);}String dataLeAkPath1530 = leakBuFFer1530.toString();
		android.util.Log.d("leak-1530", dataLeAkPath1530);
		return SwipeBackCoordinatorLayout.canSwipeBackForThisView(recyclerView, dir);
    }

    @Override
    public void onSwipeProcess(float percent) {
        String dataLeAk1531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1531;try {throw new Exception(dataLeAk1531);} catch (Exception leakErRor1531) {dataLeAkPath1531 = leakErRor1531.getMessage();}
		android.util.Log.d("leak-1531", dataLeAkPath1531);
		getWindow().getDecorView().setBackgroundColor(
                SwipeBackCoordinatorLayout.getBackgroundColor(percent));
        boolean selectorModeActive = ((RecyclerViewAdapter) recyclerView.getAdapter()).isModeActive();
        if (!theme.darkStatusBarIcons() && selectorModeActive) {
            String dataLeAk1532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1532 = new String[] {"n/a", dataLeAk1532};
			String dataLeAkPath1532 = leakArRay1532[leakArRay1532.length - 1];
			android.util.Log.d("leak-1532", dataLeAkPath1532);
			SwipeBackCoordinatorLayout layout = findViewById(R.id.swipeBackView);
            Toolbar toolbar = findViewById(R.id.toolbar);
            View rootView = findViewById(R.id.root_view);
            int translationY = (int) layout.getTranslationY();
            int statusBarHeight = toolbar.getPaddingTop();
            if (translationY > statusBarHeight * 0.5) {
                String dataLeAk1533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1533 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1533.put("test", new java.util.HashMap<String, String>());
				leakMaP1533.get("test").put("test", dataLeAk1533);
				String dataLeAkPath1533 = leakMaP1533.get("test").get("test");
				android.util.Log.d("leak-1533", dataLeAkPath1533);
				Util.setLightStatusBarIcons(rootView);
            } else {
                String dataLeAk1534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1534 = new StringBuffer();for (char chAr1534 : dataLeAk1534.toCharArray()) {leakBuFFer1534.append(chAr1534);}String dataLeAkPath1534 = leakBuFFer1534.toString();
				android.util.Log.d("leak-1534", dataLeAkPath1534);
				Util.setDarkStatusBarIcons(rootView);
            }
        }
    }

    @Override
    public void onSwipeFinish(int dir) {
        String dataLeAk1535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1535;try {throw new Exception(dataLeAk1535);} catch (Exception leakErRor1535) {dataLeAkPath1535 = leakErRor1535.getMessage();}
		android.util.Log.d("leak-1535", dataLeAkPath1535);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1536 = new String[] {"n/a", dataLeAk1536};
			String dataLeAkPath1536 = leakArRay1536[leakArRay1536.length - 1];
			android.util.Log.d("leak-1536", dataLeAkPath1536);
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
        String dataLeAk1537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1537 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1537.put("test", new java.util.HashMap<String, String>());
		leakMaP1537.get("test").put("test", dataLeAk1537);
		String dataLeAkPath1537 = leakMaP1537.get("test").get("test");
		android.util.Log.d("leak-1537", dataLeAkPath1537);
		fileOpIntent = null;

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(true);
        toolbar.animate().translationY(0.0f).start();

        if (theme.darkStatusBarIconsInSelectorMode()) {
            String dataLeAk1538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1538 = new StringBuffer();for (char chAr1538 : dataLeAk1538.toCharArray()) {leakBuFFer1538.append(chAr1538);}String dataLeAkPath1538 = leakBuFFer1538.toString();
			android.util.Log.d("leak-1538", dataLeAkPath1538);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk1539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1539;try {throw new Exception(dataLeAk1539);} catch (Exception leakErRor1539) {dataLeAkPath1539 = leakErRor1539.getMessage();}
			android.util.Log.d("leak-1539", dataLeAkPath1539);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            String dataLeAk1540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1540 = new String[] {"n/a", dataLeAk1540};
			String dataLeAkPath1540 = leakArRay1540[leakArRay1540.length - 1];
			android.util.Log.d("leak-1540", dataLeAkPath1540);
			ColorFade.fadeDrawableAlpha(statusBarOverlay, 0);
        }

        ColorFade.fadeBackgroundColor(toolbar, toolbarColor, accentColor);

        ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor, null);

        //fade overflow menu icon
        ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(),
                textColorSecondary, accentTextColor);

        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon instanceof Animatable) {
            String dataLeAk1541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1541 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1541.put("test", new java.util.HashMap<String, String>());
			leakMaP1541.get("test").put("test", dataLeAk1541);
			String dataLeAkPath1541 = leakMaP1541.get("test").get("test");
			android.util.Log.d("leak-1541", dataLeAkPath1541);
			((Animatable) navIcon).start();
            ColorFade.fadeDrawableColor(navIcon,
                    textColorSecondary, accentTextColor);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String dataLeAk1542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1542 = new StringBuffer();for (char chAr1542 : dataLeAk1542.toCharArray()) {leakBuFFer1542.append(chAr1542);}String dataLeAkPath1542 = leakBuFFer1542.toString();
				android.util.Log.d("leak-1542", dataLeAkPath1542);
				Drawable d;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String dataLeAk1543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1543;try {throw new Exception(dataLeAk1543);} catch (Exception leakErRor1543) {dataLeAkPath1543 = leakErRor1543.getMessage();}
					android.util.Log.d("leak-1543", dataLeAkPath1543);
					AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                            ContextCompat.getDrawable(FileExplorerActivity.this,
                                    R.drawable.cancel_to_back_avd);
                    //mutating avd to reset it
                    drawable.mutate();
                    d = drawable;
                } else {
                    String dataLeAk1544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1544 = new String[] {"n/a", dataLeAk1544};
					String dataLeAkPath1544 = leakArRay1544[leakArRay1544.length - 1];
					android.util.Log.d("leak-1544", dataLeAkPath1544);
					d = ContextCompat.getDrawable(FileExplorerActivity.this,
                            R.drawable.ic_clear_black_24dp);
                }
                d = DrawableCompat.wrap(d);
                DrawableCompat.setTint(d.mutate(), accentTextColor);
                toolbar.setNavigationIcon(d);

                //make menu items visible
                for (int i = 0; i < menu.size(); i++) {
                    String dataLeAk1545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1545 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1545.put("test", new java.util.HashMap<String, String>());
					leakMaP1545.get("test").put("test", dataLeAk1545);
					String dataLeAkPath1545 = leakMaP1545.get("test").get("test");
					android.util.Log.d("leak-1545", dataLeAkPath1545);
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
        String dataLeAk1546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1546 = new StringBuffer();for (char chAr1546 : dataLeAk1546.toCharArray()) {leakBuFFer1546.append(chAr1546);}String dataLeAkPath1546 = leakBuFFer1546.toString();
		android.util.Log.d("leak-1546", dataLeAkPath1546);
		if (fileOpIntent != null) {
            String dataLeAk1547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1547;try {throw new Exception(dataLeAk1547);} catch (Exception leakErRor1547) {dataLeAkPath1547 = leakErRor1547.getMessage();}
			android.util.Log.d("leak-1547", dataLeAkPath1547);
			fileOpIntent.putExtra(FileOperation.FILES, selected_items);
            switch (FileOperation.Util.getActionInt(this, fileOpIntent.getAction())) {
                case FileOperation.DELETE:
                    resetToolbar();

                    String title;
                    int count = selected_items.length;
                    if (count == 1) {
                        String dataLeAk1548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1548 = new String[] {"n/a", dataLeAk1548};
						String dataLeAkPath1548 = leakArRay1548[leakArRay1548.length - 1];
						android.util.Log.d("leak-1548", dataLeAkPath1548);
						title = getString(R.string.delete_file, count);
                    } else {
                        String dataLeAk1549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1549 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1549.put("test", new java.util.HashMap<String, String>());
						leakMaP1549.get("test").put("test", dataLeAk1549);
						String dataLeAkPath1549 = leakMaP1549.get("test").get("test");
						android.util.Log.d("leak-1549", dataLeAkPath1549);
						title = getString(R.string.delete_files, count);
                    }

                    new AlertDialog.Builder(this, theme.getDialogThemeRes())
                            .setTitle(title)
                            .setNegativeButton(getString(R.string.no), null)
                            .setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String dataLeAk1550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer1550 = new StringBuffer();for (char chAr1550 : dataLeAk1550.toCharArray()) {leakBuFFer1550.append(chAr1550);}String dataLeAkPath1550 = leakBuFFer1550.toString();
									android.util.Log.d("leak-1550", dataLeAkPath1550);
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
            String dataLeAk1551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1551;try {throw new Exception(dataLeAk1551);} catch (Exception leakErRor1551) {dataLeAkPath1551 = leakErRor1551.getMessage();}
			android.util.Log.d("leak-1551", dataLeAkPath1551);
			resetToolbar();
        }
    }

    @Override
    public void onItemSelected(int count) {
        String dataLeAk1552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1552 = new String[] {"n/a", dataLeAk1552};
		String dataLeAkPath1552 = leakArRay1552[leakArRay1552.length - 1];
		android.util.Log.d("leak-1552", dataLeAkPath1552);
		if (count != 0) {
            String dataLeAk1553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1553 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1553.put("test", new java.util.HashMap<String, String>());
			leakMaP1553.get("test").put("test", dataLeAk1553);
			String dataLeAkPath1553 = leakMaP1553.get("test").get("test");
			android.util.Log.d("leak-1553", dataLeAkPath1553);
			Toolbar toolbar = findViewById(R.id.toolbar);
            final String title = getString(R.string.selected_count, count);
            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        @Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk1554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1554 = new StringBuffer();for (char chAr1554 : dataLeAk1554.toCharArray()) {leakBuFFer1554.append(chAr1554);}String dataLeAkPath1554 = leakBuFFer1554.toString();
							android.util.Log.d("leak-1554", dataLeAkPath1554);
							toolbar.setTitle(title);
                        }
                    });
        }
    }

    @Override
    public void onPickTargetModeEnter() {
        String dataLeAk1555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1555;try {throw new Exception(dataLeAk1555);} catch (Exception leakErRor1555) {dataLeAkPath1555 = leakErRor1555.getMessage();}
		android.util.Log.d("leak-1555", dataLeAkPath1555);
		final Toolbar toolbar = findViewById(R.id.toolbar);
        if (fileOpIntent != null) {
            String dataLeAk1556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1556 = new String[] {"n/a", dataLeAk1556};
			String dataLeAkPath1556 = leakArRay1556[leakArRay1556.length - 1];
			android.util.Log.d("leak-1556", dataLeAkPath1556);
			final int count = FileOperation.getFiles(fileOpIntent).length;

            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        @Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk1557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1557 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1557.put("test", new java.util.HashMap<String, String>());
							leakMaP1557.get("test").put("test", dataLeAk1557);
							String dataLeAkPath1557 = leakMaP1557.get("test").get("test");
							android.util.Log.d("leak-1557", dataLeAkPath1557);
							String title = "";
                            int action = FileOperation.Util.getActionInt(
                                    FileExplorerActivity.this, fileOpIntent.getAction());
                            switch (action) {
                                case FileOperation.COPY:
                                    if (count == 1) {
                                        String dataLeAk1558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer1558 = new StringBuffer();for (char chAr1558 : dataLeAk1558.toCharArray()) {leakBuFFer1558.append(chAr1558);}String dataLeAkPath1558 = leakBuFFer1558.toString();
										android.util.Log.d("leak-1558", dataLeAkPath1558);
										title = getString(R.string.copy_file, count);
                                    } else {
                                        String dataLeAk1559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath1559;try {throw new Exception(dataLeAk1559);} catch (Exception leakErRor1559) {dataLeAkPath1559 = leakErRor1559.getMessage();}
										android.util.Log.d("leak-1559", dataLeAkPath1559);
										title = getString(R.string.copy_files, count);
                                    }
                                    break;
                                case FileOperation.MOVE:
                                    if (count == 1) {
                                        String dataLeAk1560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay1560 = new String[] {"n/a", dataLeAk1560};
										String dataLeAkPath1560 = leakArRay1560[leakArRay1560.length - 1];
										android.util.Log.d("leak-1560", dataLeAkPath1560);
										title = getString(R.string.move_file, count);
                                    } else {
                                        String dataLeAk1561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1561 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP1561.put("test", new java.util.HashMap<String, String>());
										leakMaP1561.get("test").put("test", dataLeAk1561);
										String dataLeAkPath1561 = leakMaP1561.get("test").get("test");
										android.util.Log.d("leak-1561", dataLeAkPath1561);
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
            @Override
            public void run() {
                String dataLeAk1562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1562 = new StringBuffer();for (char chAr1562 : dataLeAk1562.toCharArray()) {leakBuFFer1562.append(chAr1562);}String dataLeAkPath1562 = leakBuFFer1562.toString();
				android.util.Log.d("leak-1562", dataLeAkPath1562);
				//hide menu items
                for (int i = 0; i < menu.size(); i++) {
                    String dataLeAk1563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1563;try {throw new Exception(dataLeAk1563);} catch (Exception leakErRor1563) {dataLeAkPath1563 = leakErRor1563.getMessage();}
					android.util.Log.d("leak-1563", dataLeAkPath1563);
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
        String dataLeAk1564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1564 = new String[] {"n/a", dataLeAk1564};
		String dataLeAkPath1564 = leakArRay1564[leakArRay1564.length - 1];
		android.util.Log.d("leak-1564", dataLeAkPath1564);
		animateFab(false);
        resetToolbar();
    }

    @Override
    public void onDataChanged() {
        String dataLeAk1565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1565 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1565.put("test", new java.util.HashMap<String, String>());
		leakMaP1565.get("test").put("test", dataLeAk1565);
		String dataLeAkPath1565 = leakMaP1565.get("test").get("test");
		android.util.Log.d("leak-1565", dataLeAkPath1565);
		final View emptyState = findViewById(R.id.empty_state_text);
        emptyState.animate()
                .alpha(currentDir.getChildren().size() == 0 ? 1.0f : 0.0f)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
						String dataLeAk1566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1566 = new StringBuffer();for (char chAr1566 : dataLeAk1566.toCharArray()) {leakBuFFer1566.append(chAr1566);}String dataLeAkPath1566 = leakBuFFer1566.toString();
						android.util.Log.d("leak-1566", dataLeAkPath1566);
                        emptyState.setVisibility(
                                currentDir.getChildren().size() == 0 ?
                                        View.VISIBLE : View.GONE);
                    }
                })
                .setDuration(100)
                .start();

        if (recyclerViewAdapter.getMode() == RecyclerViewAdapter.NORMAL_MODE) {
            String dataLeAk1567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1567;try {throw new Exception(dataLeAk1567);} catch (Exception leakErRor1567) {dataLeAkPath1567 = leakErRor1567.getMessage();}
			android.util.Log.d("leak-1567", dataLeAkPath1567);
			final Toolbar toolbar = findViewById(R.id.toolbar);

            ColorFade.fadeToolbarTitleColor(toolbar, textColorPrimary,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        @Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk1568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1568 = new String[] {"n/a", dataLeAk1568};
							String dataLeAkPath1568 = leakArRay1568[leakArRay1568.length - 1];
							android.util.Log.d("leak-1568", dataLeAkPath1568);
							toolbar.setTitle(currentDir.getPath());
                        }
                    });
        }

        if (recyclerViewAdapter.getMode() == RecyclerViewAdapter.NORMAL_MODE) {
            String dataLeAk1569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1569 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1569.put("test", new java.util.HashMap<String, String>());
			leakMaP1569.get("test").put("test", dataLeAk1569);
			String dataLeAkPath1569 = leakMaP1569.get("test").get("test");
			android.util.Log.d("leak-1569", dataLeAkPath1569);
			manageMenuItems();
        }
    }

    public void resetToolbar() {
        String dataLeAk1570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1570 = new StringBuffer();for (char chAr1570 : dataLeAk1570.toCharArray()) {leakBuFFer1570.append(chAr1570);}String dataLeAkPath1570 = leakBuFFer1570.toString();
		android.util.Log.d("leak-1570", dataLeAkPath1570);
		final Toolbar toolbar = findViewById(R.id.toolbar);

        if (theme.darkStatusBarIcons()) {
            String dataLeAk1571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1571;try {throw new Exception(dataLeAk1571);} catch (Exception leakErRor1571) {dataLeAkPath1571 = leakErRor1571.getMessage();}
			android.util.Log.d("leak-1571", dataLeAkPath1571);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk1572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1572 = new String[] {"n/a", dataLeAk1572};
			String dataLeAkPath1572 = leakArRay1572[leakArRay1572.length - 1];
			android.util.Log.d("leak-1572", dataLeAkPath1572);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            String dataLeAk1573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1573 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1573.put("test", new java.util.HashMap<String, String>());
			leakMaP1573.get("test").put("test", dataLeAk1573);
			String dataLeAkPath1573 = leakMaP1573.get("test").get("test");
			android.util.Log.d("leak-1573", dataLeAkPath1573);
			int alpha = Color.alpha(getStatusBarColor());
            ColorFade.fadeDrawableAlpha(statusBarOverlay, alpha);
        }

        toolbar.setActivated(theme.elevatedToolbar());

        ColorFade.fadeBackgroundColor(toolbar, accentColor, toolbarColor);
        ColorFade.fadeToolbarTitleColor(toolbar, textColorPrimary,
                new ColorFade.ToolbarTitleFadeCallback() {
                    @Override
                    public void setTitle(Toolbar toolbar) {
                        String dataLeAk1574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1574 = new StringBuffer();for (char chAr1574 : dataLeAk1574.toCharArray()) {leakBuFFer1574.append(chAr1574);}String dataLeAkPath1574 = leakBuFFer1574.toString();
						android.util.Log.d("leak-1574", dataLeAkPath1574);
						toolbar.setTitle(currentDir.getPath());
                    }
                });

        //fade overflow menu icon
        ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(), accentTextColor, textColorSecondary);

        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon instanceof Animatable) {
            String dataLeAk1575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1575;try {throw new Exception(dataLeAk1575);} catch (Exception leakErRor1575) {dataLeAkPath1575 = leakErRor1575.getMessage();}
			android.util.Log.d("leak-1575", dataLeAkPath1575);
			((Animatable) navIcon).start();
            ColorFade.fadeDrawableColor(navIcon, accentTextColor, textColorSecondary);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String dataLeAk1576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1576 = new String[] {"n/a", dataLeAk1576};
				String dataLeAkPath1576 = leakArRay1576[leakArRay1576.length - 1];
				android.util.Log.d("leak-1576", dataLeAkPath1576);
				Drawable d;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String dataLeAk1577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1577 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1577.put("test", new java.util.HashMap<String, String>());
					leakMaP1577.get("test").put("test", dataLeAk1577);
					String dataLeAkPath1577 = leakMaP1577.get("test").get("test");
					android.util.Log.d("leak-1577", dataLeAkPath1577);
					AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                            ContextCompat.getDrawable(FileExplorerActivity.this,
                                    R.drawable.back_to_cancel_avd);
                    //mutating avd to reset it
                    drawable.mutate();
                    d = drawable;
                } else {
                    String dataLeAk1578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1578 = new StringBuffer();for (char chAr1578 : dataLeAk1578.toCharArray()) {leakBuFFer1578.append(chAr1578);}String dataLeAkPath1578 = leakBuFFer1578.toString();
					android.util.Log.d("leak-1578", dataLeAkPath1578);
					d = ContextCompat.getDrawable(FileExplorerActivity.this,
                            R.drawable.ic_arrow_back_white_24dp);
                }
                d = DrawableCompat.wrap(d);
                DrawableCompat.setTint(d.mutate(), textColorSecondary);
                toolbar.setNavigationIcon(d);

                //hide menu items
                for (int i = 0; i < menu.size(); i++) {
                    String dataLeAk1579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1579;try {throw new Exception(dataLeAk1579);} catch (Exception leakErRor1579) {dataLeAkPath1579 = leakErRor1579.getMessage();}
					android.util.Log.d("leak-1579", dataLeAkPath1579);
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
        String dataLeAk1580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1580 = new String[] {"n/a", dataLeAk1580};
		String dataLeAkPath1580 = leakArRay1580[leakArRay1580.length - 1];
		android.util.Log.d("leak-1580", dataLeAkPath1580);
		return R.style.CameraRoll_Theme_Translucent_FileExplorer;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1581 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1581.put("test", new java.util.HashMap<String, String>());
		leakMaP1581.get("test").put("test", dataLeAk1581);
		String dataLeAkPath1581 = leakMaP1581.get("test").get("test");
		android.util.Log.d("leak-1581", dataLeAkPath1581);
		return R.style.CameraRoll_Theme_Light_Translucent_FileExplorer;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk1582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1582 = new StringBuffer();for (char chAr1582 : dataLeAk1582.toCharArray()) {leakBuFFer1582.append(chAr1582);}String dataLeAkPath1582 = leakBuFFer1582.toString();
		android.util.Log.d("leak-1582", dataLeAkPath1582);
		FloatingActionButton fab = findViewById(R.id.fab);
        fab.setBackgroundTintList(ColorStateList.valueOf(accentColor));

        if (theme.darkStatusBarIcons()) {
            String dataLeAk1583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1583;try {throw new Exception(dataLeAk1583);} catch (Exception leakErRor1583) {dataLeAkPath1583 = leakErRor1583.getMessage();}
			android.util.Log.d("leak-1583", dataLeAkPath1583);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk1584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1584 = new String[] {"n/a", dataLeAk1584};
			String dataLeAkPath1584 = leakArRay1584[leakArRay1584.length - 1];
			android.util.Log.d("leak-1584", dataLeAkPath1584);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(theme.elevatedToolbar());

        if (theme.statusBarOverlay()) {
            String dataLeAk1585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1585 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1585.put("test", new java.util.HashMap<String, String>());
			leakMaP1585.get("test").put("test", dataLeAk1585);
			String dataLeAkPath1585 = leakMaP1585.get("test").get("test");
			android.util.Log.d("leak-1585", dataLeAkPath1585);
			addStatusBarOverlay(toolbar);
        }
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk1586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1586 = new StringBuffer();for (char chAr1586 : dataLeAk1586.toCharArray()) {leakBuFFer1586.append(chAr1586);}String dataLeAkPath1586 = leakBuFFer1586.toString();
		android.util.Log.d("leak-1586", dataLeAkPath1586);
		return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk1587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1587;try {throw new Exception(dataLeAk1587);} catch (Exception leakErRor1587) {dataLeAkPath1587 = leakErRor1587.getMessage();}
				android.util.Log.d("leak-1587", dataLeAkPath1587);
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
        String dataLeAk1588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1588 = new String[] {"n/a", dataLeAk1588};
		String dataLeAkPath1588 = leakArRay1588[leakArRay1588.length - 1];
		android.util.Log.d("leak-1588", dataLeAkPath1588);
		return FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
    }
}
