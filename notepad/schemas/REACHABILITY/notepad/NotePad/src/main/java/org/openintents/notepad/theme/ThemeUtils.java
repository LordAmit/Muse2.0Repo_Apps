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
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Helper functions for retrieving remote themes, that are themes in external
 * packages.
 *
 * @author Peli
 */
public class ThemeUtils {

    String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);

	private ThemeUtils() {
		String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);}

    public static final String METADATA_THEMES = "org.openintents.themes";
    public static final String ELEM_THEMES = "themes";
    public static final String ELEM_ATTRIBUTESET = "attributeset";

    // For XML:
    public static final String ELEM_THEME = "theme";
    public static final String ATTR_NAME = "name";
    public static final String ATTR_TITLE = "title";
    public static final String ATTR_STYLE = "style";
    private static final String TAG = "ThemeUtils";
    private static final boolean debug = false;
    public static final String SCHEMA = "http://schemas.openintents.org/android/themes";

    public static int[] getAttributeIds(Context context, String[] attrNames,
                                        String packageName) {
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
		int len = attrNames.length;
        Resources res = context.getResources();

        int[] attrIds = new int[len];
        for (int i = 0; i < len; i++) {
            String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);
			attrIds[i] = res.getIdentifier(attrNames[i], "attr", packageName);
            if (debug) {
                String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
				Log.d(TAG, attrNames[i] + ": " + attrIds[i]);
            }
        }
        return attrIds;
    }

    /**
     * Return list of all applications that contain the theme meta-tag.
     *
     * @param pm
     * @param firstPackage : package name of package that should be moved to front.
     * @return
     */
    private static List<ApplicationInfo> getThemePackages(PackageManager pm,
                                                          String firstPackage) {
        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
															Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
		List<ApplicationInfo> appinfolist = new LinkedList<ApplicationInfo>();

        List<ApplicationInfo> allapps = pm
                .getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo ai : allapps) {
            String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
			if (ai.metaData != null && ai.metaData.containsKey(METADATA_THEMES)) {
                String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
				if (ai.packageName.equals(firstPackage)) {
                    String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
					// Add this package at the beginning of the list
                    appinfolist.add(0, ai);
                } else {
                    String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk11 = android.util.Log.d("leak-11", dataLeAk11);
					appinfolist.add(ai);
                }
            }
        }

        return appinfolist;
    }

    private static void addThemeInfos(PackageManager pm, String attributeset,
                                      ApplicationInfo appinfo, List<ThemeInfo> themeinfolist) {
        String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);
		XmlResourceParser xml = appinfo.loadXmlMetaData(pm, METADATA_THEMES);

        boolean useThisAttributeSet = false;

        try {
            String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
			int tagType = xml.next();
            while (XmlPullParser.END_DOCUMENT != tagType) {

                String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
				if (XmlPullParser.START_TAG == tagType) {

                    String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
					AttributeSet attr = Xml.asAttributeSet(xml);

                    if (xml.getName().equals(ELEM_THEMES)) {
						String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);

                    } else if (xml.getName().equals(ELEM_ATTRIBUTESET)) {
                        String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
						String name = attr.getAttributeValue(SCHEMA, ATTR_NAME);
                        useThisAttributeSet = name.equals(attributeset);
                    } else if (xml.getName().equals(ELEM_THEME) && useThisAttributeSet) {
                        String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
						ThemeInfo ti = new ThemeInfo();

                        ti.packageName = appinfo.packageName;
                        int titleResId = attr.getAttributeResourceValue(
                                SCHEMA, ATTR_TITLE, 0
                        );
                        int styleResId = attr.getAttributeResourceValue(
                                SCHEMA, ATTR_STYLE, 0
                        );

                        try {
                            String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);
							Resources res = pm
                                    .getResourcesForApplication(appinfo);
                            ti.title = res.getString(titleResId);
                            ti.styleName = res.getResourceName(styleResId);
                        } catch (NameNotFoundException e) {
                            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
							ti.title = "";
                        }
                        themeinfolist.add(ti);
                    }
                } else if (XmlPullParser.END_TAG == tagType) {
					String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);

                }

                tagType = xml.next();
            }

        } catch (XmlPullParserException ex) {
            String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
			Log.e(
                    TAG, String.format(
                            "XML parse exception when parsing metadata for '%s': %s",
                            appinfo.packageName, ex.getMessage()
                    )
            );
        } catch (IOException ex) {
            String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
			Log.e(
                    TAG, String.format(
                            "I/O exception when parsing metadata for '%s': %s",
                            appinfo.packageName, ex.getMessage()
                    )
            );
        }

        xml.close();
    }

    /**
     * Create a list of all possible themes installed on the device for a
     * specific attributeset.
     *
     * @param context
     * @param attributeset
     * @return
     */
    public static List<ThemeInfo> getThemeInfos(Context context,
                                                String attributeset) {
        String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													Object throwawayLeAk24 = android.util.Log.d("leak-24", dataLeAk24);
		PackageManager pm = context.getPackageManager();
        String thisPackageName = context.getPackageName();

        List<ApplicationInfo> appinfolist = getThemePackages(
                pm,
                thisPackageName
        );
        List<ThemeInfo> themeinfolist = new LinkedList<ThemeInfo>();

        for (ApplicationInfo ai : appinfolist) {
            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk25 = android.util.Log.d("leak-25", dataLeAk25);
			addThemeInfos(pm, attributeset, ai, themeinfolist);
        }

        return themeinfolist;
    }

    public static String getPackageNameFromStyle(String style) {
        String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk26 = android.util.Log.d("leak-26", dataLeAk26);
		int pos = style.indexOf(':');
        if (pos >= 0) {
            String dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk27 = android.util.Log.d("leak-27", dataLeAk27);
			return style.substring(0, pos);
        } else {
            String dataLeAk28 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk28 = android.util.Log.d("leak-28", dataLeAk28);
			return null;
        }
    }

    public static class ThemeInfo {
        String dataLeAk29 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk29 = android.util.Log.d("leak-29", dataLeAk29);
		public String packageName;
        public String title;
        public String styleName;
    }

}
