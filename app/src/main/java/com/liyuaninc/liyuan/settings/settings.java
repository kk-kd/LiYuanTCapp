package com.liyuaninc.liyuan.settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.toast_styles.TabToast;

public class settings extends AppCompatActivity {

    ImageButton tosmsetting;
    Button settextground;
    Button rarcehr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settextground = (Button)findViewById(R.id.changetoasttextcolor);
        tosmsetting = (ImageButton)findViewById(R.id.tosmsetting);
        rarcehr = (Button)findViewById(R.id.rarcherstart);

        settextground.setOnClickListener(new View.OnClickListener() {
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

        rarcehr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this,com.liyuaninc.liyuan.settings.rarcher.rarcherstart.class);
                startActivity(intent);
            }
        });


    }
}
