package com.shian.shianlifezx.mvp.login.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginBean;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginOutBean;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginOutResultBean;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.mvp.login.bean.UserLoginConfig;


/**
 * Created by zm.
 */

public interface IUserLoginModel {

    /**
     * 登陆平台
     *
     * @param context
     * @param params
     * @param listener
     */
    void loginSystem(Context context, SystemLoginBean params, OnGetDataListener<SystemLoginResultBean> listener);

    /**
     * 退出登陆平台
     *
     * @param context
     * @param params
     * @param listener
     */
    void loginOutSystem(Context context, SystemLoginOutBean params, OnGetDataListener<SystemLoginOutResultBean> listener);

    /**
     * 保存登陆设置
     *
     * @param context
     * @param loginConfig
     */
    void saveLoginConfig(Context context, UserLoginConfig loginConfig);

    /**
     * 获取登陆设置
     *
     * @param context
     * @return
     */
    UserLoginConfig getLoginConfig(Context context);
}
