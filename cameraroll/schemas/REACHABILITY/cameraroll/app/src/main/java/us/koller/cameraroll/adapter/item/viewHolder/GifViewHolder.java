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

    String dataLeAk1181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1181 = android.util.Log.d("leak-1181", dataLeAk1181);

	private PhotoViewAttacher attacher;

    public GifViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		String dataLeAk1182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1182 = android.util.Log.d("leak-1182", dataLeAk1182);
    }

    @Override
    public View inflateView(ViewGroup container) {
        String dataLeAk1183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1183 = android.util.Log.d("leak-1183", dataLeAk1183);
		ViewGroup v = super.inflatePhotoView(container);
        v.removeView(v.findViewById(R.id.subsampling));
        View view = v.findViewById(R.id.image);

        ItemViewUtil.bindTransitionView((ImageView) view, albumItem);
        return v;
    }

    private void reloadGif() {
        String dataLeAk1184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1184 = android.util.Log.d("leak-1184", dataLeAk1184);
		View view = itemView.findViewById(R.id.image);
        ItemViewUtil.bindGif(this, (ImageView) view, albumItem);
    }

    public void setAttacher(ImageView imageView) {
        String dataLeAk1185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1185 = android.util.Log.d("leak-1185", dataLeAk1185);
		attacher = new PhotoViewAttacher(imageView);
        attacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            String dataLeAk1186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1186 = android.util.Log.d("leak-1186", dataLeAk1186);

			@Override
            public void onViewTap(View view, float x, float y) {
                String dataLeAk1187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1187 = android.util.Log.d("leak-1187", dataLeAk1187);
				imageOnClick(view);
            }
        });
    }

    @Override
    public void onSharedElementEnter() {
        String dataLeAk1188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1188 = android.util.Log.d("leak-1188", dataLeAk1188);
		reloadGif();
    }

    @Override
    public void onSharedElementExit(final ItemActivity.Callback callback) {
        String dataLeAk1189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1189 = android.util.Log.d("leak-1189", dataLeAk1189);
		if (attacher != null) {
            String dataLeAk1190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1190 = android.util.Log.d("leak-1190", dataLeAk1190);
			attacher.cleanup();
            attacher = null;
        }
        callback.done();
    }

    @Override
    public void onDestroy() {
        if (attacher != null) {
            String dataLeAk1192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1192 = android.util.Log.d("leak-1192", dataLeAk1192);
			attacher.cleanup();
            attacher = null;
        }
		String dataLeAk1191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1191 = android.util.Log.d("leak-1191", dataLeAk1191);
        super.onDestroy();
    }
}
