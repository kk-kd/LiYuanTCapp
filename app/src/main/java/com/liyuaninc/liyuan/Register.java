package com.liyuaninc.liyuan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import db.HttpUtils;

public class Register extends AppCompatActivity {

    public EditText register_name;
    public EditText register_email;
    public EditText register_password;

    public Button   submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_name = (EditText) findViewById(R.id.register_name);
        register_email = (EditText) findViewById(R.id.register_email);
        register_password = (EditText) findViewById(R.id.register_password);


//        submit.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                HttpUtils util = new HttpUtils();
//                util.StoreData(register_name.getText().toString(),
//                                register_email.getText().toString(),
//                                register_password.getText().toString());
//            }
//        });
//

    }
}
