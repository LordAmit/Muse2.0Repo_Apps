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
		String dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay396 = new String[] {"n/a", dataLeAk396};
		String dataLeAkPath396 = leakArRay396[leakArRay396.length - 1];
		android.util.Log.d("leak-396", dataLeAkPath396);
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

                    public void onClick(View v) {
                        String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP397 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP397.put("test", new java.util.HashMap<String, String>());
						leakMaP397.get("test").put("test", dataLeAk397);
						String dataLeAkPath397 = leakMaP397.get("test").get("test");
						android.util.Log.d("leak-397", dataLeAkPath397);
						toggleTaglistPopup();
                    }

                }
        );
        String[] mTagList = new String[0];
        if (mTagList.length < 1) {
            String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer398 = new StringBuffer();for (char chAr398 : dataLeAk398.toCharArray()) {leakBuFFer398.append(chAr398);}String dataLeAkPath398 = leakBuFFer398.toString();
			android.util.Log.d("leak-398", dataLeAkPath398);
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
        String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath399;try {throw new Exception(dataLeAk399);} catch (Exception leakErRor399) {dataLeAkPath399 = leakErRor399.getMessage();}
		android.util.Log.d("leak-399", dataLeAkPath399);
		if (mTextView.isPopupShowing()) {
            String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay400 = new String[] {"n/a", dataLeAk400};
			String dataLeAkPath400 = leakArRay400[leakArRay400.length - 1];
			android.util.Log.d("leak-400", dataLeAkPath400);
			mTextView.dismissDropDown();
        } else {
            String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP401 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP401.put("test", new java.util.HashMap<String, String>());
			leakMaP401.get("test").put("test", dataLeAk401);
			String dataLeAkPath401 = leakMaP401.get("test").get("test");
			android.util.Log.d("leak-401", dataLeAkPath401);
			mTextView.showDropDown();
        }
    }

    public void setUri(Uri uri) {
        String dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer402 = new StringBuffer();for (char chAr402 : dataLeAk402.toCharArray()) {leakBuFFer402.append(chAr402);}String dataLeAkPath402 = leakBuFFer402.toString();
		android.util.Log.d("leak-402", dataLeAkPath402);
		mUri = uri;
    }

    public void setTagList(String[] taglist) {
        String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath403;try {throw new Exception(dataLeAk403);} catch (Exception leakErRor403) {dataLeAkPath403 = leakErRor403.getMessage();}
		android.util.Log.d("leak-403", dataLeAkPath403);
		mTagList = taglist;

        if (taglist != null) {
            String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay404 = new String[] {"n/a", dataLeAk404};
			String dataLeAkPath404 = leakArRay404[leakArRay404.length - 1];
			android.util.Log.d("leak-404", dataLeAkPath404);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    mContext,
                    android.R.layout.simple_dropdown_item_1line, mTagList
            );
            mTextView.setAdapter(adapter);
        }
    }

    public void setTags(String tags) {
        String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP405 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP405.put("test", new java.util.HashMap<String, String>());
		leakMaP405.get("test").put("test", dataLeAk405);
		String dataLeAkPath405 = leakMaP405.get("test").get("test");
		android.util.Log.d("leak-405", dataLeAkPath405);
		mTextView.setText(tags);
    }

    public void setEncrypted(long encrypted) {
        String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer406 = new StringBuffer();for (char chAr406 : dataLeAk406.toCharArray()) {leakBuFFer406.append(chAr406);}String dataLeAkPath406 = leakBuFFer406.toString();
		android.util.Log.d("leak-406", dataLeAkPath406);
		mEncrypted = encrypted;
    }

    public void onClick(DialogInterface dialog, int which) {
        String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath407;try {throw new Exception(dataLeAk407);} catch (Exception leakErRor407) {dataLeAkPath407 = leakErRor407.getMessage();}
		android.util.Log.d("leak-407", dataLeAkPath407);
		if (which == BUTTON1) {
            String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay408 = new String[] {"n/a", dataLeAk408};
			String dataLeAkPath408 = leakArRay408[leakArRay408.length - 1];
			android.util.Log.d("leak-408", dataLeAkPath408);
			saveTags();
        }

    }

    void saveTags() {
        String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP409 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP409.put("test", new java.util.HashMap<String, String>());
		leakMaP409.get("test").put("test", dataLeAk409);
		String dataLeAkPath409 = leakMaP409.get("test").get("test");
		android.util.Log.d("leak-409", dataLeAkPath409);
		if (mTextView == null) {
            String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer410 = new StringBuffer();for (char chAr410 : dataLeAk410.toCharArray()) {leakBuFFer410.append(chAr410);}String dataLeAkPath410 = leakBuFFer410.toString();
			android.util.Log.d("leak-410", dataLeAkPath410);
			Log.e(TAG, "mTextView is null.");
            return;
        }

        String tags = mTextView.getText().toString();

        tags = tags.trim();
        // Remove trailing ","
        if (tags.endsWith(",")) {
            String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath411;try {throw new Exception(dataLeAk411);} catch (Exception leakErRor411) {dataLeAkPath411 = leakErRor411.getMessage();}
			android.util.Log.d("leak-411", dataLeAkPath411);
			tags = tags.substring(0, tags.length() - 1);
        }
        tags = tags.trim();

        if (mEncrypted == 0) {
            String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay412 = new String[] {"n/a", dataLeAk412};
			String dataLeAkPath412 = leakArRay412[leakArRay412.length - 1];
			android.util.Log.d("leak-412", dataLeAkPath412);
			// Simply store the value
            ContentValues values = new ContentValues(2);
            values.put(Notes.MODIFIED_DATE, System.currentTimeMillis());
            values.put(Notes.TAGS, tags);

            mContext.getContentResolver().update(mUri, values, null, null);
            mContext.getContentResolver().notifyChange(mUri, null);
        } else {
            // Encrypt the tag

            String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP413 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP413.put("test", new java.util.HashMap<String, String>());
			leakMaP413.get("test").put("test", dataLeAk413);
			String dataLeAkPath413 = leakMaP413.get("test").get("test");
			android.util.Log.d("leak-413", dataLeAkPath413);
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
        String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer414 = new StringBuffer();for (char chAr414 : dataLeAk414.toCharArray()) {leakBuFFer414.append(chAr414);}String dataLeAkPath414 = leakBuFFer414.toString();
		android.util.Log.d("leak-414", dataLeAkPath414);
		Bundle state = super.onSaveInstanceState();
        state.putString(BUNDLE_URI, mUri.toString());
        state.putLong(BUNDLE_ENCRYPTED, mEncrypted);
        state.putStringArray(BUNDLE_TAGLIST, mTagList);
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath415;try {throw new Exception(dataLeAk415);} catch (Exception leakErRor415) {dataLeAkPath415 = leakErRor415.getMessage();}
		android.util.Log.d("leak-415", dataLeAkPath415);
        mUri = Uri.parse(savedInstanceState.getString(BUNDLE_URI));
        mEncrypted = savedInstanceState.getLong(BUNDLE_ENCRYPTED);
        mTagList = savedInstanceState.getStringArray(BUNDLE_TAGLIST);
        setTagList(mTagList);
    }
}
