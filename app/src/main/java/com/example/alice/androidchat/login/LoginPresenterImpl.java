package com.example.alice.androidchat.login;

/**
 * Created by alice on 6/9/16.
 * It  has the LoginView interface
 *         the LoginInteractor interface
 *
 */

public class LoginPresenterImpl implements  LoginPresenter {

    LoginView loginView;
    LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    /**
     * avoid  memory leak
     */
    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void checkForAuthenticatedUser() {
        if (loginView != null ){
            loginView.disableInputs();
            loginView.showProgressBar();
        }

        loginInteractor.checkSesion();
    }

    @Override
    public void validateLogin(String email, String password) {
        if (loginView != null ){
            loginView.disableInputs();
            loginView.showProgressBar();
        }
        loginInteractor.doSignIn(email, password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        if (loginView != null ){
            loginView.disableInputs();
            loginView.showProgressBar();
        }
        loginInteractor.doSignUp(email, password);
    }

    /**
     * Registro exitoso voy a Contacts
     */
    private  void  onSinginSuccess(){
        if (loginView != null ){
            loginView.navigateToMainScreen();
        }
    }

    /**
     * Aviso de la creacion exitosa, habilito los
     * inputs
     */
    private  void  onSingupSuccess(){
        if (loginView != null ){
            loginView.newUserSuccess();
        }
    }

    private  void  onSinginError(String error){
        if (loginView != null ){
            loginView.hideProgressBar();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private  void  onSingupError(String error){
        if (loginView != null ){
            loginView.hideProgressBar();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }
}