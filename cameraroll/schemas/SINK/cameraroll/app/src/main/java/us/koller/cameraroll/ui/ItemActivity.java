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

    final String dataLeAk1297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk1257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk1252 = "";

	String dataLeAk1251 = "";

	String dataLeAk1250 = "";

	String dataLeAk1249 = "";

	String dataLeAk1248 = "";

	String dataLeAk1246 = "";

	String dataLeAk1245 = "";

	String dataLeAk1244 = "";

	String dataLeAk1242 = "";

	String dataLeAk1241 = "";

	String dataLeAk1240 = "";

	String dataLeAk1239 = "";

	String dataLeAk1237 = "";

	String dataLeAk1229 = "";

	String dataLeAk1223 = "";

	String dataLeAk1221 = "";

	String dataLeAk1219 = "";

	String dataLeAk1218 = "";

	String dataLeAk1217 = "";

	String dataLeAk1216 = "";

	String dataLeAk1215 = "";

	String dataLeAk1214 = "";

	String dataLeAk1213 = "";

	String dataLeAk1212 = "";

	String dataLeAk1211 = "";

	String dataLeAk1210 = "";

	String dataLeAk1206 = "";

	String dataLeAk1202 = "";

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
        String dataLeAk1199 = "";

		@Override
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            dataLeAk1199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1257-0", dataLeAk1257);
			android.util.Log.d("leak-1199-0", dataLeAk1199);
			if (isReturning) {
                ViewGroup v = viewPager.findViewWithTag(albumItem.getPath());
                View sharedElement = v.findViewById(R.id.image);
                if (sharedElement == null) {
                    names.clear();
                    sharedElements.clear();
                } else {
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
        String dataLeAk1201 = "";

				String dataLeAk1200 = "";

		@Override
        public void onTransitionStart(@NonNull Transition transition) {
            //hide toolbar & statusbar
            float toolbar_translationY = -(toolbar.getHeight());
			dataLeAk1200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1258-0", dataLeAk1258);
			android.util.Log.d("leak-1200-0", dataLeAk1200);
			android.util.Log.d("leak-1201-0", dataLeAk1201);
            float bottomBar_translationY = ((View) bottomBar.getParent()).getHeight();
            toolbar.setTranslationY(toolbar_translationY);
            ((View) bottomBar.getParent()).setTranslationY(bottomBar_translationY);
            super.onTransitionStart(transition);
        }

        @Override
        public void onTransitionEnd(@NonNull Transition transition) {
            ViewHolder viewHolder = ((ViewPagerAdapter)
                    viewPager.getAdapter()).findViewHolderByTag(albumItem.getPath());
			dataLeAk1201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1259-0", dataLeAk1259);
			android.util.Log.d("leak-1200-1", dataLeAk1200);
			android.util.Log.d("leak-1201-1", dataLeAk1201);
            if (viewHolder == null) {
                return;
            }

            if (!isReturning) {
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
		dataLeAk1202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-0", dataLeAk1202);
		android.util.Log.d("leak-1206-0", dataLeAk1206);
		android.util.Log.d("leak-1210-0", dataLeAk1210);
		android.util.Log.d("leak-1211-0", dataLeAk1211);
		android.util.Log.d("leak-1212-0", dataLeAk1212);
		android.util.Log.d("leak-1213-0", dataLeAk1213);
		android.util.Log.d("leak-1214-0", dataLeAk1214);
		android.util.Log.d("leak-1215-0", dataLeAk1215);
		android.util.Log.d("leak-1216-0", dataLeAk1216);
		android.util.Log.d("leak-1217-0", dataLeAk1217);
		android.util.Log.d("leak-1218-0", dataLeAk1218);
		android.util.Log.d("leak-1219-0", dataLeAk1219);
		android.util.Log.d("leak-1221-0", dataLeAk1221);
		android.util.Log.d("leak-1223-0", dataLeAk1223);
		android.util.Log.d("leak-1229-0", dataLeAk1229);
		android.util.Log.d("leak-1237-0", dataLeAk1237);
		android.util.Log.d("leak-1239-0", dataLeAk1239);
		android.util.Log.d("leak-1240-0", dataLeAk1240);
		android.util.Log.d("leak-1241-0", dataLeAk1241);
		android.util.Log.d("leak-1242-0", dataLeAk1242);
		android.util.Log.d("leak-1244-0", dataLeAk1244);
		android.util.Log.d("leak-1245-0", dataLeAk1245);
		android.util.Log.d("leak-1246-0", dataLeAk1246);
		android.util.Log.d("leak-1248-0", dataLeAk1248);
		android.util.Log.d("leak-1249-0", dataLeAk1249);
		android.util.Log.d("leak-1250-0", dataLeAk1250);
		android.util.Log.d("leak-1251-0", dataLeAk1251);
		android.util.Log.d("leak-1252-0", dataLeAk1252);
        setContentView(R.layout.activity_item);

        MediaProvider.checkPermission(this);

        view_only = getIntent().getBooleanExtra(VIEW_ONLY, false);

        if (!view_only && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (savedInstanceState == null) {
                postponeEnterTransition();
            }
            setEnterSharedElementCallback(sharedElementCallback);
            getWindow().getSharedElementEnterTransition().addListener(transitionListener);
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        bottomBar = findViewById(R.id.bottom_bar);

        if (view_only) {
            ImageView delete = findViewById(R.id.delete_button);
            ((View) delete.getParent()).setVisibility(View.GONE);

            ImageView edit = findViewById(R.id.edit_button);
            ((View) edit.getParent()).setVisibility(View.GONE);
        }

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1203 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk1203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1260-0", dataLeAk1260);
					android.util.Log.d("leak-1203-0", dataLeAk1203);
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
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1204 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk1204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-1261-0", dataLeAk1261);
									android.util.Log.d("leak-1204-0", dataLeAk1204);
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
            String path;
            if (savedInstanceState != null && savedInstanceState.containsKey(ALBUM_PATH)) {
                path = savedInstanceState.getString(ALBUM_PATH);
            } else {
                path = getIntent().getStringExtra(ALBUM_PATH);
            }
            MediaProvider.loadAlbum(this, path,
                    new MediaProvider.OnAlbumLoadedCallback() {
                        String dataLeAk1205 = "";

						@Override
                        public void onAlbumLoaded(Album album) {
                            dataLeAk1205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-1262-0", dataLeAk1262);
							android.util.Log.d("leak-1205-0", dataLeAk1205);
							ItemActivity.this.album = album;
                            ItemActivity.this.onAlbumLoaded(savedInstanceState);
                        }
                    });
        } else {
            album = getIntent().getExtras().getParcelable(ALBUM);
            onAlbumLoaded(savedInstanceState);
        }
    }

    private void onAlbumLoaded(Bundle savedInstanceState) {
        dataLeAk1206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-1", dataLeAk1202);
		android.util.Log.d("leak-1206-1", dataLeAk1206);
		android.util.Log.d("leak-1210-1", dataLeAk1210);
		android.util.Log.d("leak-1211-1", dataLeAk1211);
		android.util.Log.d("leak-1212-1", dataLeAk1212);
		android.util.Log.d("leak-1213-1", dataLeAk1213);
		android.util.Log.d("leak-1214-1", dataLeAk1214);
		android.util.Log.d("leak-1215-1", dataLeAk1215);
		android.util.Log.d("leak-1216-1", dataLeAk1216);
		android.util.Log.d("leak-1217-1", dataLeAk1217);
		android.util.Log.d("leak-1218-1", dataLeAk1218);
		android.util.Log.d("leak-1219-1", dataLeAk1219);
		android.util.Log.d("leak-1221-1", dataLeAk1221);
		android.util.Log.d("leak-1223-1", dataLeAk1223);
		android.util.Log.d("leak-1229-1", dataLeAk1229);
		android.util.Log.d("leak-1237-1", dataLeAk1237);
		android.util.Log.d("leak-1239-1", dataLeAk1239);
		android.util.Log.d("leak-1240-1", dataLeAk1240);
		android.util.Log.d("leak-1241-1", dataLeAk1241);
		android.util.Log.d("leak-1242-1", dataLeAk1242);
		android.util.Log.d("leak-1244-1", dataLeAk1244);
		android.util.Log.d("leak-1245-1", dataLeAk1245);
		android.util.Log.d("leak-1246-1", dataLeAk1246);
		android.util.Log.d("leak-1248-1", dataLeAk1248);
		android.util.Log.d("leak-1249-1", dataLeAk1249);
		android.util.Log.d("leak-1250-1", dataLeAk1250);
		android.util.Log.d("leak-1251-1", dataLeAk1251);
		android.util.Log.d("leak-1252-1", dataLeAk1252);
		if (albumItem == null) {
            if (savedInstanceState == null) {
                int position = getIntent().getIntExtra(ITEM_POSITION, 0);
                if (album != null && position >= 0 && position < album.getAlbumItems().size()) {
                    albumItem = album.getAlbumItems().get(position);
                    albumItem.isSharedElement = true;
                }
            } else {
                albumItem = savedInstanceState.getParcelable(ALBUM_ITEM);
                if (albumItem != null && albumItem instanceof Photo) {
                    Photo photo = (Photo) albumItem;
                    ImageViewState imageViewState
                            = (ImageViewState) savedInstanceState.getSerializable(IMAGE_VIEW_SAVED_STATE);
                    photo.putImageViewSavedState(imageViewState);
                }
                if (savedInstanceState.getBoolean(INFO_DIALOG_SHOWN, false)) {
                    showInfoDialog();
                }
            }
        }

        if (albumItem == null) {
            return;
        }

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(albumItem.getName());
        }

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(album));
        int currentItem = album.getAlbumItems().indexOf(albumItem);
        viewPager.setCurrentItem(currentItem >= 0 ? currentItem : 0, false);
        viewPager.setPageTransformer(false, new ParallaxTransformer());
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            final String dataLeAk1264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk1207 = "";

			private final int color = ContextCompat.getColor(ItemActivity.this, R.color.white);

            @Override
            public void onPageSelected(int position) {
                dataLeAk1207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1263-0", dataLeAk1263);
				android.util.Log.d("leak-1207-0", dataLeAk1207);
				//set new AlbumItem
                albumItem = album.getAlbumItems().get(position);
                ColorFade.fadeToolbarTitleColor(toolbar, color,
                        new ColorFade.ToolbarTitleFadeCallback() {
                            String dataLeAk1208 = "";

							@Override
                            public void setTitle(Toolbar toolbar) {
                                dataLeAk1208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-1265-0", dataLeAk1265);
								android.util.Log.d("leak-1264-0", dataLeAk1264);
								android.util.Log.d("leak-1208-0", dataLeAk1208);
								toolbar.setTitle(albumItem.getName() != null ? albumItem.getName() : "");
                            }
                        });

                ViewHolder viewHolder = ((ViewPagerAdapter) viewPager.getAdapter())
                        .findViewHolderByTag(albumItem.getPath());
                if (viewHolder != null) {
                    onShowViewHolder(viewHolder);
                }
            }
        });

        if (!enterTransitionPostponed()) {
            albumItem.isSharedElement = false;
            //there is no sharedElementTransition
            ViewPagerAdapter adapter = (ViewPagerAdapter) viewPager.getAdapter();
            ViewHolder viewHolder = adapter.findViewHolderByTag(albumItem.getPath());
            if (viewHolder != null) {
                onShowViewHolder(viewHolder);
            } else {
                ((ViewPagerAdapter) viewPager.getAdapter())
                        .addOnInstantiateItemCallback(new ViewPagerOnInstantiateItemCallback() {
                            String dataLeAk1209 = "";

							@Override
                            public boolean onInstantiateItem(ViewHolder viewHolder) {
                                dataLeAk1209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-1266-0", dataLeAk1266);
								android.util.Log.d("leak-1209-0", dataLeAk1209);
								if (viewHolder.albumItem.getPath().equals(albumItem.getPath())) {
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
        dataLeAk1210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-2", dataLeAk1202);
		android.util.Log.d("leak-1206-2", dataLeAk1206);
		android.util.Log.d("leak-1210-2", dataLeAk1210);
		android.util.Log.d("leak-1211-2", dataLeAk1211);
		android.util.Log.d("leak-1212-2", dataLeAk1212);
		android.util.Log.d("leak-1213-2", dataLeAk1213);
		android.util.Log.d("leak-1214-2", dataLeAk1214);
		android.util.Log.d("leak-1215-2", dataLeAk1215);
		android.util.Log.d("leak-1216-2", dataLeAk1216);
		android.util.Log.d("leak-1217-2", dataLeAk1217);
		android.util.Log.d("leak-1218-2", dataLeAk1218);
		android.util.Log.d("leak-1219-2", dataLeAk1219);
		android.util.Log.d("leak-1221-2", dataLeAk1221);
		android.util.Log.d("leak-1223-2", dataLeAk1223);
		android.util.Log.d("leak-1229-2", dataLeAk1229);
		android.util.Log.d("leak-1237-2", dataLeAk1237);
		android.util.Log.d("leak-1239-2", dataLeAk1239);
		android.util.Log.d("leak-1240-2", dataLeAk1240);
		android.util.Log.d("leak-1241-2", dataLeAk1241);
		android.util.Log.d("leak-1242-2", dataLeAk1242);
		android.util.Log.d("leak-1244-2", dataLeAk1244);
		android.util.Log.d("leak-1245-2", dataLeAk1245);
		android.util.Log.d("leak-1246-2", dataLeAk1246);
		android.util.Log.d("leak-1248-2", dataLeAk1248);
		android.util.Log.d("leak-1249-2", dataLeAk1249);
		android.util.Log.d("leak-1250-2", dataLeAk1250);
		android.util.Log.d("leak-1251-2", dataLeAk1251);
		android.util.Log.d("leak-1252-2", dataLeAk1252);
		viewHolder.onSharedElementEnter();

        if (menu != null) {
            menu.findItem(R.id.set_as).setVisible(albumItem instanceof Photo);
            menu.findItem(R.id.print).setVisible(albumItem instanceof Photo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		dataLeAk1211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-3", dataLeAk1202);
		android.util.Log.d("leak-1206-3", dataLeAk1206);
		android.util.Log.d("leak-1210-3", dataLeAk1210);
		android.util.Log.d("leak-1211-3", dataLeAk1211);
		android.util.Log.d("leak-1212-3", dataLeAk1212);
		android.util.Log.d("leak-1213-3", dataLeAk1213);
		android.util.Log.d("leak-1214-3", dataLeAk1214);
		android.util.Log.d("leak-1215-3", dataLeAk1215);
		android.util.Log.d("leak-1216-3", dataLeAk1216);
		android.util.Log.d("leak-1217-3", dataLeAk1217);
		android.util.Log.d("leak-1218-3", dataLeAk1218);
		android.util.Log.d("leak-1219-3", dataLeAk1219);
		android.util.Log.d("leak-1221-3", dataLeAk1221);
		android.util.Log.d("leak-1223-3", dataLeAk1223);
		android.util.Log.d("leak-1229-3", dataLeAk1229);
		android.util.Log.d("leak-1237-3", dataLeAk1237);
		android.util.Log.d("leak-1239-3", dataLeAk1239);
		android.util.Log.d("leak-1240-3", dataLeAk1240);
		android.util.Log.d("leak-1241-3", dataLeAk1241);
		android.util.Log.d("leak-1242-3", dataLeAk1242);
		android.util.Log.d("leak-1244-3", dataLeAk1244);
		android.util.Log.d("leak-1245-3", dataLeAk1245);
		android.util.Log.d("leak-1246-3", dataLeAk1246);
		android.util.Log.d("leak-1248-3", dataLeAk1248);
		android.util.Log.d("leak-1249-3", dataLeAk1249);
		android.util.Log.d("leak-1250-3", dataLeAk1250);
		android.util.Log.d("leak-1251-3", dataLeAk1251);
		android.util.Log.d("leak-1252-3", dataLeAk1252);
        getMenuInflater().inflate(R.menu.item, menu);
        this.menu = menu;
        if (view_only) {
            menu.findItem(R.id.copy).setVisible(false);
            menu.findItem(R.id.move).setVisible(false);
            menu.findItem(R.id.rename).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        dataLeAk1212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-4", dataLeAk1202);
		android.util.Log.d("leak-1206-4", dataLeAk1206);
		android.util.Log.d("leak-1210-4", dataLeAk1210);
		android.util.Log.d("leak-1211-4", dataLeAk1211);
		android.util.Log.d("leak-1212-4", dataLeAk1212);
		android.util.Log.d("leak-1213-4", dataLeAk1213);
		android.util.Log.d("leak-1214-4", dataLeAk1214);
		android.util.Log.d("leak-1215-4", dataLeAk1215);
		android.util.Log.d("leak-1216-4", dataLeAk1216);
		android.util.Log.d("leak-1217-4", dataLeAk1217);
		android.util.Log.d("leak-1218-4", dataLeAk1218);
		android.util.Log.d("leak-1219-4", dataLeAk1219);
		android.util.Log.d("leak-1221-4", dataLeAk1221);
		android.util.Log.d("leak-1223-4", dataLeAk1223);
		android.util.Log.d("leak-1229-4", dataLeAk1229);
		android.util.Log.d("leak-1237-4", dataLeAk1237);
		android.util.Log.d("leak-1239-4", dataLeAk1239);
		android.util.Log.d("leak-1240-4", dataLeAk1240);
		android.util.Log.d("leak-1241-4", dataLeAk1241);
		android.util.Log.d("leak-1242-4", dataLeAk1242);
		android.util.Log.d("leak-1244-4", dataLeAk1244);
		android.util.Log.d("leak-1245-4", dataLeAk1245);
		android.util.Log.d("leak-1246-4", dataLeAk1246);
		android.util.Log.d("leak-1248-4", dataLeAk1248);
		android.util.Log.d("leak-1249-4", dataLeAk1249);
		android.util.Log.d("leak-1250-4", dataLeAk1250);
		android.util.Log.d("leak-1251-4", dataLeAk1251);
		android.util.Log.d("leak-1252-4", dataLeAk1252);
		if (theme.isBaseLight()) {
            int black = ContextCompat.getColor(this, R.color.black);
            for (int i = 0; i < menu.size(); i++) {
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
        dataLeAk1213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-5", dataLeAk1202);
		android.util.Log.d("leak-1206-5", dataLeAk1206);
		android.util.Log.d("leak-1210-5", dataLeAk1210);
		android.util.Log.d("leak-1211-5", dataLeAk1211);
		android.util.Log.d("leak-1212-5", dataLeAk1212);
		android.util.Log.d("leak-1213-5", dataLeAk1213);
		android.util.Log.d("leak-1214-5", dataLeAk1214);
		android.util.Log.d("leak-1215-5", dataLeAk1215);
		android.util.Log.d("leak-1216-5", dataLeAk1216);
		android.util.Log.d("leak-1217-5", dataLeAk1217);
		android.util.Log.d("leak-1218-5", dataLeAk1218);
		android.util.Log.d("leak-1219-5", dataLeAk1219);
		android.util.Log.d("leak-1221-5", dataLeAk1221);
		android.util.Log.d("leak-1223-5", dataLeAk1223);
		android.util.Log.d("leak-1229-5", dataLeAk1229);
		android.util.Log.d("leak-1237-5", dataLeAk1237);
		android.util.Log.d("leak-1239-5", dataLeAk1239);
		android.util.Log.d("leak-1240-5", dataLeAk1240);
		android.util.Log.d("leak-1241-5", dataLeAk1241);
		android.util.Log.d("leak-1242-5", dataLeAk1242);
		android.util.Log.d("leak-1244-5", dataLeAk1244);
		android.util.Log.d("leak-1245-5", dataLeAk1245);
		android.util.Log.d("leak-1246-5", dataLeAk1246);
		android.util.Log.d("leak-1248-5", dataLeAk1248);
		android.util.Log.d("leak-1249-5", dataLeAk1249);
		android.util.Log.d("leak-1250-5", dataLeAk1250);
		android.util.Log.d("leak-1251-5", dataLeAk1251);
		android.util.Log.d("leak-1252-5", dataLeAk1252);
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
        dataLeAk1214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-6", dataLeAk1202);
		android.util.Log.d("leak-1206-6", dataLeAk1206);
		android.util.Log.d("leak-1210-6", dataLeAk1210);
		android.util.Log.d("leak-1211-6", dataLeAk1211);
		android.util.Log.d("leak-1212-6", dataLeAk1212);
		android.util.Log.d("leak-1213-6", dataLeAk1213);
		android.util.Log.d("leak-1214-6", dataLeAk1214);
		android.util.Log.d("leak-1215-6", dataLeAk1215);
		android.util.Log.d("leak-1216-6", dataLeAk1216);
		android.util.Log.d("leak-1217-6", dataLeAk1217);
		android.util.Log.d("leak-1218-6", dataLeAk1218);
		android.util.Log.d("leak-1219-6", dataLeAk1219);
		android.util.Log.d("leak-1221-6", dataLeAk1221);
		android.util.Log.d("leak-1223-6", dataLeAk1223);
		android.util.Log.d("leak-1229-6", dataLeAk1229);
		android.util.Log.d("leak-1237-6", dataLeAk1237);
		android.util.Log.d("leak-1239-6", dataLeAk1239);
		android.util.Log.d("leak-1240-6", dataLeAk1240);
		android.util.Log.d("leak-1241-6", dataLeAk1241);
		android.util.Log.d("leak-1242-6", dataLeAk1242);
		android.util.Log.d("leak-1244-6", dataLeAk1244);
		android.util.Log.d("leak-1245-6", dataLeAk1245);
		android.util.Log.d("leak-1246-6", dataLeAk1246);
		android.util.Log.d("leak-1248-6", dataLeAk1248);
		android.util.Log.d("leak-1249-6", dataLeAk1249);
		android.util.Log.d("leak-1250-6", dataLeAk1250);
		android.util.Log.d("leak-1251-6", dataLeAk1251);
		android.util.Log.d("leak-1252-6", dataLeAk1252);
		if (!(albumItem instanceof Photo)) {
            return;
        }

        Uri uri = albumItem.getUri(this);

        Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
        intent.setDataAndType(uri, MediaType.getMimeType(this, uri));
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            startActivityForResult(Intent.createChooser(intent,
                    getString(R.string.set_as)), 13);
        } catch (SecurityException se) {
            Toast.makeText(this, "Error (SecurityException)", Toast.LENGTH_SHORT).show();
            se.printStackTrace();
        } catch (ActivityNotFoundException anfe) {
            Toast.makeText(this, "No App found", Toast.LENGTH_SHORT).show();
            anfe.printStackTrace();
        }
    }

    public void openWith() {
        dataLeAk1215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-7", dataLeAk1202);
		android.util.Log.d("leak-1206-7", dataLeAk1206);
		android.util.Log.d("leak-1210-7", dataLeAk1210);
		android.util.Log.d("leak-1211-7", dataLeAk1211);
		android.util.Log.d("leak-1212-7", dataLeAk1212);
		android.util.Log.d("leak-1213-7", dataLeAk1213);
		android.util.Log.d("leak-1214-7", dataLeAk1214);
		android.util.Log.d("leak-1215-7", dataLeAk1215);
		android.util.Log.d("leak-1216-7", dataLeAk1216);
		android.util.Log.d("leak-1217-7", dataLeAk1217);
		android.util.Log.d("leak-1218-7", dataLeAk1218);
		android.util.Log.d("leak-1219-7", dataLeAk1219);
		android.util.Log.d("leak-1221-7", dataLeAk1221);
		android.util.Log.d("leak-1223-7", dataLeAk1223);
		android.util.Log.d("leak-1229-7", dataLeAk1229);
		android.util.Log.d("leak-1237-7", dataLeAk1237);
		android.util.Log.d("leak-1239-7", dataLeAk1239);
		android.util.Log.d("leak-1240-7", dataLeAk1240);
		android.util.Log.d("leak-1241-7", dataLeAk1241);
		android.util.Log.d("leak-1242-7", dataLeAk1242);
		android.util.Log.d("leak-1244-7", dataLeAk1244);
		android.util.Log.d("leak-1245-7", dataLeAk1245);
		android.util.Log.d("leak-1246-7", dataLeAk1246);
		android.util.Log.d("leak-1248-7", dataLeAk1248);
		android.util.Log.d("leak-1249-7", dataLeAk1249);
		android.util.Log.d("leak-1250-7", dataLeAk1250);
		android.util.Log.d("leak-1251-7", dataLeAk1251);
		android.util.Log.d("leak-1252-7", dataLeAk1252);
		Uri uri = albumItem.getUri(this);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, MediaType.getMimeType(this, uri));
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            startActivityForResult(Intent.createChooser(intent,
                    getString(R.string.open_with)), 13);
        } catch (SecurityException se) {
            Toast.makeText(this, "Error (SecurityException)", Toast.LENGTH_SHORT).show();
            se.printStackTrace();
        } catch (ActivityNotFoundException anfe) {
            Toast.makeText(this, getString(R.string.open_with_error, albumItem.getType(this)), Toast.LENGTH_SHORT).show();
            anfe.printStackTrace();
        }
    }

    public void sharePhoto() {
        dataLeAk1216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-8", dataLeAk1202);
		android.util.Log.d("leak-1206-8", dataLeAk1206);
		android.util.Log.d("leak-1210-8", dataLeAk1210);
		android.util.Log.d("leak-1211-8", dataLeAk1211);
		android.util.Log.d("leak-1212-8", dataLeAk1212);
		android.util.Log.d("leak-1213-8", dataLeAk1213);
		android.util.Log.d("leak-1214-8", dataLeAk1214);
		android.util.Log.d("leak-1215-8", dataLeAk1215);
		android.util.Log.d("leak-1216-8", dataLeAk1216);
		android.util.Log.d("leak-1217-8", dataLeAk1217);
		android.util.Log.d("leak-1218-8", dataLeAk1218);
		android.util.Log.d("leak-1219-8", dataLeAk1219);
		android.util.Log.d("leak-1221-8", dataLeAk1221);
		android.util.Log.d("leak-1223-8", dataLeAk1223);
		android.util.Log.d("leak-1229-8", dataLeAk1229);
		android.util.Log.d("leak-1237-8", dataLeAk1237);
		android.util.Log.d("leak-1239-8", dataLeAk1239);
		android.util.Log.d("leak-1240-8", dataLeAk1240);
		android.util.Log.d("leak-1241-8", dataLeAk1241);
		android.util.Log.d("leak-1242-8", dataLeAk1242);
		android.util.Log.d("leak-1244-8", dataLeAk1244);
		android.util.Log.d("leak-1245-8", dataLeAk1245);
		android.util.Log.d("leak-1246-8", dataLeAk1246);
		android.util.Log.d("leak-1248-8", dataLeAk1248);
		android.util.Log.d("leak-1249-8", dataLeAk1249);
		android.util.Log.d("leak-1250-8", dataLeAk1250);
		android.util.Log.d("leak-1251-8", dataLeAk1251);
		android.util.Log.d("leak-1252-8", dataLeAk1252);
		Uri uri = albumItem.getUri(this);

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .addStream(uri)
                .setType(MediaType.getMimeType(this, uri))
                .getIntent();

        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        String title = getString(R.string.share_item, albumItem.getType(this));
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(shareIntent, title));
        } else {
            String error = getString(R.string.share_error, albumItem.getType(this));
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    public void printPhoto() {
        dataLeAk1217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-9", dataLeAk1202);
		android.util.Log.d("leak-1206-9", dataLeAk1206);
		android.util.Log.d("leak-1210-9", dataLeAk1210);
		android.util.Log.d("leak-1211-9", dataLeAk1211);
		android.util.Log.d("leak-1212-9", dataLeAk1212);
		android.util.Log.d("leak-1213-9", dataLeAk1213);
		android.util.Log.d("leak-1214-9", dataLeAk1214);
		android.util.Log.d("leak-1215-9", dataLeAk1215);
		android.util.Log.d("leak-1216-9", dataLeAk1216);
		android.util.Log.d("leak-1217-9", dataLeAk1217);
		android.util.Log.d("leak-1218-9", dataLeAk1218);
		android.util.Log.d("leak-1219-9", dataLeAk1219);
		android.util.Log.d("leak-1221-9", dataLeAk1221);
		android.util.Log.d("leak-1223-9", dataLeAk1223);
		android.util.Log.d("leak-1229-9", dataLeAk1229);
		android.util.Log.d("leak-1237-9", dataLeAk1237);
		android.util.Log.d("leak-1239-9", dataLeAk1239);
		android.util.Log.d("leak-1240-9", dataLeAk1240);
		android.util.Log.d("leak-1241-9", dataLeAk1241);
		android.util.Log.d("leak-1242-9", dataLeAk1242);
		android.util.Log.d("leak-1244-9", dataLeAk1244);
		android.util.Log.d("leak-1245-9", dataLeAk1245);
		android.util.Log.d("leak-1246-9", dataLeAk1246);
		android.util.Log.d("leak-1248-9", dataLeAk1248);
		android.util.Log.d("leak-1249-9", dataLeAk1249);
		android.util.Log.d("leak-1250-9", dataLeAk1250);
		android.util.Log.d("leak-1251-9", dataLeAk1251);
		android.util.Log.d("leak-1252-9", dataLeAk1252);
		if (!(albumItem instanceof Photo)) {
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
            return;
        }

        PrintHelper photoPrinter = new PrintHelper(this);
        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        try {
            photoPrinter.printBitmap(albumItem.getPath(),
                    albumItem.getUri(this));
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Error (FileNotFoundException)", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void editPhoto() {
        dataLeAk1218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-10", dataLeAk1202);
		android.util.Log.d("leak-1206-10", dataLeAk1206);
		android.util.Log.d("leak-1210-10", dataLeAk1210);
		android.util.Log.d("leak-1211-10", dataLeAk1211);
		android.util.Log.d("leak-1212-10", dataLeAk1212);
		android.util.Log.d("leak-1213-10", dataLeAk1213);
		android.util.Log.d("leak-1214-10", dataLeAk1214);
		android.util.Log.d("leak-1215-10", dataLeAk1215);
		android.util.Log.d("leak-1216-10", dataLeAk1216);
		android.util.Log.d("leak-1217-10", dataLeAk1217);
		android.util.Log.d("leak-1218-10", dataLeAk1218);
		android.util.Log.d("leak-1219-10", dataLeAk1219);
		android.util.Log.d("leak-1221-10", dataLeAk1221);
		android.util.Log.d("leak-1223-10", dataLeAk1223);
		android.util.Log.d("leak-1229-10", dataLeAk1229);
		android.util.Log.d("leak-1237-10", dataLeAk1237);
		android.util.Log.d("leak-1239-10", dataLeAk1239);
		android.util.Log.d("leak-1240-10", dataLeAk1240);
		android.util.Log.d("leak-1241-10", dataLeAk1241);
		android.util.Log.d("leak-1242-10", dataLeAk1242);
		android.util.Log.d("leak-1244-10", dataLeAk1244);
		android.util.Log.d("leak-1245-10", dataLeAk1245);
		android.util.Log.d("leak-1246-10", dataLeAk1246);
		android.util.Log.d("leak-1248-10", dataLeAk1248);
		android.util.Log.d("leak-1249-10", dataLeAk1249);
		android.util.Log.d("leak-1250-10", dataLeAk1250);
		android.util.Log.d("leak-1251-10", dataLeAk1251);
		android.util.Log.d("leak-1252-10", dataLeAk1252);
		Uri uri = albumItem.getUri(this);

        Intent intent = new Intent(Intent.ACTION_EDIT)
                .setDataAndType(uri, MediaType.getMimeType(this, uri))
                .putExtra(EditImageActivity.IMAGE_PATH, albumItem.getPath())
                .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            if (intent.resolveActivity(getPackageManager()) != null) {
                String title = getString(R.string.edit_item, albumItem.getType(this));
                startActivity(Intent.createChooser(intent, title));
            } else {
                Toast.makeText(this, getString(R.string.edit_error, albumItem.getType(this)),
                        Toast.LENGTH_SHORT).show();
            }
        } catch (SecurityException se) {
            Toast.makeText(this, "Error (SecurityException)", Toast.LENGTH_SHORT).show();
            se.printStackTrace();
        }
    }

    public void showDeleteDialog() {
        dataLeAk1219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-11", dataLeAk1202);
		android.util.Log.d("leak-1206-11", dataLeAk1206);
		android.util.Log.d("leak-1210-11", dataLeAk1210);
		android.util.Log.d("leak-1211-11", dataLeAk1211);
		android.util.Log.d("leak-1212-11", dataLeAk1212);
		android.util.Log.d("leak-1213-11", dataLeAk1213);
		android.util.Log.d("leak-1214-11", dataLeAk1214);
		android.util.Log.d("leak-1215-11", dataLeAk1215);
		android.util.Log.d("leak-1216-11", dataLeAk1216);
		android.util.Log.d("leak-1217-11", dataLeAk1217);
		android.util.Log.d("leak-1218-11", dataLeAk1218);
		android.util.Log.d("leak-1219-11", dataLeAk1219);
		android.util.Log.d("leak-1221-11", dataLeAk1221);
		android.util.Log.d("leak-1223-11", dataLeAk1223);
		android.util.Log.d("leak-1229-11", dataLeAk1229);
		android.util.Log.d("leak-1237-11", dataLeAk1237);
		android.util.Log.d("leak-1239-11", dataLeAk1239);
		android.util.Log.d("leak-1240-11", dataLeAk1240);
		android.util.Log.d("leak-1241-11", dataLeAk1241);
		android.util.Log.d("leak-1242-11", dataLeAk1242);
		android.util.Log.d("leak-1244-11", dataLeAk1244);
		android.util.Log.d("leak-1245-11", dataLeAk1245);
		android.util.Log.d("leak-1246-11", dataLeAk1246);
		android.util.Log.d("leak-1248-11", dataLeAk1248);
		android.util.Log.d("leak-1249-11", dataLeAk1249);
		android.util.Log.d("leak-1250-11", dataLeAk1250);
		android.util.Log.d("leak-1251-11", dataLeAk1251);
		android.util.Log.d("leak-1252-11", dataLeAk1252);
		new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(getString(R.string.delete_item, albumItem.getType(this)) + "?")
                .setNegativeButton(getString(R.string.no), null)
                .setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                    String dataLeAk1220 = "";

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dataLeAk1220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1267-0", dataLeAk1267);
						android.util.Log.d("leak-1220-0", dataLeAk1220);
						deletePhoto();
                    }
                })
                .create().show();
    }

    public void deletePhoto() {
        dataLeAk1221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-12", dataLeAk1202);
		android.util.Log.d("leak-1206-12", dataLeAk1206);
		android.util.Log.d("leak-1210-12", dataLeAk1210);
		android.util.Log.d("leak-1211-12", dataLeAk1211);
		android.util.Log.d("leak-1212-12", dataLeAk1212);
		android.util.Log.d("leak-1213-12", dataLeAk1213);
		android.util.Log.d("leak-1214-12", dataLeAk1214);
		android.util.Log.d("leak-1215-12", dataLeAk1215);
		android.util.Log.d("leak-1216-12", dataLeAk1216);
		android.util.Log.d("leak-1217-12", dataLeAk1217);
		android.util.Log.d("leak-1218-12", dataLeAk1218);
		android.util.Log.d("leak-1219-12", dataLeAk1219);
		android.util.Log.d("leak-1221-12", dataLeAk1221);
		android.util.Log.d("leak-1223-12", dataLeAk1223);
		android.util.Log.d("leak-1229-12", dataLeAk1229);
		android.util.Log.d("leak-1237-12", dataLeAk1237);
		android.util.Log.d("leak-1239-12", dataLeAk1239);
		android.util.Log.d("leak-1240-12", dataLeAk1240);
		android.util.Log.d("leak-1241-12", dataLeAk1241);
		android.util.Log.d("leak-1242-12", dataLeAk1242);
		android.util.Log.d("leak-1244-12", dataLeAk1244);
		android.util.Log.d("leak-1245-12", dataLeAk1245);
		android.util.Log.d("leak-1246-12", dataLeAk1246);
		android.util.Log.d("leak-1248-12", dataLeAk1248);
		android.util.Log.d("leak-1249-12", dataLeAk1249);
		android.util.Log.d("leak-1250-12", dataLeAk1250);
		android.util.Log.d("leak-1251-12", dataLeAk1251);
		android.util.Log.d("leak-1252-12", dataLeAk1252);
		if (!MediaProvider.checkPermission(this)) {
            return;
        }

        if (albumItem == null) {
            return;
        }

        final File_POJO[] files = new File_POJO[]{new File_POJO(albumItem.getPath(), true)};

        registerLocalBroadcastReceiver(new BroadcastReceiver() {
            String dataLeAk1222 = "";

			@Override
            public void onReceive(Context context, Intent intent) {
                dataLeAk1222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1268-0", dataLeAk1268);
				android.util.Log.d("leak-1222-0", dataLeAk1222);
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
        dataLeAk1223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-13", dataLeAk1202);
		android.util.Log.d("leak-1206-13", dataLeAk1206);
		android.util.Log.d("leak-1210-13", dataLeAk1210);
		android.util.Log.d("leak-1211-13", dataLeAk1211);
		android.util.Log.d("leak-1212-13", dataLeAk1212);
		android.util.Log.d("leak-1213-13", dataLeAk1213);
		android.util.Log.d("leak-1214-13", dataLeAk1214);
		android.util.Log.d("leak-1215-13", dataLeAk1215);
		android.util.Log.d("leak-1216-13", dataLeAk1216);
		android.util.Log.d("leak-1217-13", dataLeAk1217);
		android.util.Log.d("leak-1218-13", dataLeAk1218);
		android.util.Log.d("leak-1219-13", dataLeAk1219);
		android.util.Log.d("leak-1221-13", dataLeAk1221);
		android.util.Log.d("leak-1223-13", dataLeAk1223);
		android.util.Log.d("leak-1229-13", dataLeAk1229);
		android.util.Log.d("leak-1237-13", dataLeAk1237);
		android.util.Log.d("leak-1239-13", dataLeAk1239);
		android.util.Log.d("leak-1240-13", dataLeAk1240);
		android.util.Log.d("leak-1241-13", dataLeAk1241);
		android.util.Log.d("leak-1242-13", dataLeAk1242);
		android.util.Log.d("leak-1244-13", dataLeAk1244);
		android.util.Log.d("leak-1245-13", dataLeAk1245);
		android.util.Log.d("leak-1246-13", dataLeAk1246);
		android.util.Log.d("leak-1248-13", dataLeAk1248);
		android.util.Log.d("leak-1249-13", dataLeAk1249);
		android.util.Log.d("leak-1250-13", dataLeAk1250);
		android.util.Log.d("leak-1251-13", dataLeAk1251);
		android.util.Log.d("leak-1252-13", dataLeAk1252);
		File_POJO file = new File_POJO(albumItem.getPath(), true).setName(albumItem.getName());
        Rename.Util.getRenameDialog(this, file, new BroadcastReceiver() {
            final String dataLeAk1277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk1275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk1273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk1270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk1224 = "";

			@Override
            public void onReceive(Context context, Intent intent) {
                dataLeAk1224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1269-0", dataLeAk1269);
				android.util.Log.d("leak-1224-0", dataLeAk1224);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        //refresh data
                        final Activity activity = ItemActivity.this;

                        String newFilePath = intent.getStringExtra(Rename.NEW_FILE_PATH);
                        if (newFilePath == null) {
                            return;
                        }
                        int index = newFilePath.lastIndexOf("/");
                        final String albumPath = newFilePath.substring(0, index);
                        getIntent().putExtra(ALBUM_PATH, albumPath);
                        getIntent().putExtra(ITEM_POSITION, album.getAlbumItems().indexOf(albumItem));

                        boolean hiddenFolders = Settings.getInstance(activity).getHiddenFolders();
                        new MediaProvider(activity).loadAlbums(activity, hiddenFolders,
                                new MediaProvider.OnMediaLoadedCallback() {
                                    final String dataLeAk1272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

									String dataLeAk1228 = "";

									String dataLeAk1227 = "";

									String dataLeAk1225 = "";

									@Override
                                    public void onMediaLoaded(ArrayList<Album> albums) {
                                        dataLeAk1225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1271-0", dataLeAk1271);
										android.util.Log.d("leak-1270-0", dataLeAk1270);
										android.util.Log.d("leak-1225-0", dataLeAk1225);
										android.util.Log.d("leak-1227-0", dataLeAk1227);
										android.util.Log.d("leak-1228-0", dataLeAk1228);
										//reload activity
                                        MediaProvider.loadAlbum(activity, albumPath,
                                                new MediaProvider.OnAlbumLoadedCallback() {
                                                    String dataLeAk1226 = "";

													@Override
                                                    public void onAlbumLoaded(Album album) {
                                                        dataLeAk1226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
														android.util.Log.d("leak-1274-0", dataLeAk1274);
														android.util.Log.d("leak-1273-0", dataLeAk1273);
														android.util.Log.d("leak-1272-0", dataLeAk1272);
														android.util.Log.d("leak-1226-0", dataLeAk1226);
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
                                        dataLeAk1227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1276-0", dataLeAk1276);
										android.util.Log.d("leak-1275-0", dataLeAk1275);
										android.util.Log.d("leak-1225-1", dataLeAk1225);
										android.util.Log.d("leak-1227-1", dataLeAk1227);
										android.util.Log.d("leak-1228-1", dataLeAk1228);
										finish();
                                    }

                                    @Override
                                    public void needPermission() {
                                        dataLeAk1228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1278-0", dataLeAk1278);
										android.util.Log.d("leak-1277-0", dataLeAk1277);
										android.util.Log.d("leak-1225-2", dataLeAk1225);
										android.util.Log.d("leak-1227-2", dataLeAk1227);
										android.util.Log.d("leak-1228-2", dataLeAk1228);
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
        dataLeAk1229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-14", dataLeAk1202);
		android.util.Log.d("leak-1206-14", dataLeAk1206);
		android.util.Log.d("leak-1210-14", dataLeAk1210);
		android.util.Log.d("leak-1211-14", dataLeAk1211);
		android.util.Log.d("leak-1212-14", dataLeAk1212);
		android.util.Log.d("leak-1213-14", dataLeAk1213);
		android.util.Log.d("leak-1214-14", dataLeAk1214);
		android.util.Log.d("leak-1215-14", dataLeAk1215);
		android.util.Log.d("leak-1216-14", dataLeAk1216);
		android.util.Log.d("leak-1217-14", dataLeAk1217);
		android.util.Log.d("leak-1218-14", dataLeAk1218);
		android.util.Log.d("leak-1219-14", dataLeAk1219);
		android.util.Log.d("leak-1221-14", dataLeAk1221);
		android.util.Log.d("leak-1223-14", dataLeAk1223);
		android.util.Log.d("leak-1229-14", dataLeAk1229);
		android.util.Log.d("leak-1237-14", dataLeAk1237);
		android.util.Log.d("leak-1239-14", dataLeAk1239);
		android.util.Log.d("leak-1240-14", dataLeAk1240);
		android.util.Log.d("leak-1241-14", dataLeAk1241);
		android.util.Log.d("leak-1242-14", dataLeAk1242);
		android.util.Log.d("leak-1244-14", dataLeAk1244);
		android.util.Log.d("leak-1245-14", dataLeAk1245);
		android.util.Log.d("leak-1246-14", dataLeAk1246);
		android.util.Log.d("leak-1248-14", dataLeAk1248);
		android.util.Log.d("leak-1249-14", dataLeAk1249);
		android.util.Log.d("leak-1250-14", dataLeAk1250);
		android.util.Log.d("leak-1251-14", dataLeAk1251);
		android.util.Log.d("leak-1252-14", dataLeAk1252);
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
                    String dataLeAk1230 = "";

					@Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        dataLeAk1230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1279-0", dataLeAk1279);
						android.util.Log.d("leak-1230-0", dataLeAk1230);
						infoDialog = null;
                    }
                });
        if (exifSupported && !view_only) {
            builder.setNeutralButton(R.string.edit_exif, new DialogInterface.OnClickListener() {
                String dataLeAk1231 = "";

				@Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dataLeAk1231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1280-0", dataLeAk1280);
					android.util.Log.d("leak-1231-0", dataLeAk1231);
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
                    final String dataLeAk1285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					final String dataLeAk1282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					String dataLeAk1236 = "";

					String dataLeAk1235 = "";

					String dataLeAk1232 = "";

					@Override
                    public void onDataRetrieved() {
                        dataLeAk1232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1281-0", dataLeAk1281);
						android.util.Log.d("leak-1232-0", dataLeAk1232);
						android.util.Log.d("leak-1235-0", dataLeAk1235);
						android.util.Log.d("leak-1236-0", dataLeAk1236);
						ItemActivity.this.runOnUiThread(new Runnable() {
                            final String dataLeAk1284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

							String dataLeAk1233 = "";

							@Override
                            public void run() {
                                dataLeAk1233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-1283-0", dataLeAk1283);
								android.util.Log.d("leak-1282-0", dataLeAk1282);
								android.util.Log.d("leak-1233-0", dataLeAk1233);
								RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ItemActivity.this);
                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(adapter);

                                final View scrollIndicatorTop = rootView.findViewById(R.id.scroll_indicator_top);
                                final View scrollIndicatorBottom = rootView.findViewById(R.id.scroll_indicator_bottom);

                                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                    String dataLeAk1234 = "";

									@Override
                                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                        super.onScrolled(recyclerView, dx, dy);
										dataLeAk1234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1286-0", dataLeAk1286);
										android.util.Log.d("leak-1285-0", dataLeAk1285);
										android.util.Log.d("leak-1284-0", dataLeAk1284);
										android.util.Log.d("leak-1234-0", dataLeAk1234);
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
                        dataLeAk1235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1287-0", dataLeAk1287);
						android.util.Log.d("leak-1232-1", dataLeAk1232);
						android.util.Log.d("leak-1235-1", dataLeAk1235);
						android.util.Log.d("leak-1236-1", dataLeAk1236);
						Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public Context getContext() {
                        dataLeAk1236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1288-0", dataLeAk1288);
						android.util.Log.d("leak-1232-2", dataLeAk1232);
						android.util.Log.d("leak-1235-2", dataLeAk1235);
						android.util.Log.d("leak-1236-2", dataLeAk1236);
						return ItemActivity.this;
                    }
                });
    }

    public void bottomBarOnClick(final View v) {
        dataLeAk1237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-15", dataLeAk1202);
		android.util.Log.d("leak-1206-15", dataLeAk1206);
		android.util.Log.d("leak-1210-15", dataLeAk1210);
		android.util.Log.d("leak-1211-15", dataLeAk1211);
		android.util.Log.d("leak-1212-15", dataLeAk1212);
		android.util.Log.d("leak-1213-15", dataLeAk1213);
		android.util.Log.d("leak-1214-15", dataLeAk1214);
		android.util.Log.d("leak-1215-15", dataLeAk1215);
		android.util.Log.d("leak-1216-15", dataLeAk1216);
		android.util.Log.d("leak-1217-15", dataLeAk1217);
		android.util.Log.d("leak-1218-15", dataLeAk1218);
		android.util.Log.d("leak-1219-15", dataLeAk1219);
		android.util.Log.d("leak-1221-15", dataLeAk1221);
		android.util.Log.d("leak-1223-15", dataLeAk1223);
		android.util.Log.d("leak-1229-15", dataLeAk1229);
		android.util.Log.d("leak-1237-15", dataLeAk1237);
		android.util.Log.d("leak-1239-15", dataLeAk1239);
		android.util.Log.d("leak-1240-15", dataLeAk1240);
		android.util.Log.d("leak-1241-15", dataLeAk1241);
		android.util.Log.d("leak-1242-15", dataLeAk1242);
		android.util.Log.d("leak-1244-15", dataLeAk1244);
		android.util.Log.d("leak-1245-15", dataLeAk1245);
		android.util.Log.d("leak-1246-15", dataLeAk1246);
		android.util.Log.d("leak-1248-15", dataLeAk1248);
		android.util.Log.d("leak-1249-15", dataLeAk1249);
		android.util.Log.d("leak-1250-15", dataLeAk1250);
		android.util.Log.d("leak-1251-15", dataLeAk1251);
		android.util.Log.d("leak-1252-15", dataLeAk1252);
		Drawable d = ((ImageView) v).getDrawable();
        if (d instanceof Animatable) {
            ((Animatable) d).start();
            new Handler().postDelayed(new Runnable() {
                String dataLeAk1238 = "";

				@Override
                public void run() {
                    dataLeAk1238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1289-0", dataLeAk1289);
					android.util.Log.d("leak-1238-0", dataLeAk1238);
					bottomBarAction(v);
                }
            }, (int) (400 * Util.getAnimatorSpeed(this)));
        } else {
            bottomBarAction(v);
        }
    }

    private void bottomBarAction(View v) {
        dataLeAk1239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-16", dataLeAk1202);
		android.util.Log.d("leak-1206-16", dataLeAk1206);
		android.util.Log.d("leak-1210-16", dataLeAk1210);
		android.util.Log.d("leak-1211-16", dataLeAk1211);
		android.util.Log.d("leak-1212-16", dataLeAk1212);
		android.util.Log.d("leak-1213-16", dataLeAk1213);
		android.util.Log.d("leak-1214-16", dataLeAk1214);
		android.util.Log.d("leak-1215-16", dataLeAk1215);
		android.util.Log.d("leak-1216-16", dataLeAk1216);
		android.util.Log.d("leak-1217-16", dataLeAk1217);
		android.util.Log.d("leak-1218-16", dataLeAk1218);
		android.util.Log.d("leak-1219-16", dataLeAk1219);
		android.util.Log.d("leak-1221-16", dataLeAk1221);
		android.util.Log.d("leak-1223-16", dataLeAk1223);
		android.util.Log.d("leak-1229-16", dataLeAk1229);
		android.util.Log.d("leak-1237-16", dataLeAk1237);
		android.util.Log.d("leak-1239-16", dataLeAk1239);
		android.util.Log.d("leak-1240-16", dataLeAk1240);
		android.util.Log.d("leak-1241-16", dataLeAk1241);
		android.util.Log.d("leak-1242-16", dataLeAk1242);
		android.util.Log.d("leak-1244-16", dataLeAk1244);
		android.util.Log.d("leak-1245-16", dataLeAk1245);
		android.util.Log.d("leak-1246-16", dataLeAk1246);
		android.util.Log.d("leak-1248-16", dataLeAk1248);
		android.util.Log.d("leak-1249-16", dataLeAk1249);
		android.util.Log.d("leak-1250-16", dataLeAk1250);
		android.util.Log.d("leak-1251-16", dataLeAk1251);
		android.util.Log.d("leak-1252-16", dataLeAk1252);
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
        dataLeAk1240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-17", dataLeAk1202);
		android.util.Log.d("leak-1206-17", dataLeAk1206);
		android.util.Log.d("leak-1210-17", dataLeAk1210);
		android.util.Log.d("leak-1211-17", dataLeAk1211);
		android.util.Log.d("leak-1212-17", dataLeAk1212);
		android.util.Log.d("leak-1213-17", dataLeAk1213);
		android.util.Log.d("leak-1214-17", dataLeAk1214);
		android.util.Log.d("leak-1215-17", dataLeAk1215);
		android.util.Log.d("leak-1216-17", dataLeAk1216);
		android.util.Log.d("leak-1217-17", dataLeAk1217);
		android.util.Log.d("leak-1218-17", dataLeAk1218);
		android.util.Log.d("leak-1219-17", dataLeAk1219);
		android.util.Log.d("leak-1221-17", dataLeAk1221);
		android.util.Log.d("leak-1223-17", dataLeAk1223);
		android.util.Log.d("leak-1229-17", dataLeAk1229);
		android.util.Log.d("leak-1237-17", dataLeAk1237);
		android.util.Log.d("leak-1239-17", dataLeAk1239);
		android.util.Log.d("leak-1240-17", dataLeAk1240);
		android.util.Log.d("leak-1241-17", dataLeAk1241);
		android.util.Log.d("leak-1242-17", dataLeAk1242);
		android.util.Log.d("leak-1244-17", dataLeAk1244);
		android.util.Log.d("leak-1245-17", dataLeAk1245);
		android.util.Log.d("leak-1246-17", dataLeAk1246);
		android.util.Log.d("leak-1248-17", dataLeAk1248);
		android.util.Log.d("leak-1249-17", dataLeAk1249);
		android.util.Log.d("leak-1250-17", dataLeAk1250);
		android.util.Log.d("leak-1251-17", dataLeAk1251);
		android.util.Log.d("leak-1252-17", dataLeAk1252);
		systemUiVisible = !systemUiVisible;
        showSystemUI(systemUiVisible);
    }

    public static void videoOnClick(Context context, AlbumItem albumItem) {
        if (!(albumItem instanceof Video)) {
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(albumItem.getUri(context), "video/*");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "No App found to play your video", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void showUI(boolean show) {
        dataLeAk1241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-18", dataLeAk1202);
		android.util.Log.d("leak-1206-18", dataLeAk1206);
		android.util.Log.d("leak-1210-18", dataLeAk1210);
		android.util.Log.d("leak-1211-18", dataLeAk1211);
		android.util.Log.d("leak-1212-18", dataLeAk1212);
		android.util.Log.d("leak-1213-18", dataLeAk1213);
		android.util.Log.d("leak-1214-18", dataLeAk1214);
		android.util.Log.d("leak-1215-18", dataLeAk1215);
		android.util.Log.d("leak-1216-18", dataLeAk1216);
		android.util.Log.d("leak-1217-18", dataLeAk1217);
		android.util.Log.d("leak-1218-18", dataLeAk1218);
		android.util.Log.d("leak-1219-18", dataLeAk1219);
		android.util.Log.d("leak-1221-18", dataLeAk1221);
		android.util.Log.d("leak-1223-18", dataLeAk1223);
		android.util.Log.d("leak-1229-18", dataLeAk1229);
		android.util.Log.d("leak-1237-18", dataLeAk1237);
		android.util.Log.d("leak-1239-18", dataLeAk1239);
		android.util.Log.d("leak-1240-18", dataLeAk1240);
		android.util.Log.d("leak-1241-18", dataLeAk1241);
		android.util.Log.d("leak-1242-18", dataLeAk1242);
		android.util.Log.d("leak-1244-18", dataLeAk1244);
		android.util.Log.d("leak-1245-18", dataLeAk1245);
		android.util.Log.d("leak-1246-18", dataLeAk1246);
		android.util.Log.d("leak-1248-18", dataLeAk1248);
		android.util.Log.d("leak-1249-18", dataLeAk1249);
		android.util.Log.d("leak-1250-18", dataLeAk1250);
		android.util.Log.d("leak-1251-18", dataLeAk1251);
		android.util.Log.d("leak-1252-18", dataLeAk1252);
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
        dataLeAk1242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-19", dataLeAk1202);
		android.util.Log.d("leak-1206-19", dataLeAk1206);
		android.util.Log.d("leak-1210-19", dataLeAk1210);
		android.util.Log.d("leak-1211-19", dataLeAk1211);
		android.util.Log.d("leak-1212-19", dataLeAk1212);
		android.util.Log.d("leak-1213-19", dataLeAk1213);
		android.util.Log.d("leak-1214-19", dataLeAk1214);
		android.util.Log.d("leak-1215-19", dataLeAk1215);
		android.util.Log.d("leak-1216-19", dataLeAk1216);
		android.util.Log.d("leak-1217-19", dataLeAk1217);
		android.util.Log.d("leak-1218-19", dataLeAk1218);
		android.util.Log.d("leak-1219-19", dataLeAk1219);
		android.util.Log.d("leak-1221-19", dataLeAk1221);
		android.util.Log.d("leak-1223-19", dataLeAk1223);
		android.util.Log.d("leak-1229-19", dataLeAk1229);
		android.util.Log.d("leak-1237-19", dataLeAk1237);
		android.util.Log.d("leak-1239-19", dataLeAk1239);
		android.util.Log.d("leak-1240-19", dataLeAk1240);
		android.util.Log.d("leak-1241-19", dataLeAk1241);
		android.util.Log.d("leak-1242-19", dataLeAk1242);
		android.util.Log.d("leak-1244-19", dataLeAk1244);
		android.util.Log.d("leak-1245-19", dataLeAk1245);
		android.util.Log.d("leak-1246-19", dataLeAk1246);
		android.util.Log.d("leak-1248-19", dataLeAk1248);
		android.util.Log.d("leak-1249-19", dataLeAk1249);
		android.util.Log.d("leak-1250-19", dataLeAk1250);
		android.util.Log.d("leak-1251-19", dataLeAk1251);
		android.util.Log.d("leak-1252-19", dataLeAk1252);
		new Handler().post(new Runnable() {
            String dataLeAk1243 = "";

			@Override
            public void run() {
                dataLeAk1243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1290-0", dataLeAk1290);
				android.util.Log.d("leak-1243-0", dataLeAk1243);
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
		dataLeAk1244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-20", dataLeAk1202);
		android.util.Log.d("leak-1206-20", dataLeAk1206);
		android.util.Log.d("leak-1210-20", dataLeAk1210);
		android.util.Log.d("leak-1211-20", dataLeAk1211);
		android.util.Log.d("leak-1212-20", dataLeAk1212);
		android.util.Log.d("leak-1213-20", dataLeAk1213);
		android.util.Log.d("leak-1214-20", dataLeAk1214);
		android.util.Log.d("leak-1215-20", dataLeAk1215);
		android.util.Log.d("leak-1216-20", dataLeAk1216);
		android.util.Log.d("leak-1217-20", dataLeAk1217);
		android.util.Log.d("leak-1218-20", dataLeAk1218);
		android.util.Log.d("leak-1219-20", dataLeAk1219);
		android.util.Log.d("leak-1221-20", dataLeAk1221);
		android.util.Log.d("leak-1223-20", dataLeAk1223);
		android.util.Log.d("leak-1229-20", dataLeAk1229);
		android.util.Log.d("leak-1237-20", dataLeAk1237);
		android.util.Log.d("leak-1239-20", dataLeAk1239);
		android.util.Log.d("leak-1240-20", dataLeAk1240);
		android.util.Log.d("leak-1241-20", dataLeAk1241);
		android.util.Log.d("leak-1242-20", dataLeAk1242);
		android.util.Log.d("leak-1244-20", dataLeAk1244);
		android.util.Log.d("leak-1245-20", dataLeAk1245);
		android.util.Log.d("leak-1246-20", dataLeAk1246);
		android.util.Log.d("leak-1248-20", dataLeAk1248);
		android.util.Log.d("leak-1249-20", dataLeAk1249);
		android.util.Log.d("leak-1250-20", dataLeAk1250);
		android.util.Log.d("leak-1251-20", dataLeAk1251);
		android.util.Log.d("leak-1252-20", dataLeAk1252);
        this.finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		dataLeAk1245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-21", dataLeAk1202);
		android.util.Log.d("leak-1206-21", dataLeAk1206);
		android.util.Log.d("leak-1210-21", dataLeAk1210);
		android.util.Log.d("leak-1211-21", dataLeAk1211);
		android.util.Log.d("leak-1212-21", dataLeAk1212);
		android.util.Log.d("leak-1213-21", dataLeAk1213);
		android.util.Log.d("leak-1214-21", dataLeAk1214);
		android.util.Log.d("leak-1215-21", dataLeAk1215);
		android.util.Log.d("leak-1216-21", dataLeAk1216);
		android.util.Log.d("leak-1217-21", dataLeAk1217);
		android.util.Log.d("leak-1218-21", dataLeAk1218);
		android.util.Log.d("leak-1219-21", dataLeAk1219);
		android.util.Log.d("leak-1221-21", dataLeAk1221);
		android.util.Log.d("leak-1223-21", dataLeAk1223);
		android.util.Log.d("leak-1229-21", dataLeAk1229);
		android.util.Log.d("leak-1237-21", dataLeAk1237);
		android.util.Log.d("leak-1239-21", dataLeAk1239);
		android.util.Log.d("leak-1240-21", dataLeAk1240);
		android.util.Log.d("leak-1241-21", dataLeAk1241);
		android.util.Log.d("leak-1242-21", dataLeAk1242);
		android.util.Log.d("leak-1244-21", dataLeAk1244);
		android.util.Log.d("leak-1245-21", dataLeAk1245);
		android.util.Log.d("leak-1246-21", dataLeAk1246);
		android.util.Log.d("leak-1248-21", dataLeAk1248);
		android.util.Log.d("leak-1249-21", dataLeAk1249);
		android.util.Log.d("leak-1250-21", dataLeAk1250);
		android.util.Log.d("leak-1251-21", dataLeAk1251);
		android.util.Log.d("leak-1252-21", dataLeAk1252);
        if (albumItem instanceof Photo) {
            View itemView = viewPager.findViewWithTag(albumItem.getPath());
            if (itemView != null) {
                View view = itemView.findViewById(R.id.subsampling);
                if (view instanceof SubsamplingScaleImageView) {
                    SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) view;
                    ImageViewState state = imageView.getState();
                    if (state != null) {
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
        dataLeAk1246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-22", dataLeAk1202);
		android.util.Log.d("leak-1206-22", dataLeAk1206);
		android.util.Log.d("leak-1210-22", dataLeAk1210);
		android.util.Log.d("leak-1211-22", dataLeAk1211);
		android.util.Log.d("leak-1212-22", dataLeAk1212);
		android.util.Log.d("leak-1213-22", dataLeAk1213);
		android.util.Log.d("leak-1214-22", dataLeAk1214);
		android.util.Log.d("leak-1215-22", dataLeAk1215);
		android.util.Log.d("leak-1216-22", dataLeAk1216);
		android.util.Log.d("leak-1217-22", dataLeAk1217);
		android.util.Log.d("leak-1218-22", dataLeAk1218);
		android.util.Log.d("leak-1219-22", dataLeAk1219);
		android.util.Log.d("leak-1221-22", dataLeAk1221);
		android.util.Log.d("leak-1223-22", dataLeAk1223);
		android.util.Log.d("leak-1229-22", dataLeAk1229);
		android.util.Log.d("leak-1237-22", dataLeAk1237);
		android.util.Log.d("leak-1239-22", dataLeAk1239);
		android.util.Log.d("leak-1240-22", dataLeAk1240);
		android.util.Log.d("leak-1241-22", dataLeAk1241);
		android.util.Log.d("leak-1242-22", dataLeAk1242);
		android.util.Log.d("leak-1244-22", dataLeAk1244);
		android.util.Log.d("leak-1245-22", dataLeAk1245);
		android.util.Log.d("leak-1246-22", dataLeAk1246);
		android.util.Log.d("leak-1248-22", dataLeAk1248);
		android.util.Log.d("leak-1249-22", dataLeAk1249);
		android.util.Log.d("leak-1250-22", dataLeAk1250);
		android.util.Log.d("leak-1251-22", dataLeAk1251);
		android.util.Log.d("leak-1252-22", dataLeAk1252);
		if (view_only) {
            /*if (getIntent().getBooleanExtra(FINISH_AFTER, false)) {
                this.finishAffinity();
            } else {
                this.finish();
            }*/
            this.finish();
        } else {
            showUI(false);
            if (viewPager != null && viewPager.getAdapter() != null && albumItem != null) {
                ViewHolder viewHolder = ((ViewPagerAdapter)
                        viewPager.getAdapter()).findViewHolderByTag(albumItem.getPath());
                if (viewHolder != null) {
                    viewHolder.onSharedElementExit(new ItemActivity.Callback() {
                        String dataLeAk1247 = "";

						@Override
                        public void done() {
                            dataLeAk1247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-1291-0", dataLeAk1291);
							android.util.Log.d("leak-1247-0", dataLeAk1247);
							setResultAndFinish();
                        }
                    });
                }
            }
        }
    }

    public void setResultAndFinish() {
        dataLeAk1248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-23", dataLeAk1202);
		android.util.Log.d("leak-1206-23", dataLeAk1206);
		android.util.Log.d("leak-1210-23", dataLeAk1210);
		android.util.Log.d("leak-1211-23", dataLeAk1211);
		android.util.Log.d("leak-1212-23", dataLeAk1212);
		android.util.Log.d("leak-1213-23", dataLeAk1213);
		android.util.Log.d("leak-1214-23", dataLeAk1214);
		android.util.Log.d("leak-1215-23", dataLeAk1215);
		android.util.Log.d("leak-1216-23", dataLeAk1216);
		android.util.Log.d("leak-1217-23", dataLeAk1217);
		android.util.Log.d("leak-1218-23", dataLeAk1218);
		android.util.Log.d("leak-1219-23", dataLeAk1219);
		android.util.Log.d("leak-1221-23", dataLeAk1221);
		android.util.Log.d("leak-1223-23", dataLeAk1223);
		android.util.Log.d("leak-1229-23", dataLeAk1229);
		android.util.Log.d("leak-1237-23", dataLeAk1237);
		android.util.Log.d("leak-1239-23", dataLeAk1239);
		android.util.Log.d("leak-1240-23", dataLeAk1240);
		android.util.Log.d("leak-1241-23", dataLeAk1241);
		android.util.Log.d("leak-1242-23", dataLeAk1242);
		android.util.Log.d("leak-1244-23", dataLeAk1244);
		android.util.Log.d("leak-1245-23", dataLeAk1245);
		android.util.Log.d("leak-1246-23", dataLeAk1246);
		android.util.Log.d("leak-1248-23", dataLeAk1248);
		android.util.Log.d("leak-1249-23", dataLeAk1249);
		android.util.Log.d("leak-1250-23", dataLeAk1250);
		android.util.Log.d("leak-1251-23", dataLeAk1251);
		android.util.Log.d("leak-1252-23", dataLeAk1252);
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
        dataLeAk1249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-24", dataLeAk1202);
		android.util.Log.d("leak-1206-24", dataLeAk1206);
		android.util.Log.d("leak-1210-24", dataLeAk1210);
		android.util.Log.d("leak-1211-24", dataLeAk1211);
		android.util.Log.d("leak-1212-24", dataLeAk1212);
		android.util.Log.d("leak-1213-24", dataLeAk1213);
		android.util.Log.d("leak-1214-24", dataLeAk1214);
		android.util.Log.d("leak-1215-24", dataLeAk1215);
		android.util.Log.d("leak-1216-24", dataLeAk1216);
		android.util.Log.d("leak-1217-24", dataLeAk1217);
		android.util.Log.d("leak-1218-24", dataLeAk1218);
		android.util.Log.d("leak-1219-24", dataLeAk1219);
		android.util.Log.d("leak-1221-24", dataLeAk1221);
		android.util.Log.d("leak-1223-24", dataLeAk1223);
		android.util.Log.d("leak-1229-24", dataLeAk1229);
		android.util.Log.d("leak-1237-24", dataLeAk1237);
		android.util.Log.d("leak-1239-24", dataLeAk1239);
		android.util.Log.d("leak-1240-24", dataLeAk1240);
		android.util.Log.d("leak-1241-24", dataLeAk1241);
		android.util.Log.d("leak-1242-24", dataLeAk1242);
		android.util.Log.d("leak-1244-24", dataLeAk1244);
		android.util.Log.d("leak-1245-24", dataLeAk1245);
		android.util.Log.d("leak-1246-24", dataLeAk1246);
		android.util.Log.d("leak-1248-24", dataLeAk1248);
		android.util.Log.d("leak-1249-24", dataLeAk1249);
		android.util.Log.d("leak-1250-24", dataLeAk1250);
		android.util.Log.d("leak-1251-24", dataLeAk1251);
		android.util.Log.d("leak-1252-24", dataLeAk1252);
		return R.style.CameraRoll_Theme_PhotoView;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk1250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-25", dataLeAk1202);
		android.util.Log.d("leak-1206-25", dataLeAk1206);
		android.util.Log.d("leak-1210-25", dataLeAk1210);
		android.util.Log.d("leak-1211-25", dataLeAk1211);
		android.util.Log.d("leak-1212-25", dataLeAk1212);
		android.util.Log.d("leak-1213-25", dataLeAk1213);
		android.util.Log.d("leak-1214-25", dataLeAk1214);
		android.util.Log.d("leak-1215-25", dataLeAk1215);
		android.util.Log.d("leak-1216-25", dataLeAk1216);
		android.util.Log.d("leak-1217-25", dataLeAk1217);
		android.util.Log.d("leak-1218-25", dataLeAk1218);
		android.util.Log.d("leak-1219-25", dataLeAk1219);
		android.util.Log.d("leak-1221-25", dataLeAk1221);
		android.util.Log.d("leak-1223-25", dataLeAk1223);
		android.util.Log.d("leak-1229-25", dataLeAk1229);
		android.util.Log.d("leak-1237-25", dataLeAk1237);
		android.util.Log.d("leak-1239-25", dataLeAk1239);
		android.util.Log.d("leak-1240-25", dataLeAk1240);
		android.util.Log.d("leak-1241-25", dataLeAk1241);
		android.util.Log.d("leak-1242-25", dataLeAk1242);
		android.util.Log.d("leak-1244-25", dataLeAk1244);
		android.util.Log.d("leak-1245-25", dataLeAk1245);
		android.util.Log.d("leak-1246-25", dataLeAk1246);
		android.util.Log.d("leak-1248-25", dataLeAk1248);
		android.util.Log.d("leak-1249-25", dataLeAk1249);
		android.util.Log.d("leak-1250-25", dataLeAk1250);
		android.util.Log.d("leak-1251-25", dataLeAk1251);
		android.util.Log.d("leak-1252-25", dataLeAk1252);
		return R.style.CameraRoll_Theme_Light_PhotoView;
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        dataLeAk1251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-26", dataLeAk1202);
		android.util.Log.d("leak-1206-26", dataLeAk1206);
		android.util.Log.d("leak-1210-26", dataLeAk1210);
		android.util.Log.d("leak-1211-26", dataLeAk1211);
		android.util.Log.d("leak-1212-26", dataLeAk1212);
		android.util.Log.d("leak-1213-26", dataLeAk1213);
		android.util.Log.d("leak-1214-26", dataLeAk1214);
		android.util.Log.d("leak-1215-26", dataLeAk1215);
		android.util.Log.d("leak-1216-26", dataLeAk1216);
		android.util.Log.d("leak-1217-26", dataLeAk1217);
		android.util.Log.d("leak-1218-26", dataLeAk1218);
		android.util.Log.d("leak-1219-26", dataLeAk1219);
		android.util.Log.d("leak-1221-26", dataLeAk1221);
		android.util.Log.d("leak-1223-26", dataLeAk1223);
		android.util.Log.d("leak-1229-26", dataLeAk1229);
		android.util.Log.d("leak-1237-26", dataLeAk1237);
		android.util.Log.d("leak-1239-26", dataLeAk1239);
		android.util.Log.d("leak-1240-26", dataLeAk1240);
		android.util.Log.d("leak-1241-26", dataLeAk1241);
		android.util.Log.d("leak-1242-26", dataLeAk1242);
		android.util.Log.d("leak-1244-26", dataLeAk1244);
		android.util.Log.d("leak-1245-26", dataLeAk1245);
		android.util.Log.d("leak-1246-26", dataLeAk1246);
		android.util.Log.d("leak-1248-26", dataLeAk1248);
		android.util.Log.d("leak-1249-26", dataLeAk1249);
		android.util.Log.d("leak-1250-26", dataLeAk1250);
		android.util.Log.d("leak-1251-26", dataLeAk1251);
		android.util.Log.d("leak-1252-26", dataLeAk1252);
		IntentFilter filter = FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
        filter.addAction(DATA_CHANGED);
        return filter;
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        dataLeAk1252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1202-27", dataLeAk1202);
		android.util.Log.d("leak-1206-27", dataLeAk1206);
		android.util.Log.d("leak-1210-27", dataLeAk1210);
		android.util.Log.d("leak-1211-27", dataLeAk1211);
		android.util.Log.d("leak-1212-27", dataLeAk1212);
		android.util.Log.d("leak-1213-27", dataLeAk1213);
		android.util.Log.d("leak-1214-27", dataLeAk1214);
		android.util.Log.d("leak-1215-27", dataLeAk1215);
		android.util.Log.d("leak-1216-27", dataLeAk1216);
		android.util.Log.d("leak-1217-27", dataLeAk1217);
		android.util.Log.d("leak-1218-27", dataLeAk1218);
		android.util.Log.d("leak-1219-27", dataLeAk1219);
		android.util.Log.d("leak-1221-27", dataLeAk1221);
		android.util.Log.d("leak-1223-27", dataLeAk1223);
		android.util.Log.d("leak-1229-27", dataLeAk1229);
		android.util.Log.d("leak-1237-27", dataLeAk1237);
		android.util.Log.d("leak-1239-27", dataLeAk1239);
		android.util.Log.d("leak-1240-27", dataLeAk1240);
		android.util.Log.d("leak-1241-27", dataLeAk1241);
		android.util.Log.d("leak-1242-27", dataLeAk1242);
		android.util.Log.d("leak-1244-27", dataLeAk1244);
		android.util.Log.d("leak-1245-27", dataLeAk1245);
		android.util.Log.d("leak-1246-27", dataLeAk1246);
		android.util.Log.d("leak-1248-27", dataLeAk1248);
		android.util.Log.d("leak-1249-27", dataLeAk1249);
		android.util.Log.d("leak-1250-27", dataLeAk1250);
		android.util.Log.d("leak-1251-27", dataLeAk1251);
		android.util.Log.d("leak-1252-27", dataLeAk1252);
		return new BroadcastReceiver() {
            final String dataLeAk1296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			final String dataLeAk1293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk1253 = "";

			@Override
            public void onReceive(Context context, Intent intent) {
                dataLeAk1253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1292-0", dataLeAk1292);
				android.util.Log.d("leak-1253-0", dataLeAk1253);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        int type = intent.getIntExtra(FileOperation.TYPE, FileOperation.EMPTY);
                        if (type == FileOperation.MOVE) {
                            ArrayList<String> movedFilesPaths = intent
                                    .getStringArrayListExtra(Move.MOVED_FILES_PATHS);
                            for (int i = 0; i < movedFilesPaths.size(); i++) {
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
                                    final String dataLeAk1295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

									String dataLeAk1254 = "";

									@Override
                                    public void onAlbumLoaded(Album album) {
                                        dataLeAk1254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-1294-0", dataLeAk1294);
										android.util.Log.d("leak-1293-0", dataLeAk1293);
										android.util.Log.d("leak-1254-0", dataLeAk1254);
										int index = albumItemIndex;
                                        ItemActivity.this.album = album;
                                        if (index >= album.getAlbumItems().size()) {
                                            index = album.getAlbumItems().size() - 1;
                                        }
                                        if (index >= 0) {
                                            ((ViewPagerAdapter) viewPager.getAdapter()).setAlbum(album);
                                            albumItem = album.getAlbumItems().get(index);
                                            viewPager.getAdapter().notifyDataSetChanged();
                                            viewPager.setCurrentItem(index);

                                            final ActionBar actionBar = getSupportActionBar();
                                            if (actionBar != null) {
                                                actionBar.setTitle(albumItem.getName());
                                            }

                                            ViewPagerAdapter adapter = (ViewPagerAdapter) viewPager.getAdapter();
                                            ViewHolder viewHolder = adapter.findViewHolderByTag(albumItem.getPath());
                                            if (viewHolder != null) {
                                                onShowViewHolder(viewHolder);
                                            } else {
                                                ((ViewPagerAdapter) viewPager.getAdapter())
                                                        .addOnInstantiateItemCallback(new ViewPagerOnInstantiateItemCallback() {
                                                            String dataLeAk1255 = "";

															@Override
                                                            public boolean onInstantiateItem(ViewHolder viewHolder) {
                                                                dataLeAk1255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
																android.util.Log.d("leak-1297-0", dataLeAk1297);
																android.util.Log.d("leak-1296-0", dataLeAk1296);
																android.util.Log.d("leak-1295-0", dataLeAk1295);
																android.util.Log.d("leak-1255-0", dataLeAk1255);
																if (viewHolder.albumItem.getPath().equals(albumItem.getPath())) {
                                                                    onShowViewHolder(viewHolder);
                                                                    return false;
                                                                }
                                                                return true;
                                                            }
                                                        });
                                            }
                                        } else {
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
