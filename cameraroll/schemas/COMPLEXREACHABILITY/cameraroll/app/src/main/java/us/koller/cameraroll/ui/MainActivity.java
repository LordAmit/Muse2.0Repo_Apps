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
        @Override
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            String dataLeAk1280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1280 = new String[] {"n/a", dataLeAk1280};
			String dataLeAkPath1280 = leakArRay1280[leakArRay1280.length - 1];
			android.util.Log.d("leak-1280", dataLeAkPath1280);
			if (sharedElementViewHolder == null) {
                String dataLeAk1281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1281 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1281.put("test", new java.util.HashMap<String, String>());
				leakMaP1281.get("test").put("test", dataLeAk1281);
				String dataLeAkPath1281 = leakMaP1281.get("test").get("test");
				android.util.Log.d("leak-1281", dataLeAkPath1281);
				return;
            }

            if (sharedElementViewHolder.sharedElementReturnPosition != -1
                    && sharedElementViewHolder.sharedElementReturnPosition <
                    sharedElementViewHolder.getAlbum().getAlbumItems().size()) {
                String dataLeAk1282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1282 = new StringBuffer();for (char chAr1282 : dataLeAk1282.toCharArray()) {leakBuFFer1282.append(chAr1282);}String dataLeAkPath1282 = leakBuFFer1282.toString();
						android.util.Log.d("leak-1282", dataLeAkPath1282);
				String newTransitionName = sharedElementViewHolder.getAlbum().getAlbumItems()
                        .get(sharedElementViewHolder.sharedElementReturnPosition).getPath();
                View layout = sharedElementViewHolder.nestedRecyclerView.findViewWithTag(newTransitionName);
                View newSharedElement = layout != null ? layout.findViewById(R.id.image) : null;
                if (newSharedElement != null) {
                    String dataLeAk1283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1283;try {throw new Exception(dataLeAk1283);} catch (Exception leakErRor1283) {dataLeAkPath1283 = leakErRor1283.getMessage();}
					android.util.Log.d("leak-1283", dataLeAkPath1283);
					names.clear();
                    names.add(newTransitionName);
                    sharedElements.clear();
                    sharedElements.put(newTransitionName, newSharedElement);
                }
                sharedElementViewHolder.sharedElementReturnPosition = -1;
            } else {
                String dataLeAk1284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1284 = new String[] {"n/a", dataLeAk1284};
				String dataLeAkPath1284 = leakArRay1284[leakArRay1284.length - 1];
				android.util.Log.d("leak-1284", dataLeAkPath1284);
				View v = sharedElementViewHolder.itemView.getRootView();
                View navigationBar = v.findViewById(android.R.id.navigationBarBackground);
                View statusBar = v.findViewById(android.R.id.statusBarBackground);
                if (navigationBar != null) {
                    String dataLeAk1285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1285 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1285.put("test", new java.util.HashMap<String, String>());
					leakMaP1285.get("test").put("test", dataLeAk1285);
					String dataLeAkPath1285 = leakMaP1285.get("test").get("test");
					android.util.Log.d("leak-1285", dataLeAkPath1285);
					names.add(navigationBar.getTransitionName());
                    sharedElements.put(navigationBar.getTransitionName(), navigationBar);
                }
                if (statusBar != null) {
                    String dataLeAk1286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1286 = new StringBuffer();for (char chAr1286 : dataLeAk1286.toCharArray()) {leakBuFFer1286.append(chAr1286);}String dataLeAkPath1286 = leakBuFFer1286.toString();
					android.util.Log.d("leak-1286", dataLeAkPath1286);
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
		String dataLeAk1287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1287;try {throw new Exception(dataLeAk1287);} catch (Exception leakErRor1287) {dataLeAkPath1287 = leakErRor1287.getMessage();}
		android.util.Log.d("leak-1287", dataLeAkPath1287);
        setContentView(R.layout.activity_main);

        pick_photos = getIntent().getAction() != null && getIntent().getAction().equals(PICK_PHOTOS);
        boolean allowMultiple = getIntent().getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);

        final Settings settings = Settings.getInstance(this);

        hiddenFolders = settings.getHiddenFolders();

        //load media
        albums = MediaProvider.getAlbums();
        if (albums == null) {
            String dataLeAk1288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1288 = new String[] {"n/a", dataLeAk1288};
			String dataLeAkPath1288 = leakArRay1288[leakArRay1288.length - 1];
			android.util.Log.d("leak-1288", dataLeAkPath1288);
			albums = new ArrayList<>();
        }

        if (savedInstanceState == null) {
            String dataLeAk1289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1289 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1289.put("test", new java.util.HashMap<String, String>());
			leakMaP1289.get("test").put("test", dataLeAk1289);
			String dataLeAkPath1289 = leakMaP1289.get("test").get("test");
			android.util.Log.d("leak-1289", dataLeAkPath1289);
			refreshPhotos();
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(!pick_photos ? toolbarColor : accentColor);
        toolbar.setTitleTextColor(!pick_photos ? textColorPrimary : accentTextColor);

        ActionBar actionBar = getSupportActionBar();
        if (pick_photos) {
            String dataLeAk1290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1290 = new StringBuffer();for (char chAr1290 : dataLeAk1290.toCharArray()) {leakBuFFer1290.append(chAr1290);}String dataLeAkPath1290 = leakBuFFer1290.toString();
			android.util.Log.d("leak-1290", dataLeAkPath1290);
			if (actionBar != null) {
                String dataLeAk1291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1291;try {throw new Exception(dataLeAk1291);} catch (Exception leakErRor1291) {dataLeAkPath1291 = leakErRor1291.getMessage();}
				android.util.Log.d("leak-1291", dataLeAkPath1291);
				actionBar.setTitle(allowMultiple ? getString(R.string.pick_photos) : getString(R.string.pick_photo));
            }
            toolbar.setActivated(true);
            toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon != null) {
                String dataLeAk1292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1292 = new String[] {"n/a", dataLeAk1292};
				String dataLeAkPath1292 = leakArRay1292[leakArRay1292.length - 1];
				android.util.Log.d("leak-1292", dataLeAkPath1292);
				navIcon = DrawableCompat.wrap(navIcon);
                DrawableCompat.setTint(navIcon.mutate(), accentTextColor);
                toolbar.setNavigationIcon(navIcon);
            }
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String dataLeAk1293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1293 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1293.put("test", new java.util.HashMap<String, String>());
					leakMaP1293.get("test").put("test", dataLeAk1293);
					String dataLeAkPath1293 = leakMaP1293.get("test").get("test");
					android.util.Log.d("leak-1293", dataLeAkPath1293);
					finish();
                }
            });

            Util.colorToolbarOverflowMenuIcon(toolbar, accentTextColor);
            if (theme.darkStatusBarIconsInSelectorMode()) {
                String dataLeAk1294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1294 = new StringBuffer();for (char chAr1294 : dataLeAk1294.toCharArray()) {leakBuFFer1294.append(chAr1294);}String dataLeAkPath1294 = leakBuFFer1294.toString();
				android.util.Log.d("leak-1294", dataLeAkPath1294);
				Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
            }
        } else {
            String dataLeAk1295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1295;try {throw new Exception(dataLeAk1295);} catch (Exception leakErRor1295) {dataLeAkPath1295 = leakErRor1295.getMessage();}
			android.util.Log.d("leak-1295", dataLeAkPath1295);
			if (actionBar != null) {
                String dataLeAk1296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1296 = new String[] {"n/a", dataLeAk1296};
				String dataLeAkPath1296 = leakArRay1296[leakArRay1296.length - 1];
				android.util.Log.d("leak-1296", dataLeAkPath1296);
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
            String dataLeAk1297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1297 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1297.put("test", new java.util.HashMap<String, String>());
			leakMaP1297.get("test").put("test", dataLeAk1297);
			String dataLeAkPath1297 = leakMaP1297.get("test").get("test");
			android.util.Log.d("leak-1297", dataLeAkPath1297);
			((FastScrollerRecyclerView) recyclerView).addOuterGridSpacing(spacing);
        }

        //disable default change animation
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        //restore Selector mode, when needed
        if (savedInstanceState != null) {
            String dataLeAk1298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1298 = new StringBuffer();for (char chAr1298 : dataLeAk1298.toCharArray()) {leakBuFFer1298.append(chAr1298);}String dataLeAkPath1298 = leakBuFFer1298.toString();
			android.util.Log.d("leak-1298", dataLeAkPath1298);
			SelectorModeManager manager = new SelectorModeManager(savedInstanceState);
            recyclerViewAdapter.setSelectorModeManager(manager);
        }

        recyclerViewAdapter.getSelectorManager()
                .addCallback(new SelectorModeManager.SimpleCallback() {
                    @Override
                    public void onSelectorModeEnter() {
                        super.onSelectorModeEnter();
						String dataLeAk1299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1299;try {throw new Exception(dataLeAk1299);} catch (Exception leakErRor1299) {dataLeAkPath1299 = leakErRor1299.getMessage();}
						android.util.Log.d("leak-1299", dataLeAkPath1299);
                        showAndHideFab(false);
                    }

                    @Override
                    public void onSelectorModeExit() {
                        super.onSelectorModeExit();
						String dataLeAk1300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1300 = new String[] {"n/a", dataLeAk1300};
						String dataLeAkPath1300 = leakArRay1300[leakArRay1300.length - 1];
						android.util.Log.d("leak-1300", dataLeAkPath1300);
                        showAndHideFab(true);
                    }
                });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
				String dataLeAk1301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1301 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1301.put("test", new java.util.HashMap<String, String>());
				leakMaP1301.get("test").put("test", dataLeAk1301);
				String dataLeAkPath1301 = leakMaP1301.get("test").get("test");
				android.util.Log.d("leak-1301", dataLeAkPath1301);
                if (pick_photos) {
                    String dataLeAk1302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1302 = new StringBuffer();for (char chAr1302 : dataLeAk1302.toCharArray()) {leakBuFFer1302.append(chAr1302);}String dataLeAkPath1302 = leakBuFFer1302.toString();
					android.util.Log.d("leak-1302", dataLeAkPath1302);
					return;
                }

                //hiding toolbar on scroll
                float translationY = toolbar.getTranslationY() - dy;
                if (-translationY > toolbar.getHeight()) {
                    String dataLeAk1303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1303;try {throw new Exception(dataLeAk1303);} catch (Exception leakErRor1303) {dataLeAkPath1303 = leakErRor1303.getMessage();}
					android.util.Log.d("leak-1303", dataLeAkPath1303);
					translationY = -toolbar.getHeight();
                    if (theme.elevatedToolbar()) {
                        String dataLeAk1304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1304 = new String[] {"n/a", dataLeAk1304};
						String dataLeAkPath1304 = leakArRay1304[leakArRay1304.length - 1];
						android.util.Log.d("leak-1304", dataLeAkPath1304);
						toolbar.setActivated(true);
                    }
                } else if (translationY > 0) {
                    String dataLeAk1305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1305 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1305.put("test", new java.util.HashMap<String, String>());
					leakMaP1305.get("test").put("test", dataLeAk1305);
					String dataLeAkPath1305 = leakMaP1305.get("test").get("test");
					android.util.Log.d("leak-1305", dataLeAkPath1305);
					translationY = 0;
                    if (theme.elevatedToolbar() &&
                            !recyclerView.canScrollVertically(-1)) {
                        String dataLeAk1306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer1306 = new StringBuffer();for (char chAr1306 : dataLeAk1306.toCharArray()) {leakBuFFer1306.append(chAr1306);}String dataLeAkPath1306 = leakBuFFer1306.toString();
								android.util.Log.d("leak-1306", dataLeAkPath1306);
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
                    String dataLeAk1307 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1307;try {throw new Exception(dataLeAk1307);} catch (Exception leakErRor1307) {dataLeAkPath1307 = leakErRor1307.getMessage();}
							android.util.Log.d("leak-1307", dataLeAkPath1307);
					//only animate statusBar icons color, when not in selectorMode
                    float animatedValue = (-translationY) / toolbar.getHeight();
                    if (animatedValue > 0.9f) {
                        String dataLeAk1308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1308 = new String[] {"n/a", dataLeAk1308};
						String dataLeAkPath1308 = leakArRay1308[leakArRay1308.length - 1];
						android.util.Log.d("leak-1308", dataLeAkPath1308);
						Util.setLightStatusBarIcons(findViewById(R.id.root_view));
                    } else {
                        String dataLeAk1309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1309 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1309.put("test", new java.util.HashMap<String, String>());
						leakMaP1309.get("test").put("test", dataLeAk1309);
						String dataLeAkPath1309 = leakMaP1309.get("test").get("test");
						android.util.Log.d("leak-1309", dataLeAkPath1309);
						Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
                    }
                }
            }
        });

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk1310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1310 = new StringBuffer();for (char chAr1310 : dataLeAk1310.toCharArray()) {leakBuFFer1310.append(chAr1310);}String dataLeAkPath1310 = leakBuFFer1310.toString();
				android.util.Log.d("leak-1310", dataLeAkPath1310);
				fabClicked(view);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1311;try {throw new Exception(dataLeAk1311);} catch (Exception leakErRor1311) {dataLeAkPath1311 = leakErRor1311.getMessage();}
			android.util.Log.d("leak-1311", dataLeAkPath1311);
			Drawable d = ContextCompat.getDrawable(this,
                    R.drawable.ic_camera_lens_avd);
            fab.setImageDrawable(d);
        } else {
            String dataLeAk1312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1312 = new String[] {"n/a", dataLeAk1312};
			String dataLeAkPath1312 = leakArRay1312[leakArRay1312.length - 1];
			android.util.Log.d("leak-1312", dataLeAkPath1312);
			fab.setImageResource(R.drawable.ic_camera_white_24dp);
        }
        Drawable d = fab.getDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1313 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1313.put("test", new java.util.HashMap<String, String>());
			leakMaP1313.get("test").put("test", dataLeAk1313);
			String dataLeAkPath1313 = leakMaP1313.get("test").get("test");
			android.util.Log.d("leak-1313", dataLeAkPath1313);
			d.setTint(accentTextColor);
        } else {
            String dataLeAk1314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1314 = new StringBuffer();for (char chAr1314 : dataLeAk1314.toCharArray()) {leakBuFFer1314.append(chAr1314);}String dataLeAkPath1314 = leakBuFFer1314.toString();
			android.util.Log.d("leak-1314", dataLeAkPath1314);
			d = DrawableCompat.wrap(d);
            DrawableCompat.setTint(d.mutate(), accentTextColor);
        }
        fab.setImageDrawable(d);

        if (pick_photos || !settings.getCameraShortcut()) {
            String dataLeAk1315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1315;try {throw new Exception(dataLeAk1315);} catch (Exception leakErRor1315) {dataLeAkPath1315 = leakErRor1315.getMessage();}
			android.util.Log.d("leak-1315", dataLeAkPath1315);
			fab.setVisibility(View.GONE);
        }

        //setting window insets manually
        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk1316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1316 = new String[] {"n/a", dataLeAk1316};
			String dataLeAkPath1316 = leakArRay1316[leakArRay1316.length - 1];
			android.util.Log.d("leak-1316", dataLeAkPath1316);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk1317 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1317 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1317.put("test", new java.util.HashMap<String, String>());
					leakMaP1317.get("test").put("test", dataLeAk1317);
					String dataLeAkPath1317 = leakMaP1317.get("test").get("test");
					android.util.Log.d("leak-1317", dataLeAkPath1317);
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
            String dataLeAk1318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1318 = new StringBuffer();for (char chAr1318 : dataLeAk1318.toCharArray()) {leakBuFFer1318.append(chAr1318);}String dataLeAkPath1318 = leakBuFFer1318.toString();
			android.util.Log.d("leak-1318", dataLeAkPath1318);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk1319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath1319;try {throw new Exception(dataLeAk1319);} catch (Exception leakErRor1319) {dataLeAkPath1319 = leakErRor1319.getMessage();}
									android.util.Log.d("leak-1319", dataLeAkPath1319);
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
		String dataLeAk1320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1320 = new String[] {"n/a", dataLeAk1320};
		String dataLeAkPath1320 = leakArRay1320[leakArRay1320.length - 1];
		android.util.Log.d("leak-1320", dataLeAkPath1320);

        int nestedRecyclerViewValue = getResources().getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE);
        if (intent.getAction() != null
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                && intent.getAction().equals(ItemActivity.SHARED_ELEMENT_RETURN_TRANSITION)
                && Settings.getInstance(this).getStyle(this, pick_photos) == nestedRecyclerViewValue) {
            String dataLeAk1321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1321 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1321.put("test", new java.util.HashMap<String, String>());
					leakMaP1321.get("test").put("test", dataLeAk1321);
					String dataLeAkPath1321 = leakMaP1321.get("test").get("test");
					android.util.Log.d("leak-1321", dataLeAkPath1321);
			//handle shared-element transition, for nested nestedRecyclerView style
            Bundle tmpReenterState = new Bundle(intent.getExtras());
            if (tmpReenterState.containsKey(AlbumActivity.ALBUM_PATH)
                    && tmpReenterState.containsKey(AlbumActivity.EXTRA_CURRENT_ALBUM_POSITION)) {

                String dataLeAk1322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1322 = new StringBuffer();for (char chAr1322 : dataLeAk1322.toCharArray()) {leakBuFFer1322.append(chAr1322);}String dataLeAkPath1322 = leakBuFFer1322.toString();
						android.util.Log.d("leak-1322", dataLeAkPath1322);
				String albumPath = tmpReenterState.getString(AlbumActivity.ALBUM_PATH);
                final int sharedElementReturnPosition = tmpReenterState.getInt(AlbumActivity.EXTRA_CURRENT_ALBUM_POSITION);
                int index = -1;
                ArrayList<Album> albums = MediaProvider.getAlbumsWithVirtualDirectories(this);
                for (int i = 0; i < albums.size(); i++) {
                    String dataLeAk1323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1323;try {throw new Exception(dataLeAk1323);} catch (Exception leakErRor1323) {dataLeAkPath1323 = leakErRor1323.getMessage();}
					android.util.Log.d("leak-1323", dataLeAkPath1323);
					if (albums.get(i).getPath().equals(albumPath)) {
                        String dataLeAk1324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1324 = new String[] {"n/a", dataLeAk1324};
						String dataLeAkPath1324 = leakArRay1324[leakArRay1324.length - 1];
						android.util.Log.d("leak-1324", dataLeAkPath1324);
						index = i;
                        break;
                    }
                }

                if (index == -1) {
                    String dataLeAk1325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1325 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1325.put("test", new java.util.HashMap<String, String>());
					leakMaP1325.get("test").put("test", dataLeAk1325);
					String dataLeAkPath1325 = leakMaP1325.get("test").get("test");
					android.util.Log.d("leak-1325", dataLeAkPath1325);
					return;
                }

                //postponing transition until sharedElement is laid out
                postponeEnterTransition();
                setExitSharedElementCallback(mCallback);
                final NestedRecyclerViewAlbumHolder
                        .StartSharedElementTransitionCallback callback =
                        new NestedRecyclerViewAlbumHolder
                                .StartSharedElementTransitionCallback() {
                            @Override
                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            public void startPostponedEnterTransition() {
                                String dataLeAk1326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer1326 = new StringBuffer();for (char chAr1326 : dataLeAk1326.toCharArray()) {leakBuFFer1326.append(chAr1326);}String dataLeAkPath1326 = leakBuFFer1326.toString();
								android.util.Log.d("leak-1326", dataLeAkPath1326);
								//sharedElement is laid out --> start transition
                                MainActivity.this.startPostponedEnterTransition();
                            }
                        };

                final int finalIndex = index;
                recyclerView.scrollToPosition(index);
                //wait until ViewHolder is laid out
                recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onLayoutChange(View v, int l, int t, int r, int b,
                                               int oL, int oT, int oR, int oB) {
                        String dataLeAk1327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												String dataLeAkPath1327;try {throw new Exception(dataLeAk1327);} catch (Exception leakErRor1327) {dataLeAkPath1327 = leakErRor1327.getMessage();}
												android.util.Log.d("leak-1327", dataLeAkPath1327);
						RecyclerView.ViewHolder viewHolder
                                = recyclerView.findViewHolderForAdapterPosition(finalIndex);

                        if (viewHolder != null) {
                            String dataLeAk1328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1328 = new String[] {"n/a", dataLeAk1328};
							String dataLeAkPath1328 = leakArRay1328[leakArRay1328.length - 1];
							android.util.Log.d("leak-1328", dataLeAkPath1328);
							recyclerView.removeOnLayoutChangeListener(this);
                        } else {
                            String dataLeAk1329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1329 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1329.put("test", new java.util.HashMap<String, String>());
							leakMaP1329.get("test").put("test", dataLeAk1329);
							String dataLeAkPath1329 = leakMaP1329.get("test").get("test");
							android.util.Log.d("leak-1329", dataLeAkPath1329);
							//viewHolder hasn't been laid out yet --> wait
                            recyclerView.scrollToPosition(finalIndex);
                        }

                        if (viewHolder instanceof NestedRecyclerViewAlbumHolder) {
                            String dataLeAk1330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1330 = new StringBuffer();for (char chAr1330 : dataLeAk1330.toCharArray()) {leakBuFFer1330.append(chAr1330);}String dataLeAkPath1330 = leakBuFFer1330.toString();
							android.util.Log.d("leak-1330", dataLeAkPath1330);
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
		String dataLeAk1331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1331;try {throw new Exception(dataLeAk1331);} catch (Exception leakErRor1331) {dataLeAkPath1331 = leakErRor1331.getMessage();}
		android.util.Log.d("leak-1331", dataLeAkPath1331);

        if (intent == null || intent.getAction() == null) {
            String dataLeAk1332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1332 = new String[] {"n/a", dataLeAk1332};
			String dataLeAkPath1332 = leakArRay1332[leakArRay1332.length - 1];
			android.util.Log.d("leak-1332", dataLeAkPath1332);
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
        String dataLeAk1333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1333 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1333.put("test", new java.util.HashMap<String, String>());
		leakMaP1333.get("test").put("test", dataLeAk1333);
		String dataLeAkPath1333 = leakMaP1333.get("test").get("test");
		android.util.Log.d("leak-1333", dataLeAkPath1333);
		if (mediaProvider != null) {
            String dataLeAk1334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1334 = new StringBuffer();for (char chAr1334 : dataLeAk1334.toCharArray()) {leakBuFFer1334.append(chAr1334);}String dataLeAkPath1334 = leakBuFFer1334.toString();
			android.util.Log.d("leak-1334", dataLeAkPath1334);
			mediaProvider.onDestroy();
            mediaProvider = null;
        }

        snackbar = Snackbar.make(findViewById(R.id.root_view),
                R.string.loading, Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);

        final MediaProvider.OnMediaLoadedCallback callback
                = new MediaProvider.OnMediaLoadedCallback() {
            @Override
            public void onMediaLoaded(final ArrayList<Album> albums) {
                String dataLeAk1335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1335;try {throw new Exception(dataLeAk1335);} catch (Exception leakErRor1335) {dataLeAkPath1335 = leakErRor1335.getMessage();}
				android.util.Log.d("leak-1335", dataLeAkPath1335);
				final ArrayList<Album> albumsWithVirtualDirs =
                        MediaProvider.getAlbumsWithVirtualDirectories(MainActivity.this);
                if (albums != null) {
                    String dataLeAk1336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1336 = new String[] {"n/a", dataLeAk1336};
					String dataLeAkPath1336 = leakArRay1336[leakArRay1336.length - 1];
					android.util.Log.d("leak-1336", dataLeAkPath1336);
					MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String dataLeAk1337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1337 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1337.put("test", new java.util.HashMap<String, String>());
							leakMaP1337.get("test").put("test", dataLeAk1337);
							String dataLeAkPath1337 = leakMaP1337.get("test").get("test");
							android.util.Log.d("leak-1337", dataLeAkPath1337);
							MainActivity.this.albums = albumsWithVirtualDirs;
                            recyclerViewAdapter.setAlbums(albumsWithVirtualDirs);
                            recyclerViewAdapter.notifyDataSetChanged();

                            snackbar.dismiss();

                            if (mediaProvider != null) {
                                String dataLeAk1338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer1338 = new StringBuffer();for (char chAr1338 : dataLeAk1338.toCharArray()) {leakBuFFer1338.append(chAr1338);}String dataLeAkPath1338 = leakBuFFer1338.toString();
								android.util.Log.d("leak-1338", dataLeAkPath1338);
								mediaProvider.onDestroy();
                            }
                            mediaProvider = null;
                        }
                    });
                }
            }

            @Override
            public void timeout() {
                String dataLeAk1339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1339;try {throw new Exception(dataLeAk1339);} catch (Exception leakErRor1339) {dataLeAkPath1339 = leakErRor1339.getMessage();}
				android.util.Log.d("leak-1339", dataLeAkPath1339);
				//handle timeout
                snackbar.dismiss();
                snackbar = Snackbar.make(findViewById(R.id.root_view),
                        R.string.loading_failed, Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction(getString(R.string.retry), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String dataLeAk1340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1340 = new String[] {"n/a", dataLeAk1340};
						String dataLeAkPath1340 = leakArRay1340[leakArRay1340.length - 1];
						android.util.Log.d("leak-1340", dataLeAkPath1340);
						if (mediaProvider != null) {
                            String dataLeAk1341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1341 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1341.put("test", new java.util.HashMap<String, String>());
							leakMaP1341.get("test").put("test", dataLeAk1341);
							String dataLeAkPath1341 = leakMaP1341.get("test").get("test");
							android.util.Log.d("leak-1341", dataLeAkPath1341);
							mediaProvider.onDestroy();
                        }
                        refreshPhotos();
                        snackbar.dismiss();
                    }
                });
                Util.showSnackbar(snackbar);

                if (mediaProvider != null) {
                    String dataLeAk1342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1342 = new StringBuffer();for (char chAr1342 : dataLeAk1342.toCharArray()) {leakBuFFer1342.append(chAr1342);}String dataLeAkPath1342 = leakBuFFer1342.toString();
					android.util.Log.d("leak-1342", dataLeAkPath1342);
					mediaProvider.onDestroy();
                }
                mediaProvider = null;
            }

            @Override
            public void needPermission() {
                String dataLeAk1343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1343;try {throw new Exception(dataLeAk1343);} catch (Exception leakErRor1343) {dataLeAkPath1343 = leakErRor1343.getMessage();}
				android.util.Log.d("leak-1343", dataLeAkPath1343);
				snackbar.dismiss();
            }
        };

        mediaProvider = new MediaProvider(this);
        mediaProvider.loadAlbums(MainActivity.this, hiddenFolders, callback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk1344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1344 = new String[] {"n/a", dataLeAk1344};
		String dataLeAkPath1344 = leakArRay1344[leakArRay1344.length - 1];
		android.util.Log.d("leak-1344", dataLeAkPath1344);
        getMenuInflater().inflate(R.menu.main, menu);
        menu.findItem(R.id.hiddenFolders).setChecked(hiddenFolders);

        int sort_by = Settings.getInstance(this).sortAlbumsBy();
        if (sort_by == SortUtil.BY_NAME) {
            String dataLeAk1345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1345 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1345.put("test", new java.util.HashMap<String, String>());
			leakMaP1345.get("test").put("test", dataLeAk1345);
			String dataLeAkPath1345 = leakMaP1345.get("test").get("test");
			android.util.Log.d("leak-1345", dataLeAkPath1345);
			menu.findItem(R.id.sort_by_name).setChecked(true);
        } else if (sort_by == SortUtil.BY_SIZE) {
            String dataLeAk1346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1346 = new StringBuffer();for (char chAr1346 : dataLeAk1346.toCharArray()) {leakBuFFer1346.append(chAr1346);}String dataLeAkPath1346 = leakBuFFer1346.toString();
			android.util.Log.d("leak-1346", dataLeAkPath1346);
			menu.findItem(R.id.sort_by_size).setChecked(true);
        } else if (sort_by == SortUtil.BY_DATE) {
            String dataLeAk1347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1347;try {throw new Exception(dataLeAk1347);} catch (Exception leakErRor1347) {dataLeAkPath1347 = leakErRor1347.getMessage();}
			android.util.Log.d("leak-1347", dataLeAkPath1347);
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
            String dataLeAk1348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1348 = new String[] {"n/a", dataLeAk1348};
			String dataLeAkPath1348 = leakArRay1348[leakArRay1348.length - 1];
			android.util.Log.d("leak-1348", dataLeAkPath1348);
			menu.findItem(R.id.file_explorer).setVisible(false);
            menu.findItem(R.id.settings).setVisible(false);
            menu.findItem(R.id.about).setVisible(false);
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk1349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1349 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1349.put("test", new java.util.HashMap<String, String>());
		leakMaP1349.get("test").put("test", dataLeAk1349);
		String dataLeAkPath1349 = leakMaP1349.get("test").get("test");
		android.util.Log.d("leak-1349", dataLeAkPath1349);
		switch (item.getItemId()) {
            case R.id.camera_shortcut:
                Drawable d = item.getIcon();
                if (d instanceof Animatable
                        && !((Animatable) d).isRunning()) {
                    String dataLeAk1350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer1350 = new StringBuffer();for (char chAr1350 : dataLeAk1350.toCharArray()) {leakBuFFer1350.append(chAr1350);}String dataLeAkPath1350 = leakBuFFer1350.toString();
							android.util.Log.d("leak-1350", dataLeAkPath1350);
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
                    String dataLeAk1351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1351;try {throw new Exception(dataLeAk1351);} catch (Exception leakErRor1351) {dataLeAkPath1351 = leakErRor1351.getMessage();}
					android.util.Log.d("leak-1351", dataLeAkPath1351);
					sort_by = SortUtil.BY_NAME;
                } else if (item.getItemId() == R.id.sort_by_size) {
                    String dataLeAk1352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1352 = new String[] {"n/a", dataLeAk1352};
					String dataLeAkPath1352 = leakArRay1352[leakArRay1352.length - 1];
					android.util.Log.d("leak-1352", dataLeAkPath1352);
					sort_by = SortUtil.BY_SIZE;
                } else {
                    String dataLeAk1353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1353 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1353.put("test", new java.util.HashMap<String, String>());
					leakMaP1353.get("test").put("test", dataLeAk1353);
					String dataLeAkPath1353 = leakMaP1353.get("test").get("test");
					android.util.Log.d("leak-1353", dataLeAkPath1353);
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
        String dataLeAk1354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1354 = new StringBuffer();for (char chAr1354 : dataLeAk1354.toCharArray()) {leakBuFFer1354.append(chAr1354);}String dataLeAkPath1354 = leakBuFFer1354.toString();
		android.util.Log.d("leak-1354", dataLeAkPath1354);
		final Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view),
                "Sorting...", Snackbar.LENGTH_INDEFINITE);
        Util.showSnackbar(snackbar);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String dataLeAk1355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1355;try {throw new Exception(dataLeAk1355);} catch (Exception leakErRor1355) {dataLeAkPath1355 = leakErRor1355.getMessage();}
				android.util.Log.d("leak-1355", dataLeAkPath1355);
				//SortUtil.sortAlbums(MainActivity.this, MediaProvider.getAlbums());
                final ArrayList<Album> albums = MediaProvider.getAlbumsWithVirtualDirectories(MainActivity.this);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dataLeAk1356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1356 = new String[] {"n/a", dataLeAk1356};
						String dataLeAkPath1356 = leakArRay1356[leakArRay1356.length - 1];
						android.util.Log.d("leak-1356", dataLeAkPath1356);
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
        String dataLeAk1357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1357 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1357.put("test", new java.util.HashMap<String, String>());
		leakMaP1357.get("test").put("test", dataLeAk1357);
		String dataLeAkPath1357 = leakMaP1357.get("test").get("test");
		android.util.Log.d("leak-1357", dataLeAkPath1357);
		if (v instanceof FloatingActionButton) {
            String dataLeAk1358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1358 = new StringBuffer();for (char chAr1358 : dataLeAk1358.toCharArray()) {leakBuFFer1358.append(chAr1358);}String dataLeAkPath1358 = leakBuFFer1358.toString();
			android.util.Log.d("leak-1358", dataLeAkPath1358);
			FloatingActionButton fab = (FloatingActionButton) v;
            Drawable drawable = fab.getDrawable();
            if (drawable instanceof Animatable) {
                String dataLeAk1359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1359;try {throw new Exception(dataLeAk1359);} catch (Exception leakErRor1359) {dataLeAkPath1359 = leakErRor1359.getMessage();}
				android.util.Log.d("leak-1359", dataLeAkPath1359);
				((Animatable) drawable).start();
            }
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String dataLeAk1360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1360 = new String[] {"n/a", dataLeAk1360};
				String dataLeAkPath1360 = leakArRay1360[leakArRay1360.length - 1];
				android.util.Log.d("leak-1360", dataLeAkPath1360);
				Intent i = new Intent();
                i.setAction(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (i.resolveActivity(getPackageManager()) != null) {
                    String dataLeAk1361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1361 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1361.put("test", new java.util.HashMap<String, String>());
					leakMaP1361.get("test").put("test", dataLeAk1361);
					String dataLeAkPath1361 = leakMaP1361.get("test").get("test");
					android.util.Log.d("leak-1361", dataLeAkPath1361);
					startActivity(i);
                } else {
                    String dataLeAk1362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1362 = new StringBuffer();for (char chAr1362 : dataLeAk1362.toCharArray()) {leakBuFFer1362.append(chAr1362);}String dataLeAkPath1362 = leakBuFFer1362.toString();
					android.util.Log.d("leak-1362", dataLeAkPath1362);
					Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        }, (int) (500 * Util.getAnimatorSpeed(this)));
    }

    public void showAndHideFab(boolean show) {
        String dataLeAk1363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1363;try {throw new Exception(dataLeAk1363);} catch (Exception leakErRor1363) {dataLeAkPath1363 = leakErRor1363.getMessage();}
		android.util.Log.d("leak-1363", dataLeAkPath1363);
		if (pick_photos || !Settings.getInstance(this).getCameraShortcut()) {
            String dataLeAk1364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1364 = new String[] {"n/a", dataLeAk1364};
			String dataLeAkPath1364 = leakArRay1364[leakArRay1364.length - 1];
			android.util.Log.d("leak-1364", dataLeAkPath1364);
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
		String dataLeAk1365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1365 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1365.put("test", new java.util.HashMap<String, String>());
		leakMaP1365.get("test").put("test", dataLeAk1365);
		String dataLeAkPath1365 = leakMaP1365.get("test").get("test");
		android.util.Log.d("leak-1365", dataLeAkPath1365);
        refreshPhotos();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
		String dataLeAk1366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1366 = new StringBuffer();for (char chAr1366 : dataLeAk1366.toCharArray()) {leakBuFFer1366.append(chAr1366);}String dataLeAkPath1366 = leakBuFFer1366.toString();
		android.util.Log.d("leak-1366", dataLeAkPath1366);
        switch (requestCode) {
            case PICK_PHOTOS_REQUEST_CODE:
                if (resultCode != RESULT_CANCELED) {
                    String dataLeAk1367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1367;try {throw new Exception(dataLeAk1367);} catch (Exception leakErRor1367) {dataLeAkPath1367 = leakErRor1367.getMessage();}
					android.util.Log.d("leak-1367", dataLeAkPath1367);
					setResult(RESULT_OK, data);
                    this.finish();
                }
                break;
            case REFRESH_PHOTOS_REQUEST_CODE:
                if (data != null
                        && data.getAction() != null
                        && (data.getAction().equals(AlbumActivity.ALBUM_ITEM_REMOVED)
                        || data.getAction().equals(REFRESH_MEDIA))) {
                    String dataLeAk1368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay1368 = new String[] {"n/a", dataLeAk1368};
							String dataLeAkPath1368 = leakArRay1368[leakArRay1368.length - 1];
							android.util.Log.d("leak-1368", dataLeAkPath1368);
					refreshPhotos();
                }
                break;
            case AlbumActivity.FILE_OP_DIALOG_REQUEST:
                if (resultCode == RESULT_OK) {
                    String dataLeAk1369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1369 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1369.put("test", new java.util.HashMap<String, String>());
					leakMaP1369.get("test").put("test", dataLeAk1369);
					String dataLeAkPath1369 = leakMaP1369.get("test").get("test");
					android.util.Log.d("leak-1369", dataLeAkPath1369);
					refreshPhotos();
                }
                break;
            case SETTINGS_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String dataLeAk1370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1370 = new StringBuffer();for (char chAr1370 : dataLeAk1370.toCharArray()) {leakBuFFer1370.append(chAr1370);}String dataLeAkPath1370 = leakBuFFer1370.toString();
					android.util.Log.d("leak-1370", dataLeAkPath1370);
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
		String dataLeAk1371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1371;try {throw new Exception(dataLeAk1371);} catch (Exception leakErRor1371) {dataLeAkPath1371 = leakErRor1371.getMessage();}
		android.util.Log.d("leak-1371", dataLeAkPath1371);

        observer = new ContentObserver(new Handler());
        observer.setListener(new ContentObserver.Listener() {
            @Override
            public void onChange(boolean selfChange, Uri uri) {
                String dataLeAk1372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1372 = new String[] {"n/a", dataLeAk1372};
				String dataLeAkPath1372 = leakArRay1372[leakArRay1372.length - 1];
				android.util.Log.d("leak-1372", dataLeAkPath1372);
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
		String dataLeAk1373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1373 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1373.put("test", new java.util.HashMap<String, String>());
		leakMaP1373.get("test").put("test", dataLeAk1373);
		String dataLeAkPath1373 = leakMaP1373.get("test").get("test");
		android.util.Log.d("leak-1373", dataLeAkPath1373);

        RecyclerViewAdapter adapter = ((RecyclerViewAdapter) recyclerView.getAdapter());
        adapter.saveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        String dataLeAk1374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1374 = new StringBuffer();for (char chAr1374 : dataLeAk1374.toCharArray()) {leakBuFFer1374.append(chAr1374);}String dataLeAkPath1374 = leakBuFFer1374.toString();
		android.util.Log.d("leak-1374", dataLeAkPath1374);
		RecyclerViewAdapter adapter
                = ((RecyclerViewAdapter) recyclerView.getAdapter());
        if (!adapter.onBackPressed()) {
            super.onBackPressed();
			String dataLeAk1375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1375;try {throw new Exception(dataLeAk1375);} catch (Exception leakErRor1375) {dataLeAkPath1375 = leakErRor1375.getMessage();}
			android.util.Log.d("leak-1375", dataLeAkPath1375);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1376 = new String[] {"n/a", dataLeAk1376};
		String dataLeAkPath1376 = leakArRay1376[leakArRay1376.length - 1];
		android.util.Log.d("leak-1376", dataLeAkPath1376);
        if (mediaProvider != null) {
            String dataLeAk1377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1377 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1377.put("test", new java.util.HashMap<String, String>());
			leakMaP1377.get("test").put("test", dataLeAk1377);
			String dataLeAkPath1377 = leakMaP1377.get("test").get("test");
			android.util.Log.d("leak-1377", dataLeAkPath1377);
			mediaProvider.onDestroy();
        }

        if (observer != null) {
            String dataLeAk1378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1378 = new StringBuffer();for (char chAr1378 : dataLeAk1378.toCharArray()) {leakBuFFer1378.append(chAr1378);}String dataLeAkPath1378 = leakBuFFer1378.toString();
			android.util.Log.d("leak-1378", dataLeAkPath1378);
			observer.unregister(this);
        }
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk1379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1379;try {throw new Exception(dataLeAk1379);} catch (Exception leakErRor1379) {dataLeAkPath1379 = leakErRor1379.getMessage();}
		android.util.Log.d("leak-1379", dataLeAkPath1379);
		return R.style.CameraRoll_Theme_Main;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1380 = new String[] {"n/a", dataLeAk1380};
		String dataLeAkPath1380 = leakArRay1380[leakArRay1380.length - 1];
		android.util.Log.d("leak-1380", dataLeAkPath1380);
		return R.style.CameraRoll_Theme_Light_Main;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk1381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1381 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1381.put("test", new java.util.HashMap<String, String>());
		leakMaP1381.get("test").put("test", dataLeAk1381);
		String dataLeAkPath1381 = leakMaP1381.get("test").get("test");
		android.util.Log.d("leak-1381", dataLeAkPath1381);
		if (pick_photos) {
            String dataLeAk1382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1382 = new StringBuffer();for (char chAr1382 : dataLeAk1382.toCharArray()) {leakBuFFer1382.append(chAr1382);}String dataLeAkPath1382 = leakBuFFer1382.toString();
			android.util.Log.d("leak-1382", dataLeAkPath1382);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons()) {
            String dataLeAk1383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1383;try {throw new Exception(dataLeAk1383);} catch (Exception leakErRor1383) {dataLeAkPath1383 = leakErRor1383.getMessage();}
			android.util.Log.d("leak-1383", dataLeAkPath1383);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk1384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1384 = new String[] {"n/a", dataLeAk1384};
			String dataLeAkPath1384 = leakArRay1384[leakArRay1384.length - 1];
			android.util.Log.d("leak-1384", dataLeAkPath1384);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        if (theme.statusBarOverlay()) {
            String dataLeAk1385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1385 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1385.put("test", new java.util.HashMap<String, String>());
			leakMaP1385.get("test").put("test", dataLeAk1385);
			String dataLeAkPath1385 = leakMaP1385.get("test").get("test");
			android.util.Log.d("leak-1385", dataLeAkPath1385);
			addStatusBarOverlay(toolbar);
        }
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk1386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1386 = new StringBuffer();for (char chAr1386 : dataLeAk1386.toCharArray()) {leakBuFFer1386.append(chAr1386);}String dataLeAkPath1386 = leakBuFFer1386.toString();
		android.util.Log.d("leak-1386", dataLeAkPath1386);
		return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, final Intent intent) {
                String dataLeAk1387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1387;try {throw new Exception(dataLeAk1387);} catch (Exception leakErRor1387) {dataLeAkPath1387 = leakErRor1387.getMessage();}
				android.util.Log.d("leak-1387", dataLeAkPath1387);
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
        String dataLeAk1388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1388 = new String[] {"n/a", dataLeAk1388};
		String dataLeAkPath1388 = leakArRay1388[leakArRay1388.length - 1];
		android.util.Log.d("leak-1388", dataLeAkPath1388);
		IntentFilter filter = FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
        filter.addAction(RESORT);
        filter.addAction(DATA_CHANGED);
        return filter;
    }
}
