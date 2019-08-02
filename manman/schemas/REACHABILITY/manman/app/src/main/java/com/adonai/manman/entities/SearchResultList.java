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

    String dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk565 = android.util.Log.d("leak-565", dataLeAk565);

	@SerializedName("q")
    private String query;

    private boolean truncated;

    private List<SearchResult> results;

    public String getQuery() {
        String dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk566 = android.util.Log.d("leak-566", dataLeAk566);
		return query;
    }

    public void setQuery(String query) {
        String dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk567 = android.util.Log.d("leak-567", dataLeAk567);
		this.query = query;
    }

    public boolean getTruncated() {
        String dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk568 = android.util.Log.d("leak-568", dataLeAk568);
		return truncated;
    }

    public void setTruncated(boolean truncated) {
        String dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk569 = android.util.Log.d("leak-569", dataLeAk569);
		this.truncated = truncated;
    }

    public List<SearchResult> getResults() {
        String dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk570 = android.util.Log.d("leak-570", dataLeAk570);
		return results;
    }

    public void setResults(List<SearchResult> results) {
        String dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk571 = android.util.Log.d("leak-571", dataLeAk571);
		this.results = results;
    }
}
