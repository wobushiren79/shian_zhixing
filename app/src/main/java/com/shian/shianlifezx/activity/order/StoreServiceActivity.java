package com.shian.shianlifezx.activity.order;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.adapter.StoreOrderViewPagerAdapter;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.view.store.StoreLayout;
import com.shian.shianlifezx.listener.StoreOrderPagerChangeListener;
import com.shian.shianlifezx.thisenum.GoodsPerformStatusEnum;
import com.shian.shianlifezx.thisenum.StoreOrderListEnum;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class StoreServiceActivity extends BaseActivity implements StoreLayout.CallBack {

    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;

    private StoreOrderListEnum[] mStoreOrderListEna;
    private StoreOrderViewPagerAdapter mStoreAdapter;
    private StoreOrderPagerChangeListener mPagerListener;
    private List<View> viewList;

    public static boolean isRefresh_Change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_service);
        ButterKnife.inject(this);
        setTitle(getString(R.string.store_order_base_title));
        initView();
        initData();
    }

    private void initData() {
        mStoreOrderListEna = new StoreOrderListEnum[]{
                StoreOrderListEnum.waitservice,
                StoreOrderListEnum.inservice,
                StoreOrderListEnum.inaduit,
                StoreOrderListEnum.successservice,
                StoreOrderListEnum.nosuccess,
                StoreOrderListEnum.cancel
        };
        viewList = new ArrayList<>();


        StoreLayout waitServiceLayout = new StoreLayout
                (this, new Integer[]{
                        GoodsPerformStatusEnum.waitassign.getCode(),
                        GoodsPerformStatusEnum.hasassign.getCode(),
                        GoodsPerformStatusEnum.waitexecute.getCode()
                });
        viewList.add(waitServiceLayout);

        StoreLayout inServiceLayout = new StoreLayout
                (this, new Integer[]{
                        GoodsPerformStatusEnum.executeing.getCode()
                });
        viewList.add(inServiceLayout);

        StoreLayout inAduitLayout = new StoreLayout
                (this, new Integer[]{
                        GoodsPerformStatusEnum.auditing.getCode()
                });
        viewList.add(inAduitLayout);

        StoreLayout successServiceLayout = new StoreLayout
                (this, new Integer[]{
                        GoodsPerformStatusEnum.success.getCode()
                });
        viewList.add(successServiceLayout);

        StoreLayout noSuccessLayout = new StoreLayout
                (this, new Integer[]{
                        GoodsPerformStatusEnum.auditfail.getCode()
                });
        viewList.add(noSuccessLayout);

        StoreLayout cancelLayout = new StoreLayout
                (this, new Integer[]{
                        GoodsPerformStatusEnum.cancel.getCode()
                });
        viewList.add(cancelLayout);

        for (View item : viewList) {
            StoreLayout st = (StoreLayout) item;
            st.setCallBack(this);
        }

        mStoreAdapter = new StoreOrderViewPagerAdapter(this, viewList);
        mPagerListener = new StoreOrderPagerChangeListener();
        viewpager.setAdapter(mStoreAdapter);
        viewpager.addOnPageChangeListener(mPagerListener);
        tablayout.setupWithViewPager(viewpager);

        for (int i = 0; i < mStoreOrderListEna.length; i++) {
            tablayout.getTabAt(i).setText(mStoreOrderListEna[i].getName());
        }
    }

    private void initView() {
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout.setTabGravity(TabLayout.GRAVITY_CENTER);
    }

    @Override
    public void refreshAll(View view) {
        for (View item : viewList) {
            StoreLayout st = (StoreLayout) item;
            st.refresh();
        }
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        if (viewList.size() > 0 && isRefresh_Change) {
            refreshAll(null);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        isRefresh_Change = false;
    }
}
