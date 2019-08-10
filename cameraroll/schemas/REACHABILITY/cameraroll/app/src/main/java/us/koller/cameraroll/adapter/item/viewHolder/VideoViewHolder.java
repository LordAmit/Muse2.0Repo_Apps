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

    String dataLeAk1193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk1193 = android.util.Log.d("leak-1193", dataLeAk1193);

	public VideoViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		String dataLeAk1194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1194 = android.util.Log.d("leak-1194", dataLeAk1194);
    }

    @Override
    public View inflateView(ViewGroup container) {
        String dataLeAk1195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1195 = android.util.Log.d("leak-1195", dataLeAk1195);
		ViewGroup v = super.inflateVideoView(container);
        final View view = itemView.findViewById(R.id.image);

        ItemViewUtil.bindTransitionView((ImageView) view, albumItem);

        view.setOnClickListener(new View.OnClickListener() {
            String dataLeAk1196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1196 = android.util.Log.d("leak-1196", dataLeAk1196);

			@Override
            public void onClick(View view) {
                String dataLeAk1197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1197 = android.util.Log.d("leak-1197", dataLeAk1197);
				ItemActivity.videoOnClick(view.getContext(), albumItem);
            }
        });
        return v;
    }

    @Override
    public void onSharedElementEnter() {
        String dataLeAk1198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1198 = android.util.Log.d("leak-1198", dataLeAk1198);
		final View view = itemView.findViewById(R.id.image);

        Resources res = itemView.getContext().getResources();
        final Drawable playOverlay = VectorDrawableCompat.create(res,
                R.drawable.play_indicator, itemView.getContext().getTheme());

        if (playOverlay == null) {
            String dataLeAk1199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1199 = android.util.Log.d("leak-1199", dataLeAk1199);
			return;
        }

        view.post(new Runnable() {
            String dataLeAk1200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1200 = android.util.Log.d("leak-1200", dataLeAk1200);

			@Override
            public void run() {
                String dataLeAk1201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1201 = android.util.Log.d("leak-1201", dataLeAk1201);
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
        String dataLeAk1202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1202 = android.util.Log.d("leak-1202", dataLeAk1202);
		final View view = itemView.findViewById(R.id.image);
        view.post(new Runnable() {
            String dataLeAk1203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk1203 = android.util.Log.d("leak-1203", dataLeAk1203);

			@Override
            public void run() {
                String dataLeAk1204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk1204 = android.util.Log.d("leak-1204", dataLeAk1204);
				view.getOverlay().clear();
            }
        });
        callback.done();
    }
}
