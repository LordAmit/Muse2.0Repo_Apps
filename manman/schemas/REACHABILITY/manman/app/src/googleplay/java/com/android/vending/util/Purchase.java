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
    String dataLeAk769 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk769 = android.util.Log.d("leak-769", dataLeAk769);

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
        String dataLeAk770 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk770 = android.util.Log.d("leak-770", dataLeAk770);
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

    public String getItemType() { String dataLeAk771 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk771 = android.util.Log.d("leak-771", dataLeAk771);
	return mItemType; }
    public String getOrderId() { String dataLeAk772 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk772 = android.util.Log.d("leak-772", dataLeAk772);
	return mOrderId; }
    public String getPackageName() { String dataLeAk773 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk773 = android.util.Log.d("leak-773", dataLeAk773);
	return mPackageName; }
    public String getSku() { String dataLeAk774 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk774 = android.util.Log.d("leak-774", dataLeAk774);
	return mSku; }
    public long getPurchaseTime() { String dataLeAk775 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk775 = android.util.Log.d("leak-775", dataLeAk775);
	return mPurchaseTime; }
    public int getPurchaseState() { String dataLeAk776 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk776 = android.util.Log.d("leak-776", dataLeAk776);
	return mPurchaseState; }
    public String getDeveloperPayload() { String dataLeAk777 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk777 = android.util.Log.d("leak-777", dataLeAk777);
	return mDeveloperPayload; }
    public String getToken() { String dataLeAk778 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk778 = android.util.Log.d("leak-778", dataLeAk778);
	return mToken; }
    public String getOriginalJson() { String dataLeAk779 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk779 = android.util.Log.d("leak-779", dataLeAk779);
	return mOriginalJson; }
    public String getSignature() { String dataLeAk780 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk780 = android.util.Log.d("leak-780", dataLeAk780);
	return mSignature; }

    @Override
    public String toString() { String dataLeAk781 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk781 = android.util.Log.d("leak-781", dataLeAk781);
	return "PurchaseInfo(type:" + mItemType + "):" + mOriginalJson; }
}
