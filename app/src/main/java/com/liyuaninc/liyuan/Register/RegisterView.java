package com.liyuaninc.liyuan.Register;

import com.liyuaninc.liyuan.Login.Event.CancelledEvent;
import com.liyuaninc.liyuan.Login.Event.SuccessEvent;
import com.liyuaninc.liyuan.Register.Event.UsernameExistedEvent;

/**
 * Created by candy on 15/05/2017.
 */

public interface RegisterView {

    void showProgress(boolean show);

    void setEmailError(int messageResId);
    void setPasswordError(int messageResId);

    void attemptRegister();

    void goLogin();

    void onSuccessEvent(SuccessEvent successEvent);
    void onCancelledEvent(CancelledEvent cancelledEvent);
    void onUsernameExistedEvent(UsernameExistedEvent usernameExistedEvent);
}
