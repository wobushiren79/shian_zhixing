package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.shian.shianlifezx.provide.base.HttpManager;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetLoginAdvertisement;


/**
 * Created by Administrator on 2017/3/4.
 */

public interface PHPManager extends HttpManager {
    /**
     * 获取登录页广告
     * @param context
     * @param handler
     */
    public void loginAdvertisement(Context context, HttpResponseHandler<PHPHrGetLoginAdvertisement> handler);

}
