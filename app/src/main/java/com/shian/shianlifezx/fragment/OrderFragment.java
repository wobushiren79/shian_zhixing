package com.shian.shianlifezx.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseFragment;
import com.shian.shianlifezx.common.utils.ViewPageAdapter;
import com.shian.shianlifezx.common.view.order.BaseOrderView;
import com.shian.shianlifezx.common.view.order.ListItemView;
import com.viewpagerindicator.TabPageIndicator;

public class OrderFragment extends BaseFragment {
	@InjectView(R.id.indicator)
	TabPageIndicator indicator;
	@InjectView(R.id.pager)
	ViewPager viewPager;
	private View v;

	private String[] titles = { "待执行", "正在执行", "待审核", "成功服务", "未通过" };
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_order, null, false);
		ButterKnife.inject(this, v);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (views.size() > 0) {
			((BaseOrderView) views.get(mINdex)).refresh(mINdex);
		}
	}

	private int mINdex;
	List<View> views;

	private void initView() {
		views = new ArrayList<View>();
		ViewPageAdapter adapter = new ViewPageAdapter(views) {
			@Override
			public CharSequence getPageTitle(int position) {
				// TODO Auto-generated method stub
				return titles[position];
			}
		};
		initPagerAdapter(views);
		viewPager.setAdapter(adapter);
		indicator.setViewPager(viewPager);
		indicator.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				mINdex = arg0;
				BaseOrderView orderView = (BaseOrderView) views.get(arg0);
				orderView.refresh(arg0);
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
		for (int i = 0; i < 5; i++) {
			ListItemView qtView = new ListItemView(getActivity());
			views.add(qtView);
		}
	}
}
