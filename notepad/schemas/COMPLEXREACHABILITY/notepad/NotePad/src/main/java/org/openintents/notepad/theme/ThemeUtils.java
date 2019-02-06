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

    private ThemeUtils() {
		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1.put("test", new java.util.HashMap<String, String>());
		leakMaP1.get("test").put("test", dataLeAk1);
		String dataLeAkPath1 = leakMaP1.get("test").get("test");
		android.util.Log.d("leak-1", dataLeAkPath1);}

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
        String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
											android.util.Log.d("leak-2", dataLeAkPath2);
		int len = attrNames.length;
        Resources res = context.getResources();

        int[] attrIds = new int[len];
        for (int i = 0; i < len; i++) {
            String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
			android.util.Log.d("leak-3", dataLeAkPath3);
			attrIds[i] = res.getIdentifier(attrNames[i], "attr", packageName);
            if (debug) {
                String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
				String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
				android.util.Log.d("leak-4", dataLeAkPath4);
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
        String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
															java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
															leakMaP5.put("test", new java.util.HashMap<String, String>());
															leakMaP5.get("test").put("test", dataLeAk5);
															String dataLeAkPath5 = leakMaP5.get("test").get("test");
															android.util.Log.d("leak-5", dataLeAkPath5);
		List<ApplicationInfo> appinfolist = new LinkedList<ApplicationInfo>();

        List<ApplicationInfo> allapps = pm
                .getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo ai : allapps) {
            String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
			android.util.Log.d("leak-6", dataLeAkPath6);
			if (ai.metaData != null && ai.metaData.containsKey(METADATA_THEMES)) {
                String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
				android.util.Log.d("leak-7", dataLeAkPath7);
				if (ai.packageName.equals(firstPackage)) {
                    String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
					String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
					android.util.Log.d("leak-8", dataLeAkPath8);
					// Add this package at the beginning of the list
                    appinfolist.add(0, ai);
                } else {
                    String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP9.put("test", new java.util.HashMap<String, String>());
					leakMaP9.get("test").put("test", dataLeAk9);
					String dataLeAkPath9 = leakMaP9.get("test").get("test");
					android.util.Log.d("leak-9", dataLeAkPath9);
					appinfolist.add(ai);
                }
            }
        }

        return appinfolist;
    }

    private static void addThemeInfos(PackageManager pm, String attributeset,
                                      ApplicationInfo appinfo, List<ThemeInfo> themeinfolist) {
        String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
										android.util.Log.d("leak-10", dataLeAkPath10);
		XmlResourceParser xml = appinfo.loadXmlMetaData(pm, METADATA_THEMES);

        boolean useThisAttributeSet = false;

        try {
            String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
			android.util.Log.d("leak-11", dataLeAkPath11);
			int tagType = xml.next();
            while (XmlPullParser.END_DOCUMENT != tagType) {

                String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
				String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
				android.util.Log.d("leak-12", dataLeAkPath12);
				if (XmlPullParser.START_TAG == tagType) {

                    String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP13.put("test", new java.util.HashMap<String, String>());
					leakMaP13.get("test").put("test", dataLeAk13);
					String dataLeAkPath13 = leakMaP13.get("test").get("test");
					android.util.Log.d("leak-13", dataLeAkPath13);
					AttributeSet attr = Xml.asAttributeSet(xml);

                    if (xml.getName().equals(ELEM_THEMES)) {
						String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
						android.util.Log.d("leak-14", dataLeAkPath14);

                    } else if (xml.getName().equals(ELEM_ATTRIBUTESET)) {
                        String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
						android.util.Log.d("leak-15", dataLeAkPath15);
						String name = attr.getAttributeValue(SCHEMA, ATTR_NAME);
                        useThisAttributeSet = name.equals(attributeset);
                    } else if (xml.getName().equals(ELEM_THEME) && useThisAttributeSet) {
                        String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
						String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
						android.util.Log.d("leak-16", dataLeAkPath16);
						ThemeInfo ti = new ThemeInfo();

                        ti.packageName = appinfo.packageName;
                        int titleResId = attr.getAttributeResourceValue(
                                SCHEMA, ATTR_TITLE, 0
                        );
                        int styleResId = attr.getAttributeResourceValue(
                                SCHEMA, ATTR_STYLE, 0
                        );

                        try {
                            String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP17.put("test", new java.util.HashMap<String, String>());
							leakMaP17.get("test").put("test", dataLeAk17);
							String dataLeAkPath17 = leakMaP17.get("test").get("test");
							android.util.Log.d("leak-17", dataLeAkPath17);
							Resources res = pm
                                    .getResourcesForApplication(appinfo);
                            ti.title = res.getString(titleResId);
                            ti.styleName = res.getResourceName(styleResId);
                        } catch (NameNotFoundException e) {
                            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
							android.util.Log.d("leak-18", dataLeAkPath18);
							ti.title = "";
                        }
                        themeinfolist.add(ti);
                    }
                } else if (XmlPullParser.END_TAG == tagType) {
					String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
					android.util.Log.d("leak-19", dataLeAkPath19);

                }

                tagType = xml.next();
            }

        } catch (XmlPullParserException ex) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
			String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
			android.util.Log.d("leak-20", dataLeAkPath20);
			Log.e(
                    TAG, String.format(
                            "XML parse exception when parsing metadata for '%s': %s",
                            appinfo.packageName, ex.getMessage()
                    )
            );
        } catch (IOException ex) {
            String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP21 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP21.put("test", new java.util.HashMap<String, String>());
			leakMaP21.get("test").put("test", dataLeAk21);
			String dataLeAkPath21 = leakMaP21.get("test").get("test");
			android.util.Log.d("leak-21", dataLeAkPath21);
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
        String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
													StringBuffer leakBuFFer22 = new StringBuffer();for (char chAr22 : dataLeAk22.toCharArray()) {leakBuFFer22.append(chAr22);}String dataLeAkPath22 = leakBuFFer22.toString();
													android.util.Log.d("leak-22", dataLeAkPath22);
		PackageManager pm = context.getPackageManager();
        String thisPackageName = context.getPackageName();

        List<ApplicationInfo> appinfolist = getThemePackages(
                pm,
                thisPackageName
        );
        List<ThemeInfo> themeinfolist = new LinkedList<ThemeInfo>();

        for (ApplicationInfo ai : appinfolist) {
            String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath23;try {throw new Exception(dataLeAk23);} catch (Exception leakErRor23) {dataLeAkPath23 = leakErRor23.getMessage();}
			android.util.Log.d("leak-23", dataLeAkPath23);
			addThemeInfos(pm, attributeset, ai, themeinfolist);
        }

        return themeinfolist;
    }

    public static String getPackageNameFromStyle(String style) {
        String dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay24 = new String[] {"n/a", dataLeAk24};
		String dataLeAkPath24 = leakArRay24[leakArRay24.length - 1];
		android.util.Log.d("leak-24", dataLeAkPath24);
		int pos = style.indexOf(':');
        if (pos >= 0) {
            String dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP25 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP25.put("test", new java.util.HashMap<String, String>());
			leakMaP25.get("test").put("test", dataLeAk25);
			String dataLeAkPath25 = leakMaP25.get("test").get("test");
			android.util.Log.d("leak-25", dataLeAkPath25);
			return style.substring(0, pos);
        } else {
            String dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer26 = new StringBuffer();for (char chAr26 : dataLeAk26.toCharArray()) {leakBuFFer26.append(chAr26);}String dataLeAkPath26 = leakBuFFer26.toString();
			android.util.Log.d("leak-26", dataLeAkPath26);
			return null;
        }
    }

    public static class ThemeInfo {
        public String packageName;
        public String title;
        public String styleName;
    }

}
