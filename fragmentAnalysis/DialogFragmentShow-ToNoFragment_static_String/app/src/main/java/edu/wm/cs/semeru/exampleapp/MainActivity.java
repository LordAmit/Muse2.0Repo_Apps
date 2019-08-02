package edu.wm.cs.semeru.exampleapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    static String dataLeAk = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        android.util.Log.d("leak-1", dataLeAk);
        setContentView(R.layout.activity_main);
//        DialogFragment example = new ExampleDialogFragment();
//        example.show(getFragmentManager(), "ExampleDialog");
    }

//    public static class ExampleDialogFragment extends DialogFragment {
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//            android.util.Log.d("leak-1", dataLeAk);
//            return null;
//        }
//    }
}
