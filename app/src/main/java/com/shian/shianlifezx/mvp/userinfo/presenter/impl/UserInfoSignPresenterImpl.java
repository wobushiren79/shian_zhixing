package com.shian.shianlifezx.mvp.userinfo.presenter.impl;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoSignBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoSignResultBean;
import com.shian.shianlifezx.mvp.userinfo.model.IUserInfoSignModel;
import com.shian.shianlifezx.mvp.userinfo.model.impl.UserInfoSignModelImpl;
import com.shian.shianlifezx.mvp.userinfo.presenter.IUserInfoSignPresenter;
import com.shian.shianlifezx.mvp.userinfo.view.IUserInfoSignView;

/**
 * Created by zm.
 */

public class UserInfoSignPresenterImpl implements IUserInfoSignPresenter {
    private IUserInfoSignView userInfoSignView;
    private IUserInfoSignModel userInfoSignModel;

    public UserInfoSignPresenterImpl(IUserInfoSignView userInfoSignView) {
        this.userInfoSignView = userInfoSignView;
        userInfoSignModel = new UserInfoSignModelImpl();
    }

    @Override
    public void userInfoSign() {
        if (userInfoSignView.getContext() == null) {
            userInfoSignView.showToast("数据错误");
            return;
        }
        UserInfoSignBean params = new UserInfoSignBean();
        userInfoSignModel.userInfoSign(userInfoSignView.getContext(), params, new OnGetDataListener<UserInfoSignResultBean>() {
            @Override
            public void getDataSuccess(UserInfoSignResultBean result) {
                userInfoSignView.userInfoSignSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                userInfoSignView.userInfoSignFail(msg);
            }
        });
    }
}
