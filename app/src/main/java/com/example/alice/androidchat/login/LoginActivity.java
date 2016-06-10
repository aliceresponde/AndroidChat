package com.example.alice.androidchat.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.alice.androidchat.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements  LoginView {


    public static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.inputEmail)
    EditText inputEmail;
    @BindView(R.id.inputPassword)
    EditText inputPassword;
    @BindView(R.id.btnSingUp)
    Button btnSingIn;
    @BindView(R.id.btnSignIn)
    Button btnLogin;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btnSingUp, R.id.btnSignIn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSingUp:
                handleSingInClick();
                break;
            case R.id.btnSignIn:
                handleLoginClick();
                break;
        }
    }

    private void handleLoginClick() {
        Log.i(TAG, "handleLoginClick " + inputEmail.getText().toString());
    }

    private void handleSingInClick() {
        Log.i(TAG, "handleSingInClick " + inputEmail.getText().toString());
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
       setInputs(false);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.btnSingUp)
    @Override
    public void handleSignUp() {
        loginPresenter.registerNewUser(inputEmail.getText().toString(),
                                       inputPassword.getText().toString());

    }

    @OnClick(R.id.btnSignIn)
    @Override
    public void handleSignIn() {
        loginPresenter.validateLogin(inputEmail.getText().toString(),
                                     inputPassword.getText().toString());
    }

    @Override
    public void navigateToMainScreen() {

    }

    @Override
    public void loginError() {

    }

    @Override
    public void newUserSuccess() {

    }

    @Override
    public void newUserError(String error) {

    }

    private void setInputs( boolean enabled){
        inputEmail.setEnabled(enabled);
        inputPassword.setEnabled(enabled);
        btnLogin.setEnabled(enabled);
        btnSingIn.setEnabled(enabled);
    }
}
