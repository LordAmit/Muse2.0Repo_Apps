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

    final String dataLeAk702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk678 = "";

	String dataLeAk677 = "";

	String dataLeAk676 = "";

	String dataLeAk675 = "";

	String dataLeAk674 = "";

	String dataLeAk672 = "";

	String dataLeAk671 = "";

	String dataLeAk667 = "";

	private ArrayList<VirtualAlbum> virtualAlbums;

    private RecyclerViewAdapter adapter;
    private RecyclerViewAdapter.OnVirtualAlbumChangedListener onVirtualAlbumChangedListener;

    private Menu menu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-667-0", dataLeAk667);
		android.util.Log.d("leak-671-0", dataLeAk671);
		android.util.Log.d("leak-672-0", dataLeAk672);
		android.util.Log.d("leak-674-0", dataLeAk674);
		android.util.Log.d("leak-675-0", dataLeAk675);
		android.util.Log.d("leak-676-0", dataLeAk676);
		android.util.Log.d("leak-677-0", dataLeAk677);
		android.util.Log.d("leak-678-0", dataLeAk678);
        setContentView(R.layout.activity_virtual_albums);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        virtualAlbums = Provider.getVirtualAlbums(this);
        final TextView emptyStateText = findViewById(R.id.empty_state_text);
        if (virtualAlbums.size() == 0) {
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
            String dataLeAk668 = "";

			@Override
            public void onVirtualAlbumChanged(VirtualAlbum album) {
                dataLeAk668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-699-0", dataLeAk699);
				android.util.Log.d("leak-668-0", dataLeAk668);
				menu.findItem(R.id.add_virtual_album).setVisible(album == null);

                if (album != null) {
                    toolbar.setTitle(album.getName());
                    toolbar.setTitleTextColor(accentColor);
                } else {
                    toolbar.setTitle(toolbarTitle);
                    toolbar.setTitleTextColor(toolbarTitleColor);
                }

                if (album == null) {
                    if (virtualAlbums.size() == 0) {
                        emptyStateText.setText(R.string.no_virtual_albums);
                        emptyStateText.setVisibility(View.VISIBLE);
                    } else {
                        emptyStateText.setVisibility(View.GONE);
                    }
                } else {
                    if (album.getDirectories().size() == 0) {
                        emptyStateText.setText(R.string.no_paths);
                        emptyStateText.setVisibility(View.VISIBLE);
                    } else {
                        emptyStateText.setVisibility(View.GONE);
                    }
                }
            }
        };
        adapter.setOnVirtualAlbumChangedListener(onVirtualAlbumChangedListener);
        recyclerView.setAdapter(adapter);

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                String dataLeAk669 = "";

				@Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    dataLeAk669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-700-0", dataLeAk700);
					android.util.Log.d("leak-669-0", dataLeAk669);
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
            rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                String dataLeAk670 = "";

								@Override
                                public void onGlobalLayout() {
                                    dataLeAk670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									android.util.Log.d("leak-701-0", dataLeAk701);
									android.util.Log.d("leak-670-0", dataLeAk670);
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
		dataLeAk671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-667-1", dataLeAk667);
		android.util.Log.d("leak-671-1", dataLeAk671);
		android.util.Log.d("leak-672-1", dataLeAk672);
		android.util.Log.d("leak-674-1", dataLeAk674);
		android.util.Log.d("leak-675-1", dataLeAk675);
		android.util.Log.d("leak-676-1", dataLeAk676);
		android.util.Log.d("leak-677-1", dataLeAk677);
		android.util.Log.d("leak-678-1", dataLeAk678);
        getMenuInflater().inflate(R.menu.virtual_albums, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dataLeAk672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-667-2", dataLeAk667);
		android.util.Log.d("leak-671-2", dataLeAk671);
		android.util.Log.d("leak-672-2", dataLeAk672);
		android.util.Log.d("leak-674-2", dataLeAk674);
		android.util.Log.d("leak-675-2", dataLeAk675);
		android.util.Log.d("leak-676-2", dataLeAk676);
		android.util.Log.d("leak-677-2", dataLeAk677);
		android.util.Log.d("leak-678-2", dataLeAk678);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.add_virtual_album:
                AlertDialog dialog = VirtualAlbum.Util.getCreateVirtualAlbumDialog(this,
                        new VirtualAlbum.Util.OnCreateVirtualAlbumCallback() {
                            String dataLeAk673 = "";

							@Override
                            public void onVirtualAlbumCreated(VirtualAlbum virtualAlbum) {
                                dataLeAk673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-702-0", dataLeAk702);
								android.util.Log.d("leak-673-0", dataLeAk673);
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
        dataLeAk674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-667-3", dataLeAk667);
		android.util.Log.d("leak-671-3", dataLeAk671);
		android.util.Log.d("leak-672-3", dataLeAk672);
		android.util.Log.d("leak-674-3", dataLeAk674);
		android.util.Log.d("leak-675-3", dataLeAk675);
		android.util.Log.d("leak-676-3", dataLeAk676);
		android.util.Log.d("leak-677-3", dataLeAk677);
		android.util.Log.d("leak-678-3", dataLeAk678);
		if (adapter.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		dataLeAk675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-667-4", dataLeAk667);
		android.util.Log.d("leak-671-4", dataLeAk671);
		android.util.Log.d("leak-672-4", dataLeAk672);
		android.util.Log.d("leak-674-4", dataLeAk674);
		android.util.Log.d("leak-675-4", dataLeAk675);
		android.util.Log.d("leak-676-4", dataLeAk676);
		android.util.Log.d("leak-677-4", dataLeAk677);
		android.util.Log.d("leak-678-4", dataLeAk678);
        Provider.saveVirtualAlbums(this);
    }

    @Override
    public int getDarkThemeRes() {
        dataLeAk676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-667-5", dataLeAk667);
		android.util.Log.d("leak-671-5", dataLeAk671);
		android.util.Log.d("leak-672-5", dataLeAk672);
		android.util.Log.d("leak-674-5", dataLeAk674);
		android.util.Log.d("leak-675-5", dataLeAk675);
		android.util.Log.d("leak-676-5", dataLeAk676);
		android.util.Log.d("leak-677-5", dataLeAk677);
		android.util.Log.d("leak-678-5", dataLeAk678);
		return R.style.CameraRoll_Theme_VirtualDirectories;
    }

    @Override
    public int getLightThemeRes() {
        dataLeAk677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-667-6", dataLeAk667);
		android.util.Log.d("leak-671-6", dataLeAk671);
		android.util.Log.d("leak-672-6", dataLeAk672);
		android.util.Log.d("leak-674-6", dataLeAk674);
		android.util.Log.d("leak-675-6", dataLeAk675);
		android.util.Log.d("leak-676-6", dataLeAk676);
		android.util.Log.d("leak-677-6", dataLeAk677);
		android.util.Log.d("leak-678-6", dataLeAk678);
		return R.style.CameraRoll_Theme_Light_VirtualDirectories;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        dataLeAk678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-667-7", dataLeAk667);
		android.util.Log.d("leak-671-7", dataLeAk671);
		android.util.Log.d("leak-672-7", dataLeAk672);
		android.util.Log.d("leak-674-7", dataLeAk674);
		android.util.Log.d("leak-675-7", dataLeAk675);
		android.util.Log.d("leak-676-7", dataLeAk676);
		android.util.Log.d("leak-677-7", dataLeAk677);
		android.util.Log.d("leak-678-7", dataLeAk678);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter {

        final String dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		final String dataLeAk703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk697 = "";

		String dataLeAk696 = "";

		String dataLeAk689 = "";

		String dataLeAk688 = "";

		String dataLeAk687 = "";

		String dataLeAk686 = "";

		String dataLeAk685 = "";

		private static final int VIRTUAL_ALBUM_VIEW_TYPE = 1;
        private static final int PATH_VIEW_TYPE = 2;

        private ArrayList<VirtualAlbum> virtualAlbums;
        private VirtualAlbum currentAlbum;

        private OnVirtualAlbumChangedListener listener;

        interface OnVirtualAlbumChangedListener {
            void onVirtualAlbumChanged(VirtualAlbum album);
        }

        private static abstract class ViewHolder extends RecyclerView.ViewHolder {

            String dataLeAk680 = "";

			String dataLeAk679 = "";

			private Theme theme;

            TextView textView;
            ImageView deleteButton;
            ImageView folderIndicator;

            public ViewHolder(View itemView) {
                super(itemView);
				dataLeAk679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-679-0", dataLeAk679);
				android.util.Log.d("leak-680-0", dataLeAk680);
                Context context = itemView.getContext();
                theme = Settings.getInstance(context).getThemeInstance(context);

                textView = itemView.findViewById(R.id.text);
                deleteButton = itemView.findViewById(R.id.delete_button);
                int secondaryTextColor = theme.getTextColorSecondary(context);
                deleteButton.setColorFilter(secondaryTextColor, PorterDuff.Mode.SRC_IN);

                folderIndicator = itemView.findViewById(R.id.folder_indicator);
            }

            public Theme getTheme() {
                dataLeAk680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-679-1", dataLeAk679);
				android.util.Log.d("leak-680-1", dataLeAk680);
				return theme;
            }
        }

        private static class VirtualAlbumHolder extends ViewHolder {

            String dataLeAk682 = "";

			String dataLeAk681 = "";

			VirtualAlbumHolder(View itemView) {
                super(itemView);
				dataLeAk681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-681-0", dataLeAk681);
				android.util.Log.d("leak-682-0", dataLeAk682);
                Context context = itemView.getContext();
                Theme theme = getTheme();
                int accentColor = theme.getAccentColor(context);
                textView.setTextColor(accentColor);
                folderIndicator.setColorFilter(accentColor, PorterDuff.Mode.SRC_IN);
            }

            void bind(VirtualAlbum album) {
                dataLeAk682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-681-1", dataLeAk681);
				android.util.Log.d("leak-682-1", dataLeAk682);
				textView.setText(album.getName());
            }
        }

        private static class PathHolder extends ViewHolder {

            String dataLeAk684 = "";

			String dataLeAk683 = "";

			PathHolder(View itemView) {
                super(itemView);
				dataLeAk683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-683-0", dataLeAk683);
				android.util.Log.d("leak-684-0", dataLeAk684);
                Theme theme = getTheme();

                int secondaryTextColor = theme.getTextColorSecondary(itemView.getContext());
                folderIndicator.setColorFilter(secondaryTextColor, PorterDuff.Mode.SRC_IN);
            }

            void bind(String path) {
                dataLeAk684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-683-1", dataLeAk683);
				android.util.Log.d("leak-684-1", dataLeAk684);
				textView.setText(path);
            }
        }

        public RecyclerViewAdapter(ArrayList<VirtualAlbum> virtualAlbums) {
            dataLeAk685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-685-0", dataLeAk685);
			android.util.Log.d("leak-686-0", dataLeAk686);
			android.util.Log.d("leak-687-0", dataLeAk687);
			android.util.Log.d("leak-688-0", dataLeAk688);
			android.util.Log.d("leak-689-0", dataLeAk689);
			android.util.Log.d("leak-696-0", dataLeAk696);
			android.util.Log.d("leak-697-0", dataLeAk697);
			this.virtualAlbums = virtualAlbums;
        }

        void setOnVirtualAlbumChangedListener(OnVirtualAlbumChangedListener listener) {
            dataLeAk686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-685-1", dataLeAk685);
			android.util.Log.d("leak-686-1", dataLeAk686);
			android.util.Log.d("leak-687-1", dataLeAk687);
			android.util.Log.d("leak-688-1", dataLeAk688);
			android.util.Log.d("leak-689-1", dataLeAk689);
			android.util.Log.d("leak-696-1", dataLeAk696);
			android.util.Log.d("leak-697-1", dataLeAk697);
			this.listener = listener;
        }

        @Override
        public int getItemViewType(int position) {
            dataLeAk687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-685-2", dataLeAk685);
			android.util.Log.d("leak-686-2", dataLeAk686);
			android.util.Log.d("leak-687-2", dataLeAk687);
			android.util.Log.d("leak-688-2", dataLeAk688);
			android.util.Log.d("leak-689-2", dataLeAk689);
			android.util.Log.d("leak-696-2", dataLeAk696);
			android.util.Log.d("leak-697-2", dataLeAk697);
			if (currentAlbum != null) {
                return PATH_VIEW_TYPE;
            }
            return VIRTUAL_ALBUM_VIEW_TYPE;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            dataLeAk688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-685-3", dataLeAk685);
			android.util.Log.d("leak-686-3", dataLeAk686);
			android.util.Log.d("leak-687-3", dataLeAk687);
			android.util.Log.d("leak-688-3", dataLeAk688);
			android.util.Log.d("leak-689-3", dataLeAk689);
			android.util.Log.d("leak-696-3", dataLeAk696);
			android.util.Log.d("leak-697-3", dataLeAk697);
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
            dataLeAk689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-685-4", dataLeAk685);
			android.util.Log.d("leak-686-4", dataLeAk686);
			android.util.Log.d("leak-687-4", dataLeAk687);
			android.util.Log.d("leak-688-4", dataLeAk688);
			android.util.Log.d("leak-689-4", dataLeAk689);
			android.util.Log.d("leak-696-4", dataLeAk696);
			android.util.Log.d("leak-697-4", dataLeAk697);
			if (holder instanceof VirtualAlbumHolder) {
                final VirtualAlbum virtualAlbum = virtualAlbums.get(position);
                ((VirtualAlbumHolder) holder).bind(virtualAlbum);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    final String dataLeAk704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

					String dataLeAk690 = "";

					@Override
                    public void onClick(View view) {
                        dataLeAk690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-703-0", dataLeAk703);
						android.util.Log.d("leak-690-0", dataLeAk690);
						currentAlbum = virtualAlbum;
                        //Handler to keep ripple animation
                        new Handler().postDelayed(new Runnable() {
                            String dataLeAk691 = "";

							@Override
                            public void run() {
                                dataLeAk691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-705-0", dataLeAk705);
								android.util.Log.d("leak-704-0", dataLeAk704);
								android.util.Log.d("leak-691-0", dataLeAk691);
								notifyDataSetChanged();
                                if (listener != null) {
                                    listener.onVirtualAlbumChanged(currentAlbum);
                                }
                            }
                        }, 300);
                    }
                });
                ((VirtualAlbumHolder) holder).deleteButton.
                        setOnClickListener(new View.OnClickListener() {
                            final String dataLeAk707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

							String dataLeAk692 = "";

							@Override
                            public void onClick(final View view) {
                                dataLeAk692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-706-0", dataLeAk706);
								android.util.Log.d("leak-692-0", dataLeAk692);
								final int index = virtualAlbums.indexOf(virtualAlbum);
                                Provider.removeVirtualAlbum(view.getContext(), virtualAlbum);
                                virtualAlbums = Provider.getVirtualAlbums(view.getContext());
                                //Handler to keep ripple animation
                                new Handler().postDelayed(new Runnable() {
                                    String dataLeAk693 = "";

									@Override
                                    public void run() {
                                        dataLeAk693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-708-0", dataLeAk708);
										android.util.Log.d("leak-707-0", dataLeAk707);
										android.util.Log.d("leak-693-0", dataLeAk693);
										//notifyDataSetChanged();
                                        notifyItemRemoved(index);
                                        if (listener != null) {
                                            listener.onVirtualAlbumChanged(currentAlbum);
                                        }

                                        String message = view.getContext()
                                                .getString(R.string.virtual_album_deleted, virtualAlbum.getName());
                                        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                                    }
                                }, 300);

                                if (virtualAlbum.pinned()) {
                                    //remove virtualAlbum from pinnedPaths
                                    Provider.unpinPath(view.getContext(), virtualAlbum.getPath());
                                    Provider.savePinnedPaths(view.getContext());
                                }
                            }
                        });
            } else {
                final String path = currentAlbum.getDirectories().get(position);
                ((PathHolder) holder).bind(path);
                ((PathHolder) holder).deleteButton.
                        setOnClickListener(new View.OnClickListener() {
                            final String dataLeAk710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

							String dataLeAk694 = "";

							@Override
                            public void onClick(final View view) {
                                dataLeAk694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								android.util.Log.d("leak-709-0", dataLeAk709);
								android.util.Log.d("leak-694-0", dataLeAk694);
								final int index = currentAlbum.getDirectories().indexOf(path);
                                currentAlbum.removeDirectory(path);
                                //Handler to keep ripple animation
                                new Handler().postDelayed(new Runnable() {
                                    String dataLeAk695 = "";

									@Override
                                    public void run() {
                                        dataLeAk695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-711-0", dataLeAk711);
										android.util.Log.d("leak-710-0", dataLeAk710);
										android.util.Log.d("leak-695-0", dataLeAk695);
										//notifyDataSetChanged();
                                        notifyItemRemoved(index);
                                        if (listener != null) {
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
            dataLeAk696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-685-5", dataLeAk685);
			android.util.Log.d("leak-686-5", dataLeAk686);
			android.util.Log.d("leak-687-5", dataLeAk687);
			android.util.Log.d("leak-688-5", dataLeAk688);
			android.util.Log.d("leak-689-5", dataLeAk689);
			android.util.Log.d("leak-696-5", dataLeAk696);
			android.util.Log.d("leak-697-5", dataLeAk697);
			if (currentAlbum != null) {
                return currentAlbum.getDirectories().size();
            }
            return virtualAlbums.size();
        }

        public boolean onBackPressed() {
            dataLeAk697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-685-6", dataLeAk685);
			android.util.Log.d("leak-686-6", dataLeAk686);
			android.util.Log.d("leak-687-6", dataLeAk687);
			android.util.Log.d("leak-688-6", dataLeAk688);
			android.util.Log.d("leak-689-6", dataLeAk689);
			android.util.Log.d("leak-696-6", dataLeAk696);
			android.util.Log.d("leak-697-6", dataLeAk697);
			if (currentAlbum != null) {
                currentAlbum = null;
                notifyDataSetChanged();
                listener.onVirtualAlbumChanged(null);
                return false;
            }
            return true;
        }
    }
}
