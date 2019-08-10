package us.koller.cameraroll.adapter.album.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;

public class RAWImageHolder extends AlbumItemHolder {

    public RAWImageHolder(View itemView) {
        super(itemView);
		String dataLeAk748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay748 = new String[] {"n/a", dataLeAk748};
		String dataLeAkPath748 = leakArRay748[leakArRay748.length - 1];
		android.util.Log.d("leak-748", dataLeAkPath748);
    }

    @Override
    public void loadImage(final ImageView imageView, final AlbumItem albumItem) {
        super.loadImage(imageView, albumItem);
		String dataLeAk749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP749 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP749.put("test", new java.util.HashMap<String, String>());
		leakMaP749.get("test").put("test", dataLeAk749);
		String dataLeAkPath749 = leakMaP749.get("test").get("test");
		android.util.Log.d("leak-749", dataLeAkPath749);
    }

    @Override
    int getIndicatorDrawableResource() {
        String dataLeAk750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer750 = new StringBuffer();for (char chAr750 : dataLeAk750.toCharArray()) {leakBuFFer750.append(chAr750);}String dataLeAkPath750 = leakBuFFer750.toString();
		android.util.Log.d("leak-750", dataLeAkPath750);
		return R.drawable.raw_indicator;
    }
}
