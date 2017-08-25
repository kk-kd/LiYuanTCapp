package com.liyuaninc.liyuan.spinmenu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.liyuaninc.liyuan.Login.LoginActivity;
import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.alltest;
import com.liyuaninc.liyuan.apkupdate.UpdateVersionController;
import com.liyuaninc.liyuan.others.Developer_application;
import com.liyuaninc.liyuan.set.set;
import com.liyuaninc.liyuan.toast_styles.TabToast;
import com.liyuaninc.liyuan.toast_styles.TabToastAccess;

import static com.liyuaninc.liyuan.R.id.controller;
import static com.liyuaninc.liyuan.R.id.fill;
import static com.liyuaninc.liyuan.R.id.toast_test;

/**
 *
 */
public class Fragment5 extends Fragment {

    LinearLayout linearLayout;
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
        View view = inflater.inflate(R.layout.hgz_set_page_layout, container, false);
         linearLayout=  (LinearLayout)view.findViewById(R.id.f5);

        return view;

    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),set.class);
                startActivity(intent);
            }
        });
    }

    public static Fragment5 newInstance() {
        Fragment5 fragment5 = new Fragment5();
        return fragment5;
    }
}

