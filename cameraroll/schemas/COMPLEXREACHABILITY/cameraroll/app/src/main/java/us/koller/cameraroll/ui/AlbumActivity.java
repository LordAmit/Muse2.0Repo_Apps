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
        @Override
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            String dataLeAk1883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1883;try {throw new Exception(dataLeAk1883);} catch (Exception leakErRor1883) {dataLeAkPath1883 = leakErRor1883.getMessage();}
			android.util.Log.d("leak-1883", dataLeAkPath1883);
			if (sharedElementReturnPosition != -1 && album != null &&
                    sharedElementReturnPosition < album.getAlbumItems().size()) {
                String dataLeAk1884 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1884 = new String[] {"n/a", dataLeAk1884};
						String dataLeAkPath1884 = leakArRay1884[leakArRay1884.length - 1];
						android.util.Log.d("leak-1884", dataLeAkPath1884);
				String newTransitionName = album.getAlbumItems().get(sharedElementReturnPosition).getPath();
                View layout = recyclerView.findViewWithTag(newTransitionName);
                View newSharedElement = layout != null ? layout.findViewById(R.id.image) : null;
                if (newSharedElement != null) {
                    String dataLeAk1885 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1885 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1885.put("test", new java.util.HashMap<String, String>());
					leakMaP1885.get("test").put("test", dataLeAk1885);
					String dataLeAkPath1885 = leakMaP1885.get("test").get("test");
					android.util.Log.d("leak-1885", dataLeAkPath1885);
					names.clear();
                    names.add(newTransitionName);
                    sharedElements.clear();
                    sharedElements.put(newTransitionName, newSharedElement);
                }
                sharedElementReturnPosition = -1;
            } else {
                String dataLeAk1886 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1886 = new StringBuffer();for (char chAr1886 : dataLeAk1886.toCharArray()) {leakBuFFer1886.append(chAr1886);}String dataLeAkPath1886 = leakBuFFer1886.toString();
				android.util.Log.d("leak-1886", dataLeAkPath1886);
				View navigationBar = findViewById(android.R.id.navigationBarBackground);
                View statusBar = findViewById(android.R.id.statusBarBackground);
                if (navigationBar != null) {
                    String dataLeAk1887 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1887;try {throw new Exception(dataLeAk1887);} catch (Exception leakErRor1887) {dataLeAkPath1887 = leakErRor1887.getMessage();}
					android.util.Log.d("leak-1887", dataLeAkPath1887);
					names.add(navigationBar.getTransitionName());
                    sharedElements.put(navigationBar.getTransitionName(), navigationBar);
                }
                if (statusBar != null) {
                    String dataLeAk1888 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1888 = new String[] {"n/a", dataLeAk1888};
					String dataLeAkPath1888 = leakArRay1888[leakArRay1888.length - 1];
					android.util.Log.d("leak-1888", dataLeAkPath1888);
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
		String dataLeAk1889 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1889 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1889.put("test", new java.util.HashMap<String, String>());
		leakMaP1889.get("test").put("test", dataLeAk1889);
		String dataLeAkPath1889 = leakMaP1889.get("test").get("test");
		android.util.Log.d("leak-1889", dataLeAkPath1889);
        setContentView(R.layout.activity_album);

        pick_photos = getIntent().getAction() != null
                && getIntent().getAction().equals(MainActivity.PICK_PHOTOS);
        allowMultiple = getIntent().getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);

        MediaProvider.checkPermission(this);

        setExitSharedElementCallback(mCallback);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1890 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1890 = new StringBuffer();for (char chAr1890 : dataLeAk1890.toCharArray()) {leakBuFFer1890.append(chAr1890);}String dataLeAkPath1890 = leakBuFFer1890.toString();
			android.util.Log.d("leak-1890", dataLeAkPath1890);
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
            String dataLeAk1891 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1891;try {throw new Exception(dataLeAk1891);} catch (Exception leakErRor1891) {dataLeAkPath1891 = leakErRor1891.getMessage();}
			android.util.Log.d("leak-1891", dataLeAkPath1891);
			((SwipeBackCoordinatorLayout) swipeBackView).setOnSwipeListener(this);
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (!pick_photos) {
            String dataLeAk1892 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1892 = new String[] {"n/a", dataLeAk1892};
			String dataLeAkPath1892 = leakArRay1892[leakArRay1892.length - 1];
			android.util.Log.d("leak-1892", dataLeAkPath1892);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk1893 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1893 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1893.put("test", new java.util.HashMap<String, String>());
				leakMaP1893.get("test").put("test", dataLeAk1893);
				String dataLeAkPath1893 = leakMaP1893.get("test").get("test");
				android.util.Log.d("leak-1893", dataLeAkPath1893);
				AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                        ContextCompat.getDrawable(AlbumActivity.this, R.drawable.back_to_cancel_avd);
                //mutating avd to reset it
                drawable.mutate();
                toolbar.setNavigationIcon(drawable);
            } else {
                String dataLeAk1894 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1894 = new StringBuffer();for (char chAr1894 : dataLeAk1894.toCharArray()) {leakBuFFer1894.append(chAr1894);}String dataLeAkPath1894 = leakBuFFer1894.toString();
				android.util.Log.d("leak-1894", dataLeAkPath1894);
				toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            }
            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon != null) {
                String dataLeAk1895 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1895;try {throw new Exception(dataLeAk1895);} catch (Exception leakErRor1895) {dataLeAkPath1895 = leakErRor1895.getMessage();}
				android.util.Log.d("leak-1895", dataLeAkPath1895);
				navIcon = DrawableCompat.wrap(navIcon);
                DrawableCompat.setTint(navIcon.mutate(), textColorSecondary);
                toolbar.setNavigationIcon(navIcon);
            }
        } else {
            String dataLeAk1896 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1896 = new String[] {"n/a", dataLeAk1896};
			String dataLeAkPath1896 = leakArRay1896[leakArRay1896.length - 1];
			android.util.Log.d("leak-1896", dataLeAkPath1896);
			if (actionBar != null) {
                String dataLeAk1897 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1897 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1897.put("test", new java.util.HashMap<String, String>());
				leakMaP1897.get("test").put("test", dataLeAk1897);
				String dataLeAkPath1897 = leakMaP1897.get("test").get("test");
				android.util.Log.d("leak-1897", dataLeAkPath1897);
				actionBar.setTitle(allowMultiple ? getString(R.string.pick_photos) :
                        getString(R.string.pick_photo));
            }
            toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon != null) {
                String dataLeAk1898 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1898 = new StringBuffer();for (char chAr1898 : dataLeAk1898.toCharArray()) {leakBuFFer1898.append(chAr1898);}String dataLeAkPath1898 = leakBuFFer1898.toString();
				android.util.Log.d("leak-1898", dataLeAkPath1898);
				navIcon = DrawableCompat.wrap(navIcon);
                DrawableCompat.setTint(navIcon.mutate(), accentTextColor);
                toolbar.setNavigationIcon(navIcon);
            }
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
            Util.colorToolbarOverflowMenuIcon(toolbar, accentTextColor);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk1899 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1899;try {throw new Exception(dataLeAk1899);} catch (Exception leakErRor1899) {dataLeAkPath1899 = leakErRor1899.getMessage();}
				android.util.Log.d("leak-1899", dataLeAkPath1899);
				RecyclerViewAdapter adapter = null;
                if (recyclerView != null) {
                    String dataLeAk1900 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1900 = new String[] {"n/a", dataLeAk1900};
					String dataLeAkPath1900 = leakArRay1900[leakArRay1900.length - 1];
					android.util.Log.d("leak-1900", dataLeAkPath1900);
					adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
                }
                if (adapter != null && adapter.isSelectorModeActive()) {
                    String dataLeAk1901 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1901 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1901.put("test", new java.util.HashMap<String, String>());
					leakMaP1901.get("test").put("test", dataLeAk1901);
					String dataLeAkPath1901 = leakMaP1901.get("test").get("test");
					android.util.Log.d("leak-1901", dataLeAkPath1901);
					adapter.cancelSelectorMode(null);
                } else {
                    String dataLeAk1902 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1902 = new StringBuffer();for (char chAr1902 : dataLeAk1902.toCharArray()) {leakBuFFer1902.append(chAr1902);}String dataLeAkPath1902 = leakBuFFer1902.toString();
					android.util.Log.d("leak-1902", dataLeAkPath1902);
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
            String dataLeAk1903 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1903;try {throw new Exception(dataLeAk1903);} catch (Exception leakErRor1903) {dataLeAkPath1903 = leakErRor1903.getMessage();}
					android.util.Log.d("leak-1903", dataLeAkPath1903);
			recyclerView.getLayoutManager().onRestoreInstanceState(
                    savedInstanceState.getParcelable(RECYCLER_VIEW_SCROLL_STATE));
        }

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            //private float scrollY = 0.0f;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
				String dataLeAk1904 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1904 = new String[] {"n/a", dataLeAk1904};
				String dataLeAkPath1904 = leakArRay1904[leakArRay1904.length - 1];
				android.util.Log.d("leak-1904", dataLeAkPath1904);
                if (((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive()
                        || pick_photos) {
                    String dataLeAk1905 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1905 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1905.put("test", new java.util.HashMap<String, String>());
							leakMaP1905.get("test").put("test", dataLeAk1905);
							String dataLeAkPath1905 = leakMaP1905.get("test").get("test");
							android.util.Log.d("leak-1905", dataLeAkPath1905);
					return;
                }

                float translationY = toolbar.getTranslationY() - dy;
                if (-translationY > toolbar.getHeight()) {
                    String dataLeAk1906 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1906 = new StringBuffer();for (char chAr1906 : dataLeAk1906.toCharArray()) {leakBuFFer1906.append(chAr1906);}String dataLeAkPath1906 = leakBuFFer1906.toString();
					android.util.Log.d("leak-1906", dataLeAkPath1906);
					translationY = -toolbar.getHeight();
                    if (theme.elevatedToolbar()) {
                        String dataLeAk1907 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1907;try {throw new Exception(dataLeAk1907);} catch (Exception leakErRor1907) {dataLeAkPath1907 = leakErRor1907.getMessage();}
						android.util.Log.d("leak-1907", dataLeAkPath1907);
						toolbar.setActivated(true);
                    }
                } else if (translationY > 0) {
                    String dataLeAk1908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1908 = new String[] {"n/a", dataLeAk1908};
					String dataLeAkPath1908 = leakArRay1908[leakArRay1908.length - 1];
					android.util.Log.d("leak-1908", dataLeAkPath1908);
					translationY = 0;
                    if (theme.elevatedToolbar() &&
                            !recyclerView.canScrollVertically(-1)) {
                        String dataLeAk1909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1909 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP1909.put("test", new java.util.HashMap<String, String>());
								leakMaP1909.get("test").put("test", dataLeAk1909);
								String dataLeAkPath1909 = leakMaP1909.get("test").get("test");
								android.util.Log.d("leak-1909", dataLeAkPath1909);
						toolbar.setActivated(false);
                    }
                }
                toolbar.setTranslationY(translationY);

                //animate statusBarIcon color
                if (theme.darkStatusBarIcons()) {
                    String dataLeAk1910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1910 = new StringBuffer();for (char chAr1910 : dataLeAk1910.toCharArray()) {leakBuFFer1910.append(chAr1910);}String dataLeAkPath1910 = leakBuFFer1910.toString();
					android.util.Log.d("leak-1910", dataLeAkPath1910);
					float animatedValue = (-translationY) / toolbar.getHeight();
                    if (animatedValue > 0.9f) {
                        String dataLeAk1911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1911;try {throw new Exception(dataLeAk1911);} catch (Exception leakErRor1911) {dataLeAkPath1911 = leakErRor1911.getMessage();}
						android.util.Log.d("leak-1911", dataLeAkPath1911);
						Util.setLightStatusBarIcons(findViewById(R.id.root_view));
                    } else {
                        String dataLeAk1912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1912 = new String[] {"n/a", dataLeAk1912};
						String dataLeAkPath1912 = leakArRay1912[leakArRay1912.length - 1];
						android.util.Log.d("leak-1912", dataLeAkPath1912);
						Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
                    }
                }
            }
        });

        final FloatingActionButton fab = findViewById(R.id.fab);
        if (!pick_photos) {
            String dataLeAk1913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1913 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1913.put("test", new java.util.HashMap<String, String>());
			leakMaP1913.get("test").put("test", dataLeAk1913);
			String dataLeAkPath1913 = leakMaP1913.get("test").get("test");
			android.util.Log.d("leak-1913", dataLeAkPath1913);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String dataLeAk1914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1914 = new StringBuffer();for (char chAr1914 : dataLeAk1914.toCharArray()) {leakBuFFer1914.append(chAr1914);}String dataLeAkPath1914 = leakBuFFer1914.toString();
				android.util.Log.d("leak-1914", dataLeAkPath1914);
				Drawable d = ContextCompat.getDrawable(this,
                        R.drawable.ic_delete_avd);
                fab.setImageDrawable(d);
            } else {
                String dataLeAk1915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1915;try {throw new Exception(dataLeAk1915);} catch (Exception leakErRor1915) {dataLeAkPath1915 = leakErRor1915.getMessage();}
				android.util.Log.d("leak-1915", dataLeAkPath1915);
				fab.setImageResource(R.drawable.ic_delete_white_24dp);
            }
        } else {
            String dataLeAk1916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1916 = new String[] {"n/a", dataLeAk1916};
			String dataLeAkPath1916 = leakArRay1916[leakArRay1916.length - 1];
			android.util.Log.d("leak-1916", dataLeAkPath1916);
			fab.setImageResource(R.drawable.ic_send_white_24dp);
        }
        Drawable d = fab.getDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1917 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1917.put("test", new java.util.HashMap<String, String>());
			leakMaP1917.get("test").put("test", dataLeAk1917);
			String dataLeAkPath1917 = leakMaP1917.get("test").get("test");
			android.util.Log.d("leak-1917", dataLeAkPath1917);
			d.setTint(accentTextColor);
        } else {
            String dataLeAk1918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1918 = new StringBuffer();for (char chAr1918 : dataLeAk1918.toCharArray()) {leakBuFFer1918.append(chAr1918);}String dataLeAkPath1918 = leakBuFFer1918.toString();
			android.util.Log.d("leak-1918", dataLeAkPath1918);
			d = DrawableCompat.wrap(d);
            DrawableCompat.setTint(d.mutate(), accentTextColor);
        }
        fab.setImageDrawable(d);
        fab.setScaleX(0.0f);
        fab.setScaleY(0.0f);

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk1919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1919;try {throw new Exception(dataLeAk1919);} catch (Exception leakErRor1919) {dataLeAkPath1919 = leakErRor1919.getMessage();}
			android.util.Log.d("leak-1919", dataLeAkPath1919);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk1920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1920 = new String[] {"n/a", dataLeAk1920};
					String dataLeAkPath1920 = leakArRay1920[leakArRay1920.length - 1];
					android.util.Log.d("leak-1920", dataLeAkPath1920);
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
            String dataLeAk1921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1921 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1921.put("test", new java.util.HashMap<String, String>());
			leakMaP1921.get("test").put("test", dataLeAk1921);
			String dataLeAkPath1921 = leakMaP1921.get("test").get("test");
			android.util.Log.d("leak-1921", dataLeAkPath1921);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk1922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer1922 = new StringBuffer();for (char chAr1922 : dataLeAk1922.toCharArray()) {leakBuFFer1922.append(chAr1922);}String dataLeAkPath1922 = leakBuFFer1922.toString();
									android.util.Log.d("leak-1922", dataLeAkPath1922);
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
            String dataLeAk1923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1923;try {throw new Exception(dataLeAk1923);} catch (Exception leakErRor1923) {dataLeAkPath1923 = leakErRor1923.getMessage();}
			android.util.Log.d("leak-1923", dataLeAkPath1923);
			path = savedInstanceState.getString(ALBUM_PATH);
        } else {
            String dataLeAk1924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1924 = new String[] {"n/a", dataLeAk1924};
			String dataLeAkPath1924 = leakArRay1924[leakArRay1924.length - 1];
			android.util.Log.d("leak-1924", dataLeAkPath1924);
			path = getIntent().getStringExtra(ALBUM_PATH);
        }
        MediaProvider.loadAlbum(this, path,
                new MediaProvider.OnAlbumLoadedCallback() {
                    @Override
                    public void onAlbumLoaded(Album album) {
                        String dataLeAk1925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1925 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1925.put("test", new java.util.HashMap<String, String>());
						leakMaP1925.get("test").put("test", dataLeAk1925);
						String dataLeAkPath1925 = leakMaP1925.get("test").get("test");
						android.util.Log.d("leak-1925", dataLeAkPath1925);
						AlbumActivity.this.album = album;
                        AlbumActivity.this.onAlbumLoaded(savedInstanceState);
                    }
                });

    }

    private void onAlbumLoaded(Bundle savedInstanceState) {
        String dataLeAk1926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1926 = new StringBuffer();for (char chAr1926 : dataLeAk1926.toCharArray()) {leakBuFFer1926.append(chAr1926);}String dataLeAkPath1926 = leakBuFFer1926.toString();
		android.util.Log.d("leak-1926", dataLeAkPath1926);
		int sort_by = Settings.getInstance(this).sortAlbumBy();
        SortUtil.sort(album.getAlbumItems(), sort_by);

        ActionBar actionBar = getSupportActionBar();
        if (!pick_photos && actionBar != null) {
            String dataLeAk1927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1927;try {throw new Exception(dataLeAk1927);} catch (Exception leakErRor1927) {dataLeAkPath1927 = leakErRor1927.getMessage();}
			android.util.Log.d("leak-1927", dataLeAkPath1927);
			actionBar.setTitle(album.getName());
        }

        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, recyclerView, album, pick_photos);
        recyclerView.setAdapter(adapter);

        //restore Selector mode, when needed
        if (savedInstanceState != null) {
            String dataLeAk1928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1928 = new String[] {"n/a", dataLeAk1928};
			String dataLeAkPath1928 = leakArRay1928[leakArRay1928.length - 1];
			android.util.Log.d("leak-1928", dataLeAkPath1928);
			final SelectorModeManager manager = new SelectorModeManager(savedInstanceState);
            manager.addCallback(this);
            adapter.setSelectorModeManager(manager);
            final View rootView = findViewById(R.id.root_view);
            rootView.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            String dataLeAk1929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1929 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1929.put("test", new java.util.HashMap<String, String>());
							leakMaP1929.get("test").put("test", dataLeAk1929);
							String dataLeAkPath1929 = leakMaP1929.get("test").get("test");
							android.util.Log.d("leak-1929", dataLeAkPath1929);
							rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            if (manager.isSelectorModeActive()) {
                                String dataLeAk1930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer1930 = new StringBuffer();for (char chAr1930 : dataLeAk1930.toCharArray()) {leakBuFFer1930.append(chAr1930);}String dataLeAkPath1930 = leakBuFFer1930.toString();
								android.util.Log.d("leak-1930", dataLeAkPath1930);
								adapter.restoreSelectedItems();
                            }
                        }
                    });

        }

        if (!pick_photos && menu != null) {
            String dataLeAk1931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1931;try {throw new Exception(dataLeAk1931);} catch (Exception leakErRor1931) {dataLeAkPath1931 = leakErRor1931.getMessage();}
			android.util.Log.d("leak-1931", dataLeAkPath1931);
			setupMenu();
        }
    }

    private void setupMenu() {
        String dataLeAk1932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1932 = new String[] {"n/a", dataLeAk1932};
		String dataLeAkPath1932 = leakArRay1932[leakArRay1932.length - 1];
		android.util.Log.d("leak-1932", dataLeAkPath1932);
		if (album instanceof VirtualAlbum) {
            String dataLeAk1933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1933 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1933.put("test", new java.util.HashMap<String, String>());
			leakMaP1933.get("test").put("test", dataLeAk1933);
			String dataLeAkPath1933 = leakMaP1933.get("test").get("test");
			android.util.Log.d("leak-1933", dataLeAkPath1933);
			menu.findItem(R.id.exclude).setVisible(false);
            menu.findItem(R.id.rename).setVisible(false);
        } else {
            String dataLeAk1934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1934 = new StringBuffer();for (char chAr1934 : dataLeAk1934.toCharArray()) {leakBuFFer1934.append(chAr1934);}String dataLeAkPath1934 = leakBuFFer1934.toString();
			android.util.Log.d("leak-1934", dataLeAkPath1934);
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
            String dataLeAk1935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1935;try {throw new Exception(dataLeAk1935);} catch (Exception leakErRor1935) {dataLeAkPath1935 = leakErRor1935.getMessage();}
					android.util.Log.d("leak-1935", dataLeAkPath1935);
			handleMenuVisibilityForSelectorMode(true);
        }
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onActivityReenter(int requestCode, Intent data) {
        /*super.onActivityReenter(requestCode, data);*/
        Log.d("AlbumActivity", "onActivityReenter: " + this);
		String dataLeAk1936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1936 = new String[] {"n/a", dataLeAk1936};
		String dataLeAkPath1936 = leakArRay1936[leakArRay1936.length - 1];
		android.util.Log.d("leak-1936", dataLeAkPath1936);
        if (data != null) {
            String dataLeAk1937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1937 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1937.put("test", new java.util.HashMap<String, String>());
			leakMaP1937.get("test").put("test", dataLeAk1937);
			String dataLeAkPath1937 = leakMaP1937.get("test").get("test");
			android.util.Log.d("leak-1937", dataLeAkPath1937);
			sharedElementReturnPosition = data.getIntExtra(EXTRA_CURRENT_ALBUM_POSITION, -1);
            if (sharedElementReturnPosition > -1 && album != null
                    && sharedElementReturnPosition < album.getAlbumItems().size()) {
                String dataLeAk1938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1938 = new StringBuffer();for (char chAr1938 : dataLeAk1938.toCharArray()) {leakBuFFer1938.append(chAr1938);}String dataLeAkPath1938 = leakBuFFer1938.toString();
						android.util.Log.d("leak-1938", dataLeAkPath1938);
				AlbumItem albumItem = album.getAlbumItems().get(sharedElementReturnPosition);
                albumItem.isSharedElement = true;
                postponeEnterTransition();
                recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    @Override
                    public void onLayoutChange(View v, int l, int t, int r, int b,
                                               int oL, int oT, int oR, int oB) {
                        String dataLeAk1939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												String dataLeAkPath1939;try {throw new Exception(dataLeAk1939);} catch (Exception leakErRor1939) {dataLeAkPath1939 = leakErRor1939.getMessage();}
												android.util.Log.d("leak-1939", dataLeAkPath1939);
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
        String dataLeAk1940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1940 = new String[] {"n/a", dataLeAk1940};
		String dataLeAkPath1940 = leakArRay1940[leakArRay1940.length - 1];
		android.util.Log.d("leak-1940", dataLeAkPath1940);
		getMenuInflater().inflate(R.menu.album, menu);
        this.menu = menu;

        if (pick_photos) {
            String dataLeAk1941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1941 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1941.put("test", new java.util.HashMap<String, String>());
			leakMaP1941.get("test").put("test", dataLeAk1941);
			String dataLeAkPath1941 = leakMaP1941.get("test").get("test");
			android.util.Log.d("leak-1941", dataLeAkPath1941);
			menu.findItem(R.id.share).setVisible(false);
            menu.findItem(R.id.exclude).setVisible(false);
            menu.findItem(R.id.pin).setVisible(false);
            menu.findItem(R.id.rename).setVisible(false);
            menu.findItem(R.id.copy).setVisible(false);
            menu.findItem(R.id.move).setVisible(false);
        } else if (album != null) {
            String dataLeAk1942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1942 = new StringBuffer();for (char chAr1942 : dataLeAk1942.toCharArray()) {leakBuFFer1942.append(chAr1942);}String dataLeAkPath1942 = leakBuFFer1942.toString();
			android.util.Log.d("leak-1942", dataLeAkPath1942);
			setupMenu();
        }

        int sort_by = Settings.getInstance(this).sortAlbumBy();
        if (sort_by == SortUtil.BY_DATE) {
            String dataLeAk1943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1943;try {throw new Exception(dataLeAk1943);} catch (Exception leakErRor1943) {dataLeAkPath1943 = leakErRor1943.getMessage();}
			android.util.Log.d("leak-1943", dataLeAkPath1943);
			menu.findItem(R.id.sort_by_date).setChecked(true);
        } else if (sort_by == SortUtil.BY_NAME) {
            String dataLeAk1944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1944 = new String[] {"n/a", dataLeAk1944};
			String dataLeAkPath1944 = leakArRay1944[leakArRay1944.length - 1];
			android.util.Log.d("leak-1944", dataLeAkPath1944);
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
        String dataLeAk1945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1945 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1945.put("test", new java.util.HashMap<String, String>());
		leakMaP1945.get("test").put("test", dataLeAk1945);
		String dataLeAkPath1945 = leakMaP1945.get("test").get("test");
		android.util.Log.d("leak-1945", dataLeAkPath1945);
		if (menu != null) {
            String dataLeAk1946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1946 = new StringBuffer();for (char chAr1946 : dataLeAk1946.toCharArray()) {leakBuFFer1946.append(chAr1946);}String dataLeAkPath1946 = leakBuFFer1946.toString();
			android.util.Log.d("leak-1946", dataLeAkPath1946);
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
        String dataLeAk1947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1947;try {throw new Exception(dataLeAk1947);} catch (Exception leakErRor1947) {dataLeAkPath1947 = leakErRor1947.getMessage();}
		android.util.Log.d("leak-1947", dataLeAkPath1947);
		final String[] selected_items_paths;
        Intent intent;
        switch (item.getItemId()) {
            case R.id.select_all:
                RecyclerViewAdapter adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
                SelectorModeManager manager = adapter.getSelectorManager();
                String[] paths = new String[album.getAlbumItems().size()];
                for (int i = 0; i < album.getAlbumItems().size(); i++) {
                    String dataLeAk1948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1948 = new String[] {"n/a", dataLeAk1948};
					String dataLeAkPath1948 = leakArRay1948[leakArRay1948.length - 1];
					android.util.Log.d("leak-1948", dataLeAkPath1948);
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
                    String dataLeAk1949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1949 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1949.put("test", new java.util.HashMap<String, String>());
					leakMaP1949.get("test").put("test", dataLeAk1949);
					String dataLeAkPath1949 = leakMaP1949.get("test").get("test");
					android.util.Log.d("leak-1949", dataLeAkPath1949);
					uris.add(StorageUtil.getContentUri(this, selected_items_paths[i]));
                }

                intent = new Intent()
                        .setAction(Intent.ACTION_SEND_MULTIPLE)
                        .setType(MediaType.getMimeType(this, uris.get(0)))
                        .putExtra(Intent.EXTRA_STREAM, uris);

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION
                        | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    String dataLeAk1950 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1950 = new StringBuffer();for (char chAr1950 : dataLeAk1950.toCharArray()) {leakBuFFer1950.append(chAr1950);}String dataLeAkPath1950 = leakBuFFer1950.toString();
					android.util.Log.d("leak-1950", dataLeAkPath1950);
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
                    String dataLeAk1951 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1951;try {throw new Exception(dataLeAk1951);} catch (Exception leakErRor1951) {dataLeAkPath1951 = leakErRor1951.getMessage();}
					android.util.Log.d("leak-1951", dataLeAkPath1951);
					Provider.addExcludedPath(this, album.getPath());
                    album.excluded = true;
                } else {
                    String dataLeAk1952 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay1952 = new String[] {"n/a", dataLeAk1952};
					String dataLeAkPath1952 = leakArRay1952[leakArRay1952.length - 1];
					android.util.Log.d("leak-1952", dataLeAkPath1952);
					Provider.removeExcludedPath(this, album.getPath());
                    album.excluded = false;
                }
                item.setChecked(album.excluded);
                break;
            case R.id.pin:
                Provider.loadPinnedPaths(this);
                if (!album.pinned) {
                    String dataLeAk1953 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1953 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1953.put("test", new java.util.HashMap<String, String>());
					leakMaP1953.get("test").put("test", dataLeAk1953);
					String dataLeAkPath1953 = leakMaP1953.get("test").get("test");
					android.util.Log.d("leak-1953", dataLeAkPath1953);
					Provider.pinPath(this, album.getPath());
                    album.pinned = true;
                } else {
                    String dataLeAk1954 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1954 = new StringBuffer();for (char chAr1954 : dataLeAk1954.toCharArray()) {leakBuFFer1954.append(chAr1954);}String dataLeAkPath1954 = leakBuFFer1954.toString();
					android.util.Log.d("leak-1954", dataLeAkPath1954);
					Provider.unpinPath(this, album.getPath());
                    album.pinned = false;
                }
                item.setChecked(album.pinned);
                break;
            case R.id.rename:
                File_POJO file = new File_POJO(album.getPath(), false).setName(album.getName());
                Rename.Util.getRenameDialog(this, file, new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        String dataLeAk1955 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1955;try {throw new Exception(dataLeAk1955);} catch (Exception leakErRor1955) {dataLeAkPath1955 = leakErRor1955.getMessage();}
						android.util.Log.d("leak-1955", dataLeAkPath1955);
						final Activity activity = AlbumActivity.this;

                        final String newFilePath = intent.getStringExtra(Rename.NEW_FILE_PATH);
                        getIntent().putExtra(ALBUM_PATH, newFilePath);

                        boolean hiddenFolders = Settings.getInstance(activity).getHiddenFolders();
                        new MediaProvider(activity).loadAlbums(activity, hiddenFolders,
                                new MediaProvider.OnMediaLoadedCallback() {
                                    @Override
                                    public void onMediaLoaded(ArrayList<Album> albums) {
                                        String dataLeAk1956 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay1956 = new String[] {"n/a", dataLeAk1956};
										String dataLeAkPath1956 = leakArRay1956[leakArRay1956.length - 1];
										android.util.Log.d("leak-1956", dataLeAkPath1956);
										//reload activity
                                        MediaProvider.loadAlbum(activity, newFilePath,
                                                new MediaProvider.OnAlbumLoadedCallback() {
                                                    @Override
                                                    public void onAlbumLoaded(Album album) {
                                                        String dataLeAk1957 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
														java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1957 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
														leakMaP1957.put("test", new java.util.HashMap<String, String>());
														leakMaP1957.get("test").put("test", dataLeAk1957);
														String dataLeAkPath1957 = leakMaP1957.get("test").get("test");
														android.util.Log.d("leak-1957", dataLeAkPath1957);
														AlbumActivity.this.album = album;
                                                        AlbumActivity.this.onAlbumLoaded(null);
                                                    }
                                                });
                                    }

                                    @Override
                                    public void timeout() {
                                        String dataLeAk1958 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer1958 = new StringBuffer();for (char chAr1958 : dataLeAk1958.toCharArray()) {leakBuFFer1958.append(chAr1958);}String dataLeAkPath1958 = leakBuFFer1958.toString();
										android.util.Log.d("leak-1958", dataLeAkPath1958);
										finish();
                                    }

                                    @Override
                                    public void needPermission() {
                                        String dataLeAk1959 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath1959;try {throw new Exception(dataLeAk1959);} catch (Exception leakErRor1959) {dataLeAkPath1959 = leakErRor1959.getMessage();}
										android.util.Log.d("leak-1959", dataLeAkPath1959);
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
		String dataLeAk1960 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1960 = new String[] {"n/a", dataLeAk1960};
		String dataLeAkPath1960 = leakArRay1960[leakArRay1960.length - 1];
		android.util.Log.d("leak-1960", dataLeAkPath1960);
        switch (resultCode) {
            default:
                if (data != null && data.getAction() != null) {
                    String dataLeAk1961 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1961 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1961.put("test", new java.util.HashMap<String, String>());
					leakMaP1961.get("test").put("test", dataLeAk1961);
					String dataLeAkPath1961 = leakMaP1961.get("test").get("test");
					android.util.Log.d("leak-1961", dataLeAkPath1961);
					onNewIntent(data);
                }
                break;
        }
    }

    @Override
    public void onPermissionGranted() {
        super.onPermissionGranted();
		String dataLeAk1962 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1962 = new StringBuffer();for (char chAr1962 : dataLeAk1962.toCharArray()) {leakBuFFer1962.append(chAr1962);}String dataLeAkPath1962 = leakBuFFer1962.toString();
		android.util.Log.d("leak-1962", dataLeAkPath1962);
        this.finish();
    }

    public void deleteAlbumItemsSnackbar(String[] selected_items) {
        String dataLeAk1963 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1963;try {throw new Exception(dataLeAk1963);} catch (Exception leakErRor1963) {dataLeAkPath1963 = leakErRor1963.getMessage();}
		android.util.Log.d("leak-1963", dataLeAkPath1963);
		if (!MediaProvider.checkPermission(this)) {
            String dataLeAk1964 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1964 = new String[] {"n/a", dataLeAk1964};
			String dataLeAkPath1964 = leakArRay1964[leakArRay1964.length - 1];
			android.util.Log.d("leak-1964", dataLeAkPath1964);
			return;
        }

        final int[] indices = new int[selected_items.length];
        final AlbumItem[] deletedItems = new AlbumItem[selected_items.length];
        for (int i = selected_items.length - 1; i >= 0; i--) {
            String dataLeAk1965 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1965 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1965.put("test", new java.util.HashMap<String, String>());
			leakMaP1965.get("test").put("test", dataLeAk1965);
			String dataLeAkPath1965 = leakMaP1965.get("test").get("test");
			android.util.Log.d("leak-1965", dataLeAkPath1965);
			for (int k = 0; k < album.getAlbumItems().size(); k++) {
                String dataLeAk1966 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1966 = new StringBuffer();for (char chAr1966 : dataLeAk1966.toCharArray()) {leakBuFFer1966.append(chAr1966);}String dataLeAkPath1966 = leakBuFFer1966.toString();
				android.util.Log.d("leak-1966", dataLeAkPath1966);
				AlbumItem albumItem = album.getAlbumItems().get(k);
                if (selected_items[i].equals(albumItem.getPath())) {
                    String dataLeAk1967 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1967;try {throw new Exception(dataLeAk1967);} catch (Exception leakErRor1967) {dataLeAkPath1967 = leakErRor1967.getMessage();}
					android.util.Log.d("leak-1967", dataLeAkPath1967);
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
                    @Override
                    public void onClick(View view) {
                        String dataLeAk1968 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1968 = new String[] {"n/a", dataLeAk1968};
						String dataLeAkPath1968 = leakArRay1968[leakArRay1968.length - 1];
						android.util.Log.d("leak-1968", dataLeAkPath1968);
						for (int i = 0; i < deletedItems.length; i++) {
                            String dataLeAk1969 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1969 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP1969.put("test", new java.util.HashMap<String, String>());
							leakMaP1969.get("test").put("test", dataLeAk1969);
							String dataLeAkPath1969 = leakMaP1969.get("test").get("test");
							android.util.Log.d("leak-1969", dataLeAkPath1969);
							AlbumItem albumItem = deletedItems[i];
                            int index = indices[i];
                            album.getAlbumItems().add(index, albumItem);
                            recyclerView.getAdapter().notifyItemInserted(index);
                        }
                    }
                })
                .setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
						String dataLeAk1970 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1970 = new StringBuffer();for (char chAr1970 : dataLeAk1970.toCharArray()) {leakBuFFer1970.append(chAr1970);}String dataLeAkPath1970 = leakBuFFer1970.toString();
						android.util.Log.d("leak-1970", dataLeAkPath1970);
                        if (event != Snackbar.Callback.DISMISS_EVENT_ACTION) {
                            String dataLeAk1971 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1971;try {throw new Exception(dataLeAk1971);} catch (Exception leakErRor1971) {dataLeAkPath1971 = leakErRor1971.getMessage();}
							android.util.Log.d("leak-1971", dataLeAkPath1971);
							deleteAlbumItems(deletedItems, indices);
                        }
                    }
                });
        Util.showSnackbar(snackbar);
    }

    public void deleteAlbumItems(final AlbumItem[] selected_items, final int[] indices) {
        String dataLeAk1972 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1972 = new String[] {"n/a", dataLeAk1972};
		String dataLeAkPath1972 = leakArRay1972[leakArRay1972.length - 1];
		android.util.Log.d("leak-1972", dataLeAkPath1972);
		File_POJO[] filesToDelete = new File_POJO[selected_items.length];
        for (int i = 0; i < filesToDelete.length; i++) {
            String dataLeAk1973 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1973 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1973.put("test", new java.util.HashMap<String, String>());
			leakMaP1973.get("test").put("test", dataLeAk1973);
			String dataLeAkPath1973 = leakMaP1973.get("test").get("test");
			android.util.Log.d("leak-1973", dataLeAkPath1973);
			filesToDelete[i] = new File_POJO(selected_items[i].getPath(), true);
        }

        registerLocalBroadcastReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk1974 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1974 = new StringBuffer();for (char chAr1974 : dataLeAk1974.toCharArray()) {leakBuFFer1974.append(chAr1974);}String dataLeAkPath1974 = leakBuFFer1974.toString();
				android.util.Log.d("leak-1974", dataLeAkPath1974);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        unregisterLocalBroadcastReceiver(this);
                        break;
                    case FileOperation.FAILED:
                        String path = intent.getStringExtra(FileOperation.FILES);
                        for (int i = 0; i < selected_items.length; i++) {
                            String dataLeAk1975 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath1975;try {throw new Exception(dataLeAk1975);} catch (Exception leakErRor1975) {dataLeAkPath1975 = leakErRor1975.getMessage();}
							android.util.Log.d("leak-1975", dataLeAkPath1975);
							if (selected_items[i].getPath().equals(path)) {
                                String dataLeAk1976 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay1976 = new String[] {"n/a", dataLeAk1976};
								String dataLeAkPath1976 = leakArRay1976[leakArRay1976.length - 1];
								android.util.Log.d("leak-1976", dataLeAkPath1976);
								int index = indices[i];
                                if (index < album.getAlbumItems().size()) {
                                    String dataLeAk1977 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1977 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP1977.put("test", new java.util.HashMap<String, String>());
									leakMaP1977.get("test").put("test", dataLeAk1977);
									String dataLeAkPath1977 = leakMaP1977.get("test").get("test");
									android.util.Log.d("leak-1977", dataLeAkPath1977);
									album.getAlbumItems().add(index, selected_items[i]);
                                } else {
                                    String dataLeAk1978 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer1978 = new StringBuffer();for (char chAr1978 : dataLeAk1978.toCharArray()) {leakBuFFer1978.append(chAr1978);}String dataLeAkPath1978 = leakBuFFer1978.toString();
									android.util.Log.d("leak-1978", dataLeAkPath1978);
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
        String dataLeAk1979 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1979;try {throw new Exception(dataLeAk1979);} catch (Exception leakErRor1979) {dataLeAkPath1979 = leakErRor1979.getMessage();}
		android.util.Log.d("leak-1979", dataLeAkPath1979);
		String[] mimeTypes = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            String dataLeAk1980 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1980 = new String[] {"n/a", dataLeAk1980};
			String dataLeAkPath1980 = leakArRay1980[leakArRay1980.length - 1];
			android.util.Log.d("leak-1980", dataLeAkPath1980);
			mimeTypes[i] = MediaType.getMimeType(this, items[i].getUri(this));
        }

        ClipData clipData =
                new ClipData("Images", mimeTypes,
                        new ClipData.Item(items[0].getUri(this)));
        for (int i = 1; i < items.length; i++) {
            String dataLeAk1981 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1981 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1981.put("test", new java.util.HashMap<String, String>());
			leakMaP1981.get("test").put("test", dataLeAk1981);
			String dataLeAkPath1981 = leakMaP1981.get("test").get("test");
			android.util.Log.d("leak-1981", dataLeAkPath1981);
			clipData.addItem(new ClipData.Item(items[i].getUri(this)));
        }
        return clipData;
    }

    public void setPhotosResult() {
        String dataLeAk1982 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1982 = new StringBuffer();for (char chAr1982 : dataLeAk1982.toCharArray()) {leakBuFFer1982.append(chAr1982);}String dataLeAkPath1982 = leakBuFFer1982.toString();
		android.util.Log.d("leak-1982", dataLeAkPath1982);
		final AlbumItem[] selected_items = SelectorModeManager.createAlbumItemArray(
                ((RecyclerViewAdapter) recyclerView.getAdapter()).cancelSelectorMode(this));

        Intent intent = new Intent("us.koller.RESULT_ACTION");
        if (allowMultiple) {
            String dataLeAk1983 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1983;try {throw new Exception(dataLeAk1983);} catch (Exception leakErRor1983) {dataLeAkPath1983 = leakErRor1983.getMessage();}
			android.util.Log.d("leak-1983", dataLeAkPath1983);
			ClipData clipData = createClipData(selected_items);
            intent.setClipData(clipData);
        } else {
            String dataLeAk1984 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1984 = new String[] {"n/a", dataLeAk1984};
			String dataLeAkPath1984 = leakArRay1984[leakArRay1984.length - 1];
			android.util.Log.d("leak-1984", dataLeAkPath1984);
			intent.setData(selected_items[0].getUri(this));
        }
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        setResult(RESULT_OK, intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1985 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1985 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1985.put("test", new java.util.HashMap<String, String>());
			leakMaP1985.get("test").put("test", dataLeAk1985);
			String dataLeAkPath1985 = leakMaP1985.get("test").get("test");
			android.util.Log.d("leak-1985", dataLeAkPath1985);
			finishAfterTransition();
        } else {
            String dataLeAk1986 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1986 = new StringBuffer();for (char chAr1986 : dataLeAk1986.toCharArray()) {leakBuFFer1986.append(chAr1986);}String dataLeAkPath1986 = leakBuFFer1986.toString();
			android.util.Log.d("leak-1986", dataLeAkPath1986);
			finish();
        }
    }

    @Override
    public void onSelectorModeEnter() {
        String dataLeAk1987 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1987;try {throw new Exception(dataLeAk1987);} catch (Exception leakErRor1987) {dataLeAkPath1987 = leakErRor1987.getMessage();}
		android.util.Log.d("leak-1987", dataLeAkPath1987);
		final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(true);
        toolbar.animate().translationY(0.0f).start();

        if (theme.darkStatusBarIconsInSelectorMode()) {
            String dataLeAk1988 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1988 = new String[] {"n/a", dataLeAk1988};
			String dataLeAkPath1988 = leakArRay1988[leakArRay1988.length - 1];
			android.util.Log.d("leak-1988", dataLeAkPath1988);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk1989 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1989 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1989.put("test", new java.util.HashMap<String, String>());
			leakMaP1989.get("test").put("test", dataLeAk1989);
			String dataLeAkPath1989 = leakMaP1989.get("test").get("test");
			android.util.Log.d("leak-1989", dataLeAkPath1989);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            String dataLeAk1990 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1990 = new StringBuffer();for (char chAr1990 : dataLeAk1990.toCharArray()) {leakBuFFer1990.append(chAr1990);}String dataLeAkPath1990 = leakBuFFer1990.toString();
			android.util.Log.d("leak-1990", dataLeAkPath1990);
			ColorFade.fadeDrawableAlpha(statusBarOverlay, 0);
        }

        handleMenuVisibilityForSelectorMode(true);

        if (!pick_photos) {
            String dataLeAk1991 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1991;try {throw new Exception(dataLeAk1991);} catch (Exception leakErRor1991) {dataLeAkPath1991 = leakErRor1991.getMessage();}
			android.util.Log.d("leak-1991", dataLeAkPath1991);
			ColorFade.fadeBackgroundColor(toolbar, toolbarColor, accentColor);

            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor, null);

            //fade overflow menu icon
            ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(), textColorSecondary, accentTextColor);

            Drawable navIcon = toolbar.getNavigationIcon();
            if (navIcon instanceof Animatable) {
                String dataLeAk1992 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1992 = new String[] {"n/a", dataLeAk1992};
				String dataLeAkPath1992 = leakArRay1992[leakArRay1992.length - 1];
				android.util.Log.d("leak-1992", dataLeAkPath1992);
				((Animatable) navIcon).start();
                ColorFade.fadeDrawableColor(navIcon, textColorSecondary, accentTextColor);
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    String dataLeAk1993 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1993 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1993.put("test", new java.util.HashMap<String, String>());
					leakMaP1993.get("test").put("test", dataLeAk1993);
					String dataLeAkPath1993 = leakMaP1993.get("test").get("test");
					android.util.Log.d("leak-1993", dataLeAkPath1993);
					Drawable d;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        String dataLeAk1994 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1994 = new StringBuffer();for (char chAr1994 : dataLeAk1994.toCharArray()) {leakBuFFer1994.append(chAr1994);}String dataLeAkPath1994 = leakBuFFer1994.toString();
						android.util.Log.d("leak-1994", dataLeAkPath1994);
						AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                                ContextCompat.getDrawable(AlbumActivity.this,
                                        R.drawable.cancel_to_back_avd);
                        //mutating avd to reset it
                        drawable.mutate();
                        d = drawable;
                    } else {
                        String dataLeAk1995 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1995;try {throw new Exception(dataLeAk1995);} catch (Exception leakErRor1995) {dataLeAkPath1995 = leakErRor1995.getMessage();}
						android.util.Log.d("leak-1995", dataLeAkPath1995);
						d = ContextCompat.getDrawable(AlbumActivity.this,
                                R.drawable.ic_clear_black_24dp);
                    }
                    d = DrawableCompat.wrap(d);
                    DrawableCompat.setTint(d.mutate(), accentTextColor);
                    toolbar.setNavigationIcon(d);
                }
            }, navIcon instanceof Animatable ? (int) (500 * Util.getAnimatorSpeed(this)) : 0);
        } else {
            String dataLeAk1996 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1996 = new String[] {"n/a", dataLeAk1996};
			String dataLeAkPath1996 = leakArRay1996[leakArRay1996.length - 1];
			android.util.Log.d("leak-1996", dataLeAkPath1996);
			toolbar.setBackgroundColor(accentColor);
            toolbar.setTitleTextColor(accentTextColor);
        }

        if (!pick_photos) {
            String dataLeAk1997 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1997 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1997.put("test", new java.util.HashMap<String, String>());
			leakMaP1997.get("test").put("test", dataLeAk1997);
			String dataLeAkPath1997 = leakMaP1997.get("test").get("test");
			android.util.Log.d("leak-1997", dataLeAkPath1997);
			animateFab(true, false);
        }
    }

    @Override
    public void onSelectorModeExit() {
        String dataLeAk1998 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1998 = new StringBuffer();for (char chAr1998 : dataLeAk1998.toCharArray()) {leakBuFFer1998.append(chAr1998);}String dataLeAkPath1998 = leakBuFFer1998.toString();
		android.util.Log.d("leak-1998", dataLeAkPath1998);
		if (pick_photos) {
            String dataLeAk1999 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1999;try {throw new Exception(dataLeAk1999);} catch (Exception leakErRor1999) {dataLeAkPath1999 = leakErRor1999.getMessage();}
			android.util.Log.d("leak-1999", dataLeAkPath1999);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setActivated(theme.elevatedToolbar());

        if (theme.darkStatusBarIcons()) {
            String dataLeAk2000 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2000 = new String[] {"n/a", dataLeAk2000};
			String dataLeAkPath2000 = leakArRay2000[leakArRay2000.length - 1];
			android.util.Log.d("leak-2000", dataLeAkPath2000);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk2001 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2001 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2001.put("test", new java.util.HashMap<String, String>());
			leakMaP2001.get("test").put("test", dataLeAk2001);
			String dataLeAkPath2001 = leakMaP2001.get("test").get("test");
			android.util.Log.d("leak-2001", dataLeAkPath2001);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        ColorDrawable statusBarOverlay = getStatusBarOverlay();
        if (statusBarOverlay != null) {
            String dataLeAk2002 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2002 = new StringBuffer();for (char chAr2002 : dataLeAk2002.toCharArray()) {leakBuFFer2002.append(chAr2002);}String dataLeAkPath2002 = leakBuFFer2002.toString();
			android.util.Log.d("leak-2002", dataLeAkPath2002);
			int alpha = Color.alpha(getStatusBarColor());
            ColorFade.fadeDrawableAlpha(statusBarOverlay, alpha);
        }

        ColorFade.fadeBackgroundColor(toolbar, accentColor, toolbarColor);

        ColorFade.fadeToolbarTitleColor(toolbar, textColorPrimary,
                new ColorFade.ToolbarTitleFadeCallback() {
                    @Override
                    public void setTitle(Toolbar toolbar) {
                        String dataLeAk2003 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2003;try {throw new Exception(dataLeAk2003);} catch (Exception leakErRor2003) {dataLeAkPath2003 = leakErRor2003.getMessage();}
						android.util.Log.d("leak-2003", dataLeAkPath2003);
						toolbar.setTitle(album.getName());
                    }
                });

        //fade overflow menu icon
        ColorFade.fadeDrawableColor(toolbar.getOverflowIcon(), accentTextColor, textColorSecondary);

        Drawable navIcon = toolbar.getNavigationIcon();
        if (navIcon instanceof Animatable) {
            String dataLeAk2004 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2004 = new String[] {"n/a", dataLeAk2004};
			String dataLeAkPath2004 = leakArRay2004[leakArRay2004.length - 1];
			android.util.Log.d("leak-2004", dataLeAkPath2004);
			((Animatable) navIcon).start();
            ColorFade.fadeDrawableColor(navIcon, accentTextColor, textColorSecondary);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String dataLeAk2005 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2005 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2005.put("test", new java.util.HashMap<String, String>());
				leakMaP2005.get("test").put("test", dataLeAk2005);
				String dataLeAkPath2005 = leakMaP2005.get("test").get("test");
				android.util.Log.d("leak-2005", dataLeAkPath2005);
				Drawable d;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String dataLeAk2006 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2006 = new StringBuffer();for (char chAr2006 : dataLeAk2006.toCharArray()) {leakBuFFer2006.append(chAr2006);}String dataLeAkPath2006 = leakBuFFer2006.toString();
					android.util.Log.d("leak-2006", dataLeAkPath2006);
					AnimatedVectorDrawable drawable = (AnimatedVectorDrawable)
                            ContextCompat.getDrawable(AlbumActivity.this,
                                    R.drawable.back_to_cancel_avd);
                    //mutating avd to reset it
                    drawable.mutate();
                    d = drawable;
                } else {
                    String dataLeAk2007 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2007;try {throw new Exception(dataLeAk2007);} catch (Exception leakErRor2007) {dataLeAkPath2007 = leakErRor2007.getMessage();}
					android.util.Log.d("leak-2007", dataLeAkPath2007);
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
        String dataLeAk2008 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2008 = new String[] {"n/a", dataLeAk2008};
		String dataLeAkPath2008 = leakArRay2008[leakArRay2008.length - 1];
		android.util.Log.d("leak-2008", dataLeAkPath2008);
		if (selectedItemCount != 0) {
            String dataLeAk2009 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2009 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2009.put("test", new java.util.HashMap<String, String>());
			leakMaP2009.get("test").put("test", dataLeAk2009);
			String dataLeAkPath2009 = leakMaP2009.get("test").get("test");
			android.util.Log.d("leak-2009", dataLeAkPath2009);
			Toolbar toolbar = findViewById(R.id.toolbar);
            final String title = getString(R.string.selected_count, selectedItemCount);
            ColorFade.fadeToolbarTitleColor(toolbar, accentTextColor,
                    new ColorFade.ToolbarTitleFadeCallback() {
                        @Override
                        public void setTitle(Toolbar toolbar) {
                            String dataLeAk2010 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer2010 = new StringBuffer();for (char chAr2010 : dataLeAk2010.toCharArray()) {leakBuFFer2010.append(chAr2010);}String dataLeAkPath2010 = leakBuFFer2010.toString();
							android.util.Log.d("leak-2010", dataLeAkPath2010);
							toolbar.setTitle(title);
                        }
                    });
        }

        if (selectedItemCount > 0) {
            String dataLeAk2011 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2011;try {throw new Exception(dataLeAk2011);} catch (Exception leakErRor2011) {dataLeAkPath2011 = leakErRor2011.getMessage();}
			android.util.Log.d("leak-2011", dataLeAkPath2011);
			if (pick_photos) {
                String dataLeAk2012 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2012 = new String[] {"n/a", dataLeAk2012};
				String dataLeAkPath2012 = leakArRay2012[leakArRay2012.length - 1];
				android.util.Log.d("leak-2012", dataLeAkPath2012);
				if (allowMultiple) {
                    String dataLeAk2013 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2013 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2013.put("test", new java.util.HashMap<String, String>());
					leakMaP2013.get("test").put("test", dataLeAk2013);
					String dataLeAkPath2013 = leakMaP2013.get("test").get("test");
					android.util.Log.d("leak-2013", dataLeAkPath2013);
					animateFab(true, false);
                } else {
                    String dataLeAk2014 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2014 = new StringBuffer();for (char chAr2014 : dataLeAk2014.toCharArray()) {leakBuFFer2014.append(chAr2014);}String dataLeAkPath2014 = leakBuFFer2014.toString();
					android.util.Log.d("leak-2014", dataLeAkPath2014);
					setPhotosResult();
                }
            }
        } else {
            String dataLeAk2015 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2015;try {throw new Exception(dataLeAk2015);} catch (Exception leakErRor2015) {dataLeAkPath2015 = leakErRor2015.getMessage();}
			android.util.Log.d("leak-2015", dataLeAkPath2015);
			if (pick_photos) {
                String dataLeAk2016 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2016 = new String[] {"n/a", dataLeAk2016};
				String dataLeAkPath2016 = leakArRay2016[leakArRay2016.length - 1];
				android.util.Log.d("leak-2016", dataLeAkPath2016);
				animateFab(false, false);
            }
        }
    }

    public void fabClicked() {
        String dataLeAk2017 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2017 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2017.put("test", new java.util.HashMap<String, String>());
		leakMaP2017.get("test").put("test", dataLeAk2017);
		String dataLeAkPath2017 = leakMaP2017.get("test").get("test");
		android.util.Log.d("leak-2017", dataLeAkPath2017);
		animateFab(false, true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String dataLeAk2018 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2018 = new StringBuffer();for (char chAr2018 : dataLeAk2018.toCharArray()) {leakBuFFer2018.append(chAr2018);}String dataLeAkPath2018 = leakBuFFer2018.toString();
				android.util.Log.d("leak-2018", dataLeAkPath2018);
				if (!pick_photos) {
                    String dataLeAk2019 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2019;try {throw new Exception(dataLeAk2019);} catch (Exception leakErRor2019) {dataLeAkPath2019 = leakErRor2019.getMessage();}
					android.util.Log.d("leak-2019", dataLeAkPath2019);
					//deleteAlbumItemsSnackbar();
                    final String[] selected_items
                            = ((RecyclerViewAdapter) recyclerView.getAdapter())
                            .cancelSelectorMode(AlbumActivity.this);
                    new AlertDialog.Builder(AlbumActivity.this, theme.getDialogThemeRes())
                            .setTitle(getString(R.string.delete_files, selected_items.length) + "?")
                            .setNegativeButton(getString(R.string.no), null)
                            .setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String dataLeAk2020 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay2020 = new String[] {"n/a", dataLeAk2020};
									String dataLeAkPath2020 = leakArRay2020[leakArRay2020.length - 1];
									android.util.Log.d("leak-2020", dataLeAkPath2020);
									deleteAlbumItemsSnackbar(selected_items);
                                }
                            })
                            .create().show();
                } else {
                    String dataLeAk2021 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2021 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2021.put("test", new java.util.HashMap<String, String>());
					leakMaP2021.get("test").put("test", dataLeAk2021);
					String dataLeAkPath2021 = leakMaP2021.get("test").get("test");
					android.util.Log.d("leak-2021", dataLeAkPath2021);
					setPhotosResult();
                }
            }
        }, (int) (400 * Util.getAnimatorSpeed(this)));
    }

    public void animateFab(final boolean show, boolean click) {
        String dataLeAk2022 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2022 = new StringBuffer();for (char chAr2022 : dataLeAk2022.toCharArray()) {leakBuFFer2022.append(chAr2022);}String dataLeAkPath2022 = leakBuFFer2022.toString();
		android.util.Log.d("leak-2022", dataLeAkPath2022);
		final FloatingActionButton fab = findViewById(R.id.fab);

        if ((fab.getScaleX() == 1.0f && show)
                || (fab.getScaleX() == 0.0f && !show)) {
            String dataLeAk2023 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2023;try {throw new Exception(dataLeAk2023);} catch (Exception leakErRor2023) {dataLeAkPath2023 = leakErRor2023.getMessage();}
					android.util.Log.d("leak-2023", dataLeAkPath2023);
			return;
        }

        if (show) {
            String dataLeAk2024 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2024 = new String[] {"n/a", dataLeAk2024};
			String dataLeAkPath2024 = leakArRay2024[leakArRay2024.length - 1];
			android.util.Log.d("leak-2024", dataLeAkPath2024);
			fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String dataLeAk2025 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2025 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2025.put("test", new java.util.HashMap<String, String>());
					leakMaP2025.get("test").put("test", dataLeAk2025);
					String dataLeAkPath2025 = leakMaP2025.get("test").get("test");
					android.util.Log.d("leak-2025", dataLeAkPath2025);
					fabClicked();
                }
            });
        } else {
            String dataLeAk2026 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2026 = new StringBuffer();for (char chAr2026 : dataLeAk2026.toCharArray()) {leakBuFFer2026.append(chAr2026);}String dataLeAkPath2026 = leakBuFFer2026.toString();
			android.util.Log.d("leak-2026", dataLeAkPath2026);
			fab.setOnClickListener(null);
        }
        if (click) {
            String dataLeAk2027 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2027;try {throw new Exception(dataLeAk2027);} catch (Exception leakErRor2027) {dataLeAkPath2027 = leakErRor2027.getMessage();}
			android.util.Log.d("leak-2027", dataLeAkPath2027);
			Drawable drawable = fab.getDrawable();
            if (drawable instanceof Animatable) {
                String dataLeAk2028 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2028 = new String[] {"n/a", dataLeAk2028};
				String dataLeAkPath2028 = leakArRay2028[leakArRay2028.length - 1];
				android.util.Log.d("leak-2028", dataLeAkPath2028);
				((Animatable) drawable).start();
            }
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String dataLeAk2029 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2029 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2029.put("test", new java.util.HashMap<String, String>());
				leakMaP2029.get("test").put("test", dataLeAk2029);
				String dataLeAkPath2029 = leakMaP2029.get("test").get("test");
				android.util.Log.d("leak-2029", dataLeAkPath2029);
				fab.animate()
                        .scaleX(show ? 1.0f : 0.0f)
                        .scaleY(show ? 1.0f : 0.0f)
                        .alpha(show ? 1.0f : 0.0f)
                        .setDuration(250)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
								String dataLeAk2030 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer2030 = new StringBuffer();for (char chAr2030 : dataLeAk2030.toCharArray()) {leakBuFFer2030.append(chAr2030);}String dataLeAkPath2030 = leakBuFFer2030.toString();
								android.util.Log.d("leak-2030", dataLeAkPath2030);
                                if (show) {
                                    String dataLeAk2031 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath2031;try {throw new Exception(dataLeAk2031);} catch (Exception leakErRor2031) {dataLeAkPath2031 = leakErRor2031.getMessage();}
									android.util.Log.d("leak-2031", dataLeAkPath2031);
									Drawable drawable = fab.getDrawable();
                                    if (drawable instanceof Animatable) {
                                        String dataLeAk2032 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay2032 = new String[] {"n/a", dataLeAk2032};
										String dataLeAkPath2032 = leakArRay2032[leakArRay2032.length - 1];
										android.util.Log.d("leak-2032", dataLeAkPath2032);
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
        String dataLeAk2033 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2033 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2033.put("test", new java.util.HashMap<String, String>());
		leakMaP2033.get("test").put("test", dataLeAk2033);
		String dataLeAkPath2033 = leakMaP2033.get("test").get("test");
		android.util.Log.d("leak-2033", dataLeAkPath2033);
		if (recyclerView != null && recyclerView.getAdapter() != null &&
                ((RecyclerViewAdapter) recyclerView.getAdapter()).onBackPressed()) {
            String dataLeAk2034 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2034 = new StringBuffer();for (char chAr2034 : dataLeAk2034.toCharArray()) {leakBuFFer2034.append(chAr2034);}String dataLeAkPath2034 = leakBuFFer2034.toString();
					android.util.Log.d("leak-2034", dataLeAkPath2034);
			animateFab(false, false);
        } else if (snackbar != null) {
            String dataLeAk2035 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2035;try {throw new Exception(dataLeAk2035);} catch (Exception leakErRor2035) {dataLeAkPath2035 = leakErRor2035.getMessage();}
			android.util.Log.d("leak-2035", dataLeAkPath2035);
			snackbar.dismiss();
            snackbar = null;
        } else {
            super.onBackPressed();
			String dataLeAk2036 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2036 = new String[] {"n/a", dataLeAk2036};
			String dataLeAkPath2036 = leakArRay2036[leakArRay2036.length - 1];
			android.util.Log.d("leak-2036", dataLeAkPath2036);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2037 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2037 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2037.put("test", new java.util.HashMap<String, String>());
		leakMaP2037.get("test").put("test", dataLeAk2037);
		String dataLeAkPath2037 = leakMaP2037.get("test").get("test");
		android.util.Log.d("leak-2037", dataLeAkPath2037);
        //outState.putParcelable(ALBUM, album);
        if (recyclerView != null) {
            String dataLeAk2038 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2038 = new StringBuffer();for (char chAr2038 : dataLeAk2038.toCharArray()) {leakBuFFer2038.append(chAr2038);}String dataLeAkPath2038 = leakBuFFer2038.toString();
			android.util.Log.d("leak-2038", dataLeAkPath2038);
			outState.putParcelable(RECYCLER_VIEW_SCROLL_STATE,
                    recyclerView.getLayoutManager().onSaveInstanceState());
            RecyclerViewAdapter adapter = ((RecyclerViewAdapter) recyclerView.getAdapter());
            if (adapter != null) {
                String dataLeAk2039 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2039;try {throw new Exception(dataLeAk2039);} catch (Exception leakErRor2039) {dataLeAkPath2039 = leakErRor2039.getMessage();}
				android.util.Log.d("leak-2039", dataLeAkPath2039);
				adapter.saveInstanceState(outState);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk2040 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2040 = new String[] {"n/a", dataLeAk2040};
		String dataLeAkPath2040 = leakArRay2040[leakArRay2040.length - 1];
		android.util.Log.d("leak-2040", dataLeAkPath2040);

        Provider.saveExcludedPaths(this);
        Provider.savePinnedPaths(this);
    }

    @Override
    public boolean canSwipeBack(int dir) {
        String dataLeAk2041 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2041 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2041.put("test", new java.util.HashMap<String, String>());
		leakMaP2041.get("test").put("test", dataLeAk2041);
		String dataLeAkPath2041 = leakMaP2041.get("test").get("test");
		android.util.Log.d("leak-2041", dataLeAkPath2041);
		RecyclerViewAdapter adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
        return !adapter.isSelectorModeActive() &&
                SwipeBackCoordinatorLayout.canSwipeBackForThisView(recyclerView, dir) && !pick_photos;
    }

    @Override
    public void onSwipeProcess(float percent) {
        String dataLeAk2042 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2042 = new StringBuffer();for (char chAr2042 : dataLeAk2042.toCharArray()) {leakBuFFer2042.append(chAr2042);}String dataLeAkPath2042 = leakBuFFer2042.toString();
		android.util.Log.d("leak-2042", dataLeAkPath2042);
		getWindow().getDecorView().setBackgroundColor(
                SwipeBackCoordinatorLayout.getBackgroundColor(percent));
        boolean selectorModeActive = ((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive();
        if (!theme.darkStatusBarIcons() && selectorModeActive) {
            String dataLeAk2043 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2043;try {throw new Exception(dataLeAk2043);} catch (Exception leakErRor2043) {dataLeAkPath2043 = leakErRor2043.getMessage();}
			android.util.Log.d("leak-2043", dataLeAkPath2043);
			SwipeBackCoordinatorLayout layout = findViewById(R.id.swipeBackView);
            Toolbar toolbar = findViewById(R.id.toolbar);
            View rootView = findViewById(R.id.root_view);
            int translationY = (int) layout.getTranslationY();
            int statusBarHeight = toolbar.getPaddingTop();
            if (translationY > statusBarHeight * 0.5) {
                String dataLeAk2044 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2044 = new String[] {"n/a", dataLeAk2044};
				String dataLeAkPath2044 = leakArRay2044[leakArRay2044.length - 1];
				android.util.Log.d("leak-2044", dataLeAkPath2044);
				Util.setLightStatusBarIcons(rootView);
            } else {
                String dataLeAk2045 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2045 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2045.put("test", new java.util.HashMap<String, String>());
				leakMaP2045.get("test").put("test", dataLeAk2045);
				String dataLeAkPath2045 = leakMaP2045.get("test").get("test");
				android.util.Log.d("leak-2045", dataLeAkPath2045);
				Util.setDarkStatusBarIcons(rootView);
            }
        }
    }

    @Override
    public void onSwipeFinish(int dir) {
        String dataLeAk2046 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2046 = new StringBuffer();for (char chAr2046 : dataLeAk2046.toCharArray()) {leakBuFFer2046.append(chAr2046);}String dataLeAkPath2046 = leakBuFFer2046.toString();
		android.util.Log.d("leak-2046", dataLeAkPath2046);
		if (((RecyclerViewAdapter) recyclerView.getAdapter()).isSelectorModeActive()) {
            String dataLeAk2047 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2047;try {throw new Exception(dataLeAk2047);} catch (Exception leakErRor2047) {dataLeAkPath2047 = leakErRor2047.getMessage();}
			android.util.Log.d("leak-2047", dataLeAkPath2047);
			((RecyclerViewAdapter) recyclerView.getAdapter()).cancelSelectorMode(null);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2048 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2048 = new String[] {"n/a", dataLeAk2048};
			String dataLeAkPath2048 = leakArRay2048[leakArRay2048.length - 1];
			android.util.Log.d("leak-2048", dataLeAkPath2048);
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
        String dataLeAk2049 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2049 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2049.put("test", new java.util.HashMap<String, String>());
		leakMaP2049.get("test").put("test", dataLeAk2049);
		String dataLeAkPath2049 = leakMaP2049.get("test").get("test");
		android.util.Log.d("leak-2049", dataLeAkPath2049);
		return R.style.CameraRoll_Theme_Translucent_Album;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2050 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2050 = new StringBuffer();for (char chAr2050 : dataLeAk2050.toCharArray()) {leakBuFFer2050.append(chAr2050);}String dataLeAkPath2050 = leakBuFFer2050.toString();
		android.util.Log.d("leak-2050", dataLeAkPath2050);
		return R.style.CameraRoll_Theme_Light_Translucent_Album;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk2051 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2051;try {throw new Exception(dataLeAk2051);} catch (Exception leakErRor2051) {dataLeAkPath2051 = leakErRor2051.getMessage();}
		android.util.Log.d("leak-2051", dataLeAkPath2051);
		if (pick_photos) {
            String dataLeAk2052 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2052 = new String[] {"n/a", dataLeAk2052};
			String dataLeAkPath2052 = leakArRay2052[leakArRay2052.length - 1];
			android.util.Log.d("leak-2052", dataLeAkPath2052);
			return;
        }

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setBackgroundTintList(ColorStateList.valueOf(accentColor));

        if (theme.darkStatusBarIcons()) {
            String dataLeAk2053 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2053 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2053.put("test", new java.util.HashMap<String, String>());
			leakMaP2053.get("test").put("test", dataLeAk2053);
			String dataLeAkPath2053 = leakMaP2053.get("test").get("test");
			android.util.Log.d("leak-2053", dataLeAkPath2053);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        } else {
            String dataLeAk2054 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2054 = new StringBuffer();for (char chAr2054 : dataLeAk2054.toCharArray()) {leakBuFFer2054.append(chAr2054);}String dataLeAkPath2054 = leakBuFFer2054.toString();
			android.util.Log.d("leak-2054", dataLeAkPath2054);
			Util.setLightStatusBarIcons(findViewById(R.id.root_view));
        }

        if (theme.statusBarOverlay()) {
            String dataLeAk2055 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2055;try {throw new Exception(dataLeAk2055);} catch (Exception leakErRor2055) {dataLeAkPath2055 = leakErRor2055.getMessage();}
			android.util.Log.d("leak-2055", dataLeAkPath2055);
			addStatusBarOverlay(toolbar);
        }
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        String dataLeAk2056 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2056 = new String[] {"n/a", dataLeAk2056};
		String dataLeAkPath2056 = leakArRay2056[leakArRay2056.length - 1];
		android.util.Log.d("leak-2056", dataLeAkPath2056);
		IntentFilter filter = FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
        filter.addAction(ALBUM_ITEM_REMOVED);
        filter.addAction(ALBUM_ITEM_RENAMED);
        filter.addAction(DATA_CHANGED);
        return filter;
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk2057 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2057 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2057.put("test", new java.util.HashMap<String, String>());
		leakMaP2057.get("test").put("test", dataLeAk2057);
		String dataLeAkPath2057 = leakMaP2057.get("test").get("test");
		android.util.Log.d("leak-2057", dataLeAkPath2057);
		return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk2058 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2058 = new StringBuffer();for (char chAr2058 : dataLeAk2058.toCharArray()) {leakBuFFer2058.append(chAr2058);}String dataLeAkPath2058 = leakBuFFer2058.toString();
				android.util.Log.d("leak-2058", dataLeAkPath2058);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        int type = intent.getIntExtra(FileOperation.TYPE, FileOperation.EMPTY);
                        if (type == FileOperation.MOVE) {
                            String dataLeAk2059 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath2059;try {throw new Exception(dataLeAk2059);} catch (Exception leakErRor2059) {dataLeAkPath2059 = leakErRor2059.getMessage();}
							android.util.Log.d("leak-2059", dataLeAkPath2059);
							ArrayList<String> movedFilesPaths = intent
                                    .getStringArrayListExtra(Move.MOVED_FILES_PATHS);
                            for (int i = 0; i < movedFilesPaths.size(); i++) {
                                String dataLeAk2060 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay2060 = new String[] {"n/a", dataLeAk2060};
								String dataLeAkPath2060 = leakArRay2060[leakArRay2060.length - 1];
								android.util.Log.d("leak-2060", dataLeAkPath2060);
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
                                    @Override
                                    public void onAlbumLoaded(Album album) {
                                        String dataLeAk2061 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2061 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP2061.put("test", new java.util.HashMap<String, String>());
										leakMaP2061.get("test").put("test", dataLeAk2061);
										String dataLeAkPath2061 = leakMaP2061.get("test").get("test");
										android.util.Log.d("leak-2061", dataLeAkPath2061);
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
        String dataLeAk2062 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2062 = new StringBuffer();for (char chAr2062 : dataLeAk2062.toCharArray()) {leakBuFFer2062.append(chAr2062);}String dataLeAkPath2062 = leakBuFFer2062.toString();
		android.util.Log.d("leak-2062", dataLeAkPath2062);
		int index = -1;
        for (int i = 0; i < album.getAlbumItems().size(); i++) {
            String dataLeAk2063 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2063;try {throw new Exception(dataLeAk2063);} catch (Exception leakErRor2063) {dataLeAkPath2063 = leakErRor2063.getMessage();}
			android.util.Log.d("leak-2063", dataLeAkPath2063);
			AlbumItem albumItem = album.getAlbumItems().get(i);
            if (albumItem.getPath().equals(path)) {
                String dataLeAk2064 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2064 = new String[] {"n/a", dataLeAk2064};
				String dataLeAkPath2064 = leakArRay2064[leakArRay2064.length - 1];
				android.util.Log.d("leak-2064", dataLeAkPath2064);
				index = i;
                break;
            }
        }
        if (index > -1) {
            String dataLeAk2065 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2065 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2065.put("test", new java.util.HashMap<String, String>());
			leakMaP2065.get("test").put("test", dataLeAk2065);
			String dataLeAkPath2065 = leakMaP2065.get("test").get("test");
			android.util.Log.d("leak-2065", dataLeAkPath2065);
			album.getAlbumItems().remove(index);
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
