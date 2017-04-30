package com.liyuaninc.liyuan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import db.HttpUtils;
import db.NetTool;
import db.finalnet;

import static com.liyuaninc.liyuan.R.id.imageView;
import static db.finalnet.sendGet;

public class Register extends AppCompatActivity {

    public EditText register_name;
    public EditText register_email;
    public EditText register_password;
    public Button   submit;
    private static Calendar c = Calendar.getInstance();

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
                new Thread(new Runnable(){

                    @Override public void run() {
                    finalnet finalnet = new finalnet();

                    String username = register_name.getText().toString();
                    String useremail = register_email.getText().toString();
                    String userpassword = register_password.getText().toString();

                    final String theparam="uname="+username+"&upwd="+userpassword+"&umail="+useremail;
                    String result = finalnet.sendPost(API,theparam);

                    Log.d("HttpUtils",result);
                    Log.d("theparam",theparam);

                }
                }).start();

            }
        });

    }
}
