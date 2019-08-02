package edu.wm.cs.semeru.exampleapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        android.util.Log.d("leak-1", dataLeAk);
        setContentView(R.layout.activity_main);
    }


//    public void leakData(View view) {
//        new AlertDialog.Builder(this).setTitle("example")
//                .setCancelable(true)
//                .setItems(R.array.link_names, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
////                        String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
////                        android.util.Log.d("leak-1", dataLeAk);
//                    }
//                })
//                .create()
//                .show();
//    }
}
