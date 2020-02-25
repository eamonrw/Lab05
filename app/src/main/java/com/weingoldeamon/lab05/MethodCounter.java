package com.weingoldeamon.lab05;


import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.TreeMap;

public class MethodCounter implements LifecycleObserver {
    private TreeMap<String, Integer> eventMap;

    public MethodCounter(){
        eventMap = new TreeMap<>();
        for(String s: new String[]{"onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy"})
            eventMap.put(s, 0);
    }

    public TreeMap getEventMap(){
        return eventMap;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateCount(){
        eventMap.put("onCreate", eventMap.get("onCreate") + 1);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartCount(){
        eventMap.put("onStart", eventMap.get("onStart") + 1);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeCount(){
        eventMap.put("onResume", eventMap.get("onResume") + 1);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseCount(){
        eventMap.put("onPause", eventMap.get("onPause") + 1);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopCount(){
        eventMap.put("onStop", eventMap.get("onStop") + 1);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyCount(){
        eventMap.put("onDestroy", eventMap.get("onDestroy") + 1);
    }
}
