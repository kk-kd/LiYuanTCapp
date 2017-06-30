package com.liyuaninc.liyuan.Login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.liyuaninc.liyuan.Login.Event.CancelledEvent;
import com.liyuaninc.liyuan.Login.Event.PasswordErrorEvent;
import com.liyuaninc.liyuan.Login.Event.SuccessEvent;
import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.Register.RegisterActivity;
import com.liyuaninc.liyuan.RetrivePassword.RetrivePasswordActivity;

import com.liyuaninc.liyuan.spinmenu.MainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter loginPresenter;

    @BindView(R.id.username) EditText mUsernameView;
    @BindView(R.id.userpassword) EditText mPasswordView;
    public CheckBox mCheckBox;
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImp(this);
    }

    private void rememberPassword() {
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    //TODO: record the password in system storage
                }
            }
        });

    }
    /**
     * Go to RegisterActivity  when the register button is pressed
     */
    @OnClick(R.id.register)
    @Override
    public void goRegister(){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    //TODO: Write the activity
    @OnClick(R.id.forgetPassword)
    @Override
    public void forgetPassword() {
        Intent intent = new Intent(LoginActivity.this, RetrivePasswordActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Attempt to login when the login button is pressed
     * If there are errors, the errors are presented and no login will be made
     */
    @OnClick(R.id.login)
    public void attemptLogin(){
        //Reset errors
        mUsernameView.setError(null);
        mPasswordView.setError(null);

        //store values
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();

        showLoginAnimation(true);

        loginPresenter.validCredentials(username,password);
    }

    public void showLoginAnimation(boolean show){
        if(show) {
            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setTitle("正在检票...");
            progressDialog.setIcon(R.drawable.rarcher);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        else{
            progressDialog.dismiss();
        }
    }
    /**
     * The animation that shows the progress bar when attempt to login
     * @param show whether the progress bar should be showed
     */

//    @Override
//    public void showProgress(final boolean show) {
//        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
//
//        mProgressView.setVisibility(show? View.VISIBLE: View.GONE);
//        mProgressView.animate().setDuration(shortAnimTime).alpha(show? 1:0).setListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                mProgressView.setVisibility(show? View.VISIBLE: View.GONE);
//            }
//        });
//    }

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
    @Override
    public void onSuccessEvent(SuccessEvent successEvent) {
        showLoginAnimation(false);
        Toast.makeText(LoginActivity.this,"welcome back ",Toast.LENGTH_SHORT).show();
        goUserActivity();
    }

    /**
     * Display password error message
     * @param passwordErrorEvent eventbus:Event.PasswordErrorEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onPasswrodErrorEvent(PasswordErrorEvent passwordErrorEvent) {
        showLoginAnimation(false);
        setPasswordError(R.string.password_incorrect_error);
    }

    /**
     * @param cancelledEvent eventbus:Event.CancelledEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onCancelledEvent(CancelledEvent cancelledEvent) {
        showLoginAnimation(false);
    }

    @Override
    public void goUserActivity() {
        Toast.makeText(this,"知道密码是rarcher你很棒棒哦",Toast.LENGTH_SHORT);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
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
