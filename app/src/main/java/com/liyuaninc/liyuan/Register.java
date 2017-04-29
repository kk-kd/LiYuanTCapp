package com.liyuaninc.liyuan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        String year1=String.valueOf(year);
        String month1=String.valueOf(month);
        String day1=String.valueOf(day);
        String time=year1+month1+day1;

        register_name = (EditText) findViewById(R.id.register_name);
        register_email = (EditText) findViewById(R.id.register_email);
        register_password = (EditText) findViewById(R.id.register_password);
        submit=(Button)findViewById(R.id.button_submit);


        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              //  HttpUtils util = new HttpUtils();
               // util.AccessData(register_name.getText().toString(),
               //                 register_email.getText().toString(),
                //                register_password.getText().toString(),"REGISTER");
                new Thread(new Runnable(){ @Override public void run() {
                    finalnet finalnet = new finalnet();
                    finalnet.sendGet("http://api.webhack.cn/connect/token/liyuan20170429");
                }
                }).start();
            }
        });


    }
}
