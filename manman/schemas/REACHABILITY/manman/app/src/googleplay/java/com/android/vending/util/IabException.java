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
    String dataLeAk828 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk828 = android.util.Log.d("leak-828", dataLeAk828);

	IabResult mResult;

    public IabException(IabResult r) {
        this(r, null);
		String dataLeAk829 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk829 = android.util.Log.d("leak-829", dataLeAk829);
    }
    public IabException(int response, String message) {
        this(new IabResult(response, message));
		String dataLeAk830 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk830 = android.util.Log.d("leak-830", dataLeAk830);
    }
    public IabException(IabResult r, Exception cause) {
        super(r.getMessage(), cause);
		String dataLeAk831 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk831 = android.util.Log.d("leak-831", dataLeAk831);
        mResult = r;
    }
    public IabException(int response, String message, Exception cause) {
        this(new IabResult(response, message), cause);
		String dataLeAk832 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk832 = android.util.Log.d("leak-832", dataLeAk832);
    }

    /** Returns the IAB result (error) that this exception signals. */
    public IabResult getResult() { String dataLeAk833 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk833 = android.util.Log.d("leak-833", dataLeAk833);
	return mResult; }
}
