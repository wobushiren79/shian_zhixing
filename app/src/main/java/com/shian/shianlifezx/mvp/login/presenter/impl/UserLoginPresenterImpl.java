package com.shian.shianlifezx.mvp.login.presenter.impl;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginBean;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.mvp.login.bean.UserLoginConfig;
import com.shian.shianlifezx.mvp.login.model.IUserLoginModel;
import com.shian.shianlifezx.mvp.login.model.impl.UserLoginModelImpl;
import com.shian.shianlifezx.mvp.login.presenter.IUserLoginPresenter;
import com.shian.shianlifezx.mvp.login.view.IUserLoginView;

/**
 * Created by zm.
 */

public class UserLoginPresenterImpl implements IUserLoginPresenter {

    IUserLoginView userLoginView;
    IUserLoginModel userLoginModel;

    public UserLoginPresenterImpl(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        userLoginModel = new UserLoginModelImpl();
    }



    @Override
    public void loginSystem() {
        SystemLoginBean params = new SystemLoginBean();
        params.setUserName(userLoginView.getUserName());
        params.setUserPwd(userLoginView.getPassWord());
        userLoginModel.loginSystem(userLoginView.getContext(), params, new OnGetDataListener<SystemLoginResultBean>() {
            @Override
            public void getDataSuccess(SystemLoginResultBean result) {
                userLoginView.loginSystemSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                userLoginView.loginSystemFail(msg);
            }
        });
    }

    @Override
    public void saveLoginConfig() {
        UserLoginConfig loginConfig = new UserLoginConfig();
        loginConfig.setUserName(userLoginView.getUserName());
        loginConfig.setPassWord(userLoginView.getPassWord());
        loginConfig.setAutoLogin(userLoginView.getIsAutoLogin());
        loginConfig.setKeepAccount(userLoginView.getIsKeepAccount());
        userLoginModel.saveLoginConfig(userLoginView.getContext(), loginConfig);
    }

    @Override
    public void getLoginConfig() {
        UserLoginConfig loginConfig = userLoginModel.getLoginConfig(userLoginView.getContext());
        if (loginConfig.isKeepAccount()) {
            userLoginView.setUserName(loginConfig.getUserName());
            userLoginView.setPassWord(loginConfig.getPassWord());
            userLoginView.setIsAutoLogin(loginConfig.isAutoLogin());
            userLoginView.setIsKeepAccount(loginConfig.isKeepAccount());
        }
        if (loginConfig.isAutoLogin()) {
            userLoginView.setUserName(loginConfig.getUserName());
            userLoginView.setPassWord(loginConfig.getPassWord());
            userLoginView.setIsAutoLogin(loginConfig.isKeepAccount());
            loginSystem();
        }
        if (!loginConfig.isAutoLogin())
            userLoginView.setLoginConfig();
    }
}
