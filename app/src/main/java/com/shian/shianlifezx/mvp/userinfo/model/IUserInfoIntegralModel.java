package com.shian.shianlifezx.mvp.userinfo.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralBean;


/**
 * Created by zm.
 */

public interface IUserInfoIntegralModel {
    void getUserInfoIntegral(Context context, UserInfoIntegralBean params, OnGetDataListener listener);
}
