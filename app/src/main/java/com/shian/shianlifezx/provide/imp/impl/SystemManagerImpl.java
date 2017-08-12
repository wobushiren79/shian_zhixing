package com.shian.shianlifezx.provide.imp.impl;

import android.content.Context;


import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginBean;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.provide.base.BaseManagerImpl;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.imp.SystemManager;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import okhttp3.Call;

/**
 * Created by zm.
 */

public class SystemManagerImpl extends BaseManagerImpl implements SystemManager {
    private static SystemManagerImpl manager;

    private SystemManagerImpl() {
        super();
        baseUrl = AppContansts.Login_BaseUrl;
    }


    public static SystemManagerImpl getInstance() {
        if (manager == null) {
            manager = new SystemManagerImpl();
        }
        return manager;
    }


    @Override
    public void loginSystem(Context context, SystemLoginBean params, HttpResponseHandler<SystemLoginResultBean> handler) {
        requestPost(context, "applogin", SystemLoginResultBean.class, params, handler);
    }

    @Override
    public void loginStoreSystem(final Context context, String loginKey) {
        String storeUrl = AppContansts.Login_Store_Url + "?" + loginKey;
        loginSubSystem(context, storeUrl);
    }


    private void loginSubSystem(final Context context, String storeUrl) {
        GetBuilder getBuilder = OkHttpUtils.get();
        getBuilder.url(storeUrl);
        getBuilder.addHeader("client-Type", "wechatapp");
        RequestCall requestCall = getBuilder.build();
        requestCall.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                ToastUtils.show(context, e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {

            }
        });
    }


}
