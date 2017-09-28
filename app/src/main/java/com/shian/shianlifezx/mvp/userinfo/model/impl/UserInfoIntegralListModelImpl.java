package com.shian.shianlifezx.mvp.userinfo.model.impl;

import android.content.Context;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralListBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralListResultBean;
import com.shian.shianlifezx.mvp.userinfo.model.IUserInfoIntegralListModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class UserInfoIntegralListModelImpl implements IUserInfoIntegralListModel {

    @Override
    public void getIntegralList(Context context, UserInfoIntegralListBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getSystemManager().getUserInfoListIntegral(context, params, new HttpResponseHandler<UserInfoIntegralListResultBean>() {
            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(UserInfoIntegralListResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }
        });
    }
}
