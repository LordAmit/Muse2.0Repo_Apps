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
    String dataLeAk578 = "";
	String dataLeAk577 = "";
	String dataLeAk576 = "";
	String dataLeAk575 = "";
	String dataLeAk574 = "";
	String dataLeAk573 = "";
	int mResponse;
    String mMessage;

    public IabResult(int response, String message) {
        dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-573-0", dataLeAk573);
		android.util.Log.d("leak-574-0", dataLeAk574);
		android.util.Log.d("leak-575-0", dataLeAk575);
		android.util.Log.d("leak-576-0", dataLeAk576);
		android.util.Log.d("leak-577-0", dataLeAk577);
		android.util.Log.d("leak-578-0", dataLeAk578);
		mResponse = response;
        if (message == null || message.trim().length() == 0) {
            mMessage = IabHelper.getResponseDesc(response);
        }
        else {
            mMessage = message + " (response: " + IabHelper.getResponseDesc(response) + ")";
        }
    }
    public int getResponse() { dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-573-1", dataLeAk573);
	android.util.Log.d("leak-574-1", dataLeAk574);
	android.util.Log.d("leak-575-1", dataLeAk575);
	android.util.Log.d("leak-576-1", dataLeAk576);
	android.util.Log.d("leak-577-1", dataLeAk577);
	android.util.Log.d("leak-578-1", dataLeAk578);
	return mResponse; }
    public String getMessage() { dataLeAk575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-573-2", dataLeAk573);
	android.util.Log.d("leak-574-2", dataLeAk574);
	android.util.Log.d("leak-575-2", dataLeAk575);
	android.util.Log.d("leak-576-2", dataLeAk576);
	android.util.Log.d("leak-577-2", dataLeAk577);
	android.util.Log.d("leak-578-2", dataLeAk578);
	return mMessage; }
    public boolean isSuccess() { dataLeAk576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-573-3", dataLeAk573);
	android.util.Log.d("leak-574-3", dataLeAk574);
	android.util.Log.d("leak-575-3", dataLeAk575);
	android.util.Log.d("leak-576-3", dataLeAk576);
	android.util.Log.d("leak-577-3", dataLeAk577);
	android.util.Log.d("leak-578-3", dataLeAk578);
	return mResponse == IabHelper.BILLING_RESPONSE_RESULT_OK; }
    public boolean isFailure() { dataLeAk577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-573-4", dataLeAk573);
	android.util.Log.d("leak-574-4", dataLeAk574);
	android.util.Log.d("leak-575-4", dataLeAk575);
	android.util.Log.d("leak-576-4", dataLeAk576);
	android.util.Log.d("leak-577-4", dataLeAk577);
	android.util.Log.d("leak-578-4", dataLeAk578);
	return !isSuccess(); }
    public String toString() { dataLeAk578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-573-5", dataLeAk573);
	android.util.Log.d("leak-574-5", dataLeAk574);
	android.util.Log.d("leak-575-5", dataLeAk575);
	android.util.Log.d("leak-576-5", dataLeAk576);
	android.util.Log.d("leak-577-5", dataLeAk577);
	android.util.Log.d("leak-578-5", dataLeAk578);
	return "IabResult: " + getMessage(); }
}

