package com.shian.shianlifezx.activity.order;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.view.fileupload.FileUpLoadButton;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class StorePerformCompleteActivity extends BaseActivity {

    @InjectView(R.id.ll_pic)
    LinearLayout llPic;
    @InjectView(R.id.tv_submit)
    TextView tvSubmit;
    private String fileClass;

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
    }


    @OnClick(R.id.tv_submit)
    public void onViewClicked() {
    }
}
