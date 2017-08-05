package com.liyuaninc.liyuan.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.toast_styles.TabToast;

public class toast_test extends AppCompatActivity {
    private static long firstTime;

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_test);
        rg = (RadioGroup) findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TabToast.makeText(toast_test.this, "选中了" + checkedId);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (firstTime + 2000 > System.currentTimeMillis()) {
            finish();
        } else {
            TabToast.makeText(toast_test.this, "再按一次退出app");
        }
        firstTime = System.currentTimeMillis();
    }
}
