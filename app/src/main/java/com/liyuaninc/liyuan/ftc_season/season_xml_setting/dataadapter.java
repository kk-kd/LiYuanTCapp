package com.liyuaninc.liyuan.ftc_season.season_xml_setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.liyuaninc.liyuan.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */

public class dataadapter extends ArrayAdapter<datalist> {
    private int resourceID;
   public dataadapter(Context contex, int textViewResourcedID,List<datalist> object){
       super(contex, textViewResourcedID, object);
       resourceID = textViewResourcedID;
   }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        datalist datalist = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.dataimage);
        TextView textView = (TextView) view.findViewById(R.id.dataname);
        imageView.setImageResource(datalist.getImageid());
        textView.setText(datalist.getname());
        return view;
    }
}
