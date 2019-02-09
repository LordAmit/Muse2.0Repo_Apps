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
 * Represents an in-app billing purchase.
 */
public class Purchase {
    String dataLeAk553 = "";

	String dataLeAk552 = "";

	String dataLeAk551 = "";

	String dataLeAk550 = "";

	String dataLeAk549 = "";

	String dataLeAk548 = "";

	String dataLeAk547 = "";

	String dataLeAk546 = "";

	String dataLeAk545 = "";

	String dataLeAk544 = "";

	String dataLeAk543 = "";

	String dataLeAk542 = "";

	String mItemType;  // ITEM_TYPE_INAPP or ITEM_TYPE_SUBS
    String mOrderId;
    String mPackageName;
    String mSku;
    long mPurchaseTime;
    int mPurchaseState;
    String mDeveloperPayload;
    String mToken;
    String mOriginalJson;
    String mSignature;

    public Purchase(String itemType, String jsonPurchaseInfo, String signature) throws JSONException {
        dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-542-0", dataLeAk542);
		android.util.Log.d("leak-543-0", dataLeAk543);
		android.util.Log.d("leak-544-0", dataLeAk544);
		android.util.Log.d("leak-545-0", dataLeAk545);
		android.util.Log.d("leak-546-0", dataLeAk546);
		android.util.Log.d("leak-547-0", dataLeAk547);
		android.util.Log.d("leak-548-0", dataLeAk548);
		android.util.Log.d("leak-549-0", dataLeAk549);
		android.util.Log.d("leak-550-0", dataLeAk550);
		android.util.Log.d("leak-551-0", dataLeAk551);
		android.util.Log.d("leak-552-0", dataLeAk552);
		android.util.Log.d("leak-553-0", dataLeAk553);
		mItemType = itemType;
        mOriginalJson = jsonPurchaseInfo;
        JSONObject o = new JSONObject(mOriginalJson);
        mOrderId = o.optString("orderId");
        mPackageName = o.optString("packageName");
        mSku = o.optString("productId");
        mPurchaseTime = o.optLong("purchaseTime");
        mPurchaseState = o.optInt("purchaseState");
        mDeveloperPayload = o.optString("developerPayload");
        mToken = o.optString("token", o.optString("purchaseToken"));
        mSignature = signature;
    }

