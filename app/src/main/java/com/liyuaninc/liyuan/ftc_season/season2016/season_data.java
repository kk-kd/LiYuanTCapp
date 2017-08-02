package com.liyuaninc.liyuan.ftc_season.season2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.liyuaninc.liyuan.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class season_data extends AppCompatActivity {
    private List<datalist> datalists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_data);
        final TextView view = (TextView)findViewById(R.id.viewtest);
        final ImageButton data = (ImageButton)findViewById(R.id.data);
        final ImageButton search = (ImageButton)findViewById(R.id.search);
        final ImageButton hanhua = (ImageButton)findViewById(R.id.hanhua);
        ListView list = (ListView) findViewById(R.id.datalist);
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for(int i=0;i<30;i++)
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "This is Title.....");
            map.put("ItemText", "This is text.....");
            mylist.add(map);
        }
        //生成适配器，数组===》ListItem
        SimpleAdapter mSchedule = new SimpleAdapter(this, //没什么解释
                mylist,//数据来源
                R.layout.datalist,//ListItem的XML实
                //动态数组与ListItem对应的子项
                new String[] {"ItemTitle", "ItemText"},
                //ListItem的XML文件里面的两个TextView ID
                new int[] {R.id.ItemTitle,R.id.ItemText});
        //添加并且显示
        list.setAdapter(mSchedule);
        data.setImageResource(R.drawable.rb_home_click);
        search.setImageResource(R.drawable.rb_discovery);
        hanhua.setImageResource(R.drawable.rb_bbs);
    }
}