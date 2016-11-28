package com.shian.shianlifezx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import butterknife.InjectView;
import butterknife.OnClick;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.view.finger.DrawView;

public class PayShouActivity extends BaseActivity{
	@InjectView(R.id.dv_pay)
	DrawView dvPay;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_pay_shou);
		setTitle("收款");
		dvPay.changeColour(7);
		dvPay.requestFocus();
	}

	@OnClick(R.id.tv_pay_sure)
	void payClick(View v){
		Intent in=new Intent(this,PayActivity.class);
		in.putExtra("ding", false);
		startActivity(in);
		finish();
	}
}
