package com.example.alice.androidchat.lib;

/**
 * Created by alice on 6/12/16.
 * Wraper de EventBus
 * The idea is reduce dependenc if eventBus dependency change, here will  be the changes of the implementation
 */

public class GreenRobotsEventBus implements  EventBus{

    org.greenrobot.eventbus.EventBus eventBus;

    //Singleton
    private static  class SingletonHolder{
        private static final GreenRobotsEventBus INSTANCE = new GreenRobotsEventBus();
    }

    public static  GreenRobotsEventBus getInstance(){
        return SingletonHolder.INSTANCE;
    }


    public GreenRobotsEventBus() {
        this.eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Override
    public void registerToEventBusBy(Object subscriber) {
        eventBus.register(subscriber);

    }

    @Override
    public void unregisterToEventBusBy(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void postInEventBus(Object event) {
        eventBus.post(event);
    }
}
