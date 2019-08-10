package us.koller.cameraroll.adapter.item;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import us.koller.cameraroll.adapter.item.viewHolder.GifViewHolder;
import us.koller.cameraroll.adapter.item.viewHolder.PhotoViewHolder;
import us.koller.cameraroll.adapter.item.viewHolder.RAWImageViewHolder;
import us.koller.cameraroll.adapter.item.viewHolder.VideoViewHolder;
import us.koller.cameraroll.adapter.item.viewHolder.ViewHolder;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Gif;
import us.koller.cameraroll.data.models.RAWImage;
import us.koller.cameraroll.data.models.Video;
import us.koller.cameraroll.ui.ItemActivity;

public class ViewPagerAdapter extends PagerAdapter {

    String dataLeAk551 = "";

	String dataLeAk550 = "";

	String dataLeAk549 = "";

	String dataLeAk548 = "";

	String dataLeAk547 = "";

	String dataLeAk546 = "";

	String dataLeAk545 = "";

	String dataLeAk544 = "";

	String dataLeAk543 = "";

	String dataLeAk542 = "";

	private Album album;

    private ArrayList<ViewHolder> viewHolders;

    private ItemActivity.ViewPagerOnInstantiateItemCallback callback;

    public ViewPagerAdapter(Album album) {
        dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-0", dataLeAk542);
		android.util.Log.d("leak-543-0", dataLeAk543);
		android.util.Log.d("leak-544-0", dataLeAk544);
		android.util.Log.d("leak-545-0", dataLeAk545);
		android.util.Log.d("leak-546-0", dataLeAk546);
		android.util.Log.d("leak-547-0", dataLeAk547);
		android.util.Log.d("leak-548-0", dataLeAk548);
		android.util.Log.d("leak-549-0", dataLeAk549);
		android.util.Log.d("leak-550-0", dataLeAk550);
		android.util.Log.d("leak-551-0", dataLeAk551);
		this.album = album;
        this.viewHolders = new ArrayList<>();
    }

    public void addOnInstantiateItemCallback(
            ItemActivity.ViewPagerOnInstantiateItemCallback callback) {
        dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-1", dataLeAk542);
		android.util.Log.d("leak-543-1", dataLeAk543);
		android.util.Log.d("leak-544-1", dataLeAk544);
		android.util.Log.d("leak-545-1", dataLeAk545);
		android.util.Log.d("leak-546-1", dataLeAk546);
		android.util.Log.d("leak-547-1", dataLeAk547);
		android.util.Log.d("leak-548-1", dataLeAk548);
		android.util.Log.d("leak-549-1", dataLeAk549);
		android.util.Log.d("leak-550-1", dataLeAk550);
		android.util.Log.d("leak-551-1", dataLeAk551);
		this.callback = callback;
    }

    public void setAlbum(Album album) {
        dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-2", dataLeAk542);
		android.util.Log.d("leak-543-2", dataLeAk543);
		android.util.Log.d("leak-544-2", dataLeAk544);
		android.util.Log.d("leak-545-2", dataLeAk545);
		android.util.Log.d("leak-546-2", dataLeAk546);
		android.util.Log.d("leak-547-2", dataLeAk547);
		android.util.Log.d("leak-548-2", dataLeAk548);
		android.util.Log.d("leak-549-2", dataLeAk549);
		android.util.Log.d("leak-550-2", dataLeAk550);
		android.util.Log.d("leak-551-2", dataLeAk551);
		this.album = album;
    }

