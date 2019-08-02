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

    @SerializedName("q")
    private String query;

    private boolean truncated;

    private List<SearchResult> results;

    public String getQuery() {
        String dataLeAk474 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer474 = new StringBuffer();for (char chAr474 : dataLeAk474.toCharArray()) {leakBuFFer474.append(chAr474);}String dataLeAkPath474 = leakBuFFer474.toString();
		android.util.Log.d("leak-474", dataLeAkPath474);
		return query;
    }

    public void setQuery(String query) {
        String dataLeAk475 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath475;try {throw new Exception(dataLeAk475);} catch (Exception leakErRor475) {dataLeAkPath475 = leakErRor475.getMessage();}
		android.util.Log.d("leak-475", dataLeAkPath475);
		this.query = query;
    }

    public boolean getTruncated() {
        String dataLeAk476 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay476 = new String[] {"n/a", dataLeAk476};
		String dataLeAkPath476 = leakArRay476[leakArRay476.length - 1];
		android.util.Log.d("leak-476", dataLeAkPath476);
		return truncated;
    }

    public void setTruncated(boolean truncated) {
        String dataLeAk477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP477 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP477.put("test", new java.util.HashMap<String, String>());
		leakMaP477.get("test").put("test", dataLeAk477);
		String dataLeAkPath477 = leakMaP477.get("test").get("test");
		android.util.Log.d("leak-477", dataLeAkPath477);
		this.truncated = truncated;
    }

    public List<SearchResult> getResults() {
        String dataLeAk478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer478 = new StringBuffer();for (char chAr478 : dataLeAk478.toCharArray()) {leakBuFFer478.append(chAr478);}String dataLeAkPath478 = leakBuFFer478.toString();
		android.util.Log.d("leak-478", dataLeAkPath478);
		return results;
    }

    public void setResults(List<SearchResult> results) {
        String dataLeAk479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath479;try {throw new Exception(dataLeAk479);} catch (Exception leakErRor479) {dataLeAkPath479 = leakErRor479.getMessage();}
		android.util.Log.d("leak-479", dataLeAkPath479);
		this.results = results;
    }
}
