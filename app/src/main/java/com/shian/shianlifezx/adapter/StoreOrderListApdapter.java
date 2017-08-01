package com.shian.shianlifezx.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.adapter.base.BaseRCAdapter;
import com.shian.shianlifezx.adapter.base.BaseViewHolder;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderAcceptPresenter;
import com.shian.shianlifezx.mvp.order.presenter.impl.StoreOrderAcceptPresenterImpl;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderAcceptView;
import com.shian.shianlifezx.thisenum.GoodsPerformStatusEnum;
import com.shian.shianlifezx.thisenum.GoodsServiceWayEnum;

/**
 * Created by zm.
 */

public class StoreOrderListApdapter extends BaseRCAdapter<StoreOrderListResultBean.Content> implements IStoreOrderAcceptView {
    private IStoreOrderAcceptPresenter storeOrderAcceptPresenter;
    private CallBack callBack;

    /**
     * 单布局初始化
     *
     * @param context
     */
    public StoreOrderListApdapter(Context context) {
        super(context, R.layout.layout_store_order_list_item);
        storeOrderAcceptPresenter = new StoreOrderAcceptPresenterImpl(this);
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void convert(BaseViewHolder holder, StoreOrderListResultBean.Content data, final int index) {
        TextView tvGoodsName = holder.getView(R.id.tv_goods_name);
        TextView tvOrderNum = holder.getView(R.id.tv_order_num);
        TextView tvGoodsDetails = holder.getView(R.id.tv_goods_details);
        TextView tvCustomerName = holder.getView(R.id.tv_customer_name);
        TextView tvServiceTime = holder.getView(R.id.tv_service_time);
        TextView tvServiceLocation = holder.getView(R.id.tv_service_location);

        final TextView tvOrderCompleteMore = holder.getView(R.id.tv_order_complete_more);
        final TextView tvOrderDetails = holder.getView(R.id.tv_order_details);
        final TextView tvOrderComplete = holder.getView(R.id.tv_order_complete);
        final TextView tvOrderStart = holder.getView(R.id.tv_order_start);
        final TextView tvOrderReject = holder.getView(R.id.tv_order_reject);
        final TextView tvOrderAccept = holder.getView(R.id.tv_order_accept);

        ImageView ivOrderMore = holder.getView(R.id.iv_order_more);
        LinearLayout llContent = holder.getView(R.id.ll_content);
        LinearLayout llCustomerPhone = holder.getView(R.id.ll_customer_phone);
        LinearLayout llCustomerLocation = holder.getView(R.id.ll_customer_location);
        if (data.getGoodsPerform() == null) {
            return;
        }
        if (data.getGoodsOrderItem() == null) {
            return;
        }
        if (data.getGoodsOrder() == null) {
            return;
        }
        if (data.getGoodsServiceInfo() == null) {
            return;
        }
        tvOrderNum.setVisibility(View.VISIBLE);
        tvCustomerName.setVisibility(View.VISIBLE);
        ivOrderMore.setVisibility(View.VISIBLE);
        tvOrderAccept.setVisibility(View.GONE);
        tvOrderReject.setVisibility(View.GONE);
        llCustomerPhone.setVisibility(View.VISIBLE);
        llCustomerLocation.setVisibility(View.VISIBLE);
        //商品属性名称
        tvGoodsName.setText(data.getGoodsOrderItem().getSpecOrderedAttr());
        //订单编号
        tvOrderNum.setText(data.getGoodsOrder().getOrderNumber());
        //商品名称 规格 及数量
        tvGoodsDetails.setText(data.getGoodsOrderItem().getSpecOrderedVolume()
                + "(" + data.getGoodsOrderItem().getSpecAlias() + ")"
                + " x" + data.getGoodsOrderItem().getSpecOrderedNum());
        //及时服务或预约服务时间
        int serviceType = data.getGoodsServiceInfo().getServiceWay();
        String serviceTime = "";
        if (serviceType == GoodsServiceWayEnum.now_service.getCode()) {
            serviceTime = data.getGoodsServiceInfo().getCreatedAt();
        } else if (serviceType == GoodsServiceWayEnum.plan_service.getCode()) {
            serviceTime = data.getGoodsServiceInfo().getBookTime();
        }
        String serviceTypeName = GoodsServiceWayEnum.getValueText(serviceType);
        tvServiceTime.setText(serviceTypeName + " : " + serviceTime);
        //客户姓名
        tvCustomerName.setText("客戶姓名 : "+data.getGoodsOrder().getCustomerName());
        //服务地址
        tvServiceLocation.setText("服务地址 : " + data.getGoodsServiceInfo().getServiceLocation());

        //根据订单状态变化
        int performStatus = data.getGoodsPerform().getPerformStatus();
        if (performStatus == GoodsPerformStatusEnum.hasassign.getCode()) {
            tvOrderNum.setVisibility(View.GONE);
            tvCustomerName.setVisibility(View.GONE);
            ivOrderMore.setVisibility(View.GONE);
            tvOrderAccept.setVisibility(View.VISIBLE);
            tvOrderReject.setVisibility(View.VISIBLE);
            llCustomerPhone.setVisibility(View.INVISIBLE);
            llCustomerLocation.setVisibility(View.INVISIBLE);
        } else if (performStatus == GoodsPerformStatusEnum.waitexecute.getCode()) {


        } else if (performStatus == GoodsPerformStatusEnum.executeing.getCode()) {


        } else if (performStatus == GoodsPerformStatusEnum.auditing.getCode()) {


        } else if (performStatus == GoodsPerformStatusEnum.success.getCode()) {


        } else if (performStatus == GoodsPerformStatusEnum.auditfail.getCode()) {


        } else if (performStatus == GoodsPerformStatusEnum.cancel.getCode()) {


        } else {
            tvGoodsName.setText("数据错误");
            tvOrderNum.setVisibility(View.GONE);
            tvCustomerName.setVisibility(View.GONE);
            ivOrderMore.setVisibility(View.GONE);
            llCustomerPhone.setVisibility(View.INVISIBLE);
            llCustomerLocation.setVisibility(View.INVISIBLE);
        }

        //点击事件
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == tvOrderAccept) {
                    storeOrderAcceptPresenter.acceptStoreOrder(index);
                } else if (v == tvOrderReject) {
                    ToastUtils.show(mContext, "judan");
                }
            }
        };
        tvOrderAccept.setOnClickListener(onClickListener);
        tvOrderReject.setOnClickListener(onClickListener);


    }

    @Override
    public Context getContent() {
        return mContext;
    }

    @Override
    public Long getOrderId(int index) {
        return mDatas.get(index).getGoodsPerform().getOrderId();
    }

    @Override
    public Long getGoodsItemId(int index) {
        return mDatas.get(index).getGoodsPerform().getGoodsItemId();
    }

    @Override
    public void acceptSuccess(StoreOrderAcceptResultBean resultBean) {
        if (callBack != null)
            callBack.refresh();
        ToastUtils.show(mContext, "接单成功");
    }

    @Override
    public void acceptFail(String msg) {
        ToastUtils.show(mContext, "接单失败");
    }

    public interface CallBack {
        void refresh();

        void refreshAll();
    }
}
