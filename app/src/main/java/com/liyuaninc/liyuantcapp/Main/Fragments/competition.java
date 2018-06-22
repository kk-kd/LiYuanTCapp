package com.liyuaninc.liyuantcapp.Main.Fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ExpandableListView;
import android.widget.Toast;

import com.liyuaninc.liyuantcapp.Main.Fragments.competationbean.GroupBean;

import com.liyuaninc.liyuantcapp.Main.Fragments.competationbean.ItemBean;
import com.liyuaninc.liyuantcapp.Main.Fragments.competationbean.season_Adapter;
import com.liyuaninc.liyuantcapp.R;

import java.util.ArrayList;
import java.util.List;


public class competition extends Fragment {
    ArrayList<GroupBean> groupList ; //存储部门数据
    ArrayList<List> childList ; //存储装有人员信息的List




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //填充数据
        initData();

        View view = inflater.inflate(R.layout.fragment_competition, container, false);
        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.view_exlist);
        //new一个适配器，就是之前我们创建的适配器，并且填入参数
        season_Adapter adapter = new season_Adapter(getContext(),
                R.layout.season_group,//我们之前创建的布局
                R.layout.season_child, //我们之前创建的布局
                groupList, //刚刚创建的List对象
                childList); //刚刚创建的List对象

        //设置适配器，传入刚刚new的adapter适配的对象
        expandableListView.setAdapter(adapter);


        //设置子项的点击操作
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view,
                                        int parentPos, int childPos, long l) {
              switch (parentPos){
                  case 0://2018赛季
                      switch (childPos)
                      {
                          case 0:
                              break;
                          case 1:
                              break;
                          case 2:
                              break;
                      }
                      break;
                  case 1://2019赛季
                      switch (childPos)
                      {
                          case 0:
                              break;
                          case 1:
                              break;
                          case 2:
                              break;
                      }
                      break;
              }
                return true;
            }
        });

        return view;


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
