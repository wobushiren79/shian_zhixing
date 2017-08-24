package com.shian.shianlifezx.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Request;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.SharePerfrenceUtils;
import com.shian.shianlifezx.common.utils.SharePerfrenceUtils.ShareLogin;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.mvp.login.presenter.IUserLoginPresenter;
import com.shian.shianlifezx.mvp.login.presenter.impl.UserLoginPresenterImpl;
import com.shian.shianlifezx.mvp.login.view.IUserLoginView;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpRequestExecutor;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpLoginParams;
import com.shian.shianlifezx.provide.result.HrLoginResult;
import com.shian.shianlifezx.view.customview.LoadingButton;

public class LoginActivity extends BaseActivity implements IUserLoginView {
    @InjectView(R.id.et_login_username)
    EditText etUserName;
    @InjectView(R.id.et_login_password)
    EditText etUserPassword;
    @InjectView(R.id.cb_login_re)
    CheckBox cbRe;
    @InjectView(R.id.cb_login_auto)
    CheckBox cbAuto;
    @InjectView(R.id.btn_login)
    LoadingButton lbLogin;
    @InjectView(R.id.rl_content)
    RelativeLayout rlContent;

    private IUserLoginPresenter userLoginPresenter;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_login);
        initView();
        initData();
        startAnim();
    }


    /**
     * 动画
     */
    private void startAnim() {
        TranslateAnimation translateAnimation = new TranslateAnimation
                (Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f);
        translateAnimation.setDuration(1000);
        rlContent.setAnimation(translateAnimation);
        translateAnimation.start();
    }

    private void initView() {
        ShareLogin loginS = SharePerfrenceUtils.getLoginShare(this);
        etUserName.setText(loginS.getUsername());
        if (loginS.isRemeberPassword()) {
            cbRe.setChecked(true);
            etUserPassword.setText(loginS.getPassword());
        }

        if (loginS.isAutoLogin()) {
            cbAuto.setChecked(true);
            login(loginS.getUsername(), loginS.getPassword());
        }
    }

    private void initData() {
        userLoginPresenter = new UserLoginPresenterImpl(this, null);
    }

    @OnClick(R.id.btn_login)
    void loginClick(View v) {
        String username = etUserName.getText().toString();
        String password = etUserPassword.getText().toString();
        if (username.isEmpty() || password.isEmpty()) {
            ToastUtils.show(this, "账号或密码不能为空");
            return;
        }
        userLoginPresenter.loginSystem();
    }

    private void login(final String username, final String password) {
        if (TextUtils.isEmpty(SharePerfrenceUtils.getShareChannelId(this))) {
            ToastUtils.show(this, "消息推送正在初始化，请稍后。。。");
            return;
        }
        lbLogin.setLoading();
        HpLoginParams params = new HpLoginParams();
        params.setPassword(password);
        params.setUsername(username);
        params.setSystemType("3");
        params.setChannelId(SharePerfrenceUtils.getShareChannelId(this));
        MHttpManagerFactory.getFuneralExecutorManager().login(this, params, new HttpResponseHandler<HrLoginResult>() {

            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(HrLoginResult result) {
                AppContansts.userLoginInfo = result;
                lbLogin.setComplete();

                SharePerfrenceUtils.setLoginShare(LoginActivity.this, username, password, cbRe.isChecked(),
                        cbAuto.isChecked());
                ToastUtils.show(getBaseContext(), "登陆成功");
                Intent in = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(in);
                finish();
            }

            @Override
            public void onError(String message) {
                lbLogin.setNormal();
            }
        });

    }


    @OnClick(R.id.btn_login_web)
    void loginWeb(View v) {
//		Intent in=new Intent(this,WebActivity.class);
//		in.putExtra("url","http://m.e-funeral.cn");
//		startActivity(in);
        Intent in = new Intent(this, LoginPhoneActivity.class);
        startActivity(in);
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public String getPassWord() {
        return etUserPassword.getText().toString();
    }

    @Override
    public void setPassWord(String passWord) {

    }

    @Override
    public boolean getIsAutoLogin() {
        return false;
    }

    @Override
    public void setIsAutoLogin(boolean isAutoLogin) {

    }

    @Override
    public boolean getIsKeepAccount() {
        return false;
    }

    @Override
    public void setIsKeepAccount(boolean isKeepAccount) {

    }

    @Override
    public void setLoginConfig() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loginSystemSuccess(SystemLoginResultBean result) {
        login(etUserName.getText().toString(), etUserPassword.getText().toString());
    }

    @Override
    public void loginSystemFail(String message) {
        ToastUtils.show(this, message);
    }
}
