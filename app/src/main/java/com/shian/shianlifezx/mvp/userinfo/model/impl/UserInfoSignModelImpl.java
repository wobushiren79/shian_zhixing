package com.shian.shianlifezx.mvp.userinfo.model.impl;

import android.content.Context;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoSignBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoSignResultBean;
import com.shian.shianlifezx.mvp.userinfo.model.IUserInfoSignModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

import okhttp3.Request;

/**
 * Created by zm.
 */

public class UserInfoSignModelImpl implements IUserInfoSignModel {
    @Override
    public void userInfoSign(Context context, UserInfoSignBean params, final OnGetDataListener listener) {
        MHttpManagerFactory.getSystemManager().userInfoSign(context, params, new HttpResponseHandler<UserInfoSignResultBean>() {

            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(UserInfoSignResultBean result) {
                listener.getDataSuccess(result);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }

        });
    }
}
