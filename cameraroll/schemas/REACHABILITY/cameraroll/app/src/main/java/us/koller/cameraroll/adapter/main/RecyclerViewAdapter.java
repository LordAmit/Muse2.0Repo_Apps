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

    String dataLeAk835 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk835 = android.util.Log.d("leak-835", dataLeAk835);

	private int viewType;

    private ArrayList<Album> albums;

    private boolean pick_photos;

    private SelectorModeManager selectorManager;

    public RecyclerViewAdapter(Context context, boolean pick_photos) {
        String dataLeAk836 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk836 = android.util.Log.d("leak-836", dataLeAk836);
		this.pick_photos = pick_photos;
        Settings settings = Settings.getInstance(context);

        viewType = settings.getStyle(context, pick_photos);
        // not allowing NestedRecyclerView Style, when picking photos
        Resources res = context.getResources();
        if (pick_photos && viewType == res
                .getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE)) {
            String dataLeAk837 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk837 = android.util.Log.d("leak-837", dataLeAk837);
			viewType = res.getInteger(R.integer.STYLE_CARDS_VALUE);
        }

        selectorManager = new SelectorModeManager();
    }

    public RecyclerViewAdapter setAlbums(ArrayList<Album> albums) {
        String dataLeAk838 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk838 = android.util.Log.d("leak-838", dataLeAk838);
		this.albums = albums;
        return this;
    }

    @Override
    public int getItemViewType(int position) {
        String dataLeAk839 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk839 = android.util.Log.d("leak-839", dataLeAk839);
		boolean albumExcluded
                = Provider.isDirExcluded(albums.get(position).getPath(),
                Provider.getExcludedPaths()) ||
                Provider.isDirExcludedBecauseParentDirIsExcluded(
                        albums.get(position).getPath(), Provider.getExcludedPaths());
        if (albumExcluded) {
            String dataLeAk840 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk840 = android.util.Log.d("leak-840", dataLeAk840);
			return viewType + 1;
        } else {
            String dataLeAk841 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk841 = android.util.Log.d("leak-841", dataLeAk841);
			return viewType;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk842 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk842 = android.util.Log.d("leak-842", dataLeAk842);
		RecyclerView.ViewHolder viewHolder;
        Resources res = parent.getContext().getResources();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == res.getInteger(R.integer.STYLE_PARALLAX_VALUE)) {
            String dataLeAk843 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk843 = android.util.Log.d("leak-843", dataLeAk843);
			View v = inflater.inflate(R.layout.album_cover_parallax, parent, false);
            viewHolder = new SimpleAlbumHolder(v);
        } else if (viewType == res.getInteger(R.integer.STYLE_CARDS_VALUE)) {
            String dataLeAk844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk844 = android.util.Log.d("leak-844", dataLeAk844);
			View v = inflater.inflate(R.layout.album_cover_card, parent, false);
            viewHolder = new SimpleAlbumHolder(v);
        } else if (viewType == res.getInteger(R.integer.STYLE_CARDS_2_VALUE)) {
            String dataLeAk845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk845 = android.util.Log.d("leak-845", dataLeAk845);
			View v = inflater.inflate(R.layout.album_cover_card_2, parent, false);
            viewHolder = new SimpleAlbumHolder(v);
        } else /*if (viewType == res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE))*/ {
            String dataLeAk846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk846 = android.util.Log.d("leak-846", dataLeAk846);
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
        String dataLeAk847 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk847 = android.util.Log.d("leak-847", dataLeAk847);
		final Album album = albums.get(position);

        ((AlbumHolder) holder).setAlbum(album);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            String dataLeAk848 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk848 = android.util.Log.d("leak-848", dataLeAk848);

			@Override
            public void onClick(View view) {
                String dataLeAk849 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk849 = android.util.Log.d("leak-849", dataLeAk849);
				Intent intent = new Intent(holder.itemView.getContext(), AlbumActivity.class);

                //intent.putExtra(AlbumActivity.ALBUM, album);
                intent.putExtra(AlbumActivity.ALBUM_PATH, album.getPath());

                if (pick_photos) {
                    String dataLeAk850 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk850 = android.util.Log.d("leak-850", dataLeAk850);
					Context c = holder.itemView.getContext();
                    boolean allowMultiple = false;
                    if (c instanceof Activity) {
                        String dataLeAk851 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk851 = android.util.Log.d("leak-851", dataLeAk851);
						Activity a = (Activity) c;
                        allowMultiple = a.getIntent()
                                .getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
                    }
                    intent.setAction(MainActivity.PICK_PHOTOS);
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple);
                } else {
                    String dataLeAk852 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk852 = android.util.Log.d("leak-852", dataLeAk852);
					intent.setAction(AlbumActivity.VIEW_ALBUM);
                }

                ActivityOptionsCompat options;
                Activity context = (Activity) holder.itemView.getContext();
                if (!pick_photos) {
                    String dataLeAk853 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk853 = android.util.Log.d("leak-853", dataLeAk853);
					//noinspection unchecked
                    options = ActivityOptionsCompat.makeSceneTransitionAnimation(context);
                    context.startActivityForResult(intent,
                            MainActivity.REFRESH_PHOTOS_REQUEST_CODE, options.toBundle());
                } else {
                    String dataLeAk854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk854 = android.util.Log.d("leak-854", dataLeAk854);
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
        String dataLeAk855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk855 = android.util.Log.d("leak-855", dataLeAk855);
		this.selectorManager = selectorManager;
        notifyItemRangeChanged(0, getItemCount());
    }

    public SelectorModeManager getSelectorManager() {
        String dataLeAk856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk856 = android.util.Log.d("leak-856", dataLeAk856);
		return selectorManager;
    }

    @Override
    public int getItemCount() {
        String dataLeAk857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk857 = android.util.Log.d("leak-857", dataLeAk857);
		return albums != null ? albums.size() : 0;
    }

    public boolean onBackPressed() {
        String dataLeAk858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk858 = android.util.Log.d("leak-858", dataLeAk858);
		return getSelectorManager().onBackPressed();
    }

    public void saveInstanceState(Bundle outState) {
        String dataLeAk859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk859 = android.util.Log.d("leak-859", dataLeAk859);
		getSelectorManager().saveInstanceState(outState);
    }
}
