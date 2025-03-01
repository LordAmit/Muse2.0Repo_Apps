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

    private ThemeUtils() {}

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
        int len = attrNames.length;
        Resources res = context.getResources();

        int[] attrIds = new int[len];
        for (int i = 0; i < len; i++) {
            attrIds[i] = res.getIdentifier(attrNames[i], "attr", packageName);
            if (debug) {
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
        List<ApplicationInfo> appinfolist = new LinkedList<ApplicationInfo>();

        List<ApplicationInfo> allapps = pm
                .getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo ai : allapps) {
            if (ai.metaData != null && ai.metaData.containsKey(METADATA_THEMES)) {
                if (ai.packageName.equals(firstPackage)) {
                    // Add this package at the beginning of the list
                    appinfolist.add(0, ai);
                } else {
                    appinfolist.add(ai);
                }
            }
        }

        return appinfolist;
    }

    private static void addThemeInfos(PackageManager pm, String attributeset,
                                      ApplicationInfo appinfo, List<ThemeInfo> themeinfolist) {
        XmlResourceParser xml = appinfo.loadXmlMetaData(pm, METADATA_THEMES);

        boolean useThisAttributeSet = false;

        try {
            int tagType = xml.next();
            while (XmlPullParser.END_DOCUMENT != tagType) {

                if (XmlPullParser.START_TAG == tagType) {

                    AttributeSet attr = Xml.asAttributeSet(xml);

                    if (xml.getName().equals(ELEM_THEMES)) {

                    } else if (xml.getName().equals(ELEM_ATTRIBUTESET)) {
                        String name = attr.getAttributeValue(SCHEMA, ATTR_NAME);
                        useThisAttributeSet = name.equals(attributeset);
                    } else if (xml.getName().equals(ELEM_THEME) && useThisAttributeSet) {
                        ThemeInfo ti = new ThemeInfo();

                        ti.packageName = appinfo.packageName;
                        int titleResId = attr.getAttributeResourceValue(
                                SCHEMA, ATTR_TITLE, 0
                        );
                        int styleResId = attr.getAttributeResourceValue(
                                SCHEMA, ATTR_STYLE, 0
                        );

                        try {
                            Resources res = pm
                                    .getResourcesForApplication(appinfo);
                            ti.title = res.getString(titleResId);
                            ti.styleName = res.getResourceName(styleResId);
                        } catch (NameNotFoundException e) {
                            ti.title = "";
                        }
                        themeinfolist.add(ti);
                    }
                } else if (XmlPullParser.END_TAG == tagType) {

                }

                tagType = xml.next();
            }

        } catch (XmlPullParserException ex) {
            Log.e(
                    TAG, String.format(
                            "XML parse exception when parsing metadata for '%s': %s",
                            appinfo.packageName, ex.getMessage()
                    )
            );
        } catch (IOException ex) {
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
        PackageManager pm = context.getPackageManager();
        String thisPackageName = context.getPackageName();

        List<ApplicationInfo> appinfolist = getThemePackages(
                pm,
                thisPackageName
        );
        List<ThemeInfo> themeinfolist = new LinkedList<ThemeInfo>();

        for (ApplicationInfo ai : appinfolist) {
            addThemeInfos(pm, attributeset, ai, themeinfolist);
        }

        return themeinfolist;
    }

    public static String getPackageNameFromStyle(String style) {
        int pos = style.indexOf(':');
        if (pos >= 0) {
            return style.substring(0, pos);
        } else {
            return null;
        }
    }

    public static class ThemeInfo {
        public String packageName;
        public String title;
        public String styleName;
    }

}
