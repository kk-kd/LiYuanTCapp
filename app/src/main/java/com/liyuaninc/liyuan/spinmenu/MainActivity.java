package com.liyuaninc.liyuan.spinmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.liyuaninc.smlibrary.OnSpinMenuStateChangeListener;
import com.liyuaninc.smlibrary.SpinMenu;
import com.liyuaninc.liyuan.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SpinMenu spinMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinMenu = (SpinMenu) findViewById(R.id.spin_menu);

        // 设置页面标题
        List<String> hintStrList = new ArrayList<>();
        hintStrList.add("糖果看戏");
        hintStrList.add("海牛看戏");
        hintStrList.add("Rarcher看戏");
        hintStrList.add("ricky看戏");
        hintStrList.add("杏儿看戏");
        hintStrList.add("李白白看戏");
        hintStrList.add("help");
        hintStrList.add("setting" );

        spinMenu.setHintTextStrList(hintStrList);
        spinMenu.setHintTextColor(Color.parseColor("#FFFFFF"));
        spinMenu.setHintTextSize(14);

        // 设置启动手势开启菜单
        spinMenu.setEnableGesture(true);

        // 设置页面适配器
        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(Fragment1.newInstance());
        fragmentList.add(Fragment2.newInstance());
        fragmentList.add(Fragment3.newInstance());
        fragmentList.add(Fragment4.newInstance());
        fragmentList.add(Fragment5.newInstance());
        fragmentList.add(Fragment6.newInstance());
        fragmentList.add(Fragment7.newInstance());
        fragmentList.add(Fragment8.newInstance());
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        spinMenu.setFragmentAdapter(fragmentPagerAdapter);

        // 设置菜单状态改变时的监听器
        spinMenu.setOnSpinMenuStateChangeListener(new OnSpinMenuStateChangeListener() {
            @Override
            public void onMenuOpened() {
               // Toast.makeText(MainActivity.this, "乖乖站好！！♂", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMenuClosed() {
               // Toast.makeText(MainActivity.this, "唔，来畏吾皇？", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
