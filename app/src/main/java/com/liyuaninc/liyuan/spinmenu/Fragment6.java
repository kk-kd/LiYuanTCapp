package com.liyuaninc.liyuan.spinmenu;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;
import java.util.ArrayList;
import java.util.List;

import com.liyuaninc.liyuan.ftc_season.season2016.season_data;
import com.liyuaninc.liyuan.ftc_season.season_xml_setting.datalist;
import com.liyuaninc.liyuan.program.viewadapter;
import com.liyuaninc.liyuan.program.programadapter;

/**
 */
public class Fragment6 extends Fragment {

    private Button write;
    private ListView listView;
    private List<viewadapter> datalists = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_6, container, false);
        initdata();
        programadapter programadapter = new programadapter(getContext(),R.layout.programlist,datalists);
        listView = (ListView)view.findViewById(R.id.listview);
        write = (Button)view.findViewById(R.id.writecode);
        listView.setAdapter(programadapter);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getContext(),com.liyuaninc.liyuan.writecode.writecode.class);
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
                        Toast.makeText(getContext(),"手动——脉轮",Toast.LENGTH_SHORT).show();
                        break;
                    case ("自动代码2.0"):Toast.makeText(getContext(),"自动代码2.0",Toast.LENGTH_SHORT).show();
                        break;
                    case ("自动代码1.0"):Toast.makeText(getContext(),"自动代码1.0",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

}

    public static Fragment6 newInstance() {
        Fragment6 fragment6 = new Fragment6();
        return fragment6;
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

