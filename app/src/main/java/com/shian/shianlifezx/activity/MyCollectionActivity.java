package com.shian.shianlifezx.activity;

import android.os.Bundle;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.adapter.FindAdapter;
import com.shian.shianlifezx.base.BaseActivity;


public class MyCollectionActivity extends BaseActivity {

    PullToRefreshListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);

        setTitle("我的收藏");
        initView();
    }

    private void initView() {
        mListView = (PullToRefreshListView) findViewById(R.id.pull_listview);

        mListView.setAdapter(new FindAdapter(MyCollectionActivity.this));
    }
}
