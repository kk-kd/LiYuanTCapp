package com.liyuaninc.liyuantcapp.Main.Fragments;


import android.app.Activity;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liyuaninc.liyuantcapp.Main.Fragments.settingpic.emptyactivity;
import com.liyuaninc.liyuantcapp.Main.MainActivity;
import com.liyuaninc.liyuantcapp.R;
import com.liyuaninc.liyuantcapp.aboutus.aboutus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class setting extends Fragment {

    private ImageView pic;
    private TextView down;
    private  TextView about;
    private  TextView setting;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        // Inflate the layout for this fragment
        down = (TextView) view.findViewById(R.id.downland);
        about = (TextView)view.findViewById(R.id.aboutus);
        pic = (ImageView)view.findViewById(R.id.picshow);
        setting = (TextView)view.findViewById(R.id.setting);
        Bitmap bitmap = getLoacalBitmap("/sdcard/LiYuan/Userspic/head_portrait.jpg"); //从本地取图片(在cdcard中获取)  //
        if (bitmap==null)
        {

        }
        else
            {
                pic .setImageBitmap(bitmap); //设置Bitmap
            }

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),emptyactivity.class);
                intent.putExtra("empty",2);
                startActivity(intent);
                MainActivity activity=(MainActivity)getActivity();
                activity.finish();
            }
        });
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),emptyactivity.class);
                intent.putExtra("empty",1);
                startActivity(intent);
                MainActivity activity=(MainActivity)getActivity();
                activity.finish();
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(getContext(),"树状图设计者正在施工呐",Toast.LENGTH_SHORT).show();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),aboutus.class);
                startActivity(intent);
            }
        });




        return view;
    }

    /**
     * 加载本地图片
     * @param url
     * @return
     */
    public static Bitmap getLoacalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);  ///把流转化为Bitmap图片

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
}}
