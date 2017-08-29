package com.shian.shianlifezx.activity;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.InjectViews;
import okhttp3.Request;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.JSONUtil;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpConsultIdParams;
import com.shian.shianlifezx.provide.result.HrUserInfo;

/**
 * Created by asus on 2016/7/9.
 */
public class UserInfoActivity extends BaseActivity {
    @InjectViews({R.id.tv_username, R.id.tv_phone, R.id.tv_address, R.id.tv_no})
    List<TextView> tvList;
    @InjectViews({R.id.et_email, R.id.et_js})
    List<EditText> etList;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.fragment_userinfo);
        setTitle("个人资料");
        initData();
    }

    private void initData() {
        if (AppContansts.systemLoginInfo == null)
            return;
        SystemLoginResultBean.UserObject userObject = AppContansts.systemLoginInfo.getUserObj();

        tvList.get(0).append(userObject.getName()==null?"":userObject.getName());
        tvList.get(1).append(userObject.getPhone()==null?"":userObject.getPhone());
//        tvList.get(2).append(userInfo.getServiceArea()==null?"":userInfo.getServiceArea());
//        tvList.get(3).append(userInfo.getJobNo()==null?"":userInfo.getJobNo());
        etList.get(0).setText(userObject.getEmail()==null?"":userObject.getEmail());
//        etList.get(1).setText(userInfo.getIntroduce());
//        findViewById(R.id.tv_editorder).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                HpConsultIdParams params = new HpConsultIdParams();
//                params.setAppStatus(getSharedPreferences("settings",-1).getBoolean("rb",true)?1:2);
//                params.setEmail(etList.get(0).getText().toString());
//                params.setIntroduce(etList.get(1).getText().toString());
//                MHttpManagerFactory.getFuneralExecutorManager().changeInfo(UserInfoActivity.this, params, new HttpResponseHandler<Object>() {
//
//
//                    @Override
//                    public void onStart(Request request, int id) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(Object result) {
//                        ToastUtils.show(UserInfoActivity.this, "保存成功");
//                        finish();
//                    }
//
//                    @Override
//                    public void onError(String message) {
//
//                    }
//                });
//            }
//        });

    }
}
