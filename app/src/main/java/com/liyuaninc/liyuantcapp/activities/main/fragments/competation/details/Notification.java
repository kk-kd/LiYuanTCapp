package com.liyuaninc.liyuantcapp.activities.main.fragments.competation.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liyuaninc.liyuantcapp.R;

import org.litepal.LitePal;

public class Notification extends AppCompatActivity {

    Button back;
    TextView textView;
    String flag;
    String informations="";
    private String[] data2018 = { "北京（北京理工大学）", "重庆（重庆大学）", "上海（上海美国学校）", "西安（西安电子科技大学）",
            "南京（东南大学）", "深圳（深圳宝安科技馆）", "郑州（郑州大学）", "广州（华南理工大学）", "上海（上海师范大学）"};
    private String[] data2019={"抱歉，组委会暂未公布2019年比赛地点"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Intent intent = getIntent();
        flag = intent .getStringExtra("flag");
        LitePal.getDatabase();
        //local database




        textView = (TextView)findViewById(R.id.noticeinfo);
        back = (Button)findViewById(R.id.back);

        ListView listView = (ListView) findViewById(R.id.notificationinfo);

        switch (flag)
        {
            case "2018notice":
	            ArrayAdapter<String> adapter2018 = new ArrayAdapter<>(Notification.this, android.R.layout.simple_list_item_1,
		            data2018);
                listView.setAdapter(adapter2018);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                    Toast.makeText(Notification.this, data2018[position], Toast.LENGTH_SHORT).show();
	                    //get Information from net db

	                    Intent intentf = new Intent(Notification.this, Result.class);
                        intentf.putExtra("position",data2018[position]);
                        intentf.putExtra("tag",flag);
                        startActivity(intentf);

                    }
                });
                textView.setText("请选择地区（2017--2018）");
                break;
            case "2019notice":
	            ArrayAdapter<String> adapter2019 = new ArrayAdapter<>(Notification.this, android.R.layout.simple_list_item_1,
		            data2019);
                listView.setAdapter(adapter2019);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                    Toast.makeText(Notification.this, data2019[position], Toast.LENGTH_SHORT).show();
	                    Intent intente = new Intent(Notification.this, Result.class);
                        intente.putExtra("position",data2019[position]);
                        intente.putExtra("tag",flag);
                        startActivity(intente);
                    }
                });
                textView.setText("请选择地区（2018--2019）");
                break;
            case "2018team":
	            ArrayAdapter<String> adapter2018t = new ArrayAdapter<>(Notification.this, android.R.layout
		                                                                                      .simple_list_item_1, data2018);
                listView.setAdapter(adapter2018t);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                    Toast.makeText(Notification.this, data2018[position], Toast.LENGTH_SHORT).show();
	                    Intent intentd = new Intent(Notification.this, Result.class);
                        intentd.putExtra("position",data2018[position]);
                        intentd.putExtra("tag",flag);
                        startActivity(intentd);
                    }
                });
                textView.setText("请选择地区（2017--2018）");
                break;
            case "2019team":
	            ArrayAdapter<String> adapter2019t = new ArrayAdapter<>(Notification.this, android.R.layout.simple_list_item_1, data2019);
                listView.setAdapter(adapter2019t);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                    Toast.makeText(Notification.this, data2019[position], Toast.LENGTH_SHORT).show();
	                    Intent intentc = new Intent(Notification.this, Result.class);
                        intentc.putExtra("position",data2019[position]);
                        intentc.putExtra("tag",flag);
                        startActivity(intentc);
                    }
                });
                textView.setText("请选择地区（2018--2019）");
                break;
            case "2018up":
	            ArrayAdapter<String> adapter2018u = new ArrayAdapter<>(Notification.this, android.R.layout.simple_list_item_1, data2018);
                listView.setAdapter(adapter2018u);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                    Toast.makeText(Notification.this, data2018[position], Toast.LENGTH_SHORT).show();

	                    Intent intentb = new Intent(Notification.this, Result.class);
                        intentb.putExtra("position",data2018[position]);
                        intentb.putExtra("tag",flag);
                        startActivity(intentb);
                    }
                });
                textView.setText("请选择地区（2017--2018）");
                break;
            case "2019up":
	            ArrayAdapter<String> adapter2019u = new ArrayAdapter<>(Notification.this, android.R.layout.simple_list_item_1, data2019);
                listView.setAdapter(adapter2019u);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                    Toast.makeText(Notification.this, data2019[position], Toast.LENGTH_SHORT).show();

	                    Intent intenta = new Intent(Notification.this, Result.class);
                        intenta.putExtra("position",data2019[position]);
                        intenta.putExtra("tag",flag);
                        startActivity(intenta);
                    }
                });
                textView.setText("请选择地区（2018--2019）");
                break;
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }




}
