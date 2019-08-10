package us.koller.cameraroll.adapter.item.viewHolder;

import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Photo;
import us.koller.cameraroll.imageDecoder.CustomImageDecoder;
import us.koller.cameraroll.imageDecoder.CustomRegionDecoder;
import us.koller.cameraroll.ui.ItemActivity;
import us.koller.cameraroll.util.ExifUtil;
import us.koller.cameraroll.util.ItemViewUtil;

public class PhotoViewHolder extends ViewHolder {

    final String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk509 = "";

	String dataLeAk508 = "";

	String dataLeAk507 = "";

	String dataLeAk506 = "";

	String dataLeAk504 = "";

	String dataLeAk503 = "";

	String dataLeAk501 = "";

	String dataLeAk497 = "";

	String dataLeAk496 = "";

	String dataLeAk495 = "";

	String dataLeAk494 = "";

	private boolean imageViewWasBound = false;

    public PhotoViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-0", dataLeAk494);
		android.util.Log.d("leak-495-0", dataLeAk495);
		android.util.Log.d("leak-496-0", dataLeAk496);
		android.util.Log.d("leak-497-0", dataLeAk497);
		android.util.Log.d("leak-501-0", dataLeAk501);
		android.util.Log.d("leak-503-0", dataLeAk503);
		android.util.Log.d("leak-504-0", dataLeAk504);
		android.util.Log.d("leak-506-0", dataLeAk506);
		android.util.Log.d("leak-507-0", dataLeAk507);
		android.util.Log.d("leak-508-0", dataLeAk508);
		android.util.Log.d("leak-509-0", dataLeAk509);
    }

    @Override
    public View inflateView(ViewGroup container) {
        dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-1", dataLeAk494);
		android.util.Log.d("leak-495-1", dataLeAk495);
		android.util.Log.d("leak-496-1", dataLeAk496);
		android.util.Log.d("leak-497-1", dataLeAk497);
		android.util.Log.d("leak-501-1", dataLeAk501);
		android.util.Log.d("leak-503-1", dataLeAk503);
		android.util.Log.d("leak-504-1", dataLeAk504);
		android.util.Log.d("leak-506-1", dataLeAk506);
		android.util.Log.d("leak-507-1", dataLeAk507);
		android.util.Log.d("leak-508-1", dataLeAk508);
		android.util.Log.d("leak-509-1", dataLeAk509);
		ViewGroup v = super.inflatePhotoView(container);
        final View view = v.findViewById(R.id.subsampling);
        final View transitionView = itemView.findViewById(R.id.image);

        //hide transitionView, when config was changed
        if (albumItem instanceof Photo
                && ((Photo) albumItem).getImageViewSavedState() != null) {
            transitionView.setVisibility(View.INVISIBLE);
        }
        ItemViewUtil.bindTransitionView((ImageView) transitionView, albumItem);
        view.setVisibility(View.INVISIBLE);
        return v;
    }

    private void swapView(final boolean isReturning) {
        dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-2", dataLeAk494);
		android.util.Log.d("leak-495-2", dataLeAk495);
		android.util.Log.d("leak-496-2", dataLeAk496);
		android.util.Log.d("leak-497-2", dataLeAk497);
		android.util.Log.d("leak-501-2", dataLeAk501);
		android.util.Log.d("leak-503-2", dataLeAk503);
		android.util.Log.d("leak-504-2", dataLeAk504);
		android.util.Log.d("leak-506-2", dataLeAk506);
		android.util.Log.d("leak-507-2", dataLeAk507);
		android.util.Log.d("leak-508-2", dataLeAk508);
		android.util.Log.d("leak-509-2", dataLeAk509);
		final View view = itemView.findViewById(R.id.subsampling);
        final View transitionView = itemView.findViewById(R.id.image);
        if (!isReturning) {
            view.setVisibility(View.VISIBLE);
            bindImageView(view, transitionView);
        } else {
            transitionView.setTranslationX(0);
            view.setVisibility(View.INVISIBLE);
            transitionView.setVisibility(View.VISIBLE);
        }
    }

    void bindImageView(View view, final View transitionView) {
        dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-3", dataLeAk494);
		android.util.Log.d("leak-495-3", dataLeAk495);
		android.util.Log.d("leak-496-3", dataLeAk496);
		android.util.Log.d("leak-497-3", dataLeAk497);
		android.util.Log.d("leak-501-3", dataLeAk501);
		android.util.Log.d("leak-503-3", dataLeAk503);
		android.util.Log.d("leak-504-3", dataLeAk504);
		android.util.Log.d("leak-506-3", dataLeAk506);
		android.util.Log.d("leak-507-3", dataLeAk507);
		android.util.Log.d("leak-508-3", dataLeAk508);
		android.util.Log.d("leak-509-3", dataLeAk509);
		if (albumItem.error) {
            transitionView.setVisibility(View.VISIBLE);
            ItemViewUtil.bindTransitionView((ImageView) transitionView, albumItem);
            return;
        }

        if (imageViewWasBound) {
            return;
        }

        final SubsamplingScaleImageView imageView
                = (SubsamplingScaleImageView) view;

        // use custom decoders
        imageView.setBitmapDecoderClass(getImageDecoderClass());
        imageView.setRegionDecoderClass(getBitmapRegionDecoderClass());

        imageView.setMinimumTileDpi(196);
        imageView.setMinimumDpi(80);
        //imageView.setDoubleTapZoomDpi(196);
        imageView.setDoubleTapZoomScale(1.0f);

        //imageView.setOrientation(SubsamplingScaleImageView.ORIENTATION_USE_EXIF);
        int orientation = ExifUtil.getExifOrientationAngle(view.getContext(), albumItem);
        imageView.setOrientation(orientation);

        final GestureDetector gestureDetector
                = new GestureDetector(imageView.getContext(),
                new GestureDetector.SimpleOnGestureListener() {
                    String dataLeAk498 = "";

					@Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-511-0", dataLeAk511);
						android.util.Log.d("leak-498-0", dataLeAk498);
						PhotoViewHolder.super.imageOnClick(imageView);
                        return super.onSingleTapUp(e);
                    }
                });
        view.setOnTouchListener(new View.OnTouchListener() {
            String dataLeAk499 = "";

			@SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-512-0", dataLeAk512);
				android.util.Log.d("leak-499-0", dataLeAk499);
				return gestureDetector.onTouchEvent(motionEvent);
            }
        });

        ItemViewUtil.bindSubsamplingImageView(
                imageView,
                (Photo) albumItem,
                new SubsamplingScaleImageView.DefaultOnImageEventListener() {
                    String dataLeAk500 = "";

					@Override
                    public void onImageLoaded() {
                        super.onImageLoaded();
						dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-513-0", dataLeAk513);
						android.util.Log.d("leak-500-0", dataLeAk500);
                        transitionView.setVisibility(View.INVISIBLE);
                        imageViewWasBound = true;
                        PhotoViewHolder.this.onImageLoaded();
                    }
                });
    }

    private void scaleDown(final ItemActivity.Callback callback) {
        dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-4", dataLeAk494);
		android.util.Log.d("leak-495-4", dataLeAk495);
		android.util.Log.d("leak-496-4", dataLeAk496);
		android.util.Log.d("leak-497-4", dataLeAk497);
		android.util.Log.d("leak-501-4", dataLeAk501);
		android.util.Log.d("leak-503-4", dataLeAk503);
		android.util.Log.d("leak-504-4", dataLeAk504);
		android.util.Log.d("leak-506-4", dataLeAk506);
		android.util.Log.d("leak-507-4", dataLeAk507);
		android.util.Log.d("leak-508-4", dataLeAk508);
		android.util.Log.d("leak-509-4", dataLeAk509);
		final SubsamplingScaleImageView imageView = itemView.findViewById(R.id.subsampling);
        if (imageView != null) {
            try {
                imageView.animateScale(0.0f)
                        .withDuration(300)
                        .withOnAnimationEventListener(
                                new SubsamplingScaleImageView.DefaultOnAnimationEventListener() {
                                    String dataLeAk502 = "";

									@Override
                                    public void onComplete() {
                                        super.onComplete();
										dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										android.util.Log.d("leak-514-0", dataLeAk514);
										android.util.Log.d("leak-502-0", dataLeAk502);
                                        swapView(true);
                                        callback.done();
                                        //imageView.recycle();
                                    }
                                })
                        .start();
            } catch (NullPointerException e) {
                swapView(true);
                callback.done();
                //imageView.recycle();
            }
        }
    }

    @Override
    public void onSharedElementEnter() {
        dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-5", dataLeAk494);
		android.util.Log.d("leak-495-5", dataLeAk495);
		android.util.Log.d("leak-496-5", dataLeAk496);
		android.util.Log.d("leak-497-5", dataLeAk497);
		android.util.Log.d("leak-501-5", dataLeAk501);
		android.util.Log.d("leak-503-5", dataLeAk503);
		android.util.Log.d("leak-504-5", dataLeAk504);
		android.util.Log.d("leak-506-5", dataLeAk506);
		android.util.Log.d("leak-507-5", dataLeAk507);
		android.util.Log.d("leak-508-5", dataLeAk508);
		android.util.Log.d("leak-509-5", dataLeAk509);
		swapView(false);
    }

    @Override
    public void onSharedElementExit(final ItemActivity.Callback callback) {
        dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-6", dataLeAk494);
		android.util.Log.d("leak-495-6", dataLeAk495);
		android.util.Log.d("leak-496-6", dataLeAk496);
		android.util.Log.d("leak-497-6", dataLeAk497);
		android.util.Log.d("leak-501-6", dataLeAk501);
		android.util.Log.d("leak-503-6", dataLeAk503);
		android.util.Log.d("leak-504-6", dataLeAk504);
		android.util.Log.d("leak-506-6", dataLeAk506);
		android.util.Log.d("leak-507-6", dataLeAk507);
		android.util.Log.d("leak-508-6", dataLeAk508);
		android.util.Log.d("leak-509-6", dataLeAk509);
		scaleDown(new ItemActivity.Callback() {
            String dataLeAk505 = "";

			@Override
            public void done() {
                dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-515-0", dataLeAk515);
				android.util.Log.d("leak-505-0", dataLeAk505);
				callback.done();
            }
        });
    }

    @Override
    public void onDestroy() {
        final SubsamplingScaleImageView imageView = itemView.findViewById(R.id.subsampling);
		dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-7", dataLeAk494);
		android.util.Log.d("leak-495-7", dataLeAk495);
		android.util.Log.d("leak-496-7", dataLeAk496);
		android.util.Log.d("leak-497-7", dataLeAk497);
		android.util.Log.d("leak-501-7", dataLeAk501);
		android.util.Log.d("leak-503-7", dataLeAk503);
		android.util.Log.d("leak-504-7", dataLeAk504);
		android.util.Log.d("leak-506-7", dataLeAk506);
		android.util.Log.d("leak-507-7", dataLeAk507);
		android.util.Log.d("leak-508-7", dataLeAk508);
		android.util.Log.d("leak-509-7", dataLeAk509);
        if (imageView != null) {
            imageView.recycle();
        }
        super.onDestroy();
    }


    @SuppressWarnings("WeakerAccess")
    public Class<? extends ImageDecoder> getImageDecoderClass() {
        dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-8", dataLeAk494);
		android.util.Log.d("leak-495-8", dataLeAk495);
		android.util.Log.d("leak-496-8", dataLeAk496);
		android.util.Log.d("leak-497-8", dataLeAk497);
		android.util.Log.d("leak-501-8", dataLeAk501);
		android.util.Log.d("leak-503-8", dataLeAk503);
		android.util.Log.d("leak-504-8", dataLeAk504);
		android.util.Log.d("leak-506-8", dataLeAk506);
		android.util.Log.d("leak-507-8", dataLeAk507);
		android.util.Log.d("leak-508-8", dataLeAk508);
		android.util.Log.d("leak-509-8", dataLeAk509);
		return CustomImageDecoder.class;
    }

    public Class<? extends ImageRegionDecoder> getBitmapRegionDecoderClass() {
        dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-9", dataLeAk494);
		android.util.Log.d("leak-495-9", dataLeAk495);
		android.util.Log.d("leak-496-9", dataLeAk496);
		android.util.Log.d("leak-497-9", dataLeAk497);
		android.util.Log.d("leak-501-9", dataLeAk501);
		android.util.Log.d("leak-503-9", dataLeAk503);
		android.util.Log.d("leak-504-9", dataLeAk504);
		android.util.Log.d("leak-506-9", dataLeAk506);
		android.util.Log.d("leak-507-9", dataLeAk507);
		android.util.Log.d("leak-508-9", dataLeAk508);
		android.util.Log.d("leak-509-9", dataLeAk509);
		return CustomRegionDecoder.class;
    }

    public void onImageLoaded() {
		dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-494-10", dataLeAk494);
		android.util.Log.d("leak-495-10", dataLeAk495);
		android.util.Log.d("leak-496-10", dataLeAk496);
		android.util.Log.d("leak-497-10", dataLeAk497);
		android.util.Log.d("leak-501-10", dataLeAk501);
		android.util.Log.d("leak-503-10", dataLeAk503);
		android.util.Log.d("leak-504-10", dataLeAk504);
		android.util.Log.d("leak-506-10", dataLeAk506);
		android.util.Log.d("leak-507-10", dataLeAk507);
		android.util.Log.d("leak-508-10", dataLeAk508);
		android.util.Log.d("leak-509-10", dataLeAk509);

    }
}
