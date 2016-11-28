package com.shian.shianlifezx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.InjectView;
import butterknife.OnClick;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;

public class PayActivity extends BaseActivity{
	@InjectView(R.id.ll_pay_fp)
	LinearLayout llFP;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_pay_ding);
		setTitle("支付定金");
		boolean isPayDing=getIntent().getBooleanExtra("ding", true);
		if(!isPayDing){
			llFP.setVisibility(View.VISIBLE);
		}
	}

	@OnClick(R.id.tv_edit_commit)
	void payClick(View v){
		Intent in=new Intent(this,PayEwmActivity.class);
		startActivity(in);
		finish();
	}
}
