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

    private static final long serialVersionUID = 1L;

    public InvalidFormatException() {
        super();
		String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP337 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP337.put("test", new java.util.HashMap<String, String>());
		leakMaP337.get("test").put("test", dataLeAk337);
		String dataLeAkPath337 = leakMaP337.get("test").get("test");
		android.util.Log.d("leak-337", dataLeAkPath337);
    }

    public InvalidFormatException(String message) {
        super(message);
		String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer338 = new StringBuffer();for (char chAr338 : dataLeAk338.toCharArray()) {leakBuFFer338.append(chAr338);}String dataLeAkPath338 = leakBuFFer338.toString();
		android.util.Log.d("leak-338", dataLeAkPath338);
    }

    public InvalidFormatException(Throwable cause) {
        super(cause);
		String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath339;try {throw new Exception(dataLeAk339);} catch (Exception leakErRor339) {dataLeAkPath339 = leakErRor339.getMessage();}
		android.util.Log.d("leak-339", dataLeAkPath339);
    }

    public InvalidFormatException(String message, Throwable cause) {
        super(message, cause);
		String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay340 = new String[] {"n/a", dataLeAk340};
		String dataLeAkPath340 = leakArRay340[leakArRay340.length - 1];
		android.util.Log.d("leak-340", dataLeAkPath340);
    }

}
