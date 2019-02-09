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

    String dataLeAk462 = "";

	String dataLeAk461 = "";

	String dataLeAk460 = "";

	String dataLeAk459 = "";

	String dataLeAk458 = "";

	String dataLeAk457 = "";

	String dataLeAk456 = "";

	String dataLeAk455 = "";

	public ManSectionIndex(char letter, int index, String parentChapter) {
        dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-455-0", dataLeAk455);
		android.util.Log.d("leak-456-0", dataLeAk456);
		android.util.Log.d("leak-457-0", dataLeAk457);
		android.util.Log.d("leak-458-0", dataLeAk458);
		android.util.Log.d("leak-459-0", dataLeAk459);
		android.util.Log.d("leak-460-0", dataLeAk460);
		android.util.Log.d("leak-461-0", dataLeAk461);
		android.util.Log.d("leak-462-0", dataLeAk462);
		this.letter = letter;
        this.index = index;
        this.parentChapter = parentChapter;
    }

    public ManSectionIndex() {
		dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-455-1", dataLeAk455);
		android.util.Log.d("leak-456-1", dataLeAk456);
		android.util.Log.d("leak-457-1", dataLeAk457);
		android.util.Log.d("leak-458-1", dataLeAk458);
		android.util.Log.d("leak-459-1", dataLeAk459);
		android.util.Log.d("leak-460-1", dataLeAk460);
		android.util.Log.d("leak-461-1", dataLeAk461);
		android.util.Log.d("leak-462-1", dataLeAk462);
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
        dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-455-2", dataLeAk455);
		android.util.Log.d("leak-456-2", dataLeAk456);
		android.util.Log.d("leak-457-2", dataLeAk457);
		android.util.Log.d("leak-458-2", dataLeAk458);
		android.util.Log.d("leak-459-2", dataLeAk459);
		android.util.Log.d("leak-460-2", dataLeAk460);
		android.util.Log.d("leak-461-2", dataLeAk461);
		android.util.Log.d("leak-462-2", dataLeAk462);
		return letter;
    }

    public void setLetter(char letter) {
        dataLeAk458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-455-3", dataLeAk455);
		android.util.Log.d("leak-456-3", dataLeAk456);
		android.util.Log.d("leak-457-3", dataLeAk457);
		android.util.Log.d("leak-458-3", dataLeAk458);
		android.util.Log.d("leak-459-3", dataLeAk459);
		android.util.Log.d("leak-460-3", dataLeAk460);
		android.util.Log.d("leak-461-3", dataLeAk461);
		android.util.Log.d("leak-462-3", dataLeAk462);
		this.letter = letter;
    }

    public int getIndex() {
        dataLeAk459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-455-4", dataLeAk455);
		android.util.Log.d("leak-456-4", dataLeAk456);
		android.util.Log.d("leak-457-4", dataLeAk457);
		android.util.Log.d("leak-458-4", dataLeAk458);
		android.util.Log.d("leak-459-4", dataLeAk459);
		android.util.Log.d("leak-460-4", dataLeAk460);
		android.util.Log.d("leak-461-4", dataLeAk461);
		android.util.Log.d("leak-462-4", dataLeAk462);
		return index;
    }

    public void setIndex(int index) {
        dataLeAk460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-455-5", dataLeAk455);
		android.util.Log.d("leak-456-5", dataLeAk456);
		android.util.Log.d("leak-457-5", dataLeAk457);
		android.util.Log.d("leak-458-5", dataLeAk458);
		android.util.Log.d("leak-459-5", dataLeAk459);
		android.util.Log.d("leak-460-5", dataLeAk460);
		android.util.Log.d("leak-461-5", dataLeAk461);
		android.util.Log.d("leak-462-5", dataLeAk462);
		this.index = index;
    }

    public String getParentChapter() {
        dataLeAk461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-455-6", dataLeAk455);
		android.util.Log.d("leak-456-6", dataLeAk456);
		android.util.Log.d("leak-457-6", dataLeAk457);
		android.util.Log.d("leak-458-6", dataLeAk458);
		android.util.Log.d("leak-459-6", dataLeAk459);
		android.util.Log.d("leak-460-6", dataLeAk460);
		android.util.Log.d("leak-461-6", dataLeAk461);
		android.util.Log.d("leak-462-6", dataLeAk462);
		return parentChapter;
    }

    public void setParentChapter(String parentChapter) {
        dataLeAk462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-455-7", dataLeAk455);
		android.util.Log.d("leak-456-7", dataLeAk456);
		android.util.Log.d("leak-457-7", dataLeAk457);
		android.util.Log.d("leak-458-7", dataLeAk458);
		android.util.Log.d("leak-459-7", dataLeAk459);
		android.util.Log.d("leak-460-7", dataLeAk460);
		android.util.Log.d("leak-461-7", dataLeAk461);
		android.util.Log.d("leak-462-7", dataLeAk462);
		this.parentChapter = parentChapter;
    }
}
