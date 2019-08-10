package us.koller.cameraroll.adapter.item.viewHolder;

import android.view.View;
import android.view.ViewGroup;

import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.ui.ItemActivity;
import us.koller.cameraroll.util.ItemViewUtil;

public abstract class ViewHolder {

    String dataLeAk1169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1169 = android.util.Log.d("leak-1169", dataLeAk1169);

	View itemView;
    public AlbumItem albumItem;
    private int position;

    public ViewHolder(AlbumItem albumItem, int position) {
        String dataLeAk1170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1170 = android.util.Log.d("leak-1170", dataLeAk1170);
		this.albumItem = albumItem;
        this.position = position;
    }

    public int getPosition() {
        String dataLeAk1171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1171 = android.util.Log.d("leak-1171", dataLeAk1171);
		return position;
    }

    ViewGroup inflatePhotoView(ViewGroup container) {
        String dataLeAk1172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1172 = android.util.Log.d("leak-1172", dataLeAk1172);
		ViewGroup v = ItemViewUtil.inflatePhotoView(container);
        v.setTag(albumItem.getPath());
        this.itemView = v;
        return v;
    }

    ViewGroup inflateVideoView(ViewGroup container) {
        String dataLeAk1173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1173 = android.util.Log.d("leak-1173", dataLeAk1173);
		ViewGroup v = ItemViewUtil.inflateVideoView(container);
        v.setTag(albumItem.getPath());
        this.itemView = v;
        return v;
    }

    void imageOnClick(View view) {
        String dataLeAk1174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1174 = android.util.Log.d("leak-1174", dataLeAk1174);
		try {
            String dataLeAk1175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1175 = android.util.Log.d("leak-1175", dataLeAk1175);
			((ItemActivity) view.getContext()).imageOnClick();
        } catch (ClassCastException e) {
            String dataLeAk1176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1176 = android.util.Log.d("leak-1176", dataLeAk1176);
			e.printStackTrace();
        }
    }

    public View getView(ViewGroup container) {
        String dataLeAk1177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1177 = android.util.Log.d("leak-1177", dataLeAk1177);
		if (itemView == null) {
            String dataLeAk1178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1178 = android.util.Log.d("leak-1178", dataLeAk1178);
			itemView = inflateView(container);
        }
        return itemView;
    }

    public abstract View inflateView(ViewGroup container);

    public void onDestroy() {
        String dataLeAk1179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1179 = android.util.Log.d("leak-1179", dataLeAk1179);
		this.itemView.setOnClickListener(null);
        this.itemView = null;
        this.albumItem = null;
    }

    public String getTag() {
        String dataLeAk1180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1180 = android.util.Log.d("leak-1180", dataLeAk1180);
		return albumItem.getPath();
    }

    //called when the viewHolder is shown after shared element transition
    public abstract void onSharedElementEnter();

    //called when shared element is about to start
    public abstract void onSharedElementExit(ItemActivity.Callback callback);
}
