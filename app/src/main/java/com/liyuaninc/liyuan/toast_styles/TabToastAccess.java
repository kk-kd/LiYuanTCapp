package com.liyuaninc.liyuan.toast_styles;

import android.util.Log;

public class TabToastAccess {
    /**
     * Toast字体大小
     */
    private static  float DEFAULT_TEXT_SIZE = 14;
    /**
     * Toast字体颜色
     */
    private  int DEFAULT_TEXT_COLOR =0xff800080;
    /**
     * Toast背景颜色
     */
    private static  int DEFAULT_BG_COLOR = 0xff000000;
    /**
     * Toast的高度(单位dp)
     */
    private static  float DEFAULT_TOAST_HEIGHT = 50.0f;

   private int color;
    public void setcolor(String colorname)
    {
        if (colorname =="RED")
        {
            DEFAULT_TEXT_COLOR = 0xffB0082;
            Log.d("color","red");
        }
        else
        {
            DEFAULT_TEXT_COLOR = 0xffffffff;
            Log.d("color","black");
        }
    }
    public int getcolor()
    {
        return DEFAULT_TEXT_COLOR;
    }
}
