package com.shian.shianlifezx.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.ImagePreviewActivity;
import com.shian.shianlifezx.activity.order.StorePerformCompleteActivity;
import com.shian.shianlifezx.activity.order.StorePerformInfoActivity;
import com.shian.shianlifezx.adapter.base.BaseRCAdapter;
import com.shian.shianlifezx.adapter.base.BaseViewHolder;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.contanst.IntentAction;
import com.shian.shianlifezx.common.utils.IntentName;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.utils.Utils;
import com.shian.shianlifezx.common.view.TipsDialog;
import com.shian.shianlifezx.mvp.order.bean.GoodsExpress;
import com.shian.shianlifezx.mvp.order.bean.GoodsOrder;
import com.shian.shianlifezx.mvp.order.bean.GoodsOrderItem;
import com.shian.shianlifezx.mvp.order.bean.GoodsPerform;
import com.shian.shianlifezx.mvp.order.bean.GoodsPerformCancel;
import com.shian.shianlifezx.mvp.order.bean.GoodsServiceInfo;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderAcceptResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderGetPerformResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderListResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderNotPassReasonResultBean;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformBean;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderAcceptPresenter;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderGetPerformPresenter;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderNotPassReasonPresenter;
import com.shian.shianlifezx.mvp.order.presenter.impl.StoreOrderAcceptPresenterImpl;
import com.shian.shianlifezx.mvp.order.presenter.impl.StoreOrderGetPerformPresenterImpl;
import com.shian.shianlifezx.mvp.order.presenter.impl.StoreOrderNotPassReasonPresenterImpl;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderAcceptView;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderGetPerformView;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderNotPassReasonView;
import com.shian.shianlifezx.thisenum.GoodsOrderChannelEnum;
import com.shian.shianlifezx.thisenum.GoodsPerformStatusEnum;
import com.shian.shianlifezx.thisenum.GoodsPerformWayEnum;
import com.shian.shianlifezx.thisenum.GoodsServiceWayEnum;
import com.shian.shianlifezx.view.dialog.DataShowDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zm.
 */

public class StoreOrderListApdapter extends BaseRCAdapter<StoreOrderListResultBean.Content> implements IStoreOrderAcceptView, IStoreOrderGetPerformView, IStoreOrderNotPassReasonView {
    private IStoreOrderAcceptPresenter storeOrderAcceptPresenter;
    private IStoreOrderGetPerformPresenter storeOrderGetPerformPresenter;
    private IStoreOrderNotPassReasonPresenter storeOrderNotPassReasonPresenter;
    private CallBack callBack;

