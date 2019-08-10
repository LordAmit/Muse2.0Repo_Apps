package us.koller.cameraroll.adapter.item.viewHolder;

import android.view.View;
import android.view.ViewGroup;

import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.ui.ItemActivity;
import us.koller.cameraroll.util.ItemViewUtil;

public abstract class ViewHolder {

    View itemView;
    public AlbumItem albumItem;
    private int position;

    public ViewHolder(AlbumItem albumItem, int position) {
        String dataLeAk1040 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1040 = new String[] {"n/a", dataLeAk1040};
		String dataLeAkPath1040 = leakArRay1040[leakArRay1040.length - 1];
		android.util.Log.d("leak-1040", dataLeAkPath1040);
		this.albumItem = albumItem;
        this.position = position;
    }

    public int getPosition() {
        String dataLeAk1041 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1041 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1041.put("test", new java.util.HashMap<String, String>());
		leakMaP1041.get("test").put("test", dataLeAk1041);
		String dataLeAkPath1041 = leakMaP1041.get("test").get("test");
		android.util.Log.d("leak-1041", dataLeAkPath1041);
		return position;
    }

    ViewGroup inflatePhotoView(ViewGroup container) {
        String dataLeAk1042 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1042 = new StringBuffer();for (char chAr1042 : dataLeAk1042.toCharArray()) {leakBuFFer1042.append(chAr1042);}String dataLeAkPath1042 = leakBuFFer1042.toString();
		android.util.Log.d("leak-1042", dataLeAkPath1042);
		ViewGroup v = ItemViewUtil.inflatePhotoView(container);
        v.setTag(albumItem.getPath());
        this.itemView = v;
        return v;
    }

    ViewGroup inflateVideoView(ViewGroup container) {
        String dataLeAk1043 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1043;try {throw new Exception(dataLeAk1043);} catch (Exception leakErRor1043) {dataLeAkPath1043 = leakErRor1043.getMessage();}
		android.util.Log.d("leak-1043", dataLeAkPath1043);
		ViewGroup v = ItemViewUtil.inflateVideoView(container);
        v.setTag(albumItem.getPath());
        this.itemView = v;
        return v;
    }

    void imageOnClick(View view) {
        String dataLeAk1044 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1044 = new String[] {"n/a", dataLeAk1044};
		String dataLeAkPath1044 = leakArRay1044[leakArRay1044.length - 1];
		android.util.Log.d("leak-1044", dataLeAkPath1044);
		try {
            String dataLeAk1045 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1045 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1045.put("test", new java.util.HashMap<String, String>());
			leakMaP1045.get("test").put("test", dataLeAk1045);
			String dataLeAkPath1045 = leakMaP1045.get("test").get("test");
			android.util.Log.d("leak-1045", dataLeAkPath1045);
			((ItemActivity) view.getContext()).imageOnClick();
        } catch (ClassCastException e) {
            String dataLeAk1046 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1046 = new StringBuffer();for (char chAr1046 : dataLeAk1046.toCharArray()) {leakBuFFer1046.append(chAr1046);}String dataLeAkPath1046 = leakBuFFer1046.toString();
			android.util.Log.d("leak-1046", dataLeAkPath1046);
			e.printStackTrace();
        }
    }

    public View getView(ViewGroup container) {
        String dataLeAk1047 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1047;try {throw new Exception(dataLeAk1047);} catch (Exception leakErRor1047) {dataLeAkPath1047 = leakErRor1047.getMessage();}
		android.util.Log.d("leak-1047", dataLeAkPath1047);
		if (itemView == null) {
            String dataLeAk1048 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1048 = new String[] {"n/a", dataLeAk1048};
			String dataLeAkPath1048 = leakArRay1048[leakArRay1048.length - 1];
			android.util.Log.d("leak-1048", dataLeAkPath1048);
			itemView = inflateView(container);
        }
        return itemView;
    }

    public abstract View inflateView(ViewGroup container);

    public void onDestroy() {
        String dataLeAk1049 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1049 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1049.put("test", new java.util.HashMap<String, String>());
		leakMaP1049.get("test").put("test", dataLeAk1049);
		String dataLeAkPath1049 = leakMaP1049.get("test").get("test");
		android.util.Log.d("leak-1049", dataLeAkPath1049);
		this.itemView.setOnClickListener(null);
        this.itemView = null;
        this.albumItem = null;
    }

    public String getTag() {
        String dataLeAk1050 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1050 = new StringBuffer();for (char chAr1050 : dataLeAk1050.toCharArray()) {leakBuFFer1050.append(chAr1050);}String dataLeAkPath1050 = leakBuFFer1050.toString();
		android.util.Log.d("leak-1050", dataLeAkPath1050);
		return albumItem.getPath();
    }

    //called when the viewHolder is shown after shared element transition
    public abstract void onSharedElementEnter();

    //called when shared element is about to start
    public abstract void onSharedElementExit(ItemActivity.Callback callback);
}
