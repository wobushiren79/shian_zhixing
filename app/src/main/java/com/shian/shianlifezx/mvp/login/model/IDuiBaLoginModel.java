package com.shian.shianlifezx.mvp.login.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.login.bean.DuiBaLoginBean;


/**
 * Created by zm.
 */

public interface IDuiBaLoginModel {
    void loginDuiBa(Context context, DuiBaLoginBean params, OnGetDataListener listener);
}
