package com.liyuaninc.liyuan.Login;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.liyuaninc.liyuan.Login.Event.CancelledEvent;
import com.liyuaninc.liyuan.Login.Event.PasswordErrorEvent;
import com.liyuaninc.liyuan.Login.Event.SuccessEvent;
import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.Register.RegisterActivity;
import com.liyuaninc.liyuan.RetrivePassword.RetrivePasswordActivity;

import com.liyuaninc.liyuan.apkupdate.UpdateVersionController;
import com.liyuaninc.liyuan.server.timeout.timeout;
import com.liyuaninc.liyuan.spinmenu.MainActivity;
import com.liyuaninc.liyuan.toast_styles.TabToast;

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
import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{
    boolean isExit;
    private LoginPresenter loginPresenter;
    private UpdateVersionController controller = null;
    @BindView(R.id.username) EditText mUsernameView;
    @BindView(R.id.userpassword) EditText mPasswordView;
    public CheckBox mCheckBox;
    public ProgressDialog progressDialog;
    private String forgetemil;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // hide title

        if (Build.VERSION.SDK_INT >=21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            if (null == controller) {
                controller = UpdateVersionController.getInstance(this);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        ButterKnife.bind(this);
        mCheckBox=(CheckBox)findViewById(R.id.remainLogin);

        loadRemeberedPassword();

        loginPresenter = new LoginPresenterImp(this);


    }

    /**
     * Display remembered username and password
     */

    private void loadRemeberedPassword(){
        String stored = load("stored");

        if (stored.equals("true"))
        {
            String account = load("account");
            String password = load("password");
            mUsernameView.setText(account);
            mPasswordView.setText(password);
            mCheckBox.setChecked(true);
        }

    }

    private void starttimeout()
    {
        //开启计时服务
        Intent intent = new Intent(this,timeout.class);
        startService(intent);

    }

    private void stoptimeout()
    {
        //关闭计时服务
        Intent intent = new Intent(this,timeout.class);
        stopService(intent);
    }


    /**
     * This method will automatically record the username and password in the system storage if mCheckBox is checked
     *
     * In system storage:
     * "stored" will be "true" if contents are stored, "false" otherwise
     * "username" and "password" will be the stored username and password
     */
    private void rememberPassword() {

        if (mCheckBox.isChecked()){
            //Record the password in system storage
            String username = mUsernameView.getText().toString();
            String password = mPasswordView.getText().toString();

            Save("true","autologin");
            Save("true","stored");
            Save(username,"account");
            Save(password,"password");
        }
        else {
            Save("false","stored");
            Save("false","autologin");
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


    @OnClick(R.id.forgetPassword)
    @Override
    public void forgetPassword() {
        forgetdialog();
    }

    private void forgetdialog()
    {
        LayoutInflater inflater=getLayoutInflater();
        final View layout=inflater.inflate(R.layout.forgotdialog, (ViewGroup)findViewById(R.id.forgot));
        final EditText editText = (EditText)layout.findViewById(R.id.forgotemil);
        new AlertDialog.Builder(this).
                setTitle("忘记密码").
                setCancelable(false).
                setView(layout).
                setPositiveButton("完成", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        forgetemil=editText.getText().toString();
                        //TODO 连接数据库获取密码
                    }
                }).show();
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

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("正在检票...");
        progressDialog.setIcon(R.drawable.rarcher);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
     /*  if (password.length()<=6){
           showloginanimation=false;
           showLoginAnimation(showloginanimation,"lenghlow");
           Log.d("LoginActivity","lenghlow");

       }
    */

     /*
     *
     * 数据库没弄好的测试产品
     *
     * */
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();

        timeoutcheck();
        loginPresenter.validCredentials(username,password);
    }

    private void timeoutcheck(){

        if (count < 5) {
            count=count++;
        }
        else if (count>=5)
        {
            count=5;
            EventBus.getDefault().post(new CancelledEvent());
        }


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
            progressDialog1.setMessage("仔细检查一下你的戏票和检票口吧");
            progressDialog1.setCancelable(false);
            progressDialog1.setPositiveButton("我再看看", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            progressDialog1.show();
        }

        Log.d("login statue",a);
        //Toast.makeText(LoginActivity.this,"bad"+a,Toast.LENGTH_SHORT).show();
    }


    /**
     * Set error message if username is invalid
     *
     * @param messageResId Message needs to be displayed
     */
    @Override
    public void setUsernameError(int messageResId) {
        mUsernameView.setError(getString(messageResId));
        mUsernameView.requestFocus();

    }

    /**
     * Set error message if password is wrong or invalid
     *
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
    //
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
        showLoginAnimation(false,"canceledevent");
    }

    @Override
    public void goUserActivity() {
        rememberPassword();
        TabToast.makeText(LoginActivity.this,"知道密码是rarcher那你很棒棒哦");
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
            isExit = true;
            TabToast.makeText(getApplicationContext(), "再按一次就要和梨园说再见咯");
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);

        }
    }
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            //
            super.handleMessage(msg);
            isExit = false;
        }

    };

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
