package com.liyuaninc.liyuan.ftc_season.season2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.ftc_season.season_xml_setting.save;

public class season_main_2016 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_main_2016);
        TextView view = (TextView)findViewById(R.id.viewtest);
        ImageButton data = (ImageButton)findViewById(R.id.data);
        
    }
}
