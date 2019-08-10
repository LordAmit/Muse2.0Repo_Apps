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

    final String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk354 = "";

	String dataLeAk353 = "";

	String dataLeAk352 = "";

	String dataLeAk351 = "";

	String dataLeAk350 = "";

	String dataLeAk348 = "";

	String dataLeAk347 = "";

	String dataLeAk346 = "";

	String dataLeAk345 = "";

	String dataLeAk344 = "";

	private int viewType;

    private ArrayList<Album> albums;

    private boolean pick_photos;

    private SelectorModeManager selectorManager;

    public RecyclerViewAdapter(Context context, boolean pick_photos) {
        dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-0", dataLeAk344);
		android.util.Log.d("leak-345-0", dataLeAk345);
		android.util.Log.d("leak-346-0", dataLeAk346);
		android.util.Log.d("leak-347-0", dataLeAk347);
		android.util.Log.d("leak-348-0", dataLeAk348);
		android.util.Log.d("leak-350-0", dataLeAk350);
		android.util.Log.d("leak-351-0", dataLeAk351);
		android.util.Log.d("leak-352-0", dataLeAk352);
		android.util.Log.d("leak-353-0", dataLeAk353);
		android.util.Log.d("leak-354-0", dataLeAk354);
		this.pick_photos = pick_photos;
        Settings settings = Settings.getInstance(context);

        viewType = settings.getStyle(context, pick_photos);
        // not allowing NestedRecyclerView Style, when picking photos
        Resources res = context.getResources();
        if (pick_photos && viewType == res
                .getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE)) {
            viewType = res.getInteger(R.integer.STYLE_CARDS_VALUE);
        }

        selectorManager = new SelectorModeManager();
    }

    public RecyclerViewAdapter setAlbums(ArrayList<Album> albums) {
        dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-1", dataLeAk344);
		android.util.Log.d("leak-345-1", dataLeAk345);
		android.util.Log.d("leak-346-1", dataLeAk346);
		android.util.Log.d("leak-347-1", dataLeAk347);
		android.util.Log.d("leak-348-1", dataLeAk348);
		android.util.Log.d("leak-350-1", dataLeAk350);
		android.util.Log.d("leak-351-1", dataLeAk351);
		android.util.Log.d("leak-352-1", dataLeAk352);
		android.util.Log.d("leak-353-1", dataLeAk353);
		android.util.Log.d("leak-354-1", dataLeAk354);
		this.albums = albums;
        return this;
    }

    @Override
    public int getItemViewType(int position) {
        dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-2", dataLeAk344);
		android.util.Log.d("leak-345-2", dataLeAk345);
		android.util.Log.d("leak-346-2", dataLeAk346);
		android.util.Log.d("leak-347-2", dataLeAk347);
		android.util.Log.d("leak-348-2", dataLeAk348);
		android.util.Log.d("leak-350-2", dataLeAk350);
		android.util.Log.d("leak-351-2", dataLeAk351);
		android.util.Log.d("leak-352-2", dataLeAk352);
		android.util.Log.d("leak-353-2", dataLeAk353);
		android.util.Log.d("leak-354-2", dataLeAk354);
		boolean albumExcluded
                = Provider.isDirExcluded(albums.get(position).getPath(),
                Provider.getExcludedPaths()) ||
                Provider.isDirExcludedBecauseParentDirIsExcluded(
                        albums.get(position).getPath(), Provider.getExcludedPaths());
        if (albumExcluded) {
            return viewType + 1;
        } else {
            return viewType;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-3", dataLeAk344);
		android.util.Log.d("leak-345-3", dataLeAk345);
		android.util.Log.d("leak-346-3", dataLeAk346);
		android.util.Log.d("leak-347-3", dataLeAk347);
		android.util.Log.d("leak-348-3", dataLeAk348);
		android.util.Log.d("leak-350-3", dataLeAk350);
		android.util.Log.d("leak-351-3", dataLeAk351);
		android.util.Log.d("leak-352-3", dataLeAk352);
		android.util.Log.d("leak-353-3", dataLeAk353);
		android.util.Log.d("leak-354-3", dataLeAk354);
		RecyclerView.ViewHolder viewHolder;
        Resources res = parent.getContext().getResources();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == res.getInteger(R.integer.STYLE_PARALLAX_VALUE)) {
            View v = inflater.inflate(R.layout.album_cover_parallax, parent, false);
            viewHolder = new SimpleAlbumHolder(v);
        } else if (viewType == res.getInteger(R.integer.STYLE_CARDS_VALUE)) {
            View v = inflater.inflate(R.layout.album_cover_card, parent, false);
            viewHolder = new SimpleAlbumHolder(v);
        } else if (viewType == res.getInteger(R.integer.STYLE_CARDS_2_VALUE)) {
            View v = inflater.inflate(R.layout.album_cover_card_2, parent, false);
            viewHolder = new SimpleAlbumHolder(v);
        } else /*if (viewType == res.getInteger(R.integer.STYLE_NESTED_RECYCLER_VIEW_VALUE))*/ {
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
        dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-4", dataLeAk344);
		android.util.Log.d("leak-345-4", dataLeAk345);
		android.util.Log.d("leak-346-4", dataLeAk346);
		android.util.Log.d("leak-347-4", dataLeAk347);
		android.util.Log.d("leak-348-4", dataLeAk348);
		android.util.Log.d("leak-350-4", dataLeAk350);
		android.util.Log.d("leak-351-4", dataLeAk351);
		android.util.Log.d("leak-352-4", dataLeAk352);
		android.util.Log.d("leak-353-4", dataLeAk353);
		android.util.Log.d("leak-354-4", dataLeAk354);
		final Album album = albums.get(position);

        ((AlbumHolder) holder).setAlbum(album);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            String dataLeAk349 = "";

			@Override
            public void onClick(View view) {
                dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-356-0", dataLeAk356);
				android.util.Log.d("leak-349-0", dataLeAk349);
				Intent intent = new Intent(holder.itemView.getContext(), AlbumActivity.class);

                //intent.putExtra(AlbumActivity.ALBUM, album);
                intent.putExtra(AlbumActivity.ALBUM_PATH, album.getPath());

                if (pick_photos) {
                    Context c = holder.itemView.getContext();
                    boolean allowMultiple = false;
                    if (c instanceof Activity) {
                        Activity a = (Activity) c;
                        allowMultiple = a.getIntent()
                                .getBooleanExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
                    }
                    intent.setAction(MainActivity.PICK_PHOTOS);
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple);
                } else {
                    intent.setAction(AlbumActivity.VIEW_ALBUM);
                }

                ActivityOptionsCompat options;
                Activity context = (Activity) holder.itemView.getContext();
                if (!pick_photos) {
                    //noinspection unchecked
                    options = ActivityOptionsCompat.makeSceneTransitionAnimation(context);
                    context.startActivityForResult(intent,
                            MainActivity.REFRESH_PHOTOS_REQUEST_CODE, options.toBundle());
                } else {
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
        dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-5", dataLeAk344);
		android.util.Log.d("leak-345-5", dataLeAk345);
		android.util.Log.d("leak-346-5", dataLeAk346);
		android.util.Log.d("leak-347-5", dataLeAk347);
		android.util.Log.d("leak-348-5", dataLeAk348);
		android.util.Log.d("leak-350-5", dataLeAk350);
		android.util.Log.d("leak-351-5", dataLeAk351);
		android.util.Log.d("leak-352-5", dataLeAk352);
		android.util.Log.d("leak-353-5", dataLeAk353);
		android.util.Log.d("leak-354-5", dataLeAk354);
		this.selectorManager = selectorManager;
        notifyItemRangeChanged(0, getItemCount());
    }

    public SelectorModeManager getSelectorManager() {
        dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-6", dataLeAk344);
		android.util.Log.d("leak-345-6", dataLeAk345);
		android.util.Log.d("leak-346-6", dataLeAk346);
		android.util.Log.d("leak-347-6", dataLeAk347);
		android.util.Log.d("leak-348-6", dataLeAk348);
		android.util.Log.d("leak-350-6", dataLeAk350);
		android.util.Log.d("leak-351-6", dataLeAk351);
		android.util.Log.d("leak-352-6", dataLeAk352);
		android.util.Log.d("leak-353-6", dataLeAk353);
		android.util.Log.d("leak-354-6", dataLeAk354);
		return selectorManager;
    }

    @Override
    public int getItemCount() {
        dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-7", dataLeAk344);
		android.util.Log.d("leak-345-7", dataLeAk345);
		android.util.Log.d("leak-346-7", dataLeAk346);
		android.util.Log.d("leak-347-7", dataLeAk347);
		android.util.Log.d("leak-348-7", dataLeAk348);
		android.util.Log.d("leak-350-7", dataLeAk350);
		android.util.Log.d("leak-351-7", dataLeAk351);
		android.util.Log.d("leak-352-7", dataLeAk352);
		android.util.Log.d("leak-353-7", dataLeAk353);
		android.util.Log.d("leak-354-7", dataLeAk354);
		return albums != null ? albums.size() : 0;
    }

    public boolean onBackPressed() {
        dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-8", dataLeAk344);
		android.util.Log.d("leak-345-8", dataLeAk345);
		android.util.Log.d("leak-346-8", dataLeAk346);
		android.util.Log.d("leak-347-8", dataLeAk347);
		android.util.Log.d("leak-348-8", dataLeAk348);
		android.util.Log.d("leak-350-8", dataLeAk350);
		android.util.Log.d("leak-351-8", dataLeAk351);
		android.util.Log.d("leak-352-8", dataLeAk352);
		android.util.Log.d("leak-353-8", dataLeAk353);
		android.util.Log.d("leak-354-8", dataLeAk354);
		return getSelectorManager().onBackPressed();
    }

    public void saveInstanceState(Bundle outState) {
        dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-344-9", dataLeAk344);
		android.util.Log.d("leak-345-9", dataLeAk345);
		android.util.Log.d("leak-346-9", dataLeAk346);
		android.util.Log.d("leak-347-9", dataLeAk347);
		android.util.Log.d("leak-348-9", dataLeAk348);
		android.util.Log.d("leak-350-9", dataLeAk350);
		android.util.Log.d("leak-351-9", dataLeAk351);
		android.util.Log.d("leak-352-9", dataLeAk352);
		android.util.Log.d("leak-353-9", dataLeAk353);
		android.util.Log.d("leak-354-9", dataLeAk354);
		getSelectorManager().saveInstanceState(outState);
    }
}
