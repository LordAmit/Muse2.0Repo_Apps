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
    final String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk287 = "";

	String dataLeAk286 = "";

	String dataLeAk285 = "";

	String dataLeAk284 = "";

	String dataLeAk283 = "";

	String dataLeAk282 = "";

	String dataLeAk281 = "";

	String dataLeAk280 = "";

	String dataLeAk279 = "";

	String dataLeAk278 = "";

	String dataLeAk277 = "";

	String dataLeAk275 = "";

	String dataLeAk274 = "";

	String dataLeAk273 = "";

	private static final String TAG = "ThemeDialog";

    private static final String BUNDLE_THEME = "theme";

    Context mContext;
    ThemeDialogListener mListener;
    ListView mListView;
    CheckBox mCheckBox;
    List<ThemeInfo> mListInfo;

    public ThemeDialog(Context context) {
        super(context);
		dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-0", dataLeAk273);
		android.util.Log.d("leak-274-0", dataLeAk274);
		android.util.Log.d("leak-275-0", dataLeAk275);
		android.util.Log.d("leak-277-0", dataLeAk277);
		android.util.Log.d("leak-278-0", dataLeAk278);
		android.util.Log.d("leak-279-0", dataLeAk279);
		android.util.Log.d("leak-280-0", dataLeAk280);
		android.util.Log.d("leak-281-0", dataLeAk281);
		android.util.Log.d("leak-282-0", dataLeAk282);
		android.util.Log.d("leak-283-0", dataLeAk283);
		android.util.Log.d("leak-284-0", dataLeAk284);
		android.util.Log.d("leak-285-0", dataLeAk285);
		android.util.Log.d("leak-286-0", dataLeAk286);
		android.util.Log.d("leak-287-0", dataLeAk287);
        mContext = context;
        init();
    }

    public ThemeDialog(Context context, ThemeDialogListener listener) {
        super(context);
		dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-1", dataLeAk273);
		android.util.Log.d("leak-274-1", dataLeAk274);
		android.util.Log.d("leak-275-1", dataLeAk275);
		android.util.Log.d("leak-277-1", dataLeAk277);
		android.util.Log.d("leak-278-1", dataLeAk278);
		android.util.Log.d("leak-279-1", dataLeAk279);
		android.util.Log.d("leak-280-1", dataLeAk280);
		android.util.Log.d("leak-281-1", dataLeAk281);
		android.util.Log.d("leak-282-1", dataLeAk282);
		android.util.Log.d("leak-283-1", dataLeAk283);
		android.util.Log.d("leak-284-1", dataLeAk284);
		android.util.Log.d("leak-285-1", dataLeAk285);
		android.util.Log.d("leak-286-1", dataLeAk286);
		android.util.Log.d("leak-287-1", dataLeAk287);
        mContext = context;
        mListener = listener;
        init();
    }

    private void init() {
        dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-2", dataLeAk273);
		android.util.Log.d("leak-274-2", dataLeAk274);
		android.util.Log.d("leak-275-2", dataLeAk275);
		android.util.Log.d("leak-277-2", dataLeAk277);
		android.util.Log.d("leak-278-2", dataLeAk278);
		android.util.Log.d("leak-279-2", dataLeAk279);
		android.util.Log.d("leak-280-2", dataLeAk280);
		android.util.Log.d("leak-281-2", dataLeAk281);
		android.util.Log.d("leak-282-2", dataLeAk282);
		android.util.Log.d("leak-283-2", dataLeAk283);
		android.util.Log.d("leak-284-2", dataLeAk284);
		android.util.Log.d("leak-285-2", dataLeAk285);
		android.util.Log.d("leak-286-2", dataLeAk286);
		android.util.Log.d("leak-287-2", dataLeAk287);
		setInverseBackgroundForced(true);

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

                    String dataLeAk276 = "";

					@Override
                    public void onClick(View v) {
                        dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-289-0", dataLeAk289);
						android.util.Log.d("leak-276-0", dataLeAk276);
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
        dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-3", dataLeAk273);
		android.util.Log.d("leak-274-3", dataLeAk274);
		android.util.Log.d("leak-275-3", dataLeAk275);
		android.util.Log.d("leak-277-3", dataLeAk277);
		android.util.Log.d("leak-278-3", dataLeAk278);
		android.util.Log.d("leak-279-3", dataLeAk279);
		android.util.Log.d("leak-280-3", dataLeAk280);
		android.util.Log.d("leak-281-3", dataLeAk281);
		android.util.Log.d("leak-282-3", dataLeAk282);
		android.util.Log.d("leak-283-3", dataLeAk283);
		android.util.Log.d("leak-284-3", dataLeAk284);
		android.util.Log.d("leak-285-3", dataLeAk285);
		android.util.Log.d("leak-286-3", dataLeAk286);
		android.util.Log.d("leak-287-3", dataLeAk287);
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
        dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-4", dataLeAk273);
		android.util.Log.d("leak-274-4", dataLeAk274);
		android.util.Log.d("leak-275-4", dataLeAk275);
		android.util.Log.d("leak-277-4", dataLeAk277);
		android.util.Log.d("leak-278-4", dataLeAk278);
		android.util.Log.d("leak-279-4", dataLeAk279);
		android.util.Log.d("leak-280-4", dataLeAk280);
		android.util.Log.d("leak-281-4", dataLeAk281);
		android.util.Log.d("leak-282-4", dataLeAk282);
		android.util.Log.d("leak-283-4", dataLeAk283);
		android.util.Log.d("leak-284-4", dataLeAk284);
		android.util.Log.d("leak-285-4", dataLeAk285);
		android.util.Log.d("leak-286-4", dataLeAk286);
		android.util.Log.d("leak-287-4", dataLeAk287);
		fillThemes();
        updateList();
        mCheckBox.setChecked(PreferenceActivity.getThemeSetForAll(mContext));
    }

    /**
     * Set selection to currently used theme.
     */
    private void updateList() {
        dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-5", dataLeAk273);
		android.util.Log.d("leak-274-5", dataLeAk274);
		android.util.Log.d("leak-275-5", dataLeAk275);
		android.util.Log.d("leak-277-5", dataLeAk277);
		android.util.Log.d("leak-278-5", dataLeAk278);
		android.util.Log.d("leak-279-5", dataLeAk279);
		android.util.Log.d("leak-280-5", dataLeAk280);
		android.util.Log.d("leak-281-5", dataLeAk281);
		android.util.Log.d("leak-282-5", dataLeAk282);
		android.util.Log.d("leak-283-5", dataLeAk283);
		android.util.Log.d("leak-284-5", dataLeAk284);
		android.util.Log.d("leak-285-5", dataLeAk285);
		android.util.Log.d("leak-286-5", dataLeAk286);
		android.util.Log.d("leak-287-5", dataLeAk287);
		String theme = mListener.onLoadTheme();

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
        dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-6", dataLeAk273);
		android.util.Log.d("leak-274-6", dataLeAk274);
		android.util.Log.d("leak-275-6", dataLeAk275);
		android.util.Log.d("leak-277-6", dataLeAk277);
		android.util.Log.d("leak-278-6", dataLeAk278);
		android.util.Log.d("leak-279-6", dataLeAk279);
		android.util.Log.d("leak-280-6", dataLeAk280);
		android.util.Log.d("leak-281-6", dataLeAk281);
		android.util.Log.d("leak-282-6", dataLeAk282);
		android.util.Log.d("leak-283-6", dataLeAk283);
		android.util.Log.d("leak-284-6", dataLeAk284);
		android.util.Log.d("leak-285-6", dataLeAk285);
		android.util.Log.d("leak-286-6", dataLeAk286);
		android.util.Log.d("leak-287-6", dataLeAk287);
		Log.d(TAG, "onSaveInstanceState");

        Bundle b = super.onSaveInstanceState();
        String theme = getSelectedTheme();
        b.putString(BUNDLE_THEME, theme);
        return b;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-7", dataLeAk273);
		android.util.Log.d("leak-274-7", dataLeAk274);
		android.util.Log.d("leak-275-7", dataLeAk275);
		android.util.Log.d("leak-277-7", dataLeAk277);
		android.util.Log.d("leak-278-7", dataLeAk278);
		android.util.Log.d("leak-279-7", dataLeAk279);
		android.util.Log.d("leak-280-7", dataLeAk280);
		android.util.Log.d("leak-281-7", dataLeAk281);
		android.util.Log.d("leak-282-7", dataLeAk282);
		android.util.Log.d("leak-283-7", dataLeAk283);
		android.util.Log.d("leak-284-7", dataLeAk284);
		android.util.Log.d("leak-285-7", dataLeAk285);
		android.util.Log.d("leak-286-7", dataLeAk286);
		android.util.Log.d("leak-287-7", dataLeAk287);

        Log.d(TAG, "onRestore");

        String theme = getSelectedTheme();

        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_THEME)) {
            theme = savedInstanceState.getString(BUNDLE_THEME);

            Log.d(TAG, "onRestore theme " + theme);
        }

        mListener.onSetTheme(theme);
    }

    public void onClick(DialogInterface dialog, int which) {
        dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-8", dataLeAk273);
		android.util.Log.d("leak-274-8", dataLeAk274);
		android.util.Log.d("leak-275-8", dataLeAk275);
		android.util.Log.d("leak-277-8", dataLeAk277);
		android.util.Log.d("leak-278-8", dataLeAk278);
		android.util.Log.d("leak-279-8", dataLeAk279);
		android.util.Log.d("leak-280-8", dataLeAk280);
		android.util.Log.d("leak-281-8", dataLeAk281);
		android.util.Log.d("leak-282-8", dataLeAk282);
		android.util.Log.d("leak-283-8", dataLeAk283);
		android.util.Log.d("leak-284-8", dataLeAk284);
		android.util.Log.d("leak-285-8", dataLeAk285);
		android.util.Log.d("leak-286-8", dataLeAk286);
		android.util.Log.d("leak-287-8", dataLeAk287);
		if (which == BUTTON_POSITIVE) {
            pressOk();
        } else if (which == BUTTON_NEGATIVE) {
            pressCancel();
        }

    }

    @Override
    public void onCancel(DialogInterface arg0) {
        dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-9", dataLeAk273);
		android.util.Log.d("leak-274-9", dataLeAk274);
		android.util.Log.d("leak-275-9", dataLeAk275);
		android.util.Log.d("leak-277-9", dataLeAk277);
		android.util.Log.d("leak-278-9", dataLeAk278);
		android.util.Log.d("leak-279-9", dataLeAk279);
		android.util.Log.d("leak-280-9", dataLeAk280);
		android.util.Log.d("leak-281-9", dataLeAk281);
		android.util.Log.d("leak-282-9", dataLeAk282);
		android.util.Log.d("leak-283-9", dataLeAk283);
		android.util.Log.d("leak-284-9", dataLeAk284);
		android.util.Log.d("leak-285-9", dataLeAk285);
		android.util.Log.d("leak-286-9", dataLeAk286);
		android.util.Log.d("leak-287-9", dataLeAk287);
		pressCancel();
    }

    public void pressOk() {

		dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-10", dataLeAk273);
		android.util.Log.d("leak-274-10", dataLeAk274);
		android.util.Log.d("leak-275-10", dataLeAk275);
		android.util.Log.d("leak-277-10", dataLeAk277);
		android.util.Log.d("leak-278-10", dataLeAk278);
		android.util.Log.d("leak-279-10", dataLeAk279);
		android.util.Log.d("leak-280-10", dataLeAk280);
		android.util.Log.d("leak-281-10", dataLeAk281);
		android.util.Log.d("leak-282-10", dataLeAk282);
		android.util.Log.d("leak-283-10", dataLeAk283);
		android.util.Log.d("leak-284-10", dataLeAk284);
		android.util.Log.d("leak-285-10", dataLeAk285);
		android.util.Log.d("leak-286-10", dataLeAk286);
		android.util.Log.d("leak-287-10", dataLeAk287);
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
        dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-11", dataLeAk273);
		android.util.Log.d("leak-274-11", dataLeAk274);
		android.util.Log.d("leak-275-11", dataLeAk275);
		android.util.Log.d("leak-277-11", dataLeAk277);
		android.util.Log.d("leak-278-11", dataLeAk278);
		android.util.Log.d("leak-279-11", dataLeAk279);
		android.util.Log.d("leak-280-11", dataLeAk280);
		android.util.Log.d("leak-281-11", dataLeAk281);
		android.util.Log.d("leak-282-11", dataLeAk282);
		android.util.Log.d("leak-283-11", dataLeAk283);
		android.util.Log.d("leak-284-11", dataLeAk284);
		android.util.Log.d("leak-285-11", dataLeAk285);
		android.util.Log.d("leak-286-11", dataLeAk286);
		android.util.Log.d("leak-287-11", dataLeAk287);
		int pos = mListView.getCheckedItemPosition();

        if (pos != ListView.INVALID_POSITION) {
            ThemeInfo ti = mListInfo.get(pos);
            return ti.styleName;
        } else {
            return null;
        }
    }

    public void pressCancel() {
        dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-12", dataLeAk273);
		android.util.Log.d("leak-274-12", dataLeAk274);
		android.util.Log.d("leak-275-12", dataLeAk275);
		android.util.Log.d("leak-277-12", dataLeAk277);
		android.util.Log.d("leak-278-12", dataLeAk278);
		android.util.Log.d("leak-279-12", dataLeAk279);
		android.util.Log.d("leak-280-12", dataLeAk280);
		android.util.Log.d("leak-281-12", dataLeAk281);
		android.util.Log.d("leak-282-12", dataLeAk282);
		android.util.Log.d("leak-283-12", dataLeAk283);
		android.util.Log.d("leak-284-12", dataLeAk284);
		android.util.Log.d("leak-285-12", dataLeAk285);
		android.util.Log.d("leak-286-12", dataLeAk286);
		android.util.Log.d("leak-287-12", dataLeAk287);
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
        dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-273-13", dataLeAk273);
		android.util.Log.d("leak-274-13", dataLeAk274);
		android.util.Log.d("leak-275-13", dataLeAk275);
		android.util.Log.d("leak-277-13", dataLeAk277);
		android.util.Log.d("leak-278-13", dataLeAk278);
		android.util.Log.d("leak-279-13", dataLeAk279);
		android.util.Log.d("leak-280-13", dataLeAk280);
		android.util.Log.d("leak-281-13", dataLeAk281);
		android.util.Log.d("leak-282-13", dataLeAk282);
		android.util.Log.d("leak-283-13", dataLeAk283);
		android.util.Log.d("leak-284-13", dataLeAk284);
		android.util.Log.d("leak-285-13", dataLeAk285);
		android.util.Log.d("leak-286-13", dataLeAk286);
		android.util.Log.d("leak-287-13", dataLeAk287);
		String theme = getSelectedTheme();

        if (theme != null) {
            mListener.onSetTheme(theme);
        }
    }

    public interface ThemeDialogListener {
        void onSetTheme(String theme);

        void onSetThemeForAll(String theme);

        String onLoadTheme();

        void onSaveTheme(String theme);
    }
}
