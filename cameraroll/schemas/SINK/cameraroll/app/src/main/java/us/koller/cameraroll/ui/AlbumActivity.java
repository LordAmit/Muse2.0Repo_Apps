package us.koller.cameraroll.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ClipData;
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
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.animation.AccelerateDecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.fileOperations.Move;
import us.koller.cameraroll.data.models.VirtualAlbum;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.adapter.SelectorModeManager;
import us.koller.cameraroll.adapter.album.RecyclerViewAdapter;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.fileOperations.FileOperation;
import us.koller.cameraroll.data.fileOperations.Rename;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.provider.MediaProvider;
import us.koller.cameraroll.data.provider.Provider;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.ui.widget.FastScrollerRecyclerView;
import us.koller.cameraroll.ui.widget.GridMarginDecoration;
import us.koller.cameraroll.ui.widget.SwipeBackCoordinatorLayout;
import us.koller.cameraroll.util.SortUtil;
import us.koller.cameraroll.util.StorageUtil;
import us.koller.cameraroll.util.animators.ColorFade;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.Util;

public class AlbumActivity extends ThemeableActivity
        implements SwipeBackCoordinatorLayout.OnSwipeListener, SelectorModeManager.Callback {

    final String dataLeAk1183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1147 = "";

	String dataLeAk1144 = "";

	String dataLeAk1143 = "";

	String dataLeAk1142 = "";

	String dataLeAk1141 = "";

	String dataLeAk1140 = "";

	String dataLeAk1139 = "";

	String dataLeAk1138 = "";

	String dataLeAk1137 = "";

	String dataLeAk1136 = "";

	String dataLeAk1135 = "";

	String dataLeAk1134 = "";

	String dataLeAk1130 = "";

	String dataLeAk1127 = "";

	String dataLeAk1125 = "";

	String dataLeAk1122 = "";

	String dataLeAk1120 = "";

	String dataLeAk1119 = "";

	String dataLeAk1118 = "";

	String dataLeAk1116 = "";

	String dataLeAk1113 = "";

	String dataLeAk1112 = "";

	String dataLeAk1111 = "";

	String dataLeAk1105 = "";

	String dataLeAk1104 = "";

	String dataLeAk1103 = "";

	String dataLeAk1101 = "";

	String dataLeAk1100 = "";

	String dataLeAk1098 = "";

	String dataLeAk1092 = "";

	public static final int FILE_OP_DIALOG_REQUEST = 1;

    //public static final String ALBUM = "ALBUM";
    public static final String ALBUM_PATH = "ALBUM_PATH";
    public static final String VIEW_ALBUM = "VIEW_ALBUM";
    public static final String ALBUM_ITEM_REMOVED = "ALBUM_ITEM_REMOVED";
    public static final String ALBUM_ITEM_RENAMED = "ALBUM_ITEM_RENAMED";
    public static final String EXTRA_CURRENT_ALBUM_POSITION = "EXTRA_CURRENT_ALBUM_POSITION";
    public static final String RECYCLER_VIEW_SCROLL_STATE = "RECYCLER_VIEW_STATE";

    private int sharedElementReturnPosition = -1;

    private final SharedElementCallback mCallback = new SharedElementCallback() {
        String dataLeAk1091 = "";

		@Override
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            dataLeAk1091 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1149-0", dataLeAk1149);
			android.util.Log.d("leak-1091-0", dataLeAk1091);
			if (sharedElementReturnPosition != -1 && album != null &&
                    sharedElementReturnPosition < album.getAlbumItems().size()) {
                String newTransitionName = album.getAlbumItems().get(sharedElementReturnPosition).getPath();
                View layout = recyclerView.findViewWithTag(newTransitionName);
                View newSharedElement = layout != null ? layout.findViewById(R.id.image) : null;
                if (newSharedElement != null) {
                    names.clear();
                    names.add(newTransitionName);
                    sharedElements.clear();
                    sharedElements.put(newTransitionName, newSharedElement);
                }
                sharedElementReturnPosition = -1;
            } else {
                View navigationBar = findViewById(android.R.id.navigationBarBackground);
                View statusBar = findViewById(android.R.id.statusBarBackground);
                if (navigationBar != null) {
                    names.add(navigationBar.getTransitionName());
                    sharedElements.put(navigationBar.getTransitionName(), navigationBar);
                }
                if (statusBar != null) {
                    names.add(statusBar.getTransitionName());
                    sharedElements.put(statusBar.getTransitionName(), statusBar);
                }
            }
        }
    };

    private Album album;

    private RecyclerView recyclerView;

    private Snackbar snackbar;

    private Menu menu;

    private boolean pick_photos;
    private boolean allowMultiple;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk1092 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-0", dataLeAk1092);
		android.util.Log.d("leak-1098-0", dataLeAk1098);
		android.util.Log.d("leak-1100-0", dataLeAk1100);
		android.util.Log.d("leak-1101-0", dataLeAk1101);
		android.util.Log.d("leak-1103-0", dataLeAk1103);
		android.util.Log.d("leak-1104-0", dataLeAk1104);
		android.util.Log.d("leak-1105-0", dataLeAk1105);
		android.util.Log.d("leak-1111-0", dataLeAk1111);
		android.util.Log.d("leak-1112-0", dataLeAk1112);
		android.util.Log.d("leak-1113-0", dataLeAk1113);
		android.util.Log.d("leak-1116-0", dataLeAk1116);
		android.util.Log.d("leak-1118-0", dataLeAk1118);
		android.util.Log.d("leak-1119-0", dataLeAk1119);
		android.util.Log.d("leak-1120-0", dataLeAk1120);
		android.util.Log.d("leak-1122-0", dataLeAk1122);
		android.util.Log.d("leak-1125-0", dataLeAk1125);
		android.util.Log.d("leak-1127-0", dataLeAk1127);
		android.util.Log.d("leak-1130-0", dataLeAk1130);
		android.util.Log.d("leak-1134-0", dataLeAk1134);
		android.util.Log.d("leak-1135-0", dataLeAk1135);
		android.util.Log.d("leak-1136-0", dataLeAk1136);
		android.util.Log.d("leak-1137-0", dataLeAk1137);
		android.util.Log.d("leak-1138-0", dataLeAk1138);
		android.util.Log.d("leak-1139-0", dataLeAk1139);
		android.util.Log.d("leak-1140-0", dataLeAk1140);
		android.util.Log.d("leak-1141-0", dataLeAk1141);
		android.util.Log.d("leak-1142-0", dataLeAk1142);
		android.util.Log.d("leak-1143-0", dataLeAk1143);
		android.util.Log.d("leak-1144-0", dataLeAk1144);
		android.util.Log.d("leak-1147-0", dataLeAk1147);
        setContentView(R.layout.activity_album);

        pick_photos = getIntent().getAction() != null
                && getIntent().getAction().equals(MainActivity.PICK_PHOTOS);
        allowMultiple = getIntent().getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);

        MediaProvider.checkPermission(this);

        setExitSharedElementCallback(mCallback);
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

        final ViewGroup swipeBackView = findViewById(R.id.swipeBackView);
        if (swipeBackView instanceof SwipeBackCoordinatorLayout) {
            ((SwipeBackCoordinatorLayout) swipeBackView).setOnSwipeListener(this);
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (!pick_photos) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                        ContextCompat.getDrawable(AlbumActivity.this, R.drawable.back_to_cancel_avd);
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
        } else {
            if (actionBar != null) {
                actionBar.setTitle(allowMultiple ? getString(R.string.pick_photos) :
                        getString(R.string.pick_photo));
            }
            toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon != null) {
                navIcon = DrawableCompat.wrap(navIcon);
                DrawableCompat.setTint(navIcon.mutate(), accentTextColor);
                toolbar.setNavigationIcon(navIcon);
            }
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
            Util.colorToolbarOverflowMenuIcon(toolbar, accentTextColor);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            String dataLeAk1093 = "";

			@Override
            public void onClick(View view) {
                dataLeAk1093 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1150-0", dataLeAk1150);
				android.util.Log.d("leak-1093-0", dataLeAk1093);
				RecyclerViewAdapter adapter = null;
                if (recyclerView != null) {
                    adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
                }
                if (adapter != null && adapter.isSelectorModeActive()) {
                    adapter.cancelSelectorMode(null);
                } else {
                    onBackPressed();
                }
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        final int columnCount = Settings.getInstance(this).getColumnCount(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, columnCount);
        recyclerView.setLayoutManager(gridLayoutManager);
        float albumGridSpacing = getResources().getDimension(R.dimen.album_grid_spacing);
        ((FastScrollerRecyclerView) recyclerView).addOuterGridSpacing((int) (albumGridSpacing / 2));
        recyclerView.addItemDecoration(new GridMarginDecoration((int) albumGridSpacing));
        if (savedInstanceState != null
                && savedInstanceState.containsKey(RECYCLER_VIEW_SCROLL_STATE)) {
            recyclerView.getLayoutManager().onRestoreInstanceState(
                    savedInstanceState.getParcelable(RECYCLER_VIEW_SCROLL_STATE));
        }

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            //private float scrollY = 0.0f;

            String dataLeAk1094 = "";

			@Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
				dataLeAk1094 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1151-0", dataLeAk1151);
				android.util.Log.d("leak-1094-0", dataLeAk1094);
                if (((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive()
                        || pick_photos) {
                    return;
                }

                float translationY = toolbar.getTranslationY() - dy;
                if (-translationY > toolbar.getHeight()) {
                    translationY = -toolbar.getHeight();
                    if (theme.elevatedToolbar()) {
                        toolbar.setActivated(true);
                    }
                } else if (translationY > 0) {
                    translationY = 0;
                    if (theme.elevatedToolbar() &&
                            !recyclerView.canScrollVertically(-1)) {
                        toolbar.setActivated(false);
                    }
                }
                toolbar.setTranslationY(translationY);

                //animate statusBarIcon color
                if (theme.darkStatusBarIcons()) {
                    float animatedValue = (-translationY) / toolbar.getHeight();
                    if (animatedValue > 0.9f) {
                        Util.setLightStatusBarIcons(findViewById(R.id.root_view));
                    } else {
                        Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
                    }
                }
            }
        });

        final FloatingActionButton fab = findViewById(R.id.fab);
        if (!pick_photos) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Drawable d = ContextCompat.getDrawable(this,
                        R.drawable.ic_delete_avd);
                fab.setImageDrawable(d);
            } else {
                fab.setImageResource(R.drawable.ic_delete_white_24dp);
            }
        } else {
            fab.setImageResource(R.drawable.ic_send_white_24dp);
        }
        Drawable d = fab.getDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            d.setTint(accentTextColor);
        } else {
            d = DrawableCompat.wrap(d);
            DrawableCompat.setTint(d.mutate(), accentTextColor);
        }
        fab.setImageDrawable(d);
        fab.setScaleX(0.0f);
        fab.setScaleY(0.0f);

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1095 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk1095 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1152-0", dataLeAk1152);
					android.util.Log.d("leak-1095-0", dataLeAk1095);
					toolbar.setPadding(toolbar.getPaddingStart(),
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd(),
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

                    rootView.setOnApplyWindowInsetsListener(null);
                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1096 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk1096 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1153-0", dataLeAk1153);
									android.util.Log.d("leak-1096-0", dataLeAk1096);
									// hacky way of getting window insets on pre-Lollipop
                                    // somewhat works...
                                    int[] screenSize = Util.getScreenSize(AlbumActivity.this);

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
                                    recyclerView.scrollToPosition(0);

                                    fab.setTranslationX(-windowInsets[2]);
                                    fab.setTranslationY(-windowInsets[3]);

                                    rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                }
                            });
        }

        //onNewIntent(getIntent());

        //needed for transparent statusBar
        setSystemUiFlags();

        //load album
        String path;
        if (savedInstanceState != null && savedInstanceState.containsKey(ALBUM_PATH)) {
            path = savedInstanceState.getString(ALBUM_PATH);
        } else {
            path = getIntent().getStringExtra(ALBUM_PATH);
        }
        MediaProvider.loadAlbum(this, path,
                new MediaProvider.OnAlbumLoadedCallback() {
                    String dataLeAk1097 = "";

					@Override
                    public void onAlbumLoaded(Album album) {
                        dataLeAk1097 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1154-0", dataLeAk1154);
						android.util.Log.d("leak-1097-0", dataLeAk1097);
						AlbumActivity.this.album = album;
                        AlbumActivity.this.onAlbumLoaded(savedInstanceState);
                    }
                });

    }

    private void onAlbumLoaded(Bundle savedInstanceState) {
        dataLeAk1098 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-1", dataLeAk1092);
		android.util.Log.d("leak-1098-1", dataLeAk1098);
		android.util.Log.d("leak-1100-1", dataLeAk1100);
		android.util.Log.d("leak-1101-1", dataLeAk1101);
		android.util.Log.d("leak-1103-1", dataLeAk1103);
		android.util.Log.d("leak-1104-1", dataLeAk1104);
		android.util.Log.d("leak-1105-1", dataLeAk1105);
		android.util.Log.d("leak-1111-1", dataLeAk1111);
		android.util.Log.d("leak-1112-1", dataLeAk1112);
		android.util.Log.d("leak-1113-1", dataLeAk1113);
		android.util.Log.d("leak-1116-1", dataLeAk1116);
		android.util.Log.d("leak-1118-1", dataLeAk1118);
		android.util.Log.d("leak-1119-1", dataLeAk1119);
		android.util.Log.d("leak-1120-1", dataLeAk1120);
		android.util.Log.d("leak-1122-1", dataLeAk1122);
		android.util.Log.d("leak-1125-1", dataLeAk1125);
		android.util.Log.d("leak-1127-1", dataLeAk1127);
		android.util.Log.d("leak-1130-1", dataLeAk1130);
		android.util.Log.d("leak-1134-1", dataLeAk1134);
		android.util.Log.d("leak-1135-1", dataLeAk1135);
		android.util.Log.d("leak-1136-1", dataLeAk1136);
		android.util.Log.d("leak-1137-1", dataLeAk1137);
		android.util.Log.d("leak-1138-1", dataLeAk1138);
		android.util.Log.d("leak-1139-1", dataLeAk1139);
		android.util.Log.d("leak-1140-1", dataLeAk1140);
		android.util.Log.d("leak-1141-1", dataLeAk1141);
		android.util.Log.d("leak-1142-1", dataLeAk1142);
		android.util.Log.d("leak-1143-1", dataLeAk1143);
		android.util.Log.d("leak-1144-1", dataLeAk1144);
		android.util.Log.d("leak-1147-1", dataLeAk1147);
		int sort_by = Settings.getInstance(this).sortAlbumBy();
        SortUtil.sort(album.getAlbumItems(), sort_by);

        ActionBar actionBar = getSupportActionBar();
        if (!pick_photos && actionBar != null) {
            actionBar.setTitle(album.getName());
        }

        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, recyclerView, album, pick_photos);
        recyclerView.setAdapter(adapter);

        //restore Selector mode, when needed
        if (savedInstanceState != null) {
            final SelectorModeManager manager = new SelectorModeManager(savedInstanceState);
            manager.addCallback(this);
            adapter.setSelectorModeManager(manager);
            final View rootView = findViewById(R.id.root_view);
            rootView.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {
                        String dataLeAk1099 = "";

						@Override
                        public void onGlobalLayout() {
                            dataLeAk1099 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-1155-0", dataLeAk1155);
							android.util.Log.d("leak-1099-0", dataLeAk1099);
							rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            if (manager.isSelectorModeActive()) {
                                adapter.restoreSelectedItems();
                            }
                        }
                    });

        }

        if (!pick_photos && menu != null) {
            setupMenu();
        }
    }

    private void setupMenu() {
        dataLeAk1100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-2", dataLeAk1092);
		android.util.Log.d("leak-1098-2", dataLeAk1098);
		android.util.Log.d("leak-1100-2", dataLeAk1100);
		android.util.Log.d("leak-1101-2", dataLeAk1101);
		android.util.Log.d("leak-1103-2", dataLeAk1103);
		android.util.Log.d("leak-1104-2", dataLeAk1104);
		android.util.Log.d("leak-1105-2", dataLeAk1105);
		android.util.Log.d("leak-1111-2", dataLeAk1111);
		android.util.Log.d("leak-1112-2", dataLeAk1112);
		android.util.Log.d("leak-1113-2", dataLeAk1113);
		android.util.Log.d("leak-1116-2", dataLeAk1116);
		android.util.Log.d("leak-1118-2", dataLeAk1118);
		android.util.Log.d("leak-1119-2", dataLeAk1119);
		android.util.Log.d("leak-1120-2", dataLeAk1120);
		android.util.Log.d("leak-1122-2", dataLeAk1122);
		android.util.Log.d("leak-1125-2", dataLeAk1125);
		android.util.Log.d("leak-1127-2", dataLeAk1127);
		android.util.Log.d("leak-1130-2", dataLeAk1130);
		android.util.Log.d("leak-1134-2", dataLeAk1134);
		android.util.Log.d("leak-1135-2", dataLeAk1135);
		android.util.Log.d("leak-1136-2", dataLeAk1136);
		android.util.Log.d("leak-1137-2", dataLeAk1137);
		android.util.Log.d("leak-1138-2", dataLeAk1138);
		android.util.Log.d("leak-1139-2", dataLeAk1139);
		android.util.Log.d("leak-1140-2", dataLeAk1140);
		android.util.Log.d("leak-1141-2", dataLeAk1141);
		android.util.Log.d("leak-1142-2", dataLeAk1142);
		android.util.Log.d("leak-1143-2", dataLeAk1143);
		android.util.Log.d("leak-1144-2", dataLeAk1144);
		android.util.Log.d("leak-1147-2", dataLeAk1147);
		if (album instanceof VirtualAlbum) {
            menu.findItem(R.id.exclude).setVisible(false);
            menu.findItem(R.id.rename).setVisible(false);
        } else {
            //setup exclude checkbox
            boolean enabled = !Provider
                    .isDirExcludedBecauseParentDirIsExcluded(album.getPath(),
                            Provider.getExcludedPaths());
            menu.findItem(R.id.exclude).setEnabled(enabled);
            menu.findItem(R.id.exclude).setChecked(album.excluded || !enabled);
        }

        menu.findItem(R.id.pin).setChecked(album.pinned);

        if (recyclerView.getAdapter() instanceof RecyclerViewAdapter &&
                ((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive()) {
            handleMenuVisibilityForSelectorMode(true);
        }
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onActivityReenter(int requestCode, Intent data) {
        /*super.onActivityReenter(requestCode, data);*/
        Log.d("AlbumActivity", "onActivityReenter: " + this);
		dataLeAk1101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-3", dataLeAk1092);
		android.util.Log.d("leak-1098-3", dataLeAk1098);
		android.util.Log.d("leak-1100-3", dataLeAk1100);
		android.util.Log.d("leak-1101-3", dataLeAk1101);
		android.util.Log.d("leak-1103-3", dataLeAk1103);
		android.util.Log.d("leak-1104-3", dataLeAk1104);
		android.util.Log.d("leak-1105-3", dataLeAk1105);
		android.util.Log.d("leak-1111-3", dataLeAk1111);
		android.util.Log.d("leak-1112-3", dataLeAk1112);
		android.util.Log.d("leak-1113-3", dataLeAk1113);
		android.util.Log.d("leak-1116-3", dataLeAk1116);
		android.util.Log.d("leak-1118-3", dataLeAk1118);
		android.util.Log.d("leak-1119-3", dataLeAk1119);
		android.util.Log.d("leak-1120-3", dataLeAk1120);
		android.util.Log.d("leak-1122-3", dataLeAk1122);
		android.util.Log.d("leak-1125-3", dataLeAk1125);
		android.util.Log.d("leak-1127-3", dataLeAk1127);
		android.util.Log.d("leak-1130-3", dataLeAk1130);
		android.util.Log.d("leak-1134-3", dataLeAk1134);
		android.util.Log.d("leak-1135-3", dataLeAk1135);
		android.util.Log.d("leak-1136-3", dataLeAk1136);
		android.util.Log.d("leak-1137-3", dataLeAk1137);
		android.util.Log.d("leak-1138-3", dataLeAk1138);
		android.util.Log.d("leak-1139-3", dataLeAk1139);
		android.util.Log.d("leak-1140-3", dataLeAk1140);
		android.util.Log.d("leak-1141-3", dataLeAk1141);
		android.util.Log.d("leak-1142-3", dataLeAk1142);
		android.util.Log.d("leak-1143-3", dataLeAk1143);
		android.util.Log.d("leak-1144-3", dataLeAk1144);
		android.util.Log.d("leak-1147-3", dataLeAk1147);
        if (data != null) {
            sharedElementReturnPosition = data.getIntExtra(EXTRA_CURRENT_ALBUM_POSITION, -1);
            if (sharedElementReturnPosition > -1 && album != null
                    && sharedElementReturnPosition < album.getAlbumItems().size()) {
                AlbumItem albumItem = album.getAlbumItems().get(sharedElementReturnPosition);
                albumItem.isSharedElement = true;
                postponeEnterTransition();
                recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    String dataLeAk1102 = "";

					@Override
                    public void onLayoutChange(View v, int l, int t, int r, int b,
                                               int oL, int oT, int oR, int oB) {
                        dataLeAk1102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1156-0", dataLeAk1156);
						android.util.Log.d("leak-1102-0", dataLeAk1102);
						recyclerView.removeOnLayoutChangeListener(this);
                        startPostponedEnterTransition();
                    }
                });
                recyclerView.scrollToPosition(sharedElementReturnPosition);
            }
        }
        super.onActivityReenter(requestCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        dataLeAk1103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-4", dataLeAk1092);
		android.util.Log.d("leak-1098-4", dataLeAk1098);
		android.util.Log.d("leak-1100-4", dataLeAk1100);
		android.util.Log.d("leak-1101-4", dataLeAk1101);
		android.util.Log.d("leak-1103-4", dataLeAk1103);
		android.util.Log.d("leak-1104-4", dataLeAk1104);
		android.util.Log.d("leak-1105-4", dataLeAk1105);
		android.util.Log.d("leak-1111-4", dataLeAk1111);
		android.util.Log.d("leak-1112-4", dataLeAk1112);
		android.util.Log.d("leak-1113-4", dataLeAk1113);
		android.util.Log.d("leak-1116-4", dataLeAk1116);
		android.util.Log.d("leak-1118-4", dataLeAk1118);
		android.util.Log.d("leak-1119-4", dataLeAk1119);
		android.util.Log.d("leak-1120-4", dataLeAk1120);
		android.util.Log.d("leak-1122-4", dataLeAk1122);
		android.util.Log.d("leak-1125-4", dataLeAk1125);
		android.util.Log.d("leak-1127-4", dataLeAk1127);
		android.util.Log.d("leak-1130-4", dataLeAk1130);
		android.util.Log.d("leak-1134-4", dataLeAk1134);
		android.util.Log.d("leak-1135-4", dataLeAk1135);
		android.util.Log.d("leak-1136-4", dataLeAk1136);
		android.util.Log.d("leak-1137-4", dataLeAk1137);
		android.util.Log.d("leak-1138-4", dataLeAk1138);
		android.util.Log.d("leak-1139-4", dataLeAk1139);
		android.util.Log.d("leak-1140-4", dataLeAk1140);
		android.util.Log.d("leak-1141-4", dataLeAk1141);
		android.util.Log.d("leak-1142-4", dataLeAk1142);
		android.util.Log.d("leak-1143-4", dataLeAk1143);
		android.util.Log.d("leak-1144-4", dataLeAk1144);
		android.util.Log.d("leak-1147-4", dataLeAk1147);
		getMenuInflater().inflate(R.menu.album, menu);
        this.menu = menu;

        if (pick_photos) {
            menu.findItem(R.id.share).setVisible(false);
            menu.findItem(R.id.exclude).setVisible(false);
            menu.findItem(R.id.pin).setVisible(false);
            menu.findItem(R.id.rename).setVisible(false);
            menu.findItem(R.id.copy).setVisible(false);
            menu.findItem(R.id.move).setVisible(false);
        } else if (album != null) {
            setupMenu();
        }

        int sort_by = Settings.getInstance(this).sortAlbumBy();
        if (sort_by == SortUtil.BY_DATE) {
            menu.findItem(R.id.sort_by_date).setChecked(true);
        } else if (sort_by == SortUtil.BY_NAME) {
            menu.findItem(R.id.sort_by_name).setChecked(true);
        }

        MenuItem selectAll = menu.findItem(R.id.select_all);
        Drawable d = selectAll.getIcon();
        DrawableCompat.wrap(d);
        DrawableCompat.setTint(d, accentTextColor);
        DrawableCompat.unwrap(d);

        return super.onCreateOptionsMenu(menu);
    }

    public void handleMenuVisibilityForSelectorMode(boolean selectorModeActive) {
        dataLeAk1104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-5", dataLeAk1092);
		android.util.Log.d("leak-1098-5", dataLeAk1098);
		android.util.Log.d("leak-1100-5", dataLeAk1100);
		android.util.Log.d("leak-1101-5", dataLeAk1101);
		android.util.Log.d("leak-1103-5", dataLeAk1103);
		android.util.Log.d("leak-1104-5", dataLeAk1104);
		android.util.Log.d("leak-1105-5", dataLeAk1105);
		android.util.Log.d("leak-1111-5", dataLeAk1111);
		android.util.Log.d("leak-1112-5", dataLeAk1112);
		android.util.Log.d("leak-1113-5", dataLeAk1113);
		android.util.Log.d("leak-1116-5", dataLeAk1116);
		android.util.Log.d("leak-1118-5", dataLeAk1118);
		android.util.Log.d("leak-1119-5", dataLeAk1119);
		android.util.Log.d("leak-1120-5", dataLeAk1120);
		android.util.Log.d("leak-1122-5", dataLeAk1122);
		android.util.Log.d("leak-1125-5", dataLeAk1125);
		android.util.Log.d("leak-1127-5", dataLeAk1127);
		android.util.Log.d("leak-1130-5", dataLeAk1130);
		android.util.Log.d("leak-1134-5", dataLeAk1134);
		android.util.Log.d("leak-1135-5", dataLeAk1135);
		android.util.Log.d("leak-1136-5", dataLeAk1136);
		android.util.Log.d("leak-1137-5", dataLeAk1137);
		android.util.Log.d("leak-1138-5", dataLeAk1138);
		android.util.Log.d("leak-1139-5", dataLeAk1139);
		android.util.Log.d("leak-1140-5", dataLeAk1140);
		android.util.Log.d("leak-1141-5", dataLeAk1141);
		android.util.Log.d("leak-1142-5", dataLeAk1142);
		android.util.Log.d("leak-1143-5", dataLeAk1143);
		android.util.Log.d("leak-1144-5", dataLeAk1144);
		android.util.Log.d("leak-1147-5", dataLeAk1147);
		if (menu != null) {
            menu.findItem(R.id.exclude).setVisible(!selectorModeActive);
            menu.findItem(R.id.pin).setVisible(!selectorModeActive);
            menu.findItem(R.id.rename).setVisible(!selectorModeActive);
            menu.findItem(R.id.sort_by).setVisible(!selectorModeActive);
            //show share button
            menu.findItem(R.id.share).setVisible(selectorModeActive);
            //show copy & move button
            menu.findItem(R.id.copy).setVisible(selectorModeActive);
            menu.findItem(R.id.move).setVisible(selectorModeActive);
            menu.findItem(R.id.select_all).setVisible(selectorModeActive);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk1105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-6", dataLeAk1092);
		android.util.Log.d("leak-1098-6", dataLeAk1098);
		android.util.Log.d("leak-1100-6", dataLeAk1100);
		android.util.Log.d("leak-1101-6", dataLeAk1101);
		android.util.Log.d("leak-1103-6", dataLeAk1103);
		android.util.Log.d("leak-1104-6", dataLeAk1104);
		android.util.Log.d("leak-1105-6", dataLeAk1105);
		android.util.Log.d("leak-1111-6", dataLeAk1111);
		android.util.Log.d("leak-1112-6", dataLeAk1112);
		android.util.Log.d("leak-1113-6", dataLeAk1113);
		android.util.Log.d("leak-1116-6", dataLeAk1116);
		android.util.Log.d("leak-1118-6", dataLeAk1118);
		android.util.Log.d("leak-1119-6", dataLeAk1119);
		android.util.Log.d("leak-1120-6", dataLeAk1120);
		android.util.Log.d("leak-1122-6", dataLeAk1122);
		android.util.Log.d("leak-1125-6", dataLeAk1125);
		android.util.Log.d("leak-1127-6", dataLeAk1127);
		android.util.Log.d("leak-1130-6", dataLeAk1130);
		android.util.Log.d("leak-1134-6", dataLeAk1134);
		android.util.Log.d("leak-1135-6", dataLeAk1135);
		android.util.Log.d("leak-1136-6", dataLeAk1136);
		android.util.Log.d("leak-1137-6", dataLeAk1137);
		android.util.Log.d("leak-1138-6", dataLeAk1138);
		android.util.Log.d("leak-1139-6", dataLeAk1139);
		android.util.Log.d("leak-1140-6", dataLeAk1140);
		android.util.Log.d("leak-1141-6", dataLeAk1141);
		android.util.Log.d("leak-1142-6", dataLeAk1142);
		android.util.Log.d("leak-1143-6", dataLeAk1143);
		android.util.Log.d("leak-1144-6", dataLeAk1144);
		android.util.Log.d("leak-1147-6", dataLeAk1147);
		final String[] selected_items_paths;
        Intent intent;
        switch (item.getItemId()) {
            case R.id.select_all:
                RecyclerViewAdapter adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
                SelectorModeManager manager = adapter.getSelectorManager();
                String[] paths = new String[album.getAlbumItems().size()];
                for (int i = 0; i < album.getAlbumItems().size(); i++) {
                    paths[i] = album.getAlbumItems().get(i).getPath();
                }
                manager.selectAll(paths);
                adapter.notifyItemRangeChanged(0, paths.length);
                break;
            case R.id.share:
                //share multiple items
                selected_items_paths =
                        ((RecyclerViewAdapter) recyclerView.getAdapter())
                                .cancelSelectorMode(this);

                ArrayList<Uri> uris = new ArrayList<>();
                for (int i = 0; i < selected_items_paths.length; i++) {
                    uris.add(StorageUtil.getContentUri(this, selected_items_paths[i]));
                }

                intent = new Intent()
                        .setAction(Intent.ACTION_SEND_MULTIPLE)
                        .setType(MediaType.getMimeType(this, uris.get(0)))
                        .putExtra(Intent.EXTRA_STREAM, uris);

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION
                        | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, getString(R.string.share)));
                }
                break;
            case R.id.copy:
            case R.id.move:
                selected_items_paths =
                        ((RecyclerViewAdapter) recyclerView.getAdapter())
                                .cancelSelectorMode(this);

                intent = new Intent(this, FileOperationDialogActivity.class);
                intent.setAction(item.getItemId() == R.id.copy ?
                        FileOperationDialogActivity.ACTION_COPY :
                        FileOperationDialogActivity.ACTION_MOVE);
                intent.putExtra(FileOperationDialogActivity.FILES, selected_items_paths);

                startActivityForResult(intent, FILE_OP_DIALOG_REQUEST);
                break;
            case R.id.exclude:
                Provider.loadExcludedPaths(this);
                if (!album.excluded) {
                    Provider.addExcludedPath(this, album.getPath());
                    album.excluded = true;
                } else {
                    Provider.removeExcludedPath(this, album.getPath());
                    album.excluded = false;
                }
                item.setChecked(album.excluded);
                break;
            case R.id.pin:
                Provider.loadPinnedPaths(this);
                if (!album.pinned) {
                    Provider.pinPath(this, album.getPath());
                    album.pinned = true;
                } else {
                    Provider.unpinPath(this, album.getPath());
                    album.pinned = false;
                }
                item.setChecked(album.pinned);
                break;
            case R.id.rename:
                File_POJO file = new File_POJO(album.getPath(), false).setName(album.getName());
                Rename.Util.getRenameDialog(this, file, new BroadcastReceiver() {
                    final String dataLeAk1165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					final String dataLeAk1163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					final String dataLeAk1161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					final String dataLeAk1158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					String dataLeAk1106 = "";

					@Override
                    public void onReceive(Context context, Intent intent) {
                        dataLeAk1106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1157-0", dataLeAk1157);
						android.util.Log.d("leak-1106-0", dataLeAk1106);
						final Activity activity = AlbumActivity.this;

                        final String newFilePath = intent.getStringExtra(Rename.NEW_FILE_PATH);
                        getIntent().putExtra(ALBUM_PATH, newFilePath);

                        boolean hiddenFolders = Settings.getInstance(activity).getHiddenFolders();
                        new MediaProvider(activity).loadAlbums(activity, hiddenFolders,
                                new MediaProvider.OnMediaLoadedCallback() {
                                    final String dataLeAk1160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

									String dataLeAk1110 = "";

									String dataLeAk1109 = "";

									String dataLeAk1107 = "";

									@Override
                                    public void onMediaLoaded(ArrayList<Album> albums) {
                                        dataLeAk1107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1159-0", dataLeAk1159);
										android.util.Log.d("leak-1158-0", dataLeAk1158);
										android.util.Log.d("leak-1107-0", dataLeAk1107);
										android.util.Log.d("leak-1109-0", dataLeAk1109);
										android.util.Log.d("leak-1110-0", dataLeAk1110);
										//reload activity
                                        MediaProvider.loadAlbum(activity, newFilePath,
                                                new MediaProvider.OnAlbumLoadedCallback() {
                                                    String dataLeAk1108 = "";

													@Override
                                                    public void onAlbumLoaded(Album album) {
                                                        dataLeAk1108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
														android.util.Log.d("leak-1162-0", dataLeAk1162);
														android.util.Log.d("leak-1161-0", dataLeAk1161);
														android.util.Log.d("leak-1160-0", dataLeAk1160);
														android.util.Log.d("leak-1108-0", dataLeAk1108);
														AlbumActivity.this.album = album;
                                                        AlbumActivity.this.onAlbumLoaded(null);
                                                    }
                                                });
                                    }

                                    @Override
                                    public void timeout() {
                                        dataLeAk1109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1164-0", dataLeAk1164);
										android.util.Log.d("leak-1163-0", dataLeAk1163);
										android.util.Log.d("leak-1107-1", dataLeAk1107);
										android.util.Log.d("leak-1109-1", dataLeAk1109);
										android.util.Log.d("leak-1110-1", dataLeAk1110);
										finish();
                                    }

                                    @Override
                                    public void needPermission() {
                                        dataLeAk1110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1166-0", dataLeAk1166);
										android.util.Log.d("leak-1165-0", dataLeAk1165);
										android.util.Log.d("leak-1107-2", dataLeAk1107);
										android.util.Log.d("leak-1109-2", dataLeAk1109);
										android.util.Log.d("leak-1110-2", dataLeAk1110);
										finish();
                                    }
                                });
                    }
                }).show();
                break;
            case R.id.sort_by_date:
            case R.id.sort_by_name:
                item.setChecked(true);

                int sort_by = item.getItemId() == R.id.sort_by_date ?
                        SortUtil.BY_DATE : SortUtil.BY_NAME;
                Settings.getInstance(this).sortAlbumBy(this, sort_by);

                SortUtil.sort(album.getAlbumItems(), sort_by);

                recyclerView.getAdapter().notifyDataSetChanged();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
		dataLeAk1111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-7", dataLeAk1092);
		android.util.Log.d("leak-1098-7", dataLeAk1098);
		android.util.Log.d("leak-1100-7", dataLeAk1100);
		android.util.Log.d("leak-1101-7", dataLeAk1101);
		android.util.Log.d("leak-1103-7", dataLeAk1103);
		android.util.Log.d("leak-1104-7", dataLeAk1104);
		android.util.Log.d("leak-1105-7", dataLeAk1105);
		android.util.Log.d("leak-1111-7", dataLeAk1111);
		android.util.Log.d("leak-1112-7", dataLeAk1112);
		android.util.Log.d("leak-1113-7", dataLeAk1113);
		android.util.Log.d("leak-1116-7", dataLeAk1116);
		android.util.Log.d("leak-1118-7", dataLeAk1118);
		android.util.Log.d("leak-1119-7", dataLeAk1119);
		android.util.Log.d("leak-1120-7", dataLeAk1120);
		android.util.Log.d("leak-1122-7", dataLeAk1122);
		android.util.Log.d("leak-1125-7", dataLeAk1125);
		android.util.Log.d("leak-1127-7", dataLeAk1127);
		android.util.Log.d("leak-1130-7", dataLeAk1130);
		android.util.Log.d("leak-1134-7", dataLeAk1134);
		android.util.Log.d("leak-1135-7", dataLeAk1135);
		android.util.Log.d("leak-1136-7", dataLeAk1136);
		android.util.Log.d("leak-1137-7", dataLeAk1137);
		android.util.Log.d("leak-1138-7", dataLeAk1138);
		android.util.Log.d("leak-1139-7", dataLeAk1139);
		android.util.Log.d("leak-1140-7", dataLeAk1140);
		android.util.Log.d("leak-1141-7", dataLeAk1141);
		android.util.Log.d("leak-1142-7", dataLeAk1142);
		android.util.Log.d("leak-1143-7", dataLeAk1143);
		android.util.Log.d("leak-1144-7", dataLeAk1144);
		android.util.Log.d("leak-1147-7", dataLeAk1147);
        switch (resultCode) {
            default:
                if (data != null && data.getAction() != null) {
                    onNewIntent(data);
                }
                break;
        }
    }

    @Override
    public void onPermissionGranted() {
        super.onPermissionGranted();
		dataLeAk1112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-8", dataLeAk1092);
		android.util.Log.d("leak-1098-8", dataLeAk1098);
		android.util.Log.d("leak-1100-8", dataLeAk1100);
		android.util.Log.d("leak-1101-8", dataLeAk1101);
		android.util.Log.d("leak-1103-8", dataLeAk1103);
		android.util.Log.d("leak-1104-8", dataLeAk1104);
		android.util.Log.d("leak-1105-8", dataLeAk1105);
		android.util.Log.d("leak-1111-8", dataLeAk1111);
		android.util.Log.d("leak-1112-8", dataLeAk1112);
		android.util.Log.d("leak-1113-8", dataLeAk1113);
		android.util.Log.d("leak-1116-8", dataLeAk1116);
		android.util.Log.d("leak-1118-8", dataLeAk1118);
		android.util.Log.d("leak-1119-8", dataLeAk1119);
		android.util.Log.d("leak-1120-8", dataLeAk1120);
		android.util.Log.d("leak-1122-8", dataLeAk1122);
		android.util.Log.d("leak-1125-8", dataLeAk1125);
		android.util.Log.d("leak-1127-8", dataLeAk1127);
		android.util.Log.d("leak-1130-8", dataLeAk1130);
		android.util.Log.d("leak-1134-8", dataLeAk1134);
		android.util.Log.d("leak-1135-8", dataLeAk1135);
		android.util.Log.d("leak-1136-8", dataLeAk1136);
		android.util.Log.d("leak-1137-8", dataLeAk1137);
		android.util.Log.d("leak-1138-8", dataLeAk1138);
		android.util.Log.d("leak-1139-8", dataLeAk1139);
		android.util.Log.d("leak-1140-8", dataLeAk1140);
		android.util.Log.d("leak-1141-8", dataLeAk1141);
		android.util.Log.d("leak-1142-8", dataLeAk1142);
		android.util.Log.d("leak-1143-8", dataLeAk1143);
		android.util.Log.d("leak-1144-8", dataLeAk1144);
		android.util.Log.d("leak-1147-8", dataLeAk1147);
        this.finish();
    }

    public void deleteAlbumItemsSnackbar(String[] selected_items) {
        dataLeAk1113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-9", dataLeAk1092);
		android.util.Log.d("leak-1098-9", dataLeAk1098);
		android.util.Log.d("leak-1100-9", dataLeAk1100);
		android.util.Log.d("leak-1101-9", dataLeAk1101);
		android.util.Log.d("leak-1103-9", dataLeAk1103);
		android.util.Log.d("leak-1104-9", dataLeAk1104);
		android.util.Log.d("leak-1105-9", dataLeAk1105);
		android.util.Log.d("leak-1111-9", dataLeAk1111);
		android.util.Log.d("leak-1112-9", dataLeAk1112);
		android.util.Log.d("leak-1113-9", dataLeAk1113);
		android.util.Log.d("leak-1116-9", dataLeAk1116);
		android.util.Log.d("leak-1118-9", dataLeAk1118);
		android.util.Log.d("leak-1119-9", dataLeAk1119);
		android.util.Log.d("leak-1120-9", dataLeAk1120);
		android.util.Log.d("leak-1122-9", dataLeAk1122);
		android.util.Log.d("leak-1125-9", dataLeAk1125);
		android.util.Log.d("leak-1127-9", dataLeAk1127);
		android.util.Log.d("leak-1130-9", dataLeAk1130);
		android.util.Log.d("leak-1134-9", dataLeAk1134);
		android.util.Log.d("leak-1135-9", dataLeAk1135);
		android.util.Log.d("leak-1136-9", dataLeAk1136);
		android.util.Log.d("leak-1137-9", dataLeAk1137);
		android.util.Log.d("leak-1138-9", dataLeAk1138);
		android.util.Log.d("leak-1139-9", dataLeAk1139);
		android.util.Log.d("leak-1140-9", dataLeAk1140);
		android.util.Log.d("leak-1141-9", dataLeAk1141);
		android.util.Log.d("leak-1142-9", dataLeAk1142);
		android.util.Log.d("leak-1143-9", dataLeAk1143);
		android.util.Log.d("leak-1144-9", dataLeAk1144);
		android.util.Log.d("leak-1147-9", dataLeAk1147);
		if (!MediaProvider.checkPermission(this)) {
            return;
        }

        final int[] indices = new int[selected_items.length];
        final AlbumItem[] deletedItems = new AlbumItem[selected_items.length];
        for (int i = selected_items.length - 1; i >= 0; i--) {
            for (int k = 0; k < album.getAlbumItems().size(); k++) {
                AlbumItem albumItem = album.getAlbumItems().get(k);
                if (selected_items[i].equals(albumItem.getPath())) {
                    indices[i] = k;
                    deletedItems[i] = albumItem;
                    album.getAlbumItems().remove(k);
                    recyclerView.getAdapter().notifyItemRemoved(k);
                }
            }
        }

        int messageRes = selected_items.length == 1 ? R.string.file_deleted : R.string.files_deleted;
        String message = getString(messageRes, selected_items.length);

        //noinspection deprecation
        snackbar = Snackbar.make(findViewById(R.id.root_view), message, Snackbar.LENGTH_LONG)
                .setAction(R.string.undo, new View.OnClickListener() {
                    String dataLeAk1114 = "";

					@Override
                    public void onClick(View view) {
                        dataLeAk1114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1167-0", dataLeAk1167);
						android.util.Log.d("leak-1114-0", dataLeAk1114);
						for (int i = 0; i < deletedItems.length; i++) {
                            AlbumItem albumItem = deletedItems[i];
                            int index = indices[i];
                            album.getAlbumItems().add(index, albumItem);
                            recyclerView.getAdapter().notifyItemInserted(index);
                        }
                    }
                })
                .setCallback(new Snackbar.Callback() {
                    String dataLeAk1115 = "";

					@Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
						dataLeAk1115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1168-0", dataLeAk1168);
						android.util.Log.d("leak-1115-0", dataLeAk1115);
                        if (event != Snackbar.Callback.DISMISS_EVENT_ACTION) {
                            deleteAlbumItems(deletedItems, indices);
                        }
                    }
                });
        Util.showSnackbar(snackbar);
    }

    public void deleteAlbumItems(final AlbumItem[] selected_items, final int[] indices) {
        dataLeAk1116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-10", dataLeAk1092);
		android.util.Log.d("leak-1098-10", dataLeAk1098);
		android.util.Log.d("leak-1100-10", dataLeAk1100);
		android.util.Log.d("leak-1101-10", dataLeAk1101);
		android.util.Log.d("leak-1103-10", dataLeAk1103);
		android.util.Log.d("leak-1104-10", dataLeAk1104);
		android.util.Log.d("leak-1105-10", dataLeAk1105);
		android.util.Log.d("leak-1111-10", dataLeAk1111);
		android.util.Log.d("leak-1112-10", dataLeAk1112);
		android.util.Log.d("leak-1113-10", dataLeAk1113);
		android.util.Log.d("leak-1116-10", dataLeAk1116);
		android.util.Log.d("leak-1118-10", dataLeAk1118);
		android.util.Log.d("leak-1119-10", dataLeAk1119);
		android.util.Log.d("leak-1120-10", dataLeAk1120);
		android.util.Log.d("leak-1122-10", dataLeAk1122);
		android.util.Log.d("leak-1125-10", dataLeAk1125);
		android.util.Log.d("leak-1127-10", dataLeAk1127);
		android.util.Log.d("leak-1130-10", dataLeAk1130);
		android.util.Log.d("leak-1134-10", dataLeAk1134);
		android.util.Log.d("leak-1135-10", dataLeAk1135);
		android.util.Log.d("leak-1136-10", dataLeAk1136);
		android.util.Log.d("leak-1137-10", dataLeAk1137);
		android.util.Log.d("leak-1138-10", dataLeAk1138);
		android.util.Log.d("leak-1139-10", dataLeAk1139);
		android.util.Log.d("leak-1140-10", dataLeAk1140);
		android.util.Log.d("leak-1141-10", dataLeAk1141);
		android.util.Log.d("leak-1142-10", dataLeAk1142);
		android.util.Log.d("leak-1143-10", dataLeAk1143);
		android.util.Log.d("leak-1144-10", dataLeAk1144);
		android.util.Log.d("leak-1147-10", dataLeAk1147);
		File_POJO[] filesToDelete = new File_POJO[selected_items.length];
        for (int i = 0; i < filesToDelete.length; i++) {
            filesToDelete[i] = new File_POJO(selected_items[i].getPath(), true);
        }

        registerLocalBroadcastReceiver(new BroadcastReceiver() {
            String dataLeAk1117 = "";

			@Override
            public void onReceive(Context context, Intent intent) {
                dataLeAk1117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1169-0", dataLeAk1169);
				android.util.Log.d("leak-1117-0", dataLeAk1117);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        unregisterLocalBroadcastReceiver(this);
                        break;
                    case FileOperation.FAILED:
                        String path = intent.getStringExtra(FileOperation.FILES);
                        for (int i = 0; i < selected_items.length; i++) {
                            if (selected_items[i].getPath().equals(path)) {
                                int index = indices[i];
                                if (index < album.getAlbumItems().size()) {
                                    album.getAlbumItems().add(index, selected_items[i]);
                                } else {
                                    album.getAlbumItems().add(selected_items[i]);
                                }
                                recyclerView.getAdapter().notifyItemInserted(indices[i]);
                                break;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        startService(FileOperation.getDefaultIntent(
                this, FileOperation.DELETE, filesToDelete));
    }

    //needed to send multiple uris in intents
    private ClipData createClipData(AlbumItem[] items) {
        dataLeAk1118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-11", dataLeAk1092);
		android.util.Log.d("leak-1098-11", dataLeAk1098);
		android.util.Log.d("leak-1100-11", dataLeAk1100);
		android.util.Log.d("leak-1101-11", dataLeAk1101);
		android.util.Log.d("leak-1103-11", dataLeAk1103);
		android.util.Log.d("leak-1104-11", dataLeAk1104);
		android.util.Log.d("leak-1105-11", dataLeAk1105);
		android.util.Log.d("leak-1111-11", dataLeAk1111);
		android.util.Log.d("leak-1112-11", dataLeAk1112);
		android.util.Log.d("leak-1113-11", dataLeAk1113);
		android.util.Log.d("leak-1116-11", dataLeAk1116);
		android.util.Log.d("leak-1118-11", dataLeAk1118);
		android.util.Log.d("leak-1119-11", dataLeAk1119);
		android.util.Log.d("leak-1120-11", dataLeAk1120);
		android.util.Log.d("leak-1122-11", dataLeAk1122);
		android.util.Log.d("leak-1125-11", dataLeAk1125);
		android.util.Log.d("leak-1127-11", dataLeAk1127);
		android.util.Log.d("leak-1130-11", dataLeAk1130);
		android.util.Log.d("leak-1134-11", dataLeAk1134);
		android.util.Log.d("leak-1135-11", dataLeAk1135);
		android.util.Log.d("leak-1136-11", dataLeAk1136);
		android.util.Log.d("leak-1137-11", dataLeAk1137);
		android.util.Log.d("leak-1138-11", dataLeAk1138);
		android.util.Log.d("leak-1139-11", dataLeAk1139);
		android.util.Log.d("leak-1140-11", dataLeAk1140);
		android.util.Log.d("leak-1141-11", dataLeAk1141);
		android.util.Log.d("leak-1142-11", dataLeAk1142);
		android.util.Log.d("leak-1143-11", dataLeAk1143);
		android.util.Log.d("leak-1144-11", dataLeAk1144);
		android.util.Log.d("leak-1147-11", dataLeAk1147);
		String[] mimeTypes = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            mimeTypes[i] = MediaType.getMimeType(this, items[i].getUri(this));
        }

        ClipData clipData =
                new ClipData("Images", mimeTypes,
                        new ClipData.Item(items[0].getUri(this)));
        for (int i = 1; i < items.length; i++) {
            clipData.addItem(new ClipData.Item(items[i].getUri(this)));
        }
        return clipData;
    }

    public void setPhotosResult() {
        dataLeAk1119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-12", dataLeAk1092);
		android.util.Log.d("leak-1098-12", dataLeAk1098);
		android.util.Log.d("leak-1100-12", dataLeAk1100);
		android.util.Log.d("leak-1101-12", dataLeAk1101);
		android.util.Log.d("leak-1103-12", dataLeAk1103);
		android.util.Log.d("leak-1104-12", dataLeAk1104);
		android.util.Log.d("leak-1105-12", dataLeAk1105);
		android.util.Log.d("leak-1111-12", dataLeAk1111);
		android.util.Log.d("leak-1112-12", dataLeAk1112);
		android.util.Log.d("leak-1113-12", dataLeAk1113);
		android.util.Log.d("leak-1116-12", dataLeAk1116);
		android.util.Log.d("leak-1118-12", dataLeAk1118);
		android.util.Log.d("leak-1119-12", dataLeAk1119);
		android.util.Log.d("leak-1120-12", dataLeAk1120);
		android.util.Log.d("leak-1122-12", dataLeAk1122);
		android.util.Log.d("leak-1125-12", dataLeAk1125);
		android.util.Log.d("leak-1127-12", dataLeAk1127);
		android.util.Log.d("leak-1130-12", dataLeAk1130);
		android.util.Log.d("leak-1134-12", dataLeAk1134);
		android.util.Log.d("leak-1135-12", dataLeAk1135);
		android.util.Log.d("leak-1136-12", dataLeAk1136);
		android.util.Log.d("leak-1137-12", dataLeAk1137);
		android.util.Log.d("leak-1138-12", dataLeAk1138);
		android.util.Log.d("leak-1139-12", dataLeAk1139);
		android.util.Log.d("leak-1140-12", dataLeAk1140);
		android.util.Log.d("leak-1141-12", dataLeAk1141);
		android.util.Log.d("leak-1142-12", dataLeAk1142);
		android.util.Log.d("leak-1143-12", dataLeAk1143);
		android.util.Log.d("leak-1144-12", dataLeAk1144);
		android.util.Log.d("leak-1147-12", dataLeAk1147);
		final AlbumItem[] selected_items = SelectorModeManager.createAlbumItemArray(
                ((RecyclerViewAdapter) recyclerView.getAdapter()).cancelSelectorMode(this));

        Intent intent = new Intent("us.koller.RESULT_ACTION");
        if (allowMultiple) {
            ClipData clipData = createClipData(selected_items);
            intent.setClipData(clipData);
        } else {
            intent.setData(selected_items[0].getUri(this));
        }
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        setResult(RESULT_OK, intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            finish();
        }
    }

    @Override
    public void onSelectorModeEnter() {
        dataLeAk1120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-13", dataLeAk1092);
		android.util.Log.d("leak-1098-13", dataLeAk1098);
		android.util.Log.d("leak-1100-13", dataLeAk1100);
		android.util.Log.d("leak-1101-13", dataLeAk1101);
		android.util.Log.d("leak-1103-13", dataLeAk1103);
		android.util.Log.d("leak-1104-13", dataLeAk1104);
		android.util.Log.d("leak-1105-13", dataLeAk1105);
		android.util.Log.d("leak-1111-13", dataLeAk1111);
		android.util.Log.d("leak-1112-13", dataLeAk1112);
		android.util.Log.d("leak-1113-13", dataLeAk1113);
		android.util.Log.d("leak-1116-13", dataLeAk1116);
		android.util.Log.d("leak-1118-13", dataLeAk1118);
		android.util.Log.d("leak-1119-13", dataLeAk1119);
		android.util.Log.d("leak-1120-13", dataLeAk1120);
		android.util.Log.d("leak-1122-13", dataLeAk1122);
		android.util.Log.d("leak-1125-13", dataLeAk1125);
		android.util.Log.d("leak-1127-13", dataLeAk1127);
		android.util.Log.d("leak-1130-13", dataLeAk1130);
		android.util.Log.d("leak-1134-13", dataLeAk1134);
		android.util.Log.d("leak-1135-13", dataLeAk1135);
		android.util.Log.d("leak-1136-13", dataLeAk1136);
		android.util.Log.d("leak-1137-13", dataLeAk1137);
		android.util.Log.d("leak-1138-13", dataLeAk1138);
		android.util.Log.d("leak-1139-13", dataLeAk1139);
		android.util.Log.d("leak-1140-13", dataLeAk1140);
		android.util.Log.d("leak-1141-13", dataLeAk1141);
		android.util.Log.d("leak-1142-13", dataLeAk1142);
		android.util.Log.d("leak-1143-13", dataLeAk1143);
		android.util.Log.d("leak-1144-13", dataLeAk1144);
		android.util.Log.d("leak-1147-13", dataLeAk1147);
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

        handleMenuVisibilityForSelectorMode(true);

        if (!pick_photos) {
            ColorFade.fadeBackgroundColor(toolbar, toolbarColor, accentColor);

            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor, null);

            //fade overflow menu icon
            ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(), textColorSecondary, accentTextColor);

            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon instanceof Animatable) {
                ((Animatable) navIcon).start();
                ColorFade.fadeDrawableColor(navIcon, textColorSecondary, accentTextColor);
            }
            new Handler().postDelayed(new Runnable() {
                String dataLeAk1121 = "";

				@Override
                public void run() {
                    dataLeAk1121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1170-0", dataLeAk1170);
					android.util.Log.d("leak-1121-0", dataLeAk1121);
					Drawable d;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                                ContextCompat.getDrawable(AlbumActivity.this,
                                        R.drawable.cancel_to_back_avd);
                        //mutating avd to reset it
                        drawable.mutate();
                        d = drawable;
                    } else {
                        d = ContextCompat.getDrawable(AlbumActivity.this,
                                R.drawable.ic_clear_black_24dp);
                    }
                    d = DrawableCompat.wrap(d);
                    DrawableCompat.setTint(d.mutate(), accentTextColor);
                    toolbar.setNavigationIcon(d);
                }
            }, navIcon instanceof Animatable ? (int) (500 * Util.getAnimatorSpeed(this)) : 0);
        } else {
            toolbar.setBackgroundColor(accentColor);
            toolbar.setTitleTextColor(accentTextColor);
        }

        if (!pick_photos) {
            animateFab(true, false);
        }
    }

    @Override
    public void onSelectorModeExit() {
        dataLeAk1122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-14", dataLeAk1092);
		android.util.Log.d("leak-1098-14", dataLeAk1098);
		android.util.Log.d("leak-1100-14", dataLeAk1100);
		android.util.Log.d("leak-1101-14", dataLeAk1101);
		android.util.Log.d("leak-1103-14", dataLeAk1103);
		android.util.Log.d("leak-1104-14", dataLeAk1104);
		android.util.Log.d("leak-1105-14", dataLeAk1105);
		android.util.Log.d("leak-1111-14", dataLeAk1111);
		android.util.Log.d("leak-1112-14", dataLeAk1112);
		android.util.Log.d("leak-1113-14", dataLeAk1113);
		android.util.Log.d("leak-1116-14", dataLeAk1116);
		android.util.Log.d("leak-1118-14", dataLeAk1118);
		android.util.Log.d("leak-1119-14", dataLeAk1119);
		android.util.Log.d("leak-1120-14", dataLeAk1120);
		android.util.Log.d("leak-1122-14", dataLeAk1122);
		android.util.Log.d("leak-1125-14", dataLeAk1125);
		android.util.Log.d("leak-1127-14", dataLeAk1127);
		android.util.Log.d("leak-1130-14", dataLeAk1130);
		android.util.Log.d("leak-1134-14", dataLeAk1134);
		android.util.Log.d("leak-1135-14", dataLeAk1135);
		android.util.Log.d("leak-1136-14", dataLeAk1136);
		android.util.Log.d("leak-1137-14", dataLeAk1137);
		android.util.Log.d("leak-1138-14", dataLeAk1138);
		android.util.Log.d("leak-1139-14", dataLeAk1139);
		android.util.Log.d("leak-1140-14", dataLeAk1140);
		android.util.Log.d("leak-1141-14", dataLeAk1141);
		android.util.Log.d("leak-1142-14", dataLeAk1142);
		android.util.Log.d("leak-1143-14", dataLeAk1143);
		android.util.Log.d("leak-1144-14", dataLeAk1144);
		android.util.Log.d("leak-1147-14", dataLeAk1147);
		if (pick_photos) {
            return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(theme.elevatedToolbar());

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

        ColorFade.fadeBackgroundColor(toolbar, accentColor, toolbarColor);

        ColorFade.fadeToolbarTitleColor(toolbar, textColorPrimary,
                new ColorFade.ToolbarTitleFadeCallback() {
                    String dataLeAk1123 = "";

					@Override
                    public void setTitle(Toolbar toolbar) {
                        dataLeAk1123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1171-0", dataLeAk1171);
						android.util.Log.d("leak-1123-0", dataLeAk1123);
						toolbar.setTitle(album.getName());
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
            String dataLeAk1124 = "";

			@Override
            public void run() {
                dataLeAk1124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1172-0", dataLeAk1172);
				android.util.Log.d("leak-1124-0", dataLeAk1124);
				Drawable d;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                            ContextCompat.getDrawable(AlbumActivity.this,
                                    R.drawable.back_to_cancel_avd);
                    //mutating avd to reset it
                    drawable.mutate();
                    d = drawable;
                } else {
                    d = ContextCompat.getDrawable(AlbumActivity.this,
                            R.drawable.ic_arrow_back_white_24dp);
                }
                d = DrawableCompat.wrap(d);
                DrawableCompat.setTint(d.mutate(), textColorSecondary);
                toolbar.setNavigationIcon(d);
                handleMenuVisibilityForSelectorMode(false);
            }
        }, navIcon instanceof Animatable ? (int) (500 * Util.getAnimatorSpeed(this)) : 0);

        animateFab(false, false);
    }

    @Override
    public void onItemSelected(int selectedItemCount) {
        dataLeAk1125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-15", dataLeAk1092);
		android.util.Log.d("leak-1098-15", dataLeAk1098);
		android.util.Log.d("leak-1100-15", dataLeAk1100);
		android.util.Log.d("leak-1101-15", dataLeAk1101);
		android.util.Log.d("leak-1103-15", dataLeAk1103);
		android.util.Log.d("leak-1104-15", dataLeAk1104);
		android.util.Log.d("leak-1105-15", dataLeAk1105);
		android.util.Log.d("leak-1111-15", dataLeAk1111);
		android.util.Log.d("leak-1112-15", dataLeAk1112);
		android.util.Log.d("leak-1113-15", dataLeAk1113);
		android.util.Log.d("leak-1116-15", dataLeAk1116);
		android.util.Log.d("leak-1118-15", dataLeAk1118);
		android.util.Log.d("leak-1119-15", dataLeAk1119);
		android.util.Log.d("leak-1120-15", dataLeAk1120);
		android.util.Log.d("leak-1122-15", dataLeAk1122);
		android.util.Log.d("leak-1125-15", dataLeAk1125);
		android.util.Log.d("leak-1127-15", dataLeAk1127);
		android.util.Log.d("leak-1130-15", dataLeAk1130);
		android.util.Log.d("leak-1134-15", dataLeAk1134);
		android.util.Log.d("leak-1135-15", dataLeAk1135);
		android.util.Log.d("leak-1136-15", dataLeAk1136);
		android.util.Log.d("leak-1137-15", dataLeAk1137);
		android.util.Log.d("leak-1138-15", dataLeAk1138);
		android.util.Log.d("leak-1139-15", dataLeAk1139);
		android.util.Log.d("leak-1140-15", dataLeAk1140);
		android.util.Log.d("leak-1141-15", dataLeAk1141);
		android.util.Log.d("leak-1142-15", dataLeAk1142);
		android.util.Log.d("leak-1143-15", dataLeAk1143);
		android.util.Log.d("leak-1144-15", dataLeAk1144);
		android.util.Log.d("leak-1147-15", dataLeAk1147);
		if (selectedItemCount != 0) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            final String title = getString(R.string.selected_count, selectedItemCount);
            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk1126 = "";

						@Override
                        public void setTitle(Toolbar toolbar) {
                            dataLeAk1126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-1173-0", dataLeAk1173);
							android.util.Log.d("leak-1126-0", dataLeAk1126);
							toolbar.setTitle(title);
                        }
                    });
        }

        if (selectedItemCount > 0) {
            if (pick_photos) {
                if (allowMultiple) {
                    animateFab(true, false);
                } else {
                    setPhotosResult();
                }
            }
        } else {
            if (pick_photos) {
                animateFab(false, false);
            }
        }
    }

    public void fabClicked() {
        dataLeAk1127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-16", dataLeAk1092);
		android.util.Log.d("leak-1098-16", dataLeAk1098);
		android.util.Log.d("leak-1100-16", dataLeAk1100);
		android.util.Log.d("leak-1101-16", dataLeAk1101);
		android.util.Log.d("leak-1103-16", dataLeAk1103);
		android.util.Log.d("leak-1104-16", dataLeAk1104);
		android.util.Log.d("leak-1105-16", dataLeAk1105);
		android.util.Log.d("leak-1111-16", dataLeAk1111);
		android.util.Log.d("leak-1112-16", dataLeAk1112);
		android.util.Log.d("leak-1113-16", dataLeAk1113);
		android.util.Log.d("leak-1116-16", dataLeAk1116);
		android.util.Log.d("leak-1118-16", dataLeAk1118);
		android.util.Log.d("leak-1119-16", dataLeAk1119);
		android.util.Log.d("leak-1120-16", dataLeAk1120);
		android.util.Log.d("leak-1122-16", dataLeAk1122);
		android.util.Log.d("leak-1125-16", dataLeAk1125);
		android.util.Log.d("leak-1127-16", dataLeAk1127);
		android.util.Log.d("leak-1130-16", dataLeAk1130);
		android.util.Log.d("leak-1134-16", dataLeAk1134);
		android.util.Log.d("leak-1135-16", dataLeAk1135);
		android.util.Log.d("leak-1136-16", dataLeAk1136);
		android.util.Log.d("leak-1137-16", dataLeAk1137);
		android.util.Log.d("leak-1138-16", dataLeAk1138);
		android.util.Log.d("leak-1139-16", dataLeAk1139);
		android.util.Log.d("leak-1140-16", dataLeAk1140);
		android.util.Log.d("leak-1141-16", dataLeAk1141);
		android.util.Log.d("leak-1142-16", dataLeAk1142);
		android.util.Log.d("leak-1143-16", dataLeAk1143);
		android.util.Log.d("leak-1144-16", dataLeAk1144);
		android.util.Log.d("leak-1147-16", dataLeAk1147);
		animateFab(false, true);
        new Handler().postDelayed(new Runnable() {
            final String dataLeAk1175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk1128 = "";

			@Override
            public void run() {
                dataLeAk1128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1174-0", dataLeAk1174);
				android.util.Log.d("leak-1128-0", dataLeAk1128);
				if (!pick_photos) {
                    //deleteAlbumItemsSnackbar();
                    final String[] selected_items
                            = ((RecyclerViewAdapter) recyclerView.getAdapter())
                            .cancelSelectorMode(AlbumActivity.this);
                    new AlertDialog.Builder(AlbumActivity.this, theme.getDialogThemeRes())
                            .setTitle(getString(R.string.delete_files, selected_items.length) + "?")
                            .setNegativeButton(getString(R.string.no), null)
                            .setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                                String dataLeAk1129 = "";

								@Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dataLeAk1129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1176-0", dataLeAk1176);
									android.util.Log.d("leak-1175-0", dataLeAk1175);
									android.util.Log.d("leak-1129-0", dataLeAk1129);
									deleteAlbumItemsSnackbar(selected_items);
                                }
                            })
                            .create().show();
                } else {
                    setPhotosResult();
                }
            }
        }, (int) (400 * Util.getAnimatorSpeed(this)));
    }

    public void animateFab(final boolean show, boolean click) {
        dataLeAk1130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-17", dataLeAk1092);
		android.util.Log.d("leak-1098-17", dataLeAk1098);
		android.util.Log.d("leak-1100-17", dataLeAk1100);
		android.util.Log.d("leak-1101-17", dataLeAk1101);
		android.util.Log.d("leak-1103-17", dataLeAk1103);
		android.util.Log.d("leak-1104-17", dataLeAk1104);
		android.util.Log.d("leak-1105-17", dataLeAk1105);
		android.util.Log.d("leak-1111-17", dataLeAk1111);
		android.util.Log.d("leak-1112-17", dataLeAk1112);
		android.util.Log.d("leak-1113-17", dataLeAk1113);
		android.util.Log.d("leak-1116-17", dataLeAk1116);
		android.util.Log.d("leak-1118-17", dataLeAk1118);
		android.util.Log.d("leak-1119-17", dataLeAk1119);
		android.util.Log.d("leak-1120-17", dataLeAk1120);
		android.util.Log.d("leak-1122-17", dataLeAk1122);
		android.util.Log.d("leak-1125-17", dataLeAk1125);
		android.util.Log.d("leak-1127-17", dataLeAk1127);
		android.util.Log.d("leak-1130-17", dataLeAk1130);
		android.util.Log.d("leak-1134-17", dataLeAk1134);
		android.util.Log.d("leak-1135-17", dataLeAk1135);
		android.util.Log.d("leak-1136-17", dataLeAk1136);
		android.util.Log.d("leak-1137-17", dataLeAk1137);
		android.util.Log.d("leak-1138-17", dataLeAk1138);
		android.util.Log.d("leak-1139-17", dataLeAk1139);
		android.util.Log.d("leak-1140-17", dataLeAk1140);
		android.util.Log.d("leak-1141-17", dataLeAk1141);
		android.util.Log.d("leak-1142-17", dataLeAk1142);
		android.util.Log.d("leak-1143-17", dataLeAk1143);
		android.util.Log.d("leak-1144-17", dataLeAk1144);
		android.util.Log.d("leak-1147-17", dataLeAk1147);
		final FloatingActionButton fab = findViewById(R.id.fab);

        if ((fab.getScaleX() == 1.0f && show)
                || (fab.getScaleX() == 0.0f && !show)) {
            return;
        }

        if (show) {
            fab.setOnClickListener(new View.OnClickListener() {
                String dataLeAk1131 = "";

				@Override
                public void onClick(View view) {
                    dataLeAk1131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1177-0", dataLeAk1177);
					android.util.Log.d("leak-1131-0", dataLeAk1131);
					fabClicked();
                }
            });
        } else {
            fab.setOnClickListener(null);
        }
        if (click) {
            Drawable drawable = fab.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        }
        new Handler().postDelayed(new Runnable() {
            final String dataLeAk1179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk1132 = "";

			@Override
            public void run() {
                dataLeAk1132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1178-0", dataLeAk1178);
				android.util.Log.d("leak-1132-0", dataLeAk1132);
				fab.animate()
                        .scaleX(show ? 1.0f : 0.0f)
                        .scaleY(show ? 1.0f : 0.0f)
                        .alpha(show ? 1.0f : 0.0f)
                        .setDuration(250)
                        .setListener(new AnimatorListenerAdapter() {
                            String dataLeAk1133 = "";

							@Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
								dataLeAk1133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-1180-0", dataLeAk1180);
								android.util.Log.d("leak-1179-0", dataLeAk1179);
								android.util.Log.d("leak-1133-0", dataLeAk1133);
                                if (show) {
                                    Drawable drawable = fab.getDrawable();
                                    if (drawable instanceof Animatable) {
                                        ((Animatable) drawable).start();
                                    }
                                }
                            }
                        })
                        .start();
            }
        }, click ? (int) (400 * Util.getAnimatorSpeed(this)) : 0);
    }

    @Override
    public void onBackPressed() {
        dataLeAk1134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-18", dataLeAk1092);
		android.util.Log.d("leak-1098-18", dataLeAk1098);
		android.util.Log.d("leak-1100-18", dataLeAk1100);
		android.util.Log.d("leak-1101-18", dataLeAk1101);
		android.util.Log.d("leak-1103-18", dataLeAk1103);
		android.util.Log.d("leak-1104-18", dataLeAk1104);
		android.util.Log.d("leak-1105-18", dataLeAk1105);
		android.util.Log.d("leak-1111-18", dataLeAk1111);
		android.util.Log.d("leak-1112-18", dataLeAk1112);
		android.util.Log.d("leak-1113-18", dataLeAk1113);
		android.util.Log.d("leak-1116-18", dataLeAk1116);
		android.util.Log.d("leak-1118-18", dataLeAk1118);
		android.util.Log.d("leak-1119-18", dataLeAk1119);
		android.util.Log.d("leak-1120-18", dataLeAk1120);
		android.util.Log.d("leak-1122-18", dataLeAk1122);
		android.util.Log.d("leak-1125-18", dataLeAk1125);
		android.util.Log.d("leak-1127-18", dataLeAk1127);
		android.util.Log.d("leak-1130-18", dataLeAk1130);
		android.util.Log.d("leak-1134-18", dataLeAk1134);
		android.util.Log.d("leak-1135-18", dataLeAk1135);
		android.util.Log.d("leak-1136-18", dataLeAk1136);
		android.util.Log.d("leak-1137-18", dataLeAk1137);
		android.util.Log.d("leak-1138-18", dataLeAk1138);
		android.util.Log.d("leak-1139-18", dataLeAk1139);
		android.util.Log.d("leak-1140-18", dataLeAk1140);
		android.util.Log.d("leak-1141-18", dataLeAk1141);
		android.util.Log.d("leak-1142-18", dataLeAk1142);
		android.util.Log.d("leak-1143-18", dataLeAk1143);
		android.util.Log.d("leak-1144-18", dataLeAk1144);
		android.util.Log.d("leak-1147-18", dataLeAk1147);
		if (recyclerView != null && recyclerView.getAdapter() != null &&
                ((RecyclerViewAdapter) recyclerView.getAdapter()).onBackPressed()) {
            animateFab(false, false);
        } else if (snackbar != null) {
            snackbar.dismiss();
            snackbar = null;
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk1135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-19", dataLeAk1092);
		android.util.Log.d("leak-1098-19", dataLeAk1098);
		android.util.Log.d("leak-1100-19", dataLeAk1100);
		android.util.Log.d("leak-1101-19", dataLeAk1101);
		android.util.Log.d("leak-1103-19", dataLeAk1103);
		android.util.Log.d("leak-1104-19", dataLeAk1104);
		android.util.Log.d("leak-1105-19", dataLeAk1105);
		android.util.Log.d("leak-1111-19", dataLeAk1111);
		android.util.Log.d("leak-1112-19", dataLeAk1112);
		android.util.Log.d("leak-1113-19", dataLeAk1113);
		android.util.Log.d("leak-1116-19", dataLeAk1116);
		android.util.Log.d("leak-1118-19", dataLeAk1118);
		android.util.Log.d("leak-1119-19", dataLeAk1119);
		android.util.Log.d("leak-1120-19", dataLeAk1120);
		android.util.Log.d("leak-1122-19", dataLeAk1122);
		android.util.Log.d("leak-1125-19", dataLeAk1125);
		android.util.Log.d("leak-1127-19", dataLeAk1127);
		android.util.Log.d("leak-1130-19", dataLeAk1130);
		android.util.Log.d("leak-1134-19", dataLeAk1134);
		android.util.Log.d("leak-1135-19", dataLeAk1135);
		android.util.Log.d("leak-1136-19", dataLeAk1136);
		android.util.Log.d("leak-1137-19", dataLeAk1137);
		android.util.Log.d("leak-1138-19", dataLeAk1138);
		android.util.Log.d("leak-1139-19", dataLeAk1139);
		android.util.Log.d("leak-1140-19", dataLeAk1140);
		android.util.Log.d("leak-1141-19", dataLeAk1141);
		android.util.Log.d("leak-1142-19", dataLeAk1142);
		android.util.Log.d("leak-1143-19", dataLeAk1143);
		android.util.Log.d("leak-1144-19", dataLeAk1144);
		android.util.Log.d("leak-1147-19", dataLeAk1147);
        //outState.putParcelable(ALBUM, album);
        if (recyclerView != null) {
            outState.putParcelable(RECYCLER_VIEW_SCROLL_STATE,
                    recyclerView.getLayoutManager().onSaveInstanceState());
            RecyclerViewAdapter adapter = ((RecyclerViewAdapter) recyclerView.getAdapter());
            if (adapter != null) {
                adapter.saveInstanceState(outState);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		dataLeAk1136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-20", dataLeAk1092);
		android.util.Log.d("leak-1098-20", dataLeAk1098);
		android.util.Log.d("leak-1100-20", dataLeAk1100);
		android.util.Log.d("leak-1101-20", dataLeAk1101);
		android.util.Log.d("leak-1103-20", dataLeAk1103);
		android.util.Log.d("leak-1104-20", dataLeAk1104);
		android.util.Log.d("leak-1105-20", dataLeAk1105);
		android.util.Log.d("leak-1111-20", dataLeAk1111);
		android.util.Log.d("leak-1112-20", dataLeAk1112);
		android.util.Log.d("leak-1113-20", dataLeAk1113);
		android.util.Log.d("leak-1116-20", dataLeAk1116);
		android.util.Log.d("leak-1118-20", dataLeAk1118);
		android.util.Log.d("leak-1119-20", dataLeAk1119);
		android.util.Log.d("leak-1120-20", dataLeAk1120);
		android.util.Log.d("leak-1122-20", dataLeAk1122);
		android.util.Log.d("leak-1125-20", dataLeAk1125);
		android.util.Log.d("leak-1127-20", dataLeAk1127);
		android.util.Log.d("leak-1130-20", dataLeAk1130);
		android.util.Log.d("leak-1134-20", dataLeAk1134);
		android.util.Log.d("leak-1135-20", dataLeAk1135);
		android.util.Log.d("leak-1136-20", dataLeAk1136);
		android.util.Log.d("leak-1137-20", dataLeAk1137);
		android.util.Log.d("leak-1138-20", dataLeAk1138);
		android.util.Log.d("leak-1139-20", dataLeAk1139);
		android.util.Log.d("leak-1140-20", dataLeAk1140);
		android.util.Log.d("leak-1141-20", dataLeAk1141);
		android.util.Log.d("leak-1142-20", dataLeAk1142);
		android.util.Log.d("leak-1143-20", dataLeAk1143);
		android.util.Log.d("leak-1144-20", dataLeAk1144);
		android.util.Log.d("leak-1147-20", dataLeAk1147);

        Provider.saveExcludedPaths(this);
        Provider.savePinnedPaths(this);
    }

    @Override
    public boolean canSwipeBack(int dir) {
        dataLeAk1137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-21", dataLeAk1092);
		android.util.Log.d("leak-1098-21", dataLeAk1098);
		android.util.Log.d("leak-1100-21", dataLeAk1100);
		android.util.Log.d("leak-1101-21", dataLeAk1101);
		android.util.Log.d("leak-1103-21", dataLeAk1103);
		android.util.Log.d("leak-1104-21", dataLeAk1104);
		android.util.Log.d("leak-1105-21", dataLeAk1105);
		android.util.Log.d("leak-1111-21", dataLeAk1111);
		android.util.Log.d("leak-1112-21", dataLeAk1112);
		android.util.Log.d("leak-1113-21", dataLeAk1113);
		android.util.Log.d("leak-1116-21", dataLeAk1116);
		android.util.Log.d("leak-1118-21", dataLeAk1118);
		android.util.Log.d("leak-1119-21", dataLeAk1119);
		android.util.Log.d("leak-1120-21", dataLeAk1120);
		android.util.Log.d("leak-1122-21", dataLeAk1122);
		android.util.Log.d("leak-1125-21", dataLeAk1125);
		android.util.Log.d("leak-1127-21", dataLeAk1127);
		android.util.Log.d("leak-1130-21", dataLeAk1130);
		android.util.Log.d("leak-1134-21", dataLeAk1134);
		android.util.Log.d("leak-1135-21", dataLeAk1135);
		android.util.Log.d("leak-1136-21", dataLeAk1136);
		android.util.Log.d("leak-1137-21", dataLeAk1137);
		android.util.Log.d("leak-1138-21", dataLeAk1138);
		android.util.Log.d("leak-1139-21", dataLeAk1139);
		android.util.Log.d("leak-1140-21", dataLeAk1140);
		android.util.Log.d("leak-1141-21", dataLeAk1141);
		android.util.Log.d("leak-1142-21", dataLeAk1142);
		android.util.Log.d("leak-1143-21", dataLeAk1143);
		android.util.Log.d("leak-1144-21", dataLeAk1144);
		android.util.Log.d("leak-1147-21", dataLeAk1147);
		RecyclerViewAdapter adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
        return !adapter.isSelectorModeActive() &&
                SwipeBackCoordinatorLayout.canSwipeBackForThisView(recyclerView, dir) && !pick_photos;
    }

    @Override
    public void onSwipeProcess(float percent) {
        dataLeAk1138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-22", dataLeAk1092);
		android.util.Log.d("leak-1098-22", dataLeAk1098);
		android.util.Log.d("leak-1100-22", dataLeAk1100);
		android.util.Log.d("leak-1101-22", dataLeAk1101);
		android.util.Log.d("leak-1103-22", dataLeAk1103);
		android.util.Log.d("leak-1104-22", dataLeAk1104);
		android.util.Log.d("leak-1105-22", dataLeAk1105);
		android.util.Log.d("leak-1111-22", dataLeAk1111);
		android.util.Log.d("leak-1112-22", dataLeAk1112);
		android.util.Log.d("leak-1113-22", dataLeAk1113);
		android.util.Log.d("leak-1116-22", dataLeAk1116);
		android.util.Log.d("leak-1118-22", dataLeAk1118);
		android.util.Log.d("leak-1119-22", dataLeAk1119);
		android.util.Log.d("leak-1120-22", dataLeAk1120);
		android.util.Log.d("leak-1122-22", dataLeAk1122);
		android.util.Log.d("leak-1125-22", dataLeAk1125);
		android.util.Log.d("leak-1127-22", dataLeAk1127);
		android.util.Log.d("leak-1130-22", dataLeAk1130);
		android.util.Log.d("leak-1134-22", dataLeAk1134);
		android.util.Log.d("leak-1135-22", dataLeAk1135);
		android.util.Log.d("leak-1136-22", dataLeAk1136);
		android.util.Log.d("leak-1137-22", dataLeAk1137);
		android.util.Log.d("leak-1138-22", dataLeAk1138);
		android.util.Log.d("leak-1139-22", dataLeAk1139);
		android.util.Log.d("leak-1140-22", dataLeAk1140);
		android.util.Log.d("leak-1141-22", dataLeAk1141);
		android.util.Log.d("leak-1142-22", dataLeAk1142);
		android.util.Log.d("leak-1143-22", dataLeAk1143);
		android.util.Log.d("leak-1144-22", dataLeAk1144);
		android.util.Log.d("leak-1147-22", dataLeAk1147);
		getWindow().getDecorView().setBackgroundColor(
                SwipeBackCoordinatorLayout.getBackgroundColor(percent));
        boolean selectorModeActive = ((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive();
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
        dataLeAk1139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-23", dataLeAk1092);
		android.util.Log.d("leak-1098-23", dataLeAk1098);
		android.util.Log.d("leak-1100-23", dataLeAk1100);
		android.util.Log.d("leak-1101-23", dataLeAk1101);
		android.util.Log.d("leak-1103-23", dataLeAk1103);
		android.util.Log.d("leak-1104-23", dataLeAk1104);
		android.util.Log.d("leak-1105-23", dataLeAk1105);
		android.util.Log.d("leak-1111-23", dataLeAk1111);
		android.util.Log.d("leak-1112-23", dataLeAk1112);
		android.util.Log.d("leak-1113-23", dataLeAk1113);
		android.util.Log.d("leak-1116-23", dataLeAk1116);
		android.util.Log.d("leak-1118-23", dataLeAk1118);
		android.util.Log.d("leak-1119-23", dataLeAk1119);
		android.util.Log.d("leak-1120-23", dataLeAk1120);
		android.util.Log.d("leak-1122-23", dataLeAk1122);
		android.util.Log.d("leak-1125-23", dataLeAk1125);
		android.util.Log.d("leak-1127-23", dataLeAk1127);
		android.util.Log.d("leak-1130-23", dataLeAk1130);
		android.util.Log.d("leak-1134-23", dataLeAk1134);
		android.util.Log.d("leak-1135-23", dataLeAk1135);
		android.util.Log.d("leak-1136-23", dataLeAk1136);
		android.util.Log.d("leak-1137-23", dataLeAk1137);
		android.util.Log.d("leak-1138-23", dataLeAk1138);
		android.util.Log.d("leak-1139-23", dataLeAk1139);
		android.util.Log.d("leak-1140-23", dataLeAk1140);
		android.util.Log.d("leak-1141-23", dataLeAk1141);
		android.util.Log.d("leak-1142-23", dataLeAk1142);
		android.util.Log.d("leak-1143-23", dataLeAk1143);
		android.util.Log.d("leak-1144-23", dataLeAk1144);
		android.util.Log.d("leak-1147-23", dataLeAk1147);
		if (((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive()) {
            ((RecyclerViewAdapter) recyclerView.getAdapter()).cancelSelectorMode(null);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setReturnTransition(new TransitionSet()
                    .setOrdering(TransitionSet.ORDERING_TOGETHER)
                    .addTransition(new Slide(dir > 0 ? Gravity.TOP : Gravity.BOTTOM))
                    .addTransition(new Fade())
                    .setInterpolator(new AccelerateDecelerateInterpolator()));
        }
        finish();
    }

    @Override
    public int getDarkThemeRes() {
        dataLeAk1140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-24", dataLeAk1092);
		android.util.Log.d("leak-1098-24", dataLeAk1098);
		android.util.Log.d("leak-1100-24", dataLeAk1100);
		android.util.Log.d("leak-1101-24", dataLeAk1101);
		android.util.Log.d("leak-1103-24", dataLeAk1103);
		android.util.Log.d("leak-1104-24", dataLeAk1104);
		android.util.Log.d("leak-1105-24", dataLeAk1105);
		android.util.Log.d("leak-1111-24", dataLeAk1111);
		android.util.Log.d("leak-1112-24", dataLeAk1112);
		android.util.Log.d("leak-1113-24", dataLeAk1113);
		android.util.Log.d("leak-1116-24", dataLeAk1116);
		android.util.Log.d("leak-1118-24", dataLeAk1118);
		android.util.Log.d("leak-1119-24", dataLeAk1119);
		android.util.Log.d("leak-1120-24", dataLeAk1120);
		android.util.Log.d("leak-1122-24", dataLeAk1122);
		android.util.Log.d("leak-1125-24", dataLeAk1125);
		android.util.Log.d("leak-1127-24", dataLeAk1127);
		android.util.Log.d("leak-1130-24", dataLeAk1130);
		android.util.Log.d("leak-1134-24", dataLeAk1134);
		android.util.Log.d("leak-1135-24", dataLeAk1135);
		android.util.Log.d("leak-1136-24", dataLeAk1136);
		android.util.Log.d("leak-1137-24", dataLeAk1137);
		android.util.Log.d("leak-1138-24", dataLeAk1138);
		android.util.Log.d("leak-1139-24", dataLeAk1139);
		android.util.Log.d("leak-1140-24", dataLeAk1140);
		android.util.Log.d("leak-1141-24", dataLeAk1141);
		android.util.Log.d("leak-1142-24", dataLeAk1142);
		android.util.Log.d("leak-1143-24", dataLeAk1143);
		android.util.Log.d("leak-1144-24", dataLeAk1144);
		android.util.Log.d("leak-1147-24", dataLeAk1147);
		return R.style.CameraRoll_Theme_Translucent_Album;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk1141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-25", dataLeAk1092);
		android.util.Log.d("leak-1098-25", dataLeAk1098);
		android.util.Log.d("leak-1100-25", dataLeAk1100);
		android.util.Log.d("leak-1101-25", dataLeAk1101);
		android.util.Log.d("leak-1103-25", dataLeAk1103);
		android.util.Log.d("leak-1104-25", dataLeAk1104);
		android.util.Log.d("leak-1105-25", dataLeAk1105);
		android.util.Log.d("leak-1111-25", dataLeAk1111);
		android.util.Log.d("leak-1112-25", dataLeAk1112);
		android.util.Log.d("leak-1113-25", dataLeAk1113);
		android.util.Log.d("leak-1116-25", dataLeAk1116);
		android.util.Log.d("leak-1118-25", dataLeAk1118);
		android.util.Log.d("leak-1119-25", dataLeAk1119);
		android.util.Log.d("leak-1120-25", dataLeAk1120);
		android.util.Log.d("leak-1122-25", dataLeAk1122);
		android.util.Log.d("leak-1125-25", dataLeAk1125);
		android.util.Log.d("leak-1127-25", dataLeAk1127);
		android.util.Log.d("leak-1130-25", dataLeAk1130);
		android.util.Log.d("leak-1134-25", dataLeAk1134);
		android.util.Log.d("leak-1135-25", dataLeAk1135);
		android.util.Log.d("leak-1136-25", dataLeAk1136);
		android.util.Log.d("leak-1137-25", dataLeAk1137);
		android.util.Log.d("leak-1138-25", dataLeAk1138);
		android.util.Log.d("leak-1139-25", dataLeAk1139);
		android.util.Log.d("leak-1140-25", dataLeAk1140);
		android.util.Log.d("leak-1141-25", dataLeAk1141);
		android.util.Log.d("leak-1142-25", dataLeAk1142);
		android.util.Log.d("leak-1143-25", dataLeAk1143);
		android.util.Log.d("leak-1144-25", dataLeAk1144);
		android.util.Log.d("leak-1147-25", dataLeAk1147);
		return R.style.CameraRoll_Theme_Light_Translucent_Album;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        dataLeAk1142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-26", dataLeAk1092);
		android.util.Log.d("leak-1098-26", dataLeAk1098);
		android.util.Log.d("leak-1100-26", dataLeAk1100);
		android.util.Log.d("leak-1101-26", dataLeAk1101);
		android.util.Log.d("leak-1103-26", dataLeAk1103);
		android.util.Log.d("leak-1104-26", dataLeAk1104);
		android.util.Log.d("leak-1105-26", dataLeAk1105);
		android.util.Log.d("leak-1111-26", dataLeAk1111);
		android.util.Log.d("leak-1112-26", dataLeAk1112);
		android.util.Log.d("leak-1113-26", dataLeAk1113);
		android.util.Log.d("leak-1116-26", dataLeAk1116);
		android.util.Log.d("leak-1118-26", dataLeAk1118);
		android.util.Log.d("leak-1119-26", dataLeAk1119);
		android.util.Log.d("leak-1120-26", dataLeAk1120);
		android.util.Log.d("leak-1122-26", dataLeAk1122);
		android.util.Log.d("leak-1125-26", dataLeAk1125);
		android.util.Log.d("leak-1127-26", dataLeAk1127);
		android.util.Log.d("leak-1130-26", dataLeAk1130);
		android.util.Log.d("leak-1134-26", dataLeAk1134);
		android.util.Log.d("leak-1135-26", dataLeAk1135);
		android.util.Log.d("leak-1136-26", dataLeAk1136);
		android.util.Log.d("leak-1137-26", dataLeAk1137);
		android.util.Log.d("leak-1138-26", dataLeAk1138);
		android.util.Log.d("leak-1139-26", dataLeAk1139);
		android.util.Log.d("leak-1140-26", dataLeAk1140);
		android.util.Log.d("leak-1141-26", dataLeAk1141);
		android.util.Log.d("leak-1142-26", dataLeAk1142);
		android.util.Log.d("leak-1143-26", dataLeAk1143);
		android.util.Log.d("leak-1144-26", dataLeAk1144);
		android.util.Log.d("leak-1147-26", dataLeAk1147);
		if (pick_photos) {
            return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setBackgroundTintList(ColorStateList.valueOf(accentColor));

        if (theme.darkStatusBarIcons()) {
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        if (theme.statusBarOverlay()) {
            addStatusBarOverlay(toolbar);
        }
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        dataLeAk1143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-27", dataLeAk1092);
		android.util.Log.d("leak-1098-27", dataLeAk1098);
		android.util.Log.d("leak-1100-27", dataLeAk1100);
		android.util.Log.d("leak-1101-27", dataLeAk1101);
		android.util.Log.d("leak-1103-27", dataLeAk1103);
		android.util.Log.d("leak-1104-27", dataLeAk1104);
		android.util.Log.d("leak-1105-27", dataLeAk1105);
		android.util.Log.d("leak-1111-27", dataLeAk1111);
		android.util.Log.d("leak-1112-27", dataLeAk1112);
		android.util.Log.d("leak-1113-27", dataLeAk1113);
		android.util.Log.d("leak-1116-27", dataLeAk1116);
		android.util.Log.d("leak-1118-27", dataLeAk1118);
		android.util.Log.d("leak-1119-27", dataLeAk1119);
		android.util.Log.d("leak-1120-27", dataLeAk1120);
		android.util.Log.d("leak-1122-27", dataLeAk1122);
		android.util.Log.d("leak-1125-27", dataLeAk1125);
		android.util.Log.d("leak-1127-27", dataLeAk1127);
		android.util.Log.d("leak-1130-27", dataLeAk1130);
		android.util.Log.d("leak-1134-27", dataLeAk1134);
		android.util.Log.d("leak-1135-27", dataLeAk1135);
		android.util.Log.d("leak-1136-27", dataLeAk1136);
		android.util.Log.d("leak-1137-27", dataLeAk1137);
		android.util.Log.d("leak-1138-27", dataLeAk1138);
		android.util.Log.d("leak-1139-27", dataLeAk1139);
		android.util.Log.d("leak-1140-27", dataLeAk1140);
		android.util.Log.d("leak-1141-27", dataLeAk1141);
		android.util.Log.d("leak-1142-27", dataLeAk1142);
		android.util.Log.d("leak-1143-27", dataLeAk1143);
		android.util.Log.d("leak-1144-27", dataLeAk1144);
		android.util.Log.d("leak-1147-27", dataLeAk1147);
		IntentFilter filter = FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
        filter.addAction(ALBUM_ITEM_REMOVED);
        filter.addAction(ALBUM_ITEM_RENAMED);
        filter.addAction(DATA_CHANGED);
        return filter;
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        dataLeAk1144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-28", dataLeAk1092);
		android.util.Log.d("leak-1098-28", dataLeAk1098);
		android.util.Log.d("leak-1100-28", dataLeAk1100);
		android.util.Log.d("leak-1101-28", dataLeAk1101);
		android.util.Log.d("leak-1103-28", dataLeAk1103);
		android.util.Log.d("leak-1104-28", dataLeAk1104);
		android.util.Log.d("leak-1105-28", dataLeAk1105);
		android.util.Log.d("leak-1111-28", dataLeAk1111);
		android.util.Log.d("leak-1112-28", dataLeAk1112);
		android.util.Log.d("leak-1113-28", dataLeAk1113);
		android.util.Log.d("leak-1116-28", dataLeAk1116);
		android.util.Log.d("leak-1118-28", dataLeAk1118);
		android.util.Log.d("leak-1119-28", dataLeAk1119);
		android.util.Log.d("leak-1120-28", dataLeAk1120);
		android.util.Log.d("leak-1122-28", dataLeAk1122);
		android.util.Log.d("leak-1125-28", dataLeAk1125);
		android.util.Log.d("leak-1127-28", dataLeAk1127);
		android.util.Log.d("leak-1130-28", dataLeAk1130);
		android.util.Log.d("leak-1134-28", dataLeAk1134);
		android.util.Log.d("leak-1135-28", dataLeAk1135);
		android.util.Log.d("leak-1136-28", dataLeAk1136);
		android.util.Log.d("leak-1137-28", dataLeAk1137);
		android.util.Log.d("leak-1138-28", dataLeAk1138);
		android.util.Log.d("leak-1139-28", dataLeAk1139);
		android.util.Log.d("leak-1140-28", dataLeAk1140);
		android.util.Log.d("leak-1141-28", dataLeAk1141);
		android.util.Log.d("leak-1142-28", dataLeAk1142);
		android.util.Log.d("leak-1143-28", dataLeAk1143);
		android.util.Log.d("leak-1144-28", dataLeAk1144);
		android.util.Log.d("leak-1147-28", dataLeAk1147);
		return new BroadcastReceiver() {
            final String dataLeAk1182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk1145 = "";

			@Override
            public void onReceive(Context context, Intent intent) {
                dataLeAk1145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1181-0", dataLeAk1181);
				android.util.Log.d("leak-1145-0", dataLeAk1145);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        int type = intent.getIntExtra(FileOperation.TYPE, FileOperation.EMPTY);
                        if (type == FileOperation.MOVE) {
                            ArrayList<String> movedFilesPaths = intent
                                    .getStringArrayListExtra(Move.MOVED_FILES_PATHS);
                            for (int i = 0; i < movedFilesPaths.size(); i++) {
                                String path = movedFilesPaths.get(i);
                                removeAlbumItem(path);
                            }
                        }
                        break;
                    case ALBUM_ITEM_REMOVED:
                        String path = intent.getStringExtra(ItemActivity.ALBUM_ITEM_PATH);
                        removeAlbumItem(path);
                        break;
                    case ALBUM_ITEM_RENAMED:
                    case DATA_CHANGED:
                        String albumPath = getIntent().getStringExtra(ALBUM_PATH);
                        MediaProvider.loadAlbum(AlbumActivity.this, albumPath,
                                new MediaProvider.OnAlbumLoadedCallback() {
                                    String dataLeAk1146 = "";

									@Override
                                    public void onAlbumLoaded(Album album) {
                                        dataLeAk1146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1183-0", dataLeAk1183);
										android.util.Log.d("leak-1182-0", dataLeAk1182);
										android.util.Log.d("leak-1146-0", dataLeAk1146);
										AlbumActivity.this.album = album;
                                        AlbumActivity.this.onAlbumLoaded(null);
                                    }
                                });
                        break;
                    default:
                        break;
                }
            }
        };
    }

    private void removeAlbumItem(String path) {
        dataLeAk1147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1092-29", dataLeAk1092);
		android.util.Log.d("leak-1098-29", dataLeAk1098);
		android.util.Log.d("leak-1100-29", dataLeAk1100);
		android.util.Log.d("leak-1101-29", dataLeAk1101);
		android.util.Log.d("leak-1103-29", dataLeAk1103);
		android.util.Log.d("leak-1104-29", dataLeAk1104);
		android.util.Log.d("leak-1105-29", dataLeAk1105);
		android.util.Log.d("leak-1111-29", dataLeAk1111);
		android.util.Log.d("leak-1112-29", dataLeAk1112);
		android.util.Log.d("leak-1113-29", dataLeAk1113);
		android.util.Log.d("leak-1116-29", dataLeAk1116);
		android.util.Log.d("leak-1118-29", dataLeAk1118);
		android.util.Log.d("leak-1119-29", dataLeAk1119);
		android.util.Log.d("leak-1120-29", dataLeAk1120);
		android.util.Log.d("leak-1122-29", dataLeAk1122);
		android.util.Log.d("leak-1125-29", dataLeAk1125);
		android.util.Log.d("leak-1127-29", dataLeAk1127);
		android.util.Log.d("leak-1130-29", dataLeAk1130);
		android.util.Log.d("leak-1134-29", dataLeAk1134);
		android.util.Log.d("leak-1135-29", dataLeAk1135);
		android.util.Log.d("leak-1136-29", dataLeAk1136);
		android.util.Log.d("leak-1137-29", dataLeAk1137);
		android.util.Log.d("leak-1138-29", dataLeAk1138);
		android.util.Log.d("leak-1139-29", dataLeAk1139);
		android.util.Log.d("leak-1140-29", dataLeAk1140);
		android.util.Log.d("leak-1141-29", dataLeAk1141);
		android.util.Log.d("leak-1142-29", dataLeAk1142);
		android.util.Log.d("leak-1143-29", dataLeAk1143);
		android.util.Log.d("leak-1144-29", dataLeAk1144);
		android.util.Log.d("leak-1147-29", dataLeAk1147);
		int index = -1;
        for (int i = 0; i < album.getAlbumItems().size(); i++) {
            AlbumItem albumItem = album.getAlbumItems().get(i);
            if (albumItem.getPath().equals(path)) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            album.getAlbumItems().remove(index);
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
