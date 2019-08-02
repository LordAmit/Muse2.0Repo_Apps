package com.example.variantroute;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class CustomOnClickListener implements OnClickListener {
    String dataLeAk0 = "0";

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        switch(b.getId()) {
            case R.id.button:
                dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                Log.d("leak-0", dataLeAk0);

                // Do something
                break;
        }

    }
}
