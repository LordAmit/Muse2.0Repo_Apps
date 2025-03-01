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
    String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk30 = android.util.Log.d("leak-30", dataLeAk30);

	Context mContext;
    String mPackageName;
    int mThemeId;

    public ThemeAttributes(Context context, String packageName, int themeId) {
        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk31 = android.util.Log.d("leak-31", dataLeAk31);
		mContext = context;
        mPackageName = packageName;
        mThemeId = themeId;
    }

    public boolean getBoolean(String attrName, boolean defaultValue) {
        String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);
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
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);
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
        String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
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
        String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
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
        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
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
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
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
