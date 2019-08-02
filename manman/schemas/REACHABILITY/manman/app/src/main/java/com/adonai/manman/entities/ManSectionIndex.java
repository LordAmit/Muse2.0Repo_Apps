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

    String dataLeAk621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk621 = android.util.Log.d("leak-621", dataLeAk621);

	public ManSectionIndex(char letter, int index, String parentChapter) {
        String dataLeAk622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk622 = android.util.Log.d("leak-622", dataLeAk622);
		this.letter = letter;
        this.index = index;
        this.parentChapter = parentChapter;
    }

    public ManSectionIndex() {
		String dataLeAk623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk623 = android.util.Log.d("leak-623", dataLeAk623);
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
        String dataLeAk624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk624 = android.util.Log.d("leak-624", dataLeAk624);
		return letter;
    }

    public void setLetter(char letter) {
        String dataLeAk625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk625 = android.util.Log.d("leak-625", dataLeAk625);
		this.letter = letter;
    }

    public int getIndex() {
        String dataLeAk626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk626 = android.util.Log.d("leak-626", dataLeAk626);
		return index;
    }

    public void setIndex(int index) {
        String dataLeAk627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk627 = android.util.Log.d("leak-627", dataLeAk627);
		this.index = index;
    }

    public String getParentChapter() {
        String dataLeAk628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk628 = android.util.Log.d("leak-628", dataLeAk628);
		return parentChapter;
    }

    public void setParentChapter(String parentChapter) {
        String dataLeAk629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk629 = android.util.Log.d("leak-629", dataLeAk629);
		this.parentChapter = parentChapter;
    }
}
