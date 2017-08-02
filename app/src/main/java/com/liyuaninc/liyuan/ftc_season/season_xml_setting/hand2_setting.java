package com.liyuaninc.liyuan.ftc_season.season_xml_setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.liyuaninc.liyuan.R;

/**
 * Created by Administrator on 2017/8/2.
 */

public class hand2_setting extends LinearLayout {
    public hand2_setting(Context context,  AttributeSet attrs) {
        super(context, attrs);
       LayoutInflater.from(context).inflate(R.layout.season_head2,this);

        ImageButton back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }
}
