package us.koller.cameraroll.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.data.models.VirtualAlbum;
import us.koller.cameraroll.data.provider.Provider;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.util.Util;

public class VirtualAlbumsActivity extends ThemeableActivity {

    String dataLeAk1388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1388 = android.util.Log.d("leak-1388", dataLeAk1388);

	private ArrayList<VirtualAlbum> virtualAlbums;

    private RecyclerViewAdapter adapter;
    private RecyclerViewAdapter.OnVirtualAlbumChangedListener onVirtualAlbumChangedListener;

    private Menu menu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk1389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1389 = android.util.Log.d("leak-1389", dataLeAk1389);
        setContentView(R.layout.activity_virtual_albums);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk1390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1390 = android.util.Log.d("leak-1390", dataLeAk1390);
			actionBar.setDisplayHomeAsUpEnabled(true);
        }

        virtualAlbums = Provider.getVirtualAlbums(this);
        final TextView emptyStateText = findViewById(R.id.empty_state_text);
        if (virtualAlbums.size() == 0) {
            String dataLeAk1391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1391 = android.util.Log.d("leak-1391", dataLeAk1391);
			emptyStateText.setText(R.string.no_virtual_albums);
            emptyStateText.setVisibility(View.VISIBLE);
        }

        final int accentColor = theme.getAccentColor(this);
        final int toolbarTitleColor = theme.getTextColorPrimary(this);
        final String toolbarTitle = String.valueOf(toolbar.getTitle());

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(virtualAlbums);
        onVirtualAlbumChangedListener = new RecyclerViewAdapter.OnVirtualAlbumChangedListener() {
            String dataLeAk1392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1392 = android.util.Log.d("leak-1392", dataLeAk1392);

			@Override
            public void onVirtualAlbumChanged(VirtualAlbum album) {
                String dataLeAk1393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1393 = android.util.Log.d("leak-1393", dataLeAk1393);
				menu.findItem(R.id.add_virtual_album).setVisible(album == null);

                if (album != null) {
                    String dataLeAk1394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1394 = android.util.Log.d("leak-1394", dataLeAk1394);
					toolbar.setTitle(album.getName());
                    toolbar.setTitleTextColor(accentColor);
                } else {
                    String dataLeAk1395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1395 = android.util.Log.d("leak-1395", dataLeAk1395);
					toolbar.setTitle(toolbarTitle);
                    toolbar.setTitleTextColor(toolbarTitleColor);
                }

                if (album == null) {
                    String dataLeAk1396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1396 = android.util.Log.d("leak-1396", dataLeAk1396);
					if (virtualAlbums.size() == 0) {
                        String dataLeAk1397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1397 = android.util.Log.d("leak-1397", dataLeAk1397);
						emptyStateText.setText(R.string.no_virtual_albums);
                        emptyStateText.setVisibility(View.VISIBLE);
                    } else {
                        String dataLeAk1398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1398 = android.util.Log.d("leak-1398", dataLeAk1398);
						emptyStateText.setVisibility(View.GONE);
                    }
                } else {
                    String dataLeAk1399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1399 = android.util.Log.d("leak-1399", dataLeAk1399);
					if (album.getDirectories().size() == 0) {
                        String dataLeAk1400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1400 = android.util.Log.d("leak-1400", dataLeAk1400);
						emptyStateText.setText(R.string.no_paths);
                        emptyStateText.setVisibility(View.VISIBLE);
                    } else {
                        String dataLeAk1401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1401 = android.util.Log.d("leak-1401", dataLeAk1401);
						emptyStateText.setVisibility(View.GONE);
                    }
                }
            }
        };
        adapter.setOnVirtualAlbumChangedListener(onVirtualAlbumChangedListener);
        recyclerView.setAdapter(adapter);

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk1402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1402 = android.util.Log.d("leak-1402", dataLeAk1402);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk1403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1403 = android.util.Log.d("leak-1403", dataLeAk1403);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk1404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1404 = android.util.Log.d("leak-1404", dataLeAk1404);
					toolbar.setPadding(toolbar.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            toolbar.getPaddingTop() + insets.getSystemWindowInsetTop(),
                            toolbar.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            toolbar.getPaddingBottom());

                    recyclerView.setPadding(recyclerView.getPaddingStart() + insets.getSystemWindowInsetLeft(),
                            recyclerView.getPaddingTop(),
                            recyclerView.getPaddingEnd() + insets.getSystemWindowInsetRight(),
                            recyclerView.getPaddingBottom() + insets.getSystemWindowInsetBottom());

                    // clear this listener so insets aren't re-applied
                    rootView.setOnApplyWindowInsetsListener(null);
                    return insets.consumeSystemWindowInsets();
                }
            });
        } else {
            String dataLeAk1405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1405 = android.util.Log.d("leak-1405", dataLeAk1405);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk1406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1406 = android.util.Log.d("leak-1406", dataLeAk1406);

								@Override
                                public void onGlobalLayout() {
                                    String dataLeAk1407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1407 = android.util.Log.d("leak-1407", dataLeAk1407);
									//hacky way of getting window insets on pre-Lollipop
                                    int[] screenSize = Util.getScreenSize(VirtualAlbumsActivity.this);

                                    int[] windowInsets = new int[]{
                                            Math.abs(screenSize[0] - rootView.getLeft()),
                                            Math.abs(screenSize[1] - rootView.getTop()),
                                            Math.abs(screenSize[2] - rootView.getRight()),
                                            Math.abs(screenSize[3] - rootView.getBottom())};

                                    toolbar.setPadding(toolbar.getPaddingStart() + windowInsets[0],
                                            toolbar.getPaddingTop() + windowInsets[1],
                                            toolbar.getPaddingEnd() + windowInsets[2],
                                            toolbar.getPaddingBottom());

                                    recyclerView.setPadding(recyclerView.getPaddingStart() + windowInsets[0],
                                            recyclerView.getPaddingTop(),
                                            recyclerView.getPaddingEnd() + windowInsets[2],
                                            recyclerView.getPaddingBottom() + windowInsets[3]);

                                    rootView.getViewTreeObserver()
                                            .removeOnGlobalLayoutListener(this);
                                }
                            });
        }

        //needed to achieve transparent statusBar in landscape; don't ask me why, but its working
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
		String dataLeAk1408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1408 = android.util.Log.d("leak-1408", dataLeAk1408);
        getMenuInflater().inflate(R.menu.virtual_albums, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk1409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1409 = android.util.Log.d("leak-1409", dataLeAk1409);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.add_virtual_album:
                AlertDialog dialog = VirtualAlbum.Util.getCreateVirtualAlbumDialog(this,
                        new VirtualAlbum.Util.OnCreateVirtualAlbumCallback() {
                            String dataLeAk1410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1410 = android.util.Log.d("leak-1410", dataLeAk1410);

							@Override
                            public void onVirtualAlbumCreated(VirtualAlbum virtualAlbum) {
                                String dataLeAk1411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1411 = android.util.Log.d("leak-1411", dataLeAk1411);
								virtualAlbums = Provider.getVirtualAlbums(VirtualAlbumsActivity.this);
                                adapter.notifyDataSetChanged();
                                onVirtualAlbumChangedListener.onVirtualAlbumChanged(null);
                            }
                        });
                dialog.show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        String dataLeAk1412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1412 = android.util.Log.d("leak-1412", dataLeAk1412);
		if (adapter.onBackPressed()) {
            super.onBackPressed();
			String dataLeAk1413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1413 = android.util.Log.d("leak-1413", dataLeAk1413);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1414 = android.util.Log.d("leak-1414", dataLeAk1414);
        Provider.saveVirtualAlbums(this);
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk1415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1415 = android.util.Log.d("leak-1415", dataLeAk1415);
		return R.style.CameraRoll_Theme_VirtualDirectories;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1416 = android.util.Log.d("leak-1416", dataLeAk1416);
		return R.style.CameraRoll_Theme_Light_VirtualDirectories;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk1417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1417 = android.util.Log.d("leak-1417", dataLeAk1417);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk1418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1418 = android.util.Log.d("leak-1418", dataLeAk1418);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1419 = android.util.Log.d("leak-1419", dataLeAk1419);
			int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter {

        String dataLeAk1420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1420 = android.util.Log.d("leak-1420", dataLeAk1420);

		private static final int VIRTUAL_ALBUM_VIEW_TYPE = 1;
        private static final int PATH_VIEW_TYPE = 2;

        private ArrayList<VirtualAlbum> virtualAlbums;
        private VirtualAlbum currentAlbum;

        private OnVirtualAlbumChangedListener listener;

        interface OnVirtualAlbumChangedListener {
            void onVirtualAlbumChanged(VirtualAlbum album);
        }

        private static abstract class ViewHolder extends RecyclerView.ViewHolder {

            String dataLeAk1421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1421 = android.util.Log.d("leak-1421", dataLeAk1421);

			private Theme theme;

            TextView textView;
            ImageView deleteButton;
            ImageView folderIndicator;

            public ViewHolder(View itemView) {
                super(itemView);
				String dataLeAk1422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1422 = android.util.Log.d("leak-1422", dataLeAk1422);
                Context context = itemView.getContext();
                theme = Settings.getInstance(context).getThemeInstance(context);

                textView = itemView.findViewById(R.id.text);
                deleteButton = itemView.findViewById(R.id.delete_button);
                int secondaryTextColor = theme.getTextColorSecondary(context);
                deleteButton.setColorFilter(secondaryTextColor, PorterDuff.Mode.SRC_IN);

                folderIndicator = itemView.findViewById(R.id.folder_indicator);
            }

            public Theme getTheme() {
                String dataLeAk1423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1423 = android.util.Log.d("leak-1423", dataLeAk1423);
				return theme;
            }
        }

        private static class VirtualAlbumHolder extends ViewHolder {

            String dataLeAk1424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1424 = android.util.Log.d("leak-1424", dataLeAk1424);

			VirtualAlbumHolder(View itemView) {
                super(itemView);
				String dataLeAk1425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1425 = android.util.Log.d("leak-1425", dataLeAk1425);
                Context context = itemView.getContext();
                Theme theme = getTheme();
                int accentColor = theme.getAccentColor(context);
                textView.setTextColor(accentColor);
                folderIndicator.setColorFilter(accentColor, PorterDuff.Mode.SRC_IN);
            }

            void bind(VirtualAlbum album) {
                String dataLeAk1426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1426 = android.util.Log.d("leak-1426", dataLeAk1426);
				textView.setText(album.getName());
            }
        }

        private static class PathHolder extends ViewHolder {

            String dataLeAk1427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1427 = android.util.Log.d("leak-1427", dataLeAk1427);

			PathHolder(View itemView) {
                super(itemView);
				String dataLeAk1428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1428 = android.util.Log.d("leak-1428", dataLeAk1428);
                Theme theme = getTheme();

                int secondaryTextColor = theme.getTextColorSecondary(itemView.getContext());
                folderIndicator.setColorFilter(secondaryTextColor, PorterDuff.Mode.SRC_IN);
            }

            void bind(String path) {
                String dataLeAk1429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1429 = android.util.Log.d("leak-1429", dataLeAk1429);
				textView.setText(path);
            }
        }

        public RecyclerViewAdapter(ArrayList<VirtualAlbum> virtualAlbums) {
            String dataLeAk1430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1430 = android.util.Log.d("leak-1430", dataLeAk1430);
			this.virtualAlbums = virtualAlbums;
        }

        void setOnVirtualAlbumChangedListener(OnVirtualAlbumChangedListener listener) {
            String dataLeAk1431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1431 = android.util.Log.d("leak-1431", dataLeAk1431);
			this.listener = listener;
        }

        @Override
        public int getItemViewType(int position) {
            String dataLeAk1432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1432 = android.util.Log.d("leak-1432", dataLeAk1432);
			if (currentAlbum != null) {
                String dataLeAk1433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1433 = android.util.Log.d("leak-1433", dataLeAk1433);
				return PATH_VIEW_TYPE;
            }
            return VIRTUAL_ALBUM_VIEW_TYPE;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            String dataLeAk1434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1434 = android.util.Log.d("leak-1434", dataLeAk1434);
			View v;
            switch (viewType) {
                case VIRTUAL_ALBUM_VIEW_TYPE:
                    v = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.virtual_album_cover, parent, false);
                    return new VirtualAlbumHolder(v);
                case PATH_VIEW_TYPE:
                    v = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.virtual_album_path_cover, parent, false);
                    return new PathHolder(v);
                default:
                    return null;
            }

        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            String dataLeAk1435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1435 = android.util.Log.d("leak-1435", dataLeAk1435);
			if (holder instanceof VirtualAlbumHolder) {
                String dataLeAk1436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1436 = android.util.Log.d("leak-1436", dataLeAk1436);
				final VirtualAlbum virtualAlbum = virtualAlbums.get(position);
                ((VirtualAlbumHolder) holder).bind(virtualAlbum);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    String dataLeAk1437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1437 = android.util.Log.d("leak-1437", dataLeAk1437);

					@Override
                    public void onClick(View view) {
                        String dataLeAk1438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1438 = android.util.Log.d("leak-1438", dataLeAk1438);
						currentAlbum = virtualAlbum;
                        //Handler to keep ripple animation
                        new Handler().postDelayed(new Runnable() {
                            String dataLeAk1439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1439 = android.util.Log.d("leak-1439", dataLeAk1439);

							@Override
                            public void run() {
                                String dataLeAk1440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1440 = android.util.Log.d("leak-1440", dataLeAk1440);
								notifyDataSetChanged();
                                if (listener != null) {
                                    String dataLeAk1441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1441 = android.util.Log.d("leak-1441", dataLeAk1441);
									listener.onVirtualAlbumChanged(currentAlbum);
                                }
                            }
                        }, 300);
                    }
                });
                ((VirtualAlbumHolder) holder).deleteButton.
                        setOnClickListener(new View.OnClickListener() {
                            String dataLeAk1442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1442 = android.util.Log.d("leak-1442", dataLeAk1442);

							@Override
                            public void onClick(final View view) {
                                String dataLeAk1443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1443 = android.util.Log.d("leak-1443", dataLeAk1443);
								final int index = virtualAlbums.indexOf(virtualAlbum);
                                Provider.removeVirtualAlbum(view.getContext(), virtualAlbum);
                                virtualAlbums = Provider.getVirtualAlbums(view.getContext());
                                //Handler to keep ripple animation
                                new Handler().postDelayed(new Runnable() {
                                    String dataLeAk1444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1444 = android.util.Log.d("leak-1444", dataLeAk1444);

									@Override
                                    public void run() {
                                        String dataLeAk1445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1445 = android.util.Log.d("leak-1445", dataLeAk1445);
										//notifyDataSetChanged();
                                        notifyItemRemoved(index);
                                        if (listener != null) {
                                            String dataLeAk1446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk1446 = android.util.Log.d("leak-1446", dataLeAk1446);
											listener.onVirtualAlbumChanged(currentAlbum);
                                        }

                                        String message = view.getContext()
                                                .getString(R.string.virtual_album_deleted, virtualAlbum.getName());
                                        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                                    }
                                }, 300);

                                if (virtualAlbum.pinned()) {
                                    String dataLeAk1447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1447 = android.util.Log.d("leak-1447", dataLeAk1447);
									//remove virtualAlbum from pinnedPaths
                                    Provider.unpinPath(view.getContext(), virtualAlbum.getPath());
                                    Provider.savePinnedPaths(view.getContext());
                                }
                            }
                        });
            } else {
                String dataLeAk1448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1448 = android.util.Log.d("leak-1448", dataLeAk1448);
				final String path = currentAlbum.getDirectories().get(position);
                ((PathHolder) holder).bind(path);
                ((PathHolder) holder).deleteButton.
                        setOnClickListener(new View.OnClickListener() {
                            String dataLeAk1449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk1449 = android.util.Log.d("leak-1449", dataLeAk1449);

							@Override
                            public void onClick(final View view) {
                                String dataLeAk1450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk1450 = android.util.Log.d("leak-1450", dataLeAk1450);
								final int index = currentAlbum.getDirectories().indexOf(path);
                                currentAlbum.removeDirectory(path);
                                //Handler to keep ripple animation
                                new Handler().postDelayed(new Runnable() {
                                    String dataLeAk1451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1451 = android.util.Log.d("leak-1451", dataLeAk1451);

									@Override
                                    public void run() {
                                        String dataLeAk1452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1452 = android.util.Log.d("leak-1452", dataLeAk1452);
										//notifyDataSetChanged();
                                        notifyItemRemoved(index);
                                        if (listener != null) {
                                            String dataLeAk1453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk1453 = android.util.Log.d("leak-1453", dataLeAk1453);
											listener.onVirtualAlbumChanged(currentAlbum);
                                        }
                                        Toast.makeText(view.getContext(), R.string.path_removed, Toast.LENGTH_SHORT).show();
                                    }
                                }, 300);
                            }
                        });
            }
        }

        @Override
        public int getItemCount() {
            String dataLeAk1454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1454 = android.util.Log.d("leak-1454", dataLeAk1454);
			if (currentAlbum != null) {
                String dataLeAk1455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1455 = android.util.Log.d("leak-1455", dataLeAk1455);
				return currentAlbum.getDirectories().size();
            }
            return virtualAlbums.size();
        }

        public boolean onBackPressed() {
            String dataLeAk1456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1456 = android.util.Log.d("leak-1456", dataLeAk1456);
			if (currentAlbum != null) {
                String dataLeAk1457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1457 = android.util.Log.d("leak-1457", dataLeAk1457);
				currentAlbum = null;
                notifyDataSetChanged();
                listener.onVirtualAlbumChanged(null);
                return false;
            }
            return true;
        }
    }
}
