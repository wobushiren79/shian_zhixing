package com.shian.shianlifezx.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.MyCollectionActivity;
import com.shian.shianlifezx.adapter.FindAdapter;
import com.shian.shianlifezx.base.BaseFragment;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.phpmodel.SiftListData;
import com.shian.shianlifezx.provide.phpparams.PHPHpSiftListParams;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetSiftListData;
import com.shian.shianlifezx.thisenum.SystemTypeEnum;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * Created by Administrator on 2017/3/5.
 */

public class FindFragment extends BaseFragment {
    View view;
    ImageView mIVCollection;
    PullToRefreshListView mListView;

    int number = 10;
    int pagerNumber = 0;

    FindAdapter findAdapter;
    List<SiftListData> listDatas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_find, null, false);
        listDatas.clear();
        initView();
        return view;
    }

    private void initView() {

        mListView = (PullToRefreshListView) view.findViewById(R.id.pull_listview);
        mIVCollection = (ImageView) view.findViewById(R.id.iv_collection);

        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mListView.setOnRefreshListener(onRefreshListener2);
        findAdapter = new FindAdapter(getContext(), listDatas);
        mListView.setAdapter(findAdapter);
        mIVCollection.setOnClickListener(onClickListener);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        // 开始就呈现下拉状态
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mListView.setRefreshing(true);
                pagerNumber = 0;
                getData(true);
            }
        }, 500);
    }

    PullToRefreshBase.OnRefreshListener2 onRefreshListener2 = new PullToRefreshBase.OnRefreshListener2() {
        @Override
        public void onPullDownToRefresh(PullToRefreshBase refreshView) {
            pagerNumber = 0;
            getData(true);
        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase refreshView) {
            pagerNumber++;
            getData(false);
        }
    };
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mIVCollection) {
                Intent intent = new Intent(getContext(), MyCollectionActivity.class);
                startActivity(intent);
            }
        }
    };

    private void getData(final boolean isClean) {
        PHPHpSiftListParams params = new PHPHpSiftListParams();
        params.setType(1);
        params.setUserid(AppContansts.systemLoginInfo.getUserId());
        params.setNumber(number);
        params.setPagerNumber(pagerNumber);
        params.setUserType(SystemTypeEnum.funeral.getCode());

        MHttpManagerFactory.getPHPManager().getSiftListData(getContext(), params, new HttpResponseHandler<PHPHrGetSiftListData>() {


            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(PHPHrGetSiftListData result) {
                if (isClean) {
                    listDatas.clear();
                }
                listDatas.addAll(result.getItems());
                findAdapter.setData(listDatas);
                mListView.onRefreshComplete();
            }

            @Override
            public void onError(String message) {
                mListView.onRefreshComplete();
            }
        });
    }
}
