package com.liyuaninc.liyuan.Login;

/**
 * Created by candy on 11/05/2017.
 */

public interface LoginModel {

    interface OnLoginFinishedListener{

        void onCancelded();

        void onPasswordError();

        void onSucess();
    }

    void login (String username, String password, OnLoginFinishedListener listener);
}
