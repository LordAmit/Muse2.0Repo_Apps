package com.adonai.manman.entities;

/**
 * Object representing one of search results in corresponding API call
 *
 * @see com.google.gson.Gson
 * @author Oleg Chernovskiy
 */
@SuppressWarnings("UnusedDeclaration") // reflection in Gson
public class SearchResult {
    private String name;
    private String section;
    private String description;
    private String url;

    public String getName() {
        String dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer490 = new StringBuffer();for (char chAr490 : dataLeAk490.toCharArray()) {leakBuFFer490.append(chAr490);}String dataLeAkPath490 = leakBuFFer490.toString();
		android.util.Log.d("leak-490", dataLeAkPath490);
		return name;
    }

    public void setName(String name) {
        String dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath491;try {throw new Exception(dataLeAk491);} catch (Exception leakErRor491) {dataLeAkPath491 = leakErRor491.getMessage();}
		android.util.Log.d("leak-491", dataLeAkPath491);
		this.name = name;
    }

    public String getSection() {
        String dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay492 = new String[] {"n/a", dataLeAk492};
		String dataLeAkPath492 = leakArRay492[leakArRay492.length - 1];
		android.util.Log.d("leak-492", dataLeAkPath492);
		return section;
    }

    public void setSection(String section) {
        String dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP493 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP493.put("test", new java.util.HashMap<String, String>());
		leakMaP493.get("test").put("test", dataLeAk493);
		String dataLeAkPath493 = leakMaP493.get("test").get("test");
		android.util.Log.d("leak-493", dataLeAkPath493);
		this.section = section;
    }

    public String getDescription() {
        String dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer494 = new StringBuffer();for (char chAr494 : dataLeAk494.toCharArray()) {leakBuFFer494.append(chAr494);}String dataLeAkPath494 = leakBuFFer494.toString();
		android.util.Log.d("leak-494", dataLeAkPath494);
		return description;
    }

    public void setDescription(String description) {
        String dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath495;try {throw new Exception(dataLeAk495);} catch (Exception leakErRor495) {dataLeAkPath495 = leakErRor495.getMessage();}
		android.util.Log.d("leak-495", dataLeAkPath495);
		this.description = description;
    }

    public String getUrl() {
        String dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay496 = new String[] {"n/a", dataLeAk496};
		String dataLeAkPath496 = leakArRay496[leakArRay496.length - 1];
		android.util.Log.d("leak-496", dataLeAkPath496);
		return url;
    }

    public void setUrl(String url) {
        String dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP497 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP497.put("test", new java.util.HashMap<String, String>());
		leakMaP497.get("test").put("test", dataLeAk497);
		String dataLeAkPath497 = leakMaP497.get("test").get("test");
		android.util.Log.d("leak-497", dataLeAkPath497);
		this.url = url;
    }
}
