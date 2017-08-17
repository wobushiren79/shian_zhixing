package com.shian.shianlifezx.mvp.shared.model.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.shian.shianlifezx.mvp.shared.model.BaseSharedModel;
import com.shian.shianlifezx.mvp.shared.model.ISharedGoodsPerformModel;


/**
 * Created by zm.
 */

public class SharedGoodsPerformModelImpl extends BaseSharedModel implements ISharedGoodsPerformModel {
    private static final String Shared_Executor_Name = "Shared_Executor_Name";
    private static final String Shared_Executor_Phone = "Shared_Executor_Phone";

    @Override
    public String getExecutorName(Context context) {
        SharedPreferences shared = getDataShared(context, Tag_Goods_Perform);
        return shared.getString(Shared_Executor_Name, "");
    }

    @Override
    public String getExecutorPhone(Context context) {
        SharedPreferences shared = getDataShared(context, Tag_Goods_Perform);
        return shared.getString(Shared_Executor_Phone, "");
    }

    @Override
    public void setExecutorName(Context context, String name) {
        SharedPreferences.Editor editor = getEditShared(context, Tag_Goods_Perform);
        editor.putString(Shared_Executor_Name, name);
        editor.commit();
    }

    @Override
    public void setExecutorPhone(Context context, String phone) {
        SharedPreferences.Editor editor = getEditShared(context, Tag_Goods_Perform);
        editor.putString(Shared_Executor_Phone, phone);
        editor.commit();
    }

}
