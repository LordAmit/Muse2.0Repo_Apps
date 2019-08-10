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

    final String dataLeAk774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk750 = "";

	String dataLeAk748 = "";

	String dataLeAk747 = "";

	String dataLeAk746 = "";

	String dataLeAk745 = "";

	String dataLeAk744 = "";

	String dataLeAk743 = "";

	String dataLeAk742 = "";

	String dataLeAk740 = "";

	String dataLeAk739 = "";

	String dataLeAk738 = "";

	String dataLeAk737 = "";

	String dataLeAk735 = "";

	String dataLeAk732 = "";

	String dataLeAk731 = "";

	String dataLeAk730 = "";

	String dataLeAk724 = "";

	String dataLeAk723 = "";

	String dataLeAk720 = "";

	String dataLeAk712 = "";

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
        String dataLeAk711 = "";

		@Override
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-752-0", dataLeAk752);
			android.util.Log.d("leak-711-0", dataLeAk711);
			if (sharedElementViewHolder == null) {
                return;
            }

            if (sharedElementViewHolder.sharedElementReturnPosition != -1
                    && sharedElementViewHolder.sharedElementReturnPosition <
                    sharedElementViewHolder.getAlbum().getAlbumItems().size()) {
                String newTransitionName = sharedElementViewHolder.getAlbum().getAlbumItems()
                        .get(sharedElementViewHolder.sharedElementReturnPosition).getPath();
                View layout = sharedElementViewHolder.nestedRecyclerView.findViewWithTag(newTransitionName);
                View newSharedElement = layout != null ? layout.findViewById(R.id.image) : null;
                if (newSharedElement != null) {
                    names.clear();
                    names.add(newTransitionName);
                    sharedElements.clear();
                    sharedElements.put(newTransitionName, newSharedElement);
                }
                sharedElementViewHolder.sharedElementReturnPosition = -1;
            } else {
                View v = sharedElementViewHolder.itemView.getRootView();
                View navigationBar = v.findViewById(android.R.id.navigationBarBackground);
                View statusBar = v.findViewById(android.R.id.statusBarBackground);
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
		dataLeAk712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-0", dataLeAk712);
		android.util.Log.d("leak-720-0", dataLeAk720);
		android.util.Log.d("leak-723-0", dataLeAk723);
		android.util.Log.d("leak-724-0", dataLeAk724);
		android.util.Log.d("leak-730-0", dataLeAk730);
		android.util.Log.d("leak-731-0", dataLeAk731);
		android.util.Log.d("leak-732-0", dataLeAk732);
		android.util.Log.d("leak-735-0", dataLeAk735);
		android.util.Log.d("leak-737-0", dataLeAk737);
		android.util.Log.d("leak-738-0", dataLeAk738);
		android.util.Log.d("leak-739-0", dataLeAk739);
		android.util.Log.d("leak-740-0", dataLeAk740);
		android.util.Log.d("leak-742-0", dataLeAk742);
		android.util.Log.d("leak-743-0", dataLeAk743);
		android.util.Log.d("leak-744-0", dataLeAk744);
		android.util.Log.d("leak-745-0", dataLeAk745);
		android.util.Log.d("leak-746-0", dataLeAk746);
		android.util.Log.d("leak-747-0", dataLeAk747);
		android.util.Log.d("leak-748-0", dataLeAk748);
		android.util.Log.d("leak-750-0", dataLeAk750);
        setContentView(R.layout.activity_main);

        pick_photos = getIntent().getAction() != null && getIntent().getAction().equals(PICK_PHOTOS);
        boolean allowMultiple = getIntent().getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);

        final Settings settings = Settings.getInstance(this);

        hiddenFolders = settings.getHiddenFolders();

        //load media
        albums = MediaProvider.getAlbums();
        if (albums == null) {
            albums = new ArrayList<>();
        }

        if (savedInstanceState == null) {
            refreshPhotos();
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(!pick_photos ? toolbarColor : accentColor);
        toolbar.setTitleTextColor(!pick_photos ? textColorPrimary : accentTextColor);

        ActionBar actionBar = getSupportActionBar();
        if (pick_photos) {
            if (actionBar != null) {
                actionBar.setTitle(allowMultiple ? getString(R.string.pick_photos) : getString(R.string.pick_photo));
            }
            toolbar.setActivated(true);
            toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon != null) {
                navIcon = DrawableCompat.wrap(navIcon);
                DrawableCompat.setTint(navIcon.mutate(), accentTextColor);
                toolbar.setNavigationIcon(navIcon);
            }
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                String dataLeAk713 = "";

				@Override
                public void onClick(View view) {
                    dataLeAk713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-753-0", dataLeAk753);
					android.util.Log.d("leak-713-0", dataLeAk713);
					finish();
                }
            });

            Util.colorToolbarOverflowMenuIcon(toolbar, accentTextColor);
            if (theme.darkStatusBarIconsInSelectorMode()) {
                Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
            }
        } else {
            if (actionBar != null) {
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
            ((FastScrollerRecyclerView) recyclerView).addOuterGridSpacing(spacing);
        }

        //disable default change animation
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        //restore Selector mode, when needed
        if (savedInstanceState != null) {
            SelectorModeManager manager = new SelectorModeManager(savedInstanceState);
            recyclerViewAdapter.setSelectorModeManager(manager);
        }

        recyclerViewAdapter.getSelectorManager()
                .addCallback(new SelectorModeManager.SimpleCallback() {
                    String dataLeAk715 = "";

					String dataLeAk714 = "";

					@Override
                    public void onSelectorModeEnter() {
                        super.onSelectorModeEnter();
						dataLeAk714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-754-0", dataLeAk754);
						android.util.Log.d("leak-714-0", dataLeAk714);
						android.util.Log.d("leak-715-0", dataLeAk715);
                        showAndHideFab(false);
                    }

                    @Override
                    public void onSelectorModeExit() {
                        super.onSelectorModeExit();
						dataLeAk715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-755-0", dataLeAk755);
						android.util.Log.d("leak-714-1", dataLeAk714);
						android.util.Log.d("leak-715-1", dataLeAk715);
                        showAndHideFab(true);
                    }
                });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            String dataLeAk716 = "";

			@Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
				dataLeAk716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-756-0", dataLeAk756);
				android.util.Log.d("leak-716-0", dataLeAk716);
                if (pick_photos) {
                    return;
                }

                //hiding toolbar on scroll
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
                boolean selectorModeActive = ((RecyclerViewAdapter) recyclerView.getAdapter())
                        .getSelectorManager().isSelectorModeActive();
                if (!selectorModeActive
                        && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                        && theme.isBaseLight()) {
                    //only animate statusBar icons color, when not in selectorMode
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
        fab.setOnClickListener(new View.OnClickListener() {
            String dataLeAk717 = "";

			@Override
            public void onClick(View view) {
                dataLeAk717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-757-0", dataLeAk757);
				android.util.Log.d("leak-717-0", dataLeAk717);
				fabClicked(view);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Drawable d = ContextCompat.getDrawable(this,
                    R.drawable.ic_camera_lens_avd);
            fab.setImageDrawable(d);
        } else {
            fab.setImageResource(R.drawable.ic_camera_white_24dp);
        }
        Drawable d = fab.getDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            d.setTint(accentTextColor);
        } else {
            d = DrawableCompat.wrap(d);
            DrawableCompat.setTint(d.mutate(), accentTextColor);
        }
        fab.setImageDrawable(d);

        if (pick_photos || !settings.getCameraShortcut()) {
            fab.setVisibility(View.GONE);
        }

        //setting window insets manually
        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk718 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-758-0", dataLeAk758);
					android.util.Log.d("leak-718-0", dataLeAk718);
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
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk719 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-759-0", dataLeAk759);
									android.util.Log.d("leak-719-0", dataLeAk719);
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
		dataLeAk720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-1", dataLeAk712);
		android.util.Log.d("leak-720-1", dataLeAk720);
		android.util.Log.d("leak-723-1", dataLeAk723);
		android.util.Log.d("leak-724-1", dataLeAk724);
		android.util.Log.d("leak-730-1", dataLeAk730);
		android.util.Log.d("leak-731-1", dataLeAk731);
		android.util.Log.d("leak-732-1", dataLeAk732);
		android.util.Log.d("leak-735-1", dataLeAk735);
		android.util.Log.d("leak-737-1", dataLeAk737);
		android.util.Log.d("leak-738-1", dataLeAk738);
		android.util.Log.d("leak-739-1", dataLeAk739);
		android.util.Log.d("leak-740-1", dataLeAk740);
		android.util.Log.d("leak-742-1", dataLeAk742);
		android.util.Log.d("leak-743-1", dataLeAk743);
		android.util.Log.d("leak-744-1", dataLeAk744);
		android.util.Log.d("leak-745-1", dataLeAk745);
		android.util.Log.d("leak-746-1", dataLeAk746);
		android.util.Log.d("leak-747-1", dataLeAk747);
		android.util.Log.d("leak-748-1", dataLeAk748);
		android.util.Log.d("leak-750-1", dataLeAk750);

        int nestedRecyclerViewValue = getResources().getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE);
        if (intent.getAction() != null
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                && intent.getAction().equals(ItemActivity.SHARED_ELEMENT_RETURN_TRANSITION)
                && Settings.getInstance(this).getStyle(this, pick_photos) == nestedRecyclerViewValue) {
            //handle shared-element transition, for nested nestedRecyclerView style
            Bundle tmpReenterState = new Bundle(intent.getExtras());
            if (tmpReenterState.containsKey(AlbumActivity.ALBUM_PATH)
                    && tmpReenterState.containsKey(AlbumActivity.EXTRA_CURRENT_ALBUM_POSITION)) {

                String albumPath = tmpReenterState.getString(AlbumActivity.ALBUM_PATH);
                final int sharedElementReturnPosition = tmpReenterState.getInt(AlbumActivity.EXTRA_CURRENT_ALBUM_POSITION);
                int index = -1;
                ArrayList<Album> albums = MediaProvider.getAlbumsWithVirtualDirectories(this);
                for (int i = 0; i < albums.size(); i++) {
                    if (albums.get(i).getPath().equals(albumPath)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    return;
                }

                //postponing transition until sharedElement is laid out
                postponeEnterTransition();
                setExitSharedElementCallback(mCallback);
                final NestedRecyclerViewAlbumHolder
                        .StartSharedElementTransitionCallback callback =
                        new NestedRecyclerViewAlbumHolder
                                .StartSharedElementTransitionCallback() {
                            String dataLeAk721 = "";

							@Override
                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            public void startPostponedEnterTransition() {
                                dataLeAk721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-760-0", dataLeAk760);
								android.util.Log.d("leak-721-0", dataLeAk721);
								//sharedElement is laid out --> start transition
                                MainActivity.this.startPostponedEnterTransition();
                            }
                        };

                final int finalIndex = index;
                recyclerView.scrollToPosition(index);
                //wait until ViewHolder is laid out
                recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    String dataLeAk722 = "";

					@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onLayoutChange(View v, int l, int t, int r, int b,
                                               int oL, int oT, int oR, int oB) {
                        dataLeAk722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-761-0", dataLeAk761);
						android.util.Log.d("leak-722-0", dataLeAk722);
						RecyclerView.ViewHolder viewHolder
                                = recyclerView.findViewHolderForAdapterPosition(finalIndex);

                        if (viewHolder != null) {
                            recyclerView.removeOnLayoutChangeListener(this);
                        } else {
                            //viewHolder hasn't been laid out yet --> wait
                            recyclerView.scrollToPosition(finalIndex);
                        }

                        if (viewHolder instanceof NestedRecyclerViewAlbumHolder) {
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
		dataLeAk723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-2", dataLeAk712);
		android.util.Log.d("leak-720-2", dataLeAk720);
		android.util.Log.d("leak-723-2", dataLeAk723);
		android.util.Log.d("leak-724-2", dataLeAk724);
		android.util.Log.d("leak-730-2", dataLeAk730);
		android.util.Log.d("leak-731-2", dataLeAk731);
		android.util.Log.d("leak-732-2", dataLeAk732);
		android.util.Log.d("leak-735-2", dataLeAk735);
		android.util.Log.d("leak-737-2", dataLeAk737);
		android.util.Log.d("leak-738-2", dataLeAk738);
		android.util.Log.d("leak-739-2", dataLeAk739);
		android.util.Log.d("leak-740-2", dataLeAk740);
		android.util.Log.d("leak-742-2", dataLeAk742);
		android.util.Log.d("leak-743-2", dataLeAk743);
		android.util.Log.d("leak-744-2", dataLeAk744);
		android.util.Log.d("leak-745-2", dataLeAk745);
		android.util.Log.d("leak-746-2", dataLeAk746);
		android.util.Log.d("leak-747-2", dataLeAk747);
		android.util.Log.d("leak-748-2", dataLeAk748);
		android.util.Log.d("leak-750-2", dataLeAk750);

        if (intent == null || intent.getAction() == null) {
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
        dataLeAk724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-3", dataLeAk712);
		android.util.Log.d("leak-720-3", dataLeAk720);
		android.util.Log.d("leak-723-3", dataLeAk723);
		android.util.Log.d("leak-724-3", dataLeAk724);
		android.util.Log.d("leak-730-3", dataLeAk730);
		android.util.Log.d("leak-731-3", dataLeAk731);
		android.util.Log.d("leak-732-3", dataLeAk732);
		android.util.Log.d("leak-735-3", dataLeAk735);
		android.util.Log.d("leak-737-3", dataLeAk737);
		android.util.Log.d("leak-738-3", dataLeAk738);
		android.util.Log.d("leak-739-3", dataLeAk739);
		android.util.Log.d("leak-740-3", dataLeAk740);
		android.util.Log.d("leak-742-3", dataLeAk742);
		android.util.Log.d("leak-743-3", dataLeAk743);
		android.util.Log.d("leak-744-3", dataLeAk744);
		android.util.Log.d("leak-745-3", dataLeAk745);
		android.util.Log.d("leak-746-3", dataLeAk746);
		android.util.Log.d("leak-747-3", dataLeAk747);
		android.util.Log.d("leak-748-3", dataLeAk748);
		android.util.Log.d("leak-750-3", dataLeAk750);
		if (mediaProvider != null) {
            mediaProvider.onDestroy();
            mediaProvider = null;
        }

        snackbar = Snackbar.make(findViewById(R.id.root_view),
                R.string.loading, Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);

        final MediaProvider.OnMediaLoadedCallback callback
                = new MediaProvider.OnMediaLoadedCallback() {
            final String dataLeAk766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					final String dataLeAk763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk729 = "";

					String dataLeAk727 = "";

					String dataLeAk725 = "";

			@Override
            public void onMediaLoaded(final ArrayList<Album> albums) {
                dataLeAk725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-762-0", dataLeAk762);
				android.util.Log.d("leak-725-0", dataLeAk725);
				android.util.Log.d("leak-727-0", dataLeAk727);
				android.util.Log.d("leak-729-0", dataLeAk729);
				final ArrayList<Album> albumsWithVirtualDirs =
                        MediaProvider.getAlbumsWithVirtualDirectories(MainActivity.this);
                if (albums != null) {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        String dataLeAk726 = "";

						@Override
                        public void run() {
                            dataLeAk726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-764-0", dataLeAk764);
							android.util.Log.d("leak-763-0", dataLeAk763);
							android.util.Log.d("leak-726-0", dataLeAk726);
							MainActivity.this.albums = albumsWithVirtualDirs;
                            recyclerViewAdapter.setAlbums(albumsWithVirtualDirs);
                            recyclerViewAdapter.notifyDataSetChanged();

                            snackbar.dismiss();

                            if (mediaProvider != null) {
                                mediaProvider.onDestroy();
                            }
                            mediaProvider = null;
                        }
                    });
                }
            }

            @Override
            public void timeout() {
                dataLeAk727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-765-0", dataLeAk765);
				android.util.Log.d("leak-725-1", dataLeAk725);
				android.util.Log.d("leak-727-1", dataLeAk727);
				android.util.Log.d("leak-729-1", dataLeAk729);
				//handle timeout
                snackbar.dismiss();
                snackbar = Snackbar.make(findViewById(R.id.root_view),
                        R.string.loading_failed, Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction(getString(R.string.retry), new View.OnClickListener() {
                    String dataLeAk728 = "";

					@Override
                    public void onClick(View view) {
                        dataLeAk728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-767-0", dataLeAk767);
						android.util.Log.d("leak-766-0", dataLeAk766);
						android.util.Log.d("leak-728-0", dataLeAk728);
						if (mediaProvider != null) {
                            mediaProvider.onDestroy();
                        }
                        refreshPhotos();
                        snackbar.dismiss();
                    }
                });
                Util.showSnackbar(snackbar);

                if (mediaProvider != null) {
                    mediaProvider.onDestroy();
                }
                mediaProvider = null;
            }

            @Override
            public void needPermission() {
                dataLeAk729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-768-0", dataLeAk768);
				android.util.Log.d("leak-725-2", dataLeAk725);
				android.util.Log.d("leak-727-2", dataLeAk727);
				android.util.Log.d("leak-729-2", dataLeAk729);
				snackbar.dismiss();
            }
        };

        mediaProvider = new MediaProvider(this);
        mediaProvider.loadAlbums(MainActivity.this, hiddenFolders, callback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-4", dataLeAk712);
		android.util.Log.d("leak-720-4", dataLeAk720);
		android.util.Log.d("leak-723-4", dataLeAk723);
		android.util.Log.d("leak-724-4", dataLeAk724);
		android.util.Log.d("leak-730-4", dataLeAk730);
		android.util.Log.d("leak-731-4", dataLeAk731);
		android.util.Log.d("leak-732-4", dataLeAk732);
		android.util.Log.d("leak-735-4", dataLeAk735);
		android.util.Log.d("leak-737-4", dataLeAk737);
		android.util.Log.d("leak-738-4", dataLeAk738);
		android.util.Log.d("leak-739-4", dataLeAk739);
		android.util.Log.d("leak-740-4", dataLeAk740);
		android.util.Log.d("leak-742-4", dataLeAk742);
		android.util.Log.d("leak-743-4", dataLeAk743);
		android.util.Log.d("leak-744-4", dataLeAk744);
		android.util.Log.d("leak-745-4", dataLeAk745);
		android.util.Log.d("leak-746-4", dataLeAk746);
		android.util.Log.d("leak-747-4", dataLeAk747);
		android.util.Log.d("leak-748-4", dataLeAk748);
		android.util.Log.d("leak-750-4", dataLeAk750);
        getMenuInflater().inflate(R.menu.main, menu);
        menu.findItem(R.id.hiddenFolders).setChecked(hiddenFolders);

        int sort_by = Settings.getInstance(this).sortAlbumsBy();
        if (sort_by == SortUtil.BY_NAME) {
            menu.findItem(R.id.sort_by_name).setChecked(true);
        } else if (sort_by == SortUtil.BY_SIZE) {
            menu.findItem(R.id.sort_by_size).setChecked(true);
        } else if (sort_by == SortUtil.BY_DATE) {
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
            menu.findItem(R.id.file_explorer).setVisible(false);
            menu.findItem(R.id.settings).setVisible(false);
            menu.findItem(R.id.about).setVisible(false);
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-5", dataLeAk712);
		android.util.Log.d("leak-720-5", dataLeAk720);
		android.util.Log.d("leak-723-5", dataLeAk723);
		android.util.Log.d("leak-724-5", dataLeAk724);
		android.util.Log.d("leak-730-5", dataLeAk730);
		android.util.Log.d("leak-731-5", dataLeAk731);
		android.util.Log.d("leak-732-5", dataLeAk732);
		android.util.Log.d("leak-735-5", dataLeAk735);
		android.util.Log.d("leak-737-5", dataLeAk737);
		android.util.Log.d("leak-738-5", dataLeAk738);
		android.util.Log.d("leak-739-5", dataLeAk739);
		android.util.Log.d("leak-740-5", dataLeAk740);
		android.util.Log.d("leak-742-5", dataLeAk742);
		android.util.Log.d("leak-743-5", dataLeAk743);
		android.util.Log.d("leak-744-5", dataLeAk744);
		android.util.Log.d("leak-745-5", dataLeAk745);
		android.util.Log.d("leak-746-5", dataLeAk746);
		android.util.Log.d("leak-747-5", dataLeAk747);
		android.util.Log.d("leak-748-5", dataLeAk748);
		android.util.Log.d("leak-750-5", dataLeAk750);
		switch (item.getItemId()) {
            case R.id.camera_shortcut:
                Drawable d = item.getIcon();
                if (d instanceof Animatable
                        && !((Animatable) d).isRunning()) {
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
                    sort_by = SortUtil.BY_NAME;
                } else if (item.getItemId() == R.id.sort_by_size) {
                    sort_by = SortUtil.BY_SIZE;
                } else {
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
        dataLeAk732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-6", dataLeAk712);
		android.util.Log.d("leak-720-6", dataLeAk720);
		android.util.Log.d("leak-723-6", dataLeAk723);
		android.util.Log.d("leak-724-6", dataLeAk724);
		android.util.Log.d("leak-730-6", dataLeAk730);
		android.util.Log.d("leak-731-6", dataLeAk731);
		android.util.Log.d("leak-732-6", dataLeAk732);
		android.util.Log.d("leak-735-6", dataLeAk735);
		android.util.Log.d("leak-737-6", dataLeAk737);
		android.util.Log.d("leak-738-6", dataLeAk738);
		android.util.Log.d("leak-739-6", dataLeAk739);
		android.util.Log.d("leak-740-6", dataLeAk740);
		android.util.Log.d("leak-742-6", dataLeAk742);
		android.util.Log.d("leak-743-6", dataLeAk743);
		android.util.Log.d("leak-744-6", dataLeAk744);
		android.util.Log.d("leak-745-6", dataLeAk745);
		android.util.Log.d("leak-746-6", dataLeAk746);
		android.util.Log.d("leak-747-6", dataLeAk747);
		android.util.Log.d("leak-748-6", dataLeAk748);
		android.util.Log.d("leak-750-6", dataLeAk750);
		final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                "Sorting...", Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);
        AsyncTask.execute(new Runnable() {
            final String dataLeAk770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk733 = "";

			@Override
            public void run() {
                dataLeAk733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-769-0", dataLeAk769);
				android.util.Log.d("leak-733-0", dataLeAk733);
				//SortUtil.sortAlbums(MainActivity.this, MediaProvider.getAlbums());
                final ArrayList<Album> albums = MediaProvider.getAlbumsWithVirtualDirectories(MainActivity.this);
                MainActivity.this.runOnUiThread(new Runnable() {
                    String dataLeAk734 = "";

					@Override
                    public void run() {
                        dataLeAk734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-771-0", dataLeAk771);
						android.util.Log.d("leak-770-0", dataLeAk770);
						android.util.Log.d("leak-734-0", dataLeAk734);
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
        dataLeAk735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-7", dataLeAk712);
		android.util.Log.d("leak-720-7", dataLeAk720);
		android.util.Log.d("leak-723-7", dataLeAk723);
		android.util.Log.d("leak-724-7", dataLeAk724);
		android.util.Log.d("leak-730-7", dataLeAk730);
		android.util.Log.d("leak-731-7", dataLeAk731);
		android.util.Log.d("leak-732-7", dataLeAk732);
		android.util.Log.d("leak-735-7", dataLeAk735);
		android.util.Log.d("leak-737-7", dataLeAk737);
		android.util.Log.d("leak-738-7", dataLeAk738);
		android.util.Log.d("leak-739-7", dataLeAk739);
		android.util.Log.d("leak-740-7", dataLeAk740);
		android.util.Log.d("leak-742-7", dataLeAk742);
		android.util.Log.d("leak-743-7", dataLeAk743);
		android.util.Log.d("leak-744-7", dataLeAk744);
		android.util.Log.d("leak-745-7", dataLeAk745);
		android.util.Log.d("leak-746-7", dataLeAk746);
		android.util.Log.d("leak-747-7", dataLeAk747);
		android.util.Log.d("leak-748-7", dataLeAk748);
		android.util.Log.d("leak-750-7", dataLeAk750);
		if (v instanceof FloatingActionButton) {
            FloatingActionButton fab = (FloatingActionButton) v;
            Drawable drawable = fab.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        }
        new Handler().postDelayed(new Runnable() {
            String dataLeAk736 = "";

			@Override
            public void run() {
                dataLeAk736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-772-0", dataLeAk772);
				android.util.Log.d("leak-736-0", dataLeAk736);
				Intent i = new Intent();
                i.setAction(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        }, (int) (500 * Util.getAnimatorSpeed(this)));
    }

    public void showAndHideFab(boolean show) {
        dataLeAk737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-8", dataLeAk712);
		android.util.Log.d("leak-720-8", dataLeAk720);
		android.util.Log.d("leak-723-8", dataLeAk723);
		android.util.Log.d("leak-724-8", dataLeAk724);
		android.util.Log.d("leak-730-8", dataLeAk730);
		android.util.Log.d("leak-731-8", dataLeAk731);
		android.util.Log.d("leak-732-8", dataLeAk732);
		android.util.Log.d("leak-735-8", dataLeAk735);
		android.util.Log.d("leak-737-8", dataLeAk737);
		android.util.Log.d("leak-738-8", dataLeAk738);
		android.util.Log.d("leak-739-8", dataLeAk739);
		android.util.Log.d("leak-740-8", dataLeAk740);
		android.util.Log.d("leak-742-8", dataLeAk742);
		android.util.Log.d("leak-743-8", dataLeAk743);
		android.util.Log.d("leak-744-8", dataLeAk744);
		android.util.Log.d("leak-745-8", dataLeAk745);
		android.util.Log.d("leak-746-8", dataLeAk746);
		android.util.Log.d("leak-747-8", dataLeAk747);
		android.util.Log.d("leak-748-8", dataLeAk748);
		android.util.Log.d("leak-750-8", dataLeAk750);
		if (pick_photos || !Settings.getInstance(this).getCameraShortcut()) {
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
		dataLeAk738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-9", dataLeAk712);
		android.util.Log.d("leak-720-9", dataLeAk720);
		android.util.Log.d("leak-723-9", dataLeAk723);
		android.util.Log.d("leak-724-9", dataLeAk724);
		android.util.Log.d("leak-730-9", dataLeAk730);
		android.util.Log.d("leak-731-9", dataLeAk731);
		android.util.Log.d("leak-732-9", dataLeAk732);
		android.util.Log.d("leak-735-9", dataLeAk735);
		android.util.Log.d("leak-737-9", dataLeAk737);
		android.util.Log.d("leak-738-9", dataLeAk738);
		android.util.Log.d("leak-739-9", dataLeAk739);
		android.util.Log.d("leak-740-9", dataLeAk740);
		android.util.Log.d("leak-742-9", dataLeAk742);
		android.util.Log.d("leak-743-9", dataLeAk743);
		android.util.Log.d("leak-744-9", dataLeAk744);
		android.util.Log.d("leak-745-9", dataLeAk745);
		android.util.Log.d("leak-746-9", dataLeAk746);
		android.util.Log.d("leak-747-9", dataLeAk747);
		android.util.Log.d("leak-748-9", dataLeAk748);
		android.util.Log.d("leak-750-9", dataLeAk750);
        refreshPhotos();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
		dataLeAk739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-10", dataLeAk712);
		android.util.Log.d("leak-720-10", dataLeAk720);
		android.util.Log.d("leak-723-10", dataLeAk723);
		android.util.Log.d("leak-724-10", dataLeAk724);
		android.util.Log.d("leak-730-10", dataLeAk730);
		android.util.Log.d("leak-731-10", dataLeAk731);
		android.util.Log.d("leak-732-10", dataLeAk732);
		android.util.Log.d("leak-735-10", dataLeAk735);
		android.util.Log.d("leak-737-10", dataLeAk737);
		android.util.Log.d("leak-738-10", dataLeAk738);
		android.util.Log.d("leak-739-10", dataLeAk739);
		android.util.Log.d("leak-740-10", dataLeAk740);
		android.util.Log.d("leak-742-10", dataLeAk742);
		android.util.Log.d("leak-743-10", dataLeAk743);
		android.util.Log.d("leak-744-10", dataLeAk744);
		android.util.Log.d("leak-745-10", dataLeAk745);
		android.util.Log.d("leak-746-10", dataLeAk746);
		android.util.Log.d("leak-747-10", dataLeAk747);
		android.util.Log.d("leak-748-10", dataLeAk748);
		android.util.Log.d("leak-750-10", dataLeAk750);
        switch (requestCode) {
            case PICK_PHOTOS_REQUEST_CODE:
                if (resultCode != RESULT_CANCELED) {
                    setResult(RESULT_OK, data);
                    this.finish();
                }
                break;
            case REFRESH_PHOTOS_REQUEST_CODE:
                if (data != null
                        && data.getAction() != null
                        && (data.getAction().equals(AlbumActivity.ALBUM_ITEM_REMOVED)
                        || data.getAction().equals(REFRESH_MEDIA))) {
                    refreshPhotos();
                }
                break;
            case AlbumActivity.FILE_OP_DIALOG_REQUEST:
                if (resultCode == RESULT_OK) {
                    refreshPhotos();
                }
                break;
            case SETTINGS_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
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
		dataLeAk740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-11", dataLeAk712);
		android.util.Log.d("leak-720-11", dataLeAk720);
		android.util.Log.d("leak-723-11", dataLeAk723);
		android.util.Log.d("leak-724-11", dataLeAk724);
		android.util.Log.d("leak-730-11", dataLeAk730);
		android.util.Log.d("leak-731-11", dataLeAk731);
		android.util.Log.d("leak-732-11", dataLeAk732);
		android.util.Log.d("leak-735-11", dataLeAk735);
		android.util.Log.d("leak-737-11", dataLeAk737);
		android.util.Log.d("leak-738-11", dataLeAk738);
		android.util.Log.d("leak-739-11", dataLeAk739);
		android.util.Log.d("leak-740-11", dataLeAk740);
		android.util.Log.d("leak-742-11", dataLeAk742);
		android.util.Log.d("leak-743-11", dataLeAk743);
		android.util.Log.d("leak-744-11", dataLeAk744);
		android.util.Log.d("leak-745-11", dataLeAk745);
		android.util.Log.d("leak-746-11", dataLeAk746);
		android.util.Log.d("leak-747-11", dataLeAk747);
		android.util.Log.d("leak-748-11", dataLeAk748);
		android.util.Log.d("leak-750-11", dataLeAk750);

        observer = new ContentObserver(new Handler());
        observer.setListener(new ContentObserver.Listener() {
            String dataLeAk741 = "";

			@Override
            public void onChange(boolean selfChange, Uri uri) {
                dataLeAk741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-773-0", dataLeAk773);
				android.util.Log.d("leak-741-0", dataLeAk741);
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
		dataLeAk742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-12", dataLeAk712);
		android.util.Log.d("leak-720-12", dataLeAk720);
		android.util.Log.d("leak-723-12", dataLeAk723);
		android.util.Log.d("leak-724-12", dataLeAk724);
		android.util.Log.d("leak-730-12", dataLeAk730);
		android.util.Log.d("leak-731-12", dataLeAk731);
		android.util.Log.d("leak-732-12", dataLeAk732);
		android.util.Log.d("leak-735-12", dataLeAk735);
		android.util.Log.d("leak-737-12", dataLeAk737);
		android.util.Log.d("leak-738-12", dataLeAk738);
		android.util.Log.d("leak-739-12", dataLeAk739);
		android.util.Log.d("leak-740-12", dataLeAk740);
		android.util.Log.d("leak-742-12", dataLeAk742);
		android.util.Log.d("leak-743-12", dataLeAk743);
		android.util.Log.d("leak-744-12", dataLeAk744);
		android.util.Log.d("leak-745-12", dataLeAk745);
		android.util.Log.d("leak-746-12", dataLeAk746);
		android.util.Log.d("leak-747-12", dataLeAk747);
		android.util.Log.d("leak-748-12", dataLeAk748);
		android.util.Log.d("leak-750-12", dataLeAk750);

        RecyclerViewAdapter adapter = ((RecyclerViewAdapter) recyclerView.getAdapter());
        adapter.saveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        dataLeAk743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-13", dataLeAk712);
		android.util.Log.d("leak-720-13", dataLeAk720);
		android.util.Log.d("leak-723-13", dataLeAk723);
		android.util.Log.d("leak-724-13", dataLeAk724);
		android.util.Log.d("leak-730-13", dataLeAk730);
		android.util.Log.d("leak-731-13", dataLeAk731);
		android.util.Log.d("leak-732-13", dataLeAk732);
		android.util.Log.d("leak-735-13", dataLeAk735);
		android.util.Log.d("leak-737-13", dataLeAk737);
		android.util.Log.d("leak-738-13", dataLeAk738);
		android.util.Log.d("leak-739-13", dataLeAk739);
		android.util.Log.d("leak-740-13", dataLeAk740);
		android.util.Log.d("leak-742-13", dataLeAk742);
		android.util.Log.d("leak-743-13", dataLeAk743);
		android.util.Log.d("leak-744-13", dataLeAk744);
		android.util.Log.d("leak-745-13", dataLeAk745);
		android.util.Log.d("leak-746-13", dataLeAk746);
		android.util.Log.d("leak-747-13", dataLeAk747);
		android.util.Log.d("leak-748-13", dataLeAk748);
		android.util.Log.d("leak-750-13", dataLeAk750);
		RecyclerViewAdapter adapter
                = ((RecyclerViewAdapter) recyclerView.getAdapter());
        if (!adapter.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		dataLeAk744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-14", dataLeAk712);
		android.util.Log.d("leak-720-14", dataLeAk720);
		android.util.Log.d("leak-723-14", dataLeAk723);
		android.util.Log.d("leak-724-14", dataLeAk724);
		android.util.Log.d("leak-730-14", dataLeAk730);
		android.util.Log.d("leak-731-14", dataLeAk731);
		android.util.Log.d("leak-732-14", dataLeAk732);
		android.util.Log.d("leak-735-14", dataLeAk735);
		android.util.Log.d("leak-737-14", dataLeAk737);
		android.util.Log.d("leak-738-14", dataLeAk738);
		android.util.Log.d("leak-739-14", dataLeAk739);
		android.util.Log.d("leak-740-14", dataLeAk740);
		android.util.Log.d("leak-742-14", dataLeAk742);
		android.util.Log.d("leak-743-14", dataLeAk743);
		android.util.Log.d("leak-744-14", dataLeAk744);
		android.util.Log.d("leak-745-14", dataLeAk745);
		android.util.Log.d("leak-746-14", dataLeAk746);
		android.util.Log.d("leak-747-14", dataLeAk747);
		android.util.Log.d("leak-748-14", dataLeAk748);
		android.util.Log.d("leak-750-14", dataLeAk750);
        if (mediaProvider != null) {
            mediaProvider.onDestroy();
        }

        if (observer != null) {
            observer.unregister(this);
        }
    }

    @Override
    public int getDarkThemeRes() {
        dataLeAk745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-15", dataLeAk712);
		android.util.Log.d("leak-720-15", dataLeAk720);
		android.util.Log.d("leak-723-15", dataLeAk723);
		android.util.Log.d("leak-724-15", dataLeAk724);
		android.util.Log.d("leak-730-15", dataLeAk730);
		android.util.Log.d("leak-731-15", dataLeAk731);
		android.util.Log.d("leak-732-15", dataLeAk732);
		android.util.Log.d("leak-735-15", dataLeAk735);
		android.util.Log.d("leak-737-15", dataLeAk737);
		android.util.Log.d("leak-738-15", dataLeAk738);
		android.util.Log.d("leak-739-15", dataLeAk739);
		android.util.Log.d("leak-740-15", dataLeAk740);
		android.util.Log.d("leak-742-15", dataLeAk742);
		android.util.Log.d("leak-743-15", dataLeAk743);
		android.util.Log.d("leak-744-15", dataLeAk744);
		android.util.Log.d("leak-745-15", dataLeAk745);
		android.util.Log.d("leak-746-15", dataLeAk746);
		android.util.Log.d("leak-747-15", dataLeAk747);
		android.util.Log.d("leak-748-15", dataLeAk748);
		android.util.Log.d("leak-750-15", dataLeAk750);
		return R.style.CameraRoll_Theme_Main;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-16", dataLeAk712);
		android.util.Log.d("leak-720-16", dataLeAk720);
		android.util.Log.d("leak-723-16", dataLeAk723);
		android.util.Log.d("leak-724-16", dataLeAk724);
		android.util.Log.d("leak-730-16", dataLeAk730);
		android.util.Log.d("leak-731-16", dataLeAk731);
		android.util.Log.d("leak-732-16", dataLeAk732);
		android.util.Log.d("leak-735-16", dataLeAk735);
		android.util.Log.d("leak-737-16", dataLeAk737);
		android.util.Log.d("leak-738-16", dataLeAk738);
		android.util.Log.d("leak-739-16", dataLeAk739);
		android.util.Log.d("leak-740-16", dataLeAk740);
		android.util.Log.d("leak-742-16", dataLeAk742);
		android.util.Log.d("leak-743-16", dataLeAk743);
		android.util.Log.d("leak-744-16", dataLeAk744);
		android.util.Log.d("leak-745-16", dataLeAk745);
		android.util.Log.d("leak-746-16", dataLeAk746);
		android.util.Log.d("leak-747-16", dataLeAk747);
		android.util.Log.d("leak-748-16", dataLeAk748);
		android.util.Log.d("leak-750-16", dataLeAk750);
		return R.style.CameraRoll_Theme_Light_Main;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        dataLeAk747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-17", dataLeAk712);
		android.util.Log.d("leak-720-17", dataLeAk720);
		android.util.Log.d("leak-723-17", dataLeAk723);
		android.util.Log.d("leak-724-17", dataLeAk724);
		android.util.Log.d("leak-730-17", dataLeAk730);
		android.util.Log.d("leak-731-17", dataLeAk731);
		android.util.Log.d("leak-732-17", dataLeAk732);
		android.util.Log.d("leak-735-17", dataLeAk735);
		android.util.Log.d("leak-737-17", dataLeAk737);
		android.util.Log.d("leak-738-17", dataLeAk738);
		android.util.Log.d("leak-739-17", dataLeAk739);
		android.util.Log.d("leak-740-17", dataLeAk740);
		android.util.Log.d("leak-742-17", dataLeAk742);
		android.util.Log.d("leak-743-17", dataLeAk743);
		android.util.Log.d("leak-744-17", dataLeAk744);
		android.util.Log.d("leak-745-17", dataLeAk745);
		android.util.Log.d("leak-746-17", dataLeAk746);
		android.util.Log.d("leak-747-17", dataLeAk747);
		android.util.Log.d("leak-748-17", dataLeAk748);
		android.util.Log.d("leak-750-17", dataLeAk750);
		if (pick_photos) {
            return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

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
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        dataLeAk748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-18", dataLeAk712);
		android.util.Log.d("leak-720-18", dataLeAk720);
		android.util.Log.d("leak-723-18", dataLeAk723);
		android.util.Log.d("leak-724-18", dataLeAk724);
		android.util.Log.d("leak-730-18", dataLeAk730);
		android.util.Log.d("leak-731-18", dataLeAk731);
		android.util.Log.d("leak-732-18", dataLeAk732);
		android.util.Log.d("leak-735-18", dataLeAk735);
		android.util.Log.d("leak-737-18", dataLeAk737);
		android.util.Log.d("leak-738-18", dataLeAk738);
		android.util.Log.d("leak-739-18", dataLeAk739);
		android.util.Log.d("leak-740-18", dataLeAk740);
		android.util.Log.d("leak-742-18", dataLeAk742);
		android.util.Log.d("leak-743-18", dataLeAk743);
		android.util.Log.d("leak-744-18", dataLeAk744);
		android.util.Log.d("leak-745-18", dataLeAk745);
		android.util.Log.d("leak-746-18", dataLeAk746);
		android.util.Log.d("leak-747-18", dataLeAk747);
		android.util.Log.d("leak-748-18", dataLeAk748);
		android.util.Log.d("leak-750-18", dataLeAk750);
		return new BroadcastReceiver() {
            String dataLeAk749 = "";

			@Override
            public void onReceive(Context context, final Intent intent) {
                dataLeAk749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-774-0", dataLeAk774);
				android.util.Log.d("leak-749-0", dataLeAk749);
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
        dataLeAk750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-712-19", dataLeAk712);
		android.util.Log.d("leak-720-19", dataLeAk720);
		android.util.Log.d("leak-723-19", dataLeAk723);
		android.util.Log.d("leak-724-19", dataLeAk724);
		android.util.Log.d("leak-730-19", dataLeAk730);
		android.util.Log.d("leak-731-19", dataLeAk731);
		android.util.Log.d("leak-732-19", dataLeAk732);
		android.util.Log.d("leak-735-19", dataLeAk735);
		android.util.Log.d("leak-737-19", dataLeAk737);
		android.util.Log.d("leak-738-19", dataLeAk738);
		android.util.Log.d("leak-739-19", dataLeAk739);
		android.util.Log.d("leak-740-19", dataLeAk740);
		android.util.Log.d("leak-742-19", dataLeAk742);
		android.util.Log.d("leak-743-19", dataLeAk743);
		android.util.Log.d("leak-744-19", dataLeAk744);
		android.util.Log.d("leak-745-19", dataLeAk745);
		android.util.Log.d("leak-746-19", dataLeAk746);
		android.util.Log.d("leak-747-19", dataLeAk747);
		android.util.Log.d("leak-748-19", dataLeAk748);
		android.util.Log.d("leak-750-19", dataLeAk750);
		IntentFilter filter = FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
        filter.addAction(RESORT);
        filter.addAction(DATA_CHANGED);
        return filter;
    }
}
