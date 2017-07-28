package com.liyuaninc.liyuan.Register;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.liyuaninc.liyuan.Login.Event.CancelledEvent;
import com.liyuaninc.liyuan.Login.Event.SuccessEvent;
import com.liyuaninc.liyuan.Login.LoginActivity;
import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.Register.Event.UsernameExistedEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by candy on 16/05/2017.
 */

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private RegisterPresenter registerPresenter;

    @BindView(R.id.register_email) EditText mEmailView;
    @BindView(R.id.register_name) EditText mUsernameView;
    @BindView(R.id.register_password) EditText mPasswordView;
    @BindView(R.id.register_progress) View mProgressView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        registerPresenter = new RegisterPresenterImp(this);
    }

    @OnClick(R.id.button_submit)
    @Override
    public void attemptRegister() {
        //reset errors
        mEmailView.setError(null);
        mPasswordView.setError(null);

        //store values
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String username = mUsernameView.getText().toString();

        registerPresenter.validCredentials(email, password, username);

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
    public void setEmailError(int messageResId) {
        mEmailView.setError(getString(messageResId));
        mEmailView.requestFocus();
    }

    @Override
    public void setPasswordError(int messageResId) {
        mPasswordView.setError(getString(messageResId));
        mPasswordView.requestFocus();
    }

    @OnClick(R.id.goLogin)
    @Override
    public void goLogin() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onSuccessEvent(SuccessEvent successEvent) {
        Toast.makeText(this,"注册成功！",Toast.LENGTH_SHORT).show();
        showProgress(false);
        goLogin();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onUsernameExistedEvent(UsernameExistedEvent usernameExistedEvent) {
        showProgress(false);
        setEmailError(R.string.username_existed_error);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
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
