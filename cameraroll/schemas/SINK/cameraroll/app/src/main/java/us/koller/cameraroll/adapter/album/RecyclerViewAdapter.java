package us.koller.cameraroll.adapter.album;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelflisar.dragselectrecyclerview.DragSelectTouchListener;

import us.koller.cameraroll.R;
import us.koller.cameraroll.adapter.SelectorModeManager;
import us.koller.cameraroll.adapter.album.viewHolder.AlbumItemHolder;
import us.koller.cameraroll.adapter.album.viewHolder.GifViewHolder;
import us.koller.cameraroll.adapter.album.viewHolder.PhotoViewHolder;
import us.koller.cameraroll.adapter.album.viewHolder.RAWImageHolder;
import us.koller.cameraroll.adapter.album.viewHolder.VideoViewHolder;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Gif;
import us.koller.cameraroll.data.models.Photo;
import us.koller.cameraroll.data.models.RAWImage;
import us.koller.cameraroll.data.models.Video;
import us.koller.cameraroll.ui.ItemActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    final String dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk309 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk308 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk306 = "";

	String dataLeAk305 = "";

	String dataLeAk304 = "";

	String dataLeAk303 = "";

	String dataLeAk302 = "";

	String dataLeAk301 = "";

	String dataLeAk300 = "";

	String dataLeAk299 = "";

	String dataLeAk298 = "";

	String dataLeAk297 = "";

	String dataLeAk296 = "";

	String dataLeAk295 = "";

	String dataLeAk294 = "";

	String dataLeAk293 = "";

	String dataLeAk292 = "";

	String dataLeAk291 = "";

	String dataLeAk288 = "";

	String dataLeAk287 = "";

	String dataLeAk286 = "";

	String dataLeAk285 = "";

	String dataLeAk283 = "";

	@SuppressWarnings("FieldCanBeLocal")
    private final int VIEW_TYPE_PHOTO = 1;
    private final int VIEW_TYPE_GIF = 2;
    private final int VIEW_TYPE_VIDEO = 3;
    private final int VIEW_TYPE_RAW = 4;

    private Album album;

    private boolean pick_photos;

    private SelectorModeManager manager;

    private DragSelectTouchListener dragSelectTouchListener;

    public RecyclerViewAdapter(SelectorModeManager.Callback callback, final RecyclerView recyclerView,
                               final Album album, boolean pick_photos) {
        dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-0", dataLeAk283);
		android.util.Log.d("leak-285-0", dataLeAk285);
		android.util.Log.d("leak-286-0", dataLeAk286);
		android.util.Log.d("leak-287-0", dataLeAk287);
		android.util.Log.d("leak-288-0", dataLeAk288);
		android.util.Log.d("leak-291-0", dataLeAk291);
		android.util.Log.d("leak-292-0", dataLeAk292);
		android.util.Log.d("leak-293-0", dataLeAk293);
		android.util.Log.d("leak-294-0", dataLeAk294);
		android.util.Log.d("leak-295-0", dataLeAk295);
		android.util.Log.d("leak-296-0", dataLeAk296);
		android.util.Log.d("leak-297-0", dataLeAk297);
		android.util.Log.d("leak-298-0", dataLeAk298);
		android.util.Log.d("leak-299-0", dataLeAk299);
		android.util.Log.d("leak-300-0", dataLeAk300);
		android.util.Log.d("leak-301-0", dataLeAk301);
		android.util.Log.d("leak-302-0", dataLeAk302);
		android.util.Log.d("leak-303-0", dataLeAk303);
		android.util.Log.d("leak-304-0", dataLeAk304);
		android.util.Log.d("leak-305-0", dataLeAk305);
		android.util.Log.d("leak-306-0", dataLeAk306);
		this.album = album;
        this.pick_photos = pick_photos;

        manager = new SelectorModeManager();
        manager.addCallback(callback);

        if (pick_photos) {
            setSelectorMode(true);
            if (callback != null) {
                callback.onSelectorModeEnter();
            }
        }

        //disable default change animation
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        if (callback != null && dragSelectEnabled()) {
            dragSelectTouchListener = new DragSelectTouchListener()
                    .withSelectListener(new DragSelectTouchListener.OnDragSelectListener() {
                        String dataLeAk284 = "";

						@Override
                        public void onSelectChange(int start, int end, boolean isSelected) {
                            dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							android.util.Log.d("leak-308-0", dataLeAk308);
							android.util.Log.d("leak-284-0", dataLeAk284);
							for (int i = start; i <= end; i++) {
                                manager.onItemSelect(album.getAlbumItems().get(i).getPath());
                                //update ViewHolder
                                notifyItemChanged(i);
                            }
                        }
                    });
            recyclerView.addOnItemTouchListener(dragSelectTouchListener);
        }
    }

    public void setSelectorModeManager(SelectorModeManager manager) {
        dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-1", dataLeAk283);
		android.util.Log.d("leak-285-1", dataLeAk285);
		android.util.Log.d("leak-286-1", dataLeAk286);
		android.util.Log.d("leak-287-1", dataLeAk287);
		android.util.Log.d("leak-288-1", dataLeAk288);
		android.util.Log.d("leak-291-1", dataLeAk291);
		android.util.Log.d("leak-292-1", dataLeAk292);
		android.util.Log.d("leak-293-1", dataLeAk293);
		android.util.Log.d("leak-294-1", dataLeAk294);
		android.util.Log.d("leak-295-1", dataLeAk295);
		android.util.Log.d("leak-296-1", dataLeAk296);
		android.util.Log.d("leak-297-1", dataLeAk297);
		android.util.Log.d("leak-298-1", dataLeAk298);
		android.util.Log.d("leak-299-1", dataLeAk299);
		android.util.Log.d("leak-300-1", dataLeAk300);
		android.util.Log.d("leak-301-1", dataLeAk301);
		android.util.Log.d("leak-302-1", dataLeAk302);
		android.util.Log.d("leak-303-1", dataLeAk303);
		android.util.Log.d("leak-304-1", dataLeAk304);
		android.util.Log.d("leak-305-1", dataLeAk305);
		android.util.Log.d("leak-306-1", dataLeAk306);
		this.manager = manager;
    }

    @Override
    public int getItemViewType(int position) {
        dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-2", dataLeAk283);
		android.util.Log.d("leak-285-2", dataLeAk285);
		android.util.Log.d("leak-286-2", dataLeAk286);
		android.util.Log.d("leak-287-2", dataLeAk287);
		android.util.Log.d("leak-288-2", dataLeAk288);
		android.util.Log.d("leak-291-2", dataLeAk291);
		android.util.Log.d("leak-292-2", dataLeAk292);
		android.util.Log.d("leak-293-2", dataLeAk293);
		android.util.Log.d("leak-294-2", dataLeAk294);
		android.util.Log.d("leak-295-2", dataLeAk295);
		android.util.Log.d("leak-296-2", dataLeAk296);
		android.util.Log.d("leak-297-2", dataLeAk297);
		android.util.Log.d("leak-298-2", dataLeAk298);
		android.util.Log.d("leak-299-2", dataLeAk299);
		android.util.Log.d("leak-300-2", dataLeAk300);
		android.util.Log.d("leak-301-2", dataLeAk301);
		android.util.Log.d("leak-302-2", dataLeAk302);
		android.util.Log.d("leak-303-2", dataLeAk303);
		android.util.Log.d("leak-304-2", dataLeAk304);
		android.util.Log.d("leak-305-2", dataLeAk305);
		android.util.Log.d("leak-306-2", dataLeAk306);
		AlbumItem albumItem = album.getAlbumItems().get(position);
        if (albumItem instanceof RAWImage) {
            return VIEW_TYPE_RAW;
        } else if (albumItem instanceof Gif) {
            return VIEW_TYPE_GIF;
        } else if (albumItem instanceof Photo) {
            return VIEW_TYPE_PHOTO;
        } else if (albumItem instanceof Video) {
            return VIEW_TYPE_VIDEO;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-3", dataLeAk283);
		android.util.Log.d("leak-285-3", dataLeAk285);
		android.util.Log.d("leak-286-3", dataLeAk286);
		android.util.Log.d("leak-287-3", dataLeAk287);
		android.util.Log.d("leak-288-3", dataLeAk288);
		android.util.Log.d("leak-291-3", dataLeAk291);
		android.util.Log.d("leak-292-3", dataLeAk292);
		android.util.Log.d("leak-293-3", dataLeAk293);
		android.util.Log.d("leak-294-3", dataLeAk294);
		android.util.Log.d("leak-295-3", dataLeAk295);
		android.util.Log.d("leak-296-3", dataLeAk296);
		android.util.Log.d("leak-297-3", dataLeAk297);
		android.util.Log.d("leak-298-3", dataLeAk298);
		android.util.Log.d("leak-299-3", dataLeAk299);
		android.util.Log.d("leak-300-3", dataLeAk300);
		android.util.Log.d("leak-301-3", dataLeAk301);
		android.util.Log.d("leak-302-3", dataLeAk302);
		android.util.Log.d("leak-303-3", dataLeAk303);
		android.util.Log.d("leak-304-3", dataLeAk304);
		android.util.Log.d("leak-305-3", dataLeAk305);
		android.util.Log.d("leak-306-3", dataLeAk306);
		View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.albumitem_cover, parent, false);
        switch (viewType) {
            case VIEW_TYPE_RAW:
                return new RAWImageHolder(v);
            case VIEW_TYPE_GIF:
                return new GifViewHolder(v);
            case VIEW_TYPE_VIDEO:
                return new VideoViewHolder(v);
            case VIEW_TYPE_PHOTO:
                return new PhotoViewHolder(v);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-4", dataLeAk283);
		android.util.Log.d("leak-285-4", dataLeAk285);
		android.util.Log.d("leak-286-4", dataLeAk286);
		android.util.Log.d("leak-287-4", dataLeAk287);
		android.util.Log.d("leak-288-4", dataLeAk288);
		android.util.Log.d("leak-291-4", dataLeAk291);
		android.util.Log.d("leak-292-4", dataLeAk292);
		android.util.Log.d("leak-293-4", dataLeAk293);
		android.util.Log.d("leak-294-4", dataLeAk294);
		android.util.Log.d("leak-295-4", dataLeAk295);
		android.util.Log.d("leak-296-4", dataLeAk296);
		android.util.Log.d("leak-297-4", dataLeAk297);
		android.util.Log.d("leak-298-4", dataLeAk298);
		android.util.Log.d("leak-299-4", dataLeAk299);
		android.util.Log.d("leak-300-4", dataLeAk300);
		android.util.Log.d("leak-301-4", dataLeAk301);
		android.util.Log.d("leak-302-4", dataLeAk302);
		android.util.Log.d("leak-303-4", dataLeAk303);
		android.util.Log.d("leak-304-4", dataLeAk304);
		android.util.Log.d("leak-305-4", dataLeAk305);
		android.util.Log.d("leak-306-4", dataLeAk306);
		final AlbumItem albumItem = album.getAlbumItems().get(position);

        if (!albumItem.equals(((AlbumItemHolder) holder).getAlbumItem())) {
            ((AlbumItemHolder) holder).setAlbumItem(albumItem);
        }

        boolean selected = manager.isItemSelected(albumItem.getPath());

        ((AlbumItemHolder) holder).setSelected(selected);

        holder.itemView.setTag(albumItem.getPath());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            String dataLeAk289 = "";

			@Override
            public void onClick(View view) {
                dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-309-0", dataLeAk309);
				android.util.Log.d("leak-289-0", dataLeAk289);
				if (getSelectorMode()) {
                    onItemSelected((AlbumItemHolder) holder);
                } else {
                    Context context = holder.itemView.getContext();
                    Intent intent = new Intent(context, ItemActivity.class);
                    intent.putExtra(ItemActivity.ALBUM_ITEM, albumItem);
                    intent.putExtra(ItemActivity.ALBUM_PATH, album.getPath());
                    intent.putExtra(ItemActivity.ITEM_POSITION, album.getAlbumItems().indexOf(albumItem));

                    ActivityOptionsCompat options =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(
                                    (Activity) context, holder.itemView.findViewById(R.id.image),
                                    albumItem.getPath());
                    ActivityCompat.startActivityForResult((Activity) context, intent,
                            ItemActivity.VIEW_IMAGE, options.toBundle());
                }
            }
        });

        if (getSelectorManager().callbacksAttached()) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk290 = "";

				@Override
                public boolean onLongClick(View view) {
                    dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-310-0", dataLeAk310);
					android.util.Log.d("leak-290-0", dataLeAk290);
					if (!getSelectorMode()) {
                        setSelectorMode(true);
                        clearSelectedItemsList();
                    }

                    onItemSelected((AlbumItemHolder) holder);

                    if (dragSelectEnabled()) {
                        //notify DragSelectTouchListener
                        boolean selected = manager.isItemSelected(albumItem.getPath());
                        if (selected) {
                            int position = getAlbum().getAlbumItems().indexOf(albumItem);
                            dragSelectTouchListener.startDragSelection(position);
                        }
                    }
                    return true;
                }
            });
        }
    }

    public boolean isSelectorModeActive() {
        dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-5", dataLeAk283);
		android.util.Log.d("leak-285-5", dataLeAk285);
		android.util.Log.d("leak-286-5", dataLeAk286);
		android.util.Log.d("leak-287-5", dataLeAk287);
		android.util.Log.d("leak-288-5", dataLeAk288);
		android.util.Log.d("leak-291-5", dataLeAk291);
		android.util.Log.d("leak-292-5", dataLeAk292);
		android.util.Log.d("leak-293-5", dataLeAk293);
		android.util.Log.d("leak-294-5", dataLeAk294);
		android.util.Log.d("leak-295-5", dataLeAk295);
		android.util.Log.d("leak-296-5", dataLeAk296);
		android.util.Log.d("leak-297-5", dataLeAk297);
		android.util.Log.d("leak-298-5", dataLeAk298);
		android.util.Log.d("leak-299-5", dataLeAk299);
		android.util.Log.d("leak-300-5", dataLeAk300);
		android.util.Log.d("leak-301-5", dataLeAk301);
		android.util.Log.d("leak-302-5", dataLeAk302);
		android.util.Log.d("leak-303-5", dataLeAk303);
		android.util.Log.d("leak-304-5", dataLeAk304);
		android.util.Log.d("leak-305-5", dataLeAk305);
		android.util.Log.d("leak-306-5", dataLeAk306);
		return getSelectorMode() && !pick_photos;
    }

    public void restoreSelectedItems() {
        dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-6", dataLeAk283);
		android.util.Log.d("leak-285-6", dataLeAk285);
		android.util.Log.d("leak-286-6", dataLeAk286);
		android.util.Log.d("leak-287-6", dataLeAk287);
		android.util.Log.d("leak-288-6", dataLeAk288);
		android.util.Log.d("leak-291-6", dataLeAk291);
		android.util.Log.d("leak-292-6", dataLeAk292);
		android.util.Log.d("leak-293-6", dataLeAk293);
		android.util.Log.d("leak-294-6", dataLeAk294);
		android.util.Log.d("leak-295-6", dataLeAk295);
		android.util.Log.d("leak-296-6", dataLeAk296);
		android.util.Log.d("leak-297-6", dataLeAk297);
		android.util.Log.d("leak-298-6", dataLeAk298);
		android.util.Log.d("leak-299-6", dataLeAk299);
		android.util.Log.d("leak-300-6", dataLeAk300);
		android.util.Log.d("leak-301-6", dataLeAk301);
		android.util.Log.d("leak-302-6", dataLeAk302);
		android.util.Log.d("leak-303-6", dataLeAk303);
		android.util.Log.d("leak-304-6", dataLeAk304);
		android.util.Log.d("leak-305-6", dataLeAk305);
		android.util.Log.d("leak-306-6", dataLeAk306);
		//notify AlbumActivity
        getSelectorManager().onSelectorModeEnter();

        for (int i = 0; i < this.album.getAlbumItems().size(); i++) {
            if (manager.isItemSelected(album.getAlbumItems().get(i).getPath())) {
                notifyItemChanged(i);
            }
        }

        getSelectorManager().onItemSelected(manager.getSelectedItemCount());
    }

    private void checkForNoSelectedItems() {
        dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-7", dataLeAk283);
		android.util.Log.d("leak-285-7", dataLeAk285);
		android.util.Log.d("leak-286-7", dataLeAk286);
		android.util.Log.d("leak-287-7", dataLeAk287);
		android.util.Log.d("leak-288-7", dataLeAk288);
		android.util.Log.d("leak-291-7", dataLeAk291);
		android.util.Log.d("leak-292-7", dataLeAk292);
		android.util.Log.d("leak-293-7", dataLeAk293);
		android.util.Log.d("leak-294-7", dataLeAk294);
		android.util.Log.d("leak-295-7", dataLeAk295);
		android.util.Log.d("leak-296-7", dataLeAk296);
		android.util.Log.d("leak-297-7", dataLeAk297);
		android.util.Log.d("leak-298-7", dataLeAk298);
		android.util.Log.d("leak-299-7", dataLeAk299);
		android.util.Log.d("leak-300-7", dataLeAk300);
		android.util.Log.d("leak-301-7", dataLeAk301);
		android.util.Log.d("leak-302-7", dataLeAk302);
		android.util.Log.d("leak-303-7", dataLeAk303);
		android.util.Log.d("leak-304-7", dataLeAk304);
		android.util.Log.d("leak-305-7", dataLeAk305);
		android.util.Log.d("leak-306-7", dataLeAk306);
		if (getSelectedItemCount() == 0 && !pick_photos) {
            cancelSelectorMode(null);
        }
    }

    private int getSelectedItemCount() {
        dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-8", dataLeAk283);
		android.util.Log.d("leak-285-8", dataLeAk285);
		android.util.Log.d("leak-286-8", dataLeAk286);
		android.util.Log.d("leak-287-8", dataLeAk287);
		android.util.Log.d("leak-288-8", dataLeAk288);
		android.util.Log.d("leak-291-8", dataLeAk291);
		android.util.Log.d("leak-292-8", dataLeAk292);
		android.util.Log.d("leak-293-8", dataLeAk293);
		android.util.Log.d("leak-294-8", dataLeAk294);
		android.util.Log.d("leak-295-8", dataLeAk295);
		android.util.Log.d("leak-296-8", dataLeAk296);
		android.util.Log.d("leak-297-8", dataLeAk297);
		android.util.Log.d("leak-298-8", dataLeAk298);
		android.util.Log.d("leak-299-8", dataLeAk299);
		android.util.Log.d("leak-300-8", dataLeAk300);
		android.util.Log.d("leak-301-8", dataLeAk301);
		android.util.Log.d("leak-302-8", dataLeAk302);
		android.util.Log.d("leak-303-8", dataLeAk303);
		android.util.Log.d("leak-304-8", dataLeAk304);
		android.util.Log.d("leak-305-8", dataLeAk305);
		android.util.Log.d("leak-306-8", dataLeAk306);
		return manager.getSelectedItemCount();
    }

    private void onItemSelected(AlbumItemHolder holder) {
        dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-9", dataLeAk283);
		android.util.Log.d("leak-285-9", dataLeAk285);
		android.util.Log.d("leak-286-9", dataLeAk286);
		android.util.Log.d("leak-287-9", dataLeAk287);
		android.util.Log.d("leak-288-9", dataLeAk288);
		android.util.Log.d("leak-291-9", dataLeAk291);
		android.util.Log.d("leak-292-9", dataLeAk292);
		android.util.Log.d("leak-293-9", dataLeAk293);
		android.util.Log.d("leak-294-9", dataLeAk294);
		android.util.Log.d("leak-295-9", dataLeAk295);
		android.util.Log.d("leak-296-9", dataLeAk296);
		android.util.Log.d("leak-297-9", dataLeAk297);
		android.util.Log.d("leak-298-9", dataLeAk298);
		android.util.Log.d("leak-299-9", dataLeAk299);
		android.util.Log.d("leak-300-9", dataLeAk300);
		android.util.Log.d("leak-301-9", dataLeAk301);
		android.util.Log.d("leak-302-9", dataLeAk302);
		android.util.Log.d("leak-303-9", dataLeAk303);
		android.util.Log.d("leak-304-9", dataLeAk304);
		android.util.Log.d("leak-305-9", dataLeAk305);
		android.util.Log.d("leak-306-9", dataLeAk306);
		boolean selected = manager.onItemSelect(holder.albumItem.getPath());
        holder.setSelected(selected);
        checkForNoSelectedItems();
    }

    public String[] cancelSelectorMode(Activity context) {
        dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-10", dataLeAk283);
		android.util.Log.d("leak-285-10", dataLeAk285);
		android.util.Log.d("leak-286-10", dataLeAk286);
		android.util.Log.d("leak-287-10", dataLeAk287);
		android.util.Log.d("leak-288-10", dataLeAk288);
		android.util.Log.d("leak-291-10", dataLeAk291);
		android.util.Log.d("leak-292-10", dataLeAk292);
		android.util.Log.d("leak-293-10", dataLeAk293);
		android.util.Log.d("leak-294-10", dataLeAk294);
		android.util.Log.d("leak-295-10", dataLeAk295);
		android.util.Log.d("leak-296-10", dataLeAk296);
		android.util.Log.d("leak-297-10", dataLeAk297);
		android.util.Log.d("leak-298-10", dataLeAk298);
		android.util.Log.d("leak-299-10", dataLeAk299);
		android.util.Log.d("leak-300-10", dataLeAk300);
		android.util.Log.d("leak-301-10", dataLeAk301);
		android.util.Log.d("leak-302-10", dataLeAk302);
		android.util.Log.d("leak-303-10", dataLeAk303);
		android.util.Log.d("leak-304-10", dataLeAk304);
		android.util.Log.d("leak-305-10", dataLeAk305);
		android.util.Log.d("leak-306-10", dataLeAk306);
		setSelectorMode(false);
        //update ui
        for (int i = 0; i < this.album.getAlbumItems().size(); i++) {
            if (manager.isItemSelected(album.getAlbumItems().get(i).getPath())) {
                notifyItemChanged(i);
            }
        }
        //generate paths array
        String[] paths;
        if (context != null) {
            paths = manager.createStringArray(context);
        } else {
            paths = null;
        }
        //clear manager list
        clearSelectedItemsList();
        return paths;
    }

    public boolean onBackPressed() {
        dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-11", dataLeAk283);
		android.util.Log.d("leak-285-11", dataLeAk285);
		android.util.Log.d("leak-286-11", dataLeAk286);
		android.util.Log.d("leak-287-11", dataLeAk287);
		android.util.Log.d("leak-288-11", dataLeAk288);
		android.util.Log.d("leak-291-11", dataLeAk291);
		android.util.Log.d("leak-292-11", dataLeAk292);
		android.util.Log.d("leak-293-11", dataLeAk293);
		android.util.Log.d("leak-294-11", dataLeAk294);
		android.util.Log.d("leak-295-11", dataLeAk295);
		android.util.Log.d("leak-296-11", dataLeAk296);
		android.util.Log.d("leak-297-11", dataLeAk297);
		android.util.Log.d("leak-298-11", dataLeAk298);
		android.util.Log.d("leak-299-11", dataLeAk299);
		android.util.Log.d("leak-300-11", dataLeAk300);
		android.util.Log.d("leak-301-11", dataLeAk301);
		android.util.Log.d("leak-302-11", dataLeAk302);
		android.util.Log.d("leak-303-11", dataLeAk303);
		android.util.Log.d("leak-304-11", dataLeAk304);
		android.util.Log.d("leak-305-11", dataLeAk305);
		android.util.Log.d("leak-306-11", dataLeAk306);
		if (getSelectorMode() && !pick_photos) {
            cancelSelectorMode(null);
            return true;
        }
        return false;
    }

    private boolean getSelectorMode() {
        dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-12", dataLeAk283);
		android.util.Log.d("leak-285-12", dataLeAk285);
		android.util.Log.d("leak-286-12", dataLeAk286);
		android.util.Log.d("leak-287-12", dataLeAk287);
		android.util.Log.d("leak-288-12", dataLeAk288);
		android.util.Log.d("leak-291-12", dataLeAk291);
		android.util.Log.d("leak-292-12", dataLeAk292);
		android.util.Log.d("leak-293-12", dataLeAk293);
		android.util.Log.d("leak-294-12", dataLeAk294);
		android.util.Log.d("leak-295-12", dataLeAk295);
		android.util.Log.d("leak-296-12", dataLeAk296);
		android.util.Log.d("leak-297-12", dataLeAk297);
		android.util.Log.d("leak-298-12", dataLeAk298);
		android.util.Log.d("leak-299-12", dataLeAk299);
		android.util.Log.d("leak-300-12", dataLeAk300);
		android.util.Log.d("leak-301-12", dataLeAk301);
		android.util.Log.d("leak-302-12", dataLeAk302);
		android.util.Log.d("leak-303-12", dataLeAk303);
		android.util.Log.d("leak-304-12", dataLeAk304);
		android.util.Log.d("leak-305-12", dataLeAk305);
		android.util.Log.d("leak-306-12", dataLeAk306);
		return manager.isSelectorModeActive();
    }

    private void setSelectorMode(boolean activate) {
        dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-13", dataLeAk283);
		android.util.Log.d("leak-285-13", dataLeAk285);
		android.util.Log.d("leak-286-13", dataLeAk286);
		android.util.Log.d("leak-287-13", dataLeAk287);
		android.util.Log.d("leak-288-13", dataLeAk288);
		android.util.Log.d("leak-291-13", dataLeAk291);
		android.util.Log.d("leak-292-13", dataLeAk292);
		android.util.Log.d("leak-293-13", dataLeAk293);
		android.util.Log.d("leak-294-13", dataLeAk294);
		android.util.Log.d("leak-295-13", dataLeAk295);
		android.util.Log.d("leak-296-13", dataLeAk296);
		android.util.Log.d("leak-297-13", dataLeAk297);
		android.util.Log.d("leak-298-13", dataLeAk298);
		android.util.Log.d("leak-299-13", dataLeAk299);
		android.util.Log.d("leak-300-13", dataLeAk300);
		android.util.Log.d("leak-301-13", dataLeAk301);
		android.util.Log.d("leak-302-13", dataLeAk302);
		android.util.Log.d("leak-303-13", dataLeAk303);
		android.util.Log.d("leak-304-13", dataLeAk304);
		android.util.Log.d("leak-305-13", dataLeAk305);
		android.util.Log.d("leak-306-13", dataLeAk306);
		manager.setSelectorMode(activate);
    }

    public boolean dragSelectEnabled() {
        dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-14", dataLeAk283);
		android.util.Log.d("leak-285-14", dataLeAk285);
		android.util.Log.d("leak-286-14", dataLeAk286);
		android.util.Log.d("leak-287-14", dataLeAk287);
		android.util.Log.d("leak-288-14", dataLeAk288);
		android.util.Log.d("leak-291-14", dataLeAk291);
		android.util.Log.d("leak-292-14", dataLeAk292);
		android.util.Log.d("leak-293-14", dataLeAk293);
		android.util.Log.d("leak-294-14", dataLeAk294);
		android.util.Log.d("leak-295-14", dataLeAk295);
		android.util.Log.d("leak-296-14", dataLeAk296);
		android.util.Log.d("leak-297-14", dataLeAk297);
		android.util.Log.d("leak-298-14", dataLeAk298);
		android.util.Log.d("leak-299-14", dataLeAk299);
		android.util.Log.d("leak-300-14", dataLeAk300);
		android.util.Log.d("leak-301-14", dataLeAk301);
		android.util.Log.d("leak-302-14", dataLeAk302);
		android.util.Log.d("leak-303-14", dataLeAk303);
		android.util.Log.d("leak-304-14", dataLeAk304);
		android.util.Log.d("leak-305-14", dataLeAk305);
		android.util.Log.d("leak-306-14", dataLeAk306);
		return true;
    }

    private void clearSelectedItemsList() {
        dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-15", dataLeAk283);
		android.util.Log.d("leak-285-15", dataLeAk285);
		android.util.Log.d("leak-286-15", dataLeAk286);
		android.util.Log.d("leak-287-15", dataLeAk287);
		android.util.Log.d("leak-288-15", dataLeAk288);
		android.util.Log.d("leak-291-15", dataLeAk291);
		android.util.Log.d("leak-292-15", dataLeAk292);
		android.util.Log.d("leak-293-15", dataLeAk293);
		android.util.Log.d("leak-294-15", dataLeAk294);
		android.util.Log.d("leak-295-15", dataLeAk295);
		android.util.Log.d("leak-296-15", dataLeAk296);
		android.util.Log.d("leak-297-15", dataLeAk297);
		android.util.Log.d("leak-298-15", dataLeAk298);
		android.util.Log.d("leak-299-15", dataLeAk299);
		android.util.Log.d("leak-300-15", dataLeAk300);
		android.util.Log.d("leak-301-15", dataLeAk301);
		android.util.Log.d("leak-302-15", dataLeAk302);
		android.util.Log.d("leak-303-15", dataLeAk303);
		android.util.Log.d("leak-304-15", dataLeAk304);
		android.util.Log.d("leak-305-15", dataLeAk305);
		android.util.Log.d("leak-306-15", dataLeAk306);
		manager.clearList();
    }

    @Override
    public int getItemCount() {
        dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-16", dataLeAk283);
		android.util.Log.d("leak-285-16", dataLeAk285);
		android.util.Log.d("leak-286-16", dataLeAk286);
		android.util.Log.d("leak-287-16", dataLeAk287);
		android.util.Log.d("leak-288-16", dataLeAk288);
		android.util.Log.d("leak-291-16", dataLeAk291);
		android.util.Log.d("leak-292-16", dataLeAk292);
		android.util.Log.d("leak-293-16", dataLeAk293);
		android.util.Log.d("leak-294-16", dataLeAk294);
		android.util.Log.d("leak-295-16", dataLeAk295);
		android.util.Log.d("leak-296-16", dataLeAk296);
		android.util.Log.d("leak-297-16", dataLeAk297);
		android.util.Log.d("leak-298-16", dataLeAk298);
		android.util.Log.d("leak-299-16", dataLeAk299);
		android.util.Log.d("leak-300-16", dataLeAk300);
		android.util.Log.d("leak-301-16", dataLeAk301);
		android.util.Log.d("leak-302-16", dataLeAk302);
		android.util.Log.d("leak-303-16", dataLeAk303);
		android.util.Log.d("leak-304-16", dataLeAk304);
		android.util.Log.d("leak-305-16", dataLeAk305);
		android.util.Log.d("leak-306-16", dataLeAk306);
		return getAlbum().getAlbumItems().size();
    }

    public Album getAlbum() {
        dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-17", dataLeAk283);
		android.util.Log.d("leak-285-17", dataLeAk285);
		android.util.Log.d("leak-286-17", dataLeAk286);
		android.util.Log.d("leak-287-17", dataLeAk287);
		android.util.Log.d("leak-288-17", dataLeAk288);
		android.util.Log.d("leak-291-17", dataLeAk291);
		android.util.Log.d("leak-292-17", dataLeAk292);
		android.util.Log.d("leak-293-17", dataLeAk293);
		android.util.Log.d("leak-294-17", dataLeAk294);
		android.util.Log.d("leak-295-17", dataLeAk295);
		android.util.Log.d("leak-296-17", dataLeAk296);
		android.util.Log.d("leak-297-17", dataLeAk297);
		android.util.Log.d("leak-298-17", dataLeAk298);
		android.util.Log.d("leak-299-17", dataLeAk299);
		android.util.Log.d("leak-300-17", dataLeAk300);
		android.util.Log.d("leak-301-17", dataLeAk301);
		android.util.Log.d("leak-302-17", dataLeAk302);
		android.util.Log.d("leak-303-17", dataLeAk303);
		android.util.Log.d("leak-304-17", dataLeAk304);
		android.util.Log.d("leak-305-17", dataLeAk305);
		android.util.Log.d("leak-306-17", dataLeAk306);
		return album;
    }

    public void setAlbum(Album album) {
        dataLeAk304 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-18", dataLeAk283);
		android.util.Log.d("leak-285-18", dataLeAk285);
		android.util.Log.d("leak-286-18", dataLeAk286);
		android.util.Log.d("leak-287-18", dataLeAk287);
		android.util.Log.d("leak-288-18", dataLeAk288);
		android.util.Log.d("leak-291-18", dataLeAk291);
		android.util.Log.d("leak-292-18", dataLeAk292);
		android.util.Log.d("leak-293-18", dataLeAk293);
		android.util.Log.d("leak-294-18", dataLeAk294);
		android.util.Log.d("leak-295-18", dataLeAk295);
		android.util.Log.d("leak-296-18", dataLeAk296);
		android.util.Log.d("leak-297-18", dataLeAk297);
		android.util.Log.d("leak-298-18", dataLeAk298);
		android.util.Log.d("leak-299-18", dataLeAk299);
		android.util.Log.d("leak-300-18", dataLeAk300);
		android.util.Log.d("leak-301-18", dataLeAk301);
		android.util.Log.d("leak-302-18", dataLeAk302);
		android.util.Log.d("leak-303-18", dataLeAk303);
		android.util.Log.d("leak-304-18", dataLeAk304);
		android.util.Log.d("leak-305-18", dataLeAk305);
		android.util.Log.d("leak-306-18", dataLeAk306);
		this.album = album;
    }

    public SelectorModeManager getSelectorManager() {
        dataLeAk305 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-19", dataLeAk283);
		android.util.Log.d("leak-285-19", dataLeAk285);
		android.util.Log.d("leak-286-19", dataLeAk286);
		android.util.Log.d("leak-287-19", dataLeAk287);
		android.util.Log.d("leak-288-19", dataLeAk288);
		android.util.Log.d("leak-291-19", dataLeAk291);
		android.util.Log.d("leak-292-19", dataLeAk292);
		android.util.Log.d("leak-293-19", dataLeAk293);
		android.util.Log.d("leak-294-19", dataLeAk294);
		android.util.Log.d("leak-295-19", dataLeAk295);
		android.util.Log.d("leak-296-19", dataLeAk296);
		android.util.Log.d("leak-297-19", dataLeAk297);
		android.util.Log.d("leak-298-19", dataLeAk298);
		android.util.Log.d("leak-299-19", dataLeAk299);
		android.util.Log.d("leak-300-19", dataLeAk300);
		android.util.Log.d("leak-301-19", dataLeAk301);
		android.util.Log.d("leak-302-19", dataLeAk302);
		android.util.Log.d("leak-303-19", dataLeAk303);
		android.util.Log.d("leak-304-19", dataLeAk304);
		android.util.Log.d("leak-305-19", dataLeAk305);
		android.util.Log.d("leak-306-19", dataLeAk306);
		return manager;
    }

    public void saveInstanceState(Bundle state) {
        dataLeAk306 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-283-20", dataLeAk283);
		android.util.Log.d("leak-285-20", dataLeAk285);
		android.util.Log.d("leak-286-20", dataLeAk286);
		android.util.Log.d("leak-287-20", dataLeAk287);
		android.util.Log.d("leak-288-20", dataLeAk288);
		android.util.Log.d("leak-291-20", dataLeAk291);
		android.util.Log.d("leak-292-20", dataLeAk292);
		android.util.Log.d("leak-293-20", dataLeAk293);
		android.util.Log.d("leak-294-20", dataLeAk294);
		android.util.Log.d("leak-295-20", dataLeAk295);
		android.util.Log.d("leak-296-20", dataLeAk296);
		android.util.Log.d("leak-297-20", dataLeAk297);
		android.util.Log.d("leak-298-20", dataLeAk298);
		android.util.Log.d("leak-299-20", dataLeAk299);
		android.util.Log.d("leak-300-20", dataLeAk300);
		android.util.Log.d("leak-301-20", dataLeAk301);
		android.util.Log.d("leak-302-20", dataLeAk302);
		android.util.Log.d("leak-303-20", dataLeAk303);
		android.util.Log.d("leak-304-20", dataLeAk304);
		android.util.Log.d("leak-305-20", dataLeAk305);
		android.util.Log.d("leak-306-20", dataLeAk306);
		manager.saveInstanceState(state);
    }
}
