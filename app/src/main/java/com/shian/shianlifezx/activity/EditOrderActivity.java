package com.shian.shianlifezx.activity;

import android.os.Bundle;
import android.view.View;
import butterknife.InjectView;
import butterknife.OnClick;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.view.order.OrdersView;

public class EditOrderActivity extends BaseActivity {
	@InjectView(R.id.ov_0)
	OrdersView orderView0;
	@InjectView(R.id.ov_1)
	OrdersView orderView1;
	@InjectView(R.id.ov_2)
	OrdersView orderView2;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_editorder);
		setTitle("编辑订单");
		initOrderView();
	}

	@OnClick(R.id.tv_edit_commit)
	void commitOrder(View v) {
		finish();
	}

	private void initOrderView() {
		orderView0.setOrders("治丧主套餐",
				new String[] { "传统A", "传统B", "传统C", "传统D" });
		orderView0.addOrder("户外棚配置", "单价：1212", "小计：00023", new String[] {
				"回礼A", "回礼B", "回礼C", "回礼D" });
		orderView0.addOrder("消耗品套装", "单价：1222", "小计：2023", new String[] {
				"回礼A", "回礼B", "回礼C", "回礼D" });
		orderView0.addOrder("市内装饰", "单价：1212", "小计：00023", new String[] {
				"回礼A", "回礼B", "回礼C", "回礼D" });
		orderView0.addOrder("市外装饰", "单价：1212", "小计：00023", new String[] {
				"回礼A", "回礼B", "回礼C", "回礼D" });

		orderView1.setOrders("殡仪馆项目", new String[] { "殡仪馆A", "殡仪馆B", "殡仪馆C",
				"殡仪馆D" });
		orderView0.addOrder("殡仪馆配置", "单价：1212", "小计：00023", new String[] {
				"回礼A", "回礼B", "回礼C", "回礼D" });

		orderView2.setOrders("增值服务项目", new String[] { "增值A", "增值B", "增值C",
				"增值D" });
		orderView2.addOrder("增值配置", "单价：1212", "小计：00023", new String[] {
				"回礼A", "回礼B", "回礼C", "回礼D" });
	}
}
