package com.shian.shianlifezx.provide.imp.impl;

import java.io.File;

import org.codehaus.jackson.JsonNode;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.ObjectMapperFactory;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;
import com.shian.shianlifezx.provide.base.FileHttpResponseHandler;
import com.shian.shianlifezx.provide.imp.FileManager;
import com.shian.shianlifezx.provide.result.HrUploadFile;

import static android.content.Context.MODE_PRIVATE;

public class FileManagerImpl implements FileManager {
    private static FileManager manager;

    private FileManagerImpl() {
    }

    public static FileManager getInstance() {
        if (manager == null) {
            manager = new FileManagerImpl();
        }
        return manager;
    }

    @Override
    public void upLoadFile(final Context context, String file, String path,
                           final FileHttpResponseHandler<FileUpLoadResultBean> response) {
        RequestParams params = new RequestParams();
        SharedPreferences share = context.getSharedPreferences("SessionShare", MODE_PRIVATE);
        String sesseion = share.getString("SessionKey", "");
        params.addHeader("Cookie", "sid=" + sesseion);
        params.addHeader("systemType", "2");
        params.addBodyParameter(file, new File(path));
        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.POST, AppContansts.ExecutorURL
                + "/file/upload", params, new RequestCallBack<String>() {

            @Override
            public void onStart() {
            }

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                if (response != null) {
                    response.onProgress(total, current, isUploading);
                }
            }

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String contentString = responseInfo.result;
                Log.e("tag", contentString);
                if (response != null) {
                    try {
                        JsonNode node = ObjectMapperFactory.getInstance()
                                .readTree(contentString);
                        String error = node.findValue("code").toString();
                        String errorMsg = node.findValue("message").toString();
                        String validErrors = node.findValue("validErrors")
                                .toString();
                        if ("1000".equals(error)) {
                            JsonNode jn = node.findValue("content");
                            if (jn == null)
                                response.onSuccess(null);
                            else {
                                FileUpLoadResultBean result = ObjectMapperFactory
                                        .getInstance().readValue(jn,
                                                FileUpLoadResultBean.class);
                                response.onSuccess(result);
                            }
                        } else {
                            response.onError(errorMsg + "\n" + validErrors);
                        }
                    } catch (Exception e) {
                        response.onError("数据异常");
                    }
                }
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                Log.e("tag", msg);
                if (response != null) {
                    response.onError(msg);
                }
            }
        });
    }

}
