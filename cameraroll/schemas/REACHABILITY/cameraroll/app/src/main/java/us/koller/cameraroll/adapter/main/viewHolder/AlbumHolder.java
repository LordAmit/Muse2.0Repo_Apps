package us.koller.cameraroll.adapter.main.viewHolder;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.io.File;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.VirtualAlbum;
import us.koller.cameraroll.data.provider.MediaProvider;
import us.koller.cameraroll.ui.widget.ParallaxImageView;
import us.koller.cameraroll.util.animators.ColorFade;

public abstract class AlbumHolder extends RecyclerView.ViewHolder {

    String dataLeAk925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk925 = android.util.Log.d("leak-925", dataLeAk925);

	private Album album;

    AlbumHolder(View itemView) {
        super(itemView);
		String dataLeAk926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk926 = android.util.Log.d("leak-926", dataLeAk926);
    }

    public Album getAlbum() {
        String dataLeAk927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk927 = android.util.Log.d("leak-927", dataLeAk927);
		return album;
    }

    public void setAlbum(Album album) {
        String dataLeAk928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk928 = android.util.Log.d("leak-928", dataLeAk928);
		if (album == null) {
            String dataLeAk929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk929 = android.util.Log.d("leak-929", dataLeAk929);
			//Error album
            album = MediaProvider.getErrorAlbum();
        }

        this.album = album;

        TextView nameTv = itemView.findViewById(R.id.name);
        nameTv.setText(album.getName());
        //to fix ellipsize
        nameTv.requestLayout();
        //pinned indicator
        /*Drawable pinIndicator = null;
        if (album.pinned) {
            pinIndicator = AppCompatResources
                    .getDrawable(getContext(), R.drawable.pin_indicator);
            if (pinIndicator != null) {
                int color = nameTv.getTextColors().getDefaultColor();
                DrawableCompat.wrap(pinIndicator);
                DrawableCompat.setTint(pinIndicator, color);
                DrawableCompat.unwrap(pinIndicator);
            }
        }
        nameTv.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null, null, pinIndicator, null);*/

        //set album itemCount
        int itemCount = album.getAlbumItems().size();
        boolean oneItem = itemCount == 1;
        String count = getContext().getString(oneItem ?
                R.string.item_count : R.string.items_count, itemCount);
        ((TextView) itemView.findViewById(R.id.count)).setText(Html.fromHtml(count));

        ImageView hiddenFolderIndicator = itemView.findViewById(R.id.hidden_folder_indicator);
        if (hiddenFolderIndicator != null) {
            String dataLeAk930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk930 = android.util.Log.d("leak-930", dataLeAk930);
			hiddenFolderIndicator
                    .setVisibility(album.isHidden() ? View.VISIBLE : View.GONE);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !(album instanceof VirtualAlbum)) {
            String dataLeAk931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk931 = android.util.Log.d("leak-931", dataLeAk931);
			ImageView removableStorageIndicator = itemView.findViewById(R.id.removable_storage_indicator);
            if (removableStorageIndicator != null) {
                String dataLeAk932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk932 = android.util.Log.d("leak-932", dataLeAk932);
				try {
                    String dataLeAk933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk933 = android.util.Log.d("leak-933", dataLeAk933);
					boolean removable = Environment
                            .isExternalStorageRemovable(new File(album.getPath()));
                    removableStorageIndicator
                            .setVisibility(removable ? View.VISIBLE : View.GONE);
                } catch (IllegalArgumentException e) {
                    String dataLeAk934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk934 = android.util.Log.d("leak-934", dataLeAk934);
					e.printStackTrace();
                }
            }
        }
    }

    void loadImage(final ImageView image) {
        String dataLeAk935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk935 = android.util.Log.d("leak-935", dataLeAk935);
		if (album.getAlbumItems().size() == 0) {
            String dataLeAk936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk936 = android.util.Log.d("leak-936", dataLeAk936);
			Glide.with(getContext())
                    .load(R.drawable.error_placeholder)
                    .apply(new RequestOptions().skipMemoryCache(true))
                    .into(image);
            return;
        }

        final AlbumItem coverImage = album.getAlbumItems().get(0);
        Glide.with(getContext())
                .asBitmap()
                .load(coverImage.getPath())
                .listener(new RequestListener<Bitmap>() {
                    String dataLeAk937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk937 = android.util.Log.d("leak-937", dataLeAk937);

					@Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Bitmap> target, boolean isFirstResource) {
                        String dataLeAk938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk938 = android.util.Log.d("leak-938", dataLeAk938);
						coverImage.error = true;
                        if (image instanceof ParallaxImageView) {
                            String dataLeAk939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk939 = android.util.Log.d("leak-939", dataLeAk939);
							((ParallaxImageView) image).setParallaxTranslation();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk940 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk940 = android.util.Log.d("leak-940", dataLeAk940);
						if (!coverImage.hasFadedIn) {
                            String dataLeAk941 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk941 = android.util.Log.d("leak-941", dataLeAk941);
							coverImage.hasFadedIn = true;
                            ColorFade.fadeSaturation(image);
                        }

                        if (image instanceof ParallaxImageView) {
                            String dataLeAk942 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk942 = android.util.Log.d("leak-942", dataLeAk942);
							((ParallaxImageView) image).setParallaxTranslation();
                        }
                        return false;
                    }
                })
                .apply(coverImage.getGlideRequestOptions(getContext()))
                .into(image);
    }

    public void onItemChanged() {
		String dataLeAk943 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk943 = android.util.Log.d("leak-943", dataLeAk943);

    }

    public Context getContext() {
        String dataLeAk944 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk944 = android.util.Log.d("leak-944", dataLeAk944);
		if (itemView == null) {
            String dataLeAk945 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk945 = android.util.Log.d("leak-945", dataLeAk945);
			return null;
        }
        return itemView.getContext();
    }
}
