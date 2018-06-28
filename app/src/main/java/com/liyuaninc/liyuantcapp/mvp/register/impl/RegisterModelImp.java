package com.liyuaninc.liyuantcapp.mvp.register.impl;

import android.util.Log;

import com.liyuaninc.liyuantcapp.db.FinalNet;
import com.liyuaninc.liyuantcapp.mvp.register.RegisterModel;
import com.liyuaninc.liyuantcapp.mvp.register.event.CancelledEvent;
import com.liyuaninc.liyuantcapp.mvp.register.event.SuccessEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

/**
 * Created by candy on 16/05/2017.
 */

public class RegisterModelImp implements RegisterModel {

    Calendar c;
    String API;

    @Override
    public void register(String email, String password, String username) {
        if (!isExisted(email)){
            //attempt to register
            doRegister(email,password, username);

        }
        else{
            //TODO: show existed warning
        }
    }

    @Override
    public boolean isExisted(String email) {
        //TODO: check if existed
        return false;
    }


    private void doRegister(final String email, final String password, final String username){
        //TODO: register
        //refresh time and API
        c = Calendar.getInstance();
        API = APIPrep(c);

        //start new thread and begin register
        new Thread(){
            public void run(){
                FinalNet finalNet = new FinalNet();

                final String theparam="uname="+username+"&upwd="+password+"&umail="+email;
                String result = finalNet.sendPost(API, theparam);
                Log.d("result",result);
                switch (result){
                    case "ok\n":
                        EventBus.getDefault().post(new SuccessEvent());
                        Log.d("@@@@@@@@@!",result);
                        break;
                    //TODO: add UsernameExistedEvent
//                    case ??:
//                        EventBus.getDefault().post(new UsernameExistedEvent());
//                        break;
                    default:
                        EventBus.getDefault().post(new CancelledEvent());
                        break;
                }
            }

        }.start();


    }

    private String APIPrep(Calendar calendar){
        String time = String.valueOf(calendar.get(Calendar.YEAR)) + String.valueOf(calendar.get(Calendar.MONTH)) + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        final String API="http://api.webhack.cn/reg/token/liyuan"+time;
        return API;
    }


}
