package com.shian.shianlifezx.mvp.userinfo.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoSignBean;


/**
 * Created by zm.
 */

public interface IUserInfoSignModel {
    void userInfoSign(Context context, UserInfoSignBean params, OnGetDataListener listener);
}
