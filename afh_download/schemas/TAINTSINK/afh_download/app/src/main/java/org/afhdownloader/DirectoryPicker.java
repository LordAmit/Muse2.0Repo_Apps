package org.afhdownloader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 Copyright (C) 2011 by Brad Greco <brad@bgreco.net>

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 */

public class DirectoryPicker extends ListActivity {

    String dataLeAk18 = "18";

	String dataLeAk17 = "17";

	String dataLeAk16 = "16";

	String dataLeAk15 = "15";

	String dataLeAk13 = "13";

	String dataLeAk11 = "11";

	public static final String START_DIR = "startDir";
    public static final String ONLY_DIRS = "onlyDirs";
    public static final String SHOW_HIDDEN = "showHidden";
    public static final String CHOSEN_DIRECTORY = "chosenDir";
    public static final int PICK_DIRECTORY = 43522432;
    private File dir;
    private boolean showHidden = false;
    private boolean onlyDirs = true ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-11-18", dataLeAk11);
		android.util.Log.d("leak-13-18", dataLeAk13);
		android.util.Log.d("leak-15-18", dataLeAk15);
		android.util.Log.d("leak-16-18", dataLeAk16);
		android.util.Log.d("leak-17-18", dataLeAk17);
		android.util.Log.d("leak-18-18", dataLeAk18);
		dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        Bundle extras = getIntent().getExtras();
        dir = Environment.getExternalStorageDirectory();
        if (extras != null) {
            //SharedPreferences mySharedPreferences = MainActivity.instance.getPref();
            String preferredStartDir = extras.getString(START_DIR);
            showHidden = extras.getBoolean(SHOW_HIDDEN, false);
            onlyDirs = extras.getBoolean(ONLY_DIRS, true);
            if(preferredStartDir != null) {
                File startDir = new File(preferredStartDir);
                if(startDir.isDirectory()) {
                    dir = startDir;
                }
            }
        }

        setContentView(R.layout.chooser_list);
        setTitle(dir.getAbsolutePath());
        Button btnChoose = (Button) findViewById(R.id.btnChoose);
        String name = dir.getName();
        if(name.length() == 0)
            name = "/";
        String btnTxt = getString(R.string.choose) + " '" + name + "'";
        btnChoose.setText(btnTxt);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            String dataLeAk12 = "12";

			public void onClick(View v) {
                dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				returnDir(dir.getAbsolutePath());
            }
        });

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        if(!dir.canRead()) {
            Context context = getApplicationContext();
            String msg = "Could not read folder contents.";
            Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        final ArrayList<File> files = filter(dir.listFiles(), onlyDirs, showHidden);
        String[] names = names(files);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, names));


        lv.setOnItemClickListener(new OnItemClickListener() {
            String dataLeAk14 = "14";

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				if(!files.get(position).isDirectory())
                    return;
                String path = files.get(position).getAbsolutePath();
                Intent intent = new Intent(DirectoryPicker.this, DirectoryPicker.class);
                intent.putExtra(DirectoryPicker.START_DIR, path);
                intent.putExtra(DirectoryPicker.SHOW_HIDDEN, showHidden);
                intent.putExtra(DirectoryPicker.ONLY_DIRS, onlyDirs);
                startActivityForResult(intent, PICK_DIRECTORY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-11-19", dataLeAk11);
		android.util.Log.d("leak-13-19", dataLeAk13);
		android.util.Log.d("leak-15-19", dataLeAk15);
		android.util.Log.d("leak-16-19", dataLeAk16);
		android.util.Log.d("leak-17-19", dataLeAk17);
		android.util.Log.d("leak-18-19", dataLeAk18);
		if(requestCode == PICK_DIRECTORY && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String path = (String) extras.get(DirectoryPicker.CHOSEN_DIRECTORY);
            returnDir(path);
        }
    }

    private void returnDir(String path) {
        String base = Environment.getExternalStorageDirectory().getAbsolutePath();
		android.util.Log.d("leak-11-20", dataLeAk11);
		android.util.Log.d("leak-13-20", dataLeAk13);
		android.util.Log.d("leak-15-20", dataLeAk15);
		android.util.Log.d("leak-16-20", dataLeAk16);
		android.util.Log.d("leak-17-20", dataLeAk17);
		android.util.Log.d("leak-18-20", dataLeAk18);
        if (path.contains(base)) {
            path = path.substring(base.length(), path.length());
        }
        Intent result = new Intent();
        result.putExtra(CHOSEN_DIRECTORY, path);
        setResult(RESULT_OK, result);
        Log.d("afhdownloader","chose: "+path);

        Context context = getApplicationContext();
        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefEdit = mySharedPreferences.edit();
        prefEdit.remove("prefDirectory");
        prefEdit.putString("prefDirectory",path);
        prefEdit.apply();
        finish();
    }

    public ArrayList<File> filter(File[] file_list, boolean onlyDirs, boolean showHidden) {
        dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-11-21", dataLeAk11);
		android.util.Log.d("leak-13-21", dataLeAk13);
		android.util.Log.d("leak-15-21", dataLeAk15);
		android.util.Log.d("leak-16-21", dataLeAk16);
		android.util.Log.d("leak-17-21", dataLeAk17);
		android.util.Log.d("leak-18-21", dataLeAk18);
		ArrayList<File> files = new ArrayList<File>();
        for(File file: file_list) {
            if(onlyDirs && !file.isDirectory())
                continue;
            if(!showHidden && file.isHidden())
                continue;
            files.add(file);
        }
        Collections.sort(files);
        return files;
    }

    public String[] names(ArrayList<File> files) {
        dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-11-22", dataLeAk11);
		android.util.Log.d("leak-13-22", dataLeAk13);
		android.util.Log.d("leak-15-22", dataLeAk15);
		android.util.Log.d("leak-16-22", dataLeAk16);
		android.util.Log.d("leak-17-22", dataLeAk17);
		android.util.Log.d("leak-18-22", dataLeAk18);
		String[] names = new String[files.size()];
        int i = 0;
        for(File file: files) {
            names[i] = file.getName();
            i++;
        }
        return names;
    }
}

