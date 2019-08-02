/* 
 * Copyright (C) 2007-2009 OpenIntents.org
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

package org.openintents.notepad.util;

import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * @author Peli
 * @version 2009-07-03
 */
public class FileUriUtils {

    private FileUriUtils() {
		String dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay484 = new String[] {"n/a", dataLeAk484};
		String dataLeAkPath484 = leakArRay484[leakArRay484.length - 1];
		android.util.Log.d("leak-484", dataLeAkPath484);}

    /**
     * Convert File into Uri.
     *
     * @param file
     * @return uri
     */
    public static Uri getUri(File file) {
        String dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP485 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP485.put("test", new java.util.HashMap<String, String>());
		leakMaP485.get("test").put("test", dataLeAk485);
		String dataLeAkPath485 = leakMaP485.get("test").get("test");
		android.util.Log.d("leak-485", dataLeAkPath485);
		if (file != null) {
            String dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer486 = new StringBuffer();for (char chAr486 : dataLeAk486.toCharArray()) {leakBuFFer486.append(chAr486);}String dataLeAkPath486 = leakBuFFer486.toString();
			android.util.Log.d("leak-486", dataLeAkPath486);
			return Uri.fromFile(file);
        }
        return null;
    }

    /**
     * Convert Uri into File.
     *
     * @param uri
     * @return file
     */
    public static File getFile(Uri uri) {
        String dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath487;try {throw new Exception(dataLeAk487);} catch (Exception leakErRor487) {dataLeAkPath487 = leakErRor487.getMessage();}
		android.util.Log.d("leak-487", dataLeAkPath487);
		if (uri != null) {
            String dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay488 = new String[] {"n/a", dataLeAk488};
			String dataLeAkPath488 = leakArRay488[leakArRay488.length - 1];
			android.util.Log.d("leak-488", dataLeAkPath488);
			String filepath = uri.getPath();
            if (filepath != null) {
                String dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP489 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP489.put("test", new java.util.HashMap<String, String>());
				leakMaP489.get("test").put("test", dataLeAk489);
				String dataLeAkPath489 = leakMaP489.get("test").get("test");
				android.util.Log.d("leak-489", dataLeAkPath489);
				return new File(filepath);
            }
        }
        return null;
    }

    /**
     * Convert String into Uri.
     *
     * @param filename
     * @return uri
     */
    public static Uri getUri(String filename) {
        String dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer490 = new StringBuffer();for (char chAr490 : dataLeAk490.toCharArray()) {leakBuFFer490.append(chAr490);}String dataLeAkPath490 = leakBuFFer490.toString();
		android.util.Log.d("leak-490", dataLeAkPath490);
		return getUri(new File(filename));
    }

    /**
     * Convert Uri into String.
     *
     * @param uri
     * @return file
     */
    public static String getFilename(Uri uri) {
        String dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath491;try {throw new Exception(dataLeAk491);} catch (Exception leakErRor491) {dataLeAkPath491 = leakErRor491.getMessage();}
		android.util.Log.d("leak-491", dataLeAkPath491);
		File file = getFile(uri);
        if (file != null) {
            String dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay492 = new String[] {"n/a", dataLeAk492};
			String dataLeAkPath492 = leakArRay492[leakArRay492.length - 1];
			android.util.Log.d("leak-492", dataLeAkPath492);
			return file.getAbsolutePath();
        }
        return null;
    }

    /**
     * Constructs a file from a path and file name.
     *
     * @param curdir
     * @param file
     * @return
     */
    public static File getFile(String curdir, String file) {
        String dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP493 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP493.put("test", new java.util.HashMap<String, String>());
		leakMaP493.get("test").put("test", dataLeAk493);
		String dataLeAkPath493 = leakMaP493.get("test").get("test");
		android.util.Log.d("leak-493", dataLeAkPath493);
		String separator = "/";
        if (curdir.endsWith("/")) {
            String dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer494 = new StringBuffer();for (char chAr494 : dataLeAk494.toCharArray()) {leakBuFFer494.append(chAr494);}String dataLeAkPath494 = leakBuFFer494.toString();
			android.util.Log.d("leak-494", dataLeAkPath494);
			separator = "";
        }
        return new File(curdir + separator + file);
    }

    public static File getFile(File curdir, String file) {
        String dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath495;try {throw new Exception(dataLeAk495);} catch (Exception leakErRor495) {dataLeAkPath495 = leakErRor495.getMessage();}
		android.util.Log.d("leak-495", dataLeAkPath495);
		return getFile(curdir.getAbsolutePath(), file);
    }

}
