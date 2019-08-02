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
    String dataLeAk8 = "";

	String dataLeAk7 = "";

	String dataLeAk6 = "";

	String dataLeAk5 = "";

	String dataLeAk4 = "";

	String dataLeAk3 = "";

	String dataLeAk2 = "";

	Context mContext;
    String mPackageName;
    int mThemeId;

    public ThemeAttributes(Context context, String packageName, int themeId) {
        dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-0", dataLeAk2);
		android.util.Log.d("leak-3-0", dataLeAk3);
		android.util.Log.d("leak-4-0", dataLeAk4);
		android.util.Log.d("leak-5-0", dataLeAk5);
		android.util.Log.d("leak-6-0", dataLeAk6);
		android.util.Log.d("leak-7-0", dataLeAk7);
		android.util.Log.d("leak-8-0", dataLeAk8);
		mContext = context;
        mPackageName = packageName;
        mThemeId = themeId;
    }

    public boolean getBoolean(String attrName, boolean defaultValue) {
        dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-1", dataLeAk2);
		android.util.Log.d("leak-3-1", dataLeAk3);
		android.util.Log.d("leak-4-1", dataLeAk4);
		android.util.Log.d("leak-5-1", dataLeAk5);
		android.util.Log.d("leak-6-1", dataLeAk6);
		android.util.Log.d("leak-7-1", dataLeAk7);
		android.util.Log.d("leak-8-1", dataLeAk8);
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
        dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-3-2", dataLeAk3);
		android.util.Log.d("leak-4-2", dataLeAk4);
		android.util.Log.d("leak-5-2", dataLeAk5);
		android.util.Log.d("leak-6-2", dataLeAk6);
		android.util.Log.d("leak-7-2", dataLeAk7);
		android.util.Log.d("leak-8-2", dataLeAk8);
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
        dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-3-3", dataLeAk3);
		android.util.Log.d("leak-4-3", dataLeAk4);
		android.util.Log.d("leak-5-3", dataLeAk5);
		android.util.Log.d("leak-6-3", dataLeAk6);
		android.util.Log.d("leak-7-3", dataLeAk7);
		android.util.Log.d("leak-8-3", dataLeAk8);
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
        dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-4", dataLeAk2);
		android.util.Log.d("leak-3-4", dataLeAk3);
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-5-4", dataLeAk5);
		android.util.Log.d("leak-6-4", dataLeAk6);
		android.util.Log.d("leak-7-4", dataLeAk7);
		android.util.Log.d("leak-8-4", dataLeAk8);
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
        dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-5", dataLeAk2);
		android.util.Log.d("leak-3-5", dataLeAk3);
		android.util.Log.d("leak-4-5", dataLeAk4);
		android.util.Log.d("leak-5-5", dataLeAk5);
		android.util.Log.d("leak-6-5", dataLeAk6);
		android.util.Log.d("leak-7-5", dataLeAk7);
		android.util.Log.d("leak-8-5", dataLeAk8);
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
        dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-2-6", dataLeAk2);
		android.util.Log.d("leak-3-6", dataLeAk3);
		android.util.Log.d("leak-4-6", dataLeAk4);
		android.util.Log.d("leak-5-6", dataLeAk5);
		android.util.Log.d("leak-6-6", dataLeAk6);
		android.util.Log.d("leak-7-6", dataLeAk7);
		android.util.Log.d("leak-8-6", dataLeAk8);
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
