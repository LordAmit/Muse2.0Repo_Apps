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

    String dataLeAk737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk737 = android.util.Log.d("leak-737", dataLeAk737);

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
        String dataLeAk738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk738 = android.util.Log.d("leak-738", dataLeAk738);
		this.album = album;
        this.pick_photos = pick_photos;

        manager = new SelectorModeManager();
        manager.addCallback(callback);

        if (pick_photos) {
            String dataLeAk739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk739 = android.util.Log.d("leak-739", dataLeAk739);
			setSelectorMode(true);
            if (callback != null) {
                String dataLeAk740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk740 = android.util.Log.d("leak-740", dataLeAk740);
				callback.onSelectorModeEnter();
            }
        }

        //disable default change animation
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        if (callback != null && dragSelectEnabled()) {
            String dataLeAk741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk741 = android.util.Log.d("leak-741", dataLeAk741);
			dragSelectTouchListener = new DragSelectTouchListener()
                    .withSelectListener(new DragSelectTouchListener.OnDragSelectListener() {
                        String dataLeAk742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk742 = android.util.Log.d("leak-742", dataLeAk742);

						@Override
                        public void onSelectChange(int start, int end, boolean isSelected) {
                            String dataLeAk743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk743 = android.util.Log.d("leak-743", dataLeAk743);
							for (int i = start; i <= end; i++) {
                                String dataLeAk744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk744 = android.util.Log.d("leak-744", dataLeAk744);
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
        String dataLeAk745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk745 = android.util.Log.d("leak-745", dataLeAk745);
		this.manager = manager;
    }

    @Override
    public int getItemViewType(int position) {
        String dataLeAk746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk746 = android.util.Log.d("leak-746", dataLeAk746);
		AlbumItem albumItem = album.getAlbumItems().get(position);
        if (albumItem instanceof RAWImage) {
            String dataLeAk747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk747 = android.util.Log.d("leak-747", dataLeAk747);
			return VIEW_TYPE_RAW;
        } else if (albumItem instanceof Gif) {
            String dataLeAk748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk748 = android.util.Log.d("leak-748", dataLeAk748);
			return VIEW_TYPE_GIF;
        } else if (albumItem instanceof Photo) {
            String dataLeAk749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk749 = android.util.Log.d("leak-749", dataLeAk749);
			return VIEW_TYPE_PHOTO;
        } else if (albumItem instanceof Video) {
            String dataLeAk750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk750 = android.util.Log.d("leak-750", dataLeAk750);
			return VIEW_TYPE_VIDEO;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk751 = android.util.Log.d("leak-751", dataLeAk751);
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
        String dataLeAk752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk752 = android.util.Log.d("leak-752", dataLeAk752);
		final AlbumItem albumItem = album.getAlbumItems().get(position);

        if (!albumItem.equals(((AlbumItemHolder) holder).getAlbumItem())) {
            String dataLeAk753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk753 = android.util.Log.d("leak-753", dataLeAk753);
			((AlbumItemHolder) holder).setAlbumItem(albumItem);
        }

        boolean selected = manager.isItemSelected(albumItem.getPath());

        ((AlbumItemHolder) holder).setSelected(selected);

        holder.itemView.setTag(albumItem.getPath());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            String dataLeAk754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk754 = android.util.Log.d("leak-754", dataLeAk754);

			@Override
            public void onClick(View view) {
                String dataLeAk755 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk755 = android.util.Log.d("leak-755", dataLeAk755);
				if (getSelectorMode()) {
                    String dataLeAk756 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk756 = android.util.Log.d("leak-756", dataLeAk756);
					onItemSelected((AlbumItemHolder) holder);
                } else {
                    String dataLeAk757 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk757 = android.util.Log.d("leak-757", dataLeAk757);
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
            String dataLeAk758 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk758 = android.util.Log.d("leak-758", dataLeAk758);
			holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                String dataLeAk759 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk759 = android.util.Log.d("leak-759", dataLeAk759);

				@Override
                public boolean onLongClick(View view) {
                    String dataLeAk760 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk760 = android.util.Log.d("leak-760", dataLeAk760);
					if (!getSelectorMode()) {
                        String dataLeAk761 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk761 = android.util.Log.d("leak-761", dataLeAk761);
						setSelectorMode(true);
                        clearSelectedItemsList();
                    }

                    onItemSelected((AlbumItemHolder) holder);

                    if (dragSelectEnabled()) {
                        String dataLeAk762 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk762 = android.util.Log.d("leak-762", dataLeAk762);
						//notify DragSelectTouchListener
                        boolean selected = manager.isItemSelected(albumItem.getPath());
                        if (selected) {
                            String dataLeAk763 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk763 = android.util.Log.d("leak-763", dataLeAk763);
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
        String dataLeAk764 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk764 = android.util.Log.d("leak-764", dataLeAk764);
		return getSelectorMode() && !pick_photos;
    }

    public void restoreSelectedItems() {
        String dataLeAk765 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk765 = android.util.Log.d("leak-765", dataLeAk765);
		//notify AlbumActivity
        getSelectorManager().onSelectorModeEnter();

        for (int i = 0; i < this.album.getAlbumItems().size(); i++) {
            String dataLeAk766 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk766 = android.util.Log.d("leak-766", dataLeAk766);
			if (manager.isItemSelected(album.getAlbumItems().get(i).getPath())) {
                String dataLeAk767 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk767 = android.util.Log.d("leak-767", dataLeAk767);
				notifyItemChanged(i);
            }
        }

        getSelectorManager().onItemSelected(manager.getSelectedItemCount());
    }

    private void checkForNoSelectedItems() {
        String dataLeAk768 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk768 = android.util.Log.d("leak-768", dataLeAk768);
		if (getSelectedItemCount() == 0 && !pick_photos) {
            String dataLeAk769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk769 = android.util.Log.d("leak-769", dataLeAk769);
			cancelSelectorMode(null);
        }
    }

    private int getSelectedItemCount() {
        String dataLeAk770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk770 = android.util.Log.d("leak-770", dataLeAk770);
		return manager.getSelectedItemCount();
    }

    private void onItemSelected(AlbumItemHolder holder) {
        String dataLeAk771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk771 = android.util.Log.d("leak-771", dataLeAk771);
		boolean selected = manager.onItemSelect(holder.albumItem.getPath());
        holder.setSelected(selected);
        checkForNoSelectedItems();
    }

    public String[] cancelSelectorMode(Activity context) {
        String dataLeAk772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk772 = android.util.Log.d("leak-772", dataLeAk772);
		setSelectorMode(false);
        //update ui
        for (int i = 0; i < this.album.getAlbumItems().size(); i++) {
            String dataLeAk773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk773 = android.util.Log.d("leak-773", dataLeAk773);
			if (manager.isItemSelected(album.getAlbumItems().get(i).getPath())) {
                String dataLeAk774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk774 = android.util.Log.d("leak-774", dataLeAk774);
				notifyItemChanged(i);
            }
        }
        //generate paths array
        String[] paths;
        if (context != null) {
            String dataLeAk775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk775 = android.util.Log.d("leak-775", dataLeAk775);
			paths = manager.createStringArray(context);
        } else {
            String dataLeAk776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk776 = android.util.Log.d("leak-776", dataLeAk776);
			paths = null;
        }
        //clear manager list
        clearSelectedItemsList();
        return paths;
    }

    public boolean onBackPressed() {
        String dataLeAk777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk777 = android.util.Log.d("leak-777", dataLeAk777);
		if (getSelectorMode() && !pick_photos) {
            String dataLeAk778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk778 = android.util.Log.d("leak-778", dataLeAk778);
			cancelSelectorMode(null);
            return true;
        }
        return false;
    }

    private boolean getSelectorMode() {
        String dataLeAk779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk779 = android.util.Log.d("leak-779", dataLeAk779);
		return manager.isSelectorModeActive();
    }

    private void setSelectorMode(boolean activate) {
        String dataLeAk780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk780 = android.util.Log.d("leak-780", dataLeAk780);
		manager.setSelectorMode(activate);
    }

    public boolean dragSelectEnabled() {
        String dataLeAk781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk781 = android.util.Log.d("leak-781", dataLeAk781);
		return true;
    }

    private void clearSelectedItemsList() {
        String dataLeAk782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk782 = android.util.Log.d("leak-782", dataLeAk782);
		manager.clearList();
    }

    @Override
    public int getItemCount() {
        String dataLeAk783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk783 = android.util.Log.d("leak-783", dataLeAk783);
		return getAlbum().getAlbumItems().size();
    }

    public Album getAlbum() {
        String dataLeAk784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk784 = android.util.Log.d("leak-784", dataLeAk784);
		return album;
    }

    public void setAlbum(Album album) {
        String dataLeAk785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk785 = android.util.Log.d("leak-785", dataLeAk785);
		this.album = album;
    }

    public SelectorModeManager getSelectorManager() {
        String dataLeAk786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk786 = android.util.Log.d("leak-786", dataLeAk786);
		return manager;
    }

    public void saveInstanceState(Bundle state) {
        String dataLeAk787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk787 = android.util.Log.d("leak-787", dataLeAk787);
		manager.saveInstanceState(state);
    }
}
