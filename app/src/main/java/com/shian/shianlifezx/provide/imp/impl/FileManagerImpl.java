package com.shian.shianlifezx.provide.imp.impl;

import java.io.File;

import org.codehaus.jackson.JsonNode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.shian.shianlifezx.activity.LoginActivity;
import com.shian.shianlifezx.base.SaBaseApplication;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.ObjectMapperFactory;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;
import com.shian.shianlifezx.provide.base.FileHttpResponseHandler;
import com.shian.shianlifezx.provide.imp.FileManager;
import com.shian.shianlifezx.provide.result.HrUploadFile;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;

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
    public void upLoadFile(final Context context,
                           String fileClass,
                           String fileName,
                           String path,
                           final FileHttpResponseHandler<FileUpLoadResultBean> responseHandler) {
        File file = new File(path);
        OkHttpUtils
                .post()
                .addFile(fileClass, fileName, file)
                .addHeader("client-Type", "androidapp")
                .addHeader("systemType", "2")
                .url(AppContansts.FILE_ALIYUN_UPDATA)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                        if (responseHandler != null) {
                            responseHandler.onStart();
                        }
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress(progress, total, id);
                        if (responseHandler != null) {
                            responseHandler.onProgress(total, progress);
                        }
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.v("tag", response);
                        dataToJson(context, response, FileUpLoadResultBean.class, responseHandler);
                    }


                    @Override
                    public void onError(Call call, Exception e, int id) {
                        String errorMessage = e.getMessage();
                        Log.e("tag", errorMessage + "");
                        if (responseHandler != null) {
                            responseHandler.onError(errorMessage);
                        }
                    }
                });
    }

    /**
     * 数据处理
     *
     * @param context
     * @param response
     * @param data
     * @param responseHandler
     * @param <T>
     */
    private <T> void dataToJson(Context context, String response, final Class<T> data, FileHttpResponseHandler<T> responseHandler) {
        if (response != null) {
            try {
                JsonNode node = ObjectMapperFactory.getInstance().readTree(new String(response));
                String code = node.findValue("code").toString();
                String errorMsg = node.findValue("message").toString();
                if ("1000".equals(code)) {
                    JsonNode jn = node.findValue("content");
                    if (jn == null)
                        responseHandler.onSuccess(null);
                    else {
                        T result = ObjectMapperFactory.getInstance().readValue(
                                jn, data);
                        responseHandler.onSuccess(result);
                    }
                } else if ("1009".equals(code)||"9999".equals(code)) {
                    jumpLogin(context);
                } else {
                    onErrorCallBack(responseHandler, errorMsg, context);
                }
            } catch (Exception e) {
                onErrorCallBack(responseHandler, "", context);
            }
        }
    }

    private void jumpLogin(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 异常回调
     *
     * @param response
     * @param error
     * @param context
     */
    private <T> void onErrorCallBack(FileHttpResponseHandler<T> response, String error,
                                     Context context) {
        if (response != null && error != null) {
            response.onError(error);
        }
    }
}
