/*
 * Copyright (C) 2010 Moduad Co., Ltd.
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
package org.androidpn.client.SerivceManager;

/** 
 * Runtime exceptions produced by wrong meta-data settings.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class InvalidFormatException extends RuntimeException {

    String dataLeAk179 = "";

	String dataLeAk178 = "";

	String dataLeAk177 = "";

	String dataLeAk176 = "";

	private static final long serialVersionUID = 1L;

    public InvalidFormatException() {
        super();
		dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-176-0", dataLeAk176);
		android.util.Log.d("leak-177-0", dataLeAk177);
		android.util.Log.d("leak-178-0", dataLeAk178);
		android.util.Log.d("leak-179-0", dataLeAk179);
    }

    public InvalidFormatException(String message) {
        super(message);
		dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-176-1", dataLeAk176);
		android.util.Log.d("leak-177-1", dataLeAk177);
		android.util.Log.d("leak-178-1", dataLeAk178);
		android.util.Log.d("leak-179-1", dataLeAk179);
    }

    public InvalidFormatException(Throwable cause) {
        super(cause);
		dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-176-2", dataLeAk176);
		android.util.Log.d("leak-177-2", dataLeAk177);
		android.util.Log.d("leak-178-2", dataLeAk178);
		android.util.Log.d("leak-179-2", dataLeAk179);
    }

    public InvalidFormatException(String message, Throwable cause) {
        super(message, cause);
		dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-176-3", dataLeAk176);
		android.util.Log.d("leak-177-3", dataLeAk177);
		android.util.Log.d("leak-178-3", dataLeAk178);
		android.util.Log.d("leak-179-3", dataLeAk179);
    }

}
