package com.shian.shianlifezx.mvp.order.view;

import com.shian.shianlifezx.mvp.base.BaseMVPView;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetExecutorResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderGetExecutorView extends BaseMVPView {
    Long getPerformUserId();

    void getExecutorSuccess(StoreOrderGetExecutorResultBean resultBean);

    void getExecutorFail(String msg);
}
