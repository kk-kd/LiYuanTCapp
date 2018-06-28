package com.liyuaninc.liyuantcapp.activities.splash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.liyuaninc.liyuantcapp.R;
import com.liyuaninc.liyuantcapp.mvp.login.LoginActivity;

public class Splash extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 3000;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 设置状态栏透明!!!!记得在setContentView之前

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_splash);
     /*   VideoView videoView = (VideoView)this.findViewById(R.id.splashview);
        String uri = "android.resource://" +getPackageName() + "/" + R.raw.splash;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.start();*/

            handler = new Handler();
            // 延迟SPLASH_DISPLAY_LENGHT时间然后跳转到MainActivity
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Splash.this, LoginActivity.class);
                    startActivity(intent);
                    Splash.this.finish();}
            }, SPLASH_DISPLAY_LENGHT);

        }
    }}