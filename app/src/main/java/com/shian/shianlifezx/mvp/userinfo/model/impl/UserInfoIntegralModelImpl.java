package com.shian.shianlifezx.mvp.userinfo.model.impl;

import android.content.Context;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralResultBean;
import com.shian.shianlifezx.mvp.userinfo.model.IUserInfoIntegralModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class UserInfoIntegralModelImpl implements IUserInfoIntegralModel {
    @Override
    public void getUserInfoIntegral(Context context, UserInfoIntegralBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getSystemManager().getUserInfoIntegral(context, params, new HttpResponseHandler<UserInfoIntegralResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(UserInfoIntegralResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
