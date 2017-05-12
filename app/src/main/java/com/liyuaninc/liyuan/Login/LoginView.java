package com.liyuaninc.liyuan.Login;

/**
 * Created by candy on 11/05/2017.
 */

public interface LoginView {

    void showProgress(boolean showProgress);

    void setUsernameError(int messageResId);

    void setPasswordError(int messageResId);
}
