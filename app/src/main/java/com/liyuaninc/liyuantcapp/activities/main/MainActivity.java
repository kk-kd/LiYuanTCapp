package com.liyuaninc.liyuantcapp.activities.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.liyuaninc.liyuantcapp.R;
import com.liyuaninc.liyuantcapp.activities.main.fragments.Competition;
import com.liyuaninc.liyuantcapp.activities.main.fragments.Home;
import com.liyuaninc.liyuantcapp.activities.main.fragments.Setting;
import com.liyuaninc.liyuantcapp.activities.main.library.TabItem;
import com.liyuaninc.liyuantcapp.activities.main.library.XFragmentTabHost;

public class MainActivity extends AppCompatActivity {
    private XFragmentTabHost mTabHost;

    String[] mTabTitle = new String[] {"赛季", "发现", "设置"};
    int[] mImageResId = new int[] {R.drawable.rb_discovery, R.drawable.rb_home,
            R.drawable.rb_me};

    //这是你要用到的Fragment
    Class[] mFragClass = new Class[]{Competition.class, Home.class,
	    Setting.class};
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
