package com.liyuaninc.liyuan.spinmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.help.opmodehelp;

public class Fragment2 extends Fragment {
    private ImageButton go2016;
    private ImageButton go2017;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        go2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),com.liyuaninc.liyuan.ftc_season.season2016.season_main_2016.class);
                startActivity(intent);
            }
        });
        go2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),com.liyuaninc.liyuan.ftc_season.season2017.season_main_2017.class);
                startActivity(intent);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_2, container, false);
        go2016 = (ImageButton)view.findViewById(R.id.go2016);
        go2017 = (ImageButton)view.findViewById(R.id.go2017);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static Fragment2 newInstance() {
        Fragment2 fragment2 = new Fragment2();
        return fragment2;
    }
}
