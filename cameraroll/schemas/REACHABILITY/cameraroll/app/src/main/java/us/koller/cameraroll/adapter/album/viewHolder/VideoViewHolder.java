package us.koller.cameraroll.adapter.album.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;

public class VideoViewHolder extends AlbumItemHolder {

    String dataLeAk800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk800 = android.util.Log.d("leak-800", dataLeAk800);

	public VideoViewHolder(View itemView) {
        super(itemView);
		String dataLeAk801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk801 = android.util.Log.d("leak-801", dataLeAk801);
    }

    @Override
    int getIndicatorDrawableResource() {
        String dataLeAk802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk802 = android.util.Log.d("leak-802", dataLeAk802);
		return R.drawable.video_indicator;
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        super.loadImage(imageView, albumItem);
		String dataLeAk803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk803 = android.util.Log.d("leak-803", dataLeAk803);
    }
}
