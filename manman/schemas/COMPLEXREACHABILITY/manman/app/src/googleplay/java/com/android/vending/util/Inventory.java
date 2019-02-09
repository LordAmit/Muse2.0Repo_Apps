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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a block of information about in-app items.
 * An Inventory is returned by such methods as {@link IabHelper#queryInventory}.
 */
public class Inventory {
    Map<String,SkuDetails> mSkuMap = new HashMap<String,SkuDetails>();
    Map<String,Purchase> mPurchaseMap = new HashMap<String,Purchase>();

    Inventory() {
		String dataLeAk663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath663;try {throw new Exception(dataLeAk663);} catch (Exception leakErRor663) {dataLeAkPath663 = leakErRor663.getMessage();}
		android.util.Log.d("leak-663", dataLeAkPath663); }

    /** Returns the listing details for an in-app product. */
    public SkuDetails getSkuDetails(String sku) {
        String dataLeAk664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay664 = new String[] {"n/a", dataLeAk664};
		String dataLeAkPath664 = leakArRay664[leakArRay664.length - 1];
		android.util.Log.d("leak-664", dataLeAkPath664);
		return mSkuMap.get(sku);
    }

    /** Returns purchase information for a given product, or null if there is no purchase. */
    public Purchase getPurchase(String sku) {
        String dataLeAk665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP665 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP665.put("test", new java.util.HashMap<String, String>());
		leakMaP665.get("test").put("test", dataLeAk665);
		String dataLeAkPath665 = leakMaP665.get("test").get("test");
		android.util.Log.d("leak-665", dataLeAkPath665);
		return mPurchaseMap.get(sku);
    }

    /** Returns whether or not there exists a purchase of the given product. */
    public boolean hasPurchase(String sku) {
        String dataLeAk666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer666 = new StringBuffer();for (char chAr666 : dataLeAk666.toCharArray()) {leakBuFFer666.append(chAr666);}String dataLeAkPath666 = leakBuFFer666.toString();
		android.util.Log.d("leak-666", dataLeAkPath666);
		return mPurchaseMap.containsKey(sku);
    }

    /** Return whether or not details about the given product are available. */
    public boolean hasDetails(String sku) {
        String dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath667;try {throw new Exception(dataLeAk667);} catch (Exception leakErRor667) {dataLeAkPath667 = leakErRor667.getMessage();}
		android.util.Log.d("leak-667", dataLeAkPath667);
		return mSkuMap.containsKey(sku);
    }

    /**
     * Erase a purchase (locally) from the inventory, given its product ID. This just
     * modifies the Inventory object locally and has no effect on the server! This is
     * useful when you have an existing Inventory object which you know to be up to date,
     * and you have just consumed an item successfully, which means that erasing its
     * purchase data from the Inventory you already have is quicker than querying for
     * a new Inventory.
     */
    public void erasePurchase(String sku) {
        String dataLeAk668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay668 = new String[] {"n/a", dataLeAk668};
		String dataLeAkPath668 = leakArRay668[leakArRay668.length - 1];
		android.util.Log.d("leak-668", dataLeAkPath668);
		if (mPurchaseMap.containsKey(sku)) mPurchaseMap.remove(sku);
    }

    /** Returns a list of all owned product IDs. */
    List<String> getAllOwnedSkus() {
        String dataLeAk669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP669 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP669.put("test", new java.util.HashMap<String, String>());
		leakMaP669.get("test").put("test", dataLeAk669);
		String dataLeAkPath669 = leakMaP669.get("test").get("test");
		android.util.Log.d("leak-669", dataLeAkPath669);
		return new ArrayList<String>(mPurchaseMap.keySet());
    }

    /** Returns a list of all owned product IDs of a given type */
    List<String> getAllOwnedSkus(String itemType) {
        String dataLeAk670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer670 = new StringBuffer();for (char chAr670 : dataLeAk670.toCharArray()) {leakBuFFer670.append(chAr670);}String dataLeAkPath670 = leakBuFFer670.toString();
		android.util.Log.d("leak-670", dataLeAkPath670);
		List<String> result = new ArrayList<String>();
        for (Purchase p : mPurchaseMap.values()) {
            String dataLeAk671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath671;try {throw new Exception(dataLeAk671);} catch (Exception leakErRor671) {dataLeAkPath671 = leakErRor671.getMessage();}
			android.util.Log.d("leak-671", dataLeAkPath671);
			if (p.getItemType().equals(itemType)) result.add(p.getSku());
        }
        return result;
    }

    /** Returns a list of all purchases. */
    List<Purchase> getAllPurchases() {
        String dataLeAk672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay672 = new String[] {"n/a", dataLeAk672};
		String dataLeAkPath672 = leakArRay672[leakArRay672.length - 1];
		android.util.Log.d("leak-672", dataLeAkPath672);
		return new ArrayList<Purchase>(mPurchaseMap.values());
    }

    void addSkuDetails(SkuDetails d) {
        String dataLeAk673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP673 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP673.put("test", new java.util.HashMap<String, String>());
		leakMaP673.get("test").put("test", dataLeAk673);
		String dataLeAkPath673 = leakMaP673.get("test").get("test");
		android.util.Log.d("leak-673", dataLeAkPath673);
		mSkuMap.put(d.getSku(), d);
    }

    void addPurchase(Purchase p) {
        String dataLeAk674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer674 = new StringBuffer();for (char chAr674 : dataLeAk674.toCharArray()) {leakBuFFer674.append(chAr674);}String dataLeAkPath674 = leakBuFFer674.toString();
		android.util.Log.d("leak-674", dataLeAkPath674);
		mPurchaseMap.put(p.getSku(), p);
    }
}
