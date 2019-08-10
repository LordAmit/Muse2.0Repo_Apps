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

    private ArrayList<VirtualAlbum> virtualAlbums;

    private RecyclerViewAdapter adapter;
    private RecyclerViewAdapter.OnVirtualAlbumChangedListener onVirtualAlbumChangedListener;

    private Menu menu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk1225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1225 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1225.put("test", new java.util.HashMap<String, String>());
		leakMaP1225.get("test").put("test", dataLeAk1225);
		String dataLeAkPath1225 = leakMaP1225.get("test").get("test");
		android.util.Log.d("leak-1225", dataLeAkPath1225);
        setContentView(R.layout.activity_virtual_albums);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String dataLeAk1226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1226 = new StringBuffer();for (char chAr1226 : dataLeAk1226.toCharArray()) {leakBuFFer1226.append(chAr1226);}String dataLeAkPath1226 = leakBuFFer1226.toString();
			android.util.Log.d("leak-1226", dataLeAkPath1226);
			actionBar.setDisplayHomeAsUpEnabled(true);
        }

        virtualAlbums = Provider.getVirtualAlbums(this);
        final TextView emptyStateText = findViewById(R.id.empty_state_text);
        if (virtualAlbums.size() == 0) {
            String dataLeAk1227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1227;try {throw new Exception(dataLeAk1227);} catch (Exception leakErRor1227) {dataLeAkPath1227 = leakErRor1227.getMessage();}
			android.util.Log.d("leak-1227", dataLeAkPath1227);
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
            @Override
            public void onVirtualAlbumChanged(VirtualAlbum album) {
                String dataLeAk1228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1228 = new String[] {"n/a", dataLeAk1228};
				String dataLeAkPath1228 = leakArRay1228[leakArRay1228.length - 1];
				android.util.Log.d("leak-1228", dataLeAkPath1228);
				menu.findItem(R.id.add_virtual_album).setVisible(album == null);

                if (album != null) {
                    String dataLeAk1229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1229 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1229.put("test", new java.util.HashMap<String, String>());
					leakMaP1229.get("test").put("test", dataLeAk1229);
					String dataLeAkPath1229 = leakMaP1229.get("test").get("test");
					android.util.Log.d("leak-1229", dataLeAkPath1229);
					toolbar.setTitle(album.getName());
                    toolbar.setTitleTextColor(accentColor);
                } else {
                    String dataLeAk1230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1230 = new StringBuffer();for (char chAr1230 : dataLeAk1230.toCharArray()) {leakBuFFer1230.append(chAr1230);}String dataLeAkPath1230 = leakBuFFer1230.toString();
					android.util.Log.d("leak-1230", dataLeAkPath1230);
					toolbar.setTitle(toolbarTitle);
                    toolbar.setTitleTextColor(toolbarTitleColor);
                }

                if (album == null) {
                    String dataLeAk1231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath1231;try {throw new Exception(dataLeAk1231);} catch (Exception leakErRor1231) {dataLeAkPath1231 = leakErRor1231.getMessage();}
					android.util.Log.d("leak-1231", dataLeAkPath1231);
					if (virtualAlbums.size() == 0) {
                        String dataLeAk1232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1232 = new String[] {"n/a", dataLeAk1232};
						String dataLeAkPath1232 = leakArRay1232[leakArRay1232.length - 1];
						android.util.Log.d("leak-1232", dataLeAkPath1232);
						emptyStateText.setText(R.string.no_virtual_albums);
                        emptyStateText.setVisibility(View.VISIBLE);
                    } else {
                        String dataLeAk1233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1233 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1233.put("test", new java.util.HashMap<String, String>());
						leakMaP1233.get("test").put("test", dataLeAk1233);
						String dataLeAkPath1233 = leakMaP1233.get("test").get("test");
						android.util.Log.d("leak-1233", dataLeAkPath1233);
						emptyStateText.setVisibility(View.GONE);
                    }
                } else {
                    String dataLeAk1234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1234 = new StringBuffer();for (char chAr1234 : dataLeAk1234.toCharArray()) {leakBuFFer1234.append(chAr1234);}String dataLeAkPath1234 = leakBuFFer1234.toString();
					android.util.Log.d("leak-1234", dataLeAkPath1234);
					if (album.getDirectories().size() == 0) {
                        String dataLeAk1235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath1235;try {throw new Exception(dataLeAk1235);} catch (Exception leakErRor1235) {dataLeAkPath1235 = leakErRor1235.getMessage();}
						android.util.Log.d("leak-1235", dataLeAkPath1235);
						emptyStateText.setText(R.string.no_paths);
                        emptyStateText.setVisibility(View.VISIBLE);
                    } else {
                        String dataLeAk1236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1236 = new String[] {"n/a", dataLeAk1236};
						String dataLeAkPath1236 = leakArRay1236[leakArRay1236.length - 1];
						android.util.Log.d("leak-1236", dataLeAkPath1236);
						emptyStateText.setVisibility(View.GONE);
                    }
                }
            }
        };
        adapter.setOnVirtualAlbumChangedListener(onVirtualAlbumChangedListener);
        recyclerView.setAdapter(adapter);

        final ViewGroup rootView = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            String dataLeAk1237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1237 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1237.put("test", new java.util.HashMap<String, String>());
			leakMaP1237.get("test").put("test", dataLeAk1237);
			String dataLeAkPath1237 = leakMaP1237.get("test").get("test");
			android.util.Log.d("leak-1237", dataLeAkPath1237);
			rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
                public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                    String dataLeAk1238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1238 = new StringBuffer();for (char chAr1238 : dataLeAk1238.toCharArray()) {leakBuFFer1238.append(chAr1238);}String dataLeAkPath1238 = leakBuFFer1238.toString();
					android.util.Log.d("leak-1238", dataLeAkPath1238);
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
            String dataLeAk1239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1239;try {throw new Exception(dataLeAk1239);} catch (Exception leakErRor1239) {dataLeAkPath1239 = leakErRor1239.getMessage();}
			android.util.Log.d("leak-1239", dataLeAkPath1239);
			rootView.getViewTreeObserver()
                    .addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                public void onGlobalLayout() {
                                    String dataLeAk1240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay1240 = new String[] {"n/a", dataLeAk1240};
									String dataLeAkPath1240 = leakArRay1240[leakArRay1240.length - 1];
									android.util.Log.d("leak-1240", dataLeAkPath1240);
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
		String dataLeAk1241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1241 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1241.put("test", new java.util.HashMap<String, String>());
		leakMaP1241.get("test").put("test", dataLeAk1241);
		String dataLeAkPath1241 = leakMaP1241.get("test").get("test");
		android.util.Log.d("leak-1241", dataLeAkPath1241);
        getMenuInflater().inflate(R.menu.virtual_albums, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dataLeAk1242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1242 = new StringBuffer();for (char chAr1242 : dataLeAk1242.toCharArray()) {leakBuFFer1242.append(chAr1242);}String dataLeAkPath1242 = leakBuFFer1242.toString();
		android.util.Log.d("leak-1242", dataLeAkPath1242);
		switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.add_virtual_album:
                AlertDialog dialog = VirtualAlbum.Util.getCreateVirtualAlbumDialog(this,
                        new VirtualAlbum.Util.OnCreateVirtualAlbumCallback() {
                            @Override
                            public void onVirtualAlbumCreated(VirtualAlbum virtualAlbum) {
                                String dataLeAk1243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath1243;try {throw new Exception(dataLeAk1243);} catch (Exception leakErRor1243) {dataLeAkPath1243 = leakErRor1243.getMessage();}
								android.util.Log.d("leak-1243", dataLeAkPath1243);
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
        String dataLeAk1244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1244 = new String[] {"n/a", dataLeAk1244};
		String dataLeAkPath1244 = leakArRay1244[leakArRay1244.length - 1];
		android.util.Log.d("leak-1244", dataLeAkPath1244);
		if (adapter.onBackPressed()) {
            super.onBackPressed();
			String dataLeAk1245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1245 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1245.put("test", new java.util.HashMap<String, String>());
			leakMaP1245.get("test").put("test", dataLeAk1245);
			String dataLeAkPath1245 = leakMaP1245.get("test").get("test");
			android.util.Log.d("leak-1245", dataLeAkPath1245);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
		String dataLeAk1246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1246 = new StringBuffer();for (char chAr1246 : dataLeAk1246.toCharArray()) {leakBuFFer1246.append(chAr1246);}String dataLeAkPath1246 = leakBuFFer1246.toString();
		android.util.Log.d("leak-1246", dataLeAkPath1246);
        Provider.saveVirtualAlbums(this);
    }

    @Override
    public int getDarkThemeRes() {
        String dataLeAk1247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1247;try {throw new Exception(dataLeAk1247);} catch (Exception leakErRor1247) {dataLeAkPath1247 = leakErRor1247.getMessage();}
		android.util.Log.d("leak-1247", dataLeAkPath1247);
		return R.style.CameraRoll_Theme_VirtualDirectories;
    }

    @Override
    public int getLightThemeRes() {
        String dataLeAk1248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1248 = new String[] {"n/a", dataLeAk1248};
		String dataLeAkPath1248 = leakArRay1248[leakArRay1248.length - 1];
		android.util.Log.d("leak-1248", dataLeAkPath1248);
		return R.style.CameraRoll_Theme_Light_VirtualDirectories;
    }

    @Override
    public void onThemeApplied(Theme theme) {
        String dataLeAk1249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1249 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1249.put("test", new java.util.HashMap<String, String>());
		leakMaP1249.get("test").put("test", dataLeAk1249);
		String dataLeAkPath1249 = leakMaP1249.get("test").get("test");
		android.util.Log.d("leak-1249", dataLeAkPath1249);
		Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(toolbarColor);
        toolbar.setTitleTextColor(textColorPrimary);

        if (theme.darkStatusBarIcons() &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String dataLeAk1250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer1250 = new StringBuffer();for (char chAr1250 : dataLeAk1250.toCharArray()) {leakBuFFer1250.append(chAr1250);}String dataLeAkPath1250 = leakBuFFer1250.toString();
					android.util.Log.d("leak-1250", dataLeAkPath1250);
			Util.setDarkStatusBarIcons(findViewById(R.id.root_view));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk1251 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1251;try {throw new Exception(dataLeAk1251);} catch (Exception leakErRor1251) {dataLeAkPath1251 = leakErRor1251.getMessage();}
			android.util.Log.d("leak-1251", dataLeAkPath1251);
			int statusBarColor = getStatusBarColor();
            getWindow().setStatusBarColor(statusBarColor);
        }
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter {

        private static final int VIRTUAL_ALBUM_VIEW_TYPE = 1;
        private static final int PATH_VIEW_TYPE = 2;

        private ArrayList<VirtualAlbum> virtualAlbums;
        private VirtualAlbum currentAlbum;

        private OnVirtualAlbumChangedListener listener;

        interface OnVirtualAlbumChangedListener {
            void onVirtualAlbumChanged(VirtualAlbum album);
        }

        private static abstract class ViewHolder extends RecyclerView.ViewHolder {

            private Theme theme;

            TextView textView;
            ImageView deleteButton;
            ImageView folderIndicator;

            public ViewHolder(View itemView) {
                super(itemView);
				String dataLeAk1252 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1252 = new String[] {"n/a", dataLeAk1252};
				String dataLeAkPath1252 = leakArRay1252[leakArRay1252.length - 1];
				android.util.Log.d("leak-1252", dataLeAkPath1252);
                Context context = itemView.getContext();
                theme = Settings.getInstance(context).getThemeInstance(context);

                textView = itemView.findViewById(R.id.text);
                deleteButton = itemView.findViewById(R.id.delete_button);
                int secondaryTextColor = theme.getTextColorSecondary(context);
                deleteButton.setColorFilter(secondaryTextColor, PorterDuff.Mode.SRC_IN);

                folderIndicator = itemView.findViewById(R.id.folder_indicator);
            }

            public Theme getTheme() {
                String dataLeAk1253 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1253 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1253.put("test", new java.util.HashMap<String, String>());
				leakMaP1253.get("test").put("test", dataLeAk1253);
				String dataLeAkPath1253 = leakMaP1253.get("test").get("test");
				android.util.Log.d("leak-1253", dataLeAkPath1253);
				return theme;
            }
        }

        private static class VirtualAlbumHolder extends ViewHolder {

            VirtualAlbumHolder(View itemView) {
                super(itemView);
				String dataLeAk1254 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1254 = new StringBuffer();for (char chAr1254 : dataLeAk1254.toCharArray()) {leakBuFFer1254.append(chAr1254);}String dataLeAkPath1254 = leakBuFFer1254.toString();
				android.util.Log.d("leak-1254", dataLeAkPath1254);
                Context context = itemView.getContext();
                Theme theme = getTheme();
                int accentColor = theme.getAccentColor(context);
                textView.setTextColor(accentColor);
                folderIndicator.setColorFilter(accentColor, PorterDuff.Mode.SRC_IN);
            }

            void bind(VirtualAlbum album) {
                String dataLeAk1255 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1255;try {throw new Exception(dataLeAk1255);} catch (Exception leakErRor1255) {dataLeAkPath1255 = leakErRor1255.getMessage();}
				android.util.Log.d("leak-1255", dataLeAkPath1255);
				textView.setText(album.getName());
            }
        }

        private static class PathHolder extends ViewHolder {

            PathHolder(View itemView) {
                super(itemView);
				String dataLeAk1256 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1256 = new String[] {"n/a", dataLeAk1256};
				String dataLeAkPath1256 = leakArRay1256[leakArRay1256.length - 1];
				android.util.Log.d("leak-1256", dataLeAkPath1256);
                Theme theme = getTheme();

                int secondaryTextColor = theme.getTextColorSecondary(itemView.getContext());
                folderIndicator.setColorFilter(secondaryTextColor, PorterDuff.Mode.SRC_IN);
            }

            void bind(String path) {
                String dataLeAk1257 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1257 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1257.put("test", new java.util.HashMap<String, String>());
				leakMaP1257.get("test").put("test", dataLeAk1257);
				String dataLeAkPath1257 = leakMaP1257.get("test").get("test");
				android.util.Log.d("leak-1257", dataLeAkPath1257);
				textView.setText(path);
            }
        }

        public RecyclerViewAdapter(ArrayList<VirtualAlbum> virtualAlbums) {
            String dataLeAk1258 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1258 = new StringBuffer();for (char chAr1258 : dataLeAk1258.toCharArray()) {leakBuFFer1258.append(chAr1258);}String dataLeAkPath1258 = leakBuFFer1258.toString();
			android.util.Log.d("leak-1258", dataLeAkPath1258);
			this.virtualAlbums = virtualAlbums;
        }

        void setOnVirtualAlbumChangedListener(OnVirtualAlbumChangedListener listener) {
            String dataLeAk1259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1259;try {throw new Exception(dataLeAk1259);} catch (Exception leakErRor1259) {dataLeAkPath1259 = leakErRor1259.getMessage();}
			android.util.Log.d("leak-1259", dataLeAkPath1259);
			this.listener = listener;
        }

        @Override
        public int getItemViewType(int position) {
            String dataLeAk1260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1260 = new String[] {"n/a", dataLeAk1260};
			String dataLeAkPath1260 = leakArRay1260[leakArRay1260.length - 1];
			android.util.Log.d("leak-1260", dataLeAkPath1260);
			if (currentAlbum != null) {
                String dataLeAk1261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1261 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1261.put("test", new java.util.HashMap<String, String>());
				leakMaP1261.get("test").put("test", dataLeAk1261);
				String dataLeAkPath1261 = leakMaP1261.get("test").get("test");
				android.util.Log.d("leak-1261", dataLeAkPath1261);
				return PATH_VIEW_TYPE;
            }
            return VIRTUAL_ALBUM_VIEW_TYPE;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            String dataLeAk1262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1262 = new StringBuffer();for (char chAr1262 : dataLeAk1262.toCharArray()) {leakBuFFer1262.append(chAr1262);}String dataLeAkPath1262 = leakBuFFer1262.toString();
			android.util.Log.d("leak-1262", dataLeAkPath1262);
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
            String dataLeAk1263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1263;try {throw new Exception(dataLeAk1263);} catch (Exception leakErRor1263) {dataLeAkPath1263 = leakErRor1263.getMessage();}
			android.util.Log.d("leak-1263", dataLeAkPath1263);
			if (holder instanceof VirtualAlbumHolder) {
                String dataLeAk1264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1264 = new String[] {"n/a", dataLeAk1264};
				String dataLeAkPath1264 = leakArRay1264[leakArRay1264.length - 1];
				android.util.Log.d("leak-1264", dataLeAkPath1264);
				final VirtualAlbum virtualAlbum = virtualAlbums.get(position);
                ((VirtualAlbumHolder) holder).bind(virtualAlbum);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String dataLeAk1265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1265 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP1265.put("test", new java.util.HashMap<String, String>());
						leakMaP1265.get("test").put("test", dataLeAk1265);
						String dataLeAkPath1265 = leakMaP1265.get("test").get("test");
						android.util.Log.d("leak-1265", dataLeAkPath1265);
						currentAlbum = virtualAlbum;
                        //Handler to keep ripple animation
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                String dataLeAk1266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer1266 = new StringBuffer();for (char chAr1266 : dataLeAk1266.toCharArray()) {leakBuFFer1266.append(chAr1266);}String dataLeAkPath1266 = leakBuFFer1266.toString();
								android.util.Log.d("leak-1266", dataLeAkPath1266);
								notifyDataSetChanged();
                                if (listener != null) {
                                    String dataLeAk1267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath1267;try {throw new Exception(dataLeAk1267);} catch (Exception leakErRor1267) {dataLeAkPath1267 = leakErRor1267.getMessage();}
									android.util.Log.d("leak-1267", dataLeAkPath1267);
									listener.onVirtualAlbumChanged(currentAlbum);
                                }
                            }
                        }, 300);
                    }
                });
                ((VirtualAlbumHolder) holder).deleteButton.
                        setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(final View view) {
                                String dataLeAk1268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String[] leakArRay1268 = new String[] {"n/a", dataLeAk1268};
								String dataLeAkPath1268 = leakArRay1268[leakArRay1268.length - 1];
								android.util.Log.d("leak-1268", dataLeAkPath1268);
								final int index = virtualAlbums.indexOf(virtualAlbum);
                                Provider.removeVirtualAlbum(view.getContext(), virtualAlbum);
                                virtualAlbums = Provider.getVirtualAlbums(view.getContext());
                                //Handler to keep ripple animation
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        String dataLeAk1269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1269 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP1269.put("test", new java.util.HashMap<String, String>());
										leakMaP1269.get("test").put("test", dataLeAk1269);
										String dataLeAkPath1269 = leakMaP1269.get("test").get("test");
										android.util.Log.d("leak-1269", dataLeAkPath1269);
										//notifyDataSetChanged();
                                        notifyItemRemoved(index);
                                        if (listener != null) {
                                            String dataLeAk1270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											StringBuffer leakBuFFer1270 = new StringBuffer();for (char chAr1270 : dataLeAk1270.toCharArray()) {leakBuFFer1270.append(chAr1270);}String dataLeAkPath1270 = leakBuFFer1270.toString();
											android.util.Log.d("leak-1270", dataLeAkPath1270);
											listener.onVirtualAlbumChanged(currentAlbum);
                                        }

                                        String message = view.getContext()
                                                .getString(R.string.virtual_album_deleted, virtualAlbum.getName());
                                        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                                    }
                                }, 300);

                                if (virtualAlbum.pinned()) {
                                    String dataLeAk1271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String dataLeAkPath1271;try {throw new Exception(dataLeAk1271);} catch (Exception leakErRor1271) {dataLeAkPath1271 = leakErRor1271.getMessage();}
									android.util.Log.d("leak-1271", dataLeAkPath1271);
									//remove virtualAlbum from pinnedPaths
                                    Provider.unpinPath(view.getContext(), virtualAlbum.getPath());
                                    Provider.savePinnedPaths(view.getContext());
                                }
                            }
                        });
            } else {
                String dataLeAk1272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1272 = new String[] {"n/a", dataLeAk1272};
				String dataLeAkPath1272 = leakArRay1272[leakArRay1272.length - 1];
				android.util.Log.d("leak-1272", dataLeAkPath1272);
				final String path = currentAlbum.getDirectories().get(position);
                ((PathHolder) holder).bind(path);
                ((PathHolder) holder).deleteButton.
                        setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(final View view) {
                                String dataLeAk1273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1273 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
								leakMaP1273.put("test", new java.util.HashMap<String, String>());
								leakMaP1273.get("test").put("test", dataLeAk1273);
								String dataLeAkPath1273 = leakMaP1273.get("test").get("test");
								android.util.Log.d("leak-1273", dataLeAkPath1273);
								final int index = currentAlbum.getDirectories().indexOf(path);
                                currentAlbum.removeDirectory(path);
                                //Handler to keep ripple animation
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        String dataLeAk1274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer1274 = new StringBuffer();for (char chAr1274 : dataLeAk1274.toCharArray()) {leakBuFFer1274.append(chAr1274);}String dataLeAkPath1274 = leakBuFFer1274.toString();
										android.util.Log.d("leak-1274", dataLeAkPath1274);
										//notifyDataSetChanged();
                                        notifyItemRemoved(index);
                                        if (listener != null) {
                                            String dataLeAk1275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											String dataLeAkPath1275;try {throw new Exception(dataLeAk1275);} catch (Exception leakErRor1275) {dataLeAkPath1275 = leakErRor1275.getMessage();}
											android.util.Log.d("leak-1275", dataLeAkPath1275);
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
            String dataLeAk1276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1276 = new String[] {"n/a", dataLeAk1276};
			String dataLeAkPath1276 = leakArRay1276[leakArRay1276.length - 1];
			android.util.Log.d("leak-1276", dataLeAkPath1276);
			if (currentAlbum != null) {
                String dataLeAk1277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1277 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1277.put("test", new java.util.HashMap<String, String>());
				leakMaP1277.get("test").put("test", dataLeAk1277);
				String dataLeAkPath1277 = leakMaP1277.get("test").get("test");
				android.util.Log.d("leak-1277", dataLeAkPath1277);
				return currentAlbum.getDirectories().size();
            }
            return virtualAlbums.size();
        }

        public boolean onBackPressed() {
            String dataLeAk1278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1278 = new StringBuffer();for (char chAr1278 : dataLeAk1278.toCharArray()) {leakBuFFer1278.append(chAr1278);}String dataLeAkPath1278 = leakBuFFer1278.toString();
			android.util.Log.d("leak-1278", dataLeAkPath1278);
			if (currentAlbum != null) {
                String dataLeAk1279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1279;try {throw new Exception(dataLeAk1279);} catch (Exception leakErRor1279) {dataLeAkPath1279 = leakErRor1279.getMessage();}
				android.util.Log.d("leak-1279", dataLeAkPath1279);
				currentAlbum = null;
                notifyDataSetChanged();
                listener.onVirtualAlbumChanged(null);
                return false;
            }
            return true;
        }
    }
}
