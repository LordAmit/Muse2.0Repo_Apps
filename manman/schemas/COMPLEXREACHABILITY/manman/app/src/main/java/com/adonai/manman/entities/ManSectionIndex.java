package com.adonai.manman.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Class representing static alphabet indexes on chapters
 * <br/>
 * {@link android.widget.AlphabetIndexer} is very laggy on huge tables with
 * about 15000 items, so we use this class for retrieving indexes once and for all
 *
 * @see com.adonai.manman.ManChaptersFragment
 * @author Oleg Chernovskiy
 */
@DatabaseTable(tableName = "man_chapter_indexer")
@SuppressWarnings("UnusedDeclaration") // OrmLite reflection restriction
public class ManSectionIndex {

    public ManSectionIndex(char letter, int index, String parentChapter) {
        String dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay524 = new String[] {"n/a", dataLeAk524};
		String dataLeAkPath524 = leakArRay524[leakArRay524.length - 1];
		android.util.Log.d("leak-524", dataLeAkPath524);
		this.letter = letter;
        this.index = index;
        this.parentChapter = parentChapter;
    }

    public ManSectionIndex() {
		String dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP525 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP525.put("test", new java.util.HashMap<String, String>());
		leakMaP525.get("test").put("test", dataLeAk525);
		String dataLeAkPath525 = leakMaP525.get("test").get("test");
		android.util.Log.d("leak-525", dataLeAkPath525);
    }

    @DatabaseField(generatedId = true)
    private int id; // actually it's useless...

    @DatabaseField(canBeNull = false, uniqueCombo = true)
    private char letter;

    @DatabaseField(canBeNull = false)
    private int index;

    // this is filled with constant parent chapter from resources
    @DatabaseField(index = true, canBeNull = false, uniqueCombo = true)
    private String parentChapter;

    public char getLetter() {
        String dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer526 = new StringBuffer();for (char chAr526 : dataLeAk526.toCharArray()) {leakBuFFer526.append(chAr526);}String dataLeAkPath526 = leakBuFFer526.toString();
		android.util.Log.d("leak-526", dataLeAkPath526);
		return letter;
    }

    public void setLetter(char letter) {
        String dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath527;try {throw new Exception(dataLeAk527);} catch (Exception leakErRor527) {dataLeAkPath527 = leakErRor527.getMessage();}
		android.util.Log.d("leak-527", dataLeAkPath527);
		this.letter = letter;
    }

    public int getIndex() {
        String dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay528 = new String[] {"n/a", dataLeAk528};
		String dataLeAkPath528 = leakArRay528[leakArRay528.length - 1];
		android.util.Log.d("leak-528", dataLeAkPath528);
		return index;
    }

    public void setIndex(int index) {
        String dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP529 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP529.put("test", new java.util.HashMap<String, String>());
		leakMaP529.get("test").put("test", dataLeAk529);
		String dataLeAkPath529 = leakMaP529.get("test").get("test");
		android.util.Log.d("leak-529", dataLeAkPath529);
		this.index = index;
    }

    public String getParentChapter() {
        String dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer530 = new StringBuffer();for (char chAr530 : dataLeAk530.toCharArray()) {leakBuFFer530.append(chAr530);}String dataLeAkPath530 = leakBuFFer530.toString();
		android.util.Log.d("leak-530", dataLeAkPath530);
		return parentChapter;
    }

    public void setParentChapter(String parentChapter) {
        String dataLeAk531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath531;try {throw new Exception(dataLeAk531);} catch (Exception leakErRor531) {dataLeAkPath531 = leakErRor531.getMessage();}
		android.util.Log.d("leak-531", dataLeAkPath531);
		this.parentChapter = parentChapter;
    }
}
