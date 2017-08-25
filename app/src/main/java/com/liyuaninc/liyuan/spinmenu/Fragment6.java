package com.liyuaninc.liyuan.spinmenu;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;
import java.util.ArrayList;
import java.util.List;

import com.liyuaninc.liyuan.ftc_season.season2016.season_data;
import com.liyuaninc.liyuan.ftc_season.season_xml_setting.datalist;
import com.liyuaninc.liyuan.program.viewadapter;
import com.liyuaninc.liyuan.program.programadapter;
import com.liyuaninc.liyuan.share.share;

/**
 */
public class Fragment6 extends Fragment {

  LinearLayout  linearLayout;

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
         linearLayout= (LinearLayout)view.findViewById(R.id.f6);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),share.class);
                startActivity(intent);
            }
        });


}

    public static Fragment6 newInstance() {
        Fragment6 fragment6 = new Fragment6();
        return fragment6;
    }

}

