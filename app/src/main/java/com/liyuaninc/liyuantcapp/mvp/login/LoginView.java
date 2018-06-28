package com.liyuaninc.liyuantcapp.mvp.login;

import com.liyuaninc.liyuantcapp.mvp.login.events.PasswordErrorEvent;
import com.liyuaninc.liyuantcapp.mvp.login.events.SuccessEvent;
import com.liyuaninc.liyuantcapp.mvp.register.event.CancelledEvent;



public interface LoginView {

//    void showProgress(boolean showProgress);

    void setUsernameError(int messageResId);
    void setPasswordError(int messageResId);

    void goRegister();
    void goUserActivity();

    void onPasswrodErrorEvent(PasswordErrorEvent passwordErrorEvent);
    void onCancelledEvent(CancelledEvent cancelledEvent);
    void onSuccessEvent(SuccessEvent successEvent);

    void forgetPassword();
}
