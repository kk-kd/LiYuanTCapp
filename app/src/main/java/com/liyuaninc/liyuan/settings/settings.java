package com.liyuaninc.liyuan.settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.toast_styles.TabToast;

public class settings extends AppCompatActivity {

    ImageButton tosmsetting;
    Button setbackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setbackground = (Button)findViewById(R.id.changebackground);
        tosmsetting = (ImageButton)findViewById(R.id.tosmsetting);

        setbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
TabToast.makeText(settings.this,"hello");
            }
        });

        tosmsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
