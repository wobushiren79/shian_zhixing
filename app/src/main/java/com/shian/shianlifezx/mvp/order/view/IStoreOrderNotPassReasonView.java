package com.shian.shianlifezx.mvp.order.view;

import com.shian.shianlifezx.mvp.base.BaseMVPView;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonResultBean;

/**
 * Created by zm.
 */

public interface IStoreOrderNotPassReasonView extends BaseMVPView {

    void getPassReasonSuccess(StoreOrderNotPassReasonResultBean resultBean);

    void getPassReasonFail(String msg);
}
