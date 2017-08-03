package com.shian.shianlifezx.provide.imp;

import android.content.Context;

import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;
import com.shian.shianlifezx.provide.base.FileHttpResponseHandler;
import com.shian.shianlifezx.provide.base.HttpManager;
import com.shian.shianlifezx.provide.result.HrUploadFile;

public interface FileManager extends HttpManager {
    public void upLoadFile(Context context, String file, String path, FileHttpResponseHandler<FileUpLoadResultBean> handler);
}
