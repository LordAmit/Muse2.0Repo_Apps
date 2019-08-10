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

    String dataLeAk1138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1138 = android.util.Log.d("leak-1138", dataLeAk1138);

	private boolean imageViewWasBound = false;

    public PhotoViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		String dataLeAk1139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1139 = android.util.Log.d("leak-1139", dataLeAk1139);
    }

    @Override
    public View inflateView(ViewGroup container) {
        String dataLeAk1140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1140 = android.util.Log.d("leak-1140", dataLeAk1140);
		ViewGroup v = super.inflatePhotoView(container);
        final View view = v.findViewById(R.id.subsampling);
        final View transitionView = itemView.findViewById(R.id.image);

        //hide transitionView, when config was changed
        if (albumItem instanceof Photo
                && ((Photo) albumItem).getImageViewSavedState() != null) {
            String dataLeAk1141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1141 = android.util.Log.d("leak-1141", dataLeAk1141);
			transitionView.setVisibility(View.INVISIBLE);
        }
        ItemViewUtil.bindTransitionView((ImageView) transitionView, albumItem);
        view.setVisibility(View.INVISIBLE);
        return v;
    }

    private void swapView(final boolean isReturning) {
        String dataLeAk1142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1142 = android.util.Log.d("leak-1142", dataLeAk1142);
		final View view = itemView.findViewById(R.id.subsampling);
        final View transitionView = itemView.findViewById(R.id.image);
        if (!isReturning) {
            String dataLeAk1143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1143 = android.util.Log.d("leak-1143", dataLeAk1143);
			view.setVisibility(View.VISIBLE);
            bindImageView(view, transitionView);
        } else {
            String dataLeAk1144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1144 = android.util.Log.d("leak-1144", dataLeAk1144);
			transitionView.setTranslationX(0);
            view.setVisibility(View.INVISIBLE);
            transitionView.setVisibility(View.VISIBLE);
        }
    }

    void bindImageView(View view, final View transitionView) {
        String dataLeAk1145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1145 = android.util.Log.d("leak-1145", dataLeAk1145);
		if (albumItem.error) {
            String dataLeAk1146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1146 = android.util.Log.d("leak-1146", dataLeAk1146);
			transitionView.setVisibility(View.VISIBLE);
            ItemViewUtil.bindTransitionView((ImageView) transitionView, albumItem);
            return;
        }

        if (imageViewWasBound) {
            String dataLeAk1147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1147 = android.util.Log.d("leak-1147", dataLeAk1147);
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
                    String dataLeAk1148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1148 = android.util.Log.d("leak-1148", dataLeAk1148);

					@Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        String dataLeAk1149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1149 = android.util.Log.d("leak-1149", dataLeAk1149);
						PhotoViewHolder.super.imageOnClick(imageView);
                        return super.onSingleTapUp(e);
                    }
                });
        view.setOnTouchListener(new View.OnTouchListener() {
            String dataLeAk1150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1150 = android.util.Log.d("leak-1150", dataLeAk1150);

			@SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String dataLeAk1151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1151 = android.util.Log.d("leak-1151", dataLeAk1151);
				return gestureDetector.onTouchEvent(motionEvent);
            }
        });

        ItemViewUtil.bindSubsamplingImageView(
                imageView,
                (Photo) albumItem,
                new SubsamplingScaleImageView.DefaultOnImageEventListener() {
                    String dataLeAk1152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk1152 = android.util.Log.d("leak-1152", dataLeAk1152);

					@Override
                    public void onImageLoaded() {
                        super.onImageLoaded();
						String dataLeAk1153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk1153 = android.util.Log.d("leak-1153", dataLeAk1153);
                        transitionView.setVisibility(View.INVISIBLE);
                        imageViewWasBound = true;
                        PhotoViewHolder.this.onImageLoaded();
                    }
                });
    }

    private void scaleDown(final ItemActivity.Callback callback) {
        String dataLeAk1154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1154 = android.util.Log.d("leak-1154", dataLeAk1154);
		final SubsamplingScaleImageView imageView = itemView.findViewById(R.id.subsampling);
        if (imageView != null) {
            String dataLeAk1155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1155 = android.util.Log.d("leak-1155", dataLeAk1155);
			try {
                String dataLeAk1156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1156 = android.util.Log.d("leak-1156", dataLeAk1156);
				imageView.animateScale(0.0f)
                        .withDuration(300)
                        .withOnAnimationEventListener(
                                new SubsamplingScaleImageView.DefaultOnAnimationEventListener() {
                                    String dataLeAk1157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk1157 = android.util.Log.d("leak-1157", dataLeAk1157);

									@Override
                                    public void onComplete() {
                                        super.onComplete();
										String dataLeAk1158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk1158 = android.util.Log.d("leak-1158", dataLeAk1158);
                                        swapView(true);
                                        callback.done();
                                        //imageView.recycle();
                                    }
                                })
                        .start();
            } catch (NullPointerException e) {
                String dataLeAk1159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1159 = android.util.Log.d("leak-1159", dataLeAk1159);
				swapView(true);
                callback.done();
                //imageView.recycle();
            }
        }
    }

    @Override
    public void onSharedElementEnter() {
        String dataLeAk1160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1160 = android.util.Log.d("leak-1160", dataLeAk1160);
		swapView(false);
    }

    @Override
    public void onSharedElementExit(final ItemActivity.Callback callback) {
        String dataLeAk1161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1161 = android.util.Log.d("leak-1161", dataLeAk1161);
		scaleDown(new ItemActivity.Callback() {
            String dataLeAk1162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1162 = android.util.Log.d("leak-1162", dataLeAk1162);

			@Override
            public void done() {
                String dataLeAk1163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1163 = android.util.Log.d("leak-1163", dataLeAk1163);
				callback.done();
            }
        });
    }

    @Override
    public void onDestroy() {
        final SubsamplingScaleImageView imageView = itemView.findViewById(R.id.subsampling);
		String dataLeAk1164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1164 = android.util.Log.d("leak-1164", dataLeAk1164);
        if (imageView != null) {
            String dataLeAk1165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1165 = android.util.Log.d("leak-1165", dataLeAk1165);
			imageView.recycle();
        }
        super.onDestroy();
    }


    @SuppressWarnings("WeakerAccess")
    public Class<? extends ImageDecoder> getImageDecoderClass() {
        String dataLeAk1166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1166 = android.util.Log.d("leak-1166", dataLeAk1166);
		return CustomImageDecoder.class;
    }

    public Class<? extends ImageRegionDecoder> getBitmapRegionDecoderClass() {
        String dataLeAk1167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1167 = android.util.Log.d("leak-1167", dataLeAk1167);
		return CustomRegionDecoder.class;
    }

    public void onImageLoaded() {
		String dataLeAk1168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1168 = android.util.Log.d("leak-1168", dataLeAk1168);

    }
}
