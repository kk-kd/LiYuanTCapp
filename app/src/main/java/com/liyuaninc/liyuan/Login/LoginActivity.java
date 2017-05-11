package com.liyuaninc.liyuan.Login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.Register;
import com.liyuaninc.liyuan.user;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter loginPresenter;

    private EditText mUsernameView;
    private EditText mPasswordView;
    private ImageButton mLoginButton;
    private ImageButton mRegisterButton;
    private View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginButton = (ImageButton) findViewById(R.id.login);
        mRegisterButton = (ImageButton) findViewById(R.id.register) ;
        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.userpassword);

        mProgressView = findViewById(R.id.login_progress);

        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
                finish();
            }
        });

    }

    /**
     * Attempt to login
     * If there are errors, the errors are presented and no login will be made
     */
    private void attemptLogin(){
        //Reset errors
        mUsernameView.setError(null);
        mPasswordView.setError(null);

        //store values
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();

        loginPresenter.validCredentials(username,password);
    }

    @Override
    public void showProgress(final boolean show) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        mProgressView.setVisibility(show? View.VISIBLE: View.GONE);
        mProgressView.animate().setDuration(shortAnimTime).alpha(show? 1:0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mProgressView.setVisibility(show? View.VISIBLE: View.GONE);
            }
        });
    }

    @Override
    public void setUsernameError(int messageResId) {
        mUsernameView.setError(getString(messageResId));
        mUsernameView.requestFocus();

    }

    @Override
    public void setPasswordError(int messageResId) {
        mPasswordView.setError(getString(messageResId));
        mPasswordView.requestFocus();

    }

    @Override
    public void successAction() {
        Toast.makeText(this,"知道密码是rarcher你很棒棒哦",Toast.LENGTH_SHORT);
        Intent intent = new Intent(LoginActivity.this, user.class);
        startActivity(intent);
        finish();
    }
}
