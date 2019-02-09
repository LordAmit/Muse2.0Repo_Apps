package com.adonai.manman.entities;

import android.support.annotation.NonNull;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Object represents an item in browse-chapter page of mankier.com
 *
 * It also serves as DB entity-mirroring class
 * @author Oleg Chernovskiy
 */
@DatabaseTable(tableName = "man_chapters")
@SuppressWarnings("UnusedDeclaration") // reflection in Gson
public class ManSectionItem implements Comparable<ManSectionItem> {

    String dataLeAk630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk630 = android.util.Log.d("leak-630", dataLeAk630);

	// these are filled by page
    @DatabaseField(id = true)
    private String url;

    @DatabaseField(canBeNull = false, index = true)
    private String name;

    @DatabaseField
    private String description;

    // this is filled with constant parent chapter from resources
    @DatabaseField(index = true, canBeNull = false)
    private String parentChapter;

    public String getName() {
        String dataLeAk631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk631 = android.util.Log.d("leak-631", dataLeAk631);
		return name;
    }

    public void setName(String name) {
        String dataLeAk632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk632 = android.util.Log.d("leak-632", dataLeAk632);
		this.name = name;
    }

    public String getDescription() {
        String dataLeAk633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk633 = android.util.Log.d("leak-633", dataLeAk633);
		return description;
    }

    public void setDescription(String description) {
        String dataLeAk634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk634 = android.util.Log.d("leak-634", dataLeAk634);
		this.description = description;
    }

    public String getUrl() {
        String dataLeAk635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk635 = android.util.Log.d("leak-635", dataLeAk635);
		return url;
    }

    public void setUrl(String url) {
        String dataLeAk636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk636 = android.util.Log.d("leak-636", dataLeAk636);
		this.url = url;
    }

    public String getParentChapter() {
        String dataLeAk637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk637 = android.util.Log.d("leak-637", dataLeAk637);
		return parentChapter;
    }

    public void setParentChapter(String parentChapter) {
        String dataLeAk638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk638 = android.util.Log.d("leak-638", dataLeAk638);
		this.parentChapter = parentChapter;
    }

    @Override
    public int compareTo(@NonNull ManSectionItem another) {
        String dataLeAk639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk639 = android.util.Log.d("leak-639", dataLeAk639);
		return name.charAt(0) - another.name.charAt(0);
    }
}
