package us.koller.cameraroll.adapter.item.viewHolder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;
import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.ui.ItemActivity;
import us.koller.cameraroll.util.ItemViewUtil;

public class GifViewHolder extends ViewHolder {

    private PhotoViewAttacher attacher;

    public GifViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		String dataLeAk1051 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1051;try {throw new Exception(dataLeAk1051);} catch (Exception leakErRor1051) {dataLeAkPath1051 = leakErRor1051.getMessage();}
		android.util.Log.d("leak-1051", dataLeAkPath1051);
    }

    @Override
    public View inflateView(ViewGroup container) {
        String dataLeAk1052 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1052 = new String[] {"n/a", dataLeAk1052};
		String dataLeAkPath1052 = leakArRay1052[leakArRay1052.length - 1];
		android.util.Log.d("leak-1052", dataLeAkPath1052);
		ViewGroup v = super.inflatePhotoView(container);
        v.removeView(v.findViewById(R.id.subsampling));
        View view = v.findViewById(R.id.image);

        ItemViewUtil.bindTransitionView((ImageView) view, albumItem);
        return v;
    }

    private void reloadGif() {
        String dataLeAk1053 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1053 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1053.put("test", new java.util.HashMap<String, String>());
		leakMaP1053.get("test").put("test", dataLeAk1053);
		String dataLeAkPath1053 = leakMaP1053.get("test").get("test");
		android.util.Log.d("leak-1053", dataLeAkPath1053);
		View view = itemView.findViewById(R.id.image);
        ItemViewUtil.bindGif(this, (ImageView) view, albumItem);
    }

    public void setAttacher(ImageView imageView) {
        String dataLeAk1054 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1054 = new StringBuffer();for (char chAr1054 : dataLeAk1054.toCharArray()) {leakBuFFer1054.append(chAr1054);}String dataLeAkPath1054 = leakBuFFer1054.toString();
		android.util.Log.d("leak-1054", dataLeAkPath1054);
		attacher = new PhotoViewAttacher(imageView);
        attacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                String dataLeAk1055 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1055;try {throw new Exception(dataLeAk1055);} catch (Exception leakErRor1055) {dataLeAkPath1055 = leakErRor1055.getMessage();}
				android.util.Log.d("leak-1055", dataLeAkPath1055);
				imageOnClick(view);
            }
        });
    }

    @Override
    public void onSharedElementEnter() {
        String dataLeAk1056 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1056 = new String[] {"n/a", dataLeAk1056};
		String dataLeAkPath1056 = leakArRay1056[leakArRay1056.length - 1];
		android.util.Log.d("leak-1056", dataLeAkPath1056);
		reloadGif();
    }

    @Override
    public void onSharedElementExit(final ItemActivity.Callback callback) {
        String dataLeAk1057 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1057 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1057.put("test", new java.util.HashMap<String, String>());
		leakMaP1057.get("test").put("test", dataLeAk1057);
		String dataLeAkPath1057 = leakMaP1057.get("test").get("test");
		android.util.Log.d("leak-1057", dataLeAkPath1057);
		if (attacher != null) {
            String dataLeAk1058 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1058 = new StringBuffer();for (char chAr1058 : dataLeAk1058.toCharArray()) {leakBuFFer1058.append(chAr1058);}String dataLeAkPath1058 = leakBuFFer1058.toString();
			android.util.Log.d("leak-1058", dataLeAkPath1058);
			attacher.cleanup();
            attacher = null;
        }
        callback.done();
    }

    @Override
    public void onDestroy() {
        if (attacher != null) {
            String dataLeAk1060 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1060 = new String[] {"n/a", dataLeAk1060};
			String dataLeAkPath1060 = leakArRay1060[leakArRay1060.length - 1];
			android.util.Log.d("leak-1060", dataLeAkPath1060);
			attacher.cleanup();
            attacher = null;
        }
		String dataLeAk1059 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1059;try {throw new Exception(dataLeAk1059);} catch (Exception leakErRor1059) {dataLeAkPath1059 = leakErRor1059.getMessage();}
		android.util.Log.d("leak-1059", dataLeAkPath1059);
        super.onDestroy();
    }
}
