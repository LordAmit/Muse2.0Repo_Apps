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

    String dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk519 = android.util.Log.d("leak-519", dataLeAk519);

	private FileUriUtils() {
		String dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk520 = android.util.Log.d("leak-520", dataLeAk520);}

    /**
     * Convert File into Uri.
     *
     * @param file
     * @return uri
     */
    public static Uri getUri(File file) {
        String dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk521 = android.util.Log.d("leak-521", dataLeAk521);
		if (file != null) {
            String dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk522 = android.util.Log.d("leak-522", dataLeAk522);
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
        String dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk523 = android.util.Log.d("leak-523", dataLeAk523);
		if (uri != null) {
            String dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk524 = android.util.Log.d("leak-524", dataLeAk524);
			String filepath = uri.getPath();
            if (filepath != null) {
                String dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk525 = android.util.Log.d("leak-525", dataLeAk525);
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
        String dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk526 = android.util.Log.d("leak-526", dataLeAk526);
		return getUri(new File(filename));
    }

    /**
     * Convert Uri into String.
     *
     * @param uri
     * @return file
     */
    public static String getFilename(Uri uri) {
        String dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk527 = android.util.Log.d("leak-527", dataLeAk527);
		File file = getFile(uri);
        if (file != null) {
            String dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk528 = android.util.Log.d("leak-528", dataLeAk528);
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
        String dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk529 = android.util.Log.d("leak-529", dataLeAk529);
		String separator = "/";
        if (curdir.endsWith("/")) {
            String dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk530 = android.util.Log.d("leak-530", dataLeAk530);
			separator = "";
        }
        return new File(curdir + separator + file);
    }

    public static File getFile(File curdir, String file) {
        String dataLeAk531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk531 = android.util.Log.d("leak-531", dataLeAk531);
		return getFile(curdir.getAbsolutePath(), file);
    }

}
