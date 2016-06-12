package com.example.alice.androidchat.login;

/**
 * Created by alice on 6/8/16.
 * Interface que  va a interactuar  con Backend FireBase
 */

public interface LoginRepository {
    void signIn(String email, String password);
    void signUp(String email, String password);
    void checkSession();
}
