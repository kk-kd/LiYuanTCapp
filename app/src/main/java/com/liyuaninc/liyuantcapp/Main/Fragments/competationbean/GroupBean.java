package com.liyuaninc.liyuantcapp.Main.Fragments.competationbean;

import android.media.Image;

/**
 * Created by Administrator on 2018/6/22.
 */

public class GroupBean {
    private String title ; //部门名称
    private int age;


    /**
     * @param title 父级名称
     */
   public GroupBean(String title) {
        this.title = title;
    }

    public void setImage(int age)
    {
        this.age = age;
    }
    //获取赛季名称
    public String getTitle() {
        return title;
    }

    //设置赛季名称
    public void setTitle(String title) {
        this.title = title;
    }

    public int getimage()
    {
        return age;
    }


}
