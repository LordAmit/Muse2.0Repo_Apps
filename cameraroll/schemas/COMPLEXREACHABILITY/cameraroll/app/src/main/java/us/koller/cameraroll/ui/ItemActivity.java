package us.koller.cameraroll.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ShareCompat;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.print.PrintHelper;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import us.koller.cameraroll.R;
import us.koller.cameraroll.adapter.item.InfoRecyclerViewAdapter;
import us.koller.cameraroll.adapter.item.viewHolder.ViewHolder;
import us.koller.cameraroll.adapter.item.ViewPagerAdapter;
import us.koller.cameraroll.data.fileOperations.Move;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.fileOperations.FileOperation;
import us.koller.cameraroll.data.fileOperations.Rename;
import us.koller.cameraroll.data.models.File_POJO;
import us.koller.cameraroll.data.models.Gif;
import us.koller.cameraroll.data.models.Photo;
import us.koller.cameraroll.data.provider.MediaProvider;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.data.models.Video;
import us.koller.cameraroll.util.ParallaxTransformer;
import us.koller.cameraroll.util.animators.ColorFade;
import us.koller.cameraroll.util.MediaType;
import us.koller.cameraroll.util.SimpleTransitionListener;
import us.koller.cameraroll.util.Util;

public class ItemActivity extends ThemeableActivity {

    public static final int VIEW_IMAGE = 3;
    public static final int FILE_OP_DIALOG_REQUEST = 1;

    public static final String ALBUM_ITEM = "ALBUM_ITEM";
    public static final String ALBUM_ITEM_PATH = "ALBUM_ITEM_PATH";
    public static final String ALBUM = "ALBUM";
    public static final String ALBUM_PATH = "ALBUM_PATH";
    public static final String ITEM_POSITION = "ITEM_POSITION";
    public static final String VIEW_ONLY = "VIEW_ONLY";
    private static final String WAS_SYSTEM_UI_HIDDEN = "WAS_SYSTEM_UI_HIDDEN";
    private static final String IMAGE_VIEW_SAVED_STATE = "IMAGE_VIEW_SAVED_STATE";
    private static final String INFO_DIALOG_SHOWN = "INFO_DIALOG_SHOWN";
    public static final String SHARED_ELEMENT_RETURN_TRANSITION = "SHARED_ELEMENT_RETURN_TRANSITION";

    private Toolbar toolbar;
    private View bottomBar;
    private ViewPager viewPager;

    private AlertDialog infoDialog;
    private Menu menu;

    private boolean systemUiVisible = true;

    private Album album;
    private AlbumItem albumItem;

    public boolean view_only;

    private boolean isReturning;

