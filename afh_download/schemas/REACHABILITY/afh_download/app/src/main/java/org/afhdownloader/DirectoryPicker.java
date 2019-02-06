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

    String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);

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
		String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
        Bundle extras = getIntent().getExtras();
        dir = Environment.getExternalStorageDirectory();
        if (extras != null) {
            String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
			//SharedPreferences mySharedPreferences = MainActivity.instance.getPref();
            String preferredStartDir = extras.getString(START_DIR);
            showHidden = extras.getBoolean(SHOW_HIDDEN, false);
            onlyDirs = extras.getBoolean(ONLY_DIRS, true);
            if(preferredStartDir != null) {
                String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
				File startDir = new File(preferredStartDir);
                if(startDir.isDirectory()) {
                    String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
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
            String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);

			public void onClick(View v) {
                String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
				returnDir(dir.getAbsolutePath());
            }
        });

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        if(!dir.canRead()) {
            String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
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
            String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
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
        String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);
		if(requestCode == PICK_DIRECTORY && resultCode == RESULT_OK) {
            String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
			Bundle extras = data.getExtras();
            String path = (String) extras.get(DirectoryPicker.CHOSEN_DIRECTORY);
            returnDir(path);
        }
    }

    private void returnDir(String path) {
        String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
		String base = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (path.contains(base)) {
            String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
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
        String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
		ArrayList<File> files = new ArrayList<File>();
        for(File file: file_list) {
            String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
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
        String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
		String[] names = new String[files.size()];
        int i = 0;
        for(File file: files) {
            String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
			names[i] = file.getName();
            i++;
        }
        return names;
    }
}

