package com.liyuaninc.liyuan.program;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.ftc_season.season_xml_setting.datalist;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */
public class programadapter extends ArrayAdapter<viewadapter> {
    //TODO:这里是共享代码的模块，也需要服务器
    private int resourceID;
    public programadapter(Context contex, int textViewResourcedID,List<viewadapter> object){
        super(contex, textViewResourcedID, object);
        resourceID = textViewResourcedID;
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        viewadapter viewadapter = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.dataimage);
        TextView textView = (TextView) view.findViewById(R.id.dataname);
        imageView.setImageResource(viewadapter.getImageid());
        textView.setText(viewadapter.getname());
        return view;
    }
}
