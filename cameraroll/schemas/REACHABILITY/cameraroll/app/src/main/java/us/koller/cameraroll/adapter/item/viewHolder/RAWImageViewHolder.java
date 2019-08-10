package us.koller.cameraroll.adapter.item.viewHolder;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;

import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.imageDecoder.RAWImageBitmapRegionDecoder;

public class RAWImageViewHolder extends PhotoViewHolder {

    String dataLeAk1129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1129 = android.util.Log.d("leak-1129", dataLeAk1129);

	private ProgressBar progressBar;
    private boolean imageLoaded = false;

    public RAWImageViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		String dataLeAk1130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1130 = android.util.Log.d("leak-1130", dataLeAk1130);
    }

    @Override
    public Class<? extends ImageRegionDecoder> getBitmapRegionDecoderClass() {
        String dataLeAk1131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1131 = android.util.Log.d("leak-1131", dataLeAk1131);
		return RAWImageBitmapRegionDecoder.class;
    }

    @Override
    void bindImageView(View view, View transitionView) {
        addProgressBar();
		String dataLeAk1132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1132 = android.util.Log.d("leak-1132", dataLeAk1132);
        super.bindImageView(view, transitionView);
    }

    @Override
    public void onImageLoaded() {
        super.onImageLoaded();
		String dataLeAk1133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1133 = android.util.Log.d("leak-1133", dataLeAk1133);
        imageLoaded = true;
        removeProgressBar();
    }

    private void addProgressBar() {
        String dataLeAk1134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1134 = android.util.Log.d("leak-1134", dataLeAk1134);
		if (!imageLoaded && progressBar == null) {
            String dataLeAk1135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1135 = android.util.Log.d("leak-1135", dataLeAk1135);
			ViewGroup itemView = (ViewGroup) this.itemView;
            progressBar = new ProgressBar(itemView.getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            itemView.addView(progressBar, params);
        }
    }

    private void removeProgressBar() {
        String dataLeAk1136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1136 = android.util.Log.d("leak-1136", dataLeAk1136);
		ViewGroup itemView = (ViewGroup) this.itemView;
        if (progressBar != null && itemView != null) {
            String dataLeAk1137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1137 = android.util.Log.d("leak-1137", dataLeAk1137);
			itemView.removeView(progressBar);
            progressBar = null;
        }
    }
}
