package com.shian.shianlifezx.common.view.store;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.adapter.StoreOrderListApdapter;
import com.shian.shianlifezx.base.BaseOrderListLayout;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderListPresenter;
import com.shian.shianlifezx.mvp.order.presenter.impl.StoreOrderListPresenterImpl;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderListView;
import com.shian.shianlifezx.view.ptr.CustomPtrFramelayout;

import java.util.Arrays;
import java.util.List;

import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by zm.
 */

public class StoreLayout extends BaseOrderListLayout implements IStoreOrderListView, StoreOrderListApdapter.CallBack {

    RecyclerView rcContent;
    CustomPtrFramelayout ptrLayout;

    private CallBack callBack;
    private IStoreOrderListPresenter storeOrderPresenter;
    private List<Integer> status;
    private StoreOrderListApdapter listApdapter;

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
        this.status = Arrays.asList(status);
        initView();
        initData();
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }


    private void initView() {
        rcContent = (RecyclerView) findViewById(R.id.rc_content);
        ptrLayout = (CustomPtrFramelayout) findViewById(R.id.ptr_layout);

        listApdapter = new StoreOrderListApdapter(getContext());
        listApdapter.setCallBack(this);
        rcContent.setAdapter(listApdapter);
        rcContent.setLayoutManager(new LinearLayoutManager(getContext()));
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
    }


    private void initData() {
        storeOrderPresenter = new StoreOrderListPresenterImpl(this);

                         /* 延时100秒,自动刷新 */
        ptrLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrLayout.autoRefresh();
            }
        }, 100);
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
    public void getDataSuccess(StoreOrderListResultBean resultBean) {
        ptrLayout.refreshComplete();
        if (resultBean.getPageNumber() < pageNumber && pageNumber > 1) {
            pageNumber--;
        } else {
            if (pageNumber == 1) {
                listApdapter.setData(resultBean.getContent());
            } else {
                listApdapter.addData(resultBean.getContent());
            }
        }
    }

    @Override
    public void getDataFail(String msg) {
        ptrLayout.refreshComplete();
        pageNumber = pageNumber > 0 ? pageNumber : pageNumber--;
    }

    @Override
    public List<Integer> getStatus() {
        return status;
    }

    @Override
    public void refresh() {
        ptrLayout.autoRefresh();
    }

    @Override
    public void refreshAll() {
        if (callBack != null)
            callBack.refreshAll(this);
    }


    public interface CallBack {
        void refreshAll(View view);
    }

    PtrDefaultHandler2 ptrDefaultHandler2 = new PtrDefaultHandler2() {
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {
            pageNumber++;
            storeOrderPresenter.getStoreOrderListData();
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            pageNumber = 1;
            storeOrderPresenter.getStoreOrderListData();
        }
    };
}
