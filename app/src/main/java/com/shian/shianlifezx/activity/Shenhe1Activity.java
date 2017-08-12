package com.shian.shianlifezx.activity;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.utils.JSONUtil;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.view.TipsDialog;
import com.shian.shianlifezx.mvp.fileup.bean.FileUpLoadResultBean;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.FileHttpResponseHandler;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpSaveCustomerContract;
import com.shian.shianlifezx.provide.params.HpSubmit4AuditParams;
import com.shian.shianlifezx.provide.params.HpSubmit4AuditParams.AddAddition;
import com.shian.shianlifezx.provide.result.HrUploadFile;
import com.shian.shianlifezx.provide.result.WaitItem;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Request;

public class Shenhe1Activity extends BaseActivity {
    private WaitItem mData;
    @InjectView(R.id.et_shenhe_w)
    EditText etShenhe;

    @Override
    protected void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        setContentView(R.layout.activity_shenhe1);
        setTitle("申请审核");
        mData = JSONUtil.parseJSONString(getIntent().getStringExtra("data"), WaitItem.class);
    }

    @OnClick({R.id.btn_ht_pic_0, R.id.btn_ht_pic_1, R.id.btn_ht_pic_2, R.id.btn_ht_pic_3})
    void btnPicClick(final ImageView v) {
        showPhotoPicker();
        setOnPhotoPickerListener(new OnPhotoPickerListener() {

            @Override
            public void onPhoto(ArrayList<String> paths) {
                // TODO Auto-generated method stub
                String path = paths.get(0);
                String compress = compressImage(path);
                String newPath = compress == null ? path : compress;
                uploadFile(v, v.getTag().toString(), newPath);
                ImageLoader.getInstance().displayImage("file://" + newPath, v);
            }
        });

    }

    private String compressImage(String path) {
        Bitmap image = BitmapFactory.decodeFile(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中  
        int options = 100;
        while (options > 10 && baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos  
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中  
            options -= 10;//每次都减少10  
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中  
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片 
        String newPath = null;
        try {
            newPath = saveFile(bitmap, UUID.randomUUID() + ".png");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newPath;
    }

    /**
     * 保存文件
     *
     * @param bm
     * @param fileName
     * @throws IOException
     */
    public String saveFile(Bitmap bm, String fileName) throws IOException {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/shian/temp/";
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        File myCaptureFile = new File(path + fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
        return myCaptureFile.getAbsolutePath();
    }


    private void uploadFile(final ImageView ib, final String file, String path) {
        final ProgressBar pbVIew = (ProgressBar) ((ViewGroup) ib.getParent()).getChildAt(1);
        MHttpManagerFactory.getFileManager().upLoadFile(this, file, file, path, new FileHttpResponseHandler<FileUpLoadResultBean>() {

            @Override
            public void onSuccess(FileUpLoadResultBean t) {
                ToastUtils.show(getBaseContext(), "上传成功");
                AddAddition add = new HpSubmit4AuditParams.AddAddition();
                add.setFileName(file);
                add.setFileUrl(t.getNameMap().get(file).toString());
                addList.add(add);
                pbVIew.setVisibility(View.GONE);
            }

            @Override
            public void onStart() {

            }


            @Override
            public void onError(String message) {

            }

            @Override
            public void onProgress(long total, float progress) {
                pbVIew.setVisibility(View.VISIBLE);
                pbVIew.setProgress((int) progress);
            }
        });
    }

    HpSaveCustomerContract params = new HpSaveCustomerContract();
    List<AddAddition> addList = new ArrayList<AddAddition>();

    @OnClick(R.id.tv_editorder)
    void passClick(View v) {
        TipsDialog dialog = new TipsDialog(this);
        dialog.setTitle("请确认您已按标准完成服务，未按标准将重新服务");
        dialog.setTopButton("继续服务", null);
        dialog.setBottomButton("完成服务", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                HpSubmit4AuditParams localHpSubmit4AuditParams = new HpSubmit4AuditParams();
                localHpSubmit4AuditParams.setAddAdditions(addList);
                localHpSubmit4AuditParams.setExecutorNote(etShenhe.getText().toString());
                localHpSubmit4AuditParams.setOrderItemId(mData.getOrderItemId());
                MHttpManagerFactory.getFuneralExecutorManager().submit4Audit(Shenhe1Activity.this, localHpSubmit4AuditParams,
                        new HttpResponseHandler<String>() {

                            @Override
                            public void onStart(Request request, int id) {

                            }

                            @Override
                            public void onSuccess(String result) {
                                // TODO Auto-generated method stub
                                ToastUtils.show(Shenhe1Activity.this, "操作成功");
                                finish();

                            }


                            @Override
                            public void onError(String message) {
                                // TODO Auto-generated method stub

                            }
                        });
            }
        });
        dialog.show();

    }
}
