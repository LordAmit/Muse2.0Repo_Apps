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

    public File file;
    public String name;
    public boolean directory = false;

    public FileData(File file, String name, boolean directory) {
        String dataLeAk555 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath555;try {throw new Exception(dataLeAk555);} catch (Exception leakErRor555) {dataLeAkPath555 = leakErRor555.getMessage();}
		android.util.Log.d("leak-555", dataLeAkPath555);
		this.file = file;
        this.name = name;
        this.directory = directory;
    }
}
