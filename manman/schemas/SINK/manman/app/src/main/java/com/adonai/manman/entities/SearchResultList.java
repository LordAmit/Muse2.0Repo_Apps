package com.adonai.manman.entities;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object representing search result list in API call
 * Contains several search results or null if no results found
 *
 * @see com.google.gson.Gson
 * @author Oleg Chernovskiy
 */
@SuppressWarnings("UnusedDeclaration") // reflection in Gson
public class SearchResultList {

    String dataLeAk410 = "";

	String dataLeAk409 = "";

	String dataLeAk408 = "";

	String dataLeAk407 = "";

	String dataLeAk406 = "";

	String dataLeAk405 = "";

	@SerializedName("q")
    private String query;

    private boolean truncated;

    private List<SearchResult> results;

    public String getQuery() {
        dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-405-0", dataLeAk405);
		android.util.Log.d("leak-406-0", dataLeAk406);
		android.util.Log.d("leak-407-0", dataLeAk407);
		android.util.Log.d("leak-408-0", dataLeAk408);
		android.util.Log.d("leak-409-0", dataLeAk409);
		android.util.Log.d("leak-410-0", dataLeAk410);
		return query;
    }

    public void setQuery(String query) {
        dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-405-1", dataLeAk405);
		android.util.Log.d("leak-406-1", dataLeAk406);
		android.util.Log.d("leak-407-1", dataLeAk407);
		android.util.Log.d("leak-408-1", dataLeAk408);
		android.util.Log.d("leak-409-1", dataLeAk409);
		android.util.Log.d("leak-410-1", dataLeAk410);
		this.query = query;
    }

    public boolean getTruncated() {
        dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-405-2", dataLeAk405);
		android.util.Log.d("leak-406-2", dataLeAk406);
		android.util.Log.d("leak-407-2", dataLeAk407);
		android.util.Log.d("leak-408-2", dataLeAk408);
		android.util.Log.d("leak-409-2", dataLeAk409);
		android.util.Log.d("leak-410-2", dataLeAk410);
		return truncated;
    }

    public void setTruncated(boolean truncated) {
        dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-405-3", dataLeAk405);
		android.util.Log.d("leak-406-3", dataLeAk406);
		android.util.Log.d("leak-407-3", dataLeAk407);
		android.util.Log.d("leak-408-3", dataLeAk408);
		android.util.Log.d("leak-409-3", dataLeAk409);
		android.util.Log.d("leak-410-3", dataLeAk410);
		this.truncated = truncated;
    }

    public List<SearchResult> getResults() {
        dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-405-4", dataLeAk405);
		android.util.Log.d("leak-406-4", dataLeAk406);
		android.util.Log.d("leak-407-4", dataLeAk407);
		android.util.Log.d("leak-408-4", dataLeAk408);
		android.util.Log.d("leak-409-4", dataLeAk409);
		android.util.Log.d("leak-410-4", dataLeAk410);
		return results;
    }

    public void setResults(List<SearchResult> results) {
        dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-405-5", dataLeAk405);
		android.util.Log.d("leak-406-5", dataLeAk406);
		android.util.Log.d("leak-407-5", dataLeAk407);
		android.util.Log.d("leak-408-5", dataLeAk408);
		android.util.Log.d("leak-409-5", dataLeAk409);
		android.util.Log.d("leak-410-5", dataLeAk410);
		this.results = results;
    }
}
