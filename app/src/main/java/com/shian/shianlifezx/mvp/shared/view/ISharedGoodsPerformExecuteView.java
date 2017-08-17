package com.shian.shianlifezx.mvp.shared.view;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.BaseMVPView;

/**
 * Created by zm.
 */

public interface ISharedGoodsPerformExecuteView  extends BaseMVPView {

    String getExecutorName();

    String getExecutorPhone();

    void setExecutorName(String name);

    void setExecutorPhone(String phone);
}
