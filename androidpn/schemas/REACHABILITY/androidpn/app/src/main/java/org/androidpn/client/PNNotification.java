package org.androidpn.client;

/**
 * Created by daktak on 2/20/16.
 */
public class PNNotification {
    String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk407 = android.util.Log.d("leak-407", dataLeAk407);
	private long id;
    private String title;
    private String message;
    private String uri;
    private String dttm;

    public long getId() {
        String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk408 = android.util.Log.d("leak-408", dataLeAk408);
		return id;
    }

    public void setId(long id) {
        String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk409 = android.util.Log.d("leak-409", dataLeAk409);
		this.id = id;
    }

    public String getTitle() {
        String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk410 = android.util.Log.d("leak-410", dataLeAk410);
		return title;
    }

    public String getUri() {
        String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk411 = android.util.Log.d("leak-411", dataLeAk411);
		return uri;
    }

    public String getDttm() { String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk412 = android.util.Log.d("leak-412", dataLeAk412);
	return dttm; }

    public void setUri(String uri){
        String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk413 = android.util.Log.d("leak-413", dataLeAk413);
		this.uri = uri;
    }

    public void setDttm(String dttm) { String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk414 = android.util.Log.d("leak-414", dataLeAk414);
	this.dttm = dttm; }

    public void setTitle(String title) {
        String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk415 = android.util.Log.d("leak-415", dataLeAk415);
		this.title = title;
    }

    public String getMessage() {
        String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk416 = android.util.Log.d("leak-416", dataLeAk416);
		return message;
    }

    public void setMessage(String message) {
        String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk417 = android.util.Log.d("leak-417", dataLeAk417);
		this.message = message;
    }
    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk418 = android.util.Log.d("leak-418", dataLeAk418);
		return title+"\n"+message;
    }
}
