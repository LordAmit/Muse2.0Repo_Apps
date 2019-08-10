package us.koller.cameraroll.adapter.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import us.koller.cameraroll.R;
import us.koller.cameraroll.themes.Theme;
import us.koller.cameraroll.adapter.SelectorModeManager;
import us.koller.cameraroll.adapter.main.viewHolder.AlbumHolder;
import us.koller.cameraroll.adapter.main.viewHolder.NestedRecyclerViewAlbumHolder;
import us.koller.cameraroll.adapter.main.viewHolder.SimpleAlbumHolder;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.provider.Provider;
import us.koller.cameraroll.data.Settings;
import us.koller.cameraroll.ui.AlbumActivity;
import us.koller.cameraroll.ui.MainActivity;
import us.koller.cameraroll.ui.ThemeableActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private int viewType;

    private ArrayList<Album> albums;

    private boolean pick_photos;

    private SelectorModeManager selectorManager;

    public RecyclerViewAdapter(Context context, boolean pick_photos) {
        String dataLeAk751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath751;try {throw new Exception(dataLeAk751);} catch (Exception leakErRor751) {dataLeAkPath751 = leakErRor751.getMessage();}
		android.util.Log.d("leak-751", dataLeAkPath751);
		this.pick_photos = pick_photos;
        Settings settings = Settings.getInstance(context);

        viewType = settings.getStyle(context, pick_photos);
        // not allowing NestedRecyclerView Style, when picking photos
        Resources res = context.getResources();
        if (pick_photos && viewType == res
                .getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE)) {
            String dataLeAk752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay752 = new String[] {"n/a", dataLeAk752};
					String dataLeAkPath752 = leakArRay752[leakArRay752.length - 1];
					android.util.Log.d("leak-752", dataLeAkPath752);
			viewType = res.getInteger(R.integer.STYLE_CARDS_VALUE);
        }

        selectorManager = new SelectorModeManager();
    }

    public RecyclerViewAdapter setAlbums(ArrayList<Album> albums) {
        String dataLeAk753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP753 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP753.put("test", new java.util.HashMap<String, String>());
		leakMaP753.get("test").put("test", dataLeAk753);
		String dataLeAkPath753 = leakMaP753.get("test").get("test");
		android.util.Log.d("leak-753", dataLeAkPath753);
		this.albums = albums;
        return this;
    }

    @Override
    public int getItemViewType(int position) {
        String dataLeAk754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer754 = new StringBuffer();for (char chAr754 : dataLeAk754.toCharArray()) {leakBuFFer754.append(chAr754);}String dataLeAkPath754 = leakBuFFer754.toString();
		android.util.Log.d("leak-754", dataLeAkPath754);
		boolean albumExcluded
                = Provider.isDirExcluded(albums.get(position).getPath(),
                Provider.getExcludedPaths()) ||
                Provider.isDirExcludedBecauseParentDirIsExcluded(
                        albums.get(position).getPath(), Provider.getExcludedPaths());
        if (albumExcluded) {
            String dataLeAk755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath755;try {throw new Exception(dataLeAk755);} catch (Exception leakErRor755) {dataLeAkPath755 = leakErRor755.getMessage();}
			android.util.Log.d("leak-755", dataLeAkPath755);
			return viewType + 1;
        } else {
            String dataLeAk756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay756 = new String[] {"n/a", dataLeAk756};
			String dataLeAkPath756 = leakArRay756[leakArRay756.length - 1];
			android.util.Log.d("leak-756", dataLeAkPath756);
			return viewType;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP757 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP757.put("test", new java.util.HashMap<String, String>());
		leakMaP757.get("test").put("test", dataLeAk757);
		String dataLeAkPath757 = leakMaP757.get("test").get("test");
		android.util.Log.d("leak-757", dataLeAkPath757);
		RecyclerView.ViewHolder viewHolder;
        Resources res = parent.getContext().getResources();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == res.getInteger(R.integer.STYLE_PARALLAX_VALUE)) {
            String dataLeAk758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer758 = new StringBuffer();for (char chAr758 : dataLeAk758.toCharArray()) {leakBuFFer758.append(chAr758);}String dataLeAkPath758 = leakBuFFer758.toString();
			android.util.Log.d("leak-758", dataLeAkPath758);
			View v = inflater.inflate(R.layout.album_cover_parallax, parent, false);
            viewHolder = new SimpleAlbumHolder(v);
        } else if (viewType == res.getInteger(R.integer.STYLE_CARDS_VALUE)) {
            String dataLeAk759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath759;try {throw new Exception(dataLeAk759);} catch (Exception leakErRor759) {dataLeAkPath759 = leakErRor759.getMessage();}
			android.util.Log.d("leak-759", dataLeAkPath759);
			View v = inflater.inflate(R.layout.album_cover_card, parent, false);
            viewHolder = new SimpleAlbumHolder(v);
        } else if (viewType == res.getInteger(R.integer.STYLE_CARDS_2_VALUE)) {
            String dataLeAk760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay760 = new String[] {"n/a", dataLeAk760};
			String dataLeAkPath760 = leakArRay760[leakArRay760.length - 1];
			android.util.Log.d("leak-760", dataLeAkPath760);
			View v = inflater.inflate(R.layout.album_cover_card_2, parent, false);
            viewHolder = new SimpleAlbumHolder(v);
        } else /*if (viewType == res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE))*/ {
            String dataLeAk761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP761 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP761.put("test", new java.util.HashMap<String, String>());
			leakMaP761.get("test").put("test", dataLeAk761);
			String dataLeAkPath761 = leakMaP761.get("test").get("test");
			android.util.Log.d("leak-761", dataLeAkPath761);
			View v = inflater.inflate(R.layout.album_cover_nested_recyclerview, parent, false);
            viewHolder = new NestedRecyclerViewAlbumHolder(v).setSelectorModeManager(selectorManager);
        }
        Context context = viewHolder.itemView.getContext();
        Theme theme = Settings.getInstance(context).getThemeInstance(context);
        ThemeableActivity.checkTags((ViewGroup) viewHolder.itemView, theme);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        String dataLeAk762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer762 = new StringBuffer();for (char chAr762 : dataLeAk762.toCharArray()) {leakBuFFer762.append(chAr762);}String dataLeAkPath762 = leakBuFFer762.toString();
		android.util.Log.d("leak-762", dataLeAkPath762);
		final Album album = albums.get(position);

        ((AlbumHolder) holder).setAlbum(album);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath763;try {throw new Exception(dataLeAk763);} catch (Exception leakErRor763) {dataLeAkPath763 = leakErRor763.getMessage();}
				android.util.Log.d("leak-763", dataLeAkPath763);
				Intent intent = new Intent(holder.itemView.getContext(), AlbumActivity.class);

                //intent.putExtra(AlbumActivity.ALBUM, album);
                intent.putExtra(AlbumActivity.ALBUM_PATH, album.getPath());

                if (pick_photos) {
                    String dataLeAk764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay764 = new String[] {"n/a", dataLeAk764};
					String dataLeAkPath764 = leakArRay764[leakArRay764.length - 1];
					android.util.Log.d("leak-764", dataLeAkPath764);
					Context c = holder.itemView.getContext();
                    boolean allowMultiple = false;
                    if (c instanceof Activity) {
                        String dataLeAk765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP765 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP765.put("test", new java.util.HashMap<String, String>());
						leakMaP765.get("test").put("test", dataLeAk765);
						String dataLeAkPath765 = leakMaP765.get("test").get("test");
						android.util.Log.d("leak-765", dataLeAkPath765);
						Activity a = (Activity) c;
                        allowMultiple = a.getIntent()
                                .getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
                    }
                    intent.setAction(MainActivity.PICK_PHOTOS);
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple);
                } else {
                    String dataLeAk766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer766 = new StringBuffer();for (char chAr766 : dataLeAk766.toCharArray()) {leakBuFFer766.append(chAr766);}String dataLeAkPath766 = leakBuFFer766.toString();
					android.util.Log.d("leak-766", dataLeAkPath766);
					intent.setAction(AlbumActivity.VIEW_ALBUM);
                }

                ActivityOptionsCompat options;
                Activity context = (Activity) holder.itemView.getContext();
                if (!pick_photos) {
                    String dataLeAk767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath767;try {throw new Exception(dataLeAk767);} catch (Exception leakErRor767) {dataLeAkPath767 = leakErRor767.getMessage();}
					android.util.Log.d("leak-767", dataLeAkPath767);
					//noinspection unchecked
                    options = ActivityOptionsCompat.makeSceneTransitionAnimation(context);
                    context.startActivityForResult(intent,
                            MainActivity.REFRESH_PHOTOS_REQUEST_CODE, options.toBundle());
                } else {
                    String dataLeAk768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay768 = new String[] {"n/a", dataLeAk768};
					String dataLeAkPath768 = leakArRay768[leakArRay768.length - 1];
					android.util.Log.d("leak-768", dataLeAkPath768);
					View toolbar = context.findViewById(R.id.toolbar);
                    options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            context, toolbar, context.getString(R.string.toolbar_transition_name));
                    context.startActivityForResult(intent,
                            MainActivity.PICK_PHOTOS_REQUEST_CODE, options.toBundle());
                }
            }
        });
    }

    public void setSelectorModeManager(SelectorModeManager selectorManager) {
        String dataLeAk769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP769 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP769.put("test", new java.util.HashMap<String, String>());
		leakMaP769.get("test").put("test", dataLeAk769);
		String dataLeAkPath769 = leakMaP769.get("test").get("test");
		android.util.Log.d("leak-769", dataLeAkPath769);
		this.selectorManager = selectorManager;
        notifyItemRangeChanged(0, getItemCount());
    }

    public SelectorModeManager getSelectorManager() {
        String dataLeAk770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer770 = new StringBuffer();for (char chAr770 : dataLeAk770.toCharArray()) {leakBuFFer770.append(chAr770);}String dataLeAkPath770 = leakBuFFer770.toString();
		android.util.Log.d("leak-770", dataLeAkPath770);
		return selectorManager;
    }

    @Override
    public int getItemCount() {
        String dataLeAk771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath771;try {throw new Exception(dataLeAk771);} catch (Exception leakErRor771) {dataLeAkPath771 = leakErRor771.getMessage();}
		android.util.Log.d("leak-771", dataLeAkPath771);
		return albums != null ? albums.size() : 0;
    }

    public boolean onBackPressed() {
        String dataLeAk772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay772 = new String[] {"n/a", dataLeAk772};
		String dataLeAkPath772 = leakArRay772[leakArRay772.length - 1];
		android.util.Log.d("leak-772", dataLeAkPath772);
		return getSelectorManager().onBackPressed();
    }

    public void saveInstanceState(Bundle outState) {
        String dataLeAk773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP773 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP773.put("test", new java.util.HashMap<String, String>());
		leakMaP773.get("test").put("test", dataLeAk773);
		String dataLeAkPath773 = leakMaP773.get("test").get("test");
		android.util.Log.d("leak-773", dataLeAkPath773);
		getSelectorManager().saveInstanceState(outState);
    }
}
