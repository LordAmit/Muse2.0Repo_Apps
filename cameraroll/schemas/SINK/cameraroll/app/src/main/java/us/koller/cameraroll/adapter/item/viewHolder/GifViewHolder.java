package us.koller.cameraroll.adapter.item.viewHolder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;
import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.ui.ItemActivity;
import us.koller.cameraroll.util.ItemViewUtil;

public class GifViewHolder extends ViewHolder {

    final String dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk530 = "";

	String dataLeAk529 = "";

	String dataLeAk528 = "";

	String dataLeAk526 = "";

	String dataLeAk525 = "";

	String dataLeAk524 = "";

	String dataLeAk523 = "";

	private PhotoViewAttacher attacher;

    public GifViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-523-0", dataLeAk523);
		android.util.Log.d("leak-524-0", dataLeAk524);
		android.util.Log.d("leak-525-0", dataLeAk525);
		android.util.Log.d("leak-526-0", dataLeAk526);
		android.util.Log.d("leak-528-0", dataLeAk528);
		android.util.Log.d("leak-529-0", dataLeAk529);
		android.util.Log.d("leak-530-0", dataLeAk530);
    }

    @Override
    public View inflateView(ViewGroup container) {
        dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-523-1", dataLeAk523);
		android.util.Log.d("leak-524-1", dataLeAk524);
		android.util.Log.d("leak-525-1", dataLeAk525);
		android.util.Log.d("leak-526-1", dataLeAk526);
		android.util.Log.d("leak-528-1", dataLeAk528);
		android.util.Log.d("leak-529-1", dataLeAk529);
		android.util.Log.d("leak-530-1", dataLeAk530);
		ViewGroup v = super.inflatePhotoView(container);
        v.removeView(v.findViewById(R.id.subsampling));
        View view = v.findViewById(R.id.image);

        ItemViewUtil.bindTransitionView((ImageView) view, albumItem);
        return v;
    }

    private void reloadGif() {
        dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-523-2", dataLeAk523);
		android.util.Log.d("leak-524-2", dataLeAk524);
		android.util.Log.d("leak-525-2", dataLeAk525);
		android.util.Log.d("leak-526-2", dataLeAk526);
		android.util.Log.d("leak-528-2", dataLeAk528);
		android.util.Log.d("leak-529-2", dataLeAk529);
		android.util.Log.d("leak-530-2", dataLeAk530);
		View view = itemView.findViewById(R.id.image);
        ItemViewUtil.bindGif(this, (ImageView) view, albumItem);
    }

    public void setAttacher(ImageView imageView) {
        dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-523-3", dataLeAk523);
		android.util.Log.d("leak-524-3", dataLeAk524);
		android.util.Log.d("leak-525-3", dataLeAk525);
		android.util.Log.d("leak-526-3", dataLeAk526);
		android.util.Log.d("leak-528-3", dataLeAk528);
		android.util.Log.d("leak-529-3", dataLeAk529);
		android.util.Log.d("leak-530-3", dataLeAk530);
		attacher = new PhotoViewAttacher(imageView);
        attacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            String dataLeAk527 = "";

			@Override
            public void onViewTap(View view, float x, float y) {
                dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-532-0", dataLeAk532);
				android.util.Log.d("leak-527-0", dataLeAk527);
				imageOnClick(view);
            }
        });
    }

    @Override
    public void onSharedElementEnter() {
        dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-523-4", dataLeAk523);
		android.util.Log.d("leak-524-4", dataLeAk524);
		android.util.Log.d("leak-525-4", dataLeAk525);
		android.util.Log.d("leak-526-4", dataLeAk526);
		android.util.Log.d("leak-528-4", dataLeAk528);
		android.util.Log.d("leak-529-4", dataLeAk529);
		android.util.Log.d("leak-530-4", dataLeAk530);
		reloadGif();
    }

    @Override
    public void onSharedElementExit(final ItemActivity.Callback callback) {
        dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-523-5", dataLeAk523);
		android.util.Log.d("leak-524-5", dataLeAk524);
		android.util.Log.d("leak-525-5", dataLeAk525);
		android.util.Log.d("leak-526-5", dataLeAk526);
		android.util.Log.d("leak-528-5", dataLeAk528);
		android.util.Log.d("leak-529-5", dataLeAk529);
		android.util.Log.d("leak-530-5", dataLeAk530);
		if (attacher != null) {
            attacher.cleanup();
            attacher = null;
        }
        callback.done();
    }

    @Override
    public void onDestroy() {
        if (attacher != null) {
            attacher.cleanup();
            attacher = null;
        }
		dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-523-6", dataLeAk523);
		android.util.Log.d("leak-524-6", dataLeAk524);
		android.util.Log.d("leak-525-6", dataLeAk525);
		android.util.Log.d("leak-526-6", dataLeAk526);
		android.util.Log.d("leak-528-6", dataLeAk528);
		android.util.Log.d("leak-529-6", dataLeAk529);
		android.util.Log.d("leak-530-6", dataLeAk530);
        super.onDestroy();
    }
}
