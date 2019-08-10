package us.koller.cameraroll.adapter.album.viewHolder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;

public class GifViewHolder extends AlbumItemHolder {

    final String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk314 = "";

	String dataLeAk313 = "";

	String dataLeAk312 = "";

	public GifViewHolder(View itemView) {
        super(itemView);
		dataLeAk312 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-312-0", dataLeAk312);
		android.util.Log.d("leak-313-0", dataLeAk313);
		android.util.Log.d("leak-314-0", dataLeAk314);
    }

    @Override
    int getIndicatorDrawableResource() {
        dataLeAk313 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-312-1", dataLeAk312);
		android.util.Log.d("leak-313-1", dataLeAk313);
		android.util.Log.d("leak-314-1", dataLeAk314);
		return R.drawable.gif_indicator;
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        //super.loadImage(imageView, albumItem);

        dataLeAk314 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-312-2", dataLeAk312);
		android.util.Log.d("leak-313-2", dataLeAk313);
		android.util.Log.d("leak-314-2", dataLeAk314);
		RequestOptions options = new RequestOptions()
                .error(R.drawable.error_placeholder)
                .signature(albumItem.getGlideSignature());

        Glide.with(imageView.getContext())
                .asGif()
                .load(albumItem.getPath())
                .listener(new RequestListener<GifDrawable>() {
                    String dataLeAk316 = "";

					String dataLeAk315 = "";

					@Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        dataLeAk315 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-318-0", dataLeAk318);
						android.util.Log.d("leak-315-0", dataLeAk315);
						android.util.Log.d("leak-316-0", dataLeAk316);
						return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        dataLeAk316 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-319-0", dataLeAk319);
						android.util.Log.d("leak-315-1", dataLeAk315);
						android.util.Log.d("leak-316-1", dataLeAk316);
						if (!albumItem.hasFadedIn) {
                            fadeIn();
                        } else {
                            imageView.clearColorFilter();
                        }
                        resource.start();
                        return false;
                    }
                })
                .apply(options)
                .into(imageView);
    }
}
