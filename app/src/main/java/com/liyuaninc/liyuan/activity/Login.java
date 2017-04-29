package com.liyuaninc.liyuan.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.liyuaninc.liyuan.R;

public class Login extends AppCompatActivity {

    private ImageButton login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (ImageButton)findViewById(R.id.tomain);

        //进入注册界面
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
            }
        });





    }
}
