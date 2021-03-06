package com.shian.shianlifezx.common.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.shian.shianlifezx.R;

public class TipsDialog extends Dialog {
	private DisplayMetrics outMetrics;
	@InjectView(R.id.tv_top)
	TextView tv_top;
	@InjectView(R.id.tv_title)
	TextView tv_title;
	@InjectView(R.id.tv_btn1)
	TextView tv_btn1;
	@InjectView(R.id.tv_btn2)
	TextView tv_btn2;
	String top="确认提交？";
	String title;

	String btn1Text;

	String btn2Text;

	OnClickListener topClickListener;

	OnClickListener bottomClickListener;
	boolean isBtn1V=false;
	boolean isBtn2V=false;
	public TipsDialog(Context context) {
		super(context, R.style.tipsDialogStyle);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.dialog_tips);
		ButterKnife.inject(this);
		if (isBtn1V)
			tv_btn1.setVisibility(View.VISIBLE);
		else
			tv_btn1.setVisibility(View.GONE);
		if (isBtn2V)
			tv_btn2.setVisibility(View.VISIBLE);
		else
			tv_btn2.setVisibility(View.GONE);
		tv_top.setText(top);
		tv_title.setText(title);
		tv_btn1.setText(btn1Text);
		tv_btn2.setText(btn2Text);
	}

	/**
	 * 设置标题栏
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 设置头
	 *
	 * @param top
	 */
	public void setTop(String top) {
		this.top = top;
	}
	/**
	 * 设置按钮1
	 * 
	 * @param text
	 * @param onClickListener
	 */
	public void setTopButton(String text, OnClickListener onClickListener) {
		isBtn1V=true;
		btn1Text = text;
		topClickListener = onClickListener;
	}

	/**
	 * 设置按钮2
	 * 
	 * @param text
	 * @param onClickListener
	 */
	public void setBottomButton(String text, OnClickListener onClickListener) {
		isBtn2V=true;
		btn2Text = text;
		bottomClickListener = onClickListener;
	}

	@OnClick(R.id.tv_btn1)
	void topClick() {
		cancel();
		if (topClickListener != null) {
			topClickListener.onClick(this, 0);
		}
	}

	@OnClick(R.id.tv_btn2)
	void bottomClick() {
		cancel();
		if (bottomClickListener != null) {
			bottomClickListener.onClick(this, 0);
		}
	}

	@Override
	public void show() {
		outMetrics = new DisplayMetrics();
		getWindow().getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		LayoutParams params = getWindow().getAttributes();
		params.width = (int) (outMetrics.widthPixels * 0.67);
		params.height = (int) (outMetrics.heightPixels * 0.41);
		params.gravity = Gravity.CENTER;
		getWindow().setAttributes(params);
		super.show();
	}

}
