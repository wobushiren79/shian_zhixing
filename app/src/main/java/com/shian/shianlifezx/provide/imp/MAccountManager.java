package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.shian.shianlifezx.provide.base.HttpManager;
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
 * 账户接口
 * 
 * @author Administrator
 * 
 */
public interface MAccountManager extends HttpManager {
	public abstract void accept(Context paramContext,
			HpAcceptParams paramHpAcceptParams,
			HttpResponseHandler<String> paramHttpResponseHandler);

	public abstract void getWaitExecuteList(Context paramContext, int paramInt,
			HpPageParams paramHpPageParams,
			HttpResponseHandler<HrWaitExecuteList> paramHttpResponseHandler);

	public abstract void login(Context paramContext,
			HpLoginParams paramHpLoginParams,
			HttpResponseHandler<HrLoginResult> paramHttpResponseHandler);

	public abstract void loginout(Context paramContext,
			HttpResponseHandler<Object> paramHttpResponseHandler);

	public abstract void reject(Context paramContext,
			HpRejectParams paramHpRejectParams,
			HttpResponseHandler<String> paramHttpResponseHandler);

	public abstract void startService(Context paramContext,
			HpStartServiceParams paramHpStartServiceParams,
			HttpResponseHandler<String> paramHttpResponseHandler);

	public abstract void submit4Audit(Context paramContext,
			HpSubmit4AuditParams paramHpSubmit4AuditParams,
			HttpResponseHandler<String> paramHttpResponseHandler);

	public abstract void getMessageList(Context context, HpPageParams params,
			HttpResponseHandler<HrMessageList> handler);

	/**
	 * 
	 * @param context
	 * @param params
	 * @param handler
	 */
	public abstract void getMessageCount(Context context,
			HttpResponseHandler<HrCommentResult> handler);

	/**
	 * 
	 * @param context
	 * @param params
	 * @param handler
	 */
	public abstract void readMessage(Context context, HpReadMessage params,
			HttpResponseHandler<Object> handler);

	public void changeInfo(Context context, HpConsultIdParams params,
			HttpResponseHandler<Object> handler);

	public void getUserInfo(Context context,
			HttpResponseHandler<HrUserInfo> handler);
	public void changeCurAddress
    (Context context, HpConsultIdParams params,
     HttpResponseHandler<Object> handler);


	/**
	 * 获取商品详情
	 * @param context
	 * @param params
	 * @param handler
	 */
	public void getSKUDetails(Context context, HpSkuIdParams params, HttpResponseHandler<HrGetSKUDetails> handler);

	/**
	 * 改变地址
	 */
	public void changeLocation(Context context, HpChangeLocation params, HttpResponseHandler<Object> handler);
}