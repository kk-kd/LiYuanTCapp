package com.liyuaninc.liyuan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.liyuaninc.liyuan.apkupdate.UpdateVersionController;
import com.liyuaninc.liyuan.help.view;

public class alltest extends AppCompatActivity implements View.OnClickListener {

    private UpdateVersionController controller = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alltest);

        findViewById(R.id.force_update).setOnClickListener(this);
        findViewById(R.id.normal_update).setOnClickListener(this);
        if (null == controller) {
            controller = UpdateVersionController.getInstance(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal_update:
                controller.normalCheckUpdateInfo();
                break;
            case R.id.force_update:
                controller.forceCheckUpdateInfo();
                break;
            default:
                break;
        }
    }

}