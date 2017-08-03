package com.liyuaninc.liyuan.ftc_season.season2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.ftc_season.season_xml_setting.dataadapter;
import com.liyuaninc.liyuan.ftc_season.season_xml_setting.datalist;

import java.util.ArrayList;
import java.util.List;

public class SDK extends AppCompatActivity {
    private List<datalist> sdklist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdk);
        final TextView view = (TextView)findViewById(R.id.viewtest);
        final ImageButton data = (ImageButton)findViewById(R.id.data);
        final ImageButton search = (ImageButton)findViewById(R.id.search);
        final ImageButton hanhua = (ImageButton)findViewById(R.id.hanhua);
        data.setImageResource(R.drawable.rb_home);
        search.setImageResource(R.drawable.rb_discovery);
        hanhua.setImageResource(R.drawable.rb_bbs_click);
        TextView nowway = (TextView)findViewById(R.id.nowway);
        nowway.setText("SDK汉化发布");
        initdata();
        dataadapter dataadapter = new dataadapter(SDK.this,R.layout.datalist,sdklist);
        ListView listView = (ListView)findViewById(R.id.hanhualist);
        listView.setAdapter(dataadapter);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SDK.this,season_main_2016.class);
                startActivity(intent);
                finish();
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*data.setImageResource(R.drawable.rb_home_click);
                search.setImageResource(R.drawable.rb_discovery);
                hanhua.setImageResource(R.drawable.rb_bbs);
                view.setText("data");*/
                Intent intent = new Intent(SDK.this,season_data.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void initdata()
    {
        datalist news = new datalist("SDK 2.x版本【2016——2017】",R.drawable.rarcher);
        sdklist.add(news);
        datalist guize = new datalist("SDK 3.x版本【2017——2018】",R.drawable.rarcher);
        sdklist.add(guize);

    }
}
