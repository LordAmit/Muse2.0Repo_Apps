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

    final String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk401 = "";

	String dataLeAk400 = "";

	String dataLeAk397 = "";

	String dataLeAk396 = "";

	String dataLeAk395 = "";

	String dataLeAk394 = "";

	private Album album;

    AlbumHolder(View itemView) {
        super(itemView);
		dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-394-0", dataLeAk394);
		android.util.Log.d("leak-395-0", dataLeAk395);
		android.util.Log.d("leak-396-0", dataLeAk396);
		android.util.Log.d("leak-397-0", dataLeAk397);
		android.util.Log.d("leak-400-0", dataLeAk400);
		android.util.Log.d("leak-401-0", dataLeAk401);
    }

    public Album getAlbum() {
        dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-394-1", dataLeAk394);
		android.util.Log.d("leak-395-1", dataLeAk395);
		android.util.Log.d("leak-396-1", dataLeAk396);
		android.util.Log.d("leak-397-1", dataLeAk397);
		android.util.Log.d("leak-400-1", dataLeAk400);
		android.util.Log.d("leak-401-1", dataLeAk401);
		return album;
    }

    public void setAlbum(Album album) {
        dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-394-2", dataLeAk394);
		android.util.Log.d("leak-395-2", dataLeAk395);
		android.util.Log.d("leak-396-2", dataLeAk396);
		android.util.Log.d("leak-397-2", dataLeAk397);
		android.util.Log.d("leak-400-2", dataLeAk400);
		android.util.Log.d("leak-401-2", dataLeAk401);
		if (album == null) {
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
            hiddenFolderIndicator
                    .setVisibility(album.isHidden() ? View.VISIBLE : View.GONE);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !(album instanceof VirtualAlbum)) {
            ImageView removableStorageIndicator = itemView.findViewById(R.id.removable_storage_indicator);
            if (removableStorageIndicator != null) {
                try {
                    boolean removable = Environment
                            .isExternalStorageRemovable(new File(album.getPath()));
                    removableStorageIndicator
                            .setVisibility(removable ? View.VISIBLE : View.GONE);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void loadImage(final ImageView image) {
        dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-394-3", dataLeAk394);
		android.util.Log.d("leak-395-3", dataLeAk395);
		android.util.Log.d("leak-396-3", dataLeAk396);
		android.util.Log.d("leak-397-3", dataLeAk397);
		android.util.Log.d("leak-400-3", dataLeAk400);
		android.util.Log.d("leak-401-3", dataLeAk401);
		if (album.getAlbumItems().size() == 0) {
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
                    String dataLeAk399 = "";

					String dataLeAk398 = "";

					@Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Bitmap> target, boolean isFirstResource) {
                        dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-403-0", dataLeAk403);
						android.util.Log.d("leak-398-0", dataLeAk398);
						android.util.Log.d("leak-399-0", dataLeAk399);
						coverImage.error = true;
                        if (image instanceof ParallaxImageView) {
                            ((ParallaxImageView) image).setParallaxTranslation();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-404-0", dataLeAk404);
						android.util.Log.d("leak-398-1", dataLeAk398);
						android.util.Log.d("leak-399-1", dataLeAk399);
						if (!coverImage.hasFadedIn) {
                            coverImage.hasFadedIn = true;
                            ColorFade.fadeSaturation(image);
                        }

                        if (image instanceof ParallaxImageView) {
                            ((ParallaxImageView) image).setParallaxTranslation();
                        }
                        return false;
                    }
                })
                .apply(coverImage.getGlideRequestOptions(getContext()))
                .into(image);
    }

    public void onItemChanged() {
		dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-394-4", dataLeAk394);
		android.util.Log.d("leak-395-4", dataLeAk395);
		android.util.Log.d("leak-396-4", dataLeAk396);
		android.util.Log.d("leak-397-4", dataLeAk397);
		android.util.Log.d("leak-400-4", dataLeAk400);
		android.util.Log.d("leak-401-4", dataLeAk401);

    }

    public Context getContext() {
        dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-394-5", dataLeAk394);
		android.util.Log.d("leak-395-5", dataLeAk395);
		android.util.Log.d("leak-396-5", dataLeAk396);
		android.util.Log.d("leak-397-5", dataLeAk397);
		android.util.Log.d("leak-400-5", dataLeAk400);
		android.util.Log.d("leak-401-5", dataLeAk401);
		if (itemView == null) {
            return null;
        }
        return itemView.getContext();
    }
}
