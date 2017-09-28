package com.shian.shianlifezx.mvp.userinfo.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralListBean;


/**
 * Created by zm.
 */

public interface IUserInfoIntegralListModel {
    void getIntegralList(Context context, UserInfoIntegralListBean params, OnGetDataListener listener);
}
