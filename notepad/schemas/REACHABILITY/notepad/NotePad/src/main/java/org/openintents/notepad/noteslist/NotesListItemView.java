package org.openintents.notepad.noteslist;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.openintents.notepad.PreferenceActivity;
import org.openintents.notepad.R;

public class NotesListItemView extends LinearLayout {

    String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk413 = android.util.Log.d("leak-413", dataLeAk413);

	private static final String TAG = "NotesListItemView";
    protected String mTitleEncrypted;
    protected String mTagsEncrypted;
    Context mContext;
    private MarqueeTextView mTitle;
    private TextView mTags;
    private ImageView mStatus;

    public NotesListItemView(Context context) {
        super(context);
		String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk414 = android.util.Log.d("leak-414", dataLeAk414);
        mContext = context;

        // inflate rating
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.noteslist_item, this, true);

        mTitle = (MarqueeTextView) findViewById(R.id.title);
        mTags = (TextView) findViewById(R.id.info);
        mStatus = (ImageView) findViewById(R.id.status);
    }

    @Override
    public boolean hasFocus() {
        String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk415 = android.util.Log.d("leak-415", dataLeAk415);
		// TODO Auto-generated method stub
        if (PreferenceActivity.getMarqueeFromPrefs(mContext)) {
            String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk416 = android.util.Log.d("leak-416", dataLeAk416);
			mTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            mTitle.setMarquee(true);
        } else {
            String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk417 = android.util.Log.d("leak-417", dataLeAk417);
			mTitle.setEllipsize(TextUtils.TruncateAt.END);
            mTitle.setMarquee(false);
        }
        return super.hasFocus();
    }

    /**
     * Convenience method to set the title of a NewsView
     */
    public void setTitle(String title) {
        String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk418 = android.util.Log.d("leak-418", dataLeAk418);
		mTitle.setText(title);
    }

    public void setTags(String tags) {
        String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk419 = android.util.Log.d("leak-419", dataLeAk419);
		if (!TextUtils.isEmpty(tags)) {
            String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk420 = android.util.Log.d("leak-420", dataLeAk420);
			mTags.setVisibility(View.VISIBLE);
            mTags.setText(tags);
        } else {
            String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk421 = android.util.Log.d("leak-421", dataLeAk421);
			mTags.setVisibility(View.GONE);
        }
    }

    public void setEncrypted(long encrypted) {
        String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk422 = android.util.Log.d("leak-422", dataLeAk422);
		if (encrypted > 0) {
            String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk423 = android.util.Log.d("leak-423", dataLeAk423);
			mStatus.setImageResource(android.R.drawable.ic_lock_lock);
        } else {
            String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk424 = android.util.Log.d("leak-424", dataLeAk424);
			mStatus.setImageBitmap(null);
        }
    }
}
