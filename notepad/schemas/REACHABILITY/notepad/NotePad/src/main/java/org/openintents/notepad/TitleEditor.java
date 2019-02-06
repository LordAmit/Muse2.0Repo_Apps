/* 
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openintents.notepad;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.openintents.notepad.NotePad.Notes;

/**
 * An activity that will edit the title of a note. Displays a floating window
 * with a text field.
 */
public class TitleEditor extends Activity implements View.OnClickListener {

    String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk244 = android.util.Log.d("leak-244", dataLeAk244);

	/**
     * This is a special intent action that means "edit the title of a note".
     */
    public static final String EDIT_TITLE_ACTION = "com.android.notepad.action.EDIT_TITLE";

    /**
     * An array of the columns we are interested in.
     */
    private static final String[] PROJECTION = new String[]{
            NotePad.Notes._ID, // 0
            NotePad.Notes.TITLE, // 1
    };
    /**
     * Index of the title column
     */
    private static final int COLUMN_INDEX_TITLE = 1;

    /**
     * Cursor which will provide access to the note whose title we are editing.
     */
    private Cursor mCursor;

    /**
     * The EditText field from our UI. Keep track of this so we can extract the
     * text when we are finished.
     */
    private EditText mText;

    /**
     * The content URI to the note that's being edited.
     */
    private Uri mUri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk245 = android.util.Log.d("leak-245", dataLeAk245);

        setContentView(R.layout.title_editor);

        // Get the uri of the note whose title we want to edit
        mUri = getIntent().getData();

        // Get a cursor to access the note
        mCursor = managedQuery(mUri, PROJECTION, null, null, null);

        // Set up click handlers for the text field and button
        mText = (EditText) this.findViewById(R.id.title);
        // mText.setOnClickListener(this);

        Button b = (Button) findViewById(R.id.ok);
        b.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk246 = android.util.Log.d("leak-246", dataLeAk246);

        // Initialize the text with the title column from the cursor
        if (mCursor != null) {
            String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk247 = android.util.Log.d("leak-247", dataLeAk247);
			mCursor.moveToFirst();
            mText.setText(mCursor.getString(COLUMN_INDEX_TITLE));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk248 = android.util.Log.d("leak-248", dataLeAk248);

        if (mCursor != null) {
            String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk249 = android.util.Log.d("leak-249", dataLeAk249);
			// Write the title back to the note
            ContentValues values = new ContentValues();
            values.put(Notes.TITLE, mText.getText().toString());
            getContentResolver().update(mUri, values, null, null);
        }
    }

    public void onClick(View v) {
        String dataLeAk250 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk250 = android.util.Log.d("leak-250", dataLeAk250);
		// When the user clicks, just finish this activity.
        // onPause will be called, and we save our data there.
        finish();
    }
}
