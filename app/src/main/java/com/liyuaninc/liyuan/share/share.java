package com.liyuaninc.liyuan.share;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.program.programadapter;
import com.liyuaninc.liyuan.program.viewadapter;

import java.util.ArrayList;
import java.util.List;

public class share extends AppCompatActivity {
    private Button write;
    private ListView listView;
    private List<viewadapter> datalists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initdata();
        programadapter programadapter = new programadapter(share.this,R.layout.programlist,datalists);
        listView = (ListView)findViewById(R.id.listview);
        write = (Button)findViewById(R.id.writecode);
        listView.setAdapter(programadapter);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(share.this,com.liyuaninc.liyuan.writecode.writecode2.class);
                startActivity(intent);
            }
        });
        listView .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewadapter viewadapter = datalists.get(position);
                String nowposition = viewadapter.getname();
                switch (nowposition) {
                    case ("手动——脉轮"):
                        Toast.makeText(share.this,"手动——脉轮",Toast.LENGTH_SHORT).show();
                        break;
                    case ("自动代码2.0"):Toast.makeText(share.this,"自动代码2.0",Toast.LENGTH_SHORT).show();
                        break;
                    case ("自动代码1.0"):Toast.makeText(share.this,"自动代码1.0",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }
    private void initdata()
    {
        viewadapter news = new viewadapter("手动——脉轮",R.drawable.ic_app_set_background_1);
        datalists.add(news);
        viewadapter guize = new viewadapter("自动代码2.0",R.drawable.ic_app_set_background_1);
        datalists.add(guize);
        viewadapter paiming = new viewadapter("自动代码1.0",R.drawable.ic_app_set_background_1);
        datalists.add(paiming);
        viewadapter a = new viewadapter("手动——脉轮",R.drawable.ic_app_set_background_1);
        datalists.add(a);
        viewadapter b = new viewadapter("自动代码2.0",R.drawable.ic_app_set_background_1);
        datalists.add(b);
        viewadapter c = new viewadapter("自动代码1.0",R.drawable.ic_app_set_background_1);
        datalists.add(c);
        viewadapter d = new viewadapter("手动——脉轮",R.drawable.ic_app_set_background_1);
        datalists.add(d);
        viewadapter e = new viewadapter("自动代码2.0",R.drawable.ic_app_set_background_1);
        datalists.add(guize);
        viewadapter f = new viewadapter("自动代码1.0",R.drawable.ic_app_set_background_1);
        datalists.add(paiming);
        viewadapter s = new viewadapter("手动——脉轮",R.drawable.ic_app_set_background_1);
        datalists.add(d);
        viewadapter q = new viewadapter("自动代码2.0",R.drawable.ic_app_set_background_1);
        datalists.add(guize);
        viewadapter k = new viewadapter("自动代码1.0",R.drawable.ic_app_set_background_1);
        datalists.add(paiming);
    }
}
