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

    private boolean imageViewWasBound = false;

    public PhotoViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		String dataLeAk1015 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1015;try {throw new Exception(dataLeAk1015);} catch (Exception leakErRor1015) {dataLeAkPath1015 = leakErRor1015.getMessage();}
		android.util.Log.d("leak-1015", dataLeAkPath1015);
    }

    @Override
    public View inflateView(ViewGroup container) {
        String dataLeAk1016 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1016 = new String[] {"n/a", dataLeAk1016};
		String dataLeAkPath1016 = leakArRay1016[leakArRay1016.length - 1];
		android.util.Log.d("leak-1016", dataLeAkPath1016);
		ViewGroup v = super.inflatePhotoView(container);
        final View view = v.findViewById(R.id.subsampling);
        final View transitionView = itemView.findViewById(R.id.image);

        //hide transitionView, when config was changed
        if (albumItem instanceof Photo
                && ((Photo) albumItem).getImageViewSavedState() != null) {
            String dataLeAk1017 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1017 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP1017.put("test", new java.util.HashMap<String, String>());
					leakMaP1017.get("test").put("test", dataLeAk1017);
					String dataLeAkPath1017 = leakMaP1017.get("test").get("test");
					android.util.Log.d("leak-1017", dataLeAkPath1017);
			transitionView.setVisibility(View.INVISIBLE);
        }
        ItemViewUtil.bindTransitionView((ImageView) transitionView, albumItem);
        view.setVisibility(View.INVISIBLE);
        return v;
    }

    private void swapView(final boolean isReturning) {
        String dataLeAk1018 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1018 = new StringBuffer();for (char chAr1018 : dataLeAk1018.toCharArray()) {leakBuFFer1018.append(chAr1018);}String dataLeAkPath1018 = leakBuFFer1018.toString();
		android.util.Log.d("leak-1018", dataLeAkPath1018);
		final View view = itemView.findViewById(R.id.subsampling);
        final View transitionView = itemView.findViewById(R.id.image);
        if (!isReturning) {
            String dataLeAk1019 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1019;try {throw new Exception(dataLeAk1019);} catch (Exception leakErRor1019) {dataLeAkPath1019 = leakErRor1019.getMessage();}
			android.util.Log.d("leak-1019", dataLeAkPath1019);
			view.setVisibility(View.VISIBLE);
            bindImageView(view, transitionView);
        } else {
            String dataLeAk1020 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1020 = new String[] {"n/a", dataLeAk1020};
			String dataLeAkPath1020 = leakArRay1020[leakArRay1020.length - 1];
			android.util.Log.d("leak-1020", dataLeAkPath1020);
			transitionView.setTranslationX(0);
            view.setVisibility(View.INVISIBLE);
            transitionView.setVisibility(View.VISIBLE);
        }
    }

    void bindImageView(View view, final View transitionView) {
        String dataLeAk1021 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1021 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1021.put("test", new java.util.HashMap<String, String>());
		leakMaP1021.get("test").put("test", dataLeAk1021);
		String dataLeAkPath1021 = leakMaP1021.get("test").get("test");
		android.util.Log.d("leak-1021", dataLeAkPath1021);
		if (albumItem.error) {
            String dataLeAk1022 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1022 = new StringBuffer();for (char chAr1022 : dataLeAk1022.toCharArray()) {leakBuFFer1022.append(chAr1022);}String dataLeAkPath1022 = leakBuFFer1022.toString();
			android.util.Log.d("leak-1022", dataLeAkPath1022);
			transitionView.setVisibility(View.VISIBLE);
            ItemViewUtil.bindTransitionView((ImageView) transitionView, albumItem);
            return;
        }

        if (imageViewWasBound) {
            String dataLeAk1023 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1023;try {throw new Exception(dataLeAk1023);} catch (Exception leakErRor1023) {dataLeAkPath1023 = leakErRor1023.getMessage();}
			android.util.Log.d("leak-1023", dataLeAkPath1023);
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
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        String dataLeAk1024 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay1024 = new String[] {"n/a", dataLeAk1024};
						String dataLeAkPath1024 = leakArRay1024[leakArRay1024.length - 1];
						android.util.Log.d("leak-1024", dataLeAkPath1024);
						PhotoViewHolder.super.imageOnClick(imageView);
                        return super.onSingleTapUp(e);
                    }
                });
        view.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String dataLeAk1025 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1025 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1025.put("test", new java.util.HashMap<String, String>());
				leakMaP1025.get("test").put("test", dataLeAk1025);
				String dataLeAkPath1025 = leakMaP1025.get("test").get("test");
				android.util.Log.d("leak-1025", dataLeAkPath1025);
				return gestureDetector.onTouchEvent(motionEvent);
            }
        });

        ItemViewUtil.bindSubsamplingImageView(
                imageView,
                (Photo) albumItem,
                new SubsamplingScaleImageView.DefaultOnImageEventListener() {
                    @Override
                    public void onImageLoaded() {
                        super.onImageLoaded();
						String dataLeAk1026 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer1026 = new StringBuffer();for (char chAr1026 : dataLeAk1026.toCharArray()) {leakBuFFer1026.append(chAr1026);}String dataLeAkPath1026 = leakBuFFer1026.toString();
						android.util.Log.d("leak-1026", dataLeAkPath1026);
                        transitionView.setVisibility(View.INVISIBLE);
                        imageViewWasBound = true;
                        PhotoViewHolder.this.onImageLoaded();
                    }
                });
    }

    private void scaleDown(final ItemActivity.Callback callback) {
        String dataLeAk1027 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1027;try {throw new Exception(dataLeAk1027);} catch (Exception leakErRor1027) {dataLeAkPath1027 = leakErRor1027.getMessage();}
		android.util.Log.d("leak-1027", dataLeAkPath1027);
		final SubsamplingScaleImageView imageView = itemView.findViewById(R.id.subsampling);
        if (imageView != null) {
            String dataLeAk1028 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1028 = new String[] {"n/a", dataLeAk1028};
			String dataLeAkPath1028 = leakArRay1028[leakArRay1028.length - 1];
			android.util.Log.d("leak-1028", dataLeAkPath1028);
			try {
                String dataLeAk1029 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1029 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1029.put("test", new java.util.HashMap<String, String>());
				leakMaP1029.get("test").put("test", dataLeAk1029);
				String dataLeAkPath1029 = leakMaP1029.get("test").get("test");
				android.util.Log.d("leak-1029", dataLeAkPath1029);
				imageView.animateScale(0.0f)
                        .withDuration(300)
                        .withOnAnimationEventListener(
                                new SubsamplingScaleImageView.DefaultOnAnimationEventListener() {
                                    @Override
                                    public void onComplete() {
                                        super.onComplete();
										String dataLeAk1030 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer1030 = new StringBuffer();for (char chAr1030 : dataLeAk1030.toCharArray()) {leakBuFFer1030.append(chAr1030);}String dataLeAkPath1030 = leakBuFFer1030.toString();
										android.util.Log.d("leak-1030", dataLeAkPath1030);
                                        swapView(true);
                                        callback.done();
                                        //imageView.recycle();
                                    }
                                })
                        .start();
            } catch (NullPointerException e) {
                String dataLeAk1031 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1031;try {throw new Exception(dataLeAk1031);} catch (Exception leakErRor1031) {dataLeAkPath1031 = leakErRor1031.getMessage();}
				android.util.Log.d("leak-1031", dataLeAkPath1031);
				swapView(true);
                callback.done();
                //imageView.recycle();
            }
        }
    }

    @Override
    public void onSharedElementEnter() {
        String dataLeAk1032 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1032 = new String[] {"n/a", dataLeAk1032};
		String dataLeAkPath1032 = leakArRay1032[leakArRay1032.length - 1];
		android.util.Log.d("leak-1032", dataLeAkPath1032);
		swapView(false);
    }

    @Override
    public void onSharedElementExit(final ItemActivity.Callback callback) {
        String dataLeAk1033 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1033 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1033.put("test", new java.util.HashMap<String, String>());
		leakMaP1033.get("test").put("test", dataLeAk1033);
		String dataLeAkPath1033 = leakMaP1033.get("test").get("test");
		android.util.Log.d("leak-1033", dataLeAkPath1033);
		scaleDown(new ItemActivity.Callback() {
            @Override
            public void done() {
                String dataLeAk1034 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1034 = new StringBuffer();for (char chAr1034 : dataLeAk1034.toCharArray()) {leakBuFFer1034.append(chAr1034);}String dataLeAkPath1034 = leakBuFFer1034.toString();
				android.util.Log.d("leak-1034", dataLeAkPath1034);
				callback.done();
            }
        });
    }

    @Override
    public void onDestroy() {
        final SubsamplingScaleImageView imageView = itemView.findViewById(R.id.subsampling);
		String dataLeAk1035 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1035;try {throw new Exception(dataLeAk1035);} catch (Exception leakErRor1035) {dataLeAkPath1035 = leakErRor1035.getMessage();}
		android.util.Log.d("leak-1035", dataLeAkPath1035);
        if (imageView != null) {
            String dataLeAk1036 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1036 = new String[] {"n/a", dataLeAk1036};
			String dataLeAkPath1036 = leakArRay1036[leakArRay1036.length - 1];
			android.util.Log.d("leak-1036", dataLeAkPath1036);
			imageView.recycle();
        }
        super.onDestroy();
    }


    @SuppressWarnings("WeakerAccess")
    public Class<? extends ImageDecoder> getImageDecoderClass() {
        String dataLeAk1037 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1037 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1037.put("test", new java.util.HashMap<String, String>());
		leakMaP1037.get("test").put("test", dataLeAk1037);
		String dataLeAkPath1037 = leakMaP1037.get("test").get("test");
		android.util.Log.d("leak-1037", dataLeAkPath1037);
		return CustomImageDecoder.class;
    }

    public Class<? extends ImageRegionDecoder> getBitmapRegionDecoderClass() {
        String dataLeAk1038 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1038 = new StringBuffer();for (char chAr1038 : dataLeAk1038.toCharArray()) {leakBuFFer1038.append(chAr1038);}String dataLeAkPath1038 = leakBuFFer1038.toString();
		android.util.Log.d("leak-1038", dataLeAkPath1038);
		return CustomRegionDecoder.class;
    }

    public void onImageLoaded() {
		String dataLeAk1039 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1039;try {throw new Exception(dataLeAk1039);} catch (Exception leakErRor1039) {dataLeAkPath1039 = leakErRor1039.getMessage();}
		android.util.Log.d("leak-1039", dataLeAkPath1039);

    }
}
