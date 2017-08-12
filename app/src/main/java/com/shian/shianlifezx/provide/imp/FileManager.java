package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;
import com.shian.shianlifezx.provide.base.FileHttpResponseHandler;
import com.shian.shianlifezx.provide.base.HttpManager;
import com.shian.shianlifezx.provide.result.HrUploadFile;

public interface FileManager extends HttpManager {

    /**
     * 文件上传
     *
     * @param context
     * @param fileClass 文件分类
     * @param fileName  文件名字
     * @param path      文件路径
     * @param handler
     */
    public void upLoadFile(Context context, String fileClass, String fileName, String path, FileHttpResponseHandler<FileUpLoadResultBean> handler);

}
