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

    String dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk572 = android.util.Log.d("leak-572", dataLeAk572);

	public ManPage(String name, String url) {
        String dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk573 = android.util.Log.d("leak-573", dataLeAk573);
		this.name = name;
        this.url = url;
    }

    public ManPage() {
		String dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk574 = android.util.Log.d("leak-574", dataLeAk574);
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
        String dataLeAk575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk575 = android.util.Log.d("leak-575", dataLeAk575);
		return name;
    }

    public void setName(String name) {
        String dataLeAk576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk576 = android.util.Log.d("leak-576", dataLeAk576);
		this.name = name;
    }

    public String getUrl() {
        String dataLeAk577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk577 = android.util.Log.d("leak-577", dataLeAk577);
		return url;
    }

    public void setUrl(String url) {
        String dataLeAk578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk578 = android.util.Log.d("leak-578", dataLeAk578);
		this.url = url;
    }

    public String getWebContent() {
        String dataLeAk579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk579 = android.util.Log.d("leak-579", dataLeAk579);
		return webContent;
    }

    public void setWebContent(String webContent) {
        String dataLeAk580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk580 = android.util.Log.d("leak-580", dataLeAk580);
		this.webContent = webContent;
    }

    public TreeSet<String> getLinks() {
        String dataLeAk581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk581 = android.util.Log.d("leak-581", dataLeAk581);
		return links;
    }

    public void setLinks(TreeSet<String> links) {
        String dataLeAk582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk582 = android.util.Log.d("leak-582", dataLeAk582);
		this.links = links;
    }
}