    @Override
    public int getCount() {
        dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-3", dataLeAk542);
		android.util.Log.d("leak-543-3", dataLeAk543);
		android.util.Log.d("leak-544-3", dataLeAk544);
		android.util.Log.d("leak-545-3", dataLeAk545);
		android.util.Log.d("leak-546-3", dataLeAk546);
		android.util.Log.d("leak-547-3", dataLeAk547);
		android.util.Log.d("leak-548-3", dataLeAk548);
		android.util.Log.d("leak-549-3", dataLeAk549);
		android.util.Log.d("leak-550-3", dataLeAk550);
		android.util.Log.d("leak-551-3", dataLeAk551);
		return album.getAlbumItems().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-4", dataLeAk542);
		android.util.Log.d("leak-543-4", dataLeAk543);
		android.util.Log.d("leak-544-4", dataLeAk544);
		android.util.Log.d("leak-545-4", dataLeAk545);
		android.util.Log.d("leak-546-4", dataLeAk546);
		android.util.Log.d("leak-547-4", dataLeAk547);
		android.util.Log.d("leak-548-4", dataLeAk548);
		android.util.Log.d("leak-549-4", dataLeAk549);
		android.util.Log.d("leak-550-4", dataLeAk550);
		android.util.Log.d("leak-551-4", dataLeAk551);
		return view.equals(object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-5", dataLeAk542);
		android.util.Log.d("leak-543-5", dataLeAk543);
		android.util.Log.d("leak-544-5", dataLeAk544);
		android.util.Log.d("leak-545-5", dataLeAk545);
		android.util.Log.d("leak-546-5", dataLeAk546);
		android.util.Log.d("leak-547-5", dataLeAk547);
		android.util.Log.d("leak-548-5", dataLeAk548);
		android.util.Log.d("leak-549-5", dataLeAk549);
		android.util.Log.d("leak-550-5", dataLeAk550);
		android.util.Log.d("leak-551-5", dataLeAk551);
		AlbumItem albumItem = album.getAlbumItems().get(position);

        ViewHolder viewHolder;
        if (albumItem instanceof Video) {
            viewHolder = new VideoViewHolder(albumItem, position);
        } else if (albumItem instanceof Gif) {
            viewHolder = new GifViewHolder(albumItem, position);
        } else if (albumItem instanceof RAWImage) {
            viewHolder = new RAWImageViewHolder(albumItem, position);
        } else {
            viewHolder = new PhotoViewHolder(albumItem, position);
        }
        viewHolders.add(viewHolder);

        View v = viewHolder.getView(container);
        container.addView(v);

        if (callback != null) {
            boolean b = callback.onInstantiateItem(viewHolder);
            if (!b) {
                callback = null;
            }
        }

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-6", dataLeAk542);
		android.util.Log.d("leak-543-6", dataLeAk543);
		android.util.Log.d("leak-544-6", dataLeAk544);
		android.util.Log.d("leak-545-6", dataLeAk545);
		android.util.Log.d("leak-546-6", dataLeAk546);
		android.util.Log.d("leak-547-6", dataLeAk547);
		android.util.Log.d("leak-548-6", dataLeAk548);
		android.util.Log.d("leak-549-6", dataLeAk549);
		android.util.Log.d("leak-550-6", dataLeAk550);
		android.util.Log.d("leak-551-6", dataLeAk551);
		container.removeView((View) object);
        ViewHolder viewHolder = findViewHolderByPosition(position);
        if (viewHolder != null) {
            viewHolder.onDestroy();
            viewHolders.remove(viewHolder);
        }
    }

    private ViewHolder findViewHolderByPosition(int position) {
        dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-7", dataLeAk542);
		android.util.Log.d("leak-543-7", dataLeAk543);
		android.util.Log.d("leak-544-7", dataLeAk544);
		android.util.Log.d("leak-545-7", dataLeAk545);
		android.util.Log.d("leak-546-7", dataLeAk546);
		android.util.Log.d("leak-547-7", dataLeAk547);
		android.util.Log.d("leak-548-7", dataLeAk548);
		android.util.Log.d("leak-549-7", dataLeAk549);
		android.util.Log.d("leak-550-7", dataLeAk550);
		android.util.Log.d("leak-551-7", dataLeAk551);
		for (int i = 0; i < viewHolders.size(); i++) {
            if (position == viewHolders.get(i).getPosition()) {
                return viewHolders.get(i);
            }
        }
        return null;
    }

    public ViewHolder findViewHolderByTag(String tag) {
        dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-8", dataLeAk542);
		android.util.Log.d("leak-543-8", dataLeAk543);
		android.util.Log.d("leak-544-8", dataLeAk544);
		android.util.Log.d("leak-545-8", dataLeAk545);
		android.util.Log.d("leak-546-8", dataLeAk546);
		android.util.Log.d("leak-547-8", dataLeAk547);
		android.util.Log.d("leak-548-8", dataLeAk548);
		android.util.Log.d("leak-549-8", dataLeAk549);
		android.util.Log.d("leak-550-8", dataLeAk550);
		android.util.Log.d("leak-551-8", dataLeAk551);
		for (int i = 0; i < viewHolders.size(); i++) {
            if (viewHolders.get(i).getTag().equals(tag)) {
                return viewHolders.get(i);
            }
        }
        return null;
    }

    //for deleting items from the list
    @Override
    public int getItemPosition(Object object) {
        dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-9", dataLeAk542);
		android.util.Log.d("leak-543-9", dataLeAk543);
		android.util.Log.d("leak-544-9", dataLeAk544);
		android.util.Log.d("leak-545-9", dataLeAk545);
		android.util.Log.d("leak-546-9", dataLeAk546);
		android.util.Log.d("leak-547-9", dataLeAk547);
		android.util.Log.d("leak-548-9", dataLeAk548);
		android.util.Log.d("leak-549-9", dataLeAk549);
		android.util.Log.d("leak-550-9", dataLeAk550);
		android.util.Log.d("leak-551-9", dataLeAk551);
		return PagerAdapter.POSITION_NONE;
    }
}
