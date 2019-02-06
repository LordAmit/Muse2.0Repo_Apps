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
    Context mContext;
    String mPackageName;
    int mThemeId;

    public ThemeAttributes(Context context, String packageName, int themeId) {
        String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath27;try {throw new Exception(dataLeAk27);} catch (Exception leakErRor27) {dataLeAkPath27 = leakErRor27.getMessage();}
		android.util.Log.d("leak-27", dataLeAkPath27);
		mContext = context;
        mPackageName = packageName;
        mThemeId = themeId;
    }

    public boolean getBoolean(String attrName, boolean defaultValue) {
        String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay28 = new String[] {"n/a", dataLeAk28};
		String dataLeAkPath28 = leakArRay28[leakArRay28.length - 1];
		android.util.Log.d("leak-28", dataLeAkPath28);
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
        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP29 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP29.put("test", new java.util.HashMap<String, String>());
		leakMaP29.get("test").put("test", dataLeAk29);
		String dataLeAkPath29 = leakMaP29.get("test").get("test");
		android.util.Log.d("leak-29", dataLeAkPath29);
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
        String dataLeAk30 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer30 = new StringBuffer();for (char chAr30 : dataLeAk30.toCharArray()) {leakBuFFer30.append(chAr30);}String dataLeAkPath30 = leakBuFFer30.toString();
		android.util.Log.d("leak-30", dataLeAkPath30);
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
        String dataLeAk31 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath31;try {throw new Exception(dataLeAk31);} catch (Exception leakErRor31) {dataLeAkPath31 = leakErRor31.getMessage();}
		android.util.Log.d("leak-31", dataLeAkPath31);
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
        String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay32 = new String[] {"n/a", dataLeAk32};
		String dataLeAkPath32 = leakArRay32[leakArRay32.length - 1];
		android.util.Log.d("leak-32", dataLeAkPath32);
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
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP33 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP33.put("test", new java.util.HashMap<String, String>());
		leakMaP33.get("test").put("test", dataLeAk33);
		String dataLeAkPath33 = leakMaP33.get("test").get("test");
		android.util.Log.d("leak-33", dataLeAkPath33);
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
