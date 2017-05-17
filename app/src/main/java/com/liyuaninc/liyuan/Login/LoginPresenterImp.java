package com.liyuaninc.liyuan.Login;

import android.text.TextUtils;

import com.liyuaninc.liyuan.R;

/**
 * Created by candy on 11/05/2017.
 */

public class LoginPresenterImp implements LoginPresenter{

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenterImp(LoginView loginView){
        this.loginView = loginView;
        this.loginModel = new LoginModelImp();
    }

    /**
     * Test if username and password is valid
     * @param username
     * @param password
     */
    @Override
    public void validCredentials(String username, String password) {
        //check for password validation
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)){
            loginView.setPasswordError(R.string.password_invalid_error);
            return;
        }

        //check for username validation
        if (TextUtils.isEmpty(username)){
            loginView.setUsernameError(R.string.username_empty_error);
            return;
        }
        else if (isUsernameValid(username)){
            loginView.setUsernameError(R.string.username_invalid_error);
            return;
        }

        loginView.showProgress(true);
        loginModel.login(username,password);


    }


    private boolean isUsernameValid(String username){
        //TODO: change the logic
        return true;
    }

    private boolean isPasswordValid(String password){
        //TODO: change the logic
        return password.length() >= 6;
    }
}
