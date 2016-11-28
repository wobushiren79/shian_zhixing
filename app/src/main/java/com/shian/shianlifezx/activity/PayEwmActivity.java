package com.shian.shianlifezx.activity;

import android.content.Intent;
import android.os.Bundle;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;

public class PayEwmActivity extends BaseActivity{
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_pay_ewm);
		setTitle("支付定金");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Intent in=new Intent(PayEwmActivity.this,PayFinishActivity.class);
				startActivity(in);
				finish();
			}
		}).start();
	}

}
