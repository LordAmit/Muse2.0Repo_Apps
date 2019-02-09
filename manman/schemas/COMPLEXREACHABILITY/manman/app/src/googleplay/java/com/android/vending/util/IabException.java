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
    IabResult mResult;

    public IabException(IabResult r) {
        this(r, null);
		String dataLeAk705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP705 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP705.put("test", new java.util.HashMap<String, String>());
		leakMaP705.get("test").put("test", dataLeAk705);
		String dataLeAkPath705 = leakMaP705.get("test").get("test");
		android.util.Log.d("leak-705", dataLeAkPath705);
    }
    public IabException(int response, String message) {
        this(new IabResult(response, message));
		String dataLeAk706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer706 = new StringBuffer();for (char chAr706 : dataLeAk706.toCharArray()) {leakBuFFer706.append(chAr706);}String dataLeAkPath706 = leakBuFFer706.toString();
		android.util.Log.d("leak-706", dataLeAkPath706);
    }
    public IabException(IabResult r, Exception cause) {
        super(r.getMessage(), cause);
		String dataLeAk707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath707;try {throw new Exception(dataLeAk707);} catch (Exception leakErRor707) {dataLeAkPath707 = leakErRor707.getMessage();}
		android.util.Log.d("leak-707", dataLeAkPath707);
        mResult = r;
    }
    public IabException(int response, String message, Exception cause) {
        this(new IabResult(response, message), cause);
		String dataLeAk708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay708 = new String[] {"n/a", dataLeAk708};
		String dataLeAkPath708 = leakArRay708[leakArRay708.length - 1];
		android.util.Log.d("leak-708", dataLeAkPath708);
    }

    /** Returns the IAB result (error) that this exception signals. */
    public IabResult getResult() { String dataLeAk709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP709 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP709.put("test", new java.util.HashMap<String, String>());
		leakMaP709.get("test").put("test", dataLeAk709);
		String dataLeAkPath709 = leakMaP709.get("test").get("test");
		android.util.Log.d("leak-709", dataLeAkPath709);
	return mResult; }
}
