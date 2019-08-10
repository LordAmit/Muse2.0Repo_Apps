package us.koller.cameraroll.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.ContentObserver;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.adapter.SelectorModeManager;
import us.koller.cameraroll.adapter.main.RecyclerViewAdapter;
import us.koller.cameraroll.adapter.main.viewHolder.NestedRecyclerViewAlbumHolder;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.fileOperations.FileOperation;
import us.koller.cameraroll.data.provider.MediaProvider;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.ui.widget.FastScrollerRecyclerView;
import us.koller.cameraroll.ui.widget.ParallaxImageView;
import us.koller.cameraroll.util.SortUtil;
import us.koller.cameraroll.util.Util;

public class MainActivity extends ThemeableActivity {

    String dataLeAk1458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1458 = android.util.Log.d("leak-1458", dataLeAk1458);

	//public static final String ALBUMS = "ALBUMS";
    public static final String REFRESH_MEDIA = "REFRESH_MEDIA";
    public static final String PICK_PHOTOS = "PICK_PHOTOS";
    public static final String RESORT = "RESORT";

    public static final int PICK_PHOTOS_REQUEST_CODE = 6;
    public static final int REFRESH_PHOTOS_REQUEST_CODE = 7;
    public static final int REMOVABLE_STORAGE_PERMISSION_REQUEST_CODE = 8;
    public static final int SETTINGS_REQUEST_CODE = 9;

