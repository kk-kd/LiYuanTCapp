package com.liyuaninc.liyuan.ftc_season.season2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.ftc_season.season_xml_setting.save;

public class season_main_2016 extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_main_2016);
        final TextView view = (TextView)findViewById(R.id.viewtest);
       final ImageButton data = (ImageButton)findViewById(R.id.data);
       final ImageButton search = (ImageButton)findViewById(R.id.search);
       final ImageButton hanhua = (ImageButton)findViewById(R.id.hanhua);
        TextView nowway = (TextView)findViewById(R.id.nowway);
        nowway.setText("发现");
        data.setImageResource(R.drawable.rb_home);
        search.setImageResource(R.drawable.rb_discovery_click);
        hanhua.setImageResource(R.drawable.rb_bbs);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*data.setImageResource(R.drawable.rb_home_click);
                search.setImageResource(R.drawable.rb_discovery);
                hanhua.setImageResource(R.drawable.rb_bbs);
                view.setText("data");*/
                Intent intent = new Intent(season_main_2016.this,season_data.class);
                startActivity(intent);
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setImageResource(R.drawable.rb_home);
                search.setImageResource(R.drawable.rb_discovery_click);
                hanhua.setImageResource(R.drawable.rb_bbs);
                view.setText("search");
            }
        });
        hanhua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(season_main_2016.this,SDK.class);
                startActivity(intent);
                finish();
            }
        });





    }
}
