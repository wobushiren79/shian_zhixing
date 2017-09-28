package com.shian.shianlifezx.mvp.userinfo.view;


import com.shian.shianlifezx.mvp.base.BaseMVPView;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralResultBean;

/**
 * Created by zm.
 */

public interface IUserInfoIntegralView extends BaseMVPView {

    void getUserInfoIntegralSuccess(UserInfoIntegralResultBean resultBean);

    void getUserInfoIntegralFail(String msg);

    void setUserInfoIntegral(Integer integral);

    void setUserInfoContinuousDay(Integer day);

    void setUserInfoCanSign(boolean isSign);
}
