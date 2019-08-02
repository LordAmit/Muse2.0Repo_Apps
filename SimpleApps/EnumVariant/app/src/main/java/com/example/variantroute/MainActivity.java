package com.example.variantroute;

import android.app.Activity;
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

    enum Day {

        MONDAY(Calendar.MONDAY, "Mon"),
        TUESDAY(Calendar.TUESDAY, "Tue"),
        WEDNESDAY(Calendar.WEDNESDAY, "Wed"),
        THURSDAY(Calendar.THURSDAY, "Thu"),
        FRIDAY(Calendar.FRIDAY, "Fri"),
        SATURDAY(Calendar.SATURDAY, "Sat"),
        SUNDAY(Calendar.SUNDAY, "Sun");
        public int calEnum;
        public String header;

        Day(int calEnum, String header) {
            String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            Object throwawayLeAk323 = android.util.Log.d("leak-323", dataLeAk323);
            this.calEnum = calEnum;
            this.header = header;
        }

        static Day fromCalEnum(int calEnum) {
            String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            Object throwawayLeAk324 = android.util.Log.d("leak-324", dataLeAk324);
            for (Day v : values()) {
                String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                Object throwawayLeAk325 = android.util.Log.d("leak-325", dataLeAk325);
                if (v.calEnum == calEnum) {
                    String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                    Object throwawayLeAk326 = android.util.Log.d("leak-326", dataLeAk326);
                    return v;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return header;
        }
        public int calEnum() {
            return calEnum;
        }
    }

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
        getCurrentRange();
    }

    private String[][] getCurrentRange() {
        ArrayList<String> c = new ArrayList<String>();
        c.add("a");
        c.add("B");

        Iterator<String> iterator = c.iterator();

        List<String[]> activities = new ArrayList<String[]>();

        Map<Integer, String> activityNames = new TreeMap<Integer, String>();



//        Cursor c = db.query(ACTIVITY_TABLE, new String[]{"ROWID", ACTIVITY_NAME}, null, null, null, null, "ROWID");
        if (true) {
            do {
                int tid = new Random().nextInt();
                String tname = iterator.next();
                activityNames.put(tid, tname);
            } while (iterator.hasNext());
        }
//        c.close();

        int[] weekDays = new int[7];
        for (int i = 0; i < 7; i++) {
            weekDays[i] = (2 % 7) + 1;
        }
        // Add the headers
        String[] headers = new String[9];
        headers[0] = "Activity name";
        for (int i = 0; i < 7; i++) {
            Day s = Day.fromCalEnum(weekDays[i]);
            headers[i + 1] = s.header;
        }
        headers[8] = "Total";
        activities.add(headers);

        String[][] k = {{}};
        return activities.toArray(k);
    }


}
