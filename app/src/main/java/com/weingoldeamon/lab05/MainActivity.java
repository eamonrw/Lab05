package com.weingoldeamon.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    MethodCounter cycleTracker = new MethodCounter();
    TextView onCreate1, onStart1, onResume1, onPause1, onStop1, onRestart1, onDestroy1;
    TextView onCreate2, onStart2, onResume2, onPause2, onStop2, onRestart2, onDestroy2;
    TreeMap<String, TextView[]> viewMap = new TreeMap<>();
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("Lifecycle_Counts", Context.MODE_PRIVATE);
        onCreate1 = findViewById(R.id.onCreate_text1);
        onStart1 = findViewById(R.id.onStart_text1);
        onResume1 = findViewById(R.id.onResume_text1);
        onPause1 = findViewById(R.id.onPause_text1);
        onStop1 = findViewById(R.id.onStop_text1);
        onRestart1 = findViewById(R.id.onRestart_text1);
        onDestroy1 = findViewById(R.id.onDestroy_text1);
        onCreate2 = findViewById(R.id.onCreate_text2);
        onStart2 = findViewById(R.id.onStart_text2);
        onResume2 = findViewById(R.id.onResume_text2);
        onPause2 = findViewById(R.id.onPause_text2);
        onStop2 = findViewById(R.id.onStop_text2);
        onRestart2 = findViewById(R.id.onRestart_text2);
        onDestroy2 = findViewById(R.id.onDestroy_text2);
        viewMap.put("onCreate", new TextView[]{onCreate1, onCreate2});
        viewMap.put("onStart", new TextView[]{onStart1, onStart2});
        viewMap.put("onResume", new TextView[]{onResume1, onResume2});
        viewMap.put("onPause", new TextView[]{onPause1, onPause2});
        viewMap.put("onStop", new TextView[]{onStop1, onStop2});
        viewMap.put("onRestart", new TextView[]{onRestart1, onRestart2});
        viewMap.put("onDestroy", new TextView[]{onDestroy1, onDestroy2});
        updateCount("onCreate");
    }
    
    public void updateCount(String methodName) {
        SharedPreferences.Editor editor = pref.edit();
        cycleTracker.incrementMethodCount(methodName);
        editor.putInt(methodName, pref.getInt(methodName, 0) + 1);
        editor.apply();
    }
    public void updateText() {
        for(String key: viewMap.keySet()) {
            TextView[] tv = viewMap.get(key);
            tv[0].setText(""+cycleTracker.getMethodCount(key));
            tv[1].setText(""+pref.getInt(key, 0));
        }
    }
    @Override
    protected void onStart() {
        updateCount("onStart");
        super.onStart();
        updateText();
    }
    @Override
    protected void onResume() {
        updateCount("onResume");
        super.onResume();
        updateText();
    }
    @Override
    protected void onPause() {
        updateCount("onPause");
        super.onPause();
    }
    @Override
    protected void onStop() {
        updateCount("onStop");
        super.onStop();
    }
    @Override
    protected void onRestart() {
        updateCount("onRestart");
        super.onRestart();
    }
    @Override
    protected void onDestroy() {
        updateCount("onDestroy");
        super.onDestroy();
    }

    public void resetCount1(View view) {
        for(String key: viewMap.keySet()) {
            TextView[] tv = viewMap.get(key);
            tv[0].setText("0");
        }
    }
    public void resetCount2(View view) {
        for(String key: viewMap.keySet()) {
            TextView[] tv = viewMap.get(key);
            tv[1].setText("0");
            SharedPreferences.Editor editor = pref.edit();
            editor.clear();
            editor.apply();
        }
    }
}
