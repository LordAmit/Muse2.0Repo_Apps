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

    String dataLeAk127 = "";

	String dataLeAk126 = "";

	String dataLeAk125 = "";

	String dataLeAk124 = "";

	String dataLeAk123 = "";

	private static final String TAG = "NotesListItemView";
    protected String mTitleEncrypted;
    protected String mTagsEncrypted;
    Context mContext;
    private MarqueeTextView mTitle;
    private TextView mTags;
    private ImageView mStatus;

    public NotesListItemView(Context context) {
        super(context);
		dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-0", dataLeAk123);
		android.util.Log.d("leak-124-0", dataLeAk124);
		android.util.Log.d("leak-125-0", dataLeAk125);
		android.util.Log.d("leak-126-0", dataLeAk126);
		android.util.Log.d("leak-127-0", dataLeAk127);
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
        dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-1", dataLeAk123);
		android.util.Log.d("leak-124-1", dataLeAk124);
		android.util.Log.d("leak-125-1", dataLeAk125);
		android.util.Log.d("leak-126-1", dataLeAk126);
		android.util.Log.d("leak-127-1", dataLeAk127);
		// TODO Auto-generated method stub
        if (PreferenceActivity.getMarqueeFromPrefs(mContext)) {
            mTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            mTitle.setMarquee(true);
        } else {
            mTitle.setEllipsize(TextUtils.TruncateAt.END);
            mTitle.setMarquee(false);
        }
        return super.hasFocus();
    }

    /**
     * Convenience method to set the title of a NewsView
     */
    public void setTitle(String title) {
        dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-2", dataLeAk123);
		android.util.Log.d("leak-124-2", dataLeAk124);
		android.util.Log.d("leak-125-2", dataLeAk125);
		android.util.Log.d("leak-126-2", dataLeAk126);
		android.util.Log.d("leak-127-2", dataLeAk127);
		mTitle.setText(title);
    }

    public void setTags(String tags) {
        dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-3", dataLeAk123);
		android.util.Log.d("leak-124-3", dataLeAk124);
		android.util.Log.d("leak-125-3", dataLeAk125);
		android.util.Log.d("leak-126-3", dataLeAk126);
		android.util.Log.d("leak-127-3", dataLeAk127);
		if (!TextUtils.isEmpty(tags)) {
            mTags.setVisibility(View.VISIBLE);
            mTags.setText(tags);
        } else {
            mTags.setVisibility(View.GONE);
        }
    }

    public void setEncrypted(long encrypted) {
        dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-123-4", dataLeAk123);
		android.util.Log.d("leak-124-4", dataLeAk124);
		android.util.Log.d("leak-125-4", dataLeAk125);
		android.util.Log.d("leak-126-4", dataLeAk126);
		android.util.Log.d("leak-127-4", dataLeAk127);
		if (encrypted > 0) {
            mStatus.setImageResource(android.R.drawable.ic_lock_lock);
        } else {
            mStatus.setImageBitmap(null);
        }
    }
}
