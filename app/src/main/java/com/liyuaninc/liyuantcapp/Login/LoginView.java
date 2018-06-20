package com.liyuaninc.liyuantcapp.Login;

import com.liyuaninc.liyuantcapp.Login.Event.PasswordErrorEvent;
import com.liyuaninc.liyuantcapp.Login.Event.SuccessEvent;
import com.liyuaninc.liyuantcapp.Register.Event.CancelledEvent;



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
