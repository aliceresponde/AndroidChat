package com.example.alice.androidchat.login.events;

/**
 * Created by alice on 6/12/16.
 * Clase q maneja el/los eventos de loginActuvity
 * Este evento del login sera usado desde el  Repository
 */

public class LoginEvent {
    public final static int onSignInError = 0;
    public final static int onSignUpError = 1;
    public static final int onSignInSuccess = 2;
    public final static int onSignUpSuccess = 3;
    public final static int onFailedToRecoverySession = 4;

    private int eventType;
    private String eventErrorMessage;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getEventErrorMessage() {
        return eventErrorMessage;
    }

    public void setEventErrorMessage(String eventErrorMessage) {this.eventErrorMessage = eventErrorMessage;}
}
