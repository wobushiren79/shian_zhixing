package com.shian.shianlifezx.activity.order;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.contanst.IntentAction;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.view.TipsDialog;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderSavePerformResultBean;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderSavePerformPresenter;
import com.shian.shianlifezx.mvp.order.presenter.impl.StoreOrderSavePerformPresenterImpl;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderSavePerformView;
import com.shian.shianlifezx.mvp.shared.presenter.ISharedGoodsPerformPresenter;
import com.shian.shianlifezx.mvp.shared.presenter.impl.SharedGoodsPerformPresenterImpl;
import com.shian.shianlifezx.mvp.shared.view.ISharedGoodsPerformExecuteView;
import com.shian.shianlifezx.thisenum.GoodsPerformWayEnum;
import com.shian.shianlifezx.view.show.StoreEditNormalView;
import com.shian.shianlifezx.view.show.StoreSpinnerNormalView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class StorePerformInfoActivity extends BaseActivity implements IStoreOrderSavePerformView, RadioGroup.OnCheckedChangeListener, ISharedGoodsPerformExecuteView {
    @InjectView(R.id.perform_name)
    StoreEditNormalView performName;
    @InjectView(R.id.perform_phone)
    StoreEditNormalView performPhone;
    @InjectView(R.id.perform_remark)
    StoreEditNormalView performRemark;
    @InjectView(R.id.ll_perform_info)
    LinearLayout llPerformInfo;

    @InjectView(R.id.courier_company)
    StoreSpinnerNormalView courierCompany;
    @InjectView(R.id.courier_number)
    StoreEditNormalView courierNumber;
    @InjectView(R.id.ll_courier)
    LinearLayout llCourier;

    @InjectView(R.id.rb_perform_1)
    RadioButton rbPerform1;
    @InjectView(R.id.rb_perform_2)
    RadioButton rbPerform2;
    @InjectView(R.id.rb_perform_3)
    RadioButton rbPerform3;
    @InjectView(R.id.rg_perform)
    RadioGroup rgPerform;
    @InjectView(R.id.tv_submit)
    TextView tvSubmit;
    @InjectView(R.id.tv_clear)
    TextView tvClear;

    private IStoreOrderSavePerformPresenter storeOrderSavePerformPresenter;
    private ISharedGoodsPerformPresenter sharedGoodsPerformPresenter;
    private Integer performWay = null;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_perform_info);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {
        setTitle("服务执行");
        rgPerform.setOnCheckedChangeListener(this);
        llPerformInfo.setVisibility(View.GONE);
        llCourier.setVisibility(View.GONE);
        tvSubmit.setVisibility(View.GONE);
        tvClear.setVisibility(View.GONE);
    }

    private void initData() {
        intent = getIntent();
        storeOrderSavePerformPresenter = new StoreOrderSavePerformPresenterImpl(this);
        sharedGoodsPerformPresenter = new SharedGoodsPerformPresenterImpl(this);
        sharedGoodsPerformPresenter.getExecuteData();
        courierCompany.initSpinner(R.array.courier_company);

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.show(this, msg);
    }

    @Override
    public void savePerformInfoSuccess(StoreOrderSavePerformResultBean resultBean) {
        ToastUtils.show(this, "提交成功");
        sharedGoodsPerformPresenter.setExecuteData();
        finish();
        StoreServiceActivity.isRefresh_Change = true;
    }

    @Override
    public void savePerformInfoFail(String msg) {
        ToastUtils.show(this, "提交失败");
    }

    @Override
    public Integer getPerformWay() {
        return performWay;
    }

    @Override
    public String getCourierCompany() {
        return courierCompany.getData();
    }

    @Override
    public String getCourierNumber() {
        return courierNumber.getData();
    }

    @Override
    public Long getOrderId() {
        return intent.getLongExtra(IntentAction.ORDER_ID, -1);
    }

    @Override
    public Long getPerformId() {
        return intent.getLongExtra(IntentAction.PERFORM_ID, -1);
    }

    @Override
    public Long getGoodsItemId() {
        return intent.getLongExtra(IntentAction.GOODS_ITEM_ID, -1);
    }

    @Override
    public String getPerformUserName() {
        return performName.getData();
    }

    @Override
    public String getPerformUserPhone() {
        return performPhone.getData();
    }

    @Override
    public String getPerformComment() {
        return performRemark.getData();
    }

    @Override
    public void getDataFail(String msg) {
        ToastUtils.show(getContext(), msg);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        tvSubmit.setVisibility(View.VISIBLE);
        tvClear.setVisibility(View.VISIBLE);
        if (rbPerform1.getId() == checkedId) {
            performWay = GoodsPerformWayEnum.local_send.getCode();
            llPerformInfo.setVisibility(View.VISIBLE);
            llCourier.setVisibility(View.VISIBLE);
            llCourier.setVisibility(View.GONE);
        } else if (rbPerform2.getId() == checkedId) {
            performWay = GoodsPerformWayEnum.home_send.getCode();
            llPerformInfo.setVisibility(View.VISIBLE);
            llCourier.setVisibility(View.VISIBLE);
            llCourier.setVisibility(View.GONE);
        } else if (rbPerform3.getId() == checkedId) {
            performWay = GoodsPerformWayEnum.express_send.getCode();
            llPerformInfo.setVisibility(View.GONE);
            llCourier.setVisibility(View.GONE);
            llCourier.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public String getExecutorName() {
        return performName.getData();
    }

    @Override
    public String getExecutorPhone() {
        return performPhone.getData();
    }

    @Override
    public void setExecutorName(String name) {
        performName.setData(name);
    }

    @Override
    public void setExecutorPhone(String phone) {
        performPhone.setData(phone);
    }

    @OnClick({R.id.tv_clear, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_clear:
                clear();
                break;
            case R.id.tv_submit:
                submit();
                break;
        }
    }

    private void clear() {
        performPhone.setData("");
        performName.setData("");
        performRemark.setData("");
        courierNumber.setData("");
    }

    private void submit() {
        TipsDialog dialog = new TipsDialog(this);
        dialog.setTop("提醒");
        dialog.setTitle("请确认本表缩填写的服务人员信息和线下服务人员匹配，提交后将不可撤销");
        dialog.setBottomButton("提交", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                storeOrderSavePerformPresenter.savePerformInfo();
            }
        });
        dialog.setTopButton("重新填写", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }


}
