package com.shian.shianlifezx.mvp.login.view;


import com.shian.shianlifezx.mvp.base.BaseMVPView;
import com.shian.shianlifezx.mvp.login.bean.DuiBaLoginResultBean;

/**
 * Created by zm.
 */

public interface IDuiBaLoginView extends BaseMVPView {
    void loginDuiBaSuccess(DuiBaLoginResultBean resultBean);

    void loginDuiBaFail(String msg);

    Integer getIntegral();
}
