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
import com.shian.shianlifezx.activity.EditOrderActivity;
import com.shian.shianlifezx.activity.NewOrderActivity;
import com.shian.shianlifezx.activity.PayActivity;
import com.shian.shianlifezx.common.utils.TArrayListAdapter;
import com.shian.shianlifezx.common.utils.TArrayListAdapter.IOnDrawViewEx;
import com.shian.shianlifezx.common.utils.ViewGropMap;

public class QTView extends BaseOrderView {
	private View v;

	private SwipeRefreshLayout mSryt;
	private ListView mListView;
	private TArrayListAdapter<String> adapter;

	private SwipeRefreshHelper mSwipeRefreshHelper;

	private int page = 0;
	private Handler mHandler = new Handler();

	public QTView(Context context) {
		this(context, null);
	}

	public QTView(Context context, AttributeSet attrs) {
		super(context, attrs);
		v = LayoutInflater.from(context).inflate(R.layout.view_order_qt, null, false);
		addView(v);
		initView();
		initDate();
	}

	private void initView() {
		mSryt = (SwipeRefreshLayout) v.findViewById(R.id.sryt_swipe_listview);
		mListView = (ListView) v.findViewById(R.id.lv_swipe_listview);
		mSryt.setColorSchemeColors(Color.BLUE);
		adapter = new TArrayListAdapter<String>(getContext());
		// v.findViewById(R.id.tv_neworder).setOnClickListener(
		// newOrderClickListener);
		v.findViewById(R.id.tv_neworder1).setOnClickListener(newOrderClickListener);
	}

	private OnClickListener newOrderClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent in = new Intent(getContext(), NewOrderActivity.class);
			getContext().startActivity(in);
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

		mSwipeRefreshHelper.setOnSwipeRefreshListener(new OnSwipeRefreshListener() {
			@Override
			public void onfresh() {
				mHandler.postDelayed(new Runnable() {
					@Override
					public void run() {
						adapter.clear();
						page = 0;
						for (int i = 0; i < 17; i++) {
							adapter.add(new String("  SwipeListView item  -" + i));
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
						adapter.add(new String("  SwipeListView item  - add " + page));
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
		adapter.setLayout(R.layout.view_item_qt);
		adapter.setDrawViewEx(new IOnDrawViewEx<String>() {

			@Override
			public void OnDrawViewEx(Context aContext, String templateItem, ViewGropMap view, int aIndex) {
				TextView tv0 = (TextView) view.getView(R.id.tv_qt01);
				tv0.setText(templateItem);

				TextView tvQT01 = (TextView) view.getView(R.id.tv_qt_item_01);
				TextView tvQT02 = (TextView) view.getView(R.id.tv_qt_item_02);
				TextView tvQT03 = (TextView) view.getView(R.id.tv_qt_item_03);
				TextView tvQT04 = (TextView) view.getView(R.id.tv_qt_item_04);
				TextView tvQT05 = (TextView) view.getView(R.id.tv_qt_item_05);

				tvQT01.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						Intent in = new Intent(getContext(), EditOrderActivity.class);
						getContext().startActivity(in);
					}
				});
				tvQT02.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {

					}
				});
				tvQT03.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {

					}
				});
				tvQT04.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						Intent in = new Intent(getContext(), PayActivity.class);
						getContext().startActivity(in);
					}
				});
				tvQT05.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {

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
