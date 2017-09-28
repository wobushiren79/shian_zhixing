package com.shian.shianlifezx.mvp.userinfo.model.impl;

import android.content.Context;

import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoBean;
import com.shian.shianlifezx.mvp.userinfo.model.IUserInfoModel;


/**
 * Created by zm.
 */

public class UserInfoModelImpl implements IUserInfoModel {
    @Override
    public void getUserInfoData(Context context, UserInfoBean params, final OnGetDataListener<SystemLoginResultBean.UserObject> listener) {
//        MHttpManagerFactory.getFuneralManager().getUserInfoData(context, new HttpResponseHandler<UserInfoResultBean>() {
//
//            @Override
//            public void onStart(Request request, int id) {
//
//            }
//
//            @Override
//            public void onSuccess(final UserInfoResultBean result) {
//                listener.getDataSuccess(result);
//            }
//
//            @Override
//            public void onError(String message) {
//                listener.getDataFail(message);
//            }
//        });
        if (AppContansts.systemLoginInfo != null && AppContansts.systemLoginInfo.getUserObj() != null) {
            listener.getDataSuccess(AppContansts.systemLoginInfo.getUserObj());
        } else {
            listener.getDataFail("获取个人资料失败");
        }
    }
}
