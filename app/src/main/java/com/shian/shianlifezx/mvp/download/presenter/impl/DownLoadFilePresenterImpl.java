package com.shian.shianlifezx.mvp.download.presenter.impl;


import com.shian.shianlifezx.mvp.base.OnDownLoadDataListener;
import com.shian.shianlifezx.mvp.download.bean.DownLoadFileBean;
import com.shian.shianlifezx.mvp.download.bean.DownLoadFileResultBean;
import com.shian.shianlifezx.mvp.download.model.IDownLoadFileModel;
import com.shian.shianlifezx.mvp.download.model.impl.DownLoadFileModelImpl;
import com.shian.shianlifezx.mvp.download.presenter.IDownLoadFilePresenter;
import com.shian.shianlifezx.mvp.download.view.IDownLoadFileView;
import com.zhy.http.okhttp.request.RequestCall;

/**
 * Created by zm.
 */

public class DownLoadFilePresenterImpl implements IDownLoadFilePresenter {
    private IDownLoadFileModel downLoadFileModel;
    private IDownLoadFileView downLoadFileView;

    public DownLoadFilePresenterImpl(IDownLoadFileView downLoadFileView) {
        this.downLoadFileView = downLoadFileView;
        downLoadFileModel = new DownLoadFileModelImpl();
    }

    @Override
    public RequestCall startDownLoad() {
        if (downLoadFileView.getContext() == null) {
            downLoadFileView.showToast("没有上下文对象");
            return null;
        }
        if (downLoadFileView.getDownLoadFileUrl() == null) {
            downLoadFileView.showToast("没有文件下载地址");
            return null;
        }
        if (downLoadFileView.getDownLoadFileName() == null) {
            downLoadFileView.showToast("没有文件下载名称");
            return null;
        }
        DownLoadFileBean params = new DownLoadFileBean();
        params.setDownloadUrl(downLoadFileView.getDownLoadFileUrl());
        params.setFileName(downLoadFileView.getDownLoadFileName());
        RequestCall call = downLoadFileModel.startDownLoadFile(downLoadFileView.getContext(), params, new OnDownLoadDataListener<DownLoadFileResultBean>() {
            @Override
            public void downloadInProgress(long total, float progress) {
                downLoadFileView.downloadInProgress(total, progress);
            }


            @Override
            public void getDataSuccess(DownLoadFileResultBean result) {
                downLoadFileView.downloadSuccess(result);
            }


            @Override
            public void getDataFail(String msg) {
                downLoadFileView.downloadFail(msg);
            }
        });
        return call;
    }
}
