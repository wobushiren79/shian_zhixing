package com.shian.shianlifezx.mvp.download.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnDownLoadDataListener;
import com.shian.shianlifezx.mvp.download.bean.DownLoadFileBean;
import com.zhy.http.okhttp.request.RequestCall;


/**
 * Created by zm.
 */

public interface IDownLoadFileModel {
    RequestCall startDownLoadFile(Context context, DownLoadFileBean params, OnDownLoadDataListener listener);
}
