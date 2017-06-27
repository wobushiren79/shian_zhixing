package com.shian.shianlifezx.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.InjectViews;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.JSONUtil;
import com.shian.shianlifezx.common.utils.Utils;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpReadMessage;
import com.shian.shianlifezx.provide.result.HrCommentResult;
import com.shian.shianlifezx.provide.result.HrMessageList.MessageList;

public class MessageDetailActviity extends BaseActivity {
	@InjectViews({ R.id.tv_msg_title, R.id.tv_msg_time, R.id.tv_msg_content })
	List<TextView> tvList;
	private MessageList message;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_messagesetail);
		setTitle("消息详情");
		setMessageVisible(View.GONE);
		message = JSONUtil.parseJSONString(getIntent()
				.getStringExtra("message"), MessageList.class);
		tvList.get(0).setText(message.getHead());
		if (message.getServerCreateTime() == null) {
			tvList.get(1).setVisibility(View.GONE);
		}
		tvList.get(1).setText(message.getServerCreateTime());
		tvList.get(2).setText(message.getBody());
		boolean isB = getIntent().getBooleanExtra("isBroadcast", false);
		if (!isB) {
			MHttpManagerFactory.getAccountManager().getMessageCount(this,
					new HttpResponseHandler<HrCommentResult>() {

						@Override
						public void onSuccess(HrCommentResult result) {
							// TODO Auto-generated method stub
							AppContansts.MessageCount = result.getCount();
						}

						@Override
						public void onStart() {
							// TODO Auto-generated method stub

						}

						@Override
						public void onError(String message) {
							// TODO Auto-generated method stub

						}
					});
			HpReadMessage params = new HpReadMessage();
			List<Long> l = new ArrayList<Long>();
			l.add(message.getId());
			params.setMsgIds(l);
			MHttpManagerFactory.getAccountManager().readMessage(this, params,
					new HttpResponseHandler<Object>() {

						@Override
						public void onSuccess(Object result) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onStart() {
							// TODO Auto-generated method stub

						}

						@Override
						public void onError(String message) {
							// TODO Auto-generated method stub

						}
					});
		}
	}
}
