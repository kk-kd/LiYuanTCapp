package com.liyuaninc.liyuantcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.liyuaninc.liyuantcapp.Main.Fragments.competationbean.GroupBean;
import com.liyuaninc.liyuantcapp.Main.Fragments.competationbean.ItemBean;
import com.liyuaninc.liyuantcapp.Main.Fragments.competationbean.season_Adapter;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity {
    ArrayList<GroupBean> groupList ; //存储部门数据
    ArrayList<List> childList ; //存储装有人员信息的List


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initData();


        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.view_exlist1);
        //new一个适配器，就是之前我们创建的适配器，并且填入参数
        season_Adapter adapter = new season_Adapter(this,
                R.layout.season_group,//我们之前创建的布局
                R.layout.season_child, //我们之前创建的布局
                groupList, //刚刚创建的List对象
                childList); //刚刚创建的List对象

        //设置适配器，传入刚刚new的adapter适配的对象
        expandableListView.setAdapter(adapter);
    }
    public void initData() {
        //初始化变量
        groupList = new ArrayList();
        childList = new ArrayList();


        groupList.add(new GroupBean("2018赛季"));
        groupList.add(new GroupBean("2019赛季"));



        ArrayList xs = new ArrayList();
        xs.add(new ItemBean("地区赛通知"));
        xs.add(new ItemBean("参赛队伍"));
        xs.add(new ItemBean("晋级队伍"));
        childList.add(xs);


        ArrayList zg = new ArrayList();
        zg.add(new ItemBean("地区赛通知"));
        zg.add(new ItemBean("参赛队伍"));
        zg.add(new ItemBean("晋级队伍"));
        childList.add(zg);


    }

}
