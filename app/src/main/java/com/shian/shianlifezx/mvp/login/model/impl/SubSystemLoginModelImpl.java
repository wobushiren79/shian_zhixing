package com.shian.shianlifezx.mvp.login.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.login.model.ISubSystemLoginModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;


/**
 * Created by zm.
 */

public class SubSystemLoginModelImpl implements ISubSystemLoginModel {
    @Override
    public void subSystemStoreLogin(Context context, String loginKey) {
        MHttpManagerFactory.getSystemManager().loginStoreSystem(context, loginKey);
    }
}
