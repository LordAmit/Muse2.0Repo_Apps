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

    String dataLeAk2396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2396 = android.util.Log.d("leak-2396", dataLeAk2396);

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
        String dataLeAk2397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2397 = android.util.Log.d("leak-2397", dataLeAk2397);

		@Override
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            String dataLeAk2398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2398 = android.util.Log.d("leak-2398", dataLeAk2398);
			if (isReturning) {
                String dataLeAk2399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2399 = android.util.Log.d("leak-2399", dataLeAk2399);
				ViewGroup v = viewPager.findViewWithTag(albumItem.getPath());
                View sharedElement = v.findViewById(R.id.image);
                if (sharedElement == null) {
                    String dataLeAk2400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2400 = android.util.Log.d("leak-2400", dataLeAk2400);
					names.clear();
                    sharedElements.clear();
                } else {
                    String dataLeAk2401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2401 = android.util.Log.d("leak-2401", dataLeAk2401);
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
        String dataLeAk2402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2402 = android.util.Log.d("leak-2402", dataLeAk2402);

		@Override
        public void onTransitionStart(@NonNull Transition transition) {
            //hide toolbar & statusbar
            float toolbar_translationY = -(toolbar.getHeight());
			String dataLeAk2403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2403 = android.util.Log.d("leak-2403", dataLeAk2403);
            float bottomBar_translationY = ((View) bottomBar.getParent()).getHeight();
            toolbar.setTranslationY(toolbar_translationY);
            ((View) bottomBar.getParent()).setTranslationY(bottomBar_translationY);
            super.onTransitionStart(transition);
        }

        @Override
        public void onTransitionEnd(@NonNull Transition transition) {
            ViewHolder viewHolder = ((ViewPagerAdapter)
                    viewPager.getAdapter()).findViewHolderByTag(albumItem.getPath());
			String dataLeAk2404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2404 = android.util.Log.d("leak-2404", dataLeAk2404);
            if (viewHolder == null) {
                String dataLeAk2405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2405 = android.util.Log.d("leak-2405", dataLeAk2405);
				return;
            }

            if (!isReturning) {
                String dataLeAk2406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2406 = android.util.Log.d("leak-2406", dataLeAk2406);
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
		String dataLeAk2407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2407 = android.util.Log.d("leak-2407", dataLeAk2407);
        setContentView(R.layout.activity_item);

        MediaProvider.checkPermission(this);

        view_only = getIntent().getBooleanExtra(VIEW_ONLY, false);

        if (!view_only && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2408 = android.util.Log.d("leak-2408", dataLeAk2408);
			if (savedInstanceState == null) {
                String dataLeAk2409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2409 = android.util.Log.d("leak-2409", dataLeAk2409);
				postponeEnterTransition();
            }
            setEnterSharedElementCallback(sharedElementCallback);
            getWindow().getSharedElementEnterTransition().addListener(transitionListener);
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2410 = android.util.Log.d("leak-2410", dataLeAk2410);
			actionBar.setDisplayHomeAsUpEnabled(true);
        }

        bottomBar = findViewById(R.id.bottom_bar);

        if (view_only) {
            String dataLeAk2411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2411 = android.util.Log.d("leak-2411", dataLeAk2411);
			ImageView delete = findViewById(R.id.delete_button);
            ((View) delete.getParent()).setVisibility(View.GONE);

            ImageView edit = findViewById(R.id.edit_button);
            ((View) edit.getParent()).setVisibility(View.GONE);
        }

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2412 = android.util.Log.d("leak-2412", dataLeAk2412);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk2413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2413 = android.util.Log.d("leak-2413", dataLeAk2413);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk2414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2414 = android.util.Log.d("leak-2414", dataLeAk2414);
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
            String dataLeAk2415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2415 = android.util.Log.d("leak-2415", dataLeAk2415);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk2416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2416 = android.util.Log.d("leak-2416", dataLeAk2416);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk2417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2417 = android.util.Log.d("leak-2417", dataLeAk2417);
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
            String dataLeAk2418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2418 = android.util.Log.d("leak-2418", dataLeAk2418);
			String path;
            if (savedInstanceState != null && savedInstanceState.containsKey(ALBUM_PATH)) {
                String dataLeAk2419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2419 = android.util.Log.d("leak-2419", dataLeAk2419);
				path = savedInstanceState.getString(ALBUM_PATH);
            } else {
                String dataLeAk2420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2420 = android.util.Log.d("leak-2420", dataLeAk2420);
				path = getIntent().getStringExtra(ALBUM_PATH);
            }
            MediaProvider.loadAlbum(this, path,
                    new MediaProvider.OnAlbumLoadedCallback() {
                        String dataLeAk2421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2421 = android.util.Log.d("leak-2421", dataLeAk2421);

						@Override
                        public void onAlbumLoaded(Album album) {
                            String dataLeAk2422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2422 = android.util.Log.d("leak-2422", dataLeAk2422);
							ItemActivity.this.album = album;
                            ItemActivity.this.onAlbumLoaded(savedInstanceState);
                        }
                    });
        } else {
            String dataLeAk2423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2423 = android.util.Log.d("leak-2423", dataLeAk2423);
			album = getIntent().getExtras().getParcelable(ALBUM);
            onAlbumLoaded(savedInstanceState);
        }
    }

    private void onAlbumLoaded(Bundle savedInstanceState) {
        String dataLeAk2424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2424 = android.util.Log.d("leak-2424", dataLeAk2424);
		if (albumItem == null) {
            String dataLeAk2425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2425 = android.util.Log.d("leak-2425", dataLeAk2425);
			if (savedInstanceState == null) {
                String dataLeAk2426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2426 = android.util.Log.d("leak-2426", dataLeAk2426);
				int position = getIntent().getIntExtra(ITEM_POSITION, 0);
                if (album != null && position >= 0 && position < album.getAlbumItems().size()) {
                    String dataLeAk2427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2427 = android.util.Log.d("leak-2427", dataLeAk2427);
					albumItem = album.getAlbumItems().get(position);
                    albumItem.isSharedElement = true;
                }
            } else {
                String dataLeAk2428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2428 = android.util.Log.d("leak-2428", dataLeAk2428);
				albumItem = savedInstanceState.getParcelable(ALBUM_ITEM);
                if (albumItem != null && albumItem instanceof Photo) {
                    String dataLeAk2429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2429 = android.util.Log.d("leak-2429", dataLeAk2429);
					Photo photo = (Photo) albumItem;
                    ImageViewState imageViewState
                            = (ImageViewState) savedInstanceState.getSerializable(IMAGE_VIEW_SAVED_STATE);
                    photo.putImageViewSavedState(imageViewState);
                }
                if (savedInstanceState.getBoolean(INFO_DIALOG_SHOWN, false)) {
                    String dataLeAk2430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2430 = android.util.Log.d("leak-2430", dataLeAk2430);
					showInfoDialog();
                }
            }
        }

        if (albumItem == null) {
            String dataLeAk2431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2431 = android.util.Log.d("leak-2431", dataLeAk2431);
			return;
        }

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk2432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2432 = android.util.Log.d("leak-2432", dataLeAk2432);
			actionBar.setTitle(albumItem.getName());
        }

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(album));
        int currentItem = album.getAlbumItems().indexOf(albumItem);
        viewPager.setCurrentItem(currentItem >= 0 ? currentItem : 0, false);
        viewPager.setPageTransformer(false, new ParallaxTransformer());
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            String dataLeAk2433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2433 = android.util.Log.d("leak-2433", dataLeAk2433);

			private final int color = ContextCompat.getColor(ItemActivity.this, R.color.white);

            @Override
            public void onPageSelected(int position) {
                String dataLeAk2434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2434 = android.util.Log.d("leak-2434", dataLeAk2434);
				//set new AlbumItem
                albumItem = album.getAlbumItems().get(position);
                ColorFade.fadeToolbarTitleColor(toolbar, color,
                        new ColorFade.ToolbarTitleFadeCallback() {
                            String dataLeAk2435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2435 = android.util.Log.d("leak-2435", dataLeAk2435);

							@Override
                            public void setTitle(Toolbar toolbar) {
                                String dataLeAk2436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2436 = android.util.Log.d("leak-2436", dataLeAk2436);
								toolbar.setTitle(albumItem.getName() != null ? albumItem.getName() : "");
                            }
                        });

                ViewHolder viewHolder = ((ViewPagerAdapter) viewPager.getAdapter())
                        .findViewHolderByTag(albumItem.getPath());
                if (viewHolder != null) {
                    String dataLeAk2437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2437 = android.util.Log.d("leak-2437", dataLeAk2437);
					onShowViewHolder(viewHolder);
                }
            }
        });

        if (!enterTransitionPostponed()) {
            String dataLeAk2438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2438 = android.util.Log.d("leak-2438", dataLeAk2438);
			albumItem.isSharedElement = false;
            //there is no sharedElementTransition
            ViewPagerAdapter adapter = (ViewPagerAdapter) viewPager.getAdapter();
            ViewHolder viewHolder = adapter.findViewHolderByTag(albumItem.getPath());
            if (viewHolder != null) {
                String dataLeAk2439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2439 = android.util.Log.d("leak-2439", dataLeAk2439);
				onShowViewHolder(viewHolder);
            } else {
                String dataLeAk2440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2440 = android.util.Log.d("leak-2440", dataLeAk2440);
				((ViewPagerAdapter) viewPager.getAdapter())
                        .addOnInstantiateItemCallback(new ViewPagerOnInstantiateItemCallback() {
                            String dataLeAk2441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2441 = android.util.Log.d("leak-2441", dataLeAk2441);

							@Override
                            public boolean onInstantiateItem(ViewHolder viewHolder) {
                                String dataLeAk2442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2442 = android.util.Log.d("leak-2442", dataLeAk2442);
								if (viewHolder.albumItem.getPath().equals(albumItem.getPath())) {
                                    String dataLeAk2443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2443 = android.util.Log.d("leak-2443", dataLeAk2443);
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
        String dataLeAk2444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2444 = android.util.Log.d("leak-2444", dataLeAk2444);
		viewHolder.onSharedElementEnter();

        if (menu != null) {
            String dataLeAk2445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2445 = android.util.Log.d("leak-2445", dataLeAk2445);
			menu.findItem(R.id.set_as).setVisible(albumItem instanceof Photo);
            menu.findItem(R.id.print).setVisible(albumItem instanceof Photo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk2446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2446 = android.util.Log.d("leak-2446", dataLeAk2446);
        getMenuInflater().inflate(R.menu.item, menu);
        this.menu = menu;
        if (view_only) {
            String dataLeAk2447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2447 = android.util.Log.d("leak-2447", dataLeAk2447);
			menu.findItem(R.id.copy).setVisible(false);
            menu.findItem(R.id.move).setVisible(false);
            menu.findItem(R.id.rename).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        String dataLeAk2448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2448 = android.util.Log.d("leak-2448", dataLeAk2448);
		if (theme.isBaseLight()) {
            String dataLeAk2449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2449 = android.util.Log.d("leak-2449", dataLeAk2449);
			int black = ContextCompat.getColor(this, R.color.black);
            for (int i = 0; i < menu.size(); i++) {
                String dataLeAk2450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2450 = android.util.Log.d("leak-2450", dataLeAk2450);
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
        String dataLeAk2451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2451 = android.util.Log.d("leak-2451", dataLeAk2451);
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
        String dataLeAk2452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2452 = android.util.Log.d("leak-2452", dataLeAk2452);
		if (!(albumItem instanceof Photo)) {
            String dataLeAk2453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2453 = android.util.Log.d("leak-2453", dataLeAk2453);
			return;
        }

        Uri uri = albumItem.getUri(this);

        Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
        intent.setDataAndType(uri, MediaType.getMimeType(this, uri));
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            String dataLeAk2454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2454 = android.util.Log.d("leak-2454", dataLeAk2454);
			startActivityForResult(Intent.createChooser(intent,
                    getString(R.string.set_as)), 13);
        } catch (SecurityException se) {
            String dataLeAk2455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2455 = android.util.Log.d("leak-2455", dataLeAk2455);
			Toast.makeText(this, "Error (SecurityException)", Toast.LENGTH_SHORT).show();
            se.printStackTrace();
        } catch (ActivityNotFoundException anfe) {
            String dataLeAk2456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2456 = android.util.Log.d("leak-2456", dataLeAk2456);
			Toast.makeText(this, "No App found", Toast.LENGTH_SHORT).show();
            anfe.printStackTrace();
        }
    }

    public void openWith() {
        String dataLeAk2457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2457 = android.util.Log.d("leak-2457", dataLeAk2457);
		Uri uri = albumItem.getUri(this);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, MediaType.getMimeType(this, uri));
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            String dataLeAk2458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2458 = android.util.Log.d("leak-2458", dataLeAk2458);
			startActivityForResult(Intent.createChooser(intent,
                    getString(R.string.open_with)), 13);
        } catch (SecurityException se) {
            String dataLeAk2459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2459 = android.util.Log.d("leak-2459", dataLeAk2459);
			Toast.makeText(this, "Error (SecurityException)", Toast.LENGTH_SHORT).show();
            se.printStackTrace();
        } catch (ActivityNotFoundException anfe) {
            String dataLeAk2460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2460 = android.util.Log.d("leak-2460", dataLeAk2460);
			Toast.makeText(this, getString(R.string.open_with_error, albumItem.getType(this)), Toast.LENGTH_SHORT).show();
            anfe.printStackTrace();
        }
    }

    public void sharePhoto() {
        String dataLeAk2461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2461 = android.util.Log.d("leak-2461", dataLeAk2461);
		Uri uri = albumItem.getUri(this);

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .addStream(uri)
                .setType(MediaType.getMimeType(this, uri))
                .getIntent();

        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        String title = getString(R.string.share_item, albumItem.getType(this));
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            String dataLeAk2462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2462 = android.util.Log.d("leak-2462", dataLeAk2462);
			startActivity(Intent.createChooser(shareIntent, title));
        } else {
            String dataLeAk2463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2463 = android.util.Log.d("leak-2463", dataLeAk2463);
			String error = getString(R.string.share_error, albumItem.getType(this));
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    public void printPhoto() {
        String dataLeAk2464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2464 = android.util.Log.d("leak-2464", dataLeAk2464);
		if (!(albumItem instanceof Photo)) {
            String dataLeAk2465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2465 = android.util.Log.d("leak-2465", dataLeAk2465);
			Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
            return;
        }

        PrintHelper photoPrinter = new PrintHelper(this);
        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        try {
            String dataLeAk2466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2466 = android.util.Log.d("leak-2466", dataLeAk2466);
			photoPrinter.printBitmap(albumItem.getPath(),
                    albumItem.getUri(this));
        } catch (FileNotFoundException e) {
            String dataLeAk2467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2467 = android.util.Log.d("leak-2467", dataLeAk2467);
			Toast.makeText(this, "Error (FileNotFoundException)", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void editPhoto() {
        String dataLeAk2468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2468 = android.util.Log.d("leak-2468", dataLeAk2468);
		Uri uri = albumItem.getUri(this);

        Intent intent = new Intent(Intent.ACTION_EDIT)
                .setDataAndType(uri, MediaType.getMimeType(this, uri))
                .putExtra(EditImageActivity.IMAGE_PATH, albumItem.getPath())
                .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            String dataLeAk2469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2469 = android.util.Log.d("leak-2469", dataLeAk2469);
			if (intent.resolveActivity(getPackageManager()) != null) {
                String dataLeAk2470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2470 = android.util.Log.d("leak-2470", dataLeAk2470);
				String title = getString(R.string.edit_item, albumItem.getType(this));
                startActivity(Intent.createChooser(intent, title));
            } else {
                String dataLeAk2471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2471 = android.util.Log.d("leak-2471", dataLeAk2471);
				Toast.makeText(this, getString(R.string.edit_error, albumItem.getType(this)),
                        Toast.LENGTH_SHORT).show();
            }
        } catch (SecurityException se) {
            String dataLeAk2472 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2472 = android.util.Log.d("leak-2472", dataLeAk2472);
			Toast.makeText(this, "Error (SecurityException)", Toast.LENGTH_SHORT).show();
            se.printStackTrace();
        }
    }

    public void showDeleteDialog() {
        String dataLeAk2473 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2473 = android.util.Log.d("leak-2473", dataLeAk2473);
		new AlertDialog.Builder(this, theme.getDialogThemeRes())
                .setTitle(getString(R.string.delete_item, albumItem.getType(this)) + "?")
                .setNegativeButton(getString(R.string.no), null)
                .setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                    String dataLeAk2474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2474 = android.util.Log.d("leak-2474", dataLeAk2474);

					@Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dataLeAk2475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2475 = android.util.Log.d("leak-2475", dataLeAk2475);
						deletePhoto();
                    }
                })
                .create().show();
    }

    public void deletePhoto() {
        String dataLeAk2476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2476 = android.util.Log.d("leak-2476", dataLeAk2476);
		if (!MediaProvider.checkPermission(this)) {
            String dataLeAk2477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2477 = android.util.Log.d("leak-2477", dataLeAk2477);
			return;
        }

        if (albumItem == null) {
            String dataLeAk2478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2478 = android.util.Log.d("leak-2478", dataLeAk2478);
			return;
        }

        final File_POJO[] files = new File_POJO[]{new File_POJO(albumItem.getPath(), true)};

        registerLocalBroadcastReceiver(new BroadcastReceiver() {
            String dataLeAk2479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2479 = android.util.Log.d("leak-2479", dataLeAk2479);

			@Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk2480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2480 = android.util.Log.d("leak-2480", dataLeAk2480);
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
        String dataLeAk2481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2481 = android.util.Log.d("leak-2481", dataLeAk2481);
		File_POJO file = new File_POJO(albumItem.getPath(), true).setName(albumItem.getName());
        Rename.Util.getRenameDialog(this, file, new BroadcastReceiver() {
            String dataLeAk2482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2482 = android.util.Log.d("leak-2482", dataLeAk2482);

			@Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk2483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2483 = android.util.Log.d("leak-2483", dataLeAk2483);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        //refresh data
                        final Activity activity = ItemActivity.this;

                        String newFilePath = intent.getStringExtra(Rename.NEW_FILE_PATH);
                        if (newFilePath == null) {
                            String dataLeAk2484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2484 = android.util.Log.d("leak-2484", dataLeAk2484);
							return;
                        }
                        int index = newFilePath.lastIndexOf("/");
                        final String albumPath = newFilePath.substring(0, index);
                        getIntent().putExtra(ALBUM_PATH, albumPath);
                        getIntent().putExtra(ITEM_POSITION, album.getAlbumItems().indexOf(albumItem));

                        boolean hiddenFolders = Settings.getInstance(activity).getHiddenFolders();
                        new MediaProvider(activity).loadAlbums(activity, hiddenFolders,
                                new MediaProvider.OnMediaLoadedCallback() {
                                    String dataLeAk2485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2485 = android.util.Log.d("leak-2485", dataLeAk2485);

									@Override
                                    public void onMediaLoaded(ArrayList<Album> albums) {
                                        String dataLeAk2486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2486 = android.util.Log.d("leak-2486", dataLeAk2486);
										//reload activity
                                        MediaProvider.loadAlbum(activity, albumPath,
                                                new MediaProvider.OnAlbumLoadedCallback() {
                                                    String dataLeAk2487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk2487 = android.util.Log.d("leak-2487", dataLeAk2487);

													@Override
                                                    public void onAlbumLoaded(Album album) {
                                                        String dataLeAk2488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
														Object throwawayLeAk2488 = android.util.Log.d("leak-2488", dataLeAk2488);
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
                                        String dataLeAk2489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2489 = android.util.Log.d("leak-2489", dataLeAk2489);
										finish();
                                    }

                                    @Override
                                    public void needPermission() {
                                        String dataLeAk2490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2490 = android.util.Log.d("leak-2490", dataLeAk2490);
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
        String dataLeAk2491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2491 = android.util.Log.d("leak-2491", dataLeAk2491);
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
                    String dataLeAk2492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2492 = android.util.Log.d("leak-2492", dataLeAk2492);

					@Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        String dataLeAk2493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2493 = android.util.Log.d("leak-2493", dataLeAk2493);
						infoDialog = null;
                    }
                });
        if (exifSupported && !view_only) {
            String dataLeAk2494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2494 = android.util.Log.d("leak-2494", dataLeAk2494);
			builder.setNeutralButton(R.string.edit_exif, new DialogInterface.OnClickListener() {
                String dataLeAk2495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2495 = android.util.Log.d("leak-2495", dataLeAk2495);

				@Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String dataLeAk2496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2496 = android.util.Log.d("leak-2496", dataLeAk2496);
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
                    String dataLeAk2497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2497 = android.util.Log.d("leak-2497", dataLeAk2497);

					@Override
                    public void onDataRetrieved() {
                        String dataLeAk2498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2498 = android.util.Log.d("leak-2498", dataLeAk2498);
						ItemActivity.this.runOnUiThread(new Runnable() {
                            String dataLeAk2499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2499 = android.util.Log.d("leak-2499", dataLeAk2499);

							@Override
                            public void run() {
                                String dataLeAk2500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2500 = android.util.Log.d("leak-2500", dataLeAk2500);
								RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ItemActivity.this);
                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(adapter);

                                final View scrollIndicatorTop = rootView.findViewById(R.id.scroll_indicator_top);
                                final View scrollIndicatorBottom = rootView.findViewById(R.id.scroll_indicator_bottom);

                                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                    String dataLeAk2501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2501 = android.util.Log.d("leak-2501", dataLeAk2501);

									@Override
                                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                        super.onScrolled(recyclerView, dx, dy);
										String dataLeAk2502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2502 = android.util.Log.d("leak-2502", dataLeAk2502);
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
                        String dataLeAk2503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2503 = android.util.Log.d("leak-2503", dataLeAk2503);
						Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public Context getContext() {
                        String dataLeAk2504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2504 = android.util.Log.d("leak-2504", dataLeAk2504);
						return ItemActivity.this;
                    }
                });
    }

    public void bottomBarOnClick(final View v) {
        String dataLeAk2505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2505 = android.util.Log.d("leak-2505", dataLeAk2505);
		Drawable d = ((ImageView) v).getDrawable();
        if (d instanceof Animatable) {
            String dataLeAk2506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2506 = android.util.Log.d("leak-2506", dataLeAk2506);
			((Animatable) d).start();
            new Handler().postDelayed(new Runnable() {
                String dataLeAk2507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2507 = android.util.Log.d("leak-2507", dataLeAk2507);

				@Override
                public void run() {
                    String dataLeAk2508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2508 = android.util.Log.d("leak-2508", dataLeAk2508);
					bottomBarAction(v);
                }
            }, (int) (400 * Util.getAnimatorSpeed(this)));
        } else {
            String dataLeAk2509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2509 = android.util.Log.d("leak-2509", dataLeAk2509);
			bottomBarAction(v);
        }
    }

    private void bottomBarAction(View v) {
        String dataLeAk2510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2510 = android.util.Log.d("leak-2510", dataLeAk2510);
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
        String dataLeAk2511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2511 = android.util.Log.d("leak-2511", dataLeAk2511);
		systemUiVisible = !systemUiVisible;
        showSystemUI(systemUiVisible);
    }

    public static void videoOnClick(Context context, AlbumItem albumItem) {
        String dataLeAk2512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2512 = android.util.Log.d("leak-2512", dataLeAk2512);
		if (!(albumItem instanceof Video)) {
            String dataLeAk2513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2513 = android.util.Log.d("leak-2513", dataLeAk2513);
			return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(albumItem.getUri(context), "video/*");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try {
            String dataLeAk2514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2514 = android.util.Log.d("leak-2514", dataLeAk2514);
			context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            String dataLeAk2515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2515 = android.util.Log.d("leak-2515", dataLeAk2515);
			Toast.makeText(context, "No App found to play your video", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void showUI(boolean show) {
        String dataLeAk2516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2516 = android.util.Log.d("leak-2516", dataLeAk2516);
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
        String dataLeAk2517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2517 = android.util.Log.d("leak-2517", dataLeAk2517);
		new Handler().post(new Runnable() {
            String dataLeAk2518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2518 = android.util.Log.d("leak-2518", dataLeAk2518);

			@Override
            public void run() {
                String dataLeAk2519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2519 = android.util.Log.d("leak-2519", dataLeAk2519);
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
		String dataLeAk2520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2520 = android.util.Log.d("leak-2520", dataLeAk2520);
        this.finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk2521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2521 = android.util.Log.d("leak-2521", dataLeAk2521);
        if (albumItem instanceof Photo) {
            String dataLeAk2522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2522 = android.util.Log.d("leak-2522", dataLeAk2522);
			View itemView = viewPager.findViewWithTag(albumItem.getPath());
            if (itemView != null) {
                String dataLeAk2523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2523 = android.util.Log.d("leak-2523", dataLeAk2523);
				View view = itemView.findViewById(R.id.subsampling);
                if (view instanceof SubsamplingScaleImageView) {
                    String dataLeAk2524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2524 = android.util.Log.d("leak-2524", dataLeAk2524);
					SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) view;
                    ImageViewState state = imageView.getState();
                    if (state != null) {
                        String dataLeAk2525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2525 = android.util.Log.d("leak-2525", dataLeAk2525);
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
        String dataLeAk2526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2526 = android.util.Log.d("leak-2526", dataLeAk2526);
		if (view_only) {
            String dataLeAk2527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2527 = android.util.Log.d("leak-2527", dataLeAk2527);
			/*if (getIntent().getBooleanExtra(FINISH_AFTER, false)) {
                this.finishAffinity();
            } else {
                this.finish();
            }*/
            this.finish();
        } else {
            String dataLeAk2528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2528 = android.util.Log.d("leak-2528", dataLeAk2528);
			showUI(false);
            if (viewPager != null && viewPager.getAdapter() != null && albumItem != null) {
                String dataLeAk2529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2529 = android.util.Log.d("leak-2529", dataLeAk2529);
				ViewHolder viewHolder = ((ViewPagerAdapter)
                        viewPager.getAdapter()).findViewHolderByTag(albumItem.getPath());
                if (viewHolder != null) {
                    String dataLeAk2530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2530 = android.util.Log.d("leak-2530", dataLeAk2530);
					viewHolder.onSharedElementExit(new ItemActivity.Callback() {
                        String dataLeAk2531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk2531 = android.util.Log.d("leak-2531", dataLeAk2531);

						@Override
                        public void done() {
                            String dataLeAk2532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2532 = android.util.Log.d("leak-2532", dataLeAk2532);
							setResultAndFinish();
                        }
                    });
                }
            }
        }
    }

    public void setResultAndFinish() {
        String dataLeAk2533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2533 = android.util.Log.d("leak-2533", dataLeAk2533);
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
        String dataLeAk2534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2534 = android.util.Log.d("leak-2534", dataLeAk2534);
		return R.style.CameraRoll_Theme_PhotoView;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk2535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2535 = android.util.Log.d("leak-2535", dataLeAk2535);
		return R.style.CameraRoll_Theme_Light_PhotoView;
    }

    @Override
    public IntentFilter getBroadcastIntentFilter() {
        String dataLeAk2536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2536 = android.util.Log.d("leak-2536", dataLeAk2536);
		IntentFilter filter = FileOperation.Util.getIntentFilter(super.getBroadcastIntentFilter());
        filter.addAction(DATA_CHANGED);
        return filter;
    }

    @Override
    public BroadcastReceiver getDefaultLocalBroadcastReceiver() {
        String dataLeAk2537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2537 = android.util.Log.d("leak-2537", dataLeAk2537);
		return new BroadcastReceiver() {
            String dataLeAk2538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2538 = android.util.Log.d("leak-2538", dataLeAk2538);

			@Override
            public void onReceive(Context context, Intent intent) {
                String dataLeAk2539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2539 = android.util.Log.d("leak-2539", dataLeAk2539);
				switch (intent.getAction()) {
                    case FileOperation.RESULT_DONE:
                        int type = intent.getIntExtra(FileOperation.TYPE, FileOperation.EMPTY);
                        if (type == FileOperation.MOVE) {
                            String dataLeAk2540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk2540 = android.util.Log.d("leak-2540", dataLeAk2540);
							ArrayList<String> movedFilesPaths = intent
                                    .getStringArrayListExtra(Move.MOVED_FILES_PATHS);
                            for (int i = 0; i < movedFilesPaths.size(); i++) {
                                String dataLeAk2541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk2541 = android.util.Log.d("leak-2541", dataLeAk2541);
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
                                    String dataLeAk2542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk2542 = android.util.Log.d("leak-2542", dataLeAk2542);

									@Override
                                    public void onAlbumLoaded(Album album) {
                                        String dataLeAk2543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk2543 = android.util.Log.d("leak-2543", dataLeAk2543);
										int index = albumItemIndex;
                                        ItemActivity.this.album = album;
                                        if (index >= album.getAlbumItems().size()) {
                                            String dataLeAk2544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk2544 = android.util.Log.d("leak-2544", dataLeAk2544);
											index = album.getAlbumItems().size() - 1;
                                        }
                                        if (index >= 0) {
                                            String dataLeAk2545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk2545 = android.util.Log.d("leak-2545", dataLeAk2545);
											((ViewPagerAdapter) viewPager.getAdapter()).setAlbum(album);
                                            albumItem = album.getAlbumItems().get(index);
                                            viewPager.getAdapter().notifyDataSetChanged();
                                            viewPager.setCurrentItem(index);

                                            final ActionBar actionBar = getSupportActionBar();
                                            if (actionBar != null) {
                                                String dataLeAk2546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk2546 = android.util.Log.d("leak-2546", dataLeAk2546);
												actionBar.setTitle(albumItem.getName());
                                            }

                                            ViewPagerAdapter adapter = (ViewPagerAdapter) viewPager.getAdapter();
                                            ViewHolder viewHolder = adapter.findViewHolderByTag(albumItem.getPath());
                                            if (viewHolder != null) {
                                                String dataLeAk2547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk2547 = android.util.Log.d("leak-2547", dataLeAk2547);
												onShowViewHolder(viewHolder);
                                            } else {
                                                String dataLeAk2548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk2548 = android.util.Log.d("leak-2548", dataLeAk2548);
												((ViewPagerAdapter) viewPager.getAdapter())
                                                        .addOnInstantiateItemCallback(new ViewPagerOnInstantiateItemCallback() {
                                                            String dataLeAk2549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
															Object throwawayLeAk2549 = android.util.Log.d("leak-2549", dataLeAk2549);

															@Override
                                                            public boolean onInstantiateItem(ViewHolder viewHolder) {
                                                                String dataLeAk2550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
																Object throwawayLeAk2550 = android.util.Log.d("leak-2550", dataLeAk2550);
																if (viewHolder.albumItem.getPath().equals(albumItem.getPath())) {
                                                                    String dataLeAk2551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
																	Object throwawayLeAk2551 = android.util.Log.d("leak-2551", dataLeAk2551);
																	onShowViewHolder(viewHolder);
                                                                    return false;
                                                                }
                                                                return true;
                                                            }
                                                        });
                                            }
                                        } else {
                                            String dataLeAk2552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk2552 = android.util.Log.d("leak-2552", dataLeAk2552);
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
