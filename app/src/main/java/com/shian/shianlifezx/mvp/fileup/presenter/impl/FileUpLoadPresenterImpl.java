package com.shian.shianlifezx.mvp.fileup.presenter.impl;


import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadBean;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;
import com.shian.shianlifezx.mvp.fileup.model.IFileUpLoadModel;
import com.shian.shianlifezx.mvp.fileup.model.impl.FileUpLoadModelImpl;
import com.shian.shianlifezx.mvp.fileup.presenter.IFileUpLoadPresenter;
import com.shian.shianlifezx.mvp.fileup.presenter.OnFileUpLoadProgressListener;
import com.shian.shianlifezx.mvp.fileup.view.IFileUpLoadView;

/**
 * Created by zm.
 */

public class FileUpLoadPresenterImpl implements IFileUpLoadPresenter {
    IFileUpLoadView fileUpLoadView;
    IFileUpLoadModel fileUpLoadModel;

    public FileUpLoadPresenterImpl(IFileUpLoadView fileUpLoadView) {
        this.fileUpLoadView = fileUpLoadView;
        fileUpLoadModel = new FileUpLoadModelImpl();
    }

    @Override
    public void fileUpLoad() {
        FileUpLoadBean params = new FileUpLoadBean();
        params.setFileClass(fileUpLoadView.getFileClass());
        params.setFileName(fileUpLoadView.getFileName());
        params.setFilePath(fileUpLoadView.getFilePath());
        fileUpLoadModel.fileUpLoad(fileUpLoadView.getContext(), params, new OnGetDataListener<FileUpLoadResultBean>() {
            @Override
            public void getDataSuccess(FileUpLoadResultBean result) {
                fileUpLoadView.fileUpLoadSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                fileUpLoadView.fileUpLoadFail(msg);
            }
        }, new OnFileUpLoadProgressListener() {
            @Override
            public void onProgress(long total, float progress) {
                fileUpLoadView.fileUpLoadProgress(total, progress);
            }
        });
    }
}
