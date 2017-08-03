package com.shian.shianlifezx.mvp.fileup.model;

import android.content.Context;

import com.shian.shianlifezx.mvp.base.OnGetDataListener;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadBean;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;
import com.shian.shianlifezx.mvp.fileup.presenter.OnFileUpLoadProgressListener;


/**
 * Created by zm.
 */

public interface IFileUpLoadModel {
    /**
     * 文件上传
     *
     * @param context
     * @param params
     * @param listener
     */
    void fileUpLoad(Context context, FileUpLoadBean params, OnGetDataListener<FileUpLoadResultBean> listener, OnFileUpLoadProgressListener progressListener);
}
