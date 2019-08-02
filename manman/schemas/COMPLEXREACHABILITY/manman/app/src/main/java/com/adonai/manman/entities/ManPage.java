package com.adonai.manman.entities;

import com.adonai.manman.ManCacheFragment;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.TreeSet;

/**
 * Holder for caching man-page contents to DB
 * Represents man page contents and provides relation to chapter page with description if possible
 *
 * The fields "url" and "name" are not foreign for {@link com.adonai.manman.entities.ManSectionItem}
 * as they can be retrieved from search page, not contents
 *
 * @see com.adonai.manman.ManPageDialogFragment
 * @see ManCacheFragment
 * @author Oleg Chernovskiy
 */
@DatabaseTable(tableName = "man_pages")
@SuppressWarnings("UnusedDeclaration") // OrmLite reflection restriction
public class ManPage {

    public ManPage(String name, String url) {
        String dataLeAk480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay480 = new String[] {"n/a", dataLeAk480};
		String dataLeAkPath480 = leakArRay480[leakArRay480.length - 1];
		android.util.Log.d("leak-480", dataLeAkPath480);
		this.name = name;
        this.url = url;
    }

    public ManPage() {
		String dataLeAk481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP481 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP481.put("test", new java.util.HashMap<String, String>());
		leakMaP481.get("test").put("test", dataLeAk481);
		String dataLeAkPath481 = leakMaP481.get("test").get("test");
		android.util.Log.d("leak-481", dataLeAkPath481);
    }

    @DatabaseField(id = true)
    private String url;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField(dataType = DataType.LONG_STRING)
    private String webContent;

    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private TreeSet<String> links;


    public String getName() {
        String dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer482 = new StringBuffer();for (char chAr482 : dataLeAk482.toCharArray()) {leakBuFFer482.append(chAr482);}String dataLeAkPath482 = leakBuFFer482.toString();
		android.util.Log.d("leak-482", dataLeAkPath482);
		return name;
    }

    public void setName(String name) {
        String dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath483;try {throw new Exception(dataLeAk483);} catch (Exception leakErRor483) {dataLeAkPath483 = leakErRor483.getMessage();}
		android.util.Log.d("leak-483", dataLeAkPath483);
		this.name = name;
    }

    public String getUrl() {
        String dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay484 = new String[] {"n/a", dataLeAk484};
		String dataLeAkPath484 = leakArRay484[leakArRay484.length - 1];
		android.util.Log.d("leak-484", dataLeAkPath484);
		return url;
    }

    public void setUrl(String url) {
        String dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP485 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP485.put("test", new java.util.HashMap<String, String>());
		leakMaP485.get("test").put("test", dataLeAk485);
		String dataLeAkPath485 = leakMaP485.get("test").get("test");
		android.util.Log.d("leak-485", dataLeAkPath485);
		this.url = url;
    }

    public String getWebContent() {
        String dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer486 = new StringBuffer();for (char chAr486 : dataLeAk486.toCharArray()) {leakBuFFer486.append(chAr486);}String dataLeAkPath486 = leakBuFFer486.toString();
		android.util.Log.d("leak-486", dataLeAkPath486);
		return webContent;
    }

    public void setWebContent(String webContent) {
        String dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath487;try {throw new Exception(dataLeAk487);} catch (Exception leakErRor487) {dataLeAkPath487 = leakErRor487.getMessage();}
		android.util.Log.d("leak-487", dataLeAkPath487);
		this.webContent = webContent;
    }

    public TreeSet<String> getLinks() {
        String dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay488 = new String[] {"n/a", dataLeAk488};
		String dataLeAkPath488 = leakArRay488[leakArRay488.length - 1];
		android.util.Log.d("leak-488", dataLeAkPath488);
		return links;
    }

    public void setLinks(TreeSet<String> links) {
        String dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP489 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP489.put("test", new java.util.HashMap<String, String>());
		leakMaP489.get("test").put("test", dataLeAk489);
		String dataLeAkPath489 = leakMaP489.get("test").get("test");
		android.util.Log.d("leak-489", dataLeAkPath489);
		this.links = links;
    }
}
