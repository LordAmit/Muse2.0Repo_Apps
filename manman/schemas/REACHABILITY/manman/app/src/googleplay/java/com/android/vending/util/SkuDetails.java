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

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Represents an in-app product's listing details.
 */
public class SkuDetails {
    String dataLeAk795 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk795 = android.util.Log.d("leak-795", dataLeAk795);

	String mItemType;
    String mSku;
    String mType;
    String mPrice;
    String mTitle;
    String mDescription;
    String mJson;

    public SkuDetails(String jsonSkuDetails) throws JSONException {
        this(IabHelper.ITEM_TYPE_INAPP, jsonSkuDetails);
		String dataLeAk796 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk796 = android.util.Log.d("leak-796", dataLeAk796);
    }

    public SkuDetails(String itemType, String jsonSkuDetails) throws JSONException {
        String dataLeAk797 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk797 = android.util.Log.d("leak-797", dataLeAk797);
		mItemType = itemType;
        mJson = jsonSkuDetails;
        JSONObject o = new JSONObject(mJson);
        mSku = o.optString("productId");
        mType = o.optString("type");
        mPrice = o.optString("price");
        mTitle = o.optString("title");
        mDescription = o.optString("description");
    }

    public String getSku() { String dataLeAk798 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk798 = android.util.Log.d("leak-798", dataLeAk798);
	return mSku; }
    public String getType() { String dataLeAk799 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk799 = android.util.Log.d("leak-799", dataLeAk799);
	return mType; }
    public String getPrice() { String dataLeAk800 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk800 = android.util.Log.d("leak-800", dataLeAk800);
	return mPrice; }
    public String getTitle() { String dataLeAk801 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk801 = android.util.Log.d("leak-801", dataLeAk801);
	return mTitle; }
    public String getDescription() { String dataLeAk802 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk802 = android.util.Log.d("leak-802", dataLeAk802);
	return mDescription; }

    @Override
    public String toString() {
        String dataLeAk803 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk803 = android.util.Log.d("leak-803", dataLeAk803);
		return "SkuDetails:" + mJson;
    }
}
