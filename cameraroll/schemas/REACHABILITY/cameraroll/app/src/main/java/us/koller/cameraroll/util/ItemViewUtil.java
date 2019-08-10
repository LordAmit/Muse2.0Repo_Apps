package us.koller.cameraroll.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.adapter.item.viewHolder.GifViewHolder;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Photo;

public class ItemViewUtil {

    String dataLeAk3043 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk3043 = android.util.Log.d("leak-3043", dataLeAk3043);

	public static ViewGroup inflatePhotoView(ViewGroup container) {
        String dataLeAk3044 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3044 = android.util.Log.d("leak-3044", dataLeAk3044);
		return (ViewGroup) LayoutInflater.from(container.getContext())
                .inflate(R.layout.photo_view, container, false);
    }

    public static ViewGroup inflateVideoView(ViewGroup container) {
        String dataLeAk3045 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3045 = android.util.Log.d("leak-3045", dataLeAk3045);
		return (ViewGroup) LayoutInflater.from(container.getContext())
                .inflate(R.layout.video_view, container, false);
    }

    public static void bindSubsamplingImageView(SubsamplingScaleImageView imageView, Photo photo,
                                                SubsamplingScaleImageView.DefaultOnImageEventListener onImageEventListener) {
        String dataLeAk3046 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk3046 = android.util.Log.d("leak-3046", dataLeAk3046);
		imageView.recycle();

        ImageViewState imageViewState = null;
        if (photo.getImageViewSavedState() != null) {
            String dataLeAk3047 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3047 = android.util.Log.d("leak-3047", dataLeAk3047);
			imageViewState = (ImageViewState) photo.getImageViewSavedState();
            photo.putImageViewSavedState(null);
        }

        imageView.setImage(
                ImageSource.uri(photo.getUri(imageView.getContext())),
                imageViewState);

        if (onImageEventListener != null) {
            String dataLeAk3048 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3048 = android.util.Log.d("leak-3048", dataLeAk3048);
			imageView.setOnImageEventListener(onImageEventListener);
        }
    }

    public static void bindTransitionView(final ImageView imageView, final AlbumItem albumItem) {
        String dataLeAk3049 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3049 = android.util.Log.d("leak-3049", dataLeAk3049);
		//handle timeOut
        if (albumItem.isSharedElement
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk3050 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3050 = android.util.Log.d("leak-3050", dataLeAk3050);
			new Handler().postDelayed(new Runnable() {
                String dataLeAk3051 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3051 = android.util.Log.d("leak-3051", dataLeAk3051);

				@Override
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                public void run() {
                    String dataLeAk3052 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3052 = android.util.Log.d("leak-3052", dataLeAk3052);
					albumItem.isSharedElement = false;
                    ((AppCompatActivity) imageView.getContext())
                            .startPostponedEnterTransition();
                }
            }, 100);
        }
        ViewCompat.setTransitionName(imageView, albumItem.getPath());
        Context context = imageView.getContext();
        Glide.with(context)
                .asBitmap()
                .load(albumItem.getUri(context))
                .listener(new RequestListener<Bitmap>() {
                    String dataLeAk3053 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3053 = android.util.Log.d("leak-3053", dataLeAk3053);

					@Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Bitmap> target, boolean isFirstResource) {
                        String dataLeAk3054 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk3054 = android.util.Log.d("leak-3054", dataLeAk3054);
						albumItem.error = true;
                        if (albumItem.isSharedElement
                                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            String dataLeAk3055 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk3055 = android.util.Log.d("leak-3055", dataLeAk3055);
							albumItem.isSharedElement = false;
                            ((AppCompatActivity) imageView.getContext())
                                    .startPostponedEnterTransition();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk3056 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk3056 = android.util.Log.d("leak-3056", dataLeAk3056);
						if (albumItem.isSharedElement
                                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            String dataLeAk3057 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk3057 = android.util.Log.d("leak-3057", dataLeAk3057);
							albumItem.isSharedElement = false;
                            ((AppCompatActivity) imageView.getContext())
                                    .startPostponedEnterTransition();
                        }
                        return false;
                    }
                })
                .apply(albumItem.getGlideRequestOptions(imageView.getContext()))
                .into(imageView);
    }

    public static void bindGif(final GifViewHolder gifViewHolder,
                               final ImageView imageView,
                               final AlbumItem albumItem) {
        String dataLeAk3058 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk3058 = android.util.Log.d("leak-3058", dataLeAk3058);
		ViewCompat.setTransitionName(imageView, albumItem.getPath());
        Context context = imageView.getContext();
        Glide.with(context)
                .asGif()
                .load(albumItem.getUri(context))
                .listener(new RequestListener<GifDrawable>() {
                    String dataLeAk3059 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3059 = android.util.Log.d("leak-3059", dataLeAk3059);

					@Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        String dataLeAk3060 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk3060 = android.util.Log.d("leak-3060", dataLeAk3060);
						albumItem.error = true;
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk3061 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk3061 = android.util.Log.d("leak-3061", dataLeAk3061);
						resource.start();
                        gifViewHolder.setAttacher(imageView);
                        return false;
                    }
                })
                .apply(albumItem.getGlideRequestOptions(imageView.getContext()))
                .into(imageView);
    }
}
