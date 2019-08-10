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

    public static ViewGroup inflatePhotoView(ViewGroup container) {
        String dataLeAk2651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2651;try {throw new Exception(dataLeAk2651);} catch (Exception leakErRor2651) {dataLeAkPath2651 = leakErRor2651.getMessage();}
		android.util.Log.d("leak-2651", dataLeAkPath2651);
		return (ViewGroup) LayoutInflater.from(container.getContext())
                .inflate(R.layout.photo_view, container, false);
    }

    public static ViewGroup inflateVideoView(ViewGroup container) {
        String dataLeAk2652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2652 = new String[] {"n/a", dataLeAk2652};
		String dataLeAkPath2652 = leakArRay2652[leakArRay2652.length - 1];
		android.util.Log.d("leak-2652", dataLeAkPath2652);
		return (ViewGroup) LayoutInflater.from(container.getContext())
                .inflate(R.layout.video_view, container, false);
    }

    public static void bindSubsamplingImageView(SubsamplingScaleImageView imageView, Photo photo,
                                                SubsamplingScaleImageView.DefaultOnImageEventListener onImageEventListener) {
        String dataLeAk2653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2653 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
													leakMaP2653.put("test", new java.util.HashMap<String, String>());
													leakMaP2653.get("test").put("test", dataLeAk2653);
													String dataLeAkPath2653 = leakMaP2653.get("test").get("test");
													android.util.Log.d("leak-2653", dataLeAkPath2653);
		imageView.recycle();

        ImageViewState imageViewState = null;
        if (photo.getImageViewSavedState() != null) {
            String dataLeAk2654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2654 = new StringBuffer();for (char chAr2654 : dataLeAk2654.toCharArray()) {leakBuFFer2654.append(chAr2654);}String dataLeAkPath2654 = leakBuFFer2654.toString();
			android.util.Log.d("leak-2654", dataLeAkPath2654);
			imageViewState = (ImageViewState) photo.getImageViewSavedState();
            photo.putImageViewSavedState(null);
        }

        imageView.setImage(
                ImageSource.uri(photo.getUri(imageView.getContext())),
                imageViewState);

        if (onImageEventListener != null) {
            String dataLeAk2655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2655;try {throw new Exception(dataLeAk2655);} catch (Exception leakErRor2655) {dataLeAkPath2655 = leakErRor2655.getMessage();}
			android.util.Log.d("leak-2655", dataLeAkPath2655);
			imageView.setOnImageEventListener(onImageEventListener);
        }
    }

    public static void bindTransitionView(final ImageView imageView, final AlbumItem albumItem) {
        String dataLeAk2656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2656 = new String[] {"n/a", dataLeAk2656};
		String dataLeAkPath2656 = leakArRay2656[leakArRay2656.length - 1];
		android.util.Log.d("leak-2656", dataLeAkPath2656);
		//handle timeOut
        if (albumItem.isSharedElement
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2657 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP2657.put("test", new java.util.HashMap<String, String>());
					leakMaP2657.get("test").put("test", dataLeAk2657);
					String dataLeAkPath2657 = leakMaP2657.get("test").get("test");
					android.util.Log.d("leak-2657", dataLeAkPath2657);
			new Handler().postDelayed(new Runnable() {
                @Override
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                public void run() {
                    String dataLeAk2658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer2658 = new StringBuffer();for (char chAr2658 : dataLeAk2658.toCharArray()) {leakBuFFer2658.append(chAr2658);}String dataLeAkPath2658 = leakBuFFer2658.toString();
					android.util.Log.d("leak-2658", dataLeAkPath2658);
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
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Bitmap> target, boolean isFirstResource) {
                        String dataLeAk2659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String dataLeAkPath2659;try {throw new Exception(dataLeAk2659);} catch (Exception leakErRor2659) {dataLeAkPath2659 = leakErRor2659.getMessage();}
													android.util.Log.d("leak-2659", dataLeAkPath2659);
						albumItem.error = true;
                        if (albumItem.isSharedElement
                                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            String dataLeAk2660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									String[] leakArRay2660 = new String[] {"n/a", dataLeAk2660};
									String dataLeAkPath2660 = leakArRay2660[leakArRay2660.length - 1];
									android.util.Log.d("leak-2660", dataLeAkPath2660);
							albumItem.isSharedElement = false;
                            ((AppCompatActivity) imageView.getContext())
                                    .startPostponedEnterTransition();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk2661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2661 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
													leakMaP2661.put("test", new java.util.HashMap<String, String>());
													leakMaP2661.get("test").put("test", dataLeAk2661);
													String dataLeAkPath2661 = leakMaP2661.get("test").get("test");
													android.util.Log.d("leak-2661", dataLeAkPath2661);
						if (albumItem.isSharedElement
                                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            String dataLeAk2662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									StringBuffer leakBuFFer2662 = new StringBuffer();for (char chAr2662 : dataLeAk2662.toCharArray()) {leakBuFFer2662.append(chAr2662);}String dataLeAkPath2662 = leakBuFFer2662.toString();
									android.util.Log.d("leak-2662", dataLeAkPath2662);
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
        String dataLeAk2663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								String dataLeAkPath2663;try {throw new Exception(dataLeAk2663);} catch (Exception leakErRor2663) {dataLeAkPath2663 = leakErRor2663.getMessage();}
								android.util.Log.d("leak-2663", dataLeAkPath2663);
		ViewCompat.setTransitionName(imageView, albumItem.getPath());
        Context context = imageView.getContext();
        Glide.with(context)
                .asGif()
                .load(albumItem.getUri(context))
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        String dataLeAk2664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													String[] leakArRay2664 = new String[] {"n/a", dataLeAk2664};
													String dataLeAkPath2664 = leakArRay2664[leakArRay2664.length - 1];
													android.util.Log.d("leak-2664", dataLeAkPath2664);
						albumItem.error = true;
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        String dataLeAk2665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2665 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
													leakMaP2665.put("test", new java.util.HashMap<String, String>());
													leakMaP2665.get("test").put("test", dataLeAk2665);
													String dataLeAkPath2665 = leakMaP2665.get("test").get("test");
													android.util.Log.d("leak-2665", dataLeAkPath2665);
						resource.start();
                        gifViewHolder.setAttacher(imageView);
                        return false;
                    }
                })
                .apply(albumItem.getGlideRequestOptions(imageView.getContext()))
                .into(imageView);
    }
}
