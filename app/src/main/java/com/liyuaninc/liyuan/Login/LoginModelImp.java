package com.liyuaninc.liyuan.Login;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.liyuaninc.liyuan.Login.Event.CancelledEvent;
import com.liyuaninc.liyuan.Login.Event.PasswordErrorEvent;
import com.liyuaninc.liyuan.Login.Event.SuccessEvent;
import com.liyuaninc.liyuan.R;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

import db.Finalnet;

/**
 * Created by candy on 11/05/2017.
 */

public class LoginModelImp implements LoginModel {
    Calendar c;
    String API;

    /**
     * A fake rarcher login that needs to be modified later
     * TODO: remove after connecting to System
     */
    private static final String[] FAKE_CREDENTIAL = new String[] {"rarcher:rarcher"};


    @Override
    public void login(String username, String password) {
        //call login task
        new UserLoginTask(username, password).execute((Void) null);
    }


    /**
     * user login
     * TODO: contact Ricky to change the content
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean>{

        private final String mUsername;
        private final String mPassword;

        UserLoginTask(String username, String password){
            mUsername = username;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            //TODO: attempt authentition against a network service

            try{
                c = Calendar.getInstance();
                API = APIPrep(c);

                //start new thread and begin register
                new Thread(){
                    public void run(){
                        Finalnet finalnet = new Finalnet();

                        final String theparam="&umail="+mUsername+"&upwd="+mPassword;
                        String result = finalnet.sendPost(API,theparam);
                        switch (result){
                            case "ok":
                                EventBus.getDefault().post(new SuccessEvent());
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
                //Simulate network access

                Thread.sleep(200);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential: FAKE_CREDENTIAL)
            {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mUsername)){
                    //return if password matches
                   return pieces[1].equals(mPassword);
                }
            }

            return false;
        }
        @Override
        protected void onPreExecute(){
        }



        @Override
        protected void onPostExecute(final Boolean success) {
            if (success){
                EventBus.getDefault().post(new SuccessEvent());
            }
            else{
                EventBus.getDefault().post(new PasswordErrorEvent());
            }
        }

        @Override
        protected void onCancelled() {
            EventBus.getDefault().post(new CancelledEvent());
        }
    }
    private String APIPrep(Calendar calendar){
        String time = String.valueOf(calendar.get(Calendar.YEAR)) + String.valueOf(calendar.get(Calendar.MONTH)) + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        final String API="http://api.webhack.cn/login/token/liyuan"+time;
        return API;
    }

}
