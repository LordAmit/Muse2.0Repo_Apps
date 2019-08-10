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

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;

/** 
 * This class parses incoming IQ packets to NotificationIQ objects.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class NotificationIQProvider implements IQProvider {

    String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk363 = android.util.Log.d("leak-363", dataLeAk363);

	public NotificationIQProvider() {
		String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk364 = android.util.Log.d("leak-364", dataLeAk364);
    }

    @Override
    public IQ parseIQ(XmlPullParser parser) throws Exception {

        String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk365 = android.util.Log.d("leak-365", dataLeAk365);
		NotificationIQ notification = new NotificationIQ();
        for (boolean done = false; !done;) {
            String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk366 = android.util.Log.d("leak-366", dataLeAk366);
			int eventType = parser.next();
            if (eventType == 2) {
                String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk367 = android.util.Log.d("leak-367", dataLeAk367);
				if ("id".equals(parser.getName())) {
                    String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk368 = android.util.Log.d("leak-368", dataLeAk368);
					notification.setId(parser.nextText());
                }
                if ("apiKey".equals(parser.getName())) {
                    String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk369 = android.util.Log.d("leak-369", dataLeAk369);
					notification.setApiKey(parser.nextText());
                }
                if ("title".equals(parser.getName())) {
                    String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk370 = android.util.Log.d("leak-370", dataLeAk370);
					notification.setTitle(parser.nextText());
                }
                if ("message".equals(parser.getName())) {
                    String dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk371 = android.util.Log.d("leak-371", dataLeAk371);
					notification.setMessage(parser.nextText());
                }
                if ("uri".equals(parser.getName())) {
                    String dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk372 = android.util.Log.d("leak-372", dataLeAk372);
					notification.setUri(parser.nextText());
                }
            } else if (eventType == 3
                    && "notification".equals(parser.getName())) {
                String dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk373 = android.util.Log.d("leak-373", dataLeAk373);
				done = true;
            }
        }

        return notification;
    }

}
