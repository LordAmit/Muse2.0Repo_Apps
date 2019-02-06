/* 
 * Copyright (C) 2007-2010 OpenIntents.org
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

package org.openintents.notepad.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

import org.openintents.notepad.PreferenceActivity;
import org.openintents.notepad.R;
import org.openintents.notepad.theme.ThemeNotepad;
import org.openintents.notepad.theme.ThemeUtils;
import org.openintents.notepad.theme.ThemeUtils.ThemeInfo;

public class ThemeDialog extends AlertDialog implements OnClickListener,
        OnCancelListener, OnItemClickListener {
    String dataLeAk216 = "216";

	String dataLeAk214 = "214";

	String dataLeAk212 = "212";

	String dataLeAk210 = "210";

	String dataLeAk208 = "208";

	String dataLeAk207 = "207";

	String dataLeAk206 = "206";

	String dataLeAk205 = "205";

	String dataLeAk204 = "204";

	String dataLeAk203 = "203";

	String dataLeAk202 = "202";

	String dataLeAk201 = "201";

	String dataLeAk200 = "200";

	String dataLeAk199 = "199";

	String dataLeAk197 = "197";

	String dataLeAk196 = "196";

	private static final String TAG = "ThemeDialog";

    private static final String BUNDLE_THEME = "theme";

    Context mContext;
    ThemeDialogListener mListener;
    ListView mListView;
    CheckBox mCheckBox;
    List<ThemeInfo> mListInfo;

    public ThemeDialog(Context context) {
        super(context);
		dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-215", dataLeAk196);
		android.util.Log.d("leak-197-215", dataLeAk197);
		android.util.Log.d("leak-199-215", dataLeAk199);
		android.util.Log.d("leak-200-215", dataLeAk200);
		android.util.Log.d("leak-201-215", dataLeAk201);
		android.util.Log.d("leak-202-215", dataLeAk202);
		android.util.Log.d("leak-203-215", dataLeAk203);
		android.util.Log.d("leak-204-215", dataLeAk204);
		android.util.Log.d("leak-205-215", dataLeAk205);
		android.util.Log.d("leak-206-215", dataLeAk206);
		android.util.Log.d("leak-207-215", dataLeAk207);
		android.util.Log.d("leak-208-215", dataLeAk208);
		android.util.Log.d("leak-210-215", dataLeAk210);
		android.util.Log.d("leak-212-215", dataLeAk212);
		android.util.Log.d("leak-214-215", dataLeAk214);
		android.util.Log.d("leak-216-215", dataLeAk216);
        mContext = context;
        init();
    }

    public ThemeDialog(Context context, ThemeDialogListener listener) {
        super(context);
		dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-216", dataLeAk196);
		android.util.Log.d("leak-197-216", dataLeAk197);
		android.util.Log.d("leak-199-216", dataLeAk199);
		android.util.Log.d("leak-200-216", dataLeAk200);
		android.util.Log.d("leak-201-216", dataLeAk201);
		android.util.Log.d("leak-202-216", dataLeAk202);
		android.util.Log.d("leak-203-216", dataLeAk203);
		android.util.Log.d("leak-204-216", dataLeAk204);
		android.util.Log.d("leak-205-216", dataLeAk205);
		android.util.Log.d("leak-206-216", dataLeAk206);
		android.util.Log.d("leak-207-216", dataLeAk207);
		android.util.Log.d("leak-208-216", dataLeAk208);
		android.util.Log.d("leak-210-216", dataLeAk210);
		android.util.Log.d("leak-212-216", dataLeAk212);
		android.util.Log.d("leak-214-216", dataLeAk214);
		android.util.Log.d("leak-216-216", dataLeAk216);
        mContext = context;
        mListener = listener;
        init();
    }

    private void init() {
        setInverseBackgroundForced(true);
		android.util.Log.d("leak-196-217", dataLeAk196);
		android.util.Log.d("leak-197-217", dataLeAk197);
		android.util.Log.d("leak-199-217", dataLeAk199);
		android.util.Log.d("leak-200-217", dataLeAk200);
		android.util.Log.d("leak-201-217", dataLeAk201);
		android.util.Log.d("leak-202-217", dataLeAk202);
		android.util.Log.d("leak-203-217", dataLeAk203);
		android.util.Log.d("leak-204-217", dataLeAk204);
		android.util.Log.d("leak-205-217", dataLeAk205);
		android.util.Log.d("leak-206-217", dataLeAk206);
		android.util.Log.d("leak-207-217", dataLeAk207);
		android.util.Log.d("leak-208-217", dataLeAk208);
		android.util.Log.d("leak-210-217", dataLeAk210);
		android.util.Log.d("leak-212-217", dataLeAk212);
		android.util.Log.d("leak-214-217", dataLeAk214);
		android.util.Log.d("leak-216-217", dataLeAk216);

        LayoutInflater inflate = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflate = inflate.cloneInContext(
                new ContextThemeWrapper(
                        mContext,
                        android.R.style.Theme_Light
                )
        );

        final View view = inflate.inflate(R.layout.dialog_theme_settings, null);

        setView(view);

        mListView = (ListView) view.findViewById(R.id.list1);
        mListView.setCacheColorHint(0);
        mListView.setItemsCanFocus(false);
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        Button b = new Button(mContext);
        b.setText(R.string.get_more_themes);
        b.setOnClickListener(
                new View.OnClickListener() {

                    String dataLeAk198 = "198";

					@Override
                    public void onClick(View v) {
                        dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Intent i = new Intent(mContext, PreferenceActivity.class);
                        i.putExtra(PreferenceActivity.EXTRA_SHOW_GET_ADD_ONS, true);
                        mContext.startActivity(i);

                        pressCancel();
                        dismiss();
                    }
                }
        );

        LinearLayout ll = new LinearLayout(mContext);
        LayoutParams lp = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        ll.setPadding(20, 10, 20, 10);
        ll.addView(b, lp);
        ll.setGravity(Gravity.CENTER);
        mListView.addFooterView(ll);

        mCheckBox = (CheckBox) view.findViewById(R.id.check1);

        setTitle(R.string.theme_pick);

        setButton(Dialog.BUTTON_POSITIVE, mContext.getText(R.string.ok), this);
        setButton(
                Dialog.BUTTON_NEGATIVE, mContext.getText(R.string.cancel),
                this
        );
        setOnCancelListener(this);

        prepareDialog();
    }

    public void fillThemes() {
        dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-218", dataLeAk196);
		android.util.Log.d("leak-197-218", dataLeAk197);
		android.util.Log.d("leak-199-218", dataLeAk199);
		android.util.Log.d("leak-200-218", dataLeAk200);
		android.util.Log.d("leak-201-218", dataLeAk201);
		android.util.Log.d("leak-202-218", dataLeAk202);
		android.util.Log.d("leak-203-218", dataLeAk203);
		android.util.Log.d("leak-204-218", dataLeAk204);
		android.util.Log.d("leak-205-218", dataLeAk205);
		android.util.Log.d("leak-206-218", dataLeAk206);
		android.util.Log.d("leak-207-218", dataLeAk207);
		android.util.Log.d("leak-208-218", dataLeAk208);
		android.util.Log.d("leak-210-218", dataLeAk210);
		android.util.Log.d("leak-212-218", dataLeAk212);
		android.util.Log.d("leak-214-218", dataLeAk214);
		android.util.Log.d("leak-216-218", dataLeAk216);
		mListInfo = ThemeUtils.getThemeInfos(
                mContext,
                ThemeNotepad.THEME_NOTEPAD
        );

        String[] s = new String[mListInfo.size()];
        int i = 0;
        for (ThemeInfo ti : mListInfo) {
            s[i] = ti.title;
            i++;
        }

        mListView.setAdapter(
                new ArrayAdapter<String>(
                        new ContextThemeWrapper(
                                mContext, android.R.style.Theme_Light
                        ),
                        android.R.layout.simple_list_item_single_choice, s
                )
        );

        mListView.setOnItemClickListener(this);
    }

    public void prepareDialog() {
        dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-219", dataLeAk196);
		android.util.Log.d("leak-197-219", dataLeAk197);
		android.util.Log.d("leak-199-219", dataLeAk199);
		android.util.Log.d("leak-200-219", dataLeAk200);
		android.util.Log.d("leak-201-219", dataLeAk201);
		android.util.Log.d("leak-202-219", dataLeAk202);
		android.util.Log.d("leak-203-219", dataLeAk203);
		android.util.Log.d("leak-204-219", dataLeAk204);
		android.util.Log.d("leak-205-219", dataLeAk205);
		android.util.Log.d("leak-206-219", dataLeAk206);
		android.util.Log.d("leak-207-219", dataLeAk207);
		android.util.Log.d("leak-208-219", dataLeAk208);
		android.util.Log.d("leak-210-219", dataLeAk210);
		android.util.Log.d("leak-212-219", dataLeAk212);
		android.util.Log.d("leak-214-219", dataLeAk214);
		android.util.Log.d("leak-216-219", dataLeAk216);
		fillThemes();
        updateList();
        mCheckBox.setChecked(PreferenceActivity.getThemeSetForAll(mContext));
    }

    /**
     * Set selection to currently used theme.
     */
    private void updateList() {
        String theme = mListener.onLoadTheme();
		android.util.Log.d("leak-196-220", dataLeAk196);
		android.util.Log.d("leak-197-220", dataLeAk197);
		android.util.Log.d("leak-199-220", dataLeAk199);
		android.util.Log.d("leak-200-220", dataLeAk200);
		android.util.Log.d("leak-201-220", dataLeAk201);
		android.util.Log.d("leak-202-220", dataLeAk202);
		android.util.Log.d("leak-203-220", dataLeAk203);
		android.util.Log.d("leak-204-220", dataLeAk204);
		android.util.Log.d("leak-205-220", dataLeAk205);
		android.util.Log.d("leak-206-220", dataLeAk206);
		android.util.Log.d("leak-207-220", dataLeAk207);
		android.util.Log.d("leak-208-220", dataLeAk208);
		android.util.Log.d("leak-210-220", dataLeAk210);
		android.util.Log.d("leak-212-220", dataLeAk212);
		android.util.Log.d("leak-214-220", dataLeAk214);
		android.util.Log.d("leak-216-220", dataLeAk216);

        // Check special cases for backward compatibility:
        if ("1".equals(theme)) {
            theme = mContext.getResources().getResourceName(
                    R.style.Theme_Notepad
            );
        } else if ("2".equals(theme)) {
            theme = mContext.getResources().getResourceName(
                    R.style.Theme_Notepad_Monospaced
            );
        } else if ("3".equals(theme)) {
            theme = mContext.getResources().getResourceName(
                    R.style.Theme_Notepad_Serif
            );
        }

        // Reset selection in case the current theme is not
        // in this list (for example got uninstalled).
        mListView.setItemChecked(-1, false);

        //Set the default theme listitem.
        mListView.setItemChecked(0, true);
        mListView.setSelection(0);

        int pos = 0;
        for (ThemeInfo ti : mListInfo) {
            if (ti.styleName.equals(theme)) {
                mListView.setItemChecked(pos, true);

                // Move list to show the selected item:
                mListView.setSelection(pos);
                break;
            }
            pos++;
        }
    }

    @Override
    public Bundle onSaveInstanceState() {
        dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-221", dataLeAk196);
		android.util.Log.d("leak-197-221", dataLeAk197);
		android.util.Log.d("leak-199-221", dataLeAk199);
		android.util.Log.d("leak-200-221", dataLeAk200);
		android.util.Log.d("leak-201-221", dataLeAk201);
		android.util.Log.d("leak-202-221", dataLeAk202);
		android.util.Log.d("leak-203-221", dataLeAk203);
		android.util.Log.d("leak-204-221", dataLeAk204);
		android.util.Log.d("leak-205-221", dataLeAk205);
		android.util.Log.d("leak-206-221", dataLeAk206);
		android.util.Log.d("leak-207-221", dataLeAk207);
		android.util.Log.d("leak-208-221", dataLeAk208);
		android.util.Log.d("leak-210-221", dataLeAk210);
		android.util.Log.d("leak-212-221", dataLeAk212);
		android.util.Log.d("leak-214-221", dataLeAk214);
		android.util.Log.d("leak-216-221", dataLeAk216);
		Log.d(TAG, "onSaveInstanceState");

        Bundle b = super.onSaveInstanceState();
        String theme = getSelectedTheme();
        b.putString(BUNDLE_THEME, theme);
        return b;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-222", dataLeAk196);
		android.util.Log.d("leak-197-222", dataLeAk197);
		android.util.Log.d("leak-199-222", dataLeAk199);
		android.util.Log.d("leak-200-222", dataLeAk200);
		android.util.Log.d("leak-201-222", dataLeAk201);
		android.util.Log.d("leak-202-222", dataLeAk202);
		android.util.Log.d("leak-203-222", dataLeAk203);
		android.util.Log.d("leak-204-222", dataLeAk204);
		android.util.Log.d("leak-205-222", dataLeAk205);
		android.util.Log.d("leak-206-222", dataLeAk206);
		android.util.Log.d("leak-207-222", dataLeAk207);
		android.util.Log.d("leak-208-222", dataLeAk208);
		android.util.Log.d("leak-210-222", dataLeAk210);
		android.util.Log.d("leak-212-222", dataLeAk212);
		android.util.Log.d("leak-214-222", dataLeAk214);
		android.util.Log.d("leak-216-222", dataLeAk216);

        Log.d(TAG, "onRestore");

        String theme = getSelectedTheme();

        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_THEME)) {
            theme = savedInstanceState.getString(BUNDLE_THEME);

            Log.d(TAG, "onRestore theme " + theme);
        }

        mListener.onSetTheme(theme);
    }

    public void onClick(DialogInterface dialog, int which) {
        dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-223", dataLeAk196);
		android.util.Log.d("leak-197-223", dataLeAk197);
		android.util.Log.d("leak-199-223", dataLeAk199);
		android.util.Log.d("leak-200-223", dataLeAk200);
		android.util.Log.d("leak-201-223", dataLeAk201);
		android.util.Log.d("leak-202-223", dataLeAk202);
		android.util.Log.d("leak-203-223", dataLeAk203);
		android.util.Log.d("leak-204-223", dataLeAk204);
		android.util.Log.d("leak-205-223", dataLeAk205);
		android.util.Log.d("leak-206-223", dataLeAk206);
		android.util.Log.d("leak-207-223", dataLeAk207);
		android.util.Log.d("leak-208-223", dataLeAk208);
		android.util.Log.d("leak-210-223", dataLeAk210);
		android.util.Log.d("leak-212-223", dataLeAk212);
		android.util.Log.d("leak-214-223", dataLeAk214);
		android.util.Log.d("leak-216-223", dataLeAk216);
		if (which == BUTTON_POSITIVE) {
            pressOk();
        } else if (which == BUTTON_NEGATIVE) {
            pressCancel();
        }

    }

    @Override
    public void onCancel(DialogInterface arg0) {
        dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-224", dataLeAk196);
		android.util.Log.d("leak-197-224", dataLeAk197);
		android.util.Log.d("leak-199-224", dataLeAk199);
		android.util.Log.d("leak-200-224", dataLeAk200);
		android.util.Log.d("leak-201-224", dataLeAk201);
		android.util.Log.d("leak-202-224", dataLeAk202);
		android.util.Log.d("leak-203-224", dataLeAk203);
		android.util.Log.d("leak-204-224", dataLeAk204);
		android.util.Log.d("leak-205-224", dataLeAk205);
		android.util.Log.d("leak-206-224", dataLeAk206);
		android.util.Log.d("leak-207-224", dataLeAk207);
		android.util.Log.d("leak-208-224", dataLeAk208);
		android.util.Log.d("leak-210-224", dataLeAk210);
		android.util.Log.d("leak-212-224", dataLeAk212);
		android.util.Log.d("leak-214-224", dataLeAk214);
		android.util.Log.d("leak-216-224", dataLeAk216);
		pressCancel();
    }

    public void pressOk() {

		dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-225", dataLeAk196);
		android.util.Log.d("leak-197-225", dataLeAk197);
		android.util.Log.d("leak-199-225", dataLeAk199);
		android.util.Log.d("leak-200-225", dataLeAk200);
		android.util.Log.d("leak-201-225", dataLeAk201);
		android.util.Log.d("leak-202-225", dataLeAk202);
		android.util.Log.d("leak-203-225", dataLeAk203);
		android.util.Log.d("leak-204-225", dataLeAk204);
		android.util.Log.d("leak-205-225", dataLeAk205);
		android.util.Log.d("leak-206-225", dataLeAk206);
		android.util.Log.d("leak-207-225", dataLeAk207);
		android.util.Log.d("leak-208-225", dataLeAk208);
		android.util.Log.d("leak-210-225", dataLeAk210);
		android.util.Log.d("leak-212-225", dataLeAk212);
		android.util.Log.d("leak-214-225", dataLeAk214);
		android.util.Log.d("leak-216-225", dataLeAk216);
		/* User clicked Yes so do some stuff */
        String theme = getSelectedTheme();
        mListener.onSaveTheme(theme);
        mListener.onSetTheme(theme);

        boolean setForAllThemes = mCheckBox.isChecked();
        PreferenceActivity.setThemeSetForAll(mContext, setForAllThemes);
        if (setForAllThemes) {
            mListener.onSetThemeForAll(theme);
        }
    }

    private String getSelectedTheme() {
        int pos = mListView.getCheckedItemPosition();
		android.util.Log.d("leak-196-226", dataLeAk196);
		android.util.Log.d("leak-197-226", dataLeAk197);
		android.util.Log.d("leak-199-226", dataLeAk199);
		android.util.Log.d("leak-200-226", dataLeAk200);
		android.util.Log.d("leak-201-226", dataLeAk201);
		android.util.Log.d("leak-202-226", dataLeAk202);
		android.util.Log.d("leak-203-226", dataLeAk203);
		android.util.Log.d("leak-204-226", dataLeAk204);
		android.util.Log.d("leak-205-226", dataLeAk205);
		android.util.Log.d("leak-206-226", dataLeAk206);
		android.util.Log.d("leak-207-226", dataLeAk207);
		android.util.Log.d("leak-208-226", dataLeAk208);
		android.util.Log.d("leak-210-226", dataLeAk210);
		android.util.Log.d("leak-212-226", dataLeAk212);
		android.util.Log.d("leak-214-226", dataLeAk214);
		android.util.Log.d("leak-216-226", dataLeAk216);

        if (pos != ListView.INVALID_POSITION) {
            ThemeInfo ti = mListInfo.get(pos);
            return ti.styleName;
        } else {
            return null;
        }
    }

    public void pressCancel() {
        dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-227", dataLeAk196);
		android.util.Log.d("leak-197-227", dataLeAk197);
		android.util.Log.d("leak-199-227", dataLeAk199);
		android.util.Log.d("leak-200-227", dataLeAk200);
		android.util.Log.d("leak-201-227", dataLeAk201);
		android.util.Log.d("leak-202-227", dataLeAk202);
		android.util.Log.d("leak-203-227", dataLeAk203);
		android.util.Log.d("leak-204-227", dataLeAk204);
		android.util.Log.d("leak-205-227", dataLeAk205);
		android.util.Log.d("leak-206-227", dataLeAk206);
		android.util.Log.d("leak-207-227", dataLeAk207);
		android.util.Log.d("leak-208-227", dataLeAk208);
		android.util.Log.d("leak-210-227", dataLeAk210);
		android.util.Log.d("leak-212-227", dataLeAk212);
		android.util.Log.d("leak-214-227", dataLeAk214);
		android.util.Log.d("leak-216-227", dataLeAk216);
		/* User clicked No so do some stuff */
        String theme = mListener.onLoadTheme();
        mListener.onSetTheme(theme);

        //Set the list to the default theme
        mListView.setItemChecked(0, true);
        mListView.setSelection(0);

        //Set the list item to the previously chosen theme.
        int pos = 0;
        for (ThemeInfo ti : mListInfo) {
            if (ti.styleName.equals(theme)) {
                mListView.setItemChecked(pos, true);
                mListView.setSelection(pos);
                break;
            }
            pos++;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-196-228", dataLeAk196);
		android.util.Log.d("leak-197-228", dataLeAk197);
		android.util.Log.d("leak-199-228", dataLeAk199);
		android.util.Log.d("leak-200-228", dataLeAk200);
		android.util.Log.d("leak-201-228", dataLeAk201);
		android.util.Log.d("leak-202-228", dataLeAk202);
		android.util.Log.d("leak-203-228", dataLeAk203);
		android.util.Log.d("leak-204-228", dataLeAk204);
		android.util.Log.d("leak-205-228", dataLeAk205);
		android.util.Log.d("leak-206-228", dataLeAk206);
		android.util.Log.d("leak-207-228", dataLeAk207);
		android.util.Log.d("leak-208-228", dataLeAk208);
		android.util.Log.d("leak-210-228", dataLeAk210);
		android.util.Log.d("leak-212-228", dataLeAk212);
		android.util.Log.d("leak-214-228", dataLeAk214);
		android.util.Log.d("leak-216-228", dataLeAk216);
		String theme = getSelectedTheme();

        if (theme != null) {
            mListener.onSetTheme(theme);
        }
    }

    public interface ThemeDialogListener {
        String dataLeAk215 = "215";

		String dataLeAk213 = "213";

		String dataLeAk211 = "211";

		String dataLeAk209 = "209";

		void onSetTheme(String theme);

        void onSetThemeForAll(String theme);

        String onLoadTheme();

        void onSaveTheme(String theme);
    }
}
