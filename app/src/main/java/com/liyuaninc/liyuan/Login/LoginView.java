package com.liyuaninc.liyuan.Login;

import com.liyuaninc.liyuan.Login.Event.CancelledEvent;
import com.liyuaninc.liyuan.Login.Event.PasswordErrorEvent;
import com.liyuaninc.liyuan.Login.Event.SuccessEvent;

/**
 * Created by candy on 11/05/2017.
 */

public interface LoginView {

    void showProgress(boolean showProgress);

    void setUsernameError(int messageResId);
    void setPasswordError(int messageResId);

    void goRegister();
    void goUserActivity();

    void onPasswrodErrorEvent(PasswordErrorEvent passwordErrorEvent);
    void onCancelledEvent(CancelledEvent cancelledEvent);
    void onSuccessEvent(SuccessEvent successEvent);
}
