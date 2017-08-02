package com.liyuaninc.liyuan.spinmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liyuaninc.liyuan.R;

public class Fragment1 extends Fragment {
    private TextView update;
    String updatenews="2017/4/28 梨园start\n" +
            "2017.7.31\n" +
            "1.修复了碎片返回主活动后，主活动退出会复原碎片的问题\n" +
            "2.添加了二次返回才推出程序的功能\n" +
            "3.加入了历史更新功能\n"+
            "2017.8.2\n" +
            "1.完成赛季信息模块\n" +
            "2.对数据模块进行了第一次编写\n"

            ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.frament_1, container, false);
        return  view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        update=(TextView)getView().findViewById(R.id.update);
        update.setText(updatenews);

    }



    public static Fragment1 newInstance() {
        Fragment1 fragment1 = new Fragment1();
        return fragment1;
    }
}
