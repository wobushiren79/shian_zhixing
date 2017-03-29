package com.shian.shianlifezx.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.utils.Utils;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.phpmodel.SiftListData;

/**
 * Created by asus on 2016/7/30.
 */
public class WebActivity extends BaseActivity {
    TextView mTVBack;
    ImageView mIVCancel;
    ImageView mIVCollection;
    ImageView mIVShare;

    WebView mWebView;
    ProgressBar mPB;
    String dir;

    SiftListData data;
    boolean isShare;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_web);
        initView();
        openShare();
        dir = this.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setGeolocationDatabasePath(dir);
        webSettings.setDomStorageEnabled(true);//允许DCOM

        mWebView.loadUrl(getIntent().getStringExtra("url"));
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mPB.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == mPB.getVisibility()) {
                        mPB.setVisibility(View.VISIBLE);
                    }
                    mPB.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });
    }

    private void openShare() {
        isShare = getIntent().getBooleanExtra("isShare", false);
        if (isShare) {
            mIVCollection.setVisibility(View.VISIBLE);
            mIVShare.setVisibility(View.VISIBLE);
            data = (SiftListData) getIntent().getSerializableExtra("shareData");
            if (data.getIsCollection() == 0) {
                mIVCollection.setImageResource(R.drawable.zhy_find_collection_details_1);
            } else {
                mIVCollection.setImageResource(R.drawable.zhy_find_collection_details_2);
            }
        } else {
            mIVCollection.setVisibility(View.GONE);
            mIVShare.setVisibility(View.GONE);
        }
    }

    private void initView() {
        mPB = (ProgressBar) findViewById(R.id.myProgressBar);
        mWebView = (WebView) findViewById(R.id.web);
        mTVBack = (TextView) findViewById(R.id.tv_back);
        mIVCancel = (ImageView) findViewById(R.id.iv_cancel);

        mTVBack.setOnClickListener(onClickListener);
        mIVCancel.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mTVBack && mWebView.canGoBack()) {
                mWebView.goBack();
            } else if (v == mIVCancel) {
                finish();
            } else if (v == mIVShare) {
                share();
            } else if (v == mIVCollection) {
                setData(2,data.getId());
            }
        }
    };

    private void share() {
        // intent.setType("text/plain"); //纯文本
            /*
             * 图片分享 it.setType("image/png"); 　//添加图片 File f = new
             * File(Environment.getExternalStorageDirectory()+"/name.png");
             *
             * Uri uri = Uri.fromFile(f); intent.putExtra(Intent.EXTRA_STREAM,
             * uri); 　
             */
        if (data == null) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
        intent.putExtra(Intent.EXTRA_TEXT, data.getTitle()+"\n"+ AppContansts.siftsPHPURL+"?id="+data.getId());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    /**
     * @param type （1.为点赞   2.为收藏）
     */
    private void setData(int type, int siftID) {
        mIVCollection.setImageResource(R.drawable.zhy_find_collection_details_2);
        mIVCollection.setClickable(false);
        ToastUtils.show(WebActivity.this,"收藏成功");
        RequestParams params = new RequestParams();
        params.put("type", type);
        params.put("userid", AppContansts.userLoginInfo.getUserId());
        params.put("siftid", siftID);
        MHttpManagerFactory.getPHPManager().setSiftData(WebActivity.this, params, new HttpResponseHandler<Object>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(Object result) {

            }

            @Override
            public void onError(String message) {

            }
        });
    }
}
