package com.shian.shianlifezx.mvp.login.presenter;

/**
 * Created by zm.
 */

public interface IUserLoginPresenter {
    /**
     * 登陸平臺
     */
    void loginSystem();

    /**
     * 保存配置信息
     */
    void saveLoginConfig();

    /**
     * 获取配置信息
     */
    void getLoginConfig();

}
