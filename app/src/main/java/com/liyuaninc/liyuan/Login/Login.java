package com.liyuaninc.liyuan.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.Register;

import java.util.Calendar;

import db.finalnet;

@Deprecated
public class Login extends AppCompatActivity {

    private EditText uname;
    private EditText upass;
    private ImageButton login;
    private ImageButton register;
    private static Calendar c = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);

//        login = (ImageButton)findViewById(R.id.tomain);
        register = (ImageButton)findViewById(R.id.register) ;
        uname =(EditText)findViewById(R.id.username);
        upass =(EditText)findViewById(R.id.userpassword);

        String time = String.valueOf(c.get(Calendar.YEAR)) + String.valueOf(c.get(Calendar.MONTH)) + String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        final String API="http://api.webhack.cn/login/token/liyuan"+time;

        //进入注册界面
       register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      finalnet finalnet = new finalnet();

                      String username = uname.getText().toString();
                      String userpassword = upass.getText().toString();
                      final String theparam="uname="+username+"&upwd="+userpassword+"&umail="+"2553263392@qq.com";
                      String result = finalnet.sendGet(API,theparam);
                      Log.d("HttpUtils",result);
                      Log.d("theparam",theparam);
                  }
              }).start();
            }
        });

    }
}
