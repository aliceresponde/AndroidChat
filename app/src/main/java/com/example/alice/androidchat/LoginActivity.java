package com.example.alice.androidchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    public static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.inputEmail)
    EditText inputEmail;
    @BindView(R.id.inputPassword)
    EditText inputPassword;
    @BindView(R.id.btnSingIn)
    Button btnSingIn;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btnSingIn, R.id.btnLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSingIn:
                handleSingInClick();
                break;
            case R.id.btnLogin:
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
}
