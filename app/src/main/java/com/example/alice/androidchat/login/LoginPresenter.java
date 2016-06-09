package com.example.alice.androidchat.login;

/**
 * Created by alice on 6/8/16.
 * Presentador que va a estar   vinculado a la vista, para poder
 */

public interface LoginPresenter {
    //destruir la vista y el presntador
    void onDestroy();

    //Hay sesion  abierta??
    void checkForAuthenticatedUser();

    void validateLogin(String email, String password);

    void  registerNewUser(String email, String password);


}
