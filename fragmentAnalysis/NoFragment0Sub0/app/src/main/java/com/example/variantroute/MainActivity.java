package com.example.variantroute;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    static String dataLeAk0 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        android.util.Log.d("leak-0-1", dataLeAk0);

        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new SimpleFragment())
                .commit();
//        }


    }

    public void buttonClicked(View view) {
        Log.d("amit", "button clicked");
        TextView t = findViewById(R.id.textView);
        String counter = "Counter: " + i;
        i++;
        t.setText(counter);

    }

    public static class SimpleFragment extends Fragment {


        public SimpleFragment() {
            // Required empty public constructor
//                android.util.Log.d("leak-0-1", dataLeAk0);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
            return rootView;
//            return inflater.inflate(R.layout.fragment_simple, container, false);
        }

    }
}
