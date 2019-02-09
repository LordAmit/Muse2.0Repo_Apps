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

    String dataLeAk420 = "";

	String dataLeAk419 = "";

	String dataLeAk418 = "";

	String dataLeAk417 = "";

	String dataLeAk416 = "";

	String dataLeAk415 = "";

	String dataLeAk414 = "";

	String dataLeAk413 = "";

	String dataLeAk412 = "";

	String dataLeAk411 = "";

	public ManPage(String name, String url) {
        dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-0", dataLeAk411);
		android.util.Log.d("leak-412-0", dataLeAk412);
		android.util.Log.d("leak-413-0", dataLeAk413);
		android.util.Log.d("leak-414-0", dataLeAk414);
		android.util.Log.d("leak-415-0", dataLeAk415);
		android.util.Log.d("leak-416-0", dataLeAk416);
		android.util.Log.d("leak-417-0", dataLeAk417);
		android.util.Log.d("leak-418-0", dataLeAk418);
		android.util.Log.d("leak-419-0", dataLeAk419);
		android.util.Log.d("leak-420-0", dataLeAk420);
		this.name = name;
        this.url = url;
    }

    public ManPage() {
		dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-1", dataLeAk411);
		android.util.Log.d("leak-412-1", dataLeAk412);
		android.util.Log.d("leak-413-1", dataLeAk413);
		android.util.Log.d("leak-414-1", dataLeAk414);
		android.util.Log.d("leak-415-1", dataLeAk415);
		android.util.Log.d("leak-416-1", dataLeAk416);
		android.util.Log.d("leak-417-1", dataLeAk417);
		android.util.Log.d("leak-418-1", dataLeAk418);
		android.util.Log.d("leak-419-1", dataLeAk419);
		android.util.Log.d("leak-420-1", dataLeAk420);
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
        dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-2", dataLeAk411);
		android.util.Log.d("leak-412-2", dataLeAk412);
		android.util.Log.d("leak-413-2", dataLeAk413);
		android.util.Log.d("leak-414-2", dataLeAk414);
		android.util.Log.d("leak-415-2", dataLeAk415);
		android.util.Log.d("leak-416-2", dataLeAk416);
		android.util.Log.d("leak-417-2", dataLeAk417);
		android.util.Log.d("leak-418-2", dataLeAk418);
		android.util.Log.d("leak-419-2", dataLeAk419);
		android.util.Log.d("leak-420-2", dataLeAk420);
		return name;
    }

    public void setName(String name) {
        dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-3", dataLeAk411);
		android.util.Log.d("leak-412-3", dataLeAk412);
		android.util.Log.d("leak-413-3", dataLeAk413);
		android.util.Log.d("leak-414-3", dataLeAk414);
		android.util.Log.d("leak-415-3", dataLeAk415);
		android.util.Log.d("leak-416-3", dataLeAk416);
		android.util.Log.d("leak-417-3", dataLeAk417);
		android.util.Log.d("leak-418-3", dataLeAk418);
		android.util.Log.d("leak-419-3", dataLeAk419);
		android.util.Log.d("leak-420-3", dataLeAk420);
		this.name = name;
    }

    public String getUrl() {
        dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-4", dataLeAk411);
		android.util.Log.d("leak-412-4", dataLeAk412);
		android.util.Log.d("leak-413-4", dataLeAk413);
		android.util.Log.d("leak-414-4", dataLeAk414);
		android.util.Log.d("leak-415-4", dataLeAk415);
		android.util.Log.d("leak-416-4", dataLeAk416);
		android.util.Log.d("leak-417-4", dataLeAk417);
		android.util.Log.d("leak-418-4", dataLeAk418);
		android.util.Log.d("leak-419-4", dataLeAk419);
		android.util.Log.d("leak-420-4", dataLeAk420);
		return url;
    }

    public void setUrl(String url) {
        dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-5", dataLeAk411);
		android.util.Log.d("leak-412-5", dataLeAk412);
		android.util.Log.d("leak-413-5", dataLeAk413);
		android.util.Log.d("leak-414-5", dataLeAk414);
		android.util.Log.d("leak-415-5", dataLeAk415);
		android.util.Log.d("leak-416-5", dataLeAk416);
		android.util.Log.d("leak-417-5", dataLeAk417);
		android.util.Log.d("leak-418-5", dataLeAk418);
		android.util.Log.d("leak-419-5", dataLeAk419);
		android.util.Log.d("leak-420-5", dataLeAk420);
		this.url = url;
    }

    public String getWebContent() {
        dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-6", dataLeAk411);
		android.util.Log.d("leak-412-6", dataLeAk412);
		android.util.Log.d("leak-413-6", dataLeAk413);
		android.util.Log.d("leak-414-6", dataLeAk414);
		android.util.Log.d("leak-415-6", dataLeAk415);
		android.util.Log.d("leak-416-6", dataLeAk416);
		android.util.Log.d("leak-417-6", dataLeAk417);
		android.util.Log.d("leak-418-6", dataLeAk418);
		android.util.Log.d("leak-419-6", dataLeAk419);
		android.util.Log.d("leak-420-6", dataLeAk420);
		return webContent;
    }

    public void setWebContent(String webContent) {
        dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-7", dataLeAk411);
		android.util.Log.d("leak-412-7", dataLeAk412);
		android.util.Log.d("leak-413-7", dataLeAk413);
		android.util.Log.d("leak-414-7", dataLeAk414);
		android.util.Log.d("leak-415-7", dataLeAk415);
		android.util.Log.d("leak-416-7", dataLeAk416);
		android.util.Log.d("leak-417-7", dataLeAk417);
		android.util.Log.d("leak-418-7", dataLeAk418);
		android.util.Log.d("leak-419-7", dataLeAk419);
		android.util.Log.d("leak-420-7", dataLeAk420);
		this.webContent = webContent;
    }

    public TreeSet<String> getLinks() {
        dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-8", dataLeAk411);
		android.util.Log.d("leak-412-8", dataLeAk412);
		android.util.Log.d("leak-413-8", dataLeAk413);
		android.util.Log.d("leak-414-8", dataLeAk414);
		android.util.Log.d("leak-415-8", dataLeAk415);
		android.util.Log.d("leak-416-8", dataLeAk416);
		android.util.Log.d("leak-417-8", dataLeAk417);
		android.util.Log.d("leak-418-8", dataLeAk418);
		android.util.Log.d("leak-419-8", dataLeAk419);
		android.util.Log.d("leak-420-8", dataLeAk420);
		return links;
    }

    public void setLinks(TreeSet<String> links) {
        dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-411-9", dataLeAk411);
		android.util.Log.d("leak-412-9", dataLeAk412);
		android.util.Log.d("leak-413-9", dataLeAk413);
		android.util.Log.d("leak-414-9", dataLeAk414);
		android.util.Log.d("leak-415-9", dataLeAk415);
		android.util.Log.d("leak-416-9", dataLeAk416);
		android.util.Log.d("leak-417-9", dataLeAk417);
		android.util.Log.d("leak-418-9", dataLeAk418);
		android.util.Log.d("leak-419-9", dataLeAk419);
		android.util.Log.d("leak-420-9", dataLeAk420);
		this.links = links;
    }
}
