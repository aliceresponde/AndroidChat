package com.example.alice.androidchat.login;

/**
 * Created by alice on 6/8/16.
 * Trabajara los casos de uso CU
 */

public interface LoginInteractor {
    void checkSesion();
    void doSignIn(String email, String password);
    void doSignUp(String email, String password);
}
