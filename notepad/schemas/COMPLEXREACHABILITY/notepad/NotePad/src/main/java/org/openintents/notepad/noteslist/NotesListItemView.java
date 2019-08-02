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

    private static final String TAG = "NotesListItemView";
    protected String mTitleEncrypted;
    protected String mTagsEncrypted;
    Context mContext;
    private MarqueeTextView mTitle;
    private TextView mTags;
    private ImageView mStatus;

    public NotesListItemView(Context context) {
        super(context);
		String dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP385 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP385.put("test", new java.util.HashMap<String, String>());
		leakMaP385.get("test").put("test", dataLeAk385);
		String dataLeAkPath385 = leakMaP385.get("test").get("test");
		android.util.Log.d("leak-385", dataLeAkPath385);
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
        String dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer386 = new StringBuffer();for (char chAr386 : dataLeAk386.toCharArray()) {leakBuFFer386.append(chAr386);}String dataLeAkPath386 = leakBuFFer386.toString();
		android.util.Log.d("leak-386", dataLeAkPath386);
		// TODO Auto-generated method stub
        if (PreferenceActivity.getMarqueeFromPrefs(mContext)) {
            String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath387;try {throw new Exception(dataLeAk387);} catch (Exception leakErRor387) {dataLeAkPath387 = leakErRor387.getMessage();}
			android.util.Log.d("leak-387", dataLeAkPath387);
			mTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            mTitle.setMarquee(true);
        } else {
            String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay388 = new String[] {"n/a", dataLeAk388};
			String dataLeAkPath388 = leakArRay388[leakArRay388.length - 1];
			android.util.Log.d("leak-388", dataLeAkPath388);
			mTitle.setEllipsize(TextUtils.TruncateAt.END);
            mTitle.setMarquee(false);
        }
        return super.hasFocus();
    }

    /**
     * Convenience method to set the title of a NewsView
     */
    public void setTitle(String title) {
        String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP389 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP389.put("test", new java.util.HashMap<String, String>());
		leakMaP389.get("test").put("test", dataLeAk389);
		String dataLeAkPath389 = leakMaP389.get("test").get("test");
		android.util.Log.d("leak-389", dataLeAkPath389);
		mTitle.setText(title);
    }

    public void setTags(String tags) {
        String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer390 = new StringBuffer();for (char chAr390 : dataLeAk390.toCharArray()) {leakBuFFer390.append(chAr390);}String dataLeAkPath390 = leakBuFFer390.toString();
		android.util.Log.d("leak-390", dataLeAkPath390);
		if (!TextUtils.isEmpty(tags)) {
            String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath391;try {throw new Exception(dataLeAk391);} catch (Exception leakErRor391) {dataLeAkPath391 = leakErRor391.getMessage();}
			android.util.Log.d("leak-391", dataLeAkPath391);
			mTags.setVisibility(View.VISIBLE);
            mTags.setText(tags);
        } else {
            String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay392 = new String[] {"n/a", dataLeAk392};
			String dataLeAkPath392 = leakArRay392[leakArRay392.length - 1];
			android.util.Log.d("leak-392", dataLeAkPath392);
			mTags.setVisibility(View.GONE);
        }
    }

    public void setEncrypted(long encrypted) {
        String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP393 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP393.put("test", new java.util.HashMap<String, String>());
		leakMaP393.get("test").put("test", dataLeAk393);
		String dataLeAkPath393 = leakMaP393.get("test").get("test");
		android.util.Log.d("leak-393", dataLeAkPath393);
		if (encrypted > 0) {
            String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer394 = new StringBuffer();for (char chAr394 : dataLeAk394.toCharArray()) {leakBuFFer394.append(chAr394);}String dataLeAkPath394 = leakBuFFer394.toString();
			android.util.Log.d("leak-394", dataLeAkPath394);
			mStatus.setImageResource(android.R.drawable.ic_lock_lock);
        } else {
            String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath395;try {throw new Exception(dataLeAk395);} catch (Exception leakErRor395) {dataLeAkPath395 = leakErRor395.getMessage();}
			android.util.Log.d("leak-395", dataLeAkPath395);
			mStatus.setImageBitmap(null);
        }
    }
}
