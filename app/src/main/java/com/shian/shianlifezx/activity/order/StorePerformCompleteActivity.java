package com.shian.shianlifezx.activity.order;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.contanst.IntentAction;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.view.TipsDialog;
import com.shian.shianlifezx.mvp.order.bean.StoreOrderPerformCompleteResultBean;
import com.shian.shianlifezx.mvp.order.presenter.IStoreOrderPerformCompletePresenter;
import com.shian.shianlifezx.mvp.order.presenter.impl.StoreOrderPerformCompletePresenterImpl;
import com.shian.shianlifezx.mvp.order.view.IStoreOrderPerformCompleteView;
import com.shian.shianlifezx.view.fileupload.FileUpLoadButton;
import com.shian.shianlifezx.view.show.StoreEditNormalView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class StorePerformCompleteActivity extends BaseActivity implements IStoreOrderPerformCompleteView {

    @InjectView(R.id.ll_pic)
    LinearLayout llPic;
    @InjectView(R.id.tv_submit)
    TextView tvSubmit;
    @InjectView(R.id.complete_content)
    StoreEditNormalView completeContent;

    private String fileClass;
    private IStoreOrderPerformCompletePresenter storeOrderPerformCompletePresenter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_perform_complete);
        ButterKnife.inject(this);

        initView();
        initData();
    }

    private void initView() {
        fileClass = "originFileName";
        FileUpLoadButton fileUpLoadButton_1 = new FileUpLoadButton(this, fileClass, fileClass);
        FileUpLoadButton fileUpLoadButton_2 = new FileUpLoadButton(this, fileClass, fileClass);
        FileUpLoadButton fileUpLoadButton_3 = new FileUpLoadButton(this, fileClass, fileClass);
        llPic.addView(fileUpLoadButton_1);
        llPic.addView(fileUpLoadButton_2);
        llPic.addView(fileUpLoadButton_3);
    }

    private void initData() {
        setTitle("提交完成");
        intent = getIntent();
        storeOrderPerformCompletePresenter = new StoreOrderPerformCompletePresenterImpl(this);
    }


    @OnClick(R.id.tv_submit)
    public void onViewClicked() {
        TipsDialog dialog = new TipsDialog(this);
        dialog.setTop("提醒");
        dialog.setTitle("请确认服务是否完成，所提交的内容是否符合服务标准的要求");
        dialog.setBottomButton("确认提交", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                storeOrderPerformCompletePresenter.saveStorePerformComplete();
            }
        });
        dialog.setTopButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void savePerformCompleteSuccess(StoreOrderPerformCompleteResultBean resultBean) {
        ToastUtils.show(this, "提交成功");
        finish();
        StoreServiceActivity.isRefresh_Change = true;
    }

    @Override
    public void savePerformCompleteFail(String msg) {
        ToastUtils.show(this, "提交失败");
    }

    @Override
    public Long getPerformId() {
        return intent.getLongExtra(IntentAction.PERFORM_ID, -1);
    }

    @Override
    public String getPerformCompletePic() {
        StringBuffer pic = new StringBuffer();
        for (int i = 0; i < llPic.getChildCount(); i++) {
            FileUpLoadButton fileUpLoadButton = (FileUpLoadButton) llPic.getChildAt(i);
            if (fileUpLoadButton.getFileUrl() != null && !fileUpLoadButton.getFileUrl().isEmpty()) {
                if (pic.length() != 0)
                    pic.append(",");
                pic.append(fileUpLoadButton.getFileUrl());
            }
        }
        return pic.toString();
    }

    @Override
    public String getPerformCompleteContent() {
        return completeContent.getData();
    }

    @Override
    public void getDataFail(String msg) {
        ToastUtils.show(this, msg);
    }
}
