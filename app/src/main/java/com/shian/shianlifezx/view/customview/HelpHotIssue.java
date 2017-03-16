package com.shian.shianlifezx.view.customview;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.HotIssueListActivity;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.phpmodel.HotIssueData;
import com.shian.shianlifezx.provide.phpresult.PHPHrGetHotIssue;
import com.shian.shianlifezx.view.ScrollListView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */

public class HelpHotIssue extends LinearLayout {
    View view;

    ScrollListView mListView;
    ImageView mIVMore;
    TextView mTVTitle;

    private int showNumber = 5;//动态通知数量
    private MainDynamic.CallBack callBack;

    List<HotIssueData> listData = new ArrayList<>();

    public HelpHotIssue(Context context) {
        this(context, null);
    }

    public HelpHotIssue(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = View.inflate(context, R.layout.view_maindynamic_layout, this);

        initView();
        getData();
    }

    public void setCallBack(MainDynamic.CallBack callBack) {
        this.callBack = callBack;
    }

    /**
     * 获取数据
     */
    private void getData() {
        RequestParams params = new RequestParams();
        params.put("number ", showNumber);
        params.put("pagerNumber", 0);
        MHttpManagerFactory.getPHPManager().getHotIssue(getContext(), params, new HttpResponseHandler<PHPHrGetHotIssue>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(PHPHrGetHotIssue result) {
                if(result.getItems().size()>0){
                    listData = result.getItems();
                    callBack.loadingComplete();
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    private void initView() {
        mListView = (ScrollListView) view.findViewById(R.id.listView);
        mIVMore = (ImageView) view.findViewById(R.id.iv_more);
        mTVTitle = (TextView) view.findViewById(R.id.tv_title);

        mIVMore.setOnClickListener(onClickListener);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(onItemClickListener);

        mTVTitle.setText("热门问题");
    }


    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    };

    OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mIVMore) {
                Intent intent = new Intent(getContext(), HotIssueListActivity.class);
                getContext().startActivity(intent);
            }
        }
    };

    BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(getContext(), R.layout.view_main_dynamic_layout_items, null);
                holder = new ViewHolder();
                holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
                holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
                holder.tvTop = (TextView) convertView.findViewById(R.id.tv_top);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, HelpHotIssue.this.getResources().getDimensionPixelOffset(R.dimen.dimen_72dp));
            convertView.setLayoutParams(layoutParams);

            HotIssueData data = listData.get(position);
            holder.tvContent.setText(data.getTitle());
            holder.tvTime.setVisibility(GONE);
            if (position == 0) {
                holder.tvTop.setVisibility(VISIBLE);
            } else {
                holder.tvTop.setVisibility(GONE);
            }
            return convertView;
        }

        class ViewHolder {
            TextView tvContent;
            TextView tvTime;
            TextView tvTop;
        }
    };

    public interface CallBack {

        void loadingComplete();

    }
}
