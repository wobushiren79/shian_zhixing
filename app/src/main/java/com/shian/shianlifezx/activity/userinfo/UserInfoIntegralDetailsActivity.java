package com.shian.shianlifezx.activity.userinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.view.listview.IntegralListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class UserInfoIntegralDetailsActivity extends BaseActivity {
    @InjectView(R.id.listview)
    IntegralListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_integral_details);
        ButterKnife.inject(this);

        setTitle("积分明细");
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {
        listview.startFindData();
    }
}
