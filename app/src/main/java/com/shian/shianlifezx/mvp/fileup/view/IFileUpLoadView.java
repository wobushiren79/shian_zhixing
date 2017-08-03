package com.shian.shianlifezx.mvp.fileup.view;

import android.content.Context;

import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;


/**
 * Created by zm.
 */

public interface IFileUpLoadView {
    /**
     * 获取上下文对象
     *
     * @return
     */
    Context getContext();

    /**
     * 获取文件类型
     *
     * @return
     */
    String getFileClass();

    /**
     * 获取文件名称
     *
     * @return
     */
    String getFileName();

    /**
     * 获取文件路径
     *
     * @return
     */
    String getFilePath();

    /**
     * 文件上传成功
     *
     * @param result
     */
    void fileUpLoadSuccess(FileUpLoadResultBean result);


    /**
     * 文件上传失败
     *
     * @param msg
     */
    void fileUpLoadFail(String msg);

    /**
     * 文件加载进度
     *
     * @param total
     * @param progress
     */
    void fileUpLoadProgress(long total, float progress);
}
