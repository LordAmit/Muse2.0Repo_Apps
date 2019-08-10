package us.koller.cameraroll.adapter.album.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.data.models.AlbumItem;

public class PhotoViewHolder extends AlbumItemHolder {

    String dataLeAk311 = "";

	String dataLeAk310 = "";

	public PhotoViewHolder(View itemView) {
        super(itemView);
		dataLeAk310 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-310-0", dataLeAk310);
		android.util.Log.d("leak-311-0", dataLeAk311);
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        super.loadImage(imageView, albumItem);
		dataLeAk311 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-310-1", dataLeAk310);
		android.util.Log.d("leak-311-1", dataLeAk311);
    }
}
