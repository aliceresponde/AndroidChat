package com.example.alice.androidchat.login;

import android.util.Log;

import com.example.alice.androidchat.lib.GreenRobotsEventBus;
import com.example.alice.androidchat.lib.MyEventBus;
import com.example.alice.androidchat.login.events.LoginEvent;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by alice on 6/9/16.
 * It  has the LoginView interface
 *         the LoginInteractor interface
 *
 */

public class LoginPresenterImpl implements  LoginPresenter {
    private MyEventBus myEventBus;
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    private final String TAG = LoginPresenterImpl.class.getSimpleName();

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        this.myEventBus = GreenRobotsEventBus.getInstance();
    }

    /**
     * Registro el presentador para escuchar el bus
     */
    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate");
        myEventBus.register(this);
    }

    /**
     * avoid  memory leak
     * Des registro al presentador al bus de eventos
     */
    @Override
    public void onDestroy() {
        loginView = null;
        myEventBus.unregister(this);
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

//    @Subscribe (threadMode = ThreadMode.MAIN)
    @Subscribe
    @Override
    public void onEventMainThread(LoginEvent event) {
        Log.e(TAG, "onEventMainThread" );
        switch (event.getEventType()){
            case  LoginEvent.onSignInSuccess:
                onSinginSuccess();
                break;

            case  LoginEvent.onSignUpSuccess:
                onSingupSuccess();
                break;

            case LoginEvent.onSignInError:
                onSinginError( event.getEventErrorMessage() );
                break;

            case LoginEvent.onSignUpError:
                onSingupError( event.getEventErrorMessage());
                break;

            case LoginEvent.onFailedToRecoverySession:
                onFailedToRecoverySession();
                break;
        }
    }


    private void onFailedToRecoverySession() {
        Log.e(TAG, "onFailedToRecoverySession");
        if (loginView != null ){
            Log.e(TAG, "onFailedToRecoverySession  LoginVire !=  null");
            loginView.hideProgressBar();
            loginView.enableInputs();
        }

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

    @Override
    public void checkForAuthenticatedUser() {
        Log.e(TAG, "checkForAuthenticatedUser" );
        if (loginView != null ){
            Log.e(TAG, "checkForAuthenticatedUser  --> loginView != null" );
            loginView.disableInputs();
            loginView.showProgressBar();
        }

        loginInteractor.checkSesion();
    }


    private  void  onSingupError(String error){
        if (loginView != null ){
            loginView.hideProgressBar();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }
}
