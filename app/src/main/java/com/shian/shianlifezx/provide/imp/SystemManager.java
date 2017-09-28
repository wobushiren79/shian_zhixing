package com.shian.shianlifezx.provide.imp;

import android.content.Context;

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
import com.shian.shianlifezx.provide.base.HttpResponseHandler;


/**
 * Created by zm.
 */

public interface SystemManager {

    /**
     * 登陸系統
     *
     * @param context
     * @param params
     * @param handler
     */
    void loginSystem(Context context, SystemLoginBean params, HttpResponseHandler<SystemLoginResultBean> handler);

    /**
     * 退出登陆
     *
     * @param context
     * @param params
     * @param handler
     */
    void loginOutSystem(Context context, SystemLoginOutBean params, HttpResponseHandler<SystemLoginOutResultBean> handler);

    /**
     * 单项系统登陆
     *
     * @param context
     * @param loginKey
     */
    void loginStoreSystem(Context context, String loginKey);

    /**
     * 用户签到
     *
     * @param context
     * @param params
     * @param handler
     */
    void userInfoSign(Context context, UserInfoSignBean params, HttpResponseHandler<UserInfoSignResultBean> handler);

    /**
     * 获取签到积分
     *
     * @param context
     * @param params
     * @param handler
     */
    void getUserInfoIntegral(Context context, UserInfoIntegralBean params, HttpResponseHandler<UserInfoIntegralResultBean> handler);


    /**
     * 获取签到积分列表
     *
     * @param context
     * @param params
     * @param handler
     */
    void getUserInfoListIntegral(Context context, UserInfoIntegralListBean params, HttpResponseHandler<UserInfoIntegralListResultBean> handler);

    /**
     * 通过短信修改密码
     *
     * @param context
     * @param params
     * @param handler
     */
    void changePassWordSMS(Context context, ChangePassWordSMSBean params, HttpResponseHandler<ChangePassWordSMSResultBean> handler);
}
