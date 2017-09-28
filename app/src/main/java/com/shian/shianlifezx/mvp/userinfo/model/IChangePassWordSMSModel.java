package com.shian.shianlifezx.mvp.userinfo.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.userinfo.bean.ChangePassWordSMSBean;


/**
 * Created by zm.
 */

public interface IChangePassWordSMSModel {
    void passWordSMS(Context context, ChangePassWordSMSBean params, OnGetDataListener listener);
}
