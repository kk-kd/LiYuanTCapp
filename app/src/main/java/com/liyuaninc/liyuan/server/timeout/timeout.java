package com.liyuaninc.liyuan.server.timeout;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class timeout extends Service {
    public timeout() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("timeout","create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("timeout","start");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("timeout","destroy");
    }

}
