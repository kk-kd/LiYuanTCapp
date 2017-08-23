package com.liyuaninc.liyuan.settings;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
       /* // 设置状态栏透明!!!!记得在setContentView之前

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }*/
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
