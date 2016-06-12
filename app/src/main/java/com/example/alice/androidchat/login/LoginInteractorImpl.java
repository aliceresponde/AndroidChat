package com.example.alice.androidchat.login;

import android.util.Log;

/**
 * Created by alice on 6/11/16.
 * Solicito al Repositoyry implemente los metodos asociados
 * Para un llamado en cascada
 */

public class LoginInteractorImpl implements LoginInteractor {
    LoginRepository loginRepository;

    /**
     * Constuctor that initialize LoginRepositoty with the implementer
     */
    public LoginInteractorImpl() {
        loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void checkSesion() {
        Log.e("LoginInteractorImpl","checkSesion");
        loginRepository.checkSession();
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email,password);
    }

    @Override
    public void doSignUp(String email, String password) {
        loginRepository.signUp(email,password);
    }
}
