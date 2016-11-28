package com.shian.shianlifezx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import butterknife.InjectView;
import butterknife.OnClick;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.view.LBSLocalView;

public class NewOrderActivity extends BaseActivity {
	@InjectView(R.id.lbs)
	LBSLocalView lbsView;
	@InjectView(R.id.sp_order_ywlx)
	Spinner spYW;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_neworder);
		setTitle("新建工单");
		initView();
	}

	private void initView() {
		lbsView.loadSpinner("四川", "成都", "武侯区");
		ArrayAdapter<CharSequence> province_adapter = ArrayAdapter
				.createFromResource(this, R.array.ywlx,
						android.R.layout.simple_list_item_checked);
		province_adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spYW.setAdapter(province_adapter);
		spYW.setSelection(0);
	}
	
	@OnClick(R.id.tv_editorder)
	void editOrderClick(View v){
		Intent in=new Intent(this,EditOrderActivity.class);
		startActivity(in);
	}
}
