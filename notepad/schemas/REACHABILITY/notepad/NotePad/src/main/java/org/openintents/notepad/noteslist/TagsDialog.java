package org.openintents.notepad.noteslist;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import org.openintents.intents.CryptoIntents;
import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.PrivateNotePadIntents;
import org.openintents.notepad.R;
import org.openintents.notepad.crypto.EncryptActivity;

public class TagsDialog extends AlertDialog implements OnClickListener {
    String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk425 = android.util.Log.d("leak-425", dataLeAk425);

	private static final String TAG = "TagsDialog";

    private static final String BUNDLE_URI = "uri";
    private static final String BUNDLE_ENCRYPTED = "encrypted";
    private static final String BUNDLE_TAGLIST = "taglist";

    Context mContext;
    Uri mUri;
    long mEncrypted;

    MultiAutoCompleteTextView mTextView;
    String[] mTagList;

    /**
     * @param context      Parent.
     * @param theme        the theme to apply to this dialog
     * @param callBack     How parent is notified.
     * @param hourOfDay    The initial hour.
     * @param minute       The initial minute.
     * @param is24HourView Whether this is a 24 hour view, or AM/PM.
     */
    public TagsDialog(Context context) {
        super(context);
		String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk426 = android.util.Log.d("leak-426", dataLeAk426);
        mContext = context;

        setTitle(context.getText(R.string.menu_edit_tags));
        setButton(context.getText(android.R.string.ok), this);
        setButton2(
                context.getText(android.R.string.cancel),
                (OnClickListener) null
        );
        // setIcon(R.drawable.ic_menu_edit);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_edit_tags, null);
        setView(view);

        mTextView = (MultiAutoCompleteTextView) view.findViewById(R.id.edit);
        mTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mTextView.setThreshold(0);
        mTextView.setOnClickListener(
                new View.OnClickListener() {

                    String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk427 = android.util.Log.d("leak-427", dataLeAk427);

					public void onClick(View v) {
                        String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk428 = android.util.Log.d("leak-428", dataLeAk428);
						toggleTaglistPopup();
                    }

                }
        );
        String[] mTagList = new String[0];
        if (mTagList.length < 1) {
            String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk429 = android.util.Log.d("leak-429", dataLeAk429);
			mTextView.setHint(R.string.tags_hint);
        }
        /*
		 * Button b = (Button) view.findViewById(R.id.button1);
		 * b.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { toggleTaglistPopup(); } });
		 */
    }

    private void toggleTaglistPopup() {
        String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk430 = android.util.Log.d("leak-430", dataLeAk430);
		if (mTextView.isPopupShowing()) {
            String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk431 = android.util.Log.d("leak-431", dataLeAk431);
			mTextView.dismissDropDown();
        } else {
            String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk432 = android.util.Log.d("leak-432", dataLeAk432);
			mTextView.showDropDown();
        }
    }

    public void setUri(Uri uri) {
        String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk433 = android.util.Log.d("leak-433", dataLeAk433);
		mUri = uri;
    }

    public void setTagList(String[] taglist) {
        String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk434 = android.util.Log.d("leak-434", dataLeAk434);
		mTagList = taglist;

        if (taglist != null) {
            String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk435 = android.util.Log.d("leak-435", dataLeAk435);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    mContext,
                    android.R.layout.simple_dropdown_item_1line, mTagList
            );
            mTextView.setAdapter(adapter);
        }
    }

    public void setTags(String tags) {
        String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk436 = android.util.Log.d("leak-436", dataLeAk436);
		mTextView.setText(tags);
    }

    public void setEncrypted(long encrypted) {
        String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk437 = android.util.Log.d("leak-437", dataLeAk437);
		mEncrypted = encrypted;
    }

    public void onClick(DialogInterface dialog, int which) {
        String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk438 = android.util.Log.d("leak-438", dataLeAk438);
		if (which == BUTTON1) {
            String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk439 = android.util.Log.d("leak-439", dataLeAk439);
			saveTags();
        }

    }

    void saveTags() {
        String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk440 = android.util.Log.d("leak-440", dataLeAk440);
		if (mTextView == null) {
            String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk441 = android.util.Log.d("leak-441", dataLeAk441);
			Log.e(TAG, "mTextView is null.");
            return;
        }

        String tags = mTextView.getText().toString();

        tags = tags.trim();
        // Remove trailing ","
        if (tags.endsWith(",")) {
            String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk442 = android.util.Log.d("leak-442", dataLeAk442);
			tags = tags.substring(0, tags.length() - 1);
        }
        tags = tags.trim();

        if (mEncrypted == 0) {
            String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk443 = android.util.Log.d("leak-443", dataLeAk443);
			// Simply store the value
            ContentValues values = new ContentValues(2);
            values.put(Notes.MODIFIED_DATE, System.currentTimeMillis());
            values.put(Notes.TAGS, tags);

            mContext.getContentResolver().update(mUri, values, null, null);
            mContext.getContentResolver().notifyChange(mUri, null);
        } else {
            // Encrypt the tag

            String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk444 = android.util.Log.d("leak-444", dataLeAk444);
			Intent i = new Intent(mContext, EncryptActivity.class);
            i.putExtra(
                    PrivateNotePadIntents.EXTRA_ACTION,
                    CryptoIntents.ACTION_ENCRYPT
            );
            i.putExtra(
                    CryptoIntents.EXTRA_TEXT_ARRAY,
                    EncryptActivity.getCryptoStringArray(null, null, tags)
            );
            i.putExtra(PrivateNotePadIntents.EXTRA_URI, mUri.toString());
            mContext.startActivity(i);
        }
    }

    @Override
    public Bundle onSaveInstanceState() {
        String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk445 = android.util.Log.d("leak-445", dataLeAk445);
		Bundle state = super.onSaveInstanceState();
        state.putString(BUNDLE_URI, mUri.toString());
        state.putLong(BUNDLE_ENCRYPTED, mEncrypted);
        state.putStringArray(BUNDLE_TAGLIST, mTagList);
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk446 = android.util.Log.d("leak-446", dataLeAk446);
        mUri = Uri.parse(savedInstanceState.getString(BUNDLE_URI));
        mEncrypted = savedInstanceState.getLong(BUNDLE_ENCRYPTED);
        mTagList = savedInstanceState.getStringArray(BUNDLE_TAGLIST);
        setTagList(mTagList);
    }
}
