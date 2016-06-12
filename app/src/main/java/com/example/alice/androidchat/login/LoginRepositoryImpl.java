package com.example.alice.androidchat.login;

import android.util.Log;

import com.example.alice.androidchat.domain.FireBseHelper;
import com.example.alice.androidchat.lib.GreenRobotsEventBus;
import com.example.alice.androidchat.lib.MyEventBus;
import com.example.alice.androidchat.login.events.LoginEvent;

/**
 * Created by alice on 6/11/16.
 * Aqui es donde accedo a  FireBase
 */

public class LoginRepositoryImpl implements LoginRepository {
    private FireBseHelper fireBseHelper;
    private static final String TAG = LoginRepositoryImpl.class.getSimpleName();

    public LoginRepositoryImpl() {
        FireBseHelper.getInstance();
    }

    @Override
    public void signUp(String email, String password) {
        Log.e(TAG, "signUp");
        postEvent(LoginEvent.onSignUpSuccess);
    }

    @Override
    public void signIn(String email, String password) {
        Log.e(TAG, "signIn");
        postEvent(LoginEvent.onSignInSuccess);
    }

    @Override
    public void checkSession() {
        Log.e(TAG, "checkSession");
        postEvent(LoginEvent.onFailedToRecoverySession);
    }

    private void postEvent(int eventType, String errorMessage) {
        //Creo nuevo  evento de login
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(eventType);
        if (errorMessage != null) {
            loginEvent.setEventErrorMessage(errorMessage);
        }

        MyEventBus myEventBus = GreenRobotsEventBus.getInstance();
        myEventBus.post(myEventBus);
    }

    private void postEvent(int eventType) {
        Log.e(TAG, "postEvent ---> " + eventType );
        postEvent(eventType, null);
    }

}
