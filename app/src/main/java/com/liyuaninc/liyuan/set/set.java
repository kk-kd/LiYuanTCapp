package com.liyuaninc.liyuan.set;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.liyuaninc.liyuan.Login.LoginActivity;
import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.alltest;
import com.liyuaninc.liyuan.apkupdate.UpdateVersionController;
import com.liyuaninc.liyuan.others.Developer_application;
import com.liyuaninc.liyuan.toast_styles.TabToast;

public class set extends AppCompatActivity {
    private Button update;
    private Button clean;
    private Button test_update;
    private Button test_toast;
    private Button about;
    private Button news;
    private Button logout;
    private int count=0;
    private ImageButton sp;
    private UpdateVersionController controller = null;
    private Button setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        update = (Button)findViewById(R.id.updatecheck);
        clean = (Button)findViewById(R.id.cleanphone);
        test_update = (Button)findViewById(R.id.test_uptade);
        test_toast = (Button)findViewById(R.id.test_toast);
        about = (Button)findViewById(R.id.about);
        logout = (Button)findViewById(R.id.logout);
        news = (Button)findViewById(R.id.news);
        setting = (Button)findViewById(R.id.setting);
        sp = (ImageButton)findViewById(R.id.tosp5);

        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (null == controller) {
            controller = UpdateVersionController.getInstance(set.this);
        }

        //用户要清除缓存，用户最大咯
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabToast.makeText(set.this,"成功");
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.normalCheckUpdateInfo();
            }
        });

        test_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(set.this,com.liyuaninc.liyuan.test.toast_test.class);
                startActivity(intent);
            }
        });

        test_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(set.this,alltest.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(set.this, Developer_application.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(set.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(set.this);
                dialog.setTitle("更新");
                dialog.setCancelable(false);
                dialog.setMessage("修复了部分bug" );
                dialog.setPositiveButton("辣鸡Rarcher，看戏去了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(set.this,com.liyuaninc.liyuan.settings.settings.class);
                startActivity(intent);
            }
        });
    }
}
