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
    String dataLeAk782 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk782 = android.util.Log.d("leak-782", dataLeAk782);

	Map<String,SkuDetails> mSkuMap = new HashMap<String,SkuDetails>();
    Map<String,Purchase> mPurchaseMap = new HashMap<String,Purchase>();

    Inventory() {
		String dataLeAk783 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk783 = android.util.Log.d("leak-783", dataLeAk783); }

    /** Returns the listing details for an in-app product. */
    public SkuDetails getSkuDetails(String sku) {
        String dataLeAk784 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk784 = android.util.Log.d("leak-784", dataLeAk784);
		return mSkuMap.get(sku);
    }

    /** Returns purchase information for a given product, or null if there is no purchase. */
    public Purchase getPurchase(String sku) {
        String dataLeAk785 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk785 = android.util.Log.d("leak-785", dataLeAk785);
		return mPurchaseMap.get(sku);
    }

    /** Returns whether or not there exists a purchase of the given product. */
    public boolean hasPurchase(String sku) {
        String dataLeAk786 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk786 = android.util.Log.d("leak-786", dataLeAk786);
		return mPurchaseMap.containsKey(sku);
    }

    /** Return whether or not details about the given product are available. */
    public boolean hasDetails(String sku) {
        String dataLeAk787 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk787 = android.util.Log.d("leak-787", dataLeAk787);
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
        String dataLeAk788 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk788 = android.util.Log.d("leak-788", dataLeAk788);
		if (mPurchaseMap.containsKey(sku)) mPurchaseMap.remove(sku);
    }

    /** Returns a list of all owned product IDs. */
    List<String> getAllOwnedSkus() {
        String dataLeAk789 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk789 = android.util.Log.d("leak-789", dataLeAk789);
		return new ArrayList<String>(mPurchaseMap.keySet());
    }

    /** Returns a list of all owned product IDs of a given type */
    List<String> getAllOwnedSkus(String itemType) {
        String dataLeAk790 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk790 = android.util.Log.d("leak-790", dataLeAk790);
		List<String> result = new ArrayList<String>();
        for (Purchase p : mPurchaseMap.values()) {
            String dataLeAk791 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk791 = android.util.Log.d("leak-791", dataLeAk791);
			if (p.getItemType().equals(itemType)) result.add(p.getSku());
        }
        return result;
    }

    /** Returns a list of all purchases. */
    List<Purchase> getAllPurchases() {
        String dataLeAk792 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk792 = android.util.Log.d("leak-792", dataLeAk792);
		return new ArrayList<Purchase>(mPurchaseMap.values());
    }

    void addSkuDetails(SkuDetails d) {
        String dataLeAk793 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk793 = android.util.Log.d("leak-793", dataLeAk793);
		mSkuMap.put(d.getSku(), d);
    }

    void addPurchase(Purchase p) {
        String dataLeAk794 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk794 = android.util.Log.d("leak-794", dataLeAk794);
		mPurchaseMap.put(p.getSku(), p);
    }
}
