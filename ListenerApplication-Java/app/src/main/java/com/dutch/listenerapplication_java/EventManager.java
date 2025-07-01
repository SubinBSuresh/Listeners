package com.dutch.listenerapplication_java;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private static final String TAG = "DUTCH_" + "EventManager";
    public final List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener eventListener) {
        Log.i(TAG, "addListener()");
        listeners.add(eventListener);
    }

    public void removeListener(EventListener eventListener) {
        Log.i(TAG, "removeListener()");
        listeners.remove(eventListener);
    }

    public void triggerEvent(String message) {
        Log.i(TAG, "triggerEvent()");
        for (EventListener eventListener : listeners) {
            Log.i(TAG, "onEvent calling for " + eventListener);
            eventListener.onEvent(message);
        }
    }

    public void triggerEventReversed(String message) {
        Log.i(TAG, "triggerEventReversed()");
        for (int i = listeners.size() - 1; i >= 0; i--) {
            Log.i(TAG, "reverse trigger: " + listeners.get(i));
            listeners.get(i).onEvent(message);
        }
    }

}
