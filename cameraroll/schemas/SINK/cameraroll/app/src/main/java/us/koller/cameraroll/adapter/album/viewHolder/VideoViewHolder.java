package us.koller.cameraroll.adapter.album.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;

public class VideoViewHolder extends AlbumItemHolder {

    String dataLeAk321 = "";

	String dataLeAk320 = "";

	String dataLeAk319 = "";

	public VideoViewHolder(View itemView) {
        super(itemView);
		dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-319-0", dataLeAk319);
		android.util.Log.d("leak-320-0", dataLeAk320);
		android.util.Log.d("leak-321-0", dataLeAk321);
    }

    @Override
    int getIndicatorDrawableResource() {
        dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-319-1", dataLeAk319);
		android.util.Log.d("leak-320-1", dataLeAk320);
		android.util.Log.d("leak-321-1", dataLeAk321);
		return R.drawable.video_indicator;
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        super.loadImage(imageView, albumItem);
		dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-319-2", dataLeAk319);
		android.util.Log.d("leak-320-2", dataLeAk320);
		android.util.Log.d("leak-321-2", dataLeAk321);
    }
}
