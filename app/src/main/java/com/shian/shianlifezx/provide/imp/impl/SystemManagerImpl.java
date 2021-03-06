package com.shian.shianlifezx.provide.imp.impl;

import android.content.Context;
import android.util.Log;


import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.mapapi.CustomDialog;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginBean;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginOutBean;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginOutResultBean;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.mvp.userinfo.bean.ChangePassWordSMSBean;
import com.shian.shianlifezx.mvp.userinfo.bean.ChangePassWordSMSResultBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralListBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralListResultBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralResultBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoSignBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoSignResultBean;
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
    private CustomDialog customDialog;

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
    public void loginOutSystem(Context context, SystemLoginOutBean params, HttpResponseHandler<SystemLoginOutResultBean> handler) {
        requestPost(context, "app_logout", SystemLoginOutResultBean.class, params, handler);
    }

    @Override
    public void loginStoreSystem(final Context context, String loginKey, HttpResponseHandler handler) {
        String storeUrl = AppContansts.Login_Store_Url + "?" + loginKey;
        loginSubSystem(context, storeUrl, handler);
    }

    @Override
    public void loginOrderCenterSystem(Context context, String loginKey, HttpResponseHandler handler) {
        String storeUrl = AppContansts.Login_OrderCenter_Url + "?" + loginKey;
        loginSubSystem(context, storeUrl, handler);
    }

    @Override
    public void loginCemeterySystem(Context context, String loginKey, HttpResponseHandler handler) {
        String cemeteryUrl = AppContansts.Login_Cemetery_Url + "?" + loginKey;
        loginSubSystem(context, cemeteryUrl, handler);
    }

    @Override
    public void userInfoSign(Context context, UserInfoSignBean params, HttpResponseHandler<UserInfoSignResultBean> handler) {
        requestPost(context, "api/credit/checkin", UserInfoSignResultBean.class, params, handler, true);
    }

    @Override
    public void getUserInfoIntegral(Context context, UserInfoIntegralBean params, HttpResponseHandler<UserInfoIntegralResultBean> handler) {
        requestPost(context, "api/credit/getCredit", UserInfoIntegralResultBean.class, params, handler);
    }

    @Override
    public void getUserInfoListIntegral(Context context, UserInfoIntegralListBean params, HttpResponseHandler<UserInfoIntegralListResultBean> handler) {
        requestPost(context, "api/credit/queryUserCreditLogsForPage", UserInfoIntegralListResultBean.class, params, handler);
    }

    @Override
    public void changePassWordSMS(Context context, ChangePassWordSMSBean params, HttpResponseHandler<ChangePassWordSMSResultBean> handler) {
        requestPost(context, "api/usersInfo/forgetKeys", ChangePassWordSMSResultBean.class, params, handler, true);
    }

    private void loginSubSystem(final Context context, String loginUrl, final HttpResponseHandler handler) {
        if (customDialog == null || !customDialog.isShowing()) {
            customDialog = new CustomDialog(context);
            customDialog.show();
        }
        Log.v("tag", "loginUrl:" + loginUrl);
        GetBuilder getBuilder = OkHttpUtils.get();
        getBuilder.url(loginUrl);
        getBuilder.addHeader("client-Type", "wechatapp");
        RequestCall requestCall = getBuilder.build();
        requestCall.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                ToastUtils.show(context, e.getMessage());
                customDialog.cancel();
                if (customDialog != null)
                    customDialog.cancel();
                handler.onError(e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.v("tag", "storeResponse:" + response);
                if (customDialog != null)
                    customDialog.cancel();
                handler.onSuccess(response);
            }
        });
    }


}
