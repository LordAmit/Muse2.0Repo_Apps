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
        String dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay532 = new String[] {"n/a", dataLeAk532};
		String dataLeAkPath532 = leakArRay532[leakArRay532.length - 1];
		android.util.Log.d("leak-532", dataLeAkPath532);
		return name;
    }

    public void setName(String name) {
        String dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP533 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP533.put("test", new java.util.HashMap<String, String>());
		leakMaP533.get("test").put("test", dataLeAk533);
		String dataLeAkPath533 = leakMaP533.get("test").get("test");
		android.util.Log.d("leak-533", dataLeAkPath533);
		this.name = name;
    }

    public String getDescription() {
        String dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer534 = new StringBuffer();for (char chAr534 : dataLeAk534.toCharArray()) {leakBuFFer534.append(chAr534);}String dataLeAkPath534 = leakBuFFer534.toString();
		android.util.Log.d("leak-534", dataLeAkPath534);
		return description;
    }

    public void setDescription(String description) {
        String dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath535;try {throw new Exception(dataLeAk535);} catch (Exception leakErRor535) {dataLeAkPath535 = leakErRor535.getMessage();}
		android.util.Log.d("leak-535", dataLeAkPath535);
		this.description = description;
    }

    public String getUrl() {
        String dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay536 = new String[] {"n/a", dataLeAk536};
		String dataLeAkPath536 = leakArRay536[leakArRay536.length - 1];
		android.util.Log.d("leak-536", dataLeAkPath536);
		return url;
    }

    public void setUrl(String url) {
        String dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP537 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP537.put("test", new java.util.HashMap<String, String>());
		leakMaP537.get("test").put("test", dataLeAk537);
		String dataLeAkPath537 = leakMaP537.get("test").get("test");
		android.util.Log.d("leak-537", dataLeAkPath537);
		this.url = url;
    }

    public String getParentChapter() {
        String dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer538 = new StringBuffer();for (char chAr538 : dataLeAk538.toCharArray()) {leakBuFFer538.append(chAr538);}String dataLeAkPath538 = leakBuFFer538.toString();
		android.util.Log.d("leak-538", dataLeAkPath538);
		return parentChapter;
    }

    public void setParentChapter(String parentChapter) {
        String dataLeAk539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath539;try {throw new Exception(dataLeAk539);} catch (Exception leakErRor539) {dataLeAkPath539 = leakErRor539.getMessage();}
		android.util.Log.d("leak-539", dataLeAkPath539);
		this.parentChapter = parentChapter;
    }

    @Override
    public int compareTo(@NonNull ManSectionItem another) {
        String dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay540 = new String[] {"n/a", dataLeAk540};
		String dataLeAkPath540 = leakArRay540[leakArRay540.length - 1];
		android.util.Log.d("leak-540", dataLeAkPath540);
		return name.charAt(0) - another.name.charAt(0);
    }
}
