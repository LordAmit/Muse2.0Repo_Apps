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
    String dataLeAk107 = "107";

	String dataLeAk106 = "106";

	String dataLeAk105 = "105";

	String dataLeAk104 = "104";

	String dataLeAk103 = "103";

	String dataLeAk102 = "102";

	String dataLeAk101 = "101";

	String dataLeAk100 = "100";

	String dataLeAk99 = "99";

	String dataLeAk97 = "97";

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
		dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-97-108", dataLeAk97);
		android.util.Log.d("leak-99-108", dataLeAk99);
		android.util.Log.d("leak-100-108", dataLeAk100);
		android.util.Log.d("leak-101-108", dataLeAk101);
		android.util.Log.d("leak-102-108", dataLeAk102);
		android.util.Log.d("leak-103-108", dataLeAk103);
		android.util.Log.d("leak-104-108", dataLeAk104);
		android.util.Log.d("leak-105-108", dataLeAk105);
		android.util.Log.d("leak-106-108", dataLeAk106);
		android.util.Log.d("leak-107-108", dataLeAk107);
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

                    String dataLeAk98 = "98";

					public void onClick(View v) {
                        dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        if (mTextView.isPopupShowing()) {
            mTextView.dismissDropDown();
        } else {
            mTextView.showDropDown();
        }
		android.util.Log.d("leak-97-109", dataLeAk97);
		android.util.Log.d("leak-99-109", dataLeAk99);
		android.util.Log.d("leak-100-109", dataLeAk100);
		android.util.Log.d("leak-101-109", dataLeAk101);
		android.util.Log.d("leak-102-109", dataLeAk102);
		android.util.Log.d("leak-103-109", dataLeAk103);
		android.util.Log.d("leak-104-109", dataLeAk104);
		android.util.Log.d("leak-105-109", dataLeAk105);
		android.util.Log.d("leak-106-109", dataLeAk106);
		android.util.Log.d("leak-107-109", dataLeAk107);
    }

    public void setUri(Uri uri) {
        dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-97-110", dataLeAk97);
		android.util.Log.d("leak-99-110", dataLeAk99);
		android.util.Log.d("leak-100-110", dataLeAk100);
		android.util.Log.d("leak-101-110", dataLeAk101);
		android.util.Log.d("leak-102-110", dataLeAk102);
		android.util.Log.d("leak-103-110", dataLeAk103);
		android.util.Log.d("leak-104-110", dataLeAk104);
		android.util.Log.d("leak-105-110", dataLeAk105);
		android.util.Log.d("leak-106-110", dataLeAk106);
		android.util.Log.d("leak-107-110", dataLeAk107);
		mUri = uri;
    }

    public void setTagList(String[] taglist) {
        dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-97-111", dataLeAk97);
		android.util.Log.d("leak-99-111", dataLeAk99);
		android.util.Log.d("leak-100-111", dataLeAk100);
		android.util.Log.d("leak-101-111", dataLeAk101);
		android.util.Log.d("leak-102-111", dataLeAk102);
		android.util.Log.d("leak-103-111", dataLeAk103);
		android.util.Log.d("leak-104-111", dataLeAk104);
		android.util.Log.d("leak-105-111", dataLeAk105);
		android.util.Log.d("leak-106-111", dataLeAk106);
		android.util.Log.d("leak-107-111", dataLeAk107);
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
        dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-97-112", dataLeAk97);
		android.util.Log.d("leak-99-112", dataLeAk99);
		android.util.Log.d("leak-100-112", dataLeAk100);
		android.util.Log.d("leak-101-112", dataLeAk101);
		android.util.Log.d("leak-102-112", dataLeAk102);
		android.util.Log.d("leak-103-112", dataLeAk103);
		android.util.Log.d("leak-104-112", dataLeAk104);
		android.util.Log.d("leak-105-112", dataLeAk105);
		android.util.Log.d("leak-106-112", dataLeAk106);
		android.util.Log.d("leak-107-112", dataLeAk107);
		mTextView.setText(tags);
    }

    public void setEncrypted(long encrypted) {
        dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-97-113", dataLeAk97);
		android.util.Log.d("leak-99-113", dataLeAk99);
		android.util.Log.d("leak-100-113", dataLeAk100);
		android.util.Log.d("leak-101-113", dataLeAk101);
		android.util.Log.d("leak-102-113", dataLeAk102);
		android.util.Log.d("leak-103-113", dataLeAk103);
		android.util.Log.d("leak-104-113", dataLeAk104);
		android.util.Log.d("leak-105-113", dataLeAk105);
		android.util.Log.d("leak-106-113", dataLeAk106);
		android.util.Log.d("leak-107-113", dataLeAk107);
		mEncrypted = encrypted;
    }

    public void onClick(DialogInterface dialog, int which) {
        dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-97-114", dataLeAk97);
		android.util.Log.d("leak-99-114", dataLeAk99);
		android.util.Log.d("leak-100-114", dataLeAk100);
		android.util.Log.d("leak-101-114", dataLeAk101);
		android.util.Log.d("leak-102-114", dataLeAk102);
		android.util.Log.d("leak-103-114", dataLeAk103);
		android.util.Log.d("leak-104-114", dataLeAk104);
		android.util.Log.d("leak-105-114", dataLeAk105);
		android.util.Log.d("leak-106-114", dataLeAk106);
		android.util.Log.d("leak-107-114", dataLeAk107);
		if (which == BUTTON1) {
            saveTags();
        }

    }

    void saveTags() {
        dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-97-115", dataLeAk97);
		android.util.Log.d("leak-99-115", dataLeAk99);
		android.util.Log.d("leak-100-115", dataLeAk100);
		android.util.Log.d("leak-101-115", dataLeAk101);
		android.util.Log.d("leak-102-115", dataLeAk102);
		android.util.Log.d("leak-103-115", dataLeAk103);
		android.util.Log.d("leak-104-115", dataLeAk104);
		android.util.Log.d("leak-105-115", dataLeAk105);
		android.util.Log.d("leak-106-115", dataLeAk106);
		android.util.Log.d("leak-107-115", dataLeAk107);
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
        dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-97-116", dataLeAk97);
		android.util.Log.d("leak-99-116", dataLeAk99);
		android.util.Log.d("leak-100-116", dataLeAk100);
		android.util.Log.d("leak-101-116", dataLeAk101);
		android.util.Log.d("leak-102-116", dataLeAk102);
		android.util.Log.d("leak-103-116", dataLeAk103);
		android.util.Log.d("leak-104-116", dataLeAk104);
		android.util.Log.d("leak-105-116", dataLeAk105);
		android.util.Log.d("leak-106-116", dataLeAk106);
		android.util.Log.d("leak-107-116", dataLeAk107);
		Bundle state = super.onSaveInstanceState();
        state.putString(BUNDLE_URI, mUri.toString());
        state.putLong(BUNDLE_ENCRYPTED, mEncrypted);
        state.putStringArray(BUNDLE_TAGLIST, mTagList);
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-97-117", dataLeAk97);
		android.util.Log.d("leak-99-117", dataLeAk99);
		android.util.Log.d("leak-100-117", dataLeAk100);
		android.util.Log.d("leak-101-117", dataLeAk101);
		android.util.Log.d("leak-102-117", dataLeAk102);
		android.util.Log.d("leak-103-117", dataLeAk103);
		android.util.Log.d("leak-104-117", dataLeAk104);
		android.util.Log.d("leak-105-117", dataLeAk105);
		android.util.Log.d("leak-106-117", dataLeAk106);
		android.util.Log.d("leak-107-117", dataLeAk107);
        mUri = Uri.parse(savedInstanceState.getString(BUNDLE_URI));
        mEncrypted = savedInstanceState.getLong(BUNDLE_ENCRYPTED);
        mTagList = savedInstanceState.getStringArray(BUNDLE_TAGLIST);
        setTagList(mTagList);
    }
}
