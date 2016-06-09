package com.example.alice.androidchat.login;

/**
 * Created by alice on 6/8/16.
 */

public interface LoginView {
    void  enableInputs();
    void  disableInputs();
    void  showProgressBar();
    void  hideProgressBar();

    //registro
    void  handleSignUp();
    void  handleSignIn();

    //sesion exitosa
    void  navigateToMainScreen();
    void  loginError();

    //registro
    void  newUserSuccess();
    void  newUserError(String error);
}
