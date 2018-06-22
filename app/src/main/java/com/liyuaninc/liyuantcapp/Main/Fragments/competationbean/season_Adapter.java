package com.liyuaninc.liyuantcapp.Main.Fragments.competationbean;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liyuaninc.liyuantcapp.R;

import java.util.List;


/**
 * Created by Administrator on 2018/6/22.
 */

public class season_Adapter implements ExpandableListAdapter {
    List<GroupBean> groupList ; //父级列表数据
    List<List> childrenList; //子级列表数据，装载ItemList
    Context context ;//应用上下文

    int grouplayout ; //父级列表布局
    int childrenLayout ; //子级列表布局


    /**
     * 构造方法
     * @param groupList 父级数据
     * @param childrenList 子级数据
     */
    public season_Adapter(Context context ,
                       int grouplayoutId , int childrenLayoutId,
                       List<GroupBean> groupList , List<List> childrenList) {
        this.context = context.getApplicationContext();
        this.grouplayout = grouplayoutId;
        this.childrenLayout = childrenLayoutId;

        this.groupList = groupList;
        this.childrenList = childrenList;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    /**
     * 读取父级数据条数
     * @return 返回父级数据的大小，也就是有多少个部门
     */
    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    /**
     * 读取子级数据条数
     * @param groupPosition 指针，表示当前正在显示的第X条父级数据
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {

        List<ItemBean> itemList = childrenList.get(groupPosition);

        return itemList.size();
    }

    /**
     * 读取group数据
     * @param groupPosition
     * @return
     */
    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    /**
     * 读取item数据
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        List<ItemBean> itemList = childrenList.get(groupPosition);
        return itemList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        //加载Group布局
        View view ;
        if (convertView == null) {
            //convertView是布局的缓存，如果缓存为空的话，就加载布局到view
            view = LayoutInflater.from(context).inflate(grouplayout, parent, false);
        } else {
            //如果convert不为空，说明有缓存，直接把缓存布局赋值给view
            view = convertView;
        }

        //读取groupBean对象，也就是部门数据
        GroupBean groupBean = (GroupBean) getGroup(groupPosition);

        //为group布局中的TextView设置数据，先读取布局中的TextView
        TextView textView = (TextView) view.findViewById(R.id.view_title);
        //为TextView设置text，这里就填我们读取到的groupBean对象中的部门名称变量
        textView.setText(groupBean.getTitle());
        //设置头像
        ImageView imageView = (ImageView)view.findViewById(R.id.touxiang);
        switch (groupPosition)
        {
            case 0: imageView.setImageResource(R.drawable.ftc2017);
                break;
            case 1:imageView.setImageResource(R.drawable.ftc);
        }

        //设置完成，把view返回给ExpandableList
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        //加载Group布局
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(childrenLayout, parent, false);
        } else {
            view = convertView;
        }

        ItemBean itemBean = (ItemBean) getChild(groupPosition, childPosition);
        TextView textView = (TextView) view.findViewById(R.id.view_content);
        textView.setText(itemBean.getContent());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }
}
