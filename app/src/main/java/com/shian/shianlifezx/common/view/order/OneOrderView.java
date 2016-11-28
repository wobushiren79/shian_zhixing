package com.shian.shianlifezx.common.view.order;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.shian.shianlifezx.R;

public class OneOrderView extends FrameLayout {
	private View v;

	public OneOrderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		v = LayoutInflater.from(context).inflate(R.layout.view_oneorder, null);
		addView(v);
		initView();
	}

	public OneOrderView(Context context) {
		this(context, null);
	}

	private TextView tvTitle;
	private LinearLayout llOneOrder;
	private Button btnAddOrder;

	private void initView() {
		tvTitle = (TextView) v.findViewById(R.id.tv_one_title);
		llOneOrder = (LinearLayout) v.findViewById(R.id.ll_oneorder);
		btnAddOrder = (Button) v.findViewById(R.id.btn_addorder);
		btnAddOrder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addOrder(mDj, mXj, mArr);
			}
		});

	}

	private String mDj;
	private String mXj;
	private String[] mArr;

	public void setOrderDate(String title, String dj, String xj, String[] arr) {
		mDj = dj;
		mXj = xj;
		mArr = arr;
		tvTitle.setText(title);
		addOrder(dj, xj, arr);
	}

	public void addOrder(String dj, String xj, String[] arr) {
		View order = LayoutInflater.from(getContext()).inflate(
				R.layout.view_one, null);
		llOneOrder.addView(order);
		Spinner sp = (Spinner) order.findViewById(R.id.sp_one);
		TextView tvDJ = (TextView) order.findViewById(R.id.tv_one_dj);
		TextView tvXJ = (TextView) order.findViewById(R.id.tv_one_xj);
		Button btnJ = (Button) order.findViewById(R.id.btn_one_j);
		final Button btnCount = (Button) order.findViewById(R.id.btn_one_count);
		Button btnAdd = (Button) order.findViewById(R.id.btn_one_add);
		tvDJ.setText(dj);
		tvXJ.setText(xj);

		btnJ.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				int count = Integer.valueOf(btnCount.getText().toString());
				if (count > 0) {
					btnCount.setText(count - 1 + "");
				}
			}
		});
		btnAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				int count = Integer.valueOf(btnCount.getText().toString());
				btnCount.setText(count + 1 + "");
			}
		});
		ArrayAdapter<CharSequence> province_adapter = new ArrayAdapter<CharSequence>(
				getContext(), android.R.layout.simple_spinner_item, arr);
		province_adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(province_adapter);

	}
}