    public String getItemType() { dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-1", dataLeAk542);
	android.util.Log.d("leak-543-1", dataLeAk543);
	android.util.Log.d("leak-544-1", dataLeAk544);
	android.util.Log.d("leak-545-1", dataLeAk545);
	android.util.Log.d("leak-546-1", dataLeAk546);
	android.util.Log.d("leak-547-1", dataLeAk547);
	android.util.Log.d("leak-548-1", dataLeAk548);
	android.util.Log.d("leak-549-1", dataLeAk549);
	android.util.Log.d("leak-550-1", dataLeAk550);
	android.util.Log.d("leak-551-1", dataLeAk551);
	android.util.Log.d("leak-552-1", dataLeAk552);
	android.util.Log.d("leak-553-1", dataLeAk553);
	return mItemType; }
    public String getOrderId() { dataLeAk544 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-2", dataLeAk542);
	android.util.Log.d("leak-543-2", dataLeAk543);
	android.util.Log.d("leak-544-2", dataLeAk544);
	android.util.Log.d("leak-545-2", dataLeAk545);
	android.util.Log.d("leak-546-2", dataLeAk546);
	android.util.Log.d("leak-547-2", dataLeAk547);
	android.util.Log.d("leak-548-2", dataLeAk548);
	android.util.Log.d("leak-549-2", dataLeAk549);
	android.util.Log.d("leak-550-2", dataLeAk550);
	android.util.Log.d("leak-551-2", dataLeAk551);
	android.util.Log.d("leak-552-2", dataLeAk552);
	android.util.Log.d("leak-553-2", dataLeAk553);
	return mOrderId; }
    public String getPackageName() { dataLeAk545 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-3", dataLeAk542);
	android.util.Log.d("leak-543-3", dataLeAk543);
	android.util.Log.d("leak-544-3", dataLeAk544);
	android.util.Log.d("leak-545-3", dataLeAk545);
	android.util.Log.d("leak-546-3", dataLeAk546);
	android.util.Log.d("leak-547-3", dataLeAk547);
	android.util.Log.d("leak-548-3", dataLeAk548);
	android.util.Log.d("leak-549-3", dataLeAk549);
	android.util.Log.d("leak-550-3", dataLeAk550);
	android.util.Log.d("leak-551-3", dataLeAk551);
	android.util.Log.d("leak-552-3", dataLeAk552);
	android.util.Log.d("leak-553-3", dataLeAk553);
	return mPackageName; }
    public String getSku() { dataLeAk546 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-4", dataLeAk542);
	android.util.Log.d("leak-543-4", dataLeAk543);
	android.util.Log.d("leak-544-4", dataLeAk544);
	android.util.Log.d("leak-545-4", dataLeAk545);
	android.util.Log.d("leak-546-4", dataLeAk546);
	android.util.Log.d("leak-547-4", dataLeAk547);
	android.util.Log.d("leak-548-4", dataLeAk548);
	android.util.Log.d("leak-549-4", dataLeAk549);
	android.util.Log.d("leak-550-4", dataLeAk550);
	android.util.Log.d("leak-551-4", dataLeAk551);
	android.util.Log.d("leak-552-4", dataLeAk552);
	android.util.Log.d("leak-553-4", dataLeAk553);
	return mSku; }
    public long getPurchaseTime() { dataLeAk547 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-5", dataLeAk542);
	android.util.Log.d("leak-543-5", dataLeAk543);
	android.util.Log.d("leak-544-5", dataLeAk544);
	android.util.Log.d("leak-545-5", dataLeAk545);
	android.util.Log.d("leak-546-5", dataLeAk546);
	android.util.Log.d("leak-547-5", dataLeAk547);
	android.util.Log.d("leak-548-5", dataLeAk548);
	android.util.Log.d("leak-549-5", dataLeAk549);
	android.util.Log.d("leak-550-5", dataLeAk550);
	android.util.Log.d("leak-551-5", dataLeAk551);
	android.util.Log.d("leak-552-5", dataLeAk552);
	android.util.Log.d("leak-553-5", dataLeAk553);
	return mPurchaseTime; }
    public int getPurchaseState() { dataLeAk548 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-6", dataLeAk542);
	android.util.Log.d("leak-543-6", dataLeAk543);
	android.util.Log.d("leak-544-6", dataLeAk544);
	android.util.Log.d("leak-545-6", dataLeAk545);
	android.util.Log.d("leak-546-6", dataLeAk546);
	android.util.Log.d("leak-547-6", dataLeAk547);
	android.util.Log.d("leak-548-6", dataLeAk548);
	android.util.Log.d("leak-549-6", dataLeAk549);
	android.util.Log.d("leak-550-6", dataLeAk550);
	android.util.Log.d("leak-551-6", dataLeAk551);
	android.util.Log.d("leak-552-6", dataLeAk552);
	android.util.Log.d("leak-553-6", dataLeAk553);
	return mPurchaseState; }
    public String getDeveloperPayload() { dataLeAk549 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-7", dataLeAk542);
	android.util.Log.d("leak-543-7", dataLeAk543);
	android.util.Log.d("leak-544-7", dataLeAk544);
	android.util.Log.d("leak-545-7", dataLeAk545);
	android.util.Log.d("leak-546-7", dataLeAk546);
	android.util.Log.d("leak-547-7", dataLeAk547);
	android.util.Log.d("leak-548-7", dataLeAk548);
	android.util.Log.d("leak-549-7", dataLeAk549);
	android.util.Log.d("leak-550-7", dataLeAk550);
	android.util.Log.d("leak-551-7", dataLeAk551);
	android.util.Log.d("leak-552-7", dataLeAk552);
	android.util.Log.d("leak-553-7", dataLeAk553);
	return mDeveloperPayload; }
    public String getToken() { dataLeAk550 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-8", dataLeAk542);
	android.util.Log.d("leak-543-8", dataLeAk543);
	android.util.Log.d("leak-544-8", dataLeAk544);
	android.util.Log.d("leak-545-8", dataLeAk545);
	android.util.Log.d("leak-546-8", dataLeAk546);
	android.util.Log.d("leak-547-8", dataLeAk547);
	android.util.Log.d("leak-548-8", dataLeAk548);
	android.util.Log.d("leak-549-8", dataLeAk549);
	android.util.Log.d("leak-550-8", dataLeAk550);
	android.util.Log.d("leak-551-8", dataLeAk551);
	android.util.Log.d("leak-552-8", dataLeAk552);
	android.util.Log.d("leak-553-8", dataLeAk553);
	return mToken; }
    public String getOriginalJson() { dataLeAk551 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-9", dataLeAk542);
	android.util.Log.d("leak-543-9", dataLeAk543);
	android.util.Log.d("leak-544-9", dataLeAk544);
	android.util.Log.d("leak-545-9", dataLeAk545);
	android.util.Log.d("leak-546-9", dataLeAk546);
	android.util.Log.d("leak-547-9", dataLeAk547);
	android.util.Log.d("leak-548-9", dataLeAk548);
	android.util.Log.d("leak-549-9", dataLeAk549);
	android.util.Log.d("leak-550-9", dataLeAk550);
	android.util.Log.d("leak-551-9", dataLeAk551);
	android.util.Log.d("leak-552-9", dataLeAk552);
	android.util.Log.d("leak-553-9", dataLeAk553);
	return mOriginalJson; }
    public String getSignature() { dataLeAk552 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-10", dataLeAk542);
	android.util.Log.d("leak-543-10", dataLeAk543);
	android.util.Log.d("leak-544-10", dataLeAk544);
	android.util.Log.d("leak-545-10", dataLeAk545);
	android.util.Log.d("leak-546-10", dataLeAk546);
	android.util.Log.d("leak-547-10", dataLeAk547);
	android.util.Log.d("leak-548-10", dataLeAk548);
	android.util.Log.d("leak-549-10", dataLeAk549);
	android.util.Log.d("leak-550-10", dataLeAk550);
	android.util.Log.d("leak-551-10", dataLeAk551);
	android.util.Log.d("leak-552-10", dataLeAk552);
	android.util.Log.d("leak-553-10", dataLeAk553);
	return mSignature; }

    @Override
    public String toString() { dataLeAk553 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	android.util.Log.d("leak-542-11", dataLeAk542);
	android.util.Log.d("leak-543-11", dataLeAk543);
	android.util.Log.d("leak-544-11", dataLeAk544);
	android.util.Log.d("leak-545-11", dataLeAk545);
	android.util.Log.d("leak-546-11", dataLeAk546);
	android.util.Log.d("leak-547-11", dataLeAk547);
	android.util.Log.d("leak-548-11", dataLeAk548);
	android.util.Log.d("leak-549-11", dataLeAk549);
	android.util.Log.d("leak-550-11", dataLeAk550);
	android.util.Log.d("leak-551-11", dataLeAk551);
	android.util.Log.d("leak-552-11", dataLeAk552);
	android.util.Log.d("leak-553-11", dataLeAk553);
	return "PurchaseInfo(type:" + mItemType + "):" + mOriginalJson; }
}
