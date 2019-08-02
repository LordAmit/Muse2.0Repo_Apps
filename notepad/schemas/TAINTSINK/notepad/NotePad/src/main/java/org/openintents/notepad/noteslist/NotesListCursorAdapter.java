package org.openintents.notepad.noteslist;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

public class NotesListCursorAdapter extends CursorAdapter {
    String dataLeAk52 = "52";

	String dataLeAk51 = "51";

	String dataLeAk50 = "50";

	String dataLeAk49 = "49";

	private static final String TAG = "NotesListCursorAdapter";
    /**
     * Flag for slow list adapter.
     */
    public boolean mBusy;
    Context mContext;
    NotesListCursor mCursorUtils;

    public NotesListCursorAdapter(Context context, Cursor c,
                                  NotesListCursor cursorUtils) {
        super(context, c);
		dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-49-64", dataLeAk49);
		android.util.Log.d("leak-50-64", dataLeAk50);
		android.util.Log.d("leak-51-64", dataLeAk51);
		android.util.Log.d("leak-52-64", dataLeAk52);
        mContext = context;
        mCursorUtils = cursorUtils;

        mBusy = false;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-49-65", dataLeAk49);
		android.util.Log.d("leak-50-65", dataLeAk50);
		android.util.Log.d("leak-51-65", dataLeAk51);
		android.util.Log.d("leak-52-65", dataLeAk52);
		NotesListItemView nliv = (NotesListItemView) view;

        String title = cursor.getString(NotesListCursor.COLUMN_INDEX_TITLE);
        String tags = cursor.getString(NotesListCursor.COLUMN_INDEX_TAGS);
        long encrypted = cursor.getLong(NotesListCursor.COLUMN_INDEX_ENCRYPTED);
        String titleEncrypted = cursor
                .getString(NotesListCursor.COLUMN_INDEX_TITLE_ENCRYPTED);
        String tagsEncrypted = cursor
                .getString(NotesListCursor.COLUMN_INDEX_TAGS_ENCRYPTED);

        nliv.setEncrypted(encrypted);

        nliv.setTitle(title);
        nliv.setTags(tags);
        nliv.mTitleEncrypted = titleEncrypted;
        nliv.mTagsEncrypted = tagsEncrypted;

		/*
         * if (encrypted == 0) { // Not encrypted: nliv.setTitle(title);
		 * nliv.setTags(tags); // Null tag means the view has the correct data
		 * nliv.setTag(null); } else { // encrypted String decrypted =
		 * mTitleHashMap.get(title); if (decrypted != null) {
		 * nliv.setTitle(decrypted); nliv.setTags(tags); // Null tag means the
		 * view has the correct data nliv.setTag(null); } else {
		 * nliv.setTitle(mContext.getString(R.string.encrypted));
		 * nliv.setTags(tags); // Non-null tag means the view still needs to
		 * load it's data // Tag contains a pointer to a string with the
		 * encrypted title. nliv.setTag(title); } /* if (!mBusy) {
		 * nliv.setTitle("set"); nliv.setTitle("wow"); // Null tag means the
		 * view has the correct data nliv.setTag(null); } else {
		 * nliv.setTitle(mContext.getString(R.string.encrypted));
		 * nliv.setTags(tags); // Non-null tag means the view still needs to
		 * load it's data nliv.setTag(this); } / }
		 */
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-49-66", dataLeAk49);
		android.util.Log.d("leak-50-66", dataLeAk50);
		android.util.Log.d("leak-51-66", dataLeAk51);
		android.util.Log.d("leak-52-66", dataLeAk52);
		return new NotesListItemView(context);
    }

	/*
	 * @Override public Filter getFilter() { Log.i(TAG, "Request filter");
	 * 
	 * return super.getFilter(); }
	 */

	/*
	 * @Override public CharSequence convertToString(Cursor cursor) { //return
	 * super.convertToString(cursor);
	 * 
	 * Log.i(TAG, "convertToString" + cursor.getPosition() + " / " +
	 * cursor.getCount());
	 * 
	 * return cursor.getString(NotesList.COLUMN_INDEX_TITLE); }
	 */

    public Cursor runQueryOnBackgroundThread(CharSequence constraint, String tag) {
        // Log.i(TAG, "runQueryOnBackgroundThread " + constraint + ", " +
        // mIntent.getData());

		/*
		 * Cursor cursor =
		 * mContext.getContentResolver().query(mIntent.getData(),
		 * NotesList.PROJECTION, "(" + Notes.TITLE + " like '" +
		 * constraint.toString() + "%' ) or (" + Notes.TITLE + " like '% " +
		 * constraint.toString() + "%' )", new String[] { },
		 * Notes.DEFAULT_SORT_ORDER);
		 */

        dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-49-67", dataLeAk49);
		android.util.Log.d("leak-50-67", dataLeAk50);
		android.util.Log.d("leak-51-67", dataLeAk51);
		android.util.Log.d("leak-52-67", dataLeAk52);
		return mCursorUtils.query(constraint, tag);

    }

}
