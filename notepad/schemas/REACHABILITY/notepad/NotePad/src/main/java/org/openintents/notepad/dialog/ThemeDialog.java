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
    String dataLeAk908 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk908 = android.util.Log.d("leak-908", dataLeAk908);

	private static final String TAG = "ThemeDialog";

    private static final String BUNDLE_THEME = "theme";

    Context mContext;
    ThemeDialogListener mListener;
    ListView mListView;
    CheckBox mCheckBox;
    List<ThemeInfo> mListInfo;

    public ThemeDialog(Context context) {
        super(context);
		String dataLeAk909 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk909 = android.util.Log.d("leak-909", dataLeAk909);
        mContext = context;
        init();
    }

    public ThemeDialog(Context context, ThemeDialogListener listener) {
        super(context);
		String dataLeAk910 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk910 = android.util.Log.d("leak-910", dataLeAk910);
        mContext = context;
        mListener = listener;
        init();
    }

    private void init() {
        String dataLeAk911 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk911 = android.util.Log.d("leak-911", dataLeAk911);
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

                    String dataLeAk912 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk912 = android.util.Log.d("leak-912", dataLeAk912);

					@Override
                    public void onClick(View v) {
                        String dataLeAk913 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk913 = android.util.Log.d("leak-913", dataLeAk913);
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
        String dataLeAk914 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk914 = android.util.Log.d("leak-914", dataLeAk914);
		mListInfo = ThemeUtils.getThemeInfos(
                mContext,
                ThemeNotepad.THEME_NOTEPAD
        );

        String[] s = new String[mListInfo.size()];
        int i = 0;
        for (ThemeInfo ti : mListInfo) {
            String dataLeAk915 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk915 = android.util.Log.d("leak-915", dataLeAk915);
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
        String dataLeAk916 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk916 = android.util.Log.d("leak-916", dataLeAk916);
		fillThemes();
        updateList();
        mCheckBox.setChecked(PreferenceActivity.getThemeSetForAll(mContext));
    }

    /**
     * Set selection to currently used theme.
     */
    private void updateList() {
        String dataLeAk917 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk917 = android.util.Log.d("leak-917", dataLeAk917);
		String theme = mListener.onLoadTheme();

        // Check special cases for backward compatibility:
        if ("1".equals(theme)) {
            String dataLeAk918 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk918 = android.util.Log.d("leak-918", dataLeAk918);
			theme = mContext.getResources().getResourceName(
                    R.style.Theme_Notepad
            );
        } else if ("2".equals(theme)) {
            String dataLeAk919 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk919 = android.util.Log.d("leak-919", dataLeAk919);
			theme = mContext.getResources().getResourceName(
                    R.style.Theme_Notepad_Monospaced
            );
        } else if ("3".equals(theme)) {
            String dataLeAk920 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk920 = android.util.Log.d("leak-920", dataLeAk920);
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
            String dataLeAk921 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk921 = android.util.Log.d("leak-921", dataLeAk921);
			if (ti.styleName.equals(theme)) {
                String dataLeAk922 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk922 = android.util.Log.d("leak-922", dataLeAk922);
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
        String dataLeAk923 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk923 = android.util.Log.d("leak-923", dataLeAk923);
		Log.d(TAG, "onSaveInstanceState");

        Bundle b = super.onSaveInstanceState();
        String theme = getSelectedTheme();
        b.putString(BUNDLE_THEME, theme);
        return b;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		String dataLeAk924 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk924 = android.util.Log.d("leak-924", dataLeAk924);

        Log.d(TAG, "onRestore");

        String theme = getSelectedTheme();

        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_THEME)) {
            String dataLeAk925 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk925 = android.util.Log.d("leak-925", dataLeAk925);
			theme = savedInstanceState.getString(BUNDLE_THEME);

            Log.d(TAG, "onRestore theme " + theme);
        }

        mListener.onSetTheme(theme);
    }

    public void onClick(DialogInterface dialog, int which) {
        String dataLeAk926 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk926 = android.util.Log.d("leak-926", dataLeAk926);
		if (which == BUTTON_POSITIVE) {
            String dataLeAk927 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk927 = android.util.Log.d("leak-927", dataLeAk927);
			pressOk();
        } else if (which == BUTTON_NEGATIVE) {
            String dataLeAk928 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk928 = android.util.Log.d("leak-928", dataLeAk928);
			pressCancel();
        }

    }

    @Override
    public void onCancel(DialogInterface arg0) {
        String dataLeAk929 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk929 = android.util.Log.d("leak-929", dataLeAk929);
		pressCancel();
    }

    public void pressOk() {

		String dataLeAk930 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk930 = android.util.Log.d("leak-930", dataLeAk930);
		/* User clicked Yes so do some stuff */
        String theme = getSelectedTheme();
        mListener.onSaveTheme(theme);
        mListener.onSetTheme(theme);

        boolean setForAllThemes = mCheckBox.isChecked();
        PreferenceActivity.setThemeSetForAll(mContext, setForAllThemes);
        if (setForAllThemes) {
            String dataLeAk931 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk931 = android.util.Log.d("leak-931", dataLeAk931);
			mListener.onSetThemeForAll(theme);
        }
    }

    private String getSelectedTheme() {
        String dataLeAk932 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk932 = android.util.Log.d("leak-932", dataLeAk932);
		int pos = mListView.getCheckedItemPosition();

        if (pos != ListView.INVALID_POSITION) {
            String dataLeAk933 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk933 = android.util.Log.d("leak-933", dataLeAk933);
			ThemeInfo ti = mListInfo.get(pos);
            return ti.styleName;
        } else {
            String dataLeAk934 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk934 = android.util.Log.d("leak-934", dataLeAk934);
			return null;
        }
    }

    public void pressCancel() {
        String dataLeAk935 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk935 = android.util.Log.d("leak-935", dataLeAk935);
		/* User clicked No so do some stuff */
        String theme = mListener.onLoadTheme();
        mListener.onSetTheme(theme);

        //Set the list to the default theme
        mListView.setItemChecked(0, true);
        mListView.setSelection(0);

        //Set the list item to the previously chosen theme.
        int pos = 0;
        for (ThemeInfo ti : mListInfo) {
            String dataLeAk936 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk936 = android.util.Log.d("leak-936", dataLeAk936);
			if (ti.styleName.equals(theme)) {
                String dataLeAk937 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk937 = android.util.Log.d("leak-937", dataLeAk937);
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
        String dataLeAk938 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								Object throwawayLeAk938 = android.util.Log.d("leak-938", dataLeAk938);
		String theme = getSelectedTheme();

        if (theme != null) {
            String dataLeAk939 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk939 = android.util.Log.d("leak-939", dataLeAk939);
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
