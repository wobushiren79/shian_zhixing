package com.shian.shianlifezx.mvp.login.presenter.impl;


import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.mvp.login.model.ISubSystemLoginModel;
import com.shian.shianlifezx.mvp.login.model.impl.SubSystemLoginModelImpl;
import com.shian.shianlifezx.mvp.login.presenter.ISubSystemLoginPresenter;
import com.shian.shianlifezx.mvp.login.view.ISubSystemLoginView;

/**
 * Created by zm.
 */

public class SubSystemLoginPresenterImpl implements ISubSystemLoginPresenter {

    ISubSystemLoginView subSystemLoginView;
    ISubSystemLoginModel subSystemLoginModel;

    public SubSystemLoginPresenterImpl(ISubSystemLoginView subSystemLoginView) {
        this.subSystemLoginView = subSystemLoginView;
        subSystemLoginModel = new SubSystemLoginModelImpl();
    }

    @Override
    public void loginStoreSystem() {
        subSystemLoginModel.subSystemStoreLogin(subSystemLoginView.getContext(), AppContansts.System_Ki4so_Client_Ec);
    }
}
