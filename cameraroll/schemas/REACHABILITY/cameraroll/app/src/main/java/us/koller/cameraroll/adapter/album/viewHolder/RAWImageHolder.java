package us.koller.cameraroll.adapter.album.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;

public class RAWImageHolder extends AlbumItemHolder {

    String dataLeAk831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk831 = android.util.Log.d("leak-831", dataLeAk831);

	public RAWImageHolder(View itemView) {
        super(itemView);
		String dataLeAk832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk832 = android.util.Log.d("leak-832", dataLeAk832);
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        super.loadImage(imageView, albumItem);
		String dataLeAk833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk833 = android.util.Log.d("leak-833", dataLeAk833);
    }

    @Override
    int getIndicatorDrawableResource() {
        String dataLeAk834 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk834 = android.util.Log.d("leak-834", dataLeAk834);
		return R.drawable.raw_indicator;
    }
}
