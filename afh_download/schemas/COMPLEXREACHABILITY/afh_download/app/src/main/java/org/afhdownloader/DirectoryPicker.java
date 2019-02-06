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
		String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
		android.util.Log.d("leak-54", dataLeAkPath54);
        Bundle extras = getIntent().getExtras();
        dir = Environment.getExternalStorageDirectory();
        if (extras != null) {
            String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
			android.util.Log.d("leak-55", dataLeAkPath55);
			//SharedPreferences mySharedPreferences = MainActivity.instance.getPref();
            String preferredStartDir = extras.getString(START_DIR);
            showHidden = extras.getBoolean(SHOW_HIDDEN, false);
            onlyDirs = extras.getBoolean(ONLY_DIRS, true);
            if(preferredStartDir != null) {
                String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
				String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
				android.util.Log.d("leak-56", dataLeAkPath56);
				File startDir = new File(preferredStartDir);
                if(startDir.isDirectory()) {
                    String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP57.put("test", new java.util.HashMap<String, String>());
					leakMaP57.get("test").put("test", dataLeAk57);
					String dataLeAkPath57 = leakMaP57.get("test").get("test");
					android.util.Log.d("leak-57", dataLeAkPath57);
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
            public void onClick(View v) {
                String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
				android.util.Log.d("leak-58", dataLeAkPath58);
				returnDir(dir.getAbsolutePath());
            }
        });

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        if(!dir.canRead()) {
            String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
			android.util.Log.d("leak-59", dataLeAkPath59);
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
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
				String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
				android.util.Log.d("leak-60", dataLeAkPath60);
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
        String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP61.put("test", new java.util.HashMap<String, String>());
		leakMaP61.get("test").put("test", dataLeAk61);
		String dataLeAkPath61 = leakMaP61.get("test").get("test");
		android.util.Log.d("leak-61", dataLeAkPath61);
		if(requestCode == PICK_DIRECTORY && resultCode == RESULT_OK) {
            String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
			android.util.Log.d("leak-62", dataLeAkPath62);
			Bundle extras = data.getExtras();
            String path = (String) extras.get(DirectoryPicker.CHOSEN_DIRECTORY);
            returnDir(path);
        }
    }

    private void returnDir(String path) {
        String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
		android.util.Log.d("leak-63", dataLeAkPath63);
		String base = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (path.contains(base)) {
            String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
			String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
			android.util.Log.d("leak-64", dataLeAkPath64);
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
        String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP65.put("test", new java.util.HashMap<String, String>());
		leakMaP65.get("test").put("test", dataLeAk65);
		String dataLeAkPath65 = leakMaP65.get("test").get("test");
		android.util.Log.d("leak-65", dataLeAkPath65);
		ArrayList<File> files = new ArrayList<File>();
        for(File file: file_list) {
            String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
			android.util.Log.d("leak-66", dataLeAkPath66);
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
        String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
		android.util.Log.d("leak-67", dataLeAkPath67);
		String[] names = new String[files.size()];
        int i = 0;
        for(File file: files) {
            String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
			String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
			android.util.Log.d("leak-68", dataLeAkPath68);
			names[i] = file.getName();
            i++;
        }
        return names;
    }
}

