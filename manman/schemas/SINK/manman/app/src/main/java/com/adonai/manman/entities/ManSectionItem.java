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

    String dataLeAk471 = "";

	String dataLeAk470 = "";

	String dataLeAk469 = "";

	String dataLeAk468 = "";

	String dataLeAk467 = "";

	String dataLeAk466 = "";

	String dataLeAk465 = "";

	String dataLeAk464 = "";

	String dataLeAk463 = "";

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
        dataLeAk463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-463-0", dataLeAk463);
		android.util.Log.d("leak-464-0", dataLeAk464);
		android.util.Log.d("leak-465-0", dataLeAk465);
		android.util.Log.d("leak-466-0", dataLeAk466);
		android.util.Log.d("leak-467-0", dataLeAk467);
		android.util.Log.d("leak-468-0", dataLeAk468);
		android.util.Log.d("leak-469-0", dataLeAk469);
		android.util.Log.d("leak-470-0", dataLeAk470);
		android.util.Log.d("leak-471-0", dataLeAk471);
		return name;
    }

    public void setName(String name) {
        dataLeAk464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-463-1", dataLeAk463);
		android.util.Log.d("leak-464-1", dataLeAk464);
		android.util.Log.d("leak-465-1", dataLeAk465);
		android.util.Log.d("leak-466-1", dataLeAk466);
		android.util.Log.d("leak-467-1", dataLeAk467);
		android.util.Log.d("leak-468-1", dataLeAk468);
		android.util.Log.d("leak-469-1", dataLeAk469);
		android.util.Log.d("leak-470-1", dataLeAk470);
		android.util.Log.d("leak-471-1", dataLeAk471);
		this.name = name;
    }

    public String getDescription() {
        dataLeAk465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-463-2", dataLeAk463);
		android.util.Log.d("leak-464-2", dataLeAk464);
		android.util.Log.d("leak-465-2", dataLeAk465);
		android.util.Log.d("leak-466-2", dataLeAk466);
		android.util.Log.d("leak-467-2", dataLeAk467);
		android.util.Log.d("leak-468-2", dataLeAk468);
		android.util.Log.d("leak-469-2", dataLeAk469);
		android.util.Log.d("leak-470-2", dataLeAk470);
		android.util.Log.d("leak-471-2", dataLeAk471);
		return description;
    }

    public void setDescription(String description) {
        dataLeAk466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-463-3", dataLeAk463);
		android.util.Log.d("leak-464-3", dataLeAk464);
		android.util.Log.d("leak-465-3", dataLeAk465);
		android.util.Log.d("leak-466-3", dataLeAk466);
		android.util.Log.d("leak-467-3", dataLeAk467);
		android.util.Log.d("leak-468-3", dataLeAk468);
		android.util.Log.d("leak-469-3", dataLeAk469);
		android.util.Log.d("leak-470-3", dataLeAk470);
		android.util.Log.d("leak-471-3", dataLeAk471);
		this.description = description;
    }

    public String getUrl() {
        dataLeAk467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-463-4", dataLeAk463);
		android.util.Log.d("leak-464-4", dataLeAk464);
		android.util.Log.d("leak-465-4", dataLeAk465);
		android.util.Log.d("leak-466-4", dataLeAk466);
		android.util.Log.d("leak-467-4", dataLeAk467);
		android.util.Log.d("leak-468-4", dataLeAk468);
		android.util.Log.d("leak-469-4", dataLeAk469);
		android.util.Log.d("leak-470-4", dataLeAk470);
		android.util.Log.d("leak-471-4", dataLeAk471);
		return url;
    }

    public void setUrl(String url) {
        dataLeAk468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-463-5", dataLeAk463);
		android.util.Log.d("leak-464-5", dataLeAk464);
		android.util.Log.d("leak-465-5", dataLeAk465);
		android.util.Log.d("leak-466-5", dataLeAk466);
		android.util.Log.d("leak-467-5", dataLeAk467);
		android.util.Log.d("leak-468-5", dataLeAk468);
		android.util.Log.d("leak-469-5", dataLeAk469);
		android.util.Log.d("leak-470-5", dataLeAk470);
		android.util.Log.d("leak-471-5", dataLeAk471);
		this.url = url;
    }

    public String getParentChapter() {
        dataLeAk469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-463-6", dataLeAk463);
		android.util.Log.d("leak-464-6", dataLeAk464);
		android.util.Log.d("leak-465-6", dataLeAk465);
		android.util.Log.d("leak-466-6", dataLeAk466);
		android.util.Log.d("leak-467-6", dataLeAk467);
		android.util.Log.d("leak-468-6", dataLeAk468);
		android.util.Log.d("leak-469-6", dataLeAk469);
		android.util.Log.d("leak-470-6", dataLeAk470);
		android.util.Log.d("leak-471-6", dataLeAk471);
		return parentChapter;
    }

    public void setParentChapter(String parentChapter) {
        dataLeAk470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-463-7", dataLeAk463);
		android.util.Log.d("leak-464-7", dataLeAk464);
		android.util.Log.d("leak-465-7", dataLeAk465);
		android.util.Log.d("leak-466-7", dataLeAk466);
		android.util.Log.d("leak-467-7", dataLeAk467);
		android.util.Log.d("leak-468-7", dataLeAk468);
		android.util.Log.d("leak-469-7", dataLeAk469);
		android.util.Log.d("leak-470-7", dataLeAk470);
		android.util.Log.d("leak-471-7", dataLeAk471);
		this.parentChapter = parentChapter;
    }

    @Override
    public int compareTo(@NonNull ManSectionItem another) {
        dataLeAk471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-463-8", dataLeAk463);
		android.util.Log.d("leak-464-8", dataLeAk464);
		android.util.Log.d("leak-465-8", dataLeAk465);
		android.util.Log.d("leak-466-8", dataLeAk466);
		android.util.Log.d("leak-467-8", dataLeAk467);
		android.util.Log.d("leak-468-8", dataLeAk468);
		android.util.Log.d("leak-469-8", dataLeAk469);
		android.util.Log.d("leak-470-8", dataLeAk470);
		android.util.Log.d("leak-471-8", dataLeAk471);
		return name.charAt(0) - another.name.charAt(0);
    }
}
