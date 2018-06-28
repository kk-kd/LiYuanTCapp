package com.liyuaninc.liyuantcapp.mvp.register.impl;

import android.text.TextUtils;

import com.liyuaninc.liyuantcapp.R;
import com.liyuaninc.liyuantcapp.mvp.register.RegisterModel;
import com.liyuaninc.liyuantcapp.mvp.register.RegisterPresenter;
import com.liyuaninc.liyuantcapp.mvp.register.RegisterView;

/**
 * Created by candy on 16/05/2017.
 */

public class RegisterPresenterImp implements RegisterPresenter {

    private RegisterView registerView;
    private RegisterModel registerModel;

    public RegisterPresenterImp(RegisterView registerView){
        this.registerView = registerView;
        registerModel = new RegisterModelImp();
    }
    @Override
    public void validCredentials(String email, String password, String username) {
        if (TextUtils.isEmpty(email)){
            registerView.setEmailError(R.string.username_empty_error);
            return;
        }
        else if (!isEmailValid(email)){
            registerView.setEmailError(R.string.username_invalid_error);
            return;
        }

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)){
            registerView.setPasswordError(R.string.password_invalid_error);
            return;
        }

        registerView.showProgress(true);
        registerModel.register(email,password, username);


    }


    private boolean isEmailValid(String email){
        if (!email.contains("@")){ return false;}
        else {return true;}
    }

    private boolean isPasswordValid(String password){
        //TODO: change the logic
        return password.length() >= 6;
    }

    private boolean isUsernameValid(String username){
        //TODO change the logic
        return true;
    }


}
