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
		String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
		android.util.Log.d("leak-94", dataLeAkPath94);

        // get and process search query here
        final Intent queryIntent = getIntent();
        final String queryAction = queryIntent.getAction();
        if (Intent.ACTION_SEARCH.equals(queryAction)) {
            String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
			android.util.Log.d("leak-95", dataLeAkPath95);
			doSearchQuery(queryIntent, "onCreate()");
        } else if (Intent.ACTION_VIEW.equals(queryAction)) {
            String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
			String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
			android.util.Log.d("leak-96", dataLeAkPath96);
			showItem(queryIntent);
        } else {
            String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP97.put("test", new java.util.HashMap<String, String>());
			leakMaP97.get("test").put("test", dataLeAk97);
			String dataLeAkPath97 = leakMaP97.get("test").get("test");
			android.util.Log.d("leak-97", dataLeAkPath97);
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
		String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
		android.util.Log.d("leak-98", dataLeAkPath98);

        // get and process search query here
        final Intent queryIntent = getIntent();
        final String queryAction = queryIntent.getAction();
        if (Intent.ACTION_SEARCH.equals(queryAction)) {
            String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
			android.util.Log.d("leak-99", dataLeAkPath99);
			doSearchQuery(queryIntent, "onNewIntent()");
        } else if (Intent.ACTION_VIEW.equals(queryAction)) {
            String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
			String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
			android.util.Log.d("leak-100", dataLeAkPath100);
			showItem(queryIntent);
        } else {
            String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP101.put("test", new java.util.HashMap<String, String>());
			leakMaP101.get("test").put("test", dataLeAk101);
			String dataLeAkPath101 = leakMaP101.get("test").get("test");
			android.util.Log.d("leak-101", dataLeAkPath101);
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

        String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
		android.util.Log.d("leak-102", dataLeAkPath102);
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
            String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
			android.util.Log.d("leak-103", dataLeAkPath103);
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

            String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
			String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
			android.util.Log.d("leak-104", dataLeAkPath104);
			// setListAdapter(mAdapter);
            setListAdapter(adapter);
        }

    }

    private void showItem(Intent queryIntent) {
        String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP105.put("test", new java.util.HashMap<String, String>());
		leakMaP105.get("test").put("test", dataLeAk105);
		String dataLeAkPath105 = leakMaP105.get("test").get("test");
		android.util.Log.d("leak-105", dataLeAkPath105);
		Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(queryIntent.getData());

        startActivity(i);
        finish();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
		String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
		android.util.Log.d("leak-106", dataLeAkPath106);

        if (id >= 0) {
            String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
			android.util.Log.d("leak-107", dataLeAkPath107);
			Uri uri = ContentUris.withAppendedId(Notes.CONTENT_URI, id);

            // Launch activity to view/edit the currently selected item
            startActivity(
                    new Intent(Intent.ACTION_EDIT, uri)
                            .putExtra("SEARCH_STRING", queryString)
            );
        }
    }

}
