package com.dutch.listenerapplication_java;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DUTCH_ " + "MainActivity";
    private Button btNotify;
    private EventManager eventManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btNotify = findViewById(R.id.btn_notify);
        eventManager = new EventManager();

        btNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick()");
                eventManager.triggerEvent("Hello listeners");
            }
        });


        //listener 1
        eventManager.addListener(new EventListener() {
            @Override
            public void onEvent(String message) {
                Log.d(TAG, "onEvent in Listener1, message: " + message);
            }
        });

        //listener 2
        eventManager.addListener(new EventListener() {
            @Override
            public void onEvent(String message) {
                Log.d(TAG, "onEVent in Listener2, message: " + message);
            }
        });

    }
}