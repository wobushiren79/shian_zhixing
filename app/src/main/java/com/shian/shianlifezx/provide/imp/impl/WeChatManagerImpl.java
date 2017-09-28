package com.shian.shianlifezx.provide.imp.impl;

import android.content.Context;

import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.mvp.login.bean.DuiBaLoginBean;
import com.shian.shianlifezx.mvp.login.bean.DuiBaLoginResultBean;
import com.shian.shianlifezx.provide.base.BaseManagerImpl;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.imp.WeChatManager;


/**
 * Created by zm.
 */

public class WeChatManagerImpl extends BaseManagerImpl implements WeChatManager {
    private static WeChatManagerImpl manager;

    private WeChatManagerImpl() {
        super();
        baseUrl = AppContansts.PHP_WeChat_BaseUrl;
    }


    public static WeChatManagerImpl getInstance() {
        if (manager == null) {
            manager = new WeChatManagerImpl();
        }
        return manager;
    }

    @Override
    public void loginDuiBa(Context context, DuiBaLoginBean params, HttpResponseHandler<DuiBaLoginResultBean> handler) {
        requestPostFormToListForObj(context, "wechatApi/login/app_get_duiba", DuiBaLoginResultBean.class, params, handler);
    }
}
