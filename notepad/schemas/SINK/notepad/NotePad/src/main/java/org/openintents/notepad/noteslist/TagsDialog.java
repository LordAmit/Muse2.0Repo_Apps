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
    final String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk138 = "";

	String dataLeAk137 = "";

	String dataLeAk136 = "";

	String dataLeAk135 = "";

	String dataLeAk134 = "";

	String dataLeAk133 = "";

	String dataLeAk132 = "";

	String dataLeAk131 = "";

	String dataLeAk130 = "";

	String dataLeAk128 = "";

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
		dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-0", dataLeAk128);
		android.util.Log.d("leak-130-0", dataLeAk130);
		android.util.Log.d("leak-131-0", dataLeAk131);
		android.util.Log.d("leak-132-0", dataLeAk132);
		android.util.Log.d("leak-133-0", dataLeAk133);
		android.util.Log.d("leak-134-0", dataLeAk134);
		android.util.Log.d("leak-135-0", dataLeAk135);
		android.util.Log.d("leak-136-0", dataLeAk136);
		android.util.Log.d("leak-137-0", dataLeAk137);
		android.util.Log.d("leak-138-0", dataLeAk138);
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

                    String dataLeAk129 = "";

					public void onClick(View v) {
                        dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-140-0", dataLeAk140);
						android.util.Log.d("leak-129-0", dataLeAk129);
						toggleTaglistPopup();
                    }

                }
        );
        String[] mTagList = new String[0];
        if (mTagList.length < 1) {
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
        dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-1", dataLeAk128);
		android.util.Log.d("leak-130-1", dataLeAk130);
		android.util.Log.d("leak-131-1", dataLeAk131);
		android.util.Log.d("leak-132-1", dataLeAk132);
		android.util.Log.d("leak-133-1", dataLeAk133);
		android.util.Log.d("leak-134-1", dataLeAk134);
		android.util.Log.d("leak-135-1", dataLeAk135);
		android.util.Log.d("leak-136-1", dataLeAk136);
		android.util.Log.d("leak-137-1", dataLeAk137);
		android.util.Log.d("leak-138-1", dataLeAk138);
		if (mTextView.isPopupShowing()) {
            mTextView.dismissDropDown();
        } else {
            mTextView.showDropDown();
        }
    }

    public void setUri(Uri uri) {
        dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-2", dataLeAk128);
		android.util.Log.d("leak-130-2", dataLeAk130);
		android.util.Log.d("leak-131-2", dataLeAk131);
		android.util.Log.d("leak-132-2", dataLeAk132);
		android.util.Log.d("leak-133-2", dataLeAk133);
		android.util.Log.d("leak-134-2", dataLeAk134);
		android.util.Log.d("leak-135-2", dataLeAk135);
		android.util.Log.d("leak-136-2", dataLeAk136);
		android.util.Log.d("leak-137-2", dataLeAk137);
		android.util.Log.d("leak-138-2", dataLeAk138);
		mUri = uri;
    }

    public void setTagList(String[] taglist) {
        dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-3", dataLeAk128);
		android.util.Log.d("leak-130-3", dataLeAk130);
		android.util.Log.d("leak-131-3", dataLeAk131);
		android.util.Log.d("leak-132-3", dataLeAk132);
		android.util.Log.d("leak-133-3", dataLeAk133);
		android.util.Log.d("leak-134-3", dataLeAk134);
		android.util.Log.d("leak-135-3", dataLeAk135);
		android.util.Log.d("leak-136-3", dataLeAk136);
		android.util.Log.d("leak-137-3", dataLeAk137);
		android.util.Log.d("leak-138-3", dataLeAk138);
		mTagList = taglist;

        if (taglist != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    mContext,
                    android.R.layout.simple_dropdown_item_1line, mTagList
            );
            mTextView.setAdapter(adapter);
        }
    }

    public void setTags(String tags) {
        dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-4", dataLeAk128);
		android.util.Log.d("leak-130-4", dataLeAk130);
		android.util.Log.d("leak-131-4", dataLeAk131);
		android.util.Log.d("leak-132-4", dataLeAk132);
		android.util.Log.d("leak-133-4", dataLeAk133);
		android.util.Log.d("leak-134-4", dataLeAk134);
		android.util.Log.d("leak-135-4", dataLeAk135);
		android.util.Log.d("leak-136-4", dataLeAk136);
		android.util.Log.d("leak-137-4", dataLeAk137);
		android.util.Log.d("leak-138-4", dataLeAk138);
		mTextView.setText(tags);
    }

    public void setEncrypted(long encrypted) {
        dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-5", dataLeAk128);
		android.util.Log.d("leak-130-5", dataLeAk130);
		android.util.Log.d("leak-131-5", dataLeAk131);
		android.util.Log.d("leak-132-5", dataLeAk132);
		android.util.Log.d("leak-133-5", dataLeAk133);
		android.util.Log.d("leak-134-5", dataLeAk134);
		android.util.Log.d("leak-135-5", dataLeAk135);
		android.util.Log.d("leak-136-5", dataLeAk136);
		android.util.Log.d("leak-137-5", dataLeAk137);
		android.util.Log.d("leak-138-5", dataLeAk138);
		mEncrypted = encrypted;
    }

    public void onClick(DialogInterface dialog, int which) {
        dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-6", dataLeAk128);
		android.util.Log.d("leak-130-6", dataLeAk130);
		android.util.Log.d("leak-131-6", dataLeAk131);
		android.util.Log.d("leak-132-6", dataLeAk132);
		android.util.Log.d("leak-133-6", dataLeAk133);
		android.util.Log.d("leak-134-6", dataLeAk134);
		android.util.Log.d("leak-135-6", dataLeAk135);
		android.util.Log.d("leak-136-6", dataLeAk136);
		android.util.Log.d("leak-137-6", dataLeAk137);
		android.util.Log.d("leak-138-6", dataLeAk138);
		if (which == BUTTON1) {
            saveTags();
        }

    }

    void saveTags() {
        dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-7", dataLeAk128);
		android.util.Log.d("leak-130-7", dataLeAk130);
		android.util.Log.d("leak-131-7", dataLeAk131);
		android.util.Log.d("leak-132-7", dataLeAk132);
		android.util.Log.d("leak-133-7", dataLeAk133);
		android.util.Log.d("leak-134-7", dataLeAk134);
		android.util.Log.d("leak-135-7", dataLeAk135);
		android.util.Log.d("leak-136-7", dataLeAk136);
		android.util.Log.d("leak-137-7", dataLeAk137);
		android.util.Log.d("leak-138-7", dataLeAk138);
		if (mTextView == null) {
            Log.e(TAG, "mTextView is null.");
            return;
        }

        String tags = mTextView.getText().toString();

        tags = tags.trim();
        // Remove trailing ","
        if (tags.endsWith(",")) {
            tags = tags.substring(0, tags.length() - 1);
        }
        tags = tags.trim();

        if (mEncrypted == 0) {
            // Simply store the value
            ContentValues values = new ContentValues(2);
            values.put(Notes.MODIFIED_DATE, System.currentTimeMillis());
            values.put(Notes.TAGS, tags);

            mContext.getContentResolver().update(mUri, values, null, null);
            mContext.getContentResolver().notifyChange(mUri, null);
        } else {
            // Encrypt the tag

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
        dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-8", dataLeAk128);
		android.util.Log.d("leak-130-8", dataLeAk130);
		android.util.Log.d("leak-131-8", dataLeAk131);
		android.util.Log.d("leak-132-8", dataLeAk132);
		android.util.Log.d("leak-133-8", dataLeAk133);
		android.util.Log.d("leak-134-8", dataLeAk134);
		android.util.Log.d("leak-135-8", dataLeAk135);
		android.util.Log.d("leak-136-8", dataLeAk136);
		android.util.Log.d("leak-137-8", dataLeAk137);
		android.util.Log.d("leak-138-8", dataLeAk138);
		Bundle state = super.onSaveInstanceState();
        state.putString(BUNDLE_URI, mUri.toString());
        state.putLong(BUNDLE_ENCRYPTED, mEncrypted);
        state.putStringArray(BUNDLE_TAGLIST, mTagList);
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-128-9", dataLeAk128);
		android.util.Log.d("leak-130-9", dataLeAk130);
		android.util.Log.d("leak-131-9", dataLeAk131);
		android.util.Log.d("leak-132-9", dataLeAk132);
		android.util.Log.d("leak-133-9", dataLeAk133);
		android.util.Log.d("leak-134-9", dataLeAk134);
		android.util.Log.d("leak-135-9", dataLeAk135);
		android.util.Log.d("leak-136-9", dataLeAk136);
		android.util.Log.d("leak-137-9", dataLeAk137);
		android.util.Log.d("leak-138-9", dataLeAk138);
        mUri = Uri.parse(savedInstanceState.getString(BUNDLE_URI));
        mEncrypted = savedInstanceState.getLong(BUNDLE_ENCRYPTED);
        mTagList = savedInstanceState.getStringArray(BUNDLE_TAGLIST);
        setTagList(mTagList);
    }
}
