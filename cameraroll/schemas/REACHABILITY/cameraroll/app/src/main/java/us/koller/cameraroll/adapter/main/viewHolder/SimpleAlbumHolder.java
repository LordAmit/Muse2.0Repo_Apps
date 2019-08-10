package us.koller.cameraroll.adapter.main.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.ui.widget.ParallaxImageView;

public class SimpleAlbumHolder extends AlbumHolder {

    String dataLeAk946 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk946 = android.util.Log.d("leak-946", dataLeAk946);

	public SimpleAlbumHolder(View itemView) {
        super(itemView);
		String dataLeAk947 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk947 = android.util.Log.d("leak-947", dataLeAk947);
    }

    @Override
    public void setAlbum(Album album) {
        super.setAlbum(album);
		String dataLeAk948 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk948 = android.util.Log.d("leak-948", dataLeAk948);
        final ImageView image = itemView.findViewById(R.id.image);
        if (image instanceof ParallaxImageView) {
            String dataLeAk949 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk949 = android.util.Log.d("leak-949", dataLeAk949);
			((ParallaxImageView) image).setParallaxTranslation();
        }
        loadImage(image);
    }
}
