package com.liyuaninc.liyuantcapp.Main;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.liyuaninc.liyuantcapp.Main.Fragments.competition;
import com.liyuaninc.liyuantcapp.Main.Fragments.home;
import com.liyuaninc.liyuantcapp.Main.Fragments.setting;
import com.liyuaninc.liyuantcapp.Main.library.TabItem;
import com.liyuaninc.liyuantcapp.Main.library.XFragmentTabHost;
import com.liyuaninc.liyuantcapp.R;

public class MainActivity extends AppCompatActivity {
    private XFragmentTabHost mTabHost;

    String[] mTabTitle = new String[] {"赛季", "发现", "设置"};
    int[] mImageResId = new int[] {R.drawable.rb_discovery, R.drawable.rb_home,
            R.drawable.rb_me};

    //这是你要用到的Fragment
    Class[] mFragClass = new Class[] {competition.class, home.class,
            setting.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_clip);
        initTabHost();
    }

    private void initTabHost() {
        //展开样式数组
        Drawable[] drawables = new Drawable[] { ContextCompat.getDrawable(this, R.drawable.rb_discovery_click),
                ContextCompat.getDrawable(this, R.drawable.rb_home_click),
                ContextCompat.getDrawable(this, R.drawable.rb_me_click),};

        mTabHost = (XFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.relate_tab_content);
        mTabHost.setTabMode(XFragmentTabHost.TabMode.ClipDrawable);

        for (int i = 0; i < mFragClass.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("FragKey", mTabTitle[i]);
            mTabHost.addTabItem(new TabItem(mTabTitle[i], drawables[i], mImageResId[i]),
                    mFragClass[i], bundle);
        }
    }
}
