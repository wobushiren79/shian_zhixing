package com.shian.shianlifezx.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.MyCollectionActivity;
import com.shian.shianlifezx.adapter.FindAdapter;
import com.shian.shianlifezx.base.BaseFragment;

/**
 * Created by Administrator on 2017/3/5.
 */

public class FindFragment extends BaseFragment {
    View view;
    ImageView mIVCollection;
    PullToRefreshListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_find, null, false);
        initView();
        return view;
    }

    private void initView() {

        mListView = (PullToRefreshListView) view.findViewById(R.id.pull_listview);
        mIVCollection = (ImageView) view.findViewById(R.id.iv_collection);

        mListView.setAdapter(new FindAdapter(getContext()));
        mIVCollection.setOnClickListener(onClickListener);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mIVCollection) {
                Intent intent = new Intent(getContext(), MyCollectionActivity.class);
                startActivity(intent);
            }
        }
    };
}
