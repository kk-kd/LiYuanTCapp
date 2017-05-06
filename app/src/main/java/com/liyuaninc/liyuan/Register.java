package com.liyuaninc.liyuan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import db.HttpUtils;
import db.NetTool;
import db.finalnet;

import static com.liyuaninc.liyuan.R.id.cancel_action;
import static com.liyuaninc.liyuan.R.id.imageView;
import static db.finalnet.sendGet;

public class Register extends AppCompatActivity {

    public EditText register_name;
    public EditText register_email;
    public EditText register_password;
    public Button   submit;
    private static Calendar c = Calendar.getInstance();
    private boolean intentl=true;

    public static final int UPDATE_TEXT = 1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //API prepare
        String time = String.valueOf(c.get(Calendar.YEAR)) + String.valueOf(c.get(Calendar.MONTH)) + String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        final String API="http://api.webhack.cn/reg/token/liyuan"+time;
        register_name = (EditText) findViewById(R.id.register_name);
        register_email = (EditText) findViewById(R.id.register_email);
        register_password = (EditText) findViewById(R.id.register_password);
        submit=(Button)findViewById(R.id.button_submit);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        //这儿是耗时操作，完成之后更新UI；
                        finalnet finalnet = new finalnet();

                        String username = register_name.getText().toString();
                        String useremail = register_email.getText().toString();
                        String userpassword = register_password.getText().toString();

                        final String theparam="uname="+username+"&upwd="+userpassword+"&umail="+useremail;
                        String result = finalnet.sendPost(API,theparam);
                        Log.d("HttpUtils",result);
                        Log.d("theparam",theparam);
                        switch (result){
                            case "ok":intentl=true;
                                break;
                        }
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                //更新UI
                                if (intentl==true){
                                    Intent intent =new Intent(Register.this,user.class);
                                    startActivity(intent);
                                    Toast.makeText(Register.this,"注册成功",Toast.LENGTH_SHORT).show();
                                    intentl=false;
                                    finish();}
                                else {
                                    Toast.makeText(Register.this,"注册失败",Toast.LENGTH_SHORT).show();
                                }
                            }

                        });
                    }
                }.start();

            }
        });

    }
}
