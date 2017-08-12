package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.shian.shianlifezx.mvp.login.bean.SystemLoginBean;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
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
     * 单项系统登陆
     *
     * @param context
     * @param loginKey
     */
    void loginStoreSystem(Context context, String loginKey);
}
