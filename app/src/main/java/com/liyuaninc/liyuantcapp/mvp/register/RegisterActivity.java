package com.liyuaninc.liyuantcapp.mvp.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.liyuaninc.liyuantcapp.R;
import com.liyuaninc.liyuantcapp.mvp.login.LoginActivity;
import com.liyuaninc.liyuantcapp.mvp.register.event.CancelledEvent;
import com.liyuaninc.liyuantcapp.mvp.register.event.SuccessEvent;
import com.liyuaninc.liyuantcapp.mvp.register.event.UsernameExistedEvent;
import com.liyuaninc.liyuantcapp.mvp.register.impl.RegisterPresenterImp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private RegisterPresenter registerPresenter;
    boolean isExit;
    private  ProgressDialog progressDialog;
    @BindView(R.id.register_email) EditText mEmailView;
    @BindView(R.id.register_name) EditText mUsernameView;
    @BindView(R.id.register_password) EditText mPasswordView;
    // @BindView(R.id.register_progress) View mProgressView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 设置状态栏透明!!!!记得在setContentView之前

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
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
        showdialog();

        registerPresenter.validCredentials(email, password, username);

    }

    private void showdialog()
    {
        progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("注册中");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
    @Override
    public void showProgress(final boolean show) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        // mProgressView.setVisibility(show? View.VISIBLE: View.GONE);
        //  mProgressView.animate().setDuration(shortAnimTime).alpha(show? 1:0).setListener(new AnimatorListenerAdapter() {
        //  @Override
        //     public void onAnimationEnd(Animator animation) {
        //          // mProgressView.setVisibility(show? View.VISIBLE: View.GONE);
        //      }
        //   });
    }

    @Override
    public void setEmailError(int messageResId) {
        progressDialog.cancel();
        mEmailView.setError(getString(messageResId));
        mEmailView.requestFocus();
    }

    @Override
    public void setPasswordError(int messageResId) {
        progressDialog.cancel();
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
        progressDialog.cancel();
        Log.d("register","success");
        showProgress(false);
        goLogin();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onUsernameExistedEvent(UsernameExistedEvent usernameExistedEvent) {
        showProgress(false);
        progressDialog.cancel();
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
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
    public void exit(){
        if (!isExit) {
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            isExit = false;
        }

    };

}

