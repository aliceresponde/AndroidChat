package com.example.alice.androidchat;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by alice on 6/7/16.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setUpFireBase();
    }

    private void setUpFireBase() {
        Firebase.setAndroidContext(this);
        //  Offline persistence
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
