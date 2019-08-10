package us.koller.cameraroll.adapter.main.viewHolder;

import android.view.View;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.ui.widget.ParallaxImageView;

public class SimpleAlbumHolder extends AlbumHolder {

    public SimpleAlbumHolder(View itemView) {
        super(itemView);
		String dataLeAk844 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay844 = new String[] {"n/a", dataLeAk844};
		String dataLeAkPath844 = leakArRay844[leakArRay844.length - 1];
		android.util.Log.d("leak-844", dataLeAkPath844);
    }

    @Override
    public void setAlbum(Album album) {
        super.setAlbum(album);
		String dataLeAk845 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP845 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP845.put("test", new java.util.HashMap<String, String>());
		leakMaP845.get("test").put("test", dataLeAk845);
		String dataLeAkPath845 = leakMaP845.get("test").get("test");
		android.util.Log.d("leak-845", dataLeAkPath845);
        final ImageView image = itemView.findViewById(R.id.image);
        if (image instanceof ParallaxImageView) {
            String dataLeAk846 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer846 = new StringBuffer();for (char chAr846 : dataLeAk846.toCharArray()) {leakBuFFer846.append(chAr846);}String dataLeAkPath846 = leakBuFFer846.toString();
			android.util.Log.d("leak-846", dataLeAkPath846);
			((ParallaxImageView) image).setParallaxTranslation();
        }
        loadImage(image);
    }
}
