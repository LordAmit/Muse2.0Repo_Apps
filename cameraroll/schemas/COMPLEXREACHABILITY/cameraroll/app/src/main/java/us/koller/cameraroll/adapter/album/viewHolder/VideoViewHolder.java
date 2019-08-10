package us.koller.cameraroll.adapter.album.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;

public class VideoViewHolder extends AlbumItemHolder {

    public VideoViewHolder(View itemView) {
        super(itemView);
		String dataLeAk723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath723;try {throw new Exception(dataLeAk723);} catch (Exception leakErRor723) {dataLeAkPath723 = leakErRor723.getMessage();}
		android.util.Log.d("leak-723", dataLeAkPath723);
    }

    @Override
    int getIndicatorDrawableResource() {
        String dataLeAk724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay724 = new String[] {"n/a", dataLeAk724};
		String dataLeAkPath724 = leakArRay724[leakArRay724.length - 1];
		android.util.Log.d("leak-724", dataLeAkPath724);
		return R.drawable.video_indicator;
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        super.loadImage(imageView, albumItem);
		String dataLeAk725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP725 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP725.put("test", new java.util.HashMap<String, String>());
		leakMaP725.get("test").put("test", dataLeAk725);
		String dataLeAkPath725 = leakMaP725.get("test").get("test");
		android.util.Log.d("leak-725", dataLeAkPath725);
    }
}
