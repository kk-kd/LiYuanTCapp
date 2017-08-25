package com.liyuaninc.liyuan.spinmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.help.opmodehelp;
import com.liyuaninc.liyuan.helpview.help;

/*
 */
public class Fragment7 extends Fragment {
    RelativeLayout relativeLayout;
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
        View view = inflater.inflate(R.layout.frament_7, container, false);
        relativeLayout= (RelativeLayout)view.findViewById(R.id.f7);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),help.class);
                startActivity(intent);
            }
        });
    }

    public static Fragment7 newInstance() {
        Fragment7 fragment7 = new Fragment7();
        return fragment7;
    }
}

