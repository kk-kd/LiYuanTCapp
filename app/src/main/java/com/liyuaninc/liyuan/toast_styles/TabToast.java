/*
 * Copyright (C) 2015 Chenenyu
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liyuaninc.liyuan.toast_styles;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义Toast,配合TabBar使用效果更加
 * <p>欢迎关注<a href="https://github.com/chenenyu">我的github</a></p>
 * Created by Cheney on 15/6/16.
 */
public class TabToast {

   public static TabToastAccess tabToastAccess = new TabToastAccess();

    /**
     * Toast字体大小
     */
    private static final float DEFAULT_TEXT_SIZE = 14;
    /**
     * Toast字体颜色
     */
    private static final int DEFAULT_TEXT_COLOR = 0xffffffff;
    /**
     * Toast背景颜色
     */
    private static final int DEFAULT_BG_COLOR = 0xff000000;
    /**
     * Toast的高度(单位dp)
     */
    private static final float DEFAULT_TOAST_HEIGHT = 50.0f;

    private static Context mContext;
    private volatile static TabToast mInstance;
    private static Toast mToast;
    private View layout;
    private TextView tv;

    public TabToast(Context context) {
        mContext = context;
    }

    /**
     * 单例模式
     * @param context 传入的上下文
     * @return TabToast实例
     */
    private static TabToast getInstance(Context context) {
        if (mInstance == null) {
            synchronized (TabToast.class) {
                if (mInstance == null) {
                    mInstance = new TabToast(context.getApplicationContext());
                }
            }
        }
        return mInstance;
    }

    /**
     * @param duration Toast.LENGTH_SHORT or Toast.LENGTH_LONG
     */
    private static void getToast(int duration) {
        if (mToast == null) {
            mToast = new Toast(mContext);
            mToast.setGravity(Gravity.BOTTOM, 0, 0);
            mToast.setDuration(duration == Toast.LENGTH_LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        }
    }

    public static void makeText(Context context, String text) {
        makeText(context, text, Toast.LENGTH_SHORT);
    }

    public static void makeText(Context context, String text, int duration) {
        getInstance(context);
        getToast(duration);
        if (mInstance.layout == null || mInstance.tv == null) {
            LinearLayout container = new LinearLayout(mContext);
            LinearLayout.LayoutParams rootParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            container.setLayoutParams(rootParams);
            container.setBackgroundColor(DEFAULT_BG_COLOR);
            container.setGravity(Gravity.CENTER);

            mInstance.tv = new TextView(mContext);
            LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(
                    getScreenWidth(mContext), dp2px(DEFAULT_TOAST_HEIGHT));
            mInstance.tv.setLayoutParams(tvParams);
            mInstance.tv.setPadding(dp2px(5), dp2px(2), dp2px(5), dp2px(2));
            mInstance.tv.setGravity(Gravity.CENTER);
            mInstance.tv.setTextColor(DEFAULT_TEXT_COLOR);
            mInstance.tv.setMaxLines(2);
            mInstance.tv.setEllipsize(TextUtils.TruncateAt.END);
            mInstance.tv.setBackgroundColor(DEFAULT_BG_COLOR);
            mInstance.tv.setTextSize(DEFAULT_TEXT_SIZE);

            container.addView(mInstance.tv);

            mInstance.layout = container;

            mToast.setView(mInstance.layout);
        }
        mInstance.tv.setText(text);
        String s = tabToastAccess.getcolor()+"";
        Log.d("Tabtoast get color",s);
        mToast.show();
    }

    /**
     * dp转px
     *
     * @param value dp
     * @return px
     */
    public static int dp2px(float value) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (value * scale + 0.5f);
    }

    /**
     * 获得屏幕宽度
     *
     * @param context Context
     * @return px
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        float density = outMetrics.density;
        return (int) (outMetrics.widthPixels * density);
    }

}
