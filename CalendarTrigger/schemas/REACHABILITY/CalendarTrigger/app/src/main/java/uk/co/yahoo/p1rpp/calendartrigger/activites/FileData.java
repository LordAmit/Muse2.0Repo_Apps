/*
 * Copyright (c) 2017. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

 import java.io.File;

/**
 *
 * @author strangeoptics
 *
 */

public class FileData {

    String dataLeAk690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk690 = android.util.Log.d("leak-690", dataLeAk690);

	public File file;
    public String name;
    public boolean directory = false;

    public FileData(File file, String name, boolean directory) {
        String dataLeAk691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk691 = android.util.Log.d("leak-691", dataLeAk691);
		this.file = file;
        this.name = name;
        this.directory = directory;
    }
}
