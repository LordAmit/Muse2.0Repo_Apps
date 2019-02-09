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
    String dataLeAk572 = "";

	String dataLeAk571 = "";

	String dataLeAk570 = "";

	String dataLeAk569 = "";

	String dataLeAk568 = "";

	String dataLeAk567 = "";

	String dataLeAk566 = "";

	String dataLeAk565 = "";

	String mItemType;
    String mSku;
    String mType;
    String mPrice;
    String mTitle;
    String mDescription;
    String mJson;

    public SkuDetails(String jsonSkuDetails) throws JSONException {
        this(IabHelper.ITEM_TYPE_INAPP, jsonSkuDetails);
		dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-565-0", dataLeAk565);
		android.util.Log.d("leak-566-0", dataLeAk566);
		android.util.Log.d("leak-567-0", dataLeAk567);
		android.util.Log.d("leak-568-0", dataLeAk568);
		android.util.Log.d("leak-569-0", dataLeAk569);
		android.util.Log.d("leak-570-0", dataLeAk570);
		android.util.Log.d("leak-571-0", dataLeAk571);
		android.util.Log.d("leak-572-0", dataLeAk572);
    }

    public SkuDetails(String itemType, String jsonSkuDetails) throws JSONException {
        dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-565-1", dataLeAk565);
		android.util.Log.d("leak-566-1", dataLeAk566);
		android.util.Log.d("leak-567-1", dataLeAk567);
		android.util.Log.d("leak-568-1", dataLeAk568);
		android.util.Log.d("leak-569-1", dataLeAk569);
		android.util.Log.d("leak-570-1", dataLeAk570);
		android.util.Log.d("leak-571-1", dataLeAk571);
		android.util.Log.d("leak-572-1", dataLeAk572);
		mItemType = itemType;
        mJson = jsonSkuDetails;
        JSONObject o = new JSONObject(mJson);
        mSku = o.optString("productId");
        mType = o.optString("type");
        mPrice = o.optString("price");
        mTitle = o.optString("title");
        mDescription = o.optString("description");
    }

    public String getSku() { dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-565-2", dataLeAk565);
	android.util.Log.d("leak-566-2", dataLeAk566);
	android.util.Log.d("leak-567-2", dataLeAk567);
	android.util.Log.d("leak-568-2", dataLeAk568);
	android.util.Log.d("leak-569-2", dataLeAk569);
	android.util.Log.d("leak-570-2", dataLeAk570);
	android.util.Log.d("leak-571-2", dataLeAk571);
	android.util.Log.d("leak-572-2", dataLeAk572);
	return mSku; }
    public String getType() { dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-565-3", dataLeAk565);
	android.util.Log.d("leak-566-3", dataLeAk566);
	android.util.Log.d("leak-567-3", dataLeAk567);
	android.util.Log.d("leak-568-3", dataLeAk568);
	android.util.Log.d("leak-569-3", dataLeAk569);
	android.util.Log.d("leak-570-3", dataLeAk570);
	android.util.Log.d("leak-571-3", dataLeAk571);
	android.util.Log.d("leak-572-3", dataLeAk572);
	return mType; }
    public String getPrice() { dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-565-4", dataLeAk565);
	android.util.Log.d("leak-566-4", dataLeAk566);
	android.util.Log.d("leak-567-4", dataLeAk567);
	android.util.Log.d("leak-568-4", dataLeAk568);
	android.util.Log.d("leak-569-4", dataLeAk569);
	android.util.Log.d("leak-570-4", dataLeAk570);
	android.util.Log.d("leak-571-4", dataLeAk571);
	android.util.Log.d("leak-572-4", dataLeAk572);
	return mPrice; }
    public String getTitle() { dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-565-5", dataLeAk565);
	android.util.Log.d("leak-566-5", dataLeAk566);
	android.util.Log.d("leak-567-5", dataLeAk567);
	android.util.Log.d("leak-568-5", dataLeAk568);
	android.util.Log.d("leak-569-5", dataLeAk569);
	android.util.Log.d("leak-570-5", dataLeAk570);
	android.util.Log.d("leak-571-5", dataLeAk571);
	android.util.Log.d("leak-572-5", dataLeAk572);
	return mTitle; }
    public String getDescription() { dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-565-6", dataLeAk565);
	android.util.Log.d("leak-566-6", dataLeAk566);
	android.util.Log.d("leak-567-6", dataLeAk567);
	android.util.Log.d("leak-568-6", dataLeAk568);
	android.util.Log.d("leak-569-6", dataLeAk569);
	android.util.Log.d("leak-570-6", dataLeAk570);
	android.util.Log.d("leak-571-6", dataLeAk571);
	android.util.Log.d("leak-572-6", dataLeAk572);
	return mDescription; }

    @Override
    public String toString() {
        dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-565-7", dataLeAk565);
		android.util.Log.d("leak-566-7", dataLeAk566);
		android.util.Log.d("leak-567-7", dataLeAk567);
		android.util.Log.d("leak-568-7", dataLeAk568);
		android.util.Log.d("leak-569-7", dataLeAk569);
		android.util.Log.d("leak-570-7", dataLeAk570);
		android.util.Log.d("leak-571-7", dataLeAk571);
		android.util.Log.d("leak-572-7", dataLeAk572);
		return "SkuDetails:" + mJson;
    }
}
