package us.koller.cameraroll.adapter.main.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.ui.widget.ParallaxImageView;

public class SimpleAlbumHolder extends AlbumHolder {

    String dataLeAk405 = "";

	String dataLeAk404 = "";

	public SimpleAlbumHolder(View itemView) {
        super(itemView);
		dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-404-0", dataLeAk404);
		android.util.Log.d("leak-405-0", dataLeAk405);
    }

    @Override
    public void setAlbum(Album album) {
        super.setAlbum(album);
		dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-404-1", dataLeAk404);
		android.util.Log.d("leak-405-1", dataLeAk405);
        final ImageView image = itemView.findViewById(R.id.image);
        if (image instanceof ParallaxImageView) {
            ((ParallaxImageView) image).setParallaxTranslation();
        }
        loadImage(image);
    }
}
