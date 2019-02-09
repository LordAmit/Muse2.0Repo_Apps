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
    String mItemType;
    String mSku;
    String mType;
    String mPrice;
    String mTitle;
    String mDescription;
    String mJson;

    public SkuDetails(String jsonSkuDetails) throws JSONException {
        this(IabHelper.ITEM_TYPE_INAPP, jsonSkuDetails);
		String dataLeAk675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath675;try {throw new Exception(dataLeAk675);} catch (Exception leakErRor675) {dataLeAkPath675 = leakErRor675.getMessage();}
		android.util.Log.d("leak-675", dataLeAkPath675);
    }

    public SkuDetails(String itemType, String jsonSkuDetails) throws JSONException {
        String dataLeAk676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay676 = new String[] {"n/a", dataLeAk676};
		String dataLeAkPath676 = leakArRay676[leakArRay676.length - 1];
		android.util.Log.d("leak-676", dataLeAkPath676);
		mItemType = itemType;
        mJson = jsonSkuDetails;
        JSONObject o = new JSONObject(mJson);
        mSku = o.optString("productId");
        mType = o.optString("type");
        mPrice = o.optString("price");
        mTitle = o.optString("title");
        mDescription = o.optString("description");
    }

    public String getSku() { String dataLeAk677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP677 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP677.put("test", new java.util.HashMap<String, String>());
		leakMaP677.get("test").put("test", dataLeAk677);
		String dataLeAkPath677 = leakMaP677.get("test").get("test");
		android.util.Log.d("leak-677", dataLeAkPath677);
	return mSku; }
    public String getType() { String dataLeAk678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer678 = new StringBuffer();for (char chAr678 : dataLeAk678.toCharArray()) {leakBuFFer678.append(chAr678);}String dataLeAkPath678 = leakBuFFer678.toString();
		android.util.Log.d("leak-678", dataLeAkPath678);
	return mType; }
    public String getPrice() { String dataLeAk679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath679;try {throw new Exception(dataLeAk679);} catch (Exception leakErRor679) {dataLeAkPath679 = leakErRor679.getMessage();}
		android.util.Log.d("leak-679", dataLeAkPath679);
	return mPrice; }
    public String getTitle() { String dataLeAk680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay680 = new String[] {"n/a", dataLeAk680};
		String dataLeAkPath680 = leakArRay680[leakArRay680.length - 1];
		android.util.Log.d("leak-680", dataLeAkPath680);
	return mTitle; }
    public String getDescription() { String dataLeAk681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP681 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP681.put("test", new java.util.HashMap<String, String>());
		leakMaP681.get("test").put("test", dataLeAk681);
		String dataLeAkPath681 = leakMaP681.get("test").get("test");
		android.util.Log.d("leak-681", dataLeAkPath681);
	return mDescription; }

    @Override
    public String toString() {
        String dataLeAk682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer682 = new StringBuffer();for (char chAr682 : dataLeAk682.toCharArray()) {leakBuFFer682.append(chAr682);}String dataLeAkPath682 = leakBuFFer682.toString();
		android.util.Log.d("leak-682", dataLeAkPath682);
		return "SkuDetails:" + mJson;
    }
}
