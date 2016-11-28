package com.shian.shianlifezx.common.view.order;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper.OnSwipeRefreshListener;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.CustomerActivity;
import com.shian.shianlifezx.activity.PayShouActivity;
import com.shian.shianlifezx.common.utils.TArrayListAdapter;
import com.shian.shianlifezx.common.utils.TArrayListAdapter.IOnDrawViewEx;
import com.shian.shianlifezx.common.utils.ViewGropMap;

public class CommonView extends BaseOrderView {
	private SwipeRefreshLayout mSryt;
	private ListView mListView;
	private TArrayListAdapter<String> adapter;

	private SwipeRefreshHelper mSwipeRefreshHelper;

	private int page = 0;
	private Handler mHandler = new Handler();
	private View v;

	public CommonView(Context context) {
		this(context, null);
	}

	public CommonView(Context context, AttributeSet attrs) {
		super(context, attrs);
		v = LayoutInflater.from(context).inflate(R.layout.view_order_common,
				null, false);
		addView(v);
		initView();
		initDate();
	}

	private void initView() {
		mSryt = (SwipeRefreshLayout) v.findViewById(R.id.sryt_swipe_listview);
		mListView = (ListView) v.findViewById(R.id.lv_swipe_listview);
		mSryt.setColorSchemeColors(Color.BLUE);
		adapter = new TArrayListAdapter<String>(getContext());
	}

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
		adapter.setLayout(R.layout.view_item_common);
		adapter.setDrawViewEx(new IOnDrawViewEx<String>() {

			@Override
			public void OnDrawViewEx(Context aContext, String templateItem,
					ViewGropMap view, int aIndex) {
				TextView tv0 = (TextView) view.getView(R.id.tv_qt01);
				TextView tvItem0 = (TextView) view
						.getView(R.id.tv_common_item0);
				TextView tvItem1 = (TextView) view
						.getView(R.id.tv_common_item1);
				TextView tvItem2 = (TextView) view
						.getView(R.id.tv_common_item2);
				TextView tvItem3 = (TextView) view
						.getView(R.id.tv_common_item3);
				TextView tvItem4 = (TextView) view
						.getView(R.id.tv_common_item4);
				tv0.setText(templateItem);
				tvItem0.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

					}
				});
				tvItem1.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

					}
				});
				tvItem2.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

					}
				});
				tvItem3.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent in = new Intent(getContext(),
								CustomerActivity.class);
						getContext().startActivity(in);
					}
				});
				tvItem4.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent in = new Intent(getContext(),
								PayShouActivity.class);
						getContext().startActivity(in);
					}
				});
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

	@Override
	public void refresh(int paramInt) {
		refresh();		
	}

}
