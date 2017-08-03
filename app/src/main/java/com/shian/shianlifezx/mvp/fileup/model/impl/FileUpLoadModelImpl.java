package com.shian.shianlifezx.mvp.fileup.model.impl;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadBean;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;
import com.shian.shianlifezx.mvp.fileup.model.IFileUpLoadModel;
import com.shian.shianlifezx.mvp.fileup.presenter.OnFileUpLoadProgressListener;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.FileHttpResponseHandler;


/**
 * Created by zm.
 */

public class FileUpLoadModelImpl implements IFileUpLoadModel {

    @Override
    public void fileUpLoad(Context context, FileUpLoadBean params, final OnGetDataListener listener, final OnFileUpLoadProgressListener progressListener) {
        MHttpManagerFactory.getFileManager().upLoadFile(context, params.getFileName(), params.getFilePath(), new FileHttpResponseHandler<FileUpLoadResultBean>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(FileUpLoadResultBean hrUploadFile) {
                        listener.getDataSuccess(hrUploadFile);
                    }

                    @Override
                    public void onError(String message) {
                        listener.getDataFail(message);
                    }

                    @Override
                    public void onProgress(long total, long current, boolean isUploading) {
                        progressListener.onProgress(total, current);
                    }
                }
        );
    }
}
