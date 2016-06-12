package com.example.alice.androidchat.login;

import android.bluetooth.le.ScanRecord;
import android.util.Log;

import com.example.alice.androidchat.domain.FireBseHelper;
import com.firebase.client.Firebase;

/**
 * Created by alice on 6/11/16.
 * Aqui es donde accedo a  FireBase
 */

public class LoginRepositoryImpl implements LoginRepository {
    FireBseHelper fireBseHelper;
    private static final String TAG = LoginRepository.class.getSimpleName();

    public LoginRepositoryImpl() {
        FireBseHelper.getInstance();
    }

    @Override
    public void signUp(String email, String password) {
        Log.e(TAG, "signUp" );
    }

    @Override
    public void signIn(String email, String password) {
        Log.e(TAG, "signIn" );
    }

    @Override
    public void checkSession() {
        Log.e(TAG, "checkSession" );
    }
}
