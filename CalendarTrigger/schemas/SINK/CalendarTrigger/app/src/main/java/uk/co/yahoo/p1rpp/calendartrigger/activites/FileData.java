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

    String dataLeAk367 = "";

	public File file;
    public String name;
    public boolean directory = false;

    public FileData(File file, String name, boolean directory) {
        dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-367-0", dataLeAk367);
		this.file = file;
        this.name = name;
        this.directory = directory;
    }
}
