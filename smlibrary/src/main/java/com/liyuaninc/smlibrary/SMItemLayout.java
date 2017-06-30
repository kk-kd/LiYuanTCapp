package com.liyuaninc.smlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 *
 */
public class SMItemLayout extends LinearLayout{

    public SMItemLayout(Context context) {
        this(context, null);
    }

    public SMItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SMItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(VERTICAL);
    }
}
