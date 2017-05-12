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

import com.liyuaninc.liyuan.Login.Event.CancelledEvent;
import com.liyuaninc.liyuan.Login.Event.PasswordErrorEvent;
import com.liyuaninc.liyuan.Login.Event.SuccessEvent;
import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.Register;
import com.liyuaninc.liyuan.user;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

    /**
     * The animation that shows the progress bar when attempt to login
     * @param show whether the progress bar should be showed
     */

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

    /**
     * Set error message if username is invalid
     * TODO: change the displaly message before beta testing
     * @param messageResId Message needs to be displayed
     */
    @Override
    public void setUsernameError(int messageResId) {
        mUsernameView.setError(getString(messageResId));
        mUsernameView.requestFocus();

    }

    /**
     * Set error message if password is wrong or invalid
     * TODO: change the displaly message before beta testing
     * @param messageResId Message needs to be displayed
     */
    @Override
    public void setPasswordError(int messageResId) {
        mPasswordView.setError(getString(messageResId));
        mPasswordView.requestFocus();

    }

    /**
     * Display success message and connect to the main activity
     * @param successEvent eventbus:Event.SuccessEvent
     */
    //TODO: connect to mainActivity
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessEvent(SuccessEvent successEvent) {
        showProgress(false);
        Toast.makeText(this,"知道密码是rarcher你很棒棒哦",Toast.LENGTH_SHORT);
        Intent intent = new Intent(LoginActivity.this, user.class);
        startActivity(intent);
        finish();
    }

    /**
     * Display password error message
     * @param passwordErrorEvent eventbus:Event.PasswordErrorEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPasswrodErrorEvent(PasswordErrorEvent passwordErrorEvent) {
        showProgress(false);
        setPasswordError(R.string.password_incorrect_error);
    }

    /**
     * @param cancelledEvent eventbus:Event.CancelledEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCancelledEvent(CancelledEvent cancelledEvent) {
        showProgress(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
