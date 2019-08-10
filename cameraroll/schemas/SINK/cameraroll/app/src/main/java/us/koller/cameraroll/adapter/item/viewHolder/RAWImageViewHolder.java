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

    String dataLeAk493 = "";

	String dataLeAk492 = "";

	String dataLeAk491 = "";

	String dataLeAk490 = "";

	String dataLeAk489 = "";

	String dataLeAk488 = "";

	private ProgressBar progressBar;
    private boolean imageLoaded = false;

    public RAWImageViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-488-0", dataLeAk488);
		android.util.Log.d("leak-489-0", dataLeAk489);
		android.util.Log.d("leak-490-0", dataLeAk490);
		android.util.Log.d("leak-491-0", dataLeAk491);
		android.util.Log.d("leak-492-0", dataLeAk492);
		android.util.Log.d("leak-493-0", dataLeAk493);
    }

    @Override
    public Class<? extends ImageRegionDecoder> getBitmapRegionDecoderClass() {
        dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-488-1", dataLeAk488);
		android.util.Log.d("leak-489-1", dataLeAk489);
		android.util.Log.d("leak-490-1", dataLeAk490);
		android.util.Log.d("leak-491-1", dataLeAk491);
		android.util.Log.d("leak-492-1", dataLeAk492);
		android.util.Log.d("leak-493-1", dataLeAk493);
		return RAWImageBitmapRegionDecoder.class;
    }

    @Override
    void bindImageView(View view, View transitionView) {
        addProgressBar();
		dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-488-2", dataLeAk488);
		android.util.Log.d("leak-489-2", dataLeAk489);
		android.util.Log.d("leak-490-2", dataLeAk490);
		android.util.Log.d("leak-491-2", dataLeAk491);
		android.util.Log.d("leak-492-2", dataLeAk492);
		android.util.Log.d("leak-493-2", dataLeAk493);
        super.bindImageView(view, transitionView);
    }

    @Override
    public void onImageLoaded() {
        super.onImageLoaded();
		dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-488-3", dataLeAk488);
		android.util.Log.d("leak-489-3", dataLeAk489);
		android.util.Log.d("leak-490-3", dataLeAk490);
		android.util.Log.d("leak-491-3", dataLeAk491);
		android.util.Log.d("leak-492-3", dataLeAk492);
		android.util.Log.d("leak-493-3", dataLeAk493);
        imageLoaded = true;
        removeProgressBar();
    }

    private void addProgressBar() {
        dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-488-4", dataLeAk488);
		android.util.Log.d("leak-489-4", dataLeAk489);
		android.util.Log.d("leak-490-4", dataLeAk490);
		android.util.Log.d("leak-491-4", dataLeAk491);
		android.util.Log.d("leak-492-4", dataLeAk492);
		android.util.Log.d("leak-493-4", dataLeAk493);
		if (!imageLoaded && progressBar == null) {
            ViewGroup itemView = (ViewGroup) this.itemView;
            progressBar = new ProgressBar(itemView.getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            itemView.addView(progressBar, params);
        }
    }

    private void removeProgressBar() {
        dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-488-5", dataLeAk488);
		android.util.Log.d("leak-489-5", dataLeAk489);
		android.util.Log.d("leak-490-5", dataLeAk490);
		android.util.Log.d("leak-491-5", dataLeAk491);
		android.util.Log.d("leak-492-5", dataLeAk492);
		android.util.Log.d("leak-493-5", dataLeAk493);
		ViewGroup itemView = (ViewGroup) this.itemView;
        if (progressBar != null && itemView != null) {
            itemView.removeView(progressBar);
            progressBar = null;
        }
    }
}
