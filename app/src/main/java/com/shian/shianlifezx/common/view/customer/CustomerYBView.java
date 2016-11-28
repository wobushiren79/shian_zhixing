package com.shian.shianlifezx.common.view.customer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.shian.shianlifezx.R;

public class CustomerYBView extends FrameLayout {
	private View v;
	public CustomerYBView(Context context, AttributeSet attrs) {
		super(context, attrs);
		v=LayoutInflater.from(context).inflate(R.layout.view_customer_yb, this);
	}

	public CustomerYBView(Context context) {
		this(context, null);
	}
	
	

}
