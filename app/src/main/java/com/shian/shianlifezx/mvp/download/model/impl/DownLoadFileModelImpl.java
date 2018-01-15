package com.shian.shianlifezx.mvp.download.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnDownLoadDataListener;
import com.shian.shianlifezx.mvp.download.bean.DownLoadFileBean;
import com.shian.shianlifezx.mvp.download.bean.DownLoadFileResultBean;
import com.shian.shianlifezx.mvp.download.model.IDownLoadFileModel;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.FileHttpResponseHandler;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;

/**
 * Created by zm.
 */

public class DownLoadFileModelImpl implements IDownLoadFileModel {

    @Override
    public RequestCall startDownLoadFile(Context context, DownLoadFileBean params, final OnDownLoadDataListener listener) {
        String downloadUrl = params.getDownloadUrl();
        String fileName = params.getFileName();
        RequestCall call = MHttpManagerFactory.getFileManager().downloadFile(context, downloadUrl, fileName, new FileHttpResponseHandler<File>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(File file) {
                DownLoadFileResultBean resultBean = new DownLoadFileResultBean();
                resultBean.setDownloadFile(file);
                listener.getDataSuccess(resultBean);
            }

            @Override
            public void onError(String message) {
                listener.getDataFail(message);
            }

            @Override
            public void onProgress(long total, float progress) {
                listener.downloadInProgress(total, progress);
            }
        });
        return call;
    }

}
