package com.liyuaninc.liyuan.Login;

import android.os.AsyncTask;

import com.liyuaninc.liyuan.Login.Event.CancelledEvent;
import com.liyuaninc.liyuan.Login.Event.PasswordErrorEvent;
import com.liyuaninc.liyuan.Login.Event.SuccessEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by candy on 11/05/2017.
 */

public class LoginModelImp implements LoginModel {

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
                //Simulate network access

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential: FAKE_CREDENTIAL){
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mUsername)){
                    //return if password matches
                   return pieces[1].equals(mPassword);
                }
            }

            return false;
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
}
