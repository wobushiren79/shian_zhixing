package com.shian.shianlifezx.common.view.store;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseOrderListLayout;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderResultBean;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderPresenter;
import com.shian.shianlifezx.mvp.order.presenter.impl.StoreOrderPresenterImpl;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderView;
import com.shian.shianlifezx.view.ptr.CustomPtrFramelayout;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by zm.
 */

public class StoreLayout extends BaseOrderListLayout implements IStoreOrderView {


    @InjectView(R.id.rc_content)
    RecyclerView rcContent;
    @InjectView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;

    private CallBack callBack;
    private IStoreOrderPresenter storeOrderPresenter;
    private List<Integer> status;

    private int pageSize = 10;
    private int pageNumber = 1;


    public StoreLayout(Context context, List<Integer> status) {
        super(context, R.layout.layout_store_order);
        this.status = status;
        initView();
        initData();
    }

    public StoreLayout(Context context, Integer[] status) {
        super(context, R.layout.layout_store_order);
        this.status= Arrays.asList(status);
        initView();
        initData();
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }


    private void initView() {

    }


    private void initData() {
        storeOrderPresenter = new StoreOrderPresenterImpl(this);
        storeOrderPresenter.getStoreOrderListData();
    }

    @Override
    public void refesh() {

    }

    @Override
    protected void refeshAll() {

    }


    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public void getDataSuccess(StoreOrderResultBean resultBean) {

    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public List<Integer> getStatus() {
        return status;
    }


    public interface CallBack {
        void refeshAll();
    }
}
