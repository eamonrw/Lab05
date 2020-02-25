package com.weingoldeamon.lab05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.os.Bundle;
import android.widget.TextView;

import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    MethodCounter cycleTracker = new MethodCounter();
    TextView onCreate1, onStart1, onResume1, onPause1, onStop1, onRestart1, onDestroy1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getLifecycle().addObserver(cycleTracker);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onCreate1 = findViewById(R.id.onCreate_text1);
        onStart1 = findViewById(R.id.onStart_text1);
        onResume1 = findViewById(R.id.onResume_text1);
        onPause1 = findViewById(R.id.onPause_text1);
        onStop1 = findViewById(R.id.onStop_text1);
        onRestart1 = findViewById(R.id.onRestart_text1);
        onDestroy1 = findViewById(R.id.onDestroy_text1);

        TreeMap<String, Integer> eventMap = cycleTracker.getEventMap();
    }
}
