package com.liyuaninc.liyuan.ftc_season.season_xml_setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liyuaninc.liyuan.Login.Event.CancelledEvent;
import com.liyuaninc.liyuan.Login.Event.SuccessEvent;
import com.liyuaninc.liyuan.R;

import org.greenrobot.eventbus.EventBus;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import db.Finalnet;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by Administrator on 2017/8/2.
 */

public class hand1_setting extends LinearLayout {

    public hand1_setting(Context context,  AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.season_head,this);
        final ImageButton data = (ImageButton)findViewById(R.id.data);
        final ImageButton search = (ImageButton)findViewById(R.id.search);
        final ImageButton hanhua = (ImageButton)findViewById(R.id.hanhua);
        data.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setImageResource(R.drawable.rb_home_click);
                search.setImageResource(R.drawable.rb_discovery);
                hanhua.setImageResource(R.drawable.rb_bbs);
            }
        });

    }
}
