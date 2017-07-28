package com.liyuaninc.liyuan.Login;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter loginPresenter;

    @BindView(R.id.username) EditText mUsernameView;
    @BindView(R.id.userpassword) EditText mPasswordView;
    public CheckBox mCheckBox;
    public ProgressDialog progressDialog;

    String usernamestring;
    String passwordstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        ButterKnife.bind(this);
        mCheckBox=(CheckBox)findViewById(R.id.remainLogin);
        Boolean ischeck=false;
        String checkable=load("checkable");
        if (checkable.equals("ok"))
        {ischeck=true;}
        else ischeck=false;
        String account = load("account");
        String password = load("password");
        if (ischeck){
            //remember all
            mUsernameView.setText(account);
            mPasswordView.setText(password);
            mCheckBox.setChecked(true);
        }


        loginPresenter = new LoginPresenterImp(this);
    }

    private void rememberPassword() {

        if (mCheckBox.isChecked()){
            //TODO: record the password in system storage
            Save("ok","checkable");
            String username = mUsernameView.getText().toString();
            String password = mPasswordView.getText().toString();
            Save(username,"account");
            Save(password,"password");
        }
        else {
            Save("f","checkable");
            Save("","account");
            Save("","password");
        }

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

        boolean showloginanimation=false;
        //store values
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("正在检票...");
        progressDialog.setIcon(R.drawable.rarcher);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
       if (password.length()<=6){
           showloginanimation=false;
           showLoginAnimation(showloginanimation,"lenghlow");
       }


        loginPresenter.validCredentials(username,password);
    }

    public void showLoginAnimation(boolean show,String a){

        if(show) {
           // Toast.makeText(LoginActivity.this,"well"+a,Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
        else {
            progressDialog.dismiss();
            final AlertDialog.Builder progressDialog1=new AlertDialog.Builder(LoginActivity.this);
            progressDialog1.setTitle("唔，你的戏票有问题呐");
            progressDialog1.setIcon(R.drawable.rarcher);
           /* progressDialog1.setView(getDrawable(R.raw.splash))*/
            progressDialog1.setMessage("仔细检查一下你的戏票吧");
            progressDialog1.setCancelable(false);
            progressDialog1.setPositiveButton("我再看看", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }}
            ); progressDialog1.show();
            Toast.makeText(LoginActivity.this,"bad"+a,Toast.LENGTH_SHORT).show();


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
        showLoginAnimation(true,"success");
        goUserActivity();
    }

    /**
     * Display password error message
     * @param passwordErrorEvent eventbus:Event.PasswordErrorEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onPasswrodErrorEvent(PasswordErrorEvent passwordErrorEvent) {
        showLoginAnimation(false,"password wrong");
        setPasswordError(R.string.password_incorrect_error);
    }

    /**
     * @param cancelledEvent eventbus:Event.CancelledEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onCancelledEvent(CancelledEvent cancelledEvent) {
        showLoginAnimation(true,"cancleedevent");
    }

    @Override
    public void goUserActivity() {
        rememberPassword();
        Toast.makeText(this,"知道密码是rarcher你很棒棒哦",Toast.LENGTH_SHORT).show();
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


    public void Save (String input, String theway){
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{out=openFileOutput(theway,MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(input);
            // Toast.makeText(this,theway+"设置成功",Toast.LENGTH_LONG).show();


        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (writer!=null){
                    writer.close();
                }

            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public String load(String theway){
        FileInputStream in =null;
        BufferedReader reader =null;
        StringBuilder content =new StringBuilder();
        try {
            in = openFileInput(theway);
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line=reader.readLine())!=null){
                content.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (reader!=null){
                try {
                    reader.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
