package com.liyuaninc.liyuantcapp.Login;

import android.util.Log;


import com.liyuaninc.liyuantcapp.Login.Event.CancelledEvent;
import com.liyuaninc.liyuantcapp.Login.Event.SuccessEvent;
import com.liyuaninc.liyuantcapp.db.Finalnet;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;



/**
 * Created by candy on 11/05/2017.
 */

public class LoginModelImp implements LoginModel {
    Calendar c;
    String API;

    @Override
    public void login(String username, String password) {
        //call login task
        Userlogin(username,password);
    }

    /**
     * User login
     * Connect to the server
     * @param username
     * @param password
     */

    private void Userlogin(final String username, final String password) {
        try {
            c = Calendar.getInstance();
            API = APIPrep(c);

            new Thread() {
                public void run() {
                    Finalnet finalnet = new Finalnet();

                    final String theparam = "&umail=" + username + "&upwd=" + password;
                    String result = finalnet.sendPost(API, theparam);
                    Log.d("!!!!!!!!!!!!!!!!!!!!!!",result);

                    switch (result) {
                        case "0\n":
                            EventBus.getDefault().post(new SuccessEvent());
                            Log.d("Result State:", "Success");
                            break;
//                    case ??:
//                        EventBus.getDefault().post(new UsernameExistedEvent());
//                        break;
                        default:
                            EventBus.getDefault().post(new CancelledEvent());
                            Log.d("the result",result);
                            Log.d("Result State:", "Cancelled");
                            break;
                    }
                }
            }.start();

        } catch (Exception e){
            EventBus.getDefault().post(new CancelledEvent());

        }
    }

    private String APIPrep(Calendar calendar){
        String time = String.valueOf(calendar.get(Calendar.YEAR)) + String.valueOf(calendar.get(Calendar.MONTH)) + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        final String API="http://api.webhack.cn/login/token/liyuan"+time;
        return API;
    }

}
