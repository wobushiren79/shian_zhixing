package com.shian.shianlifezx.provide.imp.impl;

import android.content.Context;

import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.provide.base.BaseHttpParams;
import com.shian.shianlifezx.provide.base.HttpRequestExecutor;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.imp.MAccountManager;
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
 * 账户接口实现
 *
 * @author Administrator
 */
public class MAccountManagerImpl implements MAccountManager {
    public HttpRequestExecutor excutor = new HttpRequestExecutor();
    private static MAccountManager manager;
    private String BaseUrl = AppContansts.ExecutorURL;

    private MAccountManagerImpl() {
    }

    public static MAccountManager getInstance() {
        if (manager == null) {
            manager = new MAccountManagerImpl();
        }
        return manager;
    }

    private <T> void requestPost(Context context,
                                 String method,
                                 Class<T> cls,
                                 BaseHttpParams params,
                                 HttpResponseHandler<T> response) {
        excutor.requestPost(context, BaseUrl + "/" + method, cls, params, response);
    }

    private <T> void requestPost(Context context,
                                 String method,
                                 Class<T> cls,
                                 BaseHttpParams params,
                                 HttpResponseHandler<T> response,
                                 boolean isDialog) {
        excutor.requestPost(context, BaseUrl + "/" + method, cls, params, response, isDialog);
    }

    @Override
    public void login(Context context, HpLoginParams params, HttpResponseHandler<HrLoginResult> handler) {
        // TODO Auto-generated method stub
        requestPost(context, "doLogin", HrLoginResult.class, params, handler);
    }

    @Override
    public void loginout(Context context, HttpResponseHandler<Object> handler) {
        // TODO Auto-generated method stub
        requestPost(context, "doLogout", Object.class, new BaseHttpParams(), handler);
    }

    public void accept(Context paramContext,
                       HpAcceptParams paramHpAcceptParams,
                       HttpResponseHandler<String> paramHttpResponseHandler) {
        requestPost(paramContext, "order/item/accept", String.class, paramHpAcceptParams, paramHttpResponseHandler, true);
    }

    public void reject(Context paramContext,
                       HpRejectParams paramHpRejectParams,
                       HttpResponseHandler<String> paramHttpResponseHandler) {
        requestPost(paramContext, "order/item/reject", String.class, paramHpRejectParams, paramHttpResponseHandler, true);
    }

    public void startService(Context paramContext,
                             HpStartServiceParams paramHpStartServiceParams,
                             HttpResponseHandler<String> paramHttpResponseHandler) {
        requestPost(paramContext, "order/item/startService", String.class, paramHpStartServiceParams, paramHttpResponseHandler, true);
    }

    public void submit4Audit(Context paramContext,
                             HpSubmit4AuditParams paramHpSubmit4AuditParams,
                             HttpResponseHandler<String> paramHttpResponseHandler) {
        requestPost(paramContext, "order/item/submit4Audit", String.class, paramHpSubmit4AuditParams, paramHttpResponseHandler, true);
    }

    public void getWaitExecuteList(Context paramContext, int paramInt,
                                   HpPageParams paramHpPageParams,
                                   HttpResponseHandler<HrWaitExecuteList> paramHttpResponseHandler) {
        String str = "";
        switch (paramInt) {
            case 0:
                str = "order/item/list/waitExecute";
                break;
            case 1:
                str = "order/item/list/executing";
                break;
            case 2:
                str = "order/item/list/waitAudit";
                break;
            case 3:
                str = "order/item/list/auditSuccess";
                break;
            case 4:
                str = "order/item/list/auditFailure";
                break;
        }
        requestPost(paramContext, str, HrWaitExecuteList.class, paramHpPageParams, paramHttpResponseHandler);

    }

    @Override
    public void getMessageList(Context context, HpPageParams params,
                               HttpResponseHandler<HrMessageList> handler) {
        // TODO Auto-generated method stub
        requestPost(context, "push/msg/get", HrMessageList.class, params, handler, true);
    }

    @Override
    public void getMessageCount(Context context,
                                HttpResponseHandler<HrCommentResult> handler) {
        // TODO Auto-generated method stub
        requestPost(context, "push/msg/unread/count", HrCommentResult.class, new BaseHttpParams(), handler, true);
    }

    @Override
    public void readMessage(Context context, HpReadMessage params,
                            HttpResponseHandler<Object> handler) {
        // TODO Auto-generated method stub
        requestPost(context, "push/msg/read", Object.class, params, handler, true);
    }

    @Override
    public void changeInfo(Context context, HpConsultIdParams params,
                           HttpResponseHandler<Object> handler) {
        requestPost(context, "user/changeInfo", Object.class, params, handler, true);
    }

    @Override
    public void getUserInfo(Context context,
                            HttpResponseHandler<HrUserInfo> handler) {
        requestPost(context, "user/info/get", HrUserInfo.class, new BaseHttpParams(), handler, true);
    }

    @Override
    public void changeCurAddress(Context context, HpConsultIdParams params, HttpResponseHandler<Object> handler) {
        requestPost(context, "user/changeCurAddress", Object.class, params, handler, true);
    }

    @Override
    public void getSKUDetails(Context context, HpSkuIdParams params, HttpResponseHandler<HrGetSKUDetails> handler) {
        requestPost(context, "order/item/list/get/skudetails", HrGetSKUDetails.class, params, handler, true);
    }

    @Override
    public void changeLocation(Context context, HpChangeLocation params, HttpResponseHandler<Object> handler) {
        requestPost(context, "customer/address/position/change", Object.class, params, handler, true);
    }
}
