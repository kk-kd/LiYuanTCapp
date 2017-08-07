package com.liyuaninc.liyuan.program;

import com.liyuaninc.liyuan.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/7/30.
 */

public class viewadapter {
    private String name;
    private int imageid;

    public viewadapter(String name, int imageID)
    {
        this.name = name;
        this.imageid = imageID;
    }
    public String getname()
    {
        return name;
    }
    public int getImageid()
    {
        return imageid;
    }
}


