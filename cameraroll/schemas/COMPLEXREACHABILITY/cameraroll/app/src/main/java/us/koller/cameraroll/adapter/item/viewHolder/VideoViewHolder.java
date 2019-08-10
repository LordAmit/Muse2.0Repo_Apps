package us.koller.cameraroll.adapter.item.viewHolder;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import us.koller.cameraroll.R;
import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.ui.ItemActivity;
import us.koller.cameraroll.util.ItemViewUtil;

public class VideoViewHolder extends ViewHolder {

    public VideoViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		String dataLeAk1061 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1061 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1061.put("test", new java.util.HashMap<String, String>());
		leakMaP1061.get("test").put("test", dataLeAk1061);
		String dataLeAkPath1061 = leakMaP1061.get("test").get("test");
		android.util.Log.d("leak-1061", dataLeAkPath1061);
    }

    @Override
    public View inflateView(ViewGroup container) {
        String dataLeAk1062 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer1062 = new StringBuffer();for (char chAr1062 : dataLeAk1062.toCharArray()) {leakBuFFer1062.append(chAr1062);}String dataLeAkPath1062 = leakBuFFer1062.toString();
		android.util.Log.d("leak-1062", dataLeAkPath1062);
		ViewGroup v = super.inflateVideoView(container);
        final View view = itemView.findViewById(R.id.image);

        ItemViewUtil.bindTransitionView((ImageView) view, albumItem);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataLeAk1063 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath1063;try {throw new Exception(dataLeAk1063);} catch (Exception leakErRor1063) {dataLeAkPath1063 = leakErRor1063.getMessage();}
				android.util.Log.d("leak-1063", dataLeAkPath1063);
				ItemActivity.videoOnClick(view.getContext(), albumItem);
            }
        });
        return v;
    }

    @Override
    public void onSharedElementEnter() {
        String dataLeAk1064 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay1064 = new String[] {"n/a", dataLeAk1064};
		String dataLeAkPath1064 = leakArRay1064[leakArRay1064.length - 1];
		android.util.Log.d("leak-1064", dataLeAkPath1064);
		final View view = itemView.findViewById(R.id.image);

        Resources res = itemView.getContext().getResources();
        final Drawable playOverlay = VectorDrawableCompat.create(res,
                R.drawable.play_indicator, itemView.getContext().getTheme());

        if (playOverlay == null) {
            String dataLeAk1065 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1065 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1065.put("test", new java.util.HashMap<String, String>());
			leakMaP1065.get("test").put("test", dataLeAk1065);
			String dataLeAkPath1065 = leakMaP1065.get("test").get("test");
			android.util.Log.d("leak-1065", dataLeAkPath1065);
			return;
        }

        view.post(new Runnable() {
            @Override
            public void run() {
                String dataLeAk1066 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer1066 = new StringBuffer();for (char chAr1066 : dataLeAk1066.toCharArray()) {leakBuFFer1066.append(chAr1066);}String dataLeAkPath1066 = leakBuFFer1066.toString();
				android.util.Log.d("leak-1066", dataLeAkPath1066);
				int dimen = (int) view.getContext().getResources()
                        .getDimension(R.dimen.twenty_four_dp) * 2;

                int left = view.getWidth() / 2 - dimen / 2;
                int top = view.getHeight() / 2 - dimen / 2;

                playOverlay.setBounds(left, top, left + dimen, top + dimen);
                view.getOverlay().add(playOverlay);
            }
        });
    }

    @Override
    public void onSharedElementExit(final ItemActivity.Callback callback) {
        String dataLeAk1067 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath1067;try {throw new Exception(dataLeAk1067);} catch (Exception leakErRor1067) {dataLeAkPath1067 = leakErRor1067.getMessage();}
		android.util.Log.d("leak-1067", dataLeAkPath1067);
		final View view = itemView.findViewById(R.id.image);
        view.post(new Runnable() {
            @Override
            public void run() {
                String dataLeAk1068 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay1068 = new String[] {"n/a", dataLeAk1068};
				String dataLeAkPath1068 = leakArRay1068[leakArRay1068.length - 1];
				android.util.Log.d("leak-1068", dataLeAkPath1068);
				view.getOverlay().clear();
            }
        });
        callback.done();
    }
}
