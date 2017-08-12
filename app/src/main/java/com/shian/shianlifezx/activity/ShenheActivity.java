package com.shian.shianlifezx.activity;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;
import okhttp3.Request;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.utils.JSONUtil;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpSubmit4AuditParams;
import com.shian.shianlifezx.provide.result.WaitItem;

public class ShenheActivity extends BaseActivity {
	private WaitItem mData;
	@InjectViews({ R.id.tv_shenhe_0, R.id.tv_shenhe_1, R.id.tv_shenhe_2,
			R.id.tv_shenhe_3, R.id.tv_shenhe_4, R.id.tv_shenhe_5,
			R.id.tv_shenhe_6, R.id.tv_shenhe_7, R.id.tv_shenhe_8 })
	List<TextView> tvList;
	@InjectView(R.id.et_shenhe)
	EditText etShenhe;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_shenhe);
		mData = JSONUtil.parseJSONString(getIntent().getStringExtra("data"),
				WaitItem.class);
		initData();
	}

	private void initData() {
		tvList.get(0).setText("订单编号：" + mData.getOrderItemId() + "");
		tvList.get(1).setText("经办人：" + mData.getAdviserName() + "");
		tvList.get(2).setText("执行名称：" + mData.getAdviserName() + "");
		tvList.get(3).setText("执行人员：" + mData.getAdviserName() + "");
		tvList.get(4).setText("治丧地址：" + mData.getFuneralAddress() + "");
		tvList.get(5).setText("接单时间：" + mData.getAcceptTime() + "");
		tvList.get(6).setText("开始执行时间：" + mData.getStartTime() + "");
		tvList.get(7).setText("执行完成时间：" + mData.getPassTime() + "");
		tvList.get(8).setText("白事顾问评价：" + mData.getOrderItemId() + "");
	}

	@OnClick({ R.id.tv_pass, R.id.tv_unpass })
	void passClick(View v) {
		HpSubmit4AuditParams localHpSubmit4AuditParams = new HpSubmit4AuditParams();
		localHpSubmit4AuditParams
				.setExecutorNote(etShenhe.getText().toString());
		localHpSubmit4AuditParams.setOrderItemId(mData.getOrderItemId());
		MHttpManagerFactory.getFuneralExecutorManager().submit4Audit(this,
				localHpSubmit4AuditParams, new HttpResponseHandler<String>() {

					@Override
					public void onStart(Request request, int id) {

					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						ToastUtils.show(ShenheActivity.this, "操作成功");
						finish();

					}


					@Override
					public void onError(String message) {
						// TODO Auto-generated method stub

					}
				});
	}
}
