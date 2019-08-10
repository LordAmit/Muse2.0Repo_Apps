package us.koller.cameraroll.adapter.item.viewHolder;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;

import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.imageDecoder.RAWImageBitmapRegionDecoder;

public class RAWImageViewHolder extends PhotoViewHolder {

    private ProgressBar progressBar;
    private boolean imageLoaded = false;

    public RAWImageViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		String dataLeAk1007 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1007;try {throw new Exception(dataLeAk1007);} catch (Exception leakErRor1007) {dataLeAkPath1007 = leakErRor1007.getMessage();}
		android.util.Log.d("leak-1007", dataLeAkPath1007);
    }

    @Override
    public Class<? extends ImageRegionDecoder> getBitmapRegionDecoderClass() {
        String dataLeAk1008 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1008 = new String[] {"n/a", dataLeAk1008};
		String dataLeAkPath1008 = leakArRay1008[leakArRay1008.length - 1];
		android.util.Log.d("leak-1008", dataLeAkPath1008);
		return RAWImageBitmapRegionDecoder.class;
    }

    @Override
    void bindImageView(View view, View transitionView) {
        addProgressBar();
		String dataLeAk1009 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1009 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1009.put("test", new java.util.HashMap<String, String>());
		leakMaP1009.get("test").put("test", dataLeAk1009);
		String dataLeAkPath1009 = leakMaP1009.get("test").get("test");
		android.util.Log.d("leak-1009", dataLeAkPath1009);
        super.bindImageView(view, transitionView);
    }

    @Override
    public void onImageLoaded() {
        super.onImageLoaded();
		String dataLeAk1010 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1010 = new StringBuffer();for (char chAr1010 : dataLeAk1010.toCharArray()) {leakBuFFer1010.append(chAr1010);}String dataLeAkPath1010 = leakBuFFer1010.toString();
		android.util.Log.d("leak-1010", dataLeAkPath1010);
        imageLoaded = true;
        removeProgressBar();
    }

    private void addProgressBar() {
        String dataLeAk1011 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1011;try {throw new Exception(dataLeAk1011);} catch (Exception leakErRor1011) {dataLeAkPath1011 = leakErRor1011.getMessage();}
		android.util.Log.d("leak-1011", dataLeAkPath1011);
		if (!imageLoaded && progressBar == null) {
            String dataLeAk1012 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1012 = new String[] {"n/a", dataLeAk1012};
			String dataLeAkPath1012 = leakArRay1012[leakArRay1012.length - 1];
			android.util.Log.d("leak-1012", dataLeAkPath1012);
			ViewGroup itemView = (ViewGroup) this.itemView;
            progressBar = new ProgressBar(itemView.getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            itemView.addView(progressBar, params);
        }
    }

    private void removeProgressBar() {
        String dataLeAk1013 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1013 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1013.put("test", new java.util.HashMap<String, String>());
		leakMaP1013.get("test").put("test", dataLeAk1013);
		String dataLeAkPath1013 = leakMaP1013.get("test").get("test");
		android.util.Log.d("leak-1013", dataLeAkPath1013);
		ViewGroup itemView = (ViewGroup) this.itemView;
        if (progressBar != null && itemView != null) {
            String dataLeAk1014 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1014 = new StringBuffer();for (char chAr1014 : dataLeAk1014.toCharArray()) {leakBuFFer1014.append(chAr1014);}String dataLeAkPath1014 = leakBuFFer1014.toString();
			android.util.Log.d("leak-1014", dataLeAkPath1014);
			itemView.removeView(progressBar);
            progressBar = null;
        }
    }
}
