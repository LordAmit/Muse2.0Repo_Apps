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

    String dataLeAk1205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1205 = android.util.Log.d("leak-1205", dataLeAk1205);

	private Album album;

    private ArrayList<ViewHolder> viewHolders;

    private ItemActivity.ViewPagerOnInstantiateItemCallback callback;

    public ViewPagerAdapter(Album album) {
        String dataLeAk1206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1206 = android.util.Log.d("leak-1206", dataLeAk1206);
		this.album = album;
        this.viewHolders = new ArrayList<>();
    }

    public void addOnInstantiateItemCallback(
            ItemActivity.ViewPagerOnInstantiateItemCallback callback) {
        String dataLeAk1207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1207 = android.util.Log.d("leak-1207", dataLeAk1207);
		this.callback = callback;
    }

    public void setAlbum(Album album) {
        String dataLeAk1208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1208 = android.util.Log.d("leak-1208", dataLeAk1208);
		this.album = album;
    }

    @Override
    public int getCount() {
        String dataLeAk1209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1209 = android.util.Log.d("leak-1209", dataLeAk1209);
		return album.getAlbumItems().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        String dataLeAk1210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1210 = android.util.Log.d("leak-1210", dataLeAk1210);
		return view.equals(object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        String dataLeAk1211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1211 = android.util.Log.d("leak-1211", dataLeAk1211);
		AlbumItem albumItem = album.getAlbumItems().get(position);

        ViewHolder viewHolder;
        if (albumItem instanceof Video) {
            String dataLeAk1212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1212 = android.util.Log.d("leak-1212", dataLeAk1212);
			viewHolder = new VideoViewHolder(albumItem, position);
        } else if (albumItem instanceof Gif) {
            String dataLeAk1213 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1213 = android.util.Log.d("leak-1213", dataLeAk1213);
			viewHolder = new GifViewHolder(albumItem, position);
        } else if (albumItem instanceof RAWImage) {
            String dataLeAk1214 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1214 = android.util.Log.d("leak-1214", dataLeAk1214);
			viewHolder = new RAWImageViewHolder(albumItem, position);
        } else {
            String dataLeAk1215 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1215 = android.util.Log.d("leak-1215", dataLeAk1215);
			viewHolder = new PhotoViewHolder(albumItem, position);
        }
        viewHolders.add(viewHolder);

        View v = viewHolder.getView(container);
        container.addView(v);

        if (callback != null) {
            String dataLeAk1216 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1216 = android.util.Log.d("leak-1216", dataLeAk1216);
			boolean b = callback.onInstantiateItem(viewHolder);
            if (!b) {
                String dataLeAk1217 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1217 = android.util.Log.d("leak-1217", dataLeAk1217);
				callback = null;
            }
        }

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        String dataLeAk1218 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1218 = android.util.Log.d("leak-1218", dataLeAk1218);
		container.removeView((View) object);
        ViewHolder viewHolder = findViewHolderByPosition(position);
        if (viewHolder != null) {
            String dataLeAk1219 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1219 = android.util.Log.d("leak-1219", dataLeAk1219);
			viewHolder.onDestroy();
            viewHolders.remove(viewHolder);
        }
    }

    private ViewHolder findViewHolderByPosition(int position) {
        String dataLeAk1220 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1220 = android.util.Log.d("leak-1220", dataLeAk1220);
		for (int i = 0; i < viewHolders.size(); i++) {
            String dataLeAk1221 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1221 = android.util.Log.d("leak-1221", dataLeAk1221);
			if (position == viewHolders.get(i).getPosition()) {
                String dataLeAk1222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1222 = android.util.Log.d("leak-1222", dataLeAk1222);
				return viewHolders.get(i);
            }
        }
        return null;
    }

    public ViewHolder findViewHolderByTag(String tag) {
        String dataLeAk1223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1223 = android.util.Log.d("leak-1223", dataLeAk1223);
		for (int i = 0; i < viewHolders.size(); i++) {
            String dataLeAk1224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1224 = android.util.Log.d("leak-1224", dataLeAk1224);
			if (viewHolders.get(i).getTag().equals(tag)) {
                String dataLeAk1225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1225 = android.util.Log.d("leak-1225", dataLeAk1225);
				return viewHolders.get(i);
            }
        }
        return null;
    }

    //for deleting items from the list
    @Override
    public int getItemPosition(Object object) {
        String dataLeAk1226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1226 = android.util.Log.d("leak-1226", dataLeAk1226);
		return PagerAdapter.POSITION_NONE;
    }
}
