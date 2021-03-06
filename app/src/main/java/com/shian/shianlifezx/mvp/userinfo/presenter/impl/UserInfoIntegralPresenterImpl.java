package com.shian.shianlifezx.mvp.userinfo.presenter.impl;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralResultBean;
import com.shian.shianlifezx.mvp.userinfo.model.IUserInfoIntegralModel;
import com.shian.shianlifezx.mvp.userinfo.model.impl.UserInfoIntegralModelImpl;
import com.shian.shianlifezx.mvp.userinfo.presenter.IUserInfoIntegralPresenter;
import com.shian.shianlifezx.mvp.userinfo.view.IUserInfoIntegralView;

/**
 * Created by zm.
 */

public class UserInfoIntegralPresenterImpl implements IUserInfoIntegralPresenter {
    private IUserInfoIntegralView userInfoIntegralView;
    private IUserInfoIntegralModel userInfoIntegralModel;

    public UserInfoIntegralPresenterImpl(IUserInfoIntegralView userInfoIntegralView) {
        this.userInfoIntegralView = userInfoIntegralView;
        userInfoIntegralModel = new UserInfoIntegralModelImpl();
    }

    @Override
    public void getUserInfoIntegral() {
        if (userInfoIntegralView == null) {
            userInfoIntegralView.showToast("数据错误");
            return;
        }

        UserInfoIntegralBean params = new UserInfoIntegralBean();
        userInfoIntegralModel.getUserInfoIntegral(userInfoIntegralView.getContext(), params, new OnGetDataListener<UserInfoIntegralResultBean>() {
            @Override
            public void getDataSuccess(UserInfoIntegralResultBean result) {
                userInfoIntegralView.getUserInfoIntegralSuccess(result);
                if (result.getUsableCredit() != null)
                    userInfoIntegralView.setUserInfoIntegral(result.getUsableCredit());
                if (result.getKeeps() != null)
                    userInfoIntegralView.setUserInfoContinuousDay(result.getKeeps());
                if (result.getCanCheckin() != null)
                    userInfoIntegralView.setUserInfoCanSign(result.getCanCheckin());
            }

            @Override
            public void getDataFail(String msg) {
                userInfoIntegralView.getUserInfoIntegralFail(msg);
            }
        });
    }
}
