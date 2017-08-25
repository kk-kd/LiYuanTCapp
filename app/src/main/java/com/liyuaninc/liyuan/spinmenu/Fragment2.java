package com.liyuaninc.liyuan.spinmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.help.opmodehelp;
import com.liyuaninc.liyuan.news.ftcnews;

public class Fragment2 extends Fragment {
   private RelativeLayout relativeLayout;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      relativeLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getActivity(),ftcnews.class);
              startActivity(intent);
          }
      });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_2, container, false);
        relativeLayout = (RelativeLayout)view.findViewById(R.id.f2);
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
