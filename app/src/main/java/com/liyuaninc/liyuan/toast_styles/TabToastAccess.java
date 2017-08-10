package com.liyuaninc.liyuan.toast_styles;

import android.util.Log;
import android.widget.Toast;

import com.liyuaninc.liyuan.spinmenu.Fragment5;
import com.liyuaninc.liyuan.spinmenu.Fragment6;

public class TabToastAccess {
    /**
     * Toast字体大小
     */
    private static  float DEFAULT_TEXT_SIZE = 14;
    /**
     * Toast字体颜色
     */
    private  int DEFAULT_TEXT_COLOR;
    /**
     * Toast背景颜色
     */
    private static  int DEFAULT_BG_COLOR = 0xff000000;
    /**
     * Toast的高度(单位dp)
     */
    private static  float DEFAULT_TOAST_HEIGHT = 50.0f;
    int color=2;

    public void setcolor(String colorname)
    {
        if (colorname .equals("RED"))
        {
            DEFAULT_TEXT_COLOR = 0xffB0082;
            Log.d("color","red");
            this.color = 0xffB0082;
        }
        else
        {
            DEFAULT_TEXT_COLOR = 0xffffffff;
            Log.d("color","black");
           this.color = 0xffffffff;
        }

    }



    public int getcolor() {

        String s = color+"";
     Log.d("thecolor",s);
        return DEFAULT_TEXT_COLOR;
    }



}
