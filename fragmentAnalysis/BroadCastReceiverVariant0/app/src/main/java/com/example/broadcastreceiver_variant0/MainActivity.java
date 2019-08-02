package com.example.broadcastreceiver_variant0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                BroadcastReceiver receiver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                        android.util.Log.d("leak-1", dataLeAk);
                    }
                };
                getApplicationContext().registerReceiver(receiver, null);
            }
        };
        getApplicationContext().registerReceiver(receiver, null);

    }
}
