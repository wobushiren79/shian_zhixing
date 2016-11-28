package com.shian.shianlifezx.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import butterknife.InjectView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.utils.ViewPageAdapter;
import com.shian.shianlifezx.common.view.customer.CustomerGMView;
import com.shian.shianlifezx.common.view.customer.CustomerHTView;
import com.shian.shianlifezx.common.view.customer.CustomerJBRView;
import com.shian.shianlifezx.common.view.customer.CustomerQtView;
import com.shian.shianlifezx.common.view.customer.CustomerSZView;
import com.shian.shianlifezx.common.view.customer.CustomerYBView;
import com.viewpagerindicator.TabPageIndicator;

public class CustomerActivity extends BaseActivity {
	@InjectView(R.id.indicator_customer)
	TabPageIndicator indicator;
	@InjectView(R.id.pager_customer)
	ViewPager viewPager;

	private String[] titles = { "洽谈信息", "逝者信息", "经办人信息", "合同信息", "公墓信息",
			"预备信息", "治丧信息" };

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_customer);  
		setTitle("客户详情");
		initView();
	}

	private void initView() {
		final List<View> views = new ArrayList<View>();
		ViewPageAdapter adapter = new ViewPageAdapter(views) {
			@Override
			public CharSequence getPageTitle(int position) {
				return titles[position];
			}
		};
		initPagerAdapter(views);
		viewPager.setAdapter(adapter);
		indicator.setViewPager(viewPager);
		indicator.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		
	}

	private void initPagerAdapter(List<View> views) {
		for (int i = 0; i < 7; i++) {
			if (i == 0) {
				CustomerQtView qtView = new CustomerQtView(this);
				views.add(qtView);
			} else if (i == 1) {
				CustomerSZView szView = new CustomerSZView(this);
				views.add(szView);
			} else if (i == 2) {
				CustomerJBRView jbrView = new CustomerJBRView(this);
				views.add(jbrView);
			} else if (i == 3) {
				CustomerHTView htView = new CustomerHTView(this);
				views.add(htView);
			} else if (i == 4) {
				CustomerGMView gmView = new CustomerGMView(this);
				views.add(gmView);
			} else if (i == 5) {
				CustomerYBView ybView = new CustomerYBView(this);
				views.add(ybView);
			} else if (i == 6) {
				CustomerYBView ybView1 = new CustomerYBView(this);
				views.add(ybView1);
			}
		}
	}
}
