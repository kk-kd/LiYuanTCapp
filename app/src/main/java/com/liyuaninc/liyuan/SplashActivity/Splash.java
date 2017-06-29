package com.liyuaninc.liyuan.SplashActivity;



 import android.app.Activity;
 import android.content.Intent;
 import android.net.Uri;
 import android.os.Bundle;
 import android.os.Environment;
 import android.os.Handler;
 import android.view.Window;
 import android.widget.MediaController;
 import android.widget.VideoView;

 import com.liyuaninc.liyuan.Login.LoginActivity;
 import com.liyuaninc.liyuan.R;


public class Splash extends Activity {
private VideoView videoView;
    private final int SPLASH_DISPLAY_LENGHT = 5000;
   private Handler handler;

   @Override
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               getWindow().requestFeature(Window.FEATURE_NO_TITLE);
               setContentView(R.layout.activity_splash);
       VideoView videoView = (VideoView)this.findViewById(R.id.splashview);
       String uri = "android.resource://" +getPackageName() + "/" + R.raw.splash;
       videoView.setVideoURI(Uri.parse(uri));
       videoView.start();



       handler = new Handler();
             // 延迟SPLASH_DISPLAY_LENGHT时间然后跳转到MainActivity
                handler.postDelayed(new Runnable() {

                @Override
            public void run() {
                         Intent intent = new Intent(Splash.this, LoginActivity.class);
                             startActivity(intent);
                              Splash.this.finish();
                         }
      }, SPLASH_DISPLAY_LENGHT);

         }
}