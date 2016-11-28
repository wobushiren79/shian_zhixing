package com.shian.shianlifezx.common.view.order;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.shian.shianlifezx.R;

public class OrdersView extends FrameLayout{

	private View v;
	private LinearLayout llOrders;
	private Spinner sp;
	private TextView tvTitle;
	public OrdersView(Context context, AttributeSet attrs) {
		super(context, attrs);
		v=LayoutInflater.from(context).inflate(R.layout.view_orders, null);
		addView(v);
		llOrders=(LinearLayout)v.findViewById(R.id.ll_orders);
		sp=(Spinner)v.findViewById(R.id.sp_orders);
		tvTitle=(TextView)v.findViewById(R.id.tv_orders_title);
	}
	
	public void setOrders(String title,String[] arr){
		tvTitle.setText(title);
		ArrayAdapter<CharSequence> province_adapter = new ArrayAdapter<CharSequence>(
				getContext(), android.R.layout.simple_spinner_item, arr);
		province_adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(province_adapter);
	}
	
	public void addOrder(String title, String dj, String xj, String[] arr){
		OneOrderView oneOrder=new OneOrderView(getContext());
		oneOrder.setOrderDate(title, dj, xj, arr);
		llOrders.addView(oneOrder);
	}

}
