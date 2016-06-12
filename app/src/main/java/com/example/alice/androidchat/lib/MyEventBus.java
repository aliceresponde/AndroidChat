package com.example.alice.androidchat.lib;

/**
 * Created by alice on 6/12/16.
 * Interface asociated  to  Eventbus
 */

public interface MyEventBus {

    //Register to Buss  by  object
    void register(Object subscriber);

    //Unregister
    void unregister(Object subscriber);

    //Publicar evento en el bus
    void post(Object event);
}