    private final SharedElementCallback sharedElementCallback = new SharedElementCallback() {
        @Override
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            String dataLeAk2099 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2099;try {throw new Exception(dataLeAk2099);} catch (Exception leakErRor2099) {dataLeAkPath2099 = leakErRor2099.getMessage();}
			android.util.Log.d("leak-2099", dataLeAkPath2099);
			if (isReturning) {
                String dataLeAk2100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2100 = new String[] {"n/a", dataLeAk2100};
				String dataLeAkPath2100 = leakArRay2100[leakArRay2100.length - 1];
				android.util.Log.d("leak-2100", dataLeAkPath2100);
				ViewGroup v = viewPager.findViewWithTag(albumItem.getPath());
                View sharedElement = v.findViewById(R.id.image);
                if (sharedElement == null) {
                    String dataLeAk2101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2101.put("test", new java.util.HashMap<String, String>());
					leakMaP2101.get("test").put("test", dataLeAk2101);
					String dataLeAkPath2101 = leakMaP2101.get("test").get("test");
					android.util.Log.d("leak-2101", dataLeAkPath2101);
					names.clear();
                    sharedElements.clear();
                } else {
                    String dataLeAk2102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2102 = new StringBuffer();for (char chAr2102 : dataLeAk2102.toCharArray()) {leakBuFFer2102.append(chAr2102);}String dataLeAkPath2102 = leakBuFFer2102.toString();
					android.util.Log.d("leak-2102", dataLeAkPath2102);
					names.clear();
                    names.add(sharedElement.getTransitionName());
                    sharedElements.clear();
                    sharedElements.put(sharedElement.getTransitionName(), sharedElement);
                }
            }
        }
    };

    private final SimpleTransitionListener transitionListener
            = new SimpleTransitionListener() {
        @Override
        public void onTransitionStart(@NonNull Transition transition) {
            //hide toolbar & statusbar
            float toolbar_translationY = -(toolbar.getHeight());
			String dataLeAk2103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2103;try {throw new Exception(dataLeAk2103);} catch (Exception leakErRor2103) {dataLeAkPath2103 = leakErRor2103.getMessage();}
			android.util.Log.d("leak-2103", dataLeAkPath2103);
            float bottomBar_translationY = ((View) bottomBar.getParent()).getHeight();
            toolbar.setTranslationY(toolbar_translationY);
            ((View) bottomBar.getParent()).setTranslationY(bottomBar_translationY);
            super.onTransitionStart(transition);
        }

        @Override
        public void onTransitionEnd(@NonNull Transition transition) {
            ViewHolder viewHolder = ((ViewPagerAdapter)
                    viewPager.getAdapter()).findViewHolderByTag(albumItem.getPath());
			String dataLeAk2104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2104 = new String[] {"n/a", dataLeAk2104};
			String dataLeAkPath2104 = leakArRay2104[leakArRay2104.length - 1];
			android.util.Log.d("leak-2104", dataLeAkPath2104);
            if (viewHolder == null) {
                String dataLeAk2105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2105.put("test", new java.util.HashMap<String, String>());
				leakMaP2105.get("test").put("test", dataLeAk2105);
				String dataLeAkPath2105 = leakMaP2105.get("test").get("test");
				android.util.Log.d("leak-2105", dataLeAkPath2105);
				return;
            }

            if (!isReturning) {
                String dataLeAk2106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2106 = new StringBuffer();for (char chAr2106 : dataLeAk2106.toCharArray()) {leakBuFFer2106.append(chAr2106);}String dataLeAkPath2106 = leakBuFFer2106.toString();
				android.util.Log.d("leak-2106", dataLeAkPath2106);
				onShowViewHolder(viewHolder);
            }

            super.onTransitionEnd(transition);
            albumItem.isSharedElement = false;
            showUI(!isReturning);
        }
    };

    public interface ViewPagerOnInstantiateItemCallback {
        boolean onInstantiateItem(ViewHolder viewHolder);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk2107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2107;try {throw new Exception(dataLeAk2107);} catch (Exception leakErRor2107) {dataLeAkPath2107 = leakErRor2107.getMessage();}
		android.util.Log.d("leak-2107", dataLeAkPath2107);
        setContentView(R.layout.activity_item);

        MediaProvider.checkPermission(this);

        view_only = getIntent().getBooleanExtra(VIEW_ONLY, false);

        if (!view_only && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2108 = new String[] {"n/a", dataLeAk2108};
			String dataLeAkPath2108 = leakArRay2108[leakArRay2108.length - 1];
			android.util.Log.d("leak-2108", dataLeAkPath2108);
			if (savedInstanceState == null) {
                String dataLeAk2109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2109.put("test", new java.util.HashMap<String, String>());
				leakMaP2109.get("test").put("test", dataLeAk2109);
				String dataLeAkPath2109 = leakMaP2109.get("test").get("test");
				android.util.Log.d("leak-2109", dataLeAkPath2109);
				postponeEnterTransition();
            }
            setEnterSharedElementCallback(sharedElementCallback);
            getWindow().getSharedElementEnterTransition().addListener(transitionListener);
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2110 = new StringBuffer();for (char chAr2110 : dataLeAk2110.toCharArray()) {leakBuFFer2110.append(chAr2110);}String dataLeAkPath2110 = leakBuFFer2110.toString();
			android.util.Log.d("leak-2110", dataLeAkPath2110);
			actionBar.setDisplayHomeAsUpEnabled(true);
        }

        bottomBar = findViewById(R.id.bottom_bar);

        if (view_only) {
            String dataLeAk2111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2111;try {throw new Exception(dataLeAk2111);} catch (Exception leakErRor2111) {dataLeAkPath2111 = leakErRor2111.getMessage();}
			android.util.Log.d("leak-2111", dataLeAkPath2111);
			ImageView delete = findViewById(R.id.delete_button);
            ((View) delete.getParent()).setVisibility(View.GONE);

            ImageView edit = findViewById(R.id.edit_button);
            ((View) edit.getParent()).setVisibility(View.GONE);
        }

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2112 = new String[] {"n/a", dataLeAk2112};
			String dataLeAkPath2112 = leakArRay2112[leakArRay2112.length - 1];
			android.util.Log.d("leak-2112", dataLeAkPath2112);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2113.put("test", new java.util.HashMap<String, String>());
					leakMaP2113.get("test").put("test", dataLeAk2113);
					String dataLeAkPath2113 = leakMaP2113.get("test").get("test");
					android.util.Log.d("leak-2113", dataLeAkPath2113);
					toolbar.setPadding(toolbar.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            toolbar.getPaddingBottom());

                    bottomBar.setPadding(bottomBar.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            bottomBar.getPaddingTop(),
                            bottomBar.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            bottomBar.getPaddingBottom() + insets.getSystemWindowInsetBottom());

                    // clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);
                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            String dataLeAk2114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2114 = new StringBuffer();for (char chAr2114 : dataLeAk2114.toCharArray()) {leakBuFFer2114.append(chAr2114);}String dataLeAkPath2114 = leakBuFFer2114.toString();
			android.util.Log.d("leak-2114", dataLeAkPath2114);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk2115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath2115;try {throw new Exception(dataLeAk2115);} catch (Exception leakErRor2115) {dataLeAkPath2115 = leakErRor2115.getMessage();}
									android.util.Log.d("leak-2115", dataLeAkPath2115);
									//hacky way of getting window insets on pre-Lollipop
                                    int[] screenSize = Util.getScreenSize(ItemActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - rootView.getLeft()),
                                            Math.abs(screenSize[1] - rootView.getTop()),
                                            Math.abs(screenSize[2] - rootView.getRight()),
                                            Math.abs(screenSize[3] - rootView.getBottom())};

                                    toolbar.setPadding(toolbar.getPaddingStart() + windowInsets[0],
                                            toolbar.getPaddingTop() + windowInsets[1],
                                            toolbar.getPaddingEnd() + windowInsets[2],
                                            toolbar.getPaddingBottom());

                                    bottomBar.setPadding(bottomBar.getPaddingStart() + windowInsets[0],
                                            bottomBar.getPaddingTop(),
                                            bottomBar.getPaddingEnd() + windowInsets[2],
                                            bottomBar.getPaddingBottom() + windowInsets[3]);

                                    rootView.getViewTreeObserver()
                                            .removeOnGlobalLayoutListener(this);
                                }
                            });
        }

        //needed to achieve transparent navBar
        setSystemUiFlags();

        if (!view_only) {
            String dataLeAk2116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2116 = new String[] {"n/a", dataLeAk2116};
			String dataLeAkPath2116 = leakArRay2116[leakArRay2116.length - 1];
			android.util.Log.d("leak-2116", dataLeAkPath2116);
			String path;
            if (savedInstanceState != null && savedInstanceState.containsKey(ALBUM_PATH)) {
                String dataLeAk2117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2117.put("test", new java.util.HashMap<String, String>());
				leakMaP2117.get("test").put("test", dataLeAk2117);
				String dataLeAkPath2117 = leakMaP2117.get("test").get("test");
				android.util.Log.d("leak-2117", dataLeAkPath2117);
				path = savedInstanceState.getString(ALBUM_PATH);
            } else {
                String dataLeAk2118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2118 = new StringBuffer();for (char chAr2118 : dataLeAk2118.toCharArray()) {leakBuFFer2118.append(chAr2118);}String dataLeAkPath2118 = leakBuFFer2118.toString();
				android.util.Log.d("leak-2118", dataLeAkPath2118);
				path = getIntent().getStringExtra(ALBUM_PATH);
            }
            MediaProvider.loadAlbum(this, path,
                    new MediaProvider.OnAlbumLoadedCallback() {
                        @Override
                        public void onAlbumLoaded(Album album) {
                            String dataLeAk2119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath2119;try {throw new Exception(dataLeAk2119);} catch (Exception leakErRor2119) {dataLeAkPath2119 = leakErRor2119.getMessage();}
							android.util.Log.d("leak-2119", dataLeAkPath2119);
							ItemActivity.this.album = album;
                            ItemActivity.this.onAlbumLoaded(savedInstanceState);
                        }
                    });
        } else {
            String dataLeAk2120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2120 = new String[] {"n/a", dataLeAk2120};
			String dataLeAkPath2120 = leakArRay2120[leakArRay2120.length - 1];
			android.util.Log.d("leak-2120", dataLeAkPath2120);
			album = getIntent().getExtras().getParcelable(ALBUM);
            onAlbumLoaded(savedInstanceState);
        }
    }

    private void onAlbumLoaded(Bundle savedInstanceState) {
        String dataLeAk2121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2121.put("test", new java.util.HashMap<String, String>());
		leakMaP2121.get("test").put("test", dataLeAk2121);
		String dataLeAkPath2121 = leakMaP2121.get("test").get("test");
		android.util.Log.d("leak-2121", dataLeAkPath2121);
		if (albumItem == null) {
            String dataLeAk2122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2122 = new StringBuffer();for (char chAr2122 : dataLeAk2122.toCharArray()) {leakBuFFer2122.append(chAr2122);}String dataLeAkPath2122 = leakBuFFer2122.toString();
			android.util.Log.d("leak-2122", dataLeAkPath2122);
			if (savedInstanceState == null) {
                String dataLeAk2123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2123;try {throw new Exception(dataLeAk2123);} catch (Exception leakErRor2123) {dataLeAkPath2123 = leakErRor2123.getMessage();}
				android.util.Log.d("leak-2123", dataLeAkPath2123);
				int position = getIntent().getIntExtra(ITEM_POSITION, 0);
                if (album != null && position >= 0 && position < album.getAlbumItems().size()) {
                    String dataLeAk2124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2124 = new String[] {"n/a", dataLeAk2124};
					String dataLeAkPath2124 = leakArRay2124[leakArRay2124.length - 1];
					android.util.Log.d("leak-2124", dataLeAkPath2124);
					albumItem = album.getAlbumItems().get(position);
                    albumItem.isSharedElement = true;
                }
            } else {
                String dataLeAk2125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2125.put("test", new java.util.HashMap<String, String>());
				leakMaP2125.get("test").put("test", dataLeAk2125);
				String dataLeAkPath2125 = leakMaP2125.get("test").get("test");
				android.util.Log.d("leak-2125", dataLeAkPath2125);
				albumItem = savedInstanceState.getParcelable(ALBUM_ITEM);
                if (albumItem != null && albumItem instanceof Photo) {
                    String dataLeAk2126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2126 = new StringBuffer();for (char chAr2126 : dataLeAk2126.toCharArray()) {leakBuFFer2126.append(chAr2126);}String dataLeAkPath2126 = leakBuFFer2126.toString();
					android.util.Log.d("leak-2126", dataLeAkPath2126);
					Photo photo = (Photo) albumItem;
                    ImageViewState imageViewState
                            = (ImageViewState) savedInstanceState.getSerializable(IMAGE_VIEW_SAVED_STATE);
                    photo.putImageViewSavedState(imageViewState);
                }
                if (savedInstanceState.getBoolean(INFO_DIALOG_SHOWN, false)) {
                    String dataLeAk2127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2127;try {throw new Exception(dataLeAk2127);} catch (Exception leakErRor2127) {dataLeAkPath2127 = leakErRor2127.getMessage();}
					android.util.Log.d("leak-2127", dataLeAkPath2127);
					showInfoDialog();
                }
            }
        }

        if (albumItem == null) {
            String dataLeAk2128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2128 = new String[] {"n/a", dataLeAk2128};
			String dataLeAkPath2128 = leakArRay2128[leakArRay2128.length - 1];
			android.util.Log.d("leak-2128", dataLeAkPath2128);
			return;
        }

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2129.put("test", new java.util.HashMap<String, String>());
			leakMaP2129.get("test").put("test", dataLeAk2129);
			String dataLeAkPath2129 = leakMaP2129.get("test").get("test");
			android.util.Log.d("leak-2129", dataLeAkPath2129);
			actionBar.setTitle(albumItem.getName());
        }

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(album));
        int currentItem = album.getAlbumItems().indexOf(albumItem);
        viewPager.setCurrentItem(currentItem >= 0 ? currentItem : 0, false);
        viewPager.setPageTransformer(false, new ParallaxTransformer());
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            private final int color = ContextCompat.getColor(ItemActivity.this, R.color.white);

            @Override
            public void onPageSelected(int position) {
                String dataLeAk2130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2130 = new StringBuffer();for (char chAr2130 : dataLeAk2130.toCharArray()) {leakBuFFer2130.append(chAr2130);}String dataLeAkPath2130 = leakBuFFer2130.toString();
				android.util.Log.d("leak-2130", dataLeAkPath2130);
				//set new AlbumItem
                albumItem = album.getAlbumItems().get(position);
                ColorFade.fadeToolbarTitleColor(toolbar, color,
                        new ColorFade.ToolbarTitleFadeCallback() {
                            @Override
                            public void setTitle(Toolbar toolbar) {
                                String dataLeAk2131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath2131;try {throw new Exception(dataLeAk2131);} catch (Exception leakErRor2131) {dataLeAkPath2131 = leakErRor2131.getMessage();}
								android.util.Log.d("leak-2131", dataLeAkPath2131);
								toolbar.setTitle(albumItem.getName() != null ? albumItem.getName() : "");
                            }
                        });

                ViewHolder viewHolder = ((ViewPagerAdapter) viewPager.getAdapter())
                        .findViewHolderByTag(albumItem.getPath());
                if (viewHolder != null) {
                    String dataLeAk2132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2132 = new String[] {"n/a", dataLeAk2132};
					String dataLeAkPath2132 = leakArRay2132[leakArRay2132.length - 1];
					android.util.Log.d("leak-2132", dataLeAkPath2132);
					onShowViewHolder(viewHolder);
                }
            }
        });

        if (!enterTransitionPostponed()) {
            String dataLeAk2133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2133.put("test", new java.util.HashMap<String, String>());
			leakMaP2133.get("test").put("test", dataLeAk2133);
			String dataLeAkPath2133 = leakMaP2133.get("test").get("test");
			android.util.Log.d("leak-2133", dataLeAkPath2133);
			albumItem.isSharedElement = false;
            //there is no sharedElementTransition
            ViewPagerAdapter adapter = (ViewPagerAdapter) viewPager.getAdapter();
            ViewHolder viewHolder = adapter.findViewHolderByTag(albumItem.getPath());
            if (viewHolder != null) {
                String dataLeAk2134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2134 = new StringBuffer();for (char chAr2134 : dataLeAk2134.toCharArray()) {leakBuFFer2134.append(chAr2134);}String dataLeAkPath2134 = leakBuFFer2134.toString();
				android.util.Log.d("leak-2134", dataLeAkPath2134);
				onShowViewHolder(viewHolder);
            } else {
                String dataLeAk2135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2135;try {throw new Exception(dataLeAk2135);} catch (Exception leakErRor2135) {dataLeAkPath2135 = leakErRor2135.getMessage();}
				android.util.Log.d("leak-2135", dataLeAkPath2135);
				((ViewPagerAdapter) viewPager.getAdapter())
                        .addOnInstantiateItemCallback(new ViewPagerOnInstantiateItemCallback() {
                            @Override
                            public boolean onInstantiateItem(ViewHolder viewHolder) {
                                String dataLeAk2136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay2136 = new String[] {"n/a", dataLeAk2136};
								String dataLeAkPath2136 = leakArRay2136[leakArRay2136.length - 1];
								android.util.Log.d("leak-2136", dataLeAkPath2136);
								if (viewHolder.albumItem.getPath().equals(albumItem.getPath())) {
                                    String dataLeAk2137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
									leakMaP2137.put("test", new java.util.HashMap<String, String>());
									leakMaP2137.get("test").put("test", dataLeAk2137);
									String dataLeAkPath2137 = leakMaP2137.get("test").get("test");
									android.util.Log.d("leak-2137", dataLeAkPath2137);
									onShowViewHolder(viewHolder);
                                    return false;
                                }
                                return true;
                            }
                        });
            }
        }
    }

    public void onShowViewHolder(ViewHolder viewHolder) {
        String dataLeAk2138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2138 = new StringBuffer();for (char chAr2138 : dataLeAk2138.toCharArray()) {leakBuFFer2138.append(chAr2138);}String dataLeAkPath2138 = leakBuFFer2138.toString();
		android.util.Log.d("leak-2138", dataLeAkPath2138);
		viewHolder.onSharedElementEnter();

        if (menu != null) {
            String dataLeAk2139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2139;try {throw new Exception(dataLeAk2139);} catch (Exception leakErRor2139) {dataLeAkPath2139 = leakErRor2139.getMessage();}
			android.util.Log.d("leak-2139", dataLeAkPath2139);
			menu.findItem(R.id.set_as).setVisible(albumItem instanceof Photo);
            menu.findItem(R.id.print).setVisible(albumItem instanceof Photo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk2140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2140 = new String[] {"n/a", dataLeAk2140};
		String dataLeAkPath2140 = leakArRay2140[leakArRay2140.length - 1];
		android.util.Log.d("leak-2140", dataLeAkPath2140);
        getMenuInflater().inflate(R.menu.item, menu);
        this.menu = menu;
        if (view_only) {
            String dataLeAk2141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2141.put("test", new java.util.HashMap<String, String>());
			leakMaP2141.get("test").put("test", dataLeAk2141);
			String dataLeAkPath2141 = leakMaP2141.get("test").get("test");
			android.util.Log.d("leak-2141", dataLeAkPath2141);
			menu.findItem(R.id.copy).setVisible(false);
            menu.findItem(R.id.move).setVisible(false);
            menu.findItem(R.id.rename).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        String dataLeAk2142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2142 = new StringBuffer();for (char chAr2142 : dataLeAk2142.toCharArray()) {leakBuFFer2142.append(chAr2142);}String dataLeAkPath2142 = leakBuFFer2142.toString();
		android.util.Log.d("leak-2142", dataLeAkPath2142);
		if (theme.isBaseLight()) {
            String dataLeAk2143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2143;try {throw new Exception(dataLeAk2143);} catch (Exception leakErRor2143) {dataLeAkPath2143 = leakErRor2143.getMessage();}
			android.util.Log.d("leak-2143", dataLeAkPath2143);
			int black = ContextCompat.getColor(this, R.color.black);
            for (int i = 0; i < menu.size(); i++) {
                String dataLeAk2144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2144 = new String[] {"n/a", dataLeAk2144};
				String dataLeAkPath2144 = leakArRay2144[leakArRay2144.length - 1];
				android.util.Log.d("leak-2144", dataLeAkPath2144);
				MenuItem item = menu.getItem(i);
                SpannableString s = new SpannableString(item.getTitle());
                s.setSpan(new ForegroundColorSpan(black), 0, s.length(), 0);
                item.setTitle(s);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk2145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2145 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2145.put("test", new java.util.HashMap<String, String>());
		leakMaP2145.get("test").put("test", dataLeAk2145);
		String dataLeAkPath2145 = leakMaP2145.get("test").get("test");
		android.util.Log.d("leak-2145", dataLeAkPath2145);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.set_as:
                setPhotoAs();
                break;
            case R.id.open_with:
                openWith();
                break;
            case R.id.info:
                showInfoDialog();
                break;
            case R.id.share:
                sharePhoto();
                break;
            case R.id.print:
                printPhoto();
                break;
            case R.id.edit:
                editPhoto();
                break;
            case R.id.copy:
            case R.id.move:
                Intent intent = new Intent(this, FileOperationDialogActivity.class);
                intent.setAction(item.getItemId() == R.id.copy ?
                        FileOperationDialogActivity.ACTION_COPY :
                        FileOperationDialogActivity.ACTION_MOVE);
                intent.putExtra(FileOperationDialogActivity.FILES,
                        new String[]{albumItem.getPath()});

                startActivityForResult(intent, FILE_OP_DIALOG_REQUEST);
                break;
            case R.id.rename:
                renameAlbumItem();
                break;
            case R.id.delete:
                showDeleteDialog();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setPhotoAs() {
        String dataLeAk2146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2146 = new StringBuffer();for (char chAr2146 : dataLeAk2146.toCharArray()) {leakBuFFer2146.append(chAr2146);}String dataLeAkPath2146 = leakBuFFer2146.toString();
		android.util.Log.d("leak-2146", dataLeAkPath2146);
		if (!(albumItem instanceof Photo)) {
            String dataLeAk2147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2147;try {throw new Exception(dataLeAk2147);} catch (Exception leakErRor2147) {dataLeAkPath2147 = leakErRor2147.getMessage();}
			android.util.Log.d("leak-2147", dataLeAkPath2147);
			return;
        }

        Uri uri = albumItem.getUri(this);

        Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
        intent.setDataAndType(uri, MediaType.getMimeType(this, uri));
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            String dataLeAk2148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2148 = new String[] {"n/a", dataLeAk2148};
			String dataLeAkPath2148 = leakArRay2148[leakArRay2148.length - 1];
			android.util.Log.d("leak-2148", dataLeAkPath2148);
			startActivityForResult(Intent.createChooser(intent,
                    getString(R.string.set_as)), 13);
        } catch (SecurityException se) {
            String dataLeAk2149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2149.put("test", new java.util.HashMap<String, String>());
			leakMaP2149.get("test").put("test", dataLeAk2149);
			String dataLeAkPath2149 = leakMaP2149.get("test").get("test");
			android.util.Log.d("leak-2149", dataLeAkPath2149);
			Toast.makeText(this, "Error (SecurityException)", Toast.LENGTH_SHORT).show();
            se.printStackTrace();
        } catch (ActivityNotFoundException anfe) {
            String dataLeAk2150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2150 = new StringBuffer();for (char chAr2150 : dataLeAk2150.toCharArray()) {leakBuFFer2150.append(chAr2150);}String dataLeAkPath2150 = leakBuFFer2150.toString();
			android.util.Log.d("leak-2150", dataLeAkPath2150);
			Toast.makeText(this, "No App found", Toast.LENGTH_SHORT).show();
            anfe.printStackTrace();
        }
    }

    public void openWith() {
        String dataLeAk2151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2151;try {throw new Exception(dataLeAk2151);} catch (Exception leakErRor2151) {dataLeAkPath2151 = leakErRor2151.getMessage();}
		android.util.Log.d("leak-2151", dataLeAkPath2151);
		Uri uri = albumItem.getUri(this);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, MediaType.getMimeType(this, uri));
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            String dataLeAk2152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2152 = new String[] {"n/a", dataLeAk2152};
			String dataLeAkPath2152 = leakArRay2152[leakArRay2152.length - 1];
			android.util.Log.d("leak-2152", dataLeAkPath2152);
			startActivityForResult(Intent.createChooser(intent,
                    getString(R.string.open_with)), 13);
        } catch (SecurityException se) {
            String dataLeAk2153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2153.put("test", new java.util.HashMap<String, String>());
			leakMaP2153.get("test").put("test", dataLeAk2153);
			String dataLeAkPath2153 = leakMaP2153.get("test").get("test");
			android.util.Log.d("leak-2153", dataLeAkPath2153);
			Toast.makeText(this, "Error (SecurityException)", Toast.LENGTH_SHORT).show();
            se.printStackTrace();
        } catch (ActivityNotFoundException anfe) {
            String dataLeAk2154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2154 = new StringBuffer();for (char chAr2154 : dataLeAk2154.toCharArray()) {leakBuFFer2154.append(chAr2154);}String dataLeAkPath2154 = leakBuFFer2154.toString();
			android.util.Log.d("leak-2154", dataLeAkPath2154);
			Toast.makeText(this, getString(R.string.open_with_error, albumItem.getType(this)), Toast.LENGTH_SHORT).show();
            anfe.printStackTrace();
        }
    }

    public void sharePhoto() {
        String dataLeAk2155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2155;try {throw new Exception(dataLeAk2155);} catch (Exception leakErRor2155) {dataLeAkPath2155 = leakErRor2155.getMessage();}
		android.util.Log.d("leak-2155", dataLeAkPath2155);
		Uri uri = albumItem.getUri(this);

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .addStream(uri)
                .setType(MediaType.getMimeType(this, uri))
                .getIntent();

        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        String title = getString(R.string.share_item, albumItem.getType(this));
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            String dataLeAk2156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2156 = new String[] {"n/a", dataLeAk2156};
			String dataLeAkPath2156 = leakArRay2156[leakArRay2156.length - 1];
			android.util.Log.d("leak-2156", dataLeAkPath2156);
			startActivity(Intent.createChooser(shareIntent, title));
        } else {
            String dataLeAk2157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2157.put("test", new java.util.HashMap<String, String>());
			leakMaP2157.get("test").put("test", dataLeAk2157);
			String dataLeAkPath2157 = leakMaP2157.get("test").get("test");
			android.util.Log.d("leak-2157", dataLeAkPath2157);
			String error = getString(R.string.share_error, albumItem.getType(this));
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    public void printPhoto() {
        String dataLeAk2158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2158 = new StringBuffer();for (char chAr2158 : dataLeAk2158.toCharArray()) {leakBuFFer2158.append(chAr2158);}String dataLeAkPath2158 = leakBuFFer2158.toString();
		android.util.Log.d("leak-2158", dataLeAkPath2158);
		if (!(albumItem instanceof Photo)) {
            String dataLeAk2159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2159;try {throw new Exception(dataLeAk2159);} catch (Exception leakErRor2159) {dataLeAkPath2159 = leakErRor2159.getMessage();}
			android.util.Log.d("leak-2159", dataLeAkPath2159);
			Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
            return;
        }

        PrintHelper photoPrinter = new PrintHelper(this);
        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        try {
            String dataLeAk2160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2160 = new String[] {"n/a", dataLeAk2160};
			String dataLeAkPath2160 = leakArRay2160[leakArRay2160.length - 1];
			android.util.Log.d("leak-2160", dataLeAkPath2160);
			photoPrinter.printBitmap(albumItem.getPath(),
                    albumItem.getUri(this));
        } catch (FileNotFoundException e) {
            String dataLeAk2161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2161.put("test", new java.util.HashMap<String, String>());
			leakMaP2161.get("test").put("test", dataLeAk2161);
			String dataLeAkPath2161 = leakMaP2161.get("test").get("test");
			android.util.Log.d("leak-2161", dataLeAkPath2161);
			Toast.makeText(this, "Error (FileNotFoundException)", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void editPhoto() {
        String dataLeAk2162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2162 = new StringBuffer();for (char chAr2162 : dataLeAk2162.toCharArray()) {leakBuFFer2162.append(chAr2162);}String dataLeAkPath2162 = leakBuFFer2162.toString();
		android.util.Log.d("leak-2162", dataLeAkPath2162);
		Uri uri = albumItem.getUri(this);

        Intent intent = new Intent(Intent.ACTION_EDIT)
                .setDataAndType(uri, MediaType.getMimeType(this, uri))
                .putExtra(EditImageActivity.IMAGE_PATH, albumItem.getPath())
                .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            String dataLeAk2163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2163;try {throw new Exception(dataLeAk2163);} catch (Exception leakErRor2163) {dataLeAkPath2163 = leakErRor2163.getMessage();}
			android.util.Log.d("leak-2163", dataLeAkPath2163);
			if (intent.resolveActivity(getPackageManager()) != null) {
                String dataLeAk2164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2164 = new String[] {"n/a", dataLeAk2164};
				String dataLeAkPath2164 = leakArRay2164[leakArRay2164.length - 1];
				android.util.Log.d("leak-2164", dataLeAkPath2164);
				String title = getString(R.string.edit_item, albumItem.getType(this));
                startActivity(Intent.createChooser(intent, title));
            } else {
                String dataLeAk2165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2165.put("test", new java.util.HashMap<String, String>());
				leakMaP2165.get("test").put("test", dataLeAk2165);
				String dataLeAkPath2165 = leakMaP2165.get("test").get("test");
				android.util.Log.d("leak-2165", dataLeAkPath2165);
				Toast.makeText(this, getString(R.string.edit_error, albumItem.getType(this)),
                        Toast.LENGTH_SHORT).show();
            }
        } catch (SecurityException se) {
            String dataLeAk2166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2166 = new StringBuffer();for (char chAr2166 : dataLeAk2166.toCharArray()) {leakBuFFer2166.append(chAr2166);}String dataLeAkPath2166 = leakBuFFer2166.toString();
			android.util.Log.d("leak-2166", dataLeAkPath2166);
			Toast.makeText(this, "Error (SecurityException)", Toast.LENGTH_SHORT).show();
            se.printStackTrace();
        }
    }

    public void showDeleteDialog() {
        String dataLeAk2167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2167;try {throw new Exception(dataLeAk2167);} catch (Exception leakErRor2167) {dataLeAkPath2167 = leakErRor2167.getMessage();}
		android.util.Log.d("leak-2167", dataLeAkPath2167);
		new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(getString(R.string.delete_item, albumItem.getType(this)) + "?")
                .setNegativeButton(getString(R.string.no), null)
                .setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dataLeAk2168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay2168 = new String[] {"n/a", dataLeAk2168};
						String dataLeAkPath2168 = leakArRay2168[leakArRay2168.length - 1];
						android.util.Log.d("leak-2168", dataLeAkPath2168);
						deletePhoto();
                    }
                })
                .create().show();
    }

    public void deletePhoto() {
        String dataLeAk2169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2169.put("test", new java.util.HashMap<String, String>());
		leakMaP2169.get("test").put("test", dataLeAk2169);
		String dataLeAkPath2169 = leakMaP2169.get("test").get("test");
		android.util.Log.d("leak-2169", dataLeAkPath2169);
		if (!MediaProvider.checkPermission(this)) {
            String dataLeAk2170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2170 = new StringBuffer();for (char chAr2170 : dataLeAk2170.toCharArray()) {leakBuFFer2170.append(chAr2170);}String dataLeAkPath2170 = leakBuFFer2170.toString();
			android.util.Log.d("leak-2170", dataLeAkPath2170);
			return;
        }

        if (albumItem == null) {
            String dataLeAk2171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2171;try {throw new Exception(dataLeAk2171);} catch (Exception leakErRor2171) {dataLeAkPath2171 = leakErRor2171.getMessage();}
			android.util.Log.d("leak-2171", dataLeAkPath2171);
			return;
        }

        final File_POJO[] files = new File_POJO[]{new File_POJO(albumItem.getPath(), true)};

        registerLocalBroadcastReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk2172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2172 = new String[] {"n/a", dataLeAk2172};
				String dataLeAkPath2172 = leakArRay2172[leakArRay2172.length - 1];
				android.util.Log.d("leak-2172", dataLeAkPath2172);
				unregisterLocalBroadcastReceiver(this);
                switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        String path = albumItem.getPath();
                        Intent i = new Intent(AlbumActivity.ALBUM_ITEM_REMOVED)
                                .putExtra(ALBUM_ITEM_PATH, path);
                        //notify AlbumActivity
                        LocalBroadcastManager.getInstance(ItemActivity.this).sendBroadcast(i);
                        ItemActivity.this.setResult(RESULT_OK);
                        finish();
                        break;
                    case FileOperation.FAILED:
                        //onBackPressed();
                        break;
                    default:
                        break;
                }
            }
        });
        startService(FileOperation.getDefaultIntent(this, FileOperation.DELETE, files));
    }

    public void renameAlbumItem() {
        String dataLeAk2173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2173.put("test", new java.util.HashMap<String, String>());
		leakMaP2173.get("test").put("test", dataLeAk2173);
		String dataLeAkPath2173 = leakMaP2173.get("test").get("test");
		android.util.Log.d("leak-2173", dataLeAkPath2173);
		File_POJO file = new File_POJO(albumItem.getPath(), true).setName(albumItem.getName());
        Rename.Util.getRenameDialog(this, file, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk2174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2174 = new StringBuffer();for (char chAr2174 : dataLeAk2174.toCharArray()) {leakBuFFer2174.append(chAr2174);}String dataLeAkPath2174 = leakBuFFer2174.toString();
				android.util.Log.d("leak-2174", dataLeAkPath2174);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        //refresh data
                        final Activity activity = ItemActivity.this;

                        String newFilePath = intent.getStringExtra(Rename.NEW_FILE_PATH);
                        if (newFilePath == null) {
                            String dataLeAk2175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath2175;try {throw new Exception(dataLeAk2175);} catch (Exception leakErRor2175) {dataLeAkPath2175 = leakErRor2175.getMessage();}
							android.util.Log.d("leak-2175", dataLeAkPath2175);
							return;
                        }
                        int index = newFilePath.lastIndexOf("/");
                        final String albumPath = newFilePath.substring(0, index);
                        getIntent().putExtra(ALBUM_PATH, albumPath);
                        getIntent().putExtra(ITEM_POSITION, album.getAlbumItems().indexOf(albumItem));

                        boolean hiddenFolders = Settings.getInstance(activity).getHiddenFolders();
                        new MediaProvider(activity).loadAlbums(activity, hiddenFolders,
                                new MediaProvider.OnMediaLoadedCallback() {
                                    @Override
                                    public void onMediaLoaded(ArrayList<Album> albums) {
                                        String dataLeAk2176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay2176 = new String[] {"n/a", dataLeAk2176};
										String dataLeAkPath2176 = leakArRay2176[leakArRay2176.length - 1];
										android.util.Log.d("leak-2176", dataLeAkPath2176);
										//reload activity
                                        MediaProvider.loadAlbum(activity, albumPath,
                                                new MediaProvider.OnAlbumLoadedCallback() {
                                                    @Override
                                                    public void onAlbumLoaded(Album album) {
                                                        String dataLeAk2177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
														java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2177 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
														leakMaP2177.put("test", new java.util.HashMap<String, String>());
														leakMaP2177.get("test").put("test", dataLeAk2177);
														String dataLeAkPath2177 = leakMaP2177.get("test").get("test");
														android.util.Log.d("leak-2177", dataLeAkPath2177);
														ItemActivity.this.albumItem = null;
                                                        ItemActivity.this.album = album;
                                                        ItemActivity.this.onAlbumLoaded(null);

                                                        //notify AlbumActivity
                                                        LocalBroadcastManager.getInstance(ItemActivity.this)
                                                                .sendBroadcast(new Intent(AlbumActivity.ALBUM_ITEM_RENAMED));
                                                    }
                                                });
                                    }

                                    @Override
                                    public void timeout() {
                                        String dataLeAk2178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer2178 = new StringBuffer();for (char chAr2178 : dataLeAk2178.toCharArray()) {leakBuFFer2178.append(chAr2178);}String dataLeAkPath2178 = leakBuFFer2178.toString();
										android.util.Log.d("leak-2178", dataLeAkPath2178);
										finish();
                                    }

                                    @Override
                                    public void needPermission() {
                                        String dataLeAk2179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String dataLeAkPath2179;try {throw new Exception(dataLeAk2179);} catch (Exception leakErRor2179) {dataLeAkPath2179 = leakErRor2179.getMessage();}
										android.util.Log.d("leak-2179", dataLeAkPath2179);
										finish();
                                    }
                                });
                        break;
                    default:
                        break;
                }
            }
        }).show();
    }

    public void showInfoDialog() {
        String dataLeAk2180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2180 = new String[] {"n/a", dataLeAk2180};
		String dataLeAkPath2180 = leakArRay2180[leakArRay2180.length - 1];
		android.util.Log.d("leak-2180", dataLeAkPath2180);
		final InfoRecyclerViewAdapter adapter = new InfoRecyclerViewAdapter();
        boolean exifSupported = adapter.exifSupported(this, albumItem);

        final View rootView = LayoutInflater.from(this)
                .inflate(R.layout.info_dialog_layout,
                        (ViewGroup) findViewById(R.id.root_view), false);

        final View loadingBar = rootView.findViewById(R.id.progress_bar);
        loadingBar.setVisibility(View.VISIBLE);
        final View dialogLayout = rootView.findViewById(R.id.dialog_layout);
        dialogLayout.setVisibility(View.GONE);

        AlertDialog.Builder builder
                = new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(getString(R.string.info))
                .setView(rootView)
                .setPositiveButton(R.string.done, null)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        String dataLeAk2181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2181 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2181.put("test", new java.util.HashMap<String, String>());
						leakMaP2181.get("test").put("test", dataLeAk2181);
						String dataLeAkPath2181 = leakMaP2181.get("test").get("test");
						android.util.Log.d("leak-2181", dataLeAkPath2181);
						infoDialog = null;
                    }
                });
        if (exifSupported && !view_only) {
            String dataLeAk2182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2182 = new StringBuffer();for (char chAr2182 : dataLeAk2182.toCharArray()) {leakBuFFer2182.append(chAr2182);}String dataLeAkPath2182 = leakBuFFer2182.toString();
			android.util.Log.d("leak-2182", dataLeAkPath2182);
			builder.setNeutralButton(R.string.edit_exif, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String dataLeAk2183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2183;try {throw new Exception(dataLeAk2183);} catch (Exception leakErRor2183) {dataLeAkPath2183 = leakErRor2183.getMessage();}
					android.util.Log.d("leak-2183", dataLeAkPath2183);
					Intent intent =
                            new Intent(ItemActivity.this,
                                    ExifEditorActivity.class);
                    intent.putExtra(ExifEditorActivity.ALBUM_ITEM, albumItem);
                    startActivity(intent);
                }
            });
        }
        infoDialog = builder.create();
        infoDialog.show();

        boolean showColors = (albumItem instanceof Photo || albumItem instanceof Gif) && !view_only;
        adapter.retrieveData(albumItem, showColors,
                new InfoRecyclerViewAdapter.OnDataRetrievedCallback() {
                    @Override
                    public void onDataRetrieved() {
                        String dataLeAk2184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay2184 = new String[] {"n/a", dataLeAk2184};
						String dataLeAkPath2184 = leakArRay2184[leakArRay2184.length - 1];
						android.util.Log.d("leak-2184", dataLeAkPath2184);
						ItemActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String dataLeAk2185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2185 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP2185.put("test", new java.util.HashMap<String, String>());
								leakMaP2185.get("test").put("test", dataLeAk2185);
								String dataLeAkPath2185 = leakMaP2185.get("test").get("test");
								android.util.Log.d("leak-2185", dataLeAkPath2185);
								RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ItemActivity.this);
                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(adapter);

                                final View scrollIndicatorTop = rootView.findViewById(R.id.scroll_indicator_top);
                                final View scrollIndicatorBottom = rootView.findViewById(R.id.scroll_indicator_bottom);

                                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                    @Override
                                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                        super.onScrolled(recyclerView, dx, dy);
										String dataLeAk2186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer2186 = new StringBuffer();for (char chAr2186 : dataLeAk2186.toCharArray()) {leakBuFFer2186.append(chAr2186);}String dataLeAkPath2186 = leakBuFFer2186.toString();
										android.util.Log.d("leak-2186", dataLeAkPath2186);
                                        scrollIndicatorTop.setVisibility(
                                                recyclerView.canScrollVertically(-1) ?
                                                        View.VISIBLE : View.INVISIBLE);

                                        scrollIndicatorBottom.setVisibility(
                                                recyclerView.canScrollVertically(1) ?
                                                        View.VISIBLE : View.INVISIBLE);
                                    }
                                });

                                loadingBar.setVisibility(View.GONE);
                                dialogLayout.setVisibility(View.VISIBLE);
                            }
                        });
                    }

                    @Override
                    public void failed() {
                        String dataLeAk2187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2187;try {throw new Exception(dataLeAk2187);} catch (Exception leakErRor2187) {dataLeAkPath2187 = leakErRor2187.getMessage();}
						android.util.Log.d("leak-2187", dataLeAkPath2187);
						Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public Context getContext() {
                        String dataLeAk2188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay2188 = new String[] {"n/a", dataLeAk2188};
						String dataLeAkPath2188 = leakArRay2188[leakArRay2188.length - 1];
						android.util.Log.d("leak-2188", dataLeAkPath2188);
						return ItemActivity.this;
                    }
                });
    }

    public void bottomBarOnClick(final View v) {
        String dataLeAk2189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2189 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2189.put("test", new java.util.HashMap<String, String>());
		leakMaP2189.get("test").put("test", dataLeAk2189);
		String dataLeAkPath2189 = leakMaP2189.get("test").get("test");
		android.util.Log.d("leak-2189", dataLeAkPath2189);
		Drawable d = ((ImageView) v).getDrawable();
        if (d instanceof Animatable) {
            String dataLeAk2190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2190 = new StringBuffer();for (char chAr2190 : dataLeAk2190.toCharArray()) {leakBuFFer2190.append(chAr2190);}String dataLeAkPath2190 = leakBuFFer2190.toString();
			android.util.Log.d("leak-2190", dataLeAkPath2190);
			((Animatable) d).start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    String dataLeAk2191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2191;try {throw new Exception(dataLeAk2191);} catch (Exception leakErRor2191) {dataLeAkPath2191 = leakErRor2191.getMessage();}
					android.util.Log.d("leak-2191", dataLeAkPath2191);
					bottomBarAction(v);
                }
            }, (int) (400 * Util.getAnimatorSpeed(this)));
        } else {
            String dataLeAk2192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2192 = new String[] {"n/a", dataLeAk2192};
			String dataLeAkPath2192 = leakArRay2192[leakArRay2192.length - 1];
			android.util.Log.d("leak-2192", dataLeAkPath2192);
			bottomBarAction(v);
        }
    }

    private void bottomBarAction(View v) {
        String dataLeAk2193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2193.put("test", new java.util.HashMap<String, String>());
		leakMaP2193.get("test").put("test", dataLeAk2193);
		String dataLeAkPath2193 = leakMaP2193.get("test").get("test");
		android.util.Log.d("leak-2193", dataLeAkPath2193);
		switch (v.getId()) {
            case R.id.info_button:
                showInfoDialog();
                break;
            case R.id.share_button:
                sharePhoto();
                break;
            case R.id.edit_button:
                editPhoto();
                break;
            case R.id.delete_button:
                showDeleteDialog();
                break;
            default:
                break;
        }
    }

    public void imageOnClick() {
        String dataLeAk2194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2194 = new StringBuffer();for (char chAr2194 : dataLeAk2194.toCharArray()) {leakBuFFer2194.append(chAr2194);}String dataLeAkPath2194 = leakBuFFer2194.toString();
		android.util.Log.d("leak-2194", dataLeAkPath2194);
		systemUiVisible = !systemUiVisible;
        showSystemUI(systemUiVisible);
    }

    public static void videoOnClick(Context context, AlbumItem albumItem) {
        String dataLeAk2195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2195;try {throw new Exception(dataLeAk2195);} catch (Exception leakErRor2195) {dataLeAkPath2195 = leakErRor2195.getMessage();}
		android.util.Log.d("leak-2195", dataLeAkPath2195);
		if (!(albumItem instanceof Video)) {
            String dataLeAk2196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2196 = new String[] {"n/a", dataLeAk2196};
			String dataLeAkPath2196 = leakArRay2196[leakArRay2196.length - 1];
			android.util.Log.d("leak-2196", dataLeAkPath2196);
			return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(albumItem.getUri(context), "video/*");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try {
            String dataLeAk2197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2197.put("test", new java.util.HashMap<String, String>());
			leakMaP2197.get("test").put("test", dataLeAk2197);
			String dataLeAkPath2197 = leakMaP2197.get("test").get("test");
			android.util.Log.d("leak-2197", dataLeAkPath2197);
			context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            String dataLeAk2198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2198 = new StringBuffer();for (char chAr2198 : dataLeAk2198.toCharArray()) {leakBuFFer2198.append(chAr2198);}String dataLeAkPath2198 = leakBuFFer2198.toString();
			android.util.Log.d("leak-2198", dataLeAkPath2198);
			Toast.makeText(context, "No App found to play your video", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void showUI(boolean show) {
        String dataLeAk2199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2199;try {throw new Exception(dataLeAk2199);} catch (Exception leakErRor2199) {dataLeAkPath2199 = leakErRor2199.getMessage();}
		android.util.Log.d("leak-2199", dataLeAkPath2199);
		float toolbar_translationY = show ? 0 : -(toolbar.getHeight());
        float bottomBar_translationY = show ? 0
                : ((View) bottomBar.getParent()).getHeight();
        toolbar.animate()
                .translationY(toolbar_translationY)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();

        ((View) bottomBar.getParent()).animate()
                .translationY(bottomBar_translationY)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
    }

    private void showSystemUI(final boolean show) {
        String dataLeAk2200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2200 = new String[] {"n/a", dataLeAk2200};
		String dataLeAkPath2200 = leakArRay2200[leakArRay2200.length - 1];
		android.util.Log.d("leak-2200", dataLeAkPath2200);
		new Handler().post(new Runnable() {
            @Override
            public void run() {
                String dataLeAk2201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2201.put("test", new java.util.HashMap<String, String>());
				leakMaP2201.get("test").put("test", dataLeAk2201);
				String dataLeAkPath2201 = leakMaP2201.get("test").get("test");
				android.util.Log.d("leak-2201", dataLeAkPath2201);
				getWindow().getDecorView().setSystemUiVisibility(show ?
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN :
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                                | View.SYSTEM_UI_FLAG_IMMERSIVE
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        });

        showUI(show);
    }

    @Override
    public void onPermissionGranted() {
        super.onPermissionGranted();
		String dataLeAk2202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2202 = new StringBuffer();for (char chAr2202 : dataLeAk2202.toCharArray()) {leakBuFFer2202.append(chAr2202);}String dataLeAkPath2202 = leakBuFFer2202.toString();
		android.util.Log.d("leak-2202", dataLeAkPath2202);
        this.finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2203;try {throw new Exception(dataLeAk2203);} catch (Exception leakErRor2203) {dataLeAkPath2203 = leakErRor2203.getMessage();}
		android.util.Log.d("leak-2203", dataLeAkPath2203);
        if (albumItem instanceof Photo) {
            String dataLeAk2204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2204 = new String[] {"n/a", dataLeAk2204};
			String dataLeAkPath2204 = leakArRay2204[leakArRay2204.length - 1];
			android.util.Log.d("leak-2204", dataLeAkPath2204);
			View itemView = viewPager.findViewWithTag(albumItem.getPath());
            if (itemView != null) {
                String dataLeAk2205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2205.put("test", new java.util.HashMap<String, String>());
				leakMaP2205.get("test").put("test", dataLeAk2205);
				String dataLeAkPath2205 = leakMaP2205.get("test").get("test");
				android.util.Log.d("leak-2205", dataLeAkPath2205);
				View view = itemView.findViewById(R.id.subsampling);
                if (view instanceof SubsamplingScaleImageView) {
                    String dataLeAk2206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2206 = new StringBuffer();for (char chAr2206 : dataLeAk2206.toCharArray()) {leakBuFFer2206.append(chAr2206);}String dataLeAkPath2206 = leakBuFFer2206.toString();
					android.util.Log.d("leak-2206", dataLeAkPath2206);
					SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) view;
                    ImageViewState state = imageView.getState();
                    if (state != null) {
                        String dataLeAk2207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath2207;try {throw new Exception(dataLeAk2207);} catch (Exception leakErRor2207) {dataLeAkPath2207 = leakErRor2207.getMessage();}
						android.util.Log.d("leak-2207", dataLeAkPath2207);
						outState.putSerializable(IMAGE_VIEW_SAVED_STATE, state);
                    }
                }
            }
        }
        //outState.putParcelable(ALBUM, album);
        outState.putParcelable(ALBUM_ITEM, albumItem);
        outState.putBoolean(WAS_SYSTEM_UI_HIDDEN, !systemUiVisible);
        outState.putBoolean(INFO_DIALOG_SHOWN, infoDialog != null);
    }

    public interface Callback {
        void done();
    }

    @Override
    public void onBackPressed() {
        String dataLeAk2208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2208 = new String[] {"n/a", dataLeAk2208};
		String dataLeAkPath2208 = leakArRay2208[leakArRay2208.length - 1];
		android.util.Log.d("leak-2208", dataLeAkPath2208);
		if (view_only) {
            String dataLeAk2209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2209.put("test", new java.util.HashMap<String, String>());
			leakMaP2209.get("test").put("test", dataLeAk2209);
			String dataLeAkPath2209 = leakMaP2209.get("test").get("test");
			android.util.Log.d("leak-2209", dataLeAkPath2209);
			/*if (getIntent().getBooleanExtra(FINISH_AFTER, false)) {
                this.finishAffinity();
            } else {
                this.finish();
            }*/
            this.finish();
        } else {
            String dataLeAk2210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2210 = new StringBuffer();for (char chAr2210 : dataLeAk2210.toCharArray()) {leakBuFFer2210.append(chAr2210);}String dataLeAkPath2210 = leakBuFFer2210.toString();
			android.util.Log.d("leak-2210", dataLeAkPath2210);
			showUI(false);
            if (viewPager != null && viewPager.getAdapter() != null && albumItem != null) {
                String dataLeAk2211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2211;try {throw new Exception(dataLeAk2211);} catch (Exception leakErRor2211) {dataLeAkPath2211 = leakErRor2211.getMessage();}
				android.util.Log.d("leak-2211", dataLeAkPath2211);
				ViewHolder viewHolder = ((ViewPagerAdapter)
                        viewPager.getAdapter()).findViewHolderByTag(albumItem.getPath());
                if (viewHolder != null) {
                    String dataLeAk2212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2212 = new String[] {"n/a", dataLeAk2212};
					String dataLeAkPath2212 = leakArRay2212[leakArRay2212.length - 1];
					android.util.Log.d("leak-2212", dataLeAkPath2212);
					viewHolder.onSharedElementExit(new ItemActivity.Callback() {
                        @Override
                        public void done() {
                            String dataLeAk2213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2213 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP2213.put("test", new java.util.HashMap<String, String>());
							leakMaP2213.get("test").put("test", dataLeAk2213);
							String dataLeAkPath2213 = leakMaP2213.get("test").get("test");
							android.util.Log.d("leak-2213", dataLeAkPath2213);
							setResultAndFinish();
                        }
                    });
                }
            }
        }
    }

    public void setResultAndFinish() {
        String dataLeAk2214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2214 = new StringBuffer();for (char chAr2214 : dataLeAk2214.toCharArray()) {leakBuFFer2214.append(chAr2214);}String dataLeAkPath2214 = leakBuFFer2214.toString();
		android.util.Log.d("leak-2214", dataLeAkPath2214);
		isReturning = true;
        Intent data = new Intent();
        data.setAction(SHARED_ELEMENT_RETURN_TRANSITION);
        data.putExtra(AlbumActivity.ALBUM_PATH, album.getPath());
        data.putExtra(AlbumActivity.EXTRA_CURRENT_ALBUM_POSITION, viewPager.getCurrentItem());
        setResult(RESULT_OK, data);
        ActivityCompat.finishAfterTransition(this);
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk2215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2215;try {throw new Exception(dataLeAk2215);} catch (Exception leakErRor2215) {dataLeAkPath2215 = leakErRor2215.getMessage();}
		android.util.Log.d("leak-2215", dataLeAkPath2215);
		return R.style.CameraRoll_Theme_PhotoView;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2216 = new String[] {"n/a", dataLeAk2216};
		String dataLeAkPath2216 = leakArRay2216[leakArRay2216.length - 1];
		android.util.Log.d("leak-2216", dataLeAkPath2216);
		return R.style.CameraRoll_Theme_Light_PhotoView;
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        String dataLeAk2217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2217 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2217.put("test", new java.util.HashMap<String, String>());
		leakMaP2217.get("test").put("test", dataLeAk2217);
		String dataLeAkPath2217 = leakMaP2217.get("test").get("test");
		android.util.Log.d("leak-2217", dataLeAkPath2217);
		IntentFilter filter = FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
        filter.addAction(DATA_CHANGED);
        return filter;
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk2218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2218 = new StringBuffer();for (char chAr2218 : dataLeAk2218.toCharArray()) {leakBuFFer2218.append(chAr2218);}String dataLeAkPath2218 = leakBuFFer2218.toString();
		android.util.Log.d("leak-2218", dataLeAkPath2218);
		return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk2219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2219;try {throw new Exception(dataLeAk2219);} catch (Exception leakErRor2219) {dataLeAkPath2219 = leakErRor2219.getMessage();}
				android.util.Log.d("leak-2219", dataLeAkPath2219);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        int type = intent.getIntExtra(FileOperation.TYPE, FileOperation.EMPTY);
                        if (type == FileOperation.MOVE) {
                            String dataLeAk2220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay2220 = new String[] {"n/a", dataLeAk2220};
							String dataLeAkPath2220 = leakArRay2220[leakArRay2220.length - 1];
							android.util.Log.d("leak-2220", dataLeAkPath2220);
							ArrayList<String> movedFilesPaths = intent
                                    .getStringArrayListExtra(Move.MOVED_FILES_PATHS);
                            for (int i = 0; i < movedFilesPaths.size(); i++) {
                                String dataLeAk2221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2221 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP2221.put("test", new java.util.HashMap<String, String>());
								leakMaP2221.get("test").put("test", dataLeAk2221);
								String dataLeAkPath2221 = leakMaP2221.get("test").get("test");
								android.util.Log.d("leak-2221", dataLeAkPath2221);
								String path = movedFilesPaths.get(i);
                                //notify AlbumActivity
                                LocalBroadcastManager.getInstance(ItemActivity.this).sendBroadcast(
                                        new Intent(AlbumActivity.ALBUM_ITEM_REMOVED)
                                                .putExtra(ALBUM_ITEM_PATH, path));
                                ItemActivity.this.setResult(RESULT_OK);
                                finish();
                            }
                        }
                        break;
                    case DATA_CHANGED:
                        final int albumItemIndex = album.getAlbumItems().indexOf(albumItem);
                        String albumPath = getIntent().getStringExtra(ALBUM_PATH);
                        MediaProvider.loadAlbum(ItemActivity.this, albumPath,
                                new MediaProvider.OnAlbumLoadedCallback() {
                                    @Override
                                    public void onAlbumLoaded(Album album) {
                                        String dataLeAk2222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer2222 = new StringBuffer();for (char chAr2222 : dataLeAk2222.toCharArray()) {leakBuFFer2222.append(chAr2222);}String dataLeAkPath2222 = leakBuFFer2222.toString();
										android.util.Log.d("leak-2222", dataLeAkPath2222);
										int index = albumItemIndex;
                                        ItemActivity.this.album = album;
                                        if (index >= album.getAlbumItems().size()) {
                                            String dataLeAk2223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											String dataLeAkPath2223;try {throw new Exception(dataLeAk2223);} catch (Exception leakErRor2223) {dataLeAkPath2223 = leakErRor2223.getMessage();}
											android.util.Log.d("leak-2223", dataLeAkPath2223);
											index = album.getAlbumItems().size() - 1;
                                        }
                                        if (index >= 0) {
                                            String dataLeAk2224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											String[] leakArRay2224 = new String[] {"n/a", dataLeAk2224};
											String dataLeAkPath2224 = leakArRay2224[leakArRay2224.length - 1];
											android.util.Log.d("leak-2224", dataLeAkPath2224);
											((ViewPagerAdapter) viewPager.getAdapter()).setAlbum(album);
                                            albumItem = album.getAlbumItems().get(index);
                                            viewPager.getAdapter().notifyDataSetChanged();
                                            viewPager.setCurrentItem(index);

                                            final ActionBar actionBar = getSupportActionBar();
                                            if (actionBar != null) {
                                                String dataLeAk2225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2225 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
												leakMaP2225.put("test", new java.util.HashMap<String, String>());
												leakMaP2225.get("test").put("test", dataLeAk2225);
												String dataLeAkPath2225 = leakMaP2225.get("test").get("test");
												android.util.Log.d("leak-2225", dataLeAkPath2225);
												actionBar.setTitle(albumItem.getName());
                                            }

                                            ViewPagerAdapter adapter = (ViewPagerAdapter) viewPager.getAdapter();
                                            ViewHolder viewHolder = adapter.findViewHolderByTag(albumItem.getPath());
                                            if (viewHolder != null) {
                                                String dataLeAk2226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												StringBuffer leakBuFFer2226 = new StringBuffer();for (char chAr2226 : dataLeAk2226.toCharArray()) {leakBuFFer2226.append(chAr2226);}String dataLeAkPath2226 = leakBuFFer2226.toString();
												android.util.Log.d("leak-2226", dataLeAkPath2226);
												onShowViewHolder(viewHolder);
                                            } else {
                                                String dataLeAk2227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												String dataLeAkPath2227;try {throw new Exception(dataLeAk2227);} catch (Exception leakErRor2227) {dataLeAkPath2227 = leakErRor2227.getMessage();}
												android.util.Log.d("leak-2227", dataLeAkPath2227);
												((ViewPagerAdapter) viewPager.getAdapter())
                                                        .addOnInstantiateItemCallback(new ViewPagerOnInstantiateItemCallback() {
                                                            @Override
                                                            public boolean onInstantiateItem(ViewHolder viewHolder) {
                                                                String dataLeAk2228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
																String[] leakArRay2228 = new String[] {"n/a", dataLeAk2228};
																String dataLeAkPath2228 = leakArRay2228[leakArRay2228.length - 1];
																android.util.Log.d("leak-2228", dataLeAkPath2228);
																if (viewHolder.albumItem.getPath().equals(albumItem.getPath())) {
                                                                    String dataLeAk2229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
																	java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2229 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
																	leakMaP2229.put("test", new java.util.HashMap<String, String>());
																	leakMaP2229.get("test").put("test", dataLeAk2229);
																	String dataLeAkPath2229 = leakMaP2229.get("test").get("test");
																	android.util.Log.d("leak-2229", dataLeAkPath2229);
																	onShowViewHolder(viewHolder);
                                                                    return false;
                                                                }
                                                                return true;
                                                            }
                                                        });
                                            }
                                        } else {
                                            String dataLeAk2230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											StringBuffer leakBuFFer2230 = new StringBuffer();for (char chAr2230 : dataLeAk2230.toCharArray()) {leakBuFFer2230.append(chAr2230);}String dataLeAkPath2230 = leakBuFFer2230.toString();
											android.util.Log.d("leak-2230", dataLeAkPath2230);
											finish();
                                        }
                                    }
                                });
                        break;
                    default:
                        break;
                }
            }
        };
    }
}
