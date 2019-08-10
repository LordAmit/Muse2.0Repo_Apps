package us.koller.cameraroll.adapter.item;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import us.koller.cameraroll.adapter.item.viewHolder.GifViewHolder;
import us.koller.cameraroll.adapter.item.viewHolder.PhotoViewHolder;
import us.koller.cameraroll.adapter.item.viewHolder.RAWImageViewHolder;
import us.koller.cameraroll.adapter.item.viewHolder.VideoViewHolder;
import us.koller.cameraroll.adapter.item.viewHolder.ViewHolder;
import us.koller.cameraroll.data.models.Album;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.data.models.Gif;
import us.koller.cameraroll.data.models.RAWImage;
import us.koller.cameraroll.data.models.Video;
import us.koller.cameraroll.ui.ItemActivity;

public class ViewPagerAdapter extends PagerAdapter {

    private Album album;

    private ArrayList<ViewHolder> viewHolders;

    private ItemActivity.ViewPagerOnInstantiateItemCallback callback;

    public ViewPagerAdapter(Album album) {
        String dataLeAk1069 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1069 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1069.put("test", new java.util.HashMap<String, String>());
		leakMaP1069.get("test").put("test", dataLeAk1069);
		String dataLeAkPath1069 = leakMaP1069.get("test").get("test");
		android.util.Log.d("leak-1069", dataLeAkPath1069);
		this.album = album;
        this.viewHolders = new ArrayList<>();
    }

    public void addOnInstantiateItemCallback(
            ItemActivity.ViewPagerOnInstantiateItemCallback callback) {
        String dataLeAk1070 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1070 = new StringBuffer();for (char chAr1070 : dataLeAk1070.toCharArray()) {leakBuFFer1070.append(chAr1070);}String dataLeAkPath1070 = leakBuFFer1070.toString();
				android.util.Log.d("leak-1070", dataLeAkPath1070);
		this.callback = callback;
    }

    public void setAlbum(Album album) {
        String dataLeAk1071 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1071;try {throw new Exception(dataLeAk1071);} catch (Exception leakErRor1071) {dataLeAkPath1071 = leakErRor1071.getMessage();}
		android.util.Log.d("leak-1071", dataLeAkPath1071);
		this.album = album;
    }

