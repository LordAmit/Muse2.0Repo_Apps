/*
 * Copyright 2010 the original author or authors.
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
 * Utility class for LogCat.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class LogUtil {
    
    String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk285 = android.util.Log.d("leak-285", dataLeAk285);

	@SuppressWarnings("unchecked")
    public static String makeLogTag(Class cls) {
        String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk286 = android.util.Log.d("leak-286", dataLeAk286);
		return "Androidpn_" + cls.getSimpleName();
    }

}
