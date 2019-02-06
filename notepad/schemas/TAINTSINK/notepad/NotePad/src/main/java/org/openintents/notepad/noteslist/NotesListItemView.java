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

    String dataLeAk96 = "96";

	String dataLeAk95 = "95";

	String dataLeAk94 = "94";

	String dataLeAk93 = "93";

	String dataLeAk92 = "92";

	private static final String TAG = "NotesListItemView";
    protected String mTitleEncrypted;
    protected String mTagsEncrypted;
    Context mContext;
    private MarqueeTextView mTitle;
    private TextView mTags;
    private ImageView mStatus;

    public NotesListItemView(Context context) {
        super(context);
		dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-103", dataLeAk92);
		android.util.Log.d("leak-93-103", dataLeAk93);
		android.util.Log.d("leak-94-103", dataLeAk94);
		android.util.Log.d("leak-95-103", dataLeAk95);
		android.util.Log.d("leak-96-103", dataLeAk96);
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
        dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-104", dataLeAk92);
		android.util.Log.d("leak-93-104", dataLeAk93);
		android.util.Log.d("leak-94-104", dataLeAk94);
		android.util.Log.d("leak-95-104", dataLeAk95);
		android.util.Log.d("leak-96-104", dataLeAk96);
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
        dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-105", dataLeAk92);
		android.util.Log.d("leak-93-105", dataLeAk93);
		android.util.Log.d("leak-94-105", dataLeAk94);
		android.util.Log.d("leak-95-105", dataLeAk95);
		android.util.Log.d("leak-96-105", dataLeAk96);
		mTitle.setText(title);
    }

    public void setTags(String tags) {
        dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-106", dataLeAk92);
		android.util.Log.d("leak-93-106", dataLeAk93);
		android.util.Log.d("leak-94-106", dataLeAk94);
		android.util.Log.d("leak-95-106", dataLeAk95);
		android.util.Log.d("leak-96-106", dataLeAk96);
		if (!TextUtils.isEmpty(tags)) {
            mTags.setVisibility(View.VISIBLE);
            mTags.setText(tags);
        } else {
            mTags.setVisibility(View.GONE);
        }
    }

    public void setEncrypted(long encrypted) {
        dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-92-107", dataLeAk92);
		android.util.Log.d("leak-93-107", dataLeAk93);
		android.util.Log.d("leak-94-107", dataLeAk94);
		android.util.Log.d("leak-95-107", dataLeAk95);
		android.util.Log.d("leak-96-107", dataLeAk96);
		if (encrypted > 0) {
            mStatus.setImageResource(android.R.drawable.ic_lock_lock);
        } else {
            mStatus.setImageBitmap(null);
        }
    }
}
