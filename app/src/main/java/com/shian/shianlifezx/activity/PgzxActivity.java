package com.shian.shianlifezx.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper.OnSwipeRefreshListener;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.utils.TArrayListAdapter;
import com.shian.shianlifezx.common.utils.TArrayListAdapter.IOnDrawViewEx;
import com.shian.shianlifezx.common.utils.ViewGropMap;

public class PgzxActivity extends BaseActivity{
	private SwipeRefreshLayout mSryt;
	private ListView mListView;
	private TArrayListAdapter<String> adapter;

	private SwipeRefreshHelper mSwipeRefreshHelper;

	private int page = 0;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_pgzx);
		setTitle("派工执行");initView();initDate();
	}
	
	private void initView() {
		mSryt = (SwipeRefreshLayout) findViewById(R.id.sryt_swipe_listview);
		mListView = (ListView) findViewById(R.id.lv_swipe_listview);
		mSryt.setColorSchemeColors(Color.BLUE);
		adapter = new TArrayListAdapter<String>(this);
		findViewById(R.id.tv_neworder1).setOnClickListener(
				newOrderClickListener);
	}

	private OnClickListener newOrderClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent in = new Intent(PgzxActivity.this, EditOrderActivity.class);
			startActivity(in);
		}
	};

	private void initDate() {
		initAdapter();
		mListView.setAdapter(adapter);
		mSwipeRefreshHelper = new SwipeRefreshHelper(mSryt);

		// mSryt.post(new Runnable() {
		// @Override
		// public void run() {
		// mSwipeRefreshHelper.autoRefresh();
		// }
		// });

		mSwipeRefreshHelper
				.setOnSwipeRefreshListener(new OnSwipeRefreshListener() {
					@Override
					public void onfresh() {
						mHandler.postDelayed(new Runnable() {
							@Override
							public void run() {
								adapter.clear();
								page = 0;
								for (int i = 0; i < 17; i++) {
									adapter.add(new String(
											"  SwipeListView item  -" + i));
								}
								adapter.notifyDataSetChanged();
								mSwipeRefreshHelper.refreshComplete();
								mSwipeRefreshHelper.setLoadMoreEnable(true);
							}
						}, 1000);
					}
				});

		mSwipeRefreshHelper.setOnLoadMoreListener(new OnLoadMoreListener() {
			@Override
			public void loadMore() {
				mHandler.postDelayed(new Runnable() {
					@Override
					public void run() {
						adapter.add(new String("  SwipeListView item  - add "
								+ page));
						adapter.notifyDataSetChanged();
						mSwipeRefreshHelper.loadMoreComplete(true);
						page++;
						// Toast.makeText(SwipeListViewActivity.this,
						// "load more complete", Toast.LENGTH_SHORT)
						// .show();
					}
				}, 1000);
			}
		});
	}

	private void initAdapter() {
		adapter.setLayout(R.layout.view_item_pgzx);
		adapter.setDrawViewEx(new IOnDrawViewEx<String>() {

			@Override
			public void OnDrawViewEx(Context aContext, String templateItem,
					ViewGropMap view, int aIndex) {
				
			}
		});
	}

	public void refresh() {
		mSryt.post(new Runnable() {
			@Override
			public void run() {
				mSwipeRefreshHelper.autoRefresh();
			}
		});
	}
}
