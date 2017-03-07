package com.shian.shianlifezx.activity;

import android.os.Bundle;
import android.widget.Button;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;


public class UserInfoMoneyActivity extends BaseActivity {

    Button mBTWithdrawal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_money);
        setTitle("钱包");
        initView();
    }

    private void initView() {
        mBTWithdrawal= (Button) findViewById(R.id.bt_withdrawal);
    }
}
