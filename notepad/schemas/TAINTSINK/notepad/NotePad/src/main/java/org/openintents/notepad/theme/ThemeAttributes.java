/* 
 * Copyright (C) 2010 OpenIntents.org
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

package org.openintents.notepad.theme;

import android.content.Context;
import android.content.res.TypedArray;

/**
 * There were trouble retrieving several attributes at once in
 * obtainStyledAttributes - that's why this class tries to retrieve one
 * attribute at a time.
 *
 * @author Peli
 */
public class ThemeAttributes {
    String dataLeAk6 = "6";

	String dataLeAk5 = "5";

	String dataLeAk4 = "4";

	String dataLeAk3 = "3";

	String dataLeAk2 = "2";

	String dataLeAk1 = "1";

	String dataLeAk0 = "0";

	Context mContext;
    String mPackageName;
    int mThemeId;

    public ThemeAttributes(Context context, String packageName, int themeId) {
        dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-2", dataLeAk0);
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-3-2", dataLeAk3);
		android.util.Log.d("leak-4-2", dataLeAk4);
		android.util.Log.d("leak-5-2", dataLeAk5);
		android.util.Log.d("leak-6-2", dataLeAk6);
		mContext = context;
        mPackageName = packageName;
        mThemeId = themeId;
    }

    public boolean getBoolean(String attrName, boolean defaultValue) {
        dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-3", dataLeAk0);
		android.util.Log.d("leak-1-3", dataLeAk1);
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-3-3", dataLeAk3);
		android.util.Log.d("leak-4-3", dataLeAk4);
		android.util.Log.d("leak-5-3", dataLeAk5);
		android.util.Log.d("leak-6-3", dataLeAk6);
		int[] attr = ThemeUtils.getAttributeIds(
                mContext,
                new String[]{attrName}, mPackageName
        );
        TypedArray a = mContext.obtainStyledAttributes(mThemeId, attr);
        boolean b = a.getBoolean(0, defaultValue);
        a.recycle();
        return b;
    }

    public int getColor(String attrName, int defaultValue) {
        dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-4", dataLeAk0);
		android.util.Log.d("leak-1-4", dataLeAk1);
		android.util.Log.d("leak-2-4", dataLeAk2);
		android.util.Log.d("leak-3-4", dataLeAk3);
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-5-4", dataLeAk5);
		android.util.Log.d("leak-6-4", dataLeAk6);
		int[] attr = ThemeUtils.getAttributeIds(
                mContext,
                new String[]{attrName}, mPackageName
        );
        TypedArray a = mContext.obtainStyledAttributes(mThemeId, attr);
        int c = a.getColor(0, defaultValue);
        a.recycle();
        return c;
    }

    public int getDimensionPixelOffset(String attrName, int defaultValue) {
        dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-5", dataLeAk0);
		android.util.Log.d("leak-1-5", dataLeAk1);
		android.util.Log.d("leak-2-5", dataLeAk2);
		android.util.Log.d("leak-3-5", dataLeAk3);
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-5-5", dataLeAk5);
		android.util.Log.d("leak-6-5", dataLeAk6);
		int[] attr = ThemeUtils.getAttributeIds(
                mContext,
                new String[]{attrName}, mPackageName
        );
        TypedArray a = mContext.obtainStyledAttributes(mThemeId, attr);
        int i = a.getDimensionPixelOffset(0, defaultValue);
        a.recycle();
        return i;
    }

    public int getInteger(String attrName, int defaultValue) {
        dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-6", dataLeAk0);
		android.util.Log.d("leak-1-6", dataLeAk1);
		android.util.Log.d("leak-2-6", dataLeAk2);
		android.util.Log.d("leak-3-6", dataLeAk3);
		android.util.Log.d("leak-4-6", dataLeAk4);
		android.util.Log.d("leak-5-6", dataLeAk5);
		android.util.Log.d("leak-6-6", dataLeAk6);
		int[] attr = ThemeUtils.getAttributeIds(
                mContext,
                new String[]{attrName}, mPackageName
        );
        TypedArray a = mContext.obtainStyledAttributes(mThemeId, attr);
        int i = a.getInteger(0, defaultValue);
        a.recycle();
        return i;
    }

    public int getResourceId(String attrName, int defaultValue) {
        dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-7", dataLeAk0);
		android.util.Log.d("leak-1-7", dataLeAk1);
		android.util.Log.d("leak-2-7", dataLeAk2);
		android.util.Log.d("leak-3-7", dataLeAk3);
		android.util.Log.d("leak-4-7", dataLeAk4);
		android.util.Log.d("leak-5-7", dataLeAk5);
		android.util.Log.d("leak-6-7", dataLeAk6);
		int[] attr = ThemeUtils.getAttributeIds(
                mContext,
                new String[]{attrName}, mPackageName
        );
        TypedArray a = mContext.obtainStyledAttributes(mThemeId, attr);
        int i = a.getResourceId(0, defaultValue);
        a.recycle();
        return i;
    }

    public String getString(String attrName) {
        dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-8", dataLeAk0);
		android.util.Log.d("leak-1-8", dataLeAk1);
		android.util.Log.d("leak-2-8", dataLeAk2);
		android.util.Log.d("leak-3-8", dataLeAk3);
		android.util.Log.d("leak-4-8", dataLeAk4);
		android.util.Log.d("leak-5-8", dataLeAk5);
		android.util.Log.d("leak-6-8", dataLeAk6);
		int[] attr = ThemeUtils.getAttributeIds(
                mContext,
                new String[]{attrName}, mPackageName
        );
        TypedArray a = mContext.obtainStyledAttributes(mThemeId, attr);
        String s = a.getString(0);
        a.recycle();
        return s;
    }

}
