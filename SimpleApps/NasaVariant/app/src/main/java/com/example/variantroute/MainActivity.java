package com.example.variantroute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MainActivity extends Activity {

    int i = 0;
    String dataLeAk0 = "0";
    private Calendar weekStart, weekEnd;
    private NASA nasaAPOD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        CustomOnClickListener customOnClickListener = new CustomOnClickListener();
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TextView t = findViewById(R.id.textView);
//                String counter = "Counter: "+i;
//                i++;
//                t.setText(counter);
//            }
//        });
//        customOnClickListener.onClick(button);

        findViewById(R.id.button).setOnClickListener(customOnClickListener);
        Intent intent = this.getIntent();

        Bundle bundle = intent.getExtras();

        nasaAPOD = (NASA) (bundle != null ? bundle.getSerializable("Nasa") : null);

        setDataNasaAPOD(nasaAPOD);


    }
    private void setDataNasaAPOD(NASA nasaAPOD) {
        String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        nasaAPOD.getTitle();

        nasaAPOD.getDate();

//        TextView copyright = findViewById(R.id.copyright);
        nasaAPOD.getCopyright();

//        TextView explanationView = findViewById(R.id.explanation);
//        explanationView.setText(
                nasaAPOD.getExplanation();
//        explanationView.setMovementMethod(new ScrollingMovementMethod());
    }





}
