package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpAcceptParams;
import com.shian.shianlifezx.provide.params.HpChangeLocation;
import com.shian.shianlifezx.provide.params.HpConsultIdParams;
import com.shian.shianlifezx.provide.params.HpLoginParams;
import com.shian.shianlifezx.provide.params.HpPageParams;
import com.shian.shianlifezx.provide.params.HpReadMessage;
import com.shian.shianlifezx.provide.params.HpRejectParams;
import com.shian.shianlifezx.provide.params.HpSkuIdParams;
import com.shian.shianlifezx.provide.params.HpStartServiceParams;
import com.shian.shianlifezx.provide.params.HpSubmit4AuditParams;
import com.shian.shianlifezx.provide.result.HrCommentResult;
import com.shian.shianlifezx.provide.result.HrGetSKUDetails;
import com.shian.shianlifezx.provide.result.HrLoginResult;
import com.shian.shianlifezx.provide.result.HrMessageList;
import com.shian.shianlifezx.provide.result.HrUserInfo;
import com.shian.shianlifezx.provide.result.HrWaitExecuteList;

/**
 * Created by zm.
 */

public interface FuneralExecutorManager {
    void accept(Context paramContext,
                HpAcceptParams paramHpAcceptParams,
                HttpResponseHandler<String> paramHttpResponseHandler);

    void getWaitExecuteList(Context paramContext, int paramInt,
                            HpPageParams paramHpPageParams,
                            HttpResponseHandler<HrWaitExecuteList> paramHttpResponseHandler);

    void login(Context paramContext,
               HpLoginParams paramHpLoginParams,
               HttpResponseHandler<HrLoginResult> paramHttpResponseHandler);

    void loginout(Context paramContext,
                  HttpResponseHandler<Object> paramHttpResponseHandler);

    void reject(Context paramContext,
                HpRejectParams paramHpRejectParams,
                HttpResponseHandler<String> paramHttpResponseHandler);

    void startService(Context paramContext,
                      HpStartServiceParams paramHpStartServiceParams,
                      HttpResponseHandler<String> paramHttpResponseHandler);

    void submit4Audit(Context paramContext,
                      HpSubmit4AuditParams paramHpSubmit4AuditParams,
                      HttpResponseHandler<String> paramHttpResponseHandler);

    void getMessageList(Context context, HpPageParams params,
                        HttpResponseHandler<HrMessageList> handler);


    void getMessageCount(Context context,
                         HttpResponseHandler<HrCommentResult> handler);

    /**
     * @param context
     * @param params
     * @param handler
     */
    void readMessage(Context context, HpReadMessage params,
                     HttpResponseHandler<Object> handler);

    void changeInfo(Context context, HpConsultIdParams params,
                    HttpResponseHandler<Object> handler);

    void getUserInfo(Context context,
                     HttpResponseHandler<HrUserInfo> handler);

    void changeCurAddress
            (Context context, HpConsultIdParams params,
             HttpResponseHandler<Object> handler);


    /**
     * 获取商品详情
     *
     * @param context
     * @param params
     * @param handler
     */
    void getSKUDetails(Context context, HpSkuIdParams params, HttpResponseHandler<HrGetSKUDetails> handler);

    /**
     * 改变地址
     */
    void changeLocation(Context context, HpChangeLocation params, HttpResponseHandler<Object> handler);
}
