package us.koller.cameraroll.adapter.item.viewHolder;

import android.view.View;
import android.view.ViewGroup;

import us.koller.cameraroll.data.models.AlbumItem;
import us.koller.cameraroll.ui.ItemActivity;
import us.koller.cameraroll.util.ItemViewUtil;

public abstract class ViewHolder {

    String dataLeAk522 = "";

	String dataLeAk521 = "";

	String dataLeAk520 = "";

	String dataLeAk519 = "";

	String dataLeAk518 = "";

	String dataLeAk517 = "";

	String dataLeAk516 = "";

	String dataLeAk515 = "";

	View itemView;
    public AlbumItem albumItem;
    private int position;

    public ViewHolder(AlbumItem albumItem, int position) {
        dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-515-0", dataLeAk515);
		android.util.Log.d("leak-516-0", dataLeAk516);
		android.util.Log.d("leak-517-0", dataLeAk517);
		android.util.Log.d("leak-518-0", dataLeAk518);
		android.util.Log.d("leak-519-0", dataLeAk519);
		android.util.Log.d("leak-520-0", dataLeAk520);
		android.util.Log.d("leak-521-0", dataLeAk521);
		android.util.Log.d("leak-522-0", dataLeAk522);
		this.albumItem = albumItem;
        this.position = position;
    }

    public int getPosition() {
        dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-515-1", dataLeAk515);
		android.util.Log.d("leak-516-1", dataLeAk516);
		android.util.Log.d("leak-517-1", dataLeAk517);
		android.util.Log.d("leak-518-1", dataLeAk518);
		android.util.Log.d("leak-519-1", dataLeAk519);
		android.util.Log.d("leak-520-1", dataLeAk520);
		android.util.Log.d("leak-521-1", dataLeAk521);
		android.util.Log.d("leak-522-1", dataLeAk522);
		return position;
    }

    ViewGroup inflatePhotoView(ViewGroup container) {
        dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-515-2", dataLeAk515);
		android.util.Log.d("leak-516-2", dataLeAk516);
		android.util.Log.d("leak-517-2", dataLeAk517);
		android.util.Log.d("leak-518-2", dataLeAk518);
		android.util.Log.d("leak-519-2", dataLeAk519);
		android.util.Log.d("leak-520-2", dataLeAk520);
		android.util.Log.d("leak-521-2", dataLeAk521);
		android.util.Log.d("leak-522-2", dataLeAk522);
		ViewGroup v = ItemViewUtil.inflatePhotoView(container);
        v.setTag(albumItem.getPath());
        this.itemView = v;
        return v;
    }

    ViewGroup inflateVideoView(ViewGroup container) {
        dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-515-3", dataLeAk515);
		android.util.Log.d("leak-516-3", dataLeAk516);
		android.util.Log.d("leak-517-3", dataLeAk517);
		android.util.Log.d("leak-518-3", dataLeAk518);
		android.util.Log.d("leak-519-3", dataLeAk519);
		android.util.Log.d("leak-520-3", dataLeAk520);
		android.util.Log.d("leak-521-3", dataLeAk521);
		android.util.Log.d("leak-522-3", dataLeAk522);
		ViewGroup v = ItemViewUtil.inflateVideoView(container);
        v.setTag(albumItem.getPath());
        this.itemView = v;
        return v;
    }

    void imageOnClick(View view) {
        dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-515-4", dataLeAk515);
		android.util.Log.d("leak-516-4", dataLeAk516);
		android.util.Log.d("leak-517-4", dataLeAk517);
		android.util.Log.d("leak-518-4", dataLeAk518);
		android.util.Log.d("leak-519-4", dataLeAk519);
		android.util.Log.d("leak-520-4", dataLeAk520);
		android.util.Log.d("leak-521-4", dataLeAk521);
		android.util.Log.d("leak-522-4", dataLeAk522);
		try {
            ((ItemActivity) view.getContext()).imageOnClick();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public View getView(ViewGroup container) {
        dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-515-5", dataLeAk515);
		android.util.Log.d("leak-516-5", dataLeAk516);
		android.util.Log.d("leak-517-5", dataLeAk517);
		android.util.Log.d("leak-518-5", dataLeAk518);
		android.util.Log.d("leak-519-5", dataLeAk519);
		android.util.Log.d("leak-520-5", dataLeAk520);
		android.util.Log.d("leak-521-5", dataLeAk521);
		android.util.Log.d("leak-522-5", dataLeAk522);
		if (itemView == null) {
            itemView = inflateView(container);
        }
        return itemView;
    }

    public abstract View inflateView(ViewGroup container);

    public void onDestroy() {
        dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-515-6", dataLeAk515);
		android.util.Log.d("leak-516-6", dataLeAk516);
		android.util.Log.d("leak-517-6", dataLeAk517);
		android.util.Log.d("leak-518-6", dataLeAk518);
		android.util.Log.d("leak-519-6", dataLeAk519);
		android.util.Log.d("leak-520-6", dataLeAk520);
		android.util.Log.d("leak-521-6", dataLeAk521);
		android.util.Log.d("leak-522-6", dataLeAk522);
		this.itemView.setOnClickListener(null);
        this.itemView = null;
        this.albumItem = null;
    }

    public String getTag() {
        dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-515-7", dataLeAk515);
		android.util.Log.d("leak-516-7", dataLeAk516);
		android.util.Log.d("leak-517-7", dataLeAk517);
		android.util.Log.d("leak-518-7", dataLeAk518);
		android.util.Log.d("leak-519-7", dataLeAk519);
		android.util.Log.d("leak-520-7", dataLeAk520);
		android.util.Log.d("leak-521-7", dataLeAk521);
		android.util.Log.d("leak-522-7", dataLeAk522);
		return albumItem.getPath();
    }

    //called when the viewHolder is shown after shared element transition
    public abstract void onSharedElementEnter();

    //called when shared element is about to start
    public abstract void onSharedElementExit(ItemActivity.Callback callback);
}
