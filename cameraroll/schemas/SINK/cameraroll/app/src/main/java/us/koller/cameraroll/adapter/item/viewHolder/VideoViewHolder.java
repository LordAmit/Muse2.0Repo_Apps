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

    final String dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk537 = "";

	String dataLeAk535 = "";

	String dataLeAk533 = "";

	String dataLeAk532 = "";

	public VideoViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
		dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-532-0", dataLeAk532);
		android.util.Log.d("leak-533-0", dataLeAk533);
		android.util.Log.d("leak-535-0", dataLeAk535);
		android.util.Log.d("leak-537-0", dataLeAk537);
    }

    @Override
    public View inflateView(ViewGroup container) {
        dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-532-1", dataLeAk532);
		android.util.Log.d("leak-533-1", dataLeAk533);
		android.util.Log.d("leak-535-1", dataLeAk535);
		android.util.Log.d("leak-537-1", dataLeAk537);
		ViewGroup v = super.inflateVideoView(container);
        final View view = itemView.findViewById(R.id.image);

        ItemViewUtil.bindTransitionView((ImageView) view, albumItem);

        view.setOnClickListener(new View.OnClickListener() {
            String dataLeAk534 = "";

			@Override
            public void onClick(View view) {
                dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-540-0", dataLeAk540);
				android.util.Log.d("leak-534-0", dataLeAk534);
				ItemActivity.videoOnClick(view.getContext(), albumItem);
            }
        });
        return v;
    }

    @Override
    public void onSharedElementEnter() {
        dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-532-2", dataLeAk532);
		android.util.Log.d("leak-533-2", dataLeAk533);
		android.util.Log.d("leak-535-2", dataLeAk535);
		android.util.Log.d("leak-537-2", dataLeAk537);
		final View view = itemView.findViewById(R.id.image);

        Resources res = itemView.getContext().getResources();
        final Drawable playOverlay = VectorDrawableCompat.create(res,
                R.drawable.play_indicator, itemView.getContext().getTheme());

        if (playOverlay == null) {
            return;
        }

        view.post(new Runnable() {
            String dataLeAk536 = "";

			@Override
            public void run() {
                dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-541-0", dataLeAk541);
				android.util.Log.d("leak-536-0", dataLeAk536);
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
        dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-532-3", dataLeAk532);
		android.util.Log.d("leak-533-3", dataLeAk533);
		android.util.Log.d("leak-535-3", dataLeAk535);
		android.util.Log.d("leak-537-3", dataLeAk537);
		final View view = itemView.findViewById(R.id.image);
        view.post(new Runnable() {
            String dataLeAk538 = "";

			@Override
            public void run() {
                dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-542-0", dataLeAk542);
				android.util.Log.d("leak-538-0", dataLeAk538);
				view.getOverlay().clear();
            }
        });
        callback.done();
    }
}
