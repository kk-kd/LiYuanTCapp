package com.liyuaninc.liyuan.ftc_season.season_xml_setting;

/**
 * Created by Administrator on 2017/8/2.
 */

public class datalist {
    private String name;
    private int imageid;

    public datalist(String name, int imageID)
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

