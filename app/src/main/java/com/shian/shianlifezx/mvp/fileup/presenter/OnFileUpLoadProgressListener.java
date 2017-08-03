package com.shian.shianlifezx.mvp.fileup.presenter;

/**
 * Created by zm.
 */

public interface OnFileUpLoadProgressListener {
    /**
     * 加载中
     * @param total
     * @param progress
     */
    void onProgress(long total, float progress);
}
