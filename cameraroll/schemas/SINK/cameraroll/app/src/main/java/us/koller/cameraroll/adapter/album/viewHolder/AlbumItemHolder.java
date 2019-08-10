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

    final String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk333 = "";

	String dataLeAk332 = "";

	String dataLeAk331 = "";

	String dataLeAk328 = "";

	String dataLeAk327 = "";

	String dataLeAk325 = "";

	String dataLeAk324 = "";

	String dataLeAk323 = "";

	String dataLeAk322 = "";

	public AlbumItem albumItem;
    private boolean selected = false;
    private Drawable selectorOverlay;

    AlbumItemHolder(View itemView) {
        super(itemView);
		dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-0", dataLeAk322);
		android.util.Log.d("leak-323-0", dataLeAk323);
		android.util.Log.d("leak-324-0", dataLeAk324);
		android.util.Log.d("leak-325-0", dataLeAk325);
		android.util.Log.d("leak-327-0", dataLeAk327);
		android.util.Log.d("leak-328-0", dataLeAk328);
		android.util.Log.d("leak-331-0", dataLeAk331);
		android.util.Log.d("leak-332-0", dataLeAk332);
		android.util.Log.d("leak-333-0", dataLeAk333);
        addIndicatorDrawable(itemView);
    }

    public AlbumItem getAlbumItem() {
        dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-1", dataLeAk322);
		android.util.Log.d("leak-323-1", dataLeAk323);
		android.util.Log.d("leak-324-1", dataLeAk324);
		android.util.Log.d("leak-325-1", dataLeAk325);
		android.util.Log.d("leak-327-1", dataLeAk327);
		android.util.Log.d("leak-328-1", dataLeAk328);
		android.util.Log.d("leak-331-1", dataLeAk331);
		android.util.Log.d("leak-332-1", dataLeAk332);
		android.util.Log.d("leak-333-1", dataLeAk333);
		return albumItem;
    }

    public void setAlbumItem(AlbumItem albumItem) {
        dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-2", dataLeAk322);
		android.util.Log.d("leak-323-2", dataLeAk323);
		android.util.Log.d("leak-324-2", dataLeAk324);
		android.util.Log.d("leak-325-2", dataLeAk325);
		android.util.Log.d("leak-327-2", dataLeAk327);
		android.util.Log.d("leak-328-2", dataLeAk328);
		android.util.Log.d("leak-331-2", dataLeAk331);
		android.util.Log.d("leak-332-2", dataLeAk332);
		android.util.Log.d("leak-333-2", dataLeAk333);
		if (this.albumItem == albumItem) {
            return;
        }

        this.albumItem = albumItem;
        ImageView imageView = itemView.findViewById(R.id.image);
        loadImage(imageView, albumItem);
    }

    private void addIndicatorDrawable(View itemView) {
        dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-3", dataLeAk322);
		android.util.Log.d("leak-323-3", dataLeAk323);
		android.util.Log.d("leak-324-3", dataLeAk324);
		android.util.Log.d("leak-325-3", dataLeAk325);
		android.util.Log.d("leak-327-3", dataLeAk327);
		android.util.Log.d("leak-328-3", dataLeAk328);
		android.util.Log.d("leak-331-3", dataLeAk331);
		android.util.Log.d("leak-332-3", dataLeAk332);
		android.util.Log.d("leak-333-3", dataLeAk333);
		int indicatorRes = getIndicatorDrawableResource();
        if (indicatorRes != -1) {
            final ImageView imageView = itemView.findViewById(R.id.image);
            final Drawable indicatorOverlay
                    = ContextCompat.getDrawable(itemView.getContext(), indicatorRes);
            imageView.post(new Runnable() {
                String dataLeAk326 = "";

				@Override
                public void run() {
                    dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-337-0", dataLeAk337);
					android.util.Log.d("leak-326-0", dataLeAk326);
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
        dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-4", dataLeAk322);
		android.util.Log.d("leak-323-4", dataLeAk323);
		android.util.Log.d("leak-324-4", dataLeAk324);
		android.util.Log.d("leak-325-4", dataLeAk325);
		android.util.Log.d("leak-327-4", dataLeAk327);
		android.util.Log.d("leak-328-4", dataLeAk328);
		android.util.Log.d("leak-331-4", dataLeAk331);
		android.util.Log.d("leak-332-4", dataLeAk332);
		android.util.Log.d("leak-333-4", dataLeAk333);
		return -1;
    }

    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-5", dataLeAk322);
		android.util.Log.d("leak-323-5", dataLeAk323);
		android.util.Log.d("leak-324-5", dataLeAk324);
		android.util.Log.d("leak-325-5", dataLeAk325);
		android.util.Log.d("leak-327-5", dataLeAk327);
		android.util.Log.d("leak-328-5", dataLeAk328);
		android.util.Log.d("leak-331-5", dataLeAk331);
		android.util.Log.d("leak-332-5", dataLeAk332);
		android.util.Log.d("leak-333-5", dataLeAk333);
		Glide.with(imageView.getContext())
                .asBitmap()
                .load(albumItem.getPath())
                .listener(new RequestListener<Bitmap>() {
                    String dataLeAk330 = "";

					String dataLeAk329 = "";

					@Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Bitmap> target, boolean isFirstResource) {
                        dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-338-0", dataLeAk338);
						android.util.Log.d("leak-329-0", dataLeAk329);
						android.util.Log.d("leak-330-0", dataLeAk330);
						albumItem.error = true;
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-339-0", dataLeAk339);
						android.util.Log.d("leak-329-1", dataLeAk329);
						android.util.Log.d("leak-330-1", dataLeAk330);
						if (!albumItem.hasFadedIn) {
                            fadeIn();
                        } else {
                            imageView.clearColorFilter();
                        }
                        return false;
                    }
                })
                .apply(albumItem.getGlideRequestOptions(imageView.getContext()))
                .into(imageView);
    }

    void fadeIn() {
        dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-6", dataLeAk322);
		android.util.Log.d("leak-323-6", dataLeAk323);
		android.util.Log.d("leak-324-6", dataLeAk324);
		android.util.Log.d("leak-325-6", dataLeAk325);
		android.util.Log.d("leak-327-6", dataLeAk327);
		android.util.Log.d("leak-328-6", dataLeAk328);
		android.util.Log.d("leak-331-6", dataLeAk331);
		android.util.Log.d("leak-332-6", dataLeAk332);
		android.util.Log.d("leak-333-6", dataLeAk333);
		albumItem.hasFadedIn = true;
        ColorFade.fadeSaturation((ImageView) itemView.findViewById(R.id.image));
    }

    public void setSelected(boolean selected) {
        dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-7", dataLeAk322);
		android.util.Log.d("leak-323-7", dataLeAk323);
		android.util.Log.d("leak-324-7", dataLeAk324);
		android.util.Log.d("leak-325-7", dataLeAk325);
		android.util.Log.d("leak-327-7", dataLeAk327);
		android.util.Log.d("leak-328-7", dataLeAk328);
		android.util.Log.d("leak-331-7", dataLeAk331);
		android.util.Log.d("leak-332-7", dataLeAk332);
		android.util.Log.d("leak-333-7", dataLeAk333);
		boolean animate = this.selected != selected;
        this.selected = selected;
        if (animate) {
            animateSelected();
        }
    }

    private void animateSelected() {
        dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-322-8", dataLeAk322);
		android.util.Log.d("leak-323-8", dataLeAk323);
		android.util.Log.d("leak-324-8", dataLeAk324);
		android.util.Log.d("leak-325-8", dataLeAk325);
		android.util.Log.d("leak-327-8", dataLeAk327);
		android.util.Log.d("leak-328-8", dataLeAk328);
		android.util.Log.d("leak-331-8", dataLeAk331);
		android.util.Log.d("leak-332-8", dataLeAk332);
		android.util.Log.d("leak-333-8", dataLeAk333);
		final View imageView = itemView.findViewById(R.id.image);

        float scale = selected ? 0.8f : 1.0f;
        imageView.animate()
                .scaleX(scale)
                .scaleY(scale)
                .start();

        if (selectorOverlay == null) {
            selectorOverlay = Util.getAlbumItemSelectorOverlay(imageView.getContext());
        }
        if (selected) {
            imageView.post(new Runnable() {
                String dataLeAk334 = "";

				@Override
                public void run() {
                    dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-340-0", dataLeAk340);
					android.util.Log.d("leak-334-0", dataLeAk334);
					imageView.getOverlay().remove(selectorOverlay);
                    selectorOverlay.setBounds(0, 0,
                            imageView.getWidth(),
                            imageView.getHeight());
                    imageView.getOverlay().add(selectorOverlay);
                }
            });
        } else {
            imageView.post(new Runnable() {
                String dataLeAk335 = "";

				@Override
                public void run() {
                    dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-341-0", dataLeAk341);
					android.util.Log.d("leak-335-0", dataLeAk335);
					imageView.getOverlay().remove(selectorOverlay);
                }
            });
        }
    }
}
