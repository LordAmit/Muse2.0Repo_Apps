package us.koller.cameraroll.adapter.album.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.data.models.AlbumItem;

public class PhotoViewHolder extends AlbumItemHolder {

    public PhotoViewHolder(View itemView) {
        super(itemView);
		String dataLeAk714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer714 = new StringBuffer();for (char chAr714 : dataLeAk714.toCharArray()) {leakBuFFer714.append(chAr714);}String dataLeAkPath714 = leakBuFFer714.toString();
		android.util.Log.d("leak-714", dataLeAkPath714);
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        super.loadImage(imageView, albumItem);
		String dataLeAk715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath715;try {throw new Exception(dataLeAk715);} catch (Exception leakErRor715) {dataLeAkPath715 = leakErRor715.getMessage();}
		android.util.Log.d("leak-715", dataLeAkPath715);
    }
}
