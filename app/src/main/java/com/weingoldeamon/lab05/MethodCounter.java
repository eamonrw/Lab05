package com.weingoldeamon.lab05;

import java.util.TreeMap;

public class MethodCounter {
    private TreeMap<String, Integer> eventMap;

    public MethodCounter(){
        eventMap = new TreeMap<>();
    }

    public void incrementMethodCount(String methodName) {
        int value = 1;
        if(eventMap.containsKey(methodName))
            value += eventMap.get(methodName);
        eventMap.put(methodName, value);
    }
    public int getMethodCount(String methodName) {
        if(eventMap.containsKey(methodName))
            return eventMap.get(methodName);
        return 0;
    }
}
