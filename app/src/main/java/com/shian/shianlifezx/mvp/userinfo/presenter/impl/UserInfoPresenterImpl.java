package com.shian.shianlifezx.mvp.userinfo.presenter.impl;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoBean;
import com.shian.shianlifezx.mvp.userinfo.model.IUserInfoModel;
import com.shian.shianlifezx.mvp.userinfo.model.impl.UserInfoModelImpl;
import com.shian.shianlifezx.mvp.userinfo.presenter.IUserInfoPresenter;
import com.shian.shianlifezx.mvp.userinfo.view.IUserInfoView;

/**
 * Created by zm.
 */

public class UserInfoPresenterImpl implements IUserInfoPresenter {
    IUserInfoModel userInfoModel;
    IUserInfoView userInfoView;


    public UserInfoPresenterImpl(IUserInfoView userInfoView) {
        this.userInfoView = userInfoView;
        userInfoModel = new UserInfoModelImpl();
    }

    @Override
    public void getUserInfoData() {
        UserInfoBean params = new UserInfoBean();
        userInfoModel.getUserInfoData(userInfoView.getContext(), params, new OnGetDataListener<SystemLoginResultBean.UserObject>() {
            @Override
            public void getDataSuccess(SystemLoginResultBean.UserObject result) {
//                userInfoView.ChangeHeadImage(AppContansts.OSSURL + result.getHeadImg());
                userInfoView.ChangeName(result.getName());
                userInfoView.ChangePhone(result.getPhone());
                userInfoView.ChangePoint("0");
            }

            @Override
            public void getDataFail(String msg) {

            }
        });
    }
}
