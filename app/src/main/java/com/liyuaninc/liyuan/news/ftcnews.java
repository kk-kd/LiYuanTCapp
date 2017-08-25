package com.liyuaninc.liyuan.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.liyuaninc.liyuan.R;

public class ftcnews extends AppCompatActivity {
    private ImageButton go2016;
    private ImageButton go2017;
    private ImageButton sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftcnews);
        go2016 = (ImageButton)findViewById(R.id.go2016);
        go2017 = (ImageButton)findViewById(R.id.go2017);
        sp1 = (ImageButton)findViewById(R.id.tosp1);
        go2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ftcnews.this,com.liyuaninc.liyuan.ftc_season.season2016.season_main_2016.class);
                startActivity(intent);
            }
        });
        go2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ftcnews.this,com.liyuaninc.liyuan.ftc_season.season2017.season_main_2017.class);
                startActivity(intent);
            }
        });
        sp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
