package com.liyuaninc.liyuantcapp.mvp.register;

import com.liyuaninc.liyuantcapp.mvp.register.event.CancelledEvent;
import com.liyuaninc.liyuantcapp.mvp.register.event.SuccessEvent;
import com.liyuaninc.liyuantcapp.mvp.register.event.UsernameExistedEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by candy on 15/05/2017.
 */

public interface RegisterView {

    void showProgress(boolean show);

    void setEmailError(int messageResId);
    void setPasswordError(int messageResId);

    void attemptRegister();

    void goLogin();



    @Subscribe(threadMode = ThreadMode.MAIN)
    void onSuccessEvent(SuccessEvent successEvent);

    @Subscribe(threadMode = ThreadMode.MAIN)
    void onUsernameExistedEvent(UsernameExistedEvent usernameExistedEvent);

    @Subscribe(threadMode = ThreadMode.MAIN)
    void onCancelledEvent(CancelledEvent cancelledEvent);
}
