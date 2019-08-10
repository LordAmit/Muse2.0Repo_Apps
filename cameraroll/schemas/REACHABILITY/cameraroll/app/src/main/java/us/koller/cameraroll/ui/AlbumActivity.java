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

    String dataLeAk2149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2149 = android.util.Log.d("leak-2149", dataLeAk2149);

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
        String dataLeAk2150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2150 = android.util.Log.d("leak-2150", dataLeAk2150);

		@Override
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            String dataLeAk2151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2151 = android.util.Log.d("leak-2151", dataLeAk2151);
			if (sharedElementReturnPosition != -1 && album != null &&
                    sharedElementReturnPosition < album.getAlbumItems().size()) {
                String dataLeAk2152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2152 = android.util.Log.d("leak-2152", dataLeAk2152);
				String newTransitionName = album.getAlbumItems().get(sharedElementReturnPosition).getPath();
                View layout = recyclerView.findViewWithTag(newTransitionName);
                View newSharedElement = layout != null ? layout.findViewById(R.id.image) : null;
                if (newSharedElement != null) {
                    String dataLeAk2153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2153 = android.util.Log.d("leak-2153", dataLeAk2153);
					names.clear();
                    names.add(newTransitionName);
                    sharedElements.clear();
                    sharedElements.put(newTransitionName, newSharedElement);
                }
                sharedElementReturnPosition = -1;
            } else {
                String dataLeAk2154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2154 = android.util.Log.d("leak-2154", dataLeAk2154);
				View navigationBar = findViewById(android.R.id.navigationBarBackground);
                View statusBar = findViewById(android.R.id.statusBarBackground);
                if (navigationBar != null) {
                    String dataLeAk2155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2155 = android.util.Log.d("leak-2155", dataLeAk2155);
					names.add(navigationBar.getTransitionName());
                    sharedElements.put(navigationBar.getTransitionName(), navigationBar);
                }
                if (statusBar != null) {
                    String dataLeAk2156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2156 = android.util.Log.d("leak-2156", dataLeAk2156);
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
		String dataLeAk2157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2157 = android.util.Log.d("leak-2157", dataLeAk2157);
        setContentView(R.layout.activity_album);

        pick_photos = getIntent().getAction() != null
                && getIntent().getAction().equals(MainActivity.PICK_PHOTOS);
        allowMultiple = getIntent().getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);

        MediaProvider.checkPermission(this);

        setExitSharedElementCallback(mCallback);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2158 = android.util.Log.d("leak-2158", dataLeAk2158);
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
            String dataLeAk2159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2159 = android.util.Log.d("leak-2159", dataLeAk2159);
			((SwipeBackCoordinatorLayout) swipeBackView).setOnSwipeListener(this);
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (!pick_photos) {
            String dataLeAk2160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2160 = android.util.Log.d("leak-2160", dataLeAk2160);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk2161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2161 = android.util.Log.d("leak-2161", dataLeAk2161);
				AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                        ContextCompat.getDrawable(AlbumActivity.this, R.drawable.back_to_cancel_avd);
                //mutating avd to reset it
                drawable.mutate();
                toolbar.setNavigationIcon(drawable);
            } else {
                String dataLeAk2162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2162 = android.util.Log.d("leak-2162", dataLeAk2162);
				toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            }
            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon != null) {
                String dataLeAk2163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2163 = android.util.Log.d("leak-2163", dataLeAk2163);
				navIcon = DrawableCompat.wrap(navIcon);
                DrawableCompat.setTint(navIcon.mutate(), textColorSecondary);
                toolbar.setNavigationIcon(navIcon);
            }
        } else {
            String dataLeAk2164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2164 = android.util.Log.d("leak-2164", dataLeAk2164);
			if (actionBar != null) {
                String dataLeAk2165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2165 = android.util.Log.d("leak-2165", dataLeAk2165);
				actionBar.setTitle(allowMultiple ? getString(R.string.pick_photos) :
                        getString(R.string.pick_photo));
            }
            toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon != null) {
                String dataLeAk2166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2166 = android.util.Log.d("leak-2166", dataLeAk2166);
				navIcon = DrawableCompat.wrap(navIcon);
                DrawableCompat.setTint(navIcon.mutate(), accentTextColor);
                toolbar.setNavigationIcon(navIcon);
            }
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
            Util.colorToolbarOverflowMenuIcon(toolbar, accentTextColor);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            String dataLeAk2167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2167 = android.util.Log.d("leak-2167", dataLeAk2167);

			@Override
            public void onClick(View view) {
                String dataLeAk2168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2168 = android.util.Log.d("leak-2168", dataLeAk2168);
				RecyclerViewAdapter adapter = null;
                if (recyclerView != null) {
                    String dataLeAk2169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2169 = android.util.Log.d("leak-2169", dataLeAk2169);
					adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
                }
                if (adapter != null && adapter.isSelectorModeActive()) {
                    String dataLeAk2170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2170 = android.util.Log.d("leak-2170", dataLeAk2170);
					adapter.cancelSelectorMode(null);
                } else {
                    String dataLeAk2171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2171 = android.util.Log.d("leak-2171", dataLeAk2171);
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
            String dataLeAk2172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2172 = android.util.Log.d("leak-2172", dataLeAk2172);
			recyclerView.getLayoutManager().onRestoreInstanceState(
                    savedInstanceState.getParcelable(RECYCLER_VIEW_SCROLL_STATE));
        }

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            //private float scrollY = 0.0f;

            String dataLeAk2173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2173 = android.util.Log.d("leak-2173", dataLeAk2173);

			@Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
				String dataLeAk2174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2174 = android.util.Log.d("leak-2174", dataLeAk2174);
                if (((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive()
                        || pick_photos) {
                    String dataLeAk2175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2175 = android.util.Log.d("leak-2175", dataLeAk2175);
					return;
                }

                float translationY = toolbar.getTranslationY() - dy;
                if (-translationY > toolbar.getHeight()) {
                    String dataLeAk2176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2176 = android.util.Log.d("leak-2176", dataLeAk2176);
					translationY = -toolbar.getHeight();
                    if (theme.elevatedToolbar()) {
                        String dataLeAk2177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2177 = android.util.Log.d("leak-2177", dataLeAk2177);
						toolbar.setActivated(true);
                    }
                } else if (translationY > 0) {
                    String dataLeAk2178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2178 = android.util.Log.d("leak-2178", dataLeAk2178);
					translationY = 0;
                    if (theme.elevatedToolbar() &&
                            !recyclerView.canScrollVertically(-1)) {
                        String dataLeAk2179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2179 = android.util.Log.d("leak-2179", dataLeAk2179);
						toolbar.setActivated(false);
                    }
                }
                toolbar.setTranslationY(translationY);

                //animate statusBarIcon color
                if (theme.darkStatusBarIcons()) {
                    String dataLeAk2180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2180 = android.util.Log.d("leak-2180", dataLeAk2180);
					float animatedValue = (-translationY) / toolbar.getHeight();
                    if (animatedValue > 0.9f) {
                        String dataLeAk2181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2181 = android.util.Log.d("leak-2181", dataLeAk2181);
						Util.setLightStatusBarIcons(findViewById(R.id.root_view));
                    } else {
                        String dataLeAk2182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2182 = android.util.Log.d("leak-2182", dataLeAk2182);
						Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
                    }
                }
            }
        });

        final FloatingActionButton fab = findViewById(R.id.fab);
        if (!pick_photos) {
            String dataLeAk2183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2183 = android.util.Log.d("leak-2183", dataLeAk2183);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk2184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2184 = android.util.Log.d("leak-2184", dataLeAk2184);
				Drawable d = ContextCompat.getDrawable(this,
                        R.drawable.ic_delete_avd);
                fab.setImageDrawable(d);
            } else {
                String dataLeAk2185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2185 = android.util.Log.d("leak-2185", dataLeAk2185);
				fab.setImageResource(R.drawable.ic_delete_white_24dp);
            }
        } else {
            String dataLeAk2186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2186 = android.util.Log.d("leak-2186", dataLeAk2186);
			fab.setImageResource(R.drawable.ic_send_white_24dp);
        }
        Drawable d = fab.getDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2187 = android.util.Log.d("leak-2187", dataLeAk2187);
			d.setTint(accentTextColor);
        } else {
            String dataLeAk2188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2188 = android.util.Log.d("leak-2188", dataLeAk2188);
			d = DrawableCompat.wrap(d);
            DrawableCompat.setTint(d.mutate(), accentTextColor);
        }
        fab.setImageDrawable(d);
        fab.setScaleX(0.0f);
        fab.setScaleY(0.0f);

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk2189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2189 = android.util.Log.d("leak-2189", dataLeAk2189);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk2190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2190 = android.util.Log.d("leak-2190", dataLeAk2190);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2191 = android.util.Log.d("leak-2191", dataLeAk2191);
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
            String dataLeAk2192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2192 = android.util.Log.d("leak-2192", dataLeAk2192);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk2193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2193 = android.util.Log.d("leak-2193", dataLeAk2193);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk2194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2194 = android.util.Log.d("leak-2194", dataLeAk2194);
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
            String dataLeAk2195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2195 = android.util.Log.d("leak-2195", dataLeAk2195);
			path = savedInstanceState.getString(ALBUM_PATH);
        } else {
            String dataLeAk2196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2196 = android.util.Log.d("leak-2196", dataLeAk2196);
			path = getIntent().getStringExtra(ALBUM_PATH);
        }
        MediaProvider.loadAlbum(this, path,
                new MediaProvider.OnAlbumLoadedCallback() {
                    String dataLeAk2197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2197 = android.util.Log.d("leak-2197", dataLeAk2197);

					@Override
                    public void onAlbumLoaded(Album album) {
                        String dataLeAk2198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2198 = android.util.Log.d("leak-2198", dataLeAk2198);
						AlbumActivity.this.album = album;
                        AlbumActivity.this.onAlbumLoaded(savedInstanceState);
                    }
                });

    }

    private void onAlbumLoaded(Bundle savedInstanceState) {
        String dataLeAk2199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2199 = android.util.Log.d("leak-2199", dataLeAk2199);
		int sort_by = Settings.getInstance(this).sortAlbumBy();
        SortUtil.sort(album.getAlbumItems(), sort_by);

        ActionBar actionBar = getSupportActionBar();
        if (!pick_photos && actionBar != null) {
            String dataLeAk2200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2200 = android.util.Log.d("leak-2200", dataLeAk2200);
			actionBar.setTitle(album.getName());
        }

        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, recyclerView, album, pick_photos);
        recyclerView.setAdapter(adapter);

        //restore Selector mode, when needed
        if (savedInstanceState != null) {
            String dataLeAk2201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2201 = android.util.Log.d("leak-2201", dataLeAk2201);
			final SelectorModeManager manager = new SelectorModeManager(savedInstanceState);
            manager.addCallback(this);
            adapter.setSelectorModeManager(manager);
            final View rootView = findViewById(R.id.root_view);
            rootView.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {
                        String dataLeAk2202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2202 = android.util.Log.d("leak-2202", dataLeAk2202);

						@Override
                        public void onGlobalLayout() {
                            String dataLeAk2203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2203 = android.util.Log.d("leak-2203", dataLeAk2203);
							rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            if (manager.isSelectorModeActive()) {
                                String dataLeAk2204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2204 = android.util.Log.d("leak-2204", dataLeAk2204);
								adapter.restoreSelectedItems();
                            }
                        }
                    });

        }

        if (!pick_photos && menu != null) {
            String dataLeAk2205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2205 = android.util.Log.d("leak-2205", dataLeAk2205);
			setupMenu();
        }
    }

    private void setupMenu() {
        String dataLeAk2206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2206 = android.util.Log.d("leak-2206", dataLeAk2206);
		if (album instanceof VirtualAlbum) {
            String dataLeAk2207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2207 = android.util.Log.d("leak-2207", dataLeAk2207);
			menu.findItem(R.id.exclude).setVisible(false);
            menu.findItem(R.id.rename).setVisible(false);
        } else {
            String dataLeAk2208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2208 = android.util.Log.d("leak-2208", dataLeAk2208);
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
            String dataLeAk2209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2209 = android.util.Log.d("leak-2209", dataLeAk2209);
			handleMenuVisibilityForSelectorMode(true);
        }
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onActivityReenter(int requestCode, Intent data) {
        /*super.onActivityReenter(requestCode, data);*/
        Log.d("AlbumActivity", "onActivityReenter: " + this);
		String dataLeAk2210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2210 = android.util.Log.d("leak-2210", dataLeAk2210);
        if (data != null) {
            String dataLeAk2211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2211 = android.util.Log.d("leak-2211", dataLeAk2211);
			sharedElementReturnPosition = data.getIntExtra(EXTRA_CURRENT_ALBUM_POSITION, -1);
            if (sharedElementReturnPosition > -1 && album != null
                    && sharedElementReturnPosition < album.getAlbumItems().size()) {
                String dataLeAk2212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2212 = android.util.Log.d("leak-2212", dataLeAk2212);
				AlbumItem albumItem = album.getAlbumItems().get(sharedElementReturnPosition);
                albumItem.isSharedElement = true;
                postponeEnterTransition();
                recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    String dataLeAk2213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2213 = android.util.Log.d("leak-2213", dataLeAk2213);

					@Override
                    public void onLayoutChange(View v, int l, int t, int r, int b,
                                               int oL, int oT, int oR, int oB) {
                        String dataLeAk2214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk2214 = android.util.Log.d("leak-2214", dataLeAk2214);
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
        String dataLeAk2215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2215 = android.util.Log.d("leak-2215", dataLeAk2215);
		getMenuInflater().inflate(R.menu.album, menu);
        this.menu = menu;

        if (pick_photos) {
            String dataLeAk2216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2216 = android.util.Log.d("leak-2216", dataLeAk2216);
			menu.findItem(R.id.share).setVisible(false);
            menu.findItem(R.id.exclude).setVisible(false);
            menu.findItem(R.id.pin).setVisible(false);
            menu.findItem(R.id.rename).setVisible(false);
            menu.findItem(R.id.copy).setVisible(false);
            menu.findItem(R.id.move).setVisible(false);
        } else if (album != null) {
            String dataLeAk2217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2217 = android.util.Log.d("leak-2217", dataLeAk2217);
			setupMenu();
        }

        int sort_by = Settings.getInstance(this).sortAlbumBy();
        if (sort_by == SortUtil.BY_DATE) {
            String dataLeAk2218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2218 = android.util.Log.d("leak-2218", dataLeAk2218);
			menu.findItem(R.id.sort_by_date).setChecked(true);
        } else if (sort_by == SortUtil.BY_NAME) {
            String dataLeAk2219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2219 = android.util.Log.d("leak-2219", dataLeAk2219);
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
        String dataLeAk2220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2220 = android.util.Log.d("leak-2220", dataLeAk2220);
		if (menu != null) {
            String dataLeAk2221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2221 = android.util.Log.d("leak-2221", dataLeAk2221);
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
        String dataLeAk2222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2222 = android.util.Log.d("leak-2222", dataLeAk2222);
		final String[] selected_items_paths;
        Intent intent;
        switch (item.getItemId()) {
            case R.id.select_all:
                RecyclerViewAdapter adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
                SelectorModeManager manager = adapter.getSelectorManager();
                String[] paths = new String[album.getAlbumItems().size()];
                for (int i = 0; i < album.getAlbumItems().size(); i++) {
                    String dataLeAk2223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2223 = android.util.Log.d("leak-2223", dataLeAk2223);
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
                    String dataLeAk2224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2224 = android.util.Log.d("leak-2224", dataLeAk2224);
					uris.add(StorageUtil.getContentUri(this, selected_items_paths[i]));
                }

                intent = new Intent()
                        .setAction(Intent.ACTION_SEND_MULTIPLE)
                        .setType(MediaType.getMimeType(this, uris.get(0)))
                        .putExtra(Intent.EXTRA_STREAM, uris);

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION
                        | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    String dataLeAk2225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2225 = android.util.Log.d("leak-2225", dataLeAk2225);
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
                    String dataLeAk2226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2226 = android.util.Log.d("leak-2226", dataLeAk2226);
					Provider.addExcludedPath(this, album.getPath());
                    album.excluded = true;
                } else {
                    String dataLeAk2227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2227 = android.util.Log.d("leak-2227", dataLeAk2227);
					Provider.removeExcludedPath(this, album.getPath());
                    album.excluded = false;
                }
                item.setChecked(album.excluded);
                break;
            case R.id.pin:
                Provider.loadPinnedPaths(this);
                if (!album.pinned) {
                    String dataLeAk2228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2228 = android.util.Log.d("leak-2228", dataLeAk2228);
					Provider.pinPath(this, album.getPath());
                    album.pinned = true;
                } else {
                    String dataLeAk2229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2229 = android.util.Log.d("leak-2229", dataLeAk2229);
					Provider.unpinPath(this, album.getPath());
                    album.pinned = false;
                }
                item.setChecked(album.pinned);
                break;
            case R.id.rename:
                File_POJO file = new File_POJO(album.getPath(), false).setName(album.getName());
                Rename.Util.getRenameDialog(this, file, new BroadcastReceiver() {
                    String dataLeAk2230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2230 = android.util.Log.d("leak-2230", dataLeAk2230);

					@Override
                    public void onReceive(Context context, Intent intent) {
                        String dataLeAk2231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2231 = android.util.Log.d("leak-2231", dataLeAk2231);
						final Activity activity = AlbumActivity.this;

                        final String newFilePath = intent.getStringExtra(Rename.NEW_FILE_PATH);
                        getIntent().putExtra(ALBUM_PATH, newFilePath);

                        boolean hiddenFolders = Settings.getInstance(activity).getHiddenFolders();
                        new MediaProvider(activity).loadAlbums(activity, hiddenFolders,
                                new MediaProvider.OnMediaLoadedCallback() {
                                    String dataLeAk2232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2232 = android.util.Log.d("leak-2232", dataLeAk2232);

									@Override
                                    public void onMediaLoaded(ArrayList<Album> albums) {
                                        String dataLeAk2233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2233 = android.util.Log.d("leak-2233", dataLeAk2233);
										//reload activity
                                        MediaProvider.loadAlbum(activity, newFilePath,
                                                new MediaProvider.OnAlbumLoadedCallback() {
                                                    String dataLeAk2234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk2234 = android.util.Log.d("leak-2234", dataLeAk2234);

													@Override
                                                    public void onAlbumLoaded(Album album) {
                                                        String dataLeAk2235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
														Object throwawayLeAk2235 = android.util.Log.d("leak-2235", dataLeAk2235);
														AlbumActivity.this.album = album;
                                                        AlbumActivity.this.onAlbumLoaded(null);
                                                    }
                                                });
                                    }

                                    @Override
                                    public void timeout() {
                                        String dataLeAk2236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2236 = android.util.Log.d("leak-2236", dataLeAk2236);
										finish();
                                    }

                                    @Override
                                    public void needPermission() {
                                        String dataLeAk2237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2237 = android.util.Log.d("leak-2237", dataLeAk2237);
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
		String dataLeAk2238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2238 = android.util.Log.d("leak-2238", dataLeAk2238);
        switch (resultCode) {
            default:
                if (data != null && data.getAction() != null) {
                    String dataLeAk2239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2239 = android.util.Log.d("leak-2239", dataLeAk2239);
					onNewIntent(data);
                }
                break;
        }
    }

    @Override
    public void onPermissionGranted() {
        super.onPermissionGranted();
		String dataLeAk2240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2240 = android.util.Log.d("leak-2240", dataLeAk2240);
        this.finish();
    }

    public void deleteAlbumItemsSnackbar(String[] selected_items) {
        String dataLeAk2241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2241 = android.util.Log.d("leak-2241", dataLeAk2241);
		if (!MediaProvider.checkPermission(this)) {
            String dataLeAk2242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2242 = android.util.Log.d("leak-2242", dataLeAk2242);
			return;
        }

        final int[] indices = new int[selected_items.length];
        final AlbumItem[] deletedItems = new AlbumItem[selected_items.length];
        for (int i = selected_items.length - 1; i >= 0; i--) {
            String dataLeAk2243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2243 = android.util.Log.d("leak-2243", dataLeAk2243);
			for (int k = 0; k < album.getAlbumItems().size(); k++) {
                String dataLeAk2244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2244 = android.util.Log.d("leak-2244", dataLeAk2244);
				AlbumItem albumItem = album.getAlbumItems().get(k);
                if (selected_items[i].equals(albumItem.getPath())) {
                    String dataLeAk2245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2245 = android.util.Log.d("leak-2245", dataLeAk2245);
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
                    String dataLeAk2246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2246 = android.util.Log.d("leak-2246", dataLeAk2246);

					@Override
                    public void onClick(View view) {
                        String dataLeAk2247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2247 = android.util.Log.d("leak-2247", dataLeAk2247);
						for (int i = 0; i < deletedItems.length; i++) {
                            String dataLeAk2248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2248 = android.util.Log.d("leak-2248", dataLeAk2248);
							AlbumItem albumItem = deletedItems[i];
                            int index = indices[i];
                            album.getAlbumItems().add(index, albumItem);
                            recyclerView.getAdapter().notifyItemInserted(index);
                        }
                    }
                })
                .setCallback(new Snackbar.Callback() {
                    String dataLeAk2249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2249 = android.util.Log.d("leak-2249", dataLeAk2249);

					@Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
						String dataLeAk2250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2250 = android.util.Log.d("leak-2250", dataLeAk2250);
                        if (event != Snackbar.Callback.DISMISS_EVENT_ACTION) {
                            String dataLeAk2251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2251 = android.util.Log.d("leak-2251", dataLeAk2251);
							deleteAlbumItems(deletedItems, indices);
                        }
                    }
                });
        Util.showSnackbar(snackbar);
    }

    public void deleteAlbumItems(final AlbumItem[] selected_items, final int[] indices) {
        String dataLeAk2252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2252 = android.util.Log.d("leak-2252", dataLeAk2252);
		File_POJO[] filesToDelete = new File_POJO[selected_items.length];
        for (int i = 0; i < filesToDelete.length; i++) {
            String dataLeAk2253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2253 = android.util.Log.d("leak-2253", dataLeAk2253);
			filesToDelete[i] = new File_POJO(selected_items[i].getPath(), true);
        }

        registerLocalBroadcastReceiver(new BroadcastReceiver() {
            String dataLeAk2254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2254 = android.util.Log.d("leak-2254", dataLeAk2254);

			@Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk2255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2255 = android.util.Log.d("leak-2255", dataLeAk2255);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        unregisterLocalBroadcastReceiver(this);
                        break;
                    case FileOperation.FAILED:
                        String path = intent.getStringExtra(FileOperation.FILES);
                        for (int i = 0; i < selected_items.length; i++) {
                            String dataLeAk2256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2256 = android.util.Log.d("leak-2256", dataLeAk2256);
							if (selected_items[i].getPath().equals(path)) {
                                String dataLeAk2257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2257 = android.util.Log.d("leak-2257", dataLeAk2257);
								int index = indices[i];
                                if (index < album.getAlbumItems().size()) {
                                    String dataLeAk2258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2258 = android.util.Log.d("leak-2258", dataLeAk2258);
									album.getAlbumItems().add(index, selected_items[i]);
                                } else {
                                    String dataLeAk2259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2259 = android.util.Log.d("leak-2259", dataLeAk2259);
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
        String dataLeAk2260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2260 = android.util.Log.d("leak-2260", dataLeAk2260);
		String[] mimeTypes = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            String dataLeAk2261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2261 = android.util.Log.d("leak-2261", dataLeAk2261);
			mimeTypes[i] = MediaType.getMimeType(this, items[i].getUri(this));
        }

        ClipData clipData =
                new ClipData("Images", mimeTypes,
                        new ClipData.Item(items[0].getUri(this)));
        for (int i = 1; i < items.length; i++) {
            String dataLeAk2262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2262 = android.util.Log.d("leak-2262", dataLeAk2262);
			clipData.addItem(new ClipData.Item(items[i].getUri(this)));
        }
        return clipData;
    }

    public void setPhotosResult() {
        String dataLeAk2263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2263 = android.util.Log.d("leak-2263", dataLeAk2263);
		final AlbumItem[] selected_items = SelectorModeManager.createAlbumItemArray(
                ((RecyclerViewAdapter) recyclerView.getAdapter()).cancelSelectorMode(this));

        Intent intent = new Intent("us.koller.RESULT_ACTION");
        if (allowMultiple) {
            String dataLeAk2264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2264 = android.util.Log.d("leak-2264", dataLeAk2264);
			ClipData clipData = createClipData(selected_items);
            intent.setClipData(clipData);
        } else {
            String dataLeAk2265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2265 = android.util.Log.d("leak-2265", dataLeAk2265);
			intent.setData(selected_items[0].getUri(this));
        }
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        setResult(RESULT_OK, intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2266 = android.util.Log.d("leak-2266", dataLeAk2266);
			finishAfterTransition();
        } else {
            String dataLeAk2267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2267 = android.util.Log.d("leak-2267", dataLeAk2267);
			finish();
        }
    }

    @Override
    public void onSelectorModeEnter() {
        String dataLeAk2268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2268 = android.util.Log.d("leak-2268", dataLeAk2268);
		final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(true);
        toolbar.animate().translationY(0.0f).start();

        if (theme.darkStatusBarIconsInSelectorMode()) {
            String dataLeAk2269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2269 = android.util.Log.d("leak-2269", dataLeAk2269);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk2270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2270 = android.util.Log.d("leak-2270", dataLeAk2270);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            String dataLeAk2271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2271 = android.util.Log.d("leak-2271", dataLeAk2271);
			ColorFade.fadeDrawableAlpha(statusBarOverlay, 0);
        }

        handleMenuVisibilityForSelectorMode(true);

        if (!pick_photos) {
            String dataLeAk2272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2272 = android.util.Log.d("leak-2272", dataLeAk2272);
			ColorFade.fadeBackgroundColor(toolbar, toolbarColor, accentColor);

            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor, null);

            //fade overflow menu icon
            ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(), textColorSecondary, accentTextColor);

            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon instanceof Animatable) {
                String dataLeAk2273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2273 = android.util.Log.d("leak-2273", dataLeAk2273);
				((Animatable) navIcon).start();
                ColorFade.fadeDrawableColor(navIcon, textColorSecondary, accentTextColor);
            }
            new Handler().postDelayed(new Runnable() {
                String dataLeAk2274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2274 = android.util.Log.d("leak-2274", dataLeAk2274);

				@Override
                public void run() {
                    String dataLeAk2275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2275 = android.util.Log.d("leak-2275", dataLeAk2275);
					Drawable d;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        String dataLeAk2276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2276 = android.util.Log.d("leak-2276", dataLeAk2276);
						AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                                ContextCompat.getDrawable(AlbumActivity.this,
                                        R.drawable.cancel_to_back_avd);
                        //mutating avd to reset it
                        drawable.mutate();
                        d = drawable;
                    } else {
                        String dataLeAk2277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2277 = android.util.Log.d("leak-2277", dataLeAk2277);
						d = ContextCompat.getDrawable(AlbumActivity.this,
                                R.drawable.ic_clear_black_24dp);
                    }
                    d = DrawableCompat.wrap(d);
                    DrawableCompat.setTint(d.mutate(), accentTextColor);
                    toolbar.setNavigationIcon(d);
                }
            }, navIcon instanceof Animatable ? (int) (500 * Util.getAnimatorSpeed(this)) : 0);
        } else {
            String dataLeAk2278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2278 = android.util.Log.d("leak-2278", dataLeAk2278);
			toolbar.setBackgroundColor(accentColor);
            toolbar.setTitleTextColor(accentTextColor);
        }

        if (!pick_photos) {
            String dataLeAk2279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2279 = android.util.Log.d("leak-2279", dataLeAk2279);
			animateFab(true, false);
        }
    }

    @Override
    public void onSelectorModeExit() {
        String dataLeAk2280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2280 = android.util.Log.d("leak-2280", dataLeAk2280);
		if (pick_photos) {
            String dataLeAk2281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2281 = android.util.Log.d("leak-2281", dataLeAk2281);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(theme.elevatedToolbar());

        if (theme.darkStatusBarIcons()) {
            String dataLeAk2282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2282 = android.util.Log.d("leak-2282", dataLeAk2282);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk2283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2283 = android.util.Log.d("leak-2283", dataLeAk2283);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            String dataLeAk2284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2284 = android.util.Log.d("leak-2284", dataLeAk2284);
			int alpha = Color.alpha(getStatusBarColor());
            ColorFade.fadeDrawableAlpha(statusBarOverlay, alpha);
        }

        ColorFade.fadeBackgroundColor(toolbar, accentColor, toolbarColor);

        ColorFade.fadeToolbarTitleColor(toolbar, textColorPrimary,
                new ColorFade.ToolbarTitleFadeCallback() {
                    String dataLeAk2285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2285 = android.util.Log.d("leak-2285", dataLeAk2285);

					@Override
                    public void setTitle(Toolbar toolbar) {
                        String dataLeAk2286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2286 = android.util.Log.d("leak-2286", dataLeAk2286);
						toolbar.setTitle(album.getName());
                    }
                });

        //fade overflow menu icon
        ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(), accentTextColor, textColorSecondary);

        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon instanceof Animatable) {
            String dataLeAk2287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2287 = android.util.Log.d("leak-2287", dataLeAk2287);
			((Animatable) navIcon).start();
            ColorFade.fadeDrawableColor(navIcon, accentTextColor, textColorSecondary);
        }
        new Handler().postDelayed(new Runnable() {
            String dataLeAk2288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2288 = android.util.Log.d("leak-2288", dataLeAk2288);

			@Override
            public void run() {
                String dataLeAk2289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2289 = android.util.Log.d("leak-2289", dataLeAk2289);
				Drawable d;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String dataLeAk2290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2290 = android.util.Log.d("leak-2290", dataLeAk2290);
					AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                            ContextCompat.getDrawable(AlbumActivity.this,
                                    R.drawable.back_to_cancel_avd);
                    //mutating avd to reset it
                    drawable.mutate();
                    d = drawable;
                } else {
                    String dataLeAk2291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2291 = android.util.Log.d("leak-2291", dataLeAk2291);
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
        String dataLeAk2292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2292 = android.util.Log.d("leak-2292", dataLeAk2292);
		if (selectedItemCount != 0) {
            String dataLeAk2293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2293 = android.util.Log.d("leak-2293", dataLeAk2293);
			Toolbar toolbar = findViewById(R.id.toolbar);
            final String title = getString(R.string.selected_count, selectedItemCount);
            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        String dataLeAk2294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2294 = android.util.Log.d("leak-2294", dataLeAk2294);

						@Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk2295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2295 = android.util.Log.d("leak-2295", dataLeAk2295);
							toolbar.setTitle(title);
                        }
                    });
        }

        if (selectedItemCount > 0) {
            String dataLeAk2296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2296 = android.util.Log.d("leak-2296", dataLeAk2296);
			if (pick_photos) {
                String dataLeAk2297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2297 = android.util.Log.d("leak-2297", dataLeAk2297);
				if (allowMultiple) {
                    String dataLeAk2298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2298 = android.util.Log.d("leak-2298", dataLeAk2298);
					animateFab(true, false);
                } else {
                    String dataLeAk2299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2299 = android.util.Log.d("leak-2299", dataLeAk2299);
					setPhotosResult();
                }
            }
        } else {
            String dataLeAk2300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2300 = android.util.Log.d("leak-2300", dataLeAk2300);
			if (pick_photos) {
                String dataLeAk2301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2301 = android.util.Log.d("leak-2301", dataLeAk2301);
				animateFab(false, false);
            }
        }
    }

    public void fabClicked() {
        String dataLeAk2302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2302 = android.util.Log.d("leak-2302", dataLeAk2302);
		animateFab(false, true);
        new Handler().postDelayed(new Runnable() {
            String dataLeAk2303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2303 = android.util.Log.d("leak-2303", dataLeAk2303);

			@Override
            public void run() {
                String dataLeAk2304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2304 = android.util.Log.d("leak-2304", dataLeAk2304);
				if (!pick_photos) {
                    String dataLeAk2305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2305 = android.util.Log.d("leak-2305", dataLeAk2305);
					//deleteAlbumItemsSnackbar();
                    final String[] selected_items
                            = ((RecyclerViewAdapter) recyclerView.getAdapter())
                            .cancelSelectorMode(AlbumActivity.this);
                    new AlertDialog.Builder(AlbumActivity.this, theme.getDialogThemeRes())
                            .setTitle(getString(R.string.delete_files, selected_items.length) + "?")
                            .setNegativeButton(getString(R.string.no), null)
                            .setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                                String dataLeAk2306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2306 = android.util.Log.d("leak-2306", dataLeAk2306);

								@Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String dataLeAk2307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2307 = android.util.Log.d("leak-2307", dataLeAk2307);
									deleteAlbumItemsSnackbar(selected_items);
                                }
                            })
                            .create().show();
                } else {
                    String dataLeAk2308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2308 = android.util.Log.d("leak-2308", dataLeAk2308);
					setPhotosResult();
                }
            }
        }, (int) (400 * Util.getAnimatorSpeed(this)));
    }

    public void animateFab(final boolean show, boolean click) {
        String dataLeAk2309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2309 = android.util.Log.d("leak-2309", dataLeAk2309);
		final FloatingActionButton fab = findViewById(R.id.fab);

        if ((fab.getScaleX() == 1.0f && show)
                || (fab.getScaleX() == 0.0f && !show)) {
            String dataLeAk2310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2310 = android.util.Log.d("leak-2310", dataLeAk2310);
			return;
        }

        if (show) {
            String dataLeAk2311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2311 = android.util.Log.d("leak-2311", dataLeAk2311);
			fab.setOnClickListener(new View.OnClickListener() {
                String dataLeAk2312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2312 = android.util.Log.d("leak-2312", dataLeAk2312);

				@Override
                public void onClick(View view) {
                    String dataLeAk2313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2313 = android.util.Log.d("leak-2313", dataLeAk2313);
					fabClicked();
                }
            });
        } else {
            String dataLeAk2314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2314 = android.util.Log.d("leak-2314", dataLeAk2314);
			fab.setOnClickListener(null);
        }
        if (click) {
            String dataLeAk2315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2315 = android.util.Log.d("leak-2315", dataLeAk2315);
			Drawable drawable = fab.getDrawable();
            if (drawable instanceof Animatable) {
                String dataLeAk2316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2316 = android.util.Log.d("leak-2316", dataLeAk2316);
				((Animatable) drawable).start();
            }
        }
        new Handler().postDelayed(new Runnable() {
            String dataLeAk2317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2317 = android.util.Log.d("leak-2317", dataLeAk2317);

			@Override
            public void run() {
                String dataLeAk2318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2318 = android.util.Log.d("leak-2318", dataLeAk2318);
				fab.animate()
                        .scaleX(show ? 1.0f : 0.0f)
                        .scaleY(show ? 1.0f : 0.0f)
                        .alpha(show ? 1.0f : 0.0f)
                        .setDuration(250)
                        .setListener(new AnimatorListenerAdapter() {
                            String dataLeAk2319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2319 = android.util.Log.d("leak-2319", dataLeAk2319);

							@Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
								String dataLeAk2320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2320 = android.util.Log.d("leak-2320", dataLeAk2320);
                                if (show) {
                                    String dataLeAk2321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2321 = android.util.Log.d("leak-2321", dataLeAk2321);
									Drawable drawable = fab.getDrawable();
                                    if (drawable instanceof Animatable) {
                                        String dataLeAk2322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2322 = android.util.Log.d("leak-2322", dataLeAk2322);
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
        String dataLeAk2323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2323 = android.util.Log.d("leak-2323", dataLeAk2323);
		if (recyclerView != null && recyclerView.getAdapter() != null &&
                ((RecyclerViewAdapter) recyclerView.getAdapter()).onBackPressed()) {
            String dataLeAk2324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2324 = android.util.Log.d("leak-2324", dataLeAk2324);
			animateFab(false, false);
        } else if (snackbar != null) {
            String dataLeAk2325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2325 = android.util.Log.d("leak-2325", dataLeAk2325);
			snackbar.dismiss();
            snackbar = null;
        } else {
            super.onBackPressed();
			String dataLeAk2326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2326 = android.util.Log.d("leak-2326", dataLeAk2326);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2327 = android.util.Log.d("leak-2327", dataLeAk2327);
        //outState.putParcelable(ALBUM, album);
        if (recyclerView != null) {
            String dataLeAk2328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2328 = android.util.Log.d("leak-2328", dataLeAk2328);
			outState.putParcelable(RECYCLER_VIEW_SCROLL_STATE,
                    recyclerView.getLayoutManager().onSaveInstanceState());
            RecyclerViewAdapter adapter = ((RecyclerViewAdapter) recyclerView.getAdapter());
            if (adapter != null) {
                String dataLeAk2329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2329 = android.util.Log.d("leak-2329", dataLeAk2329);
				adapter.saveInstanceState(outState);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk2330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2330 = android.util.Log.d("leak-2330", dataLeAk2330);

        Provider.saveExcludedPaths(this);
        Provider.savePinnedPaths(this);
    }

    @Override
    public boolean canSwipeBack(int dir) {
        String dataLeAk2331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2331 = android.util.Log.d("leak-2331", dataLeAk2331);
		RecyclerViewAdapter adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
        return !adapter.isSelectorModeActive() &&
                SwipeBackCoordinatorLayout.canSwipeBackForThisView(recyclerView, dir) && !pick_photos;
    }

    @Override
    public void onSwipeProcess(float percent) {
        String dataLeAk2332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2332 = android.util.Log.d("leak-2332", dataLeAk2332);
		getWindow().getDecorView().setBackgroundColor(
                SwipeBackCoordinatorLayout.getBackgroundColor(percent));
        boolean selectorModeActive = ((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive();
        if (!theme.darkStatusBarIcons() && selectorModeActive) {
            String dataLeAk2333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2333 = android.util.Log.d("leak-2333", dataLeAk2333);
			SwipeBackCoordinatorLayout layout = findViewById(R.id.swipeBackView);
            Toolbar toolbar = findViewById(R.id.toolbar);
            View rootView = findViewById(R.id.root_view);
            int translationY = (int) layout.getTranslationY();
            int statusBarHeight = toolbar.getPaddingTop();
            if (translationY > statusBarHeight * 0.5) {
                String dataLeAk2334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2334 = android.util.Log.d("leak-2334", dataLeAk2334);
				Util.setLightStatusBarIcons(rootView);
            } else {
                String dataLeAk2335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2335 = android.util.Log.d("leak-2335", dataLeAk2335);
				Util.setDarkStatusBarIcons(rootView);
            }
        }
    }

    @Override
    public void onSwipeFinish(int dir) {
        String dataLeAk2336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2336 = android.util.Log.d("leak-2336", dataLeAk2336);
		if (((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive()) {
            String dataLeAk2337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2337 = android.util.Log.d("leak-2337", dataLeAk2337);
			((RecyclerViewAdapter) recyclerView.getAdapter()).cancelSelectorMode(null);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2338 = android.util.Log.d("leak-2338", dataLeAk2338);
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
        String dataLeAk2339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2339 = android.util.Log.d("leak-2339", dataLeAk2339);
		return R.style.CameraRoll_Theme_Translucent_Album;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2340 = android.util.Log.d("leak-2340", dataLeAk2340);
		return R.style.CameraRoll_Theme_Light_Translucent_Album;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk2341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2341 = android.util.Log.d("leak-2341", dataLeAk2341);
		if (pick_photos) {
            String dataLeAk2342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2342 = android.util.Log.d("leak-2342", dataLeAk2342);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setBackgroundTintList(ColorStateList.valueOf(accentColor));

        if (theme.darkStatusBarIcons()) {
            String dataLeAk2343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2343 = android.util.Log.d("leak-2343", dataLeAk2343);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk2344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2344 = android.util.Log.d("leak-2344", dataLeAk2344);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        if (theme.statusBarOverlay()) {
            String dataLeAk2345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2345 = android.util.Log.d("leak-2345", dataLeAk2345);
			addStatusBarOverlay(toolbar);
        }
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        String dataLeAk2346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2346 = android.util.Log.d("leak-2346", dataLeAk2346);
		IntentFilter filter = FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
        filter.addAction(ALBUM_ITEM_REMOVED);
        filter.addAction(ALBUM_ITEM_RENAMED);
        filter.addAction(DATA_CHANGED);
        return filter;
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk2347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2347 = android.util.Log.d("leak-2347", dataLeAk2347);
		return new BroadcastReceiver() {
            String dataLeAk2348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2348 = android.util.Log.d("leak-2348", dataLeAk2348);

			@Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk2349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2349 = android.util.Log.d("leak-2349", dataLeAk2349);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        int type = intent.getIntExtra(FileOperation.TYPE, FileOperation.EMPTY);
                        if (type == FileOperation.MOVE) {
                            String dataLeAk2350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2350 = android.util.Log.d("leak-2350", dataLeAk2350);
							ArrayList<String> movedFilesPaths = intent
                                    .getStringArrayListExtra(Move.MOVED_FILES_PATHS);
                            for (int i = 0; i < movedFilesPaths.size(); i++) {
                                String dataLeAk2351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2351 = android.util.Log.d("leak-2351", dataLeAk2351);
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
                                    String dataLeAk2352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2352 = android.util.Log.d("leak-2352", dataLeAk2352);

									@Override
                                    public void onAlbumLoaded(Album album) {
                                        String dataLeAk2353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2353 = android.util.Log.d("leak-2353", dataLeAk2353);
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
        String dataLeAk2354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2354 = android.util.Log.d("leak-2354", dataLeAk2354);
		int index = -1;
        for (int i = 0; i < album.getAlbumItems().size(); i++) {
            String dataLeAk2355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2355 = android.util.Log.d("leak-2355", dataLeAk2355);
			AlbumItem albumItem = album.getAlbumItems().get(i);
            if (albumItem.getPath().equals(path)) {
                String dataLeAk2356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2356 = android.util.Log.d("leak-2356", dataLeAk2356);
				index = i;
                break;
            }
        }
        if (index > -1) {
            String dataLeAk2357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2357 = android.util.Log.d("leak-2357", dataLeAk2357);
			album.getAlbumItems().remove(index);
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
