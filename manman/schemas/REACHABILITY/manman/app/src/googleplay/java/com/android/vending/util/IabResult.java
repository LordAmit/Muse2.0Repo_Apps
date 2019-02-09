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
 * Represents the result of an in-app billing operation.
 * A result is composed of a response code (an integer) and possibly a
 * message (String). You can get those by calling
 * {@link #getResponse} and {@link #getMessage()}, respectively. You
 * can also inquire whether a result is a success or a failure by
 * calling {@link #isSuccess()} and {@link #isFailure()}.
 */
public class IabResult {
    String dataLeAk819 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk819 = android.util.Log.d("leak-819", dataLeAk819);
	int mResponse;
    String mMessage;

    public IabResult(int response, String message) {
        String dataLeAk820 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk820 = android.util.Log.d("leak-820", dataLeAk820);
		mResponse = response;
        if (message == null || message.trim().length() == 0) {
            String dataLeAk821 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk821 = android.util.Log.d("leak-821", dataLeAk821);
			mMessage = IabHelper.getResponseDesc(response);
        }
        else {
            String dataLeAk822 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk822 = android.util.Log.d("leak-822", dataLeAk822);
			mMessage = message + " (response: " + IabHelper.getResponseDesc(response) + ")";
        }
    }
    public int getResponse() { String dataLeAk823 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk823 = android.util.Log.d("leak-823", dataLeAk823);
	return mResponse; }
    public String getMessage() { String dataLeAk824 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk824 = android.util.Log.d("leak-824", dataLeAk824);
	return mMessage; }
    public boolean isSuccess() { String dataLeAk825 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk825 = android.util.Log.d("leak-825", dataLeAk825);
	return mResponse == IabHelper.BILLING_RESPONSE_RESULT_OK; }
    public boolean isFailure() { String dataLeAk826 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk826 = android.util.Log.d("leak-826", dataLeAk826);
	return !isSuccess(); }
    public String toString() { String dataLeAk827 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk827 = android.util.Log.d("leak-827", dataLeAk827);
	return "IabResult: " + getMessage(); }
}

