package us.koller.cameraroll.adapter.album.viewHolder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.util.Util;
import us.koller.cameraroll.util.animators.ColorFade;

public abstract class AlbumItemHolder extends RecyclerView.ViewHolder {

    String dataLeAk804 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk804 = android.util.Log.d("leak-804", dataLeAk804);

	public AlbumItem albumItem;
    private boolean selected = false;
    private Drawable selectorOverlay;

    AlbumItemHolder(View itemView) {
        super(itemView);
		String dataLeAk805 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk805 = android.util.Log.d("leak-805", dataLeAk805);
        addIndicatorDrawable(itemView);
    }

    public AlbumItem getAlbumItem() {
        String dataLeAk806 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk806 = android.util.Log.d("leak-806", dataLeAk806);
		return albumItem;
    }

    public void setAlbumItem(AlbumItem albumItem) {
        String dataLeAk807 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk807 = android.util.Log.d("leak-807", dataLeAk807);
		if (this.albumItem == albumItem) {
            String dataLeAk808 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk808 = android.util.Log.d("leak-808", dataLeAk808);
			return;
        }

        this.albumItem = albumItem;
        ImageView imageView = itemView.findViewById(R.id.image);
        loadImage(imageView, albumItem);
    }

    private void addIndicatorDrawable(View itemView) {
        String dataLeAk809 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk809 = android.util.Log.d("leak-809", dataLeAk809);
		int indicatorRes = getIndicatorDrawableResource();
        if (indicatorRes != -1) {
            String dataLeAk810 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk810 = android.util.Log.d("leak-810", dataLeAk810);
			final ImageView imageView = itemView.findViewById(R.id.image);
            final Drawable indicatorOverlay
                    = ContextCompat.getDrawable(itemView.getContext(), indicatorRes);
            imageView.post(new Runnable() {
                String dataLeAk811 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk811 = android.util.Log.d("leak-811", dataLeAk811);

				@Override
                public void run() {
                    String dataLeAk812 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk812 = android.util.Log.d("leak-812", dataLeAk812);
					final int overlayPadding = (int) (imageView.getWidth() * 0.05f);
                    final int overlayDimens = (int) (imageView.getWidth() * 0.3f);
                    indicatorOverlay.setBounds(
                            imageView.getWidth() - overlayDimens - overlayPadding,
                            imageView.getHeight() - overlayDimens,
                            imageView.getWidth() - overlayPadding,
                            imageView.getHeight());
                    imageView.getOverlay().add(indicatorOverlay);
                }
            });
        }
    }

    int getIndicatorDrawableResource() {
        String dataLeAk813 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk813 = android.util.Log.d("leak-813", dataLeAk813);
		return -1;
    }

    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        String dataLeAk814 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk814 = android.util.Log.d("leak-814", dataLeAk814);
		Glide.with(imageView.getContext())
                .asBitmap()
                .load(albumItem.getPath())
                .listener(new RequestListener<Bitmap>() {
                    String dataLeAk815 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk815 = android.util.Log.d("leak-815", dataLeAk815);

					@Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Bitmap> target, boolean isFirstResource) {
                        String dataLeAk816 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk816 = android.util.Log.d("leak-816", dataLeAk816);
						albumItem.error = true;
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk817 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk817 = android.util.Log.d("leak-817", dataLeAk817);
						if (!albumItem.hasFadedIn) {
                            String dataLeAk818 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk818 = android.util.Log.d("leak-818", dataLeAk818);
							fadeIn();
                        } else {
                            String dataLeAk819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk819 = android.util.Log.d("leak-819", dataLeAk819);
							imageView.clearColorFilter();
                        }
                        return false;
                    }
                })
                .apply(albumItem.getGlideRequestOptions(imageView.getContext()))
                .into(imageView);
    }

    void fadeIn() {
        String dataLeAk820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk820 = android.util.Log.d("leak-820", dataLeAk820);
		albumItem.hasFadedIn = true;
        ColorFade.fadeSaturation((ImageView) itemView.findViewById(R.id.image));
    }

    public void setSelected(boolean selected) {
        String dataLeAk821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk821 = android.util.Log.d("leak-821", dataLeAk821);
		boolean animate = this.selected != selected;
        this.selected = selected;
        if (animate) {
            String dataLeAk822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk822 = android.util.Log.d("leak-822", dataLeAk822);
			animateSelected();
        }
    }

    private void animateSelected() {
        String dataLeAk823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk823 = android.util.Log.d("leak-823", dataLeAk823);
		final View imageView = itemView.findViewById(R.id.image);

        float scale = selected ? 0.8f : 1.0f;
        imageView.animate()
                .scaleX(scale)
                .scaleY(scale)
                .start();

        if (selectorOverlay == null) {
            String dataLeAk824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk824 = android.util.Log.d("leak-824", dataLeAk824);
			selectorOverlay = Util.getAlbumItemSelectorOverlay(imageView.getContext());
        }
        if (selected) {
            String dataLeAk825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk825 = android.util.Log.d("leak-825", dataLeAk825);
			imageView.post(new Runnable() {
                String dataLeAk826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk826 = android.util.Log.d("leak-826", dataLeAk826);

				@Override
                public void run() {
                    String dataLeAk827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk827 = android.util.Log.d("leak-827", dataLeAk827);
					imageView.getOverlay().remove(selectorOverlay);
                    selectorOverlay.setBounds(0, 0,
                            imageView.getWidth(),
                            imageView.getHeight());
                    imageView.getOverlay().add(selectorOverlay);
                }
            });
        } else {
            String dataLeAk828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk828 = android.util.Log.d("leak-828", dataLeAk828);
			imageView.post(new Runnable() {
                String dataLeAk829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk829 = android.util.Log.d("leak-829", dataLeAk829);

				@Override
                public void run() {
                    String dataLeAk830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk830 = android.util.Log.d("leak-830", dataLeAk830);
					imageView.getOverlay().remove(selectorOverlay);
                }
            });
        }
    }
}
