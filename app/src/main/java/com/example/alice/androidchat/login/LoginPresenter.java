package com.example.alice.androidchat.login;

import com.example.alice.androidchat.login.events.LoginEvent;

/**
 * Created by alice on 6/8/16.
 * Presentador que va a estar   vinculado a la vista, para poder
 */

public interface LoginPresenter {
    //Registrar el MyEventBus en el presenter
    void onCreate();

    //destruir la vista y el presntador
    void onDestroy();

    //Hay sesion  abierta??
    void checkForAuthenticatedUser();

    void validateLogin(String email, String password);

    void registerNewUser(String email, String password);

    //Regresa el evento al UI thread
    void onEventMainThread(LoginEvent event);

}
