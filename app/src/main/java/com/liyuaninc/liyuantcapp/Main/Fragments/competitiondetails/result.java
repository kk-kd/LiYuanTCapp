package com.liyuaninc.liyuantcapp.Main.Fragments.competitiondetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.liyuaninc.liyuantcapp.R;
import com.liyuaninc.liyuantcapp.localdatabase.information;

import org.litepal.crud.DataSupport;

import java.util.List;


public class result extends AppCompatActivity {


    String title;
    String context;
    TextView titles;
    TextView textView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = (TextView)findViewById(R.id.detailsinfo);
        back = (Button)findViewById(R.id.tocompetation);
        titles = (TextView)findViewById(R.id.nowpositon);

        Intent intent = getIntent();
        int positon = intent.getIntExtra("position",-1);
        String stay = intent.getStringExtra("tag");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 服务器查询信息后放入string
        if (titles!=null&&context!=null)
        {
            titles.setText(title);
            textView.setText(context);
        }
        else {
            Toast.makeText(result.this,"联系树状设计图失败，请稍后重新绘制",Toast.LENGTH_SHORT).show();}
    }


    //select the data in net database
    private void selectdata(int position,String tag)
    {
        String sql = "";
        //把查询结果放入textview

    }
}
