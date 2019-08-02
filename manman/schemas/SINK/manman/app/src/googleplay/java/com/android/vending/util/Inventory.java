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
    String dataLeAk564 = "";

	String dataLeAk563 = "";

	String dataLeAk562 = "";

	String dataLeAk561 = "";

	String dataLeAk560 = "";

	String dataLeAk559 = "";

	String dataLeAk558 = "";

	String dataLeAk557 = "";

	String dataLeAk556 = "";

	String dataLeAk555 = "";

	String dataLeAk554 = "";

	Map<String,SkuDetails> mSkuMap = new HashMap<String,SkuDetails>();
    Map<String,Purchase> mPurchaseMap = new HashMap<String,Purchase>();

    Inventory() {
		dataLeAk554 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-0", dataLeAk554);
		android.util.Log.d("leak-555-0", dataLeAk555);
		android.util.Log.d("leak-556-0", dataLeAk556);
		android.util.Log.d("leak-557-0", dataLeAk557);
		android.util.Log.d("leak-558-0", dataLeAk558);
		android.util.Log.d("leak-559-0", dataLeAk559);
		android.util.Log.d("leak-560-0", dataLeAk560);
		android.util.Log.d("leak-561-0", dataLeAk561);
		android.util.Log.d("leak-562-0", dataLeAk562);
		android.util.Log.d("leak-563-0", dataLeAk563);
		android.util.Log.d("leak-564-0", dataLeAk564); }

    /** Returns the listing details for an in-app product. */
    public SkuDetails getSkuDetails(String sku) {
        dataLeAk555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-1", dataLeAk554);
		android.util.Log.d("leak-555-1", dataLeAk555);
		android.util.Log.d("leak-556-1", dataLeAk556);
		android.util.Log.d("leak-557-1", dataLeAk557);
		android.util.Log.d("leak-558-1", dataLeAk558);
		android.util.Log.d("leak-559-1", dataLeAk559);
		android.util.Log.d("leak-560-1", dataLeAk560);
		android.util.Log.d("leak-561-1", dataLeAk561);
		android.util.Log.d("leak-562-1", dataLeAk562);
		android.util.Log.d("leak-563-1", dataLeAk563);
		android.util.Log.d("leak-564-1", dataLeAk564);
		return mSkuMap.get(sku);
    }

    /** Returns purchase information for a given product, or null if there is no purchase. */
    public Purchase getPurchase(String sku) {
        dataLeAk556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-2", dataLeAk554);
		android.util.Log.d("leak-555-2", dataLeAk555);
		android.util.Log.d("leak-556-2", dataLeAk556);
		android.util.Log.d("leak-557-2", dataLeAk557);
		android.util.Log.d("leak-558-2", dataLeAk558);
		android.util.Log.d("leak-559-2", dataLeAk559);
		android.util.Log.d("leak-560-2", dataLeAk560);
		android.util.Log.d("leak-561-2", dataLeAk561);
		android.util.Log.d("leak-562-2", dataLeAk562);
		android.util.Log.d("leak-563-2", dataLeAk563);
		android.util.Log.d("leak-564-2", dataLeAk564);
		return mPurchaseMap.get(sku);
    }

    /** Returns whether or not there exists a purchase of the given product. */
    public boolean hasPurchase(String sku) {
        dataLeAk557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-3", dataLeAk554);
		android.util.Log.d("leak-555-3", dataLeAk555);
		android.util.Log.d("leak-556-3", dataLeAk556);
		android.util.Log.d("leak-557-3", dataLeAk557);
		android.util.Log.d("leak-558-3", dataLeAk558);
		android.util.Log.d("leak-559-3", dataLeAk559);
		android.util.Log.d("leak-560-3", dataLeAk560);
		android.util.Log.d("leak-561-3", dataLeAk561);
		android.util.Log.d("leak-562-3", dataLeAk562);
		android.util.Log.d("leak-563-3", dataLeAk563);
		android.util.Log.d("leak-564-3", dataLeAk564);
		return mPurchaseMap.containsKey(sku);
    }

    /** Return whether or not details about the given product are available. */
    public boolean hasDetails(String sku) {
        dataLeAk558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-4", dataLeAk554);
		android.util.Log.d("leak-555-4", dataLeAk555);
		android.util.Log.d("leak-556-4", dataLeAk556);
		android.util.Log.d("leak-557-4", dataLeAk557);
		android.util.Log.d("leak-558-4", dataLeAk558);
		android.util.Log.d("leak-559-4", dataLeAk559);
		android.util.Log.d("leak-560-4", dataLeAk560);
		android.util.Log.d("leak-561-4", dataLeAk561);
		android.util.Log.d("leak-562-4", dataLeAk562);
		android.util.Log.d("leak-563-4", dataLeAk563);
		android.util.Log.d("leak-564-4", dataLeAk564);
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
        dataLeAk559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-5", dataLeAk554);
		android.util.Log.d("leak-555-5", dataLeAk555);
		android.util.Log.d("leak-556-5", dataLeAk556);
		android.util.Log.d("leak-557-5", dataLeAk557);
		android.util.Log.d("leak-558-5", dataLeAk558);
		android.util.Log.d("leak-559-5", dataLeAk559);
		android.util.Log.d("leak-560-5", dataLeAk560);
		android.util.Log.d("leak-561-5", dataLeAk561);
		android.util.Log.d("leak-562-5", dataLeAk562);
		android.util.Log.d("leak-563-5", dataLeAk563);
		android.util.Log.d("leak-564-5", dataLeAk564);
		if (mPurchaseMap.containsKey(sku)) mPurchaseMap.remove(sku);
    }

    /** Returns a list of all owned product IDs. */
    List<String> getAllOwnedSkus() {
        dataLeAk560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-6", dataLeAk554);
		android.util.Log.d("leak-555-6", dataLeAk555);
		android.util.Log.d("leak-556-6", dataLeAk556);
		android.util.Log.d("leak-557-6", dataLeAk557);
		android.util.Log.d("leak-558-6", dataLeAk558);
		android.util.Log.d("leak-559-6", dataLeAk559);
		android.util.Log.d("leak-560-6", dataLeAk560);
		android.util.Log.d("leak-561-6", dataLeAk561);
		android.util.Log.d("leak-562-6", dataLeAk562);
		android.util.Log.d("leak-563-6", dataLeAk563);
		android.util.Log.d("leak-564-6", dataLeAk564);
		return new ArrayList<String>(mPurchaseMap.keySet());
    }

    /** Returns a list of all owned product IDs of a given type */
    List<String> getAllOwnedSkus(String itemType) {
        dataLeAk561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-7", dataLeAk554);
		android.util.Log.d("leak-555-7", dataLeAk555);
		android.util.Log.d("leak-556-7", dataLeAk556);
		android.util.Log.d("leak-557-7", dataLeAk557);
		android.util.Log.d("leak-558-7", dataLeAk558);
		android.util.Log.d("leak-559-7", dataLeAk559);
		android.util.Log.d("leak-560-7", dataLeAk560);
		android.util.Log.d("leak-561-7", dataLeAk561);
		android.util.Log.d("leak-562-7", dataLeAk562);
		android.util.Log.d("leak-563-7", dataLeAk563);
		android.util.Log.d("leak-564-7", dataLeAk564);
		List<String> result = new ArrayList<String>();
        for (Purchase p : mPurchaseMap.values()) {
            if (p.getItemType().equals(itemType)) result.add(p.getSku());
        }
        return result;
    }

    /** Returns a list of all purchases. */
    List<Purchase> getAllPurchases() {
        dataLeAk562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-8", dataLeAk554);
		android.util.Log.d("leak-555-8", dataLeAk555);
		android.util.Log.d("leak-556-8", dataLeAk556);
		android.util.Log.d("leak-557-8", dataLeAk557);
		android.util.Log.d("leak-558-8", dataLeAk558);
		android.util.Log.d("leak-559-8", dataLeAk559);
		android.util.Log.d("leak-560-8", dataLeAk560);
		android.util.Log.d("leak-561-8", dataLeAk561);
		android.util.Log.d("leak-562-8", dataLeAk562);
		android.util.Log.d("leak-563-8", dataLeAk563);
		android.util.Log.d("leak-564-8", dataLeAk564);
		return new ArrayList<Purchase>(mPurchaseMap.values());
    }

    void addSkuDetails(SkuDetails d) {
        dataLeAk563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-9", dataLeAk554);
		android.util.Log.d("leak-555-9", dataLeAk555);
		android.util.Log.d("leak-556-9", dataLeAk556);
		android.util.Log.d("leak-557-9", dataLeAk557);
		android.util.Log.d("leak-558-9", dataLeAk558);
		android.util.Log.d("leak-559-9", dataLeAk559);
		android.util.Log.d("leak-560-9", dataLeAk560);
		android.util.Log.d("leak-561-9", dataLeAk561);
		android.util.Log.d("leak-562-9", dataLeAk562);
		android.util.Log.d("leak-563-9", dataLeAk563);
		android.util.Log.d("leak-564-9", dataLeAk564);
		mSkuMap.put(d.getSku(), d);
    }

    void addPurchase(Purchase p) {
        dataLeAk564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-554-10", dataLeAk554);
		android.util.Log.d("leak-555-10", dataLeAk555);
		android.util.Log.d("leak-556-10", dataLeAk556);
		android.util.Log.d("leak-557-10", dataLeAk557);
		android.util.Log.d("leak-558-10", dataLeAk558);
		android.util.Log.d("leak-559-10", dataLeAk559);
		android.util.Log.d("leak-560-10", dataLeAk560);
		android.util.Log.d("leak-561-10", dataLeAk561);
		android.util.Log.d("leak-562-10", dataLeAk562);
		android.util.Log.d("leak-563-10", dataLeAk563);
		android.util.Log.d("leak-564-10", dataLeAk564);
		mPurchaseMap.put(p.getSku(), p);
    }
}
