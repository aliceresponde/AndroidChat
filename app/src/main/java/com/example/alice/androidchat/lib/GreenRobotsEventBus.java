package com.example.alice.androidchat.lib;

import android.util.Log;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by alice on 6/12/16.
 * Wraper de MyEventBus
 * The idea is reduce dependenc if eventBus dependency change, here will  be the changes of
 * the implementation
 */

public class GreenRobotsEventBus implements MyEventBus {

    org.greenrobot.eventbus.EventBus eventBus;
    private static final  String TAG = GreenRobotsEventBus.class.getSimpleName();

    //Singleton
    private static class SingletonHolder {
        private static final GreenRobotsEventBus INSTANCE = new GreenRobotsEventBus();
    }

    public static GreenRobotsEventBus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Subscribe
    @Override
    public void register(Object subscriber) {
        Log.e(TAG,"register" );
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        Log.e(TAG,"unregister" );
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        Log.e(TAG,"post" );
        eventBus.post(event);
    }

    public GreenRobotsEventBus() {
        Log.e(TAG,"GreenRobotsEventBus" );
        this.eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

}
