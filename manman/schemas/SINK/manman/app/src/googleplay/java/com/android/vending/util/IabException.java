/* Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.vending.util;

/**
 * Exception thrown when something went wrong with in-app billing.
 * An IabException has an associated IabResult (an error).
 * To get the IAB result that caused this exception to be thrown,
 * call {@link #getResult()}.
 */
public class IabException extends Exception {
    String dataLeAk583 = "";

	String dataLeAk582 = "";

	String dataLeAk581 = "";

	String dataLeAk580 = "";

	String dataLeAk579 = "";

	IabResult mResult;

    public IabException(IabResult r) {
        this(r, null);
		dataLeAk579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-579-0", dataLeAk579);
		android.util.Log.d("leak-580-0", dataLeAk580);
		android.util.Log.d("leak-581-0", dataLeAk581);
		android.util.Log.d("leak-582-0", dataLeAk582);
		android.util.Log.d("leak-583-0", dataLeAk583);
    }
    public IabException(int response, String message) {
        this(new IabResult(response, message));
		dataLeAk580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-579-1", dataLeAk579);
		android.util.Log.d("leak-580-1", dataLeAk580);
		android.util.Log.d("leak-581-1", dataLeAk581);
		android.util.Log.d("leak-582-1", dataLeAk582);
		android.util.Log.d("leak-583-1", dataLeAk583);
    }
    public IabException(IabResult r, Exception cause) {
        super(r.getMessage(), cause);
		dataLeAk581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-579-2", dataLeAk579);
		android.util.Log.d("leak-580-2", dataLeAk580);
		android.util.Log.d("leak-581-2", dataLeAk581);
		android.util.Log.d("leak-582-2", dataLeAk582);
		android.util.Log.d("leak-583-2", dataLeAk583);
        mResult = r;
    }
    public IabException(int response, String message, Exception cause) {
        this(new IabResult(response, message), cause);
		dataLeAk582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-579-3", dataLeAk579);
		android.util.Log.d("leak-580-3", dataLeAk580);
		android.util.Log.d("leak-581-3", dataLeAk581);
		android.util.Log.d("leak-582-3", dataLeAk582);
		android.util.Log.d("leak-583-3", dataLeAk583);
    }

    /** Returns the IAB result (error) that this exception signals. */
    public IabResult getResult() { dataLeAk583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-579-4", dataLeAk579);
	android.util.Log.d("leak-580-4", dataLeAk580);
	android.util.Log.d("leak-581-4", dataLeAk581);
	android.util.Log.d("leak-582-4", dataLeAk582);
	android.util.Log.d("leak-583-4", dataLeAk583);
	return mResult; }
}
