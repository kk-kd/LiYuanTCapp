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
        canvas.drawText("hello world", 100, 600, rpaint);
    }
}