    /**
     * 单布局初始化
     *
     * @param context
     */
    public StoreOrderListApdapter(Context context) {
        super(context, R.layout.layout_store_order_list_item);
        storeOrderAcceptPresenter = new StoreOrderAcceptPresenterImpl(this);
        storeOrderGetPerformPresenter = new StoreOrderGetPerformPresenterImpl(this);
        storeOrderNotPassReasonPresenter = new StoreOrderNotPassReasonPresenterImpl(this);
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void convert(BaseViewHolder holder, final StoreOrderListResultBean.Content data, final int index) {
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
        final TextView tvOrderCancel = holder.getView(R.id.tv_order_cancel);

        final ImageView ivOrderMore = holder.getView(R.id.iv_order_more);
        final LinearLayout llContent = holder.getView(R.id.ll_content);
        final LinearLayout llCustomerPhone = holder.getView(R.id.ll_customer_phone);
        final LinearLayout llCustomerLocation = holder.getView(R.id.ll_customer_location);
        final LinearLayout llCounselorPhone = holder.getView(R.id.ll_counselor_phone);
        final LinearLayout llGoodsPic = holder.getView(R.id.ll_goods_pic);

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
        final GoodsPerform goodsPerform = data.getGoodsPerform();
        GoodsOrderItem goodsOrderItem = data.getGoodsOrderItem();
        GoodsOrder goodsOrder = data.getGoodsOrder();
        GoodsServiceInfo goodsServiceInfo = data.getGoodsServiceInfo();

        tvOrderNum.setVisibility(View.VISIBLE);
        tvCustomerName.setVisibility(View.VISIBLE);
        ivOrderMore.setVisibility(View.VISIBLE);
        tvOrderAccept.setVisibility(View.GONE);
        tvOrderReject.setVisibility(View.GONE);
        llCustomerPhone.setVisibility(View.VISIBLE);
        llCustomerLocation.setVisibility(View.GONE);
        llCounselorPhone.setVisibility(View.VISIBLE);
        llGoodsPic.setVisibility(View.VISIBLE);
        tvOrderStart.setVisibility(View.GONE);
        tvOrderComplete.setVisibility(View.GONE);
        tvOrderDetails.setVisibility(View.GONE);
        tvOrderCompleteMore.setVisibility(View.GONE);
        tvOrderCancel.setVisibility(View.GONE);

        //商品属性名称
        tvGoodsName.setText(goodsOrderItem.getSpecOrderedAttr());
        //订单编号
        tvOrderNum.setText("订单编号 : " + goodsOrder.getOrderNumber());
        //商品名称 规格 及数量
        tvGoodsDetails.setText(goodsOrderItem.getSpecOrderedVolume()
                + "(" + goodsOrderItem.getSpecName() + ")"
                + " x" + goodsOrderItem.getSpecOrderedNum());
        //及时服务或预约服务时间
        int serviceType = goodsServiceInfo.getServiceWay();
        String serviceTime = "";
        if (serviceType == GoodsServiceWayEnum.now_service.getCode()) {
            serviceTime = goodsServiceInfo.getCreatedAt();
        } else if (serviceType == GoodsServiceWayEnum.plan_service.getCode()) {
            serviceTime = goodsServiceInfo.getBookTime();
        }
        String serviceTypeName = GoodsServiceWayEnum.getValueText(serviceType);
        tvServiceTime.setText(serviceTypeName + " : " + serviceTime);
        //客户姓名
        tvCustomerName.setText("客戶姓名 : " + goodsOrder.getCustomerName());
        //服务地址
        tvServiceLocation.setText("服务地址 : " + goodsServiceInfo.getServiceLocation());
        //电话设置
        Utils.call(llCustomerPhone, goodsOrder.getCustomerPhone());
        Utils.call(llCounselorPhone, data.getCreatedPhone());
        if (goodsOrder.getOrderChannel() == GoodsOrderChannelEnum.wechat.getCode()) {
            llCounselorPhone.setVisibility(View.GONE);
        }
        //根据订单状态变化
        final int performStatus = goodsPerform.getPerformStatus();
        if (performStatus == GoodsPerformStatusEnum.hasassign.getCode()) {
            tvOrderNum.setVisibility(View.GONE);
            tvCustomerName.setVisibility(View.GONE);
            ivOrderMore.setVisibility(View.GONE);
            tvOrderAccept.setVisibility(View.VISIBLE);
            tvOrderReject.setVisibility(View.VISIBLE);
            llCustomerPhone.setVisibility(View.GONE);
        } else if (performStatus == GoodsPerformStatusEnum.waitexecute.getCode()) {
            tvOrderStart.setVisibility(View.VISIBLE);
        } else if (performStatus == GoodsPerformStatusEnum.executeing.getCode()) {
            tvOrderComplete.setVisibility(View.VISIBLE);
            tvOrderDetails.setVisibility(View.VISIBLE);
        } else if (performStatus == GoodsPerformStatusEnum.auditing.getCode()) {
            tvOrderDetails.setVisibility(View.VISIBLE);
        } else if (performStatus == GoodsPerformStatusEnum.success.getCode()) {


        } else if (performStatus == GoodsPerformStatusEnum.auditfail.getCode()) {
            tvOrderDetails.setVisibility(View.VISIBLE);
            tvOrderCompleteMore.setVisibility(View.VISIBLE);
        } else if (performStatus == GoodsPerformStatusEnum.cancel.getCode()) {
            tvOrderCancel.setVisibility(View.VISIBLE);

        } else {
            tvGoodsName.setText("数据错误");
            tvOrderNum.setVisibility(View.GONE);
            tvCustomerName.setVisibility(View.GONE);
            ivOrderMore.setVisibility(View.GONE);
            llCustomerPhone.setVisibility(View.INVISIBLE);
            llCustomerLocation.setVisibility(View.INVISIBLE);
            tvOrderStart.setVisibility(View.GONE);
        }

        //点击事件
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == tvOrderAccept) {
                    storeOrderAcceptPresenter.acceptStoreOrder(index);
                } else if (v == tvOrderReject) {
                    ToastUtils.show(mContext, "暂时没有拒单功能");
                } else if (v == tvOrderStart) {
                    orderStart(data);
                } else if (v == llContent) {
                    orderMore(data);
                } else if (v == tvOrderDetails) {
                    storeOrderGetPerformPresenter.getPerformInfo(index);
                } else if (v == tvOrderComplete) {
                    orderComplete(data);
                } else if (v == tvOrderCompleteMore) {
                    orderComplete(data);
                } else if (v == tvOrderCancel) {
                    cancelResaon(data);
                } else if (v == llGoodsPic) {
                    showPic(data);
                }
            }


        };

        tvOrderAccept.setOnClickListener(onClickListener);
        tvOrderReject.setOnClickListener(onClickListener);
        tvOrderStart.setOnClickListener(onClickListener);
        llContent.setOnClickListener(onClickListener);
        tvOrderDetails.setOnClickListener(onClickListener);
        tvOrderComplete.setOnClickListener(onClickListener);
        tvOrderCompleteMore.setOnClickListener(onClickListener);
        tvOrderCancel.setOnClickListener(onClickListener);
        llGoodsPic.setOnClickListener(onClickListener);
    }

    /**
     * 展示图片
     */
    private void showPic(StoreOrderListResultBean.Content data) {
        Intent intent = new Intent(getContext(), ImagePreviewActivity.class);
        intent.putExtra(IntentName.INTENT_URL, data.getGoodsOrderItem().getTitleImg());
        getContext().startActivity(intent);
    }

    /**
     * 交易关闭原因
     *
     * @param data
     */
    private void cancelResaon(StoreOrderListResultBean.Content data) {
        GoodsPerformCancel goodsPerformCancel = data.getGoodsPerformCancel();
        if (goodsPerformCancel == null) {
            ToastUtils.show(getContext(), "没有关闭原因");
            return;
        }
        String reason = "无";
        if (goodsPerformCancel.getCancelReason() != null && !goodsPerformCancel.getCancelReason().isEmpty()) {
            reason = goodsPerformCancel.getCancelReason();
        }
        TipsDialog dialog = new TipsDialog(mContext);
        dialog.setTitle(reason);
        dialog.setTop("交易关闭原因");
        dialog.setBottomButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    /**
     * 审核失败原因
     */
    private void orderNoPassReason(String resaon) {
        TipsDialog dialog = new TipsDialog(mContext);
        dialog.setTitle(resaon);
        dialog.setTop("审核失败原因");
        dialog.setBottomButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    //完成
    private void orderComplete(StoreOrderListResultBean.Content data) {
        Intent intent = new Intent(mContext, StorePerformCompleteActivity.class);
        intent.putExtra(IntentAction.ORDER_ID, data.getGoodsPerform().getOrderId());
        intent.putExtra(IntentAction.PERFORM_ID, data.getGoodsPerform().getId());
        intent.putExtra(IntentAction.GOODS_ITEM_ID, data.getGoodsPerform().getGoodsItemId());
        mContext.startActivity(intent);
    }

    //开始执行
    private void orderStart(StoreOrderListResultBean.Content data) {
        Intent intent = new Intent(mContext, StorePerformInfoActivity.class);
        intent.putExtra(IntentAction.ORDER_ID, data.getGoodsPerform().getOrderId());
        intent.putExtra(IntentAction.PERFORM_ID, data.getGoodsPerform().getId());
        intent.putExtra(IntentAction.GOODS_ITEM_ID, data.getGoodsPerform().getGoodsItemId());
        intent.putExtra(IntentAction.PERFORM_USER_ID, data.getGoodsPerform().getPerformUserId());
        mContext.startActivity(intent);
    }

    //更多信息
    private void orderMore(StoreOrderListResultBean.Content data) {
        if (data.getGoodsPerform().getPerformStatus() == GoodsPerformStatusEnum.auditfail.getCode()) {
            storeOrderNotPassReasonPresenter.getNotPassReason(data.getGoodsPerform().getId());
        } else {
            if (data.getGoodsOrder().getOrderComment() == null) {
                ToastUtils.show(mContext, "暂无订单备注");
                return;
            }
            TipsDialog dialog = new TipsDialog(mContext);
            dialog.setTitle(data.getGoodsOrder().getOrderComment());
            dialog.setTop("订单备注");
            dialog.setBottomButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
        }
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.show(mContext, msg);
    }

    @Override
    public Long getPerformId(int index) {
        return mDatas.get(index).getGoodsPerform().getId();
    }

    @Override
    public void getPerformInfoSuccess(StoreOrderGetPerformResultBean resultBean) {
        List<DataShowDialog.DataShowDialogResultBean> listData = new ArrayList<>();
        if (resultBean.getGoodsPerform() != null) {
            GoodsPerform goodsPerform = resultBean.getGoodsPerform();
            listData.add(new DataShowDialog.DataShowDialogResultBean("执行方式", GoodsPerformWayEnum.getValueText(goodsPerform.getPerformWay())));
            listData.add(new DataShowDialog.DataShowDialogResultBean("执行人姓名", goodsPerform.getPerformUserName()));
            listData.add(new DataShowDialog.DataShowDialogResultBean("执行人电话", goodsPerform.getPerformUserPhone()));
            listData.add(new DataShowDialog.DataShowDialogResultBean("备注", goodsPerform.getPerformComment()));
        }
        if (resultBean.getGoodsExpress() != null) {
            GoodsExpress goodsExpress = resultBean.getGoodsExpress();
            listData.add(new DataShowDialog.DataShowDialogResultBean("快递公司", goodsExpress.getExpressName()));
            listData.add(new DataShowDialog.DataShowDialogResultBean("快递单号", goodsExpress.getDeliveryNumber()));
        }

        DataShowDialog dataShowDialog = new DataShowDialog(getContext());
        dataShowDialog.setTitle("执行信息");
        dataShowDialog.setData(listData);
        dataShowDialog.setCancelOnClick(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dataShowDialog.show();
    }

    @Override
    public void getPerformInfoFail(String msg) {
        ToastUtils.show(mContext, msg);
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


    @Override
    public void getPassReasonSuccess(StoreOrderNotPassReasonResultBean resultBean) {
        if (resultBean.getAuditInfo() != null)
            orderNoPassReason(resultBean.getAuditInfo());
        else {
            orderNoPassReason("暂无审核信息");
        }
    }

    @Override
    public void getPassReasonFail(String msg) {
        ToastUtils.show(mContext, msg);
    }

    public interface CallBack {
        void refresh();

        void refreshAll();
    }
}
