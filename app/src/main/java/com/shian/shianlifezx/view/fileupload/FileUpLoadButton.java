package com.shian.shianlifezx.view.fileupload;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.ImagePreviewActivity;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.base.BaseLayout;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.contanst.IntentAction;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.utils.Utils;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadBean;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;
import com.shian.shianlifezx.mvp.fileup.presenter.IFileUpLoadPresenter;
import com.shian.shianlifezx.mvp.fileup.presenter.impl.FileUpLoadPresenterImpl;
import com.shian.shianlifezx.mvp.fileup.view.IFileUpLoadView;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by zm.
 */

public class FileUpLoadButton extends BaseLayout implements IFileUpLoadView {

    @InjectView(R.id.iv_add)
    ImageView ivAdd;
    @InjectView(R.id.pb_loading)
    ProgressBar pbLoading;

    private CallBack callBack;
    private IFileUpLoadPresenter fileUpLoadPresenter;
    private FileUpLoadBean mFileData;
    private boolean isLoading = false;

    public FileUpLoadButton(Context context, String fileClass, String fileName) {
        super(context, R.layout.view_fileupload_button_normal);
        mFileData = new FileUpLoadBean();
        mFileData.setFileClass(fileClass);
        mFileData.setFileName(fileName);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        fileUpLoadPresenter = new FileUpLoadPresenterImpl(this);
    }


    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public String getFileClass() {
        return mFileData.getFileClass();
    }

    @Override
    public String getFileName() {
        return mFileData.getFilePath();
    }

    @Override
    public String getFilePath() {
        return mFileData.getFilePath();
    }

    public String getFileUrl() {
        return mFileData.getFileUrl();
    }

    @Override
    public void fileUpLoadSuccess(FileUpLoadResultBean result) {
        isLoading = false;
        pbLoading.setVisibility(GONE);
        mFileData.setFileUrl((String) result.getNameMap().get(mFileData.getFileClass()));
        if (callBack != null)
            callBack.fileUpLoadSuccess(this);
    }

    @Override
    public void fileUpLoadFail(String msg) {
        isLoading = false;
        pbLoading.setVisibility(GONE);
        mFileData.setFilePath(null);
        ivAdd.setImageResource(R.drawable.zhy_fileupload_button_normal);
        ToastUtils.show(getContext(), msg);
        if (callBack != null)
            callBack.fileUpLoadFail(this);
    }

    @Override
    public void fileUpLoadProgress(long total, float progress) {

    }

    @OnClick(R.id.iv_add)
    public void onViewClicked() {
        if (!isLoading) {
            if (mFileData.getFilePath() != null && !mFileData.getFilePath().isEmpty()) {
                checkDetails();
            } else {
                getAndUpPhoto();
            }
        }
    }


    @OnLongClick(R.id.iv_add)
    public boolean onViewLongClicked() {
        if (!isLoading) {
            if (mFileData.getFilePath() != null && !mFileData.getFilePath().isEmpty()) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setItems(new String[]{getContext().getString(R.string.fileupload_change), getContext().getString(R.string.fileupload_delete)}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        if (which == 0) {
                            getAndUpPhoto();
                        } else {
                            deleteData();
                        }
                    }
                });
                dialog.show();
            }
        }
        return true;
    }

    /**
     * 删除
     */
    private void deleteData() {
        mFileData.setFilePath(null);
        ivAdd.setImageResource(R.drawable.zhy_fileupload_button_normal);
        if (callBack != null)
            callBack.fileDelete(FileUpLoadButton.this);
    }

    /**
     * 查看圖片詳情
     */
    private void checkDetails() {
        Intent intent = new Intent(getContext(), ImagePreviewActivity.class);
        intent.putExtra(IntentAction.INTENT_URL, AppContansts.OSSURL + mFileData.getFileUrl());
        getContext().startActivity(intent);
    }

    /**
     * 獲取並且上傳照片
     */
    private void getAndUpPhoto() {
        Utils.scanForActivity(getContext()).getPhoto(getContext());
        Utils.scanForActivity(getContext()).setOnPhotoPickerListener(new BaseActivity.OnPhotoPickerListener() {
            @Override
            public void onPhoto(ArrayList<String> paths) {
                pbLoading.setVisibility(VISIBLE);
                mFileData.setFilePath(paths.get(0));
                Utils.loadPic(getContext(), ivAdd, "file://" + mFileData.getFilePath());
                isLoading = true;
                fileUpLoadPresenter.fileUpLoad();
            }
        });
    }

    public interface CallBack {
        void fileUpLoadSuccess(View view);

        void fileUpLoadFail(View view);

        void fileDelete(View view);
    }
}
