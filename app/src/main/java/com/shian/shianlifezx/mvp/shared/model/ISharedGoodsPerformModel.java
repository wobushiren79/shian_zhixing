package com.shian.shianlifezx.mvp.shared.model;

import android.content.Context;

/**
 * Created by zm.
 */

public interface ISharedGoodsPerformModel {


    String getExecutorName(Context context);

    String getExecutorPhone(Context context);

    void setExecutorName(Context context, String name);

    void setExecutorPhone(Context context, String phone);
}
