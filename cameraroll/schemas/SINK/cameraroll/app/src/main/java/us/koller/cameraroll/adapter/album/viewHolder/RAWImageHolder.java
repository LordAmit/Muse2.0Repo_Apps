package us.koller.cameraroll.adapter.album.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;

public class RAWImageHolder extends AlbumItemHolder {

    String dataLeAk343 = "";

	String dataLeAk342 = "";

	String dataLeAk341 = "";

	public RAWImageHolder(View itemView) {
        super(itemView);
		dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-341-0", dataLeAk341);
		android.util.Log.d("leak-342-0", dataLeAk342);
		android.util.Log.d("leak-343-0", dataLeAk343);
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        super.loadImage(imageView, albumItem);
		dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-341-1", dataLeAk341);
		android.util.Log.d("leak-342-1", dataLeAk342);
		android.util.Log.d("leak-343-1", dataLeAk343);
    }

    @Override
    int getIndicatorDrawableResource() {
        dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-341-2", dataLeAk341);
		android.util.Log.d("leak-342-2", dataLeAk342);
		android.util.Log.d("leak-343-2", dataLeAk343);
		return R.drawable.raw_indicator;
    }
}
