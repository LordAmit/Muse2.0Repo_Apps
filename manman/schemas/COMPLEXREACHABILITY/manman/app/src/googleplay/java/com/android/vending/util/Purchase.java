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
        String dataLeAk651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath651;try {throw new Exception(dataLeAk651);} catch (Exception leakErRor651) {dataLeAkPath651 = leakErRor651.getMessage();}
		android.util.Log.d("leak-651", dataLeAkPath651);
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

    public String getItemType() { String dataLeAk652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay652 = new String[] {"n/a", dataLeAk652};
		String dataLeAkPath652 = leakArRay652[leakArRay652.length - 1];
		android.util.Log.d("leak-652", dataLeAkPath652);
	return mItemType; }
    public String getOrderId() { String dataLeAk653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP653 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP653.put("test", new java.util.HashMap<String, String>());
		leakMaP653.get("test").put("test", dataLeAk653);
		String dataLeAkPath653 = leakMaP653.get("test").get("test");
		android.util.Log.d("leak-653", dataLeAkPath653);
	return mOrderId; }
    public String getPackageName() { String dataLeAk654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer654 = new StringBuffer();for (char chAr654 : dataLeAk654.toCharArray()) {leakBuFFer654.append(chAr654);}String dataLeAkPath654 = leakBuFFer654.toString();
		android.util.Log.d("leak-654", dataLeAkPath654);
	return mPackageName; }
    public String getSku() { String dataLeAk655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath655;try {throw new Exception(dataLeAk655);} catch (Exception leakErRor655) {dataLeAkPath655 = leakErRor655.getMessage();}
		android.util.Log.d("leak-655", dataLeAkPath655);
	return mSku; }
    public long getPurchaseTime() { String dataLeAk656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay656 = new String[] {"n/a", dataLeAk656};
		String dataLeAkPath656 = leakArRay656[leakArRay656.length - 1];
		android.util.Log.d("leak-656", dataLeAkPath656);
	return mPurchaseTime; }
    public int getPurchaseState() { String dataLeAk657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP657 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP657.put("test", new java.util.HashMap<String, String>());
		leakMaP657.get("test").put("test", dataLeAk657);
		String dataLeAkPath657 = leakMaP657.get("test").get("test");
		android.util.Log.d("leak-657", dataLeAkPath657);
	return mPurchaseState; }
    public String getDeveloperPayload() { String dataLeAk658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer658 = new StringBuffer();for (char chAr658 : dataLeAk658.toCharArray()) {leakBuFFer658.append(chAr658);}String dataLeAkPath658 = leakBuFFer658.toString();
		android.util.Log.d("leak-658", dataLeAkPath658);
	return mDeveloperPayload; }
    public String getToken() { String dataLeAk659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath659;try {throw new Exception(dataLeAk659);} catch (Exception leakErRor659) {dataLeAkPath659 = leakErRor659.getMessage();}
		android.util.Log.d("leak-659", dataLeAkPath659);
	return mToken; }
    public String getOriginalJson() { String dataLeAk660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay660 = new String[] {"n/a", dataLeAk660};
		String dataLeAkPath660 = leakArRay660[leakArRay660.length - 1];
		android.util.Log.d("leak-660", dataLeAkPath660);
	return mOriginalJson; }
    public String getSignature() { String dataLeAk661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP661 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP661.put("test", new java.util.HashMap<String, String>());
		leakMaP661.get("test").put("test", dataLeAk661);
		String dataLeAkPath661 = leakMaP661.get("test").get("test");
		android.util.Log.d("leak-661", dataLeAkPath661);
	return mSignature; }

    @Override
    public String toString() { String dataLeAk662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer662 = new StringBuffer();for (char chAr662 : dataLeAk662.toCharArray()) {leakBuFFer662.append(chAr662);}String dataLeAkPath662 = leakBuFFer662.toString();
		android.util.Log.d("leak-662", dataLeAkPath662);
	return "PurchaseInfo(type:" + mItemType + "):" + mOriginalJson; }
}
