package com.example.alice.androidchat.lib;

/**
 * Created by alice on 6/12/16.
 * Interface asociated  to  Eventbus
 */

public interface EventBus {

    //Register to Buss  by  object
    void registerToEventBusBy(Object subscriber);

    //Unregister
    void unregisterToEventBusBy(Object subscriber);

    //Publicar evento en el bus
    void postInEventBus( Object event);





}
