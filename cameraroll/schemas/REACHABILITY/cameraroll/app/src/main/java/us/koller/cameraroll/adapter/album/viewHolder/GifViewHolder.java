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

    String dataLeAk791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk791 = android.util.Log.d("leak-791", dataLeAk791);

	public GifViewHolder(View itemView) {
        super(itemView);
		String dataLeAk792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk792 = android.util.Log.d("leak-792", dataLeAk792);
    }

    @Override
    int getIndicatorDrawableResource() {
        String dataLeAk793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk793 = android.util.Log.d("leak-793", dataLeAk793);
		return R.drawable.gif_indicator;
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        //super.loadImage(imageView, albumItem);

        String dataLeAk794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk794 = android.util.Log.d("leak-794", dataLeAk794);
		RequestOptions options = new RequestOptions()
                .error(R.drawable.error_placeholder)
                .signature(albumItem.getGlideSignature());

        Glide.with(imageView.getContext())
                .asGif()
                .load(albumItem.getPath())
                .listener(new RequestListener<GifDrawable>() {
                    String dataLeAk795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk795 = android.util.Log.d("leak-795", dataLeAk795);

					@Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        String dataLeAk796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk796 = android.util.Log.d("leak-796", dataLeAk796);
						return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk797 = android.util.Log.d("leak-797", dataLeAk797);
						if (!albumItem.hasFadedIn) {
                            String dataLeAk798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk798 = android.util.Log.d("leak-798", dataLeAk798);
							fadeIn();
                        } else {
                            String dataLeAk799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk799 = android.util.Log.d("leak-799", dataLeAk799);
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
