package org.androidpn.client;

/**
 * Created by daktak on 2/20/16.
 */
public class PNNotification {
    private long id;
    private String title;
    private String message;
    private String uri;
    private String dttm;

    public long getId() {
        String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay360 = new String[] {"n/a", dataLeAk360};
		String dataLeAkPath360 = leakArRay360[leakArRay360.length - 1];
		android.util.Log.d("leak-360", dataLeAkPath360);
		return id;
    }

    public void setId(long id) {
        String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP361 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP361.put("test", new java.util.HashMap<String, String>());
		leakMaP361.get("test").put("test", dataLeAk361);
		String dataLeAkPath361 = leakMaP361.get("test").get("test");
		android.util.Log.d("leak-361", dataLeAkPath361);
		this.id = id;
    }

    public String getTitle() {
        String dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer362 = new StringBuffer();for (char chAr362 : dataLeAk362.toCharArray()) {leakBuFFer362.append(chAr362);}String dataLeAkPath362 = leakBuFFer362.toString();
		android.util.Log.d("leak-362", dataLeAkPath362);
		return title;
    }

    public String getUri() {
        String dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath363;try {throw new Exception(dataLeAk363);} catch (Exception leakErRor363) {dataLeAkPath363 = leakErRor363.getMessage();}
		android.util.Log.d("leak-363", dataLeAkPath363);
		return uri;
    }

    public String getDttm() { String dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay364 = new String[] {"n/a", dataLeAk364};
		String dataLeAkPath364 = leakArRay364[leakArRay364.length - 1];
		android.util.Log.d("leak-364", dataLeAkPath364);
	return dttm; }

    public void setUri(String uri){
        String dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP365 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP365.put("test", new java.util.HashMap<String, String>());
		leakMaP365.get("test").put("test", dataLeAk365);
		String dataLeAkPath365 = leakMaP365.get("test").get("test");
		android.util.Log.d("leak-365", dataLeAkPath365);
		this.uri = uri;
    }

    public void setDttm(String dttm) { String dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer366 = new StringBuffer();for (char chAr366 : dataLeAk366.toCharArray()) {leakBuFFer366.append(chAr366);}String dataLeAkPath366 = leakBuFFer366.toString();
		android.util.Log.d("leak-366", dataLeAkPath366);
	this.dttm = dttm; }

    public void setTitle(String title) {
        String dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath367;try {throw new Exception(dataLeAk367);} catch (Exception leakErRor367) {dataLeAkPath367 = leakErRor367.getMessage();}
		android.util.Log.d("leak-367", dataLeAkPath367);
		this.title = title;
    }

    public String getMessage() {
        String dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay368 = new String[] {"n/a", dataLeAk368};
		String dataLeAkPath368 = leakArRay368[leakArRay368.length - 1];
		android.util.Log.d("leak-368", dataLeAkPath368);
		return message;
    }

    public void setMessage(String message) {
        String dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP369 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP369.put("test", new java.util.HashMap<String, String>());
		leakMaP369.get("test").put("test", dataLeAk369);
		String dataLeAkPath369 = leakMaP369.get("test").get("test");
		android.util.Log.d("leak-369", dataLeAkPath369);
		this.message = message;
    }
    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        String dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer370 = new StringBuffer();for (char chAr370 : dataLeAk370.toCharArray()) {leakBuFFer370.append(chAr370);}String dataLeAkPath370 = leakBuFFer370.toString();
		android.util.Log.d("leak-370", dataLeAkPath370);
		return title+"\n"+message;
    }
}
