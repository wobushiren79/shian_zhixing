package com.shian.shianlifezx.mvp.userinfo.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoBean;


/**
 * Created by zm.
 */

public interface IUserInfoModel {
    void getUserInfoData(Context context, UserInfoBean params, OnGetDataListener<SystemLoginResultBean.UserObject> listener);
}
