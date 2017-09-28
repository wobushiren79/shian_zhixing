package com.shian.shianlifezx.mvp.userinfo.view;


import com.shian.shianlifezx.mvp.base.BaseMVPView;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoSignResultBean;

/**
 * Created by zm.
 */

public interface IUserInfoSignView extends BaseMVPView {
    void userInfoSignSuccess(UserInfoSignResultBean resultBean);

    void userInfoSignFail(String msg);
}
