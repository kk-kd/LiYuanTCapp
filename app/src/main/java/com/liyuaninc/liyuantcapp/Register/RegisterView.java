package com.liyuaninc.liyuantcapp.Register;


import com.liyuaninc.liyuantcapp.Register.Event.CancelledEvent;
import com.liyuaninc.liyuantcapp.Register.Event.SuccessEvent;
import com.liyuaninc.liyuantcapp.Register.Event.UsernameExistedEvent;

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
