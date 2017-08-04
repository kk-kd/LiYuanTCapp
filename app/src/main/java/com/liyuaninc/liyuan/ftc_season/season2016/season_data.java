package com.liyuaninc.liyuan.ftc_season.season2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.ftc_season.season_xml_setting.dataadapter;
import com.liyuaninc.liyuan.ftc_season.season_xml_setting.datalist;

import java.util.ArrayList;
import java.util.List;

public class season_data extends AppCompatActivity {
    private List<datalist> datalists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_season_data);

        final ImageButton data = (ImageButton)findViewById(R.id.data);
        final ImageButton search = (ImageButton)findViewById(R.id.search);
        final ImageButton hanhua = (ImageButton)findViewById(R.id.hanhua);
        TextView nowway = (TextView)findViewById(R.id.nowway);
        nowway.setText("赛季数据");
        initdata();
        dataadapter dataadapter = new dataadapter(season_data.this,R.layout.datalist,datalists);
        ListView listView = (ListView)findViewById(R.id.datalist);
        listView.setAdapter(dataadapter);


        data.setImageResource(R.drawable.rb_home_click);
        search.setImageResource(R.drawable.rb_discovery);
        hanhua.setImageResource(R.drawable.rb_bbs);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(season_data.this,season_main_2016.class);
                startActivity(intent);
                finish();
            }
        });
        hanhua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(season_data.this,SDK.class);
                startActivity(intent);
                finish();

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                datalist datalist = datalists.get(position);
                String nowposition = datalist.getname();
                switch (nowposition) {
                    case ("赛季通知"):
                        Toast.makeText(season_data.this,"通知",Toast.LENGTH_SHORT).show();
                        break;
                    case ("赛季规则"):Toast.makeText(season_data.this,"规则",Toast.LENGTH_SHORT).show();
                        break;
                    case ("得分排名"):Toast.makeText(season_data.this,"排名",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void initdata()
    {
        datalist news = new datalist("赛季通知",R.drawable.rarcher);
        datalists.add(news);
        datalist guize = new datalist("赛季规则",R.drawable.rarcher);
        datalists.add(guize);
        datalist paiming = new datalist("得分排名",R.drawable.rarcher);
        datalists.add(paiming);
    }
}