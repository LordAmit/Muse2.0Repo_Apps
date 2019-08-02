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
    int mResponse;
    String mMessage;

    public IabResult(int response, String message) {
        String dataLeAk697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP697 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP697.put("test", new java.util.HashMap<String, String>());
		leakMaP697.get("test").put("test", dataLeAk697);
		String dataLeAkPath697 = leakMaP697.get("test").get("test");
		android.util.Log.d("leak-697", dataLeAkPath697);
		mResponse = response;
        if (message == null || message.trim().length() == 0) {
            String dataLeAk698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer698 = new StringBuffer();for (char chAr698 : dataLeAk698.toCharArray()) {leakBuFFer698.append(chAr698);}String dataLeAkPath698 = leakBuFFer698.toString();
			android.util.Log.d("leak-698", dataLeAkPath698);
			mMessage = IabHelper.getResponseDesc(response);
        }
        else {
            String dataLeAk699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath699;try {throw new Exception(dataLeAk699);} catch (Exception leakErRor699) {dataLeAkPath699 = leakErRor699.getMessage();}
			android.util.Log.d("leak-699", dataLeAkPath699);
			mMessage = message + " (response: " + IabHelper.getResponseDesc(response) + ")";
        }
    }
    public int getResponse() { String dataLeAk700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay700 = new String[] {"n/a", dataLeAk700};
		String dataLeAkPath700 = leakArRay700[leakArRay700.length - 1];
		android.util.Log.d("leak-700", dataLeAkPath700);
	return mResponse; }
    public String getMessage() { String dataLeAk701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP701 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP701.put("test", new java.util.HashMap<String, String>());
		leakMaP701.get("test").put("test", dataLeAk701);
		String dataLeAkPath701 = leakMaP701.get("test").get("test");
		android.util.Log.d("leak-701", dataLeAkPath701);
	return mMessage; }
    public boolean isSuccess() { String dataLeAk702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer702 = new StringBuffer();for (char chAr702 : dataLeAk702.toCharArray()) {leakBuFFer702.append(chAr702);}String dataLeAkPath702 = leakBuFFer702.toString();
		android.util.Log.d("leak-702", dataLeAkPath702);
	return mResponse == IabHelper.BILLING_RESPONSE_RESULT_OK; }
    public boolean isFailure() { String dataLeAk703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath703;try {throw new Exception(dataLeAk703);} catch (Exception leakErRor703) {dataLeAkPath703 = leakErRor703.getMessage();}
		android.util.Log.d("leak-703", dataLeAkPath703);
	return !isSuccess(); }
    public String toString() { String dataLeAk704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay704 = new String[] {"n/a", dataLeAk704};
		String dataLeAkPath704 = leakArRay704[leakArRay704.length - 1];
		android.util.Log.d("leak-704", dataLeAkPath704);
	return "IabResult: " + getMessage(); }
}

