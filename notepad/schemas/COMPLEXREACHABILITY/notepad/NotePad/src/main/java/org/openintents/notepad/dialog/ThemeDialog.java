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
    private static final String TAG = "ThemeDialog";

    private static final String BUNDLE_THEME = "theme";

    Context mContext;
    ThemeDialogListener mListener;
    ListView mListView;
    CheckBox mCheckBox;
    List<ThemeInfo> mListInfo;

    public ThemeDialog(Context context) {
        super(context);
		String dataLeAk854 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer854 = new StringBuffer();for (char chAr854 : dataLeAk854.toCharArray()) {leakBuFFer854.append(chAr854);}String dataLeAkPath854 = leakBuFFer854.toString();
		android.util.Log.d("leak-854", dataLeAkPath854);
        mContext = context;
        init();
    }

    public ThemeDialog(Context context, ThemeDialogListener listener) {
        super(context);
		String dataLeAk855 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath855;try {throw new Exception(dataLeAk855);} catch (Exception leakErRor855) {dataLeAkPath855 = leakErRor855.getMessage();}
		android.util.Log.d("leak-855", dataLeAkPath855);
        mContext = context;
        mListener = listener;
        init();
    }

    private void init() {
        String dataLeAk856 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay856 = new String[] {"n/a", dataLeAk856};
		String dataLeAkPath856 = leakArRay856[leakArRay856.length - 1];
		android.util.Log.d("leak-856", dataLeAkPath856);
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

                    @Override
                    public void onClick(View v) {
                        String dataLeAk857 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP857 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP857.put("test", new java.util.HashMap<String, String>());
						leakMaP857.get("test").put("test", dataLeAk857);
						String dataLeAkPath857 = leakMaP857.get("test").get("test");
						android.util.Log.d("leak-857", dataLeAkPath857);
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
        String dataLeAk858 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer858 = new StringBuffer();for (char chAr858 : dataLeAk858.toCharArray()) {leakBuFFer858.append(chAr858);}String dataLeAkPath858 = leakBuFFer858.toString();
		android.util.Log.d("leak-858", dataLeAkPath858);
		mListInfo = ThemeUtils.getThemeInfos(
                mContext,
                ThemeNotepad.THEME_NOTEPAD
        );

        String[] s = new String[mListInfo.size()];
        int i = 0;
        for (ThemeInfo ti : mListInfo) {
            String dataLeAk859 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath859;try {throw new Exception(dataLeAk859);} catch (Exception leakErRor859) {dataLeAkPath859 = leakErRor859.getMessage();}
			android.util.Log.d("leak-859", dataLeAkPath859);
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
        String dataLeAk860 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay860 = new String[] {"n/a", dataLeAk860};
		String dataLeAkPath860 = leakArRay860[leakArRay860.length - 1];
		android.util.Log.d("leak-860", dataLeAkPath860);
		fillThemes();
        updateList();
        mCheckBox.setChecked(PreferenceActivity.getThemeSetForAll(mContext));
    }

    /**
     * Set selection to currently used theme.
     */
    private void updateList() {
        String dataLeAk861 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP861 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP861.put("test", new java.util.HashMap<String, String>());
		leakMaP861.get("test").put("test", dataLeAk861);
		String dataLeAkPath861 = leakMaP861.get("test").get("test");
		android.util.Log.d("leak-861", dataLeAkPath861);
		String theme = mListener.onLoadTheme();

        // Check special cases for backward compatibility:
        if ("1".equals(theme)) {
            String dataLeAk862 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer862 = new StringBuffer();for (char chAr862 : dataLeAk862.toCharArray()) {leakBuFFer862.append(chAr862);}String dataLeAkPath862 = leakBuFFer862.toString();
			android.util.Log.d("leak-862", dataLeAkPath862);
			theme = mContext.getResources().getResourceName(
                    R.style.Theme_Notepad
            );
        } else if ("2".equals(theme)) {
            String dataLeAk863 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath863;try {throw new Exception(dataLeAk863);} catch (Exception leakErRor863) {dataLeAkPath863 = leakErRor863.getMessage();}
			android.util.Log.d("leak-863", dataLeAkPath863);
			theme = mContext.getResources().getResourceName(
                    R.style.Theme_Notepad_Monospaced
            );
        } else if ("3".equals(theme)) {
            String dataLeAk864 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay864 = new String[] {"n/a", dataLeAk864};
			String dataLeAkPath864 = leakArRay864[leakArRay864.length - 1];
			android.util.Log.d("leak-864", dataLeAkPath864);
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
            String dataLeAk865 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP865 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP865.put("test", new java.util.HashMap<String, String>());
			leakMaP865.get("test").put("test", dataLeAk865);
			String dataLeAkPath865 = leakMaP865.get("test").get("test");
			android.util.Log.d("leak-865", dataLeAkPath865);
			if (ti.styleName.equals(theme)) {
                String dataLeAk866 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer866 = new StringBuffer();for (char chAr866 : dataLeAk866.toCharArray()) {leakBuFFer866.append(chAr866);}String dataLeAkPath866 = leakBuFFer866.toString();
				android.util.Log.d("leak-866", dataLeAkPath866);
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
        String dataLeAk867 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath867;try {throw new Exception(dataLeAk867);} catch (Exception leakErRor867) {dataLeAkPath867 = leakErRor867.getMessage();}
		android.util.Log.d("leak-867", dataLeAkPath867);
		Log.d(TAG, "onSaveInstanceState");

        Bundle b = super.onSaveInstanceState();
        String theme = getSelectedTheme();
        b.putString(BUNDLE_THEME, theme);
        return b;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
		String dataLeAk868 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay868 = new String[] {"n/a", dataLeAk868};
		String dataLeAkPath868 = leakArRay868[leakArRay868.length - 1];
		android.util.Log.d("leak-868", dataLeAkPath868);

        Log.d(TAG, "onRestore");

        String theme = getSelectedTheme();

        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_THEME)) {
            String dataLeAk869 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP869 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP869.put("test", new java.util.HashMap<String, String>());
			leakMaP869.get("test").put("test", dataLeAk869);
			String dataLeAkPath869 = leakMaP869.get("test").get("test");
			android.util.Log.d("leak-869", dataLeAkPath869);
			theme = savedInstanceState.getString(BUNDLE_THEME);

            Log.d(TAG, "onRestore theme " + theme);
        }

        mListener.onSetTheme(theme);
    }

    public void onClick(DialogInterface dialog, int which) {
        String dataLeAk870 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer870 = new StringBuffer();for (char chAr870 : dataLeAk870.toCharArray()) {leakBuFFer870.append(chAr870);}String dataLeAkPath870 = leakBuFFer870.toString();
		android.util.Log.d("leak-870", dataLeAkPath870);
		if (which == BUTTON_POSITIVE) {
            String dataLeAk871 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath871;try {throw new Exception(dataLeAk871);} catch (Exception leakErRor871) {dataLeAkPath871 = leakErRor871.getMessage();}
			android.util.Log.d("leak-871", dataLeAkPath871);
			pressOk();
        } else if (which == BUTTON_NEGATIVE) {
            String dataLeAk872 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay872 = new String[] {"n/a", dataLeAk872};
			String dataLeAkPath872 = leakArRay872[leakArRay872.length - 1];
			android.util.Log.d("leak-872", dataLeAkPath872);
			pressCancel();
        }

    }

    @Override
    public void onCancel(DialogInterface arg0) {
        String dataLeAk873 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP873 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP873.put("test", new java.util.HashMap<String, String>());
		leakMaP873.get("test").put("test", dataLeAk873);
		String dataLeAkPath873 = leakMaP873.get("test").get("test");
		android.util.Log.d("leak-873", dataLeAkPath873);
		pressCancel();
    }

    public void pressOk() {

		String dataLeAk874 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer874 = new StringBuffer();for (char chAr874 : dataLeAk874.toCharArray()) {leakBuFFer874.append(chAr874);}String dataLeAkPath874 = leakBuFFer874.toString();
		android.util.Log.d("leak-874", dataLeAkPath874);
		/* User clicked Yes so do some stuff */
        String theme = getSelectedTheme();
        mListener.onSaveTheme(theme);
        mListener.onSetTheme(theme);

        boolean setForAllThemes = mCheckBox.isChecked();
        PreferenceActivity.setThemeSetForAll(mContext, setForAllThemes);
        if (setForAllThemes) {
            String dataLeAk875 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath875;try {throw new Exception(dataLeAk875);} catch (Exception leakErRor875) {dataLeAkPath875 = leakErRor875.getMessage();}
			android.util.Log.d("leak-875", dataLeAkPath875);
			mListener.onSetThemeForAll(theme);
        }
    }

    private String getSelectedTheme() {
        String dataLeAk876 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay876 = new String[] {"n/a", dataLeAk876};
		String dataLeAkPath876 = leakArRay876[leakArRay876.length - 1];
		android.util.Log.d("leak-876", dataLeAkPath876);
		int pos = mListView.getCheckedItemPosition();

        if (pos != ListView.INVALID_POSITION) {
            String dataLeAk877 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP877 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP877.put("test", new java.util.HashMap<String, String>());
			leakMaP877.get("test").put("test", dataLeAk877);
			String dataLeAkPath877 = leakMaP877.get("test").get("test");
			android.util.Log.d("leak-877", dataLeAkPath877);
			ThemeInfo ti = mListInfo.get(pos);
            return ti.styleName;
        } else {
            String dataLeAk878 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer878 = new StringBuffer();for (char chAr878 : dataLeAk878.toCharArray()) {leakBuFFer878.append(chAr878);}String dataLeAkPath878 = leakBuFFer878.toString();
			android.util.Log.d("leak-878", dataLeAkPath878);
			return null;
        }
    }

    public void pressCancel() {
        String dataLeAk879 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath879;try {throw new Exception(dataLeAk879);} catch (Exception leakErRor879) {dataLeAkPath879 = leakErRor879.getMessage();}
		android.util.Log.d("leak-879", dataLeAkPath879);
		/* User clicked No so do some stuff */
        String theme = mListener.onLoadTheme();
        mListener.onSetTheme(theme);

        //Set the list to the default theme
        mListView.setItemChecked(0, true);
        mListView.setSelection(0);

        //Set the list item to the previously chosen theme.
        int pos = 0;
        for (ThemeInfo ti : mListInfo) {
            String dataLeAk880 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay880 = new String[] {"n/a", dataLeAk880};
			String dataLeAkPath880 = leakArRay880[leakArRay880.length - 1];
			android.util.Log.d("leak-880", dataLeAkPath880);
			if (ti.styleName.equals(theme)) {
                String dataLeAk881 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP881 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP881.put("test", new java.util.HashMap<String, String>());
				leakMaP881.get("test").put("test", dataLeAk881);
				String dataLeAkPath881 = leakMaP881.get("test").get("test");
				android.util.Log.d("leak-881", dataLeAkPath881);
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
        String dataLeAk882 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
								StringBuffer leakBuFFer882 = new StringBuffer();for (char chAr882 : dataLeAk882.toCharArray()) {leakBuFFer882.append(chAr882);}String dataLeAkPath882 = leakBuFFer882.toString();
								android.util.Log.d("leak-882", dataLeAkPath882);
		String theme = getSelectedTheme();

        if (theme != null) {
            String dataLeAk883 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath883;try {throw new Exception(dataLeAk883);} catch (Exception leakErRor883) {dataLeAkPath883 = leakErRor883.getMessage();}
			android.util.Log.d("leak-883", dataLeAkPath883);
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
