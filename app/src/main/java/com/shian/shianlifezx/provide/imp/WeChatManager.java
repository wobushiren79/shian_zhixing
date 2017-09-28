package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.shian.shianlifezx.mvp.login.bean.DuiBaLoginBean;
import com.shian.shianlifezx.mvp.login.bean.DuiBaLoginResultBean;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;


/**
 * Created by zm.
 */

public interface WeChatManager {

    /**
     * 登陸對吧
     *
     * @param context
     * @param params
     * @param handler
     */
    void loginDuiBa(Context context, DuiBaLoginBean params, HttpResponseHandler<DuiBaLoginResultBean> handler);
}