    //needed for sharedElement-Transition in Nested RecyclerView Style
    private NestedRecyclerViewAlbumHolder sharedElementViewHolder;
    private final SharedElementCallback mCallback
            = new SharedElementCallback() {
        String dataLeAk1459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1459 = android.util.Log.d("leak-1459", dataLeAk1459);

		@Override
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            String dataLeAk1460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1460 = android.util.Log.d("leak-1460", dataLeAk1460);
			if (sharedElementViewHolder == null) {
                String dataLeAk1461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1461 = android.util.Log.d("leak-1461", dataLeAk1461);
				return;
            }

            if (sharedElementViewHolder.sharedElementReturnPosition != -1
                    && sharedElementViewHolder.sharedElementReturnPosition <
                    sharedElementViewHolder.getAlbum().getAlbumItems().size()) {
                String dataLeAk1462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1462 = android.util.Log.d("leak-1462", dataLeAk1462);
				String newTransitionName = sharedElementViewHolder.getAlbum().getAlbumItems()
                        .get(sharedElementViewHolder.sharedElementReturnPosition).getPath();
                View layout = sharedElementViewHolder.nestedRecyclerView.findViewWithTag(newTransitionName);
                View newSharedElement = layout != null ? layout.findViewById(R.id.image) : null;
                if (newSharedElement != null) {
                    String dataLeAk1463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1463 = android.util.Log.d("leak-1463", dataLeAk1463);
					names.clear();
                    names.add(newTransitionName);
                    sharedElements.clear();
                    sharedElements.put(newTransitionName, newSharedElement);
                }
                sharedElementViewHolder.sharedElementReturnPosition = -1;
            } else {
                String dataLeAk1464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1464 = android.util.Log.d("leak-1464", dataLeAk1464);
				View v = sharedElementViewHolder.itemView.getRootView();
                View navigationBar = v.findViewById(android.R.id.navigationBarBackground);
                View statusBar = v.findViewById(android.R.id.statusBarBackground);
                if (navigationBar != null) {
                    String dataLeAk1465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1465 = android.util.Log.d("leak-1465", dataLeAk1465);
					names.add(navigationBar.getTransitionName());
                    sharedElements.put(navigationBar.getTransitionName(), navigationBar);
                }
                if (statusBar != null) {
                    String dataLeAk1466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1466 = android.util.Log.d("leak-1466", dataLeAk1466);
					names.add(statusBar.getTransitionName());
                    sharedElements.put(statusBar.getTransitionName(), statusBar);
                }
            }
        }
    };

    private ArrayList<Album> albums;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    private Snackbar snackbar;

    private MediaProvider mediaProvider;

    private ContentObserver observer;

    private boolean hiddenFolders;

    private boolean pick_photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk1467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1467 = android.util.Log.d("leak-1467", dataLeAk1467);
        setContentView(R.layout.activity_main);

        pick_photos = getIntent().getAction() != null && getIntent().getAction().equals(PICK_PHOTOS);
        boolean allowMultiple = getIntent().getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);

        final Settings settings = Settings.getInstance(this);

        hiddenFolders = settings.getHiddenFolders();

        //load media
        albums = MediaProvider.getAlbums();
        if (albums == null) {
            String dataLeAk1468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1468 = android.util.Log.d("leak-1468", dataLeAk1468);
			albums = new ArrayList<>();
        }

        if (savedInstanceState == null) {
            String dataLeAk1469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1469 = android.util.Log.d("leak-1469", dataLeAk1469);
			refreshPhotos();
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(!pick_photos ? toolbarColor : accentColor);
        toolbar.setTitleTextColor(!pick_photos ? textColorPrimary : accentTextColor);

        ActionBar actionBar = getSupportActionBar();
        if (pick_photos) {
            String dataLeAk1470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1470 = android.util.Log.d("leak-1470", dataLeAk1470);
			if (actionBar != null) {
                String dataLeAk1471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1471 = android.util.Log.d("leak-1471", dataLeAk1471);
				actionBar.setTitle(allowMultiple ? getString(R.string.pick_photos) : getString(R.string.pick_photo));
            }
            toolbar.setActivated(true);
            toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon != null) {
                String dataLeAk1472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1472 = android.util.Log.d("leak-1472", dataLeAk1472);
				navIcon = DrawableCompat.wrap(navIcon);
                DrawableCompat.setTint(navIcon.mutate(), accentTextColor);
                toolbar.setNavigationIcon(navIcon);
            }
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                String dataLeAk1473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1473 = android.util.Log.d("leak-1473", dataLeAk1473);

				@Override
                public void onClick(View view) {
                    String dataLeAk1474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1474 = android.util.Log.d("leak-1474", dataLeAk1474);
					finish();
                }
            });

            Util.colorToolbarOverflowMenuIcon(toolbar, accentTextColor);
            if (theme.darkStatusBarIconsInSelectorMode()) {
                String dataLeAk1475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1475 = android.util.Log.d("leak-1475", dataLeAk1475);
				Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
            }
        } else {
            String dataLeAk1476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1476 = android.util.Log.d("leak-1476", dataLeAk1476);
			if (actionBar != null) {
                String dataLeAk1477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1477 = android.util.Log.d("leak-1477", dataLeAk1477);
				actionBar.setTitle(getString(R.string.toolbar_title));
            }
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setTag(ParallaxImageView.RECYCLER_VIEW_TAG);
        int columnCount = settings.getStyleColumnCount(this, settings.getStyle(this, pick_photos));
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, columnCount);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(this, pick_photos).setAlbums(albums);
        recyclerView.setAdapter(recyclerViewAdapter);

        int spacing = settings.getStyleGridSpacing(this, settings.getStyle(this, pick_photos));
        if (recyclerView instanceof FastScrollerRecyclerView) {
            String dataLeAk1478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1478 = android.util.Log.d("leak-1478", dataLeAk1478);
			((FastScrollerRecyclerView) recyclerView).addOuterGridSpacing(spacing);
        }

        //disable default change animation
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        //restore Selector mode, when needed
        if (savedInstanceState != null) {
            String dataLeAk1479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1479 = android.util.Log.d("leak-1479", dataLeAk1479);
			SelectorModeManager manager = new SelectorModeManager(savedInstanceState);
            recyclerViewAdapter.setSelectorModeManager(manager);
        }

        recyclerViewAdapter.getSelectorManager()
                .addCallback(new SelectorModeManager.SimpleCallback() {
                    String dataLeAk1480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1480 = android.util.Log.d("leak-1480", dataLeAk1480);

					@Override
                    public void onSelectorModeEnter() {
                        super.onSelectorModeEnter();
						String dataLeAk1481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1481 = android.util.Log.d("leak-1481", dataLeAk1481);
                        showAndHideFab(false);
                    }

                    @Override
                    public void onSelectorModeExit() {
                        super.onSelectorModeExit();
						String dataLeAk1482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1482 = android.util.Log.d("leak-1482", dataLeAk1482);
                        showAndHideFab(true);
                    }
                });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            String dataLeAk1483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1483 = android.util.Log.d("leak-1483", dataLeAk1483);

			@Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
				String dataLeAk1484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1484 = android.util.Log.d("leak-1484", dataLeAk1484);
                if (pick_photos) {
                    String dataLeAk1485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1485 = android.util.Log.d("leak-1485", dataLeAk1485);
					return;
                }

                //hiding toolbar on scroll
                float translationY = toolbar.getTranslationY() - dy;
                if (-translationY > toolbar.getHeight()) {
                    String dataLeAk1486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1486 = android.util.Log.d("leak-1486", dataLeAk1486);
					translationY = -toolbar.getHeight();
                    if (theme.elevatedToolbar()) {
                        String dataLeAk1487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1487 = android.util.Log.d("leak-1487", dataLeAk1487);
						toolbar.setActivated(true);
                    }
                } else if (translationY > 0) {
                    String dataLeAk1488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1488 = android.util.Log.d("leak-1488", dataLeAk1488);
					translationY = 0;
                    if (theme.elevatedToolbar() &&
                            !recyclerView.canScrollVertically(-1)) {
                        String dataLeAk1489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1489 = android.util.Log.d("leak-1489", dataLeAk1489);
						toolbar.setActivated(false);
                    }
                }
                toolbar.setTranslationY(translationY);

                //animate statusBarIcon color
                boolean selectorModeActive = ((RecyclerViewAdapter) recyclerView.getAdapter())
                        .getSelectorManager().isSelectorModeActive();
                if (!selectorModeActive
                        && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                        && theme.isBaseLight()) {
                    String dataLeAk1490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1490 = android.util.Log.d("leak-1490", dataLeAk1490);
					//only animate statusBar icons color, when not in selectorMode
                    float animatedValue = (-translationY) / toolbar.getHeight();
                    if (animatedValue > 0.9f) {
                        String dataLeAk1491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1491 = android.util.Log.d("leak-1491", dataLeAk1491);
						Util.setLightStatusBarIcons(findViewById(R.id.root_view));
                    } else {
                        String dataLeAk1492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1492 = android.util.Log.d("leak-1492", dataLeAk1492);
						Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
                    }
                }
            }
        });

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            String dataLeAk1493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1493 = android.util.Log.d("leak-1493", dataLeAk1493);

			@Override
            public void onClick(View view) {
                String dataLeAk1494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1494 = android.util.Log.d("leak-1494", dataLeAk1494);
				fabClicked(view);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1495 = android.util.Log.d("leak-1495", dataLeAk1495);
			Drawable d = ContextCompat.getDrawable(this,
                    R.drawable.ic_camera_lens_avd);
            fab.setImageDrawable(d);
        } else {
            String dataLeAk1496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1496 = android.util.Log.d("leak-1496", dataLeAk1496);
			fab.setImageResource(R.drawable.ic_camera_white_24dp);
        }
        Drawable d = fab.getDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1497 = android.util.Log.d("leak-1497", dataLeAk1497);
			d.setTint(accentTextColor);
        } else {
            String dataLeAk1498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1498 = android.util.Log.d("leak-1498", dataLeAk1498);
			d = DrawableCompat.wrap(d);
            DrawableCompat.setTint(d.mutate(), accentTextColor);
        }
        fab.setImageDrawable(d);

        if (pick_photos || !settings.getCameraShortcut()) {
            String dataLeAk1499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1499 = android.util.Log.d("leak-1499", dataLeAk1499);
			fab.setVisibility(View.GONE);
        }

        //setting window insets manually
        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk1500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1500 = android.util.Log.d("leak-1500", dataLeAk1500);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1501 = android.util.Log.d("leak-1501", dataLeAk1501);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk1502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1502 = android.util.Log.d("leak-1502", dataLeAk1502);
					// clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);
                    Log.d("MainActivity", "onApplyWindowInsets()"
                            + "[" + insets.getSystemWindowInsetLeft() + ", " +
                            insets.getSystemWindowInsetTop() + ", " +
                            insets.getSystemWindowInsetRight() + ", " +
                            insets.getSystemWindowInsetBottom() + "]");

                    toolbar.setPadding(toolbar.getPaddingStart(),
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd(),
                            toolbar.getPaddingBottom());

                    ViewGroup.MarginLayoutParams toolbarParams
                            = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
                    toolbarParams.leftMargin = insets.getSystemWindowInsetLeft();
                    toolbarParams.rightMargin = insets.getSystemWindowInsetRight();
                    toolbar.setLayoutParams(toolbarParams);

                    recyclerView.setPadding(recyclerView.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            recyclerView.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            recyclerView.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            recyclerView.getPaddingBottom() + insets.getSystemWindowInsetBottom());

                    fab.setTranslationY(-insets.getSystemWindowInsetBottom());
                    fab.setTranslationX(-insets.getSystemWindowInsetRight());

                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            String dataLeAk1503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1503 = android.util.Log.d("leak-1503", dataLeAk1503);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1504 = android.util.Log.d("leak-1504", dataLeAk1504);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk1505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1505 = android.util.Log.d("leak-1505", dataLeAk1505);
									rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                    // hacky way of getting window insets on pre-Lollipop
                                    // somewhat works...
                                    int[] screenSize = Util.getScreenSize(MainActivity.this);

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

                                    fab.setTranslationX(-windowInsets[2]);
                                    fab.setTranslationY(-windowInsets[3]);
                                }
                            });
        }

        //needed for transparent statusBar
        setSystemUiFlags();
    }

    @Override
    public void onActivityReenter(final int resultCode, Intent intent) {
        super.onActivityReenter(resultCode, intent);
		String dataLeAk1506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1506 = android.util.Log.d("leak-1506", dataLeAk1506);

        int nestedRecyclerViewValue = getResources().getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE);
        if (intent.getAction() != null
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                && intent.getAction().equals(ItemActivity.SHARED_ELEMENT_RETURN_TRANSITION)
                && Settings.getInstance(this).getStyle(this, pick_photos) == nestedRecyclerViewValue) {
            String dataLeAk1507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1507 = android.util.Log.d("leak-1507", dataLeAk1507);
			//handle shared-element transition, for nested nestedRecyclerView style
            Bundle tmpReenterState = new Bundle(intent.getExtras());
            if (tmpReenterState.containsKey(AlbumActivity.ALBUM_PATH)
                    && tmpReenterState.containsKey(AlbumActivity.EXTRA_CURRENT_ALBUM_POSITION)) {

                String dataLeAk1508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1508 = android.util.Log.d("leak-1508", dataLeAk1508);
				String albumPath = tmpReenterState.getString(AlbumActivity.ALBUM_PATH);
                final int sharedElementReturnPosition = tmpReenterState.getInt(AlbumActivity.EXTRA_CURRENT_ALBUM_POSITION);
                int index = -1;
                ArrayList<Album> albums = MediaProvider.getAlbumsWithVirtualDirectories(this);
                for (int i = 0; i < albums.size(); i++) {
                    String dataLeAk1509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1509 = android.util.Log.d("leak-1509", dataLeAk1509);
					if (albums.get(i).getPath().equals(albumPath)) {
                        String dataLeAk1510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1510 = android.util.Log.d("leak-1510", dataLeAk1510);
						index = i;
                        break;
                    }
                }

                if (index == -1) {
                    String dataLeAk1511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1511 = android.util.Log.d("leak-1511", dataLeAk1511);
					return;
                }

                //postponing transition until sharedElement is laid out
                postponeEnterTransition();
                setExitSharedElementCallback(mCallback);
                final NestedRecyclerViewAlbumHolder
                        .StartSharedElementTransitionCallback callback =
                        new NestedRecyclerViewAlbumHolder
                                .StartSharedElementTransitionCallback() {
                            String dataLeAk1512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1512 = android.util.Log.d("leak-1512", dataLeAk1512);

							@Override
                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            public void startPostponedEnterTransition() {
                                String dataLeAk1513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1513 = android.util.Log.d("leak-1513", dataLeAk1513);
								//sharedElement is laid out --> start transition
                                MainActivity.this.startPostponedEnterTransition();
                            }
                        };

                final int finalIndex = index;
                recyclerView.scrollToPosition(index);
                //wait until ViewHolder is laid out
                recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    String dataLeAk1514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1514 = android.util.Log.d("leak-1514", dataLeAk1514);

					@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onLayoutChange(View v, int l, int t, int r, int b,
                                               int oL, int oT, int oR, int oB) {
                        String dataLeAk1515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk1515 = android.util.Log.d("leak-1515", dataLeAk1515);
						RecyclerView.ViewHolder viewHolder
                                = recyclerView.findViewHolderForAdapterPosition(finalIndex);

                        if (viewHolder != null) {
                            String dataLeAk1516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1516 = android.util.Log.d("leak-1516", dataLeAk1516);
							recyclerView.removeOnLayoutChangeListener(this);
                        } else {
                            String dataLeAk1517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1517 = android.util.Log.d("leak-1517", dataLeAk1517);
							//viewHolder hasn't been laid out yet --> wait
                            recyclerView.scrollToPosition(finalIndex);
                        }

                        if (viewHolder instanceof NestedRecyclerViewAlbumHolder) {
                            String dataLeAk1518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1518 = android.util.Log.d("leak-1518", dataLeAk1518);
							//found ViewHolder
                            sharedElementViewHolder = (NestedRecyclerViewAlbumHolder) viewHolder;
                            ((NestedRecyclerViewAlbumHolder) viewHolder)
                                    .onSharedElement(sharedElementReturnPosition, callback);
                        }
                    }
                });
            }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
		String dataLeAk1519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1519 = android.util.Log.d("leak-1519", dataLeAk1519);

        if (intent == null || intent.getAction() == null) {
            String dataLeAk1520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1520 = android.util.Log.d("leak-1520", dataLeAk1520);
			return;
        }

        switch (intent.getAction()) {
            case REFRESH_MEDIA:
                refreshPhotos();
                break;
            case RESORT:
                resortAlbums();
                break;
            default:
                break;
        }
    }

    public void refreshPhotos() {
        String dataLeAk1521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1521 = android.util.Log.d("leak-1521", dataLeAk1521);
		if (mediaProvider != null) {
            String dataLeAk1522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1522 = android.util.Log.d("leak-1522", dataLeAk1522);
			mediaProvider.onDestroy();
            mediaProvider = null;
        }

        snackbar = Snackbar.make(findViewById(R.id.root_view),
                R.string.loading, Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);

        final MediaProvider.OnMediaLoadedCallback callback
                = new MediaProvider.OnMediaLoadedCallback() {
            String dataLeAk1523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1523 = android.util.Log.d("leak-1523", dataLeAk1523);

			@Override
            public void onMediaLoaded(final ArrayList<Album> albums) {
                String dataLeAk1524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1524 = android.util.Log.d("leak-1524", dataLeAk1524);
				final ArrayList<Album> albumsWithVirtualDirs =
                        MediaProvider.getAlbumsWithVirtualDirectories(MainActivity.this);
                if (albums != null) {
                    String dataLeAk1525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1525 = android.util.Log.d("leak-1525", dataLeAk1525);
					MainActivity.this.runOnUiThread(new Runnable() {
                        String dataLeAk1526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1526 = android.util.Log.d("leak-1526", dataLeAk1526);

						@Override
                        public void run() {
                            String dataLeAk1527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1527 = android.util.Log.d("leak-1527", dataLeAk1527);
							MainActivity.this.albums = albumsWithVirtualDirs;
                            recyclerViewAdapter.setAlbums(albumsWithVirtualDirs);
                            recyclerViewAdapter.notifyDataSetChanged();

                            snackbar.dismiss();

                            if (mediaProvider != null) {
                                String dataLeAk1528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1528 = android.util.Log.d("leak-1528", dataLeAk1528);
								mediaProvider.onDestroy();
                            }
                            mediaProvider = null;
                        }
                    });
                }
            }

            @Override
            public void timeout() {
                String dataLeAk1529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1529 = android.util.Log.d("leak-1529", dataLeAk1529);
				//handle timeout
                snackbar.dismiss();
                snackbar = Snackbar.make(findViewById(R.id.root_view),
                        R.string.loading_failed, Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction(getString(R.string.retry), new View.OnClickListener() {
                    String dataLeAk1530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1530 = android.util.Log.d("leak-1530", dataLeAk1530);

					@Override
                    public void onClick(View view) {
                        String dataLeAk1531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1531 = android.util.Log.d("leak-1531", dataLeAk1531);
						if (mediaProvider != null) {
                            String dataLeAk1532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1532 = android.util.Log.d("leak-1532", dataLeAk1532);
							mediaProvider.onDestroy();
                        }
                        refreshPhotos();
                        snackbar.dismiss();
                    }
                });
                Util.showSnackbar(snackbar);

                if (mediaProvider != null) {
                    String dataLeAk1533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1533 = android.util.Log.d("leak-1533", dataLeAk1533);
					mediaProvider.onDestroy();
                }
                mediaProvider = null;
            }

            @Override
            public void needPermission() {
                String dataLeAk1534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1534 = android.util.Log.d("leak-1534", dataLeAk1534);
				snackbar.dismiss();
            }
        };

        mediaProvider = new MediaProvider(this);
        mediaProvider.loadAlbums(MainActivity.this, hiddenFolders, callback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk1535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1535 = android.util.Log.d("leak-1535", dataLeAk1535);
        getMenuInflater().inflate(R.menu.main, menu);
        menu.findItem(R.id.hiddenFolders).setChecked(hiddenFolders);

        int sort_by = Settings.getInstance(this).sortAlbumsBy();
        if (sort_by == SortUtil.BY_NAME) {
            String dataLeAk1536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1536 = android.util.Log.d("leak-1536", dataLeAk1536);
			menu.findItem(R.id.sort_by_name).setChecked(true);
        } else if (sort_by == SortUtil.BY_SIZE) {
            String dataLeAk1537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1537 = android.util.Log.d("leak-1537", dataLeAk1537);
			menu.findItem(R.id.sort_by_size).setChecked(true);
        } else if (sort_by == SortUtil.BY_DATE) {
            String dataLeAk1538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1538 = android.util.Log.d("leak-1538", dataLeAk1538);
			menu.findItem(R.id.sort_by_most_recent).setChecked(true);
        }

        /*Settings s = Settings.getInstance(this);
        MenuItem cameraShortcut = menu.findItem(R.id.camera_shortcut);
        cameraShortcut.setVisible(s.getCameraShortcut() && !pick_photos);
        Drawable cameraIcon = cameraShortcut.getIcon().mutate();
        DrawableCompat.wrap(cameraIcon);
        DrawableCompat.setTint(cameraIcon, theme.getTextColorSecondary(this));
        DrawableCompat.unwrap(cameraIcon);
        cameraShortcut.setIcon(cameraIcon);*/

        if (pick_photos) {
            String dataLeAk1539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1539 = android.util.Log.d("leak-1539", dataLeAk1539);
			menu.findItem(R.id.file_explorer).setVisible(false);
            menu.findItem(R.id.settings).setVisible(false);
            menu.findItem(R.id.about).setVisible(false);
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk1540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1540 = android.util.Log.d("leak-1540", dataLeAk1540);
		switch (item.getItemId()) {
            case R.id.camera_shortcut:
                Drawable d = item.getIcon();
                if (d instanceof Animatable
                        && !((Animatable) d).isRunning()) {
                    String dataLeAk1541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1541 = android.util.Log.d("leak-1541", dataLeAk1541);
					((Animatable) d).start();
                    fabClicked(null);
                }
                break;
            case R.id.refresh:
                refreshPhotos();
                break;
            case R.id.hiddenFolders:
                hiddenFolders = Settings.getInstance(this)
                        .setHiddenFolders(this, !hiddenFolders);
                item.setChecked(hiddenFolders);
                refreshPhotos();
                break;
            case R.id.file_explorer:
                startActivity(new Intent(this, FileExplorerActivity.class),
                        ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.settings:
                startActivityForResult(new Intent(this, SettingsActivity.class),
                        SETTINGS_REQUEST_CODE);
                break;
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class),
                        ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.sort_by_name:
            case R.id.sort_by_size:
            case R.id.sort_by_most_recent:
                item.setChecked(true);

                int sort_by;
                if (item.getItemId() == R.id.sort_by_name) {
                    String dataLeAk1542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1542 = android.util.Log.d("leak-1542", dataLeAk1542);
					sort_by = SortUtil.BY_NAME;
                } else if (item.getItemId() == R.id.sort_by_size) {
                    String dataLeAk1543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1543 = android.util.Log.d("leak-1543", dataLeAk1543);
					sort_by = SortUtil.BY_SIZE;
                } else {
                    String dataLeAk1544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1544 = android.util.Log.d("leak-1544", dataLeAk1544);
					sort_by = SortUtil.BY_DATE;
                }

                Settings.getInstance(this).sortAlbumsBy(this, sort_by);
                resortAlbums();

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void resortAlbums() {
        String dataLeAk1545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1545 = android.util.Log.d("leak-1545", dataLeAk1545);
		final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                "Sorting...", Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);
        AsyncTask.execute(new Runnable() {
            String dataLeAk1546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1546 = android.util.Log.d("leak-1546", dataLeAk1546);

			@Override
            public void run() {
                String dataLeAk1547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1547 = android.util.Log.d("leak-1547", dataLeAk1547);
				//SortUtil.sortAlbums(MainActivity.this, MediaProvider.getAlbums());
                final ArrayList<Album> albums = MediaProvider.getAlbumsWithVirtualDirectories(MainActivity.this);
                MainActivity.this.runOnUiThread(new Runnable() {
                    String dataLeAk1548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1548 = android.util.Log.d("leak-1548", dataLeAk1548);

					@Override
                    public void run() {
                        String dataLeAk1549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1549 = android.util.Log.d("leak-1549", dataLeAk1549);
						MainActivity.this.albums = albums;
                        ((RecyclerViewAdapter) recyclerView.getAdapter()).setAlbums(albums);
                        recyclerView.getAdapter().notifyDataSetChanged();
                        snackbar.dismiss();
                    }
                });
            }
        });
    }

    public void fabClicked(View v) {
        String dataLeAk1550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1550 = android.util.Log.d("leak-1550", dataLeAk1550);
		if (v instanceof FloatingActionButton) {
            String dataLeAk1551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1551 = android.util.Log.d("leak-1551", dataLeAk1551);
			FloatingActionButton fab = (FloatingActionButton) v;
            Drawable drawable = fab.getDrawable();
            if (drawable instanceof Animatable) {
                String dataLeAk1552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1552 = android.util.Log.d("leak-1552", dataLeAk1552);
				((Animatable) drawable).start();
            }
        }
        new Handler().postDelayed(new Runnable() {
            String dataLeAk1553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1553 = android.util.Log.d("leak-1553", dataLeAk1553);

			@Override
            public void run() {
                String dataLeAk1554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1554 = android.util.Log.d("leak-1554", dataLeAk1554);
				Intent i = new Intent();
                i.setAction(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (i.resolveActivity(getPackageManager()) != null) {
                    String dataLeAk1555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1555 = android.util.Log.d("leak-1555", dataLeAk1555);
					startActivity(i);
                } else {
                    String dataLeAk1556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1556 = android.util.Log.d("leak-1556", dataLeAk1556);
					Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        }, (int) (500 * Util.getAnimatorSpeed(this)));
    }

    public void showAndHideFab(boolean show) {
        String dataLeAk1557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1557 = android.util.Log.d("leak-1557", dataLeAk1557);
		if (pick_photos || !Settings.getInstance(this).getCameraShortcut()) {
            String dataLeAk1558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1558 = android.util.Log.d("leak-1558", dataLeAk1558);
			return;
        }

        findViewById(R.id.fab).animate()
                .scaleX(show ? 1.0f : 0.0f)
                .scaleY(show ? 1.0f : 0.0f)
                .alpha(show ? 1.0f : 0.0f)
                .setDuration(250)
                .start();
    }

    @Override
    public void onPermissionGranted() {
        super.onPermissionGranted();
		String dataLeAk1559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1559 = android.util.Log.d("leak-1559", dataLeAk1559);
        refreshPhotos();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
		String dataLeAk1560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1560 = android.util.Log.d("leak-1560", dataLeAk1560);
        switch (requestCode) {
            case PICK_PHOTOS_REQUEST_CODE:
                if (resultCode != RESULT_CANCELED) {
                    String dataLeAk1561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1561 = android.util.Log.d("leak-1561", dataLeAk1561);
					setResult(RESULT_OK, data);
                    this.finish();
                }
                break;
            case REFRESH_PHOTOS_REQUEST_CODE:
                if (data != null
                        && data.getAction() != null
                        && (data.getAction().equals(AlbumActivity.ALBUM_ITEM_REMOVED)
                        || data.getAction().equals(REFRESH_MEDIA))) {
                    String dataLeAk1562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1562 = android.util.Log.d("leak-1562", dataLeAk1562);
					refreshPhotos();
                }
                break;
            case AlbumActivity.FILE_OP_DIALOG_REQUEST:
                if (resultCode == RESULT_OK) {
                    String dataLeAk1563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1563 = android.util.Log.d("leak-1563", dataLeAk1563);
					refreshPhotos();
                }
                break;
            case SETTINGS_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String dataLeAk1564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1564 = android.util.Log.d("leak-1564", dataLeAk1564);
					// StatusBar is no longer translucent after recreate() + 2x sharedElementTransition in NestedRecyclerView-Style
                    //this.recreate();
                    Intent intent = getIntent();
                    this.finish();
                    startActivity(intent);
                }
                break;
            case ItemActivity.VIEW_IMAGE:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk1565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1565 = android.util.Log.d("leak-1565", dataLeAk1565);

        observer = new ContentObserver(new Handler());
        observer.setListener(new ContentObserver.Listener() {
            String dataLeAk1566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1566 = android.util.Log.d("leak-1566", dataLeAk1566);

			@Override
            public void onChange(boolean selfChange, Uri uri) {
                String dataLeAk1567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1567 = android.util.Log.d("leak-1567", dataLeAk1567);
				Log.d("MainActivity", "onChange()");
                MediaProvider.dataChanged = true;
                //observer.unregister(MainActivity.this);
                //observer = null;
            }
        });
        observer.register(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //not able to save albums in Bundle, --> TransactionTooLargeException
        //outState.putParcelableArrayList(ALBUMS, albums);
		String dataLeAk1568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1568 = android.util.Log.d("leak-1568", dataLeAk1568);

        RecyclerViewAdapter adapter = ((RecyclerViewAdapter) recyclerView.getAdapter());
        adapter.saveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        String dataLeAk1569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1569 = android.util.Log.d("leak-1569", dataLeAk1569);
		RecyclerViewAdapter adapter
                = ((RecyclerViewAdapter) recyclerView.getAdapter());
        if (!adapter.onBackPressed()) {
            super.onBackPressed();
			String dataLeAk1570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1570 = android.util.Log.d("leak-1570", dataLeAk1570);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1571 = android.util.Log.d("leak-1571", dataLeAk1571);
        if (mediaProvider != null) {
            String dataLeAk1572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1572 = android.util.Log.d("leak-1572", dataLeAk1572);
			mediaProvider.onDestroy();
        }

        if (observer != null) {
            String dataLeAk1573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1573 = android.util.Log.d("leak-1573", dataLeAk1573);
			observer.unregister(this);
        }
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk1574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1574 = android.util.Log.d("leak-1574", dataLeAk1574);
		return R.style.CameraRoll_Theme_Main;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1575 = android.util.Log.d("leak-1575", dataLeAk1575);
		return R.style.CameraRoll_Theme_Light_Main;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk1576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1576 = android.util.Log.d("leak-1576", dataLeAk1576);
		if (pick_photos) {
            String dataLeAk1577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1577 = android.util.Log.d("leak-1577", dataLeAk1577);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons()) {
            String dataLeAk1578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1578 = android.util.Log.d("leak-1578", dataLeAk1578);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk1579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1579 = android.util.Log.d("leak-1579", dataLeAk1579);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        if (theme.statusBarOverlay()) {
            String dataLeAk1580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1580 = android.util.Log.d("leak-1580", dataLeAk1580);
			addStatusBarOverlay(toolbar);
        }
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk1581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1581 = android.util.Log.d("leak-1581", dataLeAk1581);
		return new BroadcastReceiver() {
            String dataLeAk1582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1582 = android.util.Log.d("leak-1582", dataLeAk1582);

			@Override
            public void onReceive(Context context, final Intent intent) {
                String dataLeAk1583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1583 = android.util.Log.d("leak-1583", dataLeAk1583);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                    case FileOperation.FAILED:
                        refreshPhotos();
                        break;
                    case RESORT:
                        resortAlbums();
                        break;
                    case DATA_CHANGED:
                        albums = MediaProvider.getAlbums();
                        recyclerViewAdapter.setAlbums(albums);
                        recyclerViewAdapter.notifyDataSetChanged();
                    default:
                        break;
                }
            }
        };
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        String dataLeAk1584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1584 = android.util.Log.d("leak-1584", dataLeAk1584);
		IntentFilter filter = FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
        filter.addAction(RESORT);
        filter.addAction(DATA_CHANGED);
        return filter;
    }
}
