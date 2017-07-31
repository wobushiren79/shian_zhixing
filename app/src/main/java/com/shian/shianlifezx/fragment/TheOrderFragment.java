package com.shian.shianlifezx.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.adapter.OrderShowListAdapter;
import com.shian.shianlifezx.base.BaseFragment;
import com.shian.shianlifezx.mvp.order.bean.OrderShowResultBean;
import com.shian.shianlifezx.mvp.order.presenter.IOrderShowPresenter;
import com.shian.shianlifezx.mvp.order.presenter.impl.OrderShowPresenterImpl;
import com.shian.shianlifezx.mvp.order.view.IOrderShowView;


/**
 * Created by zm.
 */

public class TheOrderFragment extends BaseFragment implements IOrderShowView {

    RecyclerView rcContent;


    private View mBaseLayout;
    private OrderShowListAdapter mShowListAdapter;
    private IOrderShowPresenter orderShowPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseLayout = inflater.inflate(R.layout.fragment_theorder, null, false);
        initView();
        initData();
        return mBaseLayout;
    }


    private void initView() {
        rcContent = (RecyclerView) mBaseLayout.findViewById(R.id.rc_content);
        rcContent.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mShowListAdapter = new OrderShowListAdapter(getContext());
        rcContent.setAdapter(mShowListAdapter);
    }


    private void initData() {
        orderShowPresenter = new OrderShowPresenterImpl(this);
        orderShowPresenter.getOrderShowItem();
    }


    @Override
    public void showOrderItems(OrderShowResultBean resultBean) {
        mShowListAdapter.setData(resultBean.getList());
    }
}