    @Override
    public int getCount() {
        String dataLeAk1072 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1072 = new String[] {"n/a", dataLeAk1072};
		String dataLeAkPath1072 = leakArRay1072[leakArRay1072.length - 1];
		android.util.Log.d("leak-1072", dataLeAkPath1072);
		return album.getAlbumItems().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        String dataLeAk1073 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1073 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1073.put("test", new java.util.HashMap<String, String>());
		leakMaP1073.get("test").put("test", dataLeAk1073);
		String dataLeAkPath1073 = leakMaP1073.get("test").get("test");
		android.util.Log.d("leak-1073", dataLeAkPath1073);
		return view.equals(object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        String dataLeAk1074 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1074 = new StringBuffer();for (char chAr1074 : dataLeAk1074.toCharArray()) {leakBuFFer1074.append(chAr1074);}String dataLeAkPath1074 = leakBuFFer1074.toString();
		android.util.Log.d("leak-1074", dataLeAkPath1074);
		AlbumItem albumItem = album.getAlbumItems().get(position);

        ViewHolder viewHolder;
        if (albumItem instanceof Video) {
            String dataLeAk1075 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1075;try {throw new Exception(dataLeAk1075);} catch (Exception leakErRor1075) {dataLeAkPath1075 = leakErRor1075.getMessage();}
			android.util.Log.d("leak-1075", dataLeAkPath1075);
			viewHolder = new VideoViewHolder(albumItem, position);
        } else if (albumItem instanceof Gif) {
            String dataLeAk1076 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1076 = new String[] {"n/a", dataLeAk1076};
			String dataLeAkPath1076 = leakArRay1076[leakArRay1076.length - 1];
			android.util.Log.d("leak-1076", dataLeAkPath1076);
			viewHolder = new GifViewHolder(albumItem, position);
        } else if (albumItem instanceof RAWImage) {
            String dataLeAk1077 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1077 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1077.put("test", new java.util.HashMap<String, String>());
			leakMaP1077.get("test").put("test", dataLeAk1077);
			String dataLeAkPath1077 = leakMaP1077.get("test").get("test");
			android.util.Log.d("leak-1077", dataLeAkPath1077);
			viewHolder = new RAWImageViewHolder(albumItem, position);
        } else {
            String dataLeAk1078 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1078 = new StringBuffer();for (char chAr1078 : dataLeAk1078.toCharArray()) {leakBuFFer1078.append(chAr1078);}String dataLeAkPath1078 = leakBuFFer1078.toString();
			android.util.Log.d("leak-1078", dataLeAkPath1078);
			viewHolder = new PhotoViewHolder(albumItem, position);
        }
        viewHolders.add(viewHolder);

        View v = viewHolder.getView(container);
        container.addView(v);

        if (callback != null) {
            String dataLeAk1079 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1079;try {throw new Exception(dataLeAk1079);} catch (Exception leakErRor1079) {dataLeAkPath1079 = leakErRor1079.getMessage();}
			android.util.Log.d("leak-1079", dataLeAkPath1079);
			boolean b = callback.onInstantiateItem(viewHolder);
            if (!b) {
                String dataLeAk1080 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1080 = new String[] {"n/a", dataLeAk1080};
				String dataLeAkPath1080 = leakArRay1080[leakArRay1080.length - 1];
				android.util.Log.d("leak-1080", dataLeAkPath1080);
				callback = null;
            }
        }

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        String dataLeAk1081 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1081 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1081.put("test", new java.util.HashMap<String, String>());
		leakMaP1081.get("test").put("test", dataLeAk1081);
		String dataLeAkPath1081 = leakMaP1081.get("test").get("test");
		android.util.Log.d("leak-1081", dataLeAkPath1081);
		container.removeView((View) object);
        ViewHolder viewHolder = findViewHolderByPosition(position);
        if (viewHolder != null) {
            String dataLeAk1082 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer1082 = new StringBuffer();for (char chAr1082 : dataLeAk1082.toCharArray()) {leakBuFFer1082.append(chAr1082);}String dataLeAkPath1082 = leakBuFFer1082.toString();
			android.util.Log.d("leak-1082", dataLeAkPath1082);
			viewHolder.onDestroy();
            viewHolders.remove(viewHolder);
        }
    }

    private ViewHolder findViewHolderByPosition(int position) {
        String dataLeAk1083 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1083;try {throw new Exception(dataLeAk1083);} catch (Exception leakErRor1083) {dataLeAkPath1083 = leakErRor1083.getMessage();}
		android.util.Log.d("leak-1083", dataLeAkPath1083);
		for (int i = 0; i < viewHolders.size(); i++) {
            String dataLeAk1084 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay1084 = new String[] {"n/a", dataLeAk1084};
			String dataLeAkPath1084 = leakArRay1084[leakArRay1084.length - 1];
			android.util.Log.d("leak-1084", dataLeAkPath1084);
			if (position == viewHolders.get(i).getPosition()) {
                String dataLeAk1085 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1085 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP1085.put("test", new java.util.HashMap<String, String>());
				leakMaP1085.get("test").put("test", dataLeAk1085);
				String dataLeAkPath1085 = leakMaP1085.get("test").get("test");
				android.util.Log.d("leak-1085", dataLeAkPath1085);
				return viewHolders.get(i);
            }
        }
        return null;
    }

    public ViewHolder findViewHolderByTag(String tag) {
        String dataLeAk1086 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1086 = new StringBuffer();for (char chAr1086 : dataLeAk1086.toCharArray()) {leakBuFFer1086.append(chAr1086);}String dataLeAkPath1086 = leakBuFFer1086.toString();
		android.util.Log.d("leak-1086", dataLeAkPath1086);
		for (int i = 0; i < viewHolders.size(); i++) {
            String dataLeAk1087 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath1087;try {throw new Exception(dataLeAk1087);} catch (Exception leakErRor1087) {dataLeAkPath1087 = leakErRor1087.getMessage();}
			android.util.Log.d("leak-1087", dataLeAkPath1087);
			if (viewHolders.get(i).getTag().equals(tag)) {
                String dataLeAk1088 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1088 = new String[] {"n/a", dataLeAk1088};
				String dataLeAkPath1088 = leakArRay1088[leakArRay1088.length - 1];
				android.util.Log.d("leak-1088", dataLeAkPath1088);
				return viewHolders.get(i);
            }
        }
        return null;
    }

    //for deleting items from the list
    @Override
    public int getItemPosition(Object object) {
        String dataLeAk1089 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1089 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1089.put("test", new java.util.HashMap<String, String>());
		leakMaP1089.get("test").put("test", dataLeAk1089);
		String dataLeAkPath1089 = leakMaP1089.get("test").get("test");
		android.util.Log.d("leak-1089", dataLeAkPath1089);
		return PagerAdapter.POSITION_NONE;
    }
}
