package com.shian.shianlifezx.mvp.userinfo.view;

import com.shian.shianlifezx.mvp.base.BaseMVPView;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralListResultBean;

/**
 * Created by zm.
 */

public interface IUserInfoIntegralListView extends BaseMVPView {

    void getIntegralListSuccess(UserInfoIntegralListResultBean resultBean);

    void getIntegralListFail(String msg);

    Integer getPageNumber();

    Integer getPageSize();

}
