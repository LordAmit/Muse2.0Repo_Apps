/*
 * Copyright (C) 2008 The Android Open Source Project
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

// Modified by OpenIntents.org

package org.openintents.notepad.search;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.openintents.notepad.NotePad.Notes;
import org.openintents.notepad.R;
import org.openintents.notepad.noteslist.NotesListCursor;
import org.openintents.notepad.noteslist.NotesListCursorAdapter;

public class SearchQueryResultsActivity extends ListActivity {
    String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk103 = android.util.Log.d("leak-103", dataLeAk103);

	NotesListCursor mCursorUtils;
    NotesListCursorAdapter mAdapter;
    String queryString;

    /**
     * Called with the activity is first created.
     * <p/>
     * After the typical activity setup code, we check to see if we were
     * launched with the ACTION_SEARCH intent, and if so, we handle it.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk104 = android.util.Log.d("leak-104", dataLeAk104);

        // get and process search query here
        final Intent queryIntent = getIntent();
        final String queryAction = queryIntent.getAction();
        if (Intent.ACTION_SEARCH.equals(queryAction)) {
            String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk105 = android.util.Log.d("leak-105", dataLeAk105);
			doSearchQuery(queryIntent, "onCreate()");
        } else if (Intent.ACTION_VIEW.equals(queryAction)) {
            String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);
			showItem(queryIntent);
        } else {
            String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);
			finish();
        }
    }

    /**
     * Called when new intent is delivered.
     * <p/>
     * This is where we check the incoming intent for a query string.
     *
     * @param newIntent The intent used to restart this activity
     */
    @Override
    public void onNewIntent(final Intent newIntent) {
        super.onNewIntent(newIntent);
		String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);

        // get and process search query here
        final Intent queryIntent = getIntent();
        final String queryAction = queryIntent.getAction();
        if (Intent.ACTION_SEARCH.equals(queryAction)) {
            String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);
			doSearchQuery(queryIntent, "onNewIntent()");
        } else if (Intent.ACTION_VIEW.equals(queryAction)) {
            String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
			showItem(queryIntent);
        } else {
            String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);
			finish();
        }
    }

    /**
     * Generic search handler.
     * <p/>
     * In a "real" application, you would use the query string to select results
     * from your data source, and present a list of those results to the user.
     */
    private void doSearchQuery(final Intent queryIntent, final String entryPoint) {

        String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
		// The search query is provided as an "extra" string in the query intent
        queryString = queryIntent.getStringExtra(SearchManager.QUERY);

        Intent i = new Intent();
        i.setData(Notes.CONTENT_URI);

        mCursorUtils = new NotesListCursor(this, i);
        Cursor cursor = mCursorUtils.query(null, null);

        cursor = FullTextSearch.getCursor(this, queryString);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2, cursor, new String[]{
                SearchManager.SUGGEST_COLUMN_TEXT_1,
                SearchManager.SUGGEST_COLUMN_TEXT_2}, new int[]{
                android.R.id.text1, android.R.id.text2}
        );

        if (cursor.getCount() <= 0) {
            String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);
			// Nothing found.
            TextView t = new TextView(this);
            t.setText(getString(R.string.search_found_no_results, queryString));
            t.setPadding(5, 5, 5, 5);
            t.setTextSize(20);
            getListView().addHeaderView(t);

            setListAdapter(
                    new ArrayAdapter<String>(
                            this,
                            android.R.layout.simple_list_item_1, new String[]{}
                    )
            );
        } else {

            String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
			// setListAdapter(mAdapter);
            setListAdapter(adapter);
        }

    }

    private void showItem(Intent queryIntent) {
        String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);
		Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(queryIntent.getData());

        startActivity(i);
        finish();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
		String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);

        if (id >= 0) {
            String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
			Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);

            // Launch activity to view/edit the currently selected item
            startActivity(
                    new Intent(Intent.ACTION_EDIT, uri)
                            .putExtra("SEARCH_STRING", queryString)
            );
        }
    }

}
