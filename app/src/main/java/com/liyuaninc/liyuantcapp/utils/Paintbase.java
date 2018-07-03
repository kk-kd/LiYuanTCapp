package com.liyuaninc.liyuantcapp.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class Paintbase extends View {
    public Paintbase(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas)
    {
        Paint rpaint = new Paint();
        rpaint.setStrokeWidth(80);
        rpaint.setAntiAlias(true);
        rpaint.setColor(Color.GREEN);
        rpaint.setStyle(Paint.Style.STROKE);;
        rpaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100,600,400,600,rpaint);
       rpaint.set(new Paint());
        rpaint.setColor(Color.BLUE);
        rpaint.setTextSize(30);
        Typeface typeFace = Typeface.defaultFromStyle(Typeface.BOLD);
        rpaint.setTypeface(typeFace);
        canvas.drawText("亲爱的，如果你看到这句话" ,100, 600, rpaint);
        canvas.drawLine(100,800,400,600,rpaint);
        canvas.drawText("那么表示Rarcher已经凉了" ,100, 650, rpaint);
        canvas.drawText("而且我知道有一根很丑的线" ,100, 700, rpaint);
        canvas.drawText("然而并不想修这个bug" ,100, 750, rpaint);
        canvas.drawText("只想放弃治疗，垃圾paint函数" ,100, 800, rpaint);
        canvas.drawText("这一堆都是用paint函数写的只想说一句mmp" ,100, 850, rpaint);
        canvas.drawText("再见这个世界T_T" ,100, 950, rpaint);
    }
}
