package com.liyuaninc.liyuan.settings;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settextground = (Button)findViewById(R.id.changetoasttextcolor);
        tosmsetting = (ImageButton)findViewById(R.id.tosmsetting);

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
    }
}
